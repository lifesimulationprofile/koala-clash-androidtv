package androidx.compose.ui.graphics.layer;

import android.graphics.Outline;
import android.graphics.RectF;
import android.os.Build;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPaint;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Outline$Generic;
import androidx.compose.ui.graphics.Outline$Rectangle;
import androidx.compose.ui.graphics.Outline$Rounded;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContextKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.navigation.Navigator;
import java.util.Locale;
import kotlin.jvm.functions.Function1;
import okhttp3.internal.connection.Exchange;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class GraphicsLayer {
    public Outline androidOutline;
    public boolean clip;
    public final GraphicsLayerImpl impl;
    public BrushKt internalOutline;
    public boolean isReleased;
    public AndroidPath outlinePath;
    public int parentLayerUsages;
    public RectF pathBounds;
    public long pivotOffset;
    public AndroidPath roundRectClipPath;
    public float roundRectCornerRadius;
    public long size;
    public CanvasDrawScope softwareDrawScope;
    public AndroidPaint softwareLayerPaint;
    public long topLeft;
    public boolean usePathForClip;
    public Density density = DrawContextKt.DefaultDensity;
    public LayoutDirection layoutDirection = LayoutDirection.Ltr;
    public Function1 drawBlock = GraphicsLayer$drawBlock$1.INSTANCE;
    public final Navigator.AnonymousClass1 clipDrawBlock = new Navigator.AnonymousClass1(11, this);
    public boolean outlineDirty = true;
    public long roundRectOutlineTopLeft = 0;
    public long roundRectOutlineSize = 9205357640488583168L;
    public final Exchange childDependenciesTracker = new Exchange();

    static {
        Build.FINGERPRINT.toLowerCase(Locale.ROOT).equals("robolectric");
    }

    public GraphicsLayer(GraphicsLayerImpl graphicsLayerImpl) {
        this.impl = graphicsLayerImpl;
        graphicsLayerImpl.setClip(false);
        this.topLeft = 0L;
        this.size = 0L;
        this.pivotOffset = 9205357640488583168L;
    }

    public final void configureOutlineAndClip() {
        Outline outline;
        if (this.outlineDirty) {
            boolean z = this.clip;
            Outline outline2 = null;
            GraphicsLayerImpl graphicsLayerImpl = this.impl;
            if (z || graphicsLayerImpl.getShadowElevation() > 0.0f) {
                AndroidPath androidPath = this.outlinePath;
                if (androidPath != null) {
                    RectF rectF = this.pathBounds;
                    if (rectF == null) {
                        rectF = new RectF();
                        this.pathBounds = rectF;
                    }
                    boolean z2 = androidPath instanceof AndroidPath;
                    if (!z2) {
                        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
                    }
                    androidPath.internalPath.computeBounds(rectF, false);
                    int i = Build.VERSION.SDK_INT;
                    if (i > 28 || androidPath.internalPath.isConvex()) {
                        outline = this.androidOutline;
                        if (outline == null) {
                            outline = new Outline();
                            this.androidOutline = outline;
                        }
                        if (i >= 30) {
                            if (!z2) {
                                throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
                            }
                            outline.setPath(androidPath.internalPath);
                        } else {
                            if (!z2) {
                                throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
                            }
                            outline.setConvexPath(androidPath.internalPath);
                        }
                        this.usePathForClip = !outline.canClip();
                    } else {
                        Outline outline3 = this.androidOutline;
                        if (outline3 != null) {
                            outline3.setEmpty();
                        }
                        this.usePathForClip = true;
                        outline = null;
                    }
                    this.outlinePath = androidPath;
                    if (outline != null) {
                        outline.setAlpha(graphicsLayerImpl.getAlpha());
                        outline2 = outline;
                    }
                    graphicsLayerImpl.mo485setOutlineO0kMr_c(outline2, (4294967295L & ((long) Math.round(rectF.height()))) | (((long) Math.round(rectF.width())) << 32));
                    if (this.usePathForClip && this.clip) {
                        graphicsLayerImpl.setClip(false);
                        graphicsLayerImpl.discardDisplayList();
                    } else {
                        graphicsLayerImpl.setClip(this.clip);
                    }
                } else {
                    graphicsLayerImpl.setClip(this.clip);
                    Outline outline4 = this.androidOutline;
                    if (outline4 == null) {
                        outline4 = new Outline();
                        this.androidOutline = outline4;
                    }
                    Outline outline5 = outline4;
                    long jM724toSizeozmzZPI = IntSizeKt.m724toSizeozmzZPI(this.size);
                    long j = this.roundRectOutlineTopLeft;
                    long j2 = this.roundRectOutlineSize;
                    long j3 = j2 == 9205357640488583168L ? jM724toSizeozmzZPI : j2;
                    int i2 = (int) (j >> 32);
                    int i3 = (int) (j & 4294967295L);
                    outline5.setRoundRect(Math.round(Float.intBitsToFloat(i2)), Math.round(Float.intBitsToFloat(i3)), Math.round(Float.intBitsToFloat((int) (j3 >> 32)) + Float.intBitsToFloat(i2)), Math.round(Float.intBitsToFloat((int) (4294967295L & j3)) + Float.intBitsToFloat(i3)), this.roundRectCornerRadius);
                    outline5.setAlpha(graphicsLayerImpl.getAlpha());
                    graphicsLayerImpl.mo485setOutlineO0kMr_c(outline5, IntSizeKt.m722roundToIntSizeuvyYCjk(j3));
                }
            } else {
                graphicsLayerImpl.setClip(false);
                graphicsLayerImpl.mo485setOutlineO0kMr_c(null, 0L);
            }
        }
        this.outlineDirty = false;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0068 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x006a A[LOOP:0: B:14:0x002d->B:24:0x006a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:29:0x006d A[EDGE_INSN: B:29:0x006d->B:25:0x006d BREAK  A[LOOP:0: B:14:0x002d->B:24:0x006a], SYNTHETIC] */
    public final void discardContentIfReleasedAndHaveNoParentLayerUsages() {
        if (this.isReleased && this.parentLayerUsages == 0) {
            Exchange exchange = this.childDependenciesTracker;
            GraphicsLayer graphicsLayer = (GraphicsLayer) exchange.call;
            if (graphicsLayer != null) {
                graphicsLayer.parentLayerUsages--;
                graphicsLayer.discardContentIfReleasedAndHaveNoParentLayerUsages();
                exchange.call = null;
            }
            MutableScatterSet mutableScatterSet = (MutableScatterSet) exchange.codec;
            if (mutableScatterSet != null) {
                Object[] objArr = mutableScatterSet.elements;
                long[] jArr = mutableScatterSet.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i = 0;
                    while (true) {
                        long j = jArr[i];
                        if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                            if (i != length) {
                                break;
                                break;
                            }
                            i++;
                        } else {
                            int i2 = 8 - ((~(i - length)) >>> 31);
                            for (int i3 = 0; i3 < i2; i3++) {
                                if ((255 & j) < 128) {
                                    GraphicsLayer graphicsLayer2 = (GraphicsLayer) objArr[(i << 3) + i3];
                                    graphicsLayer2.parentLayerUsages--;
                                    graphicsLayer2.discardContentIfReleasedAndHaveNoParentLayerUsages();
                                }
                                j >>= 8;
                            }
                            if (i2 != 8) {
                                break;
                            } else if (i != length) {
                                break;
                            } else {
                                i++;
                            }
                        }
                    }
                }
                mutableScatterSet.clear();
            }
            this.impl.discardDisplayList();
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0094 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x0096 A[LOOP:0: B:20:0x0059->B:30:0x0096, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:34:0x0099 A[EDGE_INSN: B:34:0x0099->B:31:0x0099 BREAK  A[LOOP:0: B:20:0x0059->B:30:0x0096], SYNTHETIC] */
    public final void drawWithChildTracking(DrawScope drawScope) {
        Exchange exchange = this.childDependenciesTracker;
        exchange.finder = (GraphicsLayer) exchange.call;
        MutableScatterSet mutableScatterSet = (MutableScatterSet) exchange.codec;
        if (mutableScatterSet != null && mutableScatterSet.isNotEmpty()) {
            MutableScatterSet mutableScatterSet2 = (MutableScatterSet) exchange.connection;
            if (mutableScatterSet2 == null) {
                MutableScatterSet mutableScatterSet3 = ScatterSetKt.EmptyScatterSet;
                mutableScatterSet2 = new MutableScatterSet();
                exchange.connection = mutableScatterSet2;
            }
            mutableScatterSet2.plusAssign(mutableScatterSet);
            mutableScatterSet.clear();
        }
        exchange.hasFailure = true;
        this.drawBlock.invoke(drawScope);
        exchange.hasFailure = false;
        GraphicsLayer graphicsLayer = (GraphicsLayer) exchange.finder;
        if (graphicsLayer != null) {
            graphicsLayer.parentLayerUsages--;
            graphicsLayer.discardContentIfReleasedAndHaveNoParentLayerUsages();
        }
        MutableScatterSet mutableScatterSet4 = (MutableScatterSet) exchange.connection;
        if (mutableScatterSet4 == null || !mutableScatterSet4.isNotEmpty()) {
            return;
        }
        Object[] objArr = mutableScatterSet4.elements;
        long[] jArr = mutableScatterSet4.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i != length) {
                        break;
                        break;
                    }
                    i++;
                } else {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            GraphicsLayer graphicsLayer2 = (GraphicsLayer) objArr[(i << 3) + i3];
                            graphicsLayer2.parentLayerUsages--;
                            graphicsLayer2.discardContentIfReleasedAndHaveNoParentLayerUsages();
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    } else if (i != length) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        mutableScatterSet4.clear();
    }

    public final BrushKt getOutline() {
        BrushKt outline$Rectangle;
        BrushKt brushKt = this.internalOutline;
        AndroidPath androidPath = this.outlinePath;
        if (brushKt != null) {
            return brushKt;
        }
        if (androidPath != null) {
            Outline$Generic outline$Generic = new Outline$Generic(androidPath);
            this.internalOutline = outline$Generic;
            return outline$Generic;
        }
        long jM724toSizeozmzZPI = IntSizeKt.m724toSizeozmzZPI(this.size);
        long j = this.roundRectOutlineTopLeft;
        long j2 = this.roundRectOutlineSize;
        if (j2 != 9205357640488583168L) {
            jM724toSizeozmzZPI = j2;
        }
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (jM724toSizeozmzZPI >> 32)) + fIntBitsToFloat;
        float fIntBitsToFloat4 = Float.intBitsToFloat((int) (jM724toSizeozmzZPI & 4294967295L)) + fIntBitsToFloat2;
        float f = this.roundRectCornerRadius;
        if (f > 0.0f) {
            outline$Rectangle = new Outline$Rounded(RoundRectKt.m383RoundRectgG7oq9Y(fIntBitsToFloat, fIntBitsToFloat2, fIntBitsToFloat3, fIntBitsToFloat4, (((long) Float.floatToRawIntBits(f)) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(f)))));
        } else {
            outline$Rectangle = new Outline$Rectangle(new Rect(fIntBitsToFloat, fIntBitsToFloat2, fIntBitsToFloat3, fIntBitsToFloat4));
        }
        this.internalOutline = outline$Rectangle;
        return outline$Rectangle;
    }

    /* JADX INFO: renamed from: record-mL-hObY, reason: not valid java name */
    public final void m476recordmLhObY(Density density, LayoutDirection layoutDirection, long j, Function1 function1) {
        boolean zM720equalsimpl0 = IntSize.m720equalsimpl0(this.size, j);
        GraphicsLayerImpl graphicsLayerImpl = this.impl;
        if (!zM720equalsimpl0) {
            this.size = j;
            long j2 = this.topLeft;
            graphicsLayerImpl.mo487setPositionH0pRuoY((int) (j2 >> 32), (int) (j2 & 4294967295L), j);
            if (this.roundRectOutlineSize == 9205357640488583168L) {
                this.outlineDirty = true;
                configureOutlineAndClip();
            }
        }
        this.density = density;
        this.layoutDirection = layoutDirection;
        this.drawBlock = function1;
        graphicsLayerImpl.record(density, layoutDirection, this, this.clipDrawBlock);
    }

    public final void setAlpha(float f) {
        GraphicsLayerImpl graphicsLayerImpl = this.impl;
        if (graphicsLayerImpl.getAlpha() == f) {
            return;
        }
        graphicsLayerImpl.setAlpha(f);
    }

    public final void setClip(boolean z) {
        if (this.clip != z) {
            this.clip = z;
            this.outlineDirty = true;
            configureOutlineAndClip();
        }
    }

    /* JADX INFO: renamed from: setRoundRectOutline-TNW_H78, reason: not valid java name */
    public final void m477setRoundRectOutlineTNW_H78(long j, long j2, float f) {
        if (Offset.m369equalsimpl0(this.roundRectOutlineTopLeft, j) && Size.m384equalsimpl0(this.roundRectOutlineSize, j2) && this.roundRectCornerRadius == f && this.outlinePath == null) {
            return;
        }
        this.internalOutline = null;
        this.outlinePath = null;
        this.outlineDirty = true;
        this.usePathForClip = false;
        this.roundRectOutlineTopLeft = j;
        this.roundRectOutlineSize = j2;
        this.roundRectCornerRadius = f;
        configureOutlineAndClip();
    }
}
