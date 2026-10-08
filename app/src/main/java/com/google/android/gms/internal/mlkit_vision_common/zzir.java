package com.google.android.gms.internal.mlkit_vision_common;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.camera.core.AspectRatio;
import androidx.camera.core.impl.Quirks;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.Scale;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.EasingFunctionsKt;
import androidx.compose.foundation.FocusableNode;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.icons.outlined.ContentPasteKt;
import androidx.compose.material.icons.outlined.DescriptionKt;
import androidx.compose.material.icons.outlined.QrCodeScannerKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.SheetState;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.DelegatingSoftwareKeyboardController;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.github.kr328.clash.FilesActivity$showError$1;
import com.github.kr328.clash.common.compat.TvKt;
import com.github.kr328.clash.compose.AppCrashedScreenKt;
import com.github.kr328.clash.compose.HwidLimitDialogKt;
import com.github.kr328.clash.compose.LogsScreenKt;
import com.github.kr328.clash.compose.LogsScreenKt$$ExternalSyntheticLambda5;
import com.github.kr328.clash.compose.newprofile.NewProfileViewModel;
import com.github.kr328.clash.compose.proxy.ProxyScreenKt$$ExternalSyntheticLambda2;
import com.github.kr328.clash.compose.proxy.ProxyViewModel;
import com.github.kr328.clash.compose.qrcode.TvQrCodeSheetKt$$ExternalSyntheticLambda0;
import com.github.kr328.clash.compose.qrcode.TvQrCodeSheetKt$$ExternalSyntheticLambda3;
import com.github.kr328.clash.compose.util.TvGlassTabRowKt$$ExternalSyntheticLambda8;
import com.github.kr328.clash.design.compose.theme.AppColors;
import com.github.kr328.clash.design.compose.theme.AppColorsKt;
import com.github.kr328.clash.service.HwidLimitMarker;
import com.google.android.gms.internal.mlkit_vision_common.zzir;
import com.koala.clash.R;
import io.github.g00fy2.quickie.QRResult;
import io.github.g00fy2.quickie.ScanQRCode;
import io.github.g00fy2.quickie.content.QRContent;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.InterruptibleKt$runInterruptible$2;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobKt__JobKt$invokeOnCompletion$1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzir {
    /* JADX WARN: Multi-variable type inference failed */
    public static final void LinkInputRow(String str, Function1 function1, boolean z, Function0 function0, Function0 function2, Function0 function3, GapComposer gapComposer, int i) {
        final Function0 function4;
        final Function0 function5;
        Modifier.Companion companion;
        boolean z2;
        final Function0 function6;
        boolean z3;
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(818256434);
        int i2 = i | (gapComposer2.changed(str) ? 4 : 2) | (gapComposer2.changedInstance(function1) ? 32 : 16) | (gapComposer2.changed(z) ? 256 : 128) | (gapComposer2.changedInstance(function0) ? 2048 : 1024) | (gapComposer2.changedInstance(function2) ? 16384 : 8192) | (gapComposer2.changedInstance(function3) ? 131072 : 65536);
        if ((74899 & i2) == 74898 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
            function4 = function0;
            function5 = function2;
            function6 = function3;
        } else {
            AppColors appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            float f = 12;
            RoundedCornerShape roundedCornerShapeM158RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(f);
            final SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) gapComposer2.consume(CompositionLocalsKt.LocalSoftwareKeyboardController);
            Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
            Modifier modifierM129paddingVpY3zN4 = OffsetKt.m129paddingVpY3zN4(ImageKt.m48borderxT4_qwU(1, appColors.cardBorder, ImageKt.m47backgroundbw27NRU(ClipKt.clip(SizeKt.fillMaxWidth(companion2, 1.0f), roundedCornerShapeM158RoundedCornerShape0680j_4), appColors.cardBackground, BrushKt.RectangleShape), roundedCornerShapeM158RoundedCornerShape0680j_4), 20, 14);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.CenterVertically, gapComposer2, 48);
            long j = gapComposer2.compositeKeyHashCode;
            int i3 = (int) (j ^ (j >>> 32));
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
            Stack.m295setimpl(gapComposer2, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m295setimpl(gapComposer2, Integer.valueOf(i3), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m294reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            TextStyle textStyle = new TextStyle(appColors.textPrimary, TextUnitKt.getSp(16), FontWeight.Medium, 0L, 0, 0L, 16777208);
            SolidColor solidColor = new SolidColor(appColors.textPrimary);
            KeyboardOptions keyboardOptions = new KeyboardOptions(5, 115);
            if (1.0f <= 0.0d) {
                InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
            }
            BasicTextFieldKt.BasicTextField(str, function1, OffsetKt.m132paddingqDBjuR0$default(new LayoutWeightElement(1.0f, true), 0.0f, 0.0f, f, 0.0f, 11), z, textStyle, keyboardOptions, null, true, 0, 0, null, null, null, solidColor, Thread_jvmKt.rememberComposableLambda(1446972977, new AppCrashedScreenKt.AnonymousClass2(str, appColors), gapComposer2), gapComposer2, (i2 & 14) | 102236160 | (i2 & 112) | ((i2 << 3) & 7168), 16016);
            gapComposer2 = gapComposer2;
            ImageVector contentPaste = ContentPasteKt.getContentPaste();
            String strStringResource = StringResources_androidKt.stringResource(R.string.import_from_clipboard, gapComposer2);
            gapComposer2.startReplaceGroup(528531499);
            boolean z4 = false;
            Object[] objArr = 0;
            boolean zChanged = gapComposer2.changed(softwareKeyboardController) | ((i2 & 7168) == 2048);
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (zChanged || objRememberedValue == neverEqualPolicy) {
                function4 = function0;
                final Object[] objArr2 = objArr == true ? 1 : 0;
                objRememberedValue = new Function0() { // from class: com.github.kr328.clash.compose.newprofile.NewProfileSheetKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        switch (objArr2) {
                            case 0:
                                SoftwareKeyboardController softwareKeyboardController2 = softwareKeyboardController;
                                if (softwareKeyboardController2 != null) {
                                    ((DelegatingSoftwareKeyboardController) softwareKeyboardController2).hide();
                                }
                                function4.invoke();
                                break;
                            case 1:
                                SoftwareKeyboardController softwareKeyboardController3 = softwareKeyboardController;
                                if (softwareKeyboardController3 != null) {
                                    ((DelegatingSoftwareKeyboardController) softwareKeyboardController3).hide();
                                }
                                function4.invoke();
                                break;
                            default:
                                SoftwareKeyboardController softwareKeyboardController4 = softwareKeyboardController;
                                if (softwareKeyboardController4 != null) {
                                    ((DelegatingSoftwareKeyboardController) softwareKeyboardController4).hide();
                                }
                                function4.invoke();
                                break;
                        }
                        return Unit.INSTANCE;
                    }
                };
                gapComposer2.updateRememberedValue(objRememberedValue);
            } else {
                function4 = function0;
            }
            gapComposer2.end(false);
            int i4 = i2 & 896;
            TrailingIconButton(contentPaste, strStringResource, z, (Function0) objRememberedValue, gapComposer2, i4);
            gapComposer2.startReplaceGroup(528535147);
            function5 = function2;
            if (function5 != null) {
                companion = companion2;
                OffsetKt.Spacer(gapComposer2, SizeKt.m144width3ABfNKs(companion, 8));
                ImageVector imageVectorBuild = QrCodeScannerKt._qrCodeScanner;
                if (imageVectorBuild == null) {
                    ImageVector.Builder builder = new ImageVector.Builder("Outlined.QrCodeScanner", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                    int i5 = VectorKt.$r8$clinit;
                    SolidColor solidColor2 = new SolidColor(Color.Black);
                    Quirks quirks = new Quirks();
                    quirks.moveTo(9.5f, 6.5f);
                    quirks.verticalLineToRelative(3.0f);
                    quirks.horizontalLineToRelative(-3.0f);
                    quirks.verticalLineToRelative(-3.0f);
                    quirks.horizontalLineTo(9.5f);
                    quirks.moveTo(11.0f, 5.0f);
                    quirks.horizontalLineTo(5.0f);
                    quirks.verticalLineToRelative(6.0f);
                    quirks.horizontalLineToRelative(6.0f);
                    quirks.verticalLineTo(5.0f);
                    quirks.lineTo(11.0f, 5.0f);
                    quirks.close();
                    quirks.moveTo(9.5f, 14.5f);
                    quirks.verticalLineToRelative(3.0f);
                    quirks.horizontalLineToRelative(-3.0f);
                    quirks.verticalLineToRelative(-3.0f);
                    quirks.horizontalLineTo(9.5f);
                    quirks.moveTo(11.0f, 13.0f);
                    quirks.horizontalLineTo(5.0f);
                    quirks.verticalLineToRelative(6.0f);
                    quirks.horizontalLineToRelative(6.0f);
                    quirks.verticalLineTo(13.0f);
                    quirks.lineTo(11.0f, 13.0f);
                    quirks.close();
                    quirks.moveTo(17.5f, 6.5f);
                    quirks.verticalLineToRelative(3.0f);
                    quirks.horizontalLineToRelative(-3.0f);
                    quirks.verticalLineToRelative(-3.0f);
                    quirks.horizontalLineTo(17.5f);
                    quirks.moveTo(19.0f, 5.0f);
                    quirks.horizontalLineToRelative(-6.0f);
                    quirks.verticalLineToRelative(6.0f);
                    quirks.horizontalLineToRelative(6.0f);
                    quirks.verticalLineTo(5.0f);
                    quirks.lineTo(19.0f, 5.0f);
                    quirks.close();
                    quirks.moveTo(13.0f, 13.0f);
                    quirks.horizontalLineToRelative(1.5f);
                    quirks.verticalLineToRelative(1.5f);
                    quirks.horizontalLineTo(13.0f);
                    quirks.verticalLineTo(13.0f);
                    quirks.close();
                    quirks.moveTo(14.5f, 14.5f);
                    quirks.horizontalLineTo(16.0f);
                    quirks.verticalLineTo(16.0f);
                    quirks.horizontalLineToRelative(-1.5f);
                    quirks.verticalLineTo(14.5f);
                    quirks.close();
                    quirks.moveTo(16.0f, 13.0f);
                    quirks.horizontalLineToRelative(1.5f);
                    quirks.verticalLineToRelative(1.5f);
                    quirks.horizontalLineTo(16.0f);
                    quirks.verticalLineTo(13.0f);
                    quirks.close();
                    quirks.moveTo(13.0f, 16.0f);
                    quirks.horizontalLineToRelative(1.5f);
                    quirks.verticalLineToRelative(1.5f);
                    quirks.horizontalLineTo(13.0f);
                    quirks.verticalLineTo(16.0f);
                    quirks.close();
                    quirks.moveTo(14.5f, 17.5f);
                    quirks.horizontalLineTo(16.0f);
                    quirks.verticalLineTo(19.0f);
                    quirks.horizontalLineToRelative(-1.5f);
                    quirks.verticalLineTo(17.5f);
                    quirks.close();
                    quirks.moveTo(16.0f, 16.0f);
                    quirks.horizontalLineToRelative(1.5f);
                    quirks.verticalLineToRelative(1.5f);
                    quirks.horizontalLineTo(16.0f);
                    quirks.verticalLineTo(16.0f);
                    quirks.close();
                    quirks.moveTo(17.5f, 14.5f);
                    quirks.horizontalLineTo(19.0f);
                    quirks.verticalLineTo(16.0f);
                    quirks.horizontalLineToRelative(-1.5f);
                    quirks.verticalLineTo(14.5f);
                    quirks.close();
                    quirks.moveTo(17.5f, 17.5f);
                    quirks.horizontalLineTo(19.0f);
                    quirks.verticalLineTo(19.0f);
                    quirks.horizontalLineToRelative(-1.5f);
                    quirks.verticalLineTo(17.5f);
                    quirks.close();
                    quirks.moveTo(22.0f, 7.0f);
                    quirks.horizontalLineToRelative(-2.0f);
                    quirks.verticalLineTo(4.0f);
                    quirks.horizontalLineToRelative(-3.0f);
                    quirks.verticalLineTo(2.0f);
                    quirks.horizontalLineToRelative(5.0f);
                    quirks.verticalLineTo(7.0f);
                    quirks.close();
                    quirks.moveTo(22.0f, 22.0f);
                    quirks.verticalLineToRelative(-5.0f);
                    quirks.horizontalLineToRelative(-2.0f);
                    quirks.verticalLineToRelative(3.0f);
                    quirks.horizontalLineToRelative(-3.0f);
                    quirks.verticalLineToRelative(2.0f);
                    quirks.horizontalLineTo(22.0f);
                    quirks.close();
                    quirks.moveTo(2.0f, 22.0f);
                    quirks.horizontalLineToRelative(5.0f);
                    quirks.verticalLineToRelative(-2.0f);
                    quirks.horizontalLineTo(4.0f);
                    quirks.verticalLineToRelative(-3.0f);
                    quirks.horizontalLineTo(2.0f);
                    quirks.verticalLineTo(22.0f);
                    quirks.close();
                    quirks.moveTo(2.0f, 2.0f);
                    quirks.verticalLineToRelative(5.0f);
                    quirks.horizontalLineToRelative(2.0f);
                    quirks.verticalLineTo(4.0f);
                    quirks.horizontalLineToRelative(3.0f);
                    quirks.verticalLineTo(2.0f);
                    quirks.horizontalLineTo(2.0f);
                    quirks.close();
                    ImageVector.Builder.m502addPathoIyEayM$default(builder, quirks.mQuirks, solidColor2);
                    imageVectorBuild = builder.build();
                    QrCodeScannerKt._qrCodeScanner = imageVectorBuild;
                }
                String strStringResource2 = StringResources_androidKt.stringResource(R.string.import_from_qr, gapComposer2);
                gapComposer2.startReplaceGroup(528543864);
                boolean zChanged2 = gapComposer2.changed(softwareKeyboardController) | ((57344 & i2) == 16384);
                Object objRememberedValue2 = gapComposer2.rememberedValue();
                if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                    z2 = true;
                    final char c = 1 == true ? 1 : 0;
                    objRememberedValue2 = new Function0() { // from class: com.github.kr328.clash.compose.newprofile.NewProfileSheetKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            switch (c) {
                                case 0:
                                    SoftwareKeyboardController softwareKeyboardController2 = softwareKeyboardController;
                                    if (softwareKeyboardController2 != null) {
                                        ((DelegatingSoftwareKeyboardController) softwareKeyboardController2).hide();
                                    }
                                    function5.invoke();
                                    break;
                                case 1:
                                    SoftwareKeyboardController softwareKeyboardController3 = softwareKeyboardController;
                                    if (softwareKeyboardController3 != null) {
                                        ((DelegatingSoftwareKeyboardController) softwareKeyboardController3).hide();
                                    }
                                    function5.invoke();
                                    break;
                                default:
                                    SoftwareKeyboardController softwareKeyboardController4 = softwareKeyboardController;
                                    if (softwareKeyboardController4 != null) {
                                        ((DelegatingSoftwareKeyboardController) softwareKeyboardController4).hide();
                                    }
                                    function5.invoke();
                                    break;
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    gapComposer2.updateRememberedValue(objRememberedValue2);
                } else {
                    z2 = true;
                }
                z4 = false;
                gapComposer2.end(false);
                TrailingIconButton(imageVectorBuild, strStringResource2, z, (Function0) objRememberedValue2, gapComposer2, i4);
            } else {
                companion = companion2;
                z2 = true;
            }
            gapComposer2.end(z4);
            gapComposer2.startReplaceGroup(528548371);
            function6 = function3;
            if (function6 != null) {
                OffsetKt.Spacer(gapComposer2, SizeKt.m144width3ABfNKs(companion, 8));
                ImageVector description = DescriptionKt.getDescription();
                String strStringResource3 = StringResources_androidKt.stringResource(R.string.import_from_file, gapComposer2);
                gapComposer2.startReplaceGroup(528557212);
                boolean zChanged3 = gapComposer2.changed(softwareKeyboardController) | ((458752 & i2) == 131072 ? z2 : false);
                Object objRememberedValue3 = gapComposer2.rememberedValue();
                if (zChanged3 != 0 || objRememberedValue3 == neverEqualPolicy) {
                    final int i6 = 2;
                    objRememberedValue3 = new Function0() { // from class: com.github.kr328.clash.compose.newprofile.NewProfileSheetKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            switch (i6) {
                                case 0:
                                    SoftwareKeyboardController softwareKeyboardController2 = softwareKeyboardController;
                                    if (softwareKeyboardController2 != null) {
                                        ((DelegatingSoftwareKeyboardController) softwareKeyboardController2).hide();
                                    }
                                    function6.invoke();
                                    break;
                                case 1:
                                    SoftwareKeyboardController softwareKeyboardController3 = softwareKeyboardController;
                                    if (softwareKeyboardController3 != null) {
                                        ((DelegatingSoftwareKeyboardController) softwareKeyboardController3).hide();
                                    }
                                    function6.invoke();
                                    break;
                                default:
                                    SoftwareKeyboardController softwareKeyboardController4 = softwareKeyboardController;
                                    if (softwareKeyboardController4 != null) {
                                        ((DelegatingSoftwareKeyboardController) softwareKeyboardController4).hide();
                                    }
                                    function6.invoke();
                                    break;
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    gapComposer2.updateRememberedValue(objRememberedValue3);
                }
                z3 = false;
                gapComposer2.end(false);
                TrailingIconButton(description, strStringResource3, z, (Function0) objRememberedValue3, gapComposer2, i4);
            } else {
                z3 = false;
            }
            gapComposer2.end(z3);
            gapComposer2.end(z2);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TvGlassTabRowKt$$ExternalSyntheticLambda8(str, function1, z, function4, function5, function6, i);
        }
    }

    public static final void NewProfileSheet(Function0 function0, GapComposer gapComposer, int i) {
        SheetState sheetState;
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(322214920);
        if ((i & 3) == 2 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
        } else {
            final Context context = (Context) gapComposer2.consume(AndroidCompositionLocals_androidKt.LocalContext);
            gapComposer2.startReplaceGroup(1407965993);
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Boolean.valueOf(TvKt.isTvDevice(context));
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            final boolean zBooleanValue = ((Boolean) objRememberedValue).booleanValue();
            gapComposer2.end(false);
            ProxyViewModel.Factory factory = new ProxyViewModel.Factory((Application) context.getApplicationContext(), 1);
            ViewModelStoreOwner current = LocalViewModelStoreOwner.getCurrent(gapComposer2);
            if (current == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            final NewProfileViewModel newProfileViewModel = (NewProfileViewModel) ViewModelKt.viewModel(Reflection.getOrCreateKotlinClass(NewProfileViewModel.class), current, factory, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, gapComposer2);
            SheetState sheetStateRememberModalBottomSheetState = ScrimKt.rememberModalBottomSheetState(null, gapComposer2, 6, 2);
            final AppColors appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = Stack.createCompositionCoroutineScope(gapComposer2);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue2;
            final MutableState mutableStateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(newProfileViewModel.link, gapComposer2);
            final MutableState mutableStateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(newProfileViewModel.isLoading, gapComposer2);
            final MutableState mutableStateCollectAsStateWithLifecycle3 = FlowExtKt.collectAsStateWithLifecycle(newProfileViewModel.error, gapComposer2);
            MutableState mutableStateCollectAsStateWithLifecycle4 = FlowExtKt.collectAsStateWithLifecycle(newProfileViewModel.completed, gapComposer2);
            MutableState mutableStateCollectAsStateWithLifecycle5 = FlowExtKt.collectAsStateWithLifecycle(newProfileViewModel.hwidLimit, gapComposer2);
            gapComposer2.startReplaceGroup(1407989359);
            boolean zChangedInstance = gapComposer2.changedInstance(coroutineScope) | gapComposer2.changed(sheetStateRememberModalBottomSheetState) | gapComposer2.changedInstance(newProfileViewModel);
            Object objRememberedValue3 = gapComposer2.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == neverEqualPolicy) {
                sheetState = sheetStateRememberModalBottomSheetState;
                objRememberedValue3 = new TvQrCodeSheetKt$$ExternalSyntheticLambda0(coroutineScope, sheetState, newProfileViewModel, function0, 1);
                gapComposer2.updateRememberedValue(objRememberedValue3);
            } else {
                sheetState = sheetStateRememberModalBottomSheetState;
            }
            Function0 function1 = (Function0) objRememberedValue3;
            gapComposer2.end(false);
            Boolean bool = (Boolean) mutableStateCollectAsStateWithLifecycle4.getValue();
            bool.getClass();
            gapComposer2.startReplaceGroup(1407997592);
            boolean zChanged = gapComposer2.changed(mutableStateCollectAsStateWithLifecycle4) | gapComposer2.changed(function1);
            Object objRememberedValue4 = gapComposer2.rememberedValue();
            if (zChanged || objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = new InterruptibleKt$runInterruptible$2(function1, mutableStateCollectAsStateWithLifecycle4, null, 5);
                gapComposer2.updateRememberedValue(objRememberedValue4);
            }
            gapComposer2.end(false);
            Stack.LaunchedEffect(gapComposer2, bool, (Function2) objRememberedValue4);
            ScanQRCode scanQRCode = new ScanQRCode(0);
            gapComposer2.startReplaceGroup(1408001706);
            boolean zChangedInstance2 = gapComposer2.changedInstance(newProfileViewModel);
            Object objRememberedValue5 = gapComposer2.rememberedValue();
            if (zChangedInstance2 || objRememberedValue5 == neverEqualPolicy) {
                final int i2 = 0;
                objRememberedValue5 = new Function1() { // from class: com.github.kr328.clash.compose.newprofile.NewProfileSheetKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        switch (i2) {
                            case 0:
                                QRResult qRResult = (QRResult) obj;
                                if (qRResult instanceof QRResult.QRSuccess) {
                                    QRContent qRContent = ((QRResult.QRSuccess) qRResult).content;
                                    String rawValue = qRContent.getRawValue();
                                    if (rawValue == null) {
                                        byte[] rawBytes = qRContent.getRawBytes();
                                        rawValue = rawBytes != null ? new String(rawBytes, Charsets.UTF_8) : null;
                                    }
                                    String string = rawValue != null ? StringsKt.trim(rawValue).toString() : null;
                                    if (string == null) {
                                        string = "";
                                    }
                                    if (string.length() != 0) {
                                        String strExtractDeepLink = NewProfileViewModel.extractDeepLink(string);
                                        NewProfileViewModel newProfileViewModel2 = newProfileViewModel;
                                        if (strExtractDeepLink != null) {
                                            newProfileViewModel2.setLink(strExtractDeepLink);
                                        } else if (NewProfileViewModel.isValidUrl(string)) {
                                            newProfileViewModel2.setLink(string);
                                        } else {
                                            newProfileViewModel2._error.setValue(newProfileViewModel2.app.getString(R.string.invalid_url));
                                        }
                                    }
                                }
                                break;
                            default:
                                Uri uri = (Uri) obj;
                                if (uri != null) {
                                    NewProfileViewModel newProfileViewModel3 = newProfileViewModel;
                                    if (!((Boolean) newProfileViewModel3._isLoading.getValue()).booleanValue()) {
                                        JobKt.launch$default(androidx.lifecycle.ViewModelKt.getViewModelScope(newProfileViewModel3), null, new FilesActivity$showError$1(newProfileViewModel3, uri, null, 8), 3);
                                    }
                                }
                                break;
                        }
                        return Unit.INSTANCE;
                    }
                };
                gapComposer2.updateRememberedValue(objRememberedValue5);
            }
            gapComposer2.end(false);
            final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult = AspectRatio.rememberLauncherForActivityResult(scanQRCode, (Function1) objRememberedValue5, gapComposer2, 0);
            ScanQRCode scanQRCode2 = new ScanQRCode(2);
            gapComposer2.startReplaceGroup(1408014317);
            boolean zChangedInstance3 = gapComposer2.changedInstance(newProfileViewModel);
            Object objRememberedValue6 = gapComposer2.rememberedValue();
            if (zChangedInstance3 || objRememberedValue6 == neverEqualPolicy) {
                final int i3 = 1;
                objRememberedValue6 = new Function1() { // from class: com.github.kr328.clash.compose.newprofile.NewProfileSheetKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        switch (i3) {
                            case 0:
                                QRResult qRResult = (QRResult) obj;
                                if (qRResult instanceof QRResult.QRSuccess) {
                                    QRContent qRContent = ((QRResult.QRSuccess) qRResult).content;
                                    String rawValue = qRContent.getRawValue();
                                    if (rawValue == null) {
                                        byte[] rawBytes = qRContent.getRawBytes();
                                        rawValue = rawBytes != null ? new String(rawBytes, Charsets.UTF_8) : null;
                                    }
                                    String string = rawValue != null ? StringsKt.trim(rawValue).toString() : null;
                                    if (string == null) {
                                        string = "";
                                    }
                                    if (string.length() != 0) {
                                        String strExtractDeepLink = NewProfileViewModel.extractDeepLink(string);
                                        NewProfileViewModel newProfileViewModel2 = newProfileViewModel;
                                        if (strExtractDeepLink != null) {
                                            newProfileViewModel2.setLink(strExtractDeepLink);
                                        } else if (NewProfileViewModel.isValidUrl(string)) {
                                            newProfileViewModel2.setLink(string);
                                        } else {
                                            newProfileViewModel2._error.setValue(newProfileViewModel2.app.getString(R.string.invalid_url));
                                        }
                                    }
                                }
                                break;
                            default:
                                Uri uri = (Uri) obj;
                                if (uri != null) {
                                    NewProfileViewModel newProfileViewModel3 = newProfileViewModel;
                                    if (!((Boolean) newProfileViewModel3._isLoading.getValue()).booleanValue()) {
                                        JobKt.launch$default(androidx.lifecycle.ViewModelKt.getViewModelScope(newProfileViewModel3), null, new FilesActivity$showError$1(newProfileViewModel3, uri, null, 8), 3);
                                    }
                                }
                                break;
                        }
                        return Unit.INSTANCE;
                    }
                };
                gapComposer2.updateRememberedValue(objRememberedValue6);
            }
            gapComposer2.end(false);
            final ManagedActivityResultLauncher managedActivityResultLauncherRememberLauncherForActivityResult2 = AspectRatio.rememberLauncherForActivityResult(scanQRCode2, (Function1) objRememberedValue6, gapComposer2, 0);
            ScrimKt.m265ModalBottomSheetYbuCTN8(function0, null, sheetState, 0.0f, false, null, appColors.appBackground, appColors.textPrimary, 0.0f, 0L, null, null, null, Thread_jvmKt.rememberComposableLambda(-1164592662, new Function3() { // from class: com.github.kr328.clash.compose.newprofile.NewProfileSheetKt$NewProfileSheet$2
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r0v2 */
                /* JADX WARN: Type inference failed for: r0v3, types: [boolean, int] */
                /* JADX WARN: Type inference failed for: r0v5 */
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Function0 function2;
                    State state;
                    NewProfileViewModel newProfileViewModel2;
                    State state2;
                    ?? r0;
                    GapComposer gapComposer3;
                    GapComposer gapComposer4 = (GapComposer) obj2;
                    if ((((Number) obj3).intValue() & 17) == 16 && gapComposer4.getSkipping()) {
                        gapComposer4.skipToGroupEnd();
                    } else {
                        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                        float f = 16;
                        Modifier modifierM129paddingVpY3zN4 = OffsetKt.m129paddingVpY3zN4(SizeKt.m135height3ABfNKs(SizeKt.fillMaxWidth(companion, 1.0f), 300), f, f);
                        ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, gapComposer4, 0);
                        long j = gapComposer4.compositeKeyHashCode;
                        int i4 = (int) (j ^ (j >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer4.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer4, modifierM129paddingVpY3zN4);
                        ComposeUiNode.Companion.getClass();
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                        gapComposer4.startReusableNode();
                        if (gapComposer4.inserting) {
                            gapComposer4.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer4.useNode();
                        }
                        Stack.m295setimpl(gapComposer4, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                        Stack.m295setimpl(gapComposer4, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                        Stack.m295setimpl(gapComposer4, Integer.valueOf(i4), ComposeUiNode.Companion.SetCompositeKeyHash);
                        Stack.m294reconcileimpl(gapComposer4, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                        Stack.m295setimpl(gapComposer4, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                        String strStringResource = StringResources_androidKt.stringResource(R.string.profile_create, gapComposer4);
                        StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
                        TextStyle textStyle = ((MaterialTheme$Values) gapComposer4.consume(staticProvidableCompositionLocal)).typography.titleLarge;
                        AppColors appColors2 = appColors;
                        TextKt.m275TextNvy7gAk(strStringResource, OffsetKt.m132paddingqDBjuR0$default(SizeKt.fillMaxWidth(companion, 1.0f), 0.0f, f, 0.0f, 24, 5), appColors2.textPrimary, TextUnitKt.getSp(24), null, FontWeight.Medium, 0L, new TextAlign(3), 0L, 0, false, 0, 0, textStyle, gapComposer4, 1597488, 0, 129960);
                        GapComposer gapComposer5 = gapComposer4;
                        OffsetKt.Spacer(gapComposer5, SizeKt.m135height3ABfNKs(companion, f));
                        State state3 = mutableStateCollectAsStateWithLifecycle;
                        String str = (String) state3.getValue();
                        gapComposer5.startReplaceGroup(-1008688392);
                        NewProfileViewModel newProfileViewModel3 = newProfileViewModel;
                        boolean zChangedInstance4 = gapComposer5.changedInstance(newProfileViewModel3);
                        Object objRememberedValue7 = gapComposer5.rememberedValue();
                        NeverEqualPolicy neverEqualPolicy2 = Composer$Companion.Empty;
                        if (zChangedInstance4 || objRememberedValue7 == neverEqualPolicy2) {
                            JobKt__JobKt$invokeOnCompletion$1 jobKt__JobKt$invokeOnCompletion$1 = new JobKt__JobKt$invokeOnCompletion$1(1, newProfileViewModel3, NewProfileViewModel.class, "setLink", "setLink(Ljava/lang/String;)V", 0, 0, 8);
                            gapComposer5.updateRememberedValue(jobKt__JobKt$invokeOnCompletion$1);
                            objRememberedValue7 = jobKt__JobKt$invokeOnCompletion$1;
                        }
                        final int i5 = 0;
                        gapComposer5.end(false);
                        Function1 function3 = (Function1) ((FunctionReferenceImpl) objRememberedValue7);
                        State state4 = mutableStateCollectAsStateWithLifecycle2;
                        final int i6 = 1;
                        boolean z = !((Boolean) state4.getValue()).booleanValue();
                        gapComposer5.startReplaceGroup(-1008685344);
                        Context context2 = context;
                        boolean zChangedInstance5 = gapComposer5.changedInstance(context2) | gapComposer5.changedInstance(newProfileViewModel3);
                        Object objRememberedValue8 = gapComposer5.rememberedValue();
                        if (zChangedInstance5 || objRememberedValue8 == neverEqualPolicy2) {
                            objRememberedValue8 = new Recomposer$$ExternalSyntheticLambda6(26, context2, newProfileViewModel3);
                            gapComposer5.updateRememberedValue(objRememberedValue8);
                        }
                        Function0 function4 = (Function0) objRememberedValue8;
                        gapComposer5.end(false);
                        gapComposer5.startReplaceGroup(-1008672647);
                        if (zBooleanValue) {
                            function2 = null;
                        } else {
                            gapComposer5.startReplaceGroup(-1008671997);
                            final ManagedActivityResultLauncher managedActivityResultLauncher = managedActivityResultLauncherRememberLauncherForActivityResult;
                            boolean zChangedInstance6 = gapComposer5.changedInstance(managedActivityResultLauncher);
                            Object objRememberedValue9 = gapComposer5.rememberedValue();
                            if (zChangedInstance6 || objRememberedValue9 == neverEqualPolicy2) {
                                objRememberedValue9 = new Function0() { // from class: com.github.kr328.clash.compose.newprofile.NewProfileSheetKt$NewProfileSheet$2$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() throws Exception {
                                        switch (i5) {
                                            case 0:
                                                managedActivityResultLauncher.launch(null);
                                                break;
                                            default:
                                                managedActivityResultLauncher.launch("*/*");
                                                break;
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                gapComposer5.updateRememberedValue(objRememberedValue9);
                            }
                            function2 = (Function0) objRememberedValue9;
                            gapComposer5.end(false);
                        }
                        gapComposer5.end(false);
                        gapComposer5.startReplaceGroup(-1008669980);
                        final ManagedActivityResultLauncher managedActivityResultLauncher2 = managedActivityResultLauncherRememberLauncherForActivityResult2;
                        boolean zChangedInstance7 = gapComposer5.changedInstance(managedActivityResultLauncher2);
                        Object objRememberedValue10 = gapComposer5.rememberedValue();
                        if (zChangedInstance7 || objRememberedValue10 == neverEqualPolicy2) {
                            objRememberedValue10 = new Function0() { // from class: com.github.kr328.clash.compose.newprofile.NewProfileSheetKt$NewProfileSheet$2$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() throws Exception {
                                    switch (i6) {
                                        case 0:
                                            managedActivityResultLauncher2.launch(null);
                                            break;
                                        default:
                                            managedActivityResultLauncher2.launch("*/*");
                                            break;
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            gapComposer5.updateRememberedValue(objRememberedValue10);
                        }
                        gapComposer5.end(false);
                        zzir.LinkInputRow(str, function3, z, function4, function2, (Function0) objRememberedValue10, gapComposer5, 0);
                        String str2 = (String) mutableStateCollectAsStateWithLifecycle3.getValue();
                        gapComposer5.startReplaceGroup(-1008667554);
                        if (str2 == null) {
                            state = state3;
                            r0 = 0;
                            newProfileViewModel2 = newProfileViewModel3;
                            state2 = state4;
                            gapComposer3 = gapComposer5;
                        } else {
                            OffsetKt.Spacer(gapComposer5, SizeKt.m135height3ABfNKs(companion, f));
                            state = state3;
                            newProfileViewModel2 = newProfileViewModel3;
                            state2 = state4;
                            r0 = 0;
                            TextKt.m275TextNvy7gAk(str2, OffsetKt.m130paddingVpY3zN4$default(companion, 8, 0.0f, 2), ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal)).colorScheme.error, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer5.consume(staticProvidableCompositionLocal)).typography.bodySmall, gapComposer5, 48, 0, 131064);
                            gapComposer3 = gapComposer5;
                            Unit unit = Unit.INSTANCE;
                        }
                        gapComposer3.end(r0);
                        Scale.AnimatedVisibility(((Boolean) state2.getValue()).booleanValue(), null, EnterExitTransitionKt.fadeIn$default(ArcSplineKt.tween$default(300, 6, null), 2).plus(EnterExitTransitionKt.expandVertically$default(ArcSplineKt.tween$default(300, 2, EasingFunctionsKt.EaseOutCubic), 12)), EnterExitTransitionKt.fadeOut$default(ArcSplineKt.tween$default(200, 6, null), 2).plus(EnterExitTransitionKt.shrinkVertically$default(ArcSplineKt.tween$default(250, 2, EasingFunctionsKt.EaseInCubic), 12)), null, Thread_jvmKt.rememberComposableLambda(-435465288, new LogsScreenKt.AnonymousClass4.AnonymousClass2(appColors2, 5), gapComposer3), gapComposer3, 1572870);
                        OffsetKt.Spacer(gapComposer3, SizeKt.m135height3ABfNKs(companion, f));
                        boolean zBooleanValue2 = ((Boolean) state2.getValue()).booleanValue();
                        boolean z2 = (((Boolean) state2.getValue()).booleanValue() || StringsKt.isBlank((String) state.getValue())) ? r0 : 1;
                        gapComposer3.startReplaceGroup(-1008623166);
                        NewProfileViewModel newProfileViewModel4 = newProfileViewModel2;
                        boolean zChangedInstance8 = gapComposer3.changedInstance(newProfileViewModel4);
                        Object objRememberedValue11 = gapComposer3.rememberedValue();
                        if (zChangedInstance8 || objRememberedValue11 == neverEqualPolicy2) {
                            FocusableNode.AnonymousClass1 anonymousClass1 = new FocusableNode.AnonymousClass1(0, newProfileViewModel4, NewProfileViewModel.class, "createAndActivate", "createAndActivate()V", 0, 0, 4);
                            gapComposer3.updateRememberedValue(anonymousClass1);
                            objRememberedValue11 = anonymousClass1;
                        }
                        gapComposer3.end(r0);
                        zzir.SaveAndActivateButton(zBooleanValue2, z2, (Function0) ((FunctionReferenceImpl) objRememberedValue11), gapComposer3, r0);
                        gapComposer3.end(true);
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer2), gapComposer2, 6, 3078, 6970);
            gapComposer2 = gapComposer2;
            HwidLimitMarker hwidLimitMarker = (HwidLimitMarker) mutableStateCollectAsStateWithLifecycle5.getValue();
            if (hwidLimitMarker != null) {
                String str = hwidLimitMarker.supportURL;
                gapComposer2.startReplaceGroup(887487819);
                boolean zChangedInstance4 = gapComposer2.changedInstance(newProfileViewModel);
                Object objRememberedValue7 = gapComposer2.rememberedValue();
                if (zChangedInstance4 || objRememberedValue7 == neverEqualPolicy) {
                    objRememberedValue7 = new TvQrCodeSheetKt$$ExternalSyntheticLambda3(newProfileViewModel, 1);
                    gapComposer2.updateRememberedValue(objRememberedValue7);
                }
                gapComposer2.end(false);
                HwidLimitDialogKt.HwidLimitDialog(str, (Function0) objRememberedValue7, gapComposer2, 0);
            }
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new LogsScreenKt$$ExternalSyntheticLambda5(function0, i, 2);
        }
    }

    public static final void SaveAndActivateButton(final boolean z, final boolean z2, final Function0 function0, GapComposer gapComposer, final int i) {
        long jColor;
        long jColor2;
        boolean z3;
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(127805607);
        if (((i | (gapComposer2.changed(z) ? 4 : 2) | (gapComposer2.changed(z2) ? 32 : 16) | (gapComposer2.changedInstance(function0) ? 256 : 128)) & 147) == 146 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            RoundedCornerShape roundedCornerShapeM158RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(12);
            if (z2) {
                jColor = appColors.accentFill;
            } else {
                long j = appColors.accentFill;
                jColor = BrushKt.Color(Color.m440getRedimpl(j), Color.m439getGreenimpl(j), Color.m437getBlueimpl(j), 0.4f, Color.m438getColorSpaceimpl(j));
            }
            long j2 = z2 ? appColors.accentBorder : appColors.cardBorder;
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierM130paddingVpY3zN4$default = OffsetKt.m130paddingVpY3zN4$default(ImageKt.m51clickableoSLSa3U$default(ImageKt.m48borderxT4_qwU(1, j2, ImageKt.m47backgroundbw27NRU(ClipKt.clip(SizeKt.fillMaxWidth(companion, 1.0f), roundedCornerShapeM158RoundedCornerShape0680j_4), jColor, BrushKt.RectangleShape), roundedCornerShapeM158RoundedCornerShape0680j_4), z2, null, function0, 14), 0.0f, 18, 1);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
            long j3 = gapComposer2.compositeKeyHashCode;
            int i2 = (int) (j3 ^ (j3 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierM130paddingVpY3zN4$default);
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
            Stack.m295setimpl(gapComposer2, Integer.valueOf(i2), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m294reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            if (z) {
                gapComposer2.startReplaceGroup(195330287);
                ProgressIndicatorKt.m256CircularProgressIndicator4lLiAd8(SizeKt.m140size3ABfNKs(companion, 22), appColors.textPrimary, (float) 2.5d, 0L, 0, 0.0f, gapComposer2, 390, 56);
                gapComposer2.end(false);
                z3 = true;
            } else {
                gapComposer2.startReplaceGroup(195534856);
                String strStringResource = StringResources_androidKt.stringResource(R.string.profile_save_and_activate, gapComposer2);
                TextStyle textStyle = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.titleMedium;
                if (z2) {
                    jColor2 = appColors.textPrimary;
                } else {
                    long j4 = appColors.textPrimary;
                    jColor2 = BrushKt.Color(Color.m440getRedimpl(j4), Color.m439getGreenimpl(j4), Color.m437getBlueimpl(j4), 0.6f, Color.m438getColorSpaceimpl(j4));
                }
                TextKt.m275TextNvy7gAk(strStringResource, null, jColor2, TextUnitKt.getSp(16), null, FontWeight.Medium, 0L, null, 0L, 0, false, 0, 0, textStyle, gapComposer, 1597440, 0, 130986);
                gapComposer2 = gapComposer;
                gapComposer2.end(false);
                z3 = true;
            }
            gapComposer2.end(z3);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2(z, z2, function0, i) { // from class: com.github.kr328.clash.compose.newprofile.NewProfileSheetKt$$ExternalSyntheticLambda6
                public final /* synthetic */ boolean f$0;
                public final /* synthetic */ boolean f$1;
                public final /* synthetic */ Function0 f$2;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                    zzir.SaveAndActivateButton(this.f$0, this.f$1, this.f$2, (GapComposer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void TrailingIconButton(ImageVector imageVector, String str, boolean z, Function0 function0, GapComposer gapComposer, int i) {
        long jColor;
        gapComposer.startRestartGroup(-1839324634);
        int i2 = i | (gapComposer.changed(imageVector) ? 4 : 2) | (gapComposer.changed(str) ? 32 : 16) | (gapComposer.changed(z) ? 256 : 128) | (gapComposer.changedInstance(function0) ? 2048 : 1024);
        if ((i2 & 1171) == 1170 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierM51clickableoSLSa3U$default = ImageKt.m51clickableoSLSa3U$default(SizeKt.m140size3ABfNKs(companion, 28), z, null, function0, 14);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
            long j = gapComposer.compositeKeyHashCode;
            int i3 = (int) (j ^ (j >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifierM51clickableoSLSa3U$default);
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
            if (z) {
                jColor = appColors.textPrimary;
            } else {
                long j2 = appColors.textSecondary;
                jColor = BrushKt.Color(Color.m440getRedimpl(j2), Color.m439getGreenimpl(j2), Color.m437getBlueimpl(j2), 0.6f, Color.m438getColorSpaceimpl(j2));
            }
            IconKt.m249Iconww6aTOc(imageVector, str, SizeKt.m140size3ABfNKs(companion, 22), jColor, gapComposer, (i2 & 14) | 384 | (i2 & 112), 0);
            gapComposer.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ProxyScreenKt$$ExternalSyntheticLambda2(imageVector, str, z, function0, i);
        }
    }
}
