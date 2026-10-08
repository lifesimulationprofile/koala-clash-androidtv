package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class Barrier extends ConstraintHelper {
    public androidx.constraintlayout.solver.widgets.Barrier mBarrier;
    public int mIndicatedType;
    public int mResolvedType;

    public Barrier(Context context) {
        super(context);
        this.mIds = new int[32];
        this.mMap = new HashMap();
        this.myContext = context;
        init(null);
        super.setVisibility(8);
    }

    public int getMargin() {
        return this.mBarrier.mMargin;
    }

    public int getType() {
        return this.mIndicatedType;
    }

    public final void init(AttributeSet attributeSet) {
        int[] iArr = R$styleable.ConstraintLayout_Layout;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, iArr);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == 19) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.mReferenceIds = string;
                    setIds(string);
                }
            }
        }
        androidx.constraintlayout.solver.widgets.Barrier barrier = new androidx.constraintlayout.solver.widgets.Barrier();
        barrier.mWidgets = new ConstraintWidget[4];
        barrier.mWidgetsCount = 0;
        barrier.mBarrierType = 0;
        barrier.mAllowsGoneWidget = true;
        barrier.mMargin = 0;
        this.mBarrier = barrier;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(attributeSet, iArr);
            int indexCount2 = typedArrayObtainStyledAttributes2.getIndexCount();
            for (int i2 = 0; i2 < indexCount2; i2++) {
                int index2 = typedArrayObtainStyledAttributes2.getIndex(i2);
                if (index2 == 15) {
                    setType(typedArrayObtainStyledAttributes2.getInt(index2, 0));
                } else if (index2 == 14) {
                    this.mBarrier.mAllowsGoneWidget = typedArrayObtainStyledAttributes2.getBoolean(index2, true);
                } else if (index2 == 16) {
                    this.mBarrier.mMargin = typedArrayObtainStyledAttributes2.getDimensionPixelSize(index2, 0);
                }
            }
        }
        this.mHelperWidget = this.mBarrier;
        validateParams();
    }

    public void setAllowsGoneWidget(boolean z) {
        this.mBarrier.mAllowsGoneWidget = z;
    }

    public void setDpMargin(int i) {
        this.mBarrier.mMargin = (int) ((i * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setMargin(int i) {
        this.mBarrier.mMargin = i;
    }

    public void setType(int i) {
        this.mIndicatedType = i;
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIds = new int[32];
        this.mMap = new HashMap();
        this.myContext = context;
        init(attributeSet);
        super.setVisibility(8);
    }
}
