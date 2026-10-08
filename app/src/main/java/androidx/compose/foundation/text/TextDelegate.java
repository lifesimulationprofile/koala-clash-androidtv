package androidx.compose.foundation.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.collections.EmptyList;
import okhttp3.Request;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TextDelegate {
    public final Density density;
    public final FontFamily$Resolver fontFamilyResolver;
    public LayoutDirection intrinsicsLayoutDirection;
    public Request paragraphIntrinsics;
    public final boolean softWrap;
    public final TextStyle style;
    public final AnnotatedString text;
    public final int maxLines = Integer.MAX_VALUE;
    public final int minLines = 1;
    public final int overflow = 1;
    public final List placeholders = EmptyList.INSTANCE;

    public TextDelegate(AnnotatedString annotatedString, TextStyle textStyle, boolean z, Density density, FontFamily$Resolver fontFamily$Resolver, int i) {
        this.text = annotatedString;
        this.style = textStyle;
        this.softWrap = z;
        this.density = density;
        this.fontFamilyResolver = fontFamily$Resolver;
    }

    public final void layoutIntrinsics(LayoutDirection layoutDirection) {
        Request request = this.paragraphIntrinsics;
        if (request == null || layoutDirection != this.intrinsicsLayoutDirection || request.getHasStaleResolvedFonts()) {
            this.intrinsicsLayoutDirection = layoutDirection;
            request = new Request(this.text, ParagraphKt.resolveDefaults(this.style, layoutDirection), this.placeholders, this.density, this.fontFamilyResolver);
        }
        this.paragraphIntrinsics = request;
    }
}
