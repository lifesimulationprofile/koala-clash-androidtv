package com.google.android.material.resources;

import android.graphics.Typeface;
import com.google.android.gms.internal.mlkit_vision_common.zzlp;
import com.google.android.material.internal.CollapsingTextHelper;
import okhttp3.ConnectionPool;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CancelableFontCallback extends zzlp {
    public final ConnectionPool applyFont;
    public boolean cancelled;
    public final Typeface fallbackFont;

    public CancelableFontCallback(ConnectionPool connectionPool, Typeface typeface) {
        this.fallbackFont = typeface;
        this.applyFont = connectionPool;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzlp
    public final void onFontRetrievalFailed(int i) {
        if (this.cancelled) {
            return;
        }
        CollapsingTextHelper collapsingTextHelper = (CollapsingTextHelper) this.applyFont.delegate;
        if (collapsingTextHelper.setCollapsedTypefaceInternal(this.fallbackFont)) {
            collapsingTextHelper.recalculate(false);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzlp
    public final void onFontRetrieved(Typeface typeface, boolean z) {
        if (this.cancelled) {
            return;
        }
        CollapsingTextHelper collapsingTextHelper = (CollapsingTextHelper) this.applyFont.delegate;
        if (collapsingTextHelper.setCollapsedTypefaceInternal(typeface)) {
            collapsingTextHelper.recalculate(false);
        }
    }
}
