package androidx.navigationevent.compose;

import android.view.View;
import androidx.compose.runtime.DynamicProvidableCompositionLocal;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.viewtree.ViewTree;
import androidx.navigationevent.NavigationEventDispatcherOwner;
import coil.ImageLoader$Builder$$ExternalSyntheticLambda2;
import com.koala.clash.R;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class LocalNavigationEventDispatcherOwner {
    public static final DynamicProvidableCompositionLocal LocalNavigationEventDispatcherOwner = new DynamicProvidableCompositionLocal(new ImageLoader$Builder$$ExternalSyntheticLambda2(16));

    public static NavigationEventDispatcherOwner getCurrent(GapComposer gapComposer) {
        NavigationEventDispatcherOwner navigationEventDispatcherOwner;
        NavigationEventDispatcherOwner navigationEventDispatcherOwner2 = (NavigationEventDispatcherOwner) gapComposer.consume(LocalNavigationEventDispatcherOwner);
        if (navigationEventDispatcherOwner2 != null) {
            gapComposer.startReplaceGroup(950834231);
            gapComposer.end(false);
            return navigationEventDispatcherOwner2;
        }
        gapComposer.startReplaceGroup(950836184);
        View view = (View) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalView);
        while (true) {
            navigationEventDispatcherOwner = null;
            if (view == null) {
                break;
            }
            Object tag = view.getTag(R.id.view_tree_navigation_event_dispatcher_owner);
            NavigationEventDispatcherOwner navigationEventDispatcherOwner3 = tag instanceof NavigationEventDispatcherOwner ? (NavigationEventDispatcherOwner) tag : null;
            if (navigationEventDispatcherOwner3 != null) {
                navigationEventDispatcherOwner = navigationEventDispatcherOwner3;
                break;
            }
            Object parentOrViewTreeDisjointParent = ViewTree.getParentOrViewTreeDisjointParent(view);
            view = parentOrViewTreeDisjointParent instanceof View ? (View) parentOrViewTreeDisjointParent : null;
        }
        gapComposer.end(false);
        return navigationEventDispatcherOwner;
    }
}
