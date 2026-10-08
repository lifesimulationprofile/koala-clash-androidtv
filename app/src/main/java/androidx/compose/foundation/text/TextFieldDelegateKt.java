package androidx.compose.foundation.text;

import androidx.compose.ui.text.AndroidParagraph;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class TextFieldDelegateKt {
    public static final String EmptyTextReplacement = StringsKt__StringsJVMKt.repeat("H", 10);

    public static final long computeSizeForDefaultText(TextStyle textStyle, Density density, FontFamily$Resolver fontFamily$Resolver, String str, int i) {
        AndroidParagraph androidParagraphM632ParagraphUl8oQg4$default = ParagraphKt.m632ParagraphUl8oQg4$default(str, textStyle, ConstraintsKt.Constraints$default(0, 0, 0, 0, 15), density, fontFamily$Resolver, i, 64);
        return (((long) BasicTextKt.ceilToIntPx(androidParagraphM632ParagraphUl8oQg4$default.paragraphIntrinsics.getMinIntrinsicWidth())) << 32) | (((long) BasicTextKt.ceilToIntPx(androidParagraphM632ParagraphUl8oQg4$default.getHeight())) & 4294967295L);
    }
}
