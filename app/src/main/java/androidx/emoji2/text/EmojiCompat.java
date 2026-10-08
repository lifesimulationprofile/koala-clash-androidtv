package androidx.emoji2.text;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import androidx.collection.ArraySet;
import androidx.core.provider.CallbackWrapper$2;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.flatbuffer.MetadataList;
import androidx.recyclerview.widget.OrientationHelper$1;
import androidx.recyclerview.widget.RecyclerView;
import coil.ImageLoader$Builder;
import coil.request.RequestService;
import com.google.android.gms.internal.mlkit_vision_common.zzap;
import com.google.android.gms.internal.mlkit_vision_common.zzaq;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import okhttp3.Dispatcher;
import okio.AsyncTimeout;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class EmojiCompat {
    public static final Object INSTANCE_LOCK = new Object();
    public static volatile EmojiCompat sInstance;
    public final DefaultGlyphChecker mGlyphChecker;
    public final CompatInternal19 mHelper;
    public final ArraySet mInitCallbacks;
    public final ReentrantReadWriteLock mInitLock;
    public volatile int mLoadState;
    public final Handler mMainHandler;
    public final int mMetadataLoadStrategy;
    public final MetadataRepoLoader mMetadataLoader;
    public final AsyncTimeout.Companion mSpanFactory;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class CompatInternal19 {
        public final EmojiCompat mEmojiCompat;
        public volatile Dispatcher mMetadataRepo;
        public volatile ImageLoader$Builder mProcessor;

        /* JADX INFO: renamed from: androidx.emoji2.text.EmojiCompat$CompatInternal19$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
        public final class AnonymousClass1 extends zzap {
            public AnonymousClass1() {
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzap
            public final void onFailed(Throwable th) {
                CompatInternal19.this.mEmojiCompat.onMetadataLoadFailed(th);
            }

            @Override // com.google.android.gms.internal.mlkit_vision_common.zzap
            public final void onLoaded(Dispatcher dispatcher) {
                CompatInternal19 compatInternal19 = CompatInternal19.this;
                compatInternal19.mMetadataRepo = dispatcher;
                Dispatcher dispatcher2 = compatInternal19.mMetadataRepo;
                EmojiCompat emojiCompat = compatInternal19.mEmojiCompat;
                compatInternal19.mProcessor = new ImageLoader$Builder(dispatcher2, emojiCompat.mSpanFactory, emojiCompat.mGlyphChecker, Build.VERSION.SDK_INT >= 34 ? EmojiExclusions$EmojiExclusions_Api34.getExclusions() : zzaq.getExclusions());
                EmojiCompat emojiCompat2 = compatInternal19.mEmojiCompat;
                emojiCompat2.getClass();
                ArrayList arrayList = new ArrayList();
                emojiCompat2.mInitLock.writeLock().lock();
                try {
                    emojiCompat2.mLoadState = 1;
                    arrayList.addAll(emojiCompat2.mInitCallbacks);
                    emojiCompat2.mInitCallbacks.clear();
                    emojiCompat2.mInitLock.writeLock().unlock();
                    emojiCompat2.mMainHandler.post(new CallbackWrapper$2(arrayList, emojiCompat2.mLoadState, (Throwable) null));
                } catch (Throwable th) {
                    emojiCompat2.mInitLock.writeLock().unlock();
                    throw th;
                }
            }
        }

        public CompatInternal19(EmojiCompat emojiCompat) {
            this.mEmojiCompat = emojiCompat;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public interface GlyphChecker {
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public interface MetadataRepoLoader {
        void load(zzap zzapVar);
    }

    public EmojiCompat(FontRequestEmojiCompatConfig fontRequestEmojiCompatConfig) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.mInitLock = reentrantReadWriteLock;
        this.mLoadState = 3;
        MetadataRepoLoader metadataRepoLoader = (MetadataRepoLoader) fontRequestEmojiCompatConfig.mMetadataLoader;
        this.mMetadataLoader = metadataRepoLoader;
        int i = fontRequestEmojiCompatConfig.mMetadataLoadStrategy;
        this.mMetadataLoadStrategy = i;
        this.mGlyphChecker = (DefaultGlyphChecker) fontRequestEmojiCompatConfig.mGlyphChecker;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mInitCallbacks = new ArraySet(0);
        this.mSpanFactory = new AsyncTimeout.Companion(9);
        CompatInternal19 compatInternal19 = new CompatInternal19(this);
        this.mHelper = compatInternal19;
        reentrantReadWriteLock.writeLock().lock();
        if (i == 0) {
            try {
                this.mLoadState = 0;
            } catch (Throwable th) {
                this.mInitLock.writeLock().unlock();
                throw th;
            }
        }
        reentrantReadWriteLock.writeLock().unlock();
        if (getLoadState() == 0) {
            try {
                metadataRepoLoader.load(compatInternal19.new AnonymousClass1());
            } catch (Throwable th2) {
                onMetadataLoadFailed(th2);
            }
        }
    }

    public static EmojiCompat get() {
        EmojiCompat emojiCompat;
        synchronized (INSTANCE_LOCK) {
            emojiCompat = sInstance;
            Preconditions.checkState("EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.", emojiCompat != null);
        }
        return emojiCompat;
    }

    public static boolean isConfigured() {
        return sInstance != null;
    }

    public final int getEmojiStart(CharSequence charSequence, int i) {
        Preconditions.checkState("Not initialized yet", getLoadState() == 1);
        Preconditions.checkNotNull(charSequence, "charSequence cannot be null");
        ImageLoader$Builder imageLoader$Builder = this.mHelper.mProcessor;
        imageLoader$Builder.getClass();
        if (i < 0 || i >= charSequence.length()) {
            return -1;
        }
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            TypefaceEmojiSpan[] typefaceEmojiSpanArr = (TypefaceEmojiSpan[]) spanned.getSpans(i, i + 1, TypefaceEmojiSpan.class);
            if (typefaceEmojiSpanArr.length > 0) {
                return spanned.getSpanStart(typefaceEmojiSpanArr[0]);
            }
        }
        return ((EmojiProcessor$EmojiProcessLookupCallback) imageLoader$Builder.process(charSequence, Math.max(0, i - 16), Math.min(charSequence.length(), i + 16), Integer.MAX_VALUE, true, new EmojiProcessor$EmojiProcessLookupCallback(i))).start;
    }

    public final int getLoadState() {
        this.mInitLock.readLock().lock();
        try {
            return this.mLoadState;
        } finally {
            this.mInitLock.readLock().unlock();
        }
    }

    public final void load() {
        Preconditions.checkState("Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading", this.mMetadataLoadStrategy == 1);
        if (getLoadState() == 1) {
            return;
        }
        this.mInitLock.writeLock().lock();
        try {
            if (this.mLoadState == 0) {
                this.mInitLock.writeLock().unlock();
                return;
            }
            this.mLoadState = 0;
            this.mInitLock.writeLock().unlock();
            CompatInternal19 compatInternal19 = this.mHelper;
            EmojiCompat emojiCompat = compatInternal19.mEmojiCompat;
            try {
                emojiCompat.mMetadataLoader.load(compatInternal19.new AnonymousClass1());
            } catch (Throwable th) {
                emojiCompat.onMetadataLoadFailed(th);
            }
        } catch (Throwable th2) {
            this.mInitLock.writeLock().unlock();
            throw th2;
        }
    }

    public final void onMetadataLoadFailed(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.mInitLock.writeLock().lock();
        try {
            this.mLoadState = 2;
            arrayList.addAll(this.mInitCallbacks);
            this.mInitCallbacks.clear();
            this.mInitLock.writeLock().unlock();
            this.mMainHandler.post(new CallbackWrapper$2(arrayList, this.mLoadState, th));
        } catch (Throwable th2) {
            this.mInitLock.writeLock().unlock();
            throw th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:55:0x00a8 A[Catch: all -> 0x008b, TryCatch #2 {all -> 0x008b, blocks: (B:35:0x0063, B:38:0x0068, B:40:0x006c, B:42:0x0079, B:49:0x0098, B:51:0x00a2, B:53:0x00a5, B:55:0x00a8, B:57:0x00b8, B:58:0x00bb), top: B:94:0x0063 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00b8 A[Catch: all -> 0x008b, TryCatch #2 {all -> 0x008b, blocks: (B:35:0x0063, B:38:0x0068, B:40:0x006c, B:42:0x0079, B:49:0x0098, B:51:0x00a2, B:53:0x00a5, B:55:0x00a8, B:57:0x00b8, B:58:0x00bb), top: B:94:0x0063 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:83:0x0108  */
    /* JADX WARN: Code duplicated, block: B:97:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:? A[RETURN, SYNTHETIC] */
    public final CharSequence process(int i, int i2, int i3, CharSequence charSequence) {
        CharSequence charSequence2;
        Throwable th;
        int i4;
        int i5;
        TypefaceEmojiSpan[] typefaceEmojiSpanArr;
        int spanStart;
        Preconditions.checkState("Not initialized yet", getLoadState() == 1);
        if (i < 0) {
            throw new IllegalArgumentException("start cannot be negative");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("end cannot be negative");
        }
        Preconditions.checkArgument("start should be <= than end", i <= i2);
        UnprecomputeTextOnModificationSpannable unprecomputeTextOnModificationSpannable = null;
        if (charSequence == null) {
            return null;
        }
        Preconditions.checkArgument("start should be < than charSequence length", i <= charSequence.length());
        Preconditions.checkArgument("end should be < than charSequence length", i2 <= charSequence.length());
        if (charSequence.length() == 0 || i == i2) {
            return charSequence;
        }
        boolean z = i3 == 1;
        ImageLoader$Builder imageLoader$Builder = this.mHelper.mProcessor;
        imageLoader$Builder.getClass();
        boolean z2 = charSequence instanceof SpannableBuilder;
        if (z2) {
            ((SpannableBuilder) charSequence).blockWatchers();
        }
        if (z2) {
            unprecomputeTextOnModificationSpannable = new UnprecomputeTextOnModificationSpannable((Spannable) charSequence);
            if (unprecomputeTextOnModificationSpannable != null) {
                for (TypefaceEmojiSpan typefaceEmojiSpan : typefaceEmojiSpanArr) {
                    spanStart = unprecomputeTextOnModificationSpannable.mDelegate.getSpanStart(typefaceEmojiSpan);
                    int spanEnd = unprecomputeTextOnModificationSpannable.mDelegate.getSpanEnd(typefaceEmojiSpan);
                    if (spanStart != i2) {
                        unprecomputeTextOnModificationSpannable.removeSpan(typefaceEmojiSpan);
                    }
                    i = Math.min(spanStart, i);
                    i2 = Math.max(spanEnd, i2);
                }
            }
            i4 = i;
            i5 = i2;
            if (i4 != i5) {
                charSequence2 = charSequence;
                if (!z2) {
                    return charSequence2;
                }
            } else {
                charSequence2 = charSequence;
                if (!z2) {
                    return charSequence2;
                }
            }
            ((SpannableBuilder) charSequence2).endBatchEdit();
            return charSequence2;
        }
        try {
            if (charSequence instanceof Spannable) {
                try {
                    unprecomputeTextOnModificationSpannable = new UnprecomputeTextOnModificationSpannable((Spannable) charSequence);
                } catch (Throwable th2) {
                    th = th2;
                    charSequence2 = charSequence;
                    th = th;
                    if (!z2) {
                        throw th;
                    }
                    ((SpannableBuilder) charSequence2).endBatchEdit();
                    throw th;
                }
            } else if ((charSequence instanceof Spanned) && ((Spanned) charSequence).nextSpanTransition(i - 1, i2 + 1, TypefaceEmojiSpan.class) <= i2) {
                unprecomputeTextOnModificationSpannable = new UnprecomputeTextOnModificationSpannable();
                unprecomputeTextOnModificationSpannable.mSafeToWrite = false;
                unprecomputeTextOnModificationSpannable.mDelegate = new SpannableString(charSequence);
            }
            if (unprecomputeTextOnModificationSpannable != null && (typefaceEmojiSpanArr = (TypefaceEmojiSpan[]) unprecomputeTextOnModificationSpannable.mDelegate.getSpans(i, i2, TypefaceEmojiSpan.class)) != null && typefaceEmojiSpanArr.length > 0) {
                while (i < r3) {
                    spanStart = unprecomputeTextOnModificationSpannable.mDelegate.getSpanStart(typefaceEmojiSpan);
                    int spanEnd2 = unprecomputeTextOnModificationSpannable.mDelegate.getSpanEnd(typefaceEmojiSpan);
                    if (spanStart != i2) {
                        unprecomputeTextOnModificationSpannable.removeSpan(typefaceEmojiSpan);
                    }
                    i = Math.min(spanStart, i);
                    i2 = Math.max(spanEnd2, i2);
                }
            }
            i4 = i;
            i5 = i2;
            if (i4 != i5 || i4 >= charSequence.length()) {
                charSequence2 = charSequence;
                if (!z2) {
                    return charSequence2;
                }
            } else {
                charSequence2 = charSequence;
                try {
                    UnprecomputeTextOnModificationSpannable unprecomputeTextOnModificationSpannable2 = (UnprecomputeTextOnModificationSpannable) imageLoader$Builder.process(charSequence2, i4, i5, Integer.MAX_VALUE, z, new RequestService(16, unprecomputeTextOnModificationSpannable, (AsyncTimeout.Companion) imageLoader$Builder.applicationContext));
                    if (unprecomputeTextOnModificationSpannable2 != null) {
                        Spannable spannable = unprecomputeTextOnModificationSpannable2.mDelegate;
                        if (z2) {
                            ((SpannableBuilder) charSequence2).endBatchEdit();
                        }
                        return spannable;
                    }
                    if (!z2) {
                        return charSequence2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                    if (!z2) {
                        throw th;
                    }
                    ((SpannableBuilder) charSequence2).endBatchEdit();
                    throw th;
                }
            }
            ((SpannableBuilder) charSequence2).endBatchEdit();
            return charSequence2;
        } catch (Throwable th4) {
            th = th4;
            charSequence2 = charSequence;
        }
        if (!z2) {
            throw th;
        }
        ((SpannableBuilder) charSequence2).endBatchEdit();
        throw th;
    }

    public final void registerInitCallback(InitCallback initCallback) {
        Preconditions.checkNotNull(initCallback, "initCallback cannot be null");
        this.mInitLock.writeLock().lock();
        try {
            if (this.mLoadState == 1 || this.mLoadState == 2) {
                this.mMainHandler.post(new CallbackWrapper$2(Arrays.asList(initCallback), this.mLoadState, (Throwable) null));
            } else {
                this.mInitCallbacks.add(initCallback);
            }
        } finally {
            this.mInitLock.writeLock().unlock();
        }
    }

    public final void updateEditorInfo(EditorInfo editorInfo) {
        if (getLoadState() != 1 || editorInfo == null) {
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        CompatInternal19 compatInternal19 = this.mHelper;
        compatInternal19.getClass();
        Bundle bundle = editorInfo.extras;
        MetadataList metadataList = (MetadataList) compatInternal19.mMetadataRepo.executorServiceOrNull;
        int i__offset = metadataList.__offset(4);
        bundle.putInt("android.support.text.emoji.emojiCompat_metadataVersion", i__offset != 0 ? ((ByteBuffer) metadataList.bb).getInt(i__offset + metadataList.bb_pos) : 0);
        editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", false);
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class Config {
        public final Object mGlyphChecker;
        public int mMetadataLoadStrategy;
        public final Object mMetadataLoader;

        public Config(RecyclerView.LayoutManager layoutManager) {
            this.mMetadataLoadStrategy = Integer.MIN_VALUE;
            this.mGlyphChecker = new Rect();
            this.mMetadataLoader = layoutManager;
        }

        public static Config createOrientationHelper(RecyclerView.LayoutManager layoutManager, int i) {
            if (i == 0) {
                return new OrientationHelper$1(layoutManager, 0);
            }
            if (i == 1) {
                return new OrientationHelper$1(layoutManager, 1);
            }
            throw new IllegalArgumentException("invalid orientation");
        }

        public abstract int getDecoratedEnd(View view);

        public abstract int getDecoratedMeasurement(View view);

        public abstract int getDecoratedMeasurementInOther(View view);

        public abstract int getDecoratedStart(View view);

        public abstract int getEnd();

        public abstract int getEndAfterPadding();

        public abstract int getEndPadding();

        public abstract int getMode();

        public abstract int getModeInOther();

        public abstract int getStartAfterPadding();

        public abstract int getTotalSpace();

        public abstract int getTransformedEndWithDecoration(View view);

        public abstract int getTransformedStartWithDecoration(View view);

        public abstract void offsetChildren(int i);

        public Config(MetadataRepoLoader metadataRepoLoader) {
            this.mMetadataLoadStrategy = 0;
            this.mGlyphChecker = new DefaultGlyphChecker();
            this.mMetadataLoader = metadataRepoLoader;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class InitCallback {
        public abstract void onInitialized();

        public void onFailed() {
        }
    }
}
