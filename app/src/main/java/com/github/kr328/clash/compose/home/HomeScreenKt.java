package com.github.kr328.clash.compose.home;

import androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda3;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.SizeAnimationModifierElement;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.AppBarKt$$ExternalSyntheticLambda4;
import androidx.compose.material3.ButtonKt$$ExternalSyntheticLambda3;
import androidx.compose.material3.CheckboxColors;
import androidx.compose.material3.CheckboxDefaults;
import androidx.compose.material3.CheckboxKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.ColorSchemeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.MenuKt$$ExternalSyntheticLambda1;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.SnackbarHostKt$animatedScale$1$1;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.ThumbNode;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda7;
import androidx.compose.material3.tokens.CheckboxTokens;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt$RectangleShape$1;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetModifier$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayout$1;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import coil.compose.AsyncImageKt;
import coil.compose.AsyncImagePainter$$ExternalSyntheticLambda0;
import com.github.kr328.clash.compose.FilesScreenKt;
import com.github.kr328.clash.compose.FilesScreenKt$$ExternalSyntheticLambda4;
import com.github.kr328.clash.compose.LogsScreenKt;
import com.github.kr328.clash.compose.LogsScreenKt$$ExternalSyntheticLambda5;
import com.github.kr328.clash.compose.util.FormatKt;
import com.github.kr328.clash.design.compose.components.ControlButtonState;
import com.github.kr328.clash.design.compose.theme.AppColors;
import com.github.kr328.clash.design.compose.theme.AppColorsKt;
import com.github.kr328.clash.design.model.AppInfo;
import com.github.kr328.clash.service.model.Profile;
import com.google.android.gms.internal.mlkit_vision_common.zzjk;
import com.google.android.gms.internal.mlkit_vision_common.zzjl;
import com.google.android.gms.internal.mlkit_vision_common.zzjp;
import com.google.android.gms.internal.mlkit_vision_common.zzjq;
import com.koala.clash.R;
import dev.chrisbanes.haze.HazeKt;
import dev.chrisbanes.haze.HazeSourceElement;
import dev.chrisbanes.haze.HazeState;
import java.util.Arrays;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.serialization.encoding.Encoder;
import okhttp3.CertificatePinner;
import okhttp3.Cookie;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class HomeScreenKt {

    /* JADX INFO: renamed from: com.github.kr328.clash.compose.home.HomeScreenKt$ProxyBar$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass2 implements Function2 {
        public final /* synthetic */ AppColors $colors;
        public final /* synthetic */ Object $currentProxy;
        public final /* synthetic */ Function0 $onClick;
        public final /* synthetic */ int $r8$classId = 1;
        public final /* synthetic */ boolean $running;

        public AnonymousClass2(Function0 function0, AppInfo appInfo, boolean z, AppColors appColors) {
            this.$onClick = function0;
            this.$currentProxy = appInfo;
            this.$running = z;
            this.$colors = appColors;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            String strStringResource;
            int i = this.$r8$classId;
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            boolean z = this.$running;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Object obj3 = this.$currentProxy;
            Function0 function0 = this.$onClick;
            AppColors appColors = this.$colors;
            switch (i) {
                case 0:
                    GapComposer gapComposer = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
                        gapComposer.skipToGroupEnd();
                    } else {
                        Modifier modifierM130paddingVpY3zN4$default = OffsetKt.m130paddingVpY3zN4$default(ImageKt.m51clickableoSLSa3U$default(SizeKt.FillWholeMaxSize, z, null, function0, 14), 16, 0.0f, 2);
                        String strStringResource2 = (String) obj3;
                        RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.CenterVertically, gapComposer, 48);
                        long j = gapComposer.compositeKeyHashCode;
                        int i2 = (int) (j ^ (j >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifierM130paddingVpY3zN4$default);
                        ComposeUiNode.Companion.getClass();
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                        gapComposer.startReusableNode();
                        if (gapComposer.inserting) {
                            gapComposer.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer.useNode();
                        }
                        Stack.m295setimpl(gapComposer, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                        Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                        Stack.m295setimpl(gapComposer, Integer.valueOf(i2), ComposeUiNode.Companion.SetCompositeKeyHash);
                        Stack.m294reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                        Stack.m295setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                        gapComposer.startReplaceGroup(1916890807);
                        if (strStringResource2 == null) {
                            strStringResource2 = StringResources_androidKt.stringResource(R.string.proxy_select_server, gapComposer);
                        }
                        String str = strStringResource2;
                        gapComposer.end(false);
                        TextStyle textStyle = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.titleSmall;
                        long j2 = appColors.textPrimary;
                        if (1.0f <= 0.0d) {
                            InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                        }
                        TextKt.m275TextNvy7gAk(str, new LayoutWeightElement(1.0f, true), j2, 0L, null, null, 0L, null, 0L, 0, false, 1, 0, textStyle, gapComposer, 0, 24576, 114680);
                        IconKt.m249Iconww6aTOc(Encoder.DefaultImpls.getKeyboardArrowRight(), null, null, appColors.textPrimary, gapComposer, 48, 4);
                        gapComposer.end(true);
                    }
                    break;
                case 1:
                    GapComposer gapComposer2 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        float f = 16;
                        Modifier modifierM129paddingVpY3zN4 = OffsetKt.m129paddingVpY3zN4(ImageKt.m51clickableoSLSa3U$default(SizeKt.fillMaxWidth(companion, 1.0f), false, null, function0, 15), f, 12);
                        AppInfo appInfo = (AppInfo) obj3;
                        RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.CenterVertically, gapComposer2, 48);
                        long j3 = gapComposer2.compositeKeyHashCode;
                        int i3 = (int) (j3 ^ (j3 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer2, modifierM129paddingVpY3zN4);
                        ComposeUiNode.Companion.getClass();
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$2 = ComposeUiNode.Companion.Constructor;
                        gapComposer2.startReusableNode();
                        if (gapComposer2.inserting) {
                            gapComposer2.createNode(layoutNode$Companion$Constructor$2);
                        } else {
                            gapComposer2.useNode();
                        }
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$1 = ComposeUiNode.Companion.SetMeasurePolicy;
                        Stack.m295setimpl(gapComposer2, rowMeasurePolicy2, composeUiNode$Companion$SetModifier$1);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                        Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
                        Integer numValueOf = Integer.valueOf(i3);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
                        Stack.m295setimpl(gapComposer2, numValueOf, composeUiNode$Companion$SetModifier$3);
                        OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
                        Stack.m294reconcileimpl(gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
                        Stack.m295setimpl(gapComposer2, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
                        AsyncImageKt.m778AsyncImagegl8XCv8(appInfo.icon, SizeKt.m140size3ABfNKs(companion, 40), null, null, gapComposer2, 432, 4088);
                        OffsetKt.Spacer(gapComposer2, SizeKt.m144width3ABfNKs(companion, f));
                        if (1.0f <= 0.0d) {
                            InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                        }
                        LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
                        ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, gapComposer2, 0);
                        long j4 = gapComposer2.compositeKeyHashCode;
                        int i4 = (int) (j4 ^ (j4 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope3 = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier3 = AbsoluteAlignment.materializeModifier(gapComposer2, layoutWeightElement);
                        gapComposer2.startReusableNode();
                        if (gapComposer2.inserting) {
                            gapComposer2.createNode(layoutNode$Companion$Constructor$2);
                        } else {
                            gapComposer2.useNode();
                        }
                        Stack.m295setimpl(gapComposer2, columnMeasurePolicy, composeUiNode$Companion$SetModifier$1);
                        Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope3, composeUiNode$Companion$SetModifier$2);
                        Modifier.CC.m(i4, gapComposer2, composeUiNode$Companion$SetModifier$3, gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
                        Stack.m295setimpl(gapComposer2, modifierMaterializeModifier3, composeUiNode$Companion$SetModifier$4);
                        String str2 = appInfo.label;
                        StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                        TextKt.m275TextNvy7gAk(str2, null, appColors.textPrimary, 0L, null, null, 0L, null, 0L, 0, false, 1, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.titleMedium, gapComposer2, 0, 24576, 114682);
                        TextKt.m275TextNvy7gAk(appInfo.packageName, null, appColors.textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 1, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.bodySmall, gapComposer2, 0, 24576, 114682);
                        gapComposer2.end(true);
                        gapComposer2.startReplaceGroup(-1158366151);
                        boolean zChanged = gapComposer2.changed(function0);
                        Object objRememberedValue = gapComposer2.rememberedValue();
                        if (zChanged || objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = new AppBarKt$$ExternalSyntheticLambda4(5, function0);
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        }
                        Function1 function1 = (Function1) objRememberedValue;
                        gapComposer2.end(false);
                        float f2 = CheckboxDefaults.StrokeWidth;
                        long j5 = appColors.buttonColor;
                        long j6 = appColors.textSecondary;
                        long j7 = appColors.textPrimary;
                        long j8 = Color.Unspecified;
                        ColorScheme colorScheme = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).colorScheme;
                        CheckboxColors checkboxColors = colorScheme.defaultCheckboxColorsCached;
                        if (checkboxColors == null) {
                            long jFromToken = ColorSchemeKt.fromToken(colorScheme, CheckboxTokens.SelectedIconColor);
                            long j9 = Color.Transparent;
                            long jFromToken2 = ColorSchemeKt.fromToken(colorScheme, CheckboxTokens.SelectedDisabledIconColor);
                            int i5 = CheckboxTokens.SelectedContainerColor;
                            long jFromToken3 = ColorSchemeKt.fromToken(colorScheme, i5);
                            int i6 = CheckboxTokens.SelectedDisabledContainerColor;
                            long jFromToken4 = ColorSchemeKt.fromToken(colorScheme, i6);
                            float f3 = CheckboxTokens.SelectedDisabledContainerOpacity;
                            long jColor = BrushKt.Color(Color.m440getRedimpl(jFromToken4), Color.m439getGreenimpl(jFromToken4), Color.m437getBlueimpl(jFromToken4), f3, Color.m438getColorSpaceimpl(jFromToken4));
                            long jFromToken5 = ColorSchemeKt.fromToken(colorScheme, i6);
                            long jColor2 = BrushKt.Color(Color.m440getRedimpl(jFromToken5), Color.m439getGreenimpl(jFromToken5), Color.m437getBlueimpl(jFromToken5), f3, Color.m438getColorSpaceimpl(jFromToken5));
                            long jFromToken6 = ColorSchemeKt.fromToken(colorScheme, i5);
                            long jFromToken7 = ColorSchemeKt.fromToken(colorScheme, CheckboxTokens.UnselectedOutlineColor);
                            long jFromToken8 = ColorSchemeKt.fromToken(colorScheme, i6);
                            long jColor3 = BrushKt.Color(Color.m440getRedimpl(jFromToken8), Color.m439getGreenimpl(jFromToken8), Color.m437getBlueimpl(jFromToken8), f3, Color.m438getColorSpaceimpl(jFromToken8));
                            long jFromToken9 = ColorSchemeKt.fromToken(colorScheme, CheckboxTokens.UnselectedDisabledOutlineColor);
                            long jColor4 = BrushKt.Color(Color.m440getRedimpl(jFromToken9), Color.m439getGreenimpl(jFromToken9), Color.m437getBlueimpl(jFromToken9), CheckboxTokens.UnselectedDisabledContainerOpacity, Color.m438getColorSpaceimpl(jFromToken9));
                            long jFromToken10 = ColorSchemeKt.fromToken(colorScheme, i6);
                            CheckboxColors checkboxColors2 = new CheckboxColors(jFromToken, j9, jFromToken3, j9, jColor, j9, jColor2, jFromToken6, jFromToken7, jColor3, jColor4, BrushKt.Color(Color.m440getRedimpl(jFromToken10), Color.m439getGreenimpl(jFromToken10), Color.m437getBlueimpl(jFromToken10), f3, Color.m438getColorSpaceimpl(jFromToken10)), jFromToken2);
                            colorScheme.defaultCheckboxColorsCached = checkboxColors2;
                            checkboxColors = checkboxColors2;
                        }
                        long j10 = Color.Transparent;
                        long j11 = j7 != 16 ? j7 : checkboxColors.checkedCheckmarkColor;
                        long j12 = j10 != r13 ? j10 : checkboxColors.uncheckedCheckmarkColor;
                        long j13 = j5 != r13 ? j5 : checkboxColors.checkedBoxColor;
                        long j14 = j10 != r13 ? j10 : checkboxColors.uncheckedBoxColor;
                        long j15 = j8 != r13 ? j8 : checkboxColors.disabledCheckedBoxColor;
                        long j16 = j10 != r13 ? j10 : checkboxColors.disabledUncheckedBoxColor;
                        long j17 = j8 != r13 ? j8 : checkboxColors.disabledIndeterminateBoxColor;
                        if (j5 == r13) {
                            j5 = checkboxColors.checkedBorderColor;
                        }
                        long j18 = j5;
                        if (j6 == 16) {
                            j6 = checkboxColors.uncheckedBorderColor;
                        }
                        long j19 = j6;
                        long j20 = j8 != r13 ? j8 : checkboxColors.disabledBorderColor;
                        long j21 = j8 != r13 ? j8 : checkboxColors.disabledUncheckedBorderColor;
                        if (j8 == r13) {
                            j8 = checkboxColors.disabledIndeterminateBorderColor;
                        }
                        CheckboxKt.Checkbox(this.$running, function1, null, false, new CheckboxColors(j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j8, j7 != 16 ? j7 : checkboxColors.disabledCheckmarkColor), gapComposer2, 0);
                        gapComposer2.end(true);
                    }
                    break;
                default:
                    GapComposer gapComposer3 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer3.getSkipping()) {
                        gapComposer3.skipToGroupEnd();
                    } else {
                        float f4 = 12;
                        Modifier modifierM129paddingVpY3zN5 = OffsetKt.m129paddingVpY3zN4(SizeKt.fillMaxWidth(companion, 1.0f), 16, f4);
                        BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                        MutableState mutableState = (MutableState) obj3;
                        RowMeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.Start, vertical, gapComposer3, 48);
                        long j22 = gapComposer3.compositeKeyHashCode;
                        int i7 = (int) (j22 ^ (j22 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope4 = gapComposer3.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier4 = AbsoluteAlignment.materializeModifier(gapComposer3, modifierM129paddingVpY3zN5);
                        ComposeUiNode.Companion.getClass();
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$3 = ComposeUiNode.Companion.Constructor;
                        gapComposer3.startReusableNode();
                        if (gapComposer3.inserting) {
                            gapComposer3.createNode(layoutNode$Companion$Constructor$3);
                        } else {
                            gapComposer3.useNode();
                        }
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$5 = ComposeUiNode.Companion.SetMeasurePolicy;
                        Stack.m295setimpl(gapComposer3, rowMeasurePolicy3, composeUiNode$Companion$SetModifier$5);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$6 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                        Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope4, composeUiNode$Companion$SetModifier$6);
                        Integer numValueOf2 = Integer.valueOf(i7);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$7 = ComposeUiNode.Companion.SetCompositeKeyHash;
                        Stack.m295setimpl(gapComposer3, numValueOf2, composeUiNode$Companion$SetModifier$7);
                        OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$2 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
                        Stack.m294reconcileimpl(gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$2);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$8 = ComposeUiNode.Companion.SetModifier;
                        Stack.m295setimpl(gapComposer3, modifierMaterializeModifier4, composeUiNode$Companion$SetModifier$8);
                        if (1.0f <= 0.0d) {
                            InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                        }
                        LayoutWeightElement layoutWeightElement2 = new LayoutWeightElement(1.0f, true);
                        ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, gapComposer3, 0);
                        long j23 = gapComposer3.compositeKeyHashCode;
                        int i8 = (int) (j23 ^ (j23 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope5 = gapComposer3.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier5 = AbsoluteAlignment.materializeModifier(gapComposer3, layoutWeightElement2);
                        gapComposer3.startReusableNode();
                        if (gapComposer3.inserting) {
                            gapComposer3.createNode(layoutNode$Companion$Constructor$3);
                        } else {
                            gapComposer3.useNode();
                        }
                        Stack.m295setimpl(gapComposer3, columnMeasurePolicy2, composeUiNode$Companion$SetModifier$5);
                        Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope5, composeUiNode$Companion$SetModifier$6);
                        Modifier.CC.m(i8, gapComposer3, composeUiNode$Companion$SetModifier$7, gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$2);
                        Stack.m295setimpl(gapComposer3, modifierMaterializeModifier5, composeUiNode$Companion$SetModifier$8);
                        StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
                        TextKt.m275TextNvy7gAk("v1.2.0", null, appColors.textPrimary, 0L, null, FontWeight.SemiBold, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal2)).typography.bodyMedium, gapComposer3, 1572864, 0, 131002);
                        gapComposer3.startReplaceGroup(684397067);
                        if (((String) mutableState.getValue()) != null) {
                            TextKt.m275TextNvy7gAk(CaptureSession$State$EnumUnboxingLocalUtility.m("Core: ", (String) mutableState.getValue()), null, appColors.textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal2)).typography.bodySmall, gapComposer3, 0, 0, 131066);
                        }
                        gapComposer3.end(false);
                        gapComposer3.end(true);
                        OffsetKt.Spacer(gapComposer3, SizeKt.m144width3ABfNKs(companion, f4));
                        gapComposer3.startReplaceGroup(911086787);
                        Object objRememberedValue2 = gapComposer3.rememberedValue();
                        if (objRememberedValue2 == neverEqualPolicy) {
                            objRememberedValue2 = Stack.mutableStateOf$default(Boolean.FALSE);
                            gapComposer3.updateRememberedValue(objRememberedValue2);
                        }
                        MutableState mutableState2 = (MutableState) objRememberedValue2;
                        gapComposer3.end(false);
                        float f5 = z ? 0.5f : 1.0f;
                        CubicBezierEasing cubicBezierEasing = EasingKt.FastOutSlowInEasing;
                        State stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f5, ArcSplineKt.tween$default(250, 2, cubicBezierEasing), "buttonAlpha", gapComposer3, 3072);
                        State stateM26animateColorAsStateeuL9pac = SingleValueAnimationKt.m26animateColorAsStateeuL9pac(z ? appColors.textSecondary : appColors.textPrimary, ArcSplineKt.tween$default(250, 2, cubicBezierEasing), "textColor", gapComposer3, 384, 8);
                        long j24 = ((Boolean) mutableState2.getValue()).booleanValue() ? appColors.buttonActiveStart : appColors.accentBorder;
                        float f6 = 8;
                        Modifier modifierM48borderxT4_qwU = ImageKt.m48borderxT4_qwU(((Boolean) mutableState2.getValue()).booleanValue() ? 2 : 1, BrushKt.Color(Color.m440getRedimpl(j24), Color.m439getGreenimpl(j24), Color.m437getBlueimpl(j24), Color.m436getAlphaimpl(j24) * ((Number) stateAnimateFloatAsState.getValue()).floatValue(), Color.m438getColorSpaceimpl(j24)), ClipKt.clip(companion, RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(f6)), RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(f6));
                        long j25 = appColors.buttonColor;
                        Modifier modifierM47backgroundbw27NRU = ImageKt.m47backgroundbw27NRU(modifierM48borderxT4_qwU, BrushKt.Color(Color.m440getRedimpl(j25), Color.m439getGreenimpl(j25), Color.m437getBlueimpl(j25), ((Number) stateAnimateFloatAsState.getValue()).floatValue() * Color.m436getAlphaimpl(j25), Color.m438getColorSpaceimpl(j25)), BrushKt.RectangleShape);
                        gapComposer3.startReplaceGroup(911123741);
                        Object objRememberedValue3 = gapComposer3.rememberedValue();
                        if (objRememberedValue3 == neverEqualPolicy) {
                            objRememberedValue3 = new TooltipKt$$ExternalSyntheticLambda7(mutableState2, 28);
                            gapComposer3.updateRememberedValue(objRememberedValue3);
                        }
                        gapComposer3.end(false);
                        Modifier modifierM129paddingVpY3zN6 = OffsetKt.m129paddingVpY3zN4(ClipKt.clipToBounds(ImageKt.m51clickableoSLSa3U$default(FocusTraversalKt.onFocusChanged(modifierM47backgroundbw27NRU, (Function1) objRememberedValue3), !z, null, function0, 14)).then(new SizeAnimationModifierElement(ArcSplineKt.tween$default(250, 2, cubicBezierEasing))), 14, 10);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
                        long j26 = gapComposer3.compositeKeyHashCode;
                        int i9 = (int) (j26 ^ (j26 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope6 = gapComposer3.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier6 = AbsoluteAlignment.materializeModifier(gapComposer3, modifierM129paddingVpY3zN6);
                        gapComposer3.startReusableNode();
                        if (gapComposer3.inserting) {
                            gapComposer3.createNode(layoutNode$Companion$Constructor$3);
                        } else {
                            gapComposer3.useNode();
                        }
                        Stack.m295setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy, composeUiNode$Companion$SetModifier$5);
                        Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope6, composeUiNode$Companion$SetModifier$6);
                        Modifier.CC.m(i9, gapComposer3, composeUiNode$Companion$SetModifier$7, gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$2);
                        Stack.m295setimpl(gapComposer3, modifierMaterializeModifier6, composeUiNode$Companion$SetModifier$8);
                        RowMeasurePolicy rowMeasurePolicy4 = RowKt.rowMeasurePolicy(Arrangement.Center, vertical, gapComposer3, 54);
                        long j27 = gapComposer3.compositeKeyHashCode;
                        int i10 = (int) (j27 ^ (j27 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope7 = gapComposer3.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier7 = AbsoluteAlignment.materializeModifier(gapComposer3, companion);
                        gapComposer3.startReusableNode();
                        if (gapComposer3.inserting) {
                            gapComposer3.createNode(layoutNode$Companion$Constructor$3);
                        } else {
                            gapComposer3.useNode();
                        }
                        Stack.m295setimpl(gapComposer3, rowMeasurePolicy4, composeUiNode$Companion$SetModifier$5);
                        Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope7, composeUiNode$Companion$SetModifier$6);
                        Modifier.CC.m(i10, gapComposer3, composeUiNode$Companion$SetModifier$7, gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$2);
                        Stack.m295setimpl(gapComposer3, modifierMaterializeModifier7, composeUiNode$Companion$SetModifier$8);
                        gapComposer3.startReplaceGroup(332231567);
                        if (z) {
                            ProgressIndicatorKt.m256CircularProgressIndicator4lLiAd8(SizeKt.m140size3ABfNKs(companion, 11), appColors.textSecondary, (float) 1.5d, 0L, 0, 0.0f, gapComposer3, 390, 56);
                            OffsetKt.Spacer(gapComposer3, SizeKt.m144width3ABfNKs(companion, 6));
                        }
                        gapComposer3.end(false);
                        if (z) {
                            gapComposer3.startReplaceGroup(332245223);
                            strStringResource = StringResources_androidKt.stringResource(R.string.update_checking, gapComposer3);
                            gapComposer3.end(false);
                        } else {
                            gapComposer3.startReplaceGroup(332248356);
                            strStringResource = StringResources_androidKt.stringResource(R.string.update_check, gapComposer3);
                            gapComposer3.end(false);
                        }
                        TextKt.m275TextNvy7gAk(strStringResource, null, ((Color) stateM26animateColorAsStateeuL9pac.getValue()).value, 0L, null, FontWeight.Medium, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal2)).typography.labelMedium, gapComposer3, 1572864, 0, 131002);
                        gapComposer3.end(true);
                        gapComposer3.end(true);
                        gapComposer3.end(true);
                    }
                    break;
            }
            return Unit.INSTANCE;
        }

        public AnonymousClass2(boolean z, AppColors appColors, Function0 function0, MutableState mutableState) {
            this.$running = z;
            this.$colors = appColors;
            this.$onClick = function0;
            this.$currentProxy = mutableState;
        }

        public AnonymousClass2(boolean z, Function0 function0, String str, AppColors appColors) {
            this.$running = z;
            this.$onClick = function0;
            this.$currentProxy = str;
            this.$colors = appColors;
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.compose.home.HomeScreenKt$TrafficDaysCard$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 implements Function2 {
        public final /* synthetic */ AppColors $colors;
        public final /* synthetic */ boolean $isTv;
        public final /* synthetic */ Profile $profile;
        public final /* synthetic */ int $r8$classId;

        public AnonymousClass1(AppColors appColors, boolean z, Profile profile) {
            this.$r8$classId = 0;
            this.$colors = appColors;
            this.$isTv = z;
            this.$profile = profile;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            TextStyle textStyle;
            TextStyle textStyle2;
            switch (this.$r8$classId) {
                case 0:
                    GapComposer gapComposer = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
                        gapComposer.skipToGroupEnd();
                    } else {
                        FillElement fillElement = SizeKt.FillWholeMaxSize;
                        RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.CenterVertically, gapComposer, 48);
                        long j = gapComposer.compositeKeyHashCode;
                        int i = (int) (j ^ (j >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, fillElement);
                        ComposeUiNode.Companion.getClass();
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                        gapComposer.startReusableNode();
                        if (gapComposer.inserting) {
                            gapComposer.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer.useNode();
                        }
                        Stack.m295setimpl(gapComposer, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                        Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                        Stack.m295setimpl(gapComposer, Integer.valueOf(i), ComposeUiNode.Companion.SetCompositeKeyHash);
                        Stack.m294reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                        Stack.m295setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                        String strStringResource = StringResources_androidKt.stringResource(R.string.profile_traffic_remaining, gapComposer);
                        Profile profile = this.$profile;
                        boolean z = this.$isTv;
                        AppColors appColors = this.$colors;
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Thread_jvmKt.rememberComposableLambda(-982304519, new AnonymousClass1(profile, z, appColors, 1), gapComposer);
                        if (1.0f <= 0.0d) {
                            InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                        }
                        HomeScreenKt.TrafficColumn(strStringResource, composableLambdaImplRememberComposableLambda, new LayoutWeightElement(1.0f, true), gapComposer, 48);
                        ScrimKt.m268VerticalDivider9IZ8Weo(SizeKt.m144width3ABfNKs(SizeKt.m135height3ABfNKs(Modifier.Companion.$$INSTANCE, z ? 30 : 40), 1), 0.0f, appColors.cardBorder, gapComposer, 0);
                        String strStringResource2 = StringResources_androidKt.stringResource(R.string.profile_days_remaining, gapComposer);
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda2 = Thread_jvmKt.rememberComposableLambda(-1712490000, new AnonymousClass1(profile, z, appColors, 2), gapComposer);
                        if (1.0f <= 0.0d) {
                            InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
                        }
                        HomeScreenKt.TrafficColumn(strStringResource2, composableLambdaImplRememberComposableLambda2, new LayoutWeightElement(1.0f, true), gapComposer, 48);
                        gapComposer.end(true);
                    }
                    break;
                case 1:
                    GapComposer gapComposer2 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        Profile profile2 = this.$profile;
                        long j2 = profile2.total;
                        long j3 = profile2.upload + profile2.download;
                        AppColors appColors2 = this.$colors;
                        boolean z2 = this.$isTv;
                        if (j2 > 0) {
                            gapComposer2.startReplaceGroup(1141931337);
                            String bytesRemaining = FormatKt.formatBytesRemaining(Math.max(0L, j2 - j3));
                            if (z2) {
                                gapComposer2.startReplaceGroup(-1764273325);
                                textStyle = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyMedium;
                                gapComposer2.end(false);
                            } else {
                                gapComposer2.startReplaceGroup(-1764271116);
                                textStyle = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.titleMedium;
                                gapComposer2.end(false);
                            }
                            TextKt.m275TextNvy7gAk(bytesRemaining, null, appColors2.textPrimary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, textStyle, gapComposer2, 0, 0, 131066);
                            gapComposer2.end(false);
                        } else {
                            gapComposer2.startReplaceGroup(1142301570);
                            ImageVector allInclusive = Cookie.Companion.getAllInclusive();
                            long j4 = appColors2.textPrimary;
                            Modifier modifierM140size3ABfNKs = Modifier.Companion.$$INSTANCE;
                            if (z2) {
                                modifierM140size3ABfNKs = SizeKt.m140size3ABfNKs(modifierM140size3ABfNKs, 18);
                            }
                            IconKt.m249Iconww6aTOc(allInclusive, null, modifierM140size3ABfNKs, j4, gapComposer2, 48, 0);
                            gapComposer2.end(false);
                        }
                    }
                    break;
                default:
                    GapComposer gapComposer3 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer3.getSkipping()) {
                        gapComposer3.skipToGroupEnd();
                    } else {
                        long j5 = this.$profile.expire;
                        AppColors appColors3 = this.$colors;
                        boolean z3 = this.$isTv;
                        if (j5 > 0) {
                            gapComposer3.startReplaceGroup(1143147250);
                            long jCurrentTimeMillis = (j5 - (System.currentTimeMillis() / 1000)) / 86400;
                            String strValueOf = String.valueOf(jCurrentTimeMillis >= 0 ? jCurrentTimeMillis : 0L);
                            if (z3) {
                                gapComposer3.startReplaceGroup(-1764230413);
                                textStyle2 = ((MaterialTheme$Values) gapComposer3.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyMedium;
                                gapComposer3.end(false);
                            } else {
                                gapComposer3.startReplaceGroup(-1764228204);
                                textStyle2 = ((MaterialTheme$Values) gapComposer3.consume(MaterialThemeKt._localMaterialTheme)).typography.titleMedium;
                                gapComposer3.end(false);
                            }
                            TextKt.m275TextNvy7gAk(strValueOf, null, appColors3.textPrimary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, textStyle2, gapComposer3, 0, 0, 131066);
                            gapComposer3.end(false);
                        } else {
                            gapComposer3.startReplaceGroup(1143631842);
                            ImageVector allInclusive2 = Cookie.Companion.getAllInclusive();
                            long j6 = appColors3.textPrimary;
                            Modifier modifierM140size3ABfNKs2 = Modifier.Companion.$$INSTANCE;
                            if (z3) {
                                modifierM140size3ABfNKs2 = SizeKt.m140size3ABfNKs(modifierM140size3ABfNKs2, 18);
                            }
                            IconKt.m249Iconww6aTOc(allInclusive2, null, modifierM140size3ABfNKs2, j6, gapComposer3, 48, 0);
                            gapComposer3.end(false);
                        }
                    }
                    break;
            }
            return Unit.INSTANCE;
        }

        public /* synthetic */ AnonymousClass1(Profile profile, boolean z, AppColors appColors, int i) {
            this.$r8$classId = i;
            this.$profile = profile;
            this.$isTv = z;
            this.$colors = appColors;
        }
    }

    public static final void AddProfilePillButton(Function0 function0, GapComposer gapComposer, int i) {
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(-1014230776);
        if (((i | (gapComposer2.changedInstance(function0) ? 4 : 2)) & 3) == 2 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            gapComposer2.startReplaceGroup(-977979347);
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            gapComposer2.end(false);
            float f = 18;
            RoundedCornerShape roundedCornerShapeM158RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(f);
            gapComposer2.startReplaceGroup(-977974809);
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new TooltipKt$$ExternalSyntheticLambda7(mutableState, 19);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            gapComposer2.end(false);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierClip = ClipKt.clip(ImageKt.m48borderxT4_qwU(((Boolean) mutableState.getValue()).booleanValue() ? 2 : 0, ((Boolean) mutableState.getValue()).booleanValue() ? Color.White : Color.Transparent, FocusTraversalKt.onFocusChanged(companion, (Function1) objRememberedValue2), roundedCornerShapeM158RoundedCornerShape0680j_4), roundedCornerShapeM158RoundedCornerShape0680j_4);
            long j = appColors.buttonColor;
            RectangleShapeKt$RectangleShape$1 rectangleShapeKt$RectangleShape$1 = BrushKt.RectangleShape;
            Modifier modifierM51clickableoSLSa3U$default = ImageKt.m51clickableoSLSa3U$default(ImageKt.m47backgroundbw27NRU(modifierClip, j, rectangleShapeKt$RectangleShape$1), false, null, function0, 15);
            float f2 = 24;
            Modifier modifierM129paddingVpY3zN4 = OffsetKt.m129paddingVpY3zN4(modifierM51clickableoSLSa3U$default, f2, 14);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.m111spacedBy0680j_4(10), Alignment.Companion.CenterVertically, gapComposer2, 54);
            long j2 = gapComposer2.compositeKeyHashCode;
            int i2 = (int) (j2 ^ (j2 >>> 32));
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
            Stack.m295setimpl(gapComposer2, rowMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, composeUiNode$Companion$SetModifier$2);
            Integer numValueOf = Integer.valueOf(i2);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m295setimpl(gapComposer2, numValueOf, composeUiNode$Companion$SetModifier$3);
            OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
            Stack.m294reconcileimpl(gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
            Modifier modifierM47backgroundbw27NRU = ImageKt.m47backgroundbw27NRU(ClipKt.clip(SizeKt.m140size3ABfNKs(companion, f2), RoundedCornerShapeKt.CircleShape), Color.White, rectangleShapeKt$RectangleShape$1);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
            long j3 = gapComposer2.compositeKeyHashCode;
            int i3 = (int) (j3 ^ (j3 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer2, modifierM47backgroundbw27NRU);
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer2.useNode();
            }
            Stack.m295setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
            ImageAnalysis$$ExternalSyntheticLambda1.m(i3, gapComposer2, composeUiNode$Companion$SetModifier$3, gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
            IconKt.m249Iconww6aTOc(CertificatePinner.Companion.getAdd(), null, SizeKt.m140size3ABfNKs(companion, f), appColors.buttonActiveEnd, gapComposer2, 432, 0);
            gapComposer2.end(true);
            TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.profile_add, gapComposer2), null, appColors.textPrimary, 0L, null, FontWeight.SemiBold, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.titleMedium, gapComposer, 1572864, 0, 131002);
            gapComposer2 = gapComposer;
            gapComposer2.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new LogsScreenKt$$ExternalSyntheticLambda5(function0, i, 1);
        }
    }

    public static final void AnnounceCard(String str, HazeState hazeState, boolean z, GapComposer gapComposer, int i) {
        int i2;
        gapComposer.startRestartGroup(2082385830);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(hazeState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changed(z) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            zzjl.m819GlassSurfaceYxtnGt4(z ? SizeKt.wrapContentWidth$default() : SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), 12, hazeState, Thread_jvmKt.rememberComposableLambda(-698049591, new FilesScreenKt.AnonymousClass4((AppColors) gapComposer.consume(AppColorsKt.LocalAppColors), z, str), gapComposer), gapComposer, 196656 | ((i2 << 9) & 57344), 12);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new HomeScreenKt$$ExternalSyntheticLambda5(str, hazeState, z, i, 2);
        }
    }

    public static final void ConnectionTimer(boolean z, Long l, GapComposer gapComposer, int i) {
        int i2;
        Object snackbarHostKt$animatedScale$1$1;
        Easing easing;
        gapComposer.startRestartGroup(851301574);
        if ((i & 6) == 0) {
            i2 = i | (gapComposer.changed(z) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(l) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            gapComposer.startReplaceGroup(-992273562);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.mutableStateOf$default(Long.valueOf(System.currentTimeMillis()));
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            gapComposer.end(false);
            Boolean boolValueOf = Boolean.valueOf(z);
            gapComposer.startReplaceGroup(-992270399);
            boolean z2 = ((i2 & 112) == 32) | ((i2 & 14) == 4);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (z2 || objRememberedValue2 == neverEqualPolicy) {
                easing = null;
                snackbarHostKt$animatedScale$1$1 = new SnackbarHostKt$animatedScale$1$1(z, l, mutableState, (Continuation) null, 3);
                gapComposer.updateRememberedValue(snackbarHostKt$animatedScale$1$1);
            } else {
                snackbarHostKt$animatedScale$1$1 = objRememberedValue2;
                easing = null;
            }
            gapComposer.end(false);
            Stack.LaunchedEffect(boolValueOf, r2, (Function2) snackbarHostKt$animatedScale$1$1, gapComposer);
            String str = "00:00:00";
            if (z && r2 != 0) {
                long jLongValue = ((Number) mutableState.getValue()).longValue() - l.longValue();
                if (jLongValue >= 0) {
                    long j = jLongValue / 1000;
                    str = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j / 3600), Long.valueOf((j % 3600) / 60), Long.valueOf(j % 60)}, 3));
                }
            }
            float f = 4;
            TextKt.m275TextNvy7gAk(str, ClipKt.alpha(OffsetKt.m132paddingqDBjuR0$default(Modifier.Companion.$$INSTANCE, 0.0f, f, 0.0f, f, 5), ((Number) AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, ArcSplineKt.tween$default(300, 6, easing), "timer-alpha", gapComposer, 3120).getValue()).floatValue()), appColors.textPrimary, 0L, null, FontWeight.Bold, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyLarge, gapComposer, 1572864, 0, 131000);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new BackHandlerKt$$ExternalSyntheticLambda3(i, 2, l, z);
        }
    }

    public static final void EmptyHomeContent(Function0 function0, HazeState hazeState, boolean z, Modifier modifier, GapComposer gapComposer, int i) {
        int i2;
        HazeState hazeState2;
        gapComposer.startRestartGroup(-1550559726);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            hazeState2 = hazeState;
            i2 |= gapComposer.changed(hazeState2) ? 32 : 16;
        } else {
            hazeState2 = hazeState;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changed(modifier) ? 2048 : 1024;
        }
        if ((i2 & 1171) == 1170 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
            long j = gapComposer.compositeKeyHashCode;
            int i3 = (int) (j ^ (j >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifier);
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer.useNode();
            }
            Stack.m295setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m295setimpl(gapComposer, Integer.valueOf(i3), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m294reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m295setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            zzjl.m819GlassSurfaceYxtnGt4(z ? OffsetKt.m130paddingVpY3zN4$default(SizeKt.fillMaxWidth(companion, 0.45f), 24, 0.0f, 2) : OffsetKt.m130paddingVpY3zN4$default(SizeKt.fillMaxWidth(companion, 1.0f), 24, 0.0f, 2), 24, hazeState2, Thread_jvmKt.rememberComposableLambda(-505594885, new LogsScreenKt.AnonymousClass2(appColors, function0, 12), gapComposer), gapComposer, 196656 | ((i2 << 9) & 57344), 12);
            gapComposer.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new HomeScreenKt$$ExternalSyntheticLambda3(function0, hazeState, z, modifier, i);
        }
    }

    public static final void HomeContent(final Profile profile, final ControlButtonState controlButtonState, final Long l, final String str, final Function0 function0, final Function0 function1, final Function0 function2, final HazeState hazeState, final Modifier modifier, final boolean z, GapComposer gapComposer, final int i) {
        int i2;
        char c;
        float f;
        int i3;
        boolean z2;
        String str2;
        boolean z3;
        Modifier.Companion companion;
        GapComposer gapComposer2;
        HazeState hazeState2;
        boolean z4;
        GapComposer gapComposer3 = gapComposer;
        String str3 = profile.profileImagePath;
        gapComposer3.startRestartGroup(-1273397957);
        if ((i & 6) == 0) {
            i2 = (gapComposer3.changedInstance(profile) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer3.changed(controlButtonState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer3.changed(l) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer3.changed(str) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer3.changedInstance(function0) ? 16384 : 8192;
        }
        if ((i & 196608) == 0) {
            c = ' ';
            i2 |= gapComposer3.changedInstance(function1) ? 131072 : 65536;
        } else {
            c = ' ';
        }
        if ((i & 1572864) == 0) {
            i2 |= gapComposer3.changedInstance(function2) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i2 |= gapComposer3.changed(hazeState) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i2 |= gapComposer3.changed(modifier) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i2 |= gapComposer3.changed(z) ? 536870912 : 268435456;
        }
        int i4 = i2;
        if ((i4 & 306783379) == 306783378 && gapComposer3.getSkipping()) {
            gapComposer3.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer3.consume(AppColorsKt.LocalAppColors);
            boolean z5 = controlButtonState == ControlButtonState.Connected;
            float f2 = 16;
            Modifier modifierM130paddingVpY3zN4$default = OffsetKt.m130paddingVpY3zN4$default(modifier, f2, 0.0f, 2);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.CenterHorizontally, gapComposer3, 48);
            long j = gapComposer3.compositeKeyHashCode;
            int i5 = (int) (j ^ (j >>> c));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer3.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer3, modifierM130paddingVpY3zN4$default);
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer3.startReusableNode();
            if (gapComposer3.inserting) {
                gapComposer3.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer3.useNode();
            }
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$1 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m295setimpl(gapComposer3, columnMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope, composeUiNode$Companion$SetModifier$2);
            Integer numValueOf = Integer.valueOf(i5);
            boolean z6 = z5;
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m295setimpl(gapComposer3, numValueOf, composeUiNode$Companion$SetModifier$3);
            OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
            Stack.m294reconcileimpl(gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
            Stack.m295setimpl(gapComposer3, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
            float f3 = z ? 4 : 24;
            Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
            OffsetKt.Spacer(gapComposer3, SizeKt.m135height3ABfNKs(companion2, f3));
            if (z) {
                gapComposer3.startReplaceGroup(328394842);
                RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.m111spacedBy0680j_4(12), Alignment.Companion.CenterVertically, gapComposer3, 54);
                long j2 = gapComposer3.compositeKeyHashCode;
                int i6 = (int) (j2 ^ (j2 >>> c));
                PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer3.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer3, companion2);
                gapComposer3.startReusableNode();
                if (gapComposer3.inserting) {
                    gapComposer3.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    gapComposer3.useNode();
                }
                Stack.m295setimpl(gapComposer3, rowMeasurePolicy, composeUiNode$Companion$SetModifier$1);
                Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
                ImageAnalysis$$ExternalSyntheticLambda1.m(i6, gapComposer3, composeUiNode$Companion$SetModifier$3, gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$1);
                Stack.m295setimpl(gapComposer3, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
                str2 = null;
                zzjp.m820ProfileAvataruFdPcIQ(null, 48, str3, gapComposer3, 48);
                z3 = false;
                companion = companion2;
                i3 = 12;
                f = f2;
                z2 = z6;
                TextKt.m275TextNvy7gAk(profile.name, null, appColors.textPrimary, 0L, null, FontWeight.Bold, 0L, null, 0L, 0, false, 1, 0, ((MaterialTheme$Values) gapComposer3.consume(MaterialThemeKt._localMaterialTheme)).typography.titleLarge, gapComposer3, 1572864, 24576, 114618);
                gapComposer2 = gapComposer3;
                gapComposer2.end(true);
                gapComposer2.end(false);
            } else {
                f = f2;
                i3 = 12;
                z2 = z6;
                str2 = null;
                z3 = false;
                gapComposer3.startReplaceGroup(328942209);
                zzjp.m820ProfileAvataruFdPcIQ(null, 80, str3, gapComposer3, 48);
                OffsetKt.Spacer(gapComposer3, SizeKt.m135height3ABfNKs(companion2, 12));
                companion = companion2;
                TextKt.m275TextNvy7gAk(profile.name, null, appColors.textPrimary, 0L, null, FontWeight.Bold, 0L, null, 0L, 0, false, 1, 0, ((MaterialTheme$Values) gapComposer3.consume(MaterialThemeKt._localMaterialTheme)).typography.titleLarge, gapComposer3, 1572864, 24576, 114618);
                gapComposer2 = gapComposer3;
                gapComposer2.end(false);
            }
            String str4 = profile.announce;
            if (str4 != null && !StringsKt.isBlank(str4)) {
                str2 = str4;
            }
            if (str2 != null) {
                gapComposer2.startReplaceGroup(329415858);
                float f4 = i3;
                OffsetKt.Spacer(gapComposer2, SizeKt.m135height3ABfNKs(companion, f4));
                hazeState2 = hazeState;
                z4 = z;
                AnnounceCard(str2, hazeState2, z4, gapComposer2, ((i4 >> 18) & 112) | ((i4 >> 21) & 896));
                OffsetKt.Spacer(gapComposer2, SizeKt.m135height3ABfNKs(companion, f4));
                gapComposer2.end(z3);
            } else {
                hazeState2 = hazeState;
                z4 = z;
                gapComposer2.startReplaceGroup(329591659);
                OffsetKt.Spacer(gapComposer2, SizeKt.m135height3ABfNKs(companion, 20));
                gapComposer2.end(z3);
            }
            TrafficDaysCard(profile, hazeState2, z4, gapComposer2, (i4 & 14) | ((i4 >> 18) & 112) | ((i4 >> 21) & 896));
            if (z4) {
                gapComposer2.startReplaceGroup(329744427);
                OffsetKt.Spacer(gapComposer2, SizeKt.m135height3ABfNKs(companion, i3));
                gapComposer2.end(z3);
            } else {
                gapComposer2.startReplaceGroup(329803854);
                OffsetKt.Spacer(gapComposer2, Modifier.CC.weight$default(companion));
                gapComposer2.end(z3);
            }
            int i7 = i4 >> 3;
            int i8 = i4 >> 9;
            int i9 = i4 >> 12;
            int i10 = i9 & 7168;
            int i11 = (i4 >> 15) & 57344;
            gapComposer3 = gapComposer2;
            HazeState hazeState3 = hazeState2;
            boolean z7 = z4;
            float f5 = f;
            int i12 = i3;
            Modifier.Companion companion3 = companion;
            StatusAndControl(controlButtonState, function0, function1, hazeState3, z7, gapComposer3, (i7 & 14) | (i8 & 112) | (i8 & 896) | i10 | i11);
            OffsetKt.Spacer(gapComposer3, SizeKt.m135height3ABfNKs(companion3, 8));
            ConnectionTimer(z2, l, gapComposer3, i7 & 112);
            if (z) {
                gapComposer3.startReplaceGroup(330235467);
                OffsetKt.Spacer(gapComposer3, SizeKt.m135height3ABfNKs(companion3, i12));
                gapComposer3.end(false);
            } else {
                gapComposer3.startReplaceGroup(330294894);
                OffsetKt.Spacer(gapComposer3, Modifier.CC.weight$default(companion3));
                gapComposer3.end(false);
            }
            ProxyBar(z2, str, function2, hazeState, z, gapComposer3, ((i4 >> 6) & 112) | (i9 & 896) | i10 | i11);
            OffsetKt.Spacer(gapComposer3, SizeKt.m135height3ABfNKs(companion3, f5));
            gapComposer3.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer3.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.github.kr328.clash.compose.home.HomeScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    HomeScreenKt.HomeContent(profile, controlButtonState, l, str, function0, function1, function2, hazeState, modifier, z, (GapComposer) obj, Stack.updateChangedFlags(i | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:103:0x030e  */
    /* JADX WARN: Code duplicated, block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x008b  */
    /* JADX WARN: Code duplicated, block: B:45:0x008e  */
    /* JADX WARN: Code duplicated, block: B:48:0x0092  */
    /* JADX WARN: Code duplicated, block: B:49:0x0095  */
    /* JADX WARN: Code duplicated, block: B:52:0x009d  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:58:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:59:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:62:0x0113  */
    /* JADX WARN: Code duplicated, block: B:63:0x0117  */
    /* JADX WARN: Code duplicated, block: B:66:0x0143 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:67:0x0145  */
    /* JADX WARN: Code duplicated, block: B:68:0x0149  */
    /* JADX WARN: Code duplicated, block: B:70:0x0183  */
    /* JADX WARN: Code duplicated, block: B:73:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:75:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:76:0x01db  */
    /* JADX WARN: Code duplicated, block: B:78:0x0217  */
    /* JADX WARN: Code duplicated, block: B:80:0x0223  */
    /* JADX WARN: Code duplicated, block: B:81:0x0246  */
    /* JADX WARN: Code duplicated, block: B:83:0x0280  */
    /* JADX WARN: Code duplicated, block: B:84:0x0282  */
    /* JADX WARN: Code duplicated, block: B:87:0x028f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:88:0x0291  */
    /* JADX WARN: Code duplicated, block: B:91:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:92:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:95:0x02bd A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:96:0x02bf  */
    public static final void HomeScreen(Function0 function0, final Function0 function1, final Function0 function2, Function0 function3, PaddingValuesImpl paddingValuesImpl, Modifier modifier, HazeState hazeState, boolean z, GapComposer gapComposer, int i, int i2) {
        HazeState hazeState2;
        int i3;
        boolean z2;
        boolean z3;
        ViewModelStoreOwner current;
        CreationExtras defaultViewModelCreationExtras;
        HomeViewModel homeViewModel;
        MutableState mutableStateCollectAsState;
        MutableState mutableStateCollectAsState2;
        MutableState mutableStateCollectAsState3;
        MutableState mutableStateCollectAsState4;
        MutableState mutableStateCollectAsState5;
        boolean zIsInDarkTheme;
        HazeState hazeStateRememberHazeState;
        FillElement fillElement;
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1;
        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$1;
        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2;
        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3;
        OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1;
        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4;
        int i4;
        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$5;
        OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$2;
        HomeViewModel homeViewModel2;
        FillElement fillElement2;
        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$6;
        boolean z4;
        AppColors appColors;
        FillElement fillElement3;
        boolean z5;
        int i5;
        final HomeViewModel homeViewModel3;
        boolean z6;
        boolean z7;
        Object objRememberedValue;
        boolean z8;
        boolean z9;
        Object objRememberedValue2;
        boolean z10;
        Modifier modifier2;
        boolean z11;
        int i6;
        HazeState hazeState3;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(-1547085757);
        int i7 = (gapComposer2.changedInstance(function1) ? 32 : 16) | i | (gapComposer2.changedInstance(function2) ? 256 : 128);
        if ((i & 24576) == 0) {
            i7 |= gapComposer2.changed(paddingValuesImpl) ? 16384 : 8192;
        }
        int i8 = 196608 | i7;
        int i9 = i2 & 64;
        if (i9 != 0) {
            i3 = i7 | 1769472;
            hazeState2 = hazeState;
        } else {
            hazeState2 = hazeState;
            i3 = i8 | (gapComposer2.changed(hazeState2) ? 1048576 : 524288);
        }
        int i10 = i2 & 128;
        if (i10 == 0) {
            if ((12582912 & i) == 0) {
                z2 = z;
                i3 |= gapComposer2.changed(z2) ? 8388608 : 4194304;
            }
            if ((4793491 & i3) == 4793490 || !gapComposer2.getSkipping()) {
                if (i9 != 0) {
                    hazeState2 = null;
                }
                if (i10 != 0) {
                    z3 = false;
                } else {
                    z3 = z2;
                }
                current = LocalViewModelStoreOwner.getCurrent(gapComposer2);
                if (current == null) {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
                if (current instanceof HasDefaultViewModelProviderFactory) {
                    defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                } else {
                    defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                }
                homeViewModel = (HomeViewModel) ViewModelKt.viewModel(Reflection.getOrCreateKotlinClass(HomeViewModel.class), current, null, defaultViewModelCreationExtras, gapComposer2);
                mutableStateCollectAsState = Stack.collectAsState(homeViewModel.activeProfile, gapComposer2, 0);
                mutableStateCollectAsState2 = Stack.collectAsState(homeViewModel.loaded, gapComposer2, 0);
                mutableStateCollectAsState3 = Stack.collectAsState(homeViewModel.tunnelState, gapComposer2, 0);
                mutableStateCollectAsState4 = Stack.collectAsState(homeViewModel.currentProxy, gapComposer2, 0);
                mutableStateCollectAsState5 = Stack.collectAsState(homeViewModel.tunnelStartedAt, gapComposer2, 0);
                zIsInDarkTheme = zzjq.isInDarkTheme(gapComposer2);
                gapComposer2.startReplaceGroup(945323083);
                if (hazeState2 == null) {
                    hazeStateRememberHazeState = HazeKt.rememberHazeState(gapComposer2);
                } else {
                    hazeStateRememberHazeState = hazeState2;
                }
                gapComposer2.end(false);
                fillElement = SizeKt.FillWholeMaxSize;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                long j = gapComposer2.compositeKeyHashCode;
                int i11 = (int) (j ^ (j >>> 32));
                PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, fillElement);
                ComposeUiNode.Companion.getClass();
                layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                gapComposer2.startReusableNode();
                if (gapComposer2.inserting) {
                    gapComposer2.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    gapComposer2.useNode();
                }
                composeUiNode$Companion$SetModifier$1 = ComposeUiNode.Companion.SetMeasurePolicy;
                Stack.m295setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, composeUiNode$Companion$SetModifier$1);
                composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, composeUiNode$Companion$SetModifier$2);
                Integer numValueOf = Integer.valueOf(i11);
                composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
                Stack.m295setimpl(gapComposer2, numValueOf, composeUiNode$Companion$SetModifier$3);
                ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
                Stack.m294reconcileimpl(gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
                composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
                Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
                gapComposer2.startReplaceGroup(-1749700748);
                if (hazeState2 == null) {
                    if (zIsInDarkTheme) {
                        i6 = R.drawable.map_dark;
                    } else {
                        i6 = R.drawable.map_light;
                    }
                    ownerSnapshotObserver$onCommitAffectingLayout$2 = ownerSnapshotObserver$onCommitAffectingLayout$1;
                    fillElement2 = fillElement;
                    composeUiNode$Companion$SetModifier$6 = composeUiNode$Companion$SetModifier$2;
                    composeUiNode$Companion$SetModifier$5 = composeUiNode$Companion$SetModifier$4;
                    homeViewModel2 = homeViewModel;
                    i4 = i3;
                    z4 = false;
                    ImageKt.Image(PainterResources_androidKt.painterResource(i6, gapComposer2), null, fillElement.then(new HazeSourceElement(hazeStateRememberHazeState)), null, ContentScale.Companion.Crop, 0.0f, gapComposer, 24632, 104);
                    gapComposer2 = gapComposer;
                } else {
                    i4 = i3;
                    composeUiNode$Companion$SetModifier$5 = composeUiNode$Companion$SetModifier$4;
                    ownerSnapshotObserver$onCommitAffectingLayout$2 = ownerSnapshotObserver$onCommitAffectingLayout$1;
                    homeViewModel2 = homeViewModel;
                    fillElement2 = fillElement;
                    composeUiNode$Companion$SetModifier$6 = composeUiNode$Companion$SetModifier$2;
                    z4 = false;
                }
                gapComposer2.end(z4);
                appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
                if (((Boolean) mutableStateCollectAsState2.getValue()).booleanValue()) {
                    fillElement3 = fillElement2;
                    if (((Profile) mutableStateCollectAsState.getValue()) == null) {
                        gapComposer2.startReplaceGroup(-1749672377);
                        boolean z12 = z3;
                        EmptyHomeContent(function0, hazeStateRememberHazeState, z12, OffsetKt.padding(fillElement3, paddingValuesImpl), gapComposer2, 6 | ((i4 >> 15) & 896));
                        z5 = z12;
                        gapComposer2.end(false);
                        z10 = true;
                    } else {
                        z5 = z3;
                        i5 = i4;
                        gapComposer2.startReplaceGroup(1595024547);
                        Profile profile = (Profile) mutableStateCollectAsState.getValue();
                        ControlButtonState controlButtonState = (ControlButtonState) mutableStateCollectAsState3.getValue();
                        Long l = (Long) mutableStateCollectAsState5.getValue();
                        String str = (String) mutableStateCollectAsState4.getValue();
                        Modifier modifierPadding = OffsetKt.padding(fillElement3, paddingValuesImpl);
                        gapComposer2.startReplaceGroup(-1749656380);
                        homeViewModel3 = homeViewModel2;
                        boolean zChangedInstance = gapComposer2.changedInstance(homeViewModel3);
                        if ((i5 & 112) == 32) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        z7 = zChangedInstance | z6;
                        objRememberedValue = gapComposer2.rememberedValue();
                        NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
                        if (z7 || objRememberedValue == neverEqualPolicy) {
                            final int i12 = 0;
                            objRememberedValue = new Function0() { // from class: com.github.kr328.clash.compose.home.HomeScreenKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    switch (i12) {
                                        case 0:
                                            HomeViewModel homeViewModel4 = homeViewModel3;
                                            StateFlowImpl stateFlowImpl = homeViewModel4._tunnelState;
                                            if (stateFlowImpl.getValue() == ControlButtonState.Disconnected) {
                                                stateFlowImpl.updateState(null, ControlButtonState.Connecting);
                                                StandaloneCoroutine standaloneCoroutine = homeViewModel4.transitionWatchdog;
                                                if (standaloneCoroutine != null) {
                                                    standaloneCoroutine.cancel((CancellationException) null);
                                                }
                                                homeViewModel4.transitionWatchdog = JobKt.launch$default(androidx.lifecycle.ViewModelKt.getViewModelScope(homeViewModel4), null, new ThumbNode.AnonymousClass1(homeViewModel4, (Continuation) null, 20), 3);
                                            }
                                            function1.invoke();
                                            break;
                                        default:
                                            HomeViewModel homeViewModel5 = homeViewModel3;
                                            StateFlowImpl stateFlowImpl2 = homeViewModel5._tunnelState;
                                            if (stateFlowImpl2.getValue() == ControlButtonState.Connected) {
                                                stateFlowImpl2.updateState(null, ControlButtonState.Disconnecting);
                                                StandaloneCoroutine standaloneCoroutine2 = homeViewModel5.transitionWatchdog;
                                                if (standaloneCoroutine2 != null) {
                                                    standaloneCoroutine2.cancel((CancellationException) null);
                                                }
                                                homeViewModel5.transitionWatchdog = JobKt.launch$default(androidx.lifecycle.ViewModelKt.getViewModelScope(homeViewModel5), null, new ThumbNode.AnonymousClass1(homeViewModel5, (Continuation) null, 20), 3);
                                            }
                                            function1.invoke();
                                            break;
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        }
                        Function0 function4 = (Function0) objRememberedValue;
                        gapComposer2.end(false);
                        gapComposer2.startReplaceGroup(-1749652182);
                        boolean zChangedInstance2 = gapComposer2.changedInstance(homeViewModel3);
                        if ((i5 & 896) == 256) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        z9 = zChangedInstance2 | z8;
                        objRememberedValue2 = gapComposer2.rememberedValue();
                        if (z9 || objRememberedValue2 == neverEqualPolicy) {
                            final int i13 = 1;
                            objRememberedValue2 = new Function0() { // from class: com.github.kr328.clash.compose.home.HomeScreenKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    switch (i13) {
                                        case 0:
                                            HomeViewModel homeViewModel4 = homeViewModel3;
                                            StateFlowImpl stateFlowImpl = homeViewModel4._tunnelState;
                                            if (stateFlowImpl.getValue() == ControlButtonState.Disconnected) {
                                                stateFlowImpl.updateState(null, ControlButtonState.Connecting);
                                                StandaloneCoroutine standaloneCoroutine = homeViewModel4.transitionWatchdog;
                                                if (standaloneCoroutine != null) {
                                                    standaloneCoroutine.cancel((CancellationException) null);
                                                }
                                                homeViewModel4.transitionWatchdog = JobKt.launch$default(androidx.lifecycle.ViewModelKt.getViewModelScope(homeViewModel4), null, new ThumbNode.AnonymousClass1(homeViewModel4, (Continuation) null, 20), 3);
                                            }
                                            function2.invoke();
                                            break;
                                        default:
                                            HomeViewModel homeViewModel5 = homeViewModel3;
                                            StateFlowImpl stateFlowImpl2 = homeViewModel5._tunnelState;
                                            if (stateFlowImpl2.getValue() == ControlButtonState.Connected) {
                                                stateFlowImpl2.updateState(null, ControlButtonState.Disconnecting);
                                                StandaloneCoroutine standaloneCoroutine2 = homeViewModel5.transitionWatchdog;
                                                if (standaloneCoroutine2 != null) {
                                                    standaloneCoroutine2.cancel((CancellationException) null);
                                                }
                                                homeViewModel5.transitionWatchdog = JobKt.launch$default(androidx.lifecycle.ViewModelKt.getViewModelScope(homeViewModel5), null, new ThumbNode.AnonymousClass1(homeViewModel5, (Continuation) null, 20), 3);
                                            }
                                            function2.invoke();
                                            break;
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        }
                        gapComposer2.end(false);
                        GapComposer gapComposer3 = gapComposer2;
                        HomeContent(profile, controlButtonState, l, str, function4, (Function0) objRememberedValue2, function3, hazeStateRememberHazeState, modifierPadding, z5, gapComposer3, 1572864 | (1879048192 & (i5 << 6)));
                        gapComposer2 = gapComposer3;
                        gapComposer2.end(false);
                        z10 = true;
                    }
                } else {
                    gapComposer2.startReplaceGroup(-1749682348);
                    Modifier modifierPadding2 = OffsetKt.padding(fillElement2, paddingValuesImpl);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, z4);
                    long j2 = gapComposer2.compositeKeyHashCode;
                    int i14 = (int) (j2 ^ (j2 >>> 32));
                    PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer2, modifierPadding2);
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        gapComposer2.createNode(layoutNode$Companion$Constructor$1);
                    } else {
                        gapComposer2.useNode();
                    }
                    Stack.m295setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy2, composeUiNode$Companion$SetModifier$1);
                    Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$6);
                    ImageAnalysis$$ExternalSyntheticLambda1.m(i14, gapComposer2, composeUiNode$Companion$SetModifier$3, gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$2);
                    Stack.m295setimpl(gapComposer2, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$5);
                    ProgressIndicatorKt.m256CircularProgressIndicator4lLiAd8(null, appColors.textPrimary, 0.0f, 0L, 0, 0.0f, gapComposer, 0, 61);
                    gapComposer2 = gapComposer;
                    gapComposer2.end(true);
                    gapComposer2.end(false);
                    z10 = true;
                    z5 = z3;
                }
                gapComposer2.end(z10);
                modifier2 = Modifier.Companion.$$INSTANCE;
                z11 = z5;
            } else {
                gapComposer2.skipToGroupEnd();
                modifier2 = modifier;
                z11 = z2;
            }
            hazeState3 = hazeState2;
            recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new ButtonKt$$ExternalSyntheticLambda3(function0, function1, function2, function3, paddingValuesImpl, modifier2, hazeState3, z11, i, i2, 1);
            }
        }
        i3 |= 12582912;
        z2 = z;
        if ((4793491 & i3) == 4793490) {
            if (i9 != 0) {
                hazeState2 = null;
            }
            if (i10 != 0) {
                z3 = false;
            } else {
                z3 = z2;
            }
            current = LocalViewModelStoreOwner.getCurrent(gapComposer2);
            if (current == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            if (current instanceof HasDefaultViewModelProviderFactory) {
                defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
            } else {
                defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
            }
            homeViewModel = (HomeViewModel) ViewModelKt.viewModel(Reflection.getOrCreateKotlinClass(HomeViewModel.class), current, null, defaultViewModelCreationExtras, gapComposer2);
            mutableStateCollectAsState = Stack.collectAsState(homeViewModel.activeProfile, gapComposer2, 0);
            mutableStateCollectAsState2 = Stack.collectAsState(homeViewModel.loaded, gapComposer2, 0);
            mutableStateCollectAsState3 = Stack.collectAsState(homeViewModel.tunnelState, gapComposer2, 0);
            mutableStateCollectAsState4 = Stack.collectAsState(homeViewModel.currentProxy, gapComposer2, 0);
            mutableStateCollectAsState5 = Stack.collectAsState(homeViewModel.tunnelStartedAt, gapComposer2, 0);
            zIsInDarkTheme = zzjq.isInDarkTheme(gapComposer2);
            gapComposer2.startReplaceGroup(945323083);
            if (hazeState2 == null) {
                hazeStateRememberHazeState = HazeKt.rememberHazeState(gapComposer2);
            } else {
                hazeStateRememberHazeState = hazeState2;
            }
            gapComposer2.end(false);
            fillElement = SizeKt.FillWholeMaxSize;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            long j3 = gapComposer2.compositeKeyHashCode;
            int i15 = (int) (j3 ^ (j3 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope3 = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier3 = AbsoluteAlignment.materializeModifier(gapComposer2, fillElement);
            ComposeUiNode.Companion.getClass();
            layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer2.useNode();
            }
            composeUiNode$Companion$SetModifier$1 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m295setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy3, composeUiNode$Companion$SetModifier$1);
            composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope3, composeUiNode$Companion$SetModifier$2);
            Integer numValueOf2 = Integer.valueOf(i15);
            composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m295setimpl(gapComposer2, numValueOf2, composeUiNode$Companion$SetModifier$3);
            ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
            Stack.m294reconcileimpl(gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
            composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier3, composeUiNode$Companion$SetModifier$4);
            gapComposer2.startReplaceGroup(-1749700748);
            if (hazeState2 == null) {
                if (zIsInDarkTheme) {
                    i6 = R.drawable.map_dark;
                } else {
                    i6 = R.drawable.map_light;
                }
                ownerSnapshotObserver$onCommitAffectingLayout$2 = ownerSnapshotObserver$onCommitAffectingLayout$1;
                fillElement2 = fillElement;
                composeUiNode$Companion$SetModifier$6 = composeUiNode$Companion$SetModifier$2;
                composeUiNode$Companion$SetModifier$5 = composeUiNode$Companion$SetModifier$4;
                homeViewModel2 = homeViewModel;
                i4 = i3;
                z4 = false;
                ImageKt.Image(PainterResources_androidKt.painterResource(i6, gapComposer2), null, fillElement.then(new HazeSourceElement(hazeStateRememberHazeState)), null, ContentScale.Companion.Crop, 0.0f, gapComposer, 24632, 104);
                gapComposer2 = gapComposer;
            } else {
                i4 = i3;
                composeUiNode$Companion$SetModifier$5 = composeUiNode$Companion$SetModifier$4;
                ownerSnapshotObserver$onCommitAffectingLayout$2 = ownerSnapshotObserver$onCommitAffectingLayout$1;
                homeViewModel2 = homeViewModel;
                fillElement2 = fillElement;
                composeUiNode$Companion$SetModifier$6 = composeUiNode$Companion$SetModifier$2;
                z4 = false;
            }
            gapComposer2.end(z4);
            appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            if (((Boolean) mutableStateCollectAsState2.getValue()).booleanValue()) {
                gapComposer2.startReplaceGroup(-1749682348);
                Modifier modifierPadding3 = OffsetKt.padding(fillElement2, paddingValuesImpl);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, z4);
                long j4 = gapComposer2.compositeKeyHashCode;
                int i16 = (int) (j4 ^ (j4 >>> 32));
                PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope4 = gapComposer2.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier4 = AbsoluteAlignment.materializeModifier(gapComposer2, modifierPadding3);
                gapComposer2.startReusableNode();
                if (gapComposer2.inserting) {
                    gapComposer2.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    gapComposer2.useNode();
                }
                Stack.m295setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy4, composeUiNode$Companion$SetModifier$1);
                Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope4, composeUiNode$Companion$SetModifier$6);
                ImageAnalysis$$ExternalSyntheticLambda1.m(i16, gapComposer2, composeUiNode$Companion$SetModifier$3, gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$2);
                Stack.m295setimpl(gapComposer2, modifierMaterializeModifier4, composeUiNode$Companion$SetModifier$5);
                ProgressIndicatorKt.m256CircularProgressIndicator4lLiAd8(null, appColors.textPrimary, 0.0f, 0L, 0, 0.0f, gapComposer, 0, 61);
                gapComposer2 = gapComposer;
                gapComposer2.end(true);
                gapComposer2.end(false);
                z10 = true;
                z5 = z3;
            } else {
                fillElement3 = fillElement2;
                if (((Profile) mutableStateCollectAsState.getValue()) == null) {
                    gapComposer2.startReplaceGroup(-1749672377);
                    boolean z13 = z3;
                    EmptyHomeContent(function0, hazeStateRememberHazeState, z13, OffsetKt.padding(fillElement3, paddingValuesImpl), gapComposer2, 6 | ((i4 >> 15) & 896));
                    z5 = z13;
                    gapComposer2.end(false);
                    z10 = true;
                } else {
                    z5 = z3;
                    i5 = i4;
                    gapComposer2.startReplaceGroup(1595024547);
                    Profile profile2 = (Profile) mutableStateCollectAsState.getValue();
                    ControlButtonState controlButtonState2 = (ControlButtonState) mutableStateCollectAsState3.getValue();
                    Long l2 = (Long) mutableStateCollectAsState5.getValue();
                    String str2 = (String) mutableStateCollectAsState4.getValue();
                    Modifier modifierPadding4 = OffsetKt.padding(fillElement3, paddingValuesImpl);
                    gapComposer2.startReplaceGroup(-1749656380);
                    homeViewModel3 = homeViewModel2;
                    boolean zChangedInstance3 = gapComposer2.changedInstance(homeViewModel3);
                    if ((i5 & 112) == 32) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    z7 = zChangedInstance3 | z6;
                    objRememberedValue = gapComposer2.rememberedValue();
                    NeverEqualPolicy neverEqualPolicy2 = Composer$Companion.Empty;
                    if (z7) {
                        final int i17 = 0;
                        objRememberedValue = new Function0() { // from class: com.github.kr328.clash.compose.home.HomeScreenKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                switch (i17) {
                                    case 0:
                                        HomeViewModel homeViewModel4 = homeViewModel3;
                                        StateFlowImpl stateFlowImpl = homeViewModel4._tunnelState;
                                        if (stateFlowImpl.getValue() == ControlButtonState.Disconnected) {
                                            stateFlowImpl.updateState(null, ControlButtonState.Connecting);
                                            StandaloneCoroutine standaloneCoroutine = homeViewModel4.transitionWatchdog;
                                            if (standaloneCoroutine != null) {
                                                standaloneCoroutine.cancel((CancellationException) null);
                                            }
                                            homeViewModel4.transitionWatchdog = JobKt.launch$default(androidx.lifecycle.ViewModelKt.getViewModelScope(homeViewModel4), null, new ThumbNode.AnonymousClass1(homeViewModel4, (Continuation) null, 20), 3);
                                        }
                                        function1.invoke();
                                        break;
                                    default:
                                        HomeViewModel homeViewModel5 = homeViewModel3;
                                        StateFlowImpl stateFlowImpl2 = homeViewModel5._tunnelState;
                                        if (stateFlowImpl2.getValue() == ControlButtonState.Connected) {
                                            stateFlowImpl2.updateState(null, ControlButtonState.Disconnecting);
                                            StandaloneCoroutine standaloneCoroutine2 = homeViewModel5.transitionWatchdog;
                                            if (standaloneCoroutine2 != null) {
                                                standaloneCoroutine2.cancel((CancellationException) null);
                                            }
                                            homeViewModel5.transitionWatchdog = JobKt.launch$default(androidx.lifecycle.ViewModelKt.getViewModelScope(homeViewModel5), null, new ThumbNode.AnonymousClass1(homeViewModel5, (Continuation) null, 20), 3);
                                        }
                                        function1.invoke();
                                        break;
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    } else {
                        final int i18 = 0;
                        objRememberedValue = new Function0() { // from class: com.github.kr328.clash.compose.home.HomeScreenKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                switch (i18) {
                                    case 0:
                                        HomeViewModel homeViewModel4 = homeViewModel3;
                                        StateFlowImpl stateFlowImpl = homeViewModel4._tunnelState;
                                        if (stateFlowImpl.getValue() == ControlButtonState.Disconnected) {
                                            stateFlowImpl.updateState(null, ControlButtonState.Connecting);
                                            StandaloneCoroutine standaloneCoroutine = homeViewModel4.transitionWatchdog;
                                            if (standaloneCoroutine != null) {
                                                standaloneCoroutine.cancel((CancellationException) null);
                                            }
                                            homeViewModel4.transitionWatchdog = JobKt.launch$default(androidx.lifecycle.ViewModelKt.getViewModelScope(homeViewModel4), null, new ThumbNode.AnonymousClass1(homeViewModel4, (Continuation) null, 20), 3);
                                        }
                                        function1.invoke();
                                        break;
                                    default:
                                        HomeViewModel homeViewModel5 = homeViewModel3;
                                        StateFlowImpl stateFlowImpl2 = homeViewModel5._tunnelState;
                                        if (stateFlowImpl2.getValue() == ControlButtonState.Connected) {
                                            stateFlowImpl2.updateState(null, ControlButtonState.Disconnecting);
                                            StandaloneCoroutine standaloneCoroutine2 = homeViewModel5.transitionWatchdog;
                                            if (standaloneCoroutine2 != null) {
                                                standaloneCoroutine2.cancel((CancellationException) null);
                                            }
                                            homeViewModel5.transitionWatchdog = JobKt.launch$default(androidx.lifecycle.ViewModelKt.getViewModelScope(homeViewModel5), null, new ThumbNode.AnonymousClass1(homeViewModel5, (Continuation) null, 20), 3);
                                        }
                                        function1.invoke();
                                        break;
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    Function0 function5 = (Function0) objRememberedValue;
                    gapComposer2.end(false);
                    gapComposer2.startReplaceGroup(-1749652182);
                    boolean zChangedInstance4 = gapComposer2.changedInstance(homeViewModel3);
                    if ((i5 & 896) == 256) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    z9 = zChangedInstance4 | z8;
                    objRememberedValue2 = gapComposer2.rememberedValue();
                    if (z9) {
                        final int i19 = 1;
                        objRememberedValue2 = new Function0() { // from class: com.github.kr328.clash.compose.home.HomeScreenKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                switch (i19) {
                                    case 0:
                                        HomeViewModel homeViewModel4 = homeViewModel3;
                                        StateFlowImpl stateFlowImpl = homeViewModel4._tunnelState;
                                        if (stateFlowImpl.getValue() == ControlButtonState.Disconnected) {
                                            stateFlowImpl.updateState(null, ControlButtonState.Connecting);
                                            StandaloneCoroutine standaloneCoroutine = homeViewModel4.transitionWatchdog;
                                            if (standaloneCoroutine != null) {
                                                standaloneCoroutine.cancel((CancellationException) null);
                                            }
                                            homeViewModel4.transitionWatchdog = JobKt.launch$default(androidx.lifecycle.ViewModelKt.getViewModelScope(homeViewModel4), null, new ThumbNode.AnonymousClass1(homeViewModel4, (Continuation) null, 20), 3);
                                        }
                                        function2.invoke();
                                        break;
                                    default:
                                        HomeViewModel homeViewModel5 = homeViewModel3;
                                        StateFlowImpl stateFlowImpl2 = homeViewModel5._tunnelState;
                                        if (stateFlowImpl2.getValue() == ControlButtonState.Connected) {
                                            stateFlowImpl2.updateState(null, ControlButtonState.Disconnecting);
                                            StandaloneCoroutine standaloneCoroutine2 = homeViewModel5.transitionWatchdog;
                                            if (standaloneCoroutine2 != null) {
                                                standaloneCoroutine2.cancel((CancellationException) null);
                                            }
                                            homeViewModel5.transitionWatchdog = JobKt.launch$default(androidx.lifecycle.ViewModelKt.getViewModelScope(homeViewModel5), null, new ThumbNode.AnonymousClass1(homeViewModel5, (Continuation) null, 20), 3);
                                        }
                                        function2.invoke();
                                        break;
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    } else {
                        final int i110 = 1;
                        objRememberedValue2 = new Function0() { // from class: com.github.kr328.clash.compose.home.HomeScreenKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                switch (i110) {
                                    case 0:
                                        HomeViewModel homeViewModel4 = homeViewModel3;
                                        StateFlowImpl stateFlowImpl = homeViewModel4._tunnelState;
                                        if (stateFlowImpl.getValue() == ControlButtonState.Disconnected) {
                                            stateFlowImpl.updateState(null, ControlButtonState.Connecting);
                                            StandaloneCoroutine standaloneCoroutine = homeViewModel4.transitionWatchdog;
                                            if (standaloneCoroutine != null) {
                                                standaloneCoroutine.cancel((CancellationException) null);
                                            }
                                            homeViewModel4.transitionWatchdog = JobKt.launch$default(androidx.lifecycle.ViewModelKt.getViewModelScope(homeViewModel4), null, new ThumbNode.AnonymousClass1(homeViewModel4, (Continuation) null, 20), 3);
                                        }
                                        function2.invoke();
                                        break;
                                    default:
                                        HomeViewModel homeViewModel5 = homeViewModel3;
                                        StateFlowImpl stateFlowImpl2 = homeViewModel5._tunnelState;
                                        if (stateFlowImpl2.getValue() == ControlButtonState.Connected) {
                                            stateFlowImpl2.updateState(null, ControlButtonState.Disconnecting);
                                            StandaloneCoroutine standaloneCoroutine2 = homeViewModel5.transitionWatchdog;
                                            if (standaloneCoroutine2 != null) {
                                                standaloneCoroutine2.cancel((CancellationException) null);
                                            }
                                            homeViewModel5.transitionWatchdog = JobKt.launch$default(androidx.lifecycle.ViewModelKt.getViewModelScope(homeViewModel5), null, new ThumbNode.AnonymousClass1(homeViewModel5, (Continuation) null, 20), 3);
                                        }
                                        function2.invoke();
                                        break;
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    gapComposer2.end(false);
                    GapComposer gapComposer4 = gapComposer2;
                    HomeContent(profile2, controlButtonState2, l2, str2, function5, (Function0) objRememberedValue2, function3, hazeStateRememberHazeState, modifierPadding4, z5, gapComposer4, 1572864 | (1879048192 & (i5 << 6)));
                    gapComposer2 = gapComposer4;
                    gapComposer2.end(false);
                    z10 = true;
                }
            }
            gapComposer2.end(z10);
            modifier2 = Modifier.Companion.$$INSTANCE;
            z11 = z5;
        } else {
            if (i9 != 0) {
                hazeState2 = null;
            }
            if (i10 != 0) {
                z3 = false;
            } else {
                z3 = z2;
            }
            current = LocalViewModelStoreOwner.getCurrent(gapComposer2);
            if (current == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            if (current instanceof HasDefaultViewModelProviderFactory) {
                defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
            } else {
                defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
            }
            homeViewModel = (HomeViewModel) ViewModelKt.viewModel(Reflection.getOrCreateKotlinClass(HomeViewModel.class), current, null, defaultViewModelCreationExtras, gapComposer2);
            mutableStateCollectAsState = Stack.collectAsState(homeViewModel.activeProfile, gapComposer2, 0);
            mutableStateCollectAsState2 = Stack.collectAsState(homeViewModel.loaded, gapComposer2, 0);
            mutableStateCollectAsState3 = Stack.collectAsState(homeViewModel.tunnelState, gapComposer2, 0);
            mutableStateCollectAsState4 = Stack.collectAsState(homeViewModel.currentProxy, gapComposer2, 0);
            mutableStateCollectAsState5 = Stack.collectAsState(homeViewModel.tunnelStartedAt, gapComposer2, 0);
            zIsInDarkTheme = zzjq.isInDarkTheme(gapComposer2);
            gapComposer2.startReplaceGroup(945323083);
            if (hazeState2 == null) {
                hazeStateRememberHazeState = HazeKt.rememberHazeState(gapComposer2);
            } else {
                hazeStateRememberHazeState = hazeState2;
            }
            gapComposer2.end(false);
            fillElement = SizeKt.FillWholeMaxSize;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            long j5 = gapComposer2.compositeKeyHashCode;
            int i111 = (int) (j5 ^ (j5 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope5 = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier5 = AbsoluteAlignment.materializeModifier(gapComposer2, fillElement);
            ComposeUiNode.Companion.getClass();
            layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer2.useNode();
            }
            composeUiNode$Companion$SetModifier$1 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m295setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy5, composeUiNode$Companion$SetModifier$1);
            composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope5, composeUiNode$Companion$SetModifier$2);
            Integer numValueOf3 = Integer.valueOf(i111);
            composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m295setimpl(gapComposer2, numValueOf3, composeUiNode$Companion$SetModifier$3);
            ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
            Stack.m294reconcileimpl(gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
            composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier5, composeUiNode$Companion$SetModifier$4);
            gapComposer2.startReplaceGroup(-1749700748);
            if (hazeState2 == null) {
                if (zIsInDarkTheme) {
                    i6 = R.drawable.map_dark;
                } else {
                    i6 = R.drawable.map_light;
                }
                ownerSnapshotObserver$onCommitAffectingLayout$2 = ownerSnapshotObserver$onCommitAffectingLayout$1;
                fillElement2 = fillElement;
                composeUiNode$Companion$SetModifier$6 = composeUiNode$Companion$SetModifier$2;
                composeUiNode$Companion$SetModifier$5 = composeUiNode$Companion$SetModifier$4;
                homeViewModel2 = homeViewModel;
                i4 = i3;
                z4 = false;
                ImageKt.Image(PainterResources_androidKt.painterResource(i6, gapComposer2), null, fillElement.then(new HazeSourceElement(hazeStateRememberHazeState)), null, ContentScale.Companion.Crop, 0.0f, gapComposer, 24632, 104);
                gapComposer2 = gapComposer;
            } else {
                i4 = i3;
                composeUiNode$Companion$SetModifier$5 = composeUiNode$Companion$SetModifier$4;
                ownerSnapshotObserver$onCommitAffectingLayout$2 = ownerSnapshotObserver$onCommitAffectingLayout$1;
                homeViewModel2 = homeViewModel;
                fillElement2 = fillElement;
                composeUiNode$Companion$SetModifier$6 = composeUiNode$Companion$SetModifier$2;
                z4 = false;
            }
            gapComposer2.end(z4);
            appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            if (((Boolean) mutableStateCollectAsState2.getValue()).booleanValue()) {
                gapComposer2.startReplaceGroup(-1749682348);
                Modifier modifierPadding5 = OffsetKt.padding(fillElement2, paddingValuesImpl);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, z4);
                long j6 = gapComposer2.compositeKeyHashCode;
                int i112 = (int) (j6 ^ (j6 >>> 32));
                PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope6 = gapComposer2.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier6 = AbsoluteAlignment.materializeModifier(gapComposer2, modifierPadding5);
                gapComposer2.startReusableNode();
                if (gapComposer2.inserting) {
                    gapComposer2.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    gapComposer2.useNode();
                }
                Stack.m295setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy6, composeUiNode$Companion$SetModifier$1);
                Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope6, composeUiNode$Companion$SetModifier$6);
                ImageAnalysis$$ExternalSyntheticLambda1.m(i112, gapComposer2, composeUiNode$Companion$SetModifier$3, gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$2);
                Stack.m295setimpl(gapComposer2, modifierMaterializeModifier6, composeUiNode$Companion$SetModifier$5);
                ProgressIndicatorKt.m256CircularProgressIndicator4lLiAd8(null, appColors.textPrimary, 0.0f, 0L, 0, 0.0f, gapComposer, 0, 61);
                gapComposer2 = gapComposer;
                gapComposer2.end(true);
                gapComposer2.end(false);
                z10 = true;
                z5 = z3;
            } else {
                fillElement3 = fillElement2;
                if (((Profile) mutableStateCollectAsState.getValue()) == null) {
                    gapComposer2.startReplaceGroup(-1749672377);
                    boolean z14 = z3;
                    EmptyHomeContent(function0, hazeStateRememberHazeState, z14, OffsetKt.padding(fillElement3, paddingValuesImpl), gapComposer2, 6 | ((i4 >> 15) & 896));
                    z5 = z14;
                    gapComposer2.end(false);
                    z10 = true;
                } else {
                    z5 = z3;
                    i5 = i4;
                    gapComposer2.startReplaceGroup(1595024547);
                    Profile profile3 = (Profile) mutableStateCollectAsState.getValue();
                    ControlButtonState controlButtonState3 = (ControlButtonState) mutableStateCollectAsState3.getValue();
                    Long l3 = (Long) mutableStateCollectAsState5.getValue();
                    String str3 = (String) mutableStateCollectAsState4.getValue();
                    Modifier modifierPadding6 = OffsetKt.padding(fillElement3, paddingValuesImpl);
                    gapComposer2.startReplaceGroup(-1749656380);
                    homeViewModel3 = homeViewModel2;
                    boolean zChangedInstance5 = gapComposer2.changedInstance(homeViewModel3);
                    if ((i5 & 112) == 32) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    z7 = zChangedInstance5 | z6;
                    objRememberedValue = gapComposer2.rememberedValue();
                    NeverEqualPolicy neverEqualPolicy3 = Composer$Companion.Empty;
                    if (z7) {
                        final int i113 = 0;
                        objRememberedValue = new Function0() { // from class: com.github.kr328.clash.compose.home.HomeScreenKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                switch (i113) {
                                    case 0:
                                        HomeViewModel homeViewModel4 = homeViewModel3;
                                        StateFlowImpl stateFlowImpl = homeViewModel4._tunnelState;
                                        if (stateFlowImpl.getValue() == ControlButtonState.Disconnected) {
                                            stateFlowImpl.updateState(null, ControlButtonState.Connecting);
                                            StandaloneCoroutine standaloneCoroutine = homeViewModel4.transitionWatchdog;
                                            if (standaloneCoroutine != null) {
                                                standaloneCoroutine.cancel((CancellationException) null);
                                            }
                                            homeViewModel4.transitionWatchdog = JobKt.launch$default(androidx.lifecycle.ViewModelKt.getViewModelScope(homeViewModel4), null, new ThumbNode.AnonymousClass1(homeViewModel4, (Continuation) null, 20), 3);
                                        }
                                        function1.invoke();
                                        break;
                                    default:
                                        HomeViewModel homeViewModel5 = homeViewModel3;
                                        StateFlowImpl stateFlowImpl2 = homeViewModel5._tunnelState;
                                        if (stateFlowImpl2.getValue() == ControlButtonState.Connected) {
                                            stateFlowImpl2.updateState(null, ControlButtonState.Disconnecting);
                                            StandaloneCoroutine standaloneCoroutine2 = homeViewModel5.transitionWatchdog;
                                            if (standaloneCoroutine2 != null) {
                                                standaloneCoroutine2.cancel((CancellationException) null);
                                            }
                                            homeViewModel5.transitionWatchdog = JobKt.launch$default(androidx.lifecycle.ViewModelKt.getViewModelScope(homeViewModel5), null, new ThumbNode.AnonymousClass1(homeViewModel5, (Continuation) null, 20), 3);
                                        }
                                        function1.invoke();
                                        break;
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    } else {
                        final int i114 = 0;
                        objRememberedValue = new Function0() { // from class: com.github.kr328.clash.compose.home.HomeScreenKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                switch (i114) {
                                    case 0:
                                        HomeViewModel homeViewModel4 = homeViewModel3;
                                        StateFlowImpl stateFlowImpl = homeViewModel4._tunnelState;
                                        if (stateFlowImpl.getValue() == ControlButtonState.Disconnected) {
                                            stateFlowImpl.updateState(null, ControlButtonState.Connecting);
                                            StandaloneCoroutine standaloneCoroutine = homeViewModel4.transitionWatchdog;
                                            if (standaloneCoroutine != null) {
                                                standaloneCoroutine.cancel((CancellationException) null);
                                            }
                                            homeViewModel4.transitionWatchdog = JobKt.launch$default(androidx.lifecycle.ViewModelKt.getViewModelScope(homeViewModel4), null, new ThumbNode.AnonymousClass1(homeViewModel4, (Continuation) null, 20), 3);
                                        }
                                        function1.invoke();
                                        break;
                                    default:
                                        HomeViewModel homeViewModel5 = homeViewModel3;
                                        StateFlowImpl stateFlowImpl2 = homeViewModel5._tunnelState;
                                        if (stateFlowImpl2.getValue() == ControlButtonState.Connected) {
                                            stateFlowImpl2.updateState(null, ControlButtonState.Disconnecting);
                                            StandaloneCoroutine standaloneCoroutine2 = homeViewModel5.transitionWatchdog;
                                            if (standaloneCoroutine2 != null) {
                                                standaloneCoroutine2.cancel((CancellationException) null);
                                            }
                                            homeViewModel5.transitionWatchdog = JobKt.launch$default(androidx.lifecycle.ViewModelKt.getViewModelScope(homeViewModel5), null, new ThumbNode.AnonymousClass1(homeViewModel5, (Continuation) null, 20), 3);
                                        }
                                        function1.invoke();
                                        break;
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    Function0 function6 = (Function0) objRememberedValue;
                    gapComposer2.end(false);
                    gapComposer2.startReplaceGroup(-1749652182);
                    boolean zChangedInstance6 = gapComposer2.changedInstance(homeViewModel3);
                    if ((i5 & 896) == 256) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    z9 = zChangedInstance6 | z8;
                    objRememberedValue2 = gapComposer2.rememberedValue();
                    if (z9) {
                        final int i115 = 1;
                        objRememberedValue2 = new Function0() { // from class: com.github.kr328.clash.compose.home.HomeScreenKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                switch (i115) {
                                    case 0:
                                        HomeViewModel homeViewModel4 = homeViewModel3;
                                        StateFlowImpl stateFlowImpl = homeViewModel4._tunnelState;
                                        if (stateFlowImpl.getValue() == ControlButtonState.Disconnected) {
                                            stateFlowImpl.updateState(null, ControlButtonState.Connecting);
                                            StandaloneCoroutine standaloneCoroutine = homeViewModel4.transitionWatchdog;
                                            if (standaloneCoroutine != null) {
                                                standaloneCoroutine.cancel((CancellationException) null);
                                            }
                                            homeViewModel4.transitionWatchdog = JobKt.launch$default(androidx.lifecycle.ViewModelKt.getViewModelScope(homeViewModel4), null, new ThumbNode.AnonymousClass1(homeViewModel4, (Continuation) null, 20), 3);
                                        }
                                        function2.invoke();
                                        break;
                                    default:
                                        HomeViewModel homeViewModel5 = homeViewModel3;
                                        StateFlowImpl stateFlowImpl2 = homeViewModel5._tunnelState;
                                        if (stateFlowImpl2.getValue() == ControlButtonState.Connected) {
                                            stateFlowImpl2.updateState(null, ControlButtonState.Disconnecting);
                                            StandaloneCoroutine standaloneCoroutine2 = homeViewModel5.transitionWatchdog;
                                            if (standaloneCoroutine2 != null) {
                                                standaloneCoroutine2.cancel((CancellationException) null);
                                            }
                                            homeViewModel5.transitionWatchdog = JobKt.launch$default(androidx.lifecycle.ViewModelKt.getViewModelScope(homeViewModel5), null, new ThumbNode.AnonymousClass1(homeViewModel5, (Continuation) null, 20), 3);
                                        }
                                        function2.invoke();
                                        break;
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    } else {
                        final int i116 = 1;
                        objRememberedValue2 = new Function0() { // from class: com.github.kr328.clash.compose.home.HomeScreenKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                switch (i116) {
                                    case 0:
                                        HomeViewModel homeViewModel4 = homeViewModel3;
                                        StateFlowImpl stateFlowImpl = homeViewModel4._tunnelState;
                                        if (stateFlowImpl.getValue() == ControlButtonState.Disconnected) {
                                            stateFlowImpl.updateState(null, ControlButtonState.Connecting);
                                            StandaloneCoroutine standaloneCoroutine = homeViewModel4.transitionWatchdog;
                                            if (standaloneCoroutine != null) {
                                                standaloneCoroutine.cancel((CancellationException) null);
                                            }
                                            homeViewModel4.transitionWatchdog = JobKt.launch$default(androidx.lifecycle.ViewModelKt.getViewModelScope(homeViewModel4), null, new ThumbNode.AnonymousClass1(homeViewModel4, (Continuation) null, 20), 3);
                                        }
                                        function2.invoke();
                                        break;
                                    default:
                                        HomeViewModel homeViewModel5 = homeViewModel3;
                                        StateFlowImpl stateFlowImpl2 = homeViewModel5._tunnelState;
                                        if (stateFlowImpl2.getValue() == ControlButtonState.Connected) {
                                            stateFlowImpl2.updateState(null, ControlButtonState.Disconnecting);
                                            StandaloneCoroutine standaloneCoroutine2 = homeViewModel5.transitionWatchdog;
                                            if (standaloneCoroutine2 != null) {
                                                standaloneCoroutine2.cancel((CancellationException) null);
                                            }
                                            homeViewModel5.transitionWatchdog = JobKt.launch$default(androidx.lifecycle.ViewModelKt.getViewModelScope(homeViewModel5), null, new ThumbNode.AnonymousClass1(homeViewModel5, (Continuation) null, 20), 3);
                                        }
                                        function2.invoke();
                                        break;
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        gapComposer2.updateRememberedValue(objRememberedValue2);
                    }
                    gapComposer2.end(false);
                    GapComposer gapComposer5 = gapComposer2;
                    HomeContent(profile3, controlButtonState3, l3, str3, function6, (Function0) objRememberedValue2, function3, hazeStateRememberHazeState, modifierPadding6, z5, gapComposer5, 1572864 | (1879048192 & (i5 << 6)));
                    gapComposer2 = gapComposer5;
                    gapComposer2.end(false);
                    z10 = true;
                }
            }
            gapComposer2.end(z10);
            modifier2 = Modifier.Companion.$$INSTANCE;
            z11 = z5;
        }
        hazeState3 = hazeState2;
        recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ButtonKt$$ExternalSyntheticLambda3(function0, function1, function2, function3, paddingValuesImpl, modifier2, hazeState3, z11, i, i2, 1);
        }
    }

    public static final void ProxyBar(boolean z, String str, Function0 function0, HazeState hazeState, boolean z2, GapComposer gapComposer, int i) {
        int i2;
        gapComposer.startRestartGroup(1594235818);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changed(hazeState) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer.changed(z2) ? 16384 : 8192;
        }
        if ((i2 & 9363) == 9362 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            gapComposer.startReplaceGroup(-1395517825);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            gapComposer.end(false);
            State stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, ArcSplineKt.tween$default(300, 6, null), "proxy-bar-alpha", gapComposer, 3120);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierAlpha = ClipKt.alpha(SizeKt.m135height3ABfNKs(z2 ? SizeKt.fillMaxWidth(companion, 0.4f) : SizeKt.fillMaxWidth(companion, 1.0f), z2 ? 46 : 56), ((Number) stateAnimateFloatAsState.getValue()).floatValue());
            gapComposer.startReplaceGroup(-1395504327);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new TooltipKt$$ExternalSyntheticLambda7(mutableState, 18);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            gapComposer.end(false);
            Modifier modifierOnFocusChanged = FocusTraversalKt.onFocusChanged(modifierAlpha, (Function1) objRememberedValue2);
            float f = ((Boolean) mutableState.getValue()).booleanValue() ? 2 : 0;
            long j = ((Boolean) mutableState.getValue()).booleanValue() ? Color.White : Color.Transparent;
            float f2 = 12;
            zzjl.m819GlassSurfaceYxtnGt4(ImageKt.m48borderxT4_qwU(f, j, modifierOnFocusChanged, RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(f2)), f2, hazeState, Thread_jvmKt.rememberComposableLambda(1803456141, new AnonymousClass2(z, function0, str, appColors), gapComposer), gapComposer, 196656 | ((i2 << 3) & 57344), 12);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new FilesScreenKt$$ExternalSyntheticLambda4(z, str, function0, hazeState, z2, i);
        }
    }

    public static final void StatusAndControl(final ControlButtonState controlButtonState, final Function0 function0, final Function0 function1, final HazeState hazeState, final boolean z, GapComposer gapComposer, final int i) {
        Object obj;
        int i2;
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(62828848);
        if ((i & 6) == 0) {
            obj = controlButtonState;
            i2 = (gapComposer2.changed(obj) ? 4 : 2) | i;
        } else {
            obj = controlButtonState;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer2.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer2.changedInstance(function1) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer2.changed(hazeState) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer2.changed(z) ? 16384 : 8192;
        }
        int i3 = i2;
        if ((i3 & 9363) == 9362 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.CenterHorizontally, gapComposer2, 48);
            long j = gapComposer2.compositeKeyHashCode;
            int i4 = (int) (j ^ (j >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, companion);
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer2.useNode();
            }
            Stack.m295setimpl(gapComposer2, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m295setimpl(gapComposer2, Integer.valueOf(i4), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m294reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            gapComposer2.startReplaceGroup(-918599844);
            Object objRememberedValue = gapComposer2.rememberedValue();
            if (objRememberedValue == Composer$Companion.Empty) {
                objRememberedValue = new AsyncImagePainter$$ExternalSyntheticLambda0(21);
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            gapComposer2.end(false);
            AnimatedContentKt.AnimatedContent(obj, null, (Function1) objRememberedValue, Alignment.Companion.Center, "status-text", null, Thread_jvmKt.rememberComposableLambda(98737889, new HomeScreenKt$StatusAndControl$1$2(0, appColors), gapComposer2), gapComposer, (i3 & 14) | 1600896, 34);
            gapComposer2 = gapComposer;
            OffsetKt.Spacer(gapComposer2, SizeKt.m135height3ABfNKs(companion, 12));
            int i5 = i3 << 3;
            zzjk.ControlButton(controlButtonState, function0, function1, null, hazeState, z, gapComposer2, (i3 & 1022) | (57344 & i5) | (i5 & 458752));
            gapComposer2.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.github.kr328.clash.compose.home.HomeScreenKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    ((Integer) obj3).getClass();
                    HomeScreenKt.StatusAndControl(controlButtonState, function0, function1, hazeState, z, (GapComposer) obj2, Stack.updateChangedFlags(i | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void TrafficColumn(String str, ComposableLambdaImpl composableLambdaImpl, Modifier modifier, GapComposer gapComposer, int i) {
        GapComposer gapComposer2;
        Function2 function2;
        gapComposer.startRestartGroup(-613905561);
        int i2 = i | (gapComposer.changed(str) ? 4 : 2) | (gapComposer.changed(modifier) ? 256 : 128);
        if ((i2 & 147) == 146 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
            function2 = composableLambdaImpl;
            gapComposer2 = gapComposer;
        } else {
            AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Center, Alignment.Companion.CenterHorizontally, gapComposer, 54);
            long j = gapComposer.compositeKeyHashCode;
            int i3 = (int) (j ^ (j >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifier);
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer.useNode();
            }
            Stack.m295setimpl(gapComposer, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m295setimpl(gapComposer, Integer.valueOf(i3), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m294reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m295setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            TextKt.m275TextNvy7gAk(str, null, appColors.textSecondary, 0L, null, FontWeight.Medium, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.bodySmall, gapComposer, (i2 & 14) | 1572864, 0, 131002);
            gapComposer2 = gapComposer;
            OffsetKt.Spacer(gapComposer2, SizeKt.m135height3ABfNKs(Modifier.Companion.$$INSTANCE, 4));
            function2 = composableLambdaImpl;
            function2.invoke(gapComposer2, 6);
            gapComposer2.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MenuKt$$ExternalSyntheticLambda1(str, function2, modifier, i, 9);
        }
    }

    public static final void TrafficDaysCard(Profile profile, HazeState hazeState, boolean z, GapComposer gapComposer, int i) {
        int i2;
        gapComposer.startRestartGroup(-815518773);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changedInstance(profile) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(hazeState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changed(z) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            zzjl.m819GlassSurfaceYxtnGt4(z ? SizeKt.m135height3ABfNKs(SizeKt.fillMaxWidth(companion, 0.4f), 52) : SizeKt.m135height3ABfNKs(SizeKt.fillMaxWidth(companion, 1.0f), 70), 12, hazeState, Thread_jvmKt.rememberComposableLambda(2126597742, new AnonymousClass1(appColors, z, profile), gapComposer), gapComposer, 196656 | ((i2 << 9) & 57344), 12);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new HomeScreenKt$$ExternalSyntheticLambda5(profile, hazeState, z, i, 0);
        }
    }
}
