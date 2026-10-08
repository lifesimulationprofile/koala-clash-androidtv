package androidx.navigation;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class NavigatorProvider {
    public static final LinkedHashMap annotationNames = new LinkedHashMap();
    public final LinkedHashMap _navigators = new LinkedHashMap();

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class Companion {
        public static String getNameForNavigator$navigation_common_release(Class cls) {
            LinkedHashMap linkedHashMap = NavigatorProvider.annotationNames;
            String str = (String) linkedHashMap.get(cls);
            if (str != null) {
                return str;
            }
            Navigator.Name name = (Navigator.Name) cls.getAnnotation(Navigator.Name.class);
            String strValue = name != null ? name.value() : null;
            if (strValue == null || strValue.length() <= 0) {
                throw new IllegalArgumentException("No @Navigator.Name annotation found for ".concat(cls.getSimpleName()).toString());
            }
            linkedHashMap.put(cls, strValue);
            return strValue;
        }
    }

    public final void addNavigator(Navigator navigator) {
        String nameForNavigator$navigation_common_release = Companion.getNameForNavigator$navigation_common_release(navigator.getClass());
        if (nameForNavigator$navigation_common_release.length() <= 0) {
            throw new IllegalArgumentException("navigator name cannot be an empty string");
        }
        LinkedHashMap linkedHashMap = this._navigators;
        Navigator navigator2 = (Navigator) linkedHashMap.get(nameForNavigator$navigation_common_release);
        if (Intrinsics.areEqual(navigator2, navigator)) {
            return;
        }
        if (navigator2 != null && navigator2.isAttached) {
            throw new IllegalStateException(("Navigator " + navigator + " is replacing an already attached " + navigator2).toString());
        }
        if (!navigator.isAttached) {
            return;
        }
        throw new IllegalStateException(("Navigator " + navigator + " is already attached to another NavController").toString());
    }

    public final Navigator getNavigator(String str) {
        if (str == null || str.length() <= 0) {
            throw new IllegalArgumentException("navigator name cannot be an empty string");
        }
        Navigator navigator = (Navigator) this._navigators.get(str);
        if (navigator != null) {
            return navigator;
        }
        throw new IllegalStateException(ImageAnalysis$$ExternalSyntheticLambda1.m$1("Could not find Navigator with name \"", str, "\". You must call NavController.addNavigator() for each navigation type."));
    }
}
