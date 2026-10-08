package rikka.preference;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MultiProcessPreference implements SharedPreferences, Handler.Callback {
    public static final Object CONTENT = new Object();
    public final ContentResolver mContentResolver;
    public final Uri mUri;
    public final Object mLock = new Object();
    public final WeakHashMap mListeners = new WeakHashMap();
    public final AnonymousClass1 mListener = new AnonymousClass1();
    public final Handler mHandler = new Handler(Looper.getMainLooper(), this);

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Editor implements SharedPreferences.Editor {
        public final Bundle mData = new Bundle();
        public final ArrayList mActions = new ArrayList();
        public final ArrayList mKeys = new ArrayList();
        public final ArrayList mValues = new ArrayList();

        public Editor() {
        }

        @Override // android.content.SharedPreferences.Editor
        public final void apply() {
            finish(false);
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor clear() {
            this.mActions.add("clear");
            this.mKeys.add(null);
            this.mValues.add(null);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final boolean commit() {
            return finish(true);
        }

        public final boolean finish(boolean z) {
            ArrayList<String> arrayList = this.mActions;
            Bundle bundle = this.mData;
            bundle.putStringArrayList("editor_actions", arrayList);
            bundle.putStringArrayList("editor_keys", this.mKeys);
            bundle.putSerializable("editor_values", this.mValues);
            MultiProcessPreference multiProcessPreference = MultiProcessPreference.this;
            Bundle bundleCall = multiProcessPreference.mContentResolver.call(multiProcessPreference.mUri, z ? "editor_commit" : "editor_apply", (String) null, bundle);
            if (bundleCall == null) {
                return false;
            }
            return bundleCall.getBoolean("result", false);
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putBoolean(String str, boolean z) {
            this.mActions.add("putBoolean");
            this.mKeys.add(str);
            this.mValues.add(Boolean.valueOf(z));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putFloat(String str, float f) {
            this.mActions.add("putFloat");
            this.mKeys.add(str);
            this.mValues.add(Float.valueOf(f));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putInt(String str, int i) {
            this.mActions.add("putInt");
            this.mKeys.add(str);
            this.mValues.add(Integer.valueOf(i));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putLong(String str, long j) {
            this.mActions.add("putLong");
            this.mKeys.add(str);
            this.mValues.add(Long.valueOf(j));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putString(String str, String str2) {
            this.mActions.add("putString");
            this.mKeys.add(str);
            this.mValues.add(str2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putStringSet(String str, Set set) {
            this.mActions.add("putStringSet");
            this.mKeys.add(str);
            this.mValues.add(set == null ? null : new HashSet(set));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor remove(String str) {
            this.mActions.add("remove");
            this.mKeys.add(str);
            this.mValues.add(null);
            return this;
        }
    }

    public MultiProcessPreference(Context context, String str) {
        this.mContentResolver = context.getContentResolver();
        this.mUri = new Uri.Builder().scheme("content").authority(str).build();
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String str) {
        Objects.requireNonNull(str);
        return this.mContentResolver.call(this.mUri, "contains", str, (Bundle) null) != null;
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        return new Editor();
    }

    @Override // android.content.SharedPreferences
    public final Map getAll() {
        Bundle bundleCall = this.mContentResolver.call(this.mUri, "getAll", (String) null, (Bundle) null);
        if (bundleCall == null) {
            return null;
        }
        return (Map) bundleCall.getSerializable("result");
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String str, boolean z) {
        Objects.requireNonNull(str);
        Bundle bundleCall = this.mContentResolver.call(this.mUri, "getBoolean", str, (Bundle) null);
        return bundleCall == null ? z : bundleCall.getBoolean("result");
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String str, float f) {
        Objects.requireNonNull(str);
        Bundle bundleCall = this.mContentResolver.call(this.mUri, "getFloat", str, (Bundle) null);
        return bundleCall == null ? f : bundleCall.getFloat("result");
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String str, int i) {
        Objects.requireNonNull(str);
        Bundle bundleCall = this.mContentResolver.call(this.mUri, "getInt", str, (Bundle) null);
        return bundleCall == null ? i : bundleCall.getInt("result");
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String str, long j) {
        Objects.requireNonNull(str);
        Bundle bundleCall = this.mContentResolver.call(this.mUri, "getLong", str, (Bundle) null);
        return bundleCall == null ? j : bundleCall.getLong("result");
    }

    @Override // android.content.SharedPreferences
    public final String getString(String str, String str2) {
        Objects.requireNonNull(str);
        Bundle bundleCall = this.mContentResolver.call(this.mUri, "getString", str, (Bundle) null);
        return bundleCall == null ? str2 : bundleCall.getString("result", str2);
    }

    @Override // android.content.SharedPreferences
    public final Set getStringSet(String str, Set set) {
        Objects.requireNonNull(str);
        Bundle bundleCall = this.mContentResolver.call(this.mUri, "getStringSet", str, (Bundle) null);
        return bundleCall == null ? set : (Set) bundleCall.getSerializable("result");
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what != 100) {
            return false;
        }
        Object obj = message.obj;
        if (!(obj instanceof String)) {
            return false;
        }
        String str = (String) obj;
        for (SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener : this.mListeners.keySet()) {
            if (onSharedPreferenceChangeListener != null) {
                onSharedPreferenceChangeListener.onSharedPreferenceChanged(this, str);
            }
        }
        return true;
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        synchronized (this.mLock) {
            try {
                if (this.mListeners.isEmpty()) {
                    Bundle bundle = new Bundle();
                    AnonymousClass1 anonymousClass1 = this.mListener;
                    anonymousClass1.getClass();
                    bundle.putBinder("data", anonymousClass1);
                    this.mContentResolver.call(this.mUri, "registerListener", (String) null, bundle);
                }
                this.mListeners.put(onSharedPreferenceChangeListener, CONTENT);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        synchronized (this.mLock) {
            try {
                this.mListeners.remove(onSharedPreferenceChangeListener);
                if (this.mListeners.isEmpty()) {
                    Bundle bundle = new Bundle();
                    AnonymousClass1 anonymousClass1 = this.mListener;
                    anonymousClass1.getClass();
                    bundle.putBinder("data", anonymousClass1);
                    this.mContentResolver.call(this.mUri, "unregisterListener", (String) null, bundle);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: rikka.preference.MultiProcessPreference$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends Binder implements IMultiProcessPreferenceChangeListener {
        public static final /* synthetic */ int $r8$clinit = 0;

        public AnonymousClass1() {
            attachInterface(this, "rikka.preference.IMultiProcessPreferenceChangeListener");
        }

        @Override // rikka.preference.IMultiProcessPreferenceChangeListener
        public final void onPreferenceChanged(String str) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 100;
            messageObtain.obj = str;
            MultiProcessPreference.this.mHandler.sendMessage(messageObtain);
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("rikka.preference.IMultiProcessPreferenceChangeListener");
                return true;
            }
            parcel.enforceInterface("rikka.preference.IMultiProcessPreferenceChangeListener");
            onPreferenceChanged(parcel.readString());
            parcel2.writeNoException();
            return true;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }
    }
}
