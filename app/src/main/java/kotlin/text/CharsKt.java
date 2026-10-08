package kotlin.text;

import android.os.Handler;
import android.os.Looper;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.core.util.Preconditions;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes.dex */
public abstract class CharsKt {
    public static void checkMainThread() {
        Preconditions.checkState("Not in application's main thread", isMainThread());
    }

    public static void checkRadix(int i) {
        if (2 > i || i >= 37) {
            StringBuilder sbM = ImageAnalysis$$ExternalSyntheticLambda1.m(i, "radix ", " was not in valid range ");
            sbM.append(new IntRange(2, 36, 1));
            throw new IllegalArgumentException(sbM.toString());
        }
    }

    public static final boolean equals(char c, char c2, boolean z) {
        if (c == c2) {
            return true;
        }
        if (!z) {
            return false;
        }
        char upperCase = Character.toUpperCase(c);
        char upperCase2 = Character.toUpperCase(c2);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    public static boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static boolean isWhitespace(char c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c);
    }

    public static void runOnMain(Runnable runnable) {
        if (isMainThread()) {
            runnable.run();
        } else {
            Preconditions.checkState("Unable to post to main thread", new Handler(Looper.getMainLooper()).post(runnable));
        }
    }
}
