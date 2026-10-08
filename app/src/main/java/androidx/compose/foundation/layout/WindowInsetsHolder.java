package androidx.compose.foundation.layout;

import android.graphics.Path;
import android.os.Build;
import android.view.View;
import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.core.graphics.Insets;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.koala.clash.R;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class WindowInsetsHolder {
    public static final WeakHashMap viewMap = new WeakHashMap();
    public int accessCount;
    public final AndroidWindowInsets captionBar;
    public final ValueInsets captionBarIgnoringVisibility;
    public final boolean consumes;
    public final ParcelableSnapshotMutableState cutoutPath$delegate;
    public final AndroidWindowInsets displayCutout;
    public final AndroidWindowInsets ime;
    public final ValueInsets imeAnimationSource;
    public final ValueInsets imeAnimationTarget;
    public final InsetsListener insetsListener;
    public final AndroidWindowInsets mandatorySystemGestures;
    public final AndroidWindowInsets navigationBars;
    public final ValueInsets navigationBarsIgnoringVisibility;
    public final UnionInsets safeDrawing;
    public final AndroidWindowInsets statusBars;
    public final ValueInsets statusBarsIgnoringVisibility;
    public final AndroidWindowInsets systemBars;
    public final ValueInsets systemBarsIgnoringVisibility;
    public final AndroidWindowInsets systemGestures;
    public final AndroidWindowInsets tappableElement;
    public final ValueInsets tappableElementIgnoringVisibility;
    public final ValueInsets waterfall;

    public WindowInsetsHolder(View view) {
        AndroidWindowInsets androidWindowInsetsAccess$systemInsets = FlowRowOverflow.access$systemInsets("captionBar", 4);
        this.captionBar = androidWindowInsetsAccess$systemInsets;
        AndroidWindowInsets androidWindowInsetsAccess$systemInsets2 = FlowRowOverflow.access$systemInsets("displayCutout", 128);
        this.displayCutout = androidWindowInsetsAccess$systemInsets2;
        AndroidWindowInsets androidWindowInsetsAccess$systemInsets3 = FlowRowOverflow.access$systemInsets("ime", 8);
        this.ime = androidWindowInsetsAccess$systemInsets3;
        AndroidWindowInsets androidWindowInsetsAccess$systemInsets4 = FlowRowOverflow.access$systemInsets("mandatorySystemGestures", 32);
        this.mandatorySystemGestures = androidWindowInsetsAccess$systemInsets4;
        AndroidWindowInsets androidWindowInsetsAccess$systemInsets5 = FlowRowOverflow.access$systemInsets("navigationBars", 2);
        this.navigationBars = androidWindowInsetsAccess$systemInsets5;
        AndroidWindowInsets androidWindowInsetsAccess$systemInsets6 = FlowRowOverflow.access$systemInsets("statusBars", 1);
        this.statusBars = androidWindowInsetsAccess$systemInsets6;
        AndroidWindowInsets androidWindowInsetsAccess$systemInsets7 = FlowRowOverflow.access$systemInsets("systemBars", 519);
        this.systemBars = androidWindowInsetsAccess$systemInsets7;
        AndroidWindowInsets androidWindowInsetsAccess$systemInsets8 = FlowRowOverflow.access$systemInsets("systemGestures", 16);
        this.systemGestures = androidWindowInsetsAccess$systemInsets8;
        AndroidWindowInsets androidWindowInsetsAccess$systemInsets9 = FlowRowOverflow.access$systemInsets("tappableElement", 64);
        this.tappableElement = androidWindowInsetsAccess$systemInsets9;
        ValueInsets valueInsets = new ValueInsets(new InsetsValues(0, 0, 0, 0), "waterfall");
        this.waterfall = valueInsets;
        this.cutoutPath$delegate = Stack.mutableStateOf$default(null);
        UnionInsets unionInsets = new UnionInsets(new UnionInsets(androidWindowInsetsAccess$systemInsets7, androidWindowInsetsAccess$systemInsets3), androidWindowInsetsAccess$systemInsets2);
        this.safeDrawing = unionInsets;
        new UnionInsets(unionInsets, new UnionInsets(new UnionInsets(new UnionInsets(androidWindowInsetsAccess$systemInsets9, androidWindowInsetsAccess$systemInsets4), androidWindowInsetsAccess$systemInsets8), valueInsets));
        this.captionBarIgnoringVisibility = FlowRowOverflow.access$valueInsetsIgnoringVisibility("captionBarIgnoringVisibility", 4);
        this.navigationBarsIgnoringVisibility = FlowRowOverflow.access$valueInsetsIgnoringVisibility("navigationBarsIgnoringVisibility", 2);
        this.statusBarsIgnoringVisibility = FlowRowOverflow.access$valueInsetsIgnoringVisibility("statusBarsIgnoringVisibility", 1);
        this.systemBarsIgnoringVisibility = FlowRowOverflow.access$valueInsetsIgnoringVisibility("systemBarsIgnoringVisibility", 519);
        this.tappableElementIgnoringVisibility = FlowRowOverflow.access$valueInsetsIgnoringVisibility("tappableElementIgnoringVisibility", 64);
        this.imeAnimationTarget = new ValueInsets(new InsetsValues(0, 0, 0, 0), "imeAnimationTarget");
        this.imeAnimationSource = new ValueInsets(new InsetsValues(0, 0, 0, 0), "imeAnimationSource");
        Object parent = view.getParent();
        View view2 = parent instanceof View ? (View) parent : null;
        Object tag = view2 != null ? view2.getTag(R.id.consume_window_insets_tag) : null;
        Boolean bool = tag instanceof Boolean ? (Boolean) tag : null;
        this.consumes = bool != null ? bool.booleanValue() : false;
        this.insetsListener = new InsetsListener(this);
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        WindowInsetsCompat rootWindowInsets = ViewCompat.Api23Impl.getRootWindowInsets(view);
        if (rootWindowInsets != null) {
            WindowInsetsCompat.Impl impl = rootWindowInsets.mImpl;
            androidWindowInsetsAccess$systemInsets.setVisible(impl.isVisible(4));
            androidWindowInsetsAccess$systemInsets2.setVisible(impl.isVisible(128));
            androidWindowInsetsAccess$systemInsets3.setVisible(impl.isVisible(8));
            androidWindowInsetsAccess$systemInsets4.setVisible(impl.isVisible(32));
            androidWindowInsetsAccess$systemInsets5.setVisible(impl.isVisible(2));
            androidWindowInsetsAccess$systemInsets6.setVisible(impl.isVisible(1));
            androidWindowInsetsAccess$systemInsets7.setVisible(impl.isVisible(519));
            androidWindowInsetsAccess$systemInsets8.setVisible(impl.isVisible(16));
            androidWindowInsetsAccess$systemInsets9.setVisible(impl.isVisible(64));
        }
    }

    public static void update$default(WindowInsetsHolder windowInsetsHolder, WindowInsetsCompat windowInsetsCompat) {
        boolean z = false;
        windowInsetsHolder.captionBar.update$foundation_layout(windowInsetsCompat, 0);
        windowInsetsHolder.ime.update$foundation_layout(windowInsetsCompat, 0);
        windowInsetsHolder.displayCutout.update$foundation_layout(windowInsetsCompat, 0);
        windowInsetsHolder.navigationBars.update$foundation_layout(windowInsetsCompat, 0);
        windowInsetsHolder.statusBars.update$foundation_layout(windowInsetsCompat, 0);
        windowInsetsHolder.systemBars.update$foundation_layout(windowInsetsCompat, 0);
        windowInsetsHolder.systemGestures.update$foundation_layout(windowInsetsCompat, 0);
        windowInsetsHolder.tappableElement.update$foundation_layout(windowInsetsCompat, 0);
        windowInsetsHolder.mandatorySystemGestures.update$foundation_layout(windowInsetsCompat, 0);
        windowInsetsHolder.captionBarIgnoringVisibility.setValue$foundation_layout(OffsetKt.toInsetsValues(windowInsetsCompat.mImpl.getInsetsIgnoringVisibility(4)));
        windowInsetsHolder.navigationBarsIgnoringVisibility.setValue$foundation_layout(OffsetKt.toInsetsValues(windowInsetsCompat.mImpl.getInsetsIgnoringVisibility(2)));
        windowInsetsHolder.statusBarsIgnoringVisibility.setValue$foundation_layout(OffsetKt.toInsetsValues(windowInsetsCompat.mImpl.getInsetsIgnoringVisibility(1)));
        windowInsetsHolder.systemBarsIgnoringVisibility.setValue$foundation_layout(OffsetKt.toInsetsValues(windowInsetsCompat.mImpl.getInsetsIgnoringVisibility(519)));
        windowInsetsHolder.tappableElementIgnoringVisibility.setValue$foundation_layout(OffsetKt.toInsetsValues(windowInsetsCompat.mImpl.getInsetsIgnoringVisibility(64)));
        DisplayCutoutCompat displayCutout = windowInsetsCompat.mImpl.getDisplayCutout();
        windowInsetsHolder.waterfall.setValue$foundation_layout(OffsetKt.toInsetsValues(displayCutout != null ? displayCutout.getWaterfallInsets() : Insets.NONE));
        AndroidPath androidPath = null;
        if (displayCutout != null) {
            Path cutoutPath = Build.VERSION.SDK_INT >= 31 ? DisplayCutoutCompat.Api31Impl.getCutoutPath(displayCutout.mDisplayCutout) : null;
            if (cutoutPath != null) {
                androidPath = new AndroidPath(cutoutPath);
            }
        }
        windowInsetsHolder.cutoutPath$delegate.setValue(androidPath);
        synchronized (SnapshotKt.lock) {
            MutableScatterSet mutableScatterSet = SnapshotKt.globalSnapshot.modified;
            if (mutableScatterSet != null && mutableScatterSet.isNotEmpty()) {
                z = true;
            }
        }
        if (z) {
            SnapshotKt.advanceGlobalSnapshot(SnapshotKt.emptyLambda);
        }
    }

    public final void incrementAccessors(View view) {
        if (this.accessCount == 0) {
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            InsetsListener insetsListener = this.insetsListener;
            ViewCompat.Api21Impl.setOnApplyWindowInsetsListener(view, insetsListener);
            if (view.isAttachedToWindow()) {
                view.requestApplyInsets();
            }
            view.addOnAttachStateChangeListener(insetsListener);
            ViewCompat.setWindowInsetsAnimationCallback(view, insetsListener);
        }
        this.accessCount++;
    }
}
