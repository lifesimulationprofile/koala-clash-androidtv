package androidx.compose.foundation.text.contextmenu.internal;

import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuData;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda3 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ AndroidTextContextMenuToolbarProvider f$0;
    public final /* synthetic */ TextContextMenuDataProvider f$1;

    public /* synthetic */ AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda3(AndroidTextContextMenuToolbarProvider androidTextContextMenuToolbarProvider, TextContextMenuDataProvider textContextMenuDataProvider, int i) {
        this.$r8$classId = i;
        this.f$0 = androidTextContextMenuToolbarProvider;
        this.f$1 = textContextMenuDataProvider;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                AndroidTextContextMenuToolbarProvider androidTextContextMenuToolbarProvider = this.f$0;
                AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda0 androidTextContextMenuToolbarProvider$$ExternalSyntheticLambda0 = androidTextContextMenuToolbarProvider.onDataChange;
                BasicTextKt$$ExternalSyntheticLambda0 basicTextKt$$ExternalSyntheticLambda0 = new BasicTextKt$$ExternalSyntheticLambda0(11, this.f$1);
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                androidTextContextMenuToolbarProvider.snapshotStateObserver.observeReads("dataBuilder", androidTextContextMenuToolbarProvider$$ExternalSyntheticLambda0, new Recomposer$$ExternalSyntheticLambda6(8, ref$ObjectRef, basicTextKt$$ExternalSyntheticLambda0));
                Object obj = ref$ObjectRef.element;
                if (obj != null) {
                    return (TextContextMenuData) obj;
                }
                Intrinsics.throwUninitializedPropertyAccessException("result");
                throw null;
            case 1:
                AndroidTextContextMenuToolbarProvider androidTextContextMenuToolbarProvider2 = this.f$0;
                AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda0 androidTextContextMenuToolbarProvider$$ExternalSyntheticLambda1 = androidTextContextMenuToolbarProvider2.onPositionChange;
                AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda3 androidTextContextMenuToolbarProvider$$ExternalSyntheticLambda3 = new AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda3(androidTextContextMenuToolbarProvider2, this.f$1, 2);
                Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                androidTextContextMenuToolbarProvider2.snapshotStateObserver.observeReads("positioner", androidTextContextMenuToolbarProvider$$ExternalSyntheticLambda1, new Recomposer$$ExternalSyntheticLambda6(8, ref$ObjectRef2, androidTextContextMenuToolbarProvider$$ExternalSyntheticLambda3));
                Object obj2 = ref$ObjectRef2.element;
                if (obj2 != null) {
                    return (Rect) obj2;
                }
                Intrinsics.throwUninitializedPropertyAccessException("result");
                throw null;
            default:
                Object objInvoke = this.f$0.coordinatesProvider.invoke();
                if (!((LayoutCoordinates) objInvoke).isAttached()) {
                    objInvoke = null;
                }
                LayoutCoordinates layoutCoordinates = (LayoutCoordinates) objInvoke;
                return layoutCoordinates == null ? Rect.Zero : this.f$1.contentBounds(layoutCoordinates).m381translatek4lQ0M(layoutCoordinates.mo525localToRootMKHz9U(0L));
        }
    }
}
