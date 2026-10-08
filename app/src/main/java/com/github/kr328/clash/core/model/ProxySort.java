package com.github.kr328.clash.core.model;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ProxySort {
    public static final /* synthetic */ ProxySort[] $VALUES;
    public static final ProxySort Default;
    public static final ProxySort Delay;
    public static final ProxySort Title;

    static {
        ProxySort proxySort = new ProxySort("Default", 0);
        Default = proxySort;
        ProxySort proxySort2 = new ProxySort("Title", 1);
        Title = proxySort2;
        ProxySort proxySort3 = new ProxySort("Delay", 2);
        Delay = proxySort3;
        $VALUES = new ProxySort[]{proxySort, proxySort2, proxySort3};
    }

    public static ProxySort valueOf(String str) {
        return (ProxySort) Enum.valueOf(ProxySort.class, str);
    }

    public static ProxySort[] values() {
        return (ProxySort[]) $VALUES.clone();
    }
}
