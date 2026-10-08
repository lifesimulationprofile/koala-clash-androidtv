package androidx.compose.foundation.lazy.layout;

import android.view.View;
import androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda2;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.view.PreviewView;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.lazy.LazyLayoutSemanticStateKt$LazyLayoutSemanticState$1;
import androidx.compose.foundation.lazy.LazyListBeyondBoundsState;
import androidx.compose.foundation.lazy.LazyListItemProviderImpl;
import androidx.compose.foundation.lazy.LazyListItemProviderImpl$$ExternalSyntheticLambda1;
import androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1;
import androidx.compose.material3.SnackbarHostKt$$ExternalSyntheticLambda0;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.DisposableEffectImpl;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.saveable.SaveableStateHolderImpl;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotId_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.PinnableContainerKt;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.node.LayoutNode$$ExternalSyntheticLambda0;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1;
import coil.disk.DiskLruCache;
import coil.request.RequestService;
import com.koala.clash.R;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.reflect.KProperty0;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class LazyLayoutKt {
    public static final LayoutNode$$ExternalSyntheticLambda0 LazyLayoutMeasuredItemIndexComparator = new LayoutNode$$ExternalSyntheticLambda0(4);

    public static final void LazyLayout(final Function0 function0, final Modifier modifier, final LazyLayoutPrefetchState lazyLayoutPrefetchState, final LazyListKt$rememberLazyListMeasurePolicy$1$1 lazyListKt$rememberLazyListMeasurePolicy$1$1, GapComposer gapComposer, final int i) {
        gapComposer.startRestartGroup(1055276397);
        int i2 = (gapComposer.changedInstance(function0) ? 4 : 2) | i | (gapComposer.changed(modifier) ? 32 : 16) | (gapComposer.changed(lazyLayoutPrefetchState) ? 256 : 128) | (gapComposer.changed(lazyListKt$rememberLazyListMeasurePolicy$1$1) ? 2048 : 1024);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 1171) != 1170)) {
            final MutableState mutableStateRememberUpdatedState = Stack.rememberUpdatedState(function0, gapComposer);
            LazySaveableStateHolderProvider(Thread_jvmKt.rememberComposableLambda(-933153643, new Function3() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Modifier modifierThen;
                    SaveableStateHolder saveableStateHolder = (SaveableStateHolder) obj;
                    GapComposer gapComposer2 = (GapComposer) obj2;
                    ((Integer) obj3).getClass();
                    Object objRememberedValue = gapComposer2.rememberedValue();
                    NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
                    if (objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new LazyLayoutItemContentFactory(saveableStateHolder, new TooltipKt$$ExternalSyntheticLambda0(mutableStateRememberUpdatedState, 2));
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    final LazyLayoutItemContentFactory lazyLayoutItemContentFactory = (LazyLayoutItemContentFactory) objRememberedValue;
                    Object objRememberedValue2 = gapComposer2.rememberedValue();
                    if (objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new SubcomposeLayoutState(new SurfaceRequest.AnonymousClass1(lazyLayoutItemContentFactory));
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    final SubcomposeLayoutState subcomposeLayoutState = (SubcomposeLayoutState) objRememberedValue2;
                    final LazyLayoutPrefetchState lazyLayoutPrefetchState2 = lazyLayoutPrefetchState;
                    if (lazyLayoutPrefetchState2 != null) {
                        gapComposer2.startReplaceGroup(1743490539);
                        gapComposer2.startReplaceGroup(887527095);
                        final PrefetchScheduler prefetchScheduler = PrefetchScheduler_androidKt.RobolectricImpl;
                        if (prefetchScheduler != null) {
                            gapComposer2.startReplaceGroup(1345554384);
                        } else {
                            gapComposer2.startReplaceGroup(1345603457);
                            View view = (View) gapComposer2.consume(AndroidCompositionLocals_androidKt.LocalView);
                            boolean zChanged = gapComposer2.changed(view);
                            Object objRememberedValue3 = gapComposer2.rememberedValue();
                            if (zChanged || objRememberedValue3 == neverEqualPolicy) {
                                Object tag = view.getTag(R.id.compose_prefetch_scheduler);
                                objRememberedValue3 = tag instanceof PrefetchScheduler ? (PrefetchScheduler) tag : null;
                                if (objRememberedValue3 == null) {
                                    objRememberedValue3 = new AndroidPrefetchScheduler(view);
                                    view.setTag(R.id.compose_prefetch_scheduler, objRememberedValue3);
                                }
                                gapComposer2.updateRememberedValue(objRememberedValue3);
                            }
                            prefetchScheduler = (PrefetchScheduler) objRememberedValue3;
                        }
                        gapComposer2.end(false);
                        gapComposer2.end(false);
                        Object[] objArr = {lazyLayoutPrefetchState2, lazyLayoutItemContentFactory, subcomposeLayoutState, prefetchScheduler};
                        boolean zChanged2 = gapComposer2.changed(lazyLayoutPrefetchState2) | gapComposer2.changedInstance(lazyLayoutItemContentFactory) | gapComposer2.changedInstance(subcomposeLayoutState) | gapComposer2.changedInstance(prefetchScheduler);
                        Object objRememberedValue4 = gapComposer2.rememberedValue();
                        if (zChanged2 || objRememberedValue4 == neverEqualPolicy) {
                            objRememberedValue4 = new Function1() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj4) {
                                    DiskLruCache.Editor editor = new DiskLruCache.Editor(lazyLayoutItemContentFactory, subcomposeLayoutState, prefetchScheduler);
                                    LazyLayoutPrefetchState lazyLayoutPrefetchState3 = lazyLayoutPrefetchState2;
                                    lazyLayoutPrefetchState3.prefetchHandleProvider = editor;
                                    return new AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1(4, lazyLayoutPrefetchState3);
                                }
                            };
                            gapComposer2.updateRememberedValue(objRememberedValue4);
                        }
                        Function1 function1 = (Function1) objRememberedValue4;
                        Object[] objArrCopyOf = Arrays.copyOf(objArr, 4);
                        boolean zChanged3 = false;
                        for (Object obj4 : objArrCopyOf) {
                            zChanged3 |= gapComposer2.changed(obj4);
                        }
                        Object objRememberedValue5 = gapComposer2.rememberedValue();
                        if (zChanged3 || objRememberedValue5 == neverEqualPolicy) {
                            gapComposer2.updateRememberedValue(new DisposableEffectImpl(function1));
                        }
                        gapComposer2.end(false);
                    } else {
                        gapComposer2.startReplaceGroup(1744076749);
                        gapComposer2.end(false);
                    }
                    int i3 = LazyLayoutPrefetchStateKt.$r8$clinit;
                    Modifier modifier2 = modifier;
                    if (lazyLayoutPrefetchState2 != null && (modifierThen = modifier2.then(new TraversablePrefetchStateModifierElement(lazyLayoutPrefetchState2))) != null) {
                        modifier2 = modifierThen;
                    }
                    boolean zChanged4 = gapComposer2.changed(lazyLayoutItemContentFactory);
                    LazyListKt$rememberLazyListMeasurePolicy$1$1 lazyListKt$rememberLazyListMeasurePolicy$1$2 = lazyListKt$rememberLazyListMeasurePolicy$1$1;
                    boolean zChanged5 = zChanged4 | gapComposer2.changed(lazyListKt$rememberLazyListMeasurePolicy$1$2);
                    Object objRememberedValue6 = gapComposer2.rememberedValue();
                    if (zChanged5 || objRememberedValue6 == neverEqualPolicy) {
                        objRememberedValue6 = new TextKt$$ExternalSyntheticLambda2(5, lazyLayoutItemContentFactory, lazyListKt$rememberLazyListMeasurePolicy$1$2);
                        gapComposer2.updateRememberedValue(objRememberedValue6);
                    }
                    RulerKt.SubcomposeLayout(subcomposeLayoutState, modifier2, (Function2) objRememberedValue6, gapComposer2, 8);
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, 6);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2(modifier, lazyLayoutPrefetchState, lazyListKt$rememberLazyListMeasurePolicy$1$1, i) { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutKt$$ExternalSyntheticLambda1
                public final /* synthetic */ Modifier f$1;
                public final /* synthetic */ LazyLayoutPrefetchState f$2;
                public final /* synthetic */ LazyListKt$rememberLazyListMeasurePolicy$1$1 f$3;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                    LazyLayoutKt.LazyLayout(this.f$0, this.f$1, this.f$2, this.f$3, (GapComposer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void LazyLayoutPinnableItem(final Object obj, final int i, final LazyLayoutPinnedItemList lazyLayoutPinnedItemList, final ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, final int i2) {
        int i3;
        gapComposer.startRestartGroup(872548579);
        if ((i2 & 6) == 0) {
            i3 = (gapComposer.changedInstance(obj) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= gapComposer.changed(i) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= gapComposer.changedInstance(lazyLayoutPinnedItemList) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= gapComposer.changedInstance(composableLambdaImpl) ? 2048 : 1024;
        }
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 1171) != 1170)) {
            boolean zChanged = gapComposer.changed(obj) | gapComposer.changed(lazyLayoutPinnedItemList);
            Object objRememberedValue = gapComposer.rememberedValue();
            Object obj2 = Composer$Companion.Empty;
            if (zChanged || objRememberedValue == obj2) {
                objRememberedValue = new LazyLayoutPinnableItem(obj, lazyLayoutPinnedItemList);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            LazyLayoutPinnableItem lazyLayoutPinnableItem = (LazyLayoutPinnableItem) objRememberedValue;
            lazyLayoutPinnableItem.index = i;
            ParcelableSnapshotMutableState parcelableSnapshotMutableState = lazyLayoutPinnableItem._parentPinnableContainer$delegate;
            ProvidableCompositionLocal providableCompositionLocal = PinnableContainerKt.LocalPinnableContainer;
            LazyLayoutPinnableItem lazyLayoutPinnableItem2 = (LazyLayoutPinnableItem) gapComposer.consume(providableCompositionLocal);
            Snapshot currentThreadSnapshot = SnapshotId_jvmKt.getCurrentThreadSnapshot();
            Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot snapshotMakeCurrentNonObservable = SnapshotId_jvmKt.makeCurrentNonObservable(currentThreadSnapshot);
            try {
                if (lazyLayoutPinnableItem2 != ((LazyLayoutPinnableItem) parcelableSnapshotMutableState.getValue())) {
                    parcelableSnapshotMutableState.setValue(lazyLayoutPinnableItem2);
                    if (lazyLayoutPinnableItem.pinsCount > 0) {
                        LazyLayoutPinnableItem lazyLayoutPinnableItem3 = lazyLayoutPinnableItem.parentHandle;
                        if (lazyLayoutPinnableItem3 != null) {
                            lazyLayoutPinnableItem3.release();
                        }
                        if (lazyLayoutPinnableItem2 != null) {
                            lazyLayoutPinnableItem2.pin();
                        } else {
                            lazyLayoutPinnableItem2 = null;
                        }
                        lazyLayoutPinnableItem.parentHandle = lazyLayoutPinnableItem2;
                    }
                }
                Unit unit = Unit.INSTANCE;
                SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                boolean zChanged2 = gapComposer.changed(lazyLayoutPinnableItem);
                Object objRememberedValue2 = gapComposer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == obj2) {
                    objRememberedValue2 = new Recomposer$$ExternalSyntheticLambda0(11, lazyLayoutPinnableItem);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                Stack.DisposableEffect(lazyLayoutPinnableItem, (Function1) objRememberedValue2, gapComposer);
                Stack.CompositionLocalProvider(providableCompositionLocal.defaultProvidedValue$runtime(lazyLayoutPinnableItem), composableLambdaImpl, gapComposer, ((i3 >> 6) & 112) | 8);
            } catch (Throwable th) {
                SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                throw th;
            }
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItemKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    ((Integer) obj4).getClass();
                    LazyLayoutKt.LazyLayoutPinnableItem(obj, i, lazyLayoutPinnedItemList, composableLambdaImpl, (GapComposer) obj3, Stack.updateChangedFlags(i2 | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void LazySaveableStateHolderProvider(ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        gapComposer.startRestartGroup(-709502251);
        int i2 = 2;
        int i3 = 1;
        if (gapComposer.shouldExecute(i & 1, (i & 3) != 2)) {
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = SaveableStateRegistryKt.LocalSaveableStateRegistry;
            SaveableStateRegistry saveableStateRegistry = (SaveableStateRegistry) gapComposer.consume(staticProvidableCompositionLocal);
            SaveableStateHolderImpl saveableStateHolderImplRememberSaveableStateHolder = SaverKt.rememberSaveableStateHolder(gapComposer);
            Object[] objArr = {saveableStateRegistry};
            RequestService requestService = new RequestService(i2, new SaversKt$$ExternalSyntheticLambda0(3), new BackHandlerKt$$ExternalSyntheticLambda2(24, saveableStateRegistry, saveableStateHolderImplRememberSaveableStateHolder));
            boolean zChangedInstance = gapComposer.changedInstance(saveableStateRegistry) | gapComposer.changedInstance(saveableStateHolderImplRememberSaveableStateHolder);
            Object objRememberedValue = gapComposer.rememberedValue();
            int i4 = 6;
            if (zChangedInstance || objRememberedValue == Composer$Companion.Empty) {
                objRememberedValue = new Recomposer$$ExternalSyntheticLambda6(i4, saveableStateRegistry, saveableStateHolderImplRememberSaveableStateHolder);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            LazySaveableStateHolder lazySaveableStateHolder = (LazySaveableStateHolder) SaverKt.rememberSaveable(objArr, requestService, (Function0) objRememberedValue, gapComposer, 0);
            Stack.CompositionLocalProvider(staticProvidableCompositionLocal.defaultProvidedValue$runtime(lazySaveableStateHolder), Thread_jvmKt.rememberComposableLambda(-412824043, new TextKt$$ExternalSyntheticLambda2(composableLambdaImpl, lazySaveableStateHolder, i4), gapComposer), gapComposer, 56);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new FlowLayoutKt$$ExternalSyntheticLambda0(composableLambdaImpl, i, i3);
        }
    }

    /* JADX INFO: renamed from: SkippableItem-JVlU9Rs, reason: not valid java name */
    public static final void m153SkippableItemJVlU9Rs(LazyListItemProviderImpl lazyListItemProviderImpl, Object obj, int i, Object obj2, GapComposer gapComposer, int i2) {
        gapComposer.startRestartGroup(1439843069);
        int i3 = (gapComposer.changed(lazyListItemProviderImpl) ? 4 : 2) | i2 | (gapComposer.changed(obj) ? 32 : 16) | (gapComposer.changed(i) ? 256 : 128) | (gapComposer.changed(obj2) ? 2048 : 1024);
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 1171) != 1170)) {
            ((SaveableStateHolder) obj).SaveableStateProvider(obj2, Thread_jvmKt.rememberComposableLambda(980966366, new LazyListItemProviderImpl$$ExternalSyntheticLambda1(i, lazyListItemProviderImpl, obj2), gapComposer), gapComposer, 48);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new SnackbarHostKt$$ExternalSyntheticLambda0(lazyListItemProviderImpl, obj, i, obj2, i2);
        }
    }

    public static final int access$binarySearch(int i, MutableVector mutableVector) {
        int i2 = mutableVector.size - 1;
        int i3 = 0;
        while (i3 < i2) {
            int i4 = ((i2 - i3) / 2) + i3;
            Object[] objArr = mutableVector.content;
            int i5 = ((IntervalList$Interval) objArr[i4]).startIndex;
            if (i5 != i) {
                if (i5 < i) {
                    i3 = i4 + 1;
                    if (i < ((IntervalList$Interval) objArr[i3]).startIndex) {
                    }
                } else {
                    i2 = i4 - 1;
                }
            }
            return i4;
        }
        return i3;
    }

    public static final int findIndexByKey(int i, LazyListItemProviderImpl lazyListItemProviderImpl, Object obj) {
        int index;
        return (obj == null || lazyListItemProviderImpl.getItemCount() == 0 || (i < lazyListItemProviderImpl.getItemCount() && obj.equals(lazyListItemProviderImpl.getKey(i))) || (index = lazyListItemProviderImpl.keyIndexMap.getIndex(obj)) == -1) ? i : index;
    }

    public static final Modifier lazyLayoutBeyondBoundsModifier(LazyListBeyondBoundsState lazyListBeyondBoundsState, PreviewView.AnonymousClass1 anonymousClass1, boolean z, Orientation orientation) {
        return new LazyLayoutBeyondBoundsModifierElement(lazyListBeyondBoundsState, anonymousClass1, z, orientation);
    }

    public static final Modifier lazyLayoutSemantics(Modifier modifier, KProperty0 kProperty0, LazyLayoutSemanticStateKt$LazyLayoutSemanticState$1 lazyLayoutSemanticStateKt$LazyLayoutSemanticState$1, Orientation orientation, boolean z, boolean z2) {
        return modifier.then(new LazyLayoutSemanticsModifier(kProperty0, lazyLayoutSemanticStateKt$LazyLayoutSemanticState$1, orientation, z, z2));
    }
}
