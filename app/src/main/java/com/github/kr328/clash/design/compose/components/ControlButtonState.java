package com.github.kr328.clash.design.compose.components;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ControlButtonState {
    public static final /* synthetic */ ControlButtonState[] $VALUES;
    public static final ControlButtonState Connected;
    public static final ControlButtonState Connecting;
    public static final ControlButtonState Disconnected;
    public static final ControlButtonState Disconnecting;

    static {
        ControlButtonState controlButtonState = new ControlButtonState("Disconnected", 0);
        Disconnected = controlButtonState;
        ControlButtonState controlButtonState2 = new ControlButtonState("Connecting", 1);
        Connecting = controlButtonState2;
        ControlButtonState controlButtonState3 = new ControlButtonState("Connected", 2);
        Connected = controlButtonState3;
        ControlButtonState controlButtonState4 = new ControlButtonState("Disconnecting", 3);
        Disconnecting = controlButtonState4;
        $VALUES = new ControlButtonState[]{controlButtonState, controlButtonState2, controlButtonState3, controlButtonState4};
    }

    public static ControlButtonState valueOf(String str) {
        return (ControlButtonState) Enum.valueOf(ControlButtonState.class, str);
    }

    public static ControlButtonState[] values() {
        return (ControlButtonState[]) $VALUES.clone();
    }
}
