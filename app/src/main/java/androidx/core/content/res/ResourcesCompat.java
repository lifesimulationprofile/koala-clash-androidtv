package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.camera.core.Preview$$ExternalSyntheticLambda1;
import androidx.collection.LruCache;
import androidx.core.graphics.TypefaceCompat;
import java.io.IOException;
import java.util.Objects;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ResourcesCompat {
    public static final ThreadLocal sTempTypedValue = new ThreadLocal();
    public static final WeakHashMap sColorStateCaches = new WeakHashMap(0);
    public static final Object sColorStateCacheLock = new Object();

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class ColorStateListCacheEntry {
        public final Configuration mConfiguration;
        public final int mThemeHash;
        public final ColorStateList mValue;

        public ColorStateListCacheEntry(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
            this.mValue = colorStateList;
            this.mConfiguration = configuration;
            this.mThemeHash = theme == null ? 0 : theme.hashCode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class ColorStateListCacheKey {
        public final Resources mResources;
        public final Resources.Theme mTheme;

        public ColorStateListCacheKey(Resources resources, Resources.Theme theme) {
            this.mResources = resources;
            this.mTheme = theme;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && ColorStateListCacheKey.class == obj.getClass()) {
                ColorStateListCacheKey colorStateListCacheKey = (ColorStateListCacheKey) obj;
                if (this.mResources.equals(colorStateListCacheKey.mResources) && Objects.equals(this.mTheme, colorStateListCacheKey.mTheme)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return Objects.hash(this.mResources, this.mTheme);
        }
    }

    public static void addColorStateListToCache(ColorStateListCacheKey colorStateListCacheKey, int i, ColorStateList colorStateList, Resources.Theme theme) {
        synchronized (sColorStateCacheLock) {
            try {
                WeakHashMap weakHashMap = sColorStateCaches;
                SparseArray sparseArray = (SparseArray) weakHashMap.get(colorStateListCacheKey);
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    weakHashMap.put(colorStateListCacheKey, sparseArray);
                }
                sparseArray.append(i, new ColorStateListCacheEntry(colorStateList, colorStateListCacheKey.mResources.getConfiguration(), theme));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static Typeface getFont(Context context, int i) {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i, new TypedValue(), 0, null, false, false);
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00cb  */
    public static Typeface loadFont(Context context, int i, TypedValue typedValue, int i2, CamUtils camUtils, boolean z, boolean z2) {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        CharSequence charSequence = typedValue.string;
        if (charSequence == null) {
            throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(i) + "\" (" + Integer.toHexString(i) + ") is not a Font: " + typedValue);
        }
        String string = charSequence.toString();
        Typeface typefaceCreateFromResourcesFamilyXml = null;
        if (string.startsWith("res/")) {
            int i3 = typedValue.assetCookie;
            LruCache lruCache = TypefaceCompat.sTypefaceCache;
            Typeface typeface = (Typeface) lruCache.get(TypefaceCompat.createResourceUid(resources, i, string, i3, i2));
            if (typeface != null) {
                if (camUtils != null) {
                    new Handler(Looper.getMainLooper()).post(new Preview$$ExternalSyntheticLambda1(25, camUtils, typeface));
                }
                typefaceCreateFromResourcesFamilyXml = typeface;
            } else if (!z2) {
                try {
                    if (string.toLowerCase().endsWith(".xml")) {
                        FontResourcesParserCompat$FamilyResourceEntry fontResourcesParserCompat$FamilyResourceEntry = CamUtils.parse(resources.getXml(i), resources);
                        if (fontResourcesParserCompat$FamilyResourceEntry == null) {
                            Log.e("ResourcesCompat", "Failed to find font-family tag");
                            if (camUtils != null) {
                                camUtils.callbackFailAsync(-3);
                            }
                        } else {
                            typefaceCreateFromResourcesFamilyXml = TypefaceCompat.createFromResourcesFamilyXml(context, fontResourcesParserCompat$FamilyResourceEntry, resources, i, string, typedValue.assetCookie, i2, camUtils, z);
                        }
                    } else {
                        int i4 = typedValue.assetCookie;
                        Typeface typefaceCreateFromResourcesFontFile = TypefaceCompat.sTypefaceCompatImpl.createFromResourcesFontFile(context, resources, i, string, i2);
                        if (typefaceCreateFromResourcesFontFile != null) {
                            lruCache.put(TypefaceCompat.createResourceUid(resources, i, string, i4, i2), typefaceCreateFromResourcesFontFile);
                        }
                        if (camUtils != null) {
                            if (typefaceCreateFromResourcesFontFile != null) {
                                new Handler(Looper.getMainLooper()).post(new Preview$$ExternalSyntheticLambda1(25, camUtils, typefaceCreateFromResourcesFontFile));
                            } else {
                                camUtils.callbackFailAsync(-3);
                            }
                        }
                        typefaceCreateFromResourcesFamilyXml = typefaceCreateFromResourcesFontFile;
                    }
                } catch (IOException e) {
                    Log.e("ResourcesCompat", "Failed to read xml resource ".concat(string), e);
                    if (camUtils != null) {
                        camUtils.callbackFailAsync(-3);
                    }
                } catch (XmlPullParserException e2) {
                    Log.e("ResourcesCompat", "Failed to parse xml resource ".concat(string), e2);
                    if (camUtils != null) {
                        camUtils.callbackFailAsync(-3);
                    }
                }
            }
        } else if (camUtils != null) {
            camUtils.callbackFailAsync(-3);
        }
        if (typefaceCreateFromResourcesFamilyXml != null || camUtils != null || z2) {
            return typefaceCreateFromResourcesFamilyXml;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i) + " could not be retrieved.");
    }
}
