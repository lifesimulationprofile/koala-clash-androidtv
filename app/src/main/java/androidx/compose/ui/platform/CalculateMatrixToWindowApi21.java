package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Matrix;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CalculateMatrixToWindowApi21 implements CalculateMatrixToWindow {
    public final int[] tmpLocation;
    public final float[] tmpMatrix;

    public CalculateMatrixToWindowApi21(ArrayList arrayList, ArrayList arrayList2) {
        int size = arrayList.size();
        this.tmpLocation = new int[size];
        this.tmpMatrix = new float[size];
        for (int i = 0; i < size; i++) {
            this.tmpLocation[i] = ((Integer) arrayList.get(i)).intValue();
            this.tmpMatrix[i] = ((Float) arrayList2.get(i)).floatValue();
        }
    }

    @Override // androidx.compose.ui.platform.CalculateMatrixToWindow
    /* JADX INFO: renamed from: calculateMatrixToWindow-EL8BTi8 */
    public void mo603calculateMatrixToWindowEL8BTi8(View view, float[] fArr) {
        Matrix.m445resetimpl(fArr);
        m604transformMatrixToWindowEL8BTi8(view, fArr);
    }

    /* JADX INFO: renamed from: transformMatrixToWindow-EL8BTi8, reason: not valid java name */
    public void m604transformMatrixToWindowEL8BTi8(View view, float[] fArr) {
        Object parent = view.getParent();
        boolean z = parent instanceof View;
        float[] fArr2 = this.tmpMatrix;
        if (z) {
            m604transformMatrixToWindowEL8BTi8((View) parent, fArr);
            float f = -view.getScrollX();
            float f2 = -view.getScrollY();
            Matrix.m445resetimpl(fArr2);
            Matrix.m447translateimpl(fArr2, f, f2);
            InvertMatrixKt.m613preTransformJiSxe2E(fArr, fArr2);
            float left = view.getLeft();
            float top = view.getTop();
            Matrix.m445resetimpl(fArr2);
            Matrix.m447translateimpl(fArr2, left, top);
            InvertMatrixKt.m613preTransformJiSxe2E(fArr, fArr2);
        } else {
            int[] iArr = this.tmpLocation;
            view.getLocationInWindow(iArr);
            float f3 = -view.getScrollX();
            float f4 = -view.getScrollY();
            Matrix.m445resetimpl(fArr2);
            Matrix.m447translateimpl(fArr2, f3, f4);
            InvertMatrixKt.m613preTransformJiSxe2E(fArr, fArr2);
            float f5 = iArr[0];
            float f6 = iArr[1];
            Matrix.m445resetimpl(fArr2);
            Matrix.m447translateimpl(fArr2, f5, f6);
            InvertMatrixKt.m613preTransformJiSxe2E(fArr, fArr2);
        }
        android.graphics.Matrix matrix = view.getMatrix();
        if (matrix.isIdentity()) {
            return;
        }
        BrushKt.m423setFromtUYjHk(matrix, fArr2);
        InvertMatrixKt.m613preTransformJiSxe2E(fArr, fArr2);
    }

    public CalculateMatrixToWindowApi21(int i, int i2) {
        this.tmpLocation = new int[]{i, i2};
        this.tmpMatrix = new float[]{0.0f, 1.0f};
    }

    public CalculateMatrixToWindowApi21(int i, int i2, int i3) {
        this.tmpLocation = new int[]{i, i2, i3};
        this.tmpMatrix = new float[]{0.0f, 0.5f, 1.0f};
    }

    public CalculateMatrixToWindowApi21(float[] fArr) {
        this.tmpMatrix = fArr;
        this.tmpLocation = new int[2];
    }
}
