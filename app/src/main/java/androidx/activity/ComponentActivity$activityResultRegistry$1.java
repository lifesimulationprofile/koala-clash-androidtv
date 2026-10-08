package androidx.activity;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultRegistry$CallbackAndContract;
import androidx.activity.result.ActivityResultRegistry$LifecycleContainer;
import androidx.activity.result.ActivityResultRegistry$register$2;
import androidx.activity.result.IntentSenderRequest;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleCompat;
import androidx.fragment.app.FragmentManagerImpl;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.profileinstaller.DeviceProfileWriter$$ExternalSyntheticLambda0;
import coil.disk.DiskLruCache$$ExternalSyntheticLambda0;
import io.github.g00fy2.quickie.QRScannerActivity;
import io.github.g00fy2.quickie.ScanQRCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.sequences.ConstrainedOnceSequence;
import kotlin.sequences.GeneratorSequence;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ComponentActivity$activityResultRegistry$1 {
    public final /* synthetic */ AppCompatActivity this$0;
    public final LinkedHashMap rcToKey = new LinkedHashMap();
    public final LinkedHashMap keyToRc = new LinkedHashMap();
    public final LinkedHashMap keyToLifecycleContainers = new LinkedHashMap();
    public final ArrayList launchedKeys = new ArrayList();
    public final transient LinkedHashMap keyToCallback = new LinkedHashMap();
    public final LinkedHashMap parsedPendingResults = new LinkedHashMap();
    public final Bundle pendingResults = new Bundle();

    public ComponentActivity$activityResultRegistry$1(AppCompatActivity appCompatActivity) {
        this.this$0 = appCompatActivity;
    }

    public final boolean dispatchResult(int i, int i2, Intent intent) {
        String str = (String) this.rcToKey.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        ActivityResultRegistry$CallbackAndContract activityResultRegistry$CallbackAndContract = (ActivityResultRegistry$CallbackAndContract) this.keyToCallback.get(str);
        if ((activityResultRegistry$CallbackAndContract != null ? activityResultRegistry$CallbackAndContract.callback : null) != null) {
            ArrayList arrayList = this.launchedKeys;
            if (arrayList.contains(str)) {
                activityResultRegistry$CallbackAndContract.callback.onActivityResult(activityResultRegistry$CallbackAndContract.contract.parseResult(i2, intent));
                arrayList.remove(str);
                return true;
            }
        }
        this.parsedPendingResults.remove(str);
        this.pendingResults.putParcelable(str, new ActivityResult(i2, intent));
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:4:0x000a  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void onLaunch(int i, ScanQRCode scanQRCode, Object obj) {
        PreviewView.AnonymousClass1 anonymousClass1;
        Intent intent;
        int i2;
        Bundle bundleExtra;
        int i3 = scanQRCode.$r8$classId;
        int i4 = 1;
        Bundle bundleExtra2 = null;
        AppCompatActivity appCompatActivity = this.this$0;
        switch (i3) {
            case 1:
                anonymousClass1 = null;
                break;
            case 2:
                anonymousClass1 = null;
                break;
            case 3:
                String[] strArr = (String[]) obj;
                if (strArr.length == 0) {
                    anonymousClass1 = new PreviewView.AnonymousClass1(i4, EmptyMap.INSTANCE);
                } else {
                    int length = strArr.length;
                    int i5 = 0;
                    while (true) {
                        if (i5 >= length) {
                            int iMapCapacity = MapsKt__MapsKt.mapCapacity(strArr.length);
                            if (iMapCapacity < 16) {
                                iMapCapacity = 16;
                            }
                            LinkedHashMap linkedHashMap = new LinkedHashMap(iMapCapacity);
                            for (String str : strArr) {
                                linkedHashMap.put(str, Boolean.TRUE);
                            }
                            anonymousClass1 = new PreviewView.AnonymousClass1(i4, linkedHashMap);
                        } else if (ContextCompat.checkSelfPermission(appCompatActivity, strArr[i5]) != 0) {
                            anonymousClass1 = null;
                        } else {
                            i5++;
                        }
                    }
                }
                break;
            case 4:
                if (ContextCompat.checkSelfPermission(appCompatActivity, (String) obj) == 0) {
                    anonymousClass1 = new PreviewView.AnonymousClass1(i4, Boolean.TRUE);
                } else {
                    anonymousClass1 = null;
                }
                break;
            default:
                anonymousClass1 = null;
                break;
        }
        if (anonymousClass1 != null) {
            new Handler(Looper.getMainLooper()).post(new DeviceProfileWriter$$ExternalSyntheticLambda0(i, 1, this, anonymousClass1));
            return;
        }
        switch (scanQRCode.$r8$classId) {
            case 0:
                intent = new Intent(appCompatActivity, (Class<?>) QRScannerActivity.class);
                break;
            case 1:
                intent = new Intent("android.intent.action.CREATE_DOCUMENT").setType("text/plain").putExtra("android.intent.extra.TITLE", (String) obj);
                break;
            case 2:
                intent = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType((String) obj);
                break;
            case 3:
                intent = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", (String[]) obj);
                break;
            case 4:
                intent = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", new String[]{(String) obj});
                break;
            case 5:
                intent = (Intent) obj;
                break;
            default:
                IntentSenderRequest intentSenderRequest = (IntentSenderRequest) obj;
                intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
                Intent intent2 = intentSenderRequest.fillInIntent;
                if (intent2 != null && (bundleExtra = intent2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                    intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                    intent2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                    if (intent2.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                        intentSenderRequest = new IntentSenderRequest(intentSenderRequest.intentSender, null, intentSenderRequest.flagsMask, intentSenderRequest.flagsValues);
                    }
                }
                intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", intentSenderRequest);
                if (FragmentManagerImpl.isLoggingEnabled(2)) {
                    Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
                }
                break;
        }
        if (intent.getExtras() != null && intent.getExtras().getClassLoader() == null) {
            intent.setExtrasClassLoader(appCompatActivity.getClassLoader());
        }
        if (intent.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
            bundleExtra2 = intent.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            intent.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
        }
        Bundle bundle = bundleExtra2;
        if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(intent.getAction())) {
            String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            if (stringArrayExtra == null) {
                stringArrayExtra = new String[0];
            }
            HashSet hashSet = new HashSet();
            for (int i6 = 0; i6 < stringArrayExtra.length; i6++) {
                if (TextUtils.isEmpty(stringArrayExtra[i6])) {
                    throw new IllegalArgumentException(ImageAnalysis$$ExternalSyntheticLambda1.m(new StringBuilder("Permission request for permissions "), Arrays.toString(stringArrayExtra), " must not contain null or empty values"));
                }
                if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(stringArrayExtra[i6], "android.permission.POST_NOTIFICATIONS")) {
                    hashSet.add(Integer.valueOf(i6));
                }
            }
            int size = hashSet.size();
            String[] strArr2 = size > 0 ? new String[stringArrayExtra.length - size] : stringArrayExtra;
            if (size > 0) {
                if (size == stringArrayExtra.length) {
                    return;
                }
                int i7 = 0;
                for (int i8 = 0; i8 < stringArrayExtra.length; i8++) {
                    if (!hashSet.contains(Integer.valueOf(i8))) {
                        strArr2[i7] = stringArrayExtra[i8];
                        i7++;
                    }
                }
            }
            appCompatActivity.requestPermissions(stringArrayExtra, i);
            return;
        }
        if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(intent.getAction())) {
            appCompatActivity.startActivityForResult(intent, i, bundle);
            return;
        }
        IntentSenderRequest intentSenderRequest2 = (IntentSenderRequest) intent.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
        try {
            i2 = i;
            try {
                appCompatActivity.startIntentSenderForResult(intentSenderRequest2.intentSender, i2, intentSenderRequest2.fillInIntent, intentSenderRequest2.flagsMask, intentSenderRequest2.flagsValues, 0, bundle);
                Unit unit = Unit.INSTANCE;
            } catch (IntentSender.SendIntentException e) {
                e = e;
                new Handler(Looper.getMainLooper()).post(new DeviceProfileWriter$$ExternalSyntheticLambda0(i2, 2, this, e));
            }
        } catch (IntentSender.SendIntentException e2) {
            e = e2;
            i2 = i;
        }
    }

    public final ActivityResultRegistry$register$2 register(String str, ScanQRCode scanQRCode, ActivityResultCallback activityResultCallback) {
        registerKey(str);
        this.keyToCallback.put(str, new ActivityResultRegistry$CallbackAndContract(activityResultCallback, scanQRCode));
        LinkedHashMap linkedHashMap = this.parsedPendingResults;
        if (linkedHashMap.containsKey(str)) {
            Object obj = linkedHashMap.get(str);
            linkedHashMap.remove(str);
            activityResultCallback.onActivityResult(obj);
        }
        Bundle bundle = this.pendingResults;
        ActivityResult activityResult = (ActivityResult) BundleCompat.getParcelable(str, bundle);
        if (activityResult != null) {
            bundle.remove(str);
            activityResultCallback.onActivityResult(scanQRCode.parseResult(activityResult.resultCode, activityResult.data));
        }
        return new ActivityResultRegistry$register$2(this, str, scanQRCode, 1);
    }

    public final void registerKey(String str) {
        LinkedHashMap linkedHashMap = this.keyToRc;
        if (((Integer) linkedHashMap.get(str)) != null) {
            return;
        }
        ImmLeaksCleaner$$ExternalSyntheticLambda0 immLeaksCleaner$$ExternalSyntheticLambda0 = new ImmLeaksCleaner$$ExternalSyntheticLambda0(5);
        for (Number number : new ConstrainedOnceSequence(new GeneratorSequence(immLeaksCleaner$$ExternalSyntheticLambda0, new DiskLruCache$$ExternalSyntheticLambda0(19, immLeaksCleaner$$ExternalSyntheticLambda0), 0))) {
            Integer numValueOf = Integer.valueOf(number.intValue());
            LinkedHashMap linkedHashMap2 = this.rcToKey;
            if (!linkedHashMap2.containsKey(numValueOf)) {
                int iIntValue = number.intValue();
                linkedHashMap2.put(Integer.valueOf(iIntValue), str);
                linkedHashMap.put(str, Integer.valueOf(iIntValue));
                return;
            }
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    public final void unregister$activity(String str) {
        Integer num;
        if (!this.launchedKeys.contains(str) && (num = (Integer) this.keyToRc.remove(str)) != null) {
            this.rcToKey.remove(num);
        }
        this.keyToCallback.remove(str);
        LinkedHashMap linkedHashMap = this.parsedPendingResults;
        if (linkedHashMap.containsKey(str)) {
            StringBuilder sbM16m = ImageAnalysis$$ExternalSyntheticLambda1.m16m("Dropping pending result for request ", str, ": ");
            sbM16m.append(linkedHashMap.get(str));
            Log.w("ActivityResultRegistry", sbM16m.toString());
            linkedHashMap.remove(str);
        }
        Bundle bundle = this.pendingResults;
        if (bundle.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + ((ActivityResult) BundleCompat.getParcelable(str, bundle)));
            bundle.remove(str);
        }
        LinkedHashMap linkedHashMap2 = this.keyToLifecycleContainers;
        ActivityResultRegistry$LifecycleContainer activityResultRegistry$LifecycleContainer = (ActivityResultRegistry$LifecycleContainer) linkedHashMap2.get(str);
        if (activityResultRegistry$LifecycleContainer != null) {
            ArrayList arrayList = activityResultRegistry$LifecycleContainer.observers;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                activityResultRegistry$LifecycleContainer.lifecycle.removeObserver((LifecycleEventObserver) obj);
            }
            arrayList.clear();
            linkedHashMap2.remove(str);
        }
    }
}
