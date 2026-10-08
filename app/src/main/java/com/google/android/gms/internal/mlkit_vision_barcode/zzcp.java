package com.google.android.gms.internal.mlkit_vision_barcode;

import androidx.appcompat.widget.ActionBarContextView;
import androidx.core.view.ViewPropertyAnimatorListener;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzcp implements ViewPropertyAnimatorListener {
    public Object zza = new Object[4];
    public int zzb = 0;
    public boolean zzc;

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationCancel() {
        this.zzc = true;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationEnd() {
        if (this.zzc) {
            return;
        }
        ActionBarContextView actionBarContextView = (ActionBarContextView) this.zza;
        actionBarContextView.mVisibilityAnim = null;
        super/*android.view.ViewGroup*/.setVisibility(this.zzb);
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationStart() {
        super/*android.view.ViewGroup*/.setVisibility(0);
        this.zzc = false;
    }

    public void zza$com$google$android$gms$internal$mlkit_vision_barcode$zzcl(Object obj) {
        obj.getClass();
        zzd(this.zzb + 1);
        Object[] objArr = (Object[]) this.zza;
        int i = this.zzb;
        this.zzb = i + 1;
        objArr[i] = obj;
    }

    public void zzd(int i) {
        Object[] objArr = (Object[]) this.zza;
        int length = objArr.length;
        if (length >= i) {
            if (this.zzc) {
                this.zza = (Object[]) objArr.clone();
                this.zzc = false;
                return;
            }
            return;
        }
        int i2 = length + (length >> 1) + 1;
        if (i2 < i) {
            int iHighestOneBit = Integer.highestOneBit(i - 1);
            i2 = iHighestOneBit + iHighestOneBit;
        }
        if (i2 < 0) {
            i2 = Integer.MAX_VALUE;
        }
        this.zza = Arrays.copyOf(objArr, i2);
        this.zzc = false;
    }

    public zzdk zzf() {
        this.zzc = true;
        Object[] objArr = (Object[]) this.zza;
        int i = this.zzb;
        zzcq zzcqVar = zzcs.zza;
        return i == 0 ? zzdk.zza : new zzdk(i, objArr);
    }
}
