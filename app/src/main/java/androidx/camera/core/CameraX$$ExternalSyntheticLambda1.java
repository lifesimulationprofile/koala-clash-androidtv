package androidx.camera.core;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import androidx.camera.camera2.Camera2Config$$ExternalSyntheticLambda1;
import androidx.camera.camera2.internal.Camera2CameraFactory;
import androidx.camera.camera2.internal.Camera2UseCaseConfigFactory;
import androidx.camera.core.impl.AutoValue_CameraThreadConfig;
import androidx.camera.core.impl.CameraProviderExecutionState;
import androidx.camera.core.impl.CameraValidator;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.os.HandlerCompat;
import androidx.tracing.Trace;
import java.util.LinkedHashSet;
import java.util.concurrent.Executor;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CameraX$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ CameraX f$0;
    public final /* synthetic */ Context f$1;
    public final /* synthetic */ Executor f$2;
    public final /* synthetic */ int f$3;
    public final /* synthetic */ CallbackToFutureAdapter.Completer f$4;
    public final /* synthetic */ long f$5;

    public /* synthetic */ CameraX$$ExternalSyntheticLambda1(CameraX cameraX, Context context, Executor executor, int i, CallbackToFutureAdapter.Completer completer, long j) {
        this.f$0 = cameraX;
        this.f$1 = context;
        this.f$2 = executor;
        this.f$3 = i;
        this.f$4 = completer;
        this.f$5 = j;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00fc A[Catch: all -> 0x0095, TryCatch #1 {all -> 0x0095, blocks: (B:7:0x0038, B:9:0x0040, B:11:0x0068, B:13:0x0081, B:15:0x008c, B:24:0x009e, B:26:0x00ad, B:28:0x00b3, B:29:0x00b9, B:31:0x00c4, B:32:0x00d0, B:33:0x00d1, B:34:0x00dd, B:35:0x00de, B:36:0x00ea, B:37:0x00eb, B:39:0x00fc, B:40:0x0103, B:44:0x010c, B:46:0x013b, B:47:0x013f, B:48:0x014a, B:49:0x014c, B:53:0x0151, B:55:0x0155, B:56:0x015d, B:58:0x0161, B:59:0x0186, B:61:0x018a, B:62:0x018f, B:67:0x019c, B:51:0x014e, B:52:0x0150), top: B:70:0x0038, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x0107  */
    /* JADX WARN: Code duplicated, block: B:48:0x014a A[Catch: all -> 0x0095, TryCatch #1 {all -> 0x0095, blocks: (B:7:0x0038, B:9:0x0040, B:11:0x0068, B:13:0x0081, B:15:0x008c, B:24:0x009e, B:26:0x00ad, B:28:0x00b3, B:29:0x00b9, B:31:0x00c4, B:32:0x00d0, B:33:0x00d1, B:34:0x00dd, B:35:0x00de, B:36:0x00ea, B:37:0x00eb, B:39:0x00fc, B:40:0x0103, B:44:0x010c, B:46:0x013b, B:47:0x013f, B:48:0x014a, B:49:0x014c, B:53:0x0151, B:55:0x0155, B:56:0x015d, B:58:0x0161, B:59:0x0186, B:61:0x018a, B:62:0x018f, B:67:0x019c, B:51:0x014e, B:52:0x0150), top: B:70:0x0038, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x014d  */
    /* JADX WARN: Code duplicated, block: B:55:0x0155 A[Catch: all -> 0x0095, TryCatch #1 {all -> 0x0095, blocks: (B:7:0x0038, B:9:0x0040, B:11:0x0068, B:13:0x0081, B:15:0x008c, B:24:0x009e, B:26:0x00ad, B:28:0x00b3, B:29:0x00b9, B:31:0x00c4, B:32:0x00d0, B:33:0x00d1, B:34:0x00dd, B:35:0x00de, B:36:0x00ea, B:37:0x00eb, B:39:0x00fc, B:40:0x0103, B:44:0x010c, B:46:0x013b, B:47:0x013f, B:48:0x014a, B:49:0x014c, B:53:0x0151, B:55:0x0155, B:56:0x015d, B:58:0x0161, B:59:0x0186, B:61:0x018a, B:62:0x018f, B:67:0x019c, B:51:0x014e, B:52:0x0150), top: B:70:0x0038, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x015d A[Catch: all -> 0x0095, TryCatch #1 {all -> 0x0095, blocks: (B:7:0x0038, B:9:0x0040, B:11:0x0068, B:13:0x0081, B:15:0x008c, B:24:0x009e, B:26:0x00ad, B:28:0x00b3, B:29:0x00b9, B:31:0x00c4, B:32:0x00d0, B:33:0x00d1, B:34:0x00dd, B:35:0x00de, B:36:0x00ea, B:37:0x00eb, B:39:0x00fc, B:40:0x0103, B:44:0x010c, B:46:0x013b, B:47:0x013f, B:48:0x014a, B:49:0x014c, B:53:0x0151, B:55:0x0155, B:56:0x015d, B:58:0x0161, B:59:0x0186, B:61:0x018a, B:62:0x018f, B:67:0x019c, B:51:0x014e, B:52:0x0150), top: B:70:0x0038, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0161 A[Catch: all -> 0x0095, TryCatch #1 {all -> 0x0095, blocks: (B:7:0x0038, B:9:0x0040, B:11:0x0068, B:13:0x0081, B:15:0x008c, B:24:0x009e, B:26:0x00ad, B:28:0x00b3, B:29:0x00b9, B:31:0x00c4, B:32:0x00d0, B:33:0x00d1, B:34:0x00dd, B:35:0x00de, B:36:0x00ea, B:37:0x00eb, B:39:0x00fc, B:40:0x0103, B:44:0x010c, B:46:0x013b, B:47:0x013f, B:48:0x014a, B:49:0x014c, B:53:0x0151, B:55:0x0155, B:56:0x015d, B:58:0x0161, B:59:0x0186, B:61:0x018a, B:62:0x018f, B:67:0x019c, B:51:0x014e, B:52:0x0150), top: B:70:0x0038, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0186 A[Catch: all -> 0x0095, TryCatch #1 {all -> 0x0095, blocks: (B:7:0x0038, B:9:0x0040, B:11:0x0068, B:13:0x0081, B:15:0x008c, B:24:0x009e, B:26:0x00ad, B:28:0x00b3, B:29:0x00b9, B:31:0x00c4, B:32:0x00d0, B:33:0x00d1, B:34:0x00dd, B:35:0x00de, B:36:0x00ea, B:37:0x00eb, B:39:0x00fc, B:40:0x0103, B:44:0x010c, B:46:0x013b, B:47:0x013f, B:48:0x014a, B:49:0x014c, B:53:0x0151, B:55:0x0155, B:56:0x015d, B:58:0x0161, B:59:0x0186, B:61:0x018a, B:62:0x018f, B:67:0x019c, B:51:0x014e, B:52:0x0150), top: B:70:0x0038, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x018a A[Catch: all -> 0x0095, TryCatch #1 {all -> 0x0095, blocks: (B:7:0x0038, B:9:0x0040, B:11:0x0068, B:13:0x0081, B:15:0x008c, B:24:0x009e, B:26:0x00ad, B:28:0x00b3, B:29:0x00b9, B:31:0x00c4, B:32:0x00d0, B:33:0x00d1, B:34:0x00dd, B:35:0x00de, B:36:0x00ea, B:37:0x00eb, B:39:0x00fc, B:40:0x0103, B:44:0x010c, B:46:0x013b, B:47:0x013f, B:48:0x014a, B:49:0x014c, B:53:0x0151, B:55:0x0155, B:56:0x015d, B:58:0x0161, B:59:0x0186, B:61:0x018a, B:62:0x018f, B:67:0x019c, B:51:0x014e, B:52:0x0150), top: B:70:0x0038, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x018f A[Catch: all -> 0x0095, TRY_LEAVE, TryCatch #1 {all -> 0x0095, blocks: (B:7:0x0038, B:9:0x0040, B:11:0x0068, B:13:0x0081, B:15:0x008c, B:24:0x009e, B:26:0x00ad, B:28:0x00b3, B:29:0x00b9, B:31:0x00c4, B:32:0x00d0, B:33:0x00d1, B:34:0x00dd, B:35:0x00de, B:36:0x00ea, B:37:0x00eb, B:39:0x00fc, B:40:0x0103, B:44:0x010c, B:46:0x013b, B:47:0x013f, B:48:0x014a, B:49:0x014c, B:53:0x0151, B:55:0x0155, B:56:0x015d, B:58:0x0161, B:59:0x0186, B:61:0x018a, B:62:0x018f, B:67:0x019c, B:51:0x014e, B:52:0x0150), top: B:70:0x0038, inners: #2 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:58:0x0161, please report this as an issue */
    @Override // java.lang.Runnable
    public final void run() {
        CameraProviderExecutionState cameraProviderExecutionState;
        RetryPolicy.RetryConfig retryConfigOnRetryDecisionRequested;
        switch (this.$r8$classId) {
            case 0:
                CameraX cameraX = this.f$0;
                Context context = this.f$1;
                Executor executor = this.f$2;
                int i = this.f$3;
                CallbackToFutureAdapter.Completer completer = this.f$4;
                long j = this.f$5;
                Trace.beginSection("CX:initAndRetryRecursively");
                Context applicationContext = RangesKt.getApplicationContext(context);
                try {
                    try {
                        if (cameraX.mCameraXConfig.getCameraFactoryProvider() == null) {
                            throw new InitializationException(new IllegalArgumentException("Invalid app configuration provided. Missing CameraFactory."));
                        }
                        AutoValue_CameraThreadConfig autoValue_CameraThreadConfig = new AutoValue_CameraThreadConfig(cameraX.mCameraExecutor, cameraX.mSchedulerHandler);
                        CameraSelector availableCamerasLimiter = cameraX.mCameraXConfig.getAvailableCamerasLimiter();
                        cameraX.mCameraFactory = new Camera2CameraFactory(applicationContext, autoValue_CameraThreadConfig, availableCamerasLimiter, cameraX.mCameraXConfig.getCameraOpenRetryMaxTimeoutInMillisWhileResuming());
                        if (cameraX.mCameraXConfig.getDeviceSurfaceManagerProvider() == null) {
                            throw new InitializationException(new IllegalArgumentException("Invalid app configuration provided. Missing CameraDeviceSurfaceManager."));
                        }
                        Camera2CameraFactory camera2CameraFactory = cameraX.mCameraFactory;
                        cameraX.mSurfaceManager = Camera2Config$$ExternalSyntheticLambda1.newInstance(applicationContext, camera2CameraFactory.mCameraManager, new LinkedHashSet(camera2CameraFactory.mAvailableCameraIds));
                        if (cameraX.mCameraXConfig.getUseCaseConfigFactoryProvider() == null) {
                            throw new InitializationException(new IllegalArgumentException("Invalid app configuration provided. Missing UseCaseConfigFactory."));
                        }
                        cameraX.mDefaultConfigFactory = new Camera2UseCaseConfigFactory(applicationContext);
                        if (executor instanceof CameraExecutor) {
                            ((CameraExecutor) executor).init(cameraX.mCameraFactory);
                        }
                        cameraX.mCameraRepository.init(cameraX.mCameraFactory);
                        CameraValidator.validateCameras(applicationContext, cameraX.mCameraRepository, availableCamerasLimiter);
                        if (i > 1 && Trace.isEnabled()) {
                            Trace.setCounter("CX:CameraProvider-RetryStatus", -1);
                        }
                        cameraX.setStateToInitialized();
                        completer.set(null);
                        android.os.Trace.endSection();
                        return;
                    } catch (Throwable th) {
                        android.os.Trace.endSection();
                        throw th;
                    }
                } catch (InitializationException e) {
                    e = e;
                    cameraProviderExecutionState = new CameraProviderExecutionState(j, e);
                    retryConfigOnRetryDecisionRequested = cameraX.mRetryPolicy.onRetryDecisionRequested(cameraProviderExecutionState);
                    if (Trace.isEnabled()) {
                        Trace.setCounter("CX:CameraProvider-RetryStatus", cameraProviderExecutionState.mStatus);
                    }
                    if (retryConfigOnRetryDecisionRequested.mShouldRetry || i >= Integer.MAX_VALUE) {
                        synchronized (cameraX.mInitializeLock) {
                            cameraX.mInitState = 3;
                            break;
                        }
                        if (retryConfigOnRetryDecisionRequested.mCompleteWithoutFailure) {
                            cameraX.setStateToInitialized();
                            completer.set(null);
                        } else if (e instanceof CameraValidator.CameraIdListIncorrectException) {
                            String str = "Device reporting less cameras than anticipated. On real devices: Retrying initialization might resolve temporary camera errors. On emulators: Ensure virtual camera configuration matches supported camera features as reported by PackageManager#hasSystemFeature. Available cameras: " + ((CameraValidator.CameraIdListIncorrectException) e).mAvailableCameraCount;
                            Logger.e("CameraX", str, e);
                            completer.setException(new InitializationException(new CameraUnavailableException(str)));
                        } else if (e instanceof InitializationException) {
                            completer.setException(e);
                        } else {
                            completer.setException(new InitializationException(e));
                        }
                    } else {
                        Logger.w("CameraX", "Retry init. Start time " + j + " current time " + SystemClock.elapsedRealtime(), e);
                        Handler handler = cameraX.mSchedulerHandler;
                        CameraX$$ExternalSyntheticLambda1 cameraX$$ExternalSyntheticLambda1 = new CameraX$$ExternalSyntheticLambda1(cameraX, executor, j, i, applicationContext, completer);
                        long j2 = retryConfigOnRetryDecisionRequested.mDelayInMillis;
                        if (Build.VERSION.SDK_INT >= 28) {
                            HandlerCompat.Api28Impl.postDelayed(handler, cameraX$$ExternalSyntheticLambda1, j2);
                        } else {
                            Message messageObtain = Message.obtain(handler, cameraX$$ExternalSyntheticLambda1);
                            messageObtain.obj = "retry_token";
                            handler.sendMessageDelayed(messageObtain, j2);
                        }
                    }
                } catch (CameraValidator.CameraIdListIncorrectException e2) {
                    e = e2;
                    cameraProviderExecutionState = new CameraProviderExecutionState(j, e);
                    retryConfigOnRetryDecisionRequested = cameraX.mRetryPolicy.onRetryDecisionRequested(cameraProviderExecutionState);
                    if (Trace.isEnabled()) {
                        Trace.setCounter("CX:CameraProvider-RetryStatus", cameraProviderExecutionState.mStatus);
                    }
                    if (retryConfigOnRetryDecisionRequested.mShouldRetry) {
                        synchronized (cameraX.mInitializeLock) {
                            cameraX.mInitState = 3;
                            if (retryConfigOnRetryDecisionRequested.mCompleteWithoutFailure) {
                                cameraX.setStateToInitialized();
                                completer.set(null);
                            } else if (e instanceof CameraValidator.CameraIdListIncorrectException) {
                                String str2 = "Device reporting less cameras than anticipated. On real devices: Retrying initialization might resolve temporary camera errors. On emulators: Ensure virtual camera configuration matches supported camera features as reported by PackageManager#hasSystemFeature. Available cameras: " + ((CameraValidator.CameraIdListIncorrectException) e).mAvailableCameraCount;
                                Logger.e("CameraX", str2, e);
                                completer.setException(new InitializationException(new CameraUnavailableException(str2)));
                            } else if (e instanceof InitializationException) {
                                completer.setException(e);
                            } else {
                                completer.setException(new InitializationException(e));
                            }
                        }
                    } else {
                        synchronized (cameraX.mInitializeLock) {
                            cameraX.mInitState = 3;
                            if (retryConfigOnRetryDecisionRequested.mCompleteWithoutFailure) {
                                cameraX.setStateToInitialized();
                                completer.set(null);
                            } else if (e instanceof CameraValidator.CameraIdListIncorrectException) {
                                String str3 = "Device reporting less cameras than anticipated. On real devices: Retrying initialization might resolve temporary camera errors. On emulators: Ensure virtual camera configuration matches supported camera features as reported by PackageManager#hasSystemFeature. Available cameras: " + ((CameraValidator.CameraIdListIncorrectException) e).mAvailableCameraCount;
                                Logger.e("CameraX", str3, e);
                                completer.setException(new InitializationException(new CameraUnavailableException(str3)));
                            } else if (e instanceof InitializationException) {
                                completer.setException(e);
                            } else {
                                completer.setException(new InitializationException(e));
                            }
                        }
                    }
                } catch (RuntimeException e3) {
                    e = e3;
                    cameraProviderExecutionState = new CameraProviderExecutionState(j, e);
                    retryConfigOnRetryDecisionRequested = cameraX.mRetryPolicy.onRetryDecisionRequested(cameraProviderExecutionState);
                    if (Trace.isEnabled()) {
                        Trace.setCounter("CX:CameraProvider-RetryStatus", cameraProviderExecutionState.mStatus);
                    }
                    if (retryConfigOnRetryDecisionRequested.mShouldRetry) {
                        synchronized (cameraX.mInitializeLock) {
                            cameraX.mInitState = 3;
                            if (retryConfigOnRetryDecisionRequested.mCompleteWithoutFailure) {
                                cameraX.setStateToInitialized();
                                completer.set(null);
                            } else if (e instanceof CameraValidator.CameraIdListIncorrectException) {
                                String str4 = "Device reporting less cameras than anticipated. On real devices: Retrying initialization might resolve temporary camera errors. On emulators: Ensure virtual camera configuration matches supported camera features as reported by PackageManager#hasSystemFeature. Available cameras: " + ((CameraValidator.CameraIdListIncorrectException) e).mAvailableCameraCount;
                                Logger.e("CameraX", str4, e);
                                completer.setException(new InitializationException(new CameraUnavailableException(str4)));
                            } else if (e instanceof InitializationException) {
                                completer.setException(e);
                            } else {
                                completer.setException(new InitializationException(e));
                            }
                        }
                    } else {
                        synchronized (cameraX.mInitializeLock) {
                            cameraX.mInitState = 3;
                            if (retryConfigOnRetryDecisionRequested.mCompleteWithoutFailure) {
                                cameraX.setStateToInitialized();
                                completer.set(null);
                            } else if (e instanceof CameraValidator.CameraIdListIncorrectException) {
                                String str5 = "Device reporting less cameras than anticipated. On real devices: Retrying initialization might resolve temporary camera errors. On emulators: Ensure virtual camera configuration matches supported camera features as reported by PackageManager#hasSystemFeature. Available cameras: " + ((CameraValidator.CameraIdListIncorrectException) e).mAvailableCameraCount;
                                Logger.e("CameraX", str5, e);
                                completer.setException(new InitializationException(new CameraUnavailableException(str5)));
                            } else if (e instanceof InitializationException) {
                                completer.setException(e);
                            } else {
                                completer.setException(new InitializationException(e));
                            }
                        }
                    }
                }
                break;
            default:
                CameraX cameraX2 = this.f$0;
                Executor executor2 = this.f$2;
                executor2.execute(new CameraX$$ExternalSyntheticLambda1(cameraX2, this.f$1, executor2, this.f$3 + 1, this.f$4, this.f$5));
                return;
        }
    }

    public /* synthetic */ CameraX$$ExternalSyntheticLambda1(CameraX cameraX, Executor executor, long j, int i, Context context, CallbackToFutureAdapter.Completer completer) {
        this.f$0 = cameraX;
        this.f$2 = executor;
        this.f$5 = j;
        this.f$3 = i;
        this.f$1 = context;
        this.f$4 = completer;
    }
}
