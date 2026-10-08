package androidx.lifecycle.viewmodel.compose;

import android.view.View;
import androidx.compose.runtime.DynamicProvidableCompositionLocal;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.ViewModelStoreOwner;
import coil.ImageLoader$Builder$$ExternalSyntheticLambda2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class LocalViewModelStoreOwner {
    public static final DynamicProvidableCompositionLocal LocalViewModelStoreOwner = new DynamicProvidableCompositionLocal(new ImageLoader$Builder$$ExternalSyntheticLambda2(15));

    public static ViewModelStoreOwner getCurrent(GapComposer gapComposer) {
        ViewModelStoreOwner viewModelStoreOwnerM774get = (ViewModelStoreOwner) gapComposer.consume(LocalViewModelStoreOwner);
        if (viewModelStoreOwnerM774get == null) {
            gapComposer.startReplaceGroup(1260197609);
            viewModelStoreOwnerM774get = androidx.lifecycle.ViewModelKt.m774get((View) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalView));
        } else {
            gapComposer.startReplaceGroup(1260196493);
        }
        gapComposer.end(false);
        return viewModelStoreOwnerM774get;
    }
}
