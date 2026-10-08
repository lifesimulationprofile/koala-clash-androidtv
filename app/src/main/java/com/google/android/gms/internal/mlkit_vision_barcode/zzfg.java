package com.google.android.gms.internal.mlkit_vision_barcode;

import androidx.compose.ui.unit.Density;
import com.google.android.gms.internal.mlkit_vision_common.zzaf;
import com.google.android.gms.internal.mlkit_vision_common.zzao;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzfg implements ObjectEncoderContext {
    public static final Charset zza = Charset.forName("UTF-8");
    public static final FieldDescriptor zzb = new FieldDescriptor("key", Density.CC.m(Density.CC.m(zzfe.class, new zzez(1))));
    public static final FieldDescriptor zzc = new FieldDescriptor("value", Density.CC.m(Density.CC.m(zzfe.class, new zzez(2))));
    public static final zzff zzd = new zzff(0);
    public OutputStream zze;
    public final HashMap zzf;
    public final HashMap zzg;
    public final ObjectEncoder zzh;
    public final zzao zzi = new zzao(this, 1);

    public zzfg(ByteArrayOutputStream byteArrayOutputStream, HashMap map, HashMap map2, ObjectEncoder objectEncoder) {
        this.zze = byteArrayOutputStream;
        this.zzf = map;
        this.zzg = map2;
        this.zzh = objectEncoder;
    }

    public static int zzh(FieldDescriptor fieldDescriptor) {
        zzfe zzfeVar = (zzfe) ((Annotation) fieldDescriptor.properties.get(zzfe.class));
        if (zzfeVar != null) {
            return ((zzez) zzfeVar).zza;
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, long j) throws IOException {
        if (j == 0) {
            return this;
        }
        zzfe zzfeVar = (zzfe) ((Annotation) fieldDescriptor.properties.get(zzfe.class));
        if (zzfeVar == null) {
            throw new EncodingException("Field has no @Protobuf config");
        }
        zzn(((zzez) zzfeVar).zza << 3);
        zzo(j);
        return this;
    }

    public final void zzc(FieldDescriptor fieldDescriptor, Object obj, boolean z) {
        if (obj == null) {
            return;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z && charSequence.length() == 0) {
                return;
            }
            zzn((zzh(fieldDescriptor) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(zza);
            zzn(bytes.length);
            this.zze.write(bytes);
            return;
        }
        if (obj instanceof Collection) {
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                zzc(fieldDescriptor, it.next(), false);
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                zzk(zzd, fieldDescriptor, (Map.Entry) it2.next(), false);
            }
            return;
        }
        if (obj instanceof Double) {
            double dDoubleValue = ((Double) obj).doubleValue();
            if (z && dDoubleValue == 0.0d) {
                return;
            }
            zzn((zzh(fieldDescriptor) << 3) | 1);
            this.zze.write(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putDouble(dDoubleValue).array());
            return;
        }
        if (obj instanceof Float) {
            float fFloatValue = ((Float) obj).floatValue();
            if (z && fFloatValue == 0.0f) {
                return;
            }
            zzn((zzh(fieldDescriptor) << 3) | 5);
            this.zze.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putFloat(fFloatValue).array());
            return;
        }
        if (obj instanceof Number) {
            long jLongValue = ((Number) obj).longValue();
            if (z && jLongValue == 0) {
                return;
            }
            zzfe zzfeVar = (zzfe) ((Annotation) fieldDescriptor.properties.get(zzfe.class));
            if (zzfeVar == null) {
                throw new EncodingException("Field has no @Protobuf config");
            }
            zzn(((zzez) zzfeVar).zza << 3);
            zzo(jLongValue);
            return;
        }
        if (obj instanceof Boolean) {
            zzd(fieldDescriptor, ((Boolean) obj).booleanValue() ? 1 : 0, z);
            return;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            if (z && bArr.length == 0) {
                return;
            }
            zzn((zzh(fieldDescriptor) << 3) | 2);
            zzn(bArr.length);
            this.zze.write(bArr);
            return;
        }
        ObjectEncoder objectEncoder = (ObjectEncoder) this.zzf.get(obj.getClass());
        if (objectEncoder != null) {
            zzk(objectEncoder, fieldDescriptor, obj, z);
            return;
        }
        ValueEncoder valueEncoder = (ValueEncoder) this.zzg.get(obj.getClass());
        if (valueEncoder != null) {
            zzao zzaoVar = this.zzi;
            zzaoVar.zza = false;
            zzaoVar.zzc = fieldDescriptor;
            zzaoVar.zzb = z;
            valueEncoder.encode(obj, zzaoVar);
            return;
        }
        if (obj instanceof zzfc) {
            zzd(fieldDescriptor, ((zzfc) obj).zza(), true);
        } else if (obj instanceof Enum) {
            zzd(fieldDescriptor, ((Enum) obj).ordinal(), true);
        } else {
            zzk(this.zzh, fieldDescriptor, obj, z);
        }
    }

    public final void zzd(FieldDescriptor fieldDescriptor, int i, boolean z) {
        if (z && i == 0) {
            return;
        }
        zzfe zzfeVar = (zzfe) ((Annotation) fieldDescriptor.properties.get(zzfe.class));
        if (zzfeVar == null) {
            throw new EncodingException("Field has no @Protobuf config");
        }
        zzn(((zzez) zzfeVar).zza << 3);
        zzn(i);
    }

    public final void zzk(ObjectEncoder objectEncoder, FieldDescriptor fieldDescriptor, Object obj, boolean z) throws IOException {
        zzaf zzafVar = new zzaf(1);
        zzafVar.zza = 0L;
        try {
            OutputStream outputStream = this.zze;
            this.zze = zzafVar;
            try {
                objectEncoder.encode(obj, this);
                this.zze = outputStream;
                long j = zzafVar.zza;
                zzafVar.close();
                if (z && j == 0) {
                    return;
                }
                zzn((zzh(fieldDescriptor) << 3) | 2);
                zzo(j);
                objectEncoder.encode(obj, this);
            } catch (Throwable th) {
                this.zze = outputStream;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                zzafVar.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public final void zzn(int i) throws IOException {
        while (true) {
            int i2 = i & 127;
            if ((i & (-128)) == 0) {
                this.zze.write(i2);
                return;
            } else {
                this.zze.write(i2 | 128);
                i >>>= 7;
            }
        }
    }

    public final void zzo(long j) throws IOException {
        while (true) {
            int i = ((int) j) & 127;
            if (((-128) & j) == 0) {
                this.zze.write(i);
                return;
            } else {
                this.zze.write(i | 128);
                j >>>= 7;
            }
        }
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    public final ObjectEncoderContext add(FieldDescriptor fieldDescriptor, Object obj) {
        zzc(fieldDescriptor, obj, true);
        return this;
    }
}
