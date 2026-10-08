package androidx.compose.ui.input.pointer;

import android.os.Build;
import android.view.MotionEvent;
import coil.request.RequestService;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class PointerEvent {
    public final int buttons;
    public final Object changes;
    public final int classification;
    public final RequestService internalPointerEvent;
    public final int keyboardModifiers;
    public int type;

    /* JADX WARN: Code duplicated, block: B:41:0x0078  */
    /* JADX WARN: Code duplicated, block: B:43:0x007c  */
    /* JADX WARN: Code duplicated, block: B:44:0x007e  */
    /* JADX WARN: Code duplicated, block: B:46:0x0082  */
    /* JADX WARN: Code duplicated, block: B:49:0x0087  */
    /* JADX WARN: Code duplicated, block: B:50:0x0089 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:51:0x008b  */
    /* JADX WARN: Code duplicated, block: B:52:0x008e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:54:0x0091  */
    public PointerEvent(List list, RequestService requestService) {
        MotionEvent motionEvent;
        this.changes = list;
        this.internalPointerEvent = requestService;
        int i = Build.VERSION.SDK_INT;
        int i2 = 0;
        this.classification = (i < 29 || (motionEvent = getMotionEvent()) == null) ? 0 : motionEvent.getClassification();
        MotionEvent motionEvent2 = getMotionEvent();
        this.buttons = motionEvent2 != null ? motionEvent2.getButtonState() : 0;
        MotionEvent motionEvent3 = getMotionEvent();
        this.keyboardModifiers = motionEvent3 != null ? motionEvent3.getMetaState() : 0;
        MotionEvent motionEvent4 = getMotionEvent();
        if (motionEvent4 != null) {
            boolean z = i >= 29 && motionEvent4.getClassification() == 3;
            boolean z2 = i >= 29 && motionEvent4.getClassification() == 5;
            int actionMasked = motionEvent4.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        switch (actionMasked) {
                            case 5:
                                if (z) {
                                    i2 = 10;
                                } else if (!z2) {
                                    i2 = 1;
                                } else {
                                    i2 = 8;
                                }
                                break;
                            case 6:
                                if (z) {
                                    i2 = 12;
                                } else if (!z2) {
                                    i2 = 2;
                                } else {
                                    i2 = 8;
                                }
                                break;
                            case 7:
                                if (z) {
                                    i2 = 11;
                                } else if (!z2) {
                                    i2 = 3;
                                } else {
                                    i2 = 8;
                                }
                                break;
                            case 8:
                                i2 = 6;
                                break;
                            case 9:
                                i2 = 4;
                                break;
                            case 10:
                                i2 = 5;
                                break;
                        }
                    } else if (z) {
                        i2 = 11;
                    } else if (!z2) {
                        i2 = 8;
                    } else {
                        i2 = 3;
                    }
                } else if (z) {
                    i2 = 12;
                } else if (z2) {
                    i2 = 9;
                } else {
                    i2 = 2;
                }
            } else if (z) {
                i2 = 10;
            } else if (z2) {
                i2 = 7;
            } else {
                i2 = 1;
            }
        } else {
            int size = list.size();
            while (true) {
                if (i2 < size) {
                    PointerInputChange pointerInputChange = (PointerInputChange) list.get(i2);
                    if (PointerId.changedToUpIgnoreConsumed(pointerInputChange)) {
                        i2 = 2;
                    } else if (PointerId.changedToDownIgnoreConsumed(pointerInputChange)) {
                        i2 = 1;
                    } else {
                        i2++;
                    }
                } else {
                    i2 = 3;
                }
            }
        }
        this.type = i2;
    }

    public final MotionEvent getMotionEvent() {
        RequestService requestService = this.internalPointerEvent;
        if (requestService != null) {
            return (MotionEvent) ((RequestService) requestService.hardwareBitmapService).hardwareBitmapService;
        }
        return null;
    }
}
