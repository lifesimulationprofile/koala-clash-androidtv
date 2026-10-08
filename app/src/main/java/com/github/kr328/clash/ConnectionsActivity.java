package com.github.kr328.clash;

import android.os.Bundle;
import androidx.activity.compose.ComponentActivityKt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import coil.decode.BitmapFactoryDecoder$$ExternalSyntheticLambda2;
import com.github.kr328.clash.common.compat.TvKt;
import com.github.kr328.clash.compose.connections.ConnectionsScreenKt;
import com.github.kr328.clash.design.compose.theme.AppThemeKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ConnectionsActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: com.github.kr328.clash.ConnectionsActivity$onCreate$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 implements Function2 {
        public final /* synthetic */ boolean $isTv;
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ ConnectionsActivity this$0;

        public /* synthetic */ AnonymousClass1(ConnectionsActivity connectionsActivity, boolean z, int i) {
            this.$r8$classId = i;
            this.this$0 = connectionsActivity;
            this.$isTv = z;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            switch (this.$r8$classId) {
                case 0:
                    GapComposer gapComposer = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
                        gapComposer.skipToGroupEnd();
                    } else {
                        AppThemeKt.AppTheme(false, Thread_jvmKt.rememberComposableLambda(633142951, new AnonymousClass1(this.this$0, this.$isTv, 1), gapComposer), gapComposer, 48);
                    }
                    break;
                default:
                    GapComposer gapComposer2 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        gapComposer2.startReplaceGroup(-1615257526);
                        ConnectionsActivity connectionsActivity = this.this$0;
                        boolean zChanged = gapComposer2.changed(connectionsActivity);
                        Object objRememberedValue = gapComposer2.rememberedValue();
                        if (zChanged || objRememberedValue == Composer$Companion.Empty) {
                            objRememberedValue = new BitmapFactoryDecoder$$ExternalSyntheticLambda2(5, connectionsActivity);
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        }
                        gapComposer2.end(false);
                        ConnectionsScreenKt.ConnectionsScreen(0, gapComposer2, null, (Function0) objRememberedValue, this.$isTv);
                    }
                    break;
            }
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ComponentActivityKt.setContent$default(this, new ComposableLambdaImpl(-1660142287, new AnonymousClass1(this, TvKt.isTvDevice(this), 0), true));
    }
}
