package kotlinx.serialization.descriptors;

import androidx.compose.foundation.text.modifiers.MinLinesConstrainer;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityImpl;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class SerialKind {
    public final /* synthetic */ int $r8$classId = 0;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class CONTEXTUAL extends SerialKind {
        public static final CONTEXTUAL INSTANCE = new CONTEXTUAL();
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class ENUM extends SerialKind {
        public static final ENUM INSTANCE = new ENUM();
    }

    public static MinLinesConstrainer from(MinLinesConstrainer minLinesConstrainer, LayoutDirection layoutDirection, TextStyle textStyle, Density density, FontFamily$Resolver fontFamily$Resolver) {
        if (minLinesConstrainer != null && layoutDirection == minLinesConstrainer.layoutDirection && ParagraphKt.resolveDefaults(textStyle, layoutDirection).equals(minLinesConstrainer.inputTextStyle) && density.getDensity() == minLinesConstrainer.density.density && fontFamily$Resolver == minLinesConstrainer.fontFamilyResolver) {
            return minLinesConstrainer;
        }
        MinLinesConstrainer minLinesConstrainer2 = MinLinesConstrainer.last;
        if (minLinesConstrainer2 != null && layoutDirection == minLinesConstrainer2.layoutDirection && ParagraphKt.resolveDefaults(textStyle, layoutDirection).equals(minLinesConstrainer2.inputTextStyle) && density.getDensity() == minLinesConstrainer2.density.density && fontFamily$Resolver == minLinesConstrainer2.fontFamilyResolver) {
            return minLinesConstrainer2;
        }
        MinLinesConstrainer minLinesConstrainer3 = new MinLinesConstrainer(layoutDirection, ParagraphKt.resolveDefaults(textStyle, layoutDirection), new DensityImpl(density.getDensity(), density.getFontScale()), fontFamily$Resolver);
        MinLinesConstrainer.last = minLinesConstrainer3;
        return minLinesConstrainer3;
    }

    public int hashCode() {
        switch (this.$r8$classId) {
            case 0:
                return toString().hashCode();
            default:
                return super.hashCode();
        }
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 0:
                return Reflection.getOrCreateKotlinClass(getClass()).getSimpleName();
            default:
                return super.toString();
        }
    }
}
