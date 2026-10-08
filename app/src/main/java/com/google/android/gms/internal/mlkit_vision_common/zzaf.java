package com.google.android.gms.internal.mlkit_vision_common;

import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzaf extends OutputStream {
    public final /* synthetic */ int $r8$classId;
    public long zza;

    @Override // java.io.OutputStream
    public final void write(int i) {
        switch (this.$r8$classId) {
            case 0:
                this.zza++;
                break;
            default:
                this.zza++;
                break;
        }
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        switch (this.$r8$classId) {
            case 0:
                this.zza += (long) bArr.length;
                break;
            default:
                this.zza += (long) bArr.length;
                break;
        }
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) {
        int length;
        int i3;
        int length2;
        int i4;
        switch (this.$r8$classId) {
            case 0:
                if (i >= 0 && i <= (length = bArr.length) && i2 >= 0 && (i3 = i + i2) <= length && i3 >= 0) {
                    this.zza += (long) i2;
                    return;
                }
                throw new IndexOutOfBoundsException();
            default:
                if (i >= 0 && i <= (length2 = bArr.length) && i2 >= 0 && (i4 = i + i2) <= length2 && i4 >= 0) {
                    this.zza += (long) i2;
                    return;
                }
                throw new IndexOutOfBoundsException();
        }
    }
}
