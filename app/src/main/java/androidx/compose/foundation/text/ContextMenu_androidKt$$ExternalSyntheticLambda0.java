package androidx.compose.foundation.text;

import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.compose.foundation.text.selection.MultiWidgetSelectionDelegate;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$5$1$1$1$1$1$1;
import androidx.compose.foundation.text.selection.SelectionContainerKt$sam$androidx_compose_foundation_text_selection_OffsetProvider$0;
import androidx.compose.foundation.text.selection.SelectionManager;
import androidx.compose.foundation.text.selection.SelectionManager$$ExternalSyntheticLambda0;
import androidx.compose.foundation.text.selection.SelectionManager$handleDragObserver$1;
import androidx.compose.foundation.text.selection.SimpleLayoutKt;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendPointerInputElement;
import androidx.compose.ui.text.TextLayoutResult;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ContextMenu_androidKt$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ SelectionManager f$0;
    public final /* synthetic */ ComposableLambdaImpl f$1;

    public /* synthetic */ ContextMenu_androidKt$$ExternalSyntheticLambda0(SelectionManager selectionManager, ComposableLambdaImpl composableLambdaImpl, int i, int i2) {
        this.$r8$classId = i2;
        this.f$0 = selectionManager;
        this.f$1 = composableLambdaImpl;
    }

    /* JADX WARN: Code duplicated, block: B:50:0x0100  */
    /* JADX WARN: Code duplicated, block: B:67:0x016b  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Selection.AnchorInfo anchorInfo;
        MultiWidgetSelectionDelegate anchorSelectable$foundation;
        float lineHeight;
        Selection.AnchorInfo anchorInfo2;
        MultiWidgetSelectionDelegate anchorSelectable$foundation2;
        boolean z;
        int i = this.$r8$classId;
        SelectionManager selectionManager = this.f$0;
        ComposableLambdaImpl composableLambdaImpl = this.f$1;
        switch (i) {
            case 0:
                ((Integer) obj2).getClass();
                BasicTextKt.ContextMenuArea(selectionManager, composableLambdaImpl, (GapComposer) obj, Stack.updateChangedFlags(49));
                break;
            case 1:
                ((Integer) obj2).getClass();
                BasicTextKt.CommonContextMenuArea(selectionManager, composableLambdaImpl, (GapComposer) obj, Stack.updateChangedFlags(49));
                break;
            default:
                GapComposer gapComposer = (GapComposer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                int i2 = 2;
                int i3 = 0;
                int i4 = 1;
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    composableLambdaImpl.invoke((Object) gapComposer, (Object) 0);
                    if (selectionManager.isInTouchMode() && ((Boolean) selectionManager.hasFocus$delegate.getValue()).booleanValue()) {
                        Selection selection = selectionManager.getSelection();
                        if (selection == null ? true : Intrinsics.areEqual(selection.start, selection.end)) {
                            gapComposer.startReplaceGroup(2013602667);
                            gapComposer.end(false);
                        } else {
                            gapComposer.startReplaceGroup(-1736224054);
                            Selection selection2 = selectionManager.getSelection();
                            if (selection2 == null) {
                                gapComposer.startReplaceGroup(2011629175);
                                gapComposer.end(false);
                                z = false;
                            } else {
                                gapComposer.startReplaceGroup(2011629176);
                                gapComposer.startReplaceGroup(-1736222526);
                                List listListOf = AppCompatHintHelper.listOf(Boolean.TRUE, Boolean.FALSE);
                                int size = listListOf.size();
                                int i5 = 0;
                                while (i5 < size) {
                                    boolean zBooleanValue = ((Boolean) listListOf.get(i5)).booleanValue();
                                    boolean zChanged = gapComposer.changed(zBooleanValue);
                                    Object objRememberedValue = gapComposer.rememberedValue();
                                    Object obj3 = Composer$Companion.Empty;
                                    if (zChanged || objRememberedValue == obj3) {
                                        objRememberedValue = new SelectionManager$handleDragObserver$1(zBooleanValue, selectionManager);
                                        gapComposer.updateRememberedValue(objRememberedValue);
                                    }
                                    TextDragObserver textDragObserver = (TextDragObserver) objRememberedValue;
                                    boolean zChanged2 = gapComposer.changed(zBooleanValue);
                                    Object objRememberedValue2 = gapComposer.rememberedValue();
                                    if (zChanged2 || objRememberedValue2 == obj3) {
                                        objRememberedValue2 = zBooleanValue ? new SelectionManager$$ExternalSyntheticLambda0(selectionManager, i2) : new SelectionManager$$ExternalSyntheticLambda0(selectionManager, i4);
                                        gapComposer.updateRememberedValue(objRememberedValue2);
                                    }
                                    Function0 function0 = (Function0) objRememberedValue2;
                                    int i6 = zBooleanValue ? selection2.start.direction : selection2.end.direction;
                                    if (zBooleanValue) {
                                        Selection selection3 = selectionManager.getSelection();
                                        if (selection3 == null || (anchorSelectable$foundation2 = selectionManager.getAnchorSelectable$foundation((anchorInfo2 = selection3.start))) == null) {
                                            lineHeight = 0.0f;
                                        } else {
                                            int i7 = anchorInfo2.offset;
                                            TextLayoutResult textLayoutResult = (TextLayoutResult) anchorSelectable$foundation2.layoutResultCallback.invoke();
                                            if (textLayoutResult != null) {
                                                lineHeight = BasicTextKt.getLineHeight(textLayoutResult, i7);
                                            } else {
                                                lineHeight = 0.0f;
                                            }
                                        }
                                    } else {
                                        Selection selection4 = selectionManager.getSelection();
                                        if (selection4 == null || (anchorSelectable$foundation = selectionManager.getAnchorSelectable$foundation((anchorInfo = selection4.end))) == null) {
                                            lineHeight = 0.0f;
                                        } else {
                                            int i8 = anchorInfo.offset;
                                            TextLayoutResult textLayoutResult2 = (TextLayoutResult) anchorSelectable$foundation.layoutResultCallback.invoke();
                                            if (textLayoutResult2 != null) {
                                                lineHeight = BasicTextKt.getLineHeight(textLayoutResult2, i8);
                                            } else {
                                                lineHeight = 0.0f;
                                            }
                                        }
                                    }
                                    SelectionContainerKt$sam$androidx_compose_foundation_text_selection_OffsetProvider$0 selectionContainerKt$sam$androidx_compose_foundation_text_selection_OffsetProvider$0 = new SelectionContainerKt$sam$androidx_compose_foundation_text_selection_OffsetProvider$0(function0);
                                    boolean z2 = selection2.handlesCrossed;
                                    boolean zChangedInstance = gapComposer.changedInstance(textDragObserver);
                                    Object objRememberedValue3 = gapComposer.rememberedValue();
                                    if (zChangedInstance || objRememberedValue3 == obj3) {
                                        objRememberedValue3 = new SelectionContainerKt$SelectionContainer$5$1$1$1$1$1$1(textDragObserver, i3);
                                        gapComposer.updateRememberedValue(objRememberedValue3);
                                    }
                                    SimpleLayoutKt.m223SelectionHandlewLIcFTc(selectionContainerKt$sam$androidx_compose_foundation_text_selection_OffsetProvider$0, zBooleanValue, i6, z2, 0L, lineHeight, new SuspendPointerInputElement(textDragObserver, null, (PointerInputEventHandler) objRememberedValue3, 6), gapComposer, 0);
                                    i5++;
                                    i3 = 0;
                                    i4 = 1;
                                    i2 = 2;
                                }
                                boolean z3 = i3;
                                gapComposer.end(z3);
                                gapComposer.end(z3);
                                z = z3;
                            }
                            gapComposer.end(z);
                        }
                    } else {
                        gapComposer.startReplaceGroup(2013602667);
                        gapComposer.end(false);
                    }
                } else {
                    gapComposer.skipToGroupEnd();
                }
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ ContextMenu_androidKt$$ExternalSyntheticLambda0(ComposableLambdaImpl composableLambdaImpl, SelectionManager selectionManager) {
        this.$r8$classId = 2;
        this.f$1 = composableLambdaImpl;
        this.f$0 = selectionManager;
    }
}
