package androidx.compose.material3.internal.ripple;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.camera.core.SurfaceRequest;
import androidx.collection.MutableObjectList;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda0;
import androidx.compose.material3.DelegatingThemeAwareRippleNode$attachNewRipple$calculateColor$1;
import androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.core.view.MenuHostHelper;
import coil.RealImageLoader$execute$3;
import coil.request.Parameters;
import com.google.android.gms.internal.mlkit_vision_barcode.zzry;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.math.MathKt;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidRippleNode extends Modifier.Node implements CompositionLocalConsumerModifierNode, DrawModifierNode, LayoutAwareModifierNode {
    public final boolean bounded;
    public final DelegatingThemeAwareRippleNode$attachNewRipple$calculateColor$1 color;
    public Interaction currentInteraction;
    public MenuHostHelper focusedBorderLogic;
    public boolean hasValidSize;
    public final MutableInteractionSourceImpl interactionSource;
    public final float radius;
    public RippleContainer rippleContainer;
    public RippleHostView rippleHostView;
    public final GapComposer$$ExternalSyntheticLambda0 rippleNodeConfig;
    public float targetRadius;
    public long rippleSize = 0;
    public final MutableObjectList pendingInteractions = new MutableObjectList();
    public final Animatable animatedAlpha = ArcSplineKt.Animatable$default(0.0f);
    public final ArrayList interactions = new ArrayList();
    public final Animatable animatedFocusRingInterpolation = ArcSplineKt.Animatable$default(0.0f);
    public final ParcelableSnapshotMutableState isFocused$delegate = Stack.mutableStateOf$default(Boolean.FALSE);

    public AndroidRippleNode(MutableInteractionSourceImpl mutableInteractionSourceImpl, boolean z, float f, DelegatingThemeAwareRippleNode$attachNewRipple$calculateColor$1 delegatingThemeAwareRippleNode$attachNewRipple$calculateColor$1, GapComposer$$ExternalSyntheticLambda0 gapComposer$$ExternalSyntheticLambda0) {
        this.interactionSource = mutableInteractionSourceImpl;
        this.bounded = z;
        this.radius = f;
        this.color = delegatingThemeAwareRippleNode$attachNewRipple$calculateColor$1;
        this.rippleNodeConfig = gapComposer$$ExternalSyntheticLambda0;
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final void draw(LayoutNodeDrawScope layoutNodeDrawScope) throws Throwable {
        long j;
        LayoutNodeDrawScope layoutNodeDrawScope2 = layoutNodeDrawScope;
        layoutNodeDrawScope2.drawContent();
        CanvasDrawScope canvasDrawScope = layoutNodeDrawScope2.canvasDrawScope;
        Canvas canvas = canvasDrawScope.drawContext.getCanvas();
        RippleHostView rippleHostView = this.rippleHostView;
        if (rippleHostView != null) {
            rippleHostView.m287setRipplePropertiesbiQXAtU(this.rippleSize, MathKt.roundToInt(this.targetRadius), this.color.mo13invoke0d7_KjU(), ((RippleNodeConfig) this.rippleNodeConfig.invoke()).press instanceof RippleNodeConfig$Press$Opacity ? 0.1f : 0.0f);
            android.graphics.Canvas canvas2 = AndroidCanvas_androidKt.EmptyCanvas;
            rippleHostView.draw(((AndroidCanvas) canvas).internalCanvas);
        }
        float fFloatValue = ((Number) this.animatedAlpha.getValue()).floatValue();
        if (fFloatValue > 0.0f) {
            long jMo13invoke0d7_KjU = this.color.mo13invoke0d7_KjU();
            long jColor = BrushKt.Color(Color.m440getRedimpl(jMo13invoke0d7_KjU), Color.m439getGreenimpl(jMo13invoke0d7_KjU), Color.m437getBlueimpl(jMo13invoke0d7_KjU), fFloatValue, Color.m438getColorSpaceimpl(jMo13invoke0d7_KjU));
            if (this.bounded) {
                float fIntBitsToFloat = Float.intBitsToFloat((int) (layoutNodeDrawScope2.mo474getSizeNHjbRc() >> 32));
                float fIntBitsToFloat2 = Float.intBitsToFloat((int) (layoutNodeDrawScope2.mo474getSizeNHjbRc() & 4294967295L));
                MenuHostHelper menuHostHelper = canvasDrawScope.drawContext;
                long jM756getSizeNHjbRc = menuHostHelper.m756getSizeNHjbRc();
                menuHostHelper.getCanvas().save();
                try {
                    ((Parameters.Builder) menuHostHelper.mOnInvalidateMenuCallback).m790clipRectN_I0leg(0.0f, 0.0f, fIntBitsToFloat, fIntBitsToFloat2, 1);
                    try {
                        j = jM756getSizeNHjbRc;
                        try {
                            Modifier.CC.m308drawCircleVaOC9Bg$default(layoutNodeDrawScope2, jColor, this.targetRadius, 0L, null, 124);
                            ImageAnalysis$$ExternalSyntheticLambda1.m(menuHostHelper, j);
                            layoutNodeDrawScope2 = layoutNodeDrawScope;
                        } catch (Throwable th) {
                            th = th;
                            ImageAnalysis$$ExternalSyntheticLambda1.m(menuHostHelper, j);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        j = jM756getSizeNHjbRc;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    j = jM756getSizeNHjbRc;
                }
            } else {
                layoutNodeDrawScope2 = layoutNodeDrawScope;
                Modifier.CC.m308drawCircleVaOC9Bg$default(layoutNodeDrawScope2, jColor, this.targetRadius, 0L, null, 124);
            }
        }
        if (((Number) this.animatedFocusRingInterpolation.getValue()).floatValue() > 0.0f) {
            MenuHostHelper menuHostHelper2 = this.focusedBorderLogic;
            if (menuHostHelper2 == null) {
                menuHostHelper2 = new MenuHostHelper(this);
            }
            this.focusedBorderLogic = menuHostHelper2;
            zzry zzryVar = ((RippleNodeConfig) this.rippleNodeConfig.invoke()).focus;
            final RippleNodeConfig$Focus$InsetRing rippleNodeConfig$Focus$InsetRing = zzryVar instanceof RippleNodeConfig$Focus$InsetRing ? (RippleNodeConfig$Focus$InsetRing) zzryVar : null;
            if (rippleNodeConfig$Focus$InsetRing == null) {
                return;
            }
            BrushKt brushKtMo60createOutlinePq9zytI = rippleNodeConfig$Focus$InsetRing.shape.mo60createOutlinePq9zytI(layoutNodeDrawScope2.mo474getSizeNHjbRc(), layoutNodeDrawScope2.getLayoutDirection(), layoutNodeDrawScope2);
            MenuHostHelper menuHostHelper3 = this.focusedBorderLogic;
            final int i = 0;
            Function0 function0 = new Function0() { // from class: androidx.compose.material3.internal.ripple.RippleNode$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    switch (i) {
                        case 0:
                            return new Dp(((Number) this.animatedFocusRingInterpolation.getValue()).floatValue() * rippleNodeConfig$Focus$InsetRing.innerStrokeWidth);
                        case 1:
                            return new Dp(((Number) this.animatedFocusRingInterpolation.getValue()).floatValue() * rippleNodeConfig$Focus$InsetRing.innerStrokeInset);
                        case 2:
                            return new Dp(((Number) this.animatedFocusRingInterpolation.getValue()).floatValue() * rippleNodeConfig$Focus$InsetRing.outerStrokeWidth);
                        default:
                            return new Dp(((Number) this.animatedFocusRingInterpolation.getValue()).floatValue() * rippleNodeConfig$Focus$InsetRing.outerStrokeInset);
                    }
                }
            };
            final int i2 = 1;
            menuHostHelper3.drawBorder(layoutNodeDrawScope, function0, new Function0() { // from class: androidx.compose.material3.internal.ripple.RippleNode$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    switch (i2) {
                        case 0:
                            return new Dp(((Number) this.animatedFocusRingInterpolation.getValue()).floatValue() * rippleNodeConfig$Focus$InsetRing.innerStrokeWidth);
                        case 1:
                            return new Dp(((Number) this.animatedFocusRingInterpolation.getValue()).floatValue() * rippleNodeConfig$Focus$InsetRing.innerStrokeInset);
                        case 2:
                            return new Dp(((Number) this.animatedFocusRingInterpolation.getValue()).floatValue() * rippleNodeConfig$Focus$InsetRing.outerStrokeWidth);
                        default:
                            return new Dp(((Number) this.animatedFocusRingInterpolation.getValue()).floatValue() * rippleNodeConfig$Focus$InsetRing.outerStrokeInset);
                    }
                }
            }, new SolidColor(rippleNodeConfig$Focus$InsetRing.innerStrokeColor.mo13invoke0d7_KjU()), brushKtMo60createOutlinePq9zytI);
            MenuHostHelper menuHostHelper4 = this.focusedBorderLogic;
            final int i3 = 2;
            Function0 function1 = new Function0() { // from class: androidx.compose.material3.internal.ripple.RippleNode$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    switch (i3) {
                        case 0:
                            return new Dp(((Number) this.animatedFocusRingInterpolation.getValue()).floatValue() * rippleNodeConfig$Focus$InsetRing.innerStrokeWidth);
                        case 1:
                            return new Dp(((Number) this.animatedFocusRingInterpolation.getValue()).floatValue() * rippleNodeConfig$Focus$InsetRing.innerStrokeInset);
                        case 2:
                            return new Dp(((Number) this.animatedFocusRingInterpolation.getValue()).floatValue() * rippleNodeConfig$Focus$InsetRing.outerStrokeWidth);
                        default:
                            return new Dp(((Number) this.animatedFocusRingInterpolation.getValue()).floatValue() * rippleNodeConfig$Focus$InsetRing.outerStrokeInset);
                    }
                }
            };
            final int i4 = 3;
            menuHostHelper4.drawBorder(layoutNodeDrawScope, function1, new Function0() { // from class: androidx.compose.material3.internal.ripple.RippleNode$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    switch (i4) {
                        case 0:
                            return new Dp(((Number) this.animatedFocusRingInterpolation.getValue()).floatValue() * rippleNodeConfig$Focus$InsetRing.innerStrokeWidth);
                        case 1:
                            return new Dp(((Number) this.animatedFocusRingInterpolation.getValue()).floatValue() * rippleNodeConfig$Focus$InsetRing.innerStrokeInset);
                        case 2:
                            return new Dp(((Number) this.animatedFocusRingInterpolation.getValue()).floatValue() * rippleNodeConfig$Focus$InsetRing.outerStrokeWidth);
                        default:
                            return new Dp(((Number) this.animatedFocusRingInterpolation.getValue()).floatValue() * rippleNodeConfig$Focus$InsetRing.outerStrokeInset);
                    }
                }
            }, new SolidColor(rippleNodeConfig$Focus$InsetRing.outerStrokeColor.mo13invoke0d7_KjU()), brushKtMo60createOutlinePq9zytI);
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    public final void handlePressInteraction(PressInteraction pressInteraction) {
        RippleHostView rippleHostView;
        if (!(pressInteraction instanceof PressInteraction.Press)) {
            if (pressInteraction instanceof PressInteraction.Release) {
                RippleHostView rippleHostView2 = this.rippleHostView;
                if (rippleHostView2 != null) {
                    rippleHostView2.removeRipple();
                    return;
                }
                return;
            }
            if (!(pressInteraction instanceof PressInteraction.Cancel) || (rippleHostView = this.rippleHostView) == null) {
                return;
            }
            rippleHostView.removeRipple();
            return;
        }
        PressInteraction.Press press = (PressInteraction.Press) pressInteraction;
        long j = this.rippleSize;
        float f = this.targetRadius;
        RippleContainer rippleContainer = this.rippleContainer;
        if (rippleContainer == null) {
            Object obj = (View) HitTestResultKt.currentValueOf(this, AndroidCompositionLocals_androidKt.LocalView);
            while (!(obj instanceof ViewGroup)) {
                ViewParent parent = ((View) obj).getParent();
                if (!(parent instanceof View)) {
                    throw new IllegalArgumentException(("Couldn't find a valid parent for " + obj + ". Are you overriding LocalView and providing a View that is not attached to the view hierarchy?").toString());
                }
                obj = parent;
            }
            ViewGroup viewGroup = (ViewGroup) obj;
            int childCount = viewGroup.getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    RippleContainer rippleContainer2 = new RippleContainer(viewGroup.getContext());
                    viewGroup.addView(rippleContainer2);
                    rippleContainer = rippleContainer2;
                    break;
                } else {
                    View childAt = viewGroup.getChildAt(i);
                    if (childAt instanceof RippleContainer) {
                        rippleContainer = (RippleContainer) childAt;
                        break;
                    }
                    i++;
                }
            }
            this.rippleContainer = rippleContainer;
        }
        ArrayList arrayList = rippleContainer.rippleHosts;
        SurfaceRequest.AnonymousClass1 anonymousClass1 = rippleContainer.rippleHostMap;
        LinkedHashMap linkedHashMap = (LinkedHashMap) anonymousClass1.val$requestCancellationCompleter;
        LinkedHashMap linkedHashMap2 = (LinkedHashMap) anonymousClass1.val$requestCancellationCompleter;
        LinkedHashMap linkedHashMap3 = (LinkedHashMap) anonymousClass1.val$requestCancellationFuture;
        RippleHostView rippleHostView3 = (RippleHostView) linkedHashMap.get(this);
        if (rippleHostView3 == null) {
            ArrayList arrayList2 = rippleContainer.unusedRippleHosts;
            rippleHostView3 = (RippleHostView) (arrayList2.isEmpty() ? null : arrayList2.remove(0));
            if (rippleHostView3 == null) {
                if (rippleContainer.nextHostIndex > AppCompatHintHelper.getLastIndex(arrayList)) {
                    rippleHostView3 = new RippleHostView(rippleContainer.getContext());
                    rippleContainer.addView(rippleHostView3);
                    arrayList.add(rippleHostView3);
                } else {
                    rippleHostView3 = (RippleHostView) arrayList.get(rippleContainer.nextHostIndex);
                    AndroidRippleNode androidRippleNode = (AndroidRippleNode) linkedHashMap3.get(rippleHostView3);
                    if (androidRippleNode != null) {
                        androidRippleNode.rippleHostView = null;
                        HitTestResultKt.invalidateDraw(androidRippleNode);
                        RippleHostView rippleHostView4 = (RippleHostView) linkedHashMap2.get(androidRippleNode);
                        if (rippleHostView4 != null) {
                        }
                        linkedHashMap2.remove(androidRippleNode);
                        rippleHostView3.disposeRipple();
                    }
                }
                int i2 = rippleContainer.nextHostIndex;
                if (i2 < rippleContainer.MaxRippleHosts - 1) {
                    rippleContainer.nextHostIndex = i2 + 1;
                } else {
                    rippleContainer.nextHostIndex = 0;
                }
            }
            linkedHashMap2.put(this, rippleHostView3);
            linkedHashMap3.put(rippleHostView3, this);
        }
        RippleHostView rippleHostView5 = rippleHostView3;
        rippleHostView5.m286addRippleKOepWvA(press, this.bounded, j, MathKt.roundToInt(f), this.color.mo13invoke0d7_KjU(), ((RippleNodeConfig) this.rippleNodeConfig.invoke()).press instanceof RippleNodeConfig$Press$Opacity ? 0.1f : 0.0f, new BasicTextKt$$ExternalSyntheticLambda0(22, this));
        this.rippleHostView = rippleHostView5;
        HitTestResultKt.invalidateDraw(this);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        JobKt.launch$default(getCoroutineScope(), null, new RealImageLoader$execute$3(this, (Continuation) null, 21), 3);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() throws Throwable {
        RippleContainer rippleContainer = this.rippleContainer;
        if (rippleContainer != null) {
            this.rippleHostView = null;
            HitTestResultKt.invalidateDraw(this);
            SurfaceRequest.AnonymousClass1 anonymousClass1 = rippleContainer.rippleHostMap;
            RippleHostView rippleHostView = (RippleHostView) ((LinkedHashMap) anonymousClass1.val$requestCancellationCompleter).get(this);
            if (rippleHostView != null) {
                rippleHostView.disposeRipple();
                LinkedHashMap linkedHashMap = (LinkedHashMap) anonymousClass1.val$requestCancellationCompleter;
                RippleHostView rippleHostView2 = (RippleHostView) linkedHashMap.get(this);
                if (rippleHostView2 != null) {
                }
                linkedHashMap.remove(this);
                rippleContainer.unusedRippleHosts.add(rippleHostView);
            }
        }
    }

    @Override // androidx.compose.ui.node.MeasuredSizeAwareModifierNode
    /* JADX INFO: renamed from: onRemeasured-ozmzZPI */
    public final void mo66onRemeasuredozmzZPI(long j) {
        float fMo92toPx0680j_4;
        this.hasValidSize = true;
        Density density = HitTestResultKt.requireLayoutNode(this).density;
        this.rippleSize = IntSizeKt.m724toSizeozmzZPI(j);
        float f = this.radius;
        if (Float.isNaN(f)) {
            long j2 = this.rippleSize;
            float f2 = RippleAnimationKt.BoundedRippleExtraRadius;
            float fIntBitsToFloat = Float.intBitsToFloat((int) (j2 >> 32));
            fMo92toPx0680j_4 = Offset.m370getDistanceimpl((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j2 & 4294967295L)))) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32)) / 2.0f;
            if (this.bounded) {
                fMo92toPx0680j_4 += density.mo92toPx0680j_4(RippleAnimationKt.BoundedRippleExtraRadius);
            }
        } else {
            fMo92toPx0680j_4 = density.mo92toPx0680j_4(f);
        }
        this.targetRadius = fMo92toPx0680j_4;
        MutableObjectList mutableObjectList = this.pendingInteractions;
        Object[] objArr = mutableObjectList.content;
        int i = mutableObjectList._size;
        for (int i2 = 0; i2 < i; i2++) {
            handlePressInteraction((PressInteraction) objArr[i2]);
        }
        mutableObjectList.clear();
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final /* synthetic */ void onMeasureResultChanged() {
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    public final /* synthetic */ void onPlaced(LayoutCoordinates layoutCoordinates) {
    }
}
