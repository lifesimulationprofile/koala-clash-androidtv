package androidx.compose.material3;

import android.graphics.Typeface;
import android.text.Spannable;
import androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda2;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.foundation.contextmenu.ContextMenuColors;
import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.gestures.DraggableKt$NoOpOnDragStarted$1;
import androidx.compose.foundation.gestures.PressGestureScopeImpl;
import androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$2;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.lazy.LazyListIntervalContent$$ExternalSyntheticLambda2;
import androidx.compose.foundation.text.selection.SelectionMagnifierKt;
import androidx.compose.material3.SnackbarHostKt$animatedOpacity$2$1;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda7;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendPointerInputElement;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.android.style.TypefaceSpan;
import androidx.compose.ui.text.font.FontFamilyResolverImpl;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.SystemFontFamily;
import androidx.compose.ui.text.font.TypefaceResult$Immutable;
import androidx.compose.ui.text.platform.AndroidParagraphIntrinsics;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.MenuHostHelper;
import androidx.navigation.compose.NavHostKt$NavHost$28$1;
import coil.RealImageLoader$executeMain$result$1;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AlertDialogKt$$ExternalSyntheticLambda14 implements Function3 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ AlertDialogKt$$ExternalSyntheticLambda14(int i, Object obj, Object obj2) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        Typeface typeface;
        switch (this.$r8$classId) {
            case 0:
                LayoutDirection layoutDirection = (LayoutDirection) this.f$0;
                ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) this.f$1;
                GapComposer gapComposer = (GapComposer) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 17) != 16)) {
                    Stack.CompositionLocalProvider(CompositionLocalsKt.LocalLayoutDirection.defaultProvidedValue$runtime(layoutDirection), composableLambdaImpl, gapComposer, 8);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return Unit.INSTANCE;
            case 1:
                Function1 function1 = (Function1) this.f$0;
                ContextMenuColors contextMenuColors = (ContextMenuColors) this.f$1;
                GapComposer gapComposer2 = (GapComposer) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    Object objRememberedValue = gapComposer2.rememberedValue();
                    if (objRememberedValue == Composer$Companion.Empty) {
                        objRememberedValue = new ContextMenuScope();
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    ContextMenuScope contextMenuScope = (ContextMenuScope) objRememberedValue;
                    contextMenuScope.composables.clear();
                    function1.invoke(contextMenuScope);
                    contextMenuScope.Content$foundation(contextMenuColors, gapComposer2, 0);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return Unit.INSTANCE;
            case 2:
                MenuKt$$ExternalSyntheticLambda0 menuKt$$ExternalSyntheticLambda0 = (MenuKt$$ExternalSyntheticLambda0) this.f$0;
                final MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) this.f$1;
                GapComposer gapComposer3 = (GapComposer) obj2;
                ((Integer) obj3).getClass();
                gapComposer3.startReplaceGroup(-102778667);
                Object objRememberedValue2 = gapComposer3.rememberedValue();
                NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
                if (objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = Stack.createCompositionCoroutineScope(gapComposer3);
                    gapComposer3.updateRememberedValue(objRememberedValue2);
                }
                final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue2;
                Object objRememberedValue3 = gapComposer3.rememberedValue();
                if (objRememberedValue3 == neverEqualPolicy) {
                    objRememberedValue3 = Stack.mutableStateOf$default(null);
                    gapComposer3.updateRememberedValue(objRememberedValue3);
                }
                final MutableState mutableState = (MutableState) objRememberedValue3;
                final MutableState mutableStateRememberUpdatedState = Stack.rememberUpdatedState(menuKt$$ExternalSyntheticLambda0, gapComposer3);
                boolean zChanged = gapComposer3.changed(mutableInteractionSourceImpl);
                Object objRememberedValue4 = gapComposer3.rememberedValue();
                if (zChanged || objRememberedValue4 == neverEqualPolicy) {
                    objRememberedValue4 = new BackHandlerKt$$ExternalSyntheticLambda2(27, mutableState, mutableInteractionSourceImpl);
                    gapComposer3.updateRememberedValue(objRememberedValue4);
                }
                Stack.DisposableEffect(mutableInteractionSourceImpl, (Function1) objRememberedValue4, gapComposer3);
                boolean zChangedInstance = gapComposer3.changedInstance(coroutineScope) | gapComposer3.changed(mutableInteractionSourceImpl) | gapComposer3.changed(mutableStateRememberUpdatedState);
                Object objRememberedValue5 = gapComposer3.rememberedValue();
                if (zChangedInstance || objRememberedValue5 == neverEqualPolicy) {
                    objRememberedValue5 = new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1

                        /* JADX INFO: renamed from: androidx.compose.foundation.text.TextFieldPressGestureFilterKt$tapPressTextFieldModifier$1$2$1$1, reason: invalid class name */
                        /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
                        public final class AnonymousClass1 extends SuspendLambda implements Function3 {
                            public final /* synthetic */ MutableInteractionSourceImpl $interactionSource;
                            public final /* synthetic */ MutableState $pressedInteraction;
                            public final /* synthetic */ CoroutineScope $scope;
                            public /* synthetic */ long J$0;
                            public /* synthetic */ PressGestureScopeImpl L$0;
                            public int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            public AnonymousClass1(CoroutineScope coroutineScope, MutableState mutableState, MutableInteractionSourceImpl mutableInteractionSourceImpl, Continuation continuation) {
                                super(3, continuation);
                                this.$scope = coroutineScope;
                                this.$pressedInteraction = mutableState;
                                this.$interactionSource = mutableInteractionSourceImpl;
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                long j = ((Offset) obj2).packedValue;
                                MutableState mutableState = this.$pressedInteraction;
                                MutableInteractionSourceImpl mutableInteractionSourceImpl = this.$interactionSource;
                                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$scope, mutableState, mutableInteractionSourceImpl, (Continuation) obj3);
                                anonymousClass1.L$0 = (PressGestureScopeImpl) obj;
                                anonymousClass1.J$0 = j;
                                return anonymousClass1.invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                int i = this.label;
                                CoroutineScope coroutineScope = this.$scope;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    PressGestureScopeImpl pressGestureScopeImpl = this.L$0;
                                    JobKt.launch$default(coroutineScope, null, new ScrollableKt$semanticsScrollBy$2(this.$pressedInteraction, this.J$0, this.$interactionSource, (Continuation) null, 2), 3);
                                    this.label = 1;
                                    obj = pressGestureScopeImpl.tryAwaitRelease(this);
                                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                                    if (obj == coroutineSingletons) {
                                        return coroutineSingletons;
                                    }
                                } else {
                                    if (i != 1) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj);
                                }
                                JobKt.launch$default(coroutineScope, null, new SnackbarHostKt$animatedOpacity$2$1(this.$pressedInteraction, ((Boolean) obj).booleanValue(), this.$interactionSource, null), 3);
                                return Unit.INSTANCE;
                            }
                        }

                        @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                        public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
                            AnonymousClass1 anonymousClass1 = new AnonymousClass1(coroutineScope, mutableState, mutableInteractionSourceImpl, null);
                            TooltipKt$$ExternalSyntheticLambda7 tooltipKt$$ExternalSyntheticLambda7 = new TooltipKt$$ExternalSyntheticLambda7(mutableStateRememberUpdatedState, 2);
                            DraggableKt$NoOpOnDragStarted$1 draggableKt$NoOpOnDragStarted$1 = TapGestureDetectorKt.NoPressGesture;
                            Object objCoroutineScope = JobKt.coroutineScope(new RealImageLoader$executeMain$result$1(pointerInputScope, anonymousClass1, tooltipKt$$ExternalSyntheticLambda7, new PressGestureScopeImpl(pointerInputScope), null, 2), continuation);
                            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                            if (objCoroutineScope != coroutineSingletons) {
                                objCoroutineScope = Unit.INSTANCE;
                            }
                            return objCoroutineScope == coroutineSingletons ? objCoroutineScope : Unit.INSTANCE;
                        }
                    };
                    gapComposer3.updateRememberedValue(objRememberedValue5);
                }
                SuspendPointerInputElement suspendPointerInputElement = new SuspendPointerInputElement(mutableInteractionSourceImpl, null, (PointerInputEventHandler) objRememberedValue5, 6);
                gapComposer3.end(false);
                return suspendPointerInputElement;
            case 3:
                Function0 function0 = (Function0) this.f$0;
                Function1 function2 = (Function1) this.f$1;
                GapComposer gapComposer4 = (GapComposer) obj2;
                ((Integer) obj3).getClass();
                gapComposer4.startReplaceGroup(759876635);
                Object objRememberedValue6 = gapComposer4.rememberedValue();
                NeverEqualPolicy neverEqualPolicy2 = Composer$Companion.Empty;
                if (objRememberedValue6 == neverEqualPolicy2) {
                    objRememberedValue6 = Stack.derivedStateOf(function0);
                    gapComposer4.updateRememberedValue(objRememberedValue6);
                }
                State state = (State) objRememberedValue6;
                Object objRememberedValue7 = gapComposer4.rememberedValue();
                if (objRememberedValue7 == neverEqualPolicy2) {
                    objRememberedValue7 = new Animatable(new Offset(((Offset) state.getValue()).packedValue), SelectionMagnifierKt.UnspecifiedSafeOffsetVectorConverter, new Offset(SelectionMagnifierKt.OffsetDisplacementThreshold), 8);
                    gapComposer4.updateRememberedValue(objRememberedValue7);
                }
                Animatable animatable = (Animatable) objRememberedValue7;
                Unit unit = Unit.INSTANCE;
                boolean zChangedInstance2 = gapComposer4.changedInstance(animatable);
                Object objRememberedValue8 = gapComposer4.rememberedValue();
                if (zChangedInstance2 || objRememberedValue8 == neverEqualPolicy2) {
                    objRememberedValue8 = new NavHostKt$NavHost$28$1(state, animatable, (Continuation) null, 17);
                    gapComposer4.updateRememberedValue(objRememberedValue8);
                }
                Stack.LaunchedEffect(gapComposer4, unit, (Function2) objRememberedValue8);
                AnimationState animationState = animatable.internalState;
                boolean zChanged2 = gapComposer4.changed(animationState);
                Object objRememberedValue9 = gapComposer4.rememberedValue();
                if (zChanged2 || objRememberedValue9 == neverEqualPolicy2) {
                    objRememberedValue9 = new ModalBottomSheetKt$$ExternalSyntheticLambda10(animationState, 1);
                    gapComposer4.updateRememberedValue(objRememberedValue9);
                }
                Modifier modifier = (Modifier) function2.invoke((Function0) objRememberedValue9);
                gapComposer4.end(false);
                return modifier;
            default:
                Spannable spannable = (Spannable) this.f$0;
                LazyListIntervalContent$$ExternalSyntheticLambda2 lazyListIntervalContent$$ExternalSyntheticLambda2 = (LazyListIntervalContent$$ExternalSyntheticLambda2) this.f$1;
                SpanStyle spanStyle = (SpanStyle) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                int iIntValue4 = ((Integer) obj3).intValue();
                SystemFontFamily systemFontFamily = spanStyle.fontFamily;
                FontWeight fontWeight = spanStyle.fontWeight;
                if (fontWeight == null) {
                    fontWeight = FontWeight.Normal;
                }
                FontStyle fontStyle = spanStyle.fontStyle;
                int i = fontStyle != null ? fontStyle.value : 0;
                FontSynthesis fontSynthesis = spanStyle.fontSynthesis;
                int i2 = fontSynthesis != null ? fontSynthesis.value : 65535;
                AndroidParagraphIntrinsics androidParagraphIntrinsics = (AndroidParagraphIntrinsics) lazyListIntervalContent$$ExternalSyntheticLambda2.f$0;
                TypefaceResult$Immutable typefaceResult$ImmutableM656resolveDPcqOEQ = ((FontFamilyResolverImpl) androidParagraphIntrinsics.fontFamilyResolver).m656resolveDPcqOEQ(systemFontFamily, fontWeight, i, i2);
                if (typefaceResult$ImmutableM656resolveDPcqOEQ instanceof TypefaceResult$Immutable) {
                    typeface = (Typeface) typefaceResult$ImmutableM656resolveDPcqOEQ.value;
                } else {
                    MenuHostHelper menuHostHelper = new MenuHostHelper(typefaceResult$ImmutableM656resolveDPcqOEQ, androidParagraphIntrinsics.resolvedTypefaces);
                    androidParagraphIntrinsics.resolvedTypefaces = menuHostHelper;
                    typeface = (Typeface) menuHostHelper.mProviderToLifecycleContainers;
                }
                spannable.setSpan(new TypefaceSpan(0, typeface), iIntValue3, iIntValue4, 33);
                return Unit.INSTANCE;
        }
    }
}
