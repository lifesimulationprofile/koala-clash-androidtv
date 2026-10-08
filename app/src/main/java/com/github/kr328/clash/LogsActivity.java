package com.github.kr328.clash;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.compose.ComponentActivityKt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.unit.Density;
import coil.disk.DiskLruCache$$ExternalSyntheticLambda0;
import com.github.kr328.clash.common.compat.TvKt;
import com.github.kr328.clash.common.util.ComponentsKt;
import com.github.kr328.clash.compose.LogsScreenKt;
import com.github.kr328.clash.design.compose.theme.AppThemeKt;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LogsActivity extends AppCompatActivity {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* JADX INFO: renamed from: com.github.kr328.clash.LogsActivity$onCreate$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 implements Function2 {
        public final /* synthetic */ boolean $isTv;
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ LogsActivity this$0;

        public /* synthetic */ AnonymousClass1(LogsActivity logsActivity, boolean z, int i) {
            this.$r8$classId = i;
            this.this$0 = logsActivity;
            this.$isTv = z;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            switch (this.$r8$classId) {
                case 0:
                    GapComposer gapComposer = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
                        gapComposer.skipToGroupEnd();
                    } else {
                        AppThemeKt.AppTheme(false, Thread_jvmKt.rememberComposableLambda(106627525, new AnonymousClass1(this.this$0, this.$isTv, 1), gapComposer), gapComposer, 48);
                    }
                    break;
                default:
                    GapComposer gapComposer2 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        gapComposer2.startReplaceGroup(-26817019);
                        Object objRememberedValue = gapComposer2.rememberedValue();
                        NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
                        if (objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = Stack.mutableStateOf$default(EmptyList.INSTANCE);
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        }
                        MutableState mutableState = (MutableState) objRememberedValue;
                        Object objM = Density.CC.m(-26814068, gapComposer2, false);
                        if (objM == neverEqualPolicy) {
                            objM = Stack.mutableStateOf$default(0);
                            gapComposer2.updateRememberedValue(objM);
                        }
                        MutableState mutableState2 = (MutableState) objM;
                        gapComposer2.end(false);
                        Integer numValueOf = Integer.valueOf(((Number) mutableState2.getValue()).intValue());
                        gapComposer2.startReplaceGroup(-26811411);
                        final LogsActivity logsActivity = this.this$0;
                        boolean zChanged = gapComposer2.changed(logsActivity);
                        Object objRememberedValue2 = gapComposer2.rememberedValue();
                        if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                            objRememberedValue2 = new LogsActivity$onCreate$1$1$1$1(logsActivity, mutableState, null, 0);
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        }
                        gapComposer2.end(false);
                        Stack.LaunchedEffect(gapComposer2, numValueOf, (Function2) objRememberedValue2);
                        List list = (List) mutableState.getValue();
                        gapComposer2.startReplaceGroup(-26801142);
                        boolean zChanged2 = gapComposer2.changed(logsActivity);
                        Object objRememberedValue3 = gapComposer2.rememberedValue();
                        if (zChanged2 || objRememberedValue3 == neverEqualPolicy) {
                            final int i = 0;
                            objRememberedValue3 = new Function0() { // from class: com.github.kr328.clash.LogsActivity$onCreate$1$1$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    switch (i) {
                                        case 0:
                                            Intent intent = ComponentsKt.getIntent(Reflection.getOrCreateKotlinClass(LogcatActivity.class));
                                            LogsActivity logsActivity2 = logsActivity;
                                            logsActivity2.startActivity(intent);
                                            logsActivity2.finish();
                                            break;
                                        default:
                                            logsActivity.finish();
                                            break;
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            gapComposer2.updateRememberedValue(objRememberedValue3);
                        }
                        Function0 function0 = (Function0) objRememberedValue3;
                        gapComposer2.end(false);
                        gapComposer2.startReplaceGroup(-26796084);
                        boolean zChanged3 = gapComposer2.changed(logsActivity);
                        Object objRememberedValue4 = gapComposer2.rememberedValue();
                        if (zChanged3 || objRememberedValue4 == neverEqualPolicy) {
                            objRememberedValue4 = new DiskLruCache$$ExternalSyntheticLambda0(7, logsActivity);
                            gapComposer2.updateRememberedValue(objRememberedValue4);
                        }
                        Function1 function1 = (Function1) objRememberedValue4;
                        gapComposer2.end(false);
                        gapComposer2.startReplaceGroup(-26790809);
                        boolean zChanged4 = gapComposer2.changed(logsActivity);
                        Object objRememberedValue5 = gapComposer2.rememberedValue();
                        if (zChanged4 || objRememberedValue5 == neverEqualPolicy) {
                            objRememberedValue5 = new Recomposer$$ExternalSyntheticLambda6(21, logsActivity, mutableState2);
                            gapComposer2.updateRememberedValue(objRememberedValue5);
                        }
                        Function0 function2 = (Function0) objRememberedValue5;
                        gapComposer2.end(false);
                        gapComposer2.startReplaceGroup(-26782822);
                        boolean zChanged5 = gapComposer2.changed(logsActivity);
                        Object objRememberedValue6 = gapComposer2.rememberedValue();
                        if (zChanged5 || objRememberedValue6 == neverEqualPolicy) {
                            final int i2 = 1;
                            objRememberedValue6 = new Function0() { // from class: com.github.kr328.clash.LogsActivity$onCreate$1$1$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    switch (i2) {
                                        case 0:
                                            Intent intent = ComponentsKt.getIntent(Reflection.getOrCreateKotlinClass(LogcatActivity.class));
                                            LogsActivity logsActivity2 = logsActivity;
                                            logsActivity2.startActivity(intent);
                                            logsActivity2.finish();
                                            break;
                                        default:
                                            logsActivity.finish();
                                            break;
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            gapComposer2.updateRememberedValue(objRememberedValue6);
                        }
                        gapComposer2.end(false);
                        LogsScreenKt.LogsScreen(list, function0, function1, function2, (Function0) objRememberedValue6, null, this.$isTv, gapComposer2, 0);
                    }
                    break;
            }
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ComponentActivityKt.setContent$default(this, new ComposableLambdaImpl(-1050535473, new AnonymousClass1(this, TvKt.isTvDevice(this), 0), true));
    }
}
