package com.github.kr328.clash.log;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.collection.CircularArray;
import androidx.compose.ui.text.android.CharSequenceCharacterIterator;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.emoji2.text.EmojiCompat;
import com.github.kr328.clash.core.model.LogMessage;
import com.google.android.gms.internal.mlkit_vision_barcode.zztq;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LogcatCache {
    public final /* synthetic */ int $r8$classId;
    public int appended;
    public Object array;
    public Object lock;
    public int removed;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Snapshot {
        public final int appended;
        public final ArrayList messages;
        public final int removed;

        public Snapshot(ArrayList arrayList, int i, int i2) {
            this.messages = arrayList;
            this.removed = i;
            this.appended = i2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Snapshot)) {
                return false;
            }
            Snapshot snapshot = (Snapshot) obj;
            return this.messages.equals(snapshot.messages) && this.removed == snapshot.removed && this.appended == snapshot.appended;
        }

        public final int hashCode() {
            return (((this.messages.hashCode() * 31) + this.removed) * 31) + this.appended;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Snapshot(messages=");
            sb.append(this.messages);
            sb.append(", removed=");
            sb.append(this.removed);
            sb.append(", appended=");
            return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.appended, ")");
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.log.LogcatCache$append$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends ContinuationImpl {
        public LogcatCache L$0;
        public LogMessage L$1;
        public MutexImpl L$2;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LogcatCache.this.append(null, this);
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.log.LogcatCache$snapshot$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class C00251 extends ContinuationImpl {
        public LogcatCache L$0;
        public MutexImpl L$1;
        public boolean Z$0;
        public int label;
        public /* synthetic */ Object result;

        public C00251(ContinuationImpl continuationImpl) {
            super(continuationImpl);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LogcatCache.this.snapshot(false, this);
        }
    }

    public LogcatCache(int i) {
        this.$r8$classId = i;
        switch (i) {
            case 2:
                break;
            default:
                CircularArray circularArray = new CircularArray(0);
                int iHighestOneBit = Integer.bitCount(128) != 1 ? Integer.highestOneBit(127) << 1 : 128;
                circularArray.capacityBitmask = iHighestOneBit - 1;
                circularArray.elements = new Object[iHighestOneBit];
                this.array = circularArray;
                this.lock = new MutexImpl();
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public Object append(LogMessage logMessage, ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        LogcatCache logcatCache;
        LogMessage logMessage2;
        MutexImpl mutexImpl;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object obj = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            MutexImpl mutexImpl2 = (MutexImpl) this.lock;
            anonymousClass1.L$0 = this;
            anonymousClass1.L$1 = logMessage;
            anonymousClass1.L$2 = mutexImpl2;
            anonymousClass1.label = 1;
            Object objLock = mutexImpl2.lock(anonymousClass1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objLock == coroutineSingletons) {
                return coroutineSingletons;
            }
            logcatCache = this;
            logMessage2 = logMessage;
            mutexImpl = mutexImpl2;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutexImpl = anonymousClass1.L$2;
            logMessage2 = anonymousClass1.L$1;
            logcatCache = anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        try {
            CircularArray circularArray = (CircularArray) logcatCache.array;
            if (circularArray.size() >= 128) {
                circularArray.removeFromStart();
                logcatCache.removed++;
                logcatCache.appended--;
            }
            circularArray.addLast(logMessage2);
            logcatCache.appended++;
            return Unit.INSTANCE;
        } finally {
            mutexImpl.unlock(null);
        }
    }

    public void checkOffsetIsValid(int i) {
        int i2 = this.removed;
        int i3 = this.appended;
        boolean z = false;
        if (i <= i3 && i2 <= i) {
            z = true;
        }
        if (z) {
            return;
        }
        InlineClassHelperKt.throwIllegalArgumentException("Invalid offset: " + i + ". Valid range is [" + i2 + " , " + i3 + ']');
    }

    public int getLength() {
        CircularArray circularArray = (CircularArray) this.lock;
        if (circularArray == null) {
            return ((String) this.array).length();
        }
        return (circularArray.head - circularArray.gapLength()) + (((String) this.array).length() - (this.appended - this.removed));
    }

    public boolean isAfterLetterOrDigitOrEmoji(int i) {
        CharSequence charSequence = (CharSequence) this.array;
        int i2 = this.removed + 1;
        if (i > this.appended || i2 > i) {
            return false;
        }
        if (!Character.isLetterOrDigit(Character.codePointBefore(charSequence, i))) {
            int i3 = i - 1;
            if (!Character.isSurrogate(charSequence.charAt(i3))) {
                if (!EmojiCompat.isConfigured()) {
                    return false;
                }
                EmojiCompat emojiCompat = EmojiCompat.get();
                if (emojiCompat.getLoadState() != 1 || emojiCompat.getEmojiStart(charSequence, i3) == -1) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isAfterPunctuation(int i) {
        int i2 = this.removed + 1;
        if (i > this.appended || i2 > i) {
            return false;
        }
        return zztq.isPunctuation$ui_text(Character.codePointBefore((CharSequence) this.array, i));
    }

    public boolean isBoundary(int i) {
        checkOffsetIsValid(i);
        if (!((BreakIterator) this.lock).isBoundary(i)) {
            return false;
        }
        if (isOnLetterOrDigitOrEmoji(i) && isOnLetterOrDigitOrEmoji(i - 1) && isOnLetterOrDigitOrEmoji(i + 1)) {
            return false;
        }
        return i <= 0 || i >= ((CharSequence) this.array).length() - 1 || !(isHiraganaKatakanaBoundary(i) || isHiraganaKatakanaBoundary(i + 1));
    }

    public boolean isHiraganaKatakanaBoundary(int i) {
        CharSequence charSequence = (CharSequence) this.array;
        int i2 = i - 1;
        Character.UnicodeBlock unicodeBlockOf = Character.UnicodeBlock.of(charSequence.charAt(i2));
        Character.UnicodeBlock unicodeBlock = Character.UnicodeBlock.HIRAGANA;
        if (Intrinsics.areEqual(unicodeBlockOf, unicodeBlock) && Intrinsics.areEqual(Character.UnicodeBlock.of(charSequence.charAt(i)), Character.UnicodeBlock.KATAKANA)) {
            return true;
        }
        return Intrinsics.areEqual(Character.UnicodeBlock.of(charSequence.charAt(i)), unicodeBlock) && Intrinsics.areEqual(Character.UnicodeBlock.of(charSequence.charAt(i2)), Character.UnicodeBlock.KATAKANA);
    }

    public boolean isOnLetterOrDigitOrEmoji(int i) {
        CharSequence charSequence = (CharSequence) this.array;
        int i2 = this.removed;
        if (i >= this.appended || i2 > i) {
            return false;
        }
        if (!Character.isLetterOrDigit(Character.codePointAt(charSequence, i)) && !Character.isSurrogate(charSequence.charAt(i))) {
            if (!EmojiCompat.isConfigured()) {
                return false;
            }
            EmojiCompat emojiCompat = EmojiCompat.get();
            if (emojiCompat.getLoadState() != 1 || emojiCompat.getEmojiStart(charSequence, i) == -1) {
                return false;
            }
        }
        return true;
    }

    public boolean isOnPunctuation(int i) {
        int i2 = this.removed;
        if (i >= this.appended || i2 > i) {
            return false;
        }
        return zztq.isPunctuation$ui_text(Character.codePointAt((CharSequence) this.array, i));
    }

    public int nextBoundary(int i) {
        checkOffsetIsValid(i);
        int iFollowing = ((BreakIterator) this.lock).following(i);
        return (isOnLetterOrDigitOrEmoji(iFollowing + (-1)) && isOnLetterOrDigitOrEmoji(iFollowing) && !isHiraganaKatakanaBoundary(iFollowing)) ? nextBoundary(iFollowing) : iFollowing;
    }

    public int prevBoundary(int i) {
        checkOffsetIsValid(i);
        int iPreceding = ((BreakIterator) this.lock).preceding(i);
        return (isOnLetterOrDigitOrEmoji(iPreceding) && isAfterLetterOrDigitOrEmoji(iPreceding) && !isHiraganaKatakanaBoundary(iPreceding)) ? prevBoundary(iPreceding) : iPreceding;
    }

    public void replace(int i, int i2, String str) {
        if (i > i2) {
            InlineClassHelperKt.throwIllegalArgumentException("start index must be less than or equal to end index: " + i + " > " + i2);
        }
        if (i < 0) {
            InlineClassHelperKt.throwIllegalArgumentException("start must be non-negative, but was " + i);
        }
        CircularArray circularArray = (CircularArray) this.lock;
        if (circularArray == null) {
            int iMax = Math.max(255, str.length() + 128);
            char[] cArr = new char[iMax];
            int iMin = Math.min(i, 64);
            int iMin2 = Math.min(((String) this.array).length() - i2, 64);
            int i3 = i - iMin;
            ((String) this.array).getChars(i3, i, cArr, 0);
            int i4 = iMax - iMin2;
            int i5 = iMin2 + i2;
            ((String) this.array).getChars(i2, i5, cArr, i4);
            str.getChars(0, str.length(), cArr, iMin);
            int length = str.length() + iMin;
            CircularArray circularArray2 = new CircularArray(2);
            circularArray2.head = iMax;
            circularArray2.elements = cArr;
            circularArray2.tail = length;
            circularArray2.capacityBitmask = i4;
            this.lock = circularArray2;
            this.removed = i3;
            this.appended = i5;
            return;
        }
        int i6 = this.removed;
        int i7 = i - i6;
        int i8 = i2 - i6;
        if (i7 < 0 || i8 > circularArray.head - circularArray.gapLength()) {
            this.array = toString();
            this.lock = null;
            this.removed = -1;
            this.appended = -1;
            replace(i, i2, str);
            return;
        }
        int length2 = str.length() - (i8 - i7);
        if (length2 > circularArray.gapLength()) {
            int iGapLength = length2 - circularArray.gapLength();
            int i9 = circularArray.head;
            do {
                i9 *= 2;
            } while (i9 - circularArray.head < iGapLength);
            char[] cArr2 = new char[i9];
            System.arraycopy((char[]) circularArray.elements, 0, cArr2, 0, circularArray.tail);
            int i10 = circularArray.head;
            int i11 = circularArray.capacityBitmask;
            int i12 = i10 - i11;
            int i13 = i9 - i12;
            System.arraycopy((char[]) circularArray.elements, i11, cArr2, i13, (i12 + i11) - i11);
            circularArray.elements = cArr2;
            circularArray.head = i9;
            circularArray.capacityBitmask = i13;
        }
        int i14 = circularArray.tail;
        if (i7 < i14 && i8 <= i14) {
            int i15 = i14 - i8;
            char[] cArr3 = (char[]) circularArray.elements;
            System.arraycopy(cArr3, i8, cArr3, circularArray.capacityBitmask - i15, i15);
            circularArray.tail = i7;
            circularArray.capacityBitmask -= i15;
        } else if (i7 >= i14 || i8 < i14) {
            int iGapLength2 = circularArray.gapLength() + i7;
            int iGapLength3 = circularArray.gapLength() + i8;
            int i16 = circularArray.capacityBitmask;
            int i17 = iGapLength2 - i16;
            char[] cArr4 = (char[]) circularArray.elements;
            System.arraycopy(cArr4, i16, cArr4, circularArray.tail, i17);
            circularArray.tail += i17;
            circularArray.capacityBitmask = iGapLength3;
        } else {
            circularArray.capacityBitmask = circularArray.gapLength() + i8;
            circularArray.tail = i7;
        }
        str.getChars(0, str.length(), (char[]) circularArray.elements, circularArray.tail);
        circularArray.tail = str.length() + circularArray.tail;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x005c A[Catch: all -> 0x005a, TryCatch #0 {all -> 0x005a, blocks: (B:20:0x0050, B:22:0x0054, B:27:0x005c, B:30:0x006f, B:32:0x0075, B:34:0x008c, B:35:0x0091, B:33:0x0089, B:36:0x0092, B:38:0x0096, B:40:0x00a0, B:39:0x009e), top: B:45:0x0050 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x006d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x006f A[Catch: all -> 0x005a, TryCatch #0 {all -> 0x005a, blocks: (B:20:0x0050, B:22:0x0054, B:27:0x005c, B:30:0x006f, B:32:0x0075, B:34:0x008c, B:35:0x0091, B:33:0x0089, B:36:0x0092, B:38:0x0096, B:40:0x00a0, B:39:0x009e), top: B:45:0x0050 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x0075 A[Catch: all -> 0x005a, LOOP:0: B:28:0x006b->B:32:0x0075, LOOP_END, TryCatch #0 {all -> 0x005a, blocks: (B:20:0x0050, B:22:0x0054, B:27:0x005c, B:30:0x006f, B:32:0x0075, B:34:0x008c, B:35:0x0091, B:33:0x0089, B:36:0x0092, B:38:0x0096, B:40:0x00a0, B:39:0x009e), top: B:45:0x0050 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x0096 A[Catch: all -> 0x005a, TryCatch #0 {all -> 0x005a, blocks: (B:20:0x0050, B:22:0x0054, B:27:0x005c, B:30:0x006f, B:32:0x0075, B:34:0x008c, B:35:0x0091, B:33:0x0089, B:36:0x0092, B:38:0x0096, B:40:0x00a0, B:39:0x009e), top: B:45:0x0050 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x009e A[Catch: all -> 0x005a, TryCatch #0 {all -> 0x005a, blocks: (B:20:0x0050, B:22:0x0054, B:27:0x005c, B:30:0x006f, B:32:0x0075, B:34:0x008c, B:35:0x0091, B:33:0x0089, B:36:0x0092, B:38:0x0096, B:40:0x00a0, B:39:0x009e), top: B:45:0x0050 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x0089 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x008c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public Object snapshot(boolean z, ContinuationImpl continuationImpl) {
        C00251 c00251;
        MutexImpl mutexImpl;
        LogcatCache logcatCache;
        Snapshot snapshot;
        CircularArray circularArray;
        int size;
        ArrayList arrayList;
        int i;
        int size2;
        if (continuationImpl instanceof C00251) {
            c00251 = (C00251) continuationImpl;
            int i2 = c00251.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c00251.label = i2 - Integer.MIN_VALUE;
            } else {
                c00251 = new C00251(continuationImpl);
            }
        } else {
            c00251 = new C00251(continuationImpl);
        }
        Object obj = c00251.result;
        int i3 = c00251.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            mutexImpl = (MutexImpl) this.lock;
            c00251.L$0 = this;
            c00251.L$1 = mutexImpl;
            c00251.Z$0 = z;
            c00251.label = 1;
            Object objLock = mutexImpl.lock(c00251);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objLock == coroutineSingletons) {
                return coroutineSingletons;
            }
            logcatCache = this;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z = c00251.Z$0;
            mutexImpl = c00251.L$1;
            logcatCache = c00251.L$0;
            ResultKt.throwOnFailure(obj);
        }
        if (z) {
            circularArray = (CircularArray) logcatCache.array;
            size = circularArray.size();
            arrayList = new ArrayList(size);
            for (i = 0; i < size; i++) {
                if (i >= 0) {
                    circularArray.getClass();
                } else if (i < circularArray.size()) {
                    arrayList.add((LogMessage) ((Object[]) circularArray.elements)[(circularArray.head + i) & circularArray.capacityBitmask]);
                }
                throw new ArrayIndexOutOfBoundsException();
            }
            int i4 = logcatCache.removed;
            if (z) {
                size2 = circularArray.size() + logcatCache.appended;
            } else {
                size2 = logcatCache.appended;
            }
            snapshot = new Snapshot(arrayList, i4, size2);
            logcatCache.removed = 0;
            logcatCache.appended = 0;
        } else {
            try {
                if (logcatCache.removed == 0 && logcatCache.appended == 0) {
                    snapshot = null;
                } else {
                    circularArray = (CircularArray) logcatCache.array;
                    size = circularArray.size();
                    arrayList = new ArrayList(size);
                    while (i < size) {
                        if (i >= 0) {
                            circularArray.getClass();
                        } else if (i < circularArray.size()) {
                            arrayList.add((LogMessage) ((Object[]) circularArray.elements)[(circularArray.head + i) & circularArray.capacityBitmask]);
                        }
                        throw new ArrayIndexOutOfBoundsException();
                    }
                    int i5 = logcatCache.removed;
                    if (z) {
                        size2 = circularArray.size() + logcatCache.appended;
                    } else {
                        size2 = logcatCache.appended;
                    }
                    snapshot = new Snapshot(arrayList, i5, size2);
                    logcatCache.removed = 0;
                    logcatCache.appended = 0;
                }
            } catch (Throwable th) {
                mutexImpl.unlock(null);
                throw th;
            }
        }
        mutexImpl.unlock(null);
        return snapshot;
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 2:
                CircularArray circularArray = (CircularArray) this.lock;
                if (circularArray == null) {
                    return (String) this.array;
                }
                StringBuilder sb = new StringBuilder();
                sb.append((CharSequence) this.array, 0, this.removed);
                sb.append((char[]) circularArray.elements, 0, circularArray.tail);
                char[] cArr = (char[]) circularArray.elements;
                int i = circularArray.capacityBitmask;
                sb.append(cArr, i, circularArray.head - i);
                String str = (String) this.array;
                sb.append((CharSequence) str, this.appended, str.length());
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public LogcatCache(CharSequence charSequence, int i, Locale locale) {
        this.$r8$classId = 1;
        this.array = charSequence;
        if (charSequence.length() < 0) {
            InlineClassHelperKt.throwIllegalArgumentException("input start index is outside the CharSequence");
        }
        if (i < 0 || i > charSequence.length()) {
            InlineClassHelperKt.throwIllegalArgumentException("input end index is outside the CharSequence");
        }
        BreakIterator wordInstance = BreakIterator.getWordInstance(locale);
        this.lock = wordInstance;
        this.removed = Math.max(0, -50);
        this.appended = Math.min(charSequence.length(), i + 50);
        wordInstance.setText(new CharSequenceCharacterIterator(charSequence, i));
    }
}
