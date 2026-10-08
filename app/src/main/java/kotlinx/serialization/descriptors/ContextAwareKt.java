package kotlinx.serialization.descriptors;

import androidx.compose.foundation.text.contextmenu.internal.AndroidTextContextMenuToolbarProvider_androidKt;
import androidx.compose.foundation.text.contextmenu.provider.BasicTextContextMenuProvider;
import androidx.compose.material3.SnackbarHostKt$$ExternalSyntheticLambda0;
import androidx.compose.material3.internal.TextFieldImplKt$$ExternalSyntheticLambda10;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.Modifier;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KClass;
import kotlinx.serialization.internal.SerialDescriptorForNullable;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ContextAwareKt {
    public static final void ProvideBasicTextContextMenu(Modifier modifier, ProvidableCompositionLocal providableCompositionLocal, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        int i2;
        gapComposer.startRestartGroup(-714464401);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(providableCompositionLocal) ? 32 : 16;
        }
        int i3 = i & 384;
        ComposableLambdaImpl composableLambdaImpl2 = AndroidTextContextMenuToolbarProvider_androidKt.lambda$636288403;
        if (i3 == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl) ? 2048 : 1024;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 1171) != 1170)) {
            Object objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == Composer$Companion.Empty) {
                Object parcelableSnapshotMutableState = new ParcelableSnapshotMutableState(null, NeverEqualPolicy.INSTANCE);
                gapComposer.updateRememberedValue(parcelableSnapshotMutableState);
                objRememberedValue = parcelableSnapshotMutableState;
            }
            BasicTextContextMenuProvider basicTextContextMenuProvider = basicTextContextMenuProvider(composableLambdaImpl2, gapComposer, (i2 >> 6) & 14);
            Stack.CompositionLocalProvider(providableCompositionLocal.defaultProvidedValue$runtime(basicTextContextMenuProvider), Thread_jvmKt.rememberComposableLambda(274270255, new TextFieldImplKt$$ExternalSyntheticLambda10(modifier, (MutableState) objRememberedValue, composableLambdaImpl, basicTextContextMenuProvider), gapComposer), gapComposer, 56);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new SnackbarHostKt$$ExternalSyntheticLambda0(modifier, providableCompositionLocal, composableLambdaImpl, i);
        }
    }

    public static final BasicTextContextMenuProvider basicTextContextMenuProvider(ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        boolean z = (((i & 14) ^ 6) > 4 && gapComposer.changed(composableLambdaImpl)) || (i & 6) == 4;
        Object objRememberedValue = gapComposer.rememberedValue();
        Object obj = Composer$Companion.Empty;
        if (z || objRememberedValue == obj) {
            objRememberedValue = new BasicTextContextMenuProvider(composableLambdaImpl);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        BasicTextContextMenuProvider basicTextContextMenuProvider = (BasicTextContextMenuProvider) objRememberedValue;
        boolean zChanged = gapComposer.changed(basicTextContextMenuProvider);
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue2 == obj) {
            objRememberedValue2 = new Recomposer$$ExternalSyntheticLambda0(20, basicTextContextMenuProvider);
            gapComposer.updateRememberedValue(objRememberedValue2);
        }
        Stack.DisposableEffect(basicTextContextMenuProvider, (Function1) objRememberedValue2, gapComposer);
        return basicTextContextMenuProvider;
    }

    public static final KClass getCapturedKClass(SerialDescriptor serialDescriptor) {
        if (!(serialDescriptor instanceof ContextDescriptor) && (serialDescriptor instanceof SerialDescriptorForNullable)) {
            return getCapturedKClass(((SerialDescriptorForNullable) serialDescriptor).original);
        }
        return null;
    }
}
