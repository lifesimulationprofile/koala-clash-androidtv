package androidx.compose.foundation.text.selection;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SelectedTextType {
    public static final /* synthetic */ SelectedTextType[] $VALUES;
    public static final SelectedTextType EditableText;
    public static final SelectedTextType StaticText;

    static {
        SelectedTextType selectedTextType = new SelectedTextType("EditableText", 0);
        EditableText = selectedTextType;
        SelectedTextType selectedTextType2 = new SelectedTextType("StaticText", 1);
        StaticText = selectedTextType2;
        $VALUES = new SelectedTextType[]{selectedTextType, selectedTextType2};
    }

    public static SelectedTextType valueOf(String str) {
        return (SelectedTextType) Enum.valueOf(SelectedTextType.class, str);
    }

    public static SelectedTextType[] values() {
        return (SelectedTextType[]) $VALUES.clone();
    }
}
