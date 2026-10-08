package androidx.compose.ui.window;

import androidx.compose.runtime.DynamicProvidableCompositionLocal;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class PopupProperties {
    public final boolean dismissOnBackPress;
    public final boolean dismissOnClickOutside;
    public final boolean excludeFromSystemGesture;
    public final int flags;
    public final boolean inheritSecurePolicy;
    public final int windowType;

    public PopupProperties(int i, boolean z) {
        this(1, (i & 1) != 0 ? false : z, (i & 8) != 0);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PopupProperties)) {
            return false;
        }
        PopupProperties popupProperties = (PopupProperties) obj;
        return this.flags == popupProperties.flags && this.inheritSecurePolicy == popupProperties.inheritSecurePolicy && this.dismissOnBackPress == popupProperties.dismissOnBackPress && this.dismissOnClickOutside == popupProperties.dismissOnClickOutside && this.excludeFromSystemGesture == popupProperties.excludeFromSystemGesture && this.windowType == popupProperties.windowType;
    }

    public final int hashCode() {
        return ((((((((((((this.flags * 31) + (this.inheritSecurePolicy ? 1231 : 1237)) * 31) + (this.dismissOnBackPress ? 1231 : 1237)) * 31) + (this.dismissOnClickOutside ? 1231 : 1237)) * 31) + (this.excludeFromSystemGesture ? 1231 : 1237)) * 31) + 1237) * 31) + this.windowType) * 31;
    }

    public PopupProperties(int i, boolean z, boolean z2) {
        DynamicProvidableCompositionLocal dynamicProvidableCompositionLocal = AndroidPopup_androidKt.LocalPopupTestTag;
        int i2 = !z ? 262152 : 262144;
        i2 = i == 2 ? i2 | 8192 : i2;
        i2 = z2 ? i2 : i2 | 512;
        boolean z3 = i == 1;
        this.flags = i2;
        this.inheritSecurePolicy = z3;
        this.dismissOnBackPress = true;
        this.dismissOnClickOutside = true;
        this.excludeFromSystemGesture = true;
        this.windowType = 1002;
    }
}
