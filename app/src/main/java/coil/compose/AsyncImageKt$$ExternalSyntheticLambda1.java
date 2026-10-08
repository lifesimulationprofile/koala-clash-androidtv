package coil.compose;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.FlowRowOverflow;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.text.contextmenu.provider.BasicTextContextMenuProvider;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.foundation.text.selection.SimpleLayoutKt;
import androidx.compose.material3.AlertDialogKt;
import androidx.compose.material3.TooltipStateImpl;
import androidx.compose.material3.internal.LayoutUtilKt;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.window.DialogProperties;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LifecycleEffectKt;
import com.github.kr328.clash.compose.proxy.ProxyScreenKt;
import com.google.android.gms.internal.mlkit_vision_common.zzjb;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AsyncImageKt$$ExternalSyntheticLambda1 implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ int f$8;

    public /* synthetic */ AsyncImageKt$$ExternalSyntheticLambda1(TooltipStateImpl tooltipStateImpl, MutableState mutableState, Modifier modifier, ComposableLambdaImpl composableLambdaImpl, int i) {
        this.$r8$classId = 4;
        this.f$1 = tooltipStateImpl;
        this.f$3 = mutableState;
        this.f$0 = modifier;
        this.f$4 = composableLambdaImpl;
        this.f$8 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                ((Integer) obj2).getClass();
                AsyncImageKt.Content((Modifier) this.f$0, (AsyncImagePainter) this.f$1, (Alignment) this.f$3, (ContentScale) this.f$4, (GapComposer) obj, Stack.updateChangedFlags(this.f$8 | 1));
                break;
            case 1:
                ((Integer) obj2).getClass();
                OffsetKt.FlowRow((Modifier) this.f$0, (Arrangement.Horizontal) this.f$1, (Arrangement.Vertical) this.f$3, (ComposableLambdaImpl) this.f$4, (GapComposer) obj, Stack.updateChangedFlags(this.f$8 | 1));
                break;
            case 2:
                ((Integer) obj2).getClass();
                SimpleLayoutKt.SelectionContainer((Modifier) this.f$0, (Selection) this.f$1, (Function1) this.f$3, (ComposableLambdaImpl) this.f$4, (GapComposer) obj, Stack.updateChangedFlags(this.f$8 | 1));
                break;
            case 3:
                ((Integer) obj2).getClass();
                AlertDialogKt.BasicAlertDialog((Function0) this.f$1, (Modifier) this.f$0, (DialogProperties) this.f$3, (ComposableLambdaImpl) this.f$4, (GapComposer) obj, Stack.updateChangedFlags(this.f$8 | 1));
                break;
            case 4:
                ((Integer) obj2).getClass();
                LayoutUtilKt.WrappedAnchor((TooltipStateImpl) this.f$1, (MutableState) this.f$3, (Modifier) this.f$0, (ComposableLambdaImpl) this.f$4, (GapComposer) obj, Stack.updateChangedFlags(this.f$8 | 1));
                break;
            case 5:
                ((Integer) obj2).getClass();
                ((ComposableLambdaImpl) this.f$0).invoke((BasicTextContextMenuProvider.SessionImpl) this.f$1, this.f$3, this.f$4, (GapComposer) obj, Stack.updateChangedFlags(this.f$8) | 1);
                break;
            case 6:
                ((Integer) obj2).getClass();
                LifecycleEffectKt.LifecycleStartEffect((Boolean) this.f$0, this.f$1, (LifecycleOwner) this.f$3, (Function1) this.f$4, (GapComposer) obj, Stack.updateChangedFlags(this.f$8 | 1));
                break;
            case 7:
                ((Integer) obj2).intValue();
                ProxyScreenKt.ProxyGroupsScroll((List) this.f$0, (Map) this.f$1, (String) this.f$3, (Function1) this.f$4, (GapComposer) obj, Stack.updateChangedFlags(this.f$8 | 1));
                break;
            default:
                ((Integer) obj2).intValue();
                zzjb.SearchOverlay((List) this.f$0, (Set) this.f$1, (Function1) this.f$3, (Function0) this.f$4, (GapComposer) obj, Stack.updateChangedFlags(this.f$8 | 1));
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ AsyncImageKt$$ExternalSyntheticLambda1(Modifier modifier, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, ComposableLambdaImpl composableLambdaImpl, int i) {
        this.$r8$classId = 1;
        int i2 = FlowRowOverflow.$r8$clinit;
        this.f$0 = modifier;
        this.f$1 = horizontal;
        this.f$3 = vertical;
        this.f$4 = composableLambdaImpl;
        this.f$8 = i;
    }

    public /* synthetic */ AsyncImageKt$$ExternalSyntheticLambda1(Object obj, Object obj2, Object obj3, Object obj4, int i, int i2) {
        this.$r8$classId = i2;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$3 = obj3;
        this.f$4 = obj4;
        this.f$8 = i;
    }

    public /* synthetic */ AsyncImageKt$$ExternalSyntheticLambda1(Function0 function0, Modifier modifier, DialogProperties dialogProperties, ComposableLambdaImpl composableLambdaImpl, int i) {
        this.$r8$classId = 3;
        this.f$1 = function0;
        this.f$0 = modifier;
        this.f$3 = dialogProperties;
        this.f$4 = composableLambdaImpl;
        this.f$8 = i;
    }
}
