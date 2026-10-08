package androidx.compose.foundation;

import androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda2;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.SurfaceRequest;
import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.style.ResolvedStyle;
import androidx.compose.foundation.style.ResolvedStyleKt;
import androidx.compose.foundation.style.StyleAnimations;
import androidx.compose.foundation.style.StyleOuterNode;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda3;
import androidx.compose.foundation.text.TextFieldKeyInput;
import androidx.compose.foundation.text.TextFieldScrollerPosition;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.UndoManager;
import androidx.compose.foundation.text.VerticalScrollLayoutModifier;
import androidx.compose.foundation.text.selection.TextFieldPreparedSelection;
import androidx.compose.foundation.text.selection.TextPreparedSelectionState;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionImpl;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.ParagraphStyle;
import androidx.compose.ui.text.PlatformParagraphStyle;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.SystemFontFamily;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.BrushStyle;
import androidx.compose.ui.text.style.ColorStyle;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDrawStyleKt;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import coil.network.HttpException;
import java.util.Collections;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ScrollNode$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ ScrollNode$$ExternalSyntheticLambda0(int i, int i2, Object obj, Object obj2) {
        this.$r8$classId = i2;
        this.f$0 = obj;
        this.f$1 = i;
        this.f$2 = obj2;
    }

    /* JADX WARN: Code duplicated, block: B:199:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:202:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:205:0x02d6  */
    /* JADX WARN: Code duplicated, block: B:206:0x02d9  */
    /* JADX WARN: Code duplicated, block: B:209:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:211:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:214:0x02f9  */
    /* JADX WARN: Code duplicated, block: B:215:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:218:0x0301  */
    /* JADX WARN: Code duplicated, block: B:219:0x0303  */
    /* JADX WARN: Code duplicated, block: B:221:0x0306  */
    /* JADX WARN: Code duplicated, block: B:222:0x030b  */
    /* JADX WARN: Code duplicated, block: B:224:0x030e  */
    /* JADX WARN: Code duplicated, block: B:225:0x0310  */
    /* JADX WARN: Code duplicated, block: B:229:0x0322  */
    /* JADX WARN: Code duplicated, block: B:230:0x0327  */
    /* JADX WARN: Code duplicated, block: B:233:0x0336  */
    /* JADX WARN: Code duplicated, block: B:236:0x0346  */
    /* JADX WARN: Code duplicated, block: B:237:0x0349  */
    /* JADX WARN: Code duplicated, block: B:240:0x0353  */
    /* JADX WARN: Code duplicated, block: B:242:0x035d  */
    /* JADX WARN: Code duplicated, block: B:245:0x0374  */
    /* JADX WARN: Code duplicated, block: B:247:0x037b  */
    /* JADX WARN: Code duplicated, block: B:250:0x038c  */
    /* JADX WARN: Code duplicated, block: B:252:0x0391  */
    /* JADX WARN: Code duplicated, block: B:255:0x03a0  */
    /* JADX WARN: Code duplicated, block: B:257:0x03a5  */
    /* JADX WARN: Code duplicated, block: B:260:0x03b8  */
    /* JADX WARN: Code duplicated, block: B:261:0x03bb  */
    /* JADX WARN: Code duplicated, block: B:264:0x03c1  */
    /* JADX WARN: Code duplicated, block: B:267:0x03cf  */
    /* JADX WARN: Code duplicated, block: B:268:0x03d2  */
    /* JADX WARN: Code duplicated, block: B:271:0x03de  */
    /* JADX WARN: Code duplicated, block: B:273:0x03e3  */
    /* JADX WARN: Code duplicated, block: B:276:0x0405  */
    /* JADX WARN: Code duplicated, block: B:278:0x045d  */
    /* JADX WARN: Code duplicated, block: B:279:0x0462  */
    /* JADX WARN: Code duplicated, block: B:282:0x0468  */
    /* JADX WARN: Code duplicated, block: B:284:0x0474  */
    /* JADX WARN: Code duplicated, block: B:285:0x047a  */
    /* JADX WARN: Code duplicated, block: B:288:0x048d  */
    /* JADX WARN: Code duplicated, block: B:290:0x0491  */
    /* JADX WARN: Code duplicated, block: B:293:0x04a4  */
    /* JADX WARN: Code duplicated, block: B:295:0x04b1  */
    /* JADX WARN: Code duplicated, block: B:297:0x04be  */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Integer previousWordOffset;
        Integer nextWordOffset;
        Integer nextWordOffset2;
        Integer previousWordOffset2;
        TextLayoutResult textLayoutResult;
        TextLayoutResult textLayoutResult2;
        TextLayoutResultProxy textLayoutResultProxy;
        TextLayoutResultProxy textLayoutResultProxy2;
        TextLayoutResult textLayoutResult3;
        TextLayoutResult textLayoutResult4;
        TextLayoutResultProxy textLayoutResultProxy3;
        TextLayoutResultProxy textLayoutResultProxy4;
        Integer nextWordOffset3;
        Integer previousWordOffset3;
        Integer previousWordOffset4;
        Integer nextWordOffset4;
        TextFieldValue textFieldValue;
        SurfaceRequest.AnonymousClass1 anonymousClass1;
        TextFieldValue textFieldValue2;
        boolean z;
        long j;
        StyleOuterNode styleOuterNode;
        StyleOuterNode styleOuterNode2;
        ResolvedStyle resolvedStyle;
        long jM649getColor0d7_KjU;
        long j2;
        SpanStyle spanStyle;
        ParagraphStyle paragraphStyle;
        long j3;
        long j4;
        FontWeight fontWeight;
        int i;
        boolean z2;
        boolean z3;
        int i2;
        FontStyle fontStyle;
        FontSynthesis fontSynthesis;
        SystemFontFamily systemFontFamily;
        long j5;
        long j6;
        long j7;
        BaselineShift baselineShift;
        TextDecoration textDecoration$foundation;
        int iM162getTextAligne0LSkKk$foundation;
        int iM163getTextDirections_7Xco$foundation;
        long j8;
        long j9;
        long j10;
        TextIndent textIndent;
        PlatformTextStyle platformTextStyle;
        int i3;
        int i4;
        int i5;
        int iM161getHyphensvmbZdU8$foundation;
        Brush brush;
        float alpha;
        PlatformSpanStyle platformSpanStyle;
        TextForegroundStyle brushStyle;
        PlatformParagraphStyle platformParagraphStyle;
        long jM675modulateDxMtmZc;
        TextForegroundStyle colorStyle;
        StyleAnimations styleAnimations;
        StyleAnimations styleAnimations2;
        Composition composition;
        Composition composition2;
        int i6;
        int i7 = this.$r8$classId;
        int i8 = 25;
        Object obj2 = this.f$2;
        int i9 = this.f$1;
        Object obj3 = this.f$0;
        switch (i7) {
            case 0:
                ScrollNode scrollNode = (ScrollNode) obj3;
                Placeable placeable = (Placeable) obj2;
                Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                int intValue = scrollNode.state.value$delegate.getIntValue();
                if (intValue < 0) {
                    intValue = 0;
                }
                if (intValue <= i9) {
                    i9 = intValue;
                }
                int i10 = -i9;
                boolean z4 = scrollNode.isVertical;
                int i11 = z4 ? 0 : i10;
                int i12 = z4 ? i10 : 0;
                placementScope.motionFrameOfReferencePlacement = true;
                Placeable.PlacementScope.placeRelativeWithLayer$default(placementScope, placeable, i11, i12, null, 12);
                Unit unit = Unit.INSTANCE;
                placementScope.motionFrameOfReferencePlacement = false;
                return Unit.INSTANCE;
            case 1:
                TextFieldKeyInput textFieldKeyInput = (TextFieldKeyInput) obj3;
                Ref$BooleanRef ref$BooleanRef = (Ref$BooleanRef) obj2;
                TextFieldPreparedSelection textFieldPreparedSelection = (TextFieldPreparedSelection) obj;
                switch (CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i9)) {
                    case 0:
                        textFieldPreparedSelection.state.cachedX = null;
                        if (textFieldPreparedSelection.annotatedString.text.length() > 0) {
                            if (TextRange.m641getCollapsedimpl(textFieldPreparedSelection.selection)) {
                                textFieldPreparedSelection.moveCursorLeft();
                                Unit unit2 = Unit.INSTANCE;
                            } else if (textFieldPreparedSelection.isLtr()) {
                                int iM644getMinimpl = TextRange.m644getMinimpl(textFieldPreparedSelection.selection);
                                textFieldPreparedSelection.setSelection(iM644getMinimpl, iM644getMinimpl);
                            } else {
                                int iM643getMaximpl = TextRange.m643getMaximpl(textFieldPreparedSelection.selection);
                                textFieldPreparedSelection.setSelection(iM643getMaximpl, iM643getMaximpl);
                            }
                        }
                        break;
                    case 1:
                        textFieldPreparedSelection.state.cachedX = null;
                        if (textFieldPreparedSelection.annotatedString.text.length() > 0) {
                            if (TextRange.m641getCollapsedimpl(textFieldPreparedSelection.selection)) {
                                textFieldPreparedSelection.moveCursorRight();
                                Unit unit3 = Unit.INSTANCE;
                            } else if (textFieldPreparedSelection.isLtr()) {
                                int iM643getMaximpl2 = TextRange.m643getMaximpl(textFieldPreparedSelection.selection);
                                textFieldPreparedSelection.setSelection(iM643getMaximpl2, iM643getMaximpl2);
                            } else {
                                int iM644getMinimpl2 = TextRange.m644getMinimpl(textFieldPreparedSelection.selection);
                                textFieldPreparedSelection.setSelection(iM644getMinimpl2, iM644getMinimpl2);
                            }
                        }
                        break;
                    case 2:
                        TextPreparedSelectionState textPreparedSelectionState = textFieldPreparedSelection.state;
                        textPreparedSelectionState.cachedX = null;
                        AnnotatedString annotatedString = textFieldPreparedSelection.annotatedString;
                        String str = annotatedString.text;
                        String str2 = annotatedString.text;
                        if (str.length() > 0) {
                            if (textFieldPreparedSelection.isLtr()) {
                                textPreparedSelectionState.cachedX = null;
                                if (str2.length() > 0 && (nextWordOffset = textFieldPreparedSelection.getNextWordOffset()) != null) {
                                    int iIntValue = nextWordOffset.intValue();
                                    textFieldPreparedSelection.setSelection(iIntValue, iIntValue);
                                }
                            } else {
                                textPreparedSelectionState.cachedX = null;
                                if (str2.length() > 0 && (previousWordOffset = textFieldPreparedSelection.getPreviousWordOffset()) != null) {
                                    int iIntValue2 = previousWordOffset.intValue();
                                    textFieldPreparedSelection.setSelection(iIntValue2, iIntValue2);
                                }
                            }
                        }
                        break;
                    case 3:
                        TextPreparedSelectionState textPreparedSelectionState2 = textFieldPreparedSelection.state;
                        textPreparedSelectionState2.cachedX = null;
                        AnnotatedString annotatedString2 = textFieldPreparedSelection.annotatedString;
                        String str3 = annotatedString2.text;
                        String str4 = annotatedString2.text;
                        if (str3.length() > 0) {
                            if (textFieldPreparedSelection.isLtr()) {
                                textPreparedSelectionState2.cachedX = null;
                                if (str4.length() > 0 && (previousWordOffset2 = textFieldPreparedSelection.getPreviousWordOffset()) != null) {
                                    int iIntValue3 = previousWordOffset2.intValue();
                                    textFieldPreparedSelection.setSelection(iIntValue3, iIntValue3);
                                }
                            } else {
                                textPreparedSelectionState2.cachedX = null;
                                if (str4.length() > 0 && (nextWordOffset2 = textFieldPreparedSelection.getNextWordOffset()) != null) {
                                    int iIntValue4 = nextWordOffset2.intValue();
                                    textFieldPreparedSelection.setSelection(iIntValue4, iIntValue4);
                                }
                            }
                        }
                        break;
                    case 4:
                        textFieldPreparedSelection.moveCursorNextByParagraph();
                        break;
                    case 5:
                        textFieldPreparedSelection.moveCursorPrevByParagraph();
                        break;
                    case 6:
                        textFieldPreparedSelection.moveCursorToLineStart();
                        break;
                    case 7:
                        textFieldPreparedSelection.moveCursorToLineEnd();
                        break;
                    case 8:
                        textFieldPreparedSelection.state.cachedX = null;
                        if (textFieldPreparedSelection.annotatedString.text.length() > 0) {
                            if (textFieldPreparedSelection.isLtr()) {
                                textFieldPreparedSelection.moveCursorToLineStart();
                            } else {
                                textFieldPreparedSelection.moveCursorToLineEnd();
                            }
                        }
                        break;
                    case 9:
                        textFieldPreparedSelection.state.cachedX = null;
                        if (textFieldPreparedSelection.annotatedString.text.length() > 0) {
                            if (textFieldPreparedSelection.isLtr()) {
                                textFieldPreparedSelection.moveCursorToLineEnd();
                            } else {
                                textFieldPreparedSelection.moveCursorToLineStart();
                            }
                        }
                        break;
                    case 10:
                        if (textFieldPreparedSelection.annotatedString.text.length() > 0 && (textLayoutResult = textFieldPreparedSelection.layoutResult) != null) {
                            int iJumpByLinesOffset = textFieldPreparedSelection.jumpByLinesOffset(textLayoutResult, -1);
                            textFieldPreparedSelection.setSelection(iJumpByLinesOffset, iJumpByLinesOffset);
                        }
                        break;
                    case 11:
                        if (textFieldPreparedSelection.annotatedString.text.length() > 0 && (textLayoutResult2 = textFieldPreparedSelection.layoutResult) != null) {
                            int iJumpByLinesOffset2 = textFieldPreparedSelection.jumpByLinesOffset(textLayoutResult2, 1);
                            textFieldPreparedSelection.setSelection(iJumpByLinesOffset2, iJumpByLinesOffset2);
                        }
                        break;
                    case 12:
                    case 48:
                        Unit unit4 = Unit.INSTANCE;
                        break;
                    case 13:
                        if (textFieldPreparedSelection.annotatedString.text.length() > 0 && (textLayoutResultProxy = textFieldPreparedSelection.layoutResultProxy) != null) {
                            int iJumpByPagesOffset = textFieldPreparedSelection.jumpByPagesOffset(textLayoutResultProxy, -1);
                            textFieldPreparedSelection.setSelection(iJumpByPagesOffset, iJumpByPagesOffset);
                        }
                        break;
                    case 14:
                        if (textFieldPreparedSelection.annotatedString.text.length() > 0 && (textLayoutResultProxy2 = textFieldPreparedSelection.layoutResultProxy) != null) {
                            int iJumpByPagesOffset2 = textFieldPreparedSelection.jumpByPagesOffset(textLayoutResultProxy2, 1);
                            textFieldPreparedSelection.setSelection(iJumpByPagesOffset2, iJumpByPagesOffset2);
                        }
                        break;
                    case 15:
                        textFieldPreparedSelection.state.cachedX = null;
                        if (textFieldPreparedSelection.annotatedString.text.length() > 0) {
                            textFieldPreparedSelection.setSelection(0, 0);
                        }
                        break;
                    case 16:
                        textFieldPreparedSelection.state.cachedX = null;
                        AnnotatedString annotatedString3 = textFieldPreparedSelection.annotatedString;
                        if (annotatedString3.text.length() > 0) {
                            int length = annotatedString3.text.length();
                            textFieldPreparedSelection.setSelection(length, length);
                        }
                        break;
                    case 17:
                        textFieldKeyInput.selectionManager.copy$foundation(false);
                        break;
                    case 18:
                        textFieldKeyInput.selectionManager.paste$foundation();
                        break;
                    case 19:
                        textFieldKeyInput.selectionManager.cut$foundation();
                        break;
                    case 20:
                        List listDeleteIfSelectedOr = textFieldPreparedSelection.deleteIfSelectedOr(new BasicTextKt$$ExternalSyntheticLambda3(21));
                        if (listDeleteIfSelectedOr != null) {
                            textFieldKeyInput.apply(listDeleteIfSelectedOr);
                            Unit unit5 = Unit.INSTANCE;
                        }
                        break;
                    case 21:
                        List listDeleteIfSelectedOr2 = textFieldPreparedSelection.deleteIfSelectedOr(new BasicTextKt$$ExternalSyntheticLambda3(22));
                        if (listDeleteIfSelectedOr2 != null) {
                            textFieldKeyInput.apply(listDeleteIfSelectedOr2);
                            Unit unit6 = Unit.INSTANCE;
                        }
                        break;
                    case 22:
                        List listDeleteIfSelectedOr3 = textFieldPreparedSelection.deleteIfSelectedOr(new BasicTextKt$$ExternalSyntheticLambda3(23));
                        if (listDeleteIfSelectedOr3 != null) {
                            textFieldKeyInput.apply(listDeleteIfSelectedOr3);
                            Unit unit7 = Unit.INSTANCE;
                        }
                        break;
                    case 23:
                        List listDeleteIfSelectedOr4 = textFieldPreparedSelection.deleteIfSelectedOr(new BasicTextKt$$ExternalSyntheticLambda3(24));
                        if (listDeleteIfSelectedOr4 != null) {
                            textFieldKeyInput.apply(listDeleteIfSelectedOr4);
                            Unit unit8 = Unit.INSTANCE;
                        }
                        break;
                    case 24:
                        List listDeleteIfSelectedOr5 = textFieldPreparedSelection.deleteIfSelectedOr(new BasicTextKt$$ExternalSyntheticLambda3(25));
                        if (listDeleteIfSelectedOr5 != null) {
                            textFieldKeyInput.apply(listDeleteIfSelectedOr5);
                            Unit unit9 = Unit.INSTANCE;
                        }
                        break;
                    case 25:
                        List listDeleteIfSelectedOr6 = textFieldPreparedSelection.deleteIfSelectedOr(new BasicTextKt$$ExternalSyntheticLambda3(26));
                        if (listDeleteIfSelectedOr6 != null) {
                            textFieldKeyInput.apply(listDeleteIfSelectedOr6);
                            Unit unit10 = Unit.INSTANCE;
                        }
                        break;
                    case 26:
                        textFieldPreparedSelection.state.cachedX = null;
                        AnnotatedString annotatedString4 = textFieldPreparedSelection.annotatedString;
                        if (annotatedString4.text.length() > 0) {
                            textFieldPreparedSelection.setSelection(0, annotatedString4.text.length());
                        }
                        break;
                    case 27:
                        textFieldPreparedSelection.moveCursorLeft();
                        textFieldPreparedSelection.selectMovement();
                        break;
                    case 28:
                        textFieldPreparedSelection.moveCursorRight();
                        textFieldPreparedSelection.selectMovement();
                        break;
                    case 29:
                        if (textFieldPreparedSelection.annotatedString.text.length() > 0 && (textLayoutResult3 = textFieldPreparedSelection.layoutResult) != null) {
                            int iJumpByLinesOffset3 = textFieldPreparedSelection.jumpByLinesOffset(textLayoutResult3, -1);
                            textFieldPreparedSelection.setSelection(iJumpByLinesOffset3, iJumpByLinesOffset3);
                        }
                        textFieldPreparedSelection.selectMovement();
                        break;
                    case 30:
                        if (textFieldPreparedSelection.annotatedString.text.length() > 0 && (textLayoutResult4 = textFieldPreparedSelection.layoutResult) != null) {
                            int iJumpByLinesOffset4 = textFieldPreparedSelection.jumpByLinesOffset(textLayoutResult4, 1);
                            textFieldPreparedSelection.setSelection(iJumpByLinesOffset4, iJumpByLinesOffset4);
                        }
                        textFieldPreparedSelection.selectMovement();
                        break;
                    case 31:
                        if (textFieldPreparedSelection.annotatedString.text.length() > 0 && (textLayoutResultProxy3 = textFieldPreparedSelection.layoutResultProxy) != null) {
                            int iJumpByPagesOffset3 = textFieldPreparedSelection.jumpByPagesOffset(textLayoutResultProxy3, -1);
                            textFieldPreparedSelection.setSelection(iJumpByPagesOffset3, iJumpByPagesOffset3);
                        }
                        textFieldPreparedSelection.selectMovement();
                        break;
                    case 32:
                        if (textFieldPreparedSelection.annotatedString.text.length() > 0 && (textLayoutResultProxy4 = textFieldPreparedSelection.layoutResultProxy) != null) {
                            int iJumpByPagesOffset4 = textFieldPreparedSelection.jumpByPagesOffset(textLayoutResultProxy4, 1);
                            textFieldPreparedSelection.setSelection(iJumpByPagesOffset4, iJumpByPagesOffset4);
                        }
                        textFieldPreparedSelection.selectMovement();
                        break;
                    case 33:
                        textFieldPreparedSelection.state.cachedX = null;
                        if (textFieldPreparedSelection.annotatedString.text.length() > 0) {
                            textFieldPreparedSelection.setSelection(0, 0);
                        }
                        textFieldPreparedSelection.selectMovement();
                        break;
                    case 34:
                        textFieldPreparedSelection.state.cachedX = null;
                        AnnotatedString annotatedString5 = textFieldPreparedSelection.annotatedString;
                        if (annotatedString5.text.length() > 0) {
                            int length2 = annotatedString5.text.length();
                            textFieldPreparedSelection.setSelection(length2, length2);
                        }
                        textFieldPreparedSelection.selectMovement();
                        break;
                    case 35:
                        TextPreparedSelectionState textPreparedSelectionState3 = textFieldPreparedSelection.state;
                        textPreparedSelectionState3.cachedX = null;
                        AnnotatedString annotatedString6 = textFieldPreparedSelection.annotatedString;
                        String str5 = annotatedString6.text;
                        String str6 = annotatedString6.text;
                        if (str5.length() > 0) {
                            if (textFieldPreparedSelection.isLtr()) {
                                textPreparedSelectionState3.cachedX = null;
                                if (str6.length() > 0 && (previousWordOffset3 = textFieldPreparedSelection.getPreviousWordOffset()) != null) {
                                    int iIntValue5 = previousWordOffset3.intValue();
                                    textFieldPreparedSelection.setSelection(iIntValue5, iIntValue5);
                                }
                            } else {
                                textPreparedSelectionState3.cachedX = null;
                                if (str6.length() > 0 && (nextWordOffset3 = textFieldPreparedSelection.getNextWordOffset()) != null) {
                                    int iIntValue6 = nextWordOffset3.intValue();
                                    textFieldPreparedSelection.setSelection(iIntValue6, iIntValue6);
                                }
                            }
                        }
                        textFieldPreparedSelection.selectMovement();
                        break;
                    case 36:
                        TextPreparedSelectionState textPreparedSelectionState4 = textFieldPreparedSelection.state;
                        textPreparedSelectionState4.cachedX = null;
                        AnnotatedString annotatedString7 = textFieldPreparedSelection.annotatedString;
                        String str7 = annotatedString7.text;
                        String str8 = annotatedString7.text;
                        if (str7.length() > 0) {
                            if (textFieldPreparedSelection.isLtr()) {
                                textPreparedSelectionState4.cachedX = null;
                                if (str8.length() > 0 && (nextWordOffset4 = textFieldPreparedSelection.getNextWordOffset()) != null) {
                                    int iIntValue7 = nextWordOffset4.intValue();
                                    textFieldPreparedSelection.setSelection(iIntValue7, iIntValue7);
                                }
                            } else {
                                textPreparedSelectionState4.cachedX = null;
                                if (str8.length() > 0 && (previousWordOffset4 = textFieldPreparedSelection.getPreviousWordOffset()) != null) {
                                    int iIntValue8 = previousWordOffset4.intValue();
                                    textFieldPreparedSelection.setSelection(iIntValue8, iIntValue8);
                                }
                            }
                        }
                        textFieldPreparedSelection.selectMovement();
                        break;
                    case 37:
                        textFieldPreparedSelection.moveCursorNextByParagraph();
                        textFieldPreparedSelection.selectMovement();
                        break;
                    case 38:
                        textFieldPreparedSelection.moveCursorPrevByParagraph();
                        textFieldPreparedSelection.selectMovement();
                        break;
                    case 39:
                        textFieldPreparedSelection.moveCursorToLineStart();
                        textFieldPreparedSelection.selectMovement();
                        break;
                    case 40:
                        textFieldPreparedSelection.moveCursorToLineEnd();
                        textFieldPreparedSelection.selectMovement();
                        break;
                    case 41:
                        textFieldPreparedSelection.state.cachedX = null;
                        if (textFieldPreparedSelection.annotatedString.text.length() > 0) {
                            if (textFieldPreparedSelection.isLtr()) {
                                textFieldPreparedSelection.moveCursorToLineStart();
                            } else {
                                textFieldPreparedSelection.moveCursorToLineEnd();
                            }
                        }
                        textFieldPreparedSelection.selectMovement();
                        break;
                    case 42:
                        textFieldPreparedSelection.state.cachedX = null;
                        if (textFieldPreparedSelection.annotatedString.text.length() > 0) {
                            if (textFieldPreparedSelection.isLtr()) {
                                textFieldPreparedSelection.moveCursorToLineEnd();
                            } else {
                                textFieldPreparedSelection.moveCursorToLineStart();
                            }
                        }
                        textFieldPreparedSelection.selectMovement();
                        break;
                    case 43:
                        textFieldPreparedSelection.state.cachedX = null;
                        if (textFieldPreparedSelection.annotatedString.text.length() > 0) {
                            long j11 = textFieldPreparedSelection.selection;
                            int i13 = TextRange.$r8$clinit;
                            int i14 = (int) (j11 & 4294967295L);
                            textFieldPreparedSelection.setSelection(i14, i14);
                        }
                        break;
                    case 44:
                        if (textFieldKeyInput.singleLine) {
                            ref$BooleanRef.element = textFieldKeyInput.state.onImeActionPerformedWithResult.f$0.keyboardActionRunner.m757runActionKlQnJC8(textFieldKeyInput.imeAction);
                        } else {
                            textFieldKeyInput.apply(Collections.singletonList(new CommitTextCommand("\n", 1)));
                        }
                        Unit unit11 = Unit.INSTANCE;
                        break;
                    case 45:
                        if (textFieldKeyInput.singleLine) {
                            ref$BooleanRef.element = false;
                        } else {
                            textFieldKeyInput.apply(Collections.singletonList(new CommitTextCommand("\t", 1)));
                        }
                        Unit unit12 = Unit.INSTANCE;
                        break;
                    case 46:
                        UndoManager undoManager = textFieldKeyInput.undoManager;
                        if (undoManager != null) {
                            undoManager.makeSnapshot(TextFieldValue.m663copy3r_uNRQ$default(textFieldPreparedSelection.currentValue, textFieldPreparedSelection.annotatedString, textFieldPreparedSelection.selection, 4));
                        }
                        UndoManager undoManager2 = textFieldKeyInput.undoManager;
                        if (undoManager2 != null) {
                            SurfaceRequest.AnonymousClass1 anonymousClass2 = undoManager2.undoStack;
                            if (anonymousClass2 == null || (anonymousClass1 = (SurfaceRequest.AnonymousClass1) anonymousClass2.val$requestCancellationCompleter) == null) {
                                textFieldValue = null;
                            } else {
                                undoManager2.undoStack = anonymousClass1;
                                undoManager2.storedCharacters -= ((TextFieldValue) anonymousClass2.val$requestCancellationFuture).annotatedString.text.length();
                                undoManager2.redoStack = new SurfaceRequest.AnonymousClass1(i8, undoManager2.redoStack, (TextFieldValue) anonymousClass2.val$requestCancellationFuture, false);
                                textFieldValue = (TextFieldValue) anonymousClass1.val$requestCancellationFuture;
                            }
                            if (textFieldValue != null) {
                                textFieldKeyInput.onValueChange.invoke(textFieldValue);
                                Unit unit13 = Unit.INSTANCE;
                            }
                        }
                        break;
                    case 47:
                        UndoManager undoManager3 = textFieldKeyInput.undoManager;
                        if (undoManager3 != null) {
                            SurfaceRequest.AnonymousClass1 anonymousClass3 = undoManager3.redoStack;
                            if (anonymousClass3 != null) {
                                undoManager3.redoStack = (SurfaceRequest.AnonymousClass1) anonymousClass3.val$requestCancellationCompleter;
                                TextFieldValue textFieldValue3 = (TextFieldValue) anonymousClass3.val$requestCancellationFuture;
                                undoManager3.undoStack = new SurfaceRequest.AnonymousClass1(i8, undoManager3.undoStack, textFieldValue3, false);
                                undoManager3.storedCharacters = textFieldValue3.annotatedString.text.length() + undoManager3.storedCharacters;
                                textFieldValue2 = (TextFieldValue) anonymousClass3.val$requestCancellationFuture;
                            } else {
                                textFieldValue2 = null;
                            }
                            if (textFieldValue2 != null) {
                                textFieldKeyInput.onValueChange.invoke(textFieldValue2);
                                Unit unit14 = Unit.INSTANCE;
                            }
                        }
                        break;
                    default:
                        throw new HttpException();
                }
                return Unit.INSTANCE;
            case 2:
                VerticalScrollLayoutModifier verticalScrollLayoutModifier = (VerticalScrollLayoutModifier) obj3;
                Placeable placeable2 = (Placeable) obj2;
                Placeable.PlacementScope placementScope2 = (Placeable.PlacementScope) obj;
                int i15 = verticalScrollLayoutModifier.cursorOffset;
                TextFieldScrollerPosition textFieldScrollerPosition = verticalScrollLayoutModifier.scrollerPosition;
                TransformedText transformedText = verticalScrollLayoutModifier.transformedText;
                TextLayoutResultProxy textLayoutResultProxy5 = (TextLayoutResultProxy) verticalScrollLayoutModifier.textLayoutResultProvider.invoke();
                textFieldScrollerPosition.update(Orientation.Vertical, BasicTextKt.access$getCursorRectInScroller(placementScope2, i15, transformedText, textLayoutResultProxy5 != null ? textLayoutResultProxy5.value : null, false, placeable2.width), i9, placeable2.height);
                Placeable.PlacementScope.placeRelative$default(placementScope2, placeable2, 0, Math.round(-textFieldScrollerPosition.offset$delegate.getFloatValue()));
                return Unit.INSTANCE;
            case 3:
                Ref$ObjectRef ref$ObjectRef = (Ref$ObjectRef) obj3;
                TextStyle textStyle = (TextStyle) obj2;
                TraversableNode traversableNode = (TraversableNode) obj;
                if (traversableNode instanceof StyleOuterNode) {
                    StyleOuterNode styleOuterNode3 = (StyleOuterNode) traversableNode;
                    char c = '`';
                    int i16 = i9 == 1 ? 32 : i9 == 2 ? 64 : 96;
                    Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                    MutableObjectList mutableObjectList = styleOuterNode3.ancestorNodes;
                    ref$ObjectRef2.element = mutableObjectList;
                    if ((styleOuterNode3._resolved.flags & 96) != 0 || ((styleAnimations2 = styleOuterNode3.animations) != null && styleAnimations2.size > 0)) {
                        if (mutableObjectList == null) {
                            mutableObjectList = new MutableObjectList();
                            ref$ObjectRef2.element = mutableObjectList;
                            styleOuterNode3.ancestorNodes = mutableObjectList;
                        }
                        mutableObjectList.add(styleOuterNode3);
                    }
                    HitTestResultKt.traverseAncestors(styleOuterNode3, "StyleOuterNode", new BackHandlerKt$$ExternalSyntheticLambda2(i8, ref$ObjectRef2, styleOuterNode3));
                    ResolvedStyle resolvedStyle2 = styleOuterNode3.inheritedStyleDirty ? null : styleOuterNode3.cachedInheritedStyle;
                    int i17 = resolvedStyle2 != null ? -1 : -2;
                    StyleAnimations styleAnimations3 = styleOuterNode3.animations;
                    boolean z5 = styleAnimations3 != null && styleAnimations3.size > 0;
                    int i18 = styleOuterNode3._resolved.flags & 96;
                    MutableObjectList mutableObjectList2 = (MutableObjectList) ref$ObjectRef2.element;
                    if (mutableObjectList2 != null) {
                        Object[] objArr = mutableObjectList2.content;
                        int i19 = mutableObjectList2._size;
                        int i20 = 0;
                        while (i20 < i19) {
                            char c2 = c;
                            StyleOuterNode styleOuterNode4 = (StyleOuterNode) objArr[i20];
                            ResolvedStyle resolvedStyle3 = styleOuterNode4.inheritedStyleDirty ? null : styleOuterNode4.cachedInheritedStyle;
                            z5 = z5 || ((styleAnimations = styleOuterNode4.animations) != null && styleAnimations.size > 0);
                            i18 |= styleOuterNode4._resolved.flags & 96;
                            if (resolvedStyle3 == null) {
                                i17 = -2;
                                resolvedStyle2 = null;
                            } else if (resolvedStyle2 == null) {
                                resolvedStyle2 = resolvedStyle3;
                                i17 = i20;
                            }
                            i20++;
                            c = c2;
                        }
                    }
                    if (i18 == 0) {
                        resolvedStyle2 = null;
                    } else {
                        if (resolvedStyle2 == null || i17 >= 0 || z5) {
                            Object obj4 = ref$ObjectRef2.element;
                            if (obj4 != null && i17 < -1) {
                                i17 = ((MutableObjectList) obj4)._size - 1;
                            }
                            for (int i21 = -2; i21 < i17; i21 = -2) {
                                if (i17 < 0) {
                                    styleOuterNode2 = styleOuterNode3;
                                } else {
                                    MutableObjectList mutableObjectList3 = (MutableObjectList) ref$ObjectRef2.element;
                                    if (mutableObjectList3 == null) {
                                        ref$ObjectRef = ref$ObjectRef;
                                    } else {
                                        styleOuterNode2 = (StyleOuterNode) mutableObjectList3.get(i17);
                                    }
                                    i17--;
                                    ref$ObjectRef = ref$ObjectRef;
                                }
                                ResolvedStyle resolvedStyle4 = styleOuterNode2.cachedInheritedStyle;
                                if (resolvedStyle4 == null) {
                                    resolvedStyle4 = new ResolvedStyle();
                                }
                                if (resolvedStyle2 != null) {
                                    resolvedStyle2.copyInheritedStylesInto$foundation(resolvedStyle4);
                                }
                                ResolvedStyle resolvedStyle5 = styleOuterNode2._resolved;
                                int i22 = resolvedStyle5.flags & 96;
                                if (i22 != 0) {
                                    resolvedStyle4.flags = i22 | resolvedStyle4.flags;
                                    long j12 = resolvedStyle5.contentColor;
                                    long j13 = resolvedStyle4.contentColor;
                                    if (j12 == 16) {
                                        j12 = j13;
                                    }
                                    resolvedStyle4.contentColor = j12;
                                    Brush brush2 = resolvedStyle5.contentBrush;
                                    if (brush2 == null) {
                                        brush2 = resolvedStyle4.contentBrush;
                                    }
                                    resolvedStyle4.contentBrush = brush2;
                                    SystemFontFamily systemFontFamily2 = resolvedStyle5.fontFamily;
                                    if (systemFontFamily2 == null) {
                                        systemFontFamily2 = resolvedStyle4.fontFamily;
                                    }
                                    resolvedStyle4.fontFamily = systemFontFamily2;
                                    TextIndent textIndent2 = resolvedStyle5.textIndent;
                                    if (textIndent2 == null) {
                                        textIndent2 = resolvedStyle4.textIndent;
                                    }
                                    resolvedStyle4.textIndent = textIndent2;
                                    long j14 = resolvedStyle5.fontSize;
                                    long j15 = resolvedStyle4.fontSize;
                                    TextUnitType[] textUnitTypeArr = TextUnit.TextUnitTypes;
                                    if ((j14 & 1095216660480L) == 0) {
                                        j14 = j15;
                                    }
                                    resolvedStyle4.fontSize = j14;
                                    long j16 = resolvedStyle5.lineHeight;
                                    long j17 = resolvedStyle4.lineHeight;
                                    if ((j16 & 1095216660480L) == 0) {
                                        j16 = j17;
                                    }
                                    resolvedStyle4.lineHeight = j16;
                                    long j18 = resolvedStyle5.letterSpacing;
                                    long j19 = resolvedStyle4.letterSpacing;
                                    if ((j18 & 1095216660480L) == 0) {
                                        j18 = j19;
                                    }
                                    resolvedStyle4.letterSpacing = j18;
                                    float f = resolvedStyle5.baselineShift;
                                    float f2 = resolvedStyle4.baselineShift;
                                    if (Float.compare(f, Float.NaN) != 0) {
                                        f = f2;
                                    }
                                    resolvedStyle4.baselineShift = f;
                                    int i23 = resolvedStyle5.lineBreak;
                                    int i24 = resolvedStyle4.lineBreak;
                                    if (i23 == 0) {
                                        i23 = i24;
                                    }
                                    resolvedStyle4.lineBreak = i23;
                                    int i25 = resolvedStyle4.textEnums;
                                    int i26 = resolvedStyle5.textEnums;
                                    int i27 = i26 & 3;
                                    int i28 = i25 & (-4);
                                    if (i27 != 0) {
                                        i25 = i27;
                                    }
                                    int i29 = i25 | i28;
                                    int i30 = i26 & 28;
                                    int i31 = i29 & (-29);
                                    if (i30 != 0) {
                                        i29 = i30;
                                    }
                                    int i32 = i29 | i31;
                                    int i33 = i26 & 112;
                                    int i34 = i32 & (-113);
                                    if (i33 != 0) {
                                        i32 = i33;
                                    }
                                    int i35 = i32 | i34;
                                    int i36 = i26 & 768;
                                    int i37 = i35 & (-769);
                                    if (i36 != 0) {
                                        i35 = i36;
                                    }
                                    int i38 = i35 | i37;
                                    int i39 = i26 & 15360;
                                    int i40 = i38 & (-15361);
                                    if (i39 != 0) {
                                        i38 = i39;
                                    }
                                    int i41 = i38 | i40;
                                    int i42 = i26 & 134086656;
                                    int i43 = (-134086657) & i41;
                                    if (i42 != 0) {
                                        i41 = i42;
                                    }
                                    resolvedStyle4.textEnums = i43 | i41;
                                }
                                styleOuterNode2.inheritedStyleDirty = false;
                                styleOuterNode2.cachedInheritedStyle = resolvedStyle4;
                                resolvedStyle2 = resolvedStyle4;
                                i17--;
                                ref$ObjectRef = ref$ObjectRef;
                            }
                            ref$ObjectRef = ref$ObjectRef;
                            j = 16;
                            if (z5) {
                                ResolvedStyle resolvedStyle6 = new ResolvedStyle();
                                if (resolvedStyle2 != null) {
                                    resolvedStyle2.copyInheritedStylesInto$foundation(resolvedStyle6);
                                }
                                MutableObjectList mutableObjectList4 = (MutableObjectList) ref$ObjectRef2.element;
                                int i44 = mutableObjectList4 != null ? mutableObjectList4._size : 0;
                                Density density = HitTestResultKt.requireLayoutNode(styleOuterNode3).density;
                                for (int i45 = i44 - 1; -2 < i45; i45--) {
                                    if (i45 < 0) {
                                        styleOuterNode = styleOuterNode3;
                                    } else {
                                        MutableObjectList mutableObjectList5 = (MutableObjectList) ref$ObjectRef2.element;
                                        if (mutableObjectList5 != null) {
                                            styleOuterNode = (StyleOuterNode) mutableObjectList5.get(i45);
                                        }
                                    }
                                    StyleAnimations styleAnimations4 = styleOuterNode.animations;
                                    if (styleAnimations4 != null) {
                                        styleAnimations4.applyAnimationsTo(resolvedStyle6, density, styleOuterNode, i16);
                                    }
                                }
                                resolvedStyle2 = resolvedStyle6;
                            }
                        }
                        if (resolvedStyle2 != null) {
                            resolvedStyle = ResolvedStyleKt.EmptyResolvedStyle;
                            jM649getColor0d7_KjU = resolvedStyle2.contentColor;
                            if (jM649getColor0d7_KjU == j) {
                                jM649getColor0d7_KjU = textStyle.m649getColor0d7_KjU();
                            }
                            long j20 = jM649getColor0d7_KjU;
                            j2 = resolvedStyle2.fontSize;
                            spanStyle = textStyle.spanStyle;
                            paragraphStyle = textStyle.paragraphStyle;
                            j3 = spanStyle.fontSize;
                            if ((j2 & 1095216660480L) == 0) {
                                j4 = j3;
                            } else {
                                j4 = j2;
                            }
                            if (((resolvedStyle2.textEnums & 134086656) >> 17) != 0) {
                                fontWeight = new FontWeight((134086656 & resolvedStyle2.textEnums) >> 17);
                            } else {
                                fontWeight = spanStyle.fontWeight;
                            }
                            FontWeight fontWeight2 = fontWeight;
                            i = resolvedStyle2.textEnums;
                            if ((i & 1) == 1) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if ((resolvedStyle.textEnums & 1) == 1) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (z2 == z3) {
                                fontStyle = spanStyle.fontStyle;
                            } else {
                                if ((i & 1) == 1) {
                                    i2 = 1;
                                } else {
                                    i2 = 0;
                                }
                                fontStyle = new FontStyle(i2);
                            }
                            if (resolvedStyle2.m160getFontSynthesisGVVA2EU$foundation() == resolvedStyle.m160getFontSynthesisGVVA2EU$foundation()) {
                                fontSynthesis = spanStyle.fontSynthesis;
                            } else {
                                fontSynthesis = new FontSynthesis(resolvedStyle2.m160getFontSynthesisGVVA2EU$foundation());
                            }
                            systemFontFamily = resolvedStyle2.fontFamily;
                            if (systemFontFamily == null) {
                                systemFontFamily = spanStyle.fontFamily;
                            }
                            SystemFontFamily systemFontFamily3 = systemFontFamily;
                            String str9 = spanStyle.fontFeatureSettings;
                            j5 = resolvedStyle2.letterSpacing;
                            j6 = spanStyle.letterSpacing;
                            if ((j5 & 1095216660480L) == 0) {
                                j7 = j6;
                            } else {
                                j7 = j5;
                            }
                            if (Float.isNaN(resolvedStyle2.baselineShift)) {
                                baselineShift = spanStyle.baselineShift;
                            } else {
                                baselineShift = new BaselineShift(resolvedStyle2.baselineShift);
                            }
                            BaselineShift baselineShift2 = baselineShift;
                            TextGeometricTransform textGeometricTransform = spanStyle.textGeometricTransform;
                            LocaleList localeList = spanStyle.localeList;
                            long j21 = spanStyle.background;
                            if (resolvedStyle2.getTextDecoration$foundation().equals(resolvedStyle.getTextDecoration$foundation())) {
                                textDecoration$foundation = spanStyle.textDecoration;
                            } else {
                                textDecoration$foundation = resolvedStyle2.getTextDecoration$foundation();
                            }
                            TextDecoration textDecoration = textDecoration$foundation;
                            Shadow shadow = spanStyle.shadow;
                            DrawStyle drawStyle = spanStyle.drawStyle;
                            if (resolvedStyle2.m162getTextAligne0LSkKk$foundation() == resolvedStyle.m162getTextAligne0LSkKk$foundation()) {
                                iM162getTextAligne0LSkKk$foundation = paragraphStyle.textAlign;
                            } else {
                                iM162getTextAligne0LSkKk$foundation = resolvedStyle2.m162getTextAligne0LSkKk$foundation();
                            }
                            int i46 = iM162getTextAligne0LSkKk$foundation;
                            if (resolvedStyle2.m163getTextDirections_7Xco$foundation() == resolvedStyle.m163getTextDirections_7Xco$foundation()) {
                                iM163getTextDirections_7Xco$foundation = paragraphStyle.textDirection;
                            } else {
                                iM163getTextDirections_7Xco$foundation = resolvedStyle2.m163getTextDirections_7Xco$foundation();
                            }
                            int i47 = iM163getTextDirections_7Xco$foundation;
                            j8 = resolvedStyle2.lineHeight;
                            j9 = paragraphStyle.lineHeight;
                            if ((j8 & 1095216660480L) == 0) {
                                j10 = j9;
                            } else {
                                j10 = j8;
                            }
                            textIndent = resolvedStyle2.textIndent;
                            if (textIndent == null) {
                                textIndent = paragraphStyle.textIndent;
                            }
                            TextIndent textIndent3 = textIndent;
                            platformTextStyle = textStyle.platformStyle;
                            LineHeightStyle lineHeightStyle = paragraphStyle.lineHeightStyle;
                            i3 = resolvedStyle2.lineBreak;
                            i4 = paragraphStyle.lineBreak;
                            if (i3 == 0) {
                                i5 = i4;
                            } else {
                                i5 = i3;
                            }
                            if (resolvedStyle2.m161getHyphensvmbZdU8$foundation() == resolvedStyle.m161getHyphensvmbZdU8$foundation()) {
                                iM161getHyphensvmbZdU8$foundation = paragraphStyle.hyphens;
                            } else {
                                iM161getHyphensvmbZdU8$foundation = resolvedStyle2.m161getHyphensvmbZdU8$foundation();
                            }
                            textStyle = new TextStyle(j20, j4, fontWeight2, fontStyle, fontSynthesis, systemFontFamily3, str9, j7, baselineShift2, textGeometricTransform, localeList, j21, textDecoration, shadow, drawStyle, i46, i47, j10, textIndent3, platformTextStyle, lineHeightStyle, i5, iM161getHyphensvmbZdU8$foundation, paragraphStyle.textMotion);
                            brush = resolvedStyle2.contentBrush;
                            if (brush != null) {
                                SpanStyle spanStyle2 = textStyle.spanStyle;
                                alpha = spanStyle2.textForegroundStyle.getAlpha();
                                long j22 = spanStyle2.fontSize;
                                FontWeight fontWeight3 = spanStyle2.fontWeight;
                                FontStyle fontStyle2 = spanStyle2.fontStyle;
                                FontSynthesis fontSynthesis2 = spanStyle2.fontSynthesis;
                                SystemFontFamily systemFontFamily4 = spanStyle2.fontFamily;
                                String str10 = spanStyle2.fontFeatureSettings;
                                long j23 = spanStyle2.letterSpacing;
                                BaselineShift baselineShift3 = spanStyle2.baselineShift;
                                TextGeometricTransform textGeometricTransform2 = spanStyle2.textGeometricTransform;
                                LocaleList localeList2 = spanStyle2.localeList;
                                long j24 = spanStyle2.background;
                                TextDecoration textDecoration2 = spanStyle2.textDecoration;
                                Shadow shadow2 = spanStyle2.shadow;
                                DrawStyle drawStyle2 = spanStyle2.drawStyle;
                                ParagraphStyle paragraphStyle2 = textStyle.paragraphStyle;
                                int i48 = paragraphStyle2.textAlign;
                                int i49 = paragraphStyle2.textDirection;
                                long j25 = paragraphStyle2.lineHeight;
                                TextIndent textIndent4 = paragraphStyle2.textIndent;
                                LineHeightStyle lineHeightStyle2 = paragraphStyle2.lineHeightStyle;
                                int i50 = paragraphStyle2.lineBreak;
                                int i51 = paragraphStyle2.hyphens;
                                TextMotion textMotion = paragraphStyle2.textMotion;
                                if (platformTextStyle != null) {
                                    platformSpanStyle = platformTextStyle.spanStyle;
                                } else {
                                    platformSpanStyle = null;
                                }
                                if (brush instanceof SolidColor) {
                                    jM675modulateDxMtmZc = TextDrawStyleKt.m675modulateDxMtmZc(alpha, ((SolidColor) brush).value);
                                    if (jM675modulateDxMtmZc != j) {
                                        colorStyle = new ColorStyle(jM675modulateDxMtmZc);
                                    } else {
                                        colorStyle = TextForegroundStyle.Unspecified.INSTANCE;
                                    }
                                    brushStyle = colorStyle;
                                } else {
                                    if (brush instanceof ShaderBrush) {
                                        throw new HttpException();
                                    }
                                    brushStyle = new BrushStyle((ShaderBrush) brush, alpha);
                                }
                                SpanStyle spanStyle3 = new SpanStyle(brushStyle, j22, fontWeight3, fontStyle2, fontSynthesis2, systemFontFamily4, str10, j23, baselineShift3, textGeometricTransform2, localeList2, j24, textDecoration2, shadow2, platformSpanStyle, drawStyle2);
                                if (platformTextStyle != null) {
                                    platformParagraphStyle = platformTextStyle.paragraphStyle;
                                } else {
                                    platformParagraphStyle = null;
                                }
                                textStyle = new TextStyle(spanStyle3, new ParagraphStyle(i48, i49, j25, textIndent4, platformParagraphStyle, lineHeightStyle2, i50, i51, textMotion), platformTextStyle);
                            }
                        }
                        ref$ObjectRef.element = textStyle;
                        z = false;
                    }
                    j = 16;
                    if (resolvedStyle2 != null) {
                        resolvedStyle = ResolvedStyleKt.EmptyResolvedStyle;
                        jM649getColor0d7_KjU = resolvedStyle2.contentColor;
                        if (jM649getColor0d7_KjU == j) {
                            jM649getColor0d7_KjU = textStyle.m649getColor0d7_KjU();
                        }
                        long j26 = jM649getColor0d7_KjU;
                        j2 = resolvedStyle2.fontSize;
                        spanStyle = textStyle.spanStyle;
                        paragraphStyle = textStyle.paragraphStyle;
                        j3 = spanStyle.fontSize;
                        if ((j2 & 1095216660480L) == 0) {
                            j4 = j3;
                        } else {
                            j4 = j2;
                        }
                        if (((resolvedStyle2.textEnums & 134086656) >> 17) != 0) {
                            fontWeight = new FontWeight((134086656 & resolvedStyle2.textEnums) >> 17);
                        } else {
                            fontWeight = spanStyle.fontWeight;
                        }
                        FontWeight fontWeight4 = fontWeight;
                        i = resolvedStyle2.textEnums;
                        if ((i & 1) == 1) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if ((resolvedStyle.textEnums & 1) == 1) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z2 == z3) {
                            fontStyle = spanStyle.fontStyle;
                        } else {
                            if ((i & 1) == 1) {
                                i2 = 1;
                            } else {
                                i2 = 0;
                            }
                            fontStyle = new FontStyle(i2);
                        }
                        if (resolvedStyle2.m160getFontSynthesisGVVA2EU$foundation() == resolvedStyle.m160getFontSynthesisGVVA2EU$foundation()) {
                            fontSynthesis = spanStyle.fontSynthesis;
                        } else {
                            fontSynthesis = new FontSynthesis(resolvedStyle2.m160getFontSynthesisGVVA2EU$foundation());
                        }
                        systemFontFamily = resolvedStyle2.fontFamily;
                        if (systemFontFamily == null) {
                            systemFontFamily = spanStyle.fontFamily;
                        }
                        SystemFontFamily systemFontFamily5 = systemFontFamily;
                        String str11 = spanStyle.fontFeatureSettings;
                        j5 = resolvedStyle2.letterSpacing;
                        j6 = spanStyle.letterSpacing;
                        if ((j5 & 1095216660480L) == 0) {
                            j7 = j6;
                        } else {
                            j7 = j5;
                        }
                        if (Float.isNaN(resolvedStyle2.baselineShift)) {
                            baselineShift = new BaselineShift(resolvedStyle2.baselineShift);
                        } else {
                            baselineShift = spanStyle.baselineShift;
                        }
                        BaselineShift baselineShift4 = baselineShift;
                        TextGeometricTransform textGeometricTransform3 = spanStyle.textGeometricTransform;
                        LocaleList localeList3 = spanStyle.localeList;
                        long j27 = spanStyle.background;
                        if (resolvedStyle2.getTextDecoration$foundation().equals(resolvedStyle.getTextDecoration$foundation())) {
                            textDecoration$foundation = resolvedStyle2.getTextDecoration$foundation();
                        } else {
                            textDecoration$foundation = spanStyle.textDecoration;
                        }
                        TextDecoration textDecoration3 = textDecoration$foundation;
                        Shadow shadow3 = spanStyle.shadow;
                        DrawStyle drawStyle3 = spanStyle.drawStyle;
                        if (resolvedStyle2.m162getTextAligne0LSkKk$foundation() == resolvedStyle.m162getTextAligne0LSkKk$foundation()) {
                            iM162getTextAligne0LSkKk$foundation = paragraphStyle.textAlign;
                        } else {
                            iM162getTextAligne0LSkKk$foundation = resolvedStyle2.m162getTextAligne0LSkKk$foundation();
                        }
                        int i410 = iM162getTextAligne0LSkKk$foundation;
                        if (resolvedStyle2.m163getTextDirections_7Xco$foundation() == resolvedStyle.m163getTextDirections_7Xco$foundation()) {
                            iM163getTextDirections_7Xco$foundation = paragraphStyle.textDirection;
                        } else {
                            iM163getTextDirections_7Xco$foundation = resolvedStyle2.m163getTextDirections_7Xco$foundation();
                        }
                        int i411 = iM163getTextDirections_7Xco$foundation;
                        j8 = resolvedStyle2.lineHeight;
                        j9 = paragraphStyle.lineHeight;
                        if ((j8 & 1095216660480L) == 0) {
                            j10 = j9;
                        } else {
                            j10 = j8;
                        }
                        textIndent = resolvedStyle2.textIndent;
                        if (textIndent == null) {
                            textIndent = paragraphStyle.textIndent;
                        }
                        TextIndent textIndent5 = textIndent;
                        platformTextStyle = textStyle.platformStyle;
                        LineHeightStyle lineHeightStyle3 = paragraphStyle.lineHeightStyle;
                        i3 = resolvedStyle2.lineBreak;
                        i4 = paragraphStyle.lineBreak;
                        if (i3 == 0) {
                            i5 = i4;
                        } else {
                            i5 = i3;
                        }
                        if (resolvedStyle2.m161getHyphensvmbZdU8$foundation() == resolvedStyle.m161getHyphensvmbZdU8$foundation()) {
                            iM161getHyphensvmbZdU8$foundation = paragraphStyle.hyphens;
                        } else {
                            iM161getHyphensvmbZdU8$foundation = resolvedStyle2.m161getHyphensvmbZdU8$foundation();
                        }
                        textStyle = new TextStyle(j26, j4, fontWeight4, fontStyle, fontSynthesis, systemFontFamily5, str11, j7, baselineShift4, textGeometricTransform3, localeList3, j27, textDecoration3, shadow3, drawStyle3, i410, i411, j10, textIndent5, platformTextStyle, lineHeightStyle3, i5, iM161getHyphensvmbZdU8$foundation, paragraphStyle.textMotion);
                        brush = resolvedStyle2.contentBrush;
                        if (brush != null) {
                            SpanStyle spanStyle4 = textStyle.spanStyle;
                            alpha = spanStyle4.textForegroundStyle.getAlpha();
                            long j28 = spanStyle4.fontSize;
                            FontWeight fontWeight5 = spanStyle4.fontWeight;
                            FontStyle fontStyle3 = spanStyle4.fontStyle;
                            FontSynthesis fontSynthesis3 = spanStyle4.fontSynthesis;
                            SystemFontFamily systemFontFamily6 = spanStyle4.fontFamily;
                            String str12 = spanStyle4.fontFeatureSettings;
                            long j29 = spanStyle4.letterSpacing;
                            BaselineShift baselineShift5 = spanStyle4.baselineShift;
                            TextGeometricTransform textGeometricTransform4 = spanStyle4.textGeometricTransform;
                            LocaleList localeList4 = spanStyle4.localeList;
                            long j210 = spanStyle4.background;
                            TextDecoration textDecoration4 = spanStyle4.textDecoration;
                            Shadow shadow4 = spanStyle4.shadow;
                            DrawStyle drawStyle4 = spanStyle4.drawStyle;
                            ParagraphStyle paragraphStyle3 = textStyle.paragraphStyle;
                            int i412 = paragraphStyle3.textAlign;
                            int i413 = paragraphStyle3.textDirection;
                            long j211 = paragraphStyle3.lineHeight;
                            TextIndent textIndent6 = paragraphStyle3.textIndent;
                            LineHeightStyle lineHeightStyle4 = paragraphStyle3.lineHeightStyle;
                            int i52 = paragraphStyle3.lineBreak;
                            int i53 = paragraphStyle3.hyphens;
                            TextMotion textMotion2 = paragraphStyle3.textMotion;
                            if (platformTextStyle != null) {
                                platformSpanStyle = platformTextStyle.spanStyle;
                            } else {
                                platformSpanStyle = null;
                            }
                            if (brush instanceof SolidColor) {
                                jM675modulateDxMtmZc = TextDrawStyleKt.m675modulateDxMtmZc(alpha, ((SolidColor) brush).value);
                                if (jM675modulateDxMtmZc != j) {
                                    colorStyle = new ColorStyle(jM675modulateDxMtmZc);
                                } else {
                                    colorStyle = TextForegroundStyle.Unspecified.INSTANCE;
                                }
                                brushStyle = colorStyle;
                            } else {
                                if (brush instanceof ShaderBrush) {
                                    throw new HttpException();
                                }
                                brushStyle = new BrushStyle((ShaderBrush) brush, alpha);
                            }
                            SpanStyle spanStyle5 = new SpanStyle(brushStyle, j28, fontWeight5, fontStyle3, fontSynthesis3, systemFontFamily6, str12, j29, baselineShift5, textGeometricTransform4, localeList4, j210, textDecoration4, shadow4, platformSpanStyle, drawStyle4);
                            if (platformTextStyle != null) {
                                platformParagraphStyle = platformTextStyle.paragraphStyle;
                            } else {
                                platformParagraphStyle = null;
                            }
                            textStyle = new TextStyle(spanStyle5, new ParagraphStyle(i412, i413, j211, textIndent6, platformParagraphStyle, lineHeightStyle4, i52, i53, textMotion2), platformTextStyle);
                        }
                    }
                    ref$ObjectRef.element = textStyle;
                    z = false;
                } else {
                    z = true;
                }
                return Boolean.valueOf(z);
            default:
                RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj3;
                MutableObjectIntMap mutableObjectIntMap = (MutableObjectIntMap) obj2;
                Composition composition3 = (Composition) obj;
                if (recomposeScopeImpl.currentToken == i9 && Intrinsics.areEqual(mutableObjectIntMap, recomposeScopeImpl.trackedInstances) && (composition3 instanceof CompositionImpl)) {
                    long[] jArr = mutableObjectIntMap.metadata;
                    int length3 = jArr.length - 2;
                    if (length3 >= 0) {
                        int i54 = 0;
                        while (true) {
                            long j30 = jArr[i54];
                            if ((((~j30) << 7) & j30 & (-9187201950435737472L)) != -9187201950435737472L) {
                                int i55 = 8;
                                int i56 = 8 - ((~(i54 - length3)) >>> 31);
                                int i57 = 0;
                                while (i57 < i56) {
                                    if ((255 & j30) < 128) {
                                        int i58 = (i54 << 3) + i57;
                                        Object obj5 = mutableObjectIntMap.keys[i58];
                                        boolean z6 = mutableObjectIntMap.values[i58] != i9;
                                        if (z6) {
                                            i6 = i55;
                                            CompositionImpl compositionImpl = (CompositionImpl) composition3;
                                            MutableScatterMap mutableScatterMap = compositionImpl.observations;
                                            ScopeMap.m299removeimpl(mutableScatterMap, obj5, recomposeScopeImpl);
                                            composition2 = composition3;
                                            if (obj5 instanceof DerivedSnapshotState) {
                                                DerivedSnapshotState derivedSnapshotState = (DerivedSnapshotState) obj5;
                                                if (!mutableScatterMap.containsKey(derivedSnapshotState)) {
                                                    ScopeMap.m300removeScopeimpl(compositionImpl.derivedStates, derivedSnapshotState);
                                                }
                                                MutableScatterMap mutableScatterMap2 = recomposeScopeImpl.trackedDependencies;
                                                if (mutableScatterMap2 != null) {
                                                    mutableScatterMap2.remove(obj5);
                                                }
                                            }
                                        } else {
                                            composition2 = composition3;
                                            i6 = i55;
                                        }
                                        if (z6) {
                                            mutableObjectIntMap.removeValueAt(i58);
                                        }
                                    } else {
                                        composition2 = composition3;
                                        i6 = i55;
                                    }
                                    j30 >>= i6;
                                    i57++;
                                    i55 = i6;
                                    composition3 = composition2;
                                }
                                composition = composition3;
                                if (i56 == i55) {
                                }
                            } else {
                                composition = composition3;
                            }
                            if (i54 != length3) {
                                i54++;
                                composition3 = composition;
                            }
                        }
                    }
                }
                return Unit.INSTANCE;
        }
    }

    public /* synthetic */ ScrollNode$$ExternalSyntheticLambda0(int i, TextFieldKeyInput textFieldKeyInput, Ref$BooleanRef ref$BooleanRef) {
        this.$r8$classId = 1;
        this.f$1 = i;
        this.f$0 = textFieldKeyInput;
        this.f$2 = ref$BooleanRef;
    }

    public /* synthetic */ ScrollNode$$ExternalSyntheticLambda0(VerticalScrollLayoutModifier verticalScrollLayoutModifier, Placeable placeable, int i) {
        this.$r8$classId = 2;
        this.f$0 = verticalScrollLayoutModifier;
        this.f$2 = placeable;
        this.f$1 = i;
    }
}
