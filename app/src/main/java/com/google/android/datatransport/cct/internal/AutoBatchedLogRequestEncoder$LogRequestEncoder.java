package com.google.android.datatransport.cct.internal;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AutoBatchedLogRequestEncoder$LogRequestEncoder implements ObjectEncoder {
    public static final AutoBatchedLogRequestEncoder$LogRequestEncoder INSTANCE = new AutoBatchedLogRequestEncoder$LogRequestEncoder();
    public static final FieldDescriptor REQUESTTIMEMS_DESCRIPTOR = FieldDescriptor.of("requestTimeMs");
    public static final FieldDescriptor REQUESTUPTIMEMS_DESCRIPTOR = FieldDescriptor.of("requestUptimeMs");
    public static final FieldDescriptor CLIENTINFO_DESCRIPTOR = FieldDescriptor.of("clientInfo");
    public static final FieldDescriptor LOGSOURCE_DESCRIPTOR = FieldDescriptor.of("logSource");
    public static final FieldDescriptor LOGSOURCENAME_DESCRIPTOR = FieldDescriptor.of("logSourceName");
    public static final FieldDescriptor LOGEVENT_DESCRIPTOR = FieldDescriptor.of("logEvent");
    public static final FieldDescriptor QOSTIER_DESCRIPTOR = FieldDescriptor.of("qosTier");

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        AutoValue_LogRequest autoValue_LogRequest = (AutoValue_LogRequest) ((LogRequest) obj);
        objectEncoderContext.add(REQUESTTIMEMS_DESCRIPTOR, autoValue_LogRequest.requestTimeMs);
        objectEncoderContext.add(REQUESTUPTIMEMS_DESCRIPTOR, autoValue_LogRequest.requestUptimeMs);
        objectEncoderContext.add(CLIENTINFO_DESCRIPTOR, autoValue_LogRequest.clientInfo);
        objectEncoderContext.add(LOGSOURCE_DESCRIPTOR, autoValue_LogRequest.logSource);
        objectEncoderContext.add(LOGSOURCENAME_DESCRIPTOR, autoValue_LogRequest.logSourceName);
        objectEncoderContext.add(LOGEVENT_DESCRIPTOR, autoValue_LogRequest.logEvents);
        objectEncoderContext.add(QOSTIER_DESCRIPTOR, QosTier.DEFAULT);
    }
}
