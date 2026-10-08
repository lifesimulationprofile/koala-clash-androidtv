package androidx.compose.foundation;

import android.view.KeyEvent;
import androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda2;
import androidx.collection.LongObjectMapKt;
import androidx.collection.MutableLongObjectMap;
import androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$2;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.HoverInteraction$Exit;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.input.indirect.IndirectPointerInputChange;
import androidx.compose.ui.input.indirect.IndirectPointerInputModifierNode;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.key.Key_androidKt;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.TouchBoundsExpansion;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.navigation.compose.NavHostKt$NavHost$28$1;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobKt__JobKt$invokeOnCompletion$1;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.coroutines.internal.ContextScope;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractClickableNode extends DelegatingNode implements PointerInputModifierNode, KeyInputModifierNode, SemanticsModifierNode, TraversableNode, CompositionLocalConsumerModifierNode, ObserverModifierNode, IndirectPointerInputModifierNode, GestureConnection {
    public static final GestureNode.TraverseKey TraverseKey = new GestureNode.TraverseKey();
    public long centerOffset;
    public final MutableLongObjectMap currentKeyPressInteractions;
    public StandaloneCoroutine delayJob;
    public boolean enabled;
    public final FocusableNode focusableNode;
    public GestureNode gestureNode;
    public HoverInteraction$Enter hoverInteraction;
    public DelegatableNode indicationNode;
    public IndicationNodeFactory indicationNodeFactory;
    public PressInteraction.Press indirectPointerPressInteraction;
    public MutableInteractionSourceImpl interactionSource;
    public boolean lazilyCreateIndication;
    public IndicationNodeFactory localIndicationNodeFactory;
    public Function0 onClick;
    public String onClickLabel;
    public SuspendingPointerInputModifierNodeImpl pointerInputNode;
    public PressInteraction.Press pressInteraction;
    public Role role;
    public final GestureNode.TraverseKey traverseKey;
    public boolean useLocalIndication;
    public MutableInteractionSourceImpl userProvidedInteractionSource;

    public AbstractClickableNode(MutableInteractionSourceImpl mutableInteractionSourceImpl, IndicationNodeFactory indicationNodeFactory, boolean z, boolean z2, String str, Role role, Function0 function0) {
        this.interactionSource = mutableInteractionSourceImpl;
        this.indicationNodeFactory = indicationNodeFactory;
        this.useLocalIndication = z;
        this.onClickLabel = str;
        this.role = role;
        this.enabled = z2;
        this.onClick = function0;
        this.focusableNode = new FocusableNode(mutableInteractionSourceImpl, 0, new JobKt__JobKt$invokeOnCompletion$1(1, this, AbstractClickableNode.class, "onFocusChange", "onFocusChange(Z)V", 0, 0, 1));
        MutableLongObjectMap mutableLongObjectMap = LongObjectMapKt.EmptyLongObjectMap;
        this.currentKeyPressInteractions = new MutableLongObjectMap();
        this.centerOffset = 0L;
        MutableInteractionSourceImpl mutableInteractionSourceImpl2 = this.interactionSource;
        this.userProvidedInteractionSource = mutableInteractionSourceImpl2;
        this.lazilyCreateIndication = mutableInteractionSourceImpl2 == null;
        this.traverseKey = TraverseKey;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Role role = this.role;
        if (role != null) {
            SemanticsPropertiesKt.m616setRolekuIjeqM(semanticsPropertyReceiver, role.value);
        }
        String str = this.onClickLabel;
        AbstractClickableNode$$ExternalSyntheticLambda0 abstractClickableNode$$ExternalSyntheticLambda0 = new AbstractClickableNode$$ExternalSyntheticLambda0(this, 1);
        KProperty[] kPropertyArr = SemanticsPropertiesKt.$$delegatedProperties;
        semanticsPropertyReceiver.set(SemanticsActions.OnClick, new AccessibilityAction(str, abstractClickableNode$$ExternalSyntheticLambda0));
        if (this.enabled) {
            this.focusableNode.applySemantics(semanticsPropertyReceiver);
        } else {
            semanticsPropertyReceiver.set(SemanticsProperties.Disabled, Unit.INSTANCE);
        }
        applyAdditionalSemantics(semanticsPropertyReceiver);
    }

    public SuspendingPointerInputModifierNodeImpl createPointerInputNodeIfNeeded() {
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0071 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:26:0x0073 A[LOOP:0: B:16:0x0037->B:26:0x0073, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:30:0x0076 A[EDGE_INSN: B:30:0x0076->B:27:0x0076 BREAK  A[LOOP:0: B:16:0x0037->B:26:0x0073], SYNTHETIC] */
    public final void disposeInteractions() {
        MutableInteractionSourceImpl mutableInteractionSourceImpl = this.interactionSource;
        MutableLongObjectMap mutableLongObjectMap = this.currentKeyPressInteractions;
        if (mutableInteractionSourceImpl != null) {
            PressInteraction.Press press = this.pressInteraction;
            if (press != null) {
                mutableInteractionSourceImpl.tryEmit(new PressInteraction.Cancel(press));
            }
            PressInteraction.Press press2 = this.indirectPointerPressInteraction;
            if (press2 != null) {
                mutableInteractionSourceImpl.tryEmit(new PressInteraction.Cancel(press2));
            }
            HoverInteraction$Enter hoverInteraction$Enter = this.hoverInteraction;
            if (hoverInteraction$Enter != null) {
                mutableInteractionSourceImpl.tryEmit(new HoverInteraction$Exit(hoverInteraction$Enter));
            }
            Object[] objArr = mutableLongObjectMap.values;
            long[] jArr = mutableLongObjectMap.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i = 0;
                while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                        if (i != length) {
                            break;
                            break;
                        }
                        i++;
                    } else {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                mutableInteractionSourceImpl.tryEmit(new PressInteraction.Cancel((PressInteraction.Press) objArr[(i << 3) + i3]));
                            }
                            j >>= 8;
                        }
                        if (i2 != 8) {
                            break;
                        } else if (i != length) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
        }
        this.pressInteraction = null;
        this.indirectPointerPressInteraction = null;
        this.hoverInteraction = null;
        mutableLongObjectMap.clear();
    }

    /* JADX INFO: renamed from: getExtendedTouchPadding-hWWAJMo, reason: not valid java name */
    public final long m30getExtendedTouchPaddinghWWAJMo(long j) {
        long jMo93toSizeXkaWNTQ = HitTestResultKt.requireLayoutNode(this).density.mo93toSizeXkaWNTQ(((ViewConfiguration) HitTestResultKt.currentValueOf(this, CompositionLocalsKt.LocalViewConfiguration)).mo550getMinimumTouchTargetSizeMYxV2XQ());
        float fMax = Math.max(0.0f, Float.intBitsToFloat((int) (jMo93toSizeXkaWNTQ >> 32)) - ((int) (j >> 32))) / 2.0f;
        return (((long) Float.floatToRawIntBits(Math.max(0.0f, Float.intBitsToFloat((int) (jMo93toSizeXkaWNTQ & 4294967295L)) - ((int) (j & 4294967295L))) / 2.0f)) & 4294967295L) | (Float.floatToRawIntBits(fMax) << 32);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final /* synthetic */ boolean getShouldClearDescendantSemantics() {
        return false;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final boolean getShouldMergeDescendantSemantics() {
        return true;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: getTouchBoundsExpansion-RZrCHBk, reason: not valid java name */
    public final long mo31getTouchBoundsExpansionRZrCHBk() {
        return TouchBoundsExpansion.None;
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public final Object getTraverseKey() {
        return this.traverseKey;
    }

    public final void handlePressInteractionCancel(boolean z) {
        MutableInteractionSourceImpl mutableInteractionSourceImpl = this.interactionSource;
        if (mutableInteractionSourceImpl != null) {
            StandaloneCoroutine standaloneCoroutine = this.delayJob;
            Continuation continuation = null;
            if (standaloneCoroutine == null || !standaloneCoroutine.isActive()) {
                PressInteraction.Press press = z ? this.indirectPointerPressInteraction : this.pressInteraction;
                if (press != null) {
                    PressInteraction.Cancel cancel = new PressInteraction.Cancel(press);
                    Job job = (Job) ((ContextScope) getCoroutineScope()).coroutineContext.get(Job.Key.$$INSTANCE);
                    JobKt.launch$default(getCoroutineScope(), null, new NavHostKt$NavHost$28$1(mutableInteractionSourceImpl, cancel, job != null ? job.invokeOnCompletion(new BackHandlerKt$$ExternalSyntheticLambda2(9, mutableInteractionSourceImpl, cancel)) : null, continuation, 3), 3);
                }
            } else {
                StandaloneCoroutine standaloneCoroutine2 = this.delayJob;
                if (standaloneCoroutine2 != null) {
                    standaloneCoroutine2.cancel((CancellationException) null);
                }
            }
            if (z) {
                this.indirectPointerPressInteraction = null;
            } else {
                this.pressInteraction = null;
            }
        }
    }

    /* JADX INFO: renamed from: handlePressInteractionRelease-3MmeM6k, reason: not valid java name */
    public final void m32handlePressInteractionRelease3MmeM6k(long j, boolean z) {
        MutableInteractionSourceImpl mutableInteractionSourceImpl = this.interactionSource;
        if (mutableInteractionSourceImpl != null) {
            StandaloneCoroutine standaloneCoroutine = this.delayJob;
            if (standaloneCoroutine == null || !standaloneCoroutine.isActive()) {
                PressInteraction.Press press = z ? this.indirectPointerPressInteraction : this.pressInteraction;
                if (press != null) {
                    JobKt.launch$default(getCoroutineScope(), null, new AbstractClickableNode$handlePressInteractionStart$1$2(press, mutableInteractionSourceImpl, null), 3);
                }
            } else {
                standaloneCoroutine.cancel((CancellationException) null);
                JobKt.launch$default(getCoroutineScope(), null, new ScrollableKt$semanticsScrollBy$2(standaloneCoroutine, j, mutableInteractionSourceImpl, (Continuation) null, 1), 3);
            }
            if (z) {
                this.indirectPointerPressInteraction = null;
            } else {
                this.pressInteraction = null;
            }
        }
    }

    public final void handlePressInteractionStart(IndirectPointerInputChange indirectPointerInputChange) {
        MutableInteractionSourceImpl mutableInteractionSourceImpl = this.interactionSource;
        if (mutableInteractionSourceImpl != null) {
            PressInteraction.Press press = new PressInteraction.Press(indirectPointerInputChange.position);
            Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
            HitTestResultKt.traverseAncestors(this, GestureNode.TraverseKey, new GestureNodeKt$$ExternalSyntheticLambda0(new BackHandlerKt$$ExternalSyntheticLambda2(12, indirectPointerInputChange, ref$BooleanRef), 0));
            Continuation continuation = null;
            if (ref$BooleanRef.element || Clickable_androidKt.isComposeRootInScrollableContainer(this)) {
                this.delayJob = JobKt.launch$default(getCoroutineScope(), null, new AbstractClickableNode$handlePressInteractionStart$1$1(mutableInteractionSourceImpl, press, this, continuation, 0), 3);
            } else {
                this.indirectPointerPressInteraction = press;
                JobKt.launch$default(getCoroutineScope(), null, new AbstractClickableNode$handlePressInteractionStart$1$2(mutableInteractionSourceImpl, press, null, 0), 3);
            }
        }
    }

    public final void initializeIndicationAndInteractionSourceIfNeeded() {
        if (this.indicationNode != null) {
            return;
        }
        IndicationNodeFactory indicationNodeFactory = this.useLocalIndication ? this.localIndicationNodeFactory : this.indicationNodeFactory;
        if (indicationNodeFactory != null) {
            if (this.interactionSource == null) {
                this.interactionSource = new MutableInteractionSourceImpl();
            }
            this.focusableNode.update(this.interactionSource);
            DelegatableNode delegatableNodeCreate = indicationNodeFactory.create(this.interactionSource);
            delegate(delegatableNodeCreate);
            this.indicationNode = delegatableNodeCreate;
        }
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final /* synthetic */ boolean interceptOutOfBoundsChildEvents() {
        return false;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final /* synthetic */ boolean isImportantForBounds() {
        return true;
    }

    @Override // androidx.compose.foundation.GestureConnection
    public final /* synthetic */ boolean isInterested(IndirectPointerInputChange indirectPointerInputChange) {
        return false;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onAttach() {
        onObservedReadsChanged();
        if (!this.lazilyCreateIndication) {
            initializeIndicationAndInteractionSourceIfNeeded();
        }
        if (this.enabled) {
            delegate(this.focusableNode);
        }
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        HoverInteraction$Enter hoverInteraction$Enter;
        MutableInteractionSourceImpl mutableInteractionSourceImpl = this.interactionSource;
        if (mutableInteractionSourceImpl != null && (hoverInteraction$Enter = this.hoverInteraction) != null) {
            mutableInteractionSourceImpl.tryEmit(new HoverInteraction$Exit(hoverInteraction$Enter));
        }
        this.hoverInteraction = null;
        SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImpl = this.pointerInputNode;
        if (suspendingPointerInputModifierNodeImpl != null) {
            suspendingPointerInputModifierNodeImpl.onCancelPointerInput();
        }
    }

    /* JADX INFO: renamed from: onClickKeyDownEvent-ZmokQxo, reason: not valid java name */
    public abstract boolean mo33onClickKeyDownEventZmokQxo(KeyEvent keyEvent);

    /* JADX INFO: renamed from: onClickKeyUpEvent-ZmokQxo, reason: not valid java name */
    public abstract void mo34onClickKeyUpEventZmokQxo(KeyEvent keyEvent);

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDensityChange() {
        onCancelPointerInput();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final void onDetach() {
        disposeInteractions();
        if (this.userProvidedInteractionSource == null) {
            this.interactionSource = null;
        }
        DelegatableNode delegatableNode = this.indicationNode;
        if (delegatableNode != null) {
            undelegate(delegatableNode);
        }
        this.indicationNode = null;
        GestureNode gestureNode = this.gestureNode;
        if (gestureNode != null) {
            undelegate(gestureNode);
        }
        this.gestureNode = null;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0079 A[RETURN] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    /* JADX INFO: renamed from: onKeyEvent-ZmokQxo, reason: not valid java name */
    public final boolean mo35onKeyEventZmokQxo(KeyEvent keyEvent) {
        boolean z;
        initializeIndicationAndInteractionSourceIfNeeded();
        long jM505getKeyZmokQxo = Key_androidKt.m505getKeyZmokQxo(keyEvent);
        boolean z2 = this.enabled;
        MutableLongObjectMap mutableLongObjectMap = this.currentKeyPressInteractions;
        if (z2 && Key_androidKt.m506getTypeZmokQxo(keyEvent) == 2 && ImageKt.m53isEnterZmokQxo(keyEvent)) {
            if (mutableLongObjectMap.containsKey(jM505getKeyZmokQxo)) {
                z = false;
            } else {
                PressInteraction.Press press = new PressInteraction.Press(this.centerOffset);
                mutableLongObjectMap.set(jM505getKeyZmokQxo, press);
                if (this.interactionSource != null) {
                    JobKt.launch$default(getCoroutineScope(), null, new AbstractClickableNode$onKeyEvent$1(this, press, null, 0), 3);
                }
                z = true;
            }
            if (mo33onClickKeyDownEventZmokQxo(keyEvent) || z) {
                return true;
            }
            return false;
        }
        if (this.enabled && Key_androidKt.m506getTypeZmokQxo(keyEvent) == 1 && ImageKt.m53isEnterZmokQxo(keyEvent)) {
            PressInteraction.Press press2 = (PressInteraction.Press) mutableLongObjectMap.remove(jM505getKeyZmokQxo);
            if (press2 != null) {
                if (this.interactionSource != null) {
                    JobKt.launch$default(getCoroutineScope(), null, new AbstractClickableNode$onKeyEvent$1(this, press2, null, 3), 3);
                }
                mo34onClickKeyUpEventZmokQxo(keyEvent);
            }
            if (press2 != null) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.compose.ui.node.ObserverModifierNode
    public final void onObservedReadsChanged() {
        if (this.useLocalIndication) {
            HitTestResultKt.observeReads(this, new AbstractClickableNode$$ExternalSyntheticLambda0(this, 0));
        }
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY, reason: not valid java name */
    public void mo36onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j) {
        SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImplCreatePointerInputNodeIfNeeded;
        long j2 = ((j >> 33) << 32) | (((j << 32) >> 33) & 4294967295L);
        this.centerOffset = (((long) Float.floatToRawIntBits((int) (j2 & 4294967295L))) & 4294967295L) | (((long) Float.floatToRawIntBits((int) (j2 >> 32))) << 32);
        initializeIndicationAndInteractionSourceIfNeeded();
        if (this.enabled) {
            if (this.gestureNode == null) {
                GestureNode gestureNode = new GestureNode(this);
                delegate(gestureNode);
                this.gestureNode = gestureNode;
            }
            if (pointerEventPass == PointerEventPass.Main) {
                int i = pointerEvent.type;
                Continuation continuation = null;
                if (i == 4) {
                    JobKt.launch$default(getCoroutineScope(), null, new AbstractClickableNode$onPointerEvent$1(this, continuation, 0), 3);
                } else if (i == 5) {
                    JobKt.launch$default(getCoroutineScope(), null, new AbstractClickableNode$onPointerEvent$1(this, continuation, 1), 3);
                }
            }
        }
        if (this.pointerInputNode == null && (suspendingPointerInputModifierNodeImplCreatePointerInputNodeIfNeeded = createPointerInputNodeIfNeeded()) != null) {
            delegate(suspendingPointerInputModifierNodeImplCreatePointerInputNodeIfNeeded);
            this.pointerInputNode = suspendingPointerInputModifierNodeImplCreatePointerInputNodeIfNeeded;
        }
        SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImpl = this.pointerInputNode;
        if (suspendingPointerInputModifierNodeImpl != null) {
            suspendingPointerInputModifierNodeImpl.mo36onPointerEventH0pRuoY(pointerEvent, pointerEventPass, j);
        }
    }

    @Override // androidx.compose.ui.input.key.KeyInputModifierNode
    /* JADX INFO: renamed from: onPreKeyEvent-ZmokQxo, reason: not valid java name */
    public final boolean mo37onPreKeyEventZmokQxo(KeyEvent keyEvent) {
        return false;
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final void onViewConfigurationChange() {
        onCancelPointerInput();
    }

    @Override // androidx.compose.ui.node.PointerInputModifierNode
    public final /* synthetic */ boolean sharePointerInputWithSiblings() {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0075  */
    /* JADX INFO: renamed from: updateCommon-O2vRcR0, reason: not valid java name */
    public final void m38updateCommonO2vRcR0(MutableInteractionSourceImpl mutableInteractionSourceImpl, IndicationNodeFactory indicationNodeFactory, boolean z, boolean z2, String str, Role role, Function0 function0) {
        boolean z3;
        boolean z4;
        DelegatableNode delegatableNode;
        if (Intrinsics.areEqual(this.userProvidedInteractionSource, mutableInteractionSourceImpl)) {
            z3 = false;
        } else {
            disposeInteractions();
            this.userProvidedInteractionSource = mutableInteractionSourceImpl;
            this.interactionSource = mutableInteractionSourceImpl;
            z3 = true;
        }
        if (!Intrinsics.areEqual(this.indicationNodeFactory, indicationNodeFactory)) {
            this.indicationNodeFactory = indicationNodeFactory;
            z3 = true;
        }
        if (this.useLocalIndication != z) {
            this.useLocalIndication = z;
            if (z) {
                onObservedReadsChanged();
            }
            z3 = true;
        }
        boolean z5 = this.enabled;
        FocusableNode focusableNode = this.focusableNode;
        if (z5 != z2) {
            if (z2) {
                delegate(focusableNode);
            } else {
                undelegate(focusableNode);
                disposeInteractions();
            }
            HitTestResultKt.invalidateSemantics(this);
            this.enabled = z2;
        }
        if (!Intrinsics.areEqual(this.onClickLabel, str)) {
            this.onClickLabel = str;
            HitTestResultKt.invalidateSemantics(this);
        }
        if (!Intrinsics.areEqual(this.role, role)) {
            this.role = role;
            HitTestResultKt.invalidateSemantics(this);
        }
        this.onClick = function0;
        boolean z6 = this.lazilyCreateIndication;
        MutableInteractionSourceImpl mutableInteractionSourceImpl2 = this.userProvidedInteractionSource;
        if (z6 != (mutableInteractionSourceImpl2 == null)) {
            boolean z7 = mutableInteractionSourceImpl2 == null;
            this.lazilyCreateIndication = z7;
            z4 = (z7 || this.indicationNode != null) ? z3 : true;
        }
        if (z4 && ((delegatableNode = this.indicationNode) != null || !this.lazilyCreateIndication)) {
            if (delegatableNode != null) {
                undelegate(delegatableNode);
            }
            this.indicationNode = null;
            initializeIndicationAndInteractionSourceIfNeeded();
        }
        focusableNode.update(this.interactionSource);
    }

    @Override // androidx.compose.foundation.GestureConnection
    public final /* synthetic */ boolean isInterested(PointerInputChange pointerInputChange) {
        return false;
    }

    public final void handlePressInteractionStart(PointerInputChange pointerInputChange) {
        boolean z;
        MutableInteractionSourceImpl mutableInteractionSourceImpl = this.interactionSource;
        if (mutableInteractionSourceImpl != null) {
            PressInteraction.Press press = new PressInteraction.Press(pointerInputChange.position);
            if (pointerInputChange == null) {
                z = ImageKt.getParentGestureConnection(this) != null;
            } else {
                Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
                HitTestResultKt.traverseAncestors(this, GestureNode.TraverseKey, new GestureNodeKt$$ExternalSyntheticLambda0(new BackHandlerKt$$ExternalSyntheticLambda2(13, pointerInputChange, ref$BooleanRef), 0));
                z = ref$BooleanRef.element;
            }
            Continuation continuation = null;
            if (z || Clickable_androidKt.isComposeRootInScrollableContainer(this)) {
                this.delayJob = JobKt.launch$default(getCoroutineScope(), null, new AbstractClickableNode$handlePressInteractionStart$1$1(mutableInteractionSourceImpl, press, this, continuation, 1), 3);
            } else {
                this.pressInteraction = press;
                JobKt.launch$default(getCoroutineScope(), null, new AbstractClickableNode$handlePressInteractionStart$1$2(mutableInteractionSourceImpl, press, null, 2), 3);
            }
        }
    }

    public void onCancelKeyInput() {
    }

    public void applyAdditionalSemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
    }
}
