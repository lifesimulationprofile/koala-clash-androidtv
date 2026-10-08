package androidx.compose.material3;

import androidx.compose.foundation.contextmenu.ContextMenuColors;
import androidx.compose.foundation.contextmenu.ContextMenuUiKt;
import androidx.compose.foundation.lazy.LazyListItemProviderImpl;
import androidx.compose.foundation.lazy.layout.LazyLayoutKt;
import androidx.compose.foundation.lazy.layout.LazySaveableStateHolder;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.foundation.text.contextmenu.internal.DefaultTextContextMenuDropdownProvider_androidKt;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import androidx.compose.foundation.text.selection.OffsetProvider;
import androidx.compose.foundation.text.selection.SimpleLayoutKt;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.saveable.SaveableStateHolderImpl;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LifecycleEffectKt;
import androidx.lifecycle.compose.LifecycleStartStopEffectScope;
import com.github.kr328.clash.UpdateInfo;
import com.github.kr328.clash.compose.UpdateDialogKt;
import kotlin.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.serialization.descriptors.ContextAwareKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SnackbarHostKt$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ int f$3;

    public /* synthetic */ SnackbarHostKt$$ExternalSyntheticLambda0(LazyListItemProviderImpl lazyListItemProviderImpl, Object obj, int i, Object obj2, int i2) {
        this.$r8$classId = 3;
        this.f$0 = lazyListItemProviderImpl;
        this.f$1 = obj;
        this.f$3 = i;
        this.f$2 = obj2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                ((Integer) obj2).getClass();
                ScrimKt.SnackbarHost((SnackbarHostState) this.f$0, (Modifier) this.f$1, (ComposableLambdaImpl) this.f$2, (GapComposer) obj, Stack.updateChangedFlags(this.f$3 | 1));
                break;
            case 1:
                ((Integer) obj2).getClass();
                ContextMenuUiKt.ContextMenuColumnBuilder((Modifier) this.f$1, (ContextMenuColors) this.f$0, (Function1) this.f$2, (GapComposer) obj, Stack.updateChangedFlags(1), this.f$3);
                break;
            case 2:
                ((Integer) obj2).getClass();
                ContextMenuUiKt.ContextMenuColumn((ContextMenuColors) this.f$0, (Modifier) this.f$1, (ComposableLambdaImpl) this.f$2, (GapComposer) obj, Stack.updateChangedFlags(this.f$3 | 1));
                break;
            case 3:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                LazyLayoutKt.m153SkippableItemJVlU9Rs((LazyListItemProviderImpl) this.f$0, this.f$1, this.f$3, this.f$2, (GapComposer) obj, iUpdateChangedFlags);
                break;
            case 4:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags2 = Stack.updateChangedFlags(this.f$3 | 1);
                ((LazySaveableStateHolder) this.f$0).SaveableStateProvider(this.f$1, (ComposableLambdaImpl) this.f$2, (GapComposer) obj, iUpdateChangedFlags2);
                break;
            case 5:
                ((Integer) obj2).intValue();
                DefaultTextContextMenuDropdownProvider_androidKt.OpenContextMenu((TextContextMenuSession) this.f$0, (TextContextMenuDataProvider) this.f$1, (Function0) this.f$2, (GapComposer) obj, Stack.updateChangedFlags(this.f$3 | 1));
                break;
            case 6:
                ((Integer) obj2).getClass();
                ContextAwareKt.ProvideBasicTextContextMenu((Modifier) this.f$1, (ProvidableCompositionLocal) this.f$0, (ComposableLambdaImpl) this.f$2, (GapComposer) obj, Stack.updateChangedFlags(this.f$3 | 1));
                break;
            case 7:
                ((Integer) obj2).getClass();
                SimpleLayoutKt.HandlePopup((OffsetProvider) this.f$0, (Alignment) this.f$1, (ComposableLambdaImpl) this.f$2, (GapComposer) obj, Stack.updateChangedFlags(this.f$3 | 1));
                break;
            case 8:
                ((Integer) obj2).getClass();
                ScrimKt.FadeInFadeOutWithScale((SnackbarHostState.SnackbarDataImpl) this.f$0, (Modifier) this.f$1, (ComposableLambdaImpl) this.f$2, (GapComposer) obj, Stack.updateChangedFlags(this.f$3 | 1));
                break;
            case 9:
                ((Integer) obj2).intValue();
                int iUpdateChangedFlags3 = Stack.updateChangedFlags(this.f$3) | 1;
                ((ComposableLambdaImpl) this.f$2).invoke(this.f$0, this.f$1, (GapComposer) obj, iUpdateChangedFlags3);
                break;
            case 10:
                ((Integer) obj2).getClass();
                int iUpdateChangedFlags4 = Stack.updateChangedFlags(this.f$3 | 1);
                ((SaveableStateHolderImpl) this.f$0).SaveableStateProvider(this.f$1, (ComposableLambdaImpl) this.f$2, (GapComposer) obj, iUpdateChangedFlags4);
                break;
            case 11:
                ((Integer) obj2).intValue();
                LifecycleEffectKt.LifecycleStartEffectImpl((LifecycleOwner) this.f$0, (LifecycleStartStopEffectScope) this.f$1, (Function1) this.f$2, (GapComposer) obj, Stack.updateChangedFlags(this.f$3 | 1));
                break;
            default:
                ((Integer) obj2).getClass();
                UpdateDialogKt.UpdateDialog((UpdateInfo) this.f$0, (Function0) this.f$1, (Function0) this.f$2, (GapComposer) obj, Stack.updateChangedFlags(this.f$3 | 1));
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ SnackbarHostKt$$ExternalSyntheticLambda0(ComposableLambdaImpl composableLambdaImpl, Object obj, Object obj2, int i) {
        this.$r8$classId = 9;
        this.f$2 = composableLambdaImpl;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$3 = i;
    }

    public /* synthetic */ SnackbarHostKt$$ExternalSyntheticLambda0(Modifier modifier, ContextMenuColors contextMenuColors, Function1 function1, int i, int i2) {
        this.$r8$classId = 1;
        this.f$1 = modifier;
        this.f$0 = contextMenuColors;
        this.f$2 = function1;
        this.f$3 = i2;
    }

    public /* synthetic */ SnackbarHostKt$$ExternalSyntheticLambda0(Modifier modifier, ProvidableCompositionLocal providableCompositionLocal, ComposableLambdaImpl composableLambdaImpl, int i) {
        this.$r8$classId = 6;
        this.f$1 = modifier;
        this.f$0 = providableCompositionLocal;
        this.f$2 = composableLambdaImpl;
        this.f$3 = i;
    }

    public /* synthetic */ SnackbarHostKt$$ExternalSyntheticLambda0(Object obj, Object obj2, Function function, int i, int i2) {
        this.$r8$classId = i2;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = function;
        this.f$3 = i;
    }
}
