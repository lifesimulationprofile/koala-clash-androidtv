package com.github.kr328.clash;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.DocumentsContract;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.compose.ComponentActivityKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.AspectRatio;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.FlowRowOverflow;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.material3.ThumbNode;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda0;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda7;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.unit.Density;
import androidx.lifecycle.ViewModelKt;
import coil.RealImageLoader$executeMain$result$1;
import coil.compose.AsyncImagePainter$$ExternalSyntheticLambda0;
import coil.decode.BitmapFactoryDecoder$$ExternalSyntheticLambda2;
import coil.network.HttpException;
import com.github.kr328.clash.common.constants.Authorities;
import com.github.kr328.clash.common.util.IntentKt;
import com.github.kr328.clash.compose.FileAction;
import com.github.kr328.clash.compose.FilesScreenKt;
import com.github.kr328.clash.design.compose.components.GlassSnackbarKt;
import com.github.kr328.clash.design.compose.theme.AppThemeKt;
import com.github.kr328.clash.design.model.File;
import com.github.kr328.clash.remote.FilesClient;
import com.github.kr328.clash.remote.FilesClient$list$2;
import dev.chrisbanes.haze.BlurEffectKt$$ExternalSyntheticLambda1;
import io.github.g00fy2.quickie.ScanQRCode;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FilesActivity extends AppCompatActivity {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final SnackbarHostState snackbarHostState = new SnackbarHostState();
    public final SynchronizedLazyImpl isTv$delegate = new SynchronizedLazyImpl(new BitmapFactoryDecoder$$ExternalSyntheticLambda2(6, this));

    /* JADX INFO: renamed from: com.github.kr328.clash.FilesActivity$onCreate$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 implements Function2 {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ UUID $uuid;
        public final /* synthetic */ FilesActivity this$0;

        public /* synthetic */ AnonymousClass1(FilesActivity filesActivity, UUID uuid, int i) {
            this.$r8$classId = i;
            this.this$0 = filesActivity;
            this.$uuid = uuid;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            int i = this.$r8$classId;
            UUID uuid = this.$uuid;
            FilesActivity filesActivity = this.this$0;
            int i2 = 1;
            switch (i) {
                case 0:
                    GapComposer gapComposer = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
                        gapComposer.skipToGroupEnd();
                    } else {
                        AppThemeKt.AppTheme(false, Thread_jvmKt.rememberComposableLambda(44336803, new AnonymousClass1(filesActivity, uuid, i2), gapComposer), gapComposer, 48);
                    }
                    break;
                default:
                    GapComposer gapComposer2 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        FillElement fillElement = SizeKt.FillWholeMaxSize;
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                        long j = gapComposer2.compositeKeyHashCode;
                        int i3 = (int) (j ^ (j >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, fillElement);
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
                        FlowRowOverflow flowRowOverflow = FlowRowOverflow.INSTANCE;
                        String string = uuid.toString();
                        int i4 = FilesActivity.$r8$clinit;
                        filesActivity.Content(string, gapComposer2, 0);
                        GlassSnackbarKt.GlassSnackbarHost(filesActivity.snackbarHostState, flowRowOverflow.align(Modifier.Companion.$$INSTANCE, Alignment.Companion.BottomCenter), gapComposer2, 0, 0);
                        gapComposer2.end(true);
                    }
                    break;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object access$Content$reload(SnapshotStateList snapshotStateList, String str, FilesClient filesClient, MutableState mutableState, Continuation continuation) throws Throwable {
        FilesActivity$Content$reload$1 filesActivity$Content$reload$1;
        if (continuation instanceof FilesActivity$Content$reload$1) {
            filesActivity$Content$reload$1 = (FilesActivity$Content$reload$1) continuation;
            int i = filesActivity$Content$reload$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                filesActivity$Content$reload$1.label = i - Integer.MIN_VALUE;
            } else {
                filesActivity$Content$reload$1 = new FilesActivity$Content$reload$1(continuation);
            }
        } else {
            filesActivity$Content$reload$1 = new FilesActivity$Content$reload$1(continuation);
        }
        Object objWithContext = filesActivity$Content$reload$1.result;
        int i2 = filesActivity$Content$reload$1.label;
        Object obj = null;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objWithContext);
            String str2 = (String) CollectionsKt.lastOrNull(snapshotStateList);
            if (str2 != null) {
                str = str2;
            }
            filesActivity$Content$reload$1.L$0 = snapshotStateList;
            filesActivity$Content$reload$1.L$1 = mutableState;
            filesActivity$Content$reload$1.label = 1;
            filesClient.getClass();
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            objWithContext = JobKt.withContext(DefaultIoScheduler.INSTANCE, new FilesClient$list$2(str, filesClient, (Continuation) null), filesActivity$Content$reload$1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objWithContext == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutableState = filesActivity$Content$reload$1.L$1;
            snapshotStateList = filesActivity$Content$reload$1.L$0;
            ResultKt.throwOnFailure(objWithContext);
        }
        List listSingletonList = (List) objWithContext;
        if (snapshotStateList.isEmpty()) {
            for (Object obj2 : listSingletonList) {
                if (((File) obj2).id.endsWith("config.yaml")) {
                    obj = obj2;
                    break;
                }
            }
            File file = (File) obj;
            if (file != null && file.size <= 0) {
                listSingletonList = Collections.singletonList(file);
            }
        }
        mutableState.setValue(listSingletonList);
        return Unit.INSTANCE;
    }

    public static final void access$showError(FilesActivity filesActivity, Throwable th) {
        filesActivity.getClass();
        JobKt.launch$default(ViewModelKt.getLifecycleScope(filesActivity), null, new FilesActivity$showError$1(filesActivity, th, null, 0), 3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5, types: [com.github.kr328.clash.FilesActivity, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v0, types: [androidx.compose.runtime.GapComposer] */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v3, types: [androidx.compose.runtime.GapComposer] */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5, types: [androidx.compose.runtime.GapComposer] */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7, types: [androidx.compose.runtime.GapComposer] */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r1v11, types: [com.github.kr328.clash.FilesActivity] */
    /* JADX WARN: Type inference failed for: r2v34, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v18, types: [com.github.kr328.clash.FilesActivity] */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v21, types: [com.github.kr328.clash.FilesActivity, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [com.github.kr328.clash.FilesActivity, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9, types: [java.lang.Object] */
    public final void Content(final String str, GapComposer gapComposer, int i) {
        MutableState mutableState;
        FilesActivity filesActivity;
        CoroutineScope coroutineScope;
        ?? r3;
        Object filesActivity$$ExternalSyntheticLambda8;
        ScanQRCode scanQRCode;
        MutableState mutableState2;
        MutableState mutableState3;
        ScanQRCode scanQRCode2;
        ManagedActivityResultLauncher managedActivityResultLauncher;
        Object obj;
        final MutableState mutableState4;
        boolean z;
        SnapshotStateList snapshotStateList;
        MutableState mutableState5;
        ?? r4;
        SnapshotStateList snapshotStateList2;
        ?? r12;
        Object filesActivity$$ExternalSyntheticLambda3;
        FilesClient filesClient;
        MutableState mutableState6;
        CoroutineScope coroutineScope2;
        SnapshotStateList snapshotStateList3;
        MutableState mutableState7;
        ?? r14;
        ?? r5;
        boolean z2;
        ?? r15;
        ?? r6;
        MutableState mutableState8;
        ?? r16;
        ?? r7;
        FilesActivity filesActivity2 = this;
        String str2 = str;
        ?? r17 = gapComposer;
        r17.startRestartGroup(538079765);
        int i2 = i | (r17.changed(str2) ? 4 : 2) | (r17.changedInstance(filesActivity2) ? 32 : 16);
        if ((i2 & 19) == 18 && r17.getSkipping()) {
            r17.skipToGroupEnd();
            r7 = filesActivity2;
            r16 = r17;
        } else {
            Object objRememberedValue = r17.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.createCompositionCoroutineScope(r17);
                r17.updateRememberedValue(objRememberedValue);
            }
            CoroutineScope coroutineScope3 = (CoroutineScope) objRememberedValue;
            r17.startReplaceGroup(429526772);
            Object objRememberedValue2 = r17.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new FilesClient(filesActivity2);
                r17.updateRememberedValue(objRememberedValue2);
            }
            final FilesClient filesClient2 = (FilesClient) objRememberedValue2;
            Object objM = Density.CC.m(429528415, (GapComposer) r17, false);
            if (objM == neverEqualPolicy) {
                objM = new SnapshotStateList();
                r17.updateRememberedValue(objM);
            }
            SnapshotStateList snapshotStateList4 = (SnapshotStateList) objM;
            Object objM2 = Density.CC.m(429530967, (GapComposer) r17, false);
            if (objM2 == neverEqualPolicy) {
                objM2 = Stack.mutableStateOf$default(Boolean.TRUE);
                r17.updateRememberedValue(objM2);
            }
            MutableState mutableState9 = (MutableState) objM2;
            Object objM3 = Density.CC.m(429532746, (GapComposer) r17, false);
            if (objM3 == neverEqualPolicy) {
                objM3 = Stack.mutableStateOf$default(EmptyList.INSTANCE);
                r17.updateRememberedValue(objM3);
            }
            MutableState mutableState10 = (MutableState) objM3;
            Object objM4 = Density.CC.m(429535358, (GapComposer) r17, false);
            if (objM4 == neverEqualPolicy) {
                objM4 = Stack.mutableStateOf$default(null);
                r17.updateRememberedValue(objM4);
            }
            MutableState mutableState11 = (MutableState) objM4;
            Object objM5 = Density.CC.m(429537739, (GapComposer) r17, false);
            if (objM5 == neverEqualPolicy) {
                objM5 = Stack.mutableStateOf$default(null);
                r17.updateRememberedValue(objM5);
            }
            MutableState mutableState12 = (MutableState) objM5;
            r17.end(false);
            int size = snapshotStateList4.size();
            r17.startReplaceGroup(429540529);
            boolean zChanged = r17.changed(size);
            Object objRememberedValue3 = r17.rememberedValue();
            int i3 = 7;
            if (zChanged || objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = Stack.derivedStateOf(new BitmapFactoryDecoder$$ExternalSyntheticLambda2(i3, snapshotStateList4));
                r17.updateRememberedValue(objRememberedValue3);
            }
            State state = (State) objRememberedValue3;
            r17.end(false);
            r17.startReplaceGroup(429555716);
            int i4 = i2 & 14;
            boolean zChangedInstance = r17.changedInstance(filesActivity2) | (i4 == 4) | r17.changedInstance(filesClient2);
            Object objRememberedValue4 = r17.rememberedValue();
            if (zChangedInstance || objRememberedValue4 == neverEqualPolicy) {
                mutableState = mutableState12;
                FilesActivity$Content$1$1 filesActivity$Content$1$1 = new FilesActivity$Content$1$1(filesActivity2, mutableState9, snapshotStateList4, str2, filesClient2, mutableState10, null);
                filesActivity = filesActivity2;
                snapshotStateList4 = snapshotStateList4;
                r17.updateRememberedValue(filesActivity$Content$1$1);
                objRememberedValue4 = filesActivity$Content$1$1;
            } else {
                mutableState = mutableState12;
                filesActivity = filesActivity2;
            }
            r17.end(false);
            Stack.LaunchedEffect(r17, str2, (Function2) objRememberedValue4);
            r17.startReplaceGroup(429566810);
            boolean zChangedInstance2 = r17.changedInstance(filesActivity) | r17.changedInstance(coroutineScope3) | (i4 == 4) | r17.changedInstance(filesClient2);
            Object objRememberedValue5 = r17.rememberedValue();
            if (zChangedInstance2 || objRememberedValue5 == neverEqualPolicy) {
                FilesActivity filesActivity3 = filesActivity;
                FilesActivity$$ExternalSyntheticLambda6 filesActivity$$ExternalSyntheticLambda6 = new FilesActivity$$ExternalSyntheticLambda6(snapshotStateList4, filesActivity3, coroutineScope3, str2, filesClient2, mutableState10, 0);
                coroutineScope = coroutineScope3;
                r3 = filesActivity3;
                r17.updateRememberedValue(filesActivity$$ExternalSyntheticLambda6);
                objRememberedValue5 = filesActivity$$ExternalSyntheticLambda6;
            } else {
                coroutineScope = coroutineScope3;
                r3 = filesActivity;
            }
            r17.end(false);
            int i5 = 6;
            r3.DisposableBackPressed((Function0) objRememberedValue5, r17, ((i2 << 3) & 896) | 6);
            ScanQRCode scanQRCode3 = new ScanQRCode(5);
            r17.startReplaceGroup(429577390);
            Object objRememberedValue6 = r17.rememberedValue();
            if (objRememberedValue6 == neverEqualPolicy) {
                objRememberedValue6 = new AsyncImagePainter$$ExternalSyntheticLambda0(i5);
                r17.updateRememberedValue(objRememberedValue6);
            }
            r17.end(false);
            final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult = AspectRatio.rememberLauncherForActivityResult(scanQRCode3, (Function1) objRememberedValue6, r17, 48);
            r17.startReplaceGroup(429581566);
            Object objRememberedValue7 = r17.rememberedValue();
            if (objRememberedValue7 == neverEqualPolicy) {
                objRememberedValue7 = Stack.mutableStateOf$default(null);
                r17.updateRememberedValue(objRememberedValue7);
            }
            final MutableState mutableState13 = (MutableState) objRememberedValue7;
            r17.end(false);
            ScanQRCode scanQRCode4 = new ScanQRCode(2);
            r17.startReplaceGroup(429587199);
            boolean zChangedInstance3 = r17.changedInstance(coroutineScope) | r17.changedInstance(filesClient2) | r17.changedInstance(r3) | (i4 == 4);
            Object objRememberedValue8 = r17.rememberedValue();
            if (zChangedInstance3 || objRememberedValue8 == neverEqualPolicy) {
                scanQRCode = scanQRCode4;
                mutableState2 = mutableState10;
                filesActivity$$ExternalSyntheticLambda8 = new FilesActivity$$ExternalSyntheticLambda8(coroutineScope, mutableState13, (FilesActivity) r3, filesClient2, snapshotStateList4, str, mutableState2);
                r17.updateRememberedValue(filesActivity$$ExternalSyntheticLambda8);
            } else {
                scanQRCode = scanQRCode4;
                filesActivity$$ExternalSyntheticLambda8 = objRememberedValue8;
                mutableState2 = mutableState10;
            }
            r17.end(false);
            final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult2 = AspectRatio.rememberLauncherForActivityResult(scanQRCode, (Function1) filesActivity$$ExternalSyntheticLambda8, r17, 0);
            ScanQRCode scanQRCode5 = new ScanQRCode(2);
            r17.startReplaceGroup(429604409);
            Object objRememberedValue9 = r17.rememberedValue();
            int i6 = 8;
            if (objRememberedValue9 == neverEqualPolicy) {
                mutableState3 = mutableState;
                objRememberedValue9 = new TooltipKt$$ExternalSyntheticLambda7(mutableState3, i6);
                r17.updateRememberedValue(objRememberedValue9);
            } else {
                mutableState3 = mutableState;
            }
            r17.end(false);
            ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult3 = AspectRatio.rememberLauncherForActivityResult(scanQRCode5, (Function1) objRememberedValue9, r17, 48);
            r17.startReplaceGroup(429610494);
            Object objRememberedValue10 = r17.rememberedValue();
            if (objRememberedValue10 == neverEqualPolicy) {
                objRememberedValue10 = Stack.mutableStateOf$default(null);
                r17.updateRememberedValue(objRememberedValue10);
            }
            final MutableState mutableState14 = (MutableState) objRememberedValue10;
            r17.end(false);
            ScanQRCode scanQRCode6 = new ScanQRCode(1);
            r17.startReplaceGroup(429616576);
            boolean zChangedInstance4 = r17.changedInstance(coroutineScope) | r17.changedInstance(filesClient2) | r17.changedInstance(r3);
            Object objRememberedValue11 = r17.rememberedValue();
            if (zChangedInstance4 || objRememberedValue11 == neverEqualPolicy) {
                scanQRCode2 = scanQRCode6;
                managedActivityResultLauncher = managedActivityResultLauncherRememberLauncherForActivityResult3;
                objRememberedValue11 = new FilesActivity$$ExternalSyntheticLambda10(coroutineScope, mutableState14, r3, filesClient2, 0);
                r17.updateRememberedValue(objRememberedValue11);
            } else {
                managedActivityResultLauncher = managedActivityResultLauncherRememberLauncherForActivityResult3;
                scanQRCode2 = scanQRCode6;
            }
            r17.end(false);
            final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult4 = AspectRatio.rememberLauncherForActivityResult(scanQRCode2, (Function1) objRememberedValue11, r17, 0);
            List list = (List) mutableState2.getValue();
            boolean zBooleanValue = ((Boolean) state.getValue()).booleanValue();
            boolean zBooleanValue2 = ((Boolean) mutableState9.getValue()).booleanValue();
            r17.startReplaceGroup(429633121);
            boolean zChangedInstance5 = r17.changedInstance(r3) | r17.changedInstance(coroutineScope) | r17.changedInstance(filesClient2) | (i4 == 4) | r17.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult) | r17.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult2) | r17.changedInstance(managedActivityResultLauncherRememberLauncherForActivityResult4) | r17.changedInstance(managedActivityResultLauncher);
            Object objRememberedValue12 = r17.rememberedValue();
            if (zChangedInstance5 || objRememberedValue12 == neverEqualPolicy) {
                final MutableState mutableState15 = mutableState2;
                final ManagedActivityResultLauncher managedActivityResultLauncher2 = managedActivityResultLauncher;
                mutableState4 = mutableState11;
                z = false;
                final CoroutineScope coroutineScope4 = coroutineScope;
                final ?? r1 = r3;
                final SnapshotStateList snapshotStateList5 = snapshotStateList4;
                obj = new Function1() { // from class: com.github.kr328.clash.FilesActivity$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) throws Exception {
                        FileAction fileAction = (FileAction) obj2;
                        int i7 = FilesActivity.$r8$clinit;
                        SnapshotStateList snapshotStateList6 = snapshotStateList5;
                        String str3 = str;
                        FilesClient filesClient3 = filesClient2;
                        FilesActivity$Content$3$1$1 filesActivity$Content$3$1$1 = new FilesActivity$Content$3$1$1(snapshotStateList6, str3, filesClient3, mutableState15);
                        FilesActivity$$ExternalSyntheticLambda10 filesActivity$$ExternalSyntheticLambda10 = new FilesActivity$$ExternalSyntheticLambda10(fileAction, mutableState13, mutableState14, mutableState4, 5);
                        FilesActivity filesActivity4 = this.f$0;
                        filesActivity4.getClass();
                        boolean z3 = fileAction instanceof FileAction.Open;
                        CoroutineScope coroutineScope5 = coroutineScope4;
                        Continuation continuation = null;
                        if (z3) {
                            File file = ((FileAction.Open) fileAction).file;
                            boolean z4 = file.isDirectory;
                            String str4 = file.id;
                            if (z4) {
                                snapshotStateList6.add(str4);
                                JobKt.launch$default(coroutineScope5, null, new ThumbNode.AnonymousClass1(filesActivity$Content$3$1$1, continuation, 15), 3);
                            } else {
                                Intent intent = new Intent("android.intent.action.VIEW");
                                filesClient3.getClass();
                                Intent dataAndType = intent.setDataAndType(DocumentsContract.buildDocumentUri(Authorities.FILES_PROVIDER, str4), "text/plain");
                                dataAndType.addFlags(3);
                                managedActivityResultLauncherRememberLauncherForActivityResult.launch(dataAndType);
                            }
                        } else if (fileAction instanceof FileAction.Rename) {
                            filesActivity$$ExternalSyntheticLambda10.invoke(((FileAction.Rename) fileAction).file);
                        } else if (fileAction instanceof FileAction.Delete) {
                            JobKt.launch$default(coroutineScope5, null, new RealImageLoader$executeMain$result$1(filesActivity4, filesActivity$Content$3$1$1, filesClient3, fileAction, null, 12), 3);
                        } else if (fileAction instanceof FileAction.Import) {
                            File file2 = ((FileAction.Import) fileAction).file;
                            if (file2 == null) {
                                managedActivityResultLauncher2.launch("*/*");
                            } else {
                                filesActivity$$ExternalSyntheticLambda10.invoke(file2);
                                managedActivityResultLauncherRememberLauncherForActivityResult2.launch("*/*");
                            }
                        } else {
                            if (!(fileAction instanceof FileAction.Export)) {
                                throw new HttpException();
                            }
                            File file3 = ((FileAction.Export) fileAction).file;
                            filesActivity$$ExternalSyntheticLambda10.invoke(file3);
                            managedActivityResultLauncherRememberLauncherForActivityResult4.launch(file3.name);
                        }
                        return Unit.INSTANCE;
                    }
                };
                snapshotStateList = snapshotStateList5;
                mutableState5 = mutableState15;
                filesClient2 = filesClient2;
                r4 = r1;
                coroutineScope = coroutineScope4;
                r17.updateRememberedValue(obj);
            } else {
                obj = objRememberedValue12;
                mutableState5 = mutableState2;
                snapshotStateList = snapshotStateList4;
                mutableState4 = mutableState11;
                z = false;
                r4 = r3;
            }
            Function1 function1 = (Function1) obj;
            r17.end(z);
            r17.startReplaceGroup(429650510);
            boolean zChangedInstance6 = r17.changedInstance(r4) | r17.changedInstance(coroutineScope) | (i4 == 4 ? true : z) | r17.changedInstance(filesClient2);
            Object objRememberedValue13 = r17.rememberedValue();
            if (zChangedInstance6 || objRememberedValue13 == neverEqualPolicy) {
                ?? r2 = r4;
                CoroutineScope coroutineScope5 = coroutineScope;
                SnapshotStateList snapshotStateList6 = snapshotStateList;
                FilesClient filesClient3 = filesClient2;
                FilesActivity$$ExternalSyntheticLambda6 filesActivity$$ExternalSyntheticLambda7 = new FilesActivity$$ExternalSyntheticLambda6(snapshotStateList6, r2, coroutineScope5, str, filesClient3, mutableState5, 1);
                snapshotStateList2 = snapshotStateList6;
                r12 = r2;
                coroutineScope = coroutineScope5;
                filesClient2 = filesClient3;
                r17.updateRememberedValue(filesActivity$$ExternalSyntheticLambda7);
                objRememberedValue13 = filesActivity$$ExternalSyntheticLambda7;
            } else {
                r12 = r4;
                snapshotStateList2 = snapshotStateList;
            }
            r17.end(z);
            FilesClient filesClient4 = filesClient2;
            CoroutineScope coroutineScope6 = coroutineScope;
            FilesScreenKt.FilesScreen(list, zBooleanValue, zBooleanValue2, function1, (Function0) objRememberedValue13, null, ((Boolean) r12.isTv$delegate.getValue()).booleanValue(), r17, 0);
            File file = (File) mutableState4.getValue();
            r17.startReplaceGroup(429658617);
            int i7 = 384;
            if (file == null) {
                i7 = 384;
                r6 = r12;
                coroutineScope2 = coroutineScope6;
                filesClient = filesClient4;
                snapshotStateList3 = snapshotStateList2;
                mutableState7 = mutableState5;
                z2 = false;
                r15 = r17;
            } else {
                String str3 = file.name;
                r17.startReplaceGroup(-1333770565);
                boolean zChangedInstance7 = r17.changedInstance(coroutineScope6) | r17.changedInstance(filesClient4) | r17.changedInstance(file) | r17.changedInstance(r12) | (i4 == 4);
                Object objRememberedValue14 = r17.rememberedValue();
                if (zChangedInstance7 || objRememberedValue14 == neverEqualPolicy) {
                    ?? r8 = r12;
                    filesClient = filesClient4;
                    SnapshotStateList snapshotStateList7 = snapshotStateList2;
                    MutableState mutableState16 = mutableState5;
                    mutableState6 = mutableState4;
                    coroutineScope2 = coroutineScope6;
                    GapComposer gapComposer2 = gapComposer;
                    filesActivity$$ExternalSyntheticLambda3 = new FilesActivity$$ExternalSyntheticLambda3(coroutineScope2, mutableState6, (FilesActivity) r8, filesClient, file, snapshotStateList7, str, mutableState16);
                    snapshotStateList3 = snapshotStateList7;
                    mutableState7 = mutableState16;
                    gapComposer2.updateRememberedValue(filesActivity$$ExternalSyntheticLambda3);
                    r5 = r8;
                    r14 = gapComposer2;
                } else {
                    r5 = r12;
                    snapshotStateList3 = snapshotStateList2;
                    mutableState7 = mutableState5;
                    mutableState6 = mutableState4;
                    coroutineScope2 = coroutineScope6;
                    r14 = r17;
                    filesActivity$$ExternalSyntheticLambda3 = objRememberedValue14;
                    filesClient = filesClient4;
                }
                Function1 function2 = (Function1) filesActivity$$ExternalSyntheticLambda3;
                z2 = false;
                Object objM6 = Density.CC.m(-1333772532, (GapComposer) r14, false);
                if (objM6 == neverEqualPolicy) {
                    objM6 = new TooltipKt$$ExternalSyntheticLambda0(mutableState6, 7);
                    r14.updateRememberedValue(objM6);
                }
                r14.end(false);
                FilesScreenKt.FileNameDialog(str3, function2, (Function0) objM6, r14, i7);
                Unit unit = Unit.INSTANCE;
                r6 = r5;
                r15 = r14;
            }
            r15.end(z2);
            Pair pair = (Pair) mutableState3.getValue();
            if (pair == null) {
                str2 = str;
                r7 = r6;
                r16 = r15;
            } else {
                String str4 = (String) pair.first;
                Uri uri = (Uri) pair.second;
                r15.startReplaceGroup(-1333753886);
                boolean zChangedInstance8 = r15.changedInstance(coroutineScope2) | r15.changedInstance(filesClient) | r15.changedInstance(uri) | r15.changedInstance(r6) | (i4 == 4);
                Object objRememberedValue15 = r15.rememberedValue();
                if (zChangedInstance8 || objRememberedValue15 == neverEqualPolicy) {
                    mutableState8 = mutableState3;
                    FilesActivity$$ExternalSyntheticLambda3 filesActivity$$ExternalSyntheticLambda4 = new FilesActivity$$ExternalSyntheticLambda3(coroutineScope2, mutableState8, (FilesActivity) r6, filesClient, snapshotStateList3, uri, str, mutableState7);
                    str2 = str;
                    r15.updateRememberedValue(filesActivity$$ExternalSyntheticLambda4);
                    objRememberedValue15 = filesActivity$$ExternalSyntheticLambda4;
                } else {
                    str2 = str;
                    mutableState8 = mutableState3;
                }
                Function1 function3 = (Function1) objRememberedValue15;
                Object objM7 = Density.CC.m(-1333756015, (GapComposer) r15, false);
                if (objM7 == neverEqualPolicy) {
                    objM7 = new TooltipKt$$ExternalSyntheticLambda0(mutableState8, 8);
                    r15.updateRememberedValue(objM7);
                }
                r15.end(false);
                FilesScreenKt.FileNameDialog(str4, function3, (Function0) objM7, r15, i7);
                Unit unit2 = Unit.INSTANCE;
                r7 = r6;
                r16 = r15;
            }
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = r16.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TextKt$$ExternalSyntheticLambda2(i, 21, r7, str2);
        }
    }

    public final void DisposableBackPressed(final Function0 function0, GapComposer gapComposer, int i) {
        int i2;
        gapComposer.startRestartGroup(-1644837280);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(true) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changedInstance(this) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            gapComposer.startReplaceGroup(1370202158);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new OnBackPressedCallback() { // from class: com.github.kr328.clash.FilesActivity$DisposableBackPressed$callback$1$1
                    {
                        super(true);
                    }

                    @Override // androidx.activity.OnBackPressedCallback
                    public final void handleOnBackPressed() {
                        function0.invoke();
                    }
                };
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            FilesActivity$DisposableBackPressed$callback$1$1 filesActivity$DisposableBackPressed$callback$1$1 = (FilesActivity$DisposableBackPressed$callback$1$1) objRememberedValue;
            gapComposer.end(false);
            Unit unit = Unit.INSTANCE;
            gapComposer.startReplaceGroup(1370208745);
            boolean zChangedInstance = gapComposer.changedInstance(this);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new BlurEffectKt$$ExternalSyntheticLambda1(10, this, filesActivity$DisposableBackPressed$callback$1$1);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            gapComposer.end(false);
            Stack.DisposableEffect(unit, (Function1) objRememberedValue2, gapComposer);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new FilesActivity$$ExternalSyntheticLambda16(i, 0, this, function0);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        UUID uuid = IntentKt.getUuid(getIntent());
        if (uuid == null) {
            finish();
        } else {
            ComponentActivityKt.setContent$default(this, new ComposableLambdaImpl(407225389, new AnonymousClass1(this, uuid, 0), true));
        }
    }
}
