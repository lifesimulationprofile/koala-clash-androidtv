package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Build;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.graphics.TypefaceCompatBaseImpl;
import androidx.tracing.Trace;
import coil.memory.RealWeakMemoryCache;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.barcode.ModuleDescriptor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class FontRequestWorker {
    public static final ThreadPoolExecutor DEFAULT_EXECUTOR_SERVICE;
    public static final Object LOCK;
    public static final SimpleArrayMap PENDING_REPLIES;
    public static final LruCache sTypefaceCache = new LruCache(16);

    /* JADX INFO: renamed from: androidx.core.provider.FontRequestWorker$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 implements Callable {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Context val$context;
        public final /* synthetic */ String val$id;
        public final /* synthetic */ Object val$request;
        public final /* synthetic */ int val$style;

        public /* synthetic */ AnonymousClass1(String str, Context context, Object obj, int i, int i2) {
            this.$r8$classId = i2;
            this.val$id = str;
            this.val$context = context;
            this.val$request = obj;
            this.val$style = i;
        }

        @Override // java.util.concurrent.Callable
        public final Object call() {
            int i = this.$r8$classId;
            int i2 = this.val$style;
            Object obj = this.val$request;
            Context context = this.val$context;
            String str = this.val$id;
            switch (i) {
                case 0:
                    Object[] objArr = {(FontRequest) obj};
                    ArrayList arrayList = new ArrayList(1);
                    Object obj2 = objArr[0];
                    Objects.requireNonNull(obj2);
                    arrayList.add(obj2);
                    return FontRequestWorker.getFontSync(str, context, Collections.unmodifiableList(arrayList), i2);
                default:
                    try {
                        return FontRequestWorker.getFontSync(str, context, (List) obj, i2);
                    } catch (Throwable unused) {
                        return new TypefaceResult(-3);
                    }
            }
        }
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, ModuleDescriptor.MODULE_VERSION, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new RequestExecutor$DefaultThreadFactory(0));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        DEFAULT_EXECUTOR_SERVICE = threadPoolExecutor;
        LOCK = new Object();
        PENDING_REPLIES = new SimpleArrayMap(0);
    }

    public static String createCacheId(int i, List list) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < list.size(); i2++) {
            sb.append(((FontRequest) list.get(i2)).mIdentifier);
            sb.append("-");
            sb.append(i);
            if (i2 < list.size() - 1) {
                sb.append(";");
            }
        }
        return sb.toString();
    }

    public static TypefaceResult getFontSync(String str, Context context, List list, int i) {
        int i2;
        Typeface typefaceCreateFromFontInfo;
        LruCache lruCache = sTypefaceCache;
        Trace.beginSection("getFontSync");
        try {
            Typeface typeface = (Typeface) lruCache.get(str);
            if (typeface != null) {
                TypefaceResult typefaceResult = new TypefaceResult(typeface);
                android.os.Trace.endSection();
                return typefaceResult;
            }
            try {
                RealWeakMemoryCache fontFamilyResult = FontProvider.getFontFamilyResult(context, list);
                List list2 = (List) fontFamilyResult.cache;
                int i3 = fontFamilyResult.operationsSinceCleanUp;
                if (i3 == 0) {
                    FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArr = (FontsContractCompat$FontInfo[]) list2.get(0);
                    if (fontsContractCompat$FontInfoArr == null || fontsContractCompat$FontInfoArr.length == 0) {
                        i2 = 1;
                    } else {
                        int length = fontsContractCompat$FontInfoArr.length;
                        int i4 = 0;
                        while (true) {
                            if (i4 >= length) {
                                i2 = 0;
                                break;
                            }
                            int i5 = fontsContractCompat$FontInfoArr[i4].mResultCode;
                            if (i5 != 0) {
                                if (i5 >= 0) {
                                    i2 = i5;
                                    break;
                                }
                                i2 = -3;
                                break;
                            }
                            i4++;
                        }
                    }
                } else {
                    if (i3 != 1) {
                        i2 = -3;
                        break;
                    }
                    i2 = -2;
                }
                if (i2 != 0) {
                    TypefaceResult typefaceResult2 = new TypefaceResult(i2);
                    android.os.Trace.endSection();
                    return typefaceResult2;
                }
                if (list2.size() <= 1 || Build.VERSION.SDK_INT < 29) {
                    FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArr2 = (FontsContractCompat$FontInfo[]) list2.get(0);
                    TypefaceCompatBaseImpl typefaceCompatBaseImpl = TypefaceCompat.sTypefaceCompatImpl;
                    Trace.beginSection("TypefaceCompat.createFromFontInfo");
                    try {
                        typefaceCreateFromFontInfo = TypefaceCompat.sTypefaceCompatImpl.createFromFontInfo(context, fontsContractCompat$FontInfoArr2, i);
                        android.os.Trace.endSection();
                    } catch (Throwable th) {
                        android.os.Trace.endSection();
                        throw th;
                    }
                } else {
                    TypefaceCompatBaseImpl typefaceCompatBaseImpl2 = TypefaceCompat.sTypefaceCompatImpl;
                    Trace.beginSection("TypefaceCompat.createFromFontInfoWithFallback");
                    try {
                        typefaceCreateFromFontInfo = TypefaceCompat.sTypefaceCompatImpl.createFromFontInfoWithFallback(context, list2, i);
                        android.os.Trace.endSection();
                    } catch (Throwable th2) {
                        android.os.Trace.endSection();
                        throw th2;
                    }
                }
                if (typefaceCreateFromFontInfo == null) {
                    TypefaceResult typefaceResult3 = new TypefaceResult(-3);
                    android.os.Trace.endSection();
                    return typefaceResult3;
                }
                lruCache.put(str, typefaceCreateFromFontInfo);
                TypefaceResult typefaceResult4 = new TypefaceResult(typefaceCreateFromFontInfo);
                android.os.Trace.endSection();
                return typefaceResult4;
            } catch (PackageManager.NameNotFoundException unused) {
                TypefaceResult typefaceResult5 = new TypefaceResult(-1);
                android.os.Trace.endSection();
                return typefaceResult5;
            }
        } catch (Throwable th3) {
            android.os.Trace.endSection();
            throw th3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class TypefaceResult {
        public final int mResult;
        public final Typeface mTypeface;

        public TypefaceResult(int i) {
            this.mTypeface = null;
            this.mResult = i;
        }

        public TypefaceResult(Typeface typeface) {
            this.mTypeface = typeface;
            this.mResult = 0;
        }
    }
}
