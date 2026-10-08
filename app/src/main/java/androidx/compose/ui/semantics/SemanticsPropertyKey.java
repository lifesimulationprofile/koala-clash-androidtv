package androidx.compose.ui.semantics;

import androidx.compose.ui.autofill.AndroidContentDataType;
import androidx.compose.ui.autofill.AndroidFillableData;
import androidx.compose.ui.autofill.ContentType;
import androidx.compose.ui.graphics.Shape;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Function;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SemanticsPropertyKey {
    public final boolean isImportantForAccessibility;
    public final Function2 mergePolicy;
    public final String name;

    /* JADX INFO: renamed from: androidx.compose.ui.semantics.SemanticsPropertyKey$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends Lambda implements Function2 {
        public static final AnonymousClass1 INSTANCE;
        public static final AnonymousClass1 INSTANCE$1;
        public static final AnonymousClass1 INSTANCE$10;
        public static final AnonymousClass1 INSTANCE$11;
        public static final AnonymousClass1 INSTANCE$12;
        public static final AnonymousClass1 INSTANCE$13;
        public static final AnonymousClass1 INSTANCE$14;
        public static final AnonymousClass1 INSTANCE$15;
        public static final AnonymousClass1 INSTANCE$16;
        public static final AnonymousClass1 INSTANCE$17;
        public static final AnonymousClass1 INSTANCE$18;
        public static final AnonymousClass1 INSTANCE$19;
        public static final AnonymousClass1 INSTANCE$2;
        public static final AnonymousClass1 INSTANCE$20;
        public static final AnonymousClass1 INSTANCE$3;
        public static final AnonymousClass1 INSTANCE$4;
        public static final AnonymousClass1 INSTANCE$5;
        public static final AnonymousClass1 INSTANCE$6;
        public static final AnonymousClass1 INSTANCE$7;
        public static final AnonymousClass1 INSTANCE$8;
        public static final AnonymousClass1 INSTANCE$9;
        public final /* synthetic */ int $r8$classId;

        static {
            int i = 2;
            INSTANCE$1 = new AnonymousClass1(i, 1);
            INSTANCE$2 = new AnonymousClass1(i, 2);
            INSTANCE$3 = new AnonymousClass1(i, 3);
            INSTANCE$4 = new AnonymousClass1(i, 4);
            INSTANCE$5 = new AnonymousClass1(i, 5);
            INSTANCE$6 = new AnonymousClass1(i, 6);
            INSTANCE$7 = new AnonymousClass1(i, 7);
            INSTANCE$8 = new AnonymousClass1(i, 8);
            INSTANCE$9 = new AnonymousClass1(i, 9);
            INSTANCE$10 = new AnonymousClass1(i, 10);
            INSTANCE$11 = new AnonymousClass1(i, 11);
            INSTANCE$12 = new AnonymousClass1(i, 12);
            INSTANCE$13 = new AnonymousClass1(i, 13);
            INSTANCE$14 = new AnonymousClass1(i, 14);
            INSTANCE$15 = new AnonymousClass1(i, 15);
            INSTANCE$16 = new AnonymousClass1(i, 16);
            INSTANCE$17 = new AnonymousClass1(i, 17);
            INSTANCE$18 = new AnonymousClass1(i, 18);
            INSTANCE$19 = new AnonymousClass1(i, 19);
            INSTANCE = new AnonymousClass1(i, 0);
            INSTANCE$20 = new AnonymousClass1(i, 20);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(int i, int i2) {
            super(i);
            this.$r8$classId = i2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            String str;
            Function function;
            switch (this.$r8$classId) {
                case 0:
                    return obj == null ? obj2 : obj;
                case 1:
                    Collection collection = (List) obj;
                    List list = (List) obj2;
                    if (collection == null) {
                        collection = EmptyList.INSTANCE;
                    }
                    return CollectionsKt.plus(collection, list);
                case 2:
                    return (AndroidContentDataType) obj;
                case 3:
                    List list2 = (List) obj;
                    List list3 = (List) obj2;
                    if (list2 == null) {
                        return list3;
                    }
                    ArrayList arrayList = new ArrayList(list2);
                    arrayList.addAll(list3);
                    return arrayList;
                case 4:
                    return (ContentType) obj;
                case 5:
                    return (AndroidFillableData) obj;
                case 6:
                    return (Unit) obj;
                case 7:
                    return (Unit) obj;
                case 8:
                    throw new IllegalStateException("merge function called on unmergeable property IsDialog. A dialog should not be a child of a clickable/focusable node.");
                case 9:
                    throw new IllegalStateException("merge function called on unmergeable property IsPopup. A popup should not be a child of a clickable/focusable node.");
                case 10:
                    return (Unit) obj;
                case 11:
                    throw new IllegalStateException("merge function called on unmergeable property PaneTitle.");
                case 12:
                    Role role = (Role) obj;
                    int i = ((Role) obj2).value;
                    return role;
                case 13:
                    return (Shape) obj;
                case 14:
                    return (String) obj;
                case 15:
                    List list4 = (List) obj;
                    List list5 = (List) obj2;
                    if (list4 == null) {
                        return list5;
                    }
                    ArrayList arrayList2 = new ArrayList(list4);
                    arrayList2.addAll(list5);
                    return arrayList2;
                case 16:
                    Float f = (Float) obj;
                    ((Number) obj2).floatValue();
                    return f;
                case 17:
                    return (String) obj;
                case 18:
                    Boolean bool = (Boolean) obj;
                    ((Boolean) obj2).booleanValue();
                    return bool;
                case 19:
                    AccessibilityAction accessibilityAction = (AccessibilityAction) obj;
                    AccessibilityAction accessibilityAction2 = (AccessibilityAction) obj2;
                    if (accessibilityAction == null || (str = accessibilityAction.label) == null) {
                        str = accessibilityAction2.label;
                    }
                    if (accessibilityAction == null || (function = accessibilityAction.action) == null) {
                        function = accessibilityAction2.action;
                    }
                    return new AccessibilityAction(str, function);
                default:
                    SemanticsNode semanticsNode = (SemanticsNode) obj2;
                    Object objValueOf = Float.valueOf(0.0f);
                    SemanticsConfiguration semanticsConfiguration = ((SemanticsNode) obj).unmergedConfig;
                    SemanticsPropertyKey semanticsPropertyKey = SemanticsProperties.TraversalIndex;
                    Object obj3 = semanticsConfiguration.props.get(semanticsPropertyKey);
                    if (obj3 == null) {
                        obj3 = objValueOf;
                    }
                    float fFloatValue = ((Number) obj3).floatValue();
                    Object obj4 = semanticsNode.unmergedConfig.props.get(semanticsPropertyKey);
                    if (obj4 != null) {
                        objValueOf = obj4;
                    }
                    return Integer.valueOf(Float.compare(fFloatValue, ((Number) objValueOf).floatValue()));
            }
        }
    }

    public SemanticsPropertyKey(String str, Function2 function2) {
        this.name = str;
        this.mergePolicy = function2;
    }

    public final String toString() {
        return "AccessibilityKey: " + this.name;
    }

    public /* synthetic */ SemanticsPropertyKey(String str) {
        this(str, AnonymousClass1.INSTANCE);
    }

    public SemanticsPropertyKey(String str, int i) {
        this(str);
        this.isImportantForAccessibility = true;
    }

    public SemanticsPropertyKey(String str, boolean z, Function2 function2) {
        this(str, function2);
        this.isImportantForAccessibility = z;
    }
}
