package dev.chrisbanes.haze;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.RenderScript;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.MultiParagraph$$ExternalSyntheticLambda0;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.tracing.Trace;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.android.HandlerContext;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RenderScriptBlurEffect implements BlurEffect {
    public static boolean isEnabled = true;
    public final GraphicsLayer contentLayer;
    public StandaloneCoroutine currentJob;
    public final CanvasDrawScope drawScope = new CanvasDrawScope();
    public boolean drawSkipped;
    public final HazeEffectNode node;
    public final RenderScript renderScript;
    public RenderScriptContext renderScriptContext;

    public RenderScriptBlurEffect(HazeEffectNode hazeEffectNode) {
        this.node = hazeEffectNode;
        this.renderScript = RenderScript.create((Context) HitTestResultKt.currentValueOf(hazeEffectNode, AndroidCompositionLocals_androidKt.LocalContext));
        this.contentLayer = ((GraphicsContext) HitTestResultKt.currentValueOf(hazeEffectNode, CompositionLocalsKt.LocalGraphicsContext)).createGraphicsLayer();
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:46:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:48:0x00f3 A[Catch: all -> 0x0177, TRY_LEAVE, TryCatch #4 {all -> 0x0177, blocks: (B:43:0x00e5, B:48:0x00f3, B:71:0x017a, B:79:0x01a4, B:80:0x01a7), top: B:89:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x011e  */
    /* JADX WARN: Code duplicated, block: B:71:0x017a A[Catch: all -> 0x0177, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x0177, blocks: (B:43:0x00e5, B:48:0x00f3, B:71:0x017a, B:79:0x01a4, B:80:0x01a7), top: B:89:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.compose.ui.graphics.layer.GraphicsLayer] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v2, types: [androidx.compose.ui.graphics.layer.GraphicsLayer, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v2, types: [dev.chrisbanes.haze.RenderScriptBlurEffect$updateSurface$1, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r6v3, types: [kotlinx.coroutines.channels.BufferedChannel] */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v4, types: [int] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [int] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final Object access$updateSurface(RenderScriptBlurEffect renderScriptBlurEffect, GraphicsLayer graphicsLayer, float f, ContinuationImpl continuationImpl) throws Throwable {
        ?? renderScriptBlurEffect$updateSurface$1;
        ?? r15;
        String str;
        int i;
        Unit unit;
        Object obj;
        RenderScriptContext renderScriptContext;
        float f2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        String str2;
        ?? r1;
        String str3;
        DefaultScheduler defaultScheduler;
        RenderScriptBlurEffect$updateSurface$2$2$1 renderScriptBlurEffect$updateSurface$2$2$1;
        int i7;
        ?? r16;
        ?? r7;
        ?? r2 = graphicsLayer;
        HazeEffectNode hazeEffectNode = renderScriptBlurEffect.node;
        if (continuationImpl instanceof RenderScriptBlurEffect$updateSurface$1) {
            RenderScriptBlurEffect$updateSurface$1 renderScriptBlurEffect$updateSurface$2 = (RenderScriptBlurEffect$updateSurface$1) continuationImpl;
            int i8 = renderScriptBlurEffect$updateSurface$2.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                renderScriptBlurEffect$updateSurface$2.label = i8 - Integer.MIN_VALUE;
                renderScriptBlurEffect$updateSurface$1 = renderScriptBlurEffect$updateSurface$2;
            } else {
                renderScriptBlurEffect$updateSurface$1 = new RenderScriptBlurEffect$updateSurface$1(renderScriptBlurEffect, continuationImpl);
            }
        } else {
            renderScriptBlurEffect$updateSurface$1 = new RenderScriptBlurEffect$updateSurface$1(renderScriptBlurEffect, continuationImpl);
        }
        Object obj2 = renderScriptBlurEffect$updateSurface$1.result;
        int i9 = renderScriptBlurEffect$updateSurface$1.label;
        ?? r8 = 0;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            try {
                if (i9 != 0) {
                    try {
                        try {
                            if (i9 == 1) {
                                int i10 = renderScriptBlurEffect$updateSurface$1.I$4;
                                i3 = renderScriptBlurEffect$updateSurface$1.I$3;
                                int i11 = renderScriptBlurEffect$updateSurface$1.I$2;
                                i5 = renderScriptBlurEffect$updateSurface$1.I$1;
                                i6 = renderScriptBlurEffect$updateSurface$1.I$0;
                                f2 = renderScriptBlurEffect$updateSurface$1.F$0;
                                str = renderScriptBlurEffect$updateSurface$1.L$7;
                                RenderScriptContext renderScriptContext2 = renderScriptBlurEffect$updateSurface$1.L$4;
                                String str4 = renderScriptBlurEffect$updateSurface$1.L$2;
                                GraphicsLayer graphicsLayer2 = renderScriptBlurEffect$updateSurface$1.L$0;
                                try {
                                    ResultKt.throwOnFailure(obj2);
                                    i2 = i10;
                                    r1 = graphicsLayer2;
                                    renderScriptContext = renderScriptContext2;
                                    i4 = i11;
                                    str2 = str4;
                                    try {
                                        Unit unit2 = Unit.INSTANCE;
                                        Trace.endAsyncSection(str, 0);
                                        if (!hazeEffectNode.isAttached) {
                                            r7 = i4;
                                            r16 = str2;
                                        } else {
                                            if (f2 > 0.0f) {
                                                Trace.beginAsyncSection("Haze-RenderScriptBlurEffect-updateSurface-applyBlur");
                                                try {
                                                    defaultScheduler = Dispatchers.Default;
                                                    renderScriptBlurEffect$updateSurface$2$2$1 = new RenderScriptBlurEffect$updateSurface$2$2$1(renderScriptContext, f2, null);
                                                    renderScriptBlurEffect$updateSurface$1.L$0 = null;
                                                    renderScriptBlurEffect$updateSurface$1.L$2 = str2;
                                                    renderScriptBlurEffect$updateSurface$1.L$4 = renderScriptContext;
                                                    renderScriptBlurEffect$updateSurface$1.L$7 = "Haze-RenderScriptBlurEffect-updateSurface-applyBlur";
                                                    renderScriptBlurEffect$updateSurface$1.F$0 = f2;
                                                    renderScriptBlurEffect$updateSurface$1.I$0 = i6;
                                                    renderScriptBlurEffect$updateSurface$1.I$1 = i5;
                                                    renderScriptBlurEffect$updateSurface$1.I$2 = i4 == true ? 1 : 0;
                                                    renderScriptBlurEffect$updateSurface$1.I$3 = i3;
                                                    renderScriptBlurEffect$updateSurface$1.I$4 = i2;
                                                    renderScriptBlurEffect$updateSurface$1.label = 2;
                                                    if (JobKt.withContext(defaultScheduler, renderScriptBlurEffect$updateSurface$2$2$1, renderScriptBlurEffect$updateSurface$1) != coroutineSingletons) {
                                                        str3 = "Haze-RenderScriptBlurEffect-updateSurface-applyBlur";
                                                        r2 = i4 == true ? 1 : 0;
                                                        renderScriptBlurEffect$updateSurface$1 = str2;
                                                    }
                                                    obj = unit;
                                                    obj = objReceive;
                                                    return coroutineSingletons;
                                                } catch (Throwable th) {
                                                    th = th;
                                                    str3 = "Haze-RenderScriptBlurEffect-updateSurface-applyBlur";
                                                    boolean z = i4 == true ? 1 : 0;
                                                    i7 = 0;
                                                    Trace.endAsyncSection(str3, i7);
                                                    throw th;
                                                }
                                            }
                                            renderScriptBlurEffect.contentLayer.m476recordmLhObY(HitTestResultKt.requireLayoutNode(hazeEffectNode).density, (LayoutDirection) HitTestResultKt.currentValueOf(hazeEffectNode, CompositionLocalsKt.LocalLayoutDirection), r1.size, new RenderScriptBlurEffect$updateSurface$2$4(0, r1));
                                            r7 = i4;
                                            r16 = str2;
                                        }
                                        Trace.endAsyncSection(r16, r7);
                                        return Unit.INSTANCE;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        i = 0;
                                        Trace.endAsyncSection(str, i);
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    i = 0;
                                    Trace.endAsyncSection(str, i);
                                    throw th;
                                }
                            }
                            if (i9 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            int i12 = renderScriptBlurEffect$updateSurface$1.I$2;
                            str3 = renderScriptBlurEffect$updateSurface$1.L$7;
                            renderScriptContext = renderScriptBlurEffect$updateSurface$1.L$4;
                            String str5 = renderScriptBlurEffect$updateSurface$1.L$2;
                            try {
                                ResultKt.throwOnFailure(obj2);
                                r2 = i12;
                                renderScriptBlurEffect$updateSurface$1 = str5;
                            } catch (Throwable th4) {
                                th = th4;
                                i7 = 0;
                            }
                            Bitmap bitmap = renderScriptContext.outputBitmap;
                            renderScriptBlurEffect.contentLayer.m476recordmLhObY(HitTestResultKt.requireLayoutNode(hazeEffectNode).density, (LayoutDirection) HitTestResultKt.currentValueOf(hazeEffectNode, CompositionLocalsKt.LocalLayoutDirection), (((long) bitmap.getWidth()) << 32) | (((long) bitmap.getHeight()) & 4294967295L), new RenderScriptBlurEffect$updateSurface$2$4(5, bitmap));
                            android.os.Trace.endSection();
                            r7 = r2;
                            r16 = renderScriptBlurEffect$updateSurface$1;
                            Trace.endAsyncSection(r16, r7);
                            return Unit.INSTANCE;
                        } catch (Throwable th5) {
                            android.os.Trace.endSection();
                            throw th5;
                        }
                        Unit unit3 = Unit.INSTANCE;
                        Trace.endAsyncSection(str3, 0);
                        Trace.beginSection("Haze-RenderScriptBlurEffect-updateSurface-drawToContentLayer");
                    } catch (Throwable th6) {
                        th = th6;
                        i7 = 0;
                        Trace.endAsyncSection(str3, i7);
                        throw th;
                    }
                } else {
                    ResultKt.throwOnFailure(obj2);
                    String str6 = "Haze-RenderScriptBlurEffect-updateSurface";
                    Trace.beginAsyncSection("Haze-RenderScriptBlurEffect-updateSurface");
                    try {
                        long j = r2.size;
                        try {
                            RenderScriptContext renderScriptContext3 = renderScriptBlurEffect.renderScriptContext;
                            if (renderScriptContext3 == null || !IntSize.m720equalsimpl0(renderScriptContext3.size, j)) {
                                if (renderScriptContext3 != null) {
                                    renderScriptContext3.isDestroyed = true;
                                    renderScriptContext3.blurScript.destroy();
                                    renderScriptContext3.inputAlloc.destroy();
                                    renderScriptContext3.outputAlloc.destroy();
                                    renderScriptContext3.rs.destroy();
                                }
                                renderScriptContext3 = new RenderScriptContext(renderScriptBlurEffect.renderScript, j);
                                renderScriptBlurEffect.renderScriptContext = renderScriptContext3;
                            }
                            str = "Haze-RenderScriptBlurEffect-updateSurface-drawLayerToSurface";
                            Trace.beginAsyncSection("Haze-RenderScriptBlurEffect-updateSurface-drawLayerToSurface");
                            try {
                                HazeKt.access$drawGraphicsLayer(renderScriptContext3.inputAlloc.getSurface(), r2, HitTestResultKt.requireLayoutNode(hazeEffectNode).density, renderScriptBlurEffect.drawScope);
                                renderScriptBlurEffect$updateSurface$1.L$0 = r2;
                                renderScriptBlurEffect$updateSurface$1.L$2 = "Haze-RenderScriptBlurEffect-updateSurface";
                                renderScriptBlurEffect$updateSurface$1.L$4 = renderScriptContext3;
                                renderScriptBlurEffect$updateSurface$1.L$7 = "Haze-RenderScriptBlurEffect-updateSurface-drawLayerToSurface";
                                renderScriptBlurEffect$updateSurface$1.F$0 = f;
                                renderScriptBlurEffect$updateSurface$1.I$0 = 0;
                                renderScriptBlurEffect$updateSurface$1.I$1 = 0;
                                renderScriptBlurEffect$updateSurface$1.I$2 = 0;
                                renderScriptBlurEffect$updateSurface$1.I$3 = 0;
                                renderScriptBlurEffect$updateSurface$1.I$4 = 0;
                                renderScriptBlurEffect$updateSurface$1.label = 1;
                                Object objReceive = renderScriptContext3.channel.receive(renderScriptBlurEffect$updateSurface$1);
                                if (objReceive != coroutineSingletons) {
                                    unit = Unit.INSTANCE;
                                }
                                if (obj != coroutineSingletons) {
                                    obj = unit;
                                    obj = objReceive;
                                    renderScriptContext = renderScriptContext3;
                                    f2 = f;
                                    i2 = 0;
                                    i3 = 0;
                                    i4 = 0;
                                    i5 = 0;
                                    i6 = 0;
                                    r1 = r2;
                                    str2 = str6;
                                    Unit unit4 = Unit.INSTANCE;
                                    Trace.endAsyncSection(str, 0);
                                    if (!hazeEffectNode.isAttached) {
                                        r7 = i4;
                                        r16 = str2;
                                    } else if (f2 > 0.0f) {
                                        Trace.beginAsyncSection("Haze-RenderScriptBlurEffect-updateSurface-applyBlur");
                                        defaultScheduler = Dispatchers.Default;
                                        renderScriptBlurEffect$updateSurface$2$2$1 = new RenderScriptBlurEffect$updateSurface$2$2$1(renderScriptContext, f2, null);
                                        renderScriptBlurEffect$updateSurface$1.L$0 = null;
                                        renderScriptBlurEffect$updateSurface$1.L$2 = str2;
                                        renderScriptBlurEffect$updateSurface$1.L$4 = renderScriptContext;
                                        renderScriptBlurEffect$updateSurface$1.L$7 = "Haze-RenderScriptBlurEffect-updateSurface-applyBlur";
                                        renderScriptBlurEffect$updateSurface$1.F$0 = f2;
                                        renderScriptBlurEffect$updateSurface$1.I$0 = i6;
                                        renderScriptBlurEffect$updateSurface$1.I$1 = i5;
                                        renderScriptBlurEffect$updateSurface$1.I$2 = i4 == true ? 1 : 0;
                                        renderScriptBlurEffect$updateSurface$1.I$3 = i3;
                                        renderScriptBlurEffect$updateSurface$1.I$4 = i2;
                                        renderScriptBlurEffect$updateSurface$1.label = 2;
                                        if (JobKt.withContext(defaultScheduler, renderScriptBlurEffect$updateSurface$2$2$1, renderScriptBlurEffect$updateSurface$1) != coroutineSingletons) {
                                            str3 = "Haze-RenderScriptBlurEffect-updateSurface-applyBlur";
                                            r2 = i4 == true ? 1 : 0;
                                            renderScriptBlurEffect$updateSurface$1 = str2;
                                            Unit unit5 = Unit.INSTANCE;
                                            Trace.endAsyncSection(str3, 0);
                                            Trace.beginSection("Haze-RenderScriptBlurEffect-updateSurface-drawToContentLayer");
                                            Bitmap bitmap2 = renderScriptContext.outputBitmap;
                                            renderScriptBlurEffect.contentLayer.m476recordmLhObY(HitTestResultKt.requireLayoutNode(hazeEffectNode).density, (LayoutDirection) HitTestResultKt.currentValueOf(hazeEffectNode, CompositionLocalsKt.LocalLayoutDirection), (((long) bitmap2.getWidth()) << 32) | (((long) bitmap2.getHeight()) & 4294967295L), new RenderScriptBlurEffect$updateSurface$2$4(5, bitmap2));
                                            android.os.Trace.endSection();
                                            r7 = r2;
                                            r16 = renderScriptBlurEffect$updateSurface$1;
                                        }
                                    } else {
                                        renderScriptBlurEffect.contentLayer.m476recordmLhObY(HitTestResultKt.requireLayoutNode(hazeEffectNode).density, (LayoutDirection) HitTestResultKt.currentValueOf(hazeEffectNode, CompositionLocalsKt.LocalLayoutDirection), r1.size, new RenderScriptBlurEffect$updateSurface$2$4(0, r1));
                                        r7 = i4;
                                        r16 = str2;
                                    }
                                    Trace.endAsyncSection(r16, r7);
                                    return Unit.INSTANCE;
                                }
                                obj = unit;
                                obj = objReceive;
                                return coroutineSingletons;
                            } catch (Throwable th7) {
                                th = th7;
                                i = 0;
                                Trace.endAsyncSection(str, i);
                                throw th;
                            }
                        } catch (Throwable th8) {
                            th = th8;
                            r8 = 0;
                            r15 = str6;
                            Trace.endAsyncSection(r15, r8);
                            throw th;
                        }
                    } catch (Throwable th9) {
                        th = th9;
                        r15 = str6;
                    }
                }
                Trace.endAsyncSection(str3, i7);
                throw th;
            } catch (Throwable th10) {
                th = th10;
                r8 = r2;
                r15 = renderScriptBlurEffect$updateSurface$1;
            }
        } catch (Throwable th11) {
            th = th11;
            r8 = 1;
        }
    }

    @Override // dev.chrisbanes.haze.BlurEffect
    public final void cleanup() {
        StandaloneCoroutine standaloneCoroutine = this.currentJob;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel((CancellationException) null);
        }
        ((GraphicsContext) HitTestResultKt.currentValueOf(this.node, CompositionLocalsKt.LocalGraphicsContext)).releaseGraphicsLayer(this.contentLayer);
        RenderScriptContext renderScriptContext = this.renderScriptContext;
        if (renderScriptContext != null) {
            renderScriptContext.isDestroyed = true;
            renderScriptContext.blurScript.destroy();
            renderScriptContext.inputAlloc.destroy();
            renderScriptContext.outputAlloc.destroy();
            renderScriptContext.rs.destroy();
        }
    }

    @Override // dev.chrisbanes.haze.BlurEffect
    public final void drawEffect(LayoutNodeDrawScope layoutNodeDrawScope) throws Throwable {
        LayoutNodeDrawScope layoutNodeDrawScope2;
        HazeEffectNode hazeEffectNode;
        StandaloneCoroutine standaloneCoroutine;
        RenderScriptBlurEffect renderScriptBlurEffect = this;
        StaticProvidableCompositionLocal staticProvidableCompositionLocal = AndroidCompositionLocals_androidKt.LocalContext;
        HazeEffectNode hazeEffectNode2 = renderScriptBlurEffect.node;
        Context context = (Context) HitTestResultKt.currentValueOf(hazeEffectNode2, staticProvidableCompositionLocal);
        long j = hazeEffectNode2.layerOffset;
        Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
        float fM824calculateInputScaleFactor3ABfNKs$default = HazeEffectNodeKt.m824calculateInputScaleFactor3ABfNKs$default(hazeEffectNode2);
        ref$FloatRef.element = fM824calculateInputScaleFactor3ABfNKs$default;
        Ref$FloatRef ref$FloatRef2 = new Ref$FloatRef();
        layoutNodeDrawScope.getDensity();
        float fMo92toPx0680j_4 = layoutNodeDrawScope.mo92toPx0680j_4(HazeEffectNodeKt.resolveBlurRadius(hazeEffectNode2)) * fM824calculateInputScaleFactor3ABfNKs$default;
        ref$FloatRef2.element = fMo92toPx0680j_4;
        if (fMo92toPx0680j_4 > 25.0f) {
            ref$FloatRef.element = (25.0f / fMo92toPx0680j_4) * ref$FloatRef.element;
            ref$FloatRef2.element = 25.0f;
        }
        GraphicsLayer graphicsLayer = renderScriptBlurEffect.contentLayer;
        if (IntSize.m720equalsimpl0(graphicsLayer.size, 0L) || (standaloneCoroutine = renderScriptBlurEffect.currentJob) == null || !standaloneCoroutine.isActive()) {
            renderScriptBlurEffect.drawSkipped = false;
            GraphicsLayer graphicsLayerM825createScaledContentLayerwZMzALA = HazeKt.m825createScaledContentLayerwZMzALA(layoutNodeDrawScope, hazeEffectNode2, ref$FloatRef.element, hazeEffectNode2.layerSize, j);
            layoutNodeDrawScope2 = layoutNodeDrawScope;
            if (graphicsLayerM825createScaledContentLayerwZMzALA != null) {
                graphicsLayerM825createScaledContentLayerwZMzALA.setClip(hazeEffectNode2.blurredEdgeTreatment != null);
                Continuation continuation = null;
                if (IntSize.m720equalsimpl0(graphicsLayer.size, 0L)) {
                    hazeEffectNode = hazeEffectNode2;
                    JobKt.runBlocking(EmptyCoroutineContext.INSTANCE, new RenderScriptBlurEffect$drawEffect$2$1(renderScriptBlurEffect, graphicsLayerM825createScaledContentLayerwZMzALA, ref$FloatRef2, continuation, 0));
                    renderScriptBlurEffect = this;
                } else {
                    hazeEffectNode = hazeEffectNode2;
                    CoroutineScope coroutineScope = hazeEffectNode.getCoroutineScope();
                    DefaultScheduler defaultScheduler = Dispatchers.Default;
                    renderScriptBlurEffect = this;
                    renderScriptBlurEffect.currentJob = JobKt.launch$default(coroutineScope, ((HandlerContext) MainDispatcherLoader.dispatcher).immediate, new RenderScriptBlurEffect$drawEffect$2$1(renderScriptBlurEffect, graphicsLayerM825createScaledContentLayerwZMzALA, ref$FloatRef2, continuation, 1), 2);
                }
            } else {
                hazeEffectNode = hazeEffectNode2;
            }
        } else {
            renderScriptBlurEffect.drawSkipped = true;
            layoutNodeDrawScope2 = layoutNodeDrawScope;
            hazeEffectNode = hazeEffectNode2;
        }
        GraphicsContext graphicsContext = (GraphicsContext) HitTestResultKt.currentValueOf(hazeEffectNode, CompositionLocalsKt.LocalGraphicsContext);
        GraphicsLayer graphicsLayerCreateGraphicsLayer = graphicsContext.createGraphicsLayer();
        try {
            graphicsLayerCreateGraphicsLayer.setAlpha(hazeEffectNode.alpha);
            Object obj = HazeEffectNodeKt.renderEffectCache$delegate;
            graphicsLayerCreateGraphicsLayer.setClip(hazeEffectNode.blurredEdgeTreatment != null);
            layoutNodeDrawScope2.mo475recordJVtK1S4(graphicsLayerCreateGraphicsLayer, IntSizeKt.m723toIntSizeuvyYCjk(layoutNodeDrawScope2.mo474getSizeNHjbRc()), new MultiParagraph$$ExternalSyntheticLambda0(j, ref$FloatRef, renderScriptBlurEffect, context));
            GraphicsLayerKt.drawLayer(layoutNodeDrawScope2, graphicsLayerCreateGraphicsLayer);
            Unit unit = Unit.INSTANCE;
        } finally {
            graphicsContext.releaseGraphicsLayer(graphicsLayerCreateGraphicsLayer);
        }
    }
}
