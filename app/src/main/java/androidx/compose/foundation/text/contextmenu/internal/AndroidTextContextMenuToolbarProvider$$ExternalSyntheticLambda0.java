package androidx.compose.foundation.text.contextmenu.internal;

import android.os.Handler;
import android.os.Looper;
import android.view.ActionMode;
import android.view.View;
import androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda2;
import androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ AndroidTextContextMenuToolbarProvider f$0;

    public /* synthetic */ AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda0(AndroidTextContextMenuToolbarProvider androidTextContextMenuToolbarProvider, int i) {
        this.$r8$classId = i;
        this.f$0 = androidTextContextMenuToolbarProvider;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                Function0 function0 = (Function0) obj;
                View view = this.f$0.view;
                Handler handler = view.getHandler();
                if ((handler != null ? handler.getLooper() : null) == Looper.myLooper()) {
                    function0.invoke();
                } else {
                    Handler handler2 = view.getHandler();
                    if (handler2 != null) {
                        handler2.post(new AndroidComposeView$$ExternalSyntheticLambda2(1, function0));
                    }
                }
                return Unit.INSTANCE;
            case 1:
                ActionMode actionMode = this.f$0.actionMode;
                if (actionMode != null) {
                    actionMode.invalidate();
                }
                return Unit.INSTANCE;
            case 2:
                ActionMode actionMode2 = this.f$0.actionMode;
                if (actionMode2 != null) {
                    actionMode2.invalidateContentRect();
                }
                return Unit.INSTANCE;
            default:
                AndroidTextContextMenuToolbarProvider androidTextContextMenuToolbarProvider = this.f$0;
                androidTextContextMenuToolbarProvider.snapshotStateObserver.start();
                return new AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1(7, androidTextContextMenuToolbarProvider);
        }
    }
}
