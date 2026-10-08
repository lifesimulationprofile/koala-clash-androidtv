package androidx.compose.material3;

import androidx.activity.compose.ActivityResultRegistryKt$$ExternalSyntheticLambda1;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.contextmenu.ContextMenuColors;
import androidx.compose.foundation.contextmenu.ContextMenuPopupPositionProviderKt;
import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.input.internal.CursorAnimationState;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.LazyWindowInfo;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SnackbarHostKt$$ExternalSyntheticLambda1 implements Function3 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;

    public /* synthetic */ SnackbarHostKt$$ExternalSyntheticLambda1(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$3 = obj4;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        Object obj4;
        Object snackbarHostKt$animatedOpacity$2$1;
        Object objDrawWithContent;
        switch (this.$r8$classId) {
            case 0:
                SnackbarHostState.SnackbarDataImpl snackbarDataImpl = (SnackbarHostState.SnackbarDataImpl) this.f$0;
                SnackbarHostState.SnackbarDataImpl snackbarDataImpl2 = (SnackbarHostState.SnackbarDataImpl) this.f$1;
                Object obj5 = (FadeInFadeOutState) this.f$2;
                String str = (String) this.f$3;
                Function2 function2 = (Function2) obj;
                GapComposer gapComposer = (GapComposer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                if ((iIntValue & 6) == 0) {
                    iIntValue |= gapComposer.changedInstance(function2) ? 4 : 2;
                }
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 19) != 18)) {
                    boolean zAreEqual = Intrinsics.areEqual(snackbarDataImpl, snackbarDataImpl2);
                    FiniteAnimationSpec finiteAnimationSpecValue = ScrimKt.value(5, gapComposer);
                    boolean zChanged = gapComposer.changed(snackbarDataImpl) | gapComposer.changedInstance(obj5);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    Object obj6 = Composer$Companion.Empty;
                    if (zChanged || objRememberedValue == obj6) {
                        objRememberedValue = new Recomposer$$ExternalSyntheticLambda6(16, snackbarDataImpl, obj5);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    Function0 function0 = (Function0) objRememberedValue;
                    Object objRememberedValue2 = gapComposer.rememberedValue();
                    if (objRememberedValue2 == obj6) {
                        objRememberedValue2 = ArcSplineKt.Animatable$default(!zAreEqual ? 1.0f : 0.0f);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    Animatable animatable = (Animatable) objRememberedValue2;
                    Boolean boolValueOf = Boolean.valueOf(zAreEqual);
                    boolean zChangedInstance = gapComposer.changedInstance(animatable) | gapComposer.changed(zAreEqual) | gapComposer.changedInstance(finiteAnimationSpecValue) | gapComposer.changed(function0);
                    Object objRememberedValue3 = gapComposer.rememberedValue();
                    if (zChangedInstance || objRememberedValue3 == obj6) {
                        obj4 = obj6;
                        snackbarHostKt$animatedOpacity$2$1 = new SnackbarHostKt$animatedOpacity$2$1(animatable, zAreEqual, finiteAnimationSpecValue, function0, null);
                        gapComposer.updateRememberedValue(snackbarHostKt$animatedOpacity$2$1);
                    } else {
                        snackbarHostKt$animatedOpacity$2$1 = objRememberedValue3;
                        obj4 = obj6;
                    }
                    Stack.LaunchedEffect(gapComposer, boolValueOf, (Function2) snackbarHostKt$animatedOpacity$2$1);
                    AnimationState animationState = animatable.internalState;
                    Object objValue = ScrimKt.value(2, gapComposer);
                    Object objRememberedValue4 = gapComposer.rememberedValue();
                    if (objRememberedValue4 == obj4) {
                        objRememberedValue4 = ArcSplineKt.Animatable$default(!zAreEqual ? 1.0f : 0.8f);
                        gapComposer.updateRememberedValue(objRememberedValue4);
                    }
                    Animatable animatable2 = (Animatable) objRememberedValue4;
                    Boolean boolValueOf2 = Boolean.valueOf(zAreEqual);
                    boolean zChangedInstance2 = gapComposer.changedInstance(animatable2) | gapComposer.changed(zAreEqual) | gapComposer.changedInstance(objValue);
                    Object objRememberedValue5 = gapComposer.rememberedValue();
                    if (zChangedInstance2 || objRememberedValue5 == obj4) {
                        objRememberedValue5 = new SnackbarHostKt$animatedScale$1$1(animatable2, zAreEqual, objValue, (Continuation) null, 0);
                        gapComposer.updateRememberedValue(objRememberedValue5);
                    }
                    Stack.LaunchedEffect(gapComposer, boolValueOf2, (Function2) objRememberedValue5);
                    AnimationState animationState2 = animatable2.internalState;
                    Modifier modifierM417graphicsLayer_6ThJ44$default = BrushKt.m417graphicsLayer_6ThJ44$default(Modifier.Companion.$$INSTANCE, ((Number) animationState2.value$delegate.getValue()).floatValue(), ((Number) animationState2.value$delegate.getValue()).floatValue(), ((Number) animationState.value$delegate.getValue()).floatValue(), 0.0f, null, false, 524280);
                    boolean zChanged2 = gapComposer.changed(zAreEqual) | gapComposer.changed(snackbarDataImpl) | gapComposer.changed(str);
                    Object objRememberedValue6 = gapComposer.rememberedValue();
                    if (zChanged2 || objRememberedValue6 == obj4) {
                        objRememberedValue6 = new SnackbarHostKt$$ExternalSyntheticLambda5(zAreEqual, str, snackbarDataImpl);
                        gapComposer.updateRememberedValue(objRememberedValue6);
                    }
                    Modifier modifierSemantics = SemanticsModifierKt.semantics(modifierM417graphicsLayer_6ThJ44$default, false, (Function1) objRememberedValue6);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                    long j = gapComposer.compositeKeyHashCode;
                    int i = (int) (j ^ (j >>> 32));
                    PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifierSemantics);
                    ComposeUiNode.Companion.getClass();
                    Function0 function1 = ComposeUiNode.Companion.Constructor;
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(function1);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m295setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m295setimpl(gapComposer, Integer.valueOf(i), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m294reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                    Stack.m295setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                    function2.invoke(gapComposer, Integer.valueOf(iIntValue & 14));
                    gapComposer.end(true);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return Unit.INSTANCE;
            case 1:
                Function2 function3 = (Function2) this.f$0;
                ContextMenuScope contextMenuScope = (ContextMenuScope) this.f$1;
                Function3 function4 = (Function3) this.f$2;
                Function0 function5 = (Function0) this.f$3;
                ContextMenuColors contextMenuColors = (ContextMenuColors) obj;
                GapComposer gapComposer2 = (GapComposer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                if ((iIntValue2 & 6) == 0) {
                    iIntValue2 |= gapComposer2.changed(contextMenuColors) ? 4 : 2;
                }
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 19) != 18)) {
                    String str2 = (String) function3.invoke(gapComposer2, 0);
                    if (StringsKt.isBlank(str2)) {
                        InlineClassHelperKt.throwIllegalStateException("Label must not be blank");
                    }
                    contextMenuScope.getClass();
                    ContextMenuPopupPositionProviderKt.f1lambda$1571120048.invoke(str2, Boolean.TRUE, contextMenuColors, function4, function5, gapComposer2, Integer.valueOf((iIntValue2 << 9) & 7168));
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return Unit.INSTANCE;
            default:
                SolidColor solidColor = (SolidColor) this.f$0;
                LegacyTextFieldState legacyTextFieldState = (LegacyTextFieldState) this.f$1;
                TextFieldValue textFieldValue = (TextFieldValue) this.f$2;
                long j2 = textFieldValue.selection;
                OffsetMapping offsetMapping = (OffsetMapping) this.f$3;
                Modifier modifier = (Modifier) obj;
                GapComposer gapComposer3 = (GapComposer) obj2;
                ((Integer) obj3).getClass();
                gapComposer3.startReplaceGroup(-84507373);
                boolean zBooleanValue = ((Boolean) gapComposer3.consume(CompositionLocalsKt.LocalCursorBlinkEnabled)).booleanValue();
                boolean zChanged3 = gapComposer3.changed(zBooleanValue);
                Object objRememberedValue7 = gapComposer3.rememberedValue();
                NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
                if (zChanged3 || objRememberedValue7 == neverEqualPolicy) {
                    objRememberedValue7 = new CursorAnimationState(zBooleanValue);
                    gapComposer3.updateRememberedValue(objRememberedValue7);
                }
                CursorAnimationState cursorAnimationState = (CursorAnimationState) objRememberedValue7;
                boolean z = solidColor.value != 16;
                if (((Boolean) ((LazyWindowInfo) ((WindowInfo) gapComposer3.consume(CompositionLocalsKt.LocalWindowInfo))).isWindowFocused$delegate.getValue()).booleanValue() && legacyTextFieldState.getHasFocus() && TextRange.m641getCollapsedimpl(j2) && z) {
                    gapComposer3.startReplaceGroup(-707487962);
                    AnnotatedString annotatedString = textFieldValue.annotatedString;
                    TextRange textRange = new TextRange(j2);
                    boolean zChangedInstance3 = gapComposer3.changedInstance(cursorAnimationState);
                    Object objRememberedValue8 = gapComposer3.rememberedValue();
                    if (zChangedInstance3 || objRememberedValue8 == neverEqualPolicy) {
                        objRememberedValue8 = new ThumbNode.AnonymousClass1(cursorAnimationState, (Continuation) null, 8);
                        gapComposer3.updateRememberedValue(objRememberedValue8);
                    }
                    Stack.LaunchedEffect(annotatedString, textRange, (Function2) objRememberedValue8, gapComposer3);
                    boolean zChangedInstance4 = gapComposer3.changedInstance(cursorAnimationState) | gapComposer3.changedInstance(offsetMapping) | gapComposer3.changed(textFieldValue) | gapComposer3.changedInstance(legacyTextFieldState) | gapComposer3.changed(solidColor);
                    Object objRememberedValue9 = gapComposer3.rememberedValue();
                    if (zChangedInstance4 || objRememberedValue9 == neverEqualPolicy) {
                        objRememberedValue9 = new ActivityResultRegistryKt$$ExternalSyntheticLambda1(cursorAnimationState, offsetMapping, textFieldValue, legacyTextFieldState, solidColor, 2);
                        gapComposer3.updateRememberedValue(objRememberedValue9);
                    }
                    objDrawWithContent = ClipKt.drawWithContent(modifier, (Function1) objRememberedValue9);
                    gapComposer3.end(false);
                } else {
                    gapComposer3.startReplaceGroup(-705473241);
                    gapComposer3.end(false);
                    objDrawWithContent = Modifier.Companion.$$INSTANCE;
                }
                gapComposer3.end(false);
                return objDrawWithContent;
        }
    }
}
