package com.google.firebase.encoders.json;

import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class JsonDataEncoderBuilder$$Lambda$4 implements ValueEncoder {
    public static final JsonDataEncoderBuilder$$Lambda$4 instance = new JsonDataEncoderBuilder$$Lambda$4(0);
    public static final JsonDataEncoderBuilder$$Lambda$4 instance$1 = new JsonDataEncoderBuilder$$Lambda$4(1);
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ JsonDataEncoderBuilder$$Lambda$4(int i) {
        this.$r8$classId = i;
    }

    @Override // com.google.firebase.encoders.Encoder
    public final void encode(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                JsonDataEncoderBuilder.TimestampEncoder timestampEncoder = JsonDataEncoderBuilder.TIMESTAMP_ENCODER;
                ((ValueEncoderContext) obj2).add((String) obj);
                break;
            default:
                JsonDataEncoderBuilder.TimestampEncoder timestampEncoder2 = JsonDataEncoderBuilder.TIMESTAMP_ENCODER;
                ((ValueEncoderContext) obj2).add(((Boolean) obj).booleanValue());
                break;
        }
    }
}
