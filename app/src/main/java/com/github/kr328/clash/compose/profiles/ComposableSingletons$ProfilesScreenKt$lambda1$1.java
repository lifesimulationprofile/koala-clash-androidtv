package com.github.kr328.clash.compose.profiles;

import androidx.compose.material3.TextKt;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import com.koala.clash.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: renamed from: com.github.kr328.clash.compose.profiles.ComposableSingletons$ProfilesScreenKt$lambda-1$1, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ComposableSingletons$ProfilesScreenKt$lambda1$1 implements Function3 {
    public static final ComposableSingletons$ProfilesScreenKt$lambda1$1 INSTANCE = new ComposableSingletons$ProfilesScreenKt$lambda1$1(0);
    public static final ComposableSingletons$ProfilesScreenKt$lambda1$1 INSTANCE$1 = new ComposableSingletons$ProfilesScreenKt$lambda1$1(1);
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ ComposableSingletons$ProfilesScreenKt$lambda1$1(int i) {
        this.$r8$classId = i;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        switch (this.$r8$classId) {
            case 0:
                GapComposer gapComposer = (GapComposer) obj2;
                if ((((Number) obj3).intValue() & 17) == 16 && gapComposer.getSkipping()) {
                    gapComposer.skipToGroupEnd();
                } else {
                    TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.profile_delete, gapComposer), null, 0L, 0L, null, FontWeight.SemiBold, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 1572864, 0, 262078);
                }
                break;
            default:
                GapComposer gapComposer2 = (GapComposer) obj2;
                if ((((Number) obj3).intValue() & 17) == 16 && gapComposer2.getSkipping()) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.cancel, gapComposer2), null, 0L, 0L, null, FontWeight.Medium, 0L, null, 0L, 0, false, 0, 0, null, gapComposer2, 1572864, 0, 262078);
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
