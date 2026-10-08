package androidx.compose.runtime;

import androidx.compose.runtime.GapComposer.CompositionContextImpl;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.composer.gapbuffer.GapAnchor;
import androidx.compose.runtime.composer.gapbuffer.SlotReader;
import androidx.compose.runtime.composer.gapbuffer.SlotWriter;
import androidx.compose.runtime.composer.gapbuffer.changelist.Operation;
import androidx.compose.runtime.composer.gapbuffer.changelist.Operations;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.node.LayoutNode$$ExternalSyntheticLambda0;
import androidx.core.view.MenuHostHelper;
import androidx.navigation.compose.NavHostKt$NavHost$28$1;
import coil.RealImageLoader$executeMain$result$1;
import com.github.kr328.clash.FilesActivity$$ExternalSyntheticLambda16;
import com.google.android.gms.internal.mlkit_vision_barcode.zzsi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.SafeFlow;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class Stack {
    public static final Object PendingApplyNoModifications = new Object();
    public static final DisposableEffectScope InternalDisposableEffectScope = new DisposableEffectScope();
    public static final LayoutNode$$ExternalSyntheticLambda0 InvalidationLocationAscending = new LayoutNode$$ExternalSyntheticLambda0(5);

    /* JADX WARN: Code duplicated, block: B:26:0x009d  */
    /* JADX WARN: Code duplicated, block: B:29:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:31:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void CompositionLocalProvider(ProvidedValue[] providedValueArr, Function2 function2, GapComposer gapComposer, int i) {
        PersistentCompositionLocalMap persistentCompositionLocalMapUpdateProviderMapGroup;
        boolean z;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        gapComposer.startRestartGroup(415205898);
        IntStack intStack = gapComposer.providersInvalidStack;
        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
        gapComposer.startGroup(201, ComposerKt.provider);
        if (gapComposer.inserting) {
            persistentCompositionLocalMapUpdateProviderMapGroup = gapComposer.updateProviderMapGroup(persistentCompositionLocalMapCurrentCompositionLocalScope, updateCompositionMap(providedValueArr, persistentCompositionLocalMapCurrentCompositionLocalScope, PersistentCompositionLocalHashMap.Empty));
            gapComposer.writerHasAProvider = true;
        } else {
            SlotReader slotReader = gapComposer.reader;
            PersistentCompositionLocalMap persistentCompositionLocalMap = (PersistentCompositionLocalMap) slotReader.groupGet(slotReader.currentGroup, 0);
            SlotReader slotReader2 = gapComposer.reader;
            PersistentCompositionLocalMap persistentCompositionLocalMap2 = (PersistentCompositionLocalMap) slotReader2.groupGet(slotReader2.currentGroup, 1);
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMapUpdateCompositionMap = updateCompositionMap(providedValueArr, persistentCompositionLocalMapCurrentCompositionLocalScope, persistentCompositionLocalMap2);
            if (!gapComposer.getSkipping() || gapComposer.reusing || !persistentCompositionLocalMap2.equals(persistentCompositionLocalHashMapUpdateCompositionMap)) {
                persistentCompositionLocalMapUpdateProviderMapGroup = gapComposer.updateProviderMapGroup(persistentCompositionLocalMapCurrentCompositionLocalScope, persistentCompositionLocalHashMapUpdateCompositionMap);
                if (gapComposer.reusing || !Intrinsics.areEqual(persistentCompositionLocalMapUpdateProviderMapGroup, persistentCompositionLocalMap)) {
                    z = true;
                }
                if (z && !gapComposer.inserting) {
                    gapComposer.recordProviderUpdate(persistentCompositionLocalMapUpdateProviderMapGroup);
                }
                intStack.push(gapComposer.providersInvalid ? 1 : 0);
                gapComposer.providersInvalid = z;
                gapComposer.providerCache = persistentCompositionLocalMapUpdateProviderMapGroup;
                gapComposer.m289startAzEfcrM(202, 0, ComposerKt.compositionLocalMap, persistentCompositionLocalMapUpdateProviderMapGroup);
                function2.invoke(gapComposer, Integer.valueOf((i >> 3) & 14));
                gapComposer.end(false);
                gapComposer.end(false);
                gapComposer.providersInvalid = intStack.pop() != 0;
                gapComposer.providerCache = null;
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new FilesActivity$$ExternalSyntheticLambda16(i, 3, providedValueArr, function2);
                }
            }
            gapComposer.groupNodeCount = gapComposer.reader.skipGroup() + gapComposer.groupNodeCount;
            persistentCompositionLocalMapUpdateProviderMapGroup = persistentCompositionLocalMap;
        }
        z = false;
        if (z) {
            gapComposer.recordProviderUpdate(persistentCompositionLocalMapUpdateProviderMapGroup);
        }
        intStack.push(gapComposer.providersInvalid ? 1 : 0);
        gapComposer.providersInvalid = z;
        gapComposer.providerCache = persistentCompositionLocalMapUpdateProviderMapGroup;
        gapComposer.m289startAzEfcrM(202, 0, ComposerKt.compositionLocalMap, persistentCompositionLocalMapUpdateProviderMapGroup);
        function2.invoke(gapComposer, Integer.valueOf((i >> 3) & 14));
        gapComposer.end(false);
        gapComposer.end(false);
        gapComposer.providersInvalid = intStack.pop() != 0;
        gapComposer.providerCache = null;
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new FilesActivity$$ExternalSyntheticLambda16(i, 3, providedValueArr, function2);
        }
    }

    public static final void DisposableEffect(Object obj, Function1 function1, GapComposer gapComposer) {
        boolean zChanged = gapComposer.changed(obj);
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue == Composer$Companion.Empty) {
            objRememberedValue = new DisposableEffectImpl(function1);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
    }

    public static final void LaunchedEffect(GapComposer gapComposer, Object obj, Function2 function2) {
        CoroutineContext coroutineContext = gapComposer.applyCoroutineContext;
        boolean zChanged = gapComposer.changed(obj);
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue == Composer$Companion.Empty) {
            objRememberedValue = new LaunchedEffectImpl(coroutineContext, function2);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
    }

    public static final void SideEffect(Function0 function0, GapComposer gapComposer) {
        Operations operations = gapComposer.changeListWriter.changeList.operations;
        operations.pushOp(Operation.SideEffect.INSTANCE);
        zzsi.m814setObjectsGr0YRc(operations, 0, function0);
    }

    public static final void access$removeRange(List list, int i, int i2) {
        int iFindLocation = findLocation(i, list);
        if (iFindLocation < 0) {
            iFindLocation = -(iFindLocation + 1);
        }
        while (iFindLocation < list.size() && ((Invalidation) list.get(iFindLocation)).location < i2) {
        }
    }

    public static void adoptAnchoredScopes$runtime(SlotWriter slotWriter, List list, CompositionImpl compositionImpl) {
        if (list.isEmpty()) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int iAnchorIndex = slotWriter.anchorIndex((GapAnchor) list.get(i));
            int iSlotIndex = slotWriter.slotIndex(slotWriter.groups, slotWriter.groupIndexToAddress(iAnchorIndex));
            Object obj = iSlotIndex < slotWriter.dataIndex(slotWriter.groups, slotWriter.groupIndexToAddress(iAnchorIndex + 1)) ? slotWriter.slots[slotWriter.dataIndexToDataAddress(iSlotIndex)] : Composer$Companion.Empty;
            RecomposeScopeImpl recomposeScopeImpl = obj instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) obj : null;
            if (recomposeScopeImpl != null) {
                recomposeScopeImpl.owner = compositionImpl;
            }
        }
    }

    public static final MutableState collectAsState(StateFlow stateFlow, GapComposer gapComposer, int i) {
        return collectAsState(stateFlow, stateFlow.getValue(), EmptyCoroutineContext.INSTANCE, gapComposer, (i & 14) | ((i << 3) & 896), 0);
    }

    public static final void collectNodesFrom$lambda$0$collectFromGroup(SlotReader slotReader, ArrayList arrayList, int i) {
        boolean zIsNode = slotReader.isNode(i);
        int[] iArr = slotReader.groups;
        if (zIsNode) {
            arrayList.add(slotReader.node(i));
            return;
        }
        int i2 = iArr[(i * 5) + 3] + i;
        for (int i3 = i + 1; i3 < i2; i3 += iArr[(i3 * 5) + 3]) {
            collectNodesFrom$lambda$0$collectFromGroup(slotReader, arrayList, i3);
        }
    }

    public static DynamicProvidableCompositionLocal compositionLocalOf$default(Function0 function0) {
        return new DynamicProvidableCompositionLocal(function0);
    }

    public static final CoroutineScope createCompositionCoroutineScope(GapComposer gapComposer) {
        return new RememberedCoroutineScope(gapComposer.applyCoroutineContext);
    }

    public static final MutableVector derivedStateObservers() {
        MenuHostHelper menuHostHelper = SnapshotStateKt__DerivedStateKt.derivedStateObservers;
        MutableVector mutableVector = (MutableVector) menuHostHelper.get();
        if (mutableVector != null) {
            return mutableVector;
        }
        MutableVector mutableVector2 = new MutableVector(new GapComposer$derivedStateObserver$1[0]);
        menuHostHelper.set(mutableVector2);
        return mutableVector2;
    }

    public static final DerivedSnapshotState derivedStateOf(Function0 function0) {
        MenuHostHelper menuHostHelper = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
        return new DerivedSnapshotState(function0, null);
    }

    public static final int findLocation(int i, List list) {
        int size = list.size() - 1;
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) >>> 1;
            int iCompare = Intrinsics.compare(((Invalidation) list.get(i3)).location, i);
            if (iCompare < 0) {
                i2 = i3 + 1;
            } else {
                if (iCompare <= 0) {
                    return i3;
                }
                size = i3 - 1;
            }
        }
        return -(i2 + 1);
    }

    public static final BroadcastFrameClock getMonotonicFrameClock(CoroutineContext coroutineContext) {
        BroadcastFrameClock broadcastFrameClock = (BroadcastFrameClock) coroutineContext.get(NeverEqualPolicy.$$INSTANCE);
        if (broadcastFrameClock != null) {
            return broadcastFrameClock;
        }
        throw new IllegalStateException("A MonotonicFrameClock is not available in this CoroutineContext. Callers should supply an appropriate MonotonicFrameClock using withContext.");
    }

    /* JADX INFO: renamed from: init-impl, reason: not valid java name */
    public static final void m291initimpl(GapComposer gapComposer, Integer num, Function2 function2) {
        if (gapComposer.inserting) {
            gapComposer.apply(num, function2);
        }
    }

    /* JADX INFO: renamed from: isNotEmpty-impl, reason: not valid java name */
    public static final boolean m292isNotEmptyimpl(ArrayList arrayList) {
        return !arrayList.isEmpty();
    }

    public static ParcelableSnapshotMutableState mutableStateOf$default(Object obj) {
        return new ParcelableSnapshotMutableState(obj, NeverEqualPolicy.INSTANCE$3);
    }

    /* JADX INFO: renamed from: pop-impl, reason: not valid java name */
    public static final Object m293popimpl(ArrayList arrayList) {
        return arrayList.remove(arrayList.size() - 1);
    }

    public static final Object read(PersistentCompositionLocalMap persistentCompositionLocalMap, ProvidableCompositionLocal providableCompositionLocal) {
        PersistentCompositionLocalHashMap persistentCompositionLocalHashMap = (PersistentCompositionLocalHashMap) persistentCompositionLocalMap;
        Object defaultValueHolder$runtime = persistentCompositionLocalHashMap.get(providableCompositionLocal);
        if (defaultValueHolder$runtime == null) {
            defaultValueHolder$runtime = providableCompositionLocal.getDefaultValueHolder$runtime();
        }
        return ((ValueHolder) defaultValueHolder$runtime).readValue(persistentCompositionLocalHashMap);
    }

    /* JADX INFO: renamed from: reconcile-impl, reason: not valid java name */
    public static final void m294reconcileimpl(GapComposer gapComposer, Function1 function1) {
        gapComposer.apply(Unit.INSTANCE, new Updater$$ExternalSyntheticLambda0(0, function1));
    }

    public static final GapComposer.CompositionContextImpl rememberCompositionContext(GapComposer gapComposer) {
        GapComposer gapComposer2;
        gapComposer.startGroup(206, ComposerKt.reference);
        if (gapComposer.inserting) {
            SlotWriter.markGroup$default(gapComposer.writer);
        }
        Object objNextSlot = gapComposer.nextSlot();
        RememberObserverHolder reusableGapRememberObserverHolder = objNextSlot instanceof RememberObserverHolder ? (RememberObserverHolder) objNextSlot : null;
        if (reusableGapRememberObserverHolder == null) {
            gapComposer2 = gapComposer;
            reusableGapRememberObserverHolder = new ReusableGapRememberObserverHolder(new GapComposer.CompositionContextHolder(gapComposer2.new CompositionContextImpl(gapComposer.compositeKeyHashCode, gapComposer.forceRecomposeScopes, gapComposer.sourceMarkersEnabled, gapComposer.composition.observerHolder)), -1);
            gapComposer2.updateValue(reusableGapRememberObserverHolder);
        } else {
            gapComposer2 = gapComposer;
        }
        GapComposer.CompositionContextImpl compositionContextImpl = ((GapComposer.CompositionContextHolder) reusableGapRememberObserverHolder.getWrapped()).ref;
        compositionContextImpl.compositionLocalScope$delegate.setValue(gapComposer2.currentCompositionLocalScope());
        gapComposer2.end(false);
        return compositionContextImpl;
    }

    public static final MutableState rememberUpdatedState(Object obj, GapComposer gapComposer) {
        Object objRememberedValue = gapComposer.rememberedValue();
        if (objRememberedValue == Composer$Companion.Empty) {
            objRememberedValue = mutableStateOf$default(obj);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        MutableState mutableState = (MutableState) objRememberedValue;
        mutableState.setValue(obj);
        return mutableState;
    }

    public static final void removeData(SlotWriter slotWriter, int i, Object obj) {
        int iDataIndexToDataAddress = slotWriter.dataIndexToDataAddress(i);
        Object[] objArr = slotWriter.slots;
        Object obj2 = objArr[iDataIndexToDataAddress];
        objArr[iDataIndexToDataAddress] = Composer$Companion.Empty;
        if (obj == obj2) {
            return;
        }
        ComposerKt.composeImmediateRuntimeError("Slot table is out of sync (expected " + obj + ", got " + obj2 + ')');
    }

    /* JADX INFO: renamed from: set-impl, reason: not valid java name */
    public static final void m295setimpl(GapComposer gapComposer, Object obj, Function2 function2) {
        if (gapComposer.inserting || !Intrinsics.areEqual(gapComposer.rememberedValue(), obj)) {
            gapComposer.updateRememberedValue(obj);
            gapComposer.apply(obj, function2);
        }
    }

    public static final SafeFlow snapshotFlow(Function0 function0) {
        return new SafeFlow(new RealImageLoader$executeMain$result$1(function0, (Continuation) null, 8));
    }

    public static final StaticProvidableCompositionLocal staticCompositionLocalOf(Function0 function0) {
        return new StaticProvidableCompositionLocal(function0);
    }

    public static final int updateChangedFlags(int i) {
        int i2 = 306783378 & i;
        int i3 = 613566756 & i;
        return (i & (-920350135)) | (i3 >> 1) | i2 | ((i2 << 1) & i3);
    }

    public static final PersistentCompositionLocalHashMap updateCompositionMap(ProvidedValue[] providedValueArr, PersistentCompositionLocalMap persistentCompositionLocalMap, PersistentCompositionLocalMap persistentCompositionLocalMap2) {
        PersistentCompositionLocalHashMap.Builder builder = PersistentCompositionLocalHashMap.Empty.builder();
        for (ProvidedValue providedValue : providedValueArr) {
            ProvidableCompositionLocal providableCompositionLocal = (ProvidableCompositionLocal) providedValue.compositionLocal;
            if (providedValue.canOverride || !((PersistentCompositionLocalHashMap) persistentCompositionLocalMap).containsKey(providableCompositionLocal)) {
                builder.put(providableCompositionLocal, providableCompositionLocal.updatedStateOf$runtime(providedValue, (ValueHolder) ((PersistentCompositionLocalHashMap) persistentCompositionLocalMap2).get(providableCompositionLocal)));
            }
        }
        return builder.build();
    }

    public static final MutableState collectAsState(Flow flow, Object obj, CoroutineContext coroutineContext, GapComposer gapComposer, int i, int i2) {
        if ((i2 & 2) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        boolean zChangedInstance = gapComposer.changedInstance(coroutineContext) | gapComposer.changedInstance(flow);
        Object objRememberedValue = gapComposer.rememberedValue();
        Continuation continuation = null;
        Object obj2 = Composer$Companion.Empty;
        if (zChangedInstance || objRememberedValue == obj2) {
            objRememberedValue = new NavHostKt$NavHost$28$1(coroutineContext, flow, continuation, 22);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        Function2 function2 = (Function2) objRememberedValue;
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (objRememberedValue2 == obj2) {
            objRememberedValue2 = mutableStateOf$default(obj);
            gapComposer.updateRememberedValue(objRememberedValue2);
        }
        MutableState mutableState = (MutableState) objRememberedValue2;
        boolean zChangedInstance2 = gapComposer.changedInstance(function2);
        Object objRememberedValue3 = gapComposer.rememberedValue();
        if (zChangedInstance2 || objRememberedValue3 == obj2) {
            objRememberedValue3 = new SnapshotStateKt__ProduceStateKt$produceState$1$1(function2, mutableState, continuation, 1);
            gapComposer.updateRememberedValue(objRememberedValue3);
        }
        LaunchedEffect(flow, coroutineContext, (Function2) objRememberedValue3, gapComposer);
        return mutableState;
    }

    public static final void DisposableEffect(Object obj, Object obj2, Function1 function1, GapComposer gapComposer) {
        boolean zChanged = gapComposer.changed(obj) | gapComposer.changed(obj2);
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue == Composer$Companion.Empty) {
            objRememberedValue = new DisposableEffectImpl(function1);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
    }

    public static final void LaunchedEffect(Object obj, Object obj2, Function2 function2, GapComposer gapComposer) {
        CoroutineContext coroutineContext = gapComposer.applyCoroutineContext;
        boolean zChanged = gapComposer.changed(obj) | gapComposer.changed(obj2);
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue == Composer$Companion.Empty) {
            objRememberedValue = new LaunchedEffectImpl(coroutineContext, function2);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:49:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:51:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void CompositionLocalProvider(ProvidedValue providedValue, Function2 function2, GapComposer gapComposer, int i) {
        boolean z;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        gapComposer.startRestartGroup(-149765515);
        IntStack intStack = gapComposer.providersInvalidStack;
        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
        gapComposer.startGroup(201, ComposerKt.provider);
        Object objRememberedValue = gapComposer.rememberedValue();
        ValueHolder valueHolder = Intrinsics.areEqual(objRememberedValue, Composer$Companion.Empty) ? null : (ValueHolder) objRememberedValue;
        ProvidableCompositionLocal providableCompositionLocal = (ProvidableCompositionLocal) providedValue.compositionLocal;
        ValueHolder valueHolderUpdatedStateOf$runtime = providableCompositionLocal.updatedStateOf$runtime(providedValue, valueHolder);
        boolean zEquals = valueHolderUpdatedStateOf$runtime.equals(valueHolder);
        if (!zEquals) {
            gapComposer.updateRememberedValue(valueHolderUpdatedStateOf$runtime);
        }
        if (gapComposer.inserting) {
            if (providedValue.canOverride || !((PersistentCompositionLocalHashMap) persistentCompositionLocalMapCurrentCompositionLocalScope).containsKey(providableCompositionLocal)) {
                persistentCompositionLocalMapCurrentCompositionLocalScope = ((PersistentCompositionLocalHashMap) persistentCompositionLocalMapCurrentCompositionLocalScope).putValue(providableCompositionLocal, valueHolderUpdatedStateOf$runtime);
            }
            gapComposer.writerHasAProvider = true;
        } else {
            SlotReader slotReader = gapComposer.reader;
            PersistentCompositionLocalMap persistentCompositionLocalMap = (PersistentCompositionLocalMap) slotReader.aux(slotReader.groups, slotReader.currentGroup);
            if ((gapComposer.getSkipping() && zEquals) || (!providedValue.canOverride && ((PersistentCompositionLocalHashMap) persistentCompositionLocalMapCurrentCompositionLocalScope).containsKey(providableCompositionLocal))) {
                if ((zEquals && !gapComposer.providersInvalid) || !gapComposer.providersInvalid) {
                    persistentCompositionLocalMapCurrentCompositionLocalScope = persistentCompositionLocalMap;
                }
            } else {
                persistentCompositionLocalMapCurrentCompositionLocalScope = ((PersistentCompositionLocalHashMap) persistentCompositionLocalMapCurrentCompositionLocalScope).putValue(providableCompositionLocal, valueHolderUpdatedStateOf$runtime);
            }
            if (gapComposer.reusing || persistentCompositionLocalMap != persistentCompositionLocalMapCurrentCompositionLocalScope) {
                z = true;
            }
            if (z && !gapComposer.inserting) {
                gapComposer.recordProviderUpdate(persistentCompositionLocalMapCurrentCompositionLocalScope);
            }
            intStack.push(gapComposer.providersInvalid ? 1 : 0);
            gapComposer.providersInvalid = z;
            gapComposer.providerCache = persistentCompositionLocalMapCurrentCompositionLocalScope;
            gapComposer.m289startAzEfcrM(202, 0, ComposerKt.compositionLocalMap, persistentCompositionLocalMapCurrentCompositionLocalScope);
            function2.invoke(gapComposer, Integer.valueOf((i >> 3) & 14));
            gapComposer.end(false);
            gapComposer.end(false);
            gapComposer.providersInvalid = intStack.pop() != 0;
            gapComposer.providerCache = null;
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new FilesActivity$$ExternalSyntheticLambda16(i, 2, providedValue, function2);
            }
        }
        z = false;
        if (z) {
            gapComposer.recordProviderUpdate(persistentCompositionLocalMapCurrentCompositionLocalScope);
        }
        intStack.push(gapComposer.providersInvalid ? 1 : 0);
        gapComposer.providersInvalid = z;
        gapComposer.providerCache = persistentCompositionLocalMapCurrentCompositionLocalScope;
        gapComposer.m289startAzEfcrM(202, 0, ComposerKt.compositionLocalMap, persistentCompositionLocalMapCurrentCompositionLocalScope);
        function2.invoke(gapComposer, Integer.valueOf((i >> 3) & 14));
        gapComposer.end(false);
        gapComposer.end(false);
        gapComposer.providersInvalid = intStack.pop() != 0;
        gapComposer.providerCache = null;
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new FilesActivity$$ExternalSyntheticLambda16(i, 2, providedValue, function2);
        }
    }
}
