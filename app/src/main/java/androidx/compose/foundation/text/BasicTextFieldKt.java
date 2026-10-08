package androidx.compose.foundation.text;

import androidx.camera.camera2.internal.ZslControlImpl$$ExternalSyntheticLambda0;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation$Companion;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.unit.DpKt;
import androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda1;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class BasicTextFieldKt {
    static {
        float f = 40;
        DpKt.m706DpSizeYgX7TsA(f, f);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x013a  */
    /* JADX WARN: Code duplicated, block: B:104:0x0145  */
    /* JADX WARN: Code duplicated, block: B:107:0x0157  */
    /* JADX WARN: Code duplicated, block: B:111:0x0164  */
    /* JADX WARN: Code duplicated, block: B:114:0x016d  */
    /* JADX WARN: Code duplicated, block: B:116:0x017b  */
    /* JADX WARN: Code duplicated, block: B:124:0x01a5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:125:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:127:0x01aa  */
    /* JADX WARN: Code duplicated, block: B:128:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:130:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:133:0x01b7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:134:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:135:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:137:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:139:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:140:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:142:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:143:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:146:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:149:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:150:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:154:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:157:0x0230 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:158:0x0232  */
    /* JADX WARN: Code duplicated, block: B:161:0x0245  */
    /* JADX WARN: Code duplicated, block: B:162:0x0247  */
    /* JADX WARN: Code duplicated, block: B:165:0x024e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:166:0x0250  */
    /* JADX WARN: Code duplicated, block: B:169:0x0267  */
    /* JADX WARN: Code duplicated, block: B:171:0x026b  */
    /* JADX WARN: Code duplicated, block: B:172:0x026e  */
    /* JADX WARN: Code duplicated, block: B:175:0x027b  */
    /* JADX WARN: Code duplicated, block: B:176:0x027e  */
    /* JADX WARN: Code duplicated, block: B:178:0x0282  */
    /* JADX WARN: Code duplicated, block: B:180:0x0287  */
    /* JADX WARN: Code duplicated, block: B:183:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:184:0x02a4  */
    /* JADX WARN: Code duplicated, block: B:186:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:187:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:190:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:191:0x02ba  */
    /* JADX WARN: Code duplicated, block: B:194:0x02c2 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:195:0x02c4  */
    /* JADX WARN: Code duplicated, block: B:197:0x031f  */
    /* JADX WARN: Code duplicated, block: B:200:0x0334  */
    /* JADX WARN: Code duplicated, block: B:202:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x0062  */
    /* JADX WARN: Code duplicated, block: B:35:0x0067  */
    /* JADX WARN: Code duplicated, block: B:37:0x006e  */
    /* JADX WARN: Code duplicated, block: B:38:0x0071  */
    /* JADX WARN: Code duplicated, block: B:42:0x007b  */
    /* JADX WARN: Code duplicated, block: B:43:0x007e  */
    /* JADX WARN: Code duplicated, block: B:46:0x0088  */
    /* JADX WARN: Code duplicated, block: B:47:0x008d  */
    /* JADX WARN: Code duplicated, block: B:49:0x0093  */
    /* JADX WARN: Code duplicated, block: B:51:0x0099  */
    /* JADX WARN: Code duplicated, block: B:52:0x009c  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:74:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:79:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:81:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:82:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:86:0x0105  */
    /* JADX WARN: Code duplicated, block: B:88:0x010c  */
    /* JADX WARN: Code duplicated, block: B:90:0x0116  */
    /* JADX WARN: Code duplicated, block: B:91:0x0119  */
    /* JADX WARN: Code duplicated, block: B:95:0x0126  */
    /* JADX WARN: Code duplicated, block: B:97:0x012f  */
    /* JADX WARN: Code duplicated, block: B:99:0x0137  */
    public static final void BasicTextField(String str, Function1 function1, Modifier modifier, boolean z, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z2, int i, int i2, ZslControlImpl$$ExternalSyntheticLambda0 zslControlImpl$$ExternalSyntheticLambda0, Function1 function2, MutableInteractionSourceImpl mutableInteractionSourceImpl, SolidColor solidColor, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i3, int i4) {
        boolean z3;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        KeyboardOptions keyboardOptions2;
        int i10;
        int i11;
        KeyboardActions keyboardActions2;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        boolean z4;
        int i28;
        ZslControlImpl$$ExternalSyntheticLambda0 zslControlImpl$$ExternalSyntheticLambda1;
        MutableInteractionSourceImpl mutableInteractionSourceImpl2;
        KeyboardOptions keyboardOptions3;
        int i29;
        KeyboardActions keyboardActions3;
        boolean z5;
        Function1 function3;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        int i30;
        Object obj;
        KeyboardOptions keyboardOptions4;
        int i31;
        int i32;
        int i33;
        ZslControlImpl$$ExternalSyntheticLambda0 zslControlImpl$$ExternalSyntheticLambda2;
        Object objRememberedValue;
        MutableInteractionSourceImpl mutableInteractionSourceImpl3;
        KeyboardOptions keyboardOptions5;
        int i34;
        Object objRememberedValue2;
        MutableState mutableState;
        TextFieldValue textFieldValue;
        int i35;
        boolean zChanged;
        Object objRememberedValue3;
        boolean z6;
        Object objRememberedValue4;
        MutableState mutableState2;
        int i36;
        KeyboardType keyboardType;
        int i37;
        int i38;
        ImeAction imeAction;
        ImeAction imeAction2;
        int i39;
        int i40;
        int i41;
        boolean z7;
        boolean z8;
        Object objRememberedValue5;
        int i42;
        gapComposer.startRestartGroup(2026950908);
        int i43 = (gapComposer.changed(str) ? 4 : 2) | i3;
        if ((i3 & 48) == 0) {
            i43 |= gapComposer.changedInstance(function1) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i43 |= gapComposer.changed(modifier) ? 256 : 128;
        }
        int i44 = i4 & 8;
        if (i44 == 0) {
            if ((i3 & 3072) == 0) {
                z3 = z;
                i43 |= gapComposer.changed(z3) ? 2048 : 1024;
            }
            if ((i4 & 16) != 0) {
                i6 = i43 | 24576;
            } else {
                if (gapComposer.changed(false)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i6 = i43 | i5;
            }
            if (gapComposer.changed(textStyle)) {
                i7 = 131072;
            } else {
                i7 = 65536;
            }
            i8 = i6 | i7;
            i9 = i4 & 64;
            if (i9 != 0) {
                i8 |= 1572864;
                keyboardOptions2 = keyboardOptions;
            } else {
                keyboardOptions2 = keyboardOptions;
                if ((i3 & 1572864) == 0) {
                    if (gapComposer.changed(keyboardOptions2)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i8 |= i10;
                }
            }
            i11 = i4 & 128;
            if (i11 != 0) {
                i13 = i8 | 12582912;
                keyboardActions2 = keyboardActions;
            } else {
                keyboardActions2 = keyboardActions;
                if (gapComposer.changed(keyboardActions2)) {
                    i12 = 8388608;
                } else {
                    i12 = 4194304;
                }
                i13 = i8 | i12;
            }
            if ((i3 & 100663296) == 0) {
                if (gapComposer.changed(z2)) {
                    i42 = 67108864;
                } else {
                    i42 = 33554432;
                }
                i13 |= i42;
            }
            if ((i4 & 512) == 0) {
                i14 = i;
                int i45 = gapComposer.changed(i14) ? 536870912 : 268435456;
                i15 = i13 | i45;
                i16 = i4 & 1024;
                if (i16 != 0) {
                    i18 = 196614;
                } else {
                    if (gapComposer.changed(i2)) {
                        i17 = 4;
                    } else {
                        i17 = 2;
                    }
                    i18 = 196608 | i17;
                }
                i19 = i4 & 2048;
                if (i19 != 0) {
                    i21 = i18 | 48;
                } else {
                    if (gapComposer.changed(zslControlImpl$$ExternalSyntheticLambda0)) {
                        i20 = 32;
                    } else {
                        i20 = 16;
                    }
                    i21 = i18 | i20;
                }
                i22 = i21;
                i23 = i22 | 384;
                i24 = i4 & 8192;
                if (i24 != 0) {
                    i26 = i22 | 3456;
                } else {
                    if (gapComposer.changed(mutableInteractionSourceImpl)) {
                        i25 = 2048;
                    } else {
                        i25 = 1024;
                    }
                    i26 = i23 | i25;
                }
                i27 = i26 | (gapComposer.changed(solidColor) ? 16384 : 8192);
                if ((i15 & 306783379) == 306783378 || (i27 & 74899) != 74898) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (gapComposer.shouldExecute(i15 & 1, z4)) {
                    gapComposer.startDefaults();
                    i30 = i3 & 1;
                    obj = Composer$Companion.Empty;
                    if (i30 != 0 || gapComposer.getDefaultsInvalid()) {
                        if (i44 != 0) {
                            z3 = true;
                        }
                        if (i9 != 0) {
                            keyboardOptions4 = KeyboardOptions.Default;
                        } else {
                            keyboardOptions4 = keyboardOptions2;
                        }
                        if (i11 != 0) {
                            keyboardActions2 = KeyboardActions.Default;
                        }
                        if ((i4 & 512) != 0) {
                            if (z2) {
                                i31 = 1;
                            } else {
                                i31 = Integer.MAX_VALUE;
                            }
                            i32 = i15 & (-1879048193);
                        } else {
                            i31 = i14;
                            i32 = i15;
                        }
                        if (i16 != 0) {
                            i33 = 1;
                        } else {
                            i33 = i2;
                        }
                        if (i19 != 0) {
                            zslControlImpl$$ExternalSyntheticLambda2 = VisualTransformation$Companion.None;
                        } else {
                            zslControlImpl$$ExternalSyntheticLambda2 = zslControlImpl$$ExternalSyntheticLambda0;
                        }
                        objRememberedValue = gapComposer.rememberedValue();
                        if (objRememberedValue == obj) {
                            objRememberedValue = new BasicTextKt$$ExternalSyntheticLambda3(17);
                            gapComposer.updateRememberedValue(objRememberedValue);
                        }
                        Function1 function4 = (Function1) objRememberedValue;
                        if (i24 != 0) {
                            mutableInteractionSourceImpl3 = null;
                        } else {
                            mutableInteractionSourceImpl3 = mutableInteractionSourceImpl;
                        }
                        function2 = function4;
                        mutableInteractionSourceImpl = mutableInteractionSourceImpl3;
                        i14 = i31;
                        i2 = i33;
                        zslControlImpl$$ExternalSyntheticLambda0 = zslControlImpl$$ExternalSyntheticLambda2;
                        keyboardOptions5 = keyboardOptions4;
                        i34 = i32;
                    } else {
                        gapComposer.skipToGroupEnd();
                        i34 = (i4 & 512) != 0 ? i15 & (-1879048193) : i15;
                        keyboardOptions5 = keyboardOptions2;
                    }
                    gapComposer.endDefaults();
                    objRememberedValue2 = gapComposer.rememberedValue();
                    if (objRememberedValue2 == obj) {
                        objRememberedValue2 = Stack.mutableStateOf$default(new TextFieldValue(6, 0L, str));
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    TextFieldValue textFieldValue2 = (TextFieldValue) mutableState.getValue();
                    i35 = i34;
                    textFieldValue = new TextFieldValue(new AnnotatedString(str), textFieldValue2.selection, textFieldValue2.composition);
                    zChanged = gapComposer.changed(textFieldValue);
                    objRememberedValue3 = gapComposer.rememberedValue();
                    if (zChanged || objRememberedValue3 == obj) {
                        objRememberedValue3 = new Recomposer$$ExternalSyntheticLambda6(7, textFieldValue, mutableState);
                        gapComposer.updateRememberedValue(objRememberedValue3);
                    }
                    Stack.SideEffect((Function0) objRememberedValue3, gapComposer);
                    if ((i35 & 14) == 4) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    objRememberedValue4 = gapComposer.rememberedValue();
                    if (z6 || objRememberedValue4 == obj) {
                        objRememberedValue4 = Stack.mutableStateOf$default(str);
                        gapComposer.updateRememberedValue(objRememberedValue4);
                    }
                    mutableState2 = (MutableState) objRememberedValue4;
                    keyboardOptions5.getClass();
                    i36 = keyboardOptions5.keyboardType;
                    keyboardType = new KeyboardType(i36);
                    if (i36 == 0) {
                        keyboardType = null;
                    }
                    if (keyboardType != null) {
                        i37 = keyboardType.value;
                    } else {
                        i37 = 1;
                    }
                    i38 = keyboardOptions5.imeAction;
                    imeAction = new ImeAction(i38);
                    if (i38 == -1) {
                        imeAction2 = null;
                    }
                    if (imeAction2 != null) {
                        imeAction2 = imeAction;
                        i39 = imeAction2.value;
                    } else {
                        imeAction2 = imeAction;
                        i39 = 1;
                    }
                    KeyboardOptions keyboardOptions6 = keyboardOptions5;
                    ImeOptions imeOptions = new ImeOptions(z2, 0, true, i37, i39, LocaleList.Empty);
                    boolean z9 = !z2;
                    if (z2) {
                        i40 = 1;
                    } else {
                        i40 = i2;
                    }
                    if (z2) {
                        i41 = 1;
                    } else {
                        i41 = i14;
                    }
                    boolean zChanged2 = gapComposer.changed(mutableState2);
                    if ((i35 & 112) == 32) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    z8 = z7 | zChanged2;
                    objRememberedValue5 = gapComposer.rememberedValue();
                    if (z8 || objRememberedValue5 == obj) {
                        objRememberedValue5 = new LifecycleEffectKt$$ExternalSyntheticLambda1(function1, mutableState, mutableState2);
                        gapComposer.updateRememberedValue(objRememberedValue5);
                    }
                    int i46 = i27 << 9;
                    int i47 = i41;
                    boolean z10 = z3;
                    ZslControlImpl$$ExternalSyntheticLambda0 zslControlImpl$$ExternalSyntheticLambda3 = zslControlImpl$$ExternalSyntheticLambda0;
                    Function1 function5 = function2;
                    MutableInteractionSourceImpl mutableInteractionSourceImpl4 = mutableInteractionSourceImpl;
                    KeyboardActions keyboardActions4 = keyboardActions2;
                    BasicTextKt.CoreTextField(textFieldValue, (Function1) objRememberedValue5, modifier, textStyle, zslControlImpl$$ExternalSyntheticLambda3, function5, mutableInteractionSourceImpl4, solidColor, z9, i47, i40, imeOptions, keyboardActions4, z10, composableLambdaImpl, gapComposer, (i35 & 896) | ((i35 >> 6) & 7168) | (i46 & 57344) | 196608 | (3670016 & i46) | (i46 & 29360128), (i35 & 57344) | ((i35 >> 15) & 896) | (i35 & 7168) | 196608);
                    keyboardOptions3 = keyboardOptions6;
                    zslControlImpl$$ExternalSyntheticLambda1 = zslControlImpl$$ExternalSyntheticLambda3;
                    function3 = function5;
                    mutableInteractionSourceImpl2 = mutableInteractionSourceImpl4;
                    keyboardActions3 = keyboardActions4;
                    z5 = z10;
                    i29 = i14;
                    i28 = i2;
                } else {
                    gapComposer.skipToGroupEnd();
                    i28 = i2;
                    zslControlImpl$$ExternalSyntheticLambda1 = zslControlImpl$$ExternalSyntheticLambda0;
                    mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                    keyboardOptions3 = keyboardOptions2;
                    i29 = i14;
                    keyboardActions3 = keyboardActions2;
                    z5 = z3;
                    function3 = function2;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new CoreTextFieldKt$$ExternalSyntheticLambda6(str, function1, modifier, z5, textStyle, keyboardOptions3, keyboardActions3, z2, i29, i28, zslControlImpl$$ExternalSyntheticLambda1, function3, mutableInteractionSourceImpl2, solidColor, composableLambdaImpl, i3, i4);
                }
            }
            i14 = i;
            i15 = i13 | i45;
            i16 = i4 & 1024;
            if (i16 != 0) {
                i18 = 196614;
            } else {
                if (gapComposer.changed(i2)) {
                    i17 = 4;
                } else {
                    i17 = 2;
                }
                i18 = 196608 | i17;
            }
            i19 = i4 & 2048;
            if (i19 != 0) {
                i21 = i18 | 48;
            } else {
                if (gapComposer.changed(zslControlImpl$$ExternalSyntheticLambda0)) {
                    i20 = 32;
                } else {
                    i20 = 16;
                }
                i21 = i18 | i20;
            }
            i22 = i21;
            i23 = i22 | 384;
            i24 = i4 & 8192;
            if (i24 != 0) {
                i26 = i22 | 3456;
            } else {
                if (gapComposer.changed(mutableInteractionSourceImpl)) {
                    i25 = 2048;
                } else {
                    i25 = 1024;
                }
                i26 = i23 | i25;
            }
            i27 = i26 | (gapComposer.changed(solidColor) ? 16384 : 8192);
            if ((i15 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (gapComposer.shouldExecute(i15 & 1, z4)) {
                gapComposer.startDefaults();
                i30 = i3 & 1;
                obj = Composer$Companion.Empty;
                if (i30 != 0) {
                    if (i44 != 0) {
                        z3 = true;
                    }
                    if (i9 != 0) {
                        keyboardOptions4 = KeyboardOptions.Default;
                    } else {
                        keyboardOptions4 = keyboardOptions2;
                    }
                    if (i11 != 0) {
                        keyboardActions2 = KeyboardActions.Default;
                    }
                    if ((i4 & 512) != 0) {
                        if (z2) {
                            i31 = 1;
                        } else {
                            i31 = Integer.MAX_VALUE;
                        }
                        i32 = i15 & (-1879048193);
                    } else {
                        i31 = i14;
                        i32 = i15;
                    }
                    if (i16 != 0) {
                        i33 = 1;
                    } else {
                        i33 = i2;
                    }
                    if (i19 != 0) {
                        zslControlImpl$$ExternalSyntheticLambda2 = VisualTransformation$Companion.None;
                    } else {
                        zslControlImpl$$ExternalSyntheticLambda2 = zslControlImpl$$ExternalSyntheticLambda0;
                    }
                    objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == obj) {
                        objRememberedValue = new BasicTextKt$$ExternalSyntheticLambda3(17);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    Function1 function6 = (Function1) objRememberedValue;
                    if (i24 != 0) {
                        mutableInteractionSourceImpl3 = null;
                    } else {
                        mutableInteractionSourceImpl3 = mutableInteractionSourceImpl;
                    }
                    function2 = function6;
                    mutableInteractionSourceImpl = mutableInteractionSourceImpl3;
                    i14 = i31;
                    i2 = i33;
                    zslControlImpl$$ExternalSyntheticLambda0 = zslControlImpl$$ExternalSyntheticLambda2;
                    keyboardOptions5 = keyboardOptions4;
                    i34 = i32;
                } else {
                    if (i44 != 0) {
                        z3 = true;
                    }
                    if (i9 != 0) {
                        keyboardOptions4 = KeyboardOptions.Default;
                    } else {
                        keyboardOptions4 = keyboardOptions2;
                    }
                    if (i11 != 0) {
                        keyboardActions2 = KeyboardActions.Default;
                    }
                    if ((i4 & 512) != 0) {
                        if (z2) {
                            i31 = 1;
                        } else {
                            i31 = Integer.MAX_VALUE;
                        }
                        i32 = i15 & (-1879048193);
                    } else {
                        i31 = i14;
                        i32 = i15;
                    }
                    if (i16 != 0) {
                        i33 = 1;
                    } else {
                        i33 = i2;
                    }
                    if (i19 != 0) {
                        zslControlImpl$$ExternalSyntheticLambda2 = VisualTransformation$Companion.None;
                    } else {
                        zslControlImpl$$ExternalSyntheticLambda2 = zslControlImpl$$ExternalSyntheticLambda0;
                    }
                    objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == obj) {
                        objRememberedValue = new BasicTextKt$$ExternalSyntheticLambda3(17);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    Function1 function7 = (Function1) objRememberedValue;
                    if (i24 != 0) {
                        mutableInteractionSourceImpl3 = null;
                    } else {
                        mutableInteractionSourceImpl3 = mutableInteractionSourceImpl;
                    }
                    function2 = function7;
                    mutableInteractionSourceImpl = mutableInteractionSourceImpl3;
                    i14 = i31;
                    i2 = i33;
                    zslControlImpl$$ExternalSyntheticLambda0 = zslControlImpl$$ExternalSyntheticLambda2;
                    keyboardOptions5 = keyboardOptions4;
                    i34 = i32;
                }
                gapComposer.endDefaults();
                objRememberedValue2 = gapComposer.rememberedValue();
                if (objRememberedValue2 == obj) {
                    objRememberedValue2 = Stack.mutableStateOf$default(new TextFieldValue(6, 0L, str));
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                mutableState = (MutableState) objRememberedValue2;
                TextFieldValue textFieldValue3 = (TextFieldValue) mutableState.getValue();
                i35 = i34;
                textFieldValue = new TextFieldValue(new AnnotatedString(str), textFieldValue3.selection, textFieldValue3.composition);
                zChanged = gapComposer.changed(textFieldValue);
                objRememberedValue3 = gapComposer.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = new Recomposer$$ExternalSyntheticLambda6(7, textFieldValue, mutableState);
                    gapComposer.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Recomposer$$ExternalSyntheticLambda6(7, textFieldValue, mutableState);
                    gapComposer.updateRememberedValue(objRememberedValue3);
                }
                Stack.SideEffect((Function0) objRememberedValue3, gapComposer);
                if ((i35 & 14) == 4) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                objRememberedValue4 = gapComposer.rememberedValue();
                if (z6) {
                    objRememberedValue4 = Stack.mutableStateOf$default(str);
                    gapComposer.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = Stack.mutableStateOf$default(str);
                    gapComposer.updateRememberedValue(objRememberedValue4);
                }
                mutableState2 = (MutableState) objRememberedValue4;
                keyboardOptions5.getClass();
                i36 = keyboardOptions5.keyboardType;
                keyboardType = new KeyboardType(i36);
                if (i36 == 0) {
                    keyboardType = null;
                }
                if (keyboardType != null) {
                    i37 = keyboardType.value;
                } else {
                    i37 = 1;
                }
                i38 = keyboardOptions5.imeAction;
                imeAction = new ImeAction(i38);
                if (i38 == -1) {
                    imeAction2 = null;
                }
                if (imeAction2 != null) {
                    imeAction2 = imeAction;
                    i39 = imeAction2.value;
                } else {
                    imeAction2 = imeAction;
                    i39 = 1;
                }
                KeyboardOptions keyboardOptions7 = keyboardOptions5;
                ImeOptions imeOptions2 = new ImeOptions(z2, 0, true, i37, i39, LocaleList.Empty);
                boolean z11 = !z2;
                if (z2) {
                    i40 = 1;
                } else {
                    i40 = i2;
                }
                if (z2) {
                    i41 = 1;
                } else {
                    i41 = i14;
                }
                boolean zChanged3 = gapComposer.changed(mutableState2);
                if ((i35 & 112) == 32) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                z8 = z7 | zChanged3;
                objRememberedValue5 = gapComposer.rememberedValue();
                if (z8) {
                    objRememberedValue5 = new LifecycleEffectKt$$ExternalSyntheticLambda1(function1, mutableState, mutableState2);
                    gapComposer.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new LifecycleEffectKt$$ExternalSyntheticLambda1(function1, mutableState, mutableState2);
                    gapComposer.updateRememberedValue(objRememberedValue5);
                }
                int i48 = i27 << 9;
                int i49 = i41;
                boolean z12 = z3;
                ZslControlImpl$$ExternalSyntheticLambda0 zslControlImpl$$ExternalSyntheticLambda4 = zslControlImpl$$ExternalSyntheticLambda0;
                Function1 function8 = function2;
                MutableInteractionSourceImpl mutableInteractionSourceImpl5 = mutableInteractionSourceImpl;
                KeyboardActions keyboardActions5 = keyboardActions2;
                BasicTextKt.CoreTextField(textFieldValue, (Function1) objRememberedValue5, modifier, textStyle, zslControlImpl$$ExternalSyntheticLambda4, function8, mutableInteractionSourceImpl5, solidColor, z11, i49, i40, imeOptions2, keyboardActions5, z12, composableLambdaImpl, gapComposer, (i35 & 896) | ((i35 >> 6) & 7168) | (i48 & 57344) | 196608 | (3670016 & i48) | (i48 & 29360128), (i35 & 57344) | ((i35 >> 15) & 896) | (i35 & 7168) | 196608);
                keyboardOptions3 = keyboardOptions7;
                zslControlImpl$$ExternalSyntheticLambda1 = zslControlImpl$$ExternalSyntheticLambda4;
                function3 = function8;
                mutableInteractionSourceImpl2 = mutableInteractionSourceImpl5;
                keyboardActions3 = keyboardActions5;
                z5 = z12;
                i29 = i14;
                i28 = i2;
            } else {
                gapComposer.skipToGroupEnd();
                i28 = i2;
                zslControlImpl$$ExternalSyntheticLambda1 = zslControlImpl$$ExternalSyntheticLambda0;
                mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                keyboardOptions3 = keyboardOptions2;
                i29 = i14;
                keyboardActions3 = keyboardActions2;
                z5 = z3;
                function3 = function2;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new CoreTextFieldKt$$ExternalSyntheticLambda6(str, function1, modifier, z5, textStyle, keyboardOptions3, keyboardActions3, z2, i29, i28, zslControlImpl$$ExternalSyntheticLambda1, function3, mutableInteractionSourceImpl2, solidColor, composableLambdaImpl, i3, i4);
            }
        }
        i43 |= 3072;
        z3 = z;
        if ((i4 & 16) != 0) {
            i6 = i43 | 24576;
        } else {
            if (gapComposer.changed(false)) {
                i5 = 16384;
            } else {
                i5 = 8192;
            }
            i6 = i43 | i5;
        }
        if (gapComposer.changed(textStyle)) {
            i7 = 131072;
        } else {
            i7 = 65536;
        }
        i8 = i6 | i7;
        i9 = i4 & 64;
        if (i9 != 0) {
            i8 |= 1572864;
            keyboardOptions2 = keyboardOptions;
        } else {
            keyboardOptions2 = keyboardOptions;
            if ((i3 & 1572864) == 0) {
                if (gapComposer.changed(keyboardOptions2)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i8 |= i10;
            }
        }
        i11 = i4 & 128;
        if (i11 != 0) {
            i13 = i8 | 12582912;
            keyboardActions2 = keyboardActions;
        } else {
            keyboardActions2 = keyboardActions;
            if (gapComposer.changed(keyboardActions2)) {
                i12 = 8388608;
            } else {
                i12 = 4194304;
            }
            i13 = i8 | i12;
        }
        if ((i3 & 100663296) == 0) {
            if (gapComposer.changed(z2)) {
                i42 = 67108864;
            } else {
                i42 = 33554432;
            }
            i13 |= i42;
        }
        if ((i4 & 512) == 0) {
            i14 = i;
            if (gapComposer.changed(i14)) {
            }
            i15 = i13 | i45;
            i16 = i4 & 1024;
            if (i16 != 0) {
                i18 = 196614;
            } else {
                if (gapComposer.changed(i2)) {
                    i17 = 4;
                } else {
                    i17 = 2;
                }
                i18 = 196608 | i17;
            }
            i19 = i4 & 2048;
            if (i19 != 0) {
                i21 = i18 | 48;
            } else {
                if (gapComposer.changed(zslControlImpl$$ExternalSyntheticLambda0)) {
                    i20 = 32;
                } else {
                    i20 = 16;
                }
                i21 = i18 | i20;
            }
            i22 = i21;
            i23 = i22 | 384;
            i24 = i4 & 8192;
            if (i24 != 0) {
                i26 = i22 | 3456;
            } else {
                if (gapComposer.changed(mutableInteractionSourceImpl)) {
                    i25 = 2048;
                } else {
                    i25 = 1024;
                }
                i26 = i23 | i25;
            }
            i27 = i26 | (gapComposer.changed(solidColor) ? 16384 : 8192);
            if ((i15 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (gapComposer.shouldExecute(i15 & 1, z4)) {
                gapComposer.startDefaults();
                i30 = i3 & 1;
                obj = Composer$Companion.Empty;
                if (i30 != 0) {
                    if (i44 != 0) {
                        z3 = true;
                    }
                    if (i9 != 0) {
                        keyboardOptions4 = KeyboardOptions.Default;
                    } else {
                        keyboardOptions4 = keyboardOptions2;
                    }
                    if (i11 != 0) {
                        keyboardActions2 = KeyboardActions.Default;
                    }
                    if ((i4 & 512) != 0) {
                        if (z2) {
                            i31 = 1;
                        } else {
                            i31 = Integer.MAX_VALUE;
                        }
                        i32 = i15 & (-1879048193);
                    } else {
                        i31 = i14;
                        i32 = i15;
                    }
                    if (i16 != 0) {
                        i33 = 1;
                    } else {
                        i33 = i2;
                    }
                    if (i19 != 0) {
                        zslControlImpl$$ExternalSyntheticLambda2 = VisualTransformation$Companion.None;
                    } else {
                        zslControlImpl$$ExternalSyntheticLambda2 = zslControlImpl$$ExternalSyntheticLambda0;
                    }
                    objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == obj) {
                        objRememberedValue = new BasicTextKt$$ExternalSyntheticLambda3(17);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    Function1 function9 = (Function1) objRememberedValue;
                    if (i24 != 0) {
                        mutableInteractionSourceImpl3 = null;
                    } else {
                        mutableInteractionSourceImpl3 = mutableInteractionSourceImpl;
                    }
                    function2 = function9;
                    mutableInteractionSourceImpl = mutableInteractionSourceImpl3;
                    i14 = i31;
                    i2 = i33;
                    zslControlImpl$$ExternalSyntheticLambda0 = zslControlImpl$$ExternalSyntheticLambda2;
                    keyboardOptions5 = keyboardOptions4;
                    i34 = i32;
                } else {
                    if (i44 != 0) {
                        z3 = true;
                    }
                    if (i9 != 0) {
                        keyboardOptions4 = KeyboardOptions.Default;
                    } else {
                        keyboardOptions4 = keyboardOptions2;
                    }
                    if (i11 != 0) {
                        keyboardActions2 = KeyboardActions.Default;
                    }
                    if ((i4 & 512) != 0) {
                        if (z2) {
                            i31 = 1;
                        } else {
                            i31 = Integer.MAX_VALUE;
                        }
                        i32 = i15 & (-1879048193);
                    } else {
                        i31 = i14;
                        i32 = i15;
                    }
                    if (i16 != 0) {
                        i33 = 1;
                    } else {
                        i33 = i2;
                    }
                    if (i19 != 0) {
                        zslControlImpl$$ExternalSyntheticLambda2 = VisualTransformation$Companion.None;
                    } else {
                        zslControlImpl$$ExternalSyntheticLambda2 = zslControlImpl$$ExternalSyntheticLambda0;
                    }
                    objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == obj) {
                        objRememberedValue = new BasicTextKt$$ExternalSyntheticLambda3(17);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    Function1 function10 = (Function1) objRememberedValue;
                    if (i24 != 0) {
                        mutableInteractionSourceImpl3 = null;
                    } else {
                        mutableInteractionSourceImpl3 = mutableInteractionSourceImpl;
                    }
                    function2 = function10;
                    mutableInteractionSourceImpl = mutableInteractionSourceImpl3;
                    i14 = i31;
                    i2 = i33;
                    zslControlImpl$$ExternalSyntheticLambda0 = zslControlImpl$$ExternalSyntheticLambda2;
                    keyboardOptions5 = keyboardOptions4;
                    i34 = i32;
                }
                gapComposer.endDefaults();
                objRememberedValue2 = gapComposer.rememberedValue();
                if (objRememberedValue2 == obj) {
                    objRememberedValue2 = Stack.mutableStateOf$default(new TextFieldValue(6, 0L, str));
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                mutableState = (MutableState) objRememberedValue2;
                TextFieldValue textFieldValue4 = (TextFieldValue) mutableState.getValue();
                i35 = i34;
                textFieldValue = new TextFieldValue(new AnnotatedString(str), textFieldValue4.selection, textFieldValue4.composition);
                zChanged = gapComposer.changed(textFieldValue);
                objRememberedValue3 = gapComposer.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = new Recomposer$$ExternalSyntheticLambda6(7, textFieldValue, mutableState);
                    gapComposer.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Recomposer$$ExternalSyntheticLambda6(7, textFieldValue, mutableState);
                    gapComposer.updateRememberedValue(objRememberedValue3);
                }
                Stack.SideEffect((Function0) objRememberedValue3, gapComposer);
                if ((i35 & 14) == 4) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                objRememberedValue4 = gapComposer.rememberedValue();
                if (z6) {
                    objRememberedValue4 = Stack.mutableStateOf$default(str);
                    gapComposer.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = Stack.mutableStateOf$default(str);
                    gapComposer.updateRememberedValue(objRememberedValue4);
                }
                mutableState2 = (MutableState) objRememberedValue4;
                keyboardOptions5.getClass();
                i36 = keyboardOptions5.keyboardType;
                keyboardType = new KeyboardType(i36);
                if (i36 == 0) {
                    keyboardType = null;
                }
                if (keyboardType != null) {
                    i37 = keyboardType.value;
                } else {
                    i37 = 1;
                }
                i38 = keyboardOptions5.imeAction;
                imeAction = new ImeAction(i38);
                if (i38 == -1) {
                    imeAction2 = null;
                }
                if (imeAction2 != null) {
                    imeAction2 = imeAction;
                    i39 = imeAction2.value;
                } else {
                    imeAction2 = imeAction;
                    i39 = 1;
                }
                KeyboardOptions keyboardOptions8 = keyboardOptions5;
                ImeOptions imeOptions3 = new ImeOptions(z2, 0, true, i37, i39, LocaleList.Empty);
                boolean z13 = !z2;
                if (z2) {
                    i40 = 1;
                } else {
                    i40 = i2;
                }
                if (z2) {
                    i41 = 1;
                } else {
                    i41 = i14;
                }
                boolean zChanged4 = gapComposer.changed(mutableState2);
                if ((i35 & 112) == 32) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                z8 = z7 | zChanged4;
                objRememberedValue5 = gapComposer.rememberedValue();
                if (z8) {
                    objRememberedValue5 = new LifecycleEffectKt$$ExternalSyntheticLambda1(function1, mutableState, mutableState2);
                    gapComposer.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new LifecycleEffectKt$$ExternalSyntheticLambda1(function1, mutableState, mutableState2);
                    gapComposer.updateRememberedValue(objRememberedValue5);
                }
                int i410 = i27 << 9;
                int i411 = i41;
                boolean z14 = z3;
                ZslControlImpl$$ExternalSyntheticLambda0 zslControlImpl$$ExternalSyntheticLambda5 = zslControlImpl$$ExternalSyntheticLambda0;
                Function1 function11 = function2;
                MutableInteractionSourceImpl mutableInteractionSourceImpl6 = mutableInteractionSourceImpl;
                KeyboardActions keyboardActions6 = keyboardActions2;
                BasicTextKt.CoreTextField(textFieldValue, (Function1) objRememberedValue5, modifier, textStyle, zslControlImpl$$ExternalSyntheticLambda5, function11, mutableInteractionSourceImpl6, solidColor, z13, i411, i40, imeOptions3, keyboardActions6, z14, composableLambdaImpl, gapComposer, (i35 & 896) | ((i35 >> 6) & 7168) | (i410 & 57344) | 196608 | (3670016 & i410) | (i410 & 29360128), (i35 & 57344) | ((i35 >> 15) & 896) | (i35 & 7168) | 196608);
                keyboardOptions3 = keyboardOptions8;
                zslControlImpl$$ExternalSyntheticLambda1 = zslControlImpl$$ExternalSyntheticLambda5;
                function3 = function11;
                mutableInteractionSourceImpl2 = mutableInteractionSourceImpl6;
                keyboardActions3 = keyboardActions6;
                z5 = z14;
                i29 = i14;
                i28 = i2;
            } else {
                gapComposer.skipToGroupEnd();
                i28 = i2;
                zslControlImpl$$ExternalSyntheticLambda1 = zslControlImpl$$ExternalSyntheticLambda0;
                mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                keyboardOptions3 = keyboardOptions2;
                i29 = i14;
                keyboardActions3 = keyboardActions2;
                z5 = z3;
                function3 = function2;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new CoreTextFieldKt$$ExternalSyntheticLambda6(str, function1, modifier, z5, textStyle, keyboardOptions3, keyboardActions3, z2, i29, i28, zslControlImpl$$ExternalSyntheticLambda1, function3, mutableInteractionSourceImpl2, solidColor, composableLambdaImpl, i3, i4);
            }
        }
        i14 = i;
        i15 = i13 | i45;
        i16 = i4 & 1024;
        if (i16 != 0) {
            i18 = 196614;
        } else {
            if (gapComposer.changed(i2)) {
                i17 = 4;
            } else {
                i17 = 2;
            }
            i18 = 196608 | i17;
        }
        i19 = i4 & 2048;
        if (i19 != 0) {
            i21 = i18 | 48;
        } else {
            if (gapComposer.changed(zslControlImpl$$ExternalSyntheticLambda0)) {
                i20 = 32;
            } else {
                i20 = 16;
            }
            i21 = i18 | i20;
        }
        i22 = i21;
        i23 = i22 | 384;
        i24 = i4 & 8192;
        if (i24 != 0) {
            i26 = i22 | 3456;
        } else {
            if (gapComposer.changed(mutableInteractionSourceImpl)) {
                i25 = 2048;
            } else {
                i25 = 1024;
            }
            i26 = i23 | i25;
        }
        i27 = i26 | (gapComposer.changed(solidColor) ? 16384 : 8192);
        if ((i15 & 306783379) == 306783378) {
            z4 = true;
        } else {
            z4 = true;
        }
        if (gapComposer.shouldExecute(i15 & 1, z4)) {
            gapComposer.startDefaults();
            i30 = i3 & 1;
            obj = Composer$Companion.Empty;
            if (i30 != 0) {
                if (i44 != 0) {
                    z3 = true;
                }
                if (i9 != 0) {
                    keyboardOptions4 = KeyboardOptions.Default;
                } else {
                    keyboardOptions4 = keyboardOptions2;
                }
                if (i11 != 0) {
                    keyboardActions2 = KeyboardActions.Default;
                }
                if ((i4 & 512) != 0) {
                    if (z2) {
                        i31 = 1;
                    } else {
                        i31 = Integer.MAX_VALUE;
                    }
                    i32 = i15 & (-1879048193);
                } else {
                    i31 = i14;
                    i32 = i15;
                }
                if (i16 != 0) {
                    i33 = 1;
                } else {
                    i33 = i2;
                }
                if (i19 != 0) {
                    zslControlImpl$$ExternalSyntheticLambda2 = VisualTransformation$Companion.None;
                } else {
                    zslControlImpl$$ExternalSyntheticLambda2 = zslControlImpl$$ExternalSyntheticLambda0;
                }
                objRememberedValue = gapComposer.rememberedValue();
                if (objRememberedValue == obj) {
                    objRememberedValue = new BasicTextKt$$ExternalSyntheticLambda3(17);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                Function1 function12 = (Function1) objRememberedValue;
                if (i24 != 0) {
                    mutableInteractionSourceImpl3 = null;
                } else {
                    mutableInteractionSourceImpl3 = mutableInteractionSourceImpl;
                }
                function2 = function12;
                mutableInteractionSourceImpl = mutableInteractionSourceImpl3;
                i14 = i31;
                i2 = i33;
                zslControlImpl$$ExternalSyntheticLambda0 = zslControlImpl$$ExternalSyntheticLambda2;
                keyboardOptions5 = keyboardOptions4;
                i34 = i32;
            } else {
                if (i44 != 0) {
                    z3 = true;
                }
                if (i9 != 0) {
                    keyboardOptions4 = KeyboardOptions.Default;
                } else {
                    keyboardOptions4 = keyboardOptions2;
                }
                if (i11 != 0) {
                    keyboardActions2 = KeyboardActions.Default;
                }
                if ((i4 & 512) != 0) {
                    if (z2) {
                        i31 = 1;
                    } else {
                        i31 = Integer.MAX_VALUE;
                    }
                    i32 = i15 & (-1879048193);
                } else {
                    i31 = i14;
                    i32 = i15;
                }
                if (i16 != 0) {
                    i33 = 1;
                } else {
                    i33 = i2;
                }
                if (i19 != 0) {
                    zslControlImpl$$ExternalSyntheticLambda2 = VisualTransformation$Companion.None;
                } else {
                    zslControlImpl$$ExternalSyntheticLambda2 = zslControlImpl$$ExternalSyntheticLambda0;
                }
                objRememberedValue = gapComposer.rememberedValue();
                if (objRememberedValue == obj) {
                    objRememberedValue = new BasicTextKt$$ExternalSyntheticLambda3(17);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                Function1 function13 = (Function1) objRememberedValue;
                if (i24 != 0) {
                    mutableInteractionSourceImpl3 = null;
                } else {
                    mutableInteractionSourceImpl3 = mutableInteractionSourceImpl;
                }
                function2 = function13;
                mutableInteractionSourceImpl = mutableInteractionSourceImpl3;
                i14 = i31;
                i2 = i33;
                zslControlImpl$$ExternalSyntheticLambda0 = zslControlImpl$$ExternalSyntheticLambda2;
                keyboardOptions5 = keyboardOptions4;
                i34 = i32;
            }
            gapComposer.endDefaults();
            objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == obj) {
                objRememberedValue2 = Stack.mutableStateOf$default(new TextFieldValue(6, 0L, str));
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            mutableState = (MutableState) objRememberedValue2;
            TextFieldValue textFieldValue5 = (TextFieldValue) mutableState.getValue();
            i35 = i34;
            textFieldValue = new TextFieldValue(new AnnotatedString(str), textFieldValue5.selection, textFieldValue5.composition);
            zChanged = gapComposer.changed(textFieldValue);
            objRememberedValue3 = gapComposer.rememberedValue();
            if (zChanged) {
                objRememberedValue3 = new Recomposer$$ExternalSyntheticLambda6(7, textFieldValue, mutableState);
                gapComposer.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Recomposer$$ExternalSyntheticLambda6(7, textFieldValue, mutableState);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            Stack.SideEffect((Function0) objRememberedValue3, gapComposer);
            if ((i35 & 14) == 4) {
                z6 = true;
            } else {
                z6 = false;
            }
            objRememberedValue4 = gapComposer.rememberedValue();
            if (z6) {
                objRememberedValue4 = Stack.mutableStateOf$default(str);
                gapComposer.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = Stack.mutableStateOf$default(str);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            mutableState2 = (MutableState) objRememberedValue4;
            keyboardOptions5.getClass();
            i36 = keyboardOptions5.keyboardType;
            keyboardType = new KeyboardType(i36);
            if (i36 == 0) {
                keyboardType = null;
            }
            if (keyboardType != null) {
                i37 = keyboardType.value;
            } else {
                i37 = 1;
            }
            i38 = keyboardOptions5.imeAction;
            imeAction = new ImeAction(i38);
            if (i38 == -1) {
                imeAction2 = null;
            }
            if (imeAction2 != null) {
                imeAction2 = imeAction;
                i39 = imeAction2.value;
            } else {
                imeAction2 = imeAction;
                i39 = 1;
            }
            KeyboardOptions keyboardOptions9 = keyboardOptions5;
            ImeOptions imeOptions4 = new ImeOptions(z2, 0, true, i37, i39, LocaleList.Empty);
            boolean z15 = !z2;
            if (z2) {
                i40 = 1;
            } else {
                i40 = i2;
            }
            if (z2) {
                i41 = 1;
            } else {
                i41 = i14;
            }
            boolean zChanged5 = gapComposer.changed(mutableState2);
            if ((i35 & 112) == 32) {
                z7 = true;
            } else {
                z7 = false;
            }
            z8 = z7 | zChanged5;
            objRememberedValue5 = gapComposer.rememberedValue();
            if (z8) {
                objRememberedValue5 = new LifecycleEffectKt$$ExternalSyntheticLambda1(function1, mutableState, mutableState2);
                gapComposer.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = new LifecycleEffectKt$$ExternalSyntheticLambda1(function1, mutableState, mutableState2);
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            int i412 = i27 << 9;
            int i413 = i41;
            boolean z16 = z3;
            ZslControlImpl$$ExternalSyntheticLambda0 zslControlImpl$$ExternalSyntheticLambda6 = zslControlImpl$$ExternalSyntheticLambda0;
            Function1 function14 = function2;
            MutableInteractionSourceImpl mutableInteractionSourceImpl7 = mutableInteractionSourceImpl;
            KeyboardActions keyboardActions7 = keyboardActions2;
            BasicTextKt.CoreTextField(textFieldValue, (Function1) objRememberedValue5, modifier, textStyle, zslControlImpl$$ExternalSyntheticLambda6, function14, mutableInteractionSourceImpl7, solidColor, z15, i413, i40, imeOptions4, keyboardActions7, z16, composableLambdaImpl, gapComposer, (i35 & 896) | ((i35 >> 6) & 7168) | (i412 & 57344) | 196608 | (3670016 & i412) | (i412 & 29360128), (i35 & 57344) | ((i35 >> 15) & 896) | (i35 & 7168) | 196608);
            keyboardOptions3 = keyboardOptions9;
            zslControlImpl$$ExternalSyntheticLambda1 = zslControlImpl$$ExternalSyntheticLambda6;
            function3 = function14;
            mutableInteractionSourceImpl2 = mutableInteractionSourceImpl7;
            keyboardActions3 = keyboardActions7;
            z5 = z16;
            i29 = i14;
            i28 = i2;
        } else {
            gapComposer.skipToGroupEnd();
            i28 = i2;
            zslControlImpl$$ExternalSyntheticLambda1 = zslControlImpl$$ExternalSyntheticLambda0;
            mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
            keyboardOptions3 = keyboardOptions2;
            i29 = i14;
            keyboardActions3 = keyboardActions2;
            z5 = z3;
            function3 = function2;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new CoreTextFieldKt$$ExternalSyntheticLambda6(str, function1, modifier, z5, textStyle, keyboardOptions3, keyboardActions3, z2, i29, i28, zslControlImpl$$ExternalSyntheticLambda1, function3, mutableInteractionSourceImpl2, solidColor, composableLambdaImpl, i3, i4);
        }
    }
}
