package androidx.activity.compose;

import androidx.activity.BackEventCompat;
import androidx.activity.compose.internal.BackHandlerCompat$navigationEventHandler$1;
import androidx.appcompat.view.menu.BaseMenuWrapper;
import androidx.fragment.app.FragmentManager$1;
import coil.RealImageLoader$execute$3;
import com.github.kr328.clash.UpdateChecker$check$2;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ComposePredictiveBackHandler extends BaseMenuWrapper {
    public BufferedChannel activeChannel;
    public StandaloneCoroutine activeJob;
    public Function2 currentOnBack;
    public boolean isPredictiveBack;
    public final CoroutineScope scope;

    public ComposePredictiveBackHandler(CoroutineScope coroutineScope, PredictiveBackHandlerInfo predictiveBackHandlerInfo) {
        super(predictiveBackHandlerInfo);
        this.scope = coroutineScope;
        this.currentOnBack = new UpdateChecker$check$2(2, null, 1);
    }

    @Override // androidx.appcompat.view.menu.BaseMenuWrapper
    public final void onBackCancelled() {
        BufferedChannel bufferedChannel = this.activeChannel;
        if (bufferedChannel != null) {
            bufferedChannel.closeOrCancelImpl(new CancellationException("onBack cancelled"), true);
        }
        StandaloneCoroutine standaloneCoroutine = this.activeJob;
        if (standaloneCoroutine != null) {
            standaloneCoroutine.cancel((CancellationException) null);
        }
        this.activeChannel = null;
        this.activeJob = null;
        this.isPredictiveBack = false;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuWrapper
    public final void onBackCompleted() {
        if (this.activeChannel != null && !this.isPredictiveBack) {
            onBackCancelled();
        }
        if (this.activeChannel == null) {
            this.isPredictiveBack = false;
            this.activeChannel = ChannelKt.Channel$default(-2, 1, 4);
            this.activeJob = JobKt.launch$default(this.scope, null, new RealImageLoader$execute$3(this, (Continuation) null, 1), 3);
        }
        BufferedChannel bufferedChannel = this.activeChannel;
        if (bufferedChannel != null) {
            bufferedChannel.closeOrCancelImpl(null, false);
        }
        this.isPredictiveBack = false;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuWrapper
    public final void onBackProgressed(BackEventCompat backEventCompat) {
        BufferedChannel bufferedChannel = this.activeChannel;
        if (bufferedChannel != null) {
            bufferedChannel.mo842trySendJP2dKIU(backEventCompat);
        }
    }

    @Override // androidx.appcompat.view.menu.BaseMenuWrapper
    public final void onBackStarted() {
        onBackCancelled();
        if (super.isBackEnabled()) {
            this.isPredictiveBack = true;
            this.activeChannel = ChannelKt.Channel$default(-2, 1, 4);
            this.activeJob = JobKt.launch$default(this.scope, null, new RealImageLoader$execute$3(this, (Continuation) null, 1), 3);
        }
    }

    public final void setBackEnabled(boolean z) {
        StandaloneCoroutine standaloneCoroutine;
        if (!z && super.isBackEnabled() && (standaloneCoroutine = this.activeJob) != null && !standaloneCoroutine.isActive()) {
            onBackCancelled();
        }
        ((FragmentManager$1) this.mContext).setEnabled(z);
        ((BackHandlerCompat$navigationEventHandler$1) this.mMenuItems).setBackEnabled(z);
    }
}
