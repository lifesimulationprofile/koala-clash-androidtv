package androidx.compose.ui.text;

import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.camera.camera2.internal.ZslControlImpl$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.android.LayoutIntrinsics;
import androidx.compose.ui.text.android.StaticLayoutFactory;
import androidx.compose.ui.text.android.TextAndroidCanvas;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.android.TextLayout_androidKt;
import androidx.compose.ui.text.android.selection.GraphemeClusterSegmentFinderApi29;
import androidx.compose.ui.text.android.selection.GraphemeClusterSegmentFinderUnderApi29;
import androidx.compose.ui.text.android.selection.SegmentFinder;
import androidx.compose.ui.text.android.style.IndentationFixSpan;
import androidx.compose.ui.text.android.style.PlaceholderSpan;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.text.platform.AndroidParagraphHelper_androidKt;
import androidx.compose.ui.text.platform.AndroidParagraphHelper_androidKt$NoopSpan$1;
import androidx.compose.ui.text.platform.AndroidParagraphIntrinsics;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import androidx.compose.ui.text.platform.style.ShaderBrushSpan;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.core.view.WindowInsetsCompat$TypeImpl34$$ExternalSyntheticApiModelOutline0;
import coil.request.RequestService;
import java.util.ArrayList;
import kotlin.collections.EmptyList;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidParagraph {
    public final CharSequence charSequence;
    public final long constraints;
    public final TextLayout layout;
    public final int maxLines;
    public final AndroidParagraphIntrinsics paragraphIntrinsics;
    public final Object placeholderRects;

    /* JADX WARN: Code duplicated, block: B:102:0x013f  */
    /* JADX WARN: Code duplicated, block: B:104:0x014a  */
    /* JADX WARN: Code duplicated, block: B:116:0x0196  */
    /* JADX WARN: Code duplicated, block: B:136:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:139:0x0209  */
    /* JADX WARN: Code duplicated, block: B:140:0x020b  */
    /* JADX WARN: Code duplicated, block: B:142:0x0222  */
    /* JADX WARN: Code duplicated, block: B:144:0x0239  */
    /* JADX WARN: Code duplicated, block: B:146:0x023d A[LOOP:1: B:145:0x023b->B:146:0x023d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:149:0x0268  */
    /* JADX WARN: Code duplicated, block: B:150:0x026c  */
    /* JADX WARN: Code duplicated, block: B:152:0x0284  */
    /* JADX WARN: Code duplicated, block: B:154:0x029c  */
    /* JADX WARN: Code duplicated, block: B:155:0x029e  */
    /* JADX WARN: Code duplicated, block: B:158:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:161:0x02be  */
    /* JADX WARN: Code duplicated, block: B:164:0x02c7  */
    /* JADX WARN: Code duplicated, block: B:165:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:167:0x02cc A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:169:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:70:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:82:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:91:0x0117  */
    /* JADX WARN: Code duplicated, block: B:93:0x0120  */
    /* JADX WARN: Code duplicated, block: B:95:0x0123  */
    /* JADX WARN: Code duplicated, block: B:96:0x0126  */
    /* JADX WARN: Code duplicated, block: B:98:0x0129  */
    /* JADX WARN: Code duplicated, block: B:99:0x012c  */
    /* JADX WARN: Instruction removed from duplicated block: B:144:0x0239, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:150:0x026c, please report this as an issue */
    public AndroidParagraph(AndroidParagraphIntrinsics androidParagraphIntrinsics, int i, int i2, long j) {
        int i3;
        CharSequence charSequence;
        int i4;
        int i5;
        int i6;
        char c;
        TextUtils.TruncateAt truncateAt;
        TextUtils.TruncateAt truncateAt2;
        TextLayout textLayoutConstructTextLayout;
        int i7;
        AndroidParagraph androidParagraph;
        int i8;
        int i9;
        int i10;
        Layout layout;
        Spanned spanned;
        ShaderBrushSpan[] shaderBrushSpanArr;
        CharSequence charSequence2;
        Spanned spanned2;
        ArrayList arrayList;
        int i11;
        Object obj;
        int spanEnd;
        int lineForOffset;
        boolean z;
        boolean z2;
        boolean z3;
        Rect rect;
        float secondaryHorizontal;
        int widthPx;
        float primaryHorizontal;
        int widthPx2;
        int i12;
        int i13;
        this.paragraphIntrinsics = androidParagraphIntrinsics;
        this.maxLines = i;
        this.constraints = j;
        if (Constraints.m684getMinHeightimpl(j) != 0 || Constraints.m685getMinWidthimpl(j) != 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Setting Constraints.minWidth and Constraints.minHeight is not supported, these should be the default zero values instead.");
        }
        if (i < 1) {
            InlineClassHelperKt.throwIllegalArgumentException("maxLines should be greater than 0");
        }
        TextStyle textStyle = androidParagraphIntrinsics.style;
        CharSequence charSequence3 = androidParagraphIntrinsics.charSequence;
        if (i2 == 2) {
            i3 = 0;
            if (!TextUnit.m725equalsimpl0(textStyle.spanStyle.letterSpacing, TextUnitKt.getSp(0)) && !TextUnit.m725equalsimpl0(textStyle.spanStyle.letterSpacing, TextUnit.Unspecified) && (i13 = textStyle.paragraphStyle.textAlign) != 0 && i13 != 5 && i13 != 4 && charSequence3.length() != 0) {
                Spannable spannableString = charSequence3 instanceof Spannable ? (Spannable) charSequence3 : null;
                if (spannableString == null) {
                    charSequence = charSequence3;
                    charSequence = charSequence3;
                    spannableString = new SpannableString(charSequence3);
                }
                charSequence = charSequence3;
                charSequence = charSequence3;
                Spannable spannable = spannableString;
                boolean zHasSpan = StaticLayoutFactory.hasSpan(spannable, IndentationFixSpan.class);
                charSequence = spannable;
                if (!zHasSpan) {
                    spannable.setSpan(new IndentationFixSpan(), spannable.length() - 1, spannable.length() - 1, 33);
                    charSequence = spannable;
                }
            }
        } else {
            i3 = 0;
            charSequence = charSequence3;
        }
        charSequence = charSequence3;
        charSequence = charSequence3;
        charSequence = charSequence3;
        charSequence = charSequence3;
        charSequence = charSequence3;
        charSequence = charSequence3;
        charSequence = charSequence3;
        charSequence = charSequence3;
        charSequence = charSequence3;
        CharSequence charSequence4 = charSequence;
        this.charSequence = charSequence4;
        ParagraphStyle paragraphStyle = textStyle.paragraphStyle;
        SpanStyle spanStyle = textStyle.spanStyle;
        int i14 = paragraphStyle.textAlign;
        int i15 = 3;
        int i16 = i14 == 1 ? 3 : i14 == 2 ? 4 : i14 == 3 ? 2 : (i14 != 5 && i14 == 6) ? 1 : i3;
        int i17 = i14 == 4 ? 1 : i3;
        int i18 = paragraphStyle.hyphens == 2 ? Build.VERSION.SDK_INT <= 32 ? 2 : 4 : i3;
        int i19 = paragraphStyle.lineBreak;
        int i20 = i19 & 255;
        if (i20 == 1) {
            i4 = i3;
        } else if (i20 == 2) {
            i4 = 1;
        } else if (i20 == 3) {
            i4 = 2;
        } else {
            i4 = i3;
        }
        int i21 = (i19 >> 8) & 255;
        if (i21 == 1) {
            i15 = i3;
        } else if (i21 == 2) {
            i15 = 1;
        } else if (i21 == 3) {
            i15 = 2;
        } else if (i21 != 4) {
            i15 = i3;
        }
        int i22 = (i19 >> 16) & 255;
        if (i22 != 1) {
            i5 = 2;
            i6 = i22 == 2 ? 1 : i6;
            if (i2 == i5) {
                truncateAt2 = TextUtils.TruncateAt.END;
            } else {
                if (i2 == 5) {
                    if (i2 == 4) {
                        truncateAt2 = TextUtils.TruncateAt.START;
                    } else {
                        c = ' ';
                        truncateAt = null;
                    }
                    textLayoutConstructTextLayout = constructTextLayout(i16, i17, truncateAt, i, i18, i4, i15, i6, charSequence4);
                    Layout layout2 = textLayoutConstructTextLayout.layout;
                    i7 = i16;
                    if (Build.VERSION.SDK_INT < 35 || androidParagraphIntrinsics.textPaint.getLetterSpacing() == 0.0f || (!(i2 == 4 || i2 == 5) || layout2.getEllipsisCount(0) <= 0)) {
                        androidParagraph = this;
                        i8 = i;
                        i9 = i7;
                        i10 = 2;
                    } else {
                        int ellipsisStart = layout2.getEllipsisStart(0);
                        i10 = 2;
                        CharSequence[] charSequenceArr = {charSequence4.subSequence(0, ellipsisStart), "…", charSequence4.subSequence(layout2.getEllipsisCount(0) + ellipsisStart, charSequence4.length())};
                        AndroidParagraph androidParagraph2 = this;
                        i8 = i;
                        i9 = i7;
                        textLayoutConstructTextLayout = androidParagraph2.constructTextLayout(i9, i17, truncateAt, i8, i18, i4, i15, i6, TextUtils.concat(charSequenceArr));
                        androidParagraph = androidParagraph2;
                    }
                    int i23 = textLayoutConstructTextLayout.lineCount;
                    if (i2 == i10 || textLayoutConstructTextLayout.getHeight() <= Constraints.m682getMaxHeightimpl(j) || i8 <= 1) {
                        androidParagraph.layout = textLayoutConstructTextLayout;
                    } else {
                        int iM682getMaxHeightimpl = Constraints.m682getMaxHeightimpl(j);
                        int i24 = 0;
                        while (true) {
                            if (i24 >= i23) {
                                i24 = i23;
                                break;
                            } else if (textLayoutConstructTextLayout.getLineBottom(i24) > iM682getMaxHeightimpl) {
                                break;
                            } else {
                                i24++;
                            }
                        }
                        if (i24 >= 0 && i24 != androidParagraph.maxLines) {
                            textLayoutConstructTextLayout = androidParagraph.constructTextLayout(i9, i17, truncateAt, i24 < 1 ? 1 : i24, i18, i4, i15, i6, androidParagraph.charSequence);
                        }
                        androidParagraph.layout = textLayoutConstructTextLayout;
                    }
                    androidParagraph.paragraphIntrinsics.textPaint.m665setBrush12SF9DM(spanStyle.textForegroundStyle.getBrush(), (((long) Float.floatToRawIntBits(androidParagraph.getHeight())) & 4294967295L) | (((long) Float.floatToRawIntBits(androidParagraph.getWidth())) << c), spanStyle.textForegroundStyle.getAlpha());
                    layout = androidParagraph.layout.layout;
                    if (layout.getText() instanceof Spanned) {
                        spanned = (Spanned) layout.getText();
                        if (spanned.nextSpanTransition(-1, spanned.length(), ShaderBrushSpan.class) != spanned.length()) {
                            shaderBrushSpanArr = (ShaderBrushSpan[]) ((Spanned) layout.getText()).getSpans(0, layout.getText().length(), ShaderBrushSpan.class);
                        } else {
                            shaderBrushSpanArr = null;
                        }
                    } else {
                        shaderBrushSpanArr = null;
                    }
                    if (shaderBrushSpanArr != null) {
                        for (ShaderBrushSpan shaderBrushSpan : shaderBrushSpanArr) {
                            shaderBrushSpan.size$delegate.setValue(new Size((((long) Float.floatToRawIntBits(androidParagraph.getHeight())) & 4294967295L) | (((long) Float.floatToRawIntBits(androidParagraph.getWidth())) << c)));
                        }
                    }
                    charSequence2 = androidParagraph.charSequence;
                    if (charSequence2 instanceof Spanned) {
                        spanned2 = (Spanned) charSequence2;
                        Object[] spans = spanned2.getSpans(0, charSequence2.length(), PlaceholderSpan.class);
                        arrayList = new ArrayList(spans.length);
                        for (Object obj2 : spans) {
                            PlaceholderSpan placeholderSpan = (PlaceholderSpan) obj2;
                            int spanStart = spanned2.getSpanStart(placeholderSpan);
                            spanEnd = spanned2.getSpanEnd(placeholderSpan);
                            lineForOffset = androidParagraph.layout.layout.getLineForOffset(spanStart);
                            if (lineForOffset >= androidParagraph.maxLines) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (androidParagraph.layout.layout.getEllipsisCount(lineForOffset) > 0 || spanEnd <= androidParagraph.layout.layout.getEllipsisStart(lineForOffset) + androidParagraph.layout.layout.getLineStart(lineForOffset)) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            if (spanEnd > androidParagraph.layout.getLineEnd(lineForOffset)) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (z2 && !z3 && !z) {
                                boolean z4 = androidParagraph.layout.layout.getParagraphDirection(lineForOffset) == 1;
                                boolean zIsRtlCharAt = androidParagraph.layout.layout.isRtlCharAt(spanStart);
                                if (!z4 || zIsRtlCharAt) {
                                    if (z4 && zIsRtlCharAt) {
                                        primaryHorizontal = androidParagraph.layout.getSecondaryHorizontal(spanStart, false);
                                        widthPx2 = placeholderSpan.getWidthPx();
                                    } else if (zIsRtlCharAt) {
                                        primaryHorizontal = androidParagraph.layout.getPrimaryHorizontal(spanStart, false);
                                        widthPx2 = placeholderSpan.getWidthPx();
                                    } else {
                                        secondaryHorizontal = androidParagraph.layout.getSecondaryHorizontal(spanStart, false);
                                        widthPx = placeholderSpan.getWidthPx();
                                    }
                                    secondaryHorizontal = primaryHorizontal - widthPx2;
                                    TextLayout textLayout = androidParagraph.layout;
                                    placeholderSpan.getClass();
                                    float lineBaseline = textLayout.getLineBaseline(lineForOffset) - placeholderSpan.getHeightPx();
                                    rect = new Rect(secondaryHorizontal, lineBaseline, primaryHorizontal, placeholderSpan.getHeightPx() + lineBaseline);
                                } else {
                                    secondaryHorizontal = androidParagraph.layout.getPrimaryHorizontal(spanStart, false);
                                    widthPx = placeholderSpan.getWidthPx();
                                }
                                primaryHorizontal = widthPx + secondaryHorizontal;
                                TextLayout textLayout2 = androidParagraph.layout;
                                placeholderSpan.getClass();
                                float lineBaseline2 = textLayout2.getLineBaseline(lineForOffset) - placeholderSpan.getHeightPx();
                                rect = new Rect(secondaryHorizontal, lineBaseline2, primaryHorizontal, placeholderSpan.getHeightPx() + lineBaseline2);
                            }
                            arrayList.add(rect);
                        }
                        obj = arrayList;
                    } else {
                        obj = EmptyList.INSTANCE;
                    }
                    androidParagraph.placeholderRects = obj;
                }
                truncateAt2 = TextUtils.TruncateAt.MIDDLE;
            }
            c = ' ';
            truncateAt = truncateAt2;
            textLayoutConstructTextLayout = constructTextLayout(i16, i17, truncateAt, i, i18, i4, i15, i6, charSequence4);
            Layout layout3 = textLayoutConstructTextLayout.layout;
            i7 = i16;
            if (Build.VERSION.SDK_INT < 35) {
                androidParagraph = this;
                i8 = i;
                i9 = i7;
                i10 = 2;
            } else {
                androidParagraph = this;
                i8 = i;
                i9 = i7;
                i10 = 2;
            }
            int i25 = textLayoutConstructTextLayout.lineCount;
            if (i2 == i10) {
                androidParagraph.layout = textLayoutConstructTextLayout;
            } else {
                androidParagraph.layout = textLayoutConstructTextLayout;
            }
            androidParagraph.paragraphIntrinsics.textPaint.m665setBrush12SF9DM(spanStyle.textForegroundStyle.getBrush(), (((long) Float.floatToRawIntBits(androidParagraph.getHeight())) & 4294967295L) | (((long) Float.floatToRawIntBits(androidParagraph.getWidth())) << c), spanStyle.textForegroundStyle.getAlpha());
            layout = androidParagraph.layout.layout;
            if (layout.getText() instanceof Spanned) {
                shaderBrushSpanArr = null;
            } else {
                spanned = (Spanned) layout.getText();
                if (spanned.nextSpanTransition(-1, spanned.length(), ShaderBrushSpan.class) != spanned.length()) {
                    shaderBrushSpanArr = (ShaderBrushSpan[]) ((Spanned) layout.getText()).getSpans(0, layout.getText().length(), ShaderBrushSpan.class);
                } else {
                    shaderBrushSpanArr = null;
                }
            }
            if (shaderBrushSpanArr != null) {
                while (i12 < r2) {
                    shaderBrushSpan.size$delegate.setValue(new Size((((long) Float.floatToRawIntBits(androidParagraph.getHeight())) & 4294967295L) | (((long) Float.floatToRawIntBits(androidParagraph.getWidth())) << c)));
                }
            }
            charSequence2 = androidParagraph.charSequence;
            if (charSequence2 instanceof Spanned) {
                obj = EmptyList.INSTANCE;
            } else {
                spanned2 = (Spanned) charSequence2;
                Object[] spans2 = spanned2.getSpans(0, charSequence2.length(), PlaceholderSpan.class);
                arrayList = new ArrayList(spans2.length);
                while (i11 < r4) {
                    PlaceholderSpan placeholderSpan2 = (PlaceholderSpan) obj2;
                    int spanStart2 = spanned2.getSpanStart(placeholderSpan2);
                    spanEnd = spanned2.getSpanEnd(placeholderSpan2);
                    lineForOffset = androidParagraph.layout.layout.getLineForOffset(spanStart2);
                    if (lineForOffset >= androidParagraph.maxLines) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (androidParagraph.layout.layout.getEllipsisCount(lineForOffset) > 0) {
                        z2 = false;
                    } else {
                        z2 = false;
                    }
                    if (spanEnd > androidParagraph.layout.getLineEnd(lineForOffset)) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    rect = z2 ? null : null;
                    arrayList.add(rect);
                }
                obj = arrayList;
            }
            androidParagraph.placeholderRects = obj;
        }
        i5 = 2;
        i6 = i3;
        if (i2 == i5) {
            truncateAt2 = TextUtils.TruncateAt.END;
        } else {
            if (i2 == 5) {
                if (i2 == 4) {
                    truncateAt2 = TextUtils.TruncateAt.START;
                } else {
                    c = ' ';
                    truncateAt = null;
                }
                textLayoutConstructTextLayout = constructTextLayout(i16, i17, truncateAt, i, i18, i4, i15, i6, charSequence4);
                Layout layout4 = textLayoutConstructTextLayout.layout;
                i7 = i16;
                if (Build.VERSION.SDK_INT < 35) {
                    androidParagraph = this;
                    i8 = i;
                    i9 = i7;
                    i10 = 2;
                } else {
                    androidParagraph = this;
                    i8 = i;
                    i9 = i7;
                    i10 = 2;
                }
                int i26 = textLayoutConstructTextLayout.lineCount;
                if (i2 == i10) {
                    androidParagraph.layout = textLayoutConstructTextLayout;
                } else {
                    androidParagraph.layout = textLayoutConstructTextLayout;
                }
                androidParagraph.paragraphIntrinsics.textPaint.m665setBrush12SF9DM(spanStyle.textForegroundStyle.getBrush(), (((long) Float.floatToRawIntBits(androidParagraph.getHeight())) & 4294967295L) | (((long) Float.floatToRawIntBits(androidParagraph.getWidth())) << c), spanStyle.textForegroundStyle.getAlpha());
                layout = androidParagraph.layout.layout;
                if (layout.getText() instanceof Spanned) {
                    shaderBrushSpanArr = null;
                } else {
                    spanned = (Spanned) layout.getText();
                    if (spanned.nextSpanTransition(-1, spanned.length(), ShaderBrushSpan.class) != spanned.length()) {
                        shaderBrushSpanArr = (ShaderBrushSpan[]) ((Spanned) layout.getText()).getSpans(0, layout.getText().length(), ShaderBrushSpan.class);
                    } else {
                        shaderBrushSpanArr = null;
                    }
                }
                if (shaderBrushSpanArr != null) {
                    while (i12 < r2) {
                        shaderBrushSpan.size$delegate.setValue(new Size((((long) Float.floatToRawIntBits(androidParagraph.getHeight())) & 4294967295L) | (((long) Float.floatToRawIntBits(androidParagraph.getWidth())) << c)));
                    }
                }
                charSequence2 = androidParagraph.charSequence;
                if (charSequence2 instanceof Spanned) {
                    obj = EmptyList.INSTANCE;
                } else {
                    spanned2 = (Spanned) charSequence2;
                    Object[] spans3 = spanned2.getSpans(0, charSequence2.length(), PlaceholderSpan.class);
                    arrayList = new ArrayList(spans3.length);
                    while (i11 < r4) {
                        PlaceholderSpan placeholderSpan3 = (PlaceholderSpan) obj2;
                        int spanStart3 = spanned2.getSpanStart(placeholderSpan3);
                        spanEnd = spanned2.getSpanEnd(placeholderSpan3);
                        lineForOffset = androidParagraph.layout.layout.getLineForOffset(spanStart3);
                        if (lineForOffset >= androidParagraph.maxLines) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (androidParagraph.layout.layout.getEllipsisCount(lineForOffset) > 0) {
                            z2 = false;
                        } else {
                            z2 = false;
                        }
                        if (spanEnd > androidParagraph.layout.getLineEnd(lineForOffset)) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z2) {
                        }
                        arrayList.add(rect);
                    }
                    obj = arrayList;
                }
                androidParagraph.placeholderRects = obj;
            }
            truncateAt2 = TextUtils.TruncateAt.MIDDLE;
        }
        c = ' ';
        truncateAt = truncateAt2;
        textLayoutConstructTextLayout = constructTextLayout(i16, i17, truncateAt, i, i18, i4, i15, i6, charSequence4);
        Layout layout5 = textLayoutConstructTextLayout.layout;
        i7 = i16;
        if (Build.VERSION.SDK_INT < 35) {
            androidParagraph = this;
            i8 = i;
            i9 = i7;
            i10 = 2;
        } else {
            androidParagraph = this;
            i8 = i;
            i9 = i7;
            i10 = 2;
        }
        int i27 = textLayoutConstructTextLayout.lineCount;
        if (i2 == i10) {
            androidParagraph.layout = textLayoutConstructTextLayout;
        } else {
            androidParagraph.layout = textLayoutConstructTextLayout;
        }
        androidParagraph.paragraphIntrinsics.textPaint.m665setBrush12SF9DM(spanStyle.textForegroundStyle.getBrush(), (((long) Float.floatToRawIntBits(androidParagraph.getHeight())) & 4294967295L) | (((long) Float.floatToRawIntBits(androidParagraph.getWidth())) << c), spanStyle.textForegroundStyle.getAlpha());
        layout = androidParagraph.layout.layout;
        if (layout.getText() instanceof Spanned) {
            shaderBrushSpanArr = null;
        } else {
            spanned = (Spanned) layout.getText();
            if (spanned.nextSpanTransition(-1, spanned.length(), ShaderBrushSpan.class) != spanned.length()) {
                shaderBrushSpanArr = (ShaderBrushSpan[]) ((Spanned) layout.getText()).getSpans(0, layout.getText().length(), ShaderBrushSpan.class);
            } else {
                shaderBrushSpanArr = null;
            }
        }
        if (shaderBrushSpanArr != null) {
            while (i12 < r2) {
                shaderBrushSpan.size$delegate.setValue(new Size((((long) Float.floatToRawIntBits(androidParagraph.getHeight())) & 4294967295L) | (((long) Float.floatToRawIntBits(androidParagraph.getWidth())) << c)));
            }
        }
        charSequence2 = androidParagraph.charSequence;
        if (charSequence2 instanceof Spanned) {
            obj = EmptyList.INSTANCE;
        } else {
            spanned2 = (Spanned) charSequence2;
            Object[] spans4 = spanned2.getSpans(0, charSequence2.length(), PlaceholderSpan.class);
            arrayList = new ArrayList(spans4.length);
            while (i11 < r4) {
                PlaceholderSpan placeholderSpan4 = (PlaceholderSpan) obj2;
                int spanStart4 = spanned2.getSpanStart(placeholderSpan4);
                spanEnd = spanned2.getSpanEnd(placeholderSpan4);
                lineForOffset = androidParagraph.layout.layout.getLineForOffset(spanStart4);
                if (lineForOffset >= androidParagraph.maxLines) {
                    z = true;
                } else {
                    z = false;
                }
                if (androidParagraph.layout.layout.getEllipsisCount(lineForOffset) > 0) {
                    z2 = false;
                } else {
                    z2 = false;
                }
                if (spanEnd > androidParagraph.layout.getLineEnd(lineForOffset)) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z2) {
                }
                arrayList.add(rect);
            }
            obj = arrayList;
        }
        androidParagraph.placeholderRects = obj;
    }

    public final TextLayout constructTextLayout(int i, int i2, TextUtils.TruncateAt truncateAt, int i3, int i4, int i5, int i6, int i7, CharSequence charSequence) {
        PlatformParagraphStyle platformParagraphStyle;
        float width = getWidth();
        AndroidParagraphIntrinsics androidParagraphIntrinsics = this.paragraphIntrinsics;
        AndroidTextPaint androidTextPaint = androidParagraphIntrinsics.textPaint;
        int i8 = androidParagraphIntrinsics.textDirectionHeuristic;
        LayoutIntrinsics layoutIntrinsics = androidParagraphIntrinsics.layoutIntrinsics;
        TextStyle textStyle = androidParagraphIntrinsics.style;
        AndroidParagraphHelper_androidKt$NoopSpan$1 androidParagraphHelper_androidKt$NoopSpan$1 = AndroidParagraphHelper_androidKt.NoopSpan;
        PlatformTextStyle platformTextStyle = textStyle.platformStyle;
        return new TextLayout(charSequence, width, androidTextPaint, i, truncateAt, i8, (platformTextStyle == null || (platformParagraphStyle = platformTextStyle.paragraphStyle) == null) ? false : platformParagraphStyle.includeFontPadding, i3, i5, i6, i7, i4, i2, layoutIntrinsics);
    }

    public final float getHeight() {
        return this.layout.getHeight();
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00d7  */
    /* JADX WARN: Type inference failed for: r13v26, types: [androidx.compose.ui.text.android.AndroidLayoutApi34$$ExternalSyntheticLambda4] */
    /* JADX INFO: renamed from: getRangeForRect-8-6BmAI, reason: not valid java name */
    public final long m622getRangeForRect86BmAI(Rect rect, int i, ZslControlImpl$$ExternalSyntheticLambda0 zslControlImpl$$ExternalSyntheticLambda0) {
        SegmentFinder graphemeClusterSegmentFinderApi29;
        int i2;
        int[] rangeForRect;
        android.text.SegmentFinder segmentFinderM;
        RectF androidRectF = BrushKt.toAndroidRectF(rect);
        boolean z = i != 0 && i == 1;
        final Updater$$ExternalSyntheticLambda0 updater$$ExternalSyntheticLambda0 = new Updater$$ExternalSyntheticLambda0(26, zslControlImpl$$ExternalSyntheticLambda0);
        TextLayout textLayout = this.layout;
        TextPaint textPaint = textLayout.textPaint;
        Layout layout = textLayout.layout;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 34) {
            if (z) {
                final RequestService requestService = new RequestService(9, layout.getText(), textLayout.getWordIterator());
                segmentFinderM = new android.text.SegmentFinder() { // from class: androidx.compose.ui.text.android.selection.Api34SegmentFinder$toAndroidSegmentFinder$1
                    public final int nextEndBoundary(int i4) {
                        return requestService.nextEndBoundary(i4);
                    }

                    public final int nextStartBoundary(int i4) {
                        return requestService.nextStartBoundary(i4);
                    }

                    public final int previousEndBoundary(int i4) {
                        return requestService.previousEndBoundary(i4);
                    }

                    public final int previousStartBoundary(int i4) {
                        return requestService.previousStartBoundary(i4);
                    }
                };
            } else {
                WindowInsetsCompat$TypeImpl34$$ExternalSyntheticApiModelOutline0.m771m();
                segmentFinderM = WindowInsetsCompat$TypeImpl34$$ExternalSyntheticApiModelOutline0.m((Object) WindowInsetsCompat$TypeImpl34$$ExternalSyntheticApiModelOutline0.m(layout.getText(), textPaint));
            }
            rangeForRect = layout.getRangeForRect(androidRectF, segmentFinderM, new Layout.TextInclusionStrategy() { // from class: androidx.compose.ui.text.android.AndroidLayoutApi34$$ExternalSyntheticLambda4
                @Override // android.text.Layout.TextInclusionStrategy
                public final boolean isSegmentInside(RectF rectF, RectF rectF2) {
                    return ((Boolean) updater$$ExternalSyntheticLambda0.invoke(rectF, rectF2)).booleanValue();
                }
            });
        } else {
            Request layoutHelper = textLayout.getLayoutHelper();
            if (z) {
                graphemeClusterSegmentFinderApi29 = new RequestService(9, layout.getText(), textLayout.getWordIterator());
            } else {
                CharSequence text = layout.getText();
                graphemeClusterSegmentFinderApi29 = i3 >= 29 ? new GraphemeClusterSegmentFinderApi29(text, textPaint) : new GraphemeClusterSegmentFinderUnderApi29(text);
            }
            SegmentFinder segmentFinder = graphemeClusterSegmentFinderApi29;
            int lineForVertical = layout.getLineForVertical((int) androidRectF.top);
            if (androidRectF.top <= textLayout.getLineBottom(lineForVertical) || (lineForVertical = lineForVertical + 1) < textLayout.lineCount) {
                int i4 = lineForVertical;
                int lineForVertical2 = layout.getLineForVertical((int) androidRectF.bottom);
                if (lineForVertical2 != 0 || androidRectF.bottom >= textLayout.getLineTop(0)) {
                    int startOrEndOffsetForRectWithinLine = StaticLayoutFactory.getStartOrEndOffsetForRectWithinLine(textLayout, layout, layoutHelper, i4, androidRectF, segmentFinder, updater$$ExternalSyntheticLambda0, true);
                    while (true) {
                        i2 = i4;
                        if (startOrEndOffsetForRectWithinLine != -1 || i2 >= lineForVertical2) {
                            break;
                        }
                        i4 = i2 + 1;
                        startOrEndOffsetForRectWithinLine = StaticLayoutFactory.getStartOrEndOffsetForRectWithinLine(textLayout, layout, layoutHelper, i4, androidRectF, segmentFinder, updater$$ExternalSyntheticLambda0, true);
                    }
                    if (startOrEndOffsetForRectWithinLine == -1) {
                        rangeForRect = null;
                    } else {
                        int i5 = lineForVertical2;
                        int startOrEndOffsetForRectWithinLine2 = StaticLayoutFactory.getStartOrEndOffsetForRectWithinLine(textLayout, layout, layoutHelper, i5, androidRectF, segmentFinder, updater$$ExternalSyntheticLambda0, false);
                        while (startOrEndOffsetForRectWithinLine2 == -1 && i2 < i5) {
                            i5--;
                            startOrEndOffsetForRectWithinLine2 = StaticLayoutFactory.getStartOrEndOffsetForRectWithinLine(textLayout, layout, layoutHelper, i5, androidRectF, segmentFinder, updater$$ExternalSyntheticLambda0, false);
                        }
                        if (startOrEndOffsetForRectWithinLine2 == -1) {
                            rangeForRect = null;
                        } else {
                            rangeForRect = new int[]{segmentFinder.previousStartBoundary(startOrEndOffsetForRectWithinLine + 1), segmentFinder.nextEndBoundary(startOrEndOffsetForRectWithinLine2 - 1)};
                        }
                    }
                } else {
                    rangeForRect = null;
                }
            } else {
                rangeForRect = null;
            }
        }
        return rangeForRect == null ? TextRange.Zero : ParagraphKt.TextRange(rangeForRect[0], rangeForRect[1]);
    }

    public final float getWidth() {
        return Constraints.m683getMaxWidthimpl(this.constraints);
    }

    public final void paint(Canvas canvas) {
        android.graphics.Canvas canvas2 = AndroidCanvas_androidKt.EmptyCanvas;
        android.graphics.Canvas canvas3 = ((AndroidCanvas) canvas).internalCanvas;
        TextLayout textLayout = this.layout;
        if (textLayout.didExceedMaxLines) {
            canvas3.save();
            canvas3.clipRect(0.0f, 0.0f, getWidth(), getHeight());
        }
        int i = textLayout.topPadding;
        if (canvas3.getClipBounds(textLayout.rect)) {
            if (i != 0) {
                canvas3.translate(0.0f, i);
            }
            ThreadLocal threadLocal = TextLayout_androidKt.SharedTextAndroidCanvas;
            Object textAndroidCanvas = threadLocal.get();
            if (textAndroidCanvas == null) {
                textAndroidCanvas = new TextAndroidCanvas();
                threadLocal.set(textAndroidCanvas);
            }
            TextAndroidCanvas textAndroidCanvas2 = (TextAndroidCanvas) textAndroidCanvas;
            textAndroidCanvas2._nativeCanvas = canvas3;
            try {
                textLayout.layout.draw(textAndroidCanvas2);
                textAndroidCanvas2._nativeCanvas = null;
                if (i != 0) {
                    canvas3.translate(0.0f, (-1) * i);
                }
            } catch (Throwable th) {
                textAndroidCanvas2._nativeCanvas = null;
                throw th;
            }
        }
        if (textLayout.didExceedMaxLines) {
            canvas3.restore();
        }
    }

    /* JADX INFO: renamed from: paint-LG529CI, reason: not valid java name */
    public final void m623paintLG529CI(Canvas canvas, long j, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle) {
        AndroidTextPaint androidTextPaint = this.paragraphIntrinsics.textPaint;
        int i = androidTextPaint.backingBlendMode;
        androidTextPaint.m666setColor8_81llA(j);
        androidTextPaint.setShadow(shadow);
        androidTextPaint.setTextDecoration(textDecoration);
        androidTextPaint.setDrawStyle(drawStyle);
        androidTextPaint.m664setBlendModes9anfk8(3);
        paint(canvas);
        androidTextPaint.m664setBlendModes9anfk8(i);
    }

    /* JADX INFO: renamed from: paint-hn5TExg, reason: not valid java name */
    public final void m624painthn5TExg(Canvas canvas, Brush brush, float f, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle) {
        AndroidTextPaint androidTextPaint = this.paragraphIntrinsics.textPaint;
        int i = androidTextPaint.backingBlendMode;
        float width = getWidth();
        androidTextPaint.m665setBrush12SF9DM(brush, (((long) Float.floatToRawIntBits(getHeight())) & 4294967295L) | (Float.floatToRawIntBits(width) << 32), f);
        androidTextPaint.setShadow(shadow);
        androidTextPaint.setTextDecoration(textDecoration);
        androidTextPaint.setDrawStyle(drawStyle);
        androidTextPaint.m664setBlendModes9anfk8(3);
        paint(canvas);
        androidTextPaint.m664setBlendModes9anfk8(i);
    }
}
