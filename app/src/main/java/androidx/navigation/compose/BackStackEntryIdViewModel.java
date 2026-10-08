package androidx.navigation.compose;

import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.internal.SavedStateHandleImpl_androidKt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class BackStackEntryIdViewModel extends ViewModel {
    public final String IdKey = "SaveableStateHolder_BackStackEntryKey";
    public final UUID id;
    public WeakReference saveableStateHolderRef;

    public BackStackEntryIdViewModel(SavedStateHandle savedStateHandle) {
        Object value;
        Object obj;
        Request request = savedStateHandle.impl;
        LinkedHashMap linkedHashMap = (LinkedHashMap) request.url;
        LinkedHashMap linkedHashMap2 = (LinkedHashMap) request.tags;
        try {
            MutableStateFlow mutableStateFlow = (MutableStateFlow) linkedHashMap2.get("SaveableStateHolder_BackStackEntryKey");
            if (mutableStateFlow == null || (value = ((StateFlowImpl) mutableStateFlow).getValue()) == null) {
                value = linkedHashMap.get("SaveableStateHolder_BackStackEntryKey");
            }
        } catch (ClassCastException unused) {
            linkedHashMap.remove("SaveableStateHolder_BackStackEntryKey");
            ((LinkedHashMap) request.headers).remove("SaveableStateHolder_BackStackEntryKey");
            linkedHashMap2.remove("SaveableStateHolder_BackStackEntryKey");
            value = null;
        }
        UUID uuidRandomUUID = (UUID) value;
        if (uuidRandomUUID == null) {
            uuidRandomUUID = UUID.randomUUID();
            String str = this.IdKey;
            if (uuidRandomUUID != null) {
                ArrayList arrayList = SavedStateHandleImpl_androidKt.ACCEPTABLE_CLASSES;
                if (arrayList == null || !arrayList.isEmpty()) {
                    int size = arrayList.size();
                    int i = 0;
                    do {
                        if (i < size) {
                            obj = arrayList.get(i);
                            i++;
                        }
                    } while (!((Class) obj).isInstance(uuidRandomUUID));
                }
                throw new IllegalArgumentException(("Can't put value with type " + uuidRandomUUID.getClass() + " into saved state").toString());
            }
            ArrayList arrayList2 = SavedStateHandleImpl_androidKt.ACCEPTABLE_CLASSES;
            Object obj2 = savedStateHandle.liveDatas.get(str);
            MutableLiveData mutableLiveData = obj2 instanceof MutableLiveData ? (MutableLiveData) obj2 : null;
            if (mutableLiveData != null) {
                mutableLiveData.setValue(uuidRandomUUID);
            }
            savedStateHandle.impl.set(uuidRandomUUID, str);
        }
        this.id = uuidRandomUUID;
    }

    @Override // androidx.lifecycle.ViewModel
    public final void onCleared() {
        WeakReference weakReference = this.saveableStateHolderRef;
        if (weakReference == null) {
            Intrinsics.throwUninitializedPropertyAccessException("saveableStateHolderRef");
            throw null;
        }
        SaveableStateHolder saveableStateHolder = (SaveableStateHolder) weakReference.get();
        if (saveableStateHolder != null) {
            saveableStateHolder.removeState(this.id);
        }
        WeakReference weakReference2 = this.saveableStateHolderRef;
        if (weakReference2 != null) {
            weakReference2.clear();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("saveableStateHolderRef");
            throw null;
        }
    }
}
