package androidx.compose.material3;

import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.MenuTokens;
import androidx.compose.material3.tokens.SegmentedMenuTokens;
import androidx.compose.runtime.ParcelableSnapshotMutableState;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class MenuDefaults {
    public static final float TonalElevation = ElevationTokens.Level0;
    public static final float ShadowElevation = MenuTokens.ContainerElevation;

    static {
        int i = SegmentedMenuTokens.$r8$clinit;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = PrecisionPointer.shouldUsePrecisionPointerComponentSizing;
        ((Boolean) parcelableSnapshotMutableState.getValue()).getClass();
        float f = 12;
        OffsetKt.m121PaddingValuesYgX7TsA(f, 2);
        OffsetKt.m124PaddingValuesa9UjIt4$default(f, 0.0f, 4, 0.0f, 10);
        if (((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue()) {
            OffsetKt.m124PaddingValuesa9UjIt4$default(0, 0.0f, 6, 0.0f, 10);
        } else {
            float f2 = 0;
            new PaddingValuesImpl(f2, f2, f2, f2);
        }
        float f3 = MenuKt.DropdownMenuItemHorizontalPadding;
        float f4 = 0;
        OffsetKt.m121PaddingValuesYgX7TsA(f3, f4);
        if (((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue()) {
            OffsetKt.m123PaddingValuesa9UjIt4(16, f, 10, f);
        } else {
            OffsetKt.m121PaddingValuesYgX7TsA(f3, f);
        }
        OffsetKt.m121PaddingValuesYgX7TsA(f4, MenuKt.DropdownMenuGroupVerticalPadding);
    }
}
