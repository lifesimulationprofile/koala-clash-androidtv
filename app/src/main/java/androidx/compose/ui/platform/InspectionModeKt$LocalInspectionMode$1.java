package androidx.compose.ui.platform;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class InspectionModeKt$LocalInspectionMode$1 extends Lambda implements Function0 {
    public static final InspectionModeKt$LocalInspectionMode$1 INSTANCE;
    public static final InspectionModeKt$LocalInspectionMode$1 INSTANCE$1;
    public final /* synthetic */ int $r8$classId;

    static {
        int i = 0;
        INSTANCE = new InspectionModeKt$LocalInspectionMode$1(i, 0);
        INSTANCE$1 = new InspectionModeKt$LocalInspectionMode$1(i, 1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InspectionModeKt$LocalInspectionMode$1(int i, int i2) {
        super(i);
        this.$r8$classId = i2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final /* bridge */ /* synthetic */ Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                return Boolean.FALSE;
            default:
                return null;
        }
    }
}
