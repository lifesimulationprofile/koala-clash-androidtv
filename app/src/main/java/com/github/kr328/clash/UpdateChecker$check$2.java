package com.github.kr328.clash;

import android.net.Network;
import android.util.Log;
import android.view.Choreographer;
import com.github.kr328.clash.core.bridge.Bridge;
import com.github.kr328.clash.log.SystemLogcat;
import com.github.kr328.clash.service.clash.module.CloseModule;
import com.github.kr328.clash.service.clash.module.TunModule;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.barcode.ModuleDescriptor;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.util.ArrayList;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function2;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class UpdateChecker$check$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UpdateChecker$check$2(int i, Continuation continuation, int i2) {
        super(i, continuation);
        this.$r8$classId = i2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new UpdateChecker$check$2(2, continuation, 0);
            case 1:
                return new UpdateChecker$check$2(2, continuation, 1);
            case 2:
                return new UpdateChecker$check$2(2, continuation, 2);
            case 3:
                return new UpdateChecker$check$2(2, continuation, 3);
            case 4:
                return new UpdateChecker$check$2(2, continuation, 4);
            case 5:
                return new UpdateChecker$check$2(2, continuation, 5);
            case 6:
                return new UpdateChecker$check$2(2, continuation, 6);
            case 7:
                return new UpdateChecker$check$2(2, continuation, 7);
            case 8:
                return new UpdateChecker$check$2(2, continuation, 8);
            case 9:
                return new UpdateChecker$check$2(2, continuation, 9);
            case 10:
                return new UpdateChecker$check$2(2, continuation, 10);
            default:
                return new UpdateChecker$check$2(2, continuation, 11);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                return ((UpdateChecker$check$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 1:
                create((Flow) obj, (Continuation) obj2);
                Unit unit = Unit.INSTANCE;
                ResultKt.throwOnFailure(unit);
                return unit;
            case 2:
                return ((UpdateChecker$check$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 3:
                create((CoroutineScope) obj, (Continuation) obj2);
                Unit unit2 = Unit.INSTANCE;
                ResultKt.throwOnFailure(unit2);
                return unit2;
            case 4:
                return ((UpdateChecker$check$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 5:
                ((UpdateChecker$check$2) create((CloseModule.RequestClose) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                return Boolean.TRUE;
            case 6:
                ((UpdateChecker$check$2) create((Network) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                return Boolean.FALSE;
            case 7:
                ((UpdateChecker$check$2) create((CloseModule.RequestClose) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
                return Boolean.TRUE;
            case 8:
                return ((UpdateChecker$check$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 9:
                create((Unit) obj, (Continuation) obj2);
                ResultKt.throwOnFailure(Unit.INSTANCE);
                return null;
            case 10:
                return ((UpdateChecker$check$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            default:
                return ((UpdateChecker$check$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                ResultKt.throwOnFailure(obj);
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://api.github.com/repos/coolcoala/ClashMetaForAndroid/releases/latest").openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setRequestProperty("Accept", "application/vnd.github.v3+json");
                    httpURLConnection.setConnectTimeout(ModuleDescriptor.MODULE_VERSION);
                    httpURLConnection.setReadTimeout(ModuleDescriptor.MODULE_VERSION);
                    if (httpURLConnection.getResponseCode() != 200) {
                        return null;
                    }
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), Charsets.UTF_8), 8192);
                    try {
                        StringWriter stringWriter = new StringWriter();
                        char[] cArr = new char[8192];
                        for (int i = bufferedReader.read(cArr); i >= 0; i = bufferedReader.read(cArr)) {
                            stringWriter.write(cArr, 0, i);
                        }
                        String string = stringWriter.toString();
                        bufferedReader.close();
                        JSONObject jSONObject = new JSONObject(string);
                        String strOptString = jSONObject.optString("tag_name", "");
                        String strRemovePrefix = StringsKt.removePrefix(strOptString, "v");
                        if (!StringsKt.isBlank(strRemovePrefix) && UpdateChecker.access$compareVersions(strRemovePrefix) > 0) {
                            return new UpdateInfo(strOptString, strRemovePrefix, jSONObject.optString("body", ""), jSONObject.optString("html_url", "https://github.com/coolcoala/ClashMetaForAndroid/releases/latest"), UpdateChecker.access$findBestApkUrl(jSONObject));
                        }
                        return null;
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(bufferedReader, th);
                            throw th2;
                        }
                    }
                } catch (Exception unused) {
                    return null;
                }
            case 1:
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure(obj);
                return Choreographer.getInstance();
            case 3:
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            case 4:
                ResultKt.throwOnFailure(obj);
                try {
                    Process processExec = Runtime.getRuntime().exec(SystemLogcat.command);
                    InputStream inputStream = processExec.getInputStream();
                    try {
                        ArrayList lines = TextStreamsKt.readLines(new InputStreamReader(inputStream, Charsets.UTF_8));
                        ArrayList arrayList = new ArrayList();
                        int size = lines.size();
                        int i2 = 0;
                        while (i2 < size) {
                            Object obj2 = lines.get(i2);
                            i2++;
                            if (!StringsKt__StringsJVMKt.startsWith((String) obj2, "------", false)) {
                                arrayList.add(obj2);
                            }
                        }
                        String strJoinToString$default = CollectionsKt.joinToString$default(arrayList, "\n", null, null, null, 62);
                        CloseableKt.closeFinally(inputStream, null);
                        processExec.waitFor();
                        return StringsKt.trim(strJoinToString$default).toString();
                    } catch (Throwable th3) {
                        try {
                            throw th3;
                        } catch (Throwable th4) {
                            CloseableKt.closeFinally(inputStream, th3);
                            throw th4;
                        }
                    }
                } catch (Exception unused2) {
                    return "";
                }
            case 5:
                ResultKt.throwOnFailure(obj);
                return Boolean.TRUE;
            case 6:
                ResultKt.throwOnFailure(obj);
                return Boolean.FALSE;
            case 7:
                ResultKt.throwOnFailure(obj);
                return Boolean.TRUE;
            case 8:
                ResultKt.throwOnFailure(obj);
                Bridge bridge = Bridge.INSTANCE;
                bridge.nativeReset();
                bridge.nativeWriteOverrideMode("");
                return new Integer(Log.d("KoalaClash", "ClashRuntime: destroyed", null));
            case 9:
                ResultKt.throwOnFailure(obj);
                return null;
            case 10:
                ResultKt.throwOnFailure(obj);
                Bridge.INSTANCE.nativeSuspend(false);
                return Unit.INSTANCE;
            default:
                ResultKt.throwOnFailure(obj);
                SecureRandom secureRandom = TunModule.random;
                Bridge bridge2 = Bridge.INSTANCE;
                bridge2.nativeStopHttp();
                bridge2.nativeStopTun();
                return Unit.INSTANCE;
        }
    }
}
