package com.github.kr328.clash.design.util;

import android.content.res.Configuration;
import android.os.Build;
import com.github.kr328.clash.LogcatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class I18nKt {
    public static String format$default(Date date, LogcatActivity logcatActivity, int i) {
        boolean z = (i & 2) != 0;
        Configuration configuration = logcatActivity.getResources().getConfiguration();
        Locale locale = Build.VERSION.SDK_INT >= 24 ? configuration.getLocales().get(0) : configuration.locale;
        if (z) {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", locale).format(date);
        }
        return z ? new SimpleDateFormat("yyyy-MM-dd", locale).format(date) : new SimpleDateFormat("HH:mm:ss.SSS", locale).format(date);
    }
}
