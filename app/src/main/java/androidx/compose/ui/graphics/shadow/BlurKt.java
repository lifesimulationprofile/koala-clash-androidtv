package androidx.compose.ui.graphics.shadow;

import android.graphics.BlurMaskFilter;
import androidx.compose.ui.graphics.AndroidPaint;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class BlurKt {
    /* JADX INFO: renamed from: configureShadow-FoewPVk$default, reason: not valid java name */
    public static AndroidPaint m497configureShadowFoewPVk$default(AndroidPaint androidPaint, int i, BlurMaskFilter blurMaskFilter, int i2) {
        long j = Color.Black;
        if ((i2 & 2) != 0) {
            i = 3;
        }
        if ((i2 & 4) != 0) {
            blurMaskFilter = null;
        }
        int i3 = (i2 & 8) != 0 ? 0 : 1;
        androidPaint.m404setColor8_81llA(j);
        androidPaint.m403setBlendModes9anfk8(i);
        androidPaint.m408setStylek9PVt8s(i3);
        BrushKt.getNativePaint(androidPaint).setMaskFilter(blurMaskFilter);
        return androidPaint;
    }
}
