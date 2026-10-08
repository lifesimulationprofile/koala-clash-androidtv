package androidx.core.view.accessibility;

import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import androidx.core.view.ViewCompat;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.DropdownMenuEndIconDelegate;
import java.util.WeakHashMap;
import okhttp3.Headers;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AccessibilityManagerCompat$TouchExplorationStateChangeListenerWrapper implements AccessibilityManager.TouchExplorationStateChangeListener {
    public final Headers.Builder mListener;

    public AccessibilityManagerCompat$TouchExplorationStateChangeListenerWrapper(Headers.Builder builder) {
        this.mListener = builder;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AccessibilityManagerCompat$TouchExplorationStateChangeListenerWrapper) {
            return this.mListener.equals(((AccessibilityManagerCompat$TouchExplorationStateChangeListenerWrapper) obj).mListener);
        }
        return false;
    }

    public final int hashCode() {
        return this.mListener.hashCode();
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z) {
        DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = (DropdownMenuEndIconDelegate) this.mListener.namesAndValues;
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) dropdownMenuEndIconDelegate.textInputLayout.getEditText();
        if (autoCompleteTextView == null || autoCompleteTextView.getKeyListener() != null) {
            return;
        }
        CheckableImageButton checkableImageButton = dropdownMenuEndIconDelegate.endIconView;
        int i = z ? 2 : 1;
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        checkableImageButton.setImportantForAccessibility(i);
    }
}
