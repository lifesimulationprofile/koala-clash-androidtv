package com.google.android.gms.dynamite;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.material.internal.ViewUtils;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import kotlin.ResultKt;
import okio.AsyncTimeout;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DynamiteModule {
    public static final ByteString.Companion PREFER_LOCAL;
    public static final AsyncTimeout.Companion PREFER_REMOTE;
    public static Boolean zzb = null;
    public static String zzc = null;
    public static boolean zzd = false;
    public static int zze = -1;
    public static Boolean zzf;
    public static final ThreadLocal zzg = new ThreadLocal();
    public static final zzd zzh = new zzd(0);
    public static final zze zzi = new zze(0);
    public static zzq zzk;
    public static zzr zzl;
    public final Context zzj;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    @DynamiteApi
    public class DynamiteLoaderClassLoader {

        @GuardedBy("DynamiteLoaderClassLoader.class")
        public static ClassLoader sClassLoader;
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class LoadingException extends Exception {
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public interface VersionPolicy {

        /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
        public interface IVersions {
            int zza(Context context, String str);

            int zzb(Context context, String str, boolean z);
        }

        ViewUtils.RelativePadding selectModule(Context context, String str, IVersions iVersions);
    }

    static {
        int i = 16;
        PREFER_REMOTE = new AsyncTimeout.Companion(i);
        PREFER_LOCAL = new ByteString.Companion(i);
    }

    public DynamiteModule(Context context) {
        this.zzj = context;
    }

    public static int getLocalVersion(Context context, String str) {
        try {
            Class<?> clsLoadClass = context.getApplicationContext().getClassLoader().loadClass("com.google.android.gms.dynamite.descriptors." + str + ".ModuleDescriptor");
            Field declaredField = clsLoadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = clsLoadClass.getDeclaredField("MODULE_VERSION");
            if (zzah.equal(declaredField.get(null), str)) {
                return declaredField2.getInt(null);
            }
            Log.e("DynamiteModule", "Module descriptor id '" + String.valueOf(declaredField.get(null)) + "' didn't match expected id '" + str + "'");
            return 0;
        } catch (ClassNotFoundException unused) {
            Log.w("DynamiteModule", "Local module descriptor class for " + str + " not found.");
            return 0;
        } catch (Exception e) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e.getMessage())));
            return 0;
        }
    }

    /* JADX WARN: Code duplicated, block: B:116:0x0267  */
    /* JADX WARN: Code duplicated, block: B:117:0x026d  */
    /* JADX WARN: Code duplicated, block: B:120:0x0276  */
    /* JADX WARN: Code duplicated, block: B:125:0x0287 A[Catch: all -> 0x0085, TryCatch #4 {all -> 0x0085, blocks: (B:7:0x004b, B:11:0x007f, B:18:0x008b, B:21:0x0091, B:24:0x00a9, B:102:0x0211, B:103:0x0218, B:106:0x021b, B:107:0x021c, B:108:0x0223, B:125:0x0287, B:126:0x0298, B:109:0x0224, B:111:0x0242, B:113:0x024f, B:123:0x027f, B:124:0x0286, B:127:0x0299, B:128:0x02c5), top: B:147:0x004b, inners: #8 }] */
    /* JADX WARN: Code duplicated, block: B:144:0x00dc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:146:0x00ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:150:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:21:0x0091 A[Catch: all -> 0x0085, TRY_LEAVE, TryCatch #4 {all -> 0x0085, blocks: (B:7:0x004b, B:11:0x007f, B:18:0x008b, B:21:0x0091, B:24:0x00a9, B:102:0x0211, B:103:0x0218, B:106:0x021b, B:107:0x021c, B:108:0x0223, B:125:0x0287, B:126:0x0298, B:109:0x0224, B:111:0x0242, B:113:0x024f, B:123:0x027f, B:124:0x0286, B:127:0x0299, B:128:0x02c5), top: B:147:0x004b, inners: #8 }] */
    /* JADX WARN: Code duplicated, block: B:23:0x00a7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:29:0x00b4 A[Catch: all -> 0x0205, TryCatch #3 {, blocks: (B:27:0x00ae, B:29:0x00b4, B:30:0x00b6, B:98:0x0207, B:99:0x020e), top: B:146:0x00ae }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00b9 A[Catch: all -> 0x011c, LoadingException -> 0x011f, RemoteException -> 0x0122, TRY_ENTER, TryCatch #8 {RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c, blocks: (B:26:0x00ad, B:32:0x00b9, B:34:0x00c0, B:35:0x00db, B:39:0x00e1, B:41:0x00e9, B:43:0x00ed, B:44:0x00fb, B:51:0x0106, B:59:0x013a, B:61:0x0142, B:63:0x014a, B:64:0x0151, B:58:0x0125, B:67:0x0154, B:68:0x0155, B:69:0x015c, B:70:0x015d, B:71:0x0164, B:74:0x0167, B:75:0x0168, B:77:0x0187, B:79:0x019a, B:81:0x01a2, B:87:0x01de, B:89:0x01e4, B:90:0x01ed, B:91:0x01f4, B:82:0x01b3, B:83:0x01ba, B:85:0x01bd, B:86:0x01ce, B:92:0x01f5, B:93:0x01fc, B:94:0x01fd, B:95:0x0204, B:101:0x0210), top: B:151:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00c0 A[Catch: all -> 0x011c, LoadingException -> 0x011f, RemoteException -> 0x0122, TryCatch #8 {RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c, blocks: (B:26:0x00ad, B:32:0x00b9, B:34:0x00c0, B:35:0x00db, B:39:0x00e1, B:41:0x00e9, B:43:0x00ed, B:44:0x00fb, B:51:0x0106, B:59:0x013a, B:61:0x0142, B:63:0x014a, B:64:0x0151, B:58:0x0125, B:67:0x0154, B:68:0x0155, B:69:0x015c, B:70:0x015d, B:71:0x0164, B:74:0x0167, B:75:0x0168, B:77:0x0187, B:79:0x019a, B:81:0x01a2, B:87:0x01de, B:89:0x01e4, B:90:0x01ed, B:91:0x01f4, B:82:0x01b3, B:83:0x01ba, B:85:0x01bd, B:86:0x01ce, B:92:0x01f5, B:93:0x01fc, B:94:0x01fd, B:95:0x0204, B:101:0x0210), top: B:151:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00e1 A[Catch: all -> 0x011c, LoadingException -> 0x011f, RemoteException -> 0x0122, TRY_ENTER, TryCatch #8 {RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c, blocks: (B:26:0x00ad, B:32:0x00b9, B:34:0x00c0, B:35:0x00db, B:39:0x00e1, B:41:0x00e9, B:43:0x00ed, B:44:0x00fb, B:51:0x0106, B:59:0x013a, B:61:0x0142, B:63:0x014a, B:64:0x0151, B:58:0x0125, B:67:0x0154, B:68:0x0155, B:69:0x015c, B:70:0x015d, B:71:0x0164, B:74:0x0167, B:75:0x0168, B:77:0x0187, B:79:0x019a, B:81:0x01a2, B:87:0x01de, B:89:0x01e4, B:90:0x01ed, B:91:0x01f4, B:82:0x01b3, B:83:0x01ba, B:85:0x01bd, B:86:0x01ce, B:92:0x01f5, B:93:0x01fc, B:94:0x01fd, B:95:0x0204, B:101:0x0210), top: B:151:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:70:0x015d A[Catch: all -> 0x011c, LoadingException -> 0x011f, RemoteException -> 0x0122, TryCatch #8 {RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c, blocks: (B:26:0x00ad, B:32:0x00b9, B:34:0x00c0, B:35:0x00db, B:39:0x00e1, B:41:0x00e9, B:43:0x00ed, B:44:0x00fb, B:51:0x0106, B:59:0x013a, B:61:0x0142, B:63:0x014a, B:64:0x0151, B:58:0x0125, B:67:0x0154, B:68:0x0155, B:69:0x015c, B:70:0x015d, B:71:0x0164, B:74:0x0167, B:75:0x0168, B:77:0x0187, B:79:0x019a, B:81:0x01a2, B:87:0x01de, B:89:0x01e4, B:90:0x01ed, B:91:0x01f4, B:82:0x01b3, B:83:0x01ba, B:85:0x01bd, B:86:0x01ce, B:92:0x01f5, B:93:0x01fc, B:94:0x01fd, B:95:0x0204, B:101:0x0210), top: B:151:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:75:0x0168 A[Catch: all -> 0x011c, LoadingException -> 0x011f, RemoteException -> 0x0122, TryCatch #8 {RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c, blocks: (B:26:0x00ad, B:32:0x00b9, B:34:0x00c0, B:35:0x00db, B:39:0x00e1, B:41:0x00e9, B:43:0x00ed, B:44:0x00fb, B:51:0x0106, B:59:0x013a, B:61:0x0142, B:63:0x014a, B:64:0x0151, B:58:0x0125, B:67:0x0154, B:68:0x0155, B:69:0x015c, B:70:0x015d, B:71:0x0164, B:74:0x0167, B:75:0x0168, B:77:0x0187, B:79:0x019a, B:81:0x01a2, B:87:0x01de, B:89:0x01e4, B:90:0x01ed, B:91:0x01f4, B:82:0x01b3, B:83:0x01ba, B:85:0x01bd, B:86:0x01ce, B:92:0x01f5, B:93:0x01fc, B:94:0x01fd, B:95:0x0204, B:101:0x0210), top: B:151:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:77:0x0187 A[Catch: all -> 0x011c, LoadingException -> 0x011f, RemoteException -> 0x0122, TryCatch #8 {RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c, blocks: (B:26:0x00ad, B:32:0x00b9, B:34:0x00c0, B:35:0x00db, B:39:0x00e1, B:41:0x00e9, B:43:0x00ed, B:44:0x00fb, B:51:0x0106, B:59:0x013a, B:61:0x0142, B:63:0x014a, B:64:0x0151, B:58:0x0125, B:67:0x0154, B:68:0x0155, B:69:0x015c, B:70:0x015d, B:71:0x0164, B:74:0x0167, B:75:0x0168, B:77:0x0187, B:79:0x019a, B:81:0x01a2, B:87:0x01de, B:89:0x01e4, B:90:0x01ed, B:91:0x01f4, B:82:0x01b3, B:83:0x01ba, B:85:0x01bd, B:86:0x01ce, B:92:0x01f5, B:93:0x01fc, B:94:0x01fd, B:95:0x0204, B:101:0x0210), top: B:151:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:79:0x019a A[Catch: all -> 0x011c, LoadingException -> 0x011f, RemoteException -> 0x0122, TryCatch #8 {RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c, blocks: (B:26:0x00ad, B:32:0x00b9, B:34:0x00c0, B:35:0x00db, B:39:0x00e1, B:41:0x00e9, B:43:0x00ed, B:44:0x00fb, B:51:0x0106, B:59:0x013a, B:61:0x0142, B:63:0x014a, B:64:0x0151, B:58:0x0125, B:67:0x0154, B:68:0x0155, B:69:0x015c, B:70:0x015d, B:71:0x0164, B:74:0x0167, B:75:0x0168, B:77:0x0187, B:79:0x019a, B:81:0x01a2, B:87:0x01de, B:89:0x01e4, B:90:0x01ed, B:91:0x01f4, B:82:0x01b3, B:83:0x01ba, B:85:0x01bd, B:86:0x01ce, B:92:0x01f5, B:93:0x01fc, B:94:0x01fd, B:95:0x0204, B:101:0x0210), top: B:151:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:81:0x01a2 A[Catch: all -> 0x011c, LoadingException -> 0x011f, RemoteException -> 0x0122, TryCatch #8 {RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c, blocks: (B:26:0x00ad, B:32:0x00b9, B:34:0x00c0, B:35:0x00db, B:39:0x00e1, B:41:0x00e9, B:43:0x00ed, B:44:0x00fb, B:51:0x0106, B:59:0x013a, B:61:0x0142, B:63:0x014a, B:64:0x0151, B:58:0x0125, B:67:0x0154, B:68:0x0155, B:69:0x015c, B:70:0x015d, B:71:0x0164, B:74:0x0167, B:75:0x0168, B:77:0x0187, B:79:0x019a, B:81:0x01a2, B:87:0x01de, B:89:0x01e4, B:90:0x01ed, B:91:0x01f4, B:82:0x01b3, B:83:0x01ba, B:85:0x01bd, B:86:0x01ce, B:92:0x01f5, B:93:0x01fc, B:94:0x01fd, B:95:0x0204, B:101:0x0210), top: B:151:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:82:0x01b3 A[Catch: all -> 0x011c, LoadingException -> 0x011f, RemoteException -> 0x0122, TryCatch #8 {RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c, blocks: (B:26:0x00ad, B:32:0x00b9, B:34:0x00c0, B:35:0x00db, B:39:0x00e1, B:41:0x00e9, B:43:0x00ed, B:44:0x00fb, B:51:0x0106, B:59:0x013a, B:61:0x0142, B:63:0x014a, B:64:0x0151, B:58:0x0125, B:67:0x0154, B:68:0x0155, B:69:0x015c, B:70:0x015d, B:71:0x0164, B:74:0x0167, B:75:0x0168, B:77:0x0187, B:79:0x019a, B:81:0x01a2, B:87:0x01de, B:89:0x01e4, B:90:0x01ed, B:91:0x01f4, B:82:0x01b3, B:83:0x01ba, B:85:0x01bd, B:86:0x01ce, B:92:0x01f5, B:93:0x01fc, B:94:0x01fd, B:95:0x0204, B:101:0x0210), top: B:151:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:84:0x01bb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:85:0x01bd A[Catch: all -> 0x011c, LoadingException -> 0x011f, RemoteException -> 0x0122, TryCatch #8 {RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c, blocks: (B:26:0x00ad, B:32:0x00b9, B:34:0x00c0, B:35:0x00db, B:39:0x00e1, B:41:0x00e9, B:43:0x00ed, B:44:0x00fb, B:51:0x0106, B:59:0x013a, B:61:0x0142, B:63:0x014a, B:64:0x0151, B:58:0x0125, B:67:0x0154, B:68:0x0155, B:69:0x015c, B:70:0x015d, B:71:0x0164, B:74:0x0167, B:75:0x0168, B:77:0x0187, B:79:0x019a, B:81:0x01a2, B:87:0x01de, B:89:0x01e4, B:90:0x01ed, B:91:0x01f4, B:82:0x01b3, B:83:0x01ba, B:85:0x01bd, B:86:0x01ce, B:92:0x01f5, B:93:0x01fc, B:94:0x01fd, B:95:0x0204, B:101:0x0210), top: B:151:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:86:0x01ce A[Catch: all -> 0x011c, LoadingException -> 0x011f, RemoteException -> 0x0122, TryCatch #8 {RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c, blocks: (B:26:0x00ad, B:32:0x00b9, B:34:0x00c0, B:35:0x00db, B:39:0x00e1, B:41:0x00e9, B:43:0x00ed, B:44:0x00fb, B:51:0x0106, B:59:0x013a, B:61:0x0142, B:63:0x014a, B:64:0x0151, B:58:0x0125, B:67:0x0154, B:68:0x0155, B:69:0x015c, B:70:0x015d, B:71:0x0164, B:74:0x0167, B:75:0x0168, B:77:0x0187, B:79:0x019a, B:81:0x01a2, B:87:0x01de, B:89:0x01e4, B:90:0x01ed, B:91:0x01f4, B:82:0x01b3, B:83:0x01ba, B:85:0x01bd, B:86:0x01ce, B:92:0x01f5, B:93:0x01fc, B:94:0x01fd, B:95:0x0204, B:101:0x0210), top: B:151:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:89:0x01e4 A[Catch: all -> 0x011c, LoadingException -> 0x011f, RemoteException -> 0x0122, TryCatch #8 {RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c, blocks: (B:26:0x00ad, B:32:0x00b9, B:34:0x00c0, B:35:0x00db, B:39:0x00e1, B:41:0x00e9, B:43:0x00ed, B:44:0x00fb, B:51:0x0106, B:59:0x013a, B:61:0x0142, B:63:0x014a, B:64:0x0151, B:58:0x0125, B:67:0x0154, B:68:0x0155, B:69:0x015c, B:70:0x015d, B:71:0x0164, B:74:0x0167, B:75:0x0168, B:77:0x0187, B:79:0x019a, B:81:0x01a2, B:87:0x01de, B:89:0x01e4, B:90:0x01ed, B:91:0x01f4, B:82:0x01b3, B:83:0x01ba, B:85:0x01bd, B:86:0x01ce, B:92:0x01f5, B:93:0x01fc, B:94:0x01fd, B:95:0x0204, B:101:0x0210), top: B:151:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:90:0x01ed A[Catch: all -> 0x011c, LoadingException -> 0x011f, RemoteException -> 0x0122, TryCatch #8 {RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c, blocks: (B:26:0x00ad, B:32:0x00b9, B:34:0x00c0, B:35:0x00db, B:39:0x00e1, B:41:0x00e9, B:43:0x00ed, B:44:0x00fb, B:51:0x0106, B:59:0x013a, B:61:0x0142, B:63:0x014a, B:64:0x0151, B:58:0x0125, B:67:0x0154, B:68:0x0155, B:69:0x015c, B:70:0x015d, B:71:0x0164, B:74:0x0167, B:75:0x0168, B:77:0x0187, B:79:0x019a, B:81:0x01a2, B:87:0x01de, B:89:0x01e4, B:90:0x01ed, B:91:0x01f4, B:82:0x01b3, B:83:0x01ba, B:85:0x01bd, B:86:0x01ce, B:92:0x01f5, B:93:0x01fc, B:94:0x01fd, B:95:0x0204, B:101:0x0210), top: B:151:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:92:0x01f5 A[Catch: all -> 0x011c, LoadingException -> 0x011f, RemoteException -> 0x0122, TryCatch #8 {RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c, blocks: (B:26:0x00ad, B:32:0x00b9, B:34:0x00c0, B:35:0x00db, B:39:0x00e1, B:41:0x00e9, B:43:0x00ed, B:44:0x00fb, B:51:0x0106, B:59:0x013a, B:61:0x0142, B:63:0x014a, B:64:0x0151, B:58:0x0125, B:67:0x0154, B:68:0x0155, B:69:0x015c, B:70:0x015d, B:71:0x0164, B:74:0x0167, B:75:0x0168, B:77:0x0187, B:79:0x019a, B:81:0x01a2, B:87:0x01de, B:89:0x01e4, B:90:0x01ed, B:91:0x01f4, B:82:0x01b3, B:83:0x01ba, B:85:0x01bd, B:86:0x01ce, B:92:0x01f5, B:93:0x01fc, B:94:0x01fd, B:95:0x0204, B:101:0x0210), top: B:151:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:94:0x01fd A[Catch: all -> 0x011c, LoadingException -> 0x011f, RemoteException -> 0x0122, TryCatch #8 {RemoteException -> 0x0122, LoadingException -> 0x011f, all -> 0x011c, blocks: (B:26:0x00ad, B:32:0x00b9, B:34:0x00c0, B:35:0x00db, B:39:0x00e1, B:41:0x00e9, B:43:0x00ed, B:44:0x00fb, B:51:0x0106, B:59:0x013a, B:61:0x0142, B:63:0x014a, B:64:0x0151, B:58:0x0125, B:67:0x0154, B:68:0x0155, B:69:0x015c, B:70:0x015d, B:71:0x0164, B:74:0x0167, B:75:0x0168, B:77:0x0187, B:79:0x019a, B:81:0x01a2, B:87:0x01de, B:89:0x01e4, B:90:0x01ed, B:91:0x01f4, B:82:0x01b3, B:83:0x01ba, B:85:0x01bd, B:86:0x01ce, B:92:0x01f5, B:93:0x01fc, B:94:0x01fd, B:95:0x0204, B:101:0x0210), top: B:151:0x00ad }] */
    /* JADX WARN: Code duplicated, block: B:98:0x0207 A[Catch: all -> 0x0205, TRY_ENTER, TryCatch #3 {, blocks: (B:27:0x00ae, B:29:0x00b4, B:30:0x00b6, B:98:0x0207, B:99:0x020e), top: B:146:0x00ae }] */
    /* JADX WARN: Instruction removed from duplicated block: B:125:0x0287, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:34:0x00c0, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:75:0x0168, please report this as an issue */
    public static DynamiteModule load(Context context, VersionPolicy versionPolicy, String str) throws Throwable {
        long j;
        DynamiteModule dynamiteModule;
        int i;
        Boolean bool;
        zzq zzqVarZzg;
        int i2;
        IObjectWrapper iObjectWrapperZzh;
        Object objUnwrap;
        DynamiteModule dynamiteModule2;
        zzn zznVar;
        zzr zzrVar;
        zzn zznVar2;
        boolean z;
        IObjectWrapper iObjectWrapperZze;
        Cursor cursor;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            throw new LoadingException("null application Context");
        }
        ThreadLocal threadLocal = zzg;
        zzn zznVar3 = (zzn) threadLocal.get();
        zzn zznVar4 = new zzn();
        threadLocal.set(zznVar4);
        zzd zzdVar = zzh;
        Long l = (Long) zzdVar.get();
        long jLongValue = l.longValue();
        try {
            zzdVar.set(Long.valueOf(SystemClock.elapsedRealtime()));
            ViewUtils.RelativePadding relativePaddingSelectModule = versionPolicy.selectModule(context, str, zzi);
            j = jLongValue;
            try {
                Log.i("DynamiteModule", "Considering local module " + str + ":" + relativePaddingSelectModule.start + " and remote module " + str + ":" + relativePaddingSelectModule.end);
                int i3 = relativePaddingSelectModule.bottom;
                if (i3 != 0) {
                    if (i3 != -1) {
                        if (i3 == 1 || relativePaddingSelectModule.end != 0) {
                            if (i3 == -1) {
                                Log.i("DynamiteModule", "Selected local version of ".concat(String.valueOf(str)));
                                dynamiteModule = new DynamiteModule(applicationContext);
                            } else {
                                if (i3 == 1) {
                                    throw new LoadingException("VersionPolicy returned invalid code:" + i3);
                                }
                                try {
                                    i = relativePaddingSelectModule.end;
                                    try {
                                        synchronized (DynamiteModule.class) {
                                            if (zzf(context)) {
                                                throw new LoadingException("Remote loading disabled");
                                            }
                                            bool = zzb;
                                        }
                                        if (bool != null) {
                                            throw new LoadingException("Failed to determine which loading route to use.");
                                        }
                                        if (bool.booleanValue()) {
                                            Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i);
                                            synchronized (DynamiteModule.class) {
                                                zzrVar = zzl;
                                            }
                                            if (zzrVar != null) {
                                                throw new LoadingException("DynamiteLoaderV2 was not cached.");
                                            }
                                            zznVar2 = (zzn) threadLocal.get();
                                            if (zznVar2 != null || zznVar2.zza == null) {
                                                throw new LoadingException("No result cursor");
                                            }
                                            Context applicationContext2 = context.getApplicationContext();
                                            Cursor cursor2 = zznVar2.zza;
                                            new ObjectWrapper(null);
                                            synchronized (DynamiteModule.class) {
                                                z = zze >= 2;
                                            }
                                            if (z) {
                                                Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                                                iObjectWrapperZze = zzrVar.zzf(new ObjectWrapper(applicationContext2), str, i, new ObjectWrapper(cursor2));
                                            } else {
                                                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                                                iObjectWrapperZze = zzrVar.zze(new ObjectWrapper(applicationContext2), str, i, new ObjectWrapper(cursor2));
                                            }
                                            Context context2 = (Context) ObjectWrapper.unwrap(iObjectWrapperZze);
                                            if (context2 == null) {
                                                throw new LoadingException("Failed to get module context");
                                            }
                                            dynamiteModule2 = new DynamiteModule(context2);
                                        } else {
                                            Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i);
                                            zzqVarZzg = zzg(context);
                                            if (zzqVarZzg != null) {
                                                throw new LoadingException("Failed to create IDynamiteLoader.");
                                            }
                                            Parcel parcelZzB = zzqVarZzg.zzB(zzqVarZzg.zza(), 6);
                                            i2 = parcelZzB.readInt();
                                            parcelZzB.recycle();
                                            if (i2 >= 3) {
                                                zznVar = (zzn) threadLocal.get();
                                                if (zznVar != null) {
                                                    throw new LoadingException("No cached result cursor holder");
                                                }
                                                iObjectWrapperZzh = zzqVarZzg.zzi(new ObjectWrapper(context), str, i, new ObjectWrapper(zznVar.zza));
                                            } else if (i2 == 2) {
                                                Log.w("DynamiteModule", "IDynamite loader version = 2");
                                                iObjectWrapperZzh = zzqVarZzg.zzj(new ObjectWrapper(context), str, i);
                                            } else {
                                                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                                                iObjectWrapperZzh = zzqVarZzg.zzh(new ObjectWrapper(context), str, i);
                                            }
                                            objUnwrap = ObjectWrapper.unwrap(iObjectWrapperZzh);
                                            if (objUnwrap != null) {
                                                throw new LoadingException("Failed to load remote module.");
                                            }
                                            dynamiteModule2 = new DynamiteModule((Context) objUnwrap);
                                        }
                                        dynamiteModule = dynamiteModule2;
                                    } catch (RemoteException e) {
                                        throw new LoadingException("Failed to load remote module.", e);
                                    } catch (LoadingException e2) {
                                        throw e2;
                                    } catch (Throwable th) {
                                        throw new LoadingException("Failed to load remote module.", th);
                                    }
                                } catch (LoadingException e3) {
                                    Log.w("DynamiteModule", "Failed to load remote module: " + e3.getMessage());
                                    int i4 = relativePaddingSelectModule.start;
                                    if (i4 == 0 || versionPolicy.selectModule(context, str, new zzo(i4)).bottom != -1) {
                                        throw new LoadingException("Remote load failed. No local fallback found.", e3);
                                    }
                                    Log.i("DynamiteModule", "Selected local version of ".concat(String.valueOf(str)));
                                    dynamiteModule = new DynamiteModule(applicationContext);
                                }
                            }
                            if (j == 0) {
                                zzh.remove();
                            } else {
                                zzh.set(l);
                            }
                            cursor = zznVar4.zza;
                            if (cursor != null) {
                                cursor.close();
                            }
                            zzg.set(zznVar3);
                            return dynamiteModule;
                        }
                    } else if (relativePaddingSelectModule.start != 0) {
                        i3 = -1;
                        if (i3 == 1) {
                        }
                        if (i3 == -1) {
                            Log.i("DynamiteModule", "Selected local version of ".concat(String.valueOf(str)));
                            dynamiteModule = new DynamiteModule(applicationContext);
                        } else {
                            if (i3 == 1) {
                                throw new LoadingException("VersionPolicy returned invalid code:" + i3);
                            }
                            i = relativePaddingSelectModule.end;
                            synchronized (DynamiteModule.class) {
                                if (zzf(context)) {
                                    throw new LoadingException("Remote loading disabled");
                                }
                                bool = zzb;
                                if (bool != null) {
                                    throw new LoadingException("Failed to determine which loading route to use.");
                                }
                                if (bool.booleanValue()) {
                                    Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i);
                                    synchronized (DynamiteModule.class) {
                                        zzrVar = zzl;
                                        if (zzrVar != null) {
                                            throw new LoadingException("DynamiteLoaderV2 was not cached.");
                                        }
                                        zznVar2 = (zzn) threadLocal.get();
                                        if (zznVar2 != null) {
                                        }
                                        throw new LoadingException("No result cursor");
                                    }
                                }
                                Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i);
                                zzqVarZzg = zzg(context);
                                if (zzqVarZzg != null) {
                                    throw new LoadingException("Failed to create IDynamiteLoader.");
                                }
                                Parcel parcelZzB2 = zzqVarZzg.zzB(zzqVarZzg.zza(), 6);
                                i2 = parcelZzB2.readInt();
                                parcelZzB2.recycle();
                                if (i2 >= 3) {
                                    zznVar = (zzn) threadLocal.get();
                                    if (zznVar != null) {
                                        throw new LoadingException("No cached result cursor holder");
                                    }
                                    iObjectWrapperZzh = zzqVarZzg.zzi(new ObjectWrapper(context), str, i, new ObjectWrapper(zznVar.zza));
                                } else if (i2 == 2) {
                                    Log.w("DynamiteModule", "IDynamite loader version = 2");
                                    iObjectWrapperZzh = zzqVarZzg.zzj(new ObjectWrapper(context), str, i);
                                } else {
                                    Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                                    iObjectWrapperZzh = zzqVarZzg.zzh(new ObjectWrapper(context), str, i);
                                }
                                objUnwrap = ObjectWrapper.unwrap(iObjectWrapperZzh);
                                if (objUnwrap != null) {
                                    throw new LoadingException("Failed to load remote module.");
                                }
                                dynamiteModule2 = new DynamiteModule((Context) objUnwrap);
                                dynamiteModule = dynamiteModule2;
                            }
                        }
                        if (j == 0) {
                            zzh.remove();
                        } else {
                            zzh.set(l);
                        }
                        cursor = zznVar4.zza;
                        if (cursor != null) {
                            cursor.close();
                        }
                        zzg.set(zznVar3);
                        return dynamiteModule;
                    }
                }
                throw new LoadingException("No acceptable module " + str + " found. Local version is " + relativePaddingSelectModule.start + " and remote version is " + relativePaddingSelectModule.end + ".");
            } catch (Throwable th2) {
                th = th2;
                if (j == 0) {
                    zzh.remove();
                } else {
                    zzh.set(l);
                }
                Cursor cursor3 = zznVar4.zza;
                if (cursor3 != null) {
                    cursor3.close();
                }
                zzg.set(zznVar3);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            j = jLongValue;
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x017f  */
    /* JADX WARN: Code duplicated, block: B:50:0x00b0 A[Catch: all -> 0x0037, TryCatch #11 {all -> 0x0037, blocks: (B:9:0x0027, B:11:0x0033, B:51:0x00b9, B:16:0x003c, B:18:0x0043, B:20:0x0049, B:25:0x0050, B:27:0x0054, B:30:0x005d, B:32:0x0065, B:35:0x006c, B:42:0x0098, B:43:0x00a0, B:38:0x0073, B:40:0x0079, B:41:0x008a, B:46:0x00a3, B:49:0x00a6, B:50:0x00b0, B:17:0x003f), top: B:147:0x0027, inners: #12 }] */
    public static int zza(Context context, String str, boolean z) {
        Throwable th;
        RemoteException remoteException;
        int i;
        Cursor cursor;
        try {
            synchronized (DynamiteModule.class) {
                Boolean bool = zzb;
                boolean z2 = true;
                Cursor cursor2 = null;
                if (bool == null) {
                    try {
                        Field declaredField = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName()).getDeclaredField("sClassLoader");
                        synchronized (declaredField.getDeclaringClass()) {
                            try {
                                ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                                if (classLoader == ClassLoader.getSystemClassLoader()) {
                                    bool = Boolean.FALSE;
                                } else if (classLoader != null) {
                                    try {
                                        zzd(classLoader);
                                    } catch (LoadingException unused) {
                                    }
                                    bool = Boolean.TRUE;
                                } else {
                                    if (!zzf(context)) {
                                        return 0;
                                    }
                                    if (zzd) {
                                        declaredField.set(null, ClassLoader.getSystemClassLoader());
                                        bool = Boolean.FALSE;
                                    } else {
                                        Boolean bool2 = Boolean.TRUE;
                                        if (bool2.equals(null)) {
                                            declaredField.set(null, ClassLoader.getSystemClassLoader());
                                            bool = Boolean.FALSE;
                                        } else {
                                            try {
                                                int iZzb = zzb(context, str, z, true);
                                                String str2 = zzc;
                                                if (str2 != null && !str2.isEmpty()) {
                                                    ClassLoader classLoaderZza = ResultKt.zza();
                                                    if (classLoaderZza == null) {
                                                        if (Build.VERSION.SDK_INT >= 29) {
                                                            DynamiteModule$$ExternalSyntheticApiModelOutline0.m();
                                                            String str3 = zzc;
                                                            zzah.checkNotNull(str3);
                                                            classLoaderZza = DynamiteModule$$ExternalSyntheticApiModelOutline0.m(ClassLoader.getSystemClassLoader(), str3);
                                                        } else {
                                                            String str4 = zzc;
                                                            zzah.checkNotNull(str4);
                                                            classLoaderZza = new zzc(str4, ClassLoader.getSystemClassLoader());
                                                        }
                                                    }
                                                    zzd(classLoaderZza);
                                                    declaredField.set(null, classLoaderZza);
                                                    zzb = bool2;
                                                    return iZzb;
                                                }
                                                return iZzb;
                                            } catch (LoadingException unused2) {
                                                declaredField.set(null, ClassLoader.getSystemClassLoader());
                                                bool = Boolean.FALSE;
                                            }
                                        }
                                    }
                                }
                                zzb = bool;
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
                        Log.w("DynamiteModule", "Failed to load module via V2: " + e.toString());
                        bool = Boolean.FALSE;
                    }
                }
                if (bool.booleanValue()) {
                    try {
                        return zzb(context, str, z, false);
                    } catch (LoadingException e2) {
                        Log.w("DynamiteModule", "Failed to retrieve remote module version: " + e2.getMessage());
                        return 0;
                    }
                }
                zzq zzqVarZzg = zzg(context);
                try {
                    if (zzqVarZzg == null) {
                        return 0;
                    }
                    try {
                        Parcel parcelZzB = zzqVarZzg.zzB(zzqVarZzg.zza(), 6);
                        int i2 = parcelZzB.readInt();
                        parcelZzB.recycle();
                        if (i2 >= 3) {
                            ThreadLocal threadLocal = zzg;
                            zzn zznVar = (zzn) threadLocal.get();
                            if (zznVar != null && (cursor = zznVar.zza) != null) {
                                return cursor.getInt(0);
                            }
                            Cursor cursor3 = (Cursor) ObjectWrapper.unwrap(zzqVarZzg.zzk(new ObjectWrapper(context), str, z, ((Long) zzh.get()).longValue()));
                            if (cursor3 != null) {
                                try {
                                    if (cursor3.moveToFirst()) {
                                        i = cursor3.getInt(0);
                                        if (i > 0) {
                                            zzn zznVar2 = (zzn) threadLocal.get();
                                            if (zznVar2 == null || zznVar2.zza != null) {
                                                z2 = false;
                                            } else {
                                                zznVar2.zza = cursor3;
                                            }
                                            cursor2 = z2 ? null : cursor3;
                                        }
                                        if (cursor2 != null) {
                                            cursor2.close();
                                        }
                                    }
                                } catch (RemoteException e3) {
                                    remoteException = e3;
                                    cursor2 = cursor3;
                                    Log.w("DynamiteModule", "Failed to retrieve remote module version: " + remoteException.getMessage());
                                    if (cursor2 == null) {
                                        return 0;
                                    }
                                    cursor2.close();
                                    return 0;
                                } catch (Throwable th3) {
                                    th = th3;
                                    cursor2 = cursor3;
                                    if (cursor2 == null) {
                                        throw th;
                                    }
                                    cursor2.close();
                                    throw th;
                                }
                            }
                            Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                            if (cursor3 == null) {
                                return 0;
                            }
                            cursor3.close();
                            return 0;
                        }
                        if (i2 == 2) {
                            Log.w("DynamiteModule", "IDynamite loader version = 2, no high precision latency measurement.");
                            ObjectWrapper objectWrapper = new ObjectWrapper(context);
                            Parcel parcelZza = zzqVarZzg.zza();
                            com.google.android.gms.internal.common.zzc.zze(parcelZza, objectWrapper);
                            parcelZza.writeString(str);
                            parcelZza.writeInt(z ? 1 : 0);
                            Parcel parcelZzB2 = zzqVarZzg.zzB(parcelZza, 5);
                            i = parcelZzB2.readInt();
                            parcelZzB2.recycle();
                        } else {
                            Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
                            ObjectWrapper objectWrapper2 = new ObjectWrapper(context);
                            Parcel parcelZza2 = zzqVarZzg.zza();
                            com.google.android.gms.internal.common.zzc.zze(parcelZza2, objectWrapper2);
                            parcelZza2.writeString(str);
                            parcelZza2.writeInt(z ? 1 : 0);
                            Parcel parcelZzB3 = zzqVarZzg.zzB(parcelZza2, 3);
                            i = parcelZzB3.readInt();
                            parcelZzB3.recycle();
                        }
                        return i;
                    } catch (RemoteException e4) {
                        remoteException = e4;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        } catch (Throwable th5) {
            try {
                zzah.checkNotNull(context);
                throw th5;
            } catch (Exception e5) {
                Log.e("CrashUtils", "Error adding exception to DropBox!", e5);
                throw th5;
            }
        }
    }

    public static int zzb(Context context, String str, boolean z, boolean z2) throws Throwable {
        Throwable th;
        Exception exc;
        boolean z3;
        Cursor cursor = null;
        try {
            try {
                boolean z4 = true;
                Cursor cursorQuery = context.getContentResolver().query(new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").path(true != z ? "api" : "api_force_staging").appendPath(str).appendQueryParameter("requestStartTime", String.valueOf(((Long) zzh.get()).longValue())).build(), null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            boolean z5 = false;
                            int i = cursorQuery.getInt(0);
                            if (i > 0) {
                                synchronized (DynamiteModule.class) {
                                    try {
                                        zzc = cursorQuery.getString(2);
                                        int columnIndex = cursorQuery.getColumnIndex("loaderVersion");
                                        if (columnIndex >= 0) {
                                            zze = cursorQuery.getInt(columnIndex);
                                        }
                                        int columnIndex2 = cursorQuery.getColumnIndex("disableStandaloneDynamiteLoader2");
                                        if (columnIndex2 >= 0) {
                                            z3 = cursorQuery.getInt(columnIndex2) != 0;
                                            zzd = z3;
                                        } else {
                                            z3 = false;
                                        }
                                    } catch (Throwable th2) {
                                        throw th2;
                                    }
                                }
                                zzn zznVar = (zzn) zzg.get();
                                if (zznVar == null || zznVar.zza != null) {
                                    z4 = false;
                                } else {
                                    zznVar.zza = cursorQuery;
                                }
                                cursor = z4 ? null : cursorQuery;
                                z5 = z3;
                            } else {
                                cursor = cursorQuery;
                            }
                            if (z2 && z5) {
                                throw new LoadingException("forcing fallback to container DynamiteLoader impl");
                            }
                            if (cursor != null) {
                                cursor.close();
                            }
                            return i;
                            if (exc instanceof LoadingException) {
                                throw exc;
                            }
                            throw new LoadingException("V2 version check failed: " + exc.getMessage(), exc);
                        }
                    } catch (Exception e) {
                        exc = e;
                    } catch (Throwable th3) {
                        cursor = cursorQuery;
                        th = th3;
                        if (cursor == null) {
                            throw th;
                        }
                        cursor.close();
                        throw th;
                    }
                }
                Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                throw new LoadingException("Failed to connect to dynamite module ContentResolver.");
            } catch (Exception e2) {
                exc = e2;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static void zzd(ClassLoader classLoader) throws LoadingException {
        try {
            zzr zzrVar = null;
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(null).newInstance(null);
            if (iBinder != null) {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                zzrVar = iInterfaceQueryLocalInterface instanceof zzr ? (zzr) iInterfaceQueryLocalInterface : new zzr(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2", 1);
            }
            zzl = zzrVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new LoadingException("Failed to instantiate dynamite loader", e);
        }
    }

    public static boolean zzf(Context context) {
        ApplicationInfo applicationInfo;
        Boolean bool = Boolean.TRUE;
        if (bool.equals(null) || bool.equals(zzf)) {
            return true;
        }
        boolean z = false;
        if (zzf == null) {
            ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0);
            if (GoogleApiAvailabilityLight.zza.isGooglePlayServicesAvailable(context, 10000000) == 0 && providerInfoResolveContentProvider != null && "com.google.android.gms".equals(providerInfoResolveContentProvider.packageName)) {
                z = true;
            }
            zzf = Boolean.valueOf(z);
            if (z && (applicationInfo = providerInfoResolveContentProvider.applicationInfo) != null && (applicationInfo.flags & 129) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                zzd = true;
            }
        }
        if (!z) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z;
    }

    public static zzq zzg(Context context) {
        zzq zzqVar;
        synchronized (DynamiteModule.class) {
            zzq zzqVar2 = zzk;
            if (zzqVar2 != null) {
                return zzqVar2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzqVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    zzqVar = iInterfaceQueryLocalInterface instanceof zzq ? (zzq) iInterfaceQueryLocalInterface : new zzq(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader", 1);
                }
                if (zzqVar != null) {
                    zzk = zzqVar;
                    return zzqVar;
                }
            } catch (Exception e) {
                Log.e("DynamiteModule", "Failed to load IDynamiteLoader from GmsCore: " + e.getMessage());
            }
            return null;
        }
    }

    public final IBinder instantiate(String str) {
        try {
            return (IBinder) this.zzj.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new LoadingException("Failed to instantiate module class: ".concat(str), e);
        }
    }
}
