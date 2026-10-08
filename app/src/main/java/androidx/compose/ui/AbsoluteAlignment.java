package androidx.compose.ui;

import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.window.PopupLayout$Content$4;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbsoluteAlignment {
    public static final BiasAbsoluteAlignment TopLeft = new BiasAbsoluteAlignment(-1.0f);
    public static final BiasAbsoluteAlignment TopRight = new BiasAbsoluteAlignment(1.0f);
    public static final BiasAbsoluteAlignment.Horizontal Left = new BiasAbsoluteAlignment.Horizontal(-1.0f);
    public static final BiasAbsoluteAlignment.Horizontal Right = new BiasAbsoluteAlignment.Horizontal(1.0f);

    public static final Modifier materializeImpl(GapComposer gapComposer, Modifier modifier) {
        if (modifier.all(ComposedModifierKt$materializeImpl$1.INSTANCE)) {
            return modifier;
        }
        gapComposer.startReplaceableGroup(1219399079);
        Modifier modifier2 = (Modifier) modifier.foldIn(Modifier.Companion.$$INSTANCE, new PopupLayout$Content$4(2, gapComposer));
        gapComposer.end(false);
        return modifier2;
    }

    public static final Modifier materializeModifier(GapComposer gapComposer, Modifier modifier) {
        gapComposer.startReplaceGroup(439770924);
        Modifier modifierMaterializeImpl = materializeImpl(gapComposer, modifier);
        gapComposer.end(false);
        return modifierMaterializeImpl;
    }
}
