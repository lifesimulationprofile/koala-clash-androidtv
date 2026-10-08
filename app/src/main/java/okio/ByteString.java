package okio;

import android.content.Context;
import android.graphics.Typeface;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.text.font.AndroidFontUtils_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.compose.ui.text.font.PlatformTypefaces;
import androidx.core.view.ScrollFeedbackProviderCompat;
import androidx.fragment.app.FragmentManagerViewModel;
import androidx.lifecycle.AtomicReference;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.internal.DefaultViewModelProviderFactory;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.zze;
import com.google.android.material.internal.ViewUtils;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.RestrictedComponentContainer;
import com.google.mlkit.common.model.RemoteModelManager;
import com.google.mlkit.common.sdkinternal.ExecutorSelector;
import com.google.mlkit.common.sdkinternal.MlKitContext;
import com.google.mlkit.vision.barcode.internal.zzg;
import com.google.mlkit.vision.barcode.internal.zzi;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.collections.ArraysKt__ArraysJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.selects.SelectClause0;
import okio.internal.ZipFilesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class ByteString implements Serializable, Comparable {
    public static final ByteString EMPTY = new ByteString(new byte[0]);
    public final byte[] data;
    public transient int hashCode;
    public transient String utf8;

    public ByteString(byte[] bArr) {
        this.data = bArr;
    }

    public static int indexOf$default(ByteString byteString, ByteString byteString2) {
        byteString.getClass();
        return byteString.indexOf(0, byteString2.internalArray$okio());
    }

    public static /* synthetic */ ByteString substring$default(ByteString byteString, int i, int i2, int i3) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = -1234567890;
        }
        return byteString.substring(i, i2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            int size$okio = byteString.getSize$okio();
            byte[] bArr = this.data;
            if (size$okio == bArr.length && byteString.rangeEquals(0, 0, bArr.length, bArr)) {
                return true;
            }
        }
        return false;
    }

    public int getSize$okio() {
        return this.data.length;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.data);
        this.hashCode = iHashCode;
        return iHashCode;
    }

    public String hex() {
        byte[] bArr = this.data;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = ZipFilesKt.HEX_DIGIT_CHARS;
            cArr[i] = cArr2[(b >> 4) & 15];
            i += 2;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public int indexOf(int i, byte[] bArr) {
        byte[] bArr2 = this.data;
        int length = bArr2.length - bArr.length;
        int iMax = Math.max(i, 0);
        if (iMax > length) {
            return -1;
        }
        while (!SegmentedByteString.arrayRangeEquals(bArr2, iMax, bArr, 0, bArr.length)) {
            if (iMax == length) {
                return -1;
            }
            iMax++;
        }
        return iMax;
    }

    public byte[] internalArray$okio() {
        return this.data;
    }

    public byte internalGet$okio(int i) {
        return this.data[i];
    }

    public int lastIndexOf(byte[] bArr) {
        int size$okio = getSize$okio();
        byte[] bArr2 = this.data;
        for (int iMin = Math.min(size$okio, bArr2.length - bArr.length); -1 < iMin; iMin--) {
            if (SegmentedByteString.arrayRangeEquals(bArr2, iMin, bArr, 0, bArr.length)) {
                return iMin;
            }
        }
        return -1;
    }

    public boolean rangeEquals(int i, ByteString byteString, int i2) {
        return byteString.rangeEquals(0, i, i2, this.data);
    }

    public ByteString substring(int i, int i2) {
        if (i2 == -1234567890) {
            i2 = getSize$okio();
        }
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.data;
        if (i2 > bArr.length) {
            throw new IllegalArgumentException(ImageAnalysis$$ExternalSyntheticLambda1.m(new StringBuilder("endIndex > length("), bArr.length, ')').toString());
        }
        if (i2 - i < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        if (i == 0 && i2 == bArr.length) {
            return this;
        }
        ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(i2, bArr.length);
        return new ByteString(Arrays.copyOfRange(bArr, i, i2));
    }

    public ByteString toAsciiLowercase() {
        int i = 0;
        while (true) {
            byte[] bArr = this.data;
            if (i >= bArr.length) {
                return this;
            }
            byte b = bArr[i];
            if (b >= 65 && b <= 90) {
                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                bArrCopyOf[i] = (byte) (b + 32);
                for (int i2 = i + 1; i2 < bArrCopyOf.length; i2++) {
                    byte b2 = bArrCopyOf[i2];
                    if (b2 >= 65 && b2 <= 90) {
                        bArrCopyOf[i2] = (byte) (b2 + 32);
                    }
                }
                return new ByteString(bArrCopyOf);
            }
            i++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:179:0x01bc A[EDGE_INSN: B:179:0x01bc->B:180:0x01bd BREAK  A[LOOP:0: B:7:0x000e->B:241:0x000e]] */
    public String toString() {
        ByteString byteString;
        byte b;
        int i;
        byte[] bArr = this.data;
        if (bArr.length == 0) {
            return "[size=0]";
        }
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        loop0: while (i2 < length) {
            byte b2 = bArr[i2];
            if (b2 < 0) {
                if ((b2 >> 5) != -2) {
                    if ((b2 >> 4) != -2) {
                        if ((b2 >> 3) != -2) {
                            if (i4 == 64) {
                                break;
                            }
                            i3 = -1;
                            break;
                        }
                        int i5 = i2 + 3;
                        if (length > i5) {
                            byte b3 = bArr[i2 + 1];
                            if ((b3 & 192) != 128) {
                                if (i4 == 64) {
                                    break;
                                }
                                i3 = -1;
                                break;
                            }
                            byte b4 = bArr[i2 + 2];
                            if ((b4 & 192) != 128) {
                                if (i4 == 64) {
                                    break;
                                }
                                i3 = -1;
                                break;
                            }
                            byte b5 = bArr[i5];
                            if ((b5 & 192) != 128) {
                                if (i4 == 64) {
                                    break;
                                }
                                i3 = -1;
                                break;
                            }
                            int i6 = (((b5 ^ 3678080) ^ (b4 << 6)) ^ (b3 << 12)) ^ (b2 << 18);
                            if (i6 <= 1114111) {
                                if (55296 <= i6 && i6 < 57344) {
                                    if (i4 == 64) {
                                        break;
                                    }
                                    i3 = -1;
                                    break;
                                }
                                if (i6 >= 65536) {
                                    i = i4 + 1;
                                    if (i4 == 64) {
                                        break;
                                    }
                                    if ((i6 != 10 && i6 != 13 && ((i6 >= 0 && i6 < 32) || (127 <= i6 && i6 < 160))) || i6 == 65533) {
                                        i3 = -1;
                                        break;
                                    }
                                    i3 += i6 < 65536 ? 1 : 2;
                                    Unit unit = Unit.INSTANCE;
                                    i2 += 4;
                                    i4 = i;
                                } else {
                                    if (i4 == 64) {
                                        break;
                                    }
                                    i3 = -1;
                                    break;
                                }
                            } else {
                                if (i4 == 64) {
                                    break;
                                }
                                i3 = -1;
                                break;
                            }
                        } else {
                            if (i4 == 64) {
                                break;
                            }
                            i3 = -1;
                            break;
                        }
                    } else {
                        int i7 = i2 + 2;
                        if (length > i7) {
                            byte b6 = bArr[i2 + 1];
                            if ((b6 & 192) != 128) {
                                if (i4 == 64) {
                                    break;
                                }
                                i3 = -1;
                                break;
                            }
                            byte b7 = bArr[i7];
                            if ((b7 & 192) != 128) {
                                if (i4 == 64) {
                                    break;
                                }
                                i3 = -1;
                                break;
                            }
                            int i8 = ((b7 ^ (-123008)) ^ (b6 << 6)) ^ (b2 << 12);
                            if (i8 >= 2048) {
                                if (55296 <= i8 && i8 < 57344) {
                                    if (i4 == 64) {
                                        break;
                                    }
                                    i3 = -1;
                                    break;
                                }
                                i = i4 + 1;
                                if (i4 == 64) {
                                    break;
                                }
                                if ((i8 != 10 && i8 != 13 && ((i8 >= 0 && i8 < 32) || (127 <= i8 && i8 < 160))) || i8 == 65533) {
                                    i3 = -1;
                                    break;
                                }
                                i3 += i8 < 65536 ? 1 : 2;
                                Unit unit2 = Unit.INSTANCE;
                                i2 += 3;
                                i4 = i;
                            } else {
                                if (i4 == 64) {
                                    break;
                                }
                                i3 = -1;
                                break;
                            }
                        } else {
                            if (i4 == 64) {
                                break;
                            }
                            i3 = -1;
                            break;
                        }
                    }
                } else {
                    int i9 = i2 + 1;
                    if (length > i9) {
                        byte b8 = bArr[i9];
                        if ((b8 & 192) != 128) {
                            if (i4 == 64) {
                                break;
                            }
                            i3 = -1;
                            break;
                        }
                        int i10 = (b8 ^ 3968) ^ (b2 << 6);
                        if (i10 >= 128) {
                            i = i4 + 1;
                            if (i4 == 64) {
                                break;
                            }
                            if ((i10 != 10 && i10 != 13 && ((i10 >= 0 && i10 < 32) || (127 <= i10 && i10 < 160))) || i10 == 65533) {
                                i3 = -1;
                                break;
                            }
                            i3 += i10 < 65536 ? 1 : 2;
                            Unit unit3 = Unit.INSTANCE;
                            i2 += 2;
                            i4 = i;
                        } else {
                            if (i4 == 64) {
                                break;
                            }
                            i3 = -1;
                            break;
                        }
                    } else {
                        if (i4 == 64) {
                            break;
                        }
                        i3 = -1;
                        break;
                    }
                }
            } else {
                int i11 = i4 + 1;
                if (i4 == 64) {
                    break;
                }
                if ((b2 == 10 || b2 == 13 || ((b2 < 0 || b2 >= 32) && (127 > b2 || b2 >= 160))) && b2 != 65533) {
                    i3 += b2 < 65536 ? 1 : 2;
                    i2++;
                    while (true) {
                        i4 = i11;
                        if (i2 < length && (b = bArr[i2]) >= 0) {
                            i2++;
                            i11 = i4 + 1;
                            if (i4 == 64) {
                                break loop0;
                            }
                            if ((b == 10 || b == 13 || ((b < 0 || b >= 32) && (127 > b || b >= 160))) && b != 65533) {
                                i3 += b < 65536 ? 1 : 2;
                            }
                        }
                    }
                }
                i3 = -1;
                break;
            }
        }
        if (i3 != -1) {
            String strUtf8 = utf8();
            String strReplace$default = StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(strUtf8.substring(0, i3), "\\", "\\\\"), "\n", "\\n"), "\r", "\\r");
            if (i3 >= strUtf8.length()) {
                return "[text=" + strReplace$default + ']';
            }
            return "[size=" + bArr.length + " text=" + strReplace$default + "…]";
        }
        if (bArr.length <= 64) {
            return "[hex=" + hex() + ']';
        }
        StringBuilder sb = new StringBuilder("[size=");
        sb.append(bArr.length);
        sb.append(" hex=");
        if (64 > bArr.length) {
            throw new IllegalArgumentException(ImageAnalysis$$ExternalSyntheticLambda1.m(new StringBuilder("endIndex > length("), bArr.length, ')').toString());
        }
        if (64 == bArr.length) {
            byteString = this;
        } else {
            ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(64, bArr.length);
            byteString = new ByteString(Arrays.copyOfRange(bArr, 0, 64));
        }
        sb.append(byteString.hex());
        sb.append("…]");
        return sb.toString();
    }

    public final String utf8() {
        String str = this.utf8;
        if (str != null) {
            return str;
        }
        String str2 = new String(internalArray$okio(), Charsets.UTF_8);
        this.utf8 = str2;
        return str2;
    }

    public void write$okio(Buffer buffer, int i) {
        buffer.write(i, this.data);
    }

    @Override // java.lang.Comparable
    public final int compareTo(ByteString byteString) {
        int size$okio = getSize$okio();
        int size$okio2 = byteString.getSize$okio();
        int iMin = Math.min(size$okio, size$okio2);
        for (int i = 0; i < iMin; i++) {
            int iInternalGet$okio = internalGet$okio(i) & 255;
            int iInternalGet$okio2 = byteString.internalGet$okio(i) & 255;
            if (iInternalGet$okio != iInternalGet$okio2) {
                return iInternalGet$okio < iInternalGet$okio2 ? -1 : 1;
            }
        }
        if (size$okio == size$okio2) {
            return 0;
        }
        return size$okio < size$okio2 ? -1 : 1;
    }

    public boolean rangeEquals(int i, int i2, int i3, byte[] bArr) {
        if (i < 0) {
            return false;
        }
        byte[] bArr2 = this.data;
        return i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && SegmentedByteString.arrayRangeEquals(bArr2, i, bArr, i2, i3);
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Companion implements PlatformTypefaces, ScrollFeedbackProviderCompat.ScrollFeedbackProviderImpl, Clock, DynamiteModule.VersionPolicy, ComponentFactory, SelectClause0 {
        public final /* synthetic */ int $r8$classId;

        public /* synthetic */ Companion(int i) {
            this.$r8$classId = i;
        }

        public static AtomicReference create$default(ViewModelStoreOwner viewModelStoreOwner, FragmentManagerViewModel.AnonymousClass1 anonymousClass1, int i) {
            ViewModelProvider$Factory defaultViewModelProviderFactory = anonymousClass1;
            if ((i & 2) != 0) {
                defaultViewModelProviderFactory = viewModelStoreOwner instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) viewModelStoreOwner).getDefaultViewModelProviderFactory() : DefaultViewModelProviderFactory.INSTANCE;
            }
            return new AtomicReference(viewModelStoreOwner.getViewModelStore(), defaultViewModelProviderFactory, viewModelStoreOwner instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) viewModelStoreOwner).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE);
        }

        /* JADX INFO: renamed from: createAndroidTypefaceUsingTypefaceStyle-RetOiIg, reason: not valid java name */
        public static Typeface m861createAndroidTypefaceUsingTypefaceStyleRetOiIg(String str, FontWeight fontWeight, int i) {
            if (i == 0 && Intrinsics.areEqual(fontWeight, FontWeight.Normal) && (str == null || str.length() == 0)) {
                return Typeface.DEFAULT;
            }
            int iM655getAndroidTypefaceStyleFO1MlWM = AndroidFontUtils_androidKt.m655getAndroidTypefaceStyleFO1MlWM(fontWeight, i);
            return (str == null || str.length() == 0) ? Typeface.defaultFromStyle(iM655getAndroidTypefaceStyleFO1MlWM) : Typeface.create(str, iM655getAndroidTypefaceStyleFO1MlWM);
        }

        public static ByteString decodeHex(String str) {
            if (str.length() % 2 != 0) {
                throw new IllegalArgumentException("Unexpected hex string: ".concat(str).toString());
            }
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) (ZipFilesKt.access$decodeHexDigit(str.charAt(i2 + 1)) + (ZipFilesKt.access$decodeHexDigit(str.charAt(i2)) << 4));
            }
            return new ByteString(bArr);
        }

        public static ByteString encodeUtf8(String str) {
            ByteString byteString = new ByteString(str.getBytes(Charsets.UTF_8));
            byteString.utf8 = str;
            return byteString;
        }

        @Override // com.google.firebase.components.ComponentFactory
        public Object create(RestrictedComponentContainer restrictedComponentContainer) {
            switch (this.$r8$classId) {
                case 17:
                    return new RemoteModelManager(restrictedComponentContainer.setOf(RemoteModelManager.RemoteModelManagerRegistration.class));
                case 18:
                    return new RemoteModelManager.RemoteModelManagerRegistration(restrictedComponentContainer.getProvider(zze.class));
                default:
                    return new zzg((zzi) restrictedComponentContainer.get(zzi.class), (ExecutorSelector) restrictedComponentContainer.get(ExecutorSelector.class), (MlKitContext) restrictedComponentContainer.get(MlKitContext.class));
            }
        }

        @Override // androidx.compose.ui.text.font.PlatformTypefaces
        /* JADX INFO: renamed from: createDefault-FO1MlWM */
        public Typeface mo657createDefaultFO1MlWM(FontWeight fontWeight, int i) {
            return m861createAndroidTypefaceUsingTypefaceStyleRetOiIg(null, fontWeight, i);
        }

        @Override // androidx.compose.ui.text.font.PlatformTypefaces
        /* JADX INFO: renamed from: createNamed-RetOiIg */
        public Typeface mo658createNamedRetOiIg(GenericFontFamily genericFontFamily, FontWeight fontWeight, int i) {
            String strConcat = genericFontFamily.name;
            int i2 = fontWeight.weight / 100;
            if (i2 >= 0 && i2 < 2) {
                strConcat = strConcat.concat("-thin");
            } else if (2 <= i2 && i2 < 4) {
                strConcat = strConcat.concat("-light");
            } else if (i2 != 4) {
                if (i2 == 5) {
                    strConcat = strConcat.concat("-medium");
                } else if ((6 > i2 || i2 >= 8) && 8 <= i2 && i2 < 11) {
                    strConcat = strConcat.concat("-black");
                }
            }
            Typeface typeface = null;
            if (strConcat.length() != 0) {
                Typeface typefaceM861createAndroidTypefaceUsingTypefaceStyleRetOiIg = m861createAndroidTypefaceUsingTypefaceStyleRetOiIg(strConcat, fontWeight, i);
                if (!Intrinsics.areEqual(typefaceM861createAndroidTypefaceUsingTypefaceStyleRetOiIg, Typeface.create(Typeface.DEFAULT, AndroidFontUtils_androidKt.m655getAndroidTypefaceStyleFO1MlWM(fontWeight, i))) && !Intrinsics.areEqual(typefaceM861createAndroidTypefaceUsingTypefaceStyleRetOiIg, m861createAndroidTypefaceUsingTypefaceStyleRetOiIg(null, fontWeight, i))) {
                    typeface = typefaceM861createAndroidTypefaceUsingTypefaceStyleRetOiIg;
                }
            }
            return typeface == null ? m861createAndroidTypefaceUsingTypefaceStyleRetOiIg(genericFontFamily.name, fontWeight, i) : typeface;
        }

        @Override // com.google.android.datatransport.runtime.time.Clock
        public long getTime() {
            return System.currentTimeMillis();
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
        public ViewUtils.RelativePadding selectModule(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) {
            ViewUtils.RelativePadding relativePadding = new ViewUtils.RelativePadding();
            int iZza = iVersions.zza(context, str);
            relativePadding.start = iZza;
            if (iZza != 0) {
                relativePadding.bottom = -1;
                return relativePadding;
            }
            int iZzb = iVersions.zzb(context, str, true);
            relativePadding.end = iZzb;
            if (iZzb != 0) {
                relativePadding.bottom = 1;
            }
            return relativePadding;
        }

        @Override // androidx.core.view.ScrollFeedbackProviderCompat.ScrollFeedbackProviderImpl
        public void onScrollLimit(int i, int i2, int i3, boolean z) {
        }

        @Override // androidx.core.view.ScrollFeedbackProviderCompat.ScrollFeedbackProviderImpl
        public void onScrollProgress(int i, int i2, int i3, int i4) {
        }
    }
}
