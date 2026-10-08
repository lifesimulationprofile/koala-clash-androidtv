package coil.intercept;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil.EventListener$Companion$NONE$1;
import coil.request.ImageRequest;
import coil.request.Options;
import coil.size.Size;
import coil.util.DrawableUtils;
import coil.util.Utils;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class EngineInterceptor$transform$3 extends SuspendLambda implements Function2 {
    public final /* synthetic */ EventListener$Companion$NONE$1 $eventListener;
    public final /* synthetic */ Options $options;
    public final /* synthetic */ ImageRequest $request;
    public final /* synthetic */ EngineInterceptor.ExecuteResult $result;
    public final /* synthetic */ List $transformations;
    public int I$0;
    public int I$1;
    public /* synthetic */ Object L$0;
    public List L$1;
    public Options L$2;
    public int label;
    public final /* synthetic */ EngineInterceptor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EngineInterceptor$transform$3(EngineInterceptor engineInterceptor, EngineInterceptor.ExecuteResult executeResult, Options options, List list, EventListener$Companion$NONE$1 eventListener$Companion$NONE$1, ImageRequest imageRequest, Continuation continuation) {
        super(2, continuation);
        this.this$0 = engineInterceptor;
        this.$result = executeResult;
        this.$options = options;
        this.$transformations = list;
        this.$eventListener = eventListener$Companion$NONE$1;
        this.$request = imageRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        EngineInterceptor$transform$3 engineInterceptor$transform$3 = new EngineInterceptor$transform$3(this.this$0, this.$result, this.$options, this.$transformations, this.$eventListener, this.$request, continuation);
        engineInterceptor$transform$3.L$0 = obj;
        return engineInterceptor$transform$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((EngineInterceptor$transform$3) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0056  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        Options options;
        Bitmap bitmapConvertToBitmap;
        List list;
        int size;
        int i;
        int i2 = this.label;
        EventListener$Companion$NONE$1 eventListener$Companion$NONE$1 = this.$eventListener;
        EngineInterceptor.ExecuteResult executeResult = this.$result;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            Drawable drawable = executeResult.drawable;
            boolean z = drawable instanceof BitmapDrawable;
            options = this.$options;
            if (z) {
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                Bitmap.Config config = bitmap.getConfig();
                if (config == null) {
                    config = Bitmap.Config.ARGB_8888;
                }
                if (ArraysKt.contains(Utils.VALID_TRANSFORMATION_CONFIGS, config)) {
                    bitmapConvertToBitmap = bitmap;
                } else {
                    bitmapConvertToBitmap = DrawableUtils.convertToBitmap(drawable, options.config, options.size, options.scale, options.allowInexactSize);
                }
            } else {
                bitmapConvertToBitmap = DrawableUtils.convertToBitmap(drawable, options.config, options.size, options.scale, options.allowInexactSize);
            }
            eventListener$Companion$NONE$1.getClass();
            list = this.$transformations;
            size = list.size();
            i = 0;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            size = this.I$1;
            int i3 = this.I$0;
            options = this.L$2;
            list = this.L$1;
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            bitmapConvertToBitmap = (Bitmap) obj;
            JobKt.ensureActive(coroutineScope.getCoroutineContext());
            i = i3 + 1;
        }
        if (i >= size) {
            eventListener$Companion$NONE$1.getClass();
            return new EngineInterceptor.ExecuteResult(new BitmapDrawable(this.$request.context.getResources(), bitmapConvertToBitmap), executeResult.isSampled, executeResult.dataSource, executeResult.diskCacheKey);
        }
        if (list.get(i) != null) {
            throw new ClassCastException();
        }
        Size size2 = options.size;
        this.L$0 = coroutineScope;
        this.L$1 = list;
        this.L$2 = options;
        this.I$0 = i;
        this.I$1 = size;
        this.label = 1;
        throw null;
    }
}
