package com.google.android.datatransport.cct.internal;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AutoBatchedLogRequestEncoder$BatchedLogRequestEncoder implements ObjectEncoder {
    public static final AutoBatchedLogRequestEncoder$BatchedLogRequestEncoder INSTANCE = new AutoBatchedLogRequestEncoder$BatchedLogRequestEncoder();
    public static final FieldDescriptor LOGREQUEST_DESCRIPTOR = FieldDescriptor.of("logRequest");

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        ((ObjectEncoderContext) obj2).add(LOGREQUEST_DESCRIPTOR, ((AutoValue_BatchedLogRequest) ((BatchedLogRequest) obj)).logRequests);
    }
}
