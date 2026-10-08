package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.tokens.RadioButtonTokens;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.semantics.Role;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class RadioButtonKt {
    public static final float RadioButtonDotSize = 12;
    public static final float RadioButtonPadding;
    public static final float RadioStrokeWidth;

    static {
        float f = 2;
        RadioButtonPadding = f;
        RadioStrokeWidth = f;
    }

    public static final void RadioButton(boolean z, Function0 function0, Modifier modifier, boolean z2, RadioButtonColors radioButtonColors, GapComposer gapComposer, int i) {
        Modifier modifier2;
        boolean z3;
        boolean z4;
        Modifier modifier3;
        long j;
        boolean z5;
        State state;
        State stateRememberUpdatedState;
        gapComposer.startRestartGroup(408580840);
        int i2 = i | (gapComposer.changed(z) ? 4 : 2) | (gapComposer.changedInstance(function0) ? 32 : 16) | 3456 | (gapComposer.changed(radioButtonColors) ? 16384 : 8192) | 196608;
        if (gapComposer.shouldExecute(i2 & 1, (74899 & i2) != 74898)) {
            gapComposer.startDefaults();
            int i3 = i & 1;
            Modifier modifier4 = Modifier.Companion.$$INSTANCE;
            if (i3 == 0 || gapComposer.getDefaultsInvalid()) {
                z4 = true;
                modifier3 = modifier4;
            } else {
                gapComposer.skipToGroupEnd();
                modifier3 = modifier;
                z4 = z2;
            }
            gapComposer.endDefaults();
            State stateM27animateDpAsStateAjpBEmI = AnimateAsStateKt.m27animateDpAsStateAjpBEmI(z ? RadioButtonDotSize / 2 : 0, ScrimKt.value(2, gapComposer), gapComposer, 0, 12);
            if (z4 && z) {
                j = radioButtonColors.selectedColor;
            } else if (!z4 || z) {
                j = (z4 || !z) ? radioButtonColors.disabledUnselectedColor : radioButtonColors.disabledSelectedColor;
            } else {
                j = radioButtonColors.unselectedColor;
            }
            if (z4) {
                gapComposer.startReplaceGroup(1194671677);
                z5 = z4;
                state = stateM27animateDpAsStateAjpBEmI;
                stateRememberUpdatedState = SingleValueAnimationKt.m26animateColorAsStateeuL9pac(j, ScrimKt.value(4, gapComposer), null, gapComposer, 0, 12);
                gapComposer.end(false);
            } else {
                z5 = z4;
                state = stateM27animateDpAsStateAjpBEmI;
                gapComposer.startReplaceGroup(1194849338);
                stateRememberUpdatedState = Stack.rememberUpdatedState(new Color(j), gapComposer);
                gapComposer.end(false);
            }
            Modifier modifierM154selectableO2vRcR0 = function0 != null ? SelectableKt.m154selectableO2vRcR0(z, RippleKt.m260rippleOu1YvPQ$default(RadioButtonTokens.StateLayerSize / 2, 0L, RoundedCornerShapeKt.CircleShape, false, 244), z5, new Role(3), function0) : modifier4;
            if (function0 != null) {
                HorizontalAlignmentLine horizontalAlignmentLine = InteractiveComponentSizeKt.MinimumInteractiveTopAlignmentLine;
                modifier4 = MinimumInteractiveModifier.INSTANCE;
            }
            Modifier modifierM137requiredSize3ABfNKs = SizeKt.m137requiredSize3ABfNKs(OffsetKt.m128padding3ABfNKs(SizeKt.wrapContentSize$default(modifier3.then(modifier4).then(modifierM154selectableO2vRcR0)), RadioButtonPadding), RadioButtonTokens.IconSize);
            boolean zChanged = gapComposer.changed(stateRememberUpdatedState) | gapComposer.changed(state);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue == Composer$Companion.Empty) {
                objRememberedValue = new TooltipKt$$ExternalSyntheticLambda9(stateRememberUpdatedState, state, 1);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            ImageKt.Canvas(modifierM137requiredSize3ABfNKs, (Function1) objRememberedValue, gapComposer, 0);
            z3 = z5;
            modifier2 = modifier3;
        } else {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
            z3 = z2;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new SwitchKt$$ExternalSyntheticLambda0(z, function0, modifier2, z3, radioButtonColors, i, 3);
        }
    }
}
