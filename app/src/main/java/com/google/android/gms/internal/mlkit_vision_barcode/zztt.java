package com.google.android.gms.internal.mlkit_vision_barcode;

import android.content.Context;
import android.os.Build;
import androidx.compose.ui.platform.AndroidUriHandler;
import androidx.compose.ui.text.font.AndroidFontResolveInterceptor;
import androidx.compose.ui.text.font.FontFamilyResolverImpl;
import androidx.compose.ui.text.font.FontWeightAdjustmentHelperApi31;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zztt {
    public static final FontFamilyResolverImpl createFontFamilyResolver(Context context) {
        return new FontFamilyResolverImpl(new AndroidUriHandler(context, 2), new AndroidFontResolveInterceptor(Build.VERSION.SDK_INT >= 31 ? FontWeightAdjustmentHelperApi31.INSTANCE.fontWeightAdjustment(context) : 0));
    }
}
