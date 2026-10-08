package coil.network;

import android.graphics.Bitmap;
import coil.util.Time;
import coil.util.Utils;
import com.google.android.gms.dynamite.zzd;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.CacheControl;
import okhttp3.Dispatcher;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CacheStrategy {
    public final CacheResponse cacheResponse;
    public final Request networkRequest;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class Companion {
        public static Headers combineHeaders(Headers headers, Headers headers2) {
            Headers.Builder builder = new Headers.Builder(0);
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                String strName = headers.name(i);
                String strValue = headers.value(i);
                if ((!"Warning".equalsIgnoreCase(strName) || !StringsKt__StringsJVMKt.startsWith(strValue, "1", false)) && ("Content-Length".equalsIgnoreCase(strName) || "Content-Encoding".equalsIgnoreCase(strName) || "Content-Type".equalsIgnoreCase(strName) || !isEndToEnd(strName) || headers2.get(strName) == null)) {
                    builder.addUnsafeNonAscii(strName, strValue);
                }
            }
            int size2 = headers2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                String strName2 = headers2.name(i2);
                if (!"Content-Length".equalsIgnoreCase(strName2) && !"Content-Encoding".equalsIgnoreCase(strName2) && !"Content-Type".equalsIgnoreCase(strName2) && isEndToEnd(strName2)) {
                    builder.addUnsafeNonAscii(strName2, headers2.value(i2));
                }
            }
            return builder.build();
        }

        public static boolean isEndToEnd(String str) {
            return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Factory {
        public final int ageSeconds;
        public final CacheResponse cacheResponse;
        public final String etag;
        public final Date expires;
        public final Date lastModified;
        public final String lastModifiedString;
        public final long receivedResponseMillis;
        public final Request request;
        public final long sentRequestMillis;
        public final Date servedDate;
        public final String servedDateString;

        /* JADX WARN: Code duplicated, block: B:12:0x0043 A[EDGE_INSN: B:12:0x0043->B:36:0x00a1 BREAK  A[LOOP:1: B:19:0x0067->B:30:0x0097], PHI: r7
          0x0043: PHI (r7v3 int) = (r7v1 int), (r7v1 int), (r7v5 int) binds: [B:9:0x0039, B:11:0x0041, B:32:0x009d] A[DONT_GENERATE, DONT_INLINE]] */
        public Factory(Request request, CacheResponse cacheResponse) {
            int i;
            Date date;
            DateFormat simpleDateFormat;
            this.request = request;
            this.cacheResponse = cacheResponse;
            this.ageSeconds = -1;
            if (cacheResponse != null) {
                this.sentRequestMillis = cacheResponse.sentRequestAtMillis;
                this.receivedResponseMillis = cacheResponse.receivedResponseAtMillis;
                Headers headers = cacheResponse.responseHeaders;
                int size = headers.size();
                int i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    String strName = headers.name(i3);
                    if (StringsKt__StringsJVMKt.equals(strName, "Date", true)) {
                        String str = headers.get("Date");
                        if (str == null) {
                            date = null;
                            break;
                        }
                        zzd zzdVar = DatesKt.STANDARD_DATE_FORMAT;
                        if (str.length() == 0) {
                            date = null;
                            break;
                        }
                        ParsePosition parsePosition = new ParsePosition(i2);
                        Date date2 = ((DateFormat) DatesKt.STANDARD_DATE_FORMAT.get()).parse(str, parsePosition);
                        if (parsePosition.getIndex() == str.length()) {
                            date = date2;
                        } else {
                            String[] strArr = DatesKt.BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS;
                            synchronized (strArr) {
                                try {
                                    int length = strArr.length;
                                    int i4 = i2;
                                    while (true) {
                                        if (i4 >= length) {
                                            Unit unit = Unit.INSTANCE;
                                            date = null;
                                            break;
                                        }
                                        DateFormat[] dateFormatArr = DatesKt.BROWSER_COMPATIBLE_DATE_FORMATS;
                                        DateFormat dateFormat = dateFormatArr[i4];
                                        if (dateFormat == null) {
                                            simpleDateFormat = new SimpleDateFormat(DatesKt.BROWSER_COMPATIBLE_DATE_FORMAT_STRINGS[i4], Locale.US);
                                            simpleDateFormat.setTimeZone(Util.UTC);
                                            dateFormatArr[i4] = simpleDateFormat;
                                            i2 = 0;
                                        } else {
                                            simpleDateFormat = dateFormat;
                                        }
                                        parsePosition.setIndex(i2);
                                        Date date3 = simpleDateFormat.parse(str, parsePosition);
                                        if (parsePosition.getIndex() != 0) {
                                            date = date3;
                                            break;
                                        }
                                        i4++;
                                    }
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        }
                        this.servedDate = date;
                        this.servedDateString = headers.value(i3);
                    } else if (StringsKt__StringsJVMKt.equals(strName, "Expires", true)) {
                        this.expires = headers.getDate("Expires");
                    } else if (StringsKt__StringsJVMKt.equals(strName, "Last-Modified", true)) {
                        this.lastModified = headers.getDate("Last-Modified");
                        this.lastModifiedString = headers.value(i3);
                    } else if (StringsKt__StringsJVMKt.equals(strName, "ETag", true)) {
                        this.etag = headers.value(i3);
                    } else if (StringsKt__StringsJVMKt.equals(strName, "Age", true)) {
                        String strValue = headers.value(i3);
                        Bitmap.Config[] configArr = Utils.VALID_TRANSFORMATION_CONFIGS;
                        Long longOrNull = StringsKt__StringsJVMKt.toLongOrNull(strValue);
                        if (longOrNull != null) {
                            long jLongValue = longOrNull.longValue();
                            i = jLongValue > 2147483647L ? Integer.MAX_VALUE : jLongValue < 0 ? i2 : (int) jLongValue;
                        } else {
                            i = -1;
                        }
                        this.ageSeconds = i;
                    }
                }
            }
        }

        /* JADX WARN: Code duplicated, block: B:43:0x00d9  */
        /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Object, kotlin.Lazy] */
        public final CacheStrategy compute() {
            String string;
            long time;
            String str;
            int i;
            Request request = this.request;
            Headers headers = (Headers) request.headers;
            HttpUrl httpUrl = (HttpUrl) request.url;
            CacheResponse cacheResponse = this.cacheResponse;
            if (cacheResponse == null) {
                return new CacheStrategy(request, null);
            }
            ?? r6 = cacheResponse.cacheControl$delegate;
            if (httpUrl.isHttps && !cacheResponse.isTls) {
                return new CacheStrategy(request, null);
            }
            CacheControl cacheControl = (CacheControl) r6.getValue();
            if (request.cacheControl().noStore || ((CacheControl) r6.getValue()).noStore || Intrinsics.areEqual(cacheResponse.responseHeaders.get("Vary"), "*")) {
                return new CacheStrategy(request, null);
            }
            CacheControl cacheControl2 = request.cacheControl();
            if (cacheControl2.noCache || headers.get("If-Modified-Since") != null || headers.get("If-None-Match") != null) {
                return new CacheStrategy(request, null);
            }
            long time2 = this.receivedResponseMillis;
            Date date = this.servedDate;
            long jMax = date != null ? Math.max(0L, time2 - date.getTime()) : 0L;
            long millis = 0;
            int i2 = this.ageSeconds;
            if (i2 != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(i2));
            }
            long time3 = this.sentRequestMillis;
            long jLongValue = jMax + (time2 - time3) + (((Number) Time.provider.invoke()).longValue() - time2);
            int i3 = ((CacheControl) r6.getValue()).maxAgeSeconds;
            Date date2 = this.lastModified;
            if (i3 != -1) {
                time = TimeUnit.SECONDS.toMillis(i3);
            } else {
                Date date3 = this.expires;
                if (date3 != null) {
                    if (date != null) {
                        time2 = date.getTime();
                    }
                    time = date3.getTime() - time2;
                    if (time <= 0) {
                        time = 0;
                    }
                } else if (date2 == null) {
                    time = 0;
                } else {
                    List list = httpUrl.queryNamesAndValues;
                    if (list == null) {
                        string = null;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        HttpUrl.Companion.toQueryString$okhttp(list, sb);
                        string = sb.toString();
                    }
                    if (string != null) {
                        time = 0;
                    } else {
                        if (date != null) {
                            time3 = date.getTime();
                        }
                        long time4 = time3 - date2.getTime();
                        if (time4 > 0) {
                            time = time4 / ((long) 10);
                        } else {
                            time = 0;
                        }
                    }
                }
            }
            int i4 = cacheControl2.maxAgeSeconds;
            if (i4 != -1) {
                time = Math.min(time, TimeUnit.SECONDS.toMillis(i4));
            }
            int i5 = cacheControl2.minFreshSeconds;
            long millis2 = i5 != -1 ? TimeUnit.SECONDS.toMillis(i5) : 0L;
            if (!cacheControl.mustRevalidate && (i = cacheControl2.maxStaleSeconds) != -1) {
                millis = TimeUnit.SECONDS.toMillis(i);
            }
            if (!cacheControl.noCache && jLongValue + millis2 < time + millis) {
                return new CacheStrategy(null, cacheResponse);
            }
            String str2 = this.etag;
            if (str2 != null) {
                str = "If-None-Match";
            } else {
                if (date2 != null) {
                    str2 = this.lastModifiedString;
                } else {
                    if (date == null) {
                        return new CacheStrategy(request, null);
                    }
                    str2 = this.servedDateString;
                }
                str = "If-Modified-Since";
            }
            Dispatcher dispatcherNewBuilder = request.newBuilder();
            Headers.Builder builder = (Headers.Builder) dispatcherNewBuilder.runningAsyncCalls;
            builder.getClass();
            Headers.Companion.checkName(str);
            Headers.Companion.checkValue(str2, str);
            builder.addLenient$okhttp(str, str2);
            return new CacheStrategy(dispatcherNewBuilder.build(), cacheResponse);
        }
    }

    public CacheStrategy(Request request, CacheResponse cacheResponse) {
        this.networkRequest = request;
        this.cacheResponse = cacheResponse;
    }
}
