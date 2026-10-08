package androidx.compose.ui.graphics;

import android.graphics.Paint;
import android.graphics.Shader;
import androidx.compose.ui.geometry.Size;
import coil.memory.MemoryCacheService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ShaderBrush extends Brush {
    public long createdSize = 9205357640488583168L;
    public MemoryCacheService internalTransformShader;

    @Override // androidx.compose.ui.graphics.Brush
    /* JADX INFO: renamed from: applyTo-Pq9zytI */
    public final void mo411applyToPq9zytI(float f, long j, AndroidPaint androidPaint) {
        MemoryCacheService memoryCacheService = this.internalTransformShader;
        if (memoryCacheService == null || !Size.m384equalsimpl0(this.createdSize, j)) {
            if (Size.m388isEmptyimpl(j)) {
                this.internalTransformShader = null;
                this.createdSize = 9205357640488583168L;
                memoryCacheService = null;
            } else {
                memoryCacheService = this.internalTransformShader;
                if (memoryCacheService == null) {
                    memoryCacheService = new MemoryCacheService(4, false);
                    this.internalTransformShader = memoryCacheService;
                }
                memoryCacheService.imageLoader = mo431createShaderuvyYCjk(j);
                this.internalTransformShader = memoryCacheService;
                this.createdSize = j;
            }
        }
        Paint paint = androidPaint.internalPaint;
        long jColor = BrushKt.Color(paint.getColor());
        long j2 = Color.Black;
        if (!Color.m435equalsimpl0(jColor, j2)) {
            androidPaint.m404setColor8_81llA(j2);
        }
        if (!Intrinsics.areEqual(androidPaint.internalShader, memoryCacheService != null ? (Shader) memoryCacheService.imageLoader : null)) {
            androidPaint.setShader(memoryCacheService != null ? (Shader) memoryCacheService.imageLoader : null);
        }
        if (paint.getAlpha() / 255.0f == f) {
            return;
        }
        androidPaint.setAlpha(f);
    }

    /* JADX INFO: renamed from: createShader-uvyYCjk */
    public abstract Shader mo431createShaderuvyYCjk(long j);
}
