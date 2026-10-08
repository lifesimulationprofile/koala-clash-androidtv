package androidx.compose.foundation;

import android.view.View;
import androidx.compose.ui.unit.Density;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public interface PlatformMagnifierFactory {
    /* JADX INFO: renamed from: create-nHHXs2Y, reason: not valid java name */
    PlatformMagnifier mo58createnHHXs2Y(View view, Density density);

    boolean getCanUpdateZoom();
}
