package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Build;
import android.text.Spannable;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LocaleSpan;
import android.text.style.RelativeSizeSpan;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.intl.PlatformLocaleKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import androidx.core.os.LocaleListPlatformWrapper$$ExternalSyntheticApiModelOutline0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zztz {
    /* JADX INFO: renamed from: resolveLineHeightInPx-o2QH7mI, reason: not valid java name */
    public static final float m816resolveLineHeightInPxo2QH7mI(long j, float f, Density density) {
        float fM727getValueimpl;
        long jM726getTypeUIouoOA = TextUnit.m726getTypeUIouoOA(j);
        if (TextUnitType.m731equalsimpl0(jM726getTypeUIouoOA, 4294967296L)) {
            if (density.getFontScale() <= 1.05d) {
                return density.mo91toPxR2X_6o(j);
            }
            fM727getValueimpl = TextUnit.m727getValueimpl(j) / TextUnit.m727getValueimpl(density.mo94toSpkPz2Gy4(f));
        } else {
            if (!TextUnitType.m731equalsimpl0(jM726getTypeUIouoOA, 8589934592L)) {
                return Float.NaN;
            }
            fM727getValueimpl = TextUnit.m727getValueimpl(j);
        }
        return fM727getValueimpl * f;
    }

    /* JADX INFO: renamed from: setColor-RPmYEkk, reason: not valid java name */
    public static final void m817setColorRPmYEkk(Spannable spannable, long j, int i, int i2) {
        if (j != 16) {
            spannable.setSpan(new ForegroundColorSpan(BrushKt.m426toArgb8_81llA(j)), i, i2, 33);
        }
    }

    /* JADX INFO: renamed from: setFontSize-KmRG4DE, reason: not valid java name */
    public static final void m818setFontSizeKmRG4DE(Spannable spannable, long j, Density density, int i, int i2) {
        long jM726getTypeUIouoOA = TextUnit.m726getTypeUIouoOA(j);
        if (TextUnitType.m731equalsimpl0(jM726getTypeUIouoOA, 4294967296L)) {
            spannable.setSpan(new AbsoluteSizeSpan(MathKt.roundToInt(density.mo91toPxR2X_6o(j)), false), i, i2, 33);
        } else if (TextUnitType.m731equalsimpl0(jM726getTypeUIouoOA, 8589934592L)) {
            spannable.setSpan(new RelativeSizeSpan(TextUnit.m727getValueimpl(j)), i, i2, 33);
        }
    }

    public static final void setLocaleList(Spannable spannable, LocaleList localeList, int i, int i2) {
        LocaleSpan localeSpan;
        if (localeList != null) {
            List list = localeList.localeList;
            if (Build.VERSION.SDK_INT >= 24) {
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(localeList, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(((Locale) it.next()).platformLocale);
                }
                java.util.Locale[] localeArr = (java.util.Locale[]) arrayList.toArray(new java.util.Locale[0]);
                localeSpan = LocaleListPlatformWrapper$$ExternalSyntheticApiModelOutline0.m745m(LocaleListPlatformWrapper$$ExternalSyntheticApiModelOutline0.m((java.util.Locale[]) Arrays.copyOf(localeArr, localeArr.length)));
            } else {
                localeSpan = new LocaleSpan((list.isEmpty() ? PlatformLocaleKt.platformLocaleDelegate.getCurrent().get() : localeList.get()).platformLocale);
            }
            spannable.setSpan(localeSpan, i, i2, 33);
        }
    }
}
