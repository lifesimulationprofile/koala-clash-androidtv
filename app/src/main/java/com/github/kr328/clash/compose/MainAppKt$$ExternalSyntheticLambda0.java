package com.github.kr328.clash.compose;

import android.content.Context;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1;
import com.github.kr328.clash.compose.settings.SettingsScreenKt$SettingsScreen$5$1$1;
import com.github.kr328.clash.remote.Broadcasts$Observer;
import com.github.kr328.clash.remote.Remote;
import com.github.kr328.clash.service.ProfileProcessorKt;
import java.util.UUID;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MainAppKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ CoroutineScope f$0;
    public final /* synthetic */ SnackbarHostState f$1;
    public final /* synthetic */ Context f$2;

    public /* synthetic */ MainAppKt$$ExternalSyntheticLambda0(CoroutineScope coroutineScope, SnackbarHostState snackbarHostState, Context context, int i) {
        this.$r8$classId = i;
        this.f$0 = coroutineScope;
        this.f$1 = snackbarHostState;
        this.f$2 = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                final int i = 0;
                final CoroutineScope coroutineScope = this.f$0;
                final SnackbarHostState snackbarHostState = this.f$1;
                final Context context = this.f$2;
                Broadcasts$Observer broadcasts$Observer = new Broadcasts$Observer() { // from class: com.github.kr328.clash.compose.MainAppKt$MainApp$1$1$observer$1
                    @Override // com.github.kr328.clash.remote.Broadcasts$Observer
                    public final void onProfileChanged() {
                        int i2 = i;
                    }

                    @Override // com.github.kr328.clash.remote.Broadcasts$Observer
                    public final void onProfileLoaded() {
                        int i2 = i;
                    }

                    @Override // com.github.kr328.clash.remote.Broadcasts$Observer
                    public final void onProfileUpdateCompleted(UUID uuid) {
                        switch (i) {
                            case 0:
                                JobKt.launch$default(coroutineScope, null, new SettingsScreenKt$SettingsScreen$5$1$1(snackbarHostState, context, null, 1), 3);
                                break;
                            default:
                                JobKt.launch$default(coroutineScope, null, new SettingsScreenKt$SettingsScreen$5$1$1(snackbarHostState, context, null, 2), 3);
                                break;
                        }
                    }

                    @Override // com.github.kr328.clash.remote.Broadcasts$Observer
                    public final void onProfileUpdateFailed(UUID uuid, String str) {
                        switch (i) {
                            case 0:
                                if (ProfileProcessorKt.parseHwidLimitMarker(str) == null) {
                                    JobKt.launch$default(coroutineScope, null, new MainAppKt$MainApp$1$1$observer$1$onProfileUpdateFailed$1(context, str, snackbarHostState, null, 0), 3);
                                    break;
                                }
                                break;
                            default:
                                if (ProfileProcessorKt.parseHwidLimitMarker(str) == null) {
                                    JobKt.launch$default(coroutineScope, null, new MainAppKt$MainApp$1$1$observer$1$onProfileUpdateFailed$1(context, str, snackbarHostState, null, 1), 3);
                                    break;
                                }
                                break;
                        }
                    }

                    @Override // com.github.kr328.clash.remote.Broadcasts$Observer
                    public final void onServiceRecreated() {
                        int i2 = i;
                    }

                    @Override // com.github.kr328.clash.remote.Broadcasts$Observer
                    public final void onStarted() {
                        int i2 = i;
                    }

                    @Override // com.github.kr328.clash.remote.Broadcasts$Observer
                    public final void onStopped() {
                        int i2 = i;
                    }

                    private final void onProfileChanged$com$github$kr328$clash$compose$MainAppKt$MainApp$1$1$observer$1() {
                    }

                    private final void onProfileChanged$com$github$kr328$clash$compose$TvMainAppKt$TvMainApp$1$1$observer$1() {
                    }

                    private final void onProfileLoaded$com$github$kr328$clash$compose$MainAppKt$MainApp$1$1$observer$1() {
                    }

                    private final void onProfileLoaded$com$github$kr328$clash$compose$TvMainAppKt$TvMainApp$1$1$observer$1() {
                    }

                    private final void onServiceRecreated$com$github$kr328$clash$compose$MainAppKt$MainApp$1$1$observer$1() {
                    }

                    private final void onServiceRecreated$com$github$kr328$clash$compose$TvMainAppKt$TvMainApp$1$1$observer$1() {
                    }

                    private final void onStarted$com$github$kr328$clash$compose$MainAppKt$MainApp$1$1$observer$1() {
                    }

                    private final void onStarted$com$github$kr328$clash$compose$TvMainAppKt$TvMainApp$1$1$observer$1() {
                    }

                    private final void onStopped$com$github$kr328$clash$compose$MainAppKt$MainApp$1$1$observer$1() {
                    }

                    private final void onStopped$com$github$kr328$clash$compose$TvMainAppKt$TvMainApp$1$1$observer$1() {
                    }
                };
                Remote.broadcasts.addObserver(broadcasts$Observer);
                return new AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1(15, broadcasts$Observer);
            default:
                final int i2 = 1;
                final CoroutineScope coroutineScope2 = this.f$0;
                final SnackbarHostState snackbarHostState2 = this.f$1;
                final Context context2 = this.f$2;
                Broadcasts$Observer broadcasts$Observer2 = new Broadcasts$Observer() { // from class: com.github.kr328.clash.compose.MainAppKt$MainApp$1$1$observer$1
                    @Override // com.github.kr328.clash.remote.Broadcasts$Observer
                    public final void onProfileChanged() {
                        int i3 = i2;
                    }

                    @Override // com.github.kr328.clash.remote.Broadcasts$Observer
                    public final void onProfileLoaded() {
                        int i3 = i2;
                    }

                    @Override // com.github.kr328.clash.remote.Broadcasts$Observer
                    public final void onProfileUpdateCompleted(UUID uuid) {
                        switch (i2) {
                            case 0:
                                JobKt.launch$default(coroutineScope2, null, new SettingsScreenKt$SettingsScreen$5$1$1(snackbarHostState2, context2, null, 1), 3);
                                break;
                            default:
                                JobKt.launch$default(coroutineScope2, null, new SettingsScreenKt$SettingsScreen$5$1$1(snackbarHostState2, context2, null, 2), 3);
                                break;
                        }
                    }

                    @Override // com.github.kr328.clash.remote.Broadcasts$Observer
                    public final void onProfileUpdateFailed(UUID uuid, String str) {
                        switch (i2) {
                            case 0:
                                if (ProfileProcessorKt.parseHwidLimitMarker(str) == null) {
                                    JobKt.launch$default(coroutineScope2, null, new MainAppKt$MainApp$1$1$observer$1$onProfileUpdateFailed$1(context2, str, snackbarHostState2, null, 0), 3);
                                    break;
                                }
                                break;
                            default:
                                if (ProfileProcessorKt.parseHwidLimitMarker(str) == null) {
                                    JobKt.launch$default(coroutineScope2, null, new MainAppKt$MainApp$1$1$observer$1$onProfileUpdateFailed$1(context2, str, snackbarHostState2, null, 1), 3);
                                    break;
                                }
                                break;
                        }
                    }

                    @Override // com.github.kr328.clash.remote.Broadcasts$Observer
                    public final void onServiceRecreated() {
                        int i3 = i2;
                    }

                    @Override // com.github.kr328.clash.remote.Broadcasts$Observer
                    public final void onStarted() {
                        int i3 = i2;
                    }

                    @Override // com.github.kr328.clash.remote.Broadcasts$Observer
                    public final void onStopped() {
                        int i3 = i2;
                    }

                    private final void onProfileChanged$com$github$kr328$clash$compose$MainAppKt$MainApp$1$1$observer$1() {
                    }

                    private final void onProfileChanged$com$github$kr328$clash$compose$TvMainAppKt$TvMainApp$1$1$observer$1() {
                    }

                    private final void onProfileLoaded$com$github$kr328$clash$compose$MainAppKt$MainApp$1$1$observer$1() {
                    }

                    private final void onProfileLoaded$com$github$kr328$clash$compose$TvMainAppKt$TvMainApp$1$1$observer$1() {
                    }

                    private final void onServiceRecreated$com$github$kr328$clash$compose$MainAppKt$MainApp$1$1$observer$1() {
                    }

                    private final void onServiceRecreated$com$github$kr328$clash$compose$TvMainAppKt$TvMainApp$1$1$observer$1() {
                    }

                    private final void onStarted$com$github$kr328$clash$compose$MainAppKt$MainApp$1$1$observer$1() {
                    }

                    private final void onStarted$com$github$kr328$clash$compose$TvMainAppKt$TvMainApp$1$1$observer$1() {
                    }

                    private final void onStopped$com$github$kr328$clash$compose$MainAppKt$MainApp$1$1$observer$1() {
                    }

                    private final void onStopped$com$github$kr328$clash$compose$TvMainAppKt$TvMainApp$1$1$observer$1() {
                    }
                };
                Remote.broadcasts.addObserver(broadcasts$Observer2);
                return new AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1(16, broadcasts$Observer2);
        }
    }
}
