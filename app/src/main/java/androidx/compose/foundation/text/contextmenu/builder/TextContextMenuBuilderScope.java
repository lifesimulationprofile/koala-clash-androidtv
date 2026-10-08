package androidx.compose.foundation.text.contextmenu.builder;

import androidx.collection.MutableObjectList;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSeparator;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TextContextMenuBuilderScope {
    public final MutableObjectList components = new MutableObjectList();
    public final MutableObjectList filters = new MutableObjectList();

    public final void separator() {
        this.components.add(TextContextMenuSeparator.INSTANCE);
    }
}
