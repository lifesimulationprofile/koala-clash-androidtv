package androidx.compose.foundation.style;

import androidx.collection.MutableObjectList;
import androidx.compose.foundation.border.BorderLogic$$ExternalSyntheticLambda1;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.style.StyleOuterNode$$ExternalSyntheticLambda1;
import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.CompositionLocalAccessorScope;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda0;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Outline$Generic;
import androidx.compose.ui.graphics.Outline$Rectangle;
import androidx.compose.ui.graphics.Outline$Rounded;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerImpl;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.graphics.shadow.DropShadowPainter;
import androidx.compose.ui.graphics.shadow.InnerShadowPainter;
import androidx.compose.ui.graphics.shadow.Shadow;
import androidx.compose.ui.layout.DefaultIntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicsMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.MenuHostHelper;
import androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda1;
import coil.RealImageLoader$execute$3;
import coil.network.HttpException;
import coil.request.Parameters;
import java.util.Arrays;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.EmptyMap;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.StandaloneCoroutine;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class StyleOuterNode extends DelegatingNode implements LayoutModifierNode, DrawModifierNode, TraversableNode, CompositionLocalConsumerModifierNode, ObserverModifierNode, CompositionLocalAccessorScope {
    public ResolvedStyle _bufferOrNull;
    public MutableStyleState _state;
    public MutableObjectList ancestorNodes;
    public StyleAnimations animations;
    public GraphicsLayer borderLayer;
    public BasicTextKt$$ExternalSyntheticLambda0 borderLayerProvider;
    public DropShadowPainter[] cachedDropShadowPainters;
    public ResolvedStyle cachedInheritedStyle;
    public InnerShadowPainter[] cachedInnerShadowPainters;
    public MutableInteractionSourceImpl currentInteractionSource;
    public boolean inheritedStyleDirty;
    public StyleInnerNode innerNodeField;
    public Shadow[] lastDropShadow;
    public Shadow[] lastInnerShadow;
    public LayoutDirection lastLayoutDirection;
    public BrushKt lastOutline;
    public Shape lastShape;
    public long lastSize;
    public Recomposer$$ExternalSyntheticLambda0 layerBlock;
    public StandaloneCoroutine sourceJob;
    public Style style;
    public ResolvedStyle _resolved = new ResolvedStyle();
    public final Request borderLogic = new Request(5, false);

    public StyleOuterNode(MutableStyleState mutableStyleState, Style style) {
        this.style = style;
        this._state = mutableStyleState == null ? new MutableStyleState(null) : mutableStyleState;
        this.lastSize = 9205357640488583168L;
    }

    public static ResolvedStyle resolveAnimatedStyleFor$foundation$default(StyleOuterNode styleOuterNode, int i) {
        ResolvedStyle resolvedStyle = styleOuterNode._resolved;
        StyleAnimations styleAnimations = styleOuterNode.animations;
        if (styleAnimations == null || styleAnimations.size <= 0) {
            return resolvedStyle;
        }
        Density density = HitTestResultKt.requireLayoutNode(styleOuterNode).density;
        ResolvedStyle resolvedStyle2 = styleAnimations.currentStyle;
        resolvedStyle.copyInto$foundation(resolvedStyle2);
        styleAnimations.applyAnimationsTo(resolvedStyle2, density, styleOuterNode, i);
        return resolvedStyle2;
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final void draw(LayoutNodeDrawScope layoutNodeDrawScope) {
        boolean z;
        ResolvedStyle resolvedStyle;
        float f;
        long j;
        DropShadowPainter[] dropShadowPainterArr;
        float f2;
        int i;
        InnerShadowPainter[] innerShadowPainterArr;
        Request request;
        Function1 lifecycleEffectKt$$ExternalSyntheticLambda1;
        Function1 borderLogic$$ExternalSyntheticLambda1;
        CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
        ResolvedStyle resolvedStyleResolveAnimatedStyleFor$foundation$default = resolveAnimatedStyleFor$foundation$default(this, 2);
        long j2 = resolvedStyleResolveAnimatedStyleFor$foundation$default.backgroundColor;
        Brush brush = resolvedStyleResolveAnimatedStyleFor$foundation$default.backgroundBrush;
        long j3 = resolvedStyleResolveAnimatedStyleFor$foundation$default.foregroundColor;
        Brush brush2 = resolvedStyleResolveAnimatedStyleFor$foundation$default.foregroundBrush;
        long j4 = resolvedStyleResolveAnimatedStyleFor$foundation$default.borderColor;
        Brush brush3 = resolvedStyleResolveAnimatedStyleFor$foundation$default.borderBrush;
        float f3 = resolvedStyleResolveAnimatedStyleFor$foundation$default.borderWidth;
        float f4 = f3 / 2.0f;
        Shape shape = resolvedStyleResolveAnimatedStyleFor$foundation$default.shape;
        boolean z2 = f4 > 0.0f;
        boolean z3 = (j2 == 16 && brush == null) ? false : true;
        boolean z4 = (j3 == 16 && brush2 == null) ? false : true;
        Object obj = resolvedStyleResolveAnimatedStyleFor$foundation$default.dropShadow;
        if (obj == null) {
            resolvedStyle = resolvedStyleResolveAnimatedStyleFor$foundation$default;
            j = j4;
            f = f3;
            z = z2;
        } else {
            z = z2;
            Shadow[] shadowArr = this.lastDropShadow;
            resolvedStyle = resolvedStyleResolveAnimatedStyleFor$foundation$default;
            DropShadowPainter[] dropShadowPainterArr2 = this.cachedDropShadowPainters;
            f = f3;
            boolean z5 = obj instanceof Object[];
            int length = z5 ? ((Object[]) obj).length : 1;
            j = j4;
            if (shadowArr == null || !Intrinsics.areEqual(this.lastShape, shape)) {
                Shadow[] shadowArr2 = new Shadow[length];
                for (int i2 = 0; i2 < length; i2++) {
                    shadowArr2[i2] = null;
                }
                this.lastDropShadow = shadowArr2;
                DropShadowPainter[] dropShadowPainterArr3 = new DropShadowPainter[length];
                for (int i3 = 0; i3 < length; i3++) {
                    dropShadowPainterArr3[i3] = null;
                }
                this.cachedDropShadowPainters = dropShadowPainterArr3;
            } else if (shadowArr.length != length) {
                this.lastDropShadow = (Shadow[]) Arrays.copyOf(shadowArr, length);
                if (dropShadowPainterArr2 != null) {
                    dropShadowPainterArr = (DropShadowPainter[]) Arrays.copyOf(dropShadowPainterArr2, length);
                } else {
                    dropShadowPainterArr = new DropShadowPainter[length];
                    for (int i4 = 0; i4 < length; i4++) {
                        dropShadowPainterArr[i4] = null;
                    }
                }
                this.cachedDropShadowPainters = dropShadowPainterArr;
            }
            if (z5) {
                Object[] objArr = (Object[]) obj;
                int length2 = objArr.length;
                for (int i5 = 0; i5 < length2; i5++) {
                    Object obj2 = objArr[i5];
                    if (obj2 instanceof Shadow) {
                        drawDropShadow(layoutNodeDrawScope, i5, shape, (Shadow) obj2);
                    }
                }
            } else if (obj instanceof Shadow) {
                drawDropShadow(layoutNodeDrawScope, 0, shape, (Shadow) obj);
            }
        }
        long jM756getSizeNHjbRc = canvasDrawScope.drawContext.m756getSizeNHjbRc();
        BrushKt brushKtMo60createOutlinePq9zytI = (Size.m384equalsimpl0(this.lastSize, jM756getSizeNHjbRc) && this.lastLayoutDirection == layoutNodeDrawScope.getLayoutDirection() && Intrinsics.areEqual(this.lastShape, shape)) ? this.lastOutline : shape.mo60createOutlinePq9zytI(jM756getSizeNHjbRc, layoutNodeDrawScope.getLayoutDirection(), layoutNodeDrawScope);
        this.lastOutline = brushKtMo60createOutlinePq9zytI;
        this.lastSize = jM756getSizeNHjbRc;
        this.lastLayoutDirection = layoutNodeDrawScope.getLayoutDirection();
        if (!z3) {
            f2 = 0.0f;
        } else if (brush != null) {
            f2 = 0.0f;
            BrushKt.m415drawOutlinehn5TExg$default(layoutNodeDrawScope, brushKtMo60createOutlinePq9zytI, brush, 0.0f, 60);
        } else {
            f2 = 0.0f;
            BrushKt.m416drawOutlinewDX37Ww$default(layoutNodeDrawScope, brushKtMo60createOutlinePq9zytI, j2);
        }
        layoutNodeDrawScope.drawContent();
        if (z4) {
            if (brush2 != null) {
                BrushKt.m415drawOutlinehn5TExg$default(layoutNodeDrawScope, brushKtMo60createOutlinePq9zytI, brush2, f2, 60);
            } else {
                BrushKt.m416drawOutlinewDX37Ww$default(layoutNodeDrawScope, brushKtMo60createOutlinePq9zytI, j3);
            }
        }
        if (z) {
            Brush solidColor = brush3 == null ? new SolidColor(j) : brush3;
            StyleOuterNode$$ExternalSyntheticLambda1 styleOuterNode$$ExternalSyntheticLambda1 = new StyleOuterNode$$ExternalSyntheticLambda1(f);
            BasicTextKt$$ExternalSyntheticLambda0 basicTextKt$$ExternalSyntheticLambda0 = this.borderLayerProvider;
            if (basicTextKt$$ExternalSyntheticLambda0 == null) {
                basicTextKt$$ExternalSyntheticLambda0 = new BasicTextKt$$ExternalSyntheticLambda0(8, this);
                this.borderLayerProvider = basicTextKt$$ExternalSyntheticLambda0;
                Unit unit = Unit.INSTANCE;
            }
            final BasicTextKt$$ExternalSyntheticLambda0 basicTextKt$$ExternalSyntheticLambda1 = basicTextKt$$ExternalSyntheticLambda0;
            final Request request2 = this.borderLogic;
            request2.method = styleOuterNode$$ExternalSyntheticLambda1;
            if (solidColor.equals((Brush) request2.headers) && Intrinsics.areEqual(brushKtMo60createOutlinePq9zytI, (BrushKt) request2.tags) && ((Function1) request2.lazyCacheControl) != null) {
                request = request2;
                i = 1;
            } else {
                request2.headers = solidColor;
                request2.tags = brushKtMo60createOutlinePq9zytI;
                if (brushKtMo60createOutlinePq9zytI instanceof Outline$Generic) {
                    final Outline$Generic outline$Generic = (Outline$Generic) brushKtMo60createOutlinePq9zytI;
                    AndroidPath androidPath = outline$Generic.path;
                    final Rect bounds = androidPath.getBounds();
                    float f5 = bounds.top;
                    float f6 = bounds.bottom;
                    float f7 = bounds.left;
                    float f8 = bounds.right;
                    final float fMin = Math.min(Math.abs(f8 - f7), Math.abs(f6 - f5));
                    AndroidPath androidPathPath = (AndroidPath) request2.url;
                    if (androidPathPath == null) {
                        androidPathPath = AndroidPath_androidKt.Path();
                        request2.url = androidPathPath;
                    }
                    androidPathPath.reset();
                    Modifier.CC.addRect$default(androidPathPath, bounds);
                    androidPathPath.m409opN5in7k0(androidPathPath, androidPath, 0);
                    final long jCeil = (((long) ((int) Math.ceil(f8 - f7))) << 32) | (((long) ((int) Math.ceil(f6 - f5))) & 4294967295L);
                    final AndroidPath androidPath2 = androidPathPath;
                    final Brush brush4 = solidColor;
                    lifecycleEffectKt$$ExternalSyntheticLambda1 = new Function1() { // from class: androidx.compose.foundation.border.BorderLogic$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj3) {
                            long j5 = jCeil;
                            AndroidPath androidPath3 = androidPath2;
                            DrawScope drawScope = (DrawScope) obj3;
                            float fFloatValue = Float.valueOf(((StyleOuterNode$$ExternalSyntheticLambda1) request2.method).f$0).floatValue();
                            float f9 = fFloatValue < 0.0f ? 0.0f : fFloatValue;
                            float f10 = 2 * f9;
                            float f11 = fMin;
                            Outline$Generic outline$Generic2 = outline$Generic;
                            Brush brush5 = brush4;
                            if (f10 > f11) {
                                Modifier.CC.m312drawPathGBMwjPU$default(drawScope, outline$Generic2.path, brush5, 0.0f, null, null, 0, 60);
                            } else {
                                GraphicsLayer graphicsLayer = (GraphicsLayer) basicTextKt$$ExternalSyntheticLambda1.invoke();
                                GraphicsLayerImpl graphicsLayerImpl = graphicsLayer.impl;
                                if (graphicsLayerImpl.mo480getCompositingStrategyke2Ky5w() != 1) {
                                    graphicsLayerImpl.mo484setCompositingStrategyWpw9cng(1);
                                }
                                Rect rect = bounds;
                                float f12 = rect.left;
                                float f13 = rect.top;
                                ((Parameters.Builder) drawScope.getDrawContext().mOnInvalidateMenuCallback).translate(f12, f13);
                                try {
                                    drawScope.mo475recordJVtK1S4(graphicsLayer, j5, new BorderLogic$$ExternalSyntheticLambda4(rect, outline$Generic2, brush5, f9, androidPath3));
                                    GraphicsLayerKt.drawLayer(drawScope, graphicsLayer);
                                } finally {
                                    ((Parameters.Builder) drawScope.getDrawContext().mOnInvalidateMenuCallback).translate(-f12, -f13);
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    request = request2;
                    i = 1;
                } else {
                    request = request2;
                    if (brushKtMo60createOutlinePq9zytI instanceof Outline$Rounded) {
                        RoundRect roundRect = ((Outline$Rounded) brushKtMo60createOutlinePq9zytI).roundRect;
                        if (RoundRectKt.isSimple(roundRect)) {
                            i = 1;
                            borderLogic$$ExternalSyntheticLambda1 = new LifecycleEffectKt$$ExternalSyntheticLambda1(request, roundRect, solidColor, i);
                        } else {
                            i = 1;
                            AndroidPath androidPathPath2 = (AndroidPath) request.url;
                            if (androidPathPath2 == null) {
                                androidPathPath2 = AndroidPath_androidKt.Path();
                                request.url = androidPathPath2;
                            }
                            AndroidPath androidPath3 = androidPathPath2;
                            Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
                            ref$FloatRef.element = Float.NaN;
                            borderLogic$$ExternalSyntheticLambda1 = new BorderLogic$$ExternalSyntheticLambda1(request, roundRect, ref$FloatRef, new Ref$ObjectRef(), androidPath3, solidColor, 0);
                        }
                        lifecycleEffectKt$$ExternalSyntheticLambda1 = borderLogic$$ExternalSyntheticLambda1;
                    } else {
                        i = 1;
                        if (!(brushKtMo60createOutlinePq9zytI instanceof Outline$Rectangle)) {
                            throw new HttpException();
                        }
                        lifecycleEffectKt$$ExternalSyntheticLambda1 = new LifecycleEffectKt$$ExternalSyntheticLambda1(request, ((Outline$Rectangle) brushKtMo60createOutlinePq9zytI).rect, solidColor, 2);
                    }
                }
                request.lazyCacheControl = lifecycleEffectKt$$ExternalSyntheticLambda1;
            }
            if (Offset.m369equalsimpl0(0L, 0L)) {
                ((Function1) request.lazyCacheControl).invoke(layoutNodeDrawScope);
            } else {
                int i6 = (int) 0;
                float fIntBitsToFloat = Float.intBitsToFloat(i6);
                float fIntBitsToFloat2 = Float.intBitsToFloat(i6);
                ((Parameters.Builder) canvasDrawScope.drawContext.mOnInvalidateMenuCallback).translate(fIntBitsToFloat, fIntBitsToFloat2);
                try {
                    ((Function1) request.lazyCacheControl).invoke(layoutNodeDrawScope);
                    ((Parameters.Builder) canvasDrawScope.drawContext.mOnInvalidateMenuCallback).translate(-fIntBitsToFloat, -fIntBitsToFloat2);
                } catch (Throwable th) {
                    ((Parameters.Builder) canvasDrawScope.drawContext.mOnInvalidateMenuCallback).translate(-fIntBitsToFloat, -fIntBitsToFloat2);
                    throw th;
                }
            }
        } else {
            i = 1;
        }
        ResolvedStyle resolvedStyle2 = resolvedStyle;
        Object obj3 = resolvedStyle2.innerShadow;
        if (obj3 != null) {
            Shape shape2 = resolvedStyle2.shape;
            Shadow[] shadowArr3 = this.lastInnerShadow;
            InnerShadowPainter[] innerShadowPainterArr2 = this.cachedInnerShadowPainters;
            boolean z6 = obj3 instanceof Object[];
            int length3 = z6 ? ((Object[]) obj3).length : i;
            if (shadowArr3 == null || !Intrinsics.areEqual(this.lastShape, shape2)) {
                Shadow[] shadowArr4 = new Shadow[length3];
                for (int i7 = 0; i7 < length3; i7++) {
                    shadowArr4[i7] = null;
                }
                this.lastInnerShadow = shadowArr4;
                InnerShadowPainter[] innerShadowPainterArr3 = new InnerShadowPainter[length3];
                for (int i8 = 0; i8 < length3; i8++) {
                    innerShadowPainterArr3[i8] = null;
                }
                this.cachedInnerShadowPainters = innerShadowPainterArr3;
            } else if (shadowArr3.length != length3) {
                this.lastInnerShadow = (Shadow[]) Arrays.copyOf(shadowArr3, length3);
                if (innerShadowPainterArr2 != null) {
                    innerShadowPainterArr = (InnerShadowPainter[]) Arrays.copyOf(innerShadowPainterArr2, length3);
                } else {
                    innerShadowPainterArr = new InnerShadowPainter[length3];
                    for (int i9 = 0; i9 < length3; i9++) {
                        innerShadowPainterArr[i9] = null;
                    }
                }
                this.cachedInnerShadowPainters = innerShadowPainterArr;
            }
            if (z6) {
                Object[] objArr2 = (Object[]) obj3;
                int length4 = objArr2.length;
                for (int i10 = 0; i10 < length4; i10++) {
                    Object obj4 = objArr2[i10];
                    if (obj4 instanceof Shadow) {
                        drawInnerShadow(layoutNodeDrawScope, i10, shape2, (Shadow) obj4);
                    }
                }
            } else if (obj3 instanceof Shadow) {
                drawInnerShadow(layoutNodeDrawScope, 0, shape2, (Shadow) obj3);
            }
        }
        this.lastShape = shape;
    }

    public final void drawDropShadow(LayoutNodeDrawScope layoutNodeDrawScope, int i, Shape shape, Shadow shadow) {
        Shadow[] shadowArr = this.lastDropShadow;
        Shadow shadow2 = shadowArr != null ? (Shadow) ArraysKt.getOrNull(i, shadowArr) : null;
        DropShadowPainter[] dropShadowPainterArr = this.cachedDropShadowPainters;
        DropShadowPainter dropShadowPainter = dropShadowPainterArr != null ? (DropShadowPainter) ArraysKt.getOrNull(i, dropShadowPainterArr) : null;
        if (!Intrinsics.areEqual(shadow2, shadow) || dropShadowPainter == null) {
            MenuHostHelper shadowContext = HitTestResultKt.requireGraphicsContext(this).getShadowContext();
            shadowContext.getClass();
            dropShadowPainter = new DropShadowPainter(shape, shadow, shadowContext);
        }
        Shadow[] shadowArr2 = this.lastDropShadow;
        if (shadowArr2 != null) {
            shadowArr2[i] = shadow;
        }
        DropShadowPainter[] dropShadowPainterArr2 = this.cachedDropShadowPainters;
        if (dropShadowPainterArr2 != null) {
            dropShadowPainterArr2[i] = dropShadowPainter;
        }
        dropShadowPainter.m495drawx_KDEd0(layoutNodeDrawScope, layoutNodeDrawScope.canvasDrawScope.drawContext.m756getSizeNHjbRc(), 1.0f, null);
    }

    public final void drawInnerShadow(LayoutNodeDrawScope layoutNodeDrawScope, int i, Shape shape, Shadow shadow) {
        Shadow[] shadowArr = this.lastInnerShadow;
        Shadow shadow2 = shadowArr != null ? (Shadow) ArraysKt.getOrNull(i, shadowArr) : null;
        InnerShadowPainter[] innerShadowPainterArr = this.cachedInnerShadowPainters;
        InnerShadowPainter innerShadowPainter = innerShadowPainterArr != null ? (InnerShadowPainter) ArraysKt.getOrNull(i, innerShadowPainterArr) : null;
        if (!Intrinsics.areEqual(shadow2, shadow) || innerShadowPainter == null) {
            MenuHostHelper shadowContext = HitTestResultKt.requireGraphicsContext(this).getShadowContext();
            shadowContext.getClass();
            innerShadowPainter = new InnerShadowPainter(shape, shadow, shadowContext);
        }
        Shadow[] shadowArr2 = this.lastInnerShadow;
        if (shadowArr2 != null) {
            shadowArr2[i] = shadow;
        }
        InnerShadowPainter[] innerShadowPainterArr2 = this.cachedInnerShadowPainters;
        if (innerShadowPainterArr2 != null) {
            innerShadowPainterArr2[i] = innerShadowPainter;
        }
        innerShadowPainter.m495drawx_KDEd0(layoutNodeDrawScope, layoutNodeDrawScope.canvasDrawScope.drawContext.m756getSizeNHjbRc(), 1.0f, null);
    }

    @Override // androidx.compose.runtime.CompositionLocalAccessorScope
    public final Object getCurrentValue(ProvidableCompositionLocal providableCompositionLocal) {
        return HitTestResultKt.currentValueOf(this, providableCompositionLocal);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public final Object getTraverseKey() {
        return "StyleOuterNode";
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final /* synthetic */ int maxIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return Modifier.CC.$default$maxIntrinsicHeight(this, lookaheadCapablePlaceable, measurable, i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final /* synthetic */ int maxIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return mo25measure3p2s80s(new IntrinsicsMeasureScope(lookaheadCapablePlaceable, lookaheadCapablePlaceable.getLayoutDirection()), new DefaultIntrinsicMeasurable(measurable, 2, 1, 2), ConstraintsKt.Constraints$default(0, 0, 0, i, 7)).getWidth();
    }

    /* JADX WARN: Code duplicated, block: B:72:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:74:0x00f7  */
    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo25measure3p2s80s(MeasureScope measureScope, Measurable measurable, final long j) {
        ResolvedStyle resolvedStyleResolveAnimatedStyleFor$foundation$default = resolveAnimatedStyleFor$foundation$default(this, 8);
        float f = resolvedStyleResolveAnimatedStyleFor$foundation$default.externalPaddingStart;
        float f2 = resolvedStyleResolveAnimatedStyleFor$foundation$default.left;
        if (!Float.isNaN(f2)) {
            f += f2;
        }
        final float f3 = f;
        float f4 = resolvedStyleResolveAnimatedStyleFor$foundation$default.externalPaddingEnd;
        float f5 = resolvedStyleResolveAnimatedStyleFor$foundation$default.right;
        if (!Float.isNaN(f5)) {
            f4 += f5;
        }
        final float f6 = f4;
        float f7 = resolvedStyleResolveAnimatedStyleFor$foundation$default.externalPaddingTop;
        float f8 = resolvedStyleResolveAnimatedStyleFor$foundation$default.top;
        if (!Float.isNaN(f8)) {
            f7 += f8;
        }
        final float f9 = f7;
        float f10 = resolvedStyleResolveAnimatedStyleFor$foundation$default.externalPaddingBottom;
        float f11 = resolvedStyleResolveAnimatedStyleFor$foundation$default.bottom;
        if (!Float.isNaN(f11)) {
            f10 += f11;
        }
        final float f12 = f10;
        int iRound = Math.round(f3 + f6);
        int iRound2 = Math.round(f9 + f12);
        int iM685getMinWidthimpl = Constraints.m685getMinWidthimpl(j) - iRound;
        if (iM685getMinWidthimpl < 0) {
            iM685getMinWidthimpl = 0;
        }
        int iM683getMaxWidthimpl = Constraints.m683getMaxWidthimpl(j);
        if (iM683getMaxWidthimpl != Integer.MAX_VALUE && (iM683getMaxWidthimpl = iM683getMaxWidthimpl + iRound) < 0) {
            iM683getMaxWidthimpl = 0;
        }
        int iM684getMinHeightimpl = Constraints.m684getMinHeightimpl(j) - iRound2;
        if (iM684getMinHeightimpl < 0) {
            iM684getMinHeightimpl = 0;
        }
        int iM682getMaxHeightimpl = Constraints.m682getMaxHeightimpl(j);
        int iRound3 = (iM682getMaxHeightimpl == Integer.MAX_VALUE || (iM682getMaxHeightimpl = iM682getMaxHeightimpl + iRound2) >= 0) ? iM682getMaxHeightimpl : 0;
        float f13 = resolvedStyleResolveAnimatedStyleFor$foundation$default.minWidth;
        if (!Float.isNaN(f13)) {
            iM685getMinWidthimpl = Math.round(f13);
        }
        float f14 = resolvedStyleResolveAnimatedStyleFor$foundation$default.maxWidth;
        if (!Float.isNaN(f14)) {
            iM683getMaxWidthimpl = Math.round(f14);
        }
        float f15 = resolvedStyleResolveAnimatedStyleFor$foundation$default.minHeight;
        if (!Float.isNaN(f15)) {
            iM684getMinHeightimpl = Math.round(f15);
        }
        float f16 = resolvedStyleResolveAnimatedStyleFor$foundation$default.maxHeight;
        if (!Float.isNaN(f16)) {
            iRound3 = Math.round(f16);
        }
        if (Float.isNaN(resolvedStyleResolveAnimatedStyleFor$foundation$default.width)) {
            if (!Float.isNaN(resolvedStyleResolveAnimatedStyleFor$foundation$default.widthFraction) && Constraints.m679getHasBoundedWidthimpl(j)) {
                int iRound4 = Math.round(iM683getMaxWidthimpl * resolvedStyleResolveAnimatedStyleFor$foundation$default.widthFraction);
                if (iRound4 >= iM685getMinWidthimpl) {
                    iM685getMinWidthimpl = iRound4;
                }
                if (iM685getMinWidthimpl > iM683getMaxWidthimpl) {
                    iM685getMinWidthimpl = iM683getMaxWidthimpl;
                }
            } else if (!Float.isNaN(resolvedStyleResolveAnimatedStyleFor$foundation$default.left) && !Float.isNaN(resolvedStyleResolveAnimatedStyleFor$foundation$default.right)) {
                iM685getMinWidthimpl = iM683getMaxWidthimpl;
            }
            if (!Float.isNaN(resolvedStyleResolveAnimatedStyleFor$foundation$default.height)) {
                if (Float.isNaN(resolvedStyleResolveAnimatedStyleFor$foundation$default.heightFraction) && Constraints.m678getHasBoundedHeightimpl(j)) {
                    int iRound5 = Math.round(iRound3 * resolvedStyleResolveAnimatedStyleFor$foundation$default.heightFraction);
                    if (iRound5 >= iM684getMinHeightimpl) {
                        iM684getMinHeightimpl = iRound5;
                    }
                    if (iM684getMinHeightimpl > iRound3) {
                        iM684getMinHeightimpl = iRound3;
                    }
                } else if (!Float.isNaN(resolvedStyleResolveAnimatedStyleFor$foundation$default.top) && !Float.isNaN(resolvedStyleResolveAnimatedStyleFor$foundation$default.bottom)) {
                    iM684getMinHeightimpl = iRound3;
                }
                final Placeable placeableMo517measureBRTryo0 = measurable.mo517measureBRTryo0(ConstraintsKt.Constraints(iM685getMinWidthimpl, iM683getMaxWidthimpl, iM684getMinHeightimpl, iRound3));
                return measureScope.layout(placeableMo517measureBRTryo0.width + iRound, placeableMo517measureBRTryo0.height + iRound2, EmptyMap.INSTANCE, new Function1() { // from class: androidx.compose.foundation.style.StyleOuterNode$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                        StyleOuterNode styleOuterNode = this.f$0;
                        ResolvedStyle resolvedStyleResolveAnimatedStyleFor$foundation$default2 = StyleOuterNode.resolveAnimatedStyleFor$foundation$default(styleOuterNode, 8);
                        boolean zIsNaN = Float.isNaN(resolvedStyleResolveAnimatedStyleFor$foundation$default2.right);
                        long j2 = j;
                        Placeable placeable = placeableMo517measureBRTryo0;
                        int iRound6 = (zIsNaN || !Float.isNaN(resolvedStyleResolveAnimatedStyleFor$foundation$default2.left)) ? Math.round(f3) : (Constraints.m683getMaxWidthimpl(j2) - placeable.width) - Math.round(f6);
                        int iRound7 = (Float.isNaN(resolvedStyleResolveAnimatedStyleFor$foundation$default2.bottom) || !Float.isNaN(resolvedStyleResolveAnimatedStyleFor$foundation$default2.top)) ? Math.round(f9) : (Constraints.m682getMaxHeightimpl(j2) - placeable.height) - Math.round(f12);
                        if ((resolvedStyleResolveAnimatedStyleFor$foundation$default2.flags & 4) != 0) {
                            Recomposer$$ExternalSyntheticLambda0 recomposer$$ExternalSyntheticLambda0 = styleOuterNode.layerBlock;
                            if (recomposer$$ExternalSyntheticLambda0 == null) {
                                recomposer$$ExternalSyntheticLambda0 = new Recomposer$$ExternalSyntheticLambda0(13, styleOuterNode);
                                styleOuterNode.layerBlock = recomposer$$ExternalSyntheticLambda0;
                            }
                            Placeable.PlacementScope.placeWithLayer$default(placementScope, placeable, iRound6, iRound7, recomposer$$ExternalSyntheticLambda0, 4);
                        } else {
                            Placeable.PlacementScope.place$default(placementScope, placeable, iRound6, iRound7);
                        }
                        return Unit.INSTANCE;
                    }
                });
            }
            iM684getMinHeightimpl = Math.round(resolvedStyleResolveAnimatedStyleFor$foundation$default.height);
            iRound3 = iM684getMinHeightimpl;
            final Placeable placeableMo517measureBRTryo1 = measurable.mo517measureBRTryo0(ConstraintsKt.Constraints(iM685getMinWidthimpl, iM683getMaxWidthimpl, iM684getMinHeightimpl, iRound3));
            return measureScope.layout(placeableMo517measureBRTryo1.width + iRound, placeableMo517measureBRTryo1.height + iRound2, EmptyMap.INSTANCE, new Function1() { // from class: androidx.compose.foundation.style.StyleOuterNode$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                    StyleOuterNode styleOuterNode = this.f$0;
                    ResolvedStyle resolvedStyleResolveAnimatedStyleFor$foundation$default2 = StyleOuterNode.resolveAnimatedStyleFor$foundation$default(styleOuterNode, 8);
                    boolean zIsNaN = Float.isNaN(resolvedStyleResolveAnimatedStyleFor$foundation$default2.right);
                    long j2 = j;
                    Placeable placeable = placeableMo517measureBRTryo1;
                    int iRound6 = (zIsNaN || !Float.isNaN(resolvedStyleResolveAnimatedStyleFor$foundation$default2.left)) ? Math.round(f3) : (Constraints.m683getMaxWidthimpl(j2) - placeable.width) - Math.round(f6);
                    int iRound7 = (Float.isNaN(resolvedStyleResolveAnimatedStyleFor$foundation$default2.bottom) || !Float.isNaN(resolvedStyleResolveAnimatedStyleFor$foundation$default2.top)) ? Math.round(f9) : (Constraints.m682getMaxHeightimpl(j2) - placeable.height) - Math.round(f12);
                    if ((resolvedStyleResolveAnimatedStyleFor$foundation$default2.flags & 4) != 0) {
                        Recomposer$$ExternalSyntheticLambda0 recomposer$$ExternalSyntheticLambda0 = styleOuterNode.layerBlock;
                        if (recomposer$$ExternalSyntheticLambda0 == null) {
                            recomposer$$ExternalSyntheticLambda0 = new Recomposer$$ExternalSyntheticLambda0(13, styleOuterNode);
                            styleOuterNode.layerBlock = recomposer$$ExternalSyntheticLambda0;
                        }
                        Placeable.PlacementScope.placeWithLayer$default(placementScope, placeable, iRound6, iRound7, recomposer$$ExternalSyntheticLambda0, 4);
                    } else {
                        Placeable.PlacementScope.place$default(placementScope, placeable, iRound6, iRound7);
                    }
                    return Unit.INSTANCE;
                }
            });
        }
        iM685getMinWidthimpl = Math.round(resolvedStyleResolveAnimatedStyleFor$foundation$default.width);
        iM683getMaxWidthimpl = iM685getMinWidthimpl;
        if (!Float.isNaN(resolvedStyleResolveAnimatedStyleFor$foundation$default.height)) {
            if (Float.isNaN(resolvedStyleResolveAnimatedStyleFor$foundation$default.heightFraction)) {
            }
            if (!Float.isNaN(resolvedStyleResolveAnimatedStyleFor$foundation$default.top)) {
                iM684getMinHeightimpl = iRound3;
            }
            final Placeable placeableMo517measureBRTryo2 = measurable.mo517measureBRTryo0(ConstraintsKt.Constraints(iM685getMinWidthimpl, iM683getMaxWidthimpl, iM684getMinHeightimpl, iRound3));
            return measureScope.layout(placeableMo517measureBRTryo2.width + iRound, placeableMo517measureBRTryo2.height + iRound2, EmptyMap.INSTANCE, new Function1() { // from class: androidx.compose.foundation.style.StyleOuterNode$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                    StyleOuterNode styleOuterNode = this.f$0;
                    ResolvedStyle resolvedStyleResolveAnimatedStyleFor$foundation$default2 = StyleOuterNode.resolveAnimatedStyleFor$foundation$default(styleOuterNode, 8);
                    boolean zIsNaN = Float.isNaN(resolvedStyleResolveAnimatedStyleFor$foundation$default2.right);
                    long j2 = j;
                    Placeable placeable = placeableMo517measureBRTryo2;
                    int iRound6 = (zIsNaN || !Float.isNaN(resolvedStyleResolveAnimatedStyleFor$foundation$default2.left)) ? Math.round(f3) : (Constraints.m683getMaxWidthimpl(j2) - placeable.width) - Math.round(f6);
                    int iRound7 = (Float.isNaN(resolvedStyleResolveAnimatedStyleFor$foundation$default2.bottom) || !Float.isNaN(resolvedStyleResolveAnimatedStyleFor$foundation$default2.top)) ? Math.round(f9) : (Constraints.m682getMaxHeightimpl(j2) - placeable.height) - Math.round(f12);
                    if ((resolvedStyleResolveAnimatedStyleFor$foundation$default2.flags & 4) != 0) {
                        Recomposer$$ExternalSyntheticLambda0 recomposer$$ExternalSyntheticLambda0 = styleOuterNode.layerBlock;
                        if (recomposer$$ExternalSyntheticLambda0 == null) {
                            recomposer$$ExternalSyntheticLambda0 = new Recomposer$$ExternalSyntheticLambda0(13, styleOuterNode);
                            styleOuterNode.layerBlock = recomposer$$ExternalSyntheticLambda0;
                        }
                        Placeable.PlacementScope.placeWithLayer$default(placementScope, placeable, iRound6, iRound7, recomposer$$ExternalSyntheticLambda0, 4);
                    } else {
                        Placeable.PlacementScope.place$default(placementScope, placeable, iRound6, iRound7);
                    }
                    return Unit.INSTANCE;
                }
            });
        }
        iM684getMinHeightimpl = Math.round(resolvedStyleResolveAnimatedStyleFor$foundation$default.height);
        iRound3 = iM684getMinHeightimpl;
        final Placeable placeableMo517measureBRTryo3 = measurable.mo517measureBRTryo0(ConstraintsKt.Constraints(iM685getMinWidthimpl, iM683getMaxWidthimpl, iM684getMinHeightimpl, iRound3));
        return measureScope.layout(placeableMo517measureBRTryo3.width + iRound, placeableMo517measureBRTryo3.height + iRound2, EmptyMap.INSTANCE, new Function1() { // from class: androidx.compose.foundation.style.StyleOuterNode$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                StyleOuterNode styleOuterNode = this.f$0;
                ResolvedStyle resolvedStyleResolveAnimatedStyleFor$foundation$default2 = StyleOuterNode.resolveAnimatedStyleFor$foundation$default(styleOuterNode, 8);
                boolean zIsNaN = Float.isNaN(resolvedStyleResolveAnimatedStyleFor$foundation$default2.right);
                long j2 = j;
                Placeable placeable = placeableMo517measureBRTryo3;
                int iRound6 = (zIsNaN || !Float.isNaN(resolvedStyleResolveAnimatedStyleFor$foundation$default2.left)) ? Math.round(f3) : (Constraints.m683getMaxWidthimpl(j2) - placeable.width) - Math.round(f6);
                int iRound7 = (Float.isNaN(resolvedStyleResolveAnimatedStyleFor$foundation$default2.bottom) || !Float.isNaN(resolvedStyleResolveAnimatedStyleFor$foundation$default2.top)) ? Math.round(f9) : (Constraints.m682getMaxHeightimpl(j2) - placeable.height) - Math.round(f12);
                if ((resolvedStyleResolveAnimatedStyleFor$foundation$default2.flags & 4) != 0) {
                    Recomposer$$ExternalSyntheticLambda0 recomposer$$ExternalSyntheticLambda0 = styleOuterNode.layerBlock;
                    if (recomposer$$ExternalSyntheticLambda0 == null) {
                        recomposer$$ExternalSyntheticLambda0 = new Recomposer$$ExternalSyntheticLambda0(13, styleOuterNode);
                        styleOuterNode.layerBlock = recomposer$$ExternalSyntheticLambda0;
                    }
                    Placeable.PlacementScope.placeWithLayer$default(placementScope, placeable, iRound6, iRound7, recomposer$$ExternalSyntheticLambda0, 4);
                } else {
                    Placeable.PlacementScope.place$default(placementScope, placeable, iRound6, iRound7);
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final /* synthetic */ int minIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return mo25measure3p2s80s(new IntrinsicsMeasureScope(lookaheadCapablePlaceable, lookaheadCapablePlaceable.getLayoutDirection()), new DefaultIntrinsicMeasurable(measurable, 1, 2, 2), ConstraintsKt.Constraints$default(0, i, 0, 0, 13)).getHeight();
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final /* synthetic */ int minIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return Modifier.CC.$default$minIntrinsicWidth(this, lookaheadCapablePlaceable, measurable, i);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        GraphicsLayer graphicsLayer = this.borderLayer;
        if (graphicsLayer != null) {
            HitTestResultKt.requireGraphicsContext(this).releaseGraphicsLayer(graphicsLayer);
            this.borderLayer = null;
        }
        this.borderLayerProvider = null;
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public final void onObservedReadsChanged() {
        resolveStyleAndInvalidate(false);
    }

    public final void resolveStyleAndInvalidate(final boolean z) {
        ResolvedStyle resolvedStyle;
        if (this.isAttached) {
            Continuation continuation = null;
            final ResolvedStyle resolvedStyle2 = z ? null : this._resolved;
            if (z) {
                resolvedStyle = this._resolved;
            } else {
                if (this._bufferOrNull == null) {
                    this._bufferOrNull = new ResolvedStyle();
                }
                resolvedStyle = this._bufferOrNull;
            }
            final ResolvedStyle resolvedStyle3 = resolvedStyle;
            final Density density = HitTestResultKt.requireLayoutNode(this).density;
            resolvedStyle3.getClass();
            ResolvedStyleKt.EmptyResolvedStyle.copyInto$foundation(resolvedStyle3);
            StyleAnimations styleAnimations = this.animations;
            if (styleAnimations != null) {
                StyleAnimations.Entry[] entryArr = styleAnimations.values;
                int i = styleAnimations.size;
                for (int i2 = 0; i2 < i; i2++) {
                    StyleAnimations.Entry entry = entryArr[i2];
                    if (entry != null) {
                        int i3 = entry.state;
                        if (i3 == 2 || i3 == 3) {
                            i3 = 1;
                        }
                        entry.state = i3;
                    }
                }
            }
            final Ref$IntRef ref$IntRef = new Ref$IntRef();
            HitTestResultKt.observeReads(this, new Function0() { // from class: androidx.compose.foundation.style.StyleOuterNode$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    StyleOuterNode styleOuterNode = this;
                    Style style = styleOuterNode.style;
                    ResolvedStyle resolvedStyle4 = resolvedStyle3;
                    Density density2 = density;
                    int i4 = 0;
                    resolvedStyle4.resolve$foundation(style, styleOuterNode, density2, false);
                    styleOuterNode._resolved = resolvedStyle4;
                    styleOuterNode._bufferOrNull = resolvedStyle2;
                    StyleAnimations styleAnimations2 = styleOuterNode.animations;
                    if (styleAnimations2 != null) {
                        StyleAnimations.Entry[] entryArr2 = styleAnimations2.values;
                        int i5 = styleAnimations2.size;
                        int i6 = 0;
                        while (i4 < i5) {
                            StyleAnimations.Entry entry2 = entryArr2[i4];
                            if (entry2 != null) {
                                StyleAnimations styleAnimations3 = StyleAnimations.this;
                                ResolvedStyle resolvedStyle5 = entry2.styleScope;
                                int i7 = entry2.state;
                                boolean z2 = z;
                                if (i7 == 3) {
                                    resolvedStyle5.resolve$foundation(entry2.style, styleOuterNode, density2, true);
                                    i6 |= resolvedStyle5.flags;
                                    if (z2) {
                                        CoroutineScope coroutineScope = styleOuterNode.node.getCoroutineScope();
                                        StandaloneCoroutine standaloneCoroutine = entry2.job;
                                        if (standaloneCoroutine != null) {
                                            standaloneCoroutine.cancel((CancellationException) null);
                                        }
                                        entry2.job = JobKt.launch$default(coroutineScope, null, new StyleAnimations$Entry$snapIn$1(entry2, null, 0), 3);
                                    } else {
                                        CoroutineScope coroutineScope2 = styleOuterNode.node.getCoroutineScope();
                                        StandaloneCoroutine standaloneCoroutine2 = entry2.job;
                                        if (standaloneCoroutine2 != null) {
                                            standaloneCoroutine2.cancel((CancellationException) null);
                                        }
                                        entry2.job = JobKt.launch$default(coroutineScope2, null, new StyleAnimations$Entry$snapIn$1(entry2, null, 1), 3);
                                    }
                                } else if (i7 == 1) {
                                    entry2.state = 4;
                                    resolvedStyle5.getClass();
                                    ResolvedStyleKt.EmptyResolvedStyle.copyInto$foundation(resolvedStyle5);
                                    resolvedStyle5.resolve$foundation(entry2.style, styleOuterNode, density2, true);
                                    i6 |= resolvedStyle5.flags;
                                    if (z2) {
                                        CoroutineScope coroutineScope3 = styleOuterNode.node.getCoroutineScope();
                                        StandaloneCoroutine standaloneCoroutine3 = entry2.job;
                                        if (standaloneCoroutine3 != null) {
                                            standaloneCoroutine3.cancel((CancellationException) null);
                                        }
                                        entry2.job = JobKt.launch$default(coroutineScope3, null, new StyleAnimations$Entry$snapOut$1(entry2, styleAnimations3, null, 0), 3);
                                    } else {
                                        CoroutineScope coroutineScope4 = styleOuterNode.node.getCoroutineScope();
                                        StandaloneCoroutine standaloneCoroutine4 = entry2.job;
                                        if (standaloneCoroutine4 != null) {
                                            standaloneCoroutine4.cancel((CancellationException) null);
                                        }
                                        entry2.job = JobKt.launch$default(coroutineScope4, null, new StyleAnimations$Entry$snapOut$1(entry2, styleAnimations3, null, 1), 3);
                                    }
                                }
                            }
                            i4++;
                        }
                        i4 = i6;
                    }
                    ref$IntRef.element = i4;
                    return Unit.INSTANCE;
                }
            });
            int iDiff$foundation = ref$IntRef.element | (resolvedStyle2 != null ? resolvedStyle2.diff$foundation(resolvedStyle3, -1) : resolvedStyle3.flags);
            if (!Intrinsics.areEqual(this._state.interactionSource, this.currentInteractionSource)) {
                StandaloneCoroutine standaloneCoroutine = this.sourceJob;
                if (standaloneCoroutine != null) {
                    standaloneCoroutine.cancel((CancellationException) null);
                }
                MutableInteractionSourceImpl mutableInteractionSourceImpl = this._state.interactionSource;
                this.currentInteractionSource = mutableInteractionSourceImpl;
                if (mutableInteractionSourceImpl != null) {
                    this.sourceJob = JobKt.launch$default(getCoroutineScope(), null, new RealImageLoader$execute$3(this, mutableInteractionSourceImpl, continuation, 11), 3);
                }
            }
            if (z) {
                return;
            }
            if ((iDiff$foundation & 1) != 0) {
                StyleInnerNode styleInnerNode = this.innerNodeField;
                if (styleInnerNode == null) {
                    throw new IllegalStateException("StyleOuterNode with no corresponding StyleInnerNode");
                }
                HitTestResultKt.invalidateMeasurement(styleInnerNode);
            }
            if ((iDiff$foundation & 8) != 0) {
                HitTestResultKt.invalidateMeasurement(this);
            }
            if ((iDiff$foundation & 2) != 0) {
                StyleInnerNode styleInnerNode2 = this.innerNodeField;
                if (styleInnerNode2 == null) {
                    throw new IllegalStateException("StyleOuterNode with no corresponding StyleInnerNode");
                }
                HitTestResultKt.invalidateLayer(styleInnerNode2);
            }
            if ((iDiff$foundation & 4) != 0) {
                Recomposer$$ExternalSyntheticLambda0 recomposer$$ExternalSyntheticLambda0 = this.layerBlock;
                if (recomposer$$ExternalSyntheticLambda0 == null) {
                    recomposer$$ExternalSyntheticLambda0 = new Recomposer$$ExternalSyntheticLambda0(13, this);
                    this.layerBlock = recomposer$$ExternalSyntheticLambda0;
                }
                HitTestResultKt.updateLayerBlock(this, recomposer$$ExternalSyntheticLambda0);
            }
            if ((iDiff$foundation & 32) != 0) {
                this.inheritedStyleDirty = true;
                if (this.node.isAttached) {
                    HitTestResultKt.requireLayoutNode(this).invalidateMeasurementForSubtree();
                }
            }
            if ((iDiff$foundation & 64) != 0) {
                this.inheritedStyleDirty = true;
                if (this.node.isAttached) {
                    HitTestResultKt.requireLayoutNode(this).invalidateDrawForSubtree(true);
                }
            }
        }
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final /* synthetic */ void onMeasureResultChanged() {
    }
}
