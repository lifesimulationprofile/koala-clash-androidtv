package com.github.kr328.clash.compose;

import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import com.koala.clash.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: renamed from: com.github.kr328.clash.compose.ComposableSingletons$UpdateDialogKt$lambda-1$1, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ComposableSingletons$UpdateDialogKt$lambda1$1 implements Function3 {
    public final /* synthetic */ int $r8$classId;
    public static final ComposableSingletons$UpdateDialogKt$lambda1$1 INSTANCE$1 = new ComposableSingletons$UpdateDialogKt$lambda1$1(1);
    public static final ComposableSingletons$UpdateDialogKt$lambda1$1 INSTANCE$2 = new ComposableSingletons$UpdateDialogKt$lambda1$1(2);
    public static final ComposableSingletons$UpdateDialogKt$lambda1$1 INSTANCE$3 = new ComposableSingletons$UpdateDialogKt$lambda1$1(3);
    public static final ComposableSingletons$UpdateDialogKt$lambda1$1 INSTANCE = new ComposableSingletons$UpdateDialogKt$lambda1$1(0);
    public static final ComposableSingletons$UpdateDialogKt$lambda1$1 INSTANCE$4 = new ComposableSingletons$UpdateDialogKt$lambda1$1(4);

    public /* synthetic */ ComposableSingletons$UpdateDialogKt$lambda1$1(int i) {
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
                    TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.update_go_download, gapComposer), null, 0L, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer, 0, 0, 262142);
                }
                break;
            case 1:
                GapComposer gapComposer2 = (GapComposer) obj2;
                if ((((Number) obj3).intValue() & 17) == 16 && gapComposer2.getSkipping()) {
                    gapComposer2.skipToGroupEnd();
                } else {
                    TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.profile_device_limit_dismiss, gapComposer2), null, 0L, 0L, null, FontWeight.SemiBold, 0L, null, 0L, 0, false, 0, 0, null, gapComposer2, 1572864, 0, 262078);
                }
                break;
            case 2:
                GapComposer gapComposer3 = (GapComposer) obj2;
                if ((((Number) obj3).intValue() & 17) == 16 && gapComposer3.getSkipping()) {
                    gapComposer3.skipToGroupEnd();
                } else {
                    TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.profile_device_limit_support, gapComposer3), null, 0L, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer3, 0, 0, 262142);
                }
                break;
            case 3:
                GapComposer gapComposer4 = (GapComposer) obj2;
                if ((((Number) obj3).intValue() & 17) == 16 && gapComposer4.getSkipping()) {
                    gapComposer4.skipToGroupEnd();
                } else {
                    TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.ok, gapComposer4), null, ((MaterialTheme$Values) gapComposer4.consume(MaterialThemeKt._localMaterialTheme)).colorScheme.error, 0L, null, FontWeight.SemiBold, 0L, null, 0L, 0, false, 0, 0, null, gapComposer4, 1572864, 0, 262074);
                }
                break;
            default:
                GapComposer gapComposer5 = (GapComposer) obj2;
                if ((((Number) obj3).intValue() & 17) == 16 && gapComposer5.getSkipping()) {
                    gapComposer5.skipToGroupEnd();
                } else {
                    TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.update_later, gapComposer5), null, 0L, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer5, 0, 0, 262142);
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
