package androidx.navigation;

import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.core.os.BundleKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Pair;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class NavDeepLink {
    public final Object fragArgs$delegate;
    public final Object fragArgsAndRegex$delegate;
    public final SynchronizedLazyImpl fragPattern$delegate;
    public final Object fragRegex$delegate;
    public final boolean isExactDeepLink;
    public final SynchronizedLazyImpl isParameterizedQuery$delegate;
    public boolean isSingleQueryParamValueOnly;
    public final ArrayList pathArgs;
    public final SynchronizedLazyImpl pathPattern$delegate;
    public final String pathRegex;
    public final Object queryArgsMap$delegate;
    public final String uriPattern;
    public static final Pattern SCHEME_PATTERN = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");
    public static final Pattern FILL_IN_PATTERN = Pattern.compile("\\{(.+?)\\}");

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class ParamQuery {
        public final ArrayList arguments = new ArrayList();
        public String paramRegex;
    }

    public NavDeepLink(String str) {
        this.uriPattern = str;
        ArrayList arrayList = new ArrayList();
        this.pathArgs = arrayList;
        final int i = 6;
        this.pathPattern$delegate = new SynchronizedLazyImpl(new Function0(this) { // from class: androidx.navigation.NavDeepLink$fragArgs$2
            public final /* synthetic */ NavDeepLink this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Type inference failed for: r0v14, types: [java.lang.Object, kotlin.Lazy] */
            /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, kotlin.Lazy] */
            /* JADX WARN: Type inference failed for: r0v20, types: [java.lang.Object, kotlin.Lazy] */
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List list;
                switch (i) {
                    case 0:
                        Pair pair = (Pair) this.this$0.fragArgsAndRegex$delegate.getValue();
                        return (pair == null || (list = (List) pair.first) == null) ? new ArrayList() : list;
                    case 1:
                        String str2 = this.this$0.uriPattern;
                        if (str2 == null || Uri.parse(str2).getFragment() == null) {
                            return null;
                        }
                        ArrayList arrayList2 = new ArrayList();
                        String fragment = Uri.parse(str2).getFragment();
                        StringBuilder sb = new StringBuilder();
                        NavDeepLink.buildRegex(fragment, arrayList2, sb);
                        return new Pair(arrayList2, sb.toString());
                    case 2:
                        String str3 = (String) this.this$0.fragRegex$delegate.getValue();
                        if (str3 != null) {
                            return Pattern.compile(str3, 2);
                        }
                        return null;
                    case 3:
                        Pair pair2 = (Pair) this.this$0.fragArgsAndRegex$delegate.getValue();
                        if (pair2 != null) {
                            return (String) pair2.second;
                        }
                        return null;
                    case 4:
                        String str4 = this.this$0.uriPattern;
                        return Boolean.valueOf((str4 == null || Uri.parse(str4).getQuery() == null) ? false : true);
                    case 5:
                        return null;
                    case 6:
                        String str5 = this.this$0.pathRegex;
                        if (str5 != null) {
                            return Pattern.compile(str5, 2);
                        }
                        return null;
                    default:
                        NavDeepLink navDeepLink = this.this$0;
                        String str6 = navDeepLink.uriPattern;
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        if (((Boolean) navDeepLink.isParameterizedQuery$delegate.getValue()).booleanValue()) {
                            Uri uri = Uri.parse(str6);
                            for (String str7 : uri.getQueryParameterNames()) {
                                StringBuilder sb2 = new StringBuilder();
                                List<String> queryParameters = uri.getQueryParameters(str7);
                                if (queryParameters.size() > 1) {
                                    throw new IllegalArgumentException(("Query parameter " + str7 + " must only be present once in " + str6 + ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance.").toString());
                                }
                                String str8 = (String) CollectionsKt.firstOrNull(queryParameters);
                                if (str8 == null) {
                                    navDeepLink.isSingleQueryParamValueOnly = true;
                                    str8 = str7;
                                }
                                Matcher matcher = NavDeepLink.FILL_IN_PATTERN.matcher(str8);
                                NavDeepLink.ParamQuery paramQuery = new NavDeepLink.ParamQuery();
                                int iEnd = 0;
                                while (matcher.find()) {
                                    paramQuery.arguments.add(matcher.group(1));
                                    sb2.append(Pattern.quote(str8.substring(iEnd, matcher.start())));
                                    sb2.append("(.+?)?");
                                    iEnd = matcher.end();
                                }
                                if (iEnd < str8.length()) {
                                    sb2.append(Pattern.quote(str8.substring(iEnd)));
                                }
                                paramQuery.paramRegex = StringsKt__StringsJVMKt.replace$default(sb2.toString(), ".*", "\\E.*\\Q");
                                linkedHashMap.put(str7, paramQuery);
                            }
                        }
                        return linkedHashMap;
                }
            }
        });
        final int i2 = 4;
        this.isParameterizedQuery$delegate = new SynchronizedLazyImpl(new Function0(this) { // from class: androidx.navigation.NavDeepLink$fragArgs$2
            public final /* synthetic */ NavDeepLink this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Type inference failed for: r0v14, types: [java.lang.Object, kotlin.Lazy] */
            /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, kotlin.Lazy] */
            /* JADX WARN: Type inference failed for: r0v20, types: [java.lang.Object, kotlin.Lazy] */
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List list;
                switch (i2) {
                    case 0:
                        Pair pair = (Pair) this.this$0.fragArgsAndRegex$delegate.getValue();
                        return (pair == null || (list = (List) pair.first) == null) ? new ArrayList() : list;
                    case 1:
                        String str2 = this.this$0.uriPattern;
                        if (str2 == null || Uri.parse(str2).getFragment() == null) {
                            return null;
                        }
                        ArrayList arrayList2 = new ArrayList();
                        String fragment = Uri.parse(str2).getFragment();
                        StringBuilder sb = new StringBuilder();
                        NavDeepLink.buildRegex(fragment, arrayList2, sb);
                        return new Pair(arrayList2, sb.toString());
                    case 2:
                        String str3 = (String) this.this$0.fragRegex$delegate.getValue();
                        if (str3 != null) {
                            return Pattern.compile(str3, 2);
                        }
                        return null;
                    case 3:
                        Pair pair2 = (Pair) this.this$0.fragArgsAndRegex$delegate.getValue();
                        if (pair2 != null) {
                            return (String) pair2.second;
                        }
                        return null;
                    case 4:
                        String str4 = this.this$0.uriPattern;
                        return Boolean.valueOf((str4 == null || Uri.parse(str4).getQuery() == null) ? false : true);
                    case 5:
                        return null;
                    case 6:
                        String str5 = this.this$0.pathRegex;
                        if (str5 != null) {
                            return Pattern.compile(str5, 2);
                        }
                        return null;
                    default:
                        NavDeepLink navDeepLink = this.this$0;
                        String str6 = navDeepLink.uriPattern;
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        if (((Boolean) navDeepLink.isParameterizedQuery$delegate.getValue()).booleanValue()) {
                            Uri uri = Uri.parse(str6);
                            for (String str7 : uri.getQueryParameterNames()) {
                                StringBuilder sb2 = new StringBuilder();
                                List<String> queryParameters = uri.getQueryParameters(str7);
                                if (queryParameters.size() > 1) {
                                    throw new IllegalArgumentException(("Query parameter " + str7 + " must only be present once in " + str6 + ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance.").toString());
                                }
                                String str8 = (String) CollectionsKt.firstOrNull(queryParameters);
                                if (str8 == null) {
                                    navDeepLink.isSingleQueryParamValueOnly = true;
                                    str8 = str7;
                                }
                                Matcher matcher = NavDeepLink.FILL_IN_PATTERN.matcher(str8);
                                NavDeepLink.ParamQuery paramQuery = new NavDeepLink.ParamQuery();
                                int iEnd = 0;
                                while (matcher.find()) {
                                    paramQuery.arguments.add(matcher.group(1));
                                    sb2.append(Pattern.quote(str8.substring(iEnd, matcher.start())));
                                    sb2.append("(.+?)?");
                                    iEnd = matcher.end();
                                }
                                if (iEnd < str8.length()) {
                                    sb2.append(Pattern.quote(str8.substring(iEnd)));
                                }
                                paramQuery.paramRegex = StringsKt__StringsJVMKt.replace$default(sb2.toString(), ".*", "\\E.*\\Q");
                                linkedHashMap.put(str7, paramQuery);
                            }
                        }
                        return linkedHashMap;
                }
            }
        });
        final int i3 = 7;
        this.queryArgsMap$delegate = LazyKt__LazyJVMKt.lazy(3, new Function0(this) { // from class: androidx.navigation.NavDeepLink$fragArgs$2
            public final /* synthetic */ NavDeepLink this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Type inference failed for: r0v14, types: [java.lang.Object, kotlin.Lazy] */
            /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, kotlin.Lazy] */
            /* JADX WARN: Type inference failed for: r0v20, types: [java.lang.Object, kotlin.Lazy] */
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List list;
                switch (i3) {
                    case 0:
                        Pair pair = (Pair) this.this$0.fragArgsAndRegex$delegate.getValue();
                        return (pair == null || (list = (List) pair.first) == null) ? new ArrayList() : list;
                    case 1:
                        String str2 = this.this$0.uriPattern;
                        if (str2 == null || Uri.parse(str2).getFragment() == null) {
                            return null;
                        }
                        ArrayList arrayList2 = new ArrayList();
                        String fragment = Uri.parse(str2).getFragment();
                        StringBuilder sb = new StringBuilder();
                        NavDeepLink.buildRegex(fragment, arrayList2, sb);
                        return new Pair(arrayList2, sb.toString());
                    case 2:
                        String str3 = (String) this.this$0.fragRegex$delegate.getValue();
                        if (str3 != null) {
                            return Pattern.compile(str3, 2);
                        }
                        return null;
                    case 3:
                        Pair pair2 = (Pair) this.this$0.fragArgsAndRegex$delegate.getValue();
                        if (pair2 != null) {
                            return (String) pair2.second;
                        }
                        return null;
                    case 4:
                        String str4 = this.this$0.uriPattern;
                        return Boolean.valueOf((str4 == null || Uri.parse(str4).getQuery() == null) ? false : true);
                    case 5:
                        return null;
                    case 6:
                        String str5 = this.this$0.pathRegex;
                        if (str5 != null) {
                            return Pattern.compile(str5, 2);
                        }
                        return null;
                    default:
                        NavDeepLink navDeepLink = this.this$0;
                        String str6 = navDeepLink.uriPattern;
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        if (((Boolean) navDeepLink.isParameterizedQuery$delegate.getValue()).booleanValue()) {
                            Uri uri = Uri.parse(str6);
                            for (String str7 : uri.getQueryParameterNames()) {
                                StringBuilder sb2 = new StringBuilder();
                                List<String> queryParameters = uri.getQueryParameters(str7);
                                if (queryParameters.size() > 1) {
                                    throw new IllegalArgumentException(("Query parameter " + str7 + " must only be present once in " + str6 + ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance.").toString());
                                }
                                String str8 = (String) CollectionsKt.firstOrNull(queryParameters);
                                if (str8 == null) {
                                    navDeepLink.isSingleQueryParamValueOnly = true;
                                    str8 = str7;
                                }
                                Matcher matcher = NavDeepLink.FILL_IN_PATTERN.matcher(str8);
                                NavDeepLink.ParamQuery paramQuery = new NavDeepLink.ParamQuery();
                                int iEnd = 0;
                                while (matcher.find()) {
                                    paramQuery.arguments.add(matcher.group(1));
                                    sb2.append(Pattern.quote(str8.substring(iEnd, matcher.start())));
                                    sb2.append("(.+?)?");
                                    iEnd = matcher.end();
                                }
                                if (iEnd < str8.length()) {
                                    sb2.append(Pattern.quote(str8.substring(iEnd)));
                                }
                                paramQuery.paramRegex = StringsKt__StringsJVMKt.replace$default(sb2.toString(), ".*", "\\E.*\\Q");
                                linkedHashMap.put(str7, paramQuery);
                            }
                        }
                        return linkedHashMap;
                }
            }
        });
        final int i4 = 1;
        this.fragArgsAndRegex$delegate = LazyKt__LazyJVMKt.lazy(3, new Function0(this) { // from class: androidx.navigation.NavDeepLink$fragArgs$2
            public final /* synthetic */ NavDeepLink this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Type inference failed for: r0v14, types: [java.lang.Object, kotlin.Lazy] */
            /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, kotlin.Lazy] */
            /* JADX WARN: Type inference failed for: r0v20, types: [java.lang.Object, kotlin.Lazy] */
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List list;
                switch (i4) {
                    case 0:
                        Pair pair = (Pair) this.this$0.fragArgsAndRegex$delegate.getValue();
                        return (pair == null || (list = (List) pair.first) == null) ? new ArrayList() : list;
                    case 1:
                        String str2 = this.this$0.uriPattern;
                        if (str2 == null || Uri.parse(str2).getFragment() == null) {
                            return null;
                        }
                        ArrayList arrayList2 = new ArrayList();
                        String fragment = Uri.parse(str2).getFragment();
                        StringBuilder sb = new StringBuilder();
                        NavDeepLink.buildRegex(fragment, arrayList2, sb);
                        return new Pair(arrayList2, sb.toString());
                    case 2:
                        String str3 = (String) this.this$0.fragRegex$delegate.getValue();
                        if (str3 != null) {
                            return Pattern.compile(str3, 2);
                        }
                        return null;
                    case 3:
                        Pair pair2 = (Pair) this.this$0.fragArgsAndRegex$delegate.getValue();
                        if (pair2 != null) {
                            return (String) pair2.second;
                        }
                        return null;
                    case 4:
                        String str4 = this.this$0.uriPattern;
                        return Boolean.valueOf((str4 == null || Uri.parse(str4).getQuery() == null) ? false : true);
                    case 5:
                        return null;
                    case 6:
                        String str5 = this.this$0.pathRegex;
                        if (str5 != null) {
                            return Pattern.compile(str5, 2);
                        }
                        return null;
                    default:
                        NavDeepLink navDeepLink = this.this$0;
                        String str6 = navDeepLink.uriPattern;
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        if (((Boolean) navDeepLink.isParameterizedQuery$delegate.getValue()).booleanValue()) {
                            Uri uri = Uri.parse(str6);
                            for (String str7 : uri.getQueryParameterNames()) {
                                StringBuilder sb2 = new StringBuilder();
                                List<String> queryParameters = uri.getQueryParameters(str7);
                                if (queryParameters.size() > 1) {
                                    throw new IllegalArgumentException(("Query parameter " + str7 + " must only be present once in " + str6 + ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance.").toString());
                                }
                                String str8 = (String) CollectionsKt.firstOrNull(queryParameters);
                                if (str8 == null) {
                                    navDeepLink.isSingleQueryParamValueOnly = true;
                                    str8 = str7;
                                }
                                Matcher matcher = NavDeepLink.FILL_IN_PATTERN.matcher(str8);
                                NavDeepLink.ParamQuery paramQuery = new NavDeepLink.ParamQuery();
                                int iEnd = 0;
                                while (matcher.find()) {
                                    paramQuery.arguments.add(matcher.group(1));
                                    sb2.append(Pattern.quote(str8.substring(iEnd, matcher.start())));
                                    sb2.append("(.+?)?");
                                    iEnd = matcher.end();
                                }
                                if (iEnd < str8.length()) {
                                    sb2.append(Pattern.quote(str8.substring(iEnd)));
                                }
                                paramQuery.paramRegex = StringsKt__StringsJVMKt.replace$default(sb2.toString(), ".*", "\\E.*\\Q");
                                linkedHashMap.put(str7, paramQuery);
                            }
                        }
                        return linkedHashMap;
                }
            }
        });
        final int i5 = 0;
        this.fragArgs$delegate = LazyKt__LazyJVMKt.lazy(3, new Function0(this) { // from class: androidx.navigation.NavDeepLink$fragArgs$2
            public final /* synthetic */ NavDeepLink this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Type inference failed for: r0v14, types: [java.lang.Object, kotlin.Lazy] */
            /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, kotlin.Lazy] */
            /* JADX WARN: Type inference failed for: r0v20, types: [java.lang.Object, kotlin.Lazy] */
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List list;
                switch (i5) {
                    case 0:
                        Pair pair = (Pair) this.this$0.fragArgsAndRegex$delegate.getValue();
                        return (pair == null || (list = (List) pair.first) == null) ? new ArrayList() : list;
                    case 1:
                        String str2 = this.this$0.uriPattern;
                        if (str2 == null || Uri.parse(str2).getFragment() == null) {
                            return null;
                        }
                        ArrayList arrayList2 = new ArrayList();
                        String fragment = Uri.parse(str2).getFragment();
                        StringBuilder sb = new StringBuilder();
                        NavDeepLink.buildRegex(fragment, arrayList2, sb);
                        return new Pair(arrayList2, sb.toString());
                    case 2:
                        String str3 = (String) this.this$0.fragRegex$delegate.getValue();
                        if (str3 != null) {
                            return Pattern.compile(str3, 2);
                        }
                        return null;
                    case 3:
                        Pair pair2 = (Pair) this.this$0.fragArgsAndRegex$delegate.getValue();
                        if (pair2 != null) {
                            return (String) pair2.second;
                        }
                        return null;
                    case 4:
                        String str4 = this.this$0.uriPattern;
                        return Boolean.valueOf((str4 == null || Uri.parse(str4).getQuery() == null) ? false : true);
                    case 5:
                        return null;
                    case 6:
                        String str5 = this.this$0.pathRegex;
                        if (str5 != null) {
                            return Pattern.compile(str5, 2);
                        }
                        return null;
                    default:
                        NavDeepLink navDeepLink = this.this$0;
                        String str6 = navDeepLink.uriPattern;
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        if (((Boolean) navDeepLink.isParameterizedQuery$delegate.getValue()).booleanValue()) {
                            Uri uri = Uri.parse(str6);
                            for (String str7 : uri.getQueryParameterNames()) {
                                StringBuilder sb2 = new StringBuilder();
                                List<String> queryParameters = uri.getQueryParameters(str7);
                                if (queryParameters.size() > 1) {
                                    throw new IllegalArgumentException(("Query parameter " + str7 + " must only be present once in " + str6 + ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance.").toString());
                                }
                                String str8 = (String) CollectionsKt.firstOrNull(queryParameters);
                                if (str8 == null) {
                                    navDeepLink.isSingleQueryParamValueOnly = true;
                                    str8 = str7;
                                }
                                Matcher matcher = NavDeepLink.FILL_IN_PATTERN.matcher(str8);
                                NavDeepLink.ParamQuery paramQuery = new NavDeepLink.ParamQuery();
                                int iEnd = 0;
                                while (matcher.find()) {
                                    paramQuery.arguments.add(matcher.group(1));
                                    sb2.append(Pattern.quote(str8.substring(iEnd, matcher.start())));
                                    sb2.append("(.+?)?");
                                    iEnd = matcher.end();
                                }
                                if (iEnd < str8.length()) {
                                    sb2.append(Pattern.quote(str8.substring(iEnd)));
                                }
                                paramQuery.paramRegex = StringsKt__StringsJVMKt.replace$default(sb2.toString(), ".*", "\\E.*\\Q");
                                linkedHashMap.put(str7, paramQuery);
                            }
                        }
                        return linkedHashMap;
                }
            }
        });
        final int i6 = 3;
        this.fragRegex$delegate = LazyKt__LazyJVMKt.lazy(3, new Function0(this) { // from class: androidx.navigation.NavDeepLink$fragArgs$2
            public final /* synthetic */ NavDeepLink this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Type inference failed for: r0v14, types: [java.lang.Object, kotlin.Lazy] */
            /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, kotlin.Lazy] */
            /* JADX WARN: Type inference failed for: r0v20, types: [java.lang.Object, kotlin.Lazy] */
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List list;
                switch (i6) {
                    case 0:
                        Pair pair = (Pair) this.this$0.fragArgsAndRegex$delegate.getValue();
                        return (pair == null || (list = (List) pair.first) == null) ? new ArrayList() : list;
                    case 1:
                        String str2 = this.this$0.uriPattern;
                        if (str2 == null || Uri.parse(str2).getFragment() == null) {
                            return null;
                        }
                        ArrayList arrayList2 = new ArrayList();
                        String fragment = Uri.parse(str2).getFragment();
                        StringBuilder sb = new StringBuilder();
                        NavDeepLink.buildRegex(fragment, arrayList2, sb);
                        return new Pair(arrayList2, sb.toString());
                    case 2:
                        String str3 = (String) this.this$0.fragRegex$delegate.getValue();
                        if (str3 != null) {
                            return Pattern.compile(str3, 2);
                        }
                        return null;
                    case 3:
                        Pair pair2 = (Pair) this.this$0.fragArgsAndRegex$delegate.getValue();
                        if (pair2 != null) {
                            return (String) pair2.second;
                        }
                        return null;
                    case 4:
                        String str4 = this.this$0.uriPattern;
                        return Boolean.valueOf((str4 == null || Uri.parse(str4).getQuery() == null) ? false : true);
                    case 5:
                        return null;
                    case 6:
                        String str5 = this.this$0.pathRegex;
                        if (str5 != null) {
                            return Pattern.compile(str5, 2);
                        }
                        return null;
                    default:
                        NavDeepLink navDeepLink = this.this$0;
                        String str6 = navDeepLink.uriPattern;
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        if (((Boolean) navDeepLink.isParameterizedQuery$delegate.getValue()).booleanValue()) {
                            Uri uri = Uri.parse(str6);
                            for (String str7 : uri.getQueryParameterNames()) {
                                StringBuilder sb2 = new StringBuilder();
                                List<String> queryParameters = uri.getQueryParameters(str7);
                                if (queryParameters.size() > 1) {
                                    throw new IllegalArgumentException(("Query parameter " + str7 + " must only be present once in " + str6 + ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance.").toString());
                                }
                                String str8 = (String) CollectionsKt.firstOrNull(queryParameters);
                                if (str8 == null) {
                                    navDeepLink.isSingleQueryParamValueOnly = true;
                                    str8 = str7;
                                }
                                Matcher matcher = NavDeepLink.FILL_IN_PATTERN.matcher(str8);
                                NavDeepLink.ParamQuery paramQuery = new NavDeepLink.ParamQuery();
                                int iEnd = 0;
                                while (matcher.find()) {
                                    paramQuery.arguments.add(matcher.group(1));
                                    sb2.append(Pattern.quote(str8.substring(iEnd, matcher.start())));
                                    sb2.append("(.+?)?");
                                    iEnd = matcher.end();
                                }
                                if (iEnd < str8.length()) {
                                    sb2.append(Pattern.quote(str8.substring(iEnd)));
                                }
                                paramQuery.paramRegex = StringsKt__StringsJVMKt.replace$default(sb2.toString(), ".*", "\\E.*\\Q");
                                linkedHashMap.put(str7, paramQuery);
                            }
                        }
                        return linkedHashMap;
                }
            }
        });
        final int i7 = 2;
        this.fragPattern$delegate = new SynchronizedLazyImpl(new Function0(this) { // from class: androidx.navigation.NavDeepLink$fragArgs$2
            public final /* synthetic */ NavDeepLink this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Type inference failed for: r0v14, types: [java.lang.Object, kotlin.Lazy] */
            /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, kotlin.Lazy] */
            /* JADX WARN: Type inference failed for: r0v20, types: [java.lang.Object, kotlin.Lazy] */
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List list;
                switch (i7) {
                    case 0:
                        Pair pair = (Pair) this.this$0.fragArgsAndRegex$delegate.getValue();
                        return (pair == null || (list = (List) pair.first) == null) ? new ArrayList() : list;
                    case 1:
                        String str2 = this.this$0.uriPattern;
                        if (str2 == null || Uri.parse(str2).getFragment() == null) {
                            return null;
                        }
                        ArrayList arrayList2 = new ArrayList();
                        String fragment = Uri.parse(str2).getFragment();
                        StringBuilder sb = new StringBuilder();
                        NavDeepLink.buildRegex(fragment, arrayList2, sb);
                        return new Pair(arrayList2, sb.toString());
                    case 2:
                        String str3 = (String) this.this$0.fragRegex$delegate.getValue();
                        if (str3 != null) {
                            return Pattern.compile(str3, 2);
                        }
                        return null;
                    case 3:
                        Pair pair2 = (Pair) this.this$0.fragArgsAndRegex$delegate.getValue();
                        if (pair2 != null) {
                            return (String) pair2.second;
                        }
                        return null;
                    case 4:
                        String str4 = this.this$0.uriPattern;
                        return Boolean.valueOf((str4 == null || Uri.parse(str4).getQuery() == null) ? false : true);
                    case 5:
                        return null;
                    case 6:
                        String str5 = this.this$0.pathRegex;
                        if (str5 != null) {
                            return Pattern.compile(str5, 2);
                        }
                        return null;
                    default:
                        NavDeepLink navDeepLink = this.this$0;
                        String str6 = navDeepLink.uriPattern;
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        if (((Boolean) navDeepLink.isParameterizedQuery$delegate.getValue()).booleanValue()) {
                            Uri uri = Uri.parse(str6);
                            for (String str7 : uri.getQueryParameterNames()) {
                                StringBuilder sb2 = new StringBuilder();
                                List<String> queryParameters = uri.getQueryParameters(str7);
                                if (queryParameters.size() > 1) {
                                    throw new IllegalArgumentException(("Query parameter " + str7 + " must only be present once in " + str6 + ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance.").toString());
                                }
                                String str8 = (String) CollectionsKt.firstOrNull(queryParameters);
                                if (str8 == null) {
                                    navDeepLink.isSingleQueryParamValueOnly = true;
                                    str8 = str7;
                                }
                                Matcher matcher = NavDeepLink.FILL_IN_PATTERN.matcher(str8);
                                NavDeepLink.ParamQuery paramQuery = new NavDeepLink.ParamQuery();
                                int iEnd = 0;
                                while (matcher.find()) {
                                    paramQuery.arguments.add(matcher.group(1));
                                    sb2.append(Pattern.quote(str8.substring(iEnd, matcher.start())));
                                    sb2.append("(.+?)?");
                                    iEnd = matcher.end();
                                }
                                if (iEnd < str8.length()) {
                                    sb2.append(Pattern.quote(str8.substring(iEnd)));
                                }
                                paramQuery.paramRegex = StringsKt__StringsJVMKt.replace$default(sb2.toString(), ".*", "\\E.*\\Q");
                                linkedHashMap.put(str7, paramQuery);
                            }
                        }
                        return linkedHashMap;
                }
            }
        });
        final int i8 = 5;
        new SynchronizedLazyImpl(new Function0(this) { // from class: androidx.navigation.NavDeepLink$fragArgs$2
            public final /* synthetic */ NavDeepLink this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX WARN: Type inference failed for: r0v14, types: [java.lang.Object, kotlin.Lazy] */
            /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, kotlin.Lazy] */
            /* JADX WARN: Type inference failed for: r0v20, types: [java.lang.Object, kotlin.Lazy] */
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List list;
                switch (i8) {
                    case 0:
                        Pair pair = (Pair) this.this$0.fragArgsAndRegex$delegate.getValue();
                        return (pair == null || (list = (List) pair.first) == null) ? new ArrayList() : list;
                    case 1:
                        String str2 = this.this$0.uriPattern;
                        if (str2 == null || Uri.parse(str2).getFragment() == null) {
                            return null;
                        }
                        ArrayList arrayList2 = new ArrayList();
                        String fragment = Uri.parse(str2).getFragment();
                        StringBuilder sb = new StringBuilder();
                        NavDeepLink.buildRegex(fragment, arrayList2, sb);
                        return new Pair(arrayList2, sb.toString());
                    case 2:
                        String str3 = (String) this.this$0.fragRegex$delegate.getValue();
                        if (str3 != null) {
                            return Pattern.compile(str3, 2);
                        }
                        return null;
                    case 3:
                        Pair pair2 = (Pair) this.this$0.fragArgsAndRegex$delegate.getValue();
                        if (pair2 != null) {
                            return (String) pair2.second;
                        }
                        return null;
                    case 4:
                        String str4 = this.this$0.uriPattern;
                        return Boolean.valueOf((str4 == null || Uri.parse(str4).getQuery() == null) ? false : true);
                    case 5:
                        return null;
                    case 6:
                        String str5 = this.this$0.pathRegex;
                        if (str5 != null) {
                            return Pattern.compile(str5, 2);
                        }
                        return null;
                    default:
                        NavDeepLink navDeepLink = this.this$0;
                        String str6 = navDeepLink.uriPattern;
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        if (((Boolean) navDeepLink.isParameterizedQuery$delegate.getValue()).booleanValue()) {
                            Uri uri = Uri.parse(str6);
                            for (String str7 : uri.getQueryParameterNames()) {
                                StringBuilder sb2 = new StringBuilder();
                                List<String> queryParameters = uri.getQueryParameters(str7);
                                if (queryParameters.size() > 1) {
                                    throw new IllegalArgumentException(("Query parameter " + str7 + " must only be present once in " + str6 + ". To support repeated query parameters, use an array type for your argument and the pattern provided in your URI will be used to parse each query parameter instance.").toString());
                                }
                                String str8 = (String) CollectionsKt.firstOrNull(queryParameters);
                                if (str8 == null) {
                                    navDeepLink.isSingleQueryParamValueOnly = true;
                                    str8 = str7;
                                }
                                Matcher matcher = NavDeepLink.FILL_IN_PATTERN.matcher(str8);
                                NavDeepLink.ParamQuery paramQuery = new NavDeepLink.ParamQuery();
                                int iEnd = 0;
                                while (matcher.find()) {
                                    paramQuery.arguments.add(matcher.group(1));
                                    sb2.append(Pattern.quote(str8.substring(iEnd, matcher.start())));
                                    sb2.append("(.+?)?");
                                    iEnd = matcher.end();
                                }
                                if (iEnd < str8.length()) {
                                    sb2.append(Pattern.quote(str8.substring(iEnd)));
                                }
                                paramQuery.paramRegex = StringsKt__StringsJVMKt.replace$default(sb2.toString(), ".*", "\\E.*\\Q");
                                linkedHashMap.put(str7, paramQuery);
                            }
                        }
                        return linkedHashMap;
                }
            }
        });
        if (str == null) {
            return;
        }
        StringBuilder sb = new StringBuilder("^");
        if (!SCHEME_PATTERN.matcher(str).find()) {
            sb.append("http[s]?://");
        }
        Matcher matcher = Pattern.compile("(\\?|\\#|$)").matcher(str);
        matcher.find();
        boolean z = false;
        buildRegex(str.substring(0, matcher.start()), arrayList, sb);
        if (!StringsKt.contains(sb, ".*", false) && !StringsKt.contains(sb, "([^/]+?)", false)) {
            z = true;
        }
        this.isExactDeepLink = z;
        sb.append("($|(\\?(.)*)|(\\#(.)*))");
        this.pathRegex = StringsKt__StringsJVMKt.replace$default(sb.toString(), ".*", "\\E.*\\Q");
    }

    public static void buildRegex(String str, ArrayList arrayList, StringBuilder sb) {
        Matcher matcher = FILL_IN_PATTERN.matcher(str);
        int iEnd = 0;
        while (matcher.find()) {
            arrayList.add(matcher.group(1));
            if (matcher.start() > iEnd) {
                sb.append(Pattern.quote(str.substring(iEnd, matcher.start())));
            }
            sb.append("([^/]*?|)");
            iEnd = matcher.end();
        }
        if (iEnd < str.length()) {
            sb.append(Pattern.quote(str.substring(iEnd)));
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof NavDeepLink)) {
            return false;
        }
        return Intrinsics.areEqual(this.uriPattern, ((NavDeepLink) obj).uriPattern);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, kotlin.Lazy] */
    public final ArrayList getArgumentsNames$navigation_common_release() {
        Collection collectionValues = ((Map) this.queryArgsMap$delegate.getValue()).values();
        ArrayList arrayList = new ArrayList();
        Iterator it = collectionValues.iterator();
        while (it.hasNext()) {
            CollectionsKt__MutableCollectionsKt.addAll(((ParamQuery) it.next()).arguments, arrayList);
        }
        return CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) this.pathArgs, (List) arrayList), (List) this.fragArgs$delegate.getValue());
    }

    /* JADX WARN: Type inference failed for: r0v15, types: [java.lang.Object, kotlin.Lazy] */
    public final Bundle getMatchingArguments(Uri uri, LinkedHashMap linkedHashMap) {
        Pattern pattern = (Pattern) this.pathPattern$delegate.getValue();
        Matcher matcher = pattern != null ? pattern.matcher(uri.toString()) : null;
        if (matcher != null && matcher.matches()) {
            Bundle bundle = new Bundle();
            if (getMatchingPathArguments(matcher, bundle, linkedHashMap) && (!((Boolean) this.isParameterizedQuery$delegate.getValue()).booleanValue() || getMatchingQueryArguments(uri, bundle, linkedHashMap))) {
                String fragment = uri.getFragment();
                Pattern pattern2 = (Pattern) this.fragPattern$delegate.getValue();
                Matcher matcher2 = pattern2 != null ? pattern2.matcher(String.valueOf(fragment)) : null;
                if (matcher2 != null && matcher2.matches()) {
                    List list = (List) this.fragArgs$delegate.getValue();
                    ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                    int i = 0;
                    for (Object obj : list) {
                        int i2 = i + 1;
                        if (i < 0) {
                            AppCompatHintHelper.throwIndexOverflow();
                            throw null;
                        }
                        String str = (String) obj;
                        String strDecode = Uri.decode(matcher2.group(i2));
                        if (linkedHashMap.get(str) != null) {
                            throw new ClassCastException();
                        }
                        try {
                            bundle.putString(str, strDecode);
                            arrayList.add(Unit.INSTANCE);
                            i = i2;
                        } catch (IllegalArgumentException unused) {
                        }
                    }
                }
                if (NavArgumentKt.missingRequiredArguments(linkedHashMap, new NavDeepLink$getMatchingArguments$missingRequiredArguments$1(bundle, 0)).isEmpty()) {
                    return bundle;
                }
            }
        }
        return null;
    }

    public final boolean getMatchingPathArguments(Matcher matcher, Bundle bundle, Map map) {
        ArrayList arrayList = this.pathArgs;
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            int i3 = i + 1;
            if (i < 0) {
                AppCompatHintHelper.throwIndexOverflow();
                throw null;
            }
            String str = (String) obj;
            String strDecode = Uri.decode(matcher.group(i3));
            if (map.get(str) != null) {
                throw new ClassCastException();
            }
            try {
                bundle.putString(str, strDecode);
                arrayList2.add(Unit.INSTANCE);
                i = i3;
            } catch (IllegalArgumentException unused) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, kotlin.Lazy] */
    public final boolean getMatchingQueryArguments(Uri uri, Bundle bundle, Map map) {
        Object objValueOf;
        String query;
        for (Map.Entry entry : ((Map) this.queryArgsMap$delegate.getValue()).entrySet()) {
            String str = (String) entry.getKey();
            ParamQuery paramQuery = (ParamQuery) entry.getValue();
            List<String> queryParameters = uri.getQueryParameters(str);
            if (this.isSingleQueryParamValueOnly && (query = uri.getQuery()) != null && !query.equals(uri.toString())) {
                queryParameters = Collections.singletonList(query);
            }
            int i = 0;
            Bundle bundleBundleOf = BundleKt.bundleOf(new Pair[0]);
            ArrayList arrayList = paramQuery.arguments;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                if (map.get((String) obj) != null) {
                    throw new ClassCastException();
                }
            }
            for (String str2 : queryParameters) {
                String str3 = paramQuery.paramRegex;
                Matcher matcher = str3 != null ? Pattern.compile(str3, 32).matcher(str2) : null;
                if (matcher == null || !matcher.matches()) {
                    return i;
                }
                ArrayList arrayList2 = paramQuery.arguments;
                ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10));
                int size2 = arrayList2.size();
                int i3 = i;
                int i4 = i3;
                while (i4 < size2) {
                    Object obj2 = arrayList2.get(i4);
                    i4++;
                    int i5 = i3 + 1;
                    if (i3 < 0) {
                        AppCompatHintHelper.throwIndexOverflow();
                        throw null;
                    }
                    String str4 = (String) obj2;
                    String strGroup = matcher.group(i5);
                    if (strGroup == null) {
                        strGroup = "";
                    }
                    int i6 = i;
                    String str5 = strGroup;
                    if (map.get(str4) != null) {
                        throw new ClassCastException();
                    }
                    try {
                        if (bundleBundleOf.containsKey(str4)) {
                            objValueOf = Boolean.valueOf(!bundleBundleOf.containsKey(str4));
                        } else {
                            bundleBundleOf.putString(str4, str5);
                            objValueOf = Unit.INSTANCE;
                        }
                    } catch (IllegalArgumentException unused) {
                        objValueOf = Unit.INSTANCE;
                    }
                    arrayList3.add(objValueOf);
                    i3 = i5;
                    i = i6;
                }
            }
            bundle.putAll(bundleBundleOf);
        }
        return true;
    }

    public final int hashCode() {
        String str = this.uriPattern;
        return (str != null ? str.hashCode() : 0) * 961;
    }
}
