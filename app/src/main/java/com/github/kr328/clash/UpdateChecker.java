package com.github.kr328.clash;

import android.os.Build;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class UpdateChecker {
    public static final int access$compareVersions(String str) {
        String strReplaceAll = Pattern.compile("[^0-9.]").matcher(str).replaceAll("");
        String strReplaceAll2 = Pattern.compile("[^0-9.]").matcher("1.2.0").replaceAll("");
        List listSplit$default = StringsKt.split$default(strReplaceAll, new String[]{"."}, 0, 6);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listSplit$default, 10));
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            Integer intOrNull = StringsKt__StringsJVMKt.toIntOrNull((String) it.next());
            arrayList.add(Integer.valueOf(intOrNull != null ? intOrNull.intValue() : 0));
        }
        List listSplit$default2 = StringsKt.split$default(strReplaceAll2, new String[]{"."}, 0, 6);
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listSplit$default2, 10));
        Iterator it2 = listSplit$default2.iterator();
        while (it2.hasNext()) {
            Integer intOrNull2 = StringsKt__StringsJVMKt.toIntOrNull((String) it2.next());
            arrayList2.add(Integer.valueOf(intOrNull2 != null ? intOrNull2.intValue() : 0));
        }
        int iMax = Math.max(arrayList.size(), arrayList2.size());
        int i = 0;
        while (i < iMax) {
            int iIntValue = ((Number) ((i < 0 || i >= arrayList.size()) ? 0 : arrayList.get(i))).intValue();
            int iIntValue2 = ((Number) ((i < 0 || i >= arrayList2.size()) ? 0 : arrayList2.get(i))).intValue();
            if (iIntValue != iIntValue2) {
                return Intrinsics.compare(iIntValue, iIntValue2);
            }
            i++;
        }
        return 0;
    }

    public static final String access$findBestApkUrl(JSONObject jSONObject) {
        Object obj;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("assets");
        Object obj2 = null;
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            int length = jSONArrayOptJSONArray.length();
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("name", "");
                    String strOptString2 = jSONObjectOptJSONObject.optString("browser_download_url", "");
                    if (strOptString.endsWith(".apk") && !StringsKt.isBlank(strOptString2)) {
                        arrayList.add(new Pair(strOptString, strOptString2));
                    }
                }
                i++;
            }
            if (!arrayList.isEmpty()) {
                String[] strArr = Build.SUPPORTED_ABIS;
                String str = strArr.length == 0 ? null : strArr[0];
                String str2 = str != null ? str : "";
                if (!StringsKt.isBlank(str2)) {
                    int size = arrayList.size();
                    int i2 = 0;
                    do {
                        if (i2 >= size) {
                            obj = null;
                            break;
                        }
                        obj = arrayList.get(i2);
                        i2++;
                    } while (!StringsKt.contains((String) ((Pair) obj).first, str2, false));
                    Pair pair = (Pair) obj;
                    if (pair != null) {
                        return (String) pair.second;
                    }
                }
                int size2 = arrayList.size();
                int i3 = 0;
                while (i3 < size2) {
                    Object obj3 = arrayList.get(i3);
                    i3++;
                    if (StringsKt.contains((String) ((Pair) obj3).first, "universal", false)) {
                        obj2 = obj3;
                        break;
                    }
                }
                Pair pair2 = (Pair) obj2;
                return pair2 != null ? (String) pair2.second : (String) ((Pair) CollectionsKt.first((List) arrayList)).second;
            }
        }
        return null;
    }
}
