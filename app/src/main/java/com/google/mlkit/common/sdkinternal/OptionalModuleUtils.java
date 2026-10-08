package com.google.mlkit.common.sdkinternal;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import androidx.room.RoomOpenHelper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api$ApiOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import com.google.android.gms.common.moduleinstall.internal.ApiFeatureRequest;
import com.google.android.gms.common.moduleinstall.internal.zay;
import com.google.android.gms.internal.base.zaf;
import com.google.android.gms.internal.mlkit_common.zzag;
import com.google.android.gms.internal.mlkit_common.zzaq;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.gms.tasks.zzw;
import com.google.zxing.qrcode.encoder.MinimalEncoder;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Headers;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class OptionalModuleUtils {
    public static final Feature[] EMPTY_FEATURES = new Feature[0];
    public static final Feature FEATURE_BARCODE;
    public static final zzaq zza;
    public static final zzaq zzb;

    static {
        Feature feature = new Feature("vision.barcode", 1L);
        FEATURE_BARCODE = feature;
        Feature feature2 = new Feature("vision.custom.ica", 1L);
        Feature feature3 = new Feature("vision.face", 1L);
        Feature feature4 = new Feature("vision.ica", 1L);
        Feature feature5 = new Feature("vision.ocr", 1L);
        Feature feature6 = new Feature("mlkit.langid", 1L);
        Feature feature7 = new Feature("mlkit.nlclassifier", 1L);
        Feature feature8 = new Feature("tflite_dynamite", 1L);
        Feature feature9 = new Feature("mlkit.barcode.ui", 1L);
        Feature feature10 = new Feature("mlkit.smartreply", 1L);
        RoomOpenHelper roomOpenHelper = new RoomOpenHelper(10, (byte) 0);
        roomOpenHelper.zza("barcode", feature);
        roomOpenHelper.zza("custom_ica", feature2);
        roomOpenHelper.zza("face", feature3);
        roomOpenHelper.zza("ica", feature4);
        roomOpenHelper.zza("ocr", feature5);
        roomOpenHelper.zza("langid", feature6);
        roomOpenHelper.zza("nlclassifier", feature7);
        roomOpenHelper.zza("tflite_dynamite", feature8);
        roomOpenHelper.zza("barcode_ui", feature9);
        roomOpenHelper.zza("smart_reply", feature10);
        zzag zzagVar = (zzag) roomOpenHelper.mDelegate;
        if (zzagVar != null) {
            throw zzagVar.zza();
        }
        zzaq zzaqVarZzg = zzaq.zzg(roomOpenHelper.version, (Object[]) roomOpenHelper.mConfiguration, roomOpenHelper);
        zzag zzagVar2 = (zzag) roomOpenHelper.mDelegate;
        if (zzagVar2 != null) {
            throw zzagVar2.zza();
        }
        zza = zzaqVarZzg;
        RoomOpenHelper roomOpenHelper2 = new RoomOpenHelper(10, (byte) 0);
        roomOpenHelper2.zza("com.google.android.gms.vision.barcode", feature);
        roomOpenHelper2.zza("com.google.android.gms.vision.custom.ica", feature2);
        roomOpenHelper2.zza("com.google.android.gms.vision.face", feature3);
        roomOpenHelper2.zza("com.google.android.gms.vision.ica", feature4);
        roomOpenHelper2.zza("com.google.android.gms.vision.ocr", feature5);
        roomOpenHelper2.zza("com.google.android.gms.mlkit.langid", feature6);
        roomOpenHelper2.zza("com.google.android.gms.mlkit.nlclassifier", feature7);
        roomOpenHelper2.zza("com.google.android.gms.tflite_dynamite", feature8);
        roomOpenHelper2.zza("com.google.android.gms.mlkit_smartreply", feature10);
        zzag zzagVar3 = (zzag) roomOpenHelper2.mDelegate;
        if (zzagVar3 != null) {
            throw zzagVar3.zza();
        }
        zzaq zzaqVarZzg2 = zzaq.zzg(roomOpenHelper2.version, (Object[]) roomOpenHelper2.mConfiguration, roomOpenHelper2);
        zzag zzagVar4 = (zzag) roomOpenHelper2.mDelegate;
        if (zzagVar4 != null) {
            throw zzagVar4.zza();
        }
        zzb = zzaqVarZzg2;
    }

    public static void requestDownload(Context context, List list) {
        zzw zzwVarZae;
        GoogleApiAvailabilityLight.zza.getClass();
        if (GoogleApiAvailabilityLight.getApkVersion(context) < 221500000) {
            Intent intent = new Intent();
            intent.setClassName("com.google.android.gms", "com.google.android.gms.vision.DependencyBroadcastReceiverProxy");
            intent.setAction("com.google.android.gms.vision.DEPENDENCY");
            intent.putExtra("com.google.android.gms.vision.DEPENDENCIES", TextUtils.join(",", list));
            intent.putExtra("requester_app_package", context.getApplicationInfo().packageName);
            context.sendBroadcast(intent);
            return;
        }
        Feature[] featureArrZza = zza(zza, list);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new zzo(featureArrZza, 0));
        zzah.checkArgument("APIs must not be empty.", !arrayList.isEmpty());
        zay zayVar = new zay(context, zay.zae, Api$ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
        ApiFeatureRequest apiFeatureRequestZaa = ApiFeatureRequest.zaa(arrayList, true);
        if (apiFeatureRequestZaa.zab.isEmpty()) {
            ModuleInstallResponse moduleInstallResponse = new ModuleInstallResponse(0, false);
            zzwVarZae = new zzw();
            zzwVarZae.zzb(moduleInstallResponse);
        } else {
            MinimalEncoder minimalEncoder = new MinimalEncoder();
            minimalEncoder.encoders = new Feature[]{zaf.zaa$1};
            minimalEncoder.isGS1 = true;
            minimalEncoder.ecLevel = 27304;
            minimalEncoder.stringToEncode = new Headers.Builder(zayVar, apiFeatureRequestZaa);
            zzwVarZae = zayVar.zae(0, minimalEncoder.build());
        }
        Path.Companion companion = new Path.Companion();
        zzwVarZae.getClass();
        zzwVarZae.addOnFailureListener(TaskExecutors.MAIN_THREAD, companion);
    }

    public static Feature[] zza(zzaq zzaqVar, List list) {
        Feature[] featureArr = new Feature[list.size()];
        for (int i = 0; i < list.size(); i++) {
            Feature feature = (Feature) zzaqVar.get(list.get(i));
            zzah.checkNotNull(feature);
            featureArr[i] = feature;
        }
        return featureArr;
    }
}
