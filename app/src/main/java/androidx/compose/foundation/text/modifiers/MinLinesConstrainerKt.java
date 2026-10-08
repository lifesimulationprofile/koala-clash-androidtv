package androidx.compose.foundation.text.modifiers;

import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class MinLinesConstrainerKt {
    public static final String EmptyTextReplacement;
    public static final String TwoLineTextReplacement;

    static {
        String strRepeat = StringsKt__StringsJVMKt.repeat("H", 10);
        EmptyTextReplacement = strRepeat;
        TwoLineTextReplacement = strRepeat + '\n' + strRepeat;
    }
}
