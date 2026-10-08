package com.google.android.datatransport.cct.internal;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AutoValue_AndroidClientInfo extends AndroidClientInfo {
    public final String applicationBuild;
    public final String country;
    public final String device;
    public final String fingerprint;
    public final String hardware;
    public final String locale;
    public final String manufacturer;
    public final String mccMnc;
    public final String model;
    public final String osBuild;
    public final String product;
    public final Integer sdkVersion;

    public AutoValue_AndroidClientInfo(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.sdkVersion = num;
        this.model = str;
        this.hardware = str2;
        this.device = str3;
        this.product = str4;
        this.osBuild = str5;
        this.manufacturer = str6;
        this.fingerprint = str7;
        this.locale = str8;
        this.country = str9;
        this.mccMnc = str10;
        this.applicationBuild = str11;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AndroidClientInfo) {
            AndroidClientInfo androidClientInfo = (AndroidClientInfo) obj;
            Integer num = this.sdkVersion;
            if (num != null ? num.equals(((AutoValue_AndroidClientInfo) androidClientInfo).sdkVersion) : ((AutoValue_AndroidClientInfo) androidClientInfo).sdkVersion == null) {
                String str = this.model;
                if (str != null ? str.equals(((AutoValue_AndroidClientInfo) androidClientInfo).model) : ((AutoValue_AndroidClientInfo) androidClientInfo).model == null) {
                    String str2 = this.hardware;
                    if (str2 != null ? str2.equals(((AutoValue_AndroidClientInfo) androidClientInfo).hardware) : ((AutoValue_AndroidClientInfo) androidClientInfo).hardware == null) {
                        String str3 = this.device;
                        if (str3 != null ? str3.equals(((AutoValue_AndroidClientInfo) androidClientInfo).device) : ((AutoValue_AndroidClientInfo) androidClientInfo).device == null) {
                            String str4 = this.product;
                            if (str4 != null ? str4.equals(((AutoValue_AndroidClientInfo) androidClientInfo).product) : ((AutoValue_AndroidClientInfo) androidClientInfo).product == null) {
                                String str5 = this.osBuild;
                                if (str5 != null ? str5.equals(((AutoValue_AndroidClientInfo) androidClientInfo).osBuild) : ((AutoValue_AndroidClientInfo) androidClientInfo).osBuild == null) {
                                    String str6 = this.manufacturer;
                                    if (str6 != null ? str6.equals(((AutoValue_AndroidClientInfo) androidClientInfo).manufacturer) : ((AutoValue_AndroidClientInfo) androidClientInfo).manufacturer == null) {
                                        String str7 = this.fingerprint;
                                        if (str7 != null ? str7.equals(((AutoValue_AndroidClientInfo) androidClientInfo).fingerprint) : ((AutoValue_AndroidClientInfo) androidClientInfo).fingerprint == null) {
                                            String str8 = this.locale;
                                            if (str8 != null ? str8.equals(((AutoValue_AndroidClientInfo) androidClientInfo).locale) : ((AutoValue_AndroidClientInfo) androidClientInfo).locale == null) {
                                                String str9 = this.country;
                                                if (str9 != null ? str9.equals(((AutoValue_AndroidClientInfo) androidClientInfo).country) : ((AutoValue_AndroidClientInfo) androidClientInfo).country == null) {
                                                    String str10 = this.mccMnc;
                                                    if (str10 != null ? str10.equals(((AutoValue_AndroidClientInfo) androidClientInfo).mccMnc) : ((AutoValue_AndroidClientInfo) androidClientInfo).mccMnc == null) {
                                                        String str11 = this.applicationBuild;
                                                        if (str11 != null ? str11.equals(((AutoValue_AndroidClientInfo) androidClientInfo).applicationBuild) : ((AutoValue_AndroidClientInfo) androidClientInfo).applicationBuild == null) {
                                                            return true;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        Integer num = this.sdkVersion;
        int iHashCode = ((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003;
        String str = this.model;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.hardware;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.device;
        int iHashCode4 = (iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.product;
        int iHashCode5 = (iHashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.osBuild;
        int iHashCode6 = (iHashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.manufacturer;
        int iHashCode7 = (iHashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.fingerprint;
        int iHashCode8 = (iHashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.locale;
        int iHashCode9 = (iHashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.country;
        int iHashCode10 = (iHashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.mccMnc;
        int iHashCode11 = (iHashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.applicationBuild;
        return (str11 != null ? str11.hashCode() : 0) ^ iHashCode11;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AndroidClientInfo{sdkVersion=");
        sb.append(this.sdkVersion);
        sb.append(", model=");
        sb.append(this.model);
        sb.append(", hardware=");
        sb.append(this.hardware);
        sb.append(", device=");
        sb.append(this.device);
        sb.append(", product=");
        sb.append(this.product);
        sb.append(", osBuild=");
        sb.append(this.osBuild);
        sb.append(", manufacturer=");
        sb.append(this.manufacturer);
        sb.append(", fingerprint=");
        sb.append(this.fingerprint);
        sb.append(", locale=");
        sb.append(this.locale);
        sb.append(", country=");
        sb.append(this.country);
        sb.append(", mccMnc=");
        sb.append(this.mccMnc);
        sb.append(", applicationBuild=");
        return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.applicationBuild, "}");
    }
}
