package androidx.compose.material3;

import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotId_jvmKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CheckboxKt$$ExternalSyntheticLambda2 implements Function2 {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ boolean f$5;
    public final /* synthetic */ Object f$6;
    public final /* synthetic */ int f$8;

    public /* synthetic */ CheckboxKt$$ExternalSyntheticLambda2(TextFieldSelectionManager textFieldSelectionManager, LegacyTextFieldState legacyTextFieldState, boolean z, Function1 function1, TextFieldValue textFieldValue, OffsetMapping offsetMapping, Density density, int i) {
        this.f$0 = textFieldSelectionManager;
        this.f$1 = legacyTextFieldState;
        this.f$5 = z;
        this.f$2 = function1;
        this.f$3 = textFieldValue;
        this.f$4 = offsetMapping;
        this.f$6 = density;
        this.f$8 = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                ((Integer) obj2).getClass();
                CheckboxKt.TriStateCheckbox((ToggleableState) this.f$0, (Function0) this.f$1, (Stroke) this.f$2, (Stroke) this.f$3, (Modifier) this.f$4, this.f$5, (CheckboxColors) this.f$6, (GapComposer) obj, Stack.updateChangedFlags(this.f$8 | 1));
                break;
            default:
                TextFieldSelectionManager textFieldSelectionManager = (TextFieldSelectionManager) this.f$0;
                final LegacyTextFieldState legacyTextFieldState = (LegacyTextFieldState) this.f$1;
                final Function1 function1 = (Function1) this.f$2;
                final TextFieldValue textFieldValue = (TextFieldValue) this.f$3;
                final OffsetMapping offsetMapping = (OffsetMapping) this.f$4;
                final Density density = (Density) this.f$6;
                GapComposer gapComposer = (GapComposer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                if (gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    final int i = this.f$8;
                    MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$8$1$1$2
                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        public final /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i2) {
                            return Modifier.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, list, i2);
                        }

                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        public final int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i2) {
                            LegacyTextFieldState legacyTextFieldState2 = legacyTextFieldState;
                            legacyTextFieldState2.textDelegate.layoutIntrinsics(intrinsicMeasureScope.getLayoutDirection());
                            Request request = legacyTextFieldState2.textDelegate.paragraphIntrinsics;
                            if (request != null) {
                                return BasicTextKt.ceilToIntPx(request.getMaxIntrinsicWidth());
                            }
                            throw new IllegalStateException("layoutIntrinsics must be called first");
                        }

                        /* JADX WARN: Code duplicated, block: B:64:0x012b  */
                        /* JADX WARN: Code duplicated, block: B:68:0x0132  */
                        /* JADX WARN: Code duplicated, block: B:70:0x0136  */
                        /* JADX WARN: Code duplicated, block: B:73:0x0148  */
                        /* JADX WARN: Code duplicated, block: B:76:0x01bf  */
                        /* JADX WARN: Code duplicated, block: B:78:0x01c3  */
                        /* JADX WARN: Code duplicated, block: B:79:0x01c8  */
                        /* JADX WARN: Code duplicated, block: B:81:0x01e5  */
                        /* JADX WARN: Code duplicated, block: B:84:0x01ef  */
                        /* JADX WARN: Code duplicated, block: B:85:0x01fa  */
                        /* JADX WARN: Code duplicated, block: B:88:0x0248  */
                        /* JADX WARN: Code duplicated, block: B:90:0x0250  */
                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        /* JADX INFO: renamed from: measure-3p2s80s */
                        public final MeasureResult mo24measure3p2s80s(MeasureScope measureScope, List list, long j) {
                            LegacyTextFieldState legacyTextFieldState2;
                            TextLayoutResult textLayoutResult;
                            TextLayoutResult textLayoutResult2;
                            TextLayoutResult textLayoutResult3;
                            CoreTextFieldKt$CoreTextField$8$1$1$2 coreTextFieldKt$CoreTextField$8$1$1$2;
                            LegacyTextFieldState legacyTextFieldState3;
                            int i2;
                            int iCeilToIntPx;
                            LayoutCoordinates layoutCoordinates;
                            int i3;
                            int iM685getMinWidthimpl;
                            int iM683getMaxWidthimpl;
                            int i4;
                            Request request;
                            Request request2;
                            LegacyTextFieldState legacyTextFieldState4 = legacyTextFieldState;
                            Snapshot currentThreadSnapshot = SnapshotId_jvmKt.getCurrentThreadSnapshot();
                            Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                            Snapshot snapshotMakeCurrentNonObservable = SnapshotId_jvmKt.makeCurrentNonObservable(currentThreadSnapshot);
                            try {
                                TextLayoutResultProxy layoutResult = legacyTextFieldState4.getLayoutResult();
                                SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                                TextLayoutResult textLayoutResult4 = layoutResult != null ? layoutResult.value : null;
                                TextDelegate textDelegate = legacyTextFieldState4.textDelegate;
                                LayoutDirection layoutDirection = measureScope.getLayoutDirection();
                                int i5 = textDelegate.overflow;
                                boolean z = textDelegate.softWrap;
                                int i6 = textDelegate.maxLines;
                                if (textLayoutResult4 != null) {
                                    MultiParagraph multiParagraph = textLayoutResult4.multiParagraph;
                                    TextLayoutInput textLayoutInput = textLayoutResult4.layoutInput;
                                    AnnotatedString annotatedString = textDelegate.text;
                                    TextStyle textStyle = textDelegate.style;
                                    List list2 = textDelegate.placeholders;
                                    Density density2 = textDelegate.density;
                                    FontFamily$Resolver fontFamily$Resolver = textDelegate.fontFamilyResolver;
                                    textLayoutResult2 = textLayoutResult4;
                                    if (!multiParagraph.intrinsics.getHasStaleResolvedFonts()) {
                                        AnnotatedString annotatedString2 = textLayoutInput.text;
                                        legacyTextFieldState2 = legacyTextFieldState4;
                                        long j2 = textLayoutInput.constraints;
                                        if (Intrinsics.areEqual(annotatedString2, annotatedString) && textLayoutInput.style.hasSameLayoutAffectingAttributes(textStyle) && Intrinsics.areEqual(textLayoutInput.placeholders, list2) && textLayoutInput.maxLines == i6 && textLayoutInput.softWrap == z && textLayoutInput.overflow == i5 && Intrinsics.areEqual(textLayoutInput.density, density2) && textLayoutInput.layoutDirection == layoutDirection && Intrinsics.areEqual(textLayoutInput.fontFamilyResolver, fontFamily$Resolver) && Constraints.m685getMinWidthimpl(j) == Constraints.m685getMinWidthimpl(j2)) {
                                            if ((z || i5 == 2) && !(Constraints.m683getMaxWidthimpl(j) == Constraints.m683getMaxWidthimpl(j2) && Constraints.m682getMaxHeightimpl(j) == Constraints.m682getMaxHeightimpl(j2))) {
                                                j = j;
                                                i3 = 2;
                                                textLayoutResult = textLayoutResult2;
                                                textDelegate.layoutIntrinsics(layoutDirection);
                                                iM685getMinWidthimpl = Constraints.m685getMinWidthimpl(j);
                                                iM683getMaxWidthimpl = ((!z || i5 == i3) && Constraints.m679getHasBoundedWidthimpl(j)) ? Constraints.m683getMaxWidthimpl(j) : Integer.MAX_VALUE;
                                                if (z && i5 == i3) {
                                                    i4 = 1;
                                                } else {
                                                    i4 = i6;
                                                }
                                                if (iM685getMinWidthimpl != iM683getMaxWidthimpl) {
                                                    request2 = textDelegate.paragraphIntrinsics;
                                                    if (request2 != null) {
                                                        throw new IllegalStateException("layoutIntrinsics must be called first");
                                                    }
                                                    iM683getMaxWidthimpl = RangesKt.coerceIn(BasicTextKt.ceilToIntPx(request2.getMaxIntrinsicWidth()), iM685getMinWidthimpl, iM683getMaxWidthimpl);
                                                }
                                                request = textDelegate.paragraphIntrinsics;
                                                if (request != null) {
                                                    throw new IllegalStateException("layoutIntrinsics must be called first");
                                                }
                                                MultiParagraph multiParagraph2 = new MultiParagraph(request, Constraints.Companion.m688fitPrioritizingWidthZbe2FdA(0, iM683getMaxWidthimpl, 0, Constraints.m682getMaxHeightimpl(j)), i4, textDelegate.overflow);
                                                textLayoutResult2 = textLayoutResult;
                                                textLayoutResult3 = new TextLayoutResult(new TextLayoutInput(textDelegate.text, textDelegate.style, textDelegate.placeholders, textDelegate.maxLines, textDelegate.softWrap, textDelegate.overflow, textDelegate.density, layoutDirection, textDelegate.fontFamilyResolver, j), multiParagraph2, ConstraintsKt.m689constrain4WqzIAM(j, (((long) BasicTextKt.ceilToIntPx(multiParagraph2.width)) << 32) | (((long) BasicTextKt.ceilToIntPx(multiParagraph2.height)) & 4294967295L)));
                                            } else {
                                                textLayoutResult3 = new TextLayoutResult(new TextLayoutInput(textLayoutInput.text, textDelegate.style, textLayoutInput.placeholders, textLayoutInput.maxLines, textLayoutInput.softWrap, textLayoutInput.overflow, textLayoutInput.density, textLayoutInput.layoutDirection, textLayoutInput.fontFamilyResolver, j), multiParagraph, ConstraintsKt.m689constrain4WqzIAM(j, (((long) BasicTextKt.ceilToIntPx(multiParagraph.height)) & 4294967295L) | (((long) BasicTextKt.ceilToIntPx(multiParagraph.width)) << 32)));
                                            }
                                        }
                                        long j3 = textLayoutResult3.size;
                                        Integer numValueOf = Integer.valueOf((int) (j3 >> 32));
                                        Integer numValueOf2 = Integer.valueOf((int) (j3 & 4294967295L));
                                        int iIntValue2 = numValueOf.intValue();
                                        int iIntValue3 = numValueOf2.intValue();
                                        if (Intrinsics.areEqual(textLayoutResult2, textLayoutResult3)) {
                                            coreTextFieldKt$CoreTextField$8$1$1$2 = this;
                                            legacyTextFieldState3 = legacyTextFieldState2;
                                            i2 = 0;
                                        } else {
                                            if (layoutResult != 0) {
                                                layoutCoordinates = layoutResult.decorationBoxCoordinates;
                                            } else {
                                                layoutCoordinates = null;
                                            }
                                            legacyTextFieldState3 = legacyTextFieldState2;
                                            legacyTextFieldState3.layoutResultState.setValue(new TextLayoutResultProxy(layoutCoordinates, textLayoutResult3));
                                            i2 = 0;
                                            legacyTextFieldState3.isLayoutResultStale = false;
                                            coreTextFieldKt$CoreTextField$8$1$1$2 = this;
                                            function1.invoke(textLayoutResult3);
                                            BasicTextKt.notifyFocusedRect(legacyTextFieldState3, textFieldValue, offsetMapping);
                                        }
                                        if (i == 1) {
                                            iCeilToIntPx = BasicTextKt.ceilToIntPx(textLayoutResult3.multiParagraph.getLineBottom(i2));
                                        } else {
                                            iCeilToIntPx = 0;
                                        }
                                        legacyTextFieldState3.minHeightForSingleLineField$delegate.setValue(new Dp(density.mo89toDpu2uoSUM(iCeilToIntPx)));
                                        return measureScope.layout(iIntValue2, iIntValue3, MapsKt__MapsKt.mapOf(new Pair(AlignmentLineKt.FirstBaseline, Integer.valueOf(Math.round(textLayoutResult3.firstBaseline))), new Pair(AlignmentLineKt.LastBaseline, Integer.valueOf(Math.round(textLayoutResult3.lastBaseline)))), new BasicTextKt$$ExternalSyntheticLambda3(18));
                                    }
                                    legacyTextFieldState2 = legacyTextFieldState4;
                                    textLayoutResult = textLayoutResult2;
                                } else {
                                    j = j;
                                    legacyTextFieldState2 = legacyTextFieldState4;
                                    textLayoutResult = textLayoutResult4;
                                }
                                i3 = 2;
                                textDelegate.layoutIntrinsics(layoutDirection);
                                iM685getMinWidthimpl = Constraints.m685getMinWidthimpl(j);
                                if (z) {
                                }
                                if (z) {
                                    i4 = i6;
                                } else {
                                    i4 = i6;
                                }
                                if (iM685getMinWidthimpl != iM683getMaxWidthimpl) {
                                    request2 = textDelegate.paragraphIntrinsics;
                                    if (request2 != null) {
                                        throw new IllegalStateException("layoutIntrinsics must be called first");
                                    }
                                    iM683getMaxWidthimpl = RangesKt.coerceIn(BasicTextKt.ceilToIntPx(request2.getMaxIntrinsicWidth()), iM685getMinWidthimpl, iM683getMaxWidthimpl);
                                }
                                request = textDelegate.paragraphIntrinsics;
                                if (request != null) {
                                    throw new IllegalStateException("layoutIntrinsics must be called first");
                                }
                                MultiParagraph multiParagraph3 = new MultiParagraph(request, Constraints.Companion.m688fitPrioritizingWidthZbe2FdA(0, iM683getMaxWidthimpl, 0, Constraints.m682getMaxHeightimpl(j)), i4, textDelegate.overflow);
                                textLayoutResult2 = textLayoutResult;
                                textLayoutResult3 = new TextLayoutResult(new TextLayoutInput(textDelegate.text, textDelegate.style, textDelegate.placeholders, textDelegate.maxLines, textDelegate.softWrap, textDelegate.overflow, textDelegate.density, layoutDirection, textDelegate.fontFamilyResolver, j), multiParagraph3, ConstraintsKt.m689constrain4WqzIAM(j, (((long) BasicTextKt.ceilToIntPx(multiParagraph3.width)) << 32) | (((long) BasicTextKt.ceilToIntPx(multiParagraph3.height)) & 4294967295L)));
                                long j4 = textLayoutResult3.size;
                                Integer numValueOf3 = Integer.valueOf((int) (j4 >> 32));
                                Integer numValueOf4 = Integer.valueOf((int) (j4 & 4294967295L));
                                int iIntValue4 = numValueOf3.intValue();
                                int iIntValue5 = numValueOf4.intValue();
                                if (Intrinsics.areEqual(textLayoutResult2, textLayoutResult3)) {
                                    if (layoutResult != 0) {
                                        layoutCoordinates = layoutResult.decorationBoxCoordinates;
                                    } else {
                                        layoutCoordinates = null;
                                    }
                                    legacyTextFieldState3 = legacyTextFieldState2;
                                    legacyTextFieldState3.layoutResultState.setValue(new TextLayoutResultProxy(layoutCoordinates, textLayoutResult3));
                                    i2 = 0;
                                    legacyTextFieldState3.isLayoutResultStale = false;
                                    coreTextFieldKt$CoreTextField$8$1$1$2 = this;
                                    function1.invoke(textLayoutResult3);
                                    BasicTextKt.notifyFocusedRect(legacyTextFieldState3, textFieldValue, offsetMapping);
                                } else {
                                    coreTextFieldKt$CoreTextField$8$1$1$2 = this;
                                    legacyTextFieldState3 = legacyTextFieldState2;
                                    i2 = 0;
                                }
                                if (i == 1) {
                                    iCeilToIntPx = BasicTextKt.ceilToIntPx(textLayoutResult3.multiParagraph.getLineBottom(i2));
                                } else {
                                    iCeilToIntPx = 0;
                                }
                                legacyTextFieldState3.minHeightForSingleLineField$delegate.setValue(new Dp(density.mo89toDpu2uoSUM(iCeilToIntPx)));
                                return measureScope.layout(iIntValue4, iIntValue5, MapsKt__MapsKt.mapOf(new Pair(AlignmentLineKt.FirstBaseline, Integer.valueOf(Math.round(textLayoutResult3.firstBaseline))), new Pair(AlignmentLineKt.LastBaseline, Integer.valueOf(Math.round(textLayoutResult3.lastBaseline)))), new BasicTextKt$$ExternalSyntheticLambda3(18));
                            } catch (Throwable th) {
                                SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                                throw th;
                            }
                        }

                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        public final /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i2) {
                            return Modifier.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, list, i2);
                        }

                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        public final /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i2) {
                            return Modifier.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, list, i2);
                        }
                    };
                    long j = gapComposer.compositeKeyHashCode;
                    int i2 = (int) (j ^ (j >>> 32));
                    PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, Modifier.Companion.$$INSTANCE);
                    ComposeUiNode.Companion.getClass();
                    LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                    gapComposer.startReusableNode();
                    if (gapComposer.inserting) {
                        gapComposer.createNode(layoutNode$Companion$Constructor$1);
                    } else {
                        gapComposer.useNode();
                    }
                    Stack.m295setimpl(gapComposer, measurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    Stack.m295setimpl(gapComposer, Integer.valueOf(i2), ComposeUiNode.Companion.SetCompositeKeyHash);
                    Stack.m294reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                    Stack.m295setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                    gapComposer.end(true);
                    HandleState handleState = legacyTextFieldState.getHandleState();
                    HandleState handleState2 = HandleState.None;
                    boolean z = this.f$5;
                    BasicTextKt.SelectionToolbarAndHandles(textFieldSelectionManager, handleState != handleState2 && legacyTextFieldState.getLayoutCoordinates() != null && legacyTextFieldState.getLayoutCoordinates().isAttached() && z, gapComposer, 0);
                    if (legacyTextFieldState.getHandleState() == HandleState.Cursor && z) {
                        gapComposer.startReplaceGroup(-714666198);
                        BasicTextKt.TextFieldCursorHandle(textFieldSelectionManager, gapComposer, 0);
                        gapComposer.end(false);
                    } else {
                        gapComposer.startReplaceGroup(-714589318);
                        gapComposer.end(false);
                    }
                } else {
                    gapComposer.skipToGroupEnd();
                }
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ CheckboxKt$$ExternalSyntheticLambda2(ToggleableState toggleableState, Function0 function0, Stroke stroke, Stroke stroke2, Modifier modifier, boolean z, CheckboxColors checkboxColors, int i) {
        this.f$0 = toggleableState;
        this.f$1 = function0;
        this.f$2 = stroke;
        this.f$3 = stroke2;
        this.f$4 = modifier;
        this.f$5 = z;
        this.f$6 = checkboxColors;
        this.f$8 = i;
    }
}
