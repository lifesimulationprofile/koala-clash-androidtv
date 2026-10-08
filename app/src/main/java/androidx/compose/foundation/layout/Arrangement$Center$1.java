package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.LayoutDirection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Arrangement$Center$1 implements Arrangement.Horizontal, Arrangement.Vertical {
    public final /* synthetic */ int $r8$classId;
    public final float spacing;

    public Arrangement$Center$1(int i) {
        this.$r8$classId = i;
        switch (i) {
            case 1:
                this.spacing = 0;
                break;
            case 2:
                this.spacing = 0;
                break;
            case 3:
                this.spacing = 0;
                break;
            default:
                this.spacing = 0;
                break;
        }
    }

    @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
    public final void arrange(MeasureScope measureScope, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
        switch (this.$r8$classId) {
            case 0:
                if (layoutDirection != LayoutDirection.Ltr) {
                    Arrangement.placeCenter$foundation_layout(i, iArr, iArr2, true);
                } else {
                    Arrangement.placeCenter$foundation_layout(i, iArr, iArr2, false);
                }
                break;
            case 1:
                if (layoutDirection != LayoutDirection.Ltr) {
                    Arrangement.placeSpaceAround$foundation_layout(i, iArr, iArr2, true);
                } else {
                    Arrangement.placeSpaceAround$foundation_layout(i, iArr, iArr2, false);
                }
                break;
            case 2:
                if (layoutDirection != LayoutDirection.Ltr) {
                    Arrangement.placeSpaceBetween$foundation_layout(i, iArr, iArr2, true);
                } else {
                    Arrangement.placeSpaceBetween$foundation_layout(i, iArr, iArr2, false);
                }
                break;
            default:
                if (layoutDirection != LayoutDirection.Ltr) {
                    Arrangement.placeSpaceEvenly$foundation_layout(i, iArr, iArr2, true);
                } else {
                    Arrangement.placeSpaceEvenly$foundation_layout(i, iArr, iArr2, false);
                }
                break;
        }
    }

    @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
    /* JADX INFO: renamed from: getSpacing-D9Ej5fM, reason: not valid java name */
    public final float mo112getSpacingD9Ej5fM() {
        switch (this.$r8$classId) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
        }
        return this.spacing;
    }

    public final String toString() {
        switch (this.$r8$classId) {
            case 0:
                return "Arrangement#Center";
            case 1:
                return "Arrangement#SpaceAround";
            case 2:
                return "Arrangement#SpaceBetween";
            default:
                return "Arrangement#SpaceEvenly";
        }
    }

    @Override // androidx.compose.foundation.layout.Arrangement.Vertical
    public final void arrange(int i, MeasureScope measureScope, int[] iArr, int[] iArr2) {
        switch (this.$r8$classId) {
            case 0:
                Arrangement.placeCenter$foundation_layout(i, iArr, iArr2, false);
                break;
            case 1:
                Arrangement.placeSpaceAround$foundation_layout(i, iArr, iArr2, false);
                break;
            case 2:
                Arrangement.placeSpaceBetween$foundation_layout(i, iArr, iArr2, false);
                break;
            default:
                Arrangement.placeSpaceEvenly$foundation_layout(i, iArr, iArr2, false);
                break;
        }
    }
}
