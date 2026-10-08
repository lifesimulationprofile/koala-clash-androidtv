package com.github.kr328.clash.design.compose.components;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.focus.FocusStateImpl;
import coil.compose.AsyncImagePainter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PreferencesKt$$ExternalSyntheticLambda9 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ MutableState f$0;

    public /* synthetic */ PreferencesKt$$ExternalSyntheticLambda9(MutableState mutableState, int i) {
        this.$r8$classId = i;
        this.f$0 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                this.f$0.setValue(Boolean.valueOf(((FocusStateImpl) obj).isFocused()));
                break;
            default:
                if (((AsyncImagePainter.State) obj) instanceof AsyncImagePainter.State.Error) {
                    this.f$0.setValue(Boolean.TRUE);
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
