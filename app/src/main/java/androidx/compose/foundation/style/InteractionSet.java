package androidx.compose.foundation.style;

import android.view.accessibility.AccessibilityNodeInfo;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.foundation.interaction.Interaction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class InteractionSet {
    public Object setOrValue;

    public /* synthetic */ InteractionSet(Object obj) {
        this.setOrValue = obj;
    }

    public static InteractionSet obtain(boolean z, int i, int i2, int i3, int i4) {
        return new InteractionSet(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, false, z));
    }

    public void add(Interaction interaction) {
        Object obj = this.setOrValue;
        if (obj == null) {
            this.setOrValue = interaction;
            return;
        }
        if (obj instanceof MutableScatterSet) {
            ((MutableScatterSet) obj).add(interaction);
            return;
        }
        if (obj.equals(interaction)) {
            return;
        }
        MutableScatterSet mutableScatterSet = ScatterSetKt.EmptyScatterSet;
        MutableScatterSet mutableScatterSet2 = new MutableScatterSet(2);
        mutableScatterSet2.plusAssign((Interaction) obj);
        mutableScatterSet2.plusAssign(interaction);
        this.setOrValue = mutableScatterSet2;
    }

    public void remove(Interaction interaction) {
        Object obj = this.setOrValue;
        if (Intrinsics.areEqual(obj, interaction)) {
            this.setOrValue = null;
            return;
        }
        if (obj instanceof MutableScatterSet) {
            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
            mutableScatterSet.remove(interaction);
            int i = mutableScatterSet._size;
            if (i == 0) {
                this.setOrValue = null;
            } else {
                if (i != 1) {
                    return;
                }
                this.setOrValue = mutableScatterSet.first();
            }
        }
    }
}
