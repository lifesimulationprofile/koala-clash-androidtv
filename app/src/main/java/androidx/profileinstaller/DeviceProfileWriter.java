package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DeviceProfileWriter {
    public final String mApkName;
    public final File mCurProfile;
    public final byte[] mDesiredVersion;
    public boolean mDeviceSupportsAotProfile = false;
    public final ProfileInstaller$DiagnosticsCallback mDiagnostics;
    public final Executor mExecutor;
    public DexProfileData[] mProfile;
    public byte[] mTranscodedProfile;

    public DeviceProfileWriter(AssetManager assetManager, Executor executor, ProfileInstaller$DiagnosticsCallback profileInstaller$DiagnosticsCallback, String str, File file) {
        this.mExecutor = executor;
        this.mDiagnostics = profileInstaller$DiagnosticsCallback;
        this.mApkName = str;
        this.mCurProfile = file;
        int i = Build.VERSION.SDK_INT;
        byte[] bArr = null;
        if (i >= 24) {
            if (i < 31) {
                switch (i) {
                    case 24:
                    case 25:
                        bArr = Encoding.V001_N;
                        break;
                    case 26:
                        bArr = Encoding.V005_O;
                        break;
                    case 27:
                        bArr = Encoding.V009_O_MR1;
                        break;
                    case 28:
                    case 29:
                    case 30:
                        bArr = Encoding.V010_P;
                        break;
                }
            } else {
                bArr = Encoding.V015_S;
            }
        }
        this.mDesiredVersion = bArr;
    }

    public final FileInputStream openStreamFromAssets(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e) {
            String message = e.getMessage();
            if (message == null || !message.contains("compressed")) {
                return null;
            }
            this.mDiagnostics.onDiagnosticReceived();
            return null;
        }
    }

    public final void result(int i, Serializable serializable) {
        this.mExecutor.execute(new DeviceProfileWriter$$ExternalSyntheticLambda0(i, 0, this, serializable));
    }
}
