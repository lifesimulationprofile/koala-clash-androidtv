package androidx.activity;

import android.os.Bundle;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity$HostCallbacks;
import coil.request.RequestService;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ComponentActivity$$ExternalSyntheticLambda7 implements OnContextAvailableListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ AppCompatActivity f$0;

    public /* synthetic */ ComponentActivity$$ExternalSyntheticLambda7(AppCompatActivity appCompatActivity, int i) {
        this.$r8$classId = i;
        this.f$0 = appCompatActivity;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public final void onContextAvailable() {
        switch (this.$r8$classId) {
            case 0:
                AppCompatActivity appCompatActivity = this.f$0;
                Bundle bundleConsumeRestoredStateForKey = ((RequestService) appCompatActivity.savedStateRegistryController.hardwareBitmapService).consumeRestoredStateForKey("android:support:activity-result");
                if (bundleConsumeRestoredStateForKey != null) {
                    ComponentActivity$activityResultRegistry$1 componentActivity$activityResultRegistry$1 = appCompatActivity.activityResultRegistry;
                    LinkedHashMap linkedHashMap = componentActivity$activityResultRegistry$1.keyToRc;
                    LinkedHashMap linkedHashMap2 = componentActivity$activityResultRegistry$1.rcToKey;
                    Bundle bundle = componentActivity$activityResultRegistry$1.pendingResults;
                    ArrayList<Integer> integerArrayList = bundleConsumeRestoredStateForKey.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
                    ArrayList<String> stringArrayList = bundleConsumeRestoredStateForKey.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
                    if (stringArrayList != null && integerArrayList != null) {
                        ArrayList<String> stringArrayList2 = bundleConsumeRestoredStateForKey.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                        if (stringArrayList2 != null) {
                            componentActivity$activityResultRegistry$1.launchedKeys.addAll(stringArrayList2);
                        }
                        Bundle bundle2 = bundleConsumeRestoredStateForKey.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
                        if (bundle2 != null) {
                            bundle.putAll(bundle2);
                        }
                        int size = stringArrayList.size();
                        for (int i = 0; i < size; i++) {
                            String str = stringArrayList.get(i);
                            if (linkedHashMap.containsKey(str)) {
                                Integer num = (Integer) linkedHashMap.remove(str);
                                if (!bundle.containsKey(str)) {
                                    TypeIntrinsics.asMutableMap(linkedHashMap2).remove(num);
                                }
                            }
                            int iIntValue = integerArrayList.get(i).intValue();
                            String str2 = stringArrayList.get(i);
                            linkedHashMap2.put(Integer.valueOf(iIntValue), str2);
                            componentActivity$activityResultRegistry$1.keyToRc.put(str2, Integer.valueOf(iIntValue));
                        }
                        break;
                    }
                }
                break;
            default:
                FragmentActivity$HostCallbacks fragmentActivity$HostCallbacks = (FragmentActivity$HostCallbacks) this.f$0.mFragments.entries;
                fragmentActivity$HostCallbacks.mFragmentManager.attachController(fragmentActivity$HostCallbacks, fragmentActivity$HostCallbacks, null);
                break;
        }
    }
}
