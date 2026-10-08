package androidx.transition;

import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.appcompat.widget.SwitchCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange;
import com.google.android.material.progressindicator.LinearIndeterminateContiguousAnimatorDelegate;
import com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ViewUtils {
    public static final ViewUtilsApi23 IMPL;
    public static final AnonymousClass1 TRANSITION_ALPHA;

    /* JADX INFO: renamed from: androidx.transition.ViewUtils$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends Property {
        public final /* synthetic */ int $r8$classId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(Class cls, String str, int i) {
            super(cls, str);
            this.$r8$classId = i;
        }

        @Override // android.util.Property
        public final Object get(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    return Float.valueOf(ViewUtils.IMPL.getTransitionAlpha((View) obj));
                case 1:
                    return Float.valueOf(((SwitchCompat) obj).mThumbPosition);
                case 2:
                    return null;
                case 3:
                    return null;
                case 4:
                    return null;
                case 5:
                    return null;
                case 6:
                    return null;
                case 7:
                    return ((View) obj).getClipBounds();
                case 8:
                    return Float.valueOf(((DrawableWithAnimatedVisibilityChange) obj).getGrowFraction());
                case 9:
                    return Float.valueOf(((LinearIndeterminateContiguousAnimatorDelegate) obj).animationFraction);
                default:
                    return Float.valueOf(((LinearIndeterminateDisjointAnimatorDelegate) obj).animationFraction);
            }
        }

        @Override // android.util.Property
        public final void set(Object obj, Object obj2) {
            switch (this.$r8$classId) {
                case 0:
                    ViewUtils.IMPL.setTransitionAlpha((View) obj, ((Float) obj2).floatValue());
                    break;
                case 1:
                    ((SwitchCompat) obj).setThumbPosition(((Float) obj2).floatValue());
                    break;
                case 2:
                    ChangeBounds.ViewBounds viewBounds = (ChangeBounds.ViewBounds) obj;
                    PointF pointF = (PointF) obj2;
                    viewBounds.getClass();
                    viewBounds.mLeft = Math.round(pointF.x);
                    int iRound = Math.round(pointF.y);
                    viewBounds.mTop = iRound;
                    int i = viewBounds.mTopLeftCalls + 1;
                    viewBounds.mTopLeftCalls = i;
                    if (i == viewBounds.mBottomRightCalls) {
                        ViewUtils.setLeftTopRightBottom(viewBounds.mView, viewBounds.mLeft, iRound, viewBounds.mRight, viewBounds.mBottom);
                        viewBounds.mTopLeftCalls = 0;
                        viewBounds.mBottomRightCalls = 0;
                    }
                    break;
                case 3:
                    ChangeBounds.ViewBounds viewBounds2 = (ChangeBounds.ViewBounds) obj;
                    PointF pointF2 = (PointF) obj2;
                    viewBounds2.getClass();
                    viewBounds2.mRight = Math.round(pointF2.x);
                    int iRound2 = Math.round(pointF2.y);
                    viewBounds2.mBottom = iRound2;
                    int i2 = viewBounds2.mBottomRightCalls + 1;
                    viewBounds2.mBottomRightCalls = i2;
                    if (viewBounds2.mTopLeftCalls == i2) {
                        ViewUtils.setLeftTopRightBottom(viewBounds2.mView, viewBounds2.mLeft, viewBounds2.mTop, viewBounds2.mRight, iRound2);
                        viewBounds2.mTopLeftCalls = 0;
                        viewBounds2.mBottomRightCalls = 0;
                    }
                    break;
                case 4:
                    View view = (View) obj;
                    PointF pointF3 = (PointF) obj2;
                    ViewUtils.setLeftTopRightBottom(view, view.getLeft(), view.getTop(), Math.round(pointF3.x), Math.round(pointF3.y));
                    break;
                case 5:
                    View view2 = (View) obj;
                    PointF pointF4 = (PointF) obj2;
                    ViewUtils.setLeftTopRightBottom(view2, Math.round(pointF4.x), Math.round(pointF4.y), view2.getRight(), view2.getBottom());
                    break;
                case 6:
                    View view3 = (View) obj;
                    PointF pointF5 = (PointF) obj2;
                    int iRound3 = Math.round(pointF5.x);
                    int iRound4 = Math.round(pointF5.y);
                    ViewUtils.setLeftTopRightBottom(view3, iRound3, iRound4, view3.getWidth() + iRound3, view3.getHeight() + iRound4);
                    break;
                case 7:
                    ((View) obj).setClipBounds((Rect) obj2);
                    break;
                case 8:
                    DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange = (DrawableWithAnimatedVisibilityChange) obj;
                    float fFloatValue = ((Float) obj2).floatValue();
                    if (drawableWithAnimatedVisibilityChange.growFraction != fFloatValue) {
                        drawableWithAnimatedVisibilityChange.growFraction = fFloatValue;
                        drawableWithAnimatedVisibilityChange.invalidateSelf();
                    }
                    break;
                case 9:
                    LinearIndeterminateContiguousAnimatorDelegate linearIndeterminateContiguousAnimatorDelegate = (LinearIndeterminateContiguousAnimatorDelegate) obj;
                    float fFloatValue2 = ((Float) obj2).floatValue();
                    linearIndeterminateContiguousAnimatorDelegate.animationFraction = fFloatValue2;
                    float[] fArr = linearIndeterminateContiguousAnimatorDelegate.segmentPositions;
                    fArr[0] = 0.0f;
                    float f = ((int) (fFloatValue2 * 333.0f)) / 667;
                    FastOutSlowInInterpolator fastOutSlowInInterpolator = linearIndeterminateContiguousAnimatorDelegate.interpolator;
                    float interpolation = fastOutSlowInInterpolator.getInterpolation(f);
                    fArr[2] = interpolation;
                    fArr[1] = interpolation;
                    float interpolation2 = fastOutSlowInInterpolator.getInterpolation(f + 0.49925038f);
                    fArr[4] = interpolation2;
                    fArr[3] = interpolation2;
                    fArr[5] = 1.0f;
                    if (linearIndeterminateContiguousAnimatorDelegate.dirtyColors && interpolation2 < 1.0f) {
                        int[] iArr = linearIndeterminateContiguousAnimatorDelegate.segmentColors;
                        iArr[2] = iArr[1];
                        iArr[1] = iArr[0];
                        iArr[0] = MaterialColors.compositeARGBWithAlpha(linearIndeterminateContiguousAnimatorDelegate.baseSpec.indicatorColors[linearIndeterminateContiguousAnimatorDelegate.newIndicatorColorIndex], linearIndeterminateContiguousAnimatorDelegate.drawable.totalAlpha);
                        linearIndeterminateContiguousAnimatorDelegate.dirtyColors = false;
                    }
                    linearIndeterminateContiguousAnimatorDelegate.drawable.invalidateSelf();
                    break;
                default:
                    LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate = (LinearIndeterminateDisjointAnimatorDelegate) obj;
                    float fFloatValue3 = ((Float) obj2).floatValue();
                    linearIndeterminateDisjointAnimatorDelegate.animationFraction = fFloatValue3;
                    int i3 = (int) (fFloatValue3 * 1800.0f);
                    for (int i4 = 0; i4 < 4; i4++) {
                        linearIndeterminateDisjointAnimatorDelegate.segmentPositions[i4] = Math.max(0.0f, Math.min(1.0f, linearIndeterminateDisjointAnimatorDelegate.interpolatorArray[i4].getInterpolation((i3 - LinearIndeterminateDisjointAnimatorDelegate.DELAY_TO_MOVE_SEGMENT_ENDS[i4]) / LinearIndeterminateDisjointAnimatorDelegate.DURATION_TO_MOVE_SEGMENT_ENDS[i4])));
                    }
                    if (linearIndeterminateDisjointAnimatorDelegate.dirtyColors) {
                        Arrays.fill(linearIndeterminateDisjointAnimatorDelegate.segmentColors, MaterialColors.compositeARGBWithAlpha(linearIndeterminateDisjointAnimatorDelegate.baseSpec.indicatorColors[linearIndeterminateDisjointAnimatorDelegate.indicatorColorIndex], linearIndeterminateDisjointAnimatorDelegate.drawable.totalAlpha));
                        linearIndeterminateDisjointAnimatorDelegate.dirtyColors = false;
                    }
                    linearIndeterminateDisjointAnimatorDelegate.drawable.invalidateSelf();
                    break;
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            IMPL = new ViewUtilsApi29();
        } else {
            IMPL = new ViewUtilsApi23();
        }
        TRANSITION_ALPHA = new AnonymousClass1(Float.class, "translationAlpha", 0);
        new AnonymousClass1(Rect.class, "clipBounds", 7);
    }

    public static void setLeftTopRightBottom(View view, int i, int i2, int i3, int i4) {
        IMPL.setLeftTopRightBottom(view, i, i2, i3, i4);
    }

    public static void setTransitionVisibility(View view, int i) {
        IMPL.setTransitionVisibility(view, i);
    }
}
