package androidx.compose.material3;

import androidx.camera.camera2.internal.ZslControlImpl$$ExternalSyntheticLambda0;
import androidx.collection.MutableIntList;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.style.BooleanPredefinedKey;
import androidx.compose.foundation.style.MutableStyleState;
import androidx.compose.foundation.style.ResolvedStyle;
import androidx.compose.foundation.style.ResolvedStyleKt;
import androidx.compose.foundation.style.Style;
import androidx.compose.foundation.style.StyleAnimations;
import androidx.compose.foundation.style.StyleAnimations.Entry;
import androidx.compose.foundation.style.StyleElement;
import androidx.compose.foundation.style.StyleInnerElement;
import androidx.compose.foundation.style.StyleOuterNode;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TransformedText;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class OutlinedTextFieldDefaults {
    public static final OutlinedTextFieldDefaults INSTANCE = new OutlinedTextFieldDefaults();
    public static final float MinHeight = 56;
    public static final float MinWidth = 280;
    public static final float UnfocusedBorderThickness = 1;
    public static final float FocusedBorderThickness = 2;

    /* JADX INFO: renamed from: colors-0hiis_0, reason: not valid java name */
    public static TextFieldColors m252colors0hiis_0(long j, long j2, long j3, long j4, long j5, GapComposer gapComposer) {
        TextFieldColors textFieldColors;
        TextFieldColors textFieldColors2;
        long j6 = Color.Unspecified;
        ColorScheme colorScheme = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme;
        TextFieldColors textFieldColorsM272copyejIjP34 = colorScheme.defaultOutlinedTextFieldColorsCached;
        boolean z = false;
        if (textFieldColorsM272copyejIjP34 == null) {
            gapComposer.startReplaceGroup(390452338);
            gapComposer.end(false);
            textFieldColors = null;
        } else {
            gapComposer.startReplaceGroup(390452339);
            TextSelectionColors textSelectionColors = (TextSelectionColors) gapComposer.consume(TextSelectionColorsKt.LocalTextSelectionColors);
            if (!Intrinsics.areEqual(textFieldColorsM272copyejIjP34.textSelectionColors, textSelectionColors)) {
                textFieldColorsM272copyejIjP34 = textFieldColorsM272copyejIjP34.m272copyejIjP34(textFieldColorsM272copyejIjP34.focusedTextColor, textFieldColorsM272copyejIjP34.unfocusedTextColor, textFieldColorsM272copyejIjP34.disabledTextColor, textFieldColorsM272copyejIjP34.errorTextColor, textFieldColorsM272copyejIjP34.focusedContainerColor, textFieldColorsM272copyejIjP34.unfocusedContainerColor, textFieldColorsM272copyejIjP34.disabledContainerColor, textFieldColorsM272copyejIjP34.errorContainerColor, textFieldColorsM272copyejIjP34.cursorColor, textFieldColorsM272copyejIjP34.errorCursorColor, textSelectionColors, textFieldColorsM272copyejIjP34.focusedIndicatorColor, textFieldColorsM272copyejIjP34.unfocusedIndicatorColor, textFieldColorsM272copyejIjP34.disabledIndicatorColor, textFieldColorsM272copyejIjP34.errorIndicatorColor, textFieldColorsM272copyejIjP34.focusedLeadingIconColor, textFieldColorsM272copyejIjP34.unfocusedLeadingIconColor, textFieldColorsM272copyejIjP34.disabledLeadingIconColor, textFieldColorsM272copyejIjP34.errorLeadingIconColor, textFieldColorsM272copyejIjP34.focusedTrailingIconColor, textFieldColorsM272copyejIjP34.unfocusedTrailingIconColor, textFieldColorsM272copyejIjP34.disabledTrailingIconColor, textFieldColorsM272copyejIjP34.errorTrailingIconColor, textFieldColorsM272copyejIjP34.focusedLabelColor, textFieldColorsM272copyejIjP34.unfocusedLabelColor, textFieldColorsM272copyejIjP34.disabledLabelColor, textFieldColorsM272copyejIjP34.errorLabelColor, textFieldColorsM272copyejIjP34.focusedPlaceholderColor, textFieldColorsM272copyejIjP34.unfocusedPlaceholderColor, textFieldColorsM272copyejIjP34.disabledPlaceholderColor, textFieldColorsM272copyejIjP34.errorPlaceholderColor, textFieldColorsM272copyejIjP34.focusedSupportingTextColor, textFieldColorsM272copyejIjP34.unfocusedSupportingTextColor, textFieldColorsM272copyejIjP34.disabledSupportingTextColor, textFieldColorsM272copyejIjP34.errorSupportingTextColor, textFieldColorsM272copyejIjP34.focusedPrefixColor, textFieldColorsM272copyejIjP34.unfocusedPrefixColor, textFieldColorsM272copyejIjP34.disabledPrefixColor, textFieldColorsM272copyejIjP34.errorPrefixColor, textFieldColorsM272copyejIjP34.focusedSuffixColor, textFieldColorsM272copyejIjP34.unfocusedSuffixColor, textFieldColorsM272copyejIjP34.disabledSuffixColor, textFieldColorsM272copyejIjP34.errorSuffixColor);
                colorScheme.defaultOutlinedTextFieldColorsCached = textFieldColorsM272copyejIjP34;
                z = false;
            }
            gapComposer.end(z);
            textFieldColors = textFieldColorsM272copyejIjP34;
        }
        if (textFieldColors == null) {
            gapComposer.startReplaceGroup(-1788321191);
            long jFromToken = ColorSchemeKt.fromToken(colorScheme, 18);
            long jFromToken2 = ColorSchemeKt.fromToken(colorScheme, 18);
            long jFromToken3 = ColorSchemeKt.fromToken(colorScheme, 18);
            long jColor = BrushKt.Color(Color.m440getRedimpl(jFromToken3), Color.m439getGreenimpl(jFromToken3), Color.m437getBlueimpl(jFromToken3), 0.38f, Color.m438getColorSpaceimpl(jFromToken3));
            long jFromToken4 = ColorSchemeKt.fromToken(colorScheme, 18);
            long j7 = Color.Transparent;
            long jFromToken5 = ColorSchemeKt.fromToken(colorScheme, 26);
            long jFromToken6 = ColorSchemeKt.fromToken(colorScheme, 2);
            TextSelectionColors textSelectionColors2 = (TextSelectionColors) gapComposer.consume(TextSelectionColorsKt.LocalTextSelectionColors);
            long jFromToken7 = ColorSchemeKt.fromToken(colorScheme, 26);
            long jFromToken8 = ColorSchemeKt.fromToken(colorScheme, 24);
            long jFromToken9 = ColorSchemeKt.fromToken(colorScheme, 18);
            long jColor2 = BrushKt.Color(Color.m440getRedimpl(jFromToken9), Color.m439getGreenimpl(jFromToken9), Color.m437getBlueimpl(jFromToken9), 0.12f, Color.m438getColorSpaceimpl(jFromToken9));
            long jFromToken10 = ColorSchemeKt.fromToken(colorScheme, 2);
            long jFromToken11 = ColorSchemeKt.fromToken(colorScheme, 19);
            long jFromToken12 = ColorSchemeKt.fromToken(colorScheme, 19);
            long jFromToken13 = ColorSchemeKt.fromToken(colorScheme, 18);
            long jColor3 = BrushKt.Color(Color.m440getRedimpl(jFromToken13), Color.m439getGreenimpl(jFromToken13), Color.m437getBlueimpl(jFromToken13), 0.38f, Color.m438getColorSpaceimpl(jFromToken13));
            long jFromToken14 = ColorSchemeKt.fromToken(colorScheme, 19);
            long jFromToken15 = ColorSchemeKt.fromToken(colorScheme, 19);
            long jFromToken16 = ColorSchemeKt.fromToken(colorScheme, 19);
            long jFromToken17 = ColorSchemeKt.fromToken(colorScheme, 18);
            long jColor4 = BrushKt.Color(Color.m440getRedimpl(jFromToken17), Color.m439getGreenimpl(jFromToken17), Color.m437getBlueimpl(jFromToken17), 0.38f, Color.m438getColorSpaceimpl(jFromToken17));
            long jFromToken18 = ColorSchemeKt.fromToken(colorScheme, 2);
            long jFromToken19 = ColorSchemeKt.fromToken(colorScheme, 26);
            long jFromToken20 = ColorSchemeKt.fromToken(colorScheme, 19);
            long jFromToken21 = ColorSchemeKt.fromToken(colorScheme, 18);
            long jColor5 = BrushKt.Color(Color.m440getRedimpl(jFromToken21), Color.m439getGreenimpl(jFromToken21), Color.m437getBlueimpl(jFromToken21), 0.38f, Color.m438getColorSpaceimpl(jFromToken21));
            long jFromToken22 = ColorSchemeKt.fromToken(colorScheme, 2);
            long jFromToken23 = ColorSchemeKt.fromToken(colorScheme, 19);
            long jFromToken24 = ColorSchemeKt.fromToken(colorScheme, 19);
            long jFromToken25 = ColorSchemeKt.fromToken(colorScheme, 18);
            long jColor6 = BrushKt.Color(Color.m440getRedimpl(jFromToken25), Color.m439getGreenimpl(jFromToken25), Color.m437getBlueimpl(jFromToken25), 0.38f, Color.m438getColorSpaceimpl(jFromToken25));
            long jFromToken26 = ColorSchemeKt.fromToken(colorScheme, 19);
            long jFromToken27 = ColorSchemeKt.fromToken(colorScheme, 19);
            long jFromToken28 = ColorSchemeKt.fromToken(colorScheme, 19);
            long jFromToken29 = ColorSchemeKt.fromToken(colorScheme, 18);
            long jColor7 = BrushKt.Color(Color.m440getRedimpl(jFromToken29), Color.m439getGreenimpl(jFromToken29), Color.m437getBlueimpl(jFromToken29), 0.38f, Color.m438getColorSpaceimpl(jFromToken29));
            long jFromToken30 = ColorSchemeKt.fromToken(colorScheme, 2);
            long jFromToken31 = ColorSchemeKt.fromToken(colorScheme, 19);
            long jFromToken32 = ColorSchemeKt.fromToken(colorScheme, 19);
            long jFromToken33 = ColorSchemeKt.fromToken(colorScheme, 19);
            long jColor8 = BrushKt.Color(Color.m440getRedimpl(jFromToken33), Color.m439getGreenimpl(jFromToken33), Color.m437getBlueimpl(jFromToken33), 0.38f, Color.m438getColorSpaceimpl(jFromToken33));
            long jFromToken34 = ColorSchemeKt.fromToken(colorScheme, 19);
            long jFromToken35 = ColorSchemeKt.fromToken(colorScheme, 19);
            long jFromToken36 = ColorSchemeKt.fromToken(colorScheme, 19);
            long jFromToken37 = ColorSchemeKt.fromToken(colorScheme, 19);
            TextFieldColors textFieldColors3 = new TextFieldColors(jFromToken, jFromToken2, jColor, jFromToken4, j7, j7, j7, j7, jFromToken5, jFromToken6, textSelectionColors2, jFromToken7, jFromToken8, jColor2, jFromToken10, jFromToken11, jFromToken12, jColor3, jFromToken14, jFromToken15, jFromToken16, jColor4, jFromToken18, jFromToken19, jFromToken20, jColor5, jFromToken22, jFromToken23, jFromToken24, jColor6, jFromToken26, jFromToken27, jFromToken28, jColor7, jFromToken30, jFromToken31, jFromToken32, jColor8, jFromToken34, jFromToken35, jFromToken36, BrushKt.Color(Color.m440getRedimpl(jFromToken37), Color.m439getGreenimpl(jFromToken37), Color.m437getBlueimpl(jFromToken37), 0.38f, Color.m438getColorSpaceimpl(jFromToken37)), ColorSchemeKt.fromToken(colorScheme, 19));
            colorScheme.defaultOutlinedTextFieldColorsCached = textFieldColors3;
            gapComposer.end(false);
            textFieldColors2 = textFieldColors3;
        } else {
            gapComposer.startReplaceGroup(-1788515437);
            gapComposer.end(false);
            textFieldColors2 = textFieldColors;
        }
        return textFieldColors2.m272copyejIjP34(j, j2, j6, j6, j6, j6, j6, j6, j3, j6, null, j4, j5, j6, j6, j6, j6, j6, j6, j6, j6, j6, j6, j6, j6, j6, j6, j6, j6, j6, j6, j6, j6, j6, j6, j6, j6, j6, j6, j6, j6, j6, j6);
    }

    /* JADX WARN: Code duplicated, block: B:109:0x0164  */
    /* JADX WARN: Code duplicated, block: B:110:0x0167  */
    /* JADX WARN: Code duplicated, block: B:113:0x0172  */
    /* JADX WARN: Code duplicated, block: B:114:0x0175  */
    /* JADX WARN: Code duplicated, block: B:136:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:139:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:140:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:143:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:146:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:148:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:27:0x0059  */
    /* JADX WARN: Code duplicated, block: B:28:0x005c  */
    /* JADX WARN: Code duplicated, block: B:31:0x0065  */
    /* JADX WARN: Code duplicated, block: B:32:0x0068  */
    /* JADX WARN: Code duplicated, block: B:35:0x0073  */
    /* JADX WARN: Code duplicated, block: B:40:0x0082  */
    /* JADX WARN: Code duplicated, block: B:42:0x0087  */
    /* JADX WARN: Code duplicated, block: B:45:0x008f  */
    /* JADX WARN: Code duplicated, block: B:47:0x0093  */
    /* JADX WARN: Code duplicated, block: B:49:0x009b  */
    /* JADX WARN: Code duplicated, block: B:50:0x009e  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:56:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:57:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:60:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:72:0x00e6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:73:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:74:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:77:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:78:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:81:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:85:0x010a  */
    /* JADX WARN: Code duplicated, block: B:86:0x010d  */
    /* JADX WARN: Code duplicated, block: B:90:0x0118  */
    /* JADX INFO: renamed from: Container-4EFweAY, reason: not valid java name */
    public final void m253Container4EFweAY(final boolean z, final boolean z2, final MutableInteractionSourceImpl mutableInteractionSourceImpl, Modifier modifier, final TextFieldColors textFieldColors, final Shape shape, float f, float f2, GapComposer gapComposer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        int i4;
        int i5;
        float f3;
        float f4;
        boolean z3;
        boolean z4;
        final float f5;
        final float f6;
        final Modifier modifier3;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        Modifier modifier4;
        float f7;
        final float f8;
        final float f9;
        boolean z5;
        Object objRememberedValue;
        MutableStyleState mutableStyleState;
        final FiniteAnimationSpec finiteAnimationSpecValue;
        boolean z6;
        boolean z7;
        boolean z8;
        Object objRememberedValue2;
        int i6;
        Style style;
        Modifier modifierThen;
        int i7;
        gapComposer.startRestartGroup(1035477640);
        int i8 = (gapComposer.changed(z) ? 4 : 2) | i | (gapComposer.changed(z2) ? 32 : 16) | (gapComposer.changed(mutableInteractionSourceImpl) ? 256 : 128);
        int i9 = i2 & 8;
        if (i9 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i8 |= gapComposer.changed(modifier2) ? 2048 : 1024;
            }
            if (gapComposer.changed(textFieldColors)) {
                i3 = 16384;
            } else {
                i3 = 8192;
            }
            int i10 = i8 | i3;
            if (gapComposer.changed(shape)) {
                i4 = 131072;
            } else {
                i4 = 65536;
            }
            i5 = i10 | i4;
            if ((i & 1572864) == 0) {
                f3 = f;
                if ((i2 & 64) == 0 || !gapComposer.changed(f3)) {
                    i7 = 524288;
                } else {
                    i7 = 1048576;
                }
                i5 |= i7;
            } else {
                f3 = f;
            }
            if ((i & 12582912) == 0) {
                if ((i2 & 128) == 0) {
                    f4 = f2;
                    int i11 = gapComposer.changed(f4) ? 8388608 : 4194304;
                    i5 |= i11;
                } else {
                    f4 = f2;
                }
                i5 |= i11;
            } else {
                f4 = f2;
            }
            z3 = true;
            if ((i5 & 38347923) != 38347922) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (gapComposer.shouldExecute(i5 & 1, z4)) {
                gapComposer.startDefaults();
                if ((i & 1) != 0 || gapComposer.getDefaultsInvalid()) {
                    if (i9 != 0) {
                        modifier4 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if ((i2 & 64) != 0) {
                        i5 &= -3670017;
                        f7 = FocusedBorderThickness;
                    } else {
                        f7 = f3;
                    }
                    if ((i2 & 128) != 0) {
                        i5 &= -29360129;
                        f4 = UnfocusedBorderThickness;
                    }
                    modifier2 = modifier4;
                    f8 = f4;
                    f9 = f7;
                } else {
                    gapComposer.skipToGroupEnd();
                    if ((i2 & 64) != 0) {
                        i5 &= -3670017;
                    }
                    if ((i2 & 128) != 0) {
                        i5 &= -29360129;
                    }
                    f8 = f4;
                    f9 = f3;
                }
                gapComposer.endDefaults();
                if ((i5 & 896) == 256) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                objRememberedValue = gapComposer.rememberedValue();
                Object obj = Composer$Companion.Empty;
                if (z5 || objRememberedValue == obj) {
                    objRememberedValue = new MutableStyleState(mutableInteractionSourceImpl);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                mutableStyleState = (MutableStyleState) objRememberedValue;
                finiteAnimationSpecValue = ScrimKt.value(5, gapComposer);
                boolean z9 = ((((i5 & 458752) ^ 196608) <= 131072 && gapComposer.changed(shape)) || (i5 & 196608) == 131072) | ((((57344 & i5) ^ 24576) <= 16384 && gapComposer.changed(textFieldColors)) || (i5 & 24576) == 16384);
                if ((i5 & 14) == 4) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                boolean z10 = z9 | z6;
                if ((i5 & 112) == 32) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                boolean zChangedInstance = z10 | z7 | ((((29360128 & i5) ^ 12582912) <= 8388608 && gapComposer.changed(f8)) || (i5 & 12582912) == 8388608) | gapComposer.changedInstance(finiteAnimationSpecValue);
                if ((((3670016 & i5) ^ 1572864) > 1048576 || !gapComposer.changed(f9)) && (i5 & 1572864) != 1048576) {
                }
                z8 = zChangedInstance | z3;
                objRememberedValue2 = gapComposer.rememberedValue();
                if (!z8 || objRememberedValue2 == obj) {
                    i6 = 0;
                    Object obj2 = new Style() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda2
                        @Override // androidx.compose.foundation.style.Style
                        public final void applyStyle(ResolvedStyle resolvedStyle) {
                            long j;
                            long j2;
                            int i12 = resolvedStyle.flags;
                            resolvedStyle.flags = i12 | 6;
                            resolvedStyle.shape = shape;
                            final TextFieldColors textFieldColors2 = textFieldColors;
                            final boolean z11 = z;
                            final boolean z12 = z2;
                            if (z11) {
                                j = z12 ? textFieldColors2.errorContainerColor : textFieldColors2.unfocusedContainerColor;
                            } else {
                                j = textFieldColors2.disabledContainerColor;
                            }
                            resolvedStyle.flags = i12 | 6;
                            resolvedStyle.backgroundColor = j;
                            resolvedStyle.backgroundBrush = null;
                            if (z11) {
                                j2 = z12 ? textFieldColors2.errorIndicatorColor : textFieldColors2.unfocusedIndicatorColor;
                            } else {
                                j2 = textFieldColors2.disabledIndicatorColor;
                            }
                            resolvedStyle.m159bordercXLIe8U(f8, j2);
                            final FiniteAnimationSpec finiteAnimationSpec = finiteAnimationSpecValue;
                            final float f10 = f9;
                            Style style2 = new Style() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda0
                                /* JADX WARN: Type inference failed for: r3v0, types: [androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda1] */
                                @Override // androidx.compose.foundation.style.Style
                                public final void applyStyle(ResolvedStyle resolvedStyle2) {
                                    StyleAnimations.Entry entry;
                                    final TextFieldColors textFieldColors3 = textFieldColors2;
                                    final boolean z13 = z11;
                                    final boolean z14 = z12;
                                    final float f11 = f10;
                                    ?? r3 = new Style() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda1
                                        @Override // androidx.compose.foundation.style.Style
                                        public final void applyStyle(ResolvedStyle resolvedStyle3) {
                                            long j3;
                                            long j4;
                                            TextFieldColors textFieldColors4 = textFieldColors3;
                                            boolean z15 = z13;
                                            boolean z16 = z14;
                                            if (z15) {
                                                j3 = z16 ? textFieldColors4.errorContainerColor : textFieldColors4.focusedContainerColor;
                                            } else {
                                                j3 = textFieldColors4.disabledContainerColor;
                                            }
                                            resolvedStyle3.flags |= 2;
                                            resolvedStyle3.backgroundColor = j3;
                                            resolvedStyle3.backgroundBrush = null;
                                            if (z15) {
                                                j4 = z16 ? textFieldColors4.errorIndicatorColor : textFieldColors4.focusedIndicatorColor;
                                            } else {
                                                j4 = textFieldColors4.disabledIndicatorColor;
                                            }
                                            resolvedStyle3.m159bordercXLIe8U(f11, j4);
                                        }
                                    };
                                    resolvedStyle2.flags |= 16;
                                    int i13 = resolvedStyle2.currentIndex;
                                    int i14 = i13 ^ 1318433304;
                                    int i15 = resolvedStyle2.compositeHash;
                                    ResolvedStyle resolvedStyle3 = ResolvedStyleKt.EmptyResolvedStyle;
                                    resolvedStyle2.compositeHash = Integer.rotateLeft(i15, 3) ^ i14;
                                    MutableIntList mutableIntList = resolvedStyle2.indexStack;
                                    if (mutableIntList == null) {
                                        mutableIntList = new MutableIntList();
                                        resolvedStyle2.indexStack = mutableIntList;
                                    }
                                    MutableIntList mutableIntList2 = mutableIntList;
                                    mutableIntList2.add(i13);
                                    int i16 = 0;
                                    resolvedStyle2.currentIndex = 0;
                                    if (resolvedStyle2.animating) {
                                        r3.applyStyle(resolvedStyle2);
                                    } else {
                                        StyleOuterNode styleOuterNode = resolvedStyle2.node;
                                        StyleAnimations styleAnimations = styleOuterNode.animations;
                                        if (styleAnimations == null) {
                                            styleAnimations = new StyleAnimations(styleOuterNode);
                                            styleOuterNode.animations = styleAnimations;
                                        }
                                        StyleAnimations styleAnimations2 = styleAnimations;
                                        int i17 = resolvedStyle2.compositeHash ^ resolvedStyle2.currentIndex;
                                        StyleAnimations.Entry[] entryArr = styleAnimations2.values;
                                        int i18 = styleAnimations2.size;
                                        while (true) {
                                            if (i16 < i18) {
                                                entry = entryArr[i16];
                                                if (entry != null && entry.key == i17) {
                                                    break;
                                                } else {
                                                    i16++;
                                                }
                                            } else {
                                                entry = null;
                                                break;
                                            }
                                        }
                                        if (entry != null) {
                                            entry.style = r3;
                                            int i19 = entry.state;
                                            if (i19 == 1) {
                                                entry.state = 2;
                                            } else if (i19 == 4) {
                                                entry.state = 3;
                                            }
                                        } else {
                                            int i20 = styleAnimations2.size + 1;
                                            StyleAnimations.Entry[] entryArr2 = styleAnimations2.values;
                                            int length = entryArr2.length;
                                            if (i20 > length) {
                                                styleAnimations2.values = (StyleAnimations.Entry[]) Arrays.copyOf(entryArr2, Math.max(length * 2, 2));
                                            }
                                            int i21 = styleAnimations2.size;
                                            StyleAnimations.Entry[] entryArr3 = styleAnimations2.values;
                                            FiniteAnimationSpec finiteAnimationSpec2 = finiteAnimationSpec;
                                            entryArr3[i21] = styleAnimations2.new Entry(i17, r3, finiteAnimationSpec2, finiteAnimationSpec2);
                                            styleAnimations2.size++;
                                        }
                                    }
                                    resolvedStyle2.currentIndex = mutableIntList2.removeAt(mutableIntList2._size - 1) + 1;
                                    resolvedStyle2.compositeHash = Integer.rotateRight(resolvedStyle2.compositeHash ^ i14, 3);
                                }
                            };
                            int iHashCode = BooleanPredefinedKey.Focused.hashCode();
                            if ((resolvedStyle.node._state.predefinedState$delegate.getIntValue() & 4) == 0) {
                                resolvedStyle.currentIndex++;
                                return;
                            }
                            int i13 = resolvedStyle.currentIndex;
                            int i14 = iHashCode ^ i13;
                            int i15 = resolvedStyle.compositeHash;
                            ResolvedStyle resolvedStyle2 = ResolvedStyleKt.EmptyResolvedStyle;
                            resolvedStyle.compositeHash = Integer.rotateLeft(i15, 3) ^ i14;
                            MutableIntList mutableIntList = resolvedStyle.indexStack;
                            if (mutableIntList == null) {
                                mutableIntList = new MutableIntList();
                                resolvedStyle.indexStack = mutableIntList;
                            }
                            mutableIntList.add(i13);
                            resolvedStyle.currentIndex = 0;
                            style2.applyStyle(resolvedStyle);
                            resolvedStyle.currentIndex = mutableIntList.removeAt(mutableIntList._size - 1) + 1;
                            resolvedStyle.compositeHash = Integer.rotateRight(i14 ^ resolvedStyle.compositeHash, 3);
                        }
                    };
                    gapComposer.updateRememberedValue(obj2);
                    objRememberedValue2 = obj2;
                } else {
                    i6 = 0;
                }
                style = (Style) objRememberedValue2;
                if (style == Style.Companion.$$INSTANCE) {
                    modifierThen = modifier2;
                } else {
                    modifierThen = modifier2.then(new StyleElement(mutableStyleState, style)).then(StyleInnerElement.INSTANCE);
                }
                BoxKt.Box(modifierThen, gapComposer, i6);
                f5 = f8;
                f6 = f9;
            } else {
                gapComposer.skipToGroupEnd();
                f5 = f4;
                f6 = f3;
            }
            modifier3 = modifier2;
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj3, Object obj4) {
                        ((Integer) obj4).getClass();
                        this.f$0.m253Container4EFweAY(z, z2, mutableInteractionSourceImpl, modifier3, textFieldColors, shape, f6, f5, (GapComposer) obj3, Stack.updateChangedFlags(i | 1), i2);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i8 |= 3072;
        modifier2 = modifier;
        if (gapComposer.changed(textFieldColors)) {
            i3 = 16384;
        } else {
            i3 = 8192;
        }
        int i12 = i8 | i3;
        if (gapComposer.changed(shape)) {
            i4 = 131072;
        } else {
            i4 = 65536;
        }
        i5 = i12 | i4;
        if ((i & 1572864) == 0) {
            f3 = f;
            if ((i2 & 64) == 0) {
                i7 = 524288;
            } else {
                i7 = 524288;
            }
            i5 |= i7;
        } else {
            f3 = f;
        }
        if ((i & 12582912) == 0) {
            if ((i2 & 128) == 0) {
                f4 = f2;
                if (gapComposer.changed(f4)) {
                }
                i5 |= i11;
            } else {
                f4 = f2;
            }
            i5 |= i11;
        } else {
            f4 = f2;
        }
        z3 = true;
        if ((i5 & 38347923) != 38347922) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (gapComposer.shouldExecute(i5 & 1, z4)) {
            gapComposer.startDefaults();
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    modifier4 = Modifier.Companion.$$INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if ((i2 & 64) != 0) {
                    i5 &= -3670017;
                    f7 = FocusedBorderThickness;
                } else {
                    f7 = f3;
                }
                if ((i2 & 128) != 0) {
                    i5 &= -29360129;
                    f4 = UnfocusedBorderThickness;
                }
                modifier2 = modifier4;
                f8 = f4;
                f9 = f7;
            } else {
                if (i9 != 0) {
                    modifier4 = Modifier.Companion.$$INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if ((i2 & 64) != 0) {
                    i5 &= -3670017;
                    f7 = FocusedBorderThickness;
                } else {
                    f7 = f3;
                }
                if ((i2 & 128) != 0) {
                    i5 &= -29360129;
                    f4 = UnfocusedBorderThickness;
                }
                modifier2 = modifier4;
                f8 = f4;
                f9 = f7;
            }
            gapComposer.endDefaults();
            if ((i5 & 896) == 256) {
                z5 = true;
            } else {
                z5 = false;
            }
            objRememberedValue = gapComposer.rememberedValue();
            Object obj3 = Composer$Companion.Empty;
            if (z5) {
                objRememberedValue = new MutableStyleState(mutableInteractionSourceImpl);
                gapComposer.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new MutableStyleState(mutableInteractionSourceImpl);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            mutableStyleState = (MutableStyleState) objRememberedValue;
            finiteAnimationSpecValue = ScrimKt.value(5, gapComposer);
            boolean z11 = ((((i5 & 458752) ^ 196608) <= 131072 && gapComposer.changed(shape)) || (i5 & 196608) == 131072) | ((((57344 & i5) ^ 24576) <= 16384 && gapComposer.changed(textFieldColors)) || (i5 & 24576) == 16384);
            if ((i5 & 14) == 4) {
                z6 = true;
            } else {
                z6 = false;
            }
            boolean z12 = z11 | z6;
            if ((i5 & 112) == 32) {
                z7 = true;
            } else {
                z7 = false;
            }
            boolean zChangedInstance2 = z12 | z7 | ((((29360128 & i5) ^ 12582912) <= 8388608 && gapComposer.changed(f8)) || (i5 & 12582912) == 8388608) | gapComposer.changedInstance(finiteAnimationSpecValue);
            z3 = ((3670016 & i5) ^ 1572864) > 1048576 ? false : false;
            z8 = zChangedInstance2 | z3;
            objRememberedValue2 = gapComposer.rememberedValue();
            if (z8) {
                i6 = 0;
                Object obj4 = new Style() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda2
                    @Override // androidx.compose.foundation.style.Style
                    public final void applyStyle(ResolvedStyle resolvedStyle) {
                        long j;
                        long j2;
                        int i13 = resolvedStyle.flags;
                        resolvedStyle.flags = i13 | 6;
                        resolvedStyle.shape = shape;
                        final TextFieldColors textFieldColors2 = textFieldColors;
                        final boolean z13 = z;
                        final boolean z14 = z2;
                        if (z13) {
                            j = z14 ? textFieldColors2.errorContainerColor : textFieldColors2.unfocusedContainerColor;
                        } else {
                            j = textFieldColors2.disabledContainerColor;
                        }
                        resolvedStyle.flags = i13 | 6;
                        resolvedStyle.backgroundColor = j;
                        resolvedStyle.backgroundBrush = null;
                        if (z13) {
                            j2 = z14 ? textFieldColors2.errorIndicatorColor : textFieldColors2.unfocusedIndicatorColor;
                        } else {
                            j2 = textFieldColors2.disabledIndicatorColor;
                        }
                        resolvedStyle.m159bordercXLIe8U(f8, j2);
                        final FiniteAnimationSpec finiteAnimationSpec = finiteAnimationSpecValue;
                        final float f10 = f9;
                        Style style2 = new Style() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda0
                            /* JADX WARN: Type inference failed for: r3v0, types: [androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda1] */
                            @Override // androidx.compose.foundation.style.Style
                            public final void applyStyle(ResolvedStyle resolvedStyle2) {
                                StyleAnimations.Entry entry;
                                final TextFieldColors textFieldColors3 = textFieldColors2;
                                final boolean z15 = z13;
                                final boolean z16 = z14;
                                final float f11 = f10;
                                ?? r3 = new Style() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda1
                                    @Override // androidx.compose.foundation.style.Style
                                    public final void applyStyle(ResolvedStyle resolvedStyle3) {
                                        long j3;
                                        long j4;
                                        TextFieldColors textFieldColors4 = textFieldColors3;
                                        boolean z17 = z15;
                                        boolean z18 = z16;
                                        if (z17) {
                                            j3 = z18 ? textFieldColors4.errorContainerColor : textFieldColors4.focusedContainerColor;
                                        } else {
                                            j3 = textFieldColors4.disabledContainerColor;
                                        }
                                        resolvedStyle3.flags |= 2;
                                        resolvedStyle3.backgroundColor = j3;
                                        resolvedStyle3.backgroundBrush = null;
                                        if (z17) {
                                            j4 = z18 ? textFieldColors4.errorIndicatorColor : textFieldColors4.focusedIndicatorColor;
                                        } else {
                                            j4 = textFieldColors4.disabledIndicatorColor;
                                        }
                                        resolvedStyle3.m159bordercXLIe8U(f11, j4);
                                    }
                                };
                                resolvedStyle2.flags |= 16;
                                int i14 = resolvedStyle2.currentIndex;
                                int i15 = i14 ^ 1318433304;
                                int i16 = resolvedStyle2.compositeHash;
                                ResolvedStyle resolvedStyle3 = ResolvedStyleKt.EmptyResolvedStyle;
                                resolvedStyle2.compositeHash = Integer.rotateLeft(i16, 3) ^ i15;
                                MutableIntList mutableIntList = resolvedStyle2.indexStack;
                                if (mutableIntList == null) {
                                    mutableIntList = new MutableIntList();
                                    resolvedStyle2.indexStack = mutableIntList;
                                }
                                MutableIntList mutableIntList2 = mutableIntList;
                                mutableIntList2.add(i14);
                                int i17 = 0;
                                resolvedStyle2.currentIndex = 0;
                                if (resolvedStyle2.animating) {
                                    r3.applyStyle(resolvedStyle2);
                                } else {
                                    StyleOuterNode styleOuterNode = resolvedStyle2.node;
                                    StyleAnimations styleAnimations = styleOuterNode.animations;
                                    if (styleAnimations == null) {
                                        styleAnimations = new StyleAnimations(styleOuterNode);
                                        styleOuterNode.animations = styleAnimations;
                                    }
                                    StyleAnimations styleAnimations2 = styleAnimations;
                                    int i18 = resolvedStyle2.compositeHash ^ resolvedStyle2.currentIndex;
                                    StyleAnimations.Entry[] entryArr = styleAnimations2.values;
                                    int i19 = styleAnimations2.size;
                                    while (true) {
                                        if (i17 < i19) {
                                            entry = entryArr[i17];
                                            if (entry != null && entry.key == i18) {
                                                break;
                                            } else {
                                                i17++;
                                            }
                                        } else {
                                            entry = null;
                                            break;
                                        }
                                    }
                                    if (entry != null) {
                                        entry.style = r3;
                                        int i110 = entry.state;
                                        if (i110 == 1) {
                                            entry.state = 2;
                                        } else if (i110 == 4) {
                                            entry.state = 3;
                                        }
                                    } else {
                                        int i20 = styleAnimations2.size + 1;
                                        StyleAnimations.Entry[] entryArr2 = styleAnimations2.values;
                                        int length = entryArr2.length;
                                        if (i20 > length) {
                                            styleAnimations2.values = (StyleAnimations.Entry[]) Arrays.copyOf(entryArr2, Math.max(length * 2, 2));
                                        }
                                        int i21 = styleAnimations2.size;
                                        StyleAnimations.Entry[] entryArr3 = styleAnimations2.values;
                                        FiniteAnimationSpec finiteAnimationSpec2 = finiteAnimationSpec;
                                        entryArr3[i21] = styleAnimations2.new Entry(i18, r3, finiteAnimationSpec2, finiteAnimationSpec2);
                                        styleAnimations2.size++;
                                    }
                                }
                                resolvedStyle2.currentIndex = mutableIntList2.removeAt(mutableIntList2._size - 1) + 1;
                                resolvedStyle2.compositeHash = Integer.rotateRight(resolvedStyle2.compositeHash ^ i15, 3);
                            }
                        };
                        int iHashCode = BooleanPredefinedKey.Focused.hashCode();
                        if ((resolvedStyle.node._state.predefinedState$delegate.getIntValue() & 4) == 0) {
                            resolvedStyle.currentIndex++;
                            return;
                        }
                        int i14 = resolvedStyle.currentIndex;
                        int i15 = iHashCode ^ i14;
                        int i16 = resolvedStyle.compositeHash;
                        ResolvedStyle resolvedStyle2 = ResolvedStyleKt.EmptyResolvedStyle;
                        resolvedStyle.compositeHash = Integer.rotateLeft(i16, 3) ^ i15;
                        MutableIntList mutableIntList = resolvedStyle.indexStack;
                        if (mutableIntList == null) {
                            mutableIntList = new MutableIntList();
                            resolvedStyle.indexStack = mutableIntList;
                        }
                        mutableIntList.add(i14);
                        resolvedStyle.currentIndex = 0;
                        style2.applyStyle(resolvedStyle);
                        resolvedStyle.currentIndex = mutableIntList.removeAt(mutableIntList._size - 1) + 1;
                        resolvedStyle.compositeHash = Integer.rotateRight(i15 ^ resolvedStyle.compositeHash, 3);
                    }
                };
                gapComposer.updateRememberedValue(obj4);
                objRememberedValue2 = obj4;
            } else {
                i6 = 0;
                Object obj5 = new Style() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda2
                    @Override // androidx.compose.foundation.style.Style
                    public final void applyStyle(ResolvedStyle resolvedStyle) {
                        long j;
                        long j2;
                        int i13 = resolvedStyle.flags;
                        resolvedStyle.flags = i13 | 6;
                        resolvedStyle.shape = shape;
                        final TextFieldColors textFieldColors2 = textFieldColors;
                        final boolean z13 = z;
                        final boolean z14 = z2;
                        if (z13) {
                            j = z14 ? textFieldColors2.errorContainerColor : textFieldColors2.unfocusedContainerColor;
                        } else {
                            j = textFieldColors2.disabledContainerColor;
                        }
                        resolvedStyle.flags = i13 | 6;
                        resolvedStyle.backgroundColor = j;
                        resolvedStyle.backgroundBrush = null;
                        if (z13) {
                            j2 = z14 ? textFieldColors2.errorIndicatorColor : textFieldColors2.unfocusedIndicatorColor;
                        } else {
                            j2 = textFieldColors2.disabledIndicatorColor;
                        }
                        resolvedStyle.m159bordercXLIe8U(f8, j2);
                        final FiniteAnimationSpec finiteAnimationSpec = finiteAnimationSpecValue;
                        final float f10 = f9;
                        Style style2 = new Style() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda0
                            /* JADX WARN: Type inference failed for: r3v0, types: [androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda1] */
                            @Override // androidx.compose.foundation.style.Style
                            public final void applyStyle(ResolvedStyle resolvedStyle2) {
                                StyleAnimations.Entry entry;
                                final TextFieldColors textFieldColors3 = textFieldColors2;
                                final boolean z15 = z13;
                                final boolean z16 = z14;
                                final float f11 = f10;
                                ?? r3 = new Style() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda1
                                    @Override // androidx.compose.foundation.style.Style
                                    public final void applyStyle(ResolvedStyle resolvedStyle3) {
                                        long j3;
                                        long j4;
                                        TextFieldColors textFieldColors4 = textFieldColors3;
                                        boolean z17 = z15;
                                        boolean z18 = z16;
                                        if (z17) {
                                            j3 = z18 ? textFieldColors4.errorContainerColor : textFieldColors4.focusedContainerColor;
                                        } else {
                                            j3 = textFieldColors4.disabledContainerColor;
                                        }
                                        resolvedStyle3.flags |= 2;
                                        resolvedStyle3.backgroundColor = j3;
                                        resolvedStyle3.backgroundBrush = null;
                                        if (z17) {
                                            j4 = z18 ? textFieldColors4.errorIndicatorColor : textFieldColors4.focusedIndicatorColor;
                                        } else {
                                            j4 = textFieldColors4.disabledIndicatorColor;
                                        }
                                        resolvedStyle3.m159bordercXLIe8U(f11, j4);
                                    }
                                };
                                resolvedStyle2.flags |= 16;
                                int i14 = resolvedStyle2.currentIndex;
                                int i15 = i14 ^ 1318433304;
                                int i16 = resolvedStyle2.compositeHash;
                                ResolvedStyle resolvedStyle3 = ResolvedStyleKt.EmptyResolvedStyle;
                                resolvedStyle2.compositeHash = Integer.rotateLeft(i16, 3) ^ i15;
                                MutableIntList mutableIntList = resolvedStyle2.indexStack;
                                if (mutableIntList == null) {
                                    mutableIntList = new MutableIntList();
                                    resolvedStyle2.indexStack = mutableIntList;
                                }
                                MutableIntList mutableIntList2 = mutableIntList;
                                mutableIntList2.add(i14);
                                int i17 = 0;
                                resolvedStyle2.currentIndex = 0;
                                if (resolvedStyle2.animating) {
                                    r3.applyStyle(resolvedStyle2);
                                } else {
                                    StyleOuterNode styleOuterNode = resolvedStyle2.node;
                                    StyleAnimations styleAnimations = styleOuterNode.animations;
                                    if (styleAnimations == null) {
                                        styleAnimations = new StyleAnimations(styleOuterNode);
                                        styleOuterNode.animations = styleAnimations;
                                    }
                                    StyleAnimations styleAnimations2 = styleAnimations;
                                    int i18 = resolvedStyle2.compositeHash ^ resolvedStyle2.currentIndex;
                                    StyleAnimations.Entry[] entryArr = styleAnimations2.values;
                                    int i19 = styleAnimations2.size;
                                    while (true) {
                                        if (i17 < i19) {
                                            entry = entryArr[i17];
                                            if (entry != null && entry.key == i18) {
                                                break;
                                            } else {
                                                i17++;
                                            }
                                        } else {
                                            entry = null;
                                            break;
                                        }
                                    }
                                    if (entry != null) {
                                        entry.style = r3;
                                        int i110 = entry.state;
                                        if (i110 == 1) {
                                            entry.state = 2;
                                        } else if (i110 == 4) {
                                            entry.state = 3;
                                        }
                                    } else {
                                        int i20 = styleAnimations2.size + 1;
                                        StyleAnimations.Entry[] entryArr2 = styleAnimations2.values;
                                        int length = entryArr2.length;
                                        if (i20 > length) {
                                            styleAnimations2.values = (StyleAnimations.Entry[]) Arrays.copyOf(entryArr2, Math.max(length * 2, 2));
                                        }
                                        int i21 = styleAnimations2.size;
                                        StyleAnimations.Entry[] entryArr3 = styleAnimations2.values;
                                        FiniteAnimationSpec finiteAnimationSpec2 = finiteAnimationSpec;
                                        entryArr3[i21] = styleAnimations2.new Entry(i18, r3, finiteAnimationSpec2, finiteAnimationSpec2);
                                        styleAnimations2.size++;
                                    }
                                }
                                resolvedStyle2.currentIndex = mutableIntList2.removeAt(mutableIntList2._size - 1) + 1;
                                resolvedStyle2.compositeHash = Integer.rotateRight(resolvedStyle2.compositeHash ^ i15, 3);
                            }
                        };
                        int iHashCode = BooleanPredefinedKey.Focused.hashCode();
                        if ((resolvedStyle.node._state.predefinedState$delegate.getIntValue() & 4) == 0) {
                            resolvedStyle.currentIndex++;
                            return;
                        }
                        int i14 = resolvedStyle.currentIndex;
                        int i15 = iHashCode ^ i14;
                        int i16 = resolvedStyle.compositeHash;
                        ResolvedStyle resolvedStyle2 = ResolvedStyleKt.EmptyResolvedStyle;
                        resolvedStyle.compositeHash = Integer.rotateLeft(i16, 3) ^ i15;
                        MutableIntList mutableIntList = resolvedStyle.indexStack;
                        if (mutableIntList == null) {
                            mutableIntList = new MutableIntList();
                            resolvedStyle.indexStack = mutableIntList;
                        }
                        mutableIntList.add(i14);
                        resolvedStyle.currentIndex = 0;
                        style2.applyStyle(resolvedStyle);
                        resolvedStyle.currentIndex = mutableIntList.removeAt(mutableIntList._size - 1) + 1;
                        resolvedStyle.compositeHash = Integer.rotateRight(i15 ^ resolvedStyle.compositeHash, 3);
                    }
                };
                gapComposer.updateRememberedValue(obj5);
                objRememberedValue2 = obj5;
            }
            style = (Style) objRememberedValue2;
            if (style == Style.Companion.$$INSTANCE) {
                modifierThen = modifier2;
            } else {
                modifierThen = modifier2.then(new StyleElement(mutableStyleState, style)).then(StyleInnerElement.INSTANCE);
            }
            BoxKt.Box(modifierThen, gapComposer, i6);
            f5 = f8;
            f6 = f9;
        } else {
            gapComposer.skipToGroupEnd();
            f5 = f4;
            f6 = f3;
        }
        modifier3 = modifier2;
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj6, Object obj7) {
                    ((Integer) obj7).getClass();
                    this.f$0.m253Container4EFweAY(z, z2, mutableInteractionSourceImpl, modifier3, textFieldColors, shape, f6, f5, (GapComposer) obj6, Stack.updateChangedFlags(i | 1), i2);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public final void DecorationBox(final String str, final Function2 function2, final boolean z, final boolean z2, final ZslControlImpl$$ExternalSyntheticLambda0 zslControlImpl$$ExternalSyntheticLambda0, final MutableInteractionSourceImpl mutableInteractionSourceImpl, final boolean z3, final Function2 function3, final Function2 function4, final TextFieldColors textFieldColors, PaddingValues paddingValues, final ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, final int i) {
        int i2;
        boolean z4;
        boolean z5;
        Object obj;
        final PaddingValues paddingValues2;
        PaddingValues paddingValuesImpl;
        int i3;
        gapComposer.startRestartGroup(-1732281618);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            z4 = z;
            i2 |= gapComposer.changed(z4) ? 256 : 128;
        } else {
            z4 = z;
        }
        if ((i & 3072) == 0) {
            z5 = z2;
            i2 |= gapComposer.changed(z5) ? 2048 : 1024;
        } else {
            z5 = z2;
        }
        if ((i & 24576) == 0) {
            obj = zslControlImpl$$ExternalSyntheticLambda0;
            i2 |= gapComposer.changed(obj) ? 16384 : 8192;
        } else {
            obj = zslControlImpl$$ExternalSyntheticLambda0;
        }
        if ((i & 196608) == 0) {
            i2 |= gapComposer.changed(mutableInteractionSourceImpl) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i2 |= gapComposer.changed(z3) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i2 |= gapComposer.changedInstance(null) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i2 |= gapComposer.changedInstance(function3) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i2 |= gapComposer.changedInstance(null) ? 536870912 : 268435456;
        }
        int i4 = 14155776 | (gapComposer.changedInstance(null) ? 4 : 2) | (gapComposer.changedInstance(null) ? 32 : 16) | (gapComposer.changedInstance(null) ? 256 : 128) | (gapComposer.changedInstance(function4) ? 2048 : 1024) | (gapComposer.changed(textFieldColors) ? 16384 : 8192) | 65536;
        if (gapComposer.shouldExecute(i2 & 1, ((i2 & 306783379) == 306783378 && (4793491 & i4) == 4793490) ? false : true)) {
            gapComposer.startDefaults();
            if ((i & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                float f = TextFieldImplKt.TextFieldPadding;
                paddingValuesImpl = new PaddingValuesImpl(f, f, f, f);
                i3 = i4 & (-458753);
            } else {
                gapComposer.skipToGroupEnd();
                i3 = i4 & (-458753);
                paddingValuesImpl = paddingValues;
            }
            gapComposer.endDefaults();
            boolean z6 = ((i2 & 14) == 4) | ((i2 & 57344) == 16384);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (z6 || objRememberedValue == Composer$Companion.Empty) {
                AnnotatedString annotatedString = new AnnotatedString(str);
                obj.getClass();
                objRememberedValue = new TransformedText(annotatedString, OffsetMapping.Companion.Identity);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            String str2 = ((TransformedText) objRememberedValue).text.text;
            PaddingValues paddingValues3 = paddingValuesImpl;
            TextFieldLabelPosition$Attached textFieldLabelPosition$Attached = new TextFieldLabelPosition$Attached();
            gapComposer.startReplaceGroup(1927042940);
            gapComposer.end(false);
            int i5 = i2 >> 9;
            int i6 = i3 << 21;
            TextFieldImplKt.CommonDecorationBox(str2, function2, textFieldLabelPosition$Attached, null, function3, function4, z5, z4, z3, mutableInteractionSourceImpl, paddingValues3, textFieldColors, composableLambdaImpl, gapComposer, ((i2 << 3) & 896) | 6 | (i5 & 458752) | (i5 & 3670016) | (i6 & 29360128) | (i6 & 234881024) | (i6 & 1879048192), (i2 & 896) | ((i3 >> 9) & 14) | ((i2 >> 6) & 112) | (i5 & 7168) | ((i2 >> 3) & 57344) | ((i3 << 6) & 3670016) | 12582912);
            paddingValues2 = paddingValues3;
        } else {
            gapComposer.skipToGroupEnd();
            paddingValues2 = paddingValues;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    ((Integer) obj3).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                    this.f$0.DecorationBox(str, function2, z, z2, zslControlImpl$$ExternalSyntheticLambda0, mutableInteractionSourceImpl, z3, function3, function4, textFieldColors, paddingValues2, composableLambdaImpl, (GapComposer) obj2, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
