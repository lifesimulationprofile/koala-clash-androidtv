package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class TextDrawStyleKt {
    /* JADX INFO: renamed from: modulate-DxMtmZc, reason: not valid java name */
    public static final long m675modulateDxMtmZc(float f, long j) {
        return (Float.isNaN(f) || f >= 1.0f) ? j : BrushKt.Color(Color.m440getRedimpl(j), Color.m439getGreenimpl(j), Color.m437getBlueimpl(j), Color.m436getAlphaimpl(j) * f, Color.m438getColorSpaceimpl(j));
    }
}
