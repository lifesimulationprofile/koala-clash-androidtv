package com.github.kr328.clash;

import android.content.ClipData;
import android.content.ClipboardManager;
import com.github.kr328.clash.design.model.AppInfo;
import com.github.kr328.clash.design.store.UiStore;
import com.github.kr328.clash.service.store.ServiceStore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AccessControlActivity$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ AccessControlActivity f$0;

    public /* synthetic */ AccessControlActivity$$ExternalSyntheticLambda0(AccessControlActivity accessControlActivity, int i) {
        this.$r8$classId = i;
        this.f$0 = accessControlActivity;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        Object value;
        Object value2;
        LinkedHashSet linkedHashSet;
        Set set;
        Object value3;
        Object value4;
        int i = this.$r8$classId;
        AccessControlActivity accessControlActivity = this.f$0;
        switch (i) {
            case 0:
                int i2 = AccessControlActivity.$r8$clinit;
                return new UiStore(accessControlActivity);
            case 1:
                int i3 = AccessControlActivity.$r8$clinit;
                return new ServiceStore(accessControlActivity);
            case 2:
                Set set2 = accessControlActivity.selected;
                if (set2 != null) {
                    set2.clear();
                    Set set3 = accessControlActivity.selected;
                    if (set3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("selected");
                        throw null;
                    }
                    Iterable iterable = (Iterable) accessControlActivity.appsFlow.getValue();
                    ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
                    Iterator it = iterable.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((AppInfo) it.next()).packageName);
                    }
                    set3.addAll(arrayList);
                    StateFlowImpl stateFlowImpl = accessControlActivity.selectionVersion;
                    do {
                        value = stateFlowImpl.getValue();
                    } while (!stateFlowImpl.compareAndSet(value, Integer.valueOf(((Number) value).intValue() + 1)));
                }
                return Unit.INSTANCE;
            case 3:
                Set set4 = accessControlActivity.selected;
                if (set4 != null) {
                    set4.clear();
                    StateFlowImpl stateFlowImpl2 = accessControlActivity.selectionVersion;
                    do {
                        value2 = stateFlowImpl2.getValue();
                    } while (!stateFlowImpl2.compareAndSet(value2, Integer.valueOf(((Number) value2).intValue() + 1)));
                }
                return Unit.INSTANCE;
            case 4:
                if (accessControlActivity.selected != null) {
                    Iterable iterable2 = (Iterable) accessControlActivity.appsFlow.getValue();
                    ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable2, 10));
                    Iterator it2 = iterable2.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(((AppInfo) it2.next()).packageName);
                    }
                    Set set5 = CollectionsKt.toSet(arrayList2);
                    Set set6 = accessControlActivity.selected;
                    if (set6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("selected");
                        throw null;
                    }
                    Set set7 = set6;
                    Set list = set7 instanceof Collection ? set7 : CollectionsKt.toList(set7);
                    if (list.isEmpty()) {
                        set = CollectionsKt.toSet(set5);
                    } else {
                        if (list instanceof Set) {
                            linkedHashSet = new LinkedHashSet();
                            for (Object obj : set5) {
                                if (!((Set) list).contains(obj)) {
                                    linkedHashSet.add(obj);
                                }
                            }
                        } else {
                            linkedHashSet = new LinkedHashSet(set5);
                            linkedHashSet.removeAll(list);
                        }
                        set = linkedHashSet;
                    }
                    Set set8 = accessControlActivity.selected;
                    if (set8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("selected");
                        throw null;
                    }
                    set8.clear();
                    Set set9 = accessControlActivity.selected;
                    if (set9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("selected");
                        throw null;
                    }
                    set9.addAll(set);
                    StateFlowImpl stateFlowImpl3 = accessControlActivity.selectionVersion;
                    do {
                        value3 = stateFlowImpl3.getValue();
                    } while (!stateFlowImpl3.compareAndSet(value3, Integer.valueOf(((Number) value3).intValue() + 1)));
                }
                return Unit.INSTANCE;
            case 5:
                if (accessControlActivity.selected != null) {
                    ClipboardManager clipboardManager = (ClipboardManager) accessControlActivity.getSystemService(ClipboardManager.class);
                    ClipData primaryClip = clipboardManager != null ? clipboardManager.getPrimaryClip() : null;
                    if (primaryClip != null && primaryClip.getItemCount() > 0) {
                        Set set10 = CollectionsKt.toSet(StringsKt.split$default(primaryClip.getItemAt(0).getText(), new String[]{"\n"}, 0, 6));
                        Iterable iterable3 = (Iterable) accessControlActivity.appsFlow.getValue();
                        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable3, 10));
                        Iterator it3 = iterable3.iterator();
                        while (it3.hasNext()) {
                            arrayList3.add(((AppInfo) it3.next()).packageName);
                        }
                        Set set11 = set10;
                        Set mutableSet = CollectionsKt.toMutableSet(arrayList3);
                        mutableSet.retainAll(set11 instanceof Collection ? set11 : CollectionsKt.toList(set11));
                        Set set12 = accessControlActivity.selected;
                        if (set12 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("selected");
                            throw null;
                        }
                        set12.clear();
                        Set set13 = accessControlActivity.selected;
                        if (set13 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("selected");
                            throw null;
                        }
                        set13.addAll(mutableSet);
                        StateFlowImpl stateFlowImpl4 = accessControlActivity.selectionVersion;
                        do {
                            value4 = stateFlowImpl4.getValue();
                        } while (!stateFlowImpl4.compareAndSet(value4, Integer.valueOf(((Number) value4).intValue() + 1)));
                    }
                }
                return Unit.INSTANCE;
            case 6:
                if (accessControlActivity.selected != null) {
                    ClipboardManager clipboardManager2 = (ClipboardManager) accessControlActivity.getSystemService(ClipboardManager.class);
                    Set set14 = accessControlActivity.selected;
                    if (set14 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("selected");
                        throw null;
                    }
                    ClipData clipDataNewPlainText = ClipData.newPlainText("packages", CollectionsKt.joinToString$default(set14, "\n", null, null, null, 62));
                    if (clipboardManager2 != null) {
                        clipboardManager2.setPrimaryClip(clipDataNewPlainText);
                    }
                }
                return Unit.INSTANCE;
            default:
                accessControlActivity.finish();
                return Unit.INSTANCE;
        }
    }
}
