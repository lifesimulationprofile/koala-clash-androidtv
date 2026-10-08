package kotlinx.serialization.json.internal;

import coil.memory.RealWeakMemoryCache;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ComposerForUnsignedNumbers extends Composer {
    public final boolean forceQuoting;

    public ComposerForUnsignedNumbers(RealWeakMemoryCache realWeakMemoryCache, boolean z) {
        super(realWeakMemoryCache);
        this.forceQuoting = z;
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public final void print(int i) {
        if (this.forceQuoting) {
            printQuoted(Long.toString(4294967295L & ((long) i), 10));
        } else {
            print(Long.toString(4294967295L & ((long) i), 10));
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public final void print(long j) {
        int i = 63;
        String str = "0";
        if (this.forceQuoting) {
            if (j != 0) {
                if (j > 0) {
                    str = Long.toString(j, 10);
                } else {
                    char[] cArr = new char[64];
                    long j2 = (j >>> 1) / ((long) 5);
                    long j3 = 10;
                    cArr[63] = Character.forDigit((int) (j - (j2 * j3)), 10);
                    while (j2 > 0) {
                        i--;
                        cArr[i] = Character.forDigit((int) (j2 % j3), 10);
                        j2 /= j3;
                    }
                    str = new String(cArr, i, 64 - i);
                }
            }
            printQuoted(str);
            return;
        }
        if (j != 0) {
            if (j > 0) {
                str = Long.toString(j, 10);
            } else {
                char[] cArr2 = new char[64];
                long j4 = (j >>> 1) / ((long) 5);
                long j5 = 10;
                cArr2[63] = Character.forDigit((int) (j - (j4 * j5)), 10);
                while (j4 > 0) {
                    i--;
                    cArr2[i] = Character.forDigit((int) (j4 % j5), 10);
                    j4 /= j5;
                }
                str = new String(cArr2, i, 64 - i);
            }
        }
        print(str);
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public final void print(byte b) {
        if (this.forceQuoting) {
            printQuoted(String.valueOf(b & 255));
        } else {
            print(String.valueOf(b & 255));
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public final void print(short s) {
        if (this.forceQuoting) {
            printQuoted(String.valueOf(s & 65535));
        } else {
            print(String.valueOf(s & 65535));
        }
    }
}
