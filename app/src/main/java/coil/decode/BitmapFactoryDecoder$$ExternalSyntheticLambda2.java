package coil.decode;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.exifinterface.media.ExifInterface;
import androidx.savedstate.Recreator;
import androidx.savedstate.SavedStateRegistryOwner;
import coil.compose.AsyncImagePainter;
import coil.network.HttpException;
import coil.request.ImageRequest;
import coil.request.Options;
import coil.size.Size;
import coil.util.Bitmaps;
import coil.util.Utils;
import com.github.kr328.clash.ApkBrokenActivity;
import com.github.kr328.clash.AppCrashedActivity;
import com.github.kr328.clash.ConnectionsActivity;
import com.github.kr328.clash.FilesActivity;
import com.github.kr328.clash.MainActivity;
import com.github.kr328.clash.MainApplication;
import com.github.kr328.clash.ProvidersActivity;
import com.github.kr328.clash.ShareToTvActivity;
import com.github.kr328.clash.common.compat.TvKt;
import com.github.kr328.clash.compose.profiles.ProfilesViewModel;
import com.github.kr328.clash.design.store.UiStore;
import com.github.kr328.clash.service.FilesProvider;
import com.github.kr328.clash.service.document.Picker;
import com.google.android.gms.dynamite.zzo;
import com.google.mlkit.vision.barcode.BarcodeScannerOptions;
import com.google.mlkit.vision.barcode.BarcodeScanning;
import dev.chrisbanes.haze.HazeEffectNode;
import dev.chrisbanes.haze.HazeEffectNode$areaPreDrawListener$2$1;
import dev.chrisbanes.haze.HazeSourceNode;
import io.github.g00fy2.quickie.QRCodeAnalyzer;
import io.github.g00fy2.quickie.QRScannerActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.UIntArray;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.serialization.descriptors.SerialDescriptorImpl;
import kotlinx.serialization.internal.Platform_commonKt;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.PeekSource;
import okio.RealBufferedSource;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BitmapFactoryDecoder$$ExternalSyntheticLambda2 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ BitmapFactoryDecoder$$ExternalSyntheticLambda2(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    /* JADX WARN: Code duplicated, block: B:129:0x024a  */
    /* JADX WARN: Code duplicated, block: B:224:0x03ac A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:225:0x03ae  */
    /* JADX WARN: Code duplicated, block: B:228:0x03bf  */
    /* JADX WARN: Code duplicated, block: B:230:0x03d4  */
    /* JADX WARN: Code duplicated, block: B:232:0x03dd  */
    /* JADX WARN: Code duplicated, block: B:235:0x03fa  */
    /* JADX WARN: Code duplicated, block: B:238:0x0403  */
    /* JADX WARN: Code duplicated, block: B:240:0x040d  */
    /* JADX WARN: Code duplicated, block: B:247:0x0427  */
    /* JADX WARN: Code duplicated, block: B:249:0x0435  */
    /* JADX WARN: Code duplicated, block: B:256:0x045d  */
    /* JADX WARN: Code duplicated, block: B:259:0x0462  */
    /* JADX WARN: Code duplicated, block: B:261:0x046a  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v14, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r9v15, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v16, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v17, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v18, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v19, types: [java.util.ArrayList] */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() throws Exception {
        ExifData exifData;
        boolean z;
        int i;
        int iMin;
        double dMax;
        Bitmap bitmapDecodeStream;
        Exception exc;
        Matrix matrix;
        float width;
        float height;
        RectF rectF;
        float f;
        Bitmap.Config config;
        Bitmap bitmapCreateBitmap;
        ColorSpace colorSpace;
        int i2;
        zzo zzoVar;
        int i3 = this.$r8$classId;
        int i4 = 0;
        int i5 = 1;
        Object obj = this.f$0;
        switch (i3) {
            case 0:
                BitmapFactoryDecoder bitmapFactoryDecoder = (BitmapFactoryDecoder) obj;
                BitmapFactory.Options options = new BitmapFactory.Options();
                Options options2 = bitmapFactoryDecoder.options;
                ResponseBody responseBody = bitmapFactoryDecoder.source;
                BitmapFactoryDecoder.ExceptionCatchingSource exceptionCatchingSource = new BitmapFactoryDecoder.ExceptionCatchingSource(responseBody.source());
                RealBufferedSource realBufferedSource = new RealBufferedSource(exceptionCatchingSource);
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(new Buffer.AnonymousClass1(new RealBufferedSource(new PeekSource(realBufferedSource)), 1), null, options);
                Exception exc2 = exceptionCatchingSource.exception;
                if (exc2 != null) {
                    throw exc2;
                }
                options.inJustDecodeBounds = false;
                Paint paint = ExifUtils.PAINT;
                String str = options.outMimeType;
                Set set = ExifUtilsKt.RESPECT_PERFORMANCE_MIME_TYPES;
                int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(2);
                if (iOrdinal == 0) {
                    exifData = ExifData.NONE;
                } else {
                    if (iOrdinal != 1) {
                        if (iOrdinal != 2) {
                            throw new HttpException();
                        }
                    } else if (str == null || !ExifUtilsKt.RESPECT_PERFORMANCE_MIME_TYPES.contains(str)) {
                        exifData = ExifData.NONE;
                    }
                    ExifInterface exifInterface = new ExifInterface(new ExifInterfaceInputStream(new Buffer.AnonymousClass1(new RealBufferedSource(new PeekSource(realBufferedSource)), 1)));
                    int attributeInt = exifInterface.getAttributeInt("Orientation", 1);
                    boolean z2 = attributeInt == 2 || attributeInt == 7 || attributeInt == 4 || attributeInt == 5;
                    switch (exifInterface.getAttributeInt("Orientation", 1)) {
                        case 3:
                        case 4:
                            i2 = 180;
                            break;
                        case 5:
                        case 8:
                            i2 = 270;
                            break;
                        case 6:
                        case 7:
                            i2 = 90;
                            break;
                        default:
                            i2 = 0;
                            break;
                    }
                    exifData = new ExifData(i2, z2);
                }
                int i6 = exifData.rotationDegrees;
                boolean z3 = exifData.isFlipped;
                Exception exc3 = exceptionCatchingSource.exception;
                if (exc3 != null) {
                    throw exc3;
                }
                options.inMutable = false;
                int i7 = Build.VERSION.SDK_INT;
                if (i7 >= 26 && (colorSpace = options2.colorSpace) != null) {
                    options.inPreferredColorSpace = colorSpace;
                }
                boolean z4 = options2.premultipliedAlpha;
                Context context = options2.context;
                Size size = options2.size;
                options.inPremultiplied = z4;
                Bitmap.Config config2 = options2.config;
                if ((z3 || i6 > 0) && (config2 == null || Bitmaps.isHardware(config2))) {
                    config2 = Bitmap.Config.ARGB_8888;
                }
                if (options2.allowRgb565 && config2 == Bitmap.Config.ARGB_8888 && Intrinsics.areEqual(options.outMimeType, "image/jpeg")) {
                    config2 = Bitmap.Config.RGB_565;
                }
                if (i7 >= 26 && options.outConfig == Bitmap.Config.RGBA_F16 && config2 != Bitmap.Config.HARDWARE) {
                    config2 = Bitmap.Config.RGBA_F16;
                }
                options.inPreferredConfig = config2;
                ImageSource$Metadata metadata = responseBody.getMetadata();
                try {
                    if ((metadata instanceof ResourceMetadata) && Intrinsics.areEqual(size, Size.ORIGINAL)) {
                        options.inSampleSize = 1;
                        options.inScaled = true;
                        options.inDensity = ((ResourceMetadata) metadata).density;
                        options.inTargetDensity = context.getResources().getDisplayMetrics().densityDpi;
                        i5 = 1;
                    } else {
                        int i8 = options.outWidth;
                        if (i8 <= 0 || (i = options.outHeight) <= 0) {
                            options.inSampleSize = i5;
                            z = false;
                            options.inScaled = false;
                            bitmapDecodeStream = BitmapFactory.decodeStream(new Buffer.AnonymousClass1(realBufferedSource, i5), null, options);
                            realBufferedSource.close();
                            exc = exceptionCatchingSource.exception;
                            if (exc == null) {
                                throw exc;
                            }
                            if (bitmapDecodeStream != null) {
                                throw new IllegalStateException("BitmapFactory returned a null bitmap. Often this means BitmapFactory could not decode the image data read from the input source (e.g. network, disk, or memory) as it's not encoded as a valid image format.");
                            }
                            bitmapDecodeStream.setDensity(context.getResources().getDisplayMetrics().densityDpi);
                            if (z3 == 0 || i6 > 0) {
                                matrix = new Matrix();
                                width = bitmapDecodeStream.getWidth() / 2.0f;
                                height = bitmapDecodeStream.getHeight() / 2.0f;
                                if (z3 != 0) {
                                    matrix.postScale(-1.0f, 1.0f, width, height);
                                }
                                if (i6 > 0) {
                                    matrix.postRotate(i6, width, height);
                                }
                                rectF = new RectF(0.0f, 0.0f, bitmapDecodeStream.getWidth(), bitmapDecodeStream.getHeight());
                                matrix.mapRect(rectF);
                                f = rectF.left;
                                if (f == 0.0f || rectF.top != 0.0f) {
                                    matrix.postTranslate(-f, -rectF.top);
                                }
                                if (i6 != 90 || i6 == 270) {
                                    int height2 = bitmapDecodeStream.getHeight();
                                    int width2 = bitmapDecodeStream.getWidth();
                                    config = bitmapDecodeStream.getConfig();
                                    if (config == null) {
                                        config = Bitmap.Config.ARGB_8888;
                                    }
                                    bitmapCreateBitmap = Bitmap.createBitmap(height2, width2, config);
                                } else {
                                    int width3 = bitmapDecodeStream.getWidth();
                                    int height3 = bitmapDecodeStream.getHeight();
                                    Bitmap.Config config3 = bitmapDecodeStream.getConfig();
                                    if (config3 == null) {
                                        config3 = Bitmap.Config.ARGB_8888;
                                    }
                                    bitmapCreateBitmap = Bitmap.createBitmap(width3, height3, config3);
                                }
                                new Canvas(bitmapCreateBitmap).drawBitmap(bitmapDecodeStream, matrix, ExifUtils.PAINT);
                                bitmapDecodeStream.recycle();
                                bitmapDecodeStream = bitmapCreateBitmap;
                            }
                            BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmapDecodeStream);
                            if (options.inSampleSize <= 1 || options.inScaled) {
                                z = true;
                            }
                            return new DecodeResult(bitmapDrawable, z);
                        }
                        int i9 = (i6 == 90 || i6 == 270) ? i : i8;
                        if (i6 != 90 && i6 != 270) {
                            i8 = i;
                        }
                        int i10 = options2.scale;
                        Size size2 = Size.ORIGINAL;
                        int px = Intrinsics.areEqual(size, size2) ? i9 : Utils.toPx(size.width, i10);
                        int px2 = Intrinsics.areEqual(size, size2) ? i8 : Utils.toPx(size.height, i10);
                        int iHighestOneBit = Integer.highestOneBit(i9 / px);
                        int iHighestOneBit2 = Integer.highestOneBit(i8 / px2);
                        int iOrdinal2 = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i10);
                        if (iOrdinal2 == 0) {
                            iMin = Math.min(iHighestOneBit, iHighestOneBit2);
                        } else {
                            if (iOrdinal2 != 1) {
                                throw new HttpException();
                            }
                            iMin = Math.max(iHighestOneBit, iHighestOneBit2);
                        }
                        if (iMin < 1) {
                            iMin = 1;
                        }
                        options.inSampleSize = iMin;
                        double d = iMin;
                        double d2 = ((double) i8) / d;
                        double d3 = ((double) px) / (((double) i9) / d);
                        double d4 = ((double) px2) / d2;
                        int iOrdinal3 = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i10);
                        if (iOrdinal3 == 0) {
                            dMax = Math.max(d3, d4);
                        } else {
                            if (iOrdinal3 != 1) {
                                throw new HttpException();
                            }
                            dMax = Math.min(d3, d4);
                        }
                        if (options2.allowInexactSize && dMax > 1.0d) {
                            dMax = 1.0d;
                        }
                        boolean z5 = dMax == 1.0d;
                        options.inScaled = !z5;
                        if (!z5) {
                            if (dMax > 1.0d) {
                                options.inDensity = MathKt.roundToInt(((double) Integer.MAX_VALUE) / dMax);
                                options.inTargetDensity = Integer.MAX_VALUE;
                            } else {
                                options.inDensity = Integer.MAX_VALUE;
                                options.inTargetDensity = MathKt.roundToInt(((double) Integer.MAX_VALUE) * dMax);
                            }
                        }
                        i5 = 1;
                    }
                    bitmapDecodeStream = BitmapFactory.decodeStream(new Buffer.AnonymousClass1(realBufferedSource, i5), null, options);
                    realBufferedSource.close();
                    exc = exceptionCatchingSource.exception;
                    if (exc == null) {
                        throw exc;
                    }
                    if (bitmapDecodeStream != null) {
                        throw new IllegalStateException("BitmapFactory returned a null bitmap. Often this means BitmapFactory could not decode the image data read from the input source (e.g. network, disk, or memory) as it's not encoded as a valid image format.");
                    }
                    bitmapDecodeStream.setDensity(context.getResources().getDisplayMetrics().densityDpi);
                    if (z3 == 0) {
                        matrix = new Matrix();
                        width = bitmapDecodeStream.getWidth() / 2.0f;
                        height = bitmapDecodeStream.getHeight() / 2.0f;
                        if (z3 != 0) {
                            matrix.postScale(-1.0f, 1.0f, width, height);
                        }
                        if (i6 > 0) {
                            matrix.postRotate(i6, width, height);
                        }
                        rectF = new RectF(0.0f, 0.0f, bitmapDecodeStream.getWidth(), bitmapDecodeStream.getHeight());
                        matrix.mapRect(rectF);
                        f = rectF.left;
                        if (f == 0.0f) {
                            matrix.postTranslate(-f, -rectF.top);
                        } else {
                            matrix.postTranslate(-f, -rectF.top);
                        }
                        if (i6 != 90) {
                            int height4 = bitmapDecodeStream.getHeight();
                            int width4 = bitmapDecodeStream.getWidth();
                            config = bitmapDecodeStream.getConfig();
                            if (config == null) {
                                config = Bitmap.Config.ARGB_8888;
                            }
                            bitmapCreateBitmap = Bitmap.createBitmap(height4, width4, config);
                        } else {
                            int height5 = bitmapDecodeStream.getHeight();
                            int width5 = bitmapDecodeStream.getWidth();
                            config = bitmapDecodeStream.getConfig();
                            if (config == null) {
                                config = Bitmap.Config.ARGB_8888;
                            }
                            bitmapCreateBitmap = Bitmap.createBitmap(height5, width5, config);
                        }
                        new Canvas(bitmapCreateBitmap).drawBitmap(bitmapDecodeStream, matrix, ExifUtils.PAINT);
                        bitmapDecodeStream.recycle();
                        bitmapDecodeStream = bitmapCreateBitmap;
                    } else {
                        matrix = new Matrix();
                        width = bitmapDecodeStream.getWidth() / 2.0f;
                        height = bitmapDecodeStream.getHeight() / 2.0f;
                        if (z3 != 0) {
                            matrix.postScale(-1.0f, 1.0f, width, height);
                        }
                        if (i6 > 0) {
                            matrix.postRotate(i6, width, height);
                        }
                        rectF = new RectF(0.0f, 0.0f, bitmapDecodeStream.getWidth(), bitmapDecodeStream.getHeight());
                        matrix.mapRect(rectF);
                        f = rectF.left;
                        if (f == 0.0f) {
                            matrix.postTranslate(-f, -rectF.top);
                        } else {
                            matrix.postTranslate(-f, -rectF.top);
                        }
                        if (i6 != 90) {
                            int height6 = bitmapDecodeStream.getHeight();
                            int width6 = bitmapDecodeStream.getWidth();
                            config = bitmapDecodeStream.getConfig();
                            if (config == null) {
                                config = Bitmap.Config.ARGB_8888;
                            }
                            bitmapCreateBitmap = Bitmap.createBitmap(height6, width6, config);
                        } else {
                            int height7 = bitmapDecodeStream.getHeight();
                            int width7 = bitmapDecodeStream.getWidth();
                            config = bitmapDecodeStream.getConfig();
                            if (config == null) {
                                config = Bitmap.Config.ARGB_8888;
                            }
                            bitmapCreateBitmap = Bitmap.createBitmap(height7, width7, config);
                        }
                        new Canvas(bitmapCreateBitmap).drawBitmap(bitmapDecodeStream, matrix, ExifUtils.PAINT);
                        bitmapDecodeStream.recycle();
                        bitmapDecodeStream = bitmapCreateBitmap;
                    }
                    BitmapDrawable bitmapDrawable2 = new BitmapDrawable(context.getResources(), bitmapDecodeStream);
                    if (options.inSampleSize <= 1) {
                        z = true;
                    } else {
                        z = true;
                    }
                    return new DecodeResult(bitmapDrawable2, z);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(realBufferedSource, th);
                        throw th2;
                    }
                }
                z = false;
                break;
            case 1:
                SavedStateRegistryOwner savedStateRegistryOwner = (SavedStateRegistryOwner) obj;
                savedStateRegistryOwner.getLifecycle().addObserver(new Recreator(savedStateRegistryOwner, i4));
                return Unit.INSTANCE;
            case 2:
                return (ImageRequest) ((AsyncImagePainter) obj).request$delegate.getValue();
            case 3:
                ((ApkBrokenActivity) obj).finish();
                return Unit.INSTANCE;
            case 4:
                ((AppCrashedActivity) obj).finish();
                return Unit.INSTANCE;
            case 5:
                ((ConnectionsActivity) obj).finish();
                return Unit.INSTANCE;
            case 6:
                int i11 = FilesActivity.$r8$clinit;
                return Boolean.valueOf(TvKt.isTvDevice((FilesActivity) obj));
            case 7:
                int i12 = FilesActivity.$r8$clinit;
                return Boolean.valueOf(((SnapshotStateList) obj).isEmpty());
            case 8:
                ((MainActivity) obj).pendingUpdate$delegate.setValue(null);
                return Unit.INSTANCE;
            case 9:
                int i13 = MainApplication.$r8$clinit;
                return new UiStore((MainApplication) obj);
            case 10:
                ((ProvidersActivity) obj).finish();
                return Unit.INSTANCE;
            case 11:
                ((ShareToTvActivity) obj).finish();
                return Unit.INSTANCE;
            case 12:
                ((ProfilesViewModel) obj)._hwidLimit.setValue(null);
                return Unit.INSTANCE;
            case 13:
                String[] strArr = FilesProvider.DEFAULT_DOCUMENT_COLUMNS;
                return new Picker(((FilesProvider) obj).getContext());
            case 14:
                return new HazeEffectNode$areaPreDrawListener$2$1((HazeEffectNode) obj);
            case 15:
                HazeSourceNode hazeSourceNode = (HazeSourceNode) obj;
                if (hazeSourceNode.area.preDrawListeners.isEmpty()) {
                    StandaloneCoroutine standaloneCoroutine = hazeSourceNode.preDrawJob;
                    if (standaloneCoroutine != null) {
                        standaloneCoroutine.cancel((CancellationException) null);
                    }
                    hazeSourceNode.preDrawJob = null;
                } else {
                    StandaloneCoroutine standaloneCoroutine2 = hazeSourceNode.preDrawJob;
                    if (standaloneCoroutine2 == null || !standaloneCoroutine2.isActive()) {
                        hazeSourceNode.preDrawJob = hazeSourceNode.launchPreDraw();
                    }
                }
                return Unit.INSTANCE;
            case 16:
                QRCodeAnalyzer qRCodeAnalyzer = (QRCodeAnalyzer) obj;
                int[] iArr = qRCodeAnalyzer.barcodeFormats;
                if (iArr.length > 1) {
                    zzoVar = new zzo();
                    if (iArr.length == 0) {
                        throw new NoSuchElementException("Array is empty.");
                    }
                    int i14 = iArr[0];
                    int length = iArr.length - 1;
                    if (length < 0) {
                        length = 0;
                    }
                    if (length < 0) {
                        throw new IllegalArgumentException(CaptureSession$State$EnumUnboxingLocalUtility.m(length, "Requested element count ", " is less than zero.").toString());
                    }
                    ?? arrayList = EmptyList.INSTANCE;
                    if (length != 0) {
                        int length2 = iArr.length;
                        if (length >= length2) {
                            int length3 = iArr.length;
                            if (length3 != 0) {
                                if (length3 != 1) {
                                    arrayList = new ArrayList(iArr.length);
                                    for (int i15 : iArr) {
                                        arrayList.add(Integer.valueOf(i15));
                                    }
                                } else {
                                    arrayList = Collections.singletonList(Integer.valueOf(i14));
                                }
                            }
                        } else if (length == 1) {
                            arrayList = Collections.singletonList(Integer.valueOf(iArr[length2 - 1]));
                        } else {
                            arrayList = new ArrayList(length);
                            for (int i16 = length2 - length; i16 < length2; i16++) {
                                arrayList.add(Integer.valueOf(iArr[i16]));
                            }
                        }
                    }
                    int[] intArray = CollectionsKt.toIntArray(arrayList);
                    int[] iArrCopyOf = Arrays.copyOf(intArray, intArray.length);
                    zzoVar.zza = i14;
                    if (iArrCopyOf != null) {
                        while (i4 < iArrCopyOf.length) {
                            zzoVar.zza = iArrCopyOf[i4] | zzoVar.zza;
                            i4++;
                        }
                    }
                } else {
                    zzoVar = new zzo();
                    Integer numValueOf = iArr.length == 0 ? null : Integer.valueOf(iArr[0]);
                    zzoVar.zza = numValueOf != null ? numValueOf.intValue() : -1;
                }
                try {
                    return BarcodeScanning.getClient(new BarcodeScannerOptions(zzoVar.zza));
                } catch (Exception e) {
                    qRCodeAnalyzer.onFailure.invoke(e);
                    return null;
                }
            case 17:
                int i17 = QRScannerActivity.$r8$clinit;
                ((QRScannerActivity) obj).finish();
                return Unit.INSTANCE;
            case 18:
                return new UIntArray.Iterator(6, (Object[]) obj);
            case 19:
                return obj;
            default:
                SerialDescriptorImpl serialDescriptorImpl = (SerialDescriptorImpl) obj;
                return Integer.valueOf(Platform_commonKt.hashCodeImpl(serialDescriptorImpl, serialDescriptorImpl.typeParametersDescriptors));
        }
    }
}
