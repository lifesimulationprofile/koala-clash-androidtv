package com.github.kr328.clash.design;

import android.util.SparseIntArray;
import androidx.databinding.DataBinderMapper;
import com.koala.clash.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class DataBinderMapperImpl extends DataBinderMapper {
    static {
        SparseIntArray sparseIntArray = new SparseIntArray(15);
        sparseIntArray.put(R.layout.adapter_editable_text_list, 1);
        sparseIntArray.put(R.layout.adapter_editable_text_map, 2);
        sparseIntArray.put(R.layout.adapter_sideload_provider, 3);
        sparseIntArray.put(R.layout.common_recycler_list, 4);
        sparseIntArray.put(R.layout.component_action_label, 5);
        sparseIntArray.put(R.layout.component_action_text_field, 6);
        sparseIntArray.put(R.layout.component_large_action_label, 7);
        sparseIntArray.put(R.layout.dialog_editable_map_text_field, 8);
        sparseIntArray.put(R.layout.dialog_fetch_status, 9);
        sparseIntArray.put(R.layout.dialog_preference_list, 10);
        sparseIntArray.put(R.layout.dialog_text_field, 11);
        sparseIntArray.put(R.layout.preference_category, 12);
        sparseIntArray.put(R.layout.preference_clickable, 13);
        sparseIntArray.put(R.layout.preference_switch, 14);
        sparseIntArray.put(R.layout.preference_tips, 15);
    }

    @Override // androidx.databinding.DataBinderMapper
    public final List collectDependencies() {
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.github.kr328.clash.common.DataBinderMapperImpl());
        arrayList.add(new com.github.kr328.clash.core.DataBinderMapperImpl());
        arrayList.add(new com.github.kr328.clash.service.DataBinderMapperImpl());
        return arrayList;
    }
}
