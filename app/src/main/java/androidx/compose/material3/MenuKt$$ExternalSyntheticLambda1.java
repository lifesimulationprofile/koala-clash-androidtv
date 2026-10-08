package androidx.compose.material3;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.ScrollingLogic;
import androidx.compose.foundation.gestures.ScrollingLogic$nestedScrollScope$1;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import com.github.kr328.clash.compose.ApkBrokenScreenKt;
import com.github.kr328.clash.compose.AppCrashedScreenKt;
import com.github.kr328.clash.compose.FilesScreenKt;
import com.github.kr328.clash.compose.LogcatScreenKt;
import com.github.kr328.clash.compose.home.HomeScreenKt;
import com.github.kr328.clash.core.model.LogMessage;
import com.github.kr328.clash.design.model.File;
import com.google.android.gms.internal.mlkit_vision_common.zzit;
import com.google.android.gms.internal.mlkit_vision_common.zzjb;
import com.google.android.gms.internal.mlkit_vision_common.zzjo;
import dev.chrisbanes.haze.HazeState;
import java.text.SimpleDateFormat;
import kotlin.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$FloatRef;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MenuKt$$ExternalSyntheticLambda1 implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ MenuKt$$ExternalSyntheticLambda1(Object obj, Object obj2, Modifier modifier, int i, int i2) {
        this.$r8$classId = i2;
        this.f$1 = obj;
        this.f$2 = obj2;
        this.f$0 = modifier;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                Modifier modifier = (Modifier) this.f$0;
                ScrollState scrollState = (ScrollState) this.f$1;
                ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) this.f$2;
                GapComposer gapComposer = (GapComposer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    Modifier modifierVerticalScroll$default = ImageKt.verticalScroll$default(OffsetKt.width(OffsetKt.m130paddingVpY3zN4$default(modifier, 0.0f, MenuKt.DropdownMenuVerticalPadding, 1)), scrollState);
                    ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, gapComposer, 0);
                    long j = gapComposer.compositeKeyHashCode;
                    int i = (int) (j ^ (j >>> 32));
                    PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifierVerticalScroll$default);
                    ComposeUiNode.Companion.getClass();
                    LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(layoutNode$Companion$Constructor$1);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m295setimpl(gapComposer, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m295setimpl(gapComposer, Integer.valueOf(i), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m294reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                    Stack.m295setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                    composableLambdaImpl.invoke((Object) ColumnScopeInstance.INSTANCE, (Object) gapComposer, (Object) 6);
                    gapComposer.end(true);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                break;
            case 1:
                Ref$FloatRef ref$FloatRef = (Ref$FloatRef) this.f$0;
                ScrollingLogic scrollingLogic = (ScrollingLogic) this.f$1;
                ScrollingLogic$nestedScrollScope$1 scrollingLogic$nestedScrollScope$1 = (ScrollingLogic$nestedScrollScope$1) this.f$2;
                float fFloatValue = ((Float) obj).floatValue();
                ((Float) obj2).getClass();
                long jM108toOffsettuRUvjQ = scrollingLogic.m108toOffsettuRUvjQ(scrollingLogic.reverseIfNeeded(fFloatValue - ref$FloatRef.element));
                ScrollingLogic scrollingLogic2 = scrollingLogic$nestedScrollScope$1.this$0;
                ref$FloatRef.element += scrollingLogic.reverseIfNeeded(scrollingLogic.m107toFloatk4lQ0M(scrollingLogic2.m105performScroll3eAAhYA(scrollingLogic2.outerStateScope, jM108toOffsettuRUvjQ, 1)));
                break;
            case 2:
                ((Integer) obj2).getClass();
                BasicTextKt.CoreTextFieldRootBox((Modifier) this.f$0, (TextFieldSelectionManager) this.f$1, (ComposableLambdaImpl) this.f$2, (GapComposer) obj, Stack.updateChangedFlags(385));
                break;
            case 3:
                Modifier modifier2 = (Modifier) this.f$0;
                MutableState mutableState = (MutableState) this.f$1;
                ComposableLambdaImpl composableLambdaImpl2 = (ComposableLambdaImpl) this.f$2;
                GapComposer gapComposer2 = (GapComposer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    Object objRememberedValue = gapComposer2.rememberedValue();
                    if (objRememberedValue == Composer$Companion.Empty) {
                        objRememberedValue = new TooltipKt$$ExternalSyntheticLambda7(mutableState, 3);
                        gapComposer2.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierOnGloballyPositioned = RulerKt.onGloballyPositioned(modifier2, (Function1) objRememberedValue);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, true);
                    long j2 = gapComposer2.compositeKeyHashCode;
                    int i2 = (int) (j2 ^ (j2 >>> 32));
                    PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer2.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer2, modifierOnGloballyPositioned);
                    ComposeUiNode.Companion.getClass();
                    LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$2 = ComposeUiNode.Companion.Constructor;
                    gapComposer2.startReusableNode();
                    if (gapComposer2.inserting) {
                        gapComposer2.createNode(layoutNode$Companion$Constructor$2);
                    } else {
                        gapComposer2.useNode();
                    }
                    Stack.m295setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope2, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m295setimpl(gapComposer2, Integer.valueOf(i2), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m294reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                    Stack.m295setimpl(gapComposer2, modifierMaterializeModifier2, ComposeUiNode.Companion.SetModifier);
                    composableLambdaImpl2.invoke((Object) gapComposer2, (Object) 0);
                    gapComposer2.end(true);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                break;
            case 4:
                ((Integer) obj2).getClass();
                ApkBrokenScreenKt.ApkBrokenScreen((Function1) this.f$1, (Function0) this.f$2, (Modifier) this.f$0, (GapComposer) obj, Stack.updateChangedFlags(1));
                break;
            case 5:
                ((Integer) obj2).getClass();
                AppCrashedScreenKt.AppCrashedScreen((String) this.f$1, (Function0) this.f$2, (Modifier) this.f$0, (GapComposer) obj, Stack.updateChangedFlags(1));
                break;
            case 6:
                ((Integer) obj2).getClass();
                FilesScreenKt.FileNameDialog((String) this.f$0, (Function1) this.f$1, (Function0) this.f$2, (GapComposer) obj, Stack.updateChangedFlags(385));
                break;
            case 7:
                ((Integer) obj2).getClass();
                FilesScreenKt.FileRow((File) this.f$0, (Function0) this.f$1, (Function0) this.f$2, (GapComposer) obj, Stack.updateChangedFlags(1));
                break;
            case 8:
                ((Integer) obj2).getClass();
                LogcatScreenKt.LogMessageRow((LogMessage) this.f$0, (SimpleDateFormat) this.f$1, (Function0) this.f$2, (GapComposer) obj, Stack.updateChangedFlags(1));
                break;
            case 9:
                ((Integer) obj2).getClass();
                HomeScreenKt.TrafficColumn((String) this.f$1, (ComposableLambdaImpl) this.f$2, (Modifier) this.f$0, (GapComposer) obj, Stack.updateChangedFlags(49));
                break;
            case 10:
                ((Integer) obj2).getClass();
                zzit.DeleteProfileDialog((String) this.f$0, (Function0) this.f$1, (Function0) this.f$2, (GapComposer) obj, Stack.updateChangedFlags(385));
                break;
            case 11:
                ((Integer) obj2).getClass();
                zzit.AddProfileFab((Function0) this.f$1, (HazeState) this.f$2, (Modifier) this.f$0, (GapComposer) obj, Stack.updateChangedFlags(1));
                break;
            case 12:
                ((Integer) obj2).getClass();
                zzjb.ActionRow((ImageVector) this.f$0, (String) this.f$1, (Function0) this.f$2, (GapComposer) obj, Stack.updateChangedFlags(1));
                break;
            default:
                ((Integer) obj2).getClass();
                zzjo.PreferenceTexts((String) this.f$1, (String) this.f$2, (Modifier) this.f$0, (GapComposer) obj, Stack.updateChangedFlags(1));
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ MenuKt$$ExternalSyntheticLambda1(Object obj, Object obj2, Object obj3, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
    }

    public /* synthetic */ MenuKt$$ExternalSyntheticLambda1(Object obj, Object obj2, Function function, int i, int i2) {
        this.$r8$classId = i2;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = function;
    }
}
