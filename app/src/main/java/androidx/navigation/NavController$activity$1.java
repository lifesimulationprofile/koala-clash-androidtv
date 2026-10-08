package androidx.navigation;

import android.content.Context;
import android.content.ContextWrapper;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class NavController$activity$1 extends Lambda implements Function1 {
    public static final NavController$activity$1 INSTANCE;
    public static final NavController$activity$1 INSTANCE$1;
    public static final NavController$activity$1 INSTANCE$2;
    public static final NavController$activity$1 INSTANCE$3;
    public static final NavController$activity$1 INSTANCE$4;
    public static final NavController$activity$1 INSTANCE$5;
    public static final NavController$activity$1 INSTANCE$6;
    public final /* synthetic */ int $r8$classId;

    static {
        int i = 1;
        INSTANCE$1 = new NavController$activity$1(i, 1);
        INSTANCE = new NavController$activity$1(i, 0);
        INSTANCE$2 = new NavController$activity$1(i, 2);
        INSTANCE$3 = new NavController$activity$1(i, 3);
        INSTANCE$4 = new NavController$activity$1(i, 4);
        INSTANCE$5 = new NavController$activity$1(i, 5);
        INSTANCE$6 = new NavController$activity$1(i, 6);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NavController$activity$1(int i, int i2) {
        super(i);
        this.$r8$classId = i2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                Context context = (Context) obj;
                if (context instanceof ContextWrapper) {
                    return ((ContextWrapper) context).getBaseContext();
                }
                return null;
            case 1:
                Context context2 = (Context) obj;
                if (context2 instanceof ContextWrapper) {
                    return ((ContextWrapper) context2).getBaseContext();
                }
                return null;
            case 2:
                NavDestination navDestination = (NavDestination) obj;
                NavGraph navGraph = navDestination.parent;
                if (navGraph == null || navGraph.startDestId != navDestination.id) {
                    return null;
                }
                return navGraph;
            case 3:
                NavDestination navDestination2 = (NavDestination) obj;
                NavGraph navGraph2 = navDestination2.parent;
                if (navGraph2 == null || navGraph2.startDestId != navDestination2.id) {
                    return null;
                }
                return navGraph2;
            case 4:
                return Integer.valueOf(((NavDestination) obj).id);
            case 5:
                return ((NavDestination) obj).parent;
            default:
                NavDestination navDestination3 = (NavDestination) obj;
                if (!(navDestination3 instanceof NavGraph)) {
                    return null;
                }
                NavGraph navGraph3 = (NavGraph) navDestination3;
                return navGraph3.findNodeComprehensive(navGraph3.startDestId, navGraph3, false, null);
        }
    }
}
