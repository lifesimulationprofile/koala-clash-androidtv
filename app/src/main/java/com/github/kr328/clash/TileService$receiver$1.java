package com.github.kr328.clash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.appcompat.view.menu.BaseMenuWrapper;
import coil.disk.DiskLruCache;
import com.github.kr328.clash.common.constants.Intents;
import com.github.kr328.clash.remote.Broadcasts$Observer;
import com.github.kr328.clash.remote.StatusClient;
import java.util.ArrayList;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferedChannel;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TileService$receiver$1 extends BroadcastReceiver {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object this$0;

    public /* synthetic */ TileService$receiver$1(int i, Object obj) {
        this.$r8$classId = i;
        this.this$0 = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v21 */
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action;
        int i = this.$r8$classId;
        ?? r3 = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        Object obj = this.this$0;
        switch (i) {
            case 0:
                TileService tileService = (TileService) obj;
                action = intent != null ? intent.getAction() : null;
                if (Intrinsics.areEqual(action, Intents.ACTION_CLASH_STARTED)) {
                    tileService.clashRunning = true;
                    tileService.currentProfile = "";
                } else if (Intrinsics.areEqual(action, Intents.ACTION_CLASH_STOPPED) || Intrinsics.areEqual(action, Intents.ACTION_SERVICE_RECREATED)) {
                    tileService.clashRunning = false;
                    tileService.currentProfile = "";
                } else if (Intrinsics.areEqual(action, Intents.ACTION_PROFILE_LOADED)) {
                    String strCurrentProfile = new StatusClient(tileService, (boolean) r3).currentProfile();
                    tileService.currentProfile = strCurrentProfile != null ? strCurrentProfile : "";
                }
                int i8 = TileService.$r8$clinit;
                tileService.updateTile();
                break;
            case 1:
                ((BaseMenuWrapper) obj).onChange();
                break;
            case 2:
                DiskLruCache.Editor editor = (DiskLruCache.Editor) obj;
                ?? r0 = (ArrayList) editor.written;
                if (Intrinsics.areEqual(intent != null ? intent.getPackage() : null, context != null ? context.getPackageName() : null)) {
                    action = intent != null ? intent.getAction() : null;
                    if (Intrinsics.areEqual(action, Intents.ACTION_SERVICE_RECREATED)) {
                        editor.closed = false;
                        int size = r0.size();
                        while (i2 < size) {
                            Object obj2 = r0.get(i2);
                            i2++;
                            ((Broadcasts$Observer) obj2).onServiceRecreated();
                        }
                    } else if (Intrinsics.areEqual(action, Intents.ACTION_CLASH_STARTED)) {
                        editor.closed = true;
                        int size2 = r0.size();
                        while (i3 < size2) {
                            Object obj3 = r0.get(i3);
                            i3++;
                            ((Broadcasts$Observer) obj3).onStarted();
                        }
                    } else if (Intrinsics.areEqual(action, Intents.ACTION_CLASH_STOPPED)) {
                        editor.closed = false;
                        int size3 = r0.size();
                        while (i4 < size3) {
                            Object obj4 = r0.get(i4);
                            i4++;
                            intent.getStringExtra("stop_reason");
                            ((Broadcasts$Observer) obj4).onStopped();
                        }
                    } else if (Intrinsics.areEqual(action, Intents.ACTION_PROFILE_CHANGED)) {
                        int size4 = r0.size();
                        while (i5 < size4) {
                            Object obj5 = r0.get(i5);
                            i5++;
                            ((Broadcasts$Observer) obj5).onProfileChanged();
                        }
                    } else if (Intrinsics.areEqual(action, Intents.ACTION_PROFILE_UPDATE_COMPLETED)) {
                        int size5 = r0.size();
                        while (i6 < size5) {
                            Object obj6 = r0.get(i6);
                            i6++;
                            ((Broadcasts$Observer) obj6).onProfileUpdateCompleted(UUID.fromString(intent.getStringExtra("uuid")));
                        }
                    } else if (Intrinsics.areEqual(action, Intents.ACTION_PROFILE_UPDATE_FAILED)) {
                        int size6 = r0.size();
                        while (i7 < size6) {
                            Object obj7 = r0.get(i7);
                            i7++;
                            ((Broadcasts$Observer) obj7).onProfileUpdateFailed(UUID.fromString(intent.getStringExtra("uuid")), intent.getStringExtra("fail_reason"));
                        }
                    } else if (Intrinsics.areEqual(action, Intents.ACTION_PROFILE_LOADED)) {
                        int size7 = r0.size();
                        while (r3 < size7) {
                            ((Broadcasts$Observer) r0.get(r3)).onProfileLoaded();
                            r3++;
                        }
                    }
                    break;
                }
                break;
            default:
                BufferedChannel bufferedChannel = (BufferedChannel) obj;
                if (context == null || intent == null) {
                    bufferedChannel.closeOrCancelImpl(null, false);
                } else {
                    bufferedChannel.mo842trySendJP2dKIU(intent);
                }
                break;
        }
    }
}
