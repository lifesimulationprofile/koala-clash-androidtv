package com.google.android.gms.internal.mlkit_vision_common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.Modifier;
import coil.network.HttpException;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzko {
    public static byte[] createByteArray(Parcel parcel, int i) {
        int size = readSize(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (size == 0) {
            return null;
        }
        byte[] bArrCreateByteArray = parcel.createByteArray();
        parcel.setDataPosition(iDataPosition + size);
        return bArrCreateByteArray;
    }

    public static Parcelable createParcelable(int i, Parcel parcel, Parcelable.Creator creator) {
        int size = readSize(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (size == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + size);
        return parcelable;
    }

    public static String createString(Parcel parcel, int i) {
        int size = readSize(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (size == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + size);
        return string;
    }

    public static String[] createStringArray(Parcel parcel, int i) {
        int size = readSize(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (size == 0) {
            return null;
        }
        String[] strArrCreateStringArray = parcel.createStringArray();
        parcel.setDataPosition(iDataPosition + size);
        return strArrCreateStringArray;
    }

    public static Object[] createTypedArray(int i, Parcel parcel, Parcelable.Creator creator) {
        int size = readSize(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (size == 0) {
            return null;
        }
        Object[] objArrCreateTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(iDataPosition + size);
        return objArrCreateTypedArray;
    }

    public static ArrayList createTypedList(int i, Parcel parcel, Parcelable.Creator creator) {
        int size = readSize(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (size == 0) {
            return null;
        }
        ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(iDataPosition + size);
        return arrayListCreateTypedArrayList;
    }

    public static void ensureAtEnd(Parcel parcel, int i) {
        if (parcel.dataPosition() != i) {
            throw new HttpException(ImageAnalysis$$ExternalSyntheticLambda1.m("Overread allowed size end=", i), parcel);
        }
    }

    public static boolean readBoolean(Parcel parcel, int i) {
        zzb(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static double readDouble(Parcel parcel, int i) {
        zzb(parcel, i, 8);
        return parcel.readDouble();
    }

    public static int readInt(Parcel parcel, int i) {
        zzb(parcel, i, 4);
        return parcel.readInt();
    }

    public static long readLong(Parcel parcel, int i) {
        zzb(parcel, i, 8);
        return parcel.readLong();
    }

    public static int readSize(Parcel parcel, int i) {
        return (i & (-65536)) != -65536 ? (char) (i >> 16) : parcel.readInt();
    }

    public static void skipUnknownField(Parcel parcel, int i) {
        parcel.setDataPosition(parcel.dataPosition() + readSize(parcel, i));
    }

    public static int validateObjectHeader(Parcel parcel) {
        int i = parcel.readInt();
        int size = readSize(parcel, i);
        char c = (char) i;
        int iDataPosition = parcel.dataPosition();
        if (c != 20293) {
            throw new HttpException("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(i))), parcel);
        }
        int i2 = size + iDataPosition;
        if (i2 < iDataPosition || i2 > parcel.dataSize()) {
            throw new HttpException(Modifier.CC.m(iDataPosition, i2, "Size read is invalid start=", " end="), parcel);
        }
        return i2;
    }

    public static void zzb(Parcel parcel, int i, int i2) {
        int size = readSize(parcel, i);
        if (size == i2) {
            return;
        }
        String hexString = Integer.toHexString(size);
        StringBuilder sb = new StringBuilder("Expected size ");
        sb.append(i2);
        sb.append(" got ");
        sb.append(size);
        sb.append(" (0x");
        throw new HttpException(ImageAnalysis$$ExternalSyntheticLambda1.m(sb, hexString, ")"), parcel);
    }
}
