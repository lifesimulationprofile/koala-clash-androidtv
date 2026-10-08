package androidx.compose.ui.unit;

import android.content.ContentProviderClient;
import android.content.res.TypedArray;
import android.drm.DrmManagerClient;
import android.media.MediaDrm;
import android.media.MediaMetadataRetriever;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.text.style.BrushStyle;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.unit.fontscaling.FontScaleConverter;
import androidx.compose.ui.unit.fontscaling.FontScaleConverterFactory;
import androidx.core.os.LocaleListPlatformWrapper$$ExternalSyntheticApiModelOutline0;
import androidx.fragment.app.FragmentManagerImpl;
import com.google.android.gms.internal.mlkit_vision_barcode.zzez;
import com.google.android.gms.internal.mlkit_vision_barcode.zzfe;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdk;
import com.google.android.gms.internal.mlkit_vision_common.zzad;
import com.google.firebase.encoders.FieldDescriptor;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import okhttp3.internal.cache.CacheStrategy;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public interface Density {

    /* JADX INFO: renamed from: androidx.compose.ui.unit.Density$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract /* synthetic */ class CC {
        public static TextForegroundStyle $default$merge(TextForegroundStyle textForegroundStyle, TextForegroundStyle textForegroundStyle2) {
            boolean z = textForegroundStyle2 instanceof BrushStyle;
            if (!z || !(textForegroundStyle instanceof BrushStyle)) {
                if (!z || (textForegroundStyle instanceof BrushStyle)) {
                    return (z || !(textForegroundStyle instanceof BrushStyle)) ? textForegroundStyle2.takeOrElse(new BasicTextKt$$ExternalSyntheticLambda0(28, textForegroundStyle)) : textForegroundStyle;
                }
                return textForegroundStyle2;
            }
            BrushStyle brushStyle = (BrushStyle) textForegroundStyle2;
            ShaderBrush shaderBrush = brushStyle.value;
            float f = brushStyle.alpha;
            if (Float.isNaN(f)) {
                f = ((BrushStyle) textForegroundStyle).alpha;
            }
            return new BrushStyle(shaderBrush, f);
        }

        /* JADX INFO: renamed from: $default$roundToPx-0680j_4, reason: not valid java name */
        public static int m695$default$roundToPx0680j_4(Density density, float f) {
            float fMo92toPx0680j_4 = density.mo92toPx0680j_4(f);
            if (Float.isInfinite(fMo92toPx0680j_4)) {
                return Integer.MAX_VALUE;
            }
            return Math.round(fMo92toPx0680j_4);
        }

        /* JADX INFO: renamed from: $default$toDp-GaN1DYA, reason: not valid java name */
        public static float m696$default$toDpGaN1DYA(long j, Density density) {
            float fM727getValueimpl;
            float fontScale;
            if (!TextUnitType.m731equalsimpl0(TextUnit.m726getTypeUIouoOA(j), 4294967296L)) {
                InlineClassHelperKt.throwIllegalStateException("Only Sp can convert to Px");
            }
            float[] fArr = FontScaleConverterFactory.CommonFontSizes;
            if (density.getFontScale() >= 1.03f) {
                FontScaleConverter fontScaleConverterForScale = FontScaleConverterFactory.forScale(density.getFontScale());
                fM727getValueimpl = TextUnit.m727getValueimpl(j);
                if (fontScaleConverterForScale != null) {
                    return fontScaleConverterForScale.convertSpToDp(fM727getValueimpl);
                }
                fontScale = density.getFontScale();
            } else {
                fM727getValueimpl = TextUnit.m727getValueimpl(j);
                fontScale = density.getFontScale();
            }
            return fontScale * fM727getValueimpl;
        }

        /* JADX INFO: renamed from: $default$toDpSize-k-rfVVM, reason: not valid java name */
        public static long m697$default$toDpSizekrfVVM(long j, Density density) {
            if (j != 9205357640488583168L) {
                return DpKt.m706DpSizeYgX7TsA(density.mo88toDpu2uoSUM(Float.intBitsToFloat((int) (j >> 32))), density.mo88toDpu2uoSUM(Float.intBitsToFloat((int) (j & 4294967295L))));
            }
            return 9205357640488583168L;
        }

        /* JADX INFO: renamed from: $default$toPx--R2X_6o, reason: not valid java name */
        public static float m698$default$toPxR2X_6o(long j, Density density) {
            if (!TextUnitType.m731equalsimpl0(TextUnit.m726getTypeUIouoOA(j), 4294967296L)) {
                InlineClassHelperKt.throwIllegalStateException("Only Sp can convert to Px");
            }
            return density.mo92toPx0680j_4(density.mo87toDpGaN1DYA(j));
        }

        /* JADX INFO: renamed from: $default$toSize-XkaWNTQ, reason: not valid java name */
        public static long m699$default$toSizeXkaWNTQ(long j, Density density) {
            if (j == 9205357640488583168L) {
                return 9205357640488583168L;
            }
            float fMo92toPx0680j_4 = density.mo92toPx0680j_4(DpSize.m711getWidthD9Ej5fM(j));
            float fMo92toPx0680j_5 = density.mo92toPx0680j_4(DpSize.m710getHeightD9Ej5fM(j));
            return (((long) Float.floatToRawIntBits(fMo92toPx0680j_4)) << 32) | (((long) Float.floatToRawIntBits(fMo92toPx0680j_5)) & 4294967295L);
        }

        /* JADX INFO: renamed from: $default$toSp-0xMU5do, reason: not valid java name */
        public static long m700$default$toSp0xMU5do(Density density, float f) {
            float[] fArr = FontScaleConverterFactory.CommonFontSizes;
            if (density.getFontScale() < 1.03f) {
                return TextUnitKt.pack(f / density.getFontScale(), 4294967296L);
            }
            FontScaleConverter fontScaleConverterForScale = FontScaleConverterFactory.forScale(density.getFontScale());
            return TextUnitKt.pack(fontScaleConverterForScale != null ? fontScaleConverterForScale.convertDpToSp(f) : f / density.getFontScale(), 4294967296L);
        }

        public static final void _applyState(View view, int i) {
            int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i);
            if (iOrdinal == 0) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    if (FragmentManagerImpl.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                    }
                    viewGroup.removeView(view);
                    return;
                }
                return;
            }
            if (iOrdinal == 1) {
                if (FragmentManagerImpl.isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                }
                view.setVisibility(0);
                return;
            }
            if (iOrdinal == 2) {
                if (FragmentManagerImpl.isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                }
                view.setVisibility(8);
                return;
            }
            if (iOrdinal != 3) {
                return;
            }
            if (FragmentManagerImpl.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
            }
            view.setVisibility(4);
        }

        public static int _from(View view) {
            if (view.getAlpha() == 0.0f && view.getVisibility() == 0) {
                return 4;
            }
            return _from(view.getVisibility());
        }

        public static int _lookup(String str) {
            if (str == null) {
                return 0;
            }
            try {
                return valueOf$1(str);
            } catch (IllegalArgumentException unused) {
                return 0;
            }
        }

        public static /* synthetic */ boolean getReadEnabled(int i) {
            if (i == 1 || i == 2) {
                return true;
            }
            if (i == 3 || i == 4) {
                return false;
            }
            throw null;
        }

        public static /* synthetic */ boolean getWriteEnabled(int i) {
            if (i == 1) {
                return true;
            }
            if (i == 2) {
                return false;
            }
            if (i == 3) {
                return true;
            }
            if (i == 4) {
                return false;
            }
            throw null;
        }

        public static int m(int i, int i2, int i3) {
            return zzdk.zzA(i) + i2 + i3;
        }

        public static /* synthetic */ String name(int i) {
            switch (i) {
                case 1:
                    return "NONE";
                case 2:
                    return "LEFT";
                case 3:
                    return "TOP";
                case 4:
                    return "RIGHT";
                case 5:
                    return "BOTTOM";
                case 6:
                    return "BASELINE";
                case 7:
                    return "CENTER";
                case 8:
                    return "CENTER_X";
                case 9:
                    return "CENTER_Y";
                default:
                    throw null;
            }
        }

        public static /* synthetic */ String stringValueOf(int i) {
            if (i != 1) {
                return i != 2 ? "null" : "Rtl";
            }
            return "Ltr";
        }

        public static /* synthetic */ String stringValueOf$2(int i) {
            if (i == 1) {
                return "NONE";
            }
            if (i != 2) {
                return i != 3 ? "null" : "REMOVING";
            }
            return "ADDING";
        }

        public static /* synthetic */ String stringValueOf$3(int i) {
            if (i == 1) {
                return "REMOVED";
            }
            if (i == 2) {
                return "VISIBLE";
            }
            if (i != 3) {
                return i != 4 ? "null" : "INVISIBLE";
            }
            return "GONE";
        }

        public static /* synthetic */ String stringValueOf$6(int i) {
            if (i == 1) {
                return "SUSPEND";
            }
            if (i != 2) {
                return i != 3 ? "null" : "DROP_LATEST";
            }
            return "DROP_OLDEST";
        }

        public static /* synthetic */ int valueOf$1(String str) {
            if (str == null) {
                throw new NullPointerException("Name is null");
            }
            if (str.equals("GET")) {
                return 1;
            }
            if (str.equals("PUT")) {
                return 2;
            }
            if (str.equals("POST")) {
                return 3;
            }
            if (str.equals("DELETE")) {
                return 4;
            }
            if (str.equals("HEAD")) {
                return 5;
            }
            if (str.equals("OPTIONS")) {
                return 6;
            }
            if (str.equals("TRACE")) {
                return 7;
            }
            if (str.equals("CONNECT")) {
                return 8;
            }
            if (str.equals("PATCH")) {
                return 9;
            }
            if (str.equals("PROPFIND")) {
                return 10;
            }
            if (str.equals("PROPPATCH")) {
                return 11;
            }
            if (str.equals("MKCOL")) {
                return 12;
            }
            if (str.equals("MOVE")) {
                return 13;
            }
            if (str.equals("COPY")) {
                return 14;
            }
            if (str.equals("LOCK")) {
                return 15;
            }
            if (str.equals("UNLOCK")) {
                return 16;
            }
            throw new IllegalArgumentException("No enum constant fi.iki.elonen.NanoHTTPD.Method.".concat(str));
        }

        public static int m(int i, int i2, int i3, int i4) {
            return zzdk.zzA(i) + i2 + i3 + i4;
        }

        public static int _from(int i) {
            if (i == 0) {
                return 2;
            }
            if (i == 4) {
                return 4;
            }
            if (i == 8) {
                return 3;
            }
            throw new IllegalArgumentException(ImageAnalysis$$ExternalSyntheticLambda1.m("Unknown visibility ", i));
        }

        public static zzez m(HashMap map, int i) {
            Collections.unmodifiableMap(new HashMap(map));
            return new zzez(i);
        }

        /* JADX INFO: renamed from: m, reason: collision with other method in class */
        public static zzad m701m(HashMap map, int i) {
            Collections.unmodifiableMap(new HashMap(map));
            return new zzad(i);
        }

        public static FieldDescriptor m(int i, CacheStrategy cacheStrategy) {
            Map mapUnmodifiableMap;
            zzez zzezVar = new zzez(i);
            if (((HashMap) cacheStrategy.cacheResponse) == null) {
                cacheStrategy.cacheResponse = new HashMap();
            }
            ((HashMap) cacheStrategy.cacheResponse).put(zzfe.class, zzezVar);
            String str = (String) cacheStrategy.networkRequest;
            if (((HashMap) cacheStrategy.cacheResponse) == null) {
                mapUnmodifiableMap = Collections.EMPTY_MAP;
            } else {
                mapUnmodifiableMap = Collections.unmodifiableMap(new HashMap((HashMap) cacheStrategy.cacheResponse));
            }
            return new FieldDescriptor(str, mapUnmodifiableMap);
        }

        public static Object m(int i, GapComposer gapComposer, boolean z) {
            gapComposer.end(z);
            gapComposer.startReplaceGroup(i);
            return gapComposer.rememberedValue();
        }

        public static HashMap m(Class cls, zzez zzezVar) {
            HashMap map = new HashMap();
            map.put(cls, zzezVar);
            return map;
        }

        public static HashMap m(Class cls, zzad zzadVar) {
            HashMap map = new HashMap();
            map.put(cls, zzadVar);
            return map;
        }

        public static Map m(HashMap map) {
            return Collections.unmodifiableMap(new HashMap(map));
        }

        public static /* synthetic */ void m(AutoCloseable autoCloseable) throws Exception {
            if (autoCloseable instanceof AutoCloseable) {
                autoCloseable.close();
                return;
            }
            if (autoCloseable instanceof ExecutorService) {
                LocaleListPlatformWrapper$$ExternalSyntheticApiModelOutline0.m((ExecutorService) autoCloseable);
                return;
            }
            if (autoCloseable instanceof TypedArray) {
                ((TypedArray) autoCloseable).recycle();
                return;
            }
            if (autoCloseable instanceof MediaMetadataRetriever) {
                ((MediaMetadataRetriever) autoCloseable).release();
                return;
            }
            if (autoCloseable instanceof MediaDrm) {
                ((MediaDrm) autoCloseable).release();
            } else if (autoCloseable instanceof DrmManagerClient) {
                ((DrmManagerClient) autoCloseable).release();
            } else {
                if (!(autoCloseable instanceof ContentProviderClient)) {
                    throw new IllegalArgumentException();
                }
                ((ContentProviderClient) autoCloseable).release();
            }
        }

        public static void m(StringBuilder sb, String str, String str2, String str3, String str4) {
            sb.append(str);
            sb.append(str2);
            sb.append(str3);
            sb.append(str4);
        }

        /* JADX INFO: renamed from: m, reason: collision with other method in class */
        public static void m702m(HashMap map) {
            Collections.unmodifiableMap(new HashMap(map));
        }
    }

    float getDensity();

    float getFontScale();

    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    int mo86roundToPx0680j_4(float f);

    /* JADX INFO: renamed from: toDp-GaN1DYA */
    float mo87toDpGaN1DYA(long j);

    /* JADX INFO: renamed from: toDp-u2uoSUM */
    float mo88toDpu2uoSUM(float f);

    /* JADX INFO: renamed from: toDp-u2uoSUM */
    float mo89toDpu2uoSUM(int i);

    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    long mo90toDpSizekrfVVM(long j);

    /* JADX INFO: renamed from: toPx--R2X_6o */
    float mo91toPxR2X_6o(long j);

    /* JADX INFO: renamed from: toPx-0680j_4 */
    float mo92toPx0680j_4(float f);

    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    long mo93toSizeXkaWNTQ(long j);

    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    long mo94toSpkPz2Gy4(float f);
}
