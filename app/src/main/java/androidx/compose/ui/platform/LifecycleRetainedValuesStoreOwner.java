package androidx.compose.ui.platform;

import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.CancellationHandle;
import androidx.compose.runtime.retain.ManagedRetainedValuesStore;
import androidx.lifecycle.ViewModel;
import coil.request.Parameters;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LifecycleRetainedValuesStoreOwner extends ViewModel {
    public final MutableIntObjectMap scopes;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public interface FrameEndScheduler {
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class RetainedValuesStoreEntry {
        public final Parameters.Builder _retainedValuesStore;
        public CancellationHandle endRetainCancellationHandle;
        public boolean isInUse;
        public final Parameters.Builder retainedValuesStore;

        public RetainedValuesStoreEntry() {
            Parameters.Builder builder = new Parameters.Builder(8);
            this._retainedValuesStore = builder;
            this.retainedValuesStore = builder;
        }
    }

    public LifecycleRetainedValuesStoreOwner() {
        MutableIntObjectMap mutableIntObjectMap = IntObjectMapKt.EmptyIntObjectMap;
        this.scopes = new MutableIntObjectMap();
    }

    @Override // androidx.lifecycle.ViewModel
    public final void onCleared() {
        MutableIntObjectMap mutableIntObjectMap = this.scopes;
        int[] iArr = mutableIntObjectMap.keys;
        Object[] objArr = mutableIntObjectMap.values;
        long[] jArr = mutableIntObjectMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8;
                int i3 = 8 - ((~(i - length)) >>> 31);
                int i4 = 0;
                while (i4 < i3) {
                    if ((255 & j) < 128) {
                        int i5 = (i << 3) + i4;
                        int i6 = iArr[i5];
                        MutableObjectList mutableObjectList = (MutableObjectList) objArr[i5];
                        Object[] objArr2 = mutableObjectList.content;
                        int i7 = mutableObjectList._size;
                        int i8 = 0;
                        while (i8 < i7) {
                            RetainedValuesStoreEntry retainedValuesStoreEntry = (RetainedValuesStoreEntry) objArr2[i8];
                            int i9 = i2;
                            CancellationHandle cancellationHandle = retainedValuesStoreEntry.endRetainCancellationHandle;
                            if (cancellationHandle != null) {
                                cancellationHandle.cancel();
                            }
                            retainedValuesStoreEntry.endRetainCancellationHandle = null;
                            ManagedRetainedValuesStore managedRetainedValuesStore = (ManagedRetainedValuesStore) retainedValuesStoreEntry._retainedValuesStore.entries;
                            managedRetainedValuesStore.isDisposed = true;
                            managedRetainedValuesStore.isEnabled = false;
                            managedRetainedValuesStore.purgeUnusedExitedValues();
                            i8++;
                            i2 = i9;
                        }
                    }
                    int i10 = i2;
                    j >>= i10;
                    i4++;
                    i2 = i10;
                }
                if (i3 != i2) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }
}
