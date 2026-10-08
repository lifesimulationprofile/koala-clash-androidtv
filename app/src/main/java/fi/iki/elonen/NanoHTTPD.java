package fi.iki.elonen;

import androidx.camera.camera2.internal.Camera2CameraImpl;
import androidx.camera.core.Preview$$ExternalSyntheticLambda0;
import androidx.camera.core.impl.utils.executor.SequentialExecutor;
import androidx.compose.ui.unit.Density;
import androidx.core.app.TaskStackBuilder;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.SSLException;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.http1.HeadersReader;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class NanoHTTPD {
    public HeadersReader asyncRunner;
    public volatile ServerSocket myServerSocket;
    public Thread myThread;
    public static final Pattern CONTENT_DISPOSITION_PATTERN = Pattern.compile("([ |\t]*Content-Disposition[ |\t]*:)(.*)", 2);
    public static final Pattern CONTENT_TYPE_PATTERN = Pattern.compile("([ |\t]*content-type[ |\t]*:)(.*)", 2);
    public static final Pattern CONTENT_DISPOSITION_ATTRIBUTE_PATTERN = Pattern.compile("[ |\t]*([a-zA-Z]*)[ |\t]*=[ |\t]*['|\"]([^\"^']*)['|\"]");
    public static final Logger LOG = Logger.getLogger(NanoHTTPD.class.getName());

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class ClientHandler implements Runnable {
        public final Socket acceptSocket;
        public final InputStream inputStream;

        public ClientHandler(InputStream inputStream, Socket socket) {
            this.inputStream = inputStream;
            this.acceptSocket = socket;
        }

        @Override // java.lang.Runnable
        public final void run() throws Throwable {
            InputStream inputStream = this.inputStream;
            NanoHTTPD nanoHTTPD = NanoHTTPD.this;
            Socket socket = this.acceptSocket;
            OutputStream outputStream = null;
            try {
                try {
                    OutputStream outputStream2 = socket.getOutputStream();
                    try {
                        HTTPSession hTTPSession = nanoHTTPD.new HTTPSession(new CacheStrategy(18), this.inputStream, outputStream2, socket.getInetAddress());
                        while (!socket.isClosed()) {
                            hTTPSession.execute();
                        }
                        NanoHTTPD.safeClose(outputStream2);
                    } catch (Exception e) {
                        e = e;
                        outputStream = outputStream2;
                        if ((!(e instanceof SocketException) || !"NanoHttpd Shutdown".equals(e.getMessage())) && !(e instanceof SocketTimeoutException)) {
                            NanoHTTPD.LOG.log(Level.SEVERE, "Communication with the client broken, or an bug in the handler code", (Throwable) e);
                        }
                        NanoHTTPD.safeClose(outputStream);
                    } catch (Throwable th) {
                        th = th;
                        outputStream = outputStream2;
                        NanoHTTPD.safeClose(outputStream);
                        NanoHTTPD.safeClose(inputStream);
                        NanoHTTPD.safeClose(socket);
                        ((List) nanoHTTPD.asyncRunner.source).remove(this);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e2) {
                e = e2;
            }
            NanoHTTPD.safeClose(inputStream);
            NanoHTTPD.safeClose(socket);
            ((List) nanoHTTPD.asyncRunner.source).remove(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class ContentType {
        public final String boundary;
        public final String contentType;
        public final String contentTypeHeader;
        public final String encoding;
        public static final Pattern MIME_PATTERN = Pattern.compile("[ |\t]*([^/^ ^;^,]+/[^ ^;^,]+)", 2);
        public static final Pattern CHARSET_PATTERN = Pattern.compile("[ |\t]*(charset)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;^,]*)['|\"]?", 2);
        public static final Pattern BOUNDARY_PATTERN = Pattern.compile("[ |\t]*(boundary)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;^,]*)['|\"]?", 2);

        public ContentType(String str) {
            this.contentTypeHeader = str;
            if (str != null) {
                Matcher matcher = MIME_PATTERN.matcher(str);
                this.contentType = matcher.find() ? matcher.group(1) : "";
                Matcher matcher2 = CHARSET_PATTERN.matcher(str);
                this.encoding = matcher2.find() ? matcher2.group(2) : null;
            } else {
                this.contentType = "";
                this.encoding = "UTF-8";
            }
            if (!"multipart/form-data".equalsIgnoreCase(this.contentType)) {
                this.boundary = null;
            } else {
                Matcher matcher3 = BOUNDARY_PATTERN.matcher(str);
                this.boundary = matcher3.find() ? matcher3.group(2) : null;
            }
        }

        public final String getEncoding() {
            String str = this.encoding;
            return str == null ? "US-ASCII" : str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class DefaultTempFile {
        public final File file;
        public final FileOutputStream fstream;

        public DefaultTempFile(File file) throws IOException {
            File fileCreateTempFile = File.createTempFile("NanoHTTPD-", "", file);
            this.file = fileCreateTempFile;
            this.fstream = new FileOutputStream(fileCreateTempFile);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class HTTPSession {
        public TaskStackBuilder cookies;
        public HashMap headers;
        public final BufferedInputStream inputStream;
        public int method;
        public final OutputStream outputStream;
        public HashMap parms;
        public String protocolVersion;
        public final String remoteIp;
        public int rlen;
        public int splitbyte;
        public final CacheStrategy tempFileManager;
        public String uri;

        public HTTPSession(CacheStrategy cacheStrategy, InputStream inputStream, OutputStream outputStream, InetAddress inetAddress) {
            this.tempFileManager = cacheStrategy;
            this.inputStream = new BufferedInputStream(inputStream, 8192);
            this.outputStream = outputStream;
            this.remoteIp = (inetAddress.isLoopbackAddress() || inetAddress.isAnyLocalAddress()) ? "127.0.0.1" : inetAddress.getHostAddress().toString();
            if (!inetAddress.isLoopbackAddress() && !inetAddress.isAnyLocalAddress()) {
                inetAddress.getHostName().getClass();
            }
            this.headers = new HashMap();
        }

        public static void decodeParms(String str, Map map) {
            String strTrim;
            String strDecodePercent;
            if (str == null) {
                return;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(str, "&");
            while (stringTokenizer.hasMoreTokens()) {
                String strNextToken = stringTokenizer.nextToken();
                int iIndexOf = strNextToken.indexOf(61);
                if (iIndexOf >= 0) {
                    strTrim = NanoHTTPD.decodePercent(strNextToken.substring(0, iIndexOf)).trim();
                    strDecodePercent = NanoHTTPD.decodePercent(strNextToken.substring(iIndexOf + 1));
                } else {
                    strTrim = NanoHTTPD.decodePercent(strNextToken).trim();
                    strDecodePercent = "";
                }
                List arrayList = (List) map.get(strTrim);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    map.put(strTrim, arrayList);
                }
                arrayList.add(strDecodePercent);
            }
        }

        public static int findHeaderEnd(int i, byte[] bArr) {
            int i2;
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (i4 >= i) {
                    return 0;
                }
                byte b = bArr[i3];
                if (b == 13 && bArr[i4] == 10 && (i2 = i3 + 3) < i && bArr[i3 + 2] == 13 && bArr[i2] == 10) {
                    return i3 + 4;
                }
                if (b == 10 && bArr[i4] == 10) {
                    return i3 + 2;
                }
                i3 = i4;
            }
        }

        public static int[] getBoundaryPositions(ByteBuffer byteBuffer, byte[] bArr) {
            int[] iArr = new int[0];
            if (byteBuffer.remaining() < bArr.length) {
                return iArr;
            }
            int length = bArr.length + 4096;
            byte[] bArr2 = new byte[length];
            int iRemaining = byteBuffer.remaining() < length ? byteBuffer.remaining() : length;
            byteBuffer.get(bArr2, 0, iRemaining);
            int length2 = iRemaining - bArr.length;
            int i = 0;
            do {
                for (int i2 = 0; i2 < length2; i2++) {
                    for (int i3 = 0; i3 < bArr.length && bArr2[i2 + i3] == bArr[i3]; i3++) {
                        if (i3 == bArr.length - 1) {
                            int[] iArr2 = new int[iArr.length + 1];
                            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                            iArr2[iArr.length] = i + i2;
                            iArr = iArr2;
                        }
                    }
                }
                i += length2;
                System.arraycopy(bArr2, length - bArr.length, bArr2, 0, bArr.length);
                length2 = length - bArr.length;
                if (byteBuffer.remaining() < length2) {
                    length2 = byteBuffer.remaining();
                }
                byteBuffer.get(bArr2, bArr.length, length2);
            } while (length2 > 0);
            return iArr;
        }

        public final void decodeHeader(BufferedReader bufferedReader, HashMap map, HashMap map2, HashMap map3) throws ResponseException {
            String strDecodePercent;
            try {
                String line = bufferedReader.readLine();
                if (line == null) {
                    return;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(line);
                boolean zHasMoreTokens = stringTokenizer.hasMoreTokens();
                Response.Status status = Response.Status.BAD_REQUEST;
                if (!zHasMoreTokens) {
                    throw new ResponseException(status, "BAD REQUEST: Syntax error. Usage: GET /example/file.html");
                }
                map.put("method", stringTokenizer.nextToken());
                if (!stringTokenizer.hasMoreTokens()) {
                    throw new ResponseException(status, "BAD REQUEST: Missing URI. Usage: GET /example/file.html");
                }
                String strNextToken = stringTokenizer.nextToken();
                int iIndexOf = strNextToken.indexOf(63);
                if (iIndexOf >= 0) {
                    decodeParms(strNextToken.substring(iIndexOf + 1), map2);
                    strDecodePercent = NanoHTTPD.decodePercent(strNextToken.substring(0, iIndexOf));
                } else {
                    strDecodePercent = NanoHTTPD.decodePercent(strNextToken);
                }
                if (stringTokenizer.hasMoreTokens()) {
                    this.protocolVersion = stringTokenizer.nextToken();
                } else {
                    this.protocolVersion = "HTTP/1.1";
                    NanoHTTPD.LOG.log(Level.FINE, "no protocol version specified, strange. Assuming HTTP/1.1.");
                }
                String line2 = bufferedReader.readLine();
                while (line2 != null && !line2.trim().isEmpty()) {
                    int iIndexOf2 = line2.indexOf(58);
                    if (iIndexOf2 >= 0) {
                        map3.put(line2.substring(0, iIndexOf2).trim().toLowerCase(Locale.US), line2.substring(iIndexOf2 + 1).trim());
                    }
                    line2 = bufferedReader.readLine();
                }
                map.put("uri", strDecodePercent);
            } catch (IOException e) {
                throw new ResponseException("SERVER INTERNAL ERROR: IOException: " + e.getMessage(), e);
            }
        }

        public final void decodeMultipartFormData(ContentType contentType, ByteBuffer byteBuffer, HashMap map, LinkedHashMap linkedHashMap) throws Throwable {
            ContentType contentType2 = contentType;
            String str = contentType2.boundary;
            Response.Status status = Response.Status.INTERNAL_ERROR;
            try {
                int[] boundaryPositions = getBoundaryPositions(byteBuffer, str.getBytes());
                int length = boundaryPositions.length;
                Response.Status status2 = Response.Status.BAD_REQUEST;
                try {
                    if (length < 2) {
                        throw new ResponseException(status2, "BAD REQUEST: Content type is multipart/form-data but contains less than two boundary strings.");
                    }
                    int i = 1024;
                    byte[] bArr = new byte[1024];
                    int i2 = 0;
                    int i3 = 0;
                    int i4 = 0;
                    while (i3 < boundaryPositions.length - 1) {
                        byteBuffer.position(boundaryPositions[i3]);
                        int iRemaining = byteBuffer.remaining() < i ? byteBuffer.remaining() : i;
                        byteBuffer.get(bArr, i2, iRemaining);
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr, i2, iRemaining), Charset.forName(contentType2.getEncoding())), iRemaining);
                        String line = bufferedReader.readLine();
                        if (line == null || !line.contains(str)) {
                            throw new ResponseException(status2, "BAD REQUEST: Content type is multipart/form-data but chunk does not start with boundary.");
                        }
                        String line2 = bufferedReader.readLine();
                        String strGroup = null;
                        String strTrim = null;
                        int i5 = i4;
                        int i6 = 2;
                        String str2 = null;
                        while (line2 != null && line2.trim().length() > 0) {
                            Matcher matcher = NanoHTTPD.CONTENT_DISPOSITION_PATTERN.matcher(line2);
                            if (matcher.matches()) {
                                Matcher matcher2 = NanoHTTPD.CONTENT_DISPOSITION_ATTRIBUTE_PATTERN.matcher(matcher.group(2));
                                while (matcher2.find()) {
                                    int[] iArr = boundaryPositions;
                                    String strGroup2 = matcher2.group(1);
                                    if ("name".equalsIgnoreCase(strGroup2)) {
                                        strGroup = matcher2.group(2);
                                    } else if ("filename".equalsIgnoreCase(strGroup2)) {
                                        String strGroup3 = matcher2.group(2);
                                        if (strGroup3.isEmpty()) {
                                            str2 = strGroup3;
                                        } else if (i5 > 0) {
                                            str2 = strGroup3;
                                            i5++;
                                            strGroup = strGroup + String.valueOf(i5);
                                        } else {
                                            i5++;
                                            str2 = strGroup3;
                                        }
                                    }
                                    boundaryPositions = iArr;
                                }
                            }
                            int[] iArr2 = boundaryPositions;
                            Matcher matcher3 = NanoHTTPD.CONTENT_TYPE_PATTERN.matcher(line2);
                            if (matcher3.matches()) {
                                strTrim = matcher3.group(2).trim();
                            }
                            line2 = bufferedReader.readLine();
                            i6++;
                            boundaryPositions = iArr2;
                            str = str;
                        }
                        String str3 = str;
                        int[] iArr3 = boundaryPositions;
                        int i7 = 0;
                        while (true) {
                            int i8 = i6 - 1;
                            if (i6 <= 0) {
                                break;
                            }
                            while (bArr[i7] != 10) {
                                i7++;
                            }
                            i7++;
                            i6 = i8;
                        }
                        if (i7 >= iRemaining - 4) {
                            throw new ResponseException(status, "Multipart header size exceeds MAX_HEADER_SIZE.");
                        }
                        int i9 = iArr3[i3] + i7;
                        i3++;
                        int i10 = iArr3[i3] - 4;
                        byteBuffer.position(i9);
                        List arrayList = (List) map.get(strGroup);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            map.put(strGroup, arrayList);
                        }
                        if (strTrim == null) {
                            byte[] bArr2 = new byte[i10 - i9];
                            byteBuffer.get(bArr2);
                            arrayList.add(new String(bArr2, contentType.getEncoding()));
                        } else {
                            String strSaveTmpFile = saveTmpFile(byteBuffer, i9, i10 - i9);
                            if (linkedHashMap.containsKey(strGroup)) {
                                int i11 = 2;
                                while (true) {
                                    if (!linkedHashMap.containsKey(strGroup + i11)) {
                                        break;
                                    } else {
                                        i11++;
                                    }
                                }
                                linkedHashMap.put(strGroup + i11, strSaveTmpFile);
                            } else {
                                linkedHashMap.put(strGroup, strSaveTmpFile);
                            }
                            arrayList.add(str2);
                        }
                        contentType2 = contentType;
                        boundaryPositions = iArr3;
                        i4 = i5;
                        str = str3;
                        i = 1024;
                        i2 = 0;
                    }
                } catch (ResponseException e) {
                    throw e;
                } catch (Exception e2) {
                    e = e2;
                    throw new ResponseException(status, e.toString());
                }
            } catch (ResponseException e3) {
                throw e3;
            } catch (Exception e4) {
                e = e4;
            }
        }

        public final void execute() {
            Response.Status status = Response.Status.INTERNAL_ERROR;
            NanoHTTPD nanoHTTPD = NanoHTTPD.this;
            CacheStrategy cacheStrategy = this.tempFileManager;
            BufferedInputStream bufferedInputStream = this.inputStream;
            OutputStream outputStream = this.outputStream;
            try {
                try {
                    try {
                        try {
                            byte[] bArr = new byte[8192];
                            boolean z = false;
                            this.splitbyte = 0;
                            this.rlen = 0;
                            bufferedInputStream.mark(8192);
                            try {
                                int i = bufferedInputStream.read(bArr, 0, 8192);
                                if (i == -1) {
                                    NanoHTTPD.safeClose(bufferedInputStream);
                                    NanoHTTPD.safeClose(outputStream);
                                    throw new SocketException("NanoHttpd Shutdown");
                                }
                                while (i > 0) {
                                    int i2 = this.rlen + i;
                                    this.rlen = i2;
                                    int iFindHeaderEnd = findHeaderEnd(i2, bArr);
                                    this.splitbyte = iFindHeaderEnd;
                                    if (iFindHeaderEnd > 0) {
                                        break;
                                    }
                                    int i3 = this.rlen;
                                    i = bufferedInputStream.read(bArr, i3, 8192 - i3);
                                }
                                if (this.splitbyte < this.rlen) {
                                    bufferedInputStream.reset();
                                    bufferedInputStream.skip(this.splitbyte);
                                }
                                this.parms = new HashMap();
                                HashMap map = this.headers;
                                if (map == null) {
                                    this.headers = new HashMap();
                                } else {
                                    map.clear();
                                }
                                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArr, 0, this.rlen)));
                                HashMap map2 = new HashMap();
                                decodeHeader(bufferedReader, map2, this.parms, this.headers);
                                String str = this.remoteIp;
                                if (str != null) {
                                    this.headers.put("remote-addr", str);
                                    this.headers.put("http-client-ip", str);
                                }
                                int i_lookup = Density.CC._lookup((String) map2.get("method"));
                                this.method = i_lookup;
                                if (i_lookup == 0) {
                                    throw new ResponseException(Response.Status.BAD_REQUEST, "BAD REQUEST: Syntax error. HTTP verb " + ((String) map2.get("method")) + " unhandled.");
                                }
                                this.uri = (String) map2.get("uri");
                                this.cookies = new TaskStackBuilder(this.headers);
                                String str2 = (String) this.headers.get("connection");
                                boolean z2 = "HTTP/1.1".equals(this.protocolVersion) && (str2 == null || !str2.matches("(?i).*close.*"));
                                Response responseServe = nanoHTTPD.serve(this);
                                String str3 = (String) this.headers.get("accept-encoding");
                                this.cookies.unloadQueue();
                                responseServe.setRequestMethod(this.method);
                                if (NanoHTTPD.useGzipWhenAccepted(responseServe) && str3 != null && str3.contains("gzip")) {
                                    z = true;
                                }
                                responseServe.setGzipEncoding(z);
                                responseServe.setKeepAlive(z2);
                                responseServe.send(outputStream);
                                if (!z2 || responseServe.isCloseConnection()) {
                                    throw new SocketException("NanoHttpd Shutdown");
                                }
                                NanoHTTPD.safeClose(responseServe);
                                cacheStrategy.clear();
                            } catch (SSLException e) {
                                throw e;
                            } catch (IOException unused) {
                                NanoHTTPD.safeClose(bufferedInputStream);
                                NanoHTTPD.safeClose(outputStream);
                                throw new SocketException("NanoHttpd Shutdown");
                            }
                        } catch (ResponseException e2) {
                            NanoHTTPD.newFixedLengthResponse(e2.getStatus(), "text/plain", e2.getMessage()).send(outputStream);
                            NanoHTTPD.safeClose(outputStream);
                            NanoHTTPD.safeClose(null);
                            cacheStrategy.clear();
                        }
                    } catch (SSLException e3) {
                        NanoHTTPD.newFixedLengthResponse(status, "text/plain", "SSL PROTOCOL FAILURE: " + e3.getMessage()).send(outputStream);
                        NanoHTTPD.safeClose(outputStream);
                        NanoHTTPD.safeClose(null);
                        cacheStrategy.clear();
                    } catch (IOException e4) {
                        NanoHTTPD.newFixedLengthResponse(status, "text/plain", "SERVER INTERNAL ERROR: IOException: " + e4.getMessage()).send(outputStream);
                        NanoHTTPD.safeClose(outputStream);
                        NanoHTTPD.safeClose(null);
                        cacheStrategy.clear();
                    }
                } catch (SocketException e5) {
                    throw e5;
                } catch (SocketTimeoutException e6) {
                    throw e6;
                }
            } catch (Throwable th) {
                NanoHTTPD.safeClose(null);
                cacheStrategy.clear();
                throw th;
            }
        }

        public final HashMap getParms() {
            HashMap map = new HashMap();
            for (String str : this.parms.keySet()) {
                map.put(str, ((List) this.parms.get(str)).get(0));
            }
            return map;
        }

        public final String saveTmpFile(ByteBuffer byteBuffer, int i, int i2) throws Throwable {
            if (i2 <= 0) {
                return "";
            }
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    CacheStrategy cacheStrategy = this.tempFileManager;
                    DefaultTempFile defaultTempFile = new DefaultTempFile((File) cacheStrategy.networkRequest);
                    ((ArrayList) cacheStrategy.cacheResponse).add(defaultTempFile);
                    File file = defaultTempFile.file;
                    ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file.getAbsolutePath());
                    try {
                        FileChannel channel = fileOutputStream2.getChannel();
                        byteBufferDuplicate.position(i).limit(i + i2);
                        channel.write(byteBufferDuplicate.slice());
                        String absolutePath = file.getAbsolutePath();
                        NanoHTTPD.safeClose(fileOutputStream2);
                        return absolutePath;
                    } catch (Exception e) {
                        e = e;
                        throw new Error(e);
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        NanoHTTPD.safeClose(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Response implements Closeable {
        public boolean chunkedTransfer;
        public final long contentLength;
        public final ByteArrayInputStream data;
        public boolean encodeAsGzip;
        public boolean keepAlive;
        public final String mimeType;
        public int requestMethod;
        public final Status status;
        public final AnonymousClass1 header = new HashMap() { // from class: fi.iki.elonen.NanoHTTPD.Response.1
            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final Object put(Object obj, Object obj2) {
                String str = (String) obj;
                String str2 = (String) obj2;
                Response.this.lowerCaseHeader.put(str == null ? str : str.toLowerCase(), str2);
                return (String) super.put(str, str2);
            }
        };
        public final HashMap lowerCaseHeader = new HashMap();

        /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
        public enum Status {
            /* JADX INFO: Fake field, exist only in values array */
            EF0("SWITCH_PROTOCOL", "Switching Protocols"),
            OK("OK", "OK"),
            /* JADX INFO: Fake field, exist only in values array */
            EF2("CREATED", "Created"),
            /* JADX INFO: Fake field, exist only in values array */
            EF5("ACCEPTED", "Accepted"),
            /* JADX INFO: Fake field, exist only in values array */
            EF6("NO_CONTENT", "No Content"),
            /* JADX INFO: Fake field, exist only in values array */
            EF8("PARTIAL_CONTENT", "Partial Content"),
            /* JADX INFO: Fake field, exist only in values array */
            EF10("MULTI_STATUS", "Multi-Status"),
            /* JADX INFO: Fake field, exist only in values array */
            EF3("REDIRECT", "Moved Permanently"),
            /* JADX INFO: Fake field, exist only in values array */
            EF7("FOUND", "Found"),
            /* JADX INFO: Fake field, exist only in values array */
            EF9("REDIRECT_SEE_OTHER", "See Other"),
            /* JADX INFO: Fake field, exist only in values array */
            EF11("NOT_MODIFIED", "Not Modified"),
            /* JADX INFO: Fake field, exist only in values array */
            EF12("TEMPORARY_REDIRECT", "Temporary Redirect"),
            BAD_REQUEST("BAD_REQUEST", "Bad Request"),
            /* JADX INFO: Fake field, exist only in values array */
            EF0("UNAUTHORIZED", "Unauthorized"),
            FORBIDDEN("FORBIDDEN", "Forbidden"),
            NOT_FOUND("NOT_FOUND", "Not Found"),
            /* JADX INFO: Fake field, exist only in values array */
            EF1("METHOD_NOT_ALLOWED", "Method Not Allowed"),
            /* JADX INFO: Fake field, exist only in values array */
            EF0("NOT_ACCEPTABLE", "Not Acceptable"),
            /* JADX INFO: Fake field, exist only in values array */
            EF1("REQUEST_TIMEOUT", "Request Timeout"),
            /* JADX INFO: Fake field, exist only in values array */
            EF0("CONFLICT", "Conflict"),
            /* JADX INFO: Fake field, exist only in values array */
            EF1("GONE", "Gone"),
            /* JADX INFO: Fake field, exist only in values array */
            EF0("LENGTH_REQUIRED", "Length Required"),
            /* JADX INFO: Fake field, exist only in values array */
            EF1("PRECONDITION_FAILED", "Precondition Failed"),
            /* JADX INFO: Fake field, exist only in values array */
            EF0("PAYLOAD_TOO_LARGE", "Payload Too Large"),
            /* JADX INFO: Fake field, exist only in values array */
            EF1("UNSUPPORTED_MEDIA_TYPE", "Unsupported Media Type"),
            /* JADX INFO: Fake field, exist only in values array */
            EF0("RANGE_NOT_SATISFIABLE", "Requested Range Not Satisfiable"),
            /* JADX INFO: Fake field, exist only in values array */
            EF1("EXPECTATION_FAILED", "Expectation Failed"),
            /* JADX INFO: Fake field, exist only in values array */
            EF0("TOO_MANY_REQUESTS", "Too Many Requests"),
            INTERNAL_ERROR("INTERNAL_ERROR", "Internal Server Error"),
            /* JADX INFO: Fake field, exist only in values array */
            EF467("NOT_IMPLEMENTED", "Not Implemented"),
            /* JADX INFO: Fake field, exist only in values array */
            EF482("SERVICE_UNAVAILABLE", "Service Unavailable"),
            /* JADX INFO: Fake field, exist only in values array */
            EF497("UNSUPPORTED_HTTP_VERSION", "HTTP Version Not Supported");

            public final String description;
            public final int requestStatus;

            Status(String str, String str2) {
                this.requestStatus = i;
                this.description = str2;
            }
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [fi.iki.elonen.NanoHTTPD$Response$1] */
        public Response(Status status, String str, ByteArrayInputStream byteArrayInputStream, long j) {
            this.status = status;
            this.mimeType = str;
            this.data = byteArrayInputStream;
            this.contentLength = j;
            this.chunkedTransfer = j < 0;
            this.keepAlive = true;
        }

        public static void printHeader(PrintWriter printWriter, String str, String str2) {
            printWriter.append((CharSequence) str).append(": ").append((CharSequence) str2).append("\r\n");
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            ByteArrayInputStream byteArrayInputStream = this.data;
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
        }

        public final String getHeader(String str) {
            return (String) this.lowerCaseHeader.get(str.toLowerCase());
        }

        public final boolean isCloseConnection() {
            return "close".equals(getHeader("connection"));
        }

        public final void send(OutputStream outputStream) {
            String str = this.mimeType;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            Status status = this.status;
            try {
                if (status == null) {
                    throw new Error("sendResponse(): Status can't be null.");
                }
                PrintWriter printWriter = new PrintWriter((Writer) new BufferedWriter(new OutputStreamWriter(outputStream, new ContentType(str).getEncoding())), false);
                printWriter.append("HTTP/1.1 ").append("" + status.requestStatus + " " + status.description).append(" \r\n");
                if (str != null) {
                    printHeader(printWriter, "Content-Type", str);
                }
                if (getHeader("date") == null) {
                    printHeader(printWriter, "Date", simpleDateFormat.format(new Date()));
                }
                for (Map.Entry entry : entrySet()) {
                    printHeader(printWriter, (String) entry.getKey(), (String) entry.getValue());
                }
                if (getHeader("connection") == null) {
                    printHeader(printWriter, "Connection", this.keepAlive ? "keep-alive" : "close");
                }
                if (getHeader("content-length") != null) {
                    this.encodeAsGzip = false;
                }
                if (this.encodeAsGzip) {
                    printHeader(printWriter, "Content-Encoding", "gzip");
                    this.chunkedTransfer = true;
                }
                ByteArrayInputStream byteArrayInputStream = this.data;
                long jSendContentLengthHeaderIfNotAlreadyPresent = byteArrayInputStream != null ? this.contentLength : 0L;
                if (this.requestMethod != 5 && this.chunkedTransfer) {
                    printHeader(printWriter, "Transfer-Encoding", "chunked");
                } else if (!this.encodeAsGzip) {
                    jSendContentLengthHeaderIfNotAlreadyPresent = sendContentLengthHeaderIfNotAlreadyPresent(printWriter, jSendContentLengthHeaderIfNotAlreadyPresent);
                }
                printWriter.append("\r\n");
                printWriter.flush();
                if (this.requestMethod != 5 && this.chunkedTransfer) {
                    ChunkedOutputStream chunkedOutputStream = new ChunkedOutputStream(outputStream);
                    if (this.encodeAsGzip) {
                        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(chunkedOutputStream);
                        sendBody(gZIPOutputStream, -1L);
                        gZIPOutputStream.finish();
                    } else {
                        sendBody(chunkedOutputStream, -1L);
                    }
                    chunkedOutputStream.finish();
                } else if (this.encodeAsGzip) {
                    GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(outputStream);
                    sendBody(gZIPOutputStream2, -1L);
                    gZIPOutputStream2.finish();
                } else {
                    sendBody(outputStream, jSendContentLengthHeaderIfNotAlreadyPresent);
                }
                outputStream.flush();
                NanoHTTPD.safeClose(byteArrayInputStream);
            } catch (IOException e) {
                NanoHTTPD.LOG.log(Level.SEVERE, "Could not send response to the client", (Throwable) e);
            }
        }

        public final void sendBody(OutputStream outputStream, long j) throws IOException {
            byte[] bArr = new byte[(int) 16384];
            boolean z = j == -1;
            while (true) {
                if (j <= 0 && !z) {
                    return;
                }
                int i = this.data.read(bArr, 0, (int) (z ? 16384L : Math.min(j, 16384L)));
                if (i <= 0) {
                    return;
                }
                outputStream.write(bArr, 0, i);
                if (!z) {
                    j -= (long) i;
                }
            }
        }

        public final long sendContentLengthHeaderIfNotAlreadyPresent(PrintWriter printWriter, long j) {
            String header = getHeader("content-length");
            if (header != null) {
                try {
                    j = Long.parseLong(header);
                } catch (NumberFormatException unused) {
                    NanoHTTPD.LOG.severe("content-length was no number ".concat(header));
                }
            }
            printWriter.print("Content-Length: " + j + "\r\n");
            return j;
        }

        public final void setGzipEncoding(boolean z) {
            this.encodeAsGzip = z;
        }

        public final void setKeepAlive(boolean z) {
            this.keepAlive = z;
        }

        public final void setRequestMethod(int i) {
            this.requestMethod = i;
        }

        /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
        public final class ChunkedOutputStream extends FilterOutputStream {
            public final void finish() throws IOException {
                ((FilterOutputStream) this).out.write("0\r\n\r\n".getBytes());
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int i) throws IOException {
                write(new byte[]{(byte) i}, 0, 1);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] bArr) throws IOException {
                write(bArr, 0, bArr.length);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] bArr, int i, int i2) throws IOException {
                if (i2 == 0) {
                    return;
                }
                ((FilterOutputStream) this).out.write(String.format("%x\r\n", Integer.valueOf(i2)).getBytes());
                ((FilterOutputStream) this).out.write(bArr, i, i2);
                ((FilterOutputStream) this).out.write("\r\n".getBytes());
            }
        }
    }

    public static String decodePercent(String str) {
        try {
            return URLDecoder.decode(str, "UTF8");
        } catch (UnsupportedEncodingException e) {
            LOG.log(Level.WARNING, "Encoding not supported, ignored", (Throwable) e);
            return null;
        }
    }

    public static Response newFixedLengthResponse(Response.Status status, String str, String str2) {
        byte[] bytes;
        ContentType contentType = new ContentType(str);
        if (str2 == null) {
            return new Response(status, str, new ByteArrayInputStream(new byte[0]), 0L);
        }
        try {
            if (!Charset.forName(contentType.getEncoding()).newEncoder().canEncode(str2) && contentType.encoding == null) {
                contentType = new ContentType(str.concat("; charset=UTF-8"));
            }
            bytes = str2.getBytes(contentType.getEncoding());
        } catch (UnsupportedEncodingException e) {
            LOG.log(Level.SEVERE, "encoding problem, responding nothing", (Throwable) e);
            bytes = new byte[0];
        }
        return new Response(status, contentType.contentTypeHeader, new ByteArrayInputStream(bytes), bytes.length);
    }

    public static final void safeClose(Object obj) {
        if (obj != null) {
            try {
                if (obj instanceof Closeable) {
                    ((Closeable) obj).close();
                } else if (obj instanceof Socket) {
                    ((Socket) obj).close();
                } else {
                    if (!(obj instanceof ServerSocket)) {
                        throw new IllegalArgumentException("Unknown object to close");
                    }
                    ((ServerSocket) obj).close();
                }
            } catch (IOException e) {
                LOG.log(Level.SEVERE, "Could not close", (Throwable) e);
            }
        }
    }

    public static boolean useGzipWhenAccepted(Response response) {
        String str = response.mimeType;
        if (str != null) {
            return str.toLowerCase().contains("text/") || str.toLowerCase().contains("/json");
        }
        return false;
    }

    public abstract Response serve(HTTPSession hTTPSession);

    public final void start() throws IOException {
        this.myServerSocket = new ServerSocket();
        this.myServerSocket.setReuseAddress(true);
        ServerRunnable serverRunnable = new ServerRunnable(this);
        Thread thread = new Thread(serverRunnable);
        this.myThread = thread;
        thread.setDaemon(true);
        this.myThread.setName("NanoHttpd Main Listener");
        this.myThread.start();
        while (!serverRunnable.hasBinded && ((IOException) serverRunnable.bindException) == null) {
            try {
                Thread.sleep(10L);
            } catch (Throwable unused) {
            }
        }
        IOException iOException = (IOException) serverRunnable.bindException;
        if (iOException != null) {
            throw iOException;
        }
    }

    public final void stop() {
        try {
            safeClose(this.myServerSocket);
            HeadersReader headersReader = this.asyncRunner;
            headersReader.getClass();
            ArrayList arrayList = new ArrayList((List) headersReader.source);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ClientHandler clientHandler = (ClientHandler) obj;
                safeClose(clientHandler.inputStream);
                safeClose(clientHandler.acceptSocket);
            }
            Thread thread = this.myThread;
            if (thread != null) {
                thread.join();
            }
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Could not stop all connections", (Throwable) e);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class ResponseException extends Exception {
        public final Response.Status status;

        public ResponseException(Response.Status status, String str) {
            super(str);
            this.status = status;
        }

        public final Response.Status getStatus() {
            return this.status;
        }

        public ResponseException(String str, IOException iOException) {
            super(str, iOException);
            this.status = Response.Status.INTERNAL_ERROR;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class ServerRunnable implements Runnable {
        public Object bindException;
        public final /* synthetic */ Object this$0;
        public final /* synthetic */ int $r8$classId = 1;
        public boolean hasBinded = false;

        public ServerRunnable(NanoHTTPD nanoHTTPD) {
            this.this$0 = nanoHTTPD;
        }

        @Override // java.lang.Runnable
        public final void run() {
            switch (this.$r8$classId) {
                case 0:
                    try {
                        ((NanoHTTPD) this.this$0).myServerSocket.bind(new InetSocketAddress(0));
                        this.hasBinded = true;
                        do {
                            try {
                                Socket socketAccept = ((NanoHTTPD) this.this$0).myServerSocket.accept();
                                socketAccept.setSoTimeout(5000);
                                InputStream inputStream = socketAccept.getInputStream();
                                NanoHTTPD nanoHTTPD = (NanoHTTPD) this.this$0;
                                nanoHTTPD.asyncRunner.exec(nanoHTTPD.new ClientHandler(inputStream, socketAccept));
                            } catch (IOException e) {
                                NanoHTTPD.LOG.log(Level.FINE, "Communication with the client broken", (Throwable) e);
                            }
                        } while (!((NanoHTTPD) this.this$0).myServerSocket.isClosed());
                    } catch (IOException e2) {
                        this.bindException = e2;
                        return;
                    }
                    break;
                default:
                    ((Executor) this.bindException).execute(new Preview$$ExternalSyntheticLambda0(5, this));
                    break;
            }
        }

        public ServerRunnable(Camera2CameraImpl.StateCallback stateCallback, SequentialExecutor sequentialExecutor) {
            this.this$0 = stateCallback;
            this.bindException = sequentialExecutor;
        }
    }
}
