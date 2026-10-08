package kotlinx.serialization.encoding;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathNode;
import androidx.compose.ui.graphics.vector.VectorKt;
import java.util.ArrayList;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public interface Encoder {

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class DefaultImpls {
        public static ImageVector _keyboardArrowRight;

        public static final ImageVector getKeyboardArrowRight() {
            ImageVector imageVector = _keyboardArrowRight;
            if (imageVector != null) {
                return imageVector;
            }
            ImageVector.Builder builder = new ImageVector.Builder("AutoMirrored.Filled.KeyboardArrowRight", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, true, 96);
            int i = VectorKt.$r8$clinit;
            SolidColor solidColor = new SolidColor(Color.Black);
            ArrayList arrayList = new ArrayList(32);
            arrayList.add(new PathNode.MoveTo(8.59f, 16.59f));
            arrayList.add(new PathNode.LineTo(13.17f, 12.0f));
            arrayList.add(new PathNode.LineTo(8.59f, 7.41f));
            arrayList.add(new PathNode.LineTo(10.0f, 6.0f));
            arrayList.add(new PathNode.RelativeLineTo(6.0f, 6.0f));
            arrayList.add(new PathNode.RelativeLineTo(-6.0f, 6.0f));
            arrayList.add(new PathNode.RelativeLineTo(-1.41f, -1.41f));
            arrayList.add(PathNode.Close.INSTANCE);
            ImageVector.Builder.m502addPathoIyEayM$default(builder, arrayList, solidColor);
            ImageVector imageVectorBuild = builder.build();
            _keyboardArrowRight = imageVectorBuild;
            return imageVectorBuild;
        }
    }

    CompositeEncoder beginCollection(SerialDescriptor serialDescriptor, int i);

    /* JADX INFO: renamed from: beginStructure */
    CompositeEncoder mo810beginStructure(SerialDescriptor serialDescriptor);

    void encodeBoolean(boolean z);

    void encodeByte(byte b);

    void encodeChar(char c);

    void encodeDouble(double d);

    void encodeEnum(SerialDescriptor serialDescriptor, int i);

    void encodeFloat(float f);

    Encoder encodeInline(SerialDescriptor serialDescriptor);

    void encodeInt(int i);

    void encodeLong(long j);

    void encodeNotNullMark();

    void encodeNull();

    void encodeSerializableValue(KSerializer kSerializer, Object obj);

    void encodeShort(short s);

    void encodeString(String str);

    Request getSerializersModule();
}
