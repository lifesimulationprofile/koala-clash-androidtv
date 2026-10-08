package com.github.kr328.clash.compose.connections;

import androidx.activity.compose.BackHandlerKt;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.MutatorMutex$mutateWith$2;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda3;
import androidx.compose.foundation.layout.FlowRowOverflow;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope$CC;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.foundation.shape.DpCornerSize;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.AndroidCursorHandle_androidKt$$ExternalSyntheticLambda1;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.SheetState;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda0;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda7;
import androidx.compose.material3.TopAppBarColors;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.material3.internal.BasicTooltipKt$$ExternalSyntheticLambda7;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt$RectangleShape$1;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetModifier$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayout$1;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Density;
import androidx.core.view.MenuHostHelper;
import androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda1;
import coil.compose.AsyncImagePainter$$ExternalSyntheticLambda0;
import com.github.kr328.clash.FilesActivity$$ExternalSyntheticLambda16;
import com.github.kr328.clash.LogcatActivity$$ExternalSyntheticLambda10;
import com.github.kr328.clash.compose.FilesScreenKt;
import com.github.kr328.clash.compose.FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2;
import com.github.kr328.clash.compose.LogsScreenKt;
import com.github.kr328.clash.compose.MainAppKt$MainApp$2$3$1$1$1$2;
import com.github.kr328.clash.compose.ProvidersScreenKt;
import com.github.kr328.clash.compose.proxy.ProxyScreenKt$$ExternalSyntheticLambda2;
import com.github.kr328.clash.compose.settings.SettingsScreenKt$$ExternalSyntheticLambda6;
import com.github.kr328.clash.compose.util.TvGlassTabRowKt$$ExternalSyntheticLambda8;
import com.github.kr328.clash.core.model.ConnectionInfo;
import com.github.kr328.clash.core.model.ConnectionMetadata;
import com.github.kr328.clash.design.compose.theme.AppColors;
import com.github.kr328.clash.design.compose.theme.AppColorsKt;
import com.github.kr328.clash.remote.Remote;
import com.google.android.gms.internal.mlkit_vision_common.zzjl;
import com.koala.clash.R;
import dev.chrisbanes.haze.HazeEffectNodeElement;
import dev.chrisbanes.haze.HazeKt;
import dev.chrisbanes.haze.HazeSourceElement;
import dev.chrisbanes.haze.HazeState;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.JsonImpl;
import kotlinx.serialization.json.JsonKt;
import okio.Okio;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ConnectionsScreenKt {
    public static final JsonImpl connectionJson = JsonKt.Json$default(new AsyncImagePainter$$ExternalSyntheticLambda0(12));
    public static final DateTimeFormatter timeFormatter;

    static {
        Locale locale = Locale.US;
        timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.US);
    }

    public static final void ConnectionCard(final ConnectionInfo connectionInfo, boolean z, final Function0 function0, GapComposer gapComposer, int i) {
        final boolean z2;
        gapComposer.startRestartGroup(22430553);
        if ((((gapComposer.changedInstance(connectionInfo) ? 4 : 2) | i | (gapComposer.changedInstance(function0) ? 256 : 128)) & 147) == 146 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
            z2 = z;
        } else {
            final AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            final String strDisplayHost = displayHost(connectionInfo.metadata);
            ConnectionMetadata connectionMetadata = connectionInfo.metadata;
            final String str = connectionMetadata.destinationPort;
            final String upperCase = connectionMetadata.network.toUpperCase(Locale.ROOT);
            final long j = upperCase.equals("UDP") ? appColors.networkUdp : appColors.networkTcp;
            final State stateM26animateColorAsStateeuL9pac = SingleValueAnimationKt.m26animateColorAsStateeuL9pac(z ? appColors.statusActive : appColors.statusClosed, ArcSplineKt.tween$default(300, 6, null), "statusColor", gapComposer, 432, 8);
            z2 = z;
            zzjl.m819GlassSurfaceYxtnGt4(null, 12, null, Thread_jvmKt.rememberComposableLambda(-1238190468, new Function2() { // from class: com.github.kr328.clash.compose.connections.ConnectionsScreenKt.ConnectionCard.1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ConnectionInfo connectionInfo2;
                    AppColors appColors2;
                    boolean z3;
                    GapComposer gapComposer2 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                        Modifier modifierM129paddingVpY3zN4 = OffsetKt.m129paddingVpY3zN4(ImageKt.m51clickableoSLSa3U$default(SizeKt.fillMaxWidth(companion, 1.0f), false, null, function0, 15), 14, 12);
                        ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, gapComposer2, 0);
                        MenuHostHelper menuHostHelper = gapComposer2.applier;
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
                        BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                        Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                        FlowRowOverflow flowRowOverflow = Arrangement.Start;
                        RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(flowRowOverflow, vertical, gapComposer2, 48);
                        long j3 = gapComposer2.compositeKeyHashCode;
                        int i3 = (int) (j3 ^ (j3 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer2, modifierFillMaxWidth);
                        gapComposer2.startReusableNode();
                        if (gapComposer2.inserting) {
                            gapComposer2.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer2.useNode();
                        }
                        Stack.m295setimpl(gapComposer2, rowMeasurePolicy, composeUiNode$Companion$SetModifier$1);
                        Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
                        Modifier.CC.m(i3, gapComposer2, composeUiNode$Companion$SetModifier$3, gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
                        Stack.m295setimpl(gapComposer2, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
                        ConnectionsScreenKt.m808StatusDotek8zF_U(((Color) stateM26animateColorAsStateeuL9pac.getValue()).value, gapComposer2, 0);
                        float f = 8;
                        OffsetKt.Spacer(gapComposer2, SizeKt.m144width3ABfNKs(companion, f));
                        String str2 = str;
                        int length = str2.length();
                        String strM = strDisplayHost;
                        if (length > 0 && !str2.equals("0")) {
                            strM = ImageAnalysis$$ExternalSyntheticLambda1.m(strM, ":", str2);
                        }
                        StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                        TextStyle textStyle = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.bodyMedium;
                        AppColors appColors3 = appColors;
                        long j4 = appColors3.textPrimary;
                        FontWeight fontWeight = FontWeight.Medium;
                        if (1.0f <= 0.0d) {
                            InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                        }
                        TextKt.m275TextNvy7gAk(strM, new LayoutWeightElement(1.0f, true), j4, 0L, null, fontWeight, 0L, null, 0L, 2, false, 1, 0, textStyle, gapComposer2, 1572864, 24960, 110520);
                        GapComposer gapComposer3 = gapComposer2;
                        Modifier.Companion companion2 = companion;
                        OffsetKt.Spacer(gapComposer3, SizeKt.m144width3ABfNKs(companion2, f));
                        ConnectionsScreenKt.m804NetworkBadgeRPmYEkk(upperCase, j, gapComposer3, 0);
                        gapComposer3.end(true);
                        OffsetKt.Spacer(gapComposer3, SizeKt.m135height3ABfNKs(companion2, 4));
                        Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion2, 1.0f);
                        RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(flowRowOverflow, vertical, gapComposer3, 48);
                        long j5 = gapComposer3.compositeKeyHashCode;
                        int i4 = (int) (j5 ^ (j5 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope3 = gapComposer3.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier3 = AbsoluteAlignment.materializeModifier(gapComposer3, modifierFillMaxWidth2);
                        gapComposer3.startReusableNode();
                        if (gapComposer3.inserting) {
                            gapComposer3.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer3.useNode();
                        }
                        Stack.m295setimpl(gapComposer3, rowMeasurePolicy2, composeUiNode$Companion$SetModifier$1);
                        Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope3, composeUiNode$Companion$SetModifier$2);
                        Modifier.CC.m(i4, gapComposer3, composeUiNode$Companion$SetModifier$3, gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$1);
                        Stack.m295setimpl(gapComposer3, modifierMaterializeModifier3, composeUiNode$Companion$SetModifier$4);
                        gapComposer3.startReplaceGroup(-1283610782);
                        ConnectionInfo connectionInfo3 = connectionInfo;
                        if (connectionInfo3.rule.length() > 0) {
                            connectionInfo2 = connectionInfo3;
                            appColors2 = appColors3;
                            TextKt.m275TextNvy7gAk(connectionInfo3.rule, null, appColors3.textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 1, 0, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal)).typography.labelSmall, gapComposer3, 0, 24576, 114682);
                            gapComposer3 = gapComposer3;
                            companion2 = companion2;
                            OffsetKt.Spacer(gapComposer3, SizeKt.m144width3ABfNKs(companion2, f));
                            z3 = false;
                        } else {
                            connectionInfo2 = connectionInfo3;
                            appColors2 = appColors3;
                            z3 = false;
                        }
                        gapComposer3.end(z3);
                        if (1.0f <= 0.0d) {
                            InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                        }
                        OffsetKt.Spacer(gapComposer3, new LayoutWeightElement(1.0f, true));
                        ConnectionInfo connectionInfo4 = connectionInfo2;
                        AppColors appColors4 = appColors2;
                        Modifier.Companion companion3 = companion2;
                        GapComposer gapComposer4 = gapComposer3;
                        TextKt.m275TextNvy7gAk(CaptureSession$State$EnumUnboxingLocalUtility.m("↑", ConnectionsScreenKt.access$formatBytes(connectionInfo4.upload)), null, appColors4.textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal)).typography.labelSmall, gapComposer4, 0, 0, 131066);
                        OffsetKt.Spacer(gapComposer4, SizeKt.m144width3ABfNKs(companion3, f));
                        TextKt.m275TextNvy7gAk(CaptureSession$State$EnumUnboxingLocalUtility.m("↓", ConnectionsScreenKt.access$formatBytes(connectionInfo4.download)), null, appColors4.textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer4.consume(staticProvidableCompositionLocal)).typography.labelSmall, gapComposer4, 0, 0, 131066);
                        GapComposer gapComposer5 = gapComposer4;
                        gapComposer5.startReplaceGroup(-1283581656);
                        if (z2) {
                            long jAccess$parseStartTime = ConnectionsScreenKt.access$parseStartTime(connectionInfo4.start);
                            if (jAccess$parseStartTime > 0) {
                                OffsetKt.Spacer(gapComposer5, SizeKt.m144width3ABfNKs(companion3, f));
                                TextKt.m275TextNvy7gAk(ConnectionsScreenKt.access$formatDuration(jAccess$parseStartTime), null, appColors4.textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal)).typography.labelSmall, gapComposer5, 0, 0, 131066);
                                gapComposer5 = gapComposer5;
                            }
                        }
                        gapComposer5.end(false);
                        gapComposer5.end(true);
                        gapComposer5.end(true);
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, 196656, 29);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new LogcatActivity$$ExternalSyntheticLambda10(connectionInfo, z2, function0, i);
        }
    }

    public static final void ConnectionDetailSheet(ConnectionInfo connectionInfo, boolean z, Function0 function0, Function0 function1, GapComposer gapComposer, int i) {
        gapComposer.startRestartGroup(2069784319);
        if (((i | (gapComposer.changedInstance(connectionInfo) ? 4 : 2) | (gapComposer.changed(z) ? 32 : 16) | (gapComposer.changedInstance(function0) ? 256 : 128)) & 1171) == 1170 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            ConnectionMetadata connectionMetadata = connectionInfo.metadata;
            SheetState sheetStateRememberModalBottomSheetState = ScrimKt.rememberModalBottomSheetState(null, gapComposer, 6, 2);
            long j = appColors.appBackground;
            float f = 20;
            float f2 = 0;
            RoundedCornerShape roundedCornerShape = RoundedCornerShapeKt.CircleShape;
            ScrimKt.m265ModalBottomSheetYbuCTN8(function1, null, sheetStateRememberModalBottomSheetState, 0.0f, false, new RoundedCornerShape(new DpCornerSize(f), new DpCornerSize(f), new DpCornerSize(f2), new DpCornerSize(f2)), j, 0L, 0.0f, 0L, null, null, null, Thread_jvmKt.rememberComposableLambda(651102817, new FilesScreenKt.C00202(connectionMetadata, appColors, connectionInfo, z, function0), gapComposer), gapComposer, 6, 3072, 8090);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ProxyScreenKt$$ExternalSyntheticLambda2(connectionInfo, z, function0, function1, i, 1);
        }
    }

    public static final void ConnectionListContent(List list, List list2, Function2 function2, PaddingValues paddingValues, boolean z, HazeState hazeState, GapComposer gapComposer, int i) {
        PaddingValuesImpl paddingValuesImpl;
        gapComposer.startRestartGroup(1269024318);
        if (((i | (gapComposer.changedInstance(list) ? 4 : 2) | (gapComposer.changedInstance(list2) ? 32 : 16) | (gapComposer.changed(paddingValues) ? 2048 : 1024) | (gapComposer.changed(z) ? 16384 : 8192) | (gapComposer.changed(hazeState) ? 131072 : 65536)) & 74899) == 74898 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            FillElement fillElement = SizeKt.FillWholeMaxSize;
            Modifier modifierThen = Modifier.Companion.$$INSTANCE;
            if (!z) {
                modifierThen = modifierThen.then(new HazeSourceElement(hazeState));
            }
            Modifier modifierThen2 = fillElement.then(modifierThen);
            if (z) {
                float f = 16;
                paddingValuesImpl = new PaddingValuesImpl(f, paddingValues.mo120calculateTopPaddingD9Ej5fM(), f, paddingValues.mo117calculateBottomPaddingD9Ej5fM());
            } else {
                float f2 = 16;
                paddingValuesImpl = new PaddingValuesImpl(f2, paddingValues.mo120calculateTopPaddingD9Ej5fM() + 8, f2, f2);
            }
            PaddingValuesImpl paddingValuesImpl2 = paddingValuesImpl;
            Arrangement.SpacedAligned spacedAlignedM111spacedBy0680j_4 = Arrangement.m111spacedBy0680j_4(8);
            gapComposer.startReplaceGroup(1943949785);
            boolean zChangedInstance = gapComposer.changedInstance(list) | gapComposer.changedInstance(list2);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer$Companion.Empty) {
                objRememberedValue = new LifecycleEffectKt$$ExternalSyntheticLambda1(list, list2, function2, 20);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            gapComposer.end(false);
            LazyDslKt.LazyColumn(modifierThen2, null, paddingValuesImpl2, false, spacedAlignedM111spacedBy0680j_4, null, null, false, null, (Function1) objRememberedValue, gapComposer, 24576, 490);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TvGlassTabRowKt$$ExternalSyntheticLambda8(list, list2, function2, paddingValues, z, hazeState, i);
        }
    }

    public static final void ConnectionsScreen(int i, GapComposer gapComposer, Modifier modifier, final Function0 function0, final boolean z) {
        ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState;
        final MutableState mutableState;
        Modifier modifier2;
        MutableState mutableState2;
        gapComposer.startRestartGroup(-491516523);
        if (((i | (gapComposer.changedInstance(function0) ? 4 : 2) | 48 | (gapComposer.changed(z) ? 256 : 128)) & 147) == 146 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
        } else {
            final AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            Object objRememberedValue = gapComposer.rememberedValue();
            Object obj = Composer$Companion.Empty;
            if (objRememberedValue == obj) {
                objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            final HazeState hazeStateRememberHazeState = HazeKt.rememberHazeState(gapComposer);
            gapComposer.startReplaceGroup(-26350833);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            EmptyList emptyList = EmptyList.INSTANCE;
            if (objRememberedValue2 == obj) {
                objRememberedValue2 = Stack.mutableStateOf$default(emptyList);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState3 = (MutableState) objRememberedValue2;
            Object objM = Density.CC.m(-26347889, gapComposer, false);
            if (objM == obj) {
                objM = Stack.mutableStateOf$default(emptyList);
                gapComposer.updateRememberedValue(objM);
            }
            final MutableState mutableState4 = (MutableState) objM;
            Object objM2 = Density.CC.m(-26345164, gapComposer, false);
            if (objM2 == obj) {
                objM2 = new ParcelableSnapshotMutableLongState(0L);
                gapComposer.updateRememberedValue(objM2);
            }
            ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState2 = (ParcelableSnapshotMutableLongState) objM2;
            Object objM3 = Density.CC.m(-26343212, gapComposer, false);
            if (objM3 == obj) {
                objM3 = new ParcelableSnapshotMutableLongState(0L);
                gapComposer.updateRememberedValue(objM3);
            }
            final ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState3 = (ParcelableSnapshotMutableLongState) objM3;
            Object objM4 = Density.CC.m(-26341268, gapComposer, false);
            if (objM4 == obj) {
                objM4 = Stack.mutableStateOf$default(Boolean.valueOf(Remote.broadcasts.closed));
                gapComposer.updateRememberedValue(objM4);
            }
            MutableState mutableState5 = (MutableState) objM4;
            Object objM5 = Density.CC.m(-26338574, gapComposer, false);
            if (objM5 == obj) {
                objM5 = Stack.mutableStateOf$default(Boolean.TRUE);
                gapComposer.updateRememberedValue(objM5);
            }
            final MutableState mutableState6 = (MutableState) objM5;
            Object objM6 = Density.CC.m(-26336581, gapComposer, false);
            if (objM6 == obj) {
                objM6 = Stack.mutableStateOf$default(null);
                gapComposer.updateRememberedValue(objM6);
            }
            final MutableState mutableState7 = (MutableState) objM6;
            Object objM7 = Density.CC.m(-26334237, gapComposer, false);
            if (objM7 == obj) {
                objM7 = Stack.mutableStateOf$default(null);
                gapComposer.updateRememberedValue(objM7);
            }
            final MutableState mutableState8 = (MutableState) objM7;
            Object objM8 = Density.CC.m(-26331725, gapComposer, false);
            if (objM8 == obj) {
                objM8 = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objM8);
            }
            final MutableState mutableState9 = (MutableState) objM8;
            gapComposer.end(false);
            boolean z2 = ((String) mutableState7.getValue()) != null;
            gapComposer.startReplaceGroup(-26328937);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (objRememberedValue3 == obj) {
                objRememberedValue3 = new TooltipKt$$ExternalSyntheticLambda0(mutableState7, 29);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            gapComposer.end(false);
            BackHandlerKt.BackHandler(z2, (Function0) objRememberedValue3, gapComposer, 48);
            gapComposer.startReplaceGroup(-26326812);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (objRememberedValue4 == obj) {
                objRememberedValue4 = new LinkedHashMap();
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            Map map = (Map) objRememberedValue4;
            gapComposer.end(false);
            Unit unit = Unit.INSTANCE;
            gapComposer.startReplaceGroup(-26323656);
            Object objRememberedValue5 = gapComposer.rememberedValue();
            if (objRememberedValue5 == obj) {
                objRememberedValue5 = new TooltipKt$$ExternalSyntheticLambda7(mutableState5, 16);
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            gapComposer.end(false);
            Stack.DisposableEffect(unit, (Function1) objRememberedValue5, gapComposer);
            Boolean bool = (Boolean) mutableState5.getValue();
            bool.getClass();
            gapComposer.startReplaceGroup(-26300598);
            boolean zChangedInstance = gapComposer.changedInstance(map);
            Object objRememberedValue6 = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue6 == obj) {
                parcelableSnapshotMutableLongState = parcelableSnapshotMutableLongState2;
                Object mutatorMutex$mutateWith$2 = new MutatorMutex$mutateWith$2(map, mutableState5, mutableState3, mutableState6, mutableState4, parcelableSnapshotMutableLongState, parcelableSnapshotMutableLongState3, null);
                mutableState = mutableState5;
                mutableState3 = mutableState3;
                mutableState4 = mutableState4;
                objRememberedValue6 = mutatorMutex$mutateWith$2;
                parcelableSnapshotMutableLongState3 = parcelableSnapshotMutableLongState3;
                gapComposer.updateRememberedValue(objRememberedValue6);
            } else {
                mutableState = mutableState5;
                parcelableSnapshotMutableLongState = parcelableSnapshotMutableLongState2;
            }
            gapComposer.end(false);
            Stack.LaunchedEffect(gapComposer, bool, (Function2) objRememberedValue6);
            Object obj2 = (List) mutableState3.getValue();
            Object obj3 = (List) mutableState4.getValue();
            gapComposer.startReplaceGroup(-26240884);
            boolean zChanged = gapComposer.changed(obj2) | gapComposer.changed(obj3);
            Object objRememberedValue7 = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue7 == obj) {
                List list = (List) mutableState3.getValue();
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((ConnectionInfo) it.next()).metadata.process);
                }
                List list2 = (List) mutableState4.getValue();
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(((ConnectionInfo) it2.next()).metadata.process);
                }
                List list3 = CollectionsKt.toList(CollectionsKt.toMutableSet(CollectionsKt.plus((Collection) arrayList, (List) arrayList2)));
                ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10));
                Iterator it3 = list3.iterator();
                while (it3.hasNext()) {
                    String str = (String) it3.next();
                    List list4 = (List) mutableState3.getValue();
                    ArrayList arrayList4 = new ArrayList();
                    for (Object obj4 : list4) {
                        Iterator it4 = it3;
                        if (Intrinsics.areEqual(((ConnectionInfo) obj4).metadata.process, str)) {
                            arrayList4.add(obj4);
                        }
                        it3 = it4;
                    }
                    Iterator it5 = it3;
                    List list5 = (List) mutableState4.getValue();
                    ArrayList arrayList5 = new ArrayList();
                    Iterator it6 = list5.iterator();
                    while (it6.hasNext()) {
                        Object next = it6.next();
                        Iterator it7 = it6;
                        if (Intrinsics.areEqual(((ConnectionInfo) next).metadata.process, str)) {
                            arrayList5.add(next);
                        }
                        it6 = it7;
                    }
                    arrayList3.add(new ProcessGroup(str, arrayList4, arrayList5));
                    it3 = it5;
                }
                objRememberedValue7 = CollectionsKt.sortedWith(arrayList3, new ConnectionsScreenKt$ConnectionsScreen$lambda$41$$inlined$sortedByDescending$1());
                gapComposer.updateRememberedValue(objRememberedValue7);
            }
            final List list6 = (List) objRememberedValue7;
            gapComposer.end(false);
            final MutableState mutableState10 = mutableState3;
            final ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState4 = parcelableSnapshotMutableLongState;
            ScaffoldKt.m261ScaffoldTvnljyQ(ImageKt.m47backgroundbw27NRU(SizeKt.FillWholeMaxSize, appColors.appBackground, BrushKt.RectangleShape), Thread_jvmKt.rememberComposableLambda(-198996143, new Function2() { // from class: com.github.kr328.clash.compose.connections.ConnectionsScreenKt.ConnectionsScreen.4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj5, Object obj6) {
                    GapComposer gapComposer2 = (GapComposer) obj5;
                    int iIntValue = ((Number) obj6).intValue();
                    AppColors appColors2 = appColors;
                    long j = appColors2.appBackground;
                    if ((iIntValue & 3) == 2 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        gapComposer2.startReplaceGroup(-1735849012);
                        Modifier modifierThen = Modifier.Companion.$$INSTANCE;
                        boolean z3 = z;
                        if (!z3) {
                            modifierThen = modifierThen.then(new HazeEffectNodeElement(hazeStateRememberHazeState, BackHandlerKt.m6thinIv8Zu3U(gapComposer2)));
                        }
                        Modifier modifier3 = modifierThen;
                        gapComposer2.end(false);
                        PaddingValuesImpl paddingValuesImpl = TopAppBarDefaults.ContentPadding;
                        long j2 = z3 ? j : Color.Transparent;
                        if (!z3) {
                            j = Color.Transparent;
                        }
                        TopAppBarColors topAppBarColorsM278topAppBarColors5tl4gsc = TopAppBarDefaults.m278topAppBarColors5tl4gsc(j2, j, 0L, 0L, 0L, gapComposer2, 60);
                        MutableState mutableState11 = mutableState7;
                        int i2 = 1;
                        AppBarKt.m238TopAppBargNPyAyM(Thread_jvmKt.rememberComposableLambda(146742037, new LogsScreenKt.AnonymousClass5(appColors2, mutableState11, i2), gapComposer2), modifier3, Thread_jvmKt.rememberComposableLambda(138743063, new LogsScreenKt.AnonymousClass4(function0, mutableState11, appColors2, i2), gapComposer2), Thread_jvmKt.rememberComposableLambda(-75585088, new ProvidersScreenKt.AnonymousClass3(list6, coroutineScope, mutableState11, appColors2, mutableState10), gapComposer2), 0.0f, null, topAppBarColorsM278topAppBarColors5tl4gsc, null, gapComposer2, 3462, 432);
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), null, null, null, 0, appColors.appBackground, 0L, null, Thread_jvmKt.rememberComposableLambda(-1336206234, new Function3() { // from class: com.github.kr328.clash.compose.connections.ConnectionsScreenKt.ConnectionsScreen.5
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj5, Object obj6, Object obj7) {
                    final PaddingValues paddingValues = (PaddingValues) obj5;
                    GapComposer gapComposer2 = (GapComposer) obj6;
                    int iIntValue = ((Number) obj7).intValue();
                    if ((iIntValue & 6) == 0) {
                        iIntValue |= gapComposer2.changed(paddingValues) ? 4 : 2;
                    }
                    if ((iIntValue & 19) == 18 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        final MutableState mutableState11 = mutableState7;
                        String str2 = (String) mutableState11.getValue();
                        gapComposer2.startReplaceGroup(-1735742651);
                        Object objRememberedValue8 = gapComposer2.rememberedValue();
                        if (objRememberedValue8 == Composer$Companion.Empty) {
                            objRememberedValue8 = new AsyncImagePainter$$ExternalSyntheticLambda0(16);
                            gapComposer2.updateRememberedValue(objRememberedValue8);
                        }
                        gapComposer2.end(false);
                        final MutableState mutableState12 = mutableState8;
                        final MutableState mutableState13 = mutableState9;
                        final List list7 = list6;
                        final boolean z3 = z;
                        final HazeState hazeState = hazeStateRememberHazeState;
                        final ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState5 = parcelableSnapshotMutableLongState4;
                        final ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState6 = parcelableSnapshotMutableLongState3;
                        final MutableState mutableState14 = mutableState3;
                        final MutableState mutableState15 = mutableState4;
                        final MutableState mutableState16 = mutableState6;
                        final MutableState mutableState17 = mutableState;
                        AnimatedContentKt.AnimatedContent(str2, null, (Function1) objRememberedValue8, null, "nav", null, Thread_jvmKt.rememberComposableLambda(-1311549808, new Function4() { // from class: com.github.kr328.clash.compose.connections.ConnectionsScreenKt.ConnectionsScreen.5.2
                            @Override // kotlin.jvm.functions.Function4
                            public final Object invoke(Object obj8, Object obj9, Object obj10, Object obj11) {
                                Object next2;
                                String str3 = (String) obj9;
                                GapComposer gapComposer3 = (GapComposer) obj10;
                                ((Number) obj11).intValue();
                                HazeState hazeState2 = hazeState;
                                NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
                                if (str3 == null) {
                                    gapComposer3.startReplaceGroup(-1191548685);
                                    JsonImpl jsonImpl = ConnectionsScreenKt.connectionJson;
                                    long longValue = parcelableSnapshotMutableLongState5.getLongValue();
                                    long longValue2 = parcelableSnapshotMutableLongState6.getLongValue();
                                    int size = ((List) mutableState14.getValue()).size();
                                    int size2 = ((List) mutableState15.getValue()).size();
                                    boolean z4 = ((Boolean) mutableState16.getValue()).booleanValue() && ((Boolean) mutableState17.getValue()).booleanValue();
                                    gapComposer3.startReplaceGroup(1485595975);
                                    Object objRememberedValue9 = gapComposer3.rememberedValue();
                                    if (objRememberedValue9 == neverEqualPolicy) {
                                        objRememberedValue9 = new TooltipKt$$ExternalSyntheticLambda7(mutableState11, 17);
                                        gapComposer3.updateRememberedValue(objRememberedValue9);
                                    }
                                    gapComposer3.end(false);
                                    ConnectionsScreenKt.ProcessListContent(list7, longValue, longValue2, size, size2, z4, (Function1) objRememberedValue9, paddingValues, z3, hazeState2, gapComposer3, 1572864);
                                    gapComposer3.end(false);
                                } else {
                                    gapComposer3.startReplaceGroup(-1190970132);
                                    Iterator it8 = list7.iterator();
                                    do {
                                        if (!it8.hasNext()) {
                                            next2 = null;
                                            break;
                                        }
                                        next2 = it8.next();
                                    } while (!Intrinsics.areEqual(((ProcessGroup) next2).process, str3));
                                    ProcessGroup processGroup = (ProcessGroup) next2;
                                    List list8 = EmptyList.INSTANCE;
                                    List list9 = processGroup != null ? processGroup.activeConnections : list8;
                                    if (processGroup != null) {
                                        list8 = processGroup.closedConnections;
                                    }
                                    gapComposer3.startReplaceGroup(1485612158);
                                    Object objRememberedValue10 = gapComposer3.rememberedValue();
                                    if (objRememberedValue10 == neverEqualPolicy) {
                                        objRememberedValue10 = new TextKt$$ExternalSyntheticLambda2(24, mutableState12, mutableState13);
                                        gapComposer3.updateRememberedValue(objRememberedValue10);
                                    }
                                    gapComposer3.end(false);
                                    ConnectionsScreenKt.ConnectionListContent(list9, list8, (Function2) objRememberedValue10, paddingValues, z3, hazeState2, gapComposer3, 384);
                                    gapComposer3.end(false);
                                }
                                return Unit.INSTANCE;
                            }
                        }, gapComposer2), gapComposer2, 1597824, 42);
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, 805306416, 444);
            ConnectionInfo connectionInfo = (ConnectionInfo) mutableState8.getValue();
            if (connectionInfo != null) {
                boolean zBooleanValue = ((Boolean) mutableState9.getValue()).booleanValue();
                gapComposer.startReplaceGroup(-1735682651);
                boolean zChangedInstance2 = gapComposer.changedInstance(coroutineScope) | gapComposer.changedInstance(connectionInfo);
                Object objRememberedValue8 = gapComposer.rememberedValue();
                if (zChangedInstance2 || objRememberedValue8 == obj) {
                    mutableState2 = mutableState8;
                    objRememberedValue8 = new GapComposer$$ExternalSyntheticLambda0(coroutineScope, connectionInfo, mutableState2, 11);
                    gapComposer.updateRememberedValue(objRememberedValue8);
                } else {
                    mutableState2 = mutableState8;
                }
                Function0 function1 = (Function0) objRememberedValue8;
                Object objM9 = Density.CC.m(-1735676179, gapComposer, false);
                if (objM9 == obj) {
                    objM9 = new TooltipKt$$ExternalSyntheticLambda0(mutableState2, 28);
                    gapComposer.updateRememberedValue(objM9);
                }
                gapComposer.end(false);
                ConnectionDetailSheet(connectionInfo, zBooleanValue, function1, (Function0) objM9, gapComposer, 3072);
                Unit unit2 = Unit.INSTANCE;
            }
            modifier2 = Modifier.Companion.$$INSTANCE;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new SettingsScreenKt$$ExternalSyntheticLambda6(function0, modifier2, z, i);
        }
    }

    public static final void DetailRow(String str, String str2, GapComposer gapComposer, int i) {
        int i2;
        String str3;
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(-537618056);
        if ((i & 6) == 0) {
            i2 = i | (gapComposer2.changed(str) ? 4 : 2);
        } else {
            i2 = i;
        }
        int i3 = i2 | (gapComposer2.changed(str2) ? 32 : 16);
        if ((i3 & 19) == 18 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
            str3 = str2;
        } else {
            AppColors appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierM130paddingVpY3zN4$default = OffsetKt.m130paddingVpY3zN4$default(SizeKt.fillMaxWidth(companion, 1.0f), 0.0f, 4, 1);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.Top, gapComposer2, 48);
            long j = gapComposer2.compositeKeyHashCode;
            int i4 = (int) (j ^ (j >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierM130paddingVpY3zN4$default);
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
            Stack.m295setimpl(gapComposer2, Integer.valueOf(i4), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m294reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
            TextKt.m275TextNvy7gAk(str, SizeKt.m144width3ABfNKs(companion, 110), appColors.textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.bodySmall, gapComposer, (i3 & 14) | 48, 0, 131064);
            TextStyle textStyle = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.bodySmall;
            long j2 = appColors.textPrimary;
            FontWeight fontWeight = FontWeight.Medium;
            if (1.0f <= 0.0d) {
                InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
            }
            str3 = str2;
            TextKt.m275TextNvy7gAk(str3, new LayoutWeightElement(1.0f, true), j2, 0L, null, fontWeight, 0L, null, 0L, 2, false, 3, 0, textStyle, gapComposer, ((i3 >> 3) & 14) | 1572864, 24960, 110520);
            gapComposer2 = gapComposer;
            gapComposer2.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new FilesActivity$$ExternalSyntheticLambda16(i, 6, str, str3);
        }
    }

    public static final void DetailSection(String str, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        GapComposer gapComposer2;
        gapComposer.startRestartGroup(1465112427);
        if ((((gapComposer.changed(str) ? 4 : 2) | i) & 19) == 18 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
            gapComposer2 = gapComposer;
        } else {
            gapComposer2 = gapComposer;
            zzjl.m819GlassSurfaceYxtnGt4(null, 12, null, Thread_jvmKt.rememberComposableLambda(-1944758872, new MainAppKt$MainApp$2$3$1$1$1$2.AnonymousClass1((AppColors) gapComposer.consume(AppColorsKt.LocalAppColors), str, composableLambdaImpl, 1), gapComposer), gapComposer2, 196656, 29);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new BasicTooltipKt$$ExternalSyntheticLambda7(str, composableLambdaImpl, i, 2);
        }
    }

    public static final void EmptyState(Modifier modifier, GapComposer gapComposer, int i) {
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(-1891430554);
        if (((i | (gapComposer2.changed(modifier) ? 4 : 2)) & 3) == 2 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
            long j = gapComposer2.compositeKeyHashCode;
            int i2 = (int) (j ^ (j >>> 32));
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
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$1 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m295setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, composeUiNode$Companion$SetModifier$2);
            Integer numValueOf = Integer.valueOf(i2);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m295setimpl(gapComposer2, numValueOf, composeUiNode$Companion$SetModifier$3);
            OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
            Stack.m294reconcileimpl(gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.CenterHorizontally, gapComposer2, 48);
            long j2 = gapComposer2.compositeKeyHashCode;
            int i3 = (int) (j2 ^ (j2 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer2, companion);
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer2.useNode();
            }
            Stack.m295setimpl(gapComposer2, columnMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
            ImageAnalysis$$ExternalSyntheticLambda1.m(i3, gapComposer2, composeUiNode$Companion$SetModifier$3, gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
            ImageVector linkOff = Okio.getLinkOff();
            long j3 = appColors.textSecondary;
            IconKt.m249Iconww6aTOc(linkOff, null, SizeKt.m140size3ABfNKs(companion, 56), BrushKt.Color(Color.m440getRedimpl(j3), Color.m439getGreenimpl(j3), Color.m437getBlueimpl(j3), 0.4f, Color.m438getColorSpaceimpl(j3)), gapComposer2, 432, 0);
            OffsetKt.Spacer(gapComposer2, SizeKt.m135height3ABfNKs(companion, 16));
            String strStringResource = StringResources_androidKt.stringResource(R.string.connections_empty, gapComposer2);
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
            TextKt.m275TextNvy7gAk(strStringResource, null, appColors.textSecondary, 0L, null, FontWeight.Medium, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.bodyLarge, gapComposer, 1572864, 0, 131002);
            OffsetKt.Spacer(gapComposer, SizeKt.m135height3ABfNKs(companion, 6));
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.connections_empty_desc, gapComposer);
            TextStyle textStyle = ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.bodySmall;
            long j4 = appColors.textSecondary;
            TextKt.m275TextNvy7gAk(strStringResource2, null, BrushKt.Color(Color.m440getRedimpl(j4), Color.m439getGreenimpl(j4), Color.m437getBlueimpl(j4), 0.6f, Color.m438getColorSpaceimpl(j4)), 0L, null, null, 0L, null, 0L, 0, false, 0, 0, textStyle, gapComposer, 0, 0, 131066);
            gapComposer2 = gapComposer;
            gapComposer2.end(true);
            gapComposer2.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new BoxKt$$ExternalSyntheticLambda0(modifier, i, 1);
        }
    }

    /* JADX INFO: renamed from: NetworkBadge-RPmYEkk, reason: not valid java name */
    public static final void m804NetworkBadgeRPmYEkk(String str, long j, GapComposer gapComposer, int i) {
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(795872198);
        int i2 = i | (gapComposer2.changed(str) ? 4 : 2) | (gapComposer2.changed(j) ? 32 : 16);
        if ((i2 & 19) == 18 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
        } else {
            Modifier modifierM129paddingVpY3zN4 = OffsetKt.m129paddingVpY3zN4(ImageKt.m47backgroundbw27NRU(ClipKt.clip(Modifier.Companion.$$INSTANCE, RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(6)), BrushKt.Color(Color.m440getRedimpl(j), Color.m439getGreenimpl(j), Color.m437getBlueimpl(j), 0.12f, Color.m438getColorSpaceimpl(j)), BrushKt.RectangleShape), 8, 3);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
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
            Stack.m295setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m295setimpl(gapComposer2, Integer.valueOf(i3), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m294reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            TextKt.m275TextNvy7gAk(str, null, j, 0L, null, FontWeight.Bold, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.labelSmall, gapComposer2, (i2 & 14) | 1572864 | ((i2 << 3) & 896), 0, 131002);
            gapComposer2 = gapComposer2;
            gapComposer2.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AndroidCursorHandle_androidKt$$ExternalSyntheticLambda1(i, 1, j, str);
        }
    }

    public static final void ProcessCard(final ProcessGroup processGroup, final Function0 function0, GapComposer gapComposer, int i) {
        gapComposer.startRestartGroup(1637729356);
        if ((((gapComposer.changedInstance(processGroup) ? 4 : 2) | i | (gapComposer.changedInstance(function0) ? 32 : 16)) & 19) == 18 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            final AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            gapComposer.startReplaceGroup(-589360477);
            String strStringResource = processGroup.process;
            if (strStringResource.length() == 0) {
                strStringResource = StringResources_androidKt.stringResource(R.string.process_unknown, gapComposer);
            }
            final String str = strStringResource;
            gapComposer.end(false);
            Character chValueOf = str.length() == 0 ? null : Character.valueOf(str.charAt(0));
            final char upperCase = chValueOf != null ? Character.toUpperCase(chValueOf.charValue()) : '?';
            zzjl.m819GlassSurfaceYxtnGt4(null, 12, null, Thread_jvmKt.rememberComposableLambda(737539145, new Function2() { // from class: com.github.kr328.clash.compose.connections.ConnectionsScreenKt.ProcessCard.1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1;
                    float f;
                    ArrayList arrayList;
                    ArrayList arrayList2;
                    StaticProvidableCompositionLocal staticProvidableCompositionLocal;
                    AppColors appColors2;
                    AppColors appColors3;
                    GapComposer gapComposer2 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                        float f2 = 12;
                        Modifier modifierM129paddingVpY3zN4 = OffsetKt.m129paddingVpY3zN4(ImageKt.m51clickableoSLSa3U$default(SizeKt.fillMaxWidth(companion, 1.0f), false, null, function0, 15), 14, f2);
                        BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                        FlowRowOverflow flowRowOverflow = Arrangement.Start;
                        RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(flowRowOverflow, vertical, gapComposer2, 48);
                        long j = gapComposer2.compositeKeyHashCode;
                        int i2 = (int) (j ^ (j >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierM129paddingVpY3zN4);
                        ComposeUiNode.Companion.getClass();
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$2 = ComposeUiNode.Companion.Constructor;
                        gapComposer2.startReusableNode();
                        if (gapComposer2.inserting) {
                            gapComposer2.createNode(layoutNode$Companion$Constructor$2);
                        } else {
                            gapComposer2.useNode();
                        }
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$1 = ComposeUiNode.Companion.SetMeasurePolicy;
                        Stack.m295setimpl(gapComposer2, rowMeasurePolicy, composeUiNode$Companion$SetModifier$1);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                        Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, composeUiNode$Companion$SetModifier$2);
                        Integer numValueOf = Integer.valueOf(i2);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
                        Stack.m295setimpl(gapComposer2, numValueOf, composeUiNode$Companion$SetModifier$3);
                        OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
                        Stack.m294reconcileimpl(gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
                        Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
                        Modifier modifierClip = ClipKt.clip(SizeKt.m140size3ABfNKs(companion, 36), RoundedCornerShapeKt.CircleShape);
                        AppColors appColors4 = appColors;
                        Modifier modifierM47backgroundbw27NRU = ImageKt.m47backgroundbw27NRU(modifierClip, appColors4.accentFill, BrushKt.RectangleShape);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                        long j2 = gapComposer2.compositeKeyHashCode;
                        int i3 = (int) (j2 ^ (j2 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer2, modifierM47backgroundbw27NRU);
                        gapComposer2.startReusableNode();
                        if (gapComposer2.inserting) {
                            gapComposer2.createNode(layoutNode$Companion$Constructor$2);
                        } else {
                            gapComposer2.useNode();
                        }
                        Stack.m295setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, composeUiNode$Companion$SetModifier$1);
                        Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
                        Modifier.CC.m(i3, gapComposer2, composeUiNode$Companion$SetModifier$3, gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
                        Stack.m295setimpl(gapComposer2, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
                        String strValueOf = String.valueOf(upperCase);
                        StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                        TextKt.m275TextNvy7gAk(strValueOf, null, appColors4.textPrimary, 0L, null, FontWeight.Bold, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal2)).typography.bodyMedium, gapComposer2, 1572864, 0, 131002);
                        gapComposer2.end(true);
                        OffsetKt.Spacer(gapComposer2, SizeKt.m144width3ABfNKs(companion, f2));
                        if (1.0f <= 0.0d) {
                            InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                        }
                        LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
                        ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, gapComposer2, 0);
                        long j3 = gapComposer2.compositeKeyHashCode;
                        int i4 = (int) (j3 ^ (j3 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope3 = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier3 = AbsoluteAlignment.materializeModifier(gapComposer2, layoutWeightElement);
                        gapComposer2.startReusableNode();
                        if (gapComposer2.inserting) {
                            layoutNode$Companion$Constructor$1 = layoutNode$Companion$Constructor$2;
                            gapComposer2.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            layoutNode$Companion$Constructor$1 = layoutNode$Companion$Constructor$2;
                            gapComposer2.useNode();
                        }
                        Stack.m295setimpl(gapComposer2, columnMeasurePolicy, composeUiNode$Companion$SetModifier$1);
                        Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope3, composeUiNode$Companion$SetModifier$2);
                        Modifier.CC.m(i4, gapComposer2, composeUiNode$Companion$SetModifier$3, gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
                        Stack.m295setimpl(gapComposer2, modifierMaterializeModifier3, composeUiNode$Companion$SetModifier$4);
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$3 = layoutNode$Companion$Constructor$1;
                        TextKt.m275TextNvy7gAk(str, null, appColors4.textPrimary, 0L, null, FontWeight.Medium, 0L, null, 0L, 2, false, 1, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal2)).typography.bodyMedium, gapComposer2, 1572864, 24960, 110522);
                        GapComposer gapComposer3 = gapComposer2;
                        float f3 = 4;
                        OffsetKt.Spacer(gapComposer3, SizeKt.m135height3ABfNKs(companion, f3));
                        RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(flowRowOverflow, vertical, gapComposer3, 48);
                        long j4 = gapComposer3.compositeKeyHashCode;
                        int i5 = (int) (j4 ^ (j4 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope4 = gapComposer3.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier4 = AbsoluteAlignment.materializeModifier(gapComposer3, companion);
                        gapComposer3.startReusableNode();
                        if (gapComposer3.inserting) {
                            gapComposer3.createNode(layoutNode$Companion$Constructor$3);
                        } else {
                            gapComposer3.useNode();
                        }
                        Stack.m295setimpl(gapComposer3, rowMeasurePolicy2, composeUiNode$Companion$SetModifier$1);
                        Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope4, composeUiNode$Companion$SetModifier$2);
                        Modifier.CC.m(i5, gapComposer3, composeUiNode$Companion$SetModifier$3, gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$1);
                        Stack.m295setimpl(gapComposer3, modifierMaterializeModifier4, composeUiNode$Companion$SetModifier$4);
                        gapComposer3.startReplaceGroup(493762073);
                        ProcessGroup processGroup2 = processGroup;
                        ArrayList arrayList3 = processGroup2.activeConnections;
                        ArrayList arrayList4 = processGroup2.closedConnections;
                        if (arrayList3.isEmpty()) {
                            f = f3;
                            arrayList = arrayList4;
                            arrayList2 = arrayList3;
                            staticProvidableCompositionLocal = staticProvidableCompositionLocal2;
                            appColors2 = appColors4;
                        } else {
                            ConnectionsScreenKt.m808StatusDotek8zF_U(appColors4.statusActive, gapComposer3, 0);
                            OffsetKt.Spacer(gapComposer3, SizeKt.m144width3ABfNKs(companion, f3));
                            arrayList2 = arrayList3;
                            arrayList = arrayList4;
                            f = f3;
                            staticProvidableCompositionLocal = staticProvidableCompositionLocal2;
                            appColors2 = appColors4;
                            TextKt.m275TextNvy7gAk(String.valueOf(arrayList3.size()), null, appColors4.textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal2)).typography.labelSmall, gapComposer3, 0, 0, 131066);
                            gapComposer3 = gapComposer3;
                        }
                        gapComposer3.end(false);
                        gapComposer3.startReplaceGroup(493776601);
                        if (arrayList.isEmpty()) {
                            appColors3 = appColors2;
                        } else {
                            gapComposer3.startReplaceGroup(493778322);
                            if (!arrayList2.isEmpty()) {
                                OffsetKt.Spacer(gapComposer3, SizeKt.m144width3ABfNKs(companion, 10));
                            }
                            gapComposer3.end(false);
                            AppColors appColors5 = appColors2;
                            ConnectionsScreenKt.m808StatusDotek8zF_U(appColors5.statusClosed, gapComposer3, 0);
                            OffsetKt.Spacer(gapComposer3, SizeKt.m144width3ABfNKs(companion, f));
                            GapComposer gapComposer4 = gapComposer3;
                            appColors3 = appColors5;
                            TextKt.m275TextNvy7gAk(String.valueOf(arrayList.size()), null, appColors5.textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal)).typography.labelSmall, gapComposer4, 0, 0, 131066);
                            gapComposer3 = gapComposer4;
                        }
                        gapComposer3.end(false);
                        OffsetKt.Spacer(gapComposer3, SizeKt.m144width3ABfNKs(companion, f2));
                        ArrayList arrayList5 = arrayList2;
                        ArrayList arrayList6 = arrayList;
                        ArrayList arrayListPlus = CollectionsKt.plus((Collection) arrayList5, (List) arrayList6);
                        int size = arrayListPlus.size();
                        int i6 = 0;
                        long j5 = 0;
                        while (i6 < size) {
                            Object obj3 = arrayListPlus.get(i6);
                            i6++;
                            j5 += ((ConnectionInfo) obj3).upload;
                        }
                        String strAccess$formatBytes = ConnectionsScreenKt.access$formatBytes(j5);
                        ArrayList arrayListPlus2 = CollectionsKt.plus((Collection) arrayList5, (List) arrayList6);
                        int size2 = arrayListPlus2.size();
                        int i7 = 0;
                        long j6 = 0;
                        while (i7 < size2) {
                            Object obj4 = arrayListPlus2.get(i7);
                            i7++;
                            j6 += ((ConnectionInfo) obj4).download;
                        }
                        AppColors appColors6 = appColors3;
                        GapComposer gapComposer5 = gapComposer3;
                        TextKt.m275TextNvy7gAk("↑" + strAccess$formatBytes + "  ↓" + ConnectionsScreenKt.access$formatBytes(j6), null, appColors6.textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer3.consume(MaterialThemeKt._localMaterialTheme)).typography.labelSmall, gapComposer5, 0, 0, 131066);
                        gapComposer5.end(true);
                        gapComposer5.end(true);
                        IconKt.m249Iconww6aTOc(Encoder.DefaultImpls.getKeyboardArrowRight(), null, SizeKt.m140size3ABfNKs(companion, (float) 20), appColors6.textSecondary, gapComposer5, 432, 0);
                        gapComposer5.end(true);
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, 196656, 29);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TextKt$$ExternalSyntheticLambda2(i, 23, processGroup, function0);
        }
    }

    public static final void ProcessListContent(final List list, final long j, final long j2, final int i, final int i2, final boolean z, final Function1 function1, final PaddingValues paddingValues, final boolean z2, final HazeState hazeState, GapComposer gapComposer, final int i3) {
        GapComposer gapComposer2;
        PaddingValuesImpl paddingValuesImpl;
        gapComposer.startRestartGroup(-1347484488);
        int i4 = i3 | (gapComposer.changedInstance(list) ? 4 : 2) | (gapComposer.changed(j) ? 32 : 16) | (gapComposer.changed(j2) ? 256 : 128) | (gapComposer.changed(i) ? 2048 : 1024) | (gapComposer.changed(i2) ? 16384 : 8192) | (gapComposer.changed(z) ? 131072 : 65536) | (gapComposer.changed(paddingValues) ? 8388608 : 4194304) | (gapComposer.changed(z2) ? 67108864 : 33554432) | (gapComposer.changed(hazeState) ? 536870912 : 268435456);
        if ((i4 & 306783379) == 306783378 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
            gapComposer2 = gapComposer;
        } else {
            AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            if (z) {
                gapComposer.startReplaceGroup(1047419037);
                Modifier modifierPadding = OffsetKt.padding(SizeKt.FillWholeMaxSize, paddingValues);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                long j3 = gapComposer.compositeKeyHashCode;
                int i5 = (int) (j3 ^ (j3 >>> 32));
                PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifierPadding);
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
                Stack.m295setimpl(gapComposer, Integer.valueOf(i5), ComposeUiNode.Companion.SetCompositeKeyHash);
                Stack.m294reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                Stack.m295setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                ProgressIndicatorKt.m256CircularProgressIndicator4lLiAd8(SizeKt.m140size3ABfNKs(companion, 32), appColors.textSecondary, 3, 0L, 0, 0.0f, gapComposer, 390, 56);
                gapComposer2 = gapComposer;
                gapComposer2.end(true);
                gapComposer2.end(false);
            } else {
                gapComposer2 = gapComposer;
                if (list.isEmpty()) {
                    gapComposer2.startReplaceGroup(1047868103);
                    EmptyState(OffsetKt.padding(SizeKt.FillWholeMaxSize, paddingValues), gapComposer2, 0);
                    gapComposer2.end(false);
                } else {
                    gapComposer2.startReplaceGroup(1048076888);
                    Modifier modifierThen = SizeKt.FillWholeMaxSize.then(!z2 ? companion.then(new HazeSourceElement(hazeState)) : companion);
                    if (z2) {
                        float f = 16;
                        paddingValuesImpl = new PaddingValuesImpl(f, paddingValues.mo120calculateTopPaddingD9Ej5fM(), f, paddingValues.mo117calculateBottomPaddingD9Ej5fM());
                    } else {
                        float f2 = 16;
                        paddingValuesImpl = new PaddingValuesImpl(f2, paddingValues.mo120calculateTopPaddingD9Ej5fM() + 8, f2, f2);
                    }
                    PaddingValuesImpl paddingValuesImpl2 = paddingValuesImpl;
                    Arrangement.SpacedAligned spacedAlignedM111spacedBy0680j_4 = Arrangement.m111spacedBy0680j_4(8);
                    gapComposer2.startReplaceGroup(-1905830788);
                    boolean zChangedInstance = ((i4 & 7168) == 2048) | ((57344 & i4) == 16384) | ((i4 & 112) == 32) | ((i4 & 896) == 256) | gapComposer2.changedInstance(list);
                    Object objRememberedValue = gapComposer2.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer$Companion.Empty) {
                        Function1 function2 = new Function1() { // from class: com.github.kr328.clash.compose.connections.ConnectionsScreenKt$$ExternalSyntheticLambda20
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                LazyListIntervalContent lazyListIntervalContent = (LazyListIntervalContent) obj;
                                final int i6 = i;
                                final int i7 = i2;
                                final long j4 = j;
                                final long j5 = j2;
                                LazyItemScope$CC.item$default(lazyListIntervalContent, "stats", new ComposableLambdaImpl(430028750, new Function3() { // from class: com.github.kr328.clash.compose.connections.ConnectionsScreenKt$ProcessListContent$2$1$1
                                    @Override // kotlin.jvm.functions.Function3
                                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                                        GapComposer gapComposer3 = (GapComposer) obj3;
                                        if ((((Number) obj4).intValue() & 17) == 16 && gapComposer3.getSkipping()) {
                                            gapComposer3.skipToGroupEnd();
                                        } else {
                                            ConnectionsScreenKt.StatsBar(i6, i7, j4, j5, gapComposer3, 0);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }, true), 2);
                                AsyncImagePainter$$ExternalSyntheticLambda0 asyncImagePainter$$ExternalSyntheticLambda0 = new AsyncImagePainter$$ExternalSyntheticLambda0(15);
                                List list2 = list;
                                lazyListIntervalContent.items(list2.size(), new FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2(7, list2, asyncImagePainter$$ExternalSyntheticLambda0), new FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2(8, list2), new ComposableLambdaImpl(802480018, new ConnectionsScreenKt$ProcessListContent$lambda$53$lambda$52$$inlined$items$default$4(0, list2, function1), true));
                                return Unit.INSTANCE;
                            }
                        };
                        gapComposer2.updateRememberedValue(function2);
                        objRememberedValue = function2;
                    }
                    gapComposer2.end(r4);
                    LazyDslKt.LazyColumn(modifierThen, null, paddingValuesImpl2, false, spacedAlignedM111spacedBy0680j_4, null, null, false, null, (Function1) objRememberedValue, gapComposer, 24576, 490);
                    gapComposer2 = gapComposer;
                    gapComposer2.end(false);
                }
            }
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2(list, j, j2, i, i2, z, function1, paddingValues, z2, hazeState, i3) { // from class: com.github.kr328.clash.compose.connections.ConnectionsScreenKt$$ExternalSyntheticLambda21
                public final /* synthetic */ List f$0;
                public final /* synthetic */ long f$1;
                public final /* synthetic */ long f$2;
                public final /* synthetic */ int f$3;
                public final /* synthetic */ int f$4;
                public final /* synthetic */ boolean f$5;
                public final /* synthetic */ Function1 f$6;
                public final /* synthetic */ PaddingValues f$7;
                public final /* synthetic */ boolean f$8;
                public final /* synthetic */ HazeState f$9;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    ConnectionsScreenKt.ProcessListContent(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, (GapComposer) obj, Stack.updateChangedFlags(1572865));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX INFO: renamed from: SectionHeader-RPmYEkk, reason: not valid java name */
    public static final void m805SectionHeaderRPmYEkk(String str, long j, GapComposer gapComposer, int i) {
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(1680139525);
        int i2 = i | (gapComposer2.changed(str) ? 4 : 2) | (gapComposer2.changed(j) ? 32 : 16);
        if ((i2 & 19) == 18 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            float f = 12;
            Modifier modifierM132paddingqDBjuR0$default = OffsetKt.m132paddingqDBjuR0$default(SizeKt.fillMaxWidth(companion, 1.0f), 0.0f, f, 0.0f, 4, 5);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.CenterVertically, gapComposer2, 48);
            long j2 = gapComposer2.compositeKeyHashCode;
            int i3 = (int) (j2 ^ (j2 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierM132paddingqDBjuR0$default);
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
            m808StatusDotek8zF_U(j, gapComposer2, (i2 >> 3) & 14);
            OffsetKt.Spacer(gapComposer2, SizeKt.m144width3ABfNKs(companion, 8));
            TextKt.m275TextNvy7gAk(str, null, appColors.textSecondary, 0L, null, FontWeight.SemiBold, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.labelMedium, gapComposer, (i2 & 14) | 1572864, 0, 131002);
            gapComposer2 = gapComposer;
            OffsetKt.Spacer(gapComposer2, SizeKt.m144width3ABfNKs(companion, f));
            if (1.0f <= 0.0d) {
                InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
            }
            ScrimKt.m264HorizontalDivider9IZ8Weo(new LayoutWeightElement(1.0f, true), 0.0f, BrushKt.Color(Color.m440getRedimpl(j), Color.m439getGreenimpl(j), Color.m437getBlueimpl(j), 0.2f, Color.m438getColorSpaceimpl(j)), gapComposer2, 0, 2);
            gapComposer2.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AndroidCursorHandle_androidKt$$ExternalSyntheticLambda1(i, 3, j, str);
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x007b  */
    /* JADX WARN: Code duplicated, block: B:41:0x007e  */
    /* JADX WARN: Code duplicated, block: B:42:0x0080  */
    /* JADX WARN: Code duplicated, block: B:44:0x0083  */
    /* JADX WARN: Code duplicated, block: B:45:0x0085  */
    /* JADX WARN: Code duplicated, block: B:48:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:49:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:52:0x0109  */
    /* JADX WARN: Code duplicated, block: B:53:0x010d  */
    /* JADX WARN: Code duplicated, block: B:56:0x0124  */
    /* JADX WARN: Code duplicated, block: B:59:0x0142  */
    /* JADX WARN: Code duplicated, block: B:60:0x0199  */
    /* JADX WARN: Code duplicated, block: B:64:0x0213  */
    /* JADX WARN: Code duplicated, block: B:66:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: StatCell-Sj8uqqQ, reason: not valid java name */
    public static final void m806StatCellSj8uqqQ(String str, String str2, Modifier modifier, Color color, String str3, GapComposer gapComposer, int i, int i2) {
        Color color2;
        int i3;
        String str4;
        Color color3;
        String str5;
        AppColors appColors;
        String str6;
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1;
        Modifier.Companion companion;
        int i4;
        String str7;
        GapComposer gapComposer2;
        Color color4;
        AppColors appColors2;
        int i5;
        int i6;
        GapComposer gapComposer3;
        String str8;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        gapComposer.startRestartGroup(-1267399932);
        int i7 = (gapComposer.changed(str) ? 4 : 2) | i | (gapComposer.changed(str2) ? 32 : 16) | (gapComposer.changed(modifier) ? 256 : 128);
        int i8 = i2 & 8;
        if (i8 != 0) {
            i3 = i7 | 3072;
            color2 = color;
        } else {
            color2 = color;
            i3 = i7 | (gapComposer.changed(color2) ? 2048 : 1024);
        }
        int i9 = i2 & 16;
        if (i9 == 0) {
            if ((i & 24576) == 0) {
                str4 = str3;
                i3 |= gapComposer.changed(str4) ? 16384 : 8192;
            }
            if ((i3 & 9363) == 9362 || !gapComposer.getSkipping()) {
                if (i8 != 0) {
                    color3 = null;
                } else {
                    color3 = color2;
                }
                if (i9 != 0) {
                    str5 = null;
                } else {
                    str5 = str4;
                }
                appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
                Modifier modifierM129paddingVpY3zN4 = OffsetKt.m129paddingVpY3zN4(modifier, 16, 10);
                ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.CenterHorizontally, gapComposer, 48);
                str6 = str5;
                long j = gapComposer.compositeKeyHashCode;
                int i10 = (int) (j ^ (j >>> 32));
                PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifierM129paddingVpY3zN4);
                ComposeUiNode.Companion.getClass();
                layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                gapComposer.startReusableNode();
                if (gapComposer.inserting) {
                    gapComposer.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    gapComposer.useNode();
                }
                ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$1 = ComposeUiNode.Companion.SetMeasurePolicy;
                Stack.m295setimpl(gapComposer, columnMeasurePolicy, composeUiNode$Companion$SetModifier$1);
                ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, composeUiNode$Companion$SetModifier$2);
                Integer numValueOf = Integer.valueOf(i10);
                ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
                Stack.m295setimpl(gapComposer, numValueOf, composeUiNode$Companion$SetModifier$3);
                OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
                Stack.m294reconcileimpl(gapComposer, ownerSnapshotObserver$onCommitAffectingLayout$1);
                ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
                Stack.m295setimpl(gapComposer, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
                RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.CenterVertically, gapComposer, 48);
                long j2 = gapComposer.compositeKeyHashCode;
                int i11 = (int) (j2 ^ (j2 >>> 32));
                PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
                companion = Modifier.Companion.$$INSTANCE;
                Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer, companion);
                gapComposer.startReusableNode();
                i4 = i3;
                if (gapComposer.inserting) {
                    gapComposer.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    gapComposer.useNode();
                }
                Stack.m295setimpl(gapComposer, rowMeasurePolicy, composeUiNode$Companion$SetModifier$1);
                Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
                ImageAnalysis$$ExternalSyntheticLambda1.m(i11, gapComposer, composeUiNode$Companion$SetModifier$3, gapComposer, ownerSnapshotObserver$onCommitAffectingLayout$1);
                Stack.m295setimpl(gapComposer, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
                gapComposer.startReplaceGroup(-326820452);
                if (color3 != null) {
                    m808StatusDotek8zF_U(color3.value, gapComposer, (i4 >> 9) & 14);
                    OffsetKt.Spacer(gapComposer, SizeKt.m144width3ABfNKs(companion, 4));
                }
                gapComposer.end(false);
                gapComposer.startReplaceGroup(-326816087);
                if (str6 != null) {
                    color4 = color3;
                    str7 = str6;
                    i5 = i4;
                    appColors2 = appColors;
                    i6 = 2;
                    TextKt.m275TextNvy7gAk(str6.concat(" "), null, appColors.textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.labelSmall, gapComposer, 0, 0, 131066);
                    gapComposer2 = gapComposer;
                } else {
                    str7 = str6;
                    gapComposer2 = gapComposer;
                    color4 = color3;
                    appColors2 = appColors;
                    i5 = i4;
                    i6 = 2;
                }
                gapComposer2.end(false);
                StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                GapComposer gapComposer4 = gapComposer2;
                TextKt.m275TextNvy7gAk(str, null, appColors2.textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.labelSmall, gapComposer4, i5 & 14, 0, 131066);
                gapComposer4.end(true);
                OffsetKt.Spacer(gapComposer4, SizeKt.m135height3ABfNKs(companion, i6));
                TextKt.m275TextNvy7gAk(str2, null, appColors2.textPrimary, 0L, null, FontWeight.Bold, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer4.consume(staticProvidableCompositionLocal)).typography.titleMedium, gapComposer4, ((i5 >> 3) & 14) | 1572864, 0, 131002);
                gapComposer3 = gapComposer4;
                gapComposer3.end(true);
                str8 = str7;
            } else {
                gapComposer.skipToGroupEnd();
                gapComposer3 = gapComposer;
                color4 = color2;
                str8 = str4;
            }
            recomposeScopeImplEndRestartGroup = gapComposer3.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new FlowLayoutKt$$ExternalSyntheticLambda3(str, str2, modifier, color4, str8, i, i2);
            }
        }
        i3 |= 24576;
        str4 = str3;
        if ((i3 & 9363) == 9362) {
            if (i8 != 0) {
                color3 = null;
            } else {
                color3 = color2;
            }
            if (i9 != 0) {
                str5 = null;
            } else {
                str5 = str4;
            }
            appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            Modifier modifierM129paddingVpY3zN5 = OffsetKt.m129paddingVpY3zN4(modifier, 16, 10);
            ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.CenterHorizontally, gapComposer, 48);
            str6 = str5;
            long j3 = gapComposer.compositeKeyHashCode;
            int i12 = (int) (j3 ^ (j3 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope3 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier3 = AbsoluteAlignment.materializeModifier(gapComposer, modifierM129paddingVpY3zN5);
            ComposeUiNode.Companion.getClass();
            layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer.useNode();
            }
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$5 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m295setimpl(gapComposer, columnMeasurePolicy2, composeUiNode$Companion$SetModifier$5);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$6 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope3, composeUiNode$Companion$SetModifier$6);
            Integer numValueOf2 = Integer.valueOf(i12);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$7 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m295setimpl(gapComposer, numValueOf2, composeUiNode$Companion$SetModifier$7);
            OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$2 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
            Stack.m294reconcileimpl(gapComposer, ownerSnapshotObserver$onCommitAffectingLayout$2);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$8 = ComposeUiNode.Companion.SetModifier;
            Stack.m295setimpl(gapComposer, modifierMaterializeModifier3, composeUiNode$Companion$SetModifier$8);
            RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.CenterVertically, gapComposer, 48);
            long j4 = gapComposer.compositeKeyHashCode;
            int i13 = (int) (j4 ^ (j4 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope4 = gapComposer.currentCompositionLocalScope();
            companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierMaterializeModifier4 = AbsoluteAlignment.materializeModifier(gapComposer, companion);
            gapComposer.startReusableNode();
            i4 = i3;
            if (gapComposer.inserting) {
                gapComposer.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer.useNode();
            }
            Stack.m295setimpl(gapComposer, rowMeasurePolicy2, composeUiNode$Companion$SetModifier$5);
            Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope4, composeUiNode$Companion$SetModifier$6);
            ImageAnalysis$$ExternalSyntheticLambda1.m(i13, gapComposer, composeUiNode$Companion$SetModifier$7, gapComposer, ownerSnapshotObserver$onCommitAffectingLayout$2);
            Stack.m295setimpl(gapComposer, modifierMaterializeModifier4, composeUiNode$Companion$SetModifier$8);
            gapComposer.startReplaceGroup(-326820452);
            if (color3 != null) {
                m808StatusDotek8zF_U(color3.value, gapComposer, (i4 >> 9) & 14);
                OffsetKt.Spacer(gapComposer, SizeKt.m144width3ABfNKs(companion, 4));
            }
            gapComposer.end(false);
            gapComposer.startReplaceGroup(-326816087);
            if (str6 != null) {
                color4 = color3;
                str7 = str6;
                i5 = i4;
                appColors2 = appColors;
                i6 = 2;
                TextKt.m275TextNvy7gAk(str6.concat(" "), null, appColors.textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.labelSmall, gapComposer, 0, 0, 131066);
                gapComposer2 = gapComposer;
            } else {
                str7 = str6;
                gapComposer2 = gapComposer;
                color4 = color3;
                appColors2 = appColors;
                i5 = i4;
                i6 = 2;
            }
            gapComposer2.end(false);
            StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
            GapComposer gapComposer5 = gapComposer2;
            TextKt.m275TextNvy7gAk(str, null, appColors2.textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal2)).typography.labelSmall, gapComposer5, i5 & 14, 0, 131066);
            gapComposer5.end(true);
            OffsetKt.Spacer(gapComposer5, SizeKt.m135height3ABfNKs(companion, i6));
            TextKt.m275TextNvy7gAk(str2, null, appColors2.textPrimary, 0L, null, FontWeight.Bold, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal2)).typography.titleMedium, gapComposer5, ((i5 >> 3) & 14) | 1572864, 0, 131002);
            gapComposer3 = gapComposer5;
            gapComposer3.end(true);
            str8 = str7;
        } else {
            if (i8 != 0) {
                color3 = null;
            } else {
                color3 = color2;
            }
            if (i9 != 0) {
                str5 = null;
            } else {
                str5 = str4;
            }
            appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            Modifier modifierM129paddingVpY3zN6 = OffsetKt.m129paddingVpY3zN4(modifier, 16, 10);
            ColumnMeasurePolicy columnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.CenterHorizontally, gapComposer, 48);
            str6 = str5;
            long j5 = gapComposer.compositeKeyHashCode;
            int i14 = (int) (j5 ^ (j5 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope5 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier5 = AbsoluteAlignment.materializeModifier(gapComposer, modifierM129paddingVpY3zN6);
            ComposeUiNode.Companion.getClass();
            layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer.useNode();
            }
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$9 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m295setimpl(gapComposer, columnMeasurePolicy3, composeUiNode$Companion$SetModifier$9);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$10 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope5, composeUiNode$Companion$SetModifier$10);
            Integer numValueOf3 = Integer.valueOf(i14);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$11 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m295setimpl(gapComposer, numValueOf3, composeUiNode$Companion$SetModifier$11);
            OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$3 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
            Stack.m294reconcileimpl(gapComposer, ownerSnapshotObserver$onCommitAffectingLayout$3);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$12 = ComposeUiNode.Companion.SetModifier;
            Stack.m295setimpl(gapComposer, modifierMaterializeModifier5, composeUiNode$Companion$SetModifier$12);
            RowMeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.CenterVertically, gapComposer, 48);
            long j6 = gapComposer.compositeKeyHashCode;
            int i15 = (int) (j6 ^ (j6 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope6 = gapComposer.currentCompositionLocalScope();
            companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierMaterializeModifier6 = AbsoluteAlignment.materializeModifier(gapComposer, companion);
            gapComposer.startReusableNode();
            i4 = i3;
            if (gapComposer.inserting) {
                gapComposer.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer.useNode();
            }
            Stack.m295setimpl(gapComposer, rowMeasurePolicy3, composeUiNode$Companion$SetModifier$9);
            Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope6, composeUiNode$Companion$SetModifier$10);
            ImageAnalysis$$ExternalSyntheticLambda1.m(i15, gapComposer, composeUiNode$Companion$SetModifier$11, gapComposer, ownerSnapshotObserver$onCommitAffectingLayout$3);
            Stack.m295setimpl(gapComposer, modifierMaterializeModifier6, composeUiNode$Companion$SetModifier$12);
            gapComposer.startReplaceGroup(-326820452);
            if (color3 != null) {
                m808StatusDotek8zF_U(color3.value, gapComposer, (i4 >> 9) & 14);
                OffsetKt.Spacer(gapComposer, SizeKt.m144width3ABfNKs(companion, 4));
            }
            gapComposer.end(false);
            gapComposer.startReplaceGroup(-326816087);
            if (str6 != null) {
                color4 = color3;
                str7 = str6;
                i5 = i4;
                appColors2 = appColors;
                i6 = 2;
                TextKt.m275TextNvy7gAk(str6.concat(" "), null, appColors.textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.labelSmall, gapComposer, 0, 0, 131066);
                gapComposer2 = gapComposer;
            } else {
                str7 = str6;
                gapComposer2 = gapComposer;
                color4 = color3;
                appColors2 = appColors;
                i5 = i4;
                i6 = 2;
            }
            gapComposer2.end(false);
            StaticProvidableCompositionLocal staticProvidableCompositionLocal3 = MaterialThemeKt._localMaterialTheme;
            GapComposer gapComposer6 = gapComposer2;
            TextKt.m275TextNvy7gAk(str, null, appColors2.textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal3)).typography.labelSmall, gapComposer6, i5 & 14, 0, 131066);
            gapComposer6.end(true);
            OffsetKt.Spacer(gapComposer6, SizeKt.m135height3ABfNKs(companion, i6));
            TextKt.m275TextNvy7gAk(str2, null, appColors2.textPrimary, 0L, null, FontWeight.Bold, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer6.consume(staticProvidableCompositionLocal3)).typography.titleMedium, gapComposer6, ((i5 >> 3) & 14) | 1572864, 0, 131002);
            gapComposer3 = gapComposer6;
            gapComposer3.end(true);
            str8 = str7;
        }
        recomposeScopeImplEndRestartGroup = gapComposer3.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new FlowLayoutKt$$ExternalSyntheticLambda3(str, str2, modifier, color4, str8, i, i2);
        }
    }

    public static final void StatsBar(final int i, final int i2, final long j, final long j2, GapComposer gapComposer, final int i3) {
        gapComposer.startRestartGroup(-951553755);
        if (((i3 | (gapComposer.changed(i) ? 4 : 2) | (gapComposer.changed(i2) ? 32 : 16) | (gapComposer.changed(j) ? 256 : 128) | (gapComposer.changed(j2) ? 2048 : 1024)) & 1171) == 1170 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            final AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            zzjl.m819GlassSurfaceYxtnGt4(null, 12, null, Thread_jvmKt.rememberComposableLambda(-163910110, new Function2() { // from class: com.github.kr328.clash.compose.connections.ConnectionsScreenKt.StatsBar.1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    GapComposer gapComposer2 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                        Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                        ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, gapComposer2, 0);
                        MenuHostHelper menuHostHelper = gapComposer2.applier;
                        long j3 = gapComposer2.compositeKeyHashCode;
                        int i4 = (int) (j3 ^ (j3 >>> 32));
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
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$1 = ComposeUiNode.Companion.SetMeasurePolicy;
                        Stack.m295setimpl(gapComposer2, columnMeasurePolicy, composeUiNode$Companion$SetModifier$1);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                        Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, composeUiNode$Companion$SetModifier$2);
                        Integer numValueOf = Integer.valueOf(i4);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
                        Stack.m295setimpl(gapComposer2, numValueOf, composeUiNode$Companion$SetModifier$3);
                        OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
                        Stack.m294reconcileimpl(gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
                        Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
                        Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion, 1.0f);
                        BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                        FlowRowOverflow flowRowOverflow = Arrangement.Start;
                        RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(flowRowOverflow, vertical, gapComposer2, 48);
                        long j4 = gapComposer2.compositeKeyHashCode;
                        int i5 = (int) (j4 ^ (j4 >>> 32));
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
                        Modifier.CC.m(i5, gapComposer2, composeUiNode$Companion$SetModifier$3, gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
                        Stack.m295setimpl(gapComposer2, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
                        String strStringResource = StringResources_androidKt.stringResource(R.string.connections_active, gapComposer2);
                        String strValueOf = String.valueOf(i);
                        AppColors appColors2 = appColors;
                        long j5 = appColors2.statusActive;
                        long j6 = appColors2.cardBorder;
                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                        ConnectionsScreenKt.m806StatCellSj8uqqQ(strStringResource, strValueOf, rowScopeInstance.weight(), new Color(j5), null, gapComposer2, 0, 16);
                        float f = 1;
                        float f2 = 32;
                        Modifier modifierM135height3ABfNKs = SizeKt.m135height3ABfNKs(SizeKt.m144width3ABfNKs(companion, f), f2);
                        RectangleShapeKt$RectangleShape$1 rectangleShapeKt$RectangleShape$1 = BrushKt.RectangleShape;
                        BoxKt.Box(ImageKt.m47backgroundbw27NRU(modifierM135height3ABfNKs, j6, rectangleShapeKt$RectangleShape$1), gapComposer2, 0);
                        ConnectionsScreenKt.m806StatCellSj8uqqQ(StringResources_androidKt.stringResource(R.string.connections_closed, gapComposer2), String.valueOf(i2), rowScopeInstance.weight(), new Color(appColors2.statusClosed), null, gapComposer2, 0, 16);
                        gapComposer2.end(true);
                        ScrimKt.m264HorizontalDivider9IZ8Weo(null, 0.0f, appColors2.cardBorder, gapComposer2, 0, 3);
                        Modifier modifierFillMaxWidth3 = SizeKt.fillMaxWidth(companion, 1.0f);
                        RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(flowRowOverflow, vertical, gapComposer2, 48);
                        long j7 = gapComposer2.compositeKeyHashCode;
                        int i6 = (int) (j7 ^ (j7 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope3 = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier3 = AbsoluteAlignment.materializeModifier(gapComposer2, modifierFillMaxWidth3);
                        gapComposer2.startReusableNode();
                        if (gapComposer2.inserting) {
                            gapComposer2.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer2.useNode();
                        }
                        Stack.m295setimpl(gapComposer2, rowMeasurePolicy2, composeUiNode$Companion$SetModifier$1);
                        Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope3, composeUiNode$Companion$SetModifier$2);
                        Modifier.CC.m(i6, gapComposer2, composeUiNode$Companion$SetModifier$3, gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
                        Stack.m295setimpl(gapComposer2, modifierMaterializeModifier3, composeUiNode$Companion$SetModifier$4);
                        ConnectionsScreenKt.m806StatCellSj8uqqQ(StringResources_androidKt.stringResource(R.string.connection_upload, gapComposer2), ConnectionsScreenKt.access$formatBytes(j), rowScopeInstance.weight(), null, "↑", gapComposer2, 24576, 8);
                        BoxKt.Box(ImageKt.m47backgroundbw27NRU(SizeKt.m135height3ABfNKs(SizeKt.m144width3ABfNKs(companion, f), f2), j6, rectangleShapeKt$RectangleShape$1), gapComposer2, 0);
                        ConnectionsScreenKt.m806StatCellSj8uqqQ(StringResources_androidKt.stringResource(R.string.connection_download, gapComposer2), ConnectionsScreenKt.access$formatBytes(j2), rowScopeInstance.weight(), null, "↓", gapComposer2, 24576, 8);
                        gapComposer2.end(true);
                        gapComposer2.end(true);
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, 196656, 29);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2(i, i2, i3, j, j2) { // from class: com.github.kr328.clash.compose.connections.ConnectionsScreenKt$$ExternalSyntheticLambda28
                public final /* synthetic */ int f$0;
                public final /* synthetic */ int f$1;
                public final /* synthetic */ long f$2;
                public final /* synthetic */ long f$3;

                {
                    this.f$2 = j;
                    this.f$3 = j2;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                    ConnectionsScreenKt.StatsBar(this.f$0, this.f$1, this.f$2, this.f$3, (GapComposer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX INFO: renamed from: StatusBadge-RPmYEkk, reason: not valid java name */
    public static final void m807StatusBadgeRPmYEkk(String str, long j, GapComposer gapComposer, int i) {
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(-1695329242);
        int i2 = i | (gapComposer2.changed(str) ? 4 : 2) | (gapComposer2.changed(j) ? 32 : 16);
        if ((i2 & 19) == 18 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
        } else {
            float f = 6;
            RoundedCornerShape roundedCornerShapeM158RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(f);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierM129paddingVpY3zN4 = OffsetKt.m129paddingVpY3zN4(ImageKt.m47backgroundbw27NRU(ClipKt.clip(companion, roundedCornerShapeM158RoundedCornerShape0680j_4), BrushKt.Color(Color.m440getRedimpl(j), Color.m439getGreenimpl(j), Color.m437getBlueimpl(j), 0.15f, Color.m438getColorSpaceimpl(j)), BrushKt.RectangleShape), 8, 4);
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
            Stack.m295setimpl(gapComposer2, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m295setimpl(gapComposer2, Integer.valueOf(i3), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m294reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            m808StatusDotek8zF_U(j, gapComposer2, (i2 >> 3) & 14);
            OffsetKt.Spacer(gapComposer2, SizeKt.m144width3ABfNKs(companion, f));
            TextKt.m275TextNvy7gAk(str, null, j, 0L, null, FontWeight.SemiBold, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.labelSmall, gapComposer2, (i2 & 14) | 1572864 | ((i2 << 3) & 896), 0, 131002);
            gapComposer2 = gapComposer2;
            gapComposer2.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AndroidCursorHandle_androidKt$$ExternalSyntheticLambda1(i, 2, j, str);
        }
    }

    /* JADX INFO: renamed from: StatusDot-ek8zF_U, reason: not valid java name */
    public static final void m808StatusDotek8zF_U(final long j, GapComposer gapComposer, final int i) {
        int i2;
        gapComposer.startRestartGroup(1810686621);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            BoxKt.Box(ImageKt.m47backgroundbw27NRU(ClipKt.clip(SizeKt.m140size3ABfNKs(Modifier.Companion.$$INSTANCE, 8), RoundedCornerShapeKt.CircleShape), j, BrushKt.RectangleShape), gapComposer, 0);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.github.kr328.clash.compose.connections.ConnectionsScreenKt$$ExternalSyntheticLambda26
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).intValue();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                    ConnectionsScreenKt.m808StatusDotek8zF_U(j, (GapComposer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final String access$formatBytes(long j) {
        if (j >= 1073741824) {
            return String.format(Locale.US, "%.1f GB", Arrays.copyOf(new Object[]{Double.valueOf(j / 1.073741824E9d)}, 1));
        }
        if (j >= 1048576) {
            return String.format(Locale.US, "%.1f MB", Arrays.copyOf(new Object[]{Double.valueOf(j / 1048576.0d)}, 1));
        }
        if (j >= 1024) {
            return String.format(Locale.US, "%.1f KB", Arrays.copyOf(new Object[]{Double.valueOf(j / 1024.0d)}, 1));
        }
        return j + " B";
    }

    public static final String access$formatDuration(long j) {
        long jCurrentTimeMillis = (System.currentTimeMillis() - j) / ((long) 1000);
        if (jCurrentTimeMillis < 0) {
            return "0s";
        }
        if (jCurrentTimeMillis < 60) {
            return jCurrentTimeMillis + "s";
        }
        if (jCurrentTimeMillis < 3600) {
            long j2 = 60;
            return (jCurrentTimeMillis / j2) + "m " + (jCurrentTimeMillis % j2) + "s";
        }
        long j3 = 3600;
        return (jCurrentTimeMillis / j3) + "h " + ((jCurrentTimeMillis % j3) / ((long) 60)) + "m";
    }

    public static final long access$parseStartTime(String str) {
        Object failure;
        if (str.length() == 0) {
            return 0L;
        }
        try {
            failure = Long.valueOf(Instant.parse(str).toEpochMilli());
        } catch (Throwable th) {
            failure = new Result.Failure(th);
        }
        if (failure instanceof Result.Failure) {
            failure = 0L;
        }
        return ((Number) failure).longValue();
    }

    public static final String displayHost(ConnectionMetadata connectionMetadata) {
        String str = connectionMetadata.host;
        String str2 = connectionMetadata.destinationIP;
        String str3 = connectionMetadata.sniffHost;
        if (str.length() > 0) {
            return connectionMetadata.host;
        }
        if (str3.length() > 0) {
            return str3;
        }
        if (str2.length() > 0) {
            return str2;
        }
        String str4 = connectionMetadata.remoteDestination;
        return str4.length() == 0 ? "unknown" : str4;
    }
}
