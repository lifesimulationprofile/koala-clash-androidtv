package kotlinx.serialization.json.internal;

import kotlin.enums.EnumEntriesList;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r4v3 kotlinx.serialization.json.internal.WriteMode[], still in use, count: 1, list:
  (r4v3 kotlinx.serialization.json.internal.WriteMode[]) from 0x003f: CONSTRUCTOR (r4v3 kotlinx.serialization.json.internal.WriteMode[]) A[MD:(java.lang.Enum[]):void (m), WRAPPED] (LINE:64) call: kotlin.enums.EnumEntriesList.<init>(java.lang.Enum[]):void type: CONSTRUCTOR
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class WriteMode {
    OBJ('{', '}'),
    LIST('[', ']'),
    MAP('{', '}'),
    POLY_OBJ('[', ']');

    public static final /* synthetic */ EnumEntriesList $ENTRIES;
    public final char begin;
    public final char end;

    static {
        $ENTRIES = new EnumEntriesList(writeModeArr);
    }

    public WriteMode(char c, char c2) {
        super(str, i);
        this.begin = c;
        this.end = c2;
    }

    public static WriteMode valueOf(String str) {
        return (WriteMode) Enum.valueOf(WriteMode.class, str);
    }

    public static WriteMode[] values() {
        return (WriteMode[]) $VALUES.clone();
    }
}
