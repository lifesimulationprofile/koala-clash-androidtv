package com.google.android.datatransport.cct.internal;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AutoBatchedLogRequestEncoder$ClientInfoEncoder implements ObjectEncoder {
    public static final AutoBatchedLogRequestEncoder$ClientInfoEncoder INSTANCE = new AutoBatchedLogRequestEncoder$ClientInfoEncoder();
    public static final FieldDescriptor CLIENTTYPE_DESCRIPTOR = FieldDescriptor.of("clientType");
    public static final FieldDescriptor ANDROIDCLIENTINFO_DESCRIPTOR = FieldDescriptor.of("androidClientInfo");

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        AutoValue_ClientInfo autoValue_ClientInfo = (AutoValue_ClientInfo) ((ClientInfo) obj);
        autoValue_ClientInfo.getClass();
        objectEncoderContext.add(CLIENTTYPE_DESCRIPTOR, ClientInfo.ClientType.ANDROID_FIREBASE);
        objectEncoderContext.add(ANDROIDCLIENTINFO_DESCRIPTOR, autoValue_ClientInfo.androidClientInfo);
    }
}
