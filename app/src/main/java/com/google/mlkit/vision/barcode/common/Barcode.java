package com.google.mlkit.vision.barcode.common;

import com.google.mlkit.vision.barcode.common.internal.BarcodeSource;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Barcode {
    public final BarcodeSource zza;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Address {
        public final int zza;
        public final String[] zzb;

        public Address(int i, String[] strArr) {
            this.zza = i;
            this.zzb = strArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class CalendarDateTime {
        public final int zza;
        public final int zzb;
        public final int zzc;
        public final int zzd;
        public final int zze;
        public final int zzf;
        public final boolean zzg;

        public CalendarDateTime(int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
            this.zza = i;
            this.zzb = i2;
            this.zzc = i3;
            this.zzd = i4;
            this.zze = i5;
            this.zzf = i6;
            this.zzg = z;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Email {
        public final int zza;
        public final String zzb;
        public final String zzc;
        public final String zzd;

        public Email(int i, String str, String str2, String str3) {
            this.zza = i;
            this.zzb = str;
            this.zzc = str2;
            this.zzd = str3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class GeoPoint {
        public final double zza;
        public final double zzb;

        public GeoPoint(double d, double d2) {
            this.zza = d;
            this.zzb = d2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Phone {
        public final String zza;
        public final int zzb;

        public Phone(String str, int i) {
            this.zza = str;
            this.zzb = i;
        }
    }

    public Barcode(BarcodeSource barcodeSource) {
        this.zza = barcodeSource;
        barcodeSource.getBoundingBox();
        barcodeSource.getCornerPoints();
    }
}
