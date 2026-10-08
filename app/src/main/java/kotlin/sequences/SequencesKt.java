package kotlin.sequences;

import coil.decode.BitmapFactoryDecoder$$ExternalSyntheticLambda2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.io.LinesSequence;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public abstract class SequencesKt extends SequencesKt__SequencesJVMKt {
    public static Sequence asSequence(Iterator it) {
        return new ConstrainedOnceSequence(new LinesSequence(4, it));
    }

    public static FilteringSequence filter(Sequence sequence, Function1 function1) {
        return new FilteringSequence(sequence, true, function1);
    }

    public static Sequence generateSequence(Object obj, Function1 function1) {
        return obj == null ? EmptySequence.INSTANCE : new GeneratorSequence(new BitmapFactoryDecoder$$ExternalSyntheticLambda2(19, obj), function1, 0);
    }

    public static List toList(Sequence sequence) {
        Iterator it = sequence.iterator();
        if (!it.hasNext()) {
            return EmptyList.INSTANCE;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return Collections.singletonList(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public static ArrayList toMutableList(Sequence sequence) {
        ArrayList arrayList = new ArrayList();
        Iterator it = sequence.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
