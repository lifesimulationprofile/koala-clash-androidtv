package com.google.android.gms.tasks;

import android.content.SharedPreferences;
import android.media.Image;
import android.media.ImageReader;
import android.text.TextUtils;
import android.view.Surface;
import androidx.activity.compose.BackHandlerKt;
import androidx.appcompat.widget.Toolbar;
import androidx.camera.camera2.internal.compat.params.DynamicRangesCompat$DynamicRangeProfilesCompatImpl;
import androidx.camera.core.AndroidImageProxy;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.selection.MouseSelectionObserver;
import androidx.compose.foundation.text.selection.SelectionAdjustment$Companion;
import androidx.compose.foundation.text.selection.SelectionAdjustment$Companion$$ExternalSyntheticLambda0;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.core.util.Preconditions;
import coil.memory.MemoryCacheService;
import coil.request.Parameters;
import com.google.android.gms.tasks.zzr;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzr implements ImageReaderProxy, MouseSelectionObserver {
    public Object zza;
    public Object zzb;
    public boolean zzc;

    public zzr(ImageReader imageReader) {
        this.zza = new Object();
        this.zzc = true;
        this.zzb = imageReader;
    }

    public static boolean canResolve(DynamicRange dynamicRange, DynamicRange dynamicRange2) {
        boolean zIsFullySpecified = dynamicRange2.isFullySpecified();
        int i = dynamicRange2.mEncoding;
        Preconditions.checkState("Fully specified range is not actually fully specified.", zIsFullySpecified);
        int i2 = dynamicRange.mEncoding;
        if (i2 == 2 && i == 1) {
            return false;
        }
        if (i2 != 2 && i2 != 0 && i2 != i) {
            return false;
        }
        int i3 = dynamicRange.mBitDepth;
        return i3 == 0 || i3 == dynamicRange2.mBitDepth;
    }

    public static boolean canResolveWithinConstraints(DynamicRange dynamicRange, DynamicRange dynamicRange2, HashSet hashSet) {
        if (hashSet.contains(dynamicRange2)) {
            return canResolve(dynamicRange, dynamicRange2);
        }
        Logger.d("DynamicRangeResolver", "Candidate Dynamic range is not within constraints.\nDynamic range to resolve:\n  " + dynamicRange + "\nCandidate dynamic range:\n  " + dynamicRange2);
        return false;
    }

    public static DynamicRange findSupportedHdrMatch(DynamicRange dynamicRange, LinkedHashSet linkedHashSet, HashSet hashSet) {
        if (dynamicRange.mEncoding == 1) {
            return null;
        }
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            DynamicRange dynamicRange2 = (DynamicRange) it.next();
            Preconditions.checkNotNull(dynamicRange2, "Fully specified DynamicRange cannot be null.");
            int i = dynamicRange2.mEncoding;
            Preconditions.checkState("Fully specified DynamicRange must have fully defined encoding.", dynamicRange2.isFullySpecified());
            if (i != 1 && canResolveWithinConstraints(dynamicRange, dynamicRange2, hashSet)) {
                return dynamicRange2;
            }
        }
        return null;
    }

    public static void updateConstraints(HashSet hashSet, DynamicRange dynamicRange, Toolbar.AnonymousClass1 anonymousClass1) {
        Preconditions.checkState("Cannot update already-empty constraints.", !hashSet.isEmpty());
        Set dynamicRangeCaptureRequestConstraints = ((DynamicRangesCompat$DynamicRangeProfilesCompatImpl) anonymousClass1.this$0).getDynamicRangeCaptureRequestConstraints(dynamicRange);
        if (dynamicRangeCaptureRequestConstraints.isEmpty()) {
            return;
        }
        HashSet hashSet2 = new HashSet(hashSet);
        hashSet.retainAll(dynamicRangeCaptureRequestConstraints);
        if (hashSet.isEmpty()) {
            throw new IllegalArgumentException("Constraints of dynamic range cannot be combined with existing constraints.\nDynamic range:\n  " + dynamicRange + "\nConstraints:\n  " + TextUtils.join("\n  ", dynamicRangeCaptureRequestConstraints) + "\nExisting constraints:\n  " + TextUtils.join("\n  ", hashSet2));
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public ImageProxy acquireLatestImage() {
        Image imageAcquireLatestImage;
        synchronized (this.zza) {
            try {
                imageAcquireLatestImage = ((ImageReader) this.zzb).acquireLatestImage();
            } catch (RuntimeException e) {
                if (!"ImageReaderContext is not initialized".equals(e.getMessage())) {
                    throw e;
                }
                imageAcquireLatestImage = null;
            }
            if (imageAcquireLatestImage == null) {
                return null;
            }
            return new AndroidImageProxy(imageAcquireLatestImage);
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public ImageProxy acquireNextImage() {
        Image imageAcquireNextImage;
        synchronized (this.zza) {
            try {
                imageAcquireNextImage = ((ImageReader) this.zzb).acquireNextImage();
            } catch (RuntimeException e) {
                if (!"ImageReaderContext is not initialized".equals(e.getMessage())) {
                    throw e;
                }
                imageAcquireNextImage = null;
            }
            if (imageAcquireNextImage == null) {
                return null;
            }
            return new AndroidImageProxy(imageAcquireNextImage);
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void clearOnImageAvailableListener() {
        synchronized (this.zza) {
            this.zzc = true;
            ((ImageReader) this.zzb).setOnImageAvailableListener(null, null);
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void close() {
        synchronized (this.zza) {
            ((ImageReader) this.zzb).close();
        }
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getHeight() {
        int height;
        synchronized (this.zza) {
            height = ((ImageReader) this.zzb).getHeight();
        }
        return height;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getImageFormat() {
        int imageFormat;
        synchronized (this.zza) {
            imageFormat = ((ImageReader) this.zzb).getImageFormat();
        }
        return imageFormat;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getMaxImages() {
        int maxImages;
        synchronized (this.zza) {
            maxImages = ((ImageReader) this.zzb).getMaxImages();
        }
        return maxImages;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public Surface getSurface() {
        Surface surface;
        synchronized (this.zza) {
            surface = ((ImageReader) this.zzb).getSurface();
        }
        return surface;
    }

    public Object getValue() {
        MemoryCacheService memoryCacheService = (MemoryCacheService) ((Parameters.Builder) this.zza).entries;
        return Boolean.valueOf(((SharedPreferences) memoryCacheService.imageLoader).getBoolean((String) this.zzb, this.zzc));
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public int getWidth() {
        int width;
        synchronized (this.zza) {
            width = ((ImageReader) this.zzb).getWidth();
        }
        return width;
    }

    @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
    /* JADX INFO: renamed from: onDrag-3MmeM6k */
    public boolean mo207onDrag3MmeM6k(long j, SelectionAdjustment$Companion$$ExternalSyntheticLambda0 selectionAdjustment$Companion$$ExternalSyntheticLambda0) {
        LegacyTextFieldState legacyTextFieldState;
        TextFieldSelectionManager textFieldSelectionManager = (TextFieldSelectionManager) this.zzb;
        if (!textFieldSelectionManager.getEnabled() || textFieldSelectionManager.getValue$foundation().annotatedString.text.length() == 0 || (legacyTextFieldState = textFieldSelectionManager.state) == null || legacyTextFieldState.getLayoutResult() == null) {
            return false;
        }
        updateMouseSelection(textFieldSelectionManager.getValue$foundation(), j, false, selectionAdjustment$Companion$$ExternalSyntheticLambda0);
        return true;
    }

    @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
    public void onDragDone() {
        if (this.zzc) {
            TextFieldSelectionManager.m227access$maybeSuggestSelectionOEnZFl4((TextFieldSelectionManager) this.zzb, (TextRange) this.zza);
        }
    }

    @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
    /* JADX INFO: renamed from: onExtend-k-4lQ0M */
    public boolean mo208onExtendk4lQ0M(long j) {
        TextFieldSelectionManager textFieldSelectionManager = (TextFieldSelectionManager) this.zzb;
        LegacyTextFieldState legacyTextFieldState = textFieldSelectionManager.state;
        if (legacyTextFieldState == null || legacyTextFieldState.getLayoutResult() == null || !textFieldSelectionManager.getEnabled()) {
            return false;
        }
        textFieldSelectionManager.previousRawDragOffset = -1;
        FocusRequester focusRequester = textFieldSelectionManager.focusRequester;
        if (focusRequester != null) {
            FocusRequester.m349requestFocus3ESFkO8$default(focusRequester);
        }
        updateMouseSelection(textFieldSelectionManager.getValue$foundation(), j, false, SelectionAdjustment$Companion.None);
        return true;
    }

    @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
    /* JADX INFO: renamed from: onExtendDrag-k-4lQ0M */
    public boolean mo209onExtendDragk4lQ0M(long j) {
        LegacyTextFieldState legacyTextFieldState;
        TextFieldSelectionManager textFieldSelectionManager = (TextFieldSelectionManager) this.zzb;
        if (!textFieldSelectionManager.getEnabled() || textFieldSelectionManager.getValue$foundation().annotatedString.text.length() == 0 || (legacyTextFieldState = textFieldSelectionManager.state) == null || legacyTextFieldState.getLayoutResult() == null) {
            return false;
        }
        updateMouseSelection(textFieldSelectionManager.getValue$foundation(), j, false, SelectionAdjustment$Companion.None);
        return true;
    }

    @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
    /* JADX INFO: renamed from: onStart-9KIMszo */
    public boolean mo210onStart9KIMszo(long j, SelectionAdjustment$Companion$$ExternalSyntheticLambda0 selectionAdjustment$Companion$$ExternalSyntheticLambda0, int i) {
        LegacyTextFieldState legacyTextFieldState;
        TextFieldSelectionManager textFieldSelectionManager = (TextFieldSelectionManager) this.zzb;
        if (!textFieldSelectionManager.getEnabled() || textFieldSelectionManager.getValue$foundation().annotatedString.text.length() == 0 || (legacyTextFieldState = textFieldSelectionManager.state) == null || legacyTextFieldState.getLayoutResult() == null) {
            return false;
        }
        FocusRequester focusRequester = textFieldSelectionManager.focusRequester;
        if (focusRequester != null) {
            FocusRequester.m349requestFocus3ESFkO8$default(focusRequester);
        }
        textFieldSelectionManager.dragBeginPosition = j;
        textFieldSelectionManager.previousRawDragOffset = -1;
        textFieldSelectionManager.enterSelectionMode$foundation(true);
        long jUpdateMouseSelection = updateMouseSelection(textFieldSelectionManager.getValue$foundation(), textFieldSelectionManager.dragBeginPosition, true, selectionAdjustment$Companion$$ExternalSyntheticLambda0);
        if (i >= 2) {
            this.zzc = true;
            this.zza = new TextRange(jUpdateMouseSelection);
        }
        return true;
    }

    @Override // androidx.camera.core.impl.ImageReaderProxy
    public void setOnImageAvailableListener(final ImageReaderProxy.OnImageAvailableListener onImageAvailableListener, final Executor executor) {
        synchronized (this.zza) {
            this.zzc = false;
            ((ImageReader) this.zzb).setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: androidx.camera.core.AndroidImageReaderProxy$$ExternalSyntheticLambda0
                @Override // android.media.ImageReader.OnImageAvailableListener
                public final void onImageAvailable(ImageReader imageReader) {
                    zzr zzrVar = this.f$0;
                    Executor executor2 = executor;
                    ImageReaderProxy.OnImageAvailableListener onImageAvailableListener2 = onImageAvailableListener;
                    synchronized (zzrVar.zza) {
                        try {
                            if (!zzrVar.zzc) {
                                executor2.execute(new Preview$$ExternalSyntheticLambda1(10, zzrVar, onImageAvailableListener2));
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            }, BackHandlerKt.getInstance());
        }
    }

    public void setValue(Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        MemoryCacheService memoryCacheService = (MemoryCacheService) ((Parameters.Builder) this.zza).entries;
        String str = (String) this.zzb;
        SharedPreferences.Editor editorEdit = ((SharedPreferences) memoryCacheService.imageLoader).edit();
        editorEdit.putBoolean(str, zBooleanValue);
        editorEdit.apply();
    }

    public long updateMouseSelection(TextFieldValue textFieldValue, long j, boolean z, SelectionAdjustment$Companion$$ExternalSyntheticLambda0 selectionAdjustment$Companion$$ExternalSyntheticLambda0) {
        TextFieldSelectionManager textFieldSelectionManager = (TextFieldSelectionManager) this.zzb;
        long jM228access$updateSelectionjSglsI8 = TextFieldSelectionManager.m228access$updateSelectionjSglsI8(textFieldSelectionManager, textFieldValue, j, z, false, selectionAdjustment$Companion$$ExternalSyntheticLambda0, false, null);
        if (!TextRange.m639equalsimpl(jM228access$updateSelectionjSglsI8, (TextRange) this.zza)) {
            this.zzc = false;
        }
        textFieldSelectionManager.setHandleState(TextRange.m641getCollapsedimpl(jM228access$updateSelectionjSglsI8) ? HandleState.Cursor : HandleState.Selection);
        return jM228access$updateSelectionjSglsI8;
    }

    public void zza(zzq zzqVar) {
        synchronized (this.zza) {
            try {
                if (((ArrayDeque) this.zzb) == null) {
                    this.zzb = new ArrayDeque();
                }
                ((ArrayDeque) this.zzb).add(zzqVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void zzb(zzw zzwVar) {
        zzq zzqVar;
        synchronized (this.zza) {
            if (((ArrayDeque) this.zzb) != null && !this.zzc) {
                this.zzc = true;
                while (true) {
                    synchronized (this.zza) {
                        try {
                            zzqVar = (zzq) ((ArrayDeque) this.zzb).poll();
                            if (zzqVar == null) {
                                this.zzc = false;
                                return;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    zzqVar.zzd(zzwVar);
                }
            }
        }
    }

    public zzr(Parameters.Builder builder, String str, boolean z) {
        this.zza = builder;
        this.zzb = str;
        this.zzc = z;
    }
}
