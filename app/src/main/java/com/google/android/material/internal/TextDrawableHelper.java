package com.google.android.material.internal;

import android.text.TextPaint;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipDrawable;
import com.google.android.material.resources.TextAppearance;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TextDrawableHelper {
    public final WeakReference delegate;
    public TextAppearance textAppearance;
    public float textWidth;
    public final TextPaint textPaint = new TextPaint(1);
    public final Chip.AnonymousClass1 fontCallback = new Chip.AnonymousClass1(1, this);
    public boolean textWidthDirty = true;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public interface TextDrawableDelegate {
        int[] getState();
    }

    public TextDrawableHelper(ChipDrawable chipDrawable) {
        this.delegate = new WeakReference(null);
        this.delegate = new WeakReference(chipDrawable);
    }
}
