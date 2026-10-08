package kotlin.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.quirk.AbnormalStreamWhenImageAnalysisBindWithTemplateRecordQuirk;
import androidx.camera.camera2.internal.compat.quirk.AeFpsRangeLegacyQuirk;
import androidx.camera.camera2.internal.compat.quirk.AfRegionFlipHorizontallyQuirk;
import androidx.camera.camera2.internal.compat.quirk.AspectRatioLegacyApi21Quirk;
import androidx.camera.camera2.internal.compat.quirk.CamcorderProfileResolutionQuirk;
import androidx.camera.camera2.internal.compat.quirk.CameraNoResponseWhenEnablingFlashQuirk;
import androidx.camera.camera2.internal.compat.quirk.CaptureNoResponseQuirk;
import androidx.camera.camera2.internal.compat.quirk.CaptureSessionStuckQuirk;
import androidx.camera.camera2.internal.compat.quirk.ConfigureSurfaceToSecondarySessionFailQuirk;
import androidx.camera.camera2.internal.compat.quirk.FlashTooSlowQuirk;
import androidx.camera.camera2.internal.compat.quirk.ImageCaptureFailWithAutoFlashQuirk;
import androidx.camera.camera2.internal.compat.quirk.ImageCaptureFailedForVideoSnapshotQuirk;
import androidx.camera.camera2.internal.compat.quirk.ImageCaptureFailedWhenVideoCaptureIsBoundQuirk;
import androidx.camera.camera2.internal.compat.quirk.ImageCaptureFlashNotFireQuirk;
import androidx.camera.camera2.internal.compat.quirk.ImageCaptureWashedOutImageQuirk;
import androidx.camera.camera2.internal.compat.quirk.ImageCaptureWithFlashUnderexposureQuirk;
import androidx.camera.camera2.internal.compat.quirk.IncorrectCaptureStateQuirk;
import androidx.camera.camera2.internal.compat.quirk.JpegCaptureDownsizingQuirk;
import androidx.camera.camera2.internal.compat.quirk.JpegHalCorruptImageQuirk;
import androidx.camera.camera2.internal.compat.quirk.LegacyCameraOutputConfigNullPointerQuirk;
import androidx.camera.camera2.internal.compat.quirk.LegacyCameraSurfaceCleanupQuirk;
import androidx.camera.camera2.internal.compat.quirk.PreviewDelayWhenVideoCaptureIsBoundQuirk;
import androidx.camera.camera2.internal.compat.quirk.PreviewOrientationIncorrectQuirk;
import androidx.camera.camera2.internal.compat.quirk.PreviewStretchWhenVideoCaptureIsBoundQuirk;
import androidx.camera.camera2.internal.compat.quirk.TemporalNoiseQuirk;
import androidx.camera.camera2.internal.compat.quirk.TorchFlashRequiredFor3aUpdateQuirk;
import androidx.camera.camera2.internal.compat.quirk.YuvImageOnePixelShiftQuirk;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.AutoValue_StateObservable_ErrorWrapper;
import androidx.camera.core.impl.QuirkSettings;
import androidx.camera.core.impl.QuirkSettingsHolder;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.impl.utils.futures.ImmediateFuture$ImmediateFailedFuture;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ProgressionUtilKt {
    /* JADX WARN: Code duplicated, block: B:304:0x0517  */
    /* JADX WARN: Code duplicated, block: B:337:0x05a7  */
    public static Quirks get(CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        Integer num;
        QuirkSettingsHolder quirkSettingsHolder = QuirkSettingsHolder.sInstance;
        quirkSettingsHolder.getClass();
        try {
            try {
                Object obj = ((AtomicReference) quirkSettingsHolder.mObservable.before).get();
                QuirkSettings quirkSettings = (QuirkSettings) (obj instanceof AutoValue_StateObservable_ErrorWrapper ? new ImmediateFuture$ImmediateFailedFuture(0, null) : Futures.immediateFuture(obj)).get();
                ArrayList arrayList = new ArrayList();
                CameraCharacteristics.Key key = CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL;
                Integer num2 = (Integer) cameraCharacteristicsCompat.get(key);
                if (quirkSettings.shouldEnableQuirk(AeFpsRangeLegacyQuirk.class, num2 != null && num2.intValue() == 2)) {
                    arrayList.add(new AeFpsRangeLegacyQuirk(cameraCharacteristicsCompat));
                }
                if (quirkSettings.shouldEnableQuirk(AspectRatioLegacyApi21Quirk.class, false)) {
                    arrayList.add(new AspectRatioLegacyApi21Quirk());
                }
                HashSet hashSet = JpegHalCorruptImageQuirk.KNOWN_AFFECTED_DEVICES;
                String str = Build.DEVICE;
                Locale locale = Locale.US;
                if (quirkSettings.shouldEnableQuirk(JpegHalCorruptImageQuirk.class, hashSet.contains(str.toLowerCase(locale)))) {
                    arrayList.add(new JpegHalCorruptImageQuirk());
                }
                HashSet hashSet2 = JpegCaptureDownsizingQuirk.KNOWN_AFFECTED_FRONT_CAMERA_DEVICES;
                String str2 = Build.MODEL;
                if (quirkSettings.shouldEnableQuirk(JpegCaptureDownsizingQuirk.class, hashSet2.contains(str2.toLowerCase(locale)) && ((Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.LENS_FACING)).intValue() == 0)) {
                    arrayList.add(new JpegCaptureDownsizingQuirk());
                }
                Integer num3 = (Integer) cameraCharacteristicsCompat.get(key);
                if (quirkSettings.shouldEnableQuirk(CamcorderProfileResolutionQuirk.class, num3 != null && num3.intValue() == 2)) {
                    CamcorderProfileResolutionQuirk camcorderProfileResolutionQuirk = new CamcorderProfileResolutionQuirk();
                    cameraCharacteristicsCompat.getStreamConfigurationMapCompat();
                    arrayList.add(camcorderProfileResolutionQuirk);
                }
                String str3 = Build.HARDWARE;
                if (quirkSettings.shouldEnableQuirk(CaptureNoResponseQuirk.class, ("samsungexynos7420".equalsIgnoreCase(str3) || "universal7420".equalsIgnoreCase(str3)) && ((Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.LENS_FACING)).intValue() == 1)) {
                    arrayList.add(new CaptureNoResponseQuirk());
                }
                Integer num4 = (Integer) cameraCharacteristicsCompat.get(key);
                int i = Build.VERSION.SDK_INT;
                if (quirkSettings.shouldEnableQuirk(LegacyCameraOutputConfigNullPointerQuirk.class, i > 23 && num4 != null && num4.intValue() == 2)) {
                    arrayList.add(new LegacyCameraOutputConfigNullPointerQuirk());
                }
                if (quirkSettings.shouldEnableQuirk(LegacyCameraSurfaceCleanupQuirk.class, i > 23 && i < 29 && (num = (Integer) cameraCharacteristicsCompat.get(key)) != null && num.intValue() == 2)) {
                    arrayList.add(new LegacyCameraSurfaceCleanupQuirk());
                }
                if (quirkSettings.shouldEnableQuirk(ImageCaptureWashedOutImageQuirk.class, ImageCaptureWashedOutImageQuirk.BUILD_MODELS.contains(str2.toUpperCase(locale)) && ((Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.LENS_FACING)).intValue() == 1)) {
                    arrayList.add(new ImageCaptureWashedOutImageQuirk());
                }
                if (quirkSettings.shouldEnableQuirk(CameraNoResponseWhenEnablingFlashQuirk.class, CameraNoResponseWhenEnablingFlashQuirk.AFFECTED_MODELS.contains(str2.toUpperCase(locale)) && ((Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.LENS_FACING)).intValue() == 1)) {
                    arrayList.add(new CameraNoResponseWhenEnablingFlashQuirk());
                }
                String str4 = Build.BRAND;
                if (quirkSettings.shouldEnableQuirk(YuvImageOnePixelShiftQuirk.class, ("motorola".equalsIgnoreCase(str4) && "MotoG3".equalsIgnoreCase(str2)) || ("samsung".equalsIgnoreCase(str4) && "SM-G532F".equalsIgnoreCase(str2)) || (("samsung".equalsIgnoreCase(str4) && "SM-J700F".equalsIgnoreCase(str2)) || (("samsung".equalsIgnoreCase(str4) && "SM-A920F".equalsIgnoreCase(str2)) || (("samsung".equalsIgnoreCase(str4) && "SM-J415F".equalsIgnoreCase(str2)) || ("xiaomi".equalsIgnoreCase(str4) && "Mi A1".equalsIgnoreCase(str2))))))) {
                    arrayList.add(new YuvImageOnePixelShiftQuirk());
                }
                Iterator it = FlashTooSlowQuirk.AFFECTED_MODEL_PREFIXES.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (Build.MODEL.toUpperCase(Locale.US).startsWith((String) it.next())) {
                            if (((Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.LENS_FACING)).intValue() == 1) {
                                z = true;
                                break;
                            }
                        }
                    }
                    z = false;
                    break;
                }
                if (quirkSettings.shouldEnableQuirk(FlashTooSlowQuirk.class, z)) {
                    arrayList.add(new FlashTooSlowQuirk());
                }
                if (quirkSettings.shouldEnableQuirk(AfRegionFlipHorizontallyQuirk.class, Build.BRAND.equalsIgnoreCase("SAMSUNG") && Build.VERSION.SDK_INT < 33 && ((Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.LENS_FACING)).intValue() == 0)) {
                    arrayList.add(new AfRegionFlipHorizontallyQuirk());
                }
                CameraCharacteristics.Key key2 = CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL;
                Integer num5 = (Integer) cameraCharacteristicsCompat.get(key2);
                if (quirkSettings.shouldEnableQuirk(ConfigureSurfaceToSecondarySessionFailQuirk.class, num5 != null && num5.intValue() == 2)) {
                    arrayList.add(new ConfigureSurfaceToSecondarySessionFailQuirk());
                }
                Integer num6 = (Integer) cameraCharacteristicsCompat.get(key2);
                if (quirkSettings.shouldEnableQuirk(PreviewOrientationIncorrectQuirk.class, num6 != null && num6.intValue() == 2)) {
                    arrayList.add(new PreviewOrientationIncorrectQuirk());
                }
                Integer num7 = (Integer) cameraCharacteristicsCompat.get(key2);
                if (quirkSettings.shouldEnableQuirk(CaptureSessionStuckQuirk.class, num7 != null && num7.intValue() == 2)) {
                    arrayList.add(new CaptureSessionStuckQuirk());
                }
                List list = ImageCaptureFlashNotFireQuirk.BUILD_MODELS_FRONT_CAMERA;
                String str5 = Build.MODEL;
                Locale locale2 = Locale.US;
                if (quirkSettings.shouldEnableQuirk(ImageCaptureFlashNotFireQuirk.class, (list.contains(str5.toLowerCase(locale2)) && ((Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.LENS_FACING)).intValue() == 0) || ImageCaptureFlashNotFireQuirk.BUILD_MODELS.contains(str5.toLowerCase(locale2)))) {
                    arrayList.add(new ImageCaptureFlashNotFireQuirk());
                }
                if (quirkSettings.shouldEnableQuirk(ImageCaptureWithFlashUnderexposureQuirk.class, ImageCaptureWithFlashUnderexposureQuirk.BUILD_MODELS.contains(str5.toLowerCase(locale2)) && ((Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.LENS_FACING)).intValue() == 1)) {
                    arrayList.add(new ImageCaptureWithFlashUnderexposureQuirk());
                }
                if (quirkSettings.shouldEnableQuirk(ImageCaptureFailWithAutoFlashQuirk.class, ImageCaptureFailWithAutoFlashQuirk.BUILD_MODELS_FRONT_CAMERA.contains(str5.toLowerCase(locale2)) && ((Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.LENS_FACING)).intValue() == 0)) {
                    arrayList.add(new ImageCaptureFailWithAutoFlashQuirk());
                }
                Integer num8 = (Integer) cameraCharacteristicsCompat.get(key2);
                if (quirkSettings.shouldEnableQuirk(IncorrectCaptureStateQuirk.class, num8 != null && num8.intValue() == 2)) {
                    arrayList.add(new IncorrectCaptureStateQuirk());
                }
                Iterator it2 = TorchFlashRequiredFor3aUpdateQuirk.AFFECTED_PIXEL_MODELS.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (Build.MODEL.toUpperCase(Locale.US).equals((String) it2.next())) {
                            if (((Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.LENS_FACING)).intValue() == 0) {
                                z2 = true;
                                break;
                            }
                        }
                    }
                    z2 = false;
                    break;
                }
                if (quirkSettings.shouldEnableQuirk(TorchFlashRequiredFor3aUpdateQuirk.class, z2)) {
                    arrayList.add(new TorchFlashRequiredFor3aUpdateQuirk());
                }
                String str6 = Build.MANUFACTURER;
                if (quirkSettings.shouldEnableQuirk(PreviewStretchWhenVideoCaptureIsBoundQuirk.class, ("HUAWEI".equalsIgnoreCase(str6) && "HUAWEI ALE-L04".equalsIgnoreCase(Build.MODEL)) || ("Samsung".equalsIgnoreCase(str6) && "sm-j320f".equalsIgnoreCase(Build.MODEL)) || (("Samsung".equalsIgnoreCase(str6) && "sm-j700f".equalsIgnoreCase(Build.MODEL)) || (("Samsung".equalsIgnoreCase(str6) && "sm-j111f".equalsIgnoreCase(Build.MODEL)) || (("OPPO".equalsIgnoreCase(str6) && "A37F".equalsIgnoreCase(Build.MODEL)) || ("Samsung".equalsIgnoreCase(str6) && "sm-j510fn".equalsIgnoreCase(Build.MODEL))))))) {
                    arrayList.add(new PreviewStretchWhenVideoCaptureIsBoundQuirk());
                }
                if (quirkSettings.shouldEnableQuirk(PreviewDelayWhenVideoCaptureIsBoundQuirk.class, "Huawei".equalsIgnoreCase(str6))) {
                    arrayList.add(new PreviewDelayWhenVideoCaptureIsBoundQuirk());
                }
                String str7 = Build.BRAND;
                if (("blu".equalsIgnoreCase(str7) && "studio x10".equalsIgnoreCase(Build.MODEL)) || (("itel".equalsIgnoreCase(str7) && "itel w6004".equalsIgnoreCase(Build.MODEL)) || (("vivo".equalsIgnoreCase(str7) && "vivo 1805".equalsIgnoreCase(Build.MODEL)) || ("positivo".equalsIgnoreCase(str7) && "twist 2 pro".equalsIgnoreCase(Build.MODEL))))) {
                    z3 = true;
                } else {
                    String str8 = Build.MODEL;
                    if (("pixel 4 xl".equalsIgnoreCase(str8) && Build.VERSION.SDK_INT == 29) || ("motorola".equalsIgnoreCase(str7) && "moto e13".equalsIgnoreCase(str8))) {
                        z3 = true;
                    } else {
                        if ("samsung".equalsIgnoreCase(str7)) {
                            String str9 = Build.DEVICE;
                            if ("gta8".equalsIgnoreCase(str9) || "gta8wifi".equalsIgnoreCase(str9)) {
                                z3 = true;
                            }
                        }
                        z3 = false;
                    }
                }
                if (quirkSettings.shouldEnableQuirk(ImageCaptureFailedWhenVideoCaptureIsBoundQuirk.class, z3)) {
                    arrayList.add(new ImageCaptureFailedWhenVideoCaptureIsBoundQuirk());
                }
                String str10 = Build.MODEL;
                if (quirkSettings.shouldEnableQuirk(TemporalNoiseQuirk.class, "Pixel 8".equalsIgnoreCase(str10) && ((Integer) cameraCharacteristicsCompat.get(CameraCharacteristics.LENS_FACING)).intValue() == 0)) {
                    arrayList.add(new TemporalNoiseQuirk());
                }
                HashSet hashSet3 = ImageCaptureFailedForVideoSnapshotQuirk.PROBLEMATIC_UNI_SOC_MODELS;
                Locale locale3 = Locale.US;
                if (hashSet3.contains(str10.toLowerCase(locale3)) || (Build.VERSION.SDK_INT >= 31 && "Spreadtrum".equalsIgnoreCase(Build.SOC_MANUFACTURER))) {
                    z4 = true;
                } else {
                    String str11 = Build.HARDWARE;
                    if (str11.toLowerCase(locale3).startsWith("ums") || (("itel".equalsIgnoreCase(str7) && str11.toLowerCase(locale3).startsWith("sp")) || ("HUAWEI".equalsIgnoreCase(str7) && "FIG-LX1".equalsIgnoreCase(str10)))) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                }
                if (quirkSettings.shouldEnableQuirk(ImageCaptureFailedForVideoSnapshotQuirk.class, z4)) {
                    arrayList.add(new ImageCaptureFailedForVideoSnapshotQuirk());
                }
                if (quirkSettings.shouldEnableQuirk(AbnormalStreamWhenImageAnalysisBindWithTemplateRecordQuirk.class, "samsung".equalsIgnoreCase(str7) && str10.toLowerCase(locale3).startsWith("sm-m556"))) {
                    arrayList.add(new AbnormalStreamWhenImageAnalysisBindWithTemplateRecordQuirk());
                }
                Quirks quirks = new Quirks(arrayList);
                Logger.d("CameraQuirks", "camera2 CameraQuirks = " + Quirks.toString(quirks));
                return quirks;
            } catch (InterruptedException e) {
                e = e;
                throw new AssertionError("Unexpected error in QuirkSettings StateObservable", e);
            }
        } catch (InterruptedException | ExecutionException e2) {
            e = e2;
        }
    }

    public static final int getProgressionLastElement(int i, int i2, int i3) {
        if (i3 > 0) {
            if (i < i2) {
                int i4 = i2 % i3;
                if (i4 < 0) {
                    i4 += i3;
                }
                int i5 = i % i3;
                if (i5 < 0) {
                    i5 += i3;
                }
                int i6 = (i4 - i5) % i3;
                if (i6 < 0) {
                    i6 += i3;
                }
                return i2 - i6;
            }
        } else {
            if (i3 >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            }
            if (i > i2) {
                int i7 = -i3;
                int i8 = i % i7;
                if (i8 < 0) {
                    i8 += i7;
                }
                int i9 = i2 % i7;
                if (i9 < 0) {
                    i9 += i7;
                }
                int i10 = (i8 - i9) % i7;
                if (i10 < 0) {
                    i10 += i7;
                }
                return i10 + i2;
            }
        }
        return i2;
    }
}
