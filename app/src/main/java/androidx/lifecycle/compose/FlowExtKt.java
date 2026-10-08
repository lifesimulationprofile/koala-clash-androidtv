package androidx.lifecycle.compose;

import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.LaunchedEffectImpl;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__ProduceStateKt$produceState$1$1;
import androidx.compose.runtime.Stack;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import coil.RealImageLoader$executeMain$result$1;
import java.util.Arrays;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class FlowExtKt {
    public static final MutableState collectAsStateWithLifecycle(StateFlow stateFlow, GapComposer gapComposer) {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) gapComposer.consume(LocalLifecycleOwnerKt.LocalLifecycleOwner);
        Object value = stateFlow.getValue();
        Object lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.STARTED;
        Object obj = EmptyCoroutineContext.INSTANCE;
        Object[] objArr = {stateFlow, lifecycle, state, obj};
        boolean zChangedInstance = gapComposer.changedInstance(lifecycle) | gapComposer.changed(state.ordinal()) | gapComposer.changedInstance(obj) | gapComposer.changedInstance(stateFlow);
        Object objRememberedValue = gapComposer.rememberedValue();
        Object obj2 = Composer$Companion.Empty;
        if (zChangedInstance || objRememberedValue == obj2) {
            Object realImageLoader$executeMain$result$1 = new RealImageLoader$executeMain$result$1(lifecycle, state, obj, stateFlow, null, 9);
            gapComposer.updateRememberedValue(realImageLoader$executeMain$result$1);
            objRememberedValue = realImageLoader$executeMain$result$1;
        }
        Function2 function2 = (Function2) objRememberedValue;
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (objRememberedValue2 == obj2) {
            objRememberedValue2 = Stack.mutableStateOf$default(value);
            gapComposer.updateRememberedValue(objRememberedValue2);
        }
        MutableState mutableState = (MutableState) objRememberedValue2;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, 4);
        boolean zChangedInstance2 = gapComposer.changedInstance(function2);
        Object objRememberedValue3 = gapComposer.rememberedValue();
        if (zChangedInstance2 || objRememberedValue3 == obj2) {
            objRememberedValue3 = new SnapshotStateKt__ProduceStateKt$produceState$1$1(function2, mutableState, null, 2);
            gapComposer.updateRememberedValue(objRememberedValue3);
        }
        Function2 function3 = (Function2) objRememberedValue3;
        CoroutineContext coroutineContext = gapComposer.applyCoroutineContext;
        boolean zChanged = false;
        for (Object obj3 : Arrays.copyOf(objArrCopyOf, objArrCopyOf.length)) {
            zChanged |= gapComposer.changed(obj3);
        }
        Object objRememberedValue4 = gapComposer.rememberedValue();
        if (!zChanged && objRememberedValue4 != obj2) {
            return mutableState;
        }
        gapComposer.updateRememberedValue(new LaunchedEffectImpl(coroutineContext, function3));
        return mutableState;
    }
}
