package com.github.kr328.clash.compose.home;

import androidx.compose.runtime.MutableState;
import androidx.lifecycle.ViewModelKt;
import com.github.kr328.clash.compose.profiles.ProfilesViewModel;
import com.github.kr328.clash.compose.proxy.ProxyViewModel;
import com.github.kr328.clash.compose.proxy.ProxyViewModel$reload$1;
import com.github.kr328.clash.design.compose.components.ControlButtonState;
import com.github.kr328.clash.remote.Broadcasts$Observer;
import com.github.kr328.clash.service.HwidLimitMarker;
import com.github.kr328.clash.service.ProfileProcessorKt;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import kotlin.collections.SetsKt;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class HomeViewModel$observer$1 implements Broadcasts$Observer {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object this$0;

    public /* synthetic */ HomeViewModel$observer$1(int i, Object obj) {
        this.$r8$classId = i;
        this.this$0 = obj;
    }

    @Override // com.github.kr328.clash.remote.Broadcasts$Observer
    public final void onProfileChanged() {
        switch (this.$r8$classId) {
            case 0:
                HomeViewModel homeViewModel = (HomeViewModel) this.this$0;
                homeViewModel.refreshActiveProfile();
                if (homeViewModel._tunnelState.getValue() == ControlButtonState.Connected) {
                    homeViewModel.startProxyTicker();
                }
                break;
            case 2:
                ((ProfilesViewModel) this.this$0).refreshProfiles();
                break;
        }
    }

    @Override // com.github.kr328.clash.remote.Broadcasts$Observer
    public final void onProfileLoaded() {
        switch (this.$r8$classId) {
            case 0:
                HomeViewModel homeViewModel = (HomeViewModel) this.this$0;
                homeViewModel.refreshActiveProfile();
                if (homeViewModel._tunnelState.getValue() == ControlButtonState.Connected) {
                    homeViewModel.startProxyTicker();
                }
                break;
            case 1:
                break;
            case 2:
                ((ProfilesViewModel) this.this$0).refreshProfiles();
                break;
            default:
                ProxyViewModel proxyViewModel = (ProxyViewModel) this.this$0;
                JobKt.launch$default(ViewModelKt.getViewModelScope(proxyViewModel), null, new ProxyViewModel$reload$1(proxyViewModel, null), 3);
                break;
        }
    }

    @Override // com.github.kr328.clash.remote.Broadcasts$Observer
    public final void onProfileUpdateCompleted(UUID uuid) {
        Object value;
        switch (this.$r8$classId) {
            case 0:
                ((HomeViewModel) this.this$0).refreshActiveProfile();
                break;
            case 2:
                ProfilesViewModel profilesViewModel = (ProfilesViewModel) this.this$0;
                if (uuid != null) {
                    StateFlowImpl stateFlowImpl = profilesViewModel._updatingProfiles;
                    do {
                        value = stateFlowImpl.getValue();
                    } while (!stateFlowImpl.compareAndSet(value, SetsKt.minus((Set) value, uuid)));
                }
                profilesViewModel.refreshProfiles();
                break;
        }
    }

    @Override // com.github.kr328.clash.remote.Broadcasts$Observer
    public final void onProfileUpdateFailed(UUID uuid, String str) {
        Object value;
        switch (this.$r8$classId) {
            case 2:
                ProfilesViewModel profilesViewModel = (ProfilesViewModel) this.this$0;
                if (uuid != null) {
                    StateFlowImpl stateFlowImpl = profilesViewModel._updatingProfiles;
                    do {
                        value = stateFlowImpl.getValue();
                    } while (!stateFlowImpl.compareAndSet(value, SetsKt.minus((Set) value, uuid)));
                }
                HwidLimitMarker hwidLimitMarker = ProfileProcessorKt.parseHwidLimitMarker(str);
                if (hwidLimitMarker != null) {
                    StateFlowImpl stateFlowImpl2 = profilesViewModel._hwidLimit;
                    stateFlowImpl2.getClass();
                    stateFlowImpl2.updateState(null, hwidLimitMarker);
                }
                profilesViewModel.refreshProfiles();
                break;
        }
    }

    @Override // com.github.kr328.clash.remote.Broadcasts$Observer
    public final void onServiceRecreated() {
        switch (this.$r8$classId) {
            case 0:
                HomeViewModel homeViewModel = (HomeViewModel) this.this$0;
                StandaloneCoroutine standaloneCoroutine = homeViewModel.transitionWatchdog;
                if (standaloneCoroutine != null) {
                    standaloneCoroutine.cancel((CancellationException) null);
                }
                StateFlowImpl stateFlowImpl = homeViewModel._tunnelState;
                stateFlowImpl.getClass();
                stateFlowImpl.updateState(null, ControlButtonState.Disconnected);
                homeViewModel._tunnelStartedAt.setValue(null);
                StandaloneCoroutine standaloneCoroutine2 = homeViewModel.proxyTickerJob;
                if (standaloneCoroutine2 != null) {
                    standaloneCoroutine2.cancel((CancellationException) null);
                }
                homeViewModel.proxyTickerJob = null;
                homeViewModel._currentProxy.setValue(null);
                homeViewModel.refreshActiveProfile();
                break;
            case 1:
                ((MutableState) this.this$0).setValue(Boolean.FALSE);
                break;
        }
    }

    @Override // com.github.kr328.clash.remote.Broadcasts$Observer
    public final void onStarted() {
        switch (this.$r8$classId) {
            case 0:
                HomeViewModel homeViewModel = (HomeViewModel) this.this$0;
                StateFlowImpl stateFlowImpl = homeViewModel._tunnelStartedAt;
                StandaloneCoroutine standaloneCoroutine = homeViewModel.transitionWatchdog;
                if (standaloneCoroutine != null) {
                    standaloneCoroutine.cancel((CancellationException) null);
                }
                StateFlowImpl stateFlowImpl2 = homeViewModel._tunnelState;
                stateFlowImpl2.getClass();
                stateFlowImpl2.updateState(null, ControlButtonState.Connected);
                if (stateFlowImpl.getValue() == null) {
                    Long lValueOf = Long.valueOf(System.currentTimeMillis());
                    stateFlowImpl.getClass();
                    stateFlowImpl.updateState(null, lValueOf);
                }
                homeViewModel.startProxyTicker();
                homeViewModel.refreshActiveProfile();
                break;
            case 1:
                ((MutableState) this.this$0).setValue(Boolean.TRUE);
                break;
        }
    }

    @Override // com.github.kr328.clash.remote.Broadcasts$Observer
    public final void onStopped() {
        switch (this.$r8$classId) {
            case 0:
                HomeViewModel homeViewModel = (HomeViewModel) this.this$0;
                StandaloneCoroutine standaloneCoroutine = homeViewModel.transitionWatchdog;
                if (standaloneCoroutine != null) {
                    standaloneCoroutine.cancel((CancellationException) null);
                }
                StateFlowImpl stateFlowImpl = homeViewModel._tunnelState;
                stateFlowImpl.getClass();
                stateFlowImpl.updateState(null, ControlButtonState.Disconnected);
                homeViewModel._tunnelStartedAt.setValue(null);
                StandaloneCoroutine standaloneCoroutine2 = homeViewModel.proxyTickerJob;
                if (standaloneCoroutine2 != null) {
                    standaloneCoroutine2.cancel((CancellationException) null);
                }
                homeViewModel.proxyTickerJob = null;
                homeViewModel._currentProxy.setValue(null);
                break;
            case 1:
                ((MutableState) this.this$0).setValue(Boolean.FALSE);
                break;
        }
    }

    private final void onProfileChanged$com$github$kr328$clash$compose$connections$ConnectionsScreenKt$ConnectionsScreen$2$1$observer$1() {
    }

    private final void onProfileChanged$com$github$kr328$clash$compose$proxy$ProxySelectorSheetKt$ProxySelectorSheet$2$1$observer$1() {
    }

    private final void onProfileLoaded$com$github$kr328$clash$compose$connections$ConnectionsScreenKt$ConnectionsScreen$2$1$observer$1() {
    }

    private final void onServiceRecreated$com$github$kr328$clash$compose$profiles$ProfilesViewModel$observer$1() {
    }

    private final void onServiceRecreated$com$github$kr328$clash$compose$proxy$ProxySelectorSheetKt$ProxySelectorSheet$2$1$observer$1() {
    }

    private final void onStarted$com$github$kr328$clash$compose$profiles$ProfilesViewModel$observer$1() {
    }

    private final void onStarted$com$github$kr328$clash$compose$proxy$ProxySelectorSheetKt$ProxySelectorSheet$2$1$observer$1() {
    }

    private final void onStopped$com$github$kr328$clash$compose$profiles$ProfilesViewModel$observer$1() {
    }

    private final void onStopped$com$github$kr328$clash$compose$proxy$ProxySelectorSheetKt$ProxySelectorSheet$2$1$observer$1() {
    }

    private final void onProfileUpdateCompleted$com$github$kr328$clash$compose$connections$ConnectionsScreenKt$ConnectionsScreen$2$1$observer$1(UUID uuid) {
    }

    private final void onProfileUpdateCompleted$com$github$kr328$clash$compose$proxy$ProxySelectorSheetKt$ProxySelectorSheet$2$1$observer$1(UUID uuid) {
    }

    private final void onProfileUpdateFailed$com$github$kr328$clash$compose$connections$ConnectionsScreenKt$ConnectionsScreen$2$1$observer$1(UUID uuid, String str) {
    }

    private final void onProfileUpdateFailed$com$github$kr328$clash$compose$home$HomeViewModel$observer$1(UUID uuid, String str) {
    }

    private final void onProfileUpdateFailed$com$github$kr328$clash$compose$proxy$ProxySelectorSheetKt$ProxySelectorSheet$2$1$observer$1(UUID uuid, String str) {
    }
}
