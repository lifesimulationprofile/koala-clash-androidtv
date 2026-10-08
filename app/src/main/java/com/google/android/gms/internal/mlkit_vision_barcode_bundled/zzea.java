package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzea implements zzfk {
    public static final zzea zza = new zzea(0);
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ zzea(int i) {
        this.$r8$classId = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
    
        if (r14[r12] <= (-65)) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001e, code lost:
    
        r12 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0046, code lost:
    
        if (r14[r12] <= (-65)) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x008c, code lost:
    
        if (r14[r12] <= (-65)) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int zza(int r11, int r12, int r13, byte[] r14) {
        /*
            Method dump skipped, instruction units count: 249
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzea.zza(int, int, int, byte[]):int");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfk
    public zzfw zzb(Class cls) {
        switch (this.$r8$classId) {
            case 0:
                if (!zzeh.class.isAssignableFrom(cls)) {
                    throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
                }
                try {
                    return (zzfw) zzeh.zzJ(cls.asSubclass(zzeh.class)).zzg(3, null);
                } catch (Exception e) {
                    throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e);
                }
            default:
                throw new IllegalStateException("This should never be called.");
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfk
    public boolean zzc(Class cls) {
        switch (this.$r8$classId) {
            case 0:
                return zzeh.class.isAssignableFrom(cls);
            default:
                return false;
        }
    }

    public static void zzb(zzfe zzfeVar, Map.Entry entry) {
        zzee zzeeVar = (zzee) entry.getKey();
        zzhf zzhfVar = zzhf.zzj;
        zzeeVar.getClass();
        throw null;
    }

    public static final zzfg zza(Object obj, Object obj2) {
        zzfg zzfgVar = (zzfg) obj;
        zzfg zzfgVar2 = (zzfg) obj2;
        if (!zzfgVar2.isEmpty()) {
            if (!zzfgVar.zzb) {
                if (zzfgVar.isEmpty()) {
                    zzfgVar = new zzfg();
                } else {
                    zzfg zzfgVar3 = new zzfg(zzfgVar);
                    zzfgVar3.zzb = true;
                    zzfgVar = zzfgVar3;
                }
            }
            zzfgVar.zzg();
            if (!zzfgVar2.isEmpty()) {
                zzfgVar.putAll(zzfgVar2);
            }
        }
        return zzfgVar;
    }
}
