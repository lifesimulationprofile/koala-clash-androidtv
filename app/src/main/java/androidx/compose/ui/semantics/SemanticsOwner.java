package androidx.compose.ui.semantics;

import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import androidx.collection.IntObjectMap;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableObjectList;
import androidx.compose.ui.autofill.AndroidAutofillManager;
import androidx.compose.ui.autofill.AndroidContentDataType;
import androidx.compose.ui.autofill.AndroidFillableData;
import androidx.compose.ui.autofill.ContentDataType$Companion;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import coil.request.Parameters;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SemanticsOwner {
    public final MutableObjectList listeners = new MutableObjectList(2);
    public final IntObjectMap nodes;
    public final EmptySemanticsModifier outerSemanticsNode;
    public final LayoutNode rootNode;

    public SemanticsOwner(LayoutNode layoutNode, EmptySemanticsModifier emptySemanticsModifier, MutableIntObjectMap mutableIntObjectMap) {
        this.rootNode = layoutNode;
        this.outerSemanticsNode = emptySemanticsModifier;
        this.nodes = mutableIntObjectMap;
    }

    public final SemanticsNode getUnmergedRootSemanticsNode() {
        return new SemanticsNode(this.outerSemanticsNode, false, this.rootNode, new SemanticsConfiguration());
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0034  */
    /* JADX WARN: Code duplicated, block: B:20:0x0049  */
    public final void notifySemanticsChange$ui(LayoutNode layoutNode, SemanticsConfiguration semanticsConfiguration) {
        String str;
        String strTake;
        ToggleableState toggleableState;
        ToggleableState toggleableState2;
        AndroidFillableData androidFillableData;
        AndroidFillableData androidFillableData2;
        MutableObjectList mutableObjectList = this.listeners;
        Object[] objArr = mutableObjectList.content;
        int i = mutableObjectList._size;
        for (int i2 = 0; i2 < i; i2++) {
            AndroidAutofillManager androidAutofillManager = (AndroidAutofillManager) objArr[i2];
            MutableIntSet mutableIntSet = androidAutofillManager.currentlyDisplayedIDs;
            AndroidComposeView androidComposeView = androidAutofillManager.view;
            Parameters.Builder builder = androidAutofillManager.platformAutofillManager;
            SemanticsConfiguration semanticsConfiguration2 = layoutNode.getSemanticsConfiguration();
            int i3 = layoutNode.semanticsId;
            if (semanticsConfiguration != null) {
                Object obj = semanticsConfiguration.props.get(SemanticsProperties.InputText);
                if (obj == null) {
                    obj = null;
                }
                AnnotatedString annotatedString = (AnnotatedString) obj;
                if (annotatedString != null) {
                    str = annotatedString.text;
                } else {
                    str = null;
                }
            } else {
                str = null;
            }
            if (semanticsConfiguration2 != null) {
                Object obj2 = semanticsConfiguration2.props.get(SemanticsProperties.InputText);
                if (obj2 == null) {
                    obj2 = null;
                }
                AnnotatedString annotatedString2 = (AnnotatedString) obj2;
                if (annotatedString2 != null) {
                    strTake = annotatedString2.text;
                } else {
                    strTake = null;
                }
            } else {
                strTake = null;
            }
            if (str != strTake) {
                if (str == null) {
                    builder.notifyViewVisibilityChanged(androidComposeView, i3, true);
                } else if (strTake == null) {
                    builder.notifyViewVisibilityChanged(androidComposeView, i3, false);
                } else if (Intrinsics.areEqual((AndroidContentDataType) SemanticsNodeKt.getOrNull(semanticsConfiguration2, SemanticsProperties.ContentDataType), ContentDataType$Companion.Text)) {
                    if (strTake.length() >= 5000) {
                        strTake = (Character.isHighSurrogate(strTake.charAt(4999)) && Character.isLowSurrogate(strTake.charAt(5000))) ? StringsKt.take(strTake, 4999) : StringsKt.take(strTake, 5000);
                    }
                    ((AutofillManager) builder.entries).notifyValueChanged(androidComposeView, i3, AutofillValue.forText(strTake));
                }
            }
            if (semanticsConfiguration != null) {
                Object obj3 = semanticsConfiguration.props.get(SemanticsProperties.ToggleableState);
                if (obj3 == null) {
                    obj3 = null;
                }
                toggleableState = (ToggleableState) obj3;
            } else {
                toggleableState = null;
            }
            if (semanticsConfiguration2 != null) {
                Object obj4 = semanticsConfiguration2.props.get(SemanticsProperties.ToggleableState);
                if (obj4 == null) {
                    obj4 = null;
                }
                toggleableState2 = (ToggleableState) obj4;
            } else {
                toggleableState2 = null;
            }
            if (toggleableState != toggleableState2) {
                if (toggleableState == null) {
                    builder.notifyViewVisibilityChanged(androidComposeView, i3, true);
                } else if (toggleableState2 == null) {
                    builder.notifyViewVisibilityChanged(androidComposeView, i3, false);
                } else if (Intrinsics.areEqual((AndroidContentDataType) SemanticsNodeKt.getOrNull(semanticsConfiguration2, SemanticsProperties.ContentDataType), ContentDataType$Companion.Toggle)) {
                    int iOrdinal = toggleableState2.ordinal();
                    Boolean bool = iOrdinal != 0 ? iOrdinal != 1 ? null : Boolean.FALSE : Boolean.TRUE;
                    if (bool != null) {
                        ((AutofillManager) builder.entries).notifyValueChanged(androidComposeView, i3, AutofillValue.forToggle(bool.booleanValue()));
                    }
                }
            }
            if (semanticsConfiguration != null) {
                Object obj5 = semanticsConfiguration.props.get(SemanticsProperties.FillableData);
                if (obj5 == null) {
                    obj5 = null;
                }
                androidFillableData = (AndroidFillableData) obj5;
            } else {
                androidFillableData = null;
            }
            if (semanticsConfiguration2 != null) {
                Object obj6 = semanticsConfiguration2.props.get(SemanticsProperties.FillableData);
                if (obj6 == null) {
                    obj6 = null;
                }
                androidFillableData2 = (AndroidFillableData) obj6;
            } else {
                androidFillableData2 = null;
            }
            if (!Intrinsics.areEqual(androidFillableData, androidFillableData2)) {
                if (androidFillableData == null) {
                    builder.notifyViewVisibilityChanged(androidComposeView, i3, true);
                } else if (androidFillableData2 == null) {
                    builder.notifyViewVisibilityChanged(androidComposeView, i3, false);
                } else {
                    ((AutofillManager) builder.entries).notifyValueChanged(androidComposeView, i3, androidFillableData2.autofillValue);
                }
            }
            boolean z = semanticsConfiguration != null && semanticsConfiguration.props.contains(SemanticsProperties.ContentType);
            boolean z2 = semanticsConfiguration2 != null && semanticsConfiguration2.props.contains(SemanticsProperties.ContentType);
            if (z != z2) {
                if (z2) {
                    mutableIntSet.add(i3);
                } else {
                    mutableIntSet.remove(i3);
                }
            }
        }
    }
}
