package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Trace;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.graphics.TypefaceCompatBaseImpl;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.os.TraceCompat;
import androidx.core.provider.FontsContractCompat$FontInfo;
import androidx.emoji2.text.FontRequestEmojiCompatConfig;
import androidx.emoji2.text.MetadataListReader;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.google.android.gms.internal.mlkit_vision_common.zzap;
import com.google.android.gms.tasks.zzi;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import okhttp3.Dispatcher;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ActivityCompat$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ ActivityCompat$$ExternalSyntheticLambda0(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        switch (this.$r8$classId) {
            case 0:
                Activity activity = (Activity) this.f$0;
                if (activity.isFinishing()) {
                    return;
                }
                Handler handler = ActivityRecreator.mainHandler;
                Method method = ActivityRecreator.requestRelaunchActivityMethod;
                int i = Build.VERSION.SDK_INT;
                if (i >= 28) {
                    activity.recreate();
                    return;
                }
                if (((i != 26 && i != 27) || method != null) && (ActivityRecreator.performStopActivity2ParamsMethod != null || ActivityRecreator.performStopActivity3ParamsMethod != null)) {
                    try {
                        Object obj2 = ActivityRecreator.tokenField.get(activity);
                        if (obj2 != null && (obj = ActivityRecreator.mainThreadField.get(activity)) != null) {
                            Application application = activity.getApplication();
                            ActivityRecreator.LifecycleCheckCallbacks lifecycleCheckCallbacks = new ActivityRecreator.LifecycleCheckCallbacks(activity);
                            application.registerActivityLifecycleCallbacks(lifecycleCheckCallbacks);
                            handler.post(new zzi(3, lifecycleCheckCallbacks, obj2));
                            int i2 = 4;
                            try {
                                if (i == 26 || i == 27) {
                                    Boolean bool = Boolean.FALSE;
                                    method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                                } else {
                                    activity.recreate();
                                }
                                handler.post(new zzi(i2, application, lifecycleCheckCallbacks));
                                return;
                            } catch (Throwable th) {
                                handler.post(new zzi(i2, application, lifecycleCheckCallbacks));
                                throw th;
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
                activity.recreate();
                return;
            case 1:
                View view = (View) this.f$0;
                ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
                return;
            case 2:
                FontRequestEmojiCompatConfig.FontRequestMetadataLoader fontRequestMetadataLoader = (FontRequestEmojiCompatConfig.FontRequestMetadataLoader) this.f$0;
                synchronized (fontRequestMetadataLoader.mLock) {
                    try {
                        if (fontRequestMetadataLoader.mCallback == null) {
                            return;
                        }
                        try {
                            FontsContractCompat$FontInfo fontsContractCompat$FontInfoRetrieveFontInfo = fontRequestMetadataLoader.retrieveFontInfo();
                            int i3 = fontsContractCompat$FontInfoRetrieveFontInfo.mResultCode;
                            if (i3 == 2) {
                                synchronized (fontRequestMetadataLoader.mLock) {
                                }
                            }
                            if (i3 != 0) {
                                throw new RuntimeException("fetchFonts result is not OK. (" + i3 + ")");
                            }
                            try {
                                int i4 = TraceCompat.$r8$clinit;
                                Trace.beginSection("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                                ByteString.Companion companion = fontRequestMetadataLoader.mFontProviderHelper;
                                Context context = fontRequestMetadataLoader.mContext;
                                companion.getClass();
                                FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArr = {fontsContractCompat$FontInfoRetrieveFontInfo};
                                TypefaceCompatBaseImpl typefaceCompatBaseImpl = TypefaceCompat.sTypefaceCompatImpl;
                                androidx.tracing.Trace.beginSection("TypefaceCompat.createFromFontInfo");
                                try {
                                    Typeface typefaceCreateFromFontInfo = TypefaceCompat.sTypefaceCompatImpl.createFromFontInfo(context, fontsContractCompat$FontInfoArr, 0);
                                    Trace.endSection();
                                    MappedByteBuffer mappedByteBufferMmap = TypefaceCompatUtil.mmap(fontRequestMetadataLoader.mContext, fontsContractCompat$FontInfoRetrieveFontInfo.mUri);
                                    if (mappedByteBufferMmap == null || typefaceCreateFromFontInfo == null) {
                                        throw new RuntimeException("Unable to open file.");
                                    }
                                    try {
                                        Trace.beginSection("EmojiCompat.MetadataRepo.create");
                                        Dispatcher dispatcher = new Dispatcher(typefaceCreateFromFontInfo, MetadataListReader.read(mappedByteBufferMmap));
                                        Trace.endSection();
                                        Trace.endSection();
                                        synchronized (fontRequestMetadataLoader.mLock) {
                                            try {
                                                zzap zzapVar = fontRequestMetadataLoader.mCallback;
                                                if (zzapVar != null) {
                                                    zzapVar.onLoaded(dispatcher);
                                                }
                                            } catch (Throwable th2) {
                                                throw th2;
                                            }
                                            break;
                                        }
                                        fontRequestMetadataLoader.cleanUp();
                                        return;
                                    } catch (Throwable th3) {
                                        int i5 = TraceCompat.$r8$clinit;
                                        Trace.endSection();
                                        throw th3;
                                    }
                                } catch (Throwable th4) {
                                    Trace.endSection();
                                    throw th4;
                                }
                            } catch (Throwable th5) {
                                int i6 = TraceCompat.$r8$clinit;
                                Trace.endSection();
                                throw th5;
                            }
                            break;
                        } catch (Throwable th6) {
                            synchronized (fontRequestMetadataLoader.mLock) {
                                try {
                                    zzap zzapVar2 = fontRequestMetadataLoader.mCallback;
                                    if (zzapVar2 != null) {
                                        zzapVar2.onFailed(th6);
                                    }
                                    fontRequestMetadataLoader.cleanUp();
                                    return;
                                } catch (Throwable th7) {
                                    throw th7;
                                }
                            }
                        }
                    } catch (Throwable th8) {
                        throw th8;
                    }
                }
            default:
                ProcessLifecycleOwner processLifecycleOwner = (ProcessLifecycleOwner) this.f$0;
                LifecycleRegistry lifecycleRegistry = processLifecycleOwner.registry;
                if (processLifecycleOwner.resumedCounter == 0) {
                    processLifecycleOwner.pauseSent = true;
                    lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
                }
                if (processLifecycleOwner.startedCounter == 0 && processLifecycleOwner.pauseSent) {
                    lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
                    processLifecycleOwner.stopSent = true;
                    return;
                }
                return;
        }
    }
}
