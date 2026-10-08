package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.compose.ui.node.RulerTrackingMap;
import androidx.room.RoomOpenHelper;
import kotlin.collections.AbstractList;
import okhttp3.ConnectionSpec;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class AppCompatImageButton extends ImageButton {
    public final RulerTrackingMap mBackgroundTintHelper;
    public boolean mHasLevel;
    public final RoomOpenHelper mImageHelper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TintContextWrapper.wrap(context);
        this.mHasLevel = false;
        ThemeUtils.checkAppCompatTheme(this, getContext());
        RulerTrackingMap rulerTrackingMap = new RulerTrackingMap(this);
        this.mBackgroundTintHelper = rulerTrackingMap;
        rulerTrackingMap.loadFromAttributes(attributeSet, i);
        RoomOpenHelper roomOpenHelper = new RoomOpenHelper(this);
        this.mImageHelper = roomOpenHelper;
        roomOpenHelper.loadFromAttributes(attributeSet, i);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        RulerTrackingMap rulerTrackingMap = this.mBackgroundTintHelper;
        if (rulerTrackingMap != null) {
            rulerTrackingMap.applySupportBackgroundTint();
        }
        RoomOpenHelper roomOpenHelper = this.mImageHelper;
        if (roomOpenHelper != null) {
            roomOpenHelper.applySupportImageTint();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        RulerTrackingMap rulerTrackingMap = this.mBackgroundTintHelper;
        if (rulerTrackingMap != null) {
            return rulerTrackingMap.getSupportBackgroundTintList();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        RulerTrackingMap rulerTrackingMap = this.mBackgroundTintHelper;
        if (rulerTrackingMap != null) {
            return rulerTrackingMap.getSupportBackgroundTintMode();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        ConnectionSpec.Builder builder;
        RoomOpenHelper roomOpenHelper = this.mImageHelper;
        if (roomOpenHelper == null || (builder = (ConnectionSpec.Builder) roomOpenHelper.mDelegate) == null) {
            return null;
        }
        return (ColorStateList) builder.cipherSuites;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        ConnectionSpec.Builder builder;
        RoomOpenHelper roomOpenHelper = this.mImageHelper;
        if (roomOpenHelper == null || (builder = (ConnectionSpec.Builder) roomOpenHelper.mDelegate) == null) {
            return null;
        }
        return (PorterDuff.Mode) builder.tlsVersions;
    }

    @Override // android.widget.ImageView, android.view.View
    public final boolean hasOverlappingRendering() {
        return !(((ImageView) this.mImageHelper.mConfiguration).getBackground() instanceof RippleDrawable) && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        RulerTrackingMap rulerTrackingMap = this.mBackgroundTintHelper;
        if (rulerTrackingMap != null) {
            rulerTrackingMap.onSetBackgroundDrawable();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        RulerTrackingMap rulerTrackingMap = this.mBackgroundTintHelper;
        if (rulerTrackingMap != null) {
            rulerTrackingMap.onSetBackgroundResource(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        RoomOpenHelper roomOpenHelper = this.mImageHelper;
        if (roomOpenHelper != null) {
            roomOpenHelper.applySupportImageTint();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        RoomOpenHelper roomOpenHelper = this.mImageHelper;
        if (roomOpenHelper != null && drawable != null && !this.mHasLevel) {
            roomOpenHelper.version = drawable.getLevel();
        }
        super.setImageDrawable(drawable);
        if (roomOpenHelper != null) {
            roomOpenHelper.applySupportImageTint();
            if (this.mHasLevel) {
                return;
            }
            ImageView imageView = (ImageView) roomOpenHelper.mConfiguration;
            if (imageView.getDrawable() != null) {
                imageView.getDrawable().setLevel(roomOpenHelper.version);
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i) {
        super.setImageLevel(i);
        this.mHasLevel = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        RoomOpenHelper roomOpenHelper = this.mImageHelper;
        ImageView imageView = (ImageView) roomOpenHelper.mConfiguration;
        if (i != 0) {
            Drawable drawable = AbstractList.Companion.getDrawable(imageView.getContext(), i);
            if (drawable != null) {
                DrawableUtils.fixDrawable(drawable);
            }
            imageView.setImageDrawable(drawable);
        } else {
            imageView.setImageDrawable(null);
        }
        roomOpenHelper.applySupportImageTint();
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        RoomOpenHelper roomOpenHelper = this.mImageHelper;
        if (roomOpenHelper != null) {
            roomOpenHelper.applySupportImageTint();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        RulerTrackingMap rulerTrackingMap = this.mBackgroundTintHelper;
        if (rulerTrackingMap != null) {
            rulerTrackingMap.setSupportBackgroundTintList(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        RulerTrackingMap rulerTrackingMap = this.mBackgroundTintHelper;
        if (rulerTrackingMap != null) {
            rulerTrackingMap.setSupportBackgroundTintMode(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        RoomOpenHelper roomOpenHelper = this.mImageHelper;
        if (roomOpenHelper != null) {
            if (((ConnectionSpec.Builder) roomOpenHelper.mDelegate) == null) {
                roomOpenHelper.mDelegate = new ConnectionSpec.Builder();
            }
            ConnectionSpec.Builder builder = (ConnectionSpec.Builder) roomOpenHelper.mDelegate;
            builder.cipherSuites = colorStateList;
            builder.supportsTlsExtensions = true;
            roomOpenHelper.applySupportImageTint();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        RoomOpenHelper roomOpenHelper = this.mImageHelper;
        if (roomOpenHelper != null) {
            if (((ConnectionSpec.Builder) roomOpenHelper.mDelegate) == null) {
                roomOpenHelper.mDelegate = new ConnectionSpec.Builder();
            }
            ConnectionSpec.Builder builder = (ConnectionSpec.Builder) roomOpenHelper.mDelegate;
            builder.tlsVersions = mode;
            builder.tls = true;
            roomOpenHelper.applySupportImageTint();
        }
    }
}
