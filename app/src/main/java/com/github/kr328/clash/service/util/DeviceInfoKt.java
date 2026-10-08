package com.github.kr328.clash.service.util;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class DeviceInfoKt {
    public static final String capitalizeFirst(String str) {
        String strValueOf;
        if (str.length() <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char cCharAt = str.charAt(0);
        if (Character.isLowerCase(cCharAt)) {
            Locale locale = Locale.ROOT;
            strValueOf = String.valueOf(cCharAt).toUpperCase(locale);
            if (strValueOf.length() > 1) {
                if (cCharAt != 329) {
                    strValueOf = strValueOf.charAt(0) + strValueOf.substring(1).toLowerCase(locale);
                }
            } else if (strValueOf.equals(String.valueOf(cCharAt).toUpperCase(locale))) {
                strValueOf = String.valueOf(Character.toTitleCase(cCharAt));
            }
        } else {
            strValueOf = String.valueOf(cCharAt);
        }
        sb.append((Object) strValueOf);
        sb.append(str.substring(1));
        return sb.toString();
    }
}
