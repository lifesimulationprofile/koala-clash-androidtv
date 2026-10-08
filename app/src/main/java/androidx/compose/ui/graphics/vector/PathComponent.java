package androidx.compose.ui.graphics.vector;

import android.graphics.Path;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPathMeasure;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import java.util.List;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class PathComponent extends VNode {
    public AndroidPath _tmpPath;
    public Brush fill;
    public float fillAlpha = 1.0f;
    public boolean isPathDirty;
    public boolean isStrokeDirty;
    public boolean isTrimPathDirty;
    public final AndroidPath path;
    public List pathData;
    public final Object pathMeasure$delegate;
    public AndroidPath renderPath;
    public Brush stroke;
    public float strokeAlpha;
    public int strokeLineCap;
    public int strokeLineJoin;
    public float strokeLineMiter;
    public float strokeLineWidth;
    public Stroke strokeStyle;
    public float trimPathEnd;
    public float trimPathOffset;
    public float trimPathStart;

    public PathComponent() {
        int i = VectorKt.$r8$clinit;
        this.pathData = EmptyList.INSTANCE;
        this.strokeAlpha = 1.0f;
        this.strokeLineCap = 0;
        this.strokeLineJoin = 0;
        this.strokeLineMiter = 4.0f;
        this.trimPathEnd = 1.0f;
        this.isPathDirty = true;
        this.isStrokeDirty = true;
        AndroidPath androidPathPath = AndroidPath_androidKt.Path();
        this.path = androidPathPath;
        this.renderPath = androidPathPath;
        this.pathMeasure$delegate = LazyKt__LazyJVMKt.lazy(3, PathComponent$pathMeasure$2.INSTANCE);
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final void draw(DrawScope drawScope) {
        Stroke stroke;
        if (this.isPathDirty) {
            PathParserKt.toPath(this.pathData, this.path);
            updateRenderPath();
        } else if (this.isTrimPathDirty) {
            updateRenderPath();
        }
        this.isPathDirty = false;
        this.isTrimPathDirty = false;
        Brush brush = this.fill;
        if (brush != null) {
            Modifier.CC.m312drawPathGBMwjPU$default(drawScope, this.renderPath, brush, this.fillAlpha, null, null, 0, 56);
        }
        Brush brush2 = this.stroke;
        if (brush2 != null) {
            Stroke stroke2 = this.strokeStyle;
            if (this.isStrokeDirty || stroke2 == null) {
                Stroke stroke3 = new Stroke(this.strokeLineWidth, this.strokeLineMiter, this.strokeLineCap, this.strokeLineJoin, 16);
                this.strokeStyle = stroke3;
                this.isStrokeDirty = false;
                stroke = stroke3;
            } else {
                stroke = stroke2;
            }
            Modifier.CC.m312drawPathGBMwjPU$default(drawScope, this.renderPath, brush2, this.strokeAlpha, stroke, null, 0, 48);
        }
    }

    public final String toString() {
        return this.path.toString();
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [java.lang.Object, kotlin.Lazy] */
    public final void updateRenderPath() {
        float f = this.trimPathStart;
        AndroidPath androidPath = this.path;
        if (f == 0.0f && this.trimPathEnd == 1.0f) {
            this.renderPath = androidPath;
            return;
        }
        if (Intrinsics.areEqual(this.renderPath, androidPath)) {
            this.renderPath = AndroidPath_androidKt.Path();
        } else {
            Path.FillType fillType = this.renderPath.internalPath.getFillType();
            Path.FillType fillType2 = Path.FillType.EVEN_ODD;
            boolean z = fillType == fillType2;
            this.renderPath.internalPath.rewind();
            Path path = this.renderPath.internalPath;
            if (!z) {
                fillType2 = Path.FillType.WINDING;
            }
            path.setFillType(fillType2);
        }
        ?? r0 = this.pathMeasure$delegate;
        ((AndroidPathMeasure) r0.getValue()).internalPathMeasure.setPath(androidPath != null ? androidPath.internalPath : null, false);
        float length = ((AndroidPathMeasure) r0.getValue()).internalPathMeasure.getLength();
        float f2 = this.trimPathStart;
        float f3 = this.trimPathOffset;
        float f4 = ((f2 + f3) % 1.0f) * length;
        float f5 = ((this.trimPathEnd + f3) % 1.0f) * length;
        if (f4 <= f5) {
            ((AndroidPathMeasure) r0.getValue()).getSegment(f4, f5, this.renderPath);
            return;
        }
        AndroidPath androidPathPath = this._tmpPath;
        if (androidPathPath == null) {
            androidPathPath = AndroidPath_androidKt.Path();
            this._tmpPath = androidPathPath;
        }
        androidPathPath.reset();
        ((AndroidPathMeasure) r0.getValue()).getSegment(f4, length, androidPathPath);
        Modifier.CC.m307addPathUv8p0NA$default(this.renderPath, androidPathPath);
        androidPathPath.reset();
        ((AndroidPathMeasure) r0.getValue()).getSegment(0.0f, f5, androidPathPath);
        Modifier.CC.m307addPathUv8p0NA$default(this.renderPath, androidPathPath);
    }
}
