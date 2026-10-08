package androidx.compose.foundation.text.modifiers;

import android.os.Trace;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LookaheadCapablePlaceable;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import coil.compose.ContentPainterNode$$ExternalSyntheticLambda0;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TextAnnotatedStringNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode, SemanticsModifierNode {
    public MultiParagraphLayoutCache _layoutCache;
    public Map baselineCache;
    public FontFamily$Resolver fontFamilyResolver;
    public int maxLines;
    public int minLines;
    public Function1 onTextLayout;
    public int overflow;
    public SelectionController selectionController;
    public TextAnnotatedStringNode$$ExternalSyntheticLambda1 semanticsTextLayoutResult;
    public boolean softWrap;
    public TextStyle style;
    public AnnotatedString text;
    public TextSubstitutionValue textSubstitution;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class TextSubstitutionValue {
        public boolean isShowingSubstitution = false;
        public MultiParagraphLayoutCache layoutCache = null;
        public final AnnotatedString original;
        public AnnotatedString substitution;

        public TextSubstitutionValue(AnnotatedString annotatedString, AnnotatedString annotatedString2) {
            this.original = annotatedString;
            this.substitution = annotatedString2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TextSubstitutionValue)) {
                return false;
            }
            TextSubstitutionValue textSubstitutionValue = (TextSubstitutionValue) obj;
            return Intrinsics.areEqual(this.original, textSubstitutionValue.original) && Intrinsics.areEqual(this.substitution, textSubstitutionValue.substitution) && this.isShowingSubstitution == textSubstitutionValue.isShowingSubstitution && Intrinsics.areEqual(this.layoutCache, textSubstitutionValue.layoutCache);
        }

        public final int hashCode() {
            int iHashCode = (((this.substitution.hashCode() + (this.original.hashCode() * 31)) * 31) + (this.isShowingSubstitution ? 1231 : 1237)) * 31;
            MultiParagraphLayoutCache multiParagraphLayoutCache = this.layoutCache;
            return iHashCode + (multiParagraphLayoutCache == null ? 0 : multiParagraphLayoutCache.hashCode());
        }

        public final String toString() {
            return "TextSubstitutionValue(original=" + ((Object) this.original) + ", substitution=" + ((Object) this.substitution) + ", isShowingSubstitution=" + this.isShowingSubstitution + ", layoutCache=" + this.layoutCache + ')';
        }
    }

    public TextAnnotatedStringNode(AnnotatedString annotatedString, TextStyle textStyle, FontFamily$Resolver fontFamily$Resolver, Function1 function1, int i, boolean z, int i2, int i3, SelectionController selectionController) {
        this.text = annotatedString;
        this.style = textStyle;
        this.fontFamilyResolver = fontFamily$Resolver;
        this.onTextLayout = function1;
        this.overflow = i;
        this.softWrap = z;
        this.maxLines = i2;
        this.minLines = i3;
        this.selectionController = selectionController;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode$$ExternalSyntheticLambda1] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        TextAnnotatedStringNode$$ExternalSyntheticLambda1 textAnnotatedStringNode$$ExternalSyntheticLambda1 = this.semanticsTextLayoutResult;
        ?? r0 = textAnnotatedStringNode$$ExternalSyntheticLambda1;
        if (textAnnotatedStringNode$$ExternalSyntheticLambda1 == null) {
            final int i = 0;
            ?? r1 = new Function1(this) { // from class: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode$$ExternalSyntheticLambda1
                public final /* synthetic */ TextAnnotatedStringNode f$0;

                {
                    this.f$0 = this;
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    TextLayoutResult textLayoutResult;
                    boolean z;
                    switch (i) {
                        case 0:
                            List list = (List) obj;
                            TextAnnotatedStringNode textAnnotatedStringNode = this.f$0;
                            TextLayoutResult textLayoutResult2 = textAnnotatedStringNode.getLayoutCache().layoutCache;
                            if (textLayoutResult2 != null) {
                                TextLayoutInput textLayoutInput = textLayoutResult2.layoutInput;
                                textLayoutResult = new TextLayoutResult(new TextLayoutInput(textLayoutInput.text, TextStyle.m648mergedA7vx0o$default(textAnnotatedStringNode.style, Color.Unspecified, 0L, null, null, 0L, 0, 0L, 16777214), textLayoutInput.placeholders, textLayoutInput.maxLines, textLayoutInput.softWrap, textLayoutInput.overflow, textLayoutInput.density, textLayoutInput.layoutDirection, textLayoutInput.fontFamilyResolver, textLayoutInput.constraints), textLayoutResult2.multiParagraph, textLayoutResult2.size);
                                list.add(textLayoutResult);
                            } else {
                                textLayoutResult = null;
                            }
                            return Boolean.valueOf(textLayoutResult != null);
                        case 1:
                            AnnotatedString annotatedString = (AnnotatedString) obj;
                            TextAnnotatedStringNode textAnnotatedStringNode2 = this.f$0;
                            TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue = textAnnotatedStringNode2.textSubstitution;
                            EmptyList emptyList = EmptyList.INSTANCE;
                            if (textSubstitutionValue == null) {
                                TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue2 = new TextAnnotatedStringNode.TextSubstitutionValue(textAnnotatedStringNode2.text, annotatedString);
                                MultiParagraphLayoutCache multiParagraphLayoutCache = new MultiParagraphLayoutCache(annotatedString, textAnnotatedStringNode2.style, textAnnotatedStringNode2.fontFamilyResolver, textAnnotatedStringNode2.overflow, textAnnotatedStringNode2.softWrap, textAnnotatedStringNode2.maxLines, textAnnotatedStringNode2.minLines, emptyList);
                                multiParagraphLayoutCache.setDensity$foundation(textAnnotatedStringNode2.getLayoutCache().density);
                                textSubstitutionValue2.layoutCache = multiParagraphLayoutCache;
                                textAnnotatedStringNode2.textSubstitution = textSubstitutionValue2;
                            } else if (!Intrinsics.areEqual(annotatedString, textSubstitutionValue.substitution)) {
                                textSubstitutionValue.substitution = annotatedString;
                                MultiParagraphLayoutCache multiParagraphLayoutCache2 = textSubstitutionValue.layoutCache;
                                if (multiParagraphLayoutCache2 != null) {
                                    TextStyle textStyle = textAnnotatedStringNode2.style;
                                    FontFamily$Resolver fontFamily$Resolver = textAnnotatedStringNode2.fontFamilyResolver;
                                    int i2 = textAnnotatedStringNode2.overflow;
                                    boolean z2 = textAnnotatedStringNode2.softWrap;
                                    int i3 = textAnnotatedStringNode2.maxLines;
                                    int i4 = textAnnotatedStringNode2.minLines;
                                    multiParagraphLayoutCache2.text = annotatedString;
                                    boolean zHasSameLayoutAffectingAttributes = textStyle.hasSameLayoutAffectingAttributes(multiParagraphLayoutCache2.style);
                                    multiParagraphLayoutCache2.style = textStyle;
                                    if (!zHasSameLayoutAffectingAttributes) {
                                        multiParagraphLayoutCache2.historyFlag <<= 2;
                                        multiParagraphLayoutCache2.paragraphIntrinsics = null;
                                        multiParagraphLayoutCache2.layoutCache = null;
                                        multiParagraphLayoutCache2.cachedIntrinsicHeight = -1;
                                        multiParagraphLayoutCache2.cachedIntrinsicHeightInputWidth = -1;
                                    }
                                    multiParagraphLayoutCache2.fontFamilyResolver = fontFamily$Resolver;
                                    multiParagraphLayoutCache2.overflow = i2;
                                    multiParagraphLayoutCache2.softWrap = z2;
                                    multiParagraphLayoutCache2.maxLines = i3;
                                    multiParagraphLayoutCache2.minLines = i4;
                                    multiParagraphLayoutCache2.placeholders = emptyList;
                                    multiParagraphLayoutCache2.historyFlag = (multiParagraphLayoutCache2.historyFlag << 2) | 2;
                                    multiParagraphLayoutCache2.paragraphIntrinsics = null;
                                    multiParagraphLayoutCache2.layoutCache = null;
                                    multiParagraphLayoutCache2.cachedIntrinsicHeight = -1;
                                    multiParagraphLayoutCache2.cachedIntrinsicHeightInputWidth = -1;
                                }
                            }
                            HitTestResultKt.invalidateSemantics(textAnnotatedStringNode2);
                            HitTestResultKt.invalidateMeasurement(textAnnotatedStringNode2);
                            HitTestResultKt.invalidateDraw(textAnnotatedStringNode2);
                            return Boolean.TRUE;
                        default:
                            boolean zBooleanValue = ((Boolean) obj).booleanValue();
                            TextAnnotatedStringNode textAnnotatedStringNode3 = this.f$0;
                            TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue3 = textAnnotatedStringNode3.textSubstitution;
                            if (textSubstitutionValue3 == null) {
                                z = false;
                            } else {
                                if (textSubstitutionValue3 != null) {
                                    textSubstitutionValue3.isShowingSubstitution = zBooleanValue;
                                }
                                HitTestResultKt.invalidateSemantics(textAnnotatedStringNode3);
                                HitTestResultKt.invalidateMeasurement(textAnnotatedStringNode3);
                                HitTestResultKt.invalidateDraw(textAnnotatedStringNode3);
                                z = true;
                            }
                            return Boolean.valueOf(z);
                    }
                }
            };
            this.semanticsTextLayoutResult = r1;
            r0 = r1;
        }
        AnnotatedString annotatedString = this.text;
        KProperty[] kPropertyArr = SemanticsPropertiesKt.$$delegatedProperties;
        semanticsPropertyReceiver.set(SemanticsProperties.Text, Collections.singletonList(annotatedString));
        TextSubstitutionValue textSubstitutionValue = this.textSubstitution;
        if (textSubstitutionValue != null) {
            AnnotatedString annotatedString2 = textSubstitutionValue.substitution;
            SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.TextSubstitution;
            KProperty[] kPropertyArr2 = SemanticsPropertiesKt.$$delegatedProperties;
            KProperty kProperty = kPropertyArr2[16];
            semanticsPropertyReceiver.set(semanticsPropertyKey, annotatedString2);
            boolean z = textSubstitutionValue.isShowingSubstitution;
            SemanticsPropertyKey semanticsPropertyKey2 = SemanticsProperties.IsShowingTextSubstitution;
            KProperty kProperty2 = kPropertyArr2[17];
            semanticsPropertyReceiver.set(semanticsPropertyKey2, Boolean.valueOf(z));
        }
        final int i2 = 1;
        semanticsPropertyReceiver.set(SemanticsActions.SetTextSubstitution, new AccessibilityAction(null, new Function1(this) { // from class: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode$$ExternalSyntheticLambda1
            public final /* synthetic */ TextAnnotatedStringNode f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                TextLayoutResult textLayoutResult;
                boolean z2;
                switch (i2) {
                    case 0:
                        List list = (List) obj;
                        TextAnnotatedStringNode textAnnotatedStringNode = this.f$0;
                        TextLayoutResult textLayoutResult2 = textAnnotatedStringNode.getLayoutCache().layoutCache;
                        if (textLayoutResult2 != null) {
                            TextLayoutInput textLayoutInput = textLayoutResult2.layoutInput;
                            textLayoutResult = new TextLayoutResult(new TextLayoutInput(textLayoutInput.text, TextStyle.m648mergedA7vx0o$default(textAnnotatedStringNode.style, Color.Unspecified, 0L, null, null, 0L, 0, 0L, 16777214), textLayoutInput.placeholders, textLayoutInput.maxLines, textLayoutInput.softWrap, textLayoutInput.overflow, textLayoutInput.density, textLayoutInput.layoutDirection, textLayoutInput.fontFamilyResolver, textLayoutInput.constraints), textLayoutResult2.multiParagraph, textLayoutResult2.size);
                            list.add(textLayoutResult);
                        } else {
                            textLayoutResult = null;
                        }
                        return Boolean.valueOf(textLayoutResult != null);
                    case 1:
                        AnnotatedString annotatedString3 = (AnnotatedString) obj;
                        TextAnnotatedStringNode textAnnotatedStringNode2 = this.f$0;
                        TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue2 = textAnnotatedStringNode2.textSubstitution;
                        EmptyList emptyList = EmptyList.INSTANCE;
                        if (textSubstitutionValue2 == null) {
                            TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue3 = new TextAnnotatedStringNode.TextSubstitutionValue(textAnnotatedStringNode2.text, annotatedString3);
                            MultiParagraphLayoutCache multiParagraphLayoutCache = new MultiParagraphLayoutCache(annotatedString3, textAnnotatedStringNode2.style, textAnnotatedStringNode2.fontFamilyResolver, textAnnotatedStringNode2.overflow, textAnnotatedStringNode2.softWrap, textAnnotatedStringNode2.maxLines, textAnnotatedStringNode2.minLines, emptyList);
                            multiParagraphLayoutCache.setDensity$foundation(textAnnotatedStringNode2.getLayoutCache().density);
                            textSubstitutionValue3.layoutCache = multiParagraphLayoutCache;
                            textAnnotatedStringNode2.textSubstitution = textSubstitutionValue3;
                        } else if (!Intrinsics.areEqual(annotatedString3, textSubstitutionValue2.substitution)) {
                            textSubstitutionValue2.substitution = annotatedString3;
                            MultiParagraphLayoutCache multiParagraphLayoutCache2 = textSubstitutionValue2.layoutCache;
                            if (multiParagraphLayoutCache2 != null) {
                                TextStyle textStyle = textAnnotatedStringNode2.style;
                                FontFamily$Resolver fontFamily$Resolver = textAnnotatedStringNode2.fontFamilyResolver;
                                int i3 = textAnnotatedStringNode2.overflow;
                                boolean z3 = textAnnotatedStringNode2.softWrap;
                                int i4 = textAnnotatedStringNode2.maxLines;
                                int i5 = textAnnotatedStringNode2.minLines;
                                multiParagraphLayoutCache2.text = annotatedString3;
                                boolean zHasSameLayoutAffectingAttributes = textStyle.hasSameLayoutAffectingAttributes(multiParagraphLayoutCache2.style);
                                multiParagraphLayoutCache2.style = textStyle;
                                if (!zHasSameLayoutAffectingAttributes) {
                                    multiParagraphLayoutCache2.historyFlag <<= 2;
                                    multiParagraphLayoutCache2.paragraphIntrinsics = null;
                                    multiParagraphLayoutCache2.layoutCache = null;
                                    multiParagraphLayoutCache2.cachedIntrinsicHeight = -1;
                                    multiParagraphLayoutCache2.cachedIntrinsicHeightInputWidth = -1;
                                }
                                multiParagraphLayoutCache2.fontFamilyResolver = fontFamily$Resolver;
                                multiParagraphLayoutCache2.overflow = i3;
                                multiParagraphLayoutCache2.softWrap = z3;
                                multiParagraphLayoutCache2.maxLines = i4;
                                multiParagraphLayoutCache2.minLines = i5;
                                multiParagraphLayoutCache2.placeholders = emptyList;
                                multiParagraphLayoutCache2.historyFlag = (multiParagraphLayoutCache2.historyFlag << 2) | 2;
                                multiParagraphLayoutCache2.paragraphIntrinsics = null;
                                multiParagraphLayoutCache2.layoutCache = null;
                                multiParagraphLayoutCache2.cachedIntrinsicHeight = -1;
                                multiParagraphLayoutCache2.cachedIntrinsicHeightInputWidth = -1;
                            }
                        }
                        HitTestResultKt.invalidateSemantics(textAnnotatedStringNode2);
                        HitTestResultKt.invalidateMeasurement(textAnnotatedStringNode2);
                        HitTestResultKt.invalidateDraw(textAnnotatedStringNode2);
                        return Boolean.TRUE;
                    default:
                        boolean zBooleanValue = ((Boolean) obj).booleanValue();
                        TextAnnotatedStringNode textAnnotatedStringNode3 = this.f$0;
                        TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue4 = textAnnotatedStringNode3.textSubstitution;
                        if (textSubstitutionValue4 == null) {
                            z2 = false;
                        } else {
                            if (textSubstitutionValue4 != null) {
                                textSubstitutionValue4.isShowingSubstitution = zBooleanValue;
                            }
                            HitTestResultKt.invalidateSemantics(textAnnotatedStringNode3);
                            HitTestResultKt.invalidateMeasurement(textAnnotatedStringNode3);
                            HitTestResultKt.invalidateDraw(textAnnotatedStringNode3);
                            z2 = true;
                        }
                        return Boolean.valueOf(z2);
                }
            }
        }));
        final int i3 = 2;
        semanticsPropertyReceiver.set(SemanticsActions.ShowTextSubstitution, new AccessibilityAction(null, new Function1(this) { // from class: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode$$ExternalSyntheticLambda1
            public final /* synthetic */ TextAnnotatedStringNode f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                TextLayoutResult textLayoutResult;
                boolean z2;
                switch (i3) {
                    case 0:
                        List list = (List) obj;
                        TextAnnotatedStringNode textAnnotatedStringNode = this.f$0;
                        TextLayoutResult textLayoutResult2 = textAnnotatedStringNode.getLayoutCache().layoutCache;
                        if (textLayoutResult2 != null) {
                            TextLayoutInput textLayoutInput = textLayoutResult2.layoutInput;
                            textLayoutResult = new TextLayoutResult(new TextLayoutInput(textLayoutInput.text, TextStyle.m648mergedA7vx0o$default(textAnnotatedStringNode.style, Color.Unspecified, 0L, null, null, 0L, 0, 0L, 16777214), textLayoutInput.placeholders, textLayoutInput.maxLines, textLayoutInput.softWrap, textLayoutInput.overflow, textLayoutInput.density, textLayoutInput.layoutDirection, textLayoutInput.fontFamilyResolver, textLayoutInput.constraints), textLayoutResult2.multiParagraph, textLayoutResult2.size);
                            list.add(textLayoutResult);
                        } else {
                            textLayoutResult = null;
                        }
                        return Boolean.valueOf(textLayoutResult != null);
                    case 1:
                        AnnotatedString annotatedString3 = (AnnotatedString) obj;
                        TextAnnotatedStringNode textAnnotatedStringNode2 = this.f$0;
                        TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue2 = textAnnotatedStringNode2.textSubstitution;
                        EmptyList emptyList = EmptyList.INSTANCE;
                        if (textSubstitutionValue2 == null) {
                            TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue3 = new TextAnnotatedStringNode.TextSubstitutionValue(textAnnotatedStringNode2.text, annotatedString3);
                            MultiParagraphLayoutCache multiParagraphLayoutCache = new MultiParagraphLayoutCache(annotatedString3, textAnnotatedStringNode2.style, textAnnotatedStringNode2.fontFamilyResolver, textAnnotatedStringNode2.overflow, textAnnotatedStringNode2.softWrap, textAnnotatedStringNode2.maxLines, textAnnotatedStringNode2.minLines, emptyList);
                            multiParagraphLayoutCache.setDensity$foundation(textAnnotatedStringNode2.getLayoutCache().density);
                            textSubstitutionValue3.layoutCache = multiParagraphLayoutCache;
                            textAnnotatedStringNode2.textSubstitution = textSubstitutionValue3;
                        } else if (!Intrinsics.areEqual(annotatedString3, textSubstitutionValue2.substitution)) {
                            textSubstitutionValue2.substitution = annotatedString3;
                            MultiParagraphLayoutCache multiParagraphLayoutCache2 = textSubstitutionValue2.layoutCache;
                            if (multiParagraphLayoutCache2 != null) {
                                TextStyle textStyle = textAnnotatedStringNode2.style;
                                FontFamily$Resolver fontFamily$Resolver = textAnnotatedStringNode2.fontFamilyResolver;
                                int i4 = textAnnotatedStringNode2.overflow;
                                boolean z3 = textAnnotatedStringNode2.softWrap;
                                int i5 = textAnnotatedStringNode2.maxLines;
                                int i6 = textAnnotatedStringNode2.minLines;
                                multiParagraphLayoutCache2.text = annotatedString3;
                                boolean zHasSameLayoutAffectingAttributes = textStyle.hasSameLayoutAffectingAttributes(multiParagraphLayoutCache2.style);
                                multiParagraphLayoutCache2.style = textStyle;
                                if (!zHasSameLayoutAffectingAttributes) {
                                    multiParagraphLayoutCache2.historyFlag <<= 2;
                                    multiParagraphLayoutCache2.paragraphIntrinsics = null;
                                    multiParagraphLayoutCache2.layoutCache = null;
                                    multiParagraphLayoutCache2.cachedIntrinsicHeight = -1;
                                    multiParagraphLayoutCache2.cachedIntrinsicHeightInputWidth = -1;
                                }
                                multiParagraphLayoutCache2.fontFamilyResolver = fontFamily$Resolver;
                                multiParagraphLayoutCache2.overflow = i4;
                                multiParagraphLayoutCache2.softWrap = z3;
                                multiParagraphLayoutCache2.maxLines = i5;
                                multiParagraphLayoutCache2.minLines = i6;
                                multiParagraphLayoutCache2.placeholders = emptyList;
                                multiParagraphLayoutCache2.historyFlag = (multiParagraphLayoutCache2.historyFlag << 2) | 2;
                                multiParagraphLayoutCache2.paragraphIntrinsics = null;
                                multiParagraphLayoutCache2.layoutCache = null;
                                multiParagraphLayoutCache2.cachedIntrinsicHeight = -1;
                                multiParagraphLayoutCache2.cachedIntrinsicHeightInputWidth = -1;
                            }
                        }
                        HitTestResultKt.invalidateSemantics(textAnnotatedStringNode2);
                        HitTestResultKt.invalidateMeasurement(textAnnotatedStringNode2);
                        HitTestResultKt.invalidateDraw(textAnnotatedStringNode2);
                        return Boolean.TRUE;
                    default:
                        boolean zBooleanValue = ((Boolean) obj).booleanValue();
                        TextAnnotatedStringNode textAnnotatedStringNode3 = this.f$0;
                        TextAnnotatedStringNode.TextSubstitutionValue textSubstitutionValue4 = textAnnotatedStringNode3.textSubstitution;
                        if (textSubstitutionValue4 == null) {
                            z2 = false;
                        } else {
                            if (textSubstitutionValue4 != null) {
                                textSubstitutionValue4.isShowingSubstitution = zBooleanValue;
                            }
                            HitTestResultKt.invalidateSemantics(textAnnotatedStringNode3);
                            HitTestResultKt.invalidateMeasurement(textAnnotatedStringNode3);
                            HitTestResultKt.invalidateDraw(textAnnotatedStringNode3);
                            z2 = true;
                        }
                        return Boolean.valueOf(z2);
                }
            }
        }));
        semanticsPropertyReceiver.set(SemanticsActions.ClearTextSubstitution, new AccessibilityAction(null, new BasicTextKt$$ExternalSyntheticLambda0(17, this)));
        semanticsPropertyReceiver.set(SemanticsActions.GetTextLayoutResult, new AccessibilityAction(null, r0));
    }

    public final void doInvalidations(boolean z, boolean z2, boolean z3, boolean z4) {
        if (z2 || z3 || z4) {
            MultiParagraphLayoutCache layoutCache = getLayoutCache();
            AnnotatedString annotatedString = this.text;
            TextStyle textStyle = this.style;
            FontFamily$Resolver fontFamily$Resolver = this.fontFamilyResolver;
            int i = this.overflow;
            boolean z5 = this.softWrap;
            int i2 = this.maxLines;
            int i3 = this.minLines;
            layoutCache.text = annotatedString;
            boolean zHasSameLayoutAffectingAttributes = textStyle.hasSameLayoutAffectingAttributes(layoutCache.style);
            layoutCache.style = textStyle;
            if (!zHasSameLayoutAffectingAttributes) {
                layoutCache.historyFlag <<= 2;
                layoutCache.paragraphIntrinsics = null;
                layoutCache.layoutCache = null;
                layoutCache.cachedIntrinsicHeight = -1;
                layoutCache.cachedIntrinsicHeightInputWidth = -1;
            }
            layoutCache.fontFamilyResolver = fontFamily$Resolver;
            layoutCache.overflow = i;
            layoutCache.softWrap = z5;
            layoutCache.maxLines = i2;
            layoutCache.minLines = i3;
            layoutCache.placeholders = null;
            layoutCache.historyFlag = (layoutCache.historyFlag << 2) | 2;
            layoutCache.paragraphIntrinsics = null;
            layoutCache.layoutCache = null;
            layoutCache.cachedIntrinsicHeight = -1;
            layoutCache.cachedIntrinsicHeightInputWidth = -1;
        }
        if (this.isAttached) {
            if (z2 || (z && this.semanticsTextLayoutResult != null)) {
                HitTestResultKt.invalidateSemantics(this);
            }
            if (z2 || z3 || z4) {
                HitTestResultKt.invalidateMeasurement(this);
                HitTestResultKt.invalidateDraw(this);
            }
            if (z) {
                HitTestResultKt.invalidateDraw(this);
            }
        }
    }

    /* JADX WARN: Failed to calculate best type for var: r6v13 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v13 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r6v13 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v13 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r6v14 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v14 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r8v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r8v1 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v13 ??, new type: long
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    @Override // androidx.compose.ui.node.DrawModifierNode
    public final void draw(androidx.compose.ui.node.LayoutNodeDrawScope r27) {
        /*
            Method dump skipped, instruction units count: 476
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.modifiers.TextAnnotatedStringNode.draw(androidx.compose.ui.node.LayoutNodeDrawScope):void");
    }

    public final MultiParagraphLayoutCache getLayoutCache() {
        if (this._layoutCache == null) {
            this._layoutCache = new MultiParagraphLayoutCache(this.text, this.style, this.fontFamilyResolver, this.overflow, this.softWrap, this.maxLines, this.minLines, null);
        }
        return this._layoutCache;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public final boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final /* synthetic */ boolean getShouldClearDescendantSemantics() {
        return false;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final /* synthetic */ boolean getShouldMergeDescendantSemantics() {
        return false;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public final /* synthetic */ boolean isImportantForBounds() {
        return true;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return getLayoutCache(lookaheadCapablePlaceable).intrinsicHeight(i, lookaheadCapablePlaceable.getLayoutDirection());
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int maxIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return BasicTextKt.ceilToIntPx(getLayoutCache(lookaheadCapablePlaceable).setLayoutDirection(lookaheadCapablePlaceable.getLayoutDirection()).getMaxIntrinsicWidth());
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public final MeasureResult mo25measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        Trace.beginSection("TextAnnotatedStringNode:measure");
        try {
            MultiParagraphLayoutCache layoutCache = getLayoutCache(measureScope);
            boolean zM203layoutWithConstraintsK40F9xA = layoutCache.m203layoutWithConstraintsK40F9xA(j, measureScope.getLayoutDirection());
            TextLayoutResult textLayoutResult = layoutCache.layoutCache;
            if (textLayoutResult == null) {
                throw new IllegalStateException("Internal Error: MultiParagraphLayoutCache could not provide TextLayoutResult during the draw phase. Please report this bug on the official Issue Tracker with the following diagnostic information: " + layoutCache);
            }
            long j2 = textLayoutResult.size;
            textLayoutResult.multiParagraph.intrinsics.getHasStaleResolvedFonts();
            if (zM203layoutWithConstraintsK40F9xA) {
                HitTestResultKt.invalidateLayer(this);
                Function1 function1 = this.onTextLayout;
                if (function1 != null) {
                    function1.invoke(textLayoutResult);
                }
                SelectionController selectionController = this.selectionController;
                if (selectionController != null) {
                    selectionController.updateTextLayout(textLayoutResult);
                }
                Map linkedHashMap = this.baselineCache;
                if (linkedHashMap == null) {
                    linkedHashMap = new LinkedHashMap(2);
                }
                linkedHashMap.put(AlignmentLineKt.FirstBaseline, Integer.valueOf(Math.round(textLayoutResult.firstBaseline)));
                linkedHashMap.put(AlignmentLineKt.LastBaseline, Integer.valueOf(Math.round(textLayoutResult.lastBaseline)));
                this.baselineCache = linkedHashMap;
            }
            int i = (int) (j2 >> 32);
            int i2 = (int) (j2 & 4294967295L);
            MeasureResult measureResultLayout = measureScope.layout(i, i2, this.baselineCache, new ContentPainterNode$$ExternalSyntheticLambda0(measurable.mo517measureBRTryo0(Constraints.Companion.m688fitPrioritizingWidthZbe2FdA(i, i, i2, i2)), 9));
            Trace.endSection();
            return measureResultLayout;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicHeight(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return getLayoutCache(lookaheadCapablePlaceable).intrinsicHeight(i, lookaheadCapablePlaceable.getLayoutDirection());
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final int minIntrinsicWidth(LookaheadCapablePlaceable lookaheadCapablePlaceable, Measurable measurable, int i) {
        return BasicTextKt.ceilToIntPx(getLayoutCache(lookaheadCapablePlaceable).setLayoutDirection(lookaheadCapablePlaceable.getLayoutDirection()).getMinIntrinsicWidth());
    }

    public final boolean updateCallbacks(Function1 function1, SelectionController selectionController) {
        boolean z;
        if (this.onTextLayout != function1) {
            this.onTextLayout = function1;
            z = true;
        } else {
            z = false;
        }
        if (Intrinsics.areEqual(this.selectionController, selectionController)) {
            return z;
        }
        this.selectionController = selectionController;
        return true;
    }

    /* JADX INFO: renamed from: updateLayoutRelatedArgs-y0k-MQk, reason: not valid java name */
    public final boolean m211updateLayoutRelatedArgsy0kMQk(TextStyle textStyle, int i, int i2, boolean z, FontFamily$Resolver fontFamily$Resolver, int i3) {
        boolean z2 = !this.style.hasSameLayoutAffectingAttributes(textStyle);
        this.style = textStyle;
        if (this.minLines != i) {
            this.minLines = i;
            z2 = true;
        }
        if (this.maxLines != i2) {
            this.maxLines = i2;
            z2 = true;
        }
        if (this.softWrap != z) {
            this.softWrap = z;
            z2 = true;
        }
        if (!Intrinsics.areEqual(this.fontFamilyResolver, fontFamily$Resolver)) {
            this.fontFamilyResolver = fontFamily$Resolver;
            z2 = true;
        }
        if (this.overflow == i3) {
            return z2;
        }
        this.overflow = i3;
        return true;
    }

    public final boolean updateText$foundation(AnnotatedString annotatedString) {
        boolean zAreEqual = Intrinsics.areEqual(this.text.text, annotatedString.text);
        boolean z = (zAreEqual && Intrinsics.areEqual(this.text.annotations, annotatedString.annotations)) ? false : true;
        if (z) {
            this.text = annotatedString;
        }
        if (!zAreEqual) {
            this.textSubstitution = null;
        }
        return z;
    }

    public final MultiParagraphLayoutCache getLayoutCache(Density density) {
        MultiParagraphLayoutCache multiParagraphLayoutCache;
        TextSubstitutionValue textSubstitutionValue = this.textSubstitution;
        if (textSubstitutionValue != null && textSubstitutionValue.isShowingSubstitution && (multiParagraphLayoutCache = textSubstitutionValue.layoutCache) != null) {
            multiParagraphLayoutCache.setDensity$foundation(density);
            return multiParagraphLayoutCache;
        }
        MultiParagraphLayoutCache layoutCache = getLayoutCache();
        layoutCache.setDensity$foundation(density);
        return layoutCache;
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final /* synthetic */ void onMeasureResultChanged() {
    }
}
