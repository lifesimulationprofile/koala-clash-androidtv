package androidx.compose.ui.graphics.vector;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilderBaseIterator;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeBaseIterator;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNodeMutableEntriesIterator;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class VectorGroup extends VectorNode implements Iterable, KMappedMarker {
    public final List children;
    public final List clipPathData;
    public final String name;
    public final float pivotX;
    public final float pivotY;
    public final float rotation;
    public final float scaleX;
    public final float scaleY;
    public final float translationX;
    public final float translationY;

    public VectorGroup(String str, float f, float f2, float f3, float f4, float f5, float f6, float f7, List list, ArrayList arrayList) {
        this.name = str;
        this.rotation = f;
        this.pivotX = f2;
        this.pivotY = f3;
        this.scaleX = f4;
        this.scaleY = f5;
        this.translationX = f6;
        this.translationY = f7;
        this.clipPathData = list;
        this.children = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof VectorGroup)) {
            VectorGroup vectorGroup = (VectorGroup) obj;
            return Intrinsics.areEqual(this.name, vectorGroup.name) && this.rotation == vectorGroup.rotation && this.pivotX == vectorGroup.pivotX && this.pivotY == vectorGroup.pivotY && this.scaleX == vectorGroup.scaleX && this.scaleY == vectorGroup.scaleY && this.translationX == vectorGroup.translationX && this.translationY == vectorGroup.translationY && Intrinsics.areEqual(this.clipPathData, vectorGroup.clipPathData) && Intrinsics.areEqual(this.children, vectorGroup.children);
        }
        return false;
    }

    public final int hashCode() {
        return this.children.hashCode() + ((this.clipPathData.hashCode() + ImageAnalysis$$ExternalSyntheticLambda1.m(this.translationY, ImageAnalysis$$ExternalSyntheticLambda1.m(this.translationX, ImageAnalysis$$ExternalSyntheticLambda1.m(this.scaleY, ImageAnalysis$$ExternalSyntheticLambda1.m(this.scaleX, ImageAnalysis$$ExternalSyntheticLambda1.m(this.pivotY, ImageAnalysis$$ExternalSyntheticLambda1.m(this.pivotX, ImageAnalysis$$ExternalSyntheticLambda1.m(this.rotation, this.name.hashCode() * 31, 31), 31), 31), 31), 31), 31), 31)) * 31);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new AnonymousClass1(this);
    }

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.vector.VectorGroup$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 implements Iterator, KMappedMarker {
        public final /* synthetic */ int $r8$classId = 1;
        public final Object it;

        public AnonymousClass1(Enumeration enumeration) {
            this.it = enumeration;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            switch (this.$r8$classId) {
                case 0:
                    return ((Iterator) this.it).hasNext();
                case 1:
                    return ((PersistentHashMapBuilderBaseIterator) this.it).hasNext;
                default:
                    return ((Enumeration) this.it).hasMoreElements();
            }
        }

        @Override // java.util.Iterator
        public final Object next() {
            switch (this.$r8$classId) {
                case 0:
                    return (VectorNode) ((Iterator) this.it).next();
                case 1:
                    return (Map.Entry) ((PersistentHashMapBuilderBaseIterator) this.it).next();
                default:
                    return ((Enumeration) this.it).nextElement();
            }
        }

        @Override // java.util.Iterator
        public final void remove() {
            switch (this.$r8$classId) {
                case 0:
                    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
                case 1:
                    ((PersistentHashMapBuilderBaseIterator) this.it).remove();
                    return;
                default:
                    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        }

        public AnonymousClass1(PersistentHashMapBuilder persistentHashMapBuilder) {
            TrieNodeBaseIterator[] trieNodeBaseIteratorArr = new TrieNodeBaseIterator[8];
            for (int i = 0; i < 8; i++) {
                trieNodeBaseIteratorArr[i] = new TrieNodeMutableEntriesIterator(this);
            }
            this.it = new PersistentHashMapBuilderBaseIterator(persistentHashMapBuilder, trieNodeBaseIteratorArr);
        }

        public AnonymousClass1(VectorGroup vectorGroup) {
            this.it = vectorGroup.children.iterator();
        }
    }
}
