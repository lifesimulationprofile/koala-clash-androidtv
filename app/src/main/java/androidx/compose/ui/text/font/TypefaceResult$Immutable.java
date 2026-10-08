package androidx.compose.ui.text.font;

import android.graphics.Typeface;
import androidx.compose.runtime.State;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TypefaceResult$Immutable implements State {
    public final boolean cacheable = true;
    public final Object value;

    public TypefaceResult$Immutable(Typeface typeface) {
        this.value = typeface;
    }

    @Override // androidx.compose.runtime.State
    public final Object getValue() {
        return this.value;
    }
}
