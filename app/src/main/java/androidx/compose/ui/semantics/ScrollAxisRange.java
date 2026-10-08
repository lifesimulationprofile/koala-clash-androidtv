package androidx.compose.ui.semantics;

import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ScrollAxisRange {
    public final Function0 maxValue;
    public final boolean reverseScrolling;
    public final Function0 value;

    public ScrollAxisRange(Function0 function0, Function0 function1, boolean z) {
        this.value = function0;
        this.maxValue = function1;
        this.reverseScrolling = z;
    }

    public final String toString() {
        return "ScrollAxisRange(value=" + ((Number) this.value.invoke()).floatValue() + ", maxValue=" + ((Number) this.maxValue.invoke()).floatValue() + ", reverseScrolling=" + this.reverseScrolling + ')';
    }
}
