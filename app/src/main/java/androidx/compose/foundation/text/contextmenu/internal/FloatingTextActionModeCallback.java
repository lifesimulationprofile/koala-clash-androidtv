package androidx.compose.foundation.text.contextmenu.internal;

import android.graphics.Rect;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FloatingTextActionModeCallback extends ActionMode.Callback2 implements ActionMode.Callback {
    public final AndroidTextContextMenuToolbarProvider.TextActionModeCallbackImpl textActionModeCallback;

    public FloatingTextActionModeCallback(AndroidTextContextMenuToolbarProvider.TextActionModeCallbackImpl textActionModeCallbackImpl) {
        this.textActionModeCallback = textActionModeCallbackImpl;
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        this.textActionModeCallback.getClass();
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        this.textActionModeCallback.updateMenuItems(menu);
        return menu.size() > 0;
    }

    @Override // android.view.ActionMode.Callback
    public final void onDestroyActionMode(ActionMode actionMode) {
        this.textActionModeCallback.session.close();
    }

    @Override // android.view.ActionMode.Callback2
    public final void onGetContentRect(ActionMode actionMode, View view, Rect rect) {
        androidx.compose.ui.geometry.Rect rect2 = (androidx.compose.ui.geometry.Rect) this.textActionModeCallback.positioner.invoke();
        rect.set(Math.round(rect2.left), Math.round(rect2.top), Math.round(rect2.right), Math.round(rect2.bottom));
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return this.textActionModeCallback.updateMenuItems(menu);
    }
}
