package androidx.compose.foundation.text.selection;

import android.graphics.Bitmap;
import androidx.activity.ImmLeaksCleaner$$ExternalSyntheticLambda0;
import androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda2;
import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.Magnifier_androidKt;
import androidx.compose.foundation.gestures.DragGestureDetectorKt;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.layout.FlowRowOverflow;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.SizeElement;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuModifierKt;
import androidx.compose.foundation.text.modifiers.SelectionController$$ExternalSyntheticLambda0;
import androidx.compose.material3.ScrimKt$Scrim$dismissModifier$1$1;
import androidx.compose.material3.SheetDefaultsKt$$ExternalSyntheticLambda5;
import androidx.compose.material3.SnackbarHostKt$$ExternalSyntheticLambda0;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda7;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAbsoluteAlignment;
import androidx.compose.ui.ComposedModifier;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidImageBitmap;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.input.key.Key_androidKt;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendPointerInputElement;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AndroidParagraph;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.ParagraphInfo;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda1;
import androidx.room.RoomOpenHelper;
import coil.compose.AsyncImageKt$$ExternalSyntheticLambda1;
import coil.network.HttpException;
import com.github.kr328.clash.compose.home.HomeScreenKt$$ExternalSyntheticLambda5;
import com.github.kr328.clash.compose.proxy.ProxySelectorSheetKt$$ExternalSyntheticLambda3;
import com.github.kr328.clash.compose.settings.AccessControlScreenKt$$ExternalSyntheticLambda2;
import com.github.kr328.clash.compose.util.TvGlassTabRowKt$$ExternalSyntheticLambda2;
import dev.chrisbanes.haze.BlurEffectKt$$ExternalSyntheticLambda1;
import dev.chrisbanes.haze.RenderScriptBlurEffect$updateSurface$2$4;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobSupport$children$1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class SimpleLayoutKt {
    public static AndroidCanvas canvas;
    public static CanvasDrawScope canvasDrawScope;
    public static AndroidImageBitmap imageBitmap;
    public static final Rect invertedInfiniteRect = new Rect(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);

    public static final void HandlePopup(OffsetProvider offsetProvider, Alignment alignment, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        int i2;
        gapComposer.startRestartGroup(-1090171650);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? gapComposer.changed(offsetProvider) : gapComposer.changedInstance(offsetProvider) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(alignment) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl) ? 256 : 128;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            boolean z = ((i2 & 14) == 4 || ((i2 & 8) != 0 && gapComposer.changed(offsetProvider))) | ((i2 & 112) == 32);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (z || objRememberedValue == Composer$Companion.Empty) {
                objRememberedValue = new HandlePositionProvider(alignment, offsetProvider);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            AndroidPopup_androidKt.Popup((HandlePositionProvider) objRememberedValue, null, new PopupProperties(1, false, false), composableLambdaImpl, gapComposer, ((i2 << 3) & 7168) | 384, 2);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new SnackbarHostKt$$ExternalSyntheticLambda0(offsetProvider, alignment, composableLambdaImpl, i, 7);
        }
    }

    public static final void SelectionContainer(Modifier modifier, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        ComposableLambdaImpl composableLambdaImpl2;
        GapComposer gapComposer2;
        gapComposer.startRestartGroup(1949207773);
        int i2 = i | 6;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.mutableStateOf$default(null);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            Selection selection = (Selection) mutableState.getValue();
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new TooltipKt$$ExternalSyntheticLambda7(mutableState, 6);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            composableLambdaImpl2 = composableLambdaImpl;
            gapComposer2 = gapComposer;
            SelectionContainer(companion, selection, (Function1) objRememberedValue2, composableLambdaImpl2, gapComposer2, 3462);
            modifier = companion;
        } else {
            composableLambdaImpl2 = composableLambdaImpl;
            gapComposer2 = gapComposer;
            gapComposer2.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new SimpleLayoutKt$$ExternalSyntheticLambda0(modifier, composableLambdaImpl2, i, 1);
        }
    }

    /* JADX WARN: Code duplicated, block: B:73:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d0  */
    /* JADX INFO: renamed from: SelectionHandle-wLIcFTc, reason: not valid java name */
    public static final void m223SelectionHandlewLIcFTc(final OffsetProvider offsetProvider, final boolean z, final int i, final boolean z2, long j, final float f, final SuspendPointerInputElement suspendPointerInputElement, GapComposer gapComposer, final int i2) {
        int i3;
        final long j2;
        int i4;
        long j3;
        final boolean z3;
        gapComposer.startRestartGroup(-466280168);
        if ((i2 & 6) == 0) {
            i3 = ((i2 & 8) == 0 ? gapComposer.changed(offsetProvider) : gapComposer.changedInstance(offsetProvider) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= gapComposer.changed(z) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= gapComposer.changed(CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i)) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= gapComposer.changed(z2) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= 8192;
        }
        if ((1572864 & i2) == 0) {
            i3 |= gapComposer.changed(suspendPointerInputElement) ? 1048576 : 524288;
        }
        if (gapComposer.shouldExecute(i3 & 1, (533651 & i3) != 533650)) {
            gapComposer.startDefaults();
            if ((i2 & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                i4 = i3 & (-57345);
                j3 = 9205357640488583168L;
            } else {
                gapComposer.skipToGroupEnd();
                i4 = i3 & (-57345);
                j3 = j;
            }
            gapComposer.endDefaults();
            if (z) {
                float f2 = SelectionHandlesKt.HandleWidth;
                if ((i != 1 || z2) && !(i == 2 && z2)) {
                    z3 = false;
                } else {
                    z3 = true;
                }
            } else {
                float f3 = SelectionHandlesKt.HandleWidth;
                if ((i == 1 && !z2) || (i == 2 && z2)) {
                    z3 = false;
                } else {
                    z3 = true;
                }
            }
            BiasAbsoluteAlignment biasAbsoluteAlignment = z3 ? AbsoluteAlignment.TopRight : AbsoluteAlignment.TopLeft;
            int i5 = i4 & 14;
            boolean zChanged = (i5 == 4 || ((i4 & 8) != 0 && gapComposer.changedInstance(offsetProvider))) | ((i4 & 112) == 32) | gapComposer.changed(z3);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue == Composer$Companion.Empty) {
                objRememberedValue = new Function1() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        SemanticsPropertyReceiver semanticsPropertyReceiver = (SemanticsPropertyReceiver) obj;
                        long jMo169provideF1C5BW0 = offsetProvider.mo169provideF1C5BW0();
                        semanticsPropertyReceiver.set(SelectionHandlesKt.SelectionHandleInfoKey, new SelectionHandleInfo(z ? Handle.SelectionStart : Handle.SelectionEnd, jMo169provideF1C5BW0, z3 ? 1 : 3, (9223372034707292159L & jMo169provideF1C5BW0) != 9205357640488583168L));
                        return Unit.INSTANCE;
                    }
                };
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            final Modifier modifierSemantics = SemanticsModifierKt.semantics(suspendPointerInputElement, false, (Function1) objRememberedValue);
            final ViewConfiguration viewConfiguration = (ViewConfiguration) gapComposer.consume(CompositionLocalsKt.LocalViewConfiguration);
            final boolean z4 = z3;
            j2 = j3;
            HandlePopup(offsetProvider, biasAbsoluteAlignment, Thread_jvmKt.rememberComposableLambda(1365123137, new Function2() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    GapComposer gapComposer2 = (GapComposer) obj;
                    int iIntValue = ((Integer) obj2).intValue();
                    if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                        ProvidedValue providedValueDefaultProvidedValue$runtime = CompositionLocalsKt.LocalViewConfiguration.defaultProvidedValue$runtime(viewConfiguration);
                        final long j4 = j2;
                        final boolean z5 = z4;
                        final Modifier modifier = modifierSemantics;
                        final OffsetProvider offsetProvider2 = offsetProvider;
                        Stack.CompositionLocalProvider(providedValueDefaultProvidedValue$runtime, Thread_jvmKt.rememberComposableLambda(1260045569, new Function2() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj3, Object obj4) {
                                GapComposer gapComposer3 = (GapComposer) obj3;
                                int iIntValue2 = ((Integer) obj4).intValue();
                                if (gapComposer3.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                                    long j5 = j4;
                                    boolean z6 = z5;
                                    Modifier modifier2 = modifier;
                                    final OffsetProvider offsetProvider3 = offsetProvider2;
                                    NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
                                    if (j5 != 9205357640488583168L) {
                                        gapComposer3.startReplaceGroup(3458246);
                                        FlowRowOverflow flowRowOverflow = z6 ? OffsetKt.f3Right : OffsetKt.f2Left;
                                        Modifier modifierThen = modifier2.then(new SizeElement(DpSize.m711getWidthD9Ej5fM(j5), (2 & 2) != 0 ? Float.NaN : DpSize.m710getHeightD9Ej5fM(j5), (2 & 4) != 0 ? Float.NaN : 0.0f, (2 & 8) != 0 ? Float.NaN : 0.0f, false));
                                        RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(flowRowOverflow, Alignment.Companion.Top, gapComposer3, 0);
                                        long j6 = gapComposer3.compositeKeyHashCode;
                                        int i6 = (int) (j6 ^ (j6 >>> 32));
                                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer3.currentCompositionLocalScope();
                                        Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer3, modifierThen);
                                        ComposeUiNode.Companion.getClass();
                                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                                        gapComposer3.startReusableNode();
                                        if (gapComposer3.inserting) {
                                            gapComposer3.createNode(layoutNode$Companion$Constructor$1);
                                        } else {
                                            gapComposer3.useNode();
                                        }
                                        Stack.m295setimpl(gapComposer3, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                                        Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                                        Stack.m295setimpl(gapComposer3, Integer.valueOf(i6), ComposeUiNode.Companion.SetCompositeKeyHash);
                                        Stack.m294reconcileimpl(gapComposer3, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                                        Stack.m295setimpl(gapComposer3, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                                        boolean zChangedInstance = gapComposer3.changedInstance(offsetProvider3);
                                        Object objRememberedValue2 = gapComposer3.rememberedValue();
                                        if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                                            final int i7 = 0;
                                            objRememberedValue2 = new Function0() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda2
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Object invoke() {
                                                    switch (i7) {
                                                        case 0:
                                                            return Boolean.valueOf((offsetProvider3.mo169provideF1C5BW0() & 9223372034707292159L) != 9205357640488583168L);
                                                        default:
                                                            return Boolean.valueOf((offsetProvider3.mo169provideF1C5BW0() & 9223372034707292159L) != 9205357640488583168L);
                                                    }
                                                }
                                            };
                                            gapComposer3.updateRememberedValue(objRememberedValue2);
                                        }
                                        SimpleLayoutKt.SelectionHandleIcon(6, gapComposer3, Modifier.Companion.$$INSTANCE, (Function0) objRememberedValue2, z6);
                                        gapComposer3.end(true);
                                        gapComposer3.end(false);
                                    } else {
                                        gapComposer3.startReplaceGroup(4389176);
                                        boolean zChangedInstance2 = gapComposer3.changedInstance(offsetProvider3);
                                        Object objRememberedValue3 = gapComposer3.rememberedValue();
                                        if (zChangedInstance2 || objRememberedValue3 == neverEqualPolicy) {
                                            final int i8 = 1;
                                            objRememberedValue3 = new Function0() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda2
                                                @Override // kotlin.jvm.functions.Function0
                                                public final Object invoke() {
                                                    switch (i8) {
                                                        case 0:
                                                            return Boolean.valueOf((offsetProvider3.mo169provideF1C5BW0() & 9223372034707292159L) != 9205357640488583168L);
                                                        default:
                                                            return Boolean.valueOf((offsetProvider3.mo169provideF1C5BW0() & 9223372034707292159L) != 9205357640488583168L);
                                                    }
                                                }
                                            };
                                            gapComposer3.updateRememberedValue(objRememberedValue3);
                                        }
                                        SimpleLayoutKt.SelectionHandleIcon(0, gapComposer3, modifier2, (Function0) objRememberedValue3, z6);
                                        gapComposer3.end(false);
                                    }
                                } else {
                                    gapComposer3.skipToGroupEnd();
                                }
                                return Unit.INSTANCE;
                            }
                        }, gapComposer2), gapComposer2, 56);
                    } else {
                        gapComposer2.skipToGroupEnd();
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, i5 | 384);
        } else {
            gapComposer.skipToGroupEnd();
            j2 = j;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            final long j4 = j2;
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    SimpleLayoutKt.m223SelectionHandlewLIcFTc(offsetProvider, z, i, z2, j4, f, suspendPointerInputElement, (GapComposer) obj, Stack.updateChangedFlags(i2 | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void SelectionHandleIcon(int i, GapComposer gapComposer, Modifier modifier, final Function0 function0, final boolean z) {
        int i2;
        gapComposer.startRestartGroup(2111672474);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        int i3 = i2 | (gapComposer.changedInstance(function0) ? 32 : 16) | (gapComposer.changed(z) ? 256 : 128);
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
            OffsetKt.Spacer(gapComposer, SizeKt.m141sizeVpY3zN4(modifier, SelectionHandlesKt.HandleWidth, SelectionHandlesKt.HandleHeight).then(new ComposedModifier(new Function3() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Modifier modifier2 = (Modifier) obj;
                    GapComposer gapComposer2 = (GapComposer) obj2;
                    ((Integer) obj3).getClass();
                    gapComposer2.startReplaceGroup(-196777734);
                    final long j = ((TextSelectionColors) gapComposer2.consume(TextSelectionColorsKt.LocalTextSelectionColors)).handleColor;
                    boolean zChanged = gapComposer2.changed(j);
                    final Function0 function1 = function0;
                    boolean zChanged2 = zChanged | gapComposer2.changed(function1);
                    final boolean z2 = z;
                    boolean zChanged3 = zChanged2 | gapComposer2.changed(z2);
                    Object objRememberedValue = gapComposer2.rememberedValue();
                    if (zChanged3 || objRememberedValue == Composer$Companion.Empty) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj4) {
                                CacheDrawScope cacheDrawScope = (CacheDrawScope) obj4;
                                return cacheDrawScope.onDrawWithContent(new AccessControlScreenKt$$ExternalSyntheticLambda2(function1, z2, SimpleLayoutKt.createHandleImage(cacheDrawScope, Float.intBitsToFloat((int) (cacheDrawScope.cacheParams.mo337getSizeNHjbRc() >> 32)) / 2.0f), new BlendModeColorFilter(5, j)));
                            }
                        };
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierDrawWithCache = ClipKt.drawWithCache(modifier2, (Function1) objRememberedValue);
                    gapComposer2.end(false);
                    return modifierDrawWithCache;
                }
            })));
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new HomeScreenKt$$ExternalSyntheticLambda5(modifier, function0, z, i, 1);
        }
    }

    public static final void SimpleLayout(Modifier modifier, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        gapComposer.startRestartGroup(-1854833411);
        int i2 = (gapComposer.changed(modifier) ? 4 : 2) | i;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            Object objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == Composer$Companion.Empty) {
                objRememberedValue = SimpleLayoutKt$SimpleLayout$1$1.INSTANCE;
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue;
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
            Stack.m295setimpl(gapComposer, measurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m295setimpl(gapComposer, Integer.valueOf(i3), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m294reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m295setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            composableLambdaImpl.invoke((Object) gapComposer, (Object) 6);
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new SimpleLayoutKt$$ExternalSyntheticLambda0(modifier, composableLambdaImpl, i, 0);
        }
    }

    public static final void TextFieldSelectionHandle(final boolean z, int i, final TextFieldSelectionManager textFieldSelectionManager, GapComposer gapComposer, int i2) {
        int i3;
        TextLayoutResultProxy layoutResult;
        gapComposer.startRestartGroup(-1344558920);
        if ((i2 & 6) == 0) {
            i3 = (gapComposer.changed(z) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= gapComposer.changed(CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i)) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= gapComposer.changedInstance(textFieldSelectionManager) ? 256 : 128;
        }
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
            int i4 = i3 & 14;
            boolean zChanged = (i4 == 4) | gapComposer.changed(textFieldSelectionManager);
            Object objRememberedValue = gapComposer.rememberedValue();
            Object obj = Composer$Companion.Empty;
            if (zChanged || objRememberedValue == obj) {
                objRememberedValue = new SelectionManager$handleDragObserver$1(textFieldSelectionManager, z);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            TextDragObserver textDragObserver = (TextDragObserver) objRememberedValue;
            boolean zChangedInstance = gapComposer.changedInstance(textFieldSelectionManager) | (i4 == 4);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == obj) {
                objRememberedValue2 = new OffsetProvider() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt$TextFieldSelectionHandle$1$1
                    @Override // androidx.compose.foundation.text.selection.OffsetProvider
                    /* JADX INFO: renamed from: provide-F1C5BW0 */
                    public final long mo169provideF1C5BW0() {
                        return textFieldSelectionManager.m232getHandlePositiontuRUvjQ$foundation(z);
                    }
                };
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            OffsetProvider offsetProvider = (OffsetProvider) objRememberedValue2;
            boolean zM645getReversedimpl = TextRange.m645getReversedimpl(textFieldSelectionManager.getValue$foundation().selection);
            int i5 = (int) (z ? textFieldSelectionManager.getValue$foundation().selection >> 32 : textFieldSelectionManager.getValue$foundation().selection & 4294967295L);
            LegacyTextFieldState legacyTextFieldState = textFieldSelectionManager.state;
            float lineHeight = (legacyTextFieldState == null || (layoutResult = legacyTextFieldState.getLayoutResult()) == null) ? 0.0f : BasicTextKt.getLineHeight(layoutResult.value, i5);
            boolean zChangedInstance2 = gapComposer.changedInstance(textDragObserver);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue3 == obj) {
                objRememberedValue3 = new SelectionContainerKt$SelectionContainer$5$1$1$1$1$1$1(textDragObserver, 1);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            m223SelectionHandlewLIcFTc(offsetProvider, z, i, zM645getReversedimpl, 0L, lineHeight, new SuspendPointerInputElement(textDragObserver, null, (PointerInputEventHandler) objRememberedValue3, 6), gapComposer, (i3 << 3) & 1008);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ProxySelectorSheetKt$$ExternalSyntheticLambda3(z, i, textFieldSelectionManager, i2);
        }
    }

    public static final Selection access$adjustToBoundaries(SelectionLayout selectionLayout, BoundaryFunction boundaryFunction) {
        boolean z = selectionLayout.getCrossStatus() == 1;
        return new Selection(anchorOnBoundary(selectionLayout.getStartInfo(), z, true, selectionLayout.getStartSlot(), boundaryFunction), anchorOnBoundary(selectionLayout.getEndInfo(), z, false, selectionLayout.getEndSlot(), boundaryFunction), z);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0040 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x004c  */
    /* JADX WARN: Code duplicated, block: B:23:0x0059 A[LOOP:0: B:19:0x004a->B:23:0x0059, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:26:0x0032 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, java.util.Collection, java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x003e -> B:18:0x0041). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    public static final java.lang.Object access$awaitDown(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine r6, kotlin.coroutines.jvm.internal.BaseContinuationImpl r7) {
        /*
            boolean r0 = r7 instanceof androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1 r0 = (androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1 r0 = new androidx.compose.foundation.text.selection.SelectionGesturesKt$awaitDown$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L2f
            if (r1 != r2) goto L27
            androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine r6 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L41
        L27:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L2f:
            kotlin.ResultKt.throwOnFailure(r7)
        L32:
            r0.L$0 = r6
            r0.label = r2
            androidx.compose.ui.input.pointer.PointerEventPass r7 = androidx.compose.ui.input.pointer.PointerEventPass.Main
            java.lang.Object r7 = r6.awaitPointerEvent(r7, r0)
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r7 != r1) goto L41
            return r1
        L41:
            androidx.compose.ui.input.pointer.PointerEvent r7 = (androidx.compose.ui.input.pointer.PointerEvent) r7
            java.lang.Object r1 = r7.changes
            int r3 = r1.size()
            r4 = 0
        L4a:
            if (r4 >= r3) goto L5c
            java.lang.Object r5 = r1.get(r4)
            androidx.compose.ui.input.pointer.PointerInputChange r5 = (androidx.compose.ui.input.pointer.PointerInputChange) r5
            boolean r5 = androidx.compose.ui.input.pointer.PointerId.changedToDown(r5)
            if (r5 != 0) goto L59
            goto L32
        L59:
            int r4 = r4 + 1
            goto L4a
        L5c:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SimpleLayoutKt.access$awaitDown(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine, kotlin.coroutines.jvm.internal.BaseContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c6, code lost:
    
        if (r14 == r5) goto L48;
     */
    /* JADX WARN: Type inference failed for: r10v10, types: [java.lang.Object, java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.Object, java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object access$touchSelectionSubsequentPress(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine r10, androidx.compose.foundation.text.TextDragObserver r11, androidx.compose.ui.input.pointer.PointerEvent r12, int r13, kotlin.coroutines.jvm.internal.BaseContinuationImpl r14) {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SimpleLayoutKt.access$touchSelectionSubsequentPress(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine, androidx.compose.foundation.text.TextDragObserver, androidx.compose.ui.input.pointer.PointerEvent, int, kotlin.coroutines.jvm.internal.BaseContinuationImpl):java.lang.Object");
    }

    public static final Selection.AnchorInfo access$updateSelectionBoundary(final SelectionLayout selectionLayout, final SelectableInfo selectableInfo, Selection.AnchorInfo anchorInfo) {
        final int i = selectionLayout.isStartHandle() ? selectableInfo.rawStartHandleOffset : selectableInfo.rawEndHandleOffset;
        int startSlot = selectionLayout.isStartHandle() ? selectionLayout.getStartSlot() : selectionLayout.getEndSlot();
        int i2 = selectableInfo.slot;
        TextLayoutResult textLayoutResult = selectableInfo.textLayoutResult;
        int i3 = selectableInfo.rawPreviousHandleOffset;
        if (startSlot != i2) {
            return selectableInfo.anchorForOffset(i);
        }
        final Lazy lazy = LazyKt__LazyJVMKt.lazy(3, new TvGlassTabRowKt$$ExternalSyntheticLambda2(i, 3, selectableInfo));
        final int i4 = selectionLayout.isStartHandle() ? selectableInfo.rawEndHandleOffset : selectableInfo.rawStartHandleOffset;
        Lazy lazy2 = LazyKt__LazyJVMKt.lazy(3, new Function0() { // from class: androidx.compose.foundation.text.selection.SelectionAdjustmentKt$$ExternalSyntheticLambda1
            /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, kotlin.Lazy] */
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int iIntValue = ((Number) lazy.getValue()).intValue();
                SelectionLayout selectionLayout2 = selectionLayout;
                boolean zIsStartHandle = selectionLayout2.isStartHandle();
                boolean z = selectionLayout2.getCrossStatus() == 1;
                SelectableInfo selectableInfo2 = selectableInfo;
                TextLayoutResult textLayoutResult2 = selectableInfo2.textLayoutResult;
                int i5 = i;
                long jM638getWordBoundaryjx7JFs = textLayoutResult2.m638getWordBoundaryjx7JFs(i5);
                TextLayoutResult textLayoutResult3 = selectableInfo2.textLayoutResult;
                MultiParagraph multiParagraph = textLayoutResult3.multiParagraph;
                int i6 = TextRange.$r8$clinit;
                int lineStart = (int) (jM638getWordBoundaryjx7JFs >> 32);
                int lineForOffset = multiParagraph.getLineForOffset(lineStart);
                int i7 = multiParagraph.lineCount;
                if (lineForOffset != iIntValue) {
                    lineStart = iIntValue >= i7 ? textLayoutResult3.getLineStart(i7 - 1) : textLayoutResult3.getLineStart(iIntValue);
                }
                int lineEnd = (int) (jM638getWordBoundaryjx7JFs & 4294967295L);
                if (multiParagraph.getLineForOffset(lineEnd) != iIntValue) {
                    lineEnd = iIntValue >= i7 ? multiParagraph.getLineEnd(i7 - 1, false) : multiParagraph.getLineEnd(iIntValue, false);
                }
                int i8 = i4;
                if (lineStart == i8) {
                    return selectableInfo2.anchorForOffset(lineEnd);
                }
                if (lineEnd == i8) {
                    return selectableInfo2.anchorForOffset(lineStart);
                }
                if (!(zIsStartHandle ^ z) ? i5 >= lineStart : i5 > lineEnd) {
                    lineStart = lineEnd;
                }
                return selectableInfo2.anchorForOffset(lineStart);
            }
        });
        if (selectableInfo.selectableId != anchorInfo.selectableId) {
            return (Selection.AnchorInfo) lazy2.getValue();
        }
        if (i == i3) {
            return anchorInfo;
        }
        if (((Number) lazy.getValue()).intValue() != textLayoutResult.multiParagraph.getLineForOffset(i3)) {
            return (Selection.AnchorInfo) lazy2.getValue();
        }
        int i5 = anchorInfo.offset;
        long jM638getWordBoundaryjx7JFs = textLayoutResult.m638getWordBoundaryjx7JFs(i5);
        boolean zIsStartHandle = selectionLayout.isStartHandle();
        if (i3 != -1) {
            if (i != i3) {
                if (!(zIsStartHandle ^ (selectableInfo.getRawCrossStatus() == 1))) {
                }
            }
            return selectableInfo.anchorForOffset(i);
        }
        int i6 = TextRange.$r8$clinit;
        return (i5 == ((int) (jM638getWordBoundaryjx7JFs >> 32)) || i5 == ((int) (jM638getWordBoundaryjx7JFs & 4294967295L))) ? (Selection.AnchorInfo) lazy2.getValue() : selectableInfo.anchorForOffset(i);
    }

    public static final Selection.AnchorInfo anchorOnBoundary(SelectableInfo selectableInfo, boolean z, boolean z2, int i, BoundaryFunction boundaryFunction) {
        long j;
        int i2 = z2 ? selectableInfo.rawStartHandleOffset : selectableInfo.rawEndHandleOffset;
        if (i != selectableInfo.slot) {
            return selectableInfo.anchorForOffset(i2);
        }
        long jMo213getBoundaryfzxv0v0 = boundaryFunction.mo213getBoundaryfzxv0v0(selectableInfo, i2);
        if (z ^ z2) {
            int i3 = TextRange.$r8$clinit;
            j = jMo213getBoundaryfzxv0v0 >> 32;
        } else {
            int i4 = TextRange.$r8$clinit;
            j = 4294967295L & jMo213getBoundaryfzxv0v0;
        }
        return selectableInfo.anchorForOffset((int) j);
    }

    public static final int appendSelectableInfo_Parwq6A$otherDirection(int i, int i2, SelectionLayoutBuilder selectionLayoutBuilder, long j, Selection.AnchorInfo anchorInfo) {
        if (anchorInfo == null) {
            return resolve2dDirection(i, i2);
        }
        int iCompare = selectionLayoutBuilder.selectableIdOrderingComparator.compare(Long.valueOf(anchorInfo.selectableId), Long.valueOf(j));
        if (iCompare < 0) {
            return 1;
        }
        return iCompare > 0 ? 3 : 2;
    }

    public static final Object awaitSelectionGestures(PointerInputScope pointerInputScope, MouseSelectionObserver mouseSelectionObserver, TextDragObserver textDragObserver, Continuation continuation) {
        SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImpl = (SuspendingPointerInputModifierNodeImpl) pointerInputScope;
        suspendingPointerInputModifierNodeImpl.getClass();
        Object objAwaitEachGesture = ScrollableKt.awaitEachGesture(pointerInputScope, new JobSupport$children$1(new RoomOpenHelper(HitTestResultKt.requireLayoutNode(suspendingPointerInputModifierNodeImpl).viewConfiguration), mouseSelectionObserver, textDragObserver, null), continuation);
        return objAwaitEachGesture == CoroutineSingletons.COROUTINE_SUSPENDED ? objAwaitEachGesture : Unit.INSTANCE;
    }

    public static final Selection.AnchorInfo changeOffset(Selection.AnchorInfo anchorInfo, SelectableInfo selectableInfo, int i) {
        return new Selection.AnchorInfo(selectableInfo.textLayoutResult.getBidiRunDirection(i), i, anchorInfo.selectableId);
    }

    /* JADX INFO: renamed from: containsInclusive-Uv8p0NA, reason: not valid java name */
    public static final boolean m224containsInclusiveUv8p0NA(Rect rect, long j) {
        float f = rect.left;
        float f2 = rect.right;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        if (f > fIntBitsToFloat || fIntBitsToFloat > f2) {
            return false;
        }
        float f3 = rect.top;
        float f4 = rect.bottom;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        return f3 <= fIntBitsToFloat2 && fIntBitsToFloat2 <= f4;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0029  */
    public static final AndroidImageBitmap createHandleImage(CacheDrawScope cacheDrawScope, float f) {
        int iCeil = ((int) Math.ceil(f)) * 2;
        AndroidImageBitmap androidImageBitmapM412ImageBitmapx__hDU$default = imageBitmap;
        AndroidCanvas androidCanvasCanvas = canvas;
        CanvasDrawScope canvasDrawScope2 = canvasDrawScope;
        if (androidImageBitmapM412ImageBitmapx__hDU$default == null || androidCanvasCanvas == null) {
            androidImageBitmapM412ImageBitmapx__hDU$default = BrushKt.m412ImageBitmapx__hDU$default(iCeil, iCeil, 1);
            imageBitmap = androidImageBitmapM412ImageBitmapx__hDU$default;
            androidCanvasCanvas = BrushKt.Canvas(androidImageBitmapM412ImageBitmapx__hDU$default);
            canvas = androidCanvasCanvas;
        } else {
            Bitmap bitmap = androidImageBitmapM412ImageBitmapx__hDU$default.bitmap;
            if (iCeil > bitmap.getWidth() || iCeil > bitmap.getHeight()) {
                androidImageBitmapM412ImageBitmapx__hDU$default = BrushKt.m412ImageBitmapx__hDU$default(iCeil, iCeil, 1);
                imageBitmap = androidImageBitmapM412ImageBitmapx__hDU$default;
                androidCanvasCanvas = BrushKt.Canvas(androidImageBitmapM412ImageBitmapx__hDU$default);
                canvas = androidCanvasCanvas;
            }
        }
        AndroidImageBitmap androidImageBitmap = androidImageBitmapM412ImageBitmapx__hDU$default;
        AndroidCanvas androidCanvas = androidCanvasCanvas;
        if (canvasDrawScope2 == null) {
            canvasDrawScope2 = new CanvasDrawScope();
            canvasDrawScope = canvasDrawScope2;
        }
        CanvasDrawScope canvasDrawScope3 = canvasDrawScope2;
        CanvasDrawScope.DrawParams drawParams = canvasDrawScope3.drawParams;
        LayoutDirection layoutDirection = cacheDrawScope.cacheParams.getLayoutDirection();
        Bitmap bitmap2 = androidImageBitmap.bitmap;
        long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(bitmap2.getWidth())) << 32) | (((long) Float.floatToRawIntBits(bitmap2.getHeight())) & 4294967295L);
        Density density = drawParams.density;
        LayoutDirection layoutDirection2 = drawParams.layoutDirection;
        Canvas canvas2 = drawParams.canvas;
        long j = drawParams.size;
        drawParams.density = cacheDrawScope;
        drawParams.layoutDirection = layoutDirection;
        drawParams.canvas = androidCanvas;
        drawParams.size = jFloatToRawIntBits;
        androidCanvas.save();
        Modifier.CC.m315drawRectnJ9OG0$default(canvasDrawScope3, Color.Black, canvasDrawScope3.drawContext.m756getSizeNHjbRc(), 0.0f, 0, 58);
        Modifier.CC.m315drawRectnJ9OG0$default(canvasDrawScope3, BrushKt.Color(4278190080L), (((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L), 0.0f, 0, 120);
        Modifier.CC.m308drawCircleVaOC9Bg$default(canvasDrawScope3, BrushKt.Color(4278190080L), f, (((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L), null, 120);
        androidCanvas.restore();
        drawParams.density = density;
        drawParams.layoutDirection = layoutDirection2;
        drawParams.canvas = canvas2;
        drawParams.size = j;
        return androidImageBitmap;
    }

    /* JADX INFO: renamed from: getMagnifierCenter-JVtK1S4, reason: not valid java name */
    public static final long m225getMagnifierCenterJVtK1S4(SelectionManager selectionManager, long j, Selection.AnchorInfo anchorInfo) {
        LayoutCoordinates layoutCoordinates;
        long jTextRange;
        long j2;
        MultiParagraph multiParagraph;
        int lineForOffset;
        float fCoerceIn;
        MultiParagraph multiParagraph2;
        int lineForOffset2;
        MultiParagraph multiParagraph3;
        int lineForOffset3;
        float lineBottom;
        MultiParagraph multiParagraph4;
        int lineForOffset4;
        MultiWidgetSelectionDelegate anchorSelectable$foundation = selectionManager.getAnchorSelectable$foundation(anchorInfo);
        if (anchorSelectable$foundation == null || (layoutCoordinates = selectionManager.containerLayoutCoordinates) == null) {
            return 9205357640488583168L;
        }
        SelectionController$$ExternalSyntheticLambda0 selectionController$$ExternalSyntheticLambda0 = anchorSelectable$foundation.layoutResultCallback;
        LayoutCoordinates layoutCoordinates2 = anchorSelectable$foundation.getLayoutCoordinates();
        if (layoutCoordinates2 == null) {
            return 9205357640488583168L;
        }
        int i = anchorInfo.offset;
        TextLayoutResult textLayoutResult = (TextLayoutResult) selectionController$$ExternalSyntheticLambda0.invoke();
        if (i > (textLayoutResult == null ? 0 : anchorSelectable$foundation.getLastVisibleOffset(textLayoutResult))) {
            return 9205357640488583168L;
        }
        float fIntBitsToFloat = Float.intBitsToFloat((int) (layoutCoordinates2.mo523localPositionOfR5De75A(layoutCoordinates, ((Offset) selectionManager.currentDragPosition$delegate.getValue()).packedValue) >> 32));
        TextLayoutResult textLayoutResult2 = (TextLayoutResult) selectionController$$ExternalSyntheticLambda0.invoke();
        if (textLayoutResult2 == null) {
            jTextRange = TextRange.Zero;
        } else {
            MultiParagraph multiParagraph5 = textLayoutResult2.multiParagraph;
            int lastVisibleOffset = anchorSelectable$foundation.getLastVisibleOffset(textLayoutResult2);
            if (lastVisibleOffset < 1) {
                jTextRange = TextRange.Zero;
            } else {
                int lineForOffset5 = multiParagraph5.getLineForOffset(RangesKt.coerceIn(i, 0, lastVisibleOffset - 1));
                jTextRange = ParagraphKt.TextRange(textLayoutResult2.getLineStart(lineForOffset5), multiParagraph5.getLineEnd(lineForOffset5, true));
            }
        }
        if (TextRange.m641getCollapsedimpl(jTextRange)) {
            TextLayoutResult textLayoutResult3 = (TextLayoutResult) selectionController$$ExternalSyntheticLambda0.invoke();
            fCoerceIn = (textLayoutResult3 != null && (lineForOffset4 = (multiParagraph4 = textLayoutResult3.multiParagraph).getLineForOffset(i)) < multiParagraph4.lineCount) ? textLayoutResult3.getLineLeft(lineForOffset4) : -1.0f;
            j2 = 4294967295L;
        } else {
            j2 = 4294967295L;
            int i2 = (int) (jTextRange >> 32);
            TextLayoutResult textLayoutResult4 = (TextLayoutResult) selectionController$$ExternalSyntheticLambda0.invoke();
            float lineLeft = (textLayoutResult4 != null && (lineForOffset2 = (multiParagraph2 = textLayoutResult4.multiParagraph).getLineForOffset(i2)) < multiParagraph2.lineCount) ? textLayoutResult4.getLineLeft(lineForOffset2) : -1.0f;
            int i3 = ((int) (jTextRange & 4294967295L)) - 1;
            TextLayoutResult textLayoutResult5 = (TextLayoutResult) selectionController$$ExternalSyntheticLambda0.invoke();
            float lineRight = (textLayoutResult5 != null && (lineForOffset = (multiParagraph = textLayoutResult5.multiParagraph).getLineForOffset(i3)) < multiParagraph.lineCount) ? textLayoutResult5.getLineRight(lineForOffset) : -1.0f;
            fCoerceIn = RangesKt.coerceIn(fIntBitsToFloat, Math.min(lineLeft, lineRight), Math.max(lineLeft, lineRight));
        }
        if (fCoerceIn == -1.0f) {
            return 9205357640488583168L;
        }
        if (!IntSize.m720equalsimpl0(j, 0L) && Math.abs(fIntBitsToFloat - fCoerceIn) > ((int) (j >> 32)) / 2) {
            return 9205357640488583168L;
        }
        TextLayoutResult textLayoutResult6 = (TextLayoutResult) selectionController$$ExternalSyntheticLambda0.invoke();
        if (textLayoutResult6 != null && (lineForOffset3 = (multiParagraph3 = textLayoutResult6.multiParagraph).getLineForOffset(i)) < multiParagraph3.lineCount) {
            float lineTop = multiParagraph3.getLineTop(lineForOffset3);
            lineBottom = ((multiParagraph3.getLineBottom(lineForOffset3) - lineTop) / 2) + lineTop;
        } else {
            lineBottom = -1.0f;
        }
        if (lineBottom == -1.0f) {
            return 9205357640488583168L;
        }
        return layoutCoordinates.mo523localPositionOfR5De75A(layoutCoordinates2, (((long) Float.floatToRawIntBits(fCoerceIn)) << 32) | (((long) Float.floatToRawIntBits(lineBottom)) & j2));
    }

    /* JADX INFO: renamed from: getOffsetForPosition-3MmeM6k, reason: not valid java name */
    public static final int m226getOffsetForPosition3MmeM6k(long j, TextLayoutResult textLayoutResult) {
        int i = (int) (4294967295L & j);
        if (Float.intBitsToFloat(i) <= 0.0f) {
            return 0;
        }
        float fIntBitsToFloat = Float.intBitsToFloat(i);
        MultiParagraph multiParagraph = textLayoutResult.multiParagraph;
        return fIntBitsToFloat >= multiParagraph.height ? textLayoutResult.layoutInput.text.text.length() : multiParagraph.m629getOffsetForPositionk4lQ0M(j);
    }

    public static final long getSelectionHandleCoordinates(TextLayoutResult textLayoutResult, int i, boolean z, boolean z2) {
        MultiParagraph multiParagraph = textLayoutResult.multiParagraph;
        long j = textLayoutResult.size;
        int lineForOffset = multiParagraph.getLineForOffset(i);
        if (lineForOffset >= multiParagraph.lineCount) {
            return 9205357640488583168L;
        }
        boolean z3 = textLayoutResult.getBidiRunDirection(((!z || z2) && (z || !z2)) ? Math.max(i + (-1), 0) : i) == textLayoutResult.getParagraphDirection(i);
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        multiParagraph.requireIndexInRangeInclusiveEnd(i);
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(i == ((AnnotatedString) multiParagraph.intrinsics.url).text.length() ? AppCompatHintHelper.getLastIndex(arrayList) : ParagraphKt.findParagraphByIndex(i, arrayList));
        AndroidParagraph androidParagraph = paragraphInfo.paragraph;
        int localIndex = paragraphInfo.toLocalIndex(i);
        TextLayout textLayout = androidParagraph.layout;
        return (((long) Float.floatToRawIntBits(RangesKt.coerceIn(z3 ? textLayout.getPrimaryHorizontal(localIndex, false) : textLayout.getSecondaryHorizontal(localIndex, false), 0.0f, (int) (j >> 32)))) << 32) | (((long) Float.floatToRawIntBits(RangesKt.coerceIn(multiParagraph.getLineBottom(lineForOffset), 0.0f, (int) (j & 4294967295L)))) & 4294967295L);
    }

    public static final int getTextDirectionForOffset(TextLayoutResult textLayoutResult, int i) {
        TextLayoutInput textLayoutInput = textLayoutResult.layoutInput;
        MultiParagraph multiParagraph = textLayoutResult.multiParagraph;
        if (textLayoutInput.text.text.length() != 0) {
            int lineForOffset = multiParagraph.getLineForOffset(i);
            if ((i != 0 && lineForOffset == multiParagraph.getLineForOffset(i - 1)) || (i != textLayoutInput.text.text.length() && lineForOffset == multiParagraph.getLineForOffset(i + 1))) {
                return textLayoutResult.getBidiRunDirection(i);
            }
        }
        return textLayoutResult.getParagraphDirection(i);
    }

    public static final boolean isSelectionHandleInVisibleBound(TextFieldSelectionManager textFieldSelectionManager, boolean z) {
        LayoutCoordinates layoutCoordinates;
        LegacyTextFieldState legacyTextFieldState = textFieldSelectionManager.state;
        if (legacyTextFieldState == null || (layoutCoordinates = legacyTextFieldState.getLayoutCoordinates()) == null) {
            return false;
        }
        return m224containsInclusiveUv8p0NA(visibleBounds(layoutCoordinates), textFieldSelectionManager.m232getHandlePositiontuRUvjQ$foundation(z));
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0082 A[Catch: all -> 0x0045, TryCatch #1 {all -> 0x0045, blocks: (B:20:0x0041, B:31:0x007a, B:33:0x0082, B:35:0x008e, B:37:0x009a, B:28:0x0061), top: B:69:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x008e A[Catch: all -> 0x0045, TryCatch #1 {all -> 0x0045, blocks: (B:20:0x0041, B:31:0x007a, B:33:0x0082, B:35:0x008e, B:37:0x009a, B:28:0x0061), top: B:69:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x009a A[Catch: all -> 0x0045, TRY_LEAVE, TryCatch #1 {all -> 0x0045, blocks: (B:20:0x0041, B:31:0x007a, B:33:0x0082, B:35:0x008e, B:37:0x009a, B:28:0x0061), top: B:69:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x00fd A[Catch: all -> 0x0032, TryCatch #0 {all -> 0x0032, blocks: (B:13:0x002d, B:54:0x00e5, B:56:0x00ed, B:58:0x00f1, B:60:0x00fd, B:62:0x0109, B:50:0x00be), top: B:69:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x0109 A[Catch: all -> 0x0032, TRY_LEAVE, TryCatch #0 {all -> 0x0032, blocks: (B:13:0x002d, B:54:0x00e5, B:56:0x00ed, B:58:0x00f1, B:60:0x00fd, B:62:0x0109, B:50:0x00be), top: B:69:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x010c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x009d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Type inference failed for: r13v2, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r9v13, types: [java.lang.Object, java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r9v7, types: [java.lang.Object, java.util.Collection, java.util.List] */
    public static final Object mouseSelection(SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine, MouseSelectionObserver mouseSelectionObserver, RoomOpenHelper roomOpenHelper, PointerEvent pointerEvent, BaseContinuationImpl baseContinuationImpl) {
        SelectionGesturesKt$mouseSelection$1 selectionGesturesKt$mouseSelection$1;
        SelectionAdjustment$Companion$$ExternalSyntheticLambda0 selectionAdjustment$Companion$$ExternalSyntheticLambda0;
        SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine2;
        Ref$BooleanRef ref$BooleanRef;
        ?? r9;
        int size;
        PointerInputChange pointerInputChange;
        ?? r10;
        int size2;
        PointerInputChange pointerInputChange2;
        SelectionAdjustment$Companion$$ExternalSyntheticLambda0 selectionAdjustment$Companion$$ExternalSyntheticLambda1 = SelectionAdjustment$Companion.None;
        if (baseContinuationImpl instanceof SelectionGesturesKt$mouseSelection$1) {
            selectionGesturesKt$mouseSelection$1 = (SelectionGesturesKt$mouseSelection$1) baseContinuationImpl;
            int i = selectionGesturesKt$mouseSelection$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                selectionGesturesKt$mouseSelection$1.label = i - Integer.MIN_VALUE;
            } else {
                selectionGesturesKt$mouseSelection$1 = new SelectionGesturesKt$mouseSelection$1(baseContinuationImpl);
            }
        } else {
            selectionGesturesKt$mouseSelection$1 = new SelectionGesturesKt$mouseSelection$1(baseContinuationImpl);
        }
        Object objM72dragjO51t88 = selectionGesturesKt$mouseSelection$1.result;
        int i2 = selectionGesturesKt$mouseSelection$1.label;
        int i3 = 0;
        try {
            try {
                if (i2 == 0) {
                    ResultKt.throwOnFailure(objM72dragjO51t88);
                    PointerInputChange pointerInputChange3 = (PointerInputChange) pointerEvent.changes.get(0);
                    int i4 = pointerEvent.keyboardModifiers & 1;
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    if (i4 == 0) {
                        int i5 = roomOpenHelper.version;
                        if (i5 != 1) {
                            selectionAdjustment$Companion$$ExternalSyntheticLambda0 = i5 != 2 ? SelectionAdjustment$Companion.Paragraph : SelectionAdjustment$Companion.Word;
                        } else {
                            selectionAdjustment$Companion$$ExternalSyntheticLambda0 = selectionAdjustment$Companion$$ExternalSyntheticLambda1;
                        }
                        if (mouseSelectionObserver.mo210onStart9KIMszo(pointerInputChange3.position, selectionAdjustment$Companion$$ExternalSyntheticLambda0, i5)) {
                            Ref$BooleanRef ref$BooleanRef2 = new Ref$BooleanRef();
                            ref$BooleanRef2.element = !selectionAdjustment$Companion$$ExternalSyntheticLambda0.equals(selectionAdjustment$Companion$$ExternalSyntheticLambda1);
                            long j = pointerInputChange3.id;
                            LifecycleEffectKt$$ExternalSyntheticLambda1 lifecycleEffectKt$$ExternalSyntheticLambda1 = new LifecycleEffectKt$$ExternalSyntheticLambda1(mouseSelectionObserver, selectionAdjustment$Companion$$ExternalSyntheticLambda0, ref$BooleanRef2, 10);
                            selectionGesturesKt$mouseSelection$1.L$0 = pointerEventHandlerCoroutine;
                            selectionGesturesKt$mouseSelection$1.L$1 = mouseSelectionObserver;
                            selectionGesturesKt$mouseSelection$1.L$2 = ref$BooleanRef2;
                            selectionGesturesKt$mouseSelection$1.label = 2;
                            objM72dragjO51t88 = DragGestureDetectorKt.m72dragjO51t88(pointerEventHandlerCoroutine, j, lifecycleEffectKt$$ExternalSyntheticLambda1, selectionGesturesKt$mouseSelection$1);
                            if (objM72dragjO51t88 != coroutineSingletons) {
                                pointerEventHandlerCoroutine2 = pointerEventHandlerCoroutine;
                                ref$BooleanRef = ref$BooleanRef2;
                                if (((Boolean) objM72dragjO51t88).booleanValue()) {
                                    r10 = SuspendingPointerInputModifierNodeImpl.this.currentEvent.changes;
                                    size2 = r10.size();
                                    while (i3 < size2) {
                                        pointerInputChange2 = (PointerInputChange) r10.get(i3);
                                        if (PointerId.changedToUp(pointerInputChange2)) {
                                            pointerInputChange2.consume();
                                        }
                                        i3++;
                                    }
                                }
                                mouseSelectionObserver.onDragDone();
                            }
                            return coroutineSingletons;
                        }
                    } else if (mouseSelectionObserver.mo208onExtendk4lQ0M(pointerInputChange3.position)) {
                        pointerInputChange3.consume();
                        long j2 = pointerInputChange3.id;
                        Recomposer$$ExternalSyntheticLambda0 recomposer$$ExternalSyntheticLambda0 = new Recomposer$$ExternalSyntheticLambda0(22, mouseSelectionObserver);
                        selectionGesturesKt$mouseSelection$1.L$0 = pointerEventHandlerCoroutine;
                        selectionGesturesKt$mouseSelection$1.L$1 = mouseSelectionObserver;
                        selectionGesturesKt$mouseSelection$1.label = 1;
                        objM72dragjO51t88 = DragGestureDetectorKt.m72dragjO51t88(pointerEventHandlerCoroutine, j2, recomposer$$ExternalSyntheticLambda0, selectionGesturesKt$mouseSelection$1);
                        if (objM72dragjO51t88 == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                        if (((Boolean) objM72dragjO51t88).booleanValue()) {
                            r9 = SuspendingPointerInputModifierNodeImpl.this.currentEvent.changes;
                            size = r9.size();
                            while (i3 < size) {
                                pointerInputChange = (PointerInputChange) r9.get(i3);
                                if (PointerId.changedToUp(pointerInputChange)) {
                                    pointerInputChange.consume();
                                }
                                i3++;
                            }
                        }
                        mouseSelectionObserver.onDragDone();
                    }
                } else if (i2 == 1) {
                    mouseSelectionObserver = selectionGesturesKt$mouseSelection$1.L$1;
                    pointerEventHandlerCoroutine = selectionGesturesKt$mouseSelection$1.L$0;
                    ResultKt.throwOnFailure(objM72dragjO51t88);
                    if (((Boolean) objM72dragjO51t88).booleanValue()) {
                        r9 = SuspendingPointerInputModifierNodeImpl.this.currentEvent.changes;
                        size = r9.size();
                        while (i3 < size) {
                            pointerInputChange = (PointerInputChange) r9.get(i3);
                            if (PointerId.changedToUp(pointerInputChange)) {
                                pointerInputChange.consume();
                            }
                            i3++;
                        }
                    }
                    mouseSelectionObserver.onDragDone();
                } else {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ref$BooleanRef = selectionGesturesKt$mouseSelection$1.L$2;
                    mouseSelectionObserver = selectionGesturesKt$mouseSelection$1.L$1;
                    pointerEventHandlerCoroutine2 = selectionGesturesKt$mouseSelection$1.L$0;
                    ResultKt.throwOnFailure(objM72dragjO51t88);
                    if (((Boolean) objM72dragjO51t88).booleanValue() && ref$BooleanRef.element) {
                        r10 = SuspendingPointerInputModifierNodeImpl.this.currentEvent.changes;
                        size2 = r10.size();
                        while (i3 < size2) {
                            pointerInputChange2 = (PointerInputChange) r10.get(i3);
                            if (PointerId.changedToUp(pointerInputChange2)) {
                                pointerInputChange2.consume();
                            }
                            i3++;
                        }
                    }
                    mouseSelectionObserver.onDragDone();
                }
                return Unit.INSTANCE;
            } catch (Throwable th) {
                mouseSelectionObserver.onDragDone();
                throw th;
            }
        } catch (Throwable th2) {
            mouseSelectionObserver.onDragDone();
            throw th2;
        }
    }

    public static final int resolve2dDirection(int i, int i2) {
        int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i2);
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                if (iOrdinal == 2) {
                    return 3;
                }
                throw new HttpException();
            }
            int iOrdinal2 = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i);
            if (iOrdinal2 != 0) {
                if (iOrdinal2 == 1) {
                    return 2;
                }
                if (iOrdinal2 == 2) {
                    return 3;
                }
                throw new HttpException();
            }
        }
        return 1;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a0, code lost:
    
        if (r14 == r5) goto L35;
     */
    /* JADX WARN: Type inference failed for: r11v7, types: [java.lang.Object, java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r13v1, types: [java.lang.Object, java.util.List] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object touchSelectionFirstPress(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine r11, androidx.compose.foundation.text.TextDragObserver r12, androidx.compose.ui.input.pointer.PointerEvent r13, kotlin.coroutines.jvm.internal.BaseContinuationImpl r14) {
        /*
            Method dump skipped, instruction units count: 215
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SimpleLayoutKt.touchSelectionFirstPress(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl$PointerEventHandlerCoroutine, androidx.compose.foundation.text.TextDragObserver, androidx.compose.ui.input.pointer.PointerEvent, kotlin.coroutines.jvm.internal.BaseContinuationImpl):java.lang.Object");
    }

    public static final Rect visibleBounds(LayoutCoordinates layoutCoordinates) {
        Rect rectBoundsInWindow = RulerKt.boundsInWindow(layoutCoordinates, true);
        long jMo531windowToLocalMKHz9U = layoutCoordinates.mo531windowToLocalMKHz9U(rectBoundsInWindow.m380getTopLeftF1C5BW0());
        float f = rectBoundsInWindow.right;
        float f2 = rectBoundsInWindow.bottom;
        long jMo531windowToLocalMKHz9U2 = layoutCoordinates.mo531windowToLocalMKHz9U((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L));
        return new Rect(Float.intBitsToFloat((int) (jMo531windowToLocalMKHz9U >> 32)), Float.intBitsToFloat((int) (jMo531windowToLocalMKHz9U & 4294967295L)), Float.intBitsToFloat((int) (jMo531windowToLocalMKHz9U2 >> 32)), Float.intBitsToFloat((int) (jMo531windowToLocalMKHz9U2 & 4294967295L)));
    }

    public static final void SelectionContainer(Modifier modifier, Selection selection, Function1 function1, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        int i2;
        gapComposer.startRestartGroup(-917932944);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        int i3 = i2 | (gapComposer.changed(selection) ? 32 : 16);
        if ((i & 3072) == 0) {
            i3 |= gapComposer.changedInstance(composableLambdaImpl) ? 2048 : 1024;
        }
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 1171) != 1170)) {
            Object[] objArr = new Object[0];
            Object objRememberedValue = gapComposer.rememberedValue();
            Object obj = Composer$Companion.Empty;
            if (objRememberedValue == obj) {
                objRememberedValue = new ImmLeaksCleaner$$ExternalSyntheticLambda0(16);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            SelectionRegistrarImpl selectionRegistrarImpl = (SelectionRegistrarImpl) SaverKt.rememberSaveable(objArr, SelectionRegistrarImpl.Saver, (Function0) objRememberedValue, gapComposer, 384);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == obj) {
                objRememberedValue2 = new SelectionManager(selectionRegistrarImpl);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            SelectionManager selectionManager = (SelectionManager) objRememberedValue2;
            Object obj2 = (Clipboard) gapComposer.consume(CompositionLocalsKt.LocalClipboard);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (objRememberedValue3 == obj) {
                objRememberedValue3 = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue3;
            selectionManager.hapticFeedBack = (HapticFeedback) gapComposer.consume(CompositionLocalsKt.LocalHapticFeedback);
            boolean zChanged = gapComposer.changed(coroutineScope) | gapComposer.changed(obj2);
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue4 == obj) {
                objRememberedValue4 = new BackHandlerKt$$ExternalSyntheticLambda2(29, coroutineScope, obj2);
                gapComposer.updateRememberedValue(objRememberedValue4);
            }
            selectionManager.onCopyHandler = (Function1) objRememberedValue4;
            selectionManager.onSelectionChange = new BlurEffectKt$$ExternalSyntheticLambda1(1, selectionManager, function1);
            selectionManager.setSelection(selection);
            gapComposer.startReplaceGroup(-82280708);
            selectionManager.platformSelectionBehaviors = PlatformSelectionBehaviors_androidKt.rememberPlatformSelectionBehaviors(SelectedTextType.StaticText, null, gapComposer, 54);
            selectionManager.coroutineScope = coroutineScope;
            gapComposer.end(false);
            selectionManager.isNonEmptySelection$foundation();
            SelectionManager$$ExternalSyntheticLambda0 selectionManager$$ExternalSyntheticLambda0 = new SelectionManager$$ExternalSyntheticLambda0(selectionManager, 0);
            Unit unit = Unit.INSTANCE;
            CoreTextFieldKt$TextFieldCursorHandle$2$1 coreTextFieldKt$TextFieldCursorHandle$2$1 = new CoreTextFieldKt$TextFieldCursorHandle$2$1(1, selectionManager, selectionManager$$ExternalSyntheticLambda0);
            Modifier modifierThen = Modifier.Companion.$$INSTANCE;
            Modifier modifierOnKeyEvent = Key_androidKt.onKeyEvent(SuspendingPointerInputFilterKt.pointerInput(ImageKt.focusable(FocusTraversalKt.onFocusChanged(FocusTraversalKt.focusRequester(RulerKt.onGloballyPositioned(SuspendingPointerInputFilterKt.pointerInput(modifierThen, unit, coreTextFieldKt$TextFieldCursorHandle$2$1), new SelectionManager$$ExternalSyntheticLambda1(selectionManager, 0)), selectionManager.focusRequester), new SelectionManager$$ExternalSyntheticLambda1(selectionManager, 5)), true, null), 8675309, new ScrimKt$Scrim$dismissModifier$1$1(5, new SelectionManager$$ExternalSyntheticLambda1(selectionManager, 6))), new RenderScriptBlurEffect$updateSurface$2$4(2, selectionManager));
            if (selectionManager.getDraggingHandle() != null && selectionManager.isInTouchMode()) {
                Selection selection2 = selectionManager.getSelection();
                if (!(selection2 != null ? Intrinsics.areEqual(selection2.start, selection2.end) : true) && Magnifier_androidKt.isPlatformMagnifierSupported$default()) {
                    modifierThen = modifierThen.then(new ComposedModifier(new SheetDefaultsKt$$ExternalSyntheticLambda5(3, selectionManager)));
                }
            }
            SimpleLayout(modifier.then(TextContextMenuModifierKt.addTextContextMenuComponentsWithContext(modifierOnKeyEvent.then(modifierThen), new Updater$$ExternalSyntheticLambda0(14, selectionManager))), Thread_jvmKt.rememberComposableLambda(-1799563674, new SelectionContainerKt$$ExternalSyntheticLambda4(selectionManager, selectionRegistrarImpl, composableLambdaImpl), gapComposer), gapComposer, 48);
            boolean zChangedInstance = gapComposer.changedInstance(selectionManager);
            Object objRememberedValue5 = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue5 == obj) {
                objRememberedValue5 = new SelectionManager$$ExternalSyntheticLambda1(selectionManager, 1);
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            Stack.DisposableEffect(selectionManager, (Function1) objRememberedValue5, gapComposer);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AsyncImageKt$$ExternalSyntheticLambda1(modifier, selection, function1, composableLambdaImpl, i, 2);
        }
    }
}
