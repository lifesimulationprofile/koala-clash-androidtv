package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.unit.Density;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.io.FileSystemException;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzfp implements zzge {
    public static final int[] zza = new int[0];
    public static final Unsafe zzb = zzgz.zzg();
    public final int[] zzc;
    public final Object[] zzd;
    public final int zze;
    public final int zzf;
    public final zzcq zzg;
    public final boolean zzh;
    public final int[] zzi;
    public final int zzj;
    public final int zzk;
    public final zzea zzl;
    public final zzea zzm;

    public zzfp(int[] iArr, Object[] objArr, int i, int i2, zzcq zzcqVar, int[] iArr2, int i3, int i4, zzea zzeaVar, zzea zzeaVar2) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        boolean z = false;
        if (zzeaVar2 != null && (zzcqVar instanceof zzed)) {
            z = true;
        }
        this.zzh = z;
        this.zzi = iArr2;
        this.zzj = i3;
        this.zzk = i4;
        this.zzl = zzeaVar;
        this.zzm = zzeaVar2;
        this.zzg = zzcqVar;
    }

    public static boolean zzL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzeh) {
            return ((zzeh) obj).zzY();
        }
        return true;
    }

    public static zzgt zzd(Object obj) {
        zzeh zzehVar = (zzeh) obj;
        zzgt zzgtVar = zzehVar.zzc;
        if (zzgtVar != zzgt.zza) {
            return zzgtVar;
        }
        zzgt zzgtVarZzf = zzgt.zzf();
        zzehVar.zzc = zzgtVarZzf;
        return zzgtVarZzf;
    }

    /* JADX WARN: Code duplicated, block: B:125:0x0274  */
    /* JADX WARN: Code duplicated, block: B:126:0x0277  */
    /* JADX WARN: Code duplicated, block: B:129:0x0290  */
    /* JADX WARN: Code duplicated, block: B:130:0x0293  */
    /* JADX WARN: Code duplicated, block: B:171:0x035d  */
    /* JADX WARN: Code duplicated, block: B:186:0x03ab  */
    /* JADX WARN: Code duplicated, block: B:189:0x03b5  */
    public static zzfp zzl(zzfw zzfwVar, zzea zzeaVar, zzea zzeaVar2) {
        int i;
        int iCharAt;
        int i2;
        int[] iArr;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        char cCharAt;
        int i9;
        char cCharAt2;
        int i10;
        char cCharAt3;
        int i11;
        char cCharAt4;
        int i12;
        char cCharAt5;
        int i13;
        char cCharAt6;
        int i14;
        char cCharAt7;
        int i15;
        char cCharAt8;
        int i16;
        int i17;
        Object[] objArr;
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        Field fieldZzz;
        char cCharAt9;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        Object obj;
        Field fieldZzz2;
        int i28;
        Object obj2;
        Field fieldZzz3;
        int i29;
        char cCharAt10;
        int i30;
        char cCharAt11;
        int i31;
        char cCharAt12;
        int i32;
        char cCharAt13;
        if (!(zzfwVar instanceof zzfw)) {
            zzfwVar.getClass();
            throw new ClassCastException();
        }
        String str = zzfwVar.zzb;
        int length = str.length();
        int i33 = 55296;
        if (str.charAt(0) >= 55296) {
            int i34 = 1;
            while (true) {
                i = i34 + 1;
                if (str.charAt(i34) < 55296) {
                    break;
                }
                i34 = i;
            }
        } else {
            i = 1;
        }
        int i35 = i + 1;
        int iCharAt2 = str.charAt(i);
        if (iCharAt2 >= 55296) {
            int i36 = iCharAt2 & 8191;
            int i37 = 13;
            while (true) {
                i32 = i35 + 1;
                cCharAt13 = str.charAt(i35);
                if (cCharAt13 < 55296) {
                    break;
                }
                i36 |= (cCharAt13 & 8191) << i37;
                i37 += 13;
                i35 = i32;
            }
            iCharAt2 = i36 | (cCharAt13 << i37);
            i35 = i32;
        }
        if (iCharAt2 == 0) {
            i4 = 0;
            i6 = 0;
            iCharAt = 0;
            i3 = 0;
            i5 = 0;
            i7 = 0;
            iArr = zza;
            i2 = 0;
        } else {
            int i38 = i35 + 1;
            int iCharAt3 = str.charAt(i35);
            if (iCharAt3 >= 55296) {
                int i39 = iCharAt3 & 8191;
                int i40 = 13;
                while (true) {
                    i15 = i38 + 1;
                    cCharAt8 = str.charAt(i38);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i39 |= (cCharAt8 & 8191) << i40;
                    i40 += 13;
                    i38 = i15;
                }
                iCharAt3 = i39 | (cCharAt8 << i40);
                i38 = i15;
            }
            int i41 = i38 + 1;
            int iCharAt4 = str.charAt(i38);
            if (iCharAt4 >= 55296) {
                int i42 = iCharAt4 & 8191;
                int i43 = 13;
                while (true) {
                    i14 = i41 + 1;
                    cCharAt7 = str.charAt(i41);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i42 |= (cCharAt7 & 8191) << i43;
                    i43 += 13;
                    i41 = i14;
                }
                iCharAt4 = i42 | (cCharAt7 << i43);
                i41 = i14;
            }
            int i44 = i41 + 1;
            int iCharAt5 = str.charAt(i41);
            if (iCharAt5 >= 55296) {
                int i45 = iCharAt5 & 8191;
                int i46 = 13;
                while (true) {
                    i13 = i44 + 1;
                    cCharAt6 = str.charAt(i44);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i45 |= (cCharAt6 & 8191) << i46;
                    i46 += 13;
                    i44 = i13;
                }
                iCharAt5 = i45 | (cCharAt6 << i46);
                i44 = i13;
            }
            int i47 = i44 + 1;
            int iCharAt6 = str.charAt(i44);
            if (iCharAt6 >= 55296) {
                int i48 = iCharAt6 & 8191;
                int i49 = 13;
                while (true) {
                    i12 = i47 + 1;
                    cCharAt5 = str.charAt(i47);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i48 |= (cCharAt5 & 8191) << i49;
                    i49 += 13;
                    i47 = i12;
                }
                iCharAt6 = i48 | (cCharAt5 << i49);
                i47 = i12;
            }
            int i50 = i47 + 1;
            iCharAt = str.charAt(i47);
            if (iCharAt >= 55296) {
                int i51 = iCharAt & 8191;
                int i52 = 13;
                while (true) {
                    i11 = i50 + 1;
                    cCharAt4 = str.charAt(i50);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i51 |= (cCharAt4 & 8191) << i52;
                    i52 += 13;
                    i50 = i11;
                }
                iCharAt = i51 | (cCharAt4 << i52);
                i50 = i11;
            }
            int i53 = i50 + 1;
            int iCharAt7 = str.charAt(i50);
            if (iCharAt7 >= 55296) {
                int i54 = iCharAt7 & 8191;
                int i55 = 13;
                while (true) {
                    i10 = i53 + 1;
                    cCharAt3 = str.charAt(i53);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i54 |= (cCharAt3 & 8191) << i55;
                    i55 += 13;
                    i53 = i10;
                }
                iCharAt7 = i54 | (cCharAt3 << i55);
                i53 = i10;
            }
            int i56 = i53 + 1;
            int iCharAt8 = str.charAt(i53);
            if (iCharAt8 >= 55296) {
                int i57 = iCharAt8 & 8191;
                int i58 = 13;
                while (true) {
                    i9 = i56 + 1;
                    cCharAt2 = str.charAt(i56);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i57 |= (cCharAt2 & 8191) << i58;
                    i58 += 13;
                    i56 = i9;
                }
                iCharAt8 = i57 | (cCharAt2 << i58);
                i56 = i9;
            }
            int i59 = i56 + 1;
            int iCharAt9 = str.charAt(i56);
            if (iCharAt9 >= 55296) {
                int i60 = iCharAt9 & 8191;
                int i61 = 13;
                while (true) {
                    i8 = i59 + 1;
                    cCharAt = str.charAt(i59);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i60 |= (cCharAt & 8191) << i61;
                    i61 += 13;
                    i59 = i8;
                }
                iCharAt9 = i60 | (cCharAt << i61);
                i59 = i8;
            }
            int i62 = iCharAt3 + iCharAt3 + iCharAt4;
            i2 = iCharAt3;
            i35 = i59;
            iArr = new int[iCharAt9 + iCharAt7 + iCharAt8];
            int i63 = iCharAt7;
            i3 = iCharAt5;
            i4 = i63;
            i5 = iCharAt6;
            i6 = i62;
            i7 = iCharAt9;
        }
        Unsafe unsafe = zzb;
        Object[] objArr2 = zzfwVar.zzc;
        Class<?> cls = zzfwVar.zza.getClass();
        int i64 = i7 + i4;
        int i65 = iCharAt + iCharAt;
        int[] iArr2 = new int[iCharAt * 3];
        Object[] objArr3 = new Object[i65];
        int i66 = i64;
        int i67 = i7;
        int i68 = 0;
        int i69 = 0;
        while (i35 < length) {
            int i70 = i35 + 1;
            int iCharAt10 = str.charAt(i35);
            if (iCharAt10 >= i33) {
                int i71 = iCharAt10 & 8191;
                int i72 = i70;
                int i73 = 13;
                while (true) {
                    i31 = i72 + 1;
                    cCharAt12 = str.charAt(i72);
                    i16 = length;
                    if (cCharAt12 < 55296) {
                        break;
                    }
                    i71 |= (cCharAt12 & 8191) << i73;
                    i73 += 13;
                    i72 = i31;
                    length = i16;
                }
                iCharAt10 = i71 | (cCharAt12 << i73);
                i17 = i31;
            } else {
                i16 = length;
                i17 = i70;
            }
            int i74 = i17 + 1;
            int iCharAt11 = str.charAt(i17);
            Object[] objArr4 = objArr2;
            char c = 55296;
            if (iCharAt11 >= 55296) {
                int i75 = iCharAt11 & 8191;
                int i76 = 13;
                while (true) {
                    i30 = i74 + 1;
                    cCharAt11 = str.charAt(i74);
                    if (cCharAt11 < c) {
                        break;
                    }
                    i75 |= (cCharAt11 & 8191) << i76;
                    i76 += 13;
                    i74 = i30;
                    c = 55296;
                }
                iCharAt11 = i75 | (cCharAt11 << i76);
                i74 = i30;
            }
            if ((iCharAt11 & 1024) != 0) {
                iArr[i68] = i69;
                i68++;
            }
            int i77 = iCharAt11 & 255;
            int i78 = iCharAt10;
            int i79 = iCharAt11 & 2048;
            if (i77 >= 51) {
                int i80 = i74 + 1;
                int iCharAt12 = str.charAt(i74);
                char c2 = 55296;
                if (iCharAt12 >= 55296) {
                    int i81 = iCharAt12 & 8191;
                    int i82 = i80;
                    int i83 = 13;
                    while (true) {
                        i29 = i82 + 1;
                        cCharAt10 = str.charAt(i82);
                        if (cCharAt10 < c2) {
                            break;
                        }
                        i81 |= (cCharAt10 & 8191) << i83;
                        i83 += 13;
                        i82 = i29;
                        c2 = 55296;
                    }
                    iCharAt12 = i81 | (cCharAt10 << i83);
                    i24 = i29;
                } else {
                    i24 = i80;
                }
                int i84 = i24;
                int i85 = i77 - 51;
                int i86 = iCharAt12;
                if (i85 == 9 || i85 == 17) {
                    i25 = i6 + 1;
                    int i87 = i69 / 3;
                    objArr3[i87 + i87 + 1] = objArr4[i6];
                } else {
                    if (i85 != 12) {
                        i26 = i79;
                    } else if (zzfwVar.zzc() == 1 || i79 != 0) {
                        i25 = i6 + 1;
                        int i88 = i69 / 3;
                        objArr3[i88 + i88 + 1] = objArr4[i6];
                    } else {
                        i26 = 0;
                    }
                    i27 = i86 + i86;
                    i79 = i26;
                    obj = objArr4[i27];
                    if (obj instanceof Field) {
                        fieldZzz2 = (Field) obj;
                    } else {
                        fieldZzz2 = zzz(cls, (String) obj);
                        objArr4[i27] = fieldZzz2;
                    }
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzz2);
                    i28 = i27 + 1;
                    obj2 = objArr4[i28];
                    if (obj2 instanceof Field) {
                        fieldZzz3 = (Field) obj2;
                    } else {
                        fieldZzz3 = zzz(cls, (String) obj2);
                        objArr4[i28] = fieldZzz3;
                    }
                    i19 = i84;
                    i22 = iObjectFieldOffset3;
                    i18 = 55296;
                    objArr = objArr3;
                    i2 = i2;
                    cls = cls;
                    i21 = 0;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzz3);
                }
                i6 = i25;
                i26 = i79;
                i27 = i86 + i86;
                i79 = i26;
                obj = objArr4[i27];
                if (obj instanceof Field) {
                    fieldZzz2 = (Field) obj;
                } else {
                    fieldZzz2 = zzz(cls, (String) obj);
                    objArr4[i27] = fieldZzz2;
                }
                int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldZzz2);
                i28 = i27 + 1;
                obj2 = objArr4[i28];
                if (obj2 instanceof Field) {
                    fieldZzz3 = (Field) obj2;
                } else {
                    fieldZzz3 = zzz(cls, (String) obj2);
                    objArr4[i28] = fieldZzz3;
                }
                i19 = i84;
                i22 = iObjectFieldOffset4;
                i18 = 55296;
                objArr = objArr3;
                i2 = i2;
                cls = cls;
                i21 = 0;
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzz3);
            } else {
                int i89 = i6 + 1;
                Field fieldZzz4 = zzz(cls, (String) objArr4[i6]);
                objArr = objArr3;
                if (i77 == 9 || i77 == 17) {
                    int i90 = i69 / 3;
                    objArr[i90 + i90 + 1] = fieldZzz4.getType();
                } else {
                    if (i77 != 27) {
                        if (i77 == 49) {
                            i6 += 2;
                            i23 = 1;
                        } else if (i77 == 12 || i77 == 30 || i77 == 44) {
                            i2 = i2;
                            if (zzfwVar.zzc() == 1 || i79 != 0) {
                                i6 += 2;
                                int i91 = i69 / 3;
                                objArr[i91 + i91 + 1] = objArr4[i89];
                                cls = cls;
                            } else {
                                cls = cls;
                                i6 = i89;
                                i79 = 0;
                            }
                        } else if (i77 == 50) {
                            int i92 = i6 + 2;
                            i67++;
                            iArr[i67] = i69;
                            int i93 = i69 / 3;
                            int i94 = i93 + i93;
                            objArr[i94] = objArr4[i89];
                            if (i79 != 0) {
                                i6 += 3;
                                objArr[i94 + 1] = objArr4[i92];
                            } else {
                                i6 = i92;
                                i79 = 0;
                            }
                            i2 = i2;
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzz4);
                        iObjectFieldOffset2 = 1048575;
                        if ((iCharAt11 & 4096) != 0 || i77 > 17) {
                            i18 = 55296;
                            i19 = i74;
                            i20 = 0;
                        } else {
                            int i95 = i74 + 1;
                            int iCharAt13 = str.charAt(i74);
                            if (iCharAt13 >= 55296) {
                                int i96 = iCharAt13 & 8191;
                                int i97 = 13;
                                while (true) {
                                    i19 = i95 + 1;
                                    cCharAt9 = str.charAt(i95);
                                    if (cCharAt9 < 55296) {
                                        break;
                                    }
                                    i96 |= (cCharAt9 & 8191) << i97;
                                    i97 += 13;
                                    i95 = i19;
                                }
                                iCharAt13 = i96 | (cCharAt9 << i97);
                            } else {
                                i19 = i95;
                            }
                            int i98 = (iCharAt13 / 32) + i2 + i2;
                            Object obj3 = objArr4[i98];
                            if (obj3 instanceof Field) {
                                fieldZzz = (Field) obj3;
                            } else {
                                fieldZzz = zzz(cls, (String) obj3);
                                objArr4[i98] = fieldZzz;
                            }
                            i20 = iCharAt13 % 32;
                            iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzz);
                            i18 = 55296;
                        }
                        if (i77 >= 18 && i77 <= 49) {
                            iArr[i66] = iObjectFieldOffset;
                            i66++;
                        }
                        i21 = i20;
                        i22 = iObjectFieldOffset;
                    } else {
                        i23 = 1;
                        i6 += 2;
                    }
                    int i99 = i69 / 3;
                    objArr[i99 + i99 + i23] = objArr4[i89];
                    cls = cls;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzz4);
                    iObjectFieldOffset2 = 1048575;
                    if ((iCharAt11 & 4096) != 0) {
                        i18 = 55296;
                        i19 = i74;
                        i20 = 0;
                    } else {
                        i18 = 55296;
                        i19 = i74;
                        i20 = 0;
                    }
                    if (i77 >= 18) {
                        iArr[i66] = iObjectFieldOffset;
                        i66++;
                    }
                    i21 = i20;
                    i22 = iObjectFieldOffset;
                }
                cls = cls;
                i6 = i89;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzz4);
                iObjectFieldOffset2 = 1048575;
                if ((iCharAt11 & 4096) != 0) {
                    i18 = 55296;
                    i19 = i74;
                    i20 = 0;
                } else {
                    i18 = 55296;
                    i19 = i74;
                    i20 = 0;
                }
                if (i77 >= 18) {
                    iArr[i66] = iObjectFieldOffset;
                    i66++;
                }
                i21 = i20;
                i22 = iObjectFieldOffset;
            }
            int i100 = i79;
            int i101 = i69 + 1;
            iArr2[i69] = i78;
            int i102 = i69 + 2;
            String str2 = str;
            iArr2[i101] = ((iCharAt11 & 512) != 0 ? 536870912 : 0) | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | (i100 != 0 ? Integer.MIN_VALUE : 0) | (i77 << 20) | i22;
            i69 += 3;
            iArr2[i102] = (i21 << 20) | iObjectFieldOffset2;
            cls = cls;
            objArr2 = objArr4;
            i33 = i18;
            length = i16;
            objArr3 = objArr;
            i2 = i2;
            i35 = i19;
            str = str2;
        }
        return new zzfp(iArr2, objArr3, i3, i5, zzfwVar.zza, iArr, i7, i64, zzeaVar, zzeaVar2);
    }

    public static int zzo(long j, Object obj) {
        return ((Integer) zzgz.zzf(j, obj)).intValue();
    }

    public static int zzr(int i) {
        return (i >>> 20) & 255;
    }

    public static long zzt(long j, Object obj) {
        return ((Long) zzgz.zzf(j, obj)).longValue();
    }

    public static Field zzz(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String string = Arrays.toString(declaredFields);
            StringBuilder sbM = CaptureSession$State$EnumUnboxingLocalUtility.m("Field ", str, " for ", name, " not found. Known fields are ");
            sbM.append(string);
            throw new RuntimeException(sbM.toString());
        }
    }

    public final void zzB(int i, Object obj, Object obj2) {
        if (zzI(i, obj2)) {
            int iZzs = zzs(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzge zzgeVarZzv = zzv(i);
            if (!zzI(i, obj)) {
                if (zzL(object)) {
                    Object objZze = zzgeVarZzv.zze();
                    zzgeVarZzv.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzD(i, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object objZze2 = zzgeVarZzv.zze();
                zzgeVarZzv.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzgeVarZzv.zzg(object2, object);
        }
    }

    public final void zzC(int i, Object obj, Object obj2) {
        int[] iArr = this.zzc;
        int i2 = iArr[i];
        if (zzM(i2, i, obj2)) {
            int iZzs = zzs(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + iArr[i] + " is present but null: " + obj2.toString());
            }
            zzge zzgeVarZzv = zzv(i);
            if (!zzM(i2, i, obj)) {
                if (zzL(object)) {
                    Object objZze = zzgeVarZzv.zze();
                    zzgeVarZzv.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzgz.zzq(obj, iArr[i + 2] & 1048575, i2);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object objZze2 = zzgeVarZzv.zze();
                zzgeVarZzv.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzgeVarZzv.zzg(object2, object);
        }
    }

    public final void zzD(int i, Object obj) {
        int i2 = this.zzc[i + 2];
        long j = 1048575 & i2;
        if (j == 1048575) {
            return;
        }
        zzgz.zzq(obj, j, (1 << (i2 >>> 20)) | zzgz.zzc(j, obj));
    }

    public final void zzF(int i, Object obj, Object obj2) {
        zzb.putObject(obj, zzs(i) & 1048575, obj2);
        zzD(i, obj);
    }

    public final void zzG(int i, int i2, Object obj, Object obj2) {
        zzb.putObject(obj, zzs(i2) & 1048575, obj2);
        zzgz.zzq(obj, this.zzc[i2 + 2] & 1048575, i);
    }

    public final boolean zzH(zzeh zzehVar, zzeh zzehVar2, int i) {
        return zzI(i, zzehVar) == zzI(i, zzehVar2);
    }

    public final boolean zzI(int i, Object obj) {
        int i2 = this.zzc[i + 2];
        long j = i2 & 1048575;
        if (j == 1048575) {
            int iZzs = zzs(i);
            long j2 = iZzs & 1048575;
            switch (zzr(iZzs)) {
                case 0:
                    if (Double.doubleToRawLongBits(zzgz.zzf.zza(j2, obj)) == 0) {
                        return false;
                    }
                    break;
                case 1:
                    if (Float.floatToRawIntBits(zzgz.zzf.zzb(j2, obj)) == 0) {
                        return false;
                    }
                    break;
                case 2:
                    if (zzgz.zzd(j2, obj) == 0) {
                        return false;
                    }
                    break;
                case 3:
                    if (zzgz.zzd(j2, obj) == 0) {
                        return false;
                    }
                    break;
                case 4:
                    if (zzgz.zzc(j2, obj) == 0) {
                        return false;
                    }
                    break;
                case 5:
                    if (zzgz.zzd(j2, obj) == 0) {
                        return false;
                    }
                    break;
                case 6:
                    if (zzgz.zzc(j2, obj) == 0) {
                        return false;
                    }
                    break;
                case 7:
                    return zzgz.zzf.zzg(j2, obj);
                case 8:
                    Object objZzf = zzgz.zzf(j2, obj);
                    if (objZzf instanceof String) {
                        if (((String) objZzf).isEmpty()) {
                            return false;
                        }
                    } else {
                        if (!(objZzf instanceof zzdf)) {
                            throw new IllegalArgumentException();
                        }
                        if (zzdf.zzb.equals(objZzf)) {
                            return false;
                        }
                    }
                case 9:
                    if (zzgz.zzf(j2, obj) == null) {
                        return false;
                    }
                    break;
                case 10:
                    if (zzdf.zzb.equals(zzgz.zzf(j2, obj))) {
                        return false;
                    }
                    break;
                case 11:
                    if (zzgz.zzc(j2, obj) == 0) {
                        return false;
                    }
                    break;
                case 12:
                    if (zzgz.zzc(j2, obj) == 0) {
                        return false;
                    }
                    break;
                case 13:
                    if (zzgz.zzc(j2, obj) == 0) {
                        return false;
                    }
                    break;
                case 14:
                    if (zzgz.zzd(j2, obj) == 0) {
                        return false;
                    }
                    break;
                case 15:
                    if (zzgz.zzc(j2, obj) == 0) {
                        return false;
                    }
                    break;
                case 16:
                    if (zzgz.zzd(j2, obj) == 0) {
                        return false;
                    }
                    break;
                case 17:
                    if (zzgz.zzf(j2, obj) == null) {
                        return false;
                    }
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } else if (((1 << (i2 >>> 20)) & zzgz.zzc(j, obj)) == 0) {
            return false;
        }
        return true;
    }

    public final boolean zzJ(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzI(i, obj);
        }
        return (i3 & i4) != 0;
    }

    public final boolean zzM(int i, int i2, Object obj) {
        return zzgz.zzc((long) (this.zzc[i2 + 2] & 1048575), obj) == i;
    }

    /* JADX WARN: Code duplicated, block: B:142:0x03bf  */
    /* JADX WARN: Code duplicated, block: B:186:0x04dd  */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final int zza(zzcq zzcqVar) {
        int i;
        int iZzA;
        int iZzB;
        int i2;
        int iZzB2;
        int iZzd;
        int iZzA2;
        int size;
        int iZzl;
        int iZzA3;
        int iZzA4;
        int iZzA5;
        int iZzB3;
        int iZzA6;
        int iZzB4;
        zzfp zzfpVar = this;
        Unsafe unsafe = zzb;
        int i3 = 1048575;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        int iM = 0;
        while (true) {
            int[] iArr = zzfpVar.zzc;
            if (i5 >= iArr.length) {
                int iZza = ((zzeh) zzcqVar).zzc.zza() + iM;
                if (!zzfpVar.zzh) {
                    return iZza;
                }
                zzgh zzghVar = ((zzed) zzcqVar).zzb.zza;
                int i7 = zzghVar.zzb;
                int iZza2 = 0;
                for (int i8 = 0; i8 < i7; i8++) {
                    zzgi zzgiVarZzg = zzghVar.zzg(i8);
                    iZza2 = zzdx.zza((zzee) zzgiVarZzg.zzb, zzgiVarZzg.zzc) + iZza2;
                }
                for (Map.Entry entry : zzghVar.zzd()) {
                    iZza2 = zzdx.zza((zzee) entry.getKey(), entry.getValue()) + iZza2;
                }
                return iZza + iZza2;
            }
            int iZzs = zzfpVar.zzs(i5);
            int iZzr = zzr(iZzs);
            int i9 = iArr[i5];
            int i10 = iArr[i5 + 2];
            int i11 = i10 & i3;
            if (iZzr <= 17) {
                if (i11 != i4) {
                    i6 = i11 == i3 ? 0 : unsafe.getInt(zzcqVar, i11);
                    i4 = i11;
                }
                i = 1 << (i10 >>> 20);
            } else {
                i = 0;
            }
            int i12 = iZzs & i3;
            if (iZzr >= zzdy.zzJ.zzab) {
                zzdy.zzW.getClass();
            }
            long j = i12;
            switch (iZzr) {
                case 0:
                    if (zzfpVar.zzJ(zzcqVar, i5, i4, i6, i)) {
                        iM = Density.CC.m(i9 << 3, 8, iM);
                    }
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 1:
                    if (zzfpVar.zzJ(zzcqVar, i5, i4, i6, i)) {
                        iM = Density.CC.m(i9 << 3, 4, iM);
                    }
                    zzfpVar = this;
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 2:
                    if (zzfpVar.zzJ(zzcqVar, i5, i4, i6, i)) {
                        long j2 = unsafe.getLong(zzcqVar, j);
                        iZzA = zzdk.zzA(i9 << 3);
                        iZzB = zzdk.zzB(j2);
                        iM += iZzB + iZzA;
                    }
                    zzfpVar = this;
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 3:
                    if (zzfpVar.zzJ(zzcqVar, i5, i4, i6, i)) {
                        long j3 = unsafe.getLong(zzcqVar, j);
                        iZzA = zzdk.zzA(i9 << 3);
                        iZzB = zzdk.zzB(j3);
                        iM += iZzB + iZzA;
                    }
                    zzfpVar = this;
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 4:
                    if (zzfpVar.zzJ(zzcqVar, i5, i4, i6, i)) {
                        long j4 = unsafe.getInt(zzcqVar, j);
                        iZzA = zzdk.zzA(i9 << 3);
                        iZzB = zzdk.zzB(j4);
                        iM += iZzB + iZzA;
                    }
                    zzfpVar = this;
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 5:
                    if (zzfpVar.zzJ(zzcqVar, i5, i4, i6, i)) {
                        iM = Density.CC.m(i9 << 3, 8, iM);
                    }
                    zzfpVar = this;
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 6:
                    if (zzfpVar.zzJ(zzcqVar, i5, i4, i6, i)) {
                        iM = Density.CC.m(i9 << 3, 4, iM);
                    }
                    zzfpVar = this;
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 7:
                    if (zzfpVar.zzJ(zzcqVar, i5, i4, i6, i)) {
                        iM = Density.CC.m(i9 << 3, 1, iM);
                    }
                    zzfpVar = this;
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 8:
                    if (zzfpVar.zzJ(zzcqVar, i5, i4, i6, i)) {
                        int i13 = i9 << 3;
                        Object object = unsafe.getObject(zzcqVar, j);
                        if (object instanceof zzdf) {
                            int iZzA7 = zzdk.zzA(i13);
                            int iZzd2 = ((zzdf) object).zzd();
                            iM = Density.CC.m(iZzd2, iZzd2, iZzA7, iM);
                        } else {
                            iZzA = zzdk.zzA(i13);
                            iZzB = zzdk.zzz((String) object);
                            iM += iZzB + iZzA;
                        }
                    }
                    zzfpVar = this;
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 9:
                    if (zzfpVar.zzJ(zzcqVar, i5, i4, i6, i)) {
                        Object object2 = unsafe.getObject(zzcqVar, j);
                        zzge zzgeVarZzv = zzfpVar.zzv(i5);
                        zzea zzeaVar = zzgg.zzb;
                        int iZzA8 = zzdk.zzA(i9 << 3);
                        int iZzB5 = ((zzcq) object2).zzB(zzgeVarZzv);
                        iM = Density.CC.m(iZzB5, iZzB5, iZzA8, iM);
                    }
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 10:
                    if (zzfpVar.zzJ(zzcqVar, i5, i4, i6, i)) {
                        zzdf zzdfVar = (zzdf) unsafe.getObject(zzcqVar, j);
                        int iZzA9 = zzdk.zzA(i9 << 3);
                        int iZzd3 = zzdfVar.zzd();
                        iM = Density.CC.m(iZzd3, iZzd3, iZzA9, iM);
                    }
                    zzfpVar = this;
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 11:
                    if (zzfpVar.zzJ(zzcqVar, i5, i4, i6, i)) {
                        iM = Density.CC.m(unsafe.getInt(zzcqVar, j), zzdk.zzA(i9 << 3), iM);
                    }
                    zzfpVar = this;
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 12:
                    if (zzfpVar.zzJ(zzcqVar, i5, i4, i6, i)) {
                        long j5 = unsafe.getInt(zzcqVar, j);
                        iZzA = zzdk.zzA(i9 << 3);
                        iZzB = zzdk.zzB(j5);
                        iM += iZzB + iZzA;
                    }
                    zzfpVar = this;
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 13:
                    if (zzfpVar.zzJ(zzcqVar, i5, i4, i6, i)) {
                        iM = Density.CC.m(i9 << 3, 4, iM);
                    }
                    zzfpVar = this;
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 14:
                    if (zzfpVar.zzJ(zzcqVar, i5, i4, i6, i)) {
                        iM = Density.CC.m(i9 << 3, 8, iM);
                    }
                    zzfpVar = this;
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 15:
                    if (zzfpVar.zzJ(zzcqVar, i5, i4, i6, i)) {
                        int i14 = unsafe.getInt(zzcqVar, j);
                        iM = Density.CC.m((i14 >> 31) ^ (i14 + i14), zzdk.zzA(i9 << 3), iM);
                    }
                    zzfpVar = this;
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 16:
                    if (zzfpVar.zzJ(zzcqVar, i5, i4, i6, i)) {
                        long j6 = unsafe.getLong(zzcqVar, j);
                        iZzA = zzdk.zzA(i9 << 3);
                        iZzB = zzdk.zzB((j6 >> 63) ^ (j6 + j6));
                        iM += iZzB + iZzA;
                    }
                    zzfpVar = this;
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 17:
                    if (zzfpVar.zzJ(zzcqVar, i5, i4, i6, i)) {
                        zzcq zzcqVar2 = (zzcq) unsafe.getObject(zzcqVar, j);
                        zzge zzgeVarZzv2 = zzfpVar.zzv(i5);
                        int iZzA10 = zzdk.zzA(i9 << 3);
                        i2 = iZzA10 + iZzA10;
                        iZzB2 = zzcqVar2.zzB(zzgeVarZzv2);
                        iZzd = iZzB2 + i2;
                        iM += iZzd;
                    }
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 18:
                    iZzd = zzgg.zzd(i9, (List) unsafe.getObject(zzcqVar, j));
                    iM += iZzd;
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 19:
                    iZzd = zzgg.zzb(i9, (List) unsafe.getObject(zzcqVar, j));
                    iM += iZzd;
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(zzcqVar, j);
                    zzea zzeaVar2 = zzgg.zzb;
                    if (list.size() == 0) {
                        iZzA2 = 0;
                    } else {
                        iZzA2 = (zzdk.zzA(i9 << 3) * list.size()) + zzgg.zzg(list);
                    }
                    iM += iZzA2;
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 21:
                    List list2 = (List) unsafe.getObject(zzcqVar, j);
                    zzea zzeaVar3 = zzgg.zzb;
                    size = list2.size();
                    if (size == 0) {
                        iZzA4 = 0;
                    } else {
                        iZzl = zzgg.zzl(list2);
                        iZzA3 = zzdk.zzA(i9 << 3);
                        iZzA4 = (iZzA3 * size) + iZzl;
                    }
                    iM += iZzA4;
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 22:
                    List list3 = (List) unsafe.getObject(zzcqVar, j);
                    zzea zzeaVar4 = zzgg.zzb;
                    size = list3.size();
                    if (size == 0) {
                        iZzA4 = 0;
                    } else {
                        iZzl = zzgg.zzf(list3);
                        iZzA3 = zzdk.zzA(i9 << 3);
                        iZzA4 = (iZzA3 * size) + iZzl;
                    }
                    iM += iZzA4;
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 23:
                    iZzd = zzgg.zzd(i9, (List) unsafe.getObject(zzcqVar, j));
                    iM += iZzd;
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 24:
                    iZzd = zzgg.zzb(i9, (List) unsafe.getObject(zzcqVar, j));
                    iM += iZzd;
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 25:
                    List list4 = (List) unsafe.getObject(zzcqVar, j);
                    zzea zzeaVar5 = zzgg.zzb;
                    int size2 = list4.size();
                    if (size2 == 0) {
                        iZzA2 = 0;
                    } else {
                        iZzA2 = (zzdk.zzA(i9 << 3) + 1) * size2;
                    }
                    iM += iZzA2;
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 26:
                    List list5 = (List) unsafe.getObject(zzcqVar, j);
                    zzea zzeaVar6 = zzgg.zzb;
                    int size3 = list5.size();
                    if (size3 == 0) {
                        iZzA4 = 0;
                    } else {
                        iZzA4 = zzdk.zzA(i9 << 3) * size3;
                        for (int i15 = 0; i15 < size3; i15++) {
                            Object obj = list5.get(i15);
                            if (obj instanceof zzdf) {
                                int iZzd4 = ((zzdf) obj).zzd();
                                iZzA4 = Density.CC.m(iZzd4, iZzd4, iZzA4);
                            } else {
                                iZzA4 = zzdk.zzz((String) obj) + iZzA4;
                            }
                        }
                    }
                    iM += iZzA4;
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 27:
                    List list6 = (List) unsafe.getObject(zzcqVar, j);
                    zzge zzgeVarZzv3 = zzfpVar.zzv(i5);
                    zzea zzeaVar7 = zzgg.zzb;
                    int size4 = list6.size();
                    if (size4 == 0) {
                        iZzA5 = 0;
                    } else {
                        iZzA5 = zzdk.zzA(i9 << 3) * size4;
                        for (int i16 = 0; i16 < size4; i16++) {
                            int iZzB6 = ((zzcq) list6.get(i16)).zzB(zzgeVarZzv3);
                            iZzA5 = Density.CC.m(iZzB6, iZzB6, iZzA5);
                        }
                    }
                    iM += iZzA5;
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 28:
                    List list7 = (List) unsafe.getObject(zzcqVar, j);
                    zzea zzeaVar8 = zzgg.zzb;
                    int size5 = list7.size();
                    if (size5 == 0) {
                        iZzA4 = 0;
                    } else {
                        iZzA4 = zzdk.zzA(i9 << 3) * size5;
                        for (int i17 = 0; i17 < list7.size(); i17++) {
                            int iZzd5 = ((zzdf) list7.get(i17)).zzd();
                            iZzA4 = Density.CC.m(iZzd5, iZzd5, iZzA4);
                        }
                    }
                    iM += iZzA4;
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 29:
                    List list8 = (List) unsafe.getObject(zzcqVar, j);
                    zzea zzeaVar9 = zzgg.zzb;
                    size = list8.size();
                    if (size == 0) {
                        iZzA4 = 0;
                    } else {
                        iZzl = zzgg.zzk(list8);
                        iZzA3 = zzdk.zzA(i9 << 3);
                        iZzA4 = (iZzA3 * size) + iZzl;
                    }
                    iM += iZzA4;
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 30:
                    List list9 = (List) unsafe.getObject(zzcqVar, j);
                    zzea zzeaVar10 = zzgg.zzb;
                    size = list9.size();
                    if (size == 0) {
                        iZzA4 = 0;
                    } else {
                        iZzl = zzgg.zza(list9);
                        iZzA3 = zzdk.zzA(i9 << 3);
                        iZzA4 = (iZzA3 * size) + iZzl;
                    }
                    iM += iZzA4;
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 31:
                    iZzd = zzgg.zzb(i9, (List) unsafe.getObject(zzcqVar, j));
                    iM += iZzd;
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 32:
                    iZzd = zzgg.zzd(i9, (List) unsafe.getObject(zzcqVar, j));
                    iM += iZzd;
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 33:
                    List list10 = (List) unsafe.getObject(zzcqVar, j);
                    zzea zzeaVar11 = zzgg.zzb;
                    size = list10.size();
                    if (size == 0) {
                        iZzA4 = 0;
                    } else {
                        iZzl = zzgg.zzi(list10);
                        iZzA3 = zzdk.zzA(i9 << 3);
                        iZzA4 = (iZzA3 * size) + iZzl;
                    }
                    iM += iZzA4;
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 34:
                    List list11 = (List) unsafe.getObject(zzcqVar, j);
                    zzea zzeaVar12 = zzgg.zzb;
                    size = list11.size();
                    if (size == 0) {
                        iZzA4 = 0;
                    } else {
                        iZzl = zzgg.zzj(list11);
                        iZzA3 = zzdk.zzA(i9 << 3);
                        iZzA4 = (iZzA3 * size) + iZzl;
                    }
                    iM += iZzA4;
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 35:
                    List list12 = (List) unsafe.getObject(zzcqVar, j);
                    zzea zzeaVar13 = zzgg.zzb;
                    int size6 = list12.size() * 8;
                    if (size6 > 0) {
                        iM = Density.CC.m(size6, zzdk.zzA(i9 << 3), size6, iM);
                    }
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 36:
                    List list13 = (List) unsafe.getObject(zzcqVar, j);
                    zzea zzeaVar14 = zzgg.zzb;
                    int size7 = list13.size() * 4;
                    if (size7 > 0) {
                        iM = Density.CC.m(size7, zzdk.zzA(i9 << 3), size7, iM);
                    }
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 37:
                    int iZzg = zzgg.zzg((List) unsafe.getObject(zzcqVar, j));
                    if (iZzg > 0) {
                        iM = Density.CC.m(iZzg, zzdk.zzA(i9 << 3), iZzg, iM);
                    }
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 38:
                    int iZzl2 = zzgg.zzl((List) unsafe.getObject(zzcqVar, j));
                    if (iZzl2 > 0) {
                        iM = Density.CC.m(iZzl2, zzdk.zzA(i9 << 3), iZzl2, iM);
                    }
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 39:
                    int iZzf = zzgg.zzf((List) unsafe.getObject(zzcqVar, j));
                    if (iZzf > 0) {
                        iM = Density.CC.m(iZzf, zzdk.zzA(i9 << 3), iZzf, iM);
                    }
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 40:
                    List list14 = (List) unsafe.getObject(zzcqVar, j);
                    zzea zzeaVar15 = zzgg.zzb;
                    int size8 = list14.size() * 8;
                    if (size8 > 0) {
                        iM = Density.CC.m(size8, zzdk.zzA(i9 << 3), size8, iM);
                    }
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 41:
                    List list15 = (List) unsafe.getObject(zzcqVar, j);
                    zzea zzeaVar16 = zzgg.zzb;
                    int size9 = list15.size() * 4;
                    if (size9 > 0) {
                        iM = Density.CC.m(size9, zzdk.zzA(i9 << 3), size9, iM);
                    }
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 42:
                    List list16 = (List) unsafe.getObject(zzcqVar, j);
                    zzea zzeaVar17 = zzgg.zzb;
                    int size10 = list16.size();
                    if (size10 > 0) {
                        iM = Density.CC.m(size10, zzdk.zzA(i9 << 3), size10, iM);
                    }
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 43:
                    int iZzk = zzgg.zzk((List) unsafe.getObject(zzcqVar, j));
                    if (iZzk > 0) {
                        iM = Density.CC.m(iZzk, zzdk.zzA(i9 << 3), iZzk, iM);
                    }
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 44:
                    int iZza3 = zzgg.zza((List) unsafe.getObject(zzcqVar, j));
                    if (iZza3 > 0) {
                        iM = Density.CC.m(iZza3, zzdk.zzA(i9 << 3), iZza3, iM);
                    }
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 45:
                    List list17 = (List) unsafe.getObject(zzcqVar, j);
                    zzea zzeaVar18 = zzgg.zzb;
                    int size11 = list17.size() * 4;
                    if (size11 > 0) {
                        iM = Density.CC.m(size11, zzdk.zzA(i9 << 3), size11, iM);
                    }
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 46:
                    List list18 = (List) unsafe.getObject(zzcqVar, j);
                    zzea zzeaVar19 = zzgg.zzb;
                    int size12 = list18.size() * 8;
                    if (size12 > 0) {
                        iM = Density.CC.m(size12, zzdk.zzA(i9 << 3), size12, iM);
                    }
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 47:
                    int iZzi = zzgg.zzi((List) unsafe.getObject(zzcqVar, j));
                    if (iZzi > 0) {
                        iM = Density.CC.m(iZzi, zzdk.zzA(i9 << 3), iZzi, iM);
                    }
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 48:
                    int iZzj = zzgg.zzj((List) unsafe.getObject(zzcqVar, j));
                    if (iZzj > 0) {
                        iM = Density.CC.m(iZzj, zzdk.zzA(i9 << 3), iZzj, iM);
                    }
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 49:
                    List list19 = (List) unsafe.getObject(zzcqVar, j);
                    zzge zzgeVarZzv4 = zzfpVar.zzv(i5);
                    zzea zzeaVar20 = zzgg.zzb;
                    int size13 = list19.size();
                    if (size13 == 0) {
                        iZzB3 = 0;
                    } else {
                        iZzB3 = 0;
                        for (int i18 = 0; i18 < size13; i18++) {
                            zzcq zzcqVar3 = (zzcq) list19.get(i18);
                            int iZzA11 = zzdk.zzA(i9 << 3);
                            iZzB3 += zzcqVar3.zzB(zzgeVarZzv4) + iZzA11 + iZzA11;
                        }
                    }
                    iM += iZzB3;
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 50:
                    Object object3 = unsafe.getObject(zzcqVar, j);
                    int i19 = i5 / 3;
                    zzfg zzfgVar = (zzfg) object3;
                    if (zzfpVar.zzd[i19 + i19] != null) {
                        throw new ClassCastException();
                    }
                    if (zzfgVar.isEmpty()) {
                        continue;
                    } else {
                        Iterator it = zzfgVar.entrySet().iterator();
                        if (it.hasNext()) {
                            Map.Entry entry2 = (Map.Entry) it.next();
                            entry2.getKey();
                            entry2.getValue();
                            throw null;
                        }
                    }
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 51:
                    if (zzfpVar.zzM(i9, i5, zzcqVar)) {
                        iM = Density.CC.m(i9 << 3, 8, iM);
                    }
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 52:
                    if (zzfpVar.zzM(i9, i5, zzcqVar)) {
                        iM = Density.CC.m(i9 << 3, 4, iM);
                    }
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 53:
                    if (zzfpVar.zzM(i9, i5, zzcqVar)) {
                        long jZzt = zzt(j, zzcqVar);
                        iZzA6 = zzdk.zzA(i9 << 3);
                        iZzB4 = zzdk.zzB(jZzt);
                        iM += iZzB4 + iZzA6;
                    }
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 54:
                    if (zzfpVar.zzM(i9, i5, zzcqVar)) {
                        long jZzt2 = zzt(j, zzcqVar);
                        iZzA6 = zzdk.zzA(i9 << 3);
                        iZzB4 = zzdk.zzB(jZzt2);
                        iM += iZzB4 + iZzA6;
                    }
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 55:
                    if (zzfpVar.zzM(i9, i5, zzcqVar)) {
                        long jZzo = zzo(j, zzcqVar);
                        iZzA6 = zzdk.zzA(i9 << 3);
                        iZzB4 = zzdk.zzB(jZzo);
                        iM += iZzB4 + iZzA6;
                    }
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 56:
                    if (zzfpVar.zzM(i9, i5, zzcqVar)) {
                        iM = Density.CC.m(i9 << 3, 8, iM);
                    }
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 57:
                    if (zzfpVar.zzM(i9, i5, zzcqVar)) {
                        iM = Density.CC.m(i9 << 3, 4, iM);
                    }
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 58:
                    if (zzfpVar.zzM(i9, i5, zzcqVar)) {
                        iM = Density.CC.m(i9 << 3, 1, iM);
                    }
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 59:
                    if (zzfpVar.zzM(i9, i5, zzcqVar)) {
                        int i20 = i9 << 3;
                        Object object4 = unsafe.getObject(zzcqVar, j);
                        if (object4 instanceof zzdf) {
                            int iZzA12 = zzdk.zzA(i20);
                            int iZzd6 = ((zzdf) object4).zzd();
                            iM = Density.CC.m(iZzd6, iZzd6, iZzA12, iM);
                        } else {
                            iZzA6 = zzdk.zzA(i20);
                            iZzB4 = zzdk.zzz((String) object4);
                            iM += iZzB4 + iZzA6;
                        }
                    }
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 60:
                    if (zzfpVar.zzM(i9, i5, zzcqVar)) {
                        Object object5 = unsafe.getObject(zzcqVar, j);
                        zzge zzgeVarZzv5 = zzfpVar.zzv(i5);
                        zzea zzeaVar21 = zzgg.zzb;
                        int iZzA13 = zzdk.zzA(i9 << 3);
                        int iZzB7 = ((zzcq) object5).zzB(zzgeVarZzv5);
                        iM = Density.CC.m(iZzB7, iZzB7, iZzA13, iM);
                    }
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 61:
                    if (zzfpVar.zzM(i9, i5, zzcqVar)) {
                        zzdf zzdfVar2 = (zzdf) unsafe.getObject(zzcqVar, j);
                        int iZzA14 = zzdk.zzA(i9 << 3);
                        int iZzd7 = zzdfVar2.zzd();
                        iM = Density.CC.m(iZzd7, iZzd7, iZzA14, iM);
                    }
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 62:
                    if (zzfpVar.zzM(i9, i5, zzcqVar)) {
                        iM = Density.CC.m(zzo(j, zzcqVar), zzdk.zzA(i9 << 3), iM);
                    }
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 63:
                    if (zzfpVar.zzM(i9, i5, zzcqVar)) {
                        long jZzo2 = zzo(j, zzcqVar);
                        iZzA6 = zzdk.zzA(i9 << 3);
                        iZzB4 = zzdk.zzB(jZzo2);
                        iM += iZzB4 + iZzA6;
                    }
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 64:
                    if (zzfpVar.zzM(i9, i5, zzcqVar)) {
                        iM = Density.CC.m(i9 << 3, 4, iM);
                    }
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 65:
                    if (zzfpVar.zzM(i9, i5, zzcqVar)) {
                        iM = Density.CC.m(i9 << 3, 8, iM);
                    }
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 66:
                    if (zzfpVar.zzM(i9, i5, zzcqVar)) {
                        int iZzo = zzo(j, zzcqVar);
                        iM = Density.CC.m((iZzo >> 31) ^ (iZzo + iZzo), zzdk.zzA(i9 << 3), iM);
                    }
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 67:
                    if (zzfpVar.zzM(i9, i5, zzcqVar)) {
                        long jZzt3 = zzt(j, zzcqVar);
                        iZzA6 = zzdk.zzA(i9 << 3);
                        iZzB4 = zzdk.zzB((jZzt3 >> 63) ^ (jZzt3 + jZzt3));
                        iM += iZzB4 + iZzA6;
                    }
                    i5 += 3;
                    i3 = 1048575;
                    break;
                case 68:
                    if (zzfpVar.zzM(i9, i5, zzcqVar)) {
                        zzcq zzcqVar4 = (zzcq) unsafe.getObject(zzcqVar, j);
                        zzge zzgeVarZzv6 = zzfpVar.zzv(i5);
                        int iZzA15 = zzdk.zzA(i9 << 3);
                        i2 = iZzA15 + iZzA15;
                        iZzB2 = zzcqVar4.zzB(zzgeVarZzv6);
                        iZzd = iZzB2 + i2;
                        iM += iZzd;
                    }
                    i5 += 3;
                    i3 = 1048575;
                    break;
                default:
                    i5 += 3;
                    i3 = 1048575;
                    break;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00db A[PHI: r1
      0x00db: PHI (r1v35 int) = (r1v11 int), (r1v36 int) binds: [B:85:0x01ea, B:43:0x00d9] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final int zzb(zzeh zzehVar) {
        int i;
        long jDoubleToLongBits;
        int i2;
        int iFloatToIntBits;
        int i3;
        int i4;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i5 >= iArr.length) {
                int iHashCode = zzehVar.zzc.hashCode() + (i6 * 53);
                if (!this.zzh) {
                    return iHashCode;
                }
                return ((zzed) zzehVar).zzb.zza.hashCode() + (iHashCode * 53);
            }
            int iZzs = zzs(i5);
            int i7 = 1048575 & iZzs;
            int iZzr = zzr(iZzs);
            int i8 = iArr[i5];
            long j = i7;
            int i9 = 1237;
            int iHashCode2 = 37;
            switch (iZzr) {
                case 0:
                    i = i6 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzgz.zzf.zza(j, zzehVar));
                    Charset charset = zzep.zza;
                    i6 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 1:
                    i2 = i6 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzgz.zzf.zzb(j, zzehVar));
                    i6 = iFloatToIntBits + i2;
                    break;
                case 2:
                    i = i6 * 53;
                    jDoubleToLongBits = zzgz.zzd(j, zzehVar);
                    Charset charset2 = zzep.zza;
                    i6 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 3:
                    i = i6 * 53;
                    jDoubleToLongBits = zzgz.zzd(j, zzehVar);
                    Charset charset3 = zzep.zza;
                    i6 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 4:
                    i2 = i6 * 53;
                    iFloatToIntBits = zzgz.zzc(j, zzehVar);
                    i6 = iFloatToIntBits + i2;
                    break;
                case 5:
                    i = i6 * 53;
                    jDoubleToLongBits = zzgz.zzd(j, zzehVar);
                    Charset charset4 = zzep.zza;
                    i6 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 6:
                    i2 = i6 * 53;
                    iFloatToIntBits = zzgz.zzc(j, zzehVar);
                    i6 = iFloatToIntBits + i2;
                    break;
                case 7:
                    i3 = i6 * 53;
                    boolean zZzg = zzgz.zzf.zzg(j, zzehVar);
                    Charset charset5 = zzep.zza;
                    if (zZzg) {
                        i9 = 1231;
                    }
                    i6 = i9 + i3;
                    break;
                case 8:
                    i2 = i6 * 53;
                    iFloatToIntBits = ((String) zzgz.zzf(j, zzehVar)).hashCode();
                    i6 = iFloatToIntBits + i2;
                    break;
                case 9:
                    i4 = i6 * 53;
                    Object objZzf = zzgz.zzf(j, zzehVar);
                    if (objZzf != null) {
                        iHashCode2 = objZzf.hashCode();
                    }
                    i6 = i4 + iHashCode2;
                    break;
                case 10:
                    i2 = i6 * 53;
                    iFloatToIntBits = zzgz.zzf(j, zzehVar).hashCode();
                    i6 = iFloatToIntBits + i2;
                    break;
                case 11:
                    i2 = i6 * 53;
                    iFloatToIntBits = zzgz.zzc(j, zzehVar);
                    i6 = iFloatToIntBits + i2;
                    break;
                case 12:
                    i2 = i6 * 53;
                    iFloatToIntBits = zzgz.zzc(j, zzehVar);
                    i6 = iFloatToIntBits + i2;
                    break;
                case 13:
                    i2 = i6 * 53;
                    iFloatToIntBits = zzgz.zzc(j, zzehVar);
                    i6 = iFloatToIntBits + i2;
                    break;
                case 14:
                    i = i6 * 53;
                    jDoubleToLongBits = zzgz.zzd(j, zzehVar);
                    Charset charset6 = zzep.zza;
                    i6 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 15:
                    i2 = i6 * 53;
                    iFloatToIntBits = zzgz.zzc(j, zzehVar);
                    i6 = iFloatToIntBits + i2;
                    break;
                case 16:
                    i = i6 * 53;
                    jDoubleToLongBits = zzgz.zzd(j, zzehVar);
                    Charset charset7 = zzep.zza;
                    i6 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    break;
                case 17:
                    i4 = i6 * 53;
                    Object objZzf2 = zzgz.zzf(j, zzehVar);
                    if (objZzf2 != null) {
                        iHashCode2 = objZzf2.hashCode();
                    }
                    i6 = i4 + iHashCode2;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i2 = i6 * 53;
                    iFloatToIntBits = zzgz.zzf(j, zzehVar).hashCode();
                    i6 = iFloatToIntBits + i2;
                    break;
                case 50:
                    i2 = i6 * 53;
                    iFloatToIntBits = zzgz.zzf(j, zzehVar).hashCode();
                    i6 = iFloatToIntBits + i2;
                    break;
                case 51:
                    if (zzM(i8, i5, zzehVar)) {
                        i = i6 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(((Double) zzgz.zzf(j, zzehVar)).doubleValue());
                        Charset charset8 = zzep.zza;
                        i6 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 52:
                    if (zzM(i8, i5, zzehVar)) {
                        i2 = i6 * 53;
                        iFloatToIntBits = Float.floatToIntBits(((Float) zzgz.zzf(j, zzehVar)).floatValue());
                        i6 = iFloatToIntBits + i2;
                    }
                    break;
                case 53:
                    if (zzM(i8, i5, zzehVar)) {
                        i = i6 * 53;
                        jDoubleToLongBits = zzt(j, zzehVar);
                        Charset charset9 = zzep.zza;
                        i6 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 54:
                    if (zzM(i8, i5, zzehVar)) {
                        i = i6 * 53;
                        jDoubleToLongBits = zzt(j, zzehVar);
                        Charset charset10 = zzep.zza;
                        i6 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 55:
                    if (zzM(i8, i5, zzehVar)) {
                        i2 = i6 * 53;
                        iFloatToIntBits = zzo(j, zzehVar);
                        i6 = iFloatToIntBits + i2;
                    }
                    break;
                case 56:
                    if (zzM(i8, i5, zzehVar)) {
                        i = i6 * 53;
                        jDoubleToLongBits = zzt(j, zzehVar);
                        Charset charset11 = zzep.zza;
                        i6 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 57:
                    if (zzM(i8, i5, zzehVar)) {
                        i2 = i6 * 53;
                        iFloatToIntBits = zzo(j, zzehVar);
                        i6 = iFloatToIntBits + i2;
                    }
                    break;
                case 58:
                    if (zzM(i8, i5, zzehVar)) {
                        i3 = i6 * 53;
                        boolean zBooleanValue = ((Boolean) zzgz.zzf(j, zzehVar)).booleanValue();
                        Charset charset12 = zzep.zza;
                        if (zBooleanValue) {
                            i9 = 1231;
                        }
                        i6 = i9 + i3;
                    }
                    break;
                case 59:
                    if (zzM(i8, i5, zzehVar)) {
                        i2 = i6 * 53;
                        iFloatToIntBits = ((String) zzgz.zzf(j, zzehVar)).hashCode();
                        i6 = iFloatToIntBits + i2;
                    }
                    break;
                case 60:
                    if (zzM(i8, i5, zzehVar)) {
                        i2 = i6 * 53;
                        iFloatToIntBits = zzgz.zzf(j, zzehVar).hashCode();
                        i6 = iFloatToIntBits + i2;
                    }
                    break;
                case 61:
                    if (zzM(i8, i5, zzehVar)) {
                        i2 = i6 * 53;
                        iFloatToIntBits = zzgz.zzf(j, zzehVar).hashCode();
                        i6 = iFloatToIntBits + i2;
                    }
                    break;
                case 62:
                    if (zzM(i8, i5, zzehVar)) {
                        i2 = i6 * 53;
                        iFloatToIntBits = zzo(j, zzehVar);
                        i6 = iFloatToIntBits + i2;
                    }
                    break;
                case 63:
                    if (zzM(i8, i5, zzehVar)) {
                        i2 = i6 * 53;
                        iFloatToIntBits = zzo(j, zzehVar);
                        i6 = iFloatToIntBits + i2;
                    }
                    break;
                case 64:
                    if (zzM(i8, i5, zzehVar)) {
                        i2 = i6 * 53;
                        iFloatToIntBits = zzo(j, zzehVar);
                        i6 = iFloatToIntBits + i2;
                    }
                    break;
                case 65:
                    if (zzM(i8, i5, zzehVar)) {
                        i = i6 * 53;
                        jDoubleToLongBits = zzt(j, zzehVar);
                        Charset charset13 = zzep.zza;
                        i6 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 66:
                    if (zzM(i8, i5, zzehVar)) {
                        i2 = i6 * 53;
                        iFloatToIntBits = zzo(j, zzehVar);
                        i6 = iFloatToIntBits + i2;
                    }
                    break;
                case 67:
                    if (zzM(i8, i5, zzehVar)) {
                        i = i6 * 53;
                        jDoubleToLongBits = zzt(j, zzehVar);
                        Charset charset14 = zzep.zza;
                        i6 = i + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
                    }
                    break;
                case 68:
                    if (zzM(i8, i5, zzehVar)) {
                        i2 = i6 * 53;
                        iFloatToIntBits = zzgz.zzf(j, zzehVar).hashCode();
                        i6 = iFloatToIntBits + i2;
                    }
                    break;
            }
            i5 += 3;
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 38181. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public final int zzc(java.lang.Object r38, byte[] r39, int r40, int r41, int r42, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu r43) {
        /*
            Method dump skipped, instruction units count: 3818
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfp.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcu):int");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final Object zze() {
        return (zzeh) ((zzeh) this.zzg).zzg(4, null);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0071  */
    /* JADX WARN: Code duplicated, block: B:30:0x0077  */
    /* JADX WARN: Code duplicated, block: B:47:0x0084 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final void zzf(Object obj) {
        if (!zzL(obj)) {
            return;
        }
        if (obj instanceof zzeh) {
            zzeh zzehVar = (zzeh) obj;
            zzehVar.zzW();
            zzehVar.zza = 0;
            zzehVar.zzU();
        }
        int i = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i >= iArr.length) {
                this.zzl.getClass();
                zzgt zzgtVar = ((zzeh) obj).zzc;
                if (zzgtVar.zzf) {
                    zzgtVar.zzf = false;
                }
                if (this.zzh) {
                    this.zzm.getClass();
                    ((zzed) obj).zzb.zzg();
                    return;
                }
                return;
            }
            int iZzs = zzs(i);
            int i2 = 1048575 & iZzs;
            int iZzr = zzr(iZzs);
            long j = i2;
            if (iZzr != 9) {
                if (iZzr != 60 && iZzr != 68) {
                    switch (iZzr) {
                        case 17:
                            if (zzI(i, obj)) {
                                zzv(i).zzf(zzb.getObject(obj, j));
                            }
                            break;
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case 45:
                        case 46:
                        case 47:
                        case 48:
                        case 49:
                            zzcs zzcsVar = (zzcs) ((zzeo) zzgz.zzf(j, obj));
                            if (zzcsVar.zza) {
                                zzcsVar.zza = false;
                            }
                            break;
                        case 50:
                            Unsafe unsafe = zzb;
                            Object object = unsafe.getObject(obj, j);
                            if (object != null) {
                                ((zzfg) object).zzb = false;
                                unsafe.putObject(obj, j, object);
                            }
                            break;
                    }
                } else if (zzM(iArr[i], i, obj)) {
                    zzv(i).zzf(zzb.getObject(obj, j));
                }
            } else if (zzI(i, obj)) {
                zzv(i).zzf(zzb.getObject(obj, j));
            }
            i += 3;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:9:0x0022  */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final void zzg(Object obj, Object obj2) {
        Object obj3;
        if (!zzL(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
        obj2.getClass();
        int i = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i >= iArr.length) {
                Object obj4 = obj;
                zzgg.zzp(obj4, obj2);
                if (this.zzh) {
                    zzgg.zzo(obj4, obj2);
                    return;
                }
                return;
            }
            int iZzs = zzs(i);
            int i2 = iZzs & 1048575;
            int iZzr = zzr(iZzs);
            int i3 = iArr[i];
            long j = i2;
            switch (iZzr) {
                case 0:
                    if (!zzI(i, obj2)) {
                        obj3 = obj;
                    } else {
                        zzgy zzgyVar = zzgz.zzf;
                        obj3 = obj;
                        zzgyVar.zze(obj3, j, zzgyVar.zza(j, obj2));
                        zzD(i, obj3);
                    }
                    break;
                case 1:
                    if (zzI(i, obj2)) {
                        zzgy zzgyVar2 = zzgz.zzf;
                        zzgyVar2.zzf(obj, j, zzgyVar2.zzb(j, obj2));
                        zzD(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 2:
                    if (zzI(i, obj2)) {
                        zzgz.zzr(obj, j, zzgz.zzd(j, obj2));
                        zzD(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 3:
                    if (zzI(i, obj2)) {
                        zzgz.zzr(obj, j, zzgz.zzd(j, obj2));
                        zzD(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 4:
                    if (zzI(i, obj2)) {
                        zzgz.zzq(obj, j, zzgz.zzc(j, obj2));
                        zzD(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 5:
                    if (zzI(i, obj2)) {
                        zzgz.zzr(obj, j, zzgz.zzd(j, obj2));
                        zzD(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 6:
                    if (zzI(i, obj2)) {
                        zzgz.zzq(obj, j, zzgz.zzc(j, obj2));
                        zzD(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 7:
                    if (zzI(i, obj2)) {
                        zzgy zzgyVar3 = zzgz.zzf;
                        zzgyVar3.zzc(obj, j, zzgyVar3.zzg(j, obj2));
                        zzD(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 8:
                    if (zzI(i, obj2)) {
                        zzgz.zzs(obj, j, zzgz.zzf(j, obj2));
                        zzD(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 9:
                    zzB(i, obj, obj2);
                    obj3 = obj;
                    break;
                case 10:
                    if (zzI(i, obj2)) {
                        zzgz.zzs(obj, j, zzgz.zzf(j, obj2));
                        zzD(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 11:
                    if (zzI(i, obj2)) {
                        zzgz.zzq(obj, j, zzgz.zzc(j, obj2));
                        zzD(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 12:
                    if (zzI(i, obj2)) {
                        zzgz.zzq(obj, j, zzgz.zzc(j, obj2));
                        zzD(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 13:
                    if (zzI(i, obj2)) {
                        zzgz.zzq(obj, j, zzgz.zzc(j, obj2));
                        zzD(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 14:
                    if (zzI(i, obj2)) {
                        zzgz.zzr(obj, j, zzgz.zzd(j, obj2));
                        zzD(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 15:
                    if (zzI(i, obj2)) {
                        zzgz.zzq(obj, j, zzgz.zzc(j, obj2));
                        zzD(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 16:
                    if (zzI(i, obj2)) {
                        zzgz.zzr(obj, j, zzgz.zzd(j, obj2));
                        zzD(i, obj);
                    }
                    obj3 = obj;
                    break;
                case 17:
                    zzB(i, obj, obj2);
                    obj3 = obj;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zzeo zzeoVarZzd = (zzeo) zzgz.zzf(j, obj);
                    zzeo zzeoVar = (zzeo) zzgz.zzf(j, obj2);
                    int size = zzeoVarZzd.size();
                    int size2 = zzeoVar.size();
                    if (size > 0 && size2 > 0) {
                        if (!((zzcs) zzeoVarZzd).zza) {
                            zzeoVarZzd = zzeoVarZzd.zzd(size2 + size);
                        }
                        zzeoVarZzd.addAll(zzeoVar);
                    }
                    if (size > 0) {
                        zzeoVar = zzeoVarZzd;
                    }
                    zzgz.zzs(obj, j, zzeoVar);
                    obj3 = obj;
                    break;
                case 50:
                    zzea zzeaVar = zzgg.zzb;
                    zzgz.zzs(obj, j, zzea.zza(zzgz.zzf(j, obj), zzgz.zzf(j, obj2)));
                    obj3 = obj;
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zzM(i3, i, obj2)) {
                        zzgz.zzs(obj, j, zzgz.zzf(j, obj2));
                        zzgz.zzq(obj, iArr[i + 2] & 1048575, i3);
                    }
                    obj3 = obj;
                    break;
                case 60:
                    zzC(i, obj, obj2);
                    obj3 = obj;
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzM(i3, i, obj2)) {
                        zzgz.zzs(obj, j, zzgz.zzf(j, obj2));
                        zzgz.zzq(obj, iArr[i + 2] & 1048575, i3);
                    }
                    obj3 = obj;
                    break;
                case 68:
                    zzC(i, obj, obj2);
                    obj3 = obj;
                    break;
                default:
                    obj3 = obj;
                    break;
            }
            i += 3;
            obj = obj3;
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzcu zzcuVar) {
        zzc(obj, bArr, i, i2, 0, zzcuVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:101:0x025e A[LOOP:2: B:99:0x0258->B:101:0x025e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:102:0x0268  */
    /* JADX WARN: Code duplicated, block: B:103:0x0277  */
    /* JADX WARN: Code duplicated, block: B:104:0x0286  */
    /* JADX WARN: Code duplicated, block: B:105:0x0295  */
    /* JADX WARN: Code duplicated, block: B:106:0x02a4  */
    /* JADX WARN: Code duplicated, block: B:107:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:108:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:109:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:110:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:111:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:112:0x02fe  */
    /* JADX WARN: Code duplicated, block: B:113:0x030d  */
    /* JADX WARN: Code duplicated, block: B:114:0x031c  */
    /* JADX WARN: Code duplicated, block: B:115:0x032b  */
    /* JADX WARN: Code duplicated, block: B:116:0x033a  */
    /* JADX WARN: Code duplicated, block: B:118:0x0349  */
    /* JADX WARN: Code duplicated, block: B:119:0x0356  */
    /* JADX WARN: Code duplicated, block: B:120:0x0363  */
    /* JADX WARN: Code duplicated, block: B:121:0x0370  */
    /* JADX WARN: Code duplicated, block: B:122:0x037d  */
    /* JADX WARN: Code duplicated, block: B:123:0x038a  */
    /* JADX WARN: Code duplicated, block: B:130:0x03a6 A[LOOP:3: B:128:0x03a0->B:130:0x03a6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:131:0x03b6  */
    /* JADX WARN: Code duplicated, block: B:138:0x03d3 A[LOOP:4: B:136:0x03cd->B:138:0x03d3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:139:0x03dd  */
    /* JADX WARN: Code duplicated, block: B:146:0x03f9 A[LOOP:5: B:144:0x03f3->B:146:0x03f9, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:147:0x0409  */
    /* JADX WARN: Code duplicated, block: B:148:0x0417  */
    /* JADX WARN: Code duplicated, block: B:149:0x0425  */
    /* JADX WARN: Code duplicated, block: B:150:0x0433  */
    /* JADX WARN: Code duplicated, block: B:151:0x0441  */
    /* JADX WARN: Code duplicated, block: B:152:0x044f  */
    /* JADX WARN: Code duplicated, block: B:153:0x045d  */
    /* JADX WARN: Code duplicated, block: B:154:0x046b  */
    /* JADX WARN: Code duplicated, block: B:155:0x0479  */
    /* JADX WARN: Code duplicated, block: B:157:0x0480  */
    /* JADX WARN: Code duplicated, block: B:158:0x048d  */
    /* JADX WARN: Code duplicated, block: B:160:0x0494  */
    /* JADX WARN: Code duplicated, block: B:161:0x04a7  */
    /* JADX WARN: Code duplicated, block: B:163:0x04ae  */
    /* JADX WARN: Code duplicated, block: B:164:0x04c0  */
    /* JADX WARN: Code duplicated, block: B:166:0x04c7  */
    /* JADX WARN: Code duplicated, block: B:167:0x04d4  */
    /* JADX WARN: Code duplicated, block: B:169:0x04db  */
    /* JADX WARN: Code duplicated, block: B:170:0x04e8  */
    /* JADX WARN: Code duplicated, block: B:172:0x04ef  */
    /* JADX WARN: Code duplicated, block: B:173:0x04fc  */
    /* JADX WARN: Code duplicated, block: B:175:0x0503  */
    /* JADX WARN: Code duplicated, block: B:176:0x0510  */
    /* JADX WARN: Code duplicated, block: B:178:0x0517  */
    /* JADX WARN: Code duplicated, block: B:179:0x0526  */
    /* JADX WARN: Code duplicated, block: B:181:0x052d  */
    /* JADX WARN: Code duplicated, block: B:182:0x053a  */
    /* JADX WARN: Code duplicated, block: B:184:0x0541  */
    /* JADX WARN: Code duplicated, block: B:186:0x0549  */
    /* JADX WARN: Code duplicated, block: B:187:0x0554  */
    /* JADX WARN: Code duplicated, block: B:188:0x055f  */
    /* JADX WARN: Code duplicated, block: B:190:0x0566  */
    /* JADX WARN: Code duplicated, block: B:191:0x057a  */
    /* JADX WARN: Code duplicated, block: B:193:0x0581  */
    /* JADX WARN: Code duplicated, block: B:194:0x058e  */
    /* JADX WARN: Code duplicated, block: B:196:0x0595  */
    /* JADX WARN: Code duplicated, block: B:197:0x05a1  */
    /* JADX WARN: Code duplicated, block: B:199:0x05a8  */
    /* JADX WARN: Code duplicated, block: B:200:0x05b4  */
    /* JADX WARN: Code duplicated, block: B:202:0x05bb  */
    /* JADX WARN: Code duplicated, block: B:203:0x05c7  */
    /* JADX WARN: Code duplicated, block: B:205:0x05ce  */
    /* JADX WARN: Code duplicated, block: B:206:0x05da  */
    /* JADX WARN: Code duplicated, block: B:208:0x05e1  */
    /* JADX WARN: Code duplicated, block: B:209:0x05f3  */
    /* JADX WARN: Code duplicated, block: B:211:0x05fa  */
    /* JADX WARN: Code duplicated, block: B:222:0x0235 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:234:0x060b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:236:0x060b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:238:0x060b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:240:0x060b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:242:0x060b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:244:0x060b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:246:0x060b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:248:0x060b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:250:0x060b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:252:0x060b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:255:0x060b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:257:0x060b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:259:0x060b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:261:0x060b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:263:0x060b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:265:0x060b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:267:0x060b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:269:0x060b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x009e  */
    /* JADX WARN: Code duplicated, block: B:32:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:34:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:35:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:37:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:38:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:40:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:41:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:43:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:44:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:46:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:47:0x0105  */
    /* JADX WARN: Code duplicated, block: B:49:0x010b  */
    /* JADX WARN: Code duplicated, block: B:50:0x0117  */
    /* JADX WARN: Code duplicated, block: B:52:0x011d  */
    /* JADX WARN: Code duplicated, block: B:53:0x012a  */
    /* JADX WARN: Code duplicated, block: B:55:0x0130  */
    /* JADX WARN: Code duplicated, block: B:56:0x013f  */
    /* JADX WARN: Code duplicated, block: B:58:0x0145  */
    /* JADX WARN: Code duplicated, block: B:59:0x0152  */
    /* JADX WARN: Code duplicated, block: B:61:0x0158  */
    /* JADX WARN: Code duplicated, block: B:63:0x0160  */
    /* JADX WARN: Code duplicated, block: B:64:0x016b  */
    /* JADX WARN: Code duplicated, block: B:65:0x0176  */
    /* JADX WARN: Code duplicated, block: B:67:0x017c  */
    /* JADX WARN: Code duplicated, block: B:68:0x0194  */
    /* JADX WARN: Code duplicated, block: B:70:0x019a  */
    /* JADX WARN: Code duplicated, block: B:71:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:73:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:74:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:76:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:77:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:79:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:7:0x0023  */
    /* JADX WARN: Code duplicated, block: B:80:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:82:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:83:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:85:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:86:0x0210  */
    /* JADX WARN: Code duplicated, block: B:88:0x0216  */
    /* JADX WARN: Code duplicated, block: B:89:0x022d  */
    /* JADX WARN: Code duplicated, block: B:94:0x0241  */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final void zzi(Object obj, zzfe zzfeVar) throws FileSystemException {
        Map.Entry entry;
        Iterator it;
        boolean z;
        int i;
        int i2;
        Map.Entry entry2;
        int i3;
        long j;
        Object object;
        int i4;
        List list;
        int i5;
        int i6;
        List list2;
        zzge zzgeVarZzv;
        int i7;
        int i8;
        List list3;
        int i9;
        boolean z2;
        int i10;
        List list4;
        zzge zzgeVarZzv2;
        int i11;
        Object object2;
        zzfp zzfpVar = this;
        if (zzfpVar.zzh) {
            zzdx zzdxVar = ((zzed) obj).zzb;
            if (zzdxVar.zza.isEmpty()) {
                entry = null;
                it = null;
            } else {
                Iterator itZzf = zzdxVar.zzf();
                entry = (Map.Entry) itZzf.next();
                it = itZzf;
            }
        } else {
            entry = null;
            it = null;
        }
        Unsafe unsafe = zzb;
        int i12 = 0;
        int i13 = 1048575;
        int i14 = 0;
        while (true) {
            int[] iArr = zzfpVar.zzc;
            int length = iArr.length;
            zzea zzeaVar = zzfpVar.zzm;
            if (i12 >= length) {
                while (entry != null) {
                    zzeaVar.getClass();
                    zzea.zzb(zzfeVar, entry);
                    entry = it.hasNext() ? (Map.Entry) it.next() : null;
                }
                ((zzeh) obj).zzc.zzl(zzfeVar);
                return;
            }
            int iZzs = zzfpVar.zzs(i12);
            int iZzr = zzr(iZzs);
            int i15 = iArr[i12];
            if (iZzr <= 17) {
                int i16 = iArr[i12 + 2];
                z = true;
                int i17 = i16 & 1048575;
                Map.Entry entry3 = entry;
                if (i17 != i13) {
                    i14 = i17 == 1048575 ? 0 : unsafe.getInt(obj, i17);
                    i13 = i17;
                }
                int i18 = i14;
                i3 = 1 << (i16 >>> 20);
                i = i13;
                i2 = i18;
                entry2 = entry3;
            } else {
                Map.Entry entry4 = entry;
                z = true;
                i = i13;
                i2 = i14;
                entry2 = entry4;
                i3 = 0;
            }
            while (entry2 != null) {
                ((zzee) entry2.getKey()).getClass();
                if (i15 < 0) {
                    j = iZzs & 1048575;
                    switch (iZzr) {
                        case 0:
                            if (zzfpVar.zzJ(obj, i12, i, i2, i3)) {
                                ((zzdk) zzfeVar.zzb).zzh(i15, Double.doubleToRawLongBits(zzgz.zzf.zza(j, obj)));
                            }
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 1:
                            if (zzfpVar.zzJ(obj, i12, i, i2, i3)) {
                                ((zzdk) zzfeVar.zzb).zzf(i15, Float.floatToRawIntBits(zzgz.zzf.zzb(j, obj)));
                            }
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 2:
                            if (zzfpVar.zzJ(obj, i12, i, i2, i3)) {
                                ((zzdk) zzfeVar.zzb).zzu(i15, unsafe.getLong(obj, j));
                            }
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 3:
                            if (zzfpVar.zzJ(obj, i12, i, i2, i3)) {
                                ((zzdk) zzfeVar.zzb).zzu(i15, unsafe.getLong(obj, j));
                            }
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 4:
                            if (zzfpVar.zzJ(obj, i12, i, i2, i3)) {
                                ((zzdk) zzfeVar.zzb).zzj(i15, unsafe.getInt(obj, j));
                            }
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 5:
                            if (zzfpVar.zzJ(obj, i12, i, i2, i3)) {
                                ((zzdk) zzfeVar.zzb).zzh(i15, unsafe.getLong(obj, j));
                            }
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 6:
                            if (zzfpVar.zzJ(obj, i12, i, i2, i3)) {
                                ((zzdk) zzfeVar.zzb).zzf(i15, unsafe.getInt(obj, j));
                            }
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 7:
                            if (zzfpVar.zzJ(obj, i12, i, i2, i3)) {
                                boolean zZzg = zzgz.zzf.zzg(j, obj);
                                zzdk zzdkVar = (zzdk) zzfeVar.zzb;
                                zzdkVar.zzt(i15 << 3);
                                zzdkVar.zzb(zZzg ? (byte) 1 : (byte) 0);
                            }
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 8:
                            if (zzfpVar.zzJ(obj, i12, i, i2, i3)) {
                                object = unsafe.getObject(obj, j);
                                if (object instanceof String) {
                                    ((zzdk) zzfeVar.zzb).zzp((String) object, i15);
                                } else {
                                    ((zzdk) zzfeVar.zzb).zze(i15, (zzdf) object);
                                }
                            }
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 9:
                            if (zzfpVar.zzJ(obj, i12, i, i2, i3)) {
                                zzfeVar.zzv(i15, unsafe.getObject(obj, j), zzfpVar.zzv(i12));
                            }
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 10:
                            if (zzfpVar.zzJ(obj, i12, i, i2, i3)) {
                                ((zzdk) zzfeVar.zzb).zze(i15, (zzdf) unsafe.getObject(obj, j));
                            }
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 11:
                            if (zzfpVar.zzJ(obj, i12, i, i2, i3)) {
                                ((zzdk) zzfeVar.zzb).zzs(i15, unsafe.getInt(obj, j));
                            }
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 12:
                            if (zzfpVar.zzJ(obj, i12, i, i2, i3)) {
                                ((zzdk) zzfeVar.zzb).zzj(i15, unsafe.getInt(obj, j));
                            }
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 13:
                            if (zzfpVar.zzJ(obj, i12, i, i2, i3)) {
                                ((zzdk) zzfeVar.zzb).zzf(i15, unsafe.getInt(obj, j));
                            }
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 14:
                            if (zzfpVar.zzJ(obj, i12, i, i2, i3)) {
                                ((zzdk) zzfeVar.zzb).zzh(i15, unsafe.getLong(obj, j));
                            }
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 15:
                            if (zzfpVar.zzJ(obj, i12, i, i2, i3)) {
                                int i19 = unsafe.getInt(obj, j);
                                ((zzdk) zzfeVar.zzb).zzs(i15, (i19 >> 31) ^ (i19 + i19));
                            }
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 16:
                            if (zzfpVar.zzJ(obj, i12, i, i2, i3)) {
                                long j2 = unsafe.getLong(obj, j);
                                ((zzdk) zzfeVar.zzb).zzu(i15, (j2 + j2) ^ (j2 >> 63));
                            }
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 17:
                            if (zzfpVar.zzJ(obj, i12, i, i2, i3)) {
                                zzfeVar.zzq(i15, unsafe.getObject(obj, j), zzfpVar.zzv(i12));
                            }
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 18:
                            zzgg.zzr(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, false);
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 19:
                            zzgg.zzv(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, false);
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 20:
                            zzgg.zzx(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, false);
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 21:
                            zzgg.zzD(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, false);
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 22:
                            zzgg.zzw(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, false);
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 23:
                            zzgg.zzu(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, false);
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 24:
                            zzgg.zzt(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, false);
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 25:
                            zzgg.zzq(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, false);
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 26:
                            i4 = iArr[i12];
                            list = (List) unsafe.getObject(obj, j);
                            zzea zzeaVar2 = zzgg.zzb;
                            if (list != null && !list.isEmpty()) {
                                zzfeVar.getClass();
                                for (i5 = 0; i5 < list.size(); i5++) {
                                    ((zzdk) zzfeVar.zzb).zzp((String) list.get(i5), i4);
                                }
                            }
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 27:
                            i6 = iArr[i12];
                            list2 = (List) unsafe.getObject(obj, j);
                            zzgeVarZzv = zzfpVar.zzv(i12);
                            zzea zzeaVar3 = zzgg.zzb;
                            if (list2 != null && !list2.isEmpty()) {
                                for (i7 = 0; i7 < list2.size(); i7++) {
                                    zzfeVar.zzv(i6, list2.get(i7), zzgeVarZzv);
                                }
                            }
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 28:
                            i8 = iArr[i12];
                            list3 = (List) unsafe.getObject(obj, j);
                            zzea zzeaVar4 = zzgg.zzb;
                            if (list3 != null && !list3.isEmpty()) {
                                zzfeVar.getClass();
                                for (i9 = 0; i9 < list3.size(); i9++) {
                                    ((zzdk) zzfeVar.zzb).zze(i8, (zzdf) list3.get(i9));
                                }
                            }
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 29:
                            z2 = false;
                            zzgg.zzC(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, false);
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 30:
                            z2 = false;
                            zzgg.zzs(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, false);
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 31:
                            z2 = false;
                            zzgg.zzy(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, false);
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 32:
                            z2 = false;
                            zzgg.zzz(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, false);
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 33:
                            z2 = false;
                            zzgg.zzA(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, false);
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 34:
                            z2 = false;
                            zzgg.zzB(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, false);
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 35:
                            zzgg.zzr(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, z);
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 36:
                            zzgg.zzv(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, z);
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 37:
                            zzgg.zzx(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, z);
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 38:
                            zzgg.zzD(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, z);
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 39:
                            zzgg.zzw(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, z);
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 40:
                            zzgg.zzu(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, z);
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 41:
                            zzgg.zzt(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, z);
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 42:
                            zzgg.zzq(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, z);
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 43:
                            zzgg.zzC(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, z);
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 44:
                            zzgg.zzs(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, z);
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 45:
                            zzgg.zzy(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, z);
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 46:
                            zzgg.zzz(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, z);
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 47:
                            zzgg.zzA(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, z);
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 48:
                            zzgg.zzB(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, z);
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 49:
                            i10 = iArr[i12];
                            list4 = (List) unsafe.getObject(obj, j);
                            zzgeVarZzv2 = zzfpVar.zzv(i12);
                            zzea zzeaVar5 = zzgg.zzb;
                            if (list4 != null && !list4.isEmpty()) {
                                for (i11 = 0; i11 < list4.size(); i11++) {
                                    zzfeVar.zzq(i10, list4.get(i11), zzgeVarZzv2);
                                }
                            }
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 50:
                            if (unsafe.getObject(obj, j) != null) {
                                int i20 = i12 / 3;
                                throw ImageAnalysis$$ExternalSyntheticLambda1.m(zzfpVar.zzd[i20 + i20]);
                            }
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 51:
                            if (zzfpVar.zzM(i15, i12, obj)) {
                                ((zzdk) zzfeVar.zzb).zzh(i15, Double.doubleToRawLongBits(((Double) zzgz.zzf(j, obj)).doubleValue()));
                            }
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 52:
                            if (zzfpVar.zzM(i15, i12, obj)) {
                                ((zzdk) zzfeVar.zzb).zzf(i15, Float.floatToRawIntBits(((Float) zzgz.zzf(j, obj)).floatValue()));
                            }
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 53:
                            if (zzfpVar.zzM(i15, i12, obj)) {
                                ((zzdk) zzfeVar.zzb).zzu(i15, zzt(j, obj));
                            }
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 54:
                            if (zzfpVar.zzM(i15, i12, obj)) {
                                ((zzdk) zzfeVar.zzb).zzu(i15, zzt(j, obj));
                            }
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 55:
                            if (zzfpVar.zzM(i15, i12, obj)) {
                                ((zzdk) zzfeVar.zzb).zzj(i15, zzo(j, obj));
                            }
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 56:
                            if (zzfpVar.zzM(i15, i12, obj)) {
                                ((zzdk) zzfeVar.zzb).zzh(i15, zzt(j, obj));
                            }
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 57:
                            if (zzfpVar.zzM(i15, i12, obj)) {
                                ((zzdk) zzfeVar.zzb).zzf(i15, zzo(j, obj));
                            }
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 58:
                            if (zzfpVar.zzM(i15, i12, obj)) {
                                boolean zBooleanValue = ((Boolean) zzgz.zzf(j, obj)).booleanValue();
                                zzdk zzdkVar2 = (zzdk) zzfeVar.zzb;
                                zzdkVar2.zzt(i15 << 3);
                                zzdkVar2.zzb(zBooleanValue ? (byte) 1 : (byte) 0);
                            }
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 59:
                            if (zzfpVar.zzM(i15, i12, obj)) {
                                object2 = unsafe.getObject(obj, j);
                                if (object2 instanceof String) {
                                    ((zzdk) zzfeVar.zzb).zzp((String) object2, i15);
                                } else {
                                    ((zzdk) zzfeVar.zzb).zze(i15, (zzdf) object2);
                                }
                            }
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 60:
                            if (zzfpVar.zzM(i15, i12, obj)) {
                                zzfeVar.zzv(i15, unsafe.getObject(obj, j), zzfpVar.zzv(i12));
                            }
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 61:
                            if (zzfpVar.zzM(i15, i12, obj)) {
                                ((zzdk) zzfeVar.zzb).zze(i15, (zzdf) unsafe.getObject(obj, j));
                            }
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 62:
                            if (zzfpVar.zzM(i15, i12, obj)) {
                                ((zzdk) zzfeVar.zzb).zzs(i15, zzo(j, obj));
                            }
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 63:
                            if (zzfpVar.zzM(i15, i12, obj)) {
                                ((zzdk) zzfeVar.zzb).zzj(i15, zzo(j, obj));
                            }
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 64:
                            if (zzfpVar.zzM(i15, i12, obj)) {
                                ((zzdk) zzfeVar.zzb).zzf(i15, zzo(j, obj));
                            }
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 65:
                            if (zzfpVar.zzM(i15, i12, obj)) {
                                ((zzdk) zzfeVar.zzb).zzh(i15, zzt(j, obj));
                            }
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 66:
                            if (zzfpVar.zzM(i15, i12, obj)) {
                                int iZzo = zzo(j, obj);
                                ((zzdk) zzfeVar.zzb).zzs(i15, (iZzo >> 31) ^ (iZzo + iZzo));
                            }
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 67:
                            if (zzfpVar.zzM(i15, i12, obj)) {
                                long jZzt = zzt(j, obj);
                                ((zzdk) zzfeVar.zzb).zzu(i15, (jZzt >> 63) ^ (jZzt + jZzt));
                            }
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        case 68:
                            if (zzfpVar.zzM(i15, i12, obj)) {
                                zzfeVar.zzq(i15, unsafe.getObject(obj, j), zzfpVar.zzv(i12));
                            }
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                        default:
                            i12 += 3;
                            zzfpVar = this;
                            i14 = i2;
                            i13 = i;
                            entry = entry2;
                            break;
                    }
                } else {
                    zzeaVar.getClass();
                    zzea.zzb(zzfeVar, entry2);
                    entry2 = it.hasNext() ? (Map.Entry) it.next() : null;
                }
            }
            j = iZzs & 1048575;
            switch (iZzr) {
                case 0:
                    if (zzfpVar.zzJ(obj, i12, i, i2, i3)) {
                        ((zzdk) zzfeVar.zzb).zzh(i15, Double.doubleToRawLongBits(zzgz.zzf.zza(j, obj)));
                    }
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 1:
                    if (zzfpVar.zzJ(obj, i12, i, i2, i3)) {
                        ((zzdk) zzfeVar.zzb).zzf(i15, Float.floatToRawIntBits(zzgz.zzf.zzb(j, obj)));
                    }
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 2:
                    if (zzfpVar.zzJ(obj, i12, i, i2, i3)) {
                        ((zzdk) zzfeVar.zzb).zzu(i15, unsafe.getLong(obj, j));
                    }
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 3:
                    if (zzfpVar.zzJ(obj, i12, i, i2, i3)) {
                        ((zzdk) zzfeVar.zzb).zzu(i15, unsafe.getLong(obj, j));
                    }
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 4:
                    if (zzfpVar.zzJ(obj, i12, i, i2, i3)) {
                        ((zzdk) zzfeVar.zzb).zzj(i15, unsafe.getInt(obj, j));
                    }
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 5:
                    if (zzfpVar.zzJ(obj, i12, i, i2, i3)) {
                        ((zzdk) zzfeVar.zzb).zzh(i15, unsafe.getLong(obj, j));
                    }
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 6:
                    if (zzfpVar.zzJ(obj, i12, i, i2, i3)) {
                        ((zzdk) zzfeVar.zzb).zzf(i15, unsafe.getInt(obj, j));
                    }
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 7:
                    if (zzfpVar.zzJ(obj, i12, i, i2, i3)) {
                        boolean zZzg2 = zzgz.zzf.zzg(j, obj);
                        zzdk zzdkVar3 = (zzdk) zzfeVar.zzb;
                        zzdkVar3.zzt(i15 << 3);
                        zzdkVar3.zzb(zZzg2 ? (byte) 1 : (byte) 0);
                    }
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 8:
                    if (zzfpVar.zzJ(obj, i12, i, i2, i3)) {
                        object = unsafe.getObject(obj, j);
                        if (object instanceof String) {
                            ((zzdk) zzfeVar.zzb).zzp((String) object, i15);
                        } else {
                            ((zzdk) zzfeVar.zzb).zze(i15, (zzdf) object);
                        }
                    }
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 9:
                    if (zzfpVar.zzJ(obj, i12, i, i2, i3)) {
                        zzfeVar.zzv(i15, unsafe.getObject(obj, j), zzfpVar.zzv(i12));
                    }
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 10:
                    if (zzfpVar.zzJ(obj, i12, i, i2, i3)) {
                        ((zzdk) zzfeVar.zzb).zze(i15, (zzdf) unsafe.getObject(obj, j));
                    }
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 11:
                    if (zzfpVar.zzJ(obj, i12, i, i2, i3)) {
                        ((zzdk) zzfeVar.zzb).zzs(i15, unsafe.getInt(obj, j));
                    }
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 12:
                    if (zzfpVar.zzJ(obj, i12, i, i2, i3)) {
                        ((zzdk) zzfeVar.zzb).zzj(i15, unsafe.getInt(obj, j));
                    }
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 13:
                    if (zzfpVar.zzJ(obj, i12, i, i2, i3)) {
                        ((zzdk) zzfeVar.zzb).zzf(i15, unsafe.getInt(obj, j));
                    }
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 14:
                    if (zzfpVar.zzJ(obj, i12, i, i2, i3)) {
                        ((zzdk) zzfeVar.zzb).zzh(i15, unsafe.getLong(obj, j));
                    }
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 15:
                    if (zzfpVar.zzJ(obj, i12, i, i2, i3)) {
                        int i110 = unsafe.getInt(obj, j);
                        ((zzdk) zzfeVar.zzb).zzs(i15, (i110 >> 31) ^ (i110 + i110));
                    }
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 16:
                    if (zzfpVar.zzJ(obj, i12, i, i2, i3)) {
                        long j3 = unsafe.getLong(obj, j);
                        ((zzdk) zzfeVar.zzb).zzu(i15, (j3 + j3) ^ (j3 >> 63));
                    }
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 17:
                    if (zzfpVar.zzJ(obj, i12, i, i2, i3)) {
                        zzfeVar.zzq(i15, unsafe.getObject(obj, j), zzfpVar.zzv(i12));
                    }
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 18:
                    zzgg.zzr(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, false);
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 19:
                    zzgg.zzv(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, false);
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 20:
                    zzgg.zzx(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, false);
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 21:
                    zzgg.zzD(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, false);
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 22:
                    zzgg.zzw(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, false);
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 23:
                    zzgg.zzu(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, false);
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 24:
                    zzgg.zzt(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, false);
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 25:
                    zzgg.zzq(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, false);
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 26:
                    i4 = iArr[i12];
                    list = (List) unsafe.getObject(obj, j);
                    zzea zzeaVar6 = zzgg.zzb;
                    if (list != null) {
                        zzfeVar.getClass();
                        while (i5 < list.size()) {
                            ((zzdk) zzfeVar.zzb).zzp((String) list.get(i5), i4);
                        }
                    }
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 27:
                    i6 = iArr[i12];
                    list2 = (List) unsafe.getObject(obj, j);
                    zzgeVarZzv = zzfpVar.zzv(i12);
                    zzea zzeaVar7 = zzgg.zzb;
                    if (list2 != null) {
                        while (i7 < list2.size()) {
                            zzfeVar.zzv(i6, list2.get(i7), zzgeVarZzv);
                        }
                    }
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 28:
                    i8 = iArr[i12];
                    list3 = (List) unsafe.getObject(obj, j);
                    zzea zzeaVar8 = zzgg.zzb;
                    if (list3 != null) {
                        zzfeVar.getClass();
                        while (i9 < list3.size()) {
                            ((zzdk) zzfeVar.zzb).zze(i8, (zzdf) list3.get(i9));
                        }
                    }
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 29:
                    z2 = false;
                    zzgg.zzC(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, false);
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 30:
                    z2 = false;
                    zzgg.zzs(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, false);
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 31:
                    z2 = false;
                    zzgg.zzy(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, false);
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 32:
                    z2 = false;
                    zzgg.zzz(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, false);
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 33:
                    z2 = false;
                    zzgg.zzA(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, false);
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 34:
                    z2 = false;
                    zzgg.zzB(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, false);
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 35:
                    zzgg.zzr(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, z);
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 36:
                    zzgg.zzv(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, z);
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 37:
                    zzgg.zzx(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, z);
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 38:
                    zzgg.zzD(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, z);
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 39:
                    zzgg.zzw(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, z);
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 40:
                    zzgg.zzu(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, z);
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 41:
                    zzgg.zzt(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, z);
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 42:
                    zzgg.zzq(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, z);
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 43:
                    zzgg.zzC(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, z);
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 44:
                    zzgg.zzs(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, z);
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 45:
                    zzgg.zzy(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, z);
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 46:
                    zzgg.zzz(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, z);
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 47:
                    zzgg.zzA(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, z);
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 48:
                    zzgg.zzB(iArr[i12], (List) unsafe.getObject(obj, j), zzfeVar, z);
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 49:
                    i10 = iArr[i12];
                    list4 = (List) unsafe.getObject(obj, j);
                    zzgeVarZzv2 = zzfpVar.zzv(i12);
                    zzea zzeaVar9 = zzgg.zzb;
                    if (list4 != null) {
                        while (i11 < list4.size()) {
                            zzfeVar.zzq(i10, list4.get(i11), zzgeVarZzv2);
                        }
                    }
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 50:
                    if (unsafe.getObject(obj, j) != null) {
                        int i21 = i12 / 3;
                        throw ImageAnalysis$$ExternalSyntheticLambda1.m(zzfpVar.zzd[i21 + i21]);
                    }
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 51:
                    if (zzfpVar.zzM(i15, i12, obj)) {
                        ((zzdk) zzfeVar.zzb).zzh(i15, Double.doubleToRawLongBits(((Double) zzgz.zzf(j, obj)).doubleValue()));
                    }
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 52:
                    if (zzfpVar.zzM(i15, i12, obj)) {
                        ((zzdk) zzfeVar.zzb).zzf(i15, Float.floatToRawIntBits(((Float) zzgz.zzf(j, obj)).floatValue()));
                    }
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 53:
                    if (zzfpVar.zzM(i15, i12, obj)) {
                        ((zzdk) zzfeVar.zzb).zzu(i15, zzt(j, obj));
                    }
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 54:
                    if (zzfpVar.zzM(i15, i12, obj)) {
                        ((zzdk) zzfeVar.zzb).zzu(i15, zzt(j, obj));
                    }
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 55:
                    if (zzfpVar.zzM(i15, i12, obj)) {
                        ((zzdk) zzfeVar.zzb).zzj(i15, zzo(j, obj));
                    }
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 56:
                    if (zzfpVar.zzM(i15, i12, obj)) {
                        ((zzdk) zzfeVar.zzb).zzh(i15, zzt(j, obj));
                    }
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 57:
                    if (zzfpVar.zzM(i15, i12, obj)) {
                        ((zzdk) zzfeVar.zzb).zzf(i15, zzo(j, obj));
                    }
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 58:
                    if (zzfpVar.zzM(i15, i12, obj)) {
                        boolean zBooleanValue2 = ((Boolean) zzgz.zzf(j, obj)).booleanValue();
                        zzdk zzdkVar4 = (zzdk) zzfeVar.zzb;
                        zzdkVar4.zzt(i15 << 3);
                        zzdkVar4.zzb(zBooleanValue2 ? (byte) 1 : (byte) 0);
                    }
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 59:
                    if (zzfpVar.zzM(i15, i12, obj)) {
                        object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof String) {
                            ((zzdk) zzfeVar.zzb).zzp((String) object2, i15);
                        } else {
                            ((zzdk) zzfeVar.zzb).zze(i15, (zzdf) object2);
                        }
                    }
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 60:
                    if (zzfpVar.zzM(i15, i12, obj)) {
                        zzfeVar.zzv(i15, unsafe.getObject(obj, j), zzfpVar.zzv(i12));
                    }
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 61:
                    if (zzfpVar.zzM(i15, i12, obj)) {
                        ((zzdk) zzfeVar.zzb).zze(i15, (zzdf) unsafe.getObject(obj, j));
                    }
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 62:
                    if (zzfpVar.zzM(i15, i12, obj)) {
                        ((zzdk) zzfeVar.zzb).zzs(i15, zzo(j, obj));
                    }
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 63:
                    if (zzfpVar.zzM(i15, i12, obj)) {
                        ((zzdk) zzfeVar.zzb).zzj(i15, zzo(j, obj));
                    }
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 64:
                    if (zzfpVar.zzM(i15, i12, obj)) {
                        ((zzdk) zzfeVar.zzb).zzf(i15, zzo(j, obj));
                    }
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 65:
                    if (zzfpVar.zzM(i15, i12, obj)) {
                        ((zzdk) zzfeVar.zzb).zzh(i15, zzt(j, obj));
                    }
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 66:
                    if (zzfpVar.zzM(i15, i12, obj)) {
                        int iZzo2 = zzo(j, obj);
                        ((zzdk) zzfeVar.zzb).zzs(i15, (iZzo2 >> 31) ^ (iZzo2 + iZzo2));
                    }
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 67:
                    if (zzfpVar.zzM(i15, i12, obj)) {
                        long jZzt2 = zzt(j, obj);
                        ((zzdk) zzfeVar.zzb).zzu(i15, (jZzt2 >> 63) ^ (jZzt2 + jZzt2));
                    }
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                case 68:
                    if (zzfpVar.zzM(i15, i12, obj)) {
                        zzfeVar.zzq(i15, unsafe.getObject(obj, j), zzfpVar.zzv(i12));
                    }
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
                default:
                    i12 += 3;
                    zzfpVar = this;
                    i14 = i2;
                    i13 = i;
                    entry = entry2;
                    break;
            }
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final boolean zzj(zzeh zzehVar, zzeh zzehVar2) {
        boolean zZzE;
        int i = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i < iArr.length) {
                int iZzs = zzs(i);
                long j = iZzs & 1048575;
                switch (zzr(iZzs)) {
                    case 0:
                        if (zzH(zzehVar, zzehVar2, i)) {
                            zzgy zzgyVar = zzgz.zzf;
                            if (Double.doubleToLongBits(zzgyVar.zza(j, zzehVar)) == Double.doubleToLongBits(zzgyVar.zza(j, zzehVar2))) {
                                continue;
                                i += 3;
                            }
                        }
                        break;
                    case 1:
                        if (zzH(zzehVar, zzehVar2, i)) {
                            zzgy zzgyVar2 = zzgz.zzf;
                            if (Float.floatToIntBits(zzgyVar2.zzb(j, zzehVar)) == Float.floatToIntBits(zzgyVar2.zzb(j, zzehVar2))) {
                                continue;
                                i += 3;
                            }
                        }
                        break;
                    case 2:
                        if (zzH(zzehVar, zzehVar2, i) && zzgz.zzd(j, zzehVar) == zzgz.zzd(j, zzehVar2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 3:
                        if (zzH(zzehVar, zzehVar2, i) && zzgz.zzd(j, zzehVar) == zzgz.zzd(j, zzehVar2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 4:
                        if (zzH(zzehVar, zzehVar2, i) && zzgz.zzc(j, zzehVar) == zzgz.zzc(j, zzehVar2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 5:
                        if (zzH(zzehVar, zzehVar2, i) && zzgz.zzd(j, zzehVar) == zzgz.zzd(j, zzehVar2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 6:
                        if (zzH(zzehVar, zzehVar2, i) && zzgz.zzc(j, zzehVar) == zzgz.zzc(j, zzehVar2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 7:
                        if (zzH(zzehVar, zzehVar2, i)) {
                            zzgy zzgyVar3 = zzgz.zzf;
                            if (zzgyVar3.zzg(j, zzehVar) == zzgyVar3.zzg(j, zzehVar2)) {
                                continue;
                                i += 3;
                            }
                        }
                        break;
                    case 8:
                        if (zzH(zzehVar, zzehVar2, i) && zzgg.zzE(zzgz.zzf(j, zzehVar), zzgz.zzf(j, zzehVar2))) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 9:
                        if (zzH(zzehVar, zzehVar2, i) && zzgg.zzE(zzgz.zzf(j, zzehVar), zzgz.zzf(j, zzehVar2))) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 10:
                        if (zzH(zzehVar, zzehVar2, i) && zzgg.zzE(zzgz.zzf(j, zzehVar), zzgz.zzf(j, zzehVar2))) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 11:
                        if (zzH(zzehVar, zzehVar2, i) && zzgz.zzc(j, zzehVar) == zzgz.zzc(j, zzehVar2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 12:
                        if (zzH(zzehVar, zzehVar2, i) && zzgz.zzc(j, zzehVar) == zzgz.zzc(j, zzehVar2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 13:
                        if (zzH(zzehVar, zzehVar2, i) && zzgz.zzc(j, zzehVar) == zzgz.zzc(j, zzehVar2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 14:
                        if (zzH(zzehVar, zzehVar2, i) && zzgz.zzd(j, zzehVar) == zzgz.zzd(j, zzehVar2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 15:
                        if (zzH(zzehVar, zzehVar2, i) && zzgz.zzc(j, zzehVar) == zzgz.zzc(j, zzehVar2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 16:
                        if (zzH(zzehVar, zzehVar2, i) && zzgz.zzd(j, zzehVar) == zzgz.zzd(j, zzehVar2)) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 17:
                        if (zzH(zzehVar, zzehVar2, i) && zzgg.zzE(zzgz.zzf(j, zzehVar), zzgz.zzf(j, zzehVar2))) {
                            continue;
                            i += 3;
                        }
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        zZzE = zzgg.zzE(zzgz.zzf(j, zzehVar), zzgz.zzf(j, zzehVar2));
                        break;
                    case 50:
                        zZzE = zzgg.zzE(zzgz.zzf(j, zzehVar), zzgz.zzf(j, zzehVar2));
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                        long j2 = iArr[i + 2] & 1048575;
                        if (zzgz.zzc(j2, zzehVar) == zzgz.zzc(j2, zzehVar2) && zzgg.zzE(zzgz.zzf(j, zzehVar), zzgz.zzf(j, zzehVar2))) {
                            continue;
                            i += 3;
                        }
                        break;
                    default:
                        continue;
                        i += 3;
                        break;
                }
                if (zZzE) {
                    i += 3;
                }
            } else if (zzehVar.zzc.equals(zzehVar2.zzc)) {
                if (this.zzh) {
                    return ((zzed) zzehVar).zzb.equals(((zzed) zzehVar2).zzb);
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzge
    public final boolean zzk(Object obj) {
        int i;
        int i2;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1048575;
        while (i4 < this.zzj) {
            int i6 = this.zzi[i4];
            int[] iArr = this.zzc;
            int i7 = iArr[i6];
            int iZzs = zzs(i6);
            int i8 = iArr[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i5) {
                if (i9 != 1048575) {
                    i3 = zzb.getInt(obj, i9);
                }
                i2 = i3;
                i = i9;
            } else {
                int i11 = i3;
                i = i5;
                i2 = i11;
            }
            if ((268435456 & iZzs) == 0 || zzJ(obj, i6, i, i2, i10)) {
                int iZzr = zzr(iZzs);
                if (iZzr != 9 && iZzr != 17) {
                    if (iZzr != 27) {
                        if (iZzr == 60 || iZzr == 68) {
                            if (!zzM(i7, i6, obj) || zzv(i6).zzk(zzgz.zzf(iZzs & 1048575, obj))) {
                            }
                        } else if (iZzr != 49) {
                            if (iZzr == 50 && !((zzfg) zzgz.zzf(iZzs & 1048575, obj)).isEmpty()) {
                                int i12 = i6 / 3;
                                throw ImageAnalysis$$ExternalSyntheticLambda1.m(this.zzd[i12 + i12]);
                            }
                        }
                        i4++;
                        i5 = i;
                        i3 = i2;
                    }
                    List list = (List) zzgz.zzf(iZzs & 1048575, obj);
                    if (list.isEmpty()) {
                        continue;
                    } else {
                        zzge zzgeVarZzv = zzv(i6);
                        for (int i13 = 0; i13 < list.size(); i13++) {
                            if (zzgeVarZzv.zzk(list.get(i13))) {
                            }
                        }
                    }
                    i4++;
                    i5 = i;
                    i3 = i2;
                } else if (!zzJ(obj, i6, i, i2, i10) || zzv(i6).zzk(zzgz.zzf(iZzs & 1048575, obj))) {
                    i4++;
                    i5 = i;
                    i3 = i2;
                }
            }
        }
        return !this.zzh || ((zzed) obj).zzb.zzk();
    }

    public final int zzq(int i, int i2) {
        int[] iArr = this.zzc;
        int length = (iArr.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = iArr[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    public final int zzs(int i) {
        return this.zzc[i + 1];
    }

    public final zzel zzu(int i) {
        int i2 = i / 3;
        return (zzel) this.zzd[i2 + i2 + 1];
    }

    public final zzge zzv(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        Object[] objArr = this.zzd;
        zzge zzgeVar = (zzge) objArr[i3];
        if (zzgeVar != null) {
            return zzgeVar;
        }
        zzge zzgeVarZzb = zzfu.zzb.zzb((Class) objArr[i3 + 1]);
        objArr[i3] = zzgeVarZzb;
        return zzgeVarZzb;
    }

    public final Object zzx(int i, Object obj) {
        zzge zzgeVarZzv = zzv(i);
        int iZzs = zzs(i) & 1048575;
        if (!zzI(i, obj)) {
            return zzgeVarZzv.zze();
        }
        Object object = zzb.getObject(obj, iZzs);
        if (zzL(object)) {
            return object;
        }
        Object objZze = zzgeVarZzv.zze();
        if (object != null) {
            zzgeVarZzv.zzg(objZze, object);
        }
        return objZze;
    }

    public final Object zzy(int i, int i2, Object obj) {
        zzge zzgeVarZzv = zzv(i2);
        if (!zzM(i, i2, obj)) {
            return zzgeVarZzv.zze();
        }
        Object object = zzb.getObject(obj, zzs(i2) & 1048575);
        if (zzL(object)) {
            return object;
        }
        Object objZze = zzgeVarZzv.zze();
        if (object != null) {
            zzgeVarZzv.zzg(objZze, object);
        }
        return objZze;
    }
}
