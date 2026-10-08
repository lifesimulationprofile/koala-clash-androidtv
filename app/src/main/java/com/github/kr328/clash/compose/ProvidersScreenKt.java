package com.github.kr328.clash.compose;

import android.content.Context;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.material3.ButtonKt$$ExternalSyntheticLambda2;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.ThumbNode;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetModifier$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayout$1;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.TextStyle;
import coil.network.HttpException;
import com.github.kr328.clash.core.model.Provider;
import com.github.kr328.clash.design.compose.theme.AppColors;
import com.github.kr328.clash.design.compose.theme.AppColorsKt;
import com.google.android.gms.internal.mlkit_vision_common.zzjl;
import com.koala.clash.R;
import dev.chrisbanes.haze.HazeKt;
import dev.chrisbanes.haze.HazeState;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ProvidersScreenKt {

    /* JADX INFO: renamed from: com.github.kr328.clash.compose.ProvidersScreenKt$ProvidersScreen$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass3 implements Function3 {
        public final /* synthetic */ AppColors $colors;
        public final /* synthetic */ Object $hazeState;
        public final /* synthetic */ List $items;
        public final /* synthetic */ MutableState $now$delegate;
        public final /* synthetic */ Object $onUpdate;
        public final /* synthetic */ int $r8$classId = 0;

        public AnonymousClass3(AppColors appColors, HazeState hazeState, List list, Function1 function1, ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState) {
            this.$colors = appColors;
            this.$hazeState = hazeState;
            this.$items = list;
            this.$onUpdate = function1;
            this.$now$delegate = parcelableSnapshotMutableLongState;
        }

        /* JADX WARN: Code duplicated, block: B:26:0x008e  */
        /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r3v12 java.lang.Object, still in use, count: 2, list:
              (r3v12 java.lang.Object) from 0x006b: PHI (r3 I:??) = (r3v7 java.lang.Object), (r3v12 java.lang.Object) binds: [B:18:0x006a, B:59:0x006b] A[DONT_GENERATE, DONT_INLINE]
              (r3v12 java.lang.Object) from 0x0059: CHECK_CAST (com.github.kr328.clash.compose.connections.ProcessGroup) (r3v12 java.lang.Object)
            	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
            	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
            	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
            	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:132)
            	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:67)
            	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:50)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:96)
            	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
            	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:36)
            	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:44)
            	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
            */
        @Override // kotlin.jvm.functions.Function3
        public final java.lang.Object invoke(java.lang.Object r24, java.lang.Object r25, java.lang.Object r26) {
            /*
                Method dump skipped, instruction units count: 442
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.kr328.clash.compose.ProvidersScreenKt.AnonymousClass3.invoke(java.lang.Object, java.lang.Object, java.lang.Object):java.lang.Object");
        }

        public AnonymousClass3(List list, CoroutineScope coroutineScope, MutableState mutableState, AppColors appColors, MutableState mutableState2) {
            this.$items = list;
            this.$hazeState = coroutineScope;
            this.$onUpdate = mutableState;
            this.$colors = appColors;
            this.$now$delegate = mutableState2;
        }
    }

    public static final void ProviderRow(final ProviderItemState providerItemState, final long j, final Function0 function0, GapComposer gapComposer, int i) {
        gapComposer.startRestartGroup(-305844935);
        if ((((gapComposer.changedInstance(providerItemState) ? 4 : 2) | i | (gapComposer.changed(j) ? 32 : 16) | (gapComposer.changedInstance(function0) ? 256 : 128)) & 147) == 146 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            final AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            final Context context = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
            final boolean z = providerItemState.provider.vehicleType == Provider.VehicleType.Inline;
            zzjl.m819GlassSurfaceYxtnGt4(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), 12, null, Thread_jvmKt.rememberComposableLambda(889643958, new Function2() { // from class: com.github.kr328.clash.compose.ProvidersScreenKt.ProviderRow.1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    String string;
                    int i2;
                    String string2;
                    boolean z2;
                    boolean z3;
                    boolean z4;
                    String string3;
                    GapComposer gapComposer2 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                        float f = 12;
                        Modifier modifierM129paddingVpY3zN4 = OffsetKt.m129paddingVpY3zN4(SizeKt.fillMaxWidth(companion, 1.0f), 16, f);
                        RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.CenterVertically, gapComposer2, 48);
                        long j2 = gapComposer2.compositeKeyHashCode;
                        int i3 = (int) (j2 ^ (j2 >>> 32));
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
                        Stack.m295setimpl(gapComposer2, rowMeasurePolicy, composeUiNode$Companion$SetModifier$1);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                        Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, composeUiNode$Companion$SetModifier$2);
                        Integer numValueOf = Integer.valueOf(i3);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
                        Stack.m295setimpl(gapComposer2, numValueOf, composeUiNode$Companion$SetModifier$3);
                        OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
                        Stack.m294reconcileimpl(gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
                        Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
                        if (1.0f <= 0.0d) {
                            InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                        }
                        LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
                        ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, gapComposer2, 0);
                        long j3 = gapComposer2.compositeKeyHashCode;
                        int i4 = (int) (j3 ^ (j3 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer2, layoutWeightElement);
                        gapComposer2.startReusableNode();
                        if (gapComposer2.inserting) {
                            gapComposer2.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer2.useNode();
                        }
                        Stack.m295setimpl(gapComposer2, columnMeasurePolicy, composeUiNode$Companion$SetModifier$1);
                        Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
                        Modifier.CC.m(i4, gapComposer2, composeUiNode$Companion$SetModifier$3, gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
                        Stack.m295setimpl(gapComposer2, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
                        ProviderItemState providerItemState2 = providerItemState;
                        String str = providerItemState2.provider.name;
                        StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                        TextStyle textStyle = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.titleMedium;
                        AppColors appColors2 = appColors;
                        TextKt.m275TextNvy7gAk(str, null, appColors2.textPrimary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, textStyle, gapComposer2, 0, 0, 131066);
                        Provider provider = providerItemState2.provider;
                        int iOrdinal = provider.type.ordinal();
                        Context context2 = context;
                        if (iOrdinal == 0) {
                            string = context2.getString(R.string.proxy);
                        } else {
                            if (iOrdinal != 1) {
                                throw new HttpException();
                            }
                            string = context2.getString(R.string.rule);
                        }
                        int iOrdinal2 = provider.vehicleType.ordinal();
                        if (iOrdinal2 == 0) {
                            i2 = 2;
                            string2 = context2.getString(R.string.http);
                        } else if (iOrdinal2 != 1) {
                            i2 = 2;
                            if (iOrdinal2 == 2) {
                                string2 = context2.getString(R.string.inline);
                            } else {
                                if (iOrdinal2 != 3) {
                                    throw new HttpException();
                                }
                                string2 = context2.getString(R.string.compatible);
                            }
                        } else {
                            i2 = 2;
                            string2 = context2.getString(R.string.file);
                        }
                        Object[] objArr = new Object[i2];
                        objArr[0] = string;
                        objArr[1] = string2;
                        TextKt.m275TextNvy7gAk(context2.getString(R.string.format_provider_type, objArr), null, appColors2.textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.bodySmall, gapComposer2, 0, 0, 131066);
                        GapComposer gapComposer3 = gapComposer2;
                        gapComposer3.end(true);
                        gapComposer3.startReplaceGroup(742243278);
                        if (z) {
                            z2 = true;
                            z3 = false;
                        } else {
                            long j4 = j - providerItemState2.updatedAt;
                            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                            long days = timeUnit.toDays(j4);
                            long hours = timeUnit.toHours(j4);
                            long minutes = timeUnit.toMinutes(j4);
                            if (days > 0) {
                                z4 = false;
                                string3 = context2.getString(R.string.format_days_ago, Long.valueOf(days));
                            } else {
                                z4 = false;
                                if (hours > 0) {
                                    string3 = context2.getString(R.string.format_hours_ago, Long.valueOf(hours));
                                } else {
                                    string3 = minutes > 0 ? context2.getString(R.string.format_minutes_ago, Long.valueOf(minutes)) : context2.getString(R.string.recently);
                                }
                            }
                            z3 = z4;
                            TextKt.m275TextNvy7gAk(string3, null, appColors2.textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal)).typography.bodySmall, gapComposer3, 0, 0, 131066);
                            gapComposer3 = gapComposer3;
                            OffsetKt.Spacer(gapComposer3, SizeKt.m144width3ABfNKs(companion, f));
                            Modifier modifierM140size3ABfNKs = SizeKt.m140size3ABfNKs(companion, 40);
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, z3);
                            long j5 = gapComposer3.compositeKeyHashCode;
                            int i5 = (int) (j5 ^ (j5 >>> 32));
                            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope3 = gapComposer3.currentCompositionLocalScope();
                            Modifier modifierMaterializeModifier3 = AbsoluteAlignment.materializeModifier(gapComposer3, modifierM140size3ABfNKs);
                            gapComposer3.startReusableNode();
                            if (gapComposer3.inserting) {
                                gapComposer3.createNode(layoutNode$Companion$Constructor$1);
                            } else {
                                gapComposer3.useNode();
                            }
                            Stack.m295setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy, composeUiNode$Companion$SetModifier$1);
                            Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope3, composeUiNode$Companion$SetModifier$2);
                            Modifier.CC.m(i5, gapComposer3, composeUiNode$Companion$SetModifier$3, gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$1);
                            Stack.m295setimpl(gapComposer3, modifierMaterializeModifier3, composeUiNode$Companion$SetModifier$4);
                            if (providerItemState2.updating) {
                                gapComposer3.startReplaceGroup(1513669482);
                                ProgressIndicatorKt.m256CircularProgressIndicator4lLiAd8(SizeKt.m140size3ABfNKs(companion, 22), appColors2.buttonColor, 2, 0L, 0, 0.0f, gapComposer3, 390, 56);
                                gapComposer3 = gapComposer3;
                                gapComposer3.end(z3);
                            } else {
                                gapComposer3.startReplaceGroup(1513942127);
                                ScrimKt.IconButton(function0, null, false, null, null, Thread_jvmKt.rememberComposableLambda(1456718287, new LogsScreenKt.AnonymousClass6(appColors2, 18), gapComposer3), gapComposer3, 1572864, 62);
                                gapComposer3.end(z3);
                            }
                            z2 = true;
                            gapComposer3.end(true);
                        }
                        gapComposer3.end(z3);
                        gapComposer3.end(z2);
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, 196662, 28);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ButtonKt$$ExternalSyntheticLambda2(providerItemState, j, function0, i);
        }
    }

    public static final void ProvidersScreen(List list, Function1 function1, Function0 function0, Function0 function2, Modifier modifier, GapComposer gapComposer, int i) {
        Modifier modifier2;
        gapComposer.startRestartGroup(833826077);
        if (((i | (gapComposer.changedInstance(list) ? 4 : 2) | (gapComposer.changedInstance(function1) ? 32 : 16) | (gapComposer.changedInstance(function0) ? 256 : 128) | (gapComposer.changedInstance(function2) ? 2048 : 1024) | 24576) & 9363) == 9362 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
        } else {
            AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            HazeState hazeStateRememberHazeState = HazeKt.rememberHazeState(gapComposer);
            gapComposer.startReplaceGroup(-529480750);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new ParcelableSnapshotMutableLongState(System.currentTimeMillis());
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState = (ParcelableSnapshotMutableLongState) objRememberedValue;
            gapComposer.end(false);
            Unit unit = Unit.INSTANCE;
            gapComposer.startReplaceGroup(-529477946);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new ThumbNode.AnonymousClass1(parcelableSnapshotMutableLongState, (Continuation) null, 19);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            gapComposer.end(false);
            Stack.LaunchedEffect(gapComposer, unit, (Function2) objRememberedValue2);
            ScaffoldKt.m261ScaffoldTvnljyQ(ImageKt.m47backgroundbw27NRU(SizeKt.FillWholeMaxSize, appColors.appBackground, BrushKt.RectangleShape), Thread_jvmKt.rememberComposableLambda(1312023265, new FilesScreenKt.AnonymousClass2(hazeStateRememberHazeState, appColors, function2, list, function0), gapComposer), null, null, null, 0, appColors.appBackground, 0L, null, Thread_jvmKt.rememberComposableLambda(418248812, new AnonymousClass3(appColors, hazeStateRememberHazeState, list, function1, parcelableSnapshotMutableLongState), gapComposer), gapComposer, 805306416, 444);
            modifier2 = Modifier.Companion.$$INSTANCE;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ProvidersScreenKt$$ExternalSyntheticLambda0(list, function1, function0, function2, modifier2, i);
        }
    }
}
