package com.github.kr328.clash.compose;

import androidx.camera.core.impl.Quirks;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.filled.OpenInBrowserKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.MenuKt$$ExternalSyntheticLambda1;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.res.StringResources_androidKt;
import com.github.kr328.clash.design.compose.theme.AppColors;
import com.google.android.gms.internal.mlkit_vision_common.zzjn;
import com.google.android.gms.internal.mlkit_vision_common.zzjo;
import com.koala.clash.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ApkBrokenScreenKt {

    /* JADX INFO: renamed from: com.github.kr328.clash.compose.ApkBrokenScreenKt$ApkBrokenScreen$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 implements Function3 {
        public final /* synthetic */ Object $onOpenReleases;
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Object $releasesUrl;

        public /* synthetic */ AnonymousClass1(int i, Object obj, Object obj2) {
            this.$r8$classId = i;
            this.$onOpenReleases = obj;
            this.$releasesUrl = obj2;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            GapComposer gapComposer;
            int i = this.$r8$classId;
            Object obj4 = this.$onOpenReleases;
            Object obj5 = this.$releasesUrl;
            switch (i) {
                case 0:
                    GapComposer gapComposer2 = (GapComposer) obj2;
                    String str = (String) obj5;
                    Function1 function1 = (Function1) obj4;
                    if ((((Number) obj3).intValue() & 17) == 16 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        zzjo.PreferenceTip(StringResources_androidKt.stringResource(R.string.application_broken_tips, gapComposer2), null, gapComposer2, 0);
                        zzjo.PreferenceCategory(StringResources_androidKt.stringResource(R.string.reinstall, gapComposer2), null, gapComposer2, 0);
                        String strStringResource = StringResources_androidKt.stringResource(R.string.github_releases, gapComposer2);
                        ImageVector imageVectorBuild = OpenInBrowserKt._openInBrowser;
                        if (imageVectorBuild == null) {
                            ImageVector.Builder builder = new ImageVector.Builder("Filled.OpenInBrowser", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                            int i2 = VectorKt.$r8$clinit;
                            SolidColor solidColor = new SolidColor(Color.Black);
                            Quirks quirks = new Quirks();
                            quirks.moveTo(19.0f, 4.0f);
                            quirks.lineTo(5.0f, 4.0f);
                            quirks.curveToRelative(-1.11f, 0.0f, -2.0f, 0.9f, -2.0f, 2.0f);
                            quirks.verticalLineToRelative(12.0f);
                            quirks.curveToRelative(0.0f, 1.1f, 0.89f, 2.0f, 2.0f, 2.0f);
                            quirks.horizontalLineToRelative(4.0f);
                            quirks.verticalLineToRelative(-2.0f);
                            quirks.lineTo(5.0f, 18.0f);
                            quirks.lineTo(5.0f, 8.0f);
                            quirks.horizontalLineToRelative(14.0f);
                            quirks.verticalLineToRelative(10.0f);
                            quirks.horizontalLineToRelative(-4.0f);
                            quirks.verticalLineToRelative(2.0f);
                            quirks.horizontalLineToRelative(4.0f);
                            quirks.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
                            quirks.lineTo(21.0f, 6.0f);
                            quirks.curveToRelative(0.0f, -1.1f, -0.89f, -2.0f, -2.0f, -2.0f);
                            quirks.close();
                            quirks.moveTo(12.0f, 10.0f);
                            quirks.lineToRelative(-4.0f, 4.0f);
                            quirks.horizontalLineToRelative(3.0f);
                            quirks.verticalLineToRelative(6.0f);
                            quirks.horizontalLineToRelative(2.0f);
                            quirks.verticalLineToRelative(-6.0f);
                            quirks.horizontalLineToRelative(3.0f);
                            quirks.lineToRelative(-4.0f, -4.0f);
                            quirks.close();
                            ImageVector.Builder.m502addPathoIyEayM$default(builder, quirks.mQuirks, solidColor);
                            imageVectorBuild = builder.build();
                            OpenInBrowserKt._openInBrowser = imageVectorBuild;
                        }
                        ImageVector imageVector = imageVectorBuild;
                        gapComposer2.startReplaceGroup(528385988);
                        boolean zChanged = gapComposer2.changed(function1) | gapComposer2.changed(str);
                        Object objRememberedValue = gapComposer2.rememberedValue();
                        if (zChanged || objRememberedValue == Composer$Companion.Empty) {
                            objRememberedValue = new Recomposer$$ExternalSyntheticLambda6(23, function1, str);
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        }
                        gapComposer2.end(false);
                        zzjo.PreferenceClickable(strStringResource, (Function0) objRememberedValue, null, (String) obj5, imageVector, false, null, gapComposer2, 0, 100);
                    }
                    break;
                case 1:
                    Function2 function2 = (Function2) obj;
                    GapComposer gapComposer3 = (GapComposer) obj2;
                    int iIntValue = ((Number) obj3).intValue();
                    if ((iIntValue & 6) == 0) {
                        iIntValue |= gapComposer3.changedInstance(function2) ? 4 : 2;
                    }
                    int i3 = iIntValue;
                    if ((i3 & 19) == 18 && gapComposer3.getSkipping()) {
                        gapComposer3.skipToGroupEnd();
                    } else {
                        Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f);
                        AppColors appColors = (AppColors) obj4;
                        MutableState mutableState = (MutableState) obj5;
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                        long j = gapComposer3.compositeKeyHashCode;
                        int i4 = (int) (j ^ (j >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer3.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer3, modifierFillMaxWidth);
                        ComposeUiNode.Companion.getClass();
                        Function0 function0 = ComposeUiNode.Companion.Constructor;
                        gapComposer3.startReusableNode();
                        if (gapComposer3.inserting) {
                            gapComposer3.createNode(function0);
                        } else {
                            gapComposer3.useNode();
                        }
                        Stack.m295setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                        Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                        Stack.m295setimpl(gapComposer3, Integer.valueOf(i4), ComposeUiNode.Companion.SetCompositeKeyHash);
                        Stack.m294reconcileimpl(gapComposer3, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                        Stack.m295setimpl(gapComposer3, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                        gapComposer3.startReplaceGroup(488146499);
                        if (((String) mutableState.getValue()).length() == 0) {
                            TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.search, gapComposer3), null, appColors.textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer3.consume(MaterialThemeKt._localMaterialTheme)).typography.titleMedium, gapComposer3, 0, 0, 131066);
                            gapComposer = gapComposer3;
                        } else {
                            gapComposer = gapComposer3;
                        }
                        gapComposer.end(false);
                        function2.invoke(gapComposer, Integer.valueOf(i3 & 14));
                        gapComposer.end(true);
                    }
                    break;
                default:
                    PaddingValues paddingValues = (PaddingValues) obj;
                    GapComposer gapComposer4 = (GapComposer) obj2;
                    int iIntValue2 = ((Number) obj3).intValue();
                    if ((iIntValue2 & 6) == 0) {
                        iIntValue2 |= gapComposer4.changed(paddingValues) ? 4 : 2;
                    }
                    if ((iIntValue2 & 19) == 18 && gapComposer4.getSkipping()) {
                        gapComposer4.skipToGroupEnd();
                    } else {
                        float f = 8;
                        Modifier modifierM129paddingVpY3zN4 = OffsetKt.m129paddingVpY3zN4(ImageKt.verticalScroll$default(OffsetKt.m132paddingqDBjuR0$default(ImageKt.m47backgroundbw27NRU(SizeKt.FillWholeMaxSize, ((AppColors) obj4).appBackground, BrushKt.RectangleShape), 0.0f, paddingValues.mo120calculateTopPaddingD9Ej5fM(), 0.0f, paddingValues.mo117calculateBottomPaddingD9Ej5fM(), 5), ImageKt.rememberScrollState(gapComposer4)), 16, f);
                        ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) obj5;
                        ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.m111spacedBy0680j_4(f), Alignment.Companion.Start, gapComposer4, 6);
                        long j2 = gapComposer4.compositeKeyHashCode;
                        int i5 = (int) (j2 ^ (j2 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer4.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer4, modifierM129paddingVpY3zN4);
                        ComposeUiNode.Companion.getClass();
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                        gapComposer4.startReusableNode();
                        if (gapComposer4.inserting) {
                            gapComposer4.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer4.useNode();
                        }
                        Stack.m295setimpl(gapComposer4, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                        Stack.m295setimpl(gapComposer4, persistentCompositionLocalMapCurrentCompositionLocalScope2, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                        Stack.m295setimpl(gapComposer4, Integer.valueOf(i5), ComposeUiNode.Companion.SetCompositeKeyHash);
                        Stack.m294reconcileimpl(gapComposer4, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                        Stack.m295setimpl(gapComposer4, modifierMaterializeModifier2, ComposeUiNode.Companion.SetModifier);
                        composableLambdaImpl.invoke((Object) ColumnScopeInstance.INSTANCE, (Object) gapComposer4, (Object) 6);
                        gapComposer4.end(true);
                    }
                    break;
            }
            return Unit.INSTANCE;
        }
    }

    public static final void ApkBrokenScreen(Function1 function1, Function0 function0, Modifier modifier, GapComposer gapComposer, int i) {
        Modifier modifier2;
        gapComposer.startRestartGroup(-1655782995);
        int i2 = (gapComposer.changedInstance(function1) ? 4 : 2) | i | (gapComposer.changedInstance(function0) ? 32 : 16) | 384;
        if ((i2 & 147) == 146 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
        } else {
            String strStringResource = StringResources_androidKt.stringResource(R.string.meta_github_url, gapComposer);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            zzjn.PreferenceScaffold(StringResources_androidKt.stringResource(R.string.application_broken, gapComposer), function0, companion, null, null, Thread_jvmKt.rememberComposableLambda(-1534423302, new AnonymousClass1(0, function1, strStringResource), gapComposer), gapComposer, (i2 & 112) | 196992, 24);
            modifier2 = companion;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MenuKt$$ExternalSyntheticLambda1(function1, function0, modifier2, i, 4);
        }
    }
}
