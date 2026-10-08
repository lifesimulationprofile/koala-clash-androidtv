package androidx.activity.compose;

import androidx.appcompat.view.menu.BaseMenuWrapper;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ComposeBackHandler extends BaseMenuWrapper {
    public Function0 currentOnBackCompleted;

    @Override // androidx.appcompat.view.menu.BaseMenuWrapper
    public final void onBackCompleted() {
        this.currentOnBackCompleted.invoke();
    }
}
