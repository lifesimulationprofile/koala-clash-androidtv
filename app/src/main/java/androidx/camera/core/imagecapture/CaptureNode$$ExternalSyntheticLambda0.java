package androidx.camera.core.imagecapture;

import android.os.Build;
import android.util.Pair;
import androidx.camera.camera2.internal.compat.quirk.CaptureSessionOnClosedNotCalledQuirk;
import androidx.camera.camera2.internal.compat.quirk.CaptureSessionShouldUseMrirQuirk;
import androidx.camera.camera2.internal.compat.quirk.CrashWhenTakingPhotoWithAutoFlashAEModeQuirk;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ExcludedSupportedSizesQuirk;
import androidx.camera.camera2.internal.compat.quirk.ExtraCroppingQuirk;
import androidx.camera.camera2.internal.compat.quirk.ExtraSupportedOutputSizeQuirk;
import androidx.camera.camera2.internal.compat.quirk.ExtraSupportedSurfaceCombinationsQuirk;
import androidx.camera.camera2.internal.compat.quirk.FlashAvailabilityBufferUnderflowQuirk;
import androidx.camera.camera2.internal.compat.quirk.ImageCapturePixelHDRPlusQuirk;
import androidx.camera.camera2.internal.compat.quirk.InvalidVideoProfilesQuirk;
import androidx.camera.camera2.internal.compat.quirk.Nexus4AndroidLTargetAspectRatioQuirk;
import androidx.camera.camera2.internal.compat.quirk.Preview3AThreadCrashQuirk;
import androidx.camera.camera2.internal.compat.quirk.PreviewPixelHDRnetQuirk;
import androidx.camera.camera2.internal.compat.quirk.RepeatingStreamConstraintForVideoRecordingQuirk;
import androidx.camera.camera2.internal.compat.quirk.SmallDisplaySizeQuirk;
import androidx.camera.camera2.internal.compat.quirk.StillCaptureFlashStopRepeatingQuirk;
import androidx.camera.camera2.internal.compat.quirk.TextureViewIsClosedQuirk;
import androidx.camera.camera2.internal.compat.quirk.TorchIsClosedAfterImageCapturingQuirk;
import androidx.camera.camera2.internal.compat.quirk.ZslDisablerQuirk;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.QuirkSettings;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.SurfaceCombination;
import androidx.camera.core.internal.compat.quirk.CaptureFailedRetryQuirk;
import androidx.camera.core.internal.compat.quirk.ImageCaptureRotationOptionQuirk;
import androidx.camera.core.internal.compat.quirk.IncorrectJpegMetadataQuirk;
import androidx.camera.core.internal.compat.quirk.LargeJpegImageQuirk;
import androidx.camera.core.internal.compat.quirk.LowMemoryQuirk;
import androidx.camera.core.internal.compat.quirk.SurfaceOrderQuirk;
import androidx.camera.view.internal.compat.quirk.SurfaceViewNotCroppedByParentQuirk;
import androidx.camera.view.internal.compat.quirk.SurfaceViewStretchedQuirk;
import androidx.core.util.Consumer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import kotlin.text.CharsKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CaptureNode$$ExternalSyntheticLambda0 implements Consumer {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ CaptureNode$$ExternalSyntheticLambda0(int i) {
        this.$r8$classId = i;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x003c  */
    /* JADX WARN: Code duplicated, block: B:191:0x039e  */
    /* JADX WARN: Code duplicated, block: B:23:0x0063  */
    /* JADX WARN: Code duplicated, block: B:255:0x04d2  */
    /* JADX WARN: Code duplicated, block: B:259:0x04e0  */
    /* JADX WARN: Code duplicated, block: B:261:0x04ee  */
    /* JADX WARN: Code duplicated, block: B:264:0x04f9  */
    /* JADX WARN: Code duplicated, block: B:266:0x0505 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:267:0x0507  */
    /* JADX WARN: Code duplicated, block: B:268:0x0509  */
    /* JADX WARN: Code duplicated, block: B:271:0x050d  */
    /* JADX WARN: Code duplicated, block: B:273:0x0519 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:274:0x051b  */
    /* JADX WARN: Code duplicated, block: B:275:0x051d  */
    /* JADX WARN: Code duplicated, block: B:279:0x0523  */
    @Override // androidx.core.util.Consumer
    public final void accept(Object obj) {
        boolean z;
        String str;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean zContains;
        boolean z5;
        boolean z6;
        switch (this.$r8$classId) {
            case 0:
                if (obj != null) {
                    throw new ClassCastException();
                }
                CharsKt.checkMainThread();
                throw null;
            case 1:
                QuirkSettings quirkSettings = (QuirkSettings) obj;
                ArrayList arrayList = new ArrayList();
                List list = ImageCapturePixelHDRPlusQuirk.BUILD_MODELS;
                String str2 = Build.MODEL;
                if (quirkSettings.shouldEnableQuirk(ImageCapturePixelHDRPlusQuirk.class, list.contains(str2) && "Google".equals(Build.MANUFACTURER) && Build.VERSION.SDK_INT >= 26)) {
                    arrayList.add(new ImageCapturePixelHDRPlusQuirk());
                }
                if (quirkSettings.shouldEnableQuirk(ExtraCroppingQuirk.class, ExtraCroppingQuirk.isSamsungDistortion())) {
                    arrayList.add(new ExtraCroppingQuirk());
                }
                int i = Nexus4AndroidLTargetAspectRatioQuirk.$r8$clinit;
                String str3 = Build.BRAND;
                "GOOGLE".equalsIgnoreCase(str3);
                if (quirkSettings.shouldEnableQuirk(Nexus4AndroidLTargetAspectRatioQuirk.class, false)) {
                    arrayList.add(new Nexus4AndroidLTargetAspectRatioQuirk());
                }
                if (quirkSettings.shouldEnableQuirk(ExcludedSupportedSizesQuirk.class, ("OnePlus".equalsIgnoreCase(str3) && "OnePlus6".equalsIgnoreCase(Build.DEVICE)) || ("OnePlus".equalsIgnoreCase(str3) && "OnePlus6T".equalsIgnoreCase(Build.DEVICE)) || (("HUAWEI".equalsIgnoreCase(str3) && "HWANE".equalsIgnoreCase(Build.DEVICE)) || ExcludedSupportedSizesQuirk.isSamsungJ7PrimeApi27Above() || ExcludedSupportedSizesQuirk.isSamsungJ7Api27Above() || ("REDMI".equalsIgnoreCase(str3) && "joyeuse".equalsIgnoreCase(Build.DEVICE))))) {
                    arrayList.add(new ExcludedSupportedSizesQuirk());
                }
                List list2 = CrashWhenTakingPhotoWithAutoFlashAEModeQuirk.AFFECTED_MODELS;
                Locale locale = Locale.US;
                if (quirkSettings.shouldEnableQuirk(CrashWhenTakingPhotoWithAutoFlashAEModeQuirk.class, list2.contains(str2.toUpperCase(locale)))) {
                    arrayList.add(new CrashWhenTakingPhotoWithAutoFlashAEModeQuirk());
                }
                List list3 = PreviewPixelHDRnetQuirk.SUPPORTED_DEVICES;
                String str4 = Build.MANUFACTURER;
                if (quirkSettings.shouldEnableQuirk(PreviewPixelHDRnetQuirk.class, "Google".equals(str4) && PreviewPixelHDRnetQuirk.SUPPORTED_DEVICES.contains(Build.DEVICE.toLowerCase(Locale.getDefault())))) {
                    arrayList.add(new PreviewPixelHDRnetQuirk());
                }
                if (quirkSettings.shouldEnableQuirk(StillCaptureFlashStopRepeatingQuirk.class, "SAMSUNG".equals(str4.toUpperCase(locale)) && str2.toUpperCase(locale).startsWith("SM-A716"))) {
                    arrayList.add(new StillCaptureFlashStopRepeatingQuirk());
                }
                SurfaceCombination surfaceCombination = ExtraSupportedSurfaceCombinationsQuirk.FULL_LEVEL_YUV_PRIV_YUV_CONFIGURATION;
                String str5 = Build.DEVICE;
                if ("heroqltevzw".equalsIgnoreCase(str5) || "heroqltetmo".equalsIgnoreCase(str5)) {
                    z = true;
                } else {
                    if ("google".equalsIgnoreCase(str3)) {
                        zContains = ExtraSupportedSurfaceCombinationsQuirk.SUPPORT_EXTRA_LEVEL_3_CONFIGURATIONS_GOOGLE_MODELS.contains(str2.toUpperCase(locale));
                    } else {
                        zContains = false;
                    }
                    if (zContains || ExtraSupportedSurfaceCombinationsQuirk.supportExtraLevel3ConfigurationsSamsungDevice()) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                if (quirkSettings.shouldEnableQuirk(ExtraSupportedSurfaceCombinationsQuirk.class, z)) {
                    arrayList.add(new ExtraSupportedSurfaceCombinationsQuirk());
                }
                if (quirkSettings.shouldEnableQuirk(FlashAvailabilityBufferUnderflowQuirk.class, FlashAvailabilityBufferUnderflowQuirk.KNOWN_AFFECTED_MODELS.contains(new Pair(str4.toLowerCase(locale), str2.toLowerCase(locale))))) {
                    arrayList.add(new FlashAvailabilityBufferUnderflowQuirk());
                }
                if (quirkSettings.shouldEnableQuirk(RepeatingStreamConstraintForVideoRecordingQuirk.class, "Huawei".equalsIgnoreCase(str3) && "mha-l29".equalsIgnoreCase(str2))) {
                    arrayList.add(new RepeatingStreamConstraintForVideoRecordingQuirk());
                }
                int i2 = Build.VERSION.SDK_INT;
                if (quirkSettings.shouldEnableQuirk(TextureViewIsClosedQuirk.class, i2 <= 23)) {
                    arrayList.add(new TextureViewIsClosedQuirk());
                }
                if (quirkSettings.shouldEnableQuirk(CaptureSessionOnClosedNotCalledQuirk.class, false)) {
                    arrayList.add(new CaptureSessionOnClosedNotCalledQuirk());
                }
                if (quirkSettings.shouldEnableQuirk(TorchIsClosedAfterImageCapturingQuirk.class, TorchIsClosedAfterImageCapturingQuirk.BUILD_MODELS.contains(str2.toLowerCase(locale)))) {
                    arrayList.add(new TorchIsClosedAfterImageCapturingQuirk());
                }
                List list4 = ZslDisablerQuirk.AFFECTED_SAMSUNG_MODEL;
                if (quirkSettings.shouldEnableQuirk(ZslDisablerQuirk.class, ("samsung".equalsIgnoreCase(str3) && ZslDisablerQuirk.isAffectedModel(ZslDisablerQuirk.AFFECTED_SAMSUNG_MODEL)) || ("xiaomi".equalsIgnoreCase(str3) && ZslDisablerQuirk.isAffectedModel(ZslDisablerQuirk.AFFECTED_XIAOMI_MODEL)))) {
                    arrayList.add(new ZslDisablerQuirk());
                }
                if (quirkSettings.shouldEnableQuirk(ExtraSupportedOutputSizeQuirk.class, "motorola".equalsIgnoreCase(str3) && "moto e5 play".equalsIgnoreCase(str2))) {
                    arrayList.add(new ExtraSupportedOutputSizeQuirk());
                }
                List list5 = InvalidVideoProfilesQuirk.AFFECTED_PIXEL_MODELS;
                if (!"samsung".equalsIgnoreCase(str3) || !Build.ID.toLowerCase(Locale.ROOT).startsWith("tp1a")) {
                    List list6 = InvalidVideoProfilesQuirk.AFFECTED_PIXEL_MODELS;
                    Locale locale2 = Locale.ROOT;
                    if (list6.contains(str2.toLowerCase(locale2))) {
                        String str6 = Build.ID;
                        if (!str6.toLowerCase(locale2).startsWith("tp1a") && !str6.toLowerCase(locale2).startsWith("td1a")) {
                            if (!"redmi".equalsIgnoreCase(str3) || "xiaomi".equalsIgnoreCase(str3)) {
                                str = Build.ID;
                                if (str.toLowerCase(locale2).startsWith("tkq1") && !str.toLowerCase(locale2).startsWith("tp1a")) {
                                    if (InvalidVideoProfilesQuirk.AFFECTED_ONE_PLUS_MODELS.contains(str2.toLowerCase(locale2))) {
                                        if (i2 == 33) {
                                            z3 = true;
                                        } else {
                                            z3 = false;
                                        }
                                        if (z3) {
                                            if (InvalidVideoProfilesQuirk.AFFECTED_OPPO_MODELS.contains(str2.toLowerCase(locale2))) {
                                                if (i2 == 33) {
                                                    z2 = true;
                                                } else {
                                                    z2 = false;
                                                }
                                                if (z2) {
                                                }
                                            }
                                        }
                                    } else {
                                        if (InvalidVideoProfilesQuirk.AFFECTED_OPPO_MODELS.contains(str2.toLowerCase(locale2))) {
                                            if (i2 == 33) {
                                                z2 = true;
                                            } else {
                                                z2 = false;
                                            }
                                            z4 = z2;
                                        }
                                    }
                                }
                            } else if (InvalidVideoProfilesQuirk.AFFECTED_ONE_PLUS_MODELS.contains(str2.toLowerCase(locale2))) {
                                if (InvalidVideoProfilesQuirk.AFFECTED_OPPO_MODELS.contains(str2.toLowerCase(locale2))) {
                                    if (i2 == 33) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    if (z2) {
                                    }
                                }
                            } else {
                                if (i2 == 33) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if (z3) {
                                    if (InvalidVideoProfilesQuirk.AFFECTED_OPPO_MODELS.contains(str2.toLowerCase(locale2))) {
                                        if (i2 == 33) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                        if (z2) {
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        if ("redmi".equalsIgnoreCase(str3)) {
                            str = Build.ID;
                            if (str.toLowerCase(locale2).startsWith("tkq1")) {
                            }
                        } else {
                            str = Build.ID;
                            if (str.toLowerCase(locale2).startsWith("tkq1")) {
                            }
                        }
                    }
                }
                if (quirkSettings.shouldEnableQuirk(InvalidVideoProfilesQuirk.class, z4)) {
                    arrayList.add(new InvalidVideoProfilesQuirk());
                }
                if (quirkSettings.shouldEnableQuirk(Preview3AThreadCrashQuirk.class, "samsungexynos7870".equalsIgnoreCase(Build.HARDWARE))) {
                    arrayList.add(new Preview3AThreadCrashQuirk());
                }
                if (quirkSettings.shouldEnableQuirk(SmallDisplaySizeQuirk.class, SmallDisplaySizeQuirk.MODEL_TO_DISPLAY_SIZE_MAP.containsKey(str2.toUpperCase(locale)))) {
                    arrayList.add(new SmallDisplaySizeQuirk());
                }
                if (quirkSettings.shouldEnableQuirk(CaptureSessionShouldUseMrirQuirk.class, "google".equalsIgnoreCase(str3) && i2 >= 35)) {
                    arrayList.add(new CaptureSessionShouldUseMrirQuirk());
                }
                DeviceQuirks.sQuirks = new Quirks(arrayList);
                Logger.d("DeviceQuirks", "camera2 DeviceQuirks = " + Quirks.toString(DeviceQuirks.sQuirks));
                return;
            case 2:
                if (obj != null) {
                    throw new ClassCastException();
                }
                CharsKt.checkMainThread();
                throw null;
            case 3:
                QuirkSettings quirkSettings2 = (QuirkSettings) obj;
                ArrayList arrayList2 = new ArrayList();
                String str7 = Build.BRAND;
                if (("HUAWEI".equalsIgnoreCase(str7) && "SNE-LX1".equalsIgnoreCase(Build.MODEL)) || ("HONOR".equalsIgnoreCase(str7) && "STK-LX1".equalsIgnoreCase(Build.MODEL))) {
                    z5 = true;
                } else {
                    String str8 = Build.FINGERPRINT;
                    if (!str8.startsWith("generic") && !str8.startsWith("unknown")) {
                        String str9 = Build.MODEL;
                        if (!str9.contains("google_sdk") && !str9.contains("Emulator") && !str9.contains("Cuttlefish") && !str9.contains("Android SDK built for x86") && !Build.MANUFACTURER.contains("Genymotion") && ((!str7.startsWith("generic") || !Build.DEVICE.startsWith("generic")) && !Build.PRODUCT.equals("google_sdk"))) {
                            Build.HARDWARE.contains("ranchu");
                        }
                    }
                    z5 = false;
                }
                if (quirkSettings2.shouldEnableQuirk(ImageCaptureRotationOptionQuirk.class, z5)) {
                    arrayList2.add(new ImageCaptureRotationOptionQuirk());
                }
                if (quirkSettings2.shouldEnableQuirk(SurfaceOrderQuirk.class, true)) {
                    arrayList2.add(new SurfaceOrderQuirk());
                }
                HashSet hashSet = CaptureFailedRetryQuirk.FAILED_RETRY_ALLOW_LIST;
                Locale locale3 = Locale.US;
                String upperCase = str7.toUpperCase(locale3);
                String str10 = Build.MODEL;
                if (quirkSettings2.shouldEnableQuirk(CaptureFailedRetryQuirk.class, CaptureFailedRetryQuirk.FAILED_RETRY_ALLOW_LIST.contains(Pair.create(upperCase, str10.toUpperCase(locale3))))) {
                    arrayList2.add(new CaptureFailedRetryQuirk());
                }
                if (quirkSettings2.shouldEnableQuirk(LowMemoryQuirk.class, LowMemoryQuirk.DEVICE_MODELS.contains(str10.toUpperCase(locale3)))) {
                    arrayList2.add(new LowMemoryQuirk());
                }
                HashSet hashSet2 = LargeJpegImageQuirk.VIVO_DEVICE_MODELS;
                if (quirkSettings2.shouldEnableQuirk(LargeJpegImageQuirk.class, "Samsung".equalsIgnoreCase(str7) || ("Vivo".equalsIgnoreCase(str7) && LargeJpegImageQuirk.VIVO_DEVICE_MODELS.contains(str10.toUpperCase(locale3))))) {
                    arrayList2.add(new LargeJpegImageQuirk());
                }
                HashSet hashSet3 = IncorrectJpegMetadataQuirk.SAMSUNG_DEVICES;
                if (quirkSettings2.shouldEnableQuirk(IncorrectJpegMetadataQuirk.class, "Samsung".equalsIgnoreCase(str7) && IncorrectJpegMetadataQuirk.SAMSUNG_DEVICES.contains(Build.DEVICE.toUpperCase(locale3)))) {
                    arrayList2.add(new IncorrectJpegMetadataQuirk());
                }
                androidx.camera.core.internal.compat.quirk.DeviceQuirks.sQuirks = new Quirks(arrayList2);
                Logger.d("DeviceQuirks", "core DeviceQuirks = " + Quirks.toString(androidx.camera.core.internal.compat.quirk.DeviceQuirks.sQuirks));
                return;
            default:
                QuirkSettings quirkSettings3 = (QuirkSettings) obj;
                ArrayList arrayList3 = new ArrayList();
                if (Build.VERSION.SDK_INT < 33) {
                    String str11 = Build.MANUFACTURER;
                    if ("SAMSUNG".equalsIgnoreCase(str11)) {
                        String str12 = Build.DEVICE;
                        if (!"F2Q".equalsIgnoreCase(str12) && !"Q2Q".equalsIgnoreCase(str12)) {
                            if (("OPPO".equalsIgnoreCase(str11) || !"OP4E75L1".equalsIgnoreCase(Build.DEVICE)) && (!"LENOVO".equalsIgnoreCase(str11) || !"Q706F".equalsIgnoreCase(Build.DEVICE))) {
                                z6 = false;
                            }
                        }
                        z6 = true;
                    } else if ("OPPO".equalsIgnoreCase(str11)) {
                        z6 = false;
                    } else {
                        z6 = false;
                    }
                } else {
                    z6 = false;
                }
                if (quirkSettings3.shouldEnableQuirk(SurfaceViewStretchedQuirk.class, z6)) {
                    arrayList3.add(new SurfaceViewStretchedQuirk());
                }
                if (quirkSettings3.shouldEnableQuirk(SurfaceViewNotCroppedByParentQuirk.class, "XIAOMI".equalsIgnoreCase(Build.MANUFACTURER) && "M2101K7AG".equalsIgnoreCase(Build.MODEL))) {
                    arrayList3.add(new SurfaceViewNotCroppedByParentQuirk());
                }
                androidx.camera.view.internal.compat.quirk.DeviceQuirks.sQuirks = new Quirks(arrayList3);
                Logger.d("DeviceQuirks", "view DeviceQuirks = " + Quirks.toString(androidx.camera.view.internal.compat.quirk.DeviceQuirks.sQuirks));
                return;
        }
    }

    public /* synthetic */ CaptureNode$$ExternalSyntheticLambda0(SurfaceRequest.AnonymousClass1 anonymousClass1, int i) {
        this.$r8$classId = i;
    }
}
