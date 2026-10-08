package androidx.activity.compose;

import android.os.Handler;
import android.os.Looper;
import androidx.activity.ImmLeaksCleaner$$ExternalSyntheticLambda0;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.compose.internal.BackHandlerDispatcherCompat;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.core.os.HandlerCompat;
import androidx.lifecycle.compose.LifecycleEffectKt;
import androidx.navigationevent.NavigationEventDispatcherOwner;
import androidx.navigationevent.compose.LocalNavigationEventDispatcherOwner;
import dev.chrisbanes.haze.HazeStyle;
import dev.chrisbanes.haze.HazeTint;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class BackHandlerKt {
    public static volatile Handler sHandler;

    public static final void BackHandler(boolean z, Function0 function0, GapComposer gapComposer, int i) {
        gapComposer.startRestartGroup(-361453782);
        int i2 = (gapComposer.changed(z) ? 4 : 2) | i;
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(function0) ? 32 : 16;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            NavigationEventDispatcherOwner current = LocalNavigationEventDispatcherOwner.getCurrent(gapComposer);
            OnBackPressedDispatcherOwner current2 = LocalOnBackPressedDispatcherOwner.getCurrent(gapComposer);
            Object obj = current == null ? current2 : current;
            if (obj == null) {
                throw new IllegalArgumentException("No NavigationEventDispatcherOwner was provided via LocalNavigationEventDispatcherOwner and no OnBackPressedDispatcherOwner was provided via LocalOnBackPressedDispatcherOwner. Please provide one of the two.");
            }
            Object objRememberedValue = gapComposer.rememberedValue();
            Object obj2 = Composer$Companion.Empty;
            if (objRememberedValue == obj2) {
                objRememberedValue = new BackHandlerDispatcherCompat(current != null ? current.getNavigationEventDispatcher() : null, current2 != null ? current2.getOnBackPressedDispatcher() : null);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Object obj3 = (BackHandlerDispatcherCompat) objRememberedValue;
            long j = gapComposer.compositeKeyHashCode;
            boolean zChanged = gapComposer.changed(obj3) | gapComposer.changed(j);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            Object obj4 = objRememberedValue2;
            if (zChanged || objRememberedValue2 == obj2) {
                ComposeBackHandler composeBackHandler = new ComposeBackHandler(new BackHandlerInfo(j, obj));
                composeBackHandler.currentOnBackCompleted = new ImmLeaksCleaner$$ExternalSyntheticLambda0(2);
                gapComposer.updateRememberedValue(composeBackHandler);
                obj4 = composeBackHandler;
            }
            ComposeBackHandler composeBackHandler2 = (ComposeBackHandler) obj4;
            gapComposer.startReplaceGroup(-585289004);
            boolean zChangedInstance = gapComposer.changedInstance(composeBackHandler2) | ((i2 & 112) == 32);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == obj2) {
                objRememberedValue3 = new Recomposer$$ExternalSyntheticLambda6(1, composeBackHandler2, function0);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            Stack.SideEffect((Function0) objRememberedValue3, gapComposer);
            int i3 = i2;
            Boolean boolValueOf = Boolean.valueOf(z);
            int i4 = i3 & 14;
            boolean zChangedInstance2 = gapComposer.changedInstance(composeBackHandler2) | (i4 == 4);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue4 == obj2) {
                objRememberedValue4 = new BackHandlerKt$$ExternalSyntheticLambda1(composeBackHandler2, z, 0);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            LifecycleEffectKt.LifecycleStartEffect(boolValueOf, composeBackHandler2, null, (Function1) objRememberedValue4, gapComposer, i4);
            boolean zChangedInstance3 = gapComposer.changedInstance(obj3) | gapComposer.changedInstance(composeBackHandler2);
            Object objRememberedValue5 = gapComposer.rememberedValue();
            if (zChangedInstance3 || objRememberedValue5 == obj2) {
                objRememberedValue5 = new BackHandlerKt$$ExternalSyntheticLambda2(0, obj3, composeBackHandler2);
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            Stack.DisposableEffect(obj3, composeBackHandler2, (Function1) objRememberedValue5, gapComposer);
            gapComposer.end(false);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new BackHandlerKt$$ExternalSyntheticLambda3(i, 0, function0, z);
        }
    }

    public static Handler getInstance() {
        if (sHandler != null) {
            return sHandler;
        }
        synchronized (BackHandlerKt.class) {
            try {
                if (sHandler == null) {
                    sHandler = HandlerCompat.createAsync(Looper.getMainLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sHandler;
    }

    /* JADX INFO: renamed from: hazeMaterial-ek8zF_U, reason: not valid java name */
    public static HazeStyle m5hazeMaterialek8zF_U(float f, float f2, long j) {
        float f3 = 24;
        if (BrushKt.m421luminance8_81llA(j) < 0.5d) {
            f = f2;
        }
        return new HazeStyle(j, new HazeTint(BrushKt.Color(Color.m440getRedimpl(j), Color.m439getGreenimpl(j), Color.m437getBlueimpl(j), f, Color.m438getColorSpaceimpl(j))), f3, 24);
    }

    /* JADX INFO: renamed from: thin-Iv8Zu3U, reason: not valid java name */
    public static HazeStyle m6thinIv8Zu3U(GapComposer gapComposer) {
        return m5hazeMaterialek8zF_U(0.6f, 0.65f, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.surface);
    }
}
