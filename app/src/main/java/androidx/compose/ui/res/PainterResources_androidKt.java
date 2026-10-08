package androidx.compose.ui.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.graphics.AndroidImageBitmap;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.BrushKt$ShaderBrush$1;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathParserKt;
import androidx.compose.ui.graphics.vector.VectorGroup;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPath;
import androidx.compose.ui.graphics.vector.compat.AndroidVectorParser;
import androidx.compose.ui.graphics.vector.compat.AndroidVectorResources;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.core.content.res.CamUtils;
import androidx.room.RoomOpenHelper;
import coil.network.HttpException;
import coil.request.Parameters;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class PainterResources_androidKt {
    /* JADX WARN: Code duplicated, block: B:128:0x036b  */
    /* JADX WARN: Code duplicated, block: B:147:0x03eb  */
    /* JADX WARN: Code duplicated, block: B:148:0x03f0  */
    /* JADX WARN: Code duplicated, block: B:154:0x040c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:155:0x040e  */
    /* JADX WARN: Code duplicated, block: B:156:0x0416  */
    /* JADX WARN: Code duplicated, block: B:163:0x0431 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:164:0x0433  */
    /* JADX WARN: Code duplicated, block: B:166:0x043b  */
    /* JADX WARN: Code duplicated, block: B:169:0x044b  */
    /* JADX WARN: Code duplicated, block: B:170:0x044e  */
    /* JADX WARN: Code duplicated, block: B:173:0x0454  */
    public static final Painter painterResource(int i, GapComposer gapComposer) {
        TypedValue typedValue;
        long jColor;
        int i2;
        int i3;
        byte b;
        int i4;
        int i5;
        int i6;
        RoomOpenHelper namedComplexColor;
        int i7;
        Shader shader;
        Brush solidColor;
        Shader shader2;
        Brush solidColor2;
        Brush brush;
        int i8;
        Context context = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
        Resources resources = (Resources) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalResources);
        ResourceIdCache resourceIdCache = (ResourceIdCache) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalResourceIdCache);
        synchronized (resourceIdCache) {
            typedValue = (TypedValue) resourceIdCache.resIdPathMap.get(i);
            if (typedValue == null) {
                typedValue = new TypedValue();
                resources.getValue(i, typedValue, true);
                MutableIntObjectMap mutableIntObjectMap = resourceIdCache.resIdPathMap;
                int iFindAbsoluteInsertIndex = mutableIntObjectMap.findAbsoluteInsertIndex(i);
                Object[] objArr = mutableIntObjectMap.values;
                Object obj = objArr[iFindAbsoluteInsertIndex];
                mutableIntObjectMap.keys[iFindAbsoluteInsertIndex] = i;
                objArr[iFindAbsoluteInsertIndex] = typedValue;
            }
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence == null || !StringsKt.endsWith$default(charSequence, ".xml")) {
            gapComposer.startReplaceGroup(-1771643000);
            boolean zChanged = gapComposer.changed(context.getTheme()) | gapComposer.changed(charSequence) | gapComposer.changed(i);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue == Composer$Companion.Empty) {
                try {
                    objRememberedValue = new AndroidImageBitmap(((BitmapDrawable) resources.getDrawable(i, null)).getBitmap());
                    gapComposer.updateRememberedValue(objRememberedValue);
                } catch (Exception e) {
                    throw new HttpException("Error attempting to load resource: " + ((Object) charSequence), e);
                }
            }
            AndroidImageBitmap androidImageBitmap = (AndroidImageBitmap) objRememberedValue;
            BitmapPainter bitmapPainter = new BitmapPainter(androidImageBitmap, (((long) androidImageBitmap.bitmap.getHeight()) & 4294967295L) | (((long) androidImageBitmap.bitmap.getWidth()) << 32));
            gapComposer.end(false);
            return bitmapPainter;
        }
        gapComposer.startReplaceGroup(-1771798434);
        Resources.Theme theme = context.getTheme();
        int i9 = typedValue.changingConfigurations;
        ImageVectorCache imageVectorCache = (ImageVectorCache) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalImageVectorCache);
        ImageVectorCache.Key key = new ImageVectorCache.Key(theme, i);
        WeakReference weakReference = (WeakReference) imageVectorCache.map.get(key);
        ImageVectorCache.ImageVectorEntry imageVectorEntry = weakReference != null ? (ImageVectorCache.ImageVectorEntry) weakReference.get() : null;
        if (imageVectorEntry == null) {
            XmlResourceParser xml = resources.getXml(i);
            int next = xml.next();
            while (next != 2 && next != 1) {
                next = xml.next();
            }
            if (next != 2) {
                throw new XmlPullParserException("No start tag found");
            }
            if (!Intrinsics.areEqual(xml.getName(), "vector")) {
                throw new IllegalArgumentException("Only VectorDrawables and rasterized asset types are supported ex. PNG, JPG, WEBP");
            }
            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
            AndroidVectorParser androidVectorParser = new AndroidVectorParser(xml);
            TypedArray typedArrayObtainAttributes = CamUtils.obtainAttributes(resources, theme, attributeSetAsAttributeSet, AndroidVectorResources.STYLEABLE_VECTOR_DRAWABLE_TYPE_ARRAY);
            androidVectorParser.updateConfig(typedArrayObtainAttributes.getChangingConfigurations());
            boolean z = !CamUtils.hasAttribute(xml, "autoMirrored") ? false : typedArrayObtainAttributes.getBoolean(5, false);
            androidVectorParser.updateConfig(typedArrayObtainAttributes.getChangingConfigurations());
            float namedFloat = androidVectorParser.getNamedFloat(typedArrayObtainAttributes, "viewportWidth", 7, 0.0f);
            float namedFloat2 = androidVectorParser.getNamedFloat(typedArrayObtainAttributes, "viewportHeight", 8, 0.0f);
            if (namedFloat <= 0.0f) {
                throw new XmlPullParserException(typedArrayObtainAttributes.getPositionDescription() + "<VectorGraphic> tag requires viewportWidth > 0");
            }
            if (namedFloat2 <= 0.0f) {
                throw new XmlPullParserException(typedArrayObtainAttributes.getPositionDescription() + "<VectorGraphic> tag requires viewportHeight > 0");
            }
            int i10 = 3;
            float dimension = typedArrayObtainAttributes.getDimension(3, 0.0f);
            androidVectorParser.updateConfig(typedArrayObtainAttributes.getChangingConfigurations());
            float dimension2 = typedArrayObtainAttributes.getDimension(2, 0.0f);
            androidVectorParser.updateConfig(typedArrayObtainAttributes.getChangingConfigurations());
            if (typedArrayObtainAttributes.hasValue(1)) {
                TypedValue typedValue2 = new TypedValue();
                typedArrayObtainAttributes.getValue(1, typedValue2);
                if (typedValue2.type == 2) {
                    jColor = Color.Unspecified;
                } else {
                    ColorStateList namedColorStateList = CamUtils.getNamedColorStateList(typedArrayObtainAttributes, xml, theme);
                    androidVectorParser.updateConfig(typedArrayObtainAttributes.getChangingConfigurations());
                    jColor = namedColorStateList != null ? BrushKt.Color(namedColorStateList.getDefaultColor()) : Color.Unspecified;
                }
            } else {
                jColor = Color.Unspecified;
            }
            long j = jColor;
            int i11 = typedArrayObtainAttributes.getInt(6, -1);
            androidVectorParser.updateConfig(typedArrayObtainAttributes.getChangingConfigurations());
            if (i11 == -1) {
                i2 = 5;
            } else if (i11 == 3) {
                i2 = 3;
            } else if (i11 == 5) {
                i2 = 5;
            } else if (i11 != 9) {
                switch (i11) {
                    case 14:
                        i2 = 13;
                        break;
                    case 15:
                        i2 = 14;
                        break;
                    case 16:
                        i2 = 12;
                        break;
                    default:
                        i2 = 5;
                        break;
                }
            } else {
                i2 = 9;
            }
            float f = dimension / resources.getDisplayMetrics().density;
            float f2 = dimension2 / resources.getDisplayMetrics().density;
            typedArrayObtainAttributes.recycle();
            ImageVector.Builder builder = new ImageVector.Builder(null, f, f2, namedFloat, namedFloat2, j, i2, z, 1);
            int i12 = 0;
            while (xml.getEventType() != 1 && (xml.getDepth() >= 1 || xml.getEventType() != i10)) {
                List listPathStringToNodes$default = EmptyList.INSTANCE;
                XmlPullParser xmlPullParser = androidVectorParser.xmlParser;
                Parameters.Builder builder2 = androidVectorParser.pathParser;
                XmlResourceParser xmlResourceParser = xml;
                int eventType = xmlPullParser.getEventType();
                int i13 = i9;
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    if (name != null) {
                        int iHashCode = name.hashCode();
                        if (iHashCode != -1649314686) {
                            i3 = i12;
                            if (iHashCode != 3433509) {
                                if (iHashCode == 98629247 && name.equals("group")) {
                                    TypedArray typedArrayObtainAttributes2 = CamUtils.obtainAttributes(resources, theme, attributeSetAsAttributeSet, AndroidVectorResources.STYLEABLE_VECTOR_DRAWABLE_GROUP);
                                    androidVectorParser.updateConfig(typedArrayObtainAttributes2.getChangingConfigurations());
                                    float namedFloat3 = androidVectorParser.getNamedFloat(typedArrayObtainAttributes2, "rotation", 5, 0.0f);
                                    float f3 = typedArrayObtainAttributes2.getFloat(1, 0.0f);
                                    androidVectorParser.updateConfig(typedArrayObtainAttributes2.getChangingConfigurations());
                                    float f4 = typedArrayObtainAttributes2.getFloat(2, 0.0f);
                                    androidVectorParser.updateConfig(typedArrayObtainAttributes2.getChangingConfigurations());
                                    float namedFloat4 = androidVectorParser.getNamedFloat(typedArrayObtainAttributes2, "scaleX", 3, 1.0f);
                                    float namedFloat5 = androidVectorParser.getNamedFloat(typedArrayObtainAttributes2, "scaleY", 4, 1.0f);
                                    float namedFloat6 = androidVectorParser.getNamedFloat(typedArrayObtainAttributes2, "translateX", 6, 0.0f);
                                    float namedFloat7 = androidVectorParser.getNamedFloat(typedArrayObtainAttributes2, "translateY", 7, 0.0f);
                                    String string = typedArrayObtainAttributes2.getString(0);
                                    androidVectorParser.updateConfig(typedArrayObtainAttributes2.getChangingConfigurations());
                                    String str = string == null ? "" : string;
                                    typedArrayObtainAttributes2.recycle();
                                    int i14 = VectorKt.$r8$clinit;
                                    if (builder.isConsumed) {
                                        InlineClassHelperKt.throwIllegalStateException("ImageVector.Builder is single use, create a new instance to create a new ImageVector");
                                    }
                                    builder.nodes.add(new ImageVector.Builder.GroupParams(str, namedFloat3, f3, f4, namedFloat4, namedFloat5, namedFloat6, namedFloat7, listPathStringToNodes$default, 512));
                                    i12 = i3;
                                    b = -1;
                                    i4 = 3;
                                }
                            } else if (name.equals("path")) {
                                TypedArray typedArrayObtainAttributes3 = CamUtils.obtainAttributes(resources, theme, attributeSetAsAttributeSet, AndroidVectorResources.STYLEABLE_VECTOR_DRAWABLE_PATH);
                                androidVectorParser.updateConfig(typedArrayObtainAttributes3.getChangingConfigurations());
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "pathData") == null) {
                                    throw new IllegalArgumentException("No path data available");
                                }
                                String string2 = typedArrayObtainAttributes3.getString(0);
                                androidVectorParser.updateConfig(typedArrayObtainAttributes3.getChangingConfigurations());
                                String str2 = string2 == null ? "" : string2;
                                String string3 = typedArrayObtainAttributes3.getString(2);
                                androidVectorParser.updateConfig(typedArrayObtainAttributes3.getChangingConfigurations());
                                if (string3 == null) {
                                    int i15 = VectorKt.$r8$clinit;
                                } else {
                                    listPathStringToNodes$default = Parameters.Builder.pathStringToNodes$default(builder2, string3);
                                }
                                List list = listPathStringToNodes$default;
                                RoomOpenHelper namedComplexColor2 = CamUtils.getNamedComplexColor(typedArrayObtainAttributes3, androidVectorParser.xmlParser, theme, "fillColor", 1);
                                androidVectorParser.updateConfig(typedArrayObtainAttributes3.getChangingConfigurations());
                                float namedFloat8 = androidVectorParser.getNamedFloat(typedArrayObtainAttributes3, "fillAlpha", 12, 1.0f);
                                int i16 = !CamUtils.hasAttribute(androidVectorParser.xmlParser, "strokeLineCap") ? -1 : typedArrayObtainAttributes3.getInt(8, -1);
                                androidVectorParser.updateConfig(typedArrayObtainAttributes3.getChangingConfigurations());
                                if (i16 == 0) {
                                    i5 = 0;
                                } else if (i16 == 1) {
                                    i5 = 1;
                                } else if (i16 != 2) {
                                    i5 = 0;
                                } else {
                                    i5 = 2;
                                }
                                int i17 = !CamUtils.hasAttribute(androidVectorParser.xmlParser, "strokeLineJoin") ? -1 : typedArrayObtainAttributes3.getInt(9, -1);
                                androidVectorParser.updateConfig(typedArrayObtainAttributes3.getChangingConfigurations());
                                if (i17 != 0) {
                                    if (i17 == 1) {
                                        i6 = 1;
                                    } else if (i17 == 2) {
                                        i6 = 2;
                                    }
                                    float namedFloat9 = androidVectorParser.getNamedFloat(typedArrayObtainAttributes3, "strokeMiterLimit", 10, 4.0f);
                                    namedComplexColor = CamUtils.getNamedComplexColor(typedArrayObtainAttributes3, androidVectorParser.xmlParser, theme, "strokeColor", 3);
                                    androidVectorParser.updateConfig(typedArrayObtainAttributes3.getChangingConfigurations());
                                    float namedFloat10 = androidVectorParser.getNamedFloat(typedArrayObtainAttributes3, "strokeAlpha", 11, 1.0f);
                                    float namedFloat11 = androidVectorParser.getNamedFloat(typedArrayObtainAttributes3, "strokeWidth", 4, 1.0f);
                                    float namedFloat12 = androidVectorParser.getNamedFloat(typedArrayObtainAttributes3, "trimPathEnd", 6, 1.0f);
                                    float namedFloat13 = androidVectorParser.getNamedFloat(typedArrayObtainAttributes3, "trimPathOffset", 7, 0.0f);
                                    float namedFloat14 = androidVectorParser.getNamedFloat(typedArrayObtainAttributes3, "trimPathStart", 5, 0.0f);
                                    if (CamUtils.hasAttribute(androidVectorParser.xmlParser, "fillType")) {
                                        i7 = typedArrayObtainAttributes3.getInt(13, 0);
                                    } else {
                                        i7 = 0;
                                    }
                                    androidVectorParser.updateConfig(typedArrayObtainAttributes3.getChangingConfigurations());
                                    typedArrayObtainAttributes3.recycle();
                                    shader = (Shader) namedComplexColor2.mConfiguration;
                                    if (shader == null && namedComplexColor2.version == 0) {
                                        solidColor = null;
                                    } else if (shader != null) {
                                        solidColor = new BrushKt$ShaderBrush$1(shader);
                                    } else {
                                        solidColor = new SolidColor(BrushKt.Color(namedComplexColor2.version));
                                    }
                                    shader2 = (Shader) namedComplexColor.mConfiguration;
                                    if (shader2 != null && namedComplexColor.version == 0) {
                                        brush = null;
                                    } else {
                                        if (shader2 != null) {
                                            solidColor2 = new BrushKt$ShaderBrush$1(shader2);
                                        } else {
                                            solidColor2 = new SolidColor(BrushKt.Color(namedComplexColor.version));
                                        }
                                        brush = solidColor2;
                                    }
                                    if (i7 == 0) {
                                        i8 = 0;
                                    } else {
                                        i8 = 1;
                                    }
                                    if (builder.isConsumed) {
                                        InlineClassHelperKt.throwIllegalStateException("ImageVector.Builder is single use, create a new instance to create a new ImageVector");
                                    }
                                    ArrayList arrayList = builder.nodes;
                                    ((ImageVector.Builder.GroupParams) arrayList.get(arrayList.size() - 1)).children.add(new VectorPath(str2, list, i8, solidColor, namedFloat8, brush, namedFloat10, namedFloat11, i5, i6, namedFloat9, namedFloat14, namedFloat12, namedFloat13));
                                    i4 = 3;
                                    i12 = i3;
                                    b = -1;
                                }
                                i6 = 0;
                                float namedFloat15 = androidVectorParser.getNamedFloat(typedArrayObtainAttributes3, "strokeMiterLimit", 10, 4.0f);
                                namedComplexColor = CamUtils.getNamedComplexColor(typedArrayObtainAttributes3, androidVectorParser.xmlParser, theme, "strokeColor", 3);
                                androidVectorParser.updateConfig(typedArrayObtainAttributes3.getChangingConfigurations());
                                float namedFloat16 = androidVectorParser.getNamedFloat(typedArrayObtainAttributes3, "strokeAlpha", 11, 1.0f);
                                float namedFloat17 = androidVectorParser.getNamedFloat(typedArrayObtainAttributes3, "strokeWidth", 4, 1.0f);
                                float namedFloat18 = androidVectorParser.getNamedFloat(typedArrayObtainAttributes3, "trimPathEnd", 6, 1.0f);
                                float namedFloat19 = androidVectorParser.getNamedFloat(typedArrayObtainAttributes3, "trimPathOffset", 7, 0.0f);
                                float namedFloat110 = androidVectorParser.getNamedFloat(typedArrayObtainAttributes3, "trimPathStart", 5, 0.0f);
                                if (CamUtils.hasAttribute(androidVectorParser.xmlParser, "fillType")) {
                                    i7 = 0;
                                } else {
                                    i7 = typedArrayObtainAttributes3.getInt(13, 0);
                                }
                                androidVectorParser.updateConfig(typedArrayObtainAttributes3.getChangingConfigurations());
                                typedArrayObtainAttributes3.recycle();
                                shader = (Shader) namedComplexColor2.mConfiguration;
                                if (shader == null) {
                                    solidColor = null;
                                } else if (shader != null) {
                                    solidColor = new BrushKt$ShaderBrush$1(shader);
                                } else {
                                    solidColor = new SolidColor(BrushKt.Color(namedComplexColor2.version));
                                }
                                shader2 = (Shader) namedComplexColor.mConfiguration;
                                if (shader2 != null) {
                                    if (shader2 != null) {
                                        solidColor2 = new BrushKt$ShaderBrush$1(shader2);
                                    } else {
                                        solidColor2 = new SolidColor(BrushKt.Color(namedComplexColor.version));
                                    }
                                    brush = solidColor2;
                                } else {
                                    brush = null;
                                }
                                if (i7 == 0) {
                                    i8 = 0;
                                } else {
                                    i8 = 1;
                                }
                                if (builder.isConsumed) {
                                    InlineClassHelperKt.throwIllegalStateException("ImageVector.Builder is single use, create a new instance to create a new ImageVector");
                                }
                                ArrayList arrayList2 = builder.nodes;
                                ((ImageVector.Builder.GroupParams) arrayList2.get(arrayList2.size() - 1)).children.add(new VectorPath(str2, list, i8, solidColor, namedFloat8, brush, namedFloat16, namedFloat17, i5, i6, namedFloat15, namedFloat110, namedFloat18, namedFloat19));
                                i4 = 3;
                                i12 = i3;
                                b = -1;
                            }
                        } else {
                            i3 = i12;
                            b = -1;
                            i4 = 3;
                            if (name.equals("clip-path")) {
                                TypedArray typedArrayObtainAttributes4 = CamUtils.obtainAttributes(resources, theme, attributeSetAsAttributeSet, AndroidVectorResources.STYLEABLE_VECTOR_DRAWABLE_CLIP_PATH);
                                androidVectorParser.updateConfig(typedArrayObtainAttributes4.getChangingConfigurations());
                                String string4 = typedArrayObtainAttributes4.getString(0);
                                androidVectorParser.updateConfig(typedArrayObtainAttributes4.getChangingConfigurations());
                                String str3 = string4 == null ? "" : string4;
                                String string5 = typedArrayObtainAttributes4.getString(1);
                                androidVectorParser.updateConfig(typedArrayObtainAttributes4.getChangingConfigurations());
                                if (string5 == null) {
                                    int i18 = VectorKt.$r8$clinit;
                                } else {
                                    listPathStringToNodes$default = Parameters.Builder.pathStringToNodes$default(builder2, string5);
                                }
                                List list2 = listPathStringToNodes$default;
                                typedArrayObtainAttributes4.recycle();
                                if (builder.isConsumed) {
                                    InlineClassHelperKt.throwIllegalStateException("ImageVector.Builder is single use, create a new instance to create a new ImageVector");
                                }
                                builder.nodes.add(new ImageVector.Builder.GroupParams(str3, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, list2, 512));
                                i12 = i3 + 1;
                            } else {
                                i12 = i3;
                            }
                        }
                    } else {
                        i3 = i12;
                    }
                    b = -1;
                    i4 = 3;
                    i12 = i3;
                } else if (eventType == i10 && "group".equals(xmlPullParser.getName())) {
                    int i19 = i12 + 1;
                    int i20 = 0;
                    while (i20 < i19) {
                        ArrayList arrayList3 = builder.nodes;
                        if (builder.isConsumed) {
                            InlineClassHelperKt.throwIllegalStateException("ImageVector.Builder is single use, create a new instance to create a new ImageVector");
                        }
                        ImageVector.Builder.GroupParams groupParams = (ImageVector.Builder.GroupParams) arrayList3.remove(arrayList3.size() - 1);
                        ((ImageVector.Builder.GroupParams) arrayList3.get(arrayList3.size() - 1)).children.add(new VectorGroup(groupParams.name, groupParams.rotate, groupParams.pivotX, groupParams.pivotY, groupParams.scaleX, groupParams.scaleY, groupParams.translationX, groupParams.translationY, groupParams.clipPathData, groupParams.children));
                        i20++;
                        i10 = 3;
                    }
                    i4 = i10;
                    i12 = 0;
                    b = -1;
                } else {
                    i3 = i12;
                    i4 = i10;
                    b = -1;
                    i12 = i3;
                }
                xmlResourceParser.next();
                xml = xmlResourceParser;
                i9 = i13;
                i10 = i4;
            }
            imageVectorEntry = new ImageVectorCache.ImageVectorEntry(builder.build(), i9 | androidVectorParser.config);
            imageVectorCache.map.put(key, new WeakReference(imageVectorEntry));
        }
        VectorPainter vectorPainterRememberVectorPainter = PathParserKt.rememberVectorPainter(imageVectorEntry.imageVector, gapComposer);
        gapComposer.end(false);
        return vectorPainterRememberVectorPainter;
    }
}
