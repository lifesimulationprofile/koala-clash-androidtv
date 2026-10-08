package androidx.navigation;

import androidx.collection.ArraySetKt;
import androidx.collection.SparseArrayCompat;
import coil.ImageLoader$Builder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.UIntArray;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.ConstrainedOnceSequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class NavGraph extends NavDestination implements Iterable, KMappedMarker {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final SparseArrayCompat nodes;
    public int startDestId;
    public String startDestIdName;
    public String startDestinationRoute;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class Companion {
        public static NavDestination findStartDestination(NavGraph navGraph) {
            Iterator it = SequencesKt.generateSequence(navGraph, NavController$activity$1.INSTANCE$6).iterator();
            if (!it.hasNext()) {
                throw new NoSuchElementException("Sequence is empty.");
            }
            Object next = it.next();
            while (it.hasNext()) {
                next = it.next();
            }
            return (NavDestination) next;
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.NavGraph$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 implements Iterator, KMappedMarker {
        public int index = -1;
        public boolean wentToNext;

        public AnonymousClass1() {
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.index + 1 < NavGraph.this.nodes.size();
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.wentToNext = true;
            SparseArrayCompat sparseArrayCompat = NavGraph.this.nodes;
            int i = this.index + 1;
            this.index = i;
            return (NavDestination) sparseArrayCompat.valueAt(i);
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (!this.wentToNext) {
                throw new IllegalStateException("You must call next() before you can remove an element");
            }
            SparseArrayCompat sparseArrayCompat = NavGraph.this.nodes;
            ((NavDestination) sparseArrayCompat.valueAt(this.index)).parent = null;
            int i = this.index;
            Object[] objArr = sparseArrayCompat.values;
            Object obj = objArr[i];
            Object obj2 = ArraySetKt.DELETED$1;
            if (obj != obj2) {
                objArr[i] = obj2;
                sparseArrayCompat.garbage = true;
            }
            this.index = i - 1;
            this.wentToNext = false;
        }
    }

    public NavGraph(NavGraphNavigator navGraphNavigator) {
        super(navGraphNavigator);
        this.nodes = new SparseArrayCompat(0);
    }

    @Override // androidx.navigation.NavDestination
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NavGraph) || !super.equals(obj)) {
            return false;
        }
        SparseArrayCompat sparseArrayCompat = this.nodes;
        int size = sparseArrayCompat.size();
        NavGraph navGraph = (NavGraph) obj;
        SparseArrayCompat sparseArrayCompat2 = navGraph.nodes;
        if (size != sparseArrayCompat2.size() || this.startDestId != navGraph.startDestId) {
            return false;
        }
        for (NavDestination navDestination : (ConstrainedOnceSequence) SequencesKt.asSequence(new UIntArray.Iterator(1, sparseArrayCompat))) {
            if (!navDestination.equals(sparseArrayCompat2.get(navDestination.id))) {
                return false;
            }
        }
        return true;
    }

    public final NavDestination findNode(String str, boolean z) {
        Object next;
        NavGraph navGraph;
        NavDestination navDestination;
        Iterator it = ((ConstrainedOnceSequence) SequencesKt.asSequence(new UIntArray.Iterator(1, this.nodes))).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            navDestination = (NavDestination) next;
            if (StringsKt__StringsJVMKt.equals(navDestination.route, str, false)) {
                break;
            }
        } while (navDestination.matchRoute(str) == null);
        NavDestination navDestination2 = (NavDestination) next;
        if (navDestination2 != null) {
            return navDestination2;
        }
        if (!z || (navGraph = this.parent) == null || str == null || StringsKt.isBlank(str)) {
            return null;
        }
        return navGraph.findNode(str, true);
    }

    public final NavDestination findNodeComprehensive(int i, NavGraph navGraph, boolean z, NavDestination navDestination) {
        SparseArrayCompat sparseArrayCompat = this.nodes;
        NavDestination navDestinationFindNodeComprehensive = (NavDestination) sparseArrayCompat.get(i);
        if (navDestination != null) {
            if (Intrinsics.areEqual(navDestinationFindNodeComprehensive, navDestination) && Intrinsics.areEqual(navDestinationFindNodeComprehensive.parent, navDestination.parent)) {
                return navDestinationFindNodeComprehensive;
            }
            navDestinationFindNodeComprehensive = null;
        } else if (navDestinationFindNodeComprehensive != null) {
            return navDestinationFindNodeComprehensive;
        }
        if (z) {
            Iterator it = ((ConstrainedOnceSequence) SequencesKt.asSequence(new UIntArray.Iterator(1, sparseArrayCompat))).iterator();
            do {
                if (!it.hasNext()) {
                    navDestinationFindNodeComprehensive = null;
                    break;
                }
                NavDestination navDestination2 = (NavDestination) it.next();
                navDestinationFindNodeComprehensive = (!(navDestination2 instanceof NavGraph) || navDestination2.equals(navGraph)) ? null : ((NavGraph) navDestination2).findNodeComprehensive(i, this, true, navDestination);
            } while (navDestinationFindNodeComprehensive == null);
        }
        if (navDestinationFindNodeComprehensive != null) {
            return navDestinationFindNodeComprehensive;
        }
        NavGraph navGraph2 = this.parent;
        if (navGraph2 == null || navGraph2.equals(navGraph)) {
            return null;
        }
        return this.parent.findNodeComprehensive(i, this, z, navDestination);
    }

    @Override // androidx.navigation.NavDestination
    public final int hashCode() {
        int iKeyAt = this.startDestId;
        SparseArrayCompat sparseArrayCompat = this.nodes;
        int size = sparseArrayCompat.size();
        for (int i = 0; i < size; i++) {
            iKeyAt = (((iKeyAt * 31) + sparseArrayCompat.keyAt(i)) * 31) + ((NavDestination) sparseArrayCompat.valueAt(i)).hashCode();
        }
        return iKeyAt;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new AnonymousClass1();
    }

    @Override // androidx.navigation.NavDestination
    public final NavDestination.DeepLinkMatch matchDeepLink(ImageLoader$Builder imageLoader$Builder) {
        return matchDeepLinkComprehensive(imageLoader$Builder, false, this);
    }

    public final NavDestination.DeepLinkMatch matchDeepLinkComprehensive(ImageLoader$Builder imageLoader$Builder, boolean z, NavGraph navGraph) {
        NavDestination.DeepLinkMatch deepLinkMatchMatchDeepLinkComprehensive;
        NavDestination.DeepLinkMatch deepLinkMatchMatchDeepLink = super.matchDeepLink(imageLoader$Builder);
        ArrayList arrayList = new ArrayList();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        while (true) {
            deepLinkMatchMatchDeepLinkComprehensive = null;
            if (!anonymousClass1.hasNext()) {
                break;
            }
            NavDestination navDestination = (NavDestination) anonymousClass1.next();
            deepLinkMatchMatchDeepLinkComprehensive = Intrinsics.areEqual(navDestination, navGraph) ? null : navDestination.matchDeepLink(imageLoader$Builder);
            if (deepLinkMatchMatchDeepLinkComprehensive != null) {
                arrayList.add(deepLinkMatchMatchDeepLinkComprehensive);
            }
        }
        NavDestination.DeepLinkMatch deepLinkMatch = (NavDestination.DeepLinkMatch) CollectionsKt.maxOrNull(arrayList);
        NavGraph navGraph2 = this.parent;
        if (navGraph2 != null && z && !navGraph2.equals(navGraph)) {
            deepLinkMatchMatchDeepLinkComprehensive = navGraph2.matchDeepLinkComprehensive(imageLoader$Builder, true, this);
        }
        return (NavDestination.DeepLinkMatch) CollectionsKt.maxOrNull(ArraysKt.filterNotNull(new NavDestination.DeepLinkMatch[]{deepLinkMatchMatchDeepLink, deepLinkMatch, deepLinkMatchMatchDeepLinkComprehensive}));
    }

    public final NavDestination.DeepLinkMatch matchRouteComprehensive(String str, boolean z, NavGraph navGraph) {
        NavDestination.DeepLinkMatch deepLinkMatchMatchRouteComprehensive;
        NavDestination.DeepLinkMatch deepLinkMatchMatchRoute = matchRoute(str);
        ArrayList arrayList = new ArrayList();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        while (true) {
            deepLinkMatchMatchRouteComprehensive = null;
            if (!anonymousClass1.hasNext()) {
                break;
            }
            NavDestination navDestination = (NavDestination) anonymousClass1.next();
            if (!Intrinsics.areEqual(navDestination, navGraph)) {
                deepLinkMatchMatchRouteComprehensive = navDestination instanceof NavGraph ? ((NavGraph) navDestination).matchRouteComprehensive(str, false, this) : navDestination.matchRoute(str);
            }
            if (deepLinkMatchMatchRouteComprehensive != null) {
                arrayList.add(deepLinkMatchMatchRouteComprehensive);
            }
        }
        NavDestination.DeepLinkMatch deepLinkMatch = (NavDestination.DeepLinkMatch) CollectionsKt.maxOrNull(arrayList);
        NavGraph navGraph2 = this.parent;
        if (navGraph2 != null && z && !navGraph2.equals(navGraph)) {
            deepLinkMatchMatchRouteComprehensive = navGraph2.matchRouteComprehensive(str, true, this);
        }
        return (NavDestination.DeepLinkMatch) CollectionsKt.maxOrNull(ArraysKt.filterNotNull(new NavDestination.DeepLinkMatch[]{deepLinkMatchMatchRoute, deepLinkMatch, deepLinkMatchMatchRouteComprehensive}));
    }

    @Override // androidx.navigation.NavDestination
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        String str = this.startDestinationRoute;
        NavDestination navDestinationFindNode = (str == null || StringsKt.isBlank(str)) ? null : findNode(str, true);
        if (navDestinationFindNode == null) {
            navDestinationFindNode = findNodeComprehensive(this.startDestId, this, false, null);
        }
        sb.append(" startDestination=");
        if (navDestinationFindNode == null) {
            String str2 = this.startDestinationRoute;
            if (str2 != null) {
                sb.append(str2);
            } else {
                String str3 = this.startDestIdName;
                if (str3 != null) {
                    sb.append(str3);
                } else {
                    sb.append("0x" + Integer.toHexString(this.startDestId));
                }
            }
        } else {
            sb.append("{");
            sb.append(navDestinationFindNode.toString());
            sb.append("}");
        }
        return sb.toString();
    }
}
