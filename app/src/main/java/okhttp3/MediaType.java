package okhttp3;

import androidx.camera.core.impl.Quirks;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorKt;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class MediaType {
    public final String mediaType;
    public static final Pattern TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    public static final Pattern PARAMETER = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class Companion {
        public static ImageVector _close;

        public static MediaType get(String str) {
            Matcher matcher = MediaType.TYPE_SUBTYPE.matcher(str);
            if (!matcher.lookingAt()) {
                throw new IllegalArgumentException(("No subtype found for: \"" + str + '\"').toString());
            }
            String strGroup = matcher.group(1);
            Locale locale = Locale.US;
            strGroup.toLowerCase(locale);
            matcher.group(2).toLowerCase(locale);
            ArrayList arrayList = new ArrayList();
            Matcher matcher2 = MediaType.PARAMETER.matcher(str);
            int iEnd = matcher.end();
            while (iEnd < str.length()) {
                matcher2.region(iEnd, str.length());
                if (!matcher2.lookingAt()) {
                    throw new IllegalArgumentException(("Parameter is not formatted correctly: \"" + str.substring(iEnd) + "\" for: \"" + str + '\"').toString());
                }
                String strGroup2 = matcher2.group(1);
                if (strGroup2 == null) {
                    iEnd = matcher2.end();
                } else {
                    String strGroup3 = matcher2.group(2);
                    if (strGroup3 == null) {
                        strGroup3 = matcher2.group(3);
                    } else if (StringsKt__StringsJVMKt.startsWith(strGroup3, "'", false) && strGroup3.endsWith("'") && strGroup3.length() > 2) {
                        strGroup3 = strGroup3.substring(1, strGroup3.length() - 1);
                    }
                    arrayList.add(strGroup2);
                    arrayList.add(strGroup3);
                    iEnd = matcher2.end();
                }
            }
            return new MediaType(str);
        }

        public static final ImageVector getClose() {
            ImageVector imageVector = _close;
            if (imageVector != null) {
                return imageVector;
            }
            ImageVector.Builder builder = new ImageVector.Builder("Filled.Close", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
            int i = VectorKt.$r8$clinit;
            SolidColor solidColor = new SolidColor(Color.Black);
            Quirks quirks = new Quirks();
            quirks.moveTo(19.0f, 6.41f);
            quirks.lineTo(17.59f, 5.0f);
            quirks.lineTo(12.0f, 10.59f);
            quirks.lineTo(6.41f, 5.0f);
            quirks.lineTo(5.0f, 6.41f);
            quirks.lineTo(10.59f, 12.0f);
            quirks.lineTo(5.0f, 17.59f);
            quirks.lineTo(6.41f, 19.0f);
            quirks.lineTo(12.0f, 13.41f);
            quirks.lineTo(17.59f, 19.0f);
            quirks.lineTo(19.0f, 17.59f);
            quirks.lineTo(13.41f, 12.0f);
            quirks.close();
            ImageVector.Builder.m502addPathoIyEayM$default(builder, quirks.mQuirks, solidColor);
            ImageVector imageVectorBuild = builder.build();
            _close = imageVectorBuild;
            return imageVectorBuild;
        }
    }

    public MediaType(String str) {
        this.mediaType = str;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof MediaType) && Intrinsics.areEqual(((MediaType) obj).mediaType, this.mediaType);
    }

    public final int hashCode() {
        return this.mediaType.hashCode();
    }

    public final String toString() {
        return this.mediaType;
    }
}
