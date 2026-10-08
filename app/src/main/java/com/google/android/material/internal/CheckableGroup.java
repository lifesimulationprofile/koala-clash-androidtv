package com.google.android.material.internal;

import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.chip.ChipGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import okhttp3.ConnectionPool;
import okhttp3.Headers;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CheckableGroup {
    public final HashMap checkables = new HashMap();
    public final HashSet checkedIds = new HashSet();
    public ConnectionPool onCheckedStateChangeListener;
    public boolean selectionRequired;
    public boolean singleSelection;

    public final boolean checkInternal(MaterialCheckable materialCheckable) {
        int id = materialCheckable.getId();
        Integer numValueOf = Integer.valueOf(id);
        HashSet hashSet = this.checkedIds;
        if (hashSet.contains(numValueOf)) {
            return false;
        }
        MaterialCheckable materialCheckable2 = (MaterialCheckable) this.checkables.get(Integer.valueOf(getSingleCheckedId()));
        if (materialCheckable2 != null) {
            uncheckInternal(materialCheckable2, false);
        }
        boolean zAdd = hashSet.add(Integer.valueOf(id));
        if (!materialCheckable.isChecked()) {
            materialCheckable.setChecked(true);
        }
        return zAdd;
    }

    public final ArrayList getCheckedIdsSortedByChildOrder(ViewGroup viewGroup) {
        HashSet hashSet = new HashSet(this.checkedIds);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof MaterialCheckable) && hashSet.contains(Integer.valueOf(childAt.getId()))) {
                arrayList.add(Integer.valueOf(childAt.getId()));
            }
        }
        return arrayList;
    }

    public final int getSingleCheckedId() {
        if (!this.singleSelection) {
            return -1;
        }
        HashSet hashSet = this.checkedIds;
        if (hashSet.isEmpty()) {
            return -1;
        }
        return ((Integer) hashSet.iterator().next()).intValue();
    }

    public final void onCheckedStateChanged() {
        ConnectionPool connectionPool = this.onCheckedStateChangeListener;
        if (connectionPool != null) {
            new HashSet(this.checkedIds);
            ChipGroup chipGroup = (ChipGroup) connectionPool.delegate;
            ChipGroup.OnCheckedStateChangeListener onCheckedStateChangeListener = chipGroup.onCheckedStateChangeListener;
            if (onCheckedStateChangeListener != null) {
                chipGroup.checkableGroup.getCheckedIdsSortedByChildOrder(chipGroup);
                ChipGroup chipGroup2 = (ChipGroup) ((Headers.Builder) onCheckedStateChangeListener).namesAndValues;
                if (chipGroup2.checkableGroup.singleSelection) {
                    chipGroup2.getCheckedChipId();
                    throw null;
                }
            }
        }
    }

    public final boolean uncheckInternal(MaterialCheckable materialCheckable, boolean z) {
        int id = materialCheckable.getId();
        Integer numValueOf = Integer.valueOf(id);
        HashSet hashSet = this.checkedIds;
        if (!hashSet.contains(numValueOf)) {
            return false;
        }
        if (z && hashSet.size() == 1 && hashSet.contains(Integer.valueOf(id))) {
            materialCheckable.setChecked(true);
            return false;
        }
        boolean zRemove = hashSet.remove(Integer.valueOf(id));
        if (materialCheckable.isChecked()) {
            materialCheckable.setChecked(false);
        }
        return zRemove;
    }
}
