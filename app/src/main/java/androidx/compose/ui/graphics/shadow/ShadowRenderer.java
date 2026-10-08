package androidx.compose.ui.graphics.shadow;

import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Outline$Generic;
import androidx.compose.ui.graphics.Outline$Rectangle;
import androidx.compose.ui.graphics.Outline$Rounded;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.unit.LayoutDirection;
import coil.network.HttpException;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ShadowRenderer {
    public long cornerRadius;
    public float generatedDensity;
    public LayoutDirection generatedLayoutDirection;
    public long generatedSize;
    public final BrushKt outline;
    public AndroidPath path;
    public BlendModeColorFilter shadowTint;
    public long shadowTintColor;

    public ShadowRenderer(BrushKt brushKt) {
        this.outline = brushKt;
        int i = Color.$r8$clinit;
        this.shadowTintColor = Color.Unspecified;
        this.cornerRadius = 0L;
        this.generatedSize = 9205357640488583168L;
        this.generatedLayoutDirection = LayoutDirection.Ltr;
        this.generatedDensity = 1.0f;
    }

    /* JADX INFO: renamed from: buildShadow-_SMYjrA */
    public abstract void mo498buildShadow_SMYjrA(LayoutNodeDrawScope layoutNodeDrawScope, long j, long j2, AndroidPath androidPath);

    /* JADX INFO: renamed from: drawShadow-erFMhIw, reason: not valid java name */
    public final void m500drawShadowerFMhIw(LayoutNodeDrawScope layoutNodeDrawScope, BlendModeColorFilter blendModeColorFilter, long j, long j2, Brush brush, float f, int i) {
        CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
        BrushKt brushKt = this.outline;
        BlendModeColorFilter blendModeColorFilter2 = null;
        if (brushKt instanceof Outline$Generic) {
            this.path = ((Outline$Generic) brushKt).path;
            this.cornerRadius = 0L;
        } else if (brushKt instanceof Outline$Rounded) {
            Outline$Rounded outline$Rounded = (Outline$Rounded) brushKt;
            RoundRect roundRect = outline$Rounded.roundRect;
            if (RoundRectKt.isSimple(roundRect)) {
                this.path = null;
                this.cornerRadius = roundRect.topLeftCornerRadius;
            } else {
                this.path = outline$Rounded.roundRectPath;
                this.cornerRadius = 0L;
            }
        } else {
            if (!(brushKt instanceof Outline$Rectangle)) {
                throw new HttpException();
            }
            this.path = null;
            this.cornerRadius = 0L;
        }
        if (blendModeColorFilter != null) {
            blendModeColorFilter2 = blendModeColorFilter;
        } else if (brush == null && j2 != 16) {
            BlendModeColorFilter blendModeColorFilter3 = this.shadowTint;
            if (blendModeColorFilter3 == null || !Color.m435equalsimpl0(this.shadowTintColor, j2)) {
                blendModeColorFilter3 = new BlendModeColorFilter(5, j2);
                this.shadowTintColor = j2;
                this.shadowTint = blendModeColorFilter3;
            }
            blendModeColorFilter2 = blendModeColorFilter3;
        }
        long j3 = this.generatedSize;
        if (j3 == 9205357640488583168L || !Size.m384equalsimpl0(j3, j) || this.generatedLayoutDirection != layoutNodeDrawScope.getLayoutDirection() || this.generatedDensity != canvasDrawScope.getDensity()) {
            mo498buildShadow_SMYjrA(layoutNodeDrawScope, j, this.cornerRadius, this.path);
            this.generatedSize = j;
            this.generatedLayoutDirection = layoutNodeDrawScope.getLayoutDirection();
            this.generatedDensity = canvasDrawScope.getDensity();
        }
        mo499onDrawShadowMLmccfk(layoutNodeDrawScope, this.cornerRadius, this.path, f, blendModeColorFilter2, brush, i);
    }

    /* JADX INFO: renamed from: onDrawShadow-MLmccfk */
    public abstract void mo499onDrawShadowMLmccfk(LayoutNodeDrawScope layoutNodeDrawScope, long j, AndroidPath androidPath, float f, BlendModeColorFilter blendModeColorFilter, Brush brush, int i);
}
