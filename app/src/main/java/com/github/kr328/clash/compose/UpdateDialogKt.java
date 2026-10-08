package com.github.kr328.clash.compose;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.SizeElement;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.SnackbarHostKt$$ExternalSyntheticLambda0;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import com.github.kr328.clash.UpdateInfo;
import com.github.kr328.clash.compose.connections.ConnectionsScreenKt;
import com.github.kr328.clash.core.model.ConnectionMetadata;
import com.koala.clash.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class UpdateDialogKt {

    /* JADX INFO: renamed from: com.github.kr328.clash.compose.UpdateDialogKt$UpdateDialog$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 implements Function2 {
        public final /* synthetic */ Function0 $onDownload;
        public final /* synthetic */ int $r8$classId;

        public /* synthetic */ AnonymousClass1(int i, Function0 function0) {
            this.$r8$classId = i;
            this.$onDownload = function0;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            switch (this.$r8$classId) {
                case 0:
                    GapComposer gapComposer = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
                        gapComposer.skipToGroupEnd();
                    } else {
                        ScrimKt.TextButton(this.$onDownload, null, false, null, null, null, ComposableSingletons$UpdateDialogKt.f21lambda1, gapComposer, 805306368, 510);
                    }
                    break;
                case 1:
                    GapComposer gapComposer2 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        RoundedCornerShape roundedCornerShapeM158RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(12);
                        PaddingValuesImpl paddingValuesImpl = ButtonDefaults.ContentPadding;
                        ScrimKt.Button(this.$onDownload, null, false, roundedCornerShapeM158RoundedCornerShape0680j_4, ButtonDefaults.getDefaultButtonColors$material3(((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).colorScheme), null, null, ComposableSingletons$HwidLimitDialogKt.f14lambda1, gapComposer2, 805306368, 486);
                    }
                    break;
                case 2:
                    GapComposer gapComposer3 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer3.getSkipping()) {
                        gapComposer3.skipToGroupEnd();
                    } else {
                        ScrimKt.TextButton(this.$onDownload, null, false, null, null, null, ComposableSingletons$PropertiesScreenKt.f20lambda2, gapComposer3, 805306368, 510);
                    }
                    break;
                default:
                    GapComposer gapComposer4 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer4.getSkipping()) {
                        gapComposer4.skipToGroupEnd();
                    } else {
                        ScrimKt.TextButton(this.$onDownload, null, false, null, null, null, ComposableSingletons$UpdateDialogKt.f22lambda2, gapComposer4, 805306368, 510);
                    }
                    break;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.compose.UpdateDialogKt$UpdateDialog$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass3 implements Function2 {
        public final /* synthetic */ Object $info;
        public final /* synthetic */ int $r8$classId;

        public /* synthetic */ AnonymousClass3(int i, Object obj) {
            this.$r8$classId = i;
            this.$info = obj;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            switch (this.$r8$classId) {
                case 0:
                    GapComposer gapComposer = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
                        gapComposer.skipToGroupEnd();
                    } else {
                        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                        Modifier modifierThen = SizeKt.fillMaxWidth(companion, 1.0f).then(new SizeElement(0.0f, (1 & 1) != 0 ? Float.NaN : 0.0f, 0.0f, (1 & 2) != 0 ? Float.NaN : 300, 5));
                        UpdateInfo updateInfo = (UpdateInfo) this.$info;
                        ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, gapComposer, 0);
                        long j = gapComposer.compositeKeyHashCode;
                        int i = (int) (j ^ (j >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifierThen);
                        ComposeUiNode.Companion.getClass();
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                        gapComposer.startReusableNode();
                        if (gapComposer.inserting) {
                            gapComposer.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer.useNode();
                        }
                        Stack.m295setimpl(gapComposer, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                        Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                        Stack.m295setimpl(gapComposer, Integer.valueOf(i), ComposeUiNode.Companion.SetCompositeKeyHash);
                        Stack.m294reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                        Stack.m295setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                        String str = updateInfo.tagName;
                        String str2 = updateInfo.body;
                        TextKt.m275TextNvy7gAk(str, null, 0L, 0L, null, FontWeight.SemiBold, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.titleMedium, gapComposer, 1572864, 0, 131006);
                        GapComposer gapComposer2 = gapComposer;
                        gapComposer2.startReplaceGroup(-967448109);
                        if (!StringsKt.isBlank(str2)) {
                            OffsetKt.Spacer(gapComposer2, SizeKt.m135height3ABfNKs(companion, 12));
                            List listLines = StringsKt.lines(str2);
                            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listLines, 10));
                            Iterator it = listLines.iterator();
                            while (it.hasNext()) {
                                arrayList.add(StringsKt.trim((String) it.next()).toString());
                            }
                            ArrayList arrayList2 = new ArrayList();
                            int size = arrayList.size();
                            int i2 = 0;
                            while (i2 < size) {
                                Object obj3 = arrayList.get(i2);
                                i2++;
                                if (!StringsKt.isBlank((String) obj3)) {
                                    arrayList2.add(obj3);
                                }
                            }
                            TextKt.m275TextNvy7gAk(CollectionsKt.joinToString$default(arrayList2, "\n", null, null, null, 62), ImageKt.verticalScroll$default(SizeKt.fillMaxWidth(companion, 1.0f), ImageKt.rememberScrollState(gapComposer2)), 0L, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyMedium, gapComposer2, 0, 0, 131068);
                            gapComposer2 = gapComposer2;
                        }
                        gapComposer2.end(false);
                        gapComposer2.end(true);
                    }
                    break;
                default:
                    GapComposer gapComposer3 = (GapComposer) obj;
                    int iIntValue = ((Number) obj2).intValue();
                    ConnectionMetadata connectionMetadata = (ConnectionMetadata) this.$info;
                    if ((iIntValue & 3) == 2 && gapComposer3.getSkipping()) {
                        gapComposer3.skipToGroupEnd();
                    } else {
                        gapComposer3.startReplaceGroup(1427278317);
                        String str3 = connectionMetadata.sourceIP;
                        int i3 = connectionMetadata.uid;
                        String str4 = connectionMetadata.processPath;
                        String str5 = connectionMetadata.process;
                        String str6 = connectionMetadata.destinationIP;
                        String str7 = connectionMetadata.host;
                        if (str3.length() > 0) {
                            ConnectionsScreenKt.DetailRow(StringResources_androidKt.stringResource(R.string.connection_source, gapComposer3), ImageAnalysis$$ExternalSyntheticLambda1.m(connectionMetadata.sourceIP, ":", connectionMetadata.sourcePort), gapComposer3, 0);
                        }
                        gapComposer3.end(false);
                        String str8 = str7.length() > 0 ? str7 : str6;
                        gapComposer3.startReplaceGroup(1427286273);
                        if (str8.length() > 0) {
                            ConnectionsScreenKt.DetailRow(StringResources_androidKt.stringResource(R.string.connection_destination, gapComposer3), ImageAnalysis$$ExternalSyntheticLambda1.m(str8, ":", connectionMetadata.destinationPort), gapComposer3, 0);
                        }
                        gapComposer3.end(false);
                        gapComposer3.startReplaceGroup(1427291027);
                        if (str7.length() > 0 && str6.length() > 0) {
                            ConnectionsScreenKt.DetailRow("IP", str6, gapComposer3, 6);
                        }
                        gapComposer3.end(false);
                        gapComposer3.startReplaceGroup(1427295348);
                        if (str5.length() > 0) {
                            ConnectionsScreenKt.DetailRow(StringResources_androidKt.stringResource(R.string.connection_process, gapComposer3), str5, gapComposer3, 0);
                        }
                        gapComposer3.end(false);
                        gapComposer3.startReplaceGroup(1427299713);
                        if (str4.length() > 0) {
                            ConnectionsScreenKt.DetailRow(StringResources_androidKt.stringResource(R.string.connection_process_path, gapComposer3), str4, gapComposer3, 0);
                        }
                        gapComposer3.end(false);
                        if (i3 != 0) {
                            ConnectionsScreenKt.DetailRow(StringResources_androidKt.stringResource(R.string.connection_uid, gapComposer3), String.valueOf(i3), gapComposer3, 0);
                        }
                    }
                    break;
            }
            return Unit.INSTANCE;
        }
    }

    public static final void UpdateDialog(UpdateInfo updateInfo, Function0 function0, Function0 function1, GapComposer gapComposer, int i) {
        gapComposer.startRestartGroup(1717393234);
        int i2 = (gapComposer.changed(updateInfo) ? 4 : 2) | i | (gapComposer.changedInstance(function0) ? 32 : 16);
        if ((i & 384) == 0) {
            i2 |= gapComposer.changedInstance(function1) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            ScrimKt.m263AlertDialogOix01E0(function1, Thread_jvmKt.rememberComposableLambda(-257624166, new AnonymousClass1(0, function0), gapComposer), null, Thread_jvmKt.rememberComposableLambda(-692129764, new AnonymousClass1(3, function1), gapComposer), null, ComposableSingletons$UpdateDialogKt.f23lambda3, Thread_jvmKt.rememberComposableLambda(803595487, new AnonymousClass3(0, updateInfo), gapComposer), null, 0L, 0L, 0L, 0L, 0.0f, null, gapComposer, ((i2 >> 6) & 14) | 1772592, 16276);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new SnackbarHostKt$$ExternalSyntheticLambda0(updateInfo, function0, function1, i, 12);
        }
    }
}
