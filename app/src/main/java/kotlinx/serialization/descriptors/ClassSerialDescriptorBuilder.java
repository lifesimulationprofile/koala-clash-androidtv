package kotlinx.serialization.descriptors;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import java.util.ArrayList;
import java.util.HashSet;
import kotlin.collections.EmptyList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ClassSerialDescriptorBuilder {
    public final String serialName;
    public final ArrayList elementNames = new ArrayList();
    public final HashSet uniqueNames = new HashSet();
    public final ArrayList elementDescriptors = new ArrayList();
    public final ArrayList elementAnnotations = new ArrayList();
    public final ArrayList elementOptionality = new ArrayList();

    public ClassSerialDescriptorBuilder(String str) {
        this.serialName = str;
    }

    public static void element$default(ClassSerialDescriptorBuilder classSerialDescriptorBuilder, String str, SerialDescriptor serialDescriptor) {
        if (!classSerialDescriptorBuilder.uniqueNames.add(str)) {
            StringBuilder sbM16m = ImageAnalysis$$ExternalSyntheticLambda1.m16m("Element with name '", str, "' is already registered in ");
            sbM16m.append(classSerialDescriptorBuilder.serialName);
            throw new IllegalArgumentException(sbM16m.toString().toString());
        }
        classSerialDescriptorBuilder.elementNames.add(str);
        classSerialDescriptorBuilder.elementDescriptors.add(serialDescriptor);
        classSerialDescriptorBuilder.elementAnnotations.add(EmptyList.INSTANCE);
        classSerialDescriptorBuilder.elementOptionality.add(false);
    }
}
