package androidx.lifecycle.compose;

import android.R;
import android.app.RemoteAction;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.textclassifier.TextClassification;
import androidx.activity.compose.BackHandlerKt$BackHandler$lambda$4$0$$inlined$onStopOrDispose$1;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.compose.animation.core.AnimationScope;
import androidx.compose.foundation.contextmenu.ContextMenuPopupPositionProviderKt;
import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.gestures.ContentInViewNode;
import androidx.compose.foundation.gestures.DefaultFlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollingLogic;
import androidx.compose.foundation.gestures.ScrollingLogic$nestedScrollScope$1;
import androidx.compose.foundation.gestures.UpdatableAnimationState;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.LazyItemScope$CC;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.foundation.lazy.LazyListMeasuredItem;
import androidx.compose.foundation.style.StyleOuterNode$$ExternalSyntheticLambda1;
import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextContextMenuItems;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuComponent;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuData;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuItem;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuKeys;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSeparator;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuTextClassificationItem;
import androidx.compose.foundation.text.selection.MouseSelectionObserver;
import androidx.compose.foundation.text.selection.SelectionAdjustment$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.text.selection.SelectionManager_androidKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager$contextMenuAreaModifier$3;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.TooltipStateImpl;
import androidx.compose.material3.internal.AnchoredDraggableUninitializedException;
import androidx.compose.material3.internal.DraggableAnchorsNode;
import androidx.compose.material3.internal.TextFieldImplKt$CommonDecorationBox$borderContainerWithId$1$1;
import androidx.compose.material3.internal.ripple.BorderKt;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.saveable.SaveableStateHolderImpl;
import androidx.compose.runtime.saveable.SaveableStateRegistryWrapper;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.autofill.AndroidAutofill$$ExternalSyntheticApiModelOutline0;
import androidx.compose.ui.focus.FocusStateImpl;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPaint;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Outline$Rounded;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.MenuHostHelper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.compose.DialogHostKt$DialogHost$1$2$1$1$invoke$$inlined$onDispose$1;
import androidx.navigation.compose.NavHostKt$NavHost$28$1;
import coil.compose.AsyncImagePainter$$ExternalSyntheticLambda0;
import coil.request.Parameters;
import coil.request.RequestService;
import coil.util.ContinuationCallback;
import com.github.kr328.clash.compose.FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2;
import com.github.kr328.clash.compose.LogsScreenKt;
import com.github.kr328.clash.compose.MainAppKt$MainApp$2$3$1$1$1$2;
import com.github.kr328.clash.compose.MainAppKt$MainApp$2$3$1$1$1$3;
import com.github.kr328.clash.compose.connections.ComposableSingletons$ConnectionsScreenKt;
import com.github.kr328.clash.compose.connections.ConnectionsScreenKt$ProcessListContent$lambda$53$lambda$52$$inlined$items$default$4;
import com.github.kr328.clash.design.compose.theme.AppColors;
import com.github.kr328.clash.design.compose.theme.AppColorsKt;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.math.MathKt;
import kotlin.reflect.KProperty;
import kotlin.time.DurationKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import okhttp3.Request;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LifecycleEffectKt$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ LifecycleEffectKt$$ExternalSyntheticLambda1(ContentInViewNode contentInViewNode, UpdatableAnimationState updatableAnimationState, Job job, ScrollingLogic$nestedScrollScope$1 scrollingLogic$nestedScrollScope$1) {
        this.$r8$classId = 3;
        this.f$0 = contentInViewNode;
        this.f$1 = job;
        this.f$2 = scrollingLogic$nestedScrollScope$1;
    }

    private final Object invoke$com$github$kr328$clash$compose$sharetotv$ShareToTvScreenKt$ShareToTvScreen$2$$ExternalSyntheticLambda0(Object obj) {
        AppColors appColors = (AppColors) this.f$0;
        State state = (State) this.f$1;
        Function1 function1 = (Function1) this.f$2;
        LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
        LazyItemScope$CC.item$default(lazyListIntervalContent, null, new ComposableLambdaImpl(-935337207, new LogsScreenKt.AnonymousClass4.AnonymousClass2(appColors, 8), true), 3);
        List list = (List) state.getValue();
        lazyListIntervalContent.items(list.size(), new FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2(17, list, new AsyncImagePainter$$ExternalSyntheticLambda0(27)), new FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2(18, list), new ComposableLambdaImpl(802480018, new ConnectionsScreenKt$ProcessListContent$lambda$53$lambda$52$$inlined$items$default$4(1, list, function1), true));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.Object, java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r2v33, types: [java.lang.Object, java.util.Collection, java.util.List] */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws Throwable {
        long jFloatToRawIntBits;
        Canvas canvas;
        int i;
        ComposableLambdaImpl composableLambdaImpl;
        ComposableLambdaImpl composableLambdaImpl2;
        int i2 = this.$r8$classId;
        Fill fill = Fill.INSTANCE;
        int i3 = 5;
        int i4 = 13;
        int i5 = 11;
        int i6 = 6;
        int i7 = 3;
        Continuation continuation = null;
        final int i8 = 2;
        final int i9 = 0;
        ?? r11 = this.f$2;
        Object obj2 = this.f$1;
        Object obj3 = this.f$0;
        final int i10 = 1;
        switch (i2) {
            case 0:
                LifecycleOwner lifecycleOwner = (LifecycleOwner) obj3;
                final LifecycleStartStopEffectScope lifecycleStartStopEffectScope = (LifecycleStartStopEffectScope) obj2;
                final Function1 function1 = (Function1) r11;
                final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda3
                    @Override // androidx.lifecycle.LifecycleEventObserver
                    public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                        int i11 = LifecycleEffectKt.WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
                        Ref$ObjectRef ref$ObjectRef2 = ref$ObjectRef;
                        if (i11 == 1) {
                            ref$ObjectRef2.element = function1.invoke(lifecycleStartStopEffectScope);
                        } else {
                            if (i11 != 2) {
                                return;
                            }
                            BackHandlerKt$BackHandler$lambda$4$0$$inlined$onStopOrDispose$1 backHandlerKt$BackHandler$lambda$4$0$$inlined$onStopOrDispose$1 = (BackHandlerKt$BackHandler$lambda$4$0$$inlined$onStopOrDispose$1) ref$ObjectRef2.element;
                            if (backHandlerKt$BackHandler$lambda$4$0$$inlined$onStopOrDispose$1 != null) {
                                backHandlerKt$BackHandler$lambda$4$0$$inlined$onStopOrDispose$1.runStopOrDisposeEffect();
                            }
                            ref$ObjectRef2.element = null;
                        }
                    }
                };
                lifecycleOwner.getLifecycle().addObserver(lifecycleEventObserver);
                return new DialogHostKt$DialogHost$1$2$1$1$invoke$$inlined$onDispose$1(lifecycleOwner, lifecycleEventObserver, ref$ObjectRef, 3);
            case 1:
                RoundRect roundRect = (RoundRect) obj2;
                Brush brush = (Brush) r11;
                DrawScope drawScope = (DrawScope) obj;
                float fFloatValue = Float.valueOf(((StyleOuterNode$$ExternalSyntheticLambda1) ((Request) obj3).method).f$0).floatValue();
                float f = fFloatValue < 0.0f ? 0.0f : fFloatValue;
                float f2 = 2;
                float f3 = f / f2;
                float f4 = f2 * f;
                float fMin = Math.min(Math.abs(roundRect.getWidth()), Math.abs(roundRect.getHeight()));
                float f5 = roundRect.top;
                float f6 = roundRect.left;
                boolean z = f4 > fMin;
                long j = roundRect.topLeftCornerRadius;
                Stroke stroke = new Stroke(f, 0.0f, 0, 0, 30);
                if (z) {
                    Modifier.CC.m316drawRoundRectZuiqVtQ$default(drawScope, brush, (((long) Float.floatToRawIntBits(f6)) << 32) | (((long) Float.floatToRawIntBits(f5)) & 4294967295L), (((long) Float.floatToRawIntBits(roundRect.getWidth())) << 32) | (((long) Float.floatToRawIntBits(roundRect.getHeight())) & 4294967295L), j, 0.0f, null, null, 0, 240);
                } else if (Float.intBitsToFloat((int) (j >> 32)) < f3) {
                    float f7 = f6 + f;
                    float f8 = f5 + f;
                    float f9 = roundRect.right - f;
                    float f10 = roundRect.bottom - f;
                    MenuHostHelper drawContext = drawScope.getDrawContext();
                    long jM756getSizeNHjbRc = drawContext.m756getSizeNHjbRc();
                    drawContext.getCanvas().save();
                    try {
                        ((Parameters.Builder) drawContext.mOnInvalidateMenuCallback).m790clipRectN_I0leg(f7, f8, f9, f10, 0);
                        Modifier.CC.m316drawRoundRectZuiqVtQ$default(drawScope, brush, (((long) Float.floatToRawIntBits(f6)) << 32) | (((long) Float.floatToRawIntBits(f5)) & 4294967295L), (((long) Float.floatToRawIntBits(roundRect.getWidth())) << 32) | (((long) Float.floatToRawIntBits(roundRect.getHeight())) & 4294967295L), j, 0.0f, null, null, 0, 240);
                    } finally {
                        ImageAnalysis$$ExternalSyntheticLambda1.m(drawContext, jM756getSizeNHjbRc);
                    }
                } else {
                    Modifier.CC.m316drawRoundRectZuiqVtQ$default(drawScope, brush, (((long) Float.floatToRawIntBits(f6 + f3)) << 32) | (((long) Float.floatToRawIntBits(f5 + f3)) & 4294967295L), (((long) Float.floatToRawIntBits(roundRect.getWidth() - f)) << 32) | (((long) Float.floatToRawIntBits(roundRect.getHeight() - f)) & 4294967295L), DurationKt.m840shrinkKibmq7A(f3, j), 0.0f, stroke, null, 0, 208);
                }
                return Unit.INSTANCE;
            case 2:
                Rect rect = (Rect) obj2;
                float f11 = rect.top;
                float f12 = rect.bottom;
                float f13 = rect.left;
                float f14 = rect.right;
                Brush brush2 = (Brush) r11;
                DrawScope drawScope2 = (DrawScope) obj;
                float fFloatValue2 = Float.valueOf(((StyleOuterNode$$ExternalSyntheticLambda1) ((Request) obj3).method).f$0).floatValue();
                float f15 = fFloatValue2 < 0.0f ? 0.0f : fFloatValue2;
                float f16 = 2;
                boolean z2 = f15 * f16 > Math.min(Math.abs(f14 - f13), Math.abs(f12 - f11));
                if (z2) {
                    jFloatToRawIntBits = rect.m380getTopLeftF1C5BW0();
                } else {
                    float f17 = f15 / f16;
                    jFloatToRawIntBits = (((long) Float.floatToRawIntBits(f13 + f17)) << 32) | (((long) Float.floatToRawIntBits(f17 + f11)) & 4294967295L);
                }
                Modifier.CC.m314drawRectAsUm42w$default(drawScope2, brush2, jFloatToRawIntBits, z2 ? rect.m379getSizeNHjbRc() : (((long) Float.floatToRawIntBits((f12 - f11) - f15)) & 4294967295L) | (((long) Float.floatToRawIntBits((f14 - f13) - f15)) << 32), 0.0f, z2 ? fill : new Stroke(f15, 0.0f, 0, 0, 30), null, 0, 104);
                return Unit.INSTANCE;
            case 3:
                ContentInViewNode contentInViewNode = (ContentInViewNode) obj3;
                Job job = (Job) obj2;
                ScrollingLogic$nestedScrollScope$1 scrollingLogic$nestedScrollScope$1 = (ScrollingLogic$nestedScrollScope$1) r11;
                float fFloatValue3 = ((Float) obj).floatValue();
                float f18 = contentInViewNode.reverseDirection ? 1.0f : -1.0f;
                ScrollingLogic scrollingLogic = contentInViewNode.scrollingLogic;
                long jM106reverseIfNeededMKHz9U = scrollingLogic.m106reverseIfNeededMKHz9U(scrollingLogic.m108toOffsettuRUvjQ(f18 * fFloatValue3));
                ScrollingLogic scrollingLogic2 = scrollingLogic$nestedScrollScope$1.this$0;
                float fM107toFloatk4lQ0M = scrollingLogic.m107toFloatk4lQ0M(scrollingLogic.m106reverseIfNeededMKHz9U(scrollingLogic2.m105performScroll3eAAhYA(scrollingLogic2.outerStateScope, jM106reverseIfNeededMKHz9U, 1))) * f18;
                if (Math.abs(fM107toFloatk4lQ0M) < Math.abs(fFloatValue3)) {
                    CancellationException cancellationException = new CancellationException("Scroll animation cancelled because scroll was not consumed (" + fM107toFloatk4lQ0M + " < " + fFloatValue3 + ')');
                    cancellationException.initCause(null);
                    job.cancel(cancellationException);
                }
                return Unit.INSTANCE;
            case 4:
                Ref$FloatRef ref$FloatRef = (Ref$FloatRef) obj3;
                AnimationScope animationScope = (AnimationScope) obj;
                float fFloatValue4 = ((Number) animationScope.value$delegate.getValue()).floatValue() - ref$FloatRef.element;
                float fScrollBy = ((ScrollScope) obj2).scrollBy(fFloatValue4);
                ref$FloatRef.element = ((Number) animationScope.value$delegate.getValue()).floatValue();
                ((Ref$FloatRef) r11).element = ((Number) animationScope.getVelocity()).floatValue();
                if (Math.abs(fFloatValue4 - fScrollBy) > 0.5f) {
                    animationScope.cancelAnimation();
                }
                return Unit.INSTANCE;
            case 5:
                MutableState mutableState = (MutableState) obj3;
                ArrayList arrayList = (ArrayList) obj2;
                Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                placementScope.motionFrameOfReferencePlacement = true;
                int size = arrayList.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((LazyListMeasuredItem) arrayList.get(i11)).place(placementScope);
                }
                int size2 = r11.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    ((LazyListMeasuredItem) r11.get(i12)).place(placementScope);
                }
                Unit unit = Unit.INSTANCE;
                placementScope.motionFrameOfReferencePlacement = false;
                mutableState.getValue();
                return Unit.INSTANCE;
            case 6:
                Function1 function2 = (Function1) r11;
                MutableState mutableState2 = (MutableState) obj2;
                TextFieldValue textFieldValue = (TextFieldValue) obj;
                ((MutableState) obj3).setValue(textFieldValue);
                boolean zAreEqual = Intrinsics.areEqual((String) mutableState2.getValue(), textFieldValue.annotatedString.text);
                AnnotatedString annotatedString = textFieldValue.annotatedString;
                mutableState2.setValue(annotatedString.text);
                if (!zAreEqual) {
                    function2.invoke(annotatedString.text);
                }
                return Unit.INSTANCE;
            case 7:
                LegacyTextFieldState legacyTextFieldState = (LegacyTextFieldState) obj3;
                long j2 = ((TextFieldValue) obj2).selection;
                OffsetMapping offsetMapping = (OffsetMapping) r11;
                DrawScope drawScope3 = (DrawScope) obj;
                TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
                if (layoutResult != null) {
                    Canvas canvas2 = drawScope3.getDrawContext().getCanvas();
                    long j3 = ((TextRange) legacyTextFieldState.selectionPreviewHighlightRange$delegate.getValue()).packedValue;
                    long j4 = ((TextRange) legacyTextFieldState.deletionPreviewHighlightRange$delegate.getValue()).packedValue;
                    TextLayoutResult textLayoutResult = layoutResult.value;
                    MultiParagraph multiParagraph = textLayoutResult.multiParagraph;
                    TextLayoutInput textLayoutInput = textLayoutResult.layoutInput;
                    AndroidPaint androidPaint = legacyTextFieldState.highlightPaint;
                    long j5 = legacyTextFieldState.selectionBackgroundColor;
                    if (!TextRange.m641getCollapsedimpl(j3)) {
                        androidPaint.m404setColor8_81llA(j5);
                        int iOriginalToTransformed = offsetMapping.originalToTransformed(TextRange.m644getMinimpl(j3));
                        int iOriginalToTransformed2 = offsetMapping.originalToTransformed(TextRange.m643getMaximpl(j3));
                        if (iOriginalToTransformed != iOriginalToTransformed2) {
                            canvas2.drawPath(textLayoutResult.getPathForRange(iOriginalToTransformed, iOriginalToTransformed2), androidPaint);
                        }
                    } else if (!TextRange.m641getCollapsedimpl(j4)) {
                        long jM649getColor0d7_KjU = textLayoutInput.style.m649getColor0d7_KjU();
                        Color color = new Color(jM649getColor0d7_KjU);
                        if (jM649getColor0d7_KjU == 16) {
                            color = null;
                        }
                        long j6 = color != null ? color.value : Color.Black;
                        androidPaint.m404setColor8_81llA(BrushKt.Color(Color.m440getRedimpl(j6), Color.m439getGreenimpl(j6), Color.m437getBlueimpl(j6), Color.m436getAlphaimpl(j6) * 0.2f, Color.m438getColorSpaceimpl(j6)));
                        int iOriginalToTransformed3 = offsetMapping.originalToTransformed(TextRange.m644getMinimpl(j4));
                        int iOriginalToTransformed4 = offsetMapping.originalToTransformed(TextRange.m643getMaximpl(j4));
                        if (iOriginalToTransformed3 != iOriginalToTransformed4) {
                            canvas2.drawPath(textLayoutResult.getPathForRange(iOriginalToTransformed3, iOriginalToTransformed4), androidPaint);
                        }
                    } else if (!TextRange.m641getCollapsedimpl(j2)) {
                        androidPaint.m404setColor8_81llA(j5);
                        int iOriginalToTransformed5 = offsetMapping.originalToTransformed(TextRange.m644getMinimpl(j2));
                        int iOriginalToTransformed6 = offsetMapping.originalToTransformed(TextRange.m643getMaximpl(j2));
                        if (iOriginalToTransformed5 != iOriginalToTransformed6) {
                            canvas2.drawPath(textLayoutResult.getPathForRange(iOriginalToTransformed5, iOriginalToTransformed6), androidPaint);
                        }
                    }
                    boolean z3 = textLayoutResult.getHasVisualOverflow() && textLayoutInput.overflow != 3;
                    if (z3) {
                        long j7 = textLayoutResult.size;
                        Rect rectM382Recttz77jQw = RectKt.m382Recttz77jQw(0L, (((long) Float.floatToRawIntBits((int) (j7 & 4294967295L))) & 4294967295L) | (((long) Float.floatToRawIntBits((int) (j7 >> 32))) << 32));
                        canvas2.save();
                        canvas2.mo394clipRectmtrdDE(rectM382Recttz77jQw);
                    }
                    SpanStyle spanStyle = textLayoutInput.style.spanStyle;
                    TextDecoration textDecoration = spanStyle.textDecoration;
                    TextForegroundStyle textForegroundStyle = spanStyle.textForegroundStyle;
                    if (textDecoration == null) {
                        textDecoration = TextDecoration.None;
                    }
                    TextDecoration textDecoration2 = textDecoration;
                    Shadow shadow = spanStyle.shadow;
                    if (shadow == null) {
                        shadow = Shadow.None;
                    }
                    Shadow shadow2 = shadow;
                    DrawStyle drawStyle = spanStyle.drawStyle;
                    DrawStyle drawStyle2 = drawStyle == null ? fill : drawStyle;
                    try {
                        Brush brush3 = textForegroundStyle.getBrush();
                        TextForegroundStyle.Unspecified unspecified = TextForegroundStyle.Unspecified.INSTANCE;
                        try {
                            if (brush3 != null) {
                                canvas = canvas2;
                                MultiParagraph.m627painthn5TExg$default(multiParagraph, canvas, brush3, textForegroundStyle != unspecified ? textForegroundStyle.getAlpha() : 1.0f, shadow2, textDecoration2, drawStyle2);
                            } else {
                                canvas = canvas2;
                                MultiParagraph.m626paintLG529CI$default(multiParagraph, canvas, textForegroundStyle != unspecified ? textForegroundStyle.mo668getColor0d7_KjU() : Color.Black, shadow2, textDecoration2, drawStyle2);
                            }
                            if (z3) {
                                canvas.restore();
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (z3) {
                                canvas2.restore();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                return Unit.INSTANCE;
            case 8:
                Function1 function3 = (Function1) r11;
                TextInputSession textInputSession = (TextInputSession) ((Ref$ObjectRef) obj2).element;
                TextFieldValue textFieldValueApply = ((RequestService) obj3).apply((List) obj);
                if (textInputSession != null) {
                    textInputSession.updateState(null, textFieldValueApply);
                }
                function3.invoke(textFieldValueApply);
                return Unit.INSTANCE;
            case 9:
                Context context = (Context) obj2;
                TextContextMenuSession textContextMenuSession = (TextContextMenuSession) r11;
                ContextMenuScope contextMenuScope = (ContextMenuScope) obj;
                ?? r2 = ((TextContextMenuData) obj3).components;
                int size3 = r2.size();
                for (int i13 = 0; i13 < size3; i13++) {
                    TextContextMenuComponent textContextMenuComponent = (TextContextMenuComponent) r2.get(i13);
                    if (textContextMenuComponent instanceof TextContextMenuItem) {
                        final TextContextMenuItem textContextMenuItem = (TextContextMenuItem) textContextMenuComponent;
                        int i14 = 10;
                        ContextMenuScope.item$default(contextMenuScope, new Updater$$ExternalSyntheticLambda0(i14, textContextMenuItem), textContextMenuItem.leadingIcon == 0 ? null : new ComposableLambdaImpl(-1930700965, new Function3() { // from class: androidx.compose.foundation.text.contextmenu.internal.TextContextMenuHelperApi28$textClassificationItem$5
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj4, Object obj5, Object obj6) {
                                switch (i10) {
                                    case 0:
                                        long j8 = ((Color) obj4).value;
                                        GapComposer gapComposer = (GapComposer) obj5;
                                        int iIntValue = ((Number) obj6).intValue();
                                        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                                            TextContextMenuHelperApi28.INSTANCE.IconBox(((RemoteAction) textContextMenuItem).getIcon(), gapComposer, 48);
                                        } else {
                                            gapComposer.skipToGroupEnd();
                                        }
                                        break;
                                    case 1:
                                        long j9 = ((Color) obj4).value;
                                        GapComposer gapComposer2 = (GapComposer) obj5;
                                        int iIntValue2 = ((Number) obj6).intValue();
                                        if ((iIntValue2 & 6) == 0) {
                                            iIntValue2 |= gapComposer2.changed(j9) ? 4 : 2;
                                        }
                                        if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                                            DefaultTextContextMenuDropdownProvider_androidKt.m183IconBoxRPmYEkk(((TextContextMenuItem) textContextMenuItem).leadingIcon, j9, gapComposer2, (iIntValue2 << 3) & 112);
                                        } else {
                                            gapComposer2.skipToGroupEnd();
                                        }
                                        break;
                                    default:
                                        long j10 = ((Color) obj4).value;
                                        GapComposer gapComposer3 = (GapComposer) obj5;
                                        int iIntValue3 = ((Number) obj6).intValue();
                                        if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                                            TextContextMenuHelperApi28.INSTANCE.IconBox((Drawable) textContextMenuItem, gapComposer3, 48);
                                        } else {
                                            gapComposer3.skipToGroupEnd();
                                        }
                                        break;
                                }
                                return Unit.INSTANCE;
                            }
                        }, true), new Recomposer$$ExternalSyntheticLambda6(i14, textContextMenuItem, textContextMenuSession), 6);
                    } else {
                        if (!(textContextMenuComponent instanceof TextContextMenuTextClassificationItem)) {
                            i = 13;
                            if (textContextMenuComponent instanceof TextContextMenuSeparator) {
                                contextMenuScope.composables.add(ContextMenuPopupPositionProviderKt.f0lambda$1455401925);
                            }
                        } else if (Build.VERSION.SDK_INT >= 28) {
                            TextContextMenuTextClassificationItem textContextMenuTextClassificationItem = (TextContextMenuTextClassificationItem) textContextMenuComponent;
                            if (context != null) {
                                int i15 = textContextMenuTextClassificationItem.index;
                                TextClassification textClassification = textContextMenuTextClassificationItem.textClassification;
                                if (i15 < 0) {
                                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = new Updater$$ExternalSyntheticLambda0(i5, textClassification);
                                    final Drawable icon = textClassification.getIcon();
                                    if (icon != null) {
                                        final int i16 = 2;
                                        composableLambdaImpl2 = new ComposableLambdaImpl(-1123224187, new Function3() { // from class: androidx.compose.foundation.text.contextmenu.internal.TextContextMenuHelperApi28$textClassificationItem$5
                                            @Override // kotlin.jvm.functions.Function3
                                            public final Object invoke(Object obj4, Object obj5, Object obj6) {
                                                switch (i16) {
                                                    case 0:
                                                        long j8 = ((Color) obj4).value;
                                                        GapComposer gapComposer = (GapComposer) obj5;
                                                        int iIntValue = ((Number) obj6).intValue();
                                                        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                                                            TextContextMenuHelperApi28.INSTANCE.IconBox(((RemoteAction) icon).getIcon(), gapComposer, 48);
                                                        } else {
                                                            gapComposer.skipToGroupEnd();
                                                        }
                                                        break;
                                                    case 1:
                                                        long j9 = ((Color) obj4).value;
                                                        GapComposer gapComposer2 = (GapComposer) obj5;
                                                        int iIntValue2 = ((Number) obj6).intValue();
                                                        if ((iIntValue2 & 6) == 0) {
                                                            iIntValue2 |= gapComposer2.changed(j9) ? 4 : 2;
                                                        }
                                                        if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                                                            DefaultTextContextMenuDropdownProvider_androidKt.m183IconBoxRPmYEkk(((TextContextMenuItem) icon).leadingIcon, j9, gapComposer2, (iIntValue2 << 3) & 112);
                                                        } else {
                                                            gapComposer2.skipToGroupEnd();
                                                        }
                                                        break;
                                                    default:
                                                        long j10 = ((Color) obj4).value;
                                                        GapComposer gapComposer3 = (GapComposer) obj5;
                                                        int iIntValue3 = ((Number) obj6).intValue();
                                                        if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                                                            TextContextMenuHelperApi28.INSTANCE.IconBox((Drawable) icon, gapComposer3, 48);
                                                        } else {
                                                            gapComposer3.skipToGroupEnd();
                                                        }
                                                        break;
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }, true);
                                    } else {
                                        composableLambdaImpl2 = null;
                                    }
                                    ContextMenuScope.item$default(contextMenuScope, updater$$ExternalSyntheticLambda0, composableLambdaImpl2, new Recomposer$$ExternalSyntheticLambda6(i5, context, textClassification), 6);
                                } else {
                                    final RemoteAction remoteActionM = AndroidAutofill$$ExternalSyntheticApiModelOutline0.m(textClassification.getActions().get(i15));
                                    boolean z4 = i15 == 0;
                                    Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda1 = new Updater$$ExternalSyntheticLambda0(12, remoteActionM);
                                    if (z4 || remoteActionM.shouldShowIcon()) {
                                        final int i17 = 0;
                                        composableLambdaImpl = new ComposableLambdaImpl(-1261173016, new Function3() { // from class: androidx.compose.foundation.text.contextmenu.internal.TextContextMenuHelperApi28$textClassificationItem$5
                                            @Override // kotlin.jvm.functions.Function3
                                            public final Object invoke(Object obj4, Object obj5, Object obj6) {
                                                switch (i17) {
                                                    case 0:
                                                        long j8 = ((Color) obj4).value;
                                                        GapComposer gapComposer = (GapComposer) obj5;
                                                        int iIntValue = ((Number) obj6).intValue();
                                                        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                                                            TextContextMenuHelperApi28.INSTANCE.IconBox(((RemoteAction) remoteActionM).getIcon(), gapComposer, 48);
                                                        } else {
                                                            gapComposer.skipToGroupEnd();
                                                        }
                                                        break;
                                                    case 1:
                                                        long j9 = ((Color) obj4).value;
                                                        GapComposer gapComposer2 = (GapComposer) obj5;
                                                        int iIntValue2 = ((Number) obj6).intValue();
                                                        if ((iIntValue2 & 6) == 0) {
                                                            iIntValue2 |= gapComposer2.changed(j9) ? 4 : 2;
                                                        }
                                                        if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                                                            DefaultTextContextMenuDropdownProvider_androidKt.m183IconBoxRPmYEkk(((TextContextMenuItem) remoteActionM).leadingIcon, j9, gapComposer2, (iIntValue2 << 3) & 112);
                                                        } else {
                                                            gapComposer2.skipToGroupEnd();
                                                        }
                                                        break;
                                                    default:
                                                        long j10 = ((Color) obj4).value;
                                                        GapComposer gapComposer3 = (GapComposer) obj5;
                                                        int iIntValue3 = ((Number) obj6).intValue();
                                                        if (gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                                                            TextContextMenuHelperApi28.INSTANCE.IconBox((Drawable) remoteActionM, gapComposer3, 48);
                                                        } else {
                                                            gapComposer3.skipToGroupEnd();
                                                        }
                                                        break;
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        }, true);
                                    } else {
                                        composableLambdaImpl = null;
                                    }
                                    i = 13;
                                    ContextMenuScope.item$default(contextMenuScope, updater$$ExternalSyntheticLambda1, composableLambdaImpl, new BasicTextKt$$ExternalSyntheticLambda0(i, remoteActionM), 6);
                                }
                            }
                        }
                    }
                    i = 13;
                }
                return Unit.INSTANCE;
            case 10:
                Ref$BooleanRef ref$BooleanRef = (Ref$BooleanRef) r11;
                PointerInputChange pointerInputChange = (PointerInputChange) obj;
                if (((MouseSelectionObserver) obj3).mo207onDrag3MmeM6k(pointerInputChange.position, (SelectionAdjustment$Companion$$ExternalSyntheticLambda0) obj2)) {
                    pointerInputChange.consume();
                    ref$BooleanRef.element = true;
                }
                return Unit.INSTANCE;
            case 11:
                final TextFieldSelectionManager textFieldSelectionManager = (TextFieldSelectionManager) obj3;
                CoroutineScope coroutineScope = (CoroutineScope) obj2;
                Context context2 = (Context) r11;
                TextContextMenuBuilderScope textContextMenuBuilderScope = (TextContextMenuBuilderScope) obj;
                textContextMenuBuilderScope.separator();
                MutableObjectList mutableObjectList = textContextMenuBuilderScope.components;
                TextContextMenuItems textContextMenuItems = TextContextMenuItems.Autofill;
                boolean z5 = (TextRange.m641getCollapsedimpl(textFieldSelectionManager.getValue$foundation().selection) || !textFieldSelectionManager.getEditable() || textFieldSelectionManager.clipboard == null) ? false : true;
                Recomposer$$ExternalSyntheticLambda6 recomposer$$ExternalSyntheticLambda6 = new Recomposer$$ExternalSyntheticLambda6(coroutineScope, new TextFieldSelectionManager$contextMenuAreaModifier$3(textFieldSelectionManager, continuation, i10));
                Resources resources = context2.getResources();
                SelectionManager_androidKt$$ExternalSyntheticLambda0 selectionManager_androidKt$$ExternalSyntheticLambda0 = new SelectionManager_androidKt$$ExternalSyntheticLambda0(recomposer$$ExternalSyntheticLambda6, null, 1);
                if (z5) {
                    mutableObjectList.add(new TextContextMenuItem(TextContextMenuKeys.CutKey, resources.getString(R.string.cut), R.attr.actionModeCutDrawable, selectionManager_androidKt$$ExternalSyntheticLambda0));
                }
                TextContextMenuItems textContextMenuItems2 = TextContextMenuItems.Autofill;
                boolean z6 = (TextRange.m641getCollapsedimpl(textFieldSelectionManager.getValue$foundation().selection) || textFieldSelectionManager.clipboard == null) ? false : true;
                Recomposer$$ExternalSyntheticLambda6 recomposer$$ExternalSyntheticLambda7 = new Recomposer$$ExternalSyntheticLambda6(coroutineScope, new TextFieldSelectionManager$contextMenuAreaModifier$3(textFieldSelectionManager, continuation, i8));
                Resources resources2 = context2.getResources();
                SelectionManager_androidKt$$ExternalSyntheticLambda0 selectionManager_androidKt$$ExternalSyntheticLambda1 = new SelectionManager_androidKt$$ExternalSyntheticLambda0(recomposer$$ExternalSyntheticLambda7, null, 1);
                if (z6) {
                    mutableObjectList.add(new TextContextMenuItem(TextContextMenuKeys.CopyKey, resources2.getString(R.string.copy), R.attr.actionModeCopyDrawable, selectionManager_androidKt$$ExternalSyntheticLambda1));
                }
                TextContextMenuItems textContextMenuItems3 = TextContextMenuItems.Autofill;
                boolean z7 = textFieldSelectionManager.getEditable() && ((Boolean) textFieldSelectionManager.hasAvailableTextToPaste$delegate.getValue()).booleanValue() && textFieldSelectionManager.clipboard != null;
                Recomposer$$ExternalSyntheticLambda6 recomposer$$ExternalSyntheticLambda8 = new Recomposer$$ExternalSyntheticLambda6(coroutineScope, new TextFieldSelectionManager$contextMenuAreaModifier$3(textFieldSelectionManager, continuation, i7));
                Resources resources3 = context2.getResources();
                SelectionManager_androidKt$$ExternalSyntheticLambda0 selectionManager_androidKt$$ExternalSyntheticLambda2 = new SelectionManager_androidKt$$ExternalSyntheticLambda0(recomposer$$ExternalSyntheticLambda8, null, 1);
                if (z7) {
                    mutableObjectList.add(new TextContextMenuItem(TextContextMenuKeys.PasteKey, resources3.getString(R.string.paste), R.attr.actionModePasteDrawable, selectionManager_androidKt$$ExternalSyntheticLambda2));
                }
                TextContextMenuItems textContextMenuItems4 = TextContextMenuItems.Autofill;
                boolean z8 = TextRange.m642getLengthimpl(textFieldSelectionManager.getValue$foundation().selection) != textFieldSelectionManager.getValue$foundation().annotatedString.text.length();
                Function0 function0 = new Function0() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        switch (i9) {
                            case 0:
                                return Boolean.valueOf(!textFieldSelectionManager.textToolbarShownViaProvider);
                            case 1:
                                TextFieldSelectionManager textFieldSelectionManager2 = textFieldSelectionManager;
                                TextFieldValue textFieldValueM229createTextFieldValueFDrldGo = TextFieldSelectionManager.m229createTextFieldValueFDrldGo(textFieldSelectionManager2.getValue$foundation().annotatedString, ParagraphKt.TextRange(0, textFieldSelectionManager2.getValue$foundation().annotatedString.text.length()));
                                textFieldSelectionManager2.onValueChange.invoke(textFieldValueM229createTextFieldValueFDrldGo);
                                long j8 = textFieldValueM229createTextFieldValueFDrldGo.selection;
                                textFieldSelectionManager2.latestSelection = new TextRange(j8);
                                textFieldSelectionManager2.oldValue = TextFieldValue.m663copy3r_uNRQ$default(textFieldSelectionManager2.oldValue, null, j8, 5);
                                textFieldSelectionManager2.enterSelectionMode$foundation(true);
                                return Unit.INSTANCE;
                            default:
                                Function0 function4 = textFieldSelectionManager.requestAutofillAction;
                                if (function4 != null) {
                                    function4.invoke();
                                }
                                return Unit.INSTANCE;
                        }
                    }
                };
                Function0 function4 = new Function0() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        switch (i10) {
                            case 0:
                                return Boolean.valueOf(!textFieldSelectionManager.textToolbarShownViaProvider);
                            case 1:
                                TextFieldSelectionManager textFieldSelectionManager2 = textFieldSelectionManager;
                                TextFieldValue textFieldValueM229createTextFieldValueFDrldGo = TextFieldSelectionManager.m229createTextFieldValueFDrldGo(textFieldSelectionManager2.getValue$foundation().annotatedString, ParagraphKt.TextRange(0, textFieldSelectionManager2.getValue$foundation().annotatedString.text.length()));
                                textFieldSelectionManager2.onValueChange.invoke(textFieldValueM229createTextFieldValueFDrldGo);
                                long j8 = textFieldValueM229createTextFieldValueFDrldGo.selection;
                                textFieldSelectionManager2.latestSelection = new TextRange(j8);
                                textFieldSelectionManager2.oldValue = TextFieldValue.m663copy3r_uNRQ$default(textFieldSelectionManager2.oldValue, null, j8, 5);
                                textFieldSelectionManager2.enterSelectionMode$foundation(true);
                                return Unit.INSTANCE;
                            default:
                                Function0 function5 = textFieldSelectionManager.requestAutofillAction;
                                if (function5 != null) {
                                    function5.invoke();
                                }
                                return Unit.INSTANCE;
                        }
                    }
                };
                Resources resources4 = context2.getResources();
                SelectionManager_androidKt$$ExternalSyntheticLambda0 selectionManager_androidKt$$ExternalSyntheticLambda3 = new SelectionManager_androidKt$$ExternalSyntheticLambda0(function4, function0, 1);
                if (z8) {
                    mutableObjectList.add(new TextContextMenuItem(TextContextMenuKeys.SelectAllKey, resources4.getString(R.string.selectAll), R.attr.actionModeSelectAllDrawable, selectionManager_androidKt$$ExternalSyntheticLambda3));
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    TextContextMenuItems textContextMenuItems5 = TextContextMenuItems.Autofill;
                    if (textFieldSelectionManager.getEditable() && TextRange.m641getCollapsedimpl(textFieldSelectionManager.getValue$foundation().selection)) {
                        i9 = 1;
                    }
                    Function0 function5 = new Function0() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            switch (i8) {
                                case 0:
                                    return Boolean.valueOf(!textFieldSelectionManager.textToolbarShownViaProvider);
                                case 1:
                                    TextFieldSelectionManager textFieldSelectionManager2 = textFieldSelectionManager;
                                    TextFieldValue textFieldValueM229createTextFieldValueFDrldGo = TextFieldSelectionManager.m229createTextFieldValueFDrldGo(textFieldSelectionManager2.getValue$foundation().annotatedString, ParagraphKt.TextRange(0, textFieldSelectionManager2.getValue$foundation().annotatedString.text.length()));
                                    textFieldSelectionManager2.onValueChange.invoke(textFieldValueM229createTextFieldValueFDrldGo);
                                    long j8 = textFieldValueM229createTextFieldValueFDrldGo.selection;
                                    textFieldSelectionManager2.latestSelection = new TextRange(j8);
                                    textFieldSelectionManager2.oldValue = TextFieldValue.m663copy3r_uNRQ$default(textFieldSelectionManager2.oldValue, null, j8, 5);
                                    textFieldSelectionManager2.enterSelectionMode$foundation(true);
                                    return Unit.INSTANCE;
                                default:
                                    Function0 function6 = textFieldSelectionManager.requestAutofillAction;
                                    if (function6 != null) {
                                        function6.invoke();
                                    }
                                    return Unit.INSTANCE;
                            }
                        }
                    };
                    Resources resources5 = context2.getResources();
                    SelectionManager_androidKt$$ExternalSyntheticLambda0 selectionManager_androidKt$$ExternalSyntheticLambda4 = new SelectionManager_androidKt$$ExternalSyntheticLambda0(function5, null, 1);
                    if (i9 != 0) {
                        mutableObjectList.add(new TextContextMenuItem(textContextMenuItems5.key, resources5.getString(textContextMenuItems5.stringId), textContextMenuItems5.drawableId, selectionManager_androidKt$$ExternalSyntheticLambda4));
                    }
                }
                textContextMenuBuilderScope.separator();
                return Unit.INSTANCE;
            case 12:
                PaddingValues paddingValues = (PaddingValues) obj2;
                Alignment.Horizontal horizontal = (Alignment.Horizontal) r11;
                LayoutNodeDrawScope layoutNodeDrawScope = (LayoutNodeDrawScope) obj;
                long j8 = ((Size) ((TextFieldImplKt$CommonDecorationBox$borderContainerWithId$1$1) obj3).get()).packedValue;
                float fIntBitsToFloat = Float.intBitsToFloat((int) (j8 >> 32));
                if (fIntBitsToFloat > 0.0f) {
                    float fMo92toPx0680j_4 = layoutNodeDrawScope.mo92toPx0680j_4(OutlinedTextFieldKt.OutlinedTextFieldInnerPadding);
                    CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
                    float fMo92toPx0680j_5 = layoutNodeDrawScope.mo92toPx0680j_4(paddingValues.mo118calculateLeftPaddingu2uoSUM(layoutNodeDrawScope.getLayoutDirection()));
                    float fAlign = horizontal.align(MathKt.roundToInt(fIntBitsToFloat), MathKt.roundToInt((Float.intBitsToFloat((int) (canvasDrawScope.drawContext.m756getSizeNHjbRc() >> 32)) - fMo92toPx0680j_5) - layoutNodeDrawScope.mo92toPx0680j_4(paddingValues.mo119calculateRightPaddingu2uoSUM(layoutNodeDrawScope.getLayoutDirection()))), layoutNodeDrawScope.getLayoutDirection()) + fMo92toPx0680j_5;
                    float f19 = 2;
                    float f20 = fIntBitsToFloat / f19;
                    float f21 = fAlign + f20;
                    float f22 = (f21 - f20) - fMo92toPx0680j_4;
                    float f23 = f22 < 0.0f ? 0.0f : f22;
                    float f24 = f21 + f20 + fMo92toPx0680j_4;
                    float fIntBitsToFloat2 = Float.intBitsToFloat((int) (canvasDrawScope.drawContext.m756getSizeNHjbRc() >> 32));
                    float f25 = f24 > fIntBitsToFloat2 ? fIntBitsToFloat2 : f24;
                    float fIntBitsToFloat3 = Float.intBitsToFloat((int) (j8 & 4294967295L));
                    float f26 = (-fIntBitsToFloat3) / f19;
                    float f27 = fIntBitsToFloat3 / f19;
                    MenuHostHelper menuHostHelper = canvasDrawScope.drawContext;
                    long jM756getSizeNHjbRc2 = menuHostHelper.m756getSizeNHjbRc();
                    menuHostHelper.getCanvas().save();
                    try {
                        ((Parameters.Builder) menuHostHelper.mOnInvalidateMenuCallback).m790clipRectN_I0leg(f23, f26, f25, f27, 0);
                        layoutNodeDrawScope.drawContent();
                    } finally {
                        ImageAnalysis$$ExternalSyntheticLambda1.m(menuHostHelper, jM756getSizeNHjbRc2);
                    }
                } else {
                    layoutNodeDrawScope.drawContent();
                }
                return Unit.INSTANCE;
            case 13:
                JobKt.launch$default((CoroutineScope) obj3, null, new NavHostKt$NavHost$28$1((FocusStateImpl) obj, (MutableState) obj2, (TooltipStateImpl) r11, null, 20), 3);
                return Unit.INSTANCE;
            case 14:
                Recomposer$$ExternalSyntheticLambda6 recomposer$$ExternalSyntheticLambda9 = new Recomposer$$ExternalSyntheticLambda6(17, (CoroutineScope) obj2, (TooltipStateImpl) r11);
                KProperty[] kPropertyArr = SemanticsPropertiesKt.$$delegatedProperties;
                ((SemanticsPropertyReceiver) obj).set(SemanticsActions.OnLongClick, new AccessibilityAction((String) obj3, recomposer$$ExternalSyntheticLambda9));
                return Unit.INSTANCE;
            case 15:
                MeasureScope measureScope = (MeasureScope) obj3;
                DraggableAnchorsNode draggableAnchorsNode = (DraggableAnchorsNode) obj2;
                Placeable placeable = (Placeable) r11;
                Placeable.PlacementScope placementScope2 = (Placeable.PlacementScope) obj;
                float fPositionOf = measureScope.isLookingAhead() ? ((NodeChain) draggableAnchorsNode.state.val$requestCancellationCompleter).getAnchors().positionOf(((DerivedSnapshotState) draggableAnchorsNode.state.val$requestCancellationFuture).getValue()) : ((ParcelableSnapshotMutableFloatState) ((NodeChain) draggableAnchorsNode.state.val$requestCancellationCompleter).head).getFloatValue();
                boolean zIsLookingAhead = measureScope.isLookingAhead();
                if (Float.isNaN(fPositionOf)) {
                    throw new AnchoredDraggableUninitializedException(zIsLookingAhead, draggableAnchorsNode.didInitializeAnchors, ((NodeChain) draggableAnchorsNode.state.val$requestCancellationCompleter).getAnchors(), ((DerivedSnapshotState) draggableAnchorsNode.state.val$requestCancellationFuture).getValue());
                }
                LayoutDirection layoutDirection = HitTestResultKt.requireLayoutNode(draggableAnchorsNode).layoutDirection;
                LayoutDirection layoutDirection2 = LayoutDirection.Rtl;
                Orientation orientation = Orientation.Horizontal;
                float f28 = (layoutDirection == layoutDirection2 && draggableAnchorsNode.orientation == orientation) ? -1.0f : 1.0f;
                Orientation orientation2 = draggableAnchorsNode.orientation;
                float f29 = orientation2 == orientation ? f28 * fPositionOf : 0.0f;
                if (orientation2 != Orientation.Vertical) {
                    fPositionOf = 0.0f;
                }
                placementScope2.motionFrameOfReferencePlacement = true;
                Placeable.PlacementScope.place$default(placementScope2, placeable, MathKt.roundToInt(f29), MathKt.roundToInt(fPositionOf));
                Unit unit2 = Unit.INSTANCE;
                placementScope2.motionFrameOfReferencePlacement = false;
                return Unit.INSTANCE;
            case 16:
                Http2Connection.Builder builder = (Http2Connection.Builder) obj3;
                Outline$Rounded outline$Rounded = (Outline$Rounded) obj2;
                SolidColor solidColor = (SolidColor) r11;
                DrawScope drawScope4 = (DrawScope) obj;
                float f30 = ((Dp) ((Function0) builder.socket).invoke()).value;
                float f31 = 2;
                float fMin2 = Math.min(Dp.m704equalsimpl0(f30, 0.0f) ? 1.0f : (float) Math.ceil(drawScope4.mo92toPx0680j_4(f30)), (float) Math.ceil((Size.m386getMinDimensionimpl(drawScope4.mo474getSizeNHjbRc()) - (((float) Math.ceil(drawScope4.mo92toPx0680j_4(((Dp) ((Function0) builder.connectionName).invoke()).value))) * f31)) / f31));
                float f32 = fMin2 < 0.0f ? 0.0f : fMin2;
                float fCeil = (float) Math.ceil(drawScope4.mo92toPx0680j_4(((Dp) ((Function0) builder.connectionName).invoke()).value));
                float f33 = f32 / f31;
                float f34 = f33 + fCeil;
                long jFloatToRawIntBits2 = (((long) Float.floatToRawIntBits(f34)) << 32) | (((long) Float.floatToRawIntBits(f34)) & 4294967295L);
                float f35 = fCeil * f31;
                long jFloatToRawIntBits3 = (((long) Float.floatToRawIntBits((Float.intBitsToFloat((int) (drawScope4.mo474getSizeNHjbRc() >> 32)) - f32) - f35)) << 32) | (((long) Float.floatToRawIntBits((Float.intBitsToFloat((int) (drawScope4.mo474getSizeNHjbRc() & 4294967295L)) - f32) - f35)) & 4294967295L);
                if (fCeil == 0.0f && f31 * f32 > Size.m386getMinDimensionimpl(drawScope4.mo474getSizeNHjbRc())) {
                    i9 = 1;
                }
                long jM284shrinkKibmq7A = BorderKt.m284shrinkKibmq7A(fCeil, outline$Rounded.roundRect.topLeftCornerRadius);
                Stroke stroke2 = new Stroke(f32, 0.0f, 0, 0, 30);
                if (i9 != 0) {
                    Modifier.CC.m316drawRoundRectZuiqVtQ$default(drawScope4, solidColor, 0L, 0L, jM284shrinkKibmq7A, 0.0f, null, null, 0, 246);
                } else if (Float.intBitsToFloat((int) (jM284shrinkKibmq7A >> 32)) < f33) {
                    float fIntBitsToFloat4 = Float.intBitsToFloat((int) (drawScope4.mo474getSizeNHjbRc() >> 32)) - f32;
                    float fIntBitsToFloat5 = Float.intBitsToFloat((int) (drawScope4.mo474getSizeNHjbRc() & 4294967295L)) - f32;
                    MenuHostHelper drawContext2 = drawScope4.getDrawContext();
                    long jM756getSizeNHjbRc3 = drawContext2.m756getSizeNHjbRc();
                    drawContext2.getCanvas().save();
                    try {
                        ((Parameters.Builder) drawContext2.mOnInvalidateMenuCallback).m790clipRectN_I0leg(f32, f32, fIntBitsToFloat4, fIntBitsToFloat5, 0);
                        Modifier.CC.m316drawRoundRectZuiqVtQ$default(drawScope4, solidColor, 0L, 0L, jM284shrinkKibmq7A, 0.0f, null, null, 0, 246);
                    } finally {
                        ImageAnalysis$$ExternalSyntheticLambda1.m(drawContext2, jM756getSizeNHjbRc3);
                    }
                } else {
                    Modifier.CC.m316drawRoundRectZuiqVtQ$default(drawScope4, solidColor, jFloatToRawIntBits2, jFloatToRawIntBits3, BorderKt.m284shrinkKibmq7A(f33, jM284shrinkKibmq7A), 0.0f, stroke2, null, 0, 208);
                }
                return Unit.INSTANCE;
            case 17:
                SaveableStateHolderImpl saveableStateHolderImpl = (SaveableStateHolderImpl) obj3;
                SaveableStateRegistryWrapper saveableStateRegistryWrapper = (SaveableStateRegistryWrapper) r11;
                MutableScatterMap mutableScatterMap = saveableStateHolderImpl.registries;
                if (!mutableScatterMap.contains(obj2)) {
                    saveableStateHolderImpl.savedStates.remove(obj2);
                    mutableScatterMap.set(obj2, saveableStateRegistryWrapper);
                    return new DialogHostKt$DialogHost$1$2$1$1$invoke$$inlined$onDispose$1(saveableStateHolderImpl, obj2, saveableStateRegistryWrapper, i8);
                }
                throw new IllegalArgumentException(("Key " + obj2 + " was used multiple times ").toString());
            case 18:
                List list = (List) obj3;
                ((LazyListIntervalContent) obj).items(list.size(), null, new FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2(i8, list), new ComposableLambdaImpl(802480018, new MainAppKt$MainApp$2$3$1$1$1$2(list, (SimpleDateFormat) obj2, (Function1) r11, i8), true));
                return Unit.INSTANCE;
            case 19:
                List list2 = (List) obj3;
                ((LazyListIntervalContent) obj).items(list2.size(), new ContinuationCallback(i3, new AsyncImagePainter$$ExternalSyntheticLambda0(i5), list2), new FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2(i7, list2), new ComposableLambdaImpl(802480018, new MainAppKt$MainApp$2$3$1$1$1$2(list2, (Function1) r11, (ParcelableSnapshotMutableLongState) obj2, i7), true));
                return Unit.INSTANCE;
            case 20:
                final List list3 = (List) obj3;
                final List list4 = (List) obj2;
                Function2 function6 = (Function2) r11;
                LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
                if (!list3.isEmpty()) {
                    LazyItemScope$CC.item$default(lazyListIntervalContent, "active_header", new ComposableLambdaImpl(1806500718, new Function3() { // from class: com.github.kr328.clash.compose.connections.ConnectionsScreenKt$ConnectionListContent$1$1$1
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj4, Object obj5, Object obj6) {
                            switch (i9) {
                                case 0:
                                    GapComposer gapComposer = (GapComposer) obj5;
                                    if ((((Number) obj6).intValue() & 17) == 16 && gapComposer.getSkipping()) {
                                        gapComposer.skipToGroupEnd();
                                    } else {
                                        AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
                                        ConnectionsScreenKt.m805SectionHeaderRPmYEkk(StringResources_androidKt.stringResource(com.koala.clash.R.string.connections_active, gapComposer) + " (" + list3.size() + ")", appColors.statusActive, gapComposer, 0);
                                    }
                                    break;
                                default:
                                    GapComposer gapComposer2 = (GapComposer) obj5;
                                    if ((((Number) obj6).intValue() & 17) == 16 && gapComposer2.getSkipping()) {
                                        gapComposer2.skipToGroupEnd();
                                    } else {
                                        AppColors appColors2 = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
                                        ConnectionsScreenKt.m805SectionHeaderRPmYEkk(StringResources_androidKt.stringResource(com.koala.clash.R.string.connections_closed, gapComposer2) + " (" + list3.size() + ")", appColors2.statusClosed, gapComposer2, 0);
                                    }
                                    break;
                            }
                            return Unit.INSTANCE;
                        }
                    }, true), 2);
                    lazyListIntervalContent.items(list3.size(), new FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2(4, list3, new AsyncImagePainter$$ExternalSyntheticLambda0(i4)), new FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2(i3, list3), new ComposableLambdaImpl(802480018, new MainAppKt$MainApp$2$3$1$1$1$3(i10, list3, function6), true));
                }
                if (!list4.isEmpty()) {
                    LazyItemScope$CC.item$default(lazyListIntervalContent, "closed_header", new ComposableLambdaImpl(-2008266587, new Function3() { // from class: com.github.kr328.clash.compose.connections.ConnectionsScreenKt$ConnectionListContent$1$1$1
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj4, Object obj5, Object obj6) {
                            switch (i10) {
                                case 0:
                                    GapComposer gapComposer = (GapComposer) obj5;
                                    if ((((Number) obj6).intValue() & 17) == 16 && gapComposer.getSkipping()) {
                                        gapComposer.skipToGroupEnd();
                                    } else {
                                        AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
                                        ConnectionsScreenKt.m805SectionHeaderRPmYEkk(StringResources_androidKt.stringResource(com.koala.clash.R.string.connections_active, gapComposer) + " (" + list4.size() + ")", appColors.statusActive, gapComposer, 0);
                                    }
                                    break;
                                default:
                                    GapComposer gapComposer2 = (GapComposer) obj5;
                                    if ((((Number) obj6).intValue() & 17) == 16 && gapComposer2.getSkipping()) {
                                        gapComposer2.skipToGroupEnd();
                                    } else {
                                        AppColors appColors2 = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
                                        ConnectionsScreenKt.m805SectionHeaderRPmYEkk(StringResources_androidKt.stringResource(com.koala.clash.R.string.connections_closed, gapComposer2) + " (" + list4.size() + ")", appColors2.statusClosed, gapComposer2, 0);
                                    }
                                    break;
                            }
                            return Unit.INSTANCE;
                        }
                    }, true), 2);
                    lazyListIntervalContent.items(list4.size(), new ContinuationCallback(i6, new AsyncImagePainter$$ExternalSyntheticLambda0(14), list4), new FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2(i6, list4), new ComposableLambdaImpl(802480018, new MainAppKt$MainApp$2$3$1$1$1$3(i8, list4, function6), true));
                }
                if (list3.isEmpty() && list4.isEmpty()) {
                    LazyItemScope$CC.item$default(lazyListIntervalContent, null, ComposableSingletons$ConnectionsScreenKt.f24lambda1, 3);
                }
                return Unit.INSTANCE;
            case 21:
                return invoke$com$github$kr328$clash$compose$sharetotv$ShareToTvScreenKt$ShareToTvScreen$2$$ExternalSyntheticLambda0(obj);
            default:
                Function0 function7 = (Function0) obj3;
                Function0 function8 = (Function0) obj2;
                MutableState mutableState3 = (MutableState) r11;
                FocusStateImpl focusStateImpl = (FocusStateImpl) obj;
                boolean zBooleanValue = ((Boolean) mutableState3.getValue()).booleanValue();
                mutableState3.setValue(Boolean.valueOf(focusStateImpl.getHasFocus()));
                if (!zBooleanValue && focusStateImpl.getHasFocus()) {
                    function7.invoke();
                } else if (zBooleanValue && !focusStateImpl.getHasFocus()) {
                    function8.invoke();
                }
                return Unit.INSTANCE;
        }
    }

    public /* synthetic */ LifecycleEffectKt$$ExternalSyntheticLambda1(MutableState mutableState, ArrayList arrayList, List list, boolean z) {
        this.$r8$classId = 5;
        this.f$0 = mutableState;
        this.f$1 = arrayList;
        this.f$2 = list;
    }

    public /* synthetic */ LifecycleEffectKt$$ExternalSyntheticLambda1(Object obj, Object obj2, Object obj3, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
    }

    public /* synthetic */ LifecycleEffectKt$$ExternalSyntheticLambda1(Object obj, Function1 function1, Object obj2, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$2 = function1;
        this.f$1 = obj2;
    }

    public /* synthetic */ LifecycleEffectKt$$ExternalSyntheticLambda1(Function1 function1, MutableState mutableState, MutableState mutableState2) {
        this.$r8$classId = 6;
        this.f$2 = function1;
        this.f$0 = mutableState;
        this.f$1 = mutableState2;
    }

    public /* synthetic */ LifecycleEffectKt$$ExternalSyntheticLambda1(Ref$FloatRef ref$FloatRef, ScrollScope scrollScope, Ref$FloatRef ref$FloatRef2, DefaultFlingBehavior defaultFlingBehavior) {
        this.$r8$classId = 4;
        this.f$0 = ref$FloatRef;
        this.f$1 = scrollScope;
        this.f$2 = ref$FloatRef2;
    }
}
