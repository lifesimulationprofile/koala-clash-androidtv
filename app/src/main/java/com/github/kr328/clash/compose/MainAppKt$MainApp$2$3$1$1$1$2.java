package com.github.kr328.clash.compose;

import android.content.Context;
import androidx.camera.core.impl.Quirks;
import androidx.compose.animation.AnimatedContentScopeImpl;
import androidx.compose.foundation.layout.Arrangement;
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
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.material.icons.outlined.ContentCopyKt;
import androidx.compose.material.icons.outlined.ContentPasteKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda0;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import com.github.kr328.clash.compose.profiles.ProfileCardKt$ProfileActionsMenu$1$$ExternalSyntheticLambda0;
import com.github.kr328.clash.compose.proxy.ProxyScreenKt;
import com.github.kr328.clash.core.model.LogMessage;
import com.github.kr328.clash.core.model.TunnelState;
import com.github.kr328.clash.design.compose.components.ComposableSingletons$PreferenceScaffoldKt;
import com.github.kr328.clash.design.compose.theme.AppColors;
import com.github.kr328.clash.design.model.File;
import com.google.android.gms.internal.mlkit_vision_common.zzit;
import com.google.android.gms.internal.mlkit_vision_common.zzjb;
import com.koala.clash.R;
import java.text.SimpleDateFormat;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MainAppKt$MainApp$2$3$1$1$1$2 implements Function4 {
    public final /* synthetic */ Object $addProfileSheetOpen$delegate;
    public final /* synthetic */ Object $context;
    public final /* synthetic */ Object $padding;
    public final /* synthetic */ int $r8$classId;

    /* JADX INFO: renamed from: com.github.kr328.clash.compose.MainAppKt$MainApp$2$3$1$1$1$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 implements Function2 {
        public final /* synthetic */ Object $addProfileSheetOpen$delegate;
        public final /* synthetic */ Object $context;
        public final /* synthetic */ Object $padding;
        public final /* synthetic */ int $r8$classId;

        public AnonymousClass1(AppColors appColors, String str, Function0 function0) {
            this.$r8$classId = 4;
            ComposableLambdaImpl composableLambdaImpl = ComposableSingletons$PreferenceScaffoldKt.f30lambda1;
            this.$context = appColors;
            this.$padding = str;
            this.$addProfileSheetOpen$delegate = function0;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            int i = this.$r8$classId;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            Object obj3 = this.$addProfileSheetOpen$delegate;
            Object obj4 = this.$padding;
            Object obj5 = this.$context;
            switch (i) {
                case 0:
                    GapComposer gapComposer = (GapComposer) obj;
                    PaddingValues paddingValues = (PaddingValues) obj4;
                    Context context = (Context) obj5;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
                        gapComposer.skipToGroupEnd();
                    } else {
                        gapComposer.startReplaceGroup(-1845053276);
                        MutableState mutableState = (MutableState) obj3;
                        Object objRememberedValue = gapComposer.rememberedValue();
                        if (objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = new TooltipKt$$ExternalSyntheticLambda0(mutableState, 17);
                            gapComposer.updateRememberedValue(objRememberedValue);
                        }
                        Function0 function0 = (Function0) objRememberedValue;
                        gapComposer.end(false);
                        gapComposer.startReplaceGroup(-1845048791);
                        boolean zChangedInstance = gapComposer.changedInstance(context);
                        Object objRememberedValue2 = gapComposer.rememberedValue();
                        if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                            objRememberedValue2 = new MainAppKt$$ExternalSyntheticLambda1(context, 1);
                            gapComposer.updateRememberedValue(objRememberedValue2);
                        }
                        gapComposer.end(false);
                        zzit.ProfilesScreen(function0, (Function1) objRememberedValue2, OffsetKt.m124PaddingValuesa9UjIt4$default(0.0f, paddingValues.mo120calculateTopPaddingD9Ej5fM(), 0.0f, paddingValues.mo117calculateBottomPaddingD9Ej5fM(), 5), null, false, gapComposer, 6, 24);
                    }
                    break;
                case 1:
                    GapComposer gapComposer2 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        Modifier modifierM128padding3ABfNKs = OffsetKt.m128padding3ABfNKs(SizeKt.fillMaxWidth(companion, 1.0f), 16);
                        AppColors appColors = (AppColors) obj5;
                        String str = (String) obj4;
                        ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) obj3;
                        ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, gapComposer2, 0);
                        long j = gapComposer2.compositeKeyHashCode;
                        int i2 = (int) (j ^ (j >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierM128padding3ABfNKs);
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
                        TextKt.m275TextNvy7gAk(str, null, appColors.textSecondary, 0L, null, FontWeight.SemiBold, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.labelMedium, gapComposer2, 1572864, 0, 131002);
                        OffsetKt.Spacer(gapComposer2, SizeKt.m135height3ABfNKs(companion, 8));
                        composableLambdaImpl.invoke((Object) gapComposer2, (Object) 0);
                        gapComposer2.end(true);
                    }
                    break;
                case 2:
                    GapComposer gapComposer3 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer3.getSkipping()) {
                        gapComposer3.skipToGroupEnd();
                    } else {
                        Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                        TunnelState.Mode mode = (TunnelState.Mode) obj5;
                        TunnelState.Mode mode2 = (TunnelState.Mode) obj4;
                        Function1 function1 = (Function1) obj3;
                        RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.m111spacedBy0680j_4(8), Alignment.Companion.Top, gapComposer3, 6);
                        long j2 = gapComposer3.compositeKeyHashCode;
                        int i3 = (int) ((j2 >>> 32) ^ j2);
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
                        Stack.m295setimpl(gapComposer3, Integer.valueOf(i3), ComposeUiNode.Companion.SetCompositeKeyHash);
                        Stack.m294reconcileimpl(gapComposer3, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                        Stack.m295setimpl(gapComposer3, modifierMaterializeModifier2, ComposeUiNode.Companion.SetModifier);
                        String strStringResource = StringResources_androidKt.stringResource(R.string.rule_mode, gapComposer3);
                        TunnelState.Mode mode3 = TunnelState.Mode.Rule;
                        boolean z = mode == mode3;
                        boolean z2 = mode2 == mode3;
                        if (1.0f <= 0.0d) {
                            InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                        }
                        LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
                        gapComposer3.startReplaceGroup(1968790268);
                        boolean zChanged = gapComposer3.changed(function1);
                        Object objRememberedValue3 = gapComposer3.rememberedValue();
                        if (zChanged || objRememberedValue3 == neverEqualPolicy) {
                            objRememberedValue3 = new FilesScreenKt$FilesScreen$1$3$$ExternalSyntheticLambda0(function1, 1);
                            gapComposer3.updateRememberedValue(objRememberedValue3);
                        }
                        gapComposer3.end(false);
                        ProxyScreenKt.SegmentedPill(strStringResource, z, (Function0) objRememberedValue3, layoutWeightElement, z2, gapComposer3, 6, 0);
                        String strStringResource2 = StringResources_androidKt.stringResource(R.string.global_mode, gapComposer3);
                        TunnelState.Mode mode4 = TunnelState.Mode.Global;
                        boolean z3 = mode == mode4;
                        boolean z4 = mode2 == mode4;
                        if (1.0f <= 0.0d) {
                            InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                        }
                        boolean z5 = z3;
                        LayoutWeightElement layoutWeightElement2 = new LayoutWeightElement(1.0f, true);
                        gapComposer3.startReplaceGroup(1968804446);
                        boolean zChanged2 = gapComposer3.changed(function1);
                        Object objRememberedValue4 = gapComposer3.rememberedValue();
                        if (zChanged2 || objRememberedValue4 == neverEqualPolicy) {
                            objRememberedValue4 = new FilesScreenKt$FilesScreen$1$3$$ExternalSyntheticLambda0(function1, 2);
                            gapComposer3.updateRememberedValue(objRememberedValue4);
                        }
                        gapComposer3.end(false);
                        ProxyScreenKt.SegmentedPill(strStringResource2, z5, (Function0) objRememberedValue4, layoutWeightElement2, z4, gapComposer3, 6, 0);
                        gapComposer3.end(true);
                    }
                    break;
                case 3:
                    GapComposer gapComposer4 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer4.getSkipping()) {
                        gapComposer4.skipToGroupEnd();
                    } else {
                        Function0 function2 = (Function0) obj5;
                        Function0 function3 = (Function0) obj4;
                        Function0 function4 = (Function0) obj3;
                        ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.m111spacedBy0680j_4(2), Alignment.Companion.Start, gapComposer4, 6);
                        long j3 = gapComposer4.compositeKeyHashCode;
                        int i4 = (int) (j3 ^ (j3 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope3 = gapComposer4.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier3 = AbsoluteAlignment.materializeModifier(gapComposer4, companion);
                        ComposeUiNode.Companion.getClass();
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$3 = ComposeUiNode.Companion.Constructor;
                        gapComposer4.startReusableNode();
                        if (gapComposer4.inserting) {
                            gapComposer4.createNode(layoutNode$Companion$Constructor$3);
                        } else {
                            gapComposer4.useNode();
                        }
                        Stack.m295setimpl(gapComposer4, columnMeasurePolicy2, ComposeUiNode.Companion.SetMeasurePolicy);
                        Stack.m295setimpl(gapComposer4, persistentCompositionLocalMapCurrentCompositionLocalScope3, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                        Stack.m295setimpl(gapComposer4, Integer.valueOf(i4), ComposeUiNode.Companion.SetCompositeKeyHash);
                        Stack.m294reconcileimpl(gapComposer4, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                        Stack.m295setimpl(gapComposer4, modifierMaterializeModifier3, ComposeUiNode.Companion.SetModifier);
                        ImageVector contentPaste = ContentPasteKt.getContentPaste();
                        String strStringResource3 = StringResources_androidKt.stringResource(R.string.import_from_clipboard, gapComposer4);
                        gapComposer4.startReplaceGroup(797916106);
                        boolean zChanged3 = gapComposer4.changed(function2) | gapComposer4.changed(function3);
                        Object objRememberedValue5 = gapComposer4.rememberedValue();
                        if (zChanged3 || objRememberedValue5 == neverEqualPolicy) {
                            objRememberedValue5 = new ProfileCardKt$ProfileActionsMenu$1$$ExternalSyntheticLambda0(function2, function3, 6);
                            gapComposer4.updateRememberedValue(objRememberedValue5);
                        }
                        gapComposer4.end(false);
                        zzjb.ActionRow(contentPaste, strStringResource3, (Function0) objRememberedValue5, gapComposer4, 0);
                        ImageVector imageVectorBuild = ContentCopyKt._contentCopy;
                        if (imageVectorBuild == null) {
                            ImageVector.Builder builder = new ImageVector.Builder("Outlined.ContentCopy", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                            int i5 = VectorKt.$r8$clinit;
                            SolidColor solidColor = new SolidColor(Color.Black);
                            Quirks quirks = new Quirks();
                            quirks.moveTo(16.0f, 1.0f);
                            quirks.lineTo(4.0f, 1.0f);
                            quirks.curveToRelative(-1.1f, 0.0f, -2.0f, 0.9f, -2.0f, 2.0f);
                            quirks.verticalLineToRelative(14.0f);
                            quirks.horizontalLineToRelative(2.0f);
                            quirks.lineTo(4.0f, 3.0f);
                            quirks.horizontalLineToRelative(12.0f);
                            quirks.lineTo(16.0f, 1.0f);
                            quirks.close();
                            quirks.moveTo(19.0f, 5.0f);
                            quirks.lineTo(8.0f, 5.0f);
                            quirks.curveToRelative(-1.1f, 0.0f, -2.0f, 0.9f, -2.0f, 2.0f);
                            quirks.verticalLineToRelative(14.0f);
                            quirks.curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
                            quirks.horizontalLineToRelative(11.0f);
                            quirks.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
                            quirks.lineTo(21.0f, 7.0f);
                            quirks.curveToRelative(0.0f, -1.1f, -0.9f, -2.0f, -2.0f, -2.0f);
                            quirks.close();
                            quirks.moveTo(19.0f, 21.0f);
                            quirks.lineTo(8.0f, 21.0f);
                            quirks.lineTo(8.0f, 7.0f);
                            quirks.horizontalLineToRelative(11.0f);
                            quirks.verticalLineToRelative(14.0f);
                            quirks.close();
                            ImageVector.Builder.m502addPathoIyEayM$default(builder, quirks.mQuirks, solidColor);
                            imageVectorBuild = builder.build();
                            ContentCopyKt._contentCopy = imageVectorBuild;
                        }
                        String strStringResource4 = StringResources_androidKt.stringResource(R.string.export_to_clipboard, gapComposer4);
                        gapComposer4.startReplaceGroup(797926730);
                        boolean zChanged4 = gapComposer4.changed(function2) | gapComposer4.changed(function4);
                        Object objRememberedValue6 = gapComposer4.rememberedValue();
                        if (zChanged4 || objRememberedValue6 == neverEqualPolicy) {
                            objRememberedValue6 = new ProfileCardKt$ProfileActionsMenu$1$$ExternalSyntheticLambda0(function2, function4, 7);
                            gapComposer4.updateRememberedValue(objRememberedValue6);
                        }
                        gapComposer4.end(false);
                        zzjb.ActionRow(imageVectorBuild, strStringResource4, (Function0) objRememberedValue6, gapComposer4, 0);
                        gapComposer4.end(true);
                    }
                    break;
                default:
                    GapComposer gapComposer5 = (GapComposer) obj;
                    AppColors appColors2 = (AppColors) obj5;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer5.getSkipping()) {
                        gapComposer5.skipToGroupEnd();
                    } else {
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Thread_jvmKt.rememberComposableLambda(-1937884379, new LogcatScreenKt.AnonymousClass2.AnonymousClass1(appColors2, (String) obj4, 4), gapComposer5);
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda2 = Thread_jvmKt.rememberComposableLambda(-391800477, new LogsScreenKt.AnonymousClass2((Function0) obj3, appColors2, 18), gapComposer5);
                        ComposableLambdaImpl composableLambdaImpl2 = ComposableSingletons$PreferenceScaffoldKt.f30lambda1;
                        PaddingValuesImpl paddingValuesImpl = TopAppBarDefaults.ContentPadding;
                        long j4 = Color.Transparent;
                        long j5 = appColors2.textPrimary;
                        AppBarKt.m238TopAppBargNPyAyM(composableLambdaImplRememberComposableLambda, null, composableLambdaImplRememberComposableLambda2, composableLambdaImpl2, 0.0f, null, TopAppBarDefaults.m278topAppBarColors5tl4gsc(j4, j4, j5, j5, j5, gapComposer5, 32), null, gapComposer5, 390, 434);
                    }
                    break;
            }
            return Unit.INSTANCE;
        }

        public /* synthetic */ AnonymousClass1(Object obj, Object obj2, Object obj3, int i) {
            this.$r8$classId = i;
            this.$context = obj;
            this.$padding = obj2;
            this.$addProfileSheetOpen$delegate = obj3;
        }
    }

    public /* synthetic */ MainAppKt$MainApp$2$3$1$1$1$2(Object obj, Object obj2, Object obj3, int i) {
        this.$r8$classId = i;
        this.$context = obj;
        this.$padding = obj2;
        this.$addProfileSheetOpen$delegate = obj3;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        int i;
        int i2;
        int i3;
        switch (this.$r8$classId) {
            case 0:
                GapComposer gapComposer = (GapComposer) obj3;
                MainAppKt.ScreenWrapper((AnimatedContentScopeImpl) obj, Thread_jvmKt.rememberComposableLambda(2046177126, new AnonymousClass1((Context) this.$context, (PaddingValues) this.$padding, (MutableState) this.$addProfileSheetOpen$delegate, 0), gapComposer), gapComposer, (((Number) obj4).intValue() & 14) | 48);
                break;
            case 1:
                LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj;
                int iIntValue = ((Number) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) obj3;
                int iIntValue2 = ((Number) obj4).intValue();
                Function1 function1 = (Function1) this.$padding;
                if ((iIntValue2 & 6) == 0) {
                    i = (gapComposer2.changed(lazyItemScopeImpl) ? 4 : 2) | iIntValue2;
                } else {
                    i = iIntValue2;
                }
                if ((iIntValue2 & 48) == 0) {
                    i |= gapComposer2.changed(iIntValue) ? 32 : 16;
                }
                if (gapComposer2.shouldExecute(i & 1, (i & 147) != 146)) {
                    File file = (File) ((List) this.$context).get(iIntValue);
                    gapComposer2.startReplaceGroup(2107371913);
                    gapComposer2.startReplaceGroup(-1040396757);
                    boolean zChanged = gapComposer2.changed(function1) | gapComposer2.changedInstance(file);
                    Object objRememberedValue = gapComposer2.rememberedValue();
                    NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
                    if (zChanged || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new Http2Connection.ReaderRunnable(1, function1, file);
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    Function0 function0 = (Function0) objRememberedValue;
                    gapComposer2.end(false);
                    gapComposer2.startReplaceGroup(-1040394659);
                    boolean zChangedInstance = gapComposer2.changedInstance(file);
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new Http2Connection.ReaderRunnable(2, file, (MutableState) this.$addProfileSheetOpen$delegate);
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    gapComposer2.end(false);
                    FilesScreenKt.FileRow(file, function0, (Function0) objRememberedValue2, gapComposer2, 0);
                    gapComposer2.end(false);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                break;
            case 2:
                LazyItemScopeImpl lazyItemScopeImpl2 = (LazyItemScopeImpl) obj;
                int iIntValue3 = ((Number) obj2).intValue();
                GapComposer gapComposer3 = (GapComposer) obj3;
                int iIntValue4 = ((Number) obj4).intValue();
                Function1 function2 = (Function1) this.$addProfileSheetOpen$delegate;
                if ((iIntValue4 & 6) == 0) {
                    i2 = (gapComposer3.changed(lazyItemScopeImpl2) ? 4 : 2) | iIntValue4;
                } else {
                    i2 = iIntValue4;
                }
                if ((iIntValue4 & 48) == 0) {
                    i2 |= gapComposer3.changed(iIntValue3) ? 32 : 16;
                }
                if (gapComposer3.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
                    LogMessage logMessage = (LogMessage) ((List) this.$context).get(iIntValue3);
                    gapComposer3.startReplaceGroup(-1324358419);
                    SimpleDateFormat simpleDateFormat = (SimpleDateFormat) this.$padding;
                    gapComposer3.startReplaceGroup(1481303456);
                    boolean zChanged2 = gapComposer3.changed(function2) | gapComposer3.changedInstance(logMessage);
                    Object objRememberedValue3 = gapComposer3.rememberedValue();
                    if (zChanged2 || objRememberedValue3 == Composer$Companion.Empty) {
                        objRememberedValue3 = new Http2Connection.ReaderRunnable(3, function2, logMessage);
                        gapComposer3.updateRememberedValue(objRememberedValue3);
                    }
                    gapComposer3.end(false);
                    LogcatScreenKt.LogMessageRow(logMessage, simpleDateFormat, (Function0) objRememberedValue3, gapComposer3, 0);
                    gapComposer3.end(false);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                break;
            default:
                LazyItemScopeImpl lazyItemScopeImpl3 = (LazyItemScopeImpl) obj;
                int iIntValue5 = ((Number) obj2).intValue();
                GapComposer gapComposer4 = (GapComposer) obj3;
                int iIntValue6 = ((Number) obj4).intValue();
                Function1 function3 = (Function1) this.$padding;
                if ((iIntValue6 & 6) == 0) {
                    i3 = (gapComposer4.changed(lazyItemScopeImpl3) ? 4 : 2) | iIntValue6;
                } else {
                    i3 = iIntValue6;
                }
                if ((iIntValue6 & 48) == 0) {
                    i3 |= gapComposer4.changed(iIntValue5) ? 32 : 16;
                }
                if (gapComposer4.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
                    ProviderItemState providerItemState = (ProviderItemState) ((List) this.$context).get(iIntValue5);
                    gapComposer4.startReplaceGroup(1513189683);
                    long longValue = ((ParcelableSnapshotMutableLongState) this.$addProfileSheetOpen$delegate).getLongValue();
                    gapComposer4.startReplaceGroup(1849931279);
                    boolean zChanged3 = gapComposer4.changed(function3) | gapComposer4.changedInstance(providerItemState);
                    Object objRememberedValue4 = gapComposer4.rememberedValue();
                    if (zChanged3 || objRememberedValue4 == Composer$Companion.Empty) {
                        objRememberedValue4 = new Http2Connection.ReaderRunnable(4, function3, providerItemState);
                        gapComposer4.updateRememberedValue(objRememberedValue4);
                    }
                    gapComposer4.end(false);
                    ProvidersScreenKt.ProviderRow(providerItemState, longValue, (Function0) objRememberedValue4, gapComposer4, 0);
                    gapComposer4.end(false);
                } else {
                    gapComposer4.skipToGroupEnd();
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
