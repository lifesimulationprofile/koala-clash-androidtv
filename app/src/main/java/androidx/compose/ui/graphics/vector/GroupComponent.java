package androidx.compose.ui.graphics.vector;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.core.view.MenuHostHelper;
import androidx.navigation.Navigator;
import coil.request.Parameters;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class GroupComponent extends VNode {
    public AndroidPath clipPath;
    public List clipPathData;
    public float[] groupMatrix;
    public Function1 invalidateListener;
    public boolean isClipPathDirty;
    public boolean isMatrixDirty;
    public String name;
    public float pivotX;
    public float pivotY;
    public float rotation;
    public float scaleX;
    public float scaleY;
    public float translationX;
    public float translationY;
    public final Navigator.AnonymousClass1 wrappedListener;
    public final ArrayList children = new ArrayList();
    public boolean isTintable = true;
    public long tintColor = Color.Unspecified;

    public GroupComponent() {
        int i = VectorKt.$r8$clinit;
        this.clipPathData = EmptyList.INSTANCE;
        this.isClipPathDirty = true;
        this.wrappedListener = new Navigator.AnonymousClass1(12, this);
        this.name = "";
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.isMatrixDirty = true;
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final void draw(DrawScope drawScope) {
        if (this.isMatrixDirty) {
            float[] fArrM442constructorimpl$default = this.groupMatrix;
            if (fArrM442constructorimpl$default == null) {
                fArrM442constructorimpl$default = Matrix.m442constructorimpl$default();
                this.groupMatrix = fArrM442constructorimpl$default;
            } else {
                Matrix.m445resetimpl(fArrM442constructorimpl$default);
            }
            Matrix.m447translateimpl(fArrM442constructorimpl$default, this.translationX + this.pivotX, this.translationY + this.pivotY);
            float f = this.rotation;
            if (fArrM442constructorimpl$default.length >= 16) {
                double d = ((double) f) * 0.017453292519943295d;
                float fSin = (float) Math.sin(d);
                float fCos = (float) Math.cos(d);
                float f2 = fArrM442constructorimpl$default[0];
                float f3 = fArrM442constructorimpl$default[4];
                float f4 = (fSin * f3) + (fCos * f2);
                float f5 = -fSin;
                float f6 = (f3 * fCos) + (f2 * f5);
                float f7 = fArrM442constructorimpl$default[1];
                float f8 = fArrM442constructorimpl$default[5];
                float f9 = (fSin * f8) + (fCos * f7);
                float f10 = (f8 * fCos) + (f7 * f5);
                float f11 = fArrM442constructorimpl$default[2];
                float f12 = fArrM442constructorimpl$default[6];
                float f13 = (fSin * f12) + (fCos * f11);
                float f14 = (f12 * fCos) + (f11 * f5);
                float f15 = fArrM442constructorimpl$default[3];
                float f16 = fArrM442constructorimpl$default[7];
                float f17 = (fSin * f16) + (fCos * f15);
                fArrM442constructorimpl$default[0] = f4;
                fArrM442constructorimpl$default[1] = f9;
                fArrM442constructorimpl$default[2] = f13;
                fArrM442constructorimpl$default[3] = f17;
                fArrM442constructorimpl$default[4] = f6;
                fArrM442constructorimpl$default[5] = f10;
                fArrM442constructorimpl$default[6] = f14;
                fArrM442constructorimpl$default[7] = (fCos * f16) + (f5 * f15);
            }
            float f18 = this.scaleX;
            float f19 = this.scaleY;
            if (fArrM442constructorimpl$default.length >= 16) {
                fArrM442constructorimpl$default[0] = fArrM442constructorimpl$default[0] * f18;
                fArrM442constructorimpl$default[1] = fArrM442constructorimpl$default[1] * f18;
                fArrM442constructorimpl$default[2] = fArrM442constructorimpl$default[2] * f18;
                fArrM442constructorimpl$default[3] = fArrM442constructorimpl$default[3] * f18;
                fArrM442constructorimpl$default[4] = fArrM442constructorimpl$default[4] * f19;
                fArrM442constructorimpl$default[5] = fArrM442constructorimpl$default[5] * f19;
                fArrM442constructorimpl$default[6] = fArrM442constructorimpl$default[6] * f19;
                fArrM442constructorimpl$default[7] = fArrM442constructorimpl$default[7] * f19;
                fArrM442constructorimpl$default[8] = fArrM442constructorimpl$default[8] * 1.0f;
                fArrM442constructorimpl$default[9] = fArrM442constructorimpl$default[9] * 1.0f;
                fArrM442constructorimpl$default[10] = fArrM442constructorimpl$default[10] * 1.0f;
                fArrM442constructorimpl$default[11] = fArrM442constructorimpl$default[11] * 1.0f;
            }
            Matrix.m447translateimpl(fArrM442constructorimpl$default, -this.pivotX, -this.pivotY);
            this.isMatrixDirty = false;
        }
        if (this.isClipPathDirty) {
            if (!this.clipPathData.isEmpty()) {
                AndroidPath androidPathPath = this.clipPath;
                if (androidPathPath == null) {
                    androidPathPath = AndroidPath_androidKt.Path();
                    this.clipPath = androidPathPath;
                }
                PathParserKt.toPath(this.clipPathData, androidPathPath);
            }
            this.isClipPathDirty = false;
        }
        MenuHostHelper drawContext = drawScope.getDrawContext();
        long jM756getSizeNHjbRc = drawContext.m756getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            MenuHostHelper menuHostHelper = (MenuHostHelper) ((Parameters.Builder) drawContext.mOnInvalidateMenuCallback).entries;
            float[] fArr = this.groupMatrix;
            if (fArr != null) {
                menuHostHelper.getCanvas().mo395concat58bKbWc(fArr);
            }
            AndroidPath androidPath = this.clipPath;
            if (!this.clipPathData.isEmpty() && androidPath != null) {
                menuHostHelper.getCanvas().mo392clipPathmtrdDE(androidPath);
            }
            ArrayList arrayList = this.children;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((VNode) arrayList.get(i)).draw(drawScope);
            }
        } finally {
            ImageAnalysis$$ExternalSyntheticLambda1.m(drawContext, jM756getSizeNHjbRc);
        }
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final Function1 getInvalidateListener$ui() {
        return this.invalidateListener;
    }

    public final void insertAt(int i, VNode vNode) {
        ArrayList arrayList = this.children;
        if (i < arrayList.size()) {
            arrayList.set(i, vNode);
        } else {
            arrayList.add(vNode);
        }
        markTintForVNode(vNode);
        vNode.setInvalidateListener$ui(this.wrappedListener);
        invalidate();
    }

    /* JADX INFO: renamed from: markTintForColor-8_81llA, reason: not valid java name */
    public final void m501markTintForColor8_81llA(long j) {
        if (this.isTintable && j != 16) {
            long j2 = this.tintColor;
            if (j2 == 16) {
                this.tintColor = j;
                return;
            }
            int i = VectorKt.$r8$clinit;
            if (Color.m440getRedimpl(j2) == Color.m440getRedimpl(j) && Color.m439getGreenimpl(j2) == Color.m439getGreenimpl(j) && Color.m437getBlueimpl(j2) == Color.m437getBlueimpl(j)) {
                return;
            }
            this.isTintable = false;
            this.tintColor = Color.Unspecified;
        }
    }

    public final void markTintForVNode(VNode vNode) {
        if (!(vNode instanceof PathComponent)) {
            if (vNode instanceof GroupComponent) {
                GroupComponent groupComponent = (GroupComponent) vNode;
                if (groupComponent.isTintable && this.isTintable) {
                    m501markTintForColor8_81llA(groupComponent.tintColor);
                    return;
                } else {
                    this.isTintable = false;
                    this.tintColor = Color.Unspecified;
                    return;
                }
            }
            return;
        }
        PathComponent pathComponent = (PathComponent) vNode;
        Brush brush = pathComponent.fill;
        if (this.isTintable && brush != null) {
            if (brush instanceof SolidColor) {
                m501markTintForColor8_81llA(((SolidColor) brush).value);
            } else {
                this.isTintable = false;
                this.tintColor = Color.Unspecified;
            }
        }
        Brush brush2 = pathComponent.stroke;
        if (this.isTintable && brush2 != null) {
            if (brush2 instanceof SolidColor) {
                m501markTintForColor8_81llA(((SolidColor) brush2).value);
            } else {
                this.isTintable = false;
                this.tintColor = Color.Unspecified;
            }
        }
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final void setInvalidateListener$ui(Navigator.AnonymousClass1 anonymousClass1) {
        this.invalidateListener = anonymousClass1;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("VGroup: ");
        sb.append(this.name);
        ArrayList arrayList = this.children;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            VNode vNode = (VNode) arrayList.get(i);
            sb.append("\t");
            sb.append(vNode.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
