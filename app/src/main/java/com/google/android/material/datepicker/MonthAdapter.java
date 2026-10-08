package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.icu.text.DateFormat;
import android.icu.util.TimeZone;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.compose.ui.node.RulerTrackingMap;
import androidx.core.view.ViewCompat;
import coil.ImageLoader$Builder;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.koala.clash.R;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MonthAdapter extends BaseAdapter {
    public static final int MAXIMUM_WEEKS = UtcDates.getUtcCalendarOf(null).getMaximum(4);
    public final CalendarConstraints calendarConstraints;
    public ImageLoader$Builder calendarStyle;
    public final Month month;

    public MonthAdapter(Month month, CalendarConstraints calendarConstraints) {
        this.month = month;
        this.calendarConstraints = calendarConstraints;
        throw null;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        Month month = this.month;
        return month.daysFromStartOfWeekToFirstOfMonth() + month.daysInMonth;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i / this.month.daysInWeek;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        String str;
        String str2;
        Context context = viewGroup.getContext();
        if (this.calendarStyle == null) {
            this.calendarStyle = new ImageLoader$Builder(context, 20);
        }
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_day, viewGroup, false);
        }
        Month month = this.month;
        int iDaysFromStartOfWeekToFirstOfMonth = i - month.daysFromStartOfWeekToFirstOfMonth();
        if (iDaysFromStartOfWeekToFirstOfMonth < 0 || iDaysFromStartOfWeekToFirstOfMonth >= month.daysInMonth) {
            textView.setVisibility(8);
            textView.setEnabled(false);
        } else {
            int i2 = iDaysFromStartOfWeekToFirstOfMonth + 1;
            textView.setTag(month);
            textView.setText(String.format(textView.getResources().getConfiguration().locale, "%d", Integer.valueOf(i2)));
            Calendar dayCopy = UtcDates.getDayCopy(month.firstOfMonth);
            dayCopy.set(5, i2);
            long timeInMillis = dayCopy.getTimeInMillis();
            int i3 = month.year;
            Calendar todayCalendar = UtcDates.getTodayCalendar();
            todayCalendar.set(5, 1);
            Calendar dayCopy2 = UtcDates.getDayCopy(todayCalendar);
            dayCopy2.get(2);
            int i4 = dayCopy2.get(1);
            dayCopy2.getMaximum(7);
            dayCopy2.getActualMaximum(5);
            dayCopy2.getTimeInMillis();
            if (i3 == i4) {
                Locale locale = Locale.getDefault();
                if (Build.VERSION.SDK_INT >= 24) {
                    DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton("MMMEd", locale);
                    instanceForSkeleton.setTimeZone(TimeZone.getTimeZone("UTC"));
                    str2 = instanceForSkeleton.format(new Date(timeInMillis));
                } else {
                    java.text.DateFormat dateInstance = java.text.DateFormat.getDateInstance(0, locale);
                    dateInstance.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
                    str2 = dateInstance.format(new Date(timeInMillis));
                }
                textView.setContentDescription(str2);
            } else {
                Locale locale2 = Locale.getDefault();
                if (Build.VERSION.SDK_INT >= 24) {
                    DateFormat instanceForSkeleton2 = DateFormat.getInstanceForSkeleton("yMMMEd", locale2);
                    instanceForSkeleton2.setTimeZone(TimeZone.getTimeZone("UTC"));
                    str = instanceForSkeleton2.format(new Date(timeInMillis));
                } else {
                    java.text.DateFormat dateInstance2 = java.text.DateFormat.getDateInstance(0, locale2);
                    dateInstance2.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
                    str = dateInstance2.format(new Date(timeInMillis));
                }
                textView.setContentDescription(str);
            }
            textView.setVisibility(0);
            textView.setEnabled(true);
        }
        Long item = getItem(i);
        if (item == null) {
            return textView;
        }
        long jLongValue = item.longValue();
        if (textView != null) {
            if (jLongValue >= this.calendarConstraints.validator.point) {
                textView.setEnabled(true);
                throw null;
            }
            textView.setEnabled(false);
            RulerTrackingMap rulerTrackingMap = (RulerTrackingMap) this.calendarStyle.options;
            rulerTrackingMap.getClass();
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable();
            ShapeAppearanceModel shapeAppearanceModel = (ShapeAppearanceModel) rulerTrackingMap.newRulers;
            materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
            materialShapeDrawable2.setShapeAppearanceModel(shapeAppearanceModel);
            materialShapeDrawable.setFillColor((ColorStateList) rulerTrackingMap.accessFlags);
            float f = rulerTrackingMap.size;
            ColorStateList colorStateList = (ColorStateList) rulerTrackingMap.layoutNodes;
            materialShapeDrawable.drawableState.strokeWidth = f;
            materialShapeDrawable.invalidateSelf();
            MaterialShapeDrawable.MaterialShapeDrawableState materialShapeDrawableState = materialShapeDrawable.drawableState;
            if (materialShapeDrawableState.strokeColor != colorStateList) {
                materialShapeDrawableState.strokeColor = colorStateList;
                materialShapeDrawable.onStateChange(materialShapeDrawable.getState());
            }
            ColorStateList colorStateList2 = (ColorStateList) rulerTrackingMap.values;
            textView.setTextColor(colorStateList2);
            RippleDrawable rippleDrawable = new RippleDrawable(colorStateList2.withAlpha(30), materialShapeDrawable, materialShapeDrawable2);
            Rect rect = (Rect) rulerTrackingMap.rulers;
            InsetDrawable insetDrawable = new InsetDrawable((Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom);
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            textView.setBackground(insetDrawable);
        }
        return textView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return true;
    }

    public final int lastPositionInMonth() {
        Month month = this.month;
        return (month.daysFromStartOfWeekToFirstOfMonth() + month.daysInMonth) - 1;
    }

    @Override // android.widget.Adapter
    public final Long getItem(int i) {
        Month month = this.month;
        if (i < month.daysFromStartOfWeekToFirstOfMonth() || i > lastPositionInMonth()) {
            return null;
        }
        int iDaysFromStartOfWeekToFirstOfMonth = (i - month.daysFromStartOfWeekToFirstOfMonth()) + 1;
        Calendar dayCopy = UtcDates.getDayCopy(month.firstOfMonth);
        dayCopy.set(5, iDaysFromStartOfWeekToFirstOfMonth);
        return Long.valueOf(dayCopy.getTimeInMillis());
    }
}
