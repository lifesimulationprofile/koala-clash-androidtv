package androidx.vectordrawable.graphics.drawable;

import android.animation.TypeEvaluator;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ArgbEvaluator implements TypeEvaluator {
    public static final ArgbEvaluator sInstance = new ArgbEvaluator();

    @Override // android.animation.TypeEvaluator
    public final Object evaluate(float f, Object obj, Object obj2) {
        int iIntValue = ((Integer) obj).intValue();
        float f2 = ((iIntValue >> 24) & 255) / 255.0f;
        int iIntValue2 = ((Integer) obj2).intValue();
        float f3 = ((iIntValue2 >> 24) & 255) / 255.0f;
        float fPow = (float) Math.pow(((iIntValue >> 16) & 255) / 255.0f, 2.2d);
        float fPow2 = (float) Math.pow(((iIntValue >> 8) & 255) / 255.0f, 2.2d);
        float fPow3 = (float) Math.pow((iIntValue & 255) / 255.0f, 2.2d);
        float fPow4 = (float) Math.pow(((iIntValue2 >> 16) & 255) / 255.0f, 2.2d);
        float fPow5 = (float) Math.pow(((iIntValue2 >> 8) & 255) / 255.0f, 2.2d);
        float fPow6 = (float) Math.pow((iIntValue2 & 255) / 255.0f, 2.2d);
        float fM = ImageAnalysis$$ExternalSyntheticLambda1.m(f3, f2, f, f2);
        float fM2 = ImageAnalysis$$ExternalSyntheticLambda1.m(fPow4, fPow, f, fPow);
        float fM3 = ImageAnalysis$$ExternalSyntheticLambda1.m(fPow5, fPow2, f, fPow2);
        float fM4 = ImageAnalysis$$ExternalSyntheticLambda1.m(fPow6, fPow3, f, fPow3);
        float fPow7 = ((float) Math.pow(fM2, 0.45454545454545453d)) * 255.0f;
        float fPow8 = ((float) Math.pow(fM3, 0.45454545454545453d)) * 255.0f;
        return Integer.valueOf(Math.round(((float) Math.pow(fM4, 0.45454545454545453d)) * 255.0f) | (Math.round(fPow7) << 16) | (Math.round(fM * 255.0f) << 24) | (Math.round(fPow8) << 8));
    }
}
