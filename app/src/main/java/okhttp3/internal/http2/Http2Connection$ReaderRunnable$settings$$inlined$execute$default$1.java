package okhttp3.internal.http2;

import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.internal.Ref$ObjectRef;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.platform.Platform;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Http2Connection$ReaderRunnable$settings$$inlined$execute$default$1 extends Task {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object $settings$inlined;
    public final /* synthetic */ Object this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Http2Connection$ReaderRunnable$settings$$inlined$execute$default$1(String str, Object obj, Object obj2, int i) {
        super(str, true);
        this.$r8$classId = i;
        this.this$0 = obj;
        this.$settings$inlined = obj2;
    }

    @Override // okhttp3.internal.concurrent.Task
    public final long runOnce() {
        long initialWindowSize;
        Http2Stream[] http2StreamArr;
        switch (this.$r8$classId) {
            case 0:
                Http2Connection.ReaderRunnable readerRunnable = (Http2Connection.ReaderRunnable) this.this$0;
                Settings settings = (Settings) this.$settings$inlined;
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                Http2Connection http2Connection = (Http2Connection) readerRunnable.this$0;
                synchronized (http2Connection.writer) {
                    synchronized (http2Connection) {
                        try {
                            Settings settings2 = http2Connection.peerSettings;
                            Settings settings3 = new Settings();
                            int i = 0;
                            while (true) {
                                int i2 = 1;
                                if (i < 10) {
                                    if (((1 << i) & settings2.set) != 0) {
                                        settings3.set(i, settings2.values[i]);
                                    }
                                    i++;
                                } else {
                                    for (int i3 = 0; i3 < 10; i3++) {
                                        if (((1 << i3) & settings.set) != 0) {
                                            settings3.set(i3, settings.values[i3]);
                                        }
                                    }
                                    ref$ObjectRef.element = settings3;
                                    initialWindowSize = ((long) settings3.getInitialWindowSize()) - ((long) settings2.getInitialWindowSize());
                                    http2StreamArr = (initialWindowSize == 0 || http2Connection.streams.isEmpty()) ? null : (Http2Stream[]) http2Connection.streams.values().toArray(new Http2Stream[0]);
                                    http2Connection.peerSettings = (Settings) ref$ObjectRef.element;
                                    http2Connection.settingsListenerQueue.schedule(new Http2Connection$ReaderRunnable$settings$$inlined$execute$default$1(http2Connection.connectionName + " onSettings", http2Connection, ref$ObjectRef, i2), 0L);
                                    Unit unit = Unit.INSTANCE;
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    try {
                        http2Connection.writer.applyAndAckSettings((Settings) ref$ObjectRef.element);
                    } catch (IOException e) {
                        http2Connection.close$okhttp(2, 2, e);
                    }
                    Unit unit2 = Unit.INSTANCE;
                    break;
                }
                if (http2StreamArr != null) {
                    for (Http2Stream http2Stream : http2StreamArr) {
                        synchronized (http2Stream) {
                            http2Stream.writeBytesMaximum += initialWindowSize;
                            if (initialWindowSize > 0) {
                                http2Stream.notifyAll();
                            }
                            Unit unit3 = Unit.INSTANCE;
                        }
                    }
                }
                return -1L;
            case 1:
                ((Http2Connection) this.this$0).listener.onSettings((Settings) ((Ref$ObjectRef) this.$settings$inlined).element);
                return -1L;
            default:
                try {
                    ((Http2Connection) this.this$0).listener.onStream((Http2Stream) this.$settings$inlined);
                    break;
                } catch (IOException e2) {
                    Platform platform = Platform.platform;
                    Platform platform2 = Platform.platform;
                    String str = "Http2Connection.Listener failure for " + ((Http2Connection) this.this$0).connectionName;
                    platform2.getClass();
                    Platform.log(str, 4, e2);
                    try {
                        ((Http2Stream) this.$settings$inlined).close(2, e2);
                        break;
                    } catch (IOException unused) {
                    }
                }
                return -1L;
        }
    }
}
