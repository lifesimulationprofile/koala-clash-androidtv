package androidx.core.util;

import androidx.constraintlayout.solver.ArrayRow;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class Pools$SimplePool {
    public final /* synthetic */ int $r8$classId;
    public final Object[] pool;
    public int poolSize;

    public Pools$SimplePool(int i) {
        this.$r8$classId = 0;
        if (i <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.pool = new Object[i];
    }

    public Object acquire() {
        switch (this.$r8$classId) {
            case 0:
                int i = this.poolSize;
                if (i <= 0) {
                    return null;
                }
                int i2 = i - 1;
                Object[] objArr = this.pool;
                Object obj = objArr[i2];
                objArr[i2] = null;
                this.poolSize = i - 1;
                return obj;
            default:
                int i3 = this.poolSize;
                if (i3 <= 0) {
                    return null;
                }
                int i4 = i3 - 1;
                Object[] objArr2 = this.pool;
                Object obj2 = objArr2[i4];
                objArr2[i4] = null;
                this.poolSize = i3 - 1;
                return obj2;
        }
    }

    public boolean release(Object obj) {
        Object[] objArr;
        boolean z;
        int i = this.poolSize;
        int i2 = 0;
        while (true) {
            objArr = this.pool;
            if (i2 >= i) {
                z = false;
                break;
            }
            if (objArr[i2] == obj) {
                z = true;
                break;
            }
            i2++;
        }
        if (z) {
            throw new IllegalStateException("Already in the pool!");
        }
        int i3 = this.poolSize;
        if (i3 >= objArr.length) {
            return false;
        }
        objArr[i3] = obj;
        this.poolSize = i3 + 1;
        return true;
    }

    public Pools$SimplePool() {
        this.$r8$classId = 1;
        this.pool = new Object[256];
    }

    public void release(ArrayRow arrayRow) {
        int i = this.poolSize;
        Object[] objArr = this.pool;
        if (i < objArr.length) {
            objArr[i] = arrayRow;
            this.poolSize = i + 1;
        }
    }
}
