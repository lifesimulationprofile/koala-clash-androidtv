package androidx.compose.material3.internal;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.compose.animation.CrossfadeKt$Crossfade$3$1;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TwoWayConverterImpl;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.FlowLayoutKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.ButtonKt$$ExternalSyntheticLambda2;
import androidx.compose.material3.InteractiveComponentSizeKt;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.ModalBottomSheetKt$$ExternalSyntheticLambda10;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextFieldLabelPosition$Attached;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.material3.TooltipKt$TooltipBox$$inlined$animateFloat$1;
import androidx.compose.material3.Typography;
import androidx.compose.material3.tokens.SmallIconButtonTokens;
import androidx.compose.material3.tokens.TypeScaleTokens;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SnapshotStateKt__DerivedStateKt;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotId_jvmKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.EmojiSupportMatch;
import androidx.compose.ui.text.ParagraphStyle;
import androidx.compose.ui.text.ParagraphStyleKt;
import androidx.compose.ui.text.PlatformParagraphStyle;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.SpanStyleKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.SystemFontFamily;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.BrushStyle;
import androidx.compose.ui.text.style.ColorStyle;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextDrawStyleKt;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.MathHelpersKt;
import androidx.core.view.MenuHostHelper;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.Navigator;
import coil.network.HttpException;
import com.github.kr328.clash.compose.util.TvGlassTabRowKt$$ExternalSyntheticLambda6;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class TextFieldImplKt {
    public static final float MinFocusedLabelLineHeight;
    public static final float MinSupportingTextLineHeight;
    public static final float TextFieldPadding;
    public static final float SupportingTopPadding = 4;
    public static final float PrefixSuffixTextPadding = 2;
    public static final float MinTextLineHeight = 24;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[CaptureSession$State$EnumUnboxingLocalUtility.values(2).length];
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[InputPhase.values().length];
            try {
                iArr2[0] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[2] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    static {
        float f = 16;
        TextFieldPadding = f;
        MinFocusedLabelLineHeight = f;
        MinSupportingTextLineHeight = f;
    }

    /* JADX WARN: Code duplicated, block: B:211:0x0303  */
    /* JADX WARN: Code duplicated, block: B:248:0x03dd  */
    public static final void CommonDecorationBox(final CharSequence charSequence, final Function2 function2, final TextFieldLabelPosition$Attached textFieldLabelPosition$Attached, final Function3 function3, final Function2 function4, final Function2 function5, final boolean z, final boolean z2, final boolean z3, final MutableInteractionSourceImpl mutableInteractionSourceImpl, final PaddingValues paddingValues, final TextFieldColors textFieldColors, final ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, final int i, final int i2) {
        int i3;
        int i4;
        InputPhase inputPhase;
        Transition transition;
        InputPhase inputPhase2;
        Lifecycle lifecycle;
        int i5;
        Transition.TransitionAnimationState transitionAnimationState;
        GapComposer gapComposer2;
        boolean z4;
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation;
        TextStyle textStyle;
        TextFieldColors textFieldColors2;
        final TextStyle textStyle2;
        ComposableLambdaImpl composableLambdaImplRememberComposableLambda;
        final long j;
        ComposableLambdaImpl composableLambdaImpl2;
        long j2;
        boolean z5;
        GapComposer gapComposer3;
        ComposableLambdaImpl composableLambdaImplRememberComposableLambda2;
        int i6;
        Object objMo773getCurrentState;
        float f;
        Object objMo773getCurrentState2;
        float f2;
        float f3;
        boolean zChanged;
        Object objRememberedValue;
        GapComposer gapComposer4 = gapComposer;
        NeverEqualPolicy neverEqualPolicy = NeverEqualPolicy.INSTANCE$3;
        TwoWayConverterImpl twoWayConverterImpl = ArcSplineKt.FloatToVector;
        gapComposer4.startRestartGroup(546805032);
        if ((i & 6) == 0) {
            i3 = (gapComposer4.changed(CaptureSession$State$EnumUnboxingLocalUtility.ordinal(2)) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= gapComposer4.changedInstance(charSequence) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= gapComposer4.changedInstance(function2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= gapComposer4.changed(textFieldLabelPosition$Attached) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= gapComposer4.changedInstance(function3) ? 16384 : 8192;
        }
        if ((i & 196608) == 0) {
            i3 |= gapComposer4.changedInstance(function4) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i3 |= gapComposer4.changedInstance(null) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= gapComposer4.changedInstance(null) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= gapComposer4.changedInstance(null) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= gapComposer4.changedInstance(null) ? 536870912 : 268435456;
        }
        int i7 = i3;
        if ((i2 & 6) == 0) {
            i4 = (gapComposer4.changedInstance(function5) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= gapComposer4.changed(z) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= gapComposer4.changed(z2) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= gapComposer4.changed(z3) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= gapComposer4.changed(mutableInteractionSourceImpl) ? 16384 : 8192;
        }
        if ((i2 & 196608) == 0) {
            i4 |= gapComposer4.changed(paddingValues) ? 131072 : 65536;
        }
        if ((i2 & 1572864) == 0) {
            i4 |= gapComposer4.changed(textFieldColors) ? 1048576 : 524288;
        }
        if ((i2 & 12582912) == 0) {
            i4 |= gapComposer4.changedInstance(composableLambdaImpl) ? 8388608 : 4194304;
        }
        int i8 = i4;
        if (gapComposer4.shouldExecute(i7 & 1, ((306783379 & i7) == 306783378 && (i8 & 4793491) == 4793490) ? false : true)) {
            boolean zBooleanValue = ((Boolean) ChannelKt.collectIsFocusedAsState(mutableInteractionSourceImpl, gapComposer4, (i8 >> 12) & 14).getValue()).booleanValue();
            InputPhase inputPhase3 = InputPhase.UnfocusedNotEmpty;
            InputPhase inputPhase4 = InputPhase.UnfocusedEmpty;
            InputPhase inputPhase5 = InputPhase.Focused;
            if (zBooleanValue) {
                inputPhase = inputPhase5;
            } else {
                inputPhase = charSequence.length() == 0 ? inputPhase4 : inputPhase3;
            }
            Typography typography = ((MaterialTheme$Values) gapComposer4.consume(MaterialThemeKt._localMaterialTheme)).typography;
            TextStyle textStyle3 = typography.bodyLarge;
            TextStyle textStyle4 = typography.bodySmall;
            long jM649getColor0d7_KjU = textStyle3.m649getColor0d7_KjU();
            long j3 = Color.Unspecified;
            boolean z6 = (Color.m435equalsimpl0(jM649getColor0d7_KjU, j3) && !Color.m435equalsimpl0(textStyle4.m649getColor0d7_KjU(), j3)) || (!Color.m435equalsimpl0(textStyle3.m649getColor0d7_KjU(), j3) && Color.m435equalsimpl0(textStyle4.m649getColor0d7_KjU(), j3));
            Transition transitionUpdateTransition = ArcSplineKt.updateTransition(inputPhase, "TextFieldInputState", gapComposer4, 48, 0);
            Lifecycle lifecycle2 = transitionUpdateTransition.transitionState;
            boolean z7 = function3 != null;
            float f4 = 1.0f;
            NeverEqualPolicy neverEqualPolicy2 = Composer$Companion.Empty;
            boolean z8 = z7;
            if (function3 != null) {
                gapComposer4.startReplaceGroup(-940723593);
                FiniteAnimationSpec finiteAnimationSpecValue = ScrimKt.value(2, gapComposer4);
                if (transitionUpdateTransition.isSeeking()) {
                    lifecycle = lifecycle2;
                    gapComposer4.startReplaceGroup(1666827533);
                    gapComposer4.end(false);
                    objMo773getCurrentState2 = lifecycle.mo773getCurrentState();
                } else {
                    gapComposer4.startReplaceGroup(1666573488);
                    boolean zChanged2 = gapComposer4.changed(transitionUpdateTransition);
                    objMo773getCurrentState2 = gapComposer4.rememberedValue();
                    if (zChanged2 || objMo773getCurrentState2 == neverEqualPolicy2) {
                        Snapshot currentThreadSnapshot = SnapshotId_jvmKt.getCurrentThreadSnapshot();
                        Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                        lifecycle = lifecycle2;
                        Snapshot snapshotMakeCurrentNonObservable = SnapshotId_jvmKt.makeCurrentNonObservable(currentThreadSnapshot);
                        try {
                            Object objMo773getCurrentState3 = lifecycle.mo773getCurrentState();
                            SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                            gapComposer4.updateRememberedValue(objMo773getCurrentState3);
                            objMo773getCurrentState2 = objMo773getCurrentState3;
                        } catch (Throwable th) {
                            SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                            throw th;
                        }
                    } else {
                        lifecycle = lifecycle2;
                    }
                    gapComposer4.end(false);
                }
                gapComposer4.startReplaceGroup(1071902915);
                int iOrdinal = ((InputPhase) objMo773getCurrentState2).ordinal();
                if (iOrdinal == 0) {
                    f2 = 1.0f;
                } else {
                    if (iOrdinal != 1) {
                        if (iOrdinal != 2) {
                            throw new HttpException();
                        }
                    } else if (z8) {
                        f2 = 0.0f;
                    }
                    f2 = 1.0f;
                }
                gapComposer4.end(false);
                Float fValueOf = Float.valueOf(f2);
                boolean zChanged3 = gapComposer4.changed(transitionUpdateTransition);
                Object objRememberedValue2 = gapComposer4.rememberedValue();
                if (zChanged3 || objRememberedValue2 == neverEqualPolicy2) {
                    objRememberedValue2 = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionUpdateTransition, 16));
                    gapComposer4.updateRememberedValue(objRememberedValue2);
                }
                InputPhase inputPhase6 = (InputPhase) ((State) objRememberedValue2).getValue();
                gapComposer4.startReplaceGroup(1071902915);
                int iOrdinal2 = inputPhase6.ordinal();
                if (iOrdinal2 != 0) {
                    if (iOrdinal2 == 1) {
                        if (z8) {
                            f3 = 0.0f;
                        }
                        gapComposer4.end(false);
                        Float fValueOf2 = Float.valueOf(f3);
                        zChanged = gapComposer4.changed(transitionUpdateTransition);
                        objRememberedValue = gapComposer4.rememberedValue();
                        if (zChanged || objRememberedValue == neverEqualPolicy2) {
                            objRememberedValue = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionUpdateTransition, 17));
                            gapComposer4.updateRememberedValue(objRememberedValue);
                        }
                        gapComposer4.startReplaceGroup(1806589607);
                        gapComposer4.end(false);
                        transition = transitionUpdateTransition;
                        inputPhase2 = inputPhase3;
                        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation2 = ArcSplineKt.createTransitionAnimation(transition, fValueOf, fValueOf2, finiteAnimationSpecValue, twoWayConverterImpl, gapComposer4, 196608);
                        gapComposer4 = gapComposer4;
                        gapComposer4.end(false);
                        transitionAnimationState = transitionAnimationStateCreateTransitionAnimation2;
                        i5 = i7;
                    } else if (iOrdinal2 != 2) {
                        throw new HttpException();
                    }
                }
                f3 = 1.0f;
                gapComposer4.end(false);
                Float fValueOf3 = Float.valueOf(f3);
                zChanged = gapComposer4.changed(transitionUpdateTransition);
                objRememberedValue = gapComposer4.rememberedValue();
                if (zChanged) {
                    objRememberedValue = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionUpdateTransition, 17));
                    gapComposer4.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionUpdateTransition, 17));
                    gapComposer4.updateRememberedValue(objRememberedValue);
                }
                gapComposer4.startReplaceGroup(1806589607);
                gapComposer4.end(false);
                transition = transitionUpdateTransition;
                inputPhase2 = inputPhase3;
                Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation3 = ArcSplineKt.createTransitionAnimation(transition, fValueOf, fValueOf3, finiteAnimationSpecValue, twoWayConverterImpl, gapComposer4, 196608);
                gapComposer4 = gapComposer4;
                gapComposer4.end(false);
                transitionAnimationState = transitionAnimationStateCreateTransitionAnimation3;
                i5 = i7;
            } else {
                transition = transitionUpdateTransition;
                inputPhase2 = inputPhase3;
                z6 = z6;
                lifecycle = lifecycle2;
                gapComposer4.startReplaceGroup(-940652386);
                gapComposer4.end(false);
                i5 = i7;
                transitionAnimationState = null;
            }
            if (function4 != null) {
                gapComposer4.startReplaceGroup(-940561742);
                FiniteAnimationSpec finiteAnimationSpecValue2 = ScrimKt.value(5, gapComposer4);
                FiniteAnimationSpec finiteAnimationSpecValue3 = ScrimKt.value(6, gapComposer4);
                if (transition.isSeeking()) {
                    finiteAnimationSpecValue2 = finiteAnimationSpecValue2;
                    gapComposer4.startReplaceGroup(1666827533);
                    gapComposer4.end(false);
                    objMo773getCurrentState = lifecycle.mo773getCurrentState();
                } else {
                    gapComposer4.startReplaceGroup(1666573488);
                    boolean zChanged4 = gapComposer4.changed(transition);
                    objMo773getCurrentState = gapComposer4.rememberedValue();
                    if (zChanged4 || objMo773getCurrentState == neverEqualPolicy2) {
                        Snapshot currentThreadSnapshot2 = SnapshotId_jvmKt.getCurrentThreadSnapshot();
                        Function1 readObserver2 = currentThreadSnapshot2 != null ? currentThreadSnapshot2.getReadObserver() : null;
                        Snapshot snapshotMakeCurrentNonObservable2 = SnapshotId_jvmKt.makeCurrentNonObservable(currentThreadSnapshot2);
                        try {
                            Object objMo773getCurrentState4 = lifecycle.mo773getCurrentState();
                            SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                            gapComposer4.updateRememberedValue(objMo773getCurrentState4);
                            objMo773getCurrentState = objMo773getCurrentState4;
                        } catch (Throwable th2) {
                            SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                            throw th2;
                        }
                    }
                    gapComposer4.end(false);
                }
                gapComposer4.startReplaceGroup(-2037958114);
                int iOrdinal3 = ((InputPhase) objMo773getCurrentState).ordinal();
                if (iOrdinal3 == 0) {
                    f = 1.0f;
                } else {
                    if (iOrdinal3 != 1) {
                        if (iOrdinal3 != 2) {
                            throw new HttpException();
                        }
                    } else if (!z8) {
                        f = 1.0f;
                    }
                    f = 0.0f;
                }
                gapComposer4.end(false);
                Float fValueOf4 = Float.valueOf(f);
                boolean zChanged5 = gapComposer4.changed(transition);
                Object objRememberedValue3 = gapComposer4.rememberedValue();
                if (zChanged5 || objRememberedValue3 == neverEqualPolicy2) {
                    objRememberedValue3 = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transition, 20));
                    gapComposer4.updateRememberedValue(objRememberedValue3);
                }
                InputPhase inputPhase7 = (InputPhase) ((State) objRememberedValue3).getValue();
                gapComposer4.startReplaceGroup(-2037958114);
                int iOrdinal4 = inputPhase7.ordinal();
                if (iOrdinal4 != 0) {
                    if (iOrdinal4 != 1) {
                        if (iOrdinal4 != 2) {
                            throw new HttpException();
                        }
                    } else if (z8) {
                    }
                    f4 = 0.0f;
                }
                gapComposer4.end(false);
                Float fValueOf5 = Float.valueOf(f4);
                boolean zChanged6 = gapComposer4.changed(transition);
                Object objRememberedValue4 = gapComposer4.rememberedValue();
                if (zChanged6 || objRememberedValue4 == neverEqualPolicy2) {
                    objRememberedValue4 = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transition, 21));
                    gapComposer4.updateRememberedValue(objRememberedValue4);
                }
                Transition.Segment segment = (Transition.Segment) ((State) objRememberedValue4).getValue();
                gapComposer4.startReplaceGroup(-1370891590);
                if (segment.isTransitioningTo(inputPhase5, inputPhase4) || (!segment.isTransitioningTo(inputPhase4, inputPhase5) && !segment.isTransitioningTo(inputPhase2, inputPhase4))) {
                    finiteAnimationSpecValue3 = finiteAnimationSpecValue2;
                }
                z4 = false;
                gapComposer4.end(false);
                GapComposer gapComposer5 = gapComposer4;
                transitionAnimationStateCreateTransitionAnimation = ArcSplineKt.createTransitionAnimation(transition, fValueOf4, fValueOf5, finiteAnimationSpecValue3, twoWayConverterImpl, gapComposer5, 196608);
                gapComposer2 = gapComposer5;
                gapComposer2.end(false);
            } else {
                gapComposer2 = gapComposer4;
                z4 = false;
                gapComposer2.startReplaceGroup(-940485730);
                gapComposer2.end(false);
                transitionAnimationStateCreateTransitionAnimation = null;
            }
            gapComposer2.startReplaceGroup(-940318082);
            gapComposer2.end(z4);
            if (function3 == null) {
                gapComposer2.startReplaceGroup(-940231841);
                gapComposer2.end(z4);
                textFieldColors2 = textFieldColors;
                textStyle2 = textStyle3;
                textStyle = textStyle4;
                composableLambdaImplRememberComposableLambda = null;
            } else {
                gapComposer2.startReplaceGroup(-940231840);
                textStyle = textStyle4;
                textFieldColors2 = textFieldColors;
                textStyle2 = textStyle3;
                composableLambdaImplRememberComposableLambda = Thread_jvmKt.rememberComposableLambda(1632654811, new TextFieldImplKt$$ExternalSyntheticLambda1(transitionAnimationState, textFieldColors, z2, z3, zBooleanValue, z6, transition, textStyle, textStyle3, function3), gapComposer2);
                gapComposer2.end(z4);
            }
            if (!z2) {
                j = textFieldColors2.disabledPlaceholderColor;
            } else if (z3) {
                j = textFieldColors2.errorPlaceholderColor;
            } else {
                j = zBooleanValue != 0 ? textFieldColors2.focusedPlaceholderColor : textFieldColors2.unfocusedPlaceholderColor;
            }
            Object objRememberedValue5 = gapComposer2.rememberedValue();
            int i9 = 3;
            if (objRememberedValue5 == neverEqualPolicy2) {
                ModalBottomSheetKt$$ExternalSyntheticLambda10 modalBottomSheetKt$$ExternalSyntheticLambda10 = new ModalBottomSheetKt$$ExternalSyntheticLambda10(transitionAnimationStateCreateTransitionAnimation, 3);
                MenuHostHelper menuHostHelper = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
                DerivedSnapshotState derivedSnapshotState = new DerivedSnapshotState(modalBottomSheetKt$$ExternalSyntheticLambda10, neverEqualPolicy);
                gapComposer2.updateRememberedValue(derivedSnapshotState);
                objRememberedValue5 = derivedSnapshotState;
            }
            State state = (State) objRememberedValue5;
            if (function4 != null && charSequence.length() == 0 && ((Boolean) state.getValue()).booleanValue()) {
                gapComposer2.startReplaceGroup(-939160356);
                ComposableLambdaImpl composableLambdaImplRememberComposableLambda3 = Thread_jvmKt.rememberComposableLambda(-720601610, new Function3() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Modifier modifier = (Modifier) obj;
                        GapComposer gapComposer6 = (GapComposer) obj2;
                        int iIntValue = ((Integer) obj3).intValue();
                        if ((iIntValue & 6) == 0) {
                            iIntValue |= gapComposer6.changed(modifier) ? 4 : 2;
                        }
                        if (gapComposer6.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18)) {
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                            long j4 = gapComposer6.compositeKeyHashCode;
                            int i10 = (int) (j4 ^ (j4 >>> 32));
                            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer6.currentCompositionLocalScope();
                            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer6, modifier);
                            ComposeUiNode.Companion.getClass();
                            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                            gapComposer6.startReusableNode();
                            if (gapComposer6.inserting) {
                                gapComposer6.createNode(layoutNode$Companion$Constructor$1);
                            } else {
                                gapComposer6.useNode();
                            }
                            Stack.m295setimpl(gapComposer6, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                            Stack.m295setimpl(gapComposer6, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                            Stack.m295setimpl(gapComposer6, Integer.valueOf(i10), ComposeUiNode.Companion.SetCompositeKeyHash);
                            Stack.m294reconcileimpl(gapComposer6, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                            Stack.m295setimpl(gapComposer6, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                            TextFieldImplKt.m283Decoration3JVO9M(j, textStyle2, function4, gapComposer6, 0);
                            gapComposer6.end(true);
                        } else {
                            gapComposer6.skipToGroupEnd();
                        }
                        return Unit.INSTANCE;
                    }
                }, gapComposer2);
                gapComposer2.end(false);
                composableLambdaImpl2 = composableLambdaImplRememberComposableLambda3;
            } else {
                gapComposer2.startReplaceGroup(-938848683);
                gapComposer2.end(false);
                composableLambdaImpl2 = null;
            }
            Object objRememberedValue6 = gapComposer2.rememberedValue();
            if (objRememberedValue6 == neverEqualPolicy2) {
                ModalBottomSheetKt$$ExternalSyntheticLambda10 modalBottomSheetKt$$ExternalSyntheticLambda11 = new ModalBottomSheetKt$$ExternalSyntheticLambda10(null, 4);
                MenuHostHelper menuHostHelper2 = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
                DerivedSnapshotState derivedSnapshotState2 = new DerivedSnapshotState(modalBottomSheetKt$$ExternalSyntheticLambda11, r21);
                gapComposer2.updateRememberedValue(derivedSnapshotState2);
                objRememberedValue6 = derivedSnapshotState2;
            }
            gapComposer2.startReplaceGroup(-938405259);
            gapComposer2.end(false);
            gapComposer2.startReplaceGroup(-938084843);
            gapComposer2.end(false);
            gapComposer2.startReplaceGroup(-937922124);
            gapComposer2.end(false);
            gapComposer2.startReplaceGroup(-937662189);
            gapComposer2.end(false);
            if (!z2) {
                j2 = textFieldColors2.disabledSupportingTextColor;
            } else if (z3) {
                j2 = textFieldColors2.errorSupportingTextColor;
            } else {
                j2 = zBooleanValue != 0 ? textFieldColors2.focusedSupportingTextColor : textFieldColors2.unfocusedSupportingTextColor;
            }
            if (function5 == null) {
                gapComposer2.startReplaceGroup(-937391714);
                gapComposer2.end(false);
                z5 = false;
                composableLambdaImplRememberComposableLambda2 = null;
                gapComposer3 = gapComposer2;
            } else {
                gapComposer2.startReplaceGroup(-937391713);
                z5 = false;
                gapComposer3 = gapComposer;
                composableLambdaImplRememberComposableLambda2 = Thread_jvmKt.rememberComposableLambda(-1612592437, new ButtonKt$$ExternalSyntheticLambda2(j2, textStyle, function5, 2), gapComposer3);
                gapComposer3.end(false);
            }
            boolean zChanged7 = gapComposer3.changed(transitionAnimationState);
            Object objRememberedValue7 = gapComposer3.rememberedValue();
            if (zChanged7 || objRememberedValue7 == neverEqualPolicy2) {
                objRememberedValue7 = new ModalBottomSheetKt$$ExternalSyntheticLambda10(transitionAnimationState, 5);
                gapComposer3.updateRememberedValue(objRememberedValue7);
            }
            Function0 function0 = (Function0) objRememberedValue7;
            boolean zChanged8 = gapComposer3.changed(transitionAnimationStateCreateTransitionAnimation);
            Object objRememberedValue8 = gapComposer3.rememberedValue();
            if (zChanged8 || objRememberedValue8 == neverEqualPolicy2) {
                objRememberedValue8 = new ModalBottomSheetKt$$ExternalSyntheticLambda10(transitionAnimationStateCreateTransitionAnimation, 6);
                gapComposer3.updateRememberedValue(objRememberedValue8);
            }
            Function0 function1 = (Function0) objRememberedValue8;
            boolean zChanged9 = gapComposer3.changed((Object) null);
            Object objRememberedValue9 = gapComposer3.rememberedValue();
            if (zChanged9 || objRememberedValue9 == neverEqualPolicy2) {
                objRememberedValue9 = new ModalBottomSheetKt$$ExternalSyntheticLambda10(null, 7);
                gapComposer3.updateRememberedValue(objRememberedValue9);
            }
            Function0 function6 = (Function0) objRememberedValue9;
            int iOrdinal5 = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(2);
            if (iOrdinal5 == 0) {
                gapComposer4 = gapComposer3;
                gapComposer4.startReplaceGroup(-936973554);
                ScrimKt.TextFieldLayout(function2, composableLambdaImplRememberComposableLambda, composableLambdaImpl2, null, null, null, null, z, textFieldLabelPosition$Attached, new TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0(function0), new TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0(function1), new TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0(function6), Thread_jvmKt.rememberComposableLambda(-358432442, new FlowLayoutKt$$ExternalSyntheticLambda0(composableLambdaImpl, i9), gapComposer4), composableLambdaImplRememberComposableLambda2, paddingValues, gapComposer4, ((i5 >> 3) & 112) | 6 | ((i8 << 21) & 234881024) | ((i5 << 18) & 1879048192), (i8 & 458752) | 3072);
                gapComposer4.end(false);
                Unit unit = Unit.INSTANCE;
            } else {
                if (iOrdinal5 != 1) {
                    GapComposer gapComposer6 = gapComposer3;
                    gapComposer6.startReplaceGroup(1493796415);
                    gapComposer6.end(z5);
                    throw new HttpException();
                }
                gapComposer3.startReplaceGroup(-935939642);
                Object objRememberedValue10 = gapComposer3.rememberedValue();
                if (objRememberedValue10 == neverEqualPolicy2) {
                    i6 = 1879048192;
                    objRememberedValue10 = Stack.mutableStateOf$default(new Size(0L));
                    gapComposer3.updateRememberedValue(objRememberedValue10);
                } else {
                    i6 = 1879048192;
                }
                MutableState mutableState = (MutableState) objRememberedValue10;
                ComposableLambdaImpl composableLambdaImplRememberComposableLambda4 = Thread_jvmKt.rememberComposableLambda(-403938615, new TextFieldImplKt$$ExternalSyntheticLambda10(mutableState, textFieldLabelPosition$Attached, paddingValues, composableLambdaImpl), gapComposer3);
                TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 = new TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0(function0);
                TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1 = new TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0(function1);
                ComposableLambdaImpl composableLambdaImpl3 = composableLambdaImplRememberComposableLambda;
                TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$2 = new TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0(function6);
                int i10 = i5;
                boolean zChanged10 = ((i10 & 7168) == 2048) | gapComposer3.changed(function0);
                Object objRememberedValue11 = gapComposer3.rememberedValue();
                if (zChanged10 || objRememberedValue11 == neverEqualPolicy2) {
                    objRememberedValue11 = new TvGlassTabRowKt$$ExternalSyntheticLambda6(textFieldLabelPosition$Attached, function0, mutableState);
                    gapComposer3.updateRememberedValue(objRememberedValue11);
                }
                OutlinedTextFieldKt.OutlinedTextFieldLayout(function2, composableLambdaImpl2, composableLambdaImpl3, null, null, null, null, z, textFieldLabelPosition$Attached, textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0, textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1, textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$2, (Function1) objRememberedValue11, composableLambdaImplRememberComposableLambda4, composableLambdaImplRememberComposableLambda2, paddingValues, gapComposer, ((i10 >> 3) & 112) | 6 | ((i8 << 21) & 234881024) | ((i10 << 18) & i6), (3670016 & (i8 << 3)) | 24576);
                gapComposer4 = gapComposer;
                gapComposer4.end(false);
                Unit unit2 = Unit.INSTANCE;
            }
        } else {
            gapComposer4.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer4.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                    TextFieldImplKt.CommonDecorationBox(charSequence, function2, textFieldLabelPosition$Attached, function3, function4, function5, z, z2, z3, mutableInteractionSourceImpl, paddingValues, textFieldColors, composableLambdaImpl, (GapComposer) obj, iUpdateChangedFlags, iUpdateChangedFlags2);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX WARN: Code duplicated, block: B:128:0x0206  */
    /* JADX WARN: Code duplicated, block: B:131:0x022b  */
    /* JADX WARN: Code duplicated, block: B:133:0x0233  */
    /* JADX WARN: Code duplicated, block: B:145:0x0259  */
    /* JADX WARN: Code duplicated, block: B:194:0x037d  */
    /* JADX WARN: Code duplicated, block: B:206:0x03ba  */
    /* JADX WARN: Code duplicated, block: B:209:0x03e5  */
    /* JADX WARN: Code duplicated, block: B:210:0x03f0  */
    /* JADX WARN: Code duplicated, block: B:218:0x041f A[PHI: r13
      0x041f: PHI (r13v14 androidx.compose.ui.text.style.TextForegroundStyle$Unspecified) = 
      (r13v13 androidx.compose.ui.text.style.TextForegroundStyle$Unspecified)
      (r13v13 androidx.compose.ui.text.style.TextForegroundStyle$Unspecified)
      (r13v19 androidx.compose.ui.text.style.TextForegroundStyle$Unspecified)
     binds: [B:225:0x0440, B:230:0x0451, B:216:0x0417] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:220:0x0423  */
    /* JADX WARN: Code duplicated, block: B:222:0x0426  */
    /* JADX WARN: Code duplicated, block: B:237:0x046b  */
    /* JADX WARN: Code duplicated, block: B:240:0x048b  */
    /* JADX WARN: Code duplicated, block: B:243:0x0491  */
    /* JADX WARN: Code duplicated, block: B:246:0x04d9  */
    /* JADX WARN: Code duplicated, block: B:247:0x04dc  */
    /* JADX WARN: Code duplicated, block: B:250:0x04e1  */
    /* JADX WARN: Code duplicated, block: B:251:0x04e4  */
    /* JADX WARN: Code duplicated, block: B:254:0x04ef  */
    /* JADX WARN: Code duplicated, block: B:258:0x04f5  */
    /* JADX WARN: Code duplicated, block: B:263:0x0538 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:264:0x053a  */
    /* JADX WARN: Code duplicated, block: B:265:0x0559  */
    /* JADX WARN: Code duplicated, block: B:267:0x055c  */
    /* JADX WARN: Code duplicated, block: B:269:0x057a  */
    /* JADX WARN: Code duplicated, block: B:274:0x058c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:275:0x058e  */
    /* JADX WARN: Code duplicated, block: B:279:0x05f0  */
    /* JADX WARN: Code duplicated, block: B:282:0x05f6  */
    /* JADX WARN: Code duplicated, block: B:287:0x061a  */
    /* JADX WARN: Code duplicated, block: B:289:0x061e  */
    /* JADX WARN: Code duplicated, block: B:292:0x0623  */
    /* JADX WARN: Code duplicated, block: B:295:0x0628  */
    /* JADX WARN: Code duplicated, block: B:296:0x062b  */
    /* JADX WARN: Code duplicated, block: B:299:0x06ae  */
    /* JADX WARN: Code duplicated, block: B:300:0x06d1  */
    public static final void DecoratedLabel(State state, TextFieldColors textFieldColors, boolean z, boolean z2, boolean z3, boolean z4, Transition transition, TextStyle textStyle, TextStyle textStyle2, Function3 function3, GapComposer gapComposer, int i) {
        long j;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState;
        NeverEqualPolicy neverEqualPolicy;
        boolean z5;
        int i2;
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation;
        boolean z6;
        Object objMo773getCurrentState;
        Transition.TransitionAnimationState transitionAnimationState;
        boolean z7;
        Object objRememberedValue;
        boolean z8;
        Object objRememberedValue2;
        Transition.TransitionAnimationState transitionAnimationState2;
        float fFloatValue;
        TextStyle textStyle3;
        TextForegroundStyle textForegroundStyle;
        TextForegroundStyle textForegroundStyle2;
        boolean z9;
        TextForegroundStyle.Unspecified unspecified;
        TextForegroundStyle.Unspecified unspecified2;
        TextForegroundStyle brushStyle;
        FontWeight fontWeight;
        FontWeight fontWeight2;
        BaselineShift baselineShift;
        float f;
        BaselineShift baselineShift2;
        float f2;
        TextGeometricTransform textGeometricTransform;
        TextGeometricTransform textGeometricTransform2;
        TextGeometricTransform textGeometricTransform3;
        TextGeometricTransform textGeometricTransform4;
        Shadow shadow;
        Shadow shadow2;
        Shadow shadowLerp;
        Shadow shadowLerp2;
        PlatformSpanStyle platformSpanStyle;
        PlatformSpanStyle platformSpanStyle2;
        TextIndent textIndent;
        TextIndent textIndent2;
        PlatformParagraphStyle platformParagraphStyle;
        PlatformParagraphStyle platformParagraphStyle2;
        PlatformParagraphStyle platformParagraphStyle3;
        boolean z10;
        boolean z11;
        PlatformParagraphStyle platformParagraphStyle4;
        TextStyle textStyleM647copyp1EtxEg$default;
        int i3;
        boolean z12;
        Object objMo773getCurrentState2;
        int i4;
        boolean z13;
        Object objRememberedValue3;
        InputPhase inputPhase;
        long j2;
        boolean z14;
        Object objRememberedValue4;
        Lifecycle lifecycle = transition.transitionState;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState2 = transition.targetState$delegate;
        CrossfadeKt$Crossfade$3$1 crossfadeKt$Crossfade$3$1 = CrossfadeKt$Crossfade$3$1.INSTANCE$3;
        gapComposer.startRestartGroup(376119213);
        int i5 = i | (gapComposer.changed(state) ? 4 : 2) | (gapComposer.changed(textFieldColors) ? 32 : 16) | (gapComposer.changed(z) ? 256 : 128) | (gapComposer.changed(z2) ? 2048 : 1024) | (gapComposer.changed(z3) ? 16384 : 8192) | (gapComposer.changed(z4) ? 131072 : 65536) | (gapComposer.changed(transition) ? 1048576 : 524288) | (gapComposer.changed(textStyle) ? 8388608 : 4194304) | (gapComposer.changed(textStyle2) ? 67108864 : 33554432) | (gapComposer.changedInstance(function3) ? 536870912 : 268435456);
        if (gapComposer.shouldExecute(i5 & 1, (i5 & 306783379) != 306783378)) {
            Object objRememberedValue5 = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy2 = Composer$Companion.Empty;
            if (objRememberedValue5 == neverEqualPolicy2) {
                objRememberedValue5 = new TextFieldImplKt$DecoratedLabel$labelScope$1$1();
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            TextFieldImplKt$DecoratedLabel$labelScope$1$1 textFieldImplKt$DecoratedLabel$labelScope$1$1 = (TextFieldImplKt$DecoratedLabel$labelScope$1$1) objRememberedValue5;
            if (!z) {
                j = textFieldColors.disabledLabelColor;
            } else if (z2) {
                j = textFieldColors.errorLabelColor;
            } else {
                j = z3 ? textFieldColors.focusedLabelColor : textFieldColors.unfocusedLabelColor;
            }
            if (z4) {
                i2 = 14;
                gapComposer.startReplaceGroup(-601510006);
                long jM649getColor0d7_KjU = textStyle.m649getColor0d7_KjU();
                if (z4 && jM649getColor0d7_KjU == 16) {
                    jM649getColor0d7_KjU = j;
                }
                long jM649getColor0d7_KjU2 = textStyle2.m649getColor0d7_KjU();
                if (z4 && jM649getColor0d7_KjU2 == 16) {
                    jM649getColor0d7_KjU2 = j;
                }
                FiniteAnimationSpec finiteAnimationSpecValue = ScrimKt.value(5, gapComposer);
                int i6 = ((i5 >> 18) & 14) | 384;
                InputPhase inputPhase2 = (InputPhase) parcelableSnapshotMutableState2.getValue();
                gapComposer.startReplaceGroup(-759924327);
                int[] iArr = WhenMappings.$EnumSwitchMapping$1;
                long j3 = iArr[inputPhase2.ordinal()] == 1 ? jM649getColor0d7_KjU : jM649getColor0d7_KjU2;
                gapComposer.end(false);
                ColorSpace colorSpaceM438getColorSpaceimpl = Color.m438getColorSpaceimpl(j3);
                boolean zChanged = gapComposer.changed(colorSpaceM438getColorSpaceimpl);
                Object objRememberedValue6 = gapComposer.rememberedValue();
                if (zChanged || objRememberedValue6 == neverEqualPolicy2) {
                    TwoWayConverterImpl twoWayConverterImpl = new TwoWayConverterImpl(crossfadeKt$Crossfade$3$1, new Navigator.AnonymousClass1(3, colorSpaceM438getColorSpaceimpl));
                    gapComposer.updateRememberedValue(twoWayConverterImpl);
                    objRememberedValue6 = twoWayConverterImpl;
                }
                TwoWayConverterImpl twoWayConverterImpl2 = (TwoWayConverterImpl) objRememberedValue6;
                int i7 = (i6 & 14) | 3072;
                if (transition.isSeeking()) {
                    i3 = i7;
                    twoWayConverterImpl2 = twoWayConverterImpl2;
                    z12 = false;
                    gapComposer.startReplaceGroup(1666827533);
                    gapComposer.end(false);
                    objMo773getCurrentState2 = lifecycle.mo773getCurrentState();
                } else {
                    gapComposer.startReplaceGroup(1666573488);
                    i3 = i7;
                    boolean z15 = (((i7 & 14) ^ 6) > 4 && gapComposer.changed(transition)) || (i3 & 6) == 4;
                    objMo773getCurrentState2 = gapComposer.rememberedValue();
                    if (z15 || objMo773getCurrentState2 == neverEqualPolicy2) {
                        Snapshot currentThreadSnapshot = SnapshotId_jvmKt.getCurrentThreadSnapshot();
                        Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                        Snapshot snapshotMakeCurrentNonObservable = SnapshotId_jvmKt.makeCurrentNonObservable(currentThreadSnapshot);
                        try {
                            Object objMo773getCurrentState3 = lifecycle.mo773getCurrentState();
                            SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                            gapComposer.updateRememberedValue(objMo773getCurrentState3);
                            objMo773getCurrentState2 = objMo773getCurrentState3;
                        } catch (Throwable th) {
                            SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                            throw th;
                        }
                    }
                    z12 = false;
                    gapComposer.end(false);
                }
                gapComposer.startReplaceGroup(-759924327);
                long j4 = iArr[((InputPhase) objMo773getCurrentState2).ordinal()] == 1 ? jM649getColor0d7_KjU : jM649getColor0d7_KjU2;
                gapComposer.end(z12);
                Color color = new Color(j4);
                int i8 = i3 & 14;
                int i9 = i8 ^ 6;
                if (i9 <= 4 || !gapComposer.changed(transition)) {
                    i4 = i8;
                    if ((i3 & 6) != 4) {
                        z13 = false;
                    }
                    objRememberedValue3 = gapComposer.rememberedValue();
                    if (z13 || objRememberedValue3 == neverEqualPolicy2) {
                        objRememberedValue3 = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transition, 18));
                        gapComposer.updateRememberedValue(objRememberedValue3);
                    }
                    inputPhase = (InputPhase) ((State) objRememberedValue3).getValue();
                    gapComposer.startReplaceGroup(-759924327);
                    if (iArr[inputPhase.ordinal()] == 1) {
                        j2 = jM649getColor0d7_KjU;
                    } else {
                        j2 = jM649getColor0d7_KjU2;
                    }
                    gapComposer.end(false);
                    Color color2 = new Color(j2);
                    z14 = (i9 <= 4 && gapComposer.changed(transition)) || (i3 & 6) == 4;
                    objRememberedValue4 = gapComposer.rememberedValue();
                    if (z14 || objRememberedValue4 == neverEqualPolicy2) {
                        objRememberedValue4 = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transition, 19));
                        gapComposer.updateRememberedValue(objRememberedValue4);
                    }
                    gapComposer.startReplaceGroup(1730286052);
                    z5 = false;
                    gapComposer.end(false);
                    neverEqualPolicy = neverEqualPolicy2;
                    parcelableSnapshotMutableState = parcelableSnapshotMutableState2;
                    transitionAnimationStateCreateTransitionAnimation = ArcSplineKt.createTransitionAnimation(transition, color, color2, finiteAnimationSpecValue, twoWayConverterImpl2, gapComposer, i4 | 196608);
                    gapComposer.end(false);
                } else {
                    i4 = i8;
                }
                z13 = true;
                objRememberedValue3 = gapComposer.rememberedValue();
                if (z13) {
                    objRememberedValue3 = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transition, 18));
                    gapComposer.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transition, 18));
                    gapComposer.updateRememberedValue(objRememberedValue3);
                }
                inputPhase = (InputPhase) ((State) objRememberedValue3).getValue();
                gapComposer.startReplaceGroup(-759924327);
                if (iArr[inputPhase.ordinal()] == 1) {
                    j2 = jM649getColor0d7_KjU;
                } else {
                    j2 = jM649getColor0d7_KjU2;
                }
                gapComposer.end(false);
                Color color3 = new Color(j2);
                if (i9 <= 4) {
                }
                objRememberedValue4 = gapComposer.rememberedValue();
                if (z14) {
                    objRememberedValue4 = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transition, 19));
                    gapComposer.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transition, 19));
                    gapComposer.updateRememberedValue(objRememberedValue4);
                }
                gapComposer.startReplaceGroup(1730286052);
                z5 = false;
                gapComposer.end(false);
                neverEqualPolicy = neverEqualPolicy2;
                parcelableSnapshotMutableState = parcelableSnapshotMutableState2;
                transitionAnimationStateCreateTransitionAnimation = ArcSplineKt.createTransitionAnimation(transition, color, color3, finiteAnimationSpecValue, twoWayConverterImpl2, gapComposer, i4 | 196608);
                gapComposer.end(false);
            } else {
                parcelableSnapshotMutableState = parcelableSnapshotMutableState2;
                neverEqualPolicy = neverEqualPolicy2;
                z5 = false;
                i2 = 14;
                gapComposer.startReplaceGroup(-601031335);
                gapComposer.end(false);
                transitionAnimationStateCreateTransitionAnimation = null;
            }
            FiniteAnimationSpec finiteAnimationSpecValue2 = ScrimKt.value(5, gapComposer);
            int i10 = ((i5 >> 18) & 14) | 384;
            gapComposer.startReplaceGroup(1139343725);
            gapComposer.end(z5);
            ColorSpace colorSpaceM438getColorSpaceimpl2 = Color.m438getColorSpaceimpl(j);
            boolean zChanged2 = gapComposer.changed(colorSpaceM438getColorSpaceimpl2);
            Object objRememberedValue7 = gapComposer.rememberedValue();
            if (zChanged2 || objRememberedValue7 == neverEqualPolicy) {
                TwoWayConverterImpl twoWayConverterImpl3 = new TwoWayConverterImpl(crossfadeKt$Crossfade$3$1, new Navigator.AnonymousClass1(3, colorSpaceM438getColorSpaceimpl2));
                gapComposer.updateRememberedValue(twoWayConverterImpl3);
                objRememberedValue7 = twoWayConverterImpl3;
            }
            TwoWayConverterImpl twoWayConverterImpl4 = (TwoWayConverterImpl) objRememberedValue7;
            int i11 = (i10 & 14) | 3072;
            if (transition.isSeeking()) {
                i11 = i11;
                z6 = false;
                gapComposer.startReplaceGroup(1666827533);
                gapComposer.end(false);
                objMo773getCurrentState = lifecycle.mo773getCurrentState();
            } else {
                gapComposer.startReplaceGroup(1666573488);
                boolean z16 = (((i11 & 14) ^ 6) > 4 && gapComposer.changed(transition)) || (i11 & 6) == 4;
                objMo773getCurrentState = gapComposer.rememberedValue();
                if (z16 || objMo773getCurrentState == neverEqualPolicy) {
                    Snapshot currentThreadSnapshot2 = SnapshotId_jvmKt.getCurrentThreadSnapshot();
                    Function1 readObserver2 = currentThreadSnapshot2 != null ? currentThreadSnapshot2.getReadObserver() : null;
                    Snapshot snapshotMakeCurrentNonObservable2 = SnapshotId_jvmKt.makeCurrentNonObservable(currentThreadSnapshot2);
                    try {
                        Object objMo773getCurrentState4 = lifecycle.mo773getCurrentState();
                        SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                        gapComposer.updateRememberedValue(objMo773getCurrentState4);
                        objMo773getCurrentState = objMo773getCurrentState4;
                    } catch (Throwable th2) {
                        SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                        throw th2;
                    }
                }
                z6 = false;
                gapComposer.end(false);
            }
            gapComposer.startReplaceGroup(1139343725);
            gapComposer.end(z6);
            Transition.TransitionAnimationState transitionAnimationState3 = transitionAnimationStateCreateTransitionAnimation;
            Color color4 = new Color(j);
            int i12 = i11 & 14;
            int i13 = i12 ^ 6;
            if (i13 <= 4 || !gapComposer.changed(transition)) {
                transitionAnimationState = transitionAnimationState3;
                if ((i11 & 6) != 4) {
                    z7 = false;
                }
                objRememberedValue = gapComposer.rememberedValue();
                if (z7 || objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transition, i2));
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                gapComposer.startReplaceGroup(1139343725);
                gapComposer.end(false);
                Color color5 = new Color(j);
                z8 = (i13 <= 4 && gapComposer.changed(transition)) || (i11 & 6) == 4;
                objRememberedValue2 = gapComposer.rememberedValue();
                if (z8 || objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transition, 15));
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                gapComposer.startReplaceGroup(-1207102280);
                gapComposer.end(false);
                transitionAnimationState2 = transitionAnimationState;
                Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation2 = ArcSplineKt.createTransitionAnimation(transition, color4, color5, finiteAnimationSpecValue2, twoWayConverterImpl4, gapComposer, i12 | 196608);
                if (state != null) {
                    fFloatValue = ((Number) state.getValue()).floatValue();
                } else {
                    fFloatValue = 1.0f;
                }
                SpanStyle spanStyle = textStyle2.spanStyle;
                SpanStyle spanStyle2 = textStyle.spanStyle;
                TextForegroundStyle textForegroundStyle3 = SpanStyleKt.DefaultColorForegroundStyle;
                textForegroundStyle = spanStyle.textForegroundStyle;
                textForegroundStyle2 = spanStyle2.textForegroundStyle;
                z9 = textForegroundStyle instanceof BrushStyle;
                unspecified = TextForegroundStyle.Unspecified.INSTANCE;
                if (!z9 || (textForegroundStyle2 instanceof BrushStyle)) {
                    unspecified2 = unspecified;
                    if (z9 || !(textForegroundStyle2 instanceof BrushStyle)) {
                        brushStyle = (TextForegroundStyle) SpanStyleKt.lerpDiscrete(fFloatValue, textForegroundStyle, textForegroundStyle2);
                    } else {
                        BrushStyle brushStyle2 = (BrushStyle) textForegroundStyle;
                        BrushStyle brushStyle3 = (BrushStyle) textForegroundStyle2;
                        Brush brush = (Brush) SpanStyleKt.lerpDiscrete(fFloatValue, brushStyle2.value, brushStyle3.value);
                        float fLerp = MathHelpersKt.lerp(brushStyle2.alpha, brushStyle3.alpha, fFloatValue);
                        if (brush == null) {
                            brushStyle = unspecified2;
                        } else if (brush instanceof SolidColor) {
                            long jM675modulateDxMtmZc = TextDrawStyleKt.m675modulateDxMtmZc(fLerp, ((SolidColor) brush).value);
                            if (jM675modulateDxMtmZc != 16) {
                                brushStyle = new ColorStyle(jM675modulateDxMtmZc);
                            } else {
                                brushStyle = unspecified2;
                            }
                        } else {
                            if (!(brush instanceof ShaderBrush)) {
                                throw new HttpException();
                            }
                            brushStyle = new BrushStyle((ShaderBrush) brush, fLerp);
                        }
                    }
                } else {
                    unspecified2 = unspecified;
                    long jM419lerpjxsXWHM = BrushKt.m419lerpjxsXWHM(textForegroundStyle.mo668getColor0d7_KjU(), textForegroundStyle2.mo668getColor0d7_KjU(), fFloatValue);
                    if (jM419lerpjxsXWHM != 16) {
                        brushStyle = new ColorStyle(jM419lerpjxsXWHM);
                    } else {
                        brushStyle = unspecified2;
                    }
                }
                TextForegroundStyle textForegroundStyle4 = brushStyle;
                SystemFontFamily systemFontFamily = (SystemFontFamily) SpanStyleKt.lerpDiscrete(fFloatValue, spanStyle.fontFamily, spanStyle2.fontFamily);
                long jM637lerpTextUnitInheritableC3pnCVY = SpanStyleKt.m637lerpTextUnitInheritableC3pnCVY(spanStyle.fontSize, spanStyle2.fontSize, fFloatValue);
                fontWeight = spanStyle.fontWeight;
                if (fontWeight == null) {
                    fontWeight = FontWeight.Normal;
                }
                fontWeight2 = spanStyle2.fontWeight;
                if (fontWeight2 == null) {
                    fontWeight2 = FontWeight.Normal;
                }
                FontWeight fontWeight3 = new FontWeight(RangesKt.coerceIn(MathHelpersKt.lerp(fFloatValue, fontWeight.weight, fontWeight2.weight), 1, 1000));
                FontStyle fontStyle = (FontStyle) SpanStyleKt.lerpDiscrete(fFloatValue, spanStyle.fontStyle, spanStyle2.fontStyle);
                FontSynthesis fontSynthesis = (FontSynthesis) SpanStyleKt.lerpDiscrete(fFloatValue, spanStyle.fontSynthesis, spanStyle2.fontSynthesis);
                String str = (String) SpanStyleKt.lerpDiscrete(fFloatValue, spanStyle.fontFeatureSettings, spanStyle2.fontFeatureSettings);
                long jM637lerpTextUnitInheritableC3pnCVY2 = SpanStyleKt.m637lerpTextUnitInheritableC3pnCVY(spanStyle.letterSpacing, spanStyle2.letterSpacing, fFloatValue);
                baselineShift = spanStyle.baselineShift;
                if (baselineShift != null) {
                    f = baselineShift.multiplier;
                } else {
                    f = 0.0f;
                }
                baselineShift2 = spanStyle2.baselineShift;
                if (baselineShift2 != null) {
                    f2 = baselineShift2.multiplier;
                } else {
                    f2 = 0.0f;
                }
                float fLerp2 = MathHelpersKt.lerp(f, f2, fFloatValue);
                textGeometricTransform = spanStyle.textGeometricTransform;
                textGeometricTransform2 = TextGeometricTransform.None;
                if (textGeometricTransform == null) {
                    textGeometricTransform = textGeometricTransform2;
                }
                textGeometricTransform3 = spanStyle2.textGeometricTransform;
                if (textGeometricTransform3 != null) {
                    textGeometricTransform2 = textGeometricTransform3;
                }
                textGeometricTransform4 = new TextGeometricTransform(MathHelpersKt.lerp(textGeometricTransform.scaleX, textGeometricTransform2.scaleX, fFloatValue), MathHelpersKt.lerp(textGeometricTransform.skewX, textGeometricTransform2.skewX, fFloatValue));
                LocaleList localeList = (LocaleList) SpanStyleKt.lerpDiscrete(fFloatValue, spanStyle.localeList, spanStyle2.localeList);
                long jM419lerpjxsXWHM2 = BrushKt.m419lerpjxsXWHM(spanStyle.background, spanStyle2.background, fFloatValue);
                TextDecoration textDecoration = (TextDecoration) SpanStyleKt.lerpDiscrete(fFloatValue, spanStyle.textDecoration, spanStyle2.textDecoration);
                shadow = spanStyle.shadow;
                shadow2 = spanStyle2.shadow;
                if (shadow != null && shadow2 == null) {
                    textGeometricTransform4 = textGeometricTransform4;
                    shadowLerp2 = null;
                } else if (shadow == null) {
                    long j5 = shadow2.color;
                    shadowLerp2 = BrushKt.lerp(new Shadow(BrushKt.Color(Color.m440getRedimpl(j5), Color.m439getGreenimpl(j5), Color.m437getBlueimpl(j5), 0.0f, Color.m438getColorSpaceimpl(j5)), shadow2.offset, shadow2.blurRadius), shadow2, fFloatValue);
                    textGeometricTransform4 = textGeometricTransform4;
                } else {
                    if (shadow2 == null) {
                        long j6 = shadow.color;
                        shadowLerp = BrushKt.lerp(shadow, new Shadow(BrushKt.Color(Color.m440getRedimpl(j6), Color.m439getGreenimpl(j6), Color.m437getBlueimpl(j6), 0.0f, Color.m438getColorSpaceimpl(j6)), shadow.offset, shadow.blurRadius), fFloatValue);
                    } else {
                        shadowLerp = BrushKt.lerp(shadow, shadow2, fFloatValue);
                    }
                    shadowLerp2 = shadowLerp;
                }
                platformSpanStyle = spanStyle.platformStyle;
                PlatformSpanStyle platformSpanStyle3 = spanStyle2.platformStyle;
                if (platformSpanStyle == null || platformSpanStyle3 != null) {
                    if (platformSpanStyle == null) {
                        platformSpanStyle = PlatformSpanStyle.Default;
                    }
                    platformSpanStyle2 = platformSpanStyle;
                } else {
                    platformSpanStyle2 = null;
                }
                SpanStyle spanStyle3 = new SpanStyle(textForegroundStyle4, jM637lerpTextUnitInheritableC3pnCVY, fontWeight3, fontStyle, fontSynthesis, systemFontFamily, str, jM637lerpTextUnitInheritableC3pnCVY2, new BaselineShift(fLerp2), textGeometricTransform4, localeList, jM419lerpjxsXWHM2, textDecoration, shadowLerp2, platformSpanStyle2, (DrawStyle) SpanStyleKt.lerpDiscrete(fFloatValue, spanStyle.drawStyle, spanStyle2.drawStyle));
                ParagraphStyle paragraphStyle = textStyle2.paragraphStyle;
                ParagraphStyle paragraphStyle2 = textStyle.paragraphStyle;
                int i14 = ParagraphStyleKt.$r8$clinit;
                int i15 = ((TextAlign) SpanStyleKt.lerpDiscrete(fFloatValue, new TextAlign(paragraphStyle.textAlign), new TextAlign(paragraphStyle2.textAlign))).value;
                int i16 = ((TextDirection) SpanStyleKt.lerpDiscrete(fFloatValue, new TextDirection(paragraphStyle.textDirection), new TextDirection(paragraphStyle2.textDirection))).value;
                long jM637lerpTextUnitInheritableC3pnCVY3 = SpanStyleKt.m637lerpTextUnitInheritableC3pnCVY(paragraphStyle.lineHeight, paragraphStyle2.lineHeight, fFloatValue);
                textIndent = paragraphStyle.textIndent;
                if (textIndent == null) {
                    textIndent = TextIndent.None;
                }
                textIndent2 = paragraphStyle2.textIndent;
                if (textIndent2 == null) {
                    textIndent2 = TextIndent.None;
                }
                TextIndent textIndent3 = new TextIndent(SpanStyleKt.m637lerpTextUnitInheritableC3pnCVY(textIndent.firstLine, textIndent2.firstLine, fFloatValue), SpanStyleKt.m637lerpTextUnitInheritableC3pnCVY(textIndent.restLine, textIndent2.restLine, fFloatValue));
                platformParagraphStyle = paragraphStyle.platformStyle;
                platformParagraphStyle2 = paragraphStyle2.platformStyle;
                if (platformParagraphStyle == null || platformParagraphStyle2 != null) {
                    platformParagraphStyle3 = PlatformParagraphStyle.Default;
                    if (platformParagraphStyle == null) {
                        platformParagraphStyle = platformParagraphStyle3;
                    }
                    z10 = platformParagraphStyle.includeFontPadding;
                    if (platformParagraphStyle2 == null) {
                        platformParagraphStyle2 = platformParagraphStyle3;
                    }
                    z11 = platformParagraphStyle2.includeFontPadding;
                    if (z10 == z11) {
                        platformParagraphStyle4 = platformParagraphStyle;
                    } else {
                        platformParagraphStyle4 = new PlatformParagraphStyle(((EmojiSupportMatch) SpanStyleKt.lerpDiscrete(fFloatValue, new EmojiSupportMatch(platformParagraphStyle.emojiSupportMatch), new EmojiSupportMatch(platformParagraphStyle2.emojiSupportMatch))).value, ((Boolean) SpanStyleKt.lerpDiscrete(fFloatValue, Boolean.valueOf(z10), Boolean.valueOf(z11))).booleanValue());
                    }
                } else {
                    platformParagraphStyle4 = null;
                }
                textStyle3 = new TextStyle(spanStyle3, new ParagraphStyle(i15, i16, jM637lerpTextUnitInheritableC3pnCVY3, textIndent3, platformParagraphStyle4, (LineHeightStyle) SpanStyleKt.lerpDiscrete(fFloatValue, paragraphStyle.lineHeightStyle, paragraphStyle2.lineHeightStyle), ((LineBreak) SpanStyleKt.lerpDiscrete(fFloatValue, new LineBreak(paragraphStyle.lineBreak), new LineBreak(paragraphStyle2.lineBreak))).mask, ((Hyphens) SpanStyleKt.lerpDiscrete(fFloatValue, new Hyphens(paragraphStyle.hyphens), new Hyphens(paragraphStyle2.hyphens))).value, (TextMotion) SpanStyleKt.lerpDiscrete(fFloatValue, paragraphStyle.textMotion, paragraphStyle2.textMotion)));
                if (z4) {
                    textStyleM647copyp1EtxEg$default = TextStyle.m647copyp1EtxEg$default(textStyle3, ((Color) transitionAnimationState2.value$delegate.getValue()).value, 0L, null, null, 0L, 0L, null, 16777214);
                } else {
                    textStyleM647copyp1EtxEg$default = textStyle3;
                }
                m283Decoration3JVO9M(((Color) transitionAnimationStateCreateTransitionAnimation2.value$delegate.getValue()).value, textStyleM647copyp1EtxEg$default, Thread_jvmKt.rememberComposableLambda(57043598, new TextKt$$ExternalSyntheticLambda2(19, function3, textFieldImplKt$DecoratedLabel$labelScope$1$1), gapComposer), gapComposer, 384);
            } else {
                transitionAnimationState = transitionAnimationState3;
            }
            z7 = true;
            objRememberedValue = gapComposer.rememberedValue();
            if (z7) {
                objRememberedValue = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transition, i2));
                gapComposer.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transition, i2));
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            gapComposer.startReplaceGroup(1139343725);
            gapComposer.end(false);
            Color color6 = new Color(j);
            if (i13 <= 4) {
            }
            objRememberedValue2 = gapComposer.rememberedValue();
            if (z8) {
                objRememberedValue2 = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transition, 15));
                gapComposer.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transition, 15));
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            gapComposer.startReplaceGroup(-1207102280);
            gapComposer.end(false);
            transitionAnimationState2 = transitionAnimationState;
            Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation3 = ArcSplineKt.createTransitionAnimation(transition, color4, color6, finiteAnimationSpecValue2, twoWayConverterImpl4, gapComposer, i12 | 196608);
            if (state != null) {
                fFloatValue = ((Number) state.getValue()).floatValue();
            } else {
                fFloatValue = 1.0f;
            }
            SpanStyle spanStyle4 = textStyle2.spanStyle;
            SpanStyle spanStyle5 = textStyle.spanStyle;
            TextForegroundStyle textForegroundStyle5 = SpanStyleKt.DefaultColorForegroundStyle;
            textForegroundStyle = spanStyle4.textForegroundStyle;
            textForegroundStyle2 = spanStyle5.textForegroundStyle;
            z9 = textForegroundStyle instanceof BrushStyle;
            unspecified = TextForegroundStyle.Unspecified.INSTANCE;
            if (z9) {
                unspecified2 = unspecified;
                if (z9) {
                    brushStyle = (TextForegroundStyle) SpanStyleKt.lerpDiscrete(fFloatValue, textForegroundStyle, textForegroundStyle2);
                } else {
                    brushStyle = (TextForegroundStyle) SpanStyleKt.lerpDiscrete(fFloatValue, textForegroundStyle, textForegroundStyle2);
                }
            } else {
                unspecified2 = unspecified;
                if (z9) {
                    brushStyle = (TextForegroundStyle) SpanStyleKt.lerpDiscrete(fFloatValue, textForegroundStyle, textForegroundStyle2);
                } else {
                    brushStyle = (TextForegroundStyle) SpanStyleKt.lerpDiscrete(fFloatValue, textForegroundStyle, textForegroundStyle2);
                }
            }
            TextForegroundStyle textForegroundStyle6 = brushStyle;
            SystemFontFamily systemFontFamily2 = (SystemFontFamily) SpanStyleKt.lerpDiscrete(fFloatValue, spanStyle4.fontFamily, spanStyle5.fontFamily);
            long jM637lerpTextUnitInheritableC3pnCVY4 = SpanStyleKt.m637lerpTextUnitInheritableC3pnCVY(spanStyle4.fontSize, spanStyle5.fontSize, fFloatValue);
            fontWeight = spanStyle4.fontWeight;
            if (fontWeight == null) {
                fontWeight = FontWeight.Normal;
            }
            fontWeight2 = spanStyle5.fontWeight;
            if (fontWeight2 == null) {
                fontWeight2 = FontWeight.Normal;
            }
            FontWeight fontWeight4 = new FontWeight(RangesKt.coerceIn(MathHelpersKt.lerp(fFloatValue, fontWeight.weight, fontWeight2.weight), 1, 1000));
            FontStyle fontStyle2 = (FontStyle) SpanStyleKt.lerpDiscrete(fFloatValue, spanStyle4.fontStyle, spanStyle5.fontStyle);
            FontSynthesis fontSynthesis2 = (FontSynthesis) SpanStyleKt.lerpDiscrete(fFloatValue, spanStyle4.fontSynthesis, spanStyle5.fontSynthesis);
            String str2 = (String) SpanStyleKt.lerpDiscrete(fFloatValue, spanStyle4.fontFeatureSettings, spanStyle5.fontFeatureSettings);
            long jM637lerpTextUnitInheritableC3pnCVY5 = SpanStyleKt.m637lerpTextUnitInheritableC3pnCVY(spanStyle4.letterSpacing, spanStyle5.letterSpacing, fFloatValue);
            baselineShift = spanStyle4.baselineShift;
            if (baselineShift != null) {
                f = baselineShift.multiplier;
            } else {
                f = 0.0f;
            }
            baselineShift2 = spanStyle5.baselineShift;
            if (baselineShift2 != null) {
                f2 = baselineShift2.multiplier;
            } else {
                f2 = 0.0f;
            }
            float fLerp3 = MathHelpersKt.lerp(f, f2, fFloatValue);
            textGeometricTransform = spanStyle4.textGeometricTransform;
            textGeometricTransform2 = TextGeometricTransform.None;
            if (textGeometricTransform == null) {
                textGeometricTransform = textGeometricTransform2;
            }
            textGeometricTransform3 = spanStyle5.textGeometricTransform;
            if (textGeometricTransform3 != null) {
                textGeometricTransform2 = textGeometricTransform3;
            }
            textGeometricTransform4 = new TextGeometricTransform(MathHelpersKt.lerp(textGeometricTransform.scaleX, textGeometricTransform2.scaleX, fFloatValue), MathHelpersKt.lerp(textGeometricTransform.skewX, textGeometricTransform2.skewX, fFloatValue));
            LocaleList localeList2 = (LocaleList) SpanStyleKt.lerpDiscrete(fFloatValue, spanStyle4.localeList, spanStyle5.localeList);
            long jM419lerpjxsXWHM3 = BrushKt.m419lerpjxsXWHM(spanStyle4.background, spanStyle5.background, fFloatValue);
            TextDecoration textDecoration2 = (TextDecoration) SpanStyleKt.lerpDiscrete(fFloatValue, spanStyle4.textDecoration, spanStyle5.textDecoration);
            shadow = spanStyle4.shadow;
            shadow2 = spanStyle5.shadow;
            if (shadow != null) {
                if (shadow == null) {
                    long j7 = shadow2.color;
                    shadowLerp2 = BrushKt.lerp(new Shadow(BrushKt.Color(Color.m440getRedimpl(j7), Color.m439getGreenimpl(j7), Color.m437getBlueimpl(j7), 0.0f, Color.m438getColorSpaceimpl(j7)), shadow2.offset, shadow2.blurRadius), shadow2, fFloatValue);
                    textGeometricTransform4 = textGeometricTransform4;
                } else {
                    if (shadow2 == null) {
                        long j8 = shadow.color;
                        shadowLerp = BrushKt.lerp(shadow, new Shadow(BrushKt.Color(Color.m440getRedimpl(j8), Color.m439getGreenimpl(j8), Color.m437getBlueimpl(j8), 0.0f, Color.m438getColorSpaceimpl(j8)), shadow.offset, shadow.blurRadius), fFloatValue);
                    } else {
                        shadowLerp = BrushKt.lerp(shadow, shadow2, fFloatValue);
                    }
                    shadowLerp2 = shadowLerp;
                }
            } else if (shadow == null) {
                long j9 = shadow2.color;
                shadowLerp2 = BrushKt.lerp(new Shadow(BrushKt.Color(Color.m440getRedimpl(j9), Color.m439getGreenimpl(j9), Color.m437getBlueimpl(j9), 0.0f, Color.m438getColorSpaceimpl(j9)), shadow2.offset, shadow2.blurRadius), shadow2, fFloatValue);
                textGeometricTransform4 = textGeometricTransform4;
            } else {
                if (shadow2 == null) {
                    long j10 = shadow.color;
                    shadowLerp = BrushKt.lerp(shadow, new Shadow(BrushKt.Color(Color.m440getRedimpl(j10), Color.m439getGreenimpl(j10), Color.m437getBlueimpl(j10), 0.0f, Color.m438getColorSpaceimpl(j10)), shadow.offset, shadow.blurRadius), fFloatValue);
                } else {
                    shadowLerp = BrushKt.lerp(shadow, shadow2, fFloatValue);
                }
                shadowLerp2 = shadowLerp;
            }
            platformSpanStyle = spanStyle4.platformStyle;
            PlatformSpanStyle platformSpanStyle4 = spanStyle5.platformStyle;
            if (platformSpanStyle == null) {
                if (platformSpanStyle == null) {
                    platformSpanStyle = PlatformSpanStyle.Default;
                }
                platformSpanStyle2 = platformSpanStyle;
            } else {
                if (platformSpanStyle == null) {
                    platformSpanStyle = PlatformSpanStyle.Default;
                }
                platformSpanStyle2 = platformSpanStyle;
            }
            SpanStyle spanStyle6 = new SpanStyle(textForegroundStyle6, jM637lerpTextUnitInheritableC3pnCVY4, fontWeight4, fontStyle2, fontSynthesis2, systemFontFamily2, str2, jM637lerpTextUnitInheritableC3pnCVY5, new BaselineShift(fLerp3), textGeometricTransform4, localeList2, jM419lerpjxsXWHM3, textDecoration2, shadowLerp2, platformSpanStyle2, (DrawStyle) SpanStyleKt.lerpDiscrete(fFloatValue, spanStyle4.drawStyle, spanStyle5.drawStyle));
            ParagraphStyle paragraphStyle3 = textStyle2.paragraphStyle;
            ParagraphStyle paragraphStyle4 = textStyle.paragraphStyle;
            int i17 = ParagraphStyleKt.$r8$clinit;
            int i18 = ((TextAlign) SpanStyleKt.lerpDiscrete(fFloatValue, new TextAlign(paragraphStyle3.textAlign), new TextAlign(paragraphStyle4.textAlign))).value;
            int i19 = ((TextDirection) SpanStyleKt.lerpDiscrete(fFloatValue, new TextDirection(paragraphStyle3.textDirection), new TextDirection(paragraphStyle4.textDirection))).value;
            long jM637lerpTextUnitInheritableC3pnCVY6 = SpanStyleKt.m637lerpTextUnitInheritableC3pnCVY(paragraphStyle3.lineHeight, paragraphStyle4.lineHeight, fFloatValue);
            textIndent = paragraphStyle3.textIndent;
            if (textIndent == null) {
                textIndent = TextIndent.None;
            }
            textIndent2 = paragraphStyle4.textIndent;
            if (textIndent2 == null) {
                textIndent2 = TextIndent.None;
            }
            TextIndent textIndent4 = new TextIndent(SpanStyleKt.m637lerpTextUnitInheritableC3pnCVY(textIndent.firstLine, textIndent2.firstLine, fFloatValue), SpanStyleKt.m637lerpTextUnitInheritableC3pnCVY(textIndent.restLine, textIndent2.restLine, fFloatValue));
            platformParagraphStyle = paragraphStyle3.platformStyle;
            platformParagraphStyle2 = paragraphStyle4.platformStyle;
            if (platformParagraphStyle == null) {
                platformParagraphStyle3 = PlatformParagraphStyle.Default;
                if (platformParagraphStyle == null) {
                    platformParagraphStyle = platformParagraphStyle3;
                }
                z10 = platformParagraphStyle.includeFontPadding;
                if (platformParagraphStyle2 == null) {
                    platformParagraphStyle2 = platformParagraphStyle3;
                }
                z11 = platformParagraphStyle2.includeFontPadding;
                if (z10 == z11) {
                    platformParagraphStyle4 = platformParagraphStyle;
                } else {
                    platformParagraphStyle4 = new PlatformParagraphStyle(((EmojiSupportMatch) SpanStyleKt.lerpDiscrete(fFloatValue, new EmojiSupportMatch(platformParagraphStyle.emojiSupportMatch), new EmojiSupportMatch(platformParagraphStyle2.emojiSupportMatch))).value, ((Boolean) SpanStyleKt.lerpDiscrete(fFloatValue, Boolean.valueOf(z10), Boolean.valueOf(z11))).booleanValue());
                }
            } else {
                platformParagraphStyle3 = PlatformParagraphStyle.Default;
                if (platformParagraphStyle == null) {
                    platformParagraphStyle = platformParagraphStyle3;
                }
                z10 = platformParagraphStyle.includeFontPadding;
                if (platformParagraphStyle2 == null) {
                    platformParagraphStyle2 = platformParagraphStyle3;
                }
                z11 = platformParagraphStyle2.includeFontPadding;
                if (z10 == z11) {
                    platformParagraphStyle4 = platformParagraphStyle;
                } else {
                    platformParagraphStyle4 = new PlatformParagraphStyle(((EmojiSupportMatch) SpanStyleKt.lerpDiscrete(fFloatValue, new EmojiSupportMatch(platformParagraphStyle.emojiSupportMatch), new EmojiSupportMatch(platformParagraphStyle2.emojiSupportMatch))).value, ((Boolean) SpanStyleKt.lerpDiscrete(fFloatValue, Boolean.valueOf(z10), Boolean.valueOf(z11))).booleanValue());
                }
            }
            textStyle3 = new TextStyle(spanStyle6, new ParagraphStyle(i18, i19, jM637lerpTextUnitInheritableC3pnCVY6, textIndent4, platformParagraphStyle4, (LineHeightStyle) SpanStyleKt.lerpDiscrete(fFloatValue, paragraphStyle3.lineHeightStyle, paragraphStyle4.lineHeightStyle), ((LineBreak) SpanStyleKt.lerpDiscrete(fFloatValue, new LineBreak(paragraphStyle3.lineBreak), new LineBreak(paragraphStyle4.lineBreak))).mask, ((Hyphens) SpanStyleKt.lerpDiscrete(fFloatValue, new Hyphens(paragraphStyle3.hyphens), new Hyphens(paragraphStyle4.hyphens))).value, (TextMotion) SpanStyleKt.lerpDiscrete(fFloatValue, paragraphStyle3.textMotion, paragraphStyle4.textMotion)));
            if (z4) {
                textStyleM647copyp1EtxEg$default = TextStyle.m647copyp1EtxEg$default(textStyle3, ((Color) transitionAnimationState2.value$delegate.getValue()).value, 0L, null, null, 0L, 0L, null, 16777214);
            } else {
                textStyleM647copyp1EtxEg$default = textStyle3;
            }
            m283Decoration3JVO9M(((Color) transitionAnimationStateCreateTransitionAnimation3.value$delegate.getValue()).value, textStyleM647copyp1EtxEg$default, Thread_jvmKt.rememberComposableLambda(57043598, new TextKt$$ExternalSyntheticLambda2(19, function3, textFieldImplKt$DecoratedLabel$labelScope$1$1), gapComposer), gapComposer, 384);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TextFieldImplKt$$ExternalSyntheticLambda1(state, textFieldColors, z, z2, z3, z4, transition, textStyle, textStyle2, function3, i);
        }
    }

    /* JADX INFO: renamed from: Decoration-3J-VO9M, reason: not valid java name */
    public static final void m283Decoration3JVO9M(long j, TextStyle textStyle, Function2 function2, GapComposer gapComposer, int i) {
        long j2;
        TextStyle textStyle2;
        Function2 function3;
        GapComposer gapComposer2;
        gapComposer.startRestartGroup(396611577);
        int i2 = (gapComposer.changed(j) ? 4 : 2) | i | (gapComposer.changed(textStyle) ? 32 : 16);
        if ((i & 384) == 0) {
            i2 |= gapComposer.changedInstance(function2) ? 256 : 128;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            gapComposer2 = gapComposer;
            LayoutUtilKt.m281ProvideContentColorTextStyle3JVO9M(j, textStyle, function2, gapComposer2, i2 & 1022);
            j2 = j;
            textStyle2 = textStyle;
            function3 = function2;
        } else {
            j2 = j;
            textStyle2 = textStyle;
            function3 = function2;
            gapComposer2 = gapComposer;
            gapComposer2.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TextFieldImplKt$$ExternalSyntheticLambda2(j2, textStyle2, function3, i, 0);
        }
    }

    public static final Alignment.Horizontal getMinimizedAlignment(TextFieldLabelPosition$Attached textFieldLabelPosition$Attached) {
        if (textFieldLabelPosition$Attached instanceof TextFieldLabelPosition$Attached) {
            return textFieldLabelPosition$Attached.minimizedAlignment;
        }
        throw new IllegalArgumentException("Unknown position: " + textFieldLabelPosition$Attached);
    }

    public static final float minimizedLabelHalfHeight(GapComposer gapComposer) {
        long j = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.bodySmall.paragraphStyle.lineHeight;
        long j2 = TypeScaleTokens.BodySmallLineHeight;
        if ((1095216660480L & j) != 4294967296L) {
            j = j2;
        }
        return ((Density) gapComposer.consume(CompositionLocalsKt.LocalDensity)).mo87toDpGaN1DYA(j) / 2;
    }

    public static final float textFieldHorizontalIconPadding(GapComposer gapComposer) {
        float f = ((Dp) gapComposer.consume(InteractiveComponentSizeKt.LocalMinimumInteractiveComponentSize)).value;
        if (Float.isNaN(f)) {
            f = 0;
        }
        float f2 = (f - SmallIconButtonTokens.IconSize) / 2;
        float f3 = 0;
        return f2 < f3 ? f3 : f2;
    }
}
