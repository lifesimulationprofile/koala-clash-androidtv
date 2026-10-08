package androidx.compose.ui.text;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.text.Layout;
import androidx.collection.MutableScatterSet;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidImageBitmap;
import androidx.compose.ui.graphics.AndroidPaint;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.scrollcapture.RelativeScroller;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import coil.disk.DiskLruCache$$ExternalSyntheticLambda0;
import coil.request.Parameters;
import dev.chrisbanes.haze.HazeEffectNode;
import dev.chrisbanes.haze.HazeEffectNodeKt;
import dev.chrisbanes.haze.HazeKt;
import dev.chrisbanes.haze.HazeTint;
import dev.chrisbanes.haze.PaintKt;
import dev.chrisbanes.haze.RenderEffect_androidKt;
import dev.chrisbanes.haze.RenderScriptBlurEffect;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.RangesKt;
import okhttp3.ConnectionPool;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MultiParagraph$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId = 2;
    public final /* synthetic */ long f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;

    public /* synthetic */ MultiParagraph$$ExternalSyntheticLambda0(long j, Ref$FloatRef ref$FloatRef, RenderScriptBlurEffect renderScriptBlurEffect, Context context) {
        this.f$0 = j;
        this.f$3 = ref$FloatRef;
        this.f$1 = renderScriptBlurEffect;
        this.f$2 = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17, types: [androidx.compose.ui.graphics.drawscope.DrawScope] */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v7 */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) throws Throwable {
        int i;
        boolean z;
        TextLayout textLayout;
        float f;
        float f2;
        HazeEffectNode hazeEffectNode;
        long j;
        DrawScope drawScope;
        DrawScope drawScope2;
        Object objFirst;
        Object obj2;
        int i2 = this.$r8$classId;
        Object obj3 = this.f$2;
        Object obj4 = this.f$1;
        Object obj5 = this.f$3;
        switch (i2) {
            case 0:
                float[] fArr = (float[]) obj4;
                Ref$IntRef ref$IntRef = (Ref$IntRef) obj3;
                Ref$FloatRef ref$FloatRef = (Ref$FloatRef) obj5;
                ParagraphInfo paragraphInfo = (ParagraphInfo) obj;
                int i3 = paragraphInfo.startIndex;
                AndroidParagraph androidParagraph = paragraphInfo.paragraph;
                int iM643getMaximpl = paragraphInfo.endIndex;
                long j2 = this.f$0;
                int iM644getMinimpl = i3 > TextRange.m644getMinimpl(j2) ? paragraphInfo.startIndex : TextRange.m644getMinimpl(j2);
                if (iM643getMaximpl >= TextRange.m643getMaximpl(j2)) {
                    iM643getMaximpl = TextRange.m643getMaximpl(j2);
                }
                long jTextRange = ParagraphKt.TextRange(paragraphInfo.toLocalIndex(iM644getMinimpl), paragraphInfo.toLocalIndex(iM643getMaximpl));
                int i4 = ref$IntRef.element;
                TextLayout textLayout2 = androidParagraph.layout;
                int iM644getMinimpl2 = TextRange.m644getMinimpl(jTextRange);
                int iM643getMaximpl2 = TextRange.m643getMaximpl(jTextRange);
                Layout layout = textLayout2.layout;
                int length = layout.getText().length();
                if (iM644getMinimpl2 < 0) {
                    InlineClassHelperKt.throwIllegalArgumentException("startOffset must be > 0");
                }
                if (iM644getMinimpl2 >= length) {
                    InlineClassHelperKt.throwIllegalArgumentException("startOffset must be less than text length");
                }
                if (iM643getMaximpl2 <= iM644getMinimpl2) {
                    InlineClassHelperKt.throwIllegalArgumentException("endOffset must be greater than startOffset");
                }
                if (iM643getMaximpl2 > length) {
                    InlineClassHelperKt.throwIllegalArgumentException("endOffset must be smaller or equal to text length");
                }
                if (fArr.length - i4 < (iM643getMaximpl2 - iM644getMinimpl2) * 4) {
                    InlineClassHelperKt.throwIllegalArgumentException("array.size - arrayStart must be greater or equal than (endOffset - startOffset) * 4");
                }
                int lineForOffset = layout.getLineForOffset(iM644getMinimpl2);
                int lineForOffset2 = layout.getLineForOffset(iM643getMaximpl2 - 1);
                RelativeScroller relativeScroller = new RelativeScroller(textLayout2);
                if (lineForOffset <= lineForOffset2) {
                    while (true) {
                        int lineStart = layout.getLineStart(lineForOffset);
                        int i5 = i4;
                        int lineEnd = textLayout2.getLineEnd(lineForOffset);
                        int iMax = Math.max(iM644getMinimpl2, lineStart);
                        int iMin = Math.min(iM643getMaximpl2, lineEnd);
                        float lineTop = textLayout2.getLineTop(lineForOffset);
                        float lineBottom = textLayout2.getLineBottom(lineForOffset);
                        boolean z2 = layout.getParagraphDirection(lineForOffset) == 1;
                        int i6 = iMax;
                        int i7 = i5;
                        while (i6 < iMin) {
                            boolean zIsRtlCharAt = layout.isRtlCharAt(i6);
                            if (!z2 || zIsRtlCharAt) {
                                i = iMin;
                                z = z2;
                                if (z && zIsRtlCharAt) {
                                    float f3 = relativeScroller.get(i6, false, false, false);
                                    textLayout = textLayout2;
                                    f = relativeScroller.get(i6 + 1, true, true, false);
                                    f2 = f3;
                                } else {
                                    textLayout = textLayout2;
                                    if (z || !zIsRtlCharAt) {
                                        f = relativeScroller.get(i6, false, false, false);
                                        f2 = relativeScroller.get(i6 + 1, true, true, false);
                                    } else {
                                        f2 = relativeScroller.get(i6, false, false, true);
                                        f = relativeScroller.get(i6 + 1, true, true, true);
                                    }
                                }
                                fArr[i7] = f;
                                fArr[i7 + 1] = lineTop;
                                fArr[i7 + 2] = f2;
                                fArr[i7 + 3] = lineBottom;
                                i7 += 4;
                                i6++;
                                iMin = i;
                                z2 = z;
                                textLayout2 = textLayout;
                            } else {
                                i = iMin;
                                z = z2;
                                f = relativeScroller.get(i6, false, false, true);
                                textLayout = textLayout2;
                                f2 = relativeScroller.get(i6 + 1, true, true, true);
                            }
                            fArr[i7] = f;
                            fArr[i7 + 1] = lineTop;
                            fArr[i7 + 2] = f2;
                            fArr[i7 + 3] = lineBottom;
                            i7 += 4;
                            i6++;
                            iMin = i;
                            z2 = z;
                            textLayout2 = textLayout;
                        }
                        TextLayout textLayout3 = textLayout2;
                        if (lineForOffset != lineForOffset2) {
                            lineForOffset++;
                            i4 = i7;
                            textLayout2 = textLayout3;
                        }
                    }
                }
                int iM642getLengthimpl = (TextRange.m642getLengthimpl(jTextRange) * 4) + ref$IntRef.element;
                for (int i8 = ref$IntRef.element; i8 < iM642getLengthimpl; i8 += 4) {
                    int i9 = i8 + 1;
                    float f4 = fArr[i9];
                    float f5 = ref$FloatRef.element;
                    fArr[i9] = f4 + f5;
                    int i10 = i8 + 3;
                    fArr[i10] = fArr[i10] + f5;
                }
                ref$IntRef.element = iM642getLengthimpl;
                ref$FloatRef.element = androidParagraph.getHeight() + ref$FloatRef.element;
                return Unit.INSTANCE;
            case 1:
                Rect rect = (Rect) obj4;
                Ref$ObjectRef ref$ObjectRef = (Ref$ObjectRef) obj3;
                long j3 = this.f$0;
                BlendModeColorFilter blendModeColorFilter = (BlendModeColorFilter) obj5;
                LayoutNodeDrawScope layoutNodeDrawScope = (LayoutNodeDrawScope) obj;
                layoutNodeDrawScope.drawContent();
                float f6 = rect.left;
                float f7 = rect.top;
                CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
                ((Parameters.Builder) canvasDrawScope.drawContext.mOnInvalidateMenuCallback).translate(f6, f7);
                try {
                    layoutNodeDrawScope.mo464drawImageAZ2fEMs((AndroidImageBitmap) ref$ObjectRef.element, 0L, j3, (328 & 16) != 0 ? j3 : 0L, (328 & 32) != 0 ? 1.0f : 0.0f, blendModeColorFilter, (328 & 512) != 0 ? 1 : 0);
                    return Unit.INSTANCE;
                } finally {
                    ((Parameters.Builder) canvasDrawScope.drawContext.mOnInvalidateMenuCallback).translate(-f6, -f7);
                }
            default:
                Ref$FloatRef ref$FloatRef2 = (Ref$FloatRef) obj5;
                RenderScriptBlurEffect renderScriptBlurEffect = (RenderScriptBlurEffect) obj4;
                Context context = (Context) obj3;
                DrawScope drawScope3 = (DrawScope) obj;
                long j4 = this.f$0;
                long j5 = j4 ^ (-9223372034707292160L);
                long jM389times7Ah8Wj8 = Size.m389times7Ah8Wj8(ref$FloatRef2.element, drawScope3.mo474getSizeNHjbRc());
                HazeEffectNode hazeEffectNode2 = renderScriptBlurEffect.node;
                Object obj6 = HazeEffectNodeKt.renderEffectCache$delegate;
                HazeKt.m826drawScaledContentLF441nw(drawScope3, j5, jM389times7Ah8Wj8, hazeEffectNode2.blurredEdgeTreatment != null, new DiskLruCache$$ExternalSyntheticLambda0(14, renderScriptBlurEffect));
                long jMo474getSizeNHjbRc = drawScope3.mo474getSizeNHjbRc();
                float f8 = 2;
                float fMax = Math.max(Float.intBitsToFloat((int) (j4 >> 32)), 0.0f) * f8;
                long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (jMo474getSizeNHjbRc & 4294967295L)) + (Math.max(Float.intBitsToFloat((int) (j4 & 4294967295L)), 0.0f) * f8))) & 4294967295L) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (jMo474getSizeNHjbRc >> 32)) + fMax)) << 32);
                float fResolveNoiseFactor = HazeEffectNodeKt.resolveNoiseFactor(hazeEffectNode2);
                ?? r10 = 4294967297;
                if (fResolveNoiseFactor > 0.0f) {
                    j = 4294967297L;
                    if (((((j5 & 9187343241974906880L) ^ 9187343241974906880L) - 4294967297L) & (-9223372034707292160L)) == 0 && !Offset.m369equalsimpl0(j5, 0L)) {
                        float fIntBitsToFloat = Float.intBitsToFloat((int) (j5 >> 32));
                        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j5 & 4294967295L));
                        ((Parameters.Builder) drawScope3.getDrawContext().mOnInvalidateMenuCallback).translate(fIntBitsToFloat, fIntBitsToFloat2);
                        try {
                            ConnectionPool connectionPool = PaintKt.PaintPool;
                            MutableScatterSet mutableScatterSet = (MutableScatterSet) connectionPool.delegate;
                            if (mutableScatterSet.isNotEmpty()) {
                                Object objFirst2 = mutableScatterSet.first();
                                mutableScatterSet.remove(objFirst2);
                                obj2 = objFirst2;
                                r10 = objFirst2;
                            } else {
                                obj2 = null;
                            }
                            AndroidPaint androidPaintPaint = (AndroidPaint) obj2;
                            if (androidPaintPaint == null) {
                                androidPaintPaint = BrushKt.Paint();
                            }
                            try {
                                try {
                                    hazeEffectNode = hazeEffectNode2;
                                    androidPaintPaint.internalPaint.setAntiAlias(true);
                                    androidPaintPaint.setAlpha(RangesKt.coerceIn(fResolveNoiseFactor, 0.0f, 1.0f));
                                    Bitmap noiseTexture = RenderEffect_androidKt.getNoiseTexture(context);
                                    Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                                    BitmapShader bitmapShader = new BitmapShader(noiseTexture, tileMode, tileMode);
                                    float f9 = ref$FloatRef2.element;
                                    float f10 = f9 > 0.0f ? f9 : 1.0f;
                                    if (Math.abs(f10 - 1.0f) >= 0.001f) {
                                        Matrix matrix = new Matrix();
                                        float f11 = 1.0f / f10;
                                        matrix.setScale(f11, f11);
                                        bitmapShader.setLocalMatrix(matrix);
                                    }
                                    androidPaintPaint.setShader(bitmapShader);
                                    androidPaintPaint.m403setBlendModes9anfk8(9);
                                    drawScope = drawScope3;
                                    try {
                                        drawScope3.getDrawContext().getCanvas().drawRect(RectKt.m382Recttz77jQw(0L, jFloatToRawIntBits), androidPaintPaint);
                                        Unit unit = Unit.INSTANCE;
                                        androidPaintPaint.internalPaint.reset();
                                        MutableScatterSet mutableScatterSet2 = (MutableScatterSet) connectionPool.delegate;
                                        if (mutableScatterSet2._size < 3) {
                                            mutableScatterSet2.plusAssign(androidPaintPaint);
                                        }
                                        ((Parameters.Builder) drawScope.getDrawContext().mOnInvalidateMenuCallback).translate(-fIntBitsToFloat, -fIntBitsToFloat2);
                                    } catch (Throwable th) {
                                        th = th;
                                        androidPaintPaint.internalPaint.reset();
                                        MutableScatterSet mutableScatterSet3 = (MutableScatterSet) connectionPool.delegate;
                                        if (mutableScatterSet3._size < 3) {
                                            mutableScatterSet3.plusAssign(androidPaintPaint);
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                ((Parameters.Builder) r10.getDrawContext().mOnInvalidateMenuCallback).translate(-fIntBitsToFloat, -fIntBitsToFloat2);
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            r10 = drawScope3;
                        }
                        break;
                    } else {
                        hazeEffectNode = hazeEffectNode2;
                        drawScope = drawScope3;
                        ConnectionPool connectionPool2 = PaintKt.PaintPool;
                        MutableScatterSet mutableScatterSet4 = (MutableScatterSet) connectionPool2.delegate;
                        MutableScatterSet mutableScatterSet5 = (MutableScatterSet) connectionPool2.delegate;
                        if (mutableScatterSet4.isNotEmpty()) {
                            objFirst = mutableScatterSet4.first();
                            mutableScatterSet4.remove(objFirst);
                        } else {
                            objFirst = null;
                        }
                        AndroidPaint androidPaintPaint2 = (AndroidPaint) objFirst;
                        if (androidPaintPaint2 == null) {
                            androidPaintPaint2 = BrushKt.Paint();
                        }
                        try {
                            androidPaintPaint2.internalPaint.setAntiAlias(true);
                            androidPaintPaint2.setAlpha(RangesKt.coerceIn(fResolveNoiseFactor, 0.0f, 1.0f));
                            Bitmap noiseTexture2 = RenderEffect_androidKt.getNoiseTexture(context);
                            Shader.TileMode tileMode2 = Shader.TileMode.REPEAT;
                            BitmapShader bitmapShader2 = new BitmapShader(noiseTexture2, tileMode2, tileMode2);
                            float f12 = ref$FloatRef2.element;
                            float f13 = f12 > 0.0f ? f12 : 1.0f;
                            if (Math.abs(f13 - 1.0f) >= 0.001f) {
                                Matrix matrix2 = new Matrix();
                                float f14 = 1.0f / f13;
                                matrix2.setScale(f14, f14);
                                bitmapShader2.setLocalMatrix(matrix2);
                            }
                            androidPaintPaint2.setShader(bitmapShader2);
                            androidPaintPaint2.m403setBlendModes9anfk8(9);
                            drawScope.getDrawContext().getCanvas().drawRect(RectKt.m382Recttz77jQw(0L, jFloatToRawIntBits), androidPaintPaint2);
                            Unit unit2 = Unit.INSTANCE;
                            androidPaintPaint2.internalPaint.reset();
                            if (mutableScatterSet5._size < 3) {
                                mutableScatterSet5.plusAssign(androidPaintPaint2);
                            }
                        } catch (Throwable th5) {
                            androidPaintPaint2.internalPaint.reset();
                            if (mutableScatterSet5._size < 3) {
                                mutableScatterSet5.plusAssign(androidPaintPaint2);
                            }
                            throw th5;
                        }
                    }
                } else {
                    hazeEffectNode = hazeEffectNode2;
                    j = 4294967297L;
                    drawScope = drawScope3;
                }
                if (((((j5 & 9187343241974906880L) ^ 9187343241974906880L) - j) & (-9223372034707292160L)) != 0 || Offset.m369equalsimpl0(j5, 0L)) {
                    DrawScope drawScope4 = drawScope;
                    HazeEffectNode hazeEffectNode3 = hazeEffectNode;
                    Iterator it = HazeEffectNodeKt.resolveTints(hazeEffectNode3).iterator();
                    while (it.hasNext()) {
                        HazeKt.m827drawScrimDBWKusU(drawScope4, (HazeTint) it.next(), hazeEffectNode3, j4, jFloatToRawIntBits);
                    }
                } else {
                    float fIntBitsToFloat3 = Float.intBitsToFloat((int) (j5 >> 32));
                    float fIntBitsToFloat4 = Float.intBitsToFloat((int) (j5 & 4294967295L));
                    ((Parameters.Builder) drawScope.getDrawContext().mOnInvalidateMenuCallback).translate(fIntBitsToFloat3, fIntBitsToFloat4);
                    try {
                        Iterator it2 = HazeEffectNodeKt.resolveTints(hazeEffectNode).iterator();
                        while (it2.hasNext()) {
                            drawScope2 = drawScope;
                            long j6 = j4;
                            HazeEffectNode hazeEffectNode4 = hazeEffectNode;
                            try {
                                HazeKt.m827drawScrimDBWKusU(drawScope2, (HazeTint) it2.next(), hazeEffectNode4, j6, jFloatToRawIntBits);
                                hazeEffectNode = hazeEffectNode4;
                                j4 = j6;
                                drawScope = drawScope2;
                            } catch (Throwable th6) {
                                th = th6;
                                ((Parameters.Builder) drawScope2.getDrawContext().mOnInvalidateMenuCallback).translate(-fIntBitsToFloat3, -fIntBitsToFloat4);
                                throw th;
                            }
                        }
                        ((Parameters.Builder) drawScope.getDrawContext().mOnInvalidateMenuCallback).translate(-fIntBitsToFloat3, -fIntBitsToFloat4);
                    } catch (Throwable th7) {
                        th = th7;
                        drawScope2 = drawScope;
                    }
                }
                return Unit.INSTANCE;
        }
    }

    public /* synthetic */ MultiParagraph$$ExternalSyntheticLambda0(long j, float[] fArr, Ref$IntRef ref$IntRef, Ref$FloatRef ref$FloatRef) {
        this.f$0 = j;
        this.f$1 = fArr;
        this.f$2 = ref$IntRef;
        this.f$3 = ref$FloatRef;
    }

    public /* synthetic */ MultiParagraph$$ExternalSyntheticLambda0(Rect rect, Ref$ObjectRef ref$ObjectRef, long j, BlendModeColorFilter blendModeColorFilter) {
        this.f$1 = rect;
        this.f$2 = ref$ObjectRef;
        this.f$0 = j;
        this.f$3 = blendModeColorFilter;
    }
}
