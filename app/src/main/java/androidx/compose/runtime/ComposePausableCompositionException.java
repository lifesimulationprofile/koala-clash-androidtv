package androidx.compose.runtime;

import androidx.camera.core.impl.utils.MatrixExt;
import androidx.collection.MutableIntList;
import androidx.collection.MutableObjectList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.sequences.SequenceBuilderIterator;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ComposePausableCompositionException extends RuntimeException {
    public final MutableObjectList instances;
    public final int lastOperation;
    public final MutableIntList operations;
    public final MutableObjectList reused;

    public ComposePausableCompositionException(MutableObjectList mutableObjectList, MutableObjectList mutableObjectList2, MutableIntList mutableIntList, int i, Exception exc) {
        super(exc);
        this.instances = mutableObjectList;
        this.reused = mutableObjectList2;
        this.operations = mutableIntList;
        this.lastOperation = i;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        List listSingletonList;
        List list;
        StringBuilder sb = new StringBuilder("\n            |Failed to execute op number ");
        sb.append(this.lastOperation);
        sb.append(":\n            |");
        SequenceBuilderIterator it = MatrixExt.iterator(new ComposePausableCompositionException$operationsSequence$1(this, null));
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(next);
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
                listSingletonList = arrayList;
            } else {
                listSingletonList = Collections.singletonList(next);
            }
        } else {
            listSingletonList = EmptyList.INSTANCE;
        }
        int size = listSingletonList.size();
        if (50 >= size) {
            list = CollectionsKt.toList(listSingletonList);
        } else {
            ArrayList arrayList2 = new ArrayList(50);
            if (listSingletonList instanceof RandomAccess) {
                for (int i = size - 50; i < size; i++) {
                    arrayList2.add(listSingletonList.get(i));
                }
            } else {
                ListIterator listIterator = listSingletonList.listIterator(size - 50);
                while (listIterator.hasNext()) {
                    arrayList2.add(listIterator.next());
                }
            }
            list = arrayList2;
        }
        sb.append(CollectionsKt.joinToString$default(list, "\n", null, null, null, 62));
        sb.append("\n            ");
        return StringsKt__IndentKt.trimMargin$default(sb.toString());
    }
}
