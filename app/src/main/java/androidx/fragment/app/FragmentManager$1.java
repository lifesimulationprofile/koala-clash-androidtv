package androidx.fragment.app;

import androidx.activity.BackEventCompat;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.view.menu.BaseMenuWrapper;
import androidx.compose.ui.window.DialogWrapper;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavHostController;
import com.github.kr328.clash.PropertiesActivity;
import kotlin.collections.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentManager$1 extends OnBackPressedCallback {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FragmentManager$1(int i, Object obj) {
        super(true);
        this.$r8$classId = i;
        this.this$0 = obj;
    }

    @Override // androidx.activity.OnBackPressedCallback
    public void handleOnBackCancelled() {
        switch (this.$r8$classId) {
            case 2:
                ((BaseMenuWrapper) this.this$0).onBackCancelled();
                break;
        }
    }

    @Override // androidx.activity.OnBackPressedCallback
    public final void handleOnBackPressed() {
        switch (this.$r8$classId) {
            case 0:
                FragmentManagerImpl fragmentManagerImpl = (FragmentManagerImpl) this.this$0;
                fragmentManagerImpl.execPendingActions(true);
                if (!fragmentManagerImpl.mOnBackPressedCallback.isEnabled) {
                    fragmentManagerImpl.mOnBackPressedDispatcher.eventInput.dispatchOnBackCompleted();
                } else {
                    fragmentManagerImpl.popBackStackImmediate();
                }
                break;
            case 1:
                ((DialogWrapper.AnonymousClass2) this.this$0).invoke(this);
                break;
            case 2:
                ((BaseMenuWrapper) this.this$0).onBackCompleted();
                break;
            case 3:
                NavHostController navHostController = (NavHostController) this.this$0;
                ArrayDeque arrayDeque = navHostController.backQueue;
                if (!arrayDeque.isEmpty()) {
                    NavBackStackEntry navBackStackEntry = (NavBackStackEntry) arrayDeque.lastOrNull();
                    if (navHostController.popBackStackInternal((navBackStackEntry != null ? navBackStackEntry.destination : null).id, true, false)) {
                        navHostController.dispatchOnDestinationChanged();
                    }
                    break;
                }
                break;
            default:
                PropertiesActivity propertiesActivity = (PropertiesActivity) this.this$0;
                if (!((Boolean) propertiesActivity.hasUnsaved.invoke()).booleanValue()) {
                    propertiesActivity.finish();
                } else {
                    propertiesActivity.pendingExit$delegate.setValue(Boolean.TRUE);
                }
                break;
        }
    }

    @Override // androidx.activity.OnBackPressedCallback
    public void handleOnBackProgressed(BackEventCompat backEventCompat) {
        switch (this.$r8$classId) {
            case 2:
                ((BaseMenuWrapper) this.this$0).onBackProgressed(backEventCompat);
                break;
        }
    }

    @Override // androidx.activity.OnBackPressedCallback
    public void handleOnBackStarted(BackEventCompat backEventCompat) {
        switch (this.$r8$classId) {
            case 2:
                ((BaseMenuWrapper) this.this$0).onBackStarted();
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FragmentManager$1(int i, Object obj, boolean z) {
        super(false);
        this.$r8$classId = i;
        this.this$0 = obj;
    }
}
