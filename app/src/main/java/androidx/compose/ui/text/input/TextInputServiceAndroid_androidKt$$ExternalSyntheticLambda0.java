package androidx.compose.ui.text.input;

import android.view.Choreographer;
import androidx.profileinstaller.ProfileInstallerInitializer$$ExternalSyntheticLambda0;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TextInputServiceAndroid_androidKt$$ExternalSyntheticLambda0 implements Executor {
    public final /* synthetic */ Choreographer f$0;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f$0.postFrameCallback(new ProfileInstallerInitializer$$ExternalSyntheticLambda0(runnable));
    }
}
