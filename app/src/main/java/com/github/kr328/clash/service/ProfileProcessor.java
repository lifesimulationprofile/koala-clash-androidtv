package com.github.kr328.clash.service;

import android.content.Context;
import android.net.Uri;
import android.util.Base64;
import android.util.Log;
import androidx.compose.ui.unit.Density;
import androidx.navigation.compose.NavHostKt$NavHost$33$1;
import coil.request.RequestService;
import com.github.kr328.clash.core.bridge.Bridge;
import com.github.kr328.clash.log.LogcatReader$$ExternalSyntheticLambda3;
import com.github.kr328.clash.service.model.Profile;
import com.github.kr328.clash.service.remote.IFetchObserver;
import dev.chrisbanes.haze.HazeStyleKt$$ExternalSyntheticLambda0;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.ResultKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyMap;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CompletableDeferredImpl;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import kotlinx.coroutines.sync.MutexImpl;
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
public final class ProfileProcessor {
    public static final ProfileProcessor INSTANCE = new ProfileProcessor();
    public static final MutexImpl profileLock = new MutexImpl();
    public static final MutexImpl processLock = new MutexImpl();
    public static final SynchronizedLazyImpl httpClient$delegate = new SynchronizedLazyImpl(new HazeStyleKt$$ExternalSyntheticLambda0(1));

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class ProfileMeta {
        public final String announce;
        public final long download;
        public final long expire;
        public final Long intervalSeconds;
        public final boolean modeSwitchAllowed;
        public final byte[] profileImage;
        public final String supportURL;
        public final String title;
        public final long total;
        public final long upload;

        public /* synthetic */ ProfileMeta(long j, long j2, long j3, long j4, int i) {
            this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? 0L : j2, (i & 4) != 0 ? 0L : j3, (i & 8) != 0 ? 0L : j4, null, null, null, null, null, true);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ProfileMeta)) {
                return false;
            }
            ProfileMeta profileMeta = (ProfileMeta) obj;
            return this.upload == profileMeta.upload && this.download == profileMeta.download && this.total == profileMeta.total && this.expire == profileMeta.expire && Intrinsics.areEqual(this.title, profileMeta.title) && Intrinsics.areEqual(this.intervalSeconds, profileMeta.intervalSeconds) && Intrinsics.areEqual(this.announce, profileMeta.announce) && Intrinsics.areEqual(this.supportURL, profileMeta.supportURL) && Intrinsics.areEqual(this.profileImage, profileMeta.profileImage) && this.modeSwitchAllowed == profileMeta.modeSwitchAllowed;
        }

        public final int hashCode() {
            long j = this.upload;
            long j2 = this.download;
            int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            long j3 = this.total;
            int i2 = (i + ((int) (j3 ^ (j3 >>> 32)))) * 31;
            long j4 = this.expire;
            int i3 = (i2 + ((int) ((j4 >>> 32) ^ j4))) * 31;
            String str = this.title;
            int iHashCode = (i3 + (str == null ? 0 : str.hashCode())) * 31;
            Long l = this.intervalSeconds;
            int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
            String str2 = this.announce;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.supportURL;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            byte[] bArr = this.profileImage;
            return ((iHashCode4 + (bArr != null ? Arrays.hashCode(bArr) : 0)) * 31) + (this.modeSwitchAllowed ? 1231 : 1237);
        }

        public final String toString() {
            String string = Arrays.toString(this.profileImage);
            StringBuilder sb = new StringBuilder("ProfileMeta(upload=");
            sb.append(this.upload);
            sb.append(", download=");
            sb.append(this.download);
            sb.append(", total=");
            sb.append(this.total);
            sb.append(", expire=");
            sb.append(this.expire);
            sb.append(", title=");
            sb.append(this.title);
            sb.append(", intervalSeconds=");
            sb.append(this.intervalSeconds);
            sb.append(", announce=");
            sb.append(this.announce);
            Density.CC.m(sb, ", supportURL=", this.supportURL, ", profileImage=", string);
            sb.append(", modeSwitchAllowed=");
            sb.append(this.modeSwitchAllowed);
            sb.append(")");
            return sb.toString();
        }

        public ProfileMeta(long j, long j2, long j3, long j4, String str, Long l, String str2, String str3, byte[] bArr, boolean z) {
            this.upload = j;
            this.download = j2;
            this.total = j3;
            this.expire = j4;
            this.title = str;
            this.intervalSeconds = l;
            this.announce = str2;
            this.supportURL = str3;
            this.profileImage = bArr;
            this.modeSwitchAllowed = z;
        }
    }

    public static final void access$commitFiles(File file, File file2) throws IOException {
        FilesKt.deleteRecursively(file2);
        File parentFile = file2.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        if (file.renameTo(file2)) {
            return;
        }
        FilesKt.copyRecursively$default(file, file2, 6);
        FilesKt.deleteRecursively(file);
    }

    public static final void access$enforceFieldsValid(String str, Profile.Type type, String str2, long j) {
        String scheme;
        if (StringsKt.isBlank(str)) {
            throw new IllegalArgumentException("Empty name");
        }
        int length = str2.length();
        Profile.Type type2 = Profile.Type.File;
        if (length == 0 && type != type2) {
            throw new IllegalArgumentException("Invalid url");
        }
        if (str2.length() <= 0 || type == type2) {
            if (j != 0 && TimeUnit.MILLISECONDS.toMinutes(j) < 15) {
                throw new IllegalArgumentException("Invalid interval");
            }
        } else {
            Uri uri = Uri.parse(str2);
            String lowerCase = (uri == null || (scheme = uri.getScheme()) == null) ? null : scheme.toLowerCase(Locale.getDefault());
            if (!Intrinsics.areEqual(lowerCase, "https") && !Intrinsics.areEqual(lowerCase, "http")) {
                throw new IllegalArgumentException("Unsupported url ".concat(str2));
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x02d4  */
    /* JADX WARN: Code duplicated, block: B:104:0x02d7 A[Catch: all -> 0x02f4, TRY_LEAVE, TryCatch #1 {all -> 0x02f4, blocks: (B:97:0x02c8, B:104:0x02d7, B:111:0x02f7, B:113:0x02fb), top: B:148:0x02c8, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:111:0x02f7 A[Catch: all -> 0x02f4, TRY_ENTER, TryCatch #1 {all -> 0x02f4, blocks: (B:97:0x02c8, B:104:0x02d7, B:111:0x02f7, B:113:0x02fb), top: B:148:0x02c8, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:113:0x02fb A[Catch: all -> 0x02f4, TRY_LEAVE, TryCatch #1 {all -> 0x02f4, blocks: (B:97:0x02c8, B:104:0x02d7, B:111:0x02f7, B:113:0x02fb), top: B:148:0x02c8, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:115:0x0300  */
    /* JADX WARN: Code duplicated, block: B:128:0x033d  */
    /* JADX WARN: Code duplicated, block: B:131:0x0342  */
    /* JADX WARN: Code duplicated, block: B:132:0x0344  */
    /* JADX WARN: Code duplicated, block: B:135:0x0349  */
    /* JADX WARN: Code duplicated, block: B:137:0x034d  */
    /* JADX WARN: Code duplicated, block: B:138:0x034f  */
    /* JADX WARN: Code duplicated, block: B:141:0x0353  */
    /* JADX WARN: Code duplicated, block: B:143:0x0356  */
    /* JADX WARN: Code duplicated, block: B:162:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:33:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:65:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:67:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:72:0x0220  */
    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    /* JADX WARN: Code duplicated, block: B:80:0x024b  */
    /* JADX WARN: Code duplicated, block: B:91:0x0271  */
    /* JADX WARN: Code duplicated, block: B:93:0x0292  */
    /* JADX WARN: Code duplicated, block: B:94:0x0295  */
    /* JADX WARN: Instruction removed from duplicated block: B:104:0x02d7, please report this as an issue */
    public static final Object access$resolve(Context context, Profile.Type type, String str, File file, IFetchObserver iFetchObserver, ContinuationImpl continuationImpl) throws Throwable {
        ProfileProcessor$resolve$1 profileProcessor$resolve$1;
        ProfileProcessor profileProcessor;
        LogcatReader$$ExternalSyntheticLambda3 logcatReader$$ExternalSyntheticLambda3;
        Profile.Type type2;
        String str2;
        File file2;
        Headers headers;
        ProfileProcessor profileProcessor2;
        String str3;
        ProfileMeta profileMeta;
        String strDecodeTitleOrPlain;
        String strDecodeTitleOrPlain2;
        String str4;
        String str5;
        String str6;
        Long lValueOf;
        String str7;
        String str8;
        boolean z;
        String str9;
        boolean z2;
        String string;
        HttpUrl httpUrlBuild;
        LinkedHashMap linkedHashMap;
        Map mapUnmodifiableMap;
        Response responseExecute;
        int i;
        boolean z3;
        ResponseBody responseBody;
        byte[] bArrBytes;
        String string2;
        Long longOrNull;
        if (continuationImpl instanceof ProfileProcessor$resolve$1) {
            profileProcessor$resolve$1 = (ProfileProcessor$resolve$1) continuationImpl;
            int i2 = profileProcessor$resolve$1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                profileProcessor$resolve$1.label = i2 - Integer.MIN_VALUE;
            } else {
                profileProcessor$resolve$1 = new ProfileProcessor$resolve$1(continuationImpl);
            }
        } else {
            profileProcessor$resolve$1 = new ProfileProcessor$resolve$1(continuationImpl);
        }
        Object obj = profileProcessor$resolve$1.result;
        int i3 = profileProcessor$resolve$1.label;
        int i4 = 2;
        byte[] bArr = null;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = iFetchObserver;
            LogcatReader$$ExternalSyntheticLambda3 logcatReader$$ExternalSyntheticLambda4 = new LogcatReader$$ExternalSyntheticLambda3(ref$ObjectRef, i4);
            ProfileProcessor profileProcessor3 = INSTANCE;
            profileProcessor$resolve$1.L$0 = profileProcessor3;
            profileProcessor$resolve$1.L$1 = type;
            profileProcessor$resolve$1.L$2 = str;
            profileProcessor$resolve$1.L$3 = file;
            profileProcessor$resolve$1.L$4 = logcatReader$$ExternalSyntheticLambda4;
            profileProcessor$resolve$1.label = 1;
            DefaultScheduler defaultScheduler = Dispatchers.Default;
            Object objWithContext = JobKt.withContext(DefaultIoScheduler.INSTANCE, new NavHostKt$NavHost$33$1(type, str, logcatReader$$ExternalSyntheticLambda4, context, file, null, 2), profileProcessor$resolve$1);
            if (objWithContext != coroutineSingletons) {
                profileProcessor = profileProcessor3;
                obj = objWithContext;
                logcatReader$$ExternalSyntheticLambda3 = logcatReader$$ExternalSyntheticLambda4;
                type2 = type;
                str2 = str;
                file2 = file;
            }
            return coroutineSingletons;
        }
        if (i3 == 1) {
            logcatReader$$ExternalSyntheticLambda3 = profileProcessor$resolve$1.L$4;
            file2 = profileProcessor$resolve$1.L$3;
            str2 = profileProcessor$resolve$1.L$2;
            type2 = (Profile.Type) profileProcessor$resolve$1.L$1;
            profileProcessor = profileProcessor$resolve$1.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            if (i3 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            headers = (Headers) profileProcessor$resolve$1.L$1;
            profileProcessor2 = profileProcessor$resolve$1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        profileProcessor = profileProcessor2;
        if (headers != null) {
            str3 = headers.get("subscription-userinfo");
        } else {
            str3 = null;
        }
        profileProcessor.getClass();
        if (str3 != null || StringsKt.isBlank(str3)) {
            profileMeta = new ProfileMeta(0L, 0L, 0L, 0L, 1023);
        } else {
            long jLongValueExact = 0;
            long jLongValueExact2 = 0;
            long jLongValueExact3 = 0;
            long jLongValueExact4 = 0;
            for (String str10 : StringsKt.split$default(str3, new String[]{";"}, 0, 6)) {
                List listSplit$default = StringsKt.split$default(str10, new String[]{"="}, 2, 2);
                if (listSplit$default.size() >= 2) {
                    String string3 = StringsKt.trim((String) listSplit$default.get(0)).toString();
                    String string4 = StringsKt.trim((String) listSplit$default.get(1)).toString();
                    if (string4.length() != 0) {
                        try {
                            if (StringsKt.contains(string3, "upload", false)) {
                                jLongValueExact = new BigDecimal((String) CollectionsKt.first(StringsKt.split$default(string4, new char[]{'.'}))).longValueExact();
                            } else if (StringsKt.contains(string3, "download", false)) {
                                jLongValueExact2 = new BigDecimal((String) CollectionsKt.first(StringsKt.split$default(string4, new char[]{'.'}))).longValueExact();
                            } else if (StringsKt.contains(string3, "total", false)) {
                                jLongValueExact3 = new BigDecimal((String) CollectionsKt.first(StringsKt.split$default(string4, new char[]{'.'}))).longValueExact();
                            } else if (StringsKt.contains(string3, "expire", false)) {
                                jLongValueExact4 = new BigDecimal((String) CollectionsKt.first(StringsKt.split$default(string4, new char[]{'.'}))).longValueExact();
                            }
                            Unit unit = Unit.INSTANCE;
                        } catch (Exception e) {
                            Log.w("KoalaClash", "Parse subscription-userinfo flag '" + str10 + "': " + e, e);
                        }
                    }
                }
            }
            profileMeta = new ProfileMeta(jLongValueExact, jLongValueExact2, jLongValueExact3, jLongValueExact4, 1008);
        }
        if (headers != null) {
            return profileMeta;
        }
        strDecodeTitleOrPlain = decodeTitleOrPlain(headers.get("profile-title"));
        strDecodeTitleOrPlain2 = decodeTitleOrPlain(headers.get("announce"));
        str4 = headers.get("support-url");
        if (str4 != null || StringsKt.isBlank(str4)) {
            str5 = null;
        } else {
            str5 = str4;
        }
        str6 = headers.get("profile-update-interval");
        if (str6 != null || (string2 = StringsKt.trim(str6).toString()) == null || (longOrNull = StringsKt__StringsJVMKt.toLongOrNull(string2)) == null) {
            lValueOf = null;
        } else {
            lValueOf = Long.valueOf(TimeUnit.HOURS.toSeconds(longOrNull.longValue()));
        }
        str7 = headers.get("profile-logo");
        if (str7 != null && !StringsKt.isBlank(str7)) {
            try {
                HttpUrl.Builder builder = new HttpUrl.Builder();
                builder.parse$okhttp(null, str7);
                httpUrlBuild = builder.build();
            } catch (IllegalArgumentException unused) {
                httpUrlBuild = null;
            }
            if (httpUrlBuild != null) {
                linkedHashMap = new LinkedHashMap();
                Headers headers2 = new Headers((String[]) new ArrayList(20).toArray(new String[0]));
                byte[] bArr2 = Util.EMPTY_BYTE_ARRAY;
                if (linkedHashMap.isEmpty()) {
                    mapUnmodifiableMap = EmptyMap.INSTANCE;
                } else {
                    mapUnmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(linkedHashMap));
                }
                Request request = new Request(httpUrlBuild, "GET", headers2, (RequestBody$Companion$toRequestBody$2) null, mapUnmodifiableMap);
                try {
                    OkHttpClient okHttpClient = (OkHttpClient) httpClient$delegate.getValue();
                    okHttpClient.getClass();
                    responseExecute = new RealCall(okHttpClient, request).execute();
                    try {
                        i = responseExecute.code;
                        if (200 <= i || i >= 300) {
                            z3 = false;
                        } else {
                            z3 = true;
                        }
                        if (z3) {
                            responseBody = responseExecute.body;
                            if (responseBody != null) {
                                bArrBytes = responseBody.bytes();
                            } else {
                                bArrBytes = null;
                            }
                            responseExecute.close();
                            bArr = bArrBytes;
                        } else {
                            Log.w("KoalaClash", "Profile logo HTTP " + i + " for " + str7, null);
                            responseExecute.close();
                        }
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(responseExecute, th);
                            throw th2;
                        }
                    }
                } catch (Exception e2) {
                    Log.w("KoalaClash", "Download profile logo '" + str7 + "': " + e2, e2);
                }
            }
        }
        str8 = headers.get("global-mode");
        if (str8 != null || (string = StringsKt.trim(str8).toString()) == null) {
            z = true;
        } else {
            z = !string.equalsIgnoreCase("false");
        }
        if (strDecodeTitleOrPlain == null) {
            str9 = "<none>";
        } else {
            str9 = strDecodeTitleOrPlain;
        }
        Object obj2 = lValueOf != null ? lValueOf : "<none>";
        if (strDecodeTitleOrPlain2 != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Log.d("KoalaClash", "Profile headers parsed: title=" + str9 + ", interval=" + obj2 + "s, announce=" + z2 + ", supportURL=" + (str5 != null) + ", imageBytes=" + (bArr != null ? bArr.length : 0) + ", modeSwitchAllowed=" + z, null);
        return new ProfileMeta(profileMeta.upload, profileMeta.download, profileMeta.total, profileMeta.expire, strDecodeTitleOrPlain, lValueOf, strDecodeTitleOrPlain2, str5, bArr, z);
        Headers headers3 = (Headers) obj;
        if (type2 != Profile.Type.File || str2.length() > 0) {
            CompletableDeferredImpl completableDeferredImplCompletableDeferred$default = JobKt.CompletableDeferred$default();
            Bridge.INSTANCE.nativeValidate(new RequestService(29, logcatReader$$ExternalSyntheticLambda3, completableDeferredImplCompletableDeferred$default), file2.getAbsolutePath());
            profileProcessor$resolve$1.L$0 = profileProcessor;
            profileProcessor$resolve$1.L$1 = headers3;
            profileProcessor$resolve$1.L$2 = null;
            profileProcessor$resolve$1.L$3 = null;
            profileProcessor$resolve$1.L$4 = null;
            profileProcessor$resolve$1.label = 2;
            if (completableDeferredImplCompletableDeferred$default.awaitInternal(profileProcessor$resolve$1) != coroutineSingletons) {
                headers = headers3;
                profileProcessor2 = profileProcessor;
                profileProcessor = profileProcessor2;
            }
            return coroutineSingletons;
        }
        headers = headers3;
        if (headers != null) {
            str3 = headers.get("subscription-userinfo");
        } else {
            str3 = null;
        }
        profileProcessor.getClass();
        if (str3 != null) {
            profileMeta = new ProfileMeta(0L, 0L, 0L, 0L, 1023);
        } else {
            profileMeta = new ProfileMeta(0L, 0L, 0L, 0L, 1023);
        }
        if (headers != null) {
            return profileMeta;
        }
        strDecodeTitleOrPlain = decodeTitleOrPlain(headers.get("profile-title"));
        strDecodeTitleOrPlain2 = decodeTitleOrPlain(headers.get("announce"));
        str4 = headers.get("support-url");
        if (str4 != null) {
            str5 = null;
        } else {
            str5 = null;
        }
        str6 = headers.get("profile-update-interval");
        if (str6 != null) {
            lValueOf = null;
        } else {
            lValueOf = null;
        }
        str7 = headers.get("profile-logo");
        if (str7 != null) {
            HttpUrl.Builder builder2 = new HttpUrl.Builder();
            builder2.parse$okhttp(null, str7);
            httpUrlBuild = builder2.build();
            if (httpUrlBuild != null) {
                linkedHashMap = new LinkedHashMap();
                Headers headers4 = new Headers((String[]) new ArrayList(20).toArray(new String[0]));
                byte[] bArr3 = Util.EMPTY_BYTE_ARRAY;
                if (linkedHashMap.isEmpty()) {
                    mapUnmodifiableMap = EmptyMap.INSTANCE;
                } else {
                    mapUnmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(linkedHashMap));
                }
                Request request2 = new Request(httpUrlBuild, "GET", headers4, (RequestBody$Companion$toRequestBody$2) null, mapUnmodifiableMap);
                OkHttpClient okHttpClient2 = (OkHttpClient) httpClient$delegate.getValue();
                okHttpClient2.getClass();
                responseExecute = new RealCall(okHttpClient2, request2).execute();
                i = responseExecute.code;
                if (200 <= i) {
                    z3 = false;
                } else {
                    z3 = false;
                }
                if (z3) {
                    Log.w("KoalaClash", "Profile logo HTTP " + i + " for " + str7, null);
                    responseExecute.close();
                } else {
                    responseBody = responseExecute.body;
                    if (responseBody != null) {
                        bArrBytes = responseBody.bytes();
                    } else {
                        bArrBytes = null;
                    }
                    responseExecute.close();
                    bArr = bArrBytes;
                }
            }
        }
        str8 = headers.get("global-mode");
        if (str8 != null) {
            z = true;
        } else {
            z = true;
        }
        if (strDecodeTitleOrPlain == null) {
            str9 = "<none>";
        } else {
            str9 = strDecodeTitleOrPlain;
        }
        if (lValueOf != null) {
        }
        if (strDecodeTitleOrPlain2 != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (str5 != null) {
        }
        if (bArr != null) {
        }
        Log.d("KoalaClash", "Profile headers parsed: title=" + str9 + ", interval=" + obj2 + "s, announce=" + z2 + ", supportURL=" + (str5 != null) + ", imageBytes=" + (bArr != null ? bArr.length : 0) + ", modeSwitchAllowed=" + z, null);
        return new ProfileMeta(profileMeta.upload, profileMeta.download, profileMeta.total, profileMeta.expire, strDecodeTitleOrPlain, lValueOf, strDecodeTitleOrPlain2, str5, bArr, z);
    }

    public static String decodeTitleOrPlain(String str) {
        String str2;
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        if (!StringsKt.isBlank(str) && StringsKt__StringsJVMKt.startsWith(str, "base64:", false)) {
            try {
                str2 = new String(Base64.decode(StringsKt.removePrefix(str, "base64:"), 0), Charsets.UTF_8);
            } catch (Exception e) {
                Log.w("KoalaClash", "Decode base64 header '" + str + "': " + e, e);
                str2 = null;
            }
        } else {
            str2 = null;
        }
        if (str2 != null) {
            return str2;
        }
        String string = StringsKt.trim(str).toString();
        if (string.length() > 0) {
            return string;
        }
        return null;
    }
}
