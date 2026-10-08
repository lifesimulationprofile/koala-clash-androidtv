package androidx.compose.material3;

import androidx.activity.ImmLeaksCleaner$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.HorizontalAlignElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.material3.internal.LayoutUtilKt;
import androidx.compose.material3.tokens.DialogTokens;
import androidx.compose.runtime.DynamicProvidableCompositionLocal;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetModifier$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayout$1;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.window.DialogProperties;
import androidx.core.view.MenuHostHelper;
import coil.compose.AsyncImageKt$$ExternalSyntheticLambda1;
import coil.network.HttpException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AlertDialogKt {
    public static final float ButtonsCrossAxisSpacing;
    public static final float ButtonsMainAxisSpacing;
    public static final PaddingValuesImpl DialogPadding;
    public static final PaddingValuesImpl IconPadding;
    public static final DynamicProvidableCompositionLocal LocalBasicAlertDialogOverride;
    public static final PaddingValuesImpl TextPadding;
    public static final PaddingValuesImpl TitlePadding;
    public static final float DialogMinWidth = 280;
    public static final float DialogMaxWidth = 560;

    static {
        float f = 8;
        ButtonsMainAxisSpacing = f;
        ButtonsCrossAxisSpacing = f;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = PrecisionPointer.shouldUsePrecisionPointerComponentSizing;
        float f2 = ((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue() ? 20 : 24;
        float f3 = ((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue() ? 16 : 24;
        DialogPadding = new PaddingValuesImpl(f2, f2, f2, f2);
        float f4 = 16;
        IconPadding = OffsetKt.m124PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, f4, 7);
        TitlePadding = OffsetKt.m124PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, f4, 7);
        TextPadding = OffsetKt.m124PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, f3, 7);
        LocalBasicAlertDialogOverride = new DynamicProvidableCompositionLocal(new ImmLeaksCleaner$$ExternalSyntheticLambda0(19));
    }

    /* JADX INFO: renamed from: AlertDialogContent-4hvqGtA, reason: not valid java name */
    public static final void m233AlertDialogContent4hvqGtA(final ComposableLambdaImpl composableLambdaImpl, Modifier modifier, final Function2 function2, final Function2 function3, final Function2 function4, final Shape shape, final long j, final float f, final long j2, final long j3, final long j4, final long j5, GapComposer gapComposer, final int i) {
        final Modifier modifier2;
        gapComposer.startRestartGroup(1378716401);
        int i2 = i | 48 | (gapComposer.changedInstance(function2) ? 256 : 128) | (gapComposer.changedInstance(function3) ? 2048 : 1024) | (gapComposer.changedInstance(function4) ? 16384 : 8192) | (gapComposer.changed(shape) ? 131072 : 65536) | (gapComposer.changed(j) ? 1048576 : 524288) | (gapComposer.changed(f) ? 8388608 : 4194304) | (gapComposer.changed(j2) ? 67108864 : 33554432) | (gapComposer.changed(j3) ? 536870912 : 268435456);
        if (gapComposer.shouldExecute(i2 & 1, ((i2 & 306783379) == 306783378 && (((gapComposer.changed(j4) ? (char) 4 : (char) 2) | (gapComposer.changed(j5) ? ' ' : (char) 16)) & 19) == 18) ? false : true)) {
            ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Thread_jvmKt.rememberComposableLambda(-652798794, new Function2() { // from class: androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    TextStyle value;
                    GapComposer gapComposer2 = (GapComposer) obj;
                    int iIntValue = ((Integer) obj2).intValue();
                    int i3 = 1;
                    int i4 = 2;
                    boolean z = (iIntValue & 3) != 2;
                    MenuHostHelper menuHostHelper = gapComposer2.applier;
                    if (gapComposer2.shouldExecute(iIntValue & 1, z)) {
                        Modifier modifierPadding = OffsetKt.padding(Modifier.Companion.$$INSTANCE, AlertDialogKt.DialogPadding);
                        ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, gapComposer2, 0);
                        long j6 = gapComposer2.compositeKeyHashCode;
                        int i5 = (int) (j6 ^ (j6 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierPadding);
                        ComposeUiNode.Companion.getClass();
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                        gapComposer2.startReusableNode();
                        if (gapComposer2.inserting) {
                            gapComposer2.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer2.useNode();
                        }
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$1 = ComposeUiNode.Companion.SetMeasurePolicy;
                        Stack.m295setimpl(gapComposer2, columnMeasurePolicy, composeUiNode$Companion$SetModifier$1);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                        Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, composeUiNode$Companion$SetModifier$2);
                        Integer numValueOf = Integer.valueOf(i5);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
                        Stack.m295setimpl(gapComposer2, numValueOf, composeUiNode$Companion$SetModifier$3);
                        OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
                        Stack.m294reconcileimpl(gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
                        Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
                        Function2 function5 = function2;
                        if (function5 == null) {
                            gapComposer2.startReplaceGroup(346092326);
                            gapComposer2.end(false);
                        } else {
                            gapComposer2.startReplaceGroup(346092327);
                            Stack.CompositionLocalProvider(ContentColorKt.LocalContentColor.defaultProvidedValue$runtime(new Color(j3)), Thread_jvmKt.rememberComposableLambda(-1128150638, new ScaffoldKt$$ExternalSyntheticLambda3(i4, function5), gapComposer2), gapComposer2, 56);
                            gapComposer2.end(false);
                        }
                        Function2 function6 = function3;
                        if (function6 == null) {
                            gapComposer2.startReplaceGroup(346408309);
                            gapComposer2.end(false);
                        } else {
                            gapComposer2.startReplaceGroup(346408310);
                            if (((Boolean) PrecisionPointer.shouldUsePrecisionPointerComponentSizing.getValue()).booleanValue()) {
                                gapComposer2.startReplaceGroup(1812109189);
                                value = TextStyle.m647copyp1EtxEg$default(((MaterialTheme$Values) gapComposer2.consume(MaterialThemeKt._localMaterialTheme)).typography.headlineSmall, 0L, TextUnitKt.getSp(20), null, null, 0L, TextUnitKt.getSp(26), null, 16646141);
                                gapComposer2.end(false);
                            } else {
                                gapComposer2.startReplaceGroup(1812321322);
                                value = TypographyKt.getValue(DialogTokens.HeadlineFont, gapComposer2);
                                gapComposer2.end(false);
                            }
                            LayoutUtilKt.m281ProvideContentColorTextStyle3JVO9M(j4, value, Thread_jvmKt.rememberComposableLambda(71284337, new TextKt$$ExternalSyntheticLambda2(11, function5, function6), gapComposer2), gapComposer2, 384);
                            gapComposer2.end(false);
                        }
                        Function2 function7 = function4;
                        if (function7 == null) {
                            gapComposer2.startReplaceGroup(347550969);
                            gapComposer2.end(false);
                        } else {
                            gapComposer2.startReplaceGroup(347550970);
                            LayoutUtilKt.m281ProvideContentColorTextStyle3JVO9M(j5, TypographyKt.getValue(DialogTokens.SupportingTextFont, gapComposer2), Thread_jvmKt.rememberComposableLambda(705583346, new ScaffoldKt$$ExternalSyntheticLambda3(i3, function7), gapComposer2), gapComposer2, 384);
                            gapComposer2.end(false);
                        }
                        HorizontalAlignElement horizontalAlignElement = new HorizontalAlignElement(Alignment.Companion.End);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                        long j7 = gapComposer2.compositeKeyHashCode;
                        int i6 = (int) (j7 ^ (j7 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer2, horizontalAlignElement);
                        gapComposer2.startReusableNode();
                        if (gapComposer2.inserting) {
                            gapComposer2.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer2.useNode();
                        }
                        Stack.m295setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, composeUiNode$Companion$SetModifier$1);
                        Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
                        Modifier.CC.m(i6, gapComposer2, composeUiNode$Companion$SetModifier$3, gapComposer2, ownerSnapshotObserver$onCommitAffectingLayout$1);
                        Stack.m295setimpl(gapComposer2, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
                        int i7 = DialogTokens.ContainerShape;
                        LayoutUtilKt.m281ProvideContentColorTextStyle3JVO9M(j2, TypographyKt.getValue(10, gapComposer2), composableLambdaImpl, gapComposer2, 0);
                        gapComposer2.end(true);
                        gapComposer2.end(true);
                    } else {
                        gapComposer2.skipToGroupEnd();
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer);
            int i3 = i2 >> 12;
            int i4 = (i3 & 896) | (i3 & 112) | 12582918 | ((i2 >> 9) & 57344);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            SurfaceKt.m269SurfaceT9BRK9s(companion, shape, j, 0L, f, 0.0f, composableLambdaImplRememberComposableLambda, gapComposer, i4, 104);
            modifier2 = companion;
        } else {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2(modifier2, function2, function3, function4, shape, j, f, j2, j3, j4, j5, i) { // from class: androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda7
                public final /* synthetic */ Modifier f$1;
                public final /* synthetic */ long f$10;
                public final /* synthetic */ long f$11;
                public final /* synthetic */ Function2 f$2;
                public final /* synthetic */ Function2 f$3;
                public final /* synthetic */ Function2 f$4;
                public final /* synthetic */ Shape f$5;
                public final /* synthetic */ long f$6;
                public final /* synthetic */ float f$7;
                public final /* synthetic */ long f$8;
                public final /* synthetic */ long f$9;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(7);
                    AlertDialogKt.m233AlertDialogContent4hvqGtA(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, this.f$9, this.f$10, this.f$11, (GapComposer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX INFO: renamed from: AlertDialogFlowRow-ixp7dh8, reason: not valid java name */
    public static final void m234AlertDialogFlowRowixp7dh8(final float f, final ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, final int i) {
        LayoutDirection layoutDirection;
        gapComposer.startRestartGroup(-917637668);
        int i2 = (gapComposer.changed(f) ? 32 : 16) | i;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = CompositionLocalsKt.LocalLayoutDirection;
            final LayoutDirection layoutDirection2 = (LayoutDirection) gapComposer.consume(staticProvidableCompositionLocal);
            int iOrdinal = layoutDirection2.ordinal();
            if (iOrdinal == 0) {
                layoutDirection = LayoutDirection.Rtl;
            } else {
                if (iOrdinal != 1) {
                    throw new HttpException();
                }
                layoutDirection = LayoutDirection.Ltr;
            }
            Stack.CompositionLocalProvider(staticProvidableCompositionLocal.defaultProvidedValue$runtime(layoutDirection), Thread_jvmKt.rememberComposableLambda(-1986402020, new Function2() { // from class: androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda12
                {
                    float f2 = AlertDialogKt.DialogMinWidth;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    float f2 = AlertDialogKt.ButtonsMainAxisSpacing;
                    GapComposer gapComposer2 = (GapComposer) obj;
                    int iIntValue = ((Integer) obj2).intValue();
                    if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                        OffsetKt.FlowRow(null, Arrangement.m111spacedBy0680j_4(f2), Arrangement.m111spacedBy0680j_4(f), null, 0, 0, Thread_jvmKt.rememberComposableLambda(879927511, new AlertDialogKt$$ExternalSyntheticLambda14(0, layoutDirection2, composableLambdaImpl), gapComposer2), gapComposer2, 1572864);
                    } else {
                        gapComposer2.skipToGroupEnd();
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, 56);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2(f, composableLambdaImpl, i) { // from class: androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda13
                public final /* synthetic */ float f$1;
                public final /* synthetic */ ComposableLambdaImpl f$2;

                {
                    float f2 = AlertDialogKt.DialogMinWidth;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    float f2 = AlertDialogKt.DialogMinWidth;
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(391);
                    AlertDialogKt.m234AlertDialogFlowRowixp7dh8(this.f$1, this.f$2, (GapComposer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX INFO: renamed from: AlertDialogImpl-wrnwzgE, reason: not valid java name */
    public static final void m235AlertDialogImplwrnwzgE(Function0 function0, ComposableLambdaImpl composableLambdaImpl, Modifier modifier, Function2 function2, final Function2 function3, final Function2 function4, final Function2 function5, final Shape shape, final long j, final long j2, final long j3, final long j4, final float f, DialogProperties dialogProperties, GapComposer gapComposer, int i, int i2) {
        int i3;
        ComposableLambdaImpl composableLambdaImpl2;
        Function2 function6;
        int i4;
        gapComposer.startRestartGroup(-867616355);
        if ((i & 6) == 0) {
            i3 = (gapComposer.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            composableLambdaImpl2 = composableLambdaImpl;
            i3 |= gapComposer.changedInstance(composableLambdaImpl2) ? 32 : 16;
        } else {
            composableLambdaImpl2 = composableLambdaImpl;
        }
        if ((i & 384) == 0) {
            i3 |= gapComposer.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            function6 = function2;
            i3 |= gapComposer.changedInstance(function6) ? 2048 : 1024;
        } else {
            function6 = function2;
        }
        if ((i & 24576) == 0) {
            i3 |= gapComposer.changedInstance(function3) ? 16384 : 8192;
        }
        if ((i & 196608) == 0) {
            i3 |= gapComposer.changedInstance(function4) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i3 |= gapComposer.changedInstance(function5) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= gapComposer.changed(shape) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= gapComposer.changed(j) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= gapComposer.changed(j2) ? 536870912 : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (gapComposer.changed(j3) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= gapComposer.changed(j4) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= gapComposer.changed(f) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= gapComposer.changed(dialogProperties) ? 2048 : 1024;
        }
        int i5 = i4;
        if (gapComposer.shouldExecute(i3 & 1, ((i3 & 306783379) == 306783378 && (i5 & 1171) == 1170) ? false : true)) {
            final ComposableLambdaImpl composableLambdaImpl3 = composableLambdaImpl2;
            final Function2 function7 = function6;
            BasicAlertDialog(function0, modifier, dialogProperties, Thread_jvmKt.rememberComposableLambda(527420759, new Function2() { // from class: androidx.compose.material3.AlertDialogKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    GapComposer gapComposer2 = (GapComposer) obj;
                    int iIntValue = ((Integer) obj2).intValue();
                    int i6 = 0;
                    if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                        ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Thread_jvmKt.rememberComposableLambda(1367541877, new AlertDialogKt$$ExternalSyntheticLambda4(composableLambdaImpl3, function7, i6), gapComposer2);
                        int i7 = DialogTokens.ContainerShape;
                        AlertDialogKt.m233AlertDialogContent4hvqGtA(composableLambdaImplRememberComposableLambda, null, function3, function4, function5, shape, j, f, ColorSchemeKt.getValue(26, gapComposer2), j2, j3, j4, gapComposer2, 6);
                    } else {
                        gapComposer2.skipToGroupEnd();
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, (i3 & 14) | 3072 | ((i3 >> 3) & 112) | ((i5 >> 3) & 896));
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AlertDialogKt$$ExternalSyntheticLambda2(function0, composableLambdaImpl, modifier, function2, function3, function4, function5, shape, j, j2, j3, j4, f, dialogProperties, i, i2, 0);
        }
    }

    public static final void BasicAlertDialog(Function0 function0, Modifier modifier, DialogProperties dialogProperties, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        int i2;
        gapComposer.startRestartGroup(24925658);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(modifier) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changed(dialogProperties) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl) ? 2048 : 1024;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 1171) != 1170)) {
            ((DefaultBasicAlertDialogOverride) gapComposer.consume(LocalBasicAlertDialogOverride)).BasicAlertDialog(new Dispatcher(function0, modifier, dialogProperties, composableLambdaImpl), gapComposer, 0);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AsyncImageKt$$ExternalSyntheticLambda1(function0, modifier, dialogProperties, composableLambdaImpl, i);
        }
    }
}
