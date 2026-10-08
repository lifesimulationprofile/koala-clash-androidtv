package androidx.compose.ui.layout;

import androidx.collection.MutableIntObjectMap;
import androidx.compose.ui.node.LookaheadCapablePlaceable;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class WindowInsetsRulers_androidKt {
    public static final WindowInsetsRulers[] AnimatableInsetsRulers;
    public static final MutableIntObjectMap WindowInsetsTypeMap;

    static {
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(8);
        WindowInsetsRulers.Companion.getClass();
        WindowInsetsRulersImpl windowInsetsRulersImpl = WindowInsetsRulers.Companion.StatusBars;
        mutableIntObjectMap.set(1, windowInsetsRulersImpl);
        WindowInsetsRulersImpl windowInsetsRulersImpl2 = WindowInsetsRulers.Companion.NavigationBars;
        mutableIntObjectMap.set(2, windowInsetsRulersImpl2);
        WindowInsetsRulersImpl windowInsetsRulersImpl3 = WindowInsetsRulers.Companion.CaptionBar;
        mutableIntObjectMap.set(4, windowInsetsRulersImpl3);
        WindowInsetsRulersImpl windowInsetsRulersImpl4 = WindowInsetsRulers.Companion.Ime;
        mutableIntObjectMap.set(8, windowInsetsRulersImpl4);
        WindowInsetsRulersImpl windowInsetsRulersImpl5 = WindowInsetsRulers.Companion.SystemGestures;
        mutableIntObjectMap.set(16, windowInsetsRulersImpl5);
        WindowInsetsRulersImpl windowInsetsRulersImpl6 = WindowInsetsRulers.Companion.MandatorySystemGestures;
        mutableIntObjectMap.set(32, windowInsetsRulersImpl6);
        WindowInsetsRulersImpl windowInsetsRulersImpl7 = WindowInsetsRulers.Companion.TappableElement;
        mutableIntObjectMap.set(64, windowInsetsRulersImpl7);
        WindowInsetsRulersImpl windowInsetsRulersImpl8 = WindowInsetsRulers.Companion.DisplayCutout;
        mutableIntObjectMap.set(128, windowInsetsRulersImpl8);
        WindowInsetsTypeMap = mutableIntObjectMap;
        AnimatableInsetsRulers = new WindowInsetsRulers[]{windowInsetsRulersImpl, windowInsetsRulersImpl2, windowInsetsRulersImpl3, windowInsetsRulersImpl7, windowInsetsRulersImpl5, windowInsetsRulersImpl6, windowInsetsRulersImpl4, WindowInsetsRulers.Companion.Waterfall, windowInsetsRulersImpl8};
    }

    /* JADX INFO: renamed from: provideInsetsValues-cytEWk0, reason: not valid java name */
    public static final void m540provideInsetsValuescytEWk0(LookaheadCapablePlaceable.ResettableRulerScope resettableRulerScope, RectRulersImpl rectRulersImpl, long j, int i, int i2) {
        if (RulerKt.m538equalsimpl0(j, -1L)) {
            return;
        }
        resettableRulerScope.provides(rectRulersImpl.getLeft(), (int) ((j >>> 48) & 65535));
        resettableRulerScope.provides(rectRulersImpl.getTop(), (int) ((j >>> 32) & 65535));
        resettableRulerScope.provides(rectRulersImpl.getRight(), i - ((int) ((j >>> 16) & 65535)));
        resettableRulerScope.provides(rectRulersImpl.getBottom(), i2 - ((int) (j & 65535)));
    }
}
