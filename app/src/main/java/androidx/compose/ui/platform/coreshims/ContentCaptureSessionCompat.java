package androidx.compose.ui.platform.coreshims;

import android.os.Build;
import android.view.View;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import android.view.inputmethod.InputMethodManager;
import androidx.camera.camera2.internal.ExposureStateImpl;
import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.graphics.Api26Bitmap$$ExternalSyntheticApiModelOutline0;
import androidx.compose.ui.text.android.CanvasCompatQ$$ExternalSyntheticApiModelOutline0;
import androidx.tracing.TraceApi29Impl;
import java.util.Objects;
import kotlin.LazyKt__LazyJVMKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ContentCaptureSessionCompat {
    public final View mView;
    public final Object mWrappedObj;

    public ContentCaptureSessionCompat(View view) {
        this.mView = view;
        this.mWrappedObj = LazyKt__LazyJVMKt.lazy(3, new BasicTextKt$$ExternalSyntheticLambda0(15, this));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    public InputMethodManager getImm() {
        return (InputMethodManager) this.mWrappedObj.getValue();
    }

    public AutofillId newAutofillId(long j) {
        if (Build.VERSION.SDK_INT < 29) {
            return null;
        }
        ContentCaptureSession contentCaptureSessionM = CanvasCompatQ$$ExternalSyntheticApiModelOutline0.m(this.mWrappedObj);
        ExposureStateImpl autofillId = ViewCompatShims.getAutofillId(this.mView);
        Objects.requireNonNull(autofillId);
        return TraceApi29Impl.newAutofillId(contentCaptureSessionM, Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(autofillId.mLock), j);
    }

    public ContentCaptureSessionCompat(ContentCaptureSession contentCaptureSession, View view) {
        this.mWrappedObj = contentCaptureSession;
        this.mView = view;
    }
}
