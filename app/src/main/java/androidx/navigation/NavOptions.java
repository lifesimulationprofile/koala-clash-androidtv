package androidx.navigation;

import android.view.View;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class NavOptions {
    public final int enterAnim;
    public final int exitAnim;
    public final int popUpToId;
    public final boolean popUpToInclusive;
    public final boolean popUpToSaveState;
    public final boolean restoreState;
    public final boolean singleTop;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Builder implements OffsetMapping {
        public int enterAnim;
        public int exitAnim;

        public /* synthetic */ Builder(int i, int i2) {
            this.enterAnim = i;
            this.exitAnim = i2;
        }

        @Override // androidx.compose.ui.text.input.OffsetMapping
        public int originalToTransformed(int i) {
            if (i >= 0 && i <= this.enterAnim) {
                BasicTextKt.validateOriginalToTransformed(i, this.exitAnim, i);
            }
            return i;
        }

        public void setFrom(RecyclerView.ViewHolder viewHolder) {
            View view = viewHolder.itemView;
            this.enterAnim = view.getLeft();
            this.exitAnim = view.getTop();
            view.getRight();
            view.getBottom();
        }

        @Override // androidx.compose.ui.text.input.OffsetMapping
        public int transformedToOriginal(int i) {
            if (i >= 0 && i <= this.exitAnim) {
                BasicTextKt.validateTransformedToOriginal(i, this.enterAnim, i);
            }
            return i;
        }
    }

    public NavOptions(boolean z, boolean z2, int i, boolean z3, boolean z4, int i2, int i3) {
        this.singleTop = z;
        this.restoreState = z2;
        this.popUpToId = i;
        this.popUpToInclusive = z3;
        this.popUpToSaveState = z4;
        this.enterAnim = i2;
        this.exitAnim = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NavOptions)) {
            return false;
        }
        NavOptions navOptions = (NavOptions) obj;
        return this.singleTop == navOptions.singleTop && this.restoreState == navOptions.restoreState && this.popUpToId == navOptions.popUpToId && this.popUpToInclusive == navOptions.popUpToInclusive && this.popUpToSaveState == navOptions.popUpToSaveState && this.enterAnim == navOptions.enterAnim && this.exitAnim == navOptions.exitAnim;
    }

    public final int hashCode() {
        return ((((((((((((((((this.singleTop ? 1 : 0) * 31) + (this.restoreState ? 1 : 0)) * 31) + this.popUpToId) * 923521) + (this.popUpToInclusive ? 1 : 0)) * 31) + (this.popUpToSaveState ? 1 : 0)) * 31) + this.enterAnim) * 31) + this.exitAnim) * 31) - 1) * 31) - 1;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("NavOptions(");
        if (this.singleTop) {
            sb.append("launchSingleTop ");
        }
        if (this.restoreState) {
            sb.append("restoreState ");
        }
        int i = this.exitAnim;
        int i2 = this.enterAnim;
        if (i2 != -1 || i != -1) {
            sb.append("anim(enterAnim=0x");
            sb.append(Integer.toHexString(i2));
            sb.append(" exitAnim=0x");
            sb.append(Integer.toHexString(i));
            sb.append(" popEnterAnim=0x");
            sb.append(Integer.toHexString(-1));
            sb.append(" popExitAnim=0x");
            sb.append(Integer.toHexString(-1));
            sb.append(")");
        }
        return sb.toString();
    }
}
