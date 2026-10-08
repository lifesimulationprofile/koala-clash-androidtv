package com.google.android.material.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import coil.network.EmptyNetworkObserver;
import com.google.android.material.R$styleable;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ShapeAppearanceModel {
    public CornerTreatment topLeftCorner = new RoundedCornerTreatment();
    public CornerTreatment topRightCorner = new RoundedCornerTreatment();
    public CornerTreatment bottomRightCorner = new RoundedCornerTreatment();
    public CornerTreatment bottomLeftCorner = new RoundedCornerTreatment();
    public CornerSize topLeftCornerSize = new AbsoluteCornerSize(0.0f);
    public CornerSize topRightCornerSize = new AbsoluteCornerSize(0.0f);
    public CornerSize bottomRightCornerSize = new AbsoluteCornerSize(0.0f);
    public CornerSize bottomLeftCornerSize = new AbsoluteCornerSize(0.0f);
    public EmptyNetworkObserver topEdge = new EmptyNetworkObserver();
    public EmptyNetworkObserver rightEdge = new EmptyNetworkObserver();
    public EmptyNetworkObserver bottomEdge = new EmptyNetworkObserver();
    public EmptyNetworkObserver leftEdge = new EmptyNetworkObserver();

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Builder {
        public CornerTreatment topLeftCorner = new RoundedCornerTreatment();
        public CornerTreatment topRightCorner = new RoundedCornerTreatment();
        public CornerTreatment bottomRightCorner = new RoundedCornerTreatment();
        public CornerTreatment bottomLeftCorner = new RoundedCornerTreatment();
        public CornerSize topLeftCornerSize = new AbsoluteCornerSize(0.0f);
        public CornerSize topRightCornerSize = new AbsoluteCornerSize(0.0f);
        public CornerSize bottomRightCornerSize = new AbsoluteCornerSize(0.0f);
        public CornerSize bottomLeftCornerSize = new AbsoluteCornerSize(0.0f);
        public EmptyNetworkObserver topEdge = new EmptyNetworkObserver();
        public EmptyNetworkObserver rightEdge = new EmptyNetworkObserver();
        public EmptyNetworkObserver bottomEdge = new EmptyNetworkObserver();
        public EmptyNetworkObserver leftEdge = new EmptyNetworkObserver();

        public final ShapeAppearanceModel build() {
            ShapeAppearanceModel shapeAppearanceModel = new ShapeAppearanceModel();
            shapeAppearanceModel.topLeftCorner = this.topLeftCorner;
            shapeAppearanceModel.topRightCorner = this.topRightCorner;
            shapeAppearanceModel.bottomRightCorner = this.bottomRightCorner;
            shapeAppearanceModel.bottomLeftCorner = this.bottomLeftCorner;
            shapeAppearanceModel.topLeftCornerSize = this.topLeftCornerSize;
            shapeAppearanceModel.topRightCornerSize = this.topRightCornerSize;
            shapeAppearanceModel.bottomRightCornerSize = this.bottomRightCornerSize;
            shapeAppearanceModel.bottomLeftCornerSize = this.bottomLeftCornerSize;
            shapeAppearanceModel.topEdge = this.topEdge;
            shapeAppearanceModel.rightEdge = this.rightEdge;
            shapeAppearanceModel.bottomEdge = this.bottomEdge;
            shapeAppearanceModel.leftEdge = this.leftEdge;
            return shapeAppearanceModel;
        }
    }

    public static Builder builder(Context context, AttributeSet attributeSet, int i, int i2) {
        AbsoluteCornerSize absoluteCornerSize = new AbsoluteCornerSize(0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MaterialShape, i, i2);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        return builder(context, resourceId, resourceId2, absoluteCornerSize);
    }

    public static CornerSize getCornerSize(TypedArray typedArray, int i, CornerSize cornerSize) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i);
        if (typedValuePeekValue != null) {
            int i2 = typedValuePeekValue.type;
            if (i2 == 5) {
                return new AbsoluteCornerSize(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics()));
            }
            if (i2 == 6) {
                return new RelativeCornerSize(typedValuePeekValue.getFraction(1.0f, 1.0f));
            }
        }
        return cornerSize;
    }

    public final boolean isRoundRect(RectF rectF) {
        boolean z = this.leftEdge.getClass().equals(EmptyNetworkObserver.class) && this.rightEdge.getClass().equals(EmptyNetworkObserver.class) && this.topEdge.getClass().equals(EmptyNetworkObserver.class) && this.bottomEdge.getClass().equals(EmptyNetworkObserver.class);
        float cornerSize = this.topLeftCornerSize.getCornerSize(rectF);
        return z && ((this.topRightCornerSize.getCornerSize(rectF) > cornerSize ? 1 : (this.topRightCornerSize.getCornerSize(rectF) == cornerSize ? 0 : -1)) == 0 && (this.bottomLeftCornerSize.getCornerSize(rectF) > cornerSize ? 1 : (this.bottomLeftCornerSize.getCornerSize(rectF) == cornerSize ? 0 : -1)) == 0 && (this.bottomRightCornerSize.getCornerSize(rectF) > cornerSize ? 1 : (this.bottomRightCornerSize.getCornerSize(rectF) == cornerSize ? 0 : -1)) == 0) && ((this.topRightCorner instanceof RoundedCornerTreatment) && (this.topLeftCorner instanceof RoundedCornerTreatment) && (this.bottomRightCorner instanceof RoundedCornerTreatment) && (this.bottomLeftCorner instanceof RoundedCornerTreatment));
    }

    public final Builder toBuilder() {
        Builder builder = new Builder();
        builder.topLeftCorner = this.topLeftCorner;
        builder.topRightCorner = this.topRightCorner;
        builder.bottomRightCorner = this.bottomRightCorner;
        builder.bottomLeftCorner = this.bottomLeftCorner;
        builder.topLeftCornerSize = this.topLeftCornerSize;
        builder.topRightCornerSize = this.topRightCornerSize;
        builder.bottomRightCornerSize = this.bottomRightCornerSize;
        builder.bottomLeftCornerSize = this.bottomLeftCornerSize;
        builder.topEdge = this.topEdge;
        builder.rightEdge = this.rightEdge;
        builder.bottomEdge = this.bottomEdge;
        builder.leftEdge = this.leftEdge;
        return builder;
    }

    public static Builder builder(Context context, int i, int i2, AbsoluteCornerSize absoluteCornerSize) {
        if (i2 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i);
            i = i2;
            context = contextThemeWrapper;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, R$styleable.ShapeAppearance);
        try {
            int i3 = typedArrayObtainStyledAttributes.getInt(0, 0);
            int i4 = typedArrayObtainStyledAttributes.getInt(3, i3);
            int i5 = typedArrayObtainStyledAttributes.getInt(4, i3);
            int i6 = typedArrayObtainStyledAttributes.getInt(2, i3);
            int i7 = typedArrayObtainStyledAttributes.getInt(1, i3);
            CornerSize cornerSize = getCornerSize(typedArrayObtainStyledAttributes, 5, absoluteCornerSize);
            CornerSize cornerSize2 = getCornerSize(typedArrayObtainStyledAttributes, 8, cornerSize);
            CornerSize cornerSize3 = getCornerSize(typedArrayObtainStyledAttributes, 9, cornerSize);
            CornerSize cornerSize4 = getCornerSize(typedArrayObtainStyledAttributes, 7, cornerSize);
            CornerSize cornerSize5 = getCornerSize(typedArrayObtainStyledAttributes, 6, cornerSize);
            Builder builder = new Builder();
            builder.topLeftCorner = MaterialShapeUtils.createCornerTreatment(i4);
            builder.topLeftCornerSize = cornerSize2;
            builder.topRightCorner = MaterialShapeUtils.createCornerTreatment(i5);
            builder.topRightCornerSize = cornerSize3;
            builder.bottomRightCorner = MaterialShapeUtils.createCornerTreatment(i6);
            builder.bottomRightCornerSize = cornerSize4;
            builder.bottomLeftCorner = MaterialShapeUtils.createCornerTreatment(i7);
            builder.bottomLeftCornerSize = cornerSize5;
            return builder;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
