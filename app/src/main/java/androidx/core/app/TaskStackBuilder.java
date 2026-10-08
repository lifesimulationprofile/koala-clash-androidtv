package androidx.core.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TaskStackBuilder implements Iterable {
    public final /* synthetic */ int $r8$classId;
    public final ArrayList mIntents;
    public final Object mSourceContext;

    public TaskStackBuilder(Context context) {
        this.$r8$classId = 0;
        this.mIntents = new ArrayList();
        this.mSourceContext = context;
    }

    public void addParentStack(ComponentName componentName) {
        Context context = (Context) this.mSourceContext;
        ArrayList arrayList = this.mIntents;
        int size = arrayList.size();
        try {
            for (Intent parentActivityIntent = NavUtils.getParentActivityIntent(context, componentName); parentActivityIntent != null; parentActivityIntent = NavUtils.getParentActivityIntent(context, parentActivityIntent.getComponent())) {
                arrayList.add(size, parentActivityIntent);
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        switch (this.$r8$classId) {
            case 0:
                return this.mIntents.iterator();
            default:
                return ((HashMap) this.mSourceContext).keySet().iterator();
        }
    }

    public void startActivities() {
        ArrayList arrayList = this.mIntents;
        if (arrayList.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[0]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        ((Context) this.mSourceContext).startActivities(intentArr, null);
    }

    public void unloadQueue() {
        Iterator it = this.mIntents.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
    }

    public TaskStackBuilder(HashMap map) {
        this.$r8$classId = 1;
        this.mSourceContext = new HashMap();
        this.mIntents = new ArrayList();
        String str = (String) map.get("cookie");
        if (str != null) {
            for (String str2 : str.split(";")) {
                String[] strArrSplit = str2.trim().split("=");
                if (strArrSplit.length == 2) {
                    ((HashMap) this.mSourceContext).put(strArrSplit[0], strArrSplit[1]);
                }
            }
        }
    }
}
