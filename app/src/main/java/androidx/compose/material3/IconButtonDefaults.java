package androidx.compose.material3;

import androidx.compose.material3.tokens.SmallIconButtonTokens;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class IconButtonDefaults {
    public static final /* synthetic */ int $r8$clinit = 0;

    static {
        float f = SmallIconButtonTokens.ContainerHeight;
    }

    /* JADX INFO: renamed from: defaultIconButtonColors-4WTKRHQ$material3, reason: not valid java name */
    public static IconButtonColors m247defaultIconButtonColors4WTKRHQ$material3(ColorScheme colorScheme, long j) {
        IconButtonColors iconButtonColors = colorScheme.defaultIconButtonColorsCached;
        if (iconButtonColors != null) {
            return iconButtonColors;
        }
        long j2 = Color.Transparent;
        IconButtonColors iconButtonColors2 = new IconButtonColors(j2, j, j2, BrushKt.Color(Color.m440getRedimpl(j), Color.m439getGreenimpl(j), Color.m437getBlueimpl(j), 0.38f, Color.m438getColorSpaceimpl(j)));
        colorScheme.defaultIconButtonColorsCached = iconButtonColors2;
        return iconButtonColors2;
    }
}
