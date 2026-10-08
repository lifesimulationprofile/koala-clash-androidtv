package androidx.compose.foundation.text.selection;

import androidx.activity.ImmLeaksCleaner$$ExternalSyntheticLambda0;
import androidx.collection.MutableLongObjectMap;
import androidx.compose.runtime.DynamicProvidableCompositionLocal;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class SelectionRegistrarKt {
    public static final DynamicProvidableCompositionLocal LocalSelectionRegistrar = new DynamicProvidableCompositionLocal(new ImmLeaksCleaner$$ExternalSyntheticLambda0(17));

    public static final boolean hasSelection(SelectionRegistrarImpl selectionRegistrarImpl, long j) {
        MutableLongObjectMap subselections;
        if (selectionRegistrarImpl == null || (subselections = selectionRegistrarImpl.getSubselections()) == null) {
            return false;
        }
        return subselections.containsKey(j);
    }
}
