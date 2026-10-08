package okhttp3.internal.http1;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.geometry.Offset;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import com.google.android.gms.tasks.OnFailureListener;
import fi.iki.elonen.NanoHTTPD;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.internal.cache.CacheStrategy;
import okio.BufferedSource;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class HeadersReader implements SQLiteEventStore.Function, OnFailureListener {
    public final /* synthetic */ int $r8$classId;
    public long headerLimit;
    public Object source;

    public HeadersReader(long j, AutoValue_TransportContext autoValue_TransportContext) {
        this.$r8$classId = 3;
        this.headerLimit = j;
        this.source = autoValue_TransportContext;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        long j = this.headerLimit;
        AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) this.source;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        Encoding encoding = SQLiteEventStore.PROTOBUF_ENCODING;
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j));
        String str = autoValue_TransportContext.backendName;
        Priority priority = autoValue_TransportContext.priority;
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{str, String.valueOf(PriorityMapping.toInt(priority))}) < 1) {
            contentValues.put("backend_name", autoValue_TransportContext.backendName);
            contentValues.put("priority", Integer.valueOf(PriorityMapping.toInt(priority)));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }

    public void clear(int i) {
        if (i < 64) {
            this.headerLimit &= ~(1 << i);
            return;
        }
        HeadersReader headersReader = (HeadersReader) this.source;
        if (headersReader != null) {
            headersReader.clear(i - 64);
        }
    }

    public int countOnesBefore(int i) {
        HeadersReader headersReader = (HeadersReader) this.source;
        if (headersReader == null) {
            return i >= 64 ? Long.bitCount(this.headerLimit) : Long.bitCount(this.headerLimit & ((1 << i) - 1));
        }
        if (i < 64) {
            return Long.bitCount(this.headerLimit & ((1 << i) - 1));
        }
        return Long.bitCount(this.headerLimit) + headersReader.countOnesBefore(i - 64);
    }

    public void ensureNext() {
        if (((HeadersReader) this.source) == null) {
            this.source = new HeadersReader(2);
        }
    }

    public void exec(NanoHTTPD.ClientHandler clientHandler) {
        this.headerLimit++;
        Thread thread = new Thread(clientHandler);
        thread.setDaemon(true);
        thread.setName("NanoHttpd Request Processor (#" + this.headerLimit + ")");
        ((List) this.source).add(clientHandler);
        thread.start();
    }

    public boolean get(int i) {
        if (i < 64) {
            return (this.headerLimit & (1 << i)) != 0;
        }
        ensureNext();
        return ((HeadersReader) this.source).get(i - 64);
    }

    /* JADX INFO: renamed from: getPostSlopOffset-qto3Fdw, reason: not valid java name */
    public long m852getPostSlopOffsetqto3Fdw(long j, float f, boolean z) {
        long jM373plusMKHz9U;
        if (z) {
            jM373plusMKHz9U = Offset.m373plusMKHz9U(this.headerLimit, j);
            this.headerLimit = jM373plusMKHz9U;
        } else {
            jM373plusMKHz9U = Offset.m373plusMKHz9U(this.headerLimit, j);
        }
        if ((((Orientation) this.source) == null ? Offset.m370getDistanceimpl(jM373plusMKHz9U) : Math.abs(m853mainAxisk4lQ0M(jM373plusMKHz9U))) < f) {
            return 9205357640488583168L;
        }
        if (((Orientation) this.source) == null) {
            long j2 = this.headerLimit;
            float fM370getDistanceimpl = Offset.m370getDistanceimpl(j2);
            return Offset.m372minusMKHz9U(this.headerLimit, Offset.m374timestuRUvjQ(f, (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j2 >> 32)) / fM370getDistanceimpl)) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j2 & 4294967295L)) / fM370getDistanceimpl)))));
        }
        float fM853mainAxisk4lQ0M = m853mainAxisk4lQ0M(this.headerLimit) - (Math.signum(m853mainAxisk4lQ0M(this.headerLimit)) * f);
        long j3 = this.headerLimit;
        Orientation orientation = (Orientation) this.source;
        Orientation orientation2 = Orientation.Horizontal;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (orientation == orientation2 ? j3 & 4294967295L : j3 >> 32));
        if (((Orientation) this.source) == orientation2) {
            return (((long) Float.floatToRawIntBits(fM853mainAxisk4lQ0M)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) & 4294967295L);
        }
        return (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fM853mainAxisk4lQ0M)) & 4294967295L);
    }

    public void insert(int i, boolean z) {
        if (i >= 64) {
            ensureNext();
            ((HeadersReader) this.source).insert(i - 64, z);
            return;
        }
        long j = this.headerLimit;
        boolean z2 = (Long.MIN_VALUE & j) != 0;
        long j2 = (1 << i) - 1;
        this.headerLimit = ((j & (~j2)) << 1) | (j & j2);
        if (z) {
            set(i);
        } else {
            clear(i);
        }
        if (z2 || ((HeadersReader) this.source) != null) {
            ensureNext();
            ((HeadersReader) this.source).insert(0, z2);
        }
    }

    /* JADX INFO: renamed from: mainAxis-k-4lQ0M, reason: not valid java name */
    public float m853mainAxisk4lQ0M(long j) {
        return Float.intBitsToFloat((int) (((Orientation) this.source) == Orientation.Horizontal ? j >> 32 : j & 4294967295L));
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        CacheStrategy cacheStrategy = (CacheStrategy) this.source;
        ((AtomicLong) cacheStrategy.cacheResponse).set(this.headerLimit);
    }

    public Headers readHeaders() {
        ArrayList arrayList = new ArrayList(20);
        while (true) {
            String utf8LineStrict = ((BufferedSource) this.source).readUtf8LineStrict(this.headerLimit);
            this.headerLimit -= (long) utf8LineStrict.length();
            if (utf8LineStrict.length() == 0) {
                return new Headers((String[]) arrayList.toArray(new String[0]));
            }
            int iIndexOf$default = StringsKt.indexOf$default(utf8LineStrict, ':', 1, 4);
            if (iIndexOf$default != -1) {
                String strSubstring = utf8LineStrict.substring(0, iIndexOf$default);
                String strSubstring2 = utf8LineStrict.substring(iIndexOf$default + 1);
                arrayList.add(strSubstring);
                arrayList.add(StringsKt.trim(strSubstring2).toString());
            } else if (utf8LineStrict.charAt(0) == ':') {
                String strSubstring3 = utf8LineStrict.substring(1);
                arrayList.add("");
                arrayList.add(StringsKt.trim(strSubstring3).toString());
            } else {
                arrayList.add("");
                arrayList.add(StringsKt.trim(utf8LineStrict).toString());
            }
        }
    }

    public boolean remove(int i) {
        if (i >= 64) {
            ensureNext();
            return ((HeadersReader) this.source).remove(i - 64);
        }
        long j = 1 << i;
        long j2 = this.headerLimit;
        boolean z = (j2 & j) != 0;
        long j3 = j2 & (~j);
        this.headerLimit = j3;
        long j4 = j - 1;
        this.headerLimit = (j3 & j4) | Long.rotateRight((~j4) & j3, 1);
        HeadersReader headersReader = (HeadersReader) this.source;
        if (headersReader != null) {
            if (headersReader.get(0)) {
                set(63);
            }
            ((HeadersReader) this.source).remove(0);
        }
        return z;
    }

    public void reset() {
        this.headerLimit = 0L;
        HeadersReader headersReader = (HeadersReader) this.source;
        if (headersReader != null) {
            headersReader.reset();
        }
    }

    public void set(int i) {
        if (i < 64) {
            this.headerLimit |= 1 << i;
        } else {
            ensureNext();
            ((HeadersReader) this.source).set(i - 64);
        }
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 2:
                if (((HeadersReader) this.source) == null) {
                    return Long.toBinaryString(this.headerLimit);
                }
                return ((HeadersReader) this.source).toString() + "xx" + Long.toBinaryString(this.headerLimit);
            default:
                return super.toString();
        }
    }

    public /* synthetic */ HeadersReader(Object obj, long j, int i) {
        this.$r8$classId = i;
        this.source = obj;
        this.headerLimit = j;
    }

    public HeadersReader(BufferedSource bufferedSource) {
        this.$r8$classId = 0;
        this.source = bufferedSource;
        this.headerLimit = 262144L;
    }

    public HeadersReader(int i) {
        this.$r8$classId = i;
        switch (i) {
            case 5:
                this.source = Collections.synchronizedList(new ArrayList());
                break;
            default:
                this.headerLimit = 0L;
                break;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HeadersReader(Orientation orientation, int i) {
        this((i & 1) != 0 ? null : orientation, 0L, 1);
        this.$r8$classId = 1;
    }
}
