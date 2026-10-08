package androidx.activity.compose;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import androidx.activity.ImmLeaksCleaner$$ExternalSyntheticLambda0;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.compose.runtime.DynamicProvidableCompositionLocal;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.viewtree.ViewTree;
import com.koala.clash.R;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class LocalOnBackPressedDispatcherOwner {
    public static final DynamicProvidableCompositionLocal LocalOnBackPressedDispatcherOwner = new DynamicProvidableCompositionLocal(new ImmLeaksCleaner$$ExternalSyntheticLambda0(4));

    public static OnBackPressedDispatcherOwner getCurrent(GapComposer gapComposer) {
        OnBackPressedDispatcherOwner onBackPressedDispatcherOwner = (OnBackPressedDispatcherOwner) gapComposer.consume(LocalOnBackPressedDispatcherOwner);
        Object obj = null;
        if (onBackPressedDispatcherOwner == null) {
            gapComposer.startReplaceGroup(1208426157);
            View view = (View) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalView);
            while (true) {
                if (view == null) {
                    onBackPressedDispatcherOwner = null;
                    break;
                }
                Object tag = view.getTag(R.id.view_tree_on_back_pressed_dispatcher_owner);
                OnBackPressedDispatcherOwner onBackPressedDispatcherOwner2 = tag instanceof OnBackPressedDispatcherOwner ? (OnBackPressedDispatcherOwner) tag : null;
                if (onBackPressedDispatcherOwner2 != null) {
                    onBackPressedDispatcherOwner = onBackPressedDispatcherOwner2;
                    break;
                }
                Object parentOrViewTreeDisjointParent = ViewTree.getParentOrViewTreeDisjointParent(view);
                view = parentOrViewTreeDisjointParent instanceof View ? (View) parentOrViewTreeDisjointParent : null;
            }
            gapComposer.end(false);
        } else {
            gapComposer.startReplaceGroup(1208423708);
            gapComposer.end(false);
        }
        if (onBackPressedDispatcherOwner != null) {
            gapComposer.startReplaceGroup(1208423789);
            gapComposer.end(false);
            return onBackPressedDispatcherOwner;
        }
        gapComposer.startReplaceGroup(1208428160);
        for (Context baseContext = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext); baseContext instanceof ContextWrapper; baseContext = ((ContextWrapper) baseContext).getBaseContext()) {
            if (baseContext instanceof OnBackPressedDispatcherOwner) {
                obj = baseContext;
                break;
            }
        }
        OnBackPressedDispatcherOwner onBackPressedDispatcherOwner3 = (OnBackPressedDispatcherOwner) obj;
        gapComposer.end(false);
        return onBackPressedDispatcherOwner3;
    }
}
