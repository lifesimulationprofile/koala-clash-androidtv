package com.github.kr328.clash;

import android.app.Activity;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.activity.compose.ComponentActivityKt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.core.content.pm.ShortcutManagerCompat;
import com.github.kr328.clash.common.util.ComponentsKt;
import com.github.kr328.clash.compose.settings.AppSettingsState;
import com.github.kr328.clash.design.compose.theme.AppThemeKt;
import com.github.kr328.clash.design.model.DarkMode;
import com.github.kr328.clash.design.store.UiStore;
import com.github.kr328.clash.remote.Remote;
import com.github.kr328.clash.service.store.ServiceStore;
import com.github.kr328.clash.store.AppStore;
import com.github.kr328.clash.util.ApplicationObserver;
import com.google.android.gms.internal.mlkit_vision_common.zzjc;
import com.google.android.gms.tasks.zzr;
import com.koala.clash.R;
import java.util.Iterator;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.JobKt__JobKt$invokeOnCompletion$1;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AppSettingsActivity extends AppCompatActivity {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final SynchronizedLazyImpl uiStore$delegate = new SynchronizedLazyImpl(new AppSettingsActivity$$ExternalSyntheticLambda0(this, 0));
    public final SynchronizedLazyImpl srvStore$delegate = new SynchronizedLazyImpl(new AppSettingsActivity$$ExternalSyntheticLambda0(this, 1));
    public final SynchronizedLazyImpl appStore$delegate = new SynchronizedLazyImpl(new AppSettingsActivity$$ExternalSyntheticLambda0(this, 2));

    /* JADX INFO: renamed from: com.github.kr328.clash.AppSettingsActivity$onCreate$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 implements Function2 {
        public final /* synthetic */ AppSettingsState $initial;
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ AppSettingsActivity this$0;

        public /* synthetic */ AnonymousClass1(AppSettingsActivity appSettingsActivity, AppSettingsState appSettingsState, int i) {
            this.$r8$classId = i;
            this.this$0 = appSettingsActivity;
            this.$initial = appSettingsState;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            switch (this.$r8$classId) {
                case 0:
                    GapComposer gapComposer = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
                        gapComposer.skipToGroupEnd();
                    } else {
                        AppThemeKt.AppTheme(false, Thread_jvmKt.rememberComposableLambda(1418514761, new AnonymousClass1(this.this$0, this.$initial, 1), gapComposer), gapComposer, 48);
                    }
                    break;
                default:
                    GapComposer gapComposer2 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        gapComposer2.startReplaceGroup(956886991);
                        Object objRememberedValue = gapComposer2.rememberedValue();
                        NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
                        if (objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = new SnackbarHostState();
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        }
                        SnackbarHostState snackbarHostState = (SnackbarHostState) objRememberedValue;
                        gapComposer2.end(false);
                        final AppSettingsActivity appSettingsActivity = this.this$0;
                        String string = appSettingsActivity.getString(R.string.options_unavailable);
                        gapComposer2.startReplaceGroup(956898049);
                        boolean zChangedInstance = gapComposer2.changedInstance(appSettingsActivity);
                        Object objRememberedValue2 = gapComposer2.rememberedValue();
                        if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                            JobKt__JobKt$invokeOnCompletion$1 jobKt__JobKt$invokeOnCompletion$1 = new JobKt__JobKt$invokeOnCompletion$1(1, appSettingsActivity, AppSettingsActivity.class, "writeAutoRestart", "writeAutoRestart(Z)V", 0, 0, 5);
                            gapComposer2.updateRememberedValue(jobKt__JobKt$invokeOnCompletion$1);
                            objRememberedValue2 = jobKt__JobKt$invokeOnCompletion$1;
                        }
                        gapComposer2.end(false);
                        Function1 function1 = (Function1) ((FunctionReferenceImpl) objRememberedValue2);
                        gapComposer2.startReplaceGroup(956900058);
                        boolean zChangedInstance2 = gapComposer2.changedInstance(appSettingsActivity);
                        Object objRememberedValue3 = gapComposer2.rememberedValue();
                        if (zChangedInstance2 || objRememberedValue3 == neverEqualPolicy) {
                            final int i = 0;
                            objRememberedValue3 = new Function1() { // from class: com.github.kr328.clash.AppSettingsActivity$onCreate$1$1$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj3) {
                                    int i2 = i;
                                    AppSettingsActivity appSettingsActivity2 = appSettingsActivity;
                                    switch (i2) {
                                        case 0:
                                            DarkMode darkMode = (DarkMode) obj3;
                                            int i3 = AppSettingsActivity.$r8$clinit;
                                            Dispatcher dispatcher = appSettingsActivity2.getUiStore$1().darkMode$delegate;
                                            KProperty kProperty = UiStore.$$delegatedProperties[1];
                                            dispatcher.setValue(darkMode);
                                            int i4 = MainApplication.$r8$clinit;
                                            MainApplication.Companion.applyDarkMode(darkMode);
                                            break;
                                        case 1:
                                            Boolean bool = (Boolean) obj3;
                                            boolean zBooleanValue = bool.booleanValue();
                                            int i5 = AppSettingsActivity.$r8$clinit;
                                            zzr zzrVar = appSettingsActivity2.getUiStore$1().hideAppIcon$delegate;
                                            KProperty kProperty2 = UiStore.$$delegatedProperties[2];
                                            zzrVar.setValue(bool);
                                            int i6 = zBooleanValue ? 2 : 1;
                                            PackageManager packageManager = appSettingsActivity2.getPackageManager();
                                            UiStore.Companion.getClass();
                                            packageManager.setComponentEnabledSetting(new ComponentName(appSettingsActivity2, "com.github.kr328.clash.MainActivityAlias"), i6, 1);
                                            if (zBooleanValue) {
                                                ShortcutManagerCompat.removeAllDynamicShortcuts(appSettingsActivity2);
                                            }
                                            break;
                                        case 2:
                                            Boolean bool2 = (Boolean) obj3;
                                            bool2.getClass();
                                            int i7 = AppSettingsActivity.$r8$clinit;
                                            zzr zzrVar2 = appSettingsActivity2.getUiStore$1().hideFromRecents$delegate;
                                            KProperty kProperty3 = UiStore.$$delegatedProperties[3];
                                            zzrVar2.setValue(bool2);
                                            Iterator it = ApplicationObserver._createdActivities.iterator();
                                            while (it.hasNext()) {
                                                ((Activity) it.next()).recreate();
                                            }
                                            break;
                                        case 3:
                                            Boolean bool3 = (Boolean) obj3;
                                            bool3.getClass();
                                            int i8 = AppSettingsActivity.$r8$clinit;
                                            zzr zzrVar3 = ((ServiceStore) appSettingsActivity2.srvStore$delegate.getValue()).dynamicNotification$delegate;
                                            KProperty kProperty4 = ServiceStore.$$delegatedProperties[9];
                                            zzrVar3.setValue(bool3);
                                            break;
                                        default:
                                            Boolean bool4 = (Boolean) obj3;
                                            bool4.getClass();
                                            int i9 = AppSettingsActivity.$r8$clinit;
                                            zzr zzrVar4 = ((AppStore) appSettingsActivity2.appStore$delegate.getValue()).autoCheckUpdate$delegate;
                                            KProperty kProperty5 = AppStore.$$delegatedProperties[1];
                                            zzrVar4.setValue(bool4);
                                            break;
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            gapComposer2.updateRememberedValue(objRememberedValue3);
                        }
                        Function1 function2 = (Function1) objRememberedValue3;
                        gapComposer2.end(false);
                        gapComposer2.startReplaceGroup(956905910);
                        boolean zChangedInstance3 = gapComposer2.changedInstance(appSettingsActivity);
                        Object objRememberedValue4 = gapComposer2.rememberedValue();
                        if (zChangedInstance3 || objRememberedValue4 == neverEqualPolicy) {
                            final int i2 = 1;
                            objRememberedValue4 = new Function1() { // from class: com.github.kr328.clash.AppSettingsActivity$onCreate$1$1$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj3) {
                                    int i3 = i2;
                                    AppSettingsActivity appSettingsActivity2 = appSettingsActivity;
                                    switch (i3) {
                                        case 0:
                                            DarkMode darkMode = (DarkMode) obj3;
                                            int i4 = AppSettingsActivity.$r8$clinit;
                                            Dispatcher dispatcher = appSettingsActivity2.getUiStore$1().darkMode$delegate;
                                            KProperty kProperty = UiStore.$$delegatedProperties[1];
                                            dispatcher.setValue(darkMode);
                                            int i5 = MainApplication.$r8$clinit;
                                            MainApplication.Companion.applyDarkMode(darkMode);
                                            break;
                                        case 1:
                                            Boolean bool = (Boolean) obj3;
                                            boolean zBooleanValue = bool.booleanValue();
                                            int i6 = AppSettingsActivity.$r8$clinit;
                                            zzr zzrVar = appSettingsActivity2.getUiStore$1().hideAppIcon$delegate;
                                            KProperty kProperty2 = UiStore.$$delegatedProperties[2];
                                            zzrVar.setValue(bool);
                                            int i7 = zBooleanValue ? 2 : 1;
                                            PackageManager packageManager = appSettingsActivity2.getPackageManager();
                                            UiStore.Companion.getClass();
                                            packageManager.setComponentEnabledSetting(new ComponentName(appSettingsActivity2, "com.github.kr328.clash.MainActivityAlias"), i7, 1);
                                            if (zBooleanValue) {
                                                ShortcutManagerCompat.removeAllDynamicShortcuts(appSettingsActivity2);
                                            }
                                            break;
                                        case 2:
                                            Boolean bool2 = (Boolean) obj3;
                                            bool2.getClass();
                                            int i8 = AppSettingsActivity.$r8$clinit;
                                            zzr zzrVar2 = appSettingsActivity2.getUiStore$1().hideFromRecents$delegate;
                                            KProperty kProperty3 = UiStore.$$delegatedProperties[3];
                                            zzrVar2.setValue(bool2);
                                            Iterator it = ApplicationObserver._createdActivities.iterator();
                                            while (it.hasNext()) {
                                                ((Activity) it.next()).recreate();
                                            }
                                            break;
                                        case 3:
                                            Boolean bool3 = (Boolean) obj3;
                                            bool3.getClass();
                                            int i9 = AppSettingsActivity.$r8$clinit;
                                            zzr zzrVar3 = ((ServiceStore) appSettingsActivity2.srvStore$delegate.getValue()).dynamicNotification$delegate;
                                            KProperty kProperty4 = ServiceStore.$$delegatedProperties[9];
                                            zzrVar3.setValue(bool3);
                                            break;
                                        default:
                                            Boolean bool4 = (Boolean) obj3;
                                            bool4.getClass();
                                            int i10 = AppSettingsActivity.$r8$clinit;
                                            zzr zzrVar4 = ((AppStore) appSettingsActivity2.appStore$delegate.getValue()).autoCheckUpdate$delegate;
                                            KProperty kProperty5 = AppStore.$$delegatedProperties[1];
                                            zzrVar4.setValue(bool4);
                                            break;
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            gapComposer2.updateRememberedValue(objRememberedValue4);
                        }
                        Function1 function3 = (Function1) objRememberedValue4;
                        gapComposer2.end(false);
                        gapComposer2.startReplaceGroup(956911769);
                        boolean zChangedInstance4 = gapComposer2.changedInstance(appSettingsActivity);
                        Object objRememberedValue5 = gapComposer2.rememberedValue();
                        if (zChangedInstance4 || objRememberedValue5 == neverEqualPolicy) {
                            final int i3 = 2;
                            objRememberedValue5 = new Function1() { // from class: com.github.kr328.clash.AppSettingsActivity$onCreate$1$1$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj3) {
                                    int i4 = i3;
                                    AppSettingsActivity appSettingsActivity2 = appSettingsActivity;
                                    switch (i4) {
                                        case 0:
                                            DarkMode darkMode = (DarkMode) obj3;
                                            int i5 = AppSettingsActivity.$r8$clinit;
                                            Dispatcher dispatcher = appSettingsActivity2.getUiStore$1().darkMode$delegate;
                                            KProperty kProperty = UiStore.$$delegatedProperties[1];
                                            dispatcher.setValue(darkMode);
                                            int i6 = MainApplication.$r8$clinit;
                                            MainApplication.Companion.applyDarkMode(darkMode);
                                            break;
                                        case 1:
                                            Boolean bool = (Boolean) obj3;
                                            boolean zBooleanValue = bool.booleanValue();
                                            int i7 = AppSettingsActivity.$r8$clinit;
                                            zzr zzrVar = appSettingsActivity2.getUiStore$1().hideAppIcon$delegate;
                                            KProperty kProperty2 = UiStore.$$delegatedProperties[2];
                                            zzrVar.setValue(bool);
                                            int i8 = zBooleanValue ? 2 : 1;
                                            PackageManager packageManager = appSettingsActivity2.getPackageManager();
                                            UiStore.Companion.getClass();
                                            packageManager.setComponentEnabledSetting(new ComponentName(appSettingsActivity2, "com.github.kr328.clash.MainActivityAlias"), i8, 1);
                                            if (zBooleanValue) {
                                                ShortcutManagerCompat.removeAllDynamicShortcuts(appSettingsActivity2);
                                            }
                                            break;
                                        case 2:
                                            Boolean bool2 = (Boolean) obj3;
                                            bool2.getClass();
                                            int i9 = AppSettingsActivity.$r8$clinit;
                                            zzr zzrVar2 = appSettingsActivity2.getUiStore$1().hideFromRecents$delegate;
                                            KProperty kProperty3 = UiStore.$$delegatedProperties[3];
                                            zzrVar2.setValue(bool2);
                                            Iterator it = ApplicationObserver._createdActivities.iterator();
                                            while (it.hasNext()) {
                                                ((Activity) it.next()).recreate();
                                            }
                                            break;
                                        case 3:
                                            Boolean bool3 = (Boolean) obj3;
                                            bool3.getClass();
                                            int i10 = AppSettingsActivity.$r8$clinit;
                                            zzr zzrVar3 = ((ServiceStore) appSettingsActivity2.srvStore$delegate.getValue()).dynamicNotification$delegate;
                                            KProperty kProperty4 = ServiceStore.$$delegatedProperties[9];
                                            zzrVar3.setValue(bool3);
                                            break;
                                        default:
                                            Boolean bool4 = (Boolean) obj3;
                                            bool4.getClass();
                                            int i11 = AppSettingsActivity.$r8$clinit;
                                            zzr zzrVar4 = ((AppStore) appSettingsActivity2.appStore$delegate.getValue()).autoCheckUpdate$delegate;
                                            KProperty kProperty5 = AppStore.$$delegatedProperties[1];
                                            zzrVar4.setValue(bool4);
                                            break;
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            gapComposer2.updateRememberedValue(objRememberedValue5);
                        }
                        Function1 function4 = (Function1) objRememberedValue5;
                        gapComposer2.end(false);
                        gapComposer2.startReplaceGroup(956917808);
                        boolean zChangedInstance5 = gapComposer2.changedInstance(appSettingsActivity);
                        Object objRememberedValue6 = gapComposer2.rememberedValue();
                        if (zChangedInstance5 || objRememberedValue6 == neverEqualPolicy) {
                            final int i4 = 3;
                            objRememberedValue6 = new Function1() { // from class: com.github.kr328.clash.AppSettingsActivity$onCreate$1$1$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj3) {
                                    int i5 = i4;
                                    AppSettingsActivity appSettingsActivity2 = appSettingsActivity;
                                    switch (i5) {
                                        case 0:
                                            DarkMode darkMode = (DarkMode) obj3;
                                            int i6 = AppSettingsActivity.$r8$clinit;
                                            Dispatcher dispatcher = appSettingsActivity2.getUiStore$1().darkMode$delegate;
                                            KProperty kProperty = UiStore.$$delegatedProperties[1];
                                            dispatcher.setValue(darkMode);
                                            int i7 = MainApplication.$r8$clinit;
                                            MainApplication.Companion.applyDarkMode(darkMode);
                                            break;
                                        case 1:
                                            Boolean bool = (Boolean) obj3;
                                            boolean zBooleanValue = bool.booleanValue();
                                            int i8 = AppSettingsActivity.$r8$clinit;
                                            zzr zzrVar = appSettingsActivity2.getUiStore$1().hideAppIcon$delegate;
                                            KProperty kProperty2 = UiStore.$$delegatedProperties[2];
                                            zzrVar.setValue(bool);
                                            int i9 = zBooleanValue ? 2 : 1;
                                            PackageManager packageManager = appSettingsActivity2.getPackageManager();
                                            UiStore.Companion.getClass();
                                            packageManager.setComponentEnabledSetting(new ComponentName(appSettingsActivity2, "com.github.kr328.clash.MainActivityAlias"), i9, 1);
                                            if (zBooleanValue) {
                                                ShortcutManagerCompat.removeAllDynamicShortcuts(appSettingsActivity2);
                                            }
                                            break;
                                        case 2:
                                            Boolean bool2 = (Boolean) obj3;
                                            bool2.getClass();
                                            int i10 = AppSettingsActivity.$r8$clinit;
                                            zzr zzrVar2 = appSettingsActivity2.getUiStore$1().hideFromRecents$delegate;
                                            KProperty kProperty3 = UiStore.$$delegatedProperties[3];
                                            zzrVar2.setValue(bool2);
                                            Iterator it = ApplicationObserver._createdActivities.iterator();
                                            while (it.hasNext()) {
                                                ((Activity) it.next()).recreate();
                                            }
                                            break;
                                        case 3:
                                            Boolean bool3 = (Boolean) obj3;
                                            bool3.getClass();
                                            int i11 = AppSettingsActivity.$r8$clinit;
                                            zzr zzrVar3 = ((ServiceStore) appSettingsActivity2.srvStore$delegate.getValue()).dynamicNotification$delegate;
                                            KProperty kProperty4 = ServiceStore.$$delegatedProperties[9];
                                            zzrVar3.setValue(bool3);
                                            break;
                                        default:
                                            Boolean bool4 = (Boolean) obj3;
                                            bool4.getClass();
                                            int i12 = AppSettingsActivity.$r8$clinit;
                                            zzr zzrVar4 = ((AppStore) appSettingsActivity2.appStore$delegate.getValue()).autoCheckUpdate$delegate;
                                            KProperty kProperty5 = AppStore.$$delegatedProperties[1];
                                            zzrVar4.setValue(bool4);
                                            break;
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            gapComposer2.updateRememberedValue(objRememberedValue6);
                        }
                        Function1 function5 = (Function1) objRememberedValue6;
                        gapComposer2.end(false);
                        gapComposer2.startReplaceGroup(956922444);
                        boolean zChangedInstance6 = gapComposer2.changedInstance(appSettingsActivity);
                        Object objRememberedValue7 = gapComposer2.rememberedValue();
                        if (zChangedInstance6 || objRememberedValue7 == neverEqualPolicy) {
                            final int i5 = 4;
                            objRememberedValue7 = new Function1() { // from class: com.github.kr328.clash.AppSettingsActivity$onCreate$1$1$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj3) {
                                    int i6 = i5;
                                    AppSettingsActivity appSettingsActivity2 = appSettingsActivity;
                                    switch (i6) {
                                        case 0:
                                            DarkMode darkMode = (DarkMode) obj3;
                                            int i7 = AppSettingsActivity.$r8$clinit;
                                            Dispatcher dispatcher = appSettingsActivity2.getUiStore$1().darkMode$delegate;
                                            KProperty kProperty = UiStore.$$delegatedProperties[1];
                                            dispatcher.setValue(darkMode);
                                            int i8 = MainApplication.$r8$clinit;
                                            MainApplication.Companion.applyDarkMode(darkMode);
                                            break;
                                        case 1:
                                            Boolean bool = (Boolean) obj3;
                                            boolean zBooleanValue = bool.booleanValue();
                                            int i9 = AppSettingsActivity.$r8$clinit;
                                            zzr zzrVar = appSettingsActivity2.getUiStore$1().hideAppIcon$delegate;
                                            KProperty kProperty2 = UiStore.$$delegatedProperties[2];
                                            zzrVar.setValue(bool);
                                            int i10 = zBooleanValue ? 2 : 1;
                                            PackageManager packageManager = appSettingsActivity2.getPackageManager();
                                            UiStore.Companion.getClass();
                                            packageManager.setComponentEnabledSetting(new ComponentName(appSettingsActivity2, "com.github.kr328.clash.MainActivityAlias"), i10, 1);
                                            if (zBooleanValue) {
                                                ShortcutManagerCompat.removeAllDynamicShortcuts(appSettingsActivity2);
                                            }
                                            break;
                                        case 2:
                                            Boolean bool2 = (Boolean) obj3;
                                            bool2.getClass();
                                            int i11 = AppSettingsActivity.$r8$clinit;
                                            zzr zzrVar2 = appSettingsActivity2.getUiStore$1().hideFromRecents$delegate;
                                            KProperty kProperty3 = UiStore.$$delegatedProperties[3];
                                            zzrVar2.setValue(bool2);
                                            Iterator it = ApplicationObserver._createdActivities.iterator();
                                            while (it.hasNext()) {
                                                ((Activity) it.next()).recreate();
                                            }
                                            break;
                                        case 3:
                                            Boolean bool3 = (Boolean) obj3;
                                            bool3.getClass();
                                            int i12 = AppSettingsActivity.$r8$clinit;
                                            zzr zzrVar3 = ((ServiceStore) appSettingsActivity2.srvStore$delegate.getValue()).dynamicNotification$delegate;
                                            KProperty kProperty4 = ServiceStore.$$delegatedProperties[9];
                                            zzrVar3.setValue(bool3);
                                            break;
                                        default:
                                            Boolean bool4 = (Boolean) obj3;
                                            bool4.getClass();
                                            int i13 = AppSettingsActivity.$r8$clinit;
                                            zzr zzrVar4 = ((AppStore) appSettingsActivity2.appStore$delegate.getValue()).autoCheckUpdate$delegate;
                                            KProperty kProperty5 = AppStore.$$delegatedProperties[1];
                                            zzrVar4.setValue(bool4);
                                            break;
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            gapComposer2.updateRememberedValue(objRememberedValue7);
                        }
                        Function1 function6 = (Function1) objRememberedValue7;
                        gapComposer2.end(false);
                        gapComposer2.startReplaceGroup(956896251);
                        boolean zChangedInstance7 = gapComposer2.changedInstance(appSettingsActivity);
                        Object objRememberedValue8 = gapComposer2.rememberedValue();
                        if (zChangedInstance7 || objRememberedValue8 == neverEqualPolicy) {
                            objRememberedValue8 = new AppSettingsActivity$$ExternalSyntheticLambda0(appSettingsActivity, 3);
                            gapComposer2.updateRememberedValue(objRememberedValue8);
                        }
                        Function0 function0 = (Function0) objRememberedValue8;
                        gapComposer2.end(false);
                        gapComposer2.startReplaceGroup(956926991);
                        boolean zChanged = gapComposer2.changed(string);
                        Object objRememberedValue9 = gapComposer2.rememberedValue();
                        if (zChanged || objRememberedValue9 == neverEqualPolicy) {
                            objRememberedValue9 = new AppSettingsActivity$onCreate$1$1$8$1(snackbarHostState, string, null, 0);
                            gapComposer2.updateRememberedValue(objRememberedValue9);
                        }
                        gapComposer2.end(false);
                        zzjc.AppSettingsScreen(this.$initial, function1, function2, function3, function4, function5, function6, function0, (Function1) objRememberedValue9, snackbarHostState, null, gapComposer2, 805306368);
                    }
                    break;
            }
            return Unit.INSTANCE;
        }
    }

    public final UiStore getUiStore$1() {
        return (UiStore) this.uiStore$delegate.getValue();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        boolean z = getPackageManager().getComponentEnabledSetting(ComponentsKt.getComponentName(Reflection.getOrCreateKotlinClass(RestartReceiver.class))) == 1;
        Dispatcher dispatcher = getUiStore$1().darkMode$delegate;
        KProperty[] kPropertyArr = UiStore.$$delegatedProperties;
        KProperty kProperty = kPropertyArr[1];
        DarkMode darkMode = (DarkMode) dispatcher.getValue();
        zzr zzrVar = getUiStore$1().hideAppIcon$delegate;
        KProperty kProperty2 = kPropertyArr[2];
        boolean zBooleanValue = ((Boolean) zzrVar.getValue()).booleanValue();
        zzr zzrVar2 = getUiStore$1().hideFromRecents$delegate;
        KProperty kProperty3 = kPropertyArr[3];
        boolean zBooleanValue2 = ((Boolean) zzrVar2.getValue()).booleanValue();
        boolean dynamicNotification = ((ServiceStore) this.srvStore$delegate.getValue()).getDynamicNotification();
        boolean z2 = !Remote.broadcasts.closed;
        zzr zzrVar3 = ((AppStore) this.appStore$delegate.getValue()).autoCheckUpdate$delegate;
        KProperty kProperty4 = AppStore.$$delegatedProperties[1];
        ComponentActivityKt.setContent$default(this, new ComposableLambdaImpl(-874770477, new AnonymousClass1(this, new AppSettingsState(z, darkMode, zBooleanValue, zBooleanValue2, dynamicNotification, z2, ((Boolean) zzrVar3.getValue()).booleanValue()), 0), true));
    }
}
