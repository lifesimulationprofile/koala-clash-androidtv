package androidx.compose.ui.graphics;

import android.graphics.ComposeShader;
import android.graphics.Shader;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CompositeShaderBrush extends ShaderBrush {
    public final ShaderBrush dstBrush;
    public final ShaderBrush srcBrush;

    public CompositeShaderBrush(ShaderBrush shaderBrush, ShaderBrush shaderBrush2) {
        this.dstBrush = shaderBrush;
        this.srcBrush = shaderBrush2;
    }

    @Override // androidx.compose.ui.graphics.ShaderBrush
    /* JADX INFO: renamed from: createShader-uvyYCjk */
    public final Shader mo431createShaderuvyYCjk(long j) {
        Shader shaderMo431createShaderuvyYCjk = this.dstBrush.mo431createShaderuvyYCjk(j);
        Shader shaderMo431createShaderuvyYCjk2 = this.srcBrush.mo431createShaderuvyYCjk(j);
        return Build.VERSION.SDK_INT >= 29 ? CanvasZHelper$$ExternalSyntheticApiModelOutline0.m(shaderMo431createShaderuvyYCjk, shaderMo431createShaderuvyYCjk2, BrushKt.m424toAndroidBlendModes9anfk8(5)) : new ComposeShader(shaderMo431createShaderuvyYCjk, shaderMo431createShaderuvyYCjk2, BrushKt.m428toPorterDuffModes9anfk8(5));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompositeShaderBrush)) {
            return false;
        }
        CompositeShaderBrush compositeShaderBrush = (CompositeShaderBrush) obj;
        return this.dstBrush.equals(compositeShaderBrush.dstBrush) && this.srcBrush.equals(compositeShaderBrush.srcBrush);
    }

    public final int hashCode() {
        return ((this.srcBrush.hashCode() + (this.dstBrush.hashCode() * 31)) * 31) + 5;
    }

    public final String toString() {
        return "CompositeShaderBrush(dstBrush=" + this.dstBrush + ", srcBrush=" + this.srcBrush + ", blendMode=" + ((Object) BrushKt.m429toStringimpl(5)) + ')';
    }
}
