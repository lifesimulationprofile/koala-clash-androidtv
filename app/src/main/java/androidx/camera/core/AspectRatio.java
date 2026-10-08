package androidx.camera.core;

import android.content.Context;
import android.content.ContextWrapper;
import androidx.activity.ImmLeaksCleaner$$ExternalSyntheticLambda0;
import androidx.activity.compose.ActivityResultLauncherHolder;
import androidx.activity.compose.ActivityResultRegistryKt$$ExternalSyntheticLambda1;
import androidx.activity.compose.LocalActivityResultRegistryOwner;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.DisposableEffectImpl;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import io.github.g00fy2.quickie.ScanQRCode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AspectRatio {
    public static final ManagedActivityResultLauncher rememberLauncherForActivityResult(ScanQRCode scanQRCode, Function1 function1, GapComposer gapComposer, int i) {
        Object obj;
        Stack.rememberUpdatedState(scanQRCode, gapComposer);
        Object objRememberUpdatedState = Stack.rememberUpdatedState(function1, gapComposer);
        Object[] objArr = new Object[0];
        Object objRememberedValue = gapComposer.rememberedValue();
        Object obj2 = Composer$Companion.Empty;
        if (objRememberedValue == obj2) {
            objRememberedValue = new ImmLeaksCleaner$$ExternalSyntheticLambda0(1);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        Object obj3 = (String) SaverKt.rememberSaveable(objArr, (Function0) objRememberedValue, gapComposer);
        ActivityResultRegistryOwner activityResultRegistryOwner = (ActivityResultRegistryOwner) gapComposer.consume(LocalActivityResultRegistryOwner.LocalComposition);
        if (activityResultRegistryOwner == null) {
            gapComposer.startReplaceGroup(1213380307);
            Object baseContext = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
            while (true) {
                if (!(baseContext instanceof ContextWrapper)) {
                    baseContext = null;
                    break;
                }
                if (baseContext instanceof ActivityResultRegistryOwner) {
                    break;
                }
                baseContext = ((ContextWrapper) baseContext).getBaseContext();
            }
            activityResultRegistryOwner = (ActivityResultRegistryOwner) baseContext;
        } else {
            gapComposer.startReplaceGroup(1213379439);
        }
        gapComposer.end(false);
        if (activityResultRegistryOwner == null) {
            throw new IllegalStateException("No ActivityResultRegistryOwner was provided via LocalActivityResultRegistryOwner");
        }
        Object activityResultRegistry = activityResultRegistryOwner.getActivityResultRegistry();
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (objRememberedValue2 == obj2) {
            objRememberedValue2 = new ActivityResultLauncherHolder();
            gapComposer.updateRememberedValue(objRememberedValue2);
        }
        ActivityResultLauncherHolder activityResultLauncherHolder = (ActivityResultLauncherHolder) objRememberedValue2;
        Object objRememberedValue3 = gapComposer.rememberedValue();
        if (objRememberedValue3 == obj2) {
            objRememberedValue3 = new ManagedActivityResultLauncher(activityResultLauncherHolder);
            gapComposer.updateRememberedValue(objRememberedValue3);
        }
        ManagedActivityResultLauncher managedActivityResultLauncher = (ManagedActivityResultLauncher) objRememberedValue3;
        boolean zChangedInstance = gapComposer.changedInstance(activityResultLauncherHolder) | gapComposer.changedInstance(activityResultRegistry) | gapComposer.changed(obj3) | gapComposer.changedInstance(scanQRCode) | gapComposer.changed(objRememberUpdatedState);
        Object objRememberedValue4 = gapComposer.rememberedValue();
        if (zChangedInstance || objRememberedValue4 == obj2) {
            obj = scanQRCode;
            objRememberedValue4 = new ActivityResultRegistryKt$$ExternalSyntheticLambda1(activityResultLauncherHolder, activityResultRegistry, obj3, obj, objRememberUpdatedState, 0);
            gapComposer.updateRememberedValue(objRememberedValue4);
        } else {
            obj = scanQRCode;
        }
        Function1 function2 = (Function1) objRememberedValue4;
        boolean zChanged = gapComposer.changed(activityResultRegistry) | gapComposer.changed(obj3) | gapComposer.changed(obj);
        Object objRememberedValue5 = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue5 == obj2) {
            objRememberedValue5 = new DisposableEffectImpl(function2);
            gapComposer.updateRememberedValue(objRememberedValue5);
        }
        return managedActivityResultLauncher;
    }

    public static int zza(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
                return 7;
            case 7:
                return 8;
            case 8:
                return 9;
            case 9:
                return 10;
            case 10:
                return 11;
            case 11:
                return 12;
            case 12:
                return 13;
            case 13:
                return 14;
            default:
                return 0;
        }
    }
}
