package io.github.g00fy2.quickie.config;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.zzb;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ParcelableScannerConfig implements Parcelable {
    public static final Parcelable.Creator<ParcelableScannerConfig> CREATOR = new zzb(9);
    public final Integer drawableRes;
    public final int[] formats;
    public final boolean hapticFeedback;
    public final float horizontalFrameRatio;
    public final boolean keepScreenOn;
    public final boolean showCloseButton;
    public final boolean showTorchToggle;
    public final int stringRes;
    public final boolean useFrontCamera;

    public ParcelableScannerConfig(int[] iArr, int i, Integer num, boolean z, boolean z2, float f, boolean z3, boolean z4, boolean z5) {
        this.formats = iArr;
        this.stringRes = i;
        this.drawableRes = num;
        this.hapticFeedback = z;
        this.showTorchToggle = z2;
        this.horizontalFrameRatio = f;
        this.useFrontCamera = z3;
        this.showCloseButton = z4;
        this.keepScreenOn = z5;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iIntValue;
        parcel.writeIntArray(this.formats);
        parcel.writeInt(this.stringRes);
        Integer num = this.drawableRes;
        if (num == null) {
            iIntValue = 0;
        } else {
            parcel.writeInt(1);
            iIntValue = num.intValue();
        }
        parcel.writeInt(iIntValue);
        parcel.writeInt(this.hapticFeedback ? 1 : 0);
        parcel.writeInt(this.showTorchToggle ? 1 : 0);
        parcel.writeFloat(this.horizontalFrameRatio);
        parcel.writeInt(this.useFrontCamera ? 1 : 0);
        parcel.writeInt(this.showCloseButton ? 1 : 0);
        parcel.writeInt(this.keepScreenOn ? 1 : 0);
    }
}
