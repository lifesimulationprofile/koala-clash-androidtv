package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Build;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.autofill.AndroidContentDataType;
import androidx.compose.ui.autofill.AndroidContentType;
import androidx.compose.ui.autofill.AndroidFillableData;
import androidx.compose.ui.autofill.ContentType;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.platform.InvertMatrixKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.spatial.RectManager;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class zzss {
    /* JADX WARN: Code duplicated, block: B:120:0x0287  */
    /* JADX WARN: Code duplicated, block: B:122:0x028a  */
    /* JADX WARN: Code duplicated, block: B:124:0x0291  */
    /* JADX WARN: Code duplicated, block: B:127:0x029e  */
    /* JADX WARN: Code duplicated, block: B:128:0x02a5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:129:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:130:0x02ac A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:131:0x02ae  */
    /* JADX WARN: Code duplicated, block: B:132:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:134:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:136:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:139:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:144:0x02e5  */
    /* JADX WARN: Code duplicated, block: B:147:0x02f2  */
    /* JADX WARN: Code duplicated, block: B:154:0x031f  */
    /* JADX WARN: Code duplicated, block: B:157:0x0329  */
    /* JADX WARN: Code duplicated, block: B:159:0x0332  */
    /* JADX WARN: Code duplicated, block: B:160:0x0334  */
    /* JADX WARN: Code duplicated, block: B:162:0x0339  */
    /* JADX WARN: Code duplicated, block: B:171:0x0365  */
    /* JADX WARN: Code duplicated, block: B:179:0x0386  */
    /* JADX WARN: Code duplicated, block: B:181:0x038a A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:184:0x038f  */
    /* JADX WARN: Code duplicated, block: B:186:0x0392 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:189:0x0397  */
    /* JADX WARN: Code duplicated, block: B:193:0x03a8  */
    /* JADX WARN: Code duplicated, block: B:196:0x03ae  */
    /* JADX WARN: Code duplicated, block: B:198:0x03b6 A[LOOP:5: B:197:0x03b4->B:198:0x03b6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:202:0x03e3 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:207:0x03f2  */
    /* JADX WARN: Code duplicated, block: B:209:0x03fd A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:212:0x0408  */
    /* JADX WARN: Code duplicated, block: B:214:0x040c  */
    /* JADX WARN: Code duplicated, block: B:217:0x0175 A[EDGE_INSN: B:217:0x0175->B:70:0x0175 BREAK  A[LOOP:0: B:9:0x003e->B:68:0x0153], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:255:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:256:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:0x0151 A[DONT_INVERT, PHI: r6 r20 r21 r22 r23 r24 r25 r26 r27 r28 r29
      0x0151: PHI (r6v16 androidx.compose.ui.autofill.AndroidContentDataType) = 
      (r6v15 androidx.compose.ui.autofill.AndroidContentDataType)
      (r6v17 androidx.compose.ui.autofill.AndroidContentDataType)
     binds: [B:10:0x004d, B:66:0x014f] A[DONT_GENERATE, DONT_INLINE]
      0x0151: PHI (r20v6 boolean) = (r20v5 boolean), (r20v7 boolean) binds: [B:10:0x004d, B:66:0x014f] A[DONT_GENERATE, DONT_INLINE]
      0x0151: PHI (r21v8 androidx.compose.ui.state.ToggleableState) = (r21v7 androidx.compose.ui.state.ToggleableState), (r21v9 androidx.compose.ui.state.ToggleableState) binds: [B:10:0x004d, B:66:0x014f] A[DONT_GENERATE, DONT_INLINE]
      0x0151: PHI (r22v5 androidx.compose.ui.text.AnnotatedString) = (r22v4 androidx.compose.ui.text.AnnotatedString), (r22v6 androidx.compose.ui.text.AnnotatedString) binds: [B:10:0x004d, B:66:0x014f] A[DONT_GENERATE, DONT_INLINE]
      0x0151: PHI (r23v5 androidx.compose.ui.autofill.AndroidFillableData) = (r23v4 androidx.compose.ui.autofill.AndroidFillableData), (r23v6 androidx.compose.ui.autofill.AndroidFillableData) binds: [B:10:0x004d, B:66:0x014f] A[DONT_GENERATE, DONT_INLINE]
      0x0151: PHI (r24v6 androidx.compose.ui.autofill.ContentType) = (r24v5 androidx.compose.ui.autofill.ContentType), (r24v7 androidx.compose.ui.autofill.ContentType) binds: [B:10:0x004d, B:66:0x014f] A[DONT_GENERATE, DONT_INLINE]
      0x0151: PHI (r25v6 java.lang.Boolean) = (r25v5 java.lang.Boolean), (r25v7 java.lang.Boolean) binds: [B:10:0x004d, B:66:0x014f] A[DONT_GENERATE, DONT_INLINE]
      0x0151: PHI (r26v8 androidx.compose.ui.semantics.Role) = (r26v7 androidx.compose.ui.semantics.Role), (r26v9 androidx.compose.ui.semantics.Role) binds: [B:10:0x004d, B:66:0x014f] A[DONT_GENERATE, DONT_INLINE]
      0x0151: PHI (r27v6 boolean) = (r27v5 boolean), (r27v7 boolean) binds: [B:10:0x004d, B:66:0x014f] A[DONT_GENERATE, DONT_INLINE]
      0x0151: PHI (r28v6 boolean) = (r28v5 boolean), (r28v7 boolean) binds: [B:10:0x004d, B:66:0x014f] A[DONT_GENERATE, DONT_INLINE]
      0x0151: PHI (r29v6 java.lang.Integer) = (r29v5 java.lang.Integer), (r29v7 java.lang.Integer) binds: [B:10:0x004d, B:66:0x014f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:68:0x0153 A[LOOP:0: B:9:0x003e->B:68:0x0153, LOOP_END] */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void populate(final ViewStructure viewStructure, LayoutNode layoutNode, AutofillId autofillId, String str, RectManager rectManager) {
        long j;
        long j2;
        char c;
        long j3;
        boolean zBooleanValue;
        ToggleableState toggleableState;
        AnnotatedString annotatedString;
        AndroidFillableData androidFillableData;
        Role role;
        AndroidContentDataType androidContentDataType;
        boolean z;
        ContentType contentType;
        Boolean bool;
        boolean z2;
        Integer num;
        int i;
        List list;
        Integer numValueOf;
        int iIntValue;
        Integer numValueOf2;
        int i2;
        String[] strArr;
        boolean z3;
        boolean z4;
        boolean z5;
        String strM614toLegacyClassNameV4PA4sw;
        int size;
        String strM;
        String[] strArr2;
        boolean z6;
        String[] strArr3;
        String strTake;
        MutableScatterMap mutableScatterMap;
        long[] jArr;
        Object[] objArr;
        int i3;
        long[] jArr2;
        Object[] objArr2;
        MutableScatterMap mutableScatterMap2;
        ToggleableState toggleableState2;
        AnnotatedString annotatedString2;
        AndroidFillableData androidFillableData2;
        Role role2;
        SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.ContentDescription;
        SemanticsPropertyKey semanticsPropertyKey2 = SemanticsActions.GetTextLayoutResult;
        SemanticsConfiguration semanticsConfiguration = layoutNode.getSemanticsConfiguration();
        int i4 = 8;
        if (semanticsConfiguration == null || (mutableScatterMap2 = semanticsConfiguration.props) == null) {
            j = 128;
            j2 = 255;
            c = 7;
            j3 = -9187201950435737472L;
            zBooleanValue = true;
            toggleableState = null;
            annotatedString = null;
            androidFillableData = null;
            role = null;
            androidContentDataType = null;
            z = false;
            contentType = null;
            bool = null;
            z2 = false;
            num = null;
        } else {
            Object[] objArr3 = mutableScatterMap2.keys;
            j = 128;
            Object[] objArr4 = mutableScatterMap2.values;
            long[] jArr3 = mutableScatterMap2.metadata;
            int length = jArr3.length - 2;
            if (length >= 0) {
                zBooleanValue = true;
                int i5 = 0;
                androidContentDataType = null;
                j2 = 255;
                z = false;
                toggleableState2 = null;
                annotatedString2 = null;
                androidFillableData2 = null;
                contentType = null;
                bool = null;
                role2 = null;
                z2 = false;
                num = null;
                c = 7;
                while (true) {
                    long j4 = jArr3[i5];
                    j3 = -9187201950435737472L;
                    if ((((~j4) << 7) & j4 & (-9187201950435737472L)) == -9187201950435737472L) {
                        if (i5 != length) {
                            break;
                            break;
                        }
                        i5++;
                    } else {
                        int i6 = 8 - ((~(i5 - length)) >>> 31);
                        for (int i7 = 0; i7 < i6; i7++) {
                            if ((j4 & 255) < 128) {
                                int i8 = (i5 << 3) + i7;
                                Object obj = objArr3[i8];
                                Object obj2 = objArr4[i8];
                                SemanticsPropertyKey semanticsPropertyKey3 = (SemanticsPropertyKey) obj;
                                if (Intrinsics.areEqual(semanticsPropertyKey3, SemanticsProperties.ContentDataType)) {
                                    androidContentDataType = (AndroidContentDataType) obj2;
                                } else if (Intrinsics.areEqual(semanticsPropertyKey3, SemanticsProperties.ContentDescription)) {
                                    CharSequence charSequence = (String) CollectionsKt.firstOrNull((List) obj2);
                                    if (charSequence != null) {
                                        viewStructure.setContentDescription(charSequence);
                                    }
                                } else if (Intrinsics.areEqual(semanticsPropertyKey3, SemanticsProperties.ContentType)) {
                                    contentType = (ContentType) obj2;
                                } else if (Intrinsics.areEqual(semanticsPropertyKey3, SemanticsProperties.FillableData)) {
                                    androidFillableData2 = (AndroidFillableData) obj2;
                                } else if (Intrinsics.areEqual(semanticsPropertyKey3, SemanticsProperties.EditableText)) {
                                    annotatedString2 = (AnnotatedString) obj2;
                                } else if (Intrinsics.areEqual(semanticsPropertyKey3, SemanticsProperties.Focused)) {
                                    viewStructure.setFocused(((Boolean) obj2).booleanValue());
                                } else if (Intrinsics.areEqual(semanticsPropertyKey3, SemanticsProperties.MaxTextLength)) {
                                    num = (Integer) obj2;
                                } else if (Intrinsics.areEqual(semanticsPropertyKey3, SemanticsProperties.Password)) {
                                    z2 = true;
                                } else if (Intrinsics.areEqual(semanticsPropertyKey3, SemanticsProperties.IsSensitiveData)) {
                                    zBooleanValue = ((Boolean) obj2).booleanValue();
                                } else if (Intrinsics.areEqual(semanticsPropertyKey3, SemanticsProperties.Role)) {
                                    role2 = (Role) obj2;
                                } else if (Intrinsics.areEqual(semanticsPropertyKey3, SemanticsProperties.Selected)) {
                                    bool = (Boolean) obj2;
                                } else if (Intrinsics.areEqual(semanticsPropertyKey3, SemanticsProperties.ToggleableState)) {
                                    toggleableState2 = (ToggleableState) obj2;
                                } else if (Intrinsics.areEqual(semanticsPropertyKey3, SemanticsActions.OnClick)) {
                                    viewStructure.setClickable(true);
                                } else if (Intrinsics.areEqual(semanticsPropertyKey3, SemanticsActions.OnLongClick)) {
                                    viewStructure.setLongClickable(true);
                                } else if (Intrinsics.areEqual(semanticsPropertyKey3, SemanticsActions.RequestFocus)) {
                                    viewStructure.setFocusable(true);
                                } else if (Intrinsics.areEqual(semanticsPropertyKey3, SemanticsActions.SetText)) {
                                    z = true;
                                }
                            }
                            j4 >>= 8;
                        }
                        if (i6 != 8) {
                            break;
                        } else if (i5 != length) {
                            break;
                        } else {
                            i5++;
                        }
                    }
                }
            } else {
                j2 = 255;
                c = 7;
                j3 = -9187201950435737472L;
                zBooleanValue = true;
                androidContentDataType = null;
                z = false;
                toggleableState2 = null;
                annotatedString2 = null;
                androidFillableData2 = null;
                contentType = null;
                bool = null;
                role2 = null;
                z2 = false;
                num = null;
            }
            toggleableState = toggleableState2;
            annotatedString = annotatedString2;
            androidFillableData = androidFillableData2;
            role = role2;
        }
        SemanticsConfiguration semanticsConfiguration2 = layoutNode.getSemanticsConfiguration();
        if (semanticsConfiguration2 != null && semanticsConfiguration2.isMergingSemanticsOfDescendants && !semanticsConfiguration2.isClearingSemantics) {
            semanticsConfiguration2 = semanticsConfiguration2.copy();
            MutableObjectList mutableObjectList = new MutableObjectList(((MutableVector) ((MutableObjectList.ObjectListMutableList) layoutNode.getChildren$ui()).objectList).size);
            mutableObjectList.addAll(layoutNode.getChildren$ui());
            while (mutableObjectList.isNotEmpty()) {
                LayoutNode layoutNode2 = (LayoutNode) mutableObjectList.removeAt(mutableObjectList._size - 1);
                SemanticsConfiguration semanticsConfiguration3 = layoutNode2.getSemanticsConfiguration();
                if (semanticsConfiguration3 != null && !semanticsConfiguration3.isMergingSemanticsOfDescendants) {
                    semanticsConfiguration2.mergeChild$ui(semanticsConfiguration3);
                    if (!semanticsConfiguration3.isClearingSemantics) {
                        mutableObjectList.addAll(layoutNode2.getChildren$ui());
                    }
                }
            }
        }
        if (semanticsConfiguration2 != null && (mutableScatterMap = semanticsConfiguration2.props) != null) {
            Object[] objArr5 = mutableScatterMap.keys;
            Object[] objArr6 = mutableScatterMap.values;
            long[] jArr4 = mutableScatterMap.metadata;
            int length2 = jArr4.length - 2;
            i = 1;
            if (length2 >= 0) {
                int i9 = 0;
                list = null;
                while (true) {
                    long j5 = jArr4[i9];
                    int i10 = i4;
                    int i11 = i9;
                    if ((((~j5) << c) & j5 & j3) != j3) {
                        int i12 = 8 - ((~(i11 - length2)) >>> 31);
                        int i13 = 0;
                        while (i13 < i12) {
                            if ((j5 & j2) < j) {
                                int i14 = (i11 << 3) + i13;
                                Object obj3 = objArr5[i14];
                                Object obj4 = objArr6[i14];
                                jArr2 = jArr4;
                                SemanticsPropertyKey semanticsPropertyKey4 = (SemanticsPropertyKey) obj3;
                                objArr2 = objArr5;
                                if (Intrinsics.areEqual(semanticsPropertyKey4, SemanticsProperties.Disabled)) {
                                    viewStructure.setEnabled(false);
                                } else if (Intrinsics.areEqual(semanticsPropertyKey4, SemanticsProperties.Text)) {
                                    list = (List) obj4;
                                }
                            } else {
                                jArr2 = jArr4;
                                objArr2 = objArr5;
                            }
                            j5 >>= i10;
                            i13++;
                            objArr5 = objArr2;
                            jArr4 = jArr2;
                        }
                        jArr = jArr4;
                        objArr = objArr5;
                        i3 = i10;
                        if (i12 != i3) {
                            break;
                        }
                    } else {
                        jArr = jArr4;
                        objArr = objArr5;
                        i3 = i10;
                    }
                    if (i11 == length2) {
                        break;
                    }
                    i9 = i11 + 1;
                    i4 = i3;
                    objArr5 = objArr;
                    jArr4 = jArr;
                }
            }
            numValueOf = Integer.valueOf(layoutNode.semanticsId);
            if (layoutNode.getParent$ui() == null) {
                numValueOf = null;
            }
            if (numValueOf != null) {
                iIntValue = numValueOf.intValue();
            } else {
                iIntValue = -1;
            }
            viewStructure.setAutofillId(autofillId, iIntValue);
            viewStructure.setId(iIntValue, str, null, null);
            if (androidContentDataType != null) {
                numValueOf2 = Integer.valueOf(androidContentDataType.androidAutofillType);
            } else if (z) {
                numValueOf2 = Integer.valueOf(i);
            } else if (toggleableState != null) {
                numValueOf2 = 2;
            } else {
                numValueOf2 = null;
            }
            if (numValueOf2 != null) {
                viewStructure.setAutofillType(numValueOf2.intValue());
            }
            if (annotatedString != null) {
                strTake = annotatedString.text;
                if (strTake.length() >= 5000) {
                    if (Character.isHighSurrogate(strTake.charAt(4999)) || !Character.isLowSurrogate(strTake.charAt(5000))) {
                        strTake = StringsKt.take(strTake, 5000);
                    } else {
                        strTake = StringsKt.take(strTake, 4999);
                    }
                }
                viewStructure.setAutofillValue(AutofillValue.forText(strTake));
            }
            if (androidFillableData != null) {
                viewStructure.setAutofillValue(androidFillableData.autofillValue);
            }
            if (contentType != null && (strArr3 = (String[]) ((AndroidContentType) contentType).androidAutofillHints.toArray(new String[0])) != null) {
                viewStructure.setAutofillHints(strArr3);
            }
            rectManager.rects.withRect(layoutNode.semanticsId, new Function4() { // from class: androidx.compose.ui.autofill.PopulateViewStructure_androidKt$populate$7
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj5, Object obj6, Object obj7, Object obj8) {
                    int iIntValue2 = ((Number) obj5).intValue();
                    int iIntValue3 = ((Number) obj6).intValue();
                    int iIntValue4 = ((Number) obj7).intValue();
                    int iIntValue5 = ((Number) obj8).intValue() - iIntValue3;
                    viewStructure.setDimens(iIntValue2, iIntValue3, 0, 0, iIntValue4 - iIntValue2, iIntValue5);
                    return Unit.INSTANCE;
                }
            });
            if (bool != null) {
                viewStructure.setSelected(bool.booleanValue());
            }
            if (toggleableState != null) {
                viewStructure.setCheckable(i);
                if (toggleableState == ToggleableState.On) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                viewStructure.setChecked(z6);
            } else if (bool != null && (role == null || role.value != 4)) {
                viewStructure.setCheckable(true);
                viewStructure.setChecked(bool.booleanValue());
            }
            ContentType.Companion.getClass();
            strArr = (String[]) ContentType.Companion.Password.androidAutofillHints.toArray(new String[0]);
            if (strArr.length != 0) {
                throw new NoSuchElementException("Array is empty.");
            }
            String str2 = strArr[0];
            if (contentType == null && (strArr2 = (String[]) ((AndroidContentType) contentType).androidAutofillHints.toArray(new String[0])) != null) {
                boolean zContains = ArraysKt.contains(strArr2, str2);
                z3 = true;
                boolean z7 = zContains;
                if (!z2 || z7) {
                    z4 = z3;
                } else {
                    z4 = false;
                }
                if (!z4 || zBooleanValue) {
                    z5 = z3;
                } else {
                    z5 = false;
                }
                viewStructure.setDataIsSensitive(z5);
                viewStructure.setVisibility(((NodeCoordinator) layoutNode.nodes.outerCoordinator).isTransparent() ? 4 : 0);
                if (list != null) {
                    size = list.size();
                    strM = "";
                    for (i2 = 0; i2 < size; i2++) {
                        AnnotatedString annotatedString3 = (AnnotatedString) list.get(i2);
                        StringBuilder sb = new StringBuilder();
                        sb.append(strM);
                        strM = Modifier.CC.m(sb, annotatedString3.text, '\n');
                    }
                    viewStructure.setText(strM);
                    viewStructure.setClassName("android.widget.TextView");
                }
                if (((MutableObjectList.ObjectListMutableList) layoutNode.getChildren$ui()).isEmpty() && role != null && (strM614toLegacyClassNameV4PA4sw = InvertMatrixKt.m614toLegacyClassNameV4PA4sw(role.value)) != null) {
                    viewStructure.setClassName(strM614toLegacyClassNameV4PA4sw);
                }
                if (z) {
                    viewStructure.setClassName("android.widget.EditText");
                    if (Build.VERSION.SDK_INT >= 28 && num != null) {
                        viewStructure.setMaxTextLength(num.intValue());
                    }
                    if (z4) {
                        viewStructure.setInputType(129);
                    }
                }
            }
            z3 = true;
            if (z2) {
                z4 = z3;
            } else {
                z4 = z3;
            }
            if (z4) {
                z5 = z3;
            } else {
                z5 = z3;
            }
            viewStructure.setDataIsSensitive(z5);
            viewStructure.setVisibility(((NodeCoordinator) layoutNode.nodes.outerCoordinator).isTransparent() ? 4 : 0);
            if (list != null) {
                size = list.size();
                strM = "";
                while (i2 < size) {
                    AnnotatedString annotatedString4 = (AnnotatedString) list.get(i2);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(strM);
                    strM = Modifier.CC.m(sb2, annotatedString4.text, '\n');
                }
                viewStructure.setText(strM);
                viewStructure.setClassName("android.widget.TextView");
            }
            if (((MutableObjectList.ObjectListMutableList) layoutNode.getChildren$ui()).isEmpty()) {
                viewStructure.setClassName(strM614toLegacyClassNameV4PA4sw);
            }
            if (z) {
                viewStructure.setClassName("android.widget.EditText");
                if (Build.VERSION.SDK_INT >= 28) {
                    viewStructure.setMaxTextLength(num.intValue());
                }
                if (z4) {
                    viewStructure.setInputType(129);
                }
            }
        }
        i = 1;
        list = null;
        numValueOf = Integer.valueOf(layoutNode.semanticsId);
        if (layoutNode.getParent$ui() == null) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            iIntValue = numValueOf.intValue();
        } else {
            iIntValue = -1;
        }
        viewStructure.setAutofillId(autofillId, iIntValue);
        viewStructure.setId(iIntValue, str, null, null);
        if (androidContentDataType != null) {
            numValueOf2 = Integer.valueOf(androidContentDataType.androidAutofillType);
        } else if (z) {
            numValueOf2 = Integer.valueOf(i);
        } else if (toggleableState != null) {
            numValueOf2 = 2;
        } else {
            numValueOf2 = null;
        }
        if (numValueOf2 != null) {
            viewStructure.setAutofillType(numValueOf2.intValue());
        }
        if (annotatedString != null) {
            strTake = annotatedString.text;
            if (strTake.length() >= 5000) {
                if (Character.isHighSurrogate(strTake.charAt(4999))) {
                    strTake = StringsKt.take(strTake, 5000);
                } else {
                    strTake = StringsKt.take(strTake, 5000);
                }
            }
            viewStructure.setAutofillValue(AutofillValue.forText(strTake));
        }
        if (androidFillableData != null) {
            viewStructure.setAutofillValue(androidFillableData.autofillValue);
        }
        if (contentType != null) {
            viewStructure.setAutofillHints(strArr3);
        }
        rectManager.rects.withRect(layoutNode.semanticsId, new Function4() { // from class: androidx.compose.ui.autofill.PopulateViewStructure_androidKt$populate$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj5, Object obj6, Object obj7, Object obj8) {
                int iIntValue2 = ((Number) obj5).intValue();
                int iIntValue3 = ((Number) obj6).intValue();
                int iIntValue4 = ((Number) obj7).intValue();
                int iIntValue5 = ((Number) obj8).intValue() - iIntValue3;
                viewStructure.setDimens(iIntValue2, iIntValue3, 0, 0, iIntValue4 - iIntValue2, iIntValue5);
                return Unit.INSTANCE;
            }
        });
        if (bool != null) {
            viewStructure.setSelected(bool.booleanValue());
        }
        if (toggleableState != null) {
            viewStructure.setCheckable(i);
            if (toggleableState == ToggleableState.On) {
                z6 = true;
            } else {
                z6 = false;
            }
            viewStructure.setChecked(z6);
        } else if (bool != null) {
            viewStructure.setCheckable(true);
            viewStructure.setChecked(bool.booleanValue());
        }
        ContentType.Companion.getClass();
        strArr = (String[]) ContentType.Companion.Password.androidAutofillHints.toArray(new String[0]);
        if (strArr.length != 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        String str3 = strArr[0];
        if (contentType == null) {
            z3 = true;
        } else {
            z3 = true;
        }
        if (z2) {
            z4 = z3;
        } else {
            z4 = z3;
        }
        if (z4) {
            z5 = z3;
        } else {
            z5 = z3;
        }
        viewStructure.setDataIsSensitive(z5);
        viewStructure.setVisibility(((NodeCoordinator) layoutNode.nodes.outerCoordinator).isTransparent() ? 4 : 0);
        if (list != null) {
            size = list.size();
            strM = "";
            while (i2 < size) {
                AnnotatedString annotatedString5 = (AnnotatedString) list.get(i2);
                StringBuilder sb3 = new StringBuilder();
                sb3.append(strM);
                strM = Modifier.CC.m(sb3, annotatedString5.text, '\n');
            }
            viewStructure.setText(strM);
            viewStructure.setClassName("android.widget.TextView");
        }
        if (((MutableObjectList.ObjectListMutableList) layoutNode.getChildren$ui()).isEmpty()) {
            viewStructure.setClassName(strM614toLegacyClassNameV4PA4sw);
        }
        if (z) {
            viewStructure.setClassName("android.widget.EditText");
            if (Build.VERSION.SDK_INT >= 28) {
                viewStructure.setMaxTextLength(num.intValue());
            }
            if (z4) {
                viewStructure.setInputType(129);
            }
        }
    }
}
