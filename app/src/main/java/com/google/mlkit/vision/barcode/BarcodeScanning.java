package com.google.mlkit.vision.barcode;

import androidx.emoji2.text.DefaultEmojiCompatConfig;
import com.google.android.gms.internal.mlkit_vision_barcode.zzwd;
import com.google.android.gms.internal.mlkit_vision_barcode.zzwp;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.barcode.internal.zzb;
import com.google.mlkit.vision.barcode.internal.zzg;
import com.google.mlkit.vision.barcode.internal.zzh;
import com.google.mlkit.vision.barcode.internal.zzl;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class BarcodeScanning {
    public static zzh getClient(BarcodeScannerOptions barcodeScannerOptions) {
        zzwp zzwpVarZza;
        zzg zzgVar = (zzg) MlKitContext.getInstance().get(zzg.class);
        zzl zzlVar = (zzl) zzgVar.zza.get(barcodeScannerOptions);
        Executor executor = (Executor) zzgVar.zzb.zza.get();
        String str = true != zzb.zzf() ? "play-services-mlkit-barcode-scanning" : "barcode-scanning";
        synchronized (DefaultEmojiCompatConfig.class) {
            byte b = (byte) (((byte) 1) | 2);
            try {
                if (b != 3) {
                    StringBuilder sb = new StringBuilder();
                    if ((b & 1) == 0) {
                        sb.append(" enableFirelog");
                    }
                    if ((b & 2) == 0) {
                        sb.append(" firelogEventType");
                    }
                    throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
                }
                zzwpVarZza = DefaultEmojiCompatConfig.zza(new zzwd(str, 1));
            } catch (Throwable th) {
                throw th;
            }
        }
        return new zzh(barcodeScannerOptions, zzlVar, executor, zzwpVarZza);
    }
}
