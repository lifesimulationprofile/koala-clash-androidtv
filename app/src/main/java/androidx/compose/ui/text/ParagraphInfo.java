package androidx.compose.ui.text;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.geometry.Rect;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ParagraphInfo {
    public final float bottom;
    public final int endIndex;
    public final int endLineIndex;
    public final AndroidParagraph paragraph;
    public final int startIndex;
    public final int startLineIndex;
    public final float top;

    public ParagraphInfo(AndroidParagraph androidParagraph, int i, int i2, int i3, int i4, float f, float f2) {
        this.paragraph = androidParagraph;
        this.startIndex = i;
        this.endIndex = i2;
        this.startLineIndex = i3;
        this.endLineIndex = i4;
        this.top = f;
        this.bottom = f2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParagraphInfo)) {
            return false;
        }
        ParagraphInfo paragraphInfo = (ParagraphInfo) obj;
        return this.paragraph.equals(paragraphInfo.paragraph) && this.startIndex == paragraphInfo.startIndex && this.endIndex == paragraphInfo.endIndex && this.startLineIndex == paragraphInfo.startLineIndex && this.endLineIndex == paragraphInfo.endLineIndex && Float.compare(this.top, paragraphInfo.top) == 0 && Float.compare(this.bottom, paragraphInfo.bottom) == 0;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.bottom) + ImageAnalysis$$ExternalSyntheticLambda1.m(this.top, ((((((((this.paragraph.hashCode() * 31) + this.startIndex) * 31) + this.endIndex) * 31) + this.startLineIndex) * 31) + this.endLineIndex) * 31, 31);
    }

    public final Rect toGlobal(Rect rect) {
        return rect.m381translatek4lQ0M((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(this.top)) & 4294967295L));
    }

    /* JADX INFO: renamed from: toGlobal-xdX6-G0, reason: not valid java name */
    public final long m631toGlobalxdX6G0(long j, boolean z) {
        if (z) {
            long j2 = TextRange.Zero;
            if (TextRange.m640equalsimpl0(j, j2)) {
                return j2;
            }
        }
        int i = TextRange.$r8$clinit;
        int i2 = (int) (j >> 32);
        int i3 = this.startIndex;
        return ParagraphKt.TextRange(i2 + i3, ((int) (j & 4294967295L)) + i3);
    }

    public final Rect toLocal(Rect rect) {
        float f = -this.top;
        return rect.m381translatek4lQ0M((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L));
    }

    public final int toLocalIndex(int i) {
        int i2 = this.endIndex;
        int i3 = this.startIndex;
        return RangesKt.coerceIn(i, i3, i2) - i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ParagraphInfo(paragraph=");
        sb.append(this.paragraph);
        sb.append(", startIndex=");
        sb.append(this.startIndex);
        sb.append(", endIndex=");
        sb.append(this.endIndex);
        sb.append(", startLineIndex=");
        sb.append(this.startLineIndex);
        sb.append(", endLineIndex=");
        sb.append(this.endLineIndex);
        sb.append(", top=");
        sb.append(this.top);
        sb.append(", bottom=");
        return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.bottom, ')');
    }
}
