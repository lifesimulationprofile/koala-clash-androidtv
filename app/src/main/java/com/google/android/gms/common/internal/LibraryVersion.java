package com.google.android.gms.common.internal;

import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LibraryVersion {
    public static final GmsLogger zza = new GmsLogger("LibraryVersion", "");
    public static final LibraryVersion zzb = new LibraryVersion();
    public final ConcurrentHashMap zzc = new ConcurrentHashMap();

    public final String getVersion(String str) throws Throwable {
        IOException e;
        String str2;
        InputStream resourceAsStream;
        GmsLogger gmsLogger = zza;
        zzah.checkNotEmpty(str, "Please provide a valid libraryName");
        ConcurrentHashMap concurrentHashMap = this.zzc;
        if (concurrentHashMap.containsKey(str)) {
            return (String) concurrentHashMap.get(str);
        }
        Properties properties = new Properties();
        InputStream inputStream = null;
        property = null;
        property = null;
        String property = null;
        InputStream inputStream2 = null;
        try {
            try {
                resourceAsStream = LibraryVersion.class.getResourceAsStream("/" + str + ".properties");
                try {
                    if (resourceAsStream != null) {
                        properties.load(resourceAsStream);
                        property = properties.getProperty("version", null);
                        String str3 = str + " version is " + property;
                        if (Log.isLoggable(gmsLogger.zza, 2)) {
                            Log.v("LibraryVersion", gmsLogger.zza(str3));
                        }
                    } else {
                        String str4 = "Failed to get app version for libraryName: " + str;
                        if (Log.isLoggable(gmsLogger.zza, 5)) {
                            Log.w("LibraryVersion", gmsLogger.zza(str4));
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    String str5 = property;
                    inputStream = resourceAsStream;
                    str2 = str5;
                    String str6 = "Failed to get app version for libraryName: " + str;
                    if (Log.isLoggable(gmsLogger.zza, 6)) {
                        Log.e("LibraryVersion", gmsLogger.zza(str6), e);
                    }
                    InputStream inputStream3 = inputStream;
                    property = str2;
                    resourceAsStream = inputStream3;
                } catch (Throwable th) {
                    th = th;
                    inputStream2 = resourceAsStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException unused) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e3) {
            e = e3;
            str2 = null;
        }
        if (resourceAsStream != null) {
            try {
                resourceAsStream.close();
            } catch (IOException unused2) {
            }
        }
        if (property == null) {
            if (Log.isLoggable(gmsLogger.zza, 3)) {
                Log.d("LibraryVersion", gmsLogger.zza(".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used"));
            }
            property = "UNKNOWN";
        }
        concurrentHashMap.put(str, property);
        return property;
    }
}
