package androidx.compose.ui.layout;

import androidx.collection.Values;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ContentScale$Companion$Fit$1 implements SubcomposeSlotReusePolicy, ContentScale {
    public static final ContentScale$Companion$Fit$1 INSTANCE = new ContentScale$Companion$Fit$1(1);
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ ContentScale$Companion$Fit$1(int i) {
        this.$r8$classId = i;
    }

    @Override // androidx.compose.ui.layout.SubcomposeSlotReusePolicy
    public boolean areCompatible(Object obj, Object obj2) {
        return false;
    }

    @Override // androidx.compose.ui.layout.ContentScale
    /* JADX INFO: renamed from: computeScaleFactor-H7hwNQA */
    public long mo516computeScaleFactorH7hwNQA(long j, long j2) {
        switch (this.$r8$classId) {
            case 0:
                float fMin = Math.min(Float.intBitsToFloat((int) (j2 >> 32)) / Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j2 & 4294967295L)) / Float.intBitsToFloat((int) (j & 4294967295L)));
                long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(fMin)) << 32) | (((long) Float.floatToRawIntBits(fMin)) & 4294967295L);
                int i = ScaleFactor.$r8$clinit;
                return jFloatToRawIntBits;
            case 1:
            default:
                if (Float.intBitsToFloat((int) (j >> 32)) <= Float.intBitsToFloat((int) (j2 >> 32)) && Float.intBitsToFloat((int) (j & 4294967295L)) <= Float.intBitsToFloat((int) (j2 & 4294967295L))) {
                    long jFloatToRawIntBits2 = (((long) Float.floatToRawIntBits(1.0f)) << 32) | (((long) Float.floatToRawIntBits(1.0f)) & 4294967295L);
                    int i2 = ScaleFactor.$r8$clinit;
                    return jFloatToRawIntBits2;
                }
                float fMin2 = Math.min(Float.intBitsToFloat((int) (j2 >> 32)) / Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j2 & 4294967295L)) / Float.intBitsToFloat((int) (j & 4294967295L)));
                long jFloatToRawIntBits3 = (((long) Float.floatToRawIntBits(fMin2)) << 32) | (((long) Float.floatToRawIntBits(fMin2)) & 4294967295L);
                int i3 = ScaleFactor.$r8$clinit;
                return jFloatToRawIntBits3;
            case 2:
                float fMax = Math.max(Float.intBitsToFloat((int) (j2 >> 32)) / Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j2 & 4294967295L)) / Float.intBitsToFloat((int) (j & 4294967295L)));
                long jFloatToRawIntBits4 = (((long) Float.floatToRawIntBits(fMax)) << 32) | (((long) Float.floatToRawIntBits(fMax)) & 4294967295L);
                int i4 = ScaleFactor.$r8$clinit;
                return jFloatToRawIntBits4;
        }
    }

    @Override // androidx.compose.ui.layout.SubcomposeSlotReusePolicy
    public void getSlotsToRetain(Values values) {
        values.clear();
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 4:
                return "ReusedSlotId";
            default:
                return super.toString();
        }
    }
}
