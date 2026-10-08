package com.github.kr328.clash.compose.qrcode;

import androidx.compose.material3.BottomSheetKt$BottomSheetImpl$6$1$1$1$1;
import androidx.compose.material3.SheetState;
import com.github.kr328.clash.compose.newprofile.NewProfileViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.StandaloneCoroutine;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TvQrCodeSheetKt$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ CoroutineScope f$0;
    public final /* synthetic */ SheetState f$1;
    public final /* synthetic */ NewProfileViewModel f$2;
    public final /* synthetic */ Function0 f$3;

    public /* synthetic */ TvQrCodeSheetKt$$ExternalSyntheticLambda0(CoroutineScope coroutineScope, SheetState sheetState, NewProfileViewModel newProfileViewModel, Function0 function0, int i) {
        this.$r8$classId = i;
        this.f$0 = coroutineScope;
        this.f$1 = sheetState;
        this.f$2 = newProfileViewModel;
        this.f$3 = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                final SheetState sheetState = this.f$1;
                StandaloneCoroutine standaloneCoroutineLaunch$default = JobKt.launch$default(this.f$0, null, new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(sheetState, null, 14), 3);
                final int i = 0;
                final NewProfileViewModel newProfileViewModel = this.f$2;
                final Function0 function0 = this.f$3;
                standaloneCoroutineLaunch$default.invokeOnCompletion(new Function1() { // from class: com.github.kr328.clash.compose.qrcode.TvQrCodeSheetKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        switch (i) {
                            case 0:
                                if (!sheetState.isVisible()) {
                                    newProfileViewModel.reset();
                                    function0.invoke();
                                }
                                break;
                            default:
                                if (!sheetState.isVisible()) {
                                    newProfileViewModel.reset();
                                    function0.invoke();
                                }
                                break;
                        }
                        return Unit.INSTANCE;
                    }
                });
                break;
            default:
                final SheetState sheetState2 = this.f$1;
                StandaloneCoroutine standaloneCoroutineLaunch$default2 = JobKt.launch$default(this.f$0, null, new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(sheetState2, null, 11), 3);
                final int i2 = 1;
                final NewProfileViewModel newProfileViewModel2 = this.f$2;
                final Function0 function1 = this.f$3;
                standaloneCoroutineLaunch$default2.invokeOnCompletion(new Function1() { // from class: com.github.kr328.clash.compose.qrcode.TvQrCodeSheetKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        switch (i2) {
                            case 0:
                                if (!sheetState2.isVisible()) {
                                    newProfileViewModel2.reset();
                                    function1.invoke();
                                }
                                break;
                            default:
                                if (!sheetState2.isVisible()) {
                                    newProfileViewModel2.reset();
                                    function1.invoke();
                                }
                                break;
                        }
                        return Unit.INSTANCE;
                    }
                });
                break;
        }
        return Unit.INSTANCE;
    }
}
