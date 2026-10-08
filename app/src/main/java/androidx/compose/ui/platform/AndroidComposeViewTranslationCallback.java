package androidx.compose.ui.platform;

import android.view.View;
import android.view.translation.ViewTranslationCallback;
import androidx.collection.IntObjectMap;
import androidx.collection.MutableScatterMap;
import androidx.compose.ui.contentcapture.AndroidContentCaptureManager;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsNodeWithAdjustedBounds;
import androidx.compose.ui.semantics.SemanticsProperties;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidComposeViewTranslationCallback implements ViewTranslationCallback {
    public static final AndroidComposeViewTranslationCallback INSTANCE = new AndroidComposeViewTranslationCallback();

    /* JADX WARN: Code duplicated, block: B:26:0x0076 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:27:0x0078 A[LOOP:0: B:5:0x0018->B:27:0x0078, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:30:0x007b A[EDGE_INSN: B:30:0x007b->B:28:0x007b BREAK  A[LOOP:0: B:5:0x0018->B:27:0x0078], SYNTHETIC] */
    public final boolean onClearTranslation(View view) {
        Function0 function0;
        AndroidContentCaptureManager contentCaptureManager$ui = ((AndroidComposeView) view).getContentCaptureManager$ui();
        contentCaptureManager$ui.translateStatus = 1;
        IntObjectMap currentSemanticsNodes$ui = contentCaptureManager$ui.getCurrentSemanticsNodes$ui();
        Object[] objArr = currentSemanticsNodes$ui.values;
        long[] jArr = currentSemanticsNodes$ui.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i != length) {
                        break;
                        break;
                    }
                    i++;
                } else {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            MutableScatterMap mutableScatterMap = ((SemanticsNodeWithAdjustedBounds) objArr[(i << 3) + i3]).semanticsNode.unmergedConfig.props;
                            Object obj = mutableScatterMap.get(SemanticsProperties.IsShowingTextSubstitution);
                            if (obj == null) {
                                obj = null;
                            }
                            if (obj != null) {
                                Object obj2 = mutableScatterMap.get(SemanticsActions.ClearTextSubstitution);
                                AccessibilityAction accessibilityAction = (AccessibilityAction) (obj2 != null ? obj2 : null);
                                if (accessibilityAction != null && (function0 = (Function0) accessibilityAction.action) != null) {
                                }
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    }
                    if (i != length) {
                        break;
                    }
                    i++;
                }
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x007e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x0080 A[LOOP:0: B:5:0x0018->B:28:0x0080, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:31:0x0083 A[EDGE_INSN: B:31:0x0083->B:29:0x0083 BREAK  A[LOOP:0: B:5:0x0018->B:28:0x0080], SYNTHETIC] */
    public final boolean onHideTranslation(View view) {
        Function1 function1;
        AndroidContentCaptureManager contentCaptureManager$ui = ((AndroidComposeView) view).getContentCaptureManager$ui();
        contentCaptureManager$ui.translateStatus = 1;
        IntObjectMap currentSemanticsNodes$ui = contentCaptureManager$ui.getCurrentSemanticsNodes$ui();
        Object[] objArr = currentSemanticsNodes$ui.values;
        long[] jArr = currentSemanticsNodes$ui.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i != length) {
                        break;
                        break;
                    }
                    i++;
                } else {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            MutableScatterMap mutableScatterMap = ((SemanticsNodeWithAdjustedBounds) objArr[(i << 3) + i3]).semanticsNode.unmergedConfig.props;
                            Object obj = mutableScatterMap.get(SemanticsProperties.IsShowingTextSubstitution);
                            if (obj == null) {
                                obj = null;
                            }
                            if (Intrinsics.areEqual(obj, Boolean.TRUE)) {
                                Object obj2 = mutableScatterMap.get(SemanticsActions.ShowTextSubstitution);
                                AccessibilityAction accessibilityAction = (AccessibilityAction) (obj2 != null ? obj2 : null);
                                if (accessibilityAction != null && (function1 = (Function1) accessibilityAction.action) != null) {
                                }
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    }
                    if (i != length) {
                        break;
                    }
                    i++;
                }
            }
        }
        return true;
    }

    public final boolean onShowTranslation(View view) {
        Function1 function1;
        AndroidContentCaptureManager contentCaptureManager$ui = ((AndroidComposeView) view).getContentCaptureManager$ui();
        contentCaptureManager$ui.translateStatus = 2;
        IntObjectMap currentSemanticsNodes$ui = contentCaptureManager$ui.getCurrentSemanticsNodes$ui();
        Object[] objArr = currentSemanticsNodes$ui.values;
        long[] jArr = currentSemanticsNodes$ui.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return true;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        MutableScatterMap mutableScatterMap = ((SemanticsNodeWithAdjustedBounds) objArr[(i << 3) + i3]).semanticsNode.unmergedConfig.props;
                        Object obj = mutableScatterMap.get(SemanticsProperties.IsShowingTextSubstitution);
                        if (obj == null) {
                            obj = null;
                        }
                        if (Intrinsics.areEqual(obj, Boolean.FALSE)) {
                            Object obj2 = mutableScatterMap.get(SemanticsActions.ShowTextSubstitution);
                            AccessibilityAction accessibilityAction = (AccessibilityAction) (obj2 != null ? obj2 : null);
                            if (accessibilityAction != null && (function1 = (Function1) accessibilityAction.action) != null) {
                            }
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return true;
                }
            }
            if (i == length) {
                return true;
            }
            i++;
        }
    }
}
