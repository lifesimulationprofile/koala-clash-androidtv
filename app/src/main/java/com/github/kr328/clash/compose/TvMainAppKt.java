package com.github.kr328.clash.compose;

import android.content.Context;
import androidx.activity.compose.BackHandlerKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.camera.core.AspectRatio;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.FlowRowOverflow;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda0;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda2;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetModifier$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayout$1;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.core.view.MenuHostHelper;
import coil.ImageLoader$Builder$$ExternalSyntheticLambda2;
import coil.disk.DiskLruCache$$ExternalSyntheticLambda0;
import com.github.kr328.clash.compose.home.HomeScreenKt;
import com.github.kr328.clash.compose.qrcode.TvQrCodeSheetKt;
import com.github.kr328.clash.compose.util.TvGlassTabRowKt;
import com.github.kr328.clash.design.compose.components.GlassSnackbarKt;
import com.github.kr328.clash.design.compose.theme.AppColors;
import com.github.kr328.clash.design.compose.theme.AppColorsKt;
import com.google.android.gms.internal.mlkit_vision_common.zzir;
import com.google.android.gms.internal.mlkit_vision_common.zzit;
import com.google.android.gms.internal.mlkit_vision_common.zziz;
import com.google.android.gms.internal.mlkit_vision_common.zzje;
import com.google.android.gms.internal.mlkit_vision_common.zzjq;
import com.koala.clash.R;
import dev.chrisbanes.haze.HazeKt;
import dev.chrisbanes.haze.HazeSourceElement;
import dev.chrisbanes.haze.HazeState;
import io.github.g00fy2.quickie.ScanQRCode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.io.FilesKt__UtilsKt$$ExternalSyntheticLambda0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class TvMainAppKt {
    public static final float TvOverscanHorizontal = 48;
    public static final float TvOverscanVertical = 27;

    public static final void TvMainApp(int i, GapComposer gapComposer) {
        gapComposer.startRestartGroup(-2039035619);
        if (i == 0 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            final Context context = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
            final AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            gapComposer.startReplaceGroup(-1047096848);
            Object objRememberedValue = gapComposer.rememberedValue();
            Object obj = Composer$Companion.Empty;
            if (objRememberedValue == obj) {
                objRememberedValue = new ParcelableSnapshotMutableIntState(0);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            final ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) objRememberedValue;
            Object objM = Density.CC.m(-1047094927, gapComposer, false);
            if (objM == obj) {
                objM = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objM);
            }
            final MutableState mutableState = (MutableState) objM;
            Object objM2 = Density.CC.m(-1047093007, gapComposer, false);
            if (objM2 == obj) {
                objM2 = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objM2);
            }
            final MutableState mutableState2 = (MutableState) objM2;
            Object objM3 = Density.CC.m(-1047090799, gapComposer, false);
            if (objM3 == obj) {
                objM3 = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objM3);
            }
            final MutableState mutableState3 = (MutableState) objM3;
            Object objM4 = Density.CC.m(-1047088744, gapComposer, false);
            Object obj2 = objM4;
            if (objM4 == obj) {
                ArrayList arrayList = new ArrayList(3);
                for (int i2 = 0; i2 < 3; i2++) {
                    arrayList.add(new FocusRequester());
                }
                gapComposer.updateRememberedValue(arrayList);
                obj2 = arrayList;
            }
            final List list = (List) obj2;
            Object objM5 = Density.CC.m(-1047086481, gapComposer, false);
            if (objM5 == obj) {
                objM5 = new SnackbarHostState();
                gapComposer.updateRememberedValue(objM5);
            }
            final SnackbarHostState snackbarHostState = (SnackbarHostState) objM5;
            gapComposer.end(false);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == obj) {
                objRememberedValue2 = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue2;
            Unit unit = Unit.INSTANCE;
            gapComposer.startReplaceGroup(-1047081854);
            boolean zChangedInstance = gapComposer.changedInstance(coroutineScope) | gapComposer.changedInstance(context);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == obj) {
                objRememberedValue3 = new MainAppKt$$ExternalSyntheticLambda0(coroutineScope, snackbarHostState, context, 1);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            gapComposer.end(false);
            Stack.DisposableEffect(unit, (Function1) objRememberedValue3, gapComposer);
            ScanQRCode scanQRCode = new ScanQRCode(5);
            gapComposer.startReplaceGroup(-1047033879);
            boolean zChangedInstance2 = gapComposer.changedInstance(context);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue4 == obj) {
                objRememberedValue4 = new MainAppKt$$ExternalSyntheticLambda1(context, 2);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            gapComposer.end(false);
            final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult = AspectRatio.rememberLauncherForActivityResult(scanQRCode, (Function1) objRememberedValue4, gapComposer, 0);
            boolean z = parcelableSnapshotMutableIntState.getIntValue() != 0;
            gapComposer.startReplaceGroup(-1047028549);
            boolean zChangedInstance3 = gapComposer.changedInstance(list);
            Object objRememberedValue5 = gapComposer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue5 == obj) {
                objRememberedValue5 = new TvMainAppKt$$ExternalSyntheticLambda2(list, parcelableSnapshotMutableIntState, 0);
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            gapComposer.end(false);
            BackHandlerKt.BackHandler(z, (Function0) objRememberedValue5, gapComposer, 0);
            final List listListOf = AppCompatHintHelper.listOf(StringResources_androidKt.stringResource(R.string.tab_home, gapComposer), StringResources_androidKt.stringResource(R.string.tab_profiles, gapComposer), StringResources_androidKt.stringResource(R.string.tab_settings, gapComposer));
            final boolean zIsInDarkTheme = zzjq.isInDarkTheme(gapComposer);
            final HazeState hazeStateRememberHazeState = HazeKt.rememberHazeState(gapComposer);
            Stack.CompositionLocalProvider(GlassSnackbarKt.LocalGlassSnackbarHost.defaultProvidedValue$runtime(snackbarHostState), Thread_jvmKt.rememberComposableLambda(-1453343651, new Function2() { // from class: com.github.kr328.clash.compose.TvMainAppKt.TvMainApp.3
                /* JADX WARN: Code duplicated, block: B:63:0x0262  */
                /* JADX WARN: Code duplicated, block: B:67:0x0284  */
                /* JADX WARN: Code duplicated, block: B:71:0x02a6  */
                /* JADX WARN: Code duplicated, block: B:75:0x02c7  */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r4v20 */
                /* JADX WARN: Type inference failed for: r4v21, types: [boolean, int] */
                /* JADX WARN: Type inference failed for: r4v22 */
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$1;
                    OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1;
                    ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2;
                    LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1;
                    ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3;
                    ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4;
                    GapComposer gapComposer2;
                    ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState2;
                    Object obj5;
                    NeverEqualPolicy neverEqualPolicy;
                    Object obj6;
                    boolean z2;
                    Object obj7;
                    boolean z3;
                    boolean z4;
                    ?? r4;
                    Object obj8;
                    Object obj9;
                    Object obj10;
                    Object obj11;
                    NeverEqualPolicy neverEqualPolicy2;
                    boolean z5;
                    Object obj12;
                    boolean zChangedInstance4;
                    Object obj13;
                    boolean zChangedInstance5;
                    Object obj14;
                    boolean zChangedInstance6;
                    Object obj15;
                    boolean zChangedInstance7;
                    Object obj16;
                    GapComposer gapComposer3 = (GapComposer) obj3;
                    if ((((Number) obj4).intValue() & 3) == 2 && gapComposer3.getSkipping()) {
                        gapComposer3.skipToGroupEnd();
                    } else {
                        FillElement fillElement = SizeKt.FillWholeMaxSize;
                        Modifier modifierM47backgroundbw27NRU = ImageKt.m47backgroundbw27NRU(fillElement, appColors.appBackground, BrushKt.RectangleShape);
                        BiasAlignment biasAlignment = Alignment.Companion.TopStart;
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                        MenuHostHelper menuHostHelper = gapComposer3.applier;
                        long j = gapComposer3.compositeKeyHashCode;
                        int i3 = (int) (j ^ (j >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer3.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer3, modifierM47backgroundbw27NRU);
                        ComposeUiNode.Companion.getClass();
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$2 = ComposeUiNode.Companion.Constructor;
                        gapComposer3.startReusableNode();
                        if (gapComposer3.inserting) {
                            gapComposer3.createNode(layoutNode$Companion$Constructor$2);
                        } else {
                            gapComposer3.useNode();
                        }
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$5 = ComposeUiNode.Companion.SetMeasurePolicy;
                        Stack.m295setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy, composeUiNode$Companion$SetModifier$5);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$6 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                        Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope, composeUiNode$Companion$SetModifier$6);
                        Integer numValueOf = Integer.valueOf(i3);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$7 = ComposeUiNode.Companion.SetCompositeKeyHash;
                        Stack.m295setimpl(gapComposer3, numValueOf, composeUiNode$Companion$SetModifier$7);
                        OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$2 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
                        Stack.m294reconcileimpl(gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$2);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$8 = ComposeUiNode.Companion.SetModifier;
                        Stack.m295setimpl(gapComposer3, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$8);
                        FlowRowOverflow flowRowOverflow = FlowRowOverflow.INSTANCE;
                        gapComposer3.startReplaceGroup(-1493196330);
                        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState3 = parcelableSnapshotMutableIntState;
                        int intValue = parcelableSnapshotMutableIntState3.getIntValue();
                        HazeState hazeState = hazeStateRememberHazeState;
                        if (intValue == 0) {
                            ownerSnapshotObserver$onCommitAffectingLayout$1 = ownerSnapshotObserver$onCommitAffectingLayout$2;
                            composeUiNode$Companion$SetModifier$4 = composeUiNode$Companion$SetModifier$8;
                            composeUiNode$Companion$SetModifier$1 = composeUiNode$Companion$SetModifier$6;
                            composeUiNode$Companion$SetModifier$2 = composeUiNode$Companion$SetModifier$7;
                            layoutNode$Companion$Constructor$1 = layoutNode$Companion$Constructor$2;
                            composeUiNode$Companion$SetModifier$3 = composeUiNode$Companion$SetModifier$5;
                            ImageKt.Image(PainterResources_androidKt.painterResource(zIsInDarkTheme ? R.drawable.map_dark : R.drawable.map_light, gapComposer3), null, fillElement.then(new HazeSourceElement(hazeState)), null, ContentScale.Companion.Crop, 0.0f, gapComposer3, 24632, 104);
                            gapComposer2 = gapComposer3;
                        } else {
                            composeUiNode$Companion$SetModifier$1 = composeUiNode$Companion$SetModifier$6;
                            ownerSnapshotObserver$onCommitAffectingLayout$1 = ownerSnapshotObserver$onCommitAffectingLayout$2;
                            composeUiNode$Companion$SetModifier$2 = composeUiNode$Companion$SetModifier$7;
                            layoutNode$Companion$Constructor$1 = layoutNode$Companion$Constructor$2;
                            composeUiNode$Companion$SetModifier$3 = composeUiNode$Companion$SetModifier$5;
                            composeUiNode$Companion$SetModifier$4 = composeUiNode$Companion$SetModifier$8;
                            gapComposer2 = gapComposer3;
                        }
                        gapComposer2.end(false);
                        Modifier modifierM129paddingVpY3zN4 = OffsetKt.m129paddingVpY3zN4(fillElement, TvMainAppKt.TvOverscanHorizontal, TvMainAppKt.TvOverscanVertical);
                        ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, gapComposer2, 0);
                        long j2 = gapComposer2.compositeKeyHashCode;
                        int i4 = (int) (j2 ^ (j2 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer2, modifierM129paddingVpY3zN4);
                        gapComposer2.startReusableNode();
                        if (gapComposer2.inserting) {
                            gapComposer2.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer2.useNode();
                        }
                        Stack.m295setimpl(gapComposer2, columnMeasurePolicy, composeUiNode$Companion$SetModifier$3);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$9 = composeUiNode$Companion$SetModifier$1;
                        Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$9);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$10 = composeUiNode$Companion$SetModifier$2;
                        OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$3 = ownerSnapshotObserver$onCommitAffectingLayout$1;
                        Modifier.CC.m(i4, gapComposer2, composeUiNode$Companion$SetModifier$10, gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$3);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$11 = composeUiNode$Companion$SetModifier$4;
                        Stack.m295setimpl(gapComposer2, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$11);
                        int intValue2 = parcelableSnapshotMutableIntState3.getIntValue();
                        gapComposer2.startReplaceGroup(-368624384);
                        Object objRememberedValue6 = gapComposer2.rememberedValue();
                        int i5 = 10;
                        NeverEqualPolicy neverEqualPolicy3 = Composer$Companion.Empty;
                        if (objRememberedValue6 == neverEqualPolicy3) {
                            parcelableSnapshotMutableIntState2 = parcelableSnapshotMutableIntState3;
                            DiskLruCache$$ExternalSyntheticLambda0 diskLruCache$$ExternalSyntheticLambda0 = new DiskLruCache$$ExternalSyntheticLambda0(i5, parcelableSnapshotMutableIntState2);
                            gapComposer2.updateRememberedValue(diskLruCache$$ExternalSyntheticLambda0);
                            obj5 = diskLruCache$$ExternalSyntheticLambda0;
                        } else {
                            parcelableSnapshotMutableIntState2 = parcelableSnapshotMutableIntState3;
                            obj5 = objRememberedValue6;
                        }
                        Function1 function1 = (Function1) obj5;
                        gapComposer2.end(false);
                        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                        Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                        gapComposer2.startReplaceGroup(-368617790);
                        List list2 = list;
                        boolean zChangedInstance8 = gapComposer2.changedInstance(list2);
                        Object objRememberedValue7 = gapComposer2.rememberedValue();
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$12 = composeUiNode$Companion$SetModifier$3;
                        Object obj17 = objRememberedValue7;
                        if (zChangedInstance8 || objRememberedValue7 == neverEqualPolicy3) {
                            TvMainAppKt$$ExternalSyntheticLambda2 tvMainAppKt$$ExternalSyntheticLambda2 = new TvMainAppKt$$ExternalSyntheticLambda2(list2, parcelableSnapshotMutableIntState2, 1);
                            gapComposer2.updateRememberedValue(tvMainAppKt$$ExternalSyntheticLambda2);
                            obj17 = tvMainAppKt$$ExternalSyntheticLambda2;
                        }
                        Function0 function0 = (Function0) obj17;
                        Object objM6 = Density.CC.m(-368614002, gapComposer2, false);
                        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState4 = parcelableSnapshotMutableIntState2;
                        Object obj18 = objM6;
                        if (objM6 == neverEqualPolicy3) {
                            ImageLoader$Builder$$ExternalSyntheticLambda2 imageLoader$Builder$$ExternalSyntheticLambda2 = new ImageLoader$Builder$$ExternalSyntheticLambda2(24);
                            gapComposer2.updateRememberedValue(imageLoader$Builder$$ExternalSyntheticLambda2);
                            obj18 = imageLoader$Builder$$ExternalSyntheticLambda2;
                        }
                        gapComposer2.end(false);
                        int i6 = 10;
                        TvGlassTabRowKt.TvGlassTabRow(intValue2, listListOf, function1, modifierFillMaxWidth, hazeState, list2, function0, (Function0) obj18, gapComposer2, 12586368);
                        OffsetKt.Spacer(gapComposer2, SizeKt.m135height3ABfNKs(companion, 10));
                        if (1.0f <= 0.0d) {
                            InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                        }
                        Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(new LayoutWeightElement(1.0f, true), 1.0f);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                        long j3 = gapComposer2.compositeKeyHashCode;
                        int i7 = (int) (j3 ^ (j3 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope3 = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier3 = AbsoluteAlignment.materializeModifier(gapComposer2, modifierFillMaxWidth2);
                        gapComposer2.startReusableNode();
                        if (gapComposer2.inserting) {
                            gapComposer2.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer2.useNode();
                        }
                        Stack.m295setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy2, composeUiNode$Companion$SetModifier$12);
                        Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope3, composeUiNode$Companion$SetModifier$9);
                        Modifier.CC.m(i7, gapComposer2, composeUiNode$Companion$SetModifier$10, gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$3);
                        Stack.m295setimpl(gapComposer2, modifierMaterializeModifier3, composeUiNode$Companion$SetModifier$11);
                        int intValue3 = parcelableSnapshotMutableIntState4.getIntValue();
                        Context context2 = context;
                        MutableState mutableState4 = mutableState2;
                        MutableState mutableState5 = mutableState;
                        if (intValue3 == 0) {
                            neverEqualPolicy = neverEqualPolicy3;
                            gapComposer2.startReplaceGroup(-789710643);
                            gapComposer2.startReplaceGroup(-789709597);
                            Object objRememberedValue8 = gapComposer2.rememberedValue();
                            if (objRememberedValue8 == neverEqualPolicy) {
                                obj6 = objRememberedValue8;
                                TooltipKt$$ExternalSyntheticLambda0 tooltipKt$$ExternalSyntheticLambda0 = new TooltipKt$$ExternalSyntheticLambda0(mutableState4, 24);
                                gapComposer2.updateRememberedValue(tooltipKt$$ExternalSyntheticLambda0);
                                obj6 = tooltipKt$$ExternalSyntheticLambda0;
                            }
                            obj6 = objRememberedValue8;
                            Function0 function2 = (Function0) obj6;
                            gapComposer2.end(false);
                            gapComposer2.startReplaceGroup(-789707453);
                            boolean zChangedInstance9 = gapComposer2.changedInstance(context2);
                            ManagedActivityResultLauncher managedActivityResultLauncher = managedActivityResultLauncherRememberLauncherForActivityResult;
                            boolean zChangedInstance10 = zChangedInstance9 | gapComposer2.changedInstance(managedActivityResultLauncher);
                            Object objRememberedValue9 = gapComposer2.rememberedValue();
                            if (zChangedInstance10 || objRememberedValue9 == neverEqualPolicy) {
                                z2 = false;
                                TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda15 tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda15 = new TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda15(context2, managedActivityResultLauncher, 0);
                                gapComposer2.updateRememberedValue(tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda15);
                                obj7 = tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda15;
                            } else {
                                z2 = false;
                                obj7 = objRememberedValue9;
                            }
                            Function0 function3 = (Function0) obj7;
                            gapComposer2.end(z2);
                            gapComposer2.startReplaceGroup(-789700407);
                            boolean zChangedInstance11 = gapComposer2.changedInstance(context2);
                            Object objRememberedValue10 = gapComposer2.rememberedValue();
                            Object obj19 = objRememberedValue10;
                            if (zChangedInstance11 || objRememberedValue10 == neverEqualPolicy) {
                                TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda2 tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda2 = new TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda2(context2, 7);
                                gapComposer2.updateRememberedValue(tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda2);
                                obj19 = tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda2;
                            }
                            Function0 function4 = (Function0) obj19;
                            Object objM7 = Density.CC.m(-789698172, gapComposer2, false);
                            Object obj20 = objM7;
                            if (objM7 == neverEqualPolicy) {
                                TooltipKt$$ExternalSyntheticLambda0 tooltipKt$$ExternalSyntheticLambda1 = new TooltipKt$$ExternalSyntheticLambda0(mutableState5, 25);
                                gapComposer2.updateRememberedValue(tooltipKt$$ExternalSyntheticLambda1);
                                obj20 = tooltipKt$$ExternalSyntheticLambda1;
                            }
                            gapComposer2.end(false);
                            float f = 0;
                            HomeScreenKt.HomeScreen(function2, function3, function4, (Function0) obj20, new PaddingValuesImpl(f, f, f, f), null, hazeState, true, gapComposer2, 12610566, 32);
                            gapComposer2.end(false);
                            Unit unit2 = Unit.INSTANCE;
                        } else if (intValue3 == 1) {
                            neverEqualPolicy = neverEqualPolicy3;
                            gapComposer2.startReplaceGroup(-789690419);
                            gapComposer2.startReplaceGroup(-789689085);
                            Object objRememberedValue11 = gapComposer2.rememberedValue();
                            if (objRememberedValue11 == neverEqualPolicy) {
                                obj11 = objRememberedValue11;
                                TooltipKt$$ExternalSyntheticLambda0 tooltipKt$$ExternalSyntheticLambda2 = new TooltipKt$$ExternalSyntheticLambda0(mutableState4, 22);
                                gapComposer2.updateRememberedValue(tooltipKt$$ExternalSyntheticLambda2);
                                obj11 = tooltipKt$$ExternalSyntheticLambda2;
                            }
                            obj11 = objRememberedValue11;
                            Function0 function5 = (Function0) obj11;
                            gapComposer2.end(false);
                            gapComposer2.startReplaceGroup(-789686790);
                            boolean zChangedInstance12 = gapComposer2.changedInstance(context2);
                            Object objRememberedValue12 = gapComposer2.rememberedValue();
                            Object obj21 = objRememberedValue12;
                            if (zChangedInstance12 || objRememberedValue12 == neverEqualPolicy) {
                                MainAppKt$$ExternalSyntheticLambda1 mainAppKt$$ExternalSyntheticLambda1 = new MainAppKt$$ExternalSyntheticLambda1(context2, 3);
                                gapComposer2.updateRememberedValue(mainAppKt$$ExternalSyntheticLambda1);
                                obj21 = mainAppKt$$ExternalSyntheticLambda1;
                            }
                            Function1 function6 = (Function1) obj21;
                            gapComposer2.end(false);
                            float f2 = 0;
                            zzit.ProfilesScreen(function5, function6, new PaddingValuesImpl(f2, f2, f2, f2), null, true, gapComposer2, 24966, 8);
                            gapComposer2.end(false);
                            Unit unit3 = Unit.INSTANCE;
                        } else if (intValue3 != 2) {
                            gapComposer2.startReplaceGroup(1290977015);
                            gapComposer2.end(false);
                            Unit unit4 = Unit.INSTANCE;
                            neverEqualPolicy = neverEqualPolicy3;
                        } else {
                            gapComposer2.startReplaceGroup(-789674497);
                            gapComposer2.startReplaceGroup(-789673701);
                            boolean zChangedInstance13 = gapComposer2.changedInstance(context2);
                            Object objRememberedValue13 = gapComposer2.rememberedValue();
                            if (zChangedInstance13) {
                                neverEqualPolicy2 = neverEqualPolicy3;
                            } else {
                                neverEqualPolicy2 = neverEqualPolicy3;
                                if (objRememberedValue13 != neverEqualPolicy2) {
                                    z5 = false;
                                    obj12 = objRememberedValue13;
                                }
                                Function0 function7 = (Function0) obj12;
                                gapComposer2.end(z5);
                                gapComposer2.startReplaceGroup(-789668641);
                                zChangedInstance4 = gapComposer2.changedInstance(context2);
                                Object objRememberedValue14 = gapComposer2.rememberedValue();
                                obj13 = objRememberedValue14;
                                if (zChangedInstance4 || objRememberedValue14 == neverEqualPolicy2) {
                                    TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda2 tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda3 = new TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda2(context2, 8);
                                    gapComposer2.updateRememberedValue(tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda3);
                                    obj13 = tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda3;
                                }
                                Function0 function8 = (Function0) obj13;
                                gapComposer2.end(false);
                                gapComposer2.startReplaceGroup(-789663589);
                                zChangedInstance5 = gapComposer2.changedInstance(context2);
                                Object objRememberedValue15 = gapComposer2.rememberedValue();
                                obj14 = objRememberedValue15;
                                if (zChangedInstance5 || objRememberedValue15 == neverEqualPolicy2) {
                                    TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda2 tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda4 = new TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda2(context2, 9);
                                    gapComposer2.updateRememberedValue(tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda4);
                                    obj14 = tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda4;
                                }
                                Function0 function9 = (Function0) obj14;
                                gapComposer2.end(false);
                                gapComposer2.startReplaceGroup(-789658680);
                                zChangedInstance6 = gapComposer2.changedInstance(context2);
                                Object objRememberedValue16 = gapComposer2.rememberedValue();
                                obj15 = objRememberedValue16;
                                if (zChangedInstance6 || objRememberedValue16 == neverEqualPolicy2) {
                                    TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda2 tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda5 = new TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda2(context2, i6);
                                    gapComposer2.updateRememberedValue(tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda5);
                                    obj15 = tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda5;
                                }
                                Function0 function10 = (Function0) obj15;
                                gapComposer2.end(false);
                                gapComposer2.startReplaceGroup(-789647463);
                                zChangedInstance7 = gapComposer2.changedInstance(context2);
                                Object objRememberedValue17 = gapComposer2.rememberedValue();
                                obj16 = objRememberedValue17;
                                if (zChangedInstance7 || objRememberedValue17 == neverEqualPolicy2) {
                                    TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda2 tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda6 = new TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda2(context2, 11);
                                    gapComposer2.updateRememberedValue(tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda6);
                                    obj16 = tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda6;
                                }
                                gapComposer2.end(false);
                                float f3 = 0;
                                neverEqualPolicy = neverEqualPolicy2;
                                zzje.SettingsScreen(function7, function8, function9, function10, (Function0) obj16, null, new PaddingValuesImpl(f3, f3, f3, f3), true, gapComposer2, 102236160, 160);
                                gapComposer2.end(false);
                                Unit unit5 = Unit.INSTANCE;
                            }
                            z5 = false;
                            TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda2 tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda7 = new TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda2(context2, false ? 1 : 0);
                            gapComposer2.updateRememberedValue(tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda7);
                            obj12 = tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda7;
                            Function0 function11 = (Function0) obj12;
                            gapComposer2.end(z5);
                            gapComposer2.startReplaceGroup(-789668641);
                            zChangedInstance4 = gapComposer2.changedInstance(context2);
                            Object objRememberedValue18 = gapComposer2.rememberedValue();
                            obj13 = objRememberedValue18;
                            if (zChangedInstance4) {
                                TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda2 tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda8 = new TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda2(context2, 8);
                                gapComposer2.updateRememberedValue(tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda8);
                                obj13 = tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda8;
                            } else {
                                TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda2 tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda9 = new TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda2(context2, 8);
                                gapComposer2.updateRememberedValue(tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda9);
                                obj13 = tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda9;
                            }
                            Function0 function12 = (Function0) obj13;
                            gapComposer2.end(false);
                            gapComposer2.startReplaceGroup(-789663589);
                            zChangedInstance5 = gapComposer2.changedInstance(context2);
                            Object objRememberedValue19 = gapComposer2.rememberedValue();
                            obj14 = objRememberedValue19;
                            if (zChangedInstance5) {
                                TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda2 tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda10 = new TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda2(context2, 9);
                                gapComposer2.updateRememberedValue(tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda10);
                                obj14 = tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda10;
                            } else {
                                TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda2 tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda11 = new TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda2(context2, 9);
                                gapComposer2.updateRememberedValue(tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda11);
                                obj14 = tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda11;
                            }
                            Function0 function13 = (Function0) obj14;
                            gapComposer2.end(false);
                            gapComposer2.startReplaceGroup(-789658680);
                            zChangedInstance6 = gapComposer2.changedInstance(context2);
                            Object objRememberedValue110 = gapComposer2.rememberedValue();
                            obj15 = objRememberedValue110;
                            if (zChangedInstance6) {
                                TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda2 tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda12 = new TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda2(context2, i6);
                                gapComposer2.updateRememberedValue(tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda12);
                                obj15 = tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda12;
                            } else {
                                TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda2 tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda13 = new TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda2(context2, i6);
                                gapComposer2.updateRememberedValue(tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda13);
                                obj15 = tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda13;
                            }
                            Function0 function14 = (Function0) obj15;
                            gapComposer2.end(false);
                            gapComposer2.startReplaceGroup(-789647463);
                            zChangedInstance7 = gapComposer2.changedInstance(context2);
                            Object objRememberedValue111 = gapComposer2.rememberedValue();
                            obj16 = objRememberedValue111;
                            if (zChangedInstance7) {
                                TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda2 tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda14 = new TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda2(context2, 11);
                                gapComposer2.updateRememberedValue(tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda14);
                                obj16 = tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda14;
                            } else {
                                TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda2 tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda16 = new TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda2(context2, 11);
                                gapComposer2.updateRememberedValue(tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda16);
                                obj16 = tvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda16;
                            }
                            gapComposer2.end(false);
                            float f4 = 0;
                            neverEqualPolicy = neverEqualPolicy2;
                            zzje.SettingsScreen(function11, function12, function13, function14, (Function0) obj16, null, new PaddingValuesImpl(f4, f4, f4, f4), true, gapComposer2, 102236160, 160);
                            gapComposer2.end(false);
                            Unit unit6 = Unit.INSTANCE;
                        }
                        gapComposer2.end(true);
                        gapComposer2.end(true);
                        gapComposer2.startReplaceGroup(-1493078880);
                        if (((Boolean) mutableState5.getValue()).booleanValue()) {
                            gapComposer2.startReplaceGroup(-1493076889);
                            Object objRememberedValue20 = gapComposer2.rememberedValue();
                            if (objRememberedValue20 == neverEqualPolicy) {
                                obj10 = objRememberedValue20;
                                TooltipKt$$ExternalSyntheticLambda0 tooltipKt$$ExternalSyntheticLambda3 = new TooltipKt$$ExternalSyntheticLambda0(mutableState5, 26);
                                gapComposer2.updateRememberedValue(tooltipKt$$ExternalSyntheticLambda3);
                                obj10 = tooltipKt$$ExternalSyntheticLambda3;
                            }
                            obj10 = objRememberedValue20;
                            z3 = false;
                            gapComposer2.end(false);
                            zziz.ProxySelectorSheet((Function0) obj10, true, gapComposer2, 54, 0);
                        } else {
                            z3 = false;
                        }
                        gapComposer2.end(z3);
                        gapComposer2.startReplaceGroup(-1493074724);
                        boolean zBooleanValue = ((Boolean) mutableState4.getValue()).booleanValue();
                        MutableState mutableState6 = mutableState3;
                        if (zBooleanValue) {
                            gapComposer2.startReplaceGroup(-1493072538);
                            Object objRememberedValue21 = gapComposer2.rememberedValue();
                            if (objRememberedValue21 == neverEqualPolicy) {
                                obj9 = objRememberedValue21;
                                TooltipKt$$ExternalSyntheticLambda0 tooltipKt$$ExternalSyntheticLambda4 = new TooltipKt$$ExternalSyntheticLambda0(mutableState4, 27);
                                gapComposer2.updateRememberedValue(tooltipKt$$ExternalSyntheticLambda4);
                                obj9 = tooltipKt$$ExternalSyntheticLambda4;
                            }
                            obj9 = objRememberedValue21;
                            Function0 function15 = (Function0) obj9;
                            z4 = false;
                            Object objM8 = Density.CC.m(-1493070564, gapComposer2, false);
                            Object obj22 = objM8;
                            if (objM8 == neverEqualPolicy) {
                                TooltipKt$$ExternalSyntheticLambda2 tooltipKt$$ExternalSyntheticLambda5 = new TooltipKt$$ExternalSyntheticLambda2(mutableState4, mutableState6, 2);
                                gapComposer2.updateRememberedValue(tooltipKt$$ExternalSyntheticLambda5);
                                obj22 = tooltipKt$$ExternalSyntheticLambda5;
                            }
                            gapComposer2.end(false);
                            TvQrCodeSheetKt.TvQrCodeSheet(function15, (Function0) obj22, gapComposer2, 54);
                        } else {
                            z4 = false;
                        }
                        gapComposer2.end(z4);
                        gapComposer2.startReplaceGroup(-1493065888);
                        if (((Boolean) mutableState6.getValue()).booleanValue()) {
                            gapComposer2.startReplaceGroup(-1493063729);
                            Object objRememberedValue22 = gapComposer2.rememberedValue();
                            if (objRememberedValue22 == neverEqualPolicy) {
                                obj8 = objRememberedValue22;
                                TooltipKt$$ExternalSyntheticLambda0 tooltipKt$$ExternalSyntheticLambda6 = new TooltipKt$$ExternalSyntheticLambda0(mutableState6, 23);
                                gapComposer2.updateRememberedValue(tooltipKt$$ExternalSyntheticLambda6);
                                obj8 = tooltipKt$$ExternalSyntheticLambda6;
                            }
                            obj8 = objRememberedValue22;
                            r4 = 0;
                            gapComposer2.end(false);
                            zzir.NewProfileSheet((Function0) obj8, gapComposer2, 6);
                        } else {
                            r4 = 0;
                        }
                        gapComposer2.end(r4);
                        GlassSnackbarKt.GlassSnackbarHost(snackbarHostState, flowRowOverflow.align(companion, Alignment.Companion.BottomCenter), gapComposer2, 6, r4);
                        gapComposer2.end(true);
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, 56);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new FilesKt__UtilsKt$$ExternalSyntheticLambda0(i, 2);
        }
    }
}
