package androidx.activity.result;

import androidx.activity.ComponentActivity$activityResultRegistry$1;
import androidx.core.content.pm.ShortcutManagerCompat;
import io.github.g00fy2.quickie.ScanQRCode;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ActivityResultRegistry$register$2 extends ShortcutManagerCompat {
    public final /* synthetic */ ScanQRCode $contract;
    public final /* synthetic */ String $key;
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ ComponentActivity$activityResultRegistry$1 this$0;

    public /* synthetic */ ActivityResultRegistry$register$2(ComponentActivity$activityResultRegistry$1 componentActivity$activityResultRegistry$1, String str, ScanQRCode scanQRCode, int i) {
        this.$r8$classId = i;
        this.this$0 = componentActivity$activityResultRegistry$1;
        this.$key = str;
        this.$contract = scanQRCode;
    }

    public final void launch(Object obj) throws Exception {
        switch (this.$r8$classId) {
            case 0:
                ComponentActivity$activityResultRegistry$1 componentActivity$activityResultRegistry$1 = this.this$0;
                LinkedHashMap linkedHashMap = componentActivity$activityResultRegistry$1.keyToRc;
                ArrayList arrayList = componentActivity$activityResultRegistry$1.launchedKeys;
                String str = this.$key;
                Object obj2 = linkedHashMap.get(str);
                ScanQRCode scanQRCode = this.$contract;
                if (obj2 == null) {
                    throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + scanQRCode + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
                }
                int iIntValue = ((Number) obj2).intValue();
                arrayList.add(str);
                try {
                    componentActivity$activityResultRegistry$1.onLaunch(iIntValue, scanQRCode, obj);
                    return;
                } catch (Exception e) {
                    arrayList.remove(str);
                    throw e;
                }
            default:
                ComponentActivity$activityResultRegistry$1 componentActivity$activityResultRegistry$2 = this.this$0;
                ArrayList arrayList2 = componentActivity$activityResultRegistry$2.launchedKeys;
                LinkedHashMap linkedHashMap2 = componentActivity$activityResultRegistry$2.keyToRc;
                String str2 = this.$key;
                Object obj3 = linkedHashMap2.get(str2);
                ScanQRCode scanQRCode2 = this.$contract;
                if (obj3 == null) {
                    throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + scanQRCode2 + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
                }
                int iIntValue2 = ((Number) obj3).intValue();
                arrayList2.add(str2);
                try {
                    componentActivity$activityResultRegistry$2.onLaunch(iIntValue2, scanQRCode2, obj);
                    return;
                } catch (Exception e2) {
                    arrayList2.remove(str2);
                    throw e2;
                }
        }
    }

    public void unregister() {
        this.this$0.unregister$activity(this.$key);
    }
}
