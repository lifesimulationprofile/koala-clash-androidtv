package androidx.navigation.compose;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.animation.core.Transition;
import androidx.compose.foundation.relocation.BringIntoViewResponderNode;
import androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavHostController;
import coil.RealImageLoader$execute$3;
import com.github.kr328.clash.core.model.FetchStatus;
import com.github.kr328.clash.log.LogcatReader$$ExternalSyntheticLambda3;
import com.github.kr328.clash.service.HwidLimitException;
import com.github.kr328.clash.service.ProfileProcessor;
import com.github.kr328.clash.service.model.Profile;
import com.github.kr328.clash.service.util.DeviceInfoKt;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody$Companion$toRequestBody$2;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealCall;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class NavHostKt$NavHost$33$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Object $composeNavigator;
    public final /* synthetic */ Object $navController;
    public final /* synthetic */ int $r8$classId;
    public /* synthetic */ Object $transition;
    public final /* synthetic */ Object $visibleEntries$delegate;
    public final /* synthetic */ Object $zIndices;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavHostKt$NavHost$33$1(BringIntoViewResponderNode bringIntoViewResponderNode, NodeCoordinator nodeCoordinator, DialogHostKt$DialogHost$1$1$1 dialogHostKt$DialogHost$1$1$1, GapComposer$$ExternalSyntheticLambda0 gapComposer$$ExternalSyntheticLambda0, Continuation continuation) {
        super(2, continuation);
        this.$r8$classId = 1;
        this.$navController = bringIntoViewResponderNode;
        this.$zIndices = nodeCoordinator;
        this.$visibleEntries$delegate = dialogHostKt$DialogHost$1$1$1;
        this.$composeNavigator = gapComposer$$ExternalSyntheticLambda0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new NavHostKt$NavHost$33$1((Transition) this.$transition, (NavHostController) this.$navController, (Map) this.$zIndices, (State) this.$visibleEntries$delegate, (ComposeNavigator) this.$composeNavigator, continuation, 0);
            case 1:
                NavHostKt$NavHost$33$1 navHostKt$NavHost$33$1 = new NavHostKt$NavHost$33$1((BringIntoViewResponderNode) this.$navController, (NodeCoordinator) this.$zIndices, (DialogHostKt$DialogHost$1$1$1) this.$visibleEntries$delegate, (GapComposer$$ExternalSyntheticLambda0) this.$composeNavigator, continuation);
                navHostKt$NavHost$33$1.$transition = obj;
                return navHostKt$NavHost$33$1;
            default:
                return new NavHostKt$NavHost$33$1((Profile.Type) this.$transition, (String) this.$navController, (LogcatReader$$ExternalSyntheticLambda3) this.$zIndices, (Context) this.$visibleEntries$delegate, (File) this.$composeNavigator, continuation, 2);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (this.$r8$classId) {
            case 0:
                break;
            case 1:
                break;
        }
        return ((NavHostKt$NavHost$33$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:166:0x0088 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x009f  */
    /* JADX WARN: Code duplicated, block: B:39:0x00c2  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        HttpUrl httpUrlBuild;
        Object failure;
        String str;
        int i = this.$r8$classId;
        Object obj2 = this.$composeNavigator;
        Object obj3 = this.$zIndices;
        Object obj4 = this.$navController;
        Object obj5 = this.$visibleEntries$delegate;
        switch (i) {
            case 0:
                Map map = (Map) obj3;
                NavHostController navHostController = (NavHostController) obj4;
                ResultKt.throwOnFailure(obj);
                Transition transition = (Transition) this.$transition;
                Object objMo773getCurrentState = transition.transitionState.mo773getCurrentState();
                ParcelableSnapshotMutableState parcelableSnapshotMutableState = transition.targetState$delegate;
                if (Intrinsics.areEqual(objMo773getCurrentState, parcelableSnapshotMutableState.getValue()) && (((NavBackStackEntry) navHostController.backQueue.lastOrNull()) == null || Intrinsics.areEqual(parcelableSnapshotMutableState.getValue(), (NavBackStackEntry) navHostController.backQueue.lastOrNull()))) {
                    ComposeNavigator composeNavigator = (ComposeNavigator) obj2;
                    Iterator it = ((List) ((State) obj5).getValue()).iterator();
                    while (it.hasNext()) {
                        composeNavigator.getState().markTransitionComplete((NavBackStackEntry) it.next());
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry entry : map.entrySet()) {
                        if (!Intrinsics.areEqual(entry.getKey(), ((NavBackStackEntry) parcelableSnapshotMutableState.getValue()).id)) {
                            linkedHashMap.put(entry.getKey(), entry.getValue());
                        }
                    }
                    Iterator it2 = linkedHashMap.entrySet().iterator();
                    while (it2.hasNext()) {
                        map.remove(((Map.Entry) it2.next()).getKey());
                    }
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.$transition;
                BringIntoViewResponderNode bringIntoViewResponderNode = (BringIntoViewResponderNode) obj4;
                Continuation continuation = null;
                JobKt.launch$default(coroutineScope, null, new NavHostKt$NavHost$28$1(bringIntoViewResponderNode, (NodeCoordinator) obj3, (DialogHostKt$DialogHost$1$1$1) obj5, continuation, 15), 3);
                return JobKt.launch$default(coroutineScope, null, new RealImageLoader$execute$3(bringIntoViewResponderNode, (GapComposer$$ExternalSyntheticLambda0) obj2, continuation, 10), 3);
            default:
                Context context = (Context) obj5;
                String str2 = (String) obj4;
                ResultKt.throwOnFailure(obj);
                String str3 = null;
                if (((Profile.Type) this.$transition) == Profile.Type.File || str2.length() == 0) {
                    return null;
                }
                try {
                    HttpUrl.Builder builder = new HttpUrl.Builder();
                    builder.parse$okhttp(null, str2);
                    httpUrlBuild = builder.build();
                } catch (IllegalArgumentException unused) {
                    httpUrlBuild = null;
                }
                if (httpUrlBuild == null) {
                    throw new IllegalArgumentException("Unsupported url: ".concat(str2));
                }
                ((LogcatReader$$ExternalSyntheticLambda3) obj3).invoke(new FetchStatus(Collections.singletonList(httpUrlBuild.host)));
                boolean z = false;
                String str4 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                if (str4 == null) {
                    str4 = "unknown";
                }
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                Headers.Builder builder2 = new Headers.Builder(0);
                builder2.set("User-Agent", "koala-clash/".concat(str4));
                SharedPreferences sharedPreferences = context.getSharedPreferences("device_info", 0);
                String string = sharedPreferences.getString("hwid", null);
                if (string == null) {
                    try {
                        failure = Settings.Secure.getString(context.getContentResolver(), "android_id");
                    } catch (Throwable th) {
                        failure = new Result.Failure(th);
                    }
                    if (failure instanceof Result.Failure) {
                        failure = null;
                    }
                    str = (String) failure;
                    if (str != null || StringsKt.isBlank(str) || str.equals("9774d56d682e549c")) {
                        string = UUID.randomUUID().toString();
                    } else {
                        string = UUID.nameUUIDFromBytes(str.getBytes(Charsets.UTF_8)).toString();
                    }
                    sharedPreferences.edit().putString("hwid", string).apply();
                } else {
                    if (StringsKt.isBlank(string)) {
                        string = null;
                    }
                    if (string == null) {
                        failure = Settings.Secure.getString(context.getContentResolver(), "android_id");
                        if (failure instanceof Result.Failure) {
                            failure = null;
                        }
                        str = (String) failure;
                        if (str != null) {
                            string = UUID.randomUUID().toString();
                        } else {
                            string = UUID.randomUUID().toString();
                        }
                        sharedPreferences.edit().putString("hwid", string).apply();
                    }
                }
                Pair pair = new Pair("x-hwid", string);
                Pair pair2 = new Pair("x-device-os", "Android");
                String strValueOf = Build.VERSION.RELEASE;
                if (strValueOf == null) {
                    strValueOf = String.valueOf(Build.VERSION.SDK_INT);
                }
                Pair pair3 = new Pair("x-ver-os", strValueOf);
                String str5 = Build.MANUFACTURER;
                String string2 = str5 != null ? StringsKt.trim(str5).toString() : null;
                if (string2 == null) {
                    string2 = "";
                }
                String str6 = Build.MODEL;
                String string3 = str6 != null ? StringsKt.trim(str6).toString() : null;
                String strM = string3 != null ? string3 : "";
                if (string2.length() != 0) {
                    if (strM.length() == 0) {
                        strM = DeviceInfoKt.capitalizeFirst(string2);
                    } else if (!StringsKt__StringsJVMKt.startsWith(strM, string2, true)) {
                        strM = ImageAnalysis$$ExternalSyntheticLambda1.m(DeviceInfoKt.capitalizeFirst(string2), " ", strM);
                    }
                }
                for (Map.Entry entry2 : MapsKt__MapsKt.mapOf(pair, pair2, pair3, new Pair("x-device-model", strM)).entrySet()) {
                    builder2.set((String) entry2.getKey(), (String) entry2.getValue());
                }
                Headers headersBuild = builder2.build();
                byte[] bArr = Util.EMPTY_BYTE_ARRAY;
                Request request = new Request(httpUrlBuild, "GET", headersBuild, (RequestBody$Companion$toRequestBody$2) null, linkedHashMap2.isEmpty() ? EmptyMap.INSTANCE : Collections.unmodifiableMap(new LinkedHashMap(linkedHashMap2)));
                ProfileProcessor profileProcessor = ProfileProcessor.INSTANCE;
                OkHttpClient okHttpClient = (OkHttpClient) ProfileProcessor.httpClient$delegate.getValue();
                okHttpClient.getClass();
                Response responseExecute = new RealCall(okHttpClient, request).execute();
                int i2 = responseExecute.code;
                Headers headers = responseExecute.headers;
                File file = (File) obj2;
                try {
                    if (!(200 <= i2 && i2 < 300)) {
                        throw new IOException("HTTP " + i2 + " for " + str2);
                    }
                    String str7 = headers.get("x-hwid-limit");
                    if (str7 == null) {
                        str7 = null;
                    }
                    if (!(str7 != null && StringsKt__StringsJVMKt.equals(StringsKt.trim(str7).toString(), "true", true))) {
                        String str8 = headers.get("x-hwid-max-devices-reached");
                        if (str8 == null) {
                            str8 = null;
                        }
                        if (str8 != null && StringsKt__StringsJVMKt.equals(StringsKt.trim(str8).toString(), "true", true)) {
                            z = true;
                        }
                        if (!z) {
                            ResponseBody responseBody = responseExecute.body;
                            if (responseBody == null) {
                                throw new IOException("Empty response for " + str2);
                            }
                            FileOutputStream fileOutputStream = new FileOutputStream(new File(file, "config.yaml"));
                            try {
                                ByteStreamsKt.copyTo$default(responseBody.source().inputStream(), fileOutputStream);
                                fileOutputStream.close();
                                responseExecute.close();
                                return headers;
                            } catch (Throwable th2) {
                                try {
                                    throw th2;
                                } catch (Throwable th3) {
                                    CloseableKt.closeFinally(fileOutputStream, th2);
                                    throw th3;
                                }
                            }
                        }
                    }
                    String str9 = headers.get("support-url");
                    if (str9 == null) {
                        str9 = null;
                    }
                    if (str9 != null && !StringsKt.isBlank(str9)) {
                        str3 = str9;
                    }
                    throw new HwidLimitException(str3);
                } catch (Throwable th4) {
                    try {
                        throw th4;
                    } catch (Throwable th5) {
                        CloseableKt.closeFinally(responseExecute, th4);
                        throw th5;
                    }
                }
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NavHostKt$NavHost$33$1(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.$transition = obj;
        this.$navController = obj2;
        this.$zIndices = obj3;
        this.$visibleEntries$delegate = obj4;
        this.$composeNavigator = obj5;
    }
}
