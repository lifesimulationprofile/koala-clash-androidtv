package androidx.compose.ui.platform;

import android.os.Build;
import android.view.ViewParent;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerImpl;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.navigation.Navigator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class GraphicsLayerOwnerLayer implements OwnedLayer {
    public final GraphicsContext context;
    public Function2 drawBlock;
    public boolean drawnWithEnabledZ;
    public GraphicsLayer graphicsLayer;
    public Function0 invalidateParentLayer;
    public float[] inverseMatrixCache;
    public boolean isDestroyed;
    public boolean isDirty;
    public boolean isInverseMatrixDirty;
    public boolean isMatrixDirty;
    public int mutatedFields;
    public BrushKt outline;
    public final AndroidComposeView ownerView;
    public long size;
    public final float[] matrixCache = Matrix.m442constructorimpl$default();
    public Density density = DensityKt.Density$default();
    public LayoutDirection layoutDirection = LayoutDirection.Ltr;
    public final CanvasDrawScope scope = new CanvasDrawScope();
    public long transformOrigin = TransformOrigin.Center;
    public boolean isIdentity = true;
    public final Navigator.AnonymousClass1 recordLambda = new Navigator.AnonymousClass1(22, this);

    public GraphicsLayerOwnerLayer(GraphicsLayer graphicsLayer, GraphicsContext graphicsContext, AndroidComposeView androidComposeView, Function2 function2, Function0 function0) {
        this.graphicsLayer = graphicsLayer;
        this.context = graphicsContext;
        this.ownerView = androidComposeView;
        this.drawBlock = function2;
        this.invalidateParentLayer = function0;
        long j = Integer.MAX_VALUE;
        this.size = (j & 4294967295L) | (j << 32);
    }

    /* JADX INFO: renamed from: getInverseMatrix-3i98HWw, reason: not valid java name */
    public final float[] m605getInverseMatrix3i98HWw() {
        float[] fArrM442constructorimpl$default = this.inverseMatrixCache;
        if (fArrM442constructorimpl$default == null) {
            fArrM442constructorimpl$default = Matrix.m442constructorimpl$default();
            this.inverseMatrixCache = fArrM442constructorimpl$default;
        }
        if (this.isInverseMatrixDirty) {
            this.isInverseMatrixDirty = false;
            float[] fArrM606getMatrixsQKQjiQ = m606getMatrixsQKQjiQ();
            if (this.isIdentity) {
                return fArrM606getMatrixsQKQjiQ;
            }
            if (!InvertMatrixKt.m611invertToJiSxe2E(fArrM606getMatrixsQKQjiQ, fArrM442constructorimpl$default)) {
                fArrM442constructorimpl$default[0] = Float.NaN;
                return null;
            }
        } else if (Float.isNaN(fArrM442constructorimpl$default[0])) {
            return null;
        }
        return fArrM442constructorimpl$default;
    }

    /* JADX INFO: renamed from: getMatrix-sQKQjiQ, reason: not valid java name */
    public final float[] m606getMatrixsQKQjiQ() {
        boolean z = this.isMatrixDirty;
        float[] fArr = this.matrixCache;
        if (z) {
            GraphicsLayer graphicsLayer = this.graphicsLayer;
            long jM391getCenteruvyYCjk = graphicsLayer.pivotOffset;
            GraphicsLayerImpl graphicsLayerImpl = graphicsLayer.impl;
            if ((9223372034707292159L & jM391getCenteruvyYCjk) == 9205357640488583168L) {
                jM391getCenteruvyYCjk = SizeKt.m391getCenteruvyYCjk(IntSizeKt.m724toSizeozmzZPI(this.size));
            }
            float fIntBitsToFloat = Float.intBitsToFloat((int) (jM391getCenteruvyYCjk >> 32));
            float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jM391getCenteruvyYCjk & 4294967295L));
            float translationX = graphicsLayerImpl.getTranslationX();
            float translationY = graphicsLayerImpl.getTranslationY();
            float rotationX = graphicsLayerImpl.getRotationX();
            float rotationY = graphicsLayerImpl.getRotationY();
            float rotationZ = graphicsLayerImpl.getRotationZ();
            float scaleX = graphicsLayerImpl.getScaleX();
            float scaleY = graphicsLayerImpl.getScaleY();
            double d = ((double) rotationX) * 0.017453292519943295d;
            float fSin = (float) Math.sin(d);
            float fCos = (float) Math.cos(d);
            float f = -fSin;
            float f2 = (translationY * fCos) - (0.0f * fSin);
            float f3 = (0.0f * fCos) + (translationY * fSin);
            double d2 = ((double) rotationY) * 0.017453292519943295d;
            float fSin2 = (float) Math.sin(d2);
            float fCos2 = (float) Math.cos(d2);
            float f4 = -fSin2;
            float f5 = fSin * fSin2;
            float f6 = fSin * fCos2;
            float f7 = fCos * fSin2;
            float f8 = fCos * fCos2;
            float f9 = (f3 * fSin2) + (translationX * fCos2);
            float f10 = (f3 * fCos2) + ((-translationX) * fSin2);
            double d3 = ((double) rotationZ) * 0.017453292519943295d;
            float fSin3 = (float) Math.sin(d3);
            float fCos3 = (float) Math.cos(d3);
            float f11 = -fSin3;
            float f12 = (fCos3 * f5) + (f11 * fCos2);
            float f13 = (f5 * fSin3) + (fCos2 * fCos3);
            float f14 = fSin3 * fCos;
            float f15 = f13 * scaleX;
            float f16 = f14 * scaleX;
            float f17 = ((fSin3 * f6) + (fCos3 * f4)) * scaleX;
            float f18 = f12 * scaleY;
            float f19 = fCos * fCos3 * scaleY;
            float f20 = ((fCos3 * f6) + (f11 * f4)) * scaleY;
            float f21 = f7 * 1.0f;
            float f22 = f * 1.0f;
            float f23 = f8 * 1.0f;
            if (fArr.length >= 16) {
                fArr[0] = f15;
                fArr[1] = f16;
                fArr[2] = f17;
                fArr[3] = 0.0f;
                fArr[4] = f18;
                fArr[5] = f19;
                fArr[6] = f20;
                fArr[7] = 0.0f;
                fArr[8] = f21;
                fArr[9] = f22;
                fArr[10] = f23;
                fArr[11] = 0.0f;
                float f24 = -fIntBitsToFloat;
                fArr[12] = ((f15 * f24) - (fIntBitsToFloat2 * f18)) + f9 + fIntBitsToFloat;
                fArr[13] = ((f16 * f24) - (fIntBitsToFloat2 * f19)) + f2 + fIntBitsToFloat2;
                fArr[14] = ((f24 * f17) - (fIntBitsToFloat2 * f20)) + f10;
                fArr[15] = 1.0f;
            }
            this.isMatrixDirty = false;
            this.isIdentity = BrushKt.m418isIdentity58bKbWc(fArr);
        }
        return fArr;
    }

    @Override // androidx.compose.ui.node.OwnedLayer
    public final void invalidate() {
        if (this.isDirty || this.isDestroyed) {
            return;
        }
        AndroidComposeView androidComposeView = this.ownerView;
        androidComposeView.invalidate();
        if (true != this.isDirty) {
            this.isDirty = true;
            androidComposeView.notifyLayerIsDirty$ui(this, true);
        }
    }

    /* JADX INFO: renamed from: mapOffset-8S9VItk, reason: not valid java name */
    public final long m607mapOffset8S9VItk(long j, boolean z) {
        float[] fArrM606getMatrixsQKQjiQ;
        if (z) {
            fArrM606getMatrixsQKQjiQ = m605getInverseMatrix3i98HWw();
            if (fArrM606getMatrixsQKQjiQ == null) {
                return 9187343241974906880L;
            }
        } else {
            fArrM606getMatrixsQKQjiQ = m606getMatrixsQKQjiQ();
        }
        return this.isIdentity ? j : Matrix.m443mapMKHz9U(j, fArrM606getMatrixsQKQjiQ);
    }

    /* JADX INFO: renamed from: move--gyyYBs, reason: not valid java name */
    public final void m608movegyyYBs(long j) {
        boolean zIsArrEnabled$ui = AndroidComposeView.isArrEnabled$ui();
        AndroidComposeView androidComposeView = this.ownerView;
        if (zIsArrEnabled$ui) {
            androidComposeView.voteFrameRate(-4.0f);
        }
        GraphicsLayer graphicsLayer = this.graphicsLayer;
        if (!IntOffset.m712equalsimpl0(graphicsLayer.topLeft, j)) {
            graphicsLayer.topLeft = j;
            graphicsLayer.impl.mo487setPositionH0pRuoY((int) (j >> 32), (int) (j & 4294967295L), graphicsLayer.size);
        }
        if (Build.VERSION.SDK_INT < 26) {
            androidComposeView.invalidate();
            return;
        }
        ViewParent parent = androidComposeView.getParent();
        if (parent != null) {
            parent.onDescendantInvalidated(androidComposeView, androidComposeView);
        }
    }

    /* JADX INFO: renamed from: resize-ozmzZPI, reason: not valid java name */
    public final void m609resizeozmzZPI(long j) {
        if (IntSize.m720equalsimpl0(j, this.size)) {
            return;
        }
        boolean zIsArrEnabled$ui = AndroidComposeView.isArrEnabled$ui();
        AndroidComposeView androidComposeView = this.ownerView;
        if (zIsArrEnabled$ui) {
            androidComposeView.voteFrameRate(-4.0f);
        }
        this.size = j;
        if (this.isDirty || this.isDestroyed) {
            return;
        }
        androidComposeView.invalidate();
        if (true != this.isDirty) {
            this.isDirty = true;
            androidComposeView.notifyLayerIsDirty$ui(this, true);
        }
    }

    public final void updateDisplayList() {
        AndroidComposeView.isArrEnabled$ui();
        if (this.isDirty) {
            if (!TransformOrigin.m451equalsimpl0(this.transformOrigin, TransformOrigin.Center) && !IntSize.m720equalsimpl0(this.graphicsLayer.size, this.size)) {
                GraphicsLayer graphicsLayer = this.graphicsLayer;
                float fM452getPivotFractionXimpl = TransformOrigin.m452getPivotFractionXimpl(this.transformOrigin) * ((int) (this.size >> 32));
                long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(TransformOrigin.m453getPivotFractionYimpl(this.transformOrigin) * ((int) (this.size & 4294967295L)))) & 4294967295L) | (Float.floatToRawIntBits(fM452getPivotFractionXimpl) << 32);
                if (!Offset.m369equalsimpl0(graphicsLayer.pivotOffset, jFloatToRawIntBits)) {
                    graphicsLayer.pivotOffset = jFloatToRawIntBits;
                    graphicsLayer.impl.mo486setPivotOffsetk4lQ0M(jFloatToRawIntBits);
                }
            }
            this.graphicsLayer.m476recordmLhObY(this.density, this.layoutDirection, this.size, this.recordLambda);
            if (this.isDirty) {
                this.isDirty = false;
                this.ownerView.notifyLayerIsDirty$ui(this, false);
            }
        }
    }
}
