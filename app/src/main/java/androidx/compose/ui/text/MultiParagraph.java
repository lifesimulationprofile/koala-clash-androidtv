package androidx.compose.ui.text;

import android.graphics.Matrix;
import android.graphics.Shader;
import android.text.Layout;
import android.text.TextUtils;
import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.camera.camera2.internal.ZslControlImpl$$ExternalSyntheticLambda0;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt$ShaderBrush$1;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.android.TextLayout_androidKt;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.text.platform.AndroidParagraphIntrinsics;
import androidx.compose.ui.text.platform.AndroidTextPaint_androidKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import coil.network.HttpException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$IntRef;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MultiParagraph {
    public final boolean didExceedMaxLines;
    public final float height;
    public final Request intrinsics;
    public final int lineCount;
    public final int maxLines;
    public final ArrayList paragraphInfoList;
    public final ArrayList placeholderRects;
    public final float width;

    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.Object, java.util.Collection, java.util.List] */
    public MultiParagraph(Request request, long j, int i, int i2) {
        int i3;
        boolean z;
        int i4;
        int iM682getMaxHeightimpl;
        int i5;
        this.intrinsics = request;
        this.maxLines = i;
        if (Constraints.m685getMinWidthimpl(j) != 0 || Constraints.m684getMinHeightimpl(j) != 0) {
            InlineClassHelperKt.throwIllegalArgumentException("Setting Constraints.minWidth and Constraints.minHeight is not supported, these should be the default zero values instead.");
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = (ArrayList) request.lazyCacheControl;
        int size = arrayList2.size();
        float f = 0.0f;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            if (i6 >= size) {
                i3 = 0;
                z = false;
                break;
            }
            ParagraphIntrinsicInfo paragraphIntrinsicInfo = (ParagraphIntrinsicInfo) arrayList2.get(i6);
            AndroidParagraphIntrinsics androidParagraphIntrinsics = paragraphIntrinsicInfo.intrinsics;
            int iM683getMaxWidthimpl = Constraints.m683getMaxWidthimpl(j);
            if (Constraints.m678getHasBoundedHeightimpl(j)) {
                i4 = i6;
                iM682getMaxHeightimpl = Constraints.m682getMaxHeightimpl(j) - ((int) Math.ceil(f));
                if (iM682getMaxHeightimpl < 0) {
                    iM682getMaxHeightimpl = 0;
                }
            } else {
                i4 = i6;
                iM682getMaxHeightimpl = Constraints.m682getMaxHeightimpl(j);
            }
            i3 = 0;
            AndroidParagraph androidParagraph = new AndroidParagraph(androidParagraphIntrinsics, this.maxLines - i7, i2, ConstraintsKt.Constraints$default(0, iM683getMaxWidthimpl, 0, iM682getMaxHeightimpl, 5));
            float height = androidParagraph.getHeight() + f;
            TextLayout textLayout = androidParagraph.layout;
            int i8 = i7 + textLayout.lineCount;
            arrayList.add(new ParagraphInfo(androidParagraph, paragraphIntrinsicInfo.startIndex, paragraphIntrinsicInfo.endIndex, i7, i8, f, height));
            if (!textLayout.didExceedMaxLines) {
                if (i8 == this.maxLines) {
                    i5 = i4;
                    if (i5 != AppCompatHintHelper.getLastIndex((ArrayList) this.intrinsics.lazyCacheControl)) {
                    }
                } else {
                    i5 = i4;
                }
                i6 = i5 + 1;
                i7 = i8;
                f = height;
            }
            z = true;
            i7 = i8;
            f = height;
            break;
        }
        this.height = f;
        this.lineCount = i7;
        this.didExceedMaxLines = z;
        this.paragraphInfoList = arrayList;
        this.width = Constraints.m683getMaxWidthimpl(j);
        ArrayList arrayList3 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int i9 = i3; i9 < size2; i9++) {
            ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(i9);
            ?? r8 = paragraphInfo.paragraph.placeholderRects;
            ArrayList arrayList4 = new ArrayList(r8.size());
            int size3 = r8.size();
            for (int i10 = i3; i10 < size3; i10++) {
                Rect rect = (Rect) r8.get(i10);
                arrayList4.add(rect != null ? paragraphInfo.toGlobal(rect) : null);
            }
            CollectionsKt__MutableCollectionsKt.addAll(arrayList4, arrayList3);
        }
        if (arrayList3.size() < ((List) this.intrinsics.method).size()) {
            int size4 = ((List) this.intrinsics.method).size() - arrayList3.size();
            ArrayList arrayList5 = new ArrayList(size4);
            for (int i11 = i3; i11 < size4; i11++) {
                arrayList5.add(null);
            }
            arrayList3 = CollectionsKt.plus((Collection) arrayList3, (List) arrayList5);
        }
        this.placeholderRects = arrayList3;
    }

    /* JADX INFO: renamed from: paint-LG529CI$default, reason: not valid java name */
    public static void m626paintLG529CI$default(MultiParagraph multiParagraph, Canvas canvas, long j, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle) {
        canvas.save();
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(i);
            paragraphInfo.paragraph.m623paintLG529CI(canvas, j, shadow, textDecoration, drawStyle);
            canvas.translate(0.0f, paragraphInfo.paragraph.getHeight());
        }
        canvas.restore();
    }

    /* JADX INFO: renamed from: paint-hn5TExg$default, reason: not valid java name */
    public static void m627painthn5TExg$default(MultiParagraph multiParagraph, Canvas canvas, Brush brush, float f, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle) {
        canvas.save();
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        if (arrayList.size() <= 1 || (brush instanceof SolidColor)) {
            AndroidTextPaint_androidKt.m667drawParagraphs7AXcY_I(multiParagraph, canvas, brush, f, shadow, textDecoration, drawStyle);
        } else {
            if (!(brush instanceof ShaderBrush)) {
                throw new HttpException();
            }
            int size = arrayList.size();
            float fMax = 0.0f;
            float height = 0.0f;
            for (int i = 0; i < size; i++) {
                ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(i);
                height += paragraphInfo.paragraph.getHeight();
                fMax = Math.max(fMax, paragraphInfo.paragraph.getWidth());
            }
            Shader shaderMo431createShaderuvyYCjk = ((ShaderBrush) brush).mo431createShaderuvyYCjk((((long) Float.floatToRawIntBits(fMax)) << 32) | (((long) Float.floatToRawIntBits(height)) & 4294967295L));
            Matrix matrix = new Matrix();
            shaderMo431createShaderuvyYCjk.getLocalMatrix(matrix);
            int size2 = arrayList.size();
            for (int i2 = 0; i2 < size2; i2++) {
                AndroidParagraph androidParagraph = ((ParagraphInfo) arrayList.get(i2)).paragraph;
                androidParagraph.m624painthn5TExg(canvas, new BrushKt$ShaderBrush$1(shaderMo431createShaderuvyYCjk), f, shadow, textDecoration, drawStyle);
                canvas.translate(0.0f, androidParagraph.getHeight());
                matrix.setTranslate(0.0f, -androidParagraph.getHeight());
                shaderMo431createShaderuvyYCjk.setLocalMatrix(matrix);
            }
        }
        canvas.restore();
    }

    /* JADX INFO: renamed from: fillBoundingBoxes-8ffj60Q, reason: not valid java name */
    public final void m628fillBoundingBoxes8ffj60Q(long j, float[] fArr) {
        requireIndexInRange(TextRange.m644getMinimpl(j));
        requireIndexInRangeInclusiveEnd(TextRange.m643getMaximpl(j));
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = 0;
        ParagraphKt.m634findParagraphsByRangeSbBc2M(this.paragraphInfoList, j, new MultiParagraph$$ExternalSyntheticLambda0(j, fArr, ref$IntRef, new Ref$FloatRef()));
    }

    public final float getLineBottom(int i) {
        requireLineIndexInRange(i);
        ArrayList arrayList = this.paragraphInfoList;
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(ParagraphKt.findParagraphByLineIndex(i, arrayList));
        AndroidParagraph androidParagraph = paragraphInfo.paragraph;
        return androidParagraph.layout.getLineBottom(i - paragraphInfo.startLineIndex) + paragraphInfo.top;
    }

    public final int getLineEnd(int i, boolean z) {
        int lineEnd;
        requireLineIndexInRange(i);
        ArrayList arrayList = this.paragraphInfoList;
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(ParagraphKt.findParagraphByLineIndex(i, arrayList));
        AndroidParagraph androidParagraph = paragraphInfo.paragraph;
        int i2 = i - paragraphInfo.startLineIndex;
        TextLayout textLayout = androidParagraph.layout;
        if (z) {
            Layout layout = textLayout.layout;
            ThreadLocal threadLocal = TextLayout_androidKt.SharedTextAndroidCanvas;
            if (layout.getEllipsisCount(i2) <= 0 || textLayout.ellipsize != TextUtils.TruncateAt.END) {
                Request layoutHelper = textLayout.getLayoutHelper();
                Layout layout2 = (Layout) layoutHelper.url;
                lineEnd = layoutHelper.lineEndToVisibleEnd(layout2.getLineEnd(i2), layout2.getLineStart(i2));
            } else {
                lineEnd = layout.getEllipsisStart(i2) + layout.getLineStart(i2);
            }
        } else {
            lineEnd = textLayout.getLineEnd(i2);
        }
        return lineEnd + paragraphInfo.startIndex;
    }

    public final int getLineForOffset(int i) {
        int iFindParagraphByIndex;
        int length = ((AnnotatedString) this.intrinsics.url).text.length();
        ArrayList arrayList = this.paragraphInfoList;
        if (i >= length) {
            iFindParagraphByIndex = AppCompatHintHelper.getLastIndex(arrayList);
        } else {
            iFindParagraphByIndex = i < 0 ? 0 : ParagraphKt.findParagraphByIndex(i, arrayList);
        }
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(iFindParagraphByIndex);
        return paragraphInfo.paragraph.layout.layout.getLineForOffset(paragraphInfo.toLocalIndex(i)) + paragraphInfo.startLineIndex;
    }

    public final int getLineForVerticalPosition(float f) {
        ArrayList arrayList = this.paragraphInfoList;
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(ParagraphKt.findParagraphByY(arrayList, f));
        int i = paragraphInfo.endIndex - paragraphInfo.startIndex;
        int i2 = paragraphInfo.startLineIndex;
        if (i == 0) {
            return i2;
        }
        AndroidParagraph androidParagraph = paragraphInfo.paragraph;
        float f2 = f - paragraphInfo.top;
        TextLayout textLayout = androidParagraph.layout;
        return textLayout.layout.getLineForVertical(((int) f2) - textLayout.topPadding) + i2;
    }

    public final float getLineTop(int i) {
        requireLineIndexInRange(i);
        ArrayList arrayList = this.paragraphInfoList;
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(ParagraphKt.findParagraphByLineIndex(i, arrayList));
        AndroidParagraph androidParagraph = paragraphInfo.paragraph;
        return androidParagraph.layout.getLineTop(i - paragraphInfo.startLineIndex) + paragraphInfo.top;
    }

    /* JADX INFO: renamed from: getOffsetForPosition-k-4lQ0M, reason: not valid java name */
    public final int m629getOffsetForPositionk4lQ0M(long j) {
        int i = (int) (j & 4294967295L);
        float fIntBitsToFloat = Float.intBitsToFloat(i);
        ArrayList arrayList = this.paragraphInfoList;
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(ParagraphKt.findParagraphByY(arrayList, fIntBitsToFloat));
        int i2 = paragraphInfo.endIndex;
        int i3 = paragraphInfo.startIndex;
        if (i2 - i3 == 0) {
            return i3;
        }
        AndroidParagraph androidParagraph = paragraphInfo.paragraph;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j >> 32));
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(Float.intBitsToFloat(i) - paragraphInfo.top)) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat2) << 32);
        TextLayout textLayout = androidParagraph.layout;
        int lineForVertical = textLayout.layout.getLineForVertical(((int) Float.intBitsToFloat((int) (4294967295L & jFloatToRawIntBits))) - textLayout.topPadding);
        return textLayout.layout.getOffsetForHorizontal(lineForVertical, (textLayout.getHorizontalPadding(lineForVertical) * (-1)) + Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32))) + i3;
    }

    /* JADX INFO: renamed from: getRangeForRect-8-6BmAI, reason: not valid java name */
    public final long m630getRangeForRect86BmAI(Rect rect, int i, ZslControlImpl$$ExternalSyntheticLambda0 zslControlImpl$$ExternalSyntheticLambda0) {
        long jM631toGlobalxdX6G0;
        long j;
        float f = rect.top;
        ArrayList arrayList = this.paragraphInfoList;
        int iFindParagraphByY = ParagraphKt.findParagraphByY(arrayList, f);
        float f2 = ((ParagraphInfo) arrayList.get(iFindParagraphByY)).bottom;
        float f3 = rect.bottom;
        if (f2 >= f3 || iFindParagraphByY == AppCompatHintHelper.getLastIndex(arrayList)) {
            ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(iFindParagraphByY);
            return paragraphInfo.m631toGlobalxdX6G0(paragraphInfo.paragraph.m622getRangeForRect86BmAI(paragraphInfo.toLocal(rect), i, zslControlImpl$$ExternalSyntheticLambda0), true);
        }
        int iFindParagraphByY2 = ParagraphKt.findParagraphByY(arrayList, f3);
        long jM631toGlobalxdX6G1 = TextRange.Zero;
        while (true) {
            jM631toGlobalxdX6G0 = TextRange.Zero;
            if (!TextRange.m640equalsimpl0(jM631toGlobalxdX6G1, jM631toGlobalxdX6G0) || iFindParagraphByY > iFindParagraphByY2) {
                break;
            }
            ParagraphInfo paragraphInfo2 = (ParagraphInfo) arrayList.get(iFindParagraphByY);
            jM631toGlobalxdX6G1 = paragraphInfo2.m631toGlobalxdX6G0(paragraphInfo2.paragraph.m622getRangeForRect86BmAI(paragraphInfo2.toLocal(rect), i, zslControlImpl$$ExternalSyntheticLambda0), true);
            iFindParagraphByY++;
        }
        if (TextRange.m640equalsimpl0(jM631toGlobalxdX6G1, jM631toGlobalxdX6G0)) {
            return jM631toGlobalxdX6G0;
        }
        while (true) {
            j = TextRange.Zero;
            if (!TextRange.m640equalsimpl0(jM631toGlobalxdX6G0, j) || iFindParagraphByY > iFindParagraphByY2) {
                break;
            }
            ParagraphInfo paragraphInfo3 = (ParagraphInfo) arrayList.get(iFindParagraphByY2);
            jM631toGlobalxdX6G0 = paragraphInfo3.m631toGlobalxdX6G0(paragraphInfo3.paragraph.m622getRangeForRect86BmAI(paragraphInfo3.toLocal(rect), i, zslControlImpl$$ExternalSyntheticLambda0), true);
            iFindParagraphByY2--;
        }
        return TextRange.m640equalsimpl0(jM631toGlobalxdX6G0, j) ? jM631toGlobalxdX6G1 : ParagraphKt.TextRange((int) (jM631toGlobalxdX6G1 >> 32), (int) (4294967295L & jM631toGlobalxdX6G0));
    }

    public final void requireIndexInRange(int i) {
        boolean z = false;
        Request request = this.intrinsics;
        if (i >= 0 && i < ((AnnotatedString) request.url).text.length()) {
            z = true;
        }
        if (z) {
            return;
        }
        StringBuilder sbM = ImageAnalysis$$ExternalSyntheticLambda1.m(i, "offset(", ") is out of bounds [0, ");
        sbM.append(((AnnotatedString) request.url).text.length());
        sbM.append(')');
        InlineClassHelperKt.throwIllegalArgumentException(sbM.toString());
    }

    public final void requireIndexInRangeInclusiveEnd(int i) {
        boolean z = false;
        Request request = this.intrinsics;
        if (i >= 0 && i <= ((AnnotatedString) request.url).text.length()) {
            z = true;
        }
        if (z) {
            return;
        }
        StringBuilder sbM = ImageAnalysis$$ExternalSyntheticLambda1.m(i, "offset(", ") is out of bounds [0, ");
        sbM.append(((AnnotatedString) request.url).text.length());
        sbM.append(']');
        InlineClassHelperKt.throwIllegalArgumentException(sbM.toString());
    }

    public final void requireLineIndexInRange(int i) {
        boolean z = false;
        int i2 = this.lineCount;
        if (i >= 0 && i < i2) {
            z = true;
        }
        if (z) {
            return;
        }
        InlineClassHelperKt.throwIllegalArgumentException("lineIndex(" + i + ") is out of bounds [0, " + i2 + ')');
    }
}
