package androidx.compose.ui.text.android;

import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.ui.node.LayoutNode$$ExternalSyntheticLambda0;
import androidx.compose.ui.scrollcapture.RelativeScroller;
import androidx.compose.ui.text.android.selection.SegmentFinder;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import java.text.Bidi;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class StaticLayoutFactory {
    public static final LayoutNode$$ExternalSyntheticLambda0 IntRangeComparator = new LayoutNode$$ExternalSyntheticLambda0(6);

    public static StaticLayout create(CharSequence charSequence, TextPaint textPaint, int i, int i2, TextDirectionHeuristic textDirectionHeuristic, Layout.Alignment alignment, int i3, TextUtils.TruncateAt truncateAt, int i4, int i5, boolean z, int i6, int i7, int i8, int i9) {
        if (i2 < 0) {
            InlineClassHelperKt.throwIllegalArgumentException("invalid start value");
        }
        int length = charSequence.length();
        if (i2 < 0 || i2 > length) {
            InlineClassHelperKt.throwIllegalArgumentException("invalid end value");
        }
        if (i3 < 0) {
            InlineClassHelperKt.throwIllegalArgumentException("invalid maxLines value");
        }
        if (i < 0) {
            InlineClassHelperKt.throwIllegalArgumentException("invalid width value");
        }
        if (i4 < 0) {
            InlineClassHelperKt.throwIllegalArgumentException("invalid ellipsizedWidth value");
        }
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequence, 0, i2, textPaint, i);
        builderObtain.setTextDirection(textDirectionHeuristic);
        builderObtain.setAlignment(alignment);
        builderObtain.setMaxLines(i3);
        builderObtain.setEllipsize(truncateAt);
        builderObtain.setEllipsizedWidth(i4);
        builderObtain.setLineSpacing(0.0f, 1.0f);
        builderObtain.setIncludePad(z);
        builderObtain.setBreakStrategy(i6);
        builderObtain.setHyphenationFrequency(i9);
        builderObtain.setIndents(null, null);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26) {
            builderObtain.setJustificationMode(i5);
        }
        if (i10 >= 28) {
            builderObtain.setUseLineSpacingFromFallbacks(true);
        }
        if (i10 >= 33) {
            builderObtain.setLineBreakConfig(ComponentDialog$$ExternalSyntheticApiModelOutline0.m().setLineBreakStyle(i7).setLineBreakWordStyle(i8).build());
        }
        if (i10 >= 35) {
            builderObtain.setUseBoundsForWidth(false);
        }
        return builderObtain.build();
    }

    public static final Rect getCharSequenceBounds(TextPaint textPaint, CharSequence charSequence, int i, int i2) {
        int i3 = i;
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            if (spanned.nextSpanTransition(i3 - 1, i2, MetricAffectingSpan.class) != i2) {
                Rect rect = new Rect();
                Rect rect2 = new Rect();
                TextPaint textPaint2 = new TextPaint();
                while (i3 < i2) {
                    int iNextSpanTransition = spanned.nextSpanTransition(i3, i2, MetricAffectingSpan.class);
                    MetricAffectingSpan[] metricAffectingSpanArr = (MetricAffectingSpan[]) spanned.getSpans(i3, iNextSpanTransition, MetricAffectingSpan.class);
                    textPaint2.set(textPaint);
                    for (MetricAffectingSpan metricAffectingSpan : metricAffectingSpanArr) {
                        if (spanned.getSpanStart(metricAffectingSpan) != spanned.getSpanEnd(metricAffectingSpan)) {
                            metricAffectingSpan.updateMeasureState(textPaint2);
                        }
                    }
                    if (Build.VERSION.SDK_INT >= 29) {
                        textPaint2.getTextBounds(charSequence, i3, iNextSpanTransition, rect2);
                    } else {
                        textPaint2.getTextBounds(charSequence.toString(), i3, iNextSpanTransition, rect2);
                    }
                    rect.right = rect2.width() + rect.right;
                    rect.top = Math.min(rect.top, rect2.top);
                    rect.bottom = Math.max(rect.bottom, rect2.bottom);
                    i3 = iNextSpanTransition;
                }
                return rect;
            }
        }
        Rect rect3 = new Rect();
        if (Build.VERSION.SDK_INT >= 29) {
            textPaint.getTextBounds(charSequence, i3, i2, rect3);
            return rect3;
        }
        textPaint.getTextBounds(charSequence.toString(), i3, i2, rect3);
        return rect3;
    }

    public static final float getCharacterRightBounds(int i, int i2, float[] fArr) {
        return fArr[((i - i2) * 2) + 1];
    }

    public static final int getLineForOffset(Layout layout, int i, boolean z) {
        if (i <= 0) {
            return 0;
        }
        if (i >= layout.getText().length()) {
            return layout.getLineCount() - 1;
        }
        int lineForOffset = layout.getLineForOffset(i);
        int lineStart = layout.getLineStart(lineForOffset);
        int lineEnd = layout.getLineEnd(lineForOffset);
        if (lineStart == i || lineEnd == i) {
            if (lineStart == i) {
                if (z) {
                    return lineForOffset - 1;
                }
            } else if (!z) {
                return lineForOffset + 1;
            }
        }
        return lineForOffset;
    }

    /* JADX WARN: Code duplicated, block: B:145:0x0266 A[EDGE_INSN: B:145:0x0266->B:172:0x02c2 BREAK  A[LOOP:5: B:155:0x0282->B:207:0x0282]] */
    public static final int getStartOrEndOffsetForRectWithinLine(TextLayout textLayout, Layout layout, Request request, int i, RectF rectF, SegmentFinder segmentFinder, Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0, boolean z) {
        LayoutHelper$BidiRun[] layoutHelper$BidiRunArr;
        int i2;
        int i3;
        LayoutHelper$BidiRun[] layoutHelper$BidiRunArr2;
        int i4;
        int iNextEndBoundary;
        int i5;
        int i6;
        int iPreviousStartBoundary;
        Bidi bidiCreateLineBidi;
        float f;
        float f2;
        float f3;
        int lineTop = layout.getLineTop(i);
        int lineBottom = layout.getLineBottom(i);
        int lineStart = layout.getLineStart(i);
        int lineEnd = layout.getLineEnd(i);
        if (lineStart == lineEnd) {
            return -1;
        }
        int i7 = (lineEnd - lineStart) * 2;
        float[] fArr = new float[i7];
        Layout layout2 = textLayout.layout;
        int lineStart2 = layout2.getLineStart(i);
        int lineEnd2 = textLayout.getLineEnd(i);
        if (i7 < (lineEnd2 - lineStart2) * 2) {
            InlineClassHelperKt.throwIllegalArgumentException("array.size - arrayStart must be greater or equal than (endOffset - startOffset) * 2");
        }
        RelativeScroller relativeScroller = new RelativeScroller(textLayout);
        boolean z2 = false;
        boolean z3 = layout2.getParagraphDirection(i) == 1;
        int i8 = 0;
        while (lineStart2 < lineEnd2) {
            boolean zIsRtlCharAt = layout2.isRtlCharAt(lineStart2);
            if (z3 && !zIsRtlCharAt) {
                f = relativeScroller.get(lineStart2, z2, z2, true);
                f3 = relativeScroller.get(lineStart2 + 1, true, true, true);
            } else if (z3 && zIsRtlCharAt) {
                f3 = relativeScroller.get(lineStart2, false, false, false);
                f = relativeScroller.get(lineStart2 + 1, true, true, false);
            } else {
                if (zIsRtlCharAt) {
                    f2 = relativeScroller.get(lineStart2, false, false, true);
                    f = relativeScroller.get(lineStart2 + 1, true, true, true);
                } else {
                    f = relativeScroller.get(lineStart2, false, false, false);
                    f2 = relativeScroller.get(lineStart2 + 1, true, true, false);
                }
                f3 = f2;
            }
            fArr[i8] = f;
            fArr[i8 + 1] = f3;
            i8 += 2;
            lineStart2++;
            z3 = z3;
            z2 = false;
        }
        Layout layout3 = (Layout) request.url;
        int lineStart3 = layout3.getLineStart(i);
        int lineEnd3 = layout3.getLineEnd(i);
        int paragraphForOffset = request.getParagraphForOffset(lineStart3, false);
        int paragraphStart = request.getParagraphStart(paragraphForOffset);
        int i9 = lineStart3 - paragraphStart;
        int i10 = lineEnd3 - paragraphStart;
        Bidi bidiAnalyzeBidi = request.analyzeBidi(paragraphForOffset);
        if (bidiAnalyzeBidi == null || (bidiCreateLineBidi = bidiAnalyzeBidi.createLineBidi(i9, i10)) == null) {
            i2 = 0;
            layoutHelper$BidiRunArr = new LayoutHelper$BidiRun[]{new LayoutHelper$BidiRun(lineStart3, lineEnd3, layout3.isRtlCharAt(lineStart3))};
        } else {
            int runCount = bidiCreateLineBidi.getRunCount();
            layoutHelper$BidiRunArr = new LayoutHelper$BidiRun[runCount];
            int i11 = 0;
            while (i11 < runCount) {
                int i12 = runCount;
                layoutHelper$BidiRunArr[i11] = new LayoutHelper$BidiRun(bidiCreateLineBidi.getRunStart(i11) + lineStart3, bidiCreateLineBidi.getRunLimit(i11) + lineStart3, bidiCreateLineBidi.getRunLevel(i11) % 2 == 1);
                i11++;
                runCount = i12;
            }
            i2 = 0;
        }
        IntProgression intRange = z ? new IntRange(i2, layoutHelper$BidiRunArr.length - 1, 1) : new IntProgression(layoutHelper$BidiRunArr.length - 1, i2, -1);
        int i13 = intRange.first;
        int i14 = intRange.last;
        int i15 = intRange.step;
        if ((i15 <= 0 || i13 > i14) && (i15 >= 0 || i14 > i13)) {
            return -1;
        }
        while (true) {
            LayoutHelper$BidiRun layoutHelper$BidiRun = layoutHelper$BidiRunArr[i13];
            boolean z4 = layoutHelper$BidiRun.isRtl;
            int iNextStartBoundary = layoutHelper$BidiRun.start;
            int iPreviousEndBoundary = layoutHelper$BidiRun.end;
            float f4 = z4 ? fArr[((iPreviousEndBoundary - 1) - lineStart) * 2] : fArr[(iNextStartBoundary - lineStart) * 2];
            float characterRightBounds = z4 ? getCharacterRightBounds(iNextStartBoundary, lineStart, fArr) : getCharacterRightBounds(iPreviousEndBoundary - 1, lineStart, fArr);
            if (z) {
                float f5 = rectF.left;
                if (characterRightBounds >= f5) {
                    i3 = i15;
                    float f6 = rectF.right;
                    if (f4 <= f6) {
                        if ((z4 || f5 > f4) && (!z4 || f6 < characterRightBounds)) {
                            int i16 = iPreviousEndBoundary;
                            int i17 = iNextStartBoundary;
                            while (true) {
                                i5 = i16;
                                if (i16 - i17 <= 1) {
                                    break;
                                }
                                int i18 = (i5 + i17) / 2;
                                float f7 = fArr[(i18 - lineStart) * 2];
                                if ((z4 || f7 <= rectF.left) && (!z4 || f7 >= rectF.right)) {
                                    i16 = i5;
                                    i17 = i18;
                                } else {
                                    i16 = i18;
                                }
                            }
                            i6 = z4 ? i5 : i17;
                        } else {
                            i6 = iNextStartBoundary;
                        }
                        int iNextEndBoundary2 = segmentFinder.nextEndBoundary(i6);
                        if (iNextEndBoundary2 != -1 && (iPreviousStartBoundary = segmentFinder.previousStartBoundary(iNextEndBoundary2)) < iPreviousEndBoundary) {
                            if (iPreviousStartBoundary >= iNextStartBoundary) {
                                iNextStartBoundary = iPreviousStartBoundary;
                            }
                            if (iNextEndBoundary2 > iPreviousEndBoundary) {
                                iNextEndBoundary2 = iPreviousEndBoundary;
                            }
                            layoutHelper$BidiRunArr2 = layoutHelper$BidiRunArr;
                            RectF rectF2 = new RectF(0.0f, lineTop, 0.0f, lineBottom);
                            int iNextEndBoundary3 = iNextEndBoundary2;
                            while (true) {
                                rectF2.left = z4 ? fArr[((iNextEndBoundary3 - 1) - lineStart) * 2] : fArr[(iNextStartBoundary - lineStart) * 2];
                                rectF2.right = z4 ? getCharacterRightBounds(iNextStartBoundary, lineStart, fArr) : getCharacterRightBounds(iNextEndBoundary3 - 1, lineStart, fArr);
                                if (((Boolean) updater$$ExternalSyntheticLambda0.invoke(rectF2, rectF)).booleanValue()) {
                                    break;
                                }
                                iNextStartBoundary = segmentFinder.nextStartBoundary(iNextStartBoundary);
                                if (iNextStartBoundary != -1 && iNextStartBoundary < iPreviousEndBoundary) {
                                    iNextEndBoundary3 = segmentFinder.nextEndBoundary(iNextStartBoundary);
                                    if (iNextEndBoundary3 > iPreviousEndBoundary) {
                                        iNextEndBoundary3 = iPreviousEndBoundary;
                                    }
                                }
                            }
                        }
                        iNextStartBoundary = -1;
                        break;
                    }
                } else {
                    i3 = i15;
                }
                layoutHelper$BidiRunArr2 = layoutHelper$BidiRunArr;
                iNextStartBoundary = -1;
                break;
            } else {
                i3 = i15;
                layoutHelper$BidiRunArr2 = layoutHelper$BidiRunArr;
                float f8 = rectF.left;
                if (characterRightBounds < f8) {
                    iPreviousEndBoundary = -1;
                    break;
                }
                float f9 = rectF.right;
                if (f4 <= f9) {
                    if ((z4 || f9 < characterRightBounds) && (!z4 || f8 > f4)) {
                        int i19 = iPreviousEndBoundary;
                        int i20 = iNextStartBoundary;
                        while (i19 - i20 > 1) {
                            int i21 = (i19 + i20) / 2;
                            float f10 = fArr[(i21 - lineStart) * 2];
                            int i22 = i19;
                            if ((z4 || f10 <= rectF.right) && (!z4 || f10 >= rectF.left)) {
                                i19 = i22;
                                i20 = i21;
                            } else {
                                i19 = i21;
                            }
                        }
                        i4 = z4 ? i19 : i20;
                    } else {
                        i4 = iPreviousEndBoundary - 1;
                    }
                    int iPreviousStartBoundary2 = segmentFinder.previousStartBoundary(i4 + 1);
                    if (iPreviousStartBoundary2 == -1 || (iNextEndBoundary = segmentFinder.nextEndBoundary(iPreviousStartBoundary2)) <= iNextStartBoundary) {
                        iPreviousEndBoundary = -1;
                        break;
                    }
                    if (iPreviousStartBoundary2 < iNextStartBoundary) {
                        iPreviousStartBoundary2 = iNextStartBoundary;
                    }
                    if (iNextEndBoundary <= iPreviousEndBoundary) {
                        iPreviousEndBoundary = iNextEndBoundary;
                    }
                    RectF rectF3 = new RectF(0.0f, lineTop, 0.0f, lineBottom);
                    int iPreviousStartBoundary3 = iPreviousStartBoundary2;
                    while (true) {
                        rectF3.left = z4 ? fArr[((iPreviousEndBoundary - 1) - lineStart) * 2] : fArr[(iPreviousStartBoundary3 - lineStart) * 2];
                        rectF3.right = z4 ? getCharacterRightBounds(iPreviousStartBoundary3, lineStart, fArr) : getCharacterRightBounds(iPreviousEndBoundary - 1, lineStart, fArr);
                        if (((Boolean) updater$$ExternalSyntheticLambda0.invoke(rectF3, rectF)).booleanValue()) {
                            break;
                        }
                        iPreviousEndBoundary = segmentFinder.previousEndBoundary(iPreviousEndBoundary);
                        if (iPreviousEndBoundary == -1 || iPreviousEndBoundary <= iNextStartBoundary) {
                            iPreviousEndBoundary = -1;
                            break;
                        }
                        iPreviousStartBoundary3 = segmentFinder.previousStartBoundary(iPreviousEndBoundary);
                        if (iPreviousStartBoundary3 < iNextStartBoundary) {
                            iPreviousStartBoundary3 = iNextStartBoundary;
                        }
                    }
                } else {
                    iPreviousEndBoundary = -1;
                    break;
                }
                iNextStartBoundary = iPreviousEndBoundary;
            }
            if (iNextStartBoundary >= 0) {
                return iNextStartBoundary;
            }
            if (i13 == i14) {
                return -1;
            }
            i13 += i3;
            i15 = i3;
            layoutHelper$BidiRunArr = layoutHelper$BidiRunArr2;
        }
    }

    public static final boolean hasSpan(Spanned spanned, Class cls) {
        return spanned.nextSpanTransition(-1, spanned.length(), cls) != spanned.length();
    }
}
