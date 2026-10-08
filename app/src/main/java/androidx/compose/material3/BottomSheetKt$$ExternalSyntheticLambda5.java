package androidx.compose.material3;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BottomSheetKt$$ExternalSyntheticLambda5 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ SheetState f$0;
    public final /* synthetic */ CoroutineScope f$1;
    public final /* synthetic */ Function0 f$2;

    public /* synthetic */ BottomSheetKt$$ExternalSyntheticLambda5(SheetState sheetState, Function0 function0, CoroutineScope coroutineScope) {
        this.$r8$classId = 1;
        this.f$0 = sheetState;
        this.f$2 = function0;
        this.f$1 = coroutineScope;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i = this.$r8$classId;
        SheetValue sheetValue = SheetValue.Hidden;
        Function0 function0 = this.f$2;
        CoroutineScope coroutineScope = this.f$1;
        SheetState sheetState = this.f$0;
        switch (i) {
            case 0:
                if (((Boolean) sheetState.confirmValueChange.invoke(sheetValue)).booleanValue()) {
                    JobKt.launch$default(coroutineScope, null, new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(sheetState, null, 6), 3).invokeOnCompletion(new BottomSheetKt$$ExternalSyntheticLambda3(sheetState, function0, 1));
                }
                break;
            case 1:
                int iOrdinal = sheetState.getCurrentValue().ordinal();
                if (iOrdinal == 1) {
                    function0.invoke();
                    Unit unit = Unit.INSTANCE;
                } else if (iOrdinal != 2) {
                    JobKt.launch$default(coroutineScope, null, new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(sheetState, null, 3), 3);
                } else {
                    JobKt.launch$default(coroutineScope, null, new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(sheetState, null, 0), 3);
                }
                break;
            case 2:
                if (((Boolean) sheetState.confirmValueChange.invoke(sheetValue)).booleanValue()) {
                    JobKt.launch$default(coroutineScope, null, new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(sheetState, null, 8), 3).invokeOnCompletion(new BottomSheetKt$$ExternalSyntheticLambda3(sheetState, function0, 2));
                }
                break;
            default:
                if (sheetState.getCurrentValue() == SheetValue.Expanded && sheetState.getHasPartiallyExpandedState()) {
                    JobKt.launch$default(coroutineScope, null, new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(sheetState, null, 9), 3);
                } else {
                    JobKt.launch$default(coroutineScope, null, new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(sheetState, null, 10), 3).invokeOnCompletion(new AppBarKt$$ExternalSyntheticLambda4(3, function0));
                }
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ BottomSheetKt$$ExternalSyntheticLambda5(SheetState sheetState, CoroutineScope coroutineScope, Function0 function0, int i) {
        this.$r8$classId = i;
        this.f$0 = sheetState;
        this.f$1 = coroutineScope;
        this.f$2 = function0;
    }
}
