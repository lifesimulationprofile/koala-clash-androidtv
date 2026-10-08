package androidx.compose.material3;

import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.DerivedSize;
import androidx.compose.ui.platform.LazyWindowInfo;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class TooltipDefaults {
    public static final float plainTooltipMaxWidth;

    static {
        DpKt.m706DpSizeYgX7TsA(16, 8);
        plainTooltipMaxWidth = 200;
    }

    /* JADX INFO: renamed from: rememberTooltipPositionProvider-Hu5FAss, reason: not valid java name */
    public static TooltipPositionProviderImpl m276rememberTooltipPositionProviderHu5FAss(GapComposer gapComposer) {
        DerivedSize derivedSize;
        int iMo86roundToPx0680j_4 = ((Density) gapComposer.consume(CompositionLocalsKt.LocalDensity)).mo86roundToPx0680j_4(TooltipKt.SpacingBetweenTooltipAndAnchor);
        LazyWindowInfo lazyWindowInfo = (LazyWindowInfo) ((WindowInfo) gapComposer.consume(CompositionLocalsKt.LocalWindowInfo));
        if (lazyWindowInfo._containerSize == null) {
            Function0 function0 = lazyWindowInfo.onInitializeContainerSize;
            if (function0 == null || (derivedSize = (DerivedSize) function0.invoke()) == null) {
                derivedSize = DerivedSize.Zero;
            }
            lazyWindowInfo._containerSize = Stack.mutableStateOf$default(derivedSize);
            lazyWindowInfo.onInitializeContainerSize = null;
        }
        long j = ((DerivedSize) lazyWindowInfo._containerSize.getValue()).pxSize;
        boolean zChanged = gapComposer.changed(iMo86roundToPx0680j_4) | gapComposer.changed(j);
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue == Composer$Companion.Empty) {
            objRememberedValue = new TooltipPositionProviderImpl(iMo86roundToPx0680j_4, j);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        return (TooltipPositionProviderImpl) objRememberedValue;
    }
}
