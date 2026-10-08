package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import coil.memory.MemoryCacheService;
import com.google.android.gms.internal.mlkit_vision_common.zzas;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AppCompatEmojiTextHelper {
    public final MemoryCacheService mEmojiTextViewHelper;
    public final TextView mView;

    public AppCompatEmojiTextHelper(TextView textView) {
        this.mView = textView;
        this.mEmojiTextViewHelper = new MemoryCacheService(textView);
    }

    public final InputFilter[] getFilters(InputFilter[] inputFilterArr) {
        return ((zzas) this.mEmojiTextViewHelper.imageLoader).getFilters(inputFilterArr);
    }

    public final void loadFromAttributes(AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(attributeSet, R$styleable.AppCompatTextView, i, 0);
        try {
            boolean z = typedArrayObtainStyledAttributes.hasValue(14) ? typedArrayObtainStyledAttributes.getBoolean(14, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            setEnabled(z);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void setAllCaps(boolean z) {
        ((zzas) this.mEmojiTextViewHelper.imageLoader).setAllCaps(z);
    }

    public final void setEnabled(boolean z) {
        ((zzas) this.mEmojiTextViewHelper.imageLoader).setEnabled(z);
    }
}
