package okhttp3.internal.cache;

import java.util.ArrayList;
import java.util.Arrays;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.ResponseBody$Companion$asResponseBody$1;
import okhttp3.internal.Util;
import okhttp3.internal.http.RealInterceptorChain;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CacheInterceptor implements Interceptor {

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Companion {
        public static final Response access$stripBody(Response response) {
            if ((response != null ? response.body : null) == null) {
                return response;
            }
            Response.Builder builderNewBuilder = response.newBuilder();
            builderNewBuilder.body = null;
            return builderNewBuilder.build();
        }

        public static boolean isEndToEnd(String str) {
            return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
        }
    }

    @Override // okhttp3.Interceptor
    public final Response intercept(RealInterceptorChain realInterceptorChain) throws Throwable {
        int i;
        System.currentTimeMillis();
        Request request = realInterceptorChain.request;
        Throwable th = null;
        CacheStrategy cacheStrategy = new CacheStrategy(0, request, (Object) null);
        if (request != null && request.cacheControl().onlyIfCached) {
            cacheStrategy = new CacheStrategy(0, (Object) null, (Object) null);
        }
        Request request2 = (Request) cacheStrategy.networkRequest;
        Response response = (Response) cacheStrategy.cacheResponse;
        if (request2 == null && response == null) {
            ArrayList arrayList = new ArrayList(20);
            ResponseBody$Companion$asResponseBody$1 responseBody$Companion$asResponseBody$1 = Util.EMPTY_RESPONSE;
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (request == null) {
                throw new IllegalStateException("request == null");
            }
            return new Response(request, Protocol.HTTP_1_1, "Unsatisfiable Request (only-if-cached)", 504, null, new Headers((String[]) arrayList.toArray(new String[0])), responseBody$Companion$asResponseBody$1, null, null, null, -1L, jCurrentTimeMillis, null);
        }
        if (request2 == null) {
            Response.Builder builderNewBuilder = response.newBuilder();
            Response responseAccess$stripBody = Companion.access$stripBody(response);
            Response.Builder.checkSupportResponse("cacheResponse", responseAccess$stripBody);
            builderNewBuilder.cacheResponse = responseAccess$stripBody;
            return builderNewBuilder.build();
        }
        Response responseProceed = realInterceptorChain.proceed(request2);
        if (response != null) {
            if (responseProceed.code == 304) {
                Response.Builder builderNewBuilder2 = response.newBuilder();
                Headers headers = response.headers;
                Headers headers2 = responseProceed.headers;
                ArrayList arrayList2 = new ArrayList(20);
                int size = headers.size();
                int i2 = 0;
                while (i2 < size) {
                    String strName = headers.name(i2);
                    Throwable th2 = th;
                    String strValue = headers.value(i2);
                    if ("Warning".equalsIgnoreCase(strName)) {
                        i = size;
                        if (StringsKt__StringsJVMKt.startsWith(strValue, "1", false)) {
                        }
                        i2++;
                        size = i;
                        th = th2;
                    } else {
                        i = size;
                    }
                    if ("Content-Length".equalsIgnoreCase(strName) || "Content-Encoding".equalsIgnoreCase(strName) || "Content-Type".equalsIgnoreCase(strName) || !Companion.isEndToEnd(strName) || headers2.get(strName) == null) {
                        arrayList2.add(strName);
                        arrayList2.add(StringsKt.trim(strValue).toString());
                    }
                    i2++;
                    size = i;
                    th = th2;
                }
                Throwable th3 = th;
                int size2 = headers2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    String strName2 = headers2.name(i3);
                    if (!"Content-Length".equalsIgnoreCase(strName2) && !"Content-Encoding".equalsIgnoreCase(strName2) && !"Content-Type".equalsIgnoreCase(strName2) && Companion.isEndToEnd(strName2)) {
                        String strValue2 = headers2.value(i3);
                        arrayList2.add(strName2);
                        arrayList2.add(StringsKt.trim(strValue2).toString());
                    }
                }
                String[] strArr = (String[]) arrayList2.toArray(new String[0]);
                Headers.Builder builder = new Headers.Builder(0);
                ((ArrayList) builder.namesAndValues).addAll(Arrays.asList(strArr));
                builderNewBuilder2.headers = builder;
                builderNewBuilder2.sentRequestAtMillis = responseProceed.sentRequestAtMillis;
                builderNewBuilder2.receivedResponseAtMillis = responseProceed.receivedResponseAtMillis;
                Response responseAccess$stripBody2 = Companion.access$stripBody(response);
                Response.Builder.checkSupportResponse("cacheResponse", responseAccess$stripBody2);
                builderNewBuilder2.cacheResponse = responseAccess$stripBody2;
                Response responseAccess$stripBody3 = Companion.access$stripBody(responseProceed);
                Response.Builder.checkSupportResponse("networkResponse", responseAccess$stripBody3);
                builderNewBuilder2.networkResponse = responseAccess$stripBody3;
                builderNewBuilder2.build();
                responseProceed.body.close();
                throw th3;
            }
            ResponseBody responseBody = response.body;
            if (responseBody != null) {
                Util.closeQuietly(responseBody);
            }
        }
        Response.Builder builderNewBuilder3 = responseProceed.newBuilder();
        Response responseAccess$stripBody4 = Companion.access$stripBody(response);
        Response.Builder.checkSupportResponse("cacheResponse", responseAccess$stripBody4);
        builderNewBuilder3.cacheResponse = responseAccess$stripBody4;
        Response responseAccess$stripBody5 = Companion.access$stripBody(responseProceed);
        Response.Builder.checkSupportResponse("networkResponse", responseAccess$stripBody5);
        builderNewBuilder3.networkResponse = responseAccess$stripBody5;
        return builderNewBuilder3.build();
    }
}
