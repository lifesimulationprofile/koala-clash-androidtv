package com.github.kr328.clash;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import androidx.activity.compose.ComponentActivityKt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import coil.ImageLoader$Builder;
import coil.memory.MemoryCacheService;
import coil.request.Parameters;
import com.github.kr328.clash.compose.settings.NetworkSettingsState;
import com.github.kr328.clash.design.compose.theme.AppThemeKt;
import com.github.kr328.clash.design.store.UiStore;
import com.github.kr328.clash.remote.Remote;
import com.github.kr328.clash.service.model.AccessControlMode;
import com.github.kr328.clash.service.store.ServiceStore;
import com.google.android.gms.internal.mlkit_vision_common.zzjd;
import com.google.android.gms.tasks.zzr;
import com.koala.clash.R;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KProperty;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class NetworkSettingsActivity extends AppCompatActivity {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final SynchronizedLazyImpl uiStore$delegate = new SynchronizedLazyImpl(new NetworkSettingsActivity$$ExternalSyntheticLambda0(this, 0));
    public final SynchronizedLazyImpl srvStore$delegate = new SynchronizedLazyImpl(new NetworkSettingsActivity$$ExternalSyntheticLambda0(this, 1));

    /* JADX INFO: renamed from: com.github.kr328.clash.NetworkSettingsActivity$onCreate$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 implements Function2 {
        public final /* synthetic */ NetworkSettingsState $initial;
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ NetworkSettingsActivity this$0;

        public /* synthetic */ AnonymousClass1(NetworkSettingsActivity networkSettingsActivity, NetworkSettingsState networkSettingsState, int i) {
            this.$r8$classId = i;
            this.this$0 = networkSettingsActivity;
            this.$initial = networkSettingsState;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            switch (this.$r8$classId) {
                case 0:
                    GapComposer gapComposer = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
                        gapComposer.skipToGroupEnd();
                    } else {
                        AppThemeKt.AppTheme(false, Thread_jvmKt.rememberComposableLambda(-204708369, new AnonymousClass1(this.this$0, this.$initial, 1), gapComposer), gapComposer, 48);
                    }
                    break;
                default:
                    GapComposer gapComposer2 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        gapComposer2.startReplaceGroup(-846603742);
                        Object objRememberedValue = gapComposer2.rememberedValue();
                        NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
                        if (objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = new SnackbarHostState();
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        }
                        SnackbarHostState snackbarHostState = (SnackbarHostState) objRememberedValue;
                        gapComposer2.end(false);
                        final NetworkSettingsActivity networkSettingsActivity = this.this$0;
                        String string = networkSettingsActivity.getString(R.string.options_unavailable);
                        gapComposer2.startReplaceGroup(-846592612);
                        boolean zChangedInstance = gapComposer2.changedInstance(networkSettingsActivity);
                        Object objRememberedValue2 = gapComposer2.rememberedValue();
                        if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                            final int i = 0;
                            objRememberedValue2 = new Function1() { // from class: com.github.kr328.clash.NetworkSettingsActivity$onCreate$1$1$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj3) {
                                    int i2 = i;
                                    NetworkSettingsActivity networkSettingsActivity2 = networkSettingsActivity;
                                    switch (i2) {
                                        case 0:
                                            Boolean bool = (Boolean) obj3;
                                            bool.getClass();
                                            int i3 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar = ((UiStore) networkSettingsActivity2.uiStore$delegate.getValue()).enableVpn$delegate;
                                            KProperty kProperty = UiStore.$$delegatedProperties[0];
                                            zzrVar.setValue(bool);
                                            break;
                                        case 1:
                                            Boolean bool2 = (Boolean) obj3;
                                            bool2.getClass();
                                            int i4 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar2 = networkSettingsActivity2.getSrvStore$2().bypassPrivateNetwork$delegate;
                                            KProperty kProperty2 = ServiceStore.$$delegatedProperties[1];
                                            zzrVar2.setValue(bool2);
                                            break;
                                        case 2:
                                            Boolean bool3 = (Boolean) obj3;
                                            bool3.getClass();
                                            int i5 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar3 = networkSettingsActivity2.getSrvStore$2().dnsHijacking$delegate;
                                            KProperty kProperty3 = ServiceStore.$$delegatedProperties[4];
                                            zzrVar3.setValue(bool3);
                                            break;
                                        case 3:
                                            Boolean bool4 = (Boolean) obj3;
                                            bool4.getClass();
                                            int i6 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar4 = networkSettingsActivity2.getSrvStore$2().allowBypass$delegate;
                                            KProperty kProperty4 = ServiceStore.$$delegatedProperties[6];
                                            zzrVar4.setValue(bool4);
                                            break;
                                        case 4:
                                            Boolean bool5 = (Boolean) obj3;
                                            bool5.getClass();
                                            int i7 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar5 = networkSettingsActivity2.getSrvStore$2().allowIpv6$delegate;
                                            KProperty kProperty5 = ServiceStore.$$delegatedProperties[7];
                                            zzrVar5.setValue(bool5);
                                            break;
                                        case 5:
                                            Boolean bool6 = (Boolean) obj3;
                                            bool6.getClass();
                                            int i8 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar6 = networkSettingsActivity2.getSrvStore$2().systemProxy$delegate;
                                            KProperty kProperty6 = ServiceStore.$$delegatedProperties[5];
                                            zzrVar6.setValue(bool6);
                                            break;
                                        case 6:
                                            int i9 = NetworkSettingsActivity.$r8$clinit;
                                            ImageLoader$Builder imageLoader$Builder = networkSettingsActivity2.getSrvStore$2().tunStackMode$delegate;
                                            KProperty kProperty7 = ServiceStore.$$delegatedProperties[8];
                                            MemoryCacheService memoryCacheService = (MemoryCacheService) ((Parameters.Builder) imageLoader$Builder.applicationContext).entries;
                                            String str = (String) imageLoader$Builder.defaults;
                                            SharedPreferences.Editor editorEdit = ((SharedPreferences) memoryCacheService.imageLoader).edit();
                                            editorEdit.putString(str, (String) obj3);
                                            editorEdit.apply();
                                            break;
                                        default:
                                            int i10 = NetworkSettingsActivity.$r8$clinit;
                                            Dispatcher dispatcher = networkSettingsActivity2.getSrvStore$2().accessControlMode$delegate;
                                            KProperty kProperty8 = ServiceStore.$$delegatedProperties[2];
                                            dispatcher.setValue((AccessControlMode) obj3);
                                            break;
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        }
                        Function1 function1 = (Function1) objRememberedValue2;
                        gapComposer2.end(false);
                        gapComposer2.startReplaceGroup(-846590072);
                        boolean zChangedInstance2 = gapComposer2.changedInstance(networkSettingsActivity);
                        Object objRememberedValue3 = gapComposer2.rememberedValue();
                        if (zChangedInstance2 || objRememberedValue3 == neverEqualPolicy) {
                            final int i2 = 1;
                            objRememberedValue3 = new Function1() { // from class: com.github.kr328.clash.NetworkSettingsActivity$onCreate$1$1$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj3) {
                                    int i3 = i2;
                                    NetworkSettingsActivity networkSettingsActivity2 = networkSettingsActivity;
                                    switch (i3) {
                                        case 0:
                                            Boolean bool = (Boolean) obj3;
                                            bool.getClass();
                                            int i4 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar = ((UiStore) networkSettingsActivity2.uiStore$delegate.getValue()).enableVpn$delegate;
                                            KProperty kProperty = UiStore.$$delegatedProperties[0];
                                            zzrVar.setValue(bool);
                                            break;
                                        case 1:
                                            Boolean bool2 = (Boolean) obj3;
                                            bool2.getClass();
                                            int i5 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar2 = networkSettingsActivity2.getSrvStore$2().bypassPrivateNetwork$delegate;
                                            KProperty kProperty2 = ServiceStore.$$delegatedProperties[1];
                                            zzrVar2.setValue(bool2);
                                            break;
                                        case 2:
                                            Boolean bool3 = (Boolean) obj3;
                                            bool3.getClass();
                                            int i6 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar3 = networkSettingsActivity2.getSrvStore$2().dnsHijacking$delegate;
                                            KProperty kProperty3 = ServiceStore.$$delegatedProperties[4];
                                            zzrVar3.setValue(bool3);
                                            break;
                                        case 3:
                                            Boolean bool4 = (Boolean) obj3;
                                            bool4.getClass();
                                            int i7 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar4 = networkSettingsActivity2.getSrvStore$2().allowBypass$delegate;
                                            KProperty kProperty4 = ServiceStore.$$delegatedProperties[6];
                                            zzrVar4.setValue(bool4);
                                            break;
                                        case 4:
                                            Boolean bool5 = (Boolean) obj3;
                                            bool5.getClass();
                                            int i8 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar5 = networkSettingsActivity2.getSrvStore$2().allowIpv6$delegate;
                                            KProperty kProperty5 = ServiceStore.$$delegatedProperties[7];
                                            zzrVar5.setValue(bool5);
                                            break;
                                        case 5:
                                            Boolean bool6 = (Boolean) obj3;
                                            bool6.getClass();
                                            int i9 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar6 = networkSettingsActivity2.getSrvStore$2().systemProxy$delegate;
                                            KProperty kProperty6 = ServiceStore.$$delegatedProperties[5];
                                            zzrVar6.setValue(bool6);
                                            break;
                                        case 6:
                                            int i10 = NetworkSettingsActivity.$r8$clinit;
                                            ImageLoader$Builder imageLoader$Builder = networkSettingsActivity2.getSrvStore$2().tunStackMode$delegate;
                                            KProperty kProperty7 = ServiceStore.$$delegatedProperties[8];
                                            MemoryCacheService memoryCacheService = (MemoryCacheService) ((Parameters.Builder) imageLoader$Builder.applicationContext).entries;
                                            String str = (String) imageLoader$Builder.defaults;
                                            SharedPreferences.Editor editorEdit = ((SharedPreferences) memoryCacheService.imageLoader).edit();
                                            editorEdit.putString(str, (String) obj3);
                                            editorEdit.apply();
                                            break;
                                        default:
                                            int i11 = NetworkSettingsActivity.$r8$clinit;
                                            Dispatcher dispatcher = networkSettingsActivity2.getSrvStore$2().accessControlMode$delegate;
                                            KProperty kProperty8 = ServiceStore.$$delegatedProperties[2];
                                            dispatcher.setValue((AccessControlMode) obj3);
                                            break;
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            gapComposer2.updateRememberedValue(objRememberedValue3);
                        }
                        Function1 function2 = (Function1) objRememberedValue3;
                        gapComposer2.end(false);
                        gapComposer2.startReplaceGroup(-846587424);
                        boolean zChangedInstance3 = gapComposer2.changedInstance(networkSettingsActivity);
                        Object objRememberedValue4 = gapComposer2.rememberedValue();
                        if (zChangedInstance3 || objRememberedValue4 == neverEqualPolicy) {
                            final int i3 = 2;
                            objRememberedValue4 = new Function1() { // from class: com.github.kr328.clash.NetworkSettingsActivity$onCreate$1$1$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj3) {
                                    int i4 = i3;
                                    NetworkSettingsActivity networkSettingsActivity2 = networkSettingsActivity;
                                    switch (i4) {
                                        case 0:
                                            Boolean bool = (Boolean) obj3;
                                            bool.getClass();
                                            int i5 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar = ((UiStore) networkSettingsActivity2.uiStore$delegate.getValue()).enableVpn$delegate;
                                            KProperty kProperty = UiStore.$$delegatedProperties[0];
                                            zzrVar.setValue(bool);
                                            break;
                                        case 1:
                                            Boolean bool2 = (Boolean) obj3;
                                            bool2.getClass();
                                            int i6 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar2 = networkSettingsActivity2.getSrvStore$2().bypassPrivateNetwork$delegate;
                                            KProperty kProperty2 = ServiceStore.$$delegatedProperties[1];
                                            zzrVar2.setValue(bool2);
                                            break;
                                        case 2:
                                            Boolean bool3 = (Boolean) obj3;
                                            bool3.getClass();
                                            int i7 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar3 = networkSettingsActivity2.getSrvStore$2().dnsHijacking$delegate;
                                            KProperty kProperty3 = ServiceStore.$$delegatedProperties[4];
                                            zzrVar3.setValue(bool3);
                                            break;
                                        case 3:
                                            Boolean bool4 = (Boolean) obj3;
                                            bool4.getClass();
                                            int i8 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar4 = networkSettingsActivity2.getSrvStore$2().allowBypass$delegate;
                                            KProperty kProperty4 = ServiceStore.$$delegatedProperties[6];
                                            zzrVar4.setValue(bool4);
                                            break;
                                        case 4:
                                            Boolean bool5 = (Boolean) obj3;
                                            bool5.getClass();
                                            int i9 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar5 = networkSettingsActivity2.getSrvStore$2().allowIpv6$delegate;
                                            KProperty kProperty5 = ServiceStore.$$delegatedProperties[7];
                                            zzrVar5.setValue(bool5);
                                            break;
                                        case 5:
                                            Boolean bool6 = (Boolean) obj3;
                                            bool6.getClass();
                                            int i10 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar6 = networkSettingsActivity2.getSrvStore$2().systemProxy$delegate;
                                            KProperty kProperty6 = ServiceStore.$$delegatedProperties[5];
                                            zzrVar6.setValue(bool6);
                                            break;
                                        case 6:
                                            int i11 = NetworkSettingsActivity.$r8$clinit;
                                            ImageLoader$Builder imageLoader$Builder = networkSettingsActivity2.getSrvStore$2().tunStackMode$delegate;
                                            KProperty kProperty7 = ServiceStore.$$delegatedProperties[8];
                                            MemoryCacheService memoryCacheService = (MemoryCacheService) ((Parameters.Builder) imageLoader$Builder.applicationContext).entries;
                                            String str = (String) imageLoader$Builder.defaults;
                                            SharedPreferences.Editor editorEdit = ((SharedPreferences) memoryCacheService.imageLoader).edit();
                                            editorEdit.putString(str, (String) obj3);
                                            editorEdit.apply();
                                            break;
                                        default:
                                            int i12 = NetworkSettingsActivity.$r8$clinit;
                                            Dispatcher dispatcher = networkSettingsActivity2.getSrvStore$2().accessControlMode$delegate;
                                            KProperty kProperty8 = ServiceStore.$$delegatedProperties[2];
                                            dispatcher.setValue((AccessControlMode) obj3);
                                            break;
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            gapComposer2.updateRememberedValue(objRememberedValue4);
                        }
                        Function1 function3 = (Function1) objRememberedValue4;
                        gapComposer2.end(false);
                        gapComposer2.startReplaceGroup(-846585057);
                        boolean zChangedInstance4 = gapComposer2.changedInstance(networkSettingsActivity);
                        Object objRememberedValue5 = gapComposer2.rememberedValue();
                        if (zChangedInstance4 || objRememberedValue5 == neverEqualPolicy) {
                            final int i4 = 3;
                            objRememberedValue5 = new Function1() { // from class: com.github.kr328.clash.NetworkSettingsActivity$onCreate$1$1$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj3) {
                                    int i5 = i4;
                                    NetworkSettingsActivity networkSettingsActivity2 = networkSettingsActivity;
                                    switch (i5) {
                                        case 0:
                                            Boolean bool = (Boolean) obj3;
                                            bool.getClass();
                                            int i6 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar = ((UiStore) networkSettingsActivity2.uiStore$delegate.getValue()).enableVpn$delegate;
                                            KProperty kProperty = UiStore.$$delegatedProperties[0];
                                            zzrVar.setValue(bool);
                                            break;
                                        case 1:
                                            Boolean bool2 = (Boolean) obj3;
                                            bool2.getClass();
                                            int i7 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar2 = networkSettingsActivity2.getSrvStore$2().bypassPrivateNetwork$delegate;
                                            KProperty kProperty2 = ServiceStore.$$delegatedProperties[1];
                                            zzrVar2.setValue(bool2);
                                            break;
                                        case 2:
                                            Boolean bool3 = (Boolean) obj3;
                                            bool3.getClass();
                                            int i8 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar3 = networkSettingsActivity2.getSrvStore$2().dnsHijacking$delegate;
                                            KProperty kProperty3 = ServiceStore.$$delegatedProperties[4];
                                            zzrVar3.setValue(bool3);
                                            break;
                                        case 3:
                                            Boolean bool4 = (Boolean) obj3;
                                            bool4.getClass();
                                            int i9 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar4 = networkSettingsActivity2.getSrvStore$2().allowBypass$delegate;
                                            KProperty kProperty4 = ServiceStore.$$delegatedProperties[6];
                                            zzrVar4.setValue(bool4);
                                            break;
                                        case 4:
                                            Boolean bool5 = (Boolean) obj3;
                                            bool5.getClass();
                                            int i10 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar5 = networkSettingsActivity2.getSrvStore$2().allowIpv6$delegate;
                                            KProperty kProperty5 = ServiceStore.$$delegatedProperties[7];
                                            zzrVar5.setValue(bool5);
                                            break;
                                        case 5:
                                            Boolean bool6 = (Boolean) obj3;
                                            bool6.getClass();
                                            int i11 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar6 = networkSettingsActivity2.getSrvStore$2().systemProxy$delegate;
                                            KProperty kProperty6 = ServiceStore.$$delegatedProperties[5];
                                            zzrVar6.setValue(bool6);
                                            break;
                                        case 6:
                                            int i12 = NetworkSettingsActivity.$r8$clinit;
                                            ImageLoader$Builder imageLoader$Builder = networkSettingsActivity2.getSrvStore$2().tunStackMode$delegate;
                                            KProperty kProperty7 = ServiceStore.$$delegatedProperties[8];
                                            MemoryCacheService memoryCacheService = (MemoryCacheService) ((Parameters.Builder) imageLoader$Builder.applicationContext).entries;
                                            String str = (String) imageLoader$Builder.defaults;
                                            SharedPreferences.Editor editorEdit = ((SharedPreferences) memoryCacheService.imageLoader).edit();
                                            editorEdit.putString(str, (String) obj3);
                                            editorEdit.apply();
                                            break;
                                        default:
                                            int i13 = NetworkSettingsActivity.$r8$clinit;
                                            Dispatcher dispatcher = networkSettingsActivity2.getSrvStore$2().accessControlMode$delegate;
                                            KProperty kProperty8 = ServiceStore.$$delegatedProperties[2];
                                            dispatcher.setValue((AccessControlMode) obj3);
                                            break;
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            gapComposer2.updateRememberedValue(objRememberedValue5);
                        }
                        Function1 function4 = (Function1) objRememberedValue5;
                        gapComposer2.end(false);
                        gapComposer2.startReplaceGroup(-846582787);
                        boolean zChangedInstance5 = gapComposer2.changedInstance(networkSettingsActivity);
                        Object objRememberedValue6 = gapComposer2.rememberedValue();
                        if (zChangedInstance5 || objRememberedValue6 == neverEqualPolicy) {
                            final int i5 = 4;
                            objRememberedValue6 = new Function1() { // from class: com.github.kr328.clash.NetworkSettingsActivity$onCreate$1$1$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj3) {
                                    int i6 = i5;
                                    NetworkSettingsActivity networkSettingsActivity2 = networkSettingsActivity;
                                    switch (i6) {
                                        case 0:
                                            Boolean bool = (Boolean) obj3;
                                            bool.getClass();
                                            int i7 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar = ((UiStore) networkSettingsActivity2.uiStore$delegate.getValue()).enableVpn$delegate;
                                            KProperty kProperty = UiStore.$$delegatedProperties[0];
                                            zzrVar.setValue(bool);
                                            break;
                                        case 1:
                                            Boolean bool2 = (Boolean) obj3;
                                            bool2.getClass();
                                            int i8 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar2 = networkSettingsActivity2.getSrvStore$2().bypassPrivateNetwork$delegate;
                                            KProperty kProperty2 = ServiceStore.$$delegatedProperties[1];
                                            zzrVar2.setValue(bool2);
                                            break;
                                        case 2:
                                            Boolean bool3 = (Boolean) obj3;
                                            bool3.getClass();
                                            int i9 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar3 = networkSettingsActivity2.getSrvStore$2().dnsHijacking$delegate;
                                            KProperty kProperty3 = ServiceStore.$$delegatedProperties[4];
                                            zzrVar3.setValue(bool3);
                                            break;
                                        case 3:
                                            Boolean bool4 = (Boolean) obj3;
                                            bool4.getClass();
                                            int i10 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar4 = networkSettingsActivity2.getSrvStore$2().allowBypass$delegate;
                                            KProperty kProperty4 = ServiceStore.$$delegatedProperties[6];
                                            zzrVar4.setValue(bool4);
                                            break;
                                        case 4:
                                            Boolean bool5 = (Boolean) obj3;
                                            bool5.getClass();
                                            int i11 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar5 = networkSettingsActivity2.getSrvStore$2().allowIpv6$delegate;
                                            KProperty kProperty5 = ServiceStore.$$delegatedProperties[7];
                                            zzrVar5.setValue(bool5);
                                            break;
                                        case 5:
                                            Boolean bool6 = (Boolean) obj3;
                                            bool6.getClass();
                                            int i12 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar6 = networkSettingsActivity2.getSrvStore$2().systemProxy$delegate;
                                            KProperty kProperty6 = ServiceStore.$$delegatedProperties[5];
                                            zzrVar6.setValue(bool6);
                                            break;
                                        case 6:
                                            int i13 = NetworkSettingsActivity.$r8$clinit;
                                            ImageLoader$Builder imageLoader$Builder = networkSettingsActivity2.getSrvStore$2().tunStackMode$delegate;
                                            KProperty kProperty7 = ServiceStore.$$delegatedProperties[8];
                                            MemoryCacheService memoryCacheService = (MemoryCacheService) ((Parameters.Builder) imageLoader$Builder.applicationContext).entries;
                                            String str = (String) imageLoader$Builder.defaults;
                                            SharedPreferences.Editor editorEdit = ((SharedPreferences) memoryCacheService.imageLoader).edit();
                                            editorEdit.putString(str, (String) obj3);
                                            editorEdit.apply();
                                            break;
                                        default:
                                            int i14 = NetworkSettingsActivity.$r8$clinit;
                                            Dispatcher dispatcher = networkSettingsActivity2.getSrvStore$2().accessControlMode$delegate;
                                            KProperty kProperty8 = ServiceStore.$$delegatedProperties[2];
                                            dispatcher.setValue((AccessControlMode) obj3);
                                            break;
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            gapComposer2.updateRememberedValue(objRememberedValue6);
                        }
                        Function1 function5 = (Function1) objRememberedValue6;
                        gapComposer2.end(false);
                        gapComposer2.startReplaceGroup(-846580513);
                        boolean zChangedInstance6 = gapComposer2.changedInstance(networkSettingsActivity);
                        Object objRememberedValue7 = gapComposer2.rememberedValue();
                        if (zChangedInstance6 || objRememberedValue7 == neverEqualPolicy) {
                            final int i6 = 5;
                            objRememberedValue7 = new Function1() { // from class: com.github.kr328.clash.NetworkSettingsActivity$onCreate$1$1$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj3) {
                                    int i7 = i6;
                                    NetworkSettingsActivity networkSettingsActivity2 = networkSettingsActivity;
                                    switch (i7) {
                                        case 0:
                                            Boolean bool = (Boolean) obj3;
                                            bool.getClass();
                                            int i8 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar = ((UiStore) networkSettingsActivity2.uiStore$delegate.getValue()).enableVpn$delegate;
                                            KProperty kProperty = UiStore.$$delegatedProperties[0];
                                            zzrVar.setValue(bool);
                                            break;
                                        case 1:
                                            Boolean bool2 = (Boolean) obj3;
                                            bool2.getClass();
                                            int i9 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar2 = networkSettingsActivity2.getSrvStore$2().bypassPrivateNetwork$delegate;
                                            KProperty kProperty2 = ServiceStore.$$delegatedProperties[1];
                                            zzrVar2.setValue(bool2);
                                            break;
                                        case 2:
                                            Boolean bool3 = (Boolean) obj3;
                                            bool3.getClass();
                                            int i10 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar3 = networkSettingsActivity2.getSrvStore$2().dnsHijacking$delegate;
                                            KProperty kProperty3 = ServiceStore.$$delegatedProperties[4];
                                            zzrVar3.setValue(bool3);
                                            break;
                                        case 3:
                                            Boolean bool4 = (Boolean) obj3;
                                            bool4.getClass();
                                            int i11 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar4 = networkSettingsActivity2.getSrvStore$2().allowBypass$delegate;
                                            KProperty kProperty4 = ServiceStore.$$delegatedProperties[6];
                                            zzrVar4.setValue(bool4);
                                            break;
                                        case 4:
                                            Boolean bool5 = (Boolean) obj3;
                                            bool5.getClass();
                                            int i12 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar5 = networkSettingsActivity2.getSrvStore$2().allowIpv6$delegate;
                                            KProperty kProperty5 = ServiceStore.$$delegatedProperties[7];
                                            zzrVar5.setValue(bool5);
                                            break;
                                        case 5:
                                            Boolean bool6 = (Boolean) obj3;
                                            bool6.getClass();
                                            int i13 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar6 = networkSettingsActivity2.getSrvStore$2().systemProxy$delegate;
                                            KProperty kProperty6 = ServiceStore.$$delegatedProperties[5];
                                            zzrVar6.setValue(bool6);
                                            break;
                                        case 6:
                                            int i14 = NetworkSettingsActivity.$r8$clinit;
                                            ImageLoader$Builder imageLoader$Builder = networkSettingsActivity2.getSrvStore$2().tunStackMode$delegate;
                                            KProperty kProperty7 = ServiceStore.$$delegatedProperties[8];
                                            MemoryCacheService memoryCacheService = (MemoryCacheService) ((Parameters.Builder) imageLoader$Builder.applicationContext).entries;
                                            String str = (String) imageLoader$Builder.defaults;
                                            SharedPreferences.Editor editorEdit = ((SharedPreferences) memoryCacheService.imageLoader).edit();
                                            editorEdit.putString(str, (String) obj3);
                                            editorEdit.apply();
                                            break;
                                        default:
                                            int i15 = NetworkSettingsActivity.$r8$clinit;
                                            Dispatcher dispatcher = networkSettingsActivity2.getSrvStore$2().accessControlMode$delegate;
                                            KProperty kProperty8 = ServiceStore.$$delegatedProperties[2];
                                            dispatcher.setValue((AccessControlMode) obj3);
                                            break;
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            gapComposer2.updateRememberedValue(objRememberedValue7);
                        }
                        Function1 function6 = (Function1) objRememberedValue7;
                        gapComposer2.end(false);
                        gapComposer2.startReplaceGroup(-846578144);
                        boolean zChangedInstance7 = gapComposer2.changedInstance(networkSettingsActivity);
                        Object objRememberedValue8 = gapComposer2.rememberedValue();
                        if (zChangedInstance7 || objRememberedValue8 == neverEqualPolicy) {
                            final int i7 = 6;
                            objRememberedValue8 = new Function1() { // from class: com.github.kr328.clash.NetworkSettingsActivity$onCreate$1$1$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj3) {
                                    int i8 = i7;
                                    NetworkSettingsActivity networkSettingsActivity2 = networkSettingsActivity;
                                    switch (i8) {
                                        case 0:
                                            Boolean bool = (Boolean) obj3;
                                            bool.getClass();
                                            int i9 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar = ((UiStore) networkSettingsActivity2.uiStore$delegate.getValue()).enableVpn$delegate;
                                            KProperty kProperty = UiStore.$$delegatedProperties[0];
                                            zzrVar.setValue(bool);
                                            break;
                                        case 1:
                                            Boolean bool2 = (Boolean) obj3;
                                            bool2.getClass();
                                            int i10 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar2 = networkSettingsActivity2.getSrvStore$2().bypassPrivateNetwork$delegate;
                                            KProperty kProperty2 = ServiceStore.$$delegatedProperties[1];
                                            zzrVar2.setValue(bool2);
                                            break;
                                        case 2:
                                            Boolean bool3 = (Boolean) obj3;
                                            bool3.getClass();
                                            int i11 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar3 = networkSettingsActivity2.getSrvStore$2().dnsHijacking$delegate;
                                            KProperty kProperty3 = ServiceStore.$$delegatedProperties[4];
                                            zzrVar3.setValue(bool3);
                                            break;
                                        case 3:
                                            Boolean bool4 = (Boolean) obj3;
                                            bool4.getClass();
                                            int i12 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar4 = networkSettingsActivity2.getSrvStore$2().allowBypass$delegate;
                                            KProperty kProperty4 = ServiceStore.$$delegatedProperties[6];
                                            zzrVar4.setValue(bool4);
                                            break;
                                        case 4:
                                            Boolean bool5 = (Boolean) obj3;
                                            bool5.getClass();
                                            int i13 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar5 = networkSettingsActivity2.getSrvStore$2().allowIpv6$delegate;
                                            KProperty kProperty5 = ServiceStore.$$delegatedProperties[7];
                                            zzrVar5.setValue(bool5);
                                            break;
                                        case 5:
                                            Boolean bool6 = (Boolean) obj3;
                                            bool6.getClass();
                                            int i14 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar6 = networkSettingsActivity2.getSrvStore$2().systemProxy$delegate;
                                            KProperty kProperty6 = ServiceStore.$$delegatedProperties[5];
                                            zzrVar6.setValue(bool6);
                                            break;
                                        case 6:
                                            int i15 = NetworkSettingsActivity.$r8$clinit;
                                            ImageLoader$Builder imageLoader$Builder = networkSettingsActivity2.getSrvStore$2().tunStackMode$delegate;
                                            KProperty kProperty7 = ServiceStore.$$delegatedProperties[8];
                                            MemoryCacheService memoryCacheService = (MemoryCacheService) ((Parameters.Builder) imageLoader$Builder.applicationContext).entries;
                                            String str = (String) imageLoader$Builder.defaults;
                                            SharedPreferences.Editor editorEdit = ((SharedPreferences) memoryCacheService.imageLoader).edit();
                                            editorEdit.putString(str, (String) obj3);
                                            editorEdit.apply();
                                            break;
                                        default:
                                            int i16 = NetworkSettingsActivity.$r8$clinit;
                                            Dispatcher dispatcher = networkSettingsActivity2.getSrvStore$2().accessControlMode$delegate;
                                            KProperty kProperty8 = ServiceStore.$$delegatedProperties[2];
                                            dispatcher.setValue((AccessControlMode) obj3);
                                            break;
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            gapComposer2.updateRememberedValue(objRememberedValue8);
                        }
                        Function1 function7 = (Function1) objRememberedValue8;
                        gapComposer2.end(false);
                        gapComposer2.startReplaceGroup(-846575579);
                        boolean zChangedInstance8 = gapComposer2.changedInstance(networkSettingsActivity);
                        Object objRememberedValue9 = gapComposer2.rememberedValue();
                        if (zChangedInstance8 || objRememberedValue9 == neverEqualPolicy) {
                            final int i8 = 7;
                            objRememberedValue9 = new Function1() { // from class: com.github.kr328.clash.NetworkSettingsActivity$onCreate$1$1$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj3) {
                                    int i9 = i8;
                                    NetworkSettingsActivity networkSettingsActivity2 = networkSettingsActivity;
                                    switch (i9) {
                                        case 0:
                                            Boolean bool = (Boolean) obj3;
                                            bool.getClass();
                                            int i10 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar = ((UiStore) networkSettingsActivity2.uiStore$delegate.getValue()).enableVpn$delegate;
                                            KProperty kProperty = UiStore.$$delegatedProperties[0];
                                            zzrVar.setValue(bool);
                                            break;
                                        case 1:
                                            Boolean bool2 = (Boolean) obj3;
                                            bool2.getClass();
                                            int i11 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar2 = networkSettingsActivity2.getSrvStore$2().bypassPrivateNetwork$delegate;
                                            KProperty kProperty2 = ServiceStore.$$delegatedProperties[1];
                                            zzrVar2.setValue(bool2);
                                            break;
                                        case 2:
                                            Boolean bool3 = (Boolean) obj3;
                                            bool3.getClass();
                                            int i12 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar3 = networkSettingsActivity2.getSrvStore$2().dnsHijacking$delegate;
                                            KProperty kProperty3 = ServiceStore.$$delegatedProperties[4];
                                            zzrVar3.setValue(bool3);
                                            break;
                                        case 3:
                                            Boolean bool4 = (Boolean) obj3;
                                            bool4.getClass();
                                            int i13 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar4 = networkSettingsActivity2.getSrvStore$2().allowBypass$delegate;
                                            KProperty kProperty4 = ServiceStore.$$delegatedProperties[6];
                                            zzrVar4.setValue(bool4);
                                            break;
                                        case 4:
                                            Boolean bool5 = (Boolean) obj3;
                                            bool5.getClass();
                                            int i14 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar5 = networkSettingsActivity2.getSrvStore$2().allowIpv6$delegate;
                                            KProperty kProperty5 = ServiceStore.$$delegatedProperties[7];
                                            zzrVar5.setValue(bool5);
                                            break;
                                        case 5:
                                            Boolean bool6 = (Boolean) obj3;
                                            bool6.getClass();
                                            int i15 = NetworkSettingsActivity.$r8$clinit;
                                            zzr zzrVar6 = networkSettingsActivity2.getSrvStore$2().systemProxy$delegate;
                                            KProperty kProperty6 = ServiceStore.$$delegatedProperties[5];
                                            zzrVar6.setValue(bool6);
                                            break;
                                        case 6:
                                            int i16 = NetworkSettingsActivity.$r8$clinit;
                                            ImageLoader$Builder imageLoader$Builder = networkSettingsActivity2.getSrvStore$2().tunStackMode$delegate;
                                            KProperty kProperty7 = ServiceStore.$$delegatedProperties[8];
                                            MemoryCacheService memoryCacheService = (MemoryCacheService) ((Parameters.Builder) imageLoader$Builder.applicationContext).entries;
                                            String str = (String) imageLoader$Builder.defaults;
                                            SharedPreferences.Editor editorEdit = ((SharedPreferences) memoryCacheService.imageLoader).edit();
                                            editorEdit.putString(str, (String) obj3);
                                            editorEdit.apply();
                                            break;
                                        default:
                                            int i17 = NetworkSettingsActivity.$r8$clinit;
                                            Dispatcher dispatcher = networkSettingsActivity2.getSrvStore$2().accessControlMode$delegate;
                                            KProperty kProperty8 = ServiceStore.$$delegatedProperties[2];
                                            dispatcher.setValue((AccessControlMode) obj3);
                                            break;
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            gapComposer2.updateRememberedValue(objRememberedValue9);
                        }
                        Function1 function8 = (Function1) objRememberedValue9;
                        gapComposer2.end(false);
                        gapComposer2.startReplaceGroup(-846572700);
                        boolean zChangedInstance9 = gapComposer2.changedInstance(networkSettingsActivity);
                        Object objRememberedValue10 = gapComposer2.rememberedValue();
                        if (zChangedInstance9 || objRememberedValue10 == neverEqualPolicy) {
                            objRememberedValue10 = new NetworkSettingsActivity$$ExternalSyntheticLambda0(networkSettingsActivity, 2);
                            gapComposer2.updateRememberedValue(objRememberedValue10);
                        }
                        Function0 function0 = (Function0) objRememberedValue10;
                        gapComposer2.end(false);
                        gapComposer2.startReplaceGroup(-846594354);
                        boolean zChangedInstance10 = gapComposer2.changedInstance(networkSettingsActivity);
                        Object objRememberedValue11 = gapComposer2.rememberedValue();
                        if (zChangedInstance10 || objRememberedValue11 == neverEqualPolicy) {
                            objRememberedValue11 = new NetworkSettingsActivity$$ExternalSyntheticLambda0(networkSettingsActivity, 3);
                            gapComposer2.updateRememberedValue(objRememberedValue11);
                        }
                        Function0 function9 = (Function0) objRememberedValue11;
                        gapComposer2.end(false);
                        gapComposer2.startReplaceGroup(-846567998);
                        boolean zChanged = gapComposer2.changed(string);
                        Object objRememberedValue12 = gapComposer2.rememberedValue();
                        if (zChanged || objRememberedValue12 == neverEqualPolicy) {
                            objRememberedValue12 = new AppSettingsActivity$onCreate$1$1$8$1(snackbarHostState, string, null, 1);
                            gapComposer2.updateRememberedValue(objRememberedValue12);
                        }
                        gapComposer2.end(false);
                        zzjd.NetworkSettingsScreen(this.$initial, function1, function2, function3, function4, function5, function6, function7, function8, function0, function9, (Function1) objRememberedValue12, snackbarHostState, null, gapComposer2, 0);
                    }
                    break;
            }
            return Unit.INSTANCE;
        }
    }

    public final ServiceStore getSrvStore$2() {
        return (ServiceStore) this.srvStore$delegate.getValue();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        boolean z = Remote.broadcasts.closed;
        zzr zzrVar = ((UiStore) this.uiStore$delegate.getValue()).enableVpn$delegate;
        boolean zBooleanValue = false;
        KProperty kProperty = UiStore.$$delegatedProperties[0];
        boolean zBooleanValue2 = ((Boolean) zzrVar.getValue()).booleanValue();
        boolean bypassPrivateNetwork = getSrvStore$2().getBypassPrivateNetwork();
        zzr zzrVar2 = getSrvStore$2().dnsHijacking$delegate;
        KProperty[] kPropertyArr = ServiceStore.$$delegatedProperties;
        KProperty kProperty2 = kPropertyArr[4];
        boolean zBooleanValue3 = ((Boolean) zzrVar2.getValue()).booleanValue();
        zzr zzrVar3 = getSrvStore$2().allowBypass$delegate;
        KProperty kProperty3 = kPropertyArr[6];
        boolean zBooleanValue4 = ((Boolean) zzrVar3.getValue()).booleanValue();
        boolean allowIpv6 = getSrvStore$2().getAllowIpv6();
        if (Build.VERSION.SDK_INT >= 29) {
            zzr zzrVar4 = getSrvStore$2().systemProxy$delegate;
            KProperty kProperty4 = kPropertyArr[5];
            zBooleanValue = ((Boolean) zzrVar4.getValue()).booleanValue();
        }
        ImageLoader$Builder imageLoader$Builder = getSrvStore$2().tunStackMode$delegate;
        KProperty kProperty5 = kPropertyArr[8];
        MemoryCacheService memoryCacheService = (MemoryCacheService) ((Parameters.Builder) imageLoader$Builder.applicationContext).entries;
        String string = ((SharedPreferences) memoryCacheService.imageLoader).getString((String) imageLoader$Builder.defaults, (String) imageLoader$Builder.options);
        Dispatcher dispatcher = getSrvStore$2().accessControlMode$delegate;
        KProperty kProperty6 = kPropertyArr[2];
        ComponentActivityKt.setContent$default(this, new ComposableLambdaImpl(736197241, new AnonymousClass1(this, new NetworkSettingsState(zBooleanValue2, bypassPrivateNetwork, zBooleanValue3, zBooleanValue4, allowIpv6, zBooleanValue, string, (AccessControlMode) dispatcher.getValue(), z), 0), true));
    }
}
