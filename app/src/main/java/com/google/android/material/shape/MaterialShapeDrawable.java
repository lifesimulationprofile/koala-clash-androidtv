package com.google.android.material.shape;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.shadow.ShadowRenderer;
import java.util.BitSet;
import java.util.Objects;
import okhttp3.Headers;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class MaterialShapeDrawable extends Drawable implements Shapeable {
    public static final Paint clearPaint;
    public final BitSet containsIncompatibleShadowOp;
    public final ShapePath.ShadowCompatOperation[] cornerShadowOperation;
    public MaterialShapeDrawableState drawableState;
    public final ShapePath.ShadowCompatOperation[] edgeShadowOperation;
    public final Paint fillPaint;
    public final RectF insetRectF;
    public final Matrix matrix;
    public final Path path;
    public final RectF pathBounds;
    public boolean pathDirty;
    public final Path pathInsetByStroke;
    public final ShapeAppearancePathProvider pathProvider;
    public final Headers.Builder pathShadowListener;
    public final RectF rectF;
    public final Region scratchRegion;
    public final boolean shadowBitmapDrawingEnable;
    public final ShadowRenderer shadowRenderer;
    public final Paint strokePaint;
    public ShapeAppearanceModel strokeShapeAppearance;
    public PorterDuffColorFilter strokeTintFilter;
    public PorterDuffColorFilter tintFilter;
    public final Region transparentRegion;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class MaterialShapeDrawableState extends Drawable.ConstantState {
        public int alpha;
        public float elevation;
        public ElevationOverlayProvider elevationOverlayProvider;
        public ColorStateList fillColor;
        public float interpolation;
        public Rect padding;
        public Paint.Style paintStyle;
        public float parentAbsoluteElevation;
        public float scale;
        public int shadowCompatOffset;
        public int shadowCompatRadius;
        public ShapeAppearanceModel shapeAppearanceModel;
        public ColorStateList strokeColor;
        public float strokeWidth;
        public ColorStateList tintList;
        public PorterDuff.Mode tintMode;

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this);
            materialShapeDrawable.pathDirty = true;
            return materialShapeDrawable;
        }
    }

    static {
        Paint paint = new Paint(1);
        clearPaint = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public MaterialShapeDrawable() {
        this(new ShapeAppearanceModel());
    }

    public final void calculatePath(RectF rectF, Path path) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        this.pathProvider.calculatePath(materialShapeDrawableState.shapeAppearanceModel, materialShapeDrawableState.interpolation, rectF, this.pathShadowListener, path);
        if (this.drawableState.scale != 1.0f) {
            Matrix matrix = this.matrix;
            matrix.reset();
            float f = this.drawableState.scale;
            matrix.setScale(f, f, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(matrix);
        }
        path.computeBounds(this.pathBounds, true);
    }

    public final int compositeElevationOverlayIfNeeded(int i) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        float f = materialShapeDrawableState.elevation + 0.0f + materialShapeDrawableState.parentAbsoluteElevation;
        ElevationOverlayProvider elevationOverlayProvider = materialShapeDrawableState.elevationOverlayProvider;
        return elevationOverlayProvider != null ? elevationOverlayProvider.compositeOverlayIfNeeded(i, f) : i;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        PorterDuffColorFilter porterDuffColorFilter = this.tintFilter;
        Paint paint = this.fillPaint;
        paint.setColorFilter(porterDuffColorFilter);
        int alpha = paint.getAlpha();
        int i = this.drawableState.alpha;
        paint.setAlpha(((i + (i >>> 7)) * alpha) >>> 8);
        PorterDuffColorFilter porterDuffColorFilter2 = this.strokeTintFilter;
        Paint paint2 = this.strokePaint;
        paint2.setColorFilter(porterDuffColorFilter2);
        paint2.setStrokeWidth(this.drawableState.strokeWidth);
        int alpha2 = paint2.getAlpha();
        int i2 = this.drawableState.alpha;
        paint2.setAlpha(((i2 + (i2 >>> 7)) * alpha2) >>> 8);
        boolean z = this.pathDirty;
        Path path = this.path;
        if (z) {
            float f = -(hasStroke() ? paint2.getStrokeWidth() / 2.0f : 0.0f);
            ShapeAppearanceModel shapeAppearanceModel = this.drawableState.shapeAppearanceModel;
            ShapeAppearanceModel.Builder builder = shapeAppearanceModel.toBuilder();
            CornerSize adjustedCornerSize = shapeAppearanceModel.topLeftCornerSize;
            if (!(adjustedCornerSize instanceof RelativeCornerSize)) {
                adjustedCornerSize = new AdjustedCornerSize(f, adjustedCornerSize);
            }
            builder.topLeftCornerSize = adjustedCornerSize;
            CornerSize adjustedCornerSize2 = shapeAppearanceModel.topRightCornerSize;
            if (!(adjustedCornerSize2 instanceof RelativeCornerSize)) {
                adjustedCornerSize2 = new AdjustedCornerSize(f, adjustedCornerSize2);
            }
            builder.topRightCornerSize = adjustedCornerSize2;
            CornerSize adjustedCornerSize3 = shapeAppearanceModel.bottomLeftCornerSize;
            if (!(adjustedCornerSize3 instanceof RelativeCornerSize)) {
                adjustedCornerSize3 = new AdjustedCornerSize(f, adjustedCornerSize3);
            }
            builder.bottomLeftCornerSize = adjustedCornerSize3;
            CornerSize adjustedCornerSize4 = shapeAppearanceModel.bottomRightCornerSize;
            if (!(adjustedCornerSize4 instanceof RelativeCornerSize)) {
                adjustedCornerSize4 = new AdjustedCornerSize(f, adjustedCornerSize4);
            }
            builder.bottomRightCornerSize = adjustedCornerSize4;
            ShapeAppearanceModel shapeAppearanceModelBuild = builder.build();
            this.strokeShapeAppearance = shapeAppearanceModelBuild;
            float f2 = this.drawableState.interpolation;
            RectF boundsAsRectF = getBoundsAsRectF();
            RectF rectF = this.insetRectF;
            rectF.set(boundsAsRectF);
            float strokeWidth = hasStroke() ? paint2.getStrokeWidth() / 2.0f : 0.0f;
            rectF.inset(strokeWidth, strokeWidth);
            this.pathProvider.calculatePath(shapeAppearanceModelBuild, f2, rectF, null, this.pathInsetByStroke);
            calculatePath(getBoundsAsRectF(), path);
            this.pathDirty = false;
        }
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        materialShapeDrawableState.getClass();
        if (materialShapeDrawableState.shadowCompatRadius > 0) {
            int i3 = Build.VERSION.SDK_INT;
            if (!this.drawableState.shapeAppearanceModel.isRoundRect(getBoundsAsRectF()) && !path.isConvex() && i3 < 29) {
                canvas.save();
                double d = 0;
                canvas.translate((int) (Math.sin(Math.toRadians(d)) * ((double) this.drawableState.shadowCompatOffset)), (int) (Math.cos(Math.toRadians(d)) * ((double) this.drawableState.shadowCompatOffset)));
                if (this.shadowBitmapDrawingEnable) {
                    RectF rectF2 = this.pathBounds;
                    int iWidth = (int) (rectF2.width() - getBounds().width());
                    int iHeight = (int) (rectF2.height() - getBounds().height());
                    if (iWidth < 0 || iHeight < 0) {
                        throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
                    }
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap((this.drawableState.shadowCompatRadius * 2) + ((int) rectF2.width()) + iWidth, (this.drawableState.shadowCompatRadius * 2) + ((int) rectF2.height()) + iHeight, Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(bitmapCreateBitmap);
                    float f3 = (getBounds().left - this.drawableState.shadowCompatRadius) - iWidth;
                    float f4 = (getBounds().top - this.drawableState.shadowCompatRadius) - iHeight;
                    canvas2.translate(-f3, -f4);
                    drawCompatShadow(canvas2);
                    canvas.drawBitmap(bitmapCreateBitmap, f3, f4, (Paint) null);
                    bitmapCreateBitmap.recycle();
                    canvas.restore();
                } else {
                    drawCompatShadow(canvas);
                    canvas.restore();
                }
            }
        }
        MaterialShapeDrawableState materialShapeDrawableState2 = this.drawableState;
        Paint.Style style = materialShapeDrawableState2.paintStyle;
        if (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL) {
            drawShape(canvas, paint, path, materialShapeDrawableState2.shapeAppearanceModel, getBoundsAsRectF());
        }
        if (hasStroke()) {
            drawStrokeShape(canvas);
        }
        paint.setAlpha(alpha);
        paint2.setAlpha(alpha2);
    }

    public final void drawCompatShadow(Canvas canvas) {
        if (this.containsIncompatibleShadowOp.cardinality() > 0) {
            Log.w("MaterialShapeDrawable", "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        int i = this.drawableState.shadowCompatOffset;
        Path path = this.path;
        ShadowRenderer shadowRenderer = this.shadowRenderer;
        if (i != 0) {
            canvas.drawPath(path, shadowRenderer.shadowPaint);
        }
        for (int i2 = 0; i2 < 4; i2++) {
            ShapePath.ShadowCompatOperation shadowCompatOperation = this.cornerShadowOperation[i2];
            int i3 = this.drawableState.shadowCompatRadius;
            Matrix matrix = ShapePath.ShadowCompatOperation.IDENTITY_MATRIX;
            shadowCompatOperation.draw(matrix, shadowRenderer, i3, canvas);
            this.edgeShadowOperation[i2].draw(matrix, shadowRenderer, this.drawableState.shadowCompatRadius, canvas);
        }
        if (this.shadowBitmapDrawingEnable) {
            double d = 0;
            int iSin = (int) (Math.sin(Math.toRadians(d)) * ((double) this.drawableState.shadowCompatOffset));
            int iCos = (int) (Math.cos(Math.toRadians(d)) * ((double) this.drawableState.shadowCompatOffset));
            canvas.translate(-iSin, -iCos);
            canvas.drawPath(path, clearPaint);
            canvas.translate(iSin, iCos);
        }
    }

    public final void drawShape(Canvas canvas, Paint paint, Path path, ShapeAppearanceModel shapeAppearanceModel, RectF rectF) {
        if (!shapeAppearanceModel.isRoundRect(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float cornerSize = shapeAppearanceModel.topRightCornerSize.getCornerSize(rectF) * this.drawableState.interpolation;
            canvas.drawRoundRect(rectF, cornerSize, cornerSize, paint);
        }
    }

    public void drawStrokeShape(Canvas canvas) {
        ShapeAppearanceModel shapeAppearanceModel = this.strokeShapeAppearance;
        RectF boundsAsRectF = getBoundsAsRectF();
        RectF rectF = this.insetRectF;
        rectF.set(boundsAsRectF);
        boolean zHasStroke = hasStroke();
        Paint paint = this.strokePaint;
        float strokeWidth = zHasStroke ? paint.getStrokeWidth() / 2.0f : 0.0f;
        rectF.inset(strokeWidth, strokeWidth);
        drawShape(canvas, paint, this.pathInsetByStroke, shapeAppearanceModel, rectF);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.drawableState.alpha;
    }

    public final RectF getBoundsAsRectF() {
        Rect bounds = getBounds();
        RectF rectF = this.rectF;
        rectF.set(bounds);
        return rectF;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.drawableState;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        this.drawableState.getClass();
        if (this.drawableState.shapeAppearanceModel.isRoundRect(getBoundsAsRectF())) {
            outline.setRoundRect(getBounds(), this.drawableState.shapeAppearanceModel.topLeftCornerSize.getCornerSize(getBoundsAsRectF()) * this.drawableState.interpolation);
            return;
        }
        RectF boundsAsRectF = getBoundsAsRectF();
        Path path = this.path;
        calculatePath(boundsAsRectF, path);
        if (path.isConvex() || Build.VERSION.SDK_INT >= 29) {
            try {
                outline.setConvexPath(path);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        Rect rect2 = this.drawableState.padding;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final Region getTransparentRegion() {
        Rect bounds = getBounds();
        Region region = this.transparentRegion;
        region.set(bounds);
        RectF boundsAsRectF = getBoundsAsRectF();
        Path path = this.path;
        calculatePath(boundsAsRectF, path);
        Region region2 = this.scratchRegion;
        region2.setPath(path, region);
        region.op(region2, Region.Op.DIFFERENCE);
        return region;
    }

    public final boolean hasStroke() {
        Paint.Style style = this.drawableState.paintStyle;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.strokePaint.getStrokeWidth() > 0.0f;
    }

    public final void initializeElevationOverlay(Context context) {
        this.drawableState.elevationOverlayProvider = new ElevationOverlayProvider(context);
        updateZ();
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        this.pathDirty = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (super.isStateful()) {
            return true;
        }
        ColorStateList colorStateList = this.drawableState.tintList;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        this.drawableState.getClass();
        ColorStateList colorStateList2 = this.drawableState.strokeColor;
        if (colorStateList2 != null && colorStateList2.isStateful()) {
            return true;
        }
        ColorStateList colorStateList3 = this.drawableState.fillColor;
        return colorStateList3 != null && colorStateList3.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        MaterialShapeDrawableState materialShapeDrawableState2 = new MaterialShapeDrawableState();
        materialShapeDrawableState2.fillColor = null;
        materialShapeDrawableState2.strokeColor = null;
        materialShapeDrawableState2.tintList = null;
        materialShapeDrawableState2.tintMode = PorterDuff.Mode.SRC_IN;
        materialShapeDrawableState2.padding = null;
        materialShapeDrawableState2.scale = 1.0f;
        materialShapeDrawableState2.interpolation = 1.0f;
        materialShapeDrawableState2.alpha = 255;
        materialShapeDrawableState2.parentAbsoluteElevation = 0.0f;
        materialShapeDrawableState2.elevation = 0.0f;
        materialShapeDrawableState2.shadowCompatRadius = 0;
        materialShapeDrawableState2.shadowCompatOffset = 0;
        materialShapeDrawableState2.paintStyle = Paint.Style.FILL_AND_STROKE;
        materialShapeDrawableState2.shapeAppearanceModel = materialShapeDrawableState.shapeAppearanceModel;
        materialShapeDrawableState2.elevationOverlayProvider = materialShapeDrawableState.elevationOverlayProvider;
        materialShapeDrawableState2.strokeWidth = materialShapeDrawableState.strokeWidth;
        materialShapeDrawableState2.fillColor = materialShapeDrawableState.fillColor;
        materialShapeDrawableState2.strokeColor = materialShapeDrawableState.strokeColor;
        materialShapeDrawableState2.tintMode = materialShapeDrawableState.tintMode;
        materialShapeDrawableState2.tintList = materialShapeDrawableState.tintList;
        materialShapeDrawableState2.alpha = materialShapeDrawableState.alpha;
        materialShapeDrawableState2.scale = materialShapeDrawableState.scale;
        materialShapeDrawableState2.shadowCompatOffset = materialShapeDrawableState.shadowCompatOffset;
        materialShapeDrawableState2.interpolation = materialShapeDrawableState.interpolation;
        materialShapeDrawableState2.parentAbsoluteElevation = materialShapeDrawableState.parentAbsoluteElevation;
        materialShapeDrawableState2.elevation = materialShapeDrawableState.elevation;
        materialShapeDrawableState2.shadowCompatRadius = materialShapeDrawableState.shadowCompatRadius;
        materialShapeDrawableState2.paintStyle = materialShapeDrawableState.paintStyle;
        if (materialShapeDrawableState.padding != null) {
            materialShapeDrawableState2.padding = new Rect(materialShapeDrawableState.padding);
        }
        this.drawableState = materialShapeDrawableState2;
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        this.pathDirty = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z = updateColorsForState(iArr) || updateTintFilter();
        if (z) {
            invalidateSelf();
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.alpha != i) {
            materialShapeDrawableState.alpha = i;
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.drawableState.getClass();
        super.invalidateSelf();
    }

    public final void setElevation(float f) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.elevation != f) {
            materialShapeDrawableState.elevation = f;
            updateZ();
        }
    }

    public final void setFillColor(ColorStateList colorStateList) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.fillColor != colorStateList) {
            materialShapeDrawableState.fillColor = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // com.google.android.material.shape.Shapeable
    public final void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        this.drawableState.shapeAppearanceModel = shapeAppearanceModel;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.drawableState.tintList = colorStateList;
        updateTintFilter();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        if (materialShapeDrawableState.tintMode != mode) {
            materialShapeDrawableState.tintMode = mode;
            updateTintFilter();
            super.invalidateSelf();
        }
    }

    public final boolean updateColorsForState(int[] iArr) {
        boolean z;
        Paint paint;
        int color;
        int colorForState;
        Paint paint2;
        int color2;
        int colorForState2;
        if (this.drawableState.fillColor == null || color2 == (colorForState2 = this.drawableState.fillColor.getColorForState(iArr, (color2 = (paint2 = this.fillPaint).getColor())))) {
            z = false;
        } else {
            paint2.setColor(colorForState2);
            z = true;
        }
        if (this.drawableState.strokeColor == null || color == (colorForState = this.drawableState.strokeColor.getColorForState(iArr, (color = (paint = this.strokePaint).getColor())))) {
            return z;
        }
        paint.setColor(colorForState);
        return true;
    }

    public final boolean updateTintFilter() {
        PorterDuffColorFilter porterDuffColorFilter;
        PorterDuffColorFilter porterDuffColorFilter2 = this.tintFilter;
        PorterDuffColorFilter porterDuffColorFilter3 = this.strokeTintFilter;
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        ColorStateList colorStateList = materialShapeDrawableState.tintList;
        PorterDuff.Mode mode = materialShapeDrawableState.tintMode;
        if (colorStateList == null || mode == null) {
            int color = this.fillPaint.getColor();
            int iCompositeElevationOverlayIfNeeded = compositeElevationOverlayIfNeeded(color);
            porterDuffColorFilter = iCompositeElevationOverlayIfNeeded != color ? new PorterDuffColorFilter(iCompositeElevationOverlayIfNeeded, PorterDuff.Mode.SRC_IN) : null;
        } else {
            porterDuffColorFilter = new PorterDuffColorFilter(compositeElevationOverlayIfNeeded(colorStateList.getColorForState(getState(), 0)), mode);
        }
        this.tintFilter = porterDuffColorFilter;
        this.drawableState.getClass();
        this.strokeTintFilter = null;
        this.drawableState.getClass();
        return (Objects.equals(porterDuffColorFilter2, this.tintFilter) && Objects.equals(porterDuffColorFilter3, this.strokeTintFilter)) ? false : true;
    }

    public final void updateZ() {
        MaterialShapeDrawableState materialShapeDrawableState = this.drawableState;
        float f = materialShapeDrawableState.elevation + 0.0f;
        materialShapeDrawableState.shadowCompatRadius = (int) Math.ceil(0.75f * f);
        this.drawableState.shadowCompatOffset = (int) Math.ceil(f * 0.25f);
        updateTintFilter();
        super.invalidateSelf();
    }

    public MaterialShapeDrawable(Context context, AttributeSet attributeSet, int i, int i2) {
        this(ShapeAppearanceModel.builder(context, attributeSet, i, i2).build());
    }

    public MaterialShapeDrawable(ShapeAppearanceModel shapeAppearanceModel) {
        MaterialShapeDrawableState materialShapeDrawableState = new MaterialShapeDrawableState();
        materialShapeDrawableState.fillColor = null;
        materialShapeDrawableState.strokeColor = null;
        materialShapeDrawableState.tintList = null;
        materialShapeDrawableState.tintMode = PorterDuff.Mode.SRC_IN;
        materialShapeDrawableState.padding = null;
        materialShapeDrawableState.scale = 1.0f;
        materialShapeDrawableState.interpolation = 1.0f;
        materialShapeDrawableState.alpha = 255;
        materialShapeDrawableState.parentAbsoluteElevation = 0.0f;
        materialShapeDrawableState.elevation = 0.0f;
        materialShapeDrawableState.shadowCompatRadius = 0;
        materialShapeDrawableState.shadowCompatOffset = 0;
        materialShapeDrawableState.paintStyle = Paint.Style.FILL_AND_STROKE;
        materialShapeDrawableState.shapeAppearanceModel = shapeAppearanceModel;
        materialShapeDrawableState.elevationOverlayProvider = null;
        this(materialShapeDrawableState);
    }

    public MaterialShapeDrawable(MaterialShapeDrawableState materialShapeDrawableState) {
        ShapeAppearancePathProvider shapeAppearancePathProvider;
        this.cornerShadowOperation = new ShapePath.ShadowCompatOperation[4];
        this.edgeShadowOperation = new ShapePath.ShadowCompatOperation[4];
        this.containsIncompatibleShadowOp = new BitSet(8);
        this.matrix = new Matrix();
        this.path = new Path();
        this.pathInsetByStroke = new Path();
        this.rectF = new RectF();
        this.insetRectF = new RectF();
        this.transparentRegion = new Region();
        this.scratchRegion = new Region();
        Paint paint = new Paint(1);
        this.fillPaint = paint;
        Paint paint2 = new Paint(1);
        this.strokePaint = paint2;
        this.shadowRenderer = new ShadowRenderer();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            shapeAppearancePathProvider = ShapeAppearancePathProvider.Lazy.INSTANCE;
        } else {
            shapeAppearancePathProvider = new ShapeAppearancePathProvider();
        }
        this.pathProvider = shapeAppearancePathProvider;
        this.pathBounds = new RectF();
        this.shadowBitmapDrawingEnable = true;
        this.drawableState = materialShapeDrawableState;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        updateTintFilter();
        updateColorsForState(getState());
        this.pathShadowListener = new Headers.Builder(12, this);
    }
}
