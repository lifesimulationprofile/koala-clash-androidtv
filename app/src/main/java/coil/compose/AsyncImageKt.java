package coil.compose;

import android.content.Context;
import android.os.Trace;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.AndroidImageBitmap;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.ContentScale$Companion$Fit$1;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetModifier$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.InspectionModeKt;
import androidx.compose.ui.unit.Constraints;
import coil.Coil;
import coil.ImageLoaders;
import coil.RealImageLoader;
import coil.request.ImageRequest;
import coil.size.RealSizeResolver;
import coil.size.SizeResolver;
import java.util.List;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Handshake;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AsyncImageKt {
    public static final AsyncImagePainterKt$fakeTransitionTarget$1 fakeTransitionTarget = new AsyncImagePainterKt$fakeTransitionTarget$1();
    public static final EqualityDelegateKt$DefaultModelEqualityDelegate$1 DefaultModelEqualityDelegate = new EqualityDelegateKt$DefaultModelEqualityDelegate$1();

    /* JADX INFO: renamed from: coil.compose.AsyncImageKt$Content$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass2 implements MeasurePolicy {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public final /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            return Modifier.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, list, i);
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public final /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            return Modifier.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, list, i);
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        /* JADX INFO: renamed from: measure-3p2s80s */
        public final MeasureResult mo24measure3p2s80s(MeasureScope measureScope, List list, long j) {
            return measureScope.layout(Constraints.m685getMinWidthimpl(j), Constraints.m684getMinHeightimpl(j), EmptyMap.INSTANCE, new AsyncImagePainter$$ExternalSyntheticLambda0(3));
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public final /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            return Modifier.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, list, i);
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public final /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i) {
            return Modifier.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, list, i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0139  */
    /* JADX WARN: Code duplicated, block: B:104:0x014b  */
    /* JADX WARN: Code duplicated, block: B:107:0x016a  */
    /* JADX WARN: Code duplicated, block: B:109:0x018b  */
    /* JADX WARN: Code duplicated, block: B:114:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:95:0x011c  */
    /* JADX WARN: Code duplicated, block: B:97:0x012a  */
    /* JADX WARN: Code duplicated, block: B:98:0x012d  */
    /* JADX INFO: renamed from: AsyncImage-76YX9Dk, reason: not valid java name */
    public static final void m777AsyncImage76YX9Dk(AsyncImageState asyncImageState, Modifier modifier, Function1 function1, Function1 function2, Alignment alignment, ContentScale contentScale, GapComposer gapComposer, int i, int i2) {
        int i3;
        Alignment alignment2;
        int i4;
        Object objRememberedValue;
        SizeResolver sizeResolver;
        Context context;
        boolean zChanged;
        Object objRememberedValue2;
        boolean z;
        ImageRequest imageRequest;
        ImageRequest imageRequest2;
        boolean zChanged2;
        Object objRememberedValue3;
        gapComposer.startRestartGroup(-421592773);
        if ((i & 14) == 0) {
            i3 = (gapComposer.changed(asyncImageState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 112) == 0) {
            i3 |= gapComposer.changed((Object) null) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i3 |= gapComposer.changed(modifier) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i3 |= gapComposer.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i & 57344) == 0) {
            i3 |= gapComposer.changedInstance(function2) ? 16384 : 8192;
        }
        if ((i & 458752) == 0) {
            alignment2 = alignment;
            i3 |= gapComposer.changed(alignment2) ? 131072 : 65536;
        } else {
            alignment2 = alignment;
        }
        if ((i & 3670016) == 0) {
            i3 |= gapComposer.changed(contentScale) ? 1048576 : 524288;
        }
        if ((i & 29360128) == 0) {
            i3 |= gapComposer.changed(1.0f) ? 8388608 : 4194304;
        }
        if ((234881024 & i) == 0) {
            i3 |= gapComposer.changed((Object) null) ? 67108864 : 33554432;
        }
        if ((1879048192 & i) == 0) {
            i3 |= gapComposer.changed(1) ? 536870912 : 268435456;
        }
        if ((i2 & 14) == 0) {
            i4 = i2 | (gapComposer.changed(true) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i3 & 1533916891) == 306783378 && (i4 & 11) == 2 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            Object obj = asyncImageState.model;
            RealSizeResolver realSizeResolver = UtilsKt.OriginalSizeResolver;
            gapComposer.startReplaceableGroup(1677680258);
            boolean z2 = obj instanceof ImageRequest;
            Object obj2 = Composer$Companion.Empty;
            if (z2) {
                imageRequest = (ImageRequest) obj;
                if (imageRequest.defined.sizeResolver != null) {
                    gapComposer.end(false);
                } else {
                    gapComposer.startReplaceableGroup(408306591);
                    if (Intrinsics.areEqual(contentScale, ContentScale.Companion.None)) {
                        sizeResolver = UtilsKt.OriginalSizeResolver;
                    } else {
                        gapComposer.startReplaceableGroup(408309406);
                        objRememberedValue = gapComposer.rememberedValue();
                        if (objRememberedValue == obj2) {
                            objRememberedValue = new ConstraintsSizeResolver();
                            gapComposer.updateRememberedValue(objRememberedValue);
                        }
                        sizeResolver = (ConstraintsSizeResolver) objRememberedValue;
                        gapComposer.end(false);
                    }
                    gapComposer.end(false);
                    if (z2) {
                        gapComposer.startReplaceableGroup(-227230258);
                        imageRequest2 = (ImageRequest) obj;
                        gapComposer.startReplaceableGroup(408312509);
                        zChanged2 = gapComposer.changed(imageRequest2) | gapComposer.changed(sizeResolver);
                        objRememberedValue3 = gapComposer.rememberedValue();
                        if (zChanged2 || objRememberedValue3 == obj2) {
                            ImageRequest.Builder builderNewBuilder$default = ImageRequest.newBuilder$default(imageRequest2);
                            builderNewBuilder$default.sizeResolver = sizeResolver;
                            builderNewBuilder$default.resolvedLifecycle = null;
                            builderNewBuilder$default.resolvedSizeResolver = null;
                            builderNewBuilder$default.resolvedScale = 0;
                            objRememberedValue3 = builderNewBuilder$default.build();
                            gapComposer.updateRememberedValue(objRememberedValue3);
                        }
                        imageRequest = (ImageRequest) objRememberedValue3;
                        gapComposer.end(false);
                        gapComposer.end(false);
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceableGroup(-227066702);
                        context = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
                        gapComposer.startReplaceableGroup(408319118);
                        zChanged = gapComposer.changed(context) | gapComposer.changed(obj) | gapComposer.changed(sizeResolver);
                        objRememberedValue2 = gapComposer.rememberedValue();
                        if (!zChanged || objRememberedValue2 == obj2) {
                            ImageRequest.Builder builder = new ImageRequest.Builder(context);
                            builder.data = obj;
                            builder.sizeResolver = sizeResolver;
                            builder.resolvedLifecycle = null;
                            builder.resolvedSizeResolver = null;
                            z = false;
                            builder.resolvedScale = 0;
                            objRememberedValue2 = builder.build();
                            gapComposer.updateRememberedValue(objRememberedValue2);
                        } else {
                            z = false;
                        }
                        imageRequest = (ImageRequest) objRememberedValue2;
                        gapComposer.end(z);
                        gapComposer.end(z);
                        gapComposer.end(z);
                    }
                }
            } else {
                gapComposer.startReplaceableGroup(408306591);
                if (Intrinsics.areEqual(contentScale, ContentScale.Companion.None)) {
                    sizeResolver = UtilsKt.OriginalSizeResolver;
                } else {
                    gapComposer.startReplaceableGroup(408309406);
                    objRememberedValue = gapComposer.rememberedValue();
                    if (objRememberedValue == obj2) {
                        objRememberedValue = new ConstraintsSizeResolver();
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    sizeResolver = (ConstraintsSizeResolver) objRememberedValue;
                    gapComposer.end(false);
                }
                gapComposer.end(false);
                if (z2) {
                    gapComposer.startReplaceableGroup(-227230258);
                    imageRequest2 = (ImageRequest) obj;
                    gapComposer.startReplaceableGroup(408312509);
                    zChanged2 = gapComposer.changed(imageRequest2) | gapComposer.changed(sizeResolver);
                    objRememberedValue3 = gapComposer.rememberedValue();
                    if (zChanged2) {
                        ImageRequest.Builder builderNewBuilder$default2 = ImageRequest.newBuilder$default(imageRequest2);
                        builderNewBuilder$default2.sizeResolver = sizeResolver;
                        builderNewBuilder$default2.resolvedLifecycle = null;
                        builderNewBuilder$default2.resolvedSizeResolver = null;
                        builderNewBuilder$default2.resolvedScale = 0;
                        objRememberedValue3 = builderNewBuilder$default2.build();
                        gapComposer.updateRememberedValue(objRememberedValue3);
                    } else {
                        ImageRequest.Builder builderNewBuilder$default3 = ImageRequest.newBuilder$default(imageRequest2);
                        builderNewBuilder$default3.sizeResolver = sizeResolver;
                        builderNewBuilder$default3.resolvedLifecycle = null;
                        builderNewBuilder$default3.resolvedSizeResolver = null;
                        builderNewBuilder$default3.resolvedScale = 0;
                        objRememberedValue3 = builderNewBuilder$default3.build();
                        gapComposer.updateRememberedValue(objRememberedValue3);
                    }
                    imageRequest = (ImageRequest) objRememberedValue3;
                    gapComposer.end(false);
                    gapComposer.end(false);
                    gapComposer.end(false);
                } else {
                    gapComposer.startReplaceableGroup(-227066702);
                    context = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
                    gapComposer.startReplaceableGroup(408319118);
                    zChanged = gapComposer.changed(context) | gapComposer.changed(obj) | gapComposer.changed(sizeResolver);
                    objRememberedValue2 = gapComposer.rememberedValue();
                    if (zChanged) {
                        ImageRequest.Builder builder2 = new ImageRequest.Builder(context);
                        builder2.data = obj;
                        builder2.sizeResolver = sizeResolver;
                        builder2.resolvedLifecycle = null;
                        builder2.resolvedSizeResolver = null;
                        z = false;
                        builder2.resolvedScale = 0;
                        objRememberedValue2 = builder2.build();
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    } else {
                        ImageRequest.Builder builder3 = new ImageRequest.Builder(context);
                        builder3.data = obj;
                        builder3.sizeResolver = sizeResolver;
                        builder3.resolvedLifecycle = null;
                        builder3.resolvedSizeResolver = null;
                        z = false;
                        builder3.resolvedScale = 0;
                        objRememberedValue2 = builder3.build();
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    imageRequest = (ImageRequest) objRememberedValue2;
                    gapComposer.end(z);
                    gapComposer.end(z);
                    gapComposer.end(z);
                }
            }
            RealImageLoader realImageLoader = asyncImageState.imageLoader;
            int i5 = i3 >> 6;
            int i6 = i5 & 57344;
            gapComposer.startReplaceableGroup(1645646697);
            gapComposer.startReplaceableGroup(952940650);
            Trace.beginSection("rememberAsyncImagePainter");
            try {
                ImageRequest imageRequestRequestOf = UtilsKt.requestOf(imageRequest, gapComposer);
                validateRequest(imageRequestRequestOf);
                gapComposer.startReplaceableGroup(1094691773);
                Object objRememberedValue4 = gapComposer.rememberedValue();
                if (objRememberedValue4 == obj2) {
                    objRememberedValue4 = new AsyncImagePainter(imageRequestRequestOf, realImageLoader);
                    gapComposer.updateRememberedValue(objRememberedValue4);
                }
                AsyncImagePainter asyncImagePainter = (AsyncImagePainter) objRememberedValue4;
                gapComposer.end(false);
                asyncImagePainter.transform = function1;
                asyncImagePainter.onState = function2;
                asyncImagePainter.contentScale = contentScale;
                asyncImagePainter.filterQuality = 1;
                asyncImagePainter.isPreview = ((Boolean) gapComposer.consume(InspectionModeKt.LocalInspectionMode)).booleanValue();
                asyncImagePainter.imageLoader$delegate.setValue(realImageLoader);
                asyncImagePainter.request$delegate.setValue(imageRequestRequestOf);
                asyncImagePainter.onRemembered();
                gapComposer.end(false);
                Trace.endSection();
                gapComposer.end(false);
                SizeResolver sizeResolver2 = imageRequest.sizeResolver;
                Content(sizeResolver2 instanceof ConstraintsSizeResolver ? modifier.then((Modifier) sizeResolver2) : modifier, asyncImagePainter, alignment2, contentScale, gapComposer, ((i3 << 3) & 896) | (i5 & 7168) | i6 | (i5 & 458752) | (i5 & 3670016) | ((i4 << 21) & 29360128));
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AsyncImageKt$$ExternalSyntheticLambda0(asyncImageState, modifier, function1, function2, alignment, contentScale, i, i2);
        }
    }

    /* JADX INFO: renamed from: AsyncImage-gl8XCv8, reason: not valid java name */
    public static final void m778AsyncImagegl8XCv8(Object obj, Modifier modifier, Function1 function1, ContentScale$Companion$Fit$1 contentScale$Companion$Fit$1, GapComposer gapComposer, int i, int i2) {
        gapComposer.startReplaceableGroup(1451072229);
        AsyncImagePainter$$ExternalSyntheticLambda0 asyncImagePainter$$ExternalSyntheticLambda0 = AsyncImagePainter.DefaultTransform;
        Function1 function2 = (i2 & 16) != 0 ? null : function1;
        BiasAlignment biasAlignment = Alignment.Companion.Center;
        ContentScale$Companion$Fit$1 contentScale$Companion$Fit$2 = (i2 & 64) != 0 ? ContentScale.Companion.Fit : contentScale$Companion$Fit$1;
        EqualityDelegateKt$DefaultModelEqualityDelegate$1 equalityDelegateKt$DefaultModelEqualityDelegate$1 = DefaultModelEqualityDelegate;
        RealImageLoader realImageLoaderCreate = (RealImageLoader) gapComposer.consume(LocalImageLoaderKt.LocalImageLoader);
        if (realImageLoaderCreate == null) {
            Context context = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
            RealImageLoader realImageLoader = Coil.imageLoader;
            if (realImageLoader == null) {
                synchronized (Coil.INSTANCE) {
                    realImageLoader = Coil.imageLoader;
                    if (realImageLoader != null) {
                        realImageLoaderCreate = realImageLoader;
                    } else {
                        context.getApplicationContext();
                        realImageLoaderCreate = ImageLoaders.create(context);
                        Coil.imageLoader = realImageLoaderCreate;
                    }
                }
            } else {
                realImageLoaderCreate = realImageLoader;
            }
        }
        int i3 = i << 3;
        int i4 = (i & 112) | 520 | (i3 & 7168) | (i3 & 57344) | (i3 & 458752) | (i3 & 3670016) | (i3 & 29360128) | (i3 & 234881024) | (i3 & 1879048192);
        gapComposer.startReplaceableGroup(2032051394);
        AsyncImageState asyncImageState = new AsyncImageState(obj, equalityDelegateKt$DefaultModelEqualityDelegate$1, realImageLoaderCreate);
        int i5 = i4 >> 3;
        m777AsyncImage76YX9Dk(asyncImageState, modifier, asyncImagePainter$$ExternalSyntheticLambda0, function2, biasAlignment, contentScale$Companion$Fit$2, gapComposer, (i4 & 112) | (i5 & 896) | (i5 & 7168) | (i5 & 57344) | (i5 & 458752) | (i5 & 3670016) | (i5 & 29360128) | (i5 & 234881024) | ((((i >> 27) & 14) << 27) & 1879048192), 0);
        gapComposer.end(false);
        gapComposer.end(false);
    }

    public static final void Content(Modifier modifier, AsyncImagePainter asyncImagePainter, Alignment alignment, ContentScale contentScale, GapComposer gapComposer, int i) {
        int i2;
        gapComposer.startRestartGroup(777774312);
        if ((i & 14) == 0) {
            i2 = (gapComposer.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= gapComposer.changed(asyncImagePainter) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= gapComposer.changed((Object) null) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= gapComposer.changed(alignment) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= gapComposer.changed(contentScale) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= gapComposer.changed(1.0f) ? 131072 : 65536;
        }
        if ((3670016 & i) == 0) {
            i2 |= gapComposer.changed((Object) null) ? 1048576 : 524288;
        }
        if ((29360128 & i) == 0) {
            i2 |= gapComposer.changed(true) ? 8388608 : 4194304;
        }
        if ((i2 & 23967451) == 4793490 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            RealSizeResolver realSizeResolver = UtilsKt.OriginalSizeResolver;
            Modifier modifierThen = ClipKt.clipToBounds(modifier).then(new ContentPainterElement(asyncImagePainter, alignment, contentScale));
            gapComposer.startReplaceableGroup(544976794);
            long j = gapComposer.compositeKeyHashCode;
            int i3 = (int) ((j >>> 32) ^ j);
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifierThen);
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer.startReplaceableGroup(1405779621);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(new Handshake.AnonymousClass2(21, layoutNode$Companion$Constructor$1));
            } else {
                gapComposer.useNode();
            }
            Stack.m295setimpl(gapComposer, AnonymousClass2.INSTANCE, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m295setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
            if (gapComposer.inserting || !Intrinsics.areEqual(gapComposer.rememberedValue(), Integer.valueOf(i3))) {
                gapComposer.updateRememberedValue(Integer.valueOf(i3));
                gapComposer.apply(Integer.valueOf(i3), composeUiNode$Companion$SetModifier$1);
            }
            gapComposer.end(true);
            gapComposer.end(false);
            gapComposer.end(false);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AsyncImageKt$$ExternalSyntheticLambda1(modifier, asyncImagePainter, alignment, contentScale, i, 0);
        }
    }

    public static void unsupportedData$default(String str) {
        throw new IllegalArgumentException("Unsupported type: " + str + ". " + ImageAnalysis$$ExternalSyntheticLambda1.m$1("If you wish to display this ", str, ", use androidx.compose.foundation.Image."));
    }

    public static final void validateRequest(ImageRequest imageRequest) {
        Object obj = imageRequest.data;
        if (obj instanceof ImageRequest.Builder) {
            throw new IllegalArgumentException("Unsupported type: ImageRequest.Builder. Did you forget to call ImageRequest.Builder.build()?");
        }
        if (obj instanceof AndroidImageBitmap) {
            unsupportedData$default("ImageBitmap");
            throw null;
        }
        if (obj instanceof ImageVector) {
            unsupportedData$default("ImageVector");
            throw null;
        }
        if (obj instanceof Painter) {
            unsupportedData$default("Painter");
            throw null;
        }
        if (imageRequest.target != null) {
            throw new IllegalArgumentException("request.target must be null.");
        }
    }
}
