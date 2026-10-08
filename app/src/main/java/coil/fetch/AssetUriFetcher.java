package coil.fetch;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.webkit.MimeTypeMap;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.core.content.res.ResourcesCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import coil.decode.AssetMetadata;
import coil.decode.ResourceMetadata;
import coil.decode.SourceImageSource;
import coil.request.Options;
import coil.size.Dimension;
import coil.size.Size;
import coil.util.DrawableUtils;
import coil.util.Utils;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import kotlin.collections.AbstractList;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import okio.Okio;
import okio.RealBufferedSource;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AssetUriFetcher implements Fetcher {
    public final /* synthetic */ int $r8$classId;
    public final Uri data;
    public final Options options;

    public /* synthetic */ AssetUriFetcher(Uri uri, Options options, int i) {
        this.$r8$classId = i;
        this.data = uri;
        this.options = options;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:53:0x0120  */
    /* JADX WARN: Code duplicated, block: B:96:0x0231  */
    @Override // coil.fetch.Fetcher
    public final Object fetch(Continuation continuation) throws XmlPullParserException, IOException {
        InputStream inputStreamOpenInputStream;
        List<String> pathSegments;
        int size;
        Bundle bundle;
        Integer intOrNull;
        Drawable drawable;
        Drawable animatedVectorDrawableCompat;
        int i = this.$r8$classId;
        Uri uri = this.data;
        Options options = this.options;
        boolean z = true;
        switch (i) {
            case 0:
                String strJoinToString$default = CollectionsKt.joinToString$default(CollectionsKt.drop(1, uri.getPathSegments()), "/", null, null, null, 62);
                return new SourceResult(new SourceImageSource(new RealBufferedSource(Okio.source(options.context.getAssets().open(strJoinToString$default))), new AssetMetadata()), Utils.getMimeTypeFromUrl(MimeTypeMap.getSingleton(), strJoinToString$default), 3);
            case 1:
                ContentResolver contentResolver = options.context.getContentResolver();
                if (Intrinsics.areEqual(uri.getAuthority(), "com.android.contacts") && Intrinsics.areEqual(uri.getLastPathSegment(), "display_photo")) {
                    AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
                    inputStreamOpenInputStream = assetFileDescriptorOpenAssetFileDescriptor != null ? assetFileDescriptorOpenAssetFileDescriptor.createInputStream() : null;
                    if (inputStreamOpenInputStream == null) {
                        throw new IllegalStateException(("Unable to find a contact photo associated with '" + uri + "'.").toString());
                    }
                } else if (Build.VERSION.SDK_INT >= 29 && Intrinsics.areEqual(uri.getAuthority(), "media") && (size = (pathSegments = uri.getPathSegments()).size()) >= 3 && Intrinsics.areEqual(pathSegments.get(size - 3), "audio") && Intrinsics.areEqual(pathSegments.get(size - 2), "albums")) {
                    Size size2 = options.size;
                    Dimension dimension = size2.width;
                    Dimension.Pixels pixels = dimension instanceof Dimension.Pixels ? (Dimension.Pixels) dimension : null;
                    if (pixels != null) {
                        int i2 = pixels.px;
                        Dimension dimension2 = size2.height;
                        Dimension.Pixels pixels2 = dimension2 instanceof Dimension.Pixels ? (Dimension.Pixels) dimension2 : null;
                        if (pixels2 != null) {
                            int i3 = pixels2.px;
                            bundle = new Bundle(1);
                            bundle.putParcelable("android.content.extra.SIZE", new Point(i2, i3));
                        } else {
                            bundle = null;
                        }
                    } else {
                        bundle = null;
                    }
                    AssetFileDescriptor assetFileDescriptorOpenTypedAssetFile = contentResolver.openTypedAssetFile(uri, "image/*", bundle, null);
                    inputStreamOpenInputStream = assetFileDescriptorOpenTypedAssetFile != null ? assetFileDescriptorOpenTypedAssetFile.createInputStream() : null;
                    if (inputStreamOpenInputStream == null) {
                        throw new IllegalStateException(("Unable to find a music thumbnail associated with '" + uri + "'.").toString());
                    }
                } else {
                    inputStreamOpenInputStream = contentResolver.openInputStream(uri);
                    if (inputStreamOpenInputStream == null) {
                        throw new IllegalStateException(("Unable to open '" + uri + "'.").toString());
                    }
                }
                return new SourceResult(new SourceImageSource(new RealBufferedSource(Okio.source(inputStreamOpenInputStream)), new AssetMetadata()), contentResolver.getType(uri), 3);
            default:
                String authority = uri.getAuthority();
                if (authority != null) {
                    String str = StringsKt.isBlank(authority) ? null : authority;
                    if (str != null) {
                        String str2 = (String) CollectionsKt.lastOrNull(uri.getPathSegments());
                        if (str2 == null || (intOrNull = StringsKt__StringsJVMKt.toIntOrNull(str2)) == null) {
                            throw new IllegalStateException("Invalid android.resource URI: " + uri);
                        }
                        int iIntValue = intOrNull.intValue();
                        Context context = options.context;
                        Resources resources = str.equals(context.getPackageName()) ? context.getResources() : context.getPackageManager().getResourcesForApplication(str);
                        TypedValue typedValue = new TypedValue();
                        resources.getValue(iIntValue, typedValue, true);
                        CharSequence charSequence = typedValue.string;
                        String mimeTypeFromUrl = Utils.getMimeTypeFromUrl(MimeTypeMap.getSingleton(), charSequence.subSequence(StringsKt.lastIndexOf$default(charSequence, '/', 0, 6), charSequence.length()).toString());
                        if (!Intrinsics.areEqual(mimeTypeFromUrl, "text/xml")) {
                            TypedValue typedValue2 = new TypedValue();
                            return new SourceResult(new SourceImageSource(new RealBufferedSource(Okio.source(resources.openRawResource(iIntValue, typedValue2))), new ResourceMetadata(typedValue2.density)), mimeTypeFromUrl, 3);
                        }
                        if (str.equals(context.getPackageName())) {
                            drawable = AbstractList.Companion.getDrawable(context, iIntValue);
                            if (drawable == null) {
                                throw new IllegalStateException(ImageAnalysis$$ExternalSyntheticLambda1.m("Invalid resource ID: ", iIntValue).toString());
                            }
                        } else {
                            XmlResourceParser xml = resources.getXml(iIntValue);
                            int next = xml.next();
                            while (next != 2 && next != 1) {
                                next = xml.next();
                            }
                            if (next != 2) {
                                throw new XmlPullParserException("No start tag found.");
                            }
                            if (Build.VERSION.SDK_INT < 24) {
                                String name = xml.getName();
                                if (Intrinsics.areEqual(name, "vector")) {
                                    AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                                    Resources.Theme theme = context.getTheme();
                                    animatedVectorDrawableCompat = new VectorDrawableCompat();
                                    animatedVectorDrawableCompat.inflate(resources, xml, attributeSetAsAttributeSet, theme);
                                } else if (Intrinsics.areEqual(name, "animated-vector")) {
                                    AttributeSet attributeSetAsAttributeSet2 = Xml.asAttributeSet(xml);
                                    Resources.Theme theme2 = context.getTheme();
                                    animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(context);
                                    animatedVectorDrawableCompat.inflate(resources, xml, attributeSetAsAttributeSet2, theme2);
                                } else {
                                    Resources.Theme theme3 = context.getTheme();
                                    ThreadLocal threadLocal = ResourcesCompat.sTempTypedValue;
                                    drawable = resources.getDrawable(iIntValue, theme3);
                                    if (drawable == null) {
                                        throw new IllegalStateException(ImageAnalysis$$ExternalSyntheticLambda1.m("Invalid resource ID: ", iIntValue).toString());
                                    }
                                }
                                drawable = animatedVectorDrawableCompat;
                            } else {
                                Resources.Theme theme4 = context.getTheme();
                                ThreadLocal threadLocal2 = ResourcesCompat.sTempTypedValue;
                                drawable = resources.getDrawable(iIntValue, theme4);
                                if (drawable == null) {
                                    throw new IllegalStateException(ImageAnalysis$$ExternalSyntheticLambda1.m("Invalid resource ID: ", iIntValue).toString());
                                }
                            }
                        }
                        if (!(drawable instanceof VectorDrawable) && !(drawable instanceof VectorDrawableCompat)) {
                            z = false;
                        }
                        if (z) {
                            drawable = new BitmapDrawable(context.getResources(), DrawableUtils.convertToBitmap(drawable, options.config, options.size, options.scale, options.allowInexactSize));
                        }
                        return new DrawableResult(drawable, z, 3);
                    }
                }
                throw new IllegalStateException("Invalid android.resource URI: " + uri);
        }
    }
}
