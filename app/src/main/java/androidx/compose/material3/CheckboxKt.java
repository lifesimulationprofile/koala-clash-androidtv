package androidx.compose.material3;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SnapSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TwoWayConverterImpl;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.foundation.shape.PercentCornerSize;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.tokens.CheckboxTokens;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotId_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.unit.Density;
import androidx.lifecycle.Lifecycle;
import coil.network.HttpException;
import com.github.kr328.clash.FilesActivity$$ExternalSyntheticLambda3;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class CheckboxKt {
    public static final float CheckboxDefaultPadding;
    public static final float CheckboxSize = 20;
    public static final float RadiusSize;

    static {
        float f = 2;
        CheckboxDefaultPadding = f;
        RadiusSize = f;
    }

    public static final void Checkbox(boolean z, Function1 function1, Modifier modifier, boolean z2, CheckboxColors checkboxColors, GapComposer gapComposer, int i) {
        Modifier modifier2;
        boolean z3;
        Modifier modifier3;
        Function0 function0;
        gapComposer.startRestartGroup(-1406741137);
        int i2 = i | (gapComposer.changed(z) ? 4 : 2) | (gapComposer.changedInstance(function1) ? 32 : 16) | 3456 | (gapComposer.changed(checkboxColors) ? 16384 : 8192) | 196608;
        boolean z4 = true;
        if (gapComposer.shouldExecute(i2 & 1, (74899 & i2) != 74898)) {
            gapComposer.startDefaults();
            if ((i & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                modifier3 = Modifier.Companion.$$INSTANCE;
            } else {
                gapComposer.skipToGroupEnd();
                modifier3 = modifier;
                z4 = z2;
            }
            gapComposer.endDefaults();
            float fFloor = (float) Math.floor(((Density) gapComposer.consume(CompositionLocalsKt.LocalDensity)).mo92toPx0680j_4(CheckboxDefaults.StrokeWidth));
            ToggleableState toggleableState = z ? ToggleableState.On : ToggleableState.Off;
            if (function1 != null) {
                gapComposer.startReplaceGroup(2066141046);
                boolean z5 = ((i2 & 112) == 32) | ((i2 & 14) == 4);
                Object objRememberedValue = gapComposer.rememberedValue();
                if (z5 || objRememberedValue == Composer$Companion.Empty) {
                    objRememberedValue = new CheckboxKt$$ExternalSyntheticLambda0(function1, z, 0);
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                function0 = (Function0) objRememberedValue;
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(2066206735);
                gapComposer.end(false);
                function0 = null;
            }
            Modifier modifier4 = modifier3;
            TriStateCheckbox(toggleableState, function0, new Stroke(fFloor, 0.0f, 2, 0, 26), new Stroke(fFloor, 0.0f, 0, 0, 30), modifier4, z4, checkboxColors, gapComposer, ((i2 << 6) & 3670016) | 12808704);
            modifier2 = modifier4;
            z3 = z4;
        } else {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
            z3 = z2;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new SwitchKt$$ExternalSyntheticLambda0(z, function1, modifier2, z3, checkboxColors, i, 1);
        }
    }

    /* JADX WARN: Code duplicated, block: B:106:0x018c  */
    /* JADX WARN: Code duplicated, block: B:114:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:117:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:123:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:125:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:126:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:134:0x0218  */
    /* JADX WARN: Code duplicated, block: B:145:0x0244  */
    /* JADX WARN: Code duplicated, block: B:149:0x025a  */
    /* JADX WARN: Code duplicated, block: B:156:0x027e  */
    /* JADX WARN: Code duplicated, block: B:158:0x0282  */
    /* JADX WARN: Code duplicated, block: B:163:0x029b  */
    /* JADX WARN: Code duplicated, block: B:166:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:169:0x02c4  */
    /* JADX WARN: Code duplicated, block: B:171:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:174:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:177:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:178:0x02fe  */
    /* JADX WARN: Code duplicated, block: B:181:0x031a  */
    /* JADX WARN: Code duplicated, block: B:183:0x0320  */
    /* JADX WARN: Code duplicated, block: B:185:0x0323  */
    /* JADX WARN: Code duplicated, block: B:188:0x0327  */
    /* JADX WARN: Code duplicated, block: B:190:0x032d  */
    /* JADX WARN: Code duplicated, block: B:191:0x0330  */
    /* JADX WARN: Code duplicated, block: B:192:0x0333  */
    /* JADX WARN: Code duplicated, block: B:194:0x0339  */
    /* JADX WARN: Code duplicated, block: B:196:0x033c  */
    /* JADX WARN: Code duplicated, block: B:198:0x033f  */
    /* JADX WARN: Code duplicated, block: B:199:0x0342  */
    /* JADX WARN: Code duplicated, block: B:201:0x0348  */
    /* JADX WARN: Code duplicated, block: B:202:0x034b  */
    /* JADX WARN: Code duplicated, block: B:204:0x034f  */
    /* JADX WARN: Code duplicated, block: B:205:0x0370  */
    /* JADX WARN: Code duplicated, block: B:207:0x0386  */
    /* JADX WARN: Code duplicated, block: B:209:0x038c  */
    /* JADX WARN: Code duplicated, block: B:211:0x038f  */
    /* JADX WARN: Code duplicated, block: B:214:0x0393  */
    /* JADX WARN: Code duplicated, block: B:216:0x0399  */
    /* JADX WARN: Code duplicated, block: B:218:0x039d  */
    /* JADX WARN: Code duplicated, block: B:219:0x03a0  */
    /* JADX WARN: Code duplicated, block: B:221:0x03a6  */
    /* JADX WARN: Code duplicated, block: B:223:0x03a9  */
    /* JADX WARN: Code duplicated, block: B:225:0x03ac  */
    /* JADX WARN: Code duplicated, block: B:226:0x03af  */
    /* JADX WARN: Code duplicated, block: B:228:0x03b5  */
    /* JADX WARN: Code duplicated, block: B:229:0x03b8  */
    /* JADX WARN: Code duplicated, block: B:231:0x03bd  */
    /* JADX WARN: Code duplicated, block: B:232:0x03df  */
    /* JADX WARN: Code duplicated, block: B:235:0x0416  */
    /* JADX WARN: Code duplicated, block: B:241:0x0423  */
    /* JADX WARN: Code duplicated, block: B:244:0x043c  */
    /* JADX WARN: Code duplicated, block: B:250:0x044a  */
    /* JADX WARN: Code duplicated, block: B:253:0x0454 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:256:0x0459  */
    public static final void CheckboxImpl(boolean z, ToggleableState toggleableState, Modifier modifier, CheckboxColors checkboxColors, Stroke stroke, Stroke stroke2, GapComposer gapComposer, int i) {
        int i2;
        Modifier modifier2;
        GapComposer gapComposer2;
        Object objMo773getCurrentState;
        float f;
        float f2;
        boolean zChanged;
        Object objRememberedValue;
        Object initialState;
        ToggleableState toggleableState2;
        FiniteAnimationSpec snapSpec;
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation;
        Object objMo773getCurrentState2;
        int iOrdinal;
        float f3;
        boolean zChanged2;
        Object objRememberedValue2;
        int iOrdinal2;
        boolean zChanged3;
        Object objRememberedValue3;
        Transition.Segment segment;
        FiniteAnimationSpec snapSpec2;
        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation2;
        Object objRememberedValue4;
        CheckDrawingCache checkDrawingCache;
        long j;
        State stateM26animateColorAsStateeuL9pac;
        GapComposer gapComposer3;
        int iOrdinal3;
        long j2;
        State stateRememberUpdatedState;
        int iOrdinal4;
        long j3;
        State stateRememberUpdatedState2;
        State state;
        boolean z2;
        boolean z3;
        boolean z4;
        Object objRememberedValue5;
        int i3;
        int iOrdinal5;
        int iOrdinal6;
        boolean zChanged4;
        Snapshot currentThreadSnapshot;
        Function1 readObserver;
        Snapshot snapshotMakeCurrentNonObservable;
        gapComposer.startRestartGroup(-891330208);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(toggleableState.ordinal()) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            modifier2 = modifier;
            i2 |= gapComposer.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changed(checkboxColors) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= (i & 32768) == 0 ? gapComposer.changed(stroke) : gapComposer.changedInstance(stroke) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= (i & 262144) == 0 ? gapComposer.changed(stroke2) : gapComposer.changedInstance(stroke2) ? 131072 : 65536;
        }
        if (gapComposer.shouldExecute(i2 & 1, (74899 & i2) != 74898)) {
            Transition transitionUpdateTransition = ArcSplineKt.updateTransition(toggleableState, null, gapComposer, (i2 >> 3) & 14, 2);
            Lifecycle lifecycle = transitionUpdateTransition.transitionState;
            FiniteAnimationSpec finiteAnimationSpecValue = ScrimKt.value(1, gapComposer);
            TwoWayConverterImpl twoWayConverterImpl = ArcSplineKt.FloatToVector;
            boolean zIsSeeking = transitionUpdateTransition.isSeeking();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (zIsSeeking) {
                gapComposer.startReplaceGroup(1666827533);
                gapComposer.end(false);
                objMo773getCurrentState = lifecycle.mo773getCurrentState();
            } else {
                gapComposer.startReplaceGroup(1666573488);
                boolean zChanged5 = gapComposer.changed(transitionUpdateTransition);
                objMo773getCurrentState = gapComposer.rememberedValue();
                if (zChanged5 || objMo773getCurrentState == neverEqualPolicy) {
                    Snapshot currentThreadSnapshot2 = SnapshotId_jvmKt.getCurrentThreadSnapshot();
                    Function1 readObserver2 = currentThreadSnapshot2 != null ? currentThreadSnapshot2.getReadObserver() : null;
                    Snapshot snapshotMakeCurrentNonObservable2 = SnapshotId_jvmKt.makeCurrentNonObservable(currentThreadSnapshot2);
                    try {
                        Object objMo773getCurrentState3 = lifecycle.mo773getCurrentState();
                        SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                        gapComposer.updateRememberedValue(objMo773getCurrentState3);
                        objMo773getCurrentState = objMo773getCurrentState3;
                    } catch (Throwable th) {
                        SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot2, snapshotMakeCurrentNonObservable2, readObserver2);
                        throw th;
                    }
                }
                gapComposer.end(false);
            }
            gapComposer.startReplaceGroup(-768316570);
            int iOrdinal7 = ((ToggleableState) objMo773getCurrentState).ordinal();
            float f4 = 0.0f;
            if (iOrdinal7 == 0) {
                f = 1.0f;
            } else if (iOrdinal7 != 1) {
                if (iOrdinal7 != 2) {
                    throw new HttpException();
                }
                f = 1.0f;
            } else {
                f = 0.0f;
            }
            gapComposer.end(false);
            Float fValueOf = Float.valueOf(f);
            boolean zChanged6 = gapComposer.changed(transitionUpdateTransition);
            Object objRememberedValue6 = gapComposer.rememberedValue();
            if (zChanged6 || objRememberedValue6 == neverEqualPolicy) {
                objRememberedValue6 = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionUpdateTransition, 3));
                gapComposer.updateRememberedValue(objRememberedValue6);
            }
            ToggleableState toggleableState3 = (ToggleableState) ((State) objRememberedValue6).getValue();
            gapComposer.startReplaceGroup(-768316570);
            int iOrdinal8 = toggleableState3.ordinal();
            if (iOrdinal8 != 0) {
                if (iOrdinal8 == 1) {
                    f2 = 0.0f;
                } else if (iOrdinal8 != 2) {
                    throw new HttpException();
                }
                gapComposer.end(false);
                Float fValueOf2 = Float.valueOf(f2);
                zChanged = gapComposer.changed(transitionUpdateTransition);
                objRememberedValue = gapComposer.rememberedValue();
                if (zChanged || objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionUpdateTransition, 4));
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                Transition.Segment segment2 = (Transition.Segment) ((State) objRememberedValue).getValue();
                gapComposer.startReplaceGroup(1780794470);
                initialState = segment2.getInitialState();
                toggleableState2 = ToggleableState.Off;
                if (initialState == toggleableState2 && segment2.getTargetState() == toggleableState2) {
                    snapSpec = new SnapSpec(100);
                } else {
                    snapSpec = finiteAnimationSpecValue;
                }
                gapComposer.end(false);
                transitionAnimationStateCreateTransitionAnimation = ArcSplineKt.createTransitionAnimation(transitionUpdateTransition, fValueOf, fValueOf2, snapSpec, twoWayConverterImpl, gapComposer, 0);
                if (transitionUpdateTransition.isSeeking()) {
                    gapComposer.startReplaceGroup(1666827533);
                    gapComposer.end(false);
                    objMo773getCurrentState2 = lifecycle.mo773getCurrentState();
                } else {
                    gapComposer.startReplaceGroup(1666573488);
                    zChanged4 = gapComposer.changed(transitionUpdateTransition);
                    Object objRememberedValue7 = gapComposer.rememberedValue();
                    if (!zChanged4 || objRememberedValue7 == neverEqualPolicy) {
                        currentThreadSnapshot = SnapshotId_jvmKt.getCurrentThreadSnapshot();
                        if (currentThreadSnapshot != null) {
                            readObserver = currentThreadSnapshot.getReadObserver();
                        } else {
                            readObserver = null;
                        }
                        snapshotMakeCurrentNonObservable = SnapshotId_jvmKt.makeCurrentNonObservable(currentThreadSnapshot);
                        try {
                            objMo773getCurrentState2 = lifecycle.mo773getCurrentState();
                            SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                            gapComposer.updateRememberedValue(objMo773getCurrentState2);
                        } catch (Throwable th2) {
                            SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                            throw th2;
                        }
                    } else {
                        objMo773getCurrentState2 = objRememberedValue7;
                    }
                    gapComposer.end(false);
                }
                gapComposer.startReplaceGroup(1840054703);
                iOrdinal = ((ToggleableState) objMo773getCurrentState2).ordinal();
                if (iOrdinal != 0 || iOrdinal == 1) {
                    f3 = 0.0f;
                } else {
                    if (iOrdinal != 2) {
                        throw new HttpException();
                    }
                    f3 = 1.0f;
                }
                gapComposer.end(false);
                Float fValueOf3 = Float.valueOf(f3);
                zChanged2 = gapComposer.changed(transitionUpdateTransition);
                objRememberedValue2 = gapComposer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionUpdateTransition, 5));
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                ToggleableState toggleableState4 = (ToggleableState) ((State) objRememberedValue2).getValue();
                gapComposer.startReplaceGroup(1840054703);
                iOrdinal2 = toggleableState4.ordinal();
                if (iOrdinal2 != 0 && iOrdinal2 != 1) {
                    if (iOrdinal2 == 2) {
                        throw new HttpException();
                    }
                    f4 = 1.0f;
                }
                gapComposer.end(false);
                Float fValueOf4 = Float.valueOf(f4);
                zChanged3 = gapComposer.changed(transitionUpdateTransition);
                objRememberedValue3 = gapComposer.rememberedValue();
                if (zChanged3 || objRememberedValue3 == neverEqualPolicy) {
                    objRememberedValue3 = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionUpdateTransition, 6));
                    gapComposer.updateRememberedValue(objRememberedValue3);
                }
                segment = (Transition.Segment) ((State) objRememberedValue3).getValue();
                gapComposer.startReplaceGroup(630790831);
                if (segment.getInitialState() == toggleableState2) {
                    finiteAnimationSpecValue = ArcSplineKt.snap$default();
                } else {
                    if (segment.getTargetState() == toggleableState2) {
                        snapSpec2 = new SnapSpec(100);
                    }
                    gapComposer.end(false);
                    transitionAnimationStateCreateTransitionAnimation2 = ArcSplineKt.createTransitionAnimation(transitionUpdateTransition, fValueOf3, fValueOf4, snapSpec2, twoWayConverterImpl, gapComposer, 0);
                    objRememberedValue4 = gapComposer.rememberedValue();
                    if (objRememberedValue4 == neverEqualPolicy) {
                        objRememberedValue4 = new CheckDrawingCache();
                        gapComposer.updateRememberedValue(objRememberedValue4);
                    }
                    checkDrawingCache = (CheckDrawingCache) objRememberedValue4;
                    gapComposer.startReplaceGroup(-2128520210);
                    if (toggleableState == toggleableState2) {
                        j = checkboxColors.uncheckedCheckmarkColor;
                    } else {
                        j = checkboxColors.checkedCheckmarkColor;
                    }
                    stateM26animateColorAsStateeuL9pac = SingleValueAnimationKt.m26animateColorAsStateeuL9pac(j, CheckboxColors.colorAnimationSpecForState(toggleableState, gapComposer), null, gapComposer, 0, 12);
                    gapComposer3 = gapComposer;
                    gapComposer3.end(false);
                    if (z) {
                        iOrdinal6 = toggleableState.ordinal();
                        if (iOrdinal6 == 0) {
                            j2 = checkboxColors.checkedBoxColor;
                        } else if (iOrdinal6 != 1) {
                            if (iOrdinal6 != 2) {
                                throw new HttpException();
                            }
                            j2 = checkboxColors.checkedBoxColor;
                        } else {
                            j2 = checkboxColors.uncheckedBoxColor;
                        }
                    } else {
                        iOrdinal3 = toggleableState.ordinal();
                        if (iOrdinal3 != 0) {
                            j2 = checkboxColors.disabledCheckedBoxColor;
                        } else if (iOrdinal3 != 1) {
                            j2 = checkboxColors.disabledUncheckedBoxColor;
                        } else {
                            if (iOrdinal3 == 2) {
                                throw new HttpException();
                            }
                            j2 = checkboxColors.disabledIndeterminateBoxColor;
                        }
                    }
                    if (z) {
                        gapComposer3.startReplaceGroup(496026915);
                        stateRememberUpdatedState = SingleValueAnimationKt.m26animateColorAsStateeuL9pac(j2, CheckboxColors.colorAnimationSpecForState(toggleableState, gapComposer3), null, gapComposer, 0, 12);
                        gapComposer3 = gapComposer;
                        gapComposer3.end(false);
                    } else {
                        gapComposer3.startReplaceGroup(496117125);
                        stateRememberUpdatedState = Stack.rememberUpdatedState(new Color(j2), gapComposer3);
                        gapComposer3.end(false);
                    }
                    if (z) {
                        iOrdinal5 = toggleableState.ordinal();
                        if (iOrdinal5 == 0) {
                            j3 = checkboxColors.checkedBorderColor;
                        } else if (iOrdinal5 != 1) {
                            if (iOrdinal5 != 2) {
                                throw new HttpException();
                            }
                            j3 = checkboxColors.checkedBorderColor;
                        } else {
                            j3 = checkboxColors.uncheckedBorderColor;
                        }
                    } else {
                        iOrdinal4 = toggleableState.ordinal();
                        if (iOrdinal4 != 0) {
                            j3 = checkboxColors.disabledBorderColor;
                        } else if (iOrdinal4 != 1) {
                            j3 = checkboxColors.disabledUncheckedBorderColor;
                        } else {
                            if (iOrdinal4 == 2) {
                                throw new HttpException();
                            }
                            j3 = checkboxColors.disabledIndeterminateBorderColor;
                        }
                    }
                    if (z) {
                        gapComposer3.startReplaceGroup(633206758);
                        stateRememberUpdatedState2 = SingleValueAnimationKt.m26animateColorAsStateeuL9pac(j3, CheckboxColors.colorAnimationSpecForState(toggleableState, gapComposer3), null, gapComposer, 0, 12);
                        gapComposer2 = gapComposer;
                        gapComposer2.end(false);
                    } else {
                        long j4 = j3;
                        gapComposer2 = gapComposer3;
                        gapComposer2.startReplaceGroup(633296968);
                        stateRememberUpdatedState2 = Stack.rememberUpdatedState(new Color(j4), gapComposer2);
                        gapComposer2.end(false);
                    }
                    Modifier modifierM137requiredSize3ABfNKs = SizeKt.m137requiredSize3ABfNKs(SizeKt.wrapContentSize$default(modifier2), CheckboxSize);
                    boolean zChanged7 = gapComposer2.changed(stateRememberUpdatedState) | gapComposer2.changed(stateRememberUpdatedState2);
                    state = stateRememberUpdatedState2;
                    if ((i2 & 458752) != 131072 || ((i2 & 262144) != 0 && gapComposer2.changedInstance(stroke2))) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    boolean zChanged8 = z2 | zChanged7 | gapComposer2.changed(stateM26animateColorAsStateeuL9pac) | gapComposer2.changed(transitionAnimationStateCreateTransitionAnimation) | gapComposer2.changed(transitionAnimationStateCreateTransitionAnimation2);
                    if ((57344 & i2) != 16384 || ((i2 & 32768) != 0 && gapComposer2.changedInstance(stroke))) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    z4 = zChanged8 | z3;
                    objRememberedValue5 = gapComposer2.rememberedValue();
                    if (!z4 || objRememberedValue5 == neverEqualPolicy) {
                        i3 = 0;
                        FilesActivity$$ExternalSyntheticLambda3 filesActivity$$ExternalSyntheticLambda3 = new FilesActivity$$ExternalSyntheticLambda3(stateRememberUpdatedState, state, stroke2, stateM26animateColorAsStateeuL9pac, transitionAnimationStateCreateTransitionAnimation, transitionAnimationStateCreateTransitionAnimation2, stroke, checkDrawingCache);
                        gapComposer2.updateRememberedValue(filesActivity$$ExternalSyntheticLambda3);
                        objRememberedValue5 = filesActivity$$ExternalSyntheticLambda3;
                    } else {
                        i3 = 0;
                    }
                    ImageKt.Canvas(modifierM137requiredSize3ABfNKs, (Function1) objRememberedValue5, gapComposer2, i3);
                }
                snapSpec2 = finiteAnimationSpecValue;
                gapComposer.end(false);
                transitionAnimationStateCreateTransitionAnimation2 = ArcSplineKt.createTransitionAnimation(transitionUpdateTransition, fValueOf3, fValueOf4, snapSpec2, twoWayConverterImpl, gapComposer, 0);
                objRememberedValue4 = gapComposer.rememberedValue();
                if (objRememberedValue4 == neverEqualPolicy) {
                    objRememberedValue4 = new CheckDrawingCache();
                    gapComposer.updateRememberedValue(objRememberedValue4);
                }
                checkDrawingCache = (CheckDrawingCache) objRememberedValue4;
                gapComposer.startReplaceGroup(-2128520210);
                if (toggleableState == toggleableState2) {
                    j = checkboxColors.uncheckedCheckmarkColor;
                } else {
                    j = checkboxColors.checkedCheckmarkColor;
                }
                stateM26animateColorAsStateeuL9pac = SingleValueAnimationKt.m26animateColorAsStateeuL9pac(j, CheckboxColors.colorAnimationSpecForState(toggleableState, gapComposer), null, gapComposer, 0, 12);
                gapComposer3 = gapComposer;
                gapComposer3.end(false);
                if (z) {
                    iOrdinal6 = toggleableState.ordinal();
                    if (iOrdinal6 == 0) {
                        j2 = checkboxColors.checkedBoxColor;
                    } else if (iOrdinal6 != 1) {
                        if (iOrdinal6 != 2) {
                            throw new HttpException();
                        }
                        j2 = checkboxColors.checkedBoxColor;
                    } else {
                        j2 = checkboxColors.uncheckedBoxColor;
                    }
                } else {
                    iOrdinal3 = toggleableState.ordinal();
                    if (iOrdinal3 != 0) {
                        j2 = checkboxColors.disabledCheckedBoxColor;
                    } else if (iOrdinal3 != 1) {
                        j2 = checkboxColors.disabledUncheckedBoxColor;
                    } else {
                        if (iOrdinal3 == 2) {
                            throw new HttpException();
                        }
                        j2 = checkboxColors.disabledIndeterminateBoxColor;
                    }
                }
                if (z) {
                    gapComposer3.startReplaceGroup(496026915);
                    stateRememberUpdatedState = SingleValueAnimationKt.m26animateColorAsStateeuL9pac(j2, CheckboxColors.colorAnimationSpecForState(toggleableState, gapComposer3), null, gapComposer, 0, 12);
                    gapComposer3 = gapComposer;
                    gapComposer3.end(false);
                } else {
                    gapComposer3.startReplaceGroup(496117125);
                    stateRememberUpdatedState = Stack.rememberUpdatedState(new Color(j2), gapComposer3);
                    gapComposer3.end(false);
                }
                if (z) {
                    iOrdinal5 = toggleableState.ordinal();
                    if (iOrdinal5 == 0) {
                        j3 = checkboxColors.checkedBorderColor;
                    } else if (iOrdinal5 != 1) {
                        if (iOrdinal5 != 2) {
                            throw new HttpException();
                        }
                        j3 = checkboxColors.checkedBorderColor;
                    } else {
                        j3 = checkboxColors.uncheckedBorderColor;
                    }
                } else {
                    iOrdinal4 = toggleableState.ordinal();
                    if (iOrdinal4 != 0) {
                        j3 = checkboxColors.disabledBorderColor;
                    } else if (iOrdinal4 != 1) {
                        j3 = checkboxColors.disabledUncheckedBorderColor;
                    } else {
                        if (iOrdinal4 == 2) {
                            throw new HttpException();
                        }
                        j3 = checkboxColors.disabledIndeterminateBorderColor;
                    }
                }
                if (z) {
                    gapComposer3.startReplaceGroup(633206758);
                    stateRememberUpdatedState2 = SingleValueAnimationKt.m26animateColorAsStateeuL9pac(j3, CheckboxColors.colorAnimationSpecForState(toggleableState, gapComposer3), null, gapComposer, 0, 12);
                    gapComposer2 = gapComposer;
                    gapComposer2.end(false);
                } else {
                    long j5 = j3;
                    gapComposer2 = gapComposer3;
                    gapComposer2.startReplaceGroup(633296968);
                    stateRememberUpdatedState2 = Stack.rememberUpdatedState(new Color(j5), gapComposer2);
                    gapComposer2.end(false);
                }
                Modifier modifierM137requiredSize3ABfNKs2 = SizeKt.m137requiredSize3ABfNKs(SizeKt.wrapContentSize$default(modifier2), CheckboxSize);
                boolean zChanged9 = gapComposer2.changed(stateRememberUpdatedState) | gapComposer2.changed(stateRememberUpdatedState2);
                state = stateRememberUpdatedState2;
                if ((i2 & 458752) != 131072) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                boolean zChanged10 = z2 | zChanged9 | gapComposer2.changed(stateM26animateColorAsStateeuL9pac) | gapComposer2.changed(transitionAnimationStateCreateTransitionAnimation) | gapComposer2.changed(transitionAnimationStateCreateTransitionAnimation2);
                if ((57344 & i2) != 16384) {
                    z3 = true;
                } else {
                    z3 = true;
                }
                z4 = zChanged10 | z3;
                objRememberedValue5 = gapComposer2.rememberedValue();
                if (z4) {
                    i3 = 0;
                    FilesActivity$$ExternalSyntheticLambda3 filesActivity$$ExternalSyntheticLambda4 = new FilesActivity$$ExternalSyntheticLambda3(stateRememberUpdatedState, state, stroke2, stateM26animateColorAsStateeuL9pac, transitionAnimationStateCreateTransitionAnimation, transitionAnimationStateCreateTransitionAnimation2, stroke, checkDrawingCache);
                    gapComposer2.updateRememberedValue(filesActivity$$ExternalSyntheticLambda4);
                    objRememberedValue5 = filesActivity$$ExternalSyntheticLambda4;
                } else {
                    i3 = 0;
                    FilesActivity$$ExternalSyntheticLambda3 filesActivity$$ExternalSyntheticLambda5 = new FilesActivity$$ExternalSyntheticLambda3(stateRememberUpdatedState, state, stroke2, stateM26animateColorAsStateeuL9pac, transitionAnimationStateCreateTransitionAnimation, transitionAnimationStateCreateTransitionAnimation2, stroke, checkDrawingCache);
                    gapComposer2.updateRememberedValue(filesActivity$$ExternalSyntheticLambda5);
                    objRememberedValue5 = filesActivity$$ExternalSyntheticLambda5;
                }
                ImageKt.Canvas(modifierM137requiredSize3ABfNKs2, (Function1) objRememberedValue5, gapComposer2, i3);
            }
            f2 = 1.0f;
            gapComposer.end(false);
            Float fValueOf5 = Float.valueOf(f2);
            zChanged = gapComposer.changed(transitionUpdateTransition);
            objRememberedValue = gapComposer.rememberedValue();
            if (zChanged) {
                objRememberedValue = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionUpdateTransition, 4));
                gapComposer.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionUpdateTransition, 4));
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Transition.Segment segment3 = (Transition.Segment) ((State) objRememberedValue).getValue();
            gapComposer.startReplaceGroup(1780794470);
            initialState = segment3.getInitialState();
            toggleableState2 = ToggleableState.Off;
            if (initialState == toggleableState2) {
                snapSpec = finiteAnimationSpecValue;
            } else {
                snapSpec = new SnapSpec(100);
            }
            gapComposer.end(false);
            transitionAnimationStateCreateTransitionAnimation = ArcSplineKt.createTransitionAnimation(transitionUpdateTransition, fValueOf, fValueOf5, snapSpec, twoWayConverterImpl, gapComposer, 0);
            if (transitionUpdateTransition.isSeeking()) {
                gapComposer.startReplaceGroup(1666573488);
                zChanged4 = gapComposer.changed(transitionUpdateTransition);
                Object objRememberedValue8 = gapComposer.rememberedValue();
                if (zChanged4) {
                    currentThreadSnapshot = SnapshotId_jvmKt.getCurrentThreadSnapshot();
                    if (currentThreadSnapshot != null) {
                        readObserver = currentThreadSnapshot.getReadObserver();
                    } else {
                        readObserver = null;
                    }
                    snapshotMakeCurrentNonObservable = SnapshotId_jvmKt.makeCurrentNonObservable(currentThreadSnapshot);
                    objMo773getCurrentState2 = lifecycle.mo773getCurrentState();
                    SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    gapComposer.updateRememberedValue(objMo773getCurrentState2);
                } else {
                    currentThreadSnapshot = SnapshotId_jvmKt.getCurrentThreadSnapshot();
                    if (currentThreadSnapshot != null) {
                        readObserver = currentThreadSnapshot.getReadObserver();
                    } else {
                        readObserver = null;
                    }
                    snapshotMakeCurrentNonObservable = SnapshotId_jvmKt.makeCurrentNonObservable(currentThreadSnapshot);
                    objMo773getCurrentState2 = lifecycle.mo773getCurrentState();
                    SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    gapComposer.updateRememberedValue(objMo773getCurrentState2);
                }
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(1666827533);
                gapComposer.end(false);
                objMo773getCurrentState2 = lifecycle.mo773getCurrentState();
            }
            gapComposer.startReplaceGroup(1840054703);
            iOrdinal = ((ToggleableState) objMo773getCurrentState2).ordinal();
            if (iOrdinal != 0) {
                f3 = 0.0f;
            } else {
                f3 = 0.0f;
            }
            gapComposer.end(false);
            Float fValueOf6 = Float.valueOf(f3);
            zChanged2 = gapComposer.changed(transitionUpdateTransition);
            objRememberedValue2 = gapComposer.rememberedValue();
            if (zChanged2) {
                objRememberedValue2 = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionUpdateTransition, 5));
                gapComposer.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionUpdateTransition, 5));
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            ToggleableState toggleableState5 = (ToggleableState) ((State) objRememberedValue2).getValue();
            gapComposer.startReplaceGroup(1840054703);
            iOrdinal2 = toggleableState5.ordinal();
            if (iOrdinal2 != 0) {
                if (iOrdinal2 == 2) {
                    throw new HttpException();
                }
                f4 = 1.0f;
            }
            gapComposer.end(false);
            Float fValueOf7 = Float.valueOf(f4);
            zChanged3 = gapComposer.changed(transitionUpdateTransition);
            objRememberedValue3 = gapComposer.rememberedValue();
            if (zChanged3) {
                objRememberedValue3 = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionUpdateTransition, 6));
                gapComposer.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transitionUpdateTransition, 6));
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            segment = (Transition.Segment) ((State) objRememberedValue3).getValue();
            gapComposer.startReplaceGroup(630790831);
            if (segment.getInitialState() == toggleableState2) {
                finiteAnimationSpecValue = ArcSplineKt.snap$default();
            } else {
                if (segment.getTargetState() == toggleableState2) {
                    snapSpec2 = new SnapSpec(100);
                }
                gapComposer.end(false);
                transitionAnimationStateCreateTransitionAnimation2 = ArcSplineKt.createTransitionAnimation(transitionUpdateTransition, fValueOf6, fValueOf7, snapSpec2, twoWayConverterImpl, gapComposer, 0);
                objRememberedValue4 = gapComposer.rememberedValue();
                if (objRememberedValue4 == neverEqualPolicy) {
                    objRememberedValue4 = new CheckDrawingCache();
                    gapComposer.updateRememberedValue(objRememberedValue4);
                }
                checkDrawingCache = (CheckDrawingCache) objRememberedValue4;
                gapComposer.startReplaceGroup(-2128520210);
                if (toggleableState == toggleableState2) {
                    j = checkboxColors.uncheckedCheckmarkColor;
                } else {
                    j = checkboxColors.checkedCheckmarkColor;
                }
                stateM26animateColorAsStateeuL9pac = SingleValueAnimationKt.m26animateColorAsStateeuL9pac(j, CheckboxColors.colorAnimationSpecForState(toggleableState, gapComposer), null, gapComposer, 0, 12);
                gapComposer3 = gapComposer;
                gapComposer3.end(false);
                if (z) {
                    iOrdinal6 = toggleableState.ordinal();
                    if (iOrdinal6 == 0) {
                        j2 = checkboxColors.checkedBoxColor;
                    } else if (iOrdinal6 != 1) {
                        if (iOrdinal6 != 2) {
                            throw new HttpException();
                        }
                        j2 = checkboxColors.checkedBoxColor;
                    } else {
                        j2 = checkboxColors.uncheckedBoxColor;
                    }
                } else {
                    iOrdinal3 = toggleableState.ordinal();
                    if (iOrdinal3 != 0) {
                        j2 = checkboxColors.disabledCheckedBoxColor;
                    } else if (iOrdinal3 != 1) {
                        j2 = checkboxColors.disabledUncheckedBoxColor;
                    } else {
                        if (iOrdinal3 == 2) {
                            throw new HttpException();
                        }
                        j2 = checkboxColors.disabledIndeterminateBoxColor;
                    }
                }
                if (z) {
                    gapComposer3.startReplaceGroup(496026915);
                    stateRememberUpdatedState = SingleValueAnimationKt.m26animateColorAsStateeuL9pac(j2, CheckboxColors.colorAnimationSpecForState(toggleableState, gapComposer3), null, gapComposer, 0, 12);
                    gapComposer3 = gapComposer;
                    gapComposer3.end(false);
                } else {
                    gapComposer3.startReplaceGroup(496117125);
                    stateRememberUpdatedState = Stack.rememberUpdatedState(new Color(j2), gapComposer3);
                    gapComposer3.end(false);
                }
                if (z) {
                    iOrdinal5 = toggleableState.ordinal();
                    if (iOrdinal5 == 0) {
                        j3 = checkboxColors.checkedBorderColor;
                    } else if (iOrdinal5 != 1) {
                        if (iOrdinal5 != 2) {
                            throw new HttpException();
                        }
                        j3 = checkboxColors.checkedBorderColor;
                    } else {
                        j3 = checkboxColors.uncheckedBorderColor;
                    }
                } else {
                    iOrdinal4 = toggleableState.ordinal();
                    if (iOrdinal4 != 0) {
                        j3 = checkboxColors.disabledBorderColor;
                    } else if (iOrdinal4 != 1) {
                        j3 = checkboxColors.disabledUncheckedBorderColor;
                    } else {
                        if (iOrdinal4 == 2) {
                            throw new HttpException();
                        }
                        j3 = checkboxColors.disabledIndeterminateBorderColor;
                    }
                }
                if (z) {
                    gapComposer3.startReplaceGroup(633206758);
                    stateRememberUpdatedState2 = SingleValueAnimationKt.m26animateColorAsStateeuL9pac(j3, CheckboxColors.colorAnimationSpecForState(toggleableState, gapComposer3), null, gapComposer, 0, 12);
                    gapComposer2 = gapComposer;
                    gapComposer2.end(false);
                } else {
                    long j6 = j3;
                    gapComposer2 = gapComposer3;
                    gapComposer2.startReplaceGroup(633296968);
                    stateRememberUpdatedState2 = Stack.rememberUpdatedState(new Color(j6), gapComposer2);
                    gapComposer2.end(false);
                }
                Modifier modifierM137requiredSize3ABfNKs3 = SizeKt.m137requiredSize3ABfNKs(SizeKt.wrapContentSize$default(modifier2), CheckboxSize);
                boolean zChanged11 = gapComposer2.changed(stateRememberUpdatedState) | gapComposer2.changed(stateRememberUpdatedState2);
                state = stateRememberUpdatedState2;
                if ((i2 & 458752) != 131072) {
                    z2 = true;
                } else {
                    z2 = true;
                }
                boolean zChanged12 = z2 | zChanged11 | gapComposer2.changed(stateM26animateColorAsStateeuL9pac) | gapComposer2.changed(transitionAnimationStateCreateTransitionAnimation) | gapComposer2.changed(transitionAnimationStateCreateTransitionAnimation2);
                if ((57344 & i2) != 16384) {
                    z3 = true;
                } else {
                    z3 = true;
                }
                z4 = zChanged12 | z3;
                objRememberedValue5 = gapComposer2.rememberedValue();
                if (z4) {
                    i3 = 0;
                    FilesActivity$$ExternalSyntheticLambda3 filesActivity$$ExternalSyntheticLambda6 = new FilesActivity$$ExternalSyntheticLambda3(stateRememberUpdatedState, state, stroke2, stateM26animateColorAsStateeuL9pac, transitionAnimationStateCreateTransitionAnimation, transitionAnimationStateCreateTransitionAnimation2, stroke, checkDrawingCache);
                    gapComposer2.updateRememberedValue(filesActivity$$ExternalSyntheticLambda6);
                    objRememberedValue5 = filesActivity$$ExternalSyntheticLambda6;
                } else {
                    i3 = 0;
                    FilesActivity$$ExternalSyntheticLambda3 filesActivity$$ExternalSyntheticLambda7 = new FilesActivity$$ExternalSyntheticLambda3(stateRememberUpdatedState, state, stroke2, stateM26animateColorAsStateeuL9pac, transitionAnimationStateCreateTransitionAnimation, transitionAnimationStateCreateTransitionAnimation2, stroke, checkDrawingCache);
                    gapComposer2.updateRememberedValue(filesActivity$$ExternalSyntheticLambda7);
                    objRememberedValue5 = filesActivity$$ExternalSyntheticLambda7;
                }
                ImageKt.Canvas(modifierM137requiredSize3ABfNKs3, (Function1) objRememberedValue5, gapComposer2, i3);
            }
            snapSpec2 = finiteAnimationSpecValue;
            gapComposer.end(false);
            transitionAnimationStateCreateTransitionAnimation2 = ArcSplineKt.createTransitionAnimation(transitionUpdateTransition, fValueOf6, fValueOf7, snapSpec2, twoWayConverterImpl, gapComposer, 0);
            objRememberedValue4 = gapComposer.rememberedValue();
            if (objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = new CheckDrawingCache();
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            checkDrawingCache = (CheckDrawingCache) objRememberedValue4;
            gapComposer.startReplaceGroup(-2128520210);
            if (toggleableState == toggleableState2) {
                j = checkboxColors.uncheckedCheckmarkColor;
            } else {
                j = checkboxColors.checkedCheckmarkColor;
            }
            stateM26animateColorAsStateeuL9pac = SingleValueAnimationKt.m26animateColorAsStateeuL9pac(j, CheckboxColors.colorAnimationSpecForState(toggleableState, gapComposer), null, gapComposer, 0, 12);
            gapComposer3 = gapComposer;
            gapComposer3.end(false);
            if (z) {
                iOrdinal6 = toggleableState.ordinal();
                if (iOrdinal6 == 0) {
                    j2 = checkboxColors.checkedBoxColor;
                } else if (iOrdinal6 != 1) {
                    if (iOrdinal6 != 2) {
                        throw new HttpException();
                    }
                    j2 = checkboxColors.checkedBoxColor;
                } else {
                    j2 = checkboxColors.uncheckedBoxColor;
                }
            } else {
                iOrdinal3 = toggleableState.ordinal();
                if (iOrdinal3 != 0) {
                    j2 = checkboxColors.disabledCheckedBoxColor;
                } else if (iOrdinal3 != 1) {
                    j2 = checkboxColors.disabledUncheckedBoxColor;
                } else {
                    if (iOrdinal3 == 2) {
                        throw new HttpException();
                    }
                    j2 = checkboxColors.disabledIndeterminateBoxColor;
                }
            }
            if (z) {
                gapComposer3.startReplaceGroup(496026915);
                stateRememberUpdatedState = SingleValueAnimationKt.m26animateColorAsStateeuL9pac(j2, CheckboxColors.colorAnimationSpecForState(toggleableState, gapComposer3), null, gapComposer, 0, 12);
                gapComposer3 = gapComposer;
                gapComposer3.end(false);
            } else {
                gapComposer3.startReplaceGroup(496117125);
                stateRememberUpdatedState = Stack.rememberUpdatedState(new Color(j2), gapComposer3);
                gapComposer3.end(false);
            }
            if (z) {
                iOrdinal5 = toggleableState.ordinal();
                if (iOrdinal5 == 0) {
                    j3 = checkboxColors.checkedBorderColor;
                } else if (iOrdinal5 != 1) {
                    if (iOrdinal5 != 2) {
                        throw new HttpException();
                    }
                    j3 = checkboxColors.checkedBorderColor;
                } else {
                    j3 = checkboxColors.uncheckedBorderColor;
                }
            } else {
                iOrdinal4 = toggleableState.ordinal();
                if (iOrdinal4 != 0) {
                    j3 = checkboxColors.disabledBorderColor;
                } else if (iOrdinal4 != 1) {
                    j3 = checkboxColors.disabledUncheckedBorderColor;
                } else {
                    if (iOrdinal4 == 2) {
                        throw new HttpException();
                    }
                    j3 = checkboxColors.disabledIndeterminateBorderColor;
                }
            }
            if (z) {
                gapComposer3.startReplaceGroup(633206758);
                stateRememberUpdatedState2 = SingleValueAnimationKt.m26animateColorAsStateeuL9pac(j3, CheckboxColors.colorAnimationSpecForState(toggleableState, gapComposer3), null, gapComposer, 0, 12);
                gapComposer2 = gapComposer;
                gapComposer2.end(false);
            } else {
                long j7 = j3;
                gapComposer2 = gapComposer3;
                gapComposer2.startReplaceGroup(633296968);
                stateRememberUpdatedState2 = Stack.rememberUpdatedState(new Color(j7), gapComposer2);
                gapComposer2.end(false);
            }
            Modifier modifierM137requiredSize3ABfNKs4 = SizeKt.m137requiredSize3ABfNKs(SizeKt.wrapContentSize$default(modifier2), CheckboxSize);
            boolean zChanged13 = gapComposer2.changed(stateRememberUpdatedState) | gapComposer2.changed(stateRememberUpdatedState2);
            state = stateRememberUpdatedState2;
            if ((i2 & 458752) != 131072) {
                z2 = true;
            } else {
                z2 = true;
            }
            boolean zChanged14 = z2 | zChanged13 | gapComposer2.changed(stateM26animateColorAsStateeuL9pac) | gapComposer2.changed(transitionAnimationStateCreateTransitionAnimation) | gapComposer2.changed(transitionAnimationStateCreateTransitionAnimation2);
            if ((57344 & i2) != 16384) {
                z3 = true;
            } else {
                z3 = true;
            }
            z4 = zChanged14 | z3;
            objRememberedValue5 = gapComposer2.rememberedValue();
            if (z4) {
                i3 = 0;
                FilesActivity$$ExternalSyntheticLambda3 filesActivity$$ExternalSyntheticLambda8 = new FilesActivity$$ExternalSyntheticLambda3(stateRememberUpdatedState, state, stroke2, stateM26animateColorAsStateeuL9pac, transitionAnimationStateCreateTransitionAnimation, transitionAnimationStateCreateTransitionAnimation2, stroke, checkDrawingCache);
                gapComposer2.updateRememberedValue(filesActivity$$ExternalSyntheticLambda8);
                objRememberedValue5 = filesActivity$$ExternalSyntheticLambda8;
            } else {
                i3 = 0;
                FilesActivity$$ExternalSyntheticLambda3 filesActivity$$ExternalSyntheticLambda9 = new FilesActivity$$ExternalSyntheticLambda3(stateRememberUpdatedState, state, stroke2, stateM26animateColorAsStateeuL9pac, transitionAnimationStateCreateTransitionAnimation, transitionAnimationStateCreateTransitionAnimation2, stroke, checkDrawingCache);
                gapComposer2.updateRememberedValue(filesActivity$$ExternalSyntheticLambda9);
                objRememberedValue5 = filesActivity$$ExternalSyntheticLambda9;
            }
            ImageKt.Canvas(modifierM137requiredSize3ABfNKs4, (Function1) objRememberedValue5, gapComposer2, i3);
        } else {
            gapComposer2 = gapComposer;
            gapComposer2.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new CheckboxKt$$ExternalSyntheticLambda4(z, toggleableState, modifier, checkboxColors, stroke, stroke2, i);
        }
    }

    public static final void TriStateCheckbox(ToggleableState toggleableState, Function0 function0, Stroke stroke, Stroke stroke2, Modifier modifier, boolean z, CheckboxColors checkboxColors, GapComposer gapComposer, int i) {
        int i2;
        CheckboxColors checkboxColors2;
        ToggleableState toggleableState2;
        Modifier modifierM156triStateToggleableO2vRcR0;
        Modifier modifier2;
        gapComposer.startRestartGroup(-406243761);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(toggleableState.ordinal()) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= (i & 512) == 0 ? gapComposer.changed(stroke) : gapComposer.changedInstance(stroke) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= (i & 4096) == 0 ? gapComposer.changed(stroke2) : gapComposer.changedInstance(stroke2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer.changed(modifier) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= gapComposer.changed(z) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            checkboxColors2 = checkboxColors;
            i2 |= gapComposer.changed(checkboxColors2) ? 1048576 : 524288;
        } else {
            checkboxColors2 = checkboxColors;
        }
        if ((12582912 & i) == 0) {
            i2 |= gapComposer.changed((Object) null) ? 8388608 : 4194304;
        }
        if (gapComposer.shouldExecute(i2 & 1, (4793491 & i2) != 4793490)) {
            gapComposer.startDefaults();
            if ((i & 1) != 0 && !gapComposer.getDefaultsInvalid()) {
                gapComposer.skipToGroupEnd();
            }
            gapComposer.endDefaults();
            float f = CheckboxTokens.StateLayerSize / 2;
            long j = Color.Unspecified;
            RoundedCornerShape roundedCornerShape = RoundedCornerShapeKt.CircleShape;
            PercentCornerSize percentCornerSize = new PercentCornerSize(25);
            RippleNodeFactory rippleNodeFactoryM260rippleOu1YvPQ$default = RippleKt.m260rippleOu1YvPQ$default(f, j, new RoundedCornerShape(percentCornerSize, percentCornerSize, percentCornerSize, percentCornerSize), false, 240);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            if (function0 != null) {
                toggleableState2 = toggleableState;
                modifierM156triStateToggleableO2vRcR0 = SelectableKt.m156triStateToggleableO2vRcR0(toggleableState2, rippleNodeFactoryM260rippleOu1YvPQ$default, z, new Role(1), function0);
            } else {
                toggleableState2 = toggleableState;
                modifierM156triStateToggleableO2vRcR0 = companion;
            }
            if (function0 != null) {
                HorizontalAlignmentLine horizontalAlignmentLine = InteractiveComponentSizeKt.MinimumInteractiveTopAlignmentLine;
                modifier2 = MinimumInteractiveModifier.INSTANCE;
            } else {
                modifier2 = companion;
            }
            Modifier modifierThen = modifier.then(modifier2).then(modifierM156triStateToggleableO2vRcR0).then(OffsetKt.m128padding3ABfNKs(companion, CheckboxDefaultPadding));
            int i3 = ((i2 >> 15) & 14) | ((i2 << 3) & 112) | ((i2 >> 9) & 7168) | 32768;
            int i4 = i2 << 6;
            CheckboxImpl(z, toggleableState2, modifierThen, checkboxColors2, stroke, stroke2, gapComposer, i3 | (57344 & i4) | 262144 | (i4 & 458752));
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new CheckboxKt$$ExternalSyntheticLambda2(toggleableState, function0, stroke, stroke2, modifier, z, checkboxColors, i);
        }
    }
}
