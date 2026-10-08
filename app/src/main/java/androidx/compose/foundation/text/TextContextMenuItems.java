package androidx.compose.foundation.text;

import android.R;
import android.os.Build;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuKeys;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public enum TextContextMenuItems {
    /* JADX INFO: Fake field, exist only in values array */
    Cut(TextContextMenuKeys.CutKey, R.string.cut, R.attr.actionModeCutDrawable),
    /* JADX INFO: Fake field, exist only in values array */
    Copy(TextContextMenuKeys.CopyKey, R.string.copy, R.attr.actionModeCopyDrawable),
    /* JADX INFO: Fake field, exist only in values array */
    Paste(TextContextMenuKeys.PasteKey, R.string.paste, R.attr.actionModePasteDrawable),
    /* JADX INFO: Fake field, exist only in values array */
    SelectAll(TextContextMenuKeys.SelectAllKey, R.string.selectAll, R.attr.actionModeSelectAllDrawable),
    Autofill(TextContextMenuKeys.AutofillKey, Build.VERSION.SDK_INT <= 26 ? com.koala.clash.R.string.androidx_compose_foundation_autofill : R.string.autofill, 0);

    public final int drawableId;
    public final Object key;
    public final int stringId;

    TextContextMenuItems(Object obj, int i, int i2) {
        this.key = obj;
        this.stringId = i;
        this.drawableId = i2;
    }
}
