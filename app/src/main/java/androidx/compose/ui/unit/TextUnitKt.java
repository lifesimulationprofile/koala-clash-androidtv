package androidx.compose.ui.unit;

import androidx.compose.ui.util.MathHelpersKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class TextUnitKt {
    public static final long getSp(double d) {
        return pack((float) d, 4294967296L);
    }

    /* JADX INFO: renamed from: lerp-C3pnCVY, reason: not valid java name */
    public static final long m730lerpC3pnCVY(long j, long j2, float f) {
        TextUnitType[] textUnitTypeArr = TextUnit.TextUnitTypes;
        long j3 = j & 1095216660480L;
        if (j3 == 0 || (1095216660480L & j2) == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Cannot perform operation for Unspecified type.");
        }
        if (!TextUnitType.m731equalsimpl0(TextUnit.m726getTypeUIouoOA(j), TextUnit.m726getTypeUIouoOA(j2))) {
            InlineClassHelperKt.throwIllegalArgumentException("Cannot perform operation for " + ((Object) TextUnitType.m732toStringimpl(TextUnit.m726getTypeUIouoOA(j))) + " and " + ((Object) TextUnitType.m732toStringimpl(TextUnit.m726getTypeUIouoOA(j2))));
        }
        return pack(MathHelpersKt.lerp(TextUnit.m727getValueimpl(j), TextUnit.m727getValueimpl(j2), f), j3);
    }

    public static final long pack(float f, long j) {
        long jFloatToRawIntBits = j | (((long) Float.floatToRawIntBits(f)) & 4294967295L);
        TextUnitType[] textUnitTypeArr = TextUnit.TextUnitTypes;
        return jFloatToRawIntBits;
    }

    public static final long getSp(int i) {
        return pack(i, 4294967296L);
    }
}
