package androidx.collection;

import androidx.camera.view.PreviewView;
import androidx.collection.internal.RuntimeHelpersKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class LruCache {
    public int hitCount;
    public final ByteString.Companion lock;
    public final PreviewView.AnonymousClass1 map;
    public final int maxSize;
    public int missCount;
    public int size;

    public LruCache(int i) {
        this.maxSize = i;
        if (i <= 0) {
            RuntimeHelpersKt.throwIllegalArgumentException("maxSize <= 0");
            throw null;
        }
        this.map = new PreviewView.AnonymousClass1(20);
        this.lock = new ByteString.Companion(5);
    }

    public final Object get(Object obj) {
        synchronized (this.lock) {
            Object obj2 = ((LinkedHashMap) this.map.this$0).get(obj);
            if (obj2 != null) {
                this.hitCount++;
                return obj2;
            }
            this.missCount++;
            return null;
        }
    }

    public final Object put(Object obj, Object obj2) {
        Object objPut;
        synchronized (this.lock) {
            try {
                this.size += safeSizeOf(obj, obj2);
                objPut = ((LinkedHashMap) this.map.this$0).put(obj, obj2);
                if (objPut != null) {
                    this.size -= safeSizeOf(obj, objPut);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (objPut != null) {
            entryRemoved(obj, objPut, obj2);
        }
        trimToSize(this.maxSize);
        return objPut;
    }

    public final Object remove(Object obj) {
        Object objRemove;
        synchronized (this.lock) {
            try {
                objRemove = ((LinkedHashMap) this.map.this$0).remove(obj);
                if (objRemove != null) {
                    this.size -= safeSizeOf(obj, objRemove);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (objRemove != null) {
            entryRemoved(obj, objRemove, null);
        }
        return objRemove;
    }

    public final int safeSizeOf(Object obj, Object obj2) {
        int iSizeOf = sizeOf(obj, obj2);
        if (iSizeOf >= 0) {
            return iSizeOf;
        }
        throw new IllegalStateException("Negative size: " + obj + '=' + obj2);
    }

    public int sizeOf(Object obj, Object obj2) {
        return 1;
    }

    public final String toString() {
        String str;
        synchronized (this.lock) {
            try {
                int i = this.hitCount;
                int i2 = this.missCount + i;
                str = "LruCache[maxSize=" + this.maxSize + ",hits=" + this.hitCount + ",misses=" + this.missCount + ",hitRate=" + (i2 != 0 ? (i * 100) / i2 : 0) + "%]";
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    public final void trimToSize(int i) {
        Object next;
        Object key;
        Object value;
        while (true) {
            synchronized (this.lock) {
                try {
                    if (this.size < 0 || (((LinkedHashMap) this.map.this$0).isEmpty() && this.size != 0)) {
                        break;
                    }
                    if (this.size > i && !((LinkedHashMap) this.map.this$0).isEmpty()) {
                        Set setEntrySet = ((LinkedHashMap) this.map.this$0).entrySet();
                        if (setEntrySet instanceof List) {
                            List list = (List) setEntrySet;
                            next = list.isEmpty() ? null : list.get(0);
                        } else {
                            Iterator it = setEntrySet.iterator();
                            if (it.hasNext()) {
                                next = it.next();
                            }
                        }
                        Map.Entry entry = (Map.Entry) next;
                        if (entry == null) {
                            return;
                        }
                        key = entry.getKey();
                        value = entry.getValue();
                        ((LinkedHashMap) this.map.this$0).remove(key);
                        this.size -= safeSizeOf(key, value);
                    }
                    return;
                } catch (Throwable th) {
                    throw th;
                }
            }
            entryRemoved(key, value, null);
        }
        throw new IllegalStateException("LruCache.sizeOf() is reporting inconsistent results!");
    }

    public void entryRemoved(Object obj, Object obj2, Object obj3) {
    }
}
