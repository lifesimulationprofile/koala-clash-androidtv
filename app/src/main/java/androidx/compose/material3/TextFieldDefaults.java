package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.material3.internal.TextFieldImplKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldDefaults {
    public static final TextFieldDefaults INSTANCE = new TextFieldDefaults();
    public static final TextFieldDefaults INSTANCE$1 = new TextFieldDefaults();

    /* JADX INFO: renamed from: supportingTextPadding-a9UjIt4$material3$default, reason: not valid java name */
    public static PaddingValuesImpl m273supportingTextPaddinga9UjIt4$material3$default() {
        float f = TextFieldImplKt.TextFieldPadding;
        return new PaddingValuesImpl(f, TextFieldImplKt.SupportingTopPadding, f, 0);
    }
}
