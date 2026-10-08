package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.View;
import coil.ImageLoader$Builder;
import okio.AsyncTimeout;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class EmojiKeyListener implements KeyListener {
    public final AsyncTimeout.Companion mEmojiCompatHandleKeyDownHelper;
    public final KeyListener mKeyListener;

    public EmojiKeyListener(KeyListener keyListener) {
        AsyncTimeout.Companion companion = new AsyncTimeout.Companion(10);
        this.mKeyListener = keyListener;
        this.mEmojiCompatHandleKeyDownHelper = companion;
    }

    @Override // android.text.method.KeyListener
    public final void clearMetaKeyState(View view, Editable editable, int i) {
        this.mKeyListener.clearMetaKeyState(view, editable, i);
    }

    @Override // android.text.method.KeyListener
    public final int getInputType() {
        return this.mKeyListener.getInputType();
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyDown(View view, Editable editable, int i, KeyEvent keyEvent) {
        boolean zDelete;
        boolean z;
        this.mEmojiCompatHandleKeyDownHelper.getClass();
        if (i != 67) {
            zDelete = i != 112 ? false : ImageLoader$Builder.delete(editable, keyEvent, true);
        } else {
            zDelete = ImageLoader$Builder.delete(editable, keyEvent, false);
        }
        if (zDelete) {
            MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
            z = true;
        } else {
            z = false;
        }
        return z || this.mKeyListener.onKeyDown(view, editable, i, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.mKeyListener.onKeyOther(view, editable, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyUp(View view, Editable editable, int i, KeyEvent keyEvent) {
        return this.mKeyListener.onKeyUp(view, editable, i, keyEvent);
    }
}
