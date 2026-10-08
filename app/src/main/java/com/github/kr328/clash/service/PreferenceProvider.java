package com.github.kr328.clash.service;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import rikka.preference.IMultiProcessPreferenceChangeListener;
import rikka.preference.IMultiProcessPreferenceChangeListener$Stub$Proxy;
import rikka.preference.MultiProcessPreference;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class PreferenceProvider extends ContentProvider implements SharedPreferences.OnSharedPreferenceChangeListener {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final RemoteCallbackList mListeners = new RemoteCallbackList();
    public SharedPreferences mSharedPreferences;

    @Override // android.content.ContentProvider
    public final void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        SharedPreferences sharedPreferences = context.getSharedPreferences("service", 0);
        this.mSharedPreferences = sharedPreferences;
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
        new Uri.Builder().scheme("content").authority(providerInfo.authority).build();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // android.content.ContentProvider
    public final Bundle call(String str, String str2, Bundle bundle) {
        IMultiProcessPreferenceChangeListener iMultiProcessPreferenceChangeListener;
        IMultiProcessPreferenceChangeListener iMultiProcessPreferenceChangeListener2;
        IMultiProcessPreferenceChangeListener iMultiProcessPreferenceChangeListener3;
        str.getClass();
        byte b = -1;
        switch (str.hashCode()) {
            case -1249367445:
                if (str.equals("getAll")) {
                    b = 0;
                }
                break;
            case -1249359687:
                if (str.equals("getInt")) {
                    b = 1;
                }
                break;
            case -1161035703:
                if (str.equals("editor_commit")) {
                    b = 2;
                }
                break;
            case -1037975280:
                if (str.equals("unregisterListener")) {
                    b = 3;
                }
                break;
            case -732003812:
                if (str.equals("editor_apply")) {
                    b = 4;
                }
                break;
            case -567445985:
                if (str.equals("contains")) {
                    b = 5;
                }
                break;
            case -198897701:
                if (str.equals("getStringSet")) {
                    b = 6;
                }
                break;
            case -75354382:
                if (str.equals("getLong")) {
                    b = 7;
                }
                break;
            case 804029191:
                if (str.equals("getString")) {
                    b = 8;
                }
                break;
            case 1101572082:
                if (str.equals("getBoolean")) {
                    b = 9;
                }
                break;
            case 1115161719:
                if (str.equals("registerListener")) {
                    b = 10;
                }
                break;
            case 1953351846:
                if (str.equals("getFloat")) {
                    b = 11;
                }
                break;
        }
        switch (b) {
            case 0:
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("result", new HashMap(this.mSharedPreferences.getAll()));
                return bundle2;
            case 1:
                Objects.requireNonNull(str2);
                if (this.mSharedPreferences.contains(str2)) {
                    Bundle bundle3 = new Bundle();
                    bundle3.putInt("result", this.mSharedPreferences.getInt(str2, 0));
                    return bundle3;
                }
                iMultiProcessPreferenceChangeListener3 = iMultiProcessPreferenceChangeListener2;
                return null;
            case 2:
                Objects.requireNonNull(bundle);
                return edit(true, bundle);
            case 3:
                Objects.requireNonNull(bundle);
                IBinder binder = bundle.getBinder("data");
                int i = MultiProcessPreference.AnonymousClass1.$r8$clinit;
                if (binder == null) {
                    iMultiProcessPreferenceChangeListener = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = binder.queryLocalInterface("rikka.preference.IMultiProcessPreferenceChangeListener");
                    if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IMultiProcessPreferenceChangeListener)) {
                        IMultiProcessPreferenceChangeListener$Stub$Proxy iMultiProcessPreferenceChangeListener$Stub$Proxy = new IMultiProcessPreferenceChangeListener$Stub$Proxy();
                        iMultiProcessPreferenceChangeListener$Stub$Proxy.mRemote = binder;
                        iMultiProcessPreferenceChangeListener = iMultiProcessPreferenceChangeListener$Stub$Proxy;
                    } else {
                        iMultiProcessPreferenceChangeListener = (IMultiProcessPreferenceChangeListener) iInterfaceQueryLocalInterface;
                    }
                }
                unregisterOnSharedPreferenceChangeListener(iMultiProcessPreferenceChangeListener);
                return null;
            case 4:
                Objects.requireNonNull(bundle);
                return edit(false, bundle);
            case 5:
                Objects.requireNonNull(str2);
                if (this.mSharedPreferences.contains(str2)) {
                    return new Bundle();
                }
                iMultiProcessPreferenceChangeListener3 = iMultiProcessPreferenceChangeListener2;
                return null;
            case 6:
                Objects.requireNonNull(str2);
                if (this.mSharedPreferences.contains(str2)) {
                    Bundle bundle4 = new Bundle();
                    Set<String> stringSet = this.mSharedPreferences.getStringSet(str2, null);
                    bundle4.putSerializable("result", stringSet != null ? new HashSet(stringSet) : null);
                    return bundle4;
                }
                iMultiProcessPreferenceChangeListener3 = iMultiProcessPreferenceChangeListener2;
                return null;
            case 7:
                Objects.requireNonNull(str2);
                if (this.mSharedPreferences.contains(str2)) {
                    Bundle bundle5 = new Bundle();
                    bundle5.putLong("result", this.mSharedPreferences.getLong(str2, 0L));
                    return bundle5;
                }
                iMultiProcessPreferenceChangeListener3 = iMultiProcessPreferenceChangeListener2;
                return null;
            case 8:
                Objects.requireNonNull(str2);
                if (this.mSharedPreferences.contains(str2)) {
                    Bundle bundle6 = new Bundle();
                    bundle6.putString("result", this.mSharedPreferences.getString(str2, null));
                    return bundle6;
                }
                iMultiProcessPreferenceChangeListener3 = iMultiProcessPreferenceChangeListener2;
                return null;
            case 9:
                Objects.requireNonNull(str2);
                if (this.mSharedPreferences.contains(str2)) {
                    Bundle bundle7 = new Bundle();
                    bundle7.putBoolean("result", this.mSharedPreferences.getBoolean(str2, false));
                    return bundle7;
                }
                iMultiProcessPreferenceChangeListener3 = iMultiProcessPreferenceChangeListener2;
                return null;
            case 10:
                Objects.requireNonNull(bundle);
                IBinder binder2 = bundle.getBinder("data");
                int i2 = MultiProcessPreference.AnonymousClass1.$r8$clinit;
                if (binder2 == null) {
                    iMultiProcessPreferenceChangeListener3 = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface2 = binder2.queryLocalInterface("rikka.preference.IMultiProcessPreferenceChangeListener");
                    if (iInterfaceQueryLocalInterface2 == null || !(iInterfaceQueryLocalInterface2 instanceof IMultiProcessPreferenceChangeListener)) {
                        IMultiProcessPreferenceChangeListener$Stub$Proxy iMultiProcessPreferenceChangeListener$Stub$Proxy2 = new IMultiProcessPreferenceChangeListener$Stub$Proxy();
                        iMultiProcessPreferenceChangeListener$Stub$Proxy2.mRemote = binder2;
                        iMultiProcessPreferenceChangeListener3 = iMultiProcessPreferenceChangeListener$Stub$Proxy2;
                    } else {
                        iMultiProcessPreferenceChangeListener2 = (IMultiProcessPreferenceChangeListener) iInterfaceQueryLocalInterface2;
                    }
                }
                if (iMultiProcessPreferenceChangeListener3 != null) {
                    synchronized (this) {
                        iMultiProcessPreferenceChangeListener3 = iMultiProcessPreferenceChangeListener2;
                        this.mListeners.register(iMultiProcessPreferenceChangeListener3);
                        break;
                    }
                    return null;
                }
                iMultiProcessPreferenceChangeListener3 = iMultiProcessPreferenceChangeListener2;
                return null;
            case 11:
                Objects.requireNonNull(str2);
                if (this.mSharedPreferences.contains(str2)) {
                    Bundle bundle8 = new Bundle();
                    bundle8.putFloat("result", this.mSharedPreferences.getFloat(str2, 0.0f));
                    return bundle8;
                }
                iMultiProcessPreferenceChangeListener3 = iMultiProcessPreferenceChangeListener2;
                return null;
            default:
                throw new IllegalArgumentException("unsupported method ".concat(str));
        }
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public final Bundle edit(boolean z, Bundle bundle) {
        SharedPreferences.Editor editorEdit = this.mSharedPreferences.edit();
        ArrayList<String> stringArrayList = bundle.getStringArrayList("editor_actions");
        ArrayList<String> stringArrayList2 = bundle.getStringArrayList("editor_keys");
        List list = (List) bundle.getSerializable("editor_values");
        Objects.requireNonNull(stringArrayList);
        Objects.requireNonNull(stringArrayList2);
        Objects.requireNonNull(list);
        for (int i = 0; i < stringArrayList.size(); i++) {
            String str = stringArrayList.get(i);
            String str2 = stringArrayList2.get(i);
            Object obj = list.get(i);
            str.getClass();
            switch (str) {
                case "putStringSet":
                    editorEdit.putStringSet(str2, (Set) obj);
                    break;
                case "putInt":
                    editorEdit.putInt(str2, ((Integer) obj).intValue());
                    break;
                case "remove":
                    editorEdit.remove(str2);
                    break;
                case "putString":
                    editorEdit.putString(str2, (String) obj);
                    break;
                case "putLong":
                    editorEdit.putLong(str2, ((Long) obj).longValue());
                    break;
                case "clear":
                    editorEdit.clear();
                    break;
                case "putBoolean":
                    editorEdit.putBoolean(str2, ((Boolean) obj).booleanValue());
                    break;
                case "putFloat":
                    editorEdit.putFloat(str2, ((Float) obj).floatValue());
                    break;
            }
        }
        if (!z) {
            editorEdit.apply();
            return null;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("result", editorEdit.commit());
        return bundle2;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        return true;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        RemoteCallbackList remoteCallbackList = this.mListeners;
        int iBeginBroadcast = remoteCallbackList.beginBroadcast();
        while (iBeginBroadcast > 0) {
            iBeginBroadcast--;
            IMultiProcessPreferenceChangeListener iMultiProcessPreferenceChangeListener = (IMultiProcessPreferenceChangeListener) remoteCallbackList.getBroadcastItem(iBeginBroadcast);
            if (iMultiProcessPreferenceChangeListener != null) {
                try {
                    iMultiProcessPreferenceChangeListener.onPreferenceChanged(str);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
        remoteCallbackList.finishBroadcast();
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public final void unregisterOnSharedPreferenceChangeListener(IMultiProcessPreferenceChangeListener iMultiProcessPreferenceChangeListener) {
        if (iMultiProcessPreferenceChangeListener == null) {
            return;
        }
        synchronized (this) {
            this.mListeners.unregister(iMultiProcessPreferenceChangeListener);
        }
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
