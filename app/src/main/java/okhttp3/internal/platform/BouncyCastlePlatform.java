package okhttp3.internal.platform;

import android.graphics.Bitmap;
import android.media.Image;
import android.os.Build;
import com.google.android.gms.common.internal.zzah;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.vision.common.InputImage;
import java.nio.ByteBuffer;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.bouncycastle.jsse.provider.BouncyCastleJsseProvider;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class BouncyCastlePlatform extends Platform {
    public static final boolean isSupported;
    public final Provider provider = new BouncyCastleJsseProvider();

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class Companion {
        public static ByteBuffer convertToNv21Buffer(InputImage inputImage) throws MlKitException {
            int i = inputImage.zzg;
            int i2 = 0;
            if (i != -1) {
                if (i == 17) {
                    zzah.checkNotNull(null);
                    throw null;
                }
                if (i != 35) {
                    if (i != 842094169) {
                        throw new MlKitException("Unsupported image format", 13);
                    }
                    zzah.checkNotNull(null);
                    throw null;
                }
                Image.Plane[] planes = inputImage.getPlanes();
                zzah.checkNotNull(planes);
                int i3 = inputImage.zzd;
                int i4 = inputImage.zze;
                int i5 = i3 * i4;
                int i6 = i5 / 4;
                byte[] bArr = new byte[i6 + i6 + i5];
                ByteBuffer buffer = planes[1].getBuffer();
                ByteBuffer buffer2 = planes[2].getBuffer();
                int iPosition = buffer2.position();
                int iLimit = buffer.limit();
                buffer2.position(iPosition + 1);
                buffer.limit(iLimit - 1);
                int i7 = (i5 + i5) / 4;
                boolean z = buffer2.remaining() == i7 + (-2) && buffer2.compareTo(buffer) == 0;
                buffer2.position(iPosition);
                buffer.limit(iLimit);
                if (z) {
                    planes[0].getBuffer().get(bArr, 0, i5);
                    ByteBuffer buffer3 = planes[1].getBuffer();
                    planes[2].getBuffer().get(bArr, i5, 1);
                    buffer3.get(bArr, i5 + 1, i7 - 1);
                } else {
                    zzc(planes[0], i3, i4, bArr, 0, 1);
                    zzc(planes[1], i3, i4, bArr, i5 + 1, 2);
                    zzc(planes[2], i3, i4, bArr, i5, 2);
                }
                return ByteBuffer.wrap(bArr);
            }
            Bitmap bitmapCopy = inputImage.zza;
            zzah.checkNotNull(bitmapCopy);
            if (Build.VERSION.SDK_INT >= 26 && bitmapCopy.getConfig() == Bitmap.Config.HARDWARE) {
                bitmapCopy = bitmapCopy.copy(Bitmap.Config.ARGB_8888, bitmapCopy.isMutable());
            }
            Bitmap bitmap = bitmapCopy;
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i8 = width * height;
            int[] iArr = new int[i8];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            int iCeil = (int) Math.ceil(((double) height) / 2.0d);
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(((iCeil + iCeil) * ((int) Math.ceil(((double) width) / 2.0d))) + i8);
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            while (i9 < height) {
                int i12 = i2;
                while (i12 < width) {
                    int i13 = iArr[i11];
                    int i14 = i13 >> 16;
                    int i15 = i13 >> 8;
                    int i16 = i13 & 255;
                    int i17 = i10 + 1;
                    int i18 = i14 & 255;
                    int i19 = i15 & 255;
                    byteBufferAllocateDirect.put(i10, (byte) Math.min(255, ((((i16 * 25) + ((i19 * 129) + (i18 * 66))) + 128) >> 8) + 16));
                    if (i9 % 2 == 0 && i11 % 2 == 0) {
                        int i20 = ((((i18 * 112) - (i19 * 94)) - (i16 * 18)) + 128) >> 8;
                        int i21 = (((((i18 * (-38)) - (i19 * 74)) + (i16 * 112)) + 128) >> 8) + 128;
                        int i22 = i8 + 1;
                        byteBufferAllocateDirect.put(i8, (byte) Math.min(255, i20 + 128));
                        i8 += 2;
                        byteBufferAllocateDirect.put(i22, (byte) Math.min(255, i21));
                    }
                    i11++;
                    i12++;
                    i10 = i17;
                }
                i9++;
                i2 = 0;
            }
            return byteBufferAllocateDirect;
        }

        public static final void zzc(Image.Plane plane, int i, int i2, byte[] bArr, int i3, int i4) {
            ByteBuffer buffer = plane.getBuffer();
            buffer.rewind();
            int rowStride = ((plane.getRowStride() + buffer.limit()) - 1) / plane.getRowStride();
            if (rowStride == 0) {
                return;
            }
            int i5 = i / (i2 / rowStride);
            int rowStride2 = 0;
            for (int i6 = 0; i6 < rowStride; i6++) {
                int pixelStride = rowStride2;
                for (int i7 = 0; i7 < i5; i7++) {
                    bArr[i3] = buffer.get(pixelStride);
                    i3 += i4;
                    pixelStride += plane.getPixelStride();
                }
                rowStride2 += plane.getRowStride();
            }
        }
    }

    static {
        boolean z = false;
        try {
            Class.forName("org.bouncycastle.jsse.provider.BouncyCastleJsseProvider", false, Companion.class.getClassLoader());
            z = true;
        } catch (ClassNotFoundException unused) {
        }
        isSupported = z;
    }

    @Override // okhttp3.internal.platform.Platform
    public final String getSelectedProtocol(SSLSocket sSLSocket) {
        return null;
    }

    @Override // okhttp3.internal.platform.Platform
    public final SSLContext newSSLContext() {
        return SSLContext.getInstance("TLS", this.provider);
    }

    @Override // okhttp3.internal.platform.Platform
    public final X509TrustManager platformTrustManager() throws NoSuchAlgorithmException, KeyStoreException, NoSuchProviderException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("PKIX", "BCJSSE");
        trustManagerFactory.init((KeyStore) null);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        if (trustManagers.length == 1) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager instanceof X509TrustManager) {
                return (X509TrustManager) trustManager;
            }
        }
        throw new IllegalStateException("Unexpected default trust managers: ".concat(Arrays.toString(trustManagers)).toString());
    }

    @Override // okhttp3.internal.platform.Platform
    public final void configureTlsExtensions(SSLSocket sSLSocket, String str, List list) {
    }
}
