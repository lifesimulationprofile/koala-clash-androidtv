package kotlinx.coroutines.flow;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SharingCommand {
    public static final /* synthetic */ SharingCommand[] $VALUES;
    public static final SharingCommand START;
    public static final SharingCommand STOP;
    public static final SharingCommand STOP_AND_RESET_REPLAY_CACHE;

    static {
        SharingCommand sharingCommand = new SharingCommand("START", 0);
        START = sharingCommand;
        SharingCommand sharingCommand2 = new SharingCommand("STOP", 1);
        STOP = sharingCommand2;
        SharingCommand sharingCommand3 = new SharingCommand("STOP_AND_RESET_REPLAY_CACHE", 2);
        STOP_AND_RESET_REPLAY_CACHE = sharingCommand3;
        $VALUES = new SharingCommand[]{sharingCommand, sharingCommand2, sharingCommand3};
    }

    public static SharingCommand valueOf(String str) {
        return (SharingCommand) Enum.valueOf(SharingCommand.class, str);
    }

    public static SharingCommand[] values() {
        return (SharingCommand[]) $VALUES.clone();
    }
}
