package androidx.compose.material3;

import androidx.compose.runtime.internal.ComposableLambdaImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FadeInFadeOutAnimationItem {
    public final Object key;
    public final ComposableLambdaImpl transition;

    public FadeInFadeOutAnimationItem(SnackbarHostState.SnackbarDataImpl snackbarDataImpl, ComposableLambdaImpl composableLambdaImpl) {
        this.key = snackbarDataImpl;
        this.transition = composableLambdaImpl;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FadeInFadeOutAnimationItem)) {
            return false;
        }
        FadeInFadeOutAnimationItem fadeInFadeOutAnimationItem = (FadeInFadeOutAnimationItem) obj;
        return Intrinsics.areEqual(this.key, fadeInFadeOutAnimationItem.key) && this.transition.equals(fadeInFadeOutAnimationItem.transition);
    }

    public final int hashCode() {
        Object obj = this.key;
        return this.transition.hashCode() + ((obj == null ? 0 : obj.hashCode()) * 31);
    }

    public final String toString() {
        return "FadeInFadeOutAnimationItem(key=" + this.key + ", transition=" + this.transition + ')';
    }
}
