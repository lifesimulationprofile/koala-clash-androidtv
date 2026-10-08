package androidx.camera.core.processing.util;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import android.view.Surface;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.camera.core.Logger;
import androidx.core.util.Preconditions;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class GLUtils {
    public static final String DEFAULT_VERTEX_SHADER;
    public static final String HDR_VERTEX_SHADER;
    public static final AutoValue_OutputSurface NO_OUTPUT_SURFACE;
    public static final AnonymousClass1 SHADER_PROVIDER_DEFAULT;
    public static final AnonymousClass1 SHADER_PROVIDER_HDR_DEFAULT;
    public static final AnonymousClass1 SHADER_PROVIDER_HDR_YUV;
    public static final FloatBuffer TEX_BUF;
    public static final FloatBuffer VERTEX_BUF;
    public static final int[] EMPTY_ATTRIBS = {12344};
    public static final int[] HLG_SURFACE_ATTRIBS = {12445, 13632, 12344};

    /* JADX INFO: renamed from: androidx.camera.core.processing.util.GLUtils$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 {
        public final /* synthetic */ int $r8$classId;

        public /* synthetic */ AnonymousClass1(int i) {
            this.$r8$classId = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class BlankShaderProgram extends Program2D {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class InputFormat {
        public static final /* synthetic */ InputFormat[] $VALUES;
        public static final InputFormat DEFAULT;
        public static final InputFormat UNKNOWN;
        public static final InputFormat YUV;

        static {
            InputFormat inputFormat = new InputFormat("UNKNOWN", 0);
            UNKNOWN = inputFormat;
            InputFormat inputFormat2 = new InputFormat("DEFAULT", 1);
            DEFAULT = inputFormat2;
            InputFormat inputFormat3 = new InputFormat("YUV", 2);
            YUV = inputFormat3;
            $VALUES = new InputFormat[]{inputFormat, inputFormat2, inputFormat3};
        }

        public static InputFormat valueOf(String str) {
            return (InputFormat) Enum.valueOf(InputFormat.class, str);
        }

        public static InputFormat[] values() {
            return (InputFormat[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class Program2D {
        public final int mProgramHandle;
        public int mTransMatrixLoc = -1;
        public int mAlphaScaleLoc = -1;
        public int mPositionLoc = -1;

        /* JADX WARN: Code duplicated, block: B:32:0x0075  */
        /* JADX WARN: Code duplicated, block: B:34:0x007a  */
        /* JADX WARN: Code duplicated, block: B:36:0x007f  */
        public Program2D(String str, String str2) throws Throwable {
            int iLoadShader;
            int iLoadShader2;
            int iGlCreateProgram;
            try {
                iLoadShader = GLUtils.loadShader(str, 35633);
                try {
                    iLoadShader2 = GLUtils.loadShader(str2, 35632);
                    try {
                        iGlCreateProgram = GLES20.glCreateProgram();
                        try {
                            GLUtils.checkGlErrorOrThrow("glCreateProgram");
                            GLES20.glAttachShader(iGlCreateProgram, iLoadShader);
                            GLUtils.checkGlErrorOrThrow("glAttachShader");
                            GLES20.glAttachShader(iGlCreateProgram, iLoadShader2);
                            GLUtils.checkGlErrorOrThrow("glAttachShader");
                            GLES20.glLinkProgram(iGlCreateProgram);
                            int[] iArr = new int[1];
                            GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
                            if (iArr[0] == 1) {
                                this.mProgramHandle = iGlCreateProgram;
                                loadLocations$1();
                            } else {
                                throw new IllegalStateException("Could not link program: " + GLES20.glGetProgramInfoLog(iGlCreateProgram));
                            }
                        } catch (IllegalArgumentException e) {
                            e = e;
                            if (iLoadShader != -1) {
                                GLES20.glDeleteShader(iLoadShader);
                            }
                            if (iLoadShader2 != -1) {
                                GLES20.glDeleteShader(iLoadShader2);
                            }
                            if (iGlCreateProgram != -1) {
                                GLES20.glDeleteProgram(iGlCreateProgram);
                            }
                            throw e;
                        } catch (IllegalStateException e2) {
                            e = e2;
                            if (iLoadShader != -1) {
                                GLES20.glDeleteShader(iLoadShader);
                            }
                            if (iLoadShader2 != -1) {
                                GLES20.glDeleteShader(iLoadShader2);
                            }
                            if (iGlCreateProgram != -1) {
                                GLES20.glDeleteProgram(iGlCreateProgram);
                            }
                            throw e;
                        }
                    } catch (IllegalArgumentException | IllegalStateException e3) {
                        e = e3;
                        iGlCreateProgram = -1;
                    }
                } catch (IllegalArgumentException | IllegalStateException e4) {
                    e = e4;
                    iLoadShader2 = -1;
                    iGlCreateProgram = iLoadShader2;
                    if (iLoadShader != -1) {
                        GLES20.glDeleteShader(iLoadShader);
                    }
                    if (iLoadShader2 != -1) {
                        GLES20.glDeleteShader(iLoadShader2);
                    }
                    if (iGlCreateProgram != -1) {
                        GLES20.glDeleteProgram(iGlCreateProgram);
                    }
                    throw e;
                }
            } catch (IllegalArgumentException | IllegalStateException e5) {
                e = e5;
                iLoadShader = -1;
                iLoadShader2 = -1;
            }
        }

        public final void loadLocations$1() {
            int i = this.mProgramHandle;
            int iGlGetAttribLocation = GLES20.glGetAttribLocation(i, "aPosition");
            this.mPositionLoc = iGlGetAttribLocation;
            GLUtils.checkLocationOrThrow("aPosition", iGlGetAttribLocation);
            int iGlGetUniformLocation = GLES20.glGetUniformLocation(i, "uTransMatrix");
            this.mTransMatrixLoc = iGlGetUniformLocation;
            GLUtils.checkLocationOrThrow("uTransMatrix", iGlGetUniformLocation);
            int iGlGetUniformLocation2 = GLES20.glGetUniformLocation(i, "uAlphaScale");
            this.mAlphaScaleLoc = iGlGetUniformLocation2;
            GLUtils.checkLocationOrThrow("uAlphaScale", iGlGetUniformLocation2);
        }

        public void use() {
            GLES20.glUseProgram(this.mProgramHandle);
            GLUtils.checkGlErrorOrThrow("glUseProgram");
            GLES20.glEnableVertexAttribArray(this.mPositionLoc);
            GLUtils.checkGlErrorOrThrow("glEnableVertexAttribArray");
            GLES20.glVertexAttribPointer(this.mPositionLoc, 2, 5126, false, 0, (Buffer) GLUtils.VERTEX_BUF);
            GLUtils.checkGlErrorOrThrow("glVertexAttribPointer");
            float[] fArr = new float[16];
            Matrix.setIdentityM(fArr, 0);
            GLES20.glUniformMatrix4fv(this.mTransMatrixLoc, 1, false, fArr, 0);
            GLUtils.checkGlErrorOrThrow("glUniformMatrix4fv");
            GLES20.glUniform1f(this.mAlphaScaleLoc, 1.0f);
            GLUtils.checkGlErrorOrThrow("glUniform1f");
        }
    }

    static {
        Locale locale = Locale.US;
        DEFAULT_VERTEX_SHADER = "uniform mat4 uTexMatrix;\nuniform mat4 uTransMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uTransMatrix * aPosition;\n    vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n";
        HDR_VERTEX_SHADER = "#version 300 es\nin vec4 aPosition;\nin vec4 aTextureCoord;\nuniform mat4 uTexMatrix;\nuniform mat4 uTransMatrix;\nout vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uTransMatrix * aPosition;\n  vTextureCoord = (uTexMatrix * aTextureCoord).xy;\n}\n";
        SHADER_PROVIDER_DEFAULT = new AnonymousClass1(0);
        SHADER_PROVIDER_HDR_DEFAULT = new AnonymousClass1(1);
        SHADER_PROVIDER_HDR_YUV = new AnonymousClass1(2);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(32);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        floatBufferAsFloatBuffer.put(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f});
        floatBufferAsFloatBuffer.position(0);
        VERTEX_BUF = floatBufferAsFloatBuffer;
        ByteBuffer byteBufferAllocateDirect2 = ByteBuffer.allocateDirect(32);
        byteBufferAllocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer2 = byteBufferAllocateDirect2.asFloatBuffer();
        floatBufferAsFloatBuffer2.put(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f});
        floatBufferAsFloatBuffer2.position(0);
        TEX_BUF = floatBufferAsFloatBuffer2;
        NO_OUTPUT_SURFACE = new AutoValue_OutputSurface(EGL14.EGL_NO_SURFACE, 0, 0);
    }

    public static void checkEglErrorOrThrow(String str) {
        int iEglGetError = EGL14.eglGetError();
        if (iEglGetError == 12288) {
            return;
        }
        throw new IllegalStateException(str + ": EGL error: 0x" + Integer.toHexString(iEglGetError));
    }

    public static void checkGlErrorOrThrow(String str) {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError == 0) {
            return;
        }
        throw new IllegalStateException(str + ": GL error 0x" + Integer.toHexString(iGlGetError));
    }

    public static void checkGlThreadOrThrow(Thread thread) {
        Preconditions.checkState("Method call must be called on the GL thread.", thread == Thread.currentThread());
    }

    public static void checkInitializedOrThrow(AtomicBoolean atomicBoolean, boolean z) {
        Preconditions.checkState(z ? "OpenGlRenderer is not initialized" : "OpenGlRenderer is already initialized", z == atomicBoolean.get());
    }

    public static void checkLocationOrThrow(String str, int i) {
        if (i < 0) {
            throw new IllegalStateException(ImageAnalysis$$ExternalSyntheticLambda1.m$1("Unable to locate '", str, "' in program"));
        }
    }

    public static int[] chooseSurfaceAttrib(String str, DynamicRange dynamicRange) {
        int i = dynamicRange.mEncoding;
        int[] iArr = EMPTY_ATTRIBS;
        if (i == 3) {
            if (str.contains("EGL_EXT_gl_colorspace_bt2020_hlg")) {
                return HLG_SURFACE_ATTRIBS;
            }
            Logger.w("GLUtils", "Dynamic range uses HLG encoding, but device does not support EGL_EXT_gl_colorspace_bt2020_hlg.Fallback to default colorspace.");
        }
        return iArr;
    }

    public static HashMap createPrograms(DynamicRange dynamicRange) {
        Object samplerShaderProgram;
        InputFormat inputFormat;
        Map map = Collections.EMPTY_MAP;
        HashMap map2 = new HashMap();
        InputFormat[] inputFormatArrValues = InputFormat.values();
        int length = inputFormatArrValues.length;
        for (int i = 0; i < length; i++) {
            InputFormat inputFormat2 = inputFormatArrValues[i];
            AnonymousClass1 anonymousClass1 = (AnonymousClass1) map.get(inputFormat2);
            if (anonymousClass1 != null) {
                samplerShaderProgram = new SamplerShaderProgram(dynamicRange, anonymousClass1);
            } else if (inputFormat2 == InputFormat.YUV || inputFormat2 == (inputFormat = InputFormat.DEFAULT)) {
                samplerShaderProgram = new SamplerShaderProgram(dynamicRange, inputFormat2);
            } else {
                Preconditions.checkState("Unhandled input format: " + inputFormat2, inputFormat2 == InputFormat.UNKNOWN);
                if (dynamicRange.is10BitHdr()) {
                    samplerShaderProgram = new BlankShaderProgram("uniform mat4 uTransMatrix;\nattribute vec4 aPosition;\nvoid main() {\n    gl_Position = uTransMatrix * aPosition;\n}\n", "precision mediump float;\nuniform float uAlphaScale;\nvoid main() {\n    gl_FragColor = vec4(0.0, 0.0, 0.0, uAlphaScale);\n}\n");
                } else {
                    AnonymousClass1 anonymousClass2 = (AnonymousClass1) map.get(inputFormat);
                    samplerShaderProgram = anonymousClass2 != null ? new SamplerShaderProgram(dynamicRange, anonymousClass2) : new SamplerShaderProgram(dynamicRange, inputFormat);
                }
            }
            Log.d("GLUtils", "Shader program for input format " + inputFormat2 + " created: " + samplerShaderProgram);
            map2.put(inputFormat2, samplerShaderProgram);
        }
        return map2;
    }

    public static int createTexture() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        checkGlErrorOrThrow("glGenTextures");
        int i = iArr[0];
        GLES20.glBindTexture(36197, i);
        checkGlErrorOrThrow("glBindTexture " + i);
        GLES20.glTexParameteri(36197, 10241, 9728);
        GLES20.glTexParameteri(36197, 10240, 9729);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        checkGlErrorOrThrow("glTexParameter");
        return i;
    }

    public static EGLSurface createWindowSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Surface surface, int[] iArr) {
        EGLSurface eGLSurfaceEglCreateWindowSurface = EGL14.eglCreateWindowSurface(eGLDisplay, eGLConfig, surface, iArr, 0);
        checkEglErrorOrThrow("eglCreateWindowSurface");
        if (eGLSurfaceEglCreateWindowSurface != null) {
            return eGLSurfaceEglCreateWindowSurface;
        }
        throw new IllegalStateException("surface was null");
    }

    public static String getGlVersionNumber() {
        Matcher matcher = Pattern.compile("OpenGL ES ([0-9]+)\\.([0-9]+).*").matcher(GLES20.glGetString(7938));
        if (!matcher.find()) {
            return "0.0";
        }
        String strGroup = matcher.group(1);
        strGroup.getClass();
        String strGroup2 = matcher.group(2);
        strGroup2.getClass();
        return ImageAnalysis$$ExternalSyntheticLambda1.m(strGroup, ".", strGroup2);
    }

    public static int loadShader(String str, int i) {
        int iGlCreateShader = GLES20.glCreateShader(i);
        checkGlErrorOrThrow("glCreateShader type=" + i);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        Logger.w("GLUtils", "Could not compile shader: " + str);
        GLES20.glDeleteShader(iGlCreateShader);
        StringBuilder sbM = ImageAnalysis$$ExternalSyntheticLambda1.m(i, "Could not compile shader type ", ":");
        sbM.append(GLES20.glGetShaderInfoLog(iGlCreateShader));
        throw new IllegalStateException(sbM.toString());
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class SamplerShaderProgram extends Program2D {
        public final int mSamplerLoc;
        public final int mTexCoordLoc;
        public final int mTexMatrixLoc;

        /* JADX WARN: Illegal instructions before constructor call */
        public SamplerShaderProgram(DynamicRange dynamicRange, AnonymousClass1 anonymousClass1) {
            String str;
            String str2 = dynamicRange.is10BitHdr() ? GLUtils.HDR_VERTEX_SHADER : GLUtils.DEFAULT_VERTEX_SHADER;
            try {
                switch (anonymousClass1.$r8$classId) {
                    case 0:
                        Locale locale = Locale.US;
                        str = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nuniform float uAlphaScale;\nvoid main() {\n    vec4 src = texture2D(sTexture, vTextureCoord);\n    gl_FragColor = vec4(src.rgb, src.a * uAlphaScale);\n}\n";
                        break;
                    case 1:
                        Locale locale2 = Locale.US;
                        str = "#version 300 es\n#extension GL_OES_EGL_image_external_essl3 : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nuniform float uAlphaScale;\nin vec2 vTextureCoord;\nout vec4 outColor;\n\nvoid main() {\n  vec4 src = texture(sTexture, vTextureCoord);\n  outColor = vec4(src.rgb, src.a * uAlphaScale);\n}";
                        break;
                    default:
                        Locale locale3 = Locale.US;
                        str = "#version 300 es\n#extension GL_EXT_YUV_target : require\nprecision mediump float;\nuniform __samplerExternal2DY2YEXT sTexture;\nuniform float uAlphaScale;\nin vec2 vTextureCoord;\nout vec4 outColor;\n\nvec3 yuvToRgb(vec3 yuv) {\n  const vec3 yuvOffset = vec3(0.0625, 0.5, 0.5);\n  const mat3 yuvToRgbColorMat = mat3(\n    1.1689f, 1.1689f, 1.1689f,\n    0.0000f, -0.1881f, 2.1502f,\n    1.6853f, -0.6530f, 0.0000f\n  );\n  return clamp(yuvToRgbColorMat * (yuv - yuvOffset), 0.0, 1.0);\n}\n\nvoid main() {\n  vec3 srcYuv = texture(sTexture, vTextureCoord).xyz;\n  vec3 srcRgb = yuvToRgb(srcYuv);\n  outColor = vec4(srcRgb, uAlphaScale);\n}";
                        break;
                }
                if (!str.contains("vTextureCoord") || !str.contains("sTexture")) {
                    throw new IllegalArgumentException("Invalid fragment shader");
                }
                super(str2, str);
                this.mSamplerLoc = -1;
                this.mTexMatrixLoc = -1;
                this.mTexCoordLoc = -1;
                loadLocations$1();
                int i = this.mProgramHandle;
                int iGlGetUniformLocation = GLES20.glGetUniformLocation(i, "sTexture");
                this.mSamplerLoc = iGlGetUniformLocation;
                GLUtils.checkLocationOrThrow("sTexture", iGlGetUniformLocation);
                int iGlGetAttribLocation = GLES20.glGetAttribLocation(i, "aTextureCoord");
                this.mTexCoordLoc = iGlGetAttribLocation;
                GLUtils.checkLocationOrThrow("aTextureCoord", iGlGetAttribLocation);
                int iGlGetUniformLocation2 = GLES20.glGetUniformLocation(i, "uTexMatrix");
                this.mTexMatrixLoc = iGlGetUniformLocation2;
                GLUtils.checkLocationOrThrow("uTexMatrix", iGlGetUniformLocation2);
            } catch (Throwable th) {
                if (!(th instanceof IllegalArgumentException)) {
                    throw new IllegalArgumentException("Unable retrieve fragment shader source", th);
                }
                throw th;
            }
        }

        @Override // androidx.camera.core.processing.util.GLUtils.Program2D
        public final void use() {
            super.use();
            GLES20.glUniform1i(this.mSamplerLoc, 0);
            GLES20.glEnableVertexAttribArray(this.mTexCoordLoc);
            GLUtils.checkGlErrorOrThrow("glEnableVertexAttribArray");
            GLES20.glVertexAttribPointer(this.mTexCoordLoc, 2, 5126, false, 0, (Buffer) GLUtils.TEX_BUF);
            GLUtils.checkGlErrorOrThrow("glVertexAttribPointer");
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public SamplerShaderProgram(DynamicRange dynamicRange, InputFormat inputFormat) {
            AnonymousClass1 anonymousClass1;
            if (dynamicRange.is10BitHdr()) {
                Preconditions.checkArgument("No default sampler shader available for" + inputFormat, inputFormat != InputFormat.UNKNOWN);
                if (inputFormat == InputFormat.YUV) {
                    anonymousClass1 = GLUtils.SHADER_PROVIDER_HDR_YUV;
                } else {
                    anonymousClass1 = GLUtils.SHADER_PROVIDER_HDR_DEFAULT;
                }
            } else {
                anonymousClass1 = GLUtils.SHADER_PROVIDER_DEFAULT;
            }
            this(dynamicRange, anonymousClass1);
        }
    }
}
