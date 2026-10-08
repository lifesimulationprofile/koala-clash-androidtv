package androidx.compose.animation.core;

import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Dp;
import com.github.kr328.clash.FilesActivity$Content$1$1;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AnimateAsStateKt {
    public static final SpringSpec defaultAnimation = ArcSplineKt.spring$default(0.0f, 0.0f, null, 7);

    static {
        Object obj = VisibilityThresholdsKt.VisibilityThresholdMap;
        ArcSplineKt.spring$default(0.0f, 0.0f, new Dp(0.4f), 3);
        Float.floatToRawIntBits(1.0f);
        Float.floatToRawIntBits(1.0f);
        Float.floatToRawIntBits(1.0f);
        Float.floatToRawIntBits(1.0f);
    }

    /* JADX INFO: renamed from: animateDpAsState-AjpBEmI, reason: not valid java name */
    public static final State m27animateDpAsStateAjpBEmI(float f, FiniteAnimationSpec finiteAnimationSpec, GapComposer gapComposer, int i, int i2) {
        return animateValueAsState(new Dp(f), ArcSplineKt.DpToVector, finiteAnimationSpec, null, (i2 & 4) != 0 ? "DpAnimation" : "indicator-border-width", gapComposer, ((i << 3) & 896) | ((i << 6) & 57344), 8);
    }

    public static final State animateFloatAsState(float f, FiniteAnimationSpec finiteAnimationSpec, String str, GapComposer gapComposer, int i) {
        if (finiteAnimationSpec == defaultAnimation) {
            gapComposer.startReplaceGroup(1144115775);
            boolean zChanged = gapComposer.changed(0.01f);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue == Composer$Companion.Empty) {
                objRememberedValue = ArcSplineKt.spring$default(0.0f, 0.0f, Float.valueOf(0.01f), 3);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            finiteAnimationSpec = (SpringSpec) objRememberedValue;
            gapComposer.end(false);
        } else {
            gapComposer.startReplaceGroup(1144225701);
            gapComposer.end(false);
        }
        return animateValueAsState(Float.valueOf(f), ArcSplineKt.FloatToVector, finiteAnimationSpec, null, str, gapComposer, 24576, 0);
    }

    public static final State animateValueAsState(Object obj, TwoWayConverterImpl twoWayConverterImpl, AnimationSpec animationSpec, Float f, String str, GapComposer gapComposer, int i, int i2) {
        if ((i2 & 8) != 0) {
            f = null;
        }
        Object objRememberedValue = gapComposer.rememberedValue();
        Object obj2 = Composer$Companion.Empty;
        if (objRememberedValue == obj2) {
            objRememberedValue = Stack.mutableStateOf$default(null);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        MutableState mutableState = (MutableState) objRememberedValue;
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (objRememberedValue2 == obj2) {
            objRememberedValue2 = new Animatable(obj, twoWayConverterImpl, f);
            gapComposer.updateRememberedValue(objRememberedValue2);
        }
        Animatable animatable = (Animatable) objRememberedValue2;
        MutableState mutableStateRememberUpdatedState = Stack.rememberUpdatedState(null, gapComposer);
        if (f != null && (animationSpec instanceof SpringSpec)) {
            SpringSpec springSpec = (SpringSpec) animationSpec;
            if (!Intrinsics.areEqual(springSpec.visibilityThreshold, f)) {
                animationSpec = new SpringSpec(springSpec.dampingRatio, springSpec.stiffness, f);
            }
        }
        MutableState mutableStateRememberUpdatedState2 = Stack.rememberUpdatedState(animationSpec, gapComposer);
        Object objRememberedValue3 = gapComposer.rememberedValue();
        if (objRememberedValue3 == obj2) {
            objRememberedValue3 = ChannelKt.Channel$default(-1, 0, 6);
            gapComposer.updateRememberedValue(objRememberedValue3);
        }
        Channel channel = (Channel) objRememberedValue3;
        boolean zChangedInstance = gapComposer.changedInstance(channel) | gapComposer.changedInstance(obj);
        Object objRememberedValue4 = gapComposer.rememberedValue();
        if (zChangedInstance || objRememberedValue4 == obj2) {
            objRememberedValue4 = new Recomposer$$ExternalSyntheticLambda6(3, channel, obj);
            gapComposer.updateRememberedValue(objRememberedValue4);
        }
        Stack.SideEffect((Function0) objRememberedValue4, gapComposer);
        boolean zChangedInstance2 = gapComposer.changedInstance(channel) | gapComposer.changedInstance(animatable) | gapComposer.changed(mutableStateRememberUpdatedState2) | gapComposer.changed(mutableStateRememberUpdatedState);
        Object objRememberedValue5 = gapComposer.rememberedValue();
        if (zChangedInstance2 || objRememberedValue5 == obj2) {
            Object filesActivity$Content$1$1 = new FilesActivity$Content$1$1(channel, animatable, mutableStateRememberUpdatedState2, mutableStateRememberUpdatedState, (Continuation) null);
            gapComposer.updateRememberedValue(filesActivity$Content$1$1);
            objRememberedValue5 = filesActivity$Content$1$1;
        }
        Stack.LaunchedEffect(gapComposer, channel, (Function2) objRememberedValue5);
        State state = (State) mutableState.getValue();
        return state == null ? animatable.internalState : state;
    }
}
