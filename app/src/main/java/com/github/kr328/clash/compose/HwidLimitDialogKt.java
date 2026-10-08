package com.github.kr328.clash.compose;

import android.content.Context;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.github.kr328.clash.design.compose.components.GlassSnackbarKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class HwidLimitDialogKt {
    public static final void HwidLimitDialog(String str, Function0 function0, GapComposer gapComposer, int i) {
        int i2;
        Function0 function1 = function0;
        gapComposer.startRestartGroup(1211237876);
        if ((i & 6) == 0) {
            i2 = i | (gapComposer.changed(str) ? 4 : 2);
        } else {
            i2 = i;
        }
        int i3 = i2 | (gapComposer.changedInstance(function1) ? 32 : 16);
        if ((i3 & 19) == 18 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            Context context = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
            SnackbarHostState snackbarHostState = (SnackbarHostState) gapComposer.consume(GlassSnackbarKt.LocalGlassSnackbarHost);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == Composer$Companion.Empty) {
                objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            function1 = function0;
            ScrimKt.m263AlertDialogOix01E0(function1, Thread_jvmKt.rememberComposableLambda(1109552700, new UpdateDialogKt.AnonymousClass1(1, function1), gapComposer), null, Thread_jvmKt.rememberComposableLambda(-172619586, new FilesScreenKt.AnonymousClass2(str, context, (CoroutineScope) objRememberedValue, function0, snackbarHostState), gapComposer), ComposableSingletons$HwidLimitDialogKt.f16lambda3, ComposableSingletons$HwidLimitDialogKt.f17lambda4, ComposableSingletons$HwidLimitDialogKt.f18lambda5, null, 0L, 0L, 0L, 0L, 0.0f, null, gapComposer, ((i3 >> 3) & 14) | 1797168, 16260);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new HwidLimitDialogKt$$ExternalSyntheticLambda0(str, function1, i, 0);
        }
    }
}
