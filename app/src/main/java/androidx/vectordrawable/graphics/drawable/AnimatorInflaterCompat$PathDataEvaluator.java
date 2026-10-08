package androidx.vectordrawable.graphics.drawable;

import android.animation.TypeEvaluator;
import androidx.core.graphics.PathParser;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AnimatorInflaterCompat$PathDataEvaluator implements TypeEvaluator {
    public PathParser.PathDataNode[] mNodeArray;

    @Override // android.animation.TypeEvaluator
    public final Object evaluate(float f, Object obj, Object obj2) {
        PathParser.PathDataNode[] pathDataNodeArr = (PathParser.PathDataNode[]) obj;
        PathParser.PathDataNode[] pathDataNodeArr2 = (PathParser.PathDataNode[]) obj2;
        if (!PathParser.canMorph(pathDataNodeArr, pathDataNodeArr2)) {
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
        if (!PathParser.canMorph(this.mNodeArray, pathDataNodeArr)) {
            this.mNodeArray = PathParser.deepCopyNodes(pathDataNodeArr);
        }
        for (int i = 0; i < pathDataNodeArr.length; i++) {
            PathParser.PathDataNode pathDataNode = this.mNodeArray[i];
            PathParser.PathDataNode pathDataNode2 = pathDataNodeArr[i];
            PathParser.PathDataNode pathDataNode3 = pathDataNodeArr2[i];
            pathDataNode.getClass();
            pathDataNode.mType = pathDataNode2.mType;
            int i2 = 0;
            while (true) {
                float[] fArr = pathDataNode2.mParams;
                if (i2 < fArr.length) {
                    pathDataNode.mParams[i2] = (pathDataNode3.mParams[i2] * f) + ((1.0f - f) * fArr[i2]);
                    i2++;
                }
            }
        }
        return this.mNodeArray;
    }
}
