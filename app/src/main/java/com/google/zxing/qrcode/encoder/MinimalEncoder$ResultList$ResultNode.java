package com.google.zxing.qrcode.encoder;

import coil.ImageLoader$Builder;
import com.google.zxing.common.ECIEncoderSet;
import com.google.zxing.qrcode.decoder.Mode;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MinimalEncoder$ResultList$ResultNode {
    public final int characterLength;
    public final int charsetEncoderIndex;
    public final int fromPosition;
    public final Mode mode;
    public final /* synthetic */ ImageLoader$Builder this$1;

    public MinimalEncoder$ResultList$ResultNode(ImageLoader$Builder imageLoader$Builder, Mode mode, int i, int i2, int i3) {
        this.this$1 = imageLoader$Builder;
        this.mode = mode;
        this.fromPosition = i;
        this.charsetEncoderIndex = i2;
        this.characterLength = i3;
    }

    public final int getCharacterCountIndicator() {
        Mode mode = this.mode;
        Mode mode2 = Mode.BYTE;
        int i = this.characterLength;
        if (mode != mode2) {
            return i;
        }
        MinimalEncoder minimalEncoder = (MinimalEncoder) this.this$1.options;
        ECIEncoderSet eCIEncoderSet = (ECIEncoderSet) minimalEncoder.encoders;
        String str = (String) minimalEncoder.stringToEncode;
        int i2 = this.fromPosition;
        return str.substring(i2, i + i2).getBytes(eCIEncoderSet.encoders[this.charsetEncoderIndex].charset()).length;
    }

    public final String toString() {
        MinimalEncoder minimalEncoder = (MinimalEncoder) this.this$1.options;
        StringBuilder sb = new StringBuilder();
        Mode mode = this.mode;
        sb.append(mode);
        sb.append('(');
        if (mode == Mode.ECI) {
            ECIEncoderSet eCIEncoderSet = (ECIEncoderSet) minimalEncoder.encoders;
            sb.append(eCIEncoderSet.encoders[this.charsetEncoderIndex].charset().displayName());
        } else {
            String str = (String) minimalEncoder.stringToEncode;
            int i = this.characterLength;
            int i2 = this.fromPosition;
            String strSubstring = str.substring(i2, i + i2);
            StringBuilder sb2 = new StringBuilder();
            for (int i3 = 0; i3 < strSubstring.length(); i3++) {
                if (strSubstring.charAt(i3) < ' ' || strSubstring.charAt(i3) > '~') {
                    sb2.append('.');
                } else {
                    sb2.append(strSubstring.charAt(i3));
                }
            }
            sb.append(sb2.toString());
        }
        sb.append(')');
        return sb.toString();
    }
}
