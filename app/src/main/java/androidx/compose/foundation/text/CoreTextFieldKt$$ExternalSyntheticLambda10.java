package androidx.compose.foundation.text;

import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuModifierKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CoreTextFieldKt$$ExternalSyntheticLambda10 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ TextFieldSelectionManager f$0;

    public /* synthetic */ CoreTextFieldKt$$ExternalSyntheticLambda10(TextFieldSelectionManager textFieldSelectionManager, int i) {
        this.$r8$classId = i;
        this.f$0 = textFieldSelectionManager;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x011e  */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Rect rect;
        LayoutCoordinates layoutCoordinates;
        char c;
        float fIntBitsToFloat;
        LayoutCoordinates layoutCoordinates2;
        LayoutCoordinates layoutCoordinates3;
        LayoutCoordinates layoutCoordinates4;
        LayoutCoordinates layoutCoordinates5;
        int i = this.$r8$classId;
        TextFieldSelectionManager textFieldSelectionManager = this.f$0;
        switch (i) {
            case 0:
                return new AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1(6, textFieldSelectionManager);
            case 1:
                textFieldSelectionManager.showSelectionToolbar$foundation();
                return Unit.INSTANCE;
            default:
                LayoutCoordinates layoutCoordinates6 = (LayoutCoordinates) obj;
                LegacyTextFieldState legacyTextFieldState = textFieldSelectionManager.state;
                if (legacyTextFieldState == null) {
                    rect = Rect.Zero;
                } else {
                    if (legacyTextFieldState.isLayoutResultStale) {
                        legacyTextFieldState = null;
                    }
                    if (legacyTextFieldState != null) {
                        OffsetMapping offsetMapping = textFieldSelectionManager.offsetMapping;
                        long j = textFieldSelectionManager.getValue$foundation().selection;
                        int i2 = TextRange.$r8$clinit;
                        int iOriginalToTransformed = offsetMapping.originalToTransformed((int) (j >> 32));
                        int iOriginalToTransformed2 = textFieldSelectionManager.offsetMapping.originalToTransformed((int) (textFieldSelectionManager.getValue$foundation().selection & 4294967295L));
                        LegacyTextFieldState legacyTextFieldState2 = textFieldSelectionManager.state;
                        long jMo525localToRootMKHz9U = 0;
                        long jMo525localToRootMKHz9U2 = (legacyTextFieldState2 == null || (layoutCoordinates5 = legacyTextFieldState2.getLayoutCoordinates()) == null) ? 0L : layoutCoordinates5.mo525localToRootMKHz9U(textFieldSelectionManager.m232getHandlePositiontuRUvjQ$foundation(true));
                        LegacyTextFieldState legacyTextFieldState3 = textFieldSelectionManager.state;
                        if (legacyTextFieldState3 != null && (layoutCoordinates4 = legacyTextFieldState3.getLayoutCoordinates()) != null) {
                            jMo525localToRootMKHz9U = layoutCoordinates4.mo525localToRootMKHz9U(textFieldSelectionManager.m232getHandlePositiontuRUvjQ$foundation(false));
                        }
                        LegacyTextFieldState legacyTextFieldState4 = textFieldSelectionManager.state;
                        float fIntBitsToFloat2 = 0.0f;
                        if (legacyTextFieldState4 == null || (layoutCoordinates3 = legacyTextFieldState4.getLayoutCoordinates()) == null) {
                            c = ' ';
                            fIntBitsToFloat = 0.0f;
                        } else {
                            TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
                            c = ' ';
                            fIntBitsToFloat = Float.intBitsToFloat((int) (layoutCoordinates3.mo525localToRootMKHz9U((((long) Float.floatToRawIntBits(layoutResult != null ? layoutResult.value.getCursorRect(iOriginalToTransformed).top : 0.0f)) & 4294967295L) | (((long) Float.floatToRawIntBits(0.0f)) << 32)) & 4294967295L));
                        }
                        LegacyTextFieldState legacyTextFieldState5 = textFieldSelectionManager.state;
                        if (legacyTextFieldState5 != null && (layoutCoordinates2 = legacyTextFieldState5.getLayoutCoordinates()) != null) {
                            TextLayoutResultProxy layoutResult2 = legacyTextFieldState.getLayoutResult();
                            fIntBitsToFloat2 = Float.intBitsToFloat((int) (layoutCoordinates2.mo525localToRootMKHz9U((((long) Float.floatToRawIntBits(0.0f)) << c) | (((long) Float.floatToRawIntBits(layoutResult2 != null ? layoutResult2.value.getCursorRect(iOriginalToTransformed2).top : 0.0f)) & 4294967295L)) & 4294967295L));
                        }
                        int i3 = (int) (jMo525localToRootMKHz9U2 >> c);
                        int i4 = (int) (jMo525localToRootMKHz9U >> c);
                        rect = new Rect(Math.min(Float.intBitsToFloat(i3), Float.intBitsToFloat(i4)), Math.min(fIntBitsToFloat, fIntBitsToFloat2), Math.max(Float.intBitsToFloat(i3), Float.intBitsToFloat(i4)), (legacyTextFieldState.textDelegate.density.getDensity() * 25) + Math.max(Float.intBitsToFloat((int) (jMo525localToRootMKHz9U2 & 4294967295L)), Float.intBitsToFloat((int) (jMo525localToRootMKHz9U & 4294967295L))));
                    } else {
                        rect = Rect.Zero;
                    }
                }
                LegacyTextFieldState legacyTextFieldState6 = textFieldSelectionManager.state;
                if (legacyTextFieldState6 == null || (layoutCoordinates = legacyTextFieldState6.getLayoutCoordinates()) == null) {
                    return null;
                }
                return TextContextMenuModifierKt.translateRootToDestination(rect, layoutCoordinates, layoutCoordinates6);
        }
    }
}
