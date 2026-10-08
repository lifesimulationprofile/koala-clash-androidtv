package androidx.compose.foundation.text;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CoreTextFieldKt$$ExternalSyntheticLambda4 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ LegacyTextFieldState f$0;

    public /* synthetic */ CoreTextFieldKt$$ExternalSyntheticLambda4(LegacyTextFieldState legacyTextFieldState, int i) {
        this.$r8$classId = i;
        this.f$0 = legacyTextFieldState;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                LayoutCoordinates layoutCoordinates = (LayoutCoordinates) obj;
                TextLayoutResultProxy layoutResult = this.f$0.getLayoutResult();
                if (layoutResult != null) {
                    layoutResult.decorationBoxCoordinates = layoutCoordinates;
                }
                return Unit.INSTANCE;
            case 1:
                LegacyTextFieldState legacyTextFieldState = this.f$0;
                ParcelableSnapshotMutableState parcelableSnapshotMutableState = legacyTextFieldState.justAutofilled$delegate;
                TextFieldValue textFieldValue = (TextFieldValue) obj;
                String str = textFieldValue.annotatedString.text;
                AnnotatedString annotatedString = legacyTextFieldState.untransformedText;
                if (!Intrinsics.areEqual(str, annotatedString != null ? annotatedString.text : null)) {
                    legacyTextFieldState.handleState$delegate.setValue(HandleState.None);
                    if (((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue()) {
                        parcelableSnapshotMutableState.setValue(Boolean.FALSE);
                    } else {
                        legacyTextFieldState.autofillHighlightOn$delegate.setValue(Boolean.FALSE);
                    }
                }
                long j = TextRange.Zero;
                legacyTextFieldState.m173setSelectionPreviewHighlightRange5zctL8(j);
                legacyTextFieldState.m172setDeletionPreviewHighlightRange5zctL8(j);
                legacyTextFieldState.onValueChangeOriginal.invoke(textFieldValue);
                legacyTextFieldState.recomposeScope.invalidate();
                return Unit.INSTANCE;
            case 2:
                this.f$0.keyboardActionRunner.m757runActionKlQnJC8(((ImeAction) obj).value);
                return Unit.INSTANCE;
            case 3:
                return Boolean.valueOf(this.f$0.keyboardActionRunner.m757runActionKlQnJC8(((ImeAction) obj).value));
            default:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                this.f$0.isInTouchMode$delegate.setValue(bool);
                return Unit.INSTANCE;
        }
    }
}
