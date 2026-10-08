package androidx.compose.ui.text.input;

import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextRange;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class EditingBufferKt {
    /* JADX INFO: renamed from: updateRangeAfterDelete-pWDy79M, reason: not valid java name */
    public static final long m660updateRangeAfterDeletepWDy79M(long j, long j2) {
        int iM642getLengthimpl;
        int iM644getMinimpl = TextRange.m644getMinimpl(j);
        int iM643getMaximpl = TextRange.m643getMaximpl(j);
        if ((TextRange.m644getMinimpl(j2) < TextRange.m643getMaximpl(j)) && (TextRange.m644getMinimpl(j) < TextRange.m643getMaximpl(j2))) {
            if ((TextRange.m644getMinimpl(j2) <= TextRange.m644getMinimpl(j)) && (TextRange.m643getMaximpl(j) <= TextRange.m643getMaximpl(j2))) {
                iM644getMinimpl = TextRange.m644getMinimpl(j2);
                iM643getMaximpl = iM644getMinimpl;
            } else {
                if ((TextRange.m644getMinimpl(j) <= TextRange.m644getMinimpl(j2)) && (TextRange.m643getMaximpl(j2) <= TextRange.m643getMaximpl(j))) {
                    iM642getLengthimpl = TextRange.m642getLengthimpl(j2);
                } else {
                    int iM644getMinimpl2 = TextRange.m644getMinimpl(j2);
                    if (iM644getMinimpl >= TextRange.m643getMaximpl(j2) || iM644getMinimpl2 > iM644getMinimpl) {
                        iM643getMaximpl = TextRange.m644getMinimpl(j2);
                    } else {
                        iM644getMinimpl = TextRange.m644getMinimpl(j2);
                        iM642getLengthimpl = TextRange.m642getLengthimpl(j2);
                    }
                }
                iM643getMaximpl -= iM642getLengthimpl;
            }
        } else if (iM643getMaximpl > TextRange.m644getMinimpl(j2)) {
            iM644getMinimpl -= TextRange.m642getLengthimpl(j2);
            iM642getLengthimpl = TextRange.m642getLengthimpl(j2);
            iM643getMaximpl -= iM642getLengthimpl;
        }
        return ParagraphKt.TextRange(iM644getMinimpl, iM643getMaximpl);
    }
}
