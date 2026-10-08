package com.github.kr328.clash.compose.profiles;

import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import com.koala.clash.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.github.kr328.clash.compose.profiles.ComposableSingletons$ProfilesScreenKt$lambda-3$1, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ComposableSingletons$ProfilesScreenKt$lambda3$1 implements Function2 {
    public static final ComposableSingletons$ProfilesScreenKt$lambda3$1 INSTANCE = new ComposableSingletons$ProfilesScreenKt$lambda3$1();

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        GapComposer gapComposer = (GapComposer) obj;
        if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
            gapComposer.skipToGroupEnd();
        } else {
            TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.profile_delete_title, gapComposer), null, 0L, 0L, null, FontWeight.SemiBold, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.titleLarge, gapComposer, 1572864, 0, 131006);
        }
        return Unit.INSTANCE;
    }
}
