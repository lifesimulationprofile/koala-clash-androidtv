package coil.util;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.emoji2.text.ConcurrencyHelpers$Handler28Impl;
import androidx.emoji2.text.EmojiCompatInitializer;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.google.mlkit.common.sdkinternal.zza;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: renamed from: coil.util.-Lifecycles$awaitStarted$2$1, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Lifecycles$awaitStarted$2$1 implements DefaultLifecycleObserver {
    public final /* synthetic */ Object $continuation;
    public final /* synthetic */ int $r8$classId = 1;

    public Lifecycles$awaitStarted$2$1(CancellableContinuationImpl cancellableContinuationImpl) {
        this.$continuation = cancellableContinuationImpl;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        int i = this.$r8$classId;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onResume(LifecycleOwner lifecycleOwner) {
        switch (this.$r8$classId) {
            case 0:
                break;
            default:
                (Build.VERSION.SDK_INT >= 28 ? ConcurrencyHelpers$Handler28Impl.createAsync(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new zza(1), 500L);
                ((Lifecycle) this.$continuation).removeObserver(this);
                break;
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onStart(LifecycleOwner lifecycleOwner) {
        switch (this.$r8$classId) {
            case 0:
                ((CancellableContinuationImpl) this.$continuation).resumeWith(Unit.INSTANCE);
                break;
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        int i = this.$r8$classId;
    }

    public Lifecycles$awaitStarted$2$1(EmojiCompatInitializer emojiCompatInitializer, Lifecycle lifecycle) {
        this.$continuation = lifecycle;
    }

    private final /* synthetic */ void onDestroy$androidx$emoji2$text$EmojiCompatInitializer$1(LifecycleOwner lifecycleOwner) {
    }

    /* JADX INFO: renamed from: onDestroy$coil$util$-Lifecycles$awaitStarted$2$1, reason: not valid java name */
    private final /* synthetic */ void m794onDestroy$coil$util$Lifecycles$awaitStarted$2$1(LifecycleOwner lifecycleOwner) {
    }

    /* JADX INFO: renamed from: onResume$coil$util$-Lifecycles$awaitStarted$2$1, reason: not valid java name */
    private final /* synthetic */ void m795onResume$coil$util$Lifecycles$awaitStarted$2$1(LifecycleOwner lifecycleOwner) {
    }

    private final /* synthetic */ void onStart$androidx$emoji2$text$EmojiCompatInitializer$1(LifecycleOwner lifecycleOwner) {
    }

    private final /* synthetic */ void onStop$androidx$emoji2$text$EmojiCompatInitializer$1(LifecycleOwner lifecycleOwner) {
    }

    /* JADX INFO: renamed from: onStop$coil$util$-Lifecycles$awaitStarted$2$1, reason: not valid java name */
    private final /* synthetic */ void m796onStop$coil$util$Lifecycles$awaitStarted$2$1(LifecycleOwner lifecycleOwner) {
    }
}
