package kotlin.collections;

import coil.decode.BitmapFactoryDecoder$$ExternalSyntheticLambda2;
import java.util.Iterator;
import kotlin.UIntArray;
import kotlin.io.FileTreeWalk;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.DelimitedRangesSequence$iterator$1;
import kotlinx.serialization.internal.EnumDescriptor;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class IndexingIterable implements Iterable, KMappedMarker {
    public final /* synthetic */ int $r8$classId;
    public final Object iteratorFactory;

    public /* synthetic */ IndexingIterable(int i, Object obj) {
        this.$r8$classId = i;
        this.iteratorFactory = obj;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        switch (this.$r8$classId) {
            case 0:
                return new IndexingIterator((Iterator) ((BitmapFactoryDecoder$$ExternalSyntheticLambda2) this.iteratorFactory).invoke());
            case 1:
                return new DelimitedRangesSequence$iterator$1((FileTreeWalk) this.iteratorFactory);
            default:
                return new UIntArray.Iterator((EnumDescriptor) this.iteratorFactory);
        }
    }
}
