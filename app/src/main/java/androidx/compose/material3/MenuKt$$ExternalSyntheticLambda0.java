package androidx.compose.material3;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda4;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.platform.DelegatingSoftwareKeyboardController;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import coil.request.RequestService;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MenuKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;

    public /* synthetic */ MenuKt$$ExternalSyntheticLambda0(LegacyTextFieldState legacyTextFieldState, FocusRequester focusRequester, boolean z, TextFieldSelectionManager textFieldSelectionManager, OffsetMapping offsetMapping) {
        this.f$1 = legacyTextFieldState;
        this.f$2 = focusRequester;
        this.f$0 = z;
        this.f$3 = textFieldSelectionManager;
        this.f$4 = offsetMapping;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        float fFloatValue;
        switch (this.$r8$classId) {
            case 0:
                ParcelableSnapshotMutableState parcelableSnapshotMutableState = ((MutableTransitionState) this.f$1).targetState$delegate;
                MutableState mutableState = (MutableState) this.f$2;
                State state = (State) this.f$3;
                State state2 = (State) this.f$4;
                ReusableGraphicsLayerScope reusableGraphicsLayerScope = (ReusableGraphicsLayerScope) obj;
                boolean z = this.f$0;
                float fFloatValue2 = 0.8f;
                float fFloatValue3 = 1.0f;
                if (z) {
                    fFloatValue = ((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue() ? 1.0f : 0.8f;
                } else {
                    fFloatValue = ((Number) state.getValue()).floatValue();
                }
                reusableGraphicsLayerScope.setScaleX(fFloatValue);
                if (!z) {
                    fFloatValue2 = ((Number) state.getValue()).floatValue();
                } else if (((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue()) {
                    fFloatValue2 = 1.0f;
                }
                reusableGraphicsLayerScope.setScaleY(fFloatValue2);
                if (!z) {
                    fFloatValue3 = ((Number) state2.getValue()).floatValue();
                } else if (!((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue()) {
                    fFloatValue3 = 0.0f;
                }
                reusableGraphicsLayerScope.setAlpha(fFloatValue3);
                reusableGraphicsLayerScope.m450setTransformOrigin__ExYCQ(((TransformOrigin) mutableState.getValue()).packedValue);
                break;
            default:
                LegacyTextFieldState legacyTextFieldState = (LegacyTextFieldState) this.f$1;
                FocusRequester focusRequester = (FocusRequester) this.f$2;
                TextFieldSelectionManager textFieldSelectionManager = (TextFieldSelectionManager) this.f$3;
                OffsetMapping offsetMapping = (OffsetMapping) this.f$4;
                Offset offset = (Offset) obj;
                if (legacyTextFieldState.getHasFocus()) {
                    SoftwareKeyboardController softwareKeyboardController = legacyTextFieldState.keyboardController;
                    if (softwareKeyboardController != null) {
                        ((DelegatingSoftwareKeyboardController) softwareKeyboardController).show();
                    }
                } else {
                    FocusRequester.m349requestFocus3ESFkO8$default(focusRequester);
                }
                if (legacyTextFieldState.getHasFocus() && this.f$0) {
                    if (legacyTextFieldState.getHandleState() != HandleState.Selection) {
                        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
                        if (layoutResult != null) {
                            long j = offset.packedValue;
                            RequestService requestService = legacyTextFieldState.processor;
                            CoreTextFieldKt$$ExternalSyntheticLambda4 coreTextFieldKt$$ExternalSyntheticLambda4 = legacyTextFieldState.onValueChange;
                            int iTransformedToOriginal = offsetMapping.transformedToOriginal(layoutResult.m178getOffsetForPosition3MmeM6k(j, true));
                            coreTextFieldKt$$ExternalSyntheticLambda4.invoke(TextFieldValue.m663copy3r_uNRQ$default((TextFieldValue) requestService.systemCallbacks, null, ParagraphKt.TextRange(iTransformedToOriginal, iTransformedToOriginal), 5));
                            if (legacyTextFieldState.textDelegate.text.text.length() > 0) {
                                legacyTextFieldState.handleState$delegate.setValue(HandleState.Cursor);
                            }
                        }
                    } else {
                        textFieldSelectionManager.m230deselect_kEHs6E$foundation(offset);
                    }
                }
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ MenuKt$$ExternalSyntheticLambda0(boolean z, MutableTransitionState mutableTransitionState, MutableState mutableState, Transition.TransitionAnimationState transitionAnimationState, Transition.TransitionAnimationState transitionAnimationState2) {
        this.f$0 = z;
        this.f$1 = mutableTransitionState;
        this.f$2 = mutableState;
        this.f$3 = transitionAnimationState;
        this.f$4 = transitionAnimationState2;
    }
}
