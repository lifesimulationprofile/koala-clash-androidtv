package androidx.compose.ui.res;

import android.content.res.Resources;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class StringResources_androidKt {
    public static final String stringResource(int i, GapComposer gapComposer) {
        return ((Resources) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalResources)).getString(i);
    }
}
