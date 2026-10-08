package com.google.firebase.encoders.json;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import com.google.firebase.encoders.config.EncoderConfig;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class JsonDataEncoderBuilder implements EncoderConfig {
    public static final TimestampEncoder TIMESTAMP_ENCODER = new TimestampEncoder();
    public final JsonDataEncoderBuilder$$Lambda$1 fallbackEncoder;
    public boolean ignoreNullValues;
    public final HashMap objectEncoders;
    public final HashMap valueEncoders;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class TimestampEncoder implements ValueEncoder {
        public static final SimpleDateFormat rfc339;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            rfc339 = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        @Override // com.google.firebase.encoders.Encoder
        public final void encode(Object obj, Object obj2) {
            ((ValueEncoderContext) obj2).add(rfc339.format((Date) obj));
        }
    }

    public JsonDataEncoderBuilder() {
        HashMap map = new HashMap();
        this.objectEncoders = map;
        HashMap map2 = new HashMap();
        this.valueEncoders = map2;
        this.fallbackEncoder = JsonDataEncoderBuilder$$Lambda$1.instance;
        this.ignoreNullValues = false;
        map2.put(String.class, JsonDataEncoderBuilder$$Lambda$4.instance);
        map.remove(String.class);
        map2.put(Boolean.class, JsonDataEncoderBuilder$$Lambda$4.instance$1);
        map.remove(Boolean.class);
        map2.put(Date.class, TIMESTAMP_ENCODER);
        map.remove(Date.class);
    }

    @Override // com.google.firebase.encoders.config.EncoderConfig
    public final EncoderConfig registerEncoder(Class cls, ObjectEncoder objectEncoder) {
        this.objectEncoders.put(cls, objectEncoder);
        this.valueEncoders.remove(cls);
        return this;
    }
}
