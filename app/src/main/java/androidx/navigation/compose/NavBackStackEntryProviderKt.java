package androidx.navigation.compose;

import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.window.AndroidDialog_androidKt$DialogLayout$2;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.navigation.NavBackStackEntry;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class NavBackStackEntryProviderKt {
    public static final void LocalOwnersProvider(NavBackStackEntry navBackStackEntry, SaveableStateHolder saveableStateHolder, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        gapComposer.startRestartGroup(-1579360880);
        if ((((gapComposer.changedInstance(navBackStackEntry) ? 4 : 2) | i | (gapComposer.changedInstance(saveableStateHolder) ? 32 : 16)) & 147) == 146 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            Stack.CompositionLocalProvider(new ProvidedValue[]{LocalViewModelStoreOwner.LocalViewModelStoreOwner.defaultProvidedValue$runtime(navBackStackEntry), LocalLifecycleOwnerKt.LocalLifecycleOwner.defaultProvidedValue$runtime(navBackStackEntry), AndroidCompositionLocals_androidKt.getLocalSavedStateRegistryOwner().defaultProvidedValue$runtime(navBackStackEntry)}, Thread_jvmKt.rememberComposableLambda(-52928304, new NavHostKt.AnonymousClass32.AnonymousClass1(7, saveableStateHolder, composableLambdaImpl), gapComposer), gapComposer, 56);
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new NavHostKt$NavHost$29$1.AnonymousClass1(navBackStackEntry, saveableStateHolder, composableLambdaImpl, i);
        }
    }

    public static final void access$SaveableStateProvider(SaveableStateHolder saveableStateHolder, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        int i2;
        gapComposer.startRestartGroup(1211832233);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changedInstance(saveableStateHolder) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            gapComposer.startReplaceableGroup(1729797275);
            ViewModelStoreOwner current = LocalViewModelStoreOwner.getCurrent(gapComposer);
            if (current == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            ViewModel viewModel = ViewModelKt.viewModel(Reflection.getOrCreateKotlinClass(BackStackEntryIdViewModel.class), current, null, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, gapComposer);
            gapComposer.end(false);
            BackStackEntryIdViewModel backStackEntryIdViewModel = (BackStackEntryIdViewModel) viewModel;
            backStackEntryIdViewModel.saveableStateHolderRef = new WeakReference(saveableStateHolder);
            saveableStateHolder.SaveableStateProvider(backStackEntryIdViewModel.id, composableLambdaImpl, gapComposer, ((i2 << 6) & 896) | (i2 & 112));
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AndroidDialog_androidKt$DialogLayout$2(i, 1, saveableStateHolder, composableLambdaImpl);
        }
    }
}
