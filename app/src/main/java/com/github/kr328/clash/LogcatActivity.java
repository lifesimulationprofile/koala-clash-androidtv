package com.github.kr328.clash;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import androidx.activity.compose.ComponentActivityKt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.AspectRatio;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.FlowRowOverflow;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.ThumbNode;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.unit.Density;
import androidx.lifecycle.ViewModelKt;
import coil.ImageLoader$Builder$$ExternalSyntheticLambda2;
import coil.RealImageLoader$executeMain$result$1;
import com.github.kr328.clash.common.compat.TvKt;
import com.github.kr328.clash.compose.LogcatScreenKt;
import com.github.kr328.clash.core.model.LogMessage;
import com.github.kr328.clash.design.compose.components.GlassSnackbarKt;
import com.github.kr328.clash.design.compose.theme.AppThemeKt;
import com.github.kr328.clash.design.model.LogFile;
import com.github.kr328.clash.log.LogcatFilter;
import com.koala.clash.R;
import io.github.g00fy2.quickie.ScanQRCode;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobKt__JobKt$invokeOnCompletion$1;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LogcatActivity extends AppCompatActivity {
    public static final /* synthetic */ int $r8$clinit = 0;
    public LogcatActivity$bindLogcatService$2$1 conn;
    public final SnackbarHostState snackbarHostState = new SnackbarHostState();

    /* JADX INFO: renamed from: com.github.kr328.clash.LogcatActivity$onCreate$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 implements Function2 {
        public final /* synthetic */ boolean $isTv;
        public final /* synthetic */ LogFile $logFile;
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ LogcatActivity this$0;

        public /* synthetic */ AnonymousClass1(int i, LogcatActivity logcatActivity, LogFile logFile, boolean z) {
            this.$r8$classId = i;
            this.$logFile = logFile;
            this.this$0 = logcatActivity;
            this.$isTv = z;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            int i = this.$r8$classId;
            boolean z = this.$isTv;
            LogcatActivity logcatActivity = this.this$0;
            LogFile logFile = this.$logFile;
            int i2 = 1;
            switch (i) {
                case 0:
                    GapComposer gapComposer = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
                        gapComposer.skipToGroupEnd();
                    } else {
                        AppThemeKt.AppTheme(false, Thread_jvmKt.rememberComposableLambda(749086821, new AnonymousClass1(i2, logcatActivity, logFile, z), gapComposer), gapComposer, 48);
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
                        if (logFile != null) {
                            gapComposer2.startReplaceGroup(-925964374);
                            Regex regex = LogFile.REGEX_FILE;
                            int i4 = LogcatActivity.$r8$clinit;
                            logcatActivity.LocalLogContent(logFile, z, gapComposer2, 8);
                            gapComposer2.end(false);
                        } else {
                            gapComposer2.startReplaceGroup(-925881201);
                            int i5 = LogcatActivity.$r8$clinit;
                            logcatActivity.StreamingLogContent(0, gapComposer2, z);
                            gapComposer2.end(false);
                        }
                        GlassSnackbarKt.GlassSnackbarHost(logcatActivity.snackbarHostState, flowRowOverflow.align(Modifier.Companion.$$INSTANCE, Alignment.Companion.BottomCenter), gapComposer2, 0, 0);
                        gapComposer2.end(true);
                    }
                    break;
            }
            return Unit.INSTANCE;
        }
    }

    public static final void access$copyMessage(LogcatActivity logcatActivity, LogMessage logMessage) {
        logcatActivity.getClass();
        ClipData clipDataNewPlainText = ClipData.newPlainText("log_message", logMessage.message);
        ClipboardManager clipboardManager = (ClipboardManager) logcatActivity.getSystemService(ClipboardManager.class);
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(clipDataNewPlainText);
        }
        JobKt.launch$default(ViewModelKt.getLifecycleScope(logcatActivity), null, new ThumbNode.AnonymousClass1(logcatActivity, (Continuation) null, 16), 3);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object access$writeLogTo(LogcatActivity logcatActivity, List list, LogFile logFile, Uri uri, ContinuationImpl continuationImpl) {
        LogcatActivity$writeLogTo$1 logcatActivity$writeLogTo$1;
        Throwable th;
        LogcatFilter logcatFilter;
        if (continuationImpl instanceof LogcatActivity$writeLogTo$1) {
            logcatActivity$writeLogTo$1 = (LogcatActivity$writeLogTo$1) continuationImpl;
            int i = logcatActivity$writeLogTo$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                logcatActivity$writeLogTo$1.label = i - Integer.MIN_VALUE;
            } else {
                logcatActivity$writeLogTo$1 = new LogcatActivity$writeLogTo$1(logcatActivity, continuationImpl);
            }
        } else {
            logcatActivity$writeLogTo$1 = new LogcatActivity$writeLogTo$1(logcatActivity, continuationImpl);
        }
        Object obj = logcatActivity$writeLogTo$1.result;
        int i2 = logcatActivity$writeLogTo$1.label;
        Continuation continuation = null;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            LogcatFilter logcatFilter2 = new LogcatFilter(new OutputStreamWriter(logcatActivity.getContentResolver().openOutputStream(uri)), logcatActivity);
            try {
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                DefaultIoScheduler defaultIoScheduler = DefaultIoScheduler.INSTANCE;
                try {
                    LogcatActivity$writeLogTo$2$1 logcatActivity$writeLogTo$2$1 = new LogcatActivity$writeLogTo$2$1(logcatFilter2, logFile, list, continuation, 0);
                    logcatActivity$writeLogTo$1.L$0 = logcatFilter2;
                    logcatActivity$writeLogTo$1.label = 1;
                    Object objWithContext = JobKt.withContext(defaultIoScheduler, logcatActivity$writeLogTo$2$1, logcatActivity$writeLogTo$1);
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (objWithContext == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    logcatFilter = logcatFilter2;
                } catch (Throwable th2) {
                    th = th2;
                    logcatFilter = logcatFilter2;
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            logcatFilter = logcatActivity$writeLogTo$1.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th4) {
                th = th4;
                try {
                    throw th;
                } catch (Throwable th5) {
                    CloseableKt.closeFinally(logcatFilter, th);
                    throw th5;
                }
            }
        }
        Unit unit = Unit.INSTANCE;
        CloseableKt.closeFinally(logcatFilter, null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:81:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:88:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:92:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:96:0x020d  */
    public final void LocalLogContent(LogFile logFile, boolean z, GapComposer gapComposer, int i) {
        int i2;
        Object obj;
        Object obj2;
        int i3;
        boolean z2;
        LogFile logFile2;
        boolean z3;
        boolean z4;
        Object obj3;
        Object obj4;
        boolean z5;
        boolean z6;
        Object obj5;
        boolean zChangedInstance;
        Object obj6;
        LogcatActivity logcatActivity;
        LogFile logFile3;
        gapComposer.startRestartGroup(767709007);
        int i4 = (gapComposer.changedInstance(logFile) ? 4 : 2) | i | (gapComposer.changed(z) ? 32 : 16) | (gapComposer.changedInstance(this) ? 256 : 128);
        if ((i4 & 147) == 146 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
            logFile3 = logFile;
            logcatActivity = this;
        } else {
            gapComposer.startReplaceGroup(225033800);
            Object objRememberedValue = gapComposer.rememberedValue();
            Object obj7 = Composer$Companion.Empty;
            Object obj8 = objRememberedValue;
            if (objRememberedValue == obj7) {
                Object objMutableStateOf$default = Stack.mutableStateOf$default(EmptyList.INSTANCE);
                gapComposer.updateRememberedValue(objMutableStateOf$default);
                obj8 = objMutableStateOf$default;
            }
            MutableState mutableState = (MutableState) obj8;
            gapComposer.end(false);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            Object obj9 = objRememberedValue2;
            if (objRememberedValue2 == obj7) {
                Object objCreateCompositionCoroutineScope = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objCreateCompositionCoroutineScope);
                obj9 = objCreateCompositionCoroutineScope;
            }
            CoroutineScope coroutineScope = (CoroutineScope) obj9;
            gapComposer.startReplaceGroup(225037867);
            int i5 = i4 & 14;
            boolean z7 = i5 == 4 || gapComposer.changed(logFile);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            Object obj10 = objRememberedValue3;
            if (z7 || objRememberedValue3 == obj7) {
                Object obj11 = DateFormat.getDateTimeInstance(2, 2).format(logFile.date);
                gapComposer.updateRememberedValue(obj11);
                obj10 = obj11;
            }
            String str = (String) obj10;
            gapComposer.end(false);
            gapComposer.startReplaceGroup(225043255);
            boolean zChangedInstance2 = gapComposer.changedInstance(this) | (i5 == 4 || gapComposer.changedInstance(logFile));
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue4 == obj7) {
                i2 = 1;
                Object realImageLoader$executeMain$result$1 = new RealImageLoader$executeMain$result$1(logFile, this, mutableState, null, 13);
                gapComposer.updateRememberedValue(realImageLoader$executeMain$result$1);
                objRememberedValue4 = realImageLoader$executeMain$result$1;
            } else {
                i2 = 1;
            }
            gapComposer.end(false);
            Regex regex = LogFile.REGEX_FILE;
            Stack.LaunchedEffect(gapComposer, logFile, (Function2) objRememberedValue4);
            ScanQRCode scanQRCode = new ScanQRCode(i2);
            gapComposer.startReplaceGroup(225065519);
            int i6 = (gapComposer.changedInstance(coroutineScope) ? 1 : 0) | (gapComposer.changedInstance(this) ? 1 : 0) | ((i5 == 4 || gapComposer.changedInstance(logFile)) ? i2 : 0);
            Object objRememberedValue5 = gapComposer.rememberedValue();
            Object obj12 = objRememberedValue5;
            if (i6 != 0 || objRememberedValue5 == obj7) {
                Object filesActivity$$ExternalSyntheticLambda10 = new FilesActivity$$ExternalSyntheticLambda10(coroutineScope, this, logFile, mutableState);
                gapComposer.updateRememberedValue(filesActivity$$ExternalSyntheticLambda10);
                obj12 = filesActivity$$ExternalSyntheticLambda10;
            }
            gapComposer.end(false);
            Object objRememberLauncherForActivityResult = AspectRatio.rememberLauncherForActivityResult(scanQRCode, (Function1) obj12, gapComposer, 0);
            List list = (List) mutableState.getValue();
            gapComposer.startReplaceGroup(225092731);
            boolean zChangedInstance3 = gapComposer.changedInstance(this);
            Object objRememberedValue6 = gapComposer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue6 == obj7) {
                obj = objRememberLauncherForActivityResult;
                obj2 = coroutineScope;
                i3 = i5;
                z2 = false;
                Object jobKt__JobKt$invokeOnCompletion$1 = new JobKt__JobKt$invokeOnCompletion$1(1, this, LogcatActivity.class, "copyMessage", "copyMessage(Lcom/github/kr328/clash/core/model/LogMessage;)V", 0, 0, 6);
                gapComposer.updateRememberedValue(jobKt__JobKt$invokeOnCompletion$1);
                objRememberedValue6 = jobKt__JobKt$invokeOnCompletion$1;
            } else {
                obj = objRememberLauncherForActivityResult;
                z2 = false;
                obj2 = coroutineScope;
                i3 = i5;
            }
            gapComposer.end(z2);
            Function1 function1 = (Function1) ((FunctionReferenceImpl) objRememberedValue6);
            gapComposer.startReplaceGroup(225093872);
            Object objRememberedValue7 = gapComposer.rememberedValue();
            Object obj13 = objRememberedValue7;
            if (objRememberedValue7 == obj7) {
                Object imageLoader$Builder$$ExternalSyntheticLambda2 = new ImageLoader$Builder$$ExternalSyntheticLambda2(21);
                gapComposer.updateRememberedValue(imageLoader$Builder$$ExternalSyntheticLambda2);
                obj13 = imageLoader$Builder$$ExternalSyntheticLambda2;
            }
            Function0 function0 = (Function0) obj13;
            gapComposer.end(z2);
            gapComposer.startReplaceGroup(225094919);
            boolean zChangedInstance4 = gapComposer.changedInstance(obj2) | gapComposer.changedInstance(this);
            int i7 = i3;
            if (i7 != 4) {
                logFile2 = logFile;
                if (!gapComposer.changedInstance(logFile2)) {
                    z3 = z2;
                }
                z4 = zChangedInstance4 | z3;
                Object objRememberedValue8 = gapComposer.rememberedValue();
                obj3 = objRememberedValue8;
                if (z4 || objRememberedValue8 == obj7) {
                    Object gapComposer$$ExternalSyntheticLambda0 = new GapComposer$$ExternalSyntheticLambda0(obj2, this, logFile2, 10);
                    gapComposer.updateRememberedValue(gapComposer$$ExternalSyntheticLambda0);
                    obj3 = gapComposer$$ExternalSyntheticLambda0;
                }
                Function0 function2 = (Function0) obj3;
                gapComposer.end(z2);
                gapComposer.startReplaceGroup(225101494);
                obj4 = obj;
                boolean zChangedInstance5 = gapComposer.changedInstance(obj4);
                if (i7 != 4 || gapComposer.changedInstance(logFile2)) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                z6 = zChangedInstance5 | z5;
                Object objRememberedValue9 = gapComposer.rememberedValue();
                obj5 = objRememberedValue9;
                if (z6 || objRememberedValue9 == obj7) {
                    Object recomposer$$ExternalSyntheticLambda6 = new Recomposer$$ExternalSyntheticLambda6(20, obj4, logFile2);
                    gapComposer.updateRememberedValue(recomposer$$ExternalSyntheticLambda6);
                    obj5 = recomposer$$ExternalSyntheticLambda6;
                }
                Function0 function3 = (Function0) obj5;
                gapComposer.end(z2);
                gapComposer.startReplaceGroup(225103738);
                zChangedInstance = gapComposer.changedInstance(this);
                Object objRememberedValue10 = gapComposer.rememberedValue();
                obj6 = objRememberedValue10;
                if (zChangedInstance || objRememberedValue10 == obj7) {
                    Object logcatActivity$$ExternalSyntheticLambda0 = new LogcatActivity$$ExternalSyntheticLambda0(this, 2);
                    gapComposer.updateRememberedValue(logcatActivity$$ExternalSyntheticLambda0);
                    obj6 = logcatActivity$$ExternalSyntheticLambda0;
                }
                gapComposer.end(z2);
                int i8 = ((i4 << 24) & 1879048192) | 24624;
                logcatActivity = this;
                logFile3 = logFile2;
                LogcatScreenKt.LogcatScreen(str, false, list, function1, function0, function2, function3, (Function0) obj6, null, z, gapComposer, i8);
            } else {
                logFile2 = logFile;
            }
            z3 = true;
            z4 = zChangedInstance4 | z3;
            Object objRememberedValue11 = gapComposer.rememberedValue();
            obj3 = objRememberedValue11;
            if (z4) {
                Object gapComposer$$ExternalSyntheticLambda1 = new GapComposer$$ExternalSyntheticLambda0(obj2, this, logFile2, 10);
                gapComposer.updateRememberedValue(gapComposer$$ExternalSyntheticLambda1);
                obj3 = gapComposer$$ExternalSyntheticLambda1;
            } else {
                Object gapComposer$$ExternalSyntheticLambda2 = new GapComposer$$ExternalSyntheticLambda0(obj2, this, logFile2, 10);
                gapComposer.updateRememberedValue(gapComposer$$ExternalSyntheticLambda2);
                obj3 = gapComposer$$ExternalSyntheticLambda2;
            }
            Function0 function4 = (Function0) obj3;
            gapComposer.end(z2);
            gapComposer.startReplaceGroup(225101494);
            obj4 = obj;
            boolean zChangedInstance6 = gapComposer.changedInstance(obj4);
            if (i7 != 4) {
                z5 = true;
            } else {
                z5 = true;
            }
            z6 = zChangedInstance6 | z5;
            Object objRememberedValue12 = gapComposer.rememberedValue();
            obj5 = objRememberedValue12;
            if (z6) {
                Object recomposer$$ExternalSyntheticLambda7 = new Recomposer$$ExternalSyntheticLambda6(20, obj4, logFile2);
                gapComposer.updateRememberedValue(recomposer$$ExternalSyntheticLambda7);
                obj5 = recomposer$$ExternalSyntheticLambda7;
            } else {
                Object recomposer$$ExternalSyntheticLambda8 = new Recomposer$$ExternalSyntheticLambda6(20, obj4, logFile2);
                gapComposer.updateRememberedValue(recomposer$$ExternalSyntheticLambda8);
                obj5 = recomposer$$ExternalSyntheticLambda8;
            }
            Function0 function5 = (Function0) obj5;
            gapComposer.end(z2);
            gapComposer.startReplaceGroup(225103738);
            zChangedInstance = gapComposer.changedInstance(this);
            Object objRememberedValue13 = gapComposer.rememberedValue();
            obj6 = objRememberedValue13;
            if (zChangedInstance) {
                Object logcatActivity$$ExternalSyntheticLambda1 = new LogcatActivity$$ExternalSyntheticLambda0(this, 2);
                gapComposer.updateRememberedValue(logcatActivity$$ExternalSyntheticLambda1);
                obj6 = logcatActivity$$ExternalSyntheticLambda1;
            } else {
                Object logcatActivity$$ExternalSyntheticLambda2 = new LogcatActivity$$ExternalSyntheticLambda0(this, 2);
                gapComposer.updateRememberedValue(logcatActivity$$ExternalSyntheticLambda2);
                obj6 = logcatActivity$$ExternalSyntheticLambda2;
            }
            gapComposer.end(z2);
            int i9 = ((i4 << 24) & 1879048192) | 24624;
            logcatActivity = this;
            logFile3 = logFile2;
            LogcatScreenKt.LogcatScreen(str, false, list, function1, function0, function4, function5, (Function0) obj6, null, z, gapComposer, i9);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new LogcatActivity$$ExternalSyntheticLambda10(i, logcatActivity, logFile3, z);
        }
    }

    public final void StreamingLogContent(int i, GapComposer gapComposer, boolean z) {
        gapComposer.startRestartGroup(2075958258);
        int i2 = (gapComposer.changed(z) ? 4 : 2) | i | (gapComposer.changedInstance(this) ? 32 : 16);
        if ((i2 & 19) == 18 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            gapComposer.startReplaceGroup(-302129953);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.mutableStateOf$default(EmptyList.INSTANCE);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            gapComposer.end(false);
            Unit unit = Unit.INSTANCE;
            gapComposer.startReplaceGroup(-302126721);
            boolean zChangedInstance = gapComposer.changedInstance(this);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new LogcatActivity$StreamingLogContent$1$1(this, mutableState, null);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            gapComposer.end(false);
            Stack.LaunchedEffect(gapComposer, unit, (Function2) objRememberedValue2);
            String string = getString(R.string.clash_logcat);
            List list = (List) mutableState.getValue();
            gapComposer.startReplaceGroup(-302107822);
            boolean zChangedInstance2 = gapComposer.changedInstance(this);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue3 == neverEqualPolicy) {
                JobKt__JobKt$invokeOnCompletion$1 jobKt__JobKt$invokeOnCompletion$1 = new JobKt__JobKt$invokeOnCompletion$1(1, this, LogcatActivity.class, "copyMessage", "copyMessage(Lcom/github/kr328/clash/core/model/LogMessage;)V", 0, 0, 7);
                gapComposer.updateRememberedValue(jobKt__JobKt$invokeOnCompletion$1);
                objRememberedValue3 = jobKt__JobKt$invokeOnCompletion$1;
            }
            gapComposer.end(false);
            Function1 function1 = (Function1) ((FunctionReferenceImpl) objRememberedValue3);
            gapComposer.startReplaceGroup(-302106586);
            boolean zChangedInstance3 = gapComposer.changedInstance(this);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = new LogcatActivity$$ExternalSyntheticLambda0(this, 0);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            Function0 function0 = (Function0) objRememberedValue4;
            Object objM = Density.CC.m(-302102777, gapComposer, false);
            if (objM == neverEqualPolicy) {
                objM = new ImageLoader$Builder$$ExternalSyntheticLambda2(19);
                gapComposer.updateRememberedValue(objM);
            }
            Function0 function2 = (Function0) objM;
            Object objM2 = Density.CC.m(-302101913, gapComposer, false);
            if (objM2 == neverEqualPolicy) {
                objM2 = new ImageLoader$Builder$$ExternalSyntheticLambda2(20);
                gapComposer.updateRememberedValue(objM2);
            }
            Function0 function3 = (Function0) objM2;
            gapComposer.end(false);
            gapComposer.startReplaceGroup(-302100847);
            boolean zChangedInstance4 = gapComposer.changedInstance(this);
            Object objRememberedValue5 = gapComposer.rememberedValue();
            if (zChangedInstance4 || objRememberedValue5 == neverEqualPolicy) {
                objRememberedValue5 = new LogcatActivity$$ExternalSyntheticLambda0(this, 1);
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            gapComposer.end(false);
            LogcatScreenKt.LogcatScreen(string, true, list, function1, function0, function2, function3, (Function0) objRememberedValue5, null, z, gapComposer, ((i2 << 27) & 1879048192) | 1769520);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new LogcatActivity$$ExternalSyntheticLambda4(i, 0, this, z);
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0029  */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        String schemeSpecificPart;
        Uri data;
        super.onCreate(bundle);
        boolean zIsTvDevice = TvKt.isTvDevice(this);
        Intent intent = getIntent();
        LogFile fromFileName = null;
        if (intent == null || (data = intent.getData()) == null) {
            schemeSpecificPart = null;
        } else {
            if (!Intrinsics.areEqual(data.getScheme(), "file")) {
                data = null;
            }
            if (data != null) {
                schemeSpecificPart = data.getSchemeSpecificPart();
            } else {
                schemeSpecificPart = null;
            }
        }
        if (schemeSpecificPart != null) {
            Regex regex = LogFile.REGEX_FILE;
            fromFileName = LogFile.Companion.parseFromFileName(schemeSpecificPart);
        }
        if (schemeSpecificPart == null || fromFileName != null) {
            ComponentActivityKt.setContent$default(this, new ComposableLambdaImpl(1592666991, new AnonymousClass1(0, this, fromFileName, zIsTvDevice), true));
        } else {
            Toast.makeText(this, R.string.invalid_log_file, 1).show();
            finish();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public final void onDestroy() {
        LogcatActivity$bindLogcatService$2$1 logcatActivity$bindLogcatService$2$1 = this.conn;
        if (logcatActivity$bindLogcatService$2$1 != null) {
            unbindService(logcatActivity$bindLogcatService$2$1);
        }
        super.onDestroy();
    }
}
