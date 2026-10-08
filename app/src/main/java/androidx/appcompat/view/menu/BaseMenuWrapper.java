package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.IntentFilter;
import android.view.MenuItem;
import androidx.activity.BackEventCompat;
import androidx.activity.compose.internal.BackHandlerCompat$navigationEventHandler$1;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.FragmentManager$1;
import androidx.fragment.app.SpecialEffectsController$FragmentStateManagerOperation;
import androidx.navigationevent.NavigationEvent;
import androidx.navigationevent.NavigationEventHandler;
import androidx.navigationevent.NavigationEventInfo;
import com.github.kr328.clash.TileService$receiver$1;
import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class BaseMenuWrapper {
    public Object mContext;
    public Object mMenuItems;

    public BaseMenuWrapper(Context context) {
        this.mContext = context;
    }

    public void cleanup() {
        TileService$receiver$1 tileService$receiver$1 = (TileService$receiver$1) this.mContext;
        if (tileService$receiver$1 != null) {
            try {
                ((AppCompatDelegateImpl) this.mMenuItems).mContext.unregisterReceiver(tileService$receiver$1);
            } catch (IllegalArgumentException unused) {
            }
            this.mContext = null;
        }
    }

    public void completeSpecialEffect() {
        SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation = (SpecialEffectsController$FragmentStateManagerOperation) this.mContext;
        CancellationSignal cancellationSignal = (CancellationSignal) this.mMenuItems;
        HashSet hashSet = specialEffectsController$FragmentStateManagerOperation.mSpecialEffectsSignals;
        if (hashSet.remove(cancellationSignal) && hashSet.isEmpty()) {
            specialEffectsController$FragmentStateManagerOperation.complete();
        }
    }

    public abstract IntentFilter createIntentFilterForBroadcastReceiver();

    public abstract int[] following(int i);

    public abstract int getApplyableNightMode();

    public MenuItem getMenuItemWrapper(MenuItem menuItem) {
        if (!(menuItem instanceof SupportMenuItem)) {
            return menuItem;
        }
        SupportMenuItem supportMenuItem = (SupportMenuItem) menuItem;
        if (((SimpleArrayMap) this.mMenuItems) == null) {
            this.mMenuItems = new SimpleArrayMap(0);
        }
        MenuItem menuItem2 = (MenuItem) ((SimpleArrayMap) this.mMenuItems).get(supportMenuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItemWrapperICS menuItemWrapperICS = new MenuItemWrapperICS((Context) this.mContext, supportMenuItem);
        ((SimpleArrayMap) this.mMenuItems).put(supportMenuItem, menuItemWrapperICS);
        return menuItemWrapperICS;
    }

    public int[] getRange(int i, int i2) {
        if (i < 0 || i2 < 0 || i == i2) {
            return null;
        }
        int[] iArr = (int[]) this.mMenuItems;
        iArr[0] = i;
        iArr[1] = i2;
        return iArr;
    }

    public String getText() {
        String str = (String) this.mContext;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("text");
        throw null;
    }

    public boolean isBackEnabled() {
        return ((FragmentManager$1) this.mContext).isEnabled && ((BackHandlerCompat$navigationEventHandler$1) this.mMenuItems).isBackEnabled;
    }

    public abstract void onBackCompleted();

    public abstract void onChange();

    public abstract int[] preceding(int i);

    public void setup() {
        cleanup();
        IntentFilter intentFilterCreateIntentFilterForBroadcastReceiver = createIntentFilterForBroadcastReceiver();
        if (intentFilterCreateIntentFilterForBroadcastReceiver.countActions() == 0) {
            return;
        }
        if (((TileService$receiver$1) this.mContext) == null) {
            this.mContext = new TileService$receiver$1(1, this);
        }
        ((AppCompatDelegateImpl) this.mMenuItems).mContext.registerReceiver((TileService$receiver$1) this.mContext, intentFilterCreateIntentFilterForBroadcastReceiver);
    }

    public BaseMenuWrapper(final NavigationEventInfo navigationEventInfo) {
        this.mContext = new FragmentManager$1(2, this, false);
        this.mMenuItems = new NavigationEventHandler(navigationEventInfo) { // from class: androidx.activity.compose.internal.BackHandlerCompat$navigationEventHandler$1
            @Override // androidx.navigationevent.NavigationEventHandler
            public final void onBackCancelled() {
                this.this$0.onBackCancelled();
            }

            @Override // androidx.navigationevent.NavigationEventHandler
            public final void onBackCompleted() {
                this.this$0.onBackCompleted();
            }

            @Override // androidx.navigationevent.NavigationEventHandler
            public final void onBackProgressed(NavigationEvent navigationEvent) {
                this.this$0.onBackProgressed(new BackEventCompat(navigationEvent));
            }

            @Override // androidx.navigationevent.NavigationEventHandler
            public final void onBackStarted(NavigationEvent navigationEvent) {
                this.this$0.onBackStarted();
            }
        };
    }

    public BaseMenuWrapper() {
        this.mMenuItems = new int[2];
    }

    public BaseMenuWrapper(SpecialEffectsController$FragmentStateManagerOperation specialEffectsController$FragmentStateManagerOperation, CancellationSignal cancellationSignal) {
        this.mContext = specialEffectsController$FragmentStateManagerOperation;
        this.mMenuItems = cancellationSignal;
    }

    public BaseMenuWrapper(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.mMenuItems = appCompatDelegateImpl;
    }

    public void onBackCancelled() {
    }

    public void onBackStarted() {
    }

    public void onBackProgressed(BackEventCompat backEventCompat) {
    }
}
