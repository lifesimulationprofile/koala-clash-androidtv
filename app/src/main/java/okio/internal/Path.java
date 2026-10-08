package okio.internal;

import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okio.Buffer;
import okio.ByteString;

/* JADX INFO: renamed from: okio.internal.-Path, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class Path {
    public static final ByteString ANY_SLASH;
    public static final ByteString BACKSLASH;
    public static final ByteString DOT;
    public static final ByteString DOT_DOT;
    public static final ByteString SLASH;

    static {
        ByteString byteString = new ByteString("/".getBytes(Charsets.UTF_8));
        byteString.utf8 = "/";
        SLASH = byteString;
        ByteString byteString2 = new ByteString("\\".getBytes(Charsets.UTF_8));
        byteString2.utf8 = "\\";
        BACKSLASH = byteString2;
        ByteString byteString3 = new ByteString("/\\".getBytes(Charsets.UTF_8));
        byteString3.utf8 = "/\\";
        ANY_SLASH = byteString3;
        ByteString byteString4 = new ByteString(".".getBytes(Charsets.UTF_8));
        byteString4.utf8 = ".";
        DOT = byteString4;
        ByteString byteString5 = new ByteString("..".getBytes(Charsets.UTF_8));
        byteString5.utf8 = "..";
        DOT_DOT = byteString5;
    }

    public static final int access$rootLength(okio.Path path) {
        ByteString byteString = path.bytes;
        if (byteString.getSize$okio() != 0) {
            if (byteString.internalGet$okio(0) != 47) {
                if (byteString.internalGet$okio(0) == 92) {
                    if (byteString.getSize$okio() > 2 && byteString.internalGet$okio(1) == 92) {
                        int iIndexOf = byteString.indexOf(2, BACKSLASH.internalArray$okio());
                        return iIndexOf == -1 ? byteString.getSize$okio() : iIndexOf;
                    }
                } else if (byteString.getSize$okio() > 2 && byteString.internalGet$okio(1) == 58 && byteString.internalGet$okio(2) == 92) {
                    char cInternalGet$okio = (char) byteString.internalGet$okio(0);
                    if ('a' <= cInternalGet$okio && cInternalGet$okio < '{') {
                        return 3;
                    }
                    if ('A' <= cInternalGet$okio && cInternalGet$okio < '[') {
                        return 3;
                    }
                }
            }
            return 1;
        }
        return -1;
    }

    public static final okio.Path commonResolve(okio.Path path, okio.Path path2, boolean z) {
        if (access$rootLength(path2) != -1 || path2.volumeLetter() != null) {
            return path2;
        }
        ByteString slash = getSlash(path);
        if (slash == null && (slash = getSlash(path2)) == null) {
            slash = toSlash(okio.Path.DIRECTORY_SEPARATOR);
        }
        Buffer buffer = new Buffer();
        buffer.m856write(path.bytes);
        if (buffer.size > 0) {
            buffer.m856write(slash);
        }
        buffer.m856write(path2.bytes);
        return toPath(buffer, z);
    }

    public static final ByteString getSlash(okio.Path path) {
        ByteString byteString = path.bytes;
        ByteString byteString2 = SLASH;
        if (ByteString.indexOf$default(byteString, byteString2) != -1) {
            return byteString2;
        }
        ByteString byteString3 = path.bytes;
        ByteString byteString4 = BACKSLASH;
        if (ByteString.indexOf$default(byteString3, byteString4) != -1) {
            return byteString4;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0119 A[EDGE_INSN: B:101:0x0119->B:84:0x0119 BREAK  A[LOOP:1: B:53:0x00a9->B:116:0x00a9], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:102:0x0107 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:114:0x00cf A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:127:0x0125 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:55:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:57:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:58:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:86:0x0120 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:87:0x0122  */
    /* JADX WARN: Code duplicated, block: B:91:0x0137  */
    public static final okio.Path toPath(Buffer buffer, boolean z) {
        ByteString byteString;
        long j;
        char c;
        boolean z2;
        ArrayList arrayList;
        boolean zExhausted;
        ByteString byteString2;
        int size;
        int i;
        long jIndexOfElement;
        ByteString byteString3;
        ByteString byteString4;
        Buffer buffer2 = new Buffer();
        ByteString slash = null;
        int i2 = 0;
        while (true) {
            if (!buffer.rangeEquals(SLASH)) {
                byteString = BACKSLASH;
                if (!buffer.rangeEquals(byteString)) {
                    break;
                }
            }
            byte b = buffer.readByte();
            if (slash == null) {
                slash = toSlash(b);
            }
            i2++;
        }
        boolean z3 = i2 >= 2 && Intrinsics.areEqual(slash, byteString);
        ByteString byteString5 = ANY_SLASH;
        if (z3) {
            buffer2.m856write(slash);
            slash.write$okio(buffer2, slash.getSize$okio());
        } else {
            if (i2 <= 0) {
                long jIndexOfElement2 = buffer.indexOfElement(byteString5);
                if (slash == null) {
                    slash = jIndexOfElement2 == -1 ? toSlash(okio.Path.DIRECTORY_SEPARATOR) : toSlash(buffer.getByte(jIndexOfElement2));
                }
                if (Intrinsics.areEqual(slash, byteString) && buffer.size >= 2) {
                    j = -1;
                    if (buffer.getByte(1L) == 58 && (('a' <= (c = (char) buffer.getByte(0L)) && c < '{') || ('A' <= c && c < '['))) {
                        if (jIndexOfElement2 == 2) {
                            buffer2.write(3L, buffer);
                        } else {
                            buffer2.write(2L, buffer);
                        }
                    }
                }
                if (buffer2.size > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                arrayList = new ArrayList();
                while (true) {
                    zExhausted = buffer.exhausted();
                    byteString2 = DOT;
                    if (!zExhausted) {
                        break;
                    }
                    jIndexOfElement = buffer.indexOfElement(byteString5);
                    if (jIndexOfElement == j) {
                        byteString3 = buffer.readByteString(buffer.size);
                    } else {
                        byteString3 = buffer.readByteString(jIndexOfElement);
                        buffer.readByte();
                    }
                    byteString4 = DOT_DOT;
                    if (byteString3.equals(byteString4)) {
                        if (z2 || !arrayList.isEmpty()) {
                            if (z || (!z2 && (arrayList.isEmpty() || Intrinsics.areEqual(CollectionsKt.last(arrayList), byteString4)))) {
                                arrayList.add(byteString3);
                            } else if (!z3 || arrayList.size() != 1) {
                                if (!arrayList.isEmpty()) {
                                    arrayList.remove(AppCompatHintHelper.getLastIndex(arrayList));
                                }
                            }
                        }
                    } else if (byteString3.equals(byteString2) && !byteString3.equals(ByteString.EMPTY)) {
                        arrayList.add(byteString3);
                    }
                }
                size = arrayList.size();
                for (i = 0; i < size; i++) {
                    if (i > 0) {
                        buffer2.m856write(slash);
                    }
                    buffer2.m856write((ByteString) arrayList.get(i));
                }
                if (buffer2.size == 0) {
                    buffer2.m856write(byteString2);
                }
                return new okio.Path(buffer2.readByteString(buffer2.size));
            }
            buffer2.m856write(slash);
        }
        j = -1;
        if (buffer2.size > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        arrayList = new ArrayList();
        while (true) {
            zExhausted = buffer.exhausted();
            byteString2 = DOT;
            if (!zExhausted) {
                break;
                break;
            }
            jIndexOfElement = buffer.indexOfElement(byteString5);
            if (jIndexOfElement == j) {
                byteString3 = buffer.readByteString(buffer.size);
            } else {
                byteString3 = buffer.readByteString(jIndexOfElement);
                buffer.readByte();
            }
            byteString4 = DOT_DOT;
            if (byteString3.equals(byteString4)) {
                if (z2) {
                }
                if (z) {
                }
                arrayList.add(byteString3);
            } else if (byteString3.equals(byteString2)) {
            }
        }
        size = arrayList.size();
        while (i < size) {
            if (i > 0) {
                buffer2.m856write(slash);
            }
            buffer2.m856write((ByteString) arrayList.get(i));
        }
        if (buffer2.size == 0) {
            buffer2.m856write(byteString2);
        }
        return new okio.Path(buffer2.readByteString(buffer2.size));
    }

    public static final ByteString toSlash(String str) {
        if (Intrinsics.areEqual(str, "/")) {
            return SLASH;
        }
        if (Intrinsics.areEqual(str, "\\")) {
            return BACKSLASH;
        }
        throw new IllegalArgumentException(CaptureSession$State$EnumUnboxingLocalUtility.m("not a directory separator: ", str));
    }

    public static final ByteString toSlash(byte b) {
        if (b == 47) {
            return SLASH;
        }
        if (b == 92) {
            return BACKSLASH;
        }
        throw new IllegalArgumentException(ImageAnalysis$$ExternalSyntheticLambda1.m("not a directory separator: ", b));
    }
}
