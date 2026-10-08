package io.github.g00fy2.quickie;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.ColorUtils;
import androidx.viewbinding.ViewBindings;
import coil.decode.BitmapFactoryDecoder$$ExternalSyntheticLambda2;
import com.koala.clash.R;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class QROverlayView extends FrameLayout {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final int accentColor;
    public final Paint alphaPaint;
    public final int backgroundColor;
    public final Dispatcher binding;
    public final int grayColor;
    public float horizontalFrameRatio;
    public final RectF innerFrame;
    public final float innerRadius;
    public boolean isHighlighted;
    public boolean isLoading;
    public final Paint loadingBackgroundPaint;
    public Bitmap maskBitmap;
    public Canvas maskCanvas;
    public final RectF outerFrame;
    public final float outerRadius;
    public final Paint strokePaint;
    public final Paint transparentPaint;

    public QROverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        LayoutInflater.from(context).inflate(R.layout.quickie_overlay_view, this);
        int i = R.id.close_image_view;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.close_image_view);
        if (appCompatImageView != null) {
            i = R.id.progress_view;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(this, R.id.progress_view);
            if (linearLayout != null) {
                i = R.id.title_text_view;
                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(this, R.id.title_text_view);
                if (appCompatTextView != null) {
                    i = R.id.torch_image_view;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(this, R.id.torch_image_view);
                    if (appCompatImageView2 != null) {
                        this.binding = new Dispatcher(appCompatImageView, linearLayout, appCompatTextView, appCompatImageView2);
                        this.grayColor = context.getColor(R.color.quickie_gray);
                        this.accentColor = getAccentColor();
                        int alphaComponent = ColorUtils.setAlphaComponent(-16777216, MathKt.roundToInt(196.35d));
                        this.backgroundColor = alphaComponent;
                        Paint paint = new Paint();
                        paint.setAlpha(MathKt.roundToInt(196.35d));
                        this.alphaPaint = paint;
                        this.strokePaint = new Paint(1);
                        Paint paint2 = new Paint(1);
                        paint2.setColor(alphaComponent);
                        this.loadingBackgroundPaint = paint2;
                        Paint paint3 = new Paint(1);
                        paint3.setColor(0);
                        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
                        this.transparentPaint = paint3;
                        this.outerRadius = TypedValue.applyDimension(1, 16.0f, getResources().getDisplayMetrics());
                        this.innerRadius = TypedValue.applyDimension(1, 12.0f, getResources().getDisplayMetrics());
                        this.outerFrame = new RectF();
                        this.innerFrame = new RectF();
                        this.horizontalFrameRatio = 1.0f;
                        setWillNotDraw(false);
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    private final int getAccentColor() {
        TypedValue typedValue = new TypedValue();
        return getContext().getTheme().resolveAttribute(android.R.attr.colorAccent, typedValue, true) ? typedValue.data : getContext().getColor(R.color.quickie_accent_fallback);
    }

    private final void setTintAndStateAwareBackground(View view) {
        Drawable background = view.getBackground();
        if (background != null) {
            int[][] iArr = {new int[]{android.R.attr.state_pressed, android.R.attr.state_selected}, new int[]{android.R.attr.state_pressed, -16842913}, new int[]{-16842919, android.R.attr.state_selected}, new int[0]};
            int i = this.grayColor;
            int i2 = this.accentColor;
            background.setTintList(new ColorStateList(iArr, new int[]{i, i2, i2, i}).withAlpha(MathKt.roundToInt(153.0d)));
            view.setBackground(background);
        }
    }

    public final void calculateFrameAndTitlePos() {
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        int iMin = Math.min(width, height);
        float f = this.horizontalFrameRatio;
        float f2 = iMin;
        float f3 = f2 - ((f > 1.0f ? 0.25f * ((1.0f / f) * 1.5f) : 0.25f) * f2);
        float fApplyDimension = TypedValue.applyDimension(1, 4.0f, getResources().getDisplayMetrics());
        float f4 = width;
        float f5 = height;
        float f6 = f3 / this.horizontalFrameRatio;
        float f7 = f6 + f5;
        RectF rectF = this.outerFrame;
        rectF.set(f4 - f3, f5 - f6, f4 + f3, f7);
        this.innerFrame.set(rectF.left + fApplyDimension, rectF.top + fApplyDimension, rectF.right - fApplyDimension, rectF.bottom - fApplyDimension);
        int iRoundToInt = MathKt.roundToInt(((-getPaddingTop()) + height) - f3);
        Dispatcher dispatcher = this.binding;
        AppCompatTextView appCompatTextView = (AppCompatTextView) dispatcher.runningAsyncCalls;
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) dispatcher.runningAsyncCalls;
        int height2 = (iRoundToInt - appCompatTextView.getHeight()) / 2;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) appCompatTextView2.getLayoutParams();
        marginLayoutParams.topMargin = height2;
        appCompatTextView2.setLayoutParams(marginLayoutParams);
        appCompatTextView2.setVisibility(iRoundToInt < appCompatTextView2.getHeight() ? 4 : 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int i = this.isHighlighted ? this.accentColor : this.grayColor;
        Paint paint = this.strokePaint;
        paint.setColor(i);
        this.maskCanvas.drawColor(this.backgroundColor);
        Canvas canvas2 = this.maskCanvas;
        RectF rectF = this.outerFrame;
        float f = this.outerRadius;
        canvas2.drawRoundRect(rectF, f, f, paint);
        Canvas canvas3 = this.maskCanvas;
        Paint paint2 = this.transparentPaint;
        RectF rectF2 = this.innerFrame;
        float f2 = this.innerRadius;
        canvas3.drawRoundRect(rectF2, f2, f2, paint2);
        if (this.isLoading) {
            this.maskCanvas.drawRoundRect(rectF2, f2, f2, this.loadingBackgroundPaint);
        }
        canvas.drawBitmap(this.maskBitmap, 0.0f, 0.0f, this.alphaPaint);
        super.onDraw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.maskBitmap != null || getWidth() <= 0 || getHeight() <= 0) {
            return;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        this.maskCanvas = new Canvas(bitmapCreateBitmap);
        this.maskBitmap = bitmapCreateBitmap;
        calculateFrameAndTitlePos();
    }

    public final void setCloseVisibilityAndOnClick(boolean z, BitmapFactoryDecoder$$ExternalSyntheticLambda2 bitmapFactoryDecoder$$ExternalSyntheticLambda2) {
        Dispatcher dispatcher = this.binding;
        AppCompatImageView appCompatImageView = (AppCompatImageView) dispatcher.executorServiceOrNull;
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) dispatcher.executorServiceOrNull;
        appCompatImageView.setVisibility(z ? 0 : 8);
        appCompatImageView2.setOnClickListener(new QROverlayView$$ExternalSyntheticLambda0(bitmapFactoryDecoder$$ExternalSyntheticLambda2, 1));
        if (z) {
            setTintAndStateAwareBackground(appCompatImageView2);
        }
    }

    public final void setCustomIcon(Integer num) {
        Dispatcher dispatcher = this.binding;
        if (num == null) {
            ((AppCompatTextView) dispatcher.runningAsyncCalls).setCompoundDrawables(null, null, null, null);
            return;
        }
        if (num.intValue() != 0) {
            try {
                Resources resources = getResources();
                int iIntValue = num.intValue();
                ThreadLocal threadLocal = ResourcesCompat.sTempTypedValue;
                Drawable drawable = resources.getDrawable(iIntValue, null);
                if (drawable != null) {
                    float fApplyDimension = TypedValue.applyDimension(1, 56.0f, getResources().getDisplayMetrics()) / drawable.getMinimumHeight();
                    if (fApplyDimension < 1.0f) {
                        drawable.setBounds(0, 0, MathKt.roundToInt(drawable.getMinimumWidth() * fApplyDimension), MathKt.roundToInt(drawable.getMinimumHeight() * fApplyDimension));
                    } else {
                        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    }
                    ((AppCompatTextView) dispatcher.runningAsyncCalls).setCompoundDrawables(null, drawable, null, null);
                }
            } catch (Resources.NotFoundException unused) {
            }
        }
    }

    public final void setCustomText(int i) {
        if (i != 0) {
            try {
                ((AppCompatTextView) this.binding.runningAsyncCalls).setText(i);
            } catch (Resources.NotFoundException unused) {
            }
        }
    }

    public final void setHighlighted(boolean z) {
        if (this.isHighlighted != z) {
            this.isHighlighted = z;
            invalidate();
        }
    }

    public final void setHorizontalFrameRatio(float f) {
        if (f > 1.0f) {
            this.horizontalFrameRatio = f;
            calculateFrameAndTitlePos();
        }
    }

    public final void setLoading(boolean z) {
        if (this.isLoading != z) {
            this.isLoading = z;
            ((LinearLayout) this.binding.readyAsyncCalls).setVisibility(z ? 0 : 8);
        }
    }

    public final void setTorchState(boolean z) {
        ((AppCompatImageView) this.binding.runningSyncCalls).setSelected(z);
    }

    public final void setTorchVisibilityAndOnClick(Function1 function1, boolean z) {
        Dispatcher dispatcher = this.binding;
        AppCompatImageView appCompatImageView = (AppCompatImageView) dispatcher.runningSyncCalls;
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) dispatcher.runningSyncCalls;
        appCompatImageView.setVisibility(z ? 0 : 8);
        appCompatImageView2.setOnClickListener(new QROverlayView$$ExternalSyntheticLambda0(function1, 0));
        if (z) {
            setTintAndStateAwareBackground(appCompatImageView2);
        }
    }
}
