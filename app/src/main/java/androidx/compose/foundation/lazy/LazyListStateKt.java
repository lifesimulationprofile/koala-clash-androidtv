package androidx.compose.foundation.lazy;

import androidx.activity.ImmLeaksCleaner$$ExternalSyntheticLambda0;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.DensityKt;
import coil.request.RequestService;
import kotlin.collections.EmptyList;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class LazyListStateKt {
    public static final LazyListMeasureResult EmptyLazyListMeasureResult = new LazyListMeasureResult(null, 0, false, 0.0f, new LazyListStateKt$EmptyLazyListMeasureResult$1(), 0.0f, false, JobKt.CoroutineScope(EmptyCoroutineContext.INSTANCE), DensityKt.Density$default(), ConstraintsKt.Constraints$default(0, 0, 0, 0, 15), EmptyList.INSTANCE, 0, 0, 0, false, Orientation.Vertical, 0, 0);

    public static final LazyListState rememberLazyListState(GapComposer gapComposer) {
        Object[] objArr = new Object[0];
        RequestService requestService = LazyListState.Saver;
        boolean zChanged = gapComposer.changed(0) | gapComposer.changed(0);
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue == Composer$Companion.Empty) {
            objRememberedValue = new ImmLeaksCleaner$$ExternalSyntheticLambda0(11);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        return (LazyListState) SaverKt.rememberSaveable(objArr, requestService, (Function0) objRememberedValue, gapComposer, 0);
    }
}
