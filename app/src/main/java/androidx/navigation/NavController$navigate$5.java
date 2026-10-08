package androidx.navigation;

import android.os.Bundle;
import androidx.compose.animation.AnimatedContentTransitionScopeImpl;
import androidx.compose.animation.EnterTransitionImpl;
import androidx.compose.animation.ExitTransitionImpl;
import androidx.compose.runtime.MutableState;
import androidx.navigation.compose.ComposeNavigator;
import androidx.navigation.compose.NavHostKt;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class NavController$navigate$5 extends Lambda implements Function1 {
    public final /* synthetic */ Object $finalArgs;
    public final /* synthetic */ Object $navigated;
    public final /* synthetic */ Object $node;
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NavController$navigate$5(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        super(1);
        this.$r8$classId = i;
        this.$navigated = obj;
        this.this$0 = obj2;
        this.$node = obj3;
        this.$finalArgs = obj4;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i = this.$r8$classId;
        Object obj2 = this.this$0;
        Object obj3 = this.$node;
        Object obj4 = this.$finalArgs;
        Object obj5 = this.$navigated;
        switch (i) {
            case 0:
                ((Ref$BooleanRef) obj5).element = true;
                ((NavHostController) obj2).addEntryToBackStack((NavDestination) obj3, (Bundle) obj4, (NavBackStackEntry) obj, EmptyList.INSTANCE);
                return Unit.INSTANCE;
            case 1:
                AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl = (AnimatedContentTransitionScopeImpl) obj;
                NavController$activity$1 navController$activity$1 = NavController$activity$1.INSTANCE$5;
                ComposeNavigator.Destination destination = (ComposeNavigator.Destination) ((NavBackStackEntry) animatedContentTransitionScopeImpl.getTargetState()).destination;
                if (((Boolean) ((ComposeNavigator) obj5).isPop.getValue()).booleanValue() || NavHostKt.NavHost$lambda$11((MutableState) obj4)) {
                    int i2 = NavDestination.$r8$clinit;
                    for (NavDestination navDestination : SequencesKt.generateSequence(destination, navController$activity$1)) {
                    }
                    return (EnterTransitionImpl) ((Function1) obj2).invoke(animatedContentTransitionScopeImpl);
                }
                int i3 = NavDestination.$r8$clinit;
                for (NavDestination navDestination2 : SequencesKt.generateSequence(destination, navController$activity$1)) {
                }
                return (EnterTransitionImpl) ((Function1) obj3).invoke(animatedContentTransitionScopeImpl);
            default:
                AnimatedContentTransitionScopeImpl animatedContentTransitionScopeImpl2 = (AnimatedContentTransitionScopeImpl) obj;
                NavController$activity$1 navController$activity$2 = NavController$activity$1.INSTANCE$5;
                ComposeNavigator.Destination destination2 = (ComposeNavigator.Destination) ((NavBackStackEntry) animatedContentTransitionScopeImpl2.getInitialState()).destination;
                if (((Boolean) ((ComposeNavigator) obj5).isPop.getValue()).booleanValue() || NavHostKt.NavHost$lambda$11((MutableState) obj4)) {
                    int i4 = NavDestination.$r8$clinit;
                    for (NavDestination navDestination3 : SequencesKt.generateSequence(destination2, navController$activity$2)) {
                    }
                    return (ExitTransitionImpl) ((Function1) obj2).invoke(animatedContentTransitionScopeImpl2);
                }
                int i5 = NavDestination.$r8$clinit;
                for (NavDestination navDestination4 : SequencesKt.generateSequence(destination2, navController$activity$2)) {
                }
                return (ExitTransitionImpl) ((Function1) obj3).invoke(animatedContentTransitionScopeImpl2);
        }
    }
}
