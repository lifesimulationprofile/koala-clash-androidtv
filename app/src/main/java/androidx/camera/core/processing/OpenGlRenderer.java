package androidx.camera.core.processing;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.camera.core.Logger;
import androidx.camera.core.processing.util.AutoValue_GraphicDeviceInfo;
import androidx.camera.core.processing.util.AutoValue_OutputSurface;
import androidx.camera.core.processing.util.GLUtils;
import androidx.camera.view.PreviewView;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.internal.RuntimeHelpersKt;
import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.ArcSpline$Arc;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.VectorizedAnimationSpecKt;
import androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec;
import androidx.compose.animation.core.VectorizedKeyframeSpecElementInfo;
import androidx.core.util.Pair;
import androidx.core.util.Preconditions;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class OpenGlRenderer implements VectorizedDurationBasedAnimationSpec {
    public Object mCurrentInputformat;
    public Object mCurrentProgram;
    public Object mCurrentSurface;
    public Object mEglConfig;
    public Object mEglContext;
    public Object mEglDisplay;
    public int mExternalTextureId;
    public Object mGlThread;
    public final Object mInitialized;
    public final Object mOutputSurfaceMap;
    public Object mProgramHandles;
    public int[] mSurfaceAttrib;
    public Object mTempSurface;

    public OpenGlRenderer() {
        this.mInitialized = new AtomicBoolean(false);
        this.mOutputSurfaceMap = new HashMap();
        this.mEglDisplay = EGL14.EGL_NO_DISPLAY;
        this.mEglContext = EGL14.EGL_NO_CONTEXT;
        this.mSurfaceAttrib = GLUtils.EMPTY_ATTRIBS;
        this.mTempSurface = EGL14.EGL_NO_SURFACE;
        this.mProgramHandles = Collections.EMPTY_MAP;
        this.mCurrentProgram = null;
        this.mCurrentInputformat = GLUtils.InputFormat.UNKNOWN;
        this.mExternalTextureId = -1;
    }

    public void createEglContext(DynamicRange dynamicRange, Dispatcher dispatcher) {
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        this.mEglDisplay = eGLDisplayEglGetDisplay;
        if (Objects.equals(eGLDisplayEglGetDisplay, EGL14.EGL_NO_DISPLAY)) {
            throw new IllegalStateException("Unable to get EGL14 display");
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize((EGLDisplay) this.mEglDisplay, iArr, 0, iArr, 1)) {
            this.mEglDisplay = EGL14.EGL_NO_DISPLAY;
            throw new IllegalStateException("Unable to initialize EGL14");
        }
        if (dispatcher != null) {
            String str = iArr[0] + "." + iArr[1];
            if (str == null) {
                throw new NullPointerException("Null eglVersion");
            }
            dispatcher.readyAsyncCalls = str;
        }
        int i = dynamicRange.is10BitHdr() ? 10 : 8;
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!EGL14.eglChooseConfig((EGLDisplay) this.mEglDisplay, new int[]{12324, i, 12323, i, 12322, i, 12321, dynamicRange.is10BitHdr() ? 2 : 8, 12325, 0, 12326, 0, 12352, dynamicRange.is10BitHdr() ? 64 : 4, 12610, dynamicRange.is10BitHdr() ? -1 : 1, 12339, 5, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            throw new IllegalStateException("Unable to find a suitable EGLConfig");
        }
        EGLConfig eGLConfig = eGLConfigArr[0];
        EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext((EGLDisplay) this.mEglDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, new int[]{12440, dynamicRange.is10BitHdr() ? 3 : 2, 12344}, 0);
        GLUtils.checkEglErrorOrThrow("eglCreateContext");
        this.mEglConfig = eGLConfig;
        this.mEglContext = eGLContextEglCreateContext;
        int[] iArr2 = new int[1];
        EGL14.eglQueryContext((EGLDisplay) this.mEglDisplay, eGLContextEglCreateContext, 12440, iArr2, 0);
        Log.d("OpenGlRenderer", "EGLContext created, client version " + iArr2[0]);
    }

    public AutoValue_OutputSurface createOutputSurfaceInternal(Surface surface) {
        try {
            EGLDisplay eGLDisplay = (EGLDisplay) this.mEglDisplay;
            EGLConfig eGLConfig = (EGLConfig) this.mEglConfig;
            Objects.requireNonNull(eGLConfig);
            EGLSurface eGLSurfaceCreateWindowSurface = GLUtils.createWindowSurface(eGLDisplay, eGLConfig, surface, this.mSurfaceAttrib);
            EGLDisplay eGLDisplay2 = (EGLDisplay) this.mEglDisplay;
            int[] iArr = new int[1];
            EGL14.eglQuerySurface(eGLDisplay2, eGLSurfaceCreateWindowSurface, 12375, iArr, 0);
            int i = iArr[0];
            int[] iArr2 = new int[1];
            EGL14.eglQuerySurface(eGLDisplay2, eGLSurfaceCreateWindowSurface, 12374, iArr2, 0);
            Size size = new Size(i, iArr2[0]);
            return new AutoValue_OutputSurface(eGLSurfaceCreateWindowSurface, size.getWidth(), size.getHeight());
        } catch (IllegalArgumentException | IllegalStateException e) {
            Logger.w("OpenGlRenderer", "Failed to create EGL surface: " + e.getMessage(), e);
            return null;
        }
    }

    public void createTempSurface() {
        EGLDisplay eGLDisplay = (EGLDisplay) this.mEglDisplay;
        EGLConfig eGLConfig = (EGLConfig) this.mEglConfig;
        Objects.requireNonNull(eGLConfig);
        int[] iArr = GLUtils.EMPTY_ATTRIBS;
        EGLSurface eGLSurfaceEglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, new int[]{12375, 1, 12374, 1, 12344}, 0);
        GLUtils.checkEglErrorOrThrow("eglCreatePbufferSurface");
        if (eGLSurfaceEglCreatePbufferSurface == null) {
            throw new IllegalStateException("surface was null");
        }
        this.mTempSurface = eGLSurfaceEglCreatePbufferSurface;
    }

    public int findEntryForTimeMillis(int i) {
        int i2;
        MutableIntList mutableIntList = (MutableIntList) this.mInitialized;
        int i3 = mutableIntList._size;
        mutableIntList.getClass();
        if (i3 <= 0 || i3 > mutableIntList._size) {
            RuntimeHelpersKt.throwIndexOutOfBoundsException("");
            throw null;
        }
        int i4 = i3 - 1;
        int i5 = 0;
        while (true) {
            if (i5 <= i4) {
                i2 = (i5 + i4) >>> 1;
                int i6 = mutableIntList.content[i2];
                if (i6 >= i) {
                    if (i6 <= i) {
                        break;
                    }
                    i4 = i2 - 1;
                } else {
                    i5 = i2 + 1;
                }
            } else {
                i2 = -(i5 + 1);
                break;
            }
        }
        return i2 < -1 ? -(i2 + 2) : i2;
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int getDelayMillis() {
        return 0;
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int getDurationMillis() {
        return this.mExternalTextureId;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public long getDurationNanos(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return ((long) getDurationMillis()) * 1000000;
    }

    public float getEasedTimeFromIndex(int i, int i2, boolean z) {
        Easing easing;
        float f;
        MutableIntList mutableIntList = (MutableIntList) this.mInitialized;
        if (i >= mutableIntList._size - 1) {
            f = i2;
        } else {
            int i3 = mutableIntList.get(i);
            int i4 = mutableIntList.get(i + 1);
            if (i2 == i3) {
                f = i3;
            } else {
                int i5 = i4 - i3;
                VectorizedKeyframeSpecElementInfo vectorizedKeyframeSpecElementInfo = (VectorizedKeyframeSpecElementInfo) ((MutableIntObjectMap) this.mOutputSurfaceMap).get(i3);
                if (vectorizedKeyframeSpecElementInfo == null || (easing = vectorizedKeyframeSpecElementInfo.easing) == null) {
                    easing = (Easing) this.mGlThread;
                }
                float f2 = i5;
                float fTransform = easing.transform((i2 - i3) / f2);
                if (z) {
                    return fTransform;
                }
                f = (f2 * fTransform) + i3;
            }
        }
        return f / 1000;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector getEndVelocity(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return getVelocityFromNanos(getDurationNanos(animationVector, animationVector2, animationVector3), animationVector, animationVector2, animationVector3);
    }

    public Pair getExtensionsBeforeInitialized(DynamicRange dynamicRange) {
        GLUtils.checkInitializedOrThrow((AtomicBoolean) this.mInitialized, false);
        try {
            createEglContext(dynamicRange, null);
            createTempSurface();
            makeCurrent((EGLSurface) this.mTempSurface);
            String strGlGetString = GLES20.glGetString(7939);
            String strEglQueryString = EGL14.eglQueryString((EGLDisplay) this.mEglDisplay, 12373);
            if (strGlGetString == null) {
                strGlGetString = "";
            }
            if (strEglQueryString == null) {
                strEglQueryString = "";
            }
            return new Pair(strGlGetString, strEglQueryString);
        } catch (IllegalStateException e) {
            Logger.w("OpenGlRenderer", "Failed to get GL or EGL extensions: " + e.getMessage(), e);
            return new Pair("", "");
        } finally {
            releaseInternal();
        }
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector getValueFromNanos(long j, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        AnimationVector animationVector4;
        AnimationVector animationVector5;
        float f;
        AnimationVector animationVector6 = animationVector;
        AnimationVector animationVector7 = animationVector2;
        MutableIntList mutableIntList = (MutableIntList) this.mInitialized;
        int[] iArr = VectorizedAnimationSpecKt.EmptyIntArray;
        int i = 0;
        long j2 = (j / 1000000) - ((long) 0);
        int i2 = this.mExternalTextureId;
        long j3 = i2;
        if (j2 < 0) {
            j2 = 0;
        }
        if (j2 <= j3) {
            j3 = j2;
        }
        int i3 = (int) j3;
        MutableIntObjectMap mutableIntObjectMap = (MutableIntObjectMap) this.mOutputSurfaceMap;
        VectorizedKeyframeSpecElementInfo vectorizedKeyframeSpecElementInfo = (VectorizedKeyframeSpecElementInfo) mutableIntObjectMap.get(i3);
        if (vectorizedKeyframeSpecElementInfo != null) {
            return vectorizedKeyframeSpecElementInfo.vectorValue;
        }
        if (i3 >= i2) {
            return animationVector7;
        }
        if (i3 <= 0) {
            return animationVector6;
        }
        init(animationVector6, animationVector7, animationVector3);
        AnimationVector animationVector8 = (AnimationVector) this.mEglContext;
        boolean z = true;
        if (((PreviewView.AnonymousClass1) this.mCurrentInputformat) != VectorizedAnimationSpecKt.EmptyArcSpline) {
            float easedTimeFromIndex = getEasedTimeFromIndex(findEntryForTimeMillis(i3), i3, false);
            float[] fArr = (float[]) this.mProgramHandles;
            ArcSpline$Arc[][] arcSpline$ArcArr = (ArcSpline$Arc[][]) ((PreviewView.AnonymousClass1) this.mCurrentInputformat).this$0;
            int length = arcSpline$ArcArr.length - 1;
            float f2 = arcSpline$ArcArr[0][0].time1;
            float f3 = arcSpline$ArcArr[length][0].time2;
            int length2 = fArr.length;
            if (easedTimeFromIndex < f2 || easedTimeFromIndex > f3) {
                if (easedTimeFromIndex > f3) {
                    f2 = f3;
                } else {
                    length = 0;
                }
                float f4 = easedTimeFromIndex - f2;
                int i4 = 0;
                int i5 = 0;
                while (i4 < length2 - 1) {
                    ArcSpline$Arc arcSpline$Arc = arcSpline$ArcArr[length][i5];
                    boolean z2 = arcSpline$Arc.isLinear;
                    float f5 = arcSpline$Arc.ellipseCenterY;
                    float f6 = arcSpline$Arc.ellipseCenterX;
                    if (z2) {
                        float f7 = arcSpline$Arc.time1;
                        float f8 = arcSpline$Arc.oneOverDeltaTime;
                        f = f4;
                        float f9 = arcSpline$Arc.x1;
                        fArr[i4] = (f * f6) + ImageAnalysis$$ExternalSyntheticLambda1.m(arcSpline$Arc.x2, f9, (f2 - f7) * f8, f9);
                        float f10 = (f2 - f7) * f8;
                        float f11 = arcSpline$Arc.y1;
                        fArr[i4 + 1] = (f * f5) + ImageAnalysis$$ExternalSyntheticLambda1.m(arcSpline$Arc.y2, f11, f10, f11);
                    } else {
                        f = f4;
                        arcSpline$Arc.setPoint(f2);
                        fArr[i4] = (arcSpline$Arc.calcDX() * f) + (arcSpline$Arc.ellipseA * arcSpline$Arc.tmpSinAngle) + f6;
                        fArr[i4 + 1] = (arcSpline$Arc.calcDY() * f) + (arcSpline$Arc.ellipseB * arcSpline$Arc.tmpCosAngle) + f5;
                    }
                    i4 += 2;
                    i5++;
                    f4 = f;
                    arcSpline$ArcArr = arcSpline$ArcArr;
                }
            } else {
                int length3 = arcSpline$ArcArr.length;
                int i6 = 0;
                boolean z3 = false;
                while (i6 < length3) {
                    int i7 = i;
                    int i8 = i7;
                    while (i7 < length2 - 1) {
                        ArcSpline$Arc arcSpline$Arc2 = arcSpline$ArcArr[i6][i8];
                        if (easedTimeFromIndex <= arcSpline$Arc2.time2) {
                            if (arcSpline$Arc2.isLinear) {
                                float f12 = arcSpline$Arc2.time1;
                                float f13 = arcSpline$Arc2.oneOverDeltaTime;
                                float f14 = arcSpline$Arc2.x1;
                                fArr[i7] = ImageAnalysis$$ExternalSyntheticLambda1.m(arcSpline$Arc2.x2, f14, (easedTimeFromIndex - f12) * f13, f14);
                                float f15 = arcSpline$Arc2.y1;
                                fArr[i7 + 1] = ImageAnalysis$$ExternalSyntheticLambda1.m(arcSpline$Arc2.y2, f15, (easedTimeFromIndex - f12) * f13, f15);
                            } else {
                                arcSpline$Arc2.setPoint(easedTimeFromIndex);
                                fArr[i7] = (arcSpline$Arc2.ellipseA * arcSpline$Arc2.tmpSinAngle) + arcSpline$Arc2.ellipseCenterX;
                                fArr[i7 + 1] = (arcSpline$Arc2.ellipseB * arcSpline$Arc2.tmpCosAngle) + arcSpline$Arc2.ellipseCenterY;
                            }
                            z3 = z;
                        } else {
                            z = z;
                        }
                        i7 += 2;
                        i8++;
                        z = z;
                    }
                    boolean z4 = z;
                    if (z3) {
                        break;
                    }
                    i6++;
                    z = z4;
                    i = 0;
                }
            }
            int length4 = fArr.length;
            for (int i9 = 0; i9 < length4; i9++) {
                animationVector8.set$animation_core(i9, fArr[i9]);
            }
        } else {
            int iFindEntryForTimeMillis = findEntryForTimeMillis(i3);
            float easedTimeFromIndex2 = getEasedTimeFromIndex(iFindEntryForTimeMillis, i3, true);
            VectorizedKeyframeSpecElementInfo vectorizedKeyframeSpecElementInfo2 = (VectorizedKeyframeSpecElementInfo) mutableIntObjectMap.get(mutableIntList.get(iFindEntryForTimeMillis));
            if (vectorizedKeyframeSpecElementInfo2 != null && (animationVector5 = vectorizedKeyframeSpecElementInfo2.vectorValue) != null) {
                animationVector6 = animationVector5;
            }
            VectorizedKeyframeSpecElementInfo vectorizedKeyframeSpecElementInfo3 = (VectorizedKeyframeSpecElementInfo) mutableIntObjectMap.get(mutableIntList.get(iFindEntryForTimeMillis + 1));
            if (vectorizedKeyframeSpecElementInfo3 != null && (animationVector4 = vectorizedKeyframeSpecElementInfo3.vectorValue) != null) {
                animationVector7 = animationVector4;
            }
            int size$animation_core = animationVector8.getSize$animation_core();
            for (int i10 = 0; i10 < size$animation_core; i10++) {
                animationVector8.set$animation_core(i10, (animationVector7.get$animation_core(i10) * easedTimeFromIndex2) + ((1 - easedTimeFromIndex2) * animationVector6.get$animation_core(i10)));
            }
        }
        return animationVector8;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector getVelocityFromNanos(long j, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        int[] iArr = VectorizedAnimationSpecKt.EmptyIntArray;
        int i = 0;
        long j2 = (j / 1000000) - ((long) 0);
        long j3 = this.mExternalTextureId;
        if (j2 < 0) {
            j2 = 0;
        }
        long j4 = j2 > j3 ? j3 : j2;
        if (j4 < 0) {
            return animationVector3;
        }
        init(animationVector, animationVector2, animationVector3);
        AnimationVector animationVector4 = (AnimationVector) this.mEglConfig;
        if (((PreviewView.AnonymousClass1) this.mCurrentInputformat) != VectorizedAnimationSpecKt.EmptyArcSpline) {
            int i2 = (int) j4;
            float easedTimeFromIndex = getEasedTimeFromIndex(findEntryForTimeMillis(i2), i2, false);
            float[] fArr = (float[]) this.mCurrentProgram;
            ArcSpline$Arc[][] arcSpline$ArcArr = (ArcSpline$Arc[][]) ((PreviewView.AnonymousClass1) this.mCurrentInputformat).this$0;
            float f = arcSpline$ArcArr[0][0].time1;
            float f2 = arcSpline$ArcArr[arcSpline$ArcArr.length - 1][0].time2;
            if (easedTimeFromIndex < f) {
                easedTimeFromIndex = f;
            }
            if (easedTimeFromIndex <= f2) {
                f2 = easedTimeFromIndex;
            }
            int length = fArr.length;
            boolean z = false;
            for (ArcSpline$Arc[] arcSpline$ArcArr2 : arcSpline$ArcArr) {
                int i3 = 0;
                int i4 = 0;
                while (i3 < length - 1) {
                    ArcSpline$Arc arcSpline$Arc = arcSpline$ArcArr2[i4];
                    if (f2 <= arcSpline$Arc.time2) {
                        if (arcSpline$Arc.isLinear) {
                            fArr[i3] = arcSpline$Arc.ellipseCenterX;
                            fArr[i3 + 1] = arcSpline$Arc.ellipseCenterY;
                        } else {
                            arcSpline$Arc.setPoint(f2);
                            fArr[i3] = arcSpline$Arc.calcDX();
                            fArr[i3 + 1] = arcSpline$Arc.calcDY();
                        }
                        z = true;
                    }
                    i3 += 2;
                    i4++;
                }
                if (z) {
                    break;
                }
            }
            int length2 = fArr.length;
            while (i < length2) {
                animationVector4.set$animation_core(i, fArr[i]);
                i++;
            }
        } else {
            AnimationVector valueFromNanos = getValueFromNanos((j4 - 1) * 1000000, animationVector, animationVector2, animationVector3);
            AnimationVector valueFromNanos2 = getValueFromNanos(j4 * 1000000, animationVector, animationVector2, animationVector3);
            int size$animation_core = valueFromNanos.getSize$animation_core();
            while (i < size$animation_core) {
                animationVector4.set$animation_core(i, (valueFromNanos.get$animation_core(i) - valueFromNanos2.get$animation_core(i)) * 1000.0f);
                i++;
            }
        }
        return animationVector4;
    }

    public AutoValue_GraphicDeviceInfo init(DynamicRange dynamicRange) throws Throwable {
        Map map = Collections.EMPTY_MAP;
        AtomicBoolean atomicBoolean = (AtomicBoolean) this.mInitialized;
        GLUtils.checkInitializedOrThrow(atomicBoolean, false);
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.executorServiceOrNull = "0.0";
        dispatcher.readyAsyncCalls = "0.0";
        dispatcher.runningAsyncCalls = "";
        dispatcher.runningSyncCalls = "";
        try {
            if (dynamicRange.is10BitHdr()) {
                Pair extensionsBeforeInitialized = getExtensionsBeforeInitialized(dynamicRange);
                String str = (String) extensionsBeforeInitialized.first;
                String str2 = (String) extensionsBeforeInitialized.second;
                if (!str.contains("GL_EXT_YUV_target")) {
                    Logger.w("OpenGlRenderer", "Device does not support GL_EXT_YUV_target. Fallback to SDR.");
                    dynamicRange = DynamicRange.SDR;
                }
                this.mSurfaceAttrib = GLUtils.chooseSurfaceAttrib(str2, dynamicRange);
                dispatcher.runningAsyncCalls = str;
                dispatcher.runningSyncCalls = str2;
            }
            createEglContext(dynamicRange, dispatcher);
            createTempSurface();
            makeCurrent((EGLSurface) this.mTempSurface);
            String glVersionNumber = GLUtils.getGlVersionNumber();
            if (glVersionNumber == null) {
                throw new NullPointerException("Null glVersion");
            }
            dispatcher.executorServiceOrNull = glVersionNumber;
            this.mProgramHandles = GLUtils.createPrograms(dynamicRange);
            int iCreateTexture = GLUtils.createTexture();
            this.mExternalTextureId = iCreateTexture;
            useAndConfigureProgramWithTexture(iCreateTexture);
            this.mGlThread = Thread.currentThread();
            atomicBoolean.set(true);
            String strConcat = ((String) dispatcher.executorServiceOrNull) == null ? " glVersion" : "";
            if (((String) dispatcher.readyAsyncCalls) == null) {
                strConcat = strConcat.concat(" eglVersion");
            }
            if (strConcat.isEmpty()) {
                return new AutoValue_GraphicDeviceInfo((String) dispatcher.executorServiceOrNull, (String) dispatcher.readyAsyncCalls, (String) dispatcher.runningAsyncCalls, (String) dispatcher.runningSyncCalls);
            }
            throw new IllegalStateException("Missing required properties:".concat(strConcat));
        } catch (IllegalArgumentException e) {
            e = e;
            releaseInternal();
            throw e;
        } catch (IllegalStateException e2) {
            e = e2;
            releaseInternal();
            throw e;
        }
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public /* synthetic */ boolean isInfinite() {
        return false;
    }

    public void makeCurrent(EGLSurface eGLSurface) {
        ((EGLDisplay) this.mEglDisplay).getClass();
        ((EGLContext) this.mEglContext).getClass();
        if (!EGL14.eglMakeCurrent((EGLDisplay) this.mEglDisplay, eGLSurface, eGLSurface, (EGLContext) this.mEglContext)) {
            throw new IllegalStateException("eglMakeCurrent failed");
        }
    }

    public void registerOutputSurface(Surface surface) {
        GLUtils.checkInitializedOrThrow((AtomicBoolean) this.mInitialized, true);
        GLUtils.checkGlThreadOrThrow((Thread) this.mGlThread);
        HashMap map = (HashMap) this.mOutputSurfaceMap;
        if (map.containsKey(surface)) {
            return;
        }
        map.put(surface, GLUtils.NO_OUTPUT_SURFACE);
    }

    public void release() {
        if (((AtomicBoolean) this.mInitialized).getAndSet(false)) {
            GLUtils.checkGlThreadOrThrow((Thread) this.mGlThread);
            releaseInternal();
        }
    }

    public void releaseInternal() {
        HashMap map = (HashMap) this.mOutputSurfaceMap;
        Iterator it = ((Map) this.mProgramHandles).values().iterator();
        while (it.hasNext()) {
            GLES20.glDeleteProgram(((GLUtils.Program2D) it.next()).mProgramHandle);
        }
        this.mProgramHandles = Collections.EMPTY_MAP;
        this.mCurrentProgram = null;
        if (!Objects.equals((EGLDisplay) this.mEglDisplay, EGL14.EGL_NO_DISPLAY)) {
            EGLDisplay eGLDisplay = (EGLDisplay) this.mEglDisplay;
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            for (AutoValue_OutputSurface autoValue_OutputSurface : map.values()) {
                if (!Objects.equals(autoValue_OutputSurface.eglSurface, EGL14.EGL_NO_SURFACE) && !EGL14.eglDestroySurface((EGLDisplay) this.mEglDisplay, autoValue_OutputSurface.eglSurface)) {
                    try {
                        GLUtils.checkEglErrorOrThrow("eglDestroySurface");
                    } catch (IllegalStateException e) {
                        Logger.e("GLUtils", e.toString(), e);
                    }
                }
            }
            map.clear();
            if (!Objects.equals((EGLSurface) this.mTempSurface, EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface((EGLDisplay) this.mEglDisplay, (EGLSurface) this.mTempSurface);
                this.mTempSurface = EGL14.EGL_NO_SURFACE;
            }
            if (!Objects.equals((EGLContext) this.mEglContext, EGL14.EGL_NO_CONTEXT)) {
                EGL14.eglDestroyContext((EGLDisplay) this.mEglDisplay, (EGLContext) this.mEglContext);
                this.mEglContext = EGL14.EGL_NO_CONTEXT;
            }
            EGL14.eglReleaseThread();
            EGL14.eglTerminate((EGLDisplay) this.mEglDisplay);
            this.mEglDisplay = EGL14.EGL_NO_DISPLAY;
        }
        this.mEglConfig = null;
        this.mExternalTextureId = -1;
        this.mCurrentInputformat = GLUtils.InputFormat.UNKNOWN;
        this.mCurrentSurface = null;
        this.mGlThread = null;
    }

    public void removeOutputSurfaceInternal(Surface surface, boolean z) {
        HashMap map = (HashMap) this.mOutputSurfaceMap;
        if (((Surface) this.mCurrentSurface) == surface) {
            this.mCurrentSurface = null;
            makeCurrent((EGLSurface) this.mTempSurface);
        }
        AutoValue_OutputSurface autoValue_OutputSurface = z ? (AutoValue_OutputSurface) map.remove(surface) : (AutoValue_OutputSurface) map.put(surface, GLUtils.NO_OUTPUT_SURFACE);
        if (autoValue_OutputSurface == null || autoValue_OutputSurface == GLUtils.NO_OUTPUT_SURFACE) {
            return;
        }
        try {
            EGL14.eglDestroySurface((EGLDisplay) this.mEglDisplay, autoValue_OutputSurface.eglSurface);
        } catch (RuntimeException e) {
            Logger.w("OpenGlRenderer", "Failed to destroy EGL surface: " + e.getMessage(), e);
        }
    }

    public void render(long j, float[] fArr, Surface surface) {
        GLUtils.checkInitializedOrThrow((AtomicBoolean) this.mInitialized, true);
        GLUtils.checkGlThreadOrThrow((Thread) this.mGlThread);
        HashMap map = (HashMap) this.mOutputSurfaceMap;
        Preconditions.checkState("The surface is not registered.", map.containsKey(surface));
        AutoValue_OutputSurface autoValue_OutputSurfaceCreateOutputSurfaceInternal = (AutoValue_OutputSurface) map.get(surface);
        Objects.requireNonNull(autoValue_OutputSurfaceCreateOutputSurfaceInternal);
        if (autoValue_OutputSurfaceCreateOutputSurfaceInternal == GLUtils.NO_OUTPUT_SURFACE) {
            autoValue_OutputSurfaceCreateOutputSurfaceInternal = createOutputSurfaceInternal(surface);
            if (autoValue_OutputSurfaceCreateOutputSurfaceInternal == null) {
                return;
            } else {
                map.put(surface, autoValue_OutputSurfaceCreateOutputSurfaceInternal);
            }
        }
        int i = autoValue_OutputSurfaceCreateOutputSurfaceInternal.height;
        int i2 = autoValue_OutputSurfaceCreateOutputSurfaceInternal.width;
        EGLSurface eGLSurface = autoValue_OutputSurfaceCreateOutputSurfaceInternal.eglSurface;
        if (surface != ((Surface) this.mCurrentSurface)) {
            makeCurrent(eGLSurface);
            this.mCurrentSurface = surface;
            GLES20.glViewport(0, 0, i2, i);
            GLES20.glScissor(0, 0, i2, i);
        }
        GLUtils.Program2D program2D = (GLUtils.Program2D) this.mCurrentProgram;
        program2D.getClass();
        if (program2D instanceof GLUtils.SamplerShaderProgram) {
            GLES20.glUniformMatrix4fv(((GLUtils.SamplerShaderProgram) program2D).mTexMatrixLoc, 1, false, fArr, 0);
            GLUtils.checkGlErrorOrThrow("glUniformMatrix4fv");
        }
        GLES20.glDrawArrays(5, 0, 4);
        GLUtils.checkGlErrorOrThrow("glDrawArrays");
        EGLExt.eglPresentationTimeANDROID((EGLDisplay) this.mEglDisplay, eGLSurface, j);
        if (EGL14.eglSwapBuffers((EGLDisplay) this.mEglDisplay, eGLSurface)) {
            return;
        }
        Logger.w("OpenGlRenderer", "Failed to swap buffers with EGL error: 0x" + Integer.toHexString(EGL14.eglGetError()));
        removeOutputSurfaceInternal(surface, false);
    }

    public void useAndConfigureProgramWithTexture(int i) {
        GLUtils.Program2D program2D = (GLUtils.Program2D) ((Map) this.mProgramHandles).get((GLUtils.InputFormat) this.mCurrentInputformat);
        if (program2D == null) {
            throw new IllegalStateException("Unable to configure program for input format: " + ((GLUtils.InputFormat) this.mCurrentInputformat));
        }
        if (((GLUtils.Program2D) this.mCurrentProgram) != program2D) {
            this.mCurrentProgram = program2D;
            program2D.use();
            Log.d("OpenGlRenderer", "Using program for input format " + ((GLUtils.InputFormat) this.mCurrentInputformat) + ": " + ((GLUtils.Program2D) this.mCurrentProgram));
        }
        GLES20.glActiveTexture(33984);
        GLUtils.checkGlErrorOrThrow("glActiveTexture");
        GLES20.glBindTexture(36197, i);
        GLUtils.checkGlErrorOrThrow("glBindTexture");
    }

    public OpenGlRenderer(MutableIntList mutableIntList, MutableIntObjectMap mutableIntObjectMap, int i, Easing easing) {
        this.mInitialized = mutableIntList;
        this.mOutputSurfaceMap = mutableIntObjectMap;
        this.mExternalTextureId = i;
        this.mGlThread = easing;
        this.mSurfaceAttrib = VectorizedAnimationSpecKt.EmptyIntArray;
        float[] fArr = VectorizedAnimationSpecKt.EmptyFloatArray;
        this.mEglDisplay = fArr;
        this.mProgramHandles = fArr;
        this.mCurrentProgram = fArr;
        this.mCurrentInputformat = VectorizedAnimationSpecKt.EmptyArcSpline;
    }

    public void init(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        float[] fArr;
        MutableIntObjectMap mutableIntObjectMap = (MutableIntObjectMap) this.mOutputSurfaceMap;
        MutableIntList mutableIntList = (MutableIntList) this.mInitialized;
        boolean z = ((PreviewView.AnonymousClass1) this.mCurrentInputformat) != VectorizedAnimationSpecKt.EmptyArcSpline;
        if (((AnimationVector) this.mEglContext) == null) {
            this.mEglContext = animationVector.newVector$animation_core();
            this.mEglConfig = animationVector3.newVector$animation_core();
            int i = mutableIntList._size;
            float[] fArr2 = new float[i];
            for (int i2 = 0; i2 < i; i2++) {
                fArr2[i2] = mutableIntList.get(i2) / 1000;
            }
            this.mEglDisplay = fArr2;
            int i3 = mutableIntList._size;
            int[] iArr = new int[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                iArr[i4] = 0;
            }
            this.mSurfaceAttrib = iArr;
        }
        if (z) {
            if (((PreviewView.AnonymousClass1) this.mCurrentInputformat) != VectorizedAnimationSpecKt.EmptyArcSpline && Intrinsics.areEqual((AnimationVector) this.mTempSurface, animationVector) && Intrinsics.areEqual((AnimationVector) this.mCurrentSurface, animationVector2)) {
                return;
            }
            this.mTempSurface = animationVector;
            this.mCurrentSurface = animationVector2;
            int size$animation_core = animationVector.getSize$animation_core() + (animationVector.getSize$animation_core() % 2);
            this.mProgramHandles = new float[size$animation_core];
            this.mCurrentProgram = new float[size$animation_core];
            int i5 = mutableIntList._size;
            float[][] fArr3 = new float[i5][];
            for (int i6 = 0; i6 < i5; i6++) {
                int i7 = mutableIntList.get(i6);
                VectorizedKeyframeSpecElementInfo vectorizedKeyframeSpecElementInfo = (VectorizedKeyframeSpecElementInfo) mutableIntObjectMap.get(i7);
                if (i7 == 0 && vectorizedKeyframeSpecElementInfo == null) {
                    fArr = new float[size$animation_core];
                    for (int i8 = 0; i8 < size$animation_core; i8++) {
                        fArr[i8] = animationVector.get$animation_core(i8);
                    }
                } else if (i7 == this.mExternalTextureId && vectorizedKeyframeSpecElementInfo == null) {
                    fArr = new float[size$animation_core];
                    for (int i9 = 0; i9 < size$animation_core; i9++) {
                        fArr[i9] = animationVector2.get$animation_core(i9);
                    }
                } else {
                    AnimationVector animationVector4 = vectorizedKeyframeSpecElementInfo.vectorValue;
                    float[] fArr4 = new float[size$animation_core];
                    for (int i10 = 0; i10 < size$animation_core; i10++) {
                        fArr4[i10] = animationVector4.get$animation_core(i10);
                    }
                    fArr = fArr4;
                }
                fArr3[i6] = fArr;
            }
            this.mCurrentInputformat = new PreviewView.AnonymousClass1(this.mSurfaceAttrib, (float[]) this.mEglDisplay, fArr3);
        }
    }
}
