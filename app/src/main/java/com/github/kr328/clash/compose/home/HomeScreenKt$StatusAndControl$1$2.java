package com.github.kr328.clash.compose.home;

import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.material3.MaterialTheme$Values;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import coil.network.HttpException;
import com.github.kr328.clash.compose.settings.SettingsEntry;
import com.github.kr328.clash.design.compose.components.ControlButtonState;
import com.github.kr328.clash.design.compose.theme.AppColors;
import com.google.android.gms.internal.mlkit_vision_common.zzje;
import com.koala.clash.R;
import java.util.List;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class HomeScreenKt$StatusAndControl$1$2 implements Function4 {
    public final /* synthetic */ Object $colors;
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ HomeScreenKt$StatusAndControl$1$2(int i, Object obj) {
        this.$r8$classId = i;
        this.$colors = obj;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        int i;
        int i2;
        switch (this.$r8$classId) {
            case 0:
                GapComposer gapComposer = (GapComposer) obj3;
                ((Number) obj4).intValue();
                int iOrdinal = ((ControlButtonState) obj2).ordinal();
                if (iOrdinal == 0) {
                    i = R.string.status_disconnected;
                } else if (iOrdinal == 1) {
                    i = R.string.status_connecting;
                } else if (iOrdinal == 2) {
                    i = R.string.status_connected;
                } else {
                    if (iOrdinal != 3) {
                        throw new HttpException();
                    }
                    i = R.string.status_disconnecting;
                }
                TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(i, gapComposer).toUpperCase(Locale.ROOT), null, ((AppColors) this.$colors).textPrimary, 0L, null, FontWeight.Bold, 0L, null, 0L, 0, false, 0, 0, ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography.titleMedium, gapComposer, 1572864, 0, 131002);
                return Unit.INSTANCE;
            default:
                LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj;
                int iIntValue = ((Number) obj2).intValue();
                GapComposer gapComposer2 = (GapComposer) obj3;
                int iIntValue2 = ((Number) obj4).intValue();
                if ((iIntValue2 & 6) == 0) {
                    i2 = (gapComposer2.changed(lazyItemScopeImpl) ? 4 : 2) | iIntValue2;
                } else {
                    i2 = iIntValue2;
                }
                if ((iIntValue2 & 48) == 0) {
                    i2 |= gapComposer2.changed(iIntValue) ? 32 : 16;
                }
                if (gapComposer2.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
                    SettingsEntry settingsEntry = (SettingsEntry) ((List) this.$colors).get(iIntValue);
                    gapComposer2.startReplaceGroup(1679960011);
                    zzje.SettingsRow(settingsEntry, gapComposer2, 0);
                    gapComposer2.end(false);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return Unit.INSTANCE;
        }
    }
}
