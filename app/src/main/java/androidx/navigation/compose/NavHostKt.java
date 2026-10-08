package androidx.navigation.compose;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.collection.ArraySetKt;
import androidx.collection.SparseArrayCompat;
import androidx.collection.internal.RuntimeHelpersKt;
import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentScopeImpl;
import androidx.compose.animation.AnimatedContentTransitionScopeImpl;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransitionImpl;
import androidx.compose.animation.ExitTransitionImpl;
import androidx.compose.animation.SizeTransformImpl;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.SeekableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.composer.gapbuffer.SlotReader;
import androidx.compose.runtime.composer.gapbuffer.changelist.ComposerChangeListWriter;
import androidx.compose.runtime.composer.gapbuffer.changelist.Operation;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.saveable.SaveableStateHolderImpl;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.contentcapture.AndroidContentCaptureManager;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeKt;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeCoordinator$invalidateParentLayer$1;
import androidx.compose.ui.node.OwnerSnapshotObserver;
import androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayout$1;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.SemanticsNodeCopy;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.core.app.TaskStackBuilder;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavBackStackEntryState;
import androidx.navigation.NavController$NavControllerNavigatorState;
import androidx.navigation.NavController$activity$1;
import androidx.navigation.NavController$handleDeepLink$2;
import androidx.navigation.NavController$navigate$5;
import androidx.navigation.NavControllerViewModel;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.NavOptionsBuilderKt;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorProvider;
import coil.ImageLoader$Builder;
import coil.RealImageLoader$executeMain$result$1;
import io.github.g00fy2.quickie.content.QRContent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.ReversedListReadOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt;
import okhttp3.Handshake;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class NavHostKt {

    /* JADX INFO: renamed from: androidx.navigation.compose.NavHostKt$NavHost$7, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass7 extends Lambda implements Function1 {
        public static final AnonymousClass7 INSTANCE;
        public static final AnonymousClass7 INSTANCE$1;
        public static final AnonymousClass7 INSTANCE$2;
        public final /* synthetic */ int $r8$classId;

        static {
            int i = 1;
            INSTANCE$1 = new AnonymousClass7(i, 1);
            INSTANCE = new AnonymousClass7(i, 0);
            INSTANCE$2 = new AnonymousClass7(i, 2);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass7(int i, int i2) {
            super(i);
            this.$r8$classId = i2;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    return EnterExitTransitionKt.fadeIn$default(ArcSplineKt.tween$default(700, 6, null), 2);
                case 1:
                    return ((NavBackStackEntry) obj).id;
                case 2:
                    return EnterExitTransitionKt.fadeOut$default(ArcSplineKt.tween$default(700, 6, null), 2);
                default:
                    ComposeNavigator.Destination destination = (ComposeNavigator.Destination) ((NavBackStackEntry) ((AnimatedContentTransitionScopeImpl) obj).getTargetState()).destination;
                    int i = NavDestination.$r8$clinit;
                    for (NavDestination navDestination : SequencesKt.generateSequence(destination, NavController$activity$1.INSTANCE$5)) {
                    }
                    return null;
            }
        }
    }

    public static final void NavHost(NavHostController navHostController, Modifier modifier, Alignment alignment, Function1 function1, Function1 function2, Function1 function3, Function1 function4, Function1 function5, GapComposer gapComposer, int i) {
        Alignment alignment2;
        Function1 function6;
        Function1 function7;
        int i2;
        Function1 function8;
        Function1 function9;
        Alignment alignment3;
        gapComposer.startRestartGroup(1840250294);
        int i3 = i | (gapComposer.changedInstance(navHostController) ? 4 : 2) | 844852224;
        char c = gapComposer.changedInstance(function5) ? (char) 4 : (char) 2;
        if ((306783379 & i3) == 306783378 && (c & 3) == 2 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
            alignment3 = alignment;
            function8 = function1;
            function9 = function2;
            function6 = function3;
            function7 = function4;
        } else {
            gapComposer.startDefaults();
            if ((i & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                alignment2 = Alignment.Companion.TopStart;
                function6 = AnonymousClass7.INSTANCE;
                function7 = AnonymousClass7.INSTANCE$2;
                i2 = i3 & (-264241153);
                function8 = function6;
                function9 = function7;
            } else {
                gapComposer.skipToGroupEnd();
                i2 = i3 & (-264241153);
                alignment2 = alignment;
                function9 = function2;
                function6 = function3;
                function7 = function4;
                function8 = function1;
            }
            gapComposer.endDefaults();
            boolean z = (c & 14) == 4;
            Object objRememberedValue = gapComposer.rememberedValue();
            if (z || objRememberedValue == Composer$Companion.Empty) {
                NavGraphBuilder navGraphBuilder = new NavGraphBuilder(navHostController._navigatorProvider);
                function5.invoke(navGraphBuilder);
                objRememberedValue = navGraphBuilder.build();
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            alignment3 = alignment2;
            NavHost(navHostController, (NavGraph) objRememberedValue, modifier, alignment3, function8, function9, function6, function7, gapComposer, (i2 & 8078) | 100884480);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2(modifier, alignment3, function8, function9, function6, function7, function5, i) { // from class: androidx.navigation.compose.NavHostKt.NavHost.10
                public final /* synthetic */ Function1 $builder;
                public final /* synthetic */ Alignment $contentAlignment;
                public final /* synthetic */ Function1 $enterTransition;
                public final /* synthetic */ Function1 $exitTransition;
                public final /* synthetic */ Modifier $modifier;
                public final /* synthetic */ Function1 $popEnterTransition;
                public final /* synthetic */ Function1 $popExitTransition;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Number) obj2).intValue();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(433);
                    NavHostKt.NavHost(this.$navController, this.$modifier, this.$contentAlignment, this.$enterTransition, this.$exitTransition, this.$popEnterTransition, this.$popExitTransition, this.$builder, (GapComposer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final boolean NavHost$lambda$11(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX WARN: Code duplicated, block: B:233:0x041a  */
    /* JADX WARN: Code duplicated, block: B:235:0x041e  */
    /* JADX WARN: Code duplicated, block: B:238:0x0427  */
    /* JADX WARN: Code duplicated, block: B:239:0x0429  */
    /* JADX WARN: Code duplicated, block: B:242:0x043c  */
    /* JADX WARN: Code duplicated, block: B:254:0x0468  */
    /* JADX WARN: Code duplicated, block: B:255:0x0483  */
    /* JADX WARN: Code duplicated, block: B:257:0x048e  */
    /* JADX WARN: Code duplicated, block: B:273:0x04e7  */
    /* JADX WARN: Code duplicated, block: B:275:0x04eb  */
    /* JADX WARN: Code duplicated, block: B:277:0x04f1  */
    /* JADX WARN: Code duplicated, block: B:281:0x04fe  */
    /* JADX WARN: Code duplicated, block: B:283:0x050b A[LOOP:10: B:279:0x04fb->B:283:0x050b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:286:0x052f  */
    /* JADX WARN: Code duplicated, block: B:287:0x0532  */
    /* JADX WARN: Code duplicated, block: B:291:0x0543  */
    /* JADX WARN: Code duplicated, block: B:293:0x0549  */
    /* JADX WARN: Code duplicated, block: B:295:0x054f  */
    /* JADX WARN: Code duplicated, block: B:296:0x0555  */
    /* JADX WARN: Code duplicated, block: B:298:0x055d  */
    /* JADX WARN: Code duplicated, block: B:300:0x0564  */
    /* JADX WARN: Code duplicated, block: B:302:0x0568  */
    /* JADX WARN: Code duplicated, block: B:305:0x0574 A[LOOP:12: B:303:0x056a->B:305:0x0574, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:307:0x0582  */
    /* JADX WARN: Code duplicated, block: B:342:0x0680  */
    /* JADX WARN: Code duplicated, block: B:343:0x0684  */
    /* JADX WARN: Code duplicated, block: B:345:0x0687  */
    /* JADX WARN: Code duplicated, block: B:347:0x068d  */
    /* JADX WARN: Code duplicated, block: B:348:0x06a5  */
    /* JADX WARN: Code duplicated, block: B:350:0x06bf  */
    /* JADX WARN: Code duplicated, block: B:353:0x06d2  */
    /* JADX WARN: Code duplicated, block: B:356:0x06eb  */
    /* JADX WARN: Code duplicated, block: B:357:0x06ed  */
    /* JADX WARN: Code duplicated, block: B:363:0x0702  */
    /* JADX WARN: Code duplicated, block: B:367:0x0731  */
    /* JADX WARN: Code duplicated, block: B:370:0x074f  */
    /* JADX WARN: Code duplicated, block: B:373:0x0773  */
    /* JADX WARN: Code duplicated, block: B:376:0x0787  */
    /* JADX WARN: Code duplicated, block: B:386:0x07ac  */
    /* JADX WARN: Code duplicated, block: B:387:0x07ae  */
    /* JADX WARN: Code duplicated, block: B:393:0x07bf  */
    /* JADX WARN: Code duplicated, block: B:404:0x07f6  */
    /* JADX WARN: Code duplicated, block: B:405:0x07f8  */
    /* JADX WARN: Code duplicated, block: B:409:0x0802  */
    /* JADX WARN: Code duplicated, block: B:414:0x081f  */
    /* JADX WARN: Code duplicated, block: B:415:0x0821  */
    /* JADX WARN: Code duplicated, block: B:419:0x082a  */
    /* JADX WARN: Code duplicated, block: B:423:0x0846  */
    /* JADX WARN: Code duplicated, block: B:426:0x085b  */
    /* JADX WARN: Code duplicated, block: B:429:0x0873  */
    /* JADX WARN: Code duplicated, block: B:434:0x089b  */
    /* JADX WARN: Code duplicated, block: B:436:0x08be  */
    /* JADX WARN: Code duplicated, block: B:441:0x08e4  */
    /* JADX WARN: Code duplicated, block: B:448:0x0929  */
    /* JADX WARN: Code duplicated, block: B:452:0x09ab  */
    /* JADX WARN: Code duplicated, block: B:455:0x09c6  */
    /* JADX WARN: Code duplicated, block: B:458:0x09d8  */
    /* JADX WARN: Code duplicated, block: B:459:0x09dc  */
    /* JADX WARN: Code duplicated, block: B:461:0x09e0  */
    /* JADX WARN: Code duplicated, block: B:463:0x09e6  */
    /* JADX WARN: Code duplicated, block: B:464:0x0a01  */
    /* JADX WARN: Code duplicated, block: B:493:0x0465 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:494:0x0435 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:504:0x051b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:506:0x05a1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:508:0x059e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:525:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:527:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:254:0x0468, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void NavHost(final NavHostController navHostController, final NavGraph navGraph, final Modifier modifier, final Alignment alignment, final Function1 function1, final Function1 function2, final Function1 function3, final Function1 function4, GapComposer gapComposer, final int i) {
        LifecycleOwner lifecycleOwner;
        ComposeNavigator composeNavigator;
        Navigator navigator;
        ComposeNavigator composeNavigator2;
        MutableState mutableStateCollectAsState;
        Object objRememberedValue;
        NeverEqualPolicy neverEqualPolicy;
        Object obj;
        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState;
        Object objRememberedValue2;
        Object obj2;
        final MutableState mutableState;
        boolean z;
        boolean zChanged;
        Object objRememberedValue3;
        MutableState mutableState2;
        LifecycleOwner lifecycleOwner2;
        boolean zChangedInstance;
        Object obj3;
        final SaveableStateHolderImpl saveableStateHolderImplRememberSaveableStateHolder;
        MutableState mutableStateCollectAsState2;
        Object objRememberedValue4;
        Object obj4;
        State state;
        NavBackStackEntry navBackStackEntry;
        Object objRememberedValue5;
        Object obj5;
        final Map map;
        GapComposer gapComposer2;
        ComposeNavigator composeNavigator3;
        NavigatorProvider navigatorProvider;
        Navigator navigator2;
        DialogNavigator dialogNavigator;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        DialogNavigator dialogNavigator2;
        boolean z2;
        boolean z3;
        Object navController$navigate$5;
        NavigatorProvider navigatorProvider2;
        ComposeNavigator composeNavigator4;
        Function1 function5;
        boolean z4;
        boolean z5;
        Object objRememberedValue6;
        Function1 function6;
        final Function1 function7;
        boolean z6;
        Object obj6;
        final Function1 function8;
        boolean zChanged2;
        Object obj7;
        Object objRememberedValue7;
        Object obj8;
        SeekableTransitionState seekableTransitionState;
        Transition transitionRememberTransition;
        boolean zChangedInstance2;
        Object objRememberedValue8;
        Transition transition;
        SeekableTransitionState seekableTransitionState2;
        NavBackStackEntry navBackStackEntry2;
        boolean zChangedInstance3;
        Object objRememberedValue9;
        final State state2;
        Map map2;
        ComposeNavigator composeNavigator5;
        MutableState mutableState3;
        final State state3;
        Transition transition2;
        boolean zChanged3;
        Object objRememberedValue10;
        boolean zChanged4;
        Object objRememberedValue11;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup2;
        Context context;
        Intent intent;
        int[] intArray;
        NavDestination navDestination;
        ArrayList arrayList;
        ArrayDeque arrayDeque;
        NavGraph navGraph2;
        int length;
        int i2;
        String displayName;
        int length2;
        Bundle[] bundleArr;
        int i3;
        int i4;
        NavGraph navGraph3;
        int length3;
        int i5;
        int i6;
        Bundle bundle;
        NavDestination navDestination2;
        boolean z7;
        NavDestination navDestinationFindNodeComprehensive;
        NavGraph navGraph4;
        int i7;
        int i8;
        int i9;
        Bundle bundle2;
        NavDestination navDestinationFindDestination;
        NavBackStackEntry navBackStackEntry3;
        NavDestination navDestination3;
        Bundle bundle3;
        int i10;
        int i11;
        NavDestination navDestinationFindNodeComprehensive2;
        NavGraph navGraph5;
        ArrayDeque arrayDeque2;
        Bundle bundle4;
        ArrayList<String> stringArrayList;
        boolean z8;
        gapComposer.startRestartGroup(-1964664536);
        int i12 = (i & 6) == 0 ? (gapComposer.changedInstance(navHostController) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i12 |= gapComposer.changedInstance(navGraph) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i12 |= gapComposer.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i12 |= gapComposer.changed(alignment) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i12 |= gapComposer.changedInstance(function1) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i12 |= gapComposer.changedInstance(function2) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i12 |= gapComposer.changedInstance(function3) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i12 |= gapComposer.changedInstance(function4) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i12 |= gapComposer.changedInstance(null) ? 67108864 : 33554432;
        }
        int i13 = i12;
        if ((38347923 & i13) == 38347922 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
            gapComposer2 = gapComposer;
        } else {
            gapComposer.startDefaults();
            if ((i & 1) != 0 && !gapComposer.getDefaultsInvalid()) {
                gapComposer.skipToGroupEnd();
            }
            gapComposer.endDefaults();
            LifecycleOwner lifecycleOwner3 = (LifecycleOwner) gapComposer.consume(LocalLifecycleOwnerKt.LocalLifecycleOwner);
            ViewModelStoreOwner current = LocalViewModelStoreOwner.getCurrent(gapComposer);
            if (current != null) {
                ViewModelStore viewModelStore = current.getViewModelStore();
                NavControllerViewModel navControllerViewModel = navHostController.viewModel;
                ArrayDeque<NavBackStackEntry> arrayDeque3 = navHostController.backQueue;
                NavigatorProvider navigatorProvider3 = navHostController._navigatorProvider;
                if (!Intrinsics.areEqual(navControllerViewModel, NavControllerViewModel.Companion.getInstance(viewModelStore))) {
                    if (arrayDeque3.isEmpty()) {
                        navHostController.viewModel = NavControllerViewModel.Companion.getInstance(viewModelStore);
                    } else {
                        throw new IllegalStateException("ViewModelStore should be set before setGraph call");
                    }
                }
                LinkedHashMap linkedHashMap = navHostController.navigatorState;
                SparseArrayCompat sparseArrayCompat = navGraph.nodes;
                if (!arrayDeque3.isEmpty() && navHostController.getHostLifecycleState$navigation_runtime_release() == Lifecycle.State.DESTROYED) {
                    throw new IllegalStateException("You cannot set a new graph on a NavController with entries on the back stack after the NavController has been destroyed. Please ensure that your NavHost has the same lifetime as your NavController.");
                }
                boolean z9 = false;
                if (!Intrinsics.areEqual(navHostController._graph, navGraph)) {
                    NavGraph navGraph6 = navHostController._graph;
                    if (navGraph6 != null) {
                        ArrayList arrayList2 = new ArrayList(navHostController.backStackMap.keySet());
                        int size = arrayList2.size();
                        int i14 = 0;
                        while (i14 < size) {
                            Object obj9 = arrayList2.get(i14);
                            int i15 = i14 + 1;
                            int iIntValue = ((Integer) obj9).intValue();
                            Iterator it = linkedHashMap.values().iterator();
                            while (it.hasNext()) {
                                ((NavController$NavControllerNavigatorState) it.next()).isNavigating = true;
                            }
                            Unit unit = Unit.INSTANCE;
                            boolean zRestoreStateInternal = navHostController.restoreStateInternal(iIntValue, null, new NavOptions(z9, true, -1, z9, z9, -1, -1));
                            for (Iterator it2 = linkedHashMap.values().iterator(); it2.hasNext(); it2 = it2) {
                                ((NavController$NavControllerNavigatorState) it2.next()).isNavigating = false;
                            }
                            if (zRestoreStateInternal) {
                                navHostController.popBackStackInternal(iIntValue, true, false);
                            }
                            i14 = i15;
                            z9 = false;
                        }
                        navHostController.popBackStackInternal(navGraph6.id, true, false);
                    }
                    navHostController._graph = navGraph;
                    Activity activity = navHostController.activity;
                    Context context2 = navHostController.context;
                    Bundle bundle5 = navHostController.navigatorStateToRestore;
                    if (bundle5 != null && (stringArrayList = bundle5.getStringArrayList("android-support-nav:controller:navigatorState:names")) != null) {
                        int size2 = stringArrayList.size();
                        int i16 = 0;
                        while (i16 < size2) {
                            String str = stringArrayList.get(i16);
                            i16++;
                            String str2 = str;
                            navigatorProvider3.getNavigator(str2);
                            bundle5.getBundle(str2);
                        }
                    }
                    Parcelable[] parcelableArr = navHostController.backStackToRestore;
                    if (parcelableArr != null) {
                        int i17 = 0;
                        for (int length4 = parcelableArr.length; i17 < length4; length4 = length4) {
                            NavBackStackEntryState navBackStackEntryState = (NavBackStackEntryState) parcelableArr[i17];
                            Context context3 = context2;
                            int i18 = navBackStackEntryState.destinationId;
                            Parcelable[] parcelableArr2 = parcelableArr;
                            NavDestination navDestinationFindDestination2 = navHostController.findDestination(i18, null);
                            if (navDestinationFindDestination2 != null) {
                                Lifecycle.State hostLifecycleState$navigation_runtime_release = navHostController.getHostLifecycleState$navigation_runtime_release();
                                NavControllerViewModel navControllerViewModel2 = navHostController.viewModel;
                                Bundle bundle6 = navBackStackEntryState.args;
                                if (bundle6 != null) {
                                    bundle6.setClassLoader(context3.getClassLoader());
                                    bundle4 = bundle6;
                                } else {
                                    bundle4 = null;
                                }
                                NavBackStackEntry navBackStackEntry4 = new NavBackStackEntry(context3, navDestinationFindDestination2, bundle4, hostLifecycleState$navigation_runtime_release, navControllerViewModel2, navBackStackEntryState.id, navBackStackEntryState.savedState);
                                Navigator navigator3 = navigatorProvider3.getNavigator(navDestinationFindDestination2.navigatorName);
                                Object obj10 = linkedHashMap.get(navigator3);
                                if (obj10 == null) {
                                    NavController$NavControllerNavigatorState navController$NavControllerNavigatorState = new NavController$NavControllerNavigatorState(navHostController, navigator3);
                                    linkedHashMap.put(navigator3, navController$NavControllerNavigatorState);
                                    obj10 = navController$NavControllerNavigatorState;
                                }
                                arrayDeque3.addLast(navBackStackEntry4);
                                ((NavController$NavControllerNavigatorState) obj10).addInternal(navBackStackEntry4);
                                NavGraph navGraph7 = navBackStackEntry4.destination.parent;
                                if (navGraph7 != null) {
                                    navHostController.linkChildToParent(navBackStackEntry4, navHostController.getBackStackEntry(navGraph7.id));
                                }
                                i17++;
                                context2 = context3;
                                parcelableArr = parcelableArr2;
                            } else {
                                int i19 = NavDestination.$r8$clinit;
                                StringBuilder sbM16m = ImageAnalysis$$ExternalSyntheticLambda1.m16m("Restoring the Navigation back stack failed: destination ", NavDestination.Companion.getDisplayName(context3, i18), " cannot be found from the current destination ");
                                NavBackStackEntry navBackStackEntry5 = (NavBackStackEntry) arrayDeque3.lastOrNull();
                                sbM16m.append(navBackStackEntry5 != null ? navBackStackEntry5.destination : null);
                                throw new IllegalStateException(sbM16m.toString());
                            }
                        }
                        context = context2;
                        navHostController.updateOnBackPressedCallbackEnabled();
                        navHostController.backStackToRestore = null;
                    } else {
                        context = context2;
                    }
                    Collection collectionValues = MapsKt__MapsKt.toMap(navigatorProvider3._navigators).values();
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj11 : collectionValues) {
                        if (!((Navigator) obj11).isAttached) {
                            arrayList3.add(obj11);
                        }
                    }
                    int i20 = 0;
                    for (int size3 = arrayList3.size(); i20 < size3; size3 = size3) {
                        Object obj12 = arrayList3.get(i20);
                        i20++;
                        Navigator navigator4 = (Navigator) obj12;
                        Object obj13 = linkedHashMap.get(navigator4);
                        if (obj13 == null) {
                            NavController$NavControllerNavigatorState navController$NavControllerNavigatorState2 = new NavController$NavControllerNavigatorState(navHostController, navigator4);
                            linkedHashMap.put(navigator4, navController$NavControllerNavigatorState2);
                            obj13 = navController$NavControllerNavigatorState2;
                        }
                        navigator4._state = (NavController$NavControllerNavigatorState) obj13;
                        navigator4.isAttached = true;
                    }
                    if (navHostController._graph != null && arrayDeque3.isEmpty()) {
                        if (navHostController.deepLinkHandled || activity == null || (intent = activity.getIntent()) == null) {
                            i13 = i13;
                            lifecycleOwner = lifecycleOwner3;
                        } else {
                            Bundle extras = intent.getExtras();
                            if (extras != null) {
                                try {
                                    intArray = extras.getIntArray("android-support-nav:controller:deepLinkIds");
                                } catch (Exception e) {
                                    Log.e("NavController", "handleDeepLink() could not extract deepLink from " + intent, e);
                                    intArray = null;
                                }
                            } else {
                                intArray = null;
                            }
                            ArrayList parcelableArrayList = extras != null ? extras.getParcelableArrayList("android-support-nav:controller:deepLinkArgs") : null;
                            Bundle bundle7 = new Bundle();
                            ArrayList arrayList4 = parcelableArrayList;
                            Bundle bundle8 = extras != null ? extras.getBundle("android-support-nav:controller:deepLinkExtras") : null;
                            if (bundle8 != null) {
                                bundle7.putAll(bundle8);
                            }
                            if (intArray == null || intArray.length == 0) {
                                NavBackStackEntry navBackStackEntry6 = (NavBackStackEntry) arrayDeque3.lastOrNull();
                                if (navBackStackEntry6 == null || (navDestination = navBackStackEntry6.destination) == null) {
                                    navDestination = navHostController._graph;
                                }
                                NavGraph navGraph8 = navDestination instanceof NavGraph ? (NavGraph) navDestination : navDestination.parent;
                                ArrayDeque arrayDeque4 = arrayDeque3;
                                NavDestination.DeepLinkMatch deepLinkMatchMatchDeepLinkComprehensive = navGraph8.matchDeepLinkComprehensive(new ImageLoader$Builder(intent), true, navGraph8);
                                arrayDeque2 = arrayDeque4;
                                if (deepLinkMatchMatchDeepLinkComprehensive != null) {
                                    NavDestination navDestination4 = deepLinkMatchMatchDeepLinkComprehensive.destination;
                                    ArrayDeque arrayDeque5 = new ArrayDeque();
                                    NavDestination navDestination5 = navDestination4;
                                    while (true) {
                                        NavGraph navGraph9 = navDestination5.parent;
                                        lifecycleOwner = lifecycleOwner3;
                                        if (navGraph9 == null || navGraph9.startDestId != navDestination5.id) {
                                            arrayDeque5.addFirst(navDestination5);
                                        }
                                        if (Intrinsics.areEqual(navGraph9, null) || navGraph9 == null) {
                                            break;
                                        }
                                        navDestination5 = navGraph9;
                                        lifecycleOwner3 = lifecycleOwner;
                                    }
                                    List list = CollectionsKt.toList(arrayDeque5);
                                    ArrayList arrayList5 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
                                    Iterator it3 = list.iterator();
                                    while (it3.hasNext()) {
                                        arrayList5.add(Integer.valueOf(((NavDestination) it3.next()).id));
                                    }
                                    intArray = CollectionsKt.toIntArray(arrayList5);
                                    Bundle bundleAddInDefaultArgs = navDestination4.addInDefaultArgs(deepLinkMatchMatchDeepLinkComprehensive.matchingArgs);
                                    if (bundleAddInDefaultArgs != null) {
                                        bundle7.putAll(bundleAddInDefaultArgs);
                                    }
                                    arrayList = null;
                                    arrayDeque = arrayDeque4;
                                }
                                if (intArray != null && intArray.length != 0) {
                                    navGraph2 = navHostController._graph;
                                    length = intArray.length;
                                    i2 = 0;
                                    while (true) {
                                        if (i2 < length) {
                                            displayName = null;
                                            break;
                                        }
                                        i10 = intArray[i2];
                                        if (i2 == 0) {
                                            navDestinationFindNodeComprehensive2 = navHostController._graph;
                                            i11 = length;
                                            if (navDestinationFindNodeComprehensive2.id != i10) {
                                                navDestinationFindNodeComprehensive2 = null;
                                            }
                                        } else {
                                            i11 = length;
                                            navDestinationFindNodeComprehensive2 = navGraph2.findNodeComprehensive(i10, navGraph2, false, null);
                                        }
                                        if (navDestinationFindNodeComprehensive2 == null) {
                                            int i21 = NavDestination.$r8$clinit;
                                            displayName = NavDestination.Companion.getDisplayName(context, i10);
                                            break;
                                        }
                                        if (i2 == intArray.length - 1 && (navDestinationFindNodeComprehensive2 instanceof NavGraph)) {
                                            while (true) {
                                                navGraph5 = (NavGraph) navDestinationFindNodeComprehensive2;
                                                if (!(navGraph5.findNodeComprehensive(navGraph5.startDestId, navGraph5, false, null) instanceof NavGraph)) {
                                                    break;
                                                } else {
                                                    navDestinationFindNodeComprehensive2 = navGraph5.findNodeComprehensive(navGraph5.startDestId, navGraph5, false, null);
                                                }
                                            }
                                            navGraph2 = navGraph5;
                                        }
                                        i2++;
                                        length = i11;
                                    }
                                    if (displayName != null) {
                                        Log.i("NavController", "Could not find destination " + displayName + " in the navigation graph, ignoring the deep link from " + intent);
                                    } else {
                                        bundle7.putParcelable("android-support-nav:controller:deepLinkIntent", intent);
                                        length2 = intArray.length;
                                        bundleArr = new Bundle[length2];
                                        for (i3 = 0; i3 < length2; i3++) {
                                            Bundle bundle9 = new Bundle();
                                            bundle9.putAll(bundle7);
                                            if (arrayList == null && (bundle3 = (Bundle) arrayList.get(i3)) != null) {
                                                bundle9.putAll(bundle3);
                                            }
                                            bundleArr[i3] = bundle9;
                                        }
                                        int flags = intent.getFlags();
                                        i4 = 268435456 & flags;
                                        if (i4 == 0 && (flags & 32768) == 0) {
                                            intent.addFlags(32768);
                                            TaskStackBuilder taskStackBuilder = new TaskStackBuilder(context);
                                            ComponentName component = intent.getComponent();
                                            if (component == null) {
                                                component = intent.resolveActivity(((Context) taskStackBuilder.mSourceContext).getPackageManager());
                                            }
                                            if (component != null) {
                                                taskStackBuilder.addParentStack(component);
                                            }
                                            taskStackBuilder.mIntents.add(intent);
                                            taskStackBuilder.startActivities();
                                            activity.finish();
                                            activity.overridePendingTransition(0, 0);
                                        } else if (i4 != 0) {
                                            if (!arrayDeque.isEmpty()) {
                                                navHostController.popBackStackInternal(navHostController._graph.id, true, false);
                                            }
                                            i7 = 0;
                                            while (i7 < intArray.length) {
                                                i8 = intArray[i7];
                                                i9 = i7 + 1;
                                                bundle2 = bundleArr[i7];
                                                navDestinationFindDestination = navHostController.findDestination(i8, null);
                                                if (navDestinationFindDestination != null) {
                                                    navHostController.navigate(navDestinationFindDestination, bundle2, NavOptionsBuilderKt.navOptions(new NavController$handleDeepLink$2(0, navDestinationFindDestination, navHostController)));
                                                    i7 = i9;
                                                } else {
                                                    int i22 = NavDestination.$r8$clinit;
                                                    StringBuilder sbM16m2 = ImageAnalysis$$ExternalSyntheticLambda1.m16m("Deep Linking failed: destination ", NavDestination.Companion.getDisplayName(context, i8), " cannot be found from the current destination ");
                                                    navBackStackEntry3 = (NavBackStackEntry) arrayDeque.lastOrNull();
                                                    if (navBackStackEntry3 != null) {
                                                        navDestination3 = navBackStackEntry3.destination;
                                                    } else {
                                                        navDestination3 = null;
                                                    }
                                                    sbM16m2.append(navDestination3);
                                                    throw new IllegalStateException(sbM16m2.toString());
                                                }
                                            }
                                            navHostController.deepLinkHandled = true;
                                        } else {
                                            navGraph3 = navHostController._graph;
                                            length3 = intArray.length;
                                            for (i5 = 0; i5 < length3; i5++) {
                                                i6 = intArray[i5];
                                                bundle = bundleArr[i5];
                                                if (i5 == 0) {
                                                    navDestinationFindNodeComprehensive = navHostController._graph;
                                                    navDestination2 = null;
                                                    z7 = false;
                                                } else {
                                                    navDestination2 = null;
                                                    z7 = false;
                                                    navDestinationFindNodeComprehensive = navGraph3.findNodeComprehensive(i6, navGraph3, false, null);
                                                }
                                                if (navDestinationFindNodeComprehensive != null) {
                                                    if (i5 != intArray.length - 1) {
                                                        if (navDestinationFindNodeComprehensive instanceof NavGraph) {
                                                            navGraph4 = (NavGraph) navDestinationFindNodeComprehensive;
                                                            while (navGraph4.findNodeComprehensive(navGraph4.startDestId, navGraph4, z7, navDestination2) instanceof NavGraph) {
                                                                navGraph4 = (NavGraph) navGraph4.findNodeComprehensive(navGraph4.startDestId, navGraph4, z7, navDestination2);
                                                                navDestination2 = null;
                                                                z7 = false;
                                                            }
                                                            navGraph3 = navGraph4;
                                                        }
                                                    } else {
                                                        navHostController.navigate(navDestinationFindNodeComprehensive, bundle, new NavOptions(false, false, navHostController._graph.id, true, false, 0, 0));
                                                    }
                                                } else {
                                                    int i23 = NavDestination.$r8$clinit;
                                                    throw new IllegalStateException("Deep Linking failed: destination " + NavDestination.Companion.getDisplayName(context, i6) + " cannot be found in graph " + navGraph3);
                                                }
                                            }
                                            navHostController.deepLinkHandled = true;
                                        }
                                    }
                                }
                            } else {
                                arrayDeque2 = arrayDeque3;
                            }
                            lifecycleOwner = lifecycleOwner3;
                            arrayList = arrayList4;
                            arrayDeque = arrayDeque2;
                            if (intArray != null) {
                                navGraph2 = navHostController._graph;
                                length = intArray.length;
                                i2 = 0;
                                while (true) {
                                    if (i2 < length) {
                                        displayName = null;
                                        break;
                                    }
                                    i10 = intArray[i2];
                                    if (i2 == 0) {
                                        navDestinationFindNodeComprehensive2 = navHostController._graph;
                                        i11 = length;
                                        if (navDestinationFindNodeComprehensive2.id != i10) {
                                            navDestinationFindNodeComprehensive2 = null;
                                        }
                                    } else {
                                        i11 = length;
                                        navDestinationFindNodeComprehensive2 = navGraph2.findNodeComprehensive(i10, navGraph2, false, null);
                                    }
                                    if (navDestinationFindNodeComprehensive2 == null) {
                                        int i24 = NavDestination.$r8$clinit;
                                        displayName = NavDestination.Companion.getDisplayName(context, i10);
                                        break;
                                    } else {
                                        if (i2 == intArray.length - 1) {
                                        }
                                        i2++;
                                        length = i11;
                                    }
                                }
                                if (displayName != null) {
                                    Log.i("NavController", "Could not find destination " + displayName + " in the navigation graph, ignoring the deep link from " + intent);
                                } else {
                                    bundle7.putParcelable("android-support-nav:controller:deepLinkIntent", intent);
                                    length2 = intArray.length;
                                    bundleArr = new Bundle[length2];
                                    while (i3 < length2) {
                                        Bundle bundle10 = new Bundle();
                                        bundle10.putAll(bundle7);
                                        if (arrayList == null) {
                                        }
                                        bundleArr[i3] = bundle10;
                                    }
                                    int flags2 = intent.getFlags();
                                    i4 = 268435456 & flags2;
                                    if (i4 == 0) {
                                        if (i4 != 0) {
                                            if (!arrayDeque.isEmpty()) {
                                                navHostController.popBackStackInternal(navHostController._graph.id, true, false);
                                            }
                                            i7 = 0;
                                            while (i7 < intArray.length) {
                                                i8 = intArray[i7];
                                                i9 = i7 + 1;
                                                bundle2 = bundleArr[i7];
                                                navDestinationFindDestination = navHostController.findDestination(i8, null);
                                                if (navDestinationFindDestination != null) {
                                                    navHostController.navigate(navDestinationFindDestination, bundle2, NavOptionsBuilderKt.navOptions(new NavController$handleDeepLink$2(0, navDestinationFindDestination, navHostController)));
                                                    i7 = i9;
                                                } else {
                                                    int i25 = NavDestination.$r8$clinit;
                                                    StringBuilder sbM16m3 = ImageAnalysis$$ExternalSyntheticLambda1.m16m("Deep Linking failed: destination ", NavDestination.Companion.getDisplayName(context, i8), " cannot be found from the current destination ");
                                                    navBackStackEntry3 = (NavBackStackEntry) arrayDeque.lastOrNull();
                                                    if (navBackStackEntry3 != null) {
                                                        navDestination3 = navBackStackEntry3.destination;
                                                    } else {
                                                        navDestination3 = null;
                                                    }
                                                    sbM16m3.append(navDestination3);
                                                    throw new IllegalStateException(sbM16m3.toString());
                                                }
                                            }
                                            navHostController.deepLinkHandled = true;
                                        } else {
                                            navGraph3 = navHostController._graph;
                                            length3 = intArray.length;
                                            while (i5 < length3) {
                                                i6 = intArray[i5];
                                                bundle = bundleArr[i5];
                                                if (i5 == 0) {
                                                    navDestinationFindNodeComprehensive = navHostController._graph;
                                                    navDestination2 = null;
                                                    z7 = false;
                                                } else {
                                                    navDestination2 = null;
                                                    z7 = false;
                                                    navDestinationFindNodeComprehensive = navGraph3.findNodeComprehensive(i6, navGraph3, false, null);
                                                }
                                                if (navDestinationFindNodeComprehensive != null) {
                                                    if (i5 != intArray.length - 1) {
                                                        if (navDestinationFindNodeComprehensive instanceof NavGraph) {
                                                            navGraph4 = (NavGraph) navDestinationFindNodeComprehensive;
                                                            while (navGraph4.findNodeComprehensive(navGraph4.startDestId, navGraph4, z7, navDestination2) instanceof NavGraph) {
                                                                navGraph4 = (NavGraph) navGraph4.findNodeComprehensive(navGraph4.startDestId, navGraph4, z7, navDestination2);
                                                                navDestination2 = null;
                                                                z7 = false;
                                                            }
                                                            navGraph3 = navGraph4;
                                                        }
                                                    } else {
                                                        navHostController.navigate(navDestinationFindNodeComprehensive, bundle, new NavOptions(false, false, navHostController._graph.id, true, false, 0, 0));
                                                    }
                                                } else {
                                                    int i26 = NavDestination.$r8$clinit;
                                                    throw new IllegalStateException("Deep Linking failed: destination " + NavDestination.Companion.getDisplayName(context, i6) + " cannot be found in graph " + navGraph3);
                                                }
                                            }
                                            navHostController.deepLinkHandled = true;
                                        }
                                    } else if (i4 != 0) {
                                        if (!arrayDeque.isEmpty()) {
                                            navHostController.popBackStackInternal(navHostController._graph.id, true, false);
                                        }
                                        i7 = 0;
                                        while (i7 < intArray.length) {
                                            i8 = intArray[i7];
                                            i9 = i7 + 1;
                                            bundle2 = bundleArr[i7];
                                            navDestinationFindDestination = navHostController.findDestination(i8, null);
                                            if (navDestinationFindDestination != null) {
                                                navHostController.navigate(navDestinationFindDestination, bundle2, NavOptionsBuilderKt.navOptions(new NavController$handleDeepLink$2(0, navDestinationFindDestination, navHostController)));
                                                i7 = i9;
                                            } else {
                                                int i27 = NavDestination.$r8$clinit;
                                                StringBuilder sbM16m4 = ImageAnalysis$$ExternalSyntheticLambda1.m16m("Deep Linking failed: destination ", NavDestination.Companion.getDisplayName(context, i8), " cannot be found from the current destination ");
                                                navBackStackEntry3 = (NavBackStackEntry) arrayDeque.lastOrNull();
                                                if (navBackStackEntry3 != null) {
                                                    navDestination3 = navBackStackEntry3.destination;
                                                } else {
                                                    navDestination3 = null;
                                                }
                                                sbM16m4.append(navDestination3);
                                                throw new IllegalStateException(sbM16m4.toString());
                                            }
                                        }
                                        navHostController.deepLinkHandled = true;
                                    } else {
                                        navGraph3 = navHostController._graph;
                                        length3 = intArray.length;
                                        while (i5 < length3) {
                                            i6 = intArray[i5];
                                            bundle = bundleArr[i5];
                                            if (i5 == 0) {
                                                navDestinationFindNodeComprehensive = navHostController._graph;
                                                navDestination2 = null;
                                                z7 = false;
                                            } else {
                                                navDestination2 = null;
                                                z7 = false;
                                                navDestinationFindNodeComprehensive = navGraph3.findNodeComprehensive(i6, navGraph3, false, null);
                                            }
                                            if (navDestinationFindNodeComprehensive != null) {
                                                if (i5 != intArray.length - 1) {
                                                    if (navDestinationFindNodeComprehensive instanceof NavGraph) {
                                                        navGraph4 = (NavGraph) navDestinationFindNodeComprehensive;
                                                        while (navGraph4.findNodeComprehensive(navGraph4.startDestId, navGraph4, z7, navDestination2) instanceof NavGraph) {
                                                            navGraph4 = (NavGraph) navGraph4.findNodeComprehensive(navGraph4.startDestId, navGraph4, z7, navDestination2);
                                                            navDestination2 = null;
                                                            z7 = false;
                                                        }
                                                        navGraph3 = navGraph4;
                                                    }
                                                } else {
                                                    navHostController.navigate(navDestinationFindNodeComprehensive, bundle, new NavOptions(false, false, navHostController._graph.id, true, false, 0, 0));
                                                }
                                            } else {
                                                int i28 = NavDestination.$r8$clinit;
                                                throw new IllegalStateException("Deep Linking failed: destination " + NavDestination.Companion.getDisplayName(context, i6) + " cannot be found in graph " + navGraph3);
                                            }
                                        }
                                        navHostController.deepLinkHandled = true;
                                    }
                                }
                            }
                        }
                        composeNavigator = null;
                        navHostController.navigate(navHostController._graph, null, null);
                        navigator = navigatorProvider3.getNavigator("composable");
                        if (navigator instanceof ComposeNavigator) {
                            composeNavigator2 = (ComposeNavigator) navigator;
                        } else {
                            composeNavigator2 = composeNavigator;
                        }
                        if (composeNavigator2 == null) {
                            recomposeScopeImplEndRestartGroup2 = gapComposer.endRestartGroup();
                            if (recomposeScopeImplEndRestartGroup2 != null) {
                                final int i29 = 1;
                                recomposeScopeImplEndRestartGroup2.block = new Function2() { // from class: androidx.navigation.compose.NavHostKt.NavHost.34
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj14, Object obj15) {
                                        switch (i29) {
                                            case 0:
                                                ((Number) obj15).intValue();
                                                NavHostKt.NavHost(navHostController, navGraph, modifier, alignment, function1, function2, function3, function4, (GapComposer) obj14, Stack.updateChangedFlags(i | 1));
                                                break;
                                            case 1:
                                                ((Number) obj15).intValue();
                                                NavHostKt.NavHost(navHostController, navGraph, modifier, alignment, function1, function2, function3, function4, (GapComposer) obj14, Stack.updateChangedFlags(i | 1));
                                                break;
                                            default:
                                                ((Number) obj15).intValue();
                                                NavHostKt.NavHost(navHostController, navGraph, modifier, alignment, function1, function2, function3, function4, (GapComposer) obj14, Stack.updateChangedFlags(i | 1));
                                                break;
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                return;
                            }
                            return;
                        }
                        mutableStateCollectAsState = Stack.collectAsState(composeNavigator2.getState().backStack, gapComposer, 0);
                        objRememberedValue = gapComposer.rememberedValue();
                        neverEqualPolicy = Composer$Companion.Empty;
                        if (objRememberedValue == neverEqualPolicy) {
                            obj = objRememberedValue;
                            ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState2 = new ParcelableSnapshotMutableFloatState(0.0f);
                            gapComposer.updateRememberedValue(parcelableSnapshotMutableFloatState2);
                            obj = parcelableSnapshotMutableFloatState2;
                        }
                        obj = objRememberedValue;
                        parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) obj;
                        objRememberedValue2 = gapComposer.rememberedValue();
                        obj2 = objRememberedValue2;
                        if (objRememberedValue2 == neverEqualPolicy) {
                            ParcelableSnapshotMutableState parcelableSnapshotMutableStateMutableStateOf$default = Stack.mutableStateOf$default(Boolean.FALSE);
                            gapComposer.updateRememberedValue(parcelableSnapshotMutableStateMutableStateOf$default);
                            obj2 = parcelableSnapshotMutableStateMutableStateOf$default;
                        }
                        mutableState = (MutableState) obj2;
                        if (((List) mutableStateCollectAsState.getValue()).size() > 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        zChanged = gapComposer.changed(mutableStateCollectAsState) | gapComposer.changed(composeNavigator2);
                        objRememberedValue3 = gapComposer.rememberedValue();
                        if (!zChanged || objRememberedValue3 == neverEqualPolicy) {
                            objRememberedValue3 = new RealImageLoader$executeMain$result$1(composeNavigator2, mutableStateCollectAsState, parcelableSnapshotMutableFloatState, mutableState, null, 10);
                            mutableState2 = mutableStateCollectAsState;
                            gapComposer.updateRememberedValue(objRememberedValue3);
                        } else {
                            mutableState2 = mutableStateCollectAsState;
                        }
                        QRContent.PredictiveBackHandler(z, (Function2) objRememberedValue3, gapComposer, 0);
                        lifecycleOwner2 = lifecycleOwner;
                        zChangedInstance = gapComposer.changedInstance(navHostController) | gapComposer.changedInstance(lifecycleOwner2);
                        Object objRememberedValue12 = gapComposer.rememberedValue();
                        obj3 = objRememberedValue12;
                        if (!zChangedInstance || objRememberedValue12 == neverEqualPolicy) {
                            NavController$handleDeepLink$2 navController$handleDeepLink$2 = new NavController$handleDeepLink$2(navHostController, lifecycleOwner2);
                            gapComposer.updateRememberedValue(navController$handleDeepLink$2);
                            obj3 = navController$handleDeepLink$2;
                        }
                        Stack.DisposableEffect(lifecycleOwner2, (Function1) obj3, gapComposer);
                        saveableStateHolderImplRememberSaveableStateHolder = SaverKt.rememberSaveableStateHolder(gapComposer);
                        mutableStateCollectAsState2 = Stack.collectAsState(navHostController.visibleEntries, gapComposer, 0);
                        objRememberedValue4 = gapComposer.rememberedValue();
                        obj4 = objRememberedValue4;
                        if (objRememberedValue4 == neverEqualPolicy) {
                            DerivedSnapshotState derivedSnapshotStateDerivedStateOf = Stack.derivedStateOf(new Handshake.AnonymousClass2(20, mutableStateCollectAsState2));
                            gapComposer.updateRememberedValue(derivedSnapshotStateDerivedStateOf);
                            obj4 = derivedSnapshotStateDerivedStateOf;
                        }
                        state = (State) obj4;
                        navBackStackEntry = (NavBackStackEntry) CollectionsKt.lastOrNull((List) state.getValue());
                        objRememberedValue5 = gapComposer.rememberedValue();
                        obj5 = objRememberedValue5;
                        if (objRememberedValue5 == neverEqualPolicy) {
                            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                            gapComposer.updateRememberedValue(linkedHashMap2);
                            obj5 = linkedHashMap2;
                        }
                        map = (Map) obj5;
                        gapComposer.startReplaceGroup(653365120);
                        if (navBackStackEntry != null) {
                            boolean zChanged5 = gapComposer.changed(composeNavigator2) | ((((i13 & 3670016) ^ 1572864) <= 1048576 && gapComposer.changed(function3)) || (i13 & 1572864) == 1048576);
                            if ((i13 & 57344) == 16384) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            z3 = zChanged5 | z2;
                            Object objRememberedValue13 = gapComposer.rememberedValue();
                            if (!z3 || objRememberedValue13 == neverEqualPolicy) {
                                ComposeNavigator composeNavigator6 = composeNavigator2;
                                navigatorProvider2 = navigatorProvider3;
                                composeNavigator4 = composeNavigator6;
                                navController$navigate$5 = new NavController$navigate$5(composeNavigator4, function3, function1, mutableState, 1);
                                gapComposer.updateRememberedValue(navController$navigate$5);
                            } else {
                                navController$navigate$5 = objRememberedValue13;
                                composeNavigator4 = composeNavigator2;
                                navigatorProvider2 = navigatorProvider3;
                            }
                            function5 = (Function1) navController$navigate$5;
                            boolean zChanged6 = gapComposer.changed(composeNavigator4) | ((((i13 & 29360128) ^ 12582912) <= 8388608 && gapComposer.changed(function4)) || (i13 & 12582912) == 8388608);
                            if ((i13 & 458752) == 131072) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            z5 = zChanged6 | z4;
                            objRememberedValue6 = gapComposer.rememberedValue();
                            if (!z5 || objRememberedValue6 == neverEqualPolicy) {
                                function6 = function5;
                                NavController$navigate$5 navController$navigate$6 = new NavController$navigate$5(composeNavigator4, function4, function2, mutableState, 2);
                                gapComposer.updateRememberedValue(navController$navigate$6);
                                objRememberedValue6 = navController$navigate$6;
                            } else {
                                function6 = function5;
                            }
                            function7 = (Function1) objRememberedValue6;
                            if ((i13 & 234881024) == 67108864) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            Object objRememberedValue14 = gapComposer.rememberedValue();
                            obj6 = objRememberedValue14;
                            if (!z6 || objRememberedValue14 == neverEqualPolicy) {
                                AnonymousClass7 anonymousClass7 = new AnonymousClass7(1, 3);
                                gapComposer.updateRememberedValue(anonymousClass7);
                                obj6 = anonymousClass7;
                            }
                            function8 = (Function1) obj6;
                            Boolean bool = Boolean.TRUE;
                            zChanged2 = gapComposer.changed(composeNavigator4);
                            Object objRememberedValue15 = gapComposer.rememberedValue();
                            obj7 = objRememberedValue15;
                            if (!zChanged2 || objRememberedValue15 == neverEqualPolicy) {
                                NavController$handleDeepLink$2 navController$handleDeepLink$3 = new NavController$handleDeepLink$2(12, state, composeNavigator4);
                                gapComposer.updateRememberedValue(navController$handleDeepLink$3);
                                obj7 = navController$handleDeepLink$3;
                            }
                            Stack.DisposableEffect(bool, (Function1) obj7, gapComposer);
                            objRememberedValue7 = gapComposer.rememberedValue();
                            obj8 = objRememberedValue7;
                            if (objRememberedValue7 == neverEqualPolicy) {
                                SeekableTransitionState seekableTransitionState3 = new SeekableTransitionState(navBackStackEntry);
                                gapComposer.updateRememberedValue(seekableTransitionState3);
                                obj8 = seekableTransitionState3;
                            }
                            seekableTransitionState = (SeekableTransitionState) obj8;
                            transitionRememberTransition = ArcSplineKt.rememberTransition(seekableTransitionState, "entry", gapComposer, 56);
                            if (NavHost$lambda$11(mutableState)) {
                                gapComposer.startReplaceGroup(-1218260648);
                                Float fValueOf = Float.valueOf(parcelableSnapshotMutableFloatState.getFloatValue());
                                zChanged4 = gapComposer.changed(mutableState2) | gapComposer.changedInstance(seekableTransitionState);
                                objRememberedValue11 = gapComposer.rememberedValue();
                                if (!zChanged4 || objRememberedValue11 == neverEqualPolicy) {
                                    composeNavigator3 = null;
                                    objRememberedValue11 = new NavHostKt$NavHost$28$1(seekableTransitionState, mutableState2, parcelableSnapshotMutableFloatState, false ? 1 : 0, 0);
                                    gapComposer.updateRememberedValue(objRememberedValue11);
                                } else {
                                    composeNavigator3 = null;
                                }
                                Stack.LaunchedEffect(gapComposer, fValueOf, (Function2) objRememberedValue11);
                                gapComposer.end(false);
                                transition = transitionRememberTransition;
                                seekableTransitionState2 = seekableTransitionState;
                                navBackStackEntry2 = navBackStackEntry;
                            } else {
                                composeNavigator3 = null;
                                z8 = false;
                                gapComposer.startReplaceGroup(-1218005611);
                                zChangedInstance2 = gapComposer.changedInstance(seekableTransitionState) | gapComposer.changedInstance(navBackStackEntry) | gapComposer.changed(transitionRememberTransition);
                                objRememberedValue8 = gapComposer.rememberedValue();
                                if (!zChangedInstance2 || objRememberedValue8 == neverEqualPolicy) {
                                    transition = transitionRememberTransition;
                                    seekableTransitionState2 = seekableTransitionState;
                                    objRememberedValue8 = new NavHostKt$NavHost$29$1(seekableTransitionState2, navBackStackEntry, transition, z8 ? 1 : 0, 0);
                                    navBackStackEntry2 = navBackStackEntry;
                                    gapComposer.updateRememberedValue(objRememberedValue8);
                                } else {
                                    transition = transitionRememberTransition;
                                    seekableTransitionState2 = seekableTransitionState;
                                    navBackStackEntry2 = navBackStackEntry;
                                }
                                Stack.LaunchedEffect(gapComposer, navBackStackEntry2, (Function2) objRememberedValue8);
                                gapComposer.end(false);
                            }
                            zChangedInstance3 = gapComposer.changedInstance(map) | gapComposer.changed(composeNavigator4) | gapComposer.changed(function6) | gapComposer.changed(function7) | gapComposer.changed(function8);
                            objRememberedValue9 = gapComposer.rememberedValue();
                            if (!zChangedInstance3 || objRememberedValue9 == neverEqualPolicy) {
                                final ComposeNavigator composeNavigator7 = composeNavigator4;
                                final Function1 function9 = function6;
                                state2 = state;
                                objRememberedValue9 = new Function1() { // from class: androidx.navigation.compose.NavHostKt$NavHost$30$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj14) {
                                        float fFloatValue;
                                        AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl = (AnimatedContentTransitionScopeImpl) obj14;
                                        if (!((List) state2.getValue()).contains(animatedContentTransitionScopeImpl.getInitialState())) {
                                            return AnimatedContentKt.togetherWith(EnterTransitionImpl.None, ExitTransitionImpl.None);
                                        }
                                        String str3 = ((NavBackStackEntry) animatedContentTransitionScopeImpl.getInitialState()).id;
                                        Map map3 = map;
                                        Float f = (Float) map3.get(str3);
                                        if (f != null) {
                                            fFloatValue = f.floatValue();
                                        } else {
                                            map3.put(((NavBackStackEntry) animatedContentTransitionScopeImpl.getInitialState()).id, Float.valueOf(0.0f));
                                            fFloatValue = 0.0f;
                                        }
                                        if (!Intrinsics.areEqual(((NavBackStackEntry) animatedContentTransitionScopeImpl.getTargetState()).id, ((NavBackStackEntry) animatedContentTransitionScopeImpl.getInitialState()).id)) {
                                            fFloatValue = (((Boolean) composeNavigator7.isPop.getValue()).booleanValue() || ((Boolean) mutableState.getValue()).booleanValue()) ? fFloatValue - 1.0f : fFloatValue + 1.0f;
                                        }
                                        map3.put(((NavBackStackEntry) animatedContentTransitionScopeImpl.getTargetState()).id, Float.valueOf(fFloatValue));
                                        return new ContentTransform((EnterTransitionImpl) function9.invoke(animatedContentTransitionScopeImpl), (ExitTransitionImpl) function7.invoke(animatedContentTransitionScopeImpl), fFloatValue, (SizeTransformImpl) function8.invoke(animatedContentTransitionScopeImpl));
                                    }
                                };
                                map2 = map;
                                composeNavigator5 = composeNavigator7;
                                mutableState3 = mutableState;
                                gapComposer.updateRememberedValue(objRememberedValue9);
                            } else {
                                map2 = map;
                                state2 = state;
                                mutableState3 = mutableState;
                                composeNavigator5 = composeNavigator4;
                            }
                            final MutableState mutableState4 = mutableState3;
                            final SeekableTransitionState seekableTransitionState4 = seekableTransitionState2;
                            state3 = state2;
                            final NavBackStackEntry navBackStackEntry7 = navBackStackEntry2;
                            navigatorProvider = navigatorProvider2;
                            transition2 = transition;
                            AnimatedContentKt.AnimatedContent(transition2, modifier, (Function1) objRememberedValue9, alignment, AnonymousClass7.INSTANCE$1, Thread_jvmKt.rememberComposableLambda(820763100, new Function4() { // from class: androidx.navigation.compose.NavHostKt.NavHost.32

                                /* JADX INFO: renamed from: androidx.navigation.compose.NavHostKt$NavHost$32$1, reason: invalid class name */
                                /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
                                public final class AnonymousClass1 extends Lambda implements Function2 {
                                    public final /* synthetic */ Object $currentEntry;
                                    public final /* synthetic */ int $r8$classId;
                                    public final /* synthetic */ Object $this_AnimatedContent;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    public /* synthetic */ AnonymousClass1(int i, int i2, Object obj, Object obj2) {
                                        super(2);
                                        this.$r8$classId = i2;
                                        this.$currentEntry = obj;
                                        this.$this_AnimatedContent = obj2;
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        int i = this.$r8$classId;
                                        Object obj3 = this.$this_AnimatedContent;
                                        Object obj4 = this.$currentEntry;
                                        switch (i) {
                                            case 0:
                                                GapComposer gapComposer = (GapComposer) obj;
                                                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
                                                    gapComposer.skipToGroupEnd();
                                                } else {
                                                    NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj4;
                                                    ((ComposeNavigator.Destination) navBackStackEntry.destination).content.invoke((AnimatedContentScopeImpl) obj3, navBackStackEntry, gapComposer, 0);
                                                }
                                                break;
                                            case 1:
                                                int iIntValue = ((Number) obj).intValue();
                                                SemanticsNode semanticsNode = (SemanticsNode) obj2;
                                                AndroidContentCaptureManager androidContentCaptureManager = (AndroidContentCaptureManager) obj3;
                                                if (!((SemanticsNodeCopy) obj4).children.contains(semanticsNode.id)) {
                                                    androidContentCaptureManager.updateBuffersOnAppeared(iIntValue, semanticsNode);
                                                    androidContentCaptureManager.boundsUpdateChannel.mo842trySendJP2dKIU(Unit.INSTANCE);
                                                }
                                                break;
                                            case 2:
                                                GapComposer gapComposer2 = (GapComposer) obj;
                                                int iIntValue2 = ((Number) obj2).intValue();
                                                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                                                    Boolean bool = (Boolean) ((LayoutNodeSubcompositionsState.NodeState) obj4).activeState.getValue();
                                                    boolean zBooleanValue = bool.booleanValue();
                                                    Function2 function2 = (Function2) obj3;
                                                    gapComposer2.startReusableGroup(bool);
                                                    boolean zChanged = gapComposer2.changed(zBooleanValue);
                                                    if (zBooleanValue) {
                                                        function2.invoke(gapComposer2, 0);
                                                    } else {
                                                        if (gapComposer2.groupNodeCount != 0) {
                                                            ComposerKt.composeImmediateRuntimeError("No nodes can be emitted before calling deactivateToEndGroup");
                                                        }
                                                        if (!gapComposer2.inserting) {
                                                            if (zChanged) {
                                                                SlotReader slotReader = gapComposer2.reader;
                                                                int i2 = slotReader.currentGroup;
                                                                int i3 = slotReader.currentEnd;
                                                                ComposerChangeListWriter composerChangeListWriter = gapComposer2.changeListWriter;
                                                                composerChangeListWriter.getClass();
                                                                composerChangeListWriter.realizeOperationLocation(false);
                                                                composerChangeListWriter.changeList.operations.pushOp(Operation.DeactivateCurrentGroup.INSTANCE);
                                                                Stack.access$removeRange(gapComposer2.invalidations, i2, i3);
                                                                gapComposer2.reader.skipToGroupEnd();
                                                            } else {
                                                                gapComposer2.skipReaderToGroupEnd();
                                                            }
                                                        }
                                                    }
                                                    if (gapComposer2.reusing && gapComposer2.reader.parent == gapComposer2.reusingGroup) {
                                                        gapComposer2.reusingGroup = -1;
                                                        gapComposer2.reusing = false;
                                                    }
                                                    gapComposer2.end(false);
                                                } else {
                                                    gapComposer2.skipToGroupEnd();
                                                }
                                                break;
                                            case 3:
                                                ((Number) obj2).intValue();
                                                RulerKt.SubcomposeLayout((Modifier) obj4, (Function2) obj3, (GapComposer) obj, Stack.updateChangedFlags(1));
                                                break;
                                            case 4:
                                                Canvas canvas = (Canvas) obj;
                                                GraphicsLayer graphicsLayer = (GraphicsLayer) obj2;
                                                NodeCoordinator nodeCoordinator = (NodeCoordinator) obj4;
                                                LayoutNode layoutNode = nodeCoordinator.layoutNode;
                                                if (layoutNode.isPlaced()) {
                                                    nodeCoordinator.drawBlockCanvas = canvas;
                                                    nodeCoordinator.drawBlockParentLayer = graphicsLayer;
                                                    OwnerSnapshotObserver snapshotObserver = ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNode)).getSnapshotObserver();
                                                    ReusableGraphicsLayerScope reusableGraphicsLayerScope = NodeCoordinator.graphicsLayerScope;
                                                    snapshotObserver.observer.observeReads(nodeCoordinator, OwnerSnapshotObserver$onCommitAffectingLayout$1.INSTANCE$3, (NodeCoordinator$invalidateParentLayer$1) obj3);
                                                    nodeCoordinator.lastLayerDrawingWasSkipped = false;
                                                } else {
                                                    nodeCoordinator.lastLayerDrawingWasSkipped = true;
                                                }
                                                break;
                                            case 5:
                                                GapComposer gapComposer3 = (GapComposer) obj;
                                                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer3.getSkipping()) {
                                                    gapComposer3.skipToGroupEnd();
                                                } else {
                                                    ((DialogNavigator.Destination) obj3).content.invoke(obj4, (Object) gapComposer3, (Object) 0);
                                                }
                                                break;
                                            case 6:
                                                ((Number) obj2).intValue();
                                                DialogHostKt.PopulateVisibleList((List) obj4, (Collection) obj3, (GapComposer) obj, Stack.updateChangedFlags(1));
                                                break;
                                            default:
                                                GapComposer gapComposer4 = (GapComposer) obj;
                                                if ((((Number) obj2).intValue() & 3) == 2 && gapComposer4.getSkipping()) {
                                                    gapComposer4.skipToGroupEnd();
                                                } else {
                                                    NavBackStackEntryProviderKt.access$SaveableStateProvider((SaveableStateHolder) obj4, (ComposableLambdaImpl) obj3, gapComposer4, 0);
                                                }
                                                break;
                                        }
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    public /* synthetic */ AnonymousClass1(int i, Object obj, Object obj2) {
                                        super(2);
                                        this.$r8$classId = i;
                                        this.$currentEntry = obj;
                                        this.$this_AnimatedContent = obj2;
                                    }

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    public AnonymousClass1(DialogNavigator.Destination destination, NavBackStackEntry navBackStackEntry) {
                                        super(2);
                                        this.$r8$classId = 5;
                                        this.$this_AnimatedContent = destination;
                                        this.$currentEntry = navBackStackEntry;
                                    }
                                }

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(4);
                                }

                                @Override // kotlin.jvm.functions.Function4
                                public final Object invoke(Object obj14, Object obj15, Object obj16, Object obj17) {
                                    Object objPrevious;
                                    AnimatedContentScopeImpl animatedContentScopeImpl = (AnimatedContentScopeImpl) obj14;
                                    NavBackStackEntry navBackStackEntry8 = (NavBackStackEntry) obj15;
                                    GapComposer gapComposer3 = (GapComposer) obj16;
                                    ((Number) obj17).intValue();
                                    boolean zAreEqual = Intrinsics.areEqual(seekableTransitionState4.currentState$delegate.getValue(), navBackStackEntry7);
                                    if (!((Boolean) mutableState4.getValue()).booleanValue() && !zAreEqual) {
                                        List list2 = (List) state3.getValue();
                                        ListIterator listIterator = list2.listIterator(list2.size());
                                        do {
                                            if (!listIterator.hasPrevious()) {
                                                objPrevious = null;
                                                break;
                                            }
                                            objPrevious = listIterator.previous();
                                        } while (!Intrinsics.areEqual(navBackStackEntry8, (NavBackStackEntry) objPrevious));
                                        navBackStackEntry8 = (NavBackStackEntry) objPrevious;
                                    }
                                    if (navBackStackEntry8 != null) {
                                        NavBackStackEntryProviderKt.LocalOwnersProvider(navBackStackEntry8, saveableStateHolderImplRememberSaveableStateHolder, Thread_jvmKt.rememberComposableLambda(-1263531443, new AnonymousClass1(0, navBackStackEntry8, animatedContentScopeImpl), gapComposer3), gapComposer3, 384);
                                    }
                                    return Unit.INSTANCE;
                                }
                            }, gapComposer), gapComposer, ((i13 >> 3) & 112) | 221184 | (i13 & 7168));
                            gapComposer2 = gapComposer;
                            Object objMo773getCurrentState = transition2.transitionState.mo773getCurrentState();
                            Object value = transition2.targetState$delegate.getValue();
                            zChanged3 = gapComposer2.changed(transition2) | gapComposer2.changedInstance(navHostController) | gapComposer2.changed(composeNavigator5) | gapComposer2.changedInstance(map2);
                            objRememberedValue10 = gapComposer2.rememberedValue();
                            if (!zChanged3 || objRememberedValue10 == neverEqualPolicy) {
                                NavHostKt$NavHost$33$1 navHostKt$NavHost$33$1 = new NavHostKt$NavHost$33$1(transition2, navHostController, map2, state3, composeNavigator5, null, 0);
                                gapComposer2.updateRememberedValue(navHostKt$NavHost$33$1);
                                objRememberedValue10 = navHostKt$NavHost$33$1;
                            }
                            Stack.LaunchedEffect(objMo773getCurrentState, value, (Function2) objRememberedValue10, gapComposer2);
                        } else {
                            gapComposer2 = gapComposer;
                            composeNavigator3 = composeNavigator;
                            navigatorProvider = navigatorProvider3;
                        }
                        gapComposer2.end(false);
                        navigator2 = navigatorProvider.getNavigator("dialog");
                        if (navigator2 instanceof DialogNavigator) {
                            dialogNavigator2 = (DialogNavigator) navigator2;
                        } else {
                            dialogNavigator = composeNavigator3;
                        }
                        if (dialogNavigator == 0) {
                            recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
                            if (recomposeScopeImplEndRestartGroup != null) {
                                dialogNavigator = dialogNavigator2;
                                return;
                            }
                            dialogNavigator = dialogNavigator2;
                            final int i30 = 2;
                            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.navigation.compose.NavHostKt.NavHost.34
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj14, Object obj15) {
                                    switch (i30) {
                                        case 0:
                                            ((Number) obj15).intValue();
                                            NavHostKt.NavHost(navHostController, navGraph, modifier, alignment, function1, function2, function3, function4, (GapComposer) obj14, Stack.updateChangedFlags(i | 1));
                                            break;
                                        case 1:
                                            ((Number) obj15).intValue();
                                            NavHostKt.NavHost(navHostController, navGraph, modifier, alignment, function1, function2, function3, function4, (GapComposer) obj14, Stack.updateChangedFlags(i | 1));
                                            break;
                                        default:
                                            ((Number) obj15).intValue();
                                            NavHostKt.NavHost(navHostController, navGraph, modifier, alignment, function1, function2, function3, function4, (GapComposer) obj14, Stack.updateChangedFlags(i | 1));
                                            break;
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            return;
                        }
                        dialogNavigator = dialogNavigator2;
                        DialogHostKt.DialogHost(dialogNavigator, gapComposer2, 0);
                    } else {
                        i13 = i13;
                        lifecycleOwner = lifecycleOwner3;
                        navHostController.dispatchOnDestinationChanged();
                    }
                } else {
                    i13 = i13;
                    lifecycleOwner = lifecycleOwner3;
                    int size4 = sparseArrayCompat.size();
                    for (int i31 = 0; i31 < size4; i31++) {
                        NavDestination navDestination6 = (NavDestination) sparseArrayCompat.valueAt(i31);
                        int iKeyAt = navHostController._graph.nodes.keyAt(i31);
                        SparseArrayCompat sparseArrayCompat2 = navHostController._graph.nodes;
                        if (sparseArrayCompat2.garbage) {
                            ArraySetKt.access$gc(sparseArrayCompat2);
                        }
                        int iBinarySearch = RuntimeHelpersKt.binarySearch(sparseArrayCompat2.size, iKeyAt, sparseArrayCompat2.keys);
                        if (iBinarySearch >= 0) {
                            Object[] objArr = sparseArrayCompat2.values;
                            Object obj14 = objArr[iBinarySearch];
                            objArr[iBinarySearch] = navDestination6;
                        }
                    }
                    for (NavBackStackEntry navBackStackEntry8 : arrayDeque3) {
                        int i32 = NavDestination.$r8$clinit;
                        ReversedListReadOnly reversedListReadOnly = new ReversedListReadOnly(0, SequencesKt.toList(SequencesKt.generateSequence(navBackStackEntry8.destination, NavController$activity$1.INSTANCE$5)));
                        NavDestination navDestinationFindNodeComprehensive3 = navHostController._graph;
                        Iterator it4 = reversedListReadOnly.iterator();
                        while (true) {
                            ListIterator listIterator = (ListIterator) ((ReversedListReadOnly.AnonymousClass1) it4).delegateIterator;
                            if (listIterator.hasPrevious()) {
                                NavDestination navDestination7 = (NavDestination) listIterator.previous();
                                if ((!Intrinsics.areEqual(navDestination7, navHostController._graph) || !Intrinsics.areEqual(navDestinationFindNodeComprehensive3, navGraph)) && (navDestinationFindNodeComprehensive3 instanceof NavGraph)) {
                                    NavGraph navGraph10 = (NavGraph) navDestinationFindNodeComprehensive3;
                                    navDestinationFindNodeComprehensive3 = navGraph10.findNodeComprehensive(navDestination7.id, navGraph10, false, null);
                                }
                            }
                        }
                        navBackStackEntry8.destination = navDestinationFindNodeComprehensive3;
                    }
                }
                composeNavigator = null;
                navigator = navigatorProvider3.getNavigator("composable");
                if (navigator instanceof ComposeNavigator) {
                    composeNavigator2 = (ComposeNavigator) navigator;
                } else {
                    composeNavigator2 = composeNavigator;
                }
                if (composeNavigator2 == null) {
                    recomposeScopeImplEndRestartGroup2 = gapComposer.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup2 != null) {
                        final int i210 = 1;
                        recomposeScopeImplEndRestartGroup2.block = new Function2() { // from class: androidx.navigation.compose.NavHostKt.NavHost.34
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj15, Object obj16) {
                                switch (i210) {
                                    case 0:
                                        ((Number) obj16).intValue();
                                        NavHostKt.NavHost(navHostController, navGraph, modifier, alignment, function1, function2, function3, function4, (GapComposer) obj15, Stack.updateChangedFlags(i | 1));
                                        break;
                                    case 1:
                                        ((Number) obj16).intValue();
                                        NavHostKt.NavHost(navHostController, navGraph, modifier, alignment, function1, function2, function3, function4, (GapComposer) obj15, Stack.updateChangedFlags(i | 1));
                                        break;
                                    default:
                                        ((Number) obj16).intValue();
                                        NavHostKt.NavHost(navHostController, navGraph, modifier, alignment, function1, function2, function3, function4, (GapComposer) obj15, Stack.updateChangedFlags(i | 1));
                                        break;
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        return;
                    }
                    return;
                }
                mutableStateCollectAsState = Stack.collectAsState(composeNavigator2.getState().backStack, gapComposer, 0);
                objRememberedValue = gapComposer.rememberedValue();
                neverEqualPolicy = Composer$Companion.Empty;
                if (objRememberedValue == neverEqualPolicy) {
                    obj = objRememberedValue;
                    ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState3 = new ParcelableSnapshotMutableFloatState(0.0f);
                    gapComposer.updateRememberedValue(parcelableSnapshotMutableFloatState3);
                    obj = parcelableSnapshotMutableFloatState3;
                }
                obj = objRememberedValue;
                parcelableSnapshotMutableFloatState = (ParcelableSnapshotMutableFloatState) obj;
                objRememberedValue2 = gapComposer.rememberedValue();
                obj2 = objRememberedValue2;
                if (objRememberedValue2 == neverEqualPolicy) {
                    ParcelableSnapshotMutableState parcelableSnapshotMutableStateMutableStateOf$default2 = Stack.mutableStateOf$default(Boolean.FALSE);
                    gapComposer.updateRememberedValue(parcelableSnapshotMutableStateMutableStateOf$default2);
                    obj2 = parcelableSnapshotMutableStateMutableStateOf$default2;
                }
                mutableState = (MutableState) obj2;
                if (((List) mutableStateCollectAsState.getValue()).size() > 1) {
                    z = true;
                } else {
                    z = false;
                }
                zChanged = gapComposer.changed(mutableStateCollectAsState) | gapComposer.changed(composeNavigator2);
                objRememberedValue3 = gapComposer.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = new RealImageLoader$executeMain$result$1(composeNavigator2, mutableStateCollectAsState, parcelableSnapshotMutableFloatState, mutableState, null, 10);
                    mutableState2 = mutableStateCollectAsState;
                    gapComposer.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new RealImageLoader$executeMain$result$1(composeNavigator2, mutableStateCollectAsState, parcelableSnapshotMutableFloatState, mutableState, null, 10);
                    mutableState2 = mutableStateCollectAsState;
                    gapComposer.updateRememberedValue(objRememberedValue3);
                }
                QRContent.PredictiveBackHandler(z, (Function2) objRememberedValue3, gapComposer, 0);
                lifecycleOwner2 = lifecycleOwner;
                zChangedInstance = gapComposer.changedInstance(navHostController) | gapComposer.changedInstance(lifecycleOwner2);
                Object objRememberedValue16 = gapComposer.rememberedValue();
                obj3 = objRememberedValue16;
                if (!zChangedInstance) {
                    NavController$handleDeepLink$2 navController$handleDeepLink$4 = new NavController$handleDeepLink$2(navHostController, lifecycleOwner2);
                    gapComposer.updateRememberedValue(navController$handleDeepLink$4);
                    obj3 = navController$handleDeepLink$4;
                } else {
                    NavController$handleDeepLink$2 navController$handleDeepLink$5 = new NavController$handleDeepLink$2(navHostController, lifecycleOwner2);
                    gapComposer.updateRememberedValue(navController$handleDeepLink$5);
                    obj3 = navController$handleDeepLink$5;
                }
                Stack.DisposableEffect(lifecycleOwner2, (Function1) obj3, gapComposer);
                saveableStateHolderImplRememberSaveableStateHolder = SaverKt.rememberSaveableStateHolder(gapComposer);
                mutableStateCollectAsState2 = Stack.collectAsState(navHostController.visibleEntries, gapComposer, 0);
                objRememberedValue4 = gapComposer.rememberedValue();
                obj4 = objRememberedValue4;
                if (objRememberedValue4 == neverEqualPolicy) {
                    DerivedSnapshotState derivedSnapshotStateDerivedStateOf2 = Stack.derivedStateOf(new Handshake.AnonymousClass2(20, mutableStateCollectAsState2));
                    gapComposer.updateRememberedValue(derivedSnapshotStateDerivedStateOf2);
                    obj4 = derivedSnapshotStateDerivedStateOf2;
                }
                state = (State) obj4;
                navBackStackEntry = (NavBackStackEntry) CollectionsKt.lastOrNull((List) state.getValue());
                objRememberedValue5 = gapComposer.rememberedValue();
                obj5 = objRememberedValue5;
                if (objRememberedValue5 == neverEqualPolicy) {
                    LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                    gapComposer.updateRememberedValue(linkedHashMap3);
                    obj5 = linkedHashMap3;
                }
                map = (Map) obj5;
                gapComposer.startReplaceGroup(653365120);
                if (navBackStackEntry != null) {
                    boolean zChanged7 = gapComposer.changed(composeNavigator2) | ((((i13 & 3670016) ^ 1572864) <= 1048576 && gapComposer.changed(function3)) || (i13 & 1572864) == 1048576);
                    if ((i13 & 57344) == 16384) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    z3 = zChanged7 | z2;
                    Object objRememberedValue17 = gapComposer.rememberedValue();
                    if (z3) {
                        ComposeNavigator composeNavigator8 = composeNavigator2;
                        navigatorProvider2 = navigatorProvider3;
                        composeNavigator4 = composeNavigator8;
                        navController$navigate$5 = new NavController$navigate$5(composeNavigator4, function3, function1, mutableState, 1);
                        gapComposer.updateRememberedValue(navController$navigate$5);
                    } else {
                        ComposeNavigator composeNavigator9 = composeNavigator2;
                        navigatorProvider2 = navigatorProvider3;
                        composeNavigator4 = composeNavigator9;
                        navController$navigate$5 = new NavController$navigate$5(composeNavigator4, function3, function1, mutableState, 1);
                        gapComposer.updateRememberedValue(navController$navigate$5);
                    }
                    function5 = (Function1) navController$navigate$5;
                    boolean zChanged8 = gapComposer.changed(composeNavigator4) | ((((i13 & 29360128) ^ 12582912) <= 8388608 && gapComposer.changed(function4)) || (i13 & 12582912) == 8388608);
                    if ((i13 & 458752) == 131072) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    z5 = zChanged8 | z4;
                    objRememberedValue6 = gapComposer.rememberedValue();
                    if (z5) {
                        function6 = function5;
                        NavController$navigate$5 navController$navigate$7 = new NavController$navigate$5(composeNavigator4, function4, function2, mutableState, 2);
                        gapComposer.updateRememberedValue(navController$navigate$7);
                        objRememberedValue6 = navController$navigate$7;
                    } else {
                        function6 = function5;
                        NavController$navigate$5 navController$navigate$8 = new NavController$navigate$5(composeNavigator4, function4, function2, mutableState, 2);
                        gapComposer.updateRememberedValue(navController$navigate$8);
                        objRememberedValue6 = navController$navigate$8;
                    }
                    function7 = (Function1) objRememberedValue6;
                    if ((i13 & 234881024) == 67108864) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    Object objRememberedValue18 = gapComposer.rememberedValue();
                    obj6 = objRememberedValue18;
                    if (!z6) {
                        AnonymousClass7 anonymousClass8 = new AnonymousClass7(1, 3);
                        gapComposer.updateRememberedValue(anonymousClass8);
                        obj6 = anonymousClass8;
                    } else {
                        AnonymousClass7 anonymousClass9 = new AnonymousClass7(1, 3);
                        gapComposer.updateRememberedValue(anonymousClass9);
                        obj6 = anonymousClass9;
                    }
                    function8 = (Function1) obj6;
                    Boolean bool2 = Boolean.TRUE;
                    zChanged2 = gapComposer.changed(composeNavigator4);
                    Object objRememberedValue19 = gapComposer.rememberedValue();
                    obj7 = objRememberedValue19;
                    if (!zChanged2) {
                        NavController$handleDeepLink$2 navController$handleDeepLink$6 = new NavController$handleDeepLink$2(12, state, composeNavigator4);
                        gapComposer.updateRememberedValue(navController$handleDeepLink$6);
                        obj7 = navController$handleDeepLink$6;
                    } else {
                        NavController$handleDeepLink$2 navController$handleDeepLink$7 = new NavController$handleDeepLink$2(12, state, composeNavigator4);
                        gapComposer.updateRememberedValue(navController$handleDeepLink$7);
                        obj7 = navController$handleDeepLink$7;
                    }
                    Stack.DisposableEffect(bool2, (Function1) obj7, gapComposer);
                    objRememberedValue7 = gapComposer.rememberedValue();
                    obj8 = objRememberedValue7;
                    if (objRememberedValue7 == neverEqualPolicy) {
                        SeekableTransitionState seekableTransitionState5 = new SeekableTransitionState(navBackStackEntry);
                        gapComposer.updateRememberedValue(seekableTransitionState5);
                        obj8 = seekableTransitionState5;
                    }
                    seekableTransitionState = (SeekableTransitionState) obj8;
                    transitionRememberTransition = ArcSplineKt.rememberTransition(seekableTransitionState, "entry", gapComposer, 56);
                    if (NavHost$lambda$11(mutableState)) {
                        gapComposer.startReplaceGroup(-1218260648);
                        Float fValueOf2 = Float.valueOf(parcelableSnapshotMutableFloatState.getFloatValue());
                        zChanged4 = gapComposer.changed(mutableState2) | gapComposer.changedInstance(seekableTransitionState);
                        objRememberedValue11 = gapComposer.rememberedValue();
                        if (zChanged4) {
                            composeNavigator3 = null;
                            objRememberedValue11 = new NavHostKt$NavHost$28$1(seekableTransitionState, mutableState2, parcelableSnapshotMutableFloatState, false ? 1 : 0, 0);
                            gapComposer.updateRememberedValue(objRememberedValue11);
                        } else {
                            composeNavigator3 = null;
                            objRememberedValue11 = new NavHostKt$NavHost$28$1(seekableTransitionState, mutableState2, parcelableSnapshotMutableFloatState, false ? 1 : 0, 0);
                            gapComposer.updateRememberedValue(objRememberedValue11);
                        }
                        Stack.LaunchedEffect(gapComposer, fValueOf2, (Function2) objRememberedValue11);
                        gapComposer.end(false);
                        transition = transitionRememberTransition;
                        seekableTransitionState2 = seekableTransitionState;
                        navBackStackEntry2 = navBackStackEntry;
                    } else {
                        composeNavigator3 = null;
                        z8 = false;
                        gapComposer.startReplaceGroup(-1218005611);
                        zChangedInstance2 = gapComposer.changedInstance(seekableTransitionState) | gapComposer.changedInstance(navBackStackEntry) | gapComposer.changed(transitionRememberTransition);
                        objRememberedValue8 = gapComposer.rememberedValue();
                        if (zChangedInstance2) {
                            transition = transitionRememberTransition;
                            seekableTransitionState2 = seekableTransitionState;
                            objRememberedValue8 = new NavHostKt$NavHost$29$1(seekableTransitionState2, navBackStackEntry, transition, z8 ? 1 : 0, 0);
                            navBackStackEntry2 = navBackStackEntry;
                            gapComposer.updateRememberedValue(objRememberedValue8);
                        } else {
                            transition = transitionRememberTransition;
                            seekableTransitionState2 = seekableTransitionState;
                            objRememberedValue8 = new NavHostKt$NavHost$29$1(seekableTransitionState2, navBackStackEntry, transition, z8 ? 1 : 0, 0);
                            navBackStackEntry2 = navBackStackEntry;
                            gapComposer.updateRememberedValue(objRememberedValue8);
                        }
                        Stack.LaunchedEffect(gapComposer, navBackStackEntry2, (Function2) objRememberedValue8);
                        gapComposer.end(false);
                    }
                    zChangedInstance3 = gapComposer.changedInstance(map) | gapComposer.changed(composeNavigator4) | gapComposer.changed(function6) | gapComposer.changed(function7) | gapComposer.changed(function8);
                    objRememberedValue9 = gapComposer.rememberedValue();
                    if (zChangedInstance3) {
                        final ComposeNavigator composeNavigator10 = composeNavigator4;
                        final Function1 function10 = function6;
                        state2 = state;
                        objRememberedValue9 = new Function1() { // from class: androidx.navigation.compose.NavHostKt$NavHost$30$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj15) {
                                float fFloatValue;
                                AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl = (AnimatedContentTransitionScopeImpl) obj15;
                                if (!((List) state2.getValue()).contains(animatedContentTransitionScopeImpl.getInitialState())) {
                                    return AnimatedContentKt.togetherWith(EnterTransitionImpl.None, ExitTransitionImpl.None);
                                }
                                String str3 = ((NavBackStackEntry) animatedContentTransitionScopeImpl.getInitialState()).id;
                                Map map3 = map;
                                Float f = (Float) map3.get(str3);
                                if (f != null) {
                                    fFloatValue = f.floatValue();
                                } else {
                                    map3.put(((NavBackStackEntry) animatedContentTransitionScopeImpl.getInitialState()).id, Float.valueOf(0.0f));
                                    fFloatValue = 0.0f;
                                }
                                if (!Intrinsics.areEqual(((NavBackStackEntry) animatedContentTransitionScopeImpl.getTargetState()).id, ((NavBackStackEntry) animatedContentTransitionScopeImpl.getInitialState()).id)) {
                                    fFloatValue = (((Boolean) composeNavigator10.isPop.getValue()).booleanValue() || ((Boolean) mutableState.getValue()).booleanValue()) ? fFloatValue - 1.0f : fFloatValue + 1.0f;
                                }
                                map3.put(((NavBackStackEntry) animatedContentTransitionScopeImpl.getTargetState()).id, Float.valueOf(fFloatValue));
                                return new ContentTransform((EnterTransitionImpl) function10.invoke(animatedContentTransitionScopeImpl), (ExitTransitionImpl) function7.invoke(animatedContentTransitionScopeImpl), fFloatValue, (SizeTransformImpl) function8.invoke(animatedContentTransitionScopeImpl));
                            }
                        };
                        map2 = map;
                        composeNavigator5 = composeNavigator10;
                        mutableState3 = mutableState;
                        gapComposer.updateRememberedValue(objRememberedValue9);
                    } else {
                        final ComposeNavigator composeNavigator11 = composeNavigator4;
                        final Function1 function11 = function6;
                        state2 = state;
                        objRememberedValue9 = new Function1() { // from class: androidx.navigation.compose.NavHostKt$NavHost$30$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj15) {
                                float fFloatValue;
                                AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl = (AnimatedContentTransitionScopeImpl) obj15;
                                if (!((List) state2.getValue()).contains(animatedContentTransitionScopeImpl.getInitialState())) {
                                    return AnimatedContentKt.togetherWith(EnterTransitionImpl.None, ExitTransitionImpl.None);
                                }
                                String str3 = ((NavBackStackEntry) animatedContentTransitionScopeImpl.getInitialState()).id;
                                Map map3 = map;
                                Float f = (Float) map3.get(str3);
                                if (f != null) {
                                    fFloatValue = f.floatValue();
                                } else {
                                    map3.put(((NavBackStackEntry) animatedContentTransitionScopeImpl.getInitialState()).id, Float.valueOf(0.0f));
                                    fFloatValue = 0.0f;
                                }
                                if (!Intrinsics.areEqual(((NavBackStackEntry) animatedContentTransitionScopeImpl.getTargetState()).id, ((NavBackStackEntry) animatedContentTransitionScopeImpl.getInitialState()).id)) {
                                    fFloatValue = (((Boolean) composeNavigator11.isPop.getValue()).booleanValue() || ((Boolean) mutableState.getValue()).booleanValue()) ? fFloatValue - 1.0f : fFloatValue + 1.0f;
                                }
                                map3.put(((NavBackStackEntry) animatedContentTransitionScopeImpl.getTargetState()).id, Float.valueOf(fFloatValue));
                                return new ContentTransform((EnterTransitionImpl) function11.invoke(animatedContentTransitionScopeImpl), (ExitTransitionImpl) function7.invoke(animatedContentTransitionScopeImpl), fFloatValue, (SizeTransformImpl) function8.invoke(animatedContentTransitionScopeImpl));
                            }
                        };
                        map2 = map;
                        composeNavigator5 = composeNavigator11;
                        mutableState3 = mutableState;
                        gapComposer.updateRememberedValue(objRememberedValue9);
                    }
                    final MutableState mutableState5 = mutableState3;
                    final SeekableTransitionState seekableTransitionState6 = seekableTransitionState2;
                    state3 = state2;
                    final NavBackStackEntry navBackStackEntry9 = navBackStackEntry2;
                    navigatorProvider = navigatorProvider2;
                    transition2 = transition;
                    AnimatedContentKt.AnimatedContent(transition2, modifier, (Function1) objRememberedValue9, alignment, AnonymousClass7.INSTANCE$1, Thread_jvmKt.rememberComposableLambda(820763100, new Function4() { // from class: androidx.navigation.compose.NavHostKt.NavHost.32

                        /* JADX INFO: renamed from: androidx.navigation.compose.NavHostKt$NavHost$32$1, reason: invalid class name */
                        /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
                        public final class AnonymousClass1 extends Lambda implements Function2 {
                            public final /* synthetic */ Object $currentEntry;
                            public final /* synthetic */ int $r8$classId;
                            public final /* synthetic */ Object $this_AnimatedContent;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            public /* synthetic */ AnonymousClass1(int i, int i2, Object obj, Object obj2) {
                                super(2);
                                this.$r8$classId = i2;
                                this.$currentEntry = obj;
                                this.$this_AnimatedContent = obj2;
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                int i = this.$r8$classId;
                                Object obj3 = this.$this_AnimatedContent;
                                Object obj4 = this.$currentEntry;
                                switch (i) {
                                    case 0:
                                        GapComposer gapComposer = (GapComposer) obj;
                                        if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
                                            gapComposer.skipToGroupEnd();
                                        } else {
                                            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj4;
                                            ((ComposeNavigator.Destination) navBackStackEntry.destination).content.invoke((AnimatedContentScopeImpl) obj3, navBackStackEntry, gapComposer, 0);
                                        }
                                        break;
                                    case 1:
                                        int iIntValue = ((Number) obj).intValue();
                                        SemanticsNode semanticsNode = (SemanticsNode) obj2;
                                        AndroidContentCaptureManager androidContentCaptureManager = (AndroidContentCaptureManager) obj3;
                                        if (!((SemanticsNodeCopy) obj4).children.contains(semanticsNode.id)) {
                                            androidContentCaptureManager.updateBuffersOnAppeared(iIntValue, semanticsNode);
                                            androidContentCaptureManager.boundsUpdateChannel.mo842trySendJP2dKIU(Unit.INSTANCE);
                                        }
                                        break;
                                    case 2:
                                        GapComposer gapComposer2 = (GapComposer) obj;
                                        int iIntValue2 = ((Number) obj2).intValue();
                                        if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                                            Boolean bool = (Boolean) ((LayoutNodeSubcompositionsState.NodeState) obj4).activeState.getValue();
                                            boolean zBooleanValue = bool.booleanValue();
                                            Function2 function2 = (Function2) obj3;
                                            gapComposer2.startReusableGroup(bool);
                                            boolean zChanged = gapComposer2.changed(zBooleanValue);
                                            if (zBooleanValue) {
                                                function2.invoke(gapComposer2, 0);
                                            } else {
                                                if (gapComposer2.groupNodeCount != 0) {
                                                    ComposerKt.composeImmediateRuntimeError("No nodes can be emitted before calling deactivateToEndGroup");
                                                }
                                                if (!gapComposer2.inserting) {
                                                    if (zChanged) {
                                                        SlotReader slotReader = gapComposer2.reader;
                                                        int i2 = slotReader.currentGroup;
                                                        int i3 = slotReader.currentEnd;
                                                        ComposerChangeListWriter composerChangeListWriter = gapComposer2.changeListWriter;
                                                        composerChangeListWriter.getClass();
                                                        composerChangeListWriter.realizeOperationLocation(false);
                                                        composerChangeListWriter.changeList.operations.pushOp(Operation.DeactivateCurrentGroup.INSTANCE);
                                                        Stack.access$removeRange(gapComposer2.invalidations, i2, i3);
                                                        gapComposer2.reader.skipToGroupEnd();
                                                    } else {
                                                        gapComposer2.skipReaderToGroupEnd();
                                                    }
                                                }
                                            }
                                            if (gapComposer2.reusing && gapComposer2.reader.parent == gapComposer2.reusingGroup) {
                                                gapComposer2.reusingGroup = -1;
                                                gapComposer2.reusing = false;
                                            }
                                            gapComposer2.end(false);
                                        } else {
                                            gapComposer2.skipToGroupEnd();
                                        }
                                        break;
                                    case 3:
                                        ((Number) obj2).intValue();
                                        RulerKt.SubcomposeLayout((Modifier) obj4, (Function2) obj3, (GapComposer) obj, Stack.updateChangedFlags(1));
                                        break;
                                    case 4:
                                        Canvas canvas = (Canvas) obj;
                                        GraphicsLayer graphicsLayer = (GraphicsLayer) obj2;
                                        NodeCoordinator nodeCoordinator = (NodeCoordinator) obj4;
                                        LayoutNode layoutNode = nodeCoordinator.layoutNode;
                                        if (layoutNode.isPlaced()) {
                                            nodeCoordinator.drawBlockCanvas = canvas;
                                            nodeCoordinator.drawBlockParentLayer = graphicsLayer;
                                            OwnerSnapshotObserver snapshotObserver = ((AndroidComposeView) LayoutNodeKt.requireOwner(layoutNode)).getSnapshotObserver();
                                            ReusableGraphicsLayerScope reusableGraphicsLayerScope = NodeCoordinator.graphicsLayerScope;
                                            snapshotObserver.observer.observeReads(nodeCoordinator, OwnerSnapshotObserver$onCommitAffectingLayout$1.INSTANCE$3, (NodeCoordinator$invalidateParentLayer$1) obj3);
                                            nodeCoordinator.lastLayerDrawingWasSkipped = false;
                                        } else {
                                            nodeCoordinator.lastLayerDrawingWasSkipped = true;
                                        }
                                        break;
                                    case 5:
                                        GapComposer gapComposer3 = (GapComposer) obj;
                                        if ((((Number) obj2).intValue() & 3) == 2 && gapComposer3.getSkipping()) {
                                            gapComposer3.skipToGroupEnd();
                                        } else {
                                            ((DialogNavigator.Destination) obj3).content.invoke(obj4, (Object) gapComposer3, (Object) 0);
                                        }
                                        break;
                                    case 6:
                                        ((Number) obj2).intValue();
                                        DialogHostKt.PopulateVisibleList((List) obj4, (Collection) obj3, (GapComposer) obj, Stack.updateChangedFlags(1));
                                        break;
                                    default:
                                        GapComposer gapComposer4 = (GapComposer) obj;
                                        if ((((Number) obj2).intValue() & 3) == 2 && gapComposer4.getSkipping()) {
                                            gapComposer4.skipToGroupEnd();
                                        } else {
                                            NavBackStackEntryProviderKt.access$SaveableStateProvider((SaveableStateHolder) obj4, (ComposableLambdaImpl) obj3, gapComposer4, 0);
                                        }
                                        break;
                                }
                                return Unit.INSTANCE;
                            }

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            public /* synthetic */ AnonymousClass1(int i, Object obj, Object obj2) {
                                super(2);
                                this.$r8$classId = i;
                                this.$currentEntry = obj;
                                this.$this_AnimatedContent = obj2;
                            }

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            public AnonymousClass1(DialogNavigator.Destination destination, NavBackStackEntry navBackStackEntry) {
                                super(2);
                                this.$r8$classId = 5;
                                this.$this_AnimatedContent = destination;
                                this.$currentEntry = navBackStackEntry;
                            }
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(4);
                        }

                        @Override // kotlin.jvm.functions.Function4
                        public final Object invoke(Object obj15, Object obj16, Object obj17, Object obj18) {
                            Object objPrevious;
                            AnimatedContentScopeImpl animatedContentScopeImpl = (AnimatedContentScopeImpl) obj15;
                            NavBackStackEntry navBackStackEntry10 = (NavBackStackEntry) obj16;
                            GapComposer gapComposer3 = (GapComposer) obj17;
                            ((Number) obj18).intValue();
                            boolean zAreEqual = Intrinsics.areEqual(seekableTransitionState6.currentState$delegate.getValue(), navBackStackEntry9);
                            if (!((Boolean) mutableState5.getValue()).booleanValue() && !zAreEqual) {
                                List list2 = (List) state3.getValue();
                                ListIterator listIterator2 = list2.listIterator(list2.size());
                                do {
                                    if (!listIterator2.hasPrevious()) {
                                        objPrevious = null;
                                        break;
                                    }
                                    objPrevious = listIterator2.previous();
                                } while (!Intrinsics.areEqual(navBackStackEntry10, (NavBackStackEntry) objPrevious));
                                navBackStackEntry10 = (NavBackStackEntry) objPrevious;
                            }
                            if (navBackStackEntry10 != null) {
                                NavBackStackEntryProviderKt.LocalOwnersProvider(navBackStackEntry10, saveableStateHolderImplRememberSaveableStateHolder, Thread_jvmKt.rememberComposableLambda(-1263531443, new AnonymousClass1(0, navBackStackEntry10, animatedContentScopeImpl), gapComposer3), gapComposer3, 384);
                            }
                            return Unit.INSTANCE;
                        }
                    }, gapComposer), gapComposer, ((i13 >> 3) & 112) | 221184 | (i13 & 7168));
                    gapComposer2 = gapComposer;
                    Object objMo773getCurrentState2 = transition2.transitionState.mo773getCurrentState();
                    Object value2 = transition2.targetState$delegate.getValue();
                    zChanged3 = gapComposer2.changed(transition2) | gapComposer2.changedInstance(navHostController) | gapComposer2.changed(composeNavigator5) | gapComposer2.changedInstance(map2);
                    objRememberedValue10 = gapComposer2.rememberedValue();
                    if (!zChanged3) {
                        NavHostKt$NavHost$33$1 navHostKt$NavHost$33$2 = new NavHostKt$NavHost$33$1(transition2, navHostController, map2, state3, composeNavigator5, null, 0);
                        gapComposer2.updateRememberedValue(navHostKt$NavHost$33$2);
                        objRememberedValue10 = navHostKt$NavHost$33$2;
                    } else {
                        NavHostKt$NavHost$33$1 navHostKt$NavHost$33$3 = new NavHostKt$NavHost$33$1(transition2, navHostController, map2, state3, composeNavigator5, null, 0);
                        gapComposer2.updateRememberedValue(navHostKt$NavHost$33$3);
                        objRememberedValue10 = navHostKt$NavHost$33$3;
                    }
                    Stack.LaunchedEffect(objMo773getCurrentState2, value2, (Function2) objRememberedValue10, gapComposer2);
                } else {
                    gapComposer2 = gapComposer;
                    composeNavigator3 = composeNavigator;
                    navigatorProvider = navigatorProvider3;
                }
                gapComposer2.end(false);
                navigator2 = navigatorProvider.getNavigator("dialog");
                if (navigator2 instanceof DialogNavigator) {
                    dialogNavigator2 = (DialogNavigator) navigator2;
                } else {
                    dialogNavigator = composeNavigator3;
                }
                if (dialogNavigator == 0) {
                    recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
                    if (recomposeScopeImplEndRestartGroup != null) {
                        dialogNavigator = dialogNavigator2;
                        return;
                    }
                    dialogNavigator = dialogNavigator2;
                    final int i33 = 2;
                    recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.navigation.compose.NavHostKt.NavHost.34
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj15, Object obj16) {
                            switch (i33) {
                                case 0:
                                    ((Number) obj16).intValue();
                                    NavHostKt.NavHost(navHostController, navGraph, modifier, alignment, function1, function2, function3, function4, (GapComposer) obj15, Stack.updateChangedFlags(i | 1));
                                    break;
                                case 1:
                                    ((Number) obj16).intValue();
                                    NavHostKt.NavHost(navHostController, navGraph, modifier, alignment, function1, function2, function3, function4, (GapComposer) obj15, Stack.updateChangedFlags(i | 1));
                                    break;
                                default:
                                    ((Number) obj16).intValue();
                                    NavHostKt.NavHost(navHostController, navGraph, modifier, alignment, function1, function2, function3, function4, (GapComposer) obj15, Stack.updateChangedFlags(i | 1));
                                    break;
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    return;
                }
                dialogNavigator = dialogNavigator2;
                DialogHostKt.DialogHost(dialogNavigator, gapComposer2, 0);
            } else {
                throw new IllegalStateException("NavHost requires a ViewModelStoreOwner to be provided via LocalViewModelStoreOwner");
            }
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup3 = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup3 != null) {
            final int i34 = 0;
            recomposeScopeImplEndRestartGroup3.block = new Function2() { // from class: androidx.navigation.compose.NavHostKt.NavHost.34
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj15, Object obj16) {
                    switch (i34) {
                        case 0:
                            ((Number) obj16).intValue();
                            NavHostKt.NavHost(navHostController, navGraph, modifier, alignment, function1, function2, function3, function4, (GapComposer) obj15, Stack.updateChangedFlags(i | 1));
                            break;
                        case 1:
                            ((Number) obj16).intValue();
                            NavHostKt.NavHost(navHostController, navGraph, modifier, alignment, function1, function2, function3, function4, (GapComposer) obj15, Stack.updateChangedFlags(i | 1));
                            break;
                        default:
                            ((Number) obj16).intValue();
                            NavHostKt.NavHost(navHostController, navGraph, modifier, alignment, function1, function2, function3, function4, (GapComposer) obj15, Stack.updateChangedFlags(i | 1));
                            break;
                    }
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
