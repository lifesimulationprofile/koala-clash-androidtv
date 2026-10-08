package androidx.compose.foundation.layout;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class WrapContentElement extends ModifierNodeElement {
    public final Object align;
    public final Function2 alignmentCallback;
    public final int direction;

    public WrapContentElement(int i, Function2 function2, Object obj) {
        this.direction = i;
        this.alignmentCallback = function2;
        this.align = obj;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Modifier.Node create() {
        WrapContentNode wrapContentNode = new WrapContentNode();
        wrapContentNode.direction = this.direction;
        wrapContentNode.alignmentCallback = this.alignmentCallback;
        return wrapContentNode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || WrapContentElement.class != obj.getClass()) {
            return false;
        }
        WrapContentElement wrapContentElement = (WrapContentElement) obj;
        return this.direction == wrapContentElement.direction && this.align.equals(wrapContentElement.align);
    }

    public final int hashCode() {
        return this.align.hashCode() + (((CaptureSession$State$EnumUnboxingLocalUtility.ordinal(this.direction) * 31) + 1237) * 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final void update(Modifier.Node node) {
        WrapContentNode wrapContentNode = (WrapContentNode) node;
        wrapContentNode.direction = this.direction;
        wrapContentNode.alignmentCallback = this.alignmentCallback;
    }
}
