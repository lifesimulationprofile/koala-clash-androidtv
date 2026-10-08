package coil.util;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.Preview3AThreadCrashQuirk;
import androidx.camera.camera2.internal.compat.quirk.StillCaptureFlashStopRepeatingQuirk;
import androidx.camera.camera2.internal.compat.quirk.TorchIsClosedAfterImageCapturingQuirk;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.internal.compat.quirk.SurfaceOrderQuirk;
import coil.intercept.RealInterceptorChain;
import coil.size.Size;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ImmutableHardwareBitmapService implements HardwareBitmapService {
    public final boolean allowHardware;

    public ImmutableHardwareBitmapService(Quirks quirks) {
        this.allowHardware = quirks.contains(Preview3AThreadCrashQuirk.class);
    }

    public static CaptureConfig createTorchResetRequest(CaptureConfig captureConfig) {
        RealInterceptorChain realInterceptorChain = new RealInterceptorChain();
        realInterceptorChain.index = captureConfig.mTemplateType;
        Iterator it = Collections.unmodifiableList(captureConfig.mSurfaces).iterator();
        while (it.hasNext()) {
            ((HashSet) realInterceptorChain.initialRequest).add((DeferrableSurface) it.next());
        }
        realInterceptorChain.addImplementationOptions(captureConfig.mImplementationOptions);
        MutableOptionsBundle mutableOptionsBundleCreate = MutableOptionsBundle.create();
        mutableOptionsBundleCreate.insertOption(Camera2ImplConfig.createCaptureRequestOption(CaptureRequest.FLASH_MODE), 0);
        realInterceptorChain.addImplementationOptions(new Camera2ImplConfig(14, OptionsBundle.from(mutableOptionsBundleCreate)));
        return realInterceptorChain.build();
    }

    @Override // coil.util.HardwareBitmapService
    public boolean allowHardwareMainThread(Size size) {
        return this.allowHardware;
    }

    @Override // coil.util.HardwareBitmapService
    public boolean allowHardwareWorkerThread() {
        return this.allowHardware;
    }

    public boolean isTorchResetRequired(ArrayList arrayList, boolean z) {
        if (this.allowHardware && z) {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                Integer num = (Integer) ((CaptureRequest) obj).get(CaptureRequest.FLASH_MODE);
                if (num != null && num.intValue() == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean shouldStopRepeatingBeforeCapture(ArrayList arrayList, boolean z) {
        if (this.allowHardware && z) {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                int iIntValue = ((Integer) ((CaptureRequest) obj).get(CaptureRequest.CONTROL_AE_MODE)).intValue();
                if (iIntValue == 2 || iIntValue == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    public ImmutableHardwareBitmapService(int i) {
        switch (i) {
            case 3:
                this.allowHardware = DeviceQuirks.sQuirks.get(TorchIsClosedAfterImageCapturingQuirk.class) != null;
                break;
            case 4:
                this.allowHardware = androidx.camera.core.internal.compat.quirk.DeviceQuirks.sQuirks.get(SurfaceOrderQuirk.class) != null;
                break;
            default:
                this.allowHardware = ((StillCaptureFlashStopRepeatingQuirk) DeviceQuirks.sQuirks.get(StillCaptureFlashStopRepeatingQuirk.class)) != null;
                break;
        }
    }

    public ImmutableHardwareBitmapService(boolean z) {
        this.allowHardware = z;
    }
}
