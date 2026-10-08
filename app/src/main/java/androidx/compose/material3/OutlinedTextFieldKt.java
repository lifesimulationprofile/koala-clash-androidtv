package androidx.compose.material3;

import androidx.camera.camera2.internal.ZslControlImpl$$ExternalSyntheticLambda0;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeElement;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.internal.LayoutUtilKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.material3.internal.TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetModifier$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayout$1;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.VisualTransformation$Companion;
import androidx.compose.ui.unit.LayoutDirection;
import com.koala.clash.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class OutlinedTextFieldKt {
    public static final float OutlinedTextFieldInnerPadding = 4;

    /* JADX WARN: Code duplicated, block: B:19:0x004d  */
    /* JADX WARN: Code duplicated, block: B:20:0x004f  */
    /* JADX WARN: Code duplicated, block: B:23:0x005a  */
    /* JADX WARN: Code duplicated, block: B:24:0x005d  */
    /* JADX WARN: Code duplicated, block: B:27:0x0068  */
    /* JADX WARN: Code duplicated, block: B:28:0x0070  */
    /* JADX WARN: Code duplicated, block: B:30:0x0078  */
    /* JADX WARN: Code duplicated, block: B:31:0x007b  */
    /* JADX WARN: Code duplicated, block: B:35:0x0087  */
    /* JADX WARN: Code duplicated, block: B:37:0x008f  */
    /* JADX WARN: Code duplicated, block: B:38:0x0092  */
    /* JADX WARN: Code duplicated, block: B:42:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:45:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:51:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:54:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:56:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:60:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:62:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:64:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:65:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:67:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:68:0x0101  */
    /* JADX WARN: Code duplicated, block: B:71:0x0108  */
    /* JADX WARN: Code duplicated, block: B:75:0x0131  */
    /* JADX WARN: Code duplicated, block: B:78:0x014f  */
    /* JADX WARN: Code duplicated, block: B:80:0x0153  */
    /* JADX WARN: Code duplicated, block: B:82:0x0163  */
    /* JADX WARN: Code duplicated, block: B:84:0x0168 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:85:0x016a  */
    /* JADX WARN: Code duplicated, block: B:86:0x016d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:87:0x016f  */
    /* JADX WARN: Code duplicated, block: B:88:0x0172  */
    /* JADX WARN: Code duplicated, block: B:91:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:94:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:96:? A[RETURN, SYNTHETIC] */
    public static final void OutlinedTextField(final String str, final Function1 function1, final Modifier modifier, boolean z, TextStyle textStyle, Function2 function2, final Function2 function3, final boolean z2, ZslControlImpl$$ExternalSyntheticLambda0 zslControlImpl$$ExternalSyntheticLambda0, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, final boolean z3, int i, int i2, Shape shape, final TextFieldColors textFieldColors, GapComposer gapComposer, final int i3, final int i4) {
        Function2 function4;
        int i5;
        char c;
        int i6;
        int i7;
        int i8;
        int i9;
        KeyboardOptions keyboardOptions2;
        int i10;
        int i11;
        final Shape value;
        boolean z4;
        GapComposer gapComposer2;
        final boolean z5;
        final KeyboardActions keyboardActions2;
        final int i12;
        final int i13;
        final Function2 function5;
        final KeyboardOptions keyboardOptions3;
        final TextStyle textStyle2;
        final ZslControlImpl$$ExternalSyntheticLambda0 zslControlImpl$$ExternalSyntheticLambda1;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        KeyboardOptions keyboardOptions4;
        int i14;
        final int i15;
        final KeyboardActions keyboardActions3;
        final KeyboardOptions keyboardOptions5;
        final ZslControlImpl$$ExternalSyntheticLambda0 zslControlImpl$$ExternalSyntheticLambda2;
        final Shape shape2;
        final int i16;
        final Function2 function6;
        TextStyle textStyle3;
        final boolean z6;
        Object objRememberedValue;
        final MutableInteractionSourceImpl mutableInteractionSourceImpl;
        long jM649getColor0d7_KjU;
        boolean zBooleanValue;
        long j;
        boolean z7;
        gapComposer.startRestartGroup(1901501544);
        int i17 = i3 | (gapComposer.changed(str) ? 4 : 2);
        int i18 = 1666048 | i17;
        int i19 = i4 & 128;
        if (i19 == 0) {
            if ((i3 & 12582912) == 0) {
                function4 = function2;
                i18 |= gapComposer.changedInstance(function4) ? 8388608 : 4194304;
            }
            i5 = i18 | 905969664;
            if (gapComposer.changedInstance(function3)) {
                c = 256;
            } else {
                c = 128;
            }
            int i20 = c | '6';
            if (gapComposer.changed(z2)) {
                i6 = 2048;
            } else {
                i6 = 1024;
            }
            i7 = i20 | i6;
            i8 = i7 | 24576;
            i9 = 32768 & i4;
            if (i9 != 0) {
                i11 = i7 | 221184;
                keyboardOptions2 = keyboardOptions;
            } else {
                keyboardOptions2 = keyboardOptions;
                if (gapComposer.changed(keyboardOptions2)) {
                    i10 = 131072;
                } else {
                    i10 = 65536;
                }
                i11 = i8 | i10;
            }
            int i21 = i11 | 840433664;
            if ((i4 & 2097152) == 0) {
                value = shape;
                char c2 = gapComposer.changed(value) ? ' ' : (char) 16;
                int i22 = 6 | c2 | (gapComposer.changed(textFieldColors) ? (char) 256 : (char) 128);
                if ((i5 & 306783379) != 306783378 && (i21 & 306783379) == 306783378 && (i22 & 147) == 146) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                if (gapComposer.shouldExecute(i5 & 1, z4)) {
                    gapComposer.startDefaults();
                    if ((i3 & 1) != 0 || gapComposer.getDefaultsInvalid()) {
                        TextStyle textStyle4 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                        if (i19 != 0) {
                            function4 = null;
                        }
                        if (i9 != 0) {
                            keyboardOptions4 = KeyboardOptions.Default;
                        } else {
                            keyboardOptions4 = keyboardOptions2;
                        }
                        if (z3) {
                            i14 = 1;
                        } else {
                            i14 = Integer.MAX_VALUE;
                        }
                        if ((i4 & 2097152) != 0) {
                            OutlinedTextFieldDefaults outlinedTextFieldDefaults = OutlinedTextFieldDefaults.INSTANCE;
                            value = ShapesKt.getValue(5, gapComposer);
                        }
                        ZslControlImpl$$ExternalSyntheticLambda0 zslControlImpl$$ExternalSyntheticLambda3 = VisualTransformation$Companion.None;
                        i15 = i14;
                        keyboardActions3 = KeyboardActions.Default;
                        keyboardOptions5 = keyboardOptions4;
                        zslControlImpl$$ExternalSyntheticLambda2 = zslControlImpl$$ExternalSyntheticLambda3;
                        shape2 = value;
                        i16 = 1;
                        function6 = function4;
                        textStyle3 = textStyle4;
                        z6 = true;
                    } else {
                        gapComposer.skipToGroupEnd();
                        z6 = z;
                        zslControlImpl$$ExternalSyntheticLambda2 = zslControlImpl$$ExternalSyntheticLambda0;
                        i15 = i;
                        i16 = i2;
                        keyboardOptions5 = keyboardOptions2;
                        shape2 = value;
                        keyboardActions3 = keyboardActions;
                        function6 = function4;
                        textStyle3 = textStyle;
                    }
                    gapComposer.endDefaults();
                    gapComposer.startReplaceGroup(1310000147);
                    objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == Composer$Companion.Empty) {
                        objRememberedValue = new MutableInteractionSourceImpl();
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
                    gapComposer.end(false);
                    gapComposer.startReplaceGroup(1981926178);
                    jM649getColor0d7_KjU = textStyle3.m649getColor0d7_KjU();
                    if (jM649getColor0d7_KjU != 16) {
                        z7 = false;
                    } else {
                        zBooleanValue = ((Boolean) ChannelKt.collectIsFocusedAsState(mutableInteractionSourceImpl, gapComposer, 0).getValue()).booleanValue();
                        if (!z6) {
                            j = textFieldColors.disabledTextColor;
                        } else if (z2) {
                            j = textFieldColors.errorTextColor;
                        } else if (zBooleanValue) {
                            j = textFieldColors.focusedTextColor;
                        } else {
                            j = textFieldColors.unfocusedTextColor;
                        }
                        jM649getColor0d7_KjU = j;
                        z7 = false;
                    }
                    long j2 = jM649getColor0d7_KjU;
                    gapComposer.end(z7);
                    final TextStyle textStyleMerge = textStyle3.merge(new TextStyle(j2, 0L, null, 0L, 0, 0L, 16777214));
                    gapComposer2 = gapComposer;
                    Stack.CompositionLocalProvider(TextSelectionColorsKt.LocalTextSelectionColors.defaultProvidedValue$runtime(textFieldColors.textSelectionColors), Thread_jvmKt.rememberComposableLambda(1874034984, new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            GapComposer gapComposer3 = (GapComposer) obj;
                            int iIntValue = ((Integer) obj2).intValue();
                            if (gapComposer3.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                                gapComposer3.startReplaceGroup(-903106918);
                                gapComposer3.end(false);
                                Modifier modifierThen = modifier.then(Modifier.Companion.$$INSTANCE);
                                String strM282getString2EP1pXo = LayoutUtilKt.m282getString2EP1pXo(R.string.default_error_message, gapComposer3);
                                float f = TextFieldImplKt.TextFieldPadding;
                                final boolean z8 = z2;
                                if (z8) {
                                    modifierThen = SemanticsModifierKt.semantics(modifierThen, false, new IconKt$$ExternalSyntheticLambda1(strM282getString2EP1pXo, 6));
                                }
                                Modifier modifierM134defaultMinSizeVpY3zN4 = SizeKt.m134defaultMinSizeVpY3zN4(modifierThen, OutlinedTextFieldDefaults.MinWidth, OutlinedTextFieldDefaults.MinHeight);
                                final TextFieldColors textFieldColors2 = textFieldColors;
                                SolidColor solidColor = new SolidColor(z8 ? textFieldColors2.errorCursorColor : textFieldColors2.cursorColor);
                                final String str2 = str;
                                final boolean z9 = z6;
                                final boolean z10 = z3;
                                final ZslControlImpl$$ExternalSyntheticLambda0 zslControlImpl$$ExternalSyntheticLambda4 = zslControlImpl$$ExternalSyntheticLambda2;
                                final MutableInteractionSourceImpl mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                                final Function2 function7 = function6;
                                final Function2 function8 = function3;
                                final Shape shape3 = shape2;
                                BasicTextFieldKt.BasicTextField(str2, function1, modifierM134defaultMinSizeVpY3zN4, z9, textStyleMerge, keyboardOptions5, keyboardActions3, z10, i15, i16, zslControlImpl$$ExternalSyntheticLambda4, null, mutableInteractionSourceImpl2, solidColor, Thread_jvmKt.rememberComposableLambda(-1189274459, new Function3() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj3, Object obj4, Object obj5) {
                                        Function2 function9 = (Function2) obj3;
                                        GapComposer gapComposer4 = (GapComposer) obj4;
                                        int iIntValue2 = ((Integer) obj5).intValue();
                                        if ((iIntValue2 & 6) == 0) {
                                            iIntValue2 |= gapComposer4.changedInstance(function9) ? 4 : 2;
                                        }
                                        if (gapComposer4.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                                            int i23 = iIntValue2;
                                            OutlinedTextFieldDefaults outlinedTextFieldDefaults2 = OutlinedTextFieldDefaults.INSTANCE;
                                            boolean z11 = z9;
                                            boolean z12 = z8;
                                            MutableInteractionSourceImpl mutableInteractionSourceImpl3 = mutableInteractionSourceImpl2;
                                            TextFieldColors textFieldColors3 = textFieldColors2;
                                            outlinedTextFieldDefaults2.DecorationBox(str2, function9, z11, z10, zslControlImpl$$ExternalSyntheticLambda4, mutableInteractionSourceImpl3, z12, function7, function8, textFieldColors3, null, Thread_jvmKt.rememberComposableLambda(-656940872, new SwitchKt$$ExternalSyntheticLambda0(z11, z12, mutableInteractionSourceImpl3, textFieldColors3, shape3), gapComposer4), gapComposer4, (i23 << 3) & 112);
                                        } else {
                                            gapComposer4.skipToGroupEnd();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }, gapComposer3), gapComposer3, 0, 4096);
                            } else {
                                gapComposer3.skipToGroupEnd();
                            }
                            return Unit.INSTANCE;
                        }
                    }, gapComposer2), gapComposer2, 56);
                    int i23 = i15;
                    keyboardActions2 = keyboardActions3;
                    zslControlImpl$$ExternalSyntheticLambda1 = zslControlImpl$$ExternalSyntheticLambda2;
                    i12 = i23;
                    z5 = z6;
                    keyboardOptions3 = keyboardOptions5;
                    i13 = i16;
                    function5 = function6;
                    value = shape2;
                    textStyle2 = textStyle3;
                } else {
                    gapComposer2 = gapComposer;
                    gapComposer2.skipToGroupEnd();
                    z5 = z;
                    keyboardActions2 = keyboardActions;
                    i12 = i;
                    i13 = i2;
                    function5 = function4;
                    keyboardOptions3 = keyboardOptions2;
                    textStyle2 = textStyle;
                    zslControlImpl$$ExternalSyntheticLambda1 = zslControlImpl$$ExternalSyntheticLambda0;
                }
                recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i3 | 1);
                            OutlinedTextFieldKt.OutlinedTextField(str, function1, modifier, z5, textStyle2, function5, function3, z2, zslControlImpl$$ExternalSyntheticLambda1, keyboardOptions3, keyboardActions2, z3, i12, i13, value, textFieldColors, (GapComposer) obj, iUpdateChangedFlags, i4);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            value = shape;
            int i24 = 6 | c2 | (gapComposer.changed(textFieldColors) ? (char) 256 : (char) 128);
            if ((i5 & 306783379) != 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (gapComposer.shouldExecute(i5 & 1, z4)) {
                gapComposer.startDefaults();
                if ((i3 & 1) != 0) {
                    TextStyle textStyle5 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                    if (i19 != 0) {
                        function4 = null;
                    }
                    if (i9 != 0) {
                        keyboardOptions4 = KeyboardOptions.Default;
                    } else {
                        keyboardOptions4 = keyboardOptions2;
                    }
                    if (z3) {
                        i14 = 1;
                    } else {
                        i14 = Integer.MAX_VALUE;
                    }
                    if ((i4 & 2097152) != 0) {
                        OutlinedTextFieldDefaults outlinedTextFieldDefaults2 = OutlinedTextFieldDefaults.INSTANCE;
                        value = ShapesKt.getValue(5, gapComposer);
                    }
                    ZslControlImpl$$ExternalSyntheticLambda0 zslControlImpl$$ExternalSyntheticLambda4 = VisualTransformation$Companion.None;
                    i15 = i14;
                    keyboardActions3 = KeyboardActions.Default;
                    keyboardOptions5 = keyboardOptions4;
                    zslControlImpl$$ExternalSyntheticLambda2 = zslControlImpl$$ExternalSyntheticLambda4;
                    shape2 = value;
                    i16 = 1;
                    function6 = function4;
                    textStyle3 = textStyle5;
                    z6 = true;
                } else {
                    TextStyle textStyle6 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                    if (i19 != 0) {
                        function4 = null;
                    }
                    if (i9 != 0) {
                        keyboardOptions4 = KeyboardOptions.Default;
                    } else {
                        keyboardOptions4 = keyboardOptions2;
                    }
                    if (z3) {
                        i14 = 1;
                    } else {
                        i14 = Integer.MAX_VALUE;
                    }
                    if ((i4 & 2097152) != 0) {
                        OutlinedTextFieldDefaults outlinedTextFieldDefaults3 = OutlinedTextFieldDefaults.INSTANCE;
                        value = ShapesKt.getValue(5, gapComposer);
                    }
                    ZslControlImpl$$ExternalSyntheticLambda0 zslControlImpl$$ExternalSyntheticLambda5 = VisualTransformation$Companion.None;
                    i15 = i14;
                    keyboardActions3 = KeyboardActions.Default;
                    keyboardOptions5 = keyboardOptions4;
                    zslControlImpl$$ExternalSyntheticLambda2 = zslControlImpl$$ExternalSyntheticLambda5;
                    shape2 = value;
                    i16 = 1;
                    function6 = function4;
                    textStyle3 = textStyle6;
                    z6 = true;
                }
                gapComposer.endDefaults();
                gapComposer.startReplaceGroup(1310000147);
                objRememberedValue = gapComposer.rememberedValue();
                if (objRememberedValue == Composer$Companion.Empty) {
                    objRememberedValue = new MutableInteractionSourceImpl();
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
                gapComposer.end(false);
                gapComposer.startReplaceGroup(1981926178);
                jM649getColor0d7_KjU = textStyle3.m649getColor0d7_KjU();
                if (jM649getColor0d7_KjU != 16) {
                    z7 = false;
                } else {
                    zBooleanValue = ((Boolean) ChannelKt.collectIsFocusedAsState(mutableInteractionSourceImpl, gapComposer, 0).getValue()).booleanValue();
                    if (!z6) {
                        j = textFieldColors.disabledTextColor;
                    } else if (z2) {
                        j = textFieldColors.errorTextColor;
                    } else if (zBooleanValue) {
                        j = textFieldColors.focusedTextColor;
                    } else {
                        j = textFieldColors.unfocusedTextColor;
                    }
                    jM649getColor0d7_KjU = j;
                    z7 = false;
                }
                long j3 = jM649getColor0d7_KjU;
                gapComposer.end(z7);
                final TextStyle textStyleMerge2 = textStyle3.merge(new TextStyle(j3, 0L, null, 0L, 0, 0L, 16777214));
                gapComposer2 = gapComposer;
                Stack.CompositionLocalProvider(TextSelectionColorsKt.LocalTextSelectionColors.defaultProvidedValue$runtime(textFieldColors.textSelectionColors), Thread_jvmKt.rememberComposableLambda(1874034984, new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        GapComposer gapComposer3 = (GapComposer) obj;
                        int iIntValue = ((Integer) obj2).intValue();
                        if (gapComposer3.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                            gapComposer3.startReplaceGroup(-903106918);
                            gapComposer3.end(false);
                            Modifier modifierThen = modifier.then(Modifier.Companion.$$INSTANCE);
                            String strM282getString2EP1pXo = LayoutUtilKt.m282getString2EP1pXo(R.string.default_error_message, gapComposer3);
                            float f = TextFieldImplKt.TextFieldPadding;
                            final boolean z8 = z2;
                            if (z8) {
                                modifierThen = SemanticsModifierKt.semantics(modifierThen, false, new IconKt$$ExternalSyntheticLambda1(strM282getString2EP1pXo, 6));
                            }
                            Modifier modifierM134defaultMinSizeVpY3zN4 = SizeKt.m134defaultMinSizeVpY3zN4(modifierThen, OutlinedTextFieldDefaults.MinWidth, OutlinedTextFieldDefaults.MinHeight);
                            final TextFieldColors textFieldColors2 = textFieldColors;
                            SolidColor solidColor = new SolidColor(z8 ? textFieldColors2.errorCursorColor : textFieldColors2.cursorColor);
                            final String str2 = str;
                            final boolean z9 = z6;
                            final boolean z10 = z3;
                            final ZslControlImpl$$ExternalSyntheticLambda0 zslControlImpl$$ExternalSyntheticLambda6 = zslControlImpl$$ExternalSyntheticLambda2;
                            final MutableInteractionSourceImpl mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                            final Function2 function7 = function6;
                            final Function2 function8 = function3;
                            final Shape shape3 = shape2;
                            BasicTextFieldKt.BasicTextField(str2, function1, modifierM134defaultMinSizeVpY3zN4, z9, textStyleMerge2, keyboardOptions5, keyboardActions3, z10, i15, i16, zslControlImpl$$ExternalSyntheticLambda6, null, mutableInteractionSourceImpl2, solidColor, Thread_jvmKt.rememberComposableLambda(-1189274459, new Function3() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj3, Object obj4, Object obj5) {
                                    Function2 function9 = (Function2) obj3;
                                    GapComposer gapComposer4 = (GapComposer) obj4;
                                    int iIntValue2 = ((Integer) obj5).intValue();
                                    if ((iIntValue2 & 6) == 0) {
                                        iIntValue2 |= gapComposer4.changedInstance(function9) ? 4 : 2;
                                    }
                                    if (gapComposer4.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                                        int i25 = iIntValue2;
                                        OutlinedTextFieldDefaults outlinedTextFieldDefaults4 = OutlinedTextFieldDefaults.INSTANCE;
                                        boolean z11 = z9;
                                        boolean z12 = z8;
                                        MutableInteractionSourceImpl mutableInteractionSourceImpl3 = mutableInteractionSourceImpl2;
                                        TextFieldColors textFieldColors3 = textFieldColors2;
                                        outlinedTextFieldDefaults4.DecorationBox(str2, function9, z11, z10, zslControlImpl$$ExternalSyntheticLambda6, mutableInteractionSourceImpl3, z12, function7, function8, textFieldColors3, null, Thread_jvmKt.rememberComposableLambda(-656940872, new SwitchKt$$ExternalSyntheticLambda0(z11, z12, mutableInteractionSourceImpl3, textFieldColors3, shape3), gapComposer4), gapComposer4, (i25 << 3) & 112);
                                    } else {
                                        gapComposer4.skipToGroupEnd();
                                    }
                                    return Unit.INSTANCE;
                                }
                            }, gapComposer3), gapComposer3, 0, 4096);
                        } else {
                            gapComposer3.skipToGroupEnd();
                        }
                        return Unit.INSTANCE;
                    }
                }, gapComposer2), gapComposer2, 56);
                int i25 = i15;
                keyboardActions2 = keyboardActions3;
                zslControlImpl$$ExternalSyntheticLambda1 = zslControlImpl$$ExternalSyntheticLambda2;
                i12 = i25;
                z5 = z6;
                keyboardOptions3 = keyboardOptions5;
                i13 = i16;
                function5 = function6;
                value = shape2;
                textStyle2 = textStyle3;
            } else {
                gapComposer2 = gapComposer;
                gapComposer2.skipToGroupEnd();
                z5 = z;
                keyboardActions2 = keyboardActions;
                i12 = i;
                i13 = i2;
                function5 = function4;
                keyboardOptions3 = keyboardOptions2;
                textStyle2 = textStyle;
                zslControlImpl$$ExternalSyntheticLambda1 = zslControlImpl$$ExternalSyntheticLambda0;
            }
            recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i3 | 1);
                        OutlinedTextFieldKt.OutlinedTextField(str, function1, modifier, z5, textStyle2, function5, function3, z2, zslControlImpl$$ExternalSyntheticLambda1, keyboardOptions3, keyboardActions2, z3, i12, i13, value, textFieldColors, (GapComposer) obj, iUpdateChangedFlags, i4);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i18 = 14248960 | i17;
        function4 = function2;
        i5 = i18 | 905969664;
        if (gapComposer.changedInstance(function3)) {
            c = 256;
        } else {
            c = 128;
        }
        int i26 = c | '6';
        if (gapComposer.changed(z2)) {
            i6 = 2048;
        } else {
            i6 = 1024;
        }
        i7 = i26 | i6;
        i8 = i7 | 24576;
        i9 = 32768 & i4;
        if (i9 != 0) {
            i11 = i7 | 221184;
            keyboardOptions2 = keyboardOptions;
        } else {
            keyboardOptions2 = keyboardOptions;
            if (gapComposer.changed(keyboardOptions2)) {
                i10 = 131072;
            } else {
                i10 = 65536;
            }
            i11 = i8 | i10;
        }
        int i27 = i11 | 840433664;
        if ((i4 & 2097152) == 0) {
            value = shape;
            if (gapComposer.changed(value)) {
            }
            int i28 = 6 | c2 | (gapComposer.changed(textFieldColors) ? (char) 256 : (char) 128);
            if ((i5 & 306783379) != 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (gapComposer.shouldExecute(i5 & 1, z4)) {
                gapComposer.startDefaults();
                if ((i3 & 1) != 0) {
                    TextStyle textStyle7 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                    if (i19 != 0) {
                        function4 = null;
                    }
                    if (i9 != 0) {
                        keyboardOptions4 = KeyboardOptions.Default;
                    } else {
                        keyboardOptions4 = keyboardOptions2;
                    }
                    if (z3) {
                        i14 = 1;
                    } else {
                        i14 = Integer.MAX_VALUE;
                    }
                    if ((i4 & 2097152) != 0) {
                        OutlinedTextFieldDefaults outlinedTextFieldDefaults4 = OutlinedTextFieldDefaults.INSTANCE;
                        value = ShapesKt.getValue(5, gapComposer);
                    }
                    ZslControlImpl$$ExternalSyntheticLambda0 zslControlImpl$$ExternalSyntheticLambda6 = VisualTransformation$Companion.None;
                    i15 = i14;
                    keyboardActions3 = KeyboardActions.Default;
                    keyboardOptions5 = keyboardOptions4;
                    zslControlImpl$$ExternalSyntheticLambda2 = zslControlImpl$$ExternalSyntheticLambda6;
                    shape2 = value;
                    i16 = 1;
                    function6 = function4;
                    textStyle3 = textStyle7;
                    z6 = true;
                } else {
                    TextStyle textStyle8 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                    if (i19 != 0) {
                        function4 = null;
                    }
                    if (i9 != 0) {
                        keyboardOptions4 = KeyboardOptions.Default;
                    } else {
                        keyboardOptions4 = keyboardOptions2;
                    }
                    if (z3) {
                        i14 = 1;
                    } else {
                        i14 = Integer.MAX_VALUE;
                    }
                    if ((i4 & 2097152) != 0) {
                        OutlinedTextFieldDefaults outlinedTextFieldDefaults5 = OutlinedTextFieldDefaults.INSTANCE;
                        value = ShapesKt.getValue(5, gapComposer);
                    }
                    ZslControlImpl$$ExternalSyntheticLambda0 zslControlImpl$$ExternalSyntheticLambda7 = VisualTransformation$Companion.None;
                    i15 = i14;
                    keyboardActions3 = KeyboardActions.Default;
                    keyboardOptions5 = keyboardOptions4;
                    zslControlImpl$$ExternalSyntheticLambda2 = zslControlImpl$$ExternalSyntheticLambda7;
                    shape2 = value;
                    i16 = 1;
                    function6 = function4;
                    textStyle3 = textStyle8;
                    z6 = true;
                }
                gapComposer.endDefaults();
                gapComposer.startReplaceGroup(1310000147);
                objRememberedValue = gapComposer.rememberedValue();
                if (objRememberedValue == Composer$Companion.Empty) {
                    objRememberedValue = new MutableInteractionSourceImpl();
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
                gapComposer.end(false);
                gapComposer.startReplaceGroup(1981926178);
                jM649getColor0d7_KjU = textStyle3.m649getColor0d7_KjU();
                if (jM649getColor0d7_KjU != 16) {
                    z7 = false;
                } else {
                    zBooleanValue = ((Boolean) ChannelKt.collectIsFocusedAsState(mutableInteractionSourceImpl, gapComposer, 0).getValue()).booleanValue();
                    if (!z6) {
                        j = textFieldColors.disabledTextColor;
                    } else if (z2) {
                        j = textFieldColors.errorTextColor;
                    } else if (zBooleanValue) {
                        j = textFieldColors.focusedTextColor;
                    } else {
                        j = textFieldColors.unfocusedTextColor;
                    }
                    jM649getColor0d7_KjU = j;
                    z7 = false;
                }
                long j4 = jM649getColor0d7_KjU;
                gapComposer.end(z7);
                final TextStyle textStyleMerge3 = textStyle3.merge(new TextStyle(j4, 0L, null, 0L, 0, 0L, 16777214));
                gapComposer2 = gapComposer;
                Stack.CompositionLocalProvider(TextSelectionColorsKt.LocalTextSelectionColors.defaultProvidedValue$runtime(textFieldColors.textSelectionColors), Thread_jvmKt.rememberComposableLambda(1874034984, new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        GapComposer gapComposer3 = (GapComposer) obj;
                        int iIntValue = ((Integer) obj2).intValue();
                        if (gapComposer3.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                            gapComposer3.startReplaceGroup(-903106918);
                            gapComposer3.end(false);
                            Modifier modifierThen = modifier.then(Modifier.Companion.$$INSTANCE);
                            String strM282getString2EP1pXo = LayoutUtilKt.m282getString2EP1pXo(R.string.default_error_message, gapComposer3);
                            float f = TextFieldImplKt.TextFieldPadding;
                            final boolean z8 = z2;
                            if (z8) {
                                modifierThen = SemanticsModifierKt.semantics(modifierThen, false, new IconKt$$ExternalSyntheticLambda1(strM282getString2EP1pXo, 6));
                            }
                            Modifier modifierM134defaultMinSizeVpY3zN4 = SizeKt.m134defaultMinSizeVpY3zN4(modifierThen, OutlinedTextFieldDefaults.MinWidth, OutlinedTextFieldDefaults.MinHeight);
                            final TextFieldColors textFieldColors2 = textFieldColors;
                            SolidColor solidColor = new SolidColor(z8 ? textFieldColors2.errorCursorColor : textFieldColors2.cursorColor);
                            final String str2 = str;
                            final boolean z9 = z6;
                            final boolean z10 = z3;
                            final ZslControlImpl$$ExternalSyntheticLambda0 zslControlImpl$$ExternalSyntheticLambda8 = zslControlImpl$$ExternalSyntheticLambda2;
                            final MutableInteractionSourceImpl mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                            final Function2 function7 = function6;
                            final Function2 function8 = function3;
                            final Shape shape3 = shape2;
                            BasicTextFieldKt.BasicTextField(str2, function1, modifierM134defaultMinSizeVpY3zN4, z9, textStyleMerge3, keyboardOptions5, keyboardActions3, z10, i15, i16, zslControlImpl$$ExternalSyntheticLambda8, null, mutableInteractionSourceImpl2, solidColor, Thread_jvmKt.rememberComposableLambda(-1189274459, new Function3() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function3
                                public final Object invoke(Object obj3, Object obj4, Object obj5) {
                                    Function2 function9 = (Function2) obj3;
                                    GapComposer gapComposer4 = (GapComposer) obj4;
                                    int iIntValue2 = ((Integer) obj5).intValue();
                                    if ((iIntValue2 & 6) == 0) {
                                        iIntValue2 |= gapComposer4.changedInstance(function9) ? 4 : 2;
                                    }
                                    if (gapComposer4.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                                        int i29 = iIntValue2;
                                        OutlinedTextFieldDefaults outlinedTextFieldDefaults6 = OutlinedTextFieldDefaults.INSTANCE;
                                        boolean z11 = z9;
                                        boolean z12 = z8;
                                        MutableInteractionSourceImpl mutableInteractionSourceImpl3 = mutableInteractionSourceImpl2;
                                        TextFieldColors textFieldColors3 = textFieldColors2;
                                        outlinedTextFieldDefaults6.DecorationBox(str2, function9, z11, z10, zslControlImpl$$ExternalSyntheticLambda8, mutableInteractionSourceImpl3, z12, function7, function8, textFieldColors3, null, Thread_jvmKt.rememberComposableLambda(-656940872, new SwitchKt$$ExternalSyntheticLambda0(z11, z12, mutableInteractionSourceImpl3, textFieldColors3, shape3), gapComposer4), gapComposer4, (i29 << 3) & 112);
                                    } else {
                                        gapComposer4.skipToGroupEnd();
                                    }
                                    return Unit.INSTANCE;
                                }
                            }, gapComposer3), gapComposer3, 0, 4096);
                        } else {
                            gapComposer3.skipToGroupEnd();
                        }
                        return Unit.INSTANCE;
                    }
                }, gapComposer2), gapComposer2, 56);
                int i29 = i15;
                keyboardActions2 = keyboardActions3;
                zslControlImpl$$ExternalSyntheticLambda1 = zslControlImpl$$ExternalSyntheticLambda2;
                i12 = i29;
                z5 = z6;
                keyboardOptions3 = keyboardOptions5;
                i13 = i16;
                function5 = function6;
                value = shape2;
                textStyle2 = textStyle3;
            } else {
                gapComposer2 = gapComposer;
                gapComposer2.skipToGroupEnd();
                z5 = z;
                keyboardActions2 = keyboardActions;
                i12 = i;
                i13 = i2;
                function5 = function4;
                keyboardOptions3 = keyboardOptions2;
                textStyle2 = textStyle;
                zslControlImpl$$ExternalSyntheticLambda1 = zslControlImpl$$ExternalSyntheticLambda0;
            }
            recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i3 | 1);
                        OutlinedTextFieldKt.OutlinedTextField(str, function1, modifier, z5, textStyle2, function5, function3, z2, zslControlImpl$$ExternalSyntheticLambda1, keyboardOptions3, keyboardActions2, z3, i12, i13, value, textFieldColors, (GapComposer) obj, iUpdateChangedFlags, i4);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        value = shape;
        int i210 = 6 | c2 | (gapComposer.changed(textFieldColors) ? (char) 256 : (char) 128);
        if ((i5 & 306783379) != 306783378) {
            z4 = true;
        } else {
            z4 = true;
        }
        if (gapComposer.shouldExecute(i5 & 1, z4)) {
            gapComposer.startDefaults();
            if ((i3 & 1) != 0) {
                TextStyle textStyle9 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                if (i19 != 0) {
                    function4 = null;
                }
                if (i9 != 0) {
                    keyboardOptions4 = KeyboardOptions.Default;
                } else {
                    keyboardOptions4 = keyboardOptions2;
                }
                if (z3) {
                    i14 = 1;
                } else {
                    i14 = Integer.MAX_VALUE;
                }
                if ((i4 & 2097152) != 0) {
                    OutlinedTextFieldDefaults outlinedTextFieldDefaults6 = OutlinedTextFieldDefaults.INSTANCE;
                    value = ShapesKt.getValue(5, gapComposer);
                }
                ZslControlImpl$$ExternalSyntheticLambda0 zslControlImpl$$ExternalSyntheticLambda8 = VisualTransformation$Companion.None;
                i15 = i14;
                keyboardActions3 = KeyboardActions.Default;
                keyboardOptions5 = keyboardOptions4;
                zslControlImpl$$ExternalSyntheticLambda2 = zslControlImpl$$ExternalSyntheticLambda8;
                shape2 = value;
                i16 = 1;
                function6 = function4;
                textStyle3 = textStyle9;
                z6 = true;
            } else {
                TextStyle textStyle10 = (TextStyle) gapComposer.consume(TextKt.LocalTextStyle);
                if (i19 != 0) {
                    function4 = null;
                }
                if (i9 != 0) {
                    keyboardOptions4 = KeyboardOptions.Default;
                } else {
                    keyboardOptions4 = keyboardOptions2;
                }
                if (z3) {
                    i14 = 1;
                } else {
                    i14 = Integer.MAX_VALUE;
                }
                if ((i4 & 2097152) != 0) {
                    OutlinedTextFieldDefaults outlinedTextFieldDefaults7 = OutlinedTextFieldDefaults.INSTANCE;
                    value = ShapesKt.getValue(5, gapComposer);
                }
                ZslControlImpl$$ExternalSyntheticLambda0 zslControlImpl$$ExternalSyntheticLambda9 = VisualTransformation$Companion.None;
                i15 = i14;
                keyboardActions3 = KeyboardActions.Default;
                keyboardOptions5 = keyboardOptions4;
                zslControlImpl$$ExternalSyntheticLambda2 = zslControlImpl$$ExternalSyntheticLambda9;
                shape2 = value;
                i16 = 1;
                function6 = function4;
                textStyle3 = textStyle10;
                z6 = true;
            }
            gapComposer.endDefaults();
            gapComposer.startReplaceGroup(1310000147);
            objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == Composer$Companion.Empty) {
                objRememberedValue = new MutableInteractionSourceImpl();
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
            gapComposer.end(false);
            gapComposer.startReplaceGroup(1981926178);
            jM649getColor0d7_KjU = textStyle3.m649getColor0d7_KjU();
            if (jM649getColor0d7_KjU != 16) {
                z7 = false;
            } else {
                zBooleanValue = ((Boolean) ChannelKt.collectIsFocusedAsState(mutableInteractionSourceImpl, gapComposer, 0).getValue()).booleanValue();
                if (!z6) {
                    j = textFieldColors.disabledTextColor;
                } else if (z2) {
                    j = textFieldColors.errorTextColor;
                } else if (zBooleanValue) {
                    j = textFieldColors.focusedTextColor;
                } else {
                    j = textFieldColors.unfocusedTextColor;
                }
                jM649getColor0d7_KjU = j;
                z7 = false;
            }
            long j5 = jM649getColor0d7_KjU;
            gapComposer.end(z7);
            final TextStyle textStyleMerge4 = textStyle3.merge(new TextStyle(j5, 0L, null, 0L, 0, 0L, 16777214));
            gapComposer2 = gapComposer;
            Stack.CompositionLocalProvider(TextSelectionColorsKt.LocalTextSelectionColors.defaultProvidedValue$runtime(textFieldColors.textSelectionColors), Thread_jvmKt.rememberComposableLambda(1874034984, new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    GapComposer gapComposer3 = (GapComposer) obj;
                    int iIntValue = ((Integer) obj2).intValue();
                    if (gapComposer3.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                        gapComposer3.startReplaceGroup(-903106918);
                        gapComposer3.end(false);
                        Modifier modifierThen = modifier.then(Modifier.Companion.$$INSTANCE);
                        String strM282getString2EP1pXo = LayoutUtilKt.m282getString2EP1pXo(R.string.default_error_message, gapComposer3);
                        float f = TextFieldImplKt.TextFieldPadding;
                        final boolean z8 = z2;
                        if (z8) {
                            modifierThen = SemanticsModifierKt.semantics(modifierThen, false, new IconKt$$ExternalSyntheticLambda1(strM282getString2EP1pXo, 6));
                        }
                        Modifier modifierM134defaultMinSizeVpY3zN4 = SizeKt.m134defaultMinSizeVpY3zN4(modifierThen, OutlinedTextFieldDefaults.MinWidth, OutlinedTextFieldDefaults.MinHeight);
                        final TextFieldColors textFieldColors2 = textFieldColors;
                        SolidColor solidColor = new SolidColor(z8 ? textFieldColors2.errorCursorColor : textFieldColors2.cursorColor);
                        final String str2 = str;
                        final boolean z9 = z6;
                        final boolean z10 = z3;
                        final ZslControlImpl$$ExternalSyntheticLambda0 zslControlImpl$$ExternalSyntheticLambda10 = zslControlImpl$$ExternalSyntheticLambda2;
                        final MutableInteractionSourceImpl mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                        final Function2 function7 = function6;
                        final Function2 function8 = function3;
                        final Shape shape3 = shape2;
                        BasicTextFieldKt.BasicTextField(str2, function1, modifierM134defaultMinSizeVpY3zN4, z9, textStyleMerge4, keyboardOptions5, keyboardActions3, z10, i15, i16, zslControlImpl$$ExternalSyntheticLambda10, null, mutableInteractionSourceImpl2, solidColor, Thread_jvmKt.rememberComposableLambda(-1189274459, new Function3() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj3, Object obj4, Object obj5) {
                                Function2 function9 = (Function2) obj3;
                                GapComposer gapComposer4 = (GapComposer) obj4;
                                int iIntValue2 = ((Integer) obj5).intValue();
                                if ((iIntValue2 & 6) == 0) {
                                    iIntValue2 |= gapComposer4.changedInstance(function9) ? 4 : 2;
                                }
                                if (gapComposer4.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                                    int i211 = iIntValue2;
                                    OutlinedTextFieldDefaults outlinedTextFieldDefaults8 = OutlinedTextFieldDefaults.INSTANCE;
                                    boolean z11 = z9;
                                    boolean z12 = z8;
                                    MutableInteractionSourceImpl mutableInteractionSourceImpl3 = mutableInteractionSourceImpl2;
                                    TextFieldColors textFieldColors3 = textFieldColors2;
                                    outlinedTextFieldDefaults8.DecorationBox(str2, function9, z11, z10, zslControlImpl$$ExternalSyntheticLambda10, mutableInteractionSourceImpl3, z12, function7, function8, textFieldColors3, null, Thread_jvmKt.rememberComposableLambda(-656940872, new SwitchKt$$ExternalSyntheticLambda0(z11, z12, mutableInteractionSourceImpl3, textFieldColors3, shape3), gapComposer4), gapComposer4, (i211 << 3) & 112);
                                } else {
                                    gapComposer4.skipToGroupEnd();
                                }
                                return Unit.INSTANCE;
                            }
                        }, gapComposer3), gapComposer3, 0, 4096);
                    } else {
                        gapComposer3.skipToGroupEnd();
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer2), gapComposer2, 56);
            int i211 = i15;
            keyboardActions2 = keyboardActions3;
            zslControlImpl$$ExternalSyntheticLambda1 = zslControlImpl$$ExternalSyntheticLambda2;
            i12 = i211;
            z5 = z6;
            keyboardOptions3 = keyboardOptions5;
            i13 = i16;
            function5 = function6;
            value = shape2;
            textStyle2 = textStyle3;
        } else {
            gapComposer2 = gapComposer;
            gapComposer2.skipToGroupEnd();
            z5 = z;
            keyboardActions2 = keyboardActions;
            i12 = i;
            i13 = i2;
            function5 = function4;
            keyboardOptions3 = keyboardOptions2;
            textStyle2 = textStyle;
            zslControlImpl$$ExternalSyntheticLambda1 = zslControlImpl$$ExternalSyntheticLambda0;
        }
        recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.OutlinedTextFieldKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i3 | 1);
                    OutlinedTextFieldKt.OutlinedTextField(str, function1, modifier, z5, textStyle2, function5, function3, z2, zslControlImpl$$ExternalSyntheticLambda1, keyboardOptions3, keyboardActions2, z3, i12, i13, value, textFieldColors, (GapComposer) obj, iUpdateChangedFlags, i4);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX WARN: Code duplicated, block: B:260:0x0573  */
    /* JADX WARN: Code duplicated, block: B:262:0x0577  */
    /* JADX WARN: Code duplicated, block: B:265:0x05b7  */
    /* JADX WARN: Code duplicated, block: B:266:0x05bb  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v33 */
    /* JADX WARN: Type inference failed for: r13v40 */
    /* JADX WARN: Type inference failed for: r13v9, types: [int] */
    /* JADX WARN: Type inference failed for: r41v0, types: [java.lang.Object, kotlin.jvm.functions.Function3] */
    /* JADX WARN: Type inference failed for: r43v0, types: [java.lang.Object, kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r45v0, types: [java.lang.Object, kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r53v0, types: [androidx.compose.runtime.internal.ComposableLambdaImpl, java.lang.Object] */
    public static final void OutlinedTextFieldLayout(Function2 function2, Function3 function3, Function2 function4, Function2 function5, Function2 function6, Function2 function7, Function2 function8, boolean z, TextFieldLabelPosition$Attached textFieldLabelPosition$Attached, TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0, TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1, TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$2, Function1 function1, ComposableLambdaImpl composableLambdaImpl, Function2 function9, PaddingValues paddingValues, GapComposer gapComposer, int i, int i2) {
        int i3;
        int i4;
        Function2 function10;
        Function2 function11;
        Function2 function12;
        PaddingValues paddingValues2;
        GapComposer gapComposer2;
        float f;
        Object outlinedTextFieldMeasurePolicy;
        char c;
        BiasAlignment biasAlignment;
        GapComposer gapComposer3;
        boolean z2;
        Function2 function13;
        ?? r13;
        BiasAlignment biasAlignment2;
        Function2 function14;
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1;
        int i5;
        Function2 function15;
        BiasAlignment biasAlignment3;
        Function2 function16;
        boolean z3;
        TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$3;
        boolean z4;
        Object objRememberedValue;
        BiasAlignment biasAlignment4 = Alignment.Companion.Center;
        BiasAlignment biasAlignment5 = Alignment.Companion.TopStart;
        gapComposer.startRestartGroup(-401536574);
        int i6 = i & 6;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        if (i6 == 0) {
            i3 = i | (gapComposer.changed(companion) ? 4 : 2);
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= gapComposer.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= gapComposer.changedInstance(function3) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= gapComposer.changedInstance(function4) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= gapComposer.changedInstance(function5) ? 16384 : 8192;
        }
        if ((i & 196608) == 0) {
            i3 |= gapComposer.changedInstance(function6) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i3 |= gapComposer.changedInstance(function7) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= gapComposer.changedInstance(function8) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= gapComposer.changed(z) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= gapComposer.changed(textFieldLabelPosition$Attached) ? 536870912 : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | ((i2 & 8) == 0 ? gapComposer.changed(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0) : gapComposer.changedInstance(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= (i2 & 64) == 0 ? gapComposer.changed(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1) : gapComposer.changedInstance(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= (i2 & 512) == 0 ? gapComposer.changed(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$2) : gapComposer.changedInstance(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$2) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= gapComposer.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= gapComposer.changedInstance(composableLambdaImpl) ? 16384 : 8192;
        }
        if ((i2 & 196608) == 0) {
            i4 |= gapComposer.changedInstance(function9) ? 131072 : 65536;
        }
        if ((i2 & 1572864) == 0) {
            i4 |= gapComposer.changed(paddingValues) ? 1048576 : 524288;
        }
        int i7 = i4;
        if (gapComposer.shouldExecute(i3 & 1, ((i3 & 306783379) == 306783378 && (599187 & i7) == 599186) ? false : true)) {
            float fTextFieldHorizontalIconPadding = TextFieldImplKt.textFieldHorizontalIconPadding(gapComposer);
            int i8 = i7 & 14;
            boolean zChanged = ((i7 & 7168) == 2048) | ((i3 & 234881024) == 67108864) | ((i3 & 1879048192) == 536870912) | (i8 == 4 || ((i7 & 8) != 0 && gapComposer.changed(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0))) | ((i7 & 112) == 32 || ((i7 & 64) != 0 && gapComposer.changed(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1))) | ((i7 & 896) == 256 || ((i7 & 512) != 0 && gapComposer.changed(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$2))) | ((3670016 & i7) == 1048576) | gapComposer.changed(fTextFieldHorizontalIconPadding);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                f = fTextFieldHorizontalIconPadding;
                GapComposer gapComposer4 = gapComposer;
                c = ' ';
                paddingValues2 = paddingValues;
                biasAlignment = biasAlignment4;
                outlinedTextFieldMeasurePolicy = new OutlinedTextFieldMeasurePolicy(function1, z, textFieldLabelPosition$Attached, textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0, textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1, textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$2, paddingValues2, f);
                gapComposer4.updateRememberedValue(outlinedTextFieldMeasurePolicy);
                gapComposer3 = gapComposer4;
            } else {
                gapComposer3 = gapComposer;
                c = ' ';
                paddingValues2 = paddingValues;
                biasAlignment = biasAlignment4;
                f = fTextFieldHorizontalIconPadding;
                outlinedTextFieldMeasurePolicy = objRememberedValue2;
            }
            OutlinedTextFieldMeasurePolicy outlinedTextFieldMeasurePolicy2 = (OutlinedTextFieldMeasurePolicy) outlinedTextFieldMeasurePolicy;
            LayoutDirection layoutDirection = (LayoutDirection) gapComposer3.consume(CompositionLocalsKt.LocalLayoutDirection);
            long j = gapComposer3.compositeKeyHashCode;
            int i9 = (int) (j ^ (j >>> c));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer3.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer3, companion);
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$2 = ComposeUiNode.Companion.Constructor;
            gapComposer3.startReusableNode();
            if (gapComposer3.inserting) {
                gapComposer3.createNode(layoutNode$Companion$Constructor$2);
            } else {
                gapComposer3.useNode();
            }
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$1 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m295setimpl(gapComposer3, outlinedTextFieldMeasurePolicy2, composeUiNode$Companion$SetModifier$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope, composeUiNode$Companion$SetModifier$2);
            Integer numValueOf = Integer.valueOf(i9);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m295setimpl(gapComposer3, numValueOf, composeUiNode$Companion$SetModifier$3);
            OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
            Stack.m294reconcileimpl(gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
            Stack.m295setimpl(gapComposer3, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
            composableLambdaImpl.invoke(gapComposer3, Integer.valueOf((i7 >> 12) & 14));
            if (function5 != 0) {
                gapComposer3.startReplaceGroup(-832882071);
                Modifier modifierThen = RulerKt.layoutId(companion, "Leading").then(MinimumInteractiveModifier.INSTANCE);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                long j2 = gapComposer3.compositeKeyHashCode;
                int i10 = (int) (j2 ^ (j2 >>> c));
                PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer3.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer3, modifierThen);
                gapComposer3.startReusableNode();
                if (gapComposer3.inserting) {
                    gapComposer3.createNode(layoutNode$Companion$Constructor$2);
                } else {
                    gapComposer3.useNode();
                }
                Stack.m295setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy, composeUiNode$Companion$SetModifier$1);
                Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
                ImageAnalysis$$ExternalSyntheticLambda1.m(i10, gapComposer3, composeUiNode$Companion$SetModifier$3, gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$1);
                Stack.m295setimpl(gapComposer3, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
                function5.invoke(gapComposer3, Integer.valueOf((i3 >> 12) & 14));
                gapComposer3.end(true);
                z2 = false;
                gapComposer3.end(false);
            } else {
                z2 = false;
                gapComposer3.startReplaceGroup(-832636055);
                gapComposer3.end(false);
            }
            if (function6 != null) {
                gapComposer3.startReplaceGroup(-832593337);
                Modifier modifierThen2 = RulerKt.layoutId(companion, "Trailing").then(MinimumInteractiveModifier.INSTANCE);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, z2);
                long j3 = gapComposer3.compositeKeyHashCode;
                int i11 = (int) (j3 ^ (j3 >>> c));
                PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope3 = gapComposer3.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier3 = AbsoluteAlignment.materializeModifier(gapComposer3, modifierThen2);
                gapComposer3.startReusableNode();
                if (gapComposer3.inserting) {
                    gapComposer3.createNode(layoutNode$Companion$Constructor$2);
                } else {
                    gapComposer3.useNode();
                }
                Stack.m295setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy2, composeUiNode$Companion$SetModifier$1);
                Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope3, composeUiNode$Companion$SetModifier$2);
                ImageAnalysis$$ExternalSyntheticLambda1.m(i11, gapComposer3, composeUiNode$Companion$SetModifier$3, gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$1);
                Stack.m295setimpl(gapComposer3, modifierMaterializeModifier3, composeUiNode$Companion$SetModifier$4);
                Function2 function17 = function6;
                function17.invoke(gapComposer3, Integer.valueOf((i3 >> 15) & 14));
                gapComposer3.end(true);
                r13 = 0;
                gapComposer3.end(false);
                function13 = function17;
            } else {
                function13 = function6;
                gapComposer3.startReplaceGroup(-832345399);
                gapComposer3.end(z2);
                r13 = z2;
            }
            float fCalculateStartPadding = OffsetKt.calculateStartPadding(paddingValues2, layoutDirection);
            float fCalculateEndPadding = OffsetKt.calculateEndPadding(paddingValues2, layoutDirection);
            if (function5 != 0) {
                fCalculateStartPadding -= f;
                float f2 = (float) r13;
                if (fCalculateStartPadding < f2) {
                    fCalculateStartPadding = f2;
                }
            }
            float f3 = fCalculateStartPadding;
            if (function13 != null) {
                fCalculateEndPadding -= f;
                float f4 = (float) r13;
                if (fCalculateEndPadding < f4) {
                    fCalculateEndPadding = f4;
                }
            }
            if (function7 != 0) {
                gapComposer3.startReplaceGroup(-831641420);
                Modifier modifierM132paddingqDBjuR0$default = OffsetKt.m132paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(RulerKt.layoutId(companion, "Prefix").then(new SizeElement(0.0f, (1 & 1) != 0 ? Float.NaN : TextFieldImplKt.MinTextLineHeight, 0.0f, (1 & 2) != 0 ? Float.NaN : 0.0f, 5))), f3, 0.0f, TextFieldImplKt.PrefixSuffixTextPadding, 0.0f, 10);
                biasAlignment2 = biasAlignment5;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment2, false);
                long j4 = gapComposer3.compositeKeyHashCode;
                int i12 = (int) (j4 ^ (j4 >>> c));
                PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope4 = gapComposer3.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier4 = AbsoluteAlignment.materializeModifier(gapComposer3, modifierM132paddingqDBjuR0$default);
                gapComposer3.startReusableNode();
                if (gapComposer3.inserting) {
                    gapComposer3.createNode(layoutNode$Companion$Constructor$2);
                } else {
                    gapComposer3.useNode();
                }
                Stack.m295setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy3, composeUiNode$Companion$SetModifier$1);
                Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope4, composeUiNode$Companion$SetModifier$2);
                ImageAnalysis$$ExternalSyntheticLambda1.m(i12, gapComposer3, composeUiNode$Companion$SetModifier$3, gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$1);
                Stack.m295setimpl(gapComposer3, modifierMaterializeModifier4, composeUiNode$Companion$SetModifier$4);
                function7.invoke(gapComposer3, Integer.valueOf((i3 >> 18) & 14));
                gapComposer3.end(true);
                gapComposer3.end(false);
            } else {
                biasAlignment2 = r17;
                gapComposer3.startReplaceGroup(-831313719);
                gapComposer3.end(false);
            }
            if (function8 != null) {
                gapComposer3.startReplaceGroup(-831270474);
                Modifier modifierM132paddingqDBjuR0$default2 = OffsetKt.m132paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(RulerKt.layoutId(companion, "Suffix").then(new SizeElement(0.0f, (1 & 1) != 0 ? Float.NaN : TextFieldImplKt.MinTextLineHeight, 0.0f, (1 & 2) != 0 ? Float.NaN : 0.0f, 5))), TextFieldImplKt.PrefixSuffixTextPadding, 0.0f, fCalculateEndPadding, 0.0f, 10);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment2, false);
                layoutNode$Companion$Constructor$1 = layoutNode$Companion$Constructor$2;
                long j5 = gapComposer3.compositeKeyHashCode;
                int i13 = (int) (j5 ^ (j5 >>> c));
                PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope5 = gapComposer3.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier5 = AbsoluteAlignment.materializeModifier(gapComposer3, modifierM132paddingqDBjuR0$default2);
                gapComposer3.startReusableNode();
                if (gapComposer3.inserting) {
                    gapComposer3.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    gapComposer3.useNode();
                }
                Stack.m295setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy4, composeUiNode$Companion$SetModifier$1);
                Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope5, composeUiNode$Companion$SetModifier$2);
                ImageAnalysis$$ExternalSyntheticLambda1.m(i13, gapComposer3, composeUiNode$Companion$SetModifier$3, gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$1);
                Stack.m295setimpl(gapComposer3, modifierMaterializeModifier5, composeUiNode$Companion$SetModifier$4);
                Function2 function18 = function8;
                function18.invoke(gapComposer3, Integer.valueOf((i3 >> 21) & 14));
                gapComposer3.end(true);
                i5 = 0;
                gapComposer3.end(false);
                function14 = function18;
            } else {
                function14 = function8;
                layoutNode$Companion$Constructor$1 = layoutNode$Companion$Constructor$2;
                i5 = 0;
                gapComposer3.startReplaceGroup(-830944695);
                gapComposer3.end(false);
            }
            Modifier modifierM132paddingqDBjuR0$default3 = OffsetKt.m132paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(companion.then(new SizeElement(0.0f, (1 & 1) != 0 ? Float.NaN : TextFieldImplKt.MinTextLineHeight, 0.0f, (1 & 2) != 0 ? Float.NaN : 0.0f, 5))), function7 == 0 ? f3 : i5, 0.0f, function14 == null ? fCalculateEndPadding : i5, 0.0f, 10);
            if (function3 != 0) {
                gapComposer3.startReplaceGroup(-830574710);
                function3.invoke(RulerKt.layoutId(companion, "Hint").then(modifierM132paddingqDBjuR0$default3), gapComposer3, Integer.valueOf((i3 >> 3) & 112));
                gapComposer3.end(false);
            } else {
                gapComposer3.startReplaceGroup(-830483415);
                gapComposer3.end(false);
            }
            Modifier modifierThen3 = RulerKt.layoutId(companion, "TextField").then(modifierM132paddingqDBjuR0$default3);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment2, true);
            BiasAlignment biasAlignment6 = biasAlignment2;
            long j6 = gapComposer3.compositeKeyHashCode;
            int i14 = (int) (j6 ^ (j6 >>> c));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope6 = gapComposer3.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier6 = AbsoluteAlignment.materializeModifier(gapComposer3, modifierThen3);
            gapComposer3.startReusableNode();
            if (gapComposer3.inserting) {
                gapComposer3.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer3.useNode();
            }
            Stack.m295setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy5, composeUiNode$Companion$SetModifier$1);
            Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope6, composeUiNode$Companion$SetModifier$2);
            ImageAnalysis$$ExternalSyntheticLambda1.m(i14, gapComposer3, composeUiNode$Companion$SetModifier$3, gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$1);
            Stack.m295setimpl(gapComposer3, modifierMaterializeModifier6, composeUiNode$Companion$SetModifier$4);
            Function2 function19 = function2;
            function19.invoke(gapComposer3, Integer.valueOf((i3 >> 3) & 14));
            gapComposer3.end(true);
            if (function4 != null) {
                gapComposer3.startReplaceGroup(-829830834);
                if (i8 != 4) {
                    if ((i7 & 8) != 0) {
                        textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$3 = textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0;
                        if (gapComposer3.changedInstance(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$3)) {
                        }
                        objRememberedValue = gapComposer3.rememberedValue();
                        if (z4 || objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = new TextFieldKt$$ExternalSyntheticLambda0(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$3, 1);
                            gapComposer3.updateRememberedValue(objRememberedValue);
                        }
                        Modifier modifierThen4 = RulerKt.layoutId(SizeKt.wrapContentHeight$default(RulerKt.layout(companion, new SheetDefaultsKt$$ExternalSyntheticLambda5(5, (Function0) objRememberedValue))), "Label").then(companion);
                        biasAlignment3 = biasAlignment6;
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment3, false);
                        long j7 = gapComposer3.compositeKeyHashCode;
                        int i15 = (int) (j7 ^ (j7 >>> c));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope7 = gapComposer3.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier7 = AbsoluteAlignment.materializeModifier(gapComposer3, modifierThen4);
                        gapComposer3.startReusableNode();
                        if (gapComposer3.inserting) {
                            gapComposer3.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer3.useNode();
                        }
                        Stack.m295setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy6, composeUiNode$Companion$SetModifier$1);
                        Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope7, composeUiNode$Companion$SetModifier$2);
                        ImageAnalysis$$ExternalSyntheticLambda1.m(i15, gapComposer3, composeUiNode$Companion$SetModifier$3, gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$1);
                        Stack.m295setimpl(gapComposer3, modifierMaterializeModifier7, composeUiNode$Companion$SetModifier$4);
                        Function2 function20 = function4;
                        function20.invoke(gapComposer3, Integer.valueOf((i3 >> 9) & 14));
                        gapComposer3.end(true);
                        gapComposer3.end(false);
                        function15 = function20;
                    } else {
                        textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$3 = textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0;
                    }
                    z4 = false;
                    objRememberedValue = gapComposer3.rememberedValue();
                    if (z4) {
                        objRememberedValue = new TextFieldKt$$ExternalSyntheticLambda0(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$3, 1);
                        gapComposer3.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new TextFieldKt$$ExternalSyntheticLambda0(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$3, 1);
                        gapComposer3.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierThen5 = RulerKt.layoutId(SizeKt.wrapContentHeight$default(RulerKt.layout(companion, new SheetDefaultsKt$$ExternalSyntheticLambda5(5, (Function0) objRememberedValue))), "Label").then(companion);
                    biasAlignment3 = biasAlignment6;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment3, false);
                    long j8 = gapComposer3.compositeKeyHashCode;
                    int i16 = (int) (j8 ^ (j8 >>> c));
                    PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope8 = gapComposer3.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier8 = AbsoluteAlignment.materializeModifier(gapComposer3, modifierThen5);
                    gapComposer3.startReusableNode();
                    if (gapComposer3.inserting) {
                        gapComposer3.createNode(layoutNode$Companion$Constructor$1);
                    } else {
                        gapComposer3.useNode();
                    }
                    Stack.m295setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy7, composeUiNode$Companion$SetModifier$1);
                    Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope8, composeUiNode$Companion$SetModifier$2);
                    ImageAnalysis$$ExternalSyntheticLambda1.m(i16, gapComposer3, composeUiNode$Companion$SetModifier$3, gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$1);
                    Stack.m295setimpl(gapComposer3, modifierMaterializeModifier8, composeUiNode$Companion$SetModifier$4);
                    Function2 function21 = function4;
                    function21.invoke(gapComposer3, Integer.valueOf((i3 >> 9) & 14));
                    gapComposer3.end(true);
                    gapComposer3.end(false);
                    function15 = function21;
                } else {
                    textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$3 = textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0;
                }
                z4 = true;
                objRememberedValue = gapComposer3.rememberedValue();
                if (z4) {
                    objRememberedValue = new TextFieldKt$$ExternalSyntheticLambda0(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$3, 1);
                    gapComposer3.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new TextFieldKt$$ExternalSyntheticLambda0(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$3, 1);
                    gapComposer3.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierThen6 = RulerKt.layoutId(SizeKt.wrapContentHeight$default(RulerKt.layout(companion, new SheetDefaultsKt$$ExternalSyntheticLambda5(5, (Function0) objRememberedValue))), "Label").then(companion);
                biasAlignment3 = biasAlignment6;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy8 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment3, false);
                long j9 = gapComposer3.compositeKeyHashCode;
                int i17 = (int) (j9 ^ (j9 >>> c));
                PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope9 = gapComposer3.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier9 = AbsoluteAlignment.materializeModifier(gapComposer3, modifierThen6);
                gapComposer3.startReusableNode();
                if (gapComposer3.inserting) {
                    gapComposer3.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    gapComposer3.useNode();
                }
                Stack.m295setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy8, composeUiNode$Companion$SetModifier$1);
                Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope9, composeUiNode$Companion$SetModifier$2);
                ImageAnalysis$$ExternalSyntheticLambda1.m(i17, gapComposer3, composeUiNode$Companion$SetModifier$3, gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$1);
                Stack.m295setimpl(gapComposer3, modifierMaterializeModifier9, composeUiNode$Companion$SetModifier$4);
                Function2 function22 = function4;
                function22.invoke(gapComposer3, Integer.valueOf((i3 >> 9) & 14));
                gapComposer3.end(true);
                gapComposer3.end(false);
                function15 = function22;
            } else {
                function15 = function4;
                biasAlignment3 = biasAlignment6;
                gapComposer3.startReplaceGroup(-829435863);
                gapComposer3.end(false);
            }
            if (function9 != null) {
                gapComposer3.startReplaceGroup(-829387348);
                Modifier modifierPadding = OffsetKt.padding(SizeKt.wrapContentHeight$default(RulerKt.layoutId(companion, "Supporting").then(new SizeElement(0.0f, (1 & 1) != 0 ? Float.NaN : TextFieldImplKt.MinSupportingTextLineHeight, 0.0f, (1 & 2) != 0 ? Float.NaN : 0.0f, 5))), TextFieldDefaults.m273supportingTextPaddinga9UjIt4$material3$default());
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy9 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment3, false);
                long j10 = gapComposer3.compositeKeyHashCode;
                int i18 = (int) (j10 ^ (j10 >>> c));
                PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope10 = gapComposer3.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier10 = AbsoluteAlignment.materializeModifier(gapComposer3, modifierPadding);
                gapComposer3.startReusableNode();
                if (gapComposer3.inserting) {
                    gapComposer3.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    gapComposer3.useNode();
                }
                Stack.m295setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy9, composeUiNode$Companion$SetModifier$1);
                Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope10, composeUiNode$Companion$SetModifier$2);
                ImageAnalysis$$ExternalSyntheticLambda1.m(i18, gapComposer3, composeUiNode$Companion$SetModifier$3, gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$1);
                Stack.m295setimpl(gapComposer3, modifierMaterializeModifier10, composeUiNode$Companion$SetModifier$4);
                Function2 function23 = function9;
                function23.invoke(gapComposer3, Integer.valueOf((i7 >> 15) & 14));
                z3 = true;
                gapComposer3.end(true);
                gapComposer3.end(false);
                function16 = function23;
            } else {
                function16 = function9;
                z3 = true;
                gapComposer3.startReplaceGroup(-829051959);
                gapComposer3.end(false);
            }
            gapComposer3.end(z3);
            function11 = function15;
            gapComposer2 = gapComposer3;
            function10 = function19;
            function12 = function16;
        } else {
            function10 = function2;
            function11 = function4;
            function12 = function9;
            paddingValues2 = paddingValues;
            GapComposer gapComposer5 = gapComposer;
            gapComposer5.skipToGroupEnd();
            gapComposer2 = gapComposer5;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new OutlinedTextFieldKt$$ExternalSyntheticLambda1(function10, (Function3) function3, function11, (Function2) function5, function6, (Function2) function7, function8, z, textFieldLabelPosition$Attached, textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0, textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1, textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$2, function1, (ComposableLambdaImpl) composableLambdaImpl, function12, paddingValues2, i, i2);
        }
    }
}
