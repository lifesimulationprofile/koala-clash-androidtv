package com.google.android.gms.internal.mlkit_vision_common;

import android.os.Trace;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.RememberObserverHolder;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.PausedCompositionRemembers;
import androidx.compose.runtime.tooling.ComposeStackTraceKt;
import androidx.compose.runtime.tooling.CompositionErrorContextImpl;
import java.io.Serializable;
import java.util.Iterator;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zzky {
    public Object zza;
    public Object zzb;
    public Object zzc;
    public Object zzd;
    public RandomAccess zze;
    public Object zzf;
    public Object zzg;
    public Object zzh;
    public Object zzi;
    public Serializable zzj;
    public Object zzk;

    public zzky() {
        MutableVector mutableVector = new MutableVector(new RememberObserverHolder[16]);
        this.zzc = mutableVector;
        MutableScatterSet mutableScatterSet = ScatterSetKt.EmptyScatterSet;
        this.zzd = new MutableScatterSet();
        this.zzf = mutableVector;
        this.zze = new MutableVector(new Object[16]);
        this.zzg = new MutableVector(new Function0[16]);
    }

    public static final boolean forgetting$removeFrom(RememberObserverHolder rememberObserverHolder, MutableVector mutableVector) {
        Object[] objArr = mutableVector.content;
        int i = mutableVector.size;
        for (int i2 = 0; i2 < i; i2++) {
            RememberObserver wrapped = ((RememberObserverHolder) objArr[i2]).getWrapped();
            if (wrapped instanceof PausedCompositionRemembers) {
                MutableVector mutableVector2 = ((PausedCompositionRemembers) wrapped).pausedRemembers;
                if (mutableVector2.remove(rememberObserverHolder) || forgetting$removeFrom(rememberObserverHolder, mutableVector2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void clear() {
        this.zza = null;
        this.zzb = null;
        MutableVector mutableVector = (MutableVector) this.zzc;
        mutableVector.clear();
        ((MutableScatterSet) this.zzd).clear();
        this.zzf = mutableVector;
        ((MutableVector) this.zze).clear();
        ((MutableVector) this.zzg).clear();
        this.zzh = null;
        this.zzi = null;
        this.zzj = null;
    }

    public void dispatchAbandons() {
        Set set = (Set) this.zza;
        if (set == null || set.isEmpty()) {
            return;
        }
        Trace.beginSection("Compose:abandons");
        try {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                RememberObserver rememberObserver = (RememberObserver) it.next();
                it.remove();
                rememberObserver.onAbandoned();
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    public void dispatchRememberObservers() {
        MutableVector mutableVector = (MutableVector) this.zzc;
        MutableVector mutableVector2 = (MutableVector) this.zze;
        Set set = (Set) this.zza;
        if (set == null) {
            return;
        }
        this.zzk = null;
        int i = 19;
        if (mutableVector2.size != 0) {
            Trace.beginSection("Compose:onForgotten");
            try {
                MutableScatterSet mutableScatterSet = (MutableScatterSet) this.zzh;
                int i2 = mutableVector2.size;
                while (true) {
                    i2--;
                    if (-1 >= i2) {
                        break;
                    }
                    Object obj = mutableVector2.content[i2];
                    try {
                        if (obj instanceof RememberObserverHolder) {
                            RememberObserver wrapped = ((RememberObserverHolder) obj).getWrapped();
                            set.remove(wrapped);
                            wrapped.onForgotten();
                        }
                        if (obj instanceof ComposeNodeLifecycleCallback) {
                            if (mutableScatterSet == null || !mutableScatterSet.contains(obj)) {
                                ((ComposeNodeLifecycleCallback) obj).onDeactivate();
                            } else {
                                ((ComposeNodeLifecycleCallback) obj).onRelease();
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th) {
                        CompositionErrorContextImpl compositionErrorContextImpl = (CompositionErrorContextImpl) this.zzb;
                        if (compositionErrorContextImpl != null) {
                            ComposeStackTraceKt.tryAttachComposeStackTrace(th, new Recomposer$$ExternalSyntheticLambda6(i, compositionErrorContextImpl, obj));
                        }
                        throw th;
                    }
                }
                Unit unit2 = Unit.INSTANCE;
                Trace.endSection();
            } catch (Throwable th2) {
                Trace.endSection();
                throw th2;
            }
        }
        if (mutableVector.size != 0) {
            Trace.beginSection("Compose:onRemembered");
            try {
                Set set2 = (Set) this.zza;
                if (set2 != null) {
                    Object[] objArr = mutableVector.content;
                    int i3 = mutableVector.size;
                    for (int i4 = 0; i4 < i3; i4++) {
                        RememberObserverHolder rememberObserverHolder = (RememberObserverHolder) objArr[i4];
                        RememberObserver wrapped2 = rememberObserverHolder.getWrapped();
                        set2.remove(wrapped2);
                        try {
                            wrapped2.onRemembered();
                            Unit unit3 = Unit.INSTANCE;
                        } catch (Throwable th3) {
                            CompositionErrorContextImpl compositionErrorContextImpl2 = (CompositionErrorContextImpl) this.zzb;
                            if (compositionErrorContextImpl2 != null) {
                                ComposeStackTraceKt.tryAttachComposeStackTrace(th3, new Recomposer$$ExternalSyntheticLambda6(i, compositionErrorContextImpl2, rememberObserverHolder));
                            }
                            throw th3;
                        }
                    }
                }
                Unit unit4 = Unit.INSTANCE;
                Trace.endSection();
            } catch (Throwable th4) {
                Trace.endSection();
                throw th4;
            }
        }
    }

    public void dispatchSideEffects() {
        MutableVector mutableVector = (MutableVector) this.zzg;
        if (mutableVector.size != 0) {
            Trace.beginSection("Compose:sideeffects");
            try {
                Object[] objArr = mutableVector.content;
                int i = mutableVector.size;
                for (int i2 = 0; i2 < i; i2++) {
                    ((Function0) objArr[i2]).invoke();
                }
                mutableVector.clear();
                Unit unit = Unit.INSTANCE;
            } finally {
                Trace.endSection();
            }
        }
    }

    public void forgetting(RememberObserverHolder rememberObserverHolder) {
        MutableVector mutableVector = (MutableVector) this.zzc;
        if (!((MutableScatterSet) this.zzd).contains(rememberObserverHolder)) {
            MutableScatterSet mutableScatterSet = (MutableScatterSet) this.zzk;
            if (mutableScatterSet == null || !mutableScatterSet.contains(rememberObserverHolder)) {
                ((MutableVector) this.zze).add(rememberObserverHolder);
                return;
            }
            return;
        }
        ((MutableScatterSet) this.zzd).remove(rememberObserverHolder);
        if (!((MutableVector) this.zzf).remove(rememberObserverHolder) && !mutableVector.remove(rememberObserverHolder)) {
            forgetting$removeFrom(rememberObserverHolder, mutableVector);
        }
        Set set = (Set) this.zza;
        if (set == null) {
            return;
        }
        set.add(rememberObserverHolder.getWrapped());
    }

    public void prepare(Set set, CompositionErrorContextImpl compositionErrorContextImpl) {
        clear();
        this.zza = set;
        this.zzb = compositionErrorContextImpl;
    }

    public void remembering(RememberObserverHolder rememberObserverHolder) {
        ((MutableVector) this.zzf).add(rememberObserverHolder);
        ((MutableScatterSet) this.zzd).add(rememberObserverHolder);
    }
}
