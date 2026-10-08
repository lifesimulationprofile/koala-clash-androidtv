package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.VectorizedAnimationSpec;
import kotlin.Function;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class UpdatableAnimationState {
    public static final AnimationVector1D ZeroVector = new AnimationVector1D(0.0f);
    public boolean isRunning;
    public long lastFrameTime = Long.MIN_VALUE;
    public AnimationVector1D lastVelocity = ZeroVector;
    public float value;
    public final VectorizedAnimationSpec vectorizedSpec;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends ContinuationImpl {
        public float F$0;
        public Function L$0;
        public Function0 L$1;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UpdatableAnimationState.this.animateToZero(null, null, this);
        }
    }

    public UpdatableAnimationState(AnimationSpec animationSpec) {
        this.vectorizedSpec = animationSpec.vectorize(ArcSplineKt.FloatToVector);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0073 A[Catch: all -> 0x0035, PHI: r13 r14 r15
      0x0073: PHI (r13v4 float) = (r13v2 float), (r13v5 float) binds: [B:29:0x006d, B:37:0x00a1] A[DONT_GENERATE, DONT_INLINE]
      0x0073: PHI (r14v7 kotlin.jvm.functions.Function1) = (r14v1 kotlin.jvm.functions.Function1), (r14v8 kotlin.jvm.functions.Function1) binds: [B:29:0x006d, B:37:0x00a1] A[DONT_GENERATE, DONT_INLINE]
      0x0073: PHI (r15v16 kotlin.jvm.functions.Function0) = (r15v8 kotlin.jvm.functions.Function0), (r15v17 kotlin.jvm.functions.Function0) binds: [B:29:0x006d, B:37:0x00a1] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #0 {all -> 0x0035, blocks: (B:13:0x0030, B:45:0x00ca, B:20:0x0048, B:36:0x009c, B:30:0x0073, B:39:0x00a4, B:42:0x00af, B:33:0x0082), top: B:50:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0082 A[Catch: all -> 0x0035, TryCatch #0 {all -> 0x0035, blocks: (B:13:0x0030, B:45:0x00ca, B:20:0x0048, B:36:0x009c, B:30:0x0073, B:39:0x00a4, B:42:0x00af, B:33:0x0082), top: B:50:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x009b  */
    /* JADX WARN: Code duplicated, block: B:36:0x009c A[Catch: all -> 0x0035, PHI: r13 r14 r15
      0x009c: PHI (r13v5 float) = (r13v4 float), (r13v8 float) binds: [B:34:0x0099, B:21:0x004b] A[DONT_GENERATE, DONT_INLINE]
      0x009c: PHI (r14v8 kotlin.jvm.functions.Function1) = (r14v7 kotlin.jvm.functions.Function1), (r14v10 kotlin.jvm.functions.Function1) binds: [B:34:0x0099, B:21:0x004b] A[DONT_GENERATE, DONT_INLINE]
      0x009c: PHI (r15v17 kotlin.jvm.functions.Function0) = (r15v16 kotlin.jvm.functions.Function0), (r15v18 kotlin.jvm.functions.Function0) binds: [B:34:0x0099, B:21:0x004b] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {all -> 0x0035, blocks: (B:13:0x0030, B:45:0x00ca, B:20:0x0048, B:36:0x009c, B:30:0x0073, B:39:0x00a4, B:42:0x00af, B:33:0x0082), top: B:50:0x0026 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0099 -> B:36:0x009c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object animateToZero(androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda1 r13, androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0 r14, kotlin.coroutines.jvm.internal.ContinuationImpl r15) {
        /*
            Method dump skipped, instruction units count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.UpdatableAnimationState.animateToZero(androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda1, androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
