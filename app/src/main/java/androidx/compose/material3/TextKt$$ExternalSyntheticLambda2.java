package androidx.compose.material3;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.camera.view.PreviewView;
import androidx.collection.IntListKt;
import androidx.collection.MutableIntList;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.foundation.FocusableNode;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.contextmenu.ContextMenuColors;
import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDragScope$1;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.HorizontalAlignElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowMeasurePolicy;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScope$CC;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.LazyListItemProviderImpl;
import androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1;
import androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1;
import androidx.compose.foundation.lazy.LazyListMeasureResult;
import androidx.compose.foundation.lazy.LazyListMeasuredItem;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.layout.DummyHandle;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo$Interval;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScopeImpl;
import androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItem;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.foundation.lazy.layout.LazySaveableStateHolder;
import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda3;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuData;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.foundation.text.contextmenu.internal.DefaultTextContextMenuDropdownProvider_androidKt;
import androidx.compose.foundation.text.contextmenu.internal.TextContextMenuHelperApi28;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviors_androidKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.material3.internal.TextFieldImplKt$DecoratedLabel$labelScope$1$1;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.RememberObserverHolder;
import androidx.compose.runtime.ReusableGapRememberObserverHolder;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.composer.gapbuffer.SlotWriter;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotId_jvmKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda1;
import com.github.kr328.clash.FilesActivity;
import com.github.kr328.clash.compose.LogsScreenKt;
import com.github.kr328.clash.compose.connections.ConnectionsScreenKt;
import com.github.kr328.clash.compose.connections.ProcessGroup;
import com.github.kr328.clash.compose.proxy.ProxyScreenKt;
import com.github.kr328.clash.core.model.ConnectionInfo;
import com.github.kr328.clash.design.compose.components.GlassSnackbarKt$GlassSnackbarHost$1$2$1$2$1;
import com.github.kr328.clash.design.model.LogFile;
import com.github.kr328.clash.service.model.Profile;
import com.google.android.gms.internal.mlkit_vision_common.zzit;
import com.google.android.gms.internal.mlkit_vision_common.zzjf;
import com.google.android.gms.internal.mlkit_vision_common.zzky;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import kotlinx.serialization.json.JsonImpl;
import okhttp3.Dispatcher;
import okhttp3.internal.connection.Exchange;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TextKt$$ExternalSyntheticLambda2 implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ TextKt$$ExternalSyntheticLambda2(int i, int i2, Object obj, Object obj2) {
        this.$r8$classId = i2;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    private final Object invoke$androidx$compose$material3$AlertDialogKt$$ExternalSyntheticLambda10(Object obj, Object obj2) {
        Function2 function2 = (Function2) this.f$0;
        Function2 function3 = (Function2) this.f$1;
        GapComposer gapComposer = (GapComposer) obj;
        int iIntValue = ((Integer) obj2).intValue();
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
            Modifier modifierThen = OffsetKt.padding(Modifier.Companion.$$INSTANCE, AlertDialogKt.TitlePadding).then(new HorizontalAlignElement(function2 == null ? Alignment.Companion.Start : Alignment.Companion.CenterHorizontally));
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            long j = gapComposer.compositeKeyHashCode;
            int i = (int) (j ^ (j >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifierThen);
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
            Stack.m295setimpl(gapComposer, Integer.valueOf(i), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m294reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m295setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            function3.invoke(gapComposer, 0);
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$androidx$compose$material3$ButtonKt$$ExternalSyntheticLambda4(Object obj, Object obj2) {
        PaddingValues paddingValues = (PaddingValues) this.f$0;
        ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) this.f$1;
        GapComposer gapComposer = (GapComposer) obj;
        int iIntValue = ((Integer) obj2).intValue();
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
            Modifier modifierPadding = OffsetKt.padding(SizeKt.m134defaultMinSizeVpY3zN4(Modifier.Companion.$$INSTANCE, ButtonDefaults.MinWidth, ButtonDefaults.MinHeight), paddingValues);
            RowMeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Center, Alignment.Companion.CenterVertically, gapComposer, 54);
            long j = gapComposer.compositeKeyHashCode;
            int i = (int) (j ^ (j >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifierPadding);
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer.useNode();
            }
            Stack.m295setimpl(gapComposer, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m295setimpl(gapComposer, Integer.valueOf(i), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m294reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m295setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            composableLambdaImpl.invoke((Object) RowScopeInstance.INSTANCE, (Object) gapComposer, (Object) 6);
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$androidx$compose$material3$ScaffoldKt$$ExternalSyntheticLambda6(Object obj, Object obj2) {
        ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) this.f$1;
        ScaffoldKt$ScaffoldLayout$contentPadding$1$1 scaffoldKt$ScaffoldLayout$contentPadding$1$1 = (ScaffoldKt$ScaffoldLayout$contentPadding$1$1) this.f$0;
        GapComposer gapComposer = (GapComposer) obj;
        int iIntValue = ((Integer) obj2).intValue();
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            long j = gapComposer.compositeKeyHashCode;
            int i = (int) (j ^ (j >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, Modifier.Companion.$$INSTANCE);
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
            Stack.m295setimpl(gapComposer, Integer.valueOf(i), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m294reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m295setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            composableLambdaImpl.invoke((Object) scaffoldKt$ScaffoldLayout$contentPadding$1$1, (Object) gapComposer, (Object) 6);
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$androidx$compose$material3$SnackbarHostKt$$ExternalSyntheticLambda2(Object obj, Object obj2) {
        ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) this.f$1;
        SnackbarHostState.SnackbarDataImpl snackbarDataImpl = (SnackbarHostState.SnackbarDataImpl) this.f$0;
        GapComposer gapComposer = (GapComposer) obj;
        int iIntValue = ((Integer) obj2).intValue();
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
            composableLambdaImpl.invoke((Object) snackbarDataImpl, (Object) gapComposer, (Object) 0);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$androidx$compose$material3$TooltipKt$$ExternalSyntheticLambda1(Object obj, Object obj2) {
        MutableState mutableState = (MutableState) this.f$0;
        Function2 function2 = (Function2) this.f$1;
        GapComposer gapComposer = (GapComposer) obj;
        int iIntValue = ((Integer) obj2).intValue();
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
            Object objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == Composer$Companion.Empty) {
                objRememberedValue = new TooltipKt$$ExternalSyntheticLambda7(mutableState, 0);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierOnGloballyPositioned = RulerKt.onGloballyPositioned(Modifier.Companion.$$INSTANCE, (Function1) objRememberedValue);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            long j = gapComposer.compositeKeyHashCode;
            int i = (int) (j ^ (j >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifierOnGloballyPositioned);
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
            Stack.m295setimpl(gapComposer, Integer.valueOf(i), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m294reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m295setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            function2.invoke(gapComposer, 0);
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$androidx$compose$material3$internal$TextFieldImplKt$$ExternalSyntheticLambda0(Object obj, Object obj2) {
        Function3 function3 = (Function3) this.f$0;
        TextFieldImplKt$DecoratedLabel$labelScope$1$1 textFieldImplKt$DecoratedLabel$labelScope$1$1 = (TextFieldImplKt$DecoratedLabel$labelScope$1$1) this.f$1;
        GapComposer gapComposer = (GapComposer) obj;
        int iIntValue = ((Integer) obj2).intValue();
        if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
            function3.invoke(textFieldImplKt$DecoratedLabel$labelScope$1$1, gapComposer, 6);
        } else {
            gapComposer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$androidx$compose$runtime$GapComposerKt$$ExternalSyntheticLambda1(Object obj, Object obj2) {
        zzky zzkyVar = (zzky) this.f$0;
        SlotWriter slotWriter = (SlotWriter) this.f$1;
        int iIntValue = ((Integer) obj).intValue();
        if (obj2 instanceof ComposeNodeLifecycleCallback) {
            ((MutableVector) zzkyVar.zze).add((ComposeNodeLifecycleCallback) obj2);
        } else if (!(obj2 instanceof ReusableGapRememberObserverHolder)) {
            if (obj2 instanceof RememberObserverHolder) {
                Stack.removeData(slotWriter, iIntValue, obj2);
                zzkyVar.forgetting((RememberObserverHolder) obj2);
            } else if (obj2 instanceof RecomposeScopeImpl) {
                Stack.removeData(slotWriter, iIntValue, obj2);
                ((RecomposeScopeImpl) obj2).release();
            }
        }
        return Unit.INSTANCE;
    }

    private final Object invoke$com$github$kr328$clash$FilesActivity$$ExternalSyntheticLambda5(Object obj, Object obj2) {
        ((Integer) obj2).getClass();
        int i = FilesActivity.$r8$clinit;
        ((FilesActivity) this.f$0).Content((String) this.f$1, (GapComposer) obj, Stack.updateChangedFlags(1));
        return Unit.INSTANCE;
    }

    private final Object invoke$com$github$kr328$clash$compose$LogsScreenKt$$ExternalSyntheticLambda3(Object obj, Object obj2) {
        ((Integer) obj2).getClass();
        LogsScreenKt.LogFileRow((LogFile) this.f$0, (Function0) this.f$1, (GapComposer) obj, Stack.updateChangedFlags(9));
        return Unit.INSTANCE;
    }

    private final Object invoke$com$github$kr328$clash$compose$connections$ConnectionsScreenKt$$ExternalSyntheticLambda29(Object obj, Object obj2) {
        ((Integer) obj2).getClass();
        ConnectionsScreenKt.ProcessCard((ProcessGroup) this.f$0, (Function0) this.f$1, (GapComposer) obj, Stack.updateChangedFlags(1));
        return Unit.INSTANCE;
    }

    private final Object invoke$com$github$kr328$clash$compose$connections$ConnectionsScreenKt$ConnectionsScreen$5$2$$ExternalSyntheticLambda1(Object obj, Object obj2) {
        MutableState mutableState = (MutableState) this.f$0;
        MutableState mutableState2 = (MutableState) this.f$1;
        Boolean bool = (Boolean) obj2;
        bool.booleanValue();
        JsonImpl jsonImpl = ConnectionsScreenKt.connectionJson;
        mutableState.setValue((ConnectionInfo) obj);
        mutableState2.setValue(bool);
        return Unit.INSTANCE;
    }

    private final Object invoke$com$github$kr328$clash$compose$profiles$ProfilesScreenKt$$ExternalSyntheticLambda5(Object obj, Object obj2) {
        ((Integer) obj2).getClass();
        zzit.EmptyProfilesContent((Function0) this.f$0, (Modifier) this.f$1, (GapComposer) obj, Stack.updateChangedFlags(1));
        return Unit.INSTANCE;
    }

    private final Object invoke$com$github$kr328$clash$compose$proxy$ProxyScreenKt$$ExternalSyntheticLambda7(Object obj, Object obj2) {
        ((Integer) obj2).getClass();
        ProxyScreenKt.EmptyMessage((ImageVector) this.f$0, (String) this.f$1, (GapComposer) obj, Stack.updateChangedFlags(1));
        return Unit.INSTANCE;
    }

    private final Object invoke$com$github$kr328$clash$compose$sharetotv$ShareToTvScreenKt$$ExternalSyntheticLambda1(Object obj, Object obj2) {
        ((Integer) obj2).getClass();
        zzjf.ProfileItem((Profile) this.f$0, (Function0) this.f$1, (GapComposer) obj, Stack.updateChangedFlags(1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:461:0x0a08  */
    /* JADX WARN: Code duplicated, block: B:552:0x0b95  */
    /* JADX WARN: Code duplicated, block: B:561:0x0bbb  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r25v12 */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Type inference failed for: r7v31 */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.util.Collection, java.util.List] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        int i;
        int i2;
        float fMo112getSpacingD9Ej5fM;
        long j;
        int i3;
        int i4;
        ?? arrayList;
        IntRange intRange;
        long j2;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        LazyListMeasuredItem lazyListMeasuredItem;
        int i10;
        List arrayList2;
        int i11;
        float f;
        List arrayList3;
        LazyListMeasuredItem lazyListMeasuredItem2;
        int i12;
        boolean z;
        ArrayDeque arrayDeque;
        int i13;
        List list;
        Integer numValueOf;
        Integer numValueOf2;
        SubcomposeMeasureScope subcomposeMeasureScope;
        LazyListMeasureResult lazyListMeasureResult;
        int i14;
        MutableIntList mutableIntList;
        int i15;
        boolean z2;
        Object obj3;
        int i16;
        int i17;
        int iMax;
        int i18;
        int i19;
        int[] iArr;
        int i20;
        IntProgression intProgression;
        int i21 = this.$r8$classId;
        NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
        TextRange textRange = null;
        int i22 = 0;
        Object obj4 = this.f$1;
        Object obj5 = this.f$0;
        switch (i21) {
            case 0:
                ((Integer) obj2).getClass();
                TextKt.ProvideTextStyle((TextStyle) obj5, (ComposableLambdaImpl) obj4, (GapComposer) obj, Stack.updateChangedFlags(1));
                return Unit.INSTANCE;
            case 1:
                ((Integer) obj2).getClass();
                ImageKt.Canvas((Modifier) obj5, (Function1) obj4, (GapComposer) obj, Stack.updateChangedFlags(1));
                return Unit.INSTANCE;
            case 2:
                ((Integer) obj2).getClass();
                ((ContextMenuScope) obj5).Content$foundation((ContextMenuColors) obj4, (GapComposer) obj, Stack.updateChangedFlags(1));
                return Unit.INSTANCE;
            case 3:
                float fFloatValue = ((Float) obj).floatValue();
                ((AnchoredDraggableState$anchoredDragScope$1) obj5).dragTo(fFloatValue, ((Float) obj2).floatValue());
                ((Ref$FloatRef) obj4).element = fFloatValue;
                return Unit.INSTANCE;
            case 4:
                LazyLayoutItemContentFactory lazyLayoutItemContentFactory = (LazyLayoutItemContentFactory) obj5;
                LazyLayoutItemContentFactory.CachedItemContent cachedItemContent = (LazyLayoutItemContentFactory.CachedItemContent) obj4;
                Object obj6 = cachedItemContent.key;
                GapComposer gapComposer = (GapComposer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    LazyListItemProviderImpl lazyListItemProviderImpl = (LazyListItemProviderImpl) lazyLayoutItemContentFactory.itemProvider.invoke();
                    int index = cachedItemContent.index;
                    if (index >= lazyListItemProviderImpl.getItemCount() || !lazyListItemProviderImpl.getKey(index).equals(obj6)) {
                        index = lazyListItemProviderImpl.keyIndexMap.getIndex(obj6);
                        i = -1;
                        if (index != -1) {
                            cachedItemContent.index = index;
                        }
                    } else {
                        i = -1;
                    }
                    int i23 = index;
                    if (i23 != i) {
                        gapComposer.startReplaceGroup(-1664741271);
                        LazyLayoutKt.m153SkippableItemJVlU9Rs(lazyListItemProviderImpl, lazyLayoutItemContentFactory.saveableStateHolder, i23, obj6, gapComposer, 0);
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(-1664505826);
                        gapComposer.end(false);
                    }
                    boolean zChangedInstance = gapComposer.changedInstance(cachedItemContent);
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new Recomposer$$ExternalSyntheticLambda0(10, cachedItemContent);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    Stack.DisposableEffect(obj6, (Function1) objRememberedValue, gapComposer);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                return Unit.INSTANCE;
            case 5:
                boolean zM720equalsimpl0 = IntSize.m720equalsimpl0(0L, 0L);
                LazyListKt$rememberLazyListMeasurePolicy$1$1 lazyListKt$rememberLazyListMeasurePolicy$1$1 = (LazyListKt$rememberLazyListMeasurePolicy$1$1) obj4;
                SubcomposeMeasureScope subcomposeMeasureScope2 = (SubcomposeMeasureScope) obj;
                LazyLayoutMeasureScopeImpl lazyLayoutMeasureScopeImpl = new LazyLayoutMeasureScopeImpl((LazyLayoutItemContentFactory) obj5, subcomposeMeasureScope2);
                long j3 = ((Constraints) obj2).value;
                Arrangement.Horizontal horizontal = lazyListKt$rememberLazyListMeasurePolicy$1$1.$horizontalArrangement;
                Arrangement.Vertical vertical = lazyListKt$rememberLazyListMeasurePolicy$1$1.$verticalArrangement;
                boolean z3 = lazyListKt$rememberLazyListMeasurePolicy$1$1.$reverseLayout;
                PaddingValuesImpl paddingValuesImpl = lazyListKt$rememberLazyListMeasurePolicy$1$1.$contentPadding;
                boolean z4 = lazyListKt$rememberLazyListMeasurePolicy$1$1.$isVertical;
                LazyListState lazyListState = lazyListKt$rememberLazyListMeasurePolicy$1$1.$state;
                lazyListState.measurementScopeInvalidator.getValue();
                boolean z5 = lazyListState.hasLookaheadOccurred || subcomposeMeasureScope2.isLookingAhead();
                Orientation orientation = Orientation.Horizontal;
                Orientation orientation2 = Orientation.Vertical;
                ImageKt.m49checkScrollableContainerConstraintsK40F9xA(j3, z4 ? orientation2 : orientation);
                int iMo86roundToPx0680j_4 = z4 ? subcomposeMeasureScope2.mo86roundToPx0680j_4(paddingValuesImpl.mo118calculateLeftPaddingu2uoSUM(subcomposeMeasureScope2.getLayoutDirection())) : subcomposeMeasureScope2.mo86roundToPx0680j_4(OffsetKt.calculateStartPadding(paddingValuesImpl, subcomposeMeasureScope2.getLayoutDirection()));
                int iMo86roundToPx0680j_5 = z4 ? subcomposeMeasureScope2.mo86roundToPx0680j_4(paddingValuesImpl.mo119calculateRightPaddingu2uoSUM(subcomposeMeasureScope2.getLayoutDirection())) : subcomposeMeasureScope2.mo86roundToPx0680j_4(OffsetKt.calculateEndPadding(paddingValuesImpl, subcomposeMeasureScope2.getLayoutDirection()));
                int iMo86roundToPx0680j_6 = subcomposeMeasureScope2.mo86roundToPx0680j_4(paddingValuesImpl.top);
                int iMo86roundToPx0680j_7 = subcomposeMeasureScope2.mo86roundToPx0680j_4(paddingValuesImpl.bottom);
                int i24 = iMo86roundToPx0680j_6 + iMo86roundToPx0680j_7;
                int i25 = iMo86roundToPx0680j_4 + iMo86roundToPx0680j_5;
                int i26 = z4 ? i24 : i25;
                if (z4 && !z3) {
                    i2 = iMo86roundToPx0680j_6;
                } else if (z4 && z3) {
                    i2 = iMo86roundToPx0680j_7;
                } else {
                    i2 = (z4 || z3) ? iMo86roundToPx0680j_5 : iMo86roundToPx0680j_4;
                }
                int i27 = i26 - i2;
                long jM693offsetNN6EwU = ConstraintsKt.m693offsetNN6EwU(-i25, -i24, j3);
                LazyListItemProviderImpl lazyListItemProviderImpl2 = (LazyListItemProviderImpl) lazyListKt$rememberLazyListMeasurePolicy$1$1.$itemProviderLambda.invoke();
                LazyItemScopeImpl lazyItemScopeImpl = lazyListItemProviderImpl2.itemScope;
                int iM683getMaxWidthimpl = Constraints.m683getMaxWidthimpl(jM693offsetNN6EwU);
                int iM682getMaxHeightimpl = Constraints.m682getMaxHeightimpl(jM693offsetNN6EwU);
                lazyItemScopeImpl.maxWidthState.setIntValue(iM683getMaxWidthimpl);
                lazyItemScopeImpl.maxHeightState.setIntValue(iM682getMaxHeightimpl);
                if (z4) {
                    if (vertical == null) {
                        throw LazyItemScope$CC.m("null verticalArrangement when isVertical == true");
                    }
                    fMo112getSpacingD9Ej5fM = vertical.mo112getSpacingD9Ej5fM();
                } else {
                    if (horizontal == null) {
                        throw LazyItemScope$CC.m("null horizontalAlignment when isVertical == false");
                    }
                    fMo112getSpacingD9Ej5fM = horizontal.mo112getSpacingD9Ej5fM();
                }
                int iMo86roundToPx0680j_8 = subcomposeMeasureScope2.mo86roundToPx0680j_4(fMo112getSpacingD9Ej5fM);
                int itemCount = lazyListItemProviderImpl2.getItemCount();
                int iM682getMaxHeightimpl2 = z4 ? Constraints.m682getMaxHeightimpl(j3) - i24 : Constraints.m683getMaxWidthimpl(j3) - i25;
                boolean z6 = lazyListKt$rememberLazyListMeasurePolicy$1$1.$reverseLayout;
                if (!z6 || iM682getMaxHeightimpl2 > 0) {
                    j = ((long) iMo86roundToPx0680j_4) << 32;
                } else {
                    if (!z4) {
                        iMo86roundToPx0680j_4 += iM682getMaxHeightimpl2;
                    }
                    if (z4) {
                        iMo86roundToPx0680j_6 += iM682getMaxHeightimpl2;
                    }
                    j = ((long) iMo86roundToPx0680j_4) << 32;
                }
                LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1 = new LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1(jM693offsetNN6EwU, lazyListKt$rememberLazyListMeasurePolicy$1$1.$isVertical, lazyListItemProviderImpl2, lazyLayoutMeasureScopeImpl, itemCount, iMo86roundToPx0680j_8, lazyListKt$rememberLazyListMeasurePolicy$1$1.$horizontalAlignment, lazyListKt$rememberLazyListMeasurePolicy$1$1.$verticalAlignment, z6, i2, i27, (((long) iMo86roundToPx0680j_6) & 4294967295L) | j, lazyListKt$rememberLazyListMeasurePolicy$1$1.$state);
                int i28 = i2;
                Snapshot currentThreadSnapshot = SnapshotId_jvmKt.getCurrentThreadSnapshot();
                Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                Snapshot snapshotMakeCurrentNonObservable = SnapshotId_jvmKt.makeCurrentNonObservable(currentThreadSnapshot);
                try {
                    Exchange exchange = lazyListState.scrollPosition;
                    int i29 = iM682getMaxHeightimpl2;
                    int intValue = ((ParcelableSnapshotMutableIntState) exchange.call).getIntValue();
                    int iFindIndexByKey = LazyLayoutKt.findIndexByKey(intValue, lazyListItemProviderImpl2, exchange.codec);
                    if (intValue != iFindIndexByKey) {
                        i4 = i28;
                        ((ParcelableSnapshotMutableIntState) exchange.call).setIntValue(iFindIndexByKey);
                        LazyLayoutNearestRangeState lazyLayoutNearestRangeState = (LazyLayoutNearestRangeState) exchange.connection;
                        i3 = iFindIndexByKey;
                        if (intValue != lazyLayoutNearestRangeState.lastFirstVisibleItem) {
                            lazyLayoutNearestRangeState.lastFirstVisibleItem = intValue;
                            int i30 = (intValue / 30) * 30;
                            lazyLayoutNearestRangeState.value$delegate.setValue(RangesKt.until(Math.max(i30 - 100, 0), i30 + 130));
                        }
                    } else {
                        i3 = iFindIndexByKey;
                        i4 = i28;
                    }
                    int intValue2 = ((ParcelableSnapshotMutableIntState) exchange.finder).getIntValue();
                    Unit unit = Unit.INSTANCE;
                    SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    LazyLayoutPinnedItemList lazyLayoutPinnedItemList = lazyListState.pinnedItems;
                    PreviewView.AnonymousClass1 anonymousClass1 = lazyListState.beyondBoundsInfo;
                    MutableVector mutableVector = (MutableVector) anonymousClass1.this$0;
                    boolean z7 = mutableVector.size != 0;
                    char c = ' ';
                    List list2 = EmptyList.INSTANCE;
                    if (z7 || !lazyLayoutPinnedItemList.items.isEmpty()) {
                        arrayList = new ArrayList();
                        if (((MutableVector) anonymousClass1.this$0).size != 0) {
                            int i31 = mutableVector.size;
                            if (i31 == 0) {
                                throw new NoSuchElementException("MutableVector is empty.");
                            }
                            Object[] objArr = mutableVector.content;
                            int i32 = ((LazyLayoutBeyondBoundsInfo$Interval) objArr[0]).start;
                            int i33 = 0;
                            while (i33 < i31) {
                                int i34 = i33;
                                int i35 = ((LazyLayoutBeyondBoundsInfo$Interval) objArr[i33]).start;
                                if (i35 < i32) {
                                    i32 = i35;
                                }
                                i33 = i34 + 1;
                            }
                            if (i32 < 0) {
                                InlineClassHelperKt.throwIllegalArgumentException("negative minIndex");
                            }
                            int i36 = mutableVector.size;
                            if (i36 == 0) {
                                throw new NoSuchElementException("MutableVector is empty.");
                            }
                            Object[] objArr2 = mutableVector.content;
                            int i37 = ((LazyLayoutBeyondBoundsInfo$Interval) objArr2[0]).end;
                            int i38 = 0;
                            while (i38 < i36) {
                                Object[] objArr3 = objArr2;
                                int i39 = ((LazyLayoutBeyondBoundsInfo$Interval) objArr2[i38]).end;
                                if (i39 > i37) {
                                    i37 = i39;
                                }
                                i38++;
                                objArr2 = objArr3;
                            }
                            intRange = new IntRange(i32, Math.min(i37, lazyListItemProviderImpl2.getItemCount() - 1), 1);
                        } else {
                            intRange = IntRange.EMPTY;
                        }
                        int size = lazyLayoutPinnedItemList.items.size();
                        for (int i40 = 0; i40 < size; i40++) {
                            LazyLayoutPinnableItem lazyLayoutPinnableItem = (LazyLayoutPinnableItem) lazyLayoutPinnedItemList.get(i40);
                            int iFindIndexByKey2 = LazyLayoutKt.findIndexByKey(lazyLayoutPinnableItem.index, lazyListItemProviderImpl2, lazyLayoutPinnableItem.key);
                            int i41 = intRange.first;
                            if ((iFindIndexByKey2 > intRange.last || i41 > iFindIndexByKey2) && iFindIndexByKey2 >= 0 && iFindIndexByKey2 < lazyListItemProviderImpl2.getItemCount()) {
                                arrayList.add(Integer.valueOf(iFindIndexByKey2));
                            }
                        }
                        int i42 = intRange.first;
                        int i43 = intRange.last;
                        if (i42 <= i43) {
                            while (true) {
                                arrayList.add(Integer.valueOf(i42));
                                if (i42 != i43) {
                                    i42++;
                                }
                            }
                        }
                    } else {
                        intValue2 = intValue2;
                        c = ' ';
                        arrayList = list2;
                    }
                    float fFloatValue2 = (subcomposeMeasureScope2.isLookingAhead() || !z5) ? lazyListState.scrollToBeConsumed : ((Number) ((AnimationState) lazyListState._lazyLayoutScrollDeltaBetweenPasses.val$requestCancellationFuture).value$delegate.getValue()).floatValue();
                    boolean z8 = lazyListKt$rememberLazyListMeasurePolicy$1$1.$reverseLayout;
                    LazyLayoutItemAnimator lazyLayoutItemAnimator = lazyListState.itemAnimator;
                    boolean zIsLookingAhead = subcomposeMeasureScope2.isLookingAhead();
                    CoroutineScope coroutineScope = lazyListKt$rememberLazyListMeasurePolicy$1$1.$coroutineScope;
                    MutableState mutableState = lazyListState.placementScopeInvalidator;
                    DummyHandle dummyHandle = lazyListKt$rememberLazyListMeasurePolicy$1$1.$stickyItemsPlacement;
                    if (i4 < 0) {
                        InlineClassHelperKt.throwIllegalArgumentException("invalid beforeContentPadding");
                    }
                    if (i27 < 0) {
                        InlineClassHelperKt.throwIllegalArgumentException("invalid afterContentPadding");
                    }
                    EmptyMap emptyMap = EmptyMap.INSTANCE;
                    LazyListItemProviderImpl lazyListItemProviderImpl3 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1.itemProvider;
                    if (itemCount <= 0) {
                        int iM685getMinWidthimpl = Constraints.m685getMinWidthimpl(jM693offsetNN6EwU);
                        int iM684getMinHeightimpl = Constraints.m684getMinHeightimpl(jM693offsetNN6EwU);
                        lazyLayoutItemAnimator.onMeasured(iM685getMinWidthimpl, iM684getMinHeightimpl, new ArrayList(), lazyListItemProviderImpl3.keyIndexMap, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1, zIsLookingAhead, z5, 0, 0);
                        if (!zIsLookingAhead) {
                            lazyLayoutItemAnimator.m152getMinSizeToFitDisappearingItemsYbymL2g();
                            if (!zM720equalsimpl0) {
                                iM685getMinWidthimpl = ConstraintsKt.m692constrainWidthK40F9xA((int) 0, jM693offsetNN6EwU);
                                iM684getMinHeightimpl = ConstraintsKt.m691constrainHeightK40F9xA((int) 0, jM693offsetNN6EwU);
                            }
                        }
                        subcomposeMeasureScope = subcomposeMeasureScope2;
                        lazyListMeasureResult = new LazyListMeasureResult(null, 0, false, 0.0f, subcomposeMeasureScope.layout(ConstraintsKt.m692constrainWidthK40F9xA(iM685getMinWidthimpl + i25, j3), ConstraintsKt.m691constrainHeightK40F9xA(iM684getMinHeightimpl + i24, j3), emptyMap, new BasicTextKt$$ExternalSyntheticLambda3(14)), 0.0f, false, coroutineScope, lazyLayoutMeasureScopeImpl, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1.childConstraints, list2, -i4, i29 + i27, 0, z8, z4 ? orientation2 : orientation, i27, iMo86roundToPx0680j_8);
                    } else {
                        int i44 = i3;
                        float f2 = fFloatValue2;
                        int i45 = itemCount;
                        LazyLayoutMeasureScopeImpl lazyLayoutMeasureScopeImpl2 = lazyLayoutMeasureScopeImpl;
                        int i46 = i44;
                        int i47 = i4;
                        if (i46 >= i45) {
                            i46 = i45 - 1;
                            intValue2 = 0;
                        }
                        int iRound = Math.round(f2);
                        int i48 = intValue2 - iRound;
                        if (i46 == 0 && i48 < 0) {
                            iRound += i48;
                            i48 = 0;
                        }
                        int i49 = i46;
                        ArrayDeque arrayDeque2 = new ArrayDeque();
                        int i50 = -i47;
                        int i51 = i50 + (iMo86roundToPx0680j_8 < 0 ? iMo86roundToPx0680j_8 : 0);
                        int i52 = i48 + i51;
                        int iMax2 = 0;
                        while (true) {
                            j2 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1.childConstraints;
                            if (i52 < 0 && i49 > 0) {
                                MutableState mutableState2 = mutableState;
                                int i53 = i49 - 1;
                                LazyListMeasuredItem lazyListMeasuredItemM147getAndMeasure0kLqBqw = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1.m147getAndMeasure0kLqBqw(i53, j2);
                                arrayDeque2.add(0, lazyListMeasuredItemM147getAndMeasure0kLqBqw);
                                iMax2 = Math.max(iMax2, lazyListMeasuredItemM147getAndMeasure0kLqBqw.crossAxisSize);
                                i52 += lazyListMeasuredItemM147getAndMeasure0kLqBqw.mainAxisSizeWithSpacings;
                                i49 = i53;
                                mutableState = mutableState2;
                            }
                        }
                        MutableState mutableState3 = mutableState;
                        if (i52 < i51) {
                            iRound -= i51 - i52;
                            i52 = i51;
                        }
                        int i54 = iRound;
                        int i55 = i52 - i51;
                        int i56 = i29 + i27;
                        int i57 = iMax2;
                        int i58 = i56 < 0 ? 0 : i56;
                        int i59 = i50;
                        int i60 = -i55;
                        int i61 = i55;
                        int i62 = i49;
                        int i63 = 0;
                        boolean z9 = false;
                        while (i63 < arrayDeque2.size) {
                            if (i60 >= i58) {
                                arrayDeque2.removeAt(i63);
                                Unit unit2 = Unit.INSTANCE;
                                z9 = true;
                            } else {
                                i62++;
                                i60 += ((LazyListMeasuredItem) arrayDeque2.get(i63)).mainAxisSizeWithSpacings;
                                i63++;
                            }
                        }
                        int iMax3 = i57;
                        int i64 = i62;
                        boolean z10 = z9;
                        while (i64 < i45 && (i60 < i58 || i60 <= 0 || arrayDeque2.isEmpty())) {
                            int i65 = i58;
                            LazyListMeasuredItem lazyListMeasuredItemM147getAndMeasure0kLqBqw2 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1.m147getAndMeasure0kLqBqw(i64, j2);
                            int i66 = i45;
                            int i67 = lazyListMeasuredItemM147getAndMeasure0kLqBqw2.mainAxisSizeWithSpacings;
                            i60 += i67;
                            if (i60 > i51 || i64 == i66 - 1) {
                                int iMax4 = Math.max(iMax3, lazyListMeasuredItemM147getAndMeasure0kLqBqw2.crossAxisSize);
                                arrayDeque2.addLast(lazyListMeasuredItemM147getAndMeasure0kLqBqw2);
                                iMax3 = iMax4;
                            } else {
                                i61 -= i67;
                                Unit unit3 = Unit.INSTANCE;
                                i49 = i64 + 1;
                                z10 = true;
                            }
                            i64++;
                            i58 = i65;
                            i45 = i66;
                        }
                        int i68 = i45;
                        if (i60 < i29) {
                            int i69 = i29 - i60;
                            i60 += i69;
                            int i70 = i61 - i69;
                            while (i70 < i47 && i49 > 0) {
                                int i71 = i69;
                                int i72 = i49 - 1;
                                int i73 = i70;
                                LazyListMeasuredItem lazyListMeasuredItemM147getAndMeasure0kLqBqw3 = lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1.m147getAndMeasure0kLqBqw(i72, j2);
                                i49 = i72;
                                arrayDeque2.add(0, lazyListMeasuredItemM147getAndMeasure0kLqBqw3);
                                iMax3 = Math.max(iMax3, lazyListMeasuredItemM147getAndMeasure0kLqBqw3.crossAxisSize);
                                i70 = i73 + lazyListMeasuredItemM147getAndMeasure0kLqBqw3.mainAxisSizeWithSpacings;
                                i69 = i71;
                            }
                            int i74 = i70;
                            i6 = i54 + i69;
                            if (i74 < 0) {
                                i6 += i74;
                                i60 += i74;
                                i5 = iMax3;
                                i7 = i49;
                                i8 = 0;
                            } else {
                                i5 = iMax3;
                                i8 = i74;
                                i7 = i49;
                            }
                        } else {
                            i5 = iMax3;
                            i6 = i54;
                            i7 = i49;
                            i8 = i61;
                        }
                        int i75 = i64;
                        float f3 = (Integer.signum(Math.round(f2)) != Integer.signum(i6) || Math.abs(Math.round(f2)) < Math.abs(i6)) ? f2 : i6;
                        float f4 = f2 - f3;
                        float f5 = 0.0f;
                        if (zIsLookingAhead && i6 > i54 && f4 <= 0.0f) {
                            f5 = (i6 - i54) + f4;
                        }
                        float f6 = f5;
                        if (i8 < 0) {
                            InlineClassHelperKt.throwIllegalArgumentException("negative currentFirstItemScrollOffset");
                        }
                        int i76 = -i8;
                        LazyListMeasuredItem lazyListMeasuredItem3 = (LazyListMeasuredItem) arrayDeque2.first();
                        if (i47 > 0 || iMo86roundToPx0680j_8 < 0) {
                            int i77 = i8;
                            int size2 = arrayDeque2.getSize();
                            LazyListMeasuredItem lazyListMeasuredItem4 = lazyListMeasuredItem3;
                            int i78 = i77;
                            int i79 = 0;
                            while (i79 < size2) {
                                int i80 = size2;
                                int i81 = ((LazyListMeasuredItem) arrayDeque2.get(i79)).mainAxisSizeWithSpacings;
                                if (i78 == 0 || i81 > i78 || i79 == AppCompatHintHelper.getLastIndex(arrayDeque2)) {
                                    i9 = i78;
                                    lazyListMeasuredItem = lazyListMeasuredItem4;
                                } else {
                                    i78 -= i81;
                                    i79++;
                                    lazyListMeasuredItem4 = (LazyListMeasuredItem) arrayDeque2.get(i79);
                                    size2 = i80;
                                }
                            }
                            i9 = i78;
                            lazyListMeasuredItem = lazyListMeasuredItem4;
                        } else {
                            i9 = i8;
                            lazyListMeasuredItem = lazyListMeasuredItem3;
                        }
                        int iMax5 = Math.max(0, i7);
                        int i82 = i7 - 1;
                        if (iMax5 <= i82) {
                            arrayList2 = null;
                            while (true) {
                                if (arrayList2 == null) {
                                    arrayList2 = new ArrayList();
                                }
                                i10 = i76;
                                arrayList2.add(lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1.m147getAndMeasure0kLqBqw(i82, j2));
                                if (i82 != iMax5) {
                                    i82--;
                                    i76 = i10;
                                }
                            }
                        } else {
                            i10 = i76;
                            arrayList2 = null;
                        }
                        int size3 = arrayList.size() - 1;
                        if (size3 >= 0) {
                            while (true) {
                                int i83 = size3 - 1;
                                int iIntValue2 = ((Number) arrayList.get(size3)).intValue();
                                if (iIntValue2 < iMax5) {
                                    if (arrayList2 == null) {
                                        arrayList2 = new ArrayList();
                                    }
                                    arrayList2.add(lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1.m147getAndMeasure0kLqBqw(iIntValue2, j2));
                                }
                                if (i83 >= 0) {
                                    size3 = i83;
                                }
                            }
                        }
                        if (arrayList2 == null) {
                            arrayList2 = list2;
                        }
                        int iMax6 = i5;
                        int i84 = 0;
                        for (int size4 = arrayList2.size(); i84 < size4; size4 = size4) {
                            iMax6 = Math.max(iMax6, ((LazyListMeasuredItem) arrayList2.get(i84)).crossAxisSize);
                            i84++;
                        }
                        int iMin = Math.min(((LazyListMeasuredItem) CollectionsKt.last(arrayDeque2)).index, i68 - 1);
                        int i85 = ((LazyListMeasuredItem) CollectionsKt.last(arrayDeque2)).index + 1;
                        if (i85 <= iMin) {
                            List arrayList4 = null;
                            while (true) {
                                if (arrayList4 == null) {
                                    arrayList4 = new ArrayList();
                                }
                                i11 = iMax6;
                                f = f3;
                                arrayList3 = arrayList4;
                                arrayList3.add(lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1.m147getAndMeasure0kLqBqw(i85, j2));
                                if (i85 != iMin) {
                                    i85++;
                                    arrayList4 = arrayList3;
                                    iMax6 = i11;
                                    f3 = f;
                                }
                            }
                        } else {
                            i11 = iMax6;
                            f = f3;
                            arrayList3 = null;
                        }
                        if (arrayList3 != null && ((LazyListMeasuredItem) CollectionsKt.last(arrayList3)).index > iMin) {
                            iMin = ((LazyListMeasuredItem) CollectionsKt.last(arrayList3)).index;
                        }
                        int size5 = arrayList.size();
                        int i86 = 0;
                        ?? r7 = arrayList;
                        while (i86 < size5) {
                            ?? r25 = r7;
                            int iIntValue3 = ((Number) r7.get(i86)).intValue();
                            if (iIntValue3 > iMin) {
                                if (arrayList3 == null) {
                                    arrayList3 = new ArrayList();
                                }
                                arrayList3.add(lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1.m147getAndMeasure0kLqBqw(iIntValue3, j2));
                            }
                            i86++;
                            r7 = r25;
                        }
                        if (arrayList3 == null) {
                            arrayList3 = list2;
                        }
                        int size6 = arrayList3.size();
                        int iMax7 = i11;
                        for (int i87 = 0; i87 < size6; i87++) {
                            iMax7 = Math.max(iMax7, ((LazyListMeasuredItem) arrayList3.get(i87)).crossAxisSize);
                        }
                        boolean z11 = Intrinsics.areEqual(lazyListMeasuredItem, arrayDeque2.first()) && arrayList2.isEmpty() && arrayList3.isEmpty();
                        int iM692constrainWidthK40F9xA = ConstraintsKt.m692constrainWidthK40F9xA(z4 ? iMax7 : i60, jM693offsetNN6EwU);
                        if (z4) {
                            iMax7 = i60;
                        }
                        int iM691constrainHeightK40F9xA = ConstraintsKt.m691constrainHeightK40F9xA(iMax7, jM693offsetNN6EwU);
                        int i88 = z4 ? iM691constrainHeightK40F9xA : iM692constrainWidthK40F9xA;
                        boolean z12 = z11;
                        boolean z13 = i60 < Math.min(i88, i29);
                        if (z13 && i10 != 0) {
                            InlineClassHelperKt.throwIllegalStateException("non-zero itemsScrollOffset");
                        }
                        boolean z14 = z13;
                        ArrayList arrayList5 = new ArrayList(arrayList3.size() + arrayList2.size() + arrayDeque2.getSize());
                        if (z14) {
                            if (!arrayList2.isEmpty() || !arrayList3.isEmpty()) {
                                InlineClassHelperKt.throwIllegalArgumentException("no extra items");
                            }
                            int size7 = arrayDeque2.getSize();
                            int[] iArr2 = new int[size7];
                            int i89 = 0;
                            while (i89 < size7) {
                                iArr2[i89] = ((LazyListMeasuredItem) arrayDeque2.get(!z8 ? i89 : (size7 - i89) - 1)).size;
                                i89++;
                                lazyListMeasuredItem = lazyListMeasuredItem;
                            }
                            lazyListMeasuredItem2 = lazyListMeasuredItem;
                            int[] iArr3 = new int[size7];
                            if (z4) {
                                if (vertical == null) {
                                    throw LazyItemScope$CC.m("null verticalArrangement when isVertical == true");
                                }
                                vertical.arrange(i88, lazyLayoutMeasureScopeImpl2, iArr2, iArr3);
                                iArr = iArr3;
                                i20 = i88;
                            } else {
                                if (horizontal == null) {
                                    throw LazyItemScope$CC.m("null horizontalArrangement when isVertical == false");
                                }
                                iArr = iArr3;
                                i20 = i88;
                                horizontal.arrange(lazyLayoutMeasureScopeImpl2, i20, iArr2, LayoutDirection.Ltr, iArr);
                            }
                            if (z8) {
                                IntRange intRange2 = new IntRange(0, size7 - 1, 1);
                                intProgression = new IntProgression(intRange2.last, 0, -intRange2.step);
                            } else {
                                intProgression = new IntRange(0, size7 - 1, 1);
                            }
                            int i90 = intProgression.first;
                            int i91 = intProgression.last;
                            int i92 = intProgression.step;
                            if ((i92 <= 0 || i90 > i91) && (i92 >= 0 || i91 > i90)) {
                                lazyLayoutMeasureScopeImpl2 = lazyLayoutMeasureScopeImpl2;
                            } else {
                                while (true) {
                                    int i93 = iArr[i90];
                                    LazyListMeasuredItem lazyListMeasuredItem5 = (LazyListMeasuredItem) arrayDeque2.get(!z8 ? i90 : (size7 - i90) - 1);
                                    if (z8) {
                                        i93 = (i20 - i93) - lazyListMeasuredItem5.size;
                                    }
                                    lazyListMeasuredItem5.position(i93, iM692constrainWidthK40F9xA, iM691constrainHeightK40F9xA);
                                    arrayList5.add(lazyListMeasuredItem5);
                                    if (i90 != i91) {
                                        i90 += i92;
                                        size7 = size7;
                                        lazyLayoutMeasureScopeImpl2 = lazyLayoutMeasureScopeImpl2;
                                    }
                                }
                            }
                        } else {
                            lazyLayoutMeasureScopeImpl2 = lazyLayoutMeasureScopeImpl2;
                            lazyListMeasuredItem2 = lazyListMeasuredItem;
                            int i94 = i10;
                            int i95 = 0;
                            for (int size8 = arrayList2.size(); i95 < size8; size8 = size8) {
                                LazyListMeasuredItem lazyListMeasuredItem6 = (LazyListMeasuredItem) arrayList2.get(i95);
                                i94 -= lazyListMeasuredItem6.mainAxisSizeWithSpacings;
                                lazyListMeasuredItem6.position(i94, iM692constrainWidthK40F9xA, iM691constrainHeightK40F9xA);
                                arrayList5.add(lazyListMeasuredItem6);
                                i95++;
                            }
                            int size9 = arrayDeque2.getSize();
                            int i96 = i10;
                            for (int i97 = 0; i97 < size9; i97++) {
                                LazyListMeasuredItem lazyListMeasuredItem7 = (LazyListMeasuredItem) arrayDeque2.get(i97);
                                lazyListMeasuredItem7.position(i96, iM692constrainWidthK40F9xA, iM691constrainHeightK40F9xA);
                                arrayList5.add(lazyListMeasuredItem7);
                                i96 += lazyListMeasuredItem7.mainAxisSizeWithSpacings;
                            }
                            int size10 = arrayList3.size();
                            for (int i98 = 0; i98 < size10; i98++) {
                                LazyListMeasuredItem lazyListMeasuredItem8 = (LazyListMeasuredItem) arrayList3.get(i98);
                                lazyListMeasuredItem8.position(i96, iM692constrainWidthK40F9xA, iM691constrainHeightK40F9xA);
                                arrayList5.add(lazyListMeasuredItem8);
                                i96 += lazyListMeasuredItem8.mainAxisSizeWithSpacings;
                            }
                        }
                        int i99 = i9;
                        lazyLayoutItemAnimator.onMeasured(iM692constrainWidthK40F9xA, iM691constrainHeightK40F9xA, arrayList5, lazyListItemProviderImpl3.keyIndexMap, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1, zIsLookingAhead, z5, i99, i60);
                        int iM691constrainHeightK40F9xA2 = iM691constrainHeightK40F9xA;
                        boolean z15 = zIsLookingAhead;
                        if (z15) {
                            i12 = i60;
                        } else {
                            lazyLayoutItemAnimator.m152getMinSizeToFitDisappearingItemsYbymL2g();
                            if (zM720equalsimpl0) {
                                i12 = i60;
                            } else {
                                int i100 = z4 ? iM691constrainHeightK40F9xA2 : iM692constrainWidthK40F9xA;
                                i12 = i60;
                                iM692constrainWidthK40F9xA = ConstraintsKt.m692constrainWidthK40F9xA(Math.max(iM692constrainWidthK40F9xA, (int) 0), jM693offsetNN6EwU);
                                iM691constrainHeightK40F9xA2 = ConstraintsKt.m691constrainHeightK40F9xA(Math.max(iM691constrainHeightK40F9xA2, (int) 0), jM693offsetNN6EwU);
                                int i101 = z4 ? iM691constrainHeightK40F9xA2 : iM692constrainWidthK40F9xA;
                                if (i101 != i100) {
                                    int size11 = arrayList5.size();
                                    for (int i102 = 0; i102 < size11; i102++) {
                                        ((LazyListMeasuredItem) arrayList5.get(i102)).mainAxisLayoutSize = i101;
                                    }
                                }
                            }
                        }
                        int i103 = iM691constrainHeightK40F9xA2;
                        LazyListMeasuredItem lazyListMeasuredItem9 = (LazyListMeasuredItem) arrayDeque2.firstOrNull();
                        int i104 = lazyListMeasuredItem9 != null ? lazyListMeasuredItem9.index : 0;
                        LazyListMeasuredItem lazyListMeasuredItem10 = (LazyListMeasuredItem) arrayDeque2.lastOrNull();
                        int i105 = lazyListMeasuredItem10 != null ? lazyListMeasuredItem10.index : 0;
                        lazyListItemProviderImpl3.intervalContent.getClass();
                        MutableIntList mutableIntList2 = IntListKt.EmptyIntList;
                        if (dummyHandle == null || arrayList5.isEmpty() || (i14 = mutableIntList2._size) == 0) {
                            z = z15;
                            arrayDeque = arrayDeque2;
                            i13 = i59;
                            list = list2;
                        } else {
                            if (i105 - i104 < 0 || i14 == 0) {
                                mutableIntList = mutableIntList2;
                            } else {
                                IntRange intRangeUntil = RangesKt.until(0, i14);
                                int i106 = intRangeUntil.first;
                                int i107 = intRangeUntil.last;
                                if (i106 <= i107) {
                                    i19 = -1;
                                    while (mutableIntList2.get(i106) <= i104) {
                                        i19 = mutableIntList2.get(i106);
                                        if (i106 != i107) {
                                            i106++;
                                        } else {
                                            i18 = -1;
                                        }
                                    }
                                    i18 = -1;
                                } else {
                                    i18 = -1;
                                    i19 = -1;
                                }
                                if (i19 == i18) {
                                    mutableIntList = IntListKt.EmptyIntList;
                                } else {
                                    mutableIntList = new MutableIntList(1);
                                    mutableIntList.add(i19);
                                }
                            }
                            ArrayList arrayList6 = new ArrayList();
                            ArrayList arrayList7 = new ArrayList(arrayList5.size());
                            int size12 = arrayList5.size();
                            int i108 = 0;
                            while (i108 < size12) {
                                Object obj7 = arrayList5.get(i108);
                                ArrayDeque arrayDeque3 = arrayDeque2;
                                int i109 = ((LazyListMeasuredItem) obj7).index;
                                int i110 = size12;
                                int[] iArr4 = mutableIntList2.content;
                                int i111 = mutableIntList2._size;
                                MutableIntList mutableIntList3 = mutableIntList2;
                                int i112 = 0;
                                while (i112 < i111) {
                                    int i113 = i112;
                                    if (iArr4[i113] == i109) {
                                        arrayList7.add(obj7);
                                    }
                                    i112 = i113 + 1;
                                    break;
                                }
                                i108++;
                                arrayDeque2 = arrayDeque3;
                                size12 = i110;
                                mutableIntList2 = mutableIntList3;
                            }
                            arrayDeque = arrayDeque2;
                            int[] iArr5 = mutableIntList.content;
                            int i114 = mutableIntList._size;
                            int i115 = 0;
                            while (i115 < i114) {
                                int i116 = iArr5[i115];
                                int size13 = arrayList5.size();
                                int i117 = i114;
                                int i118 = 0;
                                int i119 = 0;
                                while (true) {
                                    if (i118 < size13) {
                                        Object obj8 = arrayList5.get(i118);
                                        int i120 = i118 + 1;
                                        if (((LazyListMeasuredItem) obj8).index != i116) {
                                            i119++;
                                            i118 = i120;
                                        }
                                    } else {
                                        i119 = -1;
                                    }
                                }
                                LazyListMeasuredItem lazyListMeasuredItemM147getAndMeasure0kLqBqw4 = i119 == -1 ? lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1.m147getAndMeasure0kLqBqw(i116, j2) : (LazyListMeasuredItem) arrayList5.remove(i119);
                                int[] iArr6 = iArr5;
                                int i121 = lazyListMeasuredItemM147getAndMeasure0kLqBqw4.mainAxisSizeWithSpacings;
                                if (i119 == -1) {
                                    z15 = z15;
                                    i15 = Integer.MIN_VALUE;
                                } else {
                                    long jM149getOffsetBjo55l4 = lazyListMeasuredItemM147getAndMeasure0kLqBqw4.m149getOffsetBjo55l4(0);
                                    i15 = (int) (lazyListMeasuredItemM147getAndMeasure0kLqBqw4.isVertical ? jM149getOffsetBjo55l4 & 4294967295L : jM149getOffsetBjo55l4 >> c);
                                }
                                int size14 = arrayList7.size();
                                int i122 = 0;
                                while (true) {
                                    if (i122 < size14) {
                                        obj3 = arrayList7.get(i122);
                                        z2 = z15;
                                        if (((LazyListMeasuredItem) obj3).index == i116) {
                                            i122++;
                                            z15 = z2;
                                        }
                                    } else {
                                        z2 = z15;
                                        obj3 = null;
                                    }
                                }
                                LazyListMeasuredItem lazyListMeasuredItem11 = (LazyListMeasuredItem) obj3;
                                if (lazyListMeasuredItem11 != null) {
                                    long jM149getOffsetBjo55l5 = lazyListMeasuredItem11.m149getOffsetBjo55l4(0);
                                    i16 = (int) (lazyListMeasuredItem11.isVertical ? jM149getOffsetBjo55l5 & 4294967295L : jM149getOffsetBjo55l5 >> c);
                                } else {
                                    j2 = j2;
                                    i16 = Integer.MIN_VALUE;
                                }
                                if (i15 == Integer.MIN_VALUE) {
                                    iMax = i59;
                                    i17 = iMax;
                                } else {
                                    i17 = i59;
                                    iMax = Math.max(i17, i15);
                                }
                                if (i16 != Integer.MIN_VALUE) {
                                    iMax = Math.min(iMax, i16 - i121);
                                }
                                lazyListMeasuredItemM147getAndMeasure0kLqBqw4.nonScrollableItem = true;
                                lazyListMeasuredItemM147getAndMeasure0kLqBqw4.position(iMax, iM692constrainWidthK40F9xA, i103);
                                arrayList6.add(lazyListMeasuredItemM147getAndMeasure0kLqBqw4);
                                i115++;
                                i59 = i17;
                                i114 = i117;
                                iArr5 = iArr6;
                                z15 = z2;
                                j2 = j2;
                            }
                            z = z15;
                            i13 = i59;
                            list = arrayList6;
                        }
                        if (z12) {
                            LazyListMeasuredItem lazyListMeasuredItem12 = (LazyListMeasuredItem) CollectionsKt.firstOrNull(arrayList5);
                            if (lazyListMeasuredItem12 != null) {
                                numValueOf = Integer.valueOf(lazyListMeasuredItem12.index);
                            } else {
                                numValueOf = null;
                            }
                        } else {
                            LazyListMeasuredItem lazyListMeasuredItem13 = (LazyListMeasuredItem) arrayDeque.firstOrNull();
                            if (lazyListMeasuredItem13 != null) {
                                numValueOf = Integer.valueOf(lazyListMeasuredItem13.index);
                            } else {
                                numValueOf = null;
                            }
                        }
                        if (z12) {
                            LazyListMeasuredItem lazyListMeasuredItem14 = (LazyListMeasuredItem) CollectionsKt.lastOrNull(arrayList5);
                            if (lazyListMeasuredItem14 != null) {
                                numValueOf2 = Integer.valueOf(lazyListMeasuredItem14.index);
                            } else {
                                numValueOf2 = null;
                            }
                        } else {
                            LazyListMeasuredItem lazyListMeasuredItem15 = (LazyListMeasuredItem) arrayDeque.lastOrNull();
                            if (lazyListMeasuredItem15 != null) {
                                numValueOf2 = Integer.valueOf(lazyListMeasuredItem15.index);
                            } else {
                                numValueOf2 = null;
                            }
                        }
                        boolean z16 = i75 < i68 || i12 > i29;
                        subcomposeMeasureScope = subcomposeMeasureScope2;
                        MeasureResult measureResultLayout = subcomposeMeasureScope.layout(ConstraintsKt.m692constrainWidthK40F9xA(iM692constrainWidthK40F9xA + i25, j3), ConstraintsKt.m691constrainHeightK40F9xA(i103 + i24, j3), emptyMap, new LifecycleEffectKt$$ExternalSyntheticLambda1(mutableState3, arrayList5, list, z));
                        int iIntValue4 = numValueOf != null ? numValueOf.intValue() : 0;
                        int iIntValue5 = numValueOf2 != null ? numValueOf2.intValue() : 0;
                        if (!arrayList5.isEmpty()) {
                            ArrayList arrayList8 = new ArrayList(list);
                            int size15 = arrayList5.size();
                            for (int i123 = 0; i123 < size15; i123++) {
                                LazyListMeasuredItem lazyListMeasuredItem16 = (LazyListMeasuredItem) arrayList5.get(i123);
                                int i124 = lazyListMeasuredItem16.index;
                                if (iIntValue4 <= i124 && i124 <= iIntValue5) {
                                    arrayList8.add(lazyListMeasuredItem16);
                                }
                            }
                            CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList8, LazyLayoutKt.LazyLayoutMeasuredItemIndexComparator);
                            list2 = arrayList8;
                        }
                        lazyListMeasureResult = new LazyListMeasureResult(lazyListMeasuredItem2, i99, z16, f, measureResultLayout, f6, z10, coroutineScope, lazyLayoutMeasureScopeImpl2, lazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1.childConstraints, list2, i13, i56, i68, z8, z4 ? orientation2 : orientation, i27, iMo86roundToPx0680j_8);
                    }
                    lazyListState.applyMeasureResult$foundation(lazyListMeasureResult, subcomposeMeasureScope.isLookingAhead(), false);
                    return lazyListMeasureResult;
                } catch (Throwable th) {
                    SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    throw th;
                }
            case 6:
                ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) obj4;
                LazySaveableStateHolder lazySaveableStateHolder = (LazySaveableStateHolder) obj5;
                GapComposer gapComposer2 = (GapComposer) obj;
                int iIntValue6 = ((Integer) obj2).intValue();
                if (gapComposer2.shouldExecute(iIntValue6 & 1, (iIntValue6 & 3) != 2)) {
                    composableLambdaImpl.invoke((Object) lazySaveableStateHolder, (Object) gapComposer2, (Object) 0);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return Unit.INSTANCE;
            case 7:
                TextContextMenuDataProvider textContextMenuDataProvider = (TextContextMenuDataProvider) obj5;
                TextContextMenuSession textContextMenuSession = (TextContextMenuSession) obj4;
                GapComposer gapComposer3 = (GapComposer) obj;
                int iIntValue7 = ((Integer) obj2).intValue();
                if (gapComposer3.shouldExecute(iIntValue7 & 1, (iIntValue7 & 3) != 2)) {
                    boolean zChanged = gapComposer3.changed(textContextMenuDataProvider);
                    Object objRememberedValue2 = gapComposer3.rememberedValue();
                    if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = Stack.derivedStateOf(new FocusableNode.AnonymousClass1(0, textContextMenuDataProvider, TextContextMenuDataProvider.class, "data", "data()Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuData;", 0, 0, 1));
                        gapComposer3.updateRememberedValue(objRememberedValue2);
                    }
                    DefaultTextContextMenuDropdownProvider_androidKt.DefaultTextContextMenuDropdown(textContextMenuSession, (TextContextMenuData) ((State) objRememberedValue2).getValue(), gapComposer3, 0);
                } else {
                    gapComposer3.skipToGroupEnd();
                }
                return Unit.INSTANCE;
            case 8:
                ((Integer) obj2).getClass();
                DefaultTextContextMenuDropdownProvider_androidKt.DefaultTextContextMenuDropdown((TextContextMenuSession) obj5, (TextContextMenuData) obj4, (GapComposer) obj, Stack.updateChangedFlags(1));
                return Unit.INSTANCE;
            case 9:
                ((Integer) obj2).getClass();
                ((TextContextMenuHelperApi28) obj5).IconBox((Drawable) obj4, (GapComposer) obj, Stack.updateChangedFlags(49));
                return Unit.INSTANCE;
            case 10:
                TextFieldSelectionManager textFieldSelectionManager = (TextFieldSelectionManager) obj5;
                CoroutineScope coroutineScope2 = (CoroutineScope) obj4;
                TextContextMenuBuilderScope textContextMenuBuilderScope = (TextContextMenuBuilderScope) obj;
                Context context = (Context) obj2;
                boolean editable = textFieldSelectionManager.getEditable();
                AnnotatedString transformedText$foundation = textFieldSelectionManager.getTransformedText$foundation();
                String str = transformedText$foundation != null ? transformedText$foundation.text : null;
                TextRange textRange2 = textFieldSelectionManager.latestSelection;
                if (textRange2 != null) {
                    long j4 = textRange2.packedValue;
                    OffsetMapping offsetMapping = textFieldSelectionManager.offsetMapping;
                    textRange = new TextRange(ParagraphKt.TextRange(offsetMapping.originalToTransformed((int) (j4 >> 32)), offsetMapping.originalToTransformed((int) (j4 & 4294967295L))));
                }
                PlatformSelectionBehaviors_androidKt.m217addPlatformTextContextMenuItems71BSaZU(textContextMenuBuilderScope, context, editable, str, textRange, textFieldSelectionManager.platformSelectionBehaviors, new LifecycleEffectKt$$ExternalSyntheticLambda1(textFieldSelectionManager, coroutineScope2, context, 11));
                return Unit.INSTANCE;
            case 11:
                return invoke$androidx$compose$material3$AlertDialogKt$$ExternalSyntheticLambda10(obj, obj2);
            case 12:
                return invoke$androidx$compose$material3$ButtonKt$$ExternalSyntheticLambda4(obj, obj2);
            case 13:
                ((Integer) obj2).getClass();
                ((DefaultBasicAlertDialogOverride) obj5).BasicAlertDialog((Dispatcher) obj4, (GapComposer) obj, Stack.updateChangedFlags(1));
                return Unit.INSTANCE;
            case 14:
                ((Integer) obj2).getClass();
                ((DefaultSingleRowTopAppBarOverride) obj5).SingleRowTopAppBar((SingleRowTopAppBarOverrideScope) obj4, (GapComposer) obj, Stack.updateChangedFlags(1));
                return Unit.INSTANCE;
            case 15:
                return invoke$androidx$compose$material3$ScaffoldKt$$ExternalSyntheticLambda6(obj, obj2);
            case 16:
                ((Integer) obj2).getClass();
                SheetDefaultsKt.DragHandleWithTooltip((Modifier) obj5, (Function2) obj4, (GapComposer) obj, Stack.updateChangedFlags(1));
                return Unit.INSTANCE;
            case 17:
                return invoke$androidx$compose$material3$SnackbarHostKt$$ExternalSyntheticLambda2(obj, obj2);
            case 18:
                return invoke$androidx$compose$material3$TooltipKt$$ExternalSyntheticLambda1(obj, obj2);
            case 19:
                return invoke$androidx$compose$material3$internal$TextFieldImplKt$$ExternalSyntheticLambda0(obj, obj2);
            case 20:
                return invoke$androidx$compose$runtime$GapComposerKt$$ExternalSyntheticLambda1(obj, obj2);
            case 21:
                return invoke$com$github$kr328$clash$FilesActivity$$ExternalSyntheticLambda5(obj, obj2);
            case 22:
                return invoke$com$github$kr328$clash$compose$LogsScreenKt$$ExternalSyntheticLambda3(obj, obj2);
            case 23:
                return invoke$com$github$kr328$clash$compose$connections$ConnectionsScreenKt$$ExternalSyntheticLambda29(obj, obj2);
            case 24:
                return invoke$com$github$kr328$clash$compose$connections$ConnectionsScreenKt$ConnectionsScreen$5$2$$ExternalSyntheticLambda1(obj, obj2);
            case 25:
                return invoke$com$github$kr328$clash$compose$profiles$ProfilesScreenKt$$ExternalSyntheticLambda5(obj, obj2);
            case 26:
                return invoke$com$github$kr328$clash$compose$proxy$ProxyScreenKt$$ExternalSyntheticLambda7(obj, obj2);
            case 27:
                return invoke$com$github$kr328$clash$compose$sharetotv$ShareToTvScreenKt$$ExternalSyntheticLambda1(obj, obj2);
            default:
                JobKt.launch$default((CoroutineScope) obj5, null, new GlassSnackbarKt$GlassSnackbarHost$1$2$1$2$1((Animatable) obj4, ((Float) obj2).floatValue(), false ? 1 : 0, i22), 3);
                return Unit.INSTANCE;
        }
    }

    public /* synthetic */ TextKt$$ExternalSyntheticLambda2(int i, Object obj, Object obj2) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    public /* synthetic */ TextKt$$ExternalSyntheticLambda2(ComposableLambdaImpl composableLambdaImpl, Object obj, int i) {
        this.$r8$classId = i;
        this.f$1 = composableLambdaImpl;
        this.f$0 = obj;
    }
}
