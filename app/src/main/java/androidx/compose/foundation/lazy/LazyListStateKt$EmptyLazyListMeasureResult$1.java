package androidx.compose.foundation.lazy;

import androidx.compose.ui.layout.MeasureResult;
import java.util.Map;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LazyListStateKt$EmptyLazyListMeasureResult$1 implements MeasureResult {
    @Override // androidx.compose.ui.layout.MeasureResult
    public final Map getAlignmentLines() {
        return EmptyMap.INSTANCE;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public final int getHeight() {
        return 0;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public final /* synthetic */ Function1 getRulers() {
        return null;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public final int getWidth() {
        return 0;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public final void placeChildren() {
    }
}
