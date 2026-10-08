package androidx.compose.ui.graphics.vector;

import android.graphics.Bitmap;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidImageBitmap;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.MenuHostHelper;
import coil.request.Parameters;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class VectorComponent extends VNode {
    public final DrawCache cacheDrawScope;
    public final AnonymousClass1 drawVectorBlock;
    public final ParcelableSnapshotMutableState intrinsicColorFilter$delegate;
    public Lambda invalidateCallback;
    public boolean isDirty;
    public String name;
    public long previousDrawSize;
    public final GroupComponent root;
    public float rootScaleX;
    public float rootScaleY;
    public BlendModeColorFilter tintFilter;
    public final ParcelableSnapshotMutableState viewportSize$delegate;

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.vector.VectorComponent$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends Lambda implements Function1 {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ VectorComponent this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(VectorComponent vectorComponent, int i) {
            super(1);
            this.$r8$classId = i;
            this.this$0 = vectorComponent;
        }

        /* JADX WARN: Type inference failed for: r10v3, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    VectorComponent vectorComponent = this.this$0;
                    vectorComponent.isDirty = true;
                    vectorComponent.invalidateCallback.invoke();
                    return Unit.INSTANCE;
                default:
                    DrawScope drawScope = (DrawScope) obj;
                    VectorComponent vectorComponent2 = this.this$0;
                    GroupComponent groupComponent = vectorComponent2.root;
                    float f = vectorComponent2.rootScaleX;
                    float f2 = vectorComponent2.rootScaleY;
                    MenuHostHelper drawContext = drawScope.getDrawContext();
                    long jM756getSizeNHjbRc = drawContext.m756getSizeNHjbRc();
                    drawContext.getCanvas().save();
                    try {
                        ((Parameters.Builder) drawContext.mOnInvalidateMenuCallback).m792scale0AR0LA0(f, f2, 0L);
                        groupComponent.draw(drawScope);
                        return Unit.INSTANCE;
                    } finally {
                        ImageAnalysis$$ExternalSyntheticLambda1.m(drawContext, jM756getSizeNHjbRc);
                    }
            }
        }
    }

    public VectorComponent(GroupComponent groupComponent) {
        this.root = groupComponent;
        groupComponent.invalidateListener = new AnonymousClass1(this, 0);
        this.name = "";
        this.isDirty = true;
        this.cacheDrawScope = new DrawCache();
        this.invalidateCallback = PathComponent$pathMeasure$2.INSTANCE$1;
        this.intrinsicColorFilter$delegate = Stack.mutableStateOf$default(null);
        this.viewportSize$delegate = Stack.mutableStateOf$default(new Size(0L));
        this.previousDrawSize = 9205357640488583168L;
        this.rootScaleX = 1.0f;
        this.rootScaleY = 1.0f;
        this.drawVectorBlock = new AnonymousClass1(this, 1);
    }

    @Override // androidx.compose.ui.graphics.vector.VNode
    public final void draw(DrawScope drawScope) {
        draw(drawScope, 1.0f, null);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Params: \tname: ");
        sb.append(this.name);
        sb.append("\n\tviewportWidth: ");
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = this.viewportSize$delegate;
        sb.append(Float.intBitsToFloat((int) (((Size) parcelableSnapshotMutableState.getValue()).packedValue >> 32)));
        sb.append("\n\tviewportHeight: ");
        sb.append(Float.intBitsToFloat((int) (((Size) parcelableSnapshotMutableState.getValue()).packedValue & 4294967295L)));
        sb.append("\n");
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:23:0x003d  */
    /* JADX WARN: Code duplicated, block: B:34:0x005e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x0060  */
    /* JADX WARN: Code duplicated, block: B:38:0x006f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0079  */
    /* JADX WARN: Code duplicated, block: B:51:0x010b  */
    public final void draw(DrawScope drawScope, float f, BlendModeColorFilter blendModeColorFilter) {
        int i;
        BlendModeColorFilter blendModeColorFilter2;
        AndroidImageBitmap androidImageBitmapM412ImageBitmapx__hDU$default;
        char c;
        long j;
        long jColor;
        int i2;
        int i3;
        BlendModeColorFilter blendModeColorFilter3 = blendModeColorFilter;
        GroupComponent groupComponent = this.root;
        boolean z = groupComponent.isTintable;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = this.intrinsicColorFilter$delegate;
        if (!z || groupComponent.tintColor == 16) {
            i = 0;
        } else {
            BlendModeColorFilter blendModeColorFilter4 = (BlendModeColorFilter) parcelableSnapshotMutableState.getValue();
            int i4 = VectorKt.$r8$clinit;
            if (!(blendModeColorFilter4 instanceof BlendModeColorFilter) ? blendModeColorFilter4 == null : (i3 = blendModeColorFilter4.blendMode) == 5 || i3 == 3) {
                i = 0;
            } else if (!(blendModeColorFilter3 instanceof BlendModeColorFilter) ? blendModeColorFilter3 == null : (i2 = blendModeColorFilter3.blendMode) == 5 || i2 == 3) {
                i = 0;
            } else {
                i = 1;
            }
        }
        boolean z2 = this.isDirty;
        DrawCache drawCache = this.cacheDrawScope;
        if (z2 || !Size.m384equalsimpl0(this.previousDrawSize, drawScope.mo474getSizeNHjbRc())) {
            if (i == 1) {
                jColor = groupComponent.tintColor;
                int i5 = VectorKt.$r8$clinit;
                if (Color.m436getAlphaimpl(jColor) != 1.0f) {
                    jColor = BrushKt.Color(Color.m440getRedimpl(jColor), Color.m439getGreenimpl(jColor), Color.m437getBlueimpl(jColor), 1.0f, Color.m438getColorSpaceimpl(jColor));
                }
                blendModeColorFilter2 = new BlendModeColorFilter(5, jColor);
            } else {
                blendModeColorFilter2 = null;
            }
            this.tintFilter = blendModeColorFilter2;
            float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo474getSizeNHjbRc() >> 32));
            ParcelableSnapshotMutableState parcelableSnapshotMutableState2 = this.viewportSize$delegate;
            this.rootScaleX = fIntBitsToFloat / Float.intBitsToFloat((int) (((Size) parcelableSnapshotMutableState2.getValue()).packedValue >> 32));
            this.rootScaleY = Float.intBitsToFloat((int) (drawScope.mo474getSizeNHjbRc() & 4294967295L)) / Float.intBitsToFloat((int) (((Size) parcelableSnapshotMutableState2.getValue()).packedValue & 4294967295L));
            long jCeil = (((long) ((int) Math.ceil(Float.intBitsToFloat((int) (drawScope.mo474getSizeNHjbRc() >> 32))))) << 32) | (((long) ((int) Math.ceil(Float.intBitsToFloat((int) (drawScope.mo474getSizeNHjbRc() & 4294967295L))))) & 4294967295L);
            LayoutDirection layoutDirection = drawScope.getLayoutDirection();
            androidImageBitmapM412ImageBitmapx__hDU$default = drawCache.mCachedImage;
            AndroidCanvas androidCanvasCanvas = drawCache.cachedCanvas;
            if (androidImageBitmapM412ImageBitmapx__hDU$default != null || androidCanvasCanvas == null) {
                c = ' ';
                j = 4294967295L;
            } else {
                int i6 = (int) (jCeil >> 32);
                Bitmap bitmap = androidImageBitmapM412ImageBitmapx__hDU$default.bitmap;
                c = ' ';
                j = 4294967295L;
                if (i6 > bitmap.getWidth() || ((int) (jCeil & 4294967295L)) > bitmap.getHeight() || drawCache.config != i) {
                }
                drawCache.size = jCeil;
                CanvasDrawScope canvasDrawScope = drawCache.cacheScope;
                long jM724toSizeozmzZPI = IntSizeKt.m724toSizeozmzZPI(jCeil);
                CanvasDrawScope.DrawParams drawParams = canvasDrawScope.drawParams;
                Density density = drawParams.density;
                LayoutDirection layoutDirection2 = drawParams.layoutDirection;
                Canvas canvas = drawParams.canvas;
                AndroidCanvas androidCanvas = androidCanvasCanvas;
                long j2 = drawParams.size;
                drawParams.density = drawScope;
                drawParams.layoutDirection = layoutDirection;
                drawParams.canvas = androidCanvas;
                drawParams.size = jM724toSizeozmzZPI;
                androidCanvas.save();
                Modifier.CC.m315drawRectnJ9OG0$default(canvasDrawScope, Color.Black, 0L, 0.0f, 0, 62);
                this.drawVectorBlock.invoke(canvasDrawScope);
                androidCanvas.restore();
                CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope.drawParams;
                drawParams2.density = density;
                drawParams2.layoutDirection = layoutDirection2;
                drawParams2.canvas = canvas;
                drawParams2.size = j2;
                androidImageBitmapM412ImageBitmapx__hDU$default.bitmap.prepareToDraw();
                this.isDirty = false;
                this.previousDrawSize = drawScope.mo474getSizeNHjbRc();
            }
            androidImageBitmapM412ImageBitmapx__hDU$default = BrushKt.m412ImageBitmapx__hDU$default((int) (jCeil >> c), (int) (jCeil & j), i);
            androidCanvasCanvas = BrushKt.Canvas(androidImageBitmapM412ImageBitmapx__hDU$default);
            drawCache.mCachedImage = androidImageBitmapM412ImageBitmapx__hDU$default;
            drawCache.cachedCanvas = androidCanvasCanvas;
            drawCache.config = i;
            drawCache.size = jCeil;
            CanvasDrawScope canvasDrawScope2 = drawCache.cacheScope;
            long jM724toSizeozmzZPI2 = IntSizeKt.m724toSizeozmzZPI(jCeil);
            CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope2.drawParams;
            Density density2 = drawParams3.density;
            LayoutDirection layoutDirection3 = drawParams3.layoutDirection;
            Canvas canvas2 = drawParams3.canvas;
            AndroidCanvas androidCanvas2 = androidCanvasCanvas;
            long j3 = drawParams3.size;
            drawParams3.density = drawScope;
            drawParams3.layoutDirection = layoutDirection;
            drawParams3.canvas = androidCanvas2;
            drawParams3.size = jM724toSizeozmzZPI2;
            androidCanvas2.save();
            Modifier.CC.m315drawRectnJ9OG0$default(canvasDrawScope2, Color.Black, 0L, 0.0f, 0, 62);
            this.drawVectorBlock.invoke(canvasDrawScope2);
            androidCanvas2.restore();
            CanvasDrawScope.DrawParams drawParams4 = canvasDrawScope2.drawParams;
            drawParams4.density = density2;
            drawParams4.layoutDirection = layoutDirection3;
            drawParams4.canvas = canvas2;
            drawParams4.size = j3;
            androidImageBitmapM412ImageBitmapx__hDU$default.bitmap.prepareToDraw();
            this.isDirty = false;
            this.previousDrawSize = drawScope.mo474getSizeNHjbRc();
        } else {
            AndroidImageBitmap androidImageBitmap = drawCache.mCachedImage;
            if (i != (androidImageBitmap != null ? androidImageBitmap.m400getConfig_sVssgQ() : 0)) {
                if (i == 1) {
                    jColor = groupComponent.tintColor;
                    int i7 = VectorKt.$r8$clinit;
                    if (Color.m436getAlphaimpl(jColor) != 1.0f) {
                        jColor = BrushKt.Color(Color.m440getRedimpl(jColor), Color.m439getGreenimpl(jColor), Color.m437getBlueimpl(jColor), 1.0f, Color.m438getColorSpaceimpl(jColor));
                    }
                    blendModeColorFilter2 = new BlendModeColorFilter(5, jColor);
                } else {
                    blendModeColorFilter2 = null;
                }
                this.tintFilter = blendModeColorFilter2;
                float fIntBitsToFloat2 = Float.intBitsToFloat((int) (drawScope.mo474getSizeNHjbRc() >> 32));
                ParcelableSnapshotMutableState parcelableSnapshotMutableState3 = this.viewportSize$delegate;
                this.rootScaleX = fIntBitsToFloat2 / Float.intBitsToFloat((int) (((Size) parcelableSnapshotMutableState3.getValue()).packedValue >> 32));
                this.rootScaleY = Float.intBitsToFloat((int) (drawScope.mo474getSizeNHjbRc() & 4294967295L)) / Float.intBitsToFloat((int) (((Size) parcelableSnapshotMutableState3.getValue()).packedValue & 4294967295L));
                long jCeil2 = (((long) ((int) Math.ceil(Float.intBitsToFloat((int) (drawScope.mo474getSizeNHjbRc() >> 32))))) << 32) | (((long) ((int) Math.ceil(Float.intBitsToFloat((int) (drawScope.mo474getSizeNHjbRc() & 4294967295L))))) & 4294967295L);
                LayoutDirection layoutDirection4 = drawScope.getLayoutDirection();
                androidImageBitmapM412ImageBitmapx__hDU$default = drawCache.mCachedImage;
                AndroidCanvas androidCanvasCanvas2 = drawCache.cachedCanvas;
                if (androidImageBitmapM412ImageBitmapx__hDU$default != null) {
                    c = ' ';
                    j = 4294967295L;
                    androidImageBitmapM412ImageBitmapx__hDU$default = BrushKt.m412ImageBitmapx__hDU$default((int) (jCeil2 >> c), (int) (jCeil2 & j), i);
                    androidCanvasCanvas2 = BrushKt.Canvas(androidImageBitmapM412ImageBitmapx__hDU$default);
                    drawCache.mCachedImage = androidImageBitmapM412ImageBitmapx__hDU$default;
                    drawCache.cachedCanvas = androidCanvasCanvas2;
                    drawCache.config = i;
                } else {
                    c = ' ';
                    j = 4294967295L;
                    androidImageBitmapM412ImageBitmapx__hDU$default = BrushKt.m412ImageBitmapx__hDU$default((int) (jCeil2 >> c), (int) (jCeil2 & j), i);
                    androidCanvasCanvas2 = BrushKt.Canvas(androidImageBitmapM412ImageBitmapx__hDU$default);
                    drawCache.mCachedImage = androidImageBitmapM412ImageBitmapx__hDU$default;
                    drawCache.cachedCanvas = androidCanvasCanvas2;
                    drawCache.config = i;
                }
                drawCache.size = jCeil2;
                CanvasDrawScope canvasDrawScope3 = drawCache.cacheScope;
                long jM724toSizeozmzZPI3 = IntSizeKt.m724toSizeozmzZPI(jCeil2);
                CanvasDrawScope.DrawParams drawParams5 = canvasDrawScope3.drawParams;
                Density density3 = drawParams5.density;
                LayoutDirection layoutDirection5 = drawParams5.layoutDirection;
                Canvas canvas3 = drawParams5.canvas;
                AndroidCanvas androidCanvas3 = androidCanvasCanvas2;
                long j4 = drawParams5.size;
                drawParams5.density = drawScope;
                drawParams5.layoutDirection = layoutDirection4;
                drawParams5.canvas = androidCanvas3;
                drawParams5.size = jM724toSizeozmzZPI3;
                androidCanvas3.save();
                Modifier.CC.m315drawRectnJ9OG0$default(canvasDrawScope3, Color.Black, 0L, 0.0f, 0, 62);
                this.drawVectorBlock.invoke(canvasDrawScope3);
                androidCanvas3.restore();
                CanvasDrawScope.DrawParams drawParams6 = canvasDrawScope3.drawParams;
                drawParams6.density = density3;
                drawParams6.layoutDirection = layoutDirection5;
                drawParams6.canvas = canvas3;
                drawParams6.size = j4;
                androidImageBitmapM412ImageBitmapx__hDU$default.bitmap.prepareToDraw();
                this.isDirty = false;
                this.previousDrawSize = drawScope.mo474getSizeNHjbRc();
            }
        }
        if (blendModeColorFilter3 == null) {
            blendModeColorFilter3 = ((BlendModeColorFilter) parcelableSnapshotMutableState.getValue()) != null ? (BlendModeColorFilter) parcelableSnapshotMutableState.getValue() : this.tintFilter;
        }
        BlendModeColorFilter blendModeColorFilter5 = blendModeColorFilter3;
        AndroidImageBitmap androidImageBitmap2 = drawCache.mCachedImage;
        if (androidImageBitmap2 == null) {
            InlineClassHelperKt.throwIllegalStateException("drawCachedImage must be invoked first before attempting to draw the result into another destination");
        }
        long j5 = drawCache.size;
        drawScope.mo464drawImageAZ2fEMs(androidImageBitmap2, 0L, j5, (328 & 16) != 0 ? j5 : 0L, (328 & 32) != 0 ? 1.0f : f, blendModeColorFilter5, (328 & 512) != 0 ? 1 : 0);
    }
}
