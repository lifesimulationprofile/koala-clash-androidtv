package androidx.compose.foundation.text.contextmenu.internal;

import android.view.View;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.text.contextmenu.ProcessTextApi23Impl$$ExternalSyntheticLambda1;
import androidx.compose.foundation.text.contextmenu.provider.BasicTextContextMenuProvider;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProviderKt;
import androidx.compose.material3.MenuKt$$ExternalSyntheticLambda1;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.window.PopupProperties;
import com.github.kr328.clash.compose.ProvidersScreenKt$$ExternalSyntheticLambda0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.serialization.descriptors.ContextAwareKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AndroidTextContextMenuToolbarProvider_androidKt {
    public static final ComposableLambdaImpl lambda$636288403 = new ComposableLambdaImpl(636288403, new ProcessTextApi23Impl$$ExternalSyntheticLambda1(1), false);

    /* JADX INFO: renamed from: lambda$-1357803046, reason: not valid java name */
    public static final ComposableLambdaImpl f4lambda$1357803046 = new ComposableLambdaImpl(-1357803046, new ProcessTextApi23Impl$$ExternalSyntheticLambda1(2), false);

    public static final void ProvideBothDefaultProviders(Modifier modifier, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        int i2;
        Modifier modifier2;
        ComposableLambdaImpl composableLambdaImpl2;
        gapComposer.startRestartGroup(790527681);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl) ? 32 : 16;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                ParcelableSnapshotMutableState parcelableSnapshotMutableState = new ParcelableSnapshotMutableState(null, NeverEqualPolicy.INSTANCE);
                gapComposer.updateRememberedValue(parcelableSnapshotMutableState);
                objRememberedValue = parcelableSnapshotMutableState;
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new TooltipKt$$ExternalSyntheticLambda0(mutableState, 5);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            Function0 function0 = (Function0) objRememberedValue2;
            PopupProperties popupProperties = DefaultTextContextMenuDropdownProvider_androidKt.DefaultPopupProperties;
            BasicTextContextMenuProvider basicTextContextMenuProvider = ContextAwareKt.basicTextContextMenuProvider(f4lambda$1357803046, gapComposer, 6);
            modifier2 = modifier;
            composableLambdaImpl2 = composableLambdaImpl;
            Stack.CompositionLocalProvider(new ProvidedValue[]{TextContextMenuProviderKt.LocalTextContextMenuToolbarProvider.defaultProvidedValue$runtime(platformTextContextMenuToolbarProvider(function0, gapComposer, 2)), TextContextMenuProviderKt.LocalTextContextMenuDropdownProvider.defaultProvidedValue$runtime(basicTextContextMenuProvider)}, Thread_jvmKt.rememberComposableLambda(1070596993, new ProvidersScreenKt$$ExternalSyntheticLambda0(modifier2, mutableState, composableLambdaImpl2, basicTextContextMenuProvider, function0), gapComposer), gapComposer, 56);
        } else {
            modifier2 = modifier;
            composableLambdaImpl2 = composableLambdaImpl;
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AndroidTextContextMenuToolbarProvider_androidKt$$ExternalSyntheticLambda0(modifier2, composableLambdaImpl2, i, 3);
        }
    }

    public static final void ProvideDefaultPlatformTextContextMenuProviders(Modifier modifier, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        int i2;
        gapComposer.startRestartGroup(155925518);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl) ? 32 : 16;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            boolean z = gapComposer.consume(TextContextMenuProviderKt.LocalTextContextMenuDropdownProvider) != null;
            boolean z2 = gapComposer.consume(TextContextMenuProviderKt.LocalTextContextMenuToolbarProvider) != null;
            if (z && z2) {
                gapComposer.startReplaceGroup(-1977187922);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, true);
                long j = gapComposer.compositeKeyHashCode;
                int i3 = (int) ((j >>> 32) ^ j);
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
                Stack.m295setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                Stack.m295setimpl(gapComposer, Integer.valueOf(i3), ComposeUiNode.Companion.SetCompositeKeyHash);
                Stack.m294reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                Stack.m295setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                composableLambdaImpl.invoke(gapComposer, Integer.valueOf((i2 >> 3) & 14));
                gapComposer.end(true);
                gapComposer.end(false);
            } else if (z) {
                gapComposer.startReplaceGroup(-1976997706);
                ProvidePlatformTextContextMenuToolbar(modifier, composableLambdaImpl, gapComposer, i2 & 126);
                gapComposer.end(false);
            } else if (z2) {
                gapComposer.startReplaceGroup(-1976846922);
                DefaultTextContextMenuDropdownProvider_androidKt.ProvideDefaultTextContextMenuDropdown(modifier, composableLambdaImpl, gapComposer, i2 & 126);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(-1976716505);
                ProvideBothDefaultProviders(modifier, composableLambdaImpl, gapComposer, i2 & 126);
                gapComposer.end(false);
            }
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AndroidTextContextMenuToolbarProvider_androidKt$$ExternalSyntheticLambda0(modifier, composableLambdaImpl, i, 4);
        }
    }

    public static final void ProvidePlatformTextContextMenuToolbar(Modifier modifier, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        int i2;
        gapComposer.startRestartGroup(2064964257);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl) ? 32 : 16;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            ProvidePlatformTextContextMenuToolbar$1(modifier, composableLambdaImpl, gapComposer, ((i2 << 3) & 896) | (i2 & 14) | 48);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AndroidTextContextMenuToolbarProvider_androidKt$$ExternalSyntheticLambda0(modifier, composableLambdaImpl, i, 0);
        }
    }

    public static final void ProvidePlatformTextContextMenuToolbar$1(Modifier modifier, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        int i2;
        gapComposer.startRestartGroup(771959668);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(null) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl) ? 256 : 128;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                ParcelableSnapshotMutableState parcelableSnapshotMutableState = new ParcelableSnapshotMutableState(null, NeverEqualPolicy.INSTANCE);
                gapComposer.updateRememberedValue(parcelableSnapshotMutableState);
                objRememberedValue = parcelableSnapshotMutableState;
            }
            MutableState mutableState = (MutableState) objRememberedValue;
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new TooltipKt$$ExternalSyntheticLambda0(mutableState, 4);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            Stack.CompositionLocalProvider(TextContextMenuProviderKt.LocalTextContextMenuToolbarProvider.defaultProvidedValue$runtime(platformTextContextMenuToolbarProvider((Function0) objRememberedValue2, gapComposer, 0)), Thread_jvmKt.rememberComposableLambda(-291176396, new MenuKt$$ExternalSyntheticLambda1(modifier, mutableState, composableLambdaImpl, 3), gapComposer), gapComposer, 56);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AndroidTextContextMenuToolbarProvider_androidKt$$ExternalSyntheticLambda0(modifier, composableLambdaImpl, i, 1);
        }
    }

    public static final AndroidTextContextMenuToolbarProvider platformTextContextMenuToolbarProvider(Function0 function0, GapComposer gapComposer, int i) {
        View view = (View) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalView);
        boolean zChanged = gapComposer.changed(view);
        Object objRememberedValue = gapComposer.rememberedValue();
        Object obj = Composer$Companion.Empty;
        if (zChanged || objRememberedValue == obj) {
            objRememberedValue = new AndroidTextContextMenuToolbarProvider(view, null, function0);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        AndroidTextContextMenuToolbarProvider androidTextContextMenuToolbarProvider = (AndroidTextContextMenuToolbarProvider) objRememberedValue;
        boolean zChangedInstance = gapComposer.changedInstance(androidTextContextMenuToolbarProvider);
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == obj) {
            objRememberedValue2 = new AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda0(androidTextContextMenuToolbarProvider, 3);
            gapComposer.updateRememberedValue(objRememberedValue2);
        }
        Stack.DisposableEffect(androidTextContextMenuToolbarProvider, (Function1) objRememberedValue2, gapComposer);
        return androidTextContextMenuToolbarProvider;
    }
}
