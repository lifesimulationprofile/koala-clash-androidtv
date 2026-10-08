package androidx.compose.ui;

import android.graphics.Path;
import android.graphics.RectF;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.compose.foundation.BackgroundNode;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.graphics.AndroidImageBitmap;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.input.key.Key_androidKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputResetException;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import androidx.compose.ui.layout.DefaultIntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.IntrinsicsMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetModifier$1;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.ObserverNodeOwnerScope;
import androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayout$1;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.navigation.compose.DialogHostKt$DialogHost$1$1$1;
import coil.network.HttpException;
import java.util.ArrayList;
import java.util.List;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.internal.ContextScope;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public interface Modifier {

    /* JADX INFO: renamed from: androidx.compose.ui.Modifier$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract /* synthetic */ class CC {
        public static int $default$maxIntrinsicHeight(LayoutModifier layoutModifier, LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
            int i2 = 2;
            return layoutModifier.mo170measure3p2s80s(new IntrinsicsMeasureScope(lookaheadCapablePlaceable, lookaheadCapablePlaceable.getLayoutDirection()), new DefaultIntrinsicMeasurable(measurable, i2, i2, 1), ConstraintsKt.Constraints$default(0, i, 0, 0, 13)).getHeight();
        }

        public static int $default$minIntrinsicWidth(LayoutModifier layoutModifier, LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
            int i2 = 1;
            return layoutModifier.mo170measure3p2s80s(new IntrinsicsMeasureScope(lookaheadCapablePlaceable, lookaheadCapablePlaceable.getLayoutDirection()), new DefaultIntrinsicMeasurable(measurable, i2, i2, 1), ConstraintsKt.Constraints$default(0, 0, 0, i, 7)).getWidth();
        }

        public static Modifier $default$then(Modifier modifier, Modifier modifier2) {
            return modifier2 == Companion.$$INSTANCE ? modifier : new CombinedModifier(modifier, modifier2);
        }

        /* JADX INFO: renamed from: $private$offsetSize-PENXr5M, reason: not valid java name */
        public static long m306$private$offsetSizePENXr5M(long j, long j2) {
            float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) - Float.intBitsToFloat((int) (j2 >> 32));
            float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L)) - Float.intBitsToFloat((int) (j2 & 4294967295L));
            return (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L);
        }

        /* JADX INFO: renamed from: addPath-Uv8p0NA$default, reason: not valid java name */
        public static void m307addPathUv8p0NA$default(AndroidPath androidPath, AndroidPath androidPath2) {
            Path path = androidPath.internalPath;
            if (!(androidPath2 instanceof AndroidPath)) {
                throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
            }
            path.addPath(androidPath2.internalPath, Float.intBitsToFloat((int) 0), Float.intBitsToFloat((int) 0));
        }

        public static void addRect$default(AndroidPath androidPath, Rect rect) {
            Path.Direction direction;
            androidPath.getClass();
            float f = rect.left;
            float f2 = rect.bottom;
            float f3 = rect.right;
            float f4 = rect.top;
            if (Float.isNaN(f) || Float.isNaN(f4) || Float.isNaN(f3) || Float.isNaN(f2)) {
                AndroidPath_androidKt.throwIllegalStateException("Invalid rectangle, make sure no value is NaN");
            }
            if (androidPath.rectF == null) {
                androidPath.rectF = new RectF();
            }
            androidPath.rectF.set(f, f4, f3, f2);
            Path path = androidPath.internalPath;
            RectF rectF = androidPath.rectF;
            int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(1);
            if (iOrdinal == 0) {
                direction = Path.Direction.CCW;
            } else {
                if (iOrdinal != 1) {
                    throw new HttpException();
                }
                direction = Path.Direction.CW;
            }
            path.addRect(rectF, direction);
        }

        public static void addRoundRect$default(AndroidPath androidPath, RoundRect roundRect) {
            Path.Direction direction;
            if (androidPath.rectF == null) {
                androidPath.rectF = new RectF();
            }
            RectF rectF = androidPath.rectF;
            float f = roundRect.left;
            long j = roundRect.bottomLeftCornerRadius;
            long j2 = roundRect.bottomRightCornerRadius;
            long j3 = roundRect.topRightCornerRadius;
            long j4 = roundRect.topLeftCornerRadius;
            rectF.set(f, roundRect.top, roundRect.right, roundRect.bottom);
            if (androidPath.radii == null) {
                androidPath.radii = new float[8];
            }
            float[] fArr = androidPath.radii;
            fArr[0] = Float.intBitsToFloat((int) (j4 >> 32));
            fArr[1] = Float.intBitsToFloat((int) (j4 & 4294967295L));
            fArr[2] = Float.intBitsToFloat((int) (j3 >> 32));
            fArr[3] = Float.intBitsToFloat((int) (j3 & 4294967295L));
            fArr[4] = Float.intBitsToFloat((int) (j2 >> 32));
            fArr[5] = Float.intBitsToFloat((int) (j2 & 4294967295L));
            fArr[6] = Float.intBitsToFloat((int) (j >> 32));
            fArr[7] = Float.intBitsToFloat((int) (j & 4294967295L));
            Path path = androidPath.internalPath;
            RectF rectF2 = androidPath.rectF;
            float[] fArr2 = androidPath.radii;
            int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(1);
            if (iOrdinal == 0) {
                direction = Path.Direction.CCW;
            } else {
                if (iOrdinal != 1) {
                    throw new HttpException();
                }
                direction = Path.Direction.CW;
            }
            path.addRoundRect(rectF2, fArr2, direction);
        }

        public static /* synthetic */ Object awaitPointerEvent$default(SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine, BaseContinuationImpl baseContinuationImpl) {
            return pointerEventHandlerCoroutine.awaitPointerEvent(PointerEventPass.Main, baseContinuationImpl);
        }

        /* JADX INFO: renamed from: drawCircle-VaOC9Bg$default, reason: not valid java name */
        public static /* synthetic */ void m308drawCircleVaOC9Bg$default(DrawScope drawScope, long j, float f, long j2, DrawStyle drawStyle, int i) {
            if ((i & 4) != 0) {
                j2 = drawScope.mo473getCenterF1C5BW0();
            }
            long j3 = j2;
            if ((i & 16) != 0) {
                drawStyle = Fill.INSTANCE;
            }
            drawScope.mo463drawCircleVaOC9Bg(j, f, j3, drawStyle);
        }

        /* JADX INFO: renamed from: drawImage-gbVJVH8$default, reason: not valid java name */
        public static /* synthetic */ void m310drawImagegbVJVH8$default(DrawScope drawScope, AndroidImageBitmap androidImageBitmap, long j, float f, BlendModeColorFilter blendModeColorFilter, int i, int i2) {
            if ((i2 & 2) != 0) {
                j = 0;
            }
            long j2 = j;
            if ((i2 & 4) != 0) {
                f = 1.0f;
            }
            float f2 = f;
            if ((i2 & 16) != 0) {
                blendModeColorFilter = null;
            }
            BlendModeColorFilter blendModeColorFilter2 = blendModeColorFilter;
            if ((i2 & 32) != 0) {
                i = 3;
            }
            drawScope.mo465drawImagegbVJVH8(androidImageBitmap, j2, f2, blendModeColorFilter2, i);
        }

        /* JADX INFO: renamed from: drawPath-GBMwjPU$default, reason: not valid java name */
        public static /* synthetic */ void m312drawPathGBMwjPU$default(DrawScope drawScope, AndroidPath androidPath, Brush brush, float f, Stroke stroke, BlendModeColorFilter blendModeColorFilter, int i, int i2) {
            if ((i2 & 4) != 0) {
                f = 1.0f;
            }
            float f2 = f;
            DrawStyle drawStyle = stroke;
            if ((i2 & 8) != 0) {
                drawStyle = Fill.INSTANCE;
            }
            DrawStyle drawStyle2 = drawStyle;
            if ((i2 & 16) != 0) {
                blendModeColorFilter = null;
            }
            BlendModeColorFilter blendModeColorFilter2 = blendModeColorFilter;
            if ((i2 & 32) != 0) {
                i = 3;
            }
            drawScope.mo467drawPathGBMwjPU(androidPath, brush, f2, drawStyle2, blendModeColorFilter2, i);
        }

        /* JADX INFO: renamed from: drawPath-LG529CI$default, reason: not valid java name */
        public static /* synthetic */ void m313drawPathLG529CI$default(DrawScope drawScope, AndroidPath androidPath, long j, DrawStyle drawStyle, int i) {
            if ((i & 8) != 0) {
                drawStyle = Fill.INSTANCE;
            }
            drawScope.mo468drawPathLG529CI(androidPath, j, drawStyle);
        }

        /* JADX INFO: renamed from: drawRect-AsUm42w$default, reason: not valid java name */
        public static /* synthetic */ void m314drawRectAsUm42w$default(DrawScope drawScope, Brush brush, long j, long j2, float f, DrawStyle drawStyle, BlendModeColorFilter blendModeColorFilter, int i, int i2) {
            if ((i2 & 2) != 0) {
                j = 0;
            }
            long j3 = j;
            drawScope.mo469drawRectAsUm42w(brush, j3, (i2 & 4) != 0 ? m306$private$offsetSizePENXr5M(drawScope.mo474getSizeNHjbRc(), j3) : j2, (i2 & 8) != 0 ? 1.0f : f, (i2 & 16) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 32) != 0 ? null : blendModeColorFilter, (i2 & 64) != 0 ? 3 : i);
        }

        /* JADX INFO: renamed from: drawRect-n-J9OG0$default, reason: not valid java name */
        public static /* synthetic */ void m315drawRectnJ9OG0$default(DrawScope drawScope, long j, long j2, float f, int i, int i2) {
            if ((i2 & 4) != 0) {
                j2 = m306$private$offsetSizePENXr5M(drawScope.mo474getSizeNHjbRc(), 0L);
            }
            long j3 = j2;
            if ((i2 & 8) != 0) {
                f = 1.0f;
            }
            drawScope.mo470drawRectnJ9OG0(j, 0L, j3, f, (i2 & 64) != 0 ? 3 : i);
        }

        /* JADX INFO: renamed from: drawRoundRect-ZuiqVtQ$default, reason: not valid java name */
        public static /* synthetic */ void m316drawRoundRectZuiqVtQ$default(DrawScope drawScope, Brush brush, long j, long j2, long j3, float f, DrawStyle drawStyle, BlendModeColorFilter blendModeColorFilter, int i, int i2) {
            long j4 = (i2 & 2) != 0 ? 0L : j;
            drawScope.mo471drawRoundRectZuiqVtQ(brush, j4, (i2 & 4) != 0 ? m306$private$offsetSizePENXr5M(drawScope.mo474getSizeNHjbRc(), j4) : j2, j3, (i2 & 16) != 0 ? 1.0f : f, (i2 & 32) != 0 ? Fill.INSTANCE : drawStyle, (i2 & 64) != 0 ? null : blendModeColorFilter, (i2 & 128) != 0 ? 3 : i);
        }

        public static int m(int i, int i2, String str) {
            return (str.hashCode() + i) * i2;
        }

        public static /* synthetic */ String stringValueOf(int i) {
            if (i == 1) {
                return "CROSSED";
            }
            if (i != 2) {
                return i != 3 ? "null" : "COLLAPSED";
            }
            return "NOT_CROSSED";
        }

        public static /* synthetic */ String stringValueOf$4(int i) {
            if (i == 1) {
                return "Measuring";
            }
            if (i == 2) {
                return "LookaheadMeasuring";
            }
            if (i == 3) {
                return "LayingOut";
            }
            if (i != 4) {
                return i != 5 ? "null" : "Idle";
            }
            return "LookaheadLayingOut";
        }

        public static Modifier weight$default(Modifier modifier) {
            if (1.0f <= 0.0d) {
                InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
            }
            return modifier.then(new LayoutWeightElement(1.0f, true));
        }

        public static int m(TextStyle textStyle, int i, int i2) {
            return (textStyle.hashCode() + i) * i2;
        }

        public static HttpException m(String str) {
            androidx.compose.ui.internal.InlineClassHelperKt.throwIllegalStateExceptionForNullCheck(str);
            return new HttpException();
        }

        public static int $default$maxIntrinsicHeight(MeasurePolicy measurePolicy, IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = 2;
                arrayList.add(new DefaultIntrinsicMeasurable((Measurable) list.get(i2), i3, i3, 0));
            }
            return measurePolicy.mo24measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), arrayList, ConstraintsKt.Constraints$default(0, i, 0, 0, 13)).getHeight();
        }

        public static int $default$maxIntrinsicWidth(MeasurePolicy measurePolicy, IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(new DefaultIntrinsicMeasurable((Measurable) list.get(i2), 2, 1, 0));
            }
            return measurePolicy.mo24measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), arrayList, ConstraintsKt.Constraints$default(0, 0, 0, i, 7)).getWidth();
        }

        public static int $default$minIntrinsicHeight(MeasurePolicy measurePolicy, IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(new DefaultIntrinsicMeasurable((Measurable) list.get(i2), 1, 2, 0));
            }
            return measurePolicy.mo24measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), arrayList, ConstraintsKt.Constraints$default(0, i, 0, 0, 13)).getHeight();
        }

        public static int $default$minIntrinsicWidth(MeasurePolicy measurePolicy, IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                int i3 = 1;
                arrayList.add(new DefaultIntrinsicMeasurable((Measurable) list.get(i2), i3, i3, 0));
            }
            return measurePolicy.mo24measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), arrayList, ConstraintsKt.Constraints$default(0, 0, 0, i, 7)).getWidth();
        }

        public static String m(int i, int i2, String str, String str2) {
            return str + i + str2 + i2;
        }

        public static String m(String str, long j) {
            return str + j;
        }

        public static int $default$maxIntrinsicHeight(LayoutModifierNode layoutModifierNode, IntrinsicMeasureScope intrinsicMeasureScope, Measurable measurable, int i) {
            int i2 = 2;
            return layoutModifierNode.mo25measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), new DefaultIntrinsicMeasurable(measurable, i2, i2, 2), ConstraintsKt.Constraints$default(0, i, 0, 0, 13)).getHeight();
        }

        public static int $default$minIntrinsicWidth(LayoutModifierNode layoutModifierNode, IntrinsicMeasureScope intrinsicMeasureScope, Measurable measurable, int i) {
            int i2 = 1;
            return layoutModifierNode.mo25measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), new DefaultIntrinsicMeasurable(measurable, i2, i2, 2), ConstraintsKt.Constraints$default(0, 0, 0, i, 7)).getWidth();
        }

        public static String m(StringBuilder sb, String str, char c) {
            sb.append(str);
            sb.append(c);
            return sb.toString();
        }

        public static void m(int i, int i2, int i3, int i4, int i5) {
            Key_androidKt.Key(i);
            Key_androidKt.Key(i2);
            Key_androidKt.Key(i3);
            Key_androidKt.Key(i4);
            Key_androidKt.Key(i5);
        }

        public static void m(int i, GapComposer gapComposer, ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$1, GapComposer gapComposer2, OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1) {
            Stack.m295setimpl(gapComposer, Integer.valueOf(i), composeUiNode$Companion$SetModifier$1);
            Stack.m294reconcileimpl(gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
        }

        public static /* synthetic */ void m(Object obj) {
            if (obj != null) {
                throw new ClassCastException();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public interface Element extends Modifier {
    }

    boolean all(Function1 function1);

    Object foldIn(Object obj, Function2 function2);

    Modifier then(Modifier modifier);

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class Node implements DelegatableNode {
        public Node child;
        public NodeCoordinator coordinator;
        public DialogHostKt$DialogHost$1$1$1 detachedListener;
        public boolean insertedNodeAwaitingAttachForInvalidation;
        public boolean isAttached;
        public int kindSet;
        public boolean onAttachRunExpected;
        public boolean onDetachRunExpected;
        public ObserverNodeOwnerScope ownerScope;
        public Node parent;
        public ContextScope scope;
        public boolean updatedNodeAwaitingAttachForInvalidation;
        public Node node = this;
        public int aggregateChildKindSet = -1;

        public final CoroutineScope getCoroutineScope() {
            ContextScope contextScope = this.scope;
            if (contextScope != null) {
                return contextScope;
            }
            ContextScope contextScopeCoroutineScope = JobKt.CoroutineScope(((AndroidComposeView) HitTestResultKt.requireOwner(this)).getCoroutineContext().plus(new JobImpl((Job) ((AndroidComposeView) HitTestResultKt.requireOwner(this)).getCoroutineContext().get(Job.Key.$$INSTANCE))));
            this.scope = contextScopeCoroutineScope;
            return contextScopeCoroutineScope;
        }

        public boolean getShouldAutoInvalidate() {
            return !(this instanceof BackgroundNode);
        }

        public void markAsAttached$ui() {
            if (this.isAttached) {
                androidx.compose.ui.internal.InlineClassHelperKt.throwIllegalStateException("node attached multiple times");
            }
            if (this.coordinator == null) {
                androidx.compose.ui.internal.InlineClassHelperKt.throwIllegalStateException("attach invoked on a node without a coordinator");
            }
            this.isAttached = true;
            this.onAttachRunExpected = true;
        }

        public void markAsDetached$ui() {
            if (!this.isAttached) {
                androidx.compose.ui.internal.InlineClassHelperKt.throwIllegalStateException("Cannot detach a node that is not attached");
            }
            if (this.onAttachRunExpected) {
                androidx.compose.ui.internal.InlineClassHelperKt.throwIllegalStateException("Must run runAttachLifecycle() before markAsDetached()");
            }
            if (this.onDetachRunExpected) {
                androidx.compose.ui.internal.InlineClassHelperKt.throwIllegalStateException("Must run runDetachLifecycle() before markAsDetached()");
            }
            this.isAttached = false;
            ContextScope contextScope = this.scope;
            if (contextScope != null) {
                JobKt.cancel(contextScope, new PointerInputResetException("The Modifier.Node was detached", 0));
                this.scope = null;
            }
        }

        public void reset$ui() {
            if (!this.isAttached) {
                androidx.compose.ui.internal.InlineClassHelperKt.throwIllegalStateException("reset() called on an unattached node");
            }
            onReset();
        }

        public void runAttachLifecycle$ui() {
            if (!this.isAttached) {
                androidx.compose.ui.internal.InlineClassHelperKt.throwIllegalStateException("Must run markAsAttached() prior to runAttachLifecycle");
            }
            if (!this.onAttachRunExpected) {
                androidx.compose.ui.internal.InlineClassHelperKt.throwIllegalStateException("Must run runAttachLifecycle() only once after markAsAttached()");
            }
            this.onAttachRunExpected = false;
            onAttach();
            this.onDetachRunExpected = true;
        }

        public void runDetachLifecycle$ui() {
            if (!this.isAttached) {
                androidx.compose.ui.internal.InlineClassHelperKt.throwIllegalStateException("node detached multiple times");
            }
            if (this.coordinator == null) {
                androidx.compose.ui.internal.InlineClassHelperKt.throwIllegalStateException("detach invoked on a node without a coordinator");
            }
            if (!this.onDetachRunExpected) {
                androidx.compose.ui.internal.InlineClassHelperKt.throwIllegalStateException("Must run runDetachLifecycle() once after runAttachLifecycle() and before markAsDetached()");
            }
            this.onDetachRunExpected = false;
            DialogHostKt$DialogHost$1$1$1 dialogHostKt$DialogHost$1$1$1 = this.detachedListener;
            if (dialogHostKt$DialogHost$1$1$1 != null) {
                dialogHostKt$DialogHost$1$1$1.invoke();
            }
            onDetach();
        }

        public void setAsDelegateTo$ui(Node node) {
            this.node = node;
        }

        public void updateCoordinator$ui(NodeCoordinator nodeCoordinator) {
            this.coordinator = nodeCoordinator;
        }

        public void onAttach() {
        }

        public /* synthetic */ void onDensityChange() {
        }

        public void onDetach() {
        }

        public /* synthetic */ void onLayoutDirectionChange() {
        }

        public void onReset() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Companion implements Modifier {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @Override // androidx.compose.ui.Modifier
        public final boolean all(Function1 function1) {
            return true;
        }

        public final String toString() {
            return "Modifier";
        }

        @Override // androidx.compose.ui.Modifier
        public final Modifier then(Modifier modifier) {
            return modifier;
        }

        @Override // androidx.compose.ui.Modifier
        public final Object foldIn(Object obj, Function2 function2) {
            return obj;
        }
    }
}
