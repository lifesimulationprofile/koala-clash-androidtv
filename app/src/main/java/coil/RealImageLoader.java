package coil;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.camera.camera2.internal.CameraIdUtil;
import coil.compose.AsyncImagePainterKt$fakeTransitionTarget$1;
import coil.decode.BitmapFactoryDecoder;
import coil.fetch.FileFetcher;
import coil.fetch.HttpUriFetcher;
import coil.intercept.EngineInterceptor;
import coil.key.UriKeyer;
import coil.map.StringMapper;
import coil.request.DefaultRequestOptions;
import coil.request.ErrorResult;
import coil.request.ImageRequest;
import coil.request.RequestService;
import coil.target.Target;
import coil.transition.NoneTransition;
import coil.transition.Transition;
import coil.util.Collections;
import coil.util.SingletonDiskCache;
import coil.util.SystemCallbacks;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.SynchronizedLazyImpl;
import kotlin.collections.CollectionsKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorJobImpl;
import kotlinx.coroutines.android.HandlerContext;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.HttpUrl;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RealImageLoader {
    public final ComponentRegistry components;
    public final Context context;
    public final DefaultRequestOptions defaults;
    public final ArrayList interceptors;
    public final SynchronizedLazyImpl memoryCacheLazy;
    public final SingletonDiskCache options;
    public final RequestService requestService;

    public RealImageLoader(Context context, DefaultRequestOptions defaultRequestOptions, SynchronizedLazyImpl synchronizedLazyImpl, SynchronizedLazyImpl synchronizedLazyImpl2, SynchronizedLazyImpl synchronizedLazyImpl3, ComponentRegistry componentRegistry, SingletonDiskCache singletonDiskCache) {
        this.context = context;
        this.defaults = defaultRequestOptions;
        this.memoryCacheLazy = synchronizedLazyImpl;
        this.options = singletonDiskCache;
        SupervisorJobImpl supervisorJobImplSupervisorJob$default = JobKt.SupervisorJob$default();
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        JobKt.CoroutineScope(CameraIdUtil.plus(supervisorJobImplSupervisorJob$default, ((HandlerContext) MainDispatcherLoader.dispatcher).immediate).plus(new RealImageLoader$special$$inlined$CoroutineExceptionHandler$1(this)));
        SystemCallbacks systemCallbacks = new SystemCallbacks(this);
        RequestService requestService = new RequestService(this, systemCallbacks);
        this.requestService = requestService;
        Request request = new Request(componentRegistry);
        int i = 3;
        request.add(new StringMapper(i), HttpUrl.class);
        int i2 = 0;
        request.add(new StringMapper(i2), String.class);
        int i3 = 2;
        request.add(new StringMapper(i3), Uri.class);
        int i4 = 5;
        request.add(new StringMapper(i4), Uri.class);
        int i5 = 4;
        request.add(new StringMapper(i5), Integer.class);
        int i6 = 1;
        request.add(new StringMapper(i6), byte[].class);
        UriKeyer uriKeyer = new UriKeyer(0);
        ArrayList arrayList = (ArrayList) request.headers;
        arrayList.add(new Pair(uriKeyer, Uri.class));
        singletonDiskCache.getClass();
        arrayList.add(new Pair(new UriKeyer(1), File.class));
        request.add(new HttpUriFetcher.Factory(synchronizedLazyImpl3, synchronizedLazyImpl2), Uri.class);
        request.add(new FileFetcher.Factory(i2), File.class);
        request.add(new FileFetcher.Factory(i6), Uri.class);
        request.add(new FileFetcher.Factory(i5), Uri.class);
        request.add(new FileFetcher.Factory(6), Uri.class);
        request.add(new FileFetcher.Factory(i4), Drawable.class);
        request.add(new FileFetcher.Factory(i3), Bitmap.class);
        request.add(new FileFetcher.Factory(i), ByteBuffer.class);
        BitmapFactoryDecoder.Factory factory = new BitmapFactoryDecoder.Factory();
        ArrayList arrayList2 = (ArrayList) request.lazyCacheControl;
        arrayList2.add(factory);
        List immutableList = Collections.toImmutableList((ArrayList) request.url);
        this.components = new ComponentRegistry(immutableList, Collections.toImmutableList((ArrayList) request.method), Collections.toImmutableList(arrayList), Collections.toImmutableList((ArrayList) request.tags), Collections.toImmutableList(arrayList2));
        this.interceptors = CollectionsKt.plus(immutableList, new EngineInterceptor(this, systemCallbacks, requestService));
        new AtomicBoolean(false);
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00cc A[Catch: all -> 0x00d0, TryCatch #0 {all -> 0x00d0, blocks: (B:42:0x00c2, B:44:0x00cc, B:47:0x00d4, B:49:0x00df, B:50:0x00e2), top: B:96:0x00c2 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x00df A[Catch: all -> 0x00d0, TryCatch #0 {all -> 0x00d0, blocks: (B:42:0x00c2, B:44:0x00cc, B:47:0x00d4, B:49:0x00df, B:50:0x00e2), top: B:96:0x00c2 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:59:0x0126  */
    /* JADX WARN: Code duplicated, block: B:62:0x012e A[Catch: all -> 0x015a, TryCatch #3 {all -> 0x015a, blocks: (B:60:0x0128, B:62:0x012e, B:69:0x0150, B:65:0x013d, B:68:0x014a, B:74:0x015c, B:76:0x0160, B:79:0x0171, B:80:0x0176), top: B:102:0x0128 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x013c  */
    /* JADX WARN: Code duplicated, block: B:65:0x013d A[Catch: all -> 0x015a, TryCatch #3 {all -> 0x015a, blocks: (B:60:0x0128, B:62:0x012e, B:69:0x0150, B:65:0x013d, B:68:0x014a, B:74:0x015c, B:76:0x0160, B:79:0x0171, B:80:0x0176), top: B:102:0x0128 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x0149  */
    /* JADX WARN: Code duplicated, block: B:68:0x014a A[Catch: all -> 0x015a, TryCatch #3 {all -> 0x015a, blocks: (B:60:0x0128, B:62:0x012e, B:69:0x0150, B:65:0x013d, B:68:0x014a, B:74:0x015c, B:76:0x0160, B:79:0x0171, B:80:0x0176), top: B:102:0x0128 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x015c A[Catch: all -> 0x015a, TryCatch #3 {all -> 0x015a, blocks: (B:60:0x0128, B:62:0x012e, B:69:0x0150, B:65:0x013d, B:68:0x014a, B:74:0x015c, B:76:0x0160, B:79:0x0171, B:80:0x0176), top: B:102:0x0128 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x0160 A[Catch: all -> 0x015a, TRY_LEAVE, TryCatch #3 {all -> 0x015a, blocks: (B:60:0x0128, B:62:0x012e, B:69:0x0150, B:65:0x013d, B:68:0x014a, B:74:0x015c, B:76:0x0160, B:79:0x0171, B:80:0x0176), top: B:102:0x0128 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x0171 A[Catch: all -> 0x015a, TRY_ENTER, TryCatch #3 {all -> 0x015a, blocks: (B:60:0x0128, B:62:0x012e, B:69:0x0150, B:65:0x013d, B:68:0x014a, B:74:0x015c, B:76:0x0160, B:79:0x0171, B:80:0x0176), top: B:102:0x0128 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code duplicated, block: B:89:0x018c A[Catch: all -> 0x019b, TryCatch #4 {all -> 0x019b, blocks: (B:87:0x0188, B:89:0x018c, B:92:0x019d, B:93:0x01a6), top: B:103:0x0188 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x019d A[Catch: all -> 0x019b, TryCatch #4 {all -> 0x019b, blocks: (B:87:0x0188, B:89:0x018c, B:92:0x019d, B:93:0x01a6), top: B:103:0x0188 }] */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b9, code lost:
    
        if (coil.util.Lifecycles.awaitStarted(r0, r2) == r8) goto L58;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object access$executeMain(coil.RealImageLoader r20, coil.request.ImageRequest r21, int r22, kotlin.coroutines.jvm.internal.ContinuationImpl r23) {
        /*
            Method dump skipped, instruction units count: 429
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.RealImageLoader.access$executeMain(coil.RealImageLoader, coil.request.ImageRequest, int, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public static void onError(ErrorResult errorResult, Target target, EventListener$Companion$NONE$1 eventListener$Companion$NONE$1) {
        ImageRequest imageRequest = errorResult.request;
        if (target instanceof AsyncImagePainterKt$fakeTransitionTarget$1) {
            Transition transitionCreate = imageRequest.transitionFactory.create((AsyncImagePainterKt$fakeTransitionTarget$1) target, errorResult);
            if (!(transitionCreate instanceof NoneTransition)) {
                eventListener$Companion$NONE$1.getClass();
                transitionCreate.transition();
            }
        }
        eventListener$Companion$NONE$1.getClass();
        imageRequest.getClass();
    }
}
