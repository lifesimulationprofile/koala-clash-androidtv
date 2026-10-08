package androidx.compose.foundation.text;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily$Resolver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldSize {
    public Density density;
    public final ParcelableSnapshotMutableState dirty$delegate = Stack.mutableStateOf$default(Boolean.TRUE);
    public FontFamily$Resolver fontFamilyResolver;
    public LayoutDirection layoutDirection;
    public long minSize;
    public TextStyle resolvedStyle;
    public Object typeface;

    public TextFieldSize(LayoutDirection layoutDirection, Density density, FontFamily$Resolver fontFamily$Resolver, TextStyle textStyle, Object obj) {
        this.layoutDirection = layoutDirection;
        this.density = density;
        this.fontFamilyResolver = fontFamily$Resolver;
        this.resolvedStyle = textStyle;
        this.typeface = obj;
        this.minSize = TextFieldDelegateKt.computeSizeForDefaultText(this.resolvedStyle, this.density, this.fontFamilyResolver, TextFieldDelegateKt.EmptyTextReplacement, 1);
    }

    public static void update$default(TextFieldSize textFieldSize, LayoutDirection layoutDirection, Density density, TextStyle textStyle, int i) {
        if ((i & 1) != 0) {
            layoutDirection = textFieldSize.layoutDirection;
        }
        if ((i & 2) != 0) {
            density = textFieldSize.density;
        }
        FontFamily$Resolver fontFamily$Resolver = textFieldSize.fontFamilyResolver;
        if ((i & 8) != 0) {
            textStyle = textFieldSize.resolvedStyle;
        }
        Object obj = textFieldSize.typeface;
        LayoutDirection layoutDirection2 = textFieldSize.layoutDirection;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = textFieldSize.dirty$delegate;
        if (layoutDirection == layoutDirection2 && Intrinsics.areEqual(density, textFieldSize.density) && Intrinsics.areEqual(fontFamily$Resolver, textFieldSize.fontFamilyResolver) && Intrinsics.areEqual(textStyle, textFieldSize.resolvedStyle)) {
            if (Intrinsics.areEqual(obj, textFieldSize.typeface)) {
                return;
            }
            textFieldSize.typeface = obj;
            parcelableSnapshotMutableState.setValue(Boolean.TRUE);
            return;
        }
        textFieldSize.layoutDirection = layoutDirection;
        textFieldSize.density = density;
        textFieldSize.fontFamilyResolver = fontFamily$Resolver;
        textFieldSize.resolvedStyle = textStyle;
        parcelableSnapshotMutableState.setValue(Boolean.TRUE);
    }
}
