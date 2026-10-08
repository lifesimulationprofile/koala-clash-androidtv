package com.google.android.datatransport.cct.internal;

import android.util.SparseArray;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class QosTier {
    public static final /* synthetic */ QosTier[] $VALUES;
    public static final QosTier DEFAULT;

    static {
        QosTier qosTier = new QosTier("DEFAULT", 0);
        DEFAULT = qosTier;
        QosTier qosTier2 = new QosTier("UNMETERED_ONLY", 1);
        QosTier qosTier3 = new QosTier("UNMETERED_OR_DAILY", 2);
        QosTier qosTier4 = new QosTier("FAST_IF_RADIO_AWAKE", 3);
        QosTier qosTier5 = new QosTier("NEVER", 4);
        QosTier qosTier6 = new QosTier("UNRECOGNIZED", 5);
        $VALUES = new QosTier[]{qosTier, qosTier2, qosTier3, qosTier4, qosTier5, qosTier6};
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, qosTier);
        sparseArray.put(1, qosTier2);
        sparseArray.put(2, qosTier3);
        sparseArray.put(3, qosTier4);
        sparseArray.put(4, qosTier5);
        sparseArray.put(-1, qosTier6);
    }

    public static QosTier valueOf(String str) {
        return (QosTier) Enum.valueOf(QosTier.class, str);
    }

    public static QosTier[] values() {
        return (QosTier[]) $VALUES.clone();
    }
}
