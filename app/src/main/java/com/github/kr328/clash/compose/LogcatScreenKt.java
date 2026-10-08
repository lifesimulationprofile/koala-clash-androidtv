package com.github.kr328.clash.compose;

import androidx.activity.compose.BackHandlerKt;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.foundation.CombinedClickableElement;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.MenuKt$$ExternalSyntheticLambda1;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SnackbarHostKt$animatedScale$1$1;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetModifier$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayout$1;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.compose.ui.text.font.SystemFontFamily;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda1;
import coil.ImageLoader$Builder$$ExternalSyntheticLambda2;
import coil.network.HttpException;
import com.github.kr328.clash.core.model.LogMessage;
import com.github.kr328.clash.design.compose.theme.AppColors;
import com.github.kr328.clash.design.compose.theme.AppColorsKt;
import com.google.android.gms.internal.mlkit_vision_common.zzjl;
import dev.chrisbanes.haze.HazeEffectNodeElement;
import dev.chrisbanes.haze.HazeKt;
import dev.chrisbanes.haze.HazeSourceElement;
import dev.chrisbanes.haze.HazeState;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class LogcatScreenKt {
    public static final void LogMessageRow(final LogMessage logMessage, final SimpleDateFormat simpleDateFormat, final Function0 function0, GapComposer gapComposer, int i) {
        long jColor;
        gapComposer.startRestartGroup(-1804060368);
        if ((((gapComposer.changedInstance(logMessage) ? 4 : 2) | i | (gapComposer.changedInstance(simpleDateFormat) ? 32 : 16) | (gapComposer.changedInstance(function0) ? 256 : 128)) & 147) == 146 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = AppColorsKt.LocalAppColors;
            final AppColors appColors = (AppColors) gapComposer.consume(staticProvidableCompositionLocal);
            LogMessage.Level level = logMessage.level;
            gapComposer.startReplaceGroup(1378814742);
            AppColors appColors2 = (AppColors) gapComposer.consume(staticProvidableCompositionLocal);
            int iOrdinal = level.ordinal();
            if (iOrdinal == 0) {
                jColor = appColors2.textSecondary;
            } else if (iOrdinal == 1) {
                jColor = BrushKt.Color(4282557941L);
            } else if (iOrdinal == 2) {
                jColor = BrushKt.Color(4294940672L);
            } else if (iOrdinal == 3) {
                jColor = BrushKt.Color(4293874512L);
            } else {
                if (iOrdinal != 4 && iOrdinal != 5) {
                    throw new HttpException();
                }
                jColor = appColors2.textSecondary;
            }
            gapComposer.end(false);
            final long j = jColor;
            zzjl.m819GlassSurfaceYxtnGt4(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), 12, null, Thread_jvmKt.rememberComposableLambda(1590716717, new Function2() { // from class: com.github.kr328.clash.compose.LogcatScreenKt.LogMessageRow.1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    GapComposer gapComposer2 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                        Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                        gapComposer2.startReplaceGroup(1675323009);
                        Object objRememberedValue = gapComposer2.rememberedValue();
                        if (objRememberedValue == Composer$Companion.Empty) {
                            objRememberedValue = new ImageLoader$Builder$$ExternalSyntheticLambda2(23);
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        }
                        gapComposer2.end(false);
                        Modifier modifierM129paddingVpY3zN4 = OffsetKt.m129paddingVpY3zN4(modifierFillMaxWidth.then(new CombinedClickableElement((Function0) objRememberedValue, function0)), 14, 10);
                        ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, gapComposer2, 0);
                        long j2 = gapComposer2.compositeKeyHashCode;
                        int i2 = (int) (j2 ^ (j2 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierM129paddingVpY3zN4);
                        ComposeUiNode.Companion.getClass();
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                        gapComposer2.startReusableNode();
                        if (gapComposer2.inserting) {
                            gapComposer2.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer2.useNode();
                        }
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$1 = ComposeUiNode.Companion.SetMeasurePolicy;
                        Stack.m295setimpl(gapComposer2, columnMeasurePolicy, composeUiNode$Companion$SetModifier$1);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                        Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, composeUiNode$Companion$SetModifier$2);
                        Integer numValueOf = Integer.valueOf(i2);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
                        Stack.m295setimpl(gapComposer2, numValueOf, composeUiNode$Companion$SetModifier$3);
                        OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
                        Stack.m294reconcileimpl(gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
                        Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
                        Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                        RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.CenterVertically, gapComposer2, 48);
                        long j3 = gapComposer2.compositeKeyHashCode;
                        int i3 = (int) (j3 ^ (j3 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer2, modifierFillMaxWidth2);
                        gapComposer2.startReusableNode();
                        if (gapComposer2.inserting) {
                            gapComposer2.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer2.useNode();
                        }
                        Stack.m295setimpl(gapComposer2, rowMeasurePolicy, composeUiNode$Companion$SetModifier$1);
                        Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
                        ImageAnalysis$$ExternalSyntheticLambda1.m(i3, gapComposer2, composeUiNode$Companion$SetModifier$3, gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
                        Stack.m295setimpl(gapComposer2, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
                        long j4 = j;
                        float f = 6;
                        Modifier modifierM129paddingVpY3zN5 = OffsetKt.m129paddingVpY3zN4(ImageKt.m47backgroundbw27NRU(companion, BrushKt.Color(Color.m440getRedimpl(j4), Color.m439getGreenimpl(j4), Color.m437getBlueimpl(j4), 0.15f, Color.m438getColorSpaceimpl(j4)), RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(f)), 8, 2);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                        long j5 = gapComposer2.compositeKeyHashCode;
                        int i4 = (int) (j5 ^ (j5 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope3 = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier3 = AbsoluteAlignment.materializeModifier(gapComposer2, modifierM129paddingVpY3zN5);
                        gapComposer2.startReusableNode();
                        if (gapComposer2.inserting) {
                            gapComposer2.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer2.useNode();
                        }
                        Stack.m295setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, composeUiNode$Companion$SetModifier$1);
                        Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope3, composeUiNode$Companion$SetModifier$2);
                        ImageAnalysis$$ExternalSyntheticLambda1.m(i4, gapComposer2, composeUiNode$Companion$SetModifier$3, gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
                        Stack.m295setimpl(gapComposer2, modifierMaterializeModifier3, composeUiNode$Companion$SetModifier$4);
                        LogMessage logMessage2 = logMessage;
                        String upperCase = logMessage2.level.name().toUpperCase(Locale.ROOT);
                        StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                        TextKt.m275TextNvy7gAk(upperCase, null, j4, TextUnitKt.getSp(10), null, FontWeight.Bold, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal2)).typography.labelSmall, gapComposer2, 1597440, 0, 130986);
                        gapComposer2.end(true);
                        if (1.0f <= 0.0d) {
                            InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                        }
                        OffsetKt.Spacer(gapComposer2, new LayoutWeightElement(1.0f, true));
                        String str = simpleDateFormat.format(logMessage2.time);
                        TextStyle textStyle = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal2)).typography.labelSmall;
                        GenericFontFamily genericFontFamily = SystemFontFamily.Monospace;
                        TextStyle textStyleM647copyp1EtxEg$default = TextStyle.m647copyp1EtxEg$default(textStyle, 0L, 0L, null, genericFontFamily, 0L, 0L, null, 16777183);
                        AppColors appColors3 = appColors;
                        TextKt.m275TextNvy7gAk(str, null, appColors3.textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, textStyleM647copyp1EtxEg$default, gapComposer2, 0, 0, 131066);
                        gapComposer2.end(true);
                        TextKt.m275TextNvy7gAk(logMessage2.message, OffsetKt.m132paddingqDBjuR0$default(companion, 0.0f, f, 0.0f, 0.0f, 13), appColors3.textPrimary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, TextStyle.m647copyp1EtxEg$default(((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal2)).typography.bodySmall, 0L, TextUnitKt.getSp(13), null, genericFontFamily, 0L, TextUnitKt.getSp(18), null, 16646109), gapComposer2, 48, 0, 131064);
                        gapComposer2.end(true);
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, 196662, 28);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MenuKt$$ExternalSyntheticLambda1(logMessage, simpleDateFormat, function0, i, 8);
        }
    }

    public static final void LogcatScreen(final String str, final boolean z, final List list, final Function1 function1, final Function0 function0, final Function0 function2, final Function0 function3, final Function0 function4, Modifier modifier, final boolean z2, GapComposer gapComposer, final int i) {
        int i2;
        Boolean bool;
        boolean z3;
        final Modifier modifier2;
        gapComposer.startRestartGroup(-1320807812);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changedInstance(list) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer.changedInstance(function0) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= gapComposer.changedInstance(function2) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= gapComposer.changedInstance(function3) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= gapComposer.changedInstance(function4) ? 8388608 : 4194304;
        }
        int i3 = i2 | 100663296;
        if ((805306368 & i) == 0) {
            i3 |= gapComposer.changed(z2) ? 536870912 : 268435456;
        }
        if ((306783379 & i3) == 306783378 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
        } else {
            final AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            final HazeState hazeStateRememberHazeState = HazeKt.rememberHazeState(gapComposer);
            final LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(gapComposer);
            gapComposer.startReplaceGroup(557421207);
            Object objRememberedValue = gapComposer.rememberedValue();
            Object obj = Composer$Companion.Empty;
            if (objRememberedValue == obj) {
                objRememberedValue = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            final SimpleDateFormat simpleDateFormat = (SimpleDateFormat) objRememberedValue;
            gapComposer.end(false);
            Integer numValueOf = Integer.valueOf(list.size());
            Boolean boolValueOf = Boolean.valueOf(z);
            gapComposer.startReplaceGroup(557424902);
            boolean zChangedInstance = ((i3 & 112) == 32) | gapComposer.changedInstance(list) | gapComposer.changed(lazyListStateRememberLazyListState);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == obj) {
                bool = boolValueOf;
                z3 = false;
                Object snackbarHostKt$animatedScale$1$1 = new SnackbarHostKt$animatedScale$1$1(z, list, lazyListStateRememberLazyListState, (Continuation) null, 2);
                gapComposer.updateRememberedValue(snackbarHostKt$animatedScale$1$1);
                objRememberedValue2 = snackbarHostKt$animatedScale$1$1;
            } else {
                bool = boolValueOf;
                z3 = false;
            }
            gapComposer.end(z3);
            Stack.LaunchedEffect(numValueOf, bool, (Function2) objRememberedValue2, gapComposer);
            ScaffoldKt.m261ScaffoldTvnljyQ(ImageKt.m47backgroundbw27NRU(SizeKt.FillWholeMaxSize, appColors.appBackground, BrushKt.RectangleShape), Thread_jvmKt.rememberComposableLambda(1354917688, new Function2() { // from class: com.github.kr328.clash.compose.LogcatScreenKt.LogcatScreen.2

                /* JADX INFO: renamed from: com.github.kr328.clash.compose.LogcatScreenKt$LogcatScreen$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
                public final class AnonymousClass1 implements Function2 {
                    public final /* synthetic */ AppColors $colors;
                    public final /* synthetic */ int $r8$classId;
                    public final /* synthetic */ String $title;

                    public /* synthetic */ AnonymousClass1(AppColors appColors, String str, int i) {
                        this.$r8$classId = i;
                        this.$colors = appColors;
                        this.$title = str;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        switch (this.$r8$classId) {
                            case 0:
                                GapComposer gapComposer = (GapComposer) obj;
                                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
                                    gapComposer.skipToGroupEnd();
                                } else {
                                    TextKt.m275TextNvy7gAk(this.$title, null, this.$colors.textPrimary, 0L, null, FontWeight.Bold, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.titleLarge, gapComposer, 1572864, 0, 131002);
                                }
                                break;
                            case 1:
                                GapComposer gapComposer2 = (GapComposer) obj;
                                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                                    gapComposer2.skipToGroupEnd();
                                } else {
                                    StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                                    TextKt.m275TextNvy7gAk(this.$title, null, this.$colors.textPrimary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, TextStyle.m647copyp1EtxEg$default(((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.bodySmall, 0L, 0L, null, SystemFontFamily.Monospace, 0L, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.bodyMedium.paragraphStyle.lineHeight, null, 16646111), gapComposer2, 0, 0, 131066);
                                }
                                break;
                            case 2:
                                GapComposer gapComposer3 = (GapComposer) obj;
                                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer3.getSkipping()) {
                                    gapComposer3.skipToGroupEnd();
                                } else {
                                    TextKt.m275TextNvy7gAk(this.$title, null, this.$colors.textPrimary, 0L, null, FontWeight.Bold, 0L, null, 0L, 0, false, 0, 0, null, gapComposer3, 1572864, 0, 262074);
                                }
                                break;
                            case 3:
                                GapComposer gapComposer4 = (GapComposer) obj;
                                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer4.getSkipping()) {
                                    gapComposer4.skipToGroupEnd();
                                } else {
                                    TextKt.m275TextNvy7gAk(this.$title, null, this.$colors.textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer4, 0, 0, 262138);
                                }
                                break;
                            case 4:
                                GapComposer gapComposer5 = (GapComposer) obj;
                                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer5.getSkipping()) {
                                    gapComposer5.skipToGroupEnd();
                                } else {
                                    TextKt.m275TextNvy7gAk(this.$title, null, this.$colors.textPrimary, 0L, null, FontWeight.Bold, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer5.consume(MaterialThemeKt._localMaterialTheme)).typography.titleLarge, gapComposer5, 1572864, 0, 131002);
                                }
                                break;
                            case 5:
                                GapComposer gapComposer6 = (GapComposer) obj;
                                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer6.getSkipping()) {
                                    gapComposer6.skipToGroupEnd();
                                } else {
                                    TextStyle textStyle = ((MaterialTheme$Values) gapComposer6.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyMedium;
                                    TextKt.m275TextNvy7gAk(this.$title, OffsetKt.m129paddingVpY3zN4(Modifier.Companion.$$INSTANCE, 16, 12), this.$colors.textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, textStyle, gapComposer6, 48, 0, 131064);
                                }
                                break;
                            default:
                                GapComposer gapComposer7 = (GapComposer) obj;
                                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer7.getSkipping()) {
                                    gapComposer7.skipToGroupEnd();
                                } else {
                                    TextKt.m275TextNvy7gAk(this.$title, null, this.$colors.textPrimary, 0L, null, FontWeight.Bold, 0L, null, 0L, 0, false, 0, 0, null, gapComposer7, 1572864, 0, 262074);
                                }
                                break;
                        }
                        return Unit.INSTANCE;
                    }

                    public /* synthetic */ AnonymousClass1(String str, AppColors appColors, int i) {
                        this.$r8$classId = i;
                        this.$title = str;
                        this.$colors = appColors;
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    GapComposer gapComposer2 = (GapComposer) obj2;
                    int iIntValue = ((Number) obj3).intValue();
                    AppColors appColors2 = appColors;
                    long j = appColors2.appBackground;
                    if ((iIntValue & 3) == 2 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        gapComposer2.startReplaceGroup(-1418065232);
                        Modifier modifierThen = Modifier.Companion.$$INSTANCE;
                        boolean z4 = z2;
                        if (!z4) {
                            modifierThen = modifierThen.then(new HazeEffectNodeElement(hazeStateRememberHazeState, BackHandlerKt.m6thinIv8Zu3U(gapComposer2)));
                        }
                        Modifier modifier3 = modifierThen;
                        int i4 = 0;
                        gapComposer2.end(false);
                        PaddingValuesImpl paddingValuesImpl = TopAppBarDefaults.ContentPadding;
                        long j2 = z4 ? j : Color.Transparent;
                        if (!z4) {
                            j = Color.Transparent;
                        }
                        long j3 = j;
                        long j4 = j2;
                        long j5 = appColors2.textPrimary;
                        AppBarKt.m238TopAppBargNPyAyM(Thread_jvmKt.rememberComposableLambda(-2078605316, new AnonymousClass1(appColors2, str, i4), gapComposer2), modifier3, Thread_jvmKt.rememberComposableLambda(865951870, new LogsScreenKt.AnonymousClass2(function4, appColors2, 5), gapComposer2), Thread_jvmKt.rememberComposableLambda(1013266023, new FilesScreenKt.C00202(z, function0, function2, function3, appColors2), gapComposer2), 0.0f, null, TopAppBarDefaults.m278topAppBarColors5tl4gsc(j4, j3, j5, j5, j5, gapComposer2, 32), null, gapComposer2, 3462, 432);
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), null, null, null, 0, appColors.appBackground, 0L, null, Thread_jvmKt.rememberComposableLambda(821853325, new Function3() { // from class: com.github.kr328.clash.compose.LogcatScreenKt.LogcatScreen.3
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    PaddingValuesImpl paddingValuesImpl;
                    PaddingValues paddingValues = (PaddingValues) obj2;
                    GapComposer gapComposer2 = (GapComposer) obj3;
                    int iIntValue = ((Number) obj4).intValue();
                    if ((iIntValue & 6) == 0) {
                        iIntValue |= gapComposer2.changed(paddingValues) ? 4 : 2;
                    }
                    if ((iIntValue & 19) == 18 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        Modifier modifierM47backgroundbw27NRU = ImageKt.m47backgroundbw27NRU(SizeKt.FillWholeMaxSize, appColors.appBackground, BrushKt.RectangleShape);
                        boolean z4 = z2;
                        Modifier modifierM132paddingqDBjuR0$default = Modifier.Companion.$$INSTANCE;
                        Modifier modifierThen = modifierM47backgroundbw27NRU.then(!z4 ? modifierM132paddingqDBjuR0$default.then(new HazeSourceElement(hazeStateRememberHazeState)) : modifierM132paddingqDBjuR0$default);
                        if (z4) {
                            modifierM132paddingqDBjuR0$default = OffsetKt.m132paddingqDBjuR0$default(modifierM132paddingqDBjuR0$default, 0.0f, paddingValues.mo120calculateTopPaddingD9Ej5fM(), 0.0f, paddingValues.mo117calculateBottomPaddingD9Ej5fM(), 5);
                        }
                        Modifier modifierThen2 = modifierThen.then(modifierM132paddingqDBjuR0$default);
                        if (z4) {
                            float f = 16;
                            paddingValuesImpl = new PaddingValuesImpl(f, 8, f, f);
                        } else {
                            float f2 = 16;
                            paddingValuesImpl = new PaddingValuesImpl(f2, paddingValues.mo120calculateTopPaddingD9Ej5fM() + 8, f2, paddingValues.mo117calculateBottomPaddingD9Ej5fM() + f2);
                        }
                        PaddingValuesImpl paddingValuesImpl2 = paddingValuesImpl;
                        Arrangement.SpacedAligned spacedAlignedM111spacedBy0680j_4 = Arrangement.m111spacedBy0680j_4(6);
                        gapComposer2.startReplaceGroup(-1417951544);
                        List list2 = list;
                        boolean zChangedInstance2 = gapComposer2.changedInstance(list2);
                        SimpleDateFormat simpleDateFormat2 = simpleDateFormat;
                        boolean zChangedInstance3 = zChangedInstance2 | gapComposer2.changedInstance(simpleDateFormat2);
                        Function1 function5 = function1;
                        boolean zChanged = zChangedInstance3 | gapComposer2.changed(function5);
                        Object objRememberedValue3 = gapComposer2.rememberedValue();
                        if (zChanged || objRememberedValue3 == Composer$Companion.Empty) {
                            objRememberedValue3 = new LifecycleEffectKt$$ExternalSyntheticLambda1(list2, simpleDateFormat2, function5, 18);
                            gapComposer2.updateRememberedValue(objRememberedValue3);
                        }
                        gapComposer2.end(false);
                        LazyDslKt.LazyColumn(modifierThen2, lazyListStateRememberLazyListState, paddingValuesImpl2, z, spacedAlignedM111spacedBy0680j_4, null, null, false, null, (Function1) objRememberedValue3, gapComposer2, 24576, 480);
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, 805306416, 444);
            modifier2 = Modifier.Companion.$$INSTANCE;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.github.kr328.clash.compose.LogcatScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    ((Integer) obj3).getClass();
                    LogcatScreenKt.LogcatScreen(str, z, list, function1, function0, function2, function3, function4, modifier2, z2, (GapComposer) obj2, Stack.updateChangedFlags(i | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
