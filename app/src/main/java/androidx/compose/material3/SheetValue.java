package androidx.compose.material3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SheetValue {
    public static final /* synthetic */ SheetValue[] $VALUES;
    public static final SheetValue Expanded;
    public static final SheetValue Hidden;
    public static final SheetValue PartiallyExpanded;

    static {
        SheetValue sheetValue = new SheetValue("Hidden", 0);
        Hidden = sheetValue;
        SheetValue sheetValue2 = new SheetValue("Expanded", 1);
        Expanded = sheetValue2;
        SheetValue sheetValue3 = new SheetValue("PartiallyExpanded", 2);
        PartiallyExpanded = sheetValue3;
        $VALUES = new SheetValue[]{sheetValue, sheetValue2, sheetValue3};
    }

    public static SheetValue valueOf(String str) {
        return (SheetValue) Enum.valueOf(SheetValue.class, str);
    }

    public static SheetValue[] values() {
        return (SheetValue[]) $VALUES.clone();
    }
}
