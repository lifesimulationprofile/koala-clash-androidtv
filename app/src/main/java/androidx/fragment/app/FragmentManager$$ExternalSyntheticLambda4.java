package androidx.fragment.app;

import android.os.Bundle;
import androidx.compose.runtime.saveable.SaveableStateRegistryImpl;
import androidx.core.os.BundleKt;
import androidx.savedstate.SavedStateRegistry$SavedStateProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FragmentManager$$ExternalSyntheticLambda4 implements SavedStateRegistry$SavedStateProvider {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ FragmentManager$$ExternalSyntheticLambda4(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // androidx.savedstate.SavedStateRegistry$SavedStateProvider
    public final Bundle saveState() {
        Pair[] pairArr;
        switch (this.$r8$classId) {
            case 0:
                return ((FragmentManagerImpl) this.f$0).saveAllStateInternal();
            case 1:
                Map mapPerformSave = ((SaveableStateRegistryImpl) this.f$0).performSave();
                Bundle bundle = new Bundle();
                for (Map.Entry entry : mapPerformSave.entrySet()) {
                    String str = (String) entry.getKey();
                    List list = (List) entry.getValue();
                    bundle.putParcelableArrayList(str, list instanceof ArrayList ? (ArrayList) list : new ArrayList<>(list));
                }
                return bundle;
            default:
                Request request = (Request) this.f$0;
                for (Map.Entry entry2 : MapsKt__MapsKt.toMap((LinkedHashMap) request.tags).entrySet()) {
                    request.set(((StateFlowImpl) ((MutableStateFlow) entry2.getValue())).getValue(), (String) entry2.getKey());
                }
                for (Map.Entry entry3 : MapsKt__MapsKt.toMap((LinkedHashMap) request.method).entrySet()) {
                    request.set(((SavedStateRegistry$SavedStateProvider) entry3.getValue()).saveState(), (String) entry3.getKey());
                }
                LinkedHashMap linkedHashMap = (LinkedHashMap) request.url;
                if (linkedHashMap.isEmpty()) {
                    pairArr = new Pair[0];
                } else {
                    ArrayList arrayList = new ArrayList(linkedHashMap.size());
                    for (Map.Entry entry4 : linkedHashMap.entrySet()) {
                        arrayList.add(new Pair((String) entry4.getKey(), entry4.getValue()));
                    }
                    pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
                }
                return BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        }
    }
}
