package com.google.android.material.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Rational;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.camera.camera2.internal.ExposureStateImpl;
import androidx.collection.MutableLongIntMap;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.core.view.ViewCompat;
import com.github.kr328.clash.design.model.AppInfo;
import com.google.android.material.R$styleable;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.google.android.material.timepicker.TimePickerView;
import com.koala.clash.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import okhttp3.Headers;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class MaterialButtonToggleGroup extends LinearLayout {
    public static final /* synthetic */ int $r8$clinit = 0;
    public HashSet checkedIds;
    public Integer[] childOrder;
    public final AnonymousClass1 childOrderComparator;
    public final int defaultCheckId;
    public final LinkedHashSet onButtonCheckedListeners;
    public final ArrayList originalCornerData;
    public final Headers.Builder pressedStateTracker;
    public boolean selectionRequired;
    public boolean singleSelection;
    public boolean skipCheckedStateTracker;

    /* JADX INFO: renamed from: com.google.android.material.button.MaterialButtonToggleGroup$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 implements Comparator {
        public final /* synthetic */ int $r8$classId;
        public final Object this$0;

        public /* synthetic */ AnonymousClass1(int i, Object obj) {
            this.$r8$classId = i;
            this.this$0 = obj;
        }

        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            switch (this.$r8$classId) {
                case 0:
                    MaterialButton materialButton = (MaterialButton) obj;
                    MaterialButton materialButton2 = (MaterialButton) obj2;
                    MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) this.this$0;
                    int iCompareTo = Boolean.valueOf(materialButton.checked).compareTo(Boolean.valueOf(materialButton2.checked));
                    if (iCompareTo != 0) {
                        return iCompareTo;
                    }
                    int iCompareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
                    return iCompareTo2 != 0 ? iCompareTo2 : Integer.valueOf(materialButtonToggleGroup.indexOfChild(materialButton)).compareTo(Integer.valueOf(materialButtonToggleGroup.indexOfChild(materialButton2)));
                case 1:
                    Rational rational = (Rational) obj2;
                    Rational rational2 = (Rational) this.this$0;
                    float fFloatValue = ((Rational) obj).floatValue();
                    float fFloatValue2 = rational2.floatValue();
                    float f = fFloatValue > fFloatValue2 ? fFloatValue2 / fFloatValue : fFloatValue / fFloatValue2;
                    float fFloatValue3 = rational.floatValue();
                    float fFloatValue4 = rational2.floatValue();
                    return Float.compare(fFloatValue3 > fFloatValue4 ? fFloatValue4 / fFloatValue3 : fFloatValue3 / fFloatValue4, f);
                case 2:
                    long jLongValue = ((Number) obj).longValue();
                    MutableLongIntMap mutableLongIntMap = (MutableLongIntMap) this.this$0;
                    return ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(mutableLongIntMap.get(jLongValue)), Integer.valueOf(mutableLongIntMap.get(((Number) obj2).longValue())));
                case 3:
                    int iCompare = ((Comparator) this.this$0).compare(obj, obj2);
                    if (iCompare != 0) {
                        return iCompare;
                    }
                    return LayoutNode.ZComparator.compare(((SemanticsNode) obj).layoutNode, ((SemanticsNode) obj2).layoutNode);
                case 4:
                    int iCompare2 = ((AnonymousClass1) this.this$0).compare(obj, obj2);
                    return iCompare2 != 0 ? iCompare2 : ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((SemanticsNode) obj).id), Integer.valueOf(((SemanticsNode) obj2).id));
                default:
                    Set set = (Set) this.this$0;
                    return ComparisonsKt__ComparisonsKt.compareValues(Boolean.valueOf(set.contains(((AppInfo) obj2).packageName)), Boolean.valueOf(set.contains(((AppInfo) obj).packageName)));
            }
        }

        public AnonymousClass1(Comparator comparator) {
            this.$r8$classId = 3;
            this.this$0 = comparator;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class CornerData {
        public static final AbsoluteCornerSize noCorner = new AbsoluteCornerSize(0.0f);
        public final CornerSize bottomLeft;
        public final CornerSize bottomRight;
        public final CornerSize topLeft;
        public final CornerSize topRight;

        public CornerData(CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4) {
            this.topLeft = cornerSize;
            this.topRight = cornerSize3;
            this.bottomRight = cornerSize4;
            this.bottomLeft = cornerSize2;
        }
    }

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, R.attr.materialButtonToggleGroupStyle, R.style.Widget_MaterialComponents_MaterialButtonToggleGroup), attributeSet, R.attr.materialButtonToggleGroupStyle);
        this.originalCornerData = new ArrayList();
        this.pressedStateTracker = new Headers.Builder(9, this);
        this.onButtonCheckedListeners = new LinkedHashSet();
        this.childOrderComparator = new AnonymousClass1(0, this);
        this.skipCheckedStateTracker = false;
        this.checkedIds = new HashSet();
        TypedArray typedArrayObtainStyledAttributes = ViewUtils.obtainStyledAttributes(getContext(), attributeSet, R$styleable.MaterialButtonToggleGroup, R.attr.materialButtonToggleGroupStyle, R.style.Widget_MaterialComponents_MaterialButtonToggleGroup, new int[0]);
        setSingleSelection(typedArrayObtainStyledAttributes.getBoolean(2, false));
        this.defaultCheckId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        this.selectionRequired = typedArrayObtainStyledAttributes.getBoolean(1, false);
        setChildrenDrawingOrderEnabled(true);
        typedArrayObtainStyledAttributes.recycle();
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        setImportantForAccessibility(1);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (isChildVisible(i)) {
                return i;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (isChildVisible(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if ((getChildAt(i2) instanceof MaterialButton) && isChildVisible(i2)) {
                i++;
            }
        }
        return i;
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            materialButton.setId(View.generateViewId());
        }
    }

    private void setupButtonChild(MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.setOnPressedChangeListenerInternal(this.pressedStateTracker);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e("MaterialButtonToggleGroup", "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        checkInternal(materialButton.getId(), materialButton.checked);
        ShapeAppearanceModel shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.originalCornerData.add(new CornerData(shapeAppearanceModel.topLeftCornerSize, shapeAppearanceModel.bottomLeftCornerSize, shapeAppearanceModel.topRightCornerSize, shapeAppearanceModel.bottomRightCornerSize));
        ViewCompat.setAccessibilityDelegate(materialButton, new MaterialCalendar.AnonymousClass5(1, this));
    }

    public final void adjustChildMarginsAndUpdateLayout() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i = firstVisibleChildIndex + 1; i < getChildCount(); i++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i);
            int iMin = Math.min(materialButton.getStrokeWidth(), ((MaterialButton) getChildAt(i - 1)).getStrokeWidth());
            ViewGroup.LayoutParams layoutParams = materialButton.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
            if (getOrientation() == 0) {
                layoutParams2.setMarginEnd(0);
                layoutParams2.setMarginStart(-iMin);
                layoutParams2.topMargin = 0;
            } else {
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = -iMin;
                layoutParams2.setMarginStart(0);
            }
            materialButton.setLayoutParams(layoutParams2);
        }
        if (getChildCount() == 0 || firstVisibleChildIndex == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) ((MaterialButton) getChildAt(firstVisibleChildIndex)).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams3.topMargin = 0;
            layoutParams3.bottomMargin = 0;
        } else {
            layoutParams3.setMarginEnd(0);
            layoutParams3.setMarginStart(0);
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
        }
    }

    public final void checkInternal(int i, boolean z) {
        if (i == -1) {
            Log.e("MaterialButtonToggleGroup", "Button ID is not valid: " + i);
            return;
        }
        HashSet hashSet = new HashSet(this.checkedIds);
        if (z && !hashSet.contains(Integer.valueOf(i))) {
            if (this.singleSelection && !hashSet.isEmpty()) {
                hashSet.clear();
            }
            hashSet.add(Integer.valueOf(i));
        } else {
            if (z || !hashSet.contains(Integer.valueOf(i))) {
                return;
            }
            if (!this.selectionRequired || hashSet.size() > 1) {
                hashSet.remove(Integer.valueOf(i));
            }
        }
        updateCheckedIds(hashSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        TreeMap treeMap = new TreeMap(this.childOrderComparator);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            treeMap.put((MaterialButton) getChildAt(i), Integer.valueOf(i));
        }
        this.childOrder = (Integer[]) treeMap.values().toArray(new Integer[0]);
        super.dispatchDraw(canvas);
    }

    public int getCheckedButtonId() {
        if (!this.singleSelection || this.checkedIds.isEmpty()) {
            return -1;
        }
        return ((Integer) this.checkedIds.iterator().next()).intValue();
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < getChildCount(); i++) {
            int id = ((MaterialButton) getChildAt(i)).getId();
            if (this.checkedIds.contains(Integer.valueOf(id))) {
                arrayList.add(Integer.valueOf(id));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i, int i2) {
        Integer[] numArr = this.childOrder;
        if (numArr != null && i2 < numArr.length) {
            return numArr[i2].intValue();
        }
        Log.w("MaterialButtonToggleGroup", "Child order wasn't updated");
        return i2;
    }

    public final boolean isChildVisible(int i) {
        return getChildAt(i).getVisibility() != 8;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int i = this.defaultCheckId;
        if (i != -1) {
            updateCheckedIds(Collections.singleton(Integer.valueOf(i)));
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) ExposureStateImpl.obtain(1, getVisibleButtonCount(), this.singleSelection ? 1 : 2).mLock);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        updateChildShapes();
        adjustChildMarginsAndUpdateLayout();
        super.onMeasure(i, i2);
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int iIndexOfChild = indexOfChild(view);
        if (iIndexOfChild >= 0) {
            this.originalCornerData.remove(iIndexOfChild);
        }
        updateChildShapes();
        adjustChildMarginsAndUpdateLayout();
    }

    public void setSelectionRequired(boolean z) {
        this.selectionRequired = z;
    }

    public void setSingleSelection(boolean z) {
        if (this.singleSelection != z) {
            this.singleSelection = z;
            updateCheckedIds(new HashSet());
        }
    }

    public final void updateCheckedIds(Set set) {
        HashSet hashSet = this.checkedIds;
        this.checkedIds = new HashSet(set);
        for (int i = 0; i < getChildCount(); i++) {
            int id = ((MaterialButton) getChildAt(i)).getId();
            boolean zContains = set.contains(Integer.valueOf(id));
            View viewFindViewById = findViewById(id);
            if (viewFindViewById instanceof MaterialButton) {
                this.skipCheckedStateTracker = true;
                ((MaterialButton) viewFindViewById).setChecked(zContains);
                this.skipCheckedStateTracker = false;
            }
            if (hashSet.contains(Integer.valueOf(id)) != set.contains(Integer.valueOf(id))) {
                set.contains(Integer.valueOf(id));
                Iterator it = this.onButtonCheckedListeners.iterator();
                while (it.hasNext()) {
                    ((TimePickerView.AnonymousClass2) it.next()).onButtonChecked();
                }
            }
        }
        invalidate();
    }

    public final void updateChildShapes() {
        CornerData cornerData;
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i = 0; i < childCount; i++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i);
            if (materialButton.getVisibility() != 8) {
                ShapeAppearanceModel.Builder builder = materialButton.getShapeAppearanceModel().toBuilder();
                CornerData cornerData2 = (CornerData) this.originalCornerData.get(i);
                if (firstVisibleChildIndex != lastVisibleChildIndex) {
                    boolean z = getOrientation() == 0;
                    AbsoluteCornerSize absoluteCornerSize = CornerData.noCorner;
                    if (i == firstVisibleChildIndex) {
                        cornerData = z ? ViewUtils.isLayoutRtl(this) ? new CornerData(absoluteCornerSize, absoluteCornerSize, cornerData2.topRight, cornerData2.bottomRight) : new CornerData(cornerData2.topLeft, cornerData2.bottomLeft, absoluteCornerSize, absoluteCornerSize) : new CornerData(cornerData2.topLeft, absoluteCornerSize, cornerData2.topRight, absoluteCornerSize);
                    } else if (i != lastVisibleChildIndex) {
                        cornerData2 = null;
                    } else if (z) {
                        cornerData = ViewUtils.isLayoutRtl(this) ? new CornerData(cornerData2.topLeft, cornerData2.bottomLeft, absoluteCornerSize, absoluteCornerSize) : new CornerData(absoluteCornerSize, absoluteCornerSize, cornerData2.topRight, cornerData2.bottomRight);
                    } else {
                        cornerData = new CornerData(absoluteCornerSize, cornerData2.bottomLeft, absoluteCornerSize, cornerData2.bottomRight);
                    }
                    cornerData2 = cornerData;
                }
                if (cornerData2 == null) {
                    builder.topLeftCornerSize = new AbsoluteCornerSize(0.0f);
                    builder.topRightCornerSize = new AbsoluteCornerSize(0.0f);
                    builder.bottomRightCornerSize = new AbsoluteCornerSize(0.0f);
                    builder.bottomLeftCornerSize = new AbsoluteCornerSize(0.0f);
                } else {
                    builder.topLeftCornerSize = cornerData2.topLeft;
                    builder.bottomLeftCornerSize = cornerData2.bottomLeft;
                    builder.topRightCornerSize = cornerData2.topRight;
                    builder.bottomRightCornerSize = cornerData2.bottomRight;
                }
                materialButton.setShapeAppearanceModel(builder.build());
            }
        }
    }

    public void setSingleSelection(int i) {
        setSingleSelection(getResources().getBoolean(i));
    }
}
