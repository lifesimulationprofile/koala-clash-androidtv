package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.impl.utils.futures.ListFuture;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.content.res.CamUtils;
import androidx.core.util.Preconditions;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TintableCompoundDrawablesView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.collections.AbstractList;
import okhttp3.ConnectionSpec;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AppCompatTextHelper {
    public boolean mAsyncFontPending;
    public final AppCompatTextViewAutoSizeHelper mAutoSizeTextHelper;
    public ConnectionSpec.Builder mDrawableBottomTint;
    public ConnectionSpec.Builder mDrawableEndTint;
    public ConnectionSpec.Builder mDrawableLeftTint;
    public ConnectionSpec.Builder mDrawableRightTint;
    public ConnectionSpec.Builder mDrawableStartTint;
    public ConnectionSpec.Builder mDrawableTint;
    public ConnectionSpec.Builder mDrawableTopTint;
    public Typeface mFontTypeface;
    public final TextView mView;
    public int mStyle = 0;
    public int mFontWeight = -1;

    /* JADX INFO: renamed from: androidx.appcompat.widget.AppCompatTextHelper$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass2 implements Runnable {
        public final /* synthetic */ int $r8$classId = 0;
        public final /* synthetic */ int val$style;
        public final /* synthetic */ Object val$textView;
        public final /* synthetic */ Object val$typeface;

        public AnonymousClass2(ListFuture listFuture, int i, ListenableFuture listenableFuture) {
            this.val$typeface = listFuture;
            this.val$style = i;
            this.val$textView = listenableFuture;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ArrayList arrayList;
            CallbackToFutureAdapter.Completer completer;
            ArrayList arrayList2;
            switch (this.$r8$classId) {
                case 0:
                    ((TextView) this.val$textView).setTypeface((Typeface) this.val$typeface, this.val$style);
                    return;
                case 1:
                    ListFuture listFuture = (ListFuture) this.val$typeface;
                    int i = this.val$style;
                    ListenableFuture listenableFuture = (ListenableFuture) this.val$textView;
                    boolean z = listFuture.mAllMustSucceed;
                    AtomicInteger atomicInteger = listFuture.mRemaining;
                    ArrayList arrayList3 = listFuture.mValues;
                    ListenableFuture listenableFuture2 = listFuture.mResult;
                    if (listenableFuture2.isDone() || arrayList3 == null) {
                        Preconditions.checkState("Future was done before all dependencies completed", z);
                        return;
                    }
                    try {
                        Preconditions.checkState("Tried to set value from future which is not done", listenableFuture.isDone());
                        arrayList3.set(i, Futures.getUninterruptibly(listenableFuture));
                        int iDecrementAndGet = atomicInteger.decrementAndGet();
                        Preconditions.checkState("Less than 0 remaining futures", iDecrementAndGet >= 0);
                        if (iDecrementAndGet == 0) {
                            if (arrayList != null) {
                                completer = listFuture.mResultNotifier;
                                arrayList2 = new ArrayList(arrayList);
                                completer.set(arrayList2);
                                return;
                            }
                            return;
                        }
                        return;
                    } catch (CancellationException unused) {
                        if (z) {
                            listFuture.cancel(false);
                        }
                        int iDecrementAndGet2 = atomicInteger.decrementAndGet();
                        Preconditions.checkState("Less than 0 remaining futures", iDecrementAndGet2 >= 0);
                        if (iDecrementAndGet2 == 0) {
                            if (arrayList != null) {
                                completer = listFuture.mResultNotifier;
                                arrayList2 = new ArrayList(arrayList);
                            }
                            return;
                        }
                        return;
                    } catch (ExecutionException e) {
                        if (z) {
                            listFuture.mResultNotifier.setException(e.getCause());
                        }
                        int iDecrementAndGet3 = atomicInteger.decrementAndGet();
                        Preconditions.checkState("Less than 0 remaining futures", iDecrementAndGet3 >= 0);
                        if (iDecrementAndGet3 == 0) {
                            if (arrayList != null) {
                                completer = listFuture.mResultNotifier;
                                arrayList2 = new ArrayList(arrayList);
                            }
                            return;
                        }
                        return;
                    } catch (Error e2) {
                        listFuture.mResultNotifier.setException(e2);
                        int iDecrementAndGet4 = atomicInteger.decrementAndGet();
                        Preconditions.checkState("Less than 0 remaining futures", iDecrementAndGet4 >= 0);
                        if (iDecrementAndGet4 == 0) {
                            if (arrayList != null) {
                                completer = listFuture.mResultNotifier;
                                arrayList2 = new ArrayList(arrayList);
                            }
                            return;
                        }
                        return;
                    } catch (RuntimeException e3) {
                        if (z) {
                            listFuture.mResultNotifier.setException(e3);
                        }
                        int iDecrementAndGet5 = atomicInteger.decrementAndGet();
                        Preconditions.checkState("Less than 0 remaining futures", iDecrementAndGet5 >= 0);
                        if (iDecrementAndGet5 == 0) {
                            if (arrayList != null) {
                                completer = listFuture.mResultNotifier;
                                arrayList2 = new ArrayList(arrayList);
                            }
                            return;
                        }
                        return;
                    } finally {
                        int iDecrementAndGet6 = atomicInteger.decrementAndGet();
                        Preconditions.checkState("Less than 0 remaining futures", iDecrementAndGet6 >= 0);
                        if (iDecrementAndGet6 == 0) {
                            arrayList = listFuture.mValues;
                            if (arrayList != null) {
                                listFuture.mResultNotifier.set(new ArrayList(arrayList));
                            } else {
                                Preconditions.checkState(null, listenableFuture2.isDone());
                            }
                        }
                    }
                default:
                    ((BottomSheetBehavior) this.val$typeface).startSettling((View) this.val$textView, this.val$style, false);
                    return;
            }
        }

        public AnonymousClass2(TextView textView, Typeface typeface, int i) {
            this.val$textView = textView;
            this.val$typeface = typeface;
            this.val$style = i;
        }

        public AnonymousClass2(BottomSheetBehavior bottomSheetBehavior, View view, int i) {
            this.val$typeface = bottomSheetBehavior;
            this.val$textView = view;
            this.val$style = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class Api21Impl {
        public static Locale forLanguageTag(String str) {
            return Locale.forLanguageTag(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class Api24Impl {
        public static LocaleList forLanguageTags(String str) {
            return LocaleList.forLanguageTags(str);
        }

        public static void setTextLocales(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class Api26Impl {
        public static int getAutoSizeStepGranularity(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        public static void setAutoSizeTextTypeUniformWithConfiguration(TextView textView, int i, int i2, int i3, int i4) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        }

        public static void setAutoSizeTextTypeUniformWithPresetSizes(TextView textView, int[] iArr, int i) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        }

        public static boolean setFontVariationSettings(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class Api28Impl {
        public static Typeface create(Typeface typeface, int i, boolean z) {
            return Typeface.create(typeface, i, z);
        }
    }

    public AppCompatTextHelper(TextView textView) {
        this.mView = textView;
        this.mAutoSizeTextHelper = new AppCompatTextViewAutoSizeHelper(textView);
    }

    public static ConnectionSpec.Builder createTintInfo(Context context, AppCompatDrawableManager appCompatDrawableManager, int i) {
        ColorStateList tintList;
        synchronized (appCompatDrawableManager) {
            tintList = appCompatDrawableManager.mResourceManager.getTintList(context, i);
        }
        if (tintList == null) {
            return null;
        }
        ConnectionSpec.Builder builder = new ConnectionSpec.Builder();
        builder.supportsTlsExtensions = true;
        builder.cipherSuites = tintList;
        return builder;
    }

    public final void applyCompoundDrawableTint(Drawable drawable, ConnectionSpec.Builder builder) {
        if (drawable == null || builder == null) {
            return;
        }
        AppCompatDrawableManager.tintDrawable(drawable, builder, this.mView.getDrawableState());
    }

    public final void applyCompoundDrawablesTints() {
        ConnectionSpec.Builder builder = this.mDrawableLeftTint;
        TextView textView = this.mView;
        if (builder != null || this.mDrawableTopTint != null || this.mDrawableRightTint != null || this.mDrawableBottomTint != null) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            applyCompoundDrawableTint(compoundDrawables[0], this.mDrawableLeftTint);
            applyCompoundDrawableTint(compoundDrawables[1], this.mDrawableTopTint);
            applyCompoundDrawableTint(compoundDrawables[2], this.mDrawableRightTint);
            applyCompoundDrawableTint(compoundDrawables[3], this.mDrawableBottomTint);
        }
        if (this.mDrawableStartTint == null && this.mDrawableEndTint == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        applyCompoundDrawableTint(compoundDrawablesRelative[0], this.mDrawableStartTint);
        applyCompoundDrawableTint(compoundDrawablesRelative[2], this.mDrawableEndTint);
    }

    public final ColorStateList getCompoundDrawableTintList() {
        ConnectionSpec.Builder builder = this.mDrawableTint;
        if (builder != null) {
            return (ColorStateList) builder.cipherSuites;
        }
        return null;
    }

    public final PorterDuff.Mode getCompoundDrawableTintMode() {
        ConnectionSpec.Builder builder = this.mDrawableTint;
        if (builder != null) {
            return (PorterDuff.Mode) builder.tlsVersions;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:242:0x03dd  */
    /* JADX WARN: Code duplicated, block: B:244:0x03e2  */
    /* JADX WARN: Code duplicated, block: B:247:0x03e9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:248:0x03eb  */
    /* JADX WARN: Code duplicated, block: B:250:0x03f0  */
    /* JADX WARN: Code duplicated, block: B:252:0x03f6  */
    /* JADX WARN: Code duplicated, block: B:254:0x03fa  */
    /* JADX WARN: Code duplicated, block: B:257:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    public final void loadFromAttributes(AttributeSet attributeSet, int i) {
        boolean z;
        boolean z2;
        String string;
        String string2;
        int i2;
        float dimensionPixelSize;
        int i3;
        ColorStateList colorStateList;
        int resourceId;
        int i4;
        int resourceId2;
        TextView textView = this.mView;
        Context context = textView.getContext();
        AppCompatDrawableManager appCompatDrawableManager = AppCompatDrawableManager.get();
        int[] iArr = R$styleable.AppCompatTextHelper;
        MenuHostHelper menuHostHelperObtainStyledAttributes = MenuHostHelper.obtainStyledAttributes(context, attributeSet, iArr, i);
        ViewCompat.saveAttributeDataForStyleable(textView, textView.getContext(), iArr, attributeSet, (TypedArray) menuHostHelperObtainStyledAttributes.mMenuProviders, i, 0);
        TypedArray typedArray = (TypedArray) menuHostHelperObtainStyledAttributes.mMenuProviders;
        int resourceId3 = typedArray.getResourceId(0, -1);
        if (typedArray.hasValue(3)) {
            this.mDrawableLeftTint = createTintInfo(context, appCompatDrawableManager, typedArray.getResourceId(3, 0));
        }
        if (typedArray.hasValue(1)) {
            this.mDrawableTopTint = createTintInfo(context, appCompatDrawableManager, typedArray.getResourceId(1, 0));
        }
        if (typedArray.hasValue(4)) {
            this.mDrawableRightTint = createTintInfo(context, appCompatDrawableManager, typedArray.getResourceId(4, 0));
        }
        if (typedArray.hasValue(2)) {
            this.mDrawableBottomTint = createTintInfo(context, appCompatDrawableManager, typedArray.getResourceId(2, 0));
        }
        if (typedArray.hasValue(5)) {
            this.mDrawableStartTint = createTintInfo(context, appCompatDrawableManager, typedArray.getResourceId(5, 0));
        }
        if (typedArray.hasValue(6)) {
            this.mDrawableEndTint = createTintInfo(context, appCompatDrawableManager, typedArray.getResourceId(6, 0));
        }
        menuHostHelperObtainStyledAttributes.recycle();
        boolean z3 = textView.getTransformationMethod() instanceof PasswordTransformationMethod;
        int[] iArr2 = R$styleable.TextAppearance;
        if (resourceId3 != -1) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(resourceId3, iArr2);
            MenuHostHelper menuHostHelper = new MenuHostHelper(context, typedArrayObtainStyledAttributes);
            if (z3 || !typedArrayObtainStyledAttributes.hasValue(14)) {
                z = false;
                z2 = false;
            } else {
                z2 = typedArrayObtainStyledAttributes.getBoolean(14, false);
                z = true;
            }
            updateTypefaceAndStyle(context, menuHostHelper);
            int i5 = Build.VERSION.SDK_INT;
            string2 = typedArrayObtainStyledAttributes.hasValue(15) ? typedArrayObtainStyledAttributes.getString(15) : null;
            string = (i5 < 26 || !typedArrayObtainStyledAttributes.hasValue(13)) ? null : typedArrayObtainStyledAttributes.getString(13);
            menuHostHelper.recycle();
        } else {
            z = false;
            z2 = false;
            string = null;
            string2 = null;
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i, 0);
        MenuHostHelper menuHostHelper2 = new MenuHostHelper(context, typedArrayObtainStyledAttributes2);
        if (!z3 && typedArrayObtainStyledAttributes2.hasValue(14)) {
            z2 = typedArrayObtainStyledAttributes2.getBoolean(14, false);
            z = true;
        }
        boolean z4 = z2;
        int i6 = Build.VERSION.SDK_INT;
        if (typedArrayObtainStyledAttributes2.hasValue(15)) {
            string2 = typedArrayObtainStyledAttributes2.getString(15);
        }
        String str = string2;
        if (i6 >= 26 && typedArrayObtainStyledAttributes2.hasValue(13)) {
            string = typedArrayObtainStyledAttributes2.getString(13);
        }
        if (i6 >= 28 && typedArrayObtainStyledAttributes2.hasValue(0) && typedArrayObtainStyledAttributes2.getDimensionPixelSize(0, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        updateTypefaceAndStyle(context, menuHostHelper2);
        menuHostHelper2.recycle();
        if (!z3 && z) {
            textView.setAllCaps(z4);
        }
        Typeface typeface = this.mFontTypeface;
        if (typeface != null) {
            if (this.mFontWeight == -1) {
                textView.setTypeface(typeface, this.mStyle);
            } else {
                textView.setTypeface(typeface);
            }
        }
        if (string != null) {
            Api26Impl.setFontVariationSettings(textView, string);
        }
        if (str != null) {
            if (i6 >= 24) {
                Api24Impl.setTextLocales(textView, Api24Impl.forLanguageTags(str));
            } else {
                textView.setTextLocale(Api21Impl.forLanguageTag(str.split(",")[0]));
            }
        }
        AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = this.mAutoSizeTextHelper;
        Context context2 = appCompatTextViewAutoSizeHelper.mContext;
        int[] iArr3 = R$styleable.AppCompatTextView;
        TypedArray typedArrayObtainStyledAttributes3 = context2.obtainStyledAttributes(attributeSet, iArr3, i, 0);
        TextView textView2 = appCompatTextViewAutoSizeHelper.mTextView;
        ViewCompat.saveAttributeDataForStyleable(textView2, textView2.getContext(), iArr3, attributeSet, typedArrayObtainStyledAttributes3, i, 0);
        if (typedArrayObtainStyledAttributes3.hasValue(5)) {
            appCompatTextViewAutoSizeHelper.mAutoSizeTextType = typedArrayObtainStyledAttributes3.getInt(5, 0);
        }
        float dimension = typedArrayObtainStyledAttributes3.hasValue(4) ? typedArrayObtainStyledAttributes3.getDimension(4, -1.0f) : -1.0f;
        float dimension2 = typedArrayObtainStyledAttributes3.hasValue(2) ? typedArrayObtainStyledAttributes3.getDimension(2, -1.0f) : -1.0f;
        float dimension3 = typedArrayObtainStyledAttributes3.hasValue(1) ? typedArrayObtainStyledAttributes3.getDimension(1, -1.0f) : -1.0f;
        if (typedArrayObtainStyledAttributes3.hasValue(3) && (resourceId2 = typedArrayObtainStyledAttributes3.getResourceId(3, 0)) > 0) {
            TypedArray typedArrayObtainTypedArray = typedArrayObtainStyledAttributes3.getResources().obtainTypedArray(resourceId2);
            int length = typedArrayObtainTypedArray.length();
            int[] iArr4 = new int[length];
            if (length > 0) {
                for (int i7 = 0; i7 < length; i7++) {
                    iArr4[i7] = typedArrayObtainTypedArray.getDimensionPixelSize(i7, -1);
                }
                appCompatTextViewAutoSizeHelper.mAutoSizeTextSizesInPx = AppCompatTextViewAutoSizeHelper.cleanupAutoSizePresetSizes(iArr4);
                appCompatTextViewAutoSizeHelper.setupAutoSizeUniformPresetSizesConfiguration();
            }
            typedArrayObtainTypedArray.recycle();
        }
        typedArrayObtainStyledAttributes3.recycle();
        if (!appCompatTextViewAutoSizeHelper.supportsAutoSizeText()) {
            appCompatTextViewAutoSizeHelper.mAutoSizeTextType = 0;
        } else if (appCompatTextViewAutoSizeHelper.mAutoSizeTextType == 1) {
            if (!appCompatTextViewAutoSizeHelper.mHasPresetAutoSizeValues) {
                DisplayMetrics displayMetrics = context2.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    i4 = 2;
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                } else {
                    i4 = 2;
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(i4, 112.0f, displayMetrics);
                }
                float f = dimension3;
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                appCompatTextViewAutoSizeHelper.validateAndSetAutoSizeTextTypeUniformConfiguration(dimension2, f, dimension);
            }
            appCompatTextViewAutoSizeHelper.setupAutoSizeText();
        }
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE && appCompatTextViewAutoSizeHelper.mAutoSizeTextType != 0) {
            int[] iArr5 = appCompatTextViewAutoSizeHelper.mAutoSizeTextSizesInPx;
            if (iArr5.length > 0) {
                if (Api26Impl.getAutoSizeStepGranularity(textView) != -1.0f) {
                    Api26Impl.setAutoSizeTextTypeUniformWithConfiguration(textView, Math.round(appCompatTextViewAutoSizeHelper.mAutoSizeMinTextSizeInPx), Math.round(appCompatTextViewAutoSizeHelper.mAutoSizeMaxTextSizeInPx), Math.round(appCompatTextViewAutoSizeHelper.mAutoSizeStepGranularityInPx), 0);
                } else {
                    Api26Impl.setAutoSizeTextTypeUniformWithPresetSizes(textView, iArr5, 0);
                }
            }
        }
        TypedArray typedArrayObtainStyledAttributes4 = context.obtainStyledAttributes(attributeSet, iArr3);
        int resourceId4 = typedArrayObtainStyledAttributes4.getResourceId(8, -1);
        Drawable drawable = resourceId4 != -1 ? appCompatDrawableManager.getDrawable(context, resourceId4) : null;
        int resourceId5 = typedArrayObtainStyledAttributes4.getResourceId(13, -1);
        Drawable drawable2 = resourceId5 != -1 ? appCompatDrawableManager.getDrawable(context, resourceId5) : null;
        int resourceId6 = typedArrayObtainStyledAttributes4.getResourceId(9, -1);
        Drawable drawable3 = resourceId6 != -1 ? appCompatDrawableManager.getDrawable(context, resourceId6) : null;
        int resourceId7 = typedArrayObtainStyledAttributes4.getResourceId(6, -1);
        Drawable drawable4 = resourceId7 != -1 ? appCompatDrawableManager.getDrawable(context, resourceId7) : null;
        int resourceId8 = typedArrayObtainStyledAttributes4.getResourceId(10, -1);
        Drawable drawable5 = resourceId8 != -1 ? appCompatDrawableManager.getDrawable(context, resourceId8) : null;
        int resourceId9 = typedArrayObtainStyledAttributes4.getResourceId(7, -1);
        Drawable drawable6 = resourceId9 != -1 ? appCompatDrawableManager.getDrawable(context, resourceId9) : null;
        if (drawable5 != null || drawable6 != null) {
            Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
        } else if (drawable != null || drawable2 != null || drawable3 != null || drawable4 != null) {
            Drawable[] compoundDrawablesRelative2 = textView.getCompoundDrawablesRelative();
            Drawable drawable7 = compoundDrawablesRelative2[0];
            if (drawable7 == null && compoundDrawablesRelative2[2] == null) {
                Drawable[] compoundDrawables = textView.getCompoundDrawables();
                if (drawable == null) {
                    drawable = compoundDrawables[0];
                }
                if (drawable2 == null) {
                    drawable2 = compoundDrawables[1];
                }
                if (drawable3 == null) {
                    drawable3 = compoundDrawables[2];
                }
                if (drawable4 == null) {
                    drawable4 = compoundDrawables[3];
                }
                textView.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            } else {
                if (drawable2 == null) {
                    drawable2 = compoundDrawablesRelative2[1];
                }
                if (drawable4 == null) {
                    drawable4 = compoundDrawablesRelative2[3];
                }
                textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, compoundDrawablesRelative2[2], drawable4);
            }
        }
        if (typedArrayObtainStyledAttributes4.hasValue(11)) {
            if (!typedArrayObtainStyledAttributes4.hasValue(11) || (resourceId = typedArrayObtainStyledAttributes4.getResourceId(11, 0)) == 0 || (colorStateList = AbstractList.Companion.getColorStateList(context, resourceId)) == null) {
                colorStateList = typedArrayObtainStyledAttributes4.getColorStateList(11);
            }
            if (Build.VERSION.SDK_INT >= 24) {
                textView.setCompoundDrawableTintList(colorStateList);
            } else if (textView instanceof TintableCompoundDrawablesView) {
                ((TintableCompoundDrawablesView) textView).setSupportCompoundDrawablesTintList(colorStateList);
            }
        }
        if (typedArrayObtainStyledAttributes4.hasValue(12)) {
            PorterDuff.Mode tintMode = DrawableUtils.parseTintMode(typedArrayObtainStyledAttributes4.getInt(12, -1), null);
            if (Build.VERSION.SDK_INT >= 24) {
                textView.setCompoundDrawableTintMode(tintMode);
            } else if (textView instanceof TintableCompoundDrawablesView) {
                ((TintableCompoundDrawablesView) textView).setSupportCompoundDrawablesTintMode(tintMode);
            }
        }
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes4.getDimensionPixelSize(15, -1);
        int dimensionPixelSize3 = typedArrayObtainStyledAttributes4.getDimensionPixelSize(18, -1);
        if (typedArrayObtainStyledAttributes4.hasValue(19)) {
            TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes4.peekValue(19);
            if (typedValuePeekValue == null || typedValuePeekValue.type != 5) {
                i2 = -1;
                dimensionPixelSize = typedArrayObtainStyledAttributes4.getDimensionPixelSize(19, -1);
            } else {
                int i8 = typedValuePeekValue.data;
                int i9 = i8 & 15;
                dimensionPixelSize = TypedValue.complexToFloat(i8);
                i3 = i9;
                i2 = -1;
            }
            typedArrayObtainStyledAttributes4.recycle();
            if (dimensionPixelSize2 != i2) {
                TextViewCompat.setFirstBaselineToTopHeight(textView, dimensionPixelSize2);
            }
            if (dimensionPixelSize3 != i2) {
                TextViewCompat.setLastBaselineToBottomHeight(textView, dimensionPixelSize3);
            }
            if (dimensionPixelSize != -1.0f) {
                if (i3 == i2) {
                    TextViewCompat.setLineHeight(textView, (int) dimensionPixelSize);
                } else if (Build.VERSION.SDK_INT >= 34) {
                    TextViewCompat.Api34Impl.setLineHeight(textView, i3, dimensionPixelSize);
                } else {
                    TextViewCompat.setLineHeight(textView, Math.round(TypedValue.applyDimension(i3, dimensionPixelSize, textView.getResources().getDisplayMetrics())));
                }
            }
        }
        i2 = -1;
        dimensionPixelSize = -1.0f;
        i3 = i2;
        typedArrayObtainStyledAttributes4.recycle();
        if (dimensionPixelSize2 != i2) {
            TextViewCompat.setFirstBaselineToTopHeight(textView, dimensionPixelSize2);
        }
        if (dimensionPixelSize3 != i2) {
            TextViewCompat.setLastBaselineToBottomHeight(textView, dimensionPixelSize3);
        }
        if (dimensionPixelSize != -1.0f) {
            if (i3 == i2) {
                TextViewCompat.setLineHeight(textView, (int) dimensionPixelSize);
            } else if (Build.VERSION.SDK_INT >= 34) {
                TextViewCompat.Api34Impl.setLineHeight(textView, i3, dimensionPixelSize);
            } else {
                TextViewCompat.setLineHeight(textView, Math.round(TypedValue.applyDimension(i3, dimensionPixelSize, textView.getResources().getDisplayMetrics())));
            }
        }
    }

    public final void onSetTextAppearance(Context context, int i) {
        String string;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, R$styleable.TextAppearance);
        MenuHostHelper menuHostHelper = new MenuHostHelper(context, typedArrayObtainStyledAttributes);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(14);
        TextView textView = this.mView;
        if (zHasValue) {
            textView.setAllCaps(typedArrayObtainStyledAttributes.getBoolean(14, false));
        }
        int i2 = Build.VERSION.SDK_INT;
        if (typedArrayObtainStyledAttributes.hasValue(0) && typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        updateTypefaceAndStyle(context, menuHostHelper);
        if (i2 >= 26 && typedArrayObtainStyledAttributes.hasValue(13) && (string = typedArrayObtainStyledAttributes.getString(13)) != null) {
            Api26Impl.setFontVariationSettings(textView, string);
        }
        menuHostHelper.recycle();
        Typeface typeface = this.mFontTypeface;
        if (typeface != null) {
            textView.setTypeface(typeface, this.mStyle);
        }
    }

    public final void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = this.mAutoSizeTextHelper;
        if (appCompatTextViewAutoSizeHelper.supportsAutoSizeText()) {
            DisplayMetrics displayMetrics = appCompatTextViewAutoSizeHelper.mContext.getResources().getDisplayMetrics();
            appCompatTextViewAutoSizeHelper.validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(i4, i, displayMetrics), TypedValue.applyDimension(i4, i2, displayMetrics), TypedValue.applyDimension(i4, i3, displayMetrics));
            if (appCompatTextViewAutoSizeHelper.setupAutoSizeText()) {
                appCompatTextViewAutoSizeHelper.autoSizeText();
            }
        }
    }

    public final void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = this.mAutoSizeTextHelper;
        if (appCompatTextViewAutoSizeHelper.supportsAutoSizeText()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = appCompatTextViewAutoSizeHelper.mContext.getResources().getDisplayMetrics();
                    for (int i2 = 0; i2 < length; i2++) {
                        iArrCopyOf[i2] = Math.round(TypedValue.applyDimension(i, iArr[i2], displayMetrics));
                    }
                }
                appCompatTextViewAutoSizeHelper.mAutoSizeTextSizesInPx = AppCompatTextViewAutoSizeHelper.cleanupAutoSizePresetSizes(iArrCopyOf);
                if (!appCompatTextViewAutoSizeHelper.setupAutoSizeUniformPresetSizesConfiguration()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                appCompatTextViewAutoSizeHelper.mHasPresetAutoSizeValues = false;
            }
            if (appCompatTextViewAutoSizeHelper.setupAutoSizeText()) {
                appCompatTextViewAutoSizeHelper.autoSizeText();
            }
        }
    }

    public final void setAutoSizeTextTypeWithDefaults(int i) {
        AppCompatTextViewAutoSizeHelper appCompatTextViewAutoSizeHelper = this.mAutoSizeTextHelper;
        if (appCompatTextViewAutoSizeHelper.supportsAutoSizeText()) {
            if (i == 0) {
                appCompatTextViewAutoSizeHelper.mAutoSizeTextType = 0;
                appCompatTextViewAutoSizeHelper.mAutoSizeMinTextSizeInPx = -1.0f;
                appCompatTextViewAutoSizeHelper.mAutoSizeMaxTextSizeInPx = -1.0f;
                appCompatTextViewAutoSizeHelper.mAutoSizeStepGranularityInPx = -1.0f;
                appCompatTextViewAutoSizeHelper.mAutoSizeTextSizesInPx = new int[0];
                appCompatTextViewAutoSizeHelper.mNeedsAutoSizeText = false;
                return;
            }
            if (i != 1) {
                throw new IllegalArgumentException(ImageAnalysis$$ExternalSyntheticLambda1.m("Unknown auto-size text type: ", i));
            }
            DisplayMetrics displayMetrics = appCompatTextViewAutoSizeHelper.mContext.getResources().getDisplayMetrics();
            appCompatTextViewAutoSizeHelper.validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (appCompatTextViewAutoSizeHelper.setupAutoSizeText()) {
                appCompatTextViewAutoSizeHelper.autoSizeText();
            }
        }
    }

    public final void setCompoundDrawableTintList(ColorStateList colorStateList) {
        if (this.mDrawableTint == null) {
            this.mDrawableTint = new ConnectionSpec.Builder();
        }
        ConnectionSpec.Builder builder = this.mDrawableTint;
        builder.cipherSuites = colorStateList;
        builder.supportsTlsExtensions = colorStateList != null;
        this.mDrawableLeftTint = builder;
        this.mDrawableTopTint = builder;
        this.mDrawableRightTint = builder;
        this.mDrawableBottomTint = builder;
        this.mDrawableStartTint = builder;
        this.mDrawableEndTint = builder;
    }

    public final void setCompoundDrawableTintMode(PorterDuff.Mode mode) {
        if (this.mDrawableTint == null) {
            this.mDrawableTint = new ConnectionSpec.Builder();
        }
        ConnectionSpec.Builder builder = this.mDrawableTint;
        builder.tlsVersions = mode;
        builder.tls = mode != null;
        this.mDrawableLeftTint = builder;
        this.mDrawableTopTint = builder;
        this.mDrawableRightTint = builder;
        this.mDrawableBottomTint = builder;
        this.mDrawableStartTint = builder;
        this.mDrawableEndTint = builder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [androidx.appcompat.widget.AppCompatTextHelper$1] */
    public final void updateTypefaceAndStyle(Context context, MenuHostHelper menuHostHelper) {
        String string;
        int i = this.mStyle;
        TypedArray typedArray = (TypedArray) menuHostHelper.mMenuProviders;
        this.mStyle = typedArray.getInt(2, i);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            int i3 = typedArray.getInt(11, -1);
            this.mFontWeight = i3;
            if (i3 != -1) {
                this.mStyle &= 2;
            }
        }
        if (!typedArray.hasValue(10) && !typedArray.hasValue(12)) {
            if (typedArray.hasValue(1)) {
                this.mAsyncFontPending = false;
                int i4 = typedArray.getInt(1, 1);
                if (i4 == 1) {
                    this.mFontTypeface = Typeface.SANS_SERIF;
                    return;
                } else if (i4 == 2) {
                    this.mFontTypeface = Typeface.SERIF;
                    return;
                } else {
                    if (i4 != 3) {
                        return;
                    }
                    this.mFontTypeface = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.mFontTypeface = null;
        int i5 = typedArray.hasValue(12) ? 12 : 10;
        final int i6 = this.mFontWeight;
        final int i7 = this.mStyle;
        if (!context.isRestricted()) {
            final WeakReference weakReference = new WeakReference(this.mView);
            try {
                Typeface font = menuHostHelper.getFont(i5, this.mStyle, new CamUtils() { // from class: androidx.appcompat.widget.AppCompatTextHelper.1
                    @Override // androidx.core.content.res.CamUtils
                    public final void onFontRetrieved(Typeface typeface) {
                        int i8;
                        if (Build.VERSION.SDK_INT >= 28 && (i8 = i6) != -1) {
                            typeface = Api28Impl.create(typeface, i8, (i7 & 2) != 0);
                        }
                        AppCompatTextHelper appCompatTextHelper = AppCompatTextHelper.this;
                        if (appCompatTextHelper.mAsyncFontPending) {
                            appCompatTextHelper.mFontTypeface = typeface;
                            TextView textView = (TextView) weakReference.get();
                            if (textView != null) {
                                if (textView.isAttachedToWindow()) {
                                    textView.post(new AnonymousClass2(textView, typeface, appCompatTextHelper.mStyle));
                                } else {
                                    textView.setTypeface(typeface, appCompatTextHelper.mStyle);
                                }
                            }
                        }
                    }

                    @Override // androidx.core.content.res.CamUtils
                    public final void onFontRetrievalFailed(int i8) {
                    }
                });
                if (font != null) {
                    if (i2 < 28 || this.mFontWeight == -1) {
                        this.mFontTypeface = font;
                    } else {
                        this.mFontTypeface = Api28Impl.create(Typeface.create(font, 0), this.mFontWeight, (this.mStyle & 2) != 0);
                    }
                }
                this.mAsyncFontPending = this.mFontTypeface == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.mFontTypeface != null || (string = typedArray.getString(i5)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.mFontWeight == -1) {
            this.mFontTypeface = Typeface.create(string, this.mStyle);
        } else {
            this.mFontTypeface = Api28Impl.create(Typeface.create(string, 0), this.mFontWeight, (this.mStyle & 2) != 0);
        }
    }
}
