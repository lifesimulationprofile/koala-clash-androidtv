package androidx.compose.ui.node;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.DrawableUtils;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.ui.layout.VerticalRuler;
import androidx.core.util.Preconditions;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.ViewCompat;
import androidx.room.RoomOpenHelper;
import coil.memory.RealWeakMemoryCache;
import com.google.android.material.R$styleable;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import okhttp3.Address;
import okhttp3.ConnectionSpec;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.StatusLine$Companion;
import okhttp3.internal.http1.HeadersReader;
import okhttp3.internal.http1.Http1ExchangeCodec$AbstractSource;
import okhttp3.internal.http1.Http1ExchangeCodec$FixedLengthSource;
import okhttp3.internal.http1.Http1ExchangeCodec$UnknownLengthSource;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.RealBufferedSink;
import okio.RealBufferedSource;
import okio.Source;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RulerTrackingMap implements ExchangeCodec {
    public Object accessFlags;
    public Object layoutNodes;
    public Object newRulers;
    public Object rulers;
    public int size;
    public Object values;

    public RulerTrackingMap(View view) {
        this.size = -1;
        this.rulers = view;
        this.values = AppCompatDrawableManager.get();
    }

    public static RulerTrackingMap create(Context context, int i) {
        Preconditions.checkArgument("Cannot create a CalendarItemStyle with a styleResId of 0", i != 0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, R$styleable.MaterialCalendarItem);
        Rect rect = new Rect(typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(2, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(3, 0));
        ColorStateList colorStateList = MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, 4);
        ColorStateList colorStateList2 = MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, 9);
        ColorStateList colorStateList3 = MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, 7);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(8, 0);
        ShapeAppearanceModel shapeAppearanceModelBuild = ShapeAppearanceModel.builder(context, typedArrayObtainStyledAttributes.getResourceId(5, 0), typedArrayObtainStyledAttributes.getResourceId(6, 0), new AbsoluteCornerSize(0)).build();
        typedArrayObtainStyledAttributes.recycle();
        RulerTrackingMap rulerTrackingMap = new RulerTrackingMap();
        Preconditions.checkArgumentNonnegative(rect.left);
        Preconditions.checkArgumentNonnegative(rect.top);
        Preconditions.checkArgumentNonnegative(rect.right);
        Preconditions.checkArgumentNonnegative(rect.bottom);
        rulerTrackingMap.rulers = rect;
        rulerTrackingMap.values = colorStateList2;
        rulerTrackingMap.accessFlags = colorStateList;
        rulerTrackingMap.layoutNodes = colorStateList3;
        rulerTrackingMap.size = dimensionPixelSize;
        rulerTrackingMap.newRulers = shapeAppearanceModelBuild;
        return rulerTrackingMap;
    }

    public void applySupportBackgroundTint() {
        View view = (View) this.rulers;
        Drawable background = view.getBackground();
        if (background != null) {
            if (((ConnectionSpec.Builder) this.accessFlags) != null) {
                if (((ConnectionSpec.Builder) this.newRulers) == null) {
                    this.newRulers = new ConnectionSpec.Builder();
                }
                ConnectionSpec.Builder builder = (ConnectionSpec.Builder) this.newRulers;
                builder.cipherSuites = null;
                builder.supportsTlsExtensions = false;
                builder.tlsVersions = null;
                builder.tls = false;
                WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                ColorStateList backgroundTintList = ViewCompat.Api21Impl.getBackgroundTintList(view);
                if (backgroundTintList != null) {
                    builder.supportsTlsExtensions = true;
                    builder.cipherSuites = backgroundTintList;
                }
                PorterDuff.Mode backgroundTintMode = ViewCompat.Api21Impl.getBackgroundTintMode(view);
                if (backgroundTintMode != null) {
                    builder.tls = true;
                    builder.tlsVersions = backgroundTintMode;
                }
                if (builder.supportsTlsExtensions || builder.tls) {
                    AppCompatDrawableManager.tintDrawable(background, builder, view.getDrawableState());
                    return;
                }
            }
            ConnectionSpec.Builder builder2 = (ConnectionSpec.Builder) this.layoutNodes;
            if (builder2 != null) {
                AppCompatDrawableManager.tintDrawable(background, builder2, view.getDrawableState());
                return;
            }
            ConnectionSpec.Builder builder3 = (ConnectionSpec.Builder) this.accessFlags;
            if (builder3 != null) {
                AppCompatDrawableManager.tintDrawable(background, builder3, view.getDrawableState());
            }
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void cancel() {
        Socket socket = ((RealConnection) this.values).rawSocket;
        if (socket != null) {
            Util.closeQuietly(socket);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void finishRequest() {
        ((BufferedSink) this.layoutNodes).flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void flushRequest() {
        ((BufferedSink) this.layoutNodes).flush();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public RealConnection getConnection() {
        return (RealConnection) this.values;
    }

    public ColorStateList getSupportBackgroundTintList() {
        ConnectionSpec.Builder builder = (ConnectionSpec.Builder) this.layoutNodes;
        if (builder != null) {
            return (ColorStateList) builder.cipherSuites;
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        ConnectionSpec.Builder builder = (ConnectionSpec.Builder) this.layoutNodes;
        if (builder != null) {
            return (PorterDuff.Mode) builder.tlsVersions;
        }
        return null;
    }

    public boolean hasNext() {
        return this.size < ((List) this.accessFlags).size() || !((ArrayList) this.newRulers).isEmpty();
    }

    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        ColorStateList tintList;
        View view = (View) this.rulers;
        Context context = view.getContext();
        int[] iArr = androidx.appcompat.R$styleable.ViewBackgroundHelper;
        MenuHostHelper menuHostHelperObtainStyledAttributes = MenuHostHelper.obtainStyledAttributes(context, attributeSet, iArr, i);
        TypedArray typedArray = (TypedArray) menuHostHelperObtainStyledAttributes.mMenuProviders;
        View view2 = (View) this.rulers;
        ViewCompat.saveAttributeDataForStyleable(view2, view2.getContext(), iArr, attributeSet, (TypedArray) menuHostHelperObtainStyledAttributes.mMenuProviders, i, 0);
        try {
            if (typedArray.hasValue(0)) {
                this.size = typedArray.getResourceId(0, -1);
                AppCompatDrawableManager appCompatDrawableManager = (AppCompatDrawableManager) this.values;
                Context context2 = view.getContext();
                int i2 = this.size;
                synchronized (appCompatDrawableManager) {
                    tintList = appCompatDrawableManager.mResourceManager.getTintList(context2, i2);
                }
                if (tintList != null) {
                    setInternalBackgroundTint(tintList);
                }
            }
            if (typedArray.hasValue(1)) {
                ViewCompat.Api21Impl.setBackgroundTintList(view, menuHostHelperObtainStyledAttributes.getColorStateList(1));
            }
            if (typedArray.hasValue(2)) {
                ViewCompat.Api21Impl.setBackgroundTintMode(view, DrawableUtils.parseTintMode(typedArray.getInt(2, -1), null));
            }
            menuHostHelperObtainStyledAttributes.recycle();
        } catch (Throwable th) {
            menuHostHelperObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public Http1ExchangeCodec$FixedLengthSource newFixedLengthSource(long j) {
        if (this.size == 4) {
            this.size = 5;
            return new Http1ExchangeCodec$FixedLengthSource(this, j);
        }
        throw new IllegalStateException(("state: " + this.size).toString());
    }

    /* JADX WARN: Type inference failed for: r1v26, types: [java.lang.Object, java.util.List] */
    public RealWeakMemoryCache next() throws SocketException, UnknownHostException {
        String hostName;
        int port;
        List listSingletonList;
        boolean zContains;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (this.size < ((List) this.accessFlags).size()) {
            Address address = (Address) this.rulers;
            if (this.size >= ((List) this.accessFlags).size()) {
                throw new SocketException("No route to " + address.url.host + "; exhausted proxy configurations: " + ((List) this.accessFlags));
            }
            List list = (List) this.accessFlags;
            int i = this.size;
            this.size = i + 1;
            Proxy proxy = (Proxy) list.get(i);
            ArrayList arrayList2 = new ArrayList();
            this.layoutNodes = arrayList2;
            if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
                HttpUrl httpUrl = address.url;
                hostName = httpUrl.host;
                port = httpUrl.port;
            } else {
                SocketAddress socketAddressAddress = proxy.address();
                if (!(socketAddressAddress instanceof InetSocketAddress)) {
                    throw new IllegalArgumentException(("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass()).toString());
                }
                InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                InetAddress address2 = inetSocketAddress.getAddress();
                hostName = address2 == null ? inetSocketAddress.getHostName() : address2.getHostAddress();
                port = inetSocketAddress.getPort();
            }
            if (1 > port || port >= 65536) {
                throw new SocketException("No route to " + hostName + ':' + port + "; port is out of range");
            }
            if (proxy.type() == Proxy.Type.SOCKS) {
                arrayList2.add(InetSocketAddress.createUnresolved(hostName, port));
            } else {
                if (Util.VERIFY_AS_IP_ADDRESS.matches(hostName)) {
                    listSingletonList = Collections.singletonList(InetAddress.getByName(hostName));
                } else {
                    address.dns.getClass();
                    try {
                        List list2 = ArraysKt.toList(InetAddress.getAllByName(hostName));
                        if (list2.isEmpty()) {
                            throw new UnknownHostException(address.dns + " returned no addresses for " + hostName);
                        }
                        listSingletonList = list2;
                    } catch (NullPointerException e) {
                        UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of ".concat(hostName));
                        unknownHostException.initCause(e);
                        throw unknownHostException;
                    }
                }
                Iterator it = listSingletonList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new InetSocketAddress((InetAddress) it.next(), port));
                }
            }
            Iterator it2 = this.layoutNodes.iterator();
            while (it2.hasNext()) {
                Route route = new Route((Address) this.rulers, proxy, (InetSocketAddress) it2.next());
                Headers.Builder builder = (Headers.Builder) this.values;
                synchronized (builder) {
                    zContains = ((LinkedHashSet) builder.namesAndValues).contains(route);
                }
                if (zContains) {
                    ((ArrayList) this.newRulers).add(route);
                } else {
                    arrayList.add(route);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            CollectionsKt__MutableCollectionsKt.addAll((ArrayList) this.newRulers, arrayList);
            ((ArrayList) this.newRulers).clear();
        }
        return new RealWeakMemoryCache(14, arrayList);
    }

    public void onSetBackgroundDrawable() {
        this.size = -1;
        setInternalBackgroundTint(null);
        applySupportBackgroundTint();
    }

    public void onSetBackgroundResource(int i) {
        ColorStateList tintList;
        this.size = i;
        AppCompatDrawableManager appCompatDrawableManager = (AppCompatDrawableManager) this.values;
        if (appCompatDrawableManager != null) {
            Context context = ((View) this.rulers).getContext();
            synchronized (appCompatDrawableManager) {
                tintList = appCompatDrawableManager.mResourceManager.getTintList(context, i);
            }
        } else {
            tintList = null;
        }
        setInternalBackgroundTint(tintList);
        applySupportBackgroundTint();
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Source openResponseBodySource(Response response) {
        if (!HttpHeaders.promisesBody(response)) {
            return newFixedLengthSource(0L);
        }
        String str = response.headers.get("Transfer-Encoding");
        if (str == null) {
            str = null;
        }
        if ("chunked".equalsIgnoreCase(str)) {
            final HttpUrl httpUrl = (HttpUrl) response.request.url;
            if (this.size == 4) {
                this.size = 5;
                return new Http1ExchangeCodec$AbstractSource(httpUrl) { // from class: okhttp3.internal.http1.Http1ExchangeCodec$ChunkedSource
                    public long bytesRemainingInChunk;
                    public boolean hasMoreChunks;
                    public final HttpUrl url;

                    {
                        super(this.this$0);
                        this.url = httpUrl;
                        this.bytesRemainingInChunk = -1L;
                        this.hasMoreChunks = true;
                    }

                    @Override // java.io.Closeable, java.lang.AutoCloseable
                    public final void close() {
                        boolean zSkipAll;
                        if (this.closed) {
                            return;
                        }
                        if (this.hasMoreChunks) {
                            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                            try {
                                zSkipAll = Util.skipAll(this, 100);
                            } catch (IOException unused) {
                                zSkipAll = false;
                            }
                            if (!zSkipAll) {
                                ((RealConnection) this.this$0.values).noNewExchanges$okhttp();
                                responseBodyComplete();
                            }
                        }
                        this.closed = true;
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:29:0x0074, code lost:
                    
                        if (r11.hasMoreChunks == false) goto L30;
                     */
                    @Override // okhttp3.internal.http1.Http1ExchangeCodec$AbstractSource, okio.Source
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final long read(long r12, okio.Buffer r14) throws java.io.IOException {
                        /*
                            Method dump skipped, instruction units count: 219
                            To view this dump add '--comments-level debug' option
                        */
                        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http1.Http1ExchangeCodec$ChunkedSource.read(long, okio.Buffer):long");
                    }
                };
            }
            throw new IllegalStateException(("state: " + this.size).toString());
        }
        long jHeadersContentLength = Util.headersContentLength(response);
        if (jHeadersContentLength != -1) {
            return newFixedLengthSource(jHeadersContentLength);
        }
        if (this.size == 4) {
            this.size = 5;
            ((RealConnection) this.values).noNewExchanges$okhttp();
            return new Http1ExchangeCodec$UnknownLengthSource(this);
        }
        throw new IllegalStateException(("state: " + this.size).toString());
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public Response.Builder readResponseHeaders(boolean z) throws IOException {
        HeadersReader headersReader = (HeadersReader) this.newRulers;
        int i = this.size;
        if (i != 1 && i != 2 && i != 3) {
            throw new IllegalStateException(("state: " + this.size).toString());
        }
        try {
            String utf8LineStrict = ((BufferedSource) headersReader.source).readUtf8LineStrict(headersReader.headerLimit);
            headersReader.headerLimit -= (long) utf8LineStrict.length();
            RoomOpenHelper roomOpenHelper = StatusLine$Companion.parse(utf8LineStrict);
            int i2 = roomOpenHelper.version;
            Response.Builder builder = new Response.Builder();
            builder.protocol = (Protocol) roomOpenHelper.mConfiguration;
            builder.code = i2;
            builder.message = (String) roomOpenHelper.mDelegate;
            builder.headers = headersReader.readHeaders().newBuilder();
            if (z && i2 == 100) {
                return null;
            }
            if (i2 == 100) {
                this.size = 3;
                return builder;
            }
            if (102 > i2 || i2 >= 200) {
                this.size = 4;
                return builder;
            }
            this.size = 3;
            return builder;
        } catch (EOFException e) {
            throw new IOException("unexpected end of stream on ".concat(((RealConnection) this.values).route.address.url.redact()), e);
        }
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public long reportedContentLength(Response response) {
        if (!HttpHeaders.promisesBody(response)) {
            return 0L;
        }
        String str = response.headers.get("Transfer-Encoding");
        if (str == null) {
            str = null;
        }
        if ("chunked".equalsIgnoreCase(str)) {
            return -1L;
        }
        return Util.headersContentLength(response);
    }

    public void setInternalBackgroundTint(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (((ConnectionSpec.Builder) this.accessFlags) == null) {
                this.accessFlags = new ConnectionSpec.Builder();
            }
            ConnectionSpec.Builder builder = (ConnectionSpec.Builder) this.accessFlags;
            builder.cipherSuites = colorStateList;
            builder.supportsTlsExtensions = true;
        } else {
            this.accessFlags = null;
        }
        applySupportBackgroundTint();
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (((ConnectionSpec.Builder) this.layoutNodes) == null) {
            this.layoutNodes = new ConnectionSpec.Builder();
        }
        ConnectionSpec.Builder builder = (ConnectionSpec.Builder) this.layoutNodes;
        builder.cipherSuites = colorStateList;
        builder.supportsTlsExtensions = true;
        applySupportBackgroundTint();
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (((ConnectionSpec.Builder) this.layoutNodes) == null) {
            this.layoutNodes = new ConnectionSpec.Builder();
        }
        ConnectionSpec.Builder builder = (ConnectionSpec.Builder) this.layoutNodes;
        builder.tlsVersions = mode;
        builder.tls = true;
        applySupportBackgroundTint();
    }

    public void writeRequest(Headers headers, String str) {
        BufferedSink bufferedSink = (BufferedSink) this.layoutNodes;
        if (this.size != 0) {
            throw new IllegalStateException(("state: " + this.size).toString());
        }
        bufferedSink.writeUtf8(str).writeUtf8("\r\n");
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            bufferedSink.writeUtf8(headers.name(i)).writeUtf8(": ").writeUtf8(headers.value(i)).writeUtf8("\r\n");
        }
        bufferedSink.writeUtf8("\r\n");
        this.size = 1;
    }

    @Override // okhttp3.internal.http.ExchangeCodec
    public void writeRequestHeaders(Request request) {
        Proxy.Type type = ((RealConnection) this.values).route.proxy.type();
        StringBuilder sb = new StringBuilder();
        sb.append((String) request.method);
        sb.append(' ');
        HttpUrl httpUrl = (HttpUrl) request.url;
        if (httpUrl.isHttps || type != Proxy.Type.HTTP) {
            String strEncodedPath = httpUrl.encodedPath();
            String strEncodedQuery = httpUrl.encodedQuery();
            if (strEncodedQuery != null) {
                strEncodedPath = strEncodedPath + '?' + strEncodedQuery;
            }
            sb.append(strEncodedPath);
        } else {
            sb.append(httpUrl);
        }
        sb.append(" HTTP/1.1");
        writeRequest((Headers) request.headers, sb.toString());
    }

    public RulerTrackingMap(OkHttpClient okHttpClient, RealConnection realConnection, RealBufferedSource realBufferedSource, RealBufferedSink realBufferedSink) {
        this.rulers = okHttpClient;
        this.values = realConnection;
        this.accessFlags = realBufferedSource;
        this.layoutNodes = realBufferedSink;
        this.newRulers = new HeadersReader(realBufferedSource);
    }

    public RulerTrackingMap() {
        this.rulers = new VerticalRuler[32];
        this.values = new float[32];
        this.accessFlags = new byte[32];
        MutableScatterSet mutableScatterSet = ScatterSetKt.EmptyScatterSet;
        this.layoutNodes = new MutableScatterSet();
        this.newRulers = new MutableScatterSet();
    }
}
