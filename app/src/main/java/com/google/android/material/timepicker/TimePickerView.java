package com.google.android.material.timepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import com.koala.clash.R;
import java.util.HashMap;
import java.util.WeakHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class TimePickerView extends ConstraintLayout {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final MaterialButtonToggleGroup toggle;

    /* JADX INFO: renamed from: com.google.android.material.timepicker.TimePickerView$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass2 {
        public final void onButtonChecked() {
            int i = TimePickerView.$r8$clinit;
        }
    }

    public TimePickerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.google.android.material.timepicker.TimePickerView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i = TimePickerView.$r8$clinit;
                TimePickerView.this.getClass();
            }
        };
        LayoutInflater.from(context).inflate(R.layout.material_timepicker, this);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(R.id.material_clock_period_toggle);
        this.toggle = materialButtonToggleGroup;
        materialButtonToggleGroup.onButtonCheckedListeners.add(new AnonymousClass2());
        Chip chip = (Chip) findViewById(R.id.material_minute_tv);
        Chip chip2 = (Chip) findViewById(R.id.material_hour_tv);
        final GestureDetector gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.google.android.material.timepicker.TimePickerView.3
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public final boolean onDoubleTap(MotionEvent motionEvent) {
                int i = TimePickerView.$r8$clinit;
                TimePickerView.this.getClass();
                return false;
            }
        });
        View.OnTouchListener onTouchListener = new View.OnTouchListener() { // from class: com.google.android.material.timepicker.TimePickerView.4
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (((Checkable) view).isChecked()) {
                    return gestureDetector.onTouchEvent(motionEvent);
                }
                return false;
            }
        };
        chip.setOnTouchListener(onTouchListener);
        chip2.setOnTouchListener(onTouchListener);
        chip.setTag(R.id.selection_type, 12);
        chip2.setTag(R.id.selection_type, 10);
        chip.setOnClickListener(onClickListener);
        chip2.setOnClickListener(onClickListener);
        chip.setAccessibilityClassName("android.view.View");
        chip2.setAccessibilityClassName("android.view.View");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateToggleConstraints();
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (view == this && i == 0) {
            updateToggleConstraints();
        }
    }

    public final void updateToggleConstraints() {
        if (this.toggle.getVisibility() == 0) {
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(this);
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            char c = getLayoutDirection() == 0 ? (char) 2 : (char) 1;
            Integer numValueOf = Integer.valueOf(R.id.material_clock_display);
            HashMap map = constraintSet.mConstraints;
            if (map.containsKey(numValueOf)) {
                ConstraintSet.Constraint constraint = (ConstraintSet.Constraint) map.get(Integer.valueOf(R.id.material_clock_display));
                switch (c) {
                    case 1:
                        ConstraintSet.Layout layout = constraint.layout;
                        layout.leftToRight = -1;
                        layout.leftToLeft = -1;
                        layout.leftMargin = -1;
                        layout.goneLeftMargin = -1;
                        break;
                    case 2:
                        ConstraintSet.Layout layout2 = constraint.layout;
                        layout2.rightToRight = -1;
                        layout2.rightToLeft = -1;
                        layout2.rightMargin = -1;
                        layout2.goneRightMargin = -1;
                        break;
                    case 3:
                        ConstraintSet.Layout layout3 = constraint.layout;
                        layout3.topToBottom = -1;
                        layout3.topToTop = -1;
                        layout3.topMargin = -1;
                        layout3.goneTopMargin = -1;
                        break;
                    case 4:
                        ConstraintSet.Layout layout4 = constraint.layout;
                        layout4.bottomToTop = -1;
                        layout4.bottomToBottom = -1;
                        layout4.bottomMargin = -1;
                        layout4.goneBottomMargin = -1;
                        break;
                    case 5:
                        constraint.layout.baselineToBaseline = -1;
                        break;
                    case 6:
                        ConstraintSet.Layout layout5 = constraint.layout;
                        layout5.startToEnd = -1;
                        layout5.startToStart = -1;
                        layout5.startMargin = -1;
                        layout5.goneStartMargin = -1;
                        break;
                    case 7:
                        ConstraintSet.Layout layout6 = constraint.layout;
                        layout6.endToStart = -1;
                        layout6.endToEnd = -1;
                        layout6.endMargin = -1;
                        layout6.goneEndMargin = -1;
                        break;
                    default:
                        throw new IllegalArgumentException("unknown constraint");
                }
            }
            constraintSet.applyToInternal(this);
            setConstraintSet(null);
            requestLayout();
        }
    }
}
