package androidx.compose.ui.graphics.colorspace;

import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ConnectorKt {
    public static final MutableIntObjectMap Connectors;

    static {
        Rgb rgb = ColorSpaces.Srgb;
        int i = rgb.id;
        Connector$Companion$identity$1 connector$Companion$identity$1 = new Connector$Companion$identity$1(rgb, rgb, 1);
        int i2 = rgb.id;
        Oklab oklab = ColorSpaces.Oklab;
        int i3 = (oklab.id << 6) | i2;
        Connector connector = new Connector(rgb, oklab, 0);
        int i4 = (i2 << 6) | oklab.id;
        Connector connector2 = new Connector(oklab, rgb, 0);
        MutableIntObjectMap mutableIntObjectMap = IntObjectMapKt.EmptyIntObjectMap;
        MutableIntObjectMap mutableIntObjectMap2 = new MutableIntObjectMap();
        mutableIntObjectMap2.set(i | (i << 6), connector$Companion$identity$1);
        mutableIntObjectMap2.set(i3, connector);
        mutableIntObjectMap2.set(i4, connector2);
        Connectors = mutableIntObjectMap2;
    }
}
