package com.google.android.gms.internal.mlkit_vision_common;

import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonKt$$ExternalSyntheticLambda0;
import androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda0;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.MenuKt$$ExternalSyntheticLambda1;
import androidx.compose.material3.RadioButtonColors;
import androidx.compose.material3.RadioButtonKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.SwitchColors;
import androidx.compose.material3.SwitchKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.tokens.RadioButtonTokens;
import androidx.compose.material3.tokens.SwitchTokens;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Density;
import androidx.core.view.MenuHostHelper;
import com.github.kr328.clash.compose.FilesScreenKt;
import com.github.kr328.clash.compose.FilesScreenKt$$ExternalSyntheticLambda1;
import com.github.kr328.clash.compose.LogcatScreenKt;
import com.github.kr328.clash.compose.LogsScreenKt;
import com.github.kr328.clash.compose.home.HomeScreenKt$$ExternalSyntheticLambda3;
import com.github.kr328.clash.compose.proxy.ProxyScreenKt$$ExternalSyntheticLambda8;
import com.github.kr328.clash.compose.util.TvGlassTabRowKt$$ExternalSyntheticLambda2;
import com.github.kr328.clash.design.compose.components.ComposableSingletons$PreferencesKt;
import com.github.kr328.clash.design.compose.components.PreferencesKt$$ExternalSyntheticLambda7;
import com.github.kr328.clash.design.compose.components.PreferencesKt$$ExternalSyntheticLambda9;
import com.github.kr328.clash.design.compose.theme.AppColors;
import com.github.kr328.clash.design.compose.theme.AppColorsKt;
import com.google.android.gms.internal.mlkit_vision_common.zzjo;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt__StringsKt$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzjo {
    public static final void PreferenceCategory(String str, Modifier modifier, GapComposer gapComposer, int i) {
        Modifier modifier2;
        gapComposer.startRestartGroup(-1666033604);
        int i2 = i | (gapComposer.changed(str) ? 4 : 2) | 48;
        if ((i2 & 19) == 18 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
        } else {
            AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            TextStyle textStyle = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.labelLarge;
            long j = appColors.textSecondary;
            FontWeight fontWeight = FontWeight.SemiBold;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            float f = 8;
            TextKt.m275TextNvy7gAk(str, OffsetKt.m131paddingqDBjuR0(SizeKt.fillMaxWidth(companion, 1.0f), f, 16, f, f), j, 0L, null, fontWeight, 0L, null, 0L, 0, false, 0, 0, textStyle, gapComposer, (i2 & 14) | 1572864, 0, 131000);
            modifier2 = companion;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new PreferencesKt$$ExternalSyntheticLambda7(str, modifier2, i, 1);
        }
    }

    /* JADX WARN: Code duplicated, block: B:47:0x0072  */
    /* JADX WARN: Code duplicated, block: B:49:0x0076  */
    /* JADX WARN: Code duplicated, block: B:51:0x0079  */
    /* JADX WARN: Code duplicated, block: B:53:0x0081  */
    /* JADX WARN: Code duplicated, block: B:54:0x0084  */
    /* JADX WARN: Code duplicated, block: B:58:0x0093  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:63:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:64:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:69:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:70:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:74:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:76:? A[RETURN, SYNTHETIC] */
    public static final void PreferenceClickable(String str, Function0 function0, Modifier modifier, String str2, ImageVector imageVector, boolean z, Function2 function2, GapComposer gapComposer, int i, int i2) {
        int i3;
        ImageVector imageVector2;
        int i4;
        boolean z2;
        int i5;
        int i6;
        Modifier modifier2;
        ImageVector imageVector3;
        boolean z3;
        ImageVector imageVector4;
        Modifier modifier3;
        Function2 function3;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        gapComposer.startRestartGroup(751960958);
        if ((i & 6) == 0) {
            i3 = (gapComposer.changed(str) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= gapComposer.changedInstance(function0) ? 32 : 16;
        }
        int i7 = i2 & 4;
        if (i7 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= gapComposer.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= gapComposer.changed(str2) ? 2048 : 1024;
        }
        int i8 = i2 & 16;
        if (i8 == 0) {
            if ((i & 24576) == 0) {
                imageVector2 = imageVector;
                i3 |= gapComposer.changed(imageVector2) ? 16384 : 8192;
            }
            i4 = i2 & 32;
            if (i4 != 0) {
                if ((196608 & i) == 0) {
                    z2 = z;
                    if (gapComposer.changed(z2)) {
                        i5 = 131072;
                    } else {
                        i5 = 65536;
                    }
                    i3 |= i5;
                }
                i6 = i3 | 1572864;
                if ((599187 & i6) == 599186 || !gapComposer.getSkipping()) {
                    if (i7 != 0) {
                        modifier2 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier2 = modifier;
                    }
                    if (i8 != 0) {
                        imageVector3 = null;
                    } else {
                        imageVector3 = imageVector2;
                    }
                    if (i4 != 0) {
                        z3 = true;
                    } else {
                        z3 = z2;
                    }
                    ComposableLambdaImpl composableLambdaImpl = ComposableSingletons$PreferencesKt.f31lambda1;
                    Modifier modifier4 = modifier2;
                    PreferenceContainer(modifier4, z3, function0, Thread_jvmKt.rememberComposableLambda(934161934, new LogsScreenKt.AnonymousClass1.AnonymousClass3(imageVector3, str, str2), gapComposer), gapComposer, ((i6 >> 6) & 14) | 3072 | ((i6 >> 12) & 112) | ((i6 << 3) & 896));
                    imageVector4 = imageVector3;
                    modifier3 = modifier4;
                    function3 = composableLambdaImpl;
                } else {
                    gapComposer.skipToGroupEnd();
                    modifier3 = modifier;
                    function3 = function2;
                    imageVector4 = imageVector2;
                    z3 = z2;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new ButtonKt$$ExternalSyntheticLambda0(str, function0, modifier3, str2, imageVector4, z3, function3, i, i2);
                }
            }
            i3 |= 196608;
            z2 = z;
            i6 = i3 | 1572864;
            if ((599187 & i6) == 599186) {
                if (i7 != 0) {
                    modifier2 = Modifier.Companion.$$INSTANCE;
                } else {
                    modifier2 = modifier;
                }
                if (i8 != 0) {
                    imageVector3 = null;
                } else {
                    imageVector3 = imageVector2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                ComposableLambdaImpl composableLambdaImpl2 = ComposableSingletons$PreferencesKt.f31lambda1;
                Modifier modifier5 = modifier2;
                PreferenceContainer(modifier5, z3, function0, Thread_jvmKt.rememberComposableLambda(934161934, new LogsScreenKt.AnonymousClass1.AnonymousClass3(imageVector3, str, str2), gapComposer), gapComposer, ((i6 >> 6) & 14) | 3072 | ((i6 >> 12) & 112) | ((i6 << 3) & 896));
                imageVector4 = imageVector3;
                modifier3 = modifier5;
                function3 = composableLambdaImpl2;
            } else {
                if (i7 != 0) {
                    modifier2 = Modifier.Companion.$$INSTANCE;
                } else {
                    modifier2 = modifier;
                }
                if (i8 != 0) {
                    imageVector3 = null;
                } else {
                    imageVector3 = imageVector2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                ComposableLambdaImpl composableLambdaImpl3 = ComposableSingletons$PreferencesKt.f31lambda1;
                Modifier modifier6 = modifier2;
                PreferenceContainer(modifier6, z3, function0, Thread_jvmKt.rememberComposableLambda(934161934, new LogsScreenKt.AnonymousClass1.AnonymousClass3(imageVector3, str, str2), gapComposer), gapComposer, ((i6 >> 6) & 14) | 3072 | ((i6 >> 12) & 112) | ((i6 << 3) & 896));
                imageVector4 = imageVector3;
                modifier3 = modifier6;
                function3 = composableLambdaImpl3;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new ButtonKt$$ExternalSyntheticLambda0(str, function0, modifier3, str2, imageVector4, z3, function3, i, i2);
            }
        }
        i3 |= 24576;
        imageVector2 = imageVector;
        i4 = i2 & 32;
        if (i4 != 0) {
            if ((196608 & i) == 0) {
                z2 = z;
                if (gapComposer.changed(z2)) {
                    i5 = 131072;
                } else {
                    i5 = 65536;
                }
                i3 |= i5;
            }
            i6 = i3 | 1572864;
            if ((599187 & i6) == 599186) {
                if (i7 != 0) {
                    modifier2 = Modifier.Companion.$$INSTANCE;
                } else {
                    modifier2 = modifier;
                }
                if (i8 != 0) {
                    imageVector3 = null;
                } else {
                    imageVector3 = imageVector2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                ComposableLambdaImpl composableLambdaImpl4 = ComposableSingletons$PreferencesKt.f31lambda1;
                Modifier modifier7 = modifier2;
                PreferenceContainer(modifier7, z3, function0, Thread_jvmKt.rememberComposableLambda(934161934, new LogsScreenKt.AnonymousClass1.AnonymousClass3(imageVector3, str, str2), gapComposer), gapComposer, ((i6 >> 6) & 14) | 3072 | ((i6 >> 12) & 112) | ((i6 << 3) & 896));
                imageVector4 = imageVector3;
                modifier3 = modifier7;
                function3 = composableLambdaImpl4;
            } else {
                if (i7 != 0) {
                    modifier2 = Modifier.Companion.$$INSTANCE;
                } else {
                    modifier2 = modifier;
                }
                if (i8 != 0) {
                    imageVector3 = null;
                } else {
                    imageVector3 = imageVector2;
                }
                if (i4 != 0) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                ComposableLambdaImpl composableLambdaImpl5 = ComposableSingletons$PreferencesKt.f31lambda1;
                Modifier modifier8 = modifier2;
                PreferenceContainer(modifier8, z3, function0, Thread_jvmKt.rememberComposableLambda(934161934, new LogsScreenKt.AnonymousClass1.AnonymousClass3(imageVector3, str, str2), gapComposer), gapComposer, ((i6 >> 6) & 14) | 3072 | ((i6 >> 12) & 112) | ((i6 << 3) & 896));
                imageVector4 = imageVector3;
                modifier3 = modifier8;
                function3 = composableLambdaImpl5;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new ButtonKt$$ExternalSyntheticLambda0(str, function0, modifier3, str2, imageVector4, z3, function3, i, i2);
            }
        }
        i3 |= 196608;
        z2 = z;
        i6 = i3 | 1572864;
        if ((599187 & i6) == 599186) {
            if (i7 != 0) {
                modifier2 = Modifier.Companion.$$INSTANCE;
            } else {
                modifier2 = modifier;
            }
            if (i8 != 0) {
                imageVector3 = null;
            } else {
                imageVector3 = imageVector2;
            }
            if (i4 != 0) {
                z3 = true;
            } else {
                z3 = z2;
            }
            ComposableLambdaImpl composableLambdaImpl6 = ComposableSingletons$PreferencesKt.f31lambda1;
            Modifier modifier9 = modifier2;
            PreferenceContainer(modifier9, z3, function0, Thread_jvmKt.rememberComposableLambda(934161934, new LogsScreenKt.AnonymousClass1.AnonymousClass3(imageVector3, str, str2), gapComposer), gapComposer, ((i6 >> 6) & 14) | 3072 | ((i6 >> 12) & 112) | ((i6 << 3) & 896));
            imageVector4 = imageVector3;
            modifier3 = modifier9;
            function3 = composableLambdaImpl6;
        } else {
            if (i7 != 0) {
                modifier2 = Modifier.Companion.$$INSTANCE;
            } else {
                modifier2 = modifier;
            }
            if (i8 != 0) {
                imageVector3 = null;
            } else {
                imageVector3 = imageVector2;
            }
            if (i4 != 0) {
                z3 = true;
            } else {
                z3 = z2;
            }
            ComposableLambdaImpl composableLambdaImpl7 = ComposableSingletons$PreferencesKt.f31lambda1;
            Modifier modifier10 = modifier2;
            PreferenceContainer(modifier10, z3, function0, Thread_jvmKt.rememberComposableLambda(934161934, new LogsScreenKt.AnonymousClass1.AnonymousClass3(imageVector3, str, str2), gapComposer), gapComposer, ((i6 >> 6) & 14) | 3072 | ((i6 >> 12) & 112) | ((i6 << 3) & 896));
            imageVector4 = imageVector3;
            modifier3 = modifier10;
            function3 = composableLambdaImpl7;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ButtonKt$$ExternalSyntheticLambda0(str, function0, modifier3, str2, imageVector4, z3, function3, i, i2);
        }
    }

    public static final void PreferenceContainer(Modifier modifier, boolean z, Function0 function0, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        int i2;
        gapComposer.startRestartGroup(-799462406);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl) ? 2048 : 1024;
        }
        if ((i2 & 1171) == 1170 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            gapComposer.startReplaceGroup(104888033);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            gapComposer.end(false);
            Modifier modifierAlpha = ClipKt.alpha(SizeKt.fillMaxWidth(modifier, 1.0f), z ? 1.0f : 0.4f);
            gapComposer.startReplaceGroup(104894587);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new PreferencesKt$$ExternalSyntheticLambda9(mutableState, 0);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            gapComposer.end(false);
            Modifier modifierOnFocusChanged = FocusTraversalKt.onFocusChanged(modifierAlpha, (Function1) objRememberedValue2);
            float f = ((Boolean) mutableState.getValue()).booleanValue() ? 2 : 0;
            long j = ((Boolean) mutableState.getValue()).booleanValue() ? Color.White : Color.Transparent;
            float f2 = 12;
            zzjl.m819GlassSurfaceYxtnGt4(ImageKt.m48borderxT4_qwU(f, j, modifierOnFocusChanged, RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(f2)), f2, null, Thread_jvmKt.rememberComposableLambda(879372279, new FilesScreenKt.AnonymousClass4(3, function0, composableLambdaImpl, z), gapComposer), gapComposer, 196656, 28);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new HomeScreenKt$$ExternalSyntheticLambda3(modifier, z, function0, composableLambdaImpl, i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0052  */
    /* JADX WARN: Code duplicated, block: B:19:? A[RETURN, SYNTHETIC] */
    public static final void PreferenceLeadingIcon(ImageVector imageVector, GapComposer gapComposer, int i) {
        ImageVector imageVector2;
        GapComposer gapComposer2;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        gapComposer.startRestartGroup(1149494007);
        int i2 = (gapComposer.changed(imageVector) ? 4 : 2) | i;
        if ((i2 & 3) != 2 || !gapComposer.getSkipping()) {
            if (imageVector != null) {
                long j = ((AppColors) gapComposer.consume(AppColorsKt.LocalAppColors)).textPrimary;
                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                imageVector2 = imageVector;
                gapComposer2 = gapComposer;
                IconKt.m249Iconww6aTOc(imageVector2, null, SizeKt.m140size3ABfNKs(companion, 24), j, gapComposer2, (i2 & 14) | 432, 0);
                OffsetKt.Spacer(gapComposer2, SizeKt.m144width3ABfNKs(companion, 16));
            }
            recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new StringsKt__StringsKt$$ExternalSyntheticLambda0(imageVector2, i);
            }
        }
        gapComposer.skipToGroupEnd();
        imageVector2 = imageVector;
        gapComposer2 = gapComposer;
        recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new StringsKt__StringsKt$$ExternalSyntheticLambda0(imageVector2, i);
        }
    }

    public static final void PreferenceSelectable(String str, List list, List list2, int i, Function1 function1, Modifier modifier, ImageVector imageVector, boolean z, GapComposer gapComposer, int i2, int i3) {
        ImageVector imageVector2;
        int i4;
        boolean z2;
        int i5;
        Modifier modifier2;
        ImageVector imageVector3;
        boolean z3;
        gapComposer.startRestartGroup(1728081970);
        int i6 = i2 | (gapComposer.changed(str) ? 4 : 2) | (gapComposer.changedInstance(list2) ? 256 : 128) | (gapComposer.changed(i) ? 2048 : 1024) | (gapComposer.changedInstance(function1) ? 16384 : 8192);
        int i7 = 196608 | i6;
        int i8 = i3 & 64;
        if (i8 != 0) {
            i4 = i6 | 1769472;
            imageVector2 = imageVector;
        } else {
            imageVector2 = imageVector;
            i4 = i7 | (gapComposer.changed(imageVector2) ? 1048576 : 524288);
        }
        int i9 = i3 & 128;
        if (i9 != 0) {
            i5 = i4 | 12582912;
            z2 = z;
        } else {
            z2 = z;
            i5 = i4 | (gapComposer.changed(z2) ? 8388608 : 4194304);
        }
        if ((4793475 & i5) == 4793474 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
            imageVector3 = imageVector2;
            z3 = z2;
        } else {
            if (i8 != 0) {
                imageVector2 = null;
            }
            ImageVector imageVector4 = imageVector2;
            boolean z4 = i9 != 0 ? true : z2;
            gapComposer.startReplaceGroup(-768013190);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            gapComposer.end(false);
            String str2 = (String) CollectionsKt.getOrNull(i, list2);
            gapComposer.startReplaceGroup(-768005651);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new ProxyScreenKt$$ExternalSyntheticLambda8(mutableState, 10);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            gapComposer.end(false);
            int i10 = i5 & 14;
            int i11 = i5 >> 6;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            PreferenceClickable(str, (Function0) objRememberedValue2, companion, str2, imageVector4, z4, null, gapComposer, i10 | 432 | (i11 & 57344) | (i11 & 458752), 64);
            if (((Boolean) mutableState.getValue()).booleanValue()) {
                gapComposer.startReplaceGroup(-767998829);
                boolean z5 = (i5 & 57344) == 16384;
                Object objRememberedValue3 = gapComposer.rememberedValue();
                if (z5 || objRememberedValue3 == neverEqualPolicy) {
                    objRememberedValue3 = new FilesScreenKt$$ExternalSyntheticLambda1(function1, mutableState, 12);
                    gapComposer.updateRememberedValue(objRememberedValue3);
                }
                Function1 function2 = (Function1) objRememberedValue3;
                Object objM = Density.CC.m(-767995154, gapComposer, false);
                if (objM == neverEqualPolicy) {
                    objM = new ProxyScreenKt$$ExternalSyntheticLambda8(mutableState, 11);
                    gapComposer.updateRememberedValue(objM);
                }
                gapComposer.end(false);
                int i12 = i5 >> 3;
                SelectableListDialog(str, list2, i, function2, (Function0) objM, gapComposer, i10 | 24576 | (i12 & 112) | (i12 & 896));
            }
            modifier2 = companion;
            imageVector3 = imageVector4;
            z3 = z4;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ButtonKt$$ExternalSyntheticLambda0(str, list, list2, i, function1, modifier2, imageVector3, z3, i2, i3);
        }
    }

    public static final void PreferenceSwitch(final String str, final boolean z, final Function1 function1, Modifier modifier, final String str2, ImageVector imageVector, boolean z2, GapComposer gapComposer, final int i, final int i2) {
        ImageVector imageVector2;
        int i3;
        boolean z3;
        int i4;
        final ImageVector imageVector3;
        final Modifier modifier2;
        final boolean z4;
        gapComposer.startRestartGroup(2059442840);
        int i5 = i | (gapComposer.changed(str) ? 4 : 2) | (gapComposer.changed(z) ? 32 : 16) | (gapComposer.changedInstance(function1) ? 256 : 128) | 3072 | (gapComposer.changed(str2) ? 16384 : 8192);
        int i6 = i2 & 32;
        if (i6 != 0) {
            i3 = i5 | 196608;
            imageVector2 = imageVector;
        } else {
            imageVector2 = imageVector;
            i3 = i5 | (gapComposer.changed(imageVector2) ? 131072 : 65536);
        }
        int i7 = i2 & 64;
        if (i7 != 0) {
            i4 = i3 | 1572864;
            z3 = z2;
        } else {
            z3 = z2;
            i4 = i3 | (gapComposer.changed(z3) ? 1048576 : 524288);
        }
        int i8 = i4;
        if ((599187 & i8) == 599186 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
            imageVector3 = imageVector2;
            z4 = z3;
            modifier2 = modifier;
        } else {
            final ImageVector imageVector4 = i6 != 0 ? null : imageVector2;
            if (i7 != 0) {
                z3 = true;
            }
            gapComposer.startReplaceGroup(1804599763);
            boolean z5 = ((i8 & 112) == 32) | ((i8 & 896) == 256);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (z5 || objRememberedValue == Composer$Companion.Empty) {
                objRememberedValue = new CheckboxKt$$ExternalSyntheticLambda0(function1, z, 4);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            gapComposer.end(false);
            final boolean z6 = z3;
            imageVector3 = imageVector4;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            PreferenceContainer(companion, z6, (Function0) objRememberedValue, Thread_jvmKt.rememberComposableLambda(671523336, new Function3() { // from class: com.github.kr328.clash.design.compose.components.PreferencesKt$PreferenceSwitch$2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    RowScope rowScope = (RowScope) obj;
                    GapComposer gapComposer2 = (GapComposer) obj2;
                    int iIntValue = ((Number) obj3).intValue();
                    if ((iIntValue & 6) == 0) {
                        iIntValue |= gapComposer2.changed(rowScope) ? 4 : 2;
                    }
                    if ((iIntValue & 19) == 18 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        zzjo.PreferenceLeadingIcon(imageVector4, gapComposer2, 0);
                        zzjo.PreferenceTexts(str, str2, rowScope.weight(), gapComposer2, 0);
                        Function1 function2 = z6 ? function1 : null;
                        StaticProvidableCompositionLocal staticProvidableCompositionLocal = AppColorsKt.LocalAppColors;
                        long j = ((AppColors) gapComposer2.consume(staticProvidableCompositionLocal)).textPrimary;
                        long j2 = ((AppColors) gapComposer2.consume(staticProvidableCompositionLocal)).buttonActiveEnd;
                        long j3 = ((AppColors) gapComposer2.consume(staticProvidableCompositionLocal)).textSecondary;
                        long j4 = ((AppColors) gapComposer2.consume(staticProvidableCompositionLocal)).cardBackground;
                        long j5 = ((AppColors) gapComposer2.consume(staticProvidableCompositionLocal)).cardBorder;
                        long j6 = Color.Transparent;
                        float f = SwitchTokens.PressedHandleWidth;
                        long value = ColorSchemeKt.getValue(11, gapComposer2);
                        long value2 = ColorSchemeKt.getValue(39, gapComposer2);
                        long value3 = ColorSchemeKt.getValue(35, gapComposer2);
                        long jColor = BrushKt.Color(Color.m440getRedimpl(value3), Color.m439getGreenimpl(value3), Color.m437getBlueimpl(value3), 1.0f, Color.m438getColorSpaceimpl(value3));
                        StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                        Function1 function3 = function2;
                        long jM414compositeOverOWjLjI = BrushKt.m414compositeOverOWjLjI(jColor, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal2)).colorScheme.surface);
                        long value4 = ColorSchemeKt.getValue(18, gapComposer2);
                        long jM414compositeOverOWjLjI2 = BrushKt.m414compositeOverOWjLjI(BrushKt.Color(Color.m440getRedimpl(value4), Color.m439getGreenimpl(value4), Color.m437getBlueimpl(value4), 0.12f, Color.m438getColorSpaceimpl(value4)), ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal2)).colorScheme.surface);
                        long value5 = ColorSchemeKt.getValue(18, gapComposer2);
                        long jM414compositeOverOWjLjI3 = BrushKt.m414compositeOverOWjLjI(BrushKt.Color(Color.m440getRedimpl(value5), Color.m439getGreenimpl(value5), Color.m437getBlueimpl(value5), 0.38f, Color.m438getColorSpaceimpl(value5)), ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal2)).colorScheme.surface);
                        long value6 = ColorSchemeKt.getValue(18, gapComposer2);
                        long jM414compositeOverOWjLjI4 = BrushKt.m414compositeOverOWjLjI(BrushKt.Color(Color.m440getRedimpl(value6), Color.m439getGreenimpl(value6), Color.m437getBlueimpl(value6), 0.38f, Color.m438getColorSpaceimpl(value6)), ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal2)).colorScheme.surface);
                        long value7 = ColorSchemeKt.getValue(39, gapComposer2);
                        long jM414compositeOverOWjLjI5 = BrushKt.m414compositeOverOWjLjI(BrushKt.Color(Color.m440getRedimpl(value7), Color.m439getGreenimpl(value7), Color.m437getBlueimpl(value7), 0.12f, Color.m438getColorSpaceimpl(value7)), ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal2)).colorScheme.surface);
                        long value8 = ColorSchemeKt.getValue(18, gapComposer2);
                        long jM414compositeOverOWjLjI6 = BrushKt.m414compositeOverOWjLjI(BrushKt.Color(Color.m440getRedimpl(value8), Color.m439getGreenimpl(value8), Color.m437getBlueimpl(value8), 0.12f, Color.m438getColorSpaceimpl(value8)), ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal2)).colorScheme.surface);
                        long value9 = ColorSchemeKt.getValue(39, gapComposer2);
                        SwitchKt.Switch(z, function3, null, false, new SwitchColors(j, j2, j6, value, j3, j4, j5, value2, jM414compositeOverOWjLjI, jM414compositeOverOWjLjI2, j6, jM414compositeOverOWjLjI3, jM414compositeOverOWjLjI4, jM414compositeOverOWjLjI5, jM414compositeOverOWjLjI6, BrushKt.m414compositeOverOWjLjI(BrushKt.Color(Color.m440getRedimpl(value9), Color.m439getGreenimpl(value9), Color.m437getBlueimpl(value9), 0.38f, Color.m438getColorSpaceimpl(value9)), ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal2)).colorScheme.surface)), gapComposer2, 0);
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, 3078 | ((i8 >> 15) & 112));
            modifier2 = companion;
            z4 = z6;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2(str, z, function1, modifier2, str2, imageVector3, z4, i, i2) { // from class: com.github.kr328.clash.design.compose.components.PreferencesKt$$ExternalSyntheticLambda2
                public final /* synthetic */ String f$0;
                public final /* synthetic */ boolean f$1;
                public final /* synthetic */ Function1 f$2;
                public final /* synthetic */ Modifier f$3;
                public final /* synthetic */ String f$4;
                public final /* synthetic */ ImageVector f$5;
                public final /* synthetic */ boolean f$6;
                public final /* synthetic */ int f$8;

                {
                    this.f$8 = i2;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                    zzjo.PreferenceSwitch(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, (GapComposer) obj, iUpdateChangedFlags, this.f$8);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void PreferenceTexts(String str, String str2, Modifier modifier, GapComposer gapComposer, int i) {
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(-1968981715);
        int i2 = i | (gapComposer2.changed(str) ? 4 : 2) | (gapComposer2.changed(str2) ? 32 : 16) | (gapComposer2.changed(modifier) ? 256 : 128);
        if ((i2 & 147) == 146 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Center, Alignment.Companion.Start, gapComposer2, 6);
            long j = gapComposer2.compositeKeyHashCode;
            int i3 = (int) (j ^ (j >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifier);
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer2.useNode();
            }
            Stack.m295setimpl(gapComposer2, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m295setimpl(gapComposer2, Integer.valueOf(i3), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m294reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
            TextKt.m275TextNvy7gAk(str, null, appColors.textPrimary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.titleMedium, gapComposer2, i2 & 14, 0, 131066);
            gapComposer2 = gapComposer2;
            gapComposer2.startReplaceGroup(-1451517570);
            if (str2 != null && str2.length() != 0) {
                OffsetKt.Spacer(gapComposer2, SizeKt.m140size3ABfNKs(Modifier.Companion.$$INSTANCE, 2));
                TextKt.m275TextNvy7gAk(str2, null, appColors.textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.bodySmall, gapComposer, (i2 >> 3) & 14, 0, 131066);
                gapComposer2 = gapComposer;
            }
            gapComposer2.end(false);
            gapComposer2.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MenuKt$$ExternalSyntheticLambda1(str, str2, modifier, i, 13);
        }
    }

    public static final void PreferenceTip(String str, Modifier modifier, GapComposer gapComposer, int i) {
        GapComposer gapComposer2;
        gapComposer.startRestartGroup(-1917561177);
        if ((((gapComposer.changed(str) ? 4 : 2) | i | 48) & 19) == 18 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
            gapComposer2 = gapComposer;
        } else {
            AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            gapComposer2 = gapComposer;
            zzjl.m819GlassSurfaceYxtnGt4(SizeKt.fillMaxWidth(companion, 1.0f), 12, null, Thread_jvmKt.rememberComposableLambda(-632071030, new LogcatScreenKt.AnonymousClass2.AnonymousClass1(appColors, str, 5), gapComposer), gapComposer2, 196656, 28);
            modifier = companion;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new PreferencesKt$$ExternalSyntheticLambda7(str, modifier, i, 0);
        }
    }

    public static final void SelectableListDialog(final String str, final List list, final int i, final Function1 function1, final Function0 function0, GapComposer gapComposer, final int i2) {
        int i3;
        gapComposer.startRestartGroup(-2137976190);
        if ((i2 & 6) == 0) {
            i3 = (gapComposer.changed(str) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= gapComposer.changedInstance(list) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= gapComposer.changed(i) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= gapComposer.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= gapComposer.changedInstance(function0) ? 16384 : 8192;
        }
        if ((i3 & 9363) == 9362 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            final AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            ScrimKt.m263AlertDialogOix01E0(function0, Thread_jvmKt.rememberComposableLambda(1933116618, new LogsScreenKt.AnonymousClass2(function0, appColors, 19), gapComposer), null, null, null, Thread_jvmKt.rememberComposableLambda(-1672194354, new LogcatScreenKt.AnonymousClass2.AnonymousClass1(str, appColors, 6), gapComposer), Thread_jvmKt.rememberComposableLambda(-1499780273, new Function2() { // from class: com.github.kr328.clash.design.compose.components.PreferencesKt$SelectableListDialog$3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    PreferencesKt$SelectableListDialog$3 preferencesKt$SelectableListDialog$3 = this;
                    GapComposer gapComposer2 = (GapComposer) obj;
                    int i4 = 2;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                        float f = 1.0f;
                        Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                        boolean z = false;
                        ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, gapComposer2, 0);
                        MenuHostHelper menuHostHelper = gapComposer2.applier;
                        long j = gapComposer2.compositeKeyHashCode;
                        int i5 = (int) (j ^ (j >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierFillMaxWidth);
                        ComposeUiNode.Companion.getClass();
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                        gapComposer2.startReusableNode();
                        if (gapComposer2.inserting) {
                            gapComposer2.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer2.useNode();
                        }
                        Stack.m295setimpl(gapComposer2, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                        Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                        Stack.m295setimpl(gapComposer2, Integer.valueOf(i5), ComposeUiNode.Companion.SetCompositeKeyHash);
                        Stack.m294reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                        Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                        gapComposer2.startReplaceGroup(983175803);
                        int i6 = 0;
                        for (Object obj3 : list) {
                            int i7 = i6 + 1;
                            if (i6 < 0) {
                                AppCompatHintHelper.throwIndexOverflow();
                                throw null;
                            }
                            String str2 = (String) obj3;
                            float f2 = 8;
                            Modifier modifierClip = ClipKt.clip(SizeKt.fillMaxWidth(companion, f), RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(f2));
                            gapComposer2.startReplaceGroup(181351699);
                            Function1 function2 = function1;
                            boolean zChanged = gapComposer2.changed(function2) | gapComposer2.changed(i6);
                            Object objRememberedValue = gapComposer2.rememberedValue();
                            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
                            if (zChanged || objRememberedValue == neverEqualPolicy) {
                                objRememberedValue = new TvGlassTabRowKt$$ExternalSyntheticLambda2(i6, 1, function2);
                                gapComposer2.updateRememberedValue(objRememberedValue);
                            }
                            gapComposer2.end(z);
                            Modifier modifierM129paddingVpY3zN4 = OffsetKt.m129paddingVpY3zN4(ImageKt.m51clickableoSLSa3U$default(modifierClip, z, null, (Function0) objRememberedValue, 15), 4, f2);
                            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.CenterVertically, gapComposer2, 48);
                            long j2 = gapComposer2.compositeKeyHashCode;
                            int i8 = (int) (j2 ^ (j2 >>> 32));
                            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
                            Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer2, modifierM129paddingVpY3zN4);
                            ComposeUiNode.Companion.getClass();
                            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$2 = ComposeUiNode.Companion.Constructor;
                            gapComposer2.startReusableNode();
                            if (gapComposer2.inserting) {
                                gapComposer2.createNode(layoutNode$Companion$Constructor$2);
                            } else {
                                gapComposer2.useNode();
                            }
                            Stack.m295setimpl(gapComposer2, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope2, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                            Stack.m295setimpl(gapComposer2, Integer.valueOf(i8), ComposeUiNode.Companion.SetCompositeKeyHash);
                            Stack.m294reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier2, ComposeUiNode.Companion.SetModifier);
                            boolean z2 = i6 == i ? true : z;
                            gapComposer2.startReplaceGroup(-1632067566);
                            boolean zChanged2 = gapComposer2.changed(function2) | gapComposer2.changed(i6);
                            Object objRememberedValue2 = gapComposer2.rememberedValue();
                            if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                                objRememberedValue2 = new TvGlassTabRowKt$$ExternalSyntheticLambda2(i6, i4, function2);
                                gapComposer2.updateRememberedValue(objRememberedValue2);
                            }
                            Function0 function3 = (Function0) objRememberedValue2;
                            gapComposer2.end(z);
                            AppColors appColors2 = appColors;
                            long j3 = appColors2.buttonActiveEnd;
                            long j4 = appColors2.textSecondary;
                            long j5 = Color.Unspecified;
                            StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                            ColorScheme colorScheme = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme;
                            RadioButtonColors radioButtonColors = colorScheme.defaultRadioButtonColorsCached;
                            if (radioButtonColors == null) {
                                float f3 = RadioButtonTokens.IconSize;
                                long jFromToken = ColorSchemeKt.fromToken(colorScheme, 26);
                                long jFromToken2 = ColorSchemeKt.fromToken(colorScheme, 19);
                                long jFromToken3 = ColorSchemeKt.fromToken(colorScheme, 18);
                                long jColor = BrushKt.Color(Color.m440getRedimpl(jFromToken3), Color.m439getGreenimpl(jFromToken3), Color.m437getBlueimpl(jFromToken3), 0.38f, Color.m438getColorSpaceimpl(jFromToken3));
                                long jFromToken4 = ColorSchemeKt.fromToken(colorScheme, 18);
                                radioButtonColors = new RadioButtonColors(jFromToken, jFromToken2, jColor, BrushKt.Color(Color.m440getRedimpl(jFromToken4), Color.m439getGreenimpl(jFromToken4), Color.m437getBlueimpl(jFromToken4), 0.38f, Color.m438getColorSpaceimpl(jFromToken4)));
                                colorScheme.defaultRadioButtonColorsCached = radioButtonColors;
                            }
                            if (j3 == 16) {
                                j3 = radioButtonColors.selectedColor;
                            }
                            long j6 = j3;
                            if (j4 == 16) {
                                j4 = radioButtonColors.unselectedColor;
                            }
                            RadioButtonKt.RadioButton(z2, function3, null, false, new RadioButtonColors(j6, j4, j5 != 16 ? j5 : radioButtonColors.disabledSelectedColor, j5 != 16 ? j5 : radioButtonColors.disabledUnselectedColor), gapComposer2, 0);
                            OffsetKt.Spacer(gapComposer2, SizeKt.m144width3ABfNKs(companion, f2));
                            GapComposer gapComposer3 = gapComposer2;
                            TextKt.m275TextNvy7gAk(str2, null, appColors2.textPrimary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.bodyLarge, gapComposer3, 0, 0, 131066);
                            gapComposer2 = gapComposer3;
                            gapComposer2.end(true);
                            preferencesKt$SelectableListDialog$3 = this;
                            i6 = i7;
                            companion = companion;
                            i4 = 2;
                            f = 1.0f;
                            z = false;
                        }
                        gapComposer2.end(z);
                        gapComposer2.end(true);
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(20), BrushKt.m414compositeOverOWjLjI(appColors.cardBackground, appColors.appBackground), 0L, 0L, 0L, 0.0f, null, gapComposer, ((i3 >> 12) & 14) | 1769520, 15900);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.github.kr328.clash.design.compose.components.PreferencesKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).intValue();
                    zzjo.SelectableListDialog(str, list, i, function1, function0, (GapComposer) obj, Stack.updateChangedFlags(i2 | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
