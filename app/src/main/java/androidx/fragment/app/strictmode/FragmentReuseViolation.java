package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentReuseViolation extends RuntimeException {
    public final Fragment fragment;

    public FragmentReuseViolation(Fragment fragment, String str) {
        super(str);
        this.fragment = fragment;
    }
}
