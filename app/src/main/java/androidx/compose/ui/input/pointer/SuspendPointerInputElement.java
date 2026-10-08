package androidx.compose.ui.input.pointer;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SuspendPointerInputElement extends ModifierNodeElement {
    public final Object key1;
    public final Object key2;
    public final PointerInputEventHandler pointerInputEventHandler;

    public SuspendPointerInputElement(Object obj, Object obj2, PointerInputEventHandler pointerInputEventHandler, int i) {
        obj2 = (i & 2) != 0 ? null : obj2;
        this.key1 = obj;
        this.key2 = obj2;
        this.pointerInputEventHandler = pointerInputEventHandler;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        return new SuspendingPointerInputModifierNodeImpl(this.key1, this.key2, this.pointerInputEventHandler);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuspendPointerInputElement)) {
            return false;
        }
        SuspendPointerInputElement suspendPointerInputElement = (SuspendPointerInputElement) obj;
        return Intrinsics.areEqual(this.key1, suspendPointerInputElement.key1) && Intrinsics.areEqual(this.key2, suspendPointerInputElement.key2) && this.pointerInputEventHandler == suspendPointerInputElement.pointerInputEventHandler;
    }

    public final int hashCode() {
        Object obj = this.key1;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Object obj2 = this.key2;
        return this.pointerInputEventHandler.hashCode() + ((iHashCode + (obj2 != null ? obj2.hashCode() : 0)) * 961);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImpl = (SuspendingPointerInputModifierNodeImpl) node;
        Object obj = suspendingPointerInputModifierNodeImpl.key1;
        Object obj2 = this.key1;
        boolean z = !Intrinsics.areEqual(obj, obj2);
        suspendingPointerInputModifierNodeImpl.key1 = obj2;
        Object obj3 = suspendingPointerInputModifierNodeImpl.key2;
        Object obj4 = this.key2;
        if (!Intrinsics.areEqual(obj3, obj4)) {
            z = true;
        }
        suspendingPointerInputModifierNodeImpl.key2 = obj4;
        Class<?> cls = suspendingPointerInputModifierNodeImpl._pointerInputEventHandler.getClass();
        PointerInputEventHandler pointerInputEventHandler = this.pointerInputEventHandler;
        if (cls == pointerInputEventHandler.getClass() ? z : true) {
            suspendingPointerInputModifierNodeImpl.resetPointerInputHandler();
        }
        suspendingPointerInputModifierNodeImpl._pointerInputEventHandler = pointerInputEventHandler;
    }
}
