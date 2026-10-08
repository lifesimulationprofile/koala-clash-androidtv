package androidx.compose.foundation.text.selection;

import android.content.ClipData;
import android.os.Parcel;
import android.text.Annotation;
import android.text.Spanned;
import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.appcompat.widget.Toolbar;
import androidx.compose.foundation.internal.ClipboardUtils_androidKt;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.platform.AndroidClipboard;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.TextFieldValueKt;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldSelectionManager$cut$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public int label;
    public final /* synthetic */ TextFieldSelectionManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextFieldSelectionManager$cut$1(TextFieldSelectionManager textFieldSelectionManager, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.this$0 = textFieldSelectionManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new TextFieldSelectionManager$cut$1(this.this$0, continuation, 0);
            case 1:
                return new TextFieldSelectionManager$cut$1(this.this$0, continuation, 1);
            default:
                return new TextFieldSelectionManager$cut$1(this.this$0, continuation, 2);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                return ((TextFieldSelectionManager$cut$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 1:
                long j = ((Offset) obj).packedValue;
                return new TextFieldSelectionManager$cut$1(this.this$0, (Continuation) obj2, 1).invokeSuspend(Unit.INSTANCE);
            default:
                return ((TextFieldSelectionManager$cut$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: Code duplicated, block: B:150:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:153:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:71:0x014c  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        int i;
        AnnotatedString selectedText;
        Object clipEntry;
        Object annotatedString;
        CharSequence text;
        int i2;
        Spanned spanned;
        Toolbar.AnonymousClass1 anonymousClass1;
        int i3;
        AnnotatedString annotatedString2;
        int i4 = this.$r8$classId;
        HandleState handleState = HandleState.None;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        TextFieldSelectionManager textFieldSelectionManager = this.this$0;
        byte b = 1;
        switch (i4) {
            case 0:
                int i5 = this.label;
                if (i5 == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (TextRange.m641getCollapsedimpl(textFieldSelectionManager.getValue$foundation().selection) || !textFieldSelectionManager.getEditable()) {
                        i = 1;
                        selectedText = null;
                    } else {
                        selectedText = TextFieldValueKt.getSelectedText(textFieldSelectionManager.getValue$foundation());
                        AnnotatedString textBeforeSelection = TextFieldValueKt.getTextBeforeSelection(textFieldSelectionManager.getValue$foundation(), textFieldSelectionManager.getValue$foundation().annotatedString.text.length());
                        AnnotatedString textAfterSelection = TextFieldValueKt.getTextAfterSelection(textFieldSelectionManager.getValue$foundation(), textFieldSelectionManager.getValue$foundation().annotatedString.text.length());
                        AnnotatedString.Builder builder = new AnnotatedString.Builder(textBeforeSelection);
                        builder.append(textAfterSelection);
                        AnnotatedString annotatedString3 = builder.toAnnotatedString();
                        int iM644getMinimpl = TextRange.m644getMinimpl(textFieldSelectionManager.getValue$foundation().selection);
                        textFieldSelectionManager.onValueChange.invoke(TextFieldSelectionManager.m229createTextFieldValueFDrldGo(annotatedString3, ParagraphKt.TextRange(iM644getMinimpl, iM644getMinimpl)));
                        textFieldSelectionManager.setHandleState(handleState);
                        i = 1;
                        textFieldSelectionManager.undoManager.forceNextSnapshot = true;
                    }
                    if (selectedText == null) {
                        return Unit.INSTANCE;
                    }
                    Clipboard clipboard = textFieldSelectionManager.clipboard;
                    if (clipboard != null) {
                        ClipEntry clipEntry2 = ClipboardUtils_androidKt.toClipEntry(selectedText);
                        this.label = i;
                        if (((AndroidClipboard) clipboard).setClipEntry(clipEntry2) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            case 1:
                int i6 = this.label;
                if (i6 != 0) {
                    if (i6 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (i6 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (textFieldSelectionManager.updateClipboardEntry$foundation(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                Pair pairAccess$getContextTextAndSelection = TextFieldSelectionManager.access$getContextTextAndSelection(textFieldSelectionManager);
                if (pairAccess$getContextTextAndSelection != null) {
                    String str = (String) pairAccess$getContextTextAndSelection.first;
                    long j = ((TextRange) pairAccess$getContextTextAndSelection.second).packedValue;
                    PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl = textFieldSelectionManager.platformSelectionBehaviors;
                    if (platformSelectionBehaviorsImpl != null) {
                        this.label = 2;
                        Object objM216onShowContextMenuOrSelectionToolbarSbBc2M = platformSelectionBehaviorsImpl.m216onShowContextMenuOrSelectionToolbarSbBc2M(str, j, this);
                        if (objM216onShowContextMenuOrSelectionToolbarSbBc2M != coroutineSingletons) {
                            objM216onShowContextMenuOrSelectionToolbarSbBc2M = Unit.INSTANCE;
                        }
                        if (objM216onShowContextMenuOrSelectionToolbarSbBc2M == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                }
                return Unit.INSTANCE;
            default:
                int i7 = this.label;
                if (i7 == 0) {
                    ResultKt.throwOnFailure(obj);
                    Clipboard clipboard2 = textFieldSelectionManager.clipboard;
                    if (clipboard2 != null) {
                        this.label = 1;
                        ClipData primaryClip = ((AndroidClipboard) clipboard2).androidClipboardManager.getClipboardManager().getPrimaryClip();
                        clipEntry = primaryClip != null ? new ClipEntry(primaryClip) : null;
                        if (clipEntry == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    return Unit.INSTANCE;
                }
                if (i7 == 1) {
                    ResultKt.throwOnFailure(obj);
                    clipEntry = obj;
                } else {
                    if (i7 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    annotatedString = obj;
                }
                annotatedString2 = (AnnotatedString) annotatedString;
                if (annotatedString2 != null) {
                    if (textFieldSelectionManager.getEditable()) {
                        AnnotatedString.Builder builder2 = new AnnotatedString.Builder(TextFieldValueKt.getTextBeforeSelection(textFieldSelectionManager.getValue$foundation(), textFieldSelectionManager.getValue$foundation().annotatedString.text.length()));
                        builder2.append(annotatedString2);
                        AnnotatedString annotatedString4 = builder2.toAnnotatedString();
                        AnnotatedString textAfterSelection2 = TextFieldValueKt.getTextAfterSelection(textFieldSelectionManager.getValue$foundation(), textFieldSelectionManager.getValue$foundation().annotatedString.text.length());
                        AnnotatedString.Builder builder3 = new AnnotatedString.Builder(annotatedString4);
                        builder3.append(textAfterSelection2);
                        AnnotatedString annotatedString5 = builder3.toAnnotatedString();
                        int length = annotatedString2.text.length() + TextRange.m644getMinimpl(textFieldSelectionManager.getValue$foundation().selection);
                        textFieldSelectionManager.onValueChange.invoke(TextFieldSelectionManager.m229createTextFieldValueFDrldGo(annotatedString5, ParagraphKt.TextRange(length, length)));
                        textFieldSelectionManager.setHandleState(handleState);
                        textFieldSelectionManager.undoManager.forceNextSnapshot = true;
                    }
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
                ClipEntry clipEntry3 = (ClipEntry) clipEntry;
                if (clipEntry3 != null) {
                    this.label = 2;
                    ClipData clipData = clipEntry3.clipData;
                    int i8 = 0;
                    ClipData.Item itemAt = clipData.getItemAt(0);
                    if (itemAt == null || (text = itemAt.getText()) == null) {
                        annotatedString = null;
                    } else if (text instanceof Spanned) {
                        Spanned spanned2 = (Spanned) text;
                        Annotation[] annotationArr = (Annotation[]) spanned2.getSpans(0, spanned2.length(), Annotation.class);
                        ArrayList arrayList = new ArrayList();
                        int length2 = annotationArr.length - 1;
                        if (length2 >= 0) {
                            int i9 = 0;
                            while (true) {
                                Annotation annotation = annotationArr[i9];
                                if (Intrinsics.areEqual(annotation.getKey(), "androidx.compose.text.SpanStyle")) {
                                    int spanStart = spanned2.getSpanStart(annotation);
                                    int spanEnd = spanned2.getSpanEnd(annotation);
                                    i2 = i8;
                                    Toolbar.AnonymousClass1 anonymousClass2 = new Toolbar.AnonymousClass1(annotation.getValue());
                                    Parcel parcel = (Parcel) anonymousClass2.this$0;
                                    long jM11decodeColor0d7_KjU = Color.Unspecified;
                                    long jM11decodeColor0d7_KjU2 = jM11decodeColor0d7_KjU;
                                    long jM12decodeTextUnitXSAIIZE = TextUnit.Unspecified;
                                    long jM12decodeTextUnitXSAIIZE2 = jM12decodeTextUnitXSAIIZE;
                                    FontWeight fontWeight = null;
                                    FontStyle fontStyle = null;
                                    FontSynthesis fontSynthesis = null;
                                    String string = null;
                                    BaselineShift baselineShift = null;
                                    TextGeometricTransform textGeometricTransform = null;
                                    TextDecoration textDecoration = null;
                                    Shadow shadow = null;
                                    while (true) {
                                        if (parcel.dataAvail() > b) {
                                            byte b2 = parcel.readByte();
                                            text = text;
                                            if (b2 == b) {
                                                if (parcel.dataAvail() >= 8) {
                                                    jM11decodeColor0d7_KjU = anonymousClass2.m11decodeColor0d7_KjU();
                                                    text = text;
                                                }
                                            } else if (b2 == 2) {
                                                if (parcel.dataAvail() >= 5) {
                                                    jM12decodeTextUnitXSAIIZE = anonymousClass2.m12decodeTextUnitXSAIIZE();
                                                    b = 1;
                                                }
                                            } else if (b2 == 3) {
                                                if (parcel.dataAvail() >= 4) {
                                                    fontWeight = new FontWeight(parcel.readInt());
                                                    b = 1;
                                                }
                                            } else if (b2 == 4) {
                                                if (parcel.dataAvail() >= 1) {
                                                    byte b3 = parcel.readByte();
                                                    fontStyle = new FontStyle((b3 != 0 && b3 == 1) ? 1 : i2);
                                                    text = text;
                                                    b = 1;
                                                }
                                            } else if (b2 != 5) {
                                                if (b2 == 6) {
                                                    string = parcel.readString();
                                                } else if (b2 == 7) {
                                                    if (parcel.dataAvail() >= 5) {
                                                        jM12decodeTextUnitXSAIIZE2 = anonymousClass2.m12decodeTextUnitXSAIIZE();
                                                    }
                                                } else if (b2 == 8) {
                                                    if (parcel.dataAvail() >= 4) {
                                                        baselineShift = new BaselineShift(parcel.readFloat());
                                                    }
                                                } else if (b2 == 9) {
                                                    if (parcel.dataAvail() >= 8) {
                                                        textGeometricTransform = new TextGeometricTransform(parcel.readFloat(), parcel.readFloat());
                                                    }
                                                } else if (b2 == 10) {
                                                    if (parcel.dataAvail() >= 8) {
                                                        jM11decodeColor0d7_KjU2 = anonymousClass2.m11decodeColor0d7_KjU();
                                                    }
                                                } else if (b2 != 11) {
                                                    anonymousClass1 = anonymousClass2;
                                                    if (b2 != 12) {
                                                        anonymousClass2 = anonymousClass1;
                                                    } else if (parcel.dataAvail() >= 20) {
                                                        spanned2 = spanned2;
                                                        anonymousClass2 = anonymousClass1;
                                                        shadow = new Shadow(anonymousClass1.m11decodeColor0d7_KjU(), (((long) Float.floatToRawIntBits(parcel.readFloat())) << 32) | (((long) Float.floatToRawIntBits(parcel.readFloat())) & 4294967295L), parcel.readFloat());
                                                    }
                                                    b = 1;
                                                } else if (parcel.dataAvail() >= 4) {
                                                    int i10 = parcel.readInt();
                                                    int i11 = (i10 & 2) != 0 ? 1 : i2;
                                                    int i12 = (i10 & 1) != 0 ? 1 : i2;
                                                    TextDecoration textDecoration2 = TextDecoration.LineThrough;
                                                    TextDecoration textDecoration3 = TextDecoration.Underline;
                                                    if (i11 == 0 || i12 == 0) {
                                                        int i13 = i12;
                                                        anonymousClass1 = anonymousClass2;
                                                        if (i11 != 0) {
                                                            textDecoration = textDecoration2;
                                                        } else {
                                                            textDecoration = i13 != 0 ? textDecoration3 : TextDecoration.None;
                                                        }
                                                    } else {
                                                        TextDecoration[] textDecorationArr = new TextDecoration[2];
                                                        textDecorationArr[i2] = textDecoration2;
                                                        textDecorationArr[1] = textDecoration3;
                                                        List listListOf = AppCompatHintHelper.listOf(textDecorationArr);
                                                        Integer numValueOf = Integer.valueOf(i2);
                                                        int size = listListOf.size();
                                                        anonymousClass1 = anonymousClass2;
                                                        int i14 = i2;
                                                        while (i14 < size) {
                                                            numValueOf = Integer.valueOf(((TextDecoration) listListOf.get(i14)).mask | numValueOf.intValue());
                                                            i14++;
                                                            listListOf = listListOf;
                                                        }
                                                        textDecoration = new TextDecoration(numValueOf.intValue());
                                                    }
                                                    anonymousClass2 = anonymousClass1;
                                                    b = 1;
                                                }
                                                b = 1;
                                            } else if (parcel.dataAvail() >= 1) {
                                                byte b4 = parcel.readByte();
                                                if (b4 == 0) {
                                                    i3 = i2;
                                                } else if (b4 == 1) {
                                                    i3 = 65535;
                                                } else if (b4 == 3) {
                                                    i3 = 2;
                                                } else if (b4 == 2) {
                                                    i3 = 1;
                                                } else {
                                                    i3 = i2;
                                                }
                                                fontSynthesis = new FontSynthesis(i3);
                                                b = 1;
                                            }
                                        } else {
                                            text = text;
                                        }
                                    }
                                    spanned = spanned2;
                                    arrayList.add(new AnnotatedString.Range(spanStart, spanEnd, new SpanStyle(jM11decodeColor0d7_KjU, jM12decodeTextUnitXSAIIZE, fontWeight, fontStyle, fontSynthesis, null, string, jM12decodeTextUnitXSAIIZE2, baselineShift, textGeometricTransform, null, jM11decodeColor0d7_KjU2, textDecoration, shadow, 49152)));
                                } else {
                                    text = text;
                                    i2 = i8;
                                    spanned = spanned2;
                                }
                                if (i9 != length2) {
                                    i9++;
                                    i8 = i2;
                                    spanned2 = spanned;
                                    text = text;
                                    b = 1;
                                }
                            }
                        } else {
                            text = text;
                        }
                        String string2 = text.toString();
                        AnnotatedString annotatedString6 = AnnotatedStringKt.EmptyAnnotatedString;
                        if (arrayList.isEmpty()) {
                            arrayList = null;
                        }
                        annotatedString = new AnnotatedString(arrayList, string2);
                    } else {
                        annotatedString = new AnnotatedString(text.toString());
                    }
                    if (annotatedString == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    annotatedString2 = (AnnotatedString) annotatedString;
                    if (annotatedString2 != null) {
                        if (textFieldSelectionManager.getEditable()) {
                            AnnotatedString.Builder builder4 = new AnnotatedString.Builder(TextFieldValueKt.getTextBeforeSelection(textFieldSelectionManager.getValue$foundation(), textFieldSelectionManager.getValue$foundation().annotatedString.text.length()));
                            builder4.append(annotatedString2);
                            AnnotatedString annotatedString7 = builder4.toAnnotatedString();
                            AnnotatedString textAfterSelection3 = TextFieldValueKt.getTextAfterSelection(textFieldSelectionManager.getValue$foundation(), textFieldSelectionManager.getValue$foundation().annotatedString.text.length());
                            AnnotatedString.Builder builder5 = new AnnotatedString.Builder(annotatedString7);
                            builder5.append(textAfterSelection3);
                            AnnotatedString annotatedString8 = builder5.toAnnotatedString();
                            int length3 = annotatedString2.text.length() + TextRange.m644getMinimpl(textFieldSelectionManager.getValue$foundation().selection);
                            textFieldSelectionManager.onValueChange.invoke(TextFieldSelectionManager.m229createTextFieldValueFDrldGo(annotatedString8, ParagraphKt.TextRange(length3, length3)));
                            textFieldSelectionManager.setHandleState(handleState);
                            textFieldSelectionManager.undoManager.forceNextSnapshot = true;
                        }
                        return Unit.INSTANCE;
                    }
                }
                return Unit.INSTANCE;
        }
    }
}
