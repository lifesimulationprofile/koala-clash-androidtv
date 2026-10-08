package com.github.kr328.clash;

import android.os.Bundle;
import androidx.activity.compose.ComponentActivityKt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import coil.decode.BitmapFactoryDecoder$$ExternalSyntheticLambda2;
import coil.disk.DiskLruCache$$ExternalSyntheticLambda0;
import com.github.kr328.clash.compose.ApkBrokenScreenKt;
import com.github.kr328.clash.design.compose.theme.AppThemeKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ApkBrokenActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: com.github.kr328.clash.ApkBrokenActivity$onCreate$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 implements Function2 {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ ApkBrokenActivity this$0;

        public /* synthetic */ AnonymousClass1(ApkBrokenActivity apkBrokenActivity, int i) {
            this.$r8$classId = i;
            this.this$0 = apkBrokenActivity;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            switch (this.$r8$classId) {
                case 0:
                    GapComposer gapComposer = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
                        gapComposer.skipToGroupEnd();
                    } else {
                        AppThemeKt.AppTheme(false, Thread_jvmKt.rememberComposableLambda(1881137391, new AnonymousClass1(this.this$0, 1), gapComposer), gapComposer, 48);
                    }
                    break;
                default:
                    GapComposer gapComposer2 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        gapComposer2.startReplaceGroup(-413129830);
                        ApkBrokenActivity apkBrokenActivity = this.this$0;
                        boolean zChanged = gapComposer2.changed(apkBrokenActivity);
                        Object objRememberedValue = gapComposer2.rememberedValue();
                        NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
                        if (zChanged || objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = new DiskLruCache$$ExternalSyntheticLambda0(6, apkBrokenActivity);
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        }
                        Function1 function1 = (Function1) objRememberedValue;
                        gapComposer2.end(false);
                        gapComposer2.startReplaceGroup(-413124850);
                        boolean zChanged2 = gapComposer2.changed(apkBrokenActivity);
                        Object objRememberedValue2 = gapComposer2.rememberedValue();
                        if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                            objRememberedValue2 = new BitmapFactoryDecoder$$ExternalSyntheticLambda2(3, apkBrokenActivity);
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        }
                        gapComposer2.end(false);
                        ApkBrokenScreenKt.ApkBrokenScreen(function1, (Function0) objRememberedValue2, null, gapComposer2, 0);
                    }
                    break;
            }
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ComponentActivityKt.setContent$default(this, new ComposableLambdaImpl(-1877478279, new AnonymousClass1(this, 0), true));
    }
}
