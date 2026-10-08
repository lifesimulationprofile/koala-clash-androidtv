package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.collection.SparseArrayCompat;
import androidx.compose.ui.Modifier;
import coil.ImageLoader$Builder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.SynchronizedLazyImpl;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.ConstrainedOnceSequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class NavDestination {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final LinkedHashMap _arguments;
    public final SparseArrayCompat actions;
    public final ArrayList deepLinks;
    public int id;
    public final String navigatorName;
    public NavGraph parent;
    public String route;
    public SynchronizedLazyImpl routeDeepLink;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class Companion {
        public static String getDisplayName(Context context, int i) {
            if (i <= 16777215) {
                return String.valueOf(i);
            }
            try {
                return context.getResources().getResourceName(i);
            } catch (Resources.NotFoundException unused) {
                return String.valueOf(i);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class DeepLinkMatch implements Comparable {
        public final NavDestination destination;
        public final boolean hasMatchingAction;
        public final boolean isExactDeepLink;
        public final Bundle matchingArgs;
        public final int matchingPathSegments;

        public DeepLinkMatch(NavDestination navDestination, Bundle bundle, boolean z, int i, boolean z2) {
            this.destination = navDestination;
            this.matchingArgs = bundle;
            this.isExactDeepLink = z;
            this.matchingPathSegments = i;
            this.hasMatchingAction = z2;
        }

        @Override // java.lang.Comparable
        public final int compareTo(DeepLinkMatch deepLinkMatch) {
            boolean z = deepLinkMatch.hasMatchingAction;
            boolean z2 = deepLinkMatch.isExactDeepLink;
            Bundle bundle = deepLinkMatch.matchingArgs;
            boolean z3 = this.isExactDeepLink;
            if (z3 && !z2) {
                return 1;
            }
            if (!z3 && z2) {
                return -1;
            }
            int i = this.matchingPathSegments - deepLinkMatch.matchingPathSegments;
            if (i > 0) {
                return 1;
            }
            if (i < 0) {
                return -1;
            }
            Bundle bundle2 = this.matchingArgs;
            if (bundle2 != null && bundle == null) {
                return 1;
            }
            if (bundle2 == null && bundle != null) {
                return -1;
            }
            if (bundle2 != null) {
                int size = bundle2.size() - bundle.size();
                if (size > 0) {
                    return 1;
                }
                if (size < 0) {
                    return -1;
                }
            }
            boolean z4 = this.hasMatchingAction;
            if (!z4 || z) {
                return (z4 || !z) ? 0 : -1;
            }
            return 1;
        }
    }

    static {
        new LinkedHashMap();
    }

    public NavDestination(Navigator navigator) {
        LinkedHashMap linkedHashMap = NavigatorProvider.annotationNames;
        this.navigatorName = NavigatorProvider.Companion.getNameForNavigator$navigation_common_release(navigator.getClass());
        this.deepLinks = new ArrayList();
        this.actions = new SparseArrayCompat(0);
        this._arguments = new LinkedHashMap();
    }

    public final Bundle addInDefaultArgs(Bundle bundle) {
        LinkedHashMap linkedHashMap = this._arguments;
        if (bundle == null && linkedHashMap.isEmpty()) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        Iterator it = linkedHashMap.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            entry.getValue().getClass();
            throw new ClassCastException();
        }
        if (bundle != null) {
            bundle2.putAll(bundle);
            Iterator it2 = linkedHashMap.entrySet().iterator();
            if (it2.hasNext()) {
                Map.Entry entry2 = (Map.Entry) it2.next();
                entry2.getValue().getClass();
                throw new ClassCastException();
            }
        }
        return bundle2;
    }

    public boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this != obj) {
            if (obj != null && (obj instanceof NavDestination)) {
                NavDestination navDestination = (NavDestination) obj;
                SparseArrayCompat sparseArrayCompat = navDestination.actions;
                LinkedHashMap linkedHashMap = navDestination._arguments;
                boolean zAreEqual = Intrinsics.areEqual(this.deepLinks, navDestination.deepLinks);
                final SparseArrayCompat sparseArrayCompat2 = this.actions;
                if (sparseArrayCompat2.size() != sparseArrayCompat.size()) {
                    z = false;
                    break;
                }
                Iterator it = ((ConstrainedOnceSequence) SequencesKt.asSequence(new IntIterator() { // from class: androidx.collection.SparseArrayKt$keyIterator$1
                    public int index;

                    @Override // java.util.Iterator
                    public final boolean hasNext() {
                        return this.index < sparseArrayCompat2.size();
                    }

                    @Override // kotlin.collections.IntIterator
                    public final int nextInt() {
                        int i = this.index;
                        this.index = i + 1;
                        return sparseArrayCompat2.keyAt(i);
                    }
                })).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    }
                    int iIntValue = ((Number) it.next()).intValue();
                    if (!Intrinsics.areEqual(sparseArrayCompat2.get(iIntValue), sparseArrayCompat.get(iIntValue))) {
                        z = false;
                        break;
                    }
                }
                LinkedHashMap linkedHashMap2 = this._arguments;
                if (linkedHashMap2.size() != linkedHashMap.size()) {
                    z2 = false;
                    break;
                }
                Iterator it2 = linkedHashMap2.entrySet().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z2 = true;
                        break;
                    }
                    Map.Entry entry = (Map.Entry) it2.next();
                    if (!linkedHashMap.containsKey(entry.getKey()) || !Intrinsics.areEqual(linkedHashMap.get(entry.getKey()), entry.getValue())) {
                        z2 = false;
                        break;
                    }
                }
                if (this.id != navDestination.id || !Intrinsics.areEqual(this.route, navDestination.route) || !zAreEqual || !z || !z2) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.id * 31;
        String str = this.route;
        int iHashCode = i + (str != null ? str.hashCode() : 0);
        ArrayList arrayList = this.deepLinks;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            int i3 = iHashCode * 31;
            String str2 = ((NavDeepLink) obj).uriPattern;
            iHashCode = (i3 + (str2 != null ? str2.hashCode() : 0)) * 961;
        }
        SparseArrayCompat sparseArrayCompat = this.actions;
        if (sparseArrayCompat.size() > 0) {
            sparseArrayCompat.valueAt(0).getClass();
            throw new ClassCastException();
        }
        LinkedHashMap linkedHashMap = this._arguments;
        for (String str3 : linkedHashMap.keySet()) {
            int iM = Modifier.CC.m(iHashCode * 31, 31, str3);
            Object obj2 = linkedHashMap.get(str3);
            iHashCode = iM + (obj2 != null ? obj2.hashCode() : 0);
        }
        return iHashCode;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00b6  */
    public DeepLinkMatch matchDeepLink(ImageLoader$Builder imageLoader$Builder) {
        int size;
        DeepLinkMatch deepLinkMatch;
        this = this;
        ArrayList arrayList = this.deepLinks;
        Bundle bundle = null;
        if (arrayList.isEmpty()) {
            return null;
        }
        int size2 = arrayList.size();
        DeepLinkMatch deepLinkMatch2 = null;
        int i = 0;
        while (i < size2) {
            int i2 = i + 1;
            NavDeepLink navDeepLink = (NavDeepLink) arrayList.get(i);
            Uri uri = (Uri) imageLoader$Builder.applicationContext;
            LinkedHashMap linkedHashMap = this._arguments;
            Bundle matchingArguments = uri != null ? navDeepLink.getMatchingArguments(uri, linkedHashMap) : bundle;
            String str = navDeepLink.uriPattern;
            if (uri == null || str == null) {
                size = 0;
            } else {
                List<String> pathSegments = uri.getPathSegments();
                List<String> pathSegments2 = Uri.parse(str).getPathSegments();
                Set mutableSet = CollectionsKt.toMutableSet(pathSegments);
                if (!ImageAnalysis$$ExternalSyntheticLambda1.m17m((Object) pathSegments2)) {
                    pathSegments2 = CollectionsKt.toList(pathSegments2);
                }
                mutableSet.retainAll(pathSegments2);
                size = mutableSet.size();
            }
            String str2 = (String) imageLoader$Builder.defaults;
            boolean z = str2 != null && str2.equals(bundle);
            if (matchingArguments != null) {
                deepLinkMatch = new DeepLinkMatch(this, matchingArguments, navDeepLink.isExactDeepLink, size, z);
                if (deepLinkMatch2 != null || deepLinkMatch.compareTo(deepLinkMatch2) > 0) {
                    bundle = null;
                    deepLinkMatch2 = deepLinkMatch;
                } else {
                    bundle = null;
                }
            } else {
                if (z) {
                    Bundle bundle2 = new Bundle();
                    if (uri != null) {
                        Pattern pattern = (Pattern) navDeepLink.pathPattern$delegate.getValue();
                        Matcher matcher = pattern != null ? pattern.matcher(uri.toString()) : null;
                        if (matcher != null && matcher.matches()) {
                            navDeepLink.getMatchingPathArguments(matcher, bundle2, linkedHashMap);
                            if (((Boolean) navDeepLink.isParameterizedQuery$delegate.getValue()).booleanValue()) {
                                navDeepLink.getMatchingQueryArguments(uri, bundle2, linkedHashMap);
                            }
                        }
                    }
                    if (NavArgumentKt.missingRequiredArguments(linkedHashMap, new NavDeepLink$getMatchingArguments$missingRequiredArguments$1(bundle2, 1)).isEmpty()) {
                        deepLinkMatch = new DeepLinkMatch(this, matchingArguments, navDeepLink.isExactDeepLink, size, z);
                        if (deepLinkMatch2 != null) {
                        }
                        bundle = null;
                        deepLinkMatch2 = deepLinkMatch;
                    }
                }
                bundle = null;
            }
            i = i2;
        }
        return deepLinkMatch2;
    }

    public final DeepLinkMatch matchRoute(String str) {
        NavDeepLink navDeepLink;
        Uri uri;
        Bundle matchingArguments;
        int size;
        SynchronizedLazyImpl synchronizedLazyImpl = this.routeDeepLink;
        if (synchronizedLazyImpl == null || (navDeepLink = (NavDeepLink) synchronizedLazyImpl.getValue()) == null || (matchingArguments = navDeepLink.getMatchingArguments((uri = Uri.parse("android-app://androidx.navigation/".concat(str))), this._arguments)) == null) {
            return null;
        }
        String str2 = navDeepLink.uriPattern;
        if (str2 == null) {
            size = 0;
        } else {
            List<String> pathSegments = uri.getPathSegments();
            List<String> pathSegments2 = Uri.parse(str2).getPathSegments();
            Set mutableSet = CollectionsKt.toMutableSet(pathSegments);
            if (!ImageAnalysis$$ExternalSyntheticLambda1.m17m((Object) pathSegments2)) {
                pathSegments2 = CollectionsKt.toList(pathSegments2);
            }
            mutableSet.retainAll(pathSegments2);
            size = mutableSet.size();
        }
        return new DeepLinkMatch(this, matchingArguments, navDeepLink.isExactDeepLink, size, false);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(0x");
        sb.append(Integer.toHexString(this.id));
        sb.append(")");
        String str = this.route;
        if (str != null && !StringsKt.isBlank(str)) {
            sb.append(" route=");
            sb.append(this.route);
        }
        return sb.toString();
    }
}
