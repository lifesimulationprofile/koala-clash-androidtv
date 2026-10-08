package androidx.camera.camera2.internal;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import androidx.appcompat.widget.Toolbar;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.camera2.internal.compat.params.DynamicRangesCompat$DynamicRangeProfilesCompatImpl;
import androidx.camera.camera2.internal.compat.quirk.AspectRatioLegacyApi21Quirk;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ExtraCroppingQuirk;
import androidx.camera.camera2.internal.compat.quirk.ExtraSupportedSurfaceCombinationsQuirk;
import androidx.camera.camera2.internal.compat.quirk.Nexus4AndroidLTargetAspectRatioQuirk;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.AutoValue_AttachedSurfaceInfo;
import androidx.camera.core.impl.AutoValue_Config_Option;
import androidx.camera.core.impl.AutoValue_StreamSpec;
import androidx.camera.core.impl.AutoValue_SurfaceConfig;
import androidx.camera.core.impl.AutoValue_SurfaceSizeDefinition;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SurfaceCombination;
import androidx.camera.core.impl.SurfaceConfig$ConfigSize;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.AspectRatioUtil;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import androidx.camera.core.internal.utils.SizeUtil;
import androidx.camera.core.streamsharing.StreamSharingConfig;
import androidx.camera.view.PreviewView;
import androidx.compose.ui.window.Api33Impl;
import androidx.core.util.Preconditions;
import com.google.android.gms.tasks.zzr;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.internal.ProgressionUtilKt;
import okhttp3.Request;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SupportedSurfaceCombination {
    public final CamcorderProfileHelper mCamcorderProfileHelper;
    public final String mCameraId;
    public final CameraCharacteristicsCompat mCharacteristics;
    public final DisplayInfoManager mDisplayInfoManager;
    public final zzr mDynamicRangeResolver;
    public final Toolbar.AnonymousClass1 mExtraSupportedSurfaceCombinationsContainer;
    public final int mHardwareLevel;
    public final boolean mIsBurstCaptureSupported;
    public final boolean mIsConcurrentCameraModeSupported;
    public final boolean mIsRawSupported;
    public final boolean mIsStreamUseCaseSupported;
    public final boolean mIsUltraHighResolutionSensorSupported;
    public AutoValue_SurfaceSizeDefinition mSurfaceSizeDefinition;
    public final ArrayList mSurfaceCombinations = new ArrayList();
    public final ArrayList mUltraHighSurfaceCombinations = new ArrayList();
    public final ArrayList mConcurrentSurfaceCombinations = new ArrayList();
    public final ArrayList mPreviewStabilizationSurfaceCombinations = new ArrayList();
    public final HashMap mFeatureSettingsToSupportedCombinationsMap = new HashMap();
    public final ArrayList mSurfaceCombinations10Bit = new ArrayList();
    public final ArrayList mSurfaceCombinationsUltraHdr = new ArrayList();
    public final ArrayList mSurfaceCombinationsStreamUseCase = new ArrayList();
    public final ArrayList mSurfaceSizeDefinitionFormats = new ArrayList();
    public final Path.Companion mTargetAspectRatio = new Path.Companion();
    public final PreviewView.AnonymousClass1 mResolutionCorrector = new PreviewView.AnonymousClass1(13);

    public SupportedSurfaceCombination(Context context, String str, CameraManagerCompat cameraManagerCompat, CamcorderProfileHelper camcorderProfileHelper) throws CameraUnavailableException {
        boolean z;
        int i;
        List listSingletonList;
        int[] outputFormats;
        long[] jArr;
        int[] iArr;
        boolean z2;
        this.mIsRawSupported = false;
        this.mIsBurstCaptureSupported = false;
        this.mIsConcurrentCameraModeSupported = false;
        this.mIsStreamUseCaseSupported = false;
        this.mIsUltraHighResolutionSensorSupported = false;
        str.getClass();
        this.mCameraId = str;
        camcorderProfileHelper.getClass();
        this.mCamcorderProfileHelper = camcorderProfileHelper;
        this.mExtraSupportedSurfaceCombinationsContainer = new Toolbar.AnonymousClass1(11);
        this.mDisplayInfoManager = DisplayInfoManager.getInstance(context);
        try {
            CameraCharacteristicsCompat cameraCharacteristicsCompat = cameraManagerCompat.getCameraCharacteristicsCompat(str);
            this.mCharacteristics = cameraCharacteristicsCompat;
            Integer num = (Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
            this.mHardwareLevel = num != null ? num.intValue() : 2;
            int[] iArr2 = (int[]) cameraCharacteristicsCompat.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
            if (iArr2 != null) {
                for (int i2 : iArr2) {
                    if (i2 == 3) {
                        this.mIsRawSupported = true;
                    } else if (i2 == 6) {
                        this.mIsBurstCaptureSupported = true;
                    } else if (Build.VERSION.SDK_INT >= 31 && i2 == 16) {
                        this.mIsUltraHighResolutionSensorSupported = true;
                    }
                }
            }
            CameraCharacteristicsCompat cameraCharacteristicsCompat2 = this.mCharacteristics;
            zzr zzrVar = new zzr();
            zzrVar.zza = cameraCharacteristicsCompat2;
            zzrVar.zzb = Toolbar.AnonymousClass1.fromCameraCharacteristics(cameraCharacteristicsCompat2);
            int[] iArr3 = (int[]) cameraCharacteristicsCompat2.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
            if (iArr3 == null) {
                z = false;
                break;
            }
            int length = iArr3.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    z = false;
                    break;
                } else {
                    if (iArr3[i3] == 18) {
                        z = true;
                        break;
                    }
                    i3++;
                }
            }
            zzrVar.zzc = z;
            this.mDynamicRangeResolver = zzrVar;
            ArrayList arrayList = this.mSurfaceCombinations;
            int i4 = this.mHardwareLevel;
            boolean z3 = this.mIsRawSupported;
            boolean z4 = this.mIsBurstCaptureSupported;
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            SurfaceCombination surfaceCombination = new SurfaceCombination();
            SurfaceConfig$ConfigSize surfaceConfig$ConfigSize = SurfaceConfig$ConfigSize.MAXIMUM;
            CaptureSession$State$EnumUnboxingLocalUtility.m(1, surfaceConfig$ConfigSize, 0L, surfaceCombination);
            SurfaceCombination surfaceCombinationM = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList3, surfaceCombination);
            CaptureSession$State$EnumUnboxingLocalUtility.m(3, surfaceConfig$ConfigSize, 0L, surfaceCombinationM);
            SurfaceCombination surfaceCombinationM2 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList3, surfaceCombinationM);
            CaptureSession$State$EnumUnboxingLocalUtility.m(2, surfaceConfig$ConfigSize, 0L, surfaceCombinationM2);
            SurfaceCombination surfaceCombinationM3 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList3, surfaceCombinationM2);
            SurfaceConfig$ConfigSize surfaceConfig$ConfigSize2 = SurfaceConfig$ConfigSize.PREVIEW;
            surfaceCombinationM3.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
            CaptureSession$State$EnumUnboxingLocalUtility.m(3, surfaceConfig$ConfigSize, 0L, surfaceCombinationM3);
            SurfaceCombination surfaceCombinationM4 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList3, surfaceCombinationM3);
            surfaceCombinationM4.addSurfaceConfig(new AutoValue_SurfaceConfig(2, surfaceConfig$ConfigSize2, 0L));
            CaptureSession$State$EnumUnboxingLocalUtility.m(3, surfaceConfig$ConfigSize, 0L, surfaceCombinationM4);
            SurfaceCombination surfaceCombinationM5 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList3, surfaceCombinationM4);
            surfaceCombinationM5.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
            CaptureSession$State$EnumUnboxingLocalUtility.m(1, surfaceConfig$ConfigSize2, 0L, surfaceCombinationM5);
            SurfaceCombination surfaceCombinationM6 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList3, surfaceCombinationM5);
            surfaceCombinationM6.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
            CaptureSession$State$EnumUnboxingLocalUtility.m(2, surfaceConfig$ConfigSize2, 0L, surfaceCombinationM6);
            SurfaceCombination surfaceCombinationM7 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList3, surfaceCombinationM6);
            surfaceCombinationM7.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
            surfaceCombinationM7.addSurfaceConfig(new AutoValue_SurfaceConfig(2, surfaceConfig$ConfigSize2, 0L));
            CaptureSession$State$EnumUnboxingLocalUtility.m(3, surfaceConfig$ConfigSize, 0L, surfaceCombinationM7);
            arrayList3.add(surfaceCombinationM7);
            arrayList2.addAll(arrayList3);
            SurfaceConfig$ConfigSize surfaceConfig$ConfigSize3 = SurfaceConfig$ConfigSize.RECORD;
            if (i4 == 0 || i4 == 1 || i4 == 3) {
                ArrayList arrayList4 = new ArrayList();
                SurfaceCombination surfaceCombination2 = new SurfaceCombination();
                surfaceCombination2.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(1, surfaceConfig$ConfigSize3, 0L, surfaceCombination2);
                SurfaceCombination surfaceCombinationM8 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList4, surfaceCombination2);
                surfaceCombinationM8.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(2, surfaceConfig$ConfigSize3, 0L, surfaceCombinationM8);
                SurfaceCombination surfaceCombinationM9 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList4, surfaceCombinationM8);
                surfaceCombinationM9.addSurfaceConfig(new AutoValue_SurfaceConfig(2, surfaceConfig$ConfigSize2, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(2, surfaceConfig$ConfigSize3, 0L, surfaceCombinationM9);
                SurfaceCombination surfaceCombinationM10 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList4, surfaceCombinationM9);
                surfaceCombinationM10.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
                surfaceCombinationM10.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize3, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(3, surfaceConfig$ConfigSize3, 0L, surfaceCombinationM10);
                SurfaceCombination surfaceCombinationM11 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList4, surfaceCombinationM10);
                surfaceCombinationM11.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
                surfaceCombinationM11.addSurfaceConfig(new AutoValue_SurfaceConfig(2, surfaceConfig$ConfigSize3, 0L));
                i = 3;
                CaptureSession$State$EnumUnboxingLocalUtility.m(3, surfaceConfig$ConfigSize3, 0L, surfaceCombinationM11);
                SurfaceCombination surfaceCombinationM12 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList4, surfaceCombinationM11);
                surfaceCombinationM12.addSurfaceConfig(new AutoValue_SurfaceConfig(2, surfaceConfig$ConfigSize2, 0L));
                surfaceCombinationM12.addSurfaceConfig(new AutoValue_SurfaceConfig(2, surfaceConfig$ConfigSize2, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(3, surfaceConfig$ConfigSize, 0L, surfaceCombinationM12);
                arrayList4.add(surfaceCombinationM12);
                arrayList2.addAll(arrayList4);
            } else {
                i = 3;
            }
            SurfaceConfig$ConfigSize surfaceConfig$ConfigSize4 = SurfaceConfig$ConfigSize.VGA;
            if (i4 == 1 || i4 == i) {
                ArrayList arrayList5 = new ArrayList();
                SurfaceCombination surfaceCombination3 = new SurfaceCombination();
                surfaceCombination3.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(1, surfaceConfig$ConfigSize, 0L, surfaceCombination3);
                SurfaceCombination surfaceCombinationM13 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList5, surfaceCombination3);
                surfaceCombinationM13.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(2, surfaceConfig$ConfigSize, 0L, surfaceCombinationM13);
                SurfaceCombination surfaceCombinationM14 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList5, surfaceCombinationM13);
                surfaceCombinationM14.addSurfaceConfig(new AutoValue_SurfaceConfig(2, surfaceConfig$ConfigSize2, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(2, surfaceConfig$ConfigSize, 0L, surfaceCombinationM14);
                SurfaceCombination surfaceCombinationM15 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList5, surfaceCombinationM14);
                surfaceCombinationM15.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
                surfaceCombinationM15.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(3, surfaceConfig$ConfigSize, 0L, surfaceCombinationM15);
                SurfaceCombination surfaceCombinationM16 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList5, surfaceCombinationM15);
                surfaceCombinationM16.addSurfaceConfig(new AutoValue_SurfaceConfig(2, surfaceConfig$ConfigSize4, 0L));
                surfaceCombinationM16.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(2, surfaceConfig$ConfigSize, 0L, surfaceCombinationM16);
                SurfaceCombination surfaceCombinationM17 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList5, surfaceCombinationM16);
                surfaceCombinationM17.addSurfaceConfig(new AutoValue_SurfaceConfig(2, surfaceConfig$ConfigSize4, 0L));
                surfaceCombinationM17.addSurfaceConfig(new AutoValue_SurfaceConfig(2, surfaceConfig$ConfigSize2, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(2, surfaceConfig$ConfigSize, 0L, surfaceCombinationM17);
                arrayList5.add(surfaceCombinationM17);
                arrayList2.addAll(arrayList5);
            }
            if (z3) {
                ArrayList arrayList6 = new ArrayList();
                SurfaceCombination surfaceCombination4 = new SurfaceCombination();
                CaptureSession$State$EnumUnboxingLocalUtility.m(5, surfaceConfig$ConfigSize, 0L, surfaceCombination4);
                SurfaceCombination surfaceCombinationM18 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList6, surfaceCombination4);
                surfaceCombinationM18.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(5, surfaceConfig$ConfigSize, 0L, surfaceCombinationM18);
                SurfaceCombination surfaceCombinationM19 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList6, surfaceCombinationM18);
                surfaceCombinationM19.addSurfaceConfig(new AutoValue_SurfaceConfig(2, surfaceConfig$ConfigSize2, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(5, surfaceConfig$ConfigSize, 0L, surfaceCombinationM19);
                SurfaceCombination surfaceCombinationM20 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList6, surfaceCombinationM19);
                surfaceCombinationM20.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
                surfaceCombinationM20.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(5, surfaceConfig$ConfigSize, 0L, surfaceCombinationM20);
                SurfaceCombination surfaceCombinationM21 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList6, surfaceCombinationM20);
                surfaceCombinationM21.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
                surfaceCombinationM21.addSurfaceConfig(new AutoValue_SurfaceConfig(2, surfaceConfig$ConfigSize2, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(5, surfaceConfig$ConfigSize, 0L, surfaceCombinationM21);
                SurfaceCombination surfaceCombinationM22 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList6, surfaceCombinationM21);
                surfaceCombinationM22.addSurfaceConfig(new AutoValue_SurfaceConfig(2, surfaceConfig$ConfigSize2, 0L));
                surfaceCombinationM22.addSurfaceConfig(new AutoValue_SurfaceConfig(2, surfaceConfig$ConfigSize2, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(5, surfaceConfig$ConfigSize, 0L, surfaceCombinationM22);
                SurfaceCombination surfaceCombinationM23 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList6, surfaceCombinationM22);
                surfaceCombinationM23.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
                surfaceCombinationM23.addSurfaceConfig(new AutoValue_SurfaceConfig(3, surfaceConfig$ConfigSize, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(5, surfaceConfig$ConfigSize, 0L, surfaceCombinationM23);
                SurfaceCombination surfaceCombinationM24 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList6, surfaceCombinationM23);
                surfaceCombinationM24.addSurfaceConfig(new AutoValue_SurfaceConfig(2, surfaceConfig$ConfigSize2, 0L));
                surfaceCombinationM24.addSurfaceConfig(new AutoValue_SurfaceConfig(3, surfaceConfig$ConfigSize, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(5, surfaceConfig$ConfigSize, 0L, surfaceCombinationM24);
                arrayList6.add(surfaceCombinationM24);
                arrayList2.addAll(arrayList6);
            }
            if (z4 && i4 == 0) {
                ArrayList arrayList7 = new ArrayList();
                SurfaceCombination surfaceCombination5 = new SurfaceCombination();
                surfaceCombination5.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(1, surfaceConfig$ConfigSize, 0L, surfaceCombination5);
                SurfaceCombination surfaceCombinationM25 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList7, surfaceCombination5);
                surfaceCombinationM25.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(2, surfaceConfig$ConfigSize, 0L, surfaceCombinationM25);
                SurfaceCombination surfaceCombinationM26 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList7, surfaceCombinationM25);
                surfaceCombinationM26.addSurfaceConfig(new AutoValue_SurfaceConfig(2, surfaceConfig$ConfigSize2, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(2, surfaceConfig$ConfigSize, 0L, surfaceCombinationM26);
                arrayList7.add(surfaceCombinationM26);
                arrayList2.addAll(arrayList7);
            }
            if (i4 == 3) {
                ArrayList arrayList8 = new ArrayList();
                SurfaceCombination surfaceCombination6 = new SurfaceCombination();
                surfaceCombination6.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
                surfaceCombination6.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize4, 0L));
                surfaceCombination6.addSurfaceConfig(new AutoValue_SurfaceConfig(2, surfaceConfig$ConfigSize, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(5, surfaceConfig$ConfigSize, 0L, surfaceCombination6);
                SurfaceCombination surfaceCombinationM27 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList8, surfaceCombination6);
                surfaceCombinationM27.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
                surfaceCombinationM27.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize4, 0L));
                surfaceCombinationM27.addSurfaceConfig(new AutoValue_SurfaceConfig(3, surfaceConfig$ConfigSize, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(5, surfaceConfig$ConfigSize, 0L, surfaceCombinationM27);
                arrayList8.add(surfaceCombinationM27);
                arrayList2.addAll(arrayList8);
            }
            arrayList.addAll(arrayList2);
            Toolbar.AnonymousClass1 anonymousClass1 = this.mExtraSupportedSurfaceCombinationsContainer;
            String str2 = this.mCameraId;
            if (((ExtraSupportedSurfaceCombinationsQuirk) anonymousClass1.this$0) == null) {
                listSingletonList = new ArrayList();
            } else {
                SurfaceCombination surfaceCombination7 = ExtraSupportedSurfaceCombinationsQuirk.FULL_LEVEL_YUV_PRIV_YUV_CONFIGURATION;
                String str3 = Build.DEVICE;
                if ("heroqltevzw".equalsIgnoreCase(str3) || "heroqltetmo".equalsIgnoreCase(str3)) {
                    ArrayList arrayList9 = new ArrayList();
                    listSingletonList = arrayList9;
                    if (str2.equals("1")) {
                        arrayList9.add(ExtraSupportedSurfaceCombinationsQuirk.FULL_LEVEL_YUV_PRIV_YUV_CONFIGURATION);
                        listSingletonList = arrayList9;
                    }
                } else {
                    listSingletonList = ((!"google".equalsIgnoreCase(Build.BRAND) ? false : ExtraSupportedSurfaceCombinationsQuirk.SUPPORT_EXTRA_LEVEL_3_CONFIGURATIONS_GOOGLE_MODELS.contains(Build.MODEL.toUpperCase(Locale.US))) || ExtraSupportedSurfaceCombinationsQuirk.supportExtraLevel3ConfigurationsSamsungDevice()) ? Collections.singletonList(ExtraSupportedSurfaceCombinationsQuirk.LEVEL_3_LEVEL_PRIV_PRIV_YUV_SUBSET_CONFIGURATION) : Collections.EMPTY_LIST;
                }
            }
            arrayList.addAll(listSingletonList);
            if (this.mIsUltraHighResolutionSensorSupported) {
                ArrayList arrayList10 = this.mUltraHighSurfaceCombinations;
                ArrayList arrayList11 = new ArrayList();
                SurfaceCombination surfaceCombination8 = new SurfaceCombination();
                SurfaceConfig$ConfigSize surfaceConfig$ConfigSize5 = SurfaceConfig$ConfigSize.ULTRA_MAXIMUM;
                surfaceCombination8.addSurfaceConfig(new AutoValue_SurfaceConfig(2, surfaceConfig$ConfigSize5, 0L));
                surfaceCombination8.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(1, surfaceConfig$ConfigSize3, 0L, surfaceCombination8);
                SurfaceCombination surfaceCombinationM28 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList11, surfaceCombination8);
                surfaceCombinationM28.addSurfaceConfig(new AutoValue_SurfaceConfig(3, surfaceConfig$ConfigSize5, 0L));
                surfaceCombinationM28.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(1, surfaceConfig$ConfigSize3, 0L, surfaceCombinationM28);
                SurfaceCombination surfaceCombinationM29 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList11, surfaceCombinationM28);
                surfaceCombinationM29.addSurfaceConfig(new AutoValue_SurfaceConfig(5, surfaceConfig$ConfigSize5, 0L));
                surfaceCombinationM29.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(1, surfaceConfig$ConfigSize3, 0L, surfaceCombinationM29);
                SurfaceCombination surfaceCombinationM30 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList11, surfaceCombinationM29);
                surfaceCombinationM30.addSurfaceConfig(new AutoValue_SurfaceConfig(2, surfaceConfig$ConfigSize5, 0L));
                surfaceCombinationM30.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(3, surfaceConfig$ConfigSize, 0L, surfaceCombinationM30);
                SurfaceCombination surfaceCombinationM31 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList11, surfaceCombinationM30);
                surfaceCombinationM31.addSurfaceConfig(new AutoValue_SurfaceConfig(3, surfaceConfig$ConfigSize5, 0L));
                surfaceCombinationM31.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(3, surfaceConfig$ConfigSize, 0L, surfaceCombinationM31);
                SurfaceCombination surfaceCombinationM32 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList11, surfaceCombinationM31);
                surfaceCombinationM32.addSurfaceConfig(new AutoValue_SurfaceConfig(5, surfaceConfig$ConfigSize5, 0L));
                surfaceCombinationM32.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(3, surfaceConfig$ConfigSize, 0L, surfaceCombinationM32);
                SurfaceCombination surfaceCombinationM33 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList11, surfaceCombinationM32);
                surfaceCombinationM33.addSurfaceConfig(new AutoValue_SurfaceConfig(2, surfaceConfig$ConfigSize5, 0L));
                surfaceCombinationM33.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(2, surfaceConfig$ConfigSize, 0L, surfaceCombinationM33);
                SurfaceCombination surfaceCombinationM34 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList11, surfaceCombinationM33);
                surfaceCombinationM34.addSurfaceConfig(new AutoValue_SurfaceConfig(3, surfaceConfig$ConfigSize5, 0L));
                surfaceCombinationM34.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(2, surfaceConfig$ConfigSize, 0L, surfaceCombinationM34);
                SurfaceCombination surfaceCombinationM35 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList11, surfaceCombinationM34);
                surfaceCombinationM35.addSurfaceConfig(new AutoValue_SurfaceConfig(5, surfaceConfig$ConfigSize5, 0L));
                surfaceCombinationM35.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(2, surfaceConfig$ConfigSize, 0L, surfaceCombinationM35);
                SurfaceCombination surfaceCombinationM36 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList11, surfaceCombinationM35);
                surfaceCombinationM36.addSurfaceConfig(new AutoValue_SurfaceConfig(2, surfaceConfig$ConfigSize5, 0L));
                surfaceCombinationM36.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(5, surfaceConfig$ConfigSize, 0L, surfaceCombinationM36);
                SurfaceCombination surfaceCombinationM37 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList11, surfaceCombinationM36);
                surfaceCombinationM37.addSurfaceConfig(new AutoValue_SurfaceConfig(3, surfaceConfig$ConfigSize5, 0L));
                surfaceCombinationM37.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(5, surfaceConfig$ConfigSize, 0L, surfaceCombinationM37);
                SurfaceCombination surfaceCombinationM38 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList11, surfaceCombinationM37);
                surfaceCombinationM38.addSurfaceConfig(new AutoValue_SurfaceConfig(5, surfaceConfig$ConfigSize5, 0L));
                surfaceCombinationM38.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(5, surfaceConfig$ConfigSize, 0L, surfaceCombinationM38);
                arrayList11.add(surfaceCombinationM38);
                arrayList10.addAll(arrayList11);
            }
            boolean zHasSystemFeature = context.getPackageManager().hasSystemFeature("android.hardware.camera.concurrent");
            this.mIsConcurrentCameraModeSupported = zHasSystemFeature;
            SurfaceConfig$ConfigSize surfaceConfig$ConfigSize6 = SurfaceConfig$ConfigSize.s1440p;
            if (zHasSystemFeature) {
                ArrayList arrayList12 = this.mConcurrentSurfaceCombinations;
                ArrayList arrayList13 = new ArrayList();
                SurfaceCombination surfaceCombination9 = new SurfaceCombination();
                CaptureSession$State$EnumUnboxingLocalUtility.m(2, surfaceConfig$ConfigSize6, 0L, surfaceCombination9);
                SurfaceCombination surfaceCombinationM39 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList13, surfaceCombination9);
                CaptureSession$State$EnumUnboxingLocalUtility.m(1, surfaceConfig$ConfigSize6, 0L, surfaceCombinationM39);
                SurfaceCombination surfaceCombinationM40 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList13, surfaceCombinationM39);
                CaptureSession$State$EnumUnboxingLocalUtility.m(3, surfaceConfig$ConfigSize6, 0L, surfaceCombinationM40);
                SurfaceCombination surfaceCombinationM41 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList13, surfaceCombinationM40);
                SurfaceConfig$ConfigSize surfaceConfig$ConfigSize7 = SurfaceConfig$ConfigSize.s720p;
                surfaceCombinationM41.addSurfaceConfig(new AutoValue_SurfaceConfig(2, surfaceConfig$ConfigSize7, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(3, surfaceConfig$ConfigSize6, 0L, surfaceCombinationM41);
                SurfaceCombination surfaceCombinationM42 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList13, surfaceCombinationM41);
                surfaceCombinationM42.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize7, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(3, surfaceConfig$ConfigSize6, 0L, surfaceCombinationM42);
                SurfaceCombination surfaceCombinationM43 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList13, surfaceCombinationM42);
                surfaceCombinationM43.addSurfaceConfig(new AutoValue_SurfaceConfig(2, surfaceConfig$ConfigSize7, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(2, surfaceConfig$ConfigSize6, 0L, surfaceCombinationM43);
                SurfaceCombination surfaceCombinationM44 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList13, surfaceCombinationM43);
                surfaceCombinationM44.addSurfaceConfig(new AutoValue_SurfaceConfig(2, surfaceConfig$ConfigSize7, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(1, surfaceConfig$ConfigSize6, 0L, surfaceCombinationM44);
                SurfaceCombination surfaceCombinationM45 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList13, surfaceCombinationM44);
                surfaceCombinationM45.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize7, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(2, surfaceConfig$ConfigSize6, 0L, surfaceCombinationM45);
                SurfaceCombination surfaceCombinationM46 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList13, surfaceCombinationM45);
                surfaceCombinationM46.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize7, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(1, surfaceConfig$ConfigSize6, 0L, surfaceCombinationM46);
                arrayList13.add(surfaceCombinationM46);
                arrayList12.addAll(arrayList13);
            }
            if (this.mDynamicRangeResolver.zzc) {
                ArrayList arrayList14 = this.mSurfaceCombinations10Bit;
                ArrayList arrayList15 = new ArrayList();
                SurfaceCombination surfaceCombination10 = new SurfaceCombination();
                CaptureSession$State$EnumUnboxingLocalUtility.m(1, surfaceConfig$ConfigSize, 0L, surfaceCombination10);
                SurfaceCombination surfaceCombinationM47 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList15, surfaceCombination10);
                CaptureSession$State$EnumUnboxingLocalUtility.m(2, surfaceConfig$ConfigSize, 0L, surfaceCombinationM47);
                SurfaceCombination surfaceCombinationM48 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList15, surfaceCombinationM47);
                surfaceCombinationM48.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(3, surfaceConfig$ConfigSize, 0L, surfaceCombinationM48);
                SurfaceCombination surfaceCombinationM49 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList15, surfaceCombinationM48);
                surfaceCombinationM49.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(2, surfaceConfig$ConfigSize, 0L, surfaceCombinationM49);
                SurfaceCombination surfaceCombinationM50 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList15, surfaceCombinationM49);
                surfaceCombinationM50.addSurfaceConfig(new AutoValue_SurfaceConfig(2, surfaceConfig$ConfigSize2, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(2, surfaceConfig$ConfigSize, 0L, surfaceCombinationM50);
                SurfaceCombination surfaceCombinationM51 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList15, surfaceCombinationM50);
                surfaceCombinationM51.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(1, surfaceConfig$ConfigSize3, 0L, surfaceCombinationM51);
                SurfaceCombination surfaceCombinationM52 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList15, surfaceCombinationM51);
                surfaceCombinationM52.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
                surfaceCombinationM52.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize3, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(2, surfaceConfig$ConfigSize3, 0L, surfaceCombinationM52);
                SurfaceCombination surfaceCombinationM53 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList15, surfaceCombinationM52);
                surfaceCombinationM53.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
                surfaceCombinationM53.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize3, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(3, surfaceConfig$ConfigSize3, 0L, surfaceCombinationM53);
                arrayList15.add(surfaceCombinationM53);
                arrayList14.addAll(arrayList15);
            }
            PreviewView.AnonymousClass1 anonymousClass2 = (PreviewView.AnonymousClass1) this.mCharacteristics.getStreamConfigurationMapCompat().mOnInvalidateMenuCallback;
            anonymousClass2.getClass();
            try {
                outputFormats = ((StreamConfigurationMap) anonymousClass2.this$0).getOutputFormats();
            } catch (IllegalArgumentException | NullPointerException e) {
                Logger.w("StreamConfigurationMapCompatBaseImpl", "Failed to get output formats from StreamConfigurationMap", e);
                outputFormats = null;
            }
            int[] iArr4 = outputFormats != null ? (int[]) outputFormats.clone() : null;
            if (iArr4 != null) {
                for (int i5 : iArr4) {
                    if (i5 == 4101) {
                        ArrayList arrayList16 = this.mSurfaceCombinationsUltraHdr;
                        ArrayList arrayList17 = new ArrayList();
                        SurfaceCombination surfaceCombination11 = new SurfaceCombination();
                        CaptureSession$State$EnumUnboxingLocalUtility.m(4, surfaceConfig$ConfigSize, 0L, surfaceCombination11);
                        SurfaceCombination surfaceCombinationM54 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList17, surfaceCombination11);
                        surfaceCombinationM54.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
                        CaptureSession$State$EnumUnboxingLocalUtility.m(4, surfaceConfig$ConfigSize, 0L, surfaceCombinationM54);
                        arrayList17.add(surfaceCombinationM54);
                        arrayList16.addAll(arrayList17);
                        break;
                    }
                }
            }
            CameraCharacteristicsCompat cameraCharacteristicsCompat3 = this.mCharacteristics;
            AutoValue_Config_Option autoValue_Config_Option = StreamUseCaseUtil.STREAM_USE_CASE_STREAM_SPEC_OPTION;
            int i6 = Build.VERSION.SDK_INT;
            boolean z5 = (i6 < 33 || (jArr = (long[]) cameraCharacteristicsCompat3.get(CameraCharacteristics.SCALER_AVAILABLE_STREAM_USE_CASES)) == null || jArr.length == 0) ? false : true;
            this.mIsStreamUseCaseSupported = z5;
            if (z5 && i6 >= 33) {
                ArrayList arrayList18 = this.mSurfaceCombinationsStreamUseCase;
                ArrayList arrayList19 = new ArrayList();
                SurfaceCombination surfaceCombination12 = new SurfaceCombination();
                CaptureSession$State$EnumUnboxingLocalUtility.m(1, surfaceConfig$ConfigSize6, 4L, surfaceCombination12);
                SurfaceCombination surfaceCombinationM55 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList19, surfaceCombination12);
                CaptureSession$State$EnumUnboxingLocalUtility.m(2, surfaceConfig$ConfigSize6, 4L, surfaceCombinationM55);
                SurfaceCombination surfaceCombinationM56 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList19, surfaceCombinationM55);
                CaptureSession$State$EnumUnboxingLocalUtility.m(1, surfaceConfig$ConfigSize3, 3L, surfaceCombinationM56);
                SurfaceCombination surfaceCombinationM57 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList19, surfaceCombinationM56);
                CaptureSession$State$EnumUnboxingLocalUtility.m(2, surfaceConfig$ConfigSize3, 3L, surfaceCombinationM57);
                SurfaceCombination surfaceCombinationM58 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList19, surfaceCombinationM57);
                CaptureSession$State$EnumUnboxingLocalUtility.m(3, surfaceConfig$ConfigSize, 2L, surfaceCombinationM58);
                SurfaceCombination surfaceCombinationM59 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList19, surfaceCombinationM58);
                CaptureSession$State$EnumUnboxingLocalUtility.m(2, surfaceConfig$ConfigSize, 2L, surfaceCombinationM59);
                SurfaceCombination surfaceCombinationM60 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList19, surfaceCombinationM59);
                surfaceCombinationM60.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 1L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(3, surfaceConfig$ConfigSize, 2L, surfaceCombinationM60);
                SurfaceCombination surfaceCombinationM61 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList19, surfaceCombinationM60);
                surfaceCombinationM61.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 1L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(2, surfaceConfig$ConfigSize, 2L, surfaceCombinationM61);
                SurfaceCombination surfaceCombinationM62 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList19, surfaceCombinationM61);
                surfaceCombinationM62.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 1L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(1, surfaceConfig$ConfigSize3, 3L, surfaceCombinationM62);
                SurfaceCombination surfaceCombinationM63 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList19, surfaceCombinationM62);
                surfaceCombinationM63.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 1L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(2, surfaceConfig$ConfigSize3, 3L, surfaceCombinationM63);
                SurfaceCombination surfaceCombinationM64 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList19, surfaceCombinationM63);
                surfaceCombinationM64.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 1L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(2, surfaceConfig$ConfigSize2, 1L, surfaceCombinationM64);
                SurfaceCombination surfaceCombinationM65 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList19, surfaceCombinationM64);
                surfaceCombinationM65.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 1L));
                surfaceCombinationM65.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize3, 3L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(3, surfaceConfig$ConfigSize3, 2L, surfaceCombinationM65);
                SurfaceCombination surfaceCombinationM66 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList19, surfaceCombinationM65);
                surfaceCombinationM66.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 1L));
                surfaceCombinationM66.addSurfaceConfig(new AutoValue_SurfaceConfig(2, surfaceConfig$ConfigSize3, 3L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(3, surfaceConfig$ConfigSize3, 2L, surfaceCombinationM66);
                SurfaceCombination surfaceCombinationM67 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList19, surfaceCombinationM66);
                surfaceCombinationM67.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 1L));
                surfaceCombinationM67.addSurfaceConfig(new AutoValue_SurfaceConfig(2, surfaceConfig$ConfigSize2, 1L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(3, surfaceConfig$ConfigSize, 2L, surfaceCombinationM67);
                arrayList19.add(surfaceCombinationM67);
                arrayList18.addAll(arrayList19);
            }
            CameraCharacteristicsCompat cameraCharacteristicsCompat4 = this.mCharacteristics;
            if (i6 < 33 || (iArr = (int[]) cameraCharacteristicsCompat4.get(CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES)) == null || iArr.length == 0) {
                z2 = false;
                break;
            }
            int length2 = iArr.length;
            int i7 = 0;
            while (true) {
                if (i7 >= length2) {
                    z2 = false;
                    break;
                } else {
                    if (iArr[i7] == 2) {
                        z2 = true;
                        break;
                    }
                    i7++;
                }
            }
            if (z2 && Build.VERSION.SDK_INT >= 33) {
                ArrayList arrayList20 = this.mPreviewStabilizationSurfaceCombinations;
                ArrayList arrayList21 = new ArrayList();
                SurfaceCombination surfaceCombination13 = new SurfaceCombination();
                CaptureSession$State$EnumUnboxingLocalUtility.m(1, surfaceConfig$ConfigSize6, 0L, surfaceCombination13);
                SurfaceCombination surfaceCombinationM68 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList21, surfaceCombination13);
                CaptureSession$State$EnumUnboxingLocalUtility.m(2, surfaceConfig$ConfigSize6, 0L, surfaceCombinationM68);
                SurfaceCombination surfaceCombinationM69 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList21, surfaceCombinationM68);
                surfaceCombinationM69.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize6, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(3, surfaceConfig$ConfigSize, 0L, surfaceCombinationM69);
                SurfaceCombination surfaceCombinationM70 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList21, surfaceCombinationM69);
                surfaceCombinationM70.addSurfaceConfig(new AutoValue_SurfaceConfig(2, surfaceConfig$ConfigSize6, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(3, surfaceConfig$ConfigSize, 0L, surfaceCombinationM70);
                SurfaceCombination surfaceCombinationM71 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList21, surfaceCombinationM70);
                surfaceCombinationM71.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize6, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(2, surfaceConfig$ConfigSize, 0L, surfaceCombinationM71);
                SurfaceCombination surfaceCombinationM72 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList21, surfaceCombinationM71);
                surfaceCombinationM72.addSurfaceConfig(new AutoValue_SurfaceConfig(2, surfaceConfig$ConfigSize6, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(2, surfaceConfig$ConfigSize, 0L, surfaceCombinationM72);
                SurfaceCombination surfaceCombinationM73 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList21, surfaceCombinationM72);
                surfaceCombinationM73.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(1, surfaceConfig$ConfigSize6, 0L, surfaceCombinationM73);
                SurfaceCombination surfaceCombinationM74 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList21, surfaceCombinationM73);
                surfaceCombinationM74.addSurfaceConfig(new AutoValue_SurfaceConfig(2, surfaceConfig$ConfigSize2, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(1, surfaceConfig$ConfigSize6, 0L, surfaceCombinationM74);
                SurfaceCombination surfaceCombinationM75 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList21, surfaceCombinationM74);
                surfaceCombinationM75.addSurfaceConfig(new AutoValue_SurfaceConfig(1, surfaceConfig$ConfigSize2, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(2, surfaceConfig$ConfigSize6, 0L, surfaceCombinationM75);
                SurfaceCombination surfaceCombinationM76 = CaptureSession$State$EnumUnboxingLocalUtility.m(arrayList21, surfaceCombinationM75);
                surfaceCombinationM76.addSurfaceConfig(new AutoValue_SurfaceConfig(2, surfaceConfig$ConfigSize2, 0L));
                CaptureSession$State$EnumUnboxingLocalUtility.m(2, surfaceConfig$ConfigSize6, 0L, surfaceCombinationM76);
                arrayList21.add(surfaceCombinationM76);
                arrayList20.addAll(arrayList21);
            }
            generateSurfaceSizeDefinition();
        } catch (CameraAccessExceptionCompat e2) {
            throw new CameraUnavailableException(e2);
        }
    }

    public static Size getMaxOutputSizeByFormat(StreamConfigurationMap streamConfigurationMap, int i, boolean z) {
        Size[] highResolutionOutputSizes;
        Size[] outputSizes = i == 34 ? streamConfigurationMap.getOutputSizes(SurfaceTexture.class) : streamConfigurationMap.getOutputSizes(i);
        if (outputSizes == null || outputSizes.length == 0) {
            return null;
        }
        CompareSizesByArea compareSizesByArea = new CompareSizesByArea(false);
        Size size = (Size) Collections.max(Arrays.asList(outputSizes), compareSizesByArea);
        Size size2 = SizeUtil.RESOLUTION_ZERO;
        if (z && (highResolutionOutputSizes = streamConfigurationMap.getHighResolutionOutputSizes(i)) != null && highResolutionOutputSizes.length > 0) {
            size2 = (Size) Collections.max(Arrays.asList(highResolutionOutputSizes), compareSizesByArea);
        }
        return (Size) Collections.max(Arrays.asList(size, size2), compareSizesByArea);
    }

    public static int getRangeDistance(Range range, Range range2) {
        Preconditions.checkState("Ranges must not intersect", (range.contains((Integer) range2.getUpper()) || range.contains((Integer) range2.getLower())) ? false : true);
        return ((Integer) range.getLower()).intValue() > ((Integer) range2.getUpper()).intValue() ? ((Integer) range.getLower()).intValue() - ((Integer) range2.getUpper()).intValue() : ((Integer) range2.getLower()).intValue() - ((Integer) range.getUpper()).intValue();
    }

    public static int getRangeLength(Range range) {
        return (((Integer) range.getUpper()).intValue() - ((Integer) range.getLower()).intValue()) + 1;
    }

    public final boolean checkSupported(AutoValue_SupportedSurfaceCombination_FeatureSettings autoValue_SupportedSurfaceCombination_FeatureSettings, List list) {
        List list2;
        HashMap map = this.mFeatureSettingsToSupportedCombinationsMap;
        if (map.containsKey(autoValue_SupportedSurfaceCombination_FeatureSettings)) {
            list2 = (List) map.get(autoValue_SupportedSurfaceCombination_FeatureSettings);
        } else {
            ArrayList arrayList = new ArrayList();
            boolean z = autoValue_SupportedSurfaceCombination_FeatureSettings.ultraHdrOn;
            int i = autoValue_SupportedSurfaceCombination_FeatureSettings.cameraMode;
            if (!z) {
                int i2 = autoValue_SupportedSurfaceCombination_FeatureSettings.requiredMaxBitDepth;
                if (i2 == 8) {
                    if (i != 1) {
                        ArrayList arrayList2 = this.mSurfaceCombinations;
                        if (i != 2) {
                            if (autoValue_SupportedSurfaceCombination_FeatureSettings.previewStabilizationOn) {
                                arrayList2 = this.mPreviewStabilizationSurfaceCombinations;
                            }
                            arrayList.addAll(arrayList2);
                        } else {
                            arrayList.addAll(this.mUltraHighSurfaceCombinations);
                            arrayList.addAll(arrayList2);
                        }
                    } else {
                        arrayList = this.mConcurrentSurfaceCombinations;
                    }
                } else if (i2 == 10 && i == 0) {
                    arrayList.addAll(this.mSurfaceCombinations10Bit);
                }
            } else if (i == 0) {
                arrayList.addAll(this.mSurfaceCombinationsUltraHdr);
            }
            map.put(autoValue_SupportedSurfaceCombination_FeatureSettings, arrayList);
            list2 = arrayList;
        }
        Iterator it = list2.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            z2 = ((SurfaceCombination) it.next()).getOrderedSupportedSurfaceConfigList(list) != null;
            if (z2) {
                break;
            }
        }
        return z2;
    }

    public final void generateSurfaceSizeDefinition() {
        Size size;
        Size size2;
        Size size3;
        Size previewSize = this.mDisplayInfoManager.getPreviewSize();
        try {
            int i = Integer.parseInt(this.mCameraId);
            CamcorderProfileHelper camcorderProfileHelper = this.mCamcorderProfileHelper;
            CamcorderProfile camcorderProfile = null;
            CamcorderProfile camcorderProfile2 = camcorderProfileHelper.hasProfile(i, 1) ? camcorderProfileHelper.get(i, 1) : null;
            if (camcorderProfile2 == null) {
                Size size4 = SizeUtil.RESOLUTION_480P;
                if (camcorderProfileHelper.hasProfile(i, 10)) {
                    camcorderProfile = camcorderProfileHelper.get(i, 10);
                } else if (camcorderProfileHelper.hasProfile(i, 8)) {
                    camcorderProfile = camcorderProfileHelper.get(i, 8);
                } else if (camcorderProfileHelper.hasProfile(i, 12)) {
                    camcorderProfile = camcorderProfileHelper.get(i, 12);
                } else if (camcorderProfileHelper.hasProfile(i, 6)) {
                    camcorderProfile = camcorderProfileHelper.get(i, 6);
                } else if (camcorderProfileHelper.hasProfile(i, 5)) {
                    camcorderProfile = camcorderProfileHelper.get(i, 5);
                } else if (camcorderProfileHelper.hasProfile(i, 4)) {
                    camcorderProfile = camcorderProfileHelper.get(i, 4);
                }
                if (camcorderProfile != null) {
                    size2 = new Size(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight);
                } else {
                    size3 = size4;
                }
                this.mSurfaceSizeDefinition = new AutoValue_SurfaceSizeDefinition(SizeUtil.RESOLUTION_VGA, new HashMap(), previewSize, new HashMap(), size3, new HashMap(), new HashMap());
            }
            size2 = new Size(camcorderProfile2.videoFrameWidth, camcorderProfile2.videoFrameHeight);
        } catch (NumberFormatException unused) {
            Size[] outputSizes = ((StreamConfigurationMap) ((PreviewView.AnonymousClass1) this.mCharacteristics.getStreamConfigurationMapCompat().mOnInvalidateMenuCallback).this$0).getOutputSizes(MediaRecorder.class);
            if (outputSizes == null) {
                size = SizeUtil.RESOLUTION_480P;
            } else {
                Arrays.sort(outputSizes, new CompareSizesByArea(true));
                int length = outputSizes.length;
                int i2 = 0;
                while (true) {
                    if (i2 < length) {
                        Size size5 = outputSizes[i2];
                        int width = size5.getWidth();
                        Size size6 = SizeUtil.RESOLUTION_1080P;
                        if (width <= size6.getWidth() && size5.getHeight() <= size6.getHeight()) {
                            size2 = size5;
                            break;
                        }
                        i2++;
                    } else {
                        size = SizeUtil.RESOLUTION_480P;
                    }
                }
            }
            size2 = size;
            break;
        }
        size3 = size2;
        this.mSurfaceSizeDefinition = new AutoValue_SurfaceSizeDefinition(SizeUtil.RESOLUTION_VGA, new HashMap(), previewSize, new HashMap(), size3, new HashMap(), new HashMap());
    }

    public final List getOrderedSupportedStreamUseCaseSurfaceConfigList(AutoValue_SupportedSurfaceCombination_FeatureSettings autoValue_SupportedSurfaceCombination_FeatureSettings, List list) {
        AutoValue_Config_Option autoValue_Config_Option = StreamUseCaseUtil.STREAM_USE_CASE_STREAM_SPEC_OPTION;
        if (autoValue_SupportedSurfaceCombination_FeatureSettings.cameraMode != 0 || autoValue_SupportedSurfaceCombination_FeatureSettings.requiredMaxBitDepth != 8) {
            return null;
        }
        ArrayList arrayList = this.mSurfaceCombinationsStreamUseCase;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            List orderedSupportedSurfaceConfigList = ((SurfaceCombination) obj).getOrderedSupportedSurfaceConfigList(list);
            if (orderedSupportedSurfaceConfigList != null) {
                return orderedSupportedSurfaceConfigList;
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:309:0x08a0  */
    /* JADX WARN: Code duplicated, block: B:319:0x08c2 A[LOOP:27: B:318:0x08c0->B:319:0x08c2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:323:0x08d8  */
    /* JADX WARN: Code duplicated, block: B:418:0x0b2a  */
    /* JADX WARN: Code duplicated, block: B:419:0x0b2c  */
    /* JADX WARN: Code duplicated, block: B:428:0x0b47  */
    /* JADX WARN: Code duplicated, block: B:438:0x0b7f  */
    /* JADX WARN: Code duplicated, block: B:440:0x0b83  */
    /* JADX WARN: Code duplicated, block: B:487:0x0cab  */
    /* JADX WARN: Code duplicated, block: B:515:0x0d51  */
    /* JADX WARN: Code duplicated, block: B:517:0x0d6b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:521:0x0d77  */
    /* JADX WARN: Code duplicated, block: B:523:0x0d85 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:527:0x0d8e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:528:0x0d90  */
    /* JADX WARN: Code duplicated, block: B:534:0x0da3  */
    /* JADX WARN: Code duplicated, block: B:537:0x0dad  */
    /* JADX WARN: Code duplicated, block: B:542:0x0dc2  */
    /* JADX WARN: Code duplicated, block: B:544:0x0dde  */
    /* JADX WARN: Code duplicated, block: B:546:0x0deb  */
    /* JADX WARN: Code duplicated, block: B:548:0x0df1  */
    /* JADX WARN: Code duplicated, block: B:550:0x0dfd  */
    /* JADX WARN: Code duplicated, block: B:552:0x0e05  */
    /* JADX WARN: Code duplicated, block: B:560:0x0e23  */
    /* JADX WARN: Code duplicated, block: B:564:0x0e31  */
    /* JADX WARN: Code duplicated, block: B:570:0x0e68  */
    /* JADX WARN: Code duplicated, block: B:572:0x0e7a  */
    /* JADX WARN: Code duplicated, block: B:574:0x0e8c  */
    /* JADX WARN: Code duplicated, block: B:576:0x0e99  */
    /* JADX WARN: Code duplicated, block: B:578:0x0e9f  */
    /* JADX WARN: Code duplicated, block: B:580:0x0eab  */
    /* JADX WARN: Code duplicated, block: B:582:0x0eb3  */
    /* JADX WARN: Code duplicated, block: B:590:0x0ecf  */
    /* JADX WARN: Code duplicated, block: B:592:0x0ed4  */
    /* JADX WARN: Code duplicated, block: B:594:0x0ee2  */
    /* JADX WARN: Code duplicated, block: B:596:0x0efc  */
    /* JADX WARN: Code duplicated, block: B:653:0x019c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:707:0x092a A[EDGE_INSN: B:707:0x092a->B:328:0x092a BREAK  A[LOOP:25: B:278:0x07c0->B:326:0x08ec, LOOP_LABEL: LOOP:25: B:278:0x07c0->B:326:0x08ec], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:711:0x08ec A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:738:0x0ec3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:739:0x0ebd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x0246  */
    /* JADX WARN: Code duplicated, block: B:740:0x0f0f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:742:0x0ec9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:745:0x0f09 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:750:0x0d71 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:751:0x0d88 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:752:0x0d99 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:755:0x0dbb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:758:0x0e1d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:759:0x0e17 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:760:0x0e11 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:765:0x0e53 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:767:0x0e2f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x02a0  */
    public final Pair getSuggestedStreamSpecifications(int i, ArrayList arrayList, HashMap map, boolean z, boolean z2) {
        ArrayList arrayList2;
        boolean z3;
        int i2;
        boolean z4;
        SupportedSurfaceCombination supportedSurfaceCombination;
        HashMap map2;
        HashMap map3;
        HashMap map4;
        HashMap map5;
        int i3;
        String str;
        ArrayList arrayList3;
        Range range;
        String str2;
        ArrayList arrayList4;
        ArrayList arrayList5;
        DynamicRange dynamicRange;
        String str3;
        ArrayList arrayList6;
        List list;
        int i4;
        int i5;
        String str4;
        ArrayList arrayList7;
        ArrayList arrayList8;
        HashMap map6;
        String str5;
        HashMap map7;
        List list2;
        List list3;
        HashMap map8;
        boolean z5;
        boolean z6;
        int size;
        int i6;
        Iterator it;
        int size2;
        int i7;
        int size3;
        int i8;
        UseCaseConfig useCaseConfig;
        AutoValue_StreamSpec autoValue_StreamSpec;
        Camera2ImplConfig updatedImplementationOptionsWithUseCaseStreamSpecOption;
        AutoValue_AttachedSurfaceInfo autoValue_AttachedSurfaceInfo;
        Camera2ImplConfig updatedImplementationOptionsWithUseCaseStreamSpecOption2;
        HashMap map9;
        Size size4;
        Request request;
        Range range2;
        DynamicRange dynamicRange2;
        Range range3;
        boolean z7;
        UseCaseConfig useCaseConfig2;
        boolean z8;
        AutoValue_Config_Option autoValue_Config_Option;
        Long l;
        int i9;
        long j;
        HashMap map10;
        UseCaseConfig useCaseConfig3;
        AutoValue_StreamSpec autoValue_StreamSpec2;
        Camera2ImplConfig updatedImplementationOptionsWithUseCaseStreamSpecOption3;
        AutoValue_AttachedSurfaceInfo autoValue_AttachedSurfaceInfo2;
        Camera2ImplConfig updatedImplementationOptionsWithUseCaseStreamSpecOption4;
        Size size5;
        Request request2;
        Range range4;
        DynamicRange dynamicRange3;
        Range range5;
        Range[] rangeArr;
        int i10;
        Range range6;
        List list4;
        long[] jArr;
        HashSet hashSet;
        int i11;
        Iterator it2;
        int i12;
        int outputMinFrameDuration;
        Rational rational;
        HashMap map11;
        Size verifiedResolution;
        DynamicRange dynamicRange4;
        HashMap map12;
        int outputMinFrameDuration2;
        int i13;
        ArrayList arrayList9;
        ArrayList arrayList10;
        DynamicRange dynamicRangeFindSupportedHdrMatch;
        Set set;
        zzr zzrVar;
        Iterator it3;
        DynamicRange recommended10BitDynamicRange;
        DynamicRange dynamicRange5 = DynamicRange.SDR;
        DisplayInfoManager displayInfoManager = this.mDisplayInfoManager;
        displayInfoManager.mPreviewSize = displayInfoManager.calculatePreviewSize();
        if (this.mSurfaceSizeDefinition == null) {
            generateSurfaceSizeDefinition();
        } else {
            Size previewSize = this.mDisplayInfoManager.getPreviewSize();
            AutoValue_SurfaceSizeDefinition autoValue_SurfaceSizeDefinition = this.mSurfaceSizeDefinition;
            this.mSurfaceSizeDefinition = new AutoValue_SurfaceSizeDefinition(autoValue_SurfaceSizeDefinition.analysisSize, autoValue_SurfaceSizeDefinition.s720pSizeMap, previewSize, autoValue_SurfaceSizeDefinition.s1440pSizeMap, autoValue_SurfaceSizeDefinition.recordSize, autoValue_SurfaceSizeDefinition.maximumSizeMap, autoValue_SurfaceSizeDefinition.ultraMaximumSizeMap);
        }
        ArrayList arrayList11 = new ArrayList(map.keySet());
        ArrayList arrayList12 = new ArrayList();
        ArrayList arrayList13 = new ArrayList();
        int size6 = arrayList11.size();
        int i14 = 0;
        while (i14 < size6) {
            Object obj = arrayList11.get(i14);
            i14++;
            int surfaceOccupancyPriority = ((UseCaseConfig) obj).getSurfaceOccupancyPriority();
            if (!arrayList13.contains(Integer.valueOf(surfaceOccupancyPriority))) {
                arrayList13.add(Integer.valueOf(surfaceOccupancyPriority));
            }
        }
        Collections.sort(arrayList13);
        Collections.reverse(arrayList13);
        int size7 = arrayList13.size();
        int i15 = 0;
        while (i15 < size7) {
            Object obj2 = arrayList13.get(i15);
            i15++;
            int iIntValue = ((Integer) obj2).intValue();
            int size8 = arrayList11.size();
            int i16 = 0;
            while (i16 < size8) {
                Object obj3 = arrayList11.get(i16);
                i16++;
                UseCaseConfig useCaseConfig4 = (UseCaseConfig) obj3;
                if (iIntValue == useCaseConfig4.getSurfaceOccupancyPriority()) {
                    arrayList12.add(Integer.valueOf(arrayList11.indexOf(useCaseConfig4)));
                }
            }
        }
        zzr zzrVar2 = this.mDynamicRangeResolver;
        Toolbar.AnonymousClass1 anonymousClass1 = (Toolbar.AnonymousClass1) zzrVar2.zzb;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int size9 = arrayList.size();
        int i17 = 0;
        while (i17 < size9) {
            Object obj4 = arrayList.get(i17);
            i17++;
            linkedHashSet.add(((AutoValue_AttachedSurfaceInfo) obj4).dynamicRange);
        }
        Set supportedDynamicRanges = ((DynamicRangesCompat$DynamicRangeProfilesCompatImpl) anonymousClass1.this$0).getSupportedDynamicRanges();
        HashSet hashSet2 = new HashSet(supportedDynamicRanges);
        Iterator it4 = linkedHashSet.iterator();
        while (it4.hasNext()) {
            zzr.updateConstraints(hashSet2, (DynamicRange) it4.next(), anonymousClass1);
        }
        ArrayList arrayList14 = new ArrayList();
        ArrayList arrayList15 = new ArrayList();
        ArrayList arrayList16 = new ArrayList();
        int size10 = arrayList12.size();
        int i18 = 0;
        while (i18 < size10) {
            Object obj5 = arrayList12.get(i18);
            int i19 = i18 + 1;
            UseCaseConfig useCaseConfig5 = (UseCaseConfig) arrayList11.get(((Integer) obj5).intValue());
            DynamicRange dynamicRange6 = useCaseConfig5.getDynamicRange();
            int i20 = size10;
            if (dynamicRange6.equals(DynamicRange.UNSPECIFIED)) {
                arrayList16.add(useCaseConfig5);
            } else {
                int i21 = dynamicRange6.mEncoding;
                int i22 = dynamicRange6.mBitDepth;
                if (i21 == 2 || ((i21 != 0 && i22 == 0) || (i21 == 0 && i22 != 0))) {
                    arrayList15.add(useCaseConfig5);
                } else {
                    arrayList14.add(useCaseConfig5);
                }
            }
            i18 = i19;
            size10 = i20;
        }
        HashMap map13 = new HashMap();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        ArrayList arrayList17 = new ArrayList();
        arrayList17.addAll(arrayList14);
        arrayList17.addAll(arrayList15);
        arrayList17.addAll(arrayList16);
        int size11 = arrayList17.size();
        int i23 = 0;
        while (true) {
            Range range7 = null;
            if (i23 >= size11) {
                ArrayList arrayList18 = arrayList11;
                ArrayList arrayList19 = arrayList12;
                int size12 = arrayList.size();
                int i24 = 0;
                while (true) {
                    if (i24 >= size12) {
                        arrayList2 = arrayList;
                        Iterator it5 = map.keySet().iterator();
                        while (true) {
                            if (!it5.hasNext()) {
                                z3 = false;
                                break;
                            }
                            if (((UseCaseConfig) it5.next()).getInputFormat() == 4101) {
                            }
                        }
                    } else {
                        arrayList2 = arrayList;
                        Object obj6 = arrayList2.get(i24);
                        i24++;
                        if (((AutoValue_AttachedSurfaceInfo) obj6).imageFormat == 4101) {
                        }
                    }
                    z3 = true;
                    break;
                }
                SupportedSurfaceCombination supportedSurfaceCombination2 = this;
                String str6 = supportedSurfaceCombination2.mCameraId;
                Iterator it6 = map13.values().iterator();
                while (true) {
                    if (!it6.hasNext()) {
                        i2 = 8;
                        break;
                    }
                    if (((DynamicRange) it6.next()).mBitDepth == 10) {
                        i2 = 10;
                        break;
                    }
                }
                if (i != 0 && z3) {
                    throw new IllegalArgumentException("Camera device id is " + str6 + ". Ultra HDR is not currently supported in " + (i != 1 ? i != 2 ? "DEFAULT" : "ULTRA_HIGH_RESOLUTION_CAMERA" : "CONCURRENT_CAMERA") + " camera mode.");
                }
                if (i != 0 && i2 == 10) {
                    throw new IllegalArgumentException("Camera device id is " + str6 + ". 10 bit dynamic range is not currently supported in " + (i != 1 ? i != 2 ? "DEFAULT" : "ULTRA_HIGH_RESOLUTION_CAMERA" : "CONCURRENT_CAMERA") + " camera mode.");
                }
                AutoValue_SupportedSurfaceCombination_FeatureSettings autoValue_SupportedSurfaceCombination_FeatureSettings = new AutoValue_SupportedSurfaceCombination_FeatureSettings(i, i2, z, z3);
                ArrayList arrayList20 = new ArrayList();
                int size13 = arrayList2.size();
                int i25 = 0;
                while (i25 < size13) {
                    Object obj7 = arrayList2.get(i25);
                    i25++;
                    arrayList20.add(((AutoValue_AttachedSurfaceInfo) obj7).surfaceConfig);
                }
                CompareSizesByArea compareSizesByArea = new CompareSizesByArea(false);
                for (UseCaseConfig useCaseConfig6 : map.keySet()) {
                    List list5 = (List) map.get(useCaseConfig6);
                    Preconditions.checkArgument("No available output size is found for " + useCaseConfig6 + ".", (list5 == null || list5.isEmpty()) ? false : true);
                    Size size14 = (Size) Collections.min(list5, compareSizesByArea);
                    int inputFormat = useCaseConfig6.getInputFormat();
                    arrayList20.add(AutoValue_SurfaceConfig.transformSurfaceConfig(autoValue_SupportedSurfaceCombination_FeatureSettings.cameraMode, inputFormat, size14, supportedSurfaceCombination2.getUpdatedSurfaceSizeDefinitionByFormat(inputFormat)));
                }
                HashMap map14 = map;
                boolean zCheckSupported = supportedSurfaceCombination2.checkSupported(autoValue_SupportedSurfaceCombination_FeatureSettings, arrayList20);
                String str7 = " New configs: ";
                String str8 = "No supported surface combination is found for camera device - Id : ";
                if (!zCheckSupported) {
                    throw new IllegalArgumentException("No supported surface combination is found for camera device - Id : " + supportedSurfaceCombination2.mCameraId + ".  May be attempting to bind too many use cases. Existing surfaces: " + arrayList2 + " New configs: " + arrayList18);
                }
                int size15 = arrayList2.size();
                Range rangeIntersect = null;
                int i26 = 0;
                while (i26 < size15) {
                    Object obj8 = arrayList2.get(i26);
                    i26++;
                    Range range8 = ((AutoValue_AttachedSurfaceInfo) obj8).targetFrameRate;
                    if (rangeIntersect == null) {
                        rangeIntersect = range8;
                    } else if (range8 != null) {
                        try {
                            rangeIntersect = rangeIntersect.intersect(range8);
                        } catch (IllegalArgumentException unused) {
                        }
                    }
                }
                int size16 = arrayList19.size();
                Range rangeIntersect2 = rangeIntersect;
                int i27 = 0;
                while (i27 < size16) {
                    ArrayList arrayList21 = arrayList19;
                    Object obj9 = arrayList21.get(i27);
                    i27++;
                    String str9 = str7;
                    ArrayList arrayList22 = arrayList18;
                    Range targetFrameRate = ((UseCaseConfig) arrayList22.get(((Integer) obj9).intValue())).getTargetFrameRate();
                    if (rangeIntersect2 == null) {
                        rangeIntersect2 = targetFrameRate;
                    } else if (targetFrameRate != null) {
                        try {
                            rangeIntersect2 = rangeIntersect2.intersect(targetFrameRate);
                        } catch (IllegalArgumentException unused2) {
                        }
                    }
                    arrayList18 = arrayList22;
                    arrayList19 = arrayList21;
                    str7 = str9;
                }
                String str10 = str7;
                ArrayList arrayList23 = arrayList18;
                ArrayList arrayList24 = arrayList19;
                HashMap map15 = new HashMap();
                Iterator it7 = map14.keySet().iterator();
                while (it7.hasNext()) {
                    UseCaseConfig useCaseConfig7 = (UseCaseConfig) it7.next();
                    ArrayList arrayList25 = new ArrayList();
                    String str11 = str8;
                    HashMap map16 = new HashMap();
                    for (Size size17 : (List) map14.get(useCaseConfig7)) {
                        Range range9 = rangeIntersect2;
                        int inputFormat2 = useCaseConfig7.getInputFormat();
                        Iterator it8 = it7;
                        boolean z9 = zCheckSupported;
                        SurfaceConfig$ConfigSize surfaceConfig$ConfigSize = AutoValue_SurfaceConfig.transformSurfaceConfig(autoValue_SupportedSurfaceCombination_FeatureSettings.cameraMode, inputFormat2, size17, supportedSurfaceCombination2.getUpdatedSurfaceSizeDefinitionByFormat(inputFormat2)).configSize;
                        if (range9 != null) {
                            map12 = map13;
                            try {
                                dynamicRange4 = dynamicRange5;
                                try {
                                    outputMinFrameDuration2 = (int) (1.0E9d / ((StreamConfigurationMap) supportedSurfaceCombination2.mCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputMinFrameDuration(inputFormat2, size17));
                                } catch (Exception unused3) {
                                    outputMinFrameDuration2 = 0;
                                }
                            } catch (Exception unused4) {
                                dynamicRange4 = dynamicRange5;
                            }
                        } else {
                            dynamicRange4 = dynamicRange5;
                            map12 = map13;
                            outputMinFrameDuration2 = Integer.MAX_VALUE;
                        }
                        Set hashSet3 = (Set) map16.get(surfaceConfig$ConfigSize);
                        if (hashSet3 == null) {
                            hashSet3 = new HashSet();
                            map16.put(surfaceConfig$ConfigSize, hashSet3);
                        }
                        if (!hashSet3.contains(Integer.valueOf(outputMinFrameDuration2))) {
                            arrayList25.add(size17);
                            hashSet3.add(Integer.valueOf(outputMinFrameDuration2));
                        }
                        dynamicRange5 = dynamicRange4;
                        it7 = it8;
                        rangeIntersect2 = range9;
                        zCheckSupported = z9;
                        map13 = map12;
                    }
                    map15.put(useCaseConfig7, arrayList25);
                    map14 = map;
                    str8 = str11;
                    zCheckSupported = zCheckSupported;
                }
                String str12 = str8;
                Range range10 = rangeIntersect2;
                HashMap map17 = map13;
                boolean z10 = zCheckSupported;
                DynamicRange dynamicRange7 = dynamicRange5;
                ArrayList arrayList26 = new ArrayList();
                int size18 = arrayList24.size();
                int i28 = 0;
                while (i28 < size18) {
                    Object obj10 = arrayList24.get(i28);
                    i28++;
                    UseCaseConfig useCaseConfig8 = (UseCaseConfig) arrayList23.get(((Integer) obj10).intValue());
                    List<Size> list6 = (List) map15.get(useCaseConfig8);
                    int inputFormat3 = useCaseConfig8.getInputFormat();
                    Path.Companion companion = supportedSurfaceCombination2.mTargetAspectRatio;
                    CameraCharacteristicsCompat cameraCharacteristicsCompat = supportedSurfaceCombination2.mCharacteristics;
                    companion.getClass();
                    if (((Nexus4AndroidLTargetAspectRatioQuirk) DeviceQuirks.sQuirks.get(Nexus4AndroidLTargetAspectRatioQuirk.class)) == null && ((AspectRatioLegacyApi21Quirk) ProgressionUtilKt.get(cameraCharacteristicsCompat).get(AspectRatioLegacyApi21Quirk.class)) == null) {
                        rational = null;
                    } else {
                        Size size19 = (Size) supportedSurfaceCombination2.getUpdatedSurfaceSizeDefinitionByFormat(256).maximumSizeMap.get(256);
                        rational = new Rational(size19.getWidth(), size19.getHeight());
                    }
                    if (rational == null) {
                        map11 = map15;
                    } else {
                        ArrayList arrayList27 = new ArrayList();
                        ArrayList arrayList28 = new ArrayList();
                        for (Size size20 : list6) {
                            HashMap map18 = map15;
                            if (AspectRatioUtil.hasMatchingAspectRatio(rational, size20)) {
                                arrayList27.add(size20);
                            } else {
                                arrayList28.add(size20);
                            }
                            map15 = map18;
                        }
                        map11 = map15;
                        arrayList28.addAll(0, arrayList27);
                        list6 = arrayList28;
                    }
                    PreviewView.AnonymousClass1 anonymousClass2 = supportedSurfaceCombination2.mResolutionCorrector;
                    int configType = AutoValue_SurfaceConfig.getConfigType(inputFormat3);
                    if (((ExtraCroppingQuirk) anonymousClass2.this$0) != null && (verifiedResolution = ExtraCroppingQuirk.getVerifiedResolution(configType)) != null) {
                        ArrayList arrayList29 = new ArrayList();
                        arrayList29.add(verifiedResolution);
                        for (Size size21 : list6) {
                            if (!size21.equals(verifiedResolution)) {
                                arrayList29.add(size21);
                            }
                        }
                        list6 = arrayList29;
                    }
                    arrayList26.add(list6);
                    map15 = map11;
                }
                int size22 = arrayList26.size();
                int size23 = 1;
                int i29 = 0;
                while (i29 < size22) {
                    Object obj11 = arrayList26.get(i29);
                    i29++;
                    size23 *= ((List) obj11).size();
                }
                if (size23 == 0) {
                    throw new IllegalArgumentException("Failed to find supported resolutions.");
                }
                ArrayList arrayList30 = new ArrayList();
                for (int i30 = 0; i30 < size23; i30++) {
                    arrayList30.add(new ArrayList());
                }
                int size24 = size23 / ((List) arrayList26.get(0)).size();
                int i31 = size23;
                for (int i32 = 0; i32 < arrayList26.size(); i32++) {
                    List list7 = (List) arrayList26.get(i32);
                    int i33 = 0;
                    while (i33 < size23) {
                        int i34 = size24;
                        ((List) arrayList30.get(i33)).add((Size) list7.get((i33 % i31) / i34));
                        i33++;
                        size24 = i34;
                    }
                    int i35 = size24;
                    if (i32 < arrayList26.size() - 1) {
                        size24 = i35 / ((List) arrayList26.get(i32 + 1)).size();
                        i31 = i35;
                    } else {
                        size24 = i35;
                    }
                }
                HashMap map19 = new HashMap();
                HashMap map20 = new HashMap();
                HashMap map21 = new HashMap();
                ArrayList arrayList31 = arrayList24;
                HashMap map22 = new HashMap();
                AutoValue_Config_Option autoValue_Config_Option2 = StreamUseCaseUtil.STREAM_USE_CASE_STREAM_SPEC_OPTION;
                int size25 = arrayList2.size();
                int i36 = 0;
                while (true) {
                    if (i36 >= size25) {
                        int size26 = arrayList23.size();
                        int i37 = 0;
                        while (true) {
                            if (i37 >= size26) {
                                z4 = false;
                                break;
                            }
                            Object obj12 = arrayList23.get(i37);
                            i37++;
                            UseCaseConfig useCaseConfig9 = (UseCaseConfig) obj12;
                            if (StreamUseCaseUtil.isZslUseCase(useCaseConfig9, useCaseConfig9.getCaptureType())) {
                            }
                        }
                    } else {
                        Object obj13 = arrayList2.get(i36);
                        i36++;
                        AutoValue_AttachedSurfaceInfo autoValue_AttachedSurfaceInfo3 = (AutoValue_AttachedSurfaceInfo) obj13;
                        int i38 = size25;
                        if (!StreamUseCaseUtil.isZslUseCase(autoValue_AttachedSurfaceInfo3.implementationOptions, (UseCaseConfigFactory.CaptureType) autoValue_AttachedSurfaceInfo3.captureTypes.get(0))) {
                            size25 = i38;
                        }
                    }
                    z4 = true;
                    break;
                }
                int size27 = arrayList2.size();
                int i39 = 0;
                int iMin = Integer.MAX_VALUE;
                while (i39 < size27) {
                    Object obj14 = arrayList2.get(i39);
                    i39++;
                    ArrayList arrayList32 = arrayList23;
                    AutoValue_AttachedSurfaceInfo autoValue_AttachedSurfaceInfo4 = (AutoValue_AttachedSurfaceInfo) obj14;
                    boolean z11 = z4;
                    int i40 = size27;
                    try {
                        outputMinFrameDuration = (int) (1.0E9d / ((StreamConfigurationMap) supportedSurfaceCombination2.mCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputMinFrameDuration(autoValue_AttachedSurfaceInfo4.imageFormat, autoValue_AttachedSurfaceInfo4.size));
                    } catch (Exception unused5) {
                        outputMinFrameDuration = 0;
                    }
                    iMin = Math.min(iMin, outputMinFrameDuration);
                    arrayList2 = arrayList;
                    z4 = z11;
                    size27 = i40;
                    arrayList23 = arrayList32;
                }
                ArrayList arrayList33 = arrayList23;
                boolean z12 = z4;
                String str13 = "SurfaceConfig does not map to any use case";
                if (!supportedSurfaceCombination2.mIsStreamUseCaseSupported || z12) {
                    supportedSurfaceCombination = supportedSurfaceCombination2;
                    map2 = map21;
                    map3 = map22;
                    map4 = map19;
                    map5 = map20;
                    i3 = iMin;
                    str = str12;
                    arrayList3 = arrayList33;
                    range = range10;
                    str2 = str10;
                    arrayList4 = arrayList31;
                    arrayList5 = arrayList30;
                    dynamicRange = dynamicRange7;
                    str3 = "SurfaceConfig does not map to any use case";
                    arrayList6 = arrayList;
                    list = null;
                } else {
                    int size28 = arrayList30.size();
                    List list8 = null;
                    int i41 = 0;
                    loop25: while (true) {
                        if (i41 >= size28) {
                            supportedSurfaceCombination = supportedSurfaceCombination2;
                            map2 = map21;
                            map3 = map22;
                            map4 = map19;
                            map5 = map20;
                            i3 = iMin;
                            str = str12;
                            arrayList3 = arrayList33;
                            range = range10;
                            str2 = str10;
                            arrayList4 = arrayList31;
                            arrayList5 = arrayList30;
                            dynamicRange = dynamicRange7;
                            str3 = str13;
                            arrayList6 = arrayList;
                            break;
                        }
                        int i42 = i41 + 1;
                        int i43 = size28;
                        supportedSurfaceCombination = supportedSurfaceCombination2;
                        map4 = map19;
                        map5 = map20;
                        int i44 = iMin;
                        str = str12;
                        ArrayList arrayList34 = arrayList33;
                        Range range11 = range10;
                        str2 = str10;
                        dynamicRange = dynamicRange7;
                        str3 = str13;
                        arrayList6 = arrayList;
                        Pair surfaceConfigListAndFpsCeiling = supportedSurfaceCombination.getSurfaceConfigListAndFpsCeiling(i, arrayList6, (List) arrayList30.get(i41), arrayList34, arrayList31, i44, map21, map22);
                        map2 = map21;
                        map3 = map22;
                        arrayList3 = arrayList34;
                        List orderedSupportedStreamUseCaseSurfaceConfigList = supportedSurfaceCombination.getOrderedSupportedStreamUseCaseSurfaceConfigList(autoValue_SupportedSurfaceCombination_FeatureSettings, (List) surfaceConfigListAndFpsCeiling.first);
                        if (orderedSupportedStreamUseCaseSurfaceConfigList != null) {
                            UseCaseConfigFactory.CaptureType captureType = UseCaseConfigFactory.CaptureType.STREAM_SHARING;
                            arrayList4 = arrayList31;
                            i3 = i44;
                            int i45 = 0;
                            while (true) {
                                if (i45 < orderedSupportedStreamUseCaseSurfaceConfigList.size()) {
                                    arrayList5 = arrayList30;
                                    long j2 = ((AutoValue_SurfaceConfig) orderedSupportedStreamUseCaseSurfaceConfigList.get(i45)).streamUseCase;
                                    List list9 = orderedSupportedStreamUseCaseSurfaceConfigList;
                                    if (map2.containsKey(Integer.valueOf(i45))) {
                                        List list10 = ((AutoValue_AttachedSurfaceInfo) map2.get(Integer.valueOf(i45))).captureTypes;
                                        i12 = i45;
                                        range = range11;
                                        if (StreamUseCaseUtil.isEligibleCaptureType(list10.size() == 1 ? (UseCaseConfigFactory.CaptureType) list10.get(0) : captureType, j2, list10)) {
                                            i45 = i12 + 1;
                                            arrayList30 = arrayList5;
                                            orderedSupportedStreamUseCaseSurfaceConfigList = list9;
                                            range11 = range;
                                        } else {
                                            list8 = null;
                                        }
                                    } else {
                                        i12 = i45;
                                        range = range11;
                                        if (!map3.containsKey(Integer.valueOf(i12))) {
                                            throw new AssertionError(str3);
                                        }
                                        UseCaseConfig useCaseConfig10 = (UseCaseConfig) map3.get(Integer.valueOf(i12));
                                        if (StreamUseCaseUtil.isEligibleCaptureType(useCaseConfig10.getCaptureType(), j2, useCaseConfig10.getCaptureType() == captureType ? (List) ((OptionsBundle) ((StreamSharingConfig) useCaseConfig10).getConfig()).retrieveOption(StreamSharingConfig.OPTION_CAPTURE_TYPES) : Collections.EMPTY_LIST)) {
                                            i45 = i12 + 1;
                                            arrayList30 = arrayList5;
                                            orderedSupportedStreamUseCaseSurfaceConfigList = list9;
                                            range11 = range;
                                        } else {
                                            list8 = null;
                                        }
                                    }
                                }
                                if (list8 != null) {
                                    CameraCharacteristicsCompat cameraCharacteristicsCompat2 = supportedSurfaceCombination.mCharacteristics;
                                    if (Build.VERSION.SDK_INT >= 33 && (jArr = (long[]) cameraCharacteristicsCompat2.get(CameraCharacteristics.SCALER_AVAILABLE_STREAM_USE_CASES)) != null && jArr.length != 0) {
                                        hashSet = new HashSet();
                                        for (long j3 : jArr) {
                                            hashSet.add(Long.valueOf(j3));
                                        }
                                        it2 = list8.iterator();
                                        do {
                                            if (it2.hasNext()) {
                                                break loop25;
                                            }
                                        } while (hashSet.contains(Long.valueOf(((AutoValue_SurfaceConfig) it2.next()).streamUseCase)));
                                    }
                                    list8 = null;
                                }
                                map2.clear();
                                map3.clear();
                                map22 = map3;
                                str12 = str;
                                str13 = str3;
                                i41 = i42;
                                map20 = map5;
                                iMin = i3;
                                arrayList31 = arrayList4;
                                arrayList30 = arrayList5;
                                range10 = range;
                                dynamicRange7 = dynamicRange;
                                arrayList33 = arrayList3;
                                map21 = map2;
                                str10 = str2;
                                map19 = map4;
                                supportedSurfaceCombination2 = supportedSurfaceCombination;
                                size28 = i43;
                            }
                        } else {
                            arrayList4 = arrayList31;
                            i3 = i44;
                        }
                        arrayList5 = arrayList30;
                        range = range11;
                        list8 = orderedSupportedStreamUseCaseSurfaceConfigList;
                        if (list8 != null) {
                            CameraCharacteristicsCompat cameraCharacteristicsCompat3 = supportedSurfaceCombination.mCharacteristics;
                            if (Build.VERSION.SDK_INT >= 33) {
                                hashSet = new HashSet();
                                while (i11 < r8) {
                                    hashSet.add(Long.valueOf(j3));
                                }
                                it2 = list8.iterator();
                                do {
                                    if (it2.hasNext()) {
                                        break loop25;
                                        break loop25;
                                    }
                                } while (hashSet.contains(Long.valueOf(((AutoValue_SurfaceConfig) it2.next()).streamUseCase)));
                            }
                            list8 = null;
                        }
                        map2.clear();
                        map3.clear();
                        map22 = map3;
                        str12 = str;
                        str13 = str3;
                        i41 = i42;
                        map20 = map5;
                        iMin = i3;
                        arrayList31 = arrayList4;
                        arrayList30 = arrayList5;
                        range10 = range;
                        dynamicRange7 = dynamicRange;
                        arrayList33 = arrayList3;
                        map21 = map2;
                        str10 = str2;
                        map19 = map4;
                        supportedSurfaceCombination2 = supportedSurfaceCombination;
                        size28 = i43;
                    }
                    if (list8 == null && !z10) {
                        throw new IllegalArgumentException(str + supportedSurfaceCombination.mCameraId + ".  May be attempting to bind too many use cases. Existing surfaces: " + arrayList6 + str2 + arrayList3);
                    }
                    list = list8;
                }
                int size29 = arrayList5.size();
                List list11 = null;
                List list12 = null;
                int i46 = 0;
                int i47 = Integer.MAX_VALUE;
                int i48 = Integer.MAX_VALUE;
                boolean z13 = false;
                boolean z14 = false;
                while (true) {
                    if (i46 >= size29) {
                        i4 = i47;
                        i5 = i48;
                        str4 = str;
                        arrayList7 = arrayList4;
                        arrayList8 = arrayList3;
                        map6 = map3;
                        str5 = str2;
                        map7 = map2;
                        list2 = list11;
                        list3 = list12;
                        break;
                    }
                    ArrayList arrayList35 = arrayList5;
                    int i49 = i46 + 1;
                    List list13 = (List) arrayList35.get(i46);
                    boolean z15 = z13;
                    i5 = i48;
                    arrayList7 = arrayList4;
                    str5 = str2;
                    map7 = map2;
                    int i50 = i3;
                    boolean z16 = z15;
                    str4 = str;
                    map6 = map3;
                    arrayList5 = arrayList35;
                    int i51 = size29;
                    i4 = i47;
                    arrayList8 = arrayList3;
                    Pair surfaceConfigListAndFpsCeiling2 = supportedSurfaceCombination.getSurfaceConfigListAndFpsCeiling(i, arrayList6, list13, arrayList8, arrayList7, i50, null, null);
                    List list14 = (List) surfaceConfigListAndFpsCeiling2.first;
                    int iIntValue2 = ((Integer) surfaceConfigListAndFpsCeiling2.second).intValue();
                    boolean z17 = range == null || i50 <= iIntValue2 || iIntValue2 >= ((Integer) range.getLower()).intValue();
                    if (z16 || !supportedSurfaceCombination.checkSupported(autoValue_SupportedSurfaceCombination_FeatureSettings, list14)) {
                        list4 = list13;
                    } else {
                        list4 = list13;
                        if (i4 == Integer.MAX_VALUE || i4 < iIntValue2) {
                            i4 = iIntValue2;
                            list11 = list4;
                        }
                        if (z17) {
                            i4 = iIntValue2;
                            if (z14) {
                                list3 = list12;
                                list2 = list4;
                                break;
                            }
                            list11 = list4;
                            z16 = true;
                        }
                    }
                    if (list != null && !z14 && supportedSurfaceCombination.getOrderedSupportedStreamUseCaseSurfaceConfigList(autoValue_SupportedSurfaceCombination_FeatureSettings, list14) != null) {
                        if (i5 == Integer.MAX_VALUE || i5 < iIntValue2) {
                            i5 = iIntValue2;
                            list12 = list4;
                        }
                        if (z17) {
                            i5 = iIntValue2;
                            if (z16) {
                                list2 = list11;
                                list3 = list4;
                                break;
                            }
                            list12 = list4;
                            z14 = true;
                        } else {
                            continue;
                        }
                    }
                    arrayList4 = arrayList7;
                    i48 = i5;
                    z13 = z16;
                    i3 = i50;
                    map2 = map7;
                    str2 = str5;
                    arrayList3 = arrayList8;
                    map3 = map6;
                    i47 = i4;
                    i46 = i49;
                    str = str4;
                    size29 = i51;
                }
                if (list2 == null) {
                    throw new IllegalArgumentException(str4 + supportedSurfaceCombination.mCameraId + " and Hardware level: " + supportedSurfaceCombination.mHardwareLevel + ". May be the specified resolution is too large and not supported. Existing surfaces: " + arrayList6 + str5 + arrayList8);
                }
                if (range != null) {
                    Range range12 = AutoValue_StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
                    Range range13 = range;
                    if (range13.equals(range12) || (rangeArr = (Range[]) supportedSurfaceCombination.mCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES)) == null) {
                        range7 = range12;
                    } else {
                        Range range14 = new Range(Integer.valueOf(Math.min(((Integer) range13.getLower()).intValue(), i4)), Integer.valueOf(Math.min(((Integer) range13.getUpper()).intValue(), i4)));
                        int length = rangeArr.length;
                        Range range15 = range12;
                        int i52 = 0;
                        int rangeLength = 0;
                        while (i52 < length) {
                            int i53 = length;
                            Range range16 = rangeArr[i52];
                            int i54 = i52;
                            if (i4 >= ((Integer) range16.getLower()).intValue()) {
                                if (range15.equals(AutoValue_StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED)) {
                                    range15 = range16;
                                }
                                if (range16.equals(range14)) {
                                    range15 = range16;
                                    break;
                                }
                                try {
                                    int rangeLength2 = getRangeLength(range16.intersect(range14));
                                    if (rangeLength == 0) {
                                        rangeLength = rangeLength2;
                                    } else if (rangeLength2 >= rangeLength) {
                                        try {
                                            range6 = range15;
                                            double rangeLength3 = getRangeLength(range15.intersect(range14));
                                            try {
                                                double rangeLength4 = getRangeLength(range16.intersect(range14));
                                                double rangeLength5 = rangeLength4 / ((double) getRangeLength(range16));
                                                double rangeLength6 = rangeLength3 / ((double) getRangeLength(range6));
                                                if (rangeLength4 > rangeLength3) {
                                                    if (rangeLength5 >= 0.5d || rangeLength5 >= rangeLength6) {
                                                        range15 = range16;
                                                    } else {
                                                        range15 = range6;
                                                    }
                                                } else if (rangeLength4 == rangeLength3) {
                                                    if (rangeLength5 <= rangeLength6 && (rangeLength5 != rangeLength6 || ((Integer) range16.getLower()).intValue() <= ((Integer) range6.getLower()).intValue())) {
                                                        range15 = range6;
                                                    } else {
                                                        range15 = range16;
                                                    }
                                                } else if (rangeLength6 >= 0.5d || rangeLength5 <= rangeLength6) {
                                                    range15 = range6;
                                                } else {
                                                    range15 = range16;
                                                }
                                                try {
                                                    rangeLength = getRangeLength(range14.intersect(range15));
                                                    range16 = range15;
                                                } catch (IllegalArgumentException unused6) {
                                                    if (rangeLength == 0) {
                                                        i10 = rangeLength;
                                                        if (getRangeDistance(range16, range14) >= getRangeDistance(range15, range14) || (getRangeDistance(range16, range14) == getRangeDistance(range15, range14) && (((Integer) range16.getLower()).intValue() > ((Integer) range15.getUpper()).intValue() || getRangeLength(range16) < getRangeLength(range15)))) {
                                                            range15 = range16;
                                                        }
                                                    } else {
                                                        i10 = rangeLength;
                                                    }
                                                    rangeLength = i10;
                                                }
                                            } catch (IllegalArgumentException unused7) {
                                                range15 = range6;
                                                if (rangeLength == 0) {
                                                    i10 = rangeLength;
                                                    if (getRangeDistance(range16, range14) >= getRangeDistance(range15, range14)) {
                                                        range15 = range16;
                                                    } else {
                                                        range15 = range16;
                                                    }
                                                } else {
                                                    i10 = rangeLength;
                                                }
                                                rangeLength = i10;
                                                i52 = i54 + 1;
                                                length = i53;
                                            }
                                        } catch (IllegalArgumentException unused8) {
                                            range6 = range15;
                                        }
                                    } else {
                                        range16 = range15;
                                    }
                                    range15 = range16;
                                } catch (IllegalArgumentException unused9) {
                                }
                            }
                            i52 = i54 + 1;
                            length = i53;
                        }
                        range7 = range15;
                    }
                }
                Range range17 = range7;
                int size30 = arrayList8.size();
                int i55 = 0;
                while (i55 < size30) {
                    Object obj15 = arrayList8.get(i55);
                    int i56 = i55 + 1;
                    int i57 = size30;
                    UseCaseConfig useCaseConfig11 = (UseCaseConfig) obj15;
                    Size size31 = (Size) list2.get(arrayList7.indexOf(Integer.valueOf(arrayList8.indexOf(useCaseConfig11))));
                    Range range18 = AutoValue_StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
                    ArrayList arrayList36 = arrayList7;
                    ArrayList arrayList37 = arrayList8;
                    HashMap map23 = map6;
                    Request request3 = new Request(2, false);
                    if (size31 == null) {
                        throw new NullPointerException("Null resolution");
                    }
                    request3.url = size31;
                    Range range19 = AutoValue_StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
                    if (range19 == null) {
                        throw new NullPointerException("Null expectedFrameRateRange");
                    }
                    request3.headers = range19;
                    DynamicRange dynamicRange8 = dynamicRange;
                    request3.method = dynamicRange8;
                    request3.lazyCacheControl = Boolean.FALSE;
                    HashMap map24 = map17;
                    DynamicRange dynamicRange9 = (DynamicRange) map24.get(useCaseConfig11);
                    dynamicRange9.getClass();
                    request3.method = dynamicRange9;
                    MutableOptionsBundle mutableOptionsBundleCreate = MutableOptionsBundle.create();
                    AutoValue_Config_Option autoValue_Config_Option3 = Camera2ImplConfig.STREAM_USE_CASE_OPTION;
                    if (useCaseConfig11.containsOption(autoValue_Config_Option3)) {
                        mutableOptionsBundleCreate.insertOption(autoValue_Config_Option3, (Long) useCaseConfig11.retrieveOption(autoValue_Config_Option3));
                    }
                    AutoValue_Config_Option autoValue_Config_Option4 = UseCaseConfig.OPTION_ZSL_DISABLED;
                    if (useCaseConfig11.containsOption(autoValue_Config_Option4)) {
                        mutableOptionsBundleCreate.insertOption(autoValue_Config_Option4, (Boolean) useCaseConfig11.retrieveOption(autoValue_Config_Option4));
                    }
                    AutoValue_Config_Option autoValue_Config_Option5 = ImageCaptureConfig.OPTION_IMAGE_CAPTURE_MODE;
                    if (useCaseConfig11.containsOption(autoValue_Config_Option5)) {
                        mutableOptionsBundleCreate.insertOption(autoValue_Config_Option5, (Integer) useCaseConfig11.retrieveOption(autoValue_Config_Option5));
                    }
                    AutoValue_Config_Option autoValue_Config_Option6 = ImageInputConfig.OPTION_INPUT_FORMAT;
                    if (useCaseConfig11.containsOption(autoValue_Config_Option6)) {
                        mutableOptionsBundleCreate.insertOption(autoValue_Config_Option6, (Integer) useCaseConfig11.retrieveOption(autoValue_Config_Option6));
                    }
                    request3.tags = new Camera2ImplConfig(14, mutableOptionsBundleCreate);
                    request3.lazyCacheControl = Boolean.valueOf(z2);
                    if (range17 != null) {
                        request3.headers = range17;
                    }
                    map5.put(useCaseConfig11, request3.m850build());
                    size30 = i57;
                    dynamicRange = dynamicRange8;
                    map17 = map24;
                    arrayList7 = arrayList36;
                    i55 = i56;
                    arrayList8 = arrayList37;
                    map6 = map23;
                }
                DynamicRange dynamicRange10 = dynamicRange;
                HashMap map25 = map6;
                HashMap map26 = map5;
                if (list == null || i4 != i5 || list2.size() != list3.size()) {
                    map8 = map4;
                    break;
                }
                int i58 = 0;
                while (true) {
                    if (i58 >= list2.size()) {
                        CameraCharacteristicsCompat cameraCharacteristicsCompat4 = supportedSurfaceCombination.mCharacteristics;
                        if (Build.VERSION.SDK_INT >= 33) {
                            ArrayList arrayList38 = new ArrayList(map26.keySet());
                            int size32 = arrayList6.size();
                            int i59 = 0;
                            while (i59 < size32) {
                                Object obj16 = arrayList6.get(i59);
                                i59++;
                                ((AutoValue_AttachedSurfaceInfo) obj16).implementationOptions.getClass();
                            }
                            int size33 = arrayList38.size();
                            int i60 = 0;
                            while (i60 < size33) {
                                Object obj17 = arrayList38.get(i60);
                                i60++;
                                AutoValue_StreamSpec autoValue_StreamSpec3 = (AutoValue_StreamSpec) map26.get((UseCaseConfig) obj17);
                                autoValue_StreamSpec3.getClass();
                                autoValue_StreamSpec3.implementationOptions.getClass();
                            }
                            long[] jArr2 = (long[]) cameraCharacteristicsCompat4.get(CameraCharacteristics.SCALER_AVAILABLE_STREAM_USE_CASES);
                            if (jArr2 != null && jArr2.length != 0) {
                                HashSet hashSet4 = new HashSet();
                                for (long j4 : jArr2) {
                                    hashSet4.add(Long.valueOf(j4));
                                }
                                HashSet hashSet5 = new HashSet();
                                Iterator it9 = arrayList6.iterator();
                                if (it9.hasNext()) {
                                    AutoValue_AttachedSurfaceInfo autoValue_AttachedSurfaceInfo5 = (AutoValue_AttachedSurfaceInfo) it9.next();
                                    Config config = autoValue_AttachedSurfaceInfo5.implementationOptions;
                                    AutoValue_Config_Option autoValue_Config_Option7 = Camera2ImplConfig.STREAM_USE_CASE_OPTION;
                                    if (config.containsOption(autoValue_Config_Option7) && ((Long) autoValue_AttachedSurfaceInfo5.implementationOptions.retrieveOption(autoValue_Config_Option7)).longValue() != 0) {
                                        z5 = true;
                                    } else {
                                        z5 = false;
                                        z6 = true;
                                    }
                                    size = arrayList38.size();
                                    i6 = 0;
                                    while (i6 < size) {
                                        Object obj18 = arrayList38.get(i6);
                                        i6++;
                                        z7 = z5;
                                        useCaseConfig2 = (UseCaseConfig) obj18;
                                        z8 = z6;
                                        autoValue_Config_Option = Camera2ImplConfig.STREAM_USE_CASE_OPTION;
                                        int i61 = size;
                                        if (!useCaseConfig2.containsOption(autoValue_Config_Option)) {
                                            l = (Long) useCaseConfig2.retrieveOption(autoValue_Config_Option);
                                            if (l.longValue() == 0) {
                                                if (!z8) {
                                                    throw new IllegalArgumentException("Either all use cases must have non-default stream use case assigned or none should have it");
                                                }
                                                hashSet5.add(l);
                                                z6 = z8;
                                                z5 = true;
                                            } else if (z7) {
                                                throw new IllegalArgumentException("Either all use cases must have non-default stream use case assigned or none should have it");
                                            }
                                            size = i61;
                                        } else if (z7) {
                                            throw new IllegalArgumentException("Either all use cases must have non-default stream use case assigned or none should have it");
                                        }
                                        z5 = z7;
                                        z6 = true;
                                        size = i61;
                                    }
                                    if (z6) {
                                        it = hashSet5.iterator();
                                        do {
                                            if (it.hasNext()) {
                                                size2 = arrayList6.size();
                                                i7 = 0;
                                                while (i7 < size2) {
                                                    Object obj19 = arrayList6.get(i7);
                                                    i7++;
                                                    autoValue_AttachedSurfaceInfo = (AutoValue_AttachedSurfaceInfo) obj19;
                                                    Config config2 = autoValue_AttachedSurfaceInfo.implementationOptions;
                                                    updatedImplementationOptionsWithUseCaseStreamSpecOption2 = StreamUseCaseUtil.getUpdatedImplementationOptionsWithUseCaseStreamSpecOption(config2, ((Long) config2.retrieveOption(Camera2ImplConfig.STREAM_USE_CASE_OPTION)).longValue());
                                                    if (updatedImplementationOptionsWithUseCaseStreamSpecOption2 != null) {
                                                        size4 = autoValue_AttachedSurfaceInfo.size;
                                                        Range range20 = AutoValue_StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
                                                        request = new Request(2, false);
                                                        if (size4 != null) {
                                                            throw new NullPointerException("Null resolution");
                                                        }
                                                        request.url = size4;
                                                        range2 = AutoValue_StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
                                                        if (range2 != null) {
                                                            throw new NullPointerException("Null expectedFrameRateRange");
                                                        }
                                                        request.headers = range2;
                                                        request.method = dynamicRange10;
                                                        request.lazyCacheControl = Boolean.FALSE;
                                                        dynamicRange2 = autoValue_AttachedSurfaceInfo.dynamicRange;
                                                        if (dynamicRange2 != null) {
                                                            throw new NullPointerException("Null dynamicRange");
                                                        }
                                                        request.method = dynamicRange2;
                                                        request.tags = updatedImplementationOptionsWithUseCaseStreamSpecOption2;
                                                        range3 = autoValue_AttachedSurfaceInfo.targetFrameRate;
                                                        if (range3 != null) {
                                                            request.headers = range3;
                                                        }
                                                        map9 = map4;
                                                        map9.put(autoValue_AttachedSurfaceInfo, request.m850build());
                                                    } else {
                                                        map9 = map4;
                                                    }
                                                    map4 = map9;
                                                }
                                                map8 = map4;
                                                size3 = arrayList38.size();
                                                i8 = 0;
                                                while (i8 < size3) {
                                                    Object obj20 = arrayList38.get(i8);
                                                    i8++;
                                                    useCaseConfig = (UseCaseConfig) obj20;
                                                    autoValue_StreamSpec = (AutoValue_StreamSpec) map26.get(useCaseConfig);
                                                    Config config3 = autoValue_StreamSpec.implementationOptions;
                                                    updatedImplementationOptionsWithUseCaseStreamSpecOption = StreamUseCaseUtil.getUpdatedImplementationOptionsWithUseCaseStreamSpecOption(config3, ((Long) config3.retrieveOption(Camera2ImplConfig.STREAM_USE_CASE_OPTION)).longValue());
                                                    if (updatedImplementationOptionsWithUseCaseStreamSpecOption != null) {
                                                        Request builder = autoValue_StreamSpec.toBuilder();
                                                        builder.tags = updatedImplementationOptionsWithUseCaseStreamSpecOption;
                                                        map26.put(useCaseConfig, builder.m850build());
                                                    }
                                                }
                                                break;
                                            }
                                        } while (hashSet4.contains((Long) it.next()));
                                        map8 = map4;
                                        i9 = 0;
                                        while (i9 < list.size()) {
                                            j = ((AutoValue_SurfaceConfig) list.get(i9)).streamUseCase;
                                            if (map7.containsKey(Integer.valueOf(i9))) {
                                                autoValue_AttachedSurfaceInfo2 = (AutoValue_AttachedSurfaceInfo) map7.get(Integer.valueOf(i9));
                                                updatedImplementationOptionsWithUseCaseStreamSpecOption4 = StreamUseCaseUtil.getUpdatedImplementationOptionsWithUseCaseStreamSpecOption(autoValue_AttachedSurfaceInfo2.implementationOptions, j);
                                                if (updatedImplementationOptionsWithUseCaseStreamSpecOption4 != null) {
                                                    size5 = autoValue_AttachedSurfaceInfo2.size;
                                                    Range range21 = AutoValue_StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
                                                    request2 = new Request(2, false);
                                                    if (size5 != null) {
                                                        throw new NullPointerException("Null resolution");
                                                    }
                                                    request2.url = size5;
                                                    range4 = AutoValue_StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
                                                    if (range4 != null) {
                                                        throw new NullPointerException("Null expectedFrameRateRange");
                                                    }
                                                    request2.headers = range4;
                                                    request2.method = dynamicRange10;
                                                    request2.lazyCacheControl = Boolean.FALSE;
                                                    dynamicRange3 = autoValue_AttachedSurfaceInfo2.dynamicRange;
                                                    if (dynamicRange3 != null) {
                                                        throw new NullPointerException("Null dynamicRange");
                                                    }
                                                    request2.method = dynamicRange3;
                                                    request2.tags = updatedImplementationOptionsWithUseCaseStreamSpecOption4;
                                                    range5 = autoValue_AttachedSurfaceInfo2.targetFrameRate;
                                                    if (range5 != null) {
                                                        request2.headers = range5;
                                                    }
                                                    map8.put(autoValue_AttachedSurfaceInfo2, request2.m850build());
                                                }
                                                map10 = map25;
                                            } else {
                                                map10 = map25;
                                                if (map10.containsKey(Integer.valueOf(i9))) {
                                                    throw new AssertionError(str3);
                                                }
                                                useCaseConfig3 = (UseCaseConfig) map10.get(Integer.valueOf(i9));
                                                autoValue_StreamSpec2 = (AutoValue_StreamSpec) map26.get(useCaseConfig3);
                                                updatedImplementationOptionsWithUseCaseStreamSpecOption3 = StreamUseCaseUtil.getUpdatedImplementationOptionsWithUseCaseStreamSpecOption(autoValue_StreamSpec2.implementationOptions, j);
                                                if (updatedImplementationOptionsWithUseCaseStreamSpecOption3 != null) {
                                                    Request builder2 = autoValue_StreamSpec2.toBuilder();
                                                    builder2.tags = updatedImplementationOptionsWithUseCaseStreamSpecOption3;
                                                    map26.put(useCaseConfig3, builder2.m850build());
                                                }
                                            }
                                            i9++;
                                            map25 = map10;
                                        }
                                        break;
                                        break;
                                    }
                                    map8 = map4;
                                    i9 = 0;
                                    while (i9 < list.size()) {
                                        j = ((AutoValue_SurfaceConfig) list.get(i9)).streamUseCase;
                                        if (map7.containsKey(Integer.valueOf(i9))) {
                                            autoValue_AttachedSurfaceInfo2 = (AutoValue_AttachedSurfaceInfo) map7.get(Integer.valueOf(i9));
                                            updatedImplementationOptionsWithUseCaseStreamSpecOption4 = StreamUseCaseUtil.getUpdatedImplementationOptionsWithUseCaseStreamSpecOption(autoValue_AttachedSurfaceInfo2.implementationOptions, j);
                                            if (updatedImplementationOptionsWithUseCaseStreamSpecOption4 != null) {
                                                size5 = autoValue_AttachedSurfaceInfo2.size;
                                                Range range22 = AutoValue_StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
                                                request2 = new Request(2, false);
                                                if (size5 != null) {
                                                    throw new NullPointerException("Null resolution");
                                                }
                                                request2.url = size5;
                                                range4 = AutoValue_StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
                                                if (range4 != null) {
                                                    throw new NullPointerException("Null expectedFrameRateRange");
                                                }
                                                request2.headers = range4;
                                                request2.method = dynamicRange10;
                                                request2.lazyCacheControl = Boolean.FALSE;
                                                dynamicRange3 = autoValue_AttachedSurfaceInfo2.dynamicRange;
                                                if (dynamicRange3 != null) {
                                                    throw new NullPointerException("Null dynamicRange");
                                                }
                                                request2.method = dynamicRange3;
                                                request2.tags = updatedImplementationOptionsWithUseCaseStreamSpecOption4;
                                                range5 = autoValue_AttachedSurfaceInfo2.targetFrameRate;
                                                if (range5 != null) {
                                                    request2.headers = range5;
                                                }
                                                map8.put(autoValue_AttachedSurfaceInfo2, request2.m850build());
                                            }
                                            map10 = map25;
                                        } else {
                                            map10 = map25;
                                            if (map10.containsKey(Integer.valueOf(i9))) {
                                                throw new AssertionError(str3);
                                            }
                                            useCaseConfig3 = (UseCaseConfig) map10.get(Integer.valueOf(i9));
                                            autoValue_StreamSpec2 = (AutoValue_StreamSpec) map26.get(useCaseConfig3);
                                            updatedImplementationOptionsWithUseCaseStreamSpecOption3 = StreamUseCaseUtil.getUpdatedImplementationOptionsWithUseCaseStreamSpecOption(autoValue_StreamSpec2.implementationOptions, j);
                                            if (updatedImplementationOptionsWithUseCaseStreamSpecOption3 != null) {
                                                Request builder3 = autoValue_StreamSpec2.toBuilder();
                                                builder3.tags = updatedImplementationOptionsWithUseCaseStreamSpecOption3;
                                                map26.put(useCaseConfig3, builder3.m850build());
                                            }
                                        }
                                        i9++;
                                        map25 = map10;
                                    }
                                    break;
                                    break;
                                }
                                z5 = false;
                                z6 = false;
                                size = arrayList38.size();
                                i6 = 0;
                                while (i6 < size) {
                                    Object obj110 = arrayList38.get(i6);
                                    i6++;
                                    z7 = z5;
                                    useCaseConfig2 = (UseCaseConfig) obj110;
                                    z8 = z6;
                                    autoValue_Config_Option = Camera2ImplConfig.STREAM_USE_CASE_OPTION;
                                    int i62 = size;
                                    if (!useCaseConfig2.containsOption(autoValue_Config_Option)) {
                                        l = (Long) useCaseConfig2.retrieveOption(autoValue_Config_Option);
                                        if (l.longValue() == 0) {
                                            if (!z8) {
                                                throw new IllegalArgumentException("Either all use cases must have non-default stream use case assigned or none should have it");
                                            }
                                            hashSet5.add(l);
                                            z6 = z8;
                                            z5 = true;
                                        } else if (z7) {
                                            throw new IllegalArgumentException("Either all use cases must have non-default stream use case assigned or none should have it");
                                        }
                                        size = i62;
                                    } else if (z7) {
                                        throw new IllegalArgumentException("Either all use cases must have non-default stream use case assigned or none should have it");
                                    }
                                    z5 = z7;
                                    z6 = true;
                                    size = i62;
                                }
                                if (z6) {
                                    map8 = map4;
                                    i9 = 0;
                                    while (i9 < list.size()) {
                                        j = ((AutoValue_SurfaceConfig) list.get(i9)).streamUseCase;
                                        if (map7.containsKey(Integer.valueOf(i9))) {
                                            autoValue_AttachedSurfaceInfo2 = (AutoValue_AttachedSurfaceInfo) map7.get(Integer.valueOf(i9));
                                            updatedImplementationOptionsWithUseCaseStreamSpecOption4 = StreamUseCaseUtil.getUpdatedImplementationOptionsWithUseCaseStreamSpecOption(autoValue_AttachedSurfaceInfo2.implementationOptions, j);
                                            if (updatedImplementationOptionsWithUseCaseStreamSpecOption4 != null) {
                                                size5 = autoValue_AttachedSurfaceInfo2.size;
                                                Range range23 = AutoValue_StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
                                                request2 = new Request(2, false);
                                                if (size5 != null) {
                                                    throw new NullPointerException("Null resolution");
                                                }
                                                request2.url = size5;
                                                range4 = AutoValue_StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
                                                if (range4 != null) {
                                                    throw new NullPointerException("Null expectedFrameRateRange");
                                                }
                                                request2.headers = range4;
                                                request2.method = dynamicRange10;
                                                request2.lazyCacheControl = Boolean.FALSE;
                                                dynamicRange3 = autoValue_AttachedSurfaceInfo2.dynamicRange;
                                                if (dynamicRange3 != null) {
                                                    throw new NullPointerException("Null dynamicRange");
                                                }
                                                request2.method = dynamicRange3;
                                                request2.tags = updatedImplementationOptionsWithUseCaseStreamSpecOption4;
                                                range5 = autoValue_AttachedSurfaceInfo2.targetFrameRate;
                                                if (range5 != null) {
                                                    request2.headers = range5;
                                                }
                                                map8.put(autoValue_AttachedSurfaceInfo2, request2.m850build());
                                            }
                                            map10 = map25;
                                        } else {
                                            map10 = map25;
                                            if (map10.containsKey(Integer.valueOf(i9))) {
                                                throw new AssertionError(str3);
                                            }
                                            useCaseConfig3 = (UseCaseConfig) map10.get(Integer.valueOf(i9));
                                            autoValue_StreamSpec2 = (AutoValue_StreamSpec) map26.get(useCaseConfig3);
                                            updatedImplementationOptionsWithUseCaseStreamSpecOption3 = StreamUseCaseUtil.getUpdatedImplementationOptionsWithUseCaseStreamSpecOption(autoValue_StreamSpec2.implementationOptions, j);
                                            if (updatedImplementationOptionsWithUseCaseStreamSpecOption3 != null) {
                                                Request builder4 = autoValue_StreamSpec2.toBuilder();
                                                builder4.tags = updatedImplementationOptionsWithUseCaseStreamSpecOption3;
                                                map26.put(useCaseConfig3, builder4.m850build());
                                            }
                                        }
                                        i9++;
                                        map25 = map10;
                                    }
                                    break;
                                    break;
                                }
                                it = hashSet5.iterator();
                                do {
                                    if (it.hasNext()) {
                                        size2 = arrayList6.size();
                                        i7 = 0;
                                        while (i7 < size2) {
                                            Object obj111 = arrayList6.get(i7);
                                            i7++;
                                            autoValue_AttachedSurfaceInfo = (AutoValue_AttachedSurfaceInfo) obj111;
                                            Config config4 = autoValue_AttachedSurfaceInfo.implementationOptions;
                                            updatedImplementationOptionsWithUseCaseStreamSpecOption2 = StreamUseCaseUtil.getUpdatedImplementationOptionsWithUseCaseStreamSpecOption(config4, ((Long) config4.retrieveOption(Camera2ImplConfig.STREAM_USE_CASE_OPTION)).longValue());
                                            if (updatedImplementationOptionsWithUseCaseStreamSpecOption2 != null) {
                                                size4 = autoValue_AttachedSurfaceInfo.size;
                                                Range range24 = AutoValue_StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
                                                request = new Request(2, false);
                                                if (size4 != null) {
                                                    throw new NullPointerException("Null resolution");
                                                }
                                                request.url = size4;
                                                range2 = AutoValue_StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
                                                if (range2 != null) {
                                                    throw new NullPointerException("Null expectedFrameRateRange");
                                                }
                                                request.headers = range2;
                                                request.method = dynamicRange10;
                                                request.lazyCacheControl = Boolean.FALSE;
                                                dynamicRange2 = autoValue_AttachedSurfaceInfo.dynamicRange;
                                                if (dynamicRange2 != null) {
                                                    throw new NullPointerException("Null dynamicRange");
                                                }
                                                request.method = dynamicRange2;
                                                request.tags = updatedImplementationOptionsWithUseCaseStreamSpecOption2;
                                                range3 = autoValue_AttachedSurfaceInfo.targetFrameRate;
                                                if (range3 != null) {
                                                    request.headers = range3;
                                                }
                                                map9 = map4;
                                                map9.put(autoValue_AttachedSurfaceInfo, request.m850build());
                                            } else {
                                                map9 = map4;
                                            }
                                            map4 = map9;
                                        }
                                        map8 = map4;
                                        size3 = arrayList38.size();
                                        i8 = 0;
                                        while (i8 < size3) {
                                            Object obj21 = arrayList38.get(i8);
                                            i8++;
                                            useCaseConfig = (UseCaseConfig) obj21;
                                            autoValue_StreamSpec = (AutoValue_StreamSpec) map26.get(useCaseConfig);
                                            Config config5 = autoValue_StreamSpec.implementationOptions;
                                            updatedImplementationOptionsWithUseCaseStreamSpecOption = StreamUseCaseUtil.getUpdatedImplementationOptionsWithUseCaseStreamSpecOption(config5, ((Long) config5.retrieveOption(Camera2ImplConfig.STREAM_USE_CASE_OPTION)).longValue());
                                            if (updatedImplementationOptionsWithUseCaseStreamSpecOption != null) {
                                                Request builder5 = autoValue_StreamSpec.toBuilder();
                                                builder5.tags = updatedImplementationOptionsWithUseCaseStreamSpecOption;
                                                map26.put(useCaseConfig, builder5.m850build());
                                            }
                                        }
                                        break;
                                        break;
                                    }
                                } while (hashSet4.contains((Long) it.next()));
                                map8 = map4;
                                i9 = 0;
                                while (i9 < list.size()) {
                                    j = ((AutoValue_SurfaceConfig) list.get(i9)).streamUseCase;
                                    if (map7.containsKey(Integer.valueOf(i9))) {
                                        autoValue_AttachedSurfaceInfo2 = (AutoValue_AttachedSurfaceInfo) map7.get(Integer.valueOf(i9));
                                        updatedImplementationOptionsWithUseCaseStreamSpecOption4 = StreamUseCaseUtil.getUpdatedImplementationOptionsWithUseCaseStreamSpecOption(autoValue_AttachedSurfaceInfo2.implementationOptions, j);
                                        if (updatedImplementationOptionsWithUseCaseStreamSpecOption4 != null) {
                                            size5 = autoValue_AttachedSurfaceInfo2.size;
                                            Range range25 = AutoValue_StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
                                            request2 = new Request(2, false);
                                            if (size5 != null) {
                                                throw new NullPointerException("Null resolution");
                                            }
                                            request2.url = size5;
                                            range4 = AutoValue_StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
                                            if (range4 != null) {
                                                throw new NullPointerException("Null expectedFrameRateRange");
                                            }
                                            request2.headers = range4;
                                            request2.method = dynamicRange10;
                                            request2.lazyCacheControl = Boolean.FALSE;
                                            dynamicRange3 = autoValue_AttachedSurfaceInfo2.dynamicRange;
                                            if (dynamicRange3 != null) {
                                                throw new NullPointerException("Null dynamicRange");
                                            }
                                            request2.method = dynamicRange3;
                                            request2.tags = updatedImplementationOptionsWithUseCaseStreamSpecOption4;
                                            range5 = autoValue_AttachedSurfaceInfo2.targetFrameRate;
                                            if (range5 != null) {
                                                request2.headers = range5;
                                            }
                                            map8.put(autoValue_AttachedSurfaceInfo2, request2.m850build());
                                        }
                                        map10 = map25;
                                    } else {
                                        map10 = map25;
                                        if (map10.containsKey(Integer.valueOf(i9))) {
                                            throw new AssertionError(str3);
                                        }
                                        useCaseConfig3 = (UseCaseConfig) map10.get(Integer.valueOf(i9));
                                        autoValue_StreamSpec2 = (AutoValue_StreamSpec) map26.get(useCaseConfig3);
                                        updatedImplementationOptionsWithUseCaseStreamSpecOption3 = StreamUseCaseUtil.getUpdatedImplementationOptionsWithUseCaseStreamSpecOption(autoValue_StreamSpec2.implementationOptions, j);
                                        if (updatedImplementationOptionsWithUseCaseStreamSpecOption3 != null) {
                                            Request builder6 = autoValue_StreamSpec2.toBuilder();
                                            builder6.tags = updatedImplementationOptionsWithUseCaseStreamSpecOption3;
                                            map26.put(useCaseConfig3, builder6.m850build());
                                        }
                                    }
                                    i9++;
                                    map25 = map10;
                                }
                                break;
                                break;
                            }
                            map8 = map4;
                            i9 = 0;
                            while (i9 < list.size()) {
                                j = ((AutoValue_SurfaceConfig) list.get(i9)).streamUseCase;
                                if (map7.containsKey(Integer.valueOf(i9))) {
                                    autoValue_AttachedSurfaceInfo2 = (AutoValue_AttachedSurfaceInfo) map7.get(Integer.valueOf(i9));
                                    updatedImplementationOptionsWithUseCaseStreamSpecOption4 = StreamUseCaseUtil.getUpdatedImplementationOptionsWithUseCaseStreamSpecOption(autoValue_AttachedSurfaceInfo2.implementationOptions, j);
                                    if (updatedImplementationOptionsWithUseCaseStreamSpecOption4 != null) {
                                        size5 = autoValue_AttachedSurfaceInfo2.size;
                                        Range range26 = AutoValue_StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
                                        request2 = new Request(2, false);
                                        if (size5 != null) {
                                            throw new NullPointerException("Null resolution");
                                        }
                                        request2.url = size5;
                                        range4 = AutoValue_StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
                                        if (range4 != null) {
                                            throw new NullPointerException("Null expectedFrameRateRange");
                                        }
                                        request2.headers = range4;
                                        request2.method = dynamicRange10;
                                        request2.lazyCacheControl = Boolean.FALSE;
                                        dynamicRange3 = autoValue_AttachedSurfaceInfo2.dynamicRange;
                                        if (dynamicRange3 != null) {
                                            throw new NullPointerException("Null dynamicRange");
                                        }
                                        request2.method = dynamicRange3;
                                        request2.tags = updatedImplementationOptionsWithUseCaseStreamSpecOption4;
                                        range5 = autoValue_AttachedSurfaceInfo2.targetFrameRate;
                                        if (range5 != null) {
                                            request2.headers = range5;
                                        }
                                        map8.put(autoValue_AttachedSurfaceInfo2, request2.m850build());
                                    }
                                    map10 = map25;
                                } else {
                                    map10 = map25;
                                    if (map10.containsKey(Integer.valueOf(i9))) {
                                        throw new AssertionError(str3);
                                    }
                                    useCaseConfig3 = (UseCaseConfig) map10.get(Integer.valueOf(i9));
                                    autoValue_StreamSpec2 = (AutoValue_StreamSpec) map26.get(useCaseConfig3);
                                    updatedImplementationOptionsWithUseCaseStreamSpecOption3 = StreamUseCaseUtil.getUpdatedImplementationOptionsWithUseCaseStreamSpecOption(autoValue_StreamSpec2.implementationOptions, j);
                                    if (updatedImplementationOptionsWithUseCaseStreamSpecOption3 != null) {
                                        Request builder7 = autoValue_StreamSpec2.toBuilder();
                                        builder7.tags = updatedImplementationOptionsWithUseCaseStreamSpecOption3;
                                        map26.put(useCaseConfig3, builder7.m850build());
                                    }
                                }
                                i9++;
                                map25 = map10;
                            }
                            break;
                            break;
                        }
                        map8 = map4;
                        i9 = 0;
                        while (i9 < list.size()) {
                            j = ((AutoValue_SurfaceConfig) list.get(i9)).streamUseCase;
                            if (map7.containsKey(Integer.valueOf(i9))) {
                                autoValue_AttachedSurfaceInfo2 = (AutoValue_AttachedSurfaceInfo) map7.get(Integer.valueOf(i9));
                                updatedImplementationOptionsWithUseCaseStreamSpecOption4 = StreamUseCaseUtil.getUpdatedImplementationOptionsWithUseCaseStreamSpecOption(autoValue_AttachedSurfaceInfo2.implementationOptions, j);
                                if (updatedImplementationOptionsWithUseCaseStreamSpecOption4 != null) {
                                    size5 = autoValue_AttachedSurfaceInfo2.size;
                                    Range range27 = AutoValue_StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
                                    request2 = new Request(2, false);
                                    if (size5 != null) {
                                        throw new NullPointerException("Null resolution");
                                    }
                                    request2.url = size5;
                                    range4 = AutoValue_StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED;
                                    if (range4 != null) {
                                        throw new NullPointerException("Null expectedFrameRateRange");
                                    }
                                    request2.headers = range4;
                                    request2.method = dynamicRange10;
                                    request2.lazyCacheControl = Boolean.FALSE;
                                    dynamicRange3 = autoValue_AttachedSurfaceInfo2.dynamicRange;
                                    if (dynamicRange3 != null) {
                                        throw new NullPointerException("Null dynamicRange");
                                    }
                                    request2.method = dynamicRange3;
                                    request2.tags = updatedImplementationOptionsWithUseCaseStreamSpecOption4;
                                    range5 = autoValue_AttachedSurfaceInfo2.targetFrameRate;
                                    if (range5 != null) {
                                        request2.headers = range5;
                                    }
                                    map8.put(autoValue_AttachedSurfaceInfo2, request2.m850build());
                                }
                                map10 = map25;
                            } else {
                                map10 = map25;
                                if (map10.containsKey(Integer.valueOf(i9))) {
                                    throw new AssertionError(str3);
                                }
                                useCaseConfig3 = (UseCaseConfig) map10.get(Integer.valueOf(i9));
                                autoValue_StreamSpec2 = (AutoValue_StreamSpec) map26.get(useCaseConfig3);
                                updatedImplementationOptionsWithUseCaseStreamSpecOption3 = StreamUseCaseUtil.getUpdatedImplementationOptionsWithUseCaseStreamSpecOption(autoValue_StreamSpec2.implementationOptions, j);
                                if (updatedImplementationOptionsWithUseCaseStreamSpecOption3 != null) {
                                    Request builder8 = autoValue_StreamSpec2.toBuilder();
                                    builder8.tags = updatedImplementationOptionsWithUseCaseStreamSpecOption3;
                                    map26.put(useCaseConfig3, builder8.m850build());
                                }
                            }
                            i9++;
                            map25 = map10;
                        }
                        break;
                    }
                    if (!((Size) list2.get(i58)).equals(list3.get(i58))) {
                        map8 = map4;
                        break;
                    }
                    i58++;
                }
                return new Pair(map26, map8);
            }
            Object obj22 = arrayList17.get(i23);
            int i63 = i23 + 1;
            UseCaseConfig useCaseConfig12 = (UseCaseConfig) obj22;
            ArrayList arrayList39 = arrayList17;
            DynamicRange dynamicRange11 = useCaseConfig12.getDynamicRange();
            int i64 = size11;
            String targetName = useCaseConfig12.getTargetName();
            if (!dynamicRange11.isFullySpecified()) {
                i13 = i63;
                int i65 = dynamicRange11.mEncoding;
                arrayList9 = arrayList11;
                int i66 = dynamicRange11.mBitDepth;
                arrayList10 = arrayList12;
                if (i65 == 1 && i66 == 0) {
                    if (!hashSet2.contains(dynamicRange5)) {
                        zzrVar = zzrVar2;
                        set = supportedDynamicRanges;
                        dynamicRangeFindSupportedHdrMatch = null;
                        break;
                    }
                    zzrVar = zzrVar2;
                    dynamicRangeFindSupportedHdrMatch = dynamicRange5;
                    set = supportedDynamicRanges;
                } else {
                    dynamicRangeFindSupportedHdrMatch = zzr.findSupportedHdrMatch(dynamicRange11, linkedHashSet, hashSet2);
                    set = supportedDynamicRanges;
                    if (dynamicRangeFindSupportedHdrMatch == null) {
                        dynamicRangeFindSupportedHdrMatch = zzr.findSupportedHdrMatch(dynamicRange11, linkedHashSet2, hashSet2);
                        if (dynamicRangeFindSupportedHdrMatch != null) {
                            Logger.d("DynamicRangeResolver", "Resolved dynamic range for use case " + targetName + " from concurrently bound use case.\n" + dynamicRange11 + "\n->\n" + dynamicRangeFindSupportedHdrMatch);
                        } else if (zzr.canResolveWithinConstraints(dynamicRange11, dynamicRange5, hashSet2)) {
                            Logger.d("DynamicRangeResolver", "Resolved dynamic range for use case " + targetName + " to no compatible HDR dynamic ranges.\n" + dynamicRange11 + "\n->\n" + dynamicRange5);
                            zzrVar = zzrVar2;
                            dynamicRangeFindSupportedHdrMatch = dynamicRange5;
                        } else if (i65 != 2 || (i66 != 10 && i66 != 0)) {
                            zzrVar = zzrVar2;
                            it3 = hashSet2.iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    dynamicRangeFindSupportedHdrMatch = null;
                                    break;
                                }
                                dynamicRangeFindSupportedHdrMatch = (DynamicRange) it3.next();
                                Preconditions.checkState("Candidate dynamic range must be fully specified.", dynamicRangeFindSupportedHdrMatch.isFullySpecified());
                                if (!dynamicRangeFindSupportedHdrMatch.equals(dynamicRange5) && zzr.canResolve(dynamicRange11, dynamicRangeFindSupportedHdrMatch)) {
                                    Logger.d("DynamicRangeResolver", "Resolved dynamic range for use case " + targetName + " from validated dynamic range constraints or supported HDR dynamic ranges.\n" + dynamicRange11 + "\n->\n" + dynamicRangeFindSupportedHdrMatch);
                                    break;
                                }
                            }
                        } else {
                            LinkedHashSet linkedHashSet3 = new LinkedHashSet();
                            if (Build.VERSION.SDK_INT >= 33) {
                                recommended10BitDynamicRange = Api33Impl.getRecommended10BitDynamicRange((CameraCharacteristicsCompat) zzrVar2.zza);
                                if (recommended10BitDynamicRange != null) {
                                    linkedHashSet3.add(recommended10BitDynamicRange);
                                }
                            } else {
                                recommended10BitDynamicRange = null;
                            }
                            linkedHashSet3.add(DynamicRange.HLG_10_BIT);
                            DynamicRange dynamicRangeFindSupportedHdrMatch2 = zzr.findSupportedHdrMatch(dynamicRange11, linkedHashSet3, hashSet2);
                            if (dynamicRangeFindSupportedHdrMatch2 == null) {
                                zzrVar = zzrVar2;
                                it3 = hashSet2.iterator();
                                while (true) {
                                    if (it3.hasNext()) {
                                        dynamicRangeFindSupportedHdrMatch = null;
                                        break;
                                    }
                                    dynamicRangeFindSupportedHdrMatch = (DynamicRange) it3.next();
                                    Preconditions.checkState("Candidate dynamic range must be fully specified.", dynamicRangeFindSupportedHdrMatch.isFullySpecified());
                                    if (!dynamicRangeFindSupportedHdrMatch.equals(dynamicRange5)) {
                                        Logger.d("DynamicRangeResolver", "Resolved dynamic range for use case " + targetName + " from validated dynamic range constraints or supported HDR dynamic ranges.\n" + dynamicRange11 + "\n->\n" + dynamicRangeFindSupportedHdrMatch);
                                        break;
                                    }
                                }
                            } else {
                                zzrVar = zzrVar2;
                                StringBuilder sbM = CaptureSession$State$EnumUnboxingLocalUtility.m("Resolved dynamic range for use case ", targetName, " from ", dynamicRangeFindSupportedHdrMatch2.equals(recommended10BitDynamicRange) ? "recommended" : "required", " 10-bit supported dynamic range.\n");
                                sbM.append(dynamicRange11);
                                sbM.append("\n->\n");
                                sbM.append(dynamicRangeFindSupportedHdrMatch2);
                                Logger.d("DynamicRangeResolver", sbM.toString());
                                dynamicRangeFindSupportedHdrMatch = dynamicRangeFindSupportedHdrMatch2;
                            }
                        }
                    } else {
                        Logger.d("DynamicRangeResolver", "Resolved dynamic range for use case " + targetName + " from existing attached surface.\n" + dynamicRange11 + "\n->\n" + dynamicRangeFindSupportedHdrMatch);
                    }
                    zzrVar = zzrVar2;
                }
            } else {
                if (!hashSet2.contains(dynamicRange11)) {
                    arrayList9 = arrayList11;
                    arrayList10 = arrayList12;
                    zzrVar = zzrVar2;
                    set = supportedDynamicRanges;
                    i13 = i63;
                    dynamicRangeFindSupportedHdrMatch = null;
                    break;
                }
                arrayList9 = arrayList11;
                arrayList10 = arrayList12;
                zzrVar = zzrVar2;
                set = supportedDynamicRanges;
                i13 = i63;
                dynamicRangeFindSupportedHdrMatch = dynamicRange11;
            }
            if (dynamicRangeFindSupportedHdrMatch == null) {
                throw new IllegalArgumentException("Unable to resolve supported dynamic range. The dynamic range may not be supported on the device or may not be allowed concurrently with other attached use cases.\nUse case:\n  " + useCaseConfig12.getTargetName() + "\nRequested dynamic range:\n  " + dynamicRange11 + "\nSupported dynamic ranges:\n  " + TextUtils.join("\n  ", set) + "\nConstrained set of concurrent dynamic ranges:\n  " + TextUtils.join("\n  ", hashSet2));
            }
            zzr.updateConstraints(hashSet2, dynamicRangeFindSupportedHdrMatch, anonymousClass1);
            map13.put(useCaseConfig12, dynamicRangeFindSupportedHdrMatch);
            if (!linkedHashSet.contains(dynamicRangeFindSupportedHdrMatch)) {
                linkedHashSet2.add(dynamicRangeFindSupportedHdrMatch);
            }
            zzrVar2 = zzrVar;
            arrayList17 = arrayList39;
            supportedDynamicRanges = set;
            size11 = i64;
            i23 = i13;
            arrayList11 = arrayList9;
            arrayList12 = arrayList10;
        }
    }

    public final Pair getSurfaceConfigListAndFpsCeiling(int i, ArrayList arrayList, List list, ArrayList arrayList2, ArrayList arrayList3, int i2, HashMap map, HashMap map2) {
        int outputMinFrameDuration;
        ArrayList arrayList4 = new ArrayList();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            AutoValue_AttachedSurfaceInfo autoValue_AttachedSurfaceInfo = (AutoValue_AttachedSurfaceInfo) obj;
            arrayList4.add(autoValue_AttachedSurfaceInfo.surfaceConfig);
            if (map != null) {
                map.put(Integer.valueOf(arrayList4.size() - 1), autoValue_AttachedSurfaceInfo);
            }
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            Size size2 = (Size) list.get(i4);
            UseCaseConfig useCaseConfig = (UseCaseConfig) arrayList2.get(((Integer) arrayList3.get(i4)).intValue());
            int inputFormat = useCaseConfig.getInputFormat();
            arrayList4.add(AutoValue_SurfaceConfig.transformSurfaceConfig(i, inputFormat, size2, getUpdatedSurfaceSizeDefinitionByFormat(inputFormat)));
            if (map2 != null) {
                map2.put(Integer.valueOf(arrayList4.size() - 1), useCaseConfig);
            }
            try {
                outputMinFrameDuration = (int) (1.0E9d / ((StreamConfigurationMap) this.mCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputMinFrameDuration(useCaseConfig.getInputFormat(), size2));
            } catch (Exception unused) {
                outputMinFrameDuration = 0;
            }
            i2 = Math.min(i2, outputMinFrameDuration);
        }
        return new Pair(arrayList4, Integer.valueOf(i2));
    }

    public final AutoValue_SurfaceSizeDefinition getUpdatedSurfaceSizeDefinitionByFormat(int i) {
        StreamConfigurationMap streamConfigurationMap;
        Integer numValueOf = Integer.valueOf(i);
        ArrayList arrayList = this.mSurfaceSizeDefinitionFormats;
        if (!arrayList.contains(numValueOf)) {
            updateS720pOrS1440pSizeByFormat(this.mSurfaceSizeDefinition.s720pSizeMap, SizeUtil.RESOLUTION_720P, i);
            updateS720pOrS1440pSizeByFormat(this.mSurfaceSizeDefinition.s1440pSizeMap, SizeUtil.RESOLUTION_1440P, i);
            HashMap map = this.mSurfaceSizeDefinition.maximumSizeMap;
            CameraCharacteristicsCompat cameraCharacteristicsCompat = this.mCharacteristics;
            Size maxOutputSizeByFormat = getMaxOutputSizeByFormat((StreamConfigurationMap) ((PreviewView.AnonymousClass1) cameraCharacteristicsCompat.getStreamConfigurationMapCompat().mOnInvalidateMenuCallback).this$0, i, true);
            if (maxOutputSizeByFormat != null) {
                map.put(Integer.valueOf(i), maxOutputSizeByFormat);
            }
            HashMap map2 = this.mSurfaceSizeDefinition.ultraMaximumSizeMap;
            if (Build.VERSION.SDK_INT >= 31 && this.mIsUltraHighResolutionSensorSupported && (streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristicsCompat.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP_MAXIMUM_RESOLUTION)) != null) {
                map2.put(Integer.valueOf(i), getMaxOutputSizeByFormat(streamConfigurationMap, i, true));
            }
            arrayList.add(Integer.valueOf(i));
        }
        return this.mSurfaceSizeDefinition;
    }

    public final void updateS720pOrS1440pSizeByFormat(HashMap map, Size size, int i) {
        if (this.mIsConcurrentCameraModeSupported) {
            Size maxOutputSizeByFormat = getMaxOutputSizeByFormat((StreamConfigurationMap) ((PreviewView.AnonymousClass1) this.mCharacteristics.getStreamConfigurationMapCompat().mOnInvalidateMenuCallback).this$0, i, false);
            Integer numValueOf = Integer.valueOf(i);
            if (maxOutputSizeByFormat != null) {
                size = (Size) Collections.min(Arrays.asList(size, maxOutputSizeByFormat), new CompareSizesByArea(false));
            }
            map.put(numValueOf, size);
        }
    }
}
