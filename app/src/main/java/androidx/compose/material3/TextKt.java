package androidx.compose.material3;

import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.runtime.DynamicProvidableCompositionLocal;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.TextUnit;
import coil.ImageLoader$Builder$$ExternalSyntheticLambda2;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class TextKt {
    public static final DynamicProvidableCompositionLocal LocalTextStyle = new DynamicProvidableCompositionLocal(new ImageLoader$Builder$$ExternalSyntheticLambda2(4));

    public static final void ProvideTextStyle(TextStyle textStyle, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        gapComposer.startRestartGroup(15327438);
        int i2 = (gapComposer.changed(textStyle) ? 4 : 2) | i | (gapComposer.changedInstance(composableLambdaImpl) ? 32 : 16);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            DynamicProvidableCompositionLocal dynamicProvidableCompositionLocal = LocalTextStyle;
            Stack.CompositionLocalProvider(dynamicProvidableCompositionLocal.defaultProvidedValue$runtime(((TextStyle) gapComposer.consume(dynamicProvidableCompositionLocal)).merge(textStyle)), composableLambdaImpl, gapComposer, (i2 & 112) | 8);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TextKt$$ExternalSyntheticLambda2(i, 0, textStyle, composableLambdaImpl);
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0138  */
    /* JADX WARN: Code duplicated, block: B:102:0x013d  */
    /* JADX WARN: Code duplicated, block: B:105:0x0149  */
    /* JADX WARN: Code duplicated, block: B:107:0x014d  */
    /* JADX WARN: Code duplicated, block: B:109:0x0157  */
    /* JADX WARN: Code duplicated, block: B:110:0x015a  */
    /* JADX WARN: Code duplicated, block: B:113:0x0163  */
    /* JADX WARN: Code duplicated, block: B:116:0x0173  */
    /* JADX WARN: Code duplicated, block: B:120:0x0180  */
    /* JADX WARN: Code duplicated, block: B:123:0x018a  */
    /* JADX WARN: Code duplicated, block: B:125:0x0194  */
    /* JADX WARN: Code duplicated, block: B:132:0x01b6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:133:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:134:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:136:0x01be  */
    /* JADX WARN: Code duplicated, block: B:138:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:139:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:142:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:144:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:146:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:147:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:150:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:153:0x01df  */
    /* JADX WARN: Code duplicated, block: B:154:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:156:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:159:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:161:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:164:0x020c  */
    /* JADX WARN: Code duplicated, block: B:165:0x0214  */
    /* JADX WARN: Code duplicated, block: B:167:0x0222  */
    /* JADX WARN: Code duplicated, block: B:169:0x0228  */
    /* JADX WARN: Code duplicated, block: B:173:0x0241  */
    /* JADX WARN: Code duplicated, block: B:174:0x0244  */
    /* JADX WARN: Code duplicated, block: B:176:0x02ac  */
    /* JADX WARN: Code duplicated, block: B:179:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:181:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0041  */
    /* JADX WARN: Code duplicated, block: B:25:0x0046  */
    /* JADX WARN: Code duplicated, block: B:27:0x004a  */
    /* JADX WARN: Code duplicated, block: B:29:0x0052  */
    /* JADX WARN: Code duplicated, block: B:30:0x0055  */
    /* JADX WARN: Code duplicated, block: B:34:0x0062  */
    /* JADX WARN: Code duplicated, block: B:35:0x0067  */
    /* JADX WARN: Code duplicated, block: B:37:0x006d  */
    /* JADX WARN: Code duplicated, block: B:39:0x0073  */
    /* JADX WARN: Code duplicated, block: B:40:0x0076  */
    /* JADX WARN: Code duplicated, block: B:44:0x0082  */
    /* JADX WARN: Code duplicated, block: B:45:0x0087  */
    /* JADX WARN: Code duplicated, block: B:47:0x008d  */
    /* JADX WARN: Code duplicated, block: B:49:0x0093  */
    /* JADX WARN: Code duplicated, block: B:50:0x0096  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:70:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:74:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:76:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:78:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:79:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:83:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:84:0x0104  */
    /* JADX WARN: Code duplicated, block: B:86:0x0108  */
    /* JADX WARN: Code duplicated, block: B:88:0x0110  */
    /* JADX WARN: Code duplicated, block: B:89:0x0113  */
    /* JADX WARN: Code duplicated, block: B:92:0x011a  */
    /* JADX WARN: Code duplicated, block: B:95:0x0125  */
    /* JADX WARN: Code duplicated, block: B:96:0x012c  */
    /* JADX WARN: Code duplicated, block: B:98:0x0130  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r42v1 */
    /* JADX INFO: renamed from: Text-Nvy7gAk, reason: not valid java name */
    public static final void m275TextNvy7gAk(final String str, Modifier modifier, long j, long j2, FontStyle fontStyle, FontWeight fontWeight, long j3, TextAlign textAlign, long j4, int i, boolean z, int i2, int i3, TextStyle textStyle, GapComposer gapComposer, final int i4, final int i5, final int i6) {
        int i7;
        Modifier modifier2;
        int i8;
        long j5;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        final FontStyle fontStyle2;
        int i14;
        int i15;
        FontWeight fontWeight2;
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
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        int i34;
        boolean z2;
        boolean z3;
        final boolean z4;
        final int i35;
        final TextStyle textStyle2;
        final int i36;
        final Modifier modifier3;
        final FontWeight fontWeight3;
        final long j6;
        final long j7;
        final long j8;
        final TextAlign textAlign2;
        final long j9;
        final int i37;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        Modifier modifier4;
        long j10;
        long j11;
        TextAlign textAlign3;
        long j12;
        int i38;
        TextStyle textStyle3;
        int i39;
        long jM649getColor0d7_KjU;
        boolean z5;
        ?? r3;
        gapComposer.startRestartGroup(1809465675);
        if ((i4 & 6) == 0) {
            i7 = (gapComposer.changed(str) ? 4 : 2) | i4;
        } else {
            i7 = i4;
        }
        int i40 = i6 & 2;
        if (i40 == 0) {
            if ((i4 & 48) == 0) {
                modifier2 = modifier;
                i7 |= gapComposer.changed(modifier2) ? 32 : 16;
            }
            i8 = i6 & 4;
            if (i8 != 0) {
                if ((i4 & 384) == 0) {
                    j5 = j;
                    if (gapComposer.changed(j5)) {
                        i9 = 256;
                    } else {
                        i9 = 128;
                    }
                    i7 |= i9;
                }
                i10 = i7 | 3072;
                i11 = i6 & 16;
                if (i11 != 0) {
                    i10 = i7 | 27648;
                } else if ((i4 & 24576) == 0) {
                    if (gapComposer.changed(j2)) {
                        i12 = 16384;
                    } else {
                        i12 = 8192;
                    }
                    i10 |= i12;
                }
                i13 = i6 & 32;
                if (i13 != 0) {
                    i10 |= 196608;
                    fontStyle2 = fontStyle;
                } else {
                    fontStyle2 = fontStyle;
                    if ((i4 & 196608) == 0) {
                        if (gapComposer.changed(fontStyle2)) {
                            i14 = 131072;
                        } else {
                            i14 = 65536;
                        }
                        i10 |= i14;
                    }
                }
                i15 = i6 & 64;
                if (i15 != 0) {
                    i10 |= 1572864;
                    fontWeight2 = fontWeight;
                } else {
                    fontWeight2 = fontWeight;
                    if ((i4 & 1572864) == 0) {
                        if (gapComposer.changed(fontWeight2)) {
                            i16 = 1048576;
                        } else {
                            i16 = 524288;
                        }
                        i10 |= i16;
                    }
                }
                i17 = i10 | 12582912;
                i18 = i6 & 256;
                if (i18 != 0) {
                    i17 = i10 | 113246208;
                } else if ((100663296 & i4) == 0) {
                    if (gapComposer.changed(j3)) {
                        i19 = 67108864;
                    } else {
                        i19 = 33554432;
                    }
                    i17 |= i19;
                }
                i20 = i17 | 805306368;
                i21 = i6 & 1024;
                if (i21 != 0) {
                    i23 = i5 | 6;
                } else {
                    if (gapComposer.changed(textAlign)) {
                        i22 = 4;
                    } else {
                        i22 = 2;
                    }
                    i23 = i5 | i22;
                }
                i24 = i23;
                i25 = i24 | 48;
                i26 = i6 & 4096;
                if (i26 != 0) {
                    i27 = i24 | 432;
                } else {
                    if ((i5 & 384) != 0) {
                        if (gapComposer.changed(i)) {
                            i28 = 256;
                        } else {
                            i28 = 128;
                        }
                        i25 |= i28;
                    }
                    i27 = i25;
                }
                i29 = i27 | 3072;
                i30 = i6 & 16384;
                if (i30 != 0) {
                    i32 = i27 | 27648;
                    i31 = i2;
                } else if ((i5 & 24576) == 0) {
                    i31 = i2;
                    i32 = i29 | (gapComposer.changed(i31) ? 16384 : 8192);
                } else {
                    i31 = i2;
                    i32 = i29;
                }
                i33 = i32 | 1769472;
                if ((i5 & 12582912) == 0) {
                    if ((i6 & 131072) == 0) {
                        i34 = i30;
                        int i41 = gapComposer.changed(textStyle) ? 8388608 : 4194304;
                        i33 |= i41;
                    } else {
                        i34 = i30;
                    }
                    i33 |= i41;
                } else {
                    i34 = i30;
                }
                z2 = true;
                if ((i20 & 306783379) == 306783378 || (i33 & 4793491) != 4793490) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (gapComposer.shouldExecute(i20 & 1, z3)) {
                    gapComposer.startDefaults();
                    if ((i4 & 1) != 0 || gapComposer.getDefaultsInvalid()) {
                        if (i40 != 0) {
                            modifier4 = Modifier.Companion.$$INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        if (i8 != 0) {
                            j5 = Color.Unspecified;
                        }
                        if (i11 != 0) {
                            j10 = TextUnit.Unspecified;
                        } else {
                            j10 = j2;
                        }
                        if (i13 != 0) {
                            fontStyle2 = null;
                        }
                        if (i15 != 0) {
                            fontWeight2 = null;
                        }
                        if (i18 != 0) {
                            j11 = TextUnit.Unspecified;
                        } else {
                            j11 = j3;
                        }
                        textAlign3 = i21 == 0 ? textAlign : null;
                        j12 = TextUnit.Unspecified;
                        if (i26 != 0) {
                            i38 = 1;
                        } else {
                            i38 = i;
                        }
                        if (i34 != 0) {
                            i31 = Integer.MAX_VALUE;
                        }
                        if ((i6 & 131072) != 0) {
                            textStyle3 = (TextStyle) gapComposer.consume(LocalTextStyle);
                            i33 &= -29360129;
                        } else {
                            textStyle3 = textStyle;
                        }
                        i39 = 1;
                    } else {
                        gapComposer.skipToGroupEnd();
                        if ((i6 & 131072) != 0) {
                            i33 &= -29360129;
                        }
                        j11 = j3;
                        textAlign3 = textAlign;
                        j12 = j4;
                        i38 = i;
                        z2 = z;
                        i39 = i3;
                        textStyle3 = textStyle;
                        modifier4 = modifier2;
                        j10 = j2;
                    }
                    gapComposer.endDefaults();
                    gapComposer.startReplaceGroup(-565217490);
                    if (j5 != 16) {
                        modifier4 = modifier4;
                        i39 = i39;
                        jM649getColor0d7_KjU = j5;
                        z5 = false;
                    } else {
                        gapComposer.startReplaceGroup(-565216717);
                        jM649getColor0d7_KjU = textStyle3.m649getColor0d7_KjU();
                        if (jM649getColor0d7_KjU != 16) {
                            jM649getColor0d7_KjU = ((Color) gapComposer.consume(ContentColorKt.LocalContentColor)).value;
                        }
                        z5 = false;
                        gapComposer.end(false);
                    }
                    gapComposer.end(z5);
                    if (textAlign3 != null) {
                        r3 = textAlign3.value;
                    } else {
                        r3 = z5;
                    }
                    int i42 = r3 == true ? 1 : 0;
                    int i43 = i33 << 6;
                    Modifier modifier5 = modifier4;
                    int i44 = i39;
                    BasicTextKt.m166BasicTextRWo7tUw(str, modifier5, TextStyle.m648mergedA7vx0o$default(textStyle3, jM649getColor0d7_KjU, j10, fontWeight2, fontStyle2, j11, i42, j12, 16609104), i38, z2, i31, i44, gapComposer, (i20 & 126) | 3072 | (i43 & 57344) | 196608 | (i43 & 3670016) | 12582912 | ((i20 << 18) & 1879048192), 256);
                    i37 = i38;
                    j6 = j5;
                    i35 = i44;
                    modifier3 = modifier5;
                    textStyle2 = textStyle3;
                    j9 = j12;
                    z4 = z2;
                    i36 = i31;
                    j7 = j10;
                    fontWeight3 = fontWeight2;
                    textAlign2 = textAlign3;
                    j8 = j11;
                } else {
                    gapComposer.skipToGroupEnd();
                    z4 = z;
                    i35 = i3;
                    textStyle2 = textStyle;
                    i36 = i31;
                    modifier3 = modifier2;
                    fontWeight3 = fontWeight2;
                    j6 = j5;
                    j7 = j2;
                    j8 = j3;
                    textAlign2 = textAlign;
                    j9 = j4;
                    i37 = i;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                            int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                            TextKt.m275TextNvy7gAk(str, modifier3, j6, j7, fontStyle2, fontWeight3, j8, textAlign2, j9, i37, z4, i36, i35, textStyle2, (GapComposer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i6);
                            return Unit.INSTANCE;
                        }
                    };
                }
            }
            i7 |= 384;
            j5 = j;
            i10 = i7 | 3072;
            i11 = i6 & 16;
            if (i11 != 0) {
                i10 = i7 | 27648;
            } else if ((i4 & 24576) == 0) {
                if (gapComposer.changed(j2)) {
                    i12 = 16384;
                } else {
                    i12 = 8192;
                }
                i10 |= i12;
            }
            i13 = i6 & 32;
            if (i13 != 0) {
                i10 |= 196608;
                fontStyle2 = fontStyle;
            } else {
                fontStyle2 = fontStyle;
                if ((i4 & 196608) == 0) {
                    if (gapComposer.changed(fontStyle2)) {
                        i14 = 131072;
                    } else {
                        i14 = 65536;
                    }
                    i10 |= i14;
                }
            }
            i15 = i6 & 64;
            if (i15 != 0) {
                i10 |= 1572864;
                fontWeight2 = fontWeight;
            } else {
                fontWeight2 = fontWeight;
                if ((i4 & 1572864) == 0) {
                    if (gapComposer.changed(fontWeight2)) {
                        i16 = 1048576;
                    } else {
                        i16 = 524288;
                    }
                    i10 |= i16;
                }
            }
            i17 = i10 | 12582912;
            i18 = i6 & 256;
            if (i18 != 0) {
                i17 = i10 | 113246208;
            } else if ((100663296 & i4) == 0) {
                if (gapComposer.changed(j3)) {
                    i19 = 67108864;
                } else {
                    i19 = 33554432;
                }
                i17 |= i19;
            }
            i20 = i17 | 805306368;
            i21 = i6 & 1024;
            if (i21 != 0) {
                i23 = i5 | 6;
            } else {
                if (gapComposer.changed(textAlign)) {
                    i22 = 4;
                } else {
                    i22 = 2;
                }
                i23 = i5 | i22;
            }
            i24 = i23;
            i25 = i24 | 48;
            i26 = i6 & 4096;
            if (i26 != 0) {
                i27 = i24 | 432;
            } else {
                if ((i5 & 384) != 0) {
                    if (gapComposer.changed(i)) {
                        i28 = 256;
                    } else {
                        i28 = 128;
                    }
                    i25 |= i28;
                }
                i27 = i25;
            }
            i29 = i27 | 3072;
            i30 = i6 & 16384;
            if (i30 != 0) {
                i32 = i27 | 27648;
                i31 = i2;
            } else if ((i5 & 24576) == 0) {
                i31 = i2;
                i32 = i29 | (gapComposer.changed(i31) ? 16384 : 8192);
            } else {
                i31 = i2;
                i32 = i29;
            }
            i33 = i32 | 1769472;
            if ((i5 & 12582912) == 0) {
                if ((i6 & 131072) == 0) {
                    i34 = i30;
                    if (gapComposer.changed(textStyle)) {
                    }
                    i33 |= i41;
                } else {
                    i34 = i30;
                }
                i33 |= i41;
            } else {
                i34 = i30;
            }
            z2 = true;
            if ((i20 & 306783379) == 306783378) {
                z3 = true;
            } else {
                z3 = true;
            }
            if (gapComposer.shouldExecute(i20 & 1, z3)) {
                gapComposer.startDefaults();
                if ((i4 & 1) != 0) {
                    if (i40 != 0) {
                        modifier4 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i8 != 0) {
                        j5 = Color.Unspecified;
                    }
                    if (i11 != 0) {
                        j10 = TextUnit.Unspecified;
                    } else {
                        j10 = j2;
                    }
                    if (i13 != 0) {
                        fontStyle2 = null;
                    }
                    if (i15 != 0) {
                        fontWeight2 = null;
                    }
                    if (i18 != 0) {
                        j11 = TextUnit.Unspecified;
                    } else {
                        j11 = j3;
                    }
                    if (i21 == 0) {
                    }
                    j12 = TextUnit.Unspecified;
                    if (i26 != 0) {
                        i38 = 1;
                    } else {
                        i38 = i;
                    }
                    if (i34 != 0) {
                        i31 = Integer.MAX_VALUE;
                    }
                    if ((i6 & 131072) != 0) {
                        textStyle3 = (TextStyle) gapComposer.consume(LocalTextStyle);
                        i33 &= -29360129;
                    } else {
                        textStyle3 = textStyle;
                    }
                    i39 = 1;
                } else {
                    if (i40 != 0) {
                        modifier4 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i8 != 0) {
                        j5 = Color.Unspecified;
                    }
                    if (i11 != 0) {
                        j10 = TextUnit.Unspecified;
                    } else {
                        j10 = j2;
                    }
                    if (i13 != 0) {
                        fontStyle2 = null;
                    }
                    if (i15 != 0) {
                        fontWeight2 = null;
                    }
                    if (i18 != 0) {
                        j11 = TextUnit.Unspecified;
                    } else {
                        j11 = j3;
                    }
                    if (i21 == 0) {
                    }
                    j12 = TextUnit.Unspecified;
                    if (i26 != 0) {
                        i38 = 1;
                    } else {
                        i38 = i;
                    }
                    if (i34 != 0) {
                        i31 = Integer.MAX_VALUE;
                    }
                    if ((i6 & 131072) != 0) {
                        textStyle3 = (TextStyle) gapComposer.consume(LocalTextStyle);
                        i33 &= -29360129;
                    } else {
                        textStyle3 = textStyle;
                    }
                    i39 = 1;
                }
                gapComposer.endDefaults();
                gapComposer.startReplaceGroup(-565217490);
                if (j5 != 16) {
                    modifier4 = modifier4;
                    i39 = i39;
                    jM649getColor0d7_KjU = j5;
                    z5 = false;
                } else {
                    gapComposer.startReplaceGroup(-565216717);
                    jM649getColor0d7_KjU = textStyle3.m649getColor0d7_KjU();
                    if (jM649getColor0d7_KjU != 16) {
                        jM649getColor0d7_KjU = ((Color) gapComposer.consume(ContentColorKt.LocalContentColor)).value;
                    }
                    z5 = false;
                    gapComposer.end(false);
                }
                gapComposer.end(z5);
                if (textAlign3 != null) {
                    r3 = textAlign3.value;
                } else {
                    r3 = z5;
                }
                int i45 = r3 == true ? 1 : 0;
                int i46 = i33 << 6;
                Modifier modifier6 = modifier4;
                int i47 = i39;
                BasicTextKt.m166BasicTextRWo7tUw(str, modifier6, TextStyle.m648mergedA7vx0o$default(textStyle3, jM649getColor0d7_KjU, j10, fontWeight2, fontStyle2, j11, i45, j12, 16609104), i38, z2, i31, i47, gapComposer, (i20 & 126) | 3072 | (i46 & 57344) | 196608 | (i46 & 3670016) | 12582912 | ((i20 << 18) & 1879048192), 256);
                i37 = i38;
                j6 = j5;
                i35 = i47;
                modifier3 = modifier6;
                textStyle2 = textStyle3;
                j9 = j12;
                z4 = z2;
                i36 = i31;
                j7 = j10;
                fontWeight3 = fontWeight2;
                textAlign2 = textAlign3;
                j8 = j11;
            } else {
                gapComposer.skipToGroupEnd();
                z4 = z;
                i35 = i3;
                textStyle2 = textStyle;
                i36 = i31;
                modifier3 = modifier2;
                fontWeight3 = fontWeight2;
                j6 = j5;
                j7 = j2;
                j8 = j3;
                textAlign2 = textAlign;
                j9 = j4;
                i37 = i;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                        int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                        TextKt.m275TextNvy7gAk(str, modifier3, j6, j7, fontStyle2, fontWeight3, j8, textAlign2, j9, i37, z4, i36, i35, textStyle2, (GapComposer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i6);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i7 |= 48;
        modifier2 = modifier;
        i8 = i6 & 4;
        if (i8 != 0) {
            if ((i4 & 384) == 0) {
                j5 = j;
                if (gapComposer.changed(j5)) {
                    i9 = 256;
                } else {
                    i9 = 128;
                }
                i7 |= i9;
            }
            i10 = i7 | 3072;
            i11 = i6 & 16;
            if (i11 != 0) {
                i10 = i7 | 27648;
            } else if ((i4 & 24576) == 0) {
                if (gapComposer.changed(j2)) {
                    i12 = 16384;
                } else {
                    i12 = 8192;
                }
                i10 |= i12;
            }
            i13 = i6 & 32;
            if (i13 != 0) {
                i10 |= 196608;
                fontStyle2 = fontStyle;
            } else {
                fontStyle2 = fontStyle;
                if ((i4 & 196608) == 0) {
                    if (gapComposer.changed(fontStyle2)) {
                        i14 = 131072;
                    } else {
                        i14 = 65536;
                    }
                    i10 |= i14;
                }
            }
            i15 = i6 & 64;
            if (i15 != 0) {
                i10 |= 1572864;
                fontWeight2 = fontWeight;
            } else {
                fontWeight2 = fontWeight;
                if ((i4 & 1572864) == 0) {
                    if (gapComposer.changed(fontWeight2)) {
                        i16 = 1048576;
                    } else {
                        i16 = 524288;
                    }
                    i10 |= i16;
                }
            }
            i17 = i10 | 12582912;
            i18 = i6 & 256;
            if (i18 != 0) {
                i17 = i10 | 113246208;
            } else if ((100663296 & i4) == 0) {
                if (gapComposer.changed(j3)) {
                    i19 = 67108864;
                } else {
                    i19 = 33554432;
                }
                i17 |= i19;
            }
            i20 = i17 | 805306368;
            i21 = i6 & 1024;
            if (i21 != 0) {
                i23 = i5 | 6;
            } else {
                if (gapComposer.changed(textAlign)) {
                    i22 = 4;
                } else {
                    i22 = 2;
                }
                i23 = i5 | i22;
            }
            i24 = i23;
            i25 = i24 | 48;
            i26 = i6 & 4096;
            if (i26 != 0) {
                i27 = i24 | 432;
            } else {
                if ((i5 & 384) != 0) {
                    if (gapComposer.changed(i)) {
                        i28 = 256;
                    } else {
                        i28 = 128;
                    }
                    i25 |= i28;
                }
                i27 = i25;
            }
            i29 = i27 | 3072;
            i30 = i6 & 16384;
            if (i30 != 0) {
                i32 = i27 | 27648;
                i31 = i2;
            } else if ((i5 & 24576) == 0) {
                i31 = i2;
                i32 = i29 | (gapComposer.changed(i31) ? 16384 : 8192);
            } else {
                i31 = i2;
                i32 = i29;
            }
            i33 = i32 | 1769472;
            if ((i5 & 12582912) == 0) {
                if ((i6 & 131072) == 0) {
                    i34 = i30;
                    if (gapComposer.changed(textStyle)) {
                    }
                    i33 |= i41;
                } else {
                    i34 = i30;
                }
                i33 |= i41;
            } else {
                i34 = i30;
            }
            z2 = true;
            if ((i20 & 306783379) == 306783378) {
                z3 = true;
            } else {
                z3 = true;
            }
            if (gapComposer.shouldExecute(i20 & 1, z3)) {
                gapComposer.startDefaults();
                if ((i4 & 1) != 0) {
                    if (i40 != 0) {
                        modifier4 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i8 != 0) {
                        j5 = Color.Unspecified;
                    }
                    if (i11 != 0) {
                        j10 = TextUnit.Unspecified;
                    } else {
                        j10 = j2;
                    }
                    if (i13 != 0) {
                        fontStyle2 = null;
                    }
                    if (i15 != 0) {
                        fontWeight2 = null;
                    }
                    if (i18 != 0) {
                        j11 = TextUnit.Unspecified;
                    } else {
                        j11 = j3;
                    }
                    if (i21 == 0) {
                    }
                    j12 = TextUnit.Unspecified;
                    if (i26 != 0) {
                        i38 = 1;
                    } else {
                        i38 = i;
                    }
                    if (i34 != 0) {
                        i31 = Integer.MAX_VALUE;
                    }
                    if ((i6 & 131072) != 0) {
                        textStyle3 = (TextStyle) gapComposer.consume(LocalTextStyle);
                        i33 &= -29360129;
                    } else {
                        textStyle3 = textStyle;
                    }
                    i39 = 1;
                } else {
                    if (i40 != 0) {
                        modifier4 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i8 != 0) {
                        j5 = Color.Unspecified;
                    }
                    if (i11 != 0) {
                        j10 = TextUnit.Unspecified;
                    } else {
                        j10 = j2;
                    }
                    if (i13 != 0) {
                        fontStyle2 = null;
                    }
                    if (i15 != 0) {
                        fontWeight2 = null;
                    }
                    if (i18 != 0) {
                        j11 = TextUnit.Unspecified;
                    } else {
                        j11 = j3;
                    }
                    if (i21 == 0) {
                    }
                    j12 = TextUnit.Unspecified;
                    if (i26 != 0) {
                        i38 = 1;
                    } else {
                        i38 = i;
                    }
                    if (i34 != 0) {
                        i31 = Integer.MAX_VALUE;
                    }
                    if ((i6 & 131072) != 0) {
                        textStyle3 = (TextStyle) gapComposer.consume(LocalTextStyle);
                        i33 &= -29360129;
                    } else {
                        textStyle3 = textStyle;
                    }
                    i39 = 1;
                }
                gapComposer.endDefaults();
                gapComposer.startReplaceGroup(-565217490);
                if (j5 != 16) {
                    modifier4 = modifier4;
                    i39 = i39;
                    jM649getColor0d7_KjU = j5;
                    z5 = false;
                } else {
                    gapComposer.startReplaceGroup(-565216717);
                    jM649getColor0d7_KjU = textStyle3.m649getColor0d7_KjU();
                    if (jM649getColor0d7_KjU != 16) {
                        jM649getColor0d7_KjU = ((Color) gapComposer.consume(ContentColorKt.LocalContentColor)).value;
                    }
                    z5 = false;
                    gapComposer.end(false);
                }
                gapComposer.end(z5);
                if (textAlign3 != null) {
                    r3 = textAlign3.value;
                } else {
                    r3 = z5;
                }
                int i48 = r3 == true ? 1 : 0;
                int i49 = i33 << 6;
                Modifier modifier7 = modifier4;
                int i410 = i39;
                BasicTextKt.m166BasicTextRWo7tUw(str, modifier7, TextStyle.m648mergedA7vx0o$default(textStyle3, jM649getColor0d7_KjU, j10, fontWeight2, fontStyle2, j11, i48, j12, 16609104), i38, z2, i31, i410, gapComposer, (i20 & 126) | 3072 | (i49 & 57344) | 196608 | (i49 & 3670016) | 12582912 | ((i20 << 18) & 1879048192), 256);
                i37 = i38;
                j6 = j5;
                i35 = i410;
                modifier3 = modifier7;
                textStyle2 = textStyle3;
                j9 = j12;
                z4 = z2;
                i36 = i31;
                j7 = j10;
                fontWeight3 = fontWeight2;
                textAlign2 = textAlign3;
                j8 = j11;
            } else {
                gapComposer.skipToGroupEnd();
                z4 = z;
                i35 = i3;
                textStyle2 = textStyle;
                i36 = i31;
                modifier3 = modifier2;
                fontWeight3 = fontWeight2;
                j6 = j5;
                j7 = j2;
                j8 = j3;
                textAlign2 = textAlign;
                j9 = j4;
                i37 = i;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                        int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                        TextKt.m275TextNvy7gAk(str, modifier3, j6, j7, fontStyle2, fontWeight3, j8, textAlign2, j9, i37, z4, i36, i35, textStyle2, (GapComposer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i6);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i7 |= 384;
        j5 = j;
        i10 = i7 | 3072;
        i11 = i6 & 16;
        if (i11 != 0) {
            i10 = i7 | 27648;
        } else if ((i4 & 24576) == 0) {
            if (gapComposer.changed(j2)) {
                i12 = 16384;
            } else {
                i12 = 8192;
            }
            i10 |= i12;
        }
        i13 = i6 & 32;
        if (i13 != 0) {
            i10 |= 196608;
            fontStyle2 = fontStyle;
        } else {
            fontStyle2 = fontStyle;
            if ((i4 & 196608) == 0) {
                if (gapComposer.changed(fontStyle2)) {
                    i14 = 131072;
                } else {
                    i14 = 65536;
                }
                i10 |= i14;
            }
        }
        i15 = i6 & 64;
        if (i15 != 0) {
            i10 |= 1572864;
            fontWeight2 = fontWeight;
        } else {
            fontWeight2 = fontWeight;
            if ((i4 & 1572864) == 0) {
                if (gapComposer.changed(fontWeight2)) {
                    i16 = 1048576;
                } else {
                    i16 = 524288;
                }
                i10 |= i16;
            }
        }
        i17 = i10 | 12582912;
        i18 = i6 & 256;
        if (i18 != 0) {
            i17 = i10 | 113246208;
        } else if ((100663296 & i4) == 0) {
            if (gapComposer.changed(j3)) {
                i19 = 67108864;
            } else {
                i19 = 33554432;
            }
            i17 |= i19;
        }
        i20 = i17 | 805306368;
        i21 = i6 & 1024;
        if (i21 != 0) {
            i23 = i5 | 6;
        } else {
            if (gapComposer.changed(textAlign)) {
                i22 = 4;
            } else {
                i22 = 2;
            }
            i23 = i5 | i22;
        }
        i24 = i23;
        i25 = i24 | 48;
        i26 = i6 & 4096;
        if (i26 != 0) {
            i27 = i24 | 432;
        } else {
            if ((i5 & 384) != 0) {
                if (gapComposer.changed(i)) {
                    i28 = 256;
                } else {
                    i28 = 128;
                }
                i25 |= i28;
            }
            i27 = i25;
        }
        i29 = i27 | 3072;
        i30 = i6 & 16384;
        if (i30 != 0) {
            i32 = i27 | 27648;
            i31 = i2;
        } else if ((i5 & 24576) == 0) {
            i31 = i2;
            i32 = i29 | (gapComposer.changed(i31) ? 16384 : 8192);
        } else {
            i31 = i2;
            i32 = i29;
        }
        i33 = i32 | 1769472;
        if ((i5 & 12582912) == 0) {
            if ((i6 & 131072) == 0) {
                i34 = i30;
                if (gapComposer.changed(textStyle)) {
                }
                i33 |= i41;
            } else {
                i34 = i30;
            }
            i33 |= i41;
        } else {
            i34 = i30;
        }
        z2 = true;
        if ((i20 & 306783379) == 306783378) {
            z3 = true;
        } else {
            z3 = true;
        }
        if (gapComposer.shouldExecute(i20 & 1, z3)) {
            gapComposer.startDefaults();
            if ((i4 & 1) != 0) {
                if (i40 != 0) {
                    modifier4 = Modifier.Companion.$$INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i8 != 0) {
                    j5 = Color.Unspecified;
                }
                if (i11 != 0) {
                    j10 = TextUnit.Unspecified;
                } else {
                    j10 = j2;
                }
                if (i13 != 0) {
                    fontStyle2 = null;
                }
                if (i15 != 0) {
                    fontWeight2 = null;
                }
                if (i18 != 0) {
                    j11 = TextUnit.Unspecified;
                } else {
                    j11 = j3;
                }
                if (i21 == 0) {
                }
                j12 = TextUnit.Unspecified;
                if (i26 != 0) {
                    i38 = 1;
                } else {
                    i38 = i;
                }
                if (i34 != 0) {
                    i31 = Integer.MAX_VALUE;
                }
                if ((i6 & 131072) != 0) {
                    textStyle3 = (TextStyle) gapComposer.consume(LocalTextStyle);
                    i33 &= -29360129;
                } else {
                    textStyle3 = textStyle;
                }
                i39 = 1;
            } else {
                if (i40 != 0) {
                    modifier4 = Modifier.Companion.$$INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i8 != 0) {
                    j5 = Color.Unspecified;
                }
                if (i11 != 0) {
                    j10 = TextUnit.Unspecified;
                } else {
                    j10 = j2;
                }
                if (i13 != 0) {
                    fontStyle2 = null;
                }
                if (i15 != 0) {
                    fontWeight2 = null;
                }
                if (i18 != 0) {
                    j11 = TextUnit.Unspecified;
                } else {
                    j11 = j3;
                }
                if (i21 == 0) {
                }
                j12 = TextUnit.Unspecified;
                if (i26 != 0) {
                    i38 = 1;
                } else {
                    i38 = i;
                }
                if (i34 != 0) {
                    i31 = Integer.MAX_VALUE;
                }
                if ((i6 & 131072) != 0) {
                    textStyle3 = (TextStyle) gapComposer.consume(LocalTextStyle);
                    i33 &= -29360129;
                } else {
                    textStyle3 = textStyle;
                }
                i39 = 1;
            }
            gapComposer.endDefaults();
            gapComposer.startReplaceGroup(-565217490);
            if (j5 != 16) {
                modifier4 = modifier4;
                i39 = i39;
                jM649getColor0d7_KjU = j5;
                z5 = false;
            } else {
                gapComposer.startReplaceGroup(-565216717);
                jM649getColor0d7_KjU = textStyle3.m649getColor0d7_KjU();
                if (jM649getColor0d7_KjU != 16) {
                    jM649getColor0d7_KjU = ((Color) gapComposer.consume(ContentColorKt.LocalContentColor)).value;
                }
                z5 = false;
                gapComposer.end(false);
            }
            gapComposer.end(z5);
            if (textAlign3 != null) {
                r3 = textAlign3.value;
            } else {
                r3 = z5;
            }
            int i411 = r3 == true ? 1 : 0;
            int i412 = i33 << 6;
            Modifier modifier8 = modifier4;
            int i413 = i39;
            BasicTextKt.m166BasicTextRWo7tUw(str, modifier8, TextStyle.m648mergedA7vx0o$default(textStyle3, jM649getColor0d7_KjU, j10, fontWeight2, fontStyle2, j11, i411, j12, 16609104), i38, z2, i31, i413, gapComposer, (i20 & 126) | 3072 | (i412 & 57344) | 196608 | (i412 & 3670016) | 12582912 | ((i20 << 18) & 1879048192), 256);
            i37 = i38;
            j6 = j5;
            i35 = i413;
            modifier3 = modifier8;
            textStyle2 = textStyle3;
            j9 = j12;
            z4 = z2;
            i36 = i31;
            j7 = j10;
            fontWeight3 = fontWeight2;
            textAlign2 = textAlign3;
            j8 = j11;
        } else {
            gapComposer.skipToGroupEnd();
            z4 = z;
            i35 = i3;
            textStyle2 = textStyle;
            i36 = i31;
            modifier3 = modifier2;
            fontWeight3 = fontWeight2;
            j6 = j5;
            j7 = j2;
            j8 = j3;
            textAlign2 = textAlign;
            j9 = j4;
            i37 = i;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i4 | 1);
                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(i5);
                    TextKt.m275TextNvy7gAk(str, modifier3, j6, j7, fontStyle2, fontWeight3, j8, textAlign2, j9, i37, z4, i36, i35, textStyle2, (GapComposer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i6);
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
