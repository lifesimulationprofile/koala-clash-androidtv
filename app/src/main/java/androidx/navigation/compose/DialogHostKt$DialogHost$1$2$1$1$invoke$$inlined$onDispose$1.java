package androidx.navigation.compose;

import androidx.activity.compose.BackHandlerKt$BackHandler$lambda$4$0$$inlined$onStopOrDispose$1;
import androidx.collection.MutableScatterMap;
import androidx.compose.animation.AnimatedContentTransitionScopeImpl;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.saveable.SaveableStateHolderImpl;
import androidx.compose.runtime.saveable.SaveableStateRegistryWrapper;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda3;
import androidx.navigation.NavBackStackEntry;
import java.util.Map;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DialogHostKt$DialogHost$1$2$1$1$invoke$$inlined$onDispose$1 implements DisposableEffectResult {
    public final /* synthetic */ Object $backStackEntry$inlined;
    public final /* synthetic */ Object $dialogNavigator$inlined;
    public final /* synthetic */ Object $dialogsToDispose$inlined;
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ DialogHostKt$DialogHost$1$2$1$1$invoke$$inlined$onDispose$1(Object obj, Object obj2, Object obj3, int i) {
        this.$r8$classId = i;
        this.$dialogNavigator$inlined = obj;
        this.$backStackEntry$inlined = obj2;
        this.$dialogsToDispose$inlined = obj3;
    }

    @Override // androidx.compose.runtime.DisposableEffectResult
    public final void dispose() {
        switch (this.$r8$classId) {
            case 0:
                DialogNavigator dialogNavigator = (DialogNavigator) this.$dialogNavigator$inlined;
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) this.$backStackEntry$inlined;
                dialogNavigator.getState().markTransitionComplete(navBackStackEntry);
                ((SnapshotStateList) this.$dialogsToDispose$inlined).remove(navBackStackEntry);
                break;
            case 1:
                SnapshotStateList snapshotStateList = (SnapshotStateList) this.$dialogsToDispose$inlined;
                Object obj = this.$dialogNavigator$inlined;
                snapshotStateList.remove(obj);
                ((AnimatedContentTransitionScopeImpl) this.$backStackEntry$inlined).targetSizeMap.remove(obj);
                break;
            case 2:
                SaveableStateHolderImpl saveableStateHolderImpl = (SaveableStateHolderImpl) this.$dialogNavigator$inlined;
                MutableScatterMap mutableScatterMap = saveableStateHolderImpl.registries;
                Object obj2 = this.$backStackEntry$inlined;
                Object objRemove = mutableScatterMap.remove(obj2);
                SaveableStateRegistryWrapper saveableStateRegistryWrapper = (SaveableStateRegistryWrapper) this.$dialogsToDispose$inlined;
                if (objRemove == saveableStateRegistryWrapper) {
                    Map map = saveableStateHolderImpl.savedStates;
                    Map mapPerformSave = saveableStateRegistryWrapper.performSave();
                    if (!mapPerformSave.isEmpty()) {
                        map.put(obj2, mapPerformSave);
                    } else {
                        map.remove(obj2);
                    }
                }
                break;
            default:
                ((LifecycleOwner) this.$dialogNavigator$inlined).getLifecycle().removeObserver((LifecycleEffectKt$$ExternalSyntheticLambda3) this.$backStackEntry$inlined);
                BackHandlerKt$BackHandler$lambda$4$0$$inlined$onStopOrDispose$1 backHandlerKt$BackHandler$lambda$4$0$$inlined$onStopOrDispose$1 = (BackHandlerKt$BackHandler$lambda$4$0$$inlined$onStopOrDispose$1) ((Ref$ObjectRef) this.$dialogsToDispose$inlined).element;
                if (backHandlerKt$BackHandler$lambda$4$0$$inlined$onStopOrDispose$1 != null) {
                    backHandlerKt$BackHandler$lambda$4$0$$inlined$onStopOrDispose$1.runStopOrDisposeEffect();
                }
                break;
        }
    }

    public DialogHostKt$DialogHost$1$2$1$1$invoke$$inlined$onDispose$1(SnapshotStateList snapshotStateList, Object obj, AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl) {
        this.$r8$classId = 1;
        this.$dialogsToDispose$inlined = snapshotStateList;
        this.$dialogNavigator$inlined = obj;
        this.$backStackEntry$inlined = animatedContentTransitionScopeImpl;
    }
}
