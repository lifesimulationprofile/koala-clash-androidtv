package com.github.kr328.clash;

import android.os.Bundle;
import androidx.activity.compose.ComponentActivityKt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.navigation.compose.NavHostKt$NavHost$28$1;
import coil.decode.BitmapFactoryDecoder$$ExternalSyntheticLambda2;
import com.github.kr328.clash.compose.AppCrashedScreenKt;
import com.github.kr328.clash.design.compose.theme.AppThemeKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AppCrashedActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: com.github.kr328.clash.AppCrashedActivity$onCreate$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 implements Function2 {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ AppCrashedActivity this$0;

        public /* synthetic */ AnonymousClass1(AppCrashedActivity appCrashedActivity, int i) {
            this.$r8$classId = i;
            this.this$0 = appCrashedActivity;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            switch (this.$r8$classId) {
                case 0:
                    GapComposer gapComposer = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
                        gapComposer.skipToGroupEnd();
                    } else {
                        AppThemeKt.AppTheme(false, Thread_jvmKt.rememberComposableLambda(137236037, new AnonymousClass1(this.this$0, 1), gapComposer), gapComposer, 48);
                    }
                    break;
                default:
                    GapComposer gapComposer2 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        gapComposer2.startReplaceGroup(-1154450729);
                        Object objRememberedValue = gapComposer2.rememberedValue();
                        NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
                        if (objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = Stack.mutableStateOf$default("");
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        }
                        MutableState mutableState = (MutableState) objRememberedValue;
                        gapComposer2.end(false);
                        Unit unit = Unit.INSTANCE;
                        gapComposer2.startReplaceGroup(-1154448127);
                        AppCrashedActivity appCrashedActivity = this.this$0;
                        boolean zChanged = gapComposer2.changed(appCrashedActivity);
                        Object objRememberedValue2 = gapComposer2.rememberedValue();
                        Continuation continuation = null;
                        if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                            objRememberedValue2 = new NavHostKt$NavHost$28$1((AppCompatActivity) appCrashedActivity, mutableState, continuation, 25);
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        }
                        gapComposer2.end(false);
                        Stack.LaunchedEffect(gapComposer2, unit, (Function2) objRememberedValue2);
                        String str = (String) mutableState.getValue();
                        gapComposer2.startReplaceGroup(-1154432540);
                        boolean zChanged2 = gapComposer2.changed(appCrashedActivity);
                        Object objRememberedValue3 = gapComposer2.rememberedValue();
                        if (zChanged2 || objRememberedValue3 == neverEqualPolicy) {
                            objRememberedValue3 = new BitmapFactoryDecoder$$ExternalSyntheticLambda2(4, appCrashedActivity);
                            gapComposer2.updateRememberedValue(objRememberedValue3);
                        }
                        gapComposer2.end(false);
                        AppCrashedScreenKt.AppCrashedScreen(str, (Function0) objRememberedValue3, null, gapComposer2, 0);
                    }
                    break;
            }
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ComponentActivityKt.setContent$default(this, new ComposableLambdaImpl(175073103, new AnonymousClass1(this, 0), true));
    }
}
