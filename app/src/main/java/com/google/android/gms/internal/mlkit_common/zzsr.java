package com.google.android.gms.internal.mlkit_common;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.gms.internal.mlkit_vision_barcode.zzwd;
import com.google.android.gms.internal.mlkit_vision_barcode.zzwi;
import com.google.android.gms.internal.mlkit_vision_barcode.zzwp;
import com.google.android.gms.internal.mlkit_vision_common.zzma;
import com.google.android.gms.internal.mlkit_vision_common.zzmf;
import com.google.android.gms.internal.mlkit_vision_common.zzmj;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.common.sdkinternal.SharedPrefManager;
import java.util.ArrayList;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzsr extends Lifecycle {
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ zzsr(int i) {
        super(5);
        this.$r8$classId = i;
    }

    @Override // androidx.lifecycle.Lifecycle
    public final Object create(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                MlKitContext mlKitContext = MlKitContext.getInstance();
                Context applicationContext = MlKitContext.getInstance().getApplicationContext();
                ArrayList arrayList = new ArrayList();
                Path.Companion companion = new Path.Companion();
                CCTDestination cCTDestination = CCTDestination.INSTANCE;
                TransportRuntime.initialize(applicationContext);
                TransportRuntime.getInstance().newFactory(cCTDestination);
                CCTDestination.SUPPORTED_ENCODINGS.contains(new Encoding("json"));
                arrayList.add(companion);
                return new zzsh(mlKitContext.getApplicationContext(), (SharedPrefManager) mlKitContext.get(SharedPrefManager.class));
            case 1:
                zzwd zzwdVar = (zzwd) obj;
                MlKitContext mlKitContext2 = MlKitContext.getInstance();
                return new zzwp(mlKitContext2.getApplicationContext(), (SharedPrefManager) mlKitContext2.get(SharedPrefManager.class), new zzwi(MlKitContext.getInstance().getApplicationContext(), zzwdVar), zzwdVar.zza);
            default:
                MlKitContext mlKitContext3 = MlKitContext.getInstance();
                return new zzmj(mlKitContext3.getApplicationContext(), (SharedPrefManager) mlKitContext3.get(SharedPrefManager.class), new zzmf(MlKitContext.getInstance().getApplicationContext(), (zzma) obj));
        }
    }
}
