package androidx.appcompat.widget;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ToolbarWidgetWrapper implements DecorToolbar {
    public ActionMenuPresenter mActionMenuPresenter;
    public View mCustomView;
    public int mDefaultNavigationContentDescription;
    public Drawable mDefaultNavigationIcon;
    public int mDisplayOpts;
    public CharSequence mHomeDescription;
    public Drawable mIcon;
    public Drawable mLogo;
    public boolean mMenuPrepared;
    public Drawable mNavIcon;
    public CharSequence mSubtitle;
    public CharSequence mTitle;
    public boolean mTitleSet;
    public Toolbar mToolbar;
    public Window.Callback mWindowCallback;

    public final void setDisplayOptions(int i) {
        View view;
        Toolbar toolbar = this.mToolbar;
        int i2 = this.mDisplayOpts ^ i;
        this.mDisplayOpts = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    updateHomeAccessibility();
                }
                if ((this.mDisplayOpts & 4) != 0) {
                    Drawable drawable = this.mNavIcon;
                    if (drawable == null) {
                        drawable = this.mDefaultNavigationIcon;
                    }
                    toolbar.setNavigationIcon(drawable);
                } else {
                    toolbar.setNavigationIcon((Drawable) null);
                }
            }
            if ((i2 & 3) != 0) {
                updateToolbarLogo();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    toolbar.setTitle(this.mTitle);
                    toolbar.setSubtitle(this.mSubtitle);
                } else {
                    toolbar.setTitle((CharSequence) null);
                    toolbar.setSubtitle((CharSequence) null);
                }
            }
            if ((i2 & 16) == 0 || (view = this.mCustomView) == null) {
                return;
            }
            if ((i & 16) != 0) {
                toolbar.addView(view);
            } else {
                toolbar.removeView(view);
            }
        }
    }

    public final void updateHomeAccessibility() {
        Toolbar toolbar = this.mToolbar;
        if ((this.mDisplayOpts & 4) != 0) {
            if (TextUtils.isEmpty(this.mHomeDescription)) {
                toolbar.setNavigationContentDescription(this.mDefaultNavigationContentDescription);
            } else {
                toolbar.setNavigationContentDescription(this.mHomeDescription);
            }
        }
    }

    public final void updateToolbarLogo() {
        Drawable drawable;
        int i = this.mDisplayOpts;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) == 0 || (drawable = this.mLogo) == null) {
            drawable = this.mIcon;
        }
        this.mToolbar.setLogo(drawable);
    }

    /* JADX INFO: renamed from: androidx.appcompat.widget.ToolbarWidgetWrapper$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass2 extends ViewPropertyAnimatorListenerAdapter {
        public final /* synthetic */ int $r8$classId;
        public boolean mCanceled;
        public final /* synthetic */ Object this$0;
        public int val$visibility;

        public AnonymousClass2(ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet) {
            this.$r8$classId = 1;
            this.this$0 = viewPropertyAnimatorCompatSet;
            this.mCanceled = false;
            this.val$visibility = 0;
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationCancel() {
            switch (this.$r8$classId) {
                case 0:
                    this.mCanceled = true;
                    break;
            }
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListener
        public final void onAnimationEnd() {
            switch (this.$r8$classId) {
                case 0:
                    if (!this.mCanceled) {
                        ((ToolbarWidgetWrapper) this.this$0).mToolbar.setVisibility(this.val$visibility);
                    }
                    break;
                default:
                    int i = this.val$visibility + 1;
                    this.val$visibility = i;
                    ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = (ViewPropertyAnimatorCompatSet) this.this$0;
                    if (i == viewPropertyAnimatorCompatSet.mAnimators.size()) {
                        ViewPropertyAnimatorListener viewPropertyAnimatorListener = viewPropertyAnimatorCompatSet.mListener;
                        if (viewPropertyAnimatorListener != null) {
                            viewPropertyAnimatorListener.onAnimationEnd();
                        }
                        this.val$visibility = 0;
                        this.mCanceled = false;
                        viewPropertyAnimatorCompatSet.mIsStarted = false;
                    }
                    break;
            }
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public final void onAnimationStart() {
            switch (this.$r8$classId) {
                case 0:
                    ((ToolbarWidgetWrapper) this.this$0).mToolbar.setVisibility(0);
                    break;
                default:
                    if (!this.mCanceled) {
                        this.mCanceled = true;
                        ViewPropertyAnimatorListener viewPropertyAnimatorListener = ((ViewPropertyAnimatorCompatSet) this.this$0).mListener;
                        if (viewPropertyAnimatorListener != null) {
                            viewPropertyAnimatorListener.onAnimationStart();
                        }
                        break;
                    }
                    break;
            }
        }

        public AnonymousClass2(ToolbarWidgetWrapper toolbarWidgetWrapper, int i) {
            this.$r8$classId = 0;
            this.this$0 = toolbarWidgetWrapper;
            this.val$visibility = i;
            this.mCanceled = false;
        }
    }
}
