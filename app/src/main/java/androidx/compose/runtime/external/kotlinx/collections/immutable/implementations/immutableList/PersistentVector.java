package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.foundation.style.InteractionSet;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.snapshots.SnapshotStateList$$ExternalSyntheticLambda0;
import com.google.android.gms.internal.mlkit_vision_barcode.zzsl;
import com.google.android.gms.internal.mlkit_vision_barcode.zzsn;
import java.util.Arrays;
import java.util.ListIterator;
import kotlin.collections.ArraysKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class PersistentVector extends AbstractPersistentList {
    public final Object[] root;
    public final int rootShift;
    public final int size;
    public final Object[] tail;

    public PersistentVector(Object[] objArr, Object[] objArr2, int i, int i2) {
        this.root = objArr;
        this.tail = objArr2;
        this.size = i;
        this.rootShift = i2;
        if (!(getSize() > 32)) {
            PreconditionsKt.throwIllegalArgumentException("Trie-based persistent vector should have at least 33 elements, got " + getSize());
        }
        int length = objArr2.length;
    }

    public static Object[] insertIntoRoot(Object[] objArr, int i, int i2, Object obj, InteractionSet interactionSet) {
        int iIndexSegment = zzsl.indexSegment(i2, i);
        if (i == 0) {
            Object[] objArrCopyOf = iIndexSegment == 0 ? new Object[32] : Arrays.copyOf(objArr, 32);
            ArraysKt.copyInto(objArr, objArrCopyOf, iIndexSegment + 1, iIndexSegment, 31);
            interactionSet.setOrValue = objArr[31];
            objArrCopyOf[iIndexSegment] = obj;
            return objArrCopyOf;
        }
        Object[] objArrCopyOf2 = Arrays.copyOf(objArr, 32);
        int i3 = i - 5;
        objArrCopyOf2[iIndexSegment] = insertIntoRoot((Object[]) objArr[iIndexSegment], i3, i2, obj, interactionSet);
        while (true) {
            iIndexSegment++;
            if (iIndexSegment >= 32 || objArrCopyOf2[iIndexSegment] == null) {
                break;
            }
            objArrCopyOf2[iIndexSegment] = insertIntoRoot((Object[]) objArr[iIndexSegment], i3, 0, interactionSet.setOrValue, interactionSet);
        }
        return objArrCopyOf2;
    }

    public static Object[] pullLastBuffer(Object[] objArr, int i, int i2, InteractionSet interactionSet) {
        Object[] objArrPullLastBuffer;
        int iIndexSegment = zzsl.indexSegment(i2, i);
        if (i == 5) {
            interactionSet.setOrValue = objArr[iIndexSegment];
            objArrPullLastBuffer = null;
        } else {
            objArrPullLastBuffer = pullLastBuffer((Object[]) objArr[iIndexSegment], i - 5, i2, interactionSet);
        }
        if (objArrPullLastBuffer == null && iIndexSegment == 0) {
            return null;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, 32);
        objArrCopyOf[iIndexSegment] = objArrPullLastBuffer;
        return objArrCopyOf;
    }

    public static Object[] setInRoot(Object[] objArr, int i, int i2, Object obj) {
        int iIndexSegment = zzsl.indexSegment(i2, i);
        Object[] objArrCopyOf = Arrays.copyOf(objArr, 32);
        if (i == 0) {
            objArrCopyOf[iIndexSegment] = obj;
            return objArrCopyOf;
        }
        objArrCopyOf[iIndexSegment] = setInRoot((Object[]) objArrCopyOf[iIndexSegment], i - 5, i2, obj);
        return objArrCopyOf;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList, java.util.Collection, java.util.List
    public final AbstractPersistentList add(Object obj) {
        int iRootSize = rootSize();
        int i = this.size;
        int i2 = i - iRootSize;
        Object[] objArr = this.root;
        Object[] objArr2 = this.tail;
        if (i2 < 32) {
            Object[] objArrCopyOf = Arrays.copyOf(objArr2, 32);
            objArrCopyOf[i2] = obj;
            return new PersistentVector(objArr, objArrCopyOf, i + 1, this.rootShift);
        }
        Object[] objArr3 = new Object[32];
        objArr3[0] = obj;
        return pushFilledTail(objArr, objArr2, objArr3);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList
    public final PersistentVectorBuilder builder() {
        return new PersistentVectorBuilder(this, this.root, this.tail, this.rootShift);
    }

    @Override // java.util.List
    public final Object get(int i) {
        Object[] objArr;
        zzsn.checkElementIndex$runtime(i, getSize());
        if (rootSize() <= i) {
            objArr = this.tail;
        } else {
            objArr = this.root;
            for (int i2 = this.rootShift; i2 > 0; i2 -= 5) {
                objArr = (Object[]) objArr[zzsl.indexSegment(i, i2)];
            }
        }
        return objArr[i & 31];
    }

    @Override // kotlin.collections.AbstractCollection
    public final int getSize() {
        return this.size;
    }

    public final PersistentVector insertIntoTail(int i, Object obj, Object[] objArr) {
        int iRootSize = rootSize();
        int i2 = this.size;
        int i3 = i2 - iRootSize;
        Object[] objArr2 = this.tail;
        Object[] objArrCopyOf = Arrays.copyOf(objArr2, 32);
        if (i3 < 32) {
            ArraysKt.copyInto(objArr2, objArrCopyOf, i + 1, i, i3);
            objArrCopyOf[i] = obj;
            return new PersistentVector(objArr, objArrCopyOf, i2 + 1, this.rootShift);
        }
        Object obj2 = objArr2[31];
        ArraysKt.copyInto(objArr2, objArrCopyOf, i + 1, i, i3 - 1);
        objArrCopyOf[i] = obj;
        Object[] objArr3 = new Object[32];
        objArr3[0] = obj2;
        return pushFilledTail(objArr, objArrCopyOf, objArr3);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final ListIterator listIterator(int i) {
        zzsn.checkPositionIndex$runtime(i, this.size);
        return new PersistentVectorIterator(this.root, this.tail, i, this.size, (this.rootShift / 5) + 1);
    }

    public final PersistentVector pushFilledTail(Object[] objArr, Object[] objArr2, Object[] objArr3) {
        int i = this.size;
        int i2 = i >> 5;
        int i3 = this.rootShift;
        if (i2 <= (1 << i3)) {
            return new PersistentVector(pushTail(i3, objArr, objArr2), objArr3, i + 1, i3);
        }
        Object[] objArr4 = new Object[32];
        objArr4[0] = objArr;
        int i4 = i3 + 5;
        return new PersistentVector(pushTail(i4, objArr4, objArr2), objArr3, i + 1, i4);
    }

    public final Object[] pushTail(int i, Object[] objArr, Object[] objArr2) {
        int iIndexSegment = zzsl.indexSegment(getSize() - 1, i);
        Object[] objArrCopyOf = objArr != null ? Arrays.copyOf(objArr, 32) : new Object[32];
        if (i == 5) {
            objArrCopyOf[iIndexSegment] = objArr2;
            return objArrCopyOf;
        }
        objArrCopyOf[iIndexSegment] = pushTail(i - 5, (Object[]) objArrCopyOf[iIndexSegment], objArr2);
        return objArrCopyOf;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList
    public final AbstractPersistentList removeAll(SnapshotStateList$$ExternalSyntheticLambda0 snapshotStateList$$ExternalSyntheticLambda0) {
        PersistentVectorBuilder persistentVectorBuilder = new PersistentVectorBuilder(this, this.root, this.tail, this.rootShift);
        persistentVectorBuilder.removeAllWithPredicate(snapshotStateList$$ExternalSyntheticLambda0);
        return persistentVectorBuilder.build();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList
    public final AbstractPersistentList removeAt(int i) {
        zzsn.checkElementIndex$runtime(i, this.size);
        int iRootSize = rootSize();
        Object[] objArr = this.root;
        int i2 = this.rootShift;
        return i >= iRootSize ? removeFromTailAt(objArr, iRootSize, i2, i - iRootSize) : removeFromTailAt(removeFromRootAt(objArr, i2, i, new InteractionSet(this.tail[0])), iRootSize, i2, 0);
    }

    public final Object[] removeFromRootAt(Object[] objArr, int i, int i2, InteractionSet interactionSet) {
        int iIndexSegment = zzsl.indexSegment(i2, i);
        if (i == 0) {
            Object[] objArrCopyOf = iIndexSegment == 0 ? new Object[32] : Arrays.copyOf(objArr, 32);
            ArraysKt.copyInto(objArr, objArrCopyOf, iIndexSegment, iIndexSegment + 1, 32);
            objArrCopyOf[31] = interactionSet.setOrValue;
            interactionSet.setOrValue = objArr[iIndexSegment];
            return objArrCopyOf;
        }
        int iIndexSegment2 = objArr[31] == null ? zzsl.indexSegment(rootSize() - 1, i) : 31;
        Object[] objArrCopyOf2 = Arrays.copyOf(objArr, 32);
        int i3 = i - 5;
        int i4 = iIndexSegment + 1;
        if (i4 <= iIndexSegment2) {
            while (true) {
                objArrCopyOf2[iIndexSegment2] = removeFromRootAt((Object[]) objArrCopyOf2[iIndexSegment2], i3, 0, interactionSet);
                if (iIndexSegment2 == i4) {
                    break;
                }
                iIndexSegment2--;
            }
        }
        objArrCopyOf2[iIndexSegment] = removeFromRootAt((Object[]) objArrCopyOf2[iIndexSegment], i3, i2, interactionSet);
        return objArrCopyOf2;
    }

    public final AbstractPersistentList removeFromTailAt(Object[] objArr, int i, int i2, int i3) {
        int i4 = this.size - i;
        if (i4 != 1) {
            Object[] objArr2 = this.tail;
            Object[] objArrCopyOf = Arrays.copyOf(objArr2, 32);
            int i5 = i4 - 1;
            if (i3 < i5) {
                ArraysKt.copyInto(objArr2, objArrCopyOf, i3, i3 + 1, i4);
            }
            objArrCopyOf[i5] = null;
            return new PersistentVector(objArr, objArrCopyOf, (i + i4) - 1, i2);
        }
        if (i2 == 0) {
            if (objArr.length == 33) {
                objArr = Arrays.copyOf(objArr, 32);
            }
            return new SmallPersistentVector(objArr);
        }
        InteractionSet interactionSet = new InteractionSet(null);
        Object[] objArrPullLastBuffer = pullLastBuffer(objArr, i2, i - 1, interactionSet);
        Object[] objArr3 = (Object[]) interactionSet.setOrValue;
        return objArrPullLastBuffer[1] == null ? new PersistentVector((Object[]) objArrPullLastBuffer[0], objArr3, i, i2 - 5) : new PersistentVector(objArrPullLastBuffer, objArr3, i, i2);
    }

    public final int rootSize() {
        return (this.size - 1) & (-32);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList, kotlin.collections.AbstractList, java.util.List
    public final AbstractPersistentList set(int i, Object obj) {
        int i2 = this.size;
        zzsn.checkElementIndex$runtime(i, i2);
        int iRootSize = rootSize();
        Object[] objArr = this.root;
        Object[] objArr2 = this.tail;
        int i3 = this.rootShift;
        if (iRootSize > i) {
            return new PersistentVector(setInRoot(objArr, i3, i, obj), objArr2, i2, i3);
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr2, 32);
        objArrCopyOf[i & 31] = obj;
        return new PersistentVector(objArr, objArrCopyOf, i2, i3);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.AbstractPersistentList, java.util.List
    public final AbstractPersistentList add(int i, Object obj) {
        int i2 = this.size;
        zzsn.checkPositionIndex$runtime(i, i2);
        if (i == i2) {
            return add(obj);
        }
        int iRootSize = rootSize();
        Object[] objArr = this.root;
        if (i >= iRootSize) {
            return insertIntoTail(i - iRootSize, obj, objArr);
        }
        InteractionSet interactionSet = new InteractionSet(null);
        return insertIntoTail(0, interactionSet.setOrValue, insertIntoRoot(objArr, this.rootShift, i, obj, interactionSet));
    }
}
