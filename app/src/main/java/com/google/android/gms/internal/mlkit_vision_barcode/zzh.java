package com.google.android.gms.internal.mlkit_vision_barcode;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzh implements Parcelable.Creator {
    public final /* synthetic */ int $r8$classId;

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.$r8$classId) {
            case 0:
                int iValidateObjectHeader = com.google.android.gms.internal.mlkit_vision_common.zzko.validateObjectHeader(parcel);
                String[] strArrCreateStringArray = null;
                int i = 0;
                while (parcel.dataPosition() < iValidateObjectHeader) {
                    int i2 = parcel.readInt();
                    char c = (char) i2;
                    if (c == 2) {
                        i = com.google.android.gms.internal.mlkit_vision_common.zzko.readInt(parcel, i2);
                    } else if (c != 3) {
                        com.google.android.gms.internal.mlkit_vision_common.zzko.skipUnknownField(parcel, i2);
                    } else {
                        strArrCreateStringArray = com.google.android.gms.internal.mlkit_vision_common.zzko.createStringArray(parcel, i2);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.zzko.ensureAtEnd(parcel, iValidateObjectHeader);
                zzi zziVar = new zzi();
                zziVar.zza = i;
                zziVar.zzb = strArrCreateStringArray;
                return zziVar;
            case 1:
                int iValidateObjectHeader2 = com.google.android.gms.internal.mlkit_vision_common.zzko.validateObjectHeader(parcel);
                String strCreateString = null;
                String strCreateString2 = null;
                int i3 = 0;
                String strCreateString3 = null;
                while (parcel.dataPosition() < iValidateObjectHeader2) {
                    int i4 = parcel.readInt();
                    char c2 = (char) i4;
                    if (c2 == 2) {
                        i3 = com.google.android.gms.internal.mlkit_vision_common.zzko.readInt(parcel, i4);
                    } else if (c2 == 3) {
                        strCreateString = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i4);
                    } else if (c2 == 4) {
                        strCreateString3 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i4);
                    } else if (c2 != 5) {
                        com.google.android.gms.internal.mlkit_vision_common.zzko.skipUnknownField(parcel, i4);
                    } else {
                        strCreateString2 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i4);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.zzko.ensureAtEnd(parcel, iValidateObjectHeader2);
                zzn zznVar = new zzn();
                zznVar.zza = i3;
                zznVar.zzb = strCreateString;
                zznVar.zzc = strCreateString3;
                zznVar.zzd = strCreateString2;
                return zznVar;
            case 2:
                int iValidateObjectHeader3 = com.google.android.gms.internal.mlkit_vision_common.zzko.validateObjectHeader(parcel);
                double d = 0.0d;
                double d2 = 0.0d;
                while (parcel.dataPosition() < iValidateObjectHeader3) {
                    int i5 = parcel.readInt();
                    char c3 = (char) i5;
                    if (c3 == 2) {
                        d = com.google.android.gms.internal.mlkit_vision_common.zzko.readDouble(parcel, i5);
                    } else if (c3 != 3) {
                        com.google.android.gms.internal.mlkit_vision_common.zzko.skipUnknownField(parcel, i5);
                    } else {
                        d2 = com.google.android.gms.internal.mlkit_vision_common.zzko.readDouble(parcel, i5);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.zzko.ensureAtEnd(parcel, iValidateObjectHeader3);
                zzo zzoVar = new zzo();
                zzoVar.zza = d;
                zzoVar.zzb = d2;
                return zzoVar;
            case 3:
                int iValidateObjectHeader4 = com.google.android.gms.internal.mlkit_vision_common.zzko.validateObjectHeader(parcel);
                String strCreateString4 = null;
                String strCreateString5 = null;
                String strCreateString6 = null;
                String strCreateString7 = null;
                String strCreateString8 = null;
                String strCreateString9 = null;
                String strCreateString10 = null;
                while (parcel.dataPosition() < iValidateObjectHeader4) {
                    int i6 = parcel.readInt();
                    switch ((char) i6) {
                        case 2:
                            strCreateString4 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i6);
                            break;
                        case 3:
                            strCreateString5 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i6);
                            break;
                        case 4:
                            strCreateString6 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i6);
                            break;
                        case 5:
                            strCreateString7 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i6);
                            break;
                        case 6:
                            strCreateString8 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i6);
                            break;
                        case 7:
                            strCreateString9 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i6);
                            break;
                        case '\b':
                            strCreateString10 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i6);
                            break;
                        default:
                            com.google.android.gms.internal.mlkit_vision_common.zzko.skipUnknownField(parcel, i6);
                            break;
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.zzko.ensureAtEnd(parcel, iValidateObjectHeader4);
                zzp zzpVar = new zzp();
                zzpVar.zza = strCreateString4;
                zzpVar.zzb = strCreateString5;
                zzpVar.zzc = strCreateString6;
                zzpVar.zzd = strCreateString7;
                zzpVar.zze = strCreateString8;
                zzpVar.zzf = strCreateString9;
                zzpVar.zzg = strCreateString10;
                return zzpVar;
            case 4:
                int iValidateObjectHeader5 = com.google.android.gms.internal.mlkit_vision_common.zzko.validateObjectHeader(parcel);
                String strCreateString11 = null;
                int i7 = 0;
                while (parcel.dataPosition() < iValidateObjectHeader5) {
                    int i8 = parcel.readInt();
                    char c4 = (char) i8;
                    if (c4 == 2) {
                        i7 = com.google.android.gms.internal.mlkit_vision_common.zzko.readInt(parcel, i8);
                    } else if (c4 != 3) {
                        com.google.android.gms.internal.mlkit_vision_common.zzko.skipUnknownField(parcel, i8);
                    } else {
                        strCreateString11 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i8);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.zzko.ensureAtEnd(parcel, iValidateObjectHeader5);
                zzq zzqVar = new zzq();
                zzqVar.zza = i7;
                zzqVar.zzb = strCreateString11;
                return zzqVar;
            case 5:
                int iValidateObjectHeader6 = com.google.android.gms.internal.mlkit_vision_common.zzko.validateObjectHeader(parcel);
                String strCreateString12 = null;
                String strCreateString13 = null;
                while (parcel.dataPosition() < iValidateObjectHeader6) {
                    int i9 = parcel.readInt();
                    char c5 = (char) i9;
                    if (c5 == 2) {
                        strCreateString12 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i9);
                    } else if (c5 != 3) {
                        com.google.android.gms.internal.mlkit_vision_common.zzko.skipUnknownField(parcel, i9);
                    } else {
                        strCreateString13 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i9);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.zzko.ensureAtEnd(parcel, iValidateObjectHeader6);
                zzr zzrVar = new zzr();
                zzrVar.zza = strCreateString12;
                zzrVar.zzb = strCreateString13;
                return zzrVar;
            case 6:
                int iValidateObjectHeader7 = com.google.android.gms.internal.mlkit_vision_common.zzko.validateObjectHeader(parcel);
                String strCreateString14 = null;
                String strCreateString15 = null;
                while (parcel.dataPosition() < iValidateObjectHeader7) {
                    int i10 = parcel.readInt();
                    char c6 = (char) i10;
                    if (c6 == 2) {
                        strCreateString14 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i10);
                    } else if (c6 != 3) {
                        com.google.android.gms.internal.mlkit_vision_common.zzko.skipUnknownField(parcel, i10);
                    } else {
                        strCreateString15 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i10);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.zzko.ensureAtEnd(parcel, iValidateObjectHeader7);
                zzs zzsVar = new zzs();
                zzsVar.zza = strCreateString14;
                zzsVar.zzb = strCreateString15;
                return zzsVar;
            case 7:
                int iValidateObjectHeader8 = com.google.android.gms.internal.mlkit_vision_common.zzko.validateObjectHeader(parcel);
                int i11 = 0;
                String strCreateString16 = null;
                String strCreateString17 = null;
                while (parcel.dataPosition() < iValidateObjectHeader8) {
                    int i12 = parcel.readInt();
                    char c7 = (char) i12;
                    if (c7 == 2) {
                        strCreateString16 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i12);
                    } else if (c7 == 3) {
                        strCreateString17 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i12);
                    } else if (c7 != 4) {
                        com.google.android.gms.internal.mlkit_vision_common.zzko.skipUnknownField(parcel, i12);
                    } else {
                        i11 = com.google.android.gms.internal.mlkit_vision_common.zzko.readInt(parcel, i12);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.zzko.ensureAtEnd(parcel, iValidateObjectHeader8);
                zzt zztVar = new zzt();
                zztVar.zza = strCreateString16;
                zztVar.zzb = strCreateString17;
                zztVar.zzc = i11;
                return zztVar;
            case 8:
                int iValidateObjectHeader9 = com.google.android.gms.internal.mlkit_vision_common.zzko.validateObjectHeader(parcel);
                int i13 = 0;
                boolean z = false;
                while (parcel.dataPosition() < iValidateObjectHeader9) {
                    int i14 = parcel.readInt();
                    char c8 = (char) i14;
                    if (c8 == 2) {
                        i13 = com.google.android.gms.internal.mlkit_vision_common.zzko.readInt(parcel, i14);
                    } else if (c8 != 3) {
                        com.google.android.gms.internal.mlkit_vision_common.zzko.skipUnknownField(parcel, i14);
                    } else {
                        z = com.google.android.gms.internal.mlkit_vision_common.zzko.readBoolean(parcel, i14);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.zzko.ensureAtEnd(parcel, iValidateObjectHeader9);
                zzah zzahVar = new zzah();
                zzahVar.zza = i13;
                zzahVar.zzb = z;
                return zzahVar;
            case 9:
                int iValidateObjectHeader10 = com.google.android.gms.internal.mlkit_vision_common.zzko.validateObjectHeader(parcel);
                int i15 = 0;
                int i16 = 0;
                int i17 = 0;
                int i18 = 0;
                long j = 0;
                while (parcel.dataPosition() < iValidateObjectHeader10) {
                    int i19 = parcel.readInt();
                    char c9 = (char) i19;
                    if (c9 == 2) {
                        i15 = com.google.android.gms.internal.mlkit_vision_common.zzko.readInt(parcel, i19);
                    } else if (c9 == 3) {
                        i16 = com.google.android.gms.internal.mlkit_vision_common.zzko.readInt(parcel, i19);
                    } else if (c9 == 4) {
                        i17 = com.google.android.gms.internal.mlkit_vision_common.zzko.readInt(parcel, i19);
                    } else if (c9 == 5) {
                        j = com.google.android.gms.internal.mlkit_vision_common.zzko.readLong(parcel, i19);
                    } else if (c9 != 6) {
                        com.google.android.gms.internal.mlkit_vision_common.zzko.skipUnknownField(parcel, i19);
                    } else {
                        i18 = com.google.android.gms.internal.mlkit_vision_common.zzko.readInt(parcel, i19);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.zzko.ensureAtEnd(parcel, iValidateObjectHeader10);
                return new zzan(i15, i16, i17, i18, j);
            case 10:
                int iValidateObjectHeader11 = com.google.android.gms.internal.mlkit_vision_common.zzko.validateObjectHeader(parcel);
                double d3 = 0.0d;
                int i20 = 0;
                boolean z2 = false;
                String strCreateString18 = null;
                String strCreateString19 = null;
                Point[] pointArr = null;
                zzn zznVar2 = null;
                zzq zzqVar2 = null;
                zzr zzrVar2 = null;
                zzt zztVar2 = null;
                byte[] bArrCreateByteArray = null;
                zzo zzoVar2 = null;
                zzs zzsVar2 = null;
                zzk zzkVar = null;
                zzl zzlVar = null;
                zzm zzmVar = null;
                int i21 = 0;
                while (parcel.dataPosition() < iValidateObjectHeader11) {
                    int i22 = parcel.readInt();
                    zzt zztVar3 = zztVar2;
                    switch ((char) i22) {
                        case 2:
                            i20 = com.google.android.gms.internal.mlkit_vision_common.zzko.readInt(parcel, i22);
                            break;
                        case 3:
                            strCreateString18 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i22);
                            break;
                        case 4:
                            strCreateString19 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i22);
                            break;
                        case 5:
                            i21 = com.google.android.gms.internal.mlkit_vision_common.zzko.readInt(parcel, i22);
                            break;
                        case 6:
                            pointArr = (Point[]) com.google.android.gms.internal.mlkit_vision_common.zzko.createTypedArray(i22, parcel, Point.CREATOR);
                            break;
                        case 7:
                            zznVar2 = (zzn) com.google.android.gms.internal.mlkit_vision_common.zzko.createParcelable(i22, parcel, zzn.CREATOR);
                            break;
                        case '\b':
                            zzqVar2 = (zzq) com.google.android.gms.internal.mlkit_vision_common.zzko.createParcelable(i22, parcel, zzq.CREATOR);
                            break;
                        case '\t':
                            zzrVar2 = (zzr) com.google.android.gms.internal.mlkit_vision_common.zzko.createParcelable(i22, parcel, zzr.CREATOR);
                            break;
                        case '\n':
                            zztVar2 = (zzt) com.google.android.gms.internal.mlkit_vision_common.zzko.createParcelable(i22, parcel, zzt.CREATOR);
                            continue;
                        case 11:
                            zzsVar2 = (zzs) com.google.android.gms.internal.mlkit_vision_common.zzko.createParcelable(i22, parcel, zzs.CREATOR);
                            break;
                        case '\f':
                            zzoVar2 = (zzo) com.google.android.gms.internal.mlkit_vision_common.zzko.createParcelable(i22, parcel, zzo.CREATOR);
                            break;
                        case '\r':
                            zzkVar = (zzk) com.google.android.gms.internal.mlkit_vision_common.zzko.createParcelable(i22, parcel, zzk.CREATOR);
                            break;
                        case 14:
                            zzlVar = (zzl) com.google.android.gms.internal.mlkit_vision_common.zzko.createParcelable(i22, parcel, zzl.CREATOR);
                            break;
                        case 15:
                            zzmVar = (zzm) com.google.android.gms.internal.mlkit_vision_common.zzko.createParcelable(i22, parcel, zzm.CREATOR);
                            break;
                        case 16:
                            bArrCreateByteArray = com.google.android.gms.internal.mlkit_vision_common.zzko.createByteArray(parcel, i22);
                            break;
                        case 17:
                            z2 = com.google.android.gms.internal.mlkit_vision_common.zzko.readBoolean(parcel, i22);
                            break;
                        case 18:
                            d3 = com.google.android.gms.internal.mlkit_vision_common.zzko.readDouble(parcel, i22);
                            break;
                        default:
                            com.google.android.gms.internal.mlkit_vision_common.zzko.skipUnknownField(parcel, i22);
                            break;
                    }
                    zztVar2 = zztVar3;
                }
                com.google.android.gms.internal.mlkit_vision_common.zzko.ensureAtEnd(parcel, iValidateObjectHeader11);
                zzu zzuVar = new zzu();
                zzuVar.zza = i20;
                zzuVar.zzb = strCreateString18;
                zzuVar.zzo = bArrCreateByteArray;
                zzuVar.zzc = strCreateString19;
                zzuVar.zzd = i21;
                zzuVar.zze = pointArr;
                zzuVar.zzp = z2;
                zzuVar.zzq = d3;
                zzuVar.zzf = zznVar2;
                zzuVar.zzg = zzqVar2;
                zzuVar.zzh = zzrVar2;
                zzuVar.zzi = zztVar2;
                zzuVar.zzj = zzsVar2;
                zzuVar.zzk = zzoVar2;
                zzuVar.zzl = zzkVar;
                zzuVar.zzm = zzlVar;
                zzuVar.zzn = zzmVar;
                return zzuVar;
            case 11:
                int iValidateObjectHeader12 = com.google.android.gms.internal.mlkit_vision_common.zzko.validateObjectHeader(parcel);
                String strCreateString20 = null;
                int i23 = 0;
                int i24 = 0;
                int i25 = 0;
                int i26 = 0;
                int i27 = 0;
                int i28 = 0;
                boolean z3 = false;
                while (parcel.dataPosition() < iValidateObjectHeader12) {
                    int i29 = parcel.readInt();
                    switch ((char) i29) {
                        case 2:
                            i23 = com.google.android.gms.internal.mlkit_vision_common.zzko.readInt(parcel, i29);
                            break;
                        case 3:
                            i24 = com.google.android.gms.internal.mlkit_vision_common.zzko.readInt(parcel, i29);
                            break;
                        case 4:
                            i25 = com.google.android.gms.internal.mlkit_vision_common.zzko.readInt(parcel, i29);
                            break;
                        case 5:
                            i26 = com.google.android.gms.internal.mlkit_vision_common.zzko.readInt(parcel, i29);
                            break;
                        case 6:
                            i27 = com.google.android.gms.internal.mlkit_vision_common.zzko.readInt(parcel, i29);
                            break;
                        case 7:
                            i28 = com.google.android.gms.internal.mlkit_vision_common.zzko.readInt(parcel, i29);
                            break;
                        case '\b':
                            z3 = com.google.android.gms.internal.mlkit_vision_common.zzko.readBoolean(parcel, i29);
                            break;
                        case '\t':
                            strCreateString20 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i29);
                            break;
                        default:
                            com.google.android.gms.internal.mlkit_vision_common.zzko.skipUnknownField(parcel, i29);
                            break;
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.zzko.ensureAtEnd(parcel, iValidateObjectHeader12);
                zzj zzjVar = new zzj();
                zzjVar.zza = i23;
                zzjVar.zzb = i24;
                zzjVar.zzc = i25;
                zzjVar.zzd = i26;
                zzjVar.zze = i27;
                zzjVar.zzf = i28;
                zzjVar.zzg = z3;
                zzjVar.zzh = strCreateString20;
                return zzjVar;
            case 12:
                int iValidateObjectHeader13 = com.google.android.gms.internal.mlkit_vision_common.zzko.validateObjectHeader(parcel);
                String strCreateString21 = null;
                String strCreateString22 = null;
                String strCreateString23 = null;
                String strCreateString24 = null;
                String strCreateString25 = null;
                zzj zzjVar2 = null;
                zzj zzjVar3 = null;
                while (parcel.dataPosition() < iValidateObjectHeader13) {
                    int i30 = parcel.readInt();
                    switch ((char) i30) {
                        case 2:
                            strCreateString21 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i30);
                            break;
                        case 3:
                            strCreateString22 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i30);
                            break;
                        case 4:
                            strCreateString23 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i30);
                            break;
                        case 5:
                            strCreateString24 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i30);
                            break;
                        case 6:
                            strCreateString25 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i30);
                            break;
                        case 7:
                            zzjVar2 = (zzj) com.google.android.gms.internal.mlkit_vision_common.zzko.createParcelable(i30, parcel, zzj.CREATOR);
                            break;
                        case '\b':
                            zzjVar3 = (zzj) com.google.android.gms.internal.mlkit_vision_common.zzko.createParcelable(i30, parcel, zzj.CREATOR);
                            break;
                        default:
                            com.google.android.gms.internal.mlkit_vision_common.zzko.skipUnknownField(parcel, i30);
                            break;
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.zzko.ensureAtEnd(parcel, iValidateObjectHeader13);
                zzk zzkVar2 = new zzk();
                zzkVar2.zza = strCreateString21;
                zzkVar2.zzb = strCreateString22;
                zzkVar2.zzc = strCreateString23;
                zzkVar2.zzd = strCreateString24;
                zzkVar2.zze = strCreateString25;
                zzkVar2.zzf = zzjVar2;
                zzkVar2.zzg = zzjVar3;
                return zzkVar2;
            case 13:
                int iValidateObjectHeader14 = com.google.android.gms.internal.mlkit_vision_common.zzko.validateObjectHeader(parcel);
                String[] strArrCreateStringArray2 = null;
                int i31 = 0;
                while (parcel.dataPosition() < iValidateObjectHeader14) {
                    int i32 = parcel.readInt();
                    char c10 = (char) i32;
                    if (c10 == 1) {
                        i31 = com.google.android.gms.internal.mlkit_vision_common.zzko.readInt(parcel, i32);
                    } else if (c10 != 2) {
                        com.google.android.gms.internal.mlkit_vision_common.zzko.skipUnknownField(parcel, i32);
                    } else {
                        strArrCreateStringArray2 = com.google.android.gms.internal.mlkit_vision_common.zzko.createStringArray(parcel, i32);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.zzko.ensureAtEnd(parcel, iValidateObjectHeader14);
                return new zzxp(i31, strArrCreateStringArray2);
            case 14:
                int iValidateObjectHeader15 = com.google.android.gms.internal.mlkit_vision_common.zzko.validateObjectHeader(parcel);
                zzp zzpVar2 = null;
                String strCreateString26 = null;
                String strCreateString27 = null;
                zzq[] zzqVarArr = null;
                zzn[] zznVarArr = null;
                String[] strArrCreateStringArray3 = null;
                zzi[] zziVarArr = null;
                while (parcel.dataPosition() < iValidateObjectHeader15) {
                    int i33 = parcel.readInt();
                    switch ((char) i33) {
                        case 2:
                            zzpVar2 = (zzp) com.google.android.gms.internal.mlkit_vision_common.zzko.createParcelable(i33, parcel, zzp.CREATOR);
                            break;
                        case 3:
                            strCreateString26 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i33);
                            break;
                        case 4:
                            strCreateString27 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i33);
                            break;
                        case 5:
                            zzqVarArr = (zzq[]) com.google.android.gms.internal.mlkit_vision_common.zzko.createTypedArray(i33, parcel, zzq.CREATOR);
                            break;
                        case 6:
                            zznVarArr = (zzn[]) com.google.android.gms.internal.mlkit_vision_common.zzko.createTypedArray(i33, parcel, zzn.CREATOR);
                            break;
                        case 7:
                            strArrCreateStringArray3 = com.google.android.gms.internal.mlkit_vision_common.zzko.createStringArray(parcel, i33);
                            break;
                        case '\b':
                            zziVarArr = (zzi[]) com.google.android.gms.internal.mlkit_vision_common.zzko.createTypedArray(i33, parcel, zzi.CREATOR);
                            break;
                        default:
                            com.google.android.gms.internal.mlkit_vision_common.zzko.skipUnknownField(parcel, i33);
                            break;
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.zzko.ensureAtEnd(parcel, iValidateObjectHeader15);
                zzl zzlVar2 = new zzl();
                zzlVar2.zza = zzpVar2;
                zzlVar2.zzb = strCreateString26;
                zzlVar2.zzc = strCreateString27;
                zzlVar2.zzd = zzqVarArr;
                zzlVar2.zze = zznVarArr;
                zzlVar2.zzf = strArrCreateStringArray3;
                zzlVar2.zzg = zziVarArr;
                return zzlVar2;
            case 15:
                int iValidateObjectHeader16 = com.google.android.gms.internal.mlkit_vision_common.zzko.validateObjectHeader(parcel);
                String strCreateString28 = null;
                String strCreateString29 = null;
                byte[] bArrCreateByteArray2 = null;
                Point[] pointArr2 = null;
                zzxu zzxuVar = null;
                zzxx zzxxVar = null;
                zzxy zzxyVar = null;
                zzya zzyaVar = null;
                zzxz zzxzVar = null;
                zzxv zzxvVar = null;
                zzxr zzxrVar = null;
                zzxs zzxsVar = null;
                zzxt zzxtVar = null;
                int i34 = 0;
                int i35 = 0;
                while (parcel.dataPosition() < iValidateObjectHeader16) {
                    int i36 = parcel.readInt();
                    switch ((char) i36) {
                        case 1:
                            i34 = com.google.android.gms.internal.mlkit_vision_common.zzko.readInt(parcel, i36);
                            break;
                        case 2:
                            strCreateString28 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i36);
                            break;
                        case 3:
                            strCreateString29 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i36);
                            break;
                        case 4:
                            bArrCreateByteArray2 = com.google.android.gms.internal.mlkit_vision_common.zzko.createByteArray(parcel, i36);
                            break;
                        case 5:
                            pointArr2 = (Point[]) com.google.android.gms.internal.mlkit_vision_common.zzko.createTypedArray(i36, parcel, Point.CREATOR);
                            break;
                        case 6:
                            i35 = com.google.android.gms.internal.mlkit_vision_common.zzko.readInt(parcel, i36);
                            break;
                        case 7:
                            zzxuVar = (zzxu) com.google.android.gms.internal.mlkit_vision_common.zzko.createParcelable(i36, parcel, zzxu.CREATOR);
                            break;
                        case '\b':
                            zzxxVar = (zzxx) com.google.android.gms.internal.mlkit_vision_common.zzko.createParcelable(i36, parcel, zzxx.CREATOR);
                            break;
                        case '\t':
                            zzxyVar = (zzxy) com.google.android.gms.internal.mlkit_vision_common.zzko.createParcelable(i36, parcel, zzxy.CREATOR);
                            break;
                        case '\n':
                            zzyaVar = (zzya) com.google.android.gms.internal.mlkit_vision_common.zzko.createParcelable(i36, parcel, zzya.CREATOR);
                            break;
                        case 11:
                            zzxzVar = (zzxz) com.google.android.gms.internal.mlkit_vision_common.zzko.createParcelable(i36, parcel, zzxz.CREATOR);
                            break;
                        case '\f':
                            zzxvVar = (zzxv) com.google.android.gms.internal.mlkit_vision_common.zzko.createParcelable(i36, parcel, zzxv.CREATOR);
                            break;
                        case '\r':
                            zzxrVar = (zzxr) com.google.android.gms.internal.mlkit_vision_common.zzko.createParcelable(i36, parcel, zzxr.CREATOR);
                            break;
                        case 14:
                            zzxsVar = (zzxs) com.google.android.gms.internal.mlkit_vision_common.zzko.createParcelable(i36, parcel, zzxs.CREATOR);
                            break;
                        case 15:
                            zzxtVar = (zzxt) com.google.android.gms.internal.mlkit_vision_common.zzko.createParcelable(i36, parcel, zzxt.CREATOR);
                            break;
                        default:
                            com.google.android.gms.internal.mlkit_vision_common.zzko.skipUnknownField(parcel, i36);
                            break;
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.zzko.ensureAtEnd(parcel, iValidateObjectHeader16);
                return new zzyb(i34, strCreateString28, strCreateString29, bArrCreateByteArray2, pointArr2, i35, zzxuVar, zzxxVar, zzxyVar, zzyaVar, zzxzVar, zzxvVar, zzxrVar, zzxsVar, zzxtVar);
            case 16:
                int iValidateObjectHeader17 = com.google.android.gms.internal.mlkit_vision_common.zzko.validateObjectHeader(parcel);
                String strCreateString30 = null;
                int i37 = 0;
                int i38 = 0;
                int i39 = 0;
                int i40 = 0;
                int i41 = 0;
                int i42 = 0;
                boolean z4 = false;
                while (parcel.dataPosition() < iValidateObjectHeader17) {
                    int i43 = parcel.readInt();
                    switch ((char) i43) {
                        case 1:
                            i37 = com.google.android.gms.internal.mlkit_vision_common.zzko.readInt(parcel, i43);
                            break;
                        case 2:
                            i38 = com.google.android.gms.internal.mlkit_vision_common.zzko.readInt(parcel, i43);
                            break;
                        case 3:
                            i39 = com.google.android.gms.internal.mlkit_vision_common.zzko.readInt(parcel, i43);
                            break;
                        case 4:
                            i40 = com.google.android.gms.internal.mlkit_vision_common.zzko.readInt(parcel, i43);
                            break;
                        case 5:
                            i41 = com.google.android.gms.internal.mlkit_vision_common.zzko.readInt(parcel, i43);
                            break;
                        case 6:
                            i42 = com.google.android.gms.internal.mlkit_vision_common.zzko.readInt(parcel, i43);
                            break;
                        case 7:
                            z4 = com.google.android.gms.internal.mlkit_vision_common.zzko.readBoolean(parcel, i43);
                            break;
                        case '\b':
                            strCreateString30 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i43);
                            break;
                        default:
                            com.google.android.gms.internal.mlkit_vision_common.zzko.skipUnknownField(parcel, i43);
                            break;
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.zzko.ensureAtEnd(parcel, iValidateObjectHeader17);
                return new zzxq(i37, i38, i39, i40, i41, i42, z4, strCreateString30);
            case 17:
                int iValidateObjectHeader18 = com.google.android.gms.internal.mlkit_vision_common.zzko.validateObjectHeader(parcel);
                String strCreateString31 = null;
                String strCreateString32 = null;
                String strCreateString33 = null;
                String strCreateString34 = null;
                String strCreateString35 = null;
                zzxq zzxqVar = null;
                zzxq zzxqVar2 = null;
                while (parcel.dataPosition() < iValidateObjectHeader18) {
                    int i44 = parcel.readInt();
                    switch ((char) i44) {
                        case 1:
                            strCreateString31 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i44);
                            break;
                        case 2:
                            strCreateString32 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i44);
                            break;
                        case 3:
                            strCreateString33 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i44);
                            break;
                        case 4:
                            strCreateString34 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i44);
                            break;
                        case 5:
                            strCreateString35 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i44);
                            break;
                        case 6:
                            zzxqVar = (zzxq) com.google.android.gms.internal.mlkit_vision_common.zzko.createParcelable(i44, parcel, zzxq.CREATOR);
                            break;
                        case 7:
                            zzxqVar2 = (zzxq) com.google.android.gms.internal.mlkit_vision_common.zzko.createParcelable(i44, parcel, zzxq.CREATOR);
                            break;
                        default:
                            com.google.android.gms.internal.mlkit_vision_common.zzko.skipUnknownField(parcel, i44);
                            break;
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.zzko.ensureAtEnd(parcel, iValidateObjectHeader18);
                return new zzxr(strCreateString31, strCreateString32, strCreateString33, strCreateString34, strCreateString35, zzxqVar, zzxqVar2);
            case 18:
                int iValidateObjectHeader19 = com.google.android.gms.internal.mlkit_vision_common.zzko.validateObjectHeader(parcel);
                zzxw zzxwVar = null;
                String strCreateString36 = null;
                String strCreateString37 = null;
                zzxx[] zzxxVarArr = null;
                zzxu[] zzxuVarArr = null;
                String[] strArrCreateStringArray4 = null;
                zzxp[] zzxpVarArr = null;
                while (parcel.dataPosition() < iValidateObjectHeader19) {
                    int i45 = parcel.readInt();
                    switch ((char) i45) {
                        case 1:
                            zzxwVar = (zzxw) com.google.android.gms.internal.mlkit_vision_common.zzko.createParcelable(i45, parcel, zzxw.CREATOR);
                            break;
                        case 2:
                            strCreateString36 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i45);
                            break;
                        case 3:
                            strCreateString37 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i45);
                            break;
                        case 4:
                            zzxxVarArr = (zzxx[]) com.google.android.gms.internal.mlkit_vision_common.zzko.createTypedArray(i45, parcel, zzxx.CREATOR);
                            break;
                        case 5:
                            zzxuVarArr = (zzxu[]) com.google.android.gms.internal.mlkit_vision_common.zzko.createTypedArray(i45, parcel, zzxu.CREATOR);
                            break;
                        case 6:
                            strArrCreateStringArray4 = com.google.android.gms.internal.mlkit_vision_common.zzko.createStringArray(parcel, i45);
                            break;
                        case 7:
                            zzxpVarArr = (zzxp[]) com.google.android.gms.internal.mlkit_vision_common.zzko.createTypedArray(i45, parcel, zzxp.CREATOR);
                            break;
                        default:
                            com.google.android.gms.internal.mlkit_vision_common.zzko.skipUnknownField(parcel, i45);
                            break;
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.zzko.ensureAtEnd(parcel, iValidateObjectHeader19);
                return new zzxs(zzxwVar, strCreateString36, strCreateString37, zzxxVarArr, zzxuVarArr, strArrCreateStringArray4, zzxpVarArr);
            case 19:
                int iValidateObjectHeader20 = com.google.android.gms.internal.mlkit_vision_common.zzko.validateObjectHeader(parcel);
                String strCreateString38 = null;
                String strCreateString39 = null;
                String strCreateString40 = null;
                String strCreateString41 = null;
                String strCreateString42 = null;
                String strCreateString43 = null;
                String strCreateString44 = null;
                String strCreateString45 = null;
                String strCreateString46 = null;
                String strCreateString47 = null;
                String strCreateString48 = null;
                String strCreateString49 = null;
                String strCreateString50 = null;
                String strCreateString51 = null;
                while (parcel.dataPosition() < iValidateObjectHeader20) {
                    int i46 = parcel.readInt();
                    switch ((char) i46) {
                        case 1:
                            strCreateString38 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i46);
                            break;
                        case 2:
                            strCreateString39 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i46);
                            break;
                        case 3:
                            strCreateString40 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i46);
                            break;
                        case 4:
                            strCreateString41 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i46);
                            break;
                        case 5:
                            strCreateString42 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i46);
                            break;
                        case 6:
                            strCreateString43 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i46);
                            break;
                        case 7:
                            strCreateString44 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i46);
                            break;
                        case '\b':
                            strCreateString45 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i46);
                            break;
                        case '\t':
                            strCreateString46 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i46);
                            break;
                        case '\n':
                            strCreateString47 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i46);
                            break;
                        case 11:
                            strCreateString48 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i46);
                            break;
                        case '\f':
                            strCreateString49 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i46);
                            break;
                        case '\r':
                            strCreateString50 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i46);
                            break;
                        case 14:
                            strCreateString51 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i46);
                            break;
                        default:
                            com.google.android.gms.internal.mlkit_vision_common.zzko.skipUnknownField(parcel, i46);
                            break;
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.zzko.ensureAtEnd(parcel, iValidateObjectHeader20);
                return new zzxt(strCreateString38, strCreateString39, strCreateString40, strCreateString41, strCreateString42, strCreateString43, strCreateString44, strCreateString45, strCreateString46, strCreateString47, strCreateString48, strCreateString49, strCreateString50, strCreateString51);
            case 20:
                int iValidateObjectHeader21 = com.google.android.gms.internal.mlkit_vision_common.zzko.validateObjectHeader(parcel);
                String strCreateString52 = null;
                String strCreateString53 = null;
                int i47 = 0;
                String strCreateString54 = null;
                while (parcel.dataPosition() < iValidateObjectHeader21) {
                    int i48 = parcel.readInt();
                    char c11 = (char) i48;
                    if (c11 == 1) {
                        i47 = com.google.android.gms.internal.mlkit_vision_common.zzko.readInt(parcel, i48);
                    } else if (c11 == 2) {
                        strCreateString52 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i48);
                    } else if (c11 == 3) {
                        strCreateString54 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i48);
                    } else if (c11 != 4) {
                        com.google.android.gms.internal.mlkit_vision_common.zzko.skipUnknownField(parcel, i48);
                    } else {
                        strCreateString53 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i48);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.zzko.ensureAtEnd(parcel, iValidateObjectHeader21);
                return new zzxu(i47, strCreateString52, strCreateString54, strCreateString53);
            case 21:
                int iValidateObjectHeader22 = com.google.android.gms.internal.mlkit_vision_common.zzko.validateObjectHeader(parcel);
                double d4 = 0.0d;
                double d5 = 0.0d;
                while (parcel.dataPosition() < iValidateObjectHeader22) {
                    int i49 = parcel.readInt();
                    char c12 = (char) i49;
                    if (c12 == 1) {
                        d4 = com.google.android.gms.internal.mlkit_vision_common.zzko.readDouble(parcel, i49);
                    } else if (c12 != 2) {
                        com.google.android.gms.internal.mlkit_vision_common.zzko.skipUnknownField(parcel, i49);
                    } else {
                        d5 = com.google.android.gms.internal.mlkit_vision_common.zzko.readDouble(parcel, i49);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.zzko.ensureAtEnd(parcel, iValidateObjectHeader22);
                return new zzxv(d4, d5);
            case 22:
                int iValidateObjectHeader23 = com.google.android.gms.internal.mlkit_vision_common.zzko.validateObjectHeader(parcel);
                String strCreateString55 = null;
                String strCreateString56 = null;
                String strCreateString57 = null;
                String strCreateString58 = null;
                String strCreateString59 = null;
                String strCreateString60 = null;
                String strCreateString61 = null;
                while (parcel.dataPosition() < iValidateObjectHeader23) {
                    int i50 = parcel.readInt();
                    switch ((char) i50) {
                        case 1:
                            strCreateString55 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i50);
                            break;
                        case 2:
                            strCreateString56 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i50);
                            break;
                        case 3:
                            strCreateString57 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i50);
                            break;
                        case 4:
                            strCreateString58 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i50);
                            break;
                        case 5:
                            strCreateString59 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i50);
                            break;
                        case 6:
                            strCreateString60 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i50);
                            break;
                        case 7:
                            strCreateString61 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i50);
                            break;
                        default:
                            com.google.android.gms.internal.mlkit_vision_common.zzko.skipUnknownField(parcel, i50);
                            break;
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.zzko.ensureAtEnd(parcel, iValidateObjectHeader23);
                return new zzxw(strCreateString55, strCreateString56, strCreateString57, strCreateString58, strCreateString59, strCreateString60, strCreateString61);
            case 23:
                int iValidateObjectHeader24 = com.google.android.gms.internal.mlkit_vision_common.zzko.validateObjectHeader(parcel);
                String strCreateString62 = null;
                int i51 = 0;
                while (parcel.dataPosition() < iValidateObjectHeader24) {
                    int i52 = parcel.readInt();
                    char c13 = (char) i52;
                    if (c13 == 1) {
                        i51 = com.google.android.gms.internal.mlkit_vision_common.zzko.readInt(parcel, i52);
                    } else if (c13 != 2) {
                        com.google.android.gms.internal.mlkit_vision_common.zzko.skipUnknownField(parcel, i52);
                    } else {
                        strCreateString62 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i52);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.zzko.ensureAtEnd(parcel, iValidateObjectHeader24);
                return new zzxx(strCreateString62, i51);
            case 24:
                int iValidateObjectHeader25 = com.google.android.gms.internal.mlkit_vision_common.zzko.validateObjectHeader(parcel);
                String strCreateString63 = null;
                String strCreateString64 = null;
                while (parcel.dataPosition() < iValidateObjectHeader25) {
                    int i53 = parcel.readInt();
                    char c14 = (char) i53;
                    if (c14 == 1) {
                        strCreateString63 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i53);
                    } else if (c14 != 2) {
                        com.google.android.gms.internal.mlkit_vision_common.zzko.skipUnknownField(parcel, i53);
                    } else {
                        strCreateString64 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i53);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.zzko.ensureAtEnd(parcel, iValidateObjectHeader25);
                return new zzxy(strCreateString63, strCreateString64);
            case 25:
                int iValidateObjectHeader26 = com.google.android.gms.internal.mlkit_vision_common.zzko.validateObjectHeader(parcel);
                String strCreateString65 = null;
                String strCreateString66 = null;
                while (parcel.dataPosition() < iValidateObjectHeader26) {
                    int i54 = parcel.readInt();
                    char c15 = (char) i54;
                    if (c15 == 1) {
                        strCreateString65 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i54);
                    } else if (c15 != 2) {
                        com.google.android.gms.internal.mlkit_vision_common.zzko.skipUnknownField(parcel, i54);
                    } else {
                        strCreateString66 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i54);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.zzko.ensureAtEnd(parcel, iValidateObjectHeader26);
                return new zzxz(strCreateString65, strCreateString66);
            case 26:
                int iValidateObjectHeader27 = com.google.android.gms.internal.mlkit_vision_common.zzko.validateObjectHeader(parcel);
                int i55 = 0;
                String strCreateString67 = null;
                String strCreateString68 = null;
                while (parcel.dataPosition() < iValidateObjectHeader27) {
                    int i56 = parcel.readInt();
                    char c16 = (char) i56;
                    if (c16 == 1) {
                        strCreateString67 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i56);
                    } else if (c16 == 2) {
                        strCreateString68 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i56);
                    } else if (c16 != 3) {
                        com.google.android.gms.internal.mlkit_vision_common.zzko.skipUnknownField(parcel, i56);
                    } else {
                        i55 = com.google.android.gms.internal.mlkit_vision_common.zzko.readInt(parcel, i56);
                    }
                }
                com.google.android.gms.internal.mlkit_vision_common.zzko.ensureAtEnd(parcel, iValidateObjectHeader27);
                return new zzya(i55, strCreateString67, strCreateString68);
            default:
                int iValidateObjectHeader28 = com.google.android.gms.internal.mlkit_vision_common.zzko.validateObjectHeader(parcel);
                String strCreateString69 = null;
                String strCreateString70 = null;
                String strCreateString71 = null;
                String strCreateString72 = null;
                String strCreateString73 = null;
                String strCreateString74 = null;
                String strCreateString75 = null;
                String strCreateString76 = null;
                String strCreateString77 = null;
                String strCreateString78 = null;
                String strCreateString79 = null;
                String strCreateString80 = null;
                String strCreateString81 = null;
                String strCreateString82 = null;
                while (parcel.dataPosition() < iValidateObjectHeader28) {
                    int i57 = parcel.readInt();
                    String str = strCreateString81;
                    switch ((char) i57) {
                        case 2:
                            strCreateString69 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i57);
                            break;
                        case 3:
                            strCreateString70 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i57);
                            break;
                        case 4:
                            strCreateString71 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i57);
                            break;
                        case 5:
                            strCreateString72 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i57);
                            break;
                        case 6:
                            strCreateString73 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i57);
                            break;
                        case 7:
                            strCreateString74 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i57);
                            break;
                        case '\b':
                            strCreateString75 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i57);
                            break;
                        case '\t':
                            strCreateString76 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i57);
                            break;
                        case '\n':
                            strCreateString77 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i57);
                            break;
                        case 11:
                            strCreateString78 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i57);
                            break;
                        case '\f':
                            strCreateString79 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i57);
                            break;
                        case '\r':
                            strCreateString80 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i57);
                            break;
                        case 14:
                            strCreateString81 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i57);
                            continue;
                        case 15:
                            strCreateString82 = com.google.android.gms.internal.mlkit_vision_common.zzko.createString(parcel, i57);
                            break;
                        default:
                            com.google.android.gms.internal.mlkit_vision_common.zzko.skipUnknownField(parcel, i57);
                            break;
                    }
                    strCreateString81 = str;
                }
                com.google.android.gms.internal.mlkit_vision_common.zzko.ensureAtEnd(parcel, iValidateObjectHeader28);
                zzm zzmVar2 = new zzm();
                zzmVar2.zza = strCreateString69;
                zzmVar2.zzb = strCreateString70;
                zzmVar2.zzc = strCreateString71;
                zzmVar2.zzd = strCreateString72;
                zzmVar2.zze = strCreateString73;
                zzmVar2.zzf = strCreateString74;
                zzmVar2.zzg = strCreateString75;
                zzmVar2.zzh = strCreateString76;
                zzmVar2.zzi = strCreateString77;
                zzmVar2.zzj = strCreateString78;
                zzmVar2.zzk = strCreateString79;
                zzmVar2.zzl = strCreateString80;
                zzmVar2.zzm = strCreateString81;
                zzmVar2.zzn = strCreateString82;
                return zzmVar2;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        switch (this.$r8$classId) {
            case 0:
                return new zzi[i];
            case 1:
                return new zzn[i];
            case 2:
                return new zzo[i];
            case 3:
                return new zzp[i];
            case 4:
                return new zzq[i];
            case 5:
                return new zzr[i];
            case 6:
                return new zzs[i];
            case 7:
                return new zzt[i];
            case 8:
                return new zzah[i];
            case 9:
                return new zzan[i];
            case 10:
                return new zzu[i];
            case 11:
                return new zzj[i];
            case 12:
                return new zzk[i];
            case 13:
                return new zzxp[i];
            case 14:
                return new zzl[i];
            case 15:
                return new zzyb[i];
            case 16:
                return new zzxq[i];
            case 17:
                return new zzxr[i];
            case 18:
                return new zzxs[i];
            case 19:
                return new zzxt[i];
            case 20:
                return new zzxu[i];
            case 21:
                return new zzxv[i];
            case 22:
                return new zzxw[i];
            case 23:
                return new zzxx[i];
            case 24:
                return new zzxy[i];
            case 25:
                return new zzxz[i];
            case 26:
                return new zzya[i];
            default:
                return new zzm[i];
        }
    }
}
