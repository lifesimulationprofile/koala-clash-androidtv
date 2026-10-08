package androidx.camera.core;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.impl.AutoValue_Config_Option;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.resolutionselector.AspectRatioStrategy;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.camera.core.resolutionselector.ResolutionStrategy;
import androidx.compose.animation.core.Animation;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetModifier$1;
import androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayout$1;
import androidx.core.view.MenuHostHelper;
import java.util.Iterator;
import java.util.Objects;
import kotlin.ULong;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class ImageAnalysis$$ExternalSyntheticLambda1 {
    public static UseCaseConfigFactory.CaptureType $default$getCaptureType(UseCaseConfig useCaseConfig) {
        return (UseCaseConfigFactory.CaptureType) useCaseConfig.retrieveOption(UseCaseConfig.OPTION_CAPTURE_TYPE);
    }

    public static DynamicRange $default$getDynamicRange(UseCaseConfig useCaseConfig) {
        DynamicRange dynamicRange = (DynamicRange) useCaseConfig.retrieveOption(ImageInputConfig.OPTION_INPUT_DYNAMIC_RANGE, DynamicRange.UNSPECIFIED);
        dynamicRange.getClass();
        return dynamicRange;
    }

    public static String $default$getTargetName(UseCaseConfig useCaseConfig, String str) {
        return (String) useCaseConfig.retrieveOption(TargetConfig.OPTION_TARGET_NAME, str);
    }

    public static boolean $default$isFinishedFromNanos(Animation animation, long j) {
        return j >= animation.getDurationNanos();
    }

    public static float m(float f, float f2, float f3, float f4) {
        return ((f - f2) * f3) + f4;
    }

    public static String m$1(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static OptionsBundle mergeConfigs(Config config, Config config2) {
        if (config == null && config2 == null) {
            return OptionsBundle.EMPTY_BUNDLE;
        }
        MutableOptionsBundle mutableOptionsBundleFrom = config2 != null ? MutableOptionsBundle.from(config2) : MutableOptionsBundle.create();
        if (config != null) {
            Iterator it = config.listOptions().iterator();
            while (it.hasNext()) {
                mergeOptionValue(mutableOptionsBundleFrom, config2, config, (AutoValue_Config_Option) it.next());
            }
        }
        return OptionsBundle.from(mutableOptionsBundleFrom);
    }

    public static void mergeOptionValue(MutableOptionsBundle mutableOptionsBundle, Config config, Config config2, AutoValue_Config_Option autoValue_Config_Option) {
        if (!Objects.equals(autoValue_Config_Option, ImageOutputConfig.OPTION_RESOLUTION_SELECTOR)) {
            mutableOptionsBundle.insertOption(autoValue_Config_Option, config2.getOptionPriority(autoValue_Config_Option), config2.retrieveOption(autoValue_Config_Option));
            return;
        }
        ResolutionSelector resolutionSelector = (ResolutionSelector) config2.retrieveOption(autoValue_Config_Option, null);
        ResolutionSelector resolutionSelector2 = (ResolutionSelector) config.retrieveOption(autoValue_Config_Option, null);
        Config.OptionPriority optionPriority = config2.getOptionPriority(autoValue_Config_Option);
        if (resolutionSelector == null) {
            resolutionSelector = resolutionSelector2;
        } else if (resolutionSelector2 != null) {
            SurfaceRequest.AnonymousClass1 anonymousClass1 = new SurfaceRequest.AnonymousClass1(18, false);
            anonymousClass1.val$requestCancellationCompleter = resolutionSelector2.mAspectRatioStrategy;
            anonymousClass1.val$requestCancellationFuture = resolutionSelector2.mResolutionStrategy;
            AspectRatioStrategy aspectRatioStrategy = resolutionSelector.mAspectRatioStrategy;
            if (aspectRatioStrategy != null) {
                anonymousClass1.val$requestCancellationCompleter = aspectRatioStrategy;
            }
            ResolutionStrategy resolutionStrategy = resolutionSelector.mResolutionStrategy;
            if (resolutionStrategy != null) {
                anonymousClass1.val$requestCancellationFuture = resolutionStrategy;
            }
            resolutionSelector = new ResolutionSelector((AspectRatioStrategy) anonymousClass1.val$requestCancellationCompleter, (ResolutionStrategy) anonymousClass1.val$requestCancellationFuture, null);
        }
        mutableOptionsBundle.insertOption(autoValue_Config_Option, optionPriority, resolutionSelector);
    }

    public static String $default$getTargetName(UseCaseConfig useCaseConfig) {
        return (String) useCaseConfig.retrieveOption(TargetConfig.OPTION_TARGET_NAME);
    }

    public static int m(float f, int i, int i2) {
        return (Float.floatToIntBits(f) + i) * i2;
    }

    public static int m(int i, int i2, int i3) {
        return (CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i) + i2) * i3;
    }

    public static int m(int i, int i2, long j) {
        return (ULong.m831hashCodeimpl(j) + i) * i2;
    }

    public static ClassCastException m(Object obj) {
        obj.getClass();
        return new ClassCastException();
    }

    public static String m(String str, int i) {
        return str + i;
    }

    public static String m(String str, String str2) {
        return str + str2;
    }

    public static String m(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String m(StringBuilder sb, float f, char c) {
        sb.append(f);
        sb.append(c);
        return sb.toString();
    }

    public static String m(StringBuilder sb, int i, char c) {
        sb.append(i);
        sb.append(c);
        return sb.toString();
    }

    public static String m(StringBuilder sb, int i, String str) {
        sb.append(i);
        sb.append(str);
        return sb.toString();
    }

    public static String m(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static StringBuilder m(int i, String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i);
        sb.append(str2);
        return sb;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static StringBuilder m16m(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    public static void m(int i, GapComposer gapComposer, ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$1, GapComposer gapComposer2, OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1) {
        Stack.m295setimpl(gapComposer, Integer.valueOf(i), composeUiNode$Companion$SetModifier$1);
        Stack.m294reconcileimpl(gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
    }

    public static void m(long j, StringBuilder sb, String str) {
        sb.append((Object) Color.m441toStringimpl(j));
        sb.append(str);
    }

    public static void m(MenuHostHelper menuHostHelper, long j) {
        menuHostHelper.getCanvas().restore();
        menuHostHelper.m758setSizeuvyYCjk(j);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ boolean m17m(Object obj) {
        return obj != null;
    }
}
