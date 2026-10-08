package com.google.android.gms.internal.mlkit_vision_barcode;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public enum zzrb implements zzfc {
    zza("NO_ERROR"),
    /* JADX INFO: Fake field, exist only in values array */
    EF2("INCOMPATIBLE_INPUT"),
    /* JADX INFO: Fake field, exist only in values array */
    EF4("INCOMPATIBLE_OUTPUT"),
    /* JADX INFO: Fake field, exist only in values array */
    EF6("INCOMPATIBLE_TFLITE_VERSION"),
    /* JADX INFO: Fake field, exist only in values array */
    EF8("MISSING_OP"),
    /* JADX INFO: Fake field, exist only in values array */
    EF10("DATA_TYPE_ERROR"),
    /* JADX INFO: Fake field, exist only in values array */
    EF13("TFLITE_INTERNAL_ERROR"),
    /* JADX INFO: Fake field, exist only in values array */
    EF15("TFLITE_UNKNOWN_ERROR"),
    /* JADX INFO: Fake field, exist only in values array */
    EF3("MEDIAPIPE_ERROR"),
    /* JADX INFO: Fake field, exist only in values array */
    EF7("TIME_OUT_FETCHING_MODEL_METADATA"),
    zzk("MODEL_NOT_DOWNLOADED"),
    /* JADX INFO: Fake field, exist only in values array */
    EF5("URI_EXPIRED"),
    /* JADX INFO: Fake field, exist only in values array */
    EF11("NO_NETWORK_CONNECTION"),
    /* JADX INFO: Fake field, exist only in values array */
    EF12("METERED_NETWORK"),
    /* JADX INFO: Fake field, exist only in values array */
    EF0("DOWNLOAD_FAILED"),
    /* JADX INFO: Fake field, exist only in values array */
    EF1("MODEL_INFO_DOWNLOAD_UNSUCCESSFUL_HTTP_STATUS"),
    /* JADX INFO: Fake field, exist only in values array */
    EF0("MODEL_INFO_DOWNLOAD_NO_HASH"),
    /* JADX INFO: Fake field, exist only in values array */
    EF1("MODEL_INFO_DOWNLOAD_CONNECTION_FAILED"),
    /* JADX INFO: Fake field, exist only in values array */
    EF0("NO_VALID_MODEL"),
    /* JADX INFO: Fake field, exist only in values array */
    EF1("LOCAL_MODEL_INVALID"),
    /* JADX INFO: Fake field, exist only in values array */
    EF0("REMOTE_MODEL_INVALID"),
    /* JADX INFO: Fake field, exist only in values array */
    EF1("REMOTE_MODEL_LOADER_ERROR"),
    /* JADX INFO: Fake field, exist only in values array */
    EF0("REMOTE_MODEL_LOADER_LOADS_NO_MODEL"),
    /* JADX INFO: Fake field, exist only in values array */
    EF1("SMART_REPLY_LANG_ID_DETECTAION_FAILURE"),
    /* JADX INFO: Fake field, exist only in values array */
    EF0("MODEL_NOT_REGISTERED"),
    /* JADX INFO: Fake field, exist only in values array */
    EF1("MODEL_TYPE_MISUSE"),
    /* JADX INFO: Fake field, exist only in values array */
    EF0("MODEL_HASH_MISMATCH"),
    zzB("OPTIONAL_MODULE_NOT_AVAILABLE"),
    zzC("OPTIONAL_MODULE_INIT_ERROR"),
    /* JADX INFO: Fake field, exist only in values array */
    EF1("OPTIONAL_MODULE_INFERENCE_ERROR"),
    /* JADX INFO: Fake field, exist only in values array */
    EF0("OPTIONAL_MODULE_RELEASE_ERROR"),
    /* JADX INFO: Fake field, exist only in values array */
    EF1("OPTIONAL_TFLITE_MODULE_INIT_ERROR"),
    /* JADX INFO: Fake field, exist only in values array */
    EF0("NATIVE_LIBRARY_LOAD_ERROR"),
    /* JADX INFO: Fake field, exist only in values array */
    EF1("OPTIONAL_MODULE_CREATE_ERROR"),
    /* JADX INFO: Fake field, exist only in values array */
    EF0("CAMERAX_SOURCE_ERROR"),
    /* JADX INFO: Fake field, exist only in values array */
    EF1("CAMERA1_SOURCE_CANT_START_ERROR"),
    /* JADX INFO: Fake field, exist only in values array */
    EF0("CAMERA1_SOURCE_NO_SUITABLE_SIZE_ERROR"),
    /* JADX INFO: Fake field, exist only in values array */
    EF1("CAMERA1_SOURCE_NO_SUITABLE_FPS_ERROR"),
    /* JADX INFO: Fake field, exist only in values array */
    EF0("CAMERA1_SOURCE_NO_BYTE_SOURCE_FOUND_ERROR"),
    /* JADX INFO: Fake field, exist only in values array */
    EF1("CODE_SCANNER_UNAVAILABLE"),
    /* JADX INFO: Fake field, exist only in values array */
    EF0("CODE_SCANNER_CANCELLED"),
    /* JADX INFO: Fake field, exist only in values array */
    EF1("CODE_SCANNER_CAMERA_PERMISSION_NOT_GRANTED"),
    /* JADX INFO: Fake field, exist only in values array */
    EF0("CODE_SCANNER_APP_NAME_UNAVAILABLE"),
    /* JADX INFO: Fake field, exist only in values array */
    EF1("CODE_SCANNER_TASK_IN_PROGRESS"),
    /* JADX INFO: Fake field, exist only in values array */
    EF0("CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR"),
    /* JADX INFO: Fake field, exist only in values array */
    EF1("CODE_SCANNER_PIPELINE_INFERENCE_ERROR"),
    /* JADX INFO: Fake field, exist only in values array */
    EF0("CODE_SCANNER_GOOGLE_PLAY_SERVICES_VERSION_TOO_OLD"),
    /* JADX INFO: Fake field, exist only in values array */
    EF1("LOW_LIGHT_AUTO_EXPOSURE_COMPUTATION_FAILURE"),
    /* JADX INFO: Fake field, exist only in values array */
    EF0("LOW_LIGHT_IMAGE_CAPTURE_PROCESSING_FAILURE"),
    /* JADX INFO: Fake field, exist only in values array */
    EF1("PERMISSION_DENIED"),
    /* JADX INFO: Fake field, exist only in values array */
    EF0("CANCELLED"),
    /* JADX INFO: Fake field, exist only in values array */
    EF1("GOOGLE_PLAY_SERVICES_VERSION_TOO_OLD"),
    /* JADX INFO: Fake field, exist only in values array */
    EF0("LOW_MEMORY"),
    zzab("UNKNOWN_ERROR");

    public final int zzad;

    zzrb(String str) {
        this.zzad = i;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzfc
    public final int zza() {
        return this.zzad;
    }
}
