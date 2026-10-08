package androidx.compose.foundation.lazy;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.lazy.layout.DummyHandle;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.graphics.GraphicsContext;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty0;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LazyListKt$rememberLazyListMeasurePolicy$1$1 {
    public final /* synthetic */ PaddingValuesImpl $contentPadding;
    public final /* synthetic */ CoroutineScope $coroutineScope;
    public final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
    public final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
    public final /* synthetic */ boolean $isVertical;
    public final /* synthetic */ Function0 $itemProviderLambda;
    public final /* synthetic */ boolean $reverseLayout;
    public final /* synthetic */ LazyListState $state;
    public final /* synthetic */ DummyHandle $stickyItemsPlacement;
    public final /* synthetic */ BiasAlignment.Vertical $verticalAlignment;
    public final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    public LazyListKt$rememberLazyListMeasurePolicy$1$1(LazyListState lazyListState, boolean z, PaddingValuesImpl paddingValuesImpl, boolean z2, KProperty0 kProperty0, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, CoroutineScope coroutineScope, GraphicsContext graphicsContext, DummyHandle dummyHandle, Alignment.Horizontal horizontal2, BiasAlignment.Vertical vertical2) {
        this.$state = lazyListState;
        this.$isVertical = z;
        this.$contentPadding = paddingValuesImpl;
        this.$reverseLayout = z2;
        this.$itemProviderLambda = kProperty0;
        this.$verticalArrangement = vertical;
        this.$horizontalArrangement = horizontal;
        this.$coroutineScope = coroutineScope;
        this.$stickyItemsPlacement = dummyHandle;
        this.$horizontalAlignment = horizontal2;
        this.$verticalAlignment = vertical2;
    }
}
