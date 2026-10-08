package androidx.navigation.compose;

import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.runtime.saveable.SaveableStateHolderImpl;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.node.LayoutNodeDrawScope$record$1;
import androidx.compose.ui.platform.InspectionModeKt;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.PopupLayout$Content$4;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.navigation.NavBackStackEntry;
import com.github.kr328.clash.LogcatActivity$writeLogTo$2$1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class DialogHostKt {
    public static final void DialogHost(DialogNavigator dialogNavigator, GapComposer gapComposer, int i) {
        SnapshotStateList snapshotStateList;
        final DialogNavigator dialogNavigator2 = dialogNavigator;
        gapComposer.startRestartGroup(294589392);
        int i2 = i | (gapComposer.changed(dialogNavigator2) ? 4 : 2);
        if ((i2 & 3) == 2 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            final SaveableStateHolderImpl saveableStateHolderImplRememberSaveableStateHolder = SaverKt.rememberSaveableStateHolder(gapComposer);
            MutableState mutableStateCollectAsState = Stack.collectAsState(dialogNavigator2.getState().backStack, gapComposer, 0);
            List list = (List) mutableStateCollectAsState.getValue();
            boolean zBooleanValue = ((Boolean) gapComposer.consume(InspectionModeKt.LocalInspectionMode)).booleanValue();
            boolean zChanged = gapComposer.changed(list);
            Object objRememberedValue = gapComposer.rememberedValue();
            Object obj = Composer$Companion.Empty;
            Object obj2 = objRememberedValue;
            if (zChanged || objRememberedValue == obj) {
                SnapshotStateList snapshotStateList2 = new SnapshotStateList();
                ArrayList arrayList = new ArrayList();
                for (Object obj3 : list) {
                    if (zBooleanValue ? true : ((NavBackStackEntry) obj3)._lifecycle.state.isAtLeast(Lifecycle.State.STARTED)) {
                        arrayList.add(obj3);
                    }
                }
                snapshotStateList2.addAll(arrayList);
                gapComposer.updateRememberedValue(snapshotStateList2);
                obj2 = snapshotStateList2;
            }
            SnapshotStateList snapshotStateList3 = (SnapshotStateList) obj2;
            PopulateVisibleList(snapshotStateList3, (List) mutableStateCollectAsState.getValue(), gapComposer, 0);
            MutableState mutableStateCollectAsState2 = Stack.collectAsState(dialogNavigator2.getState().transitionsInProgress, gapComposer, 0);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == obj) {
                objRememberedValue2 = new SnapshotStateList();
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            final SnapshotStateList snapshotStateList4 = (SnapshotStateList) objRememberedValue2;
            gapComposer.startReplaceGroup(1361037007);
            ListIterator listIterator = snapshotStateList3.listIterator();
            while (true) {
                ListBuilder.Itr itr = (ListBuilder.Itr) listIterator;
                if (!itr.hasNext()) {
                    break;
                }
                final NavBackStackEntry navBackStackEntry = (NavBackStackEntry) itr.next();
                final DialogNavigator.Destination destination = (DialogNavigator.Destination) navBackStackEntry.destination;
                boolean zChangedInstance = ((i2 & 14) == 4) | gapComposer.changedInstance(navBackStackEntry);
                Object objRememberedValue3 = gapComposer.rememberedValue();
                if (zChangedInstance || objRememberedValue3 == obj) {
                    objRememberedValue3 = new DialogHostKt$DialogHost$1$1$1(0, dialogNavigator2, navBackStackEntry);
                    gapComposer.updateRememberedValue(objRememberedValue3);
                }
                AndroidDialog_androidKt.Dialog((Function0) objRememberedValue3, destination.dialogProperties, Thread_jvmKt.rememberComposableLambda(1129586364, new Function2() { // from class: androidx.navigation.compose.DialogHostKt$DialogHost$1$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj4, Object obj5) {
                        GapComposer gapComposer2 = (GapComposer) obj4;
                        if ((((Number) obj5).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                            gapComposer2.skipToGroupEnd();
                        } else {
                            NavBackStackEntry navBackStackEntry2 = navBackStackEntry;
                            boolean zChangedInstance2 = gapComposer2.changedInstance(navBackStackEntry2);
                            DialogNavigator dialogNavigator3 = dialogNavigator2;
                            boolean zChanged2 = zChangedInstance2 | gapComposer2.changed(dialogNavigator3);
                            Object objRememberedValue4 = gapComposer2.rememberedValue();
                            if (zChanged2 || objRememberedValue4 == Composer$Companion.Empty) {
                                objRememberedValue4 = new LayoutNodeDrawScope$record$1(snapshotStateList4, navBackStackEntry2, dialogNavigator3, 6);
                                gapComposer2.updateRememberedValue(objRememberedValue4);
                            }
                            Stack.DisposableEffect(navBackStackEntry2, (Function1) objRememberedValue4, gapComposer2);
                            NavBackStackEntryProviderKt.LocalOwnersProvider(navBackStackEntry2, saveableStateHolderImplRememberSaveableStateHolder, Thread_jvmKt.rememberComposableLambda(-497631156, new NavHostKt.AnonymousClass32.AnonymousClass1(destination, navBackStackEntry2), gapComposer2), gapComposer2, 384);
                        }
                        return Unit.INSTANCE;
                    }
                }, gapComposer), gapComposer, 384);
                dialogNavigator2 = dialogNavigator;
            }
            gapComposer.end(false);
            Set set = (Set) mutableStateCollectAsState2.getValue();
            boolean zChanged2 = gapComposer.changed(mutableStateCollectAsState2) | ((i2 & 14) == 4);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (zChanged2 || objRememberedValue4 == obj) {
                snapshotStateList = snapshotStateList4;
                dialogNavigator2 = dialogNavigator;
                Object logcatActivity$writeLogTo$2$1 = new LogcatActivity$writeLogTo$2$1(mutableStateCollectAsState2, dialogNavigator2, snapshotStateList, null, 2);
                gapComposer.updateRememberedValue(logcatActivity$writeLogTo$2$1);
                objRememberedValue4 = logcatActivity$writeLogTo$2$1;
            } else {
                dialogNavigator2 = dialogNavigator;
                snapshotStateList = snapshotStateList4;
            }
            Stack.LaunchedEffect(set, snapshotStateList, (Function2) objRememberedValue4, gapComposer);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new PopupLayout$Content$4(i, 8, dialogNavigator2);
        }
    }

    public static final void PopulateVisibleList(final List list, Collection collection, GapComposer gapComposer, int i) {
        gapComposer.startRestartGroup(1537894851);
        if ((((gapComposer.changedInstance(list) ? 4 : 2) | i | (gapComposer.changedInstance(collection) ? 32 : 16)) & 19) == 18 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            final boolean zBooleanValue = ((Boolean) gapComposer.consume(InspectionModeKt.LocalInspectionMode)).booleanValue();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                final NavBackStackEntry navBackStackEntry = (NavBackStackEntry) it.next();
                LifecycleRegistry lifecycleRegistry = navBackStackEntry._lifecycle;
                boolean zChanged = gapComposer.changed(zBooleanValue) | gapComposer.changedInstance(list) | gapComposer.changedInstance(navBackStackEntry);
                Object objRememberedValue = gapComposer.rememberedValue();
                if (zChanged || objRememberedValue == Composer$Companion.Empty) {
                    objRememberedValue = new Function1() { // from class: androidx.navigation.compose.DialogHostKt$PopulateVisibleList$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            final NavBackStackEntry navBackStackEntry2 = navBackStackEntry;
                            final List list2 = list;
                            final boolean z = zBooleanValue;
                            LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.navigation.compose.DialogHostKt$PopulateVisibleList$1$1$1$$ExternalSyntheticLambda0
                                @Override // androidx.lifecycle.LifecycleEventObserver
                                public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                                    boolean z2 = z;
                                    List list3 = list2;
                                    NavBackStackEntry navBackStackEntry3 = navBackStackEntry2;
                                    if (z2 && !list3.contains(navBackStackEntry3)) {
                                        list3.add(navBackStackEntry3);
                                    }
                                    if (event == Lifecycle.Event.ON_START && !list3.contains(navBackStackEntry3)) {
                                        list3.add(navBackStackEntry3);
                                    }
                                    if (event == Lifecycle.Event.ON_STOP) {
                                        list3.remove(navBackStackEntry3);
                                    }
                                }
                            };
                            navBackStackEntry2._lifecycle.addObserver(lifecycleEventObserver);
                            return new NavHostKt$NavHost$27$1$invoke$$inlined$onDispose$1(10, navBackStackEntry2, lifecycleEventObserver);
                        }
                    };
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                Stack.DisposableEffect(lifecycleRegistry, (Function1) objRememberedValue, gapComposer);
            }
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new NavHostKt.AnonymousClass32.AnonymousClass1(i, 6, list, collection);
        }
    }
}
