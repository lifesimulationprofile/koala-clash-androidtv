package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.util.Range;
import androidx.appcompat.widget.Toolbar;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.interop.CaptureRequestOptions$Builder$$ExternalSyntheticLambda0;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.utils.futures.ChainingListenableFuture;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.AutoValue_ImmutableZoomState;
import androidx.camera.view.PreviewStreamStateObserver$$ExternalSyntheticLambda1;
import androidx.camera.view.PreviewView;
import androidx.camera.view.PreviewViewImplementation;
import androidx.compose.ui.geometry.MutableRect;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.view.MenuHostHelper;
import androidx.lifecycle.MutableLiveData;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api$Client;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.internal.BaseGmsClient$ConnectionProgressReportCallbacks;
import com.google.android.gms.tasks.zzi;
import java.util.ArrayList;
import kotlin.text.HexFormatKt;
import kotlinx.serialization.json.internal.Composer;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ZoomControl implements Observable.Observer, BaseGmsClient$ConnectionProgressReportCallbacks {
    public final Object mCamera2CameraControlImpl;
    public Object mCaptureResultListener;
    public Object mCurrentZoomState;
    public boolean mIsActive;
    public Object mZoomImpl;
    public Object mZoomStateLiveData;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public interface ZoomImpl {
        void addRequestOption(ImageCapture.Builder builder);

        float getMaxZoom();

        float getMinZoom();

        void onCaptureResult(TotalCaptureResult totalCaptureResult);

        void resetZoom();
    }

    public ZoomControl(GoogleApiManager googleApiManager, Api$Client api$Client, ApiKey apiKey) {
        this.mCaptureResultListener = googleApiManager;
        this.mZoomStateLiveData = null;
        this.mZoomImpl = null;
        this.mIsActive = false;
        this.mCamera2CameraControlImpl = api$Client;
        this.mCurrentZoomState = apiKey;
    }

    @Override // androidx.camera.core.impl.Observable.Observer
    public void onError(Throwable th) {
        FutureChain futureChain = (FutureChain) this.mCaptureResultListener;
        if (futureChain != null) {
            futureChain.cancel(false);
            this.mCaptureResultListener = null;
        }
        updatePreviewStreamState(PreviewView.StreamState.IDLE);
    }

    @Override // androidx.camera.core.impl.Observable.Observer
    public void onNewData(Object obj) {
        CameraInternal.State state = (CameraInternal.State) obj;
        CameraInternal.State state2 = CameraInternal.State.CLOSING;
        PreviewView.StreamState streamState = PreviewView.StreamState.IDLE;
        if (state == state2 || state == CameraInternal.State.CLOSED || state == CameraInternal.State.RELEASING || state == CameraInternal.State.RELEASED) {
            updatePreviewStreamState(streamState);
            if (this.mIsActive) {
                this.mIsActive = false;
                FutureChain futureChain = (FutureChain) this.mCaptureResultListener;
                if (futureChain != null) {
                    futureChain.cancel(false);
                    this.mCaptureResultListener = null;
                    return;
                }
                return;
            }
            return;
        }
        if ((state == CameraInternal.State.OPENING || state == CameraInternal.State.OPEN || state == CameraInternal.State.PENDING_OPEN) && !this.mIsActive) {
            CameraInfoInternal cameraInfoInternal = (CameraInfoInternal) this.mCamera2CameraControlImpl;
            updatePreviewStreamState(streamState);
            ArrayList arrayList = new ArrayList();
            ChainingListenableFuture chainingListenableFutureTransformAsync = Futures.transformAsync(FutureChain.from(CallbackToFutureAdapter.getFuture(new CaptureRequestOptions$Builder$$ExternalSyntheticLambda0(this, cameraInfoInternal, arrayList))), new PreviewStreamStateObserver$$ExternalSyntheticLambda1(this), HexFormatKt.directExecutor());
            PreviewStreamStateObserver$$ExternalSyntheticLambda1 previewStreamStateObserver$$ExternalSyntheticLambda1 = new PreviewStreamStateObserver$$ExternalSyntheticLambda1(this);
            ChainingListenableFuture chainingListenableFutureTransformAsync2 = Futures.transformAsync(chainingListenableFutureTransformAsync, new PreviewView.AnonymousClass1(18, previewStreamStateObserver$$ExternalSyntheticLambda1), HexFormatKt.directExecutor());
            this.mCaptureResultListener = chainingListenableFutureTransformAsync2;
            MenuHostHelper menuHostHelper = new MenuHostHelper(this, arrayList, cameraInfoInternal, 10, false);
            chainingListenableFutureTransformAsync2.addListener(new zzi(1, chainingListenableFutureTransformAsync2, menuHostHelper), HexFormatKt.directExecutor());
            this.mIsActive = true;
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient$ConnectionProgressReportCallbacks
    public void onReportServiceBinding(ConnectionResult connectionResult) {
        ((GoogleApiManager) this.mCaptureResultListener).zar.post(new zzi(11, this, connectionResult, false));
    }

    public void updatePreviewStreamState(PreviewView.StreamState streamState) {
        synchronized (this) {
            try {
                if (((PreviewView.StreamState) this.mCurrentZoomState).equals(streamState)) {
                    return;
                }
                this.mCurrentZoomState = streamState;
                Logger.d("StreamStateObserver", "Update Preview stream state to " + streamState);
                ((MutableLiveData) this.mZoomStateLiveData).postValue(streamState);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void zae(ConnectionResult connectionResult) {
        zabq zabqVar = (zabq) ((GoogleApiManager) this.mCaptureResultListener).zan.get((ApiKey) this.mCurrentZoomState);
        if (zabqVar != null) {
            zabqVar.zas(connectionResult);
        }
    }

    public ZoomControl(CameraInfoInternal cameraInfoInternal, MutableLiveData mutableLiveData, PreviewViewImplementation previewViewImplementation) {
        this.mIsActive = false;
        this.mCamera2CameraControlImpl = cameraInfoInternal;
        this.mZoomStateLiveData = mutableLiveData;
        this.mZoomImpl = previewViewImplementation;
        synchronized (this) {
            this.mCurrentZoomState = (PreviewView.StreamState) mutableLiveData.getValue();
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0031  */
    public ZoomControl(Camera2CameraControlImpl camera2CameraControlImpl, CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        Range range;
        ZoomImpl composer;
        this.mIsActive = false;
        this.mCaptureResultListener = new Camera2CameraControlImpl.CaptureResultListener() { // from class: androidx.camera.camera2.internal.ZoomControl.1
            @Override // androidx.camera.camera2.internal.Camera2CameraControlImpl.CaptureResultListener
            public final boolean onCaptureResult(TotalCaptureResult totalCaptureResult) {
                ((ZoomImpl) ZoomControl.this.mZoomImpl).onCaptureResult(totalCaptureResult);
                return false;
            }
        };
        this.mCamera2CameraControlImpl = camera2CameraControlImpl;
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                range = (Range) cameraCharacteristicsCompat.get(CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE);
            } catch (AssertionError e) {
                Logger.w("ZoomControl", "AssertionError, fail to get camera characteristic.", e);
                range = null;
            }
            if (range != null) {
                composer = new Composer(cameraCharacteristicsCompat);
            } else {
                composer = new Toolbar.AnonymousClass1(5, cameraCharacteristicsCompat);
            }
        } else {
            composer = new Toolbar.AnonymousClass1(5, cameraCharacteristicsCompat);
        }
        this.mZoomImpl = composer;
        MutableRect mutableRect = new MutableRect(composer.getMaxZoom(), composer.getMinZoom());
        this.mCurrentZoomState = mutableRect;
        mutableRect.setZoomRatio();
        this.mZoomStateLiveData = new MutableLiveData(new AutoValue_ImmutableZoomState(mutableRect.getZoomRatio(), mutableRect.getMaxZoomRatio(), mutableRect.getMinZoomRatio(), mutableRect.getLinearZoom()));
        camera2CameraControlImpl.addCaptureResultListener((AnonymousClass1) this.mCaptureResultListener);
    }
}
