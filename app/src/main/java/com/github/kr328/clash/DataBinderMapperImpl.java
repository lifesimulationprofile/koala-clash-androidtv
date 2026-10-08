package com.github.kr328.clash;

import android.util.SparseIntArray;
import androidx.databinding.DataBinderMapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class DataBinderMapperImpl extends DataBinderMapper {
    static {
        new SparseIntArray(0);
    }

    @Override // androidx.databinding.DataBinderMapper
    public final List collectDependencies() {
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.github.kr328.clash.common.DataBinderMapperImpl());
        arrayList.add(new com.github.kr328.clash.core.DataBinderMapperImpl());
        arrayList.add(new com.github.kr328.clash.design.DataBinderMapperImpl());
        arrayList.add(new com.github.kr328.clash.service.DataBinderMapperImpl());
        return arrayList;
    }
}
