package androidx.camera.core.internal.compat.quirk;

import androidx.appcompat.widget.Toolbar;
import androidx.camera.core.imagecapture.CaptureNode$$ExternalSyntheticLambda0;
import androidx.camera.core.impl.QuirkSettingsHolder;
import androidx.camera.core.impl.Quirks;
import kotlin.text.HexFormatKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class DeviceQuirks {
    public static volatile Quirks sQuirks;

    static {
        QuirkSettingsHolder quirkSettingsHolder = QuirkSettingsHolder.sInstance;
        quirkSettingsHolder.mObservable.addObserver(HexFormatKt.directExecutor(), new Toolbar.AnonymousClass1(18, new CaptureNode$$ExternalSyntheticLambda0(3)));
    }
}
