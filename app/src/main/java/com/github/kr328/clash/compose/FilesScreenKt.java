package com.github.kr328.clash.compose;

import android.content.Context;
import android.content.res.Resources;
import androidx.activity.compose.BackHandlerKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.camera.core.impl.Quirks;
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
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeElement;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.filled.UploadKt;
import androidx.compose.material.icons.outlined.DescriptionKt;
import androidx.compose.material.icons.outlined.FolderKt;
import androidx.compose.material.icons.outlined.InboxKt;
import androidx.compose.material.icons.outlined.UpdateKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.IconKt$$ExternalSyntheticLambda2;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.MenuKt$$ExternalSyntheticLambda1;
import androidx.compose.material3.OutlinedTextFieldDefaults;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.SheetState;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda0;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda7;
import androidx.compose.material3.TopAppBarDefaults;
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
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetModifier$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayout$1;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.core.view.MenuHostHelper;
import com.github.kr328.clash.common.util.PatternsKt;
import com.github.kr328.clash.compose.connections.ConnectionsScreenKt;
import com.github.kr328.clash.compose.home.HomeScreenKt;
import com.github.kr328.clash.core.model.ConnectionInfo;
import com.github.kr328.clash.core.model.ConnectionMetadata;
import com.github.kr328.clash.design.compose.theme.AppColors;
import com.github.kr328.clash.design.compose.theme.AppColorsKt;
import com.github.kr328.clash.design.model.File;
import com.github.kr328.clash.service.model.Profile;
import com.google.android.gms.internal.mlkit_vision_common.zzjl;
import com.koala.clash.R;
import dev.chrisbanes.haze.HazeEffectNodeElement;
import dev.chrisbanes.haze.HazeState;
import java.text.DateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.MediaType;
import okhttp3.RequestBody$Companion$toRequestBody$2;
import okhttp3.internal.concurrent.TaskLoggerKt;
import okhttp3.internal.http.HttpMethod;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class FilesScreenKt {

    /* JADX INFO: renamed from: com.github.kr328.clash.compose.FilesScreenKt$FileNameDialog$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class C00181 implements Function2 {
        public final /* synthetic */ AppColors $colors;
        public final /* synthetic */ boolean $isValid;
        public final /* synthetic */ Function1 $onConfirm;
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ MutableState $value$delegate;

        public /* synthetic */ C00181(Function1 function1, boolean z, MutableState mutableState, AppColors appColors, int i) {
            this.$r8$classId = i;
            this.$onConfirm = function1;
            this.$isValid = z;
            this.$value$delegate = mutableState;
            this.$colors = appColors;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            switch (this.$r8$classId) {
                case 0:
                    GapComposer gapComposer = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
                        gapComposer.skipToGroupEnd();
                    } else {
                        gapComposer.startReplaceGroup(-13214887);
                        final Function1 function1 = this.$onConfirm;
                        boolean zChanged = gapComposer.changed(function1);
                        Object objRememberedValue = gapComposer.rememberedValue();
                        if (zChanged || objRememberedValue == Composer$Companion.Empty) {
                            final int i = 0;
                            final MutableState mutableState = this.$value$delegate;
                            objRememberedValue = new Function0() { // from class: com.github.kr328.clash.compose.FilesScreenKt$FileNameDialog$1$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    switch (i) {
                                        case 0:
                                            function1.invoke((String) mutableState.getValue());
                                            break;
                                        default:
                                            function1.invoke((String) mutableState.getValue());
                                            break;
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            gapComposer.updateRememberedValue(objRememberedValue);
                        }
                        gapComposer.end(false);
                        final AppColors appColors = this.$colors;
                        final int i2 = 0;
                        final boolean z = this.$isValid;
                        ScrimKt.TextButton((Function0) objRememberedValue, null, z, null, null, null, Thread_jvmKt.rememberComposableLambda(-1936533920, new Function3() { // from class: com.github.kr328.clash.compose.FilesScreenKt.FileNameDialog.1.2
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj3, Object obj4, Object obj5) {
                                switch (i2) {
                                    case 0:
                                        GapComposer gapComposer2 = (GapComposer) obj4;
                                        if ((((Number) obj5).intValue() & 17) == 16 && gapComposer2.getSkipping()) {
                                            gapComposer2.skipToGroupEnd();
                                        } else {
                                            String strStringResource = StringResources_androidKt.stringResource(R.string.ok, gapComposer2);
                                            boolean z2 = z;
                                            AppColors appColors2 = appColors;
                                            TextKt.m275TextNvy7gAk(strStringResource, null, z2 ? appColors2.textPrimary : appColors2.textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer2, 0, 0, 262138);
                                        }
                                        break;
                                    default:
                                        GapComposer gapComposer3 = (GapComposer) obj4;
                                        if ((((Number) obj5).intValue() & 17) == 16 && gapComposer3.getSkipping()) {
                                            gapComposer3.skipToGroupEnd();
                                        } else {
                                            String strStringResource2 = StringResources_androidKt.stringResource(R.string.ok, gapComposer3);
                                            boolean z3 = z;
                                            AppColors appColors3 = appColors;
                                            TextKt.m275TextNvy7gAk(strStringResource2, null, z3 ? appColors3.textPrimary : appColors3.textSecondary, 0L, null, FontWeight.SemiBold, 0L, null, 0L, 0, false, 0, 0, null, gapComposer3, 1572864, 0, 262074);
                                        }
                                        break;
                                }
                                return Unit.INSTANCE;
                            }
                        }, gapComposer), gapComposer, 805306368, 506);
                    }
                    break;
                default:
                    GapComposer gapComposer2 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        gapComposer2.startReplaceGroup(-580855647);
                        final Function1 function2 = this.$onConfirm;
                        boolean zChanged2 = gapComposer2.changed(function2);
                        Object objRememberedValue2 = gapComposer2.rememberedValue();
                        if (zChanged2 || objRememberedValue2 == Composer$Companion.Empty) {
                            final int i3 = 1;
                            final MutableState mutableState2 = this.$value$delegate;
                            objRememberedValue2 = new Function0() { // from class: com.github.kr328.clash.compose.FilesScreenKt$FileNameDialog$1$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    switch (i3) {
                                        case 0:
                                            function2.invoke((String) mutableState2.getValue());
                                            break;
                                        default:
                                            function2.invoke((String) mutableState2.getValue());
                                            break;
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        }
                        Function0 function0 = (Function0) objRememberedValue2;
                        gapComposer2.end(false);
                        final AppColors appColors2 = this.$colors;
                        final int i4 = 1;
                        final boolean z2 = this.$isValid;
                        ScrimKt.TextButton(function0, null, z2, null, null, null, Thread_jvmKt.rememberComposableLambda(883573995, new Function3() { // from class: com.github.kr328.clash.compose.FilesScreenKt.FileNameDialog.1.2
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj3, Object obj4, Object obj5) {
                                switch (i4) {
                                    case 0:
                                        GapComposer gapComposer3 = (GapComposer) obj4;
                                        if ((((Number) obj5).intValue() & 17) == 16 && gapComposer3.getSkipping()) {
                                            gapComposer3.skipToGroupEnd();
                                        } else {
                                            String strStringResource = StringResources_androidKt.stringResource(R.string.ok, gapComposer3);
                                            boolean z3 = z2;
                                            AppColors appColors3 = appColors2;
                                            TextKt.m275TextNvy7gAk(strStringResource, null, z3 ? appColors3.textPrimary : appColors3.textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer3, 0, 0, 262138);
                                        }
                                        break;
                                    default:
                                        GapComposer gapComposer4 = (GapComposer) obj4;
                                        if ((((Number) obj5).intValue() & 17) == 16 && gapComposer4.getSkipping()) {
                                            gapComposer4.skipToGroupEnd();
                                        } else {
                                            String strStringResource2 = StringResources_androidKt.stringResource(R.string.ok, gapComposer4);
                                            boolean z4 = z2;
                                            AppColors appColors4 = appColors2;
                                            TextKt.m275TextNvy7gAk(strStringResource2, null, z4 ? appColors4.textPrimary : appColors4.textSecondary, 0L, null, FontWeight.SemiBold, 0L, null, 0L, 0, false, 0, 0, null, gapComposer4, 1572864, 0, 262074);
                                        }
                                        break;
                                }
                                return Unit.INSTANCE;
                            }
                        }, gapComposer2), gapComposer2, 805306368, 506);
                    }
                    break;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.compose.FilesScreenKt$FileNameDialog$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass4 implements Function2 {
        public final /* synthetic */ Object $colors;
        public final /* synthetic */ boolean $isValid;
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Object $value$delegate;

        public /* synthetic */ AnonymousClass4(int i, Object obj, Object obj2, boolean z) {
            this.$r8$classId = i;
            this.$isValid = z;
            this.$colors = obj;
            this.$value$delegate = obj2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            Object failure;
            int i = this.$r8$classId;
            int i2 = 12;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Object obj3 = this.$value$delegate;
            Object obj4 = this.$colors;
            boolean z = this.$isValid;
            switch (i) {
                case 0:
                    GapComposer gapComposer = (GapComposer) obj;
                    MutableState mutableState = (MutableState) obj3;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
                        gapComposer.skipToGroupEnd();
                    } else {
                        String str = (String) mutableState.getValue();
                        boolean z2 = !z;
                        ComposableLambdaImpl composableLambdaImpl = z ? null : ComposableSingletons$FilesScreenKt.f13lambda1;
                        OutlinedTextFieldDefaults outlinedTextFieldDefaults = OutlinedTextFieldDefaults.INSTANCE;
                        AppColors appColors = (AppColors) obj4;
                        long j = appColors.buttonColor;
                        long j2 = appColors.cardBorder;
                        long j3 = appColors.textPrimary;
                        TextFieldColors textFieldColorsM252colors0hiis_0 = OutlinedTextFieldDefaults.m252colors0hiis_0(j3, j3, j3, j, j2, gapComposer);
                        Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                        gapComposer.startReplaceGroup(-13240173);
                        Object objRememberedValue = gapComposer.rememberedValue();
                        if (objRememberedValue == Composer$Companion.Empty) {
                            objRememberedValue = new TooltipKt$$ExternalSyntheticLambda7(mutableState, i2);
                            gapComposer.updateRememberedValue(objRememberedValue);
                        }
                        gapComposer.end(false);
                        OutlinedTextFieldKt.OutlinedTextField(str, (Function1) objRememberedValue, modifierFillMaxWidth, false, null, null, composableLambdaImpl, z2, null, null, null, true, 0, 0, null, textFieldColorsM252colors0hiis_0, gapComposer, 432, 4050936);
                    }
                    break;
                case 1:
                    GapComposer gapComposer2 = (GapComposer) obj;
                    ConnectionInfo connectionInfo = (ConnectionInfo) obj3;
                    ConnectionMetadata connectionMetadata = (ConnectionMetadata) obj4;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        gapComposer2.startReplaceGroup(1427252517);
                        String str2 = connectionMetadata.network;
                        String str3 = connectionMetadata.type;
                        if (str2.length() > 0) {
                            ConnectionsScreenKt.DetailRow(StringResources_androidKt.stringResource(R.string.connection_network_type, gapComposer2), connectionMetadata.network.toUpperCase(Locale.ROOT), gapComposer2, 0);
                        }
                        gapComposer2.end(false);
                        gapComposer2.startReplaceGroup(1427257391);
                        if (str3.length() > 0) {
                            ConnectionsScreenKt.DetailRow(StringResources_androidKt.stringResource(R.string.connection_protocol, gapComposer2), str3, gapComposer2, 0);
                        }
                        gapComposer2.end(false);
                        long jAccess$parseStartTime = ConnectionsScreenKt.access$parseStartTime(connectionInfo.start);
                        gapComposer2.startReplaceGroup(1427263736);
                        if (jAccess$parseStartTime > 0) {
                            String strStringResource = StringResources_androidKt.stringResource(R.string.connection_start_time, gapComposer2);
                            try {
                                failure = Instant.ofEpochMilli(jAccess$parseStartTime).atZone(ZoneId.systemDefault()).format(ConnectionsScreenKt.timeFormatter);
                            } catch (Throwable th) {
                                failure = new Result.Failure(th);
                            }
                            if (failure instanceof Result.Failure) {
                                failure = "—";
                            }
                            ConnectionsScreenKt.DetailRow(strStringResource, (String) failure, gapComposer2, 0);
                            if (!z) {
                                ConnectionsScreenKt.DetailRow(StringResources_androidKt.stringResource(R.string.connection_duration, gapComposer2), ConnectionsScreenKt.access$formatDuration(jAccess$parseStartTime), gapComposer2, 0);
                            }
                        }
                        gapComposer2.end(false);
                        ConnectionsScreenKt.DetailRow(StringResources_androidKt.stringResource(R.string.connection_id, gapComposer2), StringsKt.take(connectionInfo.id, 8).concat("…"), gapComposer2, 0);
                    }
                    break;
                case 2:
                    GapComposer gapComposer3 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer3.getSkipping()) {
                        gapComposer3.skipToGroupEnd();
                    } else {
                        TextKt.m275TextNvy7gAk((String) obj3, OffsetKt.m128padding3ABfNKs(z ? SizeKt.wrapContentWidth$default() : SizeKt.fillMaxWidth(companion, 1.0f), 12), ((AppColors) obj4).textPrimary, 0L, null, FontWeight.Medium, 0L, new TextAlign(3), 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer3.consume(MaterialThemeKt._localMaterialTheme)).typography.bodySmall, gapComposer3, 1572864, 0, 129976);
                    }
                    break;
                default:
                    GapComposer gapComposer4 = (GapComposer) obj;
                    if ((3 & ((Number) obj2).intValue()) == 2 && gapComposer4.getSkipping()) {
                        gapComposer4.skipToGroupEnd();
                    } else {
                        Modifier modifierM51clickableoSLSa3U$default = ImageKt.m51clickableoSLSa3U$default(SizeKt.FillWholeMaxSize, z, null, (Function0) obj4, 14);
                        ComposableLambdaImpl composableLambdaImpl2 = (ComposableLambdaImpl) obj3;
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                        MenuHostHelper menuHostHelper = gapComposer4.applier;
                        long j4 = gapComposer4.compositeKeyHashCode;
                        int i3 = (int) (j4 ^ (j4 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer4.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer4, modifierM51clickableoSLSa3U$default);
                        ComposeUiNode.Companion.getClass();
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                        gapComposer4.startReusableNode();
                        if (gapComposer4.inserting) {
                            gapComposer4.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer4.useNode();
                        }
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$1 = ComposeUiNode.Companion.SetMeasurePolicy;
                        Stack.m295setimpl(gapComposer4, measurePolicyMaybeCachedBoxMeasurePolicy, composeUiNode$Companion$SetModifier$1);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                        Stack.m295setimpl(gapComposer4, persistentCompositionLocalMapCurrentCompositionLocalScope, composeUiNode$Companion$SetModifier$2);
                        Integer numValueOf = Integer.valueOf(i3);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
                        Stack.m295setimpl(gapComposer4, numValueOf, composeUiNode$Companion$SetModifier$3);
                        OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
                        Stack.m294reconcileimpl(gapComposer4, ownerSnapshotObserver$onCommitAffectingLayout$1);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
                        Stack.m295setimpl(gapComposer4, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
                        Modifier modifierM129paddingVpY3zN4 = OffsetKt.m129paddingVpY3zN4(SizeKt.fillMaxWidth(companion, 1.0f).then(new SizeElement(0.0f, (1 & 1) != 0 ? Float.NaN : 64, 0.0f, (1 & 2) != 0 ? Float.NaN : 0.0f, 5)), 16, 12);
                        RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.CenterVertically, gapComposer4, 48);
                        long j5 = gapComposer4.compositeKeyHashCode;
                        int i4 = (int) (j5 ^ (j5 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer4.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer4, modifierM129paddingVpY3zN4);
                        gapComposer4.startReusableNode();
                        if (gapComposer4.inserting) {
                            gapComposer4.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer4.useNode();
                        }
                        Stack.m295setimpl(gapComposer4, rowMeasurePolicy, composeUiNode$Companion$SetModifier$1);
                        Stack.m295setimpl(gapComposer4, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
                        Modifier.CC.m(i4, gapComposer4, composeUiNode$Companion$SetModifier$3, gapComposer4, ownerSnapshotObserver$onCommitAffectingLayout$1);
                        Stack.m295setimpl(gapComposer4, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
                        composableLambdaImpl2.invoke((Object) RowScopeInstance.INSTANCE, (Object) gapComposer4, (Object) 6);
                        gapComposer4.end(true);
                        gapComposer4.end(true);
                    }
                    break;
            }
            return Unit.INSTANCE;
        }

        public AnonymousClass4(ConnectionMetadata connectionMetadata, ConnectionInfo connectionInfo, boolean z) {
            this.$r8$classId = 1;
            this.$colors = connectionMetadata;
            this.$value$delegate = connectionInfo;
            this.$isValid = z;
        }

        public AnonymousClass4(AppColors appColors, boolean z, String str) {
            this.$r8$classId = 2;
            this.$colors = appColors;
            this.$isValid = z;
            this.$value$delegate = str;
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.compose.FilesScreenKt$FileRow$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass2 implements Function2 {
        public final /* synthetic */ Object $colors;
        public final /* synthetic */ Object $file;
        public final /* synthetic */ Object $formatter;
        public final /* synthetic */ Object $onClick;
        public final /* synthetic */ Object $onMore;
        public final /* synthetic */ int $r8$classId = 2;

        public AnonymousClass2(Context context, ManagedActivityResultLauncher managedActivityResultLauncher, PaddingValues paddingValues, MutableState mutableState, MutableState mutableState2) {
            this.$onClick = context;
            this.$onMore = managedActivityResultLauncher;
            this.$file = paddingValues;
            this.$colors = mutableState;
            this.$formatter = mutableState2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            String str;
            int i = this.$r8$classId;
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Object obj3 = this.$onMore;
            Object obj4 = this.$formatter;
            Object obj5 = this.$onClick;
            Object obj6 = this.$file;
            Object obj7 = this.$colors;
            int i2 = 1;
            switch (i) {
                case 0:
                    GapComposer gapComposer = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
                        gapComposer.skipToGroupEnd();
                    } else {
                        float f = 16;
                        Modifier modifierM129paddingVpY3zN4 = OffsetKt.m129paddingVpY3zN4(ImageKt.m51clickableoSLSa3U$default(SizeKt.fillMaxWidth(companion, 1.0f), false, null, (Function0) obj5, 15), f, 12);
                        File file = (File) obj6;
                        AppColors appColors = (AppColors) obj7;
                        Function0 function0 = (Function0) obj3;
                        DateFormat dateFormat = (DateFormat) obj4;
                        RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.CenterVertically, gapComposer, 48);
                        long j = gapComposer.compositeKeyHashCode;
                        int i3 = (int) (j ^ (j >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifierM129paddingVpY3zN4);
                        ComposeUiNode.Companion.getClass();
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                        gapComposer.startReusableNode();
                        if (gapComposer.inserting) {
                            gapComposer.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer.useNode();
                        }
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$1 = ComposeUiNode.Companion.SetMeasurePolicy;
                        Stack.m295setimpl(gapComposer, rowMeasurePolicy, composeUiNode$Companion$SetModifier$1);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                        Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, composeUiNode$Companion$SetModifier$2);
                        Integer numValueOf = Integer.valueOf(i3);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
                        Stack.m295setimpl(gapComposer, numValueOf, composeUiNode$Companion$SetModifier$3);
                        OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
                        Stack.m294reconcileimpl(gapComposer, ownerSnapshotObserver$onCommitAffectingLayout$1);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
                        Stack.m295setimpl(gapComposer, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
                        boolean z = file.isDirectory;
                        long j2 = file.lastModified;
                        IconKt.m249Iconww6aTOc(z ? FolderKt.getFolder() : DescriptionKt.getDescription(), null, SizeKt.m140size3ABfNKs(companion, 28), appColors.textPrimary, gapComposer, 432, 0);
                        OffsetKt.Spacer(gapComposer, SizeKt.m144width3ABfNKs(companion, f));
                        if (1.0f <= 0.0d) {
                            InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                        }
                        LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
                        ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, gapComposer, 0);
                        long j3 = gapComposer.compositeKeyHashCode;
                        int i4 = (int) (j3 ^ (j3 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer, layoutWeightElement);
                        gapComposer.startReusableNode();
                        if (gapComposer.inserting) {
                            gapComposer.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer.useNode();
                        }
                        Stack.m295setimpl(gapComposer, columnMeasurePolicy, composeUiNode$Companion$SetModifier$1);
                        Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
                        Modifier.CC.m(i4, gapComposer, composeUiNode$Companion$SetModifier$3, gapComposer, ownerSnapshotObserver$onCommitAffectingLayout$1);
                        Stack.m295setimpl(gapComposer, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
                        String str2 = file.name;
                        StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                        TextKt.m275TextNvy7gAk(str2, null, appColors.textPrimary, 0L, null, null, 0L, null, 0L, 0, false, 1, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.titleMedium, gapComposer, 0, 24576, 114682);
                        if (!file.isDirectory) {
                            gapComposer.startReplaceGroup(-1984935847);
                            long j4 = file.size;
                            double d = j4;
                            if (d > 1.15292150460684698E18d) {
                                double d2 = 1024;
                                str = String.format(Locale.US, "%.1f EB", Arrays.copyOf(new Object[]{Double.valueOf((((((d / d2) / d2) / d2) / d2) / d2) / d2)}, 1));
                            } else if (d > 1.125899906842624E15d) {
                                double d3 = 1024;
                                str = String.format(Locale.US, "%.1f PB", Arrays.copyOf(new Object[]{Double.valueOf(((((d / d3) / d3) / d3) / d3) / d3)}, 1));
                            } else if (d > 1.099511627776E12d) {
                                double d4 = 1024;
                                str = String.format(Locale.US, "%.1f TB", Arrays.copyOf(new Object[]{Double.valueOf((((d / d4) / d4) / d4) / d4)}, 1));
                            } else if (j4 > 1073741824) {
                                double d5 = 1024;
                                str = String.format(Locale.US, "%.1f GB", Arrays.copyOf(new Object[]{Double.valueOf(((d / d5) / d5) / d5)}, 1));
                            } else if (j4 > 1048576) {
                                double d6 = 1024;
                                str = String.format(Locale.US, "%.1f MB", Arrays.copyOf(new Object[]{Double.valueOf((d / d6) / d6)}, 1));
                            } else if (j4 > 1024) {
                                str = String.format(Locale.US, "%.1f KB", Arrays.copyOf(new Object[]{Double.valueOf(d / ((double) 1024))}, 1));
                            } else {
                                str = j4 + " Bytes";
                            }
                            TextKt.m275TextNvy7gAk(ImageAnalysis$$ExternalSyntheticLambda1.m(str, " · ", dateFormat.format(Long.valueOf(j2))), null, appColors.textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.bodySmall, gapComposer, 0, 0, 131066);
                            gapComposer.end(false);
                        } else if (j2 > 0) {
                            gapComposer.startReplaceGroup(-1984613571);
                            TextKt.m275TextNvy7gAk(dateFormat.format(Long.valueOf(j2)), null, appColors.textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.bodySmall, gapComposer, 0, 0, 131066);
                            gapComposer.end(false);
                        } else {
                            gapComposer.startReplaceGroup(-1984366594);
                            gapComposer.end(false);
                        }
                        gapComposer.end(true);
                        ScrimKt.IconButton(function0, null, false, null, null, Thread_jvmKt.rememberComposableLambda(-408680969, new LogsScreenKt.AnonymousClass6(appColors, 4), gapComposer), gapComposer, 1572864, 62);
                        gapComposer.end(true);
                    }
                    break;
                case 1:
                    GapComposer gapComposer2 = (GapComposer) obj;
                    String str3 = (String) obj3;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else if (str3 != null && !StringsKt.isBlank(str3)) {
                        gapComposer2.startReplaceGroup(-693740619);
                        boolean zChanged = gapComposer2.changed(str3) | gapComposer2.changedInstance((Context) obj6) | gapComposer2.changedInstance((CoroutineScope) obj7) | gapComposer2.changed((SnackbarHostState) obj4) | gapComposer2.changed((Function0) obj5);
                        String str4 = (String) obj3;
                        Context context = (Context) obj6;
                        CoroutineScope coroutineScope = (CoroutineScope) obj7;
                        Function0 function1 = (Function0) obj5;
                        SnackbarHostState snackbarHostState = (SnackbarHostState) obj4;
                        Object objRememberedValue = gapComposer2.rememberedValue();
                        if (zChanged || objRememberedValue == neverEqualPolicy) {
                            HwidLimitDialogKt$HwidLimitDialog$2$$ExternalSyntheticLambda0 hwidLimitDialogKt$HwidLimitDialog$2$$ExternalSyntheticLambda0 = new HwidLimitDialogKt$HwidLimitDialog$2$$ExternalSyntheticLambda0(str4, context, coroutineScope, function1, snackbarHostState);
                            gapComposer2.updateRememberedValue(hwidLimitDialogKt$HwidLimitDialog$2$$ExternalSyntheticLambda0);
                            objRememberedValue = hwidLimitDialogKt$HwidLimitDialog$2$$ExternalSyntheticLambda0;
                        }
                        gapComposer2.end(false);
                        ScrimKt.TextButton((Function0) objRememberedValue, null, false, null, null, null, ComposableSingletons$HwidLimitDialogKt.f15lambda2, gapComposer2, 805306368, 510);
                    }
                    break;
                case 2:
                    GapComposer gapComposer3 = (GapComposer) obj;
                    PaddingValues paddingValues = (PaddingValues) obj6;
                    ManagedActivityResultLauncher managedActivityResultLauncher = (ManagedActivityResultLauncher) obj3;
                    Context context2 = (Context) obj5;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer3.getSkipping()) {
                        gapComposer3.skipToGroupEnd();
                    } else {
                        gapComposer3.startReplaceGroup(-1845085660);
                        MutableState mutableState = (MutableState) obj7;
                        Object objRememberedValue2 = gapComposer3.rememberedValue();
                        if (objRememberedValue2 == neverEqualPolicy) {
                            objRememberedValue2 = new TooltipKt$$ExternalSyntheticLambda0(mutableState, 15);
                            gapComposer3.updateRememberedValue(objRememberedValue2);
                        }
                        Function0 function2 = (Function0) objRememberedValue2;
                        gapComposer3.end(false);
                        gapComposer3.startReplaceGroup(-1845081258);
                        boolean zChangedInstance = gapComposer3.changedInstance(context2) | gapComposer3.changedInstance(managedActivityResultLauncher);
                        Object objRememberedValue3 = gapComposer3.rememberedValue();
                        if (zChangedInstance || objRememberedValue3 == neverEqualPolicy) {
                            objRememberedValue3 = new TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda15(context2, managedActivityResultLauncher, 1);
                            gapComposer3.updateRememberedValue(objRememberedValue3);
                        }
                        Function0 function3 = (Function0) objRememberedValue3;
                        gapComposer3.end(false);
                        gapComposer3.startReplaceGroup(-1845071480);
                        boolean zChangedInstance2 = gapComposer3.changedInstance(context2);
                        Object objRememberedValue4 = gapComposer3.rememberedValue();
                        if (zChangedInstance2 || objRememberedValue4 == neverEqualPolicy) {
                            objRememberedValue4 = new TvMainAppKt$TvMainApp$3$$ExternalSyntheticLambda2(context2, i2);
                            gapComposer3.updateRememberedValue(objRememberedValue4);
                        }
                        Function0 function4 = (Function0) objRememberedValue4;
                        gapComposer3.end(false);
                        gapComposer3.startReplaceGroup(-1845069117);
                        MutableState mutableState2 = (MutableState) obj4;
                        Object objRememberedValue5 = gapComposer3.rememberedValue();
                        if (objRememberedValue5 == neverEqualPolicy) {
                            objRememberedValue5 = new TooltipKt$$ExternalSyntheticLambda0(mutableState2, 16);
                            gapComposer3.updateRememberedValue(objRememberedValue5);
                        }
                        gapComposer3.end(false);
                        HomeScreenKt.HomeScreen(function2, function3, function4, (Function0) objRememberedValue5, OffsetKt.m124PaddingValuesa9UjIt4$default(0.0f, paddingValues.mo120calculateTopPaddingD9Ej5fM(), 0.0f, paddingValues.mo117calculateBottomPaddingD9Ej5fM(), 5), null, null, false, gapComposer3, 3078, 224);
                    }
                    break;
                default:
                    GapComposer gapComposer4 = (GapComposer) obj;
                    AppColors appColors2 = (AppColors) obj7;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer4.getSkipping()) {
                        gapComposer4.skipToGroupEnd();
                    } else {
                        Modifier modifierThen = companion.then(new HazeEffectNodeElement((HazeState) obj6, BackHandlerKt.m6thinIv8Zu3U(gapComposer4)));
                        PaddingValuesImpl paddingValuesImpl = TopAppBarDefaults.ContentPadding;
                        long j5 = Color.Transparent;
                        long j6 = appColors2.textPrimary;
                        AppBarKt.m238TopAppBargNPyAyM(Thread_jvmKt.rememberComposableLambda(-854995043, new LogsScreenKt.AnonymousClass6(appColors2, 19), gapComposer4), modifierThen, Thread_jvmKt.rememberComposableLambda(-1102963237, new LogsScreenKt.AnonymousClass2((Function0) obj5, appColors2, 11), gapComposer4), Thread_jvmKt.rememberComposableLambda(842798674, new LogsScreenKt.AnonymousClass1.AnonymousClass3((List) obj4, (Function0) obj3, appColors2, i2), gapComposer4), 0.0f, null, TopAppBarDefaults.m278topAppBarColors5tl4gsc(j5, j5, j6, j6, j6, gapComposer4, 32), null, gapComposer4, 3462, 432);
                    }
                    break;
            }
            return Unit.INSTANCE;
        }

        public AnonymousClass2(HazeState hazeState, AppColors appColors, Function0 function0, List list, Function0 function1) {
            this.$file = hazeState;
            this.$colors = appColors;
            this.$onClick = function0;
            this.$formatter = list;
            this.$onMore = function1;
        }

        public AnonymousClass2(String str, Context context, CoroutineScope coroutineScope, Function0 function0, SnackbarHostState snackbarHostState) {
            this.$onMore = str;
            this.$file = context;
            this.$colors = coroutineScope;
            this.$formatter = snackbarHostState;
            this.$onClick = function0;
        }

        public AnonymousClass2(Function0 function0, File file, AppColors appColors, Function0 function1, DateFormat dateFormat) {
            this.$onClick = function0;
            this.$file = file;
            this.$colors = appColors;
            this.$onMore = function1;
            this.$formatter = dateFormat;
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.compose.FilesScreenKt$FilesScreen$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class C00191 implements Function2 {
        public final /* synthetic */ Object $colors;
        public final /* synthetic */ boolean $currentInBaseDir;
        public final /* synthetic */ boolean $isTv;
        public final /* synthetic */ Object $onAction;
        public final /* synthetic */ Object $onNavigateBack;
        public final /* synthetic */ int $r8$classId = 1;

        public C00191(Profile profile, boolean z, boolean z2, MutableState mutableState, MutableState mutableState2) {
            this.$colors = profile;
            this.$isTv = z;
            this.$currentInBaseDir = z2;
            this.$onNavigateBack = mutableState;
            this.$onAction = mutableState2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            int i = this.$r8$classId;
            Object obj3 = this.$onAction;
            Object obj4 = this.$onNavigateBack;
            final boolean z = this.$isTv;
            Object obj5 = this.$colors;
            final boolean z2 = this.$currentInBaseDir;
            switch (i) {
                case 0:
                    GapComposer gapComposer = (GapComposer) obj;
                    int iIntValue = ((Number) obj2).intValue();
                    final AppColors appColors = (AppColors) obj5;
                    long j = appColors.appBackground;
                    if ((iIntValue & 3) == 2 && gapComposer.getSkipping()) {
                        gapComposer.skipToGroupEnd();
                    } else {
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Thread_jvmKt.rememberComposableLambda(-589907539, new LogsScreenKt.AnonymousClass6(appColors, 5), gapComposer);
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda2 = Thread_jvmKt.rememberComposableLambda(-102833813, new LogsScreenKt.AnonymousClass2((Function0) obj4, appColors, 4), gapComposer);
                        final Function1 function1 = (Function1) obj3;
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda3 = Thread_jvmKt.rememberComposableLambda(1870947490, new Function3() { // from class: com.github.kr328.clash.compose.FilesScreenKt.FilesScreen.1.3
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj6, Object obj7, Object obj8) {
                                GapComposer gapComposer2 = (GapComposer) obj7;
                                if ((((Number) obj8).intValue() & 17) == 16 && gapComposer2.getSkipping()) {
                                    gapComposer2.skipToGroupEnd();
                                } else if (!z2) {
                                    gapComposer2.startReplaceGroup(1746970543);
                                    Function1 function2 = function1;
                                    boolean zChanged = gapComposer2.changed(function2);
                                    Object objRememberedValue = gapComposer2.rememberedValue();
                                    if (zChanged || objRememberedValue == Composer$Companion.Empty) {
                                        objRememberedValue = new FilesScreenKt$FilesScreen$1$3$$ExternalSyntheticLambda0(function2, 0);
                                        gapComposer2.updateRememberedValue(objRememberedValue);
                                    }
                                    gapComposer2.end(false);
                                    ScrimKt.IconButton((Function0) objRememberedValue, null, false, null, null, Thread_jvmKt.rememberComposableLambda(-876356901, new LogsScreenKt.AnonymousClass6(appColors, 7), gapComposer2), gapComposer2, 1572864, 62);
                                }
                                return Unit.INSTANCE;
                            }
                        }, gapComposer);
                        PaddingValuesImpl paddingValuesImpl = TopAppBarDefaults.ContentPadding;
                        long j2 = z ? j : Color.Transparent;
                        if (!z) {
                            j = Color.Transparent;
                        }
                        long j3 = j;
                        long j4 = appColors.textPrimary;
                        AppBarKt.m238TopAppBargNPyAyM(composableLambdaImplRememberComposableLambda, null, composableLambdaImplRememberComposableLambda2, composableLambdaImplRememberComposableLambda3, 0.0f, null, TopAppBarDefaults.m278topAppBarColors5tl4gsc(j2, j3, j4, j4, j4, gapComposer, 32), null, gapComposer, 3462, 434);
                    }
                    break;
                default:
                    GapComposer gapComposer2 = (GapComposer) obj;
                    Profile profile = (Profile) obj5;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        ImageVector inbox = InboxKt.getInbox();
                        String strStringResource = StringResources_androidKt.stringResource(R.string.profile_url, gapComposer2);
                        String str = profile.source;
                        String strStringResource2 = StringResources_androidKt.stringResource(R.string.url, gapComposer2);
                        gapComposer2.startReplaceGroup(1926042331);
                        boolean zChanged = gapComposer2.changed(z);
                        final MutableState mutableState = (MutableState) obj4;
                        Object objRememberedValue = gapComposer2.rememberedValue();
                        final int i2 = 0;
                        NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
                        if (zChanged || objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = new Function0() { // from class: com.github.kr328.clash.compose.PropertiesScreenKt$PropertiesScreen$3$1$2$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    switch (i2) {
                                        case 0:
                                            if (z) {
                                                mutableState.setValue(Boolean.TRUE);
                                            }
                                            break;
                                        default:
                                            if (z) {
                                                mutableState.setValue(Boolean.TRUE);
                                            }
                                            break;
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        }
                        gapComposer2.end(false);
                        PropertiesScreenKt.FieldRow(inbox, strStringResource, str, strStringResource2, this.$isTv, (Function0) objRememberedValue, gapComposer2, 0);
                        gapComposer2.startReplaceGroup(1926045099);
                        if (z) {
                            PropertiesScreenKt.HelperText(StringResources_androidKt.stringResource(R.string.accept_http_content, gapComposer2), gapComposer2, 0);
                        }
                        gapComposer2.end(false);
                        ImageVector imageVectorBuild = UpdateKt._update;
                        if (imageVectorBuild == null) {
                            ImageVector.Builder builder = new ImageVector.Builder("Outlined.Update", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                            int i3 = VectorKt.$r8$clinit;
                            SolidColor solidColor = new SolidColor(Color.Black);
                            Quirks quirks = new Quirks();
                            quirks.moveTo(11.0f, 8.0f);
                            quirks.verticalLineToRelative(5.0f);
                            quirks.lineToRelative(4.25f, 2.52f);
                            quirks.lineToRelative(0.77f, -1.28f);
                            quirks.lineToRelative(-3.52f, -2.09f);
                            quirks.verticalLineTo(8.0f);
                            quirks.horizontalLineTo(11.0f);
                            quirks.close();
                            quirks.moveTo(21.0f, 10.0f);
                            quirks.verticalLineTo(3.0f);
                            quirks.lineToRelative(-2.64f, 2.64f);
                            quirks.curveTo(16.74f, 4.01f, 14.49f, 3.0f, 12.0f, 3.0f);
                            quirks.curveToRelative(-4.97f, 0.0f, -9.0f, 4.03f, -9.0f, 9.0f);
                            quirks.reflectiveCurveToRelative(4.03f, 9.0f, 9.0f, 9.0f);
                            quirks.reflectiveCurveToRelative(9.0f, -4.03f, 9.0f, -9.0f);
                            quirks.horizontalLineToRelative(-2.0f);
                            quirks.curveToRelative(0.0f, 3.86f, -3.14f, 7.0f, -7.0f, 7.0f);
                            quirks.reflectiveCurveToRelative(-7.0f, -3.14f, -7.0f, -7.0f);
                            quirks.reflectiveCurveToRelative(3.14f, -7.0f, 7.0f, -7.0f);
                            quirks.curveToRelative(1.93f, 0.0f, 3.68f, 0.79f, 4.95f, 2.05f);
                            quirks.lineTo(14.0f, 10.0f);
                            quirks.horizontalLineTo(21.0f);
                            quirks.close();
                            ImageVector.Builder.m502addPathoIyEayM$default(builder, quirks.mQuirks, solidColor);
                            imageVectorBuild = builder.build();
                            UpdateKt._update = imageVectorBuild;
                        }
                        ImageVector imageVector = imageVectorBuild;
                        String strStringResource3 = StringResources_androidKt.stringResource(R.string.auto_update, gapComposer2);
                        gapComposer2.startReplaceGroup(1926055144);
                        long j5 = profile.interval;
                        final int i4 = 1;
                        String string = j5 == 0 ? "" : ((Resources) gapComposer2.consume(AndroidCompositionLocals_androidKt.LocalResources)).getString(R.string.format_minutes, Arrays.copyOf(new Object[]{Integer.valueOf((int) TimeUnit.MILLISECONDS.toMinutes(j5))}, 1));
                        gapComposer2.end(false);
                        String strStringResource4 = StringResources_androidKt.stringResource(R.string.disabled, gapComposer2);
                        gapComposer2.startReplaceGroup(1926070885);
                        boolean zChanged2 = gapComposer2.changed(z2);
                        final MutableState mutableState2 = (MutableState) obj3;
                        Object objRememberedValue2 = gapComposer2.rememberedValue();
                        if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                            objRememberedValue2 = new Function0() { // from class: com.github.kr328.clash.compose.PropertiesScreenKt$PropertiesScreen$3$1$2$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    switch (i4) {
                                        case 0:
                                            if (z2) {
                                                mutableState2.setValue(Boolean.TRUE);
                                            }
                                            break;
                                        default:
                                            if (z2) {
                                                mutableState2.setValue(Boolean.TRUE);
                                            }
                                            break;
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        }
                        gapComposer2.end(false);
                        PropertiesScreenKt.FieldRow(imageVector, strStringResource3, string, strStringResource4, this.$currentInBaseDir, (Function0) objRememberedValue2, gapComposer2, 0);
                    }
                    break;
            }
            return Unit.INSTANCE;
        }

        public C00191(boolean z, AppColors appColors, Function0 function0, boolean z2, Function1 function1) {
            this.$isTv = z;
            this.$colors = appColors;
            this.$onNavigateBack = function0;
            this.$currentInBaseDir = z2;
            this.$onAction = function1;
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.compose.FilesScreenKt$FilesScreen$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class C00202 implements Function3 {
        public final /* synthetic */ AppColors $colors;
        public final /* synthetic */ Object $files;
        public final /* synthetic */ boolean $isTv;
        public final /* synthetic */ Object $menuTarget$delegate;
        public final /* synthetic */ Object $onAction;
        public final /* synthetic */ int $r8$classId = 2;

        public C00202(ConnectionMetadata connectionMetadata, AppColors appColors, ConnectionInfo connectionInfo, boolean z, Function0 function0) {
            this.$files = connectionMetadata;
            this.$colors = appColors;
            this.$onAction = connectionInfo;
            this.$isTv = z;
            this.$menuTarget$delegate = function0;
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            PaddingValuesImpl paddingValuesImpl;
            String strStringResource;
            AppColors appColors;
            long j;
            boolean z;
            boolean z2;
            switch (this.$r8$classId) {
                case 0:
                    PaddingValues paddingValues = (PaddingValues) obj;
                    GapComposer gapComposer = (GapComposer) obj2;
                    int iIntValue = ((Number) obj3).intValue();
                    Function1 function1 = (Function1) this.$onAction;
                    List list = (List) this.$files;
                    if ((iIntValue & 6) == 0) {
                        iIntValue |= gapComposer.changed(paddingValues) ? 4 : 2;
                    }
                    if ((iIntValue & 19) == 18 && gapComposer.getSkipping()) {
                        gapComposer.skipToGroupEnd();
                    } else {
                        Modifier modifierM47backgroundbw27NRU = ImageKt.m47backgroundbw27NRU(SizeKt.FillWholeMaxSize, this.$colors.appBackground, BrushKt.RectangleShape);
                        boolean z3 = this.$isTv;
                        Modifier modifierM132paddingqDBjuR0$default = Modifier.Companion.$$INSTANCE;
                        if (z3) {
                            modifierM132paddingqDBjuR0$default = OffsetKt.m132paddingqDBjuR0$default(modifierM132paddingqDBjuR0$default, 0.0f, paddingValues.mo120calculateTopPaddingD9Ej5fM(), 0.0f, paddingValues.mo117calculateBottomPaddingD9Ej5fM(), 5);
                        }
                        Modifier modifierThen = modifierM47backgroundbw27NRU.then(modifierM132paddingqDBjuR0$default);
                        if (z3) {
                            float f = 16;
                            float f2 = 8;
                            paddingValuesImpl = new PaddingValuesImpl(f, f2, f, f2);
                        } else {
                            float f3 = 16;
                            paddingValuesImpl = new PaddingValuesImpl(f3, paddingValues.mo120calculateTopPaddingD9Ej5fM() + 8, f3, paddingValues.mo117calculateBottomPaddingD9Ej5fM() + f3);
                        }
                        Arrangement.SpacedAligned spacedAlignedM111spacedBy0680j_4 = Arrangement.m111spacedBy0680j_4(8);
                        gapComposer.startReplaceGroup(-1153510309);
                        boolean zChangedInstance = gapComposer.changedInstance(list) | gapComposer.changed(function1);
                        MutableState mutableState = (MutableState) this.$menuTarget$delegate;
                        Object objRememberedValue = gapComposer.rememberedValue();
                        if (zChangedInstance || objRememberedValue == Composer$Companion.Empty) {
                            objRememberedValue = new FilesScreenKt$FilesScreen$2$$ExternalSyntheticLambda0(list, function1, mutableState, 0);
                            gapComposer.updateRememberedValue(objRememberedValue);
                        }
                        gapComposer.end(false);
                        LazyDslKt.LazyColumn(modifierThen, null, paddingValuesImpl, false, spacedAlignedM111spacedBy0680j_4, null, null, false, null, (Function1) objRememberedValue, gapComposer, 24576, 490);
                    }
                    break;
                case 1:
                    GapComposer gapComposer2 = (GapComposer) obj2;
                    if ((((Number) obj3).intValue() & 17) == 16 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        boolean z4 = this.$isTv;
                        AppColors appColors2 = this.$colors;
                        if (z4) {
                            gapComposer2.startReplaceGroup(776576310);
                            ScrimKt.IconButton((Function0) this.$files, null, false, null, null, Thread_jvmKt.rememberComposableLambda(-1468712690, new LogsScreenKt.AnonymousClass6(appColors2, 9), gapComposer2), gapComposer2, 1572864, 62);
                            gapComposer2.end(false);
                        } else {
                            gapComposer2.startReplaceGroup(776967530);
                            ScrimKt.IconButton((Function0) this.$onAction, null, false, null, null, Thread_jvmKt.rememberComposableLambda(539743205, new LogsScreenKt.AnonymousClass6(appColors2, 10), gapComposer2), gapComposer2, 1572864, 62);
                            ScrimKt.IconButton((Function0) this.$menuTarget$delegate, null, false, null, null, Thread_jvmKt.rememberComposableLambda(786961294, new LogsScreenKt.AnonymousClass6(appColors2, 11), gapComposer2), gapComposer2, 1572864, 62);
                            gapComposer2.end(false);
                        }
                    }
                    break;
                default:
                    GapComposer gapComposer3 = (GapComposer) obj2;
                    if ((((Number) obj3).intValue() & 17) == 16 && gapComposer3.getSkipping()) {
                        gapComposer3.skipToGroupEnd();
                    } else {
                        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                        Modifier modifierM132paddingqDBjuR0$default2 = OffsetKt.m132paddingqDBjuR0$default(OffsetKt.m130paddingVpY3zN4$default(ImageKt.verticalScroll$default(SizeKt.fillMaxWidth(companion, 1.0f), ImageKt.rememberScrollState(gapComposer3)), 20, 0.0f, 2), 0.0f, 0.0f, 0.0f, 32, 7);
                        float f4 = 12;
                        Arrangement.SpacedAligned spacedAlignedM111spacedBy0680j_5 = Arrangement.m111spacedBy0680j_4(f4);
                        ConnectionMetadata connectionMetadata = (ConnectionMetadata) this.$files;
                        AppColors appColors3 = this.$colors;
                        long j2 = appColors3.destructive;
                        ConnectionInfo connectionInfo = (ConnectionInfo) this.$onAction;
                        Function0 function0 = (Function0) this.$menuTarget$delegate;
                        ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(spacedAlignedM111spacedBy0680j_5, Alignment.Companion.Start, gapComposer3, 6);
                        long j3 = gapComposer3.compositeKeyHashCode;
                        int i = (int) (j3 ^ (j3 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer3.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer3, modifierM132paddingqDBjuR0$default2);
                        ComposeUiNode.Companion.getClass();
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                        gapComposer3.startReusableNode();
                        if (gapComposer3.inserting) {
                            gapComposer3.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer3.useNode();
                        }
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$1 = ComposeUiNode.Companion.SetMeasurePolicy;
                        Stack.m295setimpl(gapComposer3, columnMeasurePolicy, composeUiNode$Companion$SetModifier$1);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                        Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope, composeUiNode$Companion$SetModifier$2);
                        Integer numValueOf = Integer.valueOf(i);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
                        Stack.m295setimpl(gapComposer3, numValueOf, composeUiNode$Companion$SetModifier$3);
                        OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
                        Stack.m294reconcileimpl(gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$1);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
                        Stack.m295setimpl(gapComposer3, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
                        String strDisplayHost = ConnectionsScreenKt.displayHost(connectionMetadata);
                        String str = connectionMetadata.type;
                        String str2 = connectionMetadata.network;
                        StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                        TextKt.m275TextNvy7gAk(strDisplayHost, null, appColors3.textPrimary, 0L, null, FontWeight.Bold, 0L, null, 0L, 2, false, 2, 0, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal)).typography.titleLarge, gapComposer3, 1572864, 24960, 110522);
                        GapComposer gapComposer4 = gapComposer3;
                        float f5 = 8;
                        Arrangement.SpacedAligned spacedAlignedM111spacedBy0680j_6 = Arrangement.m111spacedBy0680j_4(f5);
                        BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                        RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(spacedAlignedM111spacedBy0680j_6, vertical, gapComposer4, 54);
                        long j4 = gapComposer4.compositeKeyHashCode;
                        int i2 = (int) (j4 ^ (j4 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer4.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer4, companion);
                        gapComposer4.startReusableNode();
                        if (gapComposer4.inserting) {
                            gapComposer4.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer4.useNode();
                        }
                        Stack.m295setimpl(gapComposer4, rowMeasurePolicy, composeUiNode$Companion$SetModifier$1);
                        Stack.m295setimpl(gapComposer4, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
                        Modifier.CC.m(i2, gapComposer4, composeUiNode$Companion$SetModifier$3, gapComposer4, ownerSnapshotObserver$onCommitAffectingLayout$1);
                        Stack.m295setimpl(gapComposer4, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
                        boolean z5 = this.$isTv;
                        if (z5) {
                            gapComposer4.startReplaceGroup(1427195144);
                            strStringResource = StringResources_androidKt.stringResource(R.string.connections_closed, gapComposer4);
                            gapComposer4.end(false);
                        } else {
                            gapComposer4.startReplaceGroup(1427197352);
                            strStringResource = StringResources_androidKt.stringResource(R.string.connections_active, gapComposer4);
                            gapComposer4.end(false);
                        }
                        if (z5) {
                            appColors = appColors3;
                            j = appColors.statusClosed;
                        } else {
                            appColors = appColors3;
                            j = appColors.statusActive;
                        }
                        ConnectionsScreenKt.m807StatusBadgeRPmYEkk(strStringResource, j, gapComposer4, 0);
                        gapComposer4.startReplaceGroup(1427202902);
                        if (str2.length() > 0) {
                            ConnectionsScreenKt.m804NetworkBadgeRPmYEkk(str2.toUpperCase(Locale.ROOT), str2.equals("udp") ? appColors.networkUdp : appColors.networkTcp, gapComposer4, 0);
                        }
                        gapComposer4.end(false);
                        gapComposer4.startReplaceGroup(1427211290);
                        if (str.length() > 0) {
                            ConnectionsScreenKt.m804NetworkBadgeRPmYEkk(str.toUpperCase(Locale.ROOT), appColors.textSecondary, gapComposer4, 0);
                        }
                        gapComposer4.end(false);
                        gapComposer4.end(true);
                        AppColors appColors4 = appColors;
                        zzjl.m819GlassSurfaceYxtnGt4(null, f4, null, Thread_jvmKt.rememberComposableLambda(-1955724422, new LogsScreenKt.AnonymousClass1.AnonymousClass3.AnonymousClass2(3, connectionInfo, appColors), gapComposer4), gapComposer4, 196656, 29);
                        ConnectionsScreenKt.DetailSection(StringResources_androidKt.stringResource(R.string.connection_details, gapComposer4), Thread_jvmKt.rememberComposableLambda(1938976095, new AnonymousClass4(connectionMetadata, connectionInfo, z5), gapComposer4), gapComposer4, 48);
                        ConnectionsScreenKt.DetailSection(StringResources_androidKt.stringResource(R.string.connection_section_network, gapComposer4), Thread_jvmKt.rememberComposableLambda(-704326250, new UpdateDialogKt.AnonymousClass3(1, connectionMetadata), gapComposer4), gapComposer4, 48);
                        gapComposer4.startReplaceGroup(237088656);
                        if (connectionInfo.rule.length() > 0 || !connectionInfo.chains.isEmpty() || connectionMetadata.inboundName.length() > 0) {
                            ConnectionsScreenKt.DetailSection(StringResources_androidKt.stringResource(R.string.connection_section_route, gapComposer4), Thread_jvmKt.rememberComposableLambda(-1479574086, new LogsScreenKt.AnonymousClass1.AnonymousClass3.AnonymousClass2(4, connectionInfo, connectionMetadata), gapComposer4), gapComposer4, 48);
                        }
                        gapComposer4.end(false);
                        gapComposer4.startReplaceGroup(237120047);
                        if (z5) {
                            z = false;
                            z2 = true;
                        } else {
                            OffsetKt.Spacer(gapComposer4, SizeKt.m135height3ABfNKs(companion, 4));
                            Modifier modifierM128padding3ABfNKs = OffsetKt.m128padding3ABfNKs(ImageKt.m51clickableoSLSa3U$default(ImageKt.m48borderxT4_qwU(1, BrushKt.Color(Color.m440getRedimpl(j2), Color.m439getGreenimpl(j2), Color.m437getBlueimpl(j2), 0.2f, Color.m438getColorSpaceimpl(j2)), ImageKt.m47backgroundbw27NRU(ClipKt.clip(SizeKt.fillMaxWidth(companion, 1.0f), RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(f4)), BrushKt.Color(Color.m440getRedimpl(j2), Color.m439getGreenimpl(j2), Color.m437getBlueimpl(j2), 0.1f, Color.m438getColorSpaceimpl(j2)), BrushKt.RectangleShape), RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(f4)), false, null, function0, 15), 14);
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                            long j5 = gapComposer4.compositeKeyHashCode;
                            int i3 = (int) (j5 ^ (j5 >>> 32));
                            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope3 = gapComposer4.currentCompositionLocalScope();
                            Modifier modifierMaterializeModifier3 = AbsoluteAlignment.materializeModifier(gapComposer4, modifierM128padding3ABfNKs);
                            gapComposer4.startReusableNode();
                            if (gapComposer4.inserting) {
                                gapComposer4.createNode(layoutNode$Companion$Constructor$1);
                            } else {
                                gapComposer4.useNode();
                            }
                            Stack.m295setimpl(gapComposer4, measurePolicyMaybeCachedBoxMeasurePolicy, composeUiNode$Companion$SetModifier$1);
                            Stack.m295setimpl(gapComposer4, persistentCompositionLocalMapCurrentCompositionLocalScope3, composeUiNode$Companion$SetModifier$2);
                            Modifier.CC.m(i3, gapComposer4, composeUiNode$Companion$SetModifier$3, gapComposer4, ownerSnapshotObserver$onCommitAffectingLayout$1);
                            Stack.m295setimpl(gapComposer4, modifierMaterializeModifier3, composeUiNode$Companion$SetModifier$4);
                            RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.Center, vertical, gapComposer4, 54);
                            long j6 = gapComposer4.compositeKeyHashCode;
                            int i4 = (int) (j6 ^ (j6 >>> 32));
                            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope4 = gapComposer4.currentCompositionLocalScope();
                            Modifier modifierMaterializeModifier4 = AbsoluteAlignment.materializeModifier(gapComposer4, companion);
                            gapComposer4.startReusableNode();
                            if (gapComposer4.inserting) {
                                gapComposer4.createNode(layoutNode$Companion$Constructor$1);
                            } else {
                                gapComposer4.useNode();
                            }
                            Stack.m295setimpl(gapComposer4, rowMeasurePolicy2, composeUiNode$Companion$SetModifier$1);
                            Stack.m295setimpl(gapComposer4, persistentCompositionLocalMapCurrentCompositionLocalScope4, composeUiNode$Companion$SetModifier$2);
                            Modifier.CC.m(i4, gapComposer4, composeUiNode$Companion$SetModifier$3, gapComposer4, ownerSnapshotObserver$onCommitAffectingLayout$1);
                            Stack.m295setimpl(gapComposer4, modifierMaterializeModifier4, composeUiNode$Companion$SetModifier$4);
                            IconKt.m249Iconww6aTOc(MediaType.Companion.getClose(), null, SizeKt.m140size3ABfNKs(companion, 18), appColors4.destructive, gapComposer4, 432, 0);
                            OffsetKt.Spacer(gapComposer4, SizeKt.m144width3ABfNKs(companion, f5));
                            z2 = true;
                            z = false;
                            TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.connections_close, gapComposer4), null, appColors4.destructive, 0L, null, FontWeight.SemiBold, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer4.consume(staticProvidableCompositionLocal)).typography.bodyMedium, gapComposer4, 1572864, 0, 131002);
                            gapComposer4 = gapComposer4;
                            gapComposer4.end(true);
                            gapComposer4.end(true);
                        }
                        gapComposer4.end(z);
                        gapComposer4.end(z2);
                    }
                    break;
            }
            return Unit.INSTANCE;
        }

        public C00202(AppColors appColors, boolean z, List list, Function1 function1, MutableState mutableState) {
            this.$colors = appColors;
            this.$isTv = z;
            this.$files = list;
            this.$onAction = function1;
            this.$menuTarget$delegate = mutableState;
        }

        public C00202(boolean z, Function0 function0, Function0 function1, Function0 function2, AppColors appColors) {
            this.$isTv = z;
            this.$files = function0;
            this.$onAction = function1;
            this.$menuTarget$delegate = function2;
            this.$colors = appColors;
        }
    }

    public static final void FileMenuSheet(final File file, boolean z, boolean z2, Function0 function0, Function1 function1, GapComposer gapComposer, int i) {
        int i2;
        final Function1 function2;
        gapComposer.startRestartGroup(823837775);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? gapComposer.changed(file) : gapComposer.changedInstance(file) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changed(z2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changedInstance(function0) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            function2 = function1;
            i2 |= gapComposer.changedInstance(function2) ? 16384 : 8192;
        } else {
            function2 = function1;
        }
        int i3 = i2;
        if ((i3 & 9363) == 9362 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            SheetState sheetStateRememberModalBottomSheetState = ScrimKt.rememberModalBottomSheetState(null, gapComposer, 0, 3);
            boolean z3 = file.isDirectory;
            boolean z4 = !z3 && (!z || z2);
            final boolean z5 = !z3 && file.size > 0;
            final boolean z6 = !z;
            final boolean z7 = z4;
            ScrimKt.m265ModalBottomSheetYbuCTN8(function0, null, sheetStateRememberModalBottomSheetState, 0.0f, false, null, BrushKt.m414compositeOverOWjLjI(appColors.cardBackground, appColors.appBackground), 0L, 0.0f, 0L, null, null, null, Thread_jvmKt.rememberComposableLambda(158920369, new Function3() { // from class: com.github.kr328.clash.compose.FilesScreenKt.FileMenuSheet.1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    GapComposer gapComposer2 = (GapComposer) obj2;
                    if ((((Number) obj3).intValue() & 17) == 16 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        Modifier modifierM132paddingqDBjuR0$default = OffsetKt.m132paddingqDBjuR0$default(Modifier.Companion.$$INSTANCE, 0.0f, 0.0f, 0.0f, 24, 7);
                        final int i4 = 0;
                        ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, gapComposer2, 0);
                        long j = gapComposer2.compositeKeyHashCode;
                        int i5 = (int) (j ^ (j >>> 32));
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
                        Stack.m295setimpl(gapComposer2, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                        Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                        Stack.m295setimpl(gapComposer2, Integer.valueOf(i5), ComposeUiNode.Companion.SetCompositeKeyHash);
                        Stack.m294reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                        Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                        gapComposer2.startReplaceGroup(-522790395);
                        NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
                        boolean z8 = z7;
                        final Function1 function3 = function2;
                        final File file2 = file;
                        if (z8) {
                            ImageVector imageVectorBuild = TaskLoggerKt._download;
                            if (imageVectorBuild == null) {
                                ImageVector.Builder builder = new ImageVector.Builder("Filled.Download", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                                int i6 = VectorKt.$r8$clinit;
                                SolidColor solidColor = new SolidColor(Color.Black);
                                Quirks quirks = new Quirks();
                                quirks.moveTo(5.0f, 20.0f);
                                quirks.horizontalLineToRelative(14.0f);
                                quirks.verticalLineToRelative(-2.0f);
                                quirks.horizontalLineTo(5.0f);
                                quirks.verticalLineTo(20.0f);
                                quirks.close();
                                quirks.moveTo(19.0f, 9.0f);
                                quirks.horizontalLineToRelative(-4.0f);
                                quirks.verticalLineTo(3.0f);
                                quirks.horizontalLineTo(9.0f);
                                quirks.verticalLineToRelative(6.0f);
                                quirks.horizontalLineTo(5.0f);
                                quirks.lineToRelative(7.0f, 7.0f);
                                quirks.lineTo(19.0f, 9.0f);
                                quirks.close();
                                ImageVector.Builder.m502addPathoIyEayM$default(builder, quirks.mQuirks, solidColor);
                                imageVectorBuild = builder.build();
                                TaskLoggerKt._download = imageVectorBuild;
                            }
                            String strStringResource = StringResources_androidKt.stringResource(R.string.import_, gapComposer2);
                            gapComposer2.startReplaceGroup(-522787340);
                            boolean zChanged = gapComposer2.changed(function3) | gapComposer2.changedInstance(file2);
                            Object objRememberedValue = gapComposer2.rememberedValue();
                            if (zChanged || objRememberedValue == neverEqualPolicy) {
                                objRememberedValue = new Function0() { // from class: com.github.kr328.clash.compose.FilesScreenKt$FileMenuSheet$1$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        switch (i4) {
                                            case 0:
                                                function3.invoke(new FileAction.Import(file2));
                                                break;
                                            case 1:
                                                function3.invoke(new FileAction.Export(file2));
                                                break;
                                            case 2:
                                                function3.invoke(new FileAction.Rename(file2));
                                                break;
                                            default:
                                                function3.invoke(new FileAction.Delete(file2));
                                                break;
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                gapComposer2.updateRememberedValue(objRememberedValue);
                            }
                            gapComposer2.end(false);
                            FilesScreenKt.m802MenuRowcf5BqRc(imageVectorBuild, strStringResource, 0L, (Function0) objRememberedValue, gapComposer2, 0, 4);
                        }
                        gapComposer2.end(false);
                        gapComposer2.startReplaceGroup(-522784030);
                        final int i7 = 1;
                        if (z5) {
                            ImageVector upload = UploadKt.getUpload();
                            String strStringResource2 = StringResources_androidKt.stringResource(R.string.export, gapComposer2);
                            gapComposer2.startReplaceGroup(-522781068);
                            boolean zChanged2 = gapComposer2.changed(function3) | gapComposer2.changedInstance(file2);
                            Object objRememberedValue2 = gapComposer2.rememberedValue();
                            if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                                objRememberedValue2 = new Function0() { // from class: com.github.kr328.clash.compose.FilesScreenKt$FileMenuSheet$1$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        switch (i7) {
                                            case 0:
                                                function3.invoke(new FileAction.Import(file2));
                                                break;
                                            case 1:
                                                function3.invoke(new FileAction.Export(file2));
                                                break;
                                            case 2:
                                                function3.invoke(new FileAction.Rename(file2));
                                                break;
                                            default:
                                                function3.invoke(new FileAction.Delete(file2));
                                                break;
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                gapComposer2.updateRememberedValue(objRememberedValue2);
                            }
                            gapComposer2.end(false);
                            FilesScreenKt.m802MenuRowcf5BqRc(upload, strStringResource2, 0L, (Function0) objRememberedValue2, gapComposer2, 0, 4);
                        }
                        gapComposer2.end(false);
                        gapComposer2.startReplaceGroup(-522777760);
                        if (z6) {
                            ImageVector edit = HttpMethod.getEdit();
                            String strStringResource3 = StringResources_androidKt.stringResource(R.string.rename, gapComposer2);
                            gapComposer2.startReplaceGroup(-522774860);
                            boolean zChanged3 = gapComposer2.changed(function3) | gapComposer2.changedInstance(file2);
                            Object objRememberedValue3 = gapComposer2.rememberedValue();
                            if (zChanged3 || objRememberedValue3 == neverEqualPolicy) {
                                final int i8 = 2;
                                objRememberedValue3 = new Function0() { // from class: com.github.kr328.clash.compose.FilesScreenKt$FileMenuSheet$1$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        switch (i8) {
                                            case 0:
                                                function3.invoke(new FileAction.Import(file2));
                                                break;
                                            case 1:
                                                function3.invoke(new FileAction.Export(file2));
                                                break;
                                            case 2:
                                                function3.invoke(new FileAction.Rename(file2));
                                                break;
                                            default:
                                                function3.invoke(new FileAction.Delete(file2));
                                                break;
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                gapComposer2.updateRememberedValue(objRememberedValue3);
                            }
                            gapComposer2.end(false);
                            FilesScreenKt.m802MenuRowcf5BqRc(edit, strStringResource3, 0L, (Function0) objRememberedValue3, gapComposer2, 0, 4);
                        }
                        gapComposer2.end(false);
                        gapComposer2.startReplaceGroup(-522771416);
                        if (z6) {
                            ImageVector delete = RequestBody$Companion$toRequestBody$2.getDelete();
                            String strStringResource4 = StringResources_androidKt.stringResource(R.string.delete, gapComposer2);
                            long j2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.error;
                            gapComposer2.startReplaceGroup(-522764300);
                            boolean zChanged4 = gapComposer2.changed(function3) | gapComposer2.changedInstance(file2);
                            Object objRememberedValue4 = gapComposer2.rememberedValue();
                            if (zChanged4 || objRememberedValue4 == neverEqualPolicy) {
                                final int i9 = 3;
                                objRememberedValue4 = new Function0() { // from class: com.github.kr328.clash.compose.FilesScreenKt$FileMenuSheet$1$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        switch (i9) {
                                            case 0:
                                                function3.invoke(new FileAction.Import(file2));
                                                break;
                                            case 1:
                                                function3.invoke(new FileAction.Export(file2));
                                                break;
                                            case 2:
                                                function3.invoke(new FileAction.Rename(file2));
                                                break;
                                            default:
                                                function3.invoke(new FileAction.Delete(file2));
                                                break;
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                gapComposer2.updateRememberedValue(objRememberedValue4);
                            }
                            gapComposer2.end(false);
                            FilesScreenKt.m802MenuRowcf5BqRc(delete, strStringResource4, j2, (Function0) objRememberedValue4, gapComposer2, 0, 0);
                        }
                        gapComposer2.end(false);
                        gapComposer2.end(true);
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, (i3 >> 9) & 14, 3072, 8122);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new FilesScreenKt$$ExternalSyntheticLambda4(file, z, z2, function0, function1, i);
        }
    }

    public static final void FileNameDialog(String str, Function1 function1, Function0 function0, GapComposer gapComposer, int i) {
        gapComposer.startRestartGroup(108007237);
        if (((i | (gapComposer.changed(str) ? 4 : 2) | (gapComposer.changedInstance(function1) ? 32 : 16)) & 147) == 146 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            long jM414compositeOverOWjLjI = BrushKt.m414compositeOverOWjLjI(appColors.cardBackground, appColors.appBackground);
            gapComposer.startReplaceGroup(277594890);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == Composer$Companion.Empty) {
                objRememberedValue = Stack.mutableStateOf$default(str);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            boolean z = false;
            gapComposer.end(false);
            if (PatternsKt.PatternFileName.matches((String) mutableState.getValue()) && !StringsKt.isBlank((String) mutableState.getValue())) {
                z = true;
            }
            boolean z2 = z;
            ScrimKt.m263AlertDialogOix01E0(function0, Thread_jvmKt.rememberComposableLambda(-1252158467, new C00181(function1, z2, mutableState, appColors, 0), gapComposer), null, Thread_jvmKt.rememberComposableLambda(-305120581, new LogsScreenKt.AnonymousClass2(function0, appColors, 3), gapComposer), null, Thread_jvmKt.rememberComposableLambda(641917305, new LogsScreenKt.AnonymousClass6(appColors, 3), gapComposer), Thread_jvmKt.rememberComposableLambda(1115436248, new AnonymousClass4(0, appColors, mutableState, z2), gapComposer), RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(20), jM414compositeOverOWjLjI, 0L, 0L, 0L, 0.0f, null, gapComposer, 1772598, 15892);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MenuKt$$ExternalSyntheticLambda1(str, function1, function0, i, 6);
        }
    }

    public static final void FileRow(File file, Function0 function0, Function0 function1, GapComposer gapComposer, int i) {
        gapComposer.startRestartGroup(1285254204);
        if (((i | (gapComposer.changed(file) ? 4 : 2) | (gapComposer.changedInstance(function0) ? 32 : 16) | (gapComposer.changedInstance(function1) ? 256 : 128)) & 147) == 146 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            gapComposer.startReplaceGroup(1412752343);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = DateFormat.getDateTimeInstance(2, 3);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            DateFormat dateFormat = (DateFormat) objRememberedValue;
            Object objM = Density.CC.m(1412755561, gapComposer, false);
            if (objM == neverEqualPolicy) {
                objM = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objM);
            }
            MutableState mutableState = (MutableState) objM;
            gapComposer.end(false);
            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f);
            gapComposer.startReplaceGroup(1412759971);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new TooltipKt$$ExternalSyntheticLambda7(mutableState, 11);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            gapComposer.end(false);
            Modifier modifierOnFocusChanged = FocusTraversalKt.onFocusChanged(modifierFillMaxWidth, (Function1) objRememberedValue2);
            float f = ((Boolean) mutableState.getValue()).booleanValue() ? 2 : 0;
            long j = ((Boolean) mutableState.getValue()).booleanValue() ? Color.White : Color.Transparent;
            float f2 = 12;
            zzjl.m819GlassSurfaceYxtnGt4(ImageKt.m48borderxT4_qwU(f, j, modifierOnFocusChanged, RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(f2)), f2, null, Thread_jvmKt.rememberComposableLambda(-74728263, new AnonymousClass2(function0, file, appColors, function1, dateFormat), gapComposer), gapComposer, 196656, 28);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MenuKt$$ExternalSyntheticLambda1(file, function0, function1, i, 7);
        }
    }

    public static final void FilesScreen(final List list, final boolean z, final boolean z2, Function1 function1, final Function0 function0, Modifier modifier, final boolean z3, GapComposer gapComposer, final int i) {
        Function1 function2;
        final Modifier modifier2;
        MutableState mutableState;
        gapComposer.startRestartGroup(1969485613);
        int i2 = i | (gapComposer.changedInstance(list) ? 4 : 2) | (gapComposer.changed(z) ? 32 : 16) | (gapComposer.changed(z2) ? 256 : 128) | (gapComposer.changedInstance(function1) ? 2048 : 1024) | (gapComposer.changedInstance(function0) ? 16384 : 8192) | 196608 | (gapComposer.changed(z3) ? 1048576 : 524288);
        if ((599187 & i2) == 599186 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
            function2 = function1;
        } else {
            AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            gapComposer.startReplaceGroup(-120601452);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.mutableStateOf$default(null);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState2 = (MutableState) objRememberedValue;
            gapComposer.end(false);
            ScaffoldKt.m261ScaffoldTvnljyQ(ImageKt.m47backgroundbw27NRU(SizeKt.FillWholeMaxSize, appColors.appBackground, BrushKt.RectangleShape), Thread_jvmKt.rememberComposableLambda(2047756785, new C00191(z3, appColors, function0, z, function1), gapComposer), null, null, null, 0, appColors.appBackground, 0L, null, Thread_jvmKt.rememberComposableLambda(1831258940, new C00202(appColors, z3, list, function1, mutableState2), gapComposer), gapComposer, 805306416, 444);
            File file = (File) mutableState2.getValue();
            if (file != null) {
                gapComposer.startReplaceGroup(-120495135);
                Object objRememberedValue2 = gapComposer.rememberedValue();
                if (objRememberedValue2 == neverEqualPolicy) {
                    mutableState = mutableState2;
                    objRememberedValue2 = new TooltipKt$$ExternalSyntheticLambda0(mutableState, 9);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                } else {
                    mutableState = mutableState2;
                }
                Function0 function3 = (Function0) objRememberedValue2;
                gapComposer.end(false);
                gapComposer.startReplaceGroup(-120493592);
                boolean z4 = (i2 & 7168) == 2048;
                Object objRememberedValue3 = gapComposer.rememberedValue();
                if (z4 || objRememberedValue3 == neverEqualPolicy) {
                    function2 = function1;
                    objRememberedValue3 = new FilesScreenKt$$ExternalSyntheticLambda1(function2, mutableState, 0);
                    gapComposer.updateRememberedValue(objRememberedValue3);
                } else {
                    function2 = function1;
                }
                gapComposer.end(false);
                FileMenuSheet(file, z, z2, function3, (Function1) objRememberedValue3, gapComposer, (i2 & 112) | 3072 | (i2 & 896));
            } else {
                function2 = function1;
            }
            modifier2 = Modifier.Companion.$$INSTANCE;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            final Function1 function4 = function2;
            recomposeScopeImplEndRestartGroup.block = new Function2(list, z, z2, function4, function0, modifier2, z3, i) { // from class: com.github.kr328.clash.compose.FilesScreenKt$$ExternalSyntheticLambda2
                public final /* synthetic */ List f$0;
                public final /* synthetic */ boolean f$1;
                public final /* synthetic */ boolean f$2;
                public final /* synthetic */ Function1 f$3;
                public final /* synthetic */ Function0 f$4;
                public final /* synthetic */ Modifier f$5;
                public final /* synthetic */ boolean f$6;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                    FilesScreenKt.FilesScreen(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, (GapComposer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX INFO: renamed from: MenuRow-cf5BqRc, reason: not valid java name */
    public static final void m802MenuRowcf5BqRc(ImageVector imageVector, String str, long j, Function0 function0, GapComposer gapComposer, int i, int i2) {
        long j2;
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(1511029325);
        long j3 = j;
        int i3 = i | (gapComposer2.changed(imageVector) ? 4 : 2) | (gapComposer2.changed(str) ? 32 : 16) | (((i2 & 4) == 0 && gapComposer2.changed(j3)) ? 256 : 128) | (gapComposer2.changedInstance(function0) ? 2048 : 1024);
        if ((i3 & 1171) == 1170 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
            j2 = j3;
        } else {
            gapComposer2.startDefaults();
            if ((i & 1) != 0 && !gapComposer2.getDefaultsInvalid()) {
                gapComposer2.skipToGroupEnd();
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
            } else if ((i2 & 4) != 0) {
                j3 = ((AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors)).textPrimary;
                i3 &= -897;
            }
            long j4 = j3;
            gapComposer2.endDefaults();
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            float f = 24;
            Modifier modifierM129paddingVpY3zN4 = OffsetKt.m129paddingVpY3zN4(ImageKt.m51clickableoSLSa3U$default(SizeKt.fillMaxWidth(companion, 1.0f), false, null, function0, 15), f, 16);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.CenterVertically, gapComposer2, 48);
            long j5 = gapComposer2.compositeKeyHashCode;
            int i4 = (int) (j5 ^ (j5 >>> 32));
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
            Stack.m295setimpl(gapComposer2, Integer.valueOf(i4), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m294reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            IconKt.m249Iconww6aTOc(imageVector, null, SizeKt.m140size3ABfNKs(companion, f), j4, gapComposer2, (i3 & 14) | 432 | ((i3 << 3) & 7168), 0);
            OffsetKt.Spacer(gapComposer2, SizeKt.m144width3ABfNKs(companion, 20));
            TextKt.m275TextNvy7gAk(str, null, j4, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.titleMedium, gapComposer, ((i3 >> 3) & 14) | (i3 & 896), 0, 131066);
            gapComposer2 = gapComposer;
            gapComposer2.end(true);
            j2 = j4;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new IconKt$$ExternalSyntheticLambda2(imageVector, str, j2, function0, i, i2);
        }
    }
}
