package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
@Navigator.Name("activity")
public class ActivityNavigator extends Navigator {
    public final Context context;
    public final Activity hostActivity;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Destination extends NavDestination {
        @Override // androidx.navigation.NavDestination
        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof Destination) || !super.equals(obj)) {
                return false;
            }
            return true;
        }

        @Override // androidx.navigation.NavDestination
        public final int hashCode() {
            return super.hashCode() * 961;
        }
    }

    public ActivityNavigator(Context context) {
        this.context = context;
        for (Object obj : SequencesKt.generateSequence(context, NavController$activity$1.INSTANCE$1)) {
            if (((Context) obj) instanceof Activity) {
                this.hostActivity = (Activity) obj;
            }
        }
        obj = null;
        this.hostActivity = (Activity) obj;
    }

    @Override // androidx.navigation.Navigator
    public final NavDestination createDestination() {
        return new Destination(this);
    }

    @Override // androidx.navigation.Navigator
    public final NavDestination navigate(NavDestination navDestination) {
        throw new IllegalStateException(ImageAnalysis$$ExternalSyntheticLambda1.m(new StringBuilder("Destination "), ((Destination) navDestination).id, " does not have an Intent set.").toString());
    }

    @Override // androidx.navigation.Navigator
    public final boolean popBackStack() {
        Activity activity = this.hostActivity;
        if (activity == null) {
            return false;
        }
        activity.finish();
        return true;
    }
}
