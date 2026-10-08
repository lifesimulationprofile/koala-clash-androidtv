package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF2' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzhf {
    public static final zzhf zzj;
    public static final zzhf zzn;
    public static final /* synthetic */ zzhf[] zzs;
    public final zzhg zzt;

    /* JADX INFO: Fake field, exist only in values array */
    zzhf EF0;

    /* JADX INFO: Fake field, exist only in values array */
    zzhf EF1;

    /* JADX INFO: Fake field, exist only in values array */
    zzhf EF2;

    static {
        zzhf zzhfVar = new zzhf("DOUBLE", 0, zzhg.zzd);
        zzhf zzhfVar2 = new zzhf("FLOAT", 1, zzhg.zzc);
        zzhg zzhgVar = zzhg.zzb;
        zzhf zzhfVar3 = new zzhf("INT64", 2, zzhgVar);
        zzhf zzhfVar4 = new zzhf("UINT64", 3, zzhgVar);
        zzhg zzhgVar2 = zzhg.zza;
        zzhf zzhfVar5 = new zzhf("INT32", 4, zzhgVar2);
        zzhf zzhfVar6 = new zzhf("FIXED64", 5, zzhgVar);
        zzhf zzhfVar7 = new zzhf("FIXED32", 6, zzhgVar2);
        zzhf zzhfVar8 = new zzhf("BOOL", 7, zzhg.zze);
        zzhf zzhfVar9 = new zzhf("STRING", 8, zzhg.zzf);
        zzhg zzhgVar3 = zzhg.zzi;
        zzhf zzhfVar10 = new zzhf("GROUP", 9, zzhgVar3);
        zzj = zzhfVar10;
        zzhf zzhfVar11 = new zzhf("MESSAGE", 10, zzhgVar3);
        zzhf zzhfVar12 = new zzhf("BYTES", 11, zzhg.zzg);
        zzhf zzhfVar13 = new zzhf("UINT32", 12, zzhgVar2);
        zzhf zzhfVar14 = new zzhf("ENUM", 13, zzhg.zzh);
        zzn = zzhfVar14;
        zzs = new zzhf[]{zzhfVar, zzhfVar2, zzhfVar3, zzhfVar4, zzhfVar5, zzhfVar6, zzhfVar7, zzhfVar8, zzhfVar9, zzhfVar10, zzhfVar11, zzhfVar12, zzhfVar13, zzhfVar14, new zzhf("SFIXED32", 14, zzhgVar2), new zzhf("SFIXED64", 15, zzhgVar), new zzhf("SINT32", 16, zzhgVar2), new zzhf("SINT64", 17, zzhgVar)};
    }

    public zzhf(String str, int i, zzhg zzhgVar) {
        super(str, i);
        this.zzt = zzhgVar;
    }

    public static zzhf[] values() {
        return (zzhf[]) zzs.clone();
    }
}
