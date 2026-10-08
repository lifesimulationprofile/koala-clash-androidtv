package com.github.kr328.clash;

import android.content.Context;
import android.content.IntentFilter;
import android.graphics.drawable.Icon;
import android.service.quicksettings.Tile;
import com.github.kr328.clash.common.compat.ContextKt;
import com.github.kr328.clash.common.constants.Intents;
import com.github.kr328.clash.common.constants.Permissions;
import com.github.kr328.clash.remote.StatusClient;
import com.github.kr328.clash.util.ClashKt;
import com.koala.clash.R;
import kotlin.Unit;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TileService extends android.service.quicksettings.TileService {
    public static final /* synthetic */ int $r8$clinit = 0;
    public boolean clashRunning;
    public String currentProfile = "";
    public final TileService$receiver$1 receiver = new TileService$receiver$1(0, this);

    public final void onClick() {
        Tile qsTile = getQsTile();
        if (qsTile == null) {
            return;
        }
        int state = qsTile.getState();
        if (state == 1) {
            ClashKt.startClashService(this);
        } else {
            if (state != 2) {
                return;
            }
            ClashKt.stopClashService(this);
        }
    }

    public final void onStartListening() {
        super.onStartListening();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intents.ACTION_CLASH_STARTED);
        intentFilter.addAction(Intents.ACTION_CLASH_STOPPED);
        intentFilter.addAction(Intents.ACTION_PROFILE_LOADED);
        intentFilter.addAction(Intents.ACTION_SERVICE_RECREATED);
        Unit unit = Unit.INSTANCE;
        ContextKt.registerReceiverCompat(this, this.receiver, intentFilter, Permissions.RECEIVE_SELF_BROADCASTS);
        String strCurrentProfile = new StatusClient((Context) this, false).currentProfile();
        this.clashRunning = strCurrentProfile != null;
        if (strCurrentProfile == null) {
            strCurrentProfile = "";
        }
        this.currentProfile = strCurrentProfile;
        updateTile();
    }

    public final void onStopListening() {
        super.onStopListening();
        unregisterReceiver(this.receiver);
    }

    public final void updateTile() {
        Tile qsTile = getQsTile();
        if (qsTile == null) {
            return;
        }
        qsTile.setState(this.clashRunning ? 2 : 1);
        qsTile.setLabel(this.currentProfile.length() == 0 ? getText(R.string.launch_name) : this.currentProfile);
        qsTile.setIcon(Icon.createWithResource(this, R.drawable.ic_logo_service));
        qsTile.updateTile();
    }
}
