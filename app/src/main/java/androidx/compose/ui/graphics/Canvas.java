package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public interface Canvas {
    /* JADX INFO: renamed from: clipPath-mtrdD-E */
    void mo392clipPathmtrdDE(AndroidPath androidPath);

    /* JADX INFO: renamed from: clipRect-N_I0leg */
    void mo393clipRectN_I0leg(float f, float f2, float f3, float f4, int i);

    /* JADX INFO: renamed from: clipRect-mtrdD-E */
    void mo394clipRectmtrdDE(Rect rect);

    /* JADX INFO: renamed from: concat-58bKbWc */
    void mo395concat58bKbWc(float[] fArr);

    void disableZ();

    void drawArc(float f, float f2, float f3, float f4, float f5, float f6, AndroidPaint androidPaint);

    /* JADX INFO: renamed from: drawCircle-9KIMszo */
    void mo396drawCircle9KIMszo(float f, long j, AndroidPaint androidPaint);

    /* JADX INFO: renamed from: drawImage-d-4ec7I */
    void mo397drawImaged4ec7I(AndroidImageBitmap androidImageBitmap, long j, AndroidPaint androidPaint);

    /* JADX INFO: renamed from: drawImageRect-HPBpro0 */
    void mo398drawImageRectHPBpro0(AndroidImageBitmap androidImageBitmap, long j, long j2, long j3, AndroidPaint androidPaint);

    /* JADX INFO: renamed from: drawLine-Wko1d7g */
    void mo399drawLineWko1d7g(long j, long j2, AndroidPaint androidPaint);

    void drawPath(AndroidPath androidPath, AndroidPaint androidPaint);

    void drawRect(float f, float f2, float f3, float f4, AndroidPaint androidPaint);

    void drawRect(Rect rect, AndroidPaint androidPaint);

    void drawRoundRect(float f, float f2, float f3, float f4, float f5, float f6, AndroidPaint androidPaint);

    void enableZ();

    void restore();

    void rotate(float f);

    void save();

    void saveLayer(Rect rect, AndroidPaint androidPaint);

    void scale(float f, float f2);

    void translate(float f, float f2);
}
