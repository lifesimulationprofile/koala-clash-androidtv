package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import com.google.android.material.progressindicator.DeterminateDrawable;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SpringAnimation {
    public final ArrayList mEndListeners;
    public boolean mEndRequested;
    public long mLastFrameTime;
    public final float mMinVisibleChange;
    public float mPendingPosition;
    public final DeterminateDrawable.AnonymousClass1 mProperty;
    public boolean mRunning;
    public SpringForce mSpring;
    public boolean mStartValueIsSet;
    public final DeterminateDrawable mTarget;
    public final ArrayList mUpdateListeners;
    public float mValue;
    public float mVelocity;
    public static final DynamicAnimation$4 SCALE_X = new DynamicAnimation$4();
    public static final DynamicAnimation$4 SCALE_Y = new DynamicAnimation$4();
    public static final DynamicAnimation$4 ROTATION = new DynamicAnimation$4();
    public static final DynamicAnimation$4 ROTATION_X = new DynamicAnimation$4();
    public static final DynamicAnimation$4 ROTATION_Y = new DynamicAnimation$4();
    public static final DynamicAnimation$4 ALPHA = new DynamicAnimation$4();

    public SpringAnimation(DeterminateDrawable determinateDrawable) {
        DeterminateDrawable.AnonymousClass1 anonymousClass1 = DeterminateDrawable.INDICATOR_LENGTH_IN_LEVEL;
        this.mVelocity = 0.0f;
        this.mValue = Float.MAX_VALUE;
        this.mStartValueIsSet = false;
        this.mRunning = false;
        this.mLastFrameTime = 0L;
        this.mEndListeners = new ArrayList();
        this.mUpdateListeners = new ArrayList();
        this.mTarget = determinateDrawable;
        this.mProperty = anonymousClass1;
        if (anonymousClass1 == ROTATION || anonymousClass1 == ROTATION_X || anonymousClass1 == ROTATION_Y) {
            this.mMinVisibleChange = 0.1f;
        } else if (anonymousClass1 == ALPHA || anonymousClass1 == SCALE_X || anonymousClass1 == SCALE_Y) {
            this.mMinVisibleChange = 0.00390625f;
        } else {
            this.mMinVisibleChange = 1.0f;
        }
        this.mSpring = null;
        this.mPendingPosition = Float.MAX_VALUE;
        this.mEndRequested = false;
    }

    public final void setPropertyValue(float f) {
        this.mProperty.getClass();
        DeterminateDrawable determinateDrawable = this.mTarget;
        determinateDrawable.indicatorFraction = f / 10000.0f;
        determinateDrawable.invalidateSelf();
        int i = 0;
        while (true) {
            ArrayList arrayList = this.mUpdateListeners;
            if (i >= arrayList.size()) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (arrayList.get(size) == null) {
                        arrayList.remove(size);
                    }
                }
                return;
            }
            if (arrayList.get(i) != null) {
                arrayList.get(i).getClass();
                throw new ClassCastException();
            }
            i++;
        }
    }

    public final void skipToEnd() {
        if (this.mSpring.mDampingRatio <= 0.0d) {
            throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        if (this.mRunning) {
            this.mEndRequested = true;
        }
    }
}
