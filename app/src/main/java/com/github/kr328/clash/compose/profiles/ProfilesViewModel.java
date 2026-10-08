package com.github.kr328.clash.compose.profiles;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelKt;
import com.github.kr328.clash.FilesActivity$showError$1;
import com.github.kr328.clash.compose.home.HomeViewModel$observer$1;
import com.github.kr328.clash.remote.Remote;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.ReadonlyStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ProfilesViewModel extends AndroidViewModel {
    public final StateFlowImpl _hwidLimit;
    public final StateFlowImpl _loaded;
    public final StateFlowImpl _profiles;
    public final StateFlowImpl _updatingProfiles;
    public final ReadonlyStateFlow hwidLimit;
    public final ReadonlyStateFlow loaded;
    public final HomeViewModel$observer$1 observer;
    public final ReadonlyStateFlow profiles;
    public final ReadonlyStateFlow updatingProfiles;

    public ProfilesViewModel(Application application) {
        super(application);
        StateFlowImpl stateFlowImplMutableStateFlow = FlowKt.MutableStateFlow(EmptyList.INSTANCE);
        this._profiles = stateFlowImplMutableStateFlow;
        this.profiles = FlowKt.asStateFlow(stateFlowImplMutableStateFlow);
        StateFlowImpl stateFlowImplMutableStateFlow2 = FlowKt.MutableStateFlow(Boolean.FALSE);
        this._loaded = stateFlowImplMutableStateFlow2;
        this.loaded = FlowKt.asStateFlow(stateFlowImplMutableStateFlow2);
        StateFlowImpl stateFlowImplMutableStateFlow3 = FlowKt.MutableStateFlow(EmptySet.INSTANCE);
        this._updatingProfiles = stateFlowImplMutableStateFlow3;
        this.updatingProfiles = FlowKt.asStateFlow(stateFlowImplMutableStateFlow3);
        StateFlowImpl stateFlowImplMutableStateFlow4 = FlowKt.MutableStateFlow(null);
        this._hwidLimit = stateFlowImplMutableStateFlow4;
        this.hwidLimit = FlowKt.asStateFlow(stateFlowImplMutableStateFlow4);
        HomeViewModel$observer$1 homeViewModel$observer$1 = new HomeViewModel$observer$1(2, this);
        this.observer = homeViewModel$observer$1;
        Remote.broadcasts.addObserver(homeViewModel$observer$1);
        refreshProfiles();
    }

    @Override // androidx.lifecycle.ViewModel
    public final void onCleared() {
        Remote.broadcasts.removeObserver(this.observer);
    }

    public final void refreshProfiles() {
        JobKt.launch$default(ViewModelKt.getViewModelScope(this), null, new FilesActivity$showError$1(this, null, 9), 3);
    }
}
