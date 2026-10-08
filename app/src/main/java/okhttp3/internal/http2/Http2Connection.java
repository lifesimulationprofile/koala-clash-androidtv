package okhttp3.internal.http2;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Size;
import android.view.Surface;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.appcompat.widget.ThemeUtils;
import androidx.appcompat.widget.TooltipPopup;
import androidx.camera.camera2.internal.MeteringRepeatingSession$MeteringRepeatingConfig;
import androidx.camera.camera2.internal.SynchronizedCaptureSessionImpl;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.camera.core.Preview$$ExternalSyntheticLambda2;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.compose.runtime.MutableState;
import androidx.core.graphics.ColorUtils;
import coil.ImageLoader$Builder;
import com.github.kr328.clash.compose.FileAction;
import com.github.kr328.clash.compose.ProviderItemState;
import com.github.kr328.clash.compose.connections.ProcessGroup;
import com.github.kr328.clash.core.model.LogMessage;
import com.github.kr328.clash.core.model.Proxy;
import com.github.kr328.clash.design.model.AppInfo;
import com.github.kr328.clash.design.model.File;
import com.github.kr328.clash.service.model.Profile;
import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.tasks.zzi;
import com.google.common.util.concurrent.ListenableFuture;
import com.koala.clash.R;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.inject.Provider;
import kotlin.Unit;
import kotlin.collections.AbstractList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexFormatKt;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okio.Buffer;
import okio.ByteString;
import okio.RealBufferedSink;
import okio.RealBufferedSource;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Http2Connection implements Closeable {
    public static final Settings DEFAULT_SETTINGS;
    public final String connectionName;
    public final LinkedHashSet currentPushRequests;
    public long degradedPingsSent;
    public long degradedPongDeadlineNs;
    public long degradedPongsReceived;
    public long intervalPongsReceived;
    public boolean isShutdown;
    public int lastGoodStreamId;
    public final Listener listener;
    public int nextStreamId;
    public final Settings okHttpSettings;
    public Settings peerSettings;
    public final PushObserver$Companion$PushObserverCancel pushObserver;
    public final TaskQueue pushQueue;
    public long readBytesAcknowledged;
    public long readBytesTotal;
    public final ReaderRunnable readerRunnable;
    public final TaskQueue settingsListenerQueue;
    public final Socket socket;
    public final LinkedHashMap streams = new LinkedHashMap();
    public final TaskRunner taskRunner;
    public long writeBytesMaximum;
    public long writeBytesTotal;
    public final Http2Writer writer;
    public final TaskQueue writerQueue;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Builder implements Factory {
        public Object connectionName;
        public Object listener;
        public Object sink;
        public Object socket;
        public Object source;
        public Object taskRunner;

        public /* synthetic */ Builder(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
            this.taskRunner = obj;
            this.socket = obj2;
            this.connectionName = obj3;
            this.source = obj4;
            this.sink = obj5;
            this.listener = obj6;
        }

        public static boolean arrayContains(int[] iArr, int i) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }

        public static ColorStateList createButtonColorStateList(Context context, int i) {
            int themeAttrColor = ThemeUtils.getThemeAttrColor(context, R.attr.colorControlHighlight);
            return new ColorStateList(new int[][]{ThemeUtils.DISABLED_STATE_SET, ThemeUtils.PRESSED_STATE_SET, ThemeUtils.FOCUSED_STATE_SET, ThemeUtils.EMPTY_STATE_SET}, new int[]{ThemeUtils.getDisabledThemeAttrColor(context, R.attr.colorButtonNormal), ColorUtils.compositeColors(themeAttrColor, i), ColorUtils.compositeColors(themeAttrColor, i), i});
        }

        public static LayerDrawable getRatingBarLayerDrawable(ResourceManagerInternal resourceManagerInternal, Context context, int i) {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i);
            Drawable drawable = resourceManagerInternal.getDrawable(context, R.drawable.abc_star_black_48dp);
            Drawable drawable2 = resourceManagerInternal.getDrawable(context, R.drawable.abc_star_half_black_48dp);
            if ((drawable instanceof BitmapDrawable) && drawable.getIntrinsicWidth() == dimensionPixelSize && drawable.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable = (BitmapDrawable) drawable;
                bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
            } else {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawable.draw(canvas);
                bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
                bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap);
            }
            bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
            if ((drawable2 instanceof BitmapDrawable) && drawable2.getIntrinsicWidth() == dimensionPixelSize && drawable2.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (BitmapDrawable) drawable2;
            } else {
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
                drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawable2.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(bitmapCreateBitmap2);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
            layerDrawable.setId(0, android.R.id.background);
            layerDrawable.setId(1, android.R.id.secondaryProgress);
            layerDrawable.setId(2, android.R.id.progress);
            return layerDrawable;
        }

        public static void setPorterDuffColorFilter(Drawable drawable, int i, PorterDuff.Mode mode) {
            Drawable drawableMutate = drawable.mutate();
            if (mode == null) {
                mode = AppCompatDrawableManager.DEFAULT_MODE;
            }
            drawableMutate.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(i, mode));
        }

        public void addMetadata(String str, String str2) {
            HashMap map = (HashMap) this.listener;
            if (map == null) {
                throw new IllegalStateException("Property \"autoMetadata\" has not been set");
            }
            map.put(str, str2);
        }

        public AutoValue_EventInternal build() {
            String strM = ((String) this.connectionName) == null ? " transportName" : "";
            if (((EncodedPayload) this.socket) == null) {
                strM = strM.concat(" encodedPayload");
            }
            if (((Long) this.source) == null) {
                strM = ImageAnalysis$$ExternalSyntheticLambda1.m(strM, " eventMillis");
            }
            if (((Long) this.sink) == null) {
                strM = ImageAnalysis$$ExternalSyntheticLambda1.m(strM, " uptimeMillis");
            }
            if (((HashMap) this.listener) == null) {
                strM = ImageAnalysis$$ExternalSyntheticLambda1.m(strM, " autoMetadata");
            }
            if (strM.isEmpty()) {
                return new AutoValue_EventInternal((String) this.connectionName, (Integer) this.taskRunner, (EncodedPayload) this.socket, ((Long) this.source).longValue(), ((Long) this.sink).longValue(), (HashMap) this.listener);
            }
            throw new IllegalStateException("Missing required properties:".concat(strM));
        }

        public SessionConfig createSessionConfig() {
            SurfaceTexture surfaceTexture = new SurfaceTexture(0);
            Size size = (Size) this.source;
            surfaceTexture.setDefaultBufferSize(size.getWidth(), size.getHeight());
            Surface surface = new Surface(surfaceTexture);
            SessionConfig.Builder builderCreateFrom = SessionConfig.Builder.createFrom((MeteringRepeatingSession$MeteringRepeatingConfig) this.connectionName, size);
            builderCreateFrom.mCaptureConfigBuilder.index = 1;
            SurfaceRequest.AnonymousClass2 anonymousClass2 = new SurfaceRequest.AnonymousClass2(surface);
            this.taskRunner = anonymousClass2;
            ListenableFuture listenableFutureNonCancellationPropagating = Futures.nonCancellationPropagating(anonymousClass2.mTerminationFuture);
            SurfaceRequest.AnonymousClass1 anonymousClass1 = new SurfaceRequest.AnonymousClass1(6, surface, surfaceTexture, false);
            listenableFutureNonCancellationPropagating.addListener(new zzi(1, listenableFutureNonCancellationPropagating, anonymousClass1), HexFormatKt.directExecutor());
            builderCreateFrom.addSurface((SurfaceRequest.AnonymousClass2) this.taskRunner, DynamicRange.SDR, -1);
            SessionConfig.CloseableErrorListener closeableErrorListener = (SessionConfig.CloseableErrorListener) this.listener;
            if (closeableErrorListener != null) {
                closeableErrorListener.close();
            }
            SessionConfig.CloseableErrorListener closeableErrorListener2 = new SessionConfig.CloseableErrorListener(new Preview$$ExternalSyntheticLambda2(1, this));
            this.listener = closeableErrorListener2;
            builderCreateFrom.mErrorListener = closeableErrorListener2;
            return builderCreateFrom.build();
        }

        public void forceFinishCloseStaleSessions(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl) {
            ArrayList sessionsInOrder = getSessionsInOrder();
            int size = sessionsInOrder.size();
            int i = 0;
            while (i < size) {
                Object obj = sessionsInOrder.get(i);
                i++;
                SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl2 = (SynchronizedCaptureSessionImpl) obj;
                if (synchronizedCaptureSessionImpl2 == synchronizedCaptureSessionImpl) {
                    return;
                }
                synchronizedCaptureSessionImpl2.releaseDeferrableSurfaces();
                synchronizedCaptureSessionImpl2.mRequestMonitor.stop();
            }
        }

        @Override // javax.inject.Provider
        public Object get() {
            return new TooltipPopup((Context) ((Provider) this.taskRunner).get(), (MetadataBackendRegistry) ((Provider) this.socket).get(), (EventStore) ((Provider) this.connectionName).get(), (ImageLoader$Builder) ((ImageLoader$Builder) this.source).get(), (Executor) ((Provider) this.sink).get(), (SynchronizationGuard) ((Provider) this.listener).get(), new ByteString.Companion(15));
        }

        public ArrayList getCaptureSessions() {
            ArrayList arrayList;
            synchronized (this.socket) {
                arrayList = new ArrayList((LinkedHashSet) this.connectionName);
            }
            return arrayList;
        }

        public ArrayList getCreatingCaptureSessions() {
            ArrayList arrayList;
            synchronized (this.socket) {
                arrayList = new ArrayList((LinkedHashSet) this.sink);
            }
            return arrayList;
        }

        public ArrayList getSessionsInOrder() {
            ArrayList arrayList;
            synchronized (this.socket) {
                arrayList = new ArrayList();
                arrayList.addAll(getCaptureSessions());
                arrayList.addAll(getCreatingCaptureSessions());
            }
            return arrayList;
        }

        public ColorStateList getTintListForDrawableRes(Context context, int i) {
            if (i == R.drawable.abc_edit_text_material) {
                return AbstractList.Companion.getColorStateList(context, R.color.abc_tint_edittext);
            }
            if (i == R.drawable.abc_switch_track_mtrl_alpha) {
                return AbstractList.Companion.getColorStateList(context, R.color.abc_tint_switch_track);
            }
            if (i != R.drawable.abc_switch_thumb_material) {
                if (i == R.drawable.abc_btn_default_mtrl_shape) {
                    return createButtonColorStateList(context, ThemeUtils.getThemeAttrColor(context, R.attr.colorButtonNormal));
                }
                if (i == R.drawable.abc_btn_borderless_material) {
                    return createButtonColorStateList(context, 0);
                }
                if (i == R.drawable.abc_btn_colored_material) {
                    return createButtonColorStateList(context, ThemeUtils.getThemeAttrColor(context, R.attr.colorAccent));
                }
                if (i == R.drawable.abc_spinner_mtrl_am_alpha || i == R.drawable.abc_spinner_textfield_background_material) {
                    return AbstractList.Companion.getColorStateList(context, R.color.abc_tint_spinner);
                }
                if (arrayContains((int[]) this.socket, i)) {
                    return ThemeUtils.getThemeAttrColorStateList(context, R.attr.colorControlNormal);
                }
                if (arrayContains((int[]) this.sink, i)) {
                    return AbstractList.Companion.getColorStateList(context, R.color.abc_tint_default);
                }
                if (arrayContains((int[]) this.listener, i)) {
                    return AbstractList.Companion.getColorStateList(context, R.color.abc_tint_btn_checkable);
                }
                if (i == R.drawable.abc_seekbar_thumb_material) {
                    return AbstractList.Companion.getColorStateList(context, R.color.abc_tint_seek_thumb);
                }
                return null;
            }
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            ColorStateList themeAttrColorStateList = ThemeUtils.getThemeAttrColorStateList(context, R.attr.colorSwitchThumbNormal);
            if (themeAttrColorStateList == null || !themeAttrColorStateList.isStateful()) {
                iArr[0] = ThemeUtils.DISABLED_STATE_SET;
                iArr2[0] = ThemeUtils.getDisabledThemeAttrColor(context, R.attr.colorSwitchThumbNormal);
                iArr[1] = ThemeUtils.CHECKED_STATE_SET;
                iArr2[1] = ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated);
                iArr[2] = ThemeUtils.EMPTY_STATE_SET;
                iArr2[2] = ThemeUtils.getThemeAttrColor(context, R.attr.colorSwitchThumbNormal);
            } else {
                int[] iArr3 = ThemeUtils.DISABLED_STATE_SET;
                iArr[0] = iArr3;
                iArr2[0] = themeAttrColorStateList.getColorForState(iArr3, 0);
                iArr[1] = ThemeUtils.CHECKED_STATE_SET;
                iArr2[1] = ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated);
                iArr[2] = ThemeUtils.EMPTY_STATE_SET;
                iArr2[2] = themeAttrColorStateList.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }

        public void onCreateCaptureSession(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl) {
            synchronized (this.socket) {
                ((LinkedHashSet) this.sink).add(synchronizedCaptureSessionImpl);
            }
        }

        public Builder(String str, String str2, Set set) {
            Set setUnmodifiableSet = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
            this.taskRunner = setUnmodifiableSet;
            Map map = Collections.EMPTY_MAP;
            this.connectionName = str;
            this.source = str2;
            this.sink = SignInOptions.zaa;
            HashSet hashSet = new HashSet(setUnmodifiableSet);
            Iterator it = map.values().iterator();
            if (it.hasNext()) {
                it.next().getClass();
                throw new ClassCastException();
            }
            this.socket = Collections.unmodifiableSet(hashSet);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class ReaderRunnable implements Function0 {
        public final /* synthetic */ int $r8$classId;
        public final Object reader;
        public final /* synthetic */ Object this$0;

        public /* synthetic */ ReaderRunnable(int i, Object obj, Object obj2) {
            this.$r8$classId = i;
            this.reader = obj;
            this.this$0 = obj2;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            switch (this.$r8$classId) {
                case 0:
                    Http2Connection http2Connection = (Http2Connection) this.this$0;
                    Http2Reader http2Reader = (Http2Reader) this.reader;
                    try {
                        if (!http2Reader.nextFrame(true, this)) {
                            throw new IOException("Required SETTINGS preface not received");
                        }
                        while (http2Reader.nextFrame(false, this)) {
                        }
                        http2Connection.close$okhttp(1, 9, null);
                        Util.closeQuietly(http2Reader);
                        return Unit.INSTANCE;
                    } catch (IOException e) {
                        http2Connection.close$okhttp(2, 2, e);
                    } catch (Throwable th) {
                        http2Connection.close$okhttp(3, 3, null);
                        Util.closeQuietly(http2Reader);
                        throw th;
                    }
                    break;
                case 1:
                    ((Function1) this.reader).invoke(new FileAction.Open((File) this.this$0));
                    return Unit.INSTANCE;
                case 2:
                    ((MutableState) this.this$0).setValue((File) this.reader);
                    return Unit.INSTANCE;
                case 3:
                    ((Function1) this.reader).invoke((LogMessage) this.this$0);
                    return Unit.INSTANCE;
                case 4:
                    ((Function1) this.reader).invoke(((ProviderItemState) this.this$0).provider);
                    return Unit.INSTANCE;
                case 5:
                    ((Function1) this.reader).invoke(((ProcessGroup) this.this$0).process);
                    return Unit.INSTANCE;
                case 6:
                    ((MutableState) this.this$0).setValue((Profile) this.reader);
                    return Unit.INSTANCE;
                case 7:
                    ((Function1) this.reader).invoke((String) this.this$0);
                    return Unit.INSTANCE;
                case 8:
                    ((Function1) this.reader).invoke(((Proxy) this.this$0).name);
                    return Unit.INSTANCE;
                default:
                    ((Function1) this.reader).invoke(((AppInfo) this.this$0).packageName);
                    return Unit.INSTANCE;
            }
        }

        public ReaderRunnable(Http2Connection http2Connection, Http2Reader http2Reader) {
            this.$r8$classId = 0;
            this.this$0 = http2Connection;
            this.reader = http2Reader;
        }
    }

    static {
        Settings settings = new Settings();
        settings.set(7, 65535);
        settings.set(5, 16384);
        DEFAULT_SETTINGS = settings;
    }

    public Http2Connection(Builder builder) {
        this.listener = (Listener) builder.listener;
        String str = (String) builder.connectionName;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("connectionName");
            throw null;
        }
        this.connectionName = str;
        this.nextStreamId = 3;
        TaskRunner taskRunner = (TaskRunner) builder.taskRunner;
        this.taskRunner = taskRunner;
        this.writerQueue = taskRunner.newQueue();
        this.pushQueue = taskRunner.newQueue();
        this.settingsListenerQueue = taskRunner.newQueue();
        this.pushObserver = PushObserver$Companion$PushObserverCancel.CANCEL;
        Settings settings = new Settings();
        settings.set(7, 16777216);
        this.okHttpSettings = settings;
        Settings settings2 = DEFAULT_SETTINGS;
        this.peerSettings = settings2;
        this.writeBytesMaximum = settings2.getInitialWindowSize();
        Socket socket = (Socket) builder.socket;
        if (socket == null) {
            Intrinsics.throwUninitializedPropertyAccessException("socket");
            throw null;
        }
        this.socket = socket;
        RealBufferedSink realBufferedSink = (RealBufferedSink) builder.sink;
        if (realBufferedSink == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sink");
            throw null;
        }
        this.writer = new Http2Writer(realBufferedSink);
        RealBufferedSource realBufferedSource = (RealBufferedSource) builder.source;
        if (realBufferedSource == null) {
            Intrinsics.throwUninitializedPropertyAccessException("source");
            throw null;
        }
        this.readerRunnable = new ReaderRunnable(this, new Http2Reader(realBufferedSource));
        this.currentPushRequests = new LinkedHashSet();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        close$okhttp(1, 9, null);
    }

    public final void close$okhttp(int i, int i2, IOException iOException) {
        int i3;
        Object[] array;
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        try {
            shutdown(i);
        } catch (IOException unused) {
        }
        synchronized (this) {
            try {
                if (this.streams.isEmpty()) {
                    array = null;
                } else {
                    array = this.streams.values().toArray(new Http2Stream[0]);
                    this.streams.clear();
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        Http2Stream[] http2StreamArr = (Http2Stream[]) array;
        if (http2StreamArr != null) {
            for (Http2Stream http2Stream : http2StreamArr) {
                try {
                    http2Stream.close(i2, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.writer.close();
        } catch (IOException unused3) {
        }
        try {
            this.socket.close();
        } catch (IOException unused4) {
        }
        this.writerQueue.shutdown();
        this.pushQueue.shutdown();
        this.settingsListenerQueue.shutdown();
    }

    public final void flush() {
        this.writer.flush();
    }

    public final synchronized Http2Stream getStream(int i) {
        return (Http2Stream) this.streams.get(Integer.valueOf(i));
    }

    public final synchronized boolean isHealthy(long j) {
        if (this.isShutdown) {
            return false;
        }
        return this.degradedPongsReceived >= this.degradedPingsSent || j < this.degradedPongDeadlineNs;
    }

    public final synchronized Http2Stream removeStream$okhttp(int i) {
        Http2Stream http2Stream;
        http2Stream = (Http2Stream) this.streams.remove(Integer.valueOf(i));
        notifyAll();
        return http2Stream;
    }

    public final void shutdown(int i) {
        synchronized (this.writer) {
            synchronized (this) {
                if (this.isShutdown) {
                    return;
                }
                this.isShutdown = true;
                int i2 = this.lastGoodStreamId;
                Unit unit = Unit.INSTANCE;
                this.writer.goAway(Util.EMPTY_BYTE_ARRAY, i2, i);
            }
        }
    }

    public final synchronized void updateConnectionFlowControl$okhttp(long j) {
        long j2 = this.readBytesTotal + j;
        this.readBytesTotal = j2;
        long j3 = j2 - this.readBytesAcknowledged;
        if (j3 >= this.okHttpSettings.getInitialWindowSize() / 2) {
            writeWindowUpdateLater$okhttp(0, j3);
            this.readBytesAcknowledged += j3;
        }
    }

    public final void writeData(int i, boolean z, Buffer buffer, long j) {
        long j2;
        long j3;
        int iMin;
        long j4;
        if (j == 0) {
            this.writer.data(z, i, buffer, 0);
            return;
        }
        while (j > 0) {
            synchronized (this) {
                while (true) {
                    try {
                        try {
                            j2 = this.writeBytesTotal;
                            j3 = this.writeBytesMaximum;
                            if (j2 >= j3) {
                                if (!this.streams.containsKey(Integer.valueOf(i))) {
                                    throw new IOException("stream closed");
                                }
                                wait();
                            }
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            throw new InterruptedIOException();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                iMin = Math.min((int) Math.min(j, j3 - j2), this.writer.maxFrameSize);
                j4 = iMin;
                this.writeBytesTotal += j4;
                Unit unit = Unit.INSTANCE;
            }
            j -= j4;
            this.writer.data(z && j == 0, i, buffer, iMin);
        }
    }

    public final void writeSynResetLater$okhttp(int i, int i2) {
        this.writerQueue.schedule(new Http2Connection$writeSynResetLater$$inlined$execute$default$1(this.connectionName + '[' + i + "] writeSynReset", this, i, i2, 0), 0L);
    }

    public final void writeWindowUpdateLater$okhttp(final int i, final long j) {
        final String str = this.connectionName + '[' + i + "] windowUpdate";
        this.writerQueue.schedule(new Task(str) { // from class: okhttp3.internal.http2.Http2Connection$writeWindowUpdateLater$$inlined$execute$default$1
            @Override // okhttp3.internal.concurrent.Task
            public final long runOnce() {
                Http2Connection http2Connection = this;
                try {
                    http2Connection.writer.windowUpdate(i, j);
                    return -1L;
                } catch (IOException e) {
                    http2Connection.close$okhttp(2, 2, e);
                    return -1L;
                }
            }
        }, 0L);
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class Listener {
        public static final Http2Connection$Listener$Companion$REFUSE_INCOMING_STREAMS$1 REFUSE_INCOMING_STREAMS = new Http2Connection$Listener$Companion$REFUSE_INCOMING_STREAMS$1();

        public abstract void onStream(Http2Stream http2Stream);

        public void onSettings(Settings settings) {
        }
    }
}
