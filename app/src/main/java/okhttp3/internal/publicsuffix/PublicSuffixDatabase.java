package okhttp3.internal.publicsuffix;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import com.google.android.gms.dynamite.zze;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.io.CloseableKt;
import kotlin.io.LinesSequence;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.DropSequence;
import kotlin.sequences.DropTakeSequence;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__AppendableKt;
import okhttp3.internal.platform.Platform;
import okio.GzipSource;
import okio.Okio;
import okio.RealBufferedSource;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class PublicSuffixDatabase {
    public byte[] publicSuffixExceptionListBytes;
    public byte[] publicSuffixListBytes;
    public static final byte[] WILDCARD_LABEL = {42};
    public static final List PREVAILING_RULE = Collections.singletonList("*");
    public static final PublicSuffixDatabase instance = new PublicSuffixDatabase();
    public final AtomicBoolean listRead = new AtomicBoolean(false);
    public final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    public static List splitDomain(String str) {
        List listSplit$default = StringsKt.split$default(str, new char[]{'.'});
        return Intrinsics.areEqual(CollectionsKt.last(listSplit$default), "") ? CollectionsKt.dropLast(listSplit$default) : listSplit$default;
    }

    public final String getEffectiveTldPlusOne(String str) {
        String strAccess$binarySearch;
        String strAccess$binarySearch2;
        String strAccess$binarySearch3;
        int size;
        int size2;
        List listSplitDomain = splitDomain(IDN.toUnicode(str));
        List listSplit$default = EmptyList.INSTANCE;
        int i = 0;
        if (this.listRead.get() || !this.listRead.compareAndSet(false, true)) {
            try {
                this.readCompleteLatch.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            boolean z = false;
            while (true) {
                try {
                    try {
                        readTheList();
                        break;
                    } catch (InterruptedIOException unused2) {
                        Thread.interrupted();
                        z = true;
                    } catch (IOException e) {
                        Platform platform = Platform.platform;
                        Platform.platform.getClass();
                        Platform.log("Failed to read public suffix list", 5, e);
                        if (z) {
                        }
                    }
                } catch (Throwable th) {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        }
        if (this.publicSuffixListBytes == null) {
            throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
        }
        int size3 = listSplitDomain.size();
        byte[][] bArr = new byte[size3][];
        for (int i2 = 0; i2 < size3; i2++) {
            bArr[i2] = ((String) listSplitDomain.get(i2)).getBytes(StandardCharsets.UTF_8);
        }
        int i3 = 0;
        while (true) {
            if (i3 >= size3) {
                strAccess$binarySearch = null;
                break;
            }
            byte[] bArr2 = this.publicSuffixListBytes;
            if (bArr2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");
                throw null;
            }
            strAccess$binarySearch = zze.access$binarySearch(bArr2, bArr, i3);
            if (strAccess$binarySearch != null) {
                break;
            }
            i3++;
        }
        if (size3 <= 1) {
            strAccess$binarySearch2 = null;
            break;
        }
        byte[][] bArr3 = (byte[][]) bArr.clone();
        int length = bArr3.length - 1;
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                strAccess$binarySearch2 = null;
                break;
            }
            bArr3[i4] = WILDCARD_LABEL;
            byte[] bArr4 = this.publicSuffixListBytes;
            if (bArr4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");
                throw null;
            }
            strAccess$binarySearch2 = zze.access$binarySearch(bArr4, bArr3, i4);
            if (strAccess$binarySearch2 != null) {
                break;
            }
            i4++;
        }
        if (strAccess$binarySearch2 == null) {
            strAccess$binarySearch3 = null;
            break;
        }
        int i5 = size3 - 1;
        int i6 = 0;
        while (true) {
            if (i6 >= i5) {
                strAccess$binarySearch3 = null;
                break;
            }
            byte[] bArr5 = this.publicSuffixExceptionListBytes;
            if (bArr5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publicSuffixExceptionListBytes");
                throw null;
            }
            strAccess$binarySearch3 = zze.access$binarySearch(bArr5, bArr, i6);
            if (strAccess$binarySearch3 != null) {
                break;
            }
            i6++;
        }
        if (strAccess$binarySearch3 != null) {
            listSplit$default = StringsKt.split$default("!".concat(strAccess$binarySearch3), new char[]{'.'});
        } else if (strAccess$binarySearch == null && strAccess$binarySearch2 == null) {
            listSplit$default = PREVAILING_RULE;
        } else {
            List listSplit$default2 = strAccess$binarySearch != null ? StringsKt.split$default(strAccess$binarySearch, new char[]{'.'}) : listSplit$default;
            if (strAccess$binarySearch2 != null) {
                listSplit$default = StringsKt.split$default(strAccess$binarySearch2, new char[]{'.'});
            }
            if (listSplit$default2.size() > listSplit$default.size()) {
                listSplit$default = listSplit$default2;
            }
        }
        if (listSplitDomain.size() == listSplit$default.size() && ((String) listSplit$default.get(0)).charAt(0) != '!') {
            return null;
        }
        if (((String) listSplit$default.get(0)).charAt(0) == '!') {
            size = listSplitDomain.size();
            size2 = listSplit$default.size();
        } else {
            size = listSplitDomain.size();
            size2 = listSplit$default.size() + 1;
        }
        int i7 = size - size2;
        Sequence linesSequence = new LinesSequence(2, splitDomain(str));
        if (i7 < 0) {
            throw new IllegalArgumentException(CaptureSession$State$EnumUnboxingLocalUtility.m(i7, "Requested element count ", " is less than zero.").toString());
        }
        if (i7 != 0) {
            linesSequence = linesSequence instanceof DropTakeSequence ? ((DropTakeSequence) linesSequence).drop(i7) : new DropSequence(linesSequence, i7);
        }
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        for (Object obj : linesSequence) {
            i++;
            if (i > 1) {
                sb.append((CharSequence) ".");
            }
            StringsKt__AppendableKt.appendElement(sb, obj, null);
        }
        sb.append((CharSequence) "");
        return sb.toString();
    }

    public final void readTheList() {
        try {
            InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
            if (resourceAsStream != null) {
                RealBufferedSource realBufferedSource = new RealBufferedSource(new GzipSource(Okio.source(resourceAsStream)));
                try {
                    long j = realBufferedSource.readInt();
                    realBufferedSource.require(j);
                    byte[] byteArray = realBufferedSource.bufferField.readByteArray(j);
                    long j2 = realBufferedSource.readInt();
                    realBufferedSource.require(j2);
                    byte[] byteArray2 = realBufferedSource.bufferField.readByteArray(j2);
                    Unit unit = Unit.INSTANCE;
                    realBufferedSource.close();
                    synchronized (this) {
                        this.publicSuffixListBytes = byteArray;
                        this.publicSuffixExceptionListBytes = byteArray2;
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(realBufferedSource, th);
                        throw th2;
                    }
                }
            }
            this.readCompleteLatch.countDown();
        } catch (Throwable th3) {
            this.readCompleteLatch.countDown();
            throw th3;
        }
    }
}
