package androidx.compose.material3;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import com.github.kr328.clash.PropertiesActivity;
import com.github.kr328.clash.compose.TvMainAppKt;
import com.github.kr328.clash.service.model.Profile;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TooltipKt$$ExternalSyntheticLambda2 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ MutableState f$0;
    public final /* synthetic */ MutableState f$1;

    public /* synthetic */ TooltipKt$$ExternalSyntheticLambda2(MutableState mutableState, MutableState mutableState2, int i) {
        this.$r8$classId = i;
        this.f$0 = mutableState;
        this.f$1 = mutableState2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i = this.$r8$classId;
        int i2 = 0;
        z = false;
        z = false;
        boolean z = false;
        i2 = 0;
        MutableState mutableState = this.f$1;
        MutableState mutableState2 = this.f$0;
        switch (i) {
            case 0:
                if (mutableState2.getValue() != null && mutableState.getValue() != null) {
                    long jMo526localToScreenMKHz9U = ((LayoutCoordinates) mutableState2.getValue()).mo526localToScreenMKHz9U(0L);
                    long j = ((Offset) mutableState.getValue()).packedValue;
                    if (Float.intBitsToFloat((int) (j >> 32)) <= Float.intBitsToFloat((int) (jMo526localToScreenMKHz9U >> 32))) {
                        i2 = Float.intBitsToFloat((int) (j & 4294967295L)) < Float.intBitsToFloat((int) (jMo526localToScreenMKHz9U & 4294967295L)) ? 1 : 3;
                    } else {
                        i2 = Float.intBitsToFloat((int) (j & 4294967295L)) < Float.intBitsToFloat((int) (jMo526localToScreenMKHz9U & 4294967295L)) ? 2 : 4;
                    }
                }
                return Integer.valueOf(i2);
            case 1:
                int i3 = PropertiesActivity.$r8$clinit;
                Profile profile = (Profile) mutableState2.getValue();
                Profile profile2 = (Profile) mutableState.getValue();
                if (profile != null) {
                    long j2 = profile.interval;
                    String str = profile.source;
                    String str2 = profile.name;
                    if (profile2 != null ? !Intrinsics.areEqual(str2, profile2.name) || !Intrinsics.areEqual(str, profile2.source) || j2 != profile2.interval : !StringsKt.isBlank(str2) || str.length() > 0 || j2 != 0) {
                        z = true;
                    }
                }
                return Boolean.valueOf(z);
            default:
                float f = TvMainAppKt.TvOverscanHorizontal;
                mutableState2.setValue(Boolean.FALSE);
                mutableState.setValue(Boolean.TRUE);
                return Unit.INSTANCE;
        }
    }
}
