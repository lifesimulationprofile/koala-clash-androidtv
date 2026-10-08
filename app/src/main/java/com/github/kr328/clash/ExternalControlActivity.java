package com.github.kr328.clash;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.github.kr328.clash.common.constants.Intents;
import com.github.kr328.clash.common.util.ComponentsKt;
import com.github.kr328.clash.remote.Remote;
import com.github.kr328.clash.service.model.Profile;
import com.github.kr328.clash.util.ClashKt;
import com.koala.clash.R;
import java.util.Locale;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.internal.ContextScope;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ExternalControlActivity extends Activity implements CoroutineScope {
    public final /* synthetic */ ContextScope $$delegate_0 = JobKt.MainScope();

    @Override // android.app.Activity
    public final void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.$$delegate_0.coroutineContext;
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        String action = getIntent().getAction();
        if (Intrinsics.areEqual(action, "android.intent.action.VIEW")) {
            Uri data = getIntent().getData();
            if (data == null) {
                finish();
                return;
            }
            String queryParameter = data.getQueryParameter("url");
            if (queryParameter == null) {
                finish();
                return;
            }
            String queryParameter2 = data.getQueryParameter("type");
            String lowerCase = queryParameter2 != null ? queryParameter2.toLowerCase(Locale.getDefault()) : null;
            boolean zAreEqual = Intrinsics.areEqual(lowerCase, "url");
            Profile.Type type = Profile.Type.Url;
            if (!zAreEqual && Intrinsics.areEqual(lowerCase, "file")) {
                type = Profile.Type.File;
            }
            String queryParameter3 = data.getQueryParameter("name");
            if (queryParameter3 == null) {
                queryParameter3 = getString(R.string.new_profile);
            }
            startActivity(ComponentsKt.getIntent(Reflection.getOrCreateKotlinClass(PropertiesActivity.class)).putExtra("profile_type", type.name()).putExtra("name", queryParameter3).putExtra("source", queryParameter).addFlags(268435456));
        } else if (Intrinsics.areEqual(action, Intents.ACTION_TOGGLE_CLASH)) {
            if (Remote.broadcasts.closed) {
                ClashKt.stopClashService(this);
                Toast.makeText(this, R.string.external_control_stopped, 1).show();
            } else if (ClashKt.startClashService(this) != null) {
                Toast.makeText(this, R.string.unable_to_start_vpn, 1).show();
            } else {
                Toast.makeText(this, R.string.external_control_started, 1).show();
            }
        } else if (Intrinsics.areEqual(action, Intents.ACTION_START_CLASH)) {
            if (Remote.broadcasts.closed || ClashKt.startClashService(this) == null) {
                Toast.makeText(this, R.string.external_control_started, 1).show();
            } else {
                Toast.makeText(this, R.string.unable_to_start_vpn, 1).show();
            }
        } else if (Intrinsics.areEqual(action, Intents.ACTION_STOP_CLASH)) {
            if (Remote.broadcasts.closed) {
                ClashKt.stopClashService(this);
                Toast.makeText(this, R.string.external_control_stopped, 1).show();
            } else {
                Toast.makeText(this, R.string.external_control_stopped, 1).show();
            }
        }
        finish();
    }
}
