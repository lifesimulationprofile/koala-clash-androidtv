package androidx.navigation;

import android.os.Bundle;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class NavDeepLink$getMatchingArguments$missingRequiredArguments$1 extends Lambda implements Function1 {
    public final /* synthetic */ Bundle $bundle;
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NavDeepLink$getMatchingArguments$missingRequiredArguments$1(Bundle bundle, int i) {
        super(1);
        this.$r8$classId = i;
        this.$bundle = bundle;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return Boolean.valueOf(!this.$bundle.containsKey((String) obj));
            default:
                return Boolean.valueOf(!this.$bundle.containsKey((String) obj));
        }
    }
}
