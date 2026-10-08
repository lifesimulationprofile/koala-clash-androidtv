package androidx.compose.runtime.collection;

import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.collection.MutableObjectList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MutableVector implements RandomAccess {
    public Object[] content;
    public MutableObjectList.ObjectListMutableList list;
    public int size = 0;

    public MutableVector(Object[] objArr) {
        this.content = objArr;
    }

    public final void add(Object obj) {
        int i = this.size + 1;
        if (this.content.length < i) {
            resizeStorage(i);
        }
        Object[] objArr = this.content;
        int i2 = this.size;
        objArr[i2] = obj;
        this.size = i2 + 1;
    }

    public final void addAll(int i, List list) {
        if (list.isEmpty()) {
            return;
        }
        int size = list.size();
        int i2 = this.size + size;
        if (this.content.length < i2) {
            resizeStorage(i2);
        }
        Object[] objArr = this.content;
        int i3 = this.size;
        if (i != i3) {
            System.arraycopy(objArr, i, objArr, i + size, i3 - i);
        }
        int size2 = list.size();
        for (int i4 = 0; i4 < size2; i4++) {
            objArr[i + i4] = list.get(i4);
        }
        this.size += size;
    }

    public final List asMutableList() {
        MutableObjectList.ObjectListMutableList objectListMutableList = this.list;
        if (objectListMutableList != null) {
            return objectListMutableList;
        }
        MutableObjectList.ObjectListMutableList objectListMutableList2 = new MutableObjectList.ObjectListMutableList(1, this);
        this.list = objectListMutableList2;
        return objectListMutableList2;
    }

    public final void clear() {
        Object[] objArr = this.content;
        int i = this.size;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.size = 0;
    }

    public final boolean contains(Object obj) {
        int i = this.size - 1;
        if (i >= 0) {
            for (int i2 = 0; !Intrinsics.areEqual(this.content[i2], obj); i2++) {
                if (i2 != i) {
                }
            }
            return true;
        }
        return false;
    }

    public final int indexOf(Object obj) {
        Object[] objArr = this.content;
        int i = this.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (Intrinsics.areEqual(obj, objArr[i2])) {
                return i2;
            }
        }
        return -1;
    }

    public final boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        removeAt(iIndexOf);
        return true;
    }

    public final Object removeAt(int i) {
        Object[] objArr = this.content;
        Object obj = objArr[i];
        int i2 = this.size;
        if (i != i2 - 1) {
            int i3 = i + 1;
            System.arraycopy(objArr, i3, objArr, i, i2 - i3);
        }
        int i4 = this.size - 1;
        this.size = i4;
        objArr[i4] = null;
        return obj;
    }

    public final void removeRange(int i, int i2) {
        if (i2 > i) {
            int i3 = this.size;
            if (i2 < i3) {
                Object[] objArr = this.content;
                System.arraycopy(objArr, i2, objArr, i, i3 - i2);
            }
            int i4 = this.size;
            int i5 = i4 - (i2 - i);
            int i6 = i4 - 1;
            if (i5 <= i6) {
                int i7 = i5;
                while (true) {
                    this.content[i7] = null;
                    if (i7 == i6) {
                        break;
                    } else {
                        i7++;
                    }
                }
            }
            this.size = i5;
        }
    }

    public final void resizeStorage(int i) {
        Object[] objArr = this.content;
        int length = objArr.length;
        Object[] objArr2 = new Object[Math.max(i, length * 2)];
        System.arraycopy(objArr, 0, objArr2, 0, length);
        this.content = objArr2;
    }

    public final void add(int i, Object obj) {
        int i2 = this.size + 1;
        if (this.content.length < i2) {
            resizeStorage(i2);
        }
        Object[] objArr = this.content;
        int i3 = this.size;
        if (i != i3) {
            System.arraycopy(objArr, i, objArr, i + 1, i3 - i);
        }
        objArr[i] = obj;
        this.size++;
    }

    public final void addAll(int i, MutableVector mutableVector) {
        int i2 = mutableVector.size;
        if (i2 == 0) {
            return;
        }
        int i3 = this.size + i2;
        if (this.content.length < i3) {
            resizeStorage(i3);
        }
        Object[] objArr = this.content;
        int i4 = this.size;
        if (i != i4) {
            System.arraycopy(objArr, i, objArr, i + i2, i4 - i);
        }
        System.arraycopy(mutableVector.content, 0, objArr, i, i2);
        this.size += i2;
    }

    public final boolean addAll(int i, Collection collection) {
        int i2 = 0;
        if (collection.isEmpty()) {
            return false;
        }
        int size = collection.size();
        int i3 = this.size + size;
        if (this.content.length < i3) {
            resizeStorage(i3);
        }
        Object[] objArr = this.content;
        int i4 = this.size;
        if (i != i4) {
            System.arraycopy(objArr, i, objArr, i + size, i4 - i);
        }
        for (Object obj : collection) {
            int i5 = i2 + 1;
            if (i2 >= 0) {
                objArr[i2 + i] = obj;
                i2 = i5;
            } else {
                AppCompatHintHelper.throwIndexOverflow();
                throw null;
            }
        }
        this.size += size;
        return true;
    }
}
