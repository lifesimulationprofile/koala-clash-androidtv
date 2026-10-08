package androidx.compose.material3;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.material3.internal.DropdownMenuPositionProvider;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AndroidMenu_androidKt {
    public static final PopupProperties DefaultMenuProperties = new PopupProperties(30, true);

    /* JADX INFO: renamed from: DropdownMenu-IlH_yew, reason: not valid java name */
    public static final void m236DropdownMenuIlH_yew(final boolean z, final Function0 function0, Modifier modifier, long j, ScrollState scrollState, PopupProperties popupProperties, final Shape shape, final long j2, float f, float f2, final ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, final int i) {
        int i2;
        Function0 function1;
        final Modifier modifier2;
        final long j3;
        final ScrollState scrollState2;
        final PopupProperties popupProperties2;
        final float f3;
        final float f4;
        ScrollState scrollStateRememberScrollState;
        int i3;
        long j4;
        float f5;
        float f6;
        PopupProperties popupProperties3;
        Modifier modifier3;
        MutableState mutableState;
        ScrollState scrollState3;
        gapComposer.startRestartGroup(1725609375);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            function1 = function0;
            i2 |= gapComposer.changedInstance(function1) ? 32 : 16;
        } else {
            function1 = function0;
        }
        int i4 = i2 | 3456;
        if ((i & 24576) == 0) {
            i4 = i2 | 11648;
        }
        int i5 = 196608 | i4;
        if ((1572864 & i) == 0) {
            i5 |= gapComposer.changed(shape) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i5 |= gapComposer.changed(j2) ? 8388608 : 4194304;
        }
        int i6 = i5 | 905969664;
        if (gapComposer.shouldExecute(i6 & 1, (306783379 & i6) != 306783378)) {
            gapComposer.startDefaults();
            if ((i & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                float f7 = 0;
                long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(f7)) & 4294967295L) | (((long) Float.floatToRawIntBits(f7)) << 32);
                scrollStateRememberScrollState = ImageKt.rememberScrollState(gapComposer);
                i3 = i6 & (-57345);
                float f8 = MenuDefaults.TonalElevation;
                float f9 = MenuDefaults.ShadowElevation;
                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                j4 = jFloatToRawIntBits;
                f5 = f8;
                f6 = f9;
                popupProperties3 = DefaultMenuProperties;
                modifier3 = companion;
            } else {
                gapComposer.skipToGroupEnd();
                i3 = i6 & (-57345);
                modifier3 = modifier;
                j4 = j;
                scrollStateRememberScrollState = scrollState;
                popupProperties3 = popupProperties;
                f5 = f;
                f6 = f2;
            }
            gapComposer.endDefaults();
            Object objRememberedValue = gapComposer.rememberedValue();
            Object obj = Composer$Companion.Empty;
            if (objRememberedValue == obj) {
                objRememberedValue = new MutableTransitionState(Boolean.FALSE);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            MutableTransitionState mutableTransitionState = (MutableTransitionState) objRememberedValue;
            mutableTransitionState.targetState$delegate.setValue(Boolean.valueOf(z));
            if (((Boolean) mutableTransitionState.currentState$delegate.getValue()).booleanValue() || ((Boolean) mutableTransitionState.targetState$delegate.getValue()).booleanValue()) {
                gapComposer.startReplaceGroup(1165893498);
                Object objRememberedValue2 = gapComposer.rememberedValue();
                if (objRememberedValue2 == obj) {
                    objRememberedValue2 = Stack.mutableStateOf$default(new TransformOrigin(TransformOrigin.Center));
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                MutableState mutableState2 = (MutableState) objRememberedValue2;
                Density density = (Density) gapComposer.consume(CompositionLocalsKt.LocalDensity);
                boolean zChanged = ((i3 & 7168) == 2048) | gapComposer.changed(density);
                Object objRememberedValue3 = gapComposer.rememberedValue();
                if (zChanged || objRememberedValue3 == obj) {
                    mutableState = mutableState2;
                    objRememberedValue3 = new DropdownMenuPositionProvider(mutableState, j4, density, new AndroidMenu_androidKt$$ExternalSyntheticLambda0(mutableState2, 0));
                    gapComposer.updateRememberedValue(objRememberedValue3);
                } else {
                    mutableState = mutableState2;
                }
                scrollState3 = scrollStateRememberScrollState;
                AndroidPopup_androidKt.Popup((DropdownMenuPositionProvider) objRememberedValue3, function1, popupProperties3, Thread_jvmKt.rememberComposableLambda(-917492520, new MenuKt$$ExternalSyntheticLambda2(modifier3, mutableTransitionState, mutableState, scrollState3, shape, j2, f5, f6, composableLambdaImpl), gapComposer), gapComposer, ((i3 >> 9) & 896) | (i3 & 112) | 3072, 0);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(1167162979);
                gapComposer.end(false);
                j4 = j4;
                scrollState3 = scrollStateRememberScrollState;
            }
            popupProperties2 = popupProperties3;
            modifier2 = modifier3;
            scrollState2 = scrollState3;
            f3 = f5;
            f4 = f6;
            j3 = j4;
        } else {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
            j3 = j;
            scrollState2 = scrollState;
            popupProperties2 = popupProperties;
            f3 = f;
            f4 = f2;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.AndroidMenu_androidKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    ((Integer) obj3).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                    AndroidMenu_androidKt.m236DropdownMenuIlH_yew(z, function0, modifier2, j3, scrollState2, popupProperties2, shape, j2, f3, f4, composableLambdaImpl, (GapComposer) obj2, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
