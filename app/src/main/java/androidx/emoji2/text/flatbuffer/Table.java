package androidx.emoji2.text.flatbuffer;

import android.os.Build;
import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import coil.network.EmptyNetworkObserver;
import java.nio.ByteBuffer;
import java.util.ConcurrentModificationException;
import kotlin.collections.builders.MapBuilder;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class Table {
    public Object bb;
    public int bb_pos;
    public int vtable_size;
    public int vtable_start;

    public Table() {
        if (EmptyNetworkObserver.DEFAULT == null) {
            EmptyNetworkObserver.DEFAULT = new EmptyNetworkObserver();
        }
    }

    public int __offset(int i) {
        if (i < this.vtable_size) {
            return ((ByteBuffer) this.bb).getShort(this.vtable_start + i);
        }
        return 0;
    }

    public void checkForComodification$kotlin_stdlib() {
        if (((MapBuilder) this.bb).modCount != this.vtable_size) {
            throw new ConcurrentModificationException();
        }
    }

    public abstract Object frameworkGet(View view);

    public abstract void frameworkSet(View view, Object obj);

    public boolean hasNext() {
        return this.bb_pos < ((MapBuilder) this.bb).length;
    }

    public void initNext$kotlin_stdlib() {
        while (true) {
            int i = this.bb_pos;
            MapBuilder mapBuilder = (MapBuilder) this.bb;
            if (i >= mapBuilder.length || mapBuilder.presenceArray[i] >= 0) {
                return;
            } else {
                this.bb_pos = i + 1;
            }
        }
    }

    public void remove() {
        MapBuilder mapBuilder = (MapBuilder) this.bb;
        checkForComodification$kotlin_stdlib();
        if (this.vtable_start == -1) {
            throw new IllegalStateException("Call next() before removing element from the iterator.");
        }
        mapBuilder.checkIsMutable$kotlin_stdlib();
        mapBuilder.removeEntryAt(this.vtable_start);
        this.vtable_start = -1;
        this.vtable_size = mapBuilder.modCount;
    }

    public void set(View view, Object obj) {
        Object tag;
        AccessibilityDelegateCompat accessibilityDelegateCompat;
        if (Build.VERSION.SDK_INT >= this.vtable_start) {
            frameworkSet(view, obj);
            return;
        }
        if (Build.VERSION.SDK_INT >= this.vtable_start) {
            tag = frameworkGet(view);
        } else {
            tag = view.getTag(this.bb_pos);
            if (!((Class) this.bb).isInstance(tag)) {
                tag = null;
            }
        }
        if (shouldUpdate(tag, obj)) {
            View.AccessibilityDelegate accessibilityDelegateInternal = ViewCompat.getAccessibilityDelegateInternal(view);
            if (accessibilityDelegateInternal == null) {
                accessibilityDelegateCompat = null;
            } else {
                accessibilityDelegateCompat = accessibilityDelegateInternal instanceof AccessibilityDelegateCompat.AccessibilityDelegateAdapter ? ((AccessibilityDelegateCompat.AccessibilityDelegateAdapter) accessibilityDelegateInternal).mCompat : new AccessibilityDelegateCompat(accessibilityDelegateInternal);
            }
            if (accessibilityDelegateCompat == null) {
                accessibilityDelegateCompat = new AccessibilityDelegateCompat();
            }
            ViewCompat.setAccessibilityDelegate(view, accessibilityDelegateCompat);
            view.setTag(this.bb_pos, obj);
            ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view, this.vtable_size);
        }
    }

    public abstract boolean shouldUpdate(Object obj, Object obj2);
}
