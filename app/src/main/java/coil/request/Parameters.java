package coil.request;

import android.content.ClipData;
import android.content.ContentProviderClient;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Region;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.view.ContentInfo;
import android.view.View;
import android.view.ViewGroup;
import android.view.autofill.AutofillManager;
import android.widget.EditText;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.camera.core.impl.CameraProviderExecutionState;
import androidx.camera.core.streamsharing.VirtualCameraCaptureResult;
import androidx.compose.material3.RippleNodeFactory;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.retain.ManagedRetainedValuesStore;
import androidx.compose.runtime.retain.RetainedValuesStore;
import androidx.compose.runtime.retain.impl.PreconditionsKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.input.pointer.util.VelocityTracker1D;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.text.platform.ImmutableBool;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import androidx.core.os.CancellationSignal;
import androidx.core.os.LocaleListPlatformWrapper$$ExternalSyntheticApiModelOutline0;
import androidx.core.provider.FontProvider;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.SoftwareKeyboardControllerCompat$Impl30;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi19;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi26;
import androidx.emoji2.text.EmojiCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity$HostCallbacks;
import androidx.fragment.app.FragmentManager$LaunchedFragmentInfo;
import androidx.fragment.app.FragmentManagerImpl;
import androidx.fragment.app.SpecialEffectsController$FragmentStateManagerOperation;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.ViewBoundsCheck$Callback;
import coil.ImageLoader$Builder;
import coil.RealImageLoader$executeMain$1;
import coil.compose.AsyncImagePainter;
import coil.memory.MemoryCache$Key;
import coil.memory.MemoryCache$Value;
import coil.memory.MemoryCacheService;
import coil.memory.RealWeakMemoryCache;
import coil.memory.StrongMemoryCache;
import coil.size.SizeResolver;
import coil.util.Bitmaps;
import com.google.android.datatransport.cct.CctTransportBackend;
import com.google.android.datatransport.cct.internal.AutoValue_BatchedLogRequest;
import com.google.android.datatransport.cct.internal.AutoValue_LogResponse;
import com.google.android.gms.common.internal.zzp$$ExternalSyntheticApiModelOutline0;
import com.google.android.gms.internal.mlkit_vision_common.zzkl;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import com.google.firebase.encoders.json.JsonValueObjectEncoderContext;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import kotlin.Pair;
import kotlin.collections.EmptyMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SafeFlow;
import okhttp3.ConnectionPool;
import okio.AsyncTimeout;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Parameters implements Iterable, KMappedMarker {
    public static final Parameters EMPTY = new Parameters(EmptyMap.INSTANCE);
    public final Map entries;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public class Builder implements ColorProducer, RetainedValuesStore, FontProvider.ContentQueryWrapper, ContentInfoCompat.Compat, ActivityResultCallback, CancellationSignal.OnCancelListener, ViewBoundsCheck$Callback, SizeResolver, StrongMemoryCache {
        public final /* synthetic */ int $r8$classId;
        public Object entries;

        public /* synthetic */ Builder(int i, Object obj) {
            this.$r8$classId = i;
            this.entries = obj;
        }

        /*  JADX ERROR: Type inference failed
            jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 9241. Try increasing type updates limit count.
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
            */
        public static java.util.ArrayList pathStringToNodes$default(coil.request.Parameters.Builder r22, java.lang.String r23) {
            /*
                Method dump skipped, instruction units count: 924
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: coil.request.Parameters.Builder.pathStringToNodes$default(coil.request.Parameters$Builder, java.lang.String):java.util.ArrayList");
        }

        public CameraProviderExecutionState apply(ImageLoader$Builder imageLoader$Builder) {
            CctTransportBackend cctTransportBackend = (CctTransportBackend) this.entries;
            URL url = (URL) imageLoader$Builder.applicationContext;
            zzkl.d("CctTransportBackend", "Making request to: %s", url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(cctTransportBackend.readTimeout);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("User-Agent", "datatransport/2.3.3 android/");
            httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
            String str = (String) imageLoader$Builder.options;
            if (str != null) {
                httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
            }
            try {
                OutputStream outputStream = httpURLConnection.getOutputStream();
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                    try {
                        ConnectionPool connectionPool = cctTransportBackend.dataEncoder;
                        AutoValue_BatchedLogRequest autoValue_BatchedLogRequest = (AutoValue_BatchedLogRequest) imageLoader$Builder.defaults;
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(gZIPOutputStream));
                        JsonDataEncoderBuilder jsonDataEncoderBuilder = (JsonDataEncoderBuilder) connectionPool.delegate;
                        JsonValueObjectEncoderContext jsonValueObjectEncoderContext = new JsonValueObjectEncoderContext(bufferedWriter, jsonDataEncoderBuilder.objectEncoders, jsonDataEncoderBuilder.valueEncoders, jsonDataEncoderBuilder.fallbackEncoder, jsonDataEncoderBuilder.ignoreNullValues);
                        jsonValueObjectEncoderContext.add(autoValue_BatchedLogRequest);
                        jsonValueObjectEncoderContext.maybeUnNest();
                        jsonValueObjectEncoderContext.jsonWriter.flush();
                        gZIPOutputStream.close();
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        int responseCode = httpURLConnection.getResponseCode();
                        Log.i("TransportRuntime.".concat("CctTransportBackend"), ImageAnalysis$$ExternalSyntheticLambda1.m("Status Code: ", responseCode));
                        Log.i("TransportRuntime.".concat("CctTransportBackend"), "Content-Type: " + httpURLConnection.getHeaderField("Content-Type"));
                        Log.i("TransportRuntime.".concat("CctTransportBackend"), "Content-Encoding: " + httpURLConnection.getHeaderField("Content-Encoding"));
                        if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                            return new CameraProviderExecutionState(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                        }
                        if (responseCode != 200) {
                            return new CameraProviderExecutionState(responseCode, null, 0L);
                        }
                        InputStream inputStream = httpURLConnection.getInputStream();
                        try {
                            InputStream gZIPInputStream = "gzip".equals(httpURLConnection.getHeaderField("Content-Encoding")) ? new GZIPInputStream(inputStream) : inputStream;
                            try {
                                CameraProviderExecutionState cameraProviderExecutionState = new CameraProviderExecutionState(responseCode, null, AutoValue_LogResponse.fromJson(new BufferedReader(new InputStreamReader(gZIPInputStream))).nextRequestWaitMillis);
                                if (gZIPInputStream != null) {
                                    gZIPInputStream.close();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                return cameraProviderExecutionState;
                            } catch (Throwable th) {
                                if (gZIPInputStream != null) {
                                    try {
                                        gZIPInputStream.close();
                                    } catch (Throwable unused) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th2) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable unused2) {
                                }
                            }
                            throw th2;
                        }
                    } catch (Throwable th3) {
                        try {
                            gZIPOutputStream.close();
                        } catch (Throwable unused3) {
                        }
                        throw th3;
                    }
                } catch (Throwable th4) {
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Throwable unused4) {
                        }
                    }
                    throw th4;
                }
            } catch (EncodingException e) {
                e = e;
                Log.e("TransportRuntime.".concat("CctTransportBackend"), "Couldn't encode request, returning with 400", e);
                return new CameraProviderExecutionState(400, null, 0L);
            } catch (ConnectException e2) {
                e = e2;
                Log.e("TransportRuntime.".concat("CctTransportBackend"), "Couldn't open connection, returning with 500", e);
                return new CameraProviderExecutionState(500, null, 0L);
            } catch (UnknownHostException e3) {
                e = e3;
                Log.e("TransportRuntime.".concat("CctTransportBackend"), "Couldn't open connection, returning with 500", e);
                return new CameraProviderExecutionState(500, null, 0L);
            } catch (IOException e4) {
                e = e4;
                Log.e("TransportRuntime.".concat("CctTransportBackend"), "Couldn't encode request, returning with 400", e);
                return new CameraProviderExecutionState(400, null, 0L);
            }
        }

        /* JADX INFO: renamed from: calculateVelocity-AH228Gc, reason: not valid java name */
        public long m789calculateVelocityAH228Gc(long j) {
            VirtualCameraCaptureResult virtualCameraCaptureResult = (VirtualCameraCaptureResult) this.entries;
            virtualCameraCaptureResult.getClass();
            if (Velocity.m734getXimpl(j) <= 0.0f || Velocity.m735getYimpl(j) <= 0.0f) {
                InlineClassHelperKt.throwIllegalStateException("maximumVelocity should be a positive value. You specified=" + ((Object) Velocity.m739toStringimpl(j)));
            }
            return VelocityKt.Velocity(((VelocityTracker1D) virtualCameraCaptureResult.mBaseCameraCaptureResult).calculateVelocity(Velocity.m734getXimpl(j)), ((VelocityTracker1D) virtualCameraCaptureResult.mTagBundle).calculateVelocity(Velocity.m735getYimpl(j)));
        }

        /* JADX INFO: renamed from: clipRect-N_I0leg, reason: not valid java name */
        public void m790clipRectN_I0leg(float f, float f2, float f3, float f4, int i) {
            ((MenuHostHelper) this.entries).getCanvas().mo393clipRectN_I0leg(f, f2, f3, f4, i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.core.provider.FontProvider.ContentQueryWrapper
        public void close() throws Exception {
            ContentProviderClient contentProviderClient = (ContentProviderClient) this.entries;
            if (contentProviderClient != 0) {
                if (contentProviderClient instanceof AutoCloseable) {
                    contentProviderClient.close();
                } else if (contentProviderClient instanceof ExecutorService) {
                    LocaleListPlatformWrapper$$ExternalSyntheticApiModelOutline0.m((ExecutorService) contentProviderClient);
                } else {
                    contentProviderClient.release();
                }
            }
        }

        public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i) {
            return null;
        }

        public void current() {
            ((CompositionContext) this.entries).getClass();
        }

        public AccessibilityNodeInfoCompat findFocus(int i) {
            return null;
        }

        @Override // coil.memory.StrongMemoryCache
        public MemoryCache$Value get(MemoryCache$Key memoryCache$Key) {
            return null;
        }

        @Override // androidx.recyclerview.widget.ViewBoundsCheck$Callback
        public View getChildAt(int i) {
            return ((RecyclerView.LayoutManager) this.entries).getChildAt(i);
        }

        @Override // androidx.recyclerview.widget.ViewBoundsCheck$Callback
        public int getChildEnd(View view) {
            return view.getBottom() + ((RecyclerView.LayoutParams) view.getLayoutParams()).mDecorInsets.bottom + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.ViewBoundsCheck$Callback
        public int getChildStart(View view) {
            return (view.getTop() - ((RecyclerView.LayoutParams) view.getLayoutParams()).mDecorInsets.top) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public ClipData getClip() {
            return ((ContentInfo) this.entries).getClip();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getFlags() {
            return ((ContentInfo) this.entries).getFlags();
        }

        public State getFontLoadState() {
            EmojiCompat emojiCompat = EmojiCompat.get();
            if (emojiCompat.getLoadState() == 1) {
                return new ImmutableBool(true);
            }
            final ParcelableSnapshotMutableState parcelableSnapshotMutableStateMutableStateOf$default = Stack.mutableStateOf$default(Boolean.FALSE);
            emojiCompat.registerInitCallback(new EmojiCompat.InitCallback() { // from class: androidx.compose.ui.text.platform.DefaultImpl$getFontLoadState$initCallback$1
                @Override // androidx.emoji2.text.EmojiCompat.InitCallback
                public final void onFailed() {
                    this.entries = AndroidTextPaint_androidKt.Falsey;
                }

                @Override // androidx.emoji2.text.EmojiCompat.InitCallback
                public final void onInitialized() {
                    parcelableSnapshotMutableStateMutableStateOf$default.setValue(Boolean.TRUE);
                    this.entries = new ImmutableBool(true);
                }
            });
            return parcelableSnapshotMutableStateMutableStateOf$default;
        }

        @Override // androidx.recyclerview.widget.ViewBoundsCheck$Callback
        public int getParentEnd() {
            RecyclerView.LayoutManager layoutManager = (RecyclerView.LayoutManager) this.entries;
            return layoutManager.mHeight - layoutManager.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.ViewBoundsCheck$Callback
        public int getParentStart() {
            return ((RecyclerView.LayoutManager) this.entries).getPaddingTop();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getSource() {
            return ((ContentInfo) this.entries).getSource();
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public ContentInfo getWrapped() {
            return (ContentInfo) this.entries;
        }

        public void inset(float f, float f2, float f3, float f4) {
            MenuHostHelper menuHostHelper = (MenuHostHelper) this.entries;
            Canvas canvas = menuHostHelper.getCanvas();
            float fIntBitsToFloat = Float.intBitsToFloat((int) (menuHostHelper.m756getSizeNHjbRc() >> 32)) - (f3 + f);
            long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (menuHostHelper.m756getSizeNHjbRc() & 4294967295L)) - (f4 + f2))) & 4294967295L) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32);
            if (!(Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32)) >= 0.0f && Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L)) >= 0.0f)) {
                androidx.compose.ui.graphics.InlineClassHelperKt.throwIllegalArgumentException("Width and height must be greater than or equal to zero");
            }
            menuHostHelper.m758setSizeuvyYCjk(jFloatToRawIntBits);
            canvas.translate(f, f2);
        }

        @Override // androidx.compose.ui.graphics.ColorProducer
        /* JADX INFO: renamed from: invoke-0d7_KjU */
        public long mo13invoke0d7_KjU() {
            return ((RippleNodeFactory) this.entries).color;
        }

        public void noteStateNotSaved() {
            ((FragmentActivity$HostCallbacks) this.entries).mFragmentManager.noteStateNotSaved();
        }

        public void notifyViewVisibilityChanged(View view, int i, boolean z) {
            if (Build.VERSION.SDK_INT >= 27) {
                ((AutofillManager) this.entries).notifyViewVisibilityChanged(view, i, z);
            }
        }

        @Override // androidx.activity.result.ActivityResultCallback
        public void onActivityResult(Object obj) {
            ActivityResult activityResult = (ActivityResult) obj;
            FragmentManagerImpl fragmentManagerImpl = (FragmentManagerImpl) this.entries;
            FragmentManager$LaunchedFragmentInfo fragmentManager$LaunchedFragmentInfo = (FragmentManager$LaunchedFragmentInfo) fragmentManagerImpl.mLaunchedFragments.pollFirst();
            if (fragmentManager$LaunchedFragmentInfo == null) {
                Log.w("FragmentManager", "No Activities were started for result for " + this);
                return;
            }
            String str = fragmentManager$LaunchedFragmentInfo.mWho;
            int i = fragmentManager$LaunchedFragmentInfo.mRequestCode;
            Fragment fragmentFindFragmentByWho = fragmentManagerImpl.mFragmentStore.findFragmentByWho(str);
            if (fragmentFindFragmentByWho != null) {
                fragmentFindFragmentByWho.onActivityResult(i, activityResult.resultCode, activityResult.data);
                return;
            }
            Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
        }

        @Override // androidx.core.os.CancellationSignal.OnCancelListener
        public void onCancel() {
            ((SpecialEffectsController$FragmentStateManagerOperation) this.entries).cancel();
        }

        public boolean performAction(int i, int i2, Bundle bundle) {
            return false;
        }

        @Override // androidx.core.provider.FontProvider.ContentQueryWrapper
        public Cursor query(Uri uri, String[] strArr, String[] strArr2) {
            ContentProviderClient contentProviderClient = (ContentProviderClient) this.entries;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                return contentProviderClient.query(uri, strArr, "query = ?", strArr2, null, null);
            } catch (RemoteException e) {
                Log.w("FontsProvider", "Unable to query the content provider", e);
                return null;
            }
        }

        /* JADX INFO: renamed from: rotate-Uv8p0NA, reason: not valid java name */
        public void m791rotateUv8p0NA(float f, long j) {
            Canvas canvas = ((MenuHostHelper) this.entries).getCanvas();
            int i = (int) (j >> 32);
            int i2 = (int) (j & 4294967295L);
            canvas.translate(Float.intBitsToFloat(i), Float.intBitsToFloat(i2));
            canvas.rotate(f);
            canvas.translate(-Float.intBitsToFloat(i), -Float.intBitsToFloat(i2));
        }

        /* JADX INFO: renamed from: scale-0AR0LA0, reason: not valid java name */
        public void m792scale0AR0LA0(float f, float f2, long j) {
            Canvas canvas = ((MenuHostHelper) this.entries).getCanvas();
            int i = (int) (j >> 32);
            int i2 = (int) (j & 4294967295L);
            canvas.translate(Float.intBitsToFloat(i), Float.intBitsToFloat(i2));
            canvas.scale(f, f2);
            canvas.translate(-Float.intBitsToFloat(i), -Float.intBitsToFloat(i2));
        }

        public void set(IntRect intRect) {
            ((Region) this.entries).set(intRect.left, intRect.top, intRect.right, intRect.bottom);
        }

        @Override // coil.size.SizeResolver
        public Object size(RealImageLoader$executeMain$1 realImageLoader$executeMain$1) {
            return FlowKt.first(new SafeFlow(((AsyncImagePainter) this.entries).drawSize, 1), realImageLoader$executeMain$1);
        }

        public String toString() {
            switch (this.$r8$classId) {
                case 15:
                    return "ContentInfoCompat{" + ((ContentInfo) this.entries) + "}";
                default:
                    return super.toString();
            }
        }

        public void translate(float f, float f2) {
            ((MenuHostHelper) this.entries).getCanvas().translate(f, f2);
        }

        public /* synthetic */ Builder(int i, boolean z) {
            this.$r8$classId = i;
        }

        public Builder(View view) {
            this.$r8$classId = 16;
            if (Build.VERSION.SDK_INT >= 30) {
                SoftwareKeyboardControllerCompat$Impl30 softwareKeyboardControllerCompat$Impl30 = new SoftwareKeyboardControllerCompat$Impl30(12, view);
                softwareKeyboardControllerCompat$Impl30.mView = view;
                this.entries = softwareKeyboardControllerCompat$Impl30;
                return;
            }
            this.entries = new MemoryCacheService(12, view);
        }

        @Override // coil.memory.StrongMemoryCache
        public void set(MemoryCache$Key memoryCache$Key, Bitmap bitmap, Map map) {
            ((RealWeakMemoryCache) this.entries).set(memoryCache$Key, bitmap, map, Bitmaps.getAllocationByteCountCompat(bitmap));
        }

        public Builder(int i) {
            Object companion;
            this.$r8$classId = i;
            switch (i) {
                case 8:
                    ManagedRetainedValuesStore managedRetainedValuesStore = new ManagedRetainedValuesStore();
                    this.entries = managedRetainedValuesStore;
                    if (!managedRetainedValuesStore.isDisposed) {
                        if (managedRetainedValuesStore.isContentComposed) {
                            PreconditionsKt.throwIllegalStateException("ManagedValuesStore tried to enter composition twice. Did you attempt to install the same store multiple times or into two compositions?");
                        }
                        managedRetainedValuesStore.purgeUnusedExitedValues();
                        managedRetainedValuesStore.isContentComposed = true;
                        break;
                    }
                    break;
                case 10:
                    this.entries = new Region();
                    break;
                case 11:
                    if (Build.VERSION.SDK_INT >= 28) {
                        companion = new AsyncTimeout.Companion(7);
                    } else {
                        companion = new ByteString.Companion(7);
                    }
                    this.entries = companion;
                    break;
                case 17:
                    if (Build.VERSION.SDK_INT >= 26) {
                        this.entries = new AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi26(this);
                    } else {
                        this.entries = new AccessibilityNodeProviderCompat$AccessibilityNodeProviderApi19(this);
                    }
                    break;
                default:
                    this.entries = new VirtualCameraCaptureResult();
                    break;
            }
        }

        public Builder(Parameters parameters) {
            this.$r8$classId = 0;
            this.entries = new LinkedHashMap(parameters.entries);
        }

        @Override // coil.memory.StrongMemoryCache
        public void trimMemory(int i) {
        }

        public Builder(EditText editText) {
            this.$r8$classId = 19;
            this.entries = new RequestService(editText);
        }

        public Builder(Context context, Uri uri) {
            this.$r8$classId = 14;
            this.entries = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        public Builder(ContentInfo contentInfo) {
            this.$r8$classId = 15;
            contentInfo.getClass();
            this.entries = zzp$$ExternalSyntheticApiModelOutline0.m((Object) contentInfo);
        }

        public void addExtraDataToAccessibilityNodeInfo(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, String str, Bundle bundle) {
        }
    }

    public Parameters(Map map) {
        this.entries = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Parameters) {
            return Intrinsics.areEqual(this.entries, ((Parameters) obj).entries);
        }
        return false;
    }

    public final int hashCode() {
        return this.entries.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        Map map = this.entries;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (entry.getValue() != null) {
                throw new ClassCastException();
            }
            arrayList.add(new Pair(str, null));
        }
        return arrayList.iterator();
    }

    public final String toString() {
        return "Parameters(entries=" + this.entries + ')';
    }
}
