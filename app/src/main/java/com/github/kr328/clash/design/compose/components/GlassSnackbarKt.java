package com.github.kr328.clash.design.compose.components;

import androidx.activity.ImmLeaksCleaner$$ExternalSyntheticLambda0;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.camera.core.impl.Quirks;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda3;
import androidx.compose.material.icons.rounded.CheckCircleKt;
import androidx.compose.material.icons.rounded.ErrorOutlineKt;
import androidx.compose.material.icons.rounded.InfoKt;
import androidx.compose.material.icons.rounded.WarningAmberKt;
import androidx.compose.material3.BottomSheetKt$BottomSheet$settleToDismiss$1$1$2;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.IconButtonDefaults;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.SnackbarHostKt$$ExternalSyntheticLambda6;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.DynamicProvidableCompositionLocal;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetModifier$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayout$1;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import coil.ImageLoader$Builder$$ExternalSyntheticLambda2;
import coil.network.HttpException;
import com.github.kr328.clash.FilesActivity$$ExternalSyntheticLambda16;
import com.github.kr328.clash.compose.util.TvGlassTabRowKt$$ExternalSyntheticLambda1;
import com.github.kr328.clash.design.compose.theme.AppColors;
import com.github.kr328.clash.design.compose.theme.AppColorsKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class GlassSnackbarKt {
    public static final DynamicProvidableCompositionLocal LocalGlassSnackbarHost = new DynamicProvidableCompositionLocal(new ImageLoader$Builder$$ExternalSyntheticLambda2(27));

    public static final void GlassSnackbar(SnackbarHostState.SnackbarDataImpl snackbarDataImpl, Modifier modifier, GapComposer gapComposer, int i) {
        int i2;
        int i3;
        long j;
        long jColor;
        ImageVector imageVectorBuild;
        boolean z;
        SnackbarHostState.SnackbarDataImpl snackbarDataImpl2;
        Modifier modifier2;
        long jColor2;
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(-1071188863);
        if ((i & 6) == 0) {
            i2 = i | (gapComposer2.changed(snackbarDataImpl) ? 4 : 2);
        } else {
            i2 = i;
        }
        int i4 = i2 | 48;
        if ((i4 & 19) == 18 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
            modifier2 = modifier;
            snackbarDataImpl2 = snackbarDataImpl;
        } else {
            AppColors appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            GlassSnackbarVisuals glassSnackbarVisuals = snackbarDataImpl.visuals;
            GlassSnackbarVisuals glassSnackbarVisuals2 = glassSnackbarVisuals instanceof GlassSnackbarVisuals ? glassSnackbarVisuals : null;
            if (glassSnackbarVisuals2 == null || (i3 = glassSnackbarVisuals2.type) == 0) {
                i3 = 4;
            }
            int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i3);
            if (iOrdinal != 0) {
                if (iOrdinal == 1) {
                    long jColor3 = BrushKt.Color(4293874512L);
                    jColor2 = BrushKt.Color(Color.m440getRedimpl(jColor3), Color.m439getGreenimpl(jColor3), Color.m437getBlueimpl(jColor3), 0.5f, Color.m438getColorSpaceimpl(jColor3));
                    jColor = BrushKt.Color(4293874512L);
                    ImageVector imageVectorBuild2 = ErrorOutlineKt._errorOutline;
                    if (imageVectorBuild2 == null) {
                        ImageVector.Builder builder = new ImageVector.Builder("Rounded.ErrorOutline", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                        int i5 = VectorKt.$r8$clinit;
                        SolidColor solidColor = new SolidColor(Color.Black);
                        Quirks quirks = new Quirks();
                        quirks.moveTo(12.0f, 7.0f);
                        quirks.curveToRelative(0.55f, 0.0f, 1.0f, 0.45f, 1.0f, 1.0f);
                        quirks.verticalLineToRelative(4.0f);
                        quirks.curveToRelative(0.0f, 0.55f, -0.45f, 1.0f, -1.0f, 1.0f);
                        quirks.reflectiveCurveToRelative(-1.0f, -0.45f, -1.0f, -1.0f);
                        quirks.lineTo(11.0f, 8.0f);
                        quirks.curveToRelative(0.0f, -0.55f, 0.45f, -1.0f, 1.0f, -1.0f);
                        quirks.close();
                        quirks.moveTo(11.99f, 2.0f);
                        quirks.curveTo(6.47f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f);
                        quirks.reflectiveCurveToRelative(4.47f, 10.0f, 9.99f, 10.0f);
                        quirks.curveTo(17.52f, 22.0f, 22.0f, 17.52f, 22.0f, 12.0f);
                        quirks.reflectiveCurveTo(17.52f, 2.0f, 11.99f, 2.0f);
                        quirks.close();
                        quirks.moveTo(12.0f, 20.0f);
                        quirks.curveToRelative(-4.42f, 0.0f, -8.0f, -3.58f, -8.0f, -8.0f);
                        quirks.reflectiveCurveToRelative(3.58f, -8.0f, 8.0f, -8.0f);
                        quirks.reflectiveCurveToRelative(8.0f, 3.58f, 8.0f, 8.0f);
                        quirks.reflectiveCurveToRelative(-3.58f, 8.0f, -8.0f, 8.0f);
                        quirks.close();
                        quirks.moveTo(13.0f, 17.0f);
                        quirks.horizontalLineToRelative(-2.0f);
                        quirks.verticalLineToRelative(-2.0f);
                        quirks.horizontalLineToRelative(2.0f);
                        quirks.verticalLineToRelative(2.0f);
                        quirks.close();
                        ImageVector.Builder.m502addPathoIyEayM$default(builder, quirks.mQuirks, solidColor);
                        imageVectorBuild2 = builder.build();
                        ErrorOutlineKt._errorOutline = imageVectorBuild2;
                    }
                    imageVectorBuild = imageVectorBuild2;
                    Unit unit = Unit.INSTANCE;
                } else if (iOrdinal == 2) {
                    long jColor4 = BrushKt.Color(4294945600L);
                    jColor2 = BrushKt.Color(Color.m440getRedimpl(jColor4), Color.m439getGreenimpl(jColor4), Color.m437getBlueimpl(jColor4), 0.5f, Color.m438getColorSpaceimpl(jColor4));
                    jColor = BrushKt.Color(4294945600L);
                    ImageVector imageVectorBuild3 = WarningAmberKt._warningAmber;
                    if (imageVectorBuild3 == null) {
                        ImageVector.Builder builder2 = new ImageVector.Builder("Rounded.WarningAmber", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                        int i6 = VectorKt.$r8$clinit;
                        SolidColor solidColor2 = new SolidColor(Color.Black);
                        Quirks quirks2 = new Quirks();
                        quirks2.moveTo(12.0f, 5.99f);
                        quirks2.lineTo(19.53f, 19.0f);
                        quirks2.lineTo(4.47f, 19.0f);
                        quirks2.lineTo(12.0f, 5.99f);
                        quirks2.moveTo(2.74f, 18.0f);
                        quirks2.curveToRelative(-0.77f, 1.33f, 0.19f, 3.0f, 1.73f, 3.0f);
                        quirks2.horizontalLineToRelative(15.06f);
                        quirks2.curveToRelative(1.54f, 0.0f, 2.5f, -1.67f, 1.73f, -3.0f);
                        quirks2.lineTo(13.73f, 4.99f);
                        quirks2.curveToRelative(-0.77f, -1.33f, -2.69f, -1.33f, -3.46f, 0.0f);
                        quirks2.lineTo(2.74f, 18.0f);
                        quirks2.close();
                        quirks2.moveTo(11.0f, 11.0f);
                        quirks2.verticalLineToRelative(2.0f);
                        quirks2.curveToRelative(0.0f, 0.55f, 0.45f, 1.0f, 1.0f, 1.0f);
                        quirks2.reflectiveCurveToRelative(1.0f, -0.45f, 1.0f, -1.0f);
                        quirks2.verticalLineToRelative(-2.0f);
                        quirks2.curveToRelative(0.0f, -0.55f, -0.45f, -1.0f, -1.0f, -1.0f);
                        quirks2.reflectiveCurveToRelative(-1.0f, 0.45f, -1.0f, 1.0f);
                        quirks2.close();
                        quirks2.moveTo(11.0f, 16.0f);
                        quirks2.horizontalLineToRelative(2.0f);
                        quirks2.verticalLineToRelative(2.0f);
                        quirks2.horizontalLineToRelative(-2.0f);
                        quirks2.close();
                        ImageVector.Builder.m502addPathoIyEayM$default(builder2, quirks2.mQuirks, solidColor2);
                        imageVectorBuild3 = builder2.build();
                        WarningAmberKt._warningAmber = imageVectorBuild3;
                    }
                    imageVectorBuild = imageVectorBuild3;
                    Unit unit2 = Unit.INSTANCE;
                } else {
                    if (iOrdinal != 3) {
                        throw new HttpException();
                    }
                    j = appColors.cardBorder;
                    jColor = appColors.textSecondary;
                    imageVectorBuild = InfoKt._info;
                    if (imageVectorBuild == null) {
                        ImageVector.Builder builder3 = new ImageVector.Builder("Rounded.Info", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                        int i7 = VectorKt.$r8$clinit;
                        SolidColor solidColor3 = new SolidColor(Color.Black);
                        Quirks quirks3 = new Quirks();
                        quirks3.moveTo(12.0f, 2.0f);
                        quirks3.curveTo(6.48f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f);
                        quirks3.reflectiveCurveToRelative(4.48f, 10.0f, 10.0f, 10.0f);
                        quirks3.reflectiveCurveToRelative(10.0f, -4.48f, 10.0f, -10.0f);
                        quirks3.reflectiveCurveTo(17.52f, 2.0f, 12.0f, 2.0f);
                        quirks3.close();
                        quirks3.moveTo(12.0f, 17.0f);
                        quirks3.curveToRelative(-0.55f, 0.0f, -1.0f, -0.45f, -1.0f, -1.0f);
                        quirks3.verticalLineToRelative(-4.0f);
                        quirks3.curveToRelative(0.0f, -0.55f, 0.45f, -1.0f, 1.0f, -1.0f);
                        quirks3.reflectiveCurveToRelative(1.0f, 0.45f, 1.0f, 1.0f);
                        quirks3.verticalLineToRelative(4.0f);
                        quirks3.curveToRelative(0.0f, 0.55f, -0.45f, 1.0f, -1.0f, 1.0f);
                        quirks3.close();
                        quirks3.moveTo(13.0f, 9.0f);
                        quirks3.horizontalLineToRelative(-2.0f);
                        quirks3.lineTo(11.0f, 7.0f);
                        quirks3.horizontalLineToRelative(2.0f);
                        quirks3.verticalLineToRelative(2.0f);
                        quirks3.close();
                        ImageVector.Builder.m502addPathoIyEayM$default(builder3, quirks3.mQuirks, solidColor3);
                        imageVectorBuild = builder3.build();
                        InfoKt._info = imageVectorBuild;
                    }
                    Unit unit3 = Unit.INSTANCE;
                }
                j = jColor2;
            } else {
                j = appColors.accentBorder;
                jColor = appColors.buttonActiveEnd;
                ImageVector imageVectorBuild4 = CheckCircleKt._checkCircle;
                if (imageVectorBuild4 == null) {
                    ImageVector.Builder builder4 = new ImageVector.Builder("Rounded.CheckCircle", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                    int i8 = VectorKt.$r8$clinit;
                    SolidColor solidColor4 = new SolidColor(Color.Black);
                    Quirks quirks4 = new Quirks();
                    quirks4.moveTo(12.0f, 2.0f);
                    quirks4.curveTo(6.48f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f);
                    quirks4.reflectiveCurveToRelative(4.48f, 10.0f, 10.0f, 10.0f);
                    quirks4.reflectiveCurveToRelative(10.0f, -4.48f, 10.0f, -10.0f);
                    quirks4.reflectiveCurveTo(17.52f, 2.0f, 12.0f, 2.0f);
                    quirks4.close();
                    quirks4.moveTo(9.29f, 16.29f);
                    quirks4.lineTo(5.7f, 12.7f);
                    quirks4.curveToRelative(-0.39f, -0.39f, -0.39f, -1.02f, 0.0f, -1.41f);
                    quirks4.curveToRelative(0.39f, -0.39f, 1.02f, -0.39f, 1.41f, 0.0f);
                    quirks4.lineTo(10.0f, 14.17f);
                    quirks4.lineToRelative(6.88f, -6.88f);
                    quirks4.curveToRelative(0.39f, -0.39f, 1.02f, -0.39f, 1.41f, 0.0f);
                    quirks4.curveToRelative(0.39f, 0.39f, 0.39f, 1.02f, 0.0f, 1.41f);
                    quirks4.lineToRelative(-7.59f, 7.59f);
                    quirks4.curveToRelative(-0.38f, 0.39f, -1.02f, 0.39f, -1.41f, 0.0f);
                    quirks4.close();
                    ImageVector.Builder.m502addPathoIyEayM$default(builder4, quirks4.mQuirks, solidColor4);
                    imageVectorBuild4 = builder4.build();
                    CheckCircleKt._checkCircle = imageVectorBuild4;
                }
                imageVectorBuild = imageVectorBuild4;
                Unit unit4 = Unit.INSTANCE;
            }
            long j2 = jColor;
            float f = 14;
            RoundedCornerShape roundedCornerShapeM158RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(f);
            long j3 = appColors.cardBackground;
            long jM414compositeOverOWjLjI = BrushKt.m414compositeOverOWjLjI(BrushKt.Color(Color.m440getRedimpl(j3), Color.m439getGreenimpl(j3), Color.m437getBlueimpl(j3), 0.92f, Color.m438getColorSpaceimpl(j3)), appColors.appBackground);
            gapComposer2.startReplaceGroup(461536216);
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = ArcSplineKt.Animatable$default(0.85f);
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            Animatable animatable = (Animatable) objRememberedValue;
            Object objM = Density.CC.m(461537717, gapComposer2, false);
            if (objM == neverEqualPolicy) {
                objM = ArcSplineKt.Animatable$default(0.0f);
                gapComposer2.updateRememberedValue(objM);
            }
            Animatable animatable2 = (Animatable) objM;
            gapComposer2.end(false);
            Unit unit5 = Unit.INSTANCE;
            gapComposer2.startReplaceGroup(461539510);
            boolean zChangedInstance = gapComposer2.changedInstance(animatable);
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new BottomSheetKt$BottomSheet$settleToDismiss$1$1$2(animatable, null, 1);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            gapComposer2.end(false);
            Stack.LaunchedEffect(gapComposer2, unit5, (Function2) objRememberedValue2);
            gapComposer2.startReplaceGroup(461544233);
            boolean zChangedInstance2 = gapComposer2.changedInstance(animatable2);
            Object objRememberedValue3 = gapComposer2.rememberedValue();
            if (zChangedInstance2 || objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new BottomSheetKt$BottomSheet$settleToDismiss$1$1$2(animatable2, null, 2);
                gapComposer2.updateRememberedValue(objRememberedValue3);
            }
            gapComposer2.end(false);
            Stack.LaunchedEffect(gapComposer2, unit5, (Function2) objRememberedValue3);
            float f2 = 16;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(OffsetKt.m129paddingVpY3zN4(companion, f2, 8), 1.0f);
            float fFloatValue = ((Number) animatable.getValue()).floatValue();
            if (fFloatValue != 1.0f || fFloatValue != 1.0f) {
                modifierFillMaxWidth = BrushKt.m417graphicsLayer_6ThJ44$default(modifierFillMaxWidth, fFloatValue, fFloatValue, 0.0f, 0.0f, null, false, 524284);
            }
            Modifier modifierM129paddingVpY3zN4 = OffsetKt.m129paddingVpY3zN4(ImageKt.m48borderxT4_qwU(1, j, ImageKt.m47backgroundbw27NRU(ClipKt.clip(ClipKt.alpha(modifierFillMaxWidth, ((Number) animatable2.getValue()).floatValue()), roundedCornerShapeM158RoundedCornerShape0680j_4), jM414compositeOverOWjLjI, BrushKt.RectangleShape), roundedCornerShapeM158RoundedCornerShape0680j_4), f2, f);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            long j4 = gapComposer2.compositeKeyHashCode;
            int i9 = (int) (j4 ^ (j4 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierM129paddingVpY3zN4);
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer2.useNode();
            }
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$1 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m295setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, composeUiNode$Companion$SetModifier$2);
            Integer numValueOf = Integer.valueOf(i9);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m295setimpl(gapComposer2, numValueOf, composeUiNode$Companion$SetModifier$3);
            OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
            Stack.m294reconcileimpl(gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.m111spacedBy0680j_4(12), Alignment.Companion.CenterVertically, gapComposer2, 54);
            long j5 = gapComposer2.compositeKeyHashCode;
            int i10 = (int) (j5 ^ (j5 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer2, companion);
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer2.useNode();
            }
            Stack.m295setimpl(gapComposer2, rowMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
            ImageAnalysis$$ExternalSyntheticLambda1.m(i10, gapComposer2, composeUiNode$Companion$SetModifier$3, gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
            IconKt.m249Iconww6aTOc(imageVectorBuild, null, SizeKt.m140size3ABfNKs(companion, 22), j2, gapComposer2, 432, 0);
            String str = glassSnackbarVisuals.message;
            long j6 = appColors.textPrimary;
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
            TextStyle textStyle = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.bodyMedium;
            if (1.0f <= 0.0d) {
                InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
            }
            TextKt.m275TextNvy7gAk(str, new LayoutWeightElement(1.0f, false), j6, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, textStyle, gapComposer, 0, 0, 131064);
            gapComposer2 = gapComposer;
            gapComposer2.startReplaceGroup(-1074558372);
            if (glassSnackbarVisuals.withDismissAction) {
                gapComposer2.startReplaceGroup(-1074556022);
                boolean z2 = (i4 & 14) == 4;
                Object objRememberedValue4 = gapComposer2.rememberedValue();
                if (z2 || objRememberedValue4 == neverEqualPolicy) {
                    snackbarDataImpl2 = snackbarDataImpl;
                    objRememberedValue4 = new SnackbarHostKt$$ExternalSyntheticLambda6(snackbarDataImpl2, 1);
                    gapComposer2.updateRememberedValue(objRememberedValue4);
                } else {
                    snackbarDataImpl2 = snackbarDataImpl;
                }
                Function0 function0 = (Function0) objRememberedValue4;
                z = false;
                gapComposer2.end(false);
                modifier2 = companion;
                Modifier modifierM140size3ABfNKs = SizeKt.m140size3ABfNKs(modifier2, 24);
                int i11 = IconButtonDefaults.$r8$clinit;
                long j7 = appColors.textSecondary;
                long j8 = Color.Unspecified;
                ScrimKt.IconButton(function0, modifierM140size3ABfNKs, false, IconButtonDefaults.m247defaultIconButtonColors4WTKRHQ$material3(((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme, ((Color) gapComposer2.consume(ContentColorKt.LocalContentColor)).value).m246copyjRlVdoo(j8, j7, j8, BrushKt.Color(Color.m440getRedimpl(j7), Color.m439getGreenimpl(j7), Color.m437getBlueimpl(j7), 0.38f, Color.m438getColorSpaceimpl(j7))), null, ComposableSingletons$GlassSnackbarKt.f29lambda1, gapComposer, 1572912, 52);
                gapComposer2 = gapComposer;
            } else {
                z = false;
                snackbarDataImpl2 = snackbarDataImpl;
                modifier2 = companion;
            }
            gapComposer2.end(z);
            gapComposer2.end(true);
            gapComposer2.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new FilesActivity$$ExternalSyntheticLambda16(i, 7, snackbarDataImpl2, modifier2);
        }
    }

    public static final void GlassSnackbarHost(final SnackbarHostState snackbarHostState, final Modifier modifier, GapComposer gapComposer, final int i, final int i2) {
        int i3;
        int i4;
        gapComposer.startRestartGroup(1684637550);
        if ((i & 6) == 0) {
            i3 = (gapComposer.changed(snackbarHostState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i4 = i3 | 48;
        } else {
            i4 = i3 | (gapComposer.changed(modifier) ? 32 : 16);
        }
        if ((i4 & 19) == 18 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            if (i5 != 0) {
                modifier = Modifier.Companion.$$INSTANCE;
            }
            final float fMo92toPx0680j_4 = ((Density) gapComposer.consume(CompositionLocalsKt.LocalDensity)).mo92toPx0680j_4(100);
            ScrimKt.SnackbarHost(snackbarHostState, modifier, Thread_jvmKt.rememberComposableLambda(663774017, new Function3() { // from class: com.github.kr328.clash.design.compose.components.GlassSnackbarKt.GlassSnackbarHost.1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    final SnackbarHostState.SnackbarDataImpl snackbarDataImpl = (SnackbarHostState.SnackbarDataImpl) obj;
                    GapComposer gapComposer2 = (GapComposer) obj2;
                    int iIntValue = ((Number) obj3).intValue();
                    if ((iIntValue & 6) == 0) {
                        iIntValue |= gapComposer2.changed(snackbarDataImpl) ? 4 : 2;
                    }
                    if ((iIntValue & 19) == 18 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        gapComposer2.startReplaceGroup(-77646980);
                        Object objRememberedValue = gapComposer2.rememberedValue();
                        NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
                        if (objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = ArcSplineKt.Animatable$default(0.0f);
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        }
                        final Animatable animatable = (Animatable) objRememberedValue;
                        Object objM = Density.CC.m(-77645284, gapComposer2, false);
                        if (objM == neverEqualPolicy) {
                            objM = ArcSplineKt.Animatable$default(1.0f);
                            gapComposer2.updateRememberedValue(objM);
                        }
                        final Animatable animatable2 = (Animatable) objM;
                        gapComposer2.end(false);
                        Object objRememberedValue2 = gapComposer2.rememberedValue();
                        if (objRememberedValue2 == neverEqualPolicy) {
                            objRememberedValue2 = Stack.createCompositionCoroutineScope(gapComposer2);
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        }
                        final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue2;
                        gapComposer2.startReplaceGroup(-77640691);
                        boolean zChangedInstance = gapComposer2.changedInstance(animatable);
                        Object objRememberedValue3 = gapComposer2.rememberedValue();
                        if (zChangedInstance || objRememberedValue3 == neverEqualPolicy) {
                            objRememberedValue3 = new TvGlassTabRowKt$$ExternalSyntheticLambda1(animatable, 1);
                            gapComposer2.updateRememberedValue(objRememberedValue3);
                        }
                        gapComposer2.end(false);
                        Modifier modifierAlpha = ClipKt.alpha(OffsetKt.offset((Function1) objRememberedValue3), ((Number) animatable2.getValue()).floatValue());
                        gapComposer2.startReplaceGroup(-77635412);
                        int i6 = iIntValue & 14;
                        boolean zChangedInstance2 = (i6 == 4) | gapComposer2.changedInstance(animatable) | gapComposer2.changed(fMo92toPx0680j_4) | gapComposer2.changedInstance(coroutineScope) | gapComposer2.changedInstance(animatable2);
                        Object objRememberedValue4 = gapComposer2.rememberedValue();
                        if (zChangedInstance2 || objRememberedValue4 == neverEqualPolicy) {
                            final float f = fMo92toPx0680j_4;
                            PointerInputEventHandler pointerInputEventHandler = new PointerInputEventHandler() { // from class: com.github.kr328.clash.design.compose.components.GlassSnackbarKt$GlassSnackbarHost$1$2$1
                                @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                                public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
                                    Animatable animatable3 = animatable;
                                    float f2 = f;
                                    CoroutineScope coroutineScope2 = coroutineScope;
                                    GlassSnackbarKt$GlassSnackbarHost$1$2$1$$ExternalSyntheticLambda0 glassSnackbarKt$GlassSnackbarHost$1$2$1$$ExternalSyntheticLambda0 = new GlassSnackbarKt$GlassSnackbarHost$1$2$1$$ExternalSyntheticLambda0(animatable3, f2, pointerInputScope, coroutineScope2, animatable2, snackbarDataImpl);
                                    TextKt$$ExternalSyntheticLambda2 textKt$$ExternalSyntheticLambda2 = new TextKt$$ExternalSyntheticLambda2(28, coroutineScope2, animatable3);
                                    float f3 = DragGestureDetectorKt.mouseToTouchSlopRatio;
                                    Object objAwaitEachGesture = ScrollableKt.awaitEachGesture(pointerInputScope, new TapGestureDetectorKt$detectTapAndPress$2$1(new BasicTextKt$$ExternalSyntheticLambda3(2), textKt$$ExternalSyntheticLambda2, glassSnackbarKt$GlassSnackbarHost$1$2$1$$ExternalSyntheticLambda0, new ImmLeaksCleaner$$ExternalSyntheticLambda0(10), (Continuation) null, 2), continuation);
                                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                                    if (objAwaitEachGesture != coroutineSingletons) {
                                        objAwaitEachGesture = Unit.INSTANCE;
                                    }
                                    return objAwaitEachGesture == coroutineSingletons ? objAwaitEachGesture : Unit.INSTANCE;
                                }
                            };
                            gapComposer2.updateRememberedValue(pointerInputEventHandler);
                            objRememberedValue4 = pointerInputEventHandler;
                        }
                        gapComposer2.end(false);
                        Modifier modifierPointerInput = SuspendingPointerInputFilterKt.pointerInput(modifierAlpha, snackbarDataImpl, (PointerInputEventHandler) objRememberedValue4);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                        long j = gapComposer2.compositeKeyHashCode;
                        int i7 = (int) (j ^ (j >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierPointerInput);
                        ComposeUiNode.Companion.getClass();
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                        gapComposer2.startReusableNode();
                        if (gapComposer2.inserting) {
                            gapComposer2.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer2.useNode();
                        }
                        Stack.m295setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                        Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                        Stack.m295setimpl(gapComposer2, Integer.valueOf(i7), ComposeUiNode.Companion.SetCompositeKeyHash);
                        Stack.m294reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                        Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                        GlassSnackbarKt.GlassSnackbar(snackbarDataImpl, null, gapComposer2, i6);
                        gapComposer2.end(true);
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, (i4 & 112) | (i4 & 14) | 384);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.github.kr328.clash.design.compose.components.GlassSnackbarKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                    GlassSnackbarKt.GlassSnackbarHost(snackbarHostState, modifier, (GapComposer) obj, iUpdateChangedFlags, i2);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static Object showGlassSnackbar$default(SnackbarHostState snackbarHostState, String str, int i, Continuation continuation, int i2) {
        int i3 = 1;
        boolean z = (i2 & 8) == 0;
        if ((i2 & 16) == 0) {
            i3 = 3;
        } else if (i == 2) {
            i3 = 2;
        }
        return snackbarHostState.showSnackbar(new GlassSnackbarVisuals(i, i3, str, z), continuation);
    }
}
