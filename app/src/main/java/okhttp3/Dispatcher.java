package okhttp3;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.SupportActionModeWrapper;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.view.menu.MenuWrapperICS;
import androidx.appcompat.widget.Toolbar;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.imagecapture.AutoValue_CaptureNode_In;
import androidx.camera.core.imagecapture.CaptureNode$$ExternalSyntheticLambda4;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.Animations;
import androidx.compose.animation.core.FloatAnimationSpec;
import androidx.compose.animation.core.VectorizedFiniteAnimationSpec;
import androidx.compose.ui.autofill.Autofill;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPreFling$1;
import androidx.compose.ui.input.nestedscroll.NestedScrollNode;
import androidx.compose.ui.unit.Velocity;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.os.CancellationSignal;
import androidx.core.util.Pools$SimplePool;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.MetadataRepo$Node;
import androidx.emoji2.text.TypefaceEmojiRasterizer;
import androidx.emoji2.text.flatbuffer.MetadataItem;
import androidx.emoji2.text.flatbuffer.MetadataList;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManagerImpl;
import androidx.fragment.app.FragmentManagerViewModel;
import androidx.fragment.app.FragmentStateManager;
import androidx.fragment.app.SpecialEffectsController$FragmentStateManagerOperation;
import androidx.lifecycle.AtomicReference;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.lifecycle.viewmodel.internal.SynchronizedObject;
import androidx.navigationevent.NavigationEvent;
import androidx.navigationevent.NavigationEventHandler;
import androidx.navigationevent.NavigationEventInput;
import androidx.navigationevent.NavigationEventProcessor;
import androidx.navigationevent.NavigationEventTransitionState;
import androidx.navigationevent.OnBackInvokedDefaultInput;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomSQLiteQuery;
import coil.ImageLoader$Builder;
import coil.intercept.RealInterceptorChain;
import coil.memory.MemoryCacheService;
import coil.request.Parameters;
import coil.util.ContinuationCallback;
import com.github.kr328.clash.service.data.Database_Impl;
import com.github.kr328.clash.service.data.ImportedDao_Impl$7;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.io.InterruptedIOException;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.inject.Provider;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.CharsKt;
import kotlin.text.HexFormatKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.serialization.json.internal.Composer;
import okhttp3.internal.Util;
import okhttp3.internal.Util$$ExternalSyntheticLambda1;
import okhttp3.internal.connection.RealCall;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Dispatcher implements VectorizedFiniteAnimationSpec, Autofill, CancellationSignal.OnCancelListener, Factory, SelectClause1 {
    public Object executorServiceOrNull;
    public Object readyAsyncCalls;
    public Object runningAsyncCalls;
    public Object runningSyncCalls;

    public /* synthetic */ Dispatcher(Object obj, Object obj2, Object obj3, Object obj4) {
        this.executorServiceOrNull = obj;
        this.readyAsyncCalls = obj2;
        this.runningAsyncCalls = obj3;
        this.runningSyncCalls = obj4;
    }

    public static void addHandler$default(Dispatcher dispatcher, NavigationEventHandler navigationEventHandler) {
        dispatcher.getClass();
        if (((LinkedHashSet) dispatcher.runningAsyncCalls).add(navigationEventHandler)) {
            NavigationEventProcessor navigationEventProcessor = (NavigationEventProcessor) dispatcher.readyAsyncCalls;
            navigationEventProcessor.getClass();
            if (navigationEventHandler.dispatcher == null) {
                navigationEventProcessor.defaultHandlers.addFirst(navigationEventHandler);
                navigationEventHandler.dispatcher = dispatcher;
                navigationEventProcessor.refreshEnabledHandlers();
            } else {
                throw new IllegalArgumentException(("Handler '" + navigationEventHandler + "' is already registered with a dispatcher").toString());
            }
        }
    }

    public void addFragment(Fragment fragment) {
        if (((ArrayList) this.executorServiceOrNull).contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (((ArrayList) this.executorServiceOrNull)) {
            ((ArrayList) this.executorServiceOrNull).add(fragment);
        }
        fragment.mAdded = true;
    }

    public void addInput(NavigationEventInput navigationEventInput) {
        if (((LinkedHashSet) this.runningSyncCalls).add(navigationEventInput)) {
            ((NavigationEventProcessor) this.readyAsyncCalls).addInput(this, navigationEventInput, -1);
        }
    }

    public Request build() {
        HttpUrl httpUrl = (HttpUrl) this.executorServiceOrNull;
        if (httpUrl == null) {
            throw new IllegalStateException("url == null");
        }
        String str = (String) this.readyAsyncCalls;
        Headers headersBuild = ((Headers.Builder) this.runningAsyncCalls).build();
        LinkedHashMap linkedHashMap = (LinkedHashMap) this.runningSyncCalls;
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        return new Request(httpUrl, str, headersBuild, (RequestBody$Companion$toRequestBody$2) null, linkedHashMap.isEmpty() ? EmptyMap.INSTANCE : Collections.unmodifiableMap(new LinkedHashMap(linkedHashMap)));
    }

    public void cacheControl(CacheControl cacheControl) {
        String string = cacheControl.toString();
        if (string.length() == 0) {
            ((Headers.Builder) this.runningAsyncCalls).removeAll("Cache-Control");
        } else {
            ((Headers.Builder) this.runningAsyncCalls).set("Cache-Control", string);
        }
    }

    public void close() {
        CharsKt.checkMainThread();
        SurfaceRequest.AnonymousClass1 anonymousClass1 = (SurfaceRequest.AnonymousClass1) this.readyAsyncCalls;
        anonymousClass1.getClass();
        CharsKt.checkMainThread();
        AutoValue_CaptureNode_In autoValue_CaptureNode_In = (AutoValue_CaptureNode_In) anonymousClass1.val$requestCancellationFuture;
        Objects.requireNonNull(autoValue_CaptureNode_In);
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) anonymousClass1.val$requestCancellationCompleter;
        Objects.requireNonNull(realInterceptorChain);
        SurfaceRequest.AnonymousClass2 anonymousClass2 = autoValue_CaptureNode_In.mSurface;
        Objects.requireNonNull(anonymousClass2);
        anonymousClass2.close();
        SurfaceRequest.AnonymousClass2 anonymousClass3 = autoValue_CaptureNode_In.mSurface;
        Objects.requireNonNull(anonymousClass3);
        Futures.nonCancellationPropagating(anonymousClass3.mTerminationFuture).addListener(new CaptureNode$$ExternalSyntheticLambda4(realInterceptorChain, 0), HexFormatKt.mainThreadExecutor());
        SurfaceRequest.AnonymousClass2 anonymousClass4 = autoValue_CaptureNode_In.mPostviewSurface;
        if (anonymousClass4 != null) {
            anonymousClass4.close();
            Futures.nonCancellationPropagating(autoValue_CaptureNode_In.mPostviewSurface.mTerminationFuture).addListener(new CaptureNode$$ExternalSyntheticLambda4(null, 2), HexFormatKt.mainThreadExecutor());
        }
        ((Composer) this.runningAsyncCalls).getClass();
    }

    public void dfs(Object obj, ArrayList arrayList, HashSet hashSet) {
        if (arrayList.contains(obj)) {
            return;
        }
        if (hashSet.contains(obj)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(obj);
        ArrayList arrayList2 = (ArrayList) ((SimpleArrayMap) this.readyAsyncCalls).get(obj);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                dfs(arrayList2.get(i), arrayList, hashSet);
            }
        }
        hashSet.remove(obj);
        arrayList.add(obj);
    }

    public void dispatchOnStarted$navigationevent(NavigationEventInput navigationEventInput, NavigationEvent navigationEvent) {
        NavigationEventProcessor navigationEventProcessor = (NavigationEventProcessor) this.readyAsyncCalls;
        if (navigationEventProcessor.inProgressDirection != 0) {
            return;
        }
        NavigationEventHandler navigationEventHandlerResolveEnabledHandler = navigationEventProcessor.resolveEnabledHandler(-1);
        navigationEventProcessor.inProgressHandler = navigationEventHandlerResolveEnabledHandler;
        navigationEventProcessor.inProgressDirection = -1;
        navigationEventProcessor.inProgressInput = navigationEventInput;
        if (navigationEvent != null) {
            if (navigationEventHandlerResolveEnabledHandler != null) {
                navigationEventHandlerResolveEnabledHandler.onBackStarted(navigationEvent);
            }
            StateFlowImpl stateFlowImpl = navigationEventProcessor._transitionState;
            NavigationEventTransitionState.InProgress inProgress = new NavigationEventTransitionState.InProgress(navigationEvent);
            stateFlowImpl.getClass();
            stateFlowImpl.updateState(null, inProgress);
        }
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005b, code lost:
    
        if (r15 == r7) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007a, code lost:
    
        if (r15 == r7) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007c, code lost:
    
        return r7;
     */
    /* JADX INFO: renamed from: dispatchPostFling-RZ2iAVY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object m848dispatchPostFlingRZ2iAVY(long r11, long r13, kotlin.coroutines.jvm.internal.ContinuationImpl r15) {
        /*
            r10 = this;
            boolean r0 = r15 instanceof androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPostFling$1
            if (r0 == 0) goto L14
            r0 = r15
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPostFling$1 r0 = (androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPostFling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPostFling$1 r0 = new androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPostFling$1
            r0.<init>(r10, r15)
            goto L12
        L1a:
            java.lang.Object r15 = r6.result
            int r0 = r6.label
            r1 = 2
            r2 = 1
            if (r0 == 0) goto L36
            if (r0 == r2) goto L32
            if (r0 != r1) goto L2a
            kotlin.ResultKt.throwOnFailure(r15)
            goto L7d
        L2a:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L32:
            kotlin.ResultKt.throwOnFailure(r15)
            goto L5e
        L36:
            kotlin.ResultKt.throwOnFailure(r15)
            java.lang.Object r15 = r10.executorServiceOrNull
            androidx.compose.ui.input.nestedscroll.NestedScrollNode r15 = (androidx.compose.ui.input.nestedscroll.NestedScrollNode) r15
            r0 = 0
            if (r15 == 0) goto L45
            androidx.compose.ui.input.nestedscroll.NestedScrollNode r15 = r15.getParentNestedScrollNode$ui()
            goto L46
        L45:
            r15 = r0
        L46:
            r3 = 0
            kotlin.coroutines.intrinsics.CoroutineSingletons r7 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            if (r15 != 0) goto L63
            java.lang.Object r15 = r10.readyAsyncCalls
            r1 = r15
            androidx.compose.ui.input.nestedscroll.NestedScrollNode r1 = (androidx.compose.ui.input.nestedscroll.NestedScrollNode) r1
            if (r1 == 0) goto L83
            r6.label = r2
            r2 = r11
            r4 = r13
            java.lang.Object r15 = r1.mo99onPostFlingRZ2iAVY(r2, r4, r6)
            if (r15 != r7) goto L5e
            goto L7c
        L5e:
            androidx.compose.ui.unit.Velocity r15 = (androidx.compose.ui.unit.Velocity) r15
            long r3 = r15.packedValue
            goto L83
        L63:
            r8 = r3
            r2 = r11
            r11 = r8
            r4 = r13
            java.lang.Object r13 = r10.executorServiceOrNull
            androidx.compose.ui.input.nestedscroll.NestedScrollNode r13 = (androidx.compose.ui.input.nestedscroll.NestedScrollNode) r13
            if (r13 == 0) goto L71
            androidx.compose.ui.input.nestedscroll.NestedScrollNode r0 = r13.getParentNestedScrollNode$ui()
        L71:
            if (r0 == 0) goto L82
            r6.label = r1
            r1 = r0
            java.lang.Object r15 = r1.mo99onPostFlingRZ2iAVY(r2, r4, r6)
            if (r15 != r7) goto L7d
        L7c:
            return r7
        L7d:
            androidx.compose.ui.unit.Velocity r15 = (androidx.compose.ui.unit.Velocity) r15
            long r3 = r15.packedValue
            goto L83
        L82:
            r3 = r11
        L83:
            androidx.compose.ui.unit.Velocity r11 = new androidx.compose.ui.unit.Velocity
            r11.<init>(r3)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.Dispatcher.m848dispatchPostFlingRZ2iAVY(long, long, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX INFO: renamed from: dispatchPreFling-QWom1Mo, reason: not valid java name */
    public Object m849dispatchPreFlingQWom1Mo(long j, ContinuationImpl continuationImpl) {
        NestedScrollDispatcher$dispatchPreFling$1 nestedScrollDispatcher$dispatchPreFling$1;
        long j2;
        if (continuationImpl instanceof NestedScrollDispatcher$dispatchPreFling$1) {
            nestedScrollDispatcher$dispatchPreFling$1 = (NestedScrollDispatcher$dispatchPreFling$1) continuationImpl;
            int i = nestedScrollDispatcher$dispatchPreFling$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                nestedScrollDispatcher$dispatchPreFling$1.label = i - Integer.MIN_VALUE;
            } else {
                nestedScrollDispatcher$dispatchPreFling$1 = new NestedScrollDispatcher$dispatchPreFling$1(this, continuationImpl);
            }
        } else {
            nestedScrollDispatcher$dispatchPreFling$1 = new NestedScrollDispatcher$dispatchPreFling$1(this, continuationImpl);
        }
        Object objMo101onPreFlingQWom1Mo = nestedScrollDispatcher$dispatchPreFling$1.result;
        int i2 = nestedScrollDispatcher$dispatchPreFling$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objMo101onPreFlingQWom1Mo);
            NestedScrollNode nestedScrollNode = (NestedScrollNode) this.executorServiceOrNull;
            NestedScrollNode parentNestedScrollNode$ui = nestedScrollNode != null ? nestedScrollNode.getParentNestedScrollNode$ui() : null;
            if (parentNestedScrollNode$ui != null) {
                nestedScrollDispatcher$dispatchPreFling$1.label = 1;
                objMo101onPreFlingQWom1Mo = parentNestedScrollNode$ui.mo101onPreFlingQWom1Mo(j, nestedScrollDispatcher$dispatchPreFling$1);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (objMo101onPreFlingQWom1Mo == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                j2 = 0;
            }
            return new Velocity(j2);
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(objMo101onPreFlingQWom1Mo);
        j2 = ((Velocity) objMo101onPreFlingQWom1Mo).packedValue;
        return new Velocity(j2);
    }

    public synchronized ExecutorService executorService() {
        try {
            if (((ThreadPoolExecutor) this.executorServiceOrNull) == null) {
                this.executorServiceOrNull = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new Util$$ExternalSyntheticLambda1(Util.okHttpName + " Dispatcher", false));
            }
        } catch (Throwable th) {
            throw th;
        }
        return (ThreadPoolExecutor) this.executorServiceOrNull;
    }

    public Object exists(UUID uuid, ContinuationImpl continuationImpl) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT EXISTS(SELECT 1 FROM imported WHERE uuid = ?)", 1);
        roomSQLiteQueryAcquire.bindString(uuid.toString(), 1);
        return CoroutinesRoom.execute((Database_Impl) this.executorServiceOrNull, new android.os.CancellationSignal(), new ImportedDao_Impl$7(this, roomSQLiteQueryAcquire, 2), continuationImpl);
    }

    public Fragment findActiveFragment(String str) {
        FragmentStateManager fragmentStateManager = (FragmentStateManager) ((HashMap) this.readyAsyncCalls).get(str);
        if (fragmentStateManager != null) {
            return fragmentStateManager.mFragment;
        }
        return null;
    }

    public Fragment findFragmentByWho(String str) {
        for (FragmentStateManager fragmentStateManager : ((HashMap) this.readyAsyncCalls).values()) {
            if (fragmentStateManager != null) {
                Fragment fragmentFindFragmentByWho = fragmentStateManager.mFragment;
                if (!str.equals(fragmentFindFragmentByWho.mWho)) {
                    fragmentFindFragmentByWho = fragmentFindFragmentByWho.mChildFragmentManager.mFragmentStore.findFragmentByWho(str);
                }
                if (fragmentFindFragmentByWho != null) {
                    return fragmentFindFragmentByWho;
                }
            }
        }
        return null;
    }

    public void finished(ArrayDeque arrayDeque, Object obj) {
        synchronized (this) {
            if (!arrayDeque.remove(obj)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            Unit unit = Unit.INSTANCE;
        }
        promoteAndExecute();
    }

    public void finished$okhttp(RealCall.AsyncCall asyncCall) {
        asyncCall.callsPerHost.decrementAndGet();
        finished((ArrayDeque) this.runningAsyncCalls, asyncCall);
    }

    @Override // javax.inject.Provider
    public Object get() {
        return new Dispatcher((Executor) ((Provider) this.executorServiceOrNull).get(), (EventStore) ((Provider) this.readyAsyncCalls).get(), (ImageLoader$Builder) ((ImageLoader$Builder) this.runningAsyncCalls).get(), (SynchronizationGuard) ((Provider) this.runningSyncCalls).get());
    }

    public SupportActionModeWrapper getActionModeWrapper(ActionMode actionMode) {
        ArrayList arrayList = (ArrayList) this.runningAsyncCalls;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            SupportActionModeWrapper supportActionModeWrapper = (SupportActionModeWrapper) arrayList.get(i);
            if (supportActionModeWrapper != null && supportActionModeWrapper.mWrappedObject == actionMode) {
                return supportActionModeWrapper;
            }
        }
        SupportActionModeWrapper supportActionModeWrapper2 = new SupportActionModeWrapper((Context) this.readyAsyncCalls, actionMode);
        arrayList.add(supportActionModeWrapper2);
        return supportActionModeWrapper2;
    }

    public ArrayList getActiveFragmentStateManagers() {
        ArrayList arrayList = new ArrayList();
        for (FragmentStateManager fragmentStateManager : ((HashMap) this.readyAsyncCalls).values()) {
            if (fragmentStateManager != null) {
                arrayList.add(fragmentStateManager);
            }
        }
        return arrayList;
    }

    public ArrayList getActiveFragments() {
        ArrayList arrayList = new ArrayList();
        for (FragmentStateManager fragmentStateManager : ((HashMap) this.readyAsyncCalls).values()) {
            if (fragmentStateManager != null) {
                arrayList.add(fragmentStateManager.mFragment);
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    public CoroutineScope getCoroutineScope() {
        CoroutineScope coroutineScope = (CoroutineScope) ((Lambda) this.runningAsyncCalls).invoke();
        if (coroutineScope != null) {
            return coroutineScope;
        }
        throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public long getDurationNanos(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        int size$animation_core = animationVector.getSize$animation_core();
        long jMax = 0;
        for (int i = 0; i < size$animation_core; i++) {
            jMax = Math.max(jMax, ((Animations) this.executorServiceOrNull).get(i).getDurationNanos(animationVector.get$animation_core(i), animationVector2.get$animation_core(i), animationVector3.get$animation_core(i)));
        }
        return jMax;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector getEndVelocity(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        if (((AnimationVector) this.runningSyncCalls) == null) {
            this.runningSyncCalls = animationVector3.newVector$animation_core();
        }
        AnimationVector animationVector4 = (AnimationVector) this.runningSyncCalls;
        if (animationVector4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endVelocityVector");
            throw null;
        }
        int size$animation_core = animationVector4.getSize$animation_core();
        for (int i = 0; i < size$animation_core; i++) {
            AnimationVector animationVector5 = (AnimationVector) this.runningSyncCalls;
            if (animationVector5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("endVelocityVector");
                throw null;
            }
            animationVector5.set$animation_core(i, ((Animations) this.executorServiceOrNull).get(i).getEndVelocity(animationVector.get$animation_core(i), animationVector2.get$animation_core(i), animationVector3.get$animation_core(i)));
        }
        AnimationVector animationVector6 = (AnimationVector) this.runningSyncCalls;
        if (animationVector6 != null) {
            return animationVector6;
        }
        Intrinsics.throwUninitializedPropertyAccessException("endVelocityVector");
        throw null;
    }

    public List getFragments() {
        ArrayList arrayList;
        if (((ArrayList) this.executorServiceOrNull).isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        synchronized (((ArrayList) this.executorServiceOrNull)) {
            arrayList = new ArrayList((ArrayList) this.executorServiceOrNull);
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0037 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:11:0x0038 A[RETURN] */
    public Object getValue() {
        MemoryCacheService memoryCacheService = (MemoryCacheService) ((Parameters.Builder) this.executorServiceOrNull).entries;
        String str = (String) this.readyAsyncCalls;
        Enum r2 = (Enum) this.runningAsyncCalls;
        String string = ((SharedPreferences) memoryCacheService.imageLoader).getString(str, r2.name());
        for (Enum r5 : (Enum[]) this.runningSyncCalls) {
            if (string.equals(r5.name())) {
                if (r5 == null) {
                    return r2;
                }
                return r5;
            }
        }
        r5 = null;
        if (r5 == null) {
            return r2;
        }
        return r5;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector getValueFromNanos(long j, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        if (((AnimationVector) this.readyAsyncCalls) == null) {
            this.readyAsyncCalls = animationVector.newVector$animation_core();
        }
        AnimationVector animationVector4 = (AnimationVector) this.readyAsyncCalls;
        if (animationVector4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("valueVector");
            throw null;
        }
        int size$animation_core = animationVector4.getSize$animation_core();
        for (int i = 0; i < size$animation_core; i++) {
            AnimationVector animationVector5 = (AnimationVector) this.readyAsyncCalls;
            if (animationVector5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("valueVector");
                throw null;
            }
            animationVector5.set$animation_core(i, ((Animations) this.executorServiceOrNull).get(i).getValueFromNanos(j, animationVector.get$animation_core(i), animationVector2.get$animation_core(i), animationVector3.get$animation_core(i)));
        }
        AnimationVector animationVector6 = (AnimationVector) this.readyAsyncCalls;
        if (animationVector6 != null) {
            return animationVector6;
        }
        Intrinsics.throwUninitializedPropertyAccessException("valueVector");
        throw null;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector getVelocityFromNanos(long j, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        if (((AnimationVector) this.runningAsyncCalls) == null) {
            this.runningAsyncCalls = animationVector3.newVector$animation_core();
        }
        AnimationVector animationVector4 = (AnimationVector) this.runningAsyncCalls;
        if (animationVector4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            throw null;
        }
        int size$animation_core = animationVector4.getSize$animation_core();
        for (int i = 0; i < size$animation_core; i++) {
            AnimationVector animationVector5 = (AnimationVector) this.runningAsyncCalls;
            if (animationVector5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
                throw null;
            }
            animationVector5.set$animation_core(i, ((Animations) this.executorServiceOrNull).get(i).getVelocityFromNanos(j, animationVector.get$animation_core(i), animationVector2.get$animation_core(i), animationVector3.get$animation_core(i)));
        }
        AnimationVector animationVector6 = (AnimationVector) this.runningAsyncCalls;
        if (animationVector6 != null) {
            return animationVector6;
        }
        Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
        throw null;
    }

    public ViewModel getViewModel$lifecycle_viewmodel_release(String str, ClassReference classReference) {
        ViewModel viewModel;
        boolean zIsInstance;
        ViewModel viewModelCreate;
        SavedStateViewModelFactory savedStateViewModelFactory;
        Lifecycle lifecycle;
        synchronized (((SynchronizedObject) this.runningSyncCalls)) {
            try {
                viewModel = (ViewModel) ((ViewModelStore) this.executorServiceOrNull).map.get(str);
                Class javaObjectType = classReference.jClass;
                Integer num = (Integer) ClassReference.FUNCTION_CLASSES.get(javaObjectType);
                if (num != null) {
                    zIsInstance = TypeIntrinsics.isFunctionOfArity(num.intValue(), viewModel);
                } else {
                    if (javaObjectType.isPrimitive()) {
                        javaObjectType = JvmClassMappingKt.getJavaObjectType(Reflection.getOrCreateKotlinClass(javaObjectType));
                    }
                    zIsInstance = javaObjectType.isInstance(viewModel);
                }
                if (zIsInstance) {
                    ViewModelProvider$Factory viewModelProvider$Factory = (ViewModelProvider$Factory) this.readyAsyncCalls;
                    if ((viewModelProvider$Factory instanceof SavedStateViewModelFactory) && (lifecycle = (savedStateViewModelFactory = (SavedStateViewModelFactory) viewModelProvider$Factory).lifecycle) != null) {
                        ViewModelKt.attachHandleIfNeeded(viewModel, savedStateViewModelFactory.savedStateRegistry, lifecycle);
                    }
                } else {
                    MutableCreationExtras mutableCreationExtras = new MutableCreationExtras((CreationExtras) this.runningAsyncCalls);
                    mutableCreationExtras.set(AtomicReference.VIEW_MODEL_KEY, str);
                    ViewModelProvider$Factory viewModelProvider$Factory2 = (ViewModelProvider$Factory) this.readyAsyncCalls;
                    try {
                        try {
                            viewModelCreate = viewModelProvider$Factory2.create(classReference, mutableCreationExtras);
                        } catch (AbstractMethodError unused) {
                            viewModelCreate = viewModelProvider$Factory2.create(classReference.getJClass(), mutableCreationExtras);
                        }
                    } catch (AbstractMethodError unused2) {
                        viewModelCreate = viewModelProvider$Factory2.create(classReference.getJClass());
                    }
                    viewModel = viewModelCreate;
                    ViewModel viewModel2 = (ViewModel) ((ViewModelStore) this.executorServiceOrNull).map.put(str, viewModel);
                    if (viewModel2 != null) {
                        viewModel2.clear$lifecycle_viewmodel_release();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return viewModel;
    }

    public void header(String str, String str2) {
        ((Headers.Builder) this.runningAsyncCalls).set(str, str2);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public /* synthetic */ boolean isInfinite() {
        return false;
    }

    public void makeActive(FragmentStateManager fragmentStateManager) {
        Fragment fragment = fragmentStateManager.mFragment;
        String str = fragment.mWho;
        HashMap map = (HashMap) this.readyAsyncCalls;
        if (map.get(str) != null) {
            return;
        }
        map.put(fragment.mWho, fragmentStateManager);
        if (FragmentManagerImpl.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + fragment);
        }
    }

    public void makeInactive(FragmentStateManager fragmentStateManager) {
        Fragment fragment = fragmentStateManager.mFragment;
        if (fragment.mRetainInstance) {
            ((FragmentManagerViewModel) this.runningSyncCalls).removeRetainedFragment(fragment);
        }
        if (((FragmentStateManager) ((HashMap) this.readyAsyncCalls).put(fragment.mWho, null)) != null && FragmentManagerImpl.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + fragment);
        }
    }

    public void method(String str, RequestBody$Companion$toRequestBody$2 requestBody$Companion$toRequestBody$2) {
        if (str.length() <= 0) {
            throw new IllegalArgumentException("method.isEmpty() == true");
        }
        if (str.equals("POST") || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT")) {
            throw new IllegalArgumentException(ImageAnalysis$$ExternalSyntheticLambda1.m$1("method ", str, " must have a request body.").toString());
        }
        this.readyAsyncCalls = str;
    }

    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return ((android.view.ActionMode.Callback) this.executorServiceOrNull).onActionItemClicked(getActionModeWrapper(actionMode), new MenuItemWrapperICS((Context) this.readyAsyncCalls, (SupportMenuItem) menuItem));
    }

    @Override // androidx.core.os.CancellationSignal.OnCancelListener
    public void onCancel() {
        View view = (View) this.executorServiceOrNull;
        view.clearAnimation();
        ((ViewGroup) this.readyAsyncCalls).endViewTransition(view);
        ((DefaultSpecialEffectsController.AnimationInfo) this.runningAsyncCalls).completeSpecialEffect();
        if (FragmentManagerImpl.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Animation from operation " + ((SpecialEffectsController$FragmentStateManagerOperation) this.runningSyncCalls) + " has been cancelled.");
        }
    }

    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        android.view.ActionMode.Callback callback = (android.view.ActionMode.Callback) this.executorServiceOrNull;
        SupportActionModeWrapper actionModeWrapper = getActionModeWrapper(actionMode);
        SimpleArrayMap simpleArrayMap = (SimpleArrayMap) this.runningSyncCalls;
        Menu menuWrapperICS = (Menu) simpleArrayMap.get(menu);
        if (menuWrapperICS == null) {
            menuWrapperICS = new MenuWrapperICS((Context) this.readyAsyncCalls, (MenuBuilder) menu);
            simpleArrayMap.put(menu, menuWrapperICS);
        }
        return callback.onCreateActionMode(actionModeWrapper, menuWrapperICS);
    }

    public void promoteAndExecute() {
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                Iterator it = ((ArrayDeque) this.readyAsyncCalls).iterator();
                while (it.hasNext()) {
                    RealCall.AsyncCall asyncCall = (RealCall.AsyncCall) it.next();
                    if (((ArrayDeque) this.runningAsyncCalls).size() >= 64) {
                        break;
                    }
                    if (asyncCall.callsPerHost.get() < 5) {
                        it.remove();
                        asyncCall.callsPerHost.incrementAndGet();
                        arrayList.add(asyncCall);
                        ((ArrayDeque) this.runningAsyncCalls).add(asyncCall);
                    }
                }
                runningCallsCount();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            RealCall.AsyncCall asyncCall2 = (RealCall.AsyncCall) arrayList.get(i);
            ExecutorService executorService = executorService();
            RealCall realCall = RealCall.this;
            byte[] bArr2 = Util.EMPTY_BYTE_ARRAY;
            try {
                try {
                    ((ThreadPoolExecutor) executorService).execute(asyncCall2);
                } catch (Throwable th2) {
                    realCall.client.dispatcher.finished$okhttp(asyncCall2);
                    throw th2;
                }
            } catch (RejectedExecutionException e) {
                InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                interruptedIOException.initCause(e);
                realCall.noMoreExchanges$okhttp(interruptedIOException);
                ContinuationCallback continuationCallback = asyncCall2.responseCallback;
                if (!realCall.canceled) {
                    ((CancellableContinuationImpl) continuationCallback.continuation).resumeWith(new Result.Failure(interruptedIOException));
                }
                realCall.client.dispatcher.finished$okhttp(asyncCall2);
            }
        }
    }

    public Object queryAllUUIDs(ContinuationImpl continuationImpl) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT uuid FROM imported ORDER BY createdAt", 0);
        return CoroutinesRoom.execute((Database_Impl) this.executorServiceOrNull, new android.os.CancellationSignal(), new ImportedDao_Impl$7(this, roomSQLiteQueryAcquire, 1), continuationImpl);
    }

    public Object queryByUUID(UUID uuid, ContinuationImpl continuationImpl) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM imported WHERE uuid = ?", 1);
        roomSQLiteQueryAcquire.bindString(uuid.toString(), 1);
        return CoroutinesRoom.execute((Database_Impl) this.executorServiceOrNull, new android.os.CancellationSignal(), new ImportedDao_Impl$7(this, roomSQLiteQueryAcquire, 0), continuationImpl);
    }

    public void removeHeader(String str) {
        ((Headers.Builder) this.runningAsyncCalls).removeAll(str);
    }

    public synchronized int runningCallsCount() {
        return ((ArrayDeque) this.runningAsyncCalls).size() + ((ArrayDeque) this.runningSyncCalls).size();
    }

    public void setValue(Object obj) {
        MemoryCacheService memoryCacheService = (MemoryCacheService) ((Parameters.Builder) this.executorServiceOrNull).entries;
        String str = (String) this.readyAsyncCalls;
        String strName = ((Enum) obj).name();
        SharedPreferences.Editor editorEdit = ((SharedPreferences) memoryCacheService.imageLoader).edit();
        editorEdit.putString(str, strName);
        editorEdit.apply();
    }

    public Dispatcher(ViewModelStore viewModelStore, ViewModelProvider$Factory viewModelProvider$Factory, CreationExtras creationExtras) {
        this.executorServiceOrNull = viewModelStore;
        this.readyAsyncCalls = viewModelProvider$Factory;
        this.runningAsyncCalls = creationExtras;
        this.runningSyncCalls = new SynchronizedObject();
    }

    public void addInput(OnBackInvokedDefaultInput onBackInvokedDefaultInput, int i) {
        if (i != 1 && i != 0) {
            throw new IllegalArgumentException(ImageAnalysis$$ExternalSyntheticLambda1.m("Unsupported priority value: ", i).toString());
        }
        if (((LinkedHashSet) this.runningSyncCalls).add(onBackInvokedDefaultInput)) {
            ((NavigationEventProcessor) this.readyAsyncCalls).addInput(this, onBackInvokedDefaultInput, i);
        }
    }

    public Dispatcher(int i) {
        switch (i) {
            case 8:
                this.runningAsyncCalls = new Handshake.AnonymousClass2(4, this);
                break;
            case 10:
                this.executorServiceOrNull = new Pools$SimplePool(10);
                this.readyAsyncCalls = new SimpleArrayMap(0);
                this.runningAsyncCalls = new ArrayList();
                this.runningSyncCalls = new HashSet();
                break;
            case 13:
                this.executorServiceOrNull = new ArrayList();
                this.readyAsyncCalls = new HashMap();
                this.runningAsyncCalls = new HashMap();
                break;
            case 16:
                this.executorServiceOrNull = new ArrayMap(0);
                this.readyAsyncCalls = new SparseArray();
                this.runningAsyncCalls = new LongSparseArray((Object) null);
                this.runningSyncCalls = new ArrayMap(0);
                break;
            case 22:
                this.runningSyncCalls = new LinkedHashMap();
                this.readyAsyncCalls = "GET";
                this.runningAsyncCalls = new Headers.Builder(0);
                break;
            default:
                this.readyAsyncCalls = new ArrayDeque();
                this.runningAsyncCalls = new ArrayDeque();
                this.runningSyncCalls = new ArrayDeque();
                break;
        }
    }

    public Dispatcher(Typeface typeface, MetadataList metadataList) {
        int i;
        int i2;
        int i3;
        int i4;
        this.runningSyncCalls = typeface;
        this.executorServiceOrNull = metadataList;
        this.runningAsyncCalls = new MetadataRepo$Node(1024);
        int i__offset = metadataList.__offset(6);
        if (i__offset != 0) {
            int i5 = i__offset + metadataList.bb_pos;
            i = ((ByteBuffer) metadataList.bb).getInt(((ByteBuffer) metadataList.bb).getInt(i5) + i5);
        } else {
            i = 0;
        }
        this.readyAsyncCalls = new char[i * 2];
        int i__offset2 = metadataList.__offset(6);
        if (i__offset2 != 0) {
            int i6 = i__offset2 + metadataList.bb_pos;
            i2 = ((ByteBuffer) metadataList.bb).getInt(((ByteBuffer) metadataList.bb).getInt(i6) + i6);
        } else {
            i2 = 0;
        }
        for (int i7 = 0; i7 < i2; i7++) {
            TypefaceEmojiRasterizer typefaceEmojiRasterizer = new TypefaceEmojiRasterizer(this, i7);
            MetadataItem metadataItem = typefaceEmojiRasterizer.getMetadataItem();
            int i__offset3 = metadataItem.__offset(4);
            Character.toChars(i__offset3 != 0 ? ((ByteBuffer) metadataItem.bb).getInt(i__offset3 + metadataItem.bb_pos) : 0, (char[]) this.readyAsyncCalls, i7 * 2);
            MetadataItem metadataItem2 = typefaceEmojiRasterizer.getMetadataItem();
            int i__offset4 = metadataItem2.__offset(16);
            if (i__offset4 != 0) {
                int i8 = i__offset4 + metadataItem2.bb_pos;
                i3 = ((ByteBuffer) metadataItem2.bb).getInt(((ByteBuffer) metadataItem2.bb).getInt(i8) + i8);
            } else {
                i3 = 0;
            }
            Preconditions.checkArgument("invalid metadata codepoint length", i3 > 0);
            MetadataRepo$Node metadataRepo$Node = (MetadataRepo$Node) this.runningAsyncCalls;
            MetadataItem metadataItem3 = typefaceEmojiRasterizer.getMetadataItem();
            int i__offset5 = metadataItem3.__offset(16);
            if (i__offset5 != 0) {
                int i9 = i__offset5 + metadataItem3.bb_pos;
                i4 = ((ByteBuffer) metadataItem3.bb).getInt(((ByteBuffer) metadataItem3.bb).getInt(i9) + i9);
            } else {
                i4 = 0;
            }
            metadataRepo$Node.put(typefaceEmojiRasterizer, 0, i4 - 1);
        }
    }

    public Dispatcher(Animations animations) {
        this.executorServiceOrNull = animations;
    }

    public Dispatcher(FloatAnimationSpec floatAnimationSpec) {
        this(new Toolbar.AnonymousClass1(23, floatAnimationSpec));
    }
}
