package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzeh extends zzcq {
    private static final Map zzb = new ConcurrentHashMap();
    protected zzgt zzc;
    private int zzd;

    public zzeh() {
        this.zza = 0;
        this.zzd = -1;
        this.zzc = zzgt.zza;
    }

    public static zzeh zzJ(Class cls) {
        Map map = zzb;
        zzeh zzehVar = (zzeh) map.get(cls);
        if (zzehVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzehVar = (zzeh) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzehVar != null) {
            return zzehVar;
        }
        zzeh zzehVar2 = (zzeh) ((zzeh) zzgz.zze(cls)).zzg(6, null);
        if (zzehVar2 == null) {
            throw new IllegalStateException();
        }
        map.put(cls, zzehVar2);
        return zzehVar2;
    }

    public static Object zzR(Method method, zzeh zzehVar, Object... objArr) {
        try {
            return method.invoke(zzehVar, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static void zzV(Class cls, zzeh zzehVar) {
        zzehVar.zzU();
        zzb.put(cls, zzehVar);
    }

    public static final boolean zzX(zzeh zzehVar, boolean z) {
        byte bByteValue = ((Byte) zzehVar.zzg(1, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzk = zzfu.zzb.zzb(zzehVar.getClass()).zzk(zzehVar);
        if (z) {
            zzehVar.zzg(2, true == zZzk ? zzehVar : null);
        }
        return zZzk;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzfu.zzb.zzb(getClass()).zzj(this, (zzeh) obj);
    }

    public final int hashCode() {
        if (zzY()) {
            return zzfu.zzb.zzb(getClass()).zzb(this);
        }
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int iZzb = zzfu.zzb.zzb(getClass()).zzb(this);
        this.zza = iZzb;
        return iZzb;
    }

    public final String toString() {
        String string = super.toString();
        char[] cArr = zzfo.zza;
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(string);
        zzfo.zzd(this, sb, 0);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcq
    public final int zzB(zzge zzgeVar) {
        if (zzY()) {
            int iZza = zzgeVar.zza(this);
            if (iZza >= 0) {
                return iZza;
            }
            throw new IllegalStateException(ImageAnalysis$$ExternalSyntheticLambda1.m("serialized size must be non-negative, was ", iZza));
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iZza2 = zzgeVar.zza(this);
        if (iZza2 < 0) {
            throw new IllegalStateException(ImageAnalysis$$ExternalSyntheticLambda1.m("serialized size must be non-negative, was ", iZza2));
        }
        this.zzd = (this.zzd & Integer.MIN_VALUE) | iZza2;
        return iZza2;
    }

    public final int zzF() {
        if (zzY()) {
            int iZza = zzfu.zzb.zzb(getClass()).zza(this);
            if (iZza >= 0) {
                return iZza;
            }
            throw new IllegalStateException(ImageAnalysis$$ExternalSyntheticLambda1.m("serialized size must be non-negative, was ", iZza));
        }
        int i = this.zzd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iZza2 = zzfu.zzb.zzb(getClass()).zza(this);
        if (iZza2 < 0) {
            throw new IllegalStateException(ImageAnalysis$$ExternalSyntheticLambda1.m("serialized size must be non-negative, was ", iZza2));
        }
        this.zzd = (this.zzd & Integer.MIN_VALUE) | iZza2;
        return iZza2;
    }

    public final zzeb zzG() {
        return (zzeb) zzg(5, null);
    }

    public final void zzU() {
        this.zzd &= Integer.MAX_VALUE;
    }

    public final void zzW() {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    public final boolean zzY() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    public final void zzab(zzdk zzdkVar) {
        zzge zzgeVarZzb = zzfu.zzb.zzb(getClass());
        zzfe zzfeVar = zzdkVar.zza;
        if (zzfeVar == null) {
            zzfeVar = new zzfe(zzdkVar);
        }
        zzgeVarZzb.zzi(this, zzfeVar);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn
    public final boolean zzad() {
        return zzX(this, true);
    }

    public abstract Object zzg(int i, zzeh zzehVar);
}
