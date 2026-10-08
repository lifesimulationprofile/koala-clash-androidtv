package androidx.compose.ui.window;

import android.view.ActionMode;
import androidx.activity.OnBackPressedDispatcher$$ExternalSyntheticLambda0;
import androidx.activity.compose.ActivityResultLauncherHolder;
import androidx.activity.result.ActivityResultRegistry$register$2;
import androidx.compose.animation.core.SeekableTransitionState;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItem;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.text.contextmenu.internal.AndroidTextContextMenuToolbarProvider;
import androidx.compose.foundation.text.contextmenu.provider.BasicTextContextMenuProvider;
import androidx.compose.foundation.text.selection.SelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.material3.ModalBottomSheetDialogWrapper;
import androidx.compose.material3.TooltipStateImpl;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.platform.DisposableSaveableStateRegistry;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelKt;
import coil.disk.DiskLruCache;
import com.github.kr328.clash.FilesActivity$DisposableBackPressed$callback$1$1;
import com.github.kr328.clash.compose.MainAppKt$MainApp$1$1$observer$1;
import com.github.kr328.clash.compose.home.HomeViewModel$observer$1;
import com.github.kr328.clash.compose.settings.SettingsScreenKt$SettingsScreen$2$1$observer$1;
import com.github.kr328.clash.qrserver.QrProfileServer;
import com.github.kr328.clash.remote.Remote;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1 implements DisposableEffectResult {
    public final /* synthetic */ Object $popupLayout$inlined;
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1(int i, Object obj) {
        this.$r8$classId = i;
        this.$popupLayout$inlined = obj;
    }

    @Override // androidx.compose.runtime.DisposableEffectResult
    public final void dispose() throws Exception {
        switch (this.$r8$classId) {
            case 0:
                PopupLayout popupLayout = (PopupLayout) this.$popupLayout$inlined;
                popupLayout.disposeComposition();
                popupLayout.getClass();
                ViewModelKt.set(popupLayout, (LifecycleOwner) null);
                popupLayout.windowManager.removeViewImmediate(popupLayout);
                return;
            case 1:
                ActivityResultRegistry$register$2 activityResultRegistry$register$2 = ((ActivityResultLauncherHolder) this.$popupLayout$inlined).launcher;
                if (activityResultRegistry$register$2 == null) {
                    throw new IllegalStateException("Launcher has not been initialized");
                }
                activityResultRegistry$register$2.unregister();
                return;
            case 2:
                ((SeekableTransitionState) ((Lifecycle) this.$popupLayout$inlined)).setSnapshotStateObserver$animation_core(null);
                return;
            case 3:
                ((LazyLayoutItemContentFactory.CachedItemContent) this.$popupLayout$inlined)._content = null;
                return;
            case 4:
                LazyLayoutPrefetchState lazyLayoutPrefetchState = (LazyLayoutPrefetchState) this.$popupLayout$inlined;
                DiskLruCache.Editor editor = lazyLayoutPrefetchState.prefetchHandleProvider;
                if (editor != null) {
                    editor.closed = false;
                }
                lazyLayoutPrefetchState.prefetchHandleProvider = null;
                return;
            case 5:
                ((LazyLayoutPinnableItem) this.$popupLayout$inlined).isDisposed = true;
                return;
            case 6:
                ((TextFieldSelectionManager) this.$popupLayout$inlined).hideSelectionToolbar$foundation();
                return;
            case 7:
                AndroidTextContextMenuToolbarProvider androidTextContextMenuToolbarProvider = (AndroidTextContextMenuToolbarProvider) this.$popupLayout$inlined;
                SnapshotStateObserver snapshotStateObserver = androidTextContextMenuToolbarProvider.snapshotStateObserver;
                OnBackPressedDispatcher$$ExternalSyntheticLambda0 onBackPressedDispatcher$$ExternalSyntheticLambda0 = snapshotStateObserver.applyUnsubscribe;
                if (onBackPressedDispatcher$$ExternalSyntheticLambda0 != null) {
                    onBackPressedDispatcher$$ExternalSyntheticLambda0.dispose();
                }
                snapshotStateObserver.clear();
                ActionMode actionMode = androidTextContextMenuToolbarProvider.actionMode;
                if (actionMode != null) {
                    actionMode.finish();
                }
                androidTextContextMenuToolbarProvider.actionMode = null;
                return;
            case 8:
                BasicTextContextMenuProvider.SessionImpl sessionImpl = (BasicTextContextMenuProvider.SessionImpl) ((BasicTextContextMenuProvider) this.$popupLayout$inlined).session$delegate.getValue();
                if (sessionImpl != null) {
                    sessionImpl.close();
                    return;
                }
                return;
            case 9:
                SelectionManager selectionManager = (SelectionManager) this.$popupLayout$inlined;
                selectionManager.onRelease();
                selectionManager.hasFocus$delegate.setValue(Boolean.FALSE);
                return;
            case 10:
                ModalBottomSheetDialogWrapper modalBottomSheetDialogWrapper = (ModalBottomSheetDialogWrapper) this.$popupLayout$inlined;
                modalBottomSheetDialogWrapper.dismiss();
                modalBottomSheetDialogWrapper.dialogLayout.disposeComposition();
                return;
            case 11:
                CancellableContinuationImpl cancellableContinuationImpl = ((TooltipStateImpl) this.$popupLayout$inlined).job;
                if (cancellableContinuationImpl != null) {
                    cancellableContinuationImpl.cancel(null);
                    return;
                }
                return;
            case 12:
                ((DisposableSaveableStateRegistry) this.$popupLayout$inlined).onDispose.invoke();
                return;
            case 13:
                DialogWrapper dialogWrapper = (DialogWrapper) this.$popupLayout$inlined;
                dialogWrapper.dismiss();
                dialogWrapper.dialogLayout.disposeComposition();
                return;
            case 14:
                ((FilesActivity$DisposableBackPressed$callback$1$1) this.$popupLayout$inlined).remove();
                return;
            case 15:
                Remote.broadcasts.removeObserver((MainAppKt$MainApp$1$1$observer$1) this.$popupLayout$inlined);
                return;
            case 16:
                Remote.broadcasts.removeObserver((MainAppKt$MainApp$1$1$observer$1) this.$popupLayout$inlined);
                return;
            case 17:
                Remote.broadcasts.removeObserver((HomeViewModel$observer$1) this.$popupLayout$inlined);
                return;
            case 18:
                Remote.broadcasts.removeObserver((HomeViewModel$observer$1) this.$popupLayout$inlined);
                return;
            case 19:
                ((QrProfileServer) this.$popupLayout$inlined).stop();
                return;
            default:
                Remote.broadcasts.removeObserver((SettingsScreenKt$SettingsScreen$2$1$observer$1) this.$popupLayout$inlined);
                return;
        }
    }
}
