package com.google.android.datatransport.cct.internal;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AutoBatchedLogRequestEncoder$LogEventEncoder implements ObjectEncoder {
    public static final AutoBatchedLogRequestEncoder$LogEventEncoder INSTANCE = new AutoBatchedLogRequestEncoder$LogEventEncoder();
    public static final FieldDescriptor EVENTTIMEMS_DESCRIPTOR = FieldDescriptor.of("eventTimeMs");
    public static final FieldDescriptor EVENTCODE_DESCRIPTOR = FieldDescriptor.of("eventCode");
    public static final FieldDescriptor EVENTUPTIMEMS_DESCRIPTOR = FieldDescriptor.of("eventUptimeMs");
    public static final FieldDescriptor SOURCEEXTENSION_DESCRIPTOR = FieldDescriptor.of("sourceExtension");
    public static final FieldDescriptor SOURCEEXTENSIONJSONPROTO3_DESCRIPTOR = FieldDescriptor.of("sourceExtensionJsonProto3");
    public static final FieldDescriptor TIMEZONEOFFSETSECONDS_DESCRIPTOR = FieldDescriptor.of("timezoneOffsetSeconds");
    public static final FieldDescriptor NETWORKCONNECTIONINFO_DESCRIPTOR = FieldDescriptor.of("networkConnectionInfo");

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        AutoValue_LogEvent autoValue_LogEvent = (AutoValue_LogEvent) ((LogEvent) obj);
        objectEncoderContext.add(EVENTTIMEMS_DESCRIPTOR, autoValue_LogEvent.eventTimeMs);
        objectEncoderContext.add(EVENTCODE_DESCRIPTOR, autoValue_LogEvent.eventCode);
        objectEncoderContext.add(EVENTUPTIMEMS_DESCRIPTOR, autoValue_LogEvent.eventUptimeMs);
        objectEncoderContext.add(SOURCEEXTENSION_DESCRIPTOR, autoValue_LogEvent.sourceExtension);
        objectEncoderContext.add(SOURCEEXTENSIONJSONPROTO3_DESCRIPTOR, autoValue_LogEvent.sourceExtensionJsonProto3);
        objectEncoderContext.add(TIMEZONEOFFSETSECONDS_DESCRIPTOR, autoValue_LogEvent.timezoneOffsetSeconds);
        objectEncoderContext.add(NETWORKCONNECTIONINFO_DESCRIPTOR, autoValue_LogEvent.networkConnectionInfo);
    }
}
