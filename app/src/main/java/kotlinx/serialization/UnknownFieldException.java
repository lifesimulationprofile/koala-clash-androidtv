package kotlinx.serialization;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class UnknownFieldException extends SerializationException {
    public UnknownFieldException(int i) {
        super(ImageAnalysis$$ExternalSyntheticLambda1.m("An unknown field for index ", i));
    }
}
