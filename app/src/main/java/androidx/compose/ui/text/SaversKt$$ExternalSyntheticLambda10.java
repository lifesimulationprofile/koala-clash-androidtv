package androidx.compose.ui.text;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.foundation.text.selection.SelectionMagnifierKt;
import androidx.compose.foundation.text.selection.SelectionRegistrarImpl;
import androidx.compose.material3.RippleConfiguration;
import androidx.compose.material3.internal.ParentSemanticsNode;
import androidx.compose.material3.tokens.MotionTokens;
import androidx.compose.runtime.NextFrameEndCallbackQueue$NextFrameEndAwaiter;
import androidx.compose.runtime.saveable.SaveableStateHolderImpl;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import okhttp3.Handshake;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SaversKt$$ExternalSyntheticLambda10 implements Function1 {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ SaversKt$$ExternalSyntheticLambda10(int i) {
        this.$r8$classId = i;
    }

    /* JADX WARN: Type inference failed for: r1v19, types: [java.lang.Object, java.util.Collection, java.util.List] */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        SpanStyle spanStyle = null;
        spanStyle = null;
        switch (this.$r8$classId) {
            case 0:
                List list = (List) obj;
                Object obj2 = list.get(0);
                Function1 function1 = (Function1) SaversKt.SpanStyleSaver.hardwareBitmapService;
                Boolean bool = Boolean.FALSE;
                SpanStyle spanStyle2 = (Intrinsics.areEqual(obj2, bool) || obj2 == null) ? null : (SpanStyle) function1.invoke(obj2);
                Object obj3 = list.get(1);
                SpanStyle spanStyle3 = (Intrinsics.areEqual(obj3, bool) || obj3 == null) ? null : (SpanStyle) function1.invoke(obj3);
                Object obj4 = list.get(2);
                SpanStyle spanStyle4 = (Intrinsics.areEqual(obj4, bool) || obj4 == null) ? null : (SpanStyle) function1.invoke(obj4);
                Object obj5 = list.get(3);
                if (!Intrinsics.areEqual(obj5, bool) && obj5 != null) {
                    spanStyle = (SpanStyle) function1.invoke(obj5);
                }
                return new TextLinkStyles(spanStyle2, spanStyle3, spanStyle4, spanStyle);
            case 1:
                return Unit.INSTANCE;
            case 2:
                return Unit.INSTANCE;
            case 3:
                Offset offset = (Offset) obj;
                long j = offset.packedValue;
                return (9223372034707292159L & j) != 9205357640488583168L ? new AnimationVector2D(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (4294967295L & offset.packedValue))) : SelectionMagnifierKt.UnspecifiedAnimationVector2D;
            case 4:
                AnimationVector2D animationVector2D = (AnimationVector2D) obj;
                return new Offset((4294967295L & ((long) Float.floatToRawIntBits(animationVector2D.v2))) | (((long) Float.floatToRawIntBits(animationVector2D.v1)) << 32));
            case 5:
                return new SelectionRegistrarImpl(((Long) obj).longValue());
            case 6:
                return Unit.INSTANCE;
            case 7:
                SemanticsPropertiesKt.m616setRolekuIjeqM((SemanticsPropertyReceiver) obj, 0);
                return Unit.INSTANCE;
            case 8:
                SemanticsPropertiesKt.setTraversalGroup((SemanticsPropertyReceiver) obj);
                return Unit.INSTANCE;
            case 9:
                return Boolean.TRUE;
            case 10:
                SemanticsPropertiesKt.setTraversalGroup((SemanticsPropertyReceiver) obj);
                return Unit.INSTANCE;
            case 11:
                KProperty[] kPropertyArr = SemanticsPropertiesKt.$$delegatedProperties;
                SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.IsDialog;
                Unit unit = Unit.INSTANCE;
                ((SemanticsPropertyReceiver) obj).set(semanticsPropertyKey, unit);
                return unit;
            case 12:
                KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig = (KeyframesSpec.KeyframesSpecConfig) obj;
                keyframesSpecConfig.durationMillis = 6000;
                Float fValueOf = Float.valueOf(90.0f);
                keyframesSpecConfig.at(fValueOf, 300).easing = MotionTokens.EasingEmphasizedDecelerateCubicBezier;
                keyframesSpecConfig.at(fValueOf, 1500);
                Float fValueOf2 = Float.valueOf(180.0f);
                keyframesSpecConfig.at(fValueOf2, 1800);
                keyframesSpecConfig.at(fValueOf2, 3000);
                Float fValueOf3 = Float.valueOf(270.0f);
                keyframesSpecConfig.at(fValueOf3, 3300);
                keyframesSpecConfig.at(fValueOf3, 4500);
                Float fValueOf4 = Float.valueOf(360.0f);
                keyframesSpecConfig.at(fValueOf4, 4800);
                keyframesSpecConfig.at(fValueOf4, 6000);
                return Unit.INSTANCE;
            case 13:
                return new RippleConfiguration();
            case 14:
                KProperty[] kPropertyArr2 = SemanticsPropertiesKt.$$delegatedProperties;
                SemanticsPropertyKey semanticsPropertyKey2 = SemanticsProperties.IsContainer;
                KProperty kProperty = SemanticsPropertiesKt.$$delegatedProperties[5];
                ((SemanticsPropertyReceiver) obj).set(semanticsPropertyKey2, Boolean.TRUE);
                return Unit.INSTANCE;
            case 15:
                return Unit.INSTANCE;
            case 16:
                return Unit.INSTANCE;
            case 17:
                return Unit.INSTANCE;
            case 18:
                ParentSemanticsNode parentSemanticsNode = (ParentSemanticsNode) ((TraversableNode) obj);
                parentSemanticsNode.semanticsConsumed = false;
                HitTestResultKt.invalidateSemantics(parentSemanticsNode);
                return Boolean.FALSE;
            case 19:
                Handshake.AnonymousClass2 anonymousClass2 = ((NextFrameEndCallbackQueue$NextFrameEndAwaiter) obj).onNextFrameEnd;
                if (anonymousClass2 != null) {
                    anonymousClass2.invoke();
                }
                return Unit.INSTANCE;
            case 20:
                return new SaveableStateHolderImpl((Map) obj);
            case 21:
                return obj;
            case 22:
                synchronized (SnapshotKt.lock) {
                    ?? r1 = SnapshotKt.globalWriteObservers;
                    int size = r1.size();
                    for (int i = 0; i < size; i++) {
                        ((Function1) r1.get(i)).invoke(obj);
                    }
                }
                return Unit.INSTANCE;
            case 23:
                return Unit.INSTANCE;
            case 24:
                return Boolean.valueOf(!(((AnnotatedString.Annotation) obj) instanceof ParagraphStyle));
            case 25:
                ParagraphInfo paragraphInfo = (ParagraphInfo) obj;
                StringBuilder sb = new StringBuilder("[");
                sb.append(paragraphInfo.startIndex);
                sb.append(", ");
                return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, paragraphInfo.endIndex, ')');
            case 26:
                List list2 = (List) obj;
                Object obj6 = list2.get(1);
                List list3 = (Intrinsics.areEqual(obj6, Boolean.FALSE) || obj6 == null) ? null : (List) ((Function1) SaversKt.AnnotationRangeListSaver.hardwareBitmapService).invoke(obj6);
                Object obj7 = list2.get(0);
                return new AnnotatedString(list3, obj7 != null ? (String) obj7 : null);
            case 27:
                return new TextDecoration(((Integer) obj).intValue());
            case 28:
                List list4 = (List) obj;
                return new TextGeometricTransform(((Number) list4.get(0)).floatValue(), ((Number) list4.get(1)).floatValue());
            default:
                List list5 = (List) obj;
                Object obj8 = list5.get(0);
                TextUnitType[] textUnitTypeArr = TextUnit.TextUnitTypes;
                Function1 function2 = SaversKt.TextUnitSaver.$restore;
                Boolean bool2 = Boolean.FALSE;
                Intrinsics.areEqual(obj8, bool2);
                long j2 = (obj8 != null ? (TextUnit) function2.invoke(obj8) : null).packedValue;
                Object obj9 = list5.get(1);
                Intrinsics.areEqual(obj9, bool2);
                return new TextIndent(j2, (obj9 != null ? (TextUnit) function2.invoke(obj9) : null).packedValue);
        }
    }
}
