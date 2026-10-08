package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Storage {
    public static final ReentrantLock zaa = new ReentrantLock();
    public static Storage zab;
    public final ReentrantLock zac = new ReentrantLock();
    public final SharedPreferences zad;

    public Storage(Context context) {
        this.zad = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public final String zaa(String str) {
        ReentrantLock reentrantLock = this.zac;
        reentrantLock.lock();
        try {
            return this.zad.getString(str, null);
        } finally {
            reentrantLock.unlock();
        }
    }
}
