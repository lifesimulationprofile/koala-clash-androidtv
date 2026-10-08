package com.google.android.datatransport.cct.internal;

import android.util.SparseArray;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class NetworkConnectionInfo {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class MobileSubtype {
        public static final /* synthetic */ MobileSubtype[] $VALUES;
        public static final SparseArray valueMap;

        /* JADX INFO: Fake field, exist only in values array */
        MobileSubtype EF0;

        static {
            MobileSubtype mobileSubtype = new MobileSubtype("UNKNOWN_MOBILE_SUBTYPE", 0);
            MobileSubtype mobileSubtype2 = new MobileSubtype("GPRS", 1);
            MobileSubtype mobileSubtype3 = new MobileSubtype("EDGE", 2);
            MobileSubtype mobileSubtype4 = new MobileSubtype("UMTS", 3);
            MobileSubtype mobileSubtype5 = new MobileSubtype("CDMA", 4);
            MobileSubtype mobileSubtype6 = new MobileSubtype("EVDO_0", 5);
            MobileSubtype mobileSubtype7 = new MobileSubtype("EVDO_A", 6);
            MobileSubtype mobileSubtype8 = new MobileSubtype("RTT", 7);
            MobileSubtype mobileSubtype9 = new MobileSubtype("HSDPA", 8);
            MobileSubtype mobileSubtype10 = new MobileSubtype("HSUPA", 9);
            MobileSubtype mobileSubtype11 = new MobileSubtype("HSPA", 10);
            MobileSubtype mobileSubtype12 = new MobileSubtype("IDEN", 11);
            MobileSubtype mobileSubtype13 = new MobileSubtype("EVDO_B", 12);
            MobileSubtype mobileSubtype14 = new MobileSubtype("LTE", 13);
            MobileSubtype mobileSubtype15 = new MobileSubtype("EHRPD", 14);
            MobileSubtype mobileSubtype16 = new MobileSubtype("HSPAP", 15);
            MobileSubtype mobileSubtype17 = new MobileSubtype("GSM", 16);
            MobileSubtype mobileSubtype18 = new MobileSubtype("TD_SCDMA", 17);
            MobileSubtype mobileSubtype19 = new MobileSubtype("IWLAN", 18);
            MobileSubtype mobileSubtype20 = new MobileSubtype("LTE_CA", 19);
            $VALUES = new MobileSubtype[]{mobileSubtype, mobileSubtype2, mobileSubtype3, mobileSubtype4, mobileSubtype5, mobileSubtype6, mobileSubtype7, mobileSubtype8, mobileSubtype9, mobileSubtype10, mobileSubtype11, mobileSubtype12, mobileSubtype13, mobileSubtype14, mobileSubtype15, mobileSubtype16, mobileSubtype17, mobileSubtype18, mobileSubtype19, mobileSubtype20, new MobileSubtype("COMBINED", 20)};
            SparseArray sparseArray = new SparseArray();
            valueMap = sparseArray;
            sparseArray.put(0, mobileSubtype);
            sparseArray.put(1, mobileSubtype2);
            sparseArray.put(2, mobileSubtype3);
            sparseArray.put(3, mobileSubtype4);
            sparseArray.put(4, mobileSubtype5);
            sparseArray.put(5, mobileSubtype6);
            sparseArray.put(6, mobileSubtype7);
            sparseArray.put(7, mobileSubtype8);
            sparseArray.put(8, mobileSubtype9);
            sparseArray.put(9, mobileSubtype10);
            sparseArray.put(10, mobileSubtype11);
            sparseArray.put(11, mobileSubtype12);
            sparseArray.put(12, mobileSubtype13);
            sparseArray.put(13, mobileSubtype14);
            sparseArray.put(14, mobileSubtype15);
            sparseArray.put(15, mobileSubtype16);
            sparseArray.put(16, mobileSubtype17);
            sparseArray.put(17, mobileSubtype18);
            sparseArray.put(18, mobileSubtype19);
            sparseArray.put(19, mobileSubtype20);
        }

        public static MobileSubtype valueOf(String str) {
            return (MobileSubtype) Enum.valueOf(MobileSubtype.class, str);
        }

        public static MobileSubtype[] values() {
            return (MobileSubtype[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class NetworkType {
        public static final /* synthetic */ NetworkType[] $VALUES;
        public static final SparseArray valueMap;

        /* JADX INFO: Fake field, exist only in values array */
        NetworkType EF0;

        static {
            NetworkType networkType = new NetworkType("MOBILE", 0);
            NetworkType networkType2 = new NetworkType("WIFI", 1);
            NetworkType networkType3 = new NetworkType("MOBILE_MMS", 2);
            NetworkType networkType4 = new NetworkType("MOBILE_SUPL", 3);
            NetworkType networkType5 = new NetworkType("MOBILE_DUN", 4);
            NetworkType networkType6 = new NetworkType("MOBILE_HIPRI", 5);
            NetworkType networkType7 = new NetworkType("WIMAX", 6);
            NetworkType networkType8 = new NetworkType("BLUETOOTH", 7);
            NetworkType networkType9 = new NetworkType("DUMMY", 8);
            NetworkType networkType10 = new NetworkType("ETHERNET", 9);
            NetworkType networkType11 = new NetworkType("MOBILE_FOTA", 10);
            NetworkType networkType12 = new NetworkType("MOBILE_IMS", 11);
            NetworkType networkType13 = new NetworkType("MOBILE_CBS", 12);
            NetworkType networkType14 = new NetworkType("WIFI_P2P", 13);
            NetworkType networkType15 = new NetworkType("MOBILE_IA", 14);
            NetworkType networkType16 = new NetworkType("MOBILE_EMERGENCY", 15);
            NetworkType networkType17 = new NetworkType("PROXY", 16);
            NetworkType networkType18 = new NetworkType("VPN", 17);
            NetworkType networkType19 = new NetworkType("NONE", 18);
            $VALUES = new NetworkType[]{networkType, networkType2, networkType3, networkType4, networkType5, networkType6, networkType7, networkType8, networkType9, networkType10, networkType11, networkType12, networkType13, networkType14, networkType15, networkType16, networkType17, networkType18, networkType19};
            SparseArray sparseArray = new SparseArray();
            valueMap = sparseArray;
            sparseArray.put(0, networkType);
            sparseArray.put(1, networkType2);
            sparseArray.put(2, networkType3);
            sparseArray.put(3, networkType4);
            sparseArray.put(4, networkType5);
            sparseArray.put(5, networkType6);
            sparseArray.put(6, networkType7);
            sparseArray.put(7, networkType8);
            sparseArray.put(8, networkType9);
            sparseArray.put(9, networkType10);
            sparseArray.put(10, networkType11);
            sparseArray.put(11, networkType12);
            sparseArray.put(12, networkType13);
            sparseArray.put(13, networkType14);
            sparseArray.put(14, networkType15);
            sparseArray.put(15, networkType16);
            sparseArray.put(16, networkType17);
            sparseArray.put(17, networkType18);
            sparseArray.put(-1, networkType19);
        }

        public static NetworkType valueOf(String str) {
            return (NetworkType) Enum.valueOf(NetworkType.class, str);
        }

        public static NetworkType[] values() {
            return (NetworkType[]) $VALUES.clone();
        }
    }
}
