package androidx.compose.foundation.relocation;

import androidx.compose.ui.Modifier;

/* JADX INFO: loaded from: classes.dex */
public abstract class BringIntoViewRequesterKt {
    public static final Modifier bringIntoViewRequester(Modifier modifier, BringIntoViewRequesterImpl bringIntoViewRequesterImpl) {
        return modifier.then(new BringIntoViewRequesterElement(bringIntoViewRequesterImpl));
    }
}
