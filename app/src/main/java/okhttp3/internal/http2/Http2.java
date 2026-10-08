package okhttp3.internal.http2;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal.Util;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class Http2 {
    public static final String[] BINARY;
    public static final ByteString CONNECTION_PREFACE;
    public static final String[] FLAGS;
    public static final String[] FRAME_NAMES;

    static {
        ByteString byteString = new ByteString("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n".getBytes(Charsets.UTF_8));
        byteString.utf8 = "PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n";
        CONNECTION_PREFACE = byteString;
        FRAME_NAMES = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        FLAGS = new String[64];
        String[] strArr = new String[256];
        for (int i = 0; i < 256; i++) {
            strArr[i] = Util.format("%8s", Integer.toBinaryString(i)).replace(' ', '0');
        }
        BINARY = strArr;
        String[] strArr2 = FLAGS;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i2 = iArr[0];
        strArr2[i2 | 8] = ImageAnalysis$$ExternalSyntheticLambda1.m(new StringBuilder(), strArr2[i2], "|PADDED");
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i3 = 0; i3 < 3; i3++) {
            int i4 = iArr2[i3];
            int i5 = iArr[0];
            String[] strArr3 = FLAGS;
            int i6 = i5 | i4;
            strArr3[i6] = strArr3[i5] + '|' + strArr3[i4];
            StringBuilder sb = new StringBuilder();
            sb.append(strArr3[i5]);
            sb.append('|');
            strArr3[i6 | 8] = ImageAnalysis$$ExternalSyntheticLambda1.m(sb, strArr3[i4], "|PADDED");
        }
        int length = FLAGS.length;
        for (int i7 = 0; i7 < length; i7++) {
            String[] strArr4 = FLAGS;
            if (strArr4[i7] == null) {
                strArr4[i7] = BINARY[i7];
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0065  */
    public static String frameLog(boolean z, int i, int i2, int i3, int i4) {
        String strReplace$default;
        String[] strArr = FRAME_NAMES;
        String str = i3 < strArr.length ? strArr[i3] : Util.format("0x%02x", Integer.valueOf(i3));
        if (i4 == 0) {
            strReplace$default = "";
        } else {
            String[] strArr2 = BINARY;
            if (i3 == 2 || i3 == 3) {
                strReplace$default = strArr2[i4];
            } else if (i3 == 4 || i3 == 6) {
                strReplace$default = i4 == 1 ? "ACK" : strArr2[i4];
            } else if (i3 == 7 || i3 == 8) {
                strReplace$default = strArr2[i4];
            } else {
                String[] strArr3 = FLAGS;
                String str2 = i4 < strArr3.length ? strArr3[i4] : strArr2[i4];
                if (i3 != 5 || (i4 & 4) == 0) {
                    strReplace$default = (i3 != 0 || (i4 & 32) == 0) ? str2 : StringsKt__StringsJVMKt.replace$default(str2, "PRIORITY", "COMPRESSED");
                } else {
                    strReplace$default = StringsKt__StringsJVMKt.replace$default(str2, "HEADERS", "PUSH_PROMISE");
                }
            }
        }
        return Util.format("%s 0x%08x %5d %-13s %s", z ? "<<" : ">>", Integer.valueOf(i), Integer.valueOf(i2), str, strReplace$default);
    }
}
