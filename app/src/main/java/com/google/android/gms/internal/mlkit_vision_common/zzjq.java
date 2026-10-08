package com.google.android.gms.internal.mlkit_vision_common;

import android.content.Context;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import coil.network.HttpException;
import com.github.kr328.clash.design.compose.theme.ThemeState;
import com.github.kr328.clash.design.model.DarkMode;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzjq {
    /* JADX WARN: Code duplicated, block: B:4:0x0013  */
    public static final boolean isInDarkTheme(GapComposer gapComposer) {
        boolean z;
        gapComposer.startReplaceGroup(-986042636);
        DarkMode darkMode = (DarkMode) ThemeState.state$delegate.getValue();
        if (darkMode == DarkMode.ForceLight) {
            z = false;
        } else {
            z = true;
            if (darkMode != DarkMode.ForceDark) {
                if (darkMode != DarkMode.Auto) {
                    throw new HttpException();
                }
                gapComposer.consume(AndroidCompositionLocals_androidKt.LocalConfiguration);
                if ((((Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext)).getResources().getConfiguration().uiMode & 48) != 32) {
                    z = false;
                }
            }
        }
        gapComposer.end(false);
        return z;
    }
}
