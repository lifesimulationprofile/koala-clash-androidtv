package okhttp3;

import android.text.Layout;
import android.text.TextUtils;
import android.util.Range;
import android.util.Size;
import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.camera.core.AutoValue_SurfaceOutput_CameraInputInfo;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.AutoValue_SessionConfig_OutputConfig;
import androidx.camera.core.impl.AutoValue_StreamSpec;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.utils.futures.ChainingListenableFuture;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.CameraUseCaseAdapter;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.camera.core.processing.SurfaceEdge$$ExternalSyntheticLambda4;
import androidx.camera.core.processing.SurfaceProcessorInternal;
import androidx.camera.core.processing.concurrent.AutoValue_DualOutConfig;
import androidx.camera.lifecycle.AutoValue_LifecycleCameraRepository_Key;
import androidx.camera.lifecycle.LifecycleCamera;
import androidx.camera.lifecycle.LifecycleCameraRepository$LifecycleCameraRepositoryObserver;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.CancellationHandle;
import androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.internal.AtomicInt;
import androidx.compose.runtime.internal.AwaiterQueue$Awaiter;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedString$special$$inlined$sortedBy$1;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.ParagraphIntrinsicInfo;
import androidx.compose.ui.text.ParagraphIntrinsics;
import androidx.compose.ui.text.ParagraphStyle;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda10;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.android.LayoutHelper$BidiRun;
import androidx.compose.ui.text.android.StaticLayoutFactory;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.text.platform.AndroidParagraphIntrinsics;
import androidx.compose.ui.unit.Density;
import androidx.core.util.Pools$SimplePool;
import androidx.core.util.Preconditions;
import androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda4;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.AdapterHelper$UpdateOp;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.DatabaseConfiguration;
import coil.ComponentRegistry;
import coil.ImageLoader$Builder;
import coil.fetch.Fetcher;
import coil.map.StringMapper;
import coil.request.Parameters;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.tasks.zzi;
import java.text.Bidi;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.inject.Provider;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.text.CharsKt;
import kotlin.text.HexFormatKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Request implements ParagraphIntrinsics, Factory {
    public final /* synthetic */ int $r8$classId;
    public Object headers;
    public Object lazyCacheControl;
    public Object method;
    public Object tags;
    public Object url;

    public /* synthetic */ Request(int i, boolean z) {
        this.$r8$classId = i;
    }

    public void add(StringMapper stringMapper, Class cls) {
        ((ArrayList) this.method).add(new Pair(stringMapper, cls));
    }

    public CancellationHandle addAwaiter(AwaiterQueue$Awaiter awaiterQueue$Awaiter, Function0 function0) {
        int i;
        int i2;
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = -1;
        synchronized (this.url) {
            Throwable th = (Throwable) this.method;
            if (th != null) {
                awaiterQueue$Awaiter.resumeWithException(th);
                return NeverEqualPolicy.Empty;
            }
            AtomicInt atomicInt = (AtomicInt) this.headers;
            do {
                i = atomicInt.get();
                i2 = i + 1;
            } while (!atomicInt.compareAndSet(i, i2));
            boolean z = true;
            if ((134217727 & i2) != 1) {
                z = false;
            }
            ref$IntRef.element = (i2 >>> 27) & 15;
            ((MutableObjectList) this.tags).add(awaiterQueue$Awaiter);
            if (z && function0 != null) {
                try {
                    function0.invoke();
                } catch (Throwable th2) {
                    fail(th2);
                }
            }
            return new SurfaceRequest.AnonymousClass1(new GapComposer$$ExternalSyntheticLambda0(awaiterQueue$Awaiter, this, ref$IntRef, 9));
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0076  */
    public Bidi analyzeBidi(int i) {
        Bidi bidi;
        Layout layout = (Layout) this.url;
        ArrayList arrayList = (ArrayList) this.method;
        ArrayList arrayList2 = (ArrayList) this.headers;
        boolean[] zArr = (boolean[]) this.tags;
        if (zArr[i]) {
            return (Bidi) arrayList2.get(i);
        }
        int iIntValue = i == 0 ? 0 : ((Number) arrayList.get(i - 1)).intValue();
        int iIntValue2 = ((Number) arrayList.get(i)).intValue();
        int i2 = iIntValue2 - iIntValue;
        char[] cArr = (char[]) this.lazyCacheControl;
        if (cArr == null || cArr.length < i2) {
            cArr = new char[i2];
        }
        char[] cArr2 = cArr;
        TextUtils.getChars(layout.getText(), iIntValue, iIntValue2, cArr2, 0);
        if (Bidi.requiresBidi(cArr2, 0, i2)) {
            bidi = new Bidi(cArr2, 0, null, 0, i2, layout.getParagraphDirection(layout.getLineForOffset(getParagraphStart(i))) == -1 ? 1 : 0);
            if (bidi.getRunCount() == 1) {
                bidi = null;
            }
        } else {
            bidi = null;
        }
        arrayList2.set(i, bidi);
        zArr[i] = true;
        if (bidi != null) {
            char[] cArr3 = (char[]) this.lazyCacheControl;
            cArr2 = cArr2 == cArr3 ? null : cArr3;
        }
        this.lazyCacheControl = cArr2;
        return bidi;
    }

    public void bindToLifecycleCamera(LifecycleCamera lifecycleCamera, List list, DatabaseConfiguration databaseConfiguration) {
        synchronized (this.url) {
            try {
                Preconditions.checkArgument(!list.isEmpty());
                this.lazyCacheControl = databaseConfiguration;
                LifecycleOwner lifecycleOwner = lifecycleCamera.getLifecycleOwner();
                LifecycleCameraRepository$LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserver = getLifecycleCameraRepositoryObserver(lifecycleOwner);
                if (lifecycleCameraRepositoryObserver == null) {
                    return;
                }
                Set set = (Set) ((HashMap) this.headers).get(lifecycleCameraRepositoryObserver);
                DatabaseConfiguration databaseConfiguration2 = (DatabaseConfiguration) this.lazyCacheControl;
                if (databaseConfiguration2 == null || databaseConfiguration2.journalMode != 2) {
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        LifecycleCamera lifecycleCamera2 = (LifecycleCamera) ((HashMap) this.method).get((AutoValue_LifecycleCameraRepository_Key) it.next());
                        lifecycleCamera2.getClass();
                        if (!lifecycleCamera2.equals(lifecycleCamera) && !lifecycleCamera2.getUseCases().isEmpty()) {
                            throw new IllegalArgumentException("Multiple LifecycleCameras with use cases are registered to the same LifecycleOwner.");
                        }
                    }
                }
                try {
                    lifecycleCamera.mCameraUseCaseAdapter.setViewPort();
                    lifecycleCamera.mCameraUseCaseAdapter.setEffects();
                    lifecycleCamera.bind(list);
                    if (lifecycleOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                        setActive(lifecycleOwner);
                    }
                } catch (CameraUseCaseAdapter.CameraException e) {
                    throw new IllegalArgumentException(e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: build, reason: collision with other method in class */
    public AutoValue_StreamSpec m850build() {
        String strM = ((Size) this.url) == null ? " resolution" : "";
        if (((DynamicRange) this.method) == null) {
            strM = strM.concat(" dynamicRange");
        }
        if (((Range) this.headers) == null) {
            strM = ImageAnalysis$$ExternalSyntheticLambda1.m(strM, " expectedFrameRateRange");
        }
        if (((Boolean) this.lazyCacheControl) == null) {
            strM = ImageAnalysis$$ExternalSyntheticLambda1.m(strM, " zslDisabled");
        }
        if (strM.isEmpty()) {
            return new AutoValue_StreamSpec((Size) this.url, (DynamicRange) this.method, (Range) this.headers, (Config) this.tags, ((Boolean) this.lazyCacheControl).booleanValue());
        }
        throw new IllegalStateException("Missing required properties:".concat(strM));
    }

    public CacheControl cacheControl() {
        CacheControl cacheControl = (CacheControl) this.lazyCacheControl;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl cacheControl2 = CacheControl.FORCE_NETWORK;
        CacheControl cacheControl3 = CacheControl.Companion.parse((Headers) this.headers);
        this.lazyCacheControl = cacheControl3;
        return cacheControl3;
    }

    public boolean canFindInPreLayout(int i) {
        ArrayList arrayList = (ArrayList) this.headers;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            AdapterHelper$UpdateOp adapterHelper$UpdateOp = (AdapterHelper$UpdateOp) arrayList.get(i2);
            int i3 = adapterHelper$UpdateOp.cmd;
            if (i3 != 8) {
                if (i3 == 1) {
                    int i4 = adapterHelper$UpdateOp.positionStart;
                    int i5 = adapterHelper$UpdateOp.itemCount + i4;
                    while (i4 < i5) {
                        if (findPositionOffset(i4, i2 + 1) == i) {
                            return true;
                        }
                        i4++;
                    }
                } else {
                    continue;
                }
            } else {
                if (findPositionOffset(adapterHelper$UpdateOp.itemCount, i2 + 1) == i) {
                    return true;
                }
            }
        }
        return false;
    }

    public void consumeUpdatesInOnePass() {
        RecyclerView.AnonymousClass4 anonymousClass4 = (RecyclerView.AnonymousClass4) this.tags;
        ArrayList arrayList = (ArrayList) this.headers;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((RecyclerView.AnonymousClass4) this.tags).dispatchUpdate((AdapterHelper$UpdateOp) arrayList.get(i));
        }
        recycleUpdateOpsAndClearList(arrayList);
        ArrayList arrayList2 = (ArrayList) this.method;
        int size2 = arrayList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            AdapterHelper$UpdateOp adapterHelper$UpdateOp = (AdapterHelper$UpdateOp) arrayList2.get(i2);
            int i3 = adapterHelper$UpdateOp.cmd;
            if (i3 == 1) {
                anonymousClass4.dispatchUpdate(adapterHelper$UpdateOp);
                anonymousClass4.offsetPositionsForAdd(adapterHelper$UpdateOp.positionStart, adapterHelper$UpdateOp.itemCount);
            } else if (i3 == 2) {
                anonymousClass4.dispatchUpdate(adapterHelper$UpdateOp);
                int i4 = adapterHelper$UpdateOp.positionStart;
                int i5 = adapterHelper$UpdateOp.itemCount;
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.offsetPositionRecordsForRemove(i4, i5, true);
                recyclerView.mItemsAddedOrRemoved = true;
                recyclerView.mState.mDeletedInvisibleItemCountSincePreviousLayout += i5;
            } else if (i3 == 4) {
                anonymousClass4.dispatchUpdate(adapterHelper$UpdateOp);
                anonymousClass4.markViewHoldersUpdated(adapterHelper$UpdateOp.positionStart, adapterHelper$UpdateOp.itemCount);
            } else if (i3 == 8) {
                anonymousClass4.dispatchUpdate(adapterHelper$UpdateOp);
                anonymousClass4.offsetPositionsForMove(adapterHelper$UpdateOp.positionStart, adapterHelper$UpdateOp.itemCount);
            }
        }
        recycleUpdateOpsAndClearList(arrayList2);
    }

    public void createAndSendSurfaceOutput(CameraInternal cameraInternal, CameraInternal cameraInternal2, SurfaceEdge surfaceEdge, SurfaceEdge surfaceEdge2, Map.Entry entry) {
        SurfaceEdge surfaceEdge3 = (SurfaceEdge) entry.getValue();
        AutoValue_SurfaceOutput_CameraInputInfo autoValue_SurfaceOutput_CameraInputInfo = new AutoValue_SurfaceOutput_CameraInputInfo(surfaceEdge.mStreamSpec.resolution, ((AutoValue_DualOutConfig) entry.getKey()).primaryOutConfig.getCropRect, surfaceEdge.mHasCameraTransform ? cameraInternal : null, ((AutoValue_DualOutConfig) entry.getKey()).primaryOutConfig.getRotationDegrees, ((AutoValue_DualOutConfig) entry.getKey()).primaryOutConfig.isMirroring);
        AutoValue_SurfaceOutput_CameraInputInfo autoValue_SurfaceOutput_CameraInputInfo2 = new AutoValue_SurfaceOutput_CameraInputInfo(surfaceEdge2.mStreamSpec.resolution, ((AutoValue_DualOutConfig) entry.getKey()).secondaryOutConfig.getCropRect, surfaceEdge2.mHasCameraTransform ? cameraInternal2 : null, ((AutoValue_DualOutConfig) entry.getKey()).secondaryOutConfig.getRotationDegrees, ((AutoValue_DualOutConfig) entry.getKey()).secondaryOutConfig.isMirroring);
        int i = ((AutoValue_DualOutConfig) entry.getKey()).primaryOutConfig.getFormat;
        surfaceEdge3.getClass();
        CharsKt.checkMainThread();
        surfaceEdge3.checkNotClosed();
        Preconditions.checkState("Consumer can only be linked once.", !surfaceEdge3.mHasConsumer);
        surfaceEdge3.mHasConsumer = true;
        SurfaceEdge.SettableSurface settableSurface = surfaceEdge3.mSettableSurface;
        ChainingListenableFuture chainingListenableFutureTransformAsync = Futures.transformAsync(settableSurface.getSurface(), new SurfaceEdge$$ExternalSyntheticLambda4(surfaceEdge3, settableSurface, i, autoValue_SurfaceOutput_CameraInputInfo, autoValue_SurfaceOutput_CameraInputInfo2), HexFormatKt.mainThreadExecutor());
        chainingListenableFutureTransformAsync.addListener(new zzi(1, chainingListenableFutureTransformAsync, new SurfaceRequest.AnonymousClass1(17, this, surfaceEdge3)), HexFormatKt.mainThreadExecutor());
    }

    public LifecycleCamera createLifecycleCamera(LifecycleOwner lifecycleOwner, CameraUseCaseAdapter cameraUseCaseAdapter) {
        synchronized (this.url) {
            try {
                Preconditions.checkArgument("LifecycleCamera already exists for the given LifecycleOwner and set of cameras", ((HashMap) this.method).get(new AutoValue_LifecycleCameraRepository_Key(lifecycleOwner, cameraUseCaseAdapter.mId)) == null);
                LifecycleCamera lifecycleCamera = new LifecycleCamera(lifecycleOwner, cameraUseCaseAdapter);
                if (((ArrayList) cameraUseCaseAdapter.getUseCases()).isEmpty()) {
                    lifecycleCamera.suspend();
                }
                if (lifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
                    return lifecycleCamera;
                }
                registerCamera(lifecycleCamera);
                return lifecycleCamera;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void dispatchAndUpdateViewHolders(AdapterHelper$UpdateOp adapterHelper$UpdateOp) {
        int i;
        Pools$SimplePool pools$SimplePool = (Pools$SimplePool) this.url;
        int i2 = adapterHelper$UpdateOp.cmd;
        if (i2 == 1 || i2 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iUpdatePositionWithPostponed = updatePositionWithPostponed(adapterHelper$UpdateOp.positionStart, i2);
        int i3 = adapterHelper$UpdateOp.positionStart;
        int i4 = adapterHelper$UpdateOp.cmd;
        if (i4 == 2) {
            i = 0;
        } else {
            if (i4 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + adapterHelper$UpdateOp);
            }
            i = 1;
        }
        int i5 = 1;
        for (int i6 = 1; i6 < adapterHelper$UpdateOp.itemCount; i6++) {
            int iUpdatePositionWithPostponed2 = updatePositionWithPostponed((i * i6) + adapterHelper$UpdateOp.positionStart, adapterHelper$UpdateOp.cmd);
            int i7 = adapterHelper$UpdateOp.cmd;
            if (i7 == 2 ? iUpdatePositionWithPostponed2 != iUpdatePositionWithPostponed : !(i7 == 4 && iUpdatePositionWithPostponed2 == iUpdatePositionWithPostponed + 1)) {
                AdapterHelper$UpdateOp adapterHelper$UpdateOpObtainUpdateOp = obtainUpdateOp(i7, iUpdatePositionWithPostponed, i5);
                dispatchFirstPassAndUpdateViewHolders(adapterHelper$UpdateOpObtainUpdateOp, i3);
                pools$SimplePool.release(adapterHelper$UpdateOpObtainUpdateOp);
                if (adapterHelper$UpdateOp.cmd == 4) {
                    i3 += i5;
                }
                i5 = 1;
                iUpdatePositionWithPostponed = iUpdatePositionWithPostponed2;
            } else {
                i5++;
            }
        }
        pools$SimplePool.release(adapterHelper$UpdateOp);
        if (i5 > 0) {
            AdapterHelper$UpdateOp adapterHelper$UpdateOpObtainUpdateOp2 = obtainUpdateOp(adapterHelper$UpdateOp.cmd, iUpdatePositionWithPostponed, i5);
            dispatchFirstPassAndUpdateViewHolders(adapterHelper$UpdateOpObtainUpdateOp2, i3);
            pools$SimplePool.release(adapterHelper$UpdateOpObtainUpdateOp2);
        }
    }

    public void dispatchFirstPassAndUpdateViewHolders(AdapterHelper$UpdateOp adapterHelper$UpdateOp, int i) {
        RecyclerView.AnonymousClass4 anonymousClass4 = (RecyclerView.AnonymousClass4) this.tags;
        anonymousClass4.dispatchUpdate(adapterHelper$UpdateOp);
        int i2 = adapterHelper$UpdateOp.cmd;
        if (i2 != 2) {
            if (i2 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            anonymousClass4.markViewHoldersUpdated(i, adapterHelper$UpdateOp.itemCount);
        } else {
            int i3 = adapterHelper$UpdateOp.itemCount;
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.offsetPositionRecordsForRemove(i, i3, true);
            recyclerView.mItemsAddedOrRemoved = true;
            recyclerView.mState.mDeletedInvisibleItemCountSincePreviousLayout += i3;
        }
    }

    public void fail(Throwable th) {
        int i;
        synchronized (this.url) {
            try {
                if (((Throwable) this.method) != null) {
                    return;
                }
                this.method = th;
                MutableObjectList mutableObjectList = (MutableObjectList) this.tags;
                Object[] objArr = mutableObjectList.content;
                int i2 = mutableObjectList._size;
                for (int i3 = 0; i3 < i2; i3++) {
                    ((AwaiterQueue$Awaiter) objArr[i3]).resumeWithException(th);
                }
                ((MutableObjectList) this.tags).clear();
                AtomicInt atomicInt = (AtomicInt) this.headers;
                do {
                    i = atomicInt.get();
                } while (!atomicInt.compareAndSet(i, ((((i >>> 27) & 15) + 1) & 15) << 27));
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public int findPositionOffset(int i, int i2) {
        ArrayList arrayList = (ArrayList) this.headers;
        int size = arrayList.size();
        while (i2 < size) {
            AdapterHelper$UpdateOp adapterHelper$UpdateOp = (AdapterHelper$UpdateOp) arrayList.get(i2);
            int i3 = adapterHelper$UpdateOp.cmd;
            if (i3 == 8) {
                int i4 = adapterHelper$UpdateOp.positionStart;
                if (i4 == i) {
                    i = adapterHelper$UpdateOp.itemCount;
                } else {
                    if (i4 < i) {
                        i--;
                    }
                    if (adapterHelper$UpdateOp.itemCount <= i) {
                        i++;
                    }
                }
            } else {
                int i5 = adapterHelper$UpdateOp.positionStart;
                if (i5 > i) {
                    continue;
                } else if (i3 == 2) {
                    int i6 = adapterHelper$UpdateOp.itemCount;
                    if (i < i5 + i6) {
                        return -1;
                    }
                    i -= i6;
                } else if (i3 == 1) {
                    i += adapterHelper$UpdateOp.itemCount;
                }
            }
            i2++;
        }
        return i;
    }

    public void flushAndDispatchAwaiters(Function1 function1) {
        int i;
        synchronized (this.url) {
            try {
                MutableObjectList mutableObjectList = (MutableObjectList) this.tags;
                this.tags = (MutableObjectList) this.lazyCacheControl;
                this.lazyCacheControl = mutableObjectList;
                AtomicInt atomicInt = (AtomicInt) this.headers;
                do {
                    i = atomicInt.get();
                } while (!atomicInt.compareAndSet(i, ((((i >>> 27) & 15) + 1) & 15) << 27));
                int i2 = mutableObjectList._size;
                for (int i3 = 0; i3 < i2; i3++) {
                    function1.invoke(mutableObjectList.get(i3));
                }
                mutableObjectList.clear();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // javax.inject.Provider
    public Object get() {
        return new DefaultScheduler((Executor) ((Provider) this.url).get(), (MetadataBackendRegistry) ((Provider) this.method).get(), (ImageLoader$Builder) ((ImageLoader$Builder) this.headers).get(), (EventStore) ((Provider) this.tags).get(), (SynchronizationGuard) ((Provider) this.lazyCacheControl).get());
    }

    public float getDownstreamHorizontal(int i, boolean z) {
        Layout layout = (Layout) this.url;
        int lineEnd = layout.getLineEnd(layout.getLineForOffset(i));
        if (i > lineEnd) {
            i = lineEnd;
        }
        return z ? layout.getPrimaryHorizontal(i) : layout.getSecondaryHorizontal(i);
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public boolean getHasStaleResolvedFonts() {
        ArrayList arrayList = (ArrayList) this.lazyCacheControl;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((ParagraphIntrinsicInfo) arrayList.get(i)).intrinsics.getHasStaleResolvedFonts()) {
                return true;
            }
        }
        return false;
    }

    public float getHorizontalPosition(int i, boolean z, boolean z2) {
        int i2;
        int i3;
        int iLineEndToVisibleEnd = i;
        Layout layout = (Layout) this.url;
        if (!z2) {
            return getDownstreamHorizontal(i, z);
        }
        int lineForOffset = StaticLayoutFactory.getLineForOffset(layout, iLineEndToVisibleEnd, z2);
        int lineStart = layout.getLineStart(lineForOffset);
        int lineEnd = layout.getLineEnd(lineForOffset);
        if (iLineEndToVisibleEnd != lineStart && iLineEndToVisibleEnd != lineEnd) {
            return getDownstreamHorizontal(i, z);
        }
        if (iLineEndToVisibleEnd == 0 || iLineEndToVisibleEnd == layout.getText().length()) {
            return getDownstreamHorizontal(i, z);
        }
        int paragraphForOffset = getParagraphForOffset(iLineEndToVisibleEnd, z2);
        boolean z3 = layout.getParagraphDirection(layout.getLineForOffset(getParagraphStart(paragraphForOffset))) == -1;
        int iLineEndToVisibleEnd2 = lineEndToVisibleEnd(lineEnd, lineStart);
        int paragraphStart = getParagraphStart(paragraphForOffset);
        int i4 = lineStart - paragraphStart;
        int i5 = iLineEndToVisibleEnd2 - paragraphStart;
        Bidi bidiAnalyzeBidi = analyzeBidi(paragraphForOffset);
        Bidi bidiCreateLineBidi = bidiAnalyzeBidi != null ? bidiAnalyzeBidi.createLineBidi(i4, i5) : null;
        if (bidiCreateLineBidi == null || bidiCreateLineBidi.getRunCount() == 1) {
            boolean zIsRtlCharAt = layout.isRtlCharAt(lineStart);
            if (z || z3 == zIsRtlCharAt) {
                z3 = !z3;
            }
            return iLineEndToVisibleEnd == lineStart ? z3 : !z3 ? layout.getLineLeft(lineForOffset) : layout.getLineRight(lineForOffset);
        }
        int runCount = bidiCreateLineBidi.getRunCount();
        LayoutHelper$BidiRun[] layoutHelper$BidiRunArr = new LayoutHelper$BidiRun[runCount];
        for (int i6 = 0; i6 < runCount; i6++) {
            layoutHelper$BidiRunArr[i6] = new LayoutHelper$BidiRun(bidiCreateLineBidi.getRunStart(i6) + lineStart, bidiCreateLineBidi.getRunLimit(i6) + lineStart, bidiCreateLineBidi.getRunLevel(i6) % 2 == 1);
        }
        int runCount2 = bidiCreateLineBidi.getRunCount();
        byte[] bArr = new byte[runCount2];
        for (int i7 = 0; i7 < runCount2; i7++) {
            bArr[i7] = (byte) bidiCreateLineBidi.getRunLevel(i7);
        }
        Bidi.reorderVisually(bArr, 0, layoutHelper$BidiRunArr, 0, runCount);
        if (iLineEndToVisibleEnd == lineStart) {
            int i8 = 0;
            while (true) {
                if (i8 >= runCount) {
                    i3 = -1;
                    break;
                }
                if (layoutHelper$BidiRunArr[i8].start == iLineEndToVisibleEnd) {
                    i3 = i8;
                    break;
                }
                i8++;
            }
            boolean z4 = (z || z3 == layoutHelper$BidiRunArr[i3].isRtl) ? !z3 : z3;
            if (i3 == 0 && z4) {
                return layout.getLineLeft(lineForOffset);
            }
            if (i3 != runCount - 1 || z4) {
                return z4 ? layout.getPrimaryHorizontal(layoutHelper$BidiRunArr[i3 - 1].start) : layout.getPrimaryHorizontal(layoutHelper$BidiRunArr[i3 + 1].start);
            }
            return layout.getLineRight(lineForOffset);
        }
        if (iLineEndToVisibleEnd > iLineEndToVisibleEnd2) {
            iLineEndToVisibleEnd = lineEndToVisibleEnd(iLineEndToVisibleEnd, lineStart);
        }
        int i9 = 0;
        while (true) {
            if (i9 >= runCount) {
                i2 = -1;
                break;
            }
            if (layoutHelper$BidiRunArr[i9].end == iLineEndToVisibleEnd) {
                i2 = i9;
                break;
            }
            i9++;
        }
        boolean z5 = (z || z3 == layoutHelper$BidiRunArr[i2].isRtl) ? z3 : !z3;
        if (i2 == 0 && z5) {
            return layout.getLineLeft(lineForOffset);
        }
        if (i2 != runCount - 1 || z5) {
            return z5 ? layout.getPrimaryHorizontal(layoutHelper$BidiRunArr[i2 - 1].end) : layout.getPrimaryHorizontal(layoutHelper$BidiRunArr[i2 + 1].end);
        }
        return layout.getLineRight(lineForOffset);
    }

    public LifecycleCameraRepository$LifecycleCameraRepositoryObserver getLifecycleCameraRepositoryObserver(LifecycleOwner lifecycleOwner) {
        synchronized (this.url) {
            try {
                for (LifecycleCameraRepository$LifecycleCameraRepositoryObserver lifecycleCameraRepository$LifecycleCameraRepositoryObserver : ((HashMap) this.headers).keySet()) {
                    if (lifecycleOwner.equals(lifecycleCameraRepository$LifecycleCameraRepositoryObserver.mLifecycleOwner)) {
                        return lifecycleCameraRepository$LifecycleCameraRepositoryObserver;
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Collection getLifecycleCameras() {
        Collection collectionUnmodifiableCollection;
        synchronized (this.url) {
            collectionUnmodifiableCollection = Collections.unmodifiableCollection(((HashMap) this.method).values());
        }
        return collectionUnmodifiableCollection;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public float getMaxIntrinsicWidth() {
        return ((Number) this.tags.getValue()).floatValue();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public float getMinIntrinsicWidth() {
        return ((Number) this.headers.getValue()).floatValue();
    }

    public int getParagraphForOffset(int i, boolean z) {
        ArrayList arrayList = (ArrayList) this.method;
        int iBinarySearch$default = AppCompatHintHelper.binarySearch$default(arrayList, Integer.valueOf(i));
        int i2 = iBinarySearch$default < 0 ? -(iBinarySearch$default + 1) : iBinarySearch$default + 1;
        if (z && i2 > 0) {
            int i3 = i2 - 1;
            if (i == ((Number) arrayList.get(i3)).intValue()) {
                return i3;
            }
        }
        return i2;
    }

    public int getParagraphStart(int i) {
        if (i == 0) {
            return 0;
        }
        return ((Number) ((ArrayList) this.method).get(i - 1)).intValue();
    }

    public boolean hasPendingUpdates() {
        return ((ArrayList) this.method).size() > 0;
    }

    public boolean hasUseCaseBound(LifecycleOwner lifecycleOwner) {
        synchronized (this.url) {
            try {
                LifecycleCameraRepository$LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserver = getLifecycleCameraRepositoryObserver(lifecycleOwner);
                if (lifecycleCameraRepositoryObserver == null) {
                    return false;
                }
                Iterator it = ((Set) ((HashMap) this.headers).get(lifecycleCameraRepositoryObserver)).iterator();
                while (it.hasNext()) {
                    LifecycleCamera lifecycleCamera = (LifecycleCamera) ((HashMap) this.method).get((AutoValue_LifecycleCameraRepository_Key) it.next());
                    lifecycleCamera.getClass();
                    if (!lifecycleCamera.getUseCases().isEmpty()) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int lineEndToVisibleEnd(int i, int i2) {
        while (i > i2) {
            char cCharAt = ((Layout) this.url).getText().charAt(i - 1);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != 5760 && ((Intrinsics.compare((int) cCharAt, 8192) < 0 || Intrinsics.compare((int) cCharAt, 8202) > 0 || cCharAt == 8199) && cCharAt != 8287 && cCharAt != 12288)) {
                return i;
            }
            i--;
        }
        return i;
    }

    public Dispatcher newBuilder() {
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.runningSyncCalls = new LinkedHashMap();
        dispatcher.executorServiceOrNull = (HttpUrl) this.url;
        dispatcher.readyAsyncCalls = (String) this.method;
        Map map = (Map) this.tags;
        dispatcher.runningSyncCalls = map.isEmpty() ? new LinkedHashMap() : new LinkedHashMap(map);
        dispatcher.runningAsyncCalls = ((Headers) this.headers).newBuilder();
        return dispatcher;
    }

    public AdapterHelper$UpdateOp obtainUpdateOp(int i, int i2, int i3) {
        AdapterHelper$UpdateOp adapterHelper$UpdateOp = (AdapterHelper$UpdateOp) ((Pools$SimplePool) this.url).acquire();
        if (adapterHelper$UpdateOp != null) {
            adapterHelper$UpdateOp.cmd = i;
            adapterHelper$UpdateOp.positionStart = i2;
            adapterHelper$UpdateOp.itemCount = i3;
            return adapterHelper$UpdateOp;
        }
        AdapterHelper$UpdateOp adapterHelper$UpdateOp2 = new AdapterHelper$UpdateOp();
        adapterHelper$UpdateOp2.cmd = i;
        adapterHelper$UpdateOp2.positionStart = i2;
        adapterHelper$UpdateOp2.itemCount = i3;
        return adapterHelper$UpdateOp2;
    }

    public void postponeAndUpdateViewHolders(AdapterHelper$UpdateOp adapterHelper$UpdateOp) {
        RecyclerView.AnonymousClass4 anonymousClass4 = (RecyclerView.AnonymousClass4) this.tags;
        ((ArrayList) this.headers).add(adapterHelper$UpdateOp);
        int i = adapterHelper$UpdateOp.cmd;
        if (i == 1) {
            anonymousClass4.offsetPositionsForAdd(adapterHelper$UpdateOp.positionStart, adapterHelper$UpdateOp.itemCount);
            return;
        }
        if (i == 2) {
            int i2 = adapterHelper$UpdateOp.positionStart;
            int i3 = adapterHelper$UpdateOp.itemCount;
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.offsetPositionRecordsForRemove(i2, i3, false);
            recyclerView.mItemsAddedOrRemoved = true;
            return;
        }
        if (i == 4) {
            anonymousClass4.markViewHoldersUpdated(adapterHelper$UpdateOp.positionStart, adapterHelper$UpdateOp.itemCount);
        } else if (i == 8) {
            anonymousClass4.offsetPositionsForMove(adapterHelper$UpdateOp.positionStart, adapterHelper$UpdateOp.itemCount);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + adapterHelper$UpdateOp);
        }
    }

    public void recycleUpdateOpsAndClearList(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            AdapterHelper$UpdateOp adapterHelper$UpdateOp = (AdapterHelper$UpdateOp) arrayList.get(i);
            adapterHelper$UpdateOp.getClass();
            ((Pools$SimplePool) this.url).release(adapterHelper$UpdateOp);
        }
        arrayList.clear();
    }

    public void registerCamera(LifecycleCamera lifecycleCamera) {
        synchronized (this.url) {
            try {
                LifecycleOwner lifecycleOwner = lifecycleCamera.getLifecycleOwner();
                CameraUseCaseAdapter cameraUseCaseAdapter = lifecycleCamera.mCameraUseCaseAdapter;
                AutoValue_LifecycleCameraRepository_Key autoValue_LifecycleCameraRepository_Key = new AutoValue_LifecycleCameraRepository_Key(lifecycleOwner, CameraUseCaseAdapter.generateCameraId(cameraUseCaseAdapter.mAdapterCameraInfo, cameraUseCaseAdapter.mAdapterSecondaryCameraInfo));
                LifecycleCameraRepository$LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserver = getLifecycleCameraRepositoryObserver(lifecycleOwner);
                Set hashSet = lifecycleCameraRepositoryObserver != null ? (Set) ((HashMap) this.headers).get(lifecycleCameraRepositoryObserver) : new HashSet();
                hashSet.add(autoValue_LifecycleCameraRepository_Key);
                ((HashMap) this.method).put(autoValue_LifecycleCameraRepository_Key, lifecycleCamera);
                if (lifecycleCameraRepositoryObserver == null) {
                    LifecycleCameraRepository$LifecycleCameraRepositoryObserver lifecycleCameraRepository$LifecycleCameraRepositoryObserver = new LifecycleCameraRepository$LifecycleCameraRepositoryObserver(lifecycleOwner, this);
                    ((HashMap) this.headers).put(lifecycleCameraRepository$LifecycleCameraRepositoryObserver, hashSet);
                    lifecycleOwner.getLifecycle().addObserver(lifecycleCameraRepository$LifecycleCameraRepositoryObserver);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void set(Object obj, String str) {
        ((LinkedHashMap) this.url).put(str, obj);
        MutableStateFlow mutableStateFlow = (MutableStateFlow) ((LinkedHashMap) this.headers).get(str);
        if (mutableStateFlow != null) {
            ((StateFlowImpl) mutableStateFlow).setValue(obj);
        }
        MutableStateFlow mutableStateFlow2 = (MutableStateFlow) ((LinkedHashMap) this.tags).get(str);
        if (mutableStateFlow2 != null) {
            ((StateFlowImpl) mutableStateFlow2).setValue(obj);
        }
    }

    public void setActive(LifecycleOwner lifecycleOwner) {
        synchronized (this.url) {
            try {
                if (hasUseCaseBound(lifecycleOwner)) {
                    if (((ArrayDeque) this.tags).isEmpty()) {
                        ((ArrayDeque) this.tags).push(lifecycleOwner);
                    } else {
                        DatabaseConfiguration databaseConfiguration = (DatabaseConfiguration) this.lazyCacheControl;
                        if (databaseConfiguration == null || databaseConfiguration.journalMode != 2) {
                            LifecycleOwner lifecycleOwner2 = (LifecycleOwner) ((ArrayDeque) this.tags).peek();
                            if (!lifecycleOwner.equals(lifecycleOwner2)) {
                                suspendUseCases(lifecycleOwner2);
                                ((ArrayDeque) this.tags).remove(lifecycleOwner);
                                ((ArrayDeque) this.tags).push(lifecycleOwner);
                            }
                        }
                    }
                    unsuspendUseCases(lifecycleOwner);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void setInactive(LifecycleOwner lifecycleOwner) {
        synchronized (this.url) {
            try {
                ((ArrayDeque) this.tags).remove(lifecycleOwner);
                suspendUseCases(lifecycleOwner);
                if (!((ArrayDeque) this.tags).isEmpty()) {
                    unsuspendUseCases((LifecycleOwner) ((ArrayDeque) this.tags).peek());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void suspendUseCases(LifecycleOwner lifecycleOwner) {
        synchronized (this.url) {
            try {
                LifecycleCameraRepository$LifecycleCameraRepositoryObserver lifecycleCameraRepositoryObserver = getLifecycleCameraRepositoryObserver(lifecycleOwner);
                if (lifecycleCameraRepositoryObserver == null) {
                    return;
                }
                Iterator it = ((Set) ((HashMap) this.headers).get(lifecycleCameraRepositoryObserver)).iterator();
                while (it.hasNext()) {
                    LifecycleCamera lifecycleCamera = (LifecycleCamera) ((HashMap) this.method).get((AutoValue_LifecycleCameraRepository_Key) it.next());
                    lifecycleCamera.getClass();
                    lifecycleCamera.suspend();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 0:
                Map map = (Map) this.tags;
                StringBuilder sb = new StringBuilder("Request{method=");
                sb.append((String) this.method);
                sb.append(", url=");
                sb.append((HttpUrl) this.url);
                Headers headers = (Headers) this.headers;
                if (headers.size() != 0) {
                    sb.append(", headers=[");
                    int i = 0;
                    for (Object obj : headers) {
                        int i2 = i + 1;
                        if (i < 0) {
                            AppCompatHintHelper.throwIndexOverflow();
                            throw null;
                        }
                        Pair pair = (Pair) obj;
                        String str = (String) pair.first;
                        String str2 = (String) pair.second;
                        if (i > 0) {
                            sb.append(", ");
                        }
                        sb.append(str);
                        sb.append(':');
                        sb.append(str2);
                        i = i2;
                    }
                    sb.append(']');
                }
                if (!map.isEmpty()) {
                    sb.append(", tags=");
                    sb.append(map);
                }
                sb.append('}');
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public void unbindAll() {
        synchronized (this.url) {
            try {
                Iterator it = ((HashMap) this.method).keySet().iterator();
                while (it.hasNext()) {
                    LifecycleCamera lifecycleCamera = (LifecycleCamera) ((HashMap) this.method).get((AutoValue_LifecycleCameraRepository_Key) it.next());
                    lifecycleCamera.unbindAll();
                    setInactive(lifecycleCamera.getLifecycleOwner());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void unsuspendUseCases(LifecycleOwner lifecycleOwner) {
        synchronized (this.url) {
            try {
                Iterator it = ((Set) ((HashMap) this.headers).get(getLifecycleCameraRepositoryObserver(lifecycleOwner))).iterator();
                while (it.hasNext()) {
                    LifecycleCamera lifecycleCamera = (LifecycleCamera) ((HashMap) this.method).get((AutoValue_LifecycleCameraRepository_Key) it.next());
                    lifecycleCamera.getClass();
                    if (!lifecycleCamera.getUseCases().isEmpty()) {
                        lifecycleCamera.unsuspend();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int updatePositionWithPostponed(int i, int i2) {
        int i3;
        int i4;
        Pools$SimplePool pools$SimplePool = (Pools$SimplePool) this.url;
        ArrayList arrayList = (ArrayList) this.headers;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            AdapterHelper$UpdateOp adapterHelper$UpdateOp = (AdapterHelper$UpdateOp) arrayList.get(size);
            int i5 = adapterHelper$UpdateOp.cmd;
            if (i5 == 8) {
                int i6 = adapterHelper$UpdateOp.positionStart;
                int i7 = adapterHelper$UpdateOp.itemCount;
                if (i6 < i7) {
                    i4 = i6;
                    i3 = i7;
                } else {
                    i3 = i6;
                    i4 = i7;
                }
                if (i < i4 || i > i3) {
                    if (i < i6) {
                        if (i2 == 1) {
                            adapterHelper$UpdateOp.positionStart = i6 + 1;
                            adapterHelper$UpdateOp.itemCount = i7 + 1;
                        } else if (i2 == 2) {
                            adapterHelper$UpdateOp.positionStart = i6 - 1;
                            adapterHelper$UpdateOp.itemCount = i7 - 1;
                        }
                    }
                } else if (i4 == i6) {
                    if (i2 == 1) {
                        adapterHelper$UpdateOp.itemCount = i7 + 1;
                    } else if (i2 == 2) {
                        adapterHelper$UpdateOp.itemCount = i7 - 1;
                    }
                    i++;
                } else {
                    if (i2 == 1) {
                        adapterHelper$UpdateOp.positionStart = i6 + 1;
                    } else if (i2 == 2) {
                        adapterHelper$UpdateOp.positionStart = i6 - 1;
                    }
                    i--;
                }
            } else {
                int i8 = adapterHelper$UpdateOp.positionStart;
                if (i8 <= i) {
                    if (i5 == 1) {
                        i -= adapterHelper$UpdateOp.itemCount;
                    } else if (i5 == 2) {
                        i += adapterHelper$UpdateOp.itemCount;
                    }
                } else if (i2 == 1) {
                    adapterHelper$UpdateOp.positionStart = i8 + 1;
                } else if (i2 == 2) {
                    adapterHelper$UpdateOp.positionStart = i8 - 1;
                }
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            AdapterHelper$UpdateOp adapterHelper$UpdateOp2 = (AdapterHelper$UpdateOp) arrayList.get(size2);
            if (adapterHelper$UpdateOp2.cmd == 8) {
                int i9 = adapterHelper$UpdateOp2.itemCount;
                if (i9 == adapterHelper$UpdateOp2.positionStart || i9 < 0) {
                    arrayList.remove(size2);
                    pools$SimplePool.release(adapterHelper$UpdateOp2);
                }
            } else if (adapterHelper$UpdateOp2.itemCount <= 0) {
                arrayList.remove(size2);
                pools$SimplePool.release(adapterHelper$UpdateOp2);
            }
        }
        return i;
    }

    public /* synthetic */ Request(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, int i) {
        this.$r8$classId = i;
        this.url = obj;
        this.method = obj2;
        this.headers = obj3;
        this.tags = obj4;
        this.lazyCacheControl = obj5;
    }

    public Request(Map map) {
        this.$r8$classId = 9;
        this.url = new LinkedHashMap(map);
        this.method = new LinkedHashMap();
        this.headers = new LinkedHashMap();
        this.tags = new LinkedHashMap();
        this.lazyCacheControl = new FragmentManager$$ExternalSyntheticLambda4(2, this);
    }

    public void add(Fetcher.Factory factory, Class cls) {
        ((ArrayList) this.tags).add(new Pair(factory, cls));
    }

    public Request(HttpUrl httpUrl, String str, Headers headers, RequestBody$Companion$toRequestBody$2 requestBody$Companion$toRequestBody$2, Map map) {
        this.$r8$classId = 0;
        this.url = httpUrl;
        this.method = str;
        this.headers = headers;
        this.tags = map;
    }

    public Request(Layout layout) {
        this.$r8$classId = 8;
        this.url = layout;
        ArrayList arrayList = new ArrayList();
        int length = 0;
        do {
            int iIndexOf$default = StringsKt.indexOf$default(((Layout) this.url).getText(), '\n', length, 4);
            length = iIndexOf$default < 0 ? ((Layout) this.url).getText().length() : iIndexOf$default + 1;
            arrayList.add(Integer.valueOf(length));
        } while (length < ((Layout) this.url).getText().length());
        this.method = arrayList;
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList2.add(null);
        }
        this.headers = arrayList2;
        this.tags = new boolean[((ArrayList) this.method).size()];
        ((ArrayList) this.method).size();
    }

    public AutoValue_SessionConfig_OutputConfig build() {
        String strM;
        if (((DeferrableSurface) this.url) == null) {
            strM = " surface";
        } else {
            strM = "";
        }
        if (((List) this.method) == null) {
            strM = strM.concat(" sharedSurfaces");
        }
        if (((Integer) this.headers) == null) {
            strM = ImageAnalysis$$ExternalSyntheticLambda1.m(strM, " mirrorMode");
        }
        if (((Integer) this.tags) == null) {
            strM = ImageAnalysis$$ExternalSyntheticLambda1.m(strM, " surfaceGroupId");
        }
        if (((DynamicRange) this.lazyCacheControl) == null) {
            strM = ImageAnalysis$$ExternalSyntheticLambda1.m(strM, " dynamicRange");
        }
        if (strM.isEmpty()) {
            return new AutoValue_SessionConfig_OutputConfig((DeferrableSurface) this.url, (List) this.method, ((Integer) this.headers).intValue(), ((Integer) this.tags).intValue(), (DynamicRange) this.lazyCacheControl);
        }
        throw new IllegalStateException("Missing required properties:".concat(strM));
    }

    public Request(AnnotatedString annotatedString, TextStyle textStyle, List list, Density density, FontFamily$Resolver fontFamily$Resolver) {
        int i;
        AnnotatedString annotatedString2 = annotatedString;
        TextStyle textStyle2 = textStyle;
        this.$r8$classId = 7;
        this.url = annotatedString2;
        this.method = list;
        final int i2 = 0;
        this.headers = LazyKt__LazyJVMKt.lazy(3, new Function0(this) { // from class: androidx.compose.ui.text.MultiParagraphIntrinsics$$ExternalSyntheticLambda0
            public final /* synthetic */ Request f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Object obj;
                Object obj2;
                switch (i2) {
                    case 0:
                        ArrayList arrayList = (ArrayList) this.f$0.lazyCacheControl;
                        if (arrayList.isEmpty()) {
                            obj = null;
                        } else {
                            Object obj3 = arrayList.get(0);
                            float minIntrinsicWidth = ((ParagraphIntrinsicInfo) obj3).intrinsics.getMinIntrinsicWidth();
                            int lastIndex = AppCompatHintHelper.getLastIndex(arrayList);
                            int i3 = 1;
                            if (1 <= lastIndex) {
                                while (true) {
                                    Object obj4 = arrayList.get(i3);
                                    float minIntrinsicWidth2 = ((ParagraphIntrinsicInfo) obj4).intrinsics.getMinIntrinsicWidth();
                                    if (Float.compare(minIntrinsicWidth, minIntrinsicWidth2) < 0) {
                                        obj3 = obj4;
                                        minIntrinsicWidth = minIntrinsicWidth2;
                                    }
                                    if (i3 != lastIndex) {
                                        i3++;
                                    }
                                }
                            }
                            obj = obj3;
                        }
                        ParagraphIntrinsicInfo paragraphIntrinsicInfo = (ParagraphIntrinsicInfo) obj;
                        return Float.valueOf(paragraphIntrinsicInfo != null ? paragraphIntrinsicInfo.intrinsics.getMinIntrinsicWidth() : 0.0f);
                    default:
                        ArrayList arrayList2 = (ArrayList) this.f$0.lazyCacheControl;
                        if (arrayList2.isEmpty()) {
                            obj2 = null;
                        } else {
                            Object obj5 = arrayList2.get(0);
                            float maxIntrinsicWidth = ((ParagraphIntrinsicInfo) obj5).intrinsics.layoutIntrinsics.getMaxIntrinsicWidth();
                            int lastIndex2 = AppCompatHintHelper.getLastIndex(arrayList2);
                            int i4 = 1;
                            if (1 <= lastIndex2) {
                                while (true) {
                                    Object obj6 = arrayList2.get(i4);
                                    float maxIntrinsicWidth2 = ((ParagraphIntrinsicInfo) obj6).intrinsics.layoutIntrinsics.getMaxIntrinsicWidth();
                                    if (Float.compare(maxIntrinsicWidth, maxIntrinsicWidth2) < 0) {
                                        obj5 = obj6;
                                        maxIntrinsicWidth = maxIntrinsicWidth2;
                                    }
                                    if (i4 != lastIndex2) {
                                        i4++;
                                    }
                                }
                            }
                            obj2 = obj5;
                        }
                        ParagraphIntrinsicInfo paragraphIntrinsicInfo2 = (ParagraphIntrinsicInfo) obj2;
                        return Float.valueOf(paragraphIntrinsicInfo2 != null ? paragraphIntrinsicInfo2.intrinsics.layoutIntrinsics.getMaxIntrinsicWidth() : 0.0f);
                }
            }
        });
        final int i3 = 1;
        this.tags = LazyKt__LazyJVMKt.lazy(3, new Function0(this) { // from class: androidx.compose.ui.text.MultiParagraphIntrinsics$$ExternalSyntheticLambda0
            public final /* synthetic */ Request f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Object obj;
                Object obj2;
                switch (i3) {
                    case 0:
                        ArrayList arrayList = (ArrayList) this.f$0.lazyCacheControl;
                        if (arrayList.isEmpty()) {
                            obj = null;
                        } else {
                            Object obj3 = arrayList.get(0);
                            float minIntrinsicWidth = ((ParagraphIntrinsicInfo) obj3).intrinsics.getMinIntrinsicWidth();
                            int lastIndex = AppCompatHintHelper.getLastIndex(arrayList);
                            int i4 = 1;
                            if (1 <= lastIndex) {
                                while (true) {
                                    Object obj4 = arrayList.get(i4);
                                    float minIntrinsicWidth2 = ((ParagraphIntrinsicInfo) obj4).intrinsics.getMinIntrinsicWidth();
                                    if (Float.compare(minIntrinsicWidth, minIntrinsicWidth2) < 0) {
                                        obj3 = obj4;
                                        minIntrinsicWidth = minIntrinsicWidth2;
                                    }
                                    if (i4 != lastIndex) {
                                        i4++;
                                    }
                                }
                            }
                            obj = obj3;
                        }
                        ParagraphIntrinsicInfo paragraphIntrinsicInfo = (ParagraphIntrinsicInfo) obj;
                        return Float.valueOf(paragraphIntrinsicInfo != null ? paragraphIntrinsicInfo.intrinsics.getMinIntrinsicWidth() : 0.0f);
                    default:
                        ArrayList arrayList2 = (ArrayList) this.f$0.lazyCacheControl;
                        if (arrayList2.isEmpty()) {
                            obj2 = null;
                        } else {
                            Object obj5 = arrayList2.get(0);
                            float maxIntrinsicWidth = ((ParagraphIntrinsicInfo) obj5).intrinsics.layoutIntrinsics.getMaxIntrinsicWidth();
                            int lastIndex2 = AppCompatHintHelper.getLastIndex(arrayList2);
                            int i5 = 1;
                            if (1 <= lastIndex2) {
                                while (true) {
                                    Object obj6 = arrayList2.get(i5);
                                    float maxIntrinsicWidth2 = ((ParagraphIntrinsicInfo) obj6).intrinsics.layoutIntrinsics.getMaxIntrinsicWidth();
                                    if (Float.compare(maxIntrinsicWidth, maxIntrinsicWidth2) < 0) {
                                        obj5 = obj6;
                                        maxIntrinsicWidth = maxIntrinsicWidth2;
                                    }
                                    if (i5 != lastIndex2) {
                                        i5++;
                                    }
                                }
                            }
                            obj2 = obj5;
                        }
                        ParagraphIntrinsicInfo paragraphIntrinsicInfo2 = (ParagraphIntrinsicInfo) obj2;
                        return Float.valueOf(paragraphIntrinsicInfo2 != null ? paragraphIntrinsicInfo2.intrinsics.layoutIntrinsics.getMaxIntrinsicWidth() : 0.0f);
                }
            }
        });
        ParagraphStyle paragraphStyle = textStyle2.paragraphStyle;
        AnnotatedString annotatedString3 = AnnotatedStringKt.EmptyAnnotatedString;
        ArrayList arrayList = annotatedString2.paragraphStylesOrNull;
        String str = annotatedString2.text;
        EmptyList emptyList = EmptyList.INSTANCE;
        List listSortedWith = arrayList != null ? CollectionsKt.sortedWith(arrayList, new AnnotatedString$special$$inlined$sortedBy$1(1)) : emptyList;
        ArrayList arrayList2 = new ArrayList();
        kotlin.collections.ArrayDeque arrayDeque = new kotlin.collections.ArrayDeque();
        int size = listSortedWith.size();
        int i4 = 0;
        int i5 = 0;
        while (i4 < size) {
            AnnotatedString.Range range = (AnnotatedString.Range) listSortedWith.get(i4);
            ParagraphStyle paragraphStyleMerge = paragraphStyle.merge((ParagraphStyle) range.item);
            int i6 = range.start;
            int i7 = range.end;
            if (i6 > i7) {
                InlineClassHelperKt.throwIllegalArgumentException("Reversed range is not supported");
            }
            while (i5 < i6 && !arrayDeque.isEmpty()) {
                AnnotatedString.Range range2 = (AnnotatedString.Range) arrayDeque.last();
                listSortedWith = listSortedWith;
                int i8 = range2.end;
                emptyList = emptyList;
                Object obj = range2.item;
                if (i6 < i8) {
                    arrayList2.add(new AnnotatedString.Range(i5, i6, obj));
                    i5 = i6;
                } else {
                    int i9 = size;
                    arrayList2.add(new AnnotatedString.Range(i5, i8, obj));
                    i5 = range2.end;
                    while (!arrayDeque.isEmpty() && i5 == ((AnnotatedString.Range) arrayDeque.last()).end) {
                        arrayDeque.removeLast();
                    }
                    size = i9;
                }
            }
            List list2 = listSortedWith;
            EmptyList emptyList2 = emptyList;
            int i10 = size;
            if (i5 < i6) {
                arrayList2.add(new AnnotatedString.Range(i5, i6, paragraphStyle));
                i5 = i6;
            }
            AnnotatedString.Range range3 = (AnnotatedString.Range) arrayDeque.lastOrNull();
            if (range3 != null) {
                int i11 = range3.end;
                Object obj2 = range3.item;
                int i12 = range3.start;
                if (i12 == i6 && i11 == i7) {
                    arrayDeque.removeLast();
                    arrayDeque.addLast(new AnnotatedString.Range(i6, i7, ((ParagraphStyle) obj2).merge(paragraphStyleMerge)));
                } else if (i12 == i11) {
                    arrayList2.add(new AnnotatedString.Range(i12, i11, obj2));
                    arrayDeque.removeLast();
                    arrayDeque.addLast(new AnnotatedString.Range(i6, i7, paragraphStyleMerge));
                } else if (i11 >= i7) {
                    arrayDeque.addLast(new AnnotatedString.Range(i6, i7, ((ParagraphStyle) obj2).merge(paragraphStyleMerge)));
                } else {
                    throw new IllegalArgumentException();
                }
            } else {
                arrayDeque.addLast(new AnnotatedString.Range(i6, i7, paragraphStyleMerge));
            }
            i4++;
            listSortedWith = list2;
            emptyList = emptyList2;
            size = i10;
        }
        EmptyList emptyList3 = emptyList;
        while (i5 <= str.length() && !arrayDeque.isEmpty()) {
            AnnotatedString.Range range4 = (AnnotatedString.Range) arrayDeque.last();
            Object obj3 = range4.item;
            int i13 = range4.end;
            arrayList2.add(new AnnotatedString.Range(i5, i13, obj3));
            while (!arrayDeque.isEmpty() && i13 == ((AnnotatedString.Range) arrayDeque.last()).end) {
                arrayDeque.removeLast();
            }
            i5 = i13;
        }
        if (i5 < str.length()) {
            arrayList2.add(new AnnotatedString.Range(i5, str.length(), paragraphStyle));
        }
        if (arrayList2.isEmpty()) {
            i = 0;
            arrayList2.add(new AnnotatedString.Range(0, 0, paragraphStyle));
        } else {
            i = 0;
        }
        ArrayList arrayList3 = new ArrayList(arrayList2.size());
        int size2 = arrayList2.size();
        int i14 = i;
        while (i14 < size2) {
            AnnotatedString.Range range5 = (AnnotatedString.Range) arrayList2.get(i14);
            int i15 = range5.start;
            int i16 = range5.end;
            String strSubstring = i15 != i16 ? str.substring(i15, i16) : "";
            List localAnnotations = AnnotatedStringKt.getLocalAnnotations(annotatedString2, i15, i16, new SaversKt$$ExternalSyntheticLambda10(24));
            AnnotatedString annotatedString4 = new AnnotatedString(strSubstring, localAnnotations == null ? emptyList3 : localAnnotations);
            ParagraphStyle paragraphStyle2 = (ParagraphStyle) range5.item;
            if (paragraphStyle2.textDirection == 0) {
                paragraphStyle2 = new ParagraphStyle(paragraphStyle2.textAlign, paragraphStyle.textDirection, paragraphStyle2.lineHeight, paragraphStyle2.textIndent, paragraphStyle2.platformStyle, paragraphStyle2.lineHeightStyle, paragraphStyle2.lineBreak, paragraphStyle2.hyphens, paragraphStyle2.textMotion);
            }
            TextStyle textStyle3 = new TextStyle(textStyle2.spanStyle, paragraphStyle.merge(paragraphStyle2));
            List list3 = annotatedString4.annotations;
            List list4 = list3 == null ? emptyList3 : list3;
            List list5 = (List) this.method;
            ArrayList arrayList4 = new ArrayList(list5.size());
            int size3 = list5.size();
            int i17 = 0;
            while (i17 < size3) {
                AnnotatedString.Range range6 = (AnnotatedString.Range) list5.get(i17);
                int i18 = range6.start;
                ParagraphStyle paragraphStyle3 = paragraphStyle;
                int i19 = range6.end;
                if (AnnotatedStringKt.intersect(i15, i16, i18, i19)) {
                    if (i15 > i18 || i19 > i16) {
                        InlineClassHelperKt.throwIllegalArgumentException("placeholder can not overlap with paragraph.");
                    }
                    arrayList4.add(new AnnotatedString.Range(i18 - i15, i19 - i15, range6.item));
                }
                i17++;
                list5 = list5;
                paragraphStyle = paragraphStyle3;
            }
            arrayList3.add(new ParagraphIntrinsicInfo(new AndroidParagraphIntrinsics(strSubstring, textStyle3, list4, arrayList4, fontFamily$Resolver, density), i15, i16));
            i14++;
            annotatedString2 = annotatedString;
            textStyle2 = textStyle;
            str = str;
            arrayList2 = arrayList2;
        }
        this.lazyCacheControl = arrayList3;
    }

    public Request(int i) {
        this.$r8$classId = i;
        switch (i) {
            case 6:
                this.url = new Object();
                this.headers = new AtomicInt(0);
                this.tags = new MutableObjectList();
                this.lazyCacheControl = new MutableObjectList();
                break;
            default:
                this.url = new Object();
                this.method = new HashMap();
                this.headers = new HashMap();
                this.tags = new ArrayDeque();
                break;
        }
    }

    public Request(RecyclerView.AnonymousClass4 anonymousClass4) {
        this.$r8$classId = 10;
        this.url = new Pools$SimplePool(30);
        this.method = new ArrayList();
        this.headers = new ArrayList();
        this.tags = anonymousClass4;
        this.lazyCacheControl = new Parameters.Builder(23, this);
    }

    public Request(CameraInternal cameraInternal, CameraInternal cameraInternal2, SurfaceProcessorInternal surfaceProcessorInternal) {
        this.$r8$classId = 3;
        this.method = cameraInternal;
        this.headers = cameraInternal2;
        this.url = surfaceProcessorInternal;
    }

    public Request(ComponentRegistry componentRegistry) {
        this.$r8$classId = 11;
        this.url = new ArrayList(componentRegistry.interceptors);
        this.method = new ArrayList(componentRegistry.mappers);
        this.headers = new ArrayList(componentRegistry.keyers);
        this.tags = new ArrayList(componentRegistry.fetcherFactories);
        this.lazyCacheControl = new ArrayList(componentRegistry.decoderFactories);
    }
}
