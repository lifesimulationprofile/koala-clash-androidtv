package coil;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Paint;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.net.Uri;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.text.Editable;
import android.text.Selection;
import android.text.TextPaint;
import android.util.Base64;
import android.util.Log;
import android.util.SparseArray;
import android.view.Choreographer;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.TooltipPopup;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.collection.SimpleArrayMap;
import androidx.compose.animation.FlingCalculator;
import androidx.compose.ui.node.RulerTrackingMap;
import androidx.core.graphics.PaintCompat;
import androidx.core.view.ViewCompat;
import androidx.emoji2.text.DefaultGlyphChecker;
import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.EmojiProcessor$EmojiProcessCallback;
import androidx.emoji2.text.EmojiProcessor$MarkExclusionCallback;
import androidx.emoji2.text.EmojiProcessor$ProcessorSm;
import androidx.emoji2.text.MetadataRepo$Node;
import androidx.emoji2.text.TypefaceEmojiRasterizer;
import androidx.emoji2.text.TypefaceEmojiSpan;
import androidx.emoji2.text.flatbuffer.MetadataItem;
import androidx.recyclerview.widget.RecyclerView;
import coil.ImageLoader$Builder;
import coil.memory.MemoryCacheService;
import coil.network.NetworkObserver;
import coil.network.RealNetworkObserver$networkCallback$1;
import coil.util.Requests;
import coil.util.SingletonDiskCache;
import coil.util.SystemCallbacks;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.TransportImpl;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig_ConfigValue;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig$Flag;
import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_EventStoreConfig;
import com.google.android.datatransport.runtime.scheduling.persistence.AutoValue_PersistedEvent;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.util.PriorityMapping;
import com.google.android.gms.dynamite.zze;
import com.google.android.gms.internal.mlkit_vision_common.zzaj;
import com.google.android.gms.internal.mlkit_vision_common.zzkl;
import com.google.android.gms.internal.mlkit_vision_common.zzln;
import com.google.android.material.R$styleable;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.resources.MaterialResources;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;
import com.google.zxing.qrcode.encoder.Encoder;
import com.google.zxing.qrcode.encoder.MinimalEncoder;
import com.google.zxing.qrcode.encoder.MinimalEncoder$ResultList$ResultNode;
import com.koala.clash.R;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.zip.Adler32;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Dispatcher;
import okhttp3.Request;
import okhttp3.internal.http1.HeadersReader;
import okhttp3.internal.http2.Http2Connection;
import okio.AsyncTimeout;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ImageLoader$Builder implements NetworkObserver, Factory, SynchronizationGuard.CriticalSection, SQLiteEventStore.Function, EncoderConfig {
    public final /* synthetic */ int $r8$classId;
    public Object applicationContext;
    public Object defaults;
    public Object options;

    public /* synthetic */ ImageLoader$Builder(int i) {
        this.$r8$classId = i;
    }

    public static final void access$onConnectivityChange(ImageLoader$Builder imageLoader$Builder, Network network, boolean z) {
        boolean z2;
        boolean z3 = false;
        for (Network network2 : ((ConnectivityManager) imageLoader$Builder.applicationContext).getAllNetworks()) {
            if (Intrinsics.areEqual(network2, network)) {
                z2 = z;
            } else {
                NetworkCapabilities networkCapabilities = ((ConnectivityManager) imageLoader$Builder.applicationContext).getNetworkCapabilities(network2);
                z2 = networkCapabilities != null && networkCapabilities.hasCapability(12);
            }
            if (z2) {
                z3 = true;
                break;
            }
        }
        SystemCallbacks systemCallbacks = (SystemCallbacks) imageLoader$Builder.defaults;
        synchronized (systemCallbacks) {
            try {
                if (((RealImageLoader) systemCallbacks.imageLoader.get()) != null) {
                    systemCallbacks._isOnline = z3;
                } else {
                    systemCallbacks.shutdown();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean delete(Editable editable, KeyEvent keyEvent, boolean z) {
        TypefaceEmojiSpan[] typefaceEmojiSpanArr;
        if (KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (selectionStart != -1 && selectionEnd != -1 && selectionStart == selectionEnd && (typefaceEmojiSpanArr = (TypefaceEmojiSpan[]) editable.getSpans(selectionStart, selectionEnd, TypefaceEmojiSpan.class)) != null && typefaceEmojiSpanArr.length > 0) {
                for (TypefaceEmojiSpan typefaceEmojiSpan : typefaceEmojiSpanArr) {
                    int spanStart = editable.getSpanStart(typefaceEmojiSpan);
                    int spanEnd = editable.getSpanEnd(typefaceEmojiSpan);
                    if ((z && spanStart == selectionStart) || ((!z && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                        editable.delete(spanStart, spanEnd);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void addView(View view, int i, boolean z) {
        RecyclerView recyclerView = RecyclerView.this;
        int childCount = i < 0 ? recyclerView.getChildCount() : getOffset(i);
        ((HeadersReader) this.defaults).insert(childCount, z);
        if (z) {
            hideViewInternal(view);
        }
        recyclerView.addView(view, childCount);
        RecyclerView.getChildViewHolderInt(view);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore.Function
    public Object apply(Object obj) {
        String str;
        int i;
        long jInsert;
        String str2 = "bytes";
        int i2 = 0;
        Object obj2 = null;
        int i3 = 1;
        switch (this.$r8$classId) {
            case 15:
                SQLiteEventStore sQLiteEventStore = (SQLiteEventStore) this.applicationContext;
                ArrayList arrayList = (ArrayList) this.defaults;
                AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) this.options;
                Cursor cursor = (Cursor) obj;
                Encoding encoding = SQLiteEventStore.PROTOBUF_ENCODING;
                while (cursor.moveToNext()) {
                    long j = cursor.getLong(i2);
                    int i4 = cursor.getInt(7) != 0 ? i3 : i2;
                    Http2Connection.Builder builder = new Http2Connection.Builder();
                    builder.listener = new HashMap();
                    String string = cursor.getString(i3);
                    if (string == null) {
                        throw new NullPointerException("Null transportName");
                    }
                    builder.connectionName = string;
                    builder.source = Long.valueOf(cursor.getLong(2));
                    builder.sink = Long.valueOf(cursor.getLong(3));
                    if (i4 != 0) {
                        String string2 = cursor.getString(4);
                        builder.socket = new EncodedPayload(string2 == null ? SQLiteEventStore.PROTOBUF_ENCODING : new Encoding(string2), cursor.getBlob(5));
                        str = str2;
                        i = i2;
                    } else {
                        String string3 = cursor.getString(4);
                        Encoding encoding2 = string3 == null ? SQLiteEventStore.PROTOBUF_ENCODING : new Encoding(string3);
                        Cursor cursorQuery = sQLiteEventStore.getDb().query("event_payloads", new String[]{str2}, "event_id = ?", new String[]{String.valueOf(j)}, null, null, "sequence_num");
                        try {
                            Encoding encoding3 = SQLiteEventStore.PROTOBUF_ENCODING;
                            ArrayList arrayList2 = new ArrayList();
                            int length = i2;
                            while (cursorQuery.moveToNext()) {
                                byte[] blob = cursorQuery.getBlob(i2);
                                arrayList2.add(blob);
                                length += blob.length;
                            }
                            byte[] bArr = new byte[length];
                            int length2 = i2;
                            int i5 = length2;
                            while (i5 < arrayList2.size()) {
                                byte[] bArr2 = (byte[]) arrayList2.get(i5);
                                String str3 = str2;
                                System.arraycopy(bArr2, 0, bArr, length2, bArr2.length);
                                length2 += bArr2.length;
                                i5++;
                                str2 = str3;
                            }
                            str = str2;
                            i = 0;
                            cursorQuery.close();
                            builder.socket = new EncodedPayload(encoding2, bArr);
                        } catch (Throwable th) {
                            cursorQuery.close();
                            throw th;
                        }
                    }
                    if (!cursor.isNull(6)) {
                        builder.taskRunner = Integer.valueOf(cursor.getInt(6));
                    }
                    arrayList.add(new AutoValue_PersistedEvent(j, autoValue_TransportContext, builder.build()));
                    i2 = i;
                    obj2 = obj2;
                    sQLiteEventStore = sQLiteEventStore;
                    str2 = str;
                    i3 = 1;
                }
                return obj2;
            default:
                SQLiteEventStore sQLiteEventStore2 = (SQLiteEventStore) this.applicationContext;
                AutoValue_TransportContext autoValue_TransportContext2 = (AutoValue_TransportContext) this.defaults;
                AutoValue_EventInternal autoValue_EventInternal = (AutoValue_EventInternal) this.options;
                EncodedPayload encodedPayload = autoValue_EventInternal.encodedPayload;
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                Encoding encoding4 = SQLiteEventStore.PROTOBUF_ENCODING;
                long jSimpleQueryForLong = sQLiteEventStore2.getDb().compileStatement("PRAGMA page_size").simpleQueryForLong() * sQLiteEventStore2.getDb().compileStatement("PRAGMA page_count").simpleQueryForLong();
                AutoValue_EventStoreConfig autoValue_EventStoreConfig = sQLiteEventStore2.config;
                if (jSimpleQueryForLong >= autoValue_EventStoreConfig.maxStorageSizeInBytes) {
                    return -1L;
                }
                Long transportContextId = SQLiteEventStore.getTransportContextId(sQLiteDatabase, autoValue_TransportContext2);
                if (transportContextId != null) {
                    jInsert = transportContextId.longValue();
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("backend_name", autoValue_TransportContext2.backendName);
                    contentValues.put("priority", Integer.valueOf(PriorityMapping.toInt(autoValue_TransportContext2.priority)));
                    contentValues.put("next_request_ms", (Integer) 0);
                    byte[] bArr3 = autoValue_TransportContext2.extras;
                    if (bArr3 != null) {
                        contentValues.put("extras", Base64.encodeToString(bArr3, 0));
                    }
                    jInsert = sQLiteDatabase.insert("transport_contexts", null, contentValues);
                }
                int i6 = autoValue_EventStoreConfig.maxBlobByteSizePerRow;
                byte[] bArr4 = encodedPayload.bytes;
                boolean z = bArr4.length <= i6;
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("context_id", Long.valueOf(jInsert));
                contentValues2.put("transport_name", autoValue_EventInternal.transportName);
                contentValues2.put("timestamp_ms", Long.valueOf(autoValue_EventInternal.eventMillis));
                contentValues2.put("uptime_ms", Long.valueOf(autoValue_EventInternal.uptimeMillis));
                contentValues2.put("payload_encoding", encodedPayload.encoding.name);
                contentValues2.put("code", autoValue_EventInternal.code);
                contentValues2.put("num_attempts", (Integer) 0);
                contentValues2.put("inline", Boolean.valueOf(z));
                contentValues2.put("payload", z ? bArr4 : new byte[0]);
                long jInsert2 = sQLiteDatabase.insert("events", null, contentValues2);
                if (!z) {
                    int iCeil = (int) Math.ceil(((double) bArr4.length) / ((double) i6));
                    while (i3 <= iCeil) {
                        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr4, (i3 - 1) * i6, Math.min(i3 * i6, bArr4.length));
                        ContentValues contentValues3 = new ContentValues();
                        contentValues3.put("event_id", Long.valueOf(jInsert2));
                        contentValues3.put("sequence_num", Integer.valueOf(i3));
                        contentValues3.put("bytes", bArrCopyOfRange);
                        sQLiteDatabase.insert("event_payloads", null, contentValues3);
                        i3++;
                    }
                }
                for (Map.Entry entry : Collections.unmodifiableMap(autoValue_EventInternal.autoMetadata).entrySet()) {
                    ContentValues contentValues4 = new ContentValues();
                    contentValues4.put("event_id", Long.valueOf(jInsert2));
                    contentValues4.put("name", (String) entry.getKey());
                    contentValues4.put("value", (String) entry.getValue());
                    sQLiteDatabase.insert("event_metadata", null, contentValues4);
                }
                return Long.valueOf(jInsert2);
        }
    }

    public void attachViewToParent(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        RecyclerView recyclerView = RecyclerView.this;
        int childCount = i < 0 ? recyclerView.getChildCount() : getOffset(i);
        ((HeadersReader) this.defaults).insert(childCount, z);
        if (z) {
            hideViewInternal(view);
        }
        RecyclerView.ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (!childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                throw new IllegalArgumentException("Called attach on a child which is not detached: " + childViewHolderInt + recyclerView.exceptionLabel());
            }
            childViewHolderInt.mFlags &= -257;
        }
        recyclerView.attachViewToParent(view, childCount, layoutParams);
    }

    public void detachViewFromParent(int i) {
        RecyclerView.ViewHolder childViewHolderInt;
        int offset = getOffset(i);
        ((HeadersReader) this.defaults).remove(offset);
        RecyclerView recyclerView = RecyclerView.this;
        View childAt = recyclerView.getChildAt(offset);
        if (childAt != null && (childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt)) != null) {
            if (childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                throw new IllegalArgumentException("called detach on an already detached child " + childViewHolderInt + recyclerView.exceptionLabel());
            }
            childViewHolderInt.addFlags(256);
        }
        recyclerView.detachViewFromParent(offset);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object execute() {
        DefaultScheduler defaultScheduler = (DefaultScheduler) this.applicationContext;
        AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) this.defaults;
        AutoValue_EventInternal autoValue_EventInternal = (AutoValue_EventInternal) this.options;
        SQLiteEventStore sQLiteEventStore = (SQLiteEventStore) defaultScheduler.eventStore;
        sQLiteEventStore.getClass();
        Priority priority = autoValue_TransportContext.priority;
        String str = autoValue_EventInternal.transportName;
        String str2 = autoValue_TransportContext.backendName;
        Log.d("TransportRuntime.".concat("SQLiteEventStore"), "Storing event with priority=" + priority + ", name=" + str + " for destination " + str2);
        ((Long) sQLiteEventStore.inTransaction(new ImageLoader$Builder(sQLiteEventStore, autoValue_TransportContext, autoValue_EventInternal, 16))).getClass();
        defaultScheduler.workScheduler.schedule(autoValue_TransportContext, 1, false);
        return null;
    }

    @Override // javax.inject.Provider
    public Object get() {
        switch (this.$r8$classId) {
            case 10:
                int i = 15;
                return new TransportRuntime(new ByteString.Companion(i), new AsyncTimeout.Companion(i), (Scheduler) ((Request) this.applicationContext).get(), (TooltipPopup) ((Http2Connection.Builder) this.defaults).get(), (Dispatcher) ((Dispatcher) this.options).get());
            default:
                return new ImageLoader$Builder((Context) ((Provider) this.applicationContext).get(), (EventStore) ((Provider) this.defaults).get(), (AutoValue_SchedulerConfig) ((zze) this.options).get(), 14);
        }
    }

    public View getChildAt(int i) {
        return RecyclerView.this.getChildAt(getOffset(i));
    }

    public int getChildCount() {
        return RecyclerView.this.getChildCount() - ((ArrayList) this.options).size();
    }

    public int getOffset(int i) {
        HeadersReader headersReader = (HeadersReader) this.defaults;
        if (i < 0) {
            return -1;
        }
        int childCount = RecyclerView.this.getChildCount();
        int i2 = i;
        while (i2 < childCount) {
            int iCountOnesBefore = i - (i2 - headersReader.countOnesBefore(i2));
            if (iCountOnesBefore == 0) {
                while (headersReader.get(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += iCountOnesBefore;
        }
        return -1;
    }

    public int getSize(Version version) {
        ArrayList arrayList = (ArrayList) this.applicationContext;
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            MinimalEncoder$ResultList$ResultNode minimalEncoder$ResultList$ResultNode = (MinimalEncoder$ResultList$ResultNode) obj;
            int i3 = minimalEncoder$ResultList$ResultNode.characterLength;
            Mode mode = minimalEncoder$ResultList$ResultNode.mode;
            int characterCountBits = mode.getCharacterCountBits(version);
            int characterCountIndicator = characterCountBits + 4;
            int iOrdinal = mode.ordinal();
            int i4 = 4;
            if (iOrdinal != 1) {
                if (iOrdinal == 2) {
                    characterCountIndicator = ((i3 / 2) * 11) + characterCountIndicator + (i3 % 2 != 1 ? 0 : 6);
                } else if (iOrdinal == 4) {
                    characterCountIndicator += minimalEncoder$ResultList$ResultNode.getCharacterCountIndicator() * 8;
                } else if (iOrdinal == 5) {
                    characterCountIndicator = characterCountBits + 12;
                } else if (iOrdinal == 6) {
                    characterCountIndicator += i3 * 13;
                }
            } else {
                int i5 = ((i3 / 3) * 10) + characterCountIndicator;
                int i6 = i3 % 3;
                if (i6 != 1) {
                    i4 = i6 == 2 ? 7 : 0;
                }
                characterCountIndicator = i5 + i4;
            }
            i += characterCountIndicator;
        }
        return i;
    }

    public TransportImpl getTransport(Encoding encoding, Transformer transformer) {
        Set set = (Set) this.applicationContext;
        if (set.contains(encoding)) {
            return new TransportImpl((AutoValue_TransportContext) this.defaults, encoding, transformer, (TransportRuntime) this.options);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", encoding, set));
    }

    public View getUnfilteredChildAt(int i) {
        return RecyclerView.this.getChildAt(i);
    }

    public int getUnfilteredChildCount() {
        return RecyclerView.this.getChildCount();
    }

    public boolean hasGlyph(CharSequence charSequence, int i, int i2, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        if ((typefaceEmojiRasterizer.mCache & 3) == 0) {
            EmojiCompat.GlyphChecker glyphChecker = (EmojiCompat.GlyphChecker) this.options;
            MetadataItem metadataItem = typefaceEmojiRasterizer.getMetadataItem();
            int i__offset = metadataItem.__offset(8);
            if (i__offset != 0) {
                ((ByteBuffer) metadataItem.bb).getShort(i__offset + metadataItem.bb_pos);
            }
            DefaultGlyphChecker defaultGlyphChecker = (DefaultGlyphChecker) glyphChecker;
            defaultGlyphChecker.getClass();
            ThreadLocal threadLocal = DefaultGlyphChecker.sStringBuilder;
            if (threadLocal.get() == null) {
                threadLocal.set(new StringBuilder());
            }
            StringBuilder sb = (StringBuilder) threadLocal.get();
            sb.setLength(0);
            while (i < i2) {
                sb.append(charSequence.charAt(i));
                i++;
            }
            TextPaint textPaint = defaultGlyphChecker.mTextPaint;
            String string = sb.toString();
            int i3 = PaintCompat.$r8$clinit;
            boolean zHasGlyph = textPaint.hasGlyph(string);
            int i4 = typefaceEmojiRasterizer.mCache & 4;
            typefaceEmojiRasterizer.mCache = zHasGlyph ? i4 | 2 : i4 | 1;
        }
        return (typefaceEmojiRasterizer.mCache & 3) == 2;
    }

    public void hideViewInternal(View view) {
        ((ArrayList) this.options).add(view);
        RecyclerView.AnonymousClass5 anonymousClass5 = (RecyclerView.AnonymousClass5) this.applicationContext;
        RecyclerView.ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            View view2 = childViewHolderInt.itemView;
            RecyclerView recyclerView = RecyclerView.this;
            int i = childViewHolderInt.mPendingAccessibilityState;
            if (i != -1) {
                childViewHolderInt.mWasImportantForAccessibilityBeforeHidden = i;
            } else {
                WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                childViewHolderInt.mWasImportantForAccessibilityBeforeHidden = view2.getImportantForAccessibility();
            }
            if (recyclerView.isComputingLayout()) {
                childViewHolderInt.mPendingAccessibilityState = 4;
                recyclerView.mPendingAccessibilityImportanceChange.add(childViewHolderInt);
            } else {
                WeakHashMap weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                view2.setImportantForAccessibility(4);
            }
        }
    }

    @Override // coil.network.NetworkObserver
    public boolean isOnline() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.applicationContext;
        for (Network network : connectivityManager.getAllNetworks()) {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
            if (networkCapabilities != null && networkCapabilities.hasCapability(12)) {
                return true;
            }
        }
        return false;
    }

    public Object process(CharSequence charSequence, int i, int i2, int i3, boolean z, EmojiProcessor$EmojiProcessCallback emojiProcessor$EmojiProcessCallback) {
        int i4;
        char c;
        EmojiProcessor$ProcessorSm emojiProcessor$ProcessorSm = new EmojiProcessor$ProcessorSm((MetadataRepo$Node) ((Dispatcher) this.defaults).runningAsyncCalls);
        int iCodePointAt = Character.codePointAt(charSequence, i);
        int i5 = 0;
        boolean zHandleEmoji = true;
        int iCharCount = i;
        loop0: while (true) {
            i4 = iCharCount;
            while (true) {
                if (iCharCount < i2 && i5 < i3 && zHandleEmoji) {
                    SparseArray sparseArray = emojiProcessor$ProcessorSm.mCurrentNode.mChildren;
                    MetadataRepo$Node metadataRepo$Node = sparseArray == null ? null : (MetadataRepo$Node) sparseArray.get(iCodePointAt);
                    if (emojiProcessor$ProcessorSm.mState == 2) {
                        if (metadataRepo$Node != null) {
                            emojiProcessor$ProcessorSm.mCurrentNode = metadataRepo$Node;
                            emojiProcessor$ProcessorSm.mCurrentDepth++;
                        } else {
                            if (iCodePointAt == 65038) {
                                emojiProcessor$ProcessorSm.reset();
                            } else if (iCodePointAt != 65039) {
                                MetadataRepo$Node metadataRepo$Node2 = emojiProcessor$ProcessorSm.mCurrentNode;
                                if (metadataRepo$Node2.mData != null) {
                                    if (emojiProcessor$ProcessorSm.mCurrentDepth != 1) {
                                        emojiProcessor$ProcessorSm.mFlushNode = metadataRepo$Node2;
                                        emojiProcessor$ProcessorSm.reset();
                                    } else if (emojiProcessor$ProcessorSm.shouldUseEmojiPresentationStyleForSingleCodepoint()) {
                                        emojiProcessor$ProcessorSm.mFlushNode = emojiProcessor$ProcessorSm.mCurrentNode;
                                        emojiProcessor$ProcessorSm.reset();
                                    } else {
                                        emojiProcessor$ProcessorSm.reset();
                                    }
                                    c = 3;
                                } else {
                                    emojiProcessor$ProcessorSm.reset();
                                }
                            }
                            c = 1;
                        }
                        c = 2;
                    } else if (metadataRepo$Node == null) {
                        emojiProcessor$ProcessorSm.reset();
                        c = 1;
                    } else {
                        emojiProcessor$ProcessorSm.mState = 2;
                        emojiProcessor$ProcessorSm.mCurrentNode = metadataRepo$Node;
                        emojiProcessor$ProcessorSm.mCurrentDepth = 1;
                        c = 2;
                    }
                    emojiProcessor$ProcessorSm.mLastCodepoint = iCodePointAt;
                    if (c == 1) {
                        iCharCount = Character.charCount(Character.codePointAt(charSequence, i4)) + i4;
                        if (iCharCount >= i2) {
                            break;
                        }
                        iCodePointAt = Character.codePointAt(charSequence, iCharCount);
                        break;
                    }
                    if (c == 2) {
                        int iCharCount2 = Character.charCount(iCodePointAt) + iCharCount;
                        if (iCharCount2 < i2) {
                            iCodePointAt = Character.codePointAt(charSequence, iCharCount2);
                        }
                        iCharCount = iCharCount2;
                    } else if (c == 3) {
                        if (!z && hasGlyph(charSequence, i4, iCharCount, emojiProcessor$ProcessorSm.mFlushNode.mData)) {
                            break;
                        }
                        zHandleEmoji = emojiProcessor$EmojiProcessCallback.handleEmoji(charSequence, i4, iCharCount, emojiProcessor$ProcessorSm.mFlushNode.mData);
                        i5++;
                        break;
                    }
                } else {
                    break loop0;
                }
            }
        }
        if (emojiProcessor$ProcessorSm.mState == 2 && emojiProcessor$ProcessorSm.mCurrentNode.mData != null && ((emojiProcessor$ProcessorSm.mCurrentDepth > 1 || emojiProcessor$ProcessorSm.shouldUseEmojiPresentationStyleForSingleCodepoint()) && i5 < i3 && zHandleEmoji && (z || !hasGlyph(charSequence, i4, iCharCount, emojiProcessor$ProcessorSm.mCurrentNode.mData)))) {
            emojiProcessor$EmojiProcessCallback.handleEmoji(charSequence, i4, iCharCount, emojiProcessor$ProcessorSm.mCurrentNode.mData);
        }
        return emojiProcessor$EmojiProcessCallback.getResult();
    }

    @Override // com.google.firebase.encoders.config.EncoderConfig
    public /* bridge */ /* synthetic */ EncoderConfig registerEncoder(Class cls, ObjectEncoder objectEncoder) {
        ((HashMap) this.applicationContext).put(cls, objectEncoder);
        ((HashMap) this.defaults).remove(cls);
        return this;
    }

    public void schedule(AutoValue_TransportContext autoValue_TransportContext, int i, boolean z) {
        char c;
        AutoValue_SchedulerConfig autoValue_SchedulerConfig = (AutoValue_SchedulerConfig) this.options;
        Context context = (Context) this.applicationContext;
        ComponentName componentName = new ComponentName(context, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        Adler32 adler32 = new Adler32();
        adler32.update(context.getPackageName().getBytes(Charset.forName("UTF-8")));
        String str = autoValue_TransportContext.backendName;
        String str2 = autoValue_TransportContext.backendName;
        adler32.update(str.getBytes(Charset.forName("UTF-8")));
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        Priority priority = autoValue_TransportContext.priority;
        adler32.update(byteBufferAllocate.putInt(PriorityMapping.toInt(priority)).array());
        byte[] bArr = autoValue_TransportContext.extras;
        if (bArr != null) {
            adler32.update(bArr);
        }
        int value = (int) adler32.getValue();
        if (!z) {
            for (JobInfo jobInfo : jobScheduler.getAllPendingJobs()) {
                int i2 = jobInfo.getExtras().getInt("attemptNumber");
                if (jobInfo.getId() == value) {
                    if (i2 < i) {
                        break;
                    }
                    zzkl.d("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", autoValue_TransportContext);
                    return;
                }
            }
        }
        Cursor cursorRawQuery = ((SQLiteEventStore) ((EventStore) this.defaults)).getDb().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{str2, String.valueOf(PriorityMapping.toInt(priority))});
        try {
            Long lValueOf = cursorRawQuery.moveToNext() ? Long.valueOf(cursorRawQuery.getLong(0)) : 0L;
            cursorRawQuery.close();
            long jLongValue = lValueOf.longValue();
            JobInfo.Builder builder = new JobInfo.Builder(value, componentName);
            builder.setMinimumLatency(autoValue_SchedulerConfig.getScheduleDelay(priority, jLongValue, i));
            Set set = ((AutoValue_SchedulerConfig_ConfigValue) autoValue_SchedulerConfig.values.get(priority)).flags;
            if (set.contains(SchedulerConfig$Flag.NETWORK_UNMETERED)) {
                builder.setRequiredNetworkType(2);
            } else {
                builder.setRequiredNetworkType(1);
            }
            if (set.contains(SchedulerConfig$Flag.DEVICE_CHARGING)) {
                builder.setRequiresCharging(true);
            }
            if (set.contains(SchedulerConfig$Flag.DEVICE_IDLE)) {
                builder.setRequiresDeviceIdle(true);
            }
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putInt("attemptNumber", i);
            persistableBundle.putString("backendName", str2);
            persistableBundle.putInt("priority", PriorityMapping.toInt(priority));
            if (bArr != null) {
                c = 0;
                persistableBundle.putString("extras", Base64.encodeToString(bArr, 0));
            } else {
                c = 0;
            }
            builder.setExtras(persistableBundle);
            Integer numValueOf = Integer.valueOf(value);
            Long lValueOf2 = Long.valueOf(autoValue_SchedulerConfig.getScheduleDelay(priority, jLongValue, i));
            Integer numValueOf2 = Integer.valueOf(i);
            Object[] objArr = new Object[5];
            objArr[c] = autoValue_TransportContext;
            objArr[1] = numValueOf;
            objArr[2] = lValueOf2;
            objArr[3] = lValueOf;
            objArr[4] = numValueOf2;
            Log.d("TransportRuntime.".concat("JobInfoScheduler"), String.format("Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", objArr));
            jobScheduler.schedule(builder.build());
        } catch (Throwable th) {
            cursorRawQuery.close();
            throw th;
        }
    }

    @Override // coil.network.NetworkObserver
    public void shutdown() {
        ((ConnectivityManager) this.applicationContext).unregisterNetworkCallback((RealNetworkObserver$networkCallback$1) this.options);
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 3:
                String str = (String) this.options;
                String str2 = (String) this.defaults;
                StringBuilder sb = new StringBuilder("NavDeepLinkRequest{");
                Uri uri = (Uri) this.applicationContext;
                if (uri != null) {
                    sb.append(" uri=");
                    sb.append(String.valueOf(uri));
                }
                if (str2 != null) {
                    sb.append(" action=");
                    sb.append(str2);
                }
                if (str != null) {
                    sb.append(" mimetype=");
                    sb.append(str);
                }
                sb.append(" }");
                return sb.toString();
            case 4:
                return ((HeadersReader) this.defaults).toString() + ", hidden list:" + ((ArrayList) this.options).size();
            case 21:
                StringBuilder sb2 = new StringBuilder();
                ArrayList arrayList = (ArrayList) this.applicationContext;
                int size = arrayList.size();
                MinimalEncoder$ResultList$ResultNode minimalEncoder$ResultList$ResultNode = null;
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    MinimalEncoder$ResultList$ResultNode minimalEncoder$ResultList$ResultNode2 = (MinimalEncoder$ResultList$ResultNode) obj;
                    if (minimalEncoder$ResultList$ResultNode != null) {
                        sb2.append(",");
                    }
                    sb2.append(minimalEncoder$ResultList$ResultNode2.toString());
                    minimalEncoder$ResultList$ResultNode = minimalEncoder$ResultList$ResultNode2;
                }
                return sb2.toString();
            default:
                return super.toString();
        }
    }

    public void unhideViewInternal(View view) {
        if (((ArrayList) this.options).remove(view)) {
            RecyclerView.AnonymousClass5 anonymousClass5 = (RecyclerView.AnonymousClass5) this.applicationContext;
            RecyclerView.ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                RecyclerView recyclerView = RecyclerView.this;
                int i = childViewHolderInt.mWasImportantForAccessibilityBeforeHidden;
                if (recyclerView.isComputingLayout()) {
                    childViewHolderInt.mPendingAccessibilityState = i;
                    recyclerView.mPendingAccessibilityImportanceChange.add(childViewHolderInt);
                } else {
                    View view2 = childViewHolderInt.itemView;
                    WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    view2.setImportantForAccessibility(i);
                }
                childViewHolderInt.mWasImportantForAccessibilityBeforeHidden = 0;
            }
        }
    }

    public /* synthetic */ ImageLoader$Builder(Object obj, Object obj2, Object obj3, int i) {
        this.$r8$classId = i;
        this.applicationContext = obj;
        this.defaults = obj2;
        this.options = obj3;
    }

    public ImageLoader$Builder() {
        this.$r8$classId = 18;
        this.applicationContext = new HashMap();
        this.defaults = new HashMap();
        this.options = zzaj.zza$1;
    }

    public ImageLoader$Builder(RecyclerView.AnonymousClass5 anonymousClass5) {
        this.$r8$classId = 4;
        this.applicationContext = anonymousClass5;
        this.defaults = new HeadersReader(2);
        this.options = new ArrayList();
    }

    public ImageLoader$Builder(Intent intent) {
        this.$r8$classId = 3;
        Uri data = intent.getData();
        String action = intent.getAction();
        String type = intent.getType();
        this.applicationContext = data;
        this.defaults = action;
        this.options = type;
    }

    public ImageLoader$Builder(ConnectivityManager connectivityManager, SystemCallbacks systemCallbacks) {
        this.$r8$classId = 5;
        this.applicationContext = connectivityManager;
        this.defaults = systemCallbacks;
        RealNetworkObserver$networkCallback$1 realNetworkObserver$networkCallback$1 = new RealNetworkObserver$networkCallback$1(0, this);
        this.options = realNetworkObserver$networkCallback$1;
        connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).build(), realNetworkObserver$networkCallback$1);
    }

    public ImageLoader$Builder(Context context, int i) {
        this.$r8$classId = i;
        switch (i) {
            case 20:
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(zzln.resolveOrThrow(R.attr.materialCalendarStyle, context, MaterialCalendar.class.getCanonicalName()), R$styleable.MaterialCalendar);
                RulerTrackingMap.create(context, typedArrayObtainStyledAttributes.getResourceId(3, 0));
                this.options = RulerTrackingMap.create(context, typedArrayObtainStyledAttributes.getResourceId(1, 0));
                RulerTrackingMap.create(context, typedArrayObtainStyledAttributes.getResourceId(2, 0));
                RulerTrackingMap.create(context, typedArrayObtainStyledAttributes.getResourceId(4, 0));
                ColorStateList colorStateList = MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, 6);
                this.applicationContext = RulerTrackingMap.create(context, typedArrayObtainStyledAttributes.getResourceId(8, 0));
                RulerTrackingMap.create(context, typedArrayObtainStyledAttributes.getResourceId(7, 0));
                this.defaults = RulerTrackingMap.create(context, typedArrayObtainStyledAttributes.getResourceId(9, 0));
                new Paint().setColor(colorStateList.getDefaultColor());
                typedArrayObtainStyledAttributes.recycle();
                break;
            default:
                this.applicationContext = context.getApplicationContext();
                this.defaults = Requests.DEFAULT_REQUEST_OPTIONS;
                this.options = new SingletonDiskCache();
                break;
        }
    }

    public ImageLoader$Builder(Dispatcher dispatcher, AsyncTimeout.Companion companion, DefaultGlyphChecker defaultGlyphChecker, Set set) {
        this.$r8$classId = 2;
        this.applicationContext = companion;
        this.defaults = dispatcher;
        this.options = defaultGlyphChecker;
        if (set.isEmpty()) {
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            int[] iArr = (int[]) it.next();
            String str = new String(iArr, 0, iArr.length);
            process(str, 0, str.length(), 1, true, new EmojiProcessor$MarkExclusionCallback(str));
        }
    }

    public ImageLoader$Builder(MemoryCacheService memoryCacheService) {
        this.$r8$classId = 1;
        this.$r8$classId = 1;
        this.applicationContext = memoryCacheService;
        this.defaults = Choreographer.getInstance();
        this.options = new Choreographer.FrameCallback() { // from class: androidx.dynamicanimation.animation.AnimationHandler$FrameCallbackProvider16$1
            /* JADX WARN: Code duplicated, block: B:16:0x0048  */
            /* JADX WARN: Code duplicated, block: B:17:0x0050  */
            /* JADX WARN: Code duplicated, block: B:19:0x005f  */
            /* JADX WARN: Code duplicated, block: B:21:0x0065  */
            /* JADX WARN: Code duplicated, block: B:24:0x007d  */
            /* JADX WARN: Code duplicated, block: B:26:0x0083  */
            /* JADX WARN: Code duplicated, block: B:27:0x00c1  */
            /* JADX WARN: Code duplicated, block: B:36:0x012f  */
            /* JADX WARN: Code duplicated, block: B:38:0x013c  */
            /* JADX WARN: Code duplicated, block: B:41:0x0157  */
            /* JADX WARN: Code duplicated, block: B:45:0x016c  */
            /* JADX WARN: Code duplicated, block: B:47:0x0172 A[LOOP:1: B:43:0x0166->B:47:0x0172, LOOP_END] */
            /* JADX WARN: Code duplicated, block: B:52:0x018c  */
            /* JADX WARN: Code duplicated, block: B:54:0x0192  */
            /* JADX WARN: Code duplicated, block: B:74:0x0175 A[SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:76:0x0198 A[SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:7:0x0026  */
            /* JADX WARN: Code duplicated, block: B:80:0x0195 A[SYNTHETIC] */
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j) {
                long j2;
                long j3;
                float f;
                int i;
                float f2;
                SpringForce springForce;
                boolean z;
                ArrayList arrayList;
                ThreadLocal threadLocal;
                AnimationHandler animationHandler;
                ArrayList arrayList2;
                int iIndexOf;
                int i2;
                int size;
                float f3;
                AnimationHandler animationHandler2 = (AnimationHandler) ((MemoryCacheService) this.this$0.applicationContext).imageLoader;
                long jUptimeMillis = SystemClock.uptimeMillis();
                ArrayList arrayList3 = animationHandler2.mAnimationCallbacks;
                long jUptimeMillis2 = SystemClock.uptimeMillis();
                boolean z2 = false;
                int i3 = 0;
                while (i3 < arrayList3.size()) {
                    SpringAnimation springAnimation = (SpringAnimation) arrayList3.get(i3);
                    if (springAnimation == null) {
                        i = i3;
                    } else {
                        SimpleArrayMap simpleArrayMap = animationHandler2.mDelayedCallbackStartTime;
                        Long l = (Long) simpleArrayMap.get(springAnimation);
                        if (l == null) {
                            j2 = springAnimation.mLastFrameTime;
                            if (j2 == 0) {
                                springAnimation.mLastFrameTime = jUptimeMillis;
                                springAnimation.setPropertyValue(springAnimation.mValue);
                                i = i3;
                            } else {
                                j3 = jUptimeMillis - j2;
                                springAnimation.mLastFrameTime = jUptimeMillis;
                                f = Float.MAX_VALUE;
                                if (springAnimation.mEndRequested) {
                                    f3 = springAnimation.mPendingPosition;
                                    if (f3 != Float.MAX_VALUE) {
                                        springAnimation.mSpring.mFinalPosition = f3;
                                        springAnimation.mPendingPosition = Float.MAX_VALUE;
                                    }
                                    springAnimation.mValue = (float) springAnimation.mSpring.mFinalPosition;
                                    springAnimation.mVelocity = 0.0f;
                                    springAnimation.mEndRequested = z2;
                                    i = i3;
                                    f = Float.MAX_VALUE;
                                } else {
                                    if (springAnimation.mPendingPosition != Float.MAX_VALUE) {
                                        SpringForce springForce2 = springAnimation.mSpring;
                                        double d = springForce2.mFinalPosition;
                                        i = i3;
                                        long j4 = j3 / 2;
                                        FlingCalculator flingCalculatorUpdateValues = springForce2.updateValues(springAnimation.mValue, springAnimation.mVelocity, j4);
                                        SpringForce springForce3 = springAnimation.mSpring;
                                        springForce3.mFinalPosition = springAnimation.mPendingPosition;
                                        springAnimation.mPendingPosition = Float.MAX_VALUE;
                                        FlingCalculator flingCalculatorUpdateValues2 = springForce3.updateValues(flingCalculatorUpdateValues.friction, flingCalculatorUpdateValues.magicPhysicalCoefficient, j4);
                                        springAnimation.mValue = flingCalculatorUpdateValues2.friction;
                                        springAnimation.mVelocity = flingCalculatorUpdateValues2.magicPhysicalCoefficient;
                                    } else {
                                        i = i3;
                                        FlingCalculator flingCalculatorUpdateValues3 = springAnimation.mSpring.updateValues(springAnimation.mValue, springAnimation.mVelocity, j3);
                                        springAnimation.mValue = flingCalculatorUpdateValues3.friction;
                                        springAnimation.mVelocity = flingCalculatorUpdateValues3.magicPhysicalCoefficient;
                                    }
                                    float fMax = Math.max(springAnimation.mValue, -3.4028235E38f);
                                    springAnimation.mValue = fMax;
                                    float fMin = Math.min(fMax, f);
                                    springAnimation.mValue = fMin;
                                    f2 = springAnimation.mVelocity;
                                    springForce = springAnimation.mSpring;
                                    springForce.getClass();
                                    if (Math.abs(f2) < springForce.mVelocityThreshold) {
                                    }
                                    z = false;
                                    float fMin2 = Math.min(springAnimation.mValue, f);
                                    springAnimation.mValue = fMin2;
                                    float fMax2 = Math.max(fMin2, -3.4028235E38f);
                                    springAnimation.mValue = fMax2;
                                    springAnimation.setPropertyValue(fMax2);
                                    if (z) {
                                        arrayList = springAnimation.mEndListeners;
                                        springAnimation.mRunning = false;
                                        threadLocal = AnimationHandler.sAnimatorHandler;
                                        if (threadLocal.get() == null) {
                                            threadLocal.set(new AnimationHandler());
                                        }
                                        animationHandler = (AnimationHandler) threadLocal.get();
                                        animationHandler.mDelayedCallbackStartTime.remove(springAnimation);
                                        arrayList2 = animationHandler.mAnimationCallbacks;
                                        iIndexOf = arrayList2.indexOf(springAnimation);
                                        if (iIndexOf >= 0) {
                                            arrayList2.set(iIndexOf, null);
                                            animationHandler.mListDirty = true;
                                        }
                                        springAnimation.mLastFrameTime = 0L;
                                        springAnimation.mStartValueIsSet = false;
                                        for (i2 = 0; i2 < arrayList.size(); i2++) {
                                            if (arrayList.get(i2) == null) {
                                                arrayList.get(i2).getClass();
                                                throw new ClassCastException();
                                            }
                                        }
                                        for (size = arrayList.size() - 1; size >= 0; size--) {
                                            if (arrayList.get(size) == null) {
                                                arrayList.remove(size);
                                            }
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                                z = true;
                                float fMin3 = Math.min(springAnimation.mValue, f);
                                springAnimation.mValue = fMin3;
                                float fMax3 = Math.max(fMin3, -3.4028235E38f);
                                springAnimation.mValue = fMax3;
                                springAnimation.setPropertyValue(fMax3);
                                if (z) {
                                    arrayList = springAnimation.mEndListeners;
                                    springAnimation.mRunning = false;
                                    threadLocal = AnimationHandler.sAnimatorHandler;
                                    if (threadLocal.get() == null) {
                                        threadLocal.set(new AnimationHandler());
                                    }
                                    animationHandler = (AnimationHandler) threadLocal.get();
                                    animationHandler.mDelayedCallbackStartTime.remove(springAnimation);
                                    arrayList2 = animationHandler.mAnimationCallbacks;
                                    iIndexOf = arrayList2.indexOf(springAnimation);
                                    if (iIndexOf >= 0) {
                                        arrayList2.set(iIndexOf, null);
                                        animationHandler.mListDirty = true;
                                    }
                                    springAnimation.mLastFrameTime = 0L;
                                    springAnimation.mStartValueIsSet = false;
                                    while (i2 < arrayList.size()) {
                                        if (arrayList.get(i2) == null) {
                                            arrayList.get(i2).getClass();
                                            throw new ClassCastException();
                                        }
                                    }
                                    while (size >= 0) {
                                        if (arrayList.get(size) == null) {
                                            arrayList.remove(size);
                                        }
                                    }
                                } else {
                                    continue;
                                }
                            }
                        } else if (l.longValue() < jUptimeMillis2) {
                            simpleArrayMap.remove(springAnimation);
                            j2 = springAnimation.mLastFrameTime;
                            if (j2 == 0) {
                                springAnimation.mLastFrameTime = jUptimeMillis;
                                springAnimation.setPropertyValue(springAnimation.mValue);
                                i = i3;
                            } else {
                                j3 = jUptimeMillis - j2;
                                springAnimation.mLastFrameTime = jUptimeMillis;
                                f = Float.MAX_VALUE;
                                if (springAnimation.mEndRequested) {
                                    f3 = springAnimation.mPendingPosition;
                                    if (f3 != Float.MAX_VALUE) {
                                        springAnimation.mSpring.mFinalPosition = f3;
                                        springAnimation.mPendingPosition = Float.MAX_VALUE;
                                    }
                                    springAnimation.mValue = (float) springAnimation.mSpring.mFinalPosition;
                                    springAnimation.mVelocity = 0.0f;
                                    springAnimation.mEndRequested = z2;
                                    i = i3;
                                    f = Float.MAX_VALUE;
                                } else {
                                    if (springAnimation.mPendingPosition != Float.MAX_VALUE) {
                                        SpringForce springForce4 = springAnimation.mSpring;
                                        double d2 = springForce4.mFinalPosition;
                                        i = i3;
                                        long j5 = j3 / 2;
                                        FlingCalculator flingCalculatorUpdateValues4 = springForce4.updateValues(springAnimation.mValue, springAnimation.mVelocity, j5);
                                        SpringForce springForce5 = springAnimation.mSpring;
                                        springForce5.mFinalPosition = springAnimation.mPendingPosition;
                                        springAnimation.mPendingPosition = Float.MAX_VALUE;
                                        FlingCalculator flingCalculatorUpdateValues5 = springForce5.updateValues(flingCalculatorUpdateValues4.friction, flingCalculatorUpdateValues4.magicPhysicalCoefficient, j5);
                                        springAnimation.mValue = flingCalculatorUpdateValues5.friction;
                                        springAnimation.mVelocity = flingCalculatorUpdateValues5.magicPhysicalCoefficient;
                                    } else {
                                        i = i3;
                                        FlingCalculator flingCalculatorUpdateValues6 = springAnimation.mSpring.updateValues(springAnimation.mValue, springAnimation.mVelocity, j3);
                                        springAnimation.mValue = flingCalculatorUpdateValues6.friction;
                                        springAnimation.mVelocity = flingCalculatorUpdateValues6.magicPhysicalCoefficient;
                                    }
                                    float fMax4 = Math.max(springAnimation.mValue, -3.4028235E38f);
                                    springAnimation.mValue = fMax4;
                                    float fMin4 = Math.min(fMax4, f);
                                    springAnimation.mValue = fMin4;
                                    f2 = springAnimation.mVelocity;
                                    springForce = springAnimation.mSpring;
                                    springForce.getClass();
                                    if (Math.abs(f2) < springForce.mVelocityThreshold || Math.abs(fMin4 - ((float) springForce.mFinalPosition)) >= springForce.mValueThreshold) {
                                        z = false;
                                    } else {
                                        springAnimation.mValue = (float) springAnimation.mSpring.mFinalPosition;
                                        springAnimation.mVelocity = 0.0f;
                                    }
                                    float fMin5 = Math.min(springAnimation.mValue, f);
                                    springAnimation.mValue = fMin5;
                                    float fMax5 = Math.max(fMin5, -3.4028235E38f);
                                    springAnimation.mValue = fMax5;
                                    springAnimation.setPropertyValue(fMax5);
                                    if (z) {
                                        arrayList = springAnimation.mEndListeners;
                                        springAnimation.mRunning = false;
                                        threadLocal = AnimationHandler.sAnimatorHandler;
                                        if (threadLocal.get() == null) {
                                            threadLocal.set(new AnimationHandler());
                                        }
                                        animationHandler = (AnimationHandler) threadLocal.get();
                                        animationHandler.mDelayedCallbackStartTime.remove(springAnimation);
                                        arrayList2 = animationHandler.mAnimationCallbacks;
                                        iIndexOf = arrayList2.indexOf(springAnimation);
                                        if (iIndexOf >= 0) {
                                            arrayList2.set(iIndexOf, null);
                                            animationHandler.mListDirty = true;
                                        }
                                        springAnimation.mLastFrameTime = 0L;
                                        springAnimation.mStartValueIsSet = false;
                                        while (i2 < arrayList.size()) {
                                            if (arrayList.get(i2) == null) {
                                                arrayList.get(i2).getClass();
                                                throw new ClassCastException();
                                            }
                                        }
                                        while (size >= 0) {
                                            if (arrayList.get(size) == null) {
                                                arrayList.remove(size);
                                            }
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                                z = true;
                                float fMin6 = Math.min(springAnimation.mValue, f);
                                springAnimation.mValue = fMin6;
                                float fMax6 = Math.max(fMin6, -3.4028235E38f);
                                springAnimation.mValue = fMax6;
                                springAnimation.setPropertyValue(fMax6);
                                if (z) {
                                    arrayList = springAnimation.mEndListeners;
                                    springAnimation.mRunning = false;
                                    threadLocal = AnimationHandler.sAnimatorHandler;
                                    if (threadLocal.get() == null) {
                                        threadLocal.set(new AnimationHandler());
                                    }
                                    animationHandler = (AnimationHandler) threadLocal.get();
                                    animationHandler.mDelayedCallbackStartTime.remove(springAnimation);
                                    arrayList2 = animationHandler.mAnimationCallbacks;
                                    iIndexOf = arrayList2.indexOf(springAnimation);
                                    if (iIndexOf >= 0) {
                                        arrayList2.set(iIndexOf, null);
                                        animationHandler.mListDirty = true;
                                    }
                                    springAnimation.mLastFrameTime = 0L;
                                    springAnimation.mStartValueIsSet = false;
                                    while (i2 < arrayList.size()) {
                                        if (arrayList.get(i2) == null) {
                                            arrayList.get(i2).getClass();
                                            throw new ClassCastException();
                                        }
                                    }
                                    while (size >= 0) {
                                        if (arrayList.get(size) == null) {
                                            arrayList.remove(size);
                                        }
                                    }
                                } else {
                                    continue;
                                }
                            }
                        } else {
                            i = i3;
                        }
                    }
                    i3 = i + 1;
                    z2 = false;
                }
                if (animationHandler2.mListDirty) {
                    for (int size2 = arrayList3.size() - 1; size2 >= 0; size2--) {
                        if (arrayList3.get(size2) == null) {
                            arrayList3.remove(size2);
                        }
                    }
                    animationHandler2.mListDirty = false;
                }
                if (arrayList3.size() > 0) {
                    if (animationHandler2.mProvider == null) {
                        animationHandler2.mProvider = new ImageLoader$Builder(animationHandler2.mCallbackDispatcher);
                    }
                    ImageLoader$Builder imageLoader$Builder = animationHandler2.mProvider;
                    ((Choreographer) imageLoader$Builder.defaults).postFrameCallback((AnimationHandler$FrameCallbackProvider16$1) imageLoader$Builder.options);
                }
            }
        };
    }

    public ImageLoader$Builder(MinimalEncoder minimalEncoder, Version version, MinimalEncoder.Edge edge) {
        Mode mode;
        int i;
        int i2;
        this.$r8$classId = 21;
        this.options = minimalEncoder;
        this.applicationContext = new ArrayList();
        MinimalEncoder.Edge edge2 = edge;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            mode = Mode.ECI;
            i = 1;
            if (edge2 == null) {
                break;
            }
            int i5 = edge2.charsetEncoderIndex;
            int i6 = i3 + edge2.characterLength;
            MinimalEncoder.Edge edge3 = edge2.previous;
            int i7 = i4;
            Mode mode2 = edge2.mode;
            boolean z = (mode2 == Mode.BYTE && edge3 == null && i5 != 0) || !(edge3 == null || i5 == edge3.charsetEncoderIndex);
            i = z ? 1 : i7;
            if (edge3 == null || edge3.mode != mode2 || z) {
                ((ArrayList) this.applicationContext).add(0, new MinimalEncoder$ResultList$ResultNode(this, mode2, edge2.fromPosition, i5, i6));
                i2 = 0;
            } else {
                i2 = i6;
            }
            if (z) {
                ((ArrayList) this.applicationContext).add(0, new MinimalEncoder$ResultList$ResultNode(this, mode, edge2.fromPosition, edge2.charsetEncoderIndex, 0));
            }
            i4 = i;
            edge2 = edge3;
            i3 = i2;
        }
        int i8 = i4;
        boolean z2 = minimalEncoder.isGS1;
        int i9 = minimalEncoder.ecLevel;
        if (z2) {
            MinimalEncoder$ResultList$ResultNode minimalEncoder$ResultList$ResultNode = (MinimalEncoder$ResultList$ResultNode) ((ArrayList) this.applicationContext).get(0);
            if (minimalEncoder$ResultList$ResultNode != null && minimalEncoder$ResultList$ResultNode.mode != mode && i8 != 0) {
                ((ArrayList) this.applicationContext).add(0, new MinimalEncoder$ResultList$ResultNode(this, mode, 0, 0, 0));
            }
            ((ArrayList) this.applicationContext).add(((MinimalEncoder$ResultList$ResultNode) ((ArrayList) this.applicationContext).get(0)).mode == mode ? 1 : 0, new MinimalEncoder$ResultList$ResultNode(this, Mode.FNC1_FIRST_POSITION, 0, 0, 0));
        }
        int i10 = version.versionNumber;
        int i11 = 26;
        int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i10 <= 9 ? 1 : i10 <= 26 ? 2 : 3);
        if (iOrdinal == 0) {
            i11 = 9;
        } else if (iOrdinal != 1) {
            i = 27;
            i11 = 40;
        } else {
            i = 10;
        }
        int size = getSize(version);
        while (i10 < i11 && !Encoder.willFit(size, Version.getVersionForNumber(i10), i9)) {
            i10++;
        }
        while (i10 > i && Encoder.willFit(size, Version.getVersionForNumber(i10 - 1), i9)) {
            i10--;
        }
        this.defaults = Version.getVersionForNumber(i10);
    }
}
