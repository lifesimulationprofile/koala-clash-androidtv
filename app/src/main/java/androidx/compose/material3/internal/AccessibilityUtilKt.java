package androidx.compose.material3.internal;

import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda10;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AccessibilityUtilKt {
    public static final float HorizontalSemanticsBoundsPadding;
    public static final Modifier IncreaseVerticalSemanticsBounds;
    public static final float VerticalSemanticsBoundsPadding;

    static {
        float f = 10;
        HorizontalSemanticsBoundsPadding = f;
        VerticalSemanticsBoundsPadding = f;
        AccessibilityUtilKt$$ExternalSyntheticLambda0 accessibilityUtilKt$$ExternalSyntheticLambda0 = new AccessibilityUtilKt$$ExternalSyntheticLambda0(0);
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        OffsetKt.m130paddingVpY3zN4$default(SemanticsModifierKt.semantics(RulerKt.layout(companion, accessibilityUtilKt$$ExternalSyntheticLambda0), true, new SaversKt$$ExternalSyntheticLambda10(15)), f, 0.0f, 2);
        IncreaseVerticalSemanticsBounds = OffsetKt.m130paddingVpY3zN4$default(SemanticsModifierKt.semantics(RulerKt.layout(companion, new AccessibilityUtilKt$$ExternalSyntheticLambda0(3)), true, new SaversKt$$ExternalSyntheticLambda10(16)), 0.0f, f, 1);
    }
}
