package androidx.compose.foundation.text.handwriting;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.StylusHoverIconModifierElement;
import androidx.compose.ui.node.DpTouchBoundsExpansion;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class StylusHandwritingKt {
    public static final DpTouchBoundsExpansion HandwritingBoundsExpansion;

    static {
        float f = 40;
        float f2 = 10;
        HandwritingBoundsExpansion = new DpTouchBoundsExpansion(f2, f, f2, f);
    }

    public static final Modifier stylusHandwriting(boolean z, boolean z2, Function0 function0) {
        Modifier stylusHoverIconModifierElement = Modifier.Companion.$$INSTANCE;
        if (!z || !StylusHandwriting_androidKt.isStylusHandwritingSupported) {
            return stylusHoverIconModifierElement;
        }
        if (z2) {
            stylusHoverIconModifierElement = new StylusHoverIconModifierElement(HandwritingBoundsExpansion);
        }
        return stylusHoverIconModifierElement.then(new StylusHandwritingElement(function0));
    }
}
