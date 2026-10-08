package coil.network;

import android.content.Context;
import android.graphics.Rect;
import android.media.CamcorderProfile;
import android.os.Bundle;
import android.util.Log;
import androidx.camera.camera2.internal.CamcorderProfileHelper;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.utils.futures.ImmediateFuture$ImmediateFailedFuture;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.snapping.AnimationResult;
import androidx.compose.foundation.gestures.snapping.ApproachAnimation;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$tryApproach$1;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavControllerViewModel;
import androidx.navigation.NavDestination;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.zzi;
import com.google.android.gms.tasks.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.RestrictedComponentContainer;
import com.google.mlkit.common.sdkinternal.Cleaner;
import com.google.mlkit.common.sdkinternal.zza;
import com.google.mlkit.common.sdkinternal.zzd;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executors;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function1;
import kotlin.uuid.UuidKt;
import okhttp3.Protocol;
import okio.Buffer;
import okio.ByteString;
import okio.Path;
import okio.internal.ResourceFileSystem;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class EmptyNetworkObserver implements CamcorderProfileHelper, CameraControlInternal, ApproachAnimation, CreationExtras.Key, NetworkObserver, Factory, ComponentFactory, OnFailureListener {
    public static EmptyNetworkObserver DEFAULT;

    public static final boolean access$keepPath(Path path) {
        Path path2 = ResourceFileSystem.ROOT;
        ByteString byteStringSubstring$default = path.bytes;
        ByteString byteString = okio.internal.Path.SLASH;
        byteStringSubstring$default.getClass();
        int iLastIndexOf = byteStringSubstring$default.lastIndexOf(byteString.internalArray$okio());
        if (iLastIndexOf == -1) {
            ByteString byteString2 = path.bytes;
            ByteString byteString3 = okio.internal.Path.BACKSLASH;
            byteString2.getClass();
            iLastIndexOf = byteString2.lastIndexOf(byteString3.internalArray$okio());
        }
        if (iLastIndexOf != -1) {
            byteStringSubstring$default = ByteString.substring$default(byteStringSubstring$default, iLastIndexOf + 1, 0, 2);
        } else if (path.volumeLetter() != null && byteStringSubstring$default.getSize$okio() == 2) {
            byteStringSubstring$default = ByteString.EMPTY;
        }
        String strUtf8 = byteStringSubstring$default.utf8();
        return !strUtf8.regionMatches(true, strUtf8.length() - 6, ".class", 0, 6);
    }

    public static ArrayList alpnProtocolNames(List list) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((Protocol) obj) != Protocol.HTTP_1_0) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj2 = arrayList.get(i);
            i++;
            arrayList2.add(((Protocol) obj2).protocol);
        }
        return arrayList2;
    }

    public static byte[] concatLengthPrefixed(List list) {
        Buffer buffer = new Buffer();
        ArrayList arrayListAlpnProtocolNames = alpnProtocolNames(list);
        int size = arrayListAlpnProtocolNames.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListAlpnProtocolNames.get(i);
            i++;
            String str = (String) obj;
            buffer.m857writeByte(str.length());
            buffer.writeUtf8(0, str.length(), str);
        }
        return buffer.readByteArray(buffer.size);
    }

    public static NavBackStackEntry create$default(Context context, NavDestination navDestination, Bundle bundle, Lifecycle.State state, NavControllerViewModel navControllerViewModel) {
        return new NavBackStackEntry(context, navDestination, bundle, state, navControllerViewModel, UUID.randomUUID().toString(), null);
    }

    public static boolean isAndroid() {
        return "Dalvik".equals(System.getProperty("java.vm.name"));
    }

    @Override // androidx.compose.foundation.gestures.snapping.ApproachAnimation
    public Object approachAnimation(ScrollScope scrollScope, Float f, Float f2, Function1 function1, SnapFlingBehavior$tryApproach$1 snapFlingBehavior$tryApproach$1) {
        Object objAccess$animateDecay = UuidKt.access$animateDecay(scrollScope, f.floatValue(), ArcSplineKt.AnimationState$default(0.0f, f2.floatValue(), 28), ScrollableKt.NoOpDecayAnimationSpec, function1, snapFlingBehavior$tryApproach$1);
        return objAccess$animateDecay == CoroutineSingletons.COROUTINE_SUSPENDED ? objAccess$animateDecay : (AnimationResult) objAccess$animateDecay;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public Object create(RestrictedComponentContainer restrictedComponentContainer) {
        Cleaner cleaner = new Cleaner();
        zza zzaVar = new zza(0);
        ReferenceQueue referenceQueue = cleaner.zza;
        Set set = cleaner.zzb;
        set.add(new zzd(cleaner, referenceQueue, set, zzaVar));
        Thread thread = new Thread(new zzi(24, referenceQueue, set), "MlKitCleaner");
        thread.setDaemon(true);
        thread.start();
        return cleaner;
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public ListenableFuture enableTorch(boolean z) {
        return ImmediateFuture$ImmediateFailedFuture.NULL_FUTURE;
    }

    @Override // javax.inject.Provider
    public Object get() {
        return new zzu(3, Executors.newSingleThreadExecutor());
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public Config getInteropConfig() {
        return null;
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public Rect getSensorRect() {
        return new Rect();
    }

    @Override // androidx.camera.camera2.internal.CamcorderProfileHelper
    public boolean hasProfile(int i, int i2) {
        return CamcorderProfile.hasProfile(i, i2);
    }

    @Override // coil.network.NetworkObserver
    public boolean isOnline() {
        return true;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        Log.e("OptionalModuleUtils", "Failed to check feature availability", exc);
    }

    @Override // androidx.camera.camera2.internal.CamcorderProfileHelper
    public CamcorderProfile get(int i, int i2) {
        return CamcorderProfile.get(i, i2);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void clearInteropConfig() {
    }

    @Override // coil.network.NetworkObserver
    public void shutdown() {
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void addInteropConfig(Config config) {
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void addZslConfig(SessionConfig.Builder builder) {
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void setFlashMode(int i) {
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public /* synthetic */ void setScreenFlash(ImageCapture.ScreenFlash screenFlash) {
    }
}
