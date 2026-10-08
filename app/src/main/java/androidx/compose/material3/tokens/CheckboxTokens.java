package androidx.compose.material3.tokens;

import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class CheckboxTokens {
    public static final int SelectedContainerColor;
    public static final int SelectedDisabledContainerColor;
    public static final float SelectedDisabledContainerOpacity;
    public static final int SelectedDisabledIconColor;
    public static final int SelectedIconColor;
    public static final float StateLayerSize;
    public static final float UnselectedDisabledContainerOpacity;
    public static final int UnselectedDisabledOutlineColor;
    public static final int UnselectedOutlineColor;

    static {
        RoundedCornerShape roundedCornerShape = RoundedCornerShapeKt.CircleShape;
        SelectedContainerColor = 26;
        SelectedDisabledContainerColor = 18;
        SelectedDisabledContainerOpacity = 0.38f;
        SelectedDisabledIconColor = 35;
        SelectedIconColor = 10;
        StateLayerSize = (float) 40.0d;
        UnselectedDisabledContainerOpacity = 0.38f;
        UnselectedDisabledOutlineColor = 18;
        UnselectedOutlineColor = 19;
    }
}
