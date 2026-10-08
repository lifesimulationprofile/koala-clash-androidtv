package androidx.camera.view;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.display.DisplayManager;
import android.media.Image;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Rational;
import android.util.Size;
import android.view.Display;
import android.view.MenuItem;
import android.view.Surface;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.CascadingMenuPopup;
import androidx.appcompat.view.menu.CascadingMenuPopup$3$1;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.MenuItemHoverListener;
import androidx.appcompat.widget.Toolbar;
import androidx.arch.core.util.Function;
import androidx.camera.camera2.internal.CaptureSession;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.camera2.internal.ZoomControl;
import androidx.camera.camera2.internal.ZslControlImpl$$ExternalSyntheticLambda0;
import androidx.camera.camera2.internal.compat.quirk.AeFpsRangeLegacyQuirk;
import androidx.camera.camera2.internal.compat.quirk.CaptureSessionOnClosedNotCalledQuirk;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ExtraCroppingQuirk;
import androidx.camera.camera2.interop.CaptureRequestOptions$Builder$$ExternalSyntheticLambda0;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.MeteringPointFactory;
import androidx.camera.core.Preview;
import androidx.camera.core.Preview$$ExternalSyntheticLambda1;
import androidx.camera.core.SettableImageProxy;
import androidx.camera.core.SingleCloseImageProxy;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.ViewPort;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.impl.utils.futures.ListFuture;
import androidx.camera.core.internal.CameraCaptureResultImageInfo;
import androidx.camera.core.streamsharing.VirtualCameraCaptureResult;
import androidx.camera.view.internal.compat.quirk.SurfaceViewNotCroppedByParentQuirk;
import androidx.camera.view.internal.compat.quirk.SurfaceViewStretchedQuirk;
import androidx.camera.view.transform.OutputTransform;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.Animations;
import androidx.compose.animation.core.ArcSpline$Arc;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.FloatAnimationSpec;
import androidx.compose.animation.core.FloatSpringSpec;
import androidx.compose.animation.core.VectorizedAnimationSpecKt;
import androidx.compose.animation.core.VectorizedFiniteAnimationSpec;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.snapping.AnimationResult;
import androidx.compose.foundation.gestures.snapping.ApproachAnimation;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$tryApproach$1;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo$Interval;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentManager$2;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.github.kr328.clash.remote.StatusClient;
import com.google.android.gms.tasks.zzr;
import com.google.common.util.concurrent.ListenableFuture;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function1;
import kotlin.text.CharsKt;
import kotlin.uuid.UuidKt;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class PreviewView extends FrameLayout {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final AtomicReference mActiveStreamStateObserver;
    public CameraInfoInternal mCameraInfoInternal;
    public final DisplayRotationListener mDisplayRotationListener;
    public PreviewViewImplementation mImplementation;
    public ImplementationMode mImplementationMode;
    public final PreviewView$$ExternalSyntheticLambda0 mOnLayoutChangeListener;
    public final MutableLiveData mPreviewStreamStateLiveData;
    public final PreviewTransformation mPreviewTransform;
    public final PreviewViewMeteringPointFactory mPreviewViewMeteringPointFactory;
    public final ScreenFlashView mScreenFlashView;
    public final AnonymousClass1 mSurfaceProvider;
    public boolean mUseDisplayRotation;

    /* JADX INFO: renamed from: androidx.camera.view.PreviewView$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public class AnonymousClass1 implements MenuItemHoverListener, MenuPresenter.Callback, AppCompatTextView.SuperCaller, MenuBuilder.Callback, FutureCallback, ImageReaderProxy, AsyncFunction, CallbackToFutureAdapter.Resolver, Preview.SurfaceProvider, Animations, VectorizedFiniteAnimationSpec, ApproachAnimation {
        public final /* synthetic */ int $r8$classId;
        public Object this$0;

        public /* synthetic */ AnonymousClass1(int i, Object obj) {
            this.$r8$classId = i;
            this.this$0 = obj;
        }

        public static SettableImageProxy createImageProxyWithEmptyMetadata(ImageProxy imageProxy) {
            if (imageProxy == null) {
                return null;
            }
            return new SettableImageProxy(imageProxy, new Size(imageProxy.getWidth(), imageProxy.getHeight()), new CameraCaptureResultImageInfo(new VirtualCameraCaptureResult(null, TagBundle.EMPTY_TAGBUNDLE, imageProxy.getImageInfo().getTimestamp())));
        }

        @Override // androidx.camera.core.impl.ImageReaderProxy
        public ImageProxy acquireLatestImage() {
            return createImageProxyWithEmptyMetadata(((zzr) this.this$0).acquireLatestImage());
        }

        @Override // androidx.camera.core.impl.ImageReaderProxy
        public ImageProxy acquireNextImage() {
            return createImageProxyWithEmptyMetadata(((zzr) this.this$0).acquireNextImage());
        }

        @Override // androidx.camera.core.impl.utils.futures.AsyncFunction, androidx.arch.core.util.Function
        public ListenableFuture apply(Object obj) {
            return Futures.immediateFuture(((Function) this.this$0).apply(obj));
        }

        @Override // androidx.compose.foundation.gestures.snapping.ApproachAnimation
        public Object approachAnimation(ScrollScope scrollScope, Float f, Float f2, Function1 function1, SnapFlingBehavior$tryApproach$1 snapFlingBehavior$tryApproach$1) {
            float fFloatValue = f.floatValue();
            float fFloatValue2 = f2.floatValue();
            Object objAccess$animateWithTarget = UuidKt.access$animateWithTarget(scrollScope, Math.signum(fFloatValue2) * Math.abs(fFloatValue), fFloatValue, ArcSplineKt.AnimationState$default(0.0f, fFloatValue2, 28), (AnimationSpec) this.this$0, function1, snapFlingBehavior$tryApproach$1);
            return objAccess$animateWithTarget == CoroutineSingletons.COROUTINE_SUSPENDED ? objAccess$animateWithTarget : (AnimationResult) objAccess$animateWithTarget;
        }

        @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
        public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
            ListFuture listFuture = (ListFuture) this.this$0;
            Preconditions.checkState("The result can only set once!", listFuture.mResultNotifier == null);
            listFuture.mResultNotifier = completer;
            return "ListFuture[" + this + "]";
        }

        @Override // androidx.camera.core.impl.ImageReaderProxy
        public void clearOnImageAvailableListener() {
            ((zzr) this.this$0).clearOnImageAvailableListener();
        }

        @Override // androidx.camera.core.impl.ImageReaderProxy
        public void close() {
            ((zzr) this.this$0).close();
        }

        public void encode(byte b) {
            ((Parcel) this.this$0).writeByte(b);
        }

        /* JADX INFO: renamed from: encode--R2X_6o, reason: not valid java name */
        public void m19encodeR2X_6o(long j) {
            long jM726getTypeUIouoOA = TextUnit.m726getTypeUIouoOA(j);
            byte b = 0;
            if (!TextUnitType.m731equalsimpl0(jM726getTypeUIouoOA, 0L)) {
                if (TextUnitType.m731equalsimpl0(jM726getTypeUIouoOA, 4294967296L)) {
                    b = 1;
                } else if (TextUnitType.m731equalsimpl0(jM726getTypeUIouoOA, 8589934592L)) {
                    b = 2;
                }
            }
            encode(b);
            if (TextUnitType.m731equalsimpl0(TextUnit.m726getTypeUIouoOA(j), 0L)) {
                return;
            }
            encode(TextUnit.m727getValueimpl(j));
        }

        @Override // androidx.compose.animation.core.Animations
        public FloatAnimationSpec get(int i) {
            return (FloatSpringSpec) this.this$0;
        }

        public ByteBuffer getBuffer() {
            return ((Image.Plane) this.this$0).getBuffer();
        }

        @Override // androidx.compose.animation.core.VectorizedAnimationSpec
        public long getDurationNanos(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
            return ((Dispatcher) this.this$0).getDurationNanos(animationVector, animationVector2, animationVector3);
        }

        @Override // androidx.compose.animation.core.VectorizedAnimationSpec
        public AnimationVector getEndVelocity(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
            return ((Dispatcher) this.this$0).getEndVelocity(animationVector, animationVector2, animationVector3);
        }

        @Override // androidx.camera.core.impl.ImageReaderProxy
        public int getHeight() {
            return ((zzr) this.this$0).getHeight();
        }

        @Override // androidx.camera.core.impl.ImageReaderProxy
        public int getImageFormat() {
            return ((zzr) this.this$0).getImageFormat();
        }

        @Override // androidx.camera.core.impl.ImageReaderProxy
        public int getMaxImages() {
            return ((zzr) this.this$0).getMaxImages();
        }

        public int getPixelStride() {
            return ((Image.Plane) this.this$0).getPixelStride();
        }

        public int getRowStride() {
            return ((Image.Plane) this.this$0).getRowStride();
        }

        @Override // androidx.camera.core.impl.ImageReaderProxy
        public Surface getSurface() {
            return ((zzr) this.this$0).getSurface();
        }

        @Override // androidx.compose.animation.core.VectorizedAnimationSpec
        public AnimationVector getValueFromNanos(long j, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
            return ((Dispatcher) this.this$0).getValueFromNanos(j, animationVector, animationVector2, animationVector3);
        }

        @Override // androidx.compose.animation.core.VectorizedAnimationSpec
        public AnimationVector getVelocityFromNanos(long j, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
            return ((Dispatcher) this.this$0).getVelocityFromNanos(j, animationVector, animationVector2, animationVector3);
        }

        @Override // androidx.camera.core.impl.ImageReaderProxy
        public int getWidth() {
            return ((zzr) this.this$0).getWidth();
        }

        @Override // androidx.compose.animation.core.VectorizedAnimationSpec
        public boolean isInfinite() {
            ((Dispatcher) this.this$0).getClass();
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
            if (menuBuilder instanceof SubMenuBuilder) {
                ((SubMenuBuilder) menuBuilder).mParentMenu.getRootMenu().close(false);
            }
            MenuPresenter.Callback callback = ((ActionMenuPresenter) this.this$0).mCallback;
            if (callback != null) {
                callback.onCloseMenu(menuBuilder, z);
            }
        }

        @Override // androidx.camera.core.impl.utils.futures.FutureCallback
        public void onFailure(Throwable th) {
            switch (this.$r8$classId) {
                case 7:
                    synchronized (((CaptureSession) this.this$0).mSessionLock) {
                        try {
                            ((CaptureSession) this.this$0).mSessionOpener.stop();
                            int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(((CaptureSession) this.this$0).mState);
                            if ((iOrdinal == 3 || iOrdinal == 5 || iOrdinal == 6) && !(th instanceof CancellationException)) {
                                Logger.w("CaptureSession", "Opening session with fail ".concat(CaptureSession$State$EnumUnboxingLocalUtility.stringValueOf$1(((CaptureSession) this.this$0).mState)), th);
                                ((CaptureSession) this.this$0).finishClose();
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                        break;
                    }
                    return;
                case 15:
                    ((SingleCloseImageProxy) this.this$0).close();
                    return;
                default:
                    CallbackToFutureAdapter.Completer completer = (CallbackToFutureAdapter.Completer) this.this$0;
                    if (th instanceof TimeoutException) {
                        completer.setException(th);
                        return;
                    } else {
                        completer.set(Collections.EMPTY_LIST);
                        return;
                    }
            }
        }

        @Override // androidx.appcompat.widget.MenuItemHoverListener
        public void onItemHoverEnter(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            CascadingMenuPopup cascadingMenuPopup = (CascadingMenuPopup) this.this$0;
            Handler handler = cascadingMenuPopup.mSubMenuHoverHandler;
            handler.removeCallbacksAndMessages(null);
            ArrayList arrayList = cascadingMenuPopup.mShowingMenus;
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                } else if (menuBuilder == ((CascadingMenuPopup.CascadingMenuInfo) arrayList.get(i)).menu) {
                    break;
                } else {
                    i++;
                }
            }
            if (i == -1) {
                return;
            }
            int i2 = i + 1;
            handler.postAtTime(new CascadingMenuPopup$3$1(this, i2 < arrayList.size() ? (CascadingMenuPopup.CascadingMenuInfo) arrayList.get(i2) : null, menuItemImpl, menuBuilder), menuBuilder, SystemClock.uptimeMillis() + 200);
        }

        @Override // androidx.appcompat.widget.MenuItemHoverListener
        public void onItemHoverExit(MenuBuilder menuBuilder, MenuItem menuItem) {
            ((CascadingMenuPopup) this.this$0).mSubMenuHoverHandler.removeCallbacksAndMessages(menuBuilder);
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            ((Toolbar) this.this$0).getClass();
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder menuBuilder) {
            Toolbar toolbar = (Toolbar) this.this$0;
            ActionMenuPresenter actionMenuPresenter = toolbar.mMenuView.mPresenter;
            if (actionMenuPresenter == null || !actionMenuPresenter.isOverflowMenuShowing()) {
                Iterator it = ((CopyOnWriteArrayList) toolbar.mMenuHostHelper.mMenuProviders).iterator();
                while (it.hasNext()) {
                    ((FragmentManager$2) it.next()).this$0.dispatchPrepareOptionsMenu();
                }
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
            ActionMenuPresenter actionMenuPresenter = (ActionMenuPresenter) this.this$0;
            if (menuBuilder == actionMenuPresenter.mMenu) {
                return false;
            }
            ((SubMenuBuilder) menuBuilder).mItem.getClass();
            actionMenuPresenter.getClass();
            MenuPresenter.Callback callback = actionMenuPresenter.mCallback;
            if (callback != null) {
                return callback.onOpenSubMenu(menuBuilder);
            }
            return false;
        }

        @Override // androidx.camera.core.impl.utils.futures.FutureCallback
        public void onSuccess(Object obj) {
            switch (this.$r8$classId) {
                case 7:
                    break;
                case 15:
                    break;
                default:
                    List list = (List) obj;
                    list.getClass();
                    ((CallbackToFutureAdapter.Completer) this.this$0).set(new ArrayList(list));
                    break;
            }
        }

        @Override // androidx.camera.core.Preview.SurfaceProvider
        public void onSurfaceRequested(SurfaceRequest surfaceRequest) {
            PreviewViewImplementation surfaceViewImplementation;
            if (!CharsKt.isMainThread()) {
                ContextCompat.getMainExecutor(((PreviewView) this.this$0).getContext()).execute(new Preview$$ExternalSyntheticLambda1(21, this, surfaceRequest));
                return;
            }
            Logger.d("PreviewView", "Surface requested by Preview.");
            CameraInternal cameraInternal = surfaceRequest.mCamera;
            ((PreviewView) this.this$0).mCameraInfoInternal = cameraInternal.getCameraInfoInternal();
            PreviewViewMeteringPointFactory previewViewMeteringPointFactory = ((PreviewView) this.this$0).mPreviewViewMeteringPointFactory;
            Rect sensorRect = cameraInternal.getCameraControlInternal().getSensorRect();
            previewViewMeteringPointFactory.getClass();
            new Rational(sensorRect.width(), sensorRect.height());
            synchronized (previewViewMeteringPointFactory) {
                previewViewMeteringPointFactory.mSensorRect = sensorRect;
            }
            surfaceRequest.setTransformationInfoListener(ContextCompat.getMainExecutor(((PreviewView) this.this$0).getContext()), new PreviewView$1$$ExternalSyntheticLambda2(this, cameraInternal, surfaceRequest));
            PreviewView previewView = (PreviewView) this.this$0;
            PreviewViewImplementation previewViewImplementation = previewView.mImplementation;
            ImplementationMode implementationMode = previewView.mImplementationMode;
            if (!(previewViewImplementation instanceof SurfaceViewImplementation) || PreviewView.shouldUseTextureView(surfaceRequest, implementationMode)) {
                PreviewView previewView2 = (PreviewView) this.this$0;
                if (PreviewView.shouldUseTextureView(surfaceRequest, previewView2.mImplementationMode)) {
                    PreviewView previewView3 = (PreviewView) this.this$0;
                    TextureViewImplementation textureViewImplementation = new TextureViewImplementation(previewView3, previewView3.mPreviewTransform);
                    textureViewImplementation.mIsSurfaceTextureDetachedFromView = false;
                    textureViewImplementation.mNextFrameCompleter = new AtomicReference();
                    surfaceViewImplementation = textureViewImplementation;
                } else {
                    PreviewView previewView4 = (PreviewView) this.this$0;
                    surfaceViewImplementation = new SurfaceViewImplementation(previewView4, previewView4.mPreviewTransform);
                }
                previewView2.mImplementation = surfaceViewImplementation;
            }
            CameraInfoInternal cameraInfoInternal = cameraInternal.getCameraInfoInternal();
            PreviewView previewView5 = (PreviewView) this.this$0;
            ZoomControl zoomControl = new ZoomControl(cameraInfoInternal, previewView5.mPreviewStreamStateLiveData, previewView5.mImplementation);
            ((PreviewView) this.this$0).mActiveStreamStateObserver.set(zoomControl);
            cameraInternal.getCameraState().addObserver(ContextCompat.getMainExecutor(((PreviewView) this.this$0).getContext()), zoomControl);
            ((PreviewView) this.this$0).mImplementation.onSurfaceRequested(surfaceRequest, new PreviewView$1$$ExternalSyntheticLambda2(this, zoomControl, cameraInternal));
            PreviewView previewView6 = (PreviewView) this.this$0;
            if (previewView6.indexOfChild(previewView6.mScreenFlashView) == -1) {
                PreviewView previewView7 = (PreviewView) this.this$0;
                previewView7.addView(previewView7.mScreenFlashView);
            }
        }

        @Override // androidx.camera.core.impl.ImageReaderProxy
        public void setOnImageAvailableListener(ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, Executor executor) {
            ((zzr) this.this$0).setOnImageAvailableListener(new CaptureRequestOptions$Builder$$ExternalSyntheticLambda0(6, this, onImageAvailableListener), executor);
        }

        public /* synthetic */ AnonymousClass1(int i, boolean z) {
            this.$r8$classId = i;
        }

        public void encode(float f) {
            ((Parcel) this.this$0).writeFloat(f);
        }

        public AnonymousClass1(int i) {
            this.$r8$classId = i;
            switch (i) {
                case 13:
                    this.this$0 = (ExtraCroppingQuirk) DeviceQuirks.sQuirks.get(ExtraCroppingQuirk.class);
                    break;
                case 20:
                    this.this$0 = new LinkedHashMap(0, 0.75f, true);
                    break;
                case 27:
                    this.this$0 = new MutableVector(new LazyLayoutBeyondBoundsInfo$Interval[16]);
                    break;
                default:
                    this.this$0 = new AtomicInteger(0);
                    break;
            }
        }

        /* JADX WARN: Code duplicated, block: B:14:0x002a A[PHI: r10
          0x002a: PHI (r10v1 int) = (r10v0 int), (r10v3 int), (r10v4 int) binds: [B:5:0x001a, B:10:0x0023, B:12:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:19:0x0033  */
        public AnonymousClass1(int[] iArr, float[] fArr, float[][] fArr2) {
            int i;
            this.$r8$classId = 21;
            int i2 = 1;
            int length = fArr.length - 1;
            ArcSpline$Arc[][] arcSpline$ArcArr = new ArcSpline$Arc[length][];
            int i3 = 1;
            int i4 = 1;
            int i5 = 0;
            while (i5 < length) {
                int i6 = iArr[i5];
                int i7 = 3;
                if (i6 == 0) {
                    i = i7;
                } else if (i6 == i2) {
                    i3 = i2;
                    i = i3;
                } else {
                    if (i6 != 2) {
                        if (i6 != 3) {
                            i7 = 4;
                            if (i6 != 4) {
                                i7 = 5;
                                if (i6 != 5) {
                                    i = i4;
                                } else {
                                    i = i7;
                                }
                            } else {
                                i = i7;
                            }
                        } else {
                            if (i3 != i2) {
                                i3 = i2;
                            }
                            i = i3;
                        }
                    }
                    i3 = 2;
                    i = i3;
                }
                float[] fArr3 = fArr2[i5];
                int i8 = i5 + 1;
                float[] fArr4 = fArr2[i8];
                float f = fArr[i5];
                float f2 = fArr[i8];
                int length2 = (fArr3.length % 2) + (fArr3.length / 2);
                ArcSpline$Arc[] arcSpline$ArcArr2 = new ArcSpline$Arc[length2];
                int i9 = 0;
                while (i9 < length2) {
                    int i10 = i9 * 2;
                    int i11 = i9;
                    int i12 = i10 + 1;
                    arcSpline$ArcArr2[i11] = new ArcSpline$Arc(i, f, f2, fArr3[i10], fArr3[i12], fArr4[i10], fArr4[i12]);
                    i9 = i11 + 1;
                }
                arcSpline$ArcArr[i5] = arcSpline$ArcArr2;
                i5 = i8;
                i4 = i;
                i2 = 1;
            }
            this.this$0 = arcSpline$ArcArr;
        }

        public AnonymousClass1(Quirks quirks, int i) {
            this.$r8$classId = i;
            switch (i) {
                case 12:
                    this.this$0 = (CaptureSessionOnClosedNotCalledQuirk) quirks.get(CaptureSessionOnClosedNotCalledQuirk.class);
                    break;
                default:
                    AeFpsRangeLegacyQuirk aeFpsRangeLegacyQuirk = (AeFpsRangeLegacyQuirk) quirks.get(AeFpsRangeLegacyQuirk.class);
                    if (aeFpsRangeLegacyQuirk == null) {
                        this.this$0 = null;
                    } else {
                        this.this$0 = aeFpsRangeLegacyQuirk.mAeFpsRange;
                    }
                    break;
            }
        }

        public AnonymousClass1(float f, float f2, AnimationVector animationVector) {
            Animations anonymousClass1;
            this.$r8$classId = 23;
            int[] iArr = VectorizedAnimationSpecKt.EmptyIntArray;
            if (animationVector != null) {
                anonymousClass1 = new Toolbar.AnonymousClass1(f, f2, animationVector);
            } else {
                anonymousClass1 = new AnonymousClass1(f, f2);
            }
            this.this$0 = new Dispatcher(anonymousClass1);
        }

        public void setFirstBaselineToTopHeight(int i) {
        }

        public void setLastBaselineToBottomHeight(int i) {
        }

        public AnonymousClass1(float f, float f2) {
            this.$r8$classId = 22;
            this.this$0 = new FloatSpringSpec(f, f2, 0.01f);
        }

        public void setLineHeight(int i, float f) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public enum ImplementationMode {
        PERFORMANCE("PERFORMANCE"),
        /* JADX INFO: Fake field, exist only in values array */
        EF15("COMPATIBLE");

        public final int mId;

        ImplementationMode(String str) {
            this.mId = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public enum ScaleType {
        /* JADX INFO: Fake field, exist only in values array */
        EF0("FILL_START"),
        FILL_CENTER("FILL_CENTER"),
        /* JADX INFO: Fake field, exist only in values array */
        EF4("FILL_END"),
        FIT_START("FIT_START"),
        FIT_CENTER("FIT_CENTER"),
        FIT_END("FIT_END");

        public final int mId;

        ScaleType(String str) {
            this.mId = i;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class StreamState {
        public static final /* synthetic */ StreamState[] $VALUES;
        public static final StreamState IDLE;
        public static final StreamState STREAMING;

        static {
            StreamState streamState = new StreamState("IDLE", 0);
            IDLE = streamState;
            StreamState streamState2 = new StreamState("STREAMING", 1);
            STREAMING = streamState2;
            $VALUES = new StreamState[]{streamState, streamState2};
        }

        public static StreamState valueOf(String str) {
            return (StreamState) Enum.valueOf(StreamState.class, str);
        }

        public static StreamState[] values() {
            return (StreamState[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [androidx.camera.view.PreviewView$$ExternalSyntheticLambda0] */
    public PreviewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 0);
        this.mImplementationMode = ImplementationMode.PERFORMANCE;
        PreviewTransformation previewTransformation = new PreviewTransformation();
        previewTransformation.mScaleType = ScaleType.FILL_CENTER;
        this.mPreviewTransform = previewTransformation;
        this.mUseDisplayRotation = true;
        this.mPreviewStreamStateLiveData = new MutableLiveData(StreamState.IDLE);
        this.mActiveStreamStateObserver = new AtomicReference();
        this.mPreviewViewMeteringPointFactory = new PreviewViewMeteringPointFactory(previewTransformation);
        this.mDisplayRotationListener = new DisplayRotationListener();
        this.mOnLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: androidx.camera.view.PreviewView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                int i9 = PreviewView.$r8$clinit;
                if (i3 - i == i7 - i5 && i4 - i2 == i8 - i6) {
                    return;
                }
                PreviewView previewView = this.f$0;
                previewView.redrawPreview();
                CharsKt.checkMainThread();
                previewView.getViewPort();
            }
        };
        this.mSurfaceProvider = new AnonymousClass1(0, this);
        CharsKt.checkMainThread();
        Resources.Theme theme = context.getTheme();
        int[] iArr = R$styleable.PreviewView;
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        try {
            int integer = typedArrayObtainStyledAttributes.getInteger(1, previewTransformation.mScaleType.mId);
            for (ScaleType scaleType : ScaleType.values()) {
                if (scaleType.mId == integer) {
                    setScaleType(scaleType);
                    int integer2 = typedArrayObtainStyledAttributes.getInteger(0, 0);
                    for (ImplementationMode implementationMode : ImplementationMode.values()) {
                        if (implementationMode.mId == integer2) {
                            setImplementationMode(implementationMode);
                            typedArrayObtainStyledAttributes.recycle();
                            new StatusClient(context, new ZslControlImpl$$ExternalSyntheticLambda0(4));
                            if (getBackground() == null) {
                                setBackgroundColor(getContext().getColor(R.color.black));
                            }
                            ScreenFlashView screenFlashView = new ScreenFlashView(context, null, 0, 0);
                            screenFlashView.setBackgroundColor(-1);
                            screenFlashView.setAlpha(0.0f);
                            screenFlashView.setElevation(Float.MAX_VALUE);
                            this.mScreenFlashView = screenFlashView;
                            screenFlashView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                            return;
                        }
                    }
                    throw new IllegalArgumentException("Unknown implementation mode id " + integer2);
                }
            }
            throw new IllegalArgumentException("Unknown scale type id " + integer);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    private DisplayManager getDisplayManager() {
        Context context = getContext();
        if (context == null) {
            return null;
        }
        return (DisplayManager) context.getApplicationContext().getSystemService("display");
    }

    private ImageCapture.ScreenFlash getScreenFlashInternal() {
        return this.mScreenFlashView.getScreenFlash();
    }

    private int getViewPortScaleType() {
        int iOrdinal = getScaleType().ordinal();
        if (iOrdinal == 0) {
            return 0;
        }
        int i = 1;
        if (iOrdinal != 1) {
            i = 2;
            if (iOrdinal != 2) {
                i = 3;
                if (iOrdinal != 3 && iOrdinal != 4 && iOrdinal != 5) {
                    throw new IllegalStateException("Unexpected scale type: " + getScaleType());
                }
            }
        }
        return i;
    }

    private void setScreenFlashUiInfo(ImageCapture.ScreenFlash screenFlash) {
        Logger.d("PreviewView", "setScreenFlashUiInfo: mCameraController is null!");
    }

    public static boolean shouldUseTextureView(SurfaceRequest surfaceRequest, ImplementationMode implementationMode) {
        boolean zEquals = surfaceRequest.mCamera.getCameraInfoInternal().getImplementationType().equals("androidx.camera.camera2.legacy");
        boolean z = (androidx.camera.view.internal.compat.quirk.DeviceQuirks.sQuirks.get(SurfaceViewStretchedQuirk.class) == null && androidx.camera.view.internal.compat.quirk.DeviceQuirks.sQuirks.get(SurfaceViewNotCroppedByParentQuirk.class) == null) ? false : true;
        if (Build.VERSION.SDK_INT > 24 && !zEquals && !z) {
            int iOrdinal = implementationMode.ordinal();
            if (iOrdinal == 0) {
                return false;
            }
            if (iOrdinal != 1) {
                throw new IllegalArgumentException("Invalid implementation mode: " + implementationMode);
            }
        }
        return true;
    }

    public Bitmap getBitmap() {
        CharsKt.checkMainThread();
        PreviewViewImplementation previewViewImplementation = this.mImplementation;
        if (previewViewImplementation == null) {
            return null;
        }
        FrameLayout frameLayout = previewViewImplementation.mParent;
        Bitmap previewBitmap = previewViewImplementation.getPreviewBitmap();
        if (previewBitmap == null) {
            return null;
        }
        PreviewTransformation previewTransformation = previewViewImplementation.mPreviewTransform;
        Size size = new Size(frameLayout.getWidth(), frameLayout.getHeight());
        int layoutDirection = frameLayout.getLayoutDirection();
        if (!previewTransformation.isTransformationInfoReady()) {
            return previewBitmap;
        }
        Matrix textureViewCorrectionMatrix = previewTransformation.getTextureViewCorrectionMatrix();
        RectF transformedSurfaceRect = previewTransformation.getTransformedSurfaceRect(size, layoutDirection);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(size.getWidth(), size.getHeight(), previewBitmap.getConfig());
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Matrix matrix = new Matrix();
        matrix.postConcat(textureViewCorrectionMatrix);
        matrix.postScale(transformedSurfaceRect.width() / previewTransformation.mResolution.getWidth(), transformedSurfaceRect.height() / previewTransformation.mResolution.getHeight());
        matrix.postTranslate(transformedSurfaceRect.left, transformedSurfaceRect.top);
        canvas.drawBitmap(previewBitmap, matrix, new Paint(7));
        return bitmapCreateBitmap;
    }

    public CameraController getController() {
        CharsKt.checkMainThread();
        return null;
    }

    public ImplementationMode getImplementationMode() {
        CharsKt.checkMainThread();
        return this.mImplementationMode;
    }

    public MeteringPointFactory getMeteringPointFactory() {
        CharsKt.checkMainThread();
        return this.mPreviewViewMeteringPointFactory;
    }

    public OutputTransform getOutputTransform() {
        Matrix surfaceToPreviewViewMatrix;
        PreviewTransformation previewTransformation = this.mPreviewTransform;
        CharsKt.checkMainThread();
        try {
            surfaceToPreviewViewMatrix = previewTransformation.getSurfaceToPreviewViewMatrix(new Size(getWidth(), getHeight()), getLayoutDirection());
        } catch (IllegalStateException unused) {
            surfaceToPreviewViewMatrix = null;
        }
        Rect rect = previewTransformation.mSurfaceCropRect;
        if (surfaceToPreviewViewMatrix == null || rect == null) {
            Logger.d("PreviewView", "Transform info is not ready");
            return null;
        }
        RectF rectF = TransformUtils.NORMALIZED_RECT;
        RectF rectF2 = new RectF(rect);
        Matrix matrix = new Matrix();
        matrix.setRectToRect(TransformUtils.NORMALIZED_RECT, rectF2, Matrix.ScaleToFit.FILL);
        surfaceToPreviewViewMatrix.preConcat(matrix);
        if (this.mImplementation instanceof TextureViewImplementation) {
            surfaceToPreviewViewMatrix.postConcat(getMatrix());
        } else if (!getMatrix().isIdentity()) {
            Logger.w("PreviewView", "PreviewView needs to be in COMPATIBLE mode for the transform to work correctly.");
        }
        new Size(rect.width(), rect.height());
        return new OutputTransform();
    }

    public LiveData getPreviewStreamState() {
        return this.mPreviewStreamStateLiveData;
    }

    public ScaleType getScaleType() {
        CharsKt.checkMainThread();
        return this.mPreviewTransform.mScaleType;
    }

    public ImageCapture.ScreenFlash getScreenFlash() {
        return getScreenFlashInternal();
    }

    public Matrix getSensorToViewTransform() {
        CharsKt.checkMainThread();
        if (getWidth() == 0 || getHeight() == 0) {
            return null;
        }
        Size size = new Size(getWidth(), getHeight());
        int layoutDirection = getLayoutDirection();
        PreviewTransformation previewTransformation = this.mPreviewTransform;
        if (!previewTransformation.isTransformationInfoReady()) {
            return null;
        }
        Matrix matrix = new Matrix(previewTransformation.mSensorToBufferTransform);
        matrix.postConcat(previewTransformation.getSurfaceToPreviewViewMatrix(size, layoutDirection));
        return matrix;
    }

    public Preview.SurfaceProvider getSurfaceProvider() {
        CharsKt.checkMainThread();
        return this.mSurfaceProvider;
    }

    public ViewPort getViewPort() {
        CharsKt.checkMainThread();
        if (getDisplay() == null) {
            return null;
        }
        getDisplay().getRotation();
        CharsKt.checkMainThread();
        if (getWidth() == 0 || getHeight() == 0) {
            return null;
        }
        new Rational(getWidth(), getHeight());
        getViewPortScaleType();
        getLayoutDirection();
        return new ViewPort();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        DisplayManager displayManager = getDisplayManager();
        if (displayManager != null) {
            displayManager.registerDisplayListener(this.mDisplayRotationListener, new Handler(Looper.getMainLooper()));
        }
        addOnLayoutChangeListener(this.mOnLayoutChangeListener);
        PreviewViewImplementation previewViewImplementation = this.mImplementation;
        if (previewViewImplementation != null) {
            previewViewImplementation.onAttachedToWindow();
        }
        CharsKt.checkMainThread();
        getViewPort();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeOnLayoutChangeListener(this.mOnLayoutChangeListener);
        PreviewViewImplementation previewViewImplementation = this.mImplementation;
        if (previewViewImplementation != null) {
            previewViewImplementation.onDetachedFromWindow();
        }
        DisplayManager displayManager = getDisplayManager();
        if (displayManager == null) {
            return;
        }
        displayManager.unregisterDisplayListener(this.mDisplayRotationListener);
    }

    public final void redrawPreview() {
        Rect rect;
        Display display;
        CameraInfoInternal cameraInfoInternal;
        CharsKt.checkMainThread();
        if (this.mImplementation != null) {
            if (this.mUseDisplayRotation && (display = getDisplay()) != null && (cameraInfoInternal = this.mCameraInfoInternal) != null) {
                PreviewTransformation previewTransformation = this.mPreviewTransform;
                int sensorRotationDegrees = cameraInfoInternal.getSensorRotationDegrees(display.getRotation());
                int rotation = display.getRotation();
                if (previewTransformation.mHasCameraTransform) {
                    previewTransformation.mPreviewRotationDegrees = sensorRotationDegrees;
                    previewTransformation.mTargetRotation = rotation;
                }
            }
            this.mImplementation.redrawPreview();
        }
        PreviewViewMeteringPointFactory previewViewMeteringPointFactory = this.mPreviewViewMeteringPointFactory;
        Size size = new Size(getWidth(), getHeight());
        int layoutDirection = getLayoutDirection();
        previewViewMeteringPointFactory.getClass();
        CharsKt.checkMainThread();
        synchronized (previewViewMeteringPointFactory) {
            try {
                if (size.getWidth() != 0 && size.getHeight() != 0 && (rect = previewViewMeteringPointFactory.mSensorRect) != null) {
                    previewViewMeteringPointFactory.mPreviewTransformation.getPreviewViewToNormalizedSensorMatrix(size, layoutDirection, rect);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setController(CameraController cameraController) {
        CharsKt.checkMainThread();
        CharsKt.checkMainThread();
        getViewPort();
        setScreenFlashUiInfo(getScreenFlashInternal());
    }

    public void setImplementationMode(ImplementationMode implementationMode) {
        CharsKt.checkMainThread();
        this.mImplementationMode = implementationMode;
    }

    public void setScaleType(ScaleType scaleType) {
        CharsKt.checkMainThread();
        this.mPreviewTransform.mScaleType = scaleType;
        redrawPreview();
        CharsKt.checkMainThread();
        getViewPort();
    }

    public void setScreenFlashOverlayColor(int i) {
        this.mScreenFlashView.setBackgroundColor(i);
    }

    public void setScreenFlashWindow(Window window) {
        CharsKt.checkMainThread();
        this.mScreenFlashView.setScreenFlashWindow(window);
        setScreenFlashUiInfo(getScreenFlashInternal());
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class DisplayRotationListener implements DisplayManager.DisplayListener {
        public DisplayRotationListener() {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayChanged(int i) {
            PreviewView previewView = PreviewView.this;
            Display display = previewView.getDisplay();
            if (display == null || display.getDisplayId() != i) {
                return;
            }
            previewView.redrawPreview();
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayAdded(int i) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public final void onDisplayRemoved(int i) {
        }
    }
}
