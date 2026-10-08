package com.github.kr328.clash.compose.util;

import androidx.compose.material3.TextFieldLabelPosition$Attached;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.focus.FocusStateImpl;
import androidx.compose.ui.geometry.Size;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TvGlassTabRowKt$$ExternalSyntheticLambda6 implements Function1 {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ Function0 f$0;
    public final /* synthetic */ MutableState f$1;

    public /* synthetic */ TvGlassTabRowKt$$ExternalSyntheticLambda6(TextFieldLabelPosition$Attached textFieldLabelPosition$Attached, Function0 function0, MutableState mutableState) {
        this.f$0 = function0;
        this.f$1 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                FocusStateImpl focusStateImpl = (FocusStateImpl) obj;
                this.f$1.setValue(Boolean.valueOf(focusStateImpl.isFocused()));
                if (focusStateImpl.isFocused()) {
                    this.f$0.invoke();
                }
                break;
            default:
                Size size = (Size) obj;
                float fFloatValue = ((Number) this.f$0.invoke()).floatValue();
                float fIntBitsToFloat = Float.intBitsToFloat((int) (size.packedValue >> 32)) * fFloatValue;
                float fIntBitsToFloat2 = Float.intBitsToFloat((int) (size.packedValue & 4294967295L)) * fFloatValue;
                MutableState mutableState = this.f$1;
                if (Float.intBitsToFloat((int) (((Size) mutableState.getValue()).packedValue >> 32)) != fIntBitsToFloat || Float.intBitsToFloat((int) (((Size) mutableState.getValue()).packedValue & 4294967295L)) != fIntBitsToFloat2) {
                    mutableState.setValue(new Size((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L)));
                }
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ TvGlassTabRowKt$$ExternalSyntheticLambda6(Function0 function0, MutableState mutableState) {
        this.f$0 = function0;
        this.f$1 = mutableState;
    }
}
