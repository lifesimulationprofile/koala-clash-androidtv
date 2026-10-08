package com.google.android.gms.internal.mlkit_vision_common;

import androidx.activity.compose.BackHandlerKt;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda0;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.MenuKt$$ExternalSyntheticLambda1;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda4;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda7;
import androidx.compose.material3.TopAppBarColors;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.material3.internal.BasicTooltipKt$$ExternalSyntheticLambda7;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetModifier$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayout$1;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnitKt;
import coil.compose.AsyncImageKt$$ExternalSyntheticLambda1;
import com.github.kr328.clash.compose.LogsScreenKt;
import com.github.kr328.clash.compose.MainAppKt;
import com.github.kr328.clash.compose.MainAppKt$MainApp$2$3$1$1$1$2;
import com.github.kr328.clash.compose.home.HomeScreenKt;
import com.github.kr328.clash.compose.proxy.ProxyScreenKt$$ExternalSyntheticLambda2;
import com.github.kr328.clash.compose.proxy.ProxyScreenKt$$ExternalSyntheticLambda8;
import com.github.kr328.clash.compose.settings.AccessControlScreenKt$$ExternalSyntheticLambda2;
import com.github.kr328.clash.design.compose.theme.AppColors;
import com.github.kr328.clash.design.compose.theme.AppColorsKt;
import com.github.kr328.clash.design.model.AppInfo;
import com.github.kr328.clash.design.model.AppInfoSort;
import com.google.android.gms.internal.mlkit_vision_common.zzjb;
import com.koala.clash.R;
import dev.chrisbanes.haze.HazeEffectNodeElement;
import dev.chrisbanes.haze.HazeKt;
import dev.chrisbanes.haze.HazeState;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzjb {
    public static final void AccessControlMenu(final boolean z, final Function0 function0, final AppInfoSort appInfoSort, final boolean z2, final boolean z3, final Function1 function1, final Function1 function2, final Function1 function3, final Function0 function4, final Function0 function5, final Function0 function6, final Function0 function7, final Function0 function8, GapComposer gapComposer, final int i) {
        gapComposer.startRestartGroup(-67552231);
        int i2 = i | (gapComposer.changed(z) ? 4 : 2) | (gapComposer.changed(appInfoSort) ? 256 : 128) | (gapComposer.changed(z2) ? 2048 : 1024) | (gapComposer.changed(z3) ? 16384 : 8192) | (gapComposer.changedInstance(function1) ? 131072 : 65536) | (gapComposer.changedInstance(function2) ? 1048576 : 524288) | (gapComposer.changedInstance(function3) ? 8388608 : 4194304) | (gapComposer.changedInstance(function4) ? 67108864 : 33554432) | (gapComposer.changedInstance(function5) ? 536870912 : 268435456);
        int i3 = (gapComposer.changedInstance(function6) ? (char) 4 : (char) 2) | (gapComposer.changedInstance(function7) ? ' ' : (char) 16) | (gapComposer.changedInstance(function8) ? (char) 256 : (char) 128);
        if ((306783379 & i2) == 306783378 && (i3 & 147) == 146 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            AndroidMenu_androidKt.m236DropdownMenuIlH_yew(z, function0, null, 0L, null, null, RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(20), BrushKt.m414compositeOverOWjLjI(appColors.cardBackground, appColors.appBackground), 0.0f, 0.0f, Thread_jvmKt.rememberComposableLambda(-174368428, new Function3() { // from class: com.github.kr328.clash.compose.settings.AccessControlScreenKt$AccessControlMenu$1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    GapComposer gapComposer2 = (GapComposer) obj2;
                    if ((((Number) obj3).intValue() & 17) == 16 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        Modifier modifierM129paddingVpY3zN4 = OffsetKt.m129paddingVpY3zN4(SizeKt.m144width3ABfNKs(Modifier.Companion.$$INSTANCE, 300), 16, 14);
                        ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.m111spacedBy0680j_4(18), Alignment.Companion.Start, gapComposer2, 6);
                        long j = gapComposer2.compositeKeyHashCode;
                        int i4 = (int) (j ^ (j >>> 32));
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
                        Stack.m295setimpl(gapComposer2, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                        Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                        Stack.m295setimpl(gapComposer2, Integer.valueOf(i4), ComposeUiNode.Companion.SetCompositeKeyHash);
                        Stack.m294reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                        Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                        zzjb.SettingsSection(StringResources_androidKt.stringResource(R.string.sort, gapComposer2), Thread_jvmKt.rememberComposableLambda(-1067736576, new LogsScreenKt.AnonymousClass1.AnonymousClass3.AnonymousClass2(6, appInfoSort, function1), gapComposer2), gapComposer2, 48);
                        String strStringResource = StringResources_androidKt.stringResource(R.string.filter, gapComposer2);
                        final boolean z4 = z2;
                        final Function1 function9 = function2;
                        final boolean z5 = z3;
                        final Function1 function10 = function3;
                        zzjb.SettingsSection(strStringResource, Thread_jvmKt.rememberComposableLambda(667231735, new Function2() { // from class: com.github.kr328.clash.compose.settings.AccessControlScreenKt$AccessControlMenu$1$1$2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj4, Object obj5) {
                                GapComposer gapComposer3 = (GapComposer) obj4;
                                if ((((Number) obj5).intValue() & 3) == 2 && gapComposer3.getSkipping()) {
                                    gapComposer3.skipToGroupEnd();
                                } else {
                                    Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f);
                                    RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.m111spacedBy0680j_4(8), Alignment.Companion.Top, gapComposer3, 6);
                                    long j2 = gapComposer3.compositeKeyHashCode;
                                    int i5 = (int) (j2 ^ (j2 >>> 32));
                                    PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer3.currentCompositionLocalScope();
                                    Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer3, modifierFillMaxWidth);
                                    ComposeUiNode.Companion.getClass();
                                    LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$2 = ComposeUiNode.Companion.Constructor;
                                    gapComposer3.startReusableNode();
                                    if (gapComposer3.inserting) {
                                        gapComposer3.createNode(layoutNode$Companion$Constructor$2);
                                    } else {
                                        gapComposer3.useNode();
                                    }
                                    Stack.m295setimpl(gapComposer3, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                                    Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope2, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                                    Stack.m295setimpl(gapComposer3, Integer.valueOf(i5), ComposeUiNode.Companion.SetCompositeKeyHash);
                                    Stack.m294reconcileimpl(gapComposer3, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                                    Stack.m295setimpl(gapComposer3, modifierMaterializeModifier2, ComposeUiNode.Companion.SetModifier);
                                    String strStringResource2 = StringResources_androidKt.stringResource(R.string.reverse, gapComposer3);
                                    gapComposer3.startReplaceGroup(797852637);
                                    Function1 function11 = function9;
                                    boolean zChanged = gapComposer3.changed(function11);
                                    boolean z6 = z4;
                                    boolean zChanged2 = zChanged | gapComposer3.changed(z6);
                                    Object objRememberedValue = gapComposer3.rememberedValue();
                                    NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
                                    if (zChanged2 || objRememberedValue == neverEqualPolicy) {
                                        objRememberedValue = new CheckboxKt$$ExternalSyntheticLambda0(function11, z6, 2);
                                        gapComposer3.updateRememberedValue(objRememberedValue);
                                    }
                                    Function0 function12 = (Function0) objRememberedValue;
                                    gapComposer3.end(false);
                                    if (1.0f <= 0.0d) {
                                        InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                                    }
                                    zzjb.SegmentedPill(strStringResource2, z6, function12, new LayoutWeightElement(1.0f, true), gapComposer3, 0);
                                    String strStringResource3 = StringResources_androidKt.stringResource(R.string.system_apps, gapComposer3);
                                    gapComposer3.startReplaceGroup(797862219);
                                    Function1 function13 = function10;
                                    boolean zChanged3 = gapComposer3.changed(function13);
                                    boolean z7 = z5;
                                    boolean zChanged4 = zChanged3 | gapComposer3.changed(z7);
                                    Object objRememberedValue2 = gapComposer3.rememberedValue();
                                    if (zChanged4 || objRememberedValue2 == neverEqualPolicy) {
                                        objRememberedValue2 = new CheckboxKt$$ExternalSyntheticLambda0(function13, z7, 3);
                                        gapComposer3.updateRememberedValue(objRememberedValue2);
                                    }
                                    Function0 function14 = (Function0) objRememberedValue2;
                                    gapComposer3.end(false);
                                    if (1.0f <= 0.0d) {
                                        InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                                    }
                                    zzjb.SegmentedPill(strStringResource3, z7, function14, new LayoutWeightElement(1.0f, true), gapComposer3, 0);
                                    gapComposer3.end(true);
                                }
                                return Unit.INSTANCE;
                            }
                        }, gapComposer2), gapComposer2, 48);
                        String strStringResource2 = StringResources_androidKt.stringResource(R.string.selection, gapComposer2);
                        Function0 function11 = function0;
                        zzjb.SettingsSection(strStringResource2, Thread_jvmKt.rememberComposableLambda(435969016, new MainAppKt.AnonymousClass2.AnonymousClass1(function11, function4, function5, function6, 2), gapComposer2), gapComposer2, 48);
                        zzjb.SettingsSection(StringResources_androidKt.stringResource(R.string.clipboard, gapComposer2), Thread_jvmKt.rememberComposableLambda(204706297, new MainAppKt$MainApp$2$3$1$1$1$2.AnonymousClass1(function11, function7, function8, 3), gapComposer2), gapComposer2, 48);
                        gapComposer2.end(true);
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, i2 & 126);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2(z, function0, appInfoSort, z2, z3, function1, function2, function3, function4, function5, function6, function7, function8, i) { // from class: com.github.kr328.clash.compose.settings.AccessControlScreenKt$$ExternalSyntheticLambda5
                public final /* synthetic */ boolean f$0;
                public final /* synthetic */ Function0 f$1;
                public final /* synthetic */ Function0 f$10;
                public final /* synthetic */ Function0 f$11;
                public final /* synthetic */ Function0 f$12;
                public final /* synthetic */ AppInfoSort f$2;
                public final /* synthetic */ boolean f$3;
                public final /* synthetic */ boolean f$4;
                public final /* synthetic */ Function1 f$5;
                public final /* synthetic */ Function1 f$6;
                public final /* synthetic */ Function1 f$7;
                public final /* synthetic */ Function0 f$8;
                public final /* synthetic */ Function0 f$9;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(49);
                    zzjb.AccessControlMenu(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, this.f$10, this.f$11, this.f$12, (GapComposer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void AccessControlScreen(final List list, final Set set, final Function1 function1, final AppInfoSort appInfoSort, final boolean z, final boolean z2, final Function1 function2, final Function1 function3, final Function1 function4, final Function0 function0, final Function0 function5, final Function0 function6, final Function0 function7, final Function0 function8, final Function0 function9, Modifier modifier, final boolean z3, GapComposer gapComposer, final int i) {
        final Modifier modifier2;
        gapComposer.startRestartGroup(-313969018);
        int i2 = i | (gapComposer.changedInstance(list) ? 4 : 2) | (gapComposer.changedInstance(set) ? 32 : 16) | (gapComposer.changedInstance(function1) ? 256 : 128) | (gapComposer.changed(appInfoSort) ? 2048 : 1024) | (gapComposer.changed(z) ? 16384 : 8192) | (gapComposer.changed(z2) ? 131072 : 65536) | (gapComposer.changedInstance(function2) ? 1048576 : 524288) | (gapComposer.changedInstance(function3) ? 8388608 : 4194304) | (gapComposer.changedInstance(function4) ? 67108864 : 33554432) | (gapComposer.changedInstance(function0) ? 536870912 : 268435456);
        int i3 = (gapComposer.changedInstance(function5) ? (char) 4 : (char) 2) | (gapComposer.changedInstance(function6) ? ' ' : (char) 16) | (gapComposer.changedInstance(function7) ? 256 : 128) | (gapComposer.changedInstance(function8) ? 2048 : 1024) | (gapComposer.changedInstance(function9) ? (char) 16384 : (char) 8192) | 196608 | (gapComposer.changed(z3) ? (char) 0 : (char) 0);
        if ((i2 & 306783379) == 306783378 && (i3 & 599187) == 599186 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
        } else {
            final AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            final HazeState hazeStateRememberHazeState = HazeKt.rememberHazeState(gapComposer);
            gapComposer.startReplaceGroup(1704044243);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            Object objM = Density.CC.m(1704046067, gapComposer, false);
            if (objM == neverEqualPolicy) {
                objM = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objM);
            }
            final MutableState mutableState2 = (MutableState) objM;
            gapComposer.end(false);
            ScaffoldKt.m261ScaffoldTvnljyQ(ImageKt.m47backgroundbw27NRU(SizeKt.FillWholeMaxSize, appColors.appBackground, BrushKt.RectangleShape), Thread_jvmKt.rememberComposableLambda(-2048853950, new Function2() { // from class: com.github.kr328.clash.compose.settings.AccessControlScreenKt$AccessControlScreen$1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    GapComposer gapComposer2 = (GapComposer) obj;
                    int iIntValue = ((Number) obj2).intValue();
                    final AppColors appColors2 = appColors;
                    long j = appColors2.appBackground;
                    if ((iIntValue & 3) == 2 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        gapComposer2.startReplaceGroup(805908524);
                        Modifier modifierThen = Modifier.Companion.$$INSTANCE;
                        boolean z4 = z3;
                        if (!z4) {
                            modifierThen = modifierThen.then(new HazeEffectNodeElement(hazeStateRememberHazeState, BackHandlerKt.m6thinIv8Zu3U(gapComposer2)));
                        }
                        Modifier modifier3 = modifierThen;
                        gapComposer2.end(false);
                        PaddingValuesImpl paddingValuesImpl = TopAppBarDefaults.ContentPadding;
                        long j2 = z4 ? j : Color.Transparent;
                        if (!z4) {
                            j = Color.Transparent;
                        }
                        long j3 = j;
                        long j4 = j2;
                        long j5 = appColors2.textPrimary;
                        TopAppBarColors topAppBarColorsM278topAppBarColors5tl4gsc = TopAppBarDefaults.m278topAppBarColors5tl4gsc(j4, j3, j5, j5, j5, gapComposer2, 32);
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Thread_jvmKt.rememberComposableLambda(-184794106, new LogsScreenKt.AnonymousClass6(appColors2, 29), gapComposer2);
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda2 = Thread_jvmKt.rememberComposableLambda(-354413048, new LogsScreenKt.AnonymousClass2(function9, appColors2, 14), gapComposer2);
                        final Function0 function10 = function8;
                        final MutableState mutableState3 = mutableState;
                        final MutableState mutableState4 = mutableState2;
                        final AppInfoSort appInfoSort2 = appInfoSort;
                        final boolean z5 = z;
                        final boolean z6 = z2;
                        final Function1 function11 = function2;
                        final Function1 function12 = function3;
                        final Function1 function13 = function4;
                        final Function0 function14 = function0;
                        final Function0 function15 = function5;
                        final Function0 function16 = function6;
                        final Function0 function17 = function7;
                        AppBarKt.m238TopAppBargNPyAyM(composableLambdaImplRememberComposableLambda, modifier3, composableLambdaImplRememberComposableLambda2, Thread_jvmKt.rememberComposableLambda(23470769, new Function3() { // from class: com.github.kr328.clash.compose.settings.AccessControlScreenKt$AccessControlScreen$1.3
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj3, Object obj4, Object obj5) {
                                GapComposer gapComposer3 = (GapComposer) obj4;
                                if ((((Number) obj5).intValue() & 17) == 16 && gapComposer3.getSkipping()) {
                                    gapComposer3.skipToGroupEnd();
                                } else {
                                    gapComposer3.startReplaceGroup(1970355332);
                                    Object objRememberedValue2 = gapComposer3.rememberedValue();
                                    NeverEqualPolicy neverEqualPolicy2 = Composer$Companion.Empty;
                                    if (objRememberedValue2 == neverEqualPolicy2) {
                                        objRememberedValue2 = new ProxyScreenKt$$ExternalSyntheticLambda8(mutableState4, 6);
                                        gapComposer3.updateRememberedValue(objRememberedValue2);
                                    }
                                    gapComposer3.end(false);
                                    AppColors appColors3 = appColors2;
                                    ScrimKt.IconButton((Function0) objRememberedValue2, null, false, null, null, Thread_jvmKt.rememberComposableLambda(26006995, new SettingsScreenKt$SettingsScreen$3$1(appColors3, 2), gapComposer3), gapComposer3, 1572870, 62);
                                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                                    long j6 = gapComposer3.compositeKeyHashCode;
                                    int i4 = (int) (j6 ^ (j6 >>> 32));
                                    PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer3.currentCompositionLocalScope();
                                    Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer3, Modifier.Companion.$$INSTANCE);
                                    ComposeUiNode.Companion.getClass();
                                    LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                                    gapComposer3.startReusableNode();
                                    if (gapComposer3.inserting) {
                                        gapComposer3.createNode(layoutNode$Companion$Constructor$1);
                                    } else {
                                        gapComposer3.useNode();
                                    }
                                    Stack.m295setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                                    Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                                    Stack.m295setimpl(gapComposer3, Integer.valueOf(i4), ComposeUiNode.Companion.SetCompositeKeyHash);
                                    Stack.m294reconcileimpl(gapComposer3, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                                    Stack.m295setimpl(gapComposer3, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                                    gapComposer3.startReplaceGroup(-1145111711);
                                    Object objRememberedValue3 = gapComposer3.rememberedValue();
                                    MutableState mutableState5 = mutableState3;
                                    if (objRememberedValue3 == neverEqualPolicy2) {
                                        objRememberedValue3 = new ProxyScreenKt$$ExternalSyntheticLambda8(mutableState5, 7);
                                        gapComposer3.updateRememberedValue(objRememberedValue3);
                                    }
                                    gapComposer3.end(false);
                                    ScrimKt.IconButton((Function0) objRememberedValue3, null, false, null, null, Thread_jvmKt.rememberComposableLambda(-1566537843, new SettingsScreenKt$SettingsScreen$3$1(appColors3, 3), gapComposer3), gapComposer3, 1572870, 62);
                                    boolean zBooleanValue = ((Boolean) mutableState5.getValue()).booleanValue();
                                    gapComposer3.startReplaceGroup(-1145097886);
                                    Object objRememberedValue4 = gapComposer3.rememberedValue();
                                    if (objRememberedValue4 == neverEqualPolicy2) {
                                        objRememberedValue4 = new ProxyScreenKt$$ExternalSyntheticLambda8(mutableState5, 8);
                                        gapComposer3.updateRememberedValue(objRememberedValue4);
                                    }
                                    gapComposer3.end(false);
                                    zzjb.AccessControlMenu(zBooleanValue, (Function0) objRememberedValue4, appInfoSort2, z5, z6, function11, function12, function13, function14, function15, function16, function17, function10, gapComposer3, 48);
                                    gapComposer3.end(true);
                                }
                                return Unit.INSTANCE;
                            }
                        }, gapComposer2), 0.0f, null, topAppBarColorsM278topAppBarColors5tl4gsc, null, gapComposer2, 3462, 432);
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), null, null, null, 0, appColors.appBackground, 0L, null, Thread_jvmKt.rememberComposableLambda(-1426967209, new LogsScreenKt.C00212(appColors, z3, hazeStateRememberHazeState, list, set, function1), gapComposer), gapComposer, 805306416, 444);
            if (((Boolean) mutableState2.getValue()).booleanValue()) {
                gapComposer.startReplaceGroup(1704183719);
                Object objRememberedValue2 = gapComposer.rememberedValue();
                if (objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = new ProxyScreenKt$$ExternalSyntheticLambda8(mutableState2, 5);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                gapComposer.end(false);
                SearchOverlay(list, set, function1, (Function0) objRememberedValue2, gapComposer, (i2 & 14) | 3072 | (i2 & 112) | (i2 & 896));
            }
            modifier2 = Modifier.Companion.$$INSTANCE;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2(list, set, function1, appInfoSort, z, z2, function2, function3, function4, function0, function5, function6, function7, function8, function9, modifier2, z3, i) { // from class: com.github.kr328.clash.compose.settings.AccessControlScreenKt$$ExternalSyntheticLambda1
                public final /* synthetic */ List f$0;
                public final /* synthetic */ Set f$1;
                public final /* synthetic */ Function0 f$10;
                public final /* synthetic */ Function0 f$11;
                public final /* synthetic */ Function0 f$12;
                public final /* synthetic */ Function0 f$13;
                public final /* synthetic */ Function0 f$14;
                public final /* synthetic */ Modifier f$15;
                public final /* synthetic */ boolean f$16;
                public final /* synthetic */ Function1 f$2;
                public final /* synthetic */ AppInfoSort f$3;
                public final /* synthetic */ boolean f$4;
                public final /* synthetic */ boolean f$5;
                public final /* synthetic */ Function1 f$6;
                public final /* synthetic */ Function1 f$7;
                public final /* synthetic */ Function1 f$8;
                public final /* synthetic */ Function0 f$9;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                    zzjb.AccessControlScreen(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, this.f$10, this.f$11, this.f$12, this.f$13, this.f$14, this.f$15, this.f$16, (GapComposer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void ActionRow(ImageVector imageVector, String str, Function0 function0, GapComposer gapComposer, int i) {
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(-1284974418);
        int i2 = i | (gapComposer2.changed(imageVector) ? 4 : 2) | (gapComposer2.changed(str) ? 32 : 16) | (gapComposer2.changedInstance(function0) ? 256 : 128);
        if ((i2 & 147) == 146 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            float f = 10;
            Modifier modifierM129paddingVpY3zN4 = OffsetKt.m129paddingVpY3zN4(ImageKt.m51clickableoSLSa3U$default(ClipKt.clip(SizeKt.fillMaxWidth(companion, 1.0f), RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(f)), false, null, function0, 15), 12, f);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.CenterVertically, gapComposer2, 48);
            long j = gapComposer2.compositeKeyHashCode;
            int i3 = (int) (j ^ (j >>> 32));
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
            Stack.m295setimpl(gapComposer2, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m295setimpl(gapComposer2, Integer.valueOf(i3), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m294reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            IconKt.m249Iconww6aTOc(imageVector, null, SizeKt.m140size3ABfNKs(companion, 20), appColors.textPrimary, gapComposer2, (i2 & 14) | 432, 0);
            OffsetKt.Spacer(gapComposer2, SizeKt.m144width3ABfNKs(companion, 14));
            TextKt.m275TextNvy7gAk(str, null, appColors.textPrimary, 0L, null, FontWeight.Medium, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyMedium, gapComposer, ((i2 >> 3) & 14) | 1572864, 0, 131002);
            gapComposer2 = gapComposer;
            gapComposer2.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MenuKt$$ExternalSyntheticLambda1(imageVector, str, function0, i, 12);
        }
    }

    /* JADX WARN: Code duplicated, block: B:57:0x009d  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:63:0x00be  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:77:0x010a  */
    /* JADX WARN: Code duplicated, block: B:79:? A[RETURN, SYNTHETIC] */
    public static final void AppList(List list, Set set, Function1 function1, PaddingValuesImpl paddingValuesImpl, Modifier modifier, boolean z, GapComposer gapComposer, int i, int i2) {
        int i3;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Object objRememberedValue;
        boolean z6;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        gapComposer.startRestartGroup(402025355);
        if ((i & 6) == 0) {
            i3 = (gapComposer.changedInstance(list) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= gapComposer.changedInstance(set) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= gapComposer.changedInstance(function1) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= gapComposer.changed(paddingValuesImpl) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= gapComposer.changed(modifier) ? 16384 : 8192;
        }
        int i4 = i2 & 32;
        if (i4 == 0) {
            if ((196608 & i) == 0) {
                z2 = z;
                i3 |= gapComposer.changed(z2) ? 131072 : 65536;
            }
            if ((74899 & i3) == 74898 || !gapComposer.getSkipping()) {
                if (i4 != 0) {
                    z3 = false;
                } else {
                    z3 = z2;
                }
                Arrangement.SpacedAligned spacedAlignedM111spacedBy0680j_4 = Arrangement.m111spacedBy0680j_4(8);
                gapComposer.startReplaceGroup(200489150);
                boolean zChangedInstance = gapComposer.changedInstance(list) | gapComposer.changedInstance(set);
                if ((i3 & 896) == 256) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                z5 = z4 | zChangedInstance | ((458752 & i3) == 131072);
                objRememberedValue = gapComposer.rememberedValue();
                if (z5 || objRememberedValue == Composer$Companion.Empty) {
                    objRememberedValue = new AccessControlScreenKt$$ExternalSyntheticLambda2(list, set, function1, z3);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                gapComposer.end(false);
                LazyDslKt.LazyColumn(modifier, null, paddingValuesImpl, false, spacedAlignedM111spacedBy0680j_4, null, null, false, null, (Function1) objRememberedValue, gapComposer, ((i3 >> 12) & 14) | 24576 | ((i3 >> 3) & 896), 490);
                z6 = z3;
            } else {
                gapComposer.skipToGroupEnd();
                z6 = z2;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new TooltipKt$$ExternalSyntheticLambda4(list, set, function1, paddingValuesImpl, modifier, z6, i, i2);
            }
        }
        i3 |= 196608;
        z2 = z;
        if ((74899 & i3) == 74898) {
            if (i4 != 0) {
                z3 = false;
            } else {
                z3 = z2;
            }
            Arrangement.SpacedAligned spacedAlignedM111spacedBy0680j_5 = Arrangement.m111spacedBy0680j_4(8);
            gapComposer.startReplaceGroup(200489150);
            boolean zChangedInstance2 = gapComposer.changedInstance(list) | gapComposer.changedInstance(set);
            if ((i3 & 896) == 256) {
                z4 = true;
            } else {
                z4 = false;
            }
            z5 = z4 | zChangedInstance2 | ((458752 & i3) == 131072);
            objRememberedValue = gapComposer.rememberedValue();
            if (z5) {
                objRememberedValue = new AccessControlScreenKt$$ExternalSyntheticLambda2(list, set, function1, z3);
                gapComposer.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new AccessControlScreenKt$$ExternalSyntheticLambda2(list, set, function1, z3);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            gapComposer.end(false);
            LazyDslKt.LazyColumn(modifier, null, paddingValuesImpl, false, spacedAlignedM111spacedBy0680j_5, null, null, false, null, (Function1) objRememberedValue, gapComposer, ((i3 >> 12) & 14) | 24576 | ((i3 >> 3) & 896), 490);
            z6 = z3;
        } else {
            if (i4 != 0) {
                z3 = false;
            } else {
                z3 = z2;
            }
            Arrangement.SpacedAligned spacedAlignedM111spacedBy0680j_6 = Arrangement.m111spacedBy0680j_4(8);
            gapComposer.startReplaceGroup(200489150);
            boolean zChangedInstance3 = gapComposer.changedInstance(list) | gapComposer.changedInstance(set);
            if ((i3 & 896) == 256) {
                z4 = true;
            } else {
                z4 = false;
            }
            z5 = z4 | zChangedInstance3 | ((458752 & i3) == 131072);
            objRememberedValue = gapComposer.rememberedValue();
            if (z5) {
                objRememberedValue = new AccessControlScreenKt$$ExternalSyntheticLambda2(list, set, function1, z3);
                gapComposer.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new AccessControlScreenKt$$ExternalSyntheticLambda2(list, set, function1, z3);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            gapComposer.end(false);
            LazyDslKt.LazyColumn(modifier, null, paddingValuesImpl, false, spacedAlignedM111spacedBy0680j_6, null, null, false, null, (Function1) objRememberedValue, gapComposer, ((i3 >> 12) & 14) | 24576 | ((i3 >> 3) & 896), 490);
            z6 = z3;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TooltipKt$$ExternalSyntheticLambda4(list, set, function1, paddingValuesImpl, modifier, z6, i, i2);
        }
    }

    public static final void AppRow(final AppInfo appInfo, final boolean z, final Function0 function0, final boolean z2, GapComposer gapComposer, final int i) {
        gapComposer.startRestartGroup(-191028263);
        if (((i | (gapComposer.changedInstance(appInfo) ? 4 : 2) | (gapComposer.changed(z) ? 32 : 16) | (gapComposer.changedInstance(function0) ? 256 : 128)) & 147) == 146 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            gapComposer.startReplaceGroup(1120860655);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            gapComposer.end(false);
            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f);
            gapComposer.startReplaceGroup(1120865033);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new TooltipKt$$ExternalSyntheticLambda7(mutableState, 25);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            gapComposer.end(false);
            Modifier modifierOnFocusChanged = FocusTraversalKt.onFocusChanged(modifierFillMaxWidth, (Function1) objRememberedValue2);
            float f = ((Boolean) mutableState.getValue()).booleanValue() ? 2 : 0;
            long j = ((Boolean) mutableState.getValue()).booleanValue() ? Color.White : Color.Transparent;
            float f2 = 12;
            zzjl.m819GlassSurfaceYxtnGt4(ImageKt.m48borderxT4_qwU(f, j, modifierOnFocusChanged, RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(f2)), f2, null, Thread_jvmKt.rememberComposableLambda(-993760772, new HomeScreenKt.AnonymousClass2(function0, appInfo, z, appColors), gapComposer), gapComposer, 196656, 28);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2(z, function0, z2, i) { // from class: com.github.kr328.clash.compose.settings.AccessControlScreenKt$$ExternalSyntheticLambda8
                public final /* synthetic */ boolean f$1;
                public final /* synthetic */ Function0 f$2;
                public final /* synthetic */ boolean f$3;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(9);
                    zzjb.AppRow(this.f$0, this.f$1, this.f$2, this.f$3, (GapComposer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v4, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r11v0, types: [androidx.compose.runtime.GapComposer] */
    /* JADX WARN: Type inference failed for: r11v7, types: [androidx.compose.runtime.GapComposer] */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r3v4 */
    public static final void SearchOverlay(List list, Set set, Function1 function1, Function0 function0, GapComposer gapComposer, int i) {
        ?? arrayList;
        boolean z;
        GapComposer gapComposer2;
        ?? r11;
        ?? r12 = gapComposer;
        r12.startRestartGroup(1985989520);
        int i2 = (i & 6) == 0 ? (r12.changedInstance(list) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= r12.changedInstance(set) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= r12.changedInstance(function1) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= r12.changedInstance(function0) ? 2048 : 1024;
        }
        if ((i2 & 1171) == 1170 && r12.getSkipping()) {
            r12.skipToGroupEnd();
            r11 = r12;
        } else {
            AppColors appColors = (AppColors) r12.consume(AppColorsKt.LocalAppColors);
            r12.startReplaceGroup(1201806323);
            Object objRememberedValue = r12.rememberedValue();
            Object obj = Composer$Companion.Empty;
            if (objRememberedValue == obj) {
                objRememberedValue = Stack.mutableStateOf$default("");
                r12.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            r12.end(false);
            String str = (String) mutableState.getValue();
            r12.startReplaceGroup(1201808180);
            boolean zChanged = r12.changed(str) | r12.changed(list);
            Object objRememberedValue2 = r12.rememberedValue();
            ?? r14 = objRememberedValue2;
            if (zChanged || objRememberedValue2 == obj) {
                if (StringsKt.isBlank((String) mutableState.getValue())) {
                    arrayList = EmptyList.INSTANCE;
                } else {
                    arrayList = new ArrayList();
                    for (Object obj2 : list) {
                        AppInfo appInfo = (AppInfo) obj2;
                        if (StringsKt.contains(appInfo.label, (String) mutableState.getValue(), true) || StringsKt.contains(appInfo.packageName, (String) mutableState.getValue(), true)) {
                            arrayList.add(obj2);
                        }
                    }
                }
                ?? r15 = arrayList;
                r12.updateRememberedValue(r15);
                r14 = r15;
            }
            List list2 = (List) r14;
            r12.end(false);
            FillElement fillElement = SizeKt.FillWholeMaxSize;
            Modifier modifierM47backgroundbw27NRU = ImageKt.m47backgroundbw27NRU(fillElement, appColors.appBackground, BrushKt.RectangleShape);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            long j = r12.compositeKeyHashCode;
            int i3 = (int) (j ^ (j >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = r12.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(r12, modifierM47backgroundbw27NRU);
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            r12.startReusableNode();
            if (r12.inserting) {
                r12.createNode(layoutNode$Companion$Constructor$1);
            } else {
                r12.useNode();
            }
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$1 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m295setimpl(r12, measurePolicyMaybeCachedBoxMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m295setimpl(r12, persistentCompositionLocalMapCurrentCompositionLocalScope, composeUiNode$Companion$SetModifier$2);
            Integer numValueOf = Integer.valueOf(i3);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m295setimpl(r12, numValueOf, composeUiNode$Companion$SetModifier$3);
            OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
            Stack.m294reconcileimpl(r12, ownerSnapshotObserver$onCommitAffectingLayout$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
            Stack.m295setimpl(r12, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, r12, 0);
            long j2 = r12.compositeKeyHashCode;
            int i4 = (int) (j2 ^ (j2 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = r12.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(r12, fillElement);
            r12.startReusableNode();
            if (r12.inserting) {
                r12.createNode(layoutNode$Companion$Constructor$1);
            } else {
                r12.useNode();
            }
            Stack.m295setimpl(r12, columnMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            Stack.m295setimpl(r12, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
            ImageAnalysis$$ExternalSyntheticLambda1.m(i4, r12, composeUiNode$Companion$SetModifier$3, r12, ownerSnapshotObserver$onCommitAffectingLayout$1);
            Stack.m295setimpl(r12, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
            ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Thread_jvmKt.rememberComposableLambda(-1125713080, new LogsScreenKt.AnonymousClass5(appColors, mutableState, 2), r12);
            ComposableLambdaImpl composableLambdaImplRememberComposableLambda2 = Thread_jvmKt.rememberComposableLambda(409683590, new LogsScreenKt.AnonymousClass2(function0, appColors, 15), r12);
            PaddingValuesImpl paddingValuesImpl = TopAppBarDefaults.ContentPadding;
            int i5 = i2;
            AppBarKt.m238TopAppBargNPyAyM(composableLambdaImplRememberComposableLambda, null, composableLambdaImplRememberComposableLambda2, null, 0.0f, null, TopAppBarDefaults.m278topAppBarColors5tl4gsc(Color.Transparent, 0L, 0L, 0L, 0L, gapComposer, 62), null, gapComposer, 390, 442);
            GapComposer gapComposer3 = gapComposer;
            if (!list2.isEmpty() || StringsKt.isBlank((String) mutableState.getValue())) {
                z = true;
                gapComposer3.startReplaceGroup(1550362159);
                float f = 16;
                float f2 = 8;
                AppList(list2, set, function1, new PaddingValuesImpl(f, f2, f, f2), fillElement, false, gapComposer3, (i5 & 112) | 27648 | (i5 & 896), 32);
                gapComposer3.end(false);
                gapComposer2 = gapComposer3;
            } else {
                gapComposer3.startReplaceGroup(1550091591);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                long j3 = gapComposer3.compositeKeyHashCode;
                int i6 = (int) (j3 ^ (j3 >>> 32));
                PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope3 = gapComposer3.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier3 = AbsoluteAlignment.materializeModifier(gapComposer3, fillElement);
                gapComposer3.startReusableNode();
                if (gapComposer3.inserting) {
                    gapComposer3.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    gapComposer3.useNode();
                }
                Stack.m295setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy2, composeUiNode$Companion$SetModifier$1);
                Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope3, composeUiNode$Companion$SetModifier$2);
                ImageAnalysis$$ExternalSyntheticLambda1.m(i6, gapComposer3, composeUiNode$Companion$SetModifier$3, gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$1);
                Stack.m295setimpl(gapComposer3, modifierMaterializeModifier3, composeUiNode$Companion$SetModifier$4);
                TextKt.m275TextNvy7gAk("—", null, appColors.textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 6, 0, 262138);
                GapComposer gapComposer4 = gapComposer;
                z = true;
                gapComposer4.end(true);
                gapComposer4.end(false);
                gapComposer2 = gapComposer4;
            }
            OffsetKt.Spacer(gapComposer2, SizeKt.m135height3ABfNKs(Modifier.Companion.$$INSTANCE, 0));
            gapComposer2.end(z);
            gapComposer2.end(z);
            r11 = gapComposer2;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = r11.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AsyncImageKt$$ExternalSyntheticLambda1(list, set, function1, function0, i, 8);
        }
    }

    public static final void SegmentedPill(String str, boolean z, Function0 function0, Modifier modifier, GapComposer gapComposer, int i) {
        long jColor;
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(2084976012);
        int i2 = i | (gapComposer2.changed(str) ? 4 : 2) | (gapComposer2.changed(z) ? 32 : 16) | (gapComposer2.changedInstance(function0) ? 256 : 128) | (gapComposer2.changed(modifier) ? 2048 : 1024);
        if ((i2 & 1171) == 1170 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            RoundedCornerShape roundedCornerShapeM158RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(11);
            if (z) {
                jColor = appColors.accentFill;
            } else {
                long j = appColors.cardBackground;
                jColor = BrushKt.Color(Color.m440getRedimpl(j), Color.m439getGreenimpl(j), Color.m437getBlueimpl(j), 0.5f, Color.m438getColorSpaceimpl(j));
            }
            long j2 = z ? appColors.accentBorder : appColors.cardBorder;
            Modifier modifierM130paddingVpY3zN4$default = OffsetKt.m130paddingVpY3zN4$default(ImageKt.m51clickableoSLSa3U$default(ImageKt.m48borderxT4_qwU(1, ((Color) SingleValueAnimationKt.m26animateColorAsStateeuL9pac(j2, null, "pillBorder", gapComposer, 384, 10).getValue()).value, ImageKt.m47backgroundbw27NRU(ClipKt.clip(SizeKt.m135height3ABfNKs(modifier, 38), roundedCornerShapeM158RoundedCornerShape0680j_4), ((Color) SingleValueAnimationKt.m26animateColorAsStateeuL9pac(jColor, null, "pillBg", gapComposer2, 384, 10).getValue()).value, BrushKt.RectangleShape), roundedCornerShapeM158RoundedCornerShape0680j_4), false, null, function0, 15), 8, 0.0f, 2);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
            long j3 = gapComposer.compositeKeyHashCode;
            int i3 = (int) (j3 ^ (j3 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifierM130paddingVpY3zN4$default);
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer.useNode();
            }
            Stack.m295setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m295setimpl(gapComposer, Integer.valueOf(i3), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m294reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m295setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            TextKt.m275TextNvy7gAk(str, null, appColors.textPrimary, TextUnitKt.getSp(13), null, z ? FontWeight.Bold : FontWeight.Medium, 0L, new TextAlign(3), 0L, 0, false, 1, 0, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.labelMedium, gapComposer, (i2 & 14) | 24576, 24576, 113578);
            gapComposer2 = gapComposer;
            gapComposer2.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ProxyScreenKt$$ExternalSyntheticLambda2(str, z, function0, modifier, i, 3);
        }
    }

    public static final void SettingsSection(String str, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(-1052376921);
        if (((i | (gapComposer2.changed(str) ? 4 : 2)) & 19) == 18 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.m111spacedBy0680j_4(10), Alignment.Companion.Start, gapComposer2, 6);
            long j = gapComposer2.compositeKeyHashCode;
            int i2 = (int) (j ^ (j >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, companion);
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
            Stack.m295setimpl(gapComposer2, Integer.valueOf(i2), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m294reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            TextKt.m275TextNvy7gAk(str.toUpperCase(Locale.ROOT), OffsetKt.m132paddingqDBjuR0$default(companion, 4, 0.0f, 0.0f, 0.0f, 14), appColors.textSecondary, TextUnitKt.getSp(11), null, FontWeight.SemiBold, TextUnitKt.getSp(0.6d), null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.labelSmall, gapComposer, 102260784, 0, 130728);
            gapComposer2 = gapComposer;
            composableLambdaImpl.invoke((Object) gapComposer2, (Object) 6);
            gapComposer2.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new BasicTooltipKt$$ExternalSyntheticLambda7(str, composableLambdaImpl, i, 4);
        }
    }
}
