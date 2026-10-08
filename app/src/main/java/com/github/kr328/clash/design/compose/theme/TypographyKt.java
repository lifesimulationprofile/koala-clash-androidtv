package com.github.kr328.clash.design.compose.theme;

import androidx.compose.material3.Typography;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.TextUnitKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class TypographyKt {
    public static final Typography AppTypography;

    static {
        FontWeight fontWeight = FontWeight.Bold;
        TextStyle textStyle = new TextStyle(0L, TextUnitKt.getSp(22), fontWeight, 0L, 0, TextUnitKt.getSp(28), 16646137);
        TextStyle textStyle2 = new TextStyle(0L, TextUnitKt.getSp(18), fontWeight, 0L, 0, TextUnitKt.getSp(24), 16646137);
        FontWeight fontWeight2 = FontWeight.Medium;
        TextStyle textStyle3 = new TextStyle(0L, TextUnitKt.getSp(16), fontWeight2, 0L, 0, TextUnitKt.getSp(22), 16646137);
        FontWeight fontWeight3 = FontWeight.Normal;
        AppTypography = new Typography(textStyle, textStyle2, textStyle3, new TextStyle(0L, TextUnitKt.getSp(16), fontWeight3, 0L, 0, TextUnitKt.getSp(22), 16646137), new TextStyle(0L, TextUnitKt.getSp(14), fontWeight3, 0L, 0, TextUnitKt.getSp(20), 16646137), new TextStyle(0L, TextUnitKt.getSp(13), fontWeight2, 0L, 0, TextUnitKt.getSp(18), 16646137), new TextStyle(0L, TextUnitKt.getSp(14), fontWeight2, 0L, 0, TextUnitKt.getSp(20), 16646137), new TextStyle(0L, TextUnitKt.getSp(12), fontWeight2, 0L, 0, TextUnitKt.getSp(16), 16646137), new TextStyle(0L, TextUnitKt.getSp(11), FontWeight.SemiBold, 0L, 0, TextUnitKt.getSp(16), 16646137), 63);
    }
}
