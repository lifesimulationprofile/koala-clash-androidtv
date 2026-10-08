package androidx.compose.foundation.style;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda1;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Interpolatable;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.StandaloneCoroutine;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class StyleAnimations {
    public boolean inGuard;
    public final StyleOuterNode node;
    public int size;
    public final ResolvedStyle currentStyle = new ResolvedStyle();
    public Entry[] values = new Entry[2];

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Entry {
        public final AnimationSpec fromSpec;
        public StandaloneCoroutine job;
        public final int key;
        public OutlinedTextFieldDefaults$$ExternalSyntheticLambda1 style;
        public final AnimationSpec toSpec;
        public final Animatable anim = ArcSplineKt.Animatable$default(0.0f);
        public final ResolvedStyle styleScope = new ResolvedStyle();
        public int state = 3;

        public Entry(int i, OutlinedTextFieldDefaults$$ExternalSyntheticLambda1 outlinedTextFieldDefaults$$ExternalSyntheticLambda1, AnimationSpec animationSpec, AnimationSpec animationSpec2) {
            this.key = i;
            this.style = outlinedTextFieldDefaults$$ExternalSyntheticLambda1;
            this.toSpec = animationSpec;
            this.fromSpec = animationSpec2;
        }
    }

    public StyleAnimations(StyleOuterNode styleOuterNode) {
        this.node = styleOuterNode;
    }

    public static final void access$cleanupAnimations(StyleAnimations styleAnimations) {
        Entry[] entryArr = styleAnimations.values;
        int i = styleAnimations.size;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Entry entry = entryArr[i3];
            if (entry == null) {
                break;
            }
            if (entry.state != 4 || ((Boolean) entry.anim.isRunning$delegate.getValue()).booleanValue()) {
                if (i2 != i3) {
                    entryArr[i2] = entry;
                    entryArr[i3] = null;
                }
                i2++;
            } else {
                entryArr[i3] = null;
            }
        }
        styleAnimations.size = i2;
        if (i == i2 || styleAnimations.inGuard) {
            return;
        }
        styleAnimations.inGuard = true;
        try {
            styleAnimations.node.resolveStyleAndInvalidate(false);
        } finally {
            styleAnimations.inGuard = false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:133:0x0360  */
    public final void applyAnimationsTo(ResolvedStyle resolvedStyle, Density density, StyleOuterNode styleOuterNode, int i) {
        float f;
        Entry[] entryArr = this.values;
        int i2 = this.size;
        int i3 = 0;
        while (i3 < i2) {
            Entry entry = entryArr[i3];
            if (entry != null) {
                ResolvedStyle resolvedStyle2 = entry.styleScope;
                resolvedStyle.copyInto$foundation(resolvedStyle2);
                resolvedStyle2.resolve$foundation(entry.style, styleOuterNode, density, true);
                if ((resolvedStyle.diff$foundation(resolvedStyle2, i) & i) != 0) {
                    float fFloatValue = ((Number) entry.anim.getValue()).floatValue();
                    ResolvedStyle resolvedStyle3 = ResolvedStyleKt.EmptyResolvedStyle;
                    int i4 = resolvedStyle.flags | resolvedStyle2.flags;
                    resolvedStyle.flags = i4;
                    int i5 = i4 & i;
                    if ((i5 & 8) != 0) {
                        float f2 = resolvedStyle.externalPaddingStart;
                        float f3 = resolvedStyle2.externalPaddingStart;
                        boolean zIsNaN = Float.isNaN(f2);
                        boolean zIsNaN2 = Float.isNaN(f3);
                        float f4 = 1 - fFloatValue;
                        float f5 = (fFloatValue * f3) + (f4 * f2);
                        if (zIsNaN) {
                            f2 = f3;
                        } else if (!zIsNaN2) {
                            f2 = f5;
                        }
                        resolvedStyle.externalPaddingStart = f2;
                        float f6 = resolvedStyle.externalPaddingEnd;
                        float f7 = resolvedStyle2.externalPaddingEnd;
                        boolean zIsNaN3 = Float.isNaN(f6);
                        boolean zIsNaN4 = Float.isNaN(f7);
                        float f8 = (fFloatValue * f7) + (f4 * f6);
                        if (zIsNaN3) {
                            f6 = f7;
                        } else if (!zIsNaN4) {
                            f6 = f8;
                        }
                        resolvedStyle.externalPaddingEnd = f6;
                        float f9 = resolvedStyle.externalPaddingTop;
                        float f10 = resolvedStyle2.externalPaddingTop;
                        boolean zIsNaN5 = Float.isNaN(f9);
                        boolean zIsNaN6 = Float.isNaN(f10);
                        float f11 = (fFloatValue * f10) + (f4 * f9);
                        if (zIsNaN5) {
                            f9 = f10;
                        } else if (!zIsNaN6) {
                            f9 = f11;
                        }
                        resolvedStyle.externalPaddingTop = f9;
                        float f12 = resolvedStyle.externalPaddingBottom;
                        float f13 = resolvedStyle2.externalPaddingBottom;
                        boolean zIsNaN7 = Float.isNaN(f12);
                        boolean zIsNaN8 = Float.isNaN(f13);
                        float f14 = (fFloatValue * f13) + (f4 * f12);
                        if (zIsNaN7) {
                            f12 = f13;
                        } else if (!zIsNaN8) {
                            f12 = f14;
                        }
                        resolvedStyle.externalPaddingBottom = f12;
                        float f15 = resolvedStyle.left;
                        float f16 = resolvedStyle2.left;
                        boolean zIsNaN9 = Float.isNaN(f15);
                        boolean zIsNaN10 = Float.isNaN(f16);
                        float f17 = (fFloatValue * f16) + (f4 * f15);
                        if (zIsNaN9) {
                            f15 = f16;
                        } else if (!zIsNaN10) {
                            f15 = f17;
                        }
                        resolvedStyle.left = f15;
                        float f18 = resolvedStyle.top;
                        float f19 = resolvedStyle2.top;
                        boolean zIsNaN11 = Float.isNaN(f18);
                        boolean zIsNaN12 = Float.isNaN(f19);
                        float f20 = (fFloatValue * f19) + (f4 * f18);
                        if (zIsNaN11) {
                            f18 = f19;
                        } else if (!zIsNaN12) {
                            f18 = f20;
                        }
                        resolvedStyle.top = f18;
                        float f21 = resolvedStyle.right;
                        float f22 = resolvedStyle2.right;
                        boolean zIsNaN13 = Float.isNaN(f21);
                        boolean zIsNaN14 = Float.isNaN(f22);
                        float f23 = (fFloatValue * f22) + (f4 * f21);
                        if (zIsNaN13) {
                            f21 = f22;
                        } else if (!zIsNaN14) {
                            f21 = f23;
                        }
                        resolvedStyle.right = f21;
                        float f24 = resolvedStyle.bottom;
                        float f25 = resolvedStyle2.bottom;
                        boolean zIsNaN15 = Float.isNaN(f24);
                        boolean zIsNaN16 = Float.isNaN(f25);
                        float f26 = (fFloatValue * f25) + (f4 * f24);
                        if (zIsNaN15) {
                            f24 = f25;
                        } else if (!zIsNaN16) {
                            f24 = f26;
                        }
                        resolvedStyle.bottom = f24;
                        float f27 = resolvedStyle.width;
                        float f28 = resolvedStyle2.width;
                        boolean zIsNaN17 = Float.isNaN(f27);
                        boolean zIsNaN18 = Float.isNaN(f28);
                        float f29 = (fFloatValue * f28) + (f4 * f27);
                        if (zIsNaN17) {
                            f27 = f28;
                        } else if (!zIsNaN18) {
                            f27 = f29;
                        }
                        resolvedStyle.width = f27;
                        float f30 = resolvedStyle.height;
                        float f31 = resolvedStyle2.height;
                        boolean zIsNaN19 = Float.isNaN(f30);
                        boolean zIsNaN20 = Float.isNaN(f31);
                        float f32 = (fFloatValue * f31) + (f4 * f30);
                        if (zIsNaN19) {
                            f30 = f31;
                        } else if (!zIsNaN20) {
                            f30 = f32;
                        }
                        resolvedStyle.height = f30;
                        float f33 = resolvedStyle.widthFraction;
                        float f34 = resolvedStyle2.widthFraction;
                        boolean zIsNaN21 = Float.isNaN(f33);
                        boolean zIsNaN22 = Float.isNaN(f34);
                        float f35 = (fFloatValue * f34) + (f4 * f33);
                        if (zIsNaN21) {
                            f33 = f34;
                        } else if (!zIsNaN22) {
                            f33 = f35;
                        }
                        resolvedStyle.widthFraction = f33;
                        float f36 = resolvedStyle.heightFraction;
                        float f37 = resolvedStyle2.heightFraction;
                        boolean zIsNaN23 = Float.isNaN(f36);
                        boolean zIsNaN24 = Float.isNaN(f37);
                        float f38 = (fFloatValue * f37) + (f4 * f36);
                        if (zIsNaN23) {
                            f36 = f37;
                        } else if (!zIsNaN24) {
                            f36 = f38;
                        }
                        resolvedStyle.heightFraction = f36;
                        float f39 = resolvedStyle.minWidth;
                        float f40 = resolvedStyle2.minWidth;
                        boolean zIsNaN25 = Float.isNaN(f39);
                        boolean zIsNaN26 = Float.isNaN(f40);
                        float f41 = (fFloatValue * f40) + (f4 * f39);
                        if (zIsNaN25) {
                            f39 = f40;
                        } else if (!zIsNaN26) {
                            f39 = f41;
                        }
                        resolvedStyle.minWidth = f39;
                        float f42 = resolvedStyle.maxWidth;
                        float f43 = resolvedStyle2.maxWidth;
                        boolean zIsNaN27 = Float.isNaN(f42);
                        boolean zIsNaN28 = Float.isNaN(f43);
                        float f44 = (fFloatValue * f43) + (f4 * f42);
                        if (zIsNaN27) {
                            f42 = f43;
                        } else if (!zIsNaN28) {
                            f42 = f44;
                        }
                        resolvedStyle.maxWidth = f42;
                        float f45 = resolvedStyle.minHeight;
                        float f46 = resolvedStyle2.minHeight;
                        boolean zIsNaN29 = Float.isNaN(f45);
                        boolean zIsNaN30 = Float.isNaN(f46);
                        float f47 = (fFloatValue * f46) + (f4 * f45);
                        if (zIsNaN29) {
                            f45 = f46;
                        } else if (!zIsNaN30) {
                            f45 = f47;
                        }
                        resolvedStyle.minHeight = f45;
                        float f48 = resolvedStyle.maxHeight;
                        float f49 = resolvedStyle2.maxHeight;
                        boolean zIsNaN31 = Float.isNaN(f48);
                        boolean zIsNaN32 = Float.isNaN(f49);
                        float f50 = (fFloatValue * f49) + (f4 * f48);
                        if (zIsNaN31) {
                            f48 = f49;
                        } else if (!zIsNaN32) {
                            f48 = f50;
                        }
                        resolvedStyle.maxHeight = f48;
                    }
                    if ((i5 & 1) != 0) {
                        resolvedStyle.contentPaddingStart = MathHelpersKt.lerp(resolvedStyle.contentPaddingStart, resolvedStyle2.contentPaddingStart, fFloatValue);
                        resolvedStyle.contentPaddingEnd = MathHelpersKt.lerp(resolvedStyle.contentPaddingEnd, resolvedStyle2.contentPaddingEnd, fFloatValue);
                        resolvedStyle.contentPaddingTop = MathHelpersKt.lerp(resolvedStyle.contentPaddingTop, resolvedStyle2.contentPaddingTop, fFloatValue);
                        resolvedStyle.contentPaddingBottom = MathHelpersKt.lerp(resolvedStyle.contentPaddingBottom, resolvedStyle2.contentPaddingBottom, fFloatValue);
                    }
                    if ((i5 & 2) != 0) {
                        resolvedStyle.borderWidth = MathHelpersKt.lerp(resolvedStyle.borderWidth, resolvedStyle2.borderWidth, fFloatValue);
                        long jM419lerpjxsXWHM = BrushKt.m419lerpjxsXWHM(resolvedStyle.borderColor, resolvedStyle2.borderColor, fFloatValue);
                        resolvedStyle.borderColor = jM419lerpjxsXWHM;
                        f = fFloatValue;
                        resolvedStyle.borderBrush = ResolvedStyleKt.m164lerpwffgcV4(resolvedStyle.borderBrush, jM419lerpjxsXWHM, resolvedStyle2.borderBrush, resolvedStyle2.borderColor, fFloatValue);
                        long jM419lerpjxsXWHM2 = BrushKt.m419lerpjxsXWHM(resolvedStyle.backgroundColor, resolvedStyle2.backgroundColor, f);
                        resolvedStyle.backgroundColor = jM419lerpjxsXWHM2;
                        resolvedStyle.backgroundBrush = ResolvedStyleKt.m164lerpwffgcV4(resolvedStyle.backgroundBrush, jM419lerpjxsXWHM2, resolvedStyle2.backgroundBrush, resolvedStyle2.backgroundColor, fFloatValue);
                        Brush brush = resolvedStyle.foregroundBrush;
                        long j = Color.Unspecified;
                        resolvedStyle.foregroundBrush = ResolvedStyleKt.m164lerpwffgcV4(brush, j, resolvedStyle2.foregroundBrush, j, fFloatValue);
                        resolvedStyle.innerShadow = ResolvedStyleKt.lerpShadows(f, resolvedStyle.innerShadow, resolvedStyle2.innerShadow);
                        resolvedStyle.dropShadow = ResolvedStyleKt.lerpShadows(f, resolvedStyle.dropShadow, resolvedStyle2.dropShadow);
                    } else {
                        f = fFloatValue;
                    }
                    if ((i5 & 4) != 0) {
                        resolvedStyle.alpha = MathHelpersKt.lerp(resolvedStyle.alpha, resolvedStyle2.alpha, f);
                        resolvedStyle.scaleX = MathHelpersKt.lerp(resolvedStyle.scaleX, resolvedStyle2.scaleX, f);
                        resolvedStyle.scaleY = MathHelpersKt.lerp(resolvedStyle.scaleY, resolvedStyle2.scaleY, f);
                        resolvedStyle.translationX = MathHelpersKt.lerp(resolvedStyle.translationX, resolvedStyle2.translationX, f);
                        resolvedStyle.translationY = MathHelpersKt.lerp(resolvedStyle.translationY, resolvedStyle2.translationY, f);
                        resolvedStyle.rotationX = MathHelpersKt.lerp(resolvedStyle.rotationX, resolvedStyle2.rotationX, f);
                        resolvedStyle.rotationY = MathHelpersKt.lerp(resolvedStyle.rotationY, resolvedStyle2.rotationY, f);
                        resolvedStyle.rotationZ = MathHelpersKt.lerp(resolvedStyle.rotationZ, resolvedStyle2.rotationZ, f);
                        resolvedStyle.transformOrigin = BrushKt.TransformOrigin(MathHelpersKt.lerp(TransformOrigin.m452getPivotFractionXimpl(resolvedStyle.transformOrigin), TransformOrigin.m452getPivotFractionXimpl(resolvedStyle2.transformOrigin), f), MathHelpersKt.lerp(TransformOrigin.m453getPivotFractionYimpl(resolvedStyle.transformOrigin), TransformOrigin.m453getPivotFractionYimpl(resolvedStyle2.transformOrigin), f));
                        resolvedStyle.zIndex = MathHelpersKt.lerp(resolvedStyle.zIndex, resolvedStyle2.zIndex, f);
                        Object obj = resolvedStyle.shape;
                        Shape shape = resolvedStyle2.shape;
                        if (!Intrinsics.areEqual(obj, shape)) {
                            Object objLerp = obj instanceof Interpolatable ? ((Interpolatable) obj).lerp(shape, f) : null;
                            if (objLerp == null && (shape instanceof Interpolatable)) {
                                objLerp = ((Interpolatable) shape).lerp(obj, 1 - f);
                            }
                            if (objLerp != null) {
                                obj = objLerp;
                            } else if (f >= 0.5f) {
                                obj = shape;
                            }
                        } else if (f >= 0.5f) {
                            obj = shape;
                        }
                        Shape shape2 = obj instanceof Shape ? (Shape) obj : null;
                        if (shape2 == null) {
                            shape2 = BrushKt.RectangleShape;
                        }
                        resolvedStyle.shape = shape2;
                        resolvedStyle.clip = f < 0.5f ? resolvedStyle.clip : resolvedStyle2.clip;
                    }
                    if ((i5 & 64) != 0) {
                        long jM419lerpjxsXWHM3 = BrushKt.m419lerpjxsXWHM(resolvedStyle.contentColor, resolvedStyle2.contentColor, f);
                        resolvedStyle.contentColor = jM419lerpjxsXWHM3;
                        resolvedStyle.contentBrush = ResolvedStyleKt.m164lerpwffgcV4(resolvedStyle.contentBrush, jM419lerpjxsXWHM3, resolvedStyle2.contentBrush, resolvedStyle2.contentColor, f);
                    }
                    if ((i5 & 32) != 0) {
                        long j2 = resolvedStyle.fontSize;
                        TextUnitType[] textUnitTypeArr = TextUnit.TextUnitTypes;
                        if ((j2 & 1095216660480L) != 0) {
                            long j3 = resolvedStyle2.fontSize;
                            if ((j3 & 1095216660480L) != 0) {
                                resolvedStyle.fontSize = TextUnitKt.m730lerpC3pnCVY(j2, j3, f);
                            }
                        }
                        long j4 = resolvedStyle.lineHeight;
                        if ((j4 & 1095216660480L) != 0) {
                            long j5 = resolvedStyle2.lineHeight;
                            if ((j5 & 1095216660480L) != 0) {
                                resolvedStyle.lineHeight = TextUnitKt.m730lerpC3pnCVY(j4, j5, f);
                            }
                        }
                        long j6 = resolvedStyle.letterSpacing;
                        if ((j6 & 1095216660480L) != 0) {
                            long j7 = resolvedStyle2.letterSpacing;
                            if ((1095216660480L & j7) != 0) {
                                resolvedStyle.letterSpacing = TextUnitKt.m730lerpC3pnCVY(j6, j7, f);
                            }
                        }
                        resolvedStyle.fontFamily = f < 1056964608 ? resolvedStyle.fontFamily : resolvedStyle2.fontFamily;
                        resolvedStyle.textIndent = f < 1056964608 ? resolvedStyle.textIndent : resolvedStyle2.textIndent;
                        resolvedStyle.baselineShift = f < 1056964608 ? resolvedStyle.baselineShift : resolvedStyle2.baselineShift;
                        resolvedStyle.lineBreak = f < 1056964608 ? resolvedStyle.lineBreak : resolvedStyle2.lineBreak;
                        int i6 = f < 1056964608 ? resolvedStyle.textEnums : resolvedStyle2.textEnums;
                        resolvedStyle.textEnums = i6;
                        int i7 = (i6 & 134086656) >> 17;
                        int i8 = (resolvedStyle2.textEnums & 134086656) >> 17;
                        if (i7 > 0 && i8 > 0) {
                            resolvedStyle.textEnums = ((((MathHelpersKt.lerp(f, i7, i8) / 100) * 100) << 17) & 134086656) | (resolvedStyle.textEnums & (-134086657));
                        }
                    }
                }
                i3++;
                i2 = i2;
                entryArr = entryArr;
            }
            entryArr = entryArr;
            i2 = i2;
            i3++;
            i2 = i2;
            entryArr = entryArr;
        }
    }
}
