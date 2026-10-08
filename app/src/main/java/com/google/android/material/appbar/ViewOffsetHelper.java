package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOffsetHelper implements OnApplyWindowInsetsListener {
    public int layoutLeft;
    public int layoutTop;
    public final View view;

    public ViewOffsetHelper(View view) {
        this.view = view;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        int i = windowInsetsCompat.mImpl.getInsets(519).top;
        int i2 = this.layoutTop;
        View view2 = this.view;
        if (i2 >= 0) {
            view2.getLayoutParams().height = i2 + i;
            view2.setLayoutParams(view2.getLayoutParams());
        }
        view2.setPadding(view2.getPaddingLeft(), this.layoutLeft + i, view2.getPaddingRight(), view2.getPaddingBottom());
        return windowInsetsCompat;
    }

    public ViewOffsetHelper(View view, int i, int i2) {
        this.layoutTop = i;
        this.view = view;
        this.layoutLeft = i2;
    }
}
