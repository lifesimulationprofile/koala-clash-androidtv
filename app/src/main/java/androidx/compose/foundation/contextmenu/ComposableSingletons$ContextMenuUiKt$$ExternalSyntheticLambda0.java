package androidx.compose.foundation.contextmenu;

import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.Modifier;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function8;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ComposableSingletons$ContextMenuUiKt$$ExternalSyntheticLambda0 implements Function8 {
    @Override // kotlin.jvm.functions.Function8
    public final Object invoke(Object obj, Boolean bool, Object obj2, Object obj3, Object obj4, Object obj5, Integer num) {
        int i;
        String str = (String) obj;
        boolean zBooleanValue = bool.booleanValue();
        ContextMenuColors contextMenuColors = (ContextMenuColors) obj2;
        Function3 function3 = (Function3) obj3;
        Function0 function0 = (Function0) obj4;
        GapComposer gapComposer = (GapComposer) obj5;
        int iIntValue = num.intValue();
        int i2 = iIntValue & 6;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        if (i2 == 0) {
            i = (gapComposer.changed(companion) ? 4 : 2) | iIntValue;
        } else {
            i = iIntValue;
        }
        if ((iIntValue & 48) == 0) {
            i |= gapComposer.changed(str) ? 32 : 16;
        }
        if ((iIntValue & 384) == 0) {
            i |= gapComposer.changed(zBooleanValue) ? 256 : 128;
        }
        if ((iIntValue & 3072) == 0) {
            i |= gapComposer.changed(contextMenuColors) ? 2048 : 1024;
        }
        if ((iIntValue & 24576) == 0) {
            i |= gapComposer.changedInstance(function3) ? 16384 : 8192;
        }
        if ((iIntValue & 196608) == 0) {
            i |= gapComposer.changedInstance(function0) ? 131072 : 65536;
        }
        if (gapComposer.shouldExecute(i & 1, (599187 & i) != 599186)) {
            ContextMenuUiKt.ContextMenuItem(str, zBooleanValue, contextMenuColors, companion, function3, function0, gapComposer, ((i >> 3) & 1022) | ((i << 9) & 7168) | (57344 & i) | (i & 458752));
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}
