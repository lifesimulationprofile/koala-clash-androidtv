package com.github.kr328.clash;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import androidx.activity.compose.ComponentActivityKt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import coil.decode.BitmapFactoryDecoder$$ExternalSyntheticLambda2;
import coil.disk.DiskLruCache$$ExternalSyntheticLambda0;
import com.github.kr328.clash.design.compose.theme.AppThemeKt;
import com.google.android.gms.internal.mlkit_vision_common.zzjf;
import com.koala.clash.R;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.internal.ContextScope;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ShareToTvActivity extends AppCompatActivity implements CoroutineScope {
    public static final /* synthetic */ int $r8$clinit = 0;
    public String callbackUrl;
    public final /* synthetic */ ContextScope $$delegate_0 = JobKt.MainScope();
    public final StateFlowImpl profiles = FlowKt.MutableStateFlow(EmptyList.INSTANCE);
    public final StateFlowImpl loaded = FlowKt.MutableStateFlow(Boolean.FALSE);

    /* JADX INFO: renamed from: com.github.kr328.clash.ShareToTvActivity$onCreate$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass2 implements Function2 {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ ShareToTvActivity this$0;

        public /* synthetic */ AnonymousClass2(ShareToTvActivity shareToTvActivity, int i) {
            this.$r8$classId = i;
            this.this$0 = shareToTvActivity;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            switch (this.$r8$classId) {
                case 0:
                    GapComposer gapComposer = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
                        gapComposer.skipToGroupEnd();
                    } else {
                        AppThemeKt.AppTheme(false, Thread_jvmKt.rememberComposableLambda(581104729, new AnonymousClass2(this.this$0, 1), gapComposer), gapComposer, 48);
                    }
                    break;
                default:
                    GapComposer gapComposer2 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        ShareToTvActivity shareToTvActivity = this.this$0;
                        StateFlowImpl stateFlowImpl = shareToTvActivity.profiles;
                        StateFlowImpl stateFlowImpl2 = shareToTvActivity.loaded;
                        gapComposer2.startReplaceGroup(-489190502);
                        boolean zChangedInstance = gapComposer2.changedInstance(shareToTvActivity);
                        Object objRememberedValue = gapComposer2.rememberedValue();
                        NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
                        if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = new DiskLruCache$$ExternalSyntheticLambda0(8, shareToTvActivity);
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        }
                        Function1 function1 = (Function1) objRememberedValue;
                        gapComposer2.end(false);
                        gapComposer2.startReplaceGroup(-489188413);
                        boolean zChangedInstance2 = gapComposer2.changedInstance(shareToTvActivity);
                        Object objRememberedValue2 = gapComposer2.rememberedValue();
                        if (zChangedInstance2 || objRememberedValue2 == neverEqualPolicy) {
                            objRememberedValue2 = new BitmapFactoryDecoder$$ExternalSyntheticLambda2(11, shareToTvActivity);
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        }
                        gapComposer2.end(false);
                        zzjf.ShareToTvScreen(stateFlowImpl, stateFlowImpl2, function1, (Function0) objRememberedValue2, gapComposer2, 0);
                    }
                    break;
            }
            return Unit.INSTANCE;
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.coroutineContext;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Uri data = getIntent().getData();
        if (data == null) {
            finish();
            return;
        }
        String queryParameter = data.getQueryParameter("callback");
        this.callbackUrl = queryParameter;
        if (queryParameter == null || StringsKt.isBlank(queryParameter)) {
            Toast.makeText(this, R.string.share_to_tv_invalid_link, 0).show();
            finish();
        } else {
            JobKt.launch$default(this, null, new FilesActivity$showError$1(this, null, 4), 3);
            ComponentActivityKt.setContent$default(this, new ComposableLambdaImpl(1117456355, new AnonymousClass2(this, 0), true));
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity
    public final void onDestroy() {
        JobKt.cancel(this, (CancellationException) null);
        super.onDestroy();
    }
}
