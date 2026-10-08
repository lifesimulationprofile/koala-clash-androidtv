package com.google.android.material.textfield;

import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class NoEndIconDelegate extends EndIconDelegate {
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NoEndIconDelegate(TextInputLayout textInputLayout, int i, int i2) {
        super(textInputLayout, i);
        this.$r8$classId = i2;
    }

    @Override // com.google.android.material.textfield.EndIconDelegate
    public final void initialize() {
        switch (this.$r8$classId) {
            case 0:
                TextInputLayout textInputLayout = this.textInputLayout;
                textInputLayout.setEndIconOnClickListener(null);
                textInputLayout.setEndIconDrawable((Drawable) null);
                textInputLayout.setEndIconContentDescription((CharSequence) null);
                break;
            default:
                int i = this.customEndIcon;
                TextInputLayout textInputLayout2 = this.textInputLayout;
                textInputLayout2.setEndIconDrawable(i);
                textInputLayout2.setEndIconOnClickListener(null);
                textInputLayout2.setEndIconOnLongClickListener(null);
                break;
        }
    }
}
