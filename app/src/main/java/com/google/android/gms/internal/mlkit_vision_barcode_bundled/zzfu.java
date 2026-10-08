package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzfu {
    public static final zzfu zzb = new zzfu();
    public final ConcurrentHashMap zzd = new ConcurrentHashMap();
    public final zzfe zzc = new zzfe(0);

    public final zzge zzb(Class cls) {
        zzge zzgeVarZzl;
        Charset charset = zzep.zza;
        if (cls == null) {
            throw new NullPointerException("messageType");
        }
        ConcurrentHashMap concurrentHashMap = this.zzd;
        zzge zzgeVar = (zzge) concurrentHashMap.get(cls);
        if (zzgeVar != null) {
            return zzgeVar;
        }
        zzfe zzfeVar = this.zzc;
        zzfeVar.getClass();
        zzea zzeaVar = zzgg.zzb;
        zzeh.class.isAssignableFrom(cls);
        zzfw zzfwVarZzb = ((zzfe) zzfeVar.zzb).zzb(cls);
        if ((zzfwVarZzb.zzd & 2) == 2) {
            zzea zzeaVar2 = zzgg.zzb;
            zzea zzeaVar3 = zzdv.zza;
            zzgeVarZzl = new zzfq(zzeaVar2, zzfwVarZzb.zza);
        } else {
            int i = zzft.$r8$clinit;
            int i2 = zzfa.$r8$clinit;
            zzea zzeaVar4 = zzgg.zzb;
            zzea zzeaVar5 = zzfwVarZzb.zzc() + (-1) != 1 ? zzdv.zza : null;
            int i3 = zzfi.$r8$clinit;
            zzgeVarZzl = zzfp.zzl(zzfwVarZzb, zzeaVar4, zzeaVar5);
        }
        zzge zzgeVar2 = (zzge) concurrentHashMap.putIfAbsent(cls, zzgeVarZzl);
        return zzgeVar2 == null ? zzgeVarZzl : zzgeVar2;
    }
}
