package com.github.kr328.clash.compose.profiles;

import android.content.Context;
import android.text.format.DateUtils;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.camera.core.impl.Quirks;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.Scale;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.EasingFunctionsKt;
import androidx.compose.foundation.GestureNodeKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.Arrangement$Center$1;
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
import androidx.compose.material.icons.filled.RefreshKt;
import androidx.compose.material.icons.filled.SupportAgentKt;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda7;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt$RectangleShape$1;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathNode;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetModifier$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayout$1;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Density;
import coil.compose.AsyncImagePainter$$ExternalSyntheticLambda0;
import com.github.kr328.clash.compose.HwidLimitDialogKt$HwidLimitDialog$2$$ExternalSyntheticLambda0;
import com.github.kr328.clash.compose.LogsScreenKt;
import com.github.kr328.clash.compose.PropertiesScreenKt$$ExternalSyntheticLambda9;
import com.github.kr328.clash.compose.proxy.ProxyScreenKt$$ExternalSyntheticLambda8;
import com.github.kr328.clash.compose.util.FormatKt;
import com.github.kr328.clash.design.compose.components.GlassSnackbarKt;
import com.github.kr328.clash.design.compose.theme.AppColors;
import com.github.kr328.clash.design.compose.theme.AppColorsKt;
import com.github.kr328.clash.service.model.Profile;
import com.google.android.gms.internal.mlkit_vision_common.zzjp;
import com.koala.clash.R;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Cookie;
import okhttp3.RequestBody$Companion$toRequestBody$2;
import okhttp3.internal.http.HttpMethod;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ProfileCardKt {
    public static final void CardFooter(Profile profile, GapComposer gapComposer, int i) {
        int i2;
        Context context;
        boolean z;
        int i3;
        boolean z2;
        String string;
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(1035421732);
        if ((i & 6) == 0) {
            i2 = i | (gapComposer2.changedInstance(profile) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
            i3 = 1;
        } else {
            AppColors appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            Context context2 = (Context) gapComposer2.consume(AndroidCompositionLocals_androidKt.LocalContext);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.CenterVertically, gapComposer2, 48);
            long j = gapComposer2.compositeKeyHashCode;
            int i4 = (int) (j ^ (j >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierFillMaxWidth);
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
            Stack.m295setimpl(gapComposer2, Integer.valueOf(i4), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m294reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            String strStringResource = StringResources_androidKt.stringResource(R.string.profile_updated, gapComposer2);
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = MaterialThemeKt._localMaterialTheme;
            TextStyle textStyle = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.bodySmall;
            long j2 = appColors.textSecondary;
            FontWeight fontWeight = FontWeight.Medium;
            TextKt.m275TextNvy7gAk(strStringResource, null, j2, 0L, null, fontWeight, 0L, null, 0L, 0, false, 0, 0, textStyle, gapComposer, 1572864, 0, 131002);
            OffsetKt.Spacer(gapComposer, SizeKt.m144width3ABfNKs(companion, 6));
            long j3 = profile.updatedAt;
            long j4 = profile.interval;
            Long lValueOf = Long.valueOf(j3);
            if (j3 <= 0) {
                lValueOf = null;
            }
            long jLongValue = lValueOf != null ? lValueOf.longValue() : 0L;
            gapComposer.startReplaceGroup(987423194);
            boolean zChanged = gapComposer.changed(jLongValue);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (zChanged || objRememberedValue == neverEqualPolicy) {
                if (jLongValue <= 0) {
                    context = context2;
                    objRememberedValue = context.getString(R.string.recently);
                } else if (System.currentTimeMillis() - jLongValue < 60000) {
                    context = context2;
                    objRememberedValue = context.getString(R.string.recently);
                } else {
                    context = context2;
                    objRememberedValue = DateUtils.getRelativeTimeSpanString(jLongValue, System.currentTimeMillis(), 60000L).toString();
                }
                gapComposer.updateRememberedValue(objRememberedValue);
            } else {
                context = context2;
            }
            gapComposer.end(false);
            Context context3 = context;
            TextKt.m275TextNvy7gAk((String) objRememberedValue, null, appColors.textSecondary, 0L, null, fontWeight, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal)).typography.bodySmall, gapComposer, 1572864, 0, 131002);
            gapComposer2 = gapComposer;
            if (1.0f <= 0.0d) {
                InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
            }
            OffsetKt.Spacer(gapComposer2, new LayoutWeightElement(1.0f, true));
            gapComposer2.startReplaceGroup(987450714);
            if (j4 > 0) {
                IconKt.m249Iconww6aTOc(RefreshKt.getRefresh(), null, SizeKt.m140size3ABfNKs(companion, 16), appColors.textSecondary, gapComposer2, 432, 0);
                OffsetKt.Spacer(gapComposer2, SizeKt.m144width3ABfNKs(companion, 4));
                gapComposer2.startReplaceGroup(987460463);
                boolean zChanged2 = gapComposer2.changed(j4);
                Object objRememberedValue2 = gapComposer2.rememberedValue();
                if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                    long j5 = j4 / 60000;
                    if (j5 < 60) {
                        z2 = false;
                        string = context3.getString(R.string.format_minutes, Integer.valueOf((int) j5));
                    } else {
                        z2 = false;
                        string = context3.getString(R.string.format_hours, Integer.valueOf((int) (j5 / 60)));
                    }
                    objRememberedValue2 = string;
                    gapComposer2.updateRememberedValue(objRememberedValue2);
                } else {
                    z2 = false;
                }
                gapComposer2.end(z2);
                z = z2;
                TextKt.m275TextNvy7gAk((String) objRememberedValue2, null, appColors.textSecondary, 0L, null, fontWeight, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal)).typography.bodySmall, gapComposer, 1572864, 0, 131002);
                gapComposer2 = gapComposer;
            } else {
                z = false;
            }
            gapComposer2.end(z);
            i3 = 1;
            gapComposer2.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ProfileCardKt$$ExternalSyntheticLambda13(profile, i, i3);
        }
    }

    public static final void CardHeader(final String str, final String str2, final boolean z, final boolean z2, final Function0 function0, final Function0 function1, final Function0 function2, final String str3, boolean z3, FocusRequester focusRequester, FocusRequester focusRequester2, boolean z4, Function1 function3, GapComposer gapComposer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        boolean z5;
        FocusRequester focusRequester3;
        int i6;
        int i7;
        Function1 function4;
        MutableState mutableState;
        Function1 function5;
        boolean z6;
        Modifier modifierOnFocusChanged;
        final FocusRequester focusRequester4;
        final FocusRequester focusRequester5;
        final Function1 function6;
        final boolean z7;
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(363766791);
        if ((i & 6) == 0) {
            i4 = (gapComposer2.changed(str) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= gapComposer2.changed(str2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i4 |= gapComposer2.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i4 |= gapComposer2.changed(z2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i4 |= gapComposer2.changedInstance(function0) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i4 |= gapComposer2.changedInstance(function1) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i4 |= gapComposer2.changedInstance(function2) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i5 = i4 | (gapComposer2.changed(str3) ? 8388608 : 4194304);
        } else {
            i5 = i4;
        }
        int i8 = i3 & 256;
        if (i8 != 0) {
            i5 |= 100663296;
            z5 = z3;
        } else {
            z5 = z3;
            if ((i & 100663296) == 0) {
                i5 |= gapComposer2.changed(z5) ? 67108864 : 33554432;
            }
        }
        int i9 = i3 & 512;
        if (i9 != 0) {
            i5 |= 805306368;
            focusRequester3 = focusRequester;
        } else {
            focusRequester3 = focusRequester;
            if ((i & 805306368) == 0) {
                i5 |= gapComposer2.changed(focusRequester3) ? 536870912 : 268435456;
            }
        }
        int i10 = i5;
        int i11 = i3 & 1024;
        if (i11 != 0) {
            i6 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i6 = i2 | (gapComposer2.changed(focusRequester2) ? 4 : 2);
        } else {
            i6 = i2;
        }
        int i12 = i3 & 4096;
        if (i12 != 0) {
            i7 = i6 | 384;
        } else {
            int i13 = i6;
            if ((i2 & 384) == 0) {
                i13 |= gapComposer2.changedInstance(function3) ? 256 : 128;
            }
            i7 = i13;
        }
        if ((i10 & 306783379) == 306783378 && (i7 & 131) == 130 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
            z7 = z4;
            function6 = function3;
            focusRequester4 = focusRequester3;
            focusRequester5 = focusRequester2;
        } else {
            boolean z8 = i8 != 0 ? false : z5;
            if (i9 != 0) {
                focusRequester3 = null;
            }
            FocusRequester focusRequester6 = i11 != 0 ? null : focusRequester2;
            boolean z9 = (i3 & 2048) != 0 ? false : z4;
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (i12 != 0) {
                gapComposer2.startReplaceGroup(-945628660);
                Object objRememberedValue = gapComposer2.rememberedValue();
                if (objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = new AsyncImagePainter$$ExternalSyntheticLambda0(22);
                    gapComposer2.updateRememberedValue(objRememberedValue);
                }
                function4 = (Function1) objRememberedValue;
                gapComposer2.end(false);
            } else {
                function4 = function3;
            }
            AppColors appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            gapComposer2.startReplaceGroup(-945626324);
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            MutableState mutableState2 = (MutableState) objRememberedValue2;
            boolean z10 = z8;
            gapComposer2.end(false);
            int i14 = i7;
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.CenterVertically, gapComposer2, 48);
            long j = gapComposer2.compositeKeyHashCode;
            int i15 = (int) (j ^ (j >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, companion);
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer2.startReusableNode();
            Function1 function7 = function4;
            if (gapComposer2.inserting) {
                gapComposer2.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer2.useNode();
            }
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$1 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m295setimpl(gapComposer2, rowMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, composeUiNode$Companion$SetModifier$2);
            Integer numValueOf = Integer.valueOf(i15);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m295setimpl(gapComposer2, numValueOf, composeUiNode$Companion$SetModifier$3);
            OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
            Stack.m294reconcileimpl(gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
            FocusRequester focusRequester7 = focusRequester6;
            zzjp.m820ProfileAvataruFdPcIQ(null, 28, str2, gapComposer2, ((i10 << 3) & 896) | 48);
            OffsetKt.Spacer(gapComposer2, SizeKt.m144width3ABfNKs(companion, 10));
            TextStyle textStyle = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.titleMedium;
            long j2 = appColors.textPrimary;
            if (1.0f <= 0.0d) {
                InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
            }
            FocusRequester focusRequester8 = focusRequester3;
            TextKt.m275TextNvy7gAk(str, new LayoutWeightElement(1.0f, true), j2, 0L, null, null, 0L, null, 0L, 0, false, 1, 0, textStyle, gapComposer, i10 & 14, 24576, 114680);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            long j3 = gapComposer.compositeKeyHashCode;
            int i16 = (int) (j3 ^ (j3 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer, companion);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer.useNode();
            }
            Stack.m295setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
            ImageAnalysis$$ExternalSyntheticLambda1.m(i16, gapComposer, composeUiNode$Companion$SetModifier$3, gapComposer, ownerSnapshotObserver$onCommitAffectingLayout$1);
            Stack.m295setimpl(gapComposer, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
            gapComposer.startReplaceGroup(-406708865);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (objRememberedValue3 == neverEqualPolicy) {
                mutableState = mutableState2;
                objRememberedValue3 = new ProxyScreenKt$$ExternalSyntheticLambda8(mutableState, 2);
                gapComposer.updateRememberedValue(objRememberedValue3);
            } else {
                mutableState = mutableState2;
            }
            Function0 function8 = (Function0) objRememberedValue3;
            gapComposer.end(false);
            gapComposer.startReplaceGroup(-406706881);
            if (!z10 || focusRequester8 == null || focusRequester7 == null) {
                function5 = function7;
                z6 = false;
                modifierOnFocusChanged = companion;
            } else {
                Modifier modifierFocusRequester = FocusTraversalKt.focusRequester(companion, focusRequester8);
                gapComposer.startReplaceGroup(-406700731);
                boolean z11 = (i14 & 14) == 4;
                Object objRememberedValue4 = gapComposer.rememberedValue();
                if (z11 || objRememberedValue4 == neverEqualPolicy) {
                    objRememberedValue4 = new ProfileCardKt$$ExternalSyntheticLambda3(focusRequester7, 1);
                    gapComposer.updateRememberedValue(objRememberedValue4);
                }
                gapComposer.end(false);
                Modifier modifierFocusProperties = FocusTraversalKt.focusProperties(modifierFocusRequester, (Function1) objRememberedValue4);
                gapComposer.startReplaceGroup(-406698481);
                boolean z12 = (i14 & 896) == 256;
                Object objRememberedValue5 = gapComposer.rememberedValue();
                if (z12 || objRememberedValue5 == neverEqualPolicy) {
                    function5 = function7;
                    objRememberedValue5 = new GestureNodeKt$$ExternalSyntheticLambda0(function5, 3);
                    gapComposer.updateRememberedValue(objRememberedValue5);
                } else {
                    function5 = function7;
                }
                z6 = false;
                gapComposer.end(false);
                modifierOnFocusChanged = FocusTraversalKt.onFocusChanged(modifierFocusProperties, (Function1) objRememberedValue5);
            }
            gapComposer.end(z6);
            ScrimKt.IconButton(function8, modifierOnFocusChanged, false, null, null, Thread_jvmKt.rememberComposableLambda(-889067777, new LogsScreenKt.AnonymousClass6(appColors, 24), gapComposer), gapComposer, 1572870, 60);
            boolean zBooleanValue = ((Boolean) mutableState.getValue()).booleanValue();
            gapComposer.startReplaceGroup(-406685824);
            Object objRememberedValue6 = gapComposer.rememberedValue();
            if (objRememberedValue6 == neverEqualPolicy) {
                objRememberedValue6 = new ProxyScreenKt$$ExternalSyntheticLambda8(mutableState, 1);
                gapComposer.updateRememberedValue(objRememberedValue6);
            }
            gapComposer.end(false);
            ProfileActionsMenu(zBooleanValue, (Function0) objRememberedValue6, z, z2, function0, function1, function2, str3, gapComposer, (i10 & 896) | 48 | (i10 & 7168) | (57344 & i10) | (458752 & i10) | (3670016 & i10) | (i10 & 29360128));
            gapComposer2 = gapComposer;
            gapComposer2.end(true);
            gapComposer2.end(true);
            focusRequester4 = focusRequester8;
            focusRequester5 = focusRequester7;
            function6 = function5;
            z7 = z9;
            z5 = z10;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            final boolean z13 = z5;
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.github.kr328.clash.compose.profiles.ProfileCardKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                    ProfileCardKt.CardHeader(str, str2, z, z2, function0, function1, function2, str3, z13, focusRequester4, focusRequester5, z7, function6, (GapComposer) obj, iUpdateChangedFlags, iUpdateChangedFlags2, i3);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void ProfileActionsMenu(final boolean z, final Function0 function0, final boolean z2, final boolean z3, final Function0 function1, final Function0 function2, final Function0 function3, final String str, GapComposer gapComposer, final int i) {
        int i2;
        Function0 function4;
        boolean z4;
        Function0 function5;
        Function0 function6;
        Function0 function7;
        String str2;
        gapComposer.startRestartGroup(1536620042);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            function4 = function0;
            i2 |= gapComposer.changedInstance(function4) ? 32 : 16;
        } else {
            function4 = function0;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changed(z2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            z4 = z3;
            i2 |= gapComposer.changed(z4) ? 2048 : 1024;
        } else {
            z4 = z3;
        }
        if ((i & 24576) == 0) {
            function5 = function1;
            i2 |= gapComposer.changedInstance(function5) ? 16384 : 8192;
        } else {
            function5 = function1;
        }
        if ((196608 & i) == 0) {
            function6 = function2;
            i2 |= gapComposer.changedInstance(function6) ? 131072 : 65536;
        } else {
            function6 = function2;
        }
        if ((1572864 & i) == 0) {
            function7 = function3;
            i2 |= gapComposer.changedInstance(function7) ? 1048576 : 524288;
        } else {
            function7 = function3;
        }
        if ((12582912 & i) == 0) {
            str2 = str;
            i2 |= gapComposer.changed(str2) ? 8388608 : 4194304;
        } else {
            str2 = str;
        }
        if ((4793491 & i2) == 4793490 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            final AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            long jM414compositeOverOWjLjI = BrushKt.m414compositeOverOWjLjI(appColors.cardBackground, appColors.appBackground);
            final long j = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.error;
            final Context context = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
            final SnackbarHostState snackbarHostState = (SnackbarHostState) gapComposer.consume(GlassSnackbarKt.LocalGlassSnackbarHost);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == Composer$Companion.Empty) {
                objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            final Function0 function8 = function4;
            final boolean z5 = z4;
            final Function0 function9 = function5;
            final Function0 function10 = function6;
            final Function0 function11 = function7;
            final String str3 = str2;
            AndroidMenu_androidKt.m236DropdownMenuIlH_yew(z, function0, null, 0L, null, null, RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(16), jM414compositeOverOWjLjI, 0.0f, 0.0f, Thread_jvmKt.rememberComposableLambda(733481093, new Function3() { // from class: com.github.kr328.clash.compose.profiles.ProfileCardKt.ProfileActionsMenu.1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    GapComposer gapComposer2 = (GapComposer) obj2;
                    if ((((Number) obj3).intValue() & 17) == 16 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                        Modifier modifierM130paddingVpY3zN4$default = OffsetKt.m130paddingVpY3zN4$default(SizeKt.m144width3ABfNKs(companion, 180), 0.0f, 6, 1);
                        ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, gapComposer2, 0);
                        long j2 = gapComposer2.compositeKeyHashCode;
                        int i3 = (int) (j2 ^ (j2 >>> 32));
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
                        Stack.m295setimpl(gapComposer2, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                        Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                        Stack.m295setimpl(gapComposer2, Integer.valueOf(i3), ComposeUiNode.Companion.SetCompositeKeyHash);
                        Stack.m294reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                        Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                        ImageVector edit = HttpMethod.getEdit();
                        String strStringResource = StringResources_androidKt.stringResource(R.string.profile_edit, gapComposer2);
                        gapComposer2.startReplaceGroup(-1623018962);
                        Function0 function12 = function8;
                        boolean zChanged = gapComposer2.changed(function12);
                        Function0 function13 = function9;
                        boolean zChanged2 = zChanged | gapComposer2.changed(function13);
                        Object objRememberedValue2 = gapComposer2.rememberedValue();
                        NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
                        if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                            objRememberedValue2 = new ProfileCardKt$ProfileActionsMenu$1$$ExternalSyntheticLambda0(function12, function13, 0);
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        }
                        gapComposer2.end(false);
                        ProfileCardKt.m809ProfileMenuRowjM_yU8I(edit, strStringResource, (Function0) objRememberedValue2, false, null, false, gapComposer2, 0, 56);
                        gapComposer2.startReplaceGroup(-1623015217);
                        if (z5) {
                            ImageVector refresh = RefreshKt.getRefresh();
                            String strStringResource2 = StringResources_androidKt.stringResource(R.string.profile_update, gapComposer2);
                            boolean z6 = !z2;
                            gapComposer2.startReplaceGroup(-1623007748);
                            boolean zChanged3 = gapComposer2.changed(function12);
                            Function0 function14 = function10;
                            boolean zChanged4 = zChanged3 | gapComposer2.changed(function14);
                            Object objRememberedValue3 = gapComposer2.rememberedValue();
                            if (zChanged4 || objRememberedValue3 == neverEqualPolicy) {
                                objRememberedValue3 = new ProfileCardKt$ProfileActionsMenu$1$$ExternalSyntheticLambda0(function12, function14, 1);
                                gapComposer2.updateRememberedValue(objRememberedValue3);
                            }
                            gapComposer2.end(false);
                            ProfileCardKt.m809ProfileMenuRowjM_yU8I(refresh, strStringResource2, (Function0) objRememberedValue3, z6, null, false, gapComposer2, 0, 48);
                        }
                        gapComposer2.end(false);
                        gapComposer2.startReplaceGroup(-1623002416);
                        String str4 = str3;
                        if (str4 != null && !StringsKt.isBlank(str4)) {
                            ImageVector imageVectorBuild = SupportAgentKt._supportAgent;
                            if (imageVectorBuild == null) {
                                ImageVector.Builder builder = new ImageVector.Builder("Filled.SupportAgent", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                                int i4 = VectorKt.$r8$clinit;
                                long j3 = Color.Black;
                                SolidColor solidColor = new SolidColor(j3);
                                Quirks quirks = new Quirks();
                                quirks.moveTo(21.0f, 12.22f);
                                quirks.curveTo(21.0f, 6.73f, 16.74f, 3.0f, 12.0f, 3.0f);
                                quirks.curveToRelative(-4.69f, 0.0f, -9.0f, 3.65f, -9.0f, 9.28f);
                                quirks.curveTo(2.4f, 12.62f, 2.0f, 13.26f, 2.0f, 14.0f);
                                quirks.verticalLineToRelative(2.0f);
                                quirks.curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
                                quirks.horizontalLineToRelative(1.0f);
                                quirks.verticalLineToRelative(-6.1f);
                                quirks.curveToRelative(0.0f, -3.87f, 3.13f, -7.0f, 7.0f, -7.0f);
                                quirks.reflectiveCurveToRelative(7.0f, 3.13f, 7.0f, 7.0f);
                                quirks.verticalLineTo(19.0f);
                                quirks.horizontalLineToRelative(-8.0f);
                                quirks.verticalLineToRelative(2.0f);
                                quirks.horizontalLineToRelative(8.0f);
                                quirks.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
                                quirks.verticalLineToRelative(-1.22f);
                                quirks.curveToRelative(0.59f, -0.31f, 1.0f, -0.92f, 1.0f, -1.64f);
                                quirks.verticalLineToRelative(-2.3f);
                                quirks.curveTo(22.0f, 13.14f, 21.59f, 12.53f, 21.0f, 12.22f);
                                quirks.close();
                                ImageVector.Builder.m502addPathoIyEayM$default(builder, quirks.mQuirks, solidColor);
                                SolidColor solidColor2 = new SolidColor(j3);
                                ArrayList arrayList = new ArrayList(32);
                                arrayList.add(new PathNode.MoveTo(9.0f, 13.0f));
                                arrayList.add(new PathNode.RelativeMoveTo(-1.0f, 0.0f));
                                arrayList.add(new PathNode.RelativeArcTo(1.0f, 1.0f, 0.0f, true, true, 2.0f, 0.0f));
                                arrayList.add(new PathNode.RelativeArcTo(1.0f, 1.0f, 0.0f, true, true, -2.0f, 0.0f));
                                ImageVector.Builder.m502addPathoIyEayM$default(builder, arrayList, solidColor2);
                                SolidColor solidColor3 = new SolidColor(j3);
                                ArrayList arrayList2 = new ArrayList(32);
                                arrayList2.add(new PathNode.MoveTo(15.0f, 13.0f));
                                arrayList2.add(new PathNode.RelativeMoveTo(-1.0f, 0.0f));
                                arrayList2.add(new PathNode.RelativeArcTo(1.0f, 1.0f, 0.0f, true, true, 2.0f, 0.0f));
                                arrayList2.add(new PathNode.RelativeArcTo(1.0f, 1.0f, 0.0f, true, true, -2.0f, 0.0f));
                                ImageVector.Builder.m502addPathoIyEayM$default(builder, arrayList2, solidColor3);
                                SolidColor solidColor4 = new SolidColor(j3);
                                ArrayList arrayList3 = new ArrayList(32);
                                arrayList3.add(new PathNode.MoveTo(18.0f, 11.03f));
                                arrayList3.add(new PathNode.CurveTo(17.52f, 8.18f, 15.04f, 6.0f, 12.05f, 6.0f));
                                arrayList3.add(new PathNode.RelativeCurveTo(-3.03f, 0.0f, -6.29f, 2.51f, -6.03f, 6.45f));
                                arrayList3.add(new PathNode.RelativeCurveTo(2.47f, -1.01f, 4.33f, -3.21f, 4.86f, -5.89f));
                                arrayList3.add(new PathNode.CurveTo(12.19f, 9.19f, 14.88f, 11.0f, 18.0f, 11.03f));
                                arrayList3.add(PathNode.Close.INSTANCE);
                                ImageVector.Builder.m502addPathoIyEayM$default(builder, arrayList3, solidColor4);
                                imageVectorBuild = builder.build();
                                SupportAgentKt._supportAgent = imageVectorBuild;
                            }
                            String strStringResource3 = StringResources_androidKt.stringResource(R.string.profile_support, gapComposer2);
                            gapComposer2.startReplaceGroup(-1622995598);
                            boolean zChanged5 = gapComposer2.changed(function12) | gapComposer2.changed(str4);
                            Context context2 = context;
                            boolean zChangedInstance = zChanged5 | gapComposer2.changedInstance(context2);
                            CoroutineScope coroutineScope2 = coroutineScope;
                            boolean zChangedInstance2 = zChangedInstance | gapComposer2.changedInstance(coroutineScope2);
                            SnackbarHostState snackbarHostState2 = snackbarHostState;
                            boolean zChanged6 = zChangedInstance2 | gapComposer2.changed(snackbarHostState2);
                            Object objRememberedValue4 = gapComposer2.rememberedValue();
                            if (zChanged6 || objRememberedValue4 == neverEqualPolicy) {
                                objRememberedValue4 = new HwidLimitDialogKt$HwidLimitDialog$2$$ExternalSyntheticLambda0(function12, str4, context2, coroutineScope2, snackbarHostState2);
                                gapComposer2.updateRememberedValue(objRememberedValue4);
                            }
                            gapComposer2.end(false);
                            ProfileCardKt.m809ProfileMenuRowjM_yU8I(imageVectorBuild, strStringResource3, (Function0) objRememberedValue4, false, null, false, gapComposer2, 0, 56);
                        }
                        gapComposer2.end(false);
                        long j4 = appColors.cardBorder;
                        ScrimKt.m264HorizontalDivider9IZ8Weo(OffsetKt.m129paddingVpY3zN4(companion, 12, 4), 0.0f, BrushKt.Color(Color.m440getRedimpl(j4), Color.m439getGreenimpl(j4), Color.m437getBlueimpl(j4), 0.5f, Color.m438getColorSpaceimpl(j4)), gapComposer2, 6, 2);
                        ImageVector delete = RequestBody$Companion$toRequestBody$2.getDelete();
                        String strStringResource4 = StringResources_androidKt.stringResource(R.string.profile_delete, gapComposer2);
                        gapComposer2.startReplaceGroup(-1622959472);
                        boolean zChanged7 = gapComposer2.changed(function12);
                        Function0 function15 = function11;
                        boolean zChanged8 = zChanged7 | gapComposer2.changed(function15);
                        Object objRememberedValue5 = gapComposer2.rememberedValue();
                        if (zChanged8 || objRememberedValue5 == neverEqualPolicy) {
                            objRememberedValue5 = new ProfileCardKt$ProfileActionsMenu$1$$ExternalSyntheticLambda0(function12, function15, 2);
                            gapComposer2.updateRememberedValue(objRememberedValue5);
                        }
                        gapComposer2.end(false);
                        ProfileCardKt.m809ProfileMenuRowjM_yU8I(delete, strStringResource4, (Function0) objRememberedValue5, false, new Color(j), true, gapComposer2, 196608, 8);
                        gapComposer2.end(true);
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, i2 & 126);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.github.kr328.clash.compose.profiles.ProfileCardKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).intValue();
                    ProfileCardKt.ProfileActionsMenu(z, function0, z2, z3, function1, function2, function3, str, (GapComposer) obj, Stack.updateChangedFlags(i | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void ProfileCard(Profile profile, boolean z, Function0 function0, Function0 function1, Function0 function2, Function0 function3, Modifier modifier, boolean z2, GapComposer gapComposer, int i) {
        long j;
        Modifier.Companion companion;
        Profile profile2;
        Modifier modifier2;
        FocusRequester focusRequester;
        BiasAlignment.Horizontal horizontal = Alignment.Companion.Start;
        BiasAlignment biasAlignment = Alignment.Companion.TopStart;
        Profile.Type type = profile.type;
        boolean z3 = profile.active;
        gapComposer.startRestartGroup(-1775783689);
        int i2 = i | (gapComposer.changedInstance(profile) ? 4 : 2) | (gapComposer.changed(z) ? 32 : 16) | (gapComposer.changedInstance(function0) ? 256 : 128) | (gapComposer.changedInstance(function1) ? 2048 : 1024) | (gapComposer.changedInstance(function2) ? 16384 : 8192) | (gapComposer.changedInstance(function3) ? 131072 : 65536) | 1572864 | (gapComposer.changed(z2) ? 8388608 : 4194304);
        if ((i2 & 4793491) == 4793490 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
            profile2 = profile;
        } else {
            AppColors appColors = (AppColors) gapComposer.consume(AppColorsKt.LocalAppColors);
            RoundedCornerShape roundedCornerShapeM158RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(12);
            gapComposer.startReplaceGroup(-2072453394);
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            gapComposer.end(false);
            long jM414compositeOverOWjLjI = z3 ? appColors.accentFill : appColors.cardBackground;
            if (z2 && ((Boolean) mutableState.getValue()).booleanValue()) {
                long j2 = Color.White;
                jM414compositeOverOWjLjI = BrushKt.m414compositeOverOWjLjI(BrushKt.Color(Color.m440getRedimpl(j2), Color.m439getGreenimpl(j2), Color.m437getBlueimpl(j2), 0.2f, Color.m438getColorSpaceimpl(j2)), jM414compositeOverOWjLjI);
            }
            if (((Boolean) mutableState.getValue()).booleanValue()) {
                j = Color.White;
            } else {
                j = z3 ? appColors.accentBorder : appColors.cardBorder;
            }
            float f = ((Boolean) mutableState.getValue()).booleanValue() ? 2 : 1;
            Profile.Type type2 = Profile.Type.File;
            RectangleShapeKt$RectangleShape$1 rectangleShapeKt$RectangleShape$1 = BrushKt.RectangleShape;
            Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
            if (z2) {
                gapComposer.startReplaceGroup(179043941);
                gapComposer.startReplaceGroup(-2072436695);
                Object objRememberedValue2 = gapComposer.rememberedValue();
                if (objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = new FocusRequester();
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                FocusRequester focusRequester2 = (FocusRequester) objRememberedValue2;
                Object objM = Density.CC.m(-2072434679, gapComposer, false);
                if (objM == neverEqualPolicy) {
                    objM = new FocusRequester();
                    gapComposer.updateRememberedValue(objM);
                }
                FocusRequester focusRequester3 = (FocusRequester) objM;
                Object objM2 = Density.CC.m(-2072432754, gapComposer, false);
                if (objM2 == neverEqualPolicy) {
                    objM2 = Stack.mutableStateOf$default(Boolean.FALSE);
                    gapComposer.updateRememberedValue(objM2);
                }
                MutableState mutableState2 = (MutableState) objM2;
                gapComposer.end(false);
                Modifier modifierFillMaxWidth = SizeKt.fillMaxWidth(companion2, 1.0f);
                gapComposer.startReplaceGroup(-2072428121);
                Object objRememberedValue3 = gapComposer.rememberedValue();
                if (objRememberedValue3 == neverEqualPolicy) {
                    objRememberedValue3 = new TooltipKt$$ExternalSyntheticLambda7(mutableState, 20);
                    gapComposer.updateRememberedValue(objRememberedValue3);
                }
                gapComposer.end(false);
                float f2 = 8;
                Modifier modifierM129paddingVpY3zN4 = OffsetKt.m129paddingVpY3zN4(ImageKt.focusGroup(ImageKt.m48borderxT4_qwU(f, j, ImageKt.m47backgroundbw27NRU(ClipKt.clip(FocusTraversalKt.onFocusChanged(modifierFillMaxWidth, (Function1) objRememberedValue3), roundedCornerShapeM158RoundedCornerShape0680j_4), jM414compositeOverOWjLjI, rectangleShapeKt$RectangleShape$1), roundedCornerShapeM158RoundedCornerShape0680j_4)), 16, f2);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                long j3 = gapComposer.compositeKeyHashCode;
                int i3 = (int) (j3 ^ (j3 >>> 32));
                PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifierM129paddingVpY3zN4);
                ComposeUiNode.Companion.getClass();
                LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                gapComposer.startReusableNode();
                if (gapComposer.inserting) {
                    gapComposer.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    gapComposer.useNode();
                }
                ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$1 = ComposeUiNode.Companion.SetMeasurePolicy;
                Stack.m295setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, composeUiNode$Companion$SetModifier$1);
                ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, composeUiNode$Companion$SetModifier$2);
                Integer numValueOf = Integer.valueOf(i3);
                ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
                Stack.m295setimpl(gapComposer, numValueOf, composeUiNode$Companion$SetModifier$3);
                OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
                Stack.m294reconcileimpl(gapComposer, ownerSnapshotObserver$onCommitAffectingLayout$1);
                ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
                Stack.m295setimpl(gapComposer, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
                Modifier modifierFocusRequester = FocusTraversalKt.focusRequester(companion2, focusRequester2);
                gapComposer.startReplaceGroup(-8186551);
                Object objRememberedValue4 = gapComposer.rememberedValue();
                if (objRememberedValue4 == neverEqualPolicy) {
                    focusRequester = focusRequester3;
                    objRememberedValue4 = new ProfileCardKt$$ExternalSyntheticLambda3(focusRequester, 0);
                    gapComposer.updateRememberedValue(objRememberedValue4);
                } else {
                    focusRequester = focusRequester3;
                }
                gapComposer.end(false);
                Modifier modifierFocusProperties = FocusTraversalKt.focusProperties(modifierFocusRequester, (Function1) objRememberedValue4);
                gapComposer.startReplaceGroup(-8181742);
                Object objRememberedValue5 = gapComposer.rememberedValue();
                if (objRememberedValue5 == neverEqualPolicy) {
                    objRememberedValue5 = new MutableInteractionSourceImpl();
                    gapComposer.updateRememberedValue(objRememberedValue5);
                }
                gapComposer.end(false);
                FocusRequester focusRequester4 = focusRequester;
                Modifier modifierM50clickableO2vRcR0$default = ImageKt.m50clickableO2vRcR0$default(modifierFocusProperties, (MutableInteractionSourceImpl) objRememberedValue5, null, false, null, function0, 28);
                ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, horizontal, gapComposer, 0);
                long j4 = gapComposer.compositeKeyHashCode;
                int i4 = (int) (j4 ^ (j4 >>> 32));
                PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer, modifierM50clickableO2vRcR0$default);
                gapComposer.startReusableNode();
                if (gapComposer.inserting) {
                    gapComposer.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    gapComposer.useNode();
                }
                Stack.m295setimpl(gapComposer, columnMeasurePolicy, composeUiNode$Companion$SetModifier$1);
                Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
                ImageAnalysis$$ExternalSyntheticLambda1.m(i4, gapComposer, composeUiNode$Companion$SetModifier$3, gapComposer, ownerSnapshotObserver$onCommitAffectingLayout$1);
                Stack.m295setimpl(gapComposer, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
                String str = profile.name;
                String str2 = profile.profileImagePath;
                boolean z4 = type != type2;
                String str3 = profile.supportURL;
                boolean zBooleanValue = ((Boolean) mutableState2.getValue()).booleanValue();
                gapComposer.startReplaceGroup(714744929);
                Object objRememberedValue6 = gapComposer.rememberedValue();
                if (objRememberedValue6 == neverEqualPolicy) {
                    objRememberedValue6 = new TooltipKt$$ExternalSyntheticLambda7(mutableState2, 21);
                    gapComposer.updateRememberedValue(objRememberedValue6);
                }
                gapComposer.end(false);
                int i5 = i2 << 3;
                CardHeader(str, str2, z, z4, function1, function2, function3, str3, true, focusRequester4, focusRequester2, zBooleanValue, (Function1) objRememberedValue6, gapComposer, (i5 & 896) | 905969664 | (i5 & 57344) | (i5 & 458752) | (i5 & 3670016), 390, 0);
                Scale.AnimatedVisibility(z, null, EnterExitTransitionKt.fadeIn$default(ArcSplineKt.tween$default(300, 6, null), 2).plus(EnterExitTransitionKt.expandVertically$default(ArcSplineKt.tween$default(300, 2, EasingFunctionsKt.EaseOutCubic), 12)), EnterExitTransitionKt.fadeOut$default(ArcSplineKt.tween$default(200, 6, null), 2).plus(EnterExitTransitionKt.shrinkVertically$default(ArcSplineKt.tween$default(250, 2, EasingFunctionsKt.EaseInCubic), 12)), null, Thread_jvmKt.rememberComposableLambda(337462822, new LogsScreenKt.AnonymousClass4.AnonymousClass2(appColors, 6), gapComposer), gapComposer, 1572870 | (i2 & 112));
                float f3 = 5;
                OffsetKt.Spacer(gapComposer, SizeKt.m135height3ABfNKs(companion2, f3));
                int i6 = i2 & 14;
                profile2 = profile;
                TrafficDaysRow(profile2, gapComposer, i6);
                OffsetKt.Spacer(gapComposer, SizeKt.m135height3ABfNKs(companion2, f3));
                ScrimKt.m264HorizontalDivider9IZ8Weo(null, 1, j, gapComposer, 48, 1);
                OffsetKt.Spacer(gapComposer, SizeKt.m135height3ABfNKs(companion2, f2));
                CardFooter(profile2, gapComposer, i6);
                gapComposer.end(true);
                gapComposer.end(true);
                gapComposer.end(false);
                companion = companion2;
            } else {
                long j5 = j;
                gapComposer.startReplaceGroup(182468666);
                Modifier modifierFillMaxWidth2 = SizeKt.fillMaxWidth(companion2, 1.0f);
                gapComposer.startReplaceGroup(-2072322936);
                Object objRememberedValue7 = gapComposer.rememberedValue();
                if (objRememberedValue7 == neverEqualPolicy) {
                    objRememberedValue7 = new TooltipKt$$ExternalSyntheticLambda7(mutableState, 22);
                    gapComposer.updateRememberedValue(objRememberedValue7);
                }
                gapComposer.end(false);
                float f4 = 8;
                Modifier modifierM129paddingVpY3zN5 = OffsetKt.m129paddingVpY3zN4(ImageKt.m51clickableoSLSa3U$default(ImageKt.m48borderxT4_qwU(f, j5, ImageKt.m47backgroundbw27NRU(ClipKt.clip(FocusTraversalKt.onFocusChanged(modifierFillMaxWidth2, (Function1) objRememberedValue7), roundedCornerShapeM158RoundedCornerShape0680j_4), jM414compositeOverOWjLjI, rectangleShapeKt$RectangleShape$1), roundedCornerShapeM158RoundedCornerShape0680j_4), false, null, function0, 15), 16, f4);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                long j6 = gapComposer.compositeKeyHashCode;
                int i7 = (int) (j6 ^ (j6 >>> 32));
                PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope3 = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier3 = AbsoluteAlignment.materializeModifier(gapComposer, modifierM129paddingVpY3zN5);
                ComposeUiNode.Companion.getClass();
                LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$2 = ComposeUiNode.Companion.Constructor;
                gapComposer.startReusableNode();
                if (gapComposer.inserting) {
                    gapComposer.createNode(layoutNode$Companion$Constructor$2);
                } else {
                    gapComposer.useNode();
                }
                ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$5 = ComposeUiNode.Companion.SetMeasurePolicy;
                Stack.m295setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy2, composeUiNode$Companion$SetModifier$5);
                ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$6 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope3, composeUiNode$Companion$SetModifier$6);
                Integer numValueOf2 = Integer.valueOf(i7);
                ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$7 = ComposeUiNode.Companion.SetCompositeKeyHash;
                Stack.m295setimpl(gapComposer, numValueOf2, composeUiNode$Companion$SetModifier$7);
                OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$2 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
                Stack.m294reconcileimpl(gapComposer, ownerSnapshotObserver$onCommitAffectingLayout$2);
                ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$8 = ComposeUiNode.Companion.SetModifier;
                Stack.m295setimpl(gapComposer, modifierMaterializeModifier3, composeUiNode$Companion$SetModifier$8);
                ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.Top, horizontal, gapComposer, 0);
                long j7 = gapComposer.compositeKeyHashCode;
                int i8 = (int) (j7 ^ (j7 >>> 32));
                PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope4 = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier4 = AbsoluteAlignment.materializeModifier(gapComposer, companion2);
                gapComposer.startReusableNode();
                if (gapComposer.inserting) {
                    gapComposer.createNode(layoutNode$Companion$Constructor$2);
                } else {
                    gapComposer.useNode();
                }
                Stack.m295setimpl(gapComposer, columnMeasurePolicy2, composeUiNode$Companion$SetModifier$5);
                Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope4, composeUiNode$Companion$SetModifier$6);
                ImageAnalysis$$ExternalSyntheticLambda1.m(i8, gapComposer, composeUiNode$Companion$SetModifier$7, gapComposer, ownerSnapshotObserver$onCommitAffectingLayout$2);
                Stack.m295setimpl(gapComposer, modifierMaterializeModifier4, composeUiNode$Companion$SetModifier$8);
                CardHeader(profile.name, profile.profileImagePath, z, type != type2, function1, function2, function3, profile.supportURL, false, null, null, false, null, gapComposer, (i2 << 3) & 4187008, 0, 7936);
                Scale.AnimatedVisibility(z, null, EnterExitTransitionKt.fadeIn$default(ArcSplineKt.tween$default(300, 6, null), 2).plus(EnterExitTransitionKt.expandVertically$default(ArcSplineKt.tween$default(300, 2, EasingFunctionsKt.EaseOutCubic), 12)), EnterExitTransitionKt.fadeOut$default(ArcSplineKt.tween$default(200, 6, null), 2).plus(EnterExitTransitionKt.shrinkVertically$default(ArcSplineKt.tween$default(250, 2, EasingFunctionsKt.EaseInCubic), 12)), null, Thread_jvmKt.rememberComposableLambda(1470481007, new LogsScreenKt.AnonymousClass4.AnonymousClass2(appColors, 7), gapComposer), gapComposer, 1572870 | (i2 & 112));
                float f5 = 5;
                companion = companion2;
                OffsetKt.Spacer(gapComposer, SizeKt.m135height3ABfNKs(companion, f5));
                int i9 = i2 & 14;
                profile2 = profile;
                TrafficDaysRow(profile2, gapComposer, i9);
                OffsetKt.Spacer(gapComposer, SizeKt.m135height3ABfNKs(companion, f5));
                ScrimKt.m264HorizontalDivider9IZ8Weo(null, 1, j5, gapComposer, 48, 1);
                OffsetKt.Spacer(gapComposer, SizeKt.m135height3ABfNKs(companion, f4));
                CardFooter(profile2, gapComposer, i9);
                gapComposer.end(true);
                gapComposer.end(true);
                gapComposer.end(false);
            }
            modifier2 = companion;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new PropertiesScreenKt$$ExternalSyntheticLambda9(profile2, z, function0, function1, function2, function3, modifier2, z2, i);
        }
    }

    /* JADX WARN: Code duplicated, block: B:47:0x0095 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:48:0x0097  */
    /* JADX WARN: Code duplicated, block: B:49:0x0099  */
    /* JADX WARN: Code duplicated, block: B:52:0x009d  */
    /* JADX WARN: Code duplicated, block: B:53:0x009f  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:60:0x00bc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:61:0x00be  */
    /* JADX WARN: Code duplicated, block: B:62:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:65:0x0107  */
    /* JADX WARN: Code duplicated, block: B:66:0x010b  */
    /* JADX WARN: Code duplicated, block: B:69:0x015b  */
    /* JADX WARN: Code duplicated, block: B:71:0x015f  */
    /* JADX WARN: Code duplicated, block: B:75:0x0197  */
    /* JADX WARN: Code duplicated, block: B:77:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: ProfileMenuRow-jM_yU8I, reason: not valid java name */
    public static final void m809ProfileMenuRowjM_yU8I(final ImageVector imageVector, final String str, final Function0 function0, boolean z, Color color, boolean z2, GapComposer gapComposer, final int i, final int i2) {
        boolean z3;
        int i3;
        Color color2;
        int i4;
        boolean z4;
        boolean z5;
        Color color3;
        boolean z6;
        AppColors appColors;
        long jColor;
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1;
        FontWeight fontWeight;
        final boolean z7;
        final Color color4;
        final boolean z8;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(-1383980420);
        int i5 = i | (gapComposer2.changed(imageVector) ? 4 : 2) | (gapComposer2.changed(str) ? 32 : 16) | (gapComposer2.changedInstance(function0) ? 256 : 128);
        int i6 = i2 & 8;
        if (i6 != 0) {
            i3 = i5 | 3072;
            z3 = z;
        } else {
            z3 = z;
            i3 = i5 | (gapComposer2.changed(z3) ? 2048 : 1024);
        }
        int i7 = i2 & 16;
        if (i7 != 0) {
            i4 = i3 | 24576;
            color2 = color;
        } else {
            color2 = color;
            i4 = i3 | (gapComposer2.changed(color2) ? 16384 : 8192);
        }
        int i8 = i2 & 32;
        if (i8 == 0) {
            if ((i & 196608) == 0) {
                z4 = z2;
                i4 |= gapComposer2.changed(z4) ? 131072 : 65536;
            }
            if ((74899 & i4) == 74898 || !gapComposer2.getSkipping()) {
                if (i6 != 0) {
                    z5 = true;
                } else {
                    z5 = z3;
                }
                if (i7 != 0) {
                    color3 = null;
                } else {
                    color3 = color2;
                }
                if (i8 != 0) {
                    z6 = false;
                } else {
                    z6 = z4;
                }
                appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
                if (!z5) {
                    long j = appColors.textSecondary;
                    jColor = BrushKt.Color(Color.m440getRedimpl(j), Color.m439getGreenimpl(j), Color.m437getBlueimpl(j), 0.6f, Color.m438getColorSpaceimpl(j));
                } else if (color3 != null) {
                    jColor = color3.value;
                } else {
                    jColor = appColors.textPrimary;
                }
                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                Modifier modifierM130paddingVpY3zN4$default = OffsetKt.m130paddingVpY3zN4$default(ImageKt.m51clickableoSLSa3U$default(SizeKt.m135height3ABfNKs(SizeKt.fillMaxWidth(companion, 1.0f), 46), z5, null, function0, 14), 16, 0.0f, 2);
                RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.CenterVertically, gapComposer2, 48);
                long j2 = gapComposer2.compositeKeyHashCode;
                int i9 = (int) (j2 ^ (j2 >>> 32));
                PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierM130paddingVpY3zN4$default);
                ComposeUiNode.Companion.getClass();
                layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                gapComposer2.startReusableNode();
                if (gapComposer2.inserting) {
                    gapComposer2.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    gapComposer2.useNode();
                }
                Stack.m295setimpl(gapComposer2, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                Stack.m295setimpl(gapComposer2, Integer.valueOf(i9), ComposeUiNode.Companion.SetCompositeKeyHash);
                Stack.m294reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                long j3 = jColor;
                Color color5 = color3;
                IconKt.m249Iconww6aTOc(imageVector, null, SizeKt.m140size3ABfNKs(companion, 20), j3, gapComposer2, (i4 & 14) | 432, 0);
                OffsetKt.Spacer(gapComposer2, SizeKt.m144width3ABfNKs(companion, 14));
                TextStyle textStyle = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyMedium;
                if (z6) {
                    fontWeight = FontWeight.SemiBold;
                } else {
                    fontWeight = FontWeight.Medium;
                }
                TextKt.m275TextNvy7gAk(str, null, j3, 0L, null, fontWeight, 0L, null, 0L, 0, false, 0, 0, textStyle, gapComposer, (i4 >> 3) & 14, 0, 131002);
                gapComposer2 = gapComposer;
                gapComposer2.end(true);
                z7 = z5;
                color4 = color5;
                z8 = z6;
            } else {
                gapComposer2.skipToGroupEnd();
                z7 = z3;
                color4 = color2;
                z8 = z4;
            }
            recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.github.kr328.clash.compose.profiles.ProfileCardKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        ProfileCardKt.m809ProfileMenuRowjM_yU8I(imageVector, str, function0, z7, color4, z8, (GapComposer) obj, Stack.updateChangedFlags(i | 1), i2);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i4 |= 196608;
        z4 = z2;
        if ((74899 & i4) == 74898) {
            if (i6 != 0) {
                z5 = true;
            } else {
                z5 = z3;
            }
            if (i7 != 0) {
                color3 = null;
            } else {
                color3 = color2;
            }
            if (i8 != 0) {
                z6 = false;
            } else {
                z6 = z4;
            }
            appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            if (!z5) {
                long j4 = appColors.textSecondary;
                jColor = BrushKt.Color(Color.m440getRedimpl(j4), Color.m439getGreenimpl(j4), Color.m437getBlueimpl(j4), 0.6f, Color.m438getColorSpaceimpl(j4));
            } else if (color3 != null) {
                jColor = color3.value;
            } else {
                jColor = appColors.textPrimary;
            }
            Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
            Modifier modifierM130paddingVpY3zN4$default2 = OffsetKt.m130paddingVpY3zN4$default(ImageKt.m51clickableoSLSa3U$default(SizeKt.m135height3ABfNKs(SizeKt.fillMaxWidth(companion2, 1.0f), 46), z5, null, function0, 14), 16, 0.0f, 2);
            RowMeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.CenterVertically, gapComposer2, 48);
            long j5 = gapComposer2.compositeKeyHashCode;
            int i10 = (int) (j5 ^ (j5 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer2, modifierM130paddingVpY3zN4$default2);
            ComposeUiNode.Companion.getClass();
            layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer2.useNode();
            }
            Stack.m295setimpl(gapComposer2, rowMeasurePolicy2, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope2, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m295setimpl(gapComposer2, Integer.valueOf(i10), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m294reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier2, ComposeUiNode.Companion.SetModifier);
            long j6 = jColor;
            Color color6 = color3;
            IconKt.m249Iconww6aTOc(imageVector, null, SizeKt.m140size3ABfNKs(companion2, 20), j6, gapComposer2, (i4 & 14) | 432, 0);
            OffsetKt.Spacer(gapComposer2, SizeKt.m144width3ABfNKs(companion2, 14));
            TextStyle textStyle2 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyMedium;
            if (z6) {
                fontWeight = FontWeight.SemiBold;
            } else {
                fontWeight = FontWeight.Medium;
            }
            TextKt.m275TextNvy7gAk(str, null, j6, 0L, null, fontWeight, 0L, null, 0L, 0, false, 0, 0, textStyle2, gapComposer, (i4 >> 3) & 14, 0, 131002);
            gapComposer2 = gapComposer;
            gapComposer2.end(true);
            z7 = z5;
            color4 = color6;
            z8 = z6;
        } else {
            if (i6 != 0) {
                z5 = true;
            } else {
                z5 = z3;
            }
            if (i7 != 0) {
                color3 = null;
            } else {
                color3 = color2;
            }
            if (i8 != 0) {
                z6 = false;
            } else {
                z6 = z4;
            }
            appColors = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            if (!z5) {
                long j7 = appColors.textSecondary;
                jColor = BrushKt.Color(Color.m440getRedimpl(j7), Color.m439getGreenimpl(j7), Color.m437getBlueimpl(j7), 0.6f, Color.m438getColorSpaceimpl(j7));
            } else if (color3 != null) {
                jColor = color3.value;
            } else {
                jColor = appColors.textPrimary;
            }
            Modifier.Companion companion3 = Modifier.Companion.$$INSTANCE;
            Modifier modifierM130paddingVpY3zN4$default3 = OffsetKt.m130paddingVpY3zN4$default(ImageKt.m51clickableoSLSa3U$default(SizeKt.m135height3ABfNKs(SizeKt.fillMaxWidth(companion3, 1.0f), 46), z5, null, function0, 14), 16, 0.0f, 2);
            RowMeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.CenterVertically, gapComposer2, 48);
            long j8 = gapComposer2.compositeKeyHashCode;
            int i11 = (int) (j8 ^ (j8 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope3 = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier3 = AbsoluteAlignment.materializeModifier(gapComposer2, modifierM130paddingVpY3zN4$default3);
            ComposeUiNode.Companion.getClass();
            layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer2.useNode();
            }
            Stack.m295setimpl(gapComposer2, rowMeasurePolicy3, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope3, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m295setimpl(gapComposer2, Integer.valueOf(i11), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m294reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier3, ComposeUiNode.Companion.SetModifier);
            long j9 = jColor;
            Color color7 = color3;
            IconKt.m249Iconww6aTOc(imageVector, null, SizeKt.m140size3ABfNKs(companion3, 20), j9, gapComposer2, (i4 & 14) | 432, 0);
            OffsetKt.Spacer(gapComposer2, SizeKt.m144width3ABfNKs(companion3, 14));
            TextStyle textStyle3 = ((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.bodyMedium;
            if (z6) {
                fontWeight = FontWeight.SemiBold;
            } else {
                fontWeight = FontWeight.Medium;
            }
            TextKt.m275TextNvy7gAk(str, null, j9, 0L, null, fontWeight, 0L, null, 0L, 0, false, 0, 0, textStyle3, gapComposer, (i4 >> 3) & 14, 0, 131002);
            gapComposer2 = gapComposer;
            gapComposer2.end(true);
            z7 = z5;
            color4 = color7;
            z8 = z6;
        }
        recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: com.github.kr328.clash.compose.profiles.ProfileCardKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    ProfileCardKt.m809ProfileMenuRowjM_yU8I(imageVector, str, function0, z7, color4, z8, (GapComposer) obj, Stack.updateChangedFlags(i | 1), i2);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void TrafficDaysRow(Profile profile, GapComposer gapComposer, int i) {
        int i2;
        Modifier.Companion companion;
        long j;
        StaticProvidableCompositionLocal staticProvidableCompositionLocal;
        AppColors appColors;
        Profile profile2 = profile;
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(200469129);
        if ((i & 6) == 0) {
            i2 = i | (gapComposer2.changedInstance(profile2) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
        } else {
            AppColors appColors2 = (AppColors) gapComposer2.consume(AppColorsKt.LocalAppColors);
            Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
            Modifier modifierM135height3ABfNKs = SizeKt.m135height3ABfNKs(SizeKt.fillMaxWidth(companion2, 1.0f), 56);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.SpaceBetween, Alignment.Companion.CenterVertically, gapComposer2, 54);
            long j2 = gapComposer2.compositeKeyHashCode;
            int i3 = (int) (j2 ^ (j2 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierM135height3ABfNKs);
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
            Integer numValueOf = Integer.valueOf(i3);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m295setimpl(gapComposer2, numValueOf, composeUiNode$Companion$SetModifier$3);
            OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
            Stack.m294reconcileimpl(gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
            if (1.0f <= 0.0d) {
                InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
            }
            LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
            BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
            Arrangement$Center$1 arrangement$Center$1 = Arrangement.Center;
            ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement$Center$1, horizontal, gapComposer2, 54);
            long j3 = gapComposer2.compositeKeyHashCode;
            int i4 = (int) (j3 ^ (j3 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer2, layoutWeightElement);
            gapComposer2.startReusableNode();
            if (gapComposer2.inserting) {
                gapComposer2.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer2.useNode();
            }
            Stack.m295setimpl(gapComposer2, columnMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
            ImageAnalysis$$ExternalSyntheticLambda1.m(i4, gapComposer2, composeUiNode$Companion$SetModifier$3, gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
            String strStringResource = StringResources_androidKt.stringResource(R.string.profile_traffic_remaining, gapComposer2);
            StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = MaterialThemeKt._localMaterialTheme;
            TextStyle textStyle = ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal2)).typography.bodySmall;
            long j4 = appColors2.textSecondary;
            FontWeight fontWeight = FontWeight.Medium;
            TextKt.m275TextNvy7gAk(strStringResource, null, j4, 0L, null, fontWeight, 0L, null, 0L, 0, false, 0, 0, textStyle, gapComposer, 1572864, 0, 131002);
            GapComposer gapComposer3 = gapComposer;
            float f = 2;
            OffsetKt.Spacer(gapComposer3, SizeKt.m135height3ABfNKs(companion2, f));
            long j5 = profile.total;
            long j6 = profile.upload + profile.download;
            if (j5 > 0) {
                gapComposer3.startReplaceGroup(1907892512);
                j = 0;
                staticProvidableCompositionLocal = staticProvidableCompositionLocal2;
                companion = companion2;
                TextKt.m275TextNvy7gAk(FormatKt.formatBytesRemaining(Math.max(0L, j5 - j6)), null, appColors2.textPrimary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer3.consume(staticProvidableCompositionLocal2)).typography.titleMedium, gapComposer, 0, 0, 131066);
                gapComposer3 = gapComposer;
                gapComposer3.end(false);
                appColors = appColors2;
            } else {
                companion = companion2;
                j = 0;
                staticProvidableCompositionLocal = staticProvidableCompositionLocal2;
                gapComposer3.startReplaceGroup(1908136575);
                appColors = appColors2;
                IconKt.m249Iconww6aTOc(Cookie.Companion.getAllInclusive(), null, null, appColors.textPrimary, gapComposer3, 48, 4);
                gapComposer3.end(false);
            }
            gapComposer3.end(true);
            Modifier.Companion companion3 = companion;
            ScrimKt.m268VerticalDivider9IZ8Weo(SizeKt.m144width3ABfNKs(SizeKt.m135height3ABfNKs(companion3, 36), 1), 0.0f, profile.active ? appColors.accentBorder : appColors.cardBorder, gapComposer, 6);
            if (1.0f <= 0.0d) {
                InlineClassHelperKt.throwIllegalArgumentException("invalid weight; must be greater than zero");
            }
            LayoutWeightElement layoutWeightElement2 = new LayoutWeightElement(1.0f, true);
            ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement$Center$1, horizontal, gapComposer, 54);
            long j7 = gapComposer.compositeKeyHashCode;
            int i5 = (int) (j7 ^ (j7 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope3 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier3 = AbsoluteAlignment.materializeModifier(gapComposer, layoutWeightElement2);
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer.useNode();
            }
            Stack.m295setimpl(gapComposer, columnMeasurePolicy2, composeUiNode$Companion$SetModifier$1);
            Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope3, composeUiNode$Companion$SetModifier$2);
            ImageAnalysis$$ExternalSyntheticLambda1.m(i5, gapComposer, composeUiNode$Companion$SetModifier$3, gapComposer, ownerSnapshotObserver$onCommitAffectingLayout$1);
            Stack.m295setimpl(gapComposer, modifierMaterializeModifier3, composeUiNode$Companion$SetModifier$4);
            StaticProvidableCompositionLocal staticProvidableCompositionLocal3 = staticProvidableCompositionLocal;
            AppColors appColors3 = appColors;
            TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.profile_days_remaining, gapComposer), null, appColors.textSecondary, 0L, null, fontWeight, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(staticProvidableCompositionLocal3)).typography.bodySmall, gapComposer, 1572864, 0, 131002);
            gapComposer2 = gapComposer;
            OffsetKt.Spacer(gapComposer2, SizeKt.m135height3ABfNKs(companion3, f));
            profile2 = profile;
            long j8 = profile2.expire;
            if (j8 > j) {
                gapComposer2.startReplaceGroup(1909124793);
                long jCurrentTimeMillis = (j8 - (System.currentTimeMillis() / 1000)) / 86400;
                if (jCurrentTimeMillis < j) {
                    jCurrentTimeMillis = j;
                }
                TextKt.m275TextNvy7gAk(String.valueOf(jCurrentTimeMillis), null, appColors3.textPrimary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer2.consume(staticProvidableCompositionLocal3)).typography.titleMedium, gapComposer, 0, 0, 131066);
                gapComposer2 = gapComposer;
                gapComposer2.end(false);
            } else {
                gapComposer2.startReplaceGroup(1909467839);
                IconKt.m249Iconww6aTOc(Cookie.Companion.getAllInclusive(), null, null, appColors3.textPrimary, gapComposer2, 48, 4);
                gapComposer2.end(false);
            }
            gapComposer2.end(true);
            gapComposer2.end(true);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ProfileCardKt$$ExternalSyntheticLambda13(profile2, i, 0);
        }
    }
}
