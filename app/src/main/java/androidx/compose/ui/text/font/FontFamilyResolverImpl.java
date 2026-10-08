package androidx.compose.ui.text.font;

import android.graphics.Typeface;
import androidx.camera.camera2.internal.CameraIdUtil;
import androidx.collection.LruCache;
import androidx.compose.ui.platform.AndroidUriHandler;
import androidx.compose.ui.text.platform.DispatcherKt;
import coil.disk.DiskLruCache$$ExternalSyntheticLambda0;
import coil.network.EmptyNetworkObserver;
import coil.request.Parameters;
import coil.request.RequestService;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.SupervisorJobImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FontFamilyResolverImpl implements FontFamily$Resolver {
    public final FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter;
    public final Parameters.Builder platformFamilyTypefaceAdapter;
    public final AndroidUriHandler platformFontLoader;
    public final AndroidFontResolveInterceptor platformResolveInterceptor;
    public final RequestService typefaceRequestCache;

    public FontFamilyResolverImpl(AndroidUriHandler androidUriHandler, AndroidFontResolveInterceptor androidFontResolveInterceptor) {
        RequestService requestService = FontFamilyResolverKt.GlobalTypefaceRequestCache;
        RequestService requestService2 = FontFamilyResolverKt.GlobalTypefaceRequestCache;
        FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter = new FontListFontFamilyTypefaceAdapter();
        FontListFontFamilyTypefaceAdapter$special$$inlined$CoroutineExceptionHandler$1 fontListFontFamilyTypefaceAdapter$special$$inlined$CoroutineExceptionHandler$1 = FontListFontFamilyTypefaceAdapter.DropExceptionHandler;
        MainCoroutineDispatcher mainCoroutineDispatcher = DispatcherKt.FontCacheManagementDispatcher;
        fontListFontFamilyTypefaceAdapter$special$$inlined$CoroutineExceptionHandler$1.getClass();
        JobKt.CoroutineScope(CameraIdUtil.plus(fontListFontFamilyTypefaceAdapter$special$$inlined$CoroutineExceptionHandler$1, mainCoroutineDispatcher).plus(EmptyCoroutineContext.INSTANCE).plus(new SupervisorJobImpl(null)));
        Parameters.Builder builder = new Parameters.Builder(11);
        this.platformFontLoader = androidUriHandler;
        this.platformResolveInterceptor = androidFontResolveInterceptor;
        this.typefaceRequestCache = requestService;
        this.fontListFontFamilyTypefaceAdapter = fontListFontFamilyTypefaceAdapter;
        this.platformFamilyTypefaceAdapter = builder;
        new DiskLruCache$$ExternalSyntheticLambda0(3, this);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0058  */
    /* JADX WARN: Code duplicated, block: B:42:0x007b A[Catch: Exception -> 0x0083, TRY_ENTER, TryCatch #2 {Exception -> 0x0083, blocks: (B:15:0x0027, B:17:0x003a, B:20:0x003f, B:22:0x0043, B:25:0x0050, B:42:0x007b, B:43:0x0082, B:24:0x004c), top: B:53:0x0027 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final TypefaceResult$Immutable resolve(TypefaceRequest typefaceRequest) {
        Typeface typefaceMo657createDefaultFO1MlWM;
        TypefaceResult$Immutable typefaceResult$Immutable;
        RequestService requestService = this.typefaceRequestCache;
        synchronized (((EmptyNetworkObserver) requestService.systemCallbacks)) {
            TypefaceResult$Immutable typefaceResult$Immutable2 = (TypefaceResult$Immutable) ((LruCache) requestService.hardwareBitmapService).get(typefaceRequest);
            if (typefaceResult$Immutable2 != null) {
                if (typefaceResult$Immutable2.cacheable) {
                    return typefaceResult$Immutable2;
                }
            }
            try {
                this.fontListFontFamilyTypefaceAdapter.getClass();
                SystemFontFamily systemFontFamily = typefaceRequest.fontFamily;
                PlatformTypefaces platformTypefaces = (PlatformTypefaces) this.platformFamilyTypefaceAdapter.entries;
                int i = typefaceRequest.fontStyle;
                FontWeight fontWeight = typefaceRequest.fontWeight;
                if (systemFontFamily != null && !(systemFontFamily instanceof DefaultFontFamily)) {
                    if (systemFontFamily instanceof GenericFontFamily) {
                        typefaceMo657createDefaultFO1MlWM = platformTypefaces.mo658createNamedRetOiIg((GenericFontFamily) systemFontFamily, fontWeight, i);
                    } else {
                        typefaceResult$Immutable = null;
                    }
                    if (typefaceResult$Immutable != null) {
                        throw new IllegalStateException("Could not load font");
                    }
                    synchronized (((EmptyNetworkObserver) requestService.systemCallbacks)) {
                        try {
                            if (((LruCache) requestService.hardwareBitmapService).get(typefaceRequest) == null && typefaceResult$Immutable.cacheable) {
                                ((LruCache) requestService.hardwareBitmapService).put(typefaceRequest, typefaceResult$Immutable);
                            }
                            Unit unit = Unit.INSTANCE;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return typefaceResult$Immutable;
                }
                typefaceMo657createDefaultFO1MlWM = platformTypefaces.mo657createDefaultFO1MlWM(fontWeight, i);
                typefaceResult$Immutable = new TypefaceResult$Immutable(typefaceMo657createDefaultFO1MlWM);
                if (typefaceResult$Immutable != null) {
                    throw new IllegalStateException("Could not load font");
                }
                synchronized (((EmptyNetworkObserver) requestService.systemCallbacks)) {
                    if (((LruCache) requestService.hardwareBitmapService).get(typefaceRequest) == null) {
                        ((LruCache) requestService.hardwareBitmapService).put(typefaceRequest, typefaceResult$Immutable);
                    }
                    Unit unit2 = Unit.INSTANCE;
                    return typefaceResult$Immutable;
                }
            } catch (Exception e) {
                throw new IllegalStateException("Could not load font", e);
            }
        }
    }

    /* JADX INFO: renamed from: resolve-DPcqOEQ, reason: not valid java name */
    public final TypefaceResult$Immutable m656resolveDPcqOEQ(SystemFontFamily systemFontFamily, FontWeight fontWeight, int i, int i2) {
        AndroidFontResolveInterceptor androidFontResolveInterceptor = this.platformResolveInterceptor;
        androidFontResolveInterceptor.getClass();
        int i3 = androidFontResolveInterceptor.fontWeightAdjustment;
        FontWeight fontWeight2 = (i3 == 0 || i3 == Integer.MAX_VALUE) ? fontWeight : new FontWeight(RangesKt.coerceIn(fontWeight.weight + i3, 1, 1000));
        this.platformFontLoader.getClass();
        return resolve(new TypefaceRequest(systemFontFamily, fontWeight2, i, i2, null));
    }
}
