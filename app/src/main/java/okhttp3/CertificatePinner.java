package okhttp3;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.camera.core.impl.Quirks;
import androidx.compose.material.icons.filled.LanKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import kotlin.collections.ArraysKt__ArraysJVMKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okio.Base64;
import okio.SegmentedByteString;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class CertificatePinner {
    public static final CertificatePinner DEFAULT = new CertificatePinner(CollectionsKt.toSet(new ArrayList()), null);
    public final LanKt certificateChainCleaner;
    public final Set pins;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class Companion {
        public static ImageVector _add;

        public static final ImageVector getAdd() {
            ImageVector imageVector = _add;
            if (imageVector != null) {
                return imageVector;
            }
            ImageVector.Builder builder = new ImageVector.Builder("Filled.Add", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
            int i = VectorKt.$r8$clinit;
            SolidColor solidColor = new SolidColor(Color.Black);
            Quirks quirks = new Quirks();
            quirks.moveTo(19.0f, 13.0f);
            quirks.horizontalLineToRelative(-6.0f);
            quirks.verticalLineToRelative(6.0f);
            quirks.horizontalLineToRelative(-2.0f);
            quirks.verticalLineToRelative(-6.0f);
            quirks.horizontalLineTo(5.0f);
            quirks.verticalLineToRelative(-2.0f);
            quirks.horizontalLineToRelative(6.0f);
            quirks.verticalLineTo(5.0f);
            quirks.horizontalLineToRelative(2.0f);
            quirks.verticalLineToRelative(6.0f);
            quirks.horizontalLineToRelative(6.0f);
            quirks.verticalLineToRelative(2.0f);
            quirks.close();
            ImageVector.Builder.m502addPathoIyEayM$default(builder, quirks.mQuirks, solidColor);
            ImageVector imageVectorBuild = builder.build();
            _add = imageVectorBuild;
            return imageVectorBuild;
        }

        public static String pin(X509Certificate x509Certificate) throws NoSuchAlgorithmException {
            if (!ImageAnalysis$$ExternalSyntheticLambda1.m17m((Object) x509Certificate)) {
                throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
            }
            StringBuilder sb = new StringBuilder("sha256/");
            byte[] encoded = x509Certificate.getPublicKey().getEncoded();
            int length = encoded.length;
            int i = 0;
            SegmentedByteString.checkOffsetAndCount(encoded.length, 0, length);
            ArraysKt__ArraysJVMKt.copyOfRangeToIndexCheck(length, encoded.length);
            byte[] bArrCopyOfRange = Arrays.copyOfRange(encoded, 0, length);
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(bArrCopyOfRange, 0, bArrCopyOfRange.length);
            byte[] bArrDigest = messageDigest.digest();
            byte[] bArr = Base64.BASE64;
            byte[] bArr2 = new byte[((bArrDigest.length + 2) / 3) * 4];
            int length2 = bArrDigest.length - (bArrDigest.length % 3);
            int i2 = 0;
            while (i < length2) {
                byte b = bArrDigest[i];
                int i3 = i + 2;
                byte b2 = bArrDigest[i + 1];
                i += 3;
                byte b3 = bArrDigest[i3];
                bArr2[i2] = bArr[(b & 255) >> 2];
                bArr2[i2 + 1] = bArr[((b & 3) << 4) | ((b2 & 255) >> 4)];
                int i4 = i2 + 3;
                bArr2[i2 + 2] = bArr[((b2 & 15) << 2) | ((b3 & 255) >> 6)];
                i2 += 4;
                bArr2[i4] = bArr[b3 & 63];
            }
            int length3 = bArrDigest.length - length2;
            if (length3 == 1) {
                byte b4 = bArrDigest[i];
                bArr2[i2] = bArr[(b4 & 255) >> 2];
                bArr2[i2 + 1] = bArr[(b4 & 3) << 4];
                bArr2[i2 + 2] = 61;
                bArr2[i2 + 3] = 61;
            } else if (length3 == 2) {
                int i5 = i + 1;
                byte b5 = bArrDigest[i];
                byte b6 = bArrDigest[i5];
                bArr2[i2] = bArr[(b5 & 255) >> 2];
                bArr2[i2 + 1] = bArr[((b5 & 3) << 4) | ((b6 & 255) >> 4)];
                bArr2[i2 + 2] = bArr[(b6 & 15) << 2];
                bArr2[i2 + 3] = 61;
            }
            sb.append(new String(bArr2, Charsets.UTF_8));
            return sb.toString();
        }
    }

    public CertificatePinner(Set set, LanKt lanKt) {
        this.pins = set;
        this.certificateChainCleaner = lanKt;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof CertificatePinner)) {
            return false;
        }
        CertificatePinner certificatePinner = (CertificatePinner) obj;
        return Intrinsics.areEqual(certificatePinner.pins, this.pins) && Intrinsics.areEqual(certificatePinner.certificateChainCleaner, this.certificateChainCleaner);
    }

    public final int hashCode() {
        int iHashCode = (this.pins.hashCode() + 1517) * 41;
        LanKt lanKt = this.certificateChainCleaner;
        return iHashCode + (lanKt != null ? lanKt.hashCode() : 0);
    }
}
