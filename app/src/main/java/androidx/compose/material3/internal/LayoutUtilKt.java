package androidx.compose.material3.internal;

import android.content.res.Resources;
import android.view.KeyEvent;
import androidx.camera.core.SurfaceRequest;
import androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.material3.CheckboxKt$$ExternalSyntheticLambda4;
import androidx.compose.material3.ContentColorKt;
import androidx.compose.material3.MaterialThemeKt$$ExternalSyntheticLambda5;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TooltipStateImpl;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.DynamicProvidableCompositionLocal;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.Key_androidKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import androidx.compose.ui.layout.LayoutIdModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.PlatformParagraphStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.compose.ui.window.PopupProperties;
import androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda1;
import coil.compose.AsyncImageKt$$ExternalSyntheticLambda1;
import com.github.kr328.clash.LogcatActivity$$ExternalSyntheticLambda4;
import com.koala.clash.R;
import io.github.g00fy2.quickie.content.QRContent;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobSupport$children$1;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class LayoutUtilKt {
    public static final PlatformTextStyle DefaultPlatformTextStyle = new PlatformTextStyle(null, new PlatformParagraphStyle());

    public static final void BasicTooltipBox(PopupPositionProvider popupPositionProvider, ComposableLambdaImpl composableLambdaImpl, TooltipStateImpl tooltipStateImpl, Modifier modifier, ComposableLambdaImpl composableLambdaImpl2, GapComposer gapComposer, int i) {
        PopupPositionProvider popupPositionProvider2;
        int i2;
        MutableState mutableState;
        boolean z;
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(-1221877520);
        if ((i & 6) == 0) {
            popupPositionProvider2 = popupPositionProvider;
            i2 = (gapComposer2.changed(popupPositionProvider2) ? 4 : 2) | i;
        } else {
            popupPositionProvider2 = popupPositionProvider;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer2.changedInstance(composableLambdaImpl) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= (i & 512) == 0 ? gapComposer2.changed(tooltipStateImpl) : gapComposer2.changedInstance(tooltipStateImpl) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer2.changed(modifier) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer2.changedInstance(null) ? 16384 : 8192;
        }
        if ((i & 196608) == 0) {
            i2 |= gapComposer2.changed(false) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= gapComposer2.changed(true) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= gapComposer2.changed(false) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i2 |= gapComposer2.changedInstance(composableLambdaImpl2) ? 67108864 : 33554432;
        }
        int i3 = i2;
        if (gapComposer2.shouldExecute(i3 & 1, (38347923 & i3) != 38347922)) {
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer2);
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            MutableState mutableState2 = (MutableState) objRememberedValue2;
            gapComposer2.startReplaceGroup(-1104742522);
            gapComposer2.end(false);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            long j = gapComposer2.compositeKeyHashCode;
            int i4 = (int) (j ^ (j >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, Modifier.Companion.$$INSTANCE);
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
            Stack.m295setimpl(gapComposer2, Integer.valueOf(i4), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m294reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            if (tooltipStateImpl.isVisible()) {
                gapComposer2.startReplaceGroup(-1891243071);
                TooltipPopup(popupPositionProvider2, tooltipStateImpl, coroutineScope, false, mutableState2, composableLambdaImpl, gapComposer2, (i3 & 14) | 196608 | ((i3 >> 3) & 112) | ((i3 >> 6) & 896) | ((i3 << 15) & 3670016));
                mutableState = mutableState2;
                gapComposer2 = gapComposer2;
                z = false;
                gapComposer2.end(false);
            } else {
                mutableState = mutableState2;
                z = false;
                gapComposer2.startReplaceGroup(-1890863476);
                gapComposer2.end(false);
            }
            WrappedAnchor(tooltipStateImpl, mutableState, modifier, composableLambdaImpl2, gapComposer2, ((i3 >> 18) & 14) | 384 | ((i3 >> 3) & 112) | ((i3 >> 12) & 7168) | (57344 & (i3 << 3)) | ((i3 >> 9) & 458752));
            gapComposer2.end(true);
            boolean z2 = ((i3 & 896) == 256 || ((i3 & 512) != 0 && gapComposer2.changedInstance(tooltipStateImpl))) ? true : z;
            Object objRememberedValue3 = gapComposer2.rememberedValue();
            if (z2 || objRememberedValue3 == neverEqualPolicy) {
                objRememberedValue3 = new Recomposer$$ExternalSyntheticLambda0(27, tooltipStateImpl);
                gapComposer2.updateRememberedValue(objRememberedValue3);
            }
            Stack.DisposableEffect(tooltipStateImpl, (Function1) objRememberedValue3, gapComposer2);
        } else {
            gapComposer2.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new MaterialThemeKt$$ExternalSyntheticLambda5(popupPositionProvider, composableLambdaImpl, tooltipStateImpl, modifier, composableLambdaImpl2, i);
        }
    }

    public static final void PredictiveBackHandler(boolean z, Function2 function2, GapComposer gapComposer, int i) {
        gapComposer.startRestartGroup(-1437916225);
        int i2 = (gapComposer.changed(z) ? 4 : 2) | i | (gapComposer.changedInstance(function2) ? 32 : 16);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            QRContent.PredictiveBackHandler(z, function2, gapComposer, i2 & 126);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new LogcatActivity$$ExternalSyntheticLambda4(z, function2, i, 2);
        }
    }

    /* JADX INFO: renamed from: ProvideContentColorTextStyle-3J-VO9M, reason: not valid java name */
    public static final void m281ProvideContentColorTextStyle3JVO9M(long j, TextStyle textStyle, Function2 function2, GapComposer gapComposer, int i) {
        int i2;
        gapComposer.startRestartGroup(-684938728);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(textStyle) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changedInstance(function2) ? 256 : 128;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            DynamicProvidableCompositionLocal dynamicProvidableCompositionLocal = TextKt.LocalTextStyle;
            Stack.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.LocalContentColor.defaultProvidedValue$runtime(new Color(j)), dynamicProvidableCompositionLocal.defaultProvidedValue$runtime(((TextStyle) gapComposer.consume(dynamicProvidableCompositionLocal)).merge(textStyle))}, function2, gapComposer, ((i2 >> 3) & 112) | 8);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TextFieldImplKt$$ExternalSyntheticLambda2(j, textStyle, function2, i, 1);
        }
    }

    public static final void TooltipPopup(PopupPositionProvider popupPositionProvider, TooltipStateImpl tooltipStateImpl, CoroutineScope coroutineScope, boolean z, MutableState mutableState, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        PopupPositionProvider popupPositionProvider2;
        int i2;
        gapComposer.startRestartGroup(-1413720282);
        if ((i & 6) == 0) {
            popupPositionProvider2 = popupPositionProvider;
            i2 = (gapComposer.changed(popupPositionProvider2) ? 4 : 2) | i;
        } else {
            popupPositionProvider2 = popupPositionProvider;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? gapComposer.changed(tooltipStateImpl) : gapComposer.changedInstance(tooltipStateImpl) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changedInstance(null) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changedInstance(coroutineScope) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer.changed(z) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= gapComposer.changed(mutableState) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl) ? 1048576 : 524288;
        }
        if (gapComposer.shouldExecute(i2 & 1, (599187 & i2) != 599186)) {
            String strStringResource = StringResources_androidKt.stringResource(R.string.tooltip_description, gapComposer);
            boolean zChangedInstance = ((i2 & 112) == 32 || ((i2 & 64) != 0 && gapComposer.changedInstance(tooltipStateImpl))) | ((i2 & 896) == 256) | gapComposer.changedInstance(coroutineScope) | ((458752 & i2) == 131072);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer$Companion.Empty) {
                objRememberedValue = new GapComposer$$ExternalSyntheticLambda0(tooltipStateImpl, coroutineScope, mutableState, 7);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            int i3 = (i2 & 14) | 3072;
            AndroidPopup_androidKt.Popup(popupPositionProvider2, (Function0) objRememberedValue, new PopupProperties(22, z), Thread_jvmKt.rememberComposableLambda(-1287705660, new BasicTooltipKt$$ExternalSyntheticLambda7(strStringResource, composableLambdaImpl), gapComposer), gapComposer, i3, 0);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new CheckboxKt$$ExternalSyntheticLambda4(popupPositionProvider, tooltipStateImpl, coroutineScope, z, mutableState, composableLambdaImpl, i);
        }
    }

    public static final void WrappedAnchor(final TooltipStateImpl tooltipStateImpl, final MutableState mutableState, Modifier modifier, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        int i2;
        gapComposer.startRestartGroup(1873232064);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(true) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? gapComposer.changed(tooltipStateImpl) : gapComposer.changedInstance(tooltipStateImpl) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changed(mutableState) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changed(false) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer.changed(modifier) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl) ? 131072 : 65536;
        }
        if (gapComposer.shouldExecute(i2 & 1, (74899 & i2) != 74898)) {
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            String strStringResource = StringResources_androidKt.stringResource(R.string.tooltip_label, gapComposer);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue2;
            final int i3 = 0;
            final int i4 = 1;
            Modifier modifierOnPreviewKeyEvent = Key_androidKt.onPreviewKeyEvent(FocusTraversalKt.onFocusChanged(SuspendingPointerInputFilterKt.pointerInput(SuspendingPointerInputFilterKt.pointerInput(modifier, tooltipStateImpl, new PointerInputEventHandler() { // from class: androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1

                /* JADX INFO: renamed from: androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
                public final class AnonymousClass1 extends SuspendLambda implements Function2 {
                    public final /* synthetic */ int $r8$classId;
                    public final /* synthetic */ TooltipStateImpl $state;
                    public final /* synthetic */ PointerInputScope $this_pointerInput;
                    public /* synthetic */ Object L$0;
                    public int label;

                    /* JADX INFO: renamed from: androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1$1$1, reason: invalid class name and collision with other inner class name */
                    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
                    public final class C00021 extends RestrictedSuspendLambda implements Function2 {
                        public final /* synthetic */ CoroutineScope $$this$coroutineScope;
                        public final /* synthetic */ TooltipStateImpl $state;
                        public long J$0;
                        public /* synthetic */ Object L$0;
                        public MutableStateFlow L$1;
                        public PointerEventPass L$2;
                        public int label;

                        /* JADX INFO: renamed from: androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1$1$1$1, reason: invalid class name and collision with other inner class name */
                        /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
                        public final class C00031 extends RestrictedSuspendLambda implements Function2 {
                            public final /* synthetic */ Object $pass;
                            public final /* synthetic */ int $r8$classId;
                            public /* synthetic */ Object L$0;
                            public int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            public /* synthetic */ C00031(Object obj, Continuation continuation, int i) {
                                super(2, continuation);
                                this.$r8$classId = i;
                                this.$pass = obj;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation create(Object obj, Continuation continuation) {
                                switch (this.$r8$classId) {
                                    case 0:
                                        C00031 c00031 = new C00031((PointerEventPass) this.$pass, continuation, 0);
                                        c00031.L$0 = obj;
                                        return c00031;
                                    default:
                                        C00031 c00032 = new C00031((AndroidEdgeEffectOverscrollEffect) this.$pass, continuation, 1);
                                        c00032.L$0 = obj;
                                        return c00032;
                                }
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) obj;
                                Continuation continuation = (Continuation) obj2;
                                switch (this.$r8$classId) {
                                    case 0:
                                        break;
                                }
                                return ((C00031) create(pointerEventHandlerCoroutine, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            /* JADX WARN: Code duplicated, block: B:27:0x0082  */
                            /* JADX WARN: Code duplicated, block: B:30:0x0094 A[LOOP:1: B:26:0x0080->B:30:0x0094, LOOP_END] */
                            /* JADX WARN: Code duplicated, block: B:55:0x0098 A[SYNTHETIC] */
                            /* JADX WARN: Type inference failed for: r12v13, types: [java.lang.Object, java.util.Collection, java.util.List] */
                            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0053 -> B:19:0x0056). Please report as a decompilation issue!!! */
                            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                                jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
                                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                                	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
                                */
                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final java.lang.Object invokeSuspend(java.lang.Object r12) {
                                /*
                                    Method dump skipped, instruction units count: 234
                                    To view this dump add '--comments-level debug' option
                                */
                                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1.AnonymousClass1.C00021.C00031.invokeSuspend(java.lang.Object):java.lang.Object");
                            }
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public C00021(CoroutineScope coroutineScope, TooltipStateImpl tooltipStateImpl, Continuation continuation) {
                            super(2, continuation);
                            this.$$this$coroutineScope = coroutineScope;
                            this.$state = tooltipStateImpl;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation create(Object obj, Continuation continuation) {
                            C00021 c00021 = new C00021(this.$$this$coroutineScope, this.$state, continuation);
                            c00021.L$0 = obj;
                            return c00021;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ((C00021) create((SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:38:0x00c2, code lost:
                        
                            if (r14 == r5) goto L39;
                         */
                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Type inference failed for: r0v0, types: [int] */
                        /* JADX WARN: Type inference failed for: r0v1 */
                        /* JADX WARN: Type inference failed for: r0v11 */
                        /* JADX WARN: Type inference failed for: r0v15 */
                        /* JADX WARN: Type inference failed for: r0v2 */
                        /* JADX WARN: Type inference failed for: r0v20 */
                        /* JADX WARN: Type inference failed for: r0v21 */
                        /* JADX WARN: Type inference failed for: r0v8 */
                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
                            /*
                                Method dump skipped, instruction units count: 229
                                To view this dump add '--comments-level debug' option
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1.AnonymousClass1.C00021.invokeSuspend(java.lang.Object):java.lang.Object");
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public /* synthetic */ AnonymousClass1(PointerInputScope pointerInputScope, TooltipStateImpl tooltipStateImpl, Continuation continuation, int i) {
                        super(2, continuation);
                        this.$r8$classId = i;
                        this.$this_pointerInput = pointerInputScope;
                        this.$state = tooltipStateImpl;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object obj, Continuation continuation) {
                        switch (this.$r8$classId) {
                            case 0:
                                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_pointerInput, this.$state, continuation, 0);
                                anonymousClass1.L$0 = obj;
                                return anonymousClass1;
                            default:
                                AnonymousClass1 anonymousClass2 = new AnonymousClass1(this.$this_pointerInput, this.$state, continuation, 1);
                                anonymousClass2.L$0 = obj;
                                return anonymousClass2;
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        CoroutineScope coroutineScope = (CoroutineScope) obj;
                        Continuation continuation = (Continuation) obj2;
                        switch (this.$r8$classId) {
                            case 0:
                                break;
                        }
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        switch (this.$r8$classId) {
                            case 0:
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    C00021 c00021 = new C00021((CoroutineScope) this.L$0, this.$state, null);
                                    this.label = 1;
                                    Object objAwaitEachGesture = ScrollableKt.awaitEachGesture(this.$this_pointerInput, c00021, this);
                                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                                    if (objAwaitEachGesture == coroutineSingletons) {
                                        return coroutineSingletons;
                                    }
                                } else {
                                    if (i != 1) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj);
                                }
                                return Unit.INSTANCE;
                            default:
                                int i2 = this.label;
                                if (i2 == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    JobSupport$children$1 jobSupport$children$1 = new JobSupport$children$1((CoroutineScope) this.L$0, this.$state, (Continuation) null);
                                    this.label = 1;
                                    Object objAwaitPointerEventScope = ((SuspendingPointerInputModifierNodeImpl) this.$this_pointerInput).awaitPointerEventScope(jobSupport$children$1, this);
                                    CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                                    if (objAwaitPointerEventScope == coroutineSingletons2) {
                                        return coroutineSingletons2;
                                    }
                                } else {
                                    if (i2 != 1) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj);
                                }
                                return Unit.INSTANCE;
                        }
                    }
                }

                @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
                    switch (i3) {
                        case 0:
                            Object objCoroutineScope = JobKt.coroutineScope(new AnonymousClass1(pointerInputScope, tooltipStateImpl, null, 0), continuation);
                            return objCoroutineScope == CoroutineSingletons.COROUTINE_SUSPENDED ? objCoroutineScope : Unit.INSTANCE;
                        default:
                            Object objCoroutineScope2 = JobKt.coroutineScope(new AnonymousClass1(pointerInputScope, tooltipStateImpl, null, 1), continuation);
                            return objCoroutineScope2 == CoroutineSingletons.COROUTINE_SUSPENDED ? objCoroutineScope2 : Unit.INSTANCE;
                    }
                }
            }), tooltipStateImpl, new PointerInputEventHandler() { // from class: androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1

                /* JADX INFO: renamed from: androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
                public final class AnonymousClass1 extends SuspendLambda implements Function2 {
                    public final /* synthetic */ int $r8$classId;
                    public final /* synthetic */ TooltipStateImpl $state;
                    public final /* synthetic */ PointerInputScope $this_pointerInput;
                    public /* synthetic */ Object L$0;
                    public int label;

                    /* JADX INFO: renamed from: androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1$1$1, reason: invalid class name and collision with other inner class name */
                    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
                    public final class C00021 extends RestrictedSuspendLambda implements Function2 {
                        public final /* synthetic */ CoroutineScope $$this$coroutineScope;
                        public final /* synthetic */ TooltipStateImpl $state;
                        public long J$0;
                        public /* synthetic */ Object L$0;
                        public MutableStateFlow L$1;
                        public PointerEventPass L$2;
                        public int label;

                        /* JADX INFO: renamed from: androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1$1$1$1, reason: invalid class name and collision with other inner class name */
                        /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
                        public final class C00031 extends RestrictedSuspendLambda implements Function2 {
                            public final /* synthetic */ Object $pass;
                            public final /* synthetic */ int $r8$classId;
                            public /* synthetic */ Object L$0;
                            public int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            public /* synthetic */ C00031(Object obj, Continuation continuation, int i) {
                                super(2, continuation);
                                this.$r8$classId = i;
                                this.$pass = obj;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation create(Object obj, Continuation continuation) {
                                switch (this.$r8$classId) {
                                    case 0:
                                        C00031 c00031 = new C00031((PointerEventPass) this.$pass, continuation, 0);
                                        c00031.L$0 = obj;
                                        return c00031;
                                    default:
                                        C00031 c00032 = new C00031((AndroidEdgeEffectOverscrollEffect) this.$pass, continuation, 1);
                                        c00032.L$0 = obj;
                                        return c00032;
                                }
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine pointerEventHandlerCoroutine = (SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) obj;
                                Continuation continuation = (Continuation) obj2;
                                switch (this.$r8$classId) {
                                    case 0:
                                        break;
                                }
                                return ((C00031) create(pointerEventHandlerCoroutine, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            /* JADX WARN: Code duplicated, block: B:27:0x0082  */
                            /* JADX WARN: Code duplicated, block: B:30:0x0094 A[LOOP:1: B:26:0x0080->B:30:0x0094, LOOP_END] */
                            /* JADX WARN: Code duplicated, block: B:55:0x0098 A[SYNTHETIC] */
                            /* JADX WARN: Type inference failed for: r12v13, types: [java.lang.Object, java.util.Collection, java.util.List] */
                            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0053 -> B:19:0x0056). Please report as a decompilation issue!!! */
                            /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
                                jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
                                	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
                                	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
                                */
                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final java.lang.Object invokeSuspend(java.lang.Object r12) {
                                /*
                                    Method dump skipped, instruction units count: 234
                                    To view this dump add '--comments-level debug' option
                                */
                                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1.AnonymousClass1.C00021.C00031.invokeSuspend(java.lang.Object):java.lang.Object");
                            }
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public C00021(CoroutineScope coroutineScope, TooltipStateImpl tooltipStateImpl, Continuation continuation) {
                            super(2, continuation);
                            this.$$this$coroutineScope = coroutineScope;
                            this.$state = tooltipStateImpl;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation create(Object obj, Continuation continuation) {
                            C00021 c00021 = new C00021(this.$$this$coroutineScope, this.$state, continuation);
                            c00021.L$0 = obj;
                            return c00021;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ((C00021) create((SuspendingPointerInputModifierNodeImpl.PointerEventHandlerCoroutine) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:38:0x00c2, code lost:
                        
                            if (r14 == r5) goto L39;
                         */
                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Type inference failed for: r0v0, types: [int] */
                        /* JADX WARN: Type inference failed for: r0v1 */
                        /* JADX WARN: Type inference failed for: r0v11 */
                        /* JADX WARN: Type inference failed for: r0v15 */
                        /* JADX WARN: Type inference failed for: r0v2 */
                        /* JADX WARN: Type inference failed for: r0v20 */
                        /* JADX WARN: Type inference failed for: r0v21 */
                        /* JADX WARN: Type inference failed for: r0v8 */
                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
                            /*
                                Method dump skipped, instruction units count: 229
                                To view this dump add '--comments-level debug' option
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.BasicTooltipKt$handleGestures$1.AnonymousClass1.C00021.invokeSuspend(java.lang.Object):java.lang.Object");
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public /* synthetic */ AnonymousClass1(PointerInputScope pointerInputScope, TooltipStateImpl tooltipStateImpl, Continuation continuation, int i) {
                        super(2, continuation);
                        this.$r8$classId = i;
                        this.$this_pointerInput = pointerInputScope;
                        this.$state = tooltipStateImpl;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object obj, Continuation continuation) {
                        switch (this.$r8$classId) {
                            case 0:
                                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_pointerInput, this.$state, continuation, 0);
                                anonymousClass1.L$0 = obj;
                                return anonymousClass1;
                            default:
                                AnonymousClass1 anonymousClass2 = new AnonymousClass1(this.$this_pointerInput, this.$state, continuation, 1);
                                anonymousClass2.L$0 = obj;
                                return anonymousClass2;
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        CoroutineScope coroutineScope = (CoroutineScope) obj;
                        Continuation continuation = (Continuation) obj2;
                        switch (this.$r8$classId) {
                            case 0:
                                break;
                        }
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        switch (this.$r8$classId) {
                            case 0:
                                int i = this.label;
                                if (i == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    C00021 c00021 = new C00021((CoroutineScope) this.L$0, this.$state, null);
                                    this.label = 1;
                                    Object objAwaitEachGesture = ScrollableKt.awaitEachGesture(this.$this_pointerInput, c00021, this);
                                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                                    if (objAwaitEachGesture == coroutineSingletons) {
                                        return coroutineSingletons;
                                    }
                                } else {
                                    if (i != 1) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj);
                                }
                                return Unit.INSTANCE;
                            default:
                                int i2 = this.label;
                                if (i2 == 0) {
                                    ResultKt.throwOnFailure(obj);
                                    JobSupport$children$1 jobSupport$children$1 = new JobSupport$children$1((CoroutineScope) this.L$0, this.$state, (Continuation) null);
                                    this.label = 1;
                                    Object objAwaitPointerEventScope = ((SuspendingPointerInputModifierNodeImpl) this.$this_pointerInput).awaitPointerEventScope(jobSupport$children$1, this);
                                    CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                                    if (objAwaitPointerEventScope == coroutineSingletons2) {
                                        return coroutineSingletons2;
                                    }
                                } else {
                                    if (i2 != 1) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj);
                                }
                                return Unit.INSTANCE;
                        }
                    }
                }

                @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
                public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
                    switch (i4) {
                        case 0:
                            Object objCoroutineScope = JobKt.coroutineScope(new AnonymousClass1(pointerInputScope, tooltipStateImpl, null, 0), continuation);
                            return objCoroutineScope == CoroutineSingletons.COROUTINE_SUSPENDED ? objCoroutineScope : Unit.INSTANCE;
                        default:
                            Object objCoroutineScope2 = JobKt.coroutineScope(new AnonymousClass1(pointerInputScope, tooltipStateImpl, null, 1), continuation);
                            return objCoroutineScope2 == CoroutineSingletons.COROUTINE_SUSPENDED ? objCoroutineScope2 : Unit.INSTANCE;
                    }
                }
            }).then(new ParentSemanticsNodeElement(new LifecycleEffectKt$$ExternalSyntheticLambda1(strStringResource, coroutineScope, tooltipStateImpl, 14))), new LifecycleEffectKt$$ExternalSyntheticLambda1(coroutineScope, mutableState2, tooltipStateImpl, 13)), new Function1() { // from class: androidx.compose.material3.internal.BasicTooltipKt$keyboardBehavior$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    KeyEvent keyEvent = ((androidx.compose.ui.input.key.KeyEvent) obj).nativeKeyEvent;
                    TooltipStateImpl tooltipStateImpl2 = tooltipStateImpl;
                    if (!tooltipStateImpl2.isVisible()) {
                        mutableState.setValue(Boolean.FALSE);
                    } else if (Key_androidKt.m506getTypeZmokQxo(keyEvent) == 2 && Key.m504equalsimpl0(Key_androidKt.Key(keyEvent.getKeyCode()), Key.Escape)) {
                        mutableState2.setValue(Boolean.FALSE);
                        tooltipStateImpl2.dismiss();
                        return Boolean.TRUE;
                    }
                    return Boolean.FALSE;
                }
            });
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            long j = gapComposer.compositeKeyHashCode;
            int i5 = (int) (j ^ (j >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifierOnPreviewKeyEvent);
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
            Stack.m295setimpl(gapComposer, Integer.valueOf(i5), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m294reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m295setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            composableLambdaImpl.invoke(gapComposer, Integer.valueOf((i2 >> 15) & 14));
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AsyncImageKt$$ExternalSyntheticLambda1(tooltipStateImpl, mutableState, modifier, composableLambdaImpl, i);
        }
    }

    public static final Modifier draggableAnchors(Modifier modifier, SurfaceRequest.AnonymousClass1 anonymousClass1, Function2 function2) {
        return modifier.then(new DraggableAnchorsElement(anonymousClass1, function2));
    }

    public static final Object getLayoutId(Measurable measurable) {
        Object parentData = measurable.getParentData();
        LayoutIdModifier layoutIdModifier = parentData instanceof LayoutIdModifier ? (LayoutIdModifier) parentData : null;
        if (layoutIdModifier != null) {
            return layoutIdModifier.layoutId;
        }
        return null;
    }

    /* JADX INFO: renamed from: getString-2EP1pXo, reason: not valid java name */
    public static final String m282getString2EP1pXo(int i, GapComposer gapComposer) {
        gapComposer.consume(AndroidCompositionLocals_androidKt.LocalConfiguration);
        return ((Resources) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalResources)).getString(i);
    }

    public static final int subtractConstraintSafely(int i, int i2) {
        if (i == Integer.MAX_VALUE) {
            return i;
        }
        int i3 = i - i2;
        if (i3 < 0) {
            return 0;
        }
        return i3;
    }
}
