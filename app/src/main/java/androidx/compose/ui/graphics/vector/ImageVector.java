package androidx.compose.ui.graphics.vector;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ImageVector {
    public static int imageVectorCount;
    public static final ByteString.Companion lock = new ByteString.Companion(6);
    public final boolean autoMirror;
    public final float defaultHeight;
    public final float defaultWidth;
    public final int genId;
    public final String name;
    public final VectorGroup root;
    public final int tintBlendMode;
    public final long tintColor;
    public final float viewportHeight;
    public final float viewportWidth;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Builder {
        public final boolean autoMirror;
        public final float defaultHeight;
        public final float defaultWidth;
        public boolean isConsumed;
        public final String name;
        public final ArrayList nodes;
        public final GroupParams root;
        public final int tintBlendMode;
        public final long tintColor;
        public final float viewportHeight;
        public final float viewportWidth;

        /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
        public final class GroupParams {
            public final ArrayList children;
            public final List clipPathData;
            public final String name;
            public final float pivotX;
            public final float pivotY;
            public final float rotate;
            public final float scaleX;
            public final float scaleY;
            public final float translationX;
            public final float translationY;

            public GroupParams(String str, float f, float f2, float f3, float f4, float f5, float f6, float f7, List list, int i) {
                str = (i & 1) != 0 ? "" : str;
                f = (i & 2) != 0 ? 0.0f : f;
                f2 = (i & 4) != 0 ? 0.0f : f2;
                f3 = (i & 8) != 0 ? 0.0f : f3;
                f4 = (i & 16) != 0 ? 1.0f : f4;
                f5 = (i & 32) != 0 ? 1.0f : f5;
                f6 = (i & 64) != 0 ? 0.0f : f6;
                f7 = (i & 128) != 0 ? 0.0f : f7;
                if ((i & 256) != 0) {
                    int i2 = VectorKt.$r8$clinit;
                    list = EmptyList.INSTANCE;
                }
                ArrayList arrayList = new ArrayList();
                this.name = str;
                this.rotate = f;
                this.pivotX = f2;
                this.pivotY = f3;
                this.scaleX = f4;
                this.scaleY = f5;
                this.translationX = f6;
                this.translationY = f7;
                this.clipPathData = list;
                this.children = arrayList;
            }
        }

        public Builder(String str, float f, float f2, float f3, float f4, long j, int i, boolean z, int i2) {
            str = (i2 & 1) != 0 ? "" : str;
            long j2 = (i2 & 32) != 0 ? Color.Unspecified : j;
            int i3 = (i2 & 64) != 0 ? 5 : i;
            boolean z2 = (i2 & 128) != 0 ? false : z;
            this.name = str;
            this.defaultWidth = f;
            this.defaultHeight = f2;
            this.viewportWidth = f3;
            this.viewportHeight = f4;
            this.tintColor = j2;
            this.tintBlendMode = i3;
            this.autoMirror = z2;
            ArrayList arrayList = new ArrayList();
            this.nodes = arrayList;
            GroupParams groupParams = new GroupParams(null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 1023);
            this.root = groupParams;
            arrayList.add(groupParams);
        }

        /* JADX INFO: renamed from: addPath-oIyEayM$default, reason: not valid java name */
        public static void m502addPathoIyEayM$default(Builder builder, ArrayList arrayList, SolidColor solidColor) {
            if (builder.isConsumed) {
                InlineClassHelperKt.throwIllegalStateException("ImageVector.Builder is single use, create a new instance to create a new ImageVector");
            }
            ArrayList arrayList2 = builder.nodes;
            ((GroupParams) arrayList2.get(arrayList2.size() - 1)).children.add(new VectorPath("", arrayList, 0, solidColor, 1.0f, null, 1.0f, 1.0f, 0, 2, 1.0f, 0.0f, 1.0f, 0.0f));
        }

        public final ImageVector build() {
            if (this.isConsumed) {
                InlineClassHelperKt.throwIllegalStateException("ImageVector.Builder is single use, create a new instance to create a new ImageVector");
            }
            while (true) {
                ArrayList arrayList = this.nodes;
                if (arrayList.size() <= 1) {
                    GroupParams groupParams = this.root;
                    ImageVector imageVector = new ImageVector(this.name, this.defaultWidth, this.defaultHeight, this.viewportWidth, this.viewportHeight, new VectorGroup(groupParams.name, groupParams.rotate, groupParams.pivotX, groupParams.pivotY, groupParams.scaleX, groupParams.scaleY, groupParams.translationX, groupParams.translationY, groupParams.clipPathData, groupParams.children), this.tintColor, this.tintBlendMode, this.autoMirror);
                    this.isConsumed = true;
                    return imageVector;
                }
                if (this.isConsumed) {
                    InlineClassHelperKt.throwIllegalStateException("ImageVector.Builder is single use, create a new instance to create a new ImageVector");
                }
                GroupParams groupParams2 = (GroupParams) arrayList.remove(arrayList.size() - 1);
                ((GroupParams) arrayList.get(arrayList.size() - 1)).children.add(new VectorGroup(groupParams2.name, groupParams2.rotate, groupParams2.pivotX, groupParams2.pivotY, groupParams2.scaleX, groupParams2.scaleY, groupParams2.translationX, groupParams2.translationY, groupParams2.clipPathData, groupParams2.children));
            }
        }
    }

    public ImageVector(String str, float f, float f2, float f3, float f4, VectorGroup vectorGroup, long j, int i, boolean z) {
        int i2;
        synchronized (lock) {
            i2 = imageVectorCount;
            imageVectorCount = i2 + 1;
        }
        this.name = str;
        this.defaultWidth = f;
        this.defaultHeight = f2;
        this.viewportWidth = f3;
        this.viewportHeight = f4;
        this.root = vectorGroup;
        this.tintColor = j;
        this.tintBlendMode = i;
        this.autoMirror = z;
        this.genId = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageVector)) {
            return false;
        }
        ImageVector imageVector = (ImageVector) obj;
        return Intrinsics.areEqual(this.name, imageVector.name) && Dp.m704equalsimpl0(this.defaultWidth, imageVector.defaultWidth) && Dp.m704equalsimpl0(this.defaultHeight, imageVector.defaultHeight) && this.viewportWidth == imageVector.viewportWidth && this.viewportHeight == imageVector.viewportHeight && this.root.equals(imageVector.root) && Color.m435equalsimpl0(this.tintColor, imageVector.tintColor) && this.tintBlendMode == imageVector.tintBlendMode && this.autoMirror == imageVector.autoMirror;
    }

    public final int hashCode() {
        int iHashCode = (this.root.hashCode() + ImageAnalysis$$ExternalSyntheticLambda1.m(this.viewportHeight, ImageAnalysis$$ExternalSyntheticLambda1.m(this.viewportWidth, ImageAnalysis$$ExternalSyntheticLambda1.m(this.defaultHeight, ImageAnalysis$$ExternalSyntheticLambda1.m(this.defaultWidth, this.name.hashCode() * 31, 31), 31), 31), 31)) * 31;
        int i = Color.$r8$clinit;
        return ((ImageAnalysis$$ExternalSyntheticLambda1.m(iHashCode, 31, this.tintColor) + this.tintBlendMode) * 31) + (this.autoMirror ? 1231 : 1237);
    }
}
