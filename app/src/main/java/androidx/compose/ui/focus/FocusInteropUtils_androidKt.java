package androidx.compose.ui.focus;

import android.graphics.Rect;
import android.view.View;
import androidx.compose.ui.platform.AndroidComposeView;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class FocusInteropUtils_androidKt {
    public static final int[] tempCoordinates = new int[2];
    public static final Rect tempRect = new Rect();

    public static final androidx.compose.ui.geometry.Rect calculateFocusRectRelativeTo(View view, AndroidComposeView androidComposeView) {
        int[] iArr = tempCoordinates;
        view.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        androidComposeView.getLocationInWindow(iArr);
        int i3 = iArr[0];
        float f = i2 - iArr[1];
        Rect rect = tempRect;
        view.getFocusedRect(rect);
        float f2 = (i - i3) + rect.left;
        return new androidx.compose.ui.geometry.Rect(f2, rect.top + f, rect.width() + f2, f + rect.top + rect.height());
    }

    public static final FocusDirection toFocusDirection(int i) {
        if (i == 1) {
            return new FocusDirection(2);
        }
        if (i == 2) {
            return new FocusDirection(1);
        }
        if (i == 17) {
            return new FocusDirection(3);
        }
        if (i == 33) {
            return new FocusDirection(5);
        }
        if (i == 66) {
            return new FocusDirection(4);
        }
        if (i != 130) {
            return null;
        }
        return new FocusDirection(6);
    }
}
