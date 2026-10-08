package kotlin.collections;

import androidx.appcompat.widget.AppCompatHintHelper;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class CollectionsKt__IterablesKt extends AppCompatHintHelper {
    public static int collectionSizeOrDefault(Iterable iterable, int i) {
        return iterable instanceof Collection ? ((Collection) iterable).size() : i;
    }
}
