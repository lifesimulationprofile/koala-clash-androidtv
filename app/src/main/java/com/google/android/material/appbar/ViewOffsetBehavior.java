package com.google.android.material.appbar;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ViewOffsetBehavior extends CoordinatorLayout.Behavior {
    public ViewOffsetHelper viewOffsetHelper;

    public void layoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        coordinatorLayout.onLayoutChild(view, i);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        layoutChild(coordinatorLayout, view, i);
        if (this.viewOffsetHelper == null) {
            this.viewOffsetHelper = new ViewOffsetHelper(view);
        }
        ViewOffsetHelper viewOffsetHelper = this.viewOffsetHelper;
        View view2 = viewOffsetHelper.view;
        viewOffsetHelper.layoutTop = view2.getTop();
        viewOffsetHelper.layoutLeft = view2.getLeft();
        ViewOffsetHelper viewOffsetHelper2 = this.viewOffsetHelper;
        View view3 = viewOffsetHelper2.view;
        int top = 0 - (view3.getTop() - viewOffsetHelper2.layoutTop);
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        view3.offsetTopAndBottom(top);
        view3.offsetLeftAndRight(0 - (view3.getLeft() - viewOffsetHelper2.layoutLeft));
        return true;
    }
}
