package kotlinx.serialization.json.internal;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CharMappings {
    public static final char[] ESCAPE_2_CHAR = new char[117];
    public static final byte[] CHAR_TO_TOKEN = new byte[126];

    static {
        for (int i = 0; i < 32; i++) {
        }
        initC2ESC('b', 8);
        initC2ESC('t', 9);
        initC2ESC('n', 10);
        initC2ESC('f', 12);
        initC2ESC('r', 13);
        initC2ESC('/', 47);
        initC2ESC('\"', 34);
        initC2ESC('\\', 92);
        byte[] bArr = CHAR_TO_TOKEN;
        for (int i2 = 0; i2 < 33; i2++) {
            bArr[i2] = 127;
        }
        bArr[9] = 3;
        bArr[10] = 3;
        bArr[13] = 3;
        bArr[32] = 3;
        bArr[44] = 4;
        bArr[58] = 5;
        bArr[123] = 6;
        bArr[125] = 7;
        bArr[91] = 8;
        bArr[93] = 9;
        bArr[34] = 1;
        bArr[92] = 2;
    }

    public static void initC2ESC(char c, int i) {
        if (c != 'u') {
            ESCAPE_2_CHAR[c] = (char) i;
        }
    }
}
