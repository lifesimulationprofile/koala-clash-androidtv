package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.core.view.ViewCompat;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LinearProgressIndicator extends BaseProgressIndicator {
    public LinearProgressIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Context context2 = getContext();
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = this.spec;
        LinearDrawingDelegate linearDrawingDelegate = new LinearDrawingDelegate(linearProgressIndicatorSpec);
        IndeterminateAnimatorDelegate linearIndeterminateContiguousAnimatorDelegate = linearProgressIndicatorSpec.indeterminateAnimationType == 0 ? new LinearIndeterminateContiguousAnimatorDelegate(linearProgressIndicatorSpec) : new LinearIndeterminateDisjointAnimatorDelegate(context2, linearProgressIndicatorSpec);
        IndeterminateDrawable indeterminateDrawable = new IndeterminateDrawable(context2, linearProgressIndicatorSpec);
        indeterminateDrawable.drawingDelegate = linearDrawingDelegate;
        linearDrawingDelegate.drawable = indeterminateDrawable;
        indeterminateDrawable.animatorDelegate = linearIndeterminateContiguousAnimatorDelegate;
        linearIndeterminateContiguousAnimatorDelegate.drawable = indeterminateDrawable;
        setIndeterminateDrawable(indeterminateDrawable);
        setProgressDrawable(new DeterminateDrawable(getContext(), linearProgressIndicatorSpec, new LinearDrawingDelegate(linearProgressIndicatorSpec)));
    }

    public int getIndeterminateAnimationType() {
        return this.spec.indeterminateAnimationType;
    }

    public int getIndicatorDirection() {
        return this.spec.indicatorDirection;
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = this.spec;
        boolean z2 = true;
        if (linearProgressIndicatorSpec.indicatorDirection != 1) {
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            if ((getLayoutDirection() != 1 || linearProgressIndicatorSpec.indicatorDirection != 2) && (getLayoutDirection() != 0 || linearProgressIndicatorSpec.indicatorDirection != 3)) {
                z2 = false;
            }
        }
        linearProgressIndicatorSpec.drawHorizontallyInverse = z2;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        int paddingRight = i - (getPaddingRight() + getPaddingLeft());
        int paddingBottom = i2 - (getPaddingBottom() + getPaddingTop());
        IndeterminateDrawable indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null) {
            indeterminateDrawable.setBounds(0, 0, paddingRight, paddingBottom);
        }
        DeterminateDrawable progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setBounds(0, 0, paddingRight, paddingBottom);
        }
    }

    public void setIndeterminateAnimationType(int i) {
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = this.spec;
        if (linearProgressIndicatorSpec.indeterminateAnimationType == i) {
            return;
        }
        if (visibleToUser() && isIndeterminate()) {
            throw new IllegalStateException("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
        }
        linearProgressIndicatorSpec.indeterminateAnimationType = i;
        linearProgressIndicatorSpec.validateSpec();
        if (i == 0) {
            IndeterminateDrawable indeterminateDrawable = getIndeterminateDrawable();
            LinearIndeterminateContiguousAnimatorDelegate linearIndeterminateContiguousAnimatorDelegate = new LinearIndeterminateContiguousAnimatorDelegate(linearProgressIndicatorSpec);
            indeterminateDrawable.animatorDelegate = linearIndeterminateContiguousAnimatorDelegate;
            linearIndeterminateContiguousAnimatorDelegate.drawable = indeterminateDrawable;
        } else {
            IndeterminateDrawable indeterminateDrawable2 = getIndeterminateDrawable();
            LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate = new LinearIndeterminateDisjointAnimatorDelegate(getContext(), linearProgressIndicatorSpec);
            indeterminateDrawable2.animatorDelegate = linearIndeterminateDisjointAnimatorDelegate;
            linearIndeterminateDisjointAnimatorDelegate.drawable = indeterminateDrawable2;
        }
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setIndicatorColor(int... iArr) {
        super.setIndicatorColor(iArr);
        this.spec.validateSpec();
    }

    public void setIndicatorDirection(int i) {
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = this.spec;
        linearProgressIndicatorSpec.indicatorDirection = i;
        boolean z = true;
        if (i != 1) {
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            if ((getLayoutDirection() != 1 || linearProgressIndicatorSpec.indicatorDirection != 2) && (getLayoutDirection() != 0 || i != 3)) {
                z = false;
            }
        }
        linearProgressIndicatorSpec.drawHorizontallyInverse = z;
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public final void setProgressCompat(int i) {
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = this.spec;
        if (linearProgressIndicatorSpec != null && linearProgressIndicatorSpec.indeterminateAnimationType == 0 && isIndeterminate()) {
            return;
        }
        super.setProgressCompat(i);
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackCornerRadius(int i) {
        super.setTrackCornerRadius(i);
        this.spec.validateSpec();
        invalidate();
    }
}
