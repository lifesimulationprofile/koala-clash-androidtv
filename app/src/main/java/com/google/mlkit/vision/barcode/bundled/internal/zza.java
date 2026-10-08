package com.google.mlkit.vision.barcode.bundled.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.media.Image;
import android.os.Parcel;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzam;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzan;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzao;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzap;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzaq;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzar;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzas;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzat;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzau;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzav;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzaw;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzax;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzay;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzb;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzba;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbc;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbn;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzbt;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzc;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzcc;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzci;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzck;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzco;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeb;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeo;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzep;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfu;
import com.google.android.libraries.barhopper.BarhopperV3;
import com.google.android.libraries.barhopper.MultiScaleDecodingOptions;
import com.google.android.libraries.barhopper.MultiScaleDetectionOptions;
import com.google.android.libraries.barhopper.RecognitionOptions;
import com.google.barhopper.deeplearning.BarhopperV3Options;
import com.google.barhopper.deeplearning.zzab;
import com.google.barhopper.deeplearning.zzac;
import com.google.barhopper.deeplearning.zze;
import com.google.barhopper.deeplearning.zzf;
import com.google.barhopper.deeplearning.zzh;
import com.google.barhopper.deeplearning.zzi;
import com.google.barhopper.deeplearning.zzk;
import com.google.photos.vision.barhopper.BarhopperProto$BarhopperResponse;
import com.google.photos.vision.barhopper.zzae;
import com.google.photos.vision.barhopper.zzaf;
import com.google.photos.vision.barhopper.zzak;
import com.google.photos.vision.barhopper.zzl;
import com.google.photos.vision.barhopper.zzn;
import com.google.photos.vision.barhopper.zzp;
import com.google.photos.vision.barhopper.zzr;
import com.google.photos.vision.barhopper.zzv;
import com.google.photos.vision.barhopper.zzz;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class zza extends zzb implements zzbn {
    public static final int[] zza = {5, 7, 7, 7, 5, 5};
    public static final double[][] zzb = {new double[]{0.075d, 1.0d}, new double[]{0.1d, 1.0d}, new double[]{0.125d, 1.0d}, new double[]{0.2d, 2.0d}, new double[]{0.2d, 0.5d}, new double[]{0.15d, 1.0d}, new double[]{0.2d, 1.0d}, new double[]{0.25d, 1.0d}, new double[]{0.35d, 2.0d}, new double[]{0.35d, 0.5d}, new double[]{0.35d, 3.0d}, new double[]{0.35d, 0.3333d}, new double[]{0.3d, 1.0d}, new double[]{0.4d, 1.0d}, new double[]{0.5d, 1.0d}, new double[]{0.5d, 2.0d}, new double[]{0.5d, 0.5d}, new double[]{0.5d, 3.0d}, new double[]{0.5d, 0.3333d}, new double[]{0.6d, 1.0d}, new double[]{0.8d, 1.0d}, new double[]{1.0d, 1.0d}, new double[]{0.65d, 2.0d}, new double[]{0.65d, 0.5d}, new double[]{0.65d, 3.0d}, new double[]{0.65d, 0.3333d}, new double[]{1.0d, 1.0d}, new double[]{0.8d, 2.0d}, new double[]{0.8d, 0.5d}, new double[]{0.8d, 3.0d}, new double[]{0.8d, 0.3333d}, new double[]{1.0d, 1.0d}, new double[]{0.95d, 2.0d}, new double[]{0.95d, 0.5d}, new double[]{0.95d, 3.0d}, new double[]{0.95d, 0.3333d}};
    public final Context zzc;
    public final zzba zzd;
    public BarhopperV3 zze;

    public zza(Context context, zzba zzbaVar) {
        super("com.google.mlkit.vision.barcode.aidls.IBarcodeScanner");
        this.zzc = context;
        this.zzd = zzbaVar;
    }

    public static zzan zzh(zzl zzlVar, String str, String str2) {
        if (zzlVar == null || str == null) {
            return null;
        }
        Matcher matcher = Pattern.compile(str2).matcher(str);
        return new zzan(zzlVar.zzf(), zzlVar.zzd(), zzlVar.zza(), zzlVar.zzb(), zzlVar.zzc(), zzlVar.zze(), zzlVar.zzj(), matcher.find() ? matcher.group(1) : null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzb
    public final boolean zza(int i, Parcel parcel, Parcel parcel2) {
        if (i == 1) {
            zzd();
            parcel2.writeNoException();
            return true;
        }
        if (i == 2) {
            BarhopperV3 barhopperV3 = this.zze;
            if (barhopperV3 != null) {
                barhopperV3.close();
                this.zze = null;
            }
            parcel2.writeNoException();
            return true;
        }
        if (i == 3) {
            IObjectWrapper iObjectWrapperAsInterface = ObjectWrapper.asInterface(parcel.readStrongBinder());
            zzcc zzccVar = (zzcc) zzc.zza(parcel, zzcc.CREATOR);
            zzc.zzb(parcel);
            RecognitionOptions recognitionOptions = new RecognitionOptions();
            zzba zzbaVar = this.zzd;
            recognitionOptions.setBarcodeFormats(zzbaVar.zza);
            recognitionOptions.setOutputUnrecognizedBarcodes(zzbaVar.zzb);
            recognitionOptions.setEnableQrAlignmentGrid();
            recognitionOptions.setEnableUseKeypointAsFinderPattern();
            ArrayList arrayListZzj = zzj(iObjectWrapperAsInterface, zzccVar, recognitionOptions);
            parcel2.writeNoException();
            parcel2.writeTypedList(arrayListZzj);
            return true;
        }
        if (i != 4) {
            if (i != 5) {
                return false;
            }
            zzc.zzb(parcel);
            zzd();
            parcel2.writeNoException();
            return true;
        }
        IObjectWrapper iObjectWrapperAsInterface2 = ObjectWrapper.asInterface(parcel.readStrongBinder());
        zzcc zzccVar2 = (zzcc) zzc.zza(parcel, zzcc.CREATOR);
        zzbc zzbcVar = (zzbc) zzc.zza(parcel, zzbc.CREATOR);
        zzc.zzb(parcel);
        RecognitionOptions recognitionOptions2 = new RecognitionOptions();
        zzba zzbaVar2 = this.zzd;
        recognitionOptions2.setBarcodeFormats(zzbaVar2.zza);
        recognitionOptions2.setOutputUnrecognizedBarcodes(zzbaVar2.zzb);
        recognitionOptions2.setEnableQrAlignmentGrid();
        recognitionOptions2.setEnableUseKeypointAsFinderPattern();
        MultiScaleDecodingOptions multiScaleDecodingOptions = new MultiScaleDecodingOptions();
        multiScaleDecodingOptions.setExtraScales(zzbcVar.zza.zza);
        zzbt zzbtVar = zzbcVar.zza;
        multiScaleDecodingOptions.setMinimumDetectedDimension(zzbtVar.zzb);
        multiScaleDecodingOptions.setSkipProcessingIfBarcodeFound(zzbtVar.zzc);
        recognitionOptions2.setMultiScaleDecodingOptions(multiScaleDecodingOptions);
        MultiScaleDetectionOptions multiScaleDetectionOptions = new MultiScaleDetectionOptions();
        multiScaleDetectionOptions.setExtraScales(zzbtVar.zza);
        recognitionOptions2.setMultiScaleDetectionOptions(multiScaleDetectionOptions);
        recognitionOptions2.setQrEnableFourthCornerApproximation(zzbcVar.zzd);
        ArrayList arrayListZzj2 = zzj(iObjectWrapperAsInterface2, zzccVar2, recognitionOptions2);
        parcel2.writeNoException();
        parcel2.writeTypedList(arrayListZzj2);
        return true;
    }

    public final void zzd() {
        Context context = this.zzc;
        if (this.zze != null) {
            return;
        }
        BarhopperV3 barhopperV3 = new BarhopperV3();
        System.loadLibrary("barhopper_v3");
        this.zze = barhopperV3;
        zzh zzhVarZza$1 = zzi.zza$1();
        zze zzeVarZza$1 = zzf.zza$1();
        int i = 16;
        int i2 = 0;
        for (int i3 = 0; i3 < 6; i3++) {
            com.google.barhopper.deeplearning.zzb zzbVarZza$1 = com.google.barhopper.deeplearning.zzc.zza$1();
            zzbVarZza$1.zzm();
            com.google.barhopper.deeplearning.zzc.zzf((com.google.barhopper.deeplearning.zzc) zzbVarZza$1.zza, i);
            zzbVarZza$1.zzm();
            com.google.barhopper.deeplearning.zzc.zzc((com.google.barhopper.deeplearning.zzc) zzbVarZza$1.zza, i);
            for (int i4 = 0; i4 < zza[i3]; i4++) {
                double[] dArr = zzb[i2];
                double d = dArr[0] * 320.0d;
                float fSqrt = (float) Math.sqrt(dArr[1]);
                float f = (float) d;
                zzbVarZza$1.zzm();
                com.google.barhopper.deeplearning.zzc.zzd((com.google.barhopper.deeplearning.zzc) zzbVarZza$1.zza, f / fSqrt);
                zzbVarZza$1.zzm();
                com.google.barhopper.deeplearning.zzc.zze((com.google.barhopper.deeplearning.zzc) zzbVarZza$1.zza, f * fSqrt);
                i2++;
            }
            i += i;
            zzeVarZza$1.zzm();
            zzf.zzc((zzf) zzeVarZza$1.zza, (com.google.barhopper.deeplearning.zzc) zzbVarZza$1.zzh());
        }
        zzhVarZza$1.zzm();
        zzi.zzc((zzi) zzhVarZza$1.zza, (zzf) zzeVarZza$1.zzh());
        try {
            InputStream inputStreamOpen = context.getAssets().open("mlkit_barcode_models/barcode_ssd_mobilenet_v1_dmp25_quant.tflite");
            try {
                InputStream inputStreamOpen2 = context.getAssets().open("mlkit_barcode_models/oned_auto_regressor_mobile.tflite");
                try {
                    InputStream inputStreamOpen3 = context.getAssets().open("mlkit_barcode_models/oned_feature_extractor_mobile.tflite");
                    try {
                        BarhopperV3 barhopperV4 = this.zze;
                        zzah.checkNotNull(barhopperV4);
                        zzk zzkVarZza = BarhopperV3Options.zza();
                        zzdf zzdfVarZzs = zzdf.zzs(inputStreamOpen);
                        zzhVarZza$1.zzm();
                        zzi.zzd((zzi) zzhVarZza$1.zza, zzdfVarZzs);
                        zzkVarZza.zzm();
                        BarhopperV3Options.zzc((BarhopperV3Options) zzkVarZza.zza, (zzi) zzhVarZza$1.zzh());
                        zzab zzabVarZza$1 = zzac.zza$1();
                        zzdf zzdfVarZzs2 = zzdf.zzs(inputStreamOpen2);
                        zzabVarZza$1.zzm();
                        zzac.zzd((zzac) zzabVarZza$1.zza, zzdfVarZzs2);
                        zzdf zzdfVarZzs3 = zzdf.zzs(inputStreamOpen3);
                        zzabVarZza$1.zzm();
                        zzac.zzc((zzac) zzabVarZza$1.zza, zzdfVarZzs3);
                        zzkVarZza.zzm();
                        BarhopperV3Options.zzd((BarhopperV3Options) zzkVarZza.zza, (zzac) zzabVarZza$1.zzh());
                        barhopperV4.create((BarhopperV3Options) zzkVarZza.zzh());
                        if (inputStreamOpen3 != null) {
                            inputStreamOpen3.close();
                        }
                        if (inputStreamOpen2 != null) {
                            inputStreamOpen2.close();
                        }
                        if (inputStreamOpen != null) {
                            inputStreamOpen.close();
                        }
                    } catch (Throwable th) {
                        if (inputStreamOpen3 != null) {
                            try {
                                inputStreamOpen3.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    if (inputStreamOpen2 != null) {
                        try {
                            inputStreamOpen2.close();
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                        }
                    }
                    throw th3;
                }
            } catch (Throwable th5) {
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (Throwable th6) {
                        th5.addSuppressed(th6);
                    }
                }
                throw th5;
            }
        } catch (IOException e) {
            throw new IllegalStateException("Failed to open Barcode models", e);
        }
    }

    public final BarhopperProto$BarhopperResponse zzi(ByteBuffer byteBuffer, zzcc zzccVar, RecognitionOptions recognitionOptions) {
        BarhopperV3 barhopperV3 = this.zze;
        zzah.checkNotNull(barhopperV3);
        zzah.checkNotNull(byteBuffer);
        if (byteBuffer.isDirect()) {
            return barhopperV3.recognize(zzccVar.zzb, zzccVar.zzc, byteBuffer, recognitionOptions);
        }
        if (byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
            return barhopperV3.recognize(zzccVar.zzb, zzccVar.zzc, byteBuffer.array(), recognitionOptions);
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return barhopperV3.recognize(zzccVar.zzb, zzccVar.zzc, bArr, recognitionOptions);
    }

    public final ArrayList zzj(IObjectWrapper iObjectWrapper, zzcc zzccVar, RecognitionOptions recognitionOptions) {
        BarhopperProto$BarhopperResponse barhopperProto$BarhopperResponseRecognize;
        Matrix matrix;
        int i;
        zzar zzarVar;
        zzau zzauVar;
        zzav zzavVar;
        zzax zzaxVar;
        zzaw zzawVar;
        zzas zzasVar;
        zzao zzaoVar;
        zzap zzapVar;
        zzaq zzaqVar;
        int i2;
        int i3;
        String strZzl;
        int i4;
        byte[] bArr;
        Point[] pointArr;
        int i5;
        zzau[] zzauVarArr;
        zzar[] zzarVarArr;
        zzam[] zzamVarArr;
        String strZzl2;
        String strZzl3;
        int i6 = zzccVar.zza;
        int i7 = zzccVar.zzd;
        int i8 = 0;
        int i9 = -1;
        if (i6 == -1) {
            BarhopperV3 barhopperV3 = this.zze;
            zzah.checkNotNull(barhopperV3);
            barhopperProto$BarhopperResponseRecognize = barhopperV3.recognize((Bitmap) ObjectWrapper.unwrap(iObjectWrapper), recognitionOptions);
        } else if (i6 == 17) {
            barhopperProto$BarhopperResponseRecognize = zzi((ByteBuffer) ObjectWrapper.unwrap(iObjectWrapper), zzccVar, recognitionOptions);
        } else if (i6 != 35) {
            if (i6 != 842094169) {
                throw new IllegalArgumentException(ImageAnalysis$$ExternalSyntheticLambda1.m("Unsupported image format: ", zzccVar.zza));
            }
            barhopperProto$BarhopperResponseRecognize = zzi((ByteBuffer) ObjectWrapper.unwrap(iObjectWrapper), zzccVar, recognitionOptions);
        } else {
            Image image = (Image) ObjectWrapper.unwrap(iObjectWrapper);
            zzah.checkNotNull(image);
            barhopperProto$BarhopperResponseRecognize = zzi(image.getPlanes()[0].getBuffer(), zzccVar, recognitionOptions);
        }
        ArrayList arrayList = new ArrayList();
        int i10 = zzccVar.zzb;
        int i11 = zzccVar.zzc;
        zzeh zzehVar = null;
        if (i7 == 0) {
            matrix = null;
        } else {
            matrix = new Matrix();
            matrix.postTranslate((-i10) / 2.0f, (-i11) / 2.0f);
            matrix.postRotate(i7 * 90);
            int i12 = i7 % 2;
            int i13 = i12 != 0 ? i11 : i10;
            if (i12 == 0) {
                i10 = i11;
            }
            matrix.postTranslate(i13 / 2.0f, i10 / 2.0f);
        }
        for (com.google.photos.vision.barhopper.zzc zzcVar : barhopperProto$BarhopperResponseRecognize.zzc()) {
            int i14 = 5;
            if (zzcVar.zza() <= 0 || matrix == null) {
                i = i9;
            } else {
                float[] fArr = new float[8];
                zzeo zzeoVarZzo = zzcVar.zzo();
                int iZza = zzcVar.zza();
                int i15 = i8;
                while (i15 < iZza) {
                    int i16 = i15 + i15;
                    fArr[i16] = ((zzaf) zzeoVarZzo.get(i15)).zza();
                    fArr[i16 + 1] = ((zzaf) zzeoVarZzo.get(i15)).zzb();
                    i15++;
                    i9 = i9;
                }
                i = i9;
                matrix.mapPoints(fArr);
                int i17 = i8;
                while (i17 < iZza) {
                    zzeb zzebVar = (zzeb) zzcVar.zzg(i14, zzehVar);
                    if (!zzebVar.zzb.equals(zzcVar)) {
                        if (!zzebVar.zza.zzY()) {
                            zzebVar.zzn();
                        }
                        zzeh zzehVar2 = zzebVar.zza;
                        zzfu.zzb.zzb(zzehVar2.getClass()).zzg(zzehVar2, zzcVar);
                    }
                    com.google.photos.vision.barhopper.zzb zzbVar = (com.google.photos.vision.barhopper.zzb) zzebVar;
                    int i18 = i17 + i17;
                    zzae zzaeVarZzc = zzaf.zzc();
                    int i19 = (int) fArr[i18];
                    zzaeVarZzc.zzm();
                    zzaf.zze((zzaf) zzaeVarZzc.zza, i19);
                    int i20 = (int) fArr[i18 + 1];
                    zzaeVarZzc.zzm();
                    zzaf.zzf((zzaf) zzaeVarZzc.zza, i20);
                    zzaf zzafVar = (zzaf) zzaeVarZzc.zzh();
                    zzbVar.zzm();
                    com.google.photos.vision.barhopper.zzc.zzp((com.google.photos.vision.barhopper.zzc) zzbVar.zza, (i17 + i7) % iZza, zzafVar);
                    zzcVar = (com.google.photos.vision.barhopper.zzc) zzbVar.zzh();
                    i17++;
                    zzehVar = null;
                    i14 = 5;
                }
            }
            if (zzcVar.zzt()) {
                zzv zzvVarZzh = zzcVar.zzh();
                zzarVar = new zzar(zzvVarZzh.zzf() - 1, zzvVarZzh.zzc(), zzvVarZzh.zze(), zzvVarZzh.zzd());
            } else {
                zzarVar = null;
            }
            if (zzcVar.zzv()) {
                zzco zzcoVarZzb = zzcVar.zzb();
                zzauVar = new zzau(zzcoVarZzb.zzc(), zzcoVarZzb.zzd() - 1);
            } else {
                zzauVar = null;
            }
            if (zzcVar.zzw()) {
                com.google.photos.vision.barhopper.zzah zzahVarZzj = zzcVar.zzj();
                zzavVar = new zzav(zzahVarZzj.zzc(), zzahVarZzj.zzd());
            } else {
                zzavVar = null;
            }
            if (zzcVar.zzy()) {
                com.google.photos.vision.barhopper.zzao zzaoVarZzl = zzcVar.zzl();
                zzaxVar = new zzax(zzaoVarZzl.zze() - 1, zzaoVarZzl.zzd(), zzaoVarZzl.zzc());
            } else {
                zzaxVar = null;
            }
            if (zzcVar.zzx()) {
                zzak zzakVarZzk = zzcVar.zzk();
                zzawVar = new zzaw(zzakVarZzk.zzc(), zzakVarZzk.zzd());
            } else {
                zzawVar = null;
            }
            if (zzcVar.zzu()) {
                zzz zzzVarZzi = zzcVar.zzi();
                zzasVar = new zzas(zzzVarZzi.zza(), zzzVarZzi.zzb());
            } else {
                zzasVar = null;
            }
            if (zzcVar.zzq()) {
                zzn zznVarZzd = zzcVar.zzd();
                String strZzj = zznVarZzd.zzj();
                String strZze = zznVarZzd.zze();
                String strZzf = zznVarZzd.zzf();
                String strZzh = zznVarZzd.zzh();
                String strZzi = zznVarZzd.zzi();
                zzl zzlVarZzb = zznVarZzd.zzb();
                if (zzcVar.zzm().zzn()) {
                    zzdf zzdfVarZzm = zzcVar.zzm();
                    zzdfVarZzm.getClass();
                    strZzl2 = zzdfVarZzm.zzd() == 0 ? "" : zzdfVarZzm.zzl(zzep.zza);
                } else {
                    strZzl2 = null;
                }
                zzan zzanVarZzh = zzh(zzlVarZzb, strZzl2, "DTSTART:([0-9TZ]*)");
                zzl zzlVarZza = zznVarZzd.zza();
                if (zzcVar.zzm().zzn()) {
                    zzdf zzdfVarZzm2 = zzcVar.zzm();
                    zzdfVarZzm2.getClass();
                    strZzl3 = zzdfVarZzm2.zzd() == 0 ? "" : zzdfVarZzm2.zzl(zzep.zza);
                } else {
                    strZzl3 = null;
                }
                zzaoVar = new zzao(strZzj, strZze, strZzf, strZzh, strZzi, zzanVarZzh, zzh(zzlVarZza, strZzl3, "DTEND:([0-9TZ]*)"));
            } else {
                zzaoVar = null;
            }
            if (zzcVar.zzr()) {
                zzp zzpVarZze = zzcVar.zze();
                zzck zzckVarZza = zzpVarZze.zza();
                zzat zzatVar = zzckVarZza != null ? new zzat(zzckVarZza.zzd(), zzckVarZza.zzi(), zzckVarZza.zzh(), zzckVarZza.zzc(), zzckVarZza.zzf(), zzckVarZza.zze(), zzckVarZza.zzj()) : null;
                String strZzd = zzpVarZze.zzd();
                String strZze2 = zzpVarZze.zze();
                zzeo zzeoVarZzi = zzpVarZze.zzi();
                if (zzeoVarZzi.isEmpty()) {
                    zzauVarArr = null;
                } else {
                    zzau[] zzauVarArr2 = new zzau[zzeoVarZzi.size()];
                    for (int i21 = i8; i21 < zzeoVarZzi.size(); i21++) {
                        zzauVarArr2[i21] = new zzau(((zzco) zzeoVarZzi.get(i21)).zzc(), ((zzco) zzeoVarZzi.get(i21)).zzd() - 1);
                    }
                    zzauVarArr = zzauVarArr2;
                }
                zzeo zzeoVarZzh = zzpVarZze.zzh();
                if (zzeoVarZzh.isEmpty()) {
                    zzarVarArr = null;
                } else {
                    zzar[] zzarVarArr2 = new zzar[zzeoVarZzh.size()];
                    for (int i22 = i8; i22 < zzeoVarZzh.size(); i22++) {
                        zzarVarArr2[i22] = new zzar(((zzv) zzeoVarZzh.get(i22)).zzf() - 1, ((zzv) zzeoVarZzh.get(i22)).zzc(), ((zzv) zzeoVarZzh.get(i22)).zze(), ((zzv) zzeoVarZzh.get(i22)).zzd());
                    }
                    zzarVarArr = zzarVarArr2;
                }
                String[] strArr = (String[]) zzpVarZze.zzj().toArray(new String[0]);
                zzeo zzeoVarZzf = zzpVarZze.zzf();
                if (zzeoVarZzf.isEmpty()) {
                    zzamVarArr = null;
                } else {
                    zzam[] zzamVarArr2 = new zzam[zzeoVarZzf.size()];
                    for (int i23 = 0; i23 < zzeoVarZzf.size(); i23++) {
                        zzamVarArr2[i23] = new zzam(((zzci) zzeoVarZzf.get(i23)).zzc() - 1, (String[]) ((zzci) zzeoVarZzf.get(i23)).zzb().toArray(new String[0]));
                    }
                    zzamVarArr = zzamVarArr2;
                }
                zzapVar = new zzap(zzatVar, strZzd, strZze2, zzauVarArr, zzarVarArr, strArr, zzamVarArr);
            } else {
                zzapVar = null;
            }
            if (zzcVar.zzs()) {
                zzr zzrVarZzf = zzcVar.zzf();
                zzaqVar = new zzaq(zzrVarZzf.zzi(), zzrVarZzf.zzk(), zzrVarZzf.zzq(), zzrVarZzf.zzo(), zzrVarZzf.zzl(), zzrVarZzf.zze(), zzrVarZzf.zzc(), zzrVarZzf.zzd(), zzrVarZzf.zzf(), zzrVarZzf.zzp(), zzrVarZzf.zzm(), zzrVarZzf.zzj(), zzrVarZzf.zzh(), zzrVarZzf.zzn());
            } else {
                zzaqVar = null;
            }
            int i24 = 2;
            switch (zzcVar.zzz() - 1) {
                case 0:
                    i2 = 0;
                    break;
                case 1:
                    i2 = 1;
                    break;
                case 2:
                    i2 = 2;
                    break;
                case 3:
                    i2 = 4;
                    break;
                case 4:
                    i2 = 8;
                    break;
                case 5:
                    i3 = 16;
                    i2 = i3;
                    break;
                case 6:
                    i3 = 32;
                    i2 = i3;
                    break;
                case 7:
                    i3 = 64;
                    i2 = i3;
                    break;
                case 8:
                    i3 = 128;
                    i2 = i3;
                    break;
                case 9:
                    i3 = 256;
                    i2 = i3;
                    break;
                case 10:
                    i3 = 512;
                    i2 = i3;
                    break;
                case 11:
                    i3 = 1024;
                    i2 = i3;
                    break;
                case 12:
                    i3 = 2048;
                    i2 = i3;
                    break;
                case 13:
                    i3 = 4096;
                    i2 = i3;
                    break;
                default:
                    i2 = i;
                    break;
            }
            String strZzn = zzcVar.zzn();
            if (zzcVar.zzm().zzn()) {
                zzdf zzdfVarZzm3 = zzcVar.zzm();
                zzdfVarZzm3.getClass();
                strZzl = zzdfVarZzm3.zzd() != 0 ? zzdfVarZzm3.zzl(zzep.zza) : "";
            } else {
                strZzl = null;
            }
            zzdf zzdfVarZzm4 = zzcVar.zzm();
            int iZzd = zzdfVarZzm4.zzd();
            if (iZzd == 0) {
                bArr = zzep.zzb;
                i4 = 0;
            } else {
                byte[] bArr2 = new byte[iZzd];
                i4 = 0;
                zzdfVarZzm4.zze(0, 0, iZzd, bArr2);
                bArr = bArr2;
            }
            zzeo zzeoVarZzo2 = zzcVar.zzo();
            if (zzeoVarZzo2.isEmpty()) {
                pointArr = null;
            } else {
                Point[] pointArr2 = new Point[zzeoVarZzo2.size()];
                for (int i25 = i4; i25 < zzeoVarZzo2.size(); i25++) {
                    pointArr2[i25] = new Point(((zzaf) zzeoVarZzo2.get(i25)).zza(), ((zzaf) zzeoVarZzo2.get(i25)).zzb());
                }
                pointArr = pointArr2;
            }
            switch (zzcVar.zzA() - 1) {
                case 1:
                    i5 = 1;
                    continue;
                    arrayList.add(new zzay(i2, strZzn, strZzl, bArr, pointArr, i5, zzarVar, zzauVar, zzavVar, zzaxVar, zzawVar, zzasVar, zzaoVar, zzapVar, zzaqVar));
                    i8 = i4;
                    i9 = i;
                    zzehVar = null;
                    break;
                case 2:
                    break;
                case 3:
                    i24 = 3;
                    break;
                case 4:
                    i5 = 4;
                    continue;
                    arrayList.add(new zzay(i2, strZzn, strZzl, bArr, pointArr, i5, zzarVar, zzauVar, zzavVar, zzaxVar, zzawVar, zzasVar, zzaoVar, zzapVar, zzaqVar));
                    i8 = i4;
                    i9 = i;
                    zzehVar = null;
                    break;
                case 5:
                    i5 = 5;
                    continue;
                    arrayList.add(new zzay(i2, strZzn, strZzl, bArr, pointArr, i5, zzarVar, zzauVar, zzavVar, zzaxVar, zzawVar, zzasVar, zzaoVar, zzapVar, zzaqVar));
                    i8 = i4;
                    i9 = i;
                    zzehVar = null;
                    break;
                case 6:
                    i24 = 6;
                    break;
                case 7:
                    i24 = 7;
                    break;
                case 8:
                    i5 = 8;
                    continue;
                    arrayList.add(new zzay(i2, strZzn, strZzl, bArr, pointArr, i5, zzarVar, zzauVar, zzavVar, zzaxVar, zzawVar, zzasVar, zzaoVar, zzapVar, zzaqVar));
                    i8 = i4;
                    i9 = i;
                    zzehVar = null;
                    break;
                case 9:
                    i24 = 9;
                    break;
                case 10:
                    i24 = 10;
                    break;
                case 11:
                    i24 = 11;
                    break;
                case 12:
                    i24 = 12;
                    break;
                default:
                    i5 = i4;
                    continue;
                    arrayList.add(new zzay(i2, strZzn, strZzl, bArr, pointArr, i5, zzarVar, zzauVar, zzavVar, zzaxVar, zzawVar, zzasVar, zzaoVar, zzapVar, zzaqVar));
                    i8 = i4;
                    i9 = i;
                    zzehVar = null;
                    break;
            }
            i5 = i24;
            arrayList.add(new zzay(i2, strZzn, strZzl, bArr, pointArr, i5, zzarVar, zzauVar, zzavVar, zzaxVar, zzawVar, zzasVar, zzaoVar, zzapVar, zzaqVar));
            i8 = i4;
            i9 = i;
            zzehVar = null;
        }
        return arrayList;
    }
}
