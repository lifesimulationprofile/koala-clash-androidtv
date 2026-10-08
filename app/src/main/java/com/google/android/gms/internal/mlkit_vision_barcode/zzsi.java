package com.google.android.gms.internal.mlkit_vision_barcode;

import androidx.compose.runtime.composer.gapbuffer.changelist.Operations;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzsi {
    /* JADX INFO: renamed from: setObject-sGr0YRc, reason: not valid java name */
    public static final void m814setObjectsGr0YRc(Operations operations, int i, Object obj) {
        operations.objectArgs[(operations.objectArgsSize - operations.opCodes[operations.opCodesSize - 1].objects) + i] = obj;
    }

    /* JADX INFO: renamed from: setObjects-EsEZvaA, reason: not valid java name */
    public static final void m815setObjectsEsEZvaA(Operations operations, int i, Object obj, int i2, Object obj2) {
        int i3 = operations.objectArgsSize - operations.opCodes[operations.opCodesSize - 1].objects;
        Object[] objArr = operations.objectArgs;
        objArr[i + i3] = obj;
        objArr[i3 + i2] = obj2;
    }
}
