package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzgg {
    public static final zzea zzb;

    static {
        zzfu zzfuVar = zzfu.zzb;
        zzb = new zzea(6);
    }

    public static void zzA(int i, List list, zzfe zzfeVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzdk zzdkVar = (zzdk) zzfeVar.zzb;
        int i2 = 0;
        if (!(list instanceof zzei)) {
            if (!z) {
                while (i2 < list.size()) {
                    int iIntValue = ((Integer) list.get(i2)).intValue();
                    zzdkVar.zzs(i, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                    i2++;
                }
                return;
            }
            zzdkVar.zzr(i, 2);
            int iZzA = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                int iIntValue2 = ((Integer) list.get(i3)).intValue();
                iZzA += zzdk.zzA((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
            }
            zzdkVar.zzt(iZzA);
            while (i2 < list.size()) {
                int iIntValue3 = ((Integer) list.get(i2)).intValue();
                zzdkVar.zzt((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
                i2++;
            }
            return;
        }
        zzei zzeiVar = (zzei) list;
        if (!z) {
            while (i2 < zzeiVar.zzc) {
                int iZze = zzeiVar.zze(i2);
                zzdkVar.zzs(i, (iZze >> 31) ^ (iZze + iZze));
                i2++;
            }
            return;
        }
        zzdkVar.zzr(i, 2);
        int iZzA2 = 0;
        for (int i4 = 0; i4 < zzeiVar.zzc; i4++) {
            int iZze2 = zzeiVar.zze(i4);
            iZzA2 += zzdk.zzA((iZze2 >> 31) ^ (iZze2 + iZze2));
        }
        zzdkVar.zzt(iZzA2);
        while (i2 < zzeiVar.zzc) {
            int iZze3 = zzeiVar.zze(i2);
            zzdkVar.zzt((iZze3 >> 31) ^ (iZze3 + iZze3));
            i2++;
        }
    }

    public static void zzB(int i, List list, zzfe zzfeVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzdk zzdkVar = (zzdk) zzfeVar.zzb;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                long jLongValue = ((Long) list.get(i2)).longValue();
                zzdkVar.zzu(i, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                i2++;
            }
            return;
        }
        zzdkVar.zzr(i, 2);
        int iZzB = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            long jLongValue2 = ((Long) list.get(i3)).longValue();
            iZzB += zzdk.zzB((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
        }
        zzdkVar.zzt(iZzB);
        while (i2 < list.size()) {
            long jLongValue3 = ((Long) list.get(i2)).longValue();
            zzdkVar.zzv((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
            i2++;
        }
    }

    public static void zzC(int i, List list, zzfe zzfeVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzdk zzdkVar = (zzdk) zzfeVar.zzb;
        int i2 = 0;
        if (!(list instanceof zzei)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzdkVar.zzs(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzdkVar.zzr(i, 2);
            int iZzA = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzA += zzdk.zzA(((Integer) list.get(i3)).intValue());
            }
            zzdkVar.zzt(iZzA);
            while (i2 < list.size()) {
                zzdkVar.zzt(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzei zzeiVar = (zzei) list;
        if (!z) {
            while (i2 < zzeiVar.zzc) {
                zzdkVar.zzs(i, zzeiVar.zze(i2));
                i2++;
            }
            return;
        }
        zzdkVar.zzr(i, 2);
        int iZzA2 = 0;
        for (int i4 = 0; i4 < zzeiVar.zzc; i4++) {
            iZzA2 += zzdk.zzA(zzeiVar.zze(i4));
        }
        zzdkVar.zzt(iZzA2);
        while (i2 < zzeiVar.zzc) {
            zzdkVar.zzt(zzeiVar.zze(i2));
            i2++;
        }
    }

    public static void zzD(int i, List list, zzfe zzfeVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzdk zzdkVar = (zzdk) zzfeVar.zzb;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                zzdkVar.zzu(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzdkVar.zzr(i, 2);
        int iZzB = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzB += zzdk.zzB(((Long) list.get(i3)).longValue());
        }
        zzdkVar.zzt(iZzB);
        while (i2 < list.size()) {
            zzdkVar.zzv(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static boolean zzE(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int zza(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzei)) {
            int iZzB = 0;
            while (i < size) {
                iZzB += zzdk.zzB(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZzB;
        }
        zzei zzeiVar = (zzei) list;
        int iZzB2 = 0;
        while (i < size) {
            iZzB2 += zzdk.zzB(zzeiVar.zze(i));
            i++;
        }
        return iZzB2;
    }

    public static int zzb(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzdk.zzA(i << 3) + 4) * size;
    }

    public static int zzd(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (zzdk.zzA(i << 3) + 8) * size;
    }

    public static int zzf(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzei)) {
            int iZzB = 0;
            while (i < size) {
                iZzB += zzdk.zzB(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZzB;
        }
        zzei zzeiVar = (zzei) list;
        int iZzB2 = 0;
        while (i < size) {
            iZzB2 += zzdk.zzB(zzeiVar.zze(i));
            i++;
        }
        return iZzB2;
    }

    public static int zzg(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzB = 0;
        for (int i = 0; i < size; i++) {
            iZzB += zzdk.zzB(((Long) list.get(i)).longValue());
        }
        return iZzB;
    }

    public static int zzi(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzei)) {
            int iZzA = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                iZzA += zzdk.zzA((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i++;
            }
            return iZzA;
        }
        zzei zzeiVar = (zzei) list;
        int iZzA2 = 0;
        while (i < size) {
            int iZze = zzeiVar.zze(i);
            iZzA2 += zzdk.zzA((iZze >> 31) ^ (iZze + iZze));
            i++;
        }
        return iZzA2;
    }

    public static int zzj(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzB = 0;
        for (int i = 0; i < size; i++) {
            long jLongValue = ((Long) list.get(i)).longValue();
            iZzB += zzdk.zzB((jLongValue >> 63) ^ (jLongValue + jLongValue));
        }
        return iZzB;
    }

    public static int zzk(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzei)) {
            int iZzA = 0;
            while (i < size) {
                iZzA += zzdk.zzA(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZzA;
        }
        zzei zzeiVar = (zzei) list;
        int iZzA2 = 0;
        while (i < size) {
            iZzA2 += zzdk.zzA(zzeiVar.zze(i));
            i++;
        }
        return iZzA2;
    }

    public static int zzl(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzB = 0;
        for (int i = 0; i < size; i++) {
            iZzB += zzdk.zzB(((Long) list.get(i)).longValue());
        }
        return iZzB;
    }

    public static Object zzn(int i, int i2, Object obj, Object obj2) {
        zzeh zzehVar;
        zzgt zzgtVar;
        Object obj3 = obj2;
        if (obj2 == null && (zzgtVar = (zzehVar = (zzeh) obj).zzc) == zzgt.zza) {
            obj3 = zzgtVar;
            zzgt zzgtVarZzf = zzgt.zzf();
            zzehVar.zzc = zzgtVarZzf;
            obj3 = zzgtVarZzf;
        }
        obj3 = zzgtVar;
        ((zzgt) obj3).zzj(i << 3, Long.valueOf(i2));
        return obj3;
    }

    public static void zzo(Object obj, Object obj2) {
        zzdx zzdxVar = ((zzed) obj2).zzb;
        if (zzdxVar.zza.isEmpty()) {
            return;
        }
        zzed zzedVar = (zzed) obj;
        zzdx zzdxVar2 = zzedVar.zzb;
        if (zzdxVar2.zzc) {
            zzedVar.zzb = zzdxVar2.clone();
        }
        zzdx zzdxVar3 = zzedVar.zzb;
        zzdxVar3.getClass();
        zzgh zzghVar = zzdxVar.zza;
        int i = zzghVar.zzb;
        for (int i2 = 0; i2 < i; i2++) {
            zzdxVar3.zzm(zzghVar.zzg(i2));
        }
        Iterator it = zzghVar.zzd().iterator();
        while (it.hasNext()) {
            zzdxVar3.zzm((Map.Entry) it.next());
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void zzp(Object obj, Object obj2) {
        zzeh zzehVar = (zzeh) obj;
        zzgt zzgtVar = zzehVar.zzc;
        zzgt zzgtVar2 = ((zzeh) obj2).zzc;
        zzgt zzgtVar3 = zzgt.zza;
        if (!zzgtVar3.equals(zzgtVar2)) {
            if (zzgtVar3.equals(zzgtVar)) {
                int i = zzgtVar.zzb + zzgtVar2.zzb;
                int[] iArrCopyOf = Arrays.copyOf(zzgtVar.zzc, i);
                System.arraycopy(zzgtVar2.zzc, 0, iArrCopyOf, zzgtVar.zzb, zzgtVar2.zzb);
                Object[] objArrCopyOf = Arrays.copyOf(zzgtVar.zzd, i);
                System.arraycopy(zzgtVar2.zzd, 0, objArrCopyOf, zzgtVar.zzb, zzgtVar2.zzb);
                zzgtVar = new zzgt(i, iArrCopyOf, objArrCopyOf, true);
            } else {
                zzgtVar.getClass();
                if (!zzgtVar2.equals(zzgtVar3)) {
                    if (!zzgtVar.zzf) {
                        throw new UnsupportedOperationException();
                    }
                    int i2 = zzgtVar.zzb + zzgtVar2.zzb;
                    zzgtVar.zzm(i2);
                    System.arraycopy(zzgtVar2.zzc, 0, zzgtVar.zzc, zzgtVar.zzb, zzgtVar2.zzb);
                    System.arraycopy(zzgtVar2.zzd, 0, zzgtVar.zzd, zzgtVar.zzb, zzgtVar2.zzb);
                    zzgtVar.zzb = i2;
                }
            }
        }
        zzehVar.zzc = zzgtVar;
    }

    public static void zzq(int i, List list, zzfe zzfeVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzdk zzdkVar = (zzdk) zzfeVar.zzb;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                boolean zBooleanValue = ((Boolean) list.get(i2)).booleanValue();
                zzdkVar.zzt(i << 3);
                zzdkVar.zzb(zBooleanValue ? (byte) 1 : (byte) 0);
                i2++;
            }
            return;
        }
        zzdkVar.zzr(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Boolean) list.get(i4)).getClass();
            i3++;
        }
        zzdkVar.zzt(i3);
        while (i2 < list.size()) {
            zzdkVar.zzb(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    public static void zzr(int i, List list, zzfe zzfeVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzdk zzdkVar = (zzdk) zzfeVar.zzb;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                zzdkVar.zzh(i, Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
                i2++;
            }
            return;
        }
        zzdkVar.zzr(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Double) list.get(i4)).getClass();
            i3 += 8;
        }
        zzdkVar.zzt(i3);
        while (i2 < list.size()) {
            zzdkVar.zzi(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
            i2++;
        }
    }

    public static void zzs(int i, List list, zzfe zzfeVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzdk zzdkVar = (zzdk) zzfeVar.zzb;
        int i2 = 0;
        if (!(list instanceof zzei)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzdkVar.zzj(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzdkVar.zzr(i, 2);
            int iZzB = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzB += zzdk.zzB(((Integer) list.get(i3)).intValue());
            }
            zzdkVar.zzt(iZzB);
            while (i2 < list.size()) {
                zzdkVar.zzk(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzei zzeiVar = (zzei) list;
        if (!z) {
            while (i2 < zzeiVar.zzc) {
                zzdkVar.zzj(i, zzeiVar.zze(i2));
                i2++;
            }
            return;
        }
        zzdkVar.zzr(i, 2);
        int iZzB2 = 0;
        for (int i4 = 0; i4 < zzeiVar.zzc; i4++) {
            iZzB2 += zzdk.zzB(zzeiVar.zze(i4));
        }
        zzdkVar.zzt(iZzB2);
        while (i2 < zzeiVar.zzc) {
            zzdkVar.zzk(zzeiVar.zze(i2));
            i2++;
        }
    }

    public static void zzt(int i, List list, zzfe zzfeVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzdk zzdkVar = (zzdk) zzfeVar.zzb;
        int i2 = 0;
        if (!(list instanceof zzei)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzdkVar.zzf(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzdkVar.zzr(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).getClass();
                i3 += 4;
            }
            zzdkVar.zzt(i3);
            while (i2 < list.size()) {
                zzdkVar.zzg(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzei zzeiVar = (zzei) list;
        if (!z) {
            while (i2 < zzeiVar.zzc) {
                zzdkVar.zzf(i, zzeiVar.zze(i2));
                i2++;
            }
            return;
        }
        zzdkVar.zzr(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzeiVar.zzc; i6++) {
            zzeiVar.zze(i6);
            i5 += 4;
        }
        zzdkVar.zzt(i5);
        while (i2 < zzeiVar.zzc) {
            zzdkVar.zzg(zzeiVar.zze(i2));
            i2++;
        }
    }

    public static void zzu(int i, List list, zzfe zzfeVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzdk zzdkVar = (zzdk) zzfeVar.zzb;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                zzdkVar.zzh(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzdkVar.zzr(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).getClass();
            i3 += 8;
        }
        zzdkVar.zzt(i3);
        while (i2 < list.size()) {
            zzdkVar.zzi(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static void zzv(int i, List list, zzfe zzfeVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzdk zzdkVar = (zzdk) zzfeVar.zzb;
        int i2 = 0;
        if (!(list instanceof zzdz)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzdkVar.zzf(i, Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                    i2++;
                }
                return;
            }
            zzdkVar.zzr(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Float) list.get(i4)).getClass();
                i3 += 4;
            }
            zzdkVar.zzt(i3);
            while (i2 < list.size()) {
                zzdkVar.zzg(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
                i2++;
            }
            return;
        }
        zzdz zzdzVar = (zzdz) list;
        if (!z) {
            while (i2 < zzdzVar.zzc) {
                zzdzVar.zzj(i2);
                zzdkVar.zzf(i, Float.floatToRawIntBits(zzdzVar.zzb[i2]));
                i2++;
            }
            return;
        }
        zzdkVar.zzr(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzdzVar.zzc; i6++) {
            zzdzVar.zzj(i6);
            float f = zzdzVar.zzb[i6];
            i5 += 4;
        }
        zzdkVar.zzt(i5);
        while (i2 < zzdzVar.zzc) {
            zzdzVar.zzj(i2);
            zzdkVar.zzg(Float.floatToRawIntBits(zzdzVar.zzb[i2]));
            i2++;
        }
    }

    public static void zzw(int i, List list, zzfe zzfeVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzdk zzdkVar = (zzdk) zzfeVar.zzb;
        int i2 = 0;
        if (!(list instanceof zzei)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzdkVar.zzj(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzdkVar.zzr(i, 2);
            int iZzB = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzB += zzdk.zzB(((Integer) list.get(i3)).intValue());
            }
            zzdkVar.zzt(iZzB);
            while (i2 < list.size()) {
                zzdkVar.zzk(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzei zzeiVar = (zzei) list;
        if (!z) {
            while (i2 < zzeiVar.zzc) {
                zzdkVar.zzj(i, zzeiVar.zze(i2));
                i2++;
            }
            return;
        }
        zzdkVar.zzr(i, 2);
        int iZzB2 = 0;
        for (int i4 = 0; i4 < zzeiVar.zzc; i4++) {
            iZzB2 += zzdk.zzB(zzeiVar.zze(i4));
        }
        zzdkVar.zzt(iZzB2);
        while (i2 < zzeiVar.zzc) {
            zzdkVar.zzk(zzeiVar.zze(i2));
            i2++;
        }
    }

    public static void zzx(int i, List list, zzfe zzfeVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzdk zzdkVar = (zzdk) zzfeVar.zzb;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                zzdkVar.zzu(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzdkVar.zzr(i, 2);
        int iZzB = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzB += zzdk.zzB(((Long) list.get(i3)).longValue());
        }
        zzdkVar.zzt(iZzB);
        while (i2 < list.size()) {
            zzdkVar.zzv(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public static void zzy(int i, List list, zzfe zzfeVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzdk zzdkVar = (zzdk) zzfeVar.zzb;
        int i2 = 0;
        if (!(list instanceof zzei)) {
            if (!z) {
                while (i2 < list.size()) {
                    zzdkVar.zzf(i, ((Integer) list.get(i2)).intValue());
                    i2++;
                }
                return;
            }
            zzdkVar.zzr(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                ((Integer) list.get(i4)).getClass();
                i3 += 4;
            }
            zzdkVar.zzt(i3);
            while (i2 < list.size()) {
                zzdkVar.zzg(((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        zzei zzeiVar = (zzei) list;
        if (!z) {
            while (i2 < zzeiVar.zzc) {
                zzdkVar.zzf(i, zzeiVar.zze(i2));
                i2++;
            }
            return;
        }
        zzdkVar.zzr(i, 2);
        int i5 = 0;
        for (int i6 = 0; i6 < zzeiVar.zzc; i6++) {
            zzeiVar.zze(i6);
            i5 += 4;
        }
        zzdkVar.zzt(i5);
        while (i2 < zzeiVar.zzc) {
            zzdkVar.zzg(zzeiVar.zze(i2));
            i2++;
        }
    }

    public static void zzz(int i, List list, zzfe zzfeVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzdk zzdkVar = (zzdk) zzfeVar.zzb;
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                zzdkVar.zzh(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        zzdkVar.zzr(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).getClass();
            i3 += 8;
        }
        zzdkVar.zzt(i3);
        while (i2 < list.size()) {
            zzdkVar.zzi(((Long) list.get(i2)).longValue());
            i2++;
        }
    }
}
