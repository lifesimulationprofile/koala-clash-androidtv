package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeElement;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.unit.DpSize;
import com.github.kr328.clash.compose.connections.ConnectionsScreenKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AndroidCursorHandle_androidKt$$ExternalSyntheticLambda1 implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ long f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ AndroidCursorHandle_androidKt$$ExternalSyntheticLambda1(int i, int i2, long j, String str) {
        this.$r8$classId = i2;
        this.f$1 = str;
        this.f$0 = j;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                Modifier modifier = (Modifier) this.f$1;
                GapComposer gapComposer = (GapComposer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    long j = this.f$0;
                    if (j != 9205357640488583168L) {
                        gapComposer.startReplaceGroup(-1244013944);
                        Modifier modifierThen = modifier.then(new SizeElement(DpSize.m711getWidthD9Ej5fM(j), (2 & 2) != 0 ? Float.NaN : DpSize.m710getHeightD9Ej5fM(j), (2 & 4) != 0 ? Float.NaN : 0.0f, (2 & 8) != 0 ? Float.NaN : 0.0f, false));
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopCenter, false);
                        long j2 = gapComposer.compositeKeyHashCode;
                        int i = (int) (j2 ^ (j2 >>> 32));
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
                        AndroidCursorHandle_androidKt.DefaultCursorHandle(null, gapComposer, 0, 1);
                        gapComposer.end(true);
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(-1243644858);
                        AndroidCursorHandle_androidKt.DefaultCursorHandle(modifier, gapComposer, 0, 0);
                        gapComposer.end(false);
                    }
                } else {
                    gapComposer.skipToGroupEnd();
                }
                break;
            case 1:
                ((Integer) obj2).getClass();
                ConnectionsScreenKt.m804NetworkBadgeRPmYEkk((String) this.f$1, this.f$0, (GapComposer) obj, Stack.updateChangedFlags(1));
                break;
            case 2:
                ((Integer) obj2).getClass();
                ConnectionsScreenKt.m807StatusBadgeRPmYEkk((String) this.f$1, this.f$0, (GapComposer) obj, Stack.updateChangedFlags(1));
                break;
            default:
                ((Integer) obj2).getClass();
                ConnectionsScreenKt.m805SectionHeaderRPmYEkk((String) this.f$1, this.f$0, (GapComposer) obj, Stack.updateChangedFlags(1));
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ AndroidCursorHandle_androidKt$$ExternalSyntheticLambda1(long j, Modifier modifier) {
        this.$r8$classId = 0;
        this.f$0 = j;
        this.f$1 = modifier;
    }
}
