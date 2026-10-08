package androidx.compose.foundation.text.contextmenu.data;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TextContextMenuItem extends TextContextMenuComponent {
    public final String label;
    public final int leadingIcon;
    public final Function1 onClick;

    public TextContextMenuItem(Object obj, String str, int i, Function1 function1) {
        super(obj);
        this.label = str;
        this.leadingIcon = i;
        this.onClick = function1;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TextContextMenuItem(key=");
        sb.append(this.key);
        sb.append(", label=\"");
        sb.append(this.label);
        sb.append("\", leadingIcon=");
        return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.leadingIcon, ')');
    }
}
