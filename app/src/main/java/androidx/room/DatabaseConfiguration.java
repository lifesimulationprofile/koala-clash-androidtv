package androidx.room;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.appcompat.widget.TooltipPopup;
import androidx.camera.camera2.internal.Camera2CameraInfoImpl;
import androidx.camera.camera2.internal.CameraIdUtil;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.camera.core.InitializationException;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.core.util.Preconditions;
import coil.ImageLoader$Builder;
import coil.memory.MemoryCacheService;
import coil.network.HttpException;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.backends.AutoValue_BackendResponse;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Dependency;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.CharMappings;
import kotlinx.serialization.json.internal.WriteModeKt;
import okhttp3.internal.http1.HeadersReader;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class DatabaseConfiguration implements SynchronizationGuard.CriticalSection {
    public final /* synthetic */ int $r8$classId;
    public final Object autoMigrationSpecs;
    public final Object context;
    public int journalMode;
    public Object migrationContainer;
    public Object typeConverters;

    public DatabaseConfiguration(TooltipPopup tooltipPopup, AutoValue_BackendResponse autoValue_BackendResponse, Iterable iterable, AutoValue_TransportContext autoValue_TransportContext, int i) {
        this.$r8$classId = 2;
        this.context = tooltipPopup;
        this.migrationContainer = autoValue_BackendResponse;
        this.typeConverters = iterable;
        this.autoMigrationSpecs = autoValue_TransportContext;
        this.journalMode = i;
    }

    public static /* synthetic */ void fail$default(DatabaseConfiguration databaseConfiguration, String str, int i, String str2, int i2) {
        if ((i2 & 2) != 0) {
            i = databaseConfiguration.journalMode;
        }
        if ((i2 & 4) != 0) {
            str2 = "";
        }
        databaseConfiguration.fail(i, str, str2);
        throw null;
    }

    public void add(Dependency dependency) {
        if (((HashSet) this.context).contains(dependency.anInterface)) {
            throw new IllegalArgumentException("Components are not allowed to depend on interfaces they themselves provide.");
        }
        ((HashSet) this.migrationContainer).add(dependency);
    }

    public int appendHex(CharSequence charSequence, int i) {
        int i2 = i + 4;
        if (i2 < charSequence.length()) {
            ((StringBuilder) this.typeConverters).append((char) (fromHexChar(charSequence, i + 3) + (fromHexChar(charSequence, i) << 12) + (fromHexChar(charSequence, i + 1) << 8) + (fromHexChar(charSequence, i + 2) << 4)));
            return i2;
        }
        this.journalMode = i;
        if (i2 < charSequence.length()) {
            return appendHex(charSequence, this.journalMode);
        }
        fail$default(this, "Unexpected EOF during unicode escape", 0, null, 6);
        throw null;
    }

    public Component build() {
        if (((ComponentFactory) this.typeConverters) != null) {
            return new Component(new HashSet((HashSet) this.context), new HashSet((HashSet) this.migrationContainer), this.journalMode, (ComponentFactory) this.typeConverters, (HashSet) this.autoMigrationSpecs);
        }
        throw new IllegalStateException("Missing required property: factory.");
    }

    public boolean canConsumeValue() {
        int i = this.journalMode;
        if (i == -1) {
            return false;
        }
        String str = (String) this.autoMigrationSpecs;
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.journalMode = i;
                return (cCharAt == ',' || cCharAt == ':' || cCharAt == ']' || cCharAt == '}') ? false : true;
            }
            i++;
        }
        this.journalMode = i;
        return false;
    }

    public void consumeBooleanLiteral(String str, int i) {
        String str2 = (String) this.autoMigrationSpecs;
        if (str2.length() - i < str.length()) {
            fail$default(this, "Unexpected end of boolean literal", 0, null, 6);
            throw null;
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (str.charAt(i2) != (str2.charAt(i + i2) | ' ')) {
                fail$default(this, "Expected valid boolean literal prefix, but had '" + consumeStringLenient() + '\'', 0, null, 6);
                throw null;
            }
        }
        this.journalMode = str.length() + i;
    }

    public String consumeKeyString() {
        String string;
        StringBuilder sb = (StringBuilder) this.typeConverters;
        String str = (String) this.autoMigrationSpecs;
        consumeNextToken('\"');
        int i = this.journalMode;
        int iIndexOf$default = StringsKt.indexOf$default(str, '\"', i, 4);
        if (iIndexOf$default == -1) {
            consumeStringLenient();
            fail$kotlinx_serialization_json((byte) 1, false);
            throw null;
        }
        int i2 = i;
        while (i2 < iIndexOf$default) {
            if (str.charAt(i2) == '\\') {
                int iPrefetchOrEof = this.journalMode;
                char cCharAt = str.charAt(i2);
                boolean z = false;
                while (cCharAt != '\"') {
                    if (cCharAt == '\\') {
                        sb.append((CharSequence) str, iPrefetchOrEof, i2);
                        int iPrefetchOrEof2 = prefetchOrEof(i2 + 1);
                        if (iPrefetchOrEof2 == -1) {
                            fail$default(this, "Expected escape sequence to continue, got EOF", 0, null, 6);
                            throw null;
                        }
                        int iAppendHex = iPrefetchOrEof2 + 1;
                        char cCharAt2 = str.charAt(iPrefetchOrEof2);
                        if (cCharAt2 == 'u') {
                            iAppendHex = appendHex(str, iAppendHex);
                        } else {
                            char c = cCharAt2 < 'u' ? CharMappings.ESCAPE_2_CHAR[cCharAt2] : (char) 0;
                            if (c == 0) {
                                fail$default(this, "Invalid escaped char '" + cCharAt2 + '\'', 0, null, 6);
                                throw null;
                            }
                            sb.append(c);
                        }
                        iPrefetchOrEof = prefetchOrEof(iAppendHex);
                        if (iPrefetchOrEof == -1) {
                            fail$default(this, "Unexpected EOF", iPrefetchOrEof, null, 4);
                            throw null;
                        }
                    } else {
                        i2++;
                        if (i2 >= str.length()) {
                            sb.append((CharSequence) str, iPrefetchOrEof, i2);
                            iPrefetchOrEof = prefetchOrEof(i2);
                            if (iPrefetchOrEof == -1) {
                                fail$default(this, "Unexpected EOF", iPrefetchOrEof, null, 4);
                                throw null;
                            }
                        } else {
                            continue;
                        }
                        cCharAt = str.charAt(i2);
                    }
                    i2 = iPrefetchOrEof;
                    z = true;
                    cCharAt = str.charAt(i2);
                }
                if (z) {
                    sb.append((CharSequence) str, iPrefetchOrEof, i2);
                    String string2 = sb.toString();
                    sb.setLength(0);
                    string = string2;
                } else {
                    string = str.subSequence(iPrefetchOrEof, i2).toString();
                }
                this.journalMode = i2 + 1;
                return string;
            }
            i2++;
        }
        this.journalMode = iIndexOf$default + 1;
        return str.substring(i, iIndexOf$default);
    }

    public byte consumeNextToken() {
        String str = (String) this.autoMigrationSpecs;
        int i = this.journalMode;
        while (i != -1 && i < str.length()) {
            int i2 = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                this.journalMode = i2;
                return WriteModeKt.charToTokenClass(cCharAt);
            }
            i = i2;
        }
        this.journalMode = str.length();
        return (byte) 10;
    }

    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.String, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r6v9 */
    public long consumeNumericLiteral() {
        boolean z;
        boolean z2;
        long j;
        double dPow;
        int iPrefetchOrEof = prefetchOrEof(skipWhitespaces());
        String str = (String) this.autoMigrationSpecs;
        ?? r6 = 0;
        if (iPrefetchOrEof >= str.length() || iPrefetchOrEof == -1) {
            fail$default(this, "EOF", 0, null, 6);
            throw null;
        }
        if (str.charAt(iPrefetchOrEof) == '\"') {
            iPrefetchOrEof++;
            if (iPrefetchOrEof == str.length()) {
                fail$default(this, "EOF", 0, null, 6);
                throw null;
            }
            z = true;
        } else {
            z = false;
        }
        int i = iPrefetchOrEof;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        long j2 = 0;
        long j3 = 0;
        while (true) {
            if (i == str.length()) {
                z2 = z;
                break;
            }
            char cCharAt = str.charAt(i);
            if ((cCharAt != 'e' && cCharAt != 'E') || z4) {
                if (cCharAt == '-' && z4) {
                    if (i == iPrefetchOrEof) {
                        fail$default(this, "Unexpected symbol '-' in numeric literal", 0, null, 6);
                        throw null;
                    }
                    i++;
                    z3 = false;
                } else if (cCharAt != '+' || !z4) {
                    z2 = z;
                    if (cCharAt != '-') {
                        if (WriteModeKt.charToTokenClass(cCharAt) != 0) {
                            break;
                        }
                        i++;
                        int i2 = cCharAt - '0';
                        if (i2 < 0 || i2 >= 10) {
                            fail$default(this, "Unexpected symbol '" + cCharAt + "' in numeric literal", 0, null, 6);
                            throw null;
                        }
                        if (z4) {
                            j2 = (j2 * ((long) 10)) + ((long) i2);
                        } else {
                            j3 = (j3 * ((long) 10)) - ((long) i2);
                            if (j3 > 0) {
                                fail$default(this, "Numeric value overflow", 0, null, 6);
                                throw null;
                            }
                        }
                        z = z2;
                    } else {
                        if (i != iPrefetchOrEof) {
                            fail$default(this, "Unexpected symbol '-' in numeric literal", 0, null, 6);
                            throw null;
                        }
                        i++;
                        z = z2;
                        r6 = 0;
                        z5 = true;
                    }
                } else {
                    if (i == iPrefetchOrEof) {
                        fail$default(this, "Unexpected symbol '+' in numeric literal", 0, null, 6);
                        throw null;
                    }
                    i++;
                    r6 = 0;
                    z3 = true;
                }
                r6 = 0;
            } else {
                if (i == iPrefetchOrEof) {
                    fail$default(this, "Unexpected symbol " + cCharAt + " in numeric literal", 0, r6, 6);
                    throw r6;
                }
                i++;
                z3 = true;
                z4 = true;
            }
        }
        boolean z6 = i != iPrefetchOrEof;
        if (iPrefetchOrEof == i || (z5 && iPrefetchOrEof == i - 1)) {
            fail$default(this, "Expected numeric literal", 0, null, 6);
            throw null;
        }
        if (z2) {
            if (!z6) {
                fail$default(this, "EOF", 0, null, 6);
                throw null;
            }
            if (str.charAt(i) != '\"') {
                fail$default(this, "Expected closing quotation mark", 0, null, 6);
                throw null;
            }
            i++;
        }
        this.journalMode = i;
        long j4 = j3;
        if (z4) {
            double d = j4;
            if (!z3) {
                dPow = Math.pow(10.0d, -j2);
            } else {
                if (!z3) {
                    throw new HttpException();
                }
                dPow = Math.pow(10.0d, j2);
            }
            double d2 = d * dPow;
            if (d2 > 9.223372036854776E18d || d2 < -9.223372036854776E18d) {
                fail$default(this, "Numeric value overflow", 0, null, 6);
                throw null;
            }
            if (Math.floor(d2) != d2) {
                fail$default(this, "Can't convert " + d2 + " to Long", 0, null, 6);
                throw null;
            }
            j = (long) d2;
        } else {
            j = j4;
        }
        if (z5) {
            return j;
        }
        if (j != Long.MIN_VALUE) {
            return -j;
        }
        fail$default(this, "Numeric value overflow", 0, null, 6);
        throw null;
    }

    public String consumeString() {
        String str = (String) this.migrationContainer;
        if (str == null) {
            return consumeKeyString();
        }
        this.migrationContainer = null;
        return str;
    }

    public String consumeStringLenient() {
        String string;
        StringBuilder sb = (StringBuilder) this.typeConverters;
        String str = (String) this.autoMigrationSpecs;
        String str2 = (String) this.migrationContainer;
        if (str2 != null) {
            this.migrationContainer = null;
            return str2;
        }
        int iSkipWhitespaces = skipWhitespaces();
        if (iSkipWhitespaces >= str.length() || iSkipWhitespaces == -1) {
            fail$default(this, "EOF", iSkipWhitespaces, null, 4);
            throw null;
        }
        byte bCharToTokenClass = WriteModeKt.charToTokenClass(str.charAt(iSkipWhitespaces));
        if (bCharToTokenClass == 1) {
            return consumeString();
        }
        if (bCharToTokenClass != 0) {
            fail$default(this, "Expected beginning of the string, but got " + str.charAt(iSkipWhitespaces), 0, null, 6);
            throw null;
        }
        boolean z = false;
        while (WriteModeKt.charToTokenClass(str.charAt(iSkipWhitespaces)) == 0) {
            iSkipWhitespaces++;
            if (iSkipWhitespaces >= str.length()) {
                sb.append((CharSequence) str, this.journalMode, iSkipWhitespaces);
                int iPrefetchOrEof = prefetchOrEof(iSkipWhitespaces);
                if (iPrefetchOrEof == -1) {
                    this.journalMode = iSkipWhitespaces;
                    sb.append((CharSequence) str, 0, 0);
                    String string2 = sb.toString();
                    sb.setLength(0);
                    return string2;
                }
                iSkipWhitespaces = iPrefetchOrEof;
                z = true;
            }
        }
        if (z) {
            sb.append((CharSequence) str, this.journalMode, iSkipWhitespaces);
            String string3 = sb.toString();
            sb.setLength(0);
            string = string3;
        } else {
            string = str.subSequence(this.journalMode, iSkipWhitespaces).toString();
        }
        this.journalMode = iSkipWhitespaces;
        return string;
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object execute() {
        Boolean bool;
        TooltipPopup tooltipPopup = (TooltipPopup) this.context;
        ImageLoader$Builder imageLoader$Builder = (ImageLoader$Builder) tooltipPopup.mLayoutParams;
        EventStore eventStore = (EventStore) tooltipPopup.mMessageView;
        AutoValue_BackendResponse autoValue_BackendResponse = (AutoValue_BackendResponse) this.migrationContainer;
        Iterable iterable = (Iterable) this.typeConverters;
        AutoValue_TransportContext autoValue_TransportContext = (AutoValue_TransportContext) this.autoMigrationSpecs;
        int i = this.journalMode;
        int i2 = autoValue_BackendResponse.status;
        if (i2 == 2) {
            SQLiteEventStore sQLiteEventStore = (SQLiteEventStore) eventStore;
            sQLiteEventStore.getClass();
            if (iterable.iterator().hasNext()) {
                String str = "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + SQLiteEventStore.toIdList(iterable);
                SQLiteDatabase db = sQLiteEventStore.getDb();
                db.beginTransaction();
                try {
                    db.compileStatement(str).execute();
                    db.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
                    db.setTransactionSuccessful();
                    db.endTransaction();
                } catch (Throwable th) {
                    db.endTransaction();
                    throw th;
                }
            }
            imageLoader$Builder.schedule(autoValue_TransportContext, i + 1, false);
            return null;
        }
        SQLiteEventStore sQLiteEventStore2 = (SQLiteEventStore) eventStore;
        sQLiteEventStore2.getClass();
        if (iterable.iterator().hasNext()) {
            sQLiteEventStore2.getDb().compileStatement("DELETE FROM events WHERE _id in " + SQLiteEventStore.toIdList(iterable)).execute();
        }
        if (i2 == 1) {
            long time = ((Clock) tooltipPopup.mTmpAppPos).getTime() + autoValue_BackendResponse.nextRequestWaitMillis;
            sQLiteEventStore2.getClass();
            sQLiteEventStore2.inTransaction(new HeadersReader(time, autoValue_TransportContext));
        }
        SQLiteDatabase db2 = sQLiteEventStore2.getDb();
        db2.beginTransaction();
        try {
            Long transportContextId = SQLiteEventStore.getTransportContextId(db2, autoValue_TransportContext);
            if (transportContextId == null) {
                bool = Boolean.FALSE;
            } else {
                Cursor cursorRawQuery = sQLiteEventStore2.getDb().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{transportContextId.toString()});
                try {
                    Boolean boolValueOf = Boolean.valueOf(cursorRawQuery.moveToNext());
                    cursorRawQuery.close();
                    bool = boolValueOf;
                } catch (Throwable th2) {
                    cursorRawQuery.close();
                    throw th2;
                }
            }
            db2.setTransactionSuccessful();
            db2.endTransaction();
            if (!bool.booleanValue()) {
                return null;
            }
            imageLoader$Builder.schedule(autoValue_TransportContext, 1, true);
            return null;
        } catch (Throwable th3) {
            db2.endTransaction();
            throw th3;
        }
    }

    public void fail(int i, String str, String str2) {
        throw WriteModeKt.JsonDecodingException(i, (String) this.autoMigrationSpecs, str + " at path: " + ((RoomOpenHelper) this.context).getPath() + (str2.length() == 0 ? "" : "\n".concat(str2)));
    }

    public void fail$kotlinx_serialization_json(byte b, boolean z) {
        String str = (String) this.autoMigrationSpecs;
        String str2 = WriteModeKt.tokenDescription(b);
        int i = z ? this.journalMode - 1 : this.journalMode;
        fail$default(this, "Expected " + str2 + ", but had '" + ((this.journalMode == str.length() || i < 0) ? "EOF" : String.valueOf(str.charAt(i))) + "' instead", i, null, 4);
        throw null;
    }

    public int fromHexChar(CharSequence charSequence, int i) {
        char cCharAt = charSequence.charAt(i);
        if ('0' <= cCharAt && cCharAt < ':') {
            return cCharAt - '0';
        }
        if ('a' <= cCharAt && cCharAt < 'g') {
            return cCharAt - 'W';
        }
        if ('A' <= cCharAt && cCharAt < 'G') {
            return cCharAt - '7';
        }
        fail$default(this, "Invalid toHexChar char '" + cCharAt + "' in unicode escape", 0, null, 6);
        throw null;
    }

    public String getPairedConcurrentCameraId(String str) {
        HashMap map = (HashMap) this.migrationContainer;
        if (!map.containsKey(str)) {
            return null;
        }
        for (String str2 : (List) map.get(str)) {
            ArrayList arrayList = (ArrayList) this.typeConverters;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                CameraInfoInternal implementation = ((CameraInfoInternal) obj).getImplementation();
                Preconditions.checkArgument("CameraInfo doesn't contain Camera2 implementation.", implementation instanceof Camera2CameraInfoImpl);
                if (str2.equals(((Camera2CameraInfoImpl) ((Camera2CameraInfoImpl) implementation).mCamera2CameraInfo.this$0).mCameraId)) {
                    return str2;
                }
            }
        }
        return null;
    }

    public String peekLeadingMatchingValue(String str) {
        int i = this.journalMode;
        try {
            if (consumeNextToken() == 6 && Intrinsics.areEqual(peekString(), str)) {
                this.migrationContainer = null;
                if (consumeNextToken() == 5) {
                    return peekString();
                }
            }
            return null;
        } finally {
            this.journalMode = i;
            this.migrationContainer = null;
        }
    }

    public byte peekNextToken() {
        String str = (String) this.autoMigrationSpecs;
        int i = this.journalMode;
        while (true) {
            int iPrefetchOrEof = prefetchOrEof(i);
            if (iPrefetchOrEof == -1) {
                this.journalMode = iPrefetchOrEof;
                return (byte) 10;
            }
            char cCharAt = str.charAt(iPrefetchOrEof);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != ' ') {
                this.journalMode = iPrefetchOrEof;
                return WriteModeKt.charToTokenClass(cCharAt);
            }
            i = iPrefetchOrEof + 1;
        }
    }

    public String peekString() {
        if (peekNextToken() != 1) {
            return null;
        }
        String strConsumeString = consumeString();
        this.migrationContainer = strConsumeString;
        return strConsumeString;
    }

    public int prefetchOrEof(int i) {
        if (i < ((String) this.autoMigrationSpecs).length()) {
            return i;
        }
        return -1;
    }

    public int skipWhitespaces() {
        char cCharAt;
        int i = this.journalMode;
        if (i == -1) {
            return i;
        }
        String str = (String) this.autoMigrationSpecs;
        while (i < str.length() && ((cCharAt = str.charAt(i)) == ' ' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t')) {
            i++;
        }
        this.journalMode = i;
        return i;
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 4:
                StringBuilder sb = new StringBuilder("JsonReader(source='");
                sb.append(this.autoMigrationSpecs);
                sb.append("', currentPosition=");
                return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.journalMode, ')');
            default:
                return super.toString();
        }
    }

    public boolean tryConsumeComma() {
        int iSkipWhitespaces = skipWhitespaces();
        String str = (String) this.autoMigrationSpecs;
        if (iSkipWhitespaces >= str.length() || iSkipWhitespaces == -1 || str.charAt(iSkipWhitespaces) != ',') {
            return false;
        }
        this.journalMode++;
        return true;
    }

    public void unexpectedToken(char c) {
        int i = this.journalMode;
        if (i > 0 && c == '\"') {
            try {
                this.journalMode = i - 1;
                String strConsumeStringLenient = consumeStringLenient();
                this.journalMode = i;
                if (Intrinsics.areEqual(strConsumeStringLenient, "null")) {
                    fail(this.journalMode - 1, "Expected string literal but 'null' literal was found", "Use 'coerceInputValues = true' in 'Json {}' builder to coerce nulls if property has a default value.");
                    throw null;
                }
            } catch (Throwable th) {
                this.journalMode = i;
                throw th;
            }
        }
        fail$kotlinx_serialization_json(WriteModeKt.charToTokenClass(c), true);
        throw null;
    }

    public DatabaseConfiguration(CameraManagerCompat cameraManagerCompat) {
        this.$r8$classId = 1;
        this.journalMode = 0;
        HashMap map = new HashMap();
        this.migrationContainer = map;
        this.autoMigrationSpecs = new HashSet();
        this.context = new ArrayList();
        this.typeConverters = new ArrayList();
        Set hashSet = new HashSet();
        try {
            hashSet = cameraManagerCompat.mImpl.getConcurrentCameraIds();
        } catch (CameraAccessExceptionCompat unused) {
            Logger.e("Camera2CameraCoordinator", "Failed to get concurrent camera ids");
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ArrayList arrayList = new ArrayList((Set) it.next());
            if (arrayList.size() >= 2) {
                String str = (String) arrayList.get(0);
                String str2 = (String) arrayList.get(1);
                try {
                    if (CameraIdUtil.isBackwardCompatible(cameraManagerCompat, str) && CameraIdUtil.isBackwardCompatible(cameraManagerCompat, str2)) {
                        ((HashSet) this.autoMigrationSpecs).add(new HashSet(Arrays.asList(str, str2)));
                        if (!map.containsKey(str)) {
                            map.put(str, new ArrayList());
                        }
                        if (!map.containsKey(str2)) {
                            map.put(str2, new ArrayList());
                        }
                        ((List) map.get(str)).add((String) arrayList.get(1));
                        ((List) map.get(str2)).add((String) arrayList.get(0));
                    }
                } catch (InitializationException unused2) {
                    Logger.d("Camera2CameraCoordinator", "Concurrent camera id pair: (" + str + ", " + str2 + ") is not backward compatible");
                }
            }
        }
    }

    public void consumeNextToken(char c) {
        int i = this.journalMode;
        if (i != -1) {
            String str = (String) this.autoMigrationSpecs;
            while (i < str.length()) {
                int i2 = i + 1;
                char cCharAt = str.charAt(i);
                if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                    this.journalMode = i2;
                    if (cCharAt == c) {
                        return;
                    }
                    unexpectedToken(c);
                    throw null;
                }
                i = i2;
            }
            this.journalMode = -1;
            unexpectedToken(c);
            throw null;
        }
        unexpectedToken(c);
        throw null;
    }

    public byte consumeNextToken(byte b) {
        byte bConsumeNextToken = consumeNextToken();
        if (bConsumeNextToken == b) {
            return bConsumeNextToken;
        }
        fail$kotlinx_serialization_json(b, true);
        throw null;
    }

    public DatabaseConfiguration(String str) {
        this.$r8$classId = 4;
        RoomOpenHelper roomOpenHelper = new RoomOpenHelper((char) 0, 13);
        roomOpenHelper.mConfiguration = new Object[8];
        int[] iArr = new int[8];
        for (int i = 0; i < 8; i++) {
            iArr[i] = -1;
        }
        roomOpenHelper.mDelegate = iArr;
        roomOpenHelper.version = -1;
        this.context = roomOpenHelper;
        this.typeConverters = new StringBuilder();
        this.autoMigrationSpecs = str;
    }

    public DatabaseConfiguration(Class cls, Class[] clsArr) {
        this.$r8$classId = 3;
        HashSet hashSet = new HashSet();
        this.context = hashSet;
        this.migrationContainer = new HashSet();
        this.journalMode = 0;
        this.autoMigrationSpecs = new HashSet();
        hashSet.add(cls);
        for (Class cls2 : clsArr) {
            com.google.firebase.components.Preconditions.checkNotNull(cls2, "Null interface");
        }
        Collections.addAll((HashSet) this.context, clsArr);
    }

    public DatabaseConfiguration(Context context, ByteString.Companion companion, MemoryCacheService memoryCacheService, int i) {
        this.$r8$classId = 0;
        this.context = context;
        this.migrationContainer = memoryCacheService;
        this.journalMode = i;
        List list = Collections.EMPTY_LIST;
        this.typeConverters = list;
        this.autoMigrationSpecs = list;
    }
}
