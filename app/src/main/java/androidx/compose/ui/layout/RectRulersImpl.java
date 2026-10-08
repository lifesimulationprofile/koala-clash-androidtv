package androidx.compose.ui.layout;

import java.io.Serializable;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__AppendableKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RectRulersImpl {
    public final /* synthetic */ int $r8$classId;
    public final VerticalRuler bottom;
    public final VerticalRuler left;
    public final Serializable name;
    public final VerticalRuler right;
    public final VerticalRuler top;

    public RectRulersImpl(String str) {
        this.$r8$classId = 0;
        this.name = str;
        this.left = new VerticalRuler(0, null);
        this.top = new VerticalRuler(1, null);
        this.right = new VerticalRuler(0, null);
        this.bottom = new VerticalRuler(1, null);
    }

    public final VerticalRuler getBottom() {
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return this.bottom;
    }

    public final VerticalRuler getLeft() {
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return this.left;
    }

    public final VerticalRuler getRight() {
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return this.right;
    }

    public final VerticalRuler getTop() {
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return this.top;
    }

    public final String toString() {
        switch (this.$r8$classId) {
            case 0:
                String str = (String) this.name;
                if (str == null) {
                    return super.toString();
                }
                return "RectRulers(" + str + ')';
            default:
                RectRulersImpl[] rectRulersImplArr = (RectRulersImpl[]) this.name;
                StringBuilder sb = new StringBuilder();
                sb.append((CharSequence) "innermostOf(");
                int i = 0;
                for (RectRulersImpl rectRulersImpl : rectRulersImplArr) {
                    i++;
                    if (i > 1) {
                        sb.append((CharSequence) ", ");
                    }
                    StringsKt__AppendableKt.appendElement(sb, rectRulersImpl, null);
                }
                sb.append((CharSequence) ")");
                return sb.toString();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RectRulersImpl(RectRulersImpl[] rectRulersImplArr) {
        this.$r8$classId = 1;
        this.name = rectRulersImplArr;
        int length = rectRulersImplArr.length;
        final VerticalRuler[] verticalRulerArr = new VerticalRuler[length];
        for (int i = 0; i < length; i++) {
            verticalRulerArr[i] = ((RectRulersImpl[]) this.name)[i].getLeft();
        }
        final int i2 = 0;
        this.left = new VerticalRuler(0, new Function2() { // from class: androidx.compose.ui.layout.VerticalRuler$Companion$maxOf$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                switch (i2) {
                    case 0:
                        return Float.valueOf(RulerKt.access$mergeRulerValues((Placeable.PlacementScope) obj, true, verticalRulerArr, ((Number) obj2).floatValue()));
                    default:
                        return Float.valueOf(RulerKt.access$mergeRulerValues((Placeable.PlacementScope) obj, false, verticalRulerArr, ((Number) obj2).floatValue()));
                }
            }
        });
        int length2 = ((RectRulersImpl[]) this.name).length;
        final VerticalRuler[] verticalRulerArr2 = new VerticalRuler[length2];
        for (int i3 = 0; i3 < length2; i3++) {
            verticalRulerArr2[i3] = ((RectRulersImpl[]) this.name)[i3].getTop();
        }
        final int i4 = 0;
        this.top = new VerticalRuler(1, new Function2() { // from class: androidx.compose.ui.layout.HorizontalRuler$Companion$maxOf$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                switch (i4) {
                    case 0:
                        return Float.valueOf(RulerKt.access$mergeRulerValues((Placeable.PlacementScope) obj, true, verticalRulerArr2, ((Number) obj2).floatValue()));
                    default:
                        return Float.valueOf(RulerKt.access$mergeRulerValues((Placeable.PlacementScope) obj, false, verticalRulerArr2, ((Number) obj2).floatValue()));
                }
            }
        });
        int length3 = ((RectRulersImpl[]) this.name).length;
        final VerticalRuler[] verticalRulerArr3 = new VerticalRuler[length3];
        for (int i5 = 0; i5 < length3; i5++) {
            verticalRulerArr3[i5] = ((RectRulersImpl[]) this.name)[i5].getRight();
        }
        final int i6 = 1;
        this.right = new VerticalRuler(0, new Function2() { // from class: androidx.compose.ui.layout.VerticalRuler$Companion$maxOf$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                switch (i6) {
                    case 0:
                        return Float.valueOf(RulerKt.access$mergeRulerValues((Placeable.PlacementScope) obj, true, verticalRulerArr3, ((Number) obj2).floatValue()));
                    default:
                        return Float.valueOf(RulerKt.access$mergeRulerValues((Placeable.PlacementScope) obj, false, verticalRulerArr3, ((Number) obj2).floatValue()));
                }
            }
        });
        int length4 = ((RectRulersImpl[]) this.name).length;
        final VerticalRuler[] verticalRulerArr4 = new VerticalRuler[length4];
        for (int i7 = 0; i7 < length4; i7++) {
            verticalRulerArr4[i7] = ((RectRulersImpl[]) this.name)[i7].getBottom();
        }
        final int i8 = 1;
        this.bottom = new VerticalRuler(1, new Function2() { // from class: androidx.compose.ui.layout.HorizontalRuler$Companion$maxOf$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                switch (i8) {
                    case 0:
                        return Float.valueOf(RulerKt.access$mergeRulerValues((Placeable.PlacementScope) obj, true, verticalRulerArr4, ((Number) obj2).floatValue()));
                    default:
                        return Float.valueOf(RulerKt.access$mergeRulerValues((Placeable.PlacementScope) obj, false, verticalRulerArr4, ((Number) obj2).floatValue()));
                }
            }
        });
    }
}
