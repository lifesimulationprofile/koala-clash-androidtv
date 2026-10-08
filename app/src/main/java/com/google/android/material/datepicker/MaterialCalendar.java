package com.google.android.material.datepicker;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ScrollView;
import android.widget.Scroller;
import androidx.appcompat.widget.Toolbar;
import androidx.compose.foundation.style.InteractionSet;
import androidx.core.provider.CallbackWrapper$2;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper$1;
import coil.ImageLoader$Builder;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.NavigationMenuItemView;
import com.koala.clash.R;
import java.util.ArrayList;
import java.util.Calendar;
import okhttp3.ConnectionPool;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MaterialCalendar<S> extends PickerFragment {
    public CalendarConstraints calendarConstraints;
    public int calendarSelector;
    public ImageLoader$Builder calendarStyle;
    public Month current;
    public View dayFrame;
    public RecyclerView recyclerView;
    public int themeResId;
    public View yearFrame;
    public RecyclerView yearSelector;

    /* JADX INFO: renamed from: com.google.android.material.datepicker.MaterialCalendar$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends AccessibilityDelegateCompat {
        public final /* synthetic */ int $r8$classId;

        public /* synthetic */ AnonymousClass1(int i) {
            this.$r8$classId = i;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            switch (this.$r8$classId) {
                case 1:
                    super.onInitializeAccessibilityEvent(view, accessibilityEvent);
                    NestedScrollView nestedScrollView = (NestedScrollView) view;
                    accessibilityEvent.setClassName(ScrollView.class.getName());
                    accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
                    accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
                    accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
                    accessibilityEvent.setMaxScrollX(nestedScrollView.getScrollX());
                    accessibilityEvent.setMaxScrollY(nestedScrollView.getScrollRange());
                    break;
                default:
                    super.onInitializeAccessibilityEvent(view, accessibilityEvent);
                    break;
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int scrollRange;
            switch (this.$r8$classId) {
                case 0:
                    this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.mInfo);
                    accessibilityNodeInfoCompat.setCollectionInfo(null);
                    break;
                case 1:
                    AccessibilityNodeInfo accessibilityNodeInfo = accessibilityNodeInfoCompat.mInfo;
                    this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                    NestedScrollView nestedScrollView = (NestedScrollView) view;
                    accessibilityNodeInfoCompat.setClassName(ScrollView.class.getName());
                    if (nestedScrollView.isEnabled() && (scrollRange = nestedScrollView.getScrollRange()) > 0) {
                        accessibilityNodeInfo.setScrollable(true);
                        if (nestedScrollView.getScrollY() > 0) {
                            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
                        }
                        if (nestedScrollView.getScrollY() < scrollRange) {
                            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
                        }
                        break;
                    }
                    break;
                default:
                    this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.mInfo);
                    accessibilityNodeInfoCompat.setCollectionInfo(null);
                    break;
            }
        }

        /* JADX WARN: Code duplicated, block: B:29:0x0075  */
        /* JADX WARN: Code duplicated, block: B:31:0x0092  */
        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            int iMin;
            switch (this.$r8$classId) {
                case 1:
                    if (super.performAccessibilityAction(view, i, bundle)) {
                        return true;
                    }
                    NestedScrollView nestedScrollView = (NestedScrollView) view;
                    if (nestedScrollView.isEnabled()) {
                        int height = nestedScrollView.getHeight();
                        Rect rect = new Rect();
                        if (nestedScrollView.getMatrix().isIdentity() && nestedScrollView.getGlobalVisibleRect(rect)) {
                            height = rect.height();
                        }
                        if (i == 4096) {
                            iMin = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
                            if (iMin != nestedScrollView.getScrollY()) {
                                nestedScrollView.smoothScrollBy(0 - nestedScrollView.getScrollX(), iMin - nestedScrollView.getScrollY(), true);
                                return true;
                            }
                        } else if (i == 8192 || i == 16908344) {
                            int iMax = Math.max(nestedScrollView.getScrollY() - ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                            if (iMax != nestedScrollView.getScrollY()) {
                                nestedScrollView.smoothScrollBy(0 - nestedScrollView.getScrollX(), iMax - nestedScrollView.getScrollY(), true);
                                return true;
                            }
                        } else if (i == 16908346) {
                            iMin = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
                            if (iMin != nestedScrollView.getScrollY()) {
                                nestedScrollView.smoothScrollBy(0 - nestedScrollView.getScrollX(), iMin - nestedScrollView.getScrollY(), true);
                                return true;
                            }
                        }
                    }
                    return false;
                default:
                    return super.performAccessibilityAction(view, i, bundle);
            }
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.datepicker.MaterialCalendar$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass4 extends RecyclerView.ItemDecoration {
        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public final void onDraw(RecyclerView recyclerView) {
            if ((recyclerView.getAdapter() instanceof YearGridAdapter) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                throw null;
            }
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.datepicker.MaterialCalendar$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass5 extends AccessibilityDelegateCompat {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Object this$0;

        public /* synthetic */ AnonymousClass5(int i, Object obj) {
            this.$r8$classId = i;
            this.this$0 = obj;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            switch (this.$r8$classId) {
                case 2:
                    super.onInitializeAccessibilityEvent(view, accessibilityEvent);
                    accessibilityEvent.setChecked(((CheckableImageButton) this.this$0).checked);
                    break;
                default:
                    super.onInitializeAccessibilityEvent(view, accessibilityEvent);
                    break;
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int i = this.$r8$classId;
            Object obj = this.this$0;
            View.AccessibilityDelegate accessibilityDelegate = this.mOriginalDelegate;
            switch (i) {
                case 0:
                    accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.mInfo);
                    MaterialCalendar materialCalendar = (MaterialCalendar) obj;
                    accessibilityNodeInfoCompat.setHintText(materialCalendar.dayFrame.getVisibility() == 0 ? materialCalendar.requireContext().getResources().getString(R.string.mtrl_picker_toggle_to_year_selection) : materialCalendar.requireContext().getResources().getString(R.string.mtrl_picker_toggle_to_day_selection));
                    break;
                case 1:
                    accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.mInfo);
                    MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) obj;
                    int i2 = MaterialButtonToggleGroup.$r8$clinit;
                    int i3 = -1;
                    if (view instanceof MaterialButton) {
                        int i4 = 0;
                        for (int i5 = 0; i5 < materialButtonToggleGroup.getChildCount(); i5++) {
                            if (materialButtonToggleGroup.getChildAt(i5) == view) {
                                i3 = i4;
                            } else {
                                if ((materialButtonToggleGroup.getChildAt(i5) instanceof MaterialButton) && materialButtonToggleGroup.isChildVisible(i5)) {
                                    i4++;
                                }
                            }
                        }
                    }
                    accessibilityNodeInfoCompat.setCollectionItemInfo(InteractionSet.obtain(((MaterialButton) view).checked, 0, 1, i3, 1));
                    break;
                case 2:
                    AccessibilityNodeInfo accessibilityNodeInfo = accessibilityNodeInfoCompat.mInfo;
                    accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                    CheckableImageButton checkableImageButton = (CheckableImageButton) obj;
                    accessibilityNodeInfo.setCheckable(checkableImageButton.checkable);
                    accessibilityNodeInfo.setChecked(checkableImageButton.checked);
                    break;
                default:
                    AccessibilityNodeInfo accessibilityNodeInfo2 = accessibilityNodeInfoCompat.mInfo;
                    accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo2);
                    accessibilityNodeInfo2.setCheckable(((NavigationMenuItemView) obj).checkable);
                    break;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = this.mArguments;
        }
        this.themeResId = bundle.getInt("THEME_RES_ID_KEY");
        if (bundle.getParcelable("GRID_SELECTOR_KEY") != null) {
            throw new ClassCastException();
        }
        this.calendarConstraints = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.current = (Month) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        int i;
        final int i2;
        PagerSnapHelper pagerSnapHelper;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.themeResId);
        this.calendarStyle = new ImageLoader$Builder(contextThemeWrapper, 20);
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        Month month = this.calendarConstraints.start;
        if (MaterialDatePicker.readMaterialCalendarStyleBoolean(contextThemeWrapper, android.R.attr.windowFullscreen)) {
            i = R.layout.mtrl_calendar_vertical;
            i2 = 1;
        } else {
            i = R.layout.mtrl_calendar_horizontal;
            i2 = 0;
        }
        View viewInflate = layoutInflaterCloneInContext.inflate(i, viewGroup, false);
        Resources resources = requireContext().getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_bottom_padding) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelSize(R.dimen.mtrl_calendar_navigation_height);
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_days_of_week_height);
        int i3 = MonthAdapter.MAXIMUM_WEEKS;
        viewInflate.setMinimumHeight(dimensionPixelOffset + dimensionPixelSize + (resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_vertical_padding) * (i3 - 1)) + (resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) * i3) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_bottom_padding));
        GridView gridView = (GridView) viewInflate.findViewById(R.id.mtrl_calendar_days_of_week);
        ViewCompat.setAccessibilityDelegate(gridView, new AnonymousClass1(0));
        gridView.setAdapter((ListAdapter) new DaysOfWeekAdapter());
        gridView.setNumColumns(month.daysInWeek);
        gridView.setEnabled(false);
        this.recyclerView = (RecyclerView) viewInflate.findViewById(R.id.mtrl_calendar_months);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(i2) { // from class: com.google.android.material.datepicker.MaterialCalendar.2
            @Override // androidx.recyclerview.widget.LinearLayoutManager
            public final void calculateExtraLayoutSpace(RecyclerView.State state, int[] iArr) {
                int i4 = i2;
                MaterialCalendar materialCalendar = MaterialCalendar.this;
                if (i4 == 0) {
                    iArr[0] = materialCalendar.recyclerView.getWidth();
                    iArr[1] = materialCalendar.recyclerView.getWidth();
                } else {
                    iArr[0] = materialCalendar.recyclerView.getHeight();
                    iArr[1] = materialCalendar.recyclerView.getHeight();
                }
            }

            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public final void smoothScrollToPosition(RecyclerView recyclerView3, int i4) {
                SmoothCalendarLayoutManager$1 smoothCalendarLayoutManager$1 = new SmoothCalendarLayoutManager$1(recyclerView3.getContext());
                smoothCalendarLayoutManager$1.mTargetPosition = i4;
                startSmoothScroll(smoothCalendarLayoutManager$1);
            }
        });
        this.recyclerView.setTag("MONTHS_VIEW_GROUP_TAG");
        final MonthsPagerAdapter monthsPagerAdapter = new MonthsPagerAdapter(contextThemeWrapper, this.calendarConstraints, new ConnectionPool(this));
        this.recyclerView.setAdapter(monthsPagerAdapter);
        int integer = contextThemeWrapper.getResources().getInteger(R.integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView3 = (RecyclerView) viewInflate.findViewById(R.id.mtrl_calendar_year_selector_frame);
        this.yearSelector = recyclerView3;
        if (recyclerView3 != null) {
            recyclerView3.setHasFixedSize(true);
            this.yearSelector.setLayoutManager(new GridLayoutManager(integer));
            this.yearSelector.setAdapter(new YearGridAdapter(this));
            RecyclerView recyclerView4 = this.yearSelector;
            AnonymousClass4 anonymousClass4 = new AnonymousClass4();
            UtcDates.getUtcCalendarOf(null);
            UtcDates.getUtcCalendarOf(null);
            recyclerView4.addItemDecoration(anonymousClass4);
        }
        if (viewInflate.findViewById(R.id.month_navigation_fragment_toggle) != null) {
            final MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.month_navigation_fragment_toggle);
            materialButton.setTag("SELECTOR_TOGGLE_TAG");
            ViewCompat.setAccessibilityDelegate(materialButton, new AnonymousClass5(0, this));
            MaterialButton materialButton2 = (MaterialButton) viewInflate.findViewById(R.id.month_navigation_previous);
            materialButton2.setTag("NAVIGATION_PREV_TAG");
            MaterialButton materialButton3 = (MaterialButton) viewInflate.findViewById(R.id.month_navigation_next);
            materialButton3.setTag("NAVIGATION_NEXT_TAG");
            this.yearFrame = viewInflate.findViewById(R.id.mtrl_calendar_year_selector_frame);
            this.dayFrame = viewInflate.findViewById(R.id.mtrl_calendar_day_selector_frame);
            setSelector$1(1);
            materialButton.setText(this.current.getLongName());
            this.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.google.android.material.datepicker.MaterialCalendar.6
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public final void onScrollStateChanged(RecyclerView recyclerView5, int i4) {
                    if (i4 == 0) {
                        recyclerView5.announceForAccessibility(materialButton.getText());
                    }
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public final void onScrolled(RecyclerView recyclerView5, int i4, int i5) {
                    int iFindLastVisibleItemPosition;
                    CalendarConstraints calendarConstraints = monthsPagerAdapter.calendarConstraints;
                    MaterialCalendar materialCalendar = MaterialCalendar.this;
                    if (i4 < 0) {
                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) materialCalendar.recyclerView.getLayoutManager();
                        View viewFindOneVisibleChild = linearLayoutManager.findOneVisibleChild(0, linearLayoutManager.getChildCount(), false);
                        iFindLastVisibleItemPosition = viewFindOneVisibleChild == null ? -1 : RecyclerView.LayoutManager.getPosition(viewFindOneVisibleChild);
                    } else {
                        iFindLastVisibleItemPosition = ((LinearLayoutManager) materialCalendar.recyclerView.getLayoutManager()).findLastVisibleItemPosition();
                    }
                    Calendar dayCopy = UtcDates.getDayCopy(calendarConstraints.start.firstOfMonth);
                    dayCopy.add(2, iFindLastVisibleItemPosition);
                    materialCalendar.current = new Month(dayCopy);
                    Calendar dayCopy2 = UtcDates.getDayCopy(calendarConstraints.start.firstOfMonth);
                    dayCopy2.add(2, iFindLastVisibleItemPosition);
                    dayCopy2.set(5, 1);
                    Calendar dayCopy3 = UtcDates.getDayCopy(dayCopy2);
                    dayCopy3.get(2);
                    dayCopy3.get(1);
                    dayCopy3.getMaximum(7);
                    dayCopy3.getActualMaximum(5);
                    dayCopy3.getTimeInMillis();
                    materialButton.setText(DateUtils.formatDateTime(null, dayCopy3.getTimeInMillis(), 8228));
                }
            });
            materialButton.setOnClickListener(new Toolbar.AnonymousClass4(3, this));
            final int i4 = 0;
            materialButton3.setOnClickListener(new View.OnClickListener(this) { // from class: com.google.android.material.datepicker.MaterialCalendar.8
                public final /* synthetic */ MaterialCalendar this$0;

                {
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i4) {
                        case 0:
                            MaterialCalendar materialCalendar = this.this$0;
                            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) materialCalendar.recyclerView.getLayoutManager();
                            View viewFindOneVisibleChild = linearLayoutManager.findOneVisibleChild(0, linearLayoutManager.getChildCount(), false);
                            int position = (viewFindOneVisibleChild == null ? -1 : RecyclerView.LayoutManager.getPosition(viewFindOneVisibleChild)) + 1;
                            if (position < materialCalendar.recyclerView.getAdapter().getItemCount()) {
                                Calendar dayCopy = UtcDates.getDayCopy(monthsPagerAdapter.calendarConstraints.start.firstOfMonth);
                                dayCopy.add(2, position);
                                materialCalendar.setCurrentMonth(new Month(dayCopy));
                            }
                            break;
                        default:
                            MaterialCalendar materialCalendar2 = this.this$0;
                            int iFindLastVisibleItemPosition = ((LinearLayoutManager) materialCalendar2.recyclerView.getLayoutManager()).findLastVisibleItemPosition() - 1;
                            if (iFindLastVisibleItemPosition >= 0) {
                                Calendar dayCopy2 = UtcDates.getDayCopy(monthsPagerAdapter.calendarConstraints.start.firstOfMonth);
                                dayCopy2.add(2, iFindLastVisibleItemPosition);
                                materialCalendar2.setCurrentMonth(new Month(dayCopy2));
                            }
                            break;
                    }
                }
            });
            final int i5 = 1;
            materialButton2.setOnClickListener(new View.OnClickListener(this) { // from class: com.google.android.material.datepicker.MaterialCalendar.8
                public final /* synthetic */ MaterialCalendar this$0;

                {
                    this.this$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i5) {
                        case 0:
                            MaterialCalendar materialCalendar = this.this$0;
                            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) materialCalendar.recyclerView.getLayoutManager();
                            View viewFindOneVisibleChild = linearLayoutManager.findOneVisibleChild(0, linearLayoutManager.getChildCount(), false);
                            int position = (viewFindOneVisibleChild == null ? -1 : RecyclerView.LayoutManager.getPosition(viewFindOneVisibleChild)) + 1;
                            if (position < materialCalendar.recyclerView.getAdapter().getItemCount()) {
                                Calendar dayCopy = UtcDates.getDayCopy(monthsPagerAdapter.calendarConstraints.start.firstOfMonth);
                                dayCopy.add(2, position);
                                materialCalendar.setCurrentMonth(new Month(dayCopy));
                            }
                            break;
                        default:
                            MaterialCalendar materialCalendar2 = this.this$0;
                            int iFindLastVisibleItemPosition = ((LinearLayoutManager) materialCalendar2.recyclerView.getLayoutManager()).findLastVisibleItemPosition() - 1;
                            if (iFindLastVisibleItemPosition >= 0) {
                                Calendar dayCopy2 = UtcDates.getDayCopy(monthsPagerAdapter.calendarConstraints.start.firstOfMonth);
                                dayCopy2.add(2, iFindLastVisibleItemPosition);
                                materialCalendar2.setCurrentMonth(new Month(dayCopy2));
                            }
                            break;
                    }
                }
            });
        }
        if (!MaterialDatePicker.readMaterialCalendarStyleBoolean(contextThemeWrapper, android.R.attr.windowFullscreen) && (recyclerView2 = (pagerSnapHelper = new PagerSnapHelper()).mRecyclerView) != (recyclerView = this.recyclerView)) {
            SnapHelper$1 snapHelper$1 = pagerSnapHelper.mScrollListener;
            if (recyclerView2 != null) {
                ArrayList arrayList = recyclerView2.mScrollListeners;
                if (arrayList != null) {
                    arrayList.remove(snapHelper$1);
                }
                pagerSnapHelper.mRecyclerView.setOnFlingListener(null);
            }
            pagerSnapHelper.mRecyclerView = recyclerView;
            if (recyclerView != null) {
                if (recyclerView.getOnFlingListener() != null) {
                    throw new IllegalStateException("An instance of OnFlingListener already set.");
                }
                pagerSnapHelper.mRecyclerView.addOnScrollListener(snapHelper$1);
                pagerSnapHelper.mRecyclerView.setOnFlingListener(pagerSnapHelper);
                new Scroller(pagerSnapHelper.mRecyclerView.getContext(), new DecelerateInterpolator());
                pagerSnapHelper.snapToTargetExistingView();
            }
        }
        this.recyclerView.scrollToPosition(monthsPagerAdapter.calendarConstraints.start.monthsUntil(this.current));
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.themeResId);
        bundle.putParcelable("GRID_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.calendarConstraints);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.current);
    }

    public final void setCurrentMonth(Month month) {
        MonthsPagerAdapter monthsPagerAdapter = (MonthsPagerAdapter) this.recyclerView.getAdapter();
        int iMonthsUntil = monthsPagerAdapter.calendarConstraints.start.monthsUntil(month);
        int iMonthsUntil2 = iMonthsUntil - monthsPagerAdapter.calendarConstraints.start.monthsUntil(this.current);
        boolean z = Math.abs(iMonthsUntil2) > 3;
        boolean z2 = iMonthsUntil2 > 0;
        this.current = month;
        if (z && z2) {
            this.recyclerView.scrollToPosition(iMonthsUntil - 3);
            this.recyclerView.post(new CallbackWrapper$2(iMonthsUntil, 3, this));
        } else if (!z) {
            this.recyclerView.post(new CallbackWrapper$2(iMonthsUntil, 3, this));
        } else {
            this.recyclerView.scrollToPosition(iMonthsUntil + 3);
            this.recyclerView.post(new CallbackWrapper$2(iMonthsUntil, 3, this));
        }
    }

    public final void setSelector$1(int i) {
        this.calendarSelector = i;
        if (i == 2) {
            this.yearSelector.getLayoutManager().scrollToPosition(this.current.year - ((YearGridAdapter) this.yearSelector.getAdapter()).materialCalendar.calendarConstraints.start.year);
            this.yearFrame.setVisibility(0);
            this.dayFrame.setVisibility(8);
            return;
        }
        if (i == 1) {
            this.yearFrame.setVisibility(8);
            this.dayFrame.setVisibility(0);
            setCurrentMonth(this.current);
        }
    }
}
