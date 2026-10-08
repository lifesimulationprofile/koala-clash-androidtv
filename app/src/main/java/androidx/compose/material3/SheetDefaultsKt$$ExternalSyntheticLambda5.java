package androidx.compose.material3;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.foundation.text.LongPressTextDragObserverKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.text.input.internal.CoreTextFieldSemanticsModifierNode;
import androidx.compose.foundation.text.selection.SelectionAdjustment$Companion;
import androidx.compose.foundation.text.selection.SelectionMagnifierKt;
import androidx.compose.foundation.text.selection.SelectionManager;
import androidx.compose.foundation.text.selection.SelectionManager_androidKt$$ExternalSyntheticLambda5;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.ComposedModifier;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import coil.compose.ContentPainterNode$$ExternalSyntheticLambda0;
import coil.disk.DiskLruCache$$ExternalSyntheticLambda0;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.coroutines.sync.SemaphoreAndMutexImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SheetDefaultsKt$$ExternalSyntheticLambda5 implements Function3 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ SheetDefaultsKt$$ExternalSyntheticLambda5(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    /* JADX WARN: Code duplicated, block: B:55:0x01be  */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int i = this.$r8$classId;
        boolean z = true;
        int i2 = 14;
        NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
        int i3 = 3;
        int i4 = 0;
        Object obj4 = this.f$0;
        switch (i) {
            case 0:
                String str = (String) obj4;
                TooltipScopeImpl tooltipScopeImpl = (TooltipScopeImpl) obj;
                GapComposer gapComposer = (GapComposer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                if ((iIntValue & 6) == 0) {
                    iIntValue |= (iIntValue & 8) == 0 ? gapComposer.changed(tooltipScopeImpl) : gapComposer.changedInstance(tooltipScopeImpl) ? 4 : 2;
                }
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18)) {
                    TooltipKt.m277PlainTooltipgv3ox5I(tooltipScopeImpl, null, 0.0f, null, 0L, 0L, 0.0f, 0.0f, Thread_jvmKt.rememberComposableLambda(435848468, new SheetDefaultsKt$$ExternalSyntheticLambda0(str), gapComposer), gapComposer, (14 & iIntValue) | 805306368);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return Unit.INSTANCE;
            case 1:
                ((LongPressTextDragObserverKt$$ExternalSyntheticLambda0) obj4).f$0.mo176onStart3MmeM6k(((PointerInputChange) obj2).position, SelectionAdjustment$Companion.None);
                Unit unit = Unit.INSTANCE;
                return Unit.INSTANCE;
            case 2:
                CoreTextFieldSemanticsModifierNode coreTextFieldSemanticsModifierNode = (CoreTextFieldSemanticsModifierNode) obj4;
                int iIntValue2 = ((Integer) obj).intValue();
                int iIntValue3 = ((Integer) obj2).intValue();
                boolean zBooleanValue = ((Boolean) obj3).booleanValue();
                if (!zBooleanValue) {
                    iIntValue2 = coreTextFieldSemanticsModifierNode.offsetMapping.transformedToOriginal(iIntValue2);
                }
                if (!zBooleanValue) {
                    iIntValue3 = coreTextFieldSemanticsModifierNode.offsetMapping.transformedToOriginal(iIntValue3);
                }
                if (coreTextFieldSemanticsModifierNode.enabled) {
                    long j = coreTextFieldSemanticsModifierNode.value.selection;
                    int i5 = TextRange.$r8$clinit;
                    if (iIntValue2 == ((int) (j >> 32)) && iIntValue3 == ((int) (j & 4294967295L))) {
                        z = false;
                    } else {
                        int iMin = Math.min(iIntValue2, iIntValue3);
                        HandleState handleState = HandleState.None;
                        if (iMin < 0 || Math.max(iIntValue2, iIntValue3) > coreTextFieldSemanticsModifierNode.value.annotatedString.text.length()) {
                            TextFieldSelectionManager textFieldSelectionManager = coreTextFieldSemanticsModifierNode.manager;
                            textFieldSelectionManager.updateFloatingToolbar(false);
                            textFieldSelectionManager.setHandleState(handleState);
                            z = false;
                        } else {
                            if (zBooleanValue || iIntValue2 == iIntValue3) {
                                TextFieldSelectionManager textFieldSelectionManager2 = coreTextFieldSemanticsModifierNode.manager;
                                textFieldSelectionManager2.updateFloatingToolbar(false);
                                textFieldSelectionManager2.setHandleState(handleState);
                            } else {
                                coreTextFieldSemanticsModifierNode.manager.enterSelectionMode$foundation(true);
                            }
                            coreTextFieldSemanticsModifierNode.state.onValueChange.invoke(new TextFieldValue(coreTextFieldSemanticsModifierNode.value.annotatedString, ParagraphKt.TextRange(iIntValue2, iIntValue3), (TextRange) null));
                        }
                    }
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 3:
                SelectionManager selectionManager = (SelectionManager) obj4;
                Modifier modifier = (Modifier) obj;
                GapComposer gapComposer2 = (GapComposer) obj2;
                ((Integer) obj3).getClass();
                gapComposer2.startReplaceGroup(-1914520728);
                Density density = (Density) gapComposer2.consume(CompositionLocalsKt.LocalDensity);
                Object objRememberedValue = gapComposer2.rememberedValue();
                if (objRememberedValue == neverEqualPolicy) {
                    objRememberedValue = Stack.mutableStateOf$default(new IntSize(0L));
                    gapComposer2.updateRememberedValue(objRememberedValue);
                }
                MutableState mutableState = (MutableState) objRememberedValue;
                boolean zChangedInstance = gapComposer2.changedInstance(selectionManager);
                Object objRememberedValue2 = gapComposer2.rememberedValue();
                if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = new Recomposer$$ExternalSyntheticLambda6(12, selectionManager, mutableState);
                    gapComposer2.updateRememberedValue(objRememberedValue2);
                }
                Function0 function0 = (Function0) objRememberedValue2;
                boolean zChanged = gapComposer2.changed(density);
                Object objRememberedValue3 = gapComposer2.rememberedValue();
                if (zChanged || objRememberedValue3 == neverEqualPolicy) {
                    objRememberedValue3 = new SelectionManager_androidKt$$ExternalSyntheticLambda5(density, mutableState, i4);
                    gapComposer2.updateRememberedValue(objRememberedValue3);
                }
                AnimationVector2D animationVector2D = SelectionMagnifierKt.UnspecifiedAnimationVector2D;
                Modifier modifierThen = modifier.then(new ComposedModifier(new AlertDialogKt$$ExternalSyntheticLambda14(i3, function0, (Function1) objRememberedValue3)));
                gapComposer2.end(false);
                return modifierThen;
            case 4:
                TextFieldSelectionManager textFieldSelectionManager3 = (TextFieldSelectionManager) obj4;
                Modifier modifier2 = (Modifier) obj;
                GapComposer gapComposer3 = (GapComposer) obj2;
                ((Integer) obj3).getClass();
                gapComposer3.startReplaceGroup(1980580247);
                Density density2 = (Density) gapComposer3.consume(CompositionLocalsKt.LocalDensity);
                Object objRememberedValue4 = gapComposer3.rememberedValue();
                if (objRememberedValue4 == neverEqualPolicy) {
                    objRememberedValue4 = Stack.mutableStateOf$default(new IntSize(0L));
                    gapComposer3.updateRememberedValue(objRememberedValue4);
                }
                MutableState mutableState2 = (MutableState) objRememberedValue4;
                boolean zChangedInstance2 = gapComposer3.changedInstance(textFieldSelectionManager3);
                Object objRememberedValue5 = gapComposer3.rememberedValue();
                if (zChangedInstance2 || objRememberedValue5 == neverEqualPolicy) {
                    objRememberedValue5 = new Recomposer$$ExternalSyntheticLambda6(i2, textFieldSelectionManager3, mutableState2);
                    gapComposer3.updateRememberedValue(objRememberedValue5);
                }
                Function0 function1 = (Function0) objRememberedValue5;
                boolean zChanged2 = gapComposer3.changed(density2);
                Object objRememberedValue6 = gapComposer3.rememberedValue();
                if (zChanged2 || objRememberedValue6 == neverEqualPolicy) {
                    objRememberedValue6 = new SelectionManager_androidKt$$ExternalSyntheticLambda5(density2, mutableState2, i3);
                    gapComposer3.updateRememberedValue(objRememberedValue6);
                }
                AnimationVector2D animationVector2D2 = SelectionMagnifierKt.UnspecifiedAnimationVector2D;
                Modifier modifierThen2 = modifier2.then(new ComposedModifier(new AlertDialogKt$$ExternalSyntheticLambda14(i3, function1, (Function1) objRememberedValue6)));
                gapComposer3.end(false);
                return modifierThen2;
            case 5:
                MeasureScope measureScope = (MeasureScope) obj;
                Measurable measurable = (Measurable) obj2;
                Constraints constraints = (Constraints) obj3;
                float f = ((Dp) ((Function0) obj4).invoke()).value;
                Placeable placeableMo517measureBRTryo0 = measurable.mo517measureBRTryo0(Constraints.m676copyZbe2FdA$default(constraints.value, 0, 0, ConstraintsKt.m691constrainHeightK40F9xA(Dp.m704equalsimpl0(f, Float.NaN) ? 0 : measureScope.mo86roundToPx0680j_4(f), constraints.value), 0, 11));
                return measureScope.layout(placeableMo517measureBRTryo0.width, placeableMo517measureBRTryo0.height, EmptyMap.INSTANCE, new ContentPainterNode$$ExternalSyntheticLambda0(placeableMo517measureBRTryo0, 11));
            case 6:
                ((DiskLruCache$$ExternalSyntheticLambda0) obj4).invoke((Throwable) obj);
                return Unit.INSTANCE;
            case 7:
                MutexImpl mutexImpl = (MutexImpl) obj4;
                MutexImpl.owner$volatile$FU.set(mutexImpl, null);
                mutexImpl.unlock(null);
                return Unit.INSTANCE;
            default:
                ((SemaphoreAndMutexImpl) obj4).release();
                return Unit.INSTANCE;
        }
    }

    public /* synthetic */ SheetDefaultsKt$$ExternalSyntheticLambda5(MutexImpl mutexImpl, MutexImpl.CancellableContinuationWithOwner cancellableContinuationWithOwner) {
        this.$r8$classId = 7;
        this.f$0 = mutexImpl;
    }
}
