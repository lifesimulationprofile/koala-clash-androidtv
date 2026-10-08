package com.google.android.gms.internal.mlkit_vision_common;

import android.util.Log;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import coil.ImageLoader$Builder;
import com.google.android.datatransport.Encoding;
import com.google.android.gms.internal.mlkit_vision_barcode.zzxb;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.InvalidRegistrarException;
import com.google.firebase.inject.Provider;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzmm implements Provider {
    public final /* synthetic */ int $r8$classId;
    public final Object zza;

    public /* synthetic */ zzmm(int i, Object obj) {
        this.$r8$classId = i;
        this.zza = obj;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        switch (this.$r8$classId) {
            case 0:
                return ((ImageLoader$Builder) this.zza).getTransport(new Encoding("json"), zzmw.zza$3);
            case 1:
                return ((ImageLoader$Builder) this.zza).getTransport(new Encoding("json"), new zzxb(3));
            case 2:
                return ((ImageLoader$Builder) this.zza).getTransport(new Encoding("proto"), new zzxb(2));
            case 3:
                return ((ImageLoader$Builder) this.zza).getTransport(new Encoding("proto"), zzmw.zza$2);
            default:
                String str = (String) this.zza;
                try {
                    Class<?> cls = Class.forName(str);
                    if (ComponentRegistrar.class.isAssignableFrom(cls)) {
                        return (ComponentRegistrar) cls.getDeclaredConstructor(null).newInstance(null);
                    }
                    throw new InvalidRegistrarException("Class " + str + " is not an instance of com.google.firebase.components.ComponentRegistrar");
                } catch (ClassNotFoundException unused) {
                    Log.w("ComponentDiscovery", "Class " + str + " is not an found.");
                    return null;
                } catch (IllegalAccessException e) {
                    throw new InvalidRegistrarException(ImageAnalysis$$ExternalSyntheticLambda1.m$1("Could not instantiate ", str, "."), e);
                } catch (InstantiationException e2) {
                    throw new InvalidRegistrarException(ImageAnalysis$$ExternalSyntheticLambda1.m$1("Could not instantiate ", str, "."), e2);
                } catch (NoSuchMethodException e3) {
                    throw new InvalidRegistrarException(CaptureSession$State$EnumUnboxingLocalUtility.m("Could not instantiate ", str), e3);
                } catch (InvocationTargetException e4) {
                    throw new InvalidRegistrarException(CaptureSession$State$EnumUnboxingLocalUtility.m("Could not instantiate ", str), e4);
                }
        }
    }
}
