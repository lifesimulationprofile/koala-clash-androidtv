package androidx.navigation;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class NavOptionsBuilder {
    public final NavOptions.Builder builder;
    public boolean launchSingleTop;
    public int popUpToId;
    public boolean restoreState;
    public boolean saveState;

    public NavOptionsBuilder() {
        NavOptions.Builder builder = new NavOptions.Builder();
        builder.enterAnim = -1;
        builder.exitAnim = -1;
        this.builder = builder;
        this.popUpToId = -1;
    }
}
