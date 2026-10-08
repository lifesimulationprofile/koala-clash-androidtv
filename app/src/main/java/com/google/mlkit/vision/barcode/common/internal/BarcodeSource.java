package com.google.mlkit.vision.barcode.common.internal;

import android.graphics.Point;
import android.graphics.Rect;
import androidx.appcompat.widget.TooltipPopup;
import androidx.room.RoomOpenHelper;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.mlkit.vision.barcode.common.Barcode;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public interface BarcodeSource {
    Rect getBoundingBox();

    TooltipPopup getCalendarEvent();

    TooltipPopup getContactInfo();

    Point[] getCornerPoints();

    Barcode.Email getEmail();

    int getFormat();

    Barcode.GeoPoint getGeoPoint();

    Barcode.Phone getPhone();

    byte[] getRawBytes();

    String getRawValue();

    GmsLogger getSms();

    GmsLogger getUrl();

    int getValueType();

    RoomOpenHelper getWifi();
}
