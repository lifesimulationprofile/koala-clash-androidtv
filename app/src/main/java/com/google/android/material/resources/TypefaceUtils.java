package com.google.android.material.resources;

import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class TypefaceUtils {
    /* JADX WARN: Code duplicated, block: B:10:0x0021 A[PHI: r0
      0x0021: PHI (r0v7 int) = (r0v4 int), (r0v5 int) binds: [B:9:0x001f, B:12:0x0025] A[DONT_GENERATE, DONT_INLINE]] */
    public static Typeface maybeCopyWithFontWeightAdjustment(Configuration configuration, Typeface typeface) {
        if (Build.VERSION.SDK_INT < 31 || configuration.fontWeightAdjustment == Integer.MAX_VALUE || configuration.fontWeightAdjustment == 0) {
            return null;
        }
        int weight = configuration.fontWeightAdjustment + typeface.getWeight();
        int i = 1;
        if (weight < 1) {
            weight = i;
        } else {
            i = 1000;
            if (weight > 1000) {
                weight = i;
            }
        }
        return Typeface.create(typeface, weight, typeface.isItalic());
    }
}
