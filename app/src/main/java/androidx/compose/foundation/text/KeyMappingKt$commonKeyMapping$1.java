package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.camera.view.PreviewView;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.Key_androidKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class KeyMappingKt$commonKeyMapping$1 {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ KeyMappingKt$commonKeyMapping$1(int i) {
        this.$r8$classId = i;
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:49:0x00c0  */
    /* JADX INFO: renamed from: map-ZmokQxo, reason: not valid java name */
    public final int m171mapZmokQxo(KeyEvent keyEvent) {
        int i;
        switch (this.$r8$classId) {
            case 0:
                int iM168getModifiersZmokQxo = BasicTextKt.m168getModifiersZmokQxo(keyEvent);
                if (iM168getModifiersZmokQxo != 10) {
                    if (iM168getModifiersZmokQxo == 2) {
                        long jKey = Key_androidKt.Key(keyEvent.getKeyCode());
                        if (!Key.m504equalsimpl0(jKey, Key.C) && !Key.m504equalsimpl0(jKey, Key.Insert) && !Key.m504equalsimpl0(jKey, Key.NumPadInsert)) {
                            if (!Key.m504equalsimpl0(jKey, Key.V)) {
                                if (!Key.m504equalsimpl0(jKey, Key.X)) {
                                    if (Key.m504equalsimpl0(jKey, Key.A)) {
                                        return 27;
                                    }
                                    if (!Key.m504equalsimpl0(jKey, Key.Y)) {
                                        return Key.m504equalsimpl0(jKey, Key.Z) ? 47 : 0;
                                    }
                                }
                                return 20;
                            }
                            return 19;
                        }
                        return 18;
                    }
                    if (iM168getModifiersZmokQxo == 8) {
                        long jKey2 = Key_androidKt.Key(keyEvent.getKeyCode());
                        if (Key.m504equalsimpl0(jKey2, Key.DirectionLeft) || Key.m504equalsimpl0(jKey2, Key.NumPadDirectionLeft)) {
                            return 28;
                        }
                        if (Key.m504equalsimpl0(jKey2, Key.DirectionRight) || Key.m504equalsimpl0(jKey2, Key.NumPadDirectionRight)) {
                            return 29;
                        }
                        if (Key.m504equalsimpl0(jKey2, Key.DirectionUp) || Key.m504equalsimpl0(jKey2, Key.NumPadDirectionUp)) {
                            return 30;
                        }
                        if (Key.m504equalsimpl0(jKey2, Key.DirectionDown) || Key.m504equalsimpl0(jKey2, Key.NumPadDirectionDown)) {
                            return 31;
                        }
                        if (Key.m504equalsimpl0(jKey2, Key.PageUp) || Key.m504equalsimpl0(jKey2, Key.NumPadPageUp)) {
                            return 32;
                        }
                        if (Key.m504equalsimpl0(jKey2, Key.PageDown) || Key.m504equalsimpl0(jKey2, Key.NumPadPageDown)) {
                            return 33;
                        }
                        if (Key.m504equalsimpl0(jKey2, Key.MoveHome) || Key.m504equalsimpl0(jKey2, Key.NumPadMoveHome)) {
                            return 40;
                        }
                        if (Key.m504equalsimpl0(jKey2, Key.MoveEnd) || Key.m504equalsimpl0(jKey2, Key.NumPadMoveEnd)) {
                            return 41;
                        }
                        if (!Key.m504equalsimpl0(jKey2, Key.Insert) && !Key.m504equalsimpl0(jKey2, Key.NumPadInsert)) {
                            return 0;
                        }
                    } else {
                        if (iM168getModifiersZmokQxo != 0) {
                            return 0;
                        }
                        long jKey3 = Key_androidKt.Key(keyEvent.getKeyCode());
                        if (Key.m504equalsimpl0(jKey3, Key.DirectionLeft) || Key.m504equalsimpl0(jKey3, Key.NumPadDirectionLeft)) {
                            return 1;
                        }
                        if (Key.m504equalsimpl0(jKey3, Key.DirectionRight) || Key.m504equalsimpl0(jKey3, Key.NumPadDirectionRight)) {
                            return 2;
                        }
                        if (Key.m504equalsimpl0(jKey3, Key.DirectionUp) || Key.m504equalsimpl0(jKey3, Key.NumPadDirectionUp)) {
                            return 11;
                        }
                        if (Key.m504equalsimpl0(jKey3, Key.DirectionDown) || Key.m504equalsimpl0(jKey3, Key.NumPadDirectionDown)) {
                            return 12;
                        }
                        if (Key.m504equalsimpl0(jKey3, Key.DirectionCenter)) {
                            return 13;
                        }
                        if (Key.m504equalsimpl0(jKey3, Key.PageUp) || Key.m504equalsimpl0(jKey3, Key.NumPadPageUp)) {
                            return 14;
                        }
                        if (Key.m504equalsimpl0(jKey3, Key.PageDown) || Key.m504equalsimpl0(jKey3, Key.NumPadPageDown)) {
                            return 15;
                        }
                        if (Key.m504equalsimpl0(jKey3, Key.MoveHome) || Key.m504equalsimpl0(jKey3, Key.NumPadMoveHome)) {
                            return 7;
                        }
                        if (Key.m504equalsimpl0(jKey3, Key.MoveEnd) || Key.m504equalsimpl0(jKey3, Key.NumPadMoveEnd)) {
                            return 8;
                        }
                        if (Key.m504equalsimpl0(jKey3, Key.Enter) || Key.m504equalsimpl0(jKey3, Key.NumPadEnter)) {
                            return 45;
                        }
                        if (Key.m504equalsimpl0(jKey3, Key.Backspace)) {
                            return 21;
                        }
                        if (Key.m504equalsimpl0(jKey3, Key.Delete)) {
                            return 22;
                        }
                        if (!Key.m504equalsimpl0(jKey3, Key.Paste)) {
                            if (!Key.m504equalsimpl0(jKey3, Key.Cut)) {
                                if (!Key.m504equalsimpl0(jKey3, Key.Copy)) {
                                    return Key.m504equalsimpl0(jKey3, Key.Tab) ? 46 : 0;
                                }
                                return 18;
                            }
                            return 20;
                        }
                    }
                    return 19;
                }
                if (!Key.m504equalsimpl0(Key_androidKt.Key(keyEvent.getKeyCode()), Key.Z)) {
                    return 0;
                }
                return 48;
            default:
                int iM168getModifiersZmokQxo2 = BasicTextKt.m168getModifiersZmokQxo(keyEvent);
                int i2 = BasicTextKt.AltShift;
                int i3 = 0;
                if (iM168getModifiersZmokQxo2 == 9) {
                    long jKey4 = Key_androidKt.Key(keyEvent.getKeyCode());
                    if (Key.m504equalsimpl0(jKey4, Key.DirectionLeft)) {
                        i3 = 42;
                    } else if (Key.m504equalsimpl0(jKey4, Key.DirectionRight)) {
                        i3 = 43;
                    } else if (Key.m504equalsimpl0(jKey4, Key.DirectionUp)) {
                        i3 = 34;
                    } else if (Key.m504equalsimpl0(jKey4, Key.DirectionDown)) {
                        i3 = 35;
                    }
                } else if (iM168getModifiersZmokQxo2 == 1) {
                    long jKey5 = Key_androidKt.Key(keyEvent.getKeyCode());
                    if (Key.m504equalsimpl0(jKey5, Key.DirectionLeft)) {
                        i3 = 9;
                    } else if (Key.m504equalsimpl0(jKey5, Key.DirectionRight)) {
                        i3 = 10;
                    } else if (Key.m504equalsimpl0(jKey5, Key.DirectionUp)) {
                        i3 = 16;
                    } else if (Key.m504equalsimpl0(jKey5, Key.DirectionDown)) {
                        i3 = 17;
                    } else if (Key.m504equalsimpl0(jKey5, Key.Backspace)) {
                        i3 = 25;
                    }
                }
                if (i3 != 0) {
                    return i3;
                }
                PreviewView.AnonymousClass1 anonymousClass1 = BasicTextKt.defaultKeyMapping;
                anonymousClass1.getClass();
                int i4 = BasicTextKt.CtrlShift;
                int iM168getModifiersZmokQxo3 = BasicTextKt.m168getModifiersZmokQxo(keyEvent);
                long jKey6 = Key_androidKt.Key(keyEvent.getKeyCode());
                int i5 = 0;
                if (Key.m504equalsimpl0(jKey6, Key.Backspace)) {
                    if (iM168getModifiersZmokQxo3 == 0 || iM168getModifiersZmokQxo3 == 8) {
                        i = 21;
                    } else {
                        int i6 = BasicTextKt.ShiftMeta;
                        if (iM168getModifiersZmokQxo3 == 12) {
                            i = 21;
                        } else if (iM168getModifiersZmokQxo3 == 2 || iM168getModifiersZmokQxo3 == 10) {
                            i = 23;
                        } else {
                            i = 0;
                        }
                    }
                } else if ((Key.m504equalsimpl0(jKey6, Key.Enter) || Key.m504equalsimpl0(jKey6, Key.NumPadEnter)) && (iM168getModifiersZmokQxo3 == 0 || iM168getModifiersZmokQxo3 == 8 || iM168getModifiersZmokQxo3 == 2 || iM168getModifiersZmokQxo3 == 10)) {
                    i = 45;
                } else {
                    i = 0;
                }
                if (i != 0) {
                    return i;
                }
                int iM168getModifiersZmokQxo4 = BasicTextKt.m168getModifiersZmokQxo(keyEvent);
                if (iM168getModifiersZmokQxo4 == 10) {
                    long jKey7 = Key_androidKt.Key(keyEvent.getKeyCode());
                    if (Key.m504equalsimpl0(jKey7, Key.DirectionLeft) || Key.m504equalsimpl0(jKey7, Key.NumPadDirectionLeft)) {
                        i5 = 36;
                    } else if (Key.m504equalsimpl0(jKey7, Key.DirectionRight) || Key.m504equalsimpl0(jKey7, Key.NumPadDirectionRight)) {
                        i5 = 37;
                    } else if (Key.m504equalsimpl0(jKey7, Key.DirectionUp) || Key.m504equalsimpl0(jKey7, Key.NumPadDirectionUp)) {
                        i5 = 39;
                    } else if (Key.m504equalsimpl0(jKey7, Key.DirectionDown) || Key.m504equalsimpl0(jKey7, Key.NumPadDirectionDown)) {
                        i5 = 38;
                    }
                } else if (iM168getModifiersZmokQxo4 == 2) {
                    long jKey8 = Key_androidKt.Key(keyEvent.getKeyCode());
                    if (Key.m504equalsimpl0(jKey8, Key.DirectionLeft) || Key.m504equalsimpl0(jKey8, Key.NumPadDirectionLeft)) {
                        i5 = 4;
                    } else if (Key.m504equalsimpl0(jKey8, Key.DirectionRight) || Key.m504equalsimpl0(jKey8, Key.NumPadDirectionRight)) {
                        i5 = 3;
                    } else if (Key.m504equalsimpl0(jKey8, Key.DirectionUp) || Key.m504equalsimpl0(jKey8, Key.NumPadDirectionUp)) {
                        i5 = 6;
                    } else if (Key.m504equalsimpl0(jKey8, Key.DirectionDown) || Key.m504equalsimpl0(jKey8, Key.NumPadDirectionDown)) {
                        i5 = 5;
                    } else if (Key.m504equalsimpl0(jKey8, Key.H)) {
                        i5 = 21;
                    } else if (Key.m504equalsimpl0(jKey8, Key.Delete)) {
                        i5 = 24;
                    } else if (Key.m504equalsimpl0(jKey8, Key.Backslash)) {
                        i5 = 44;
                    }
                } else if (iM168getModifiersZmokQxo4 == 8) {
                    long jKey9 = Key_androidKt.Key(keyEvent.getKeyCode());
                    if (Key.m504equalsimpl0(jKey9, Key.MoveHome) || Key.m504equalsimpl0(jKey9, Key.NumPadMoveHome)) {
                        i5 = 40;
                    } else if (Key.m504equalsimpl0(jKey9, Key.MoveEnd) || Key.m504equalsimpl0(jKey9, Key.NumPadMoveEnd)) {
                        i5 = 41;
                    }
                } else if (iM168getModifiersZmokQxo4 == 1 && Key.m504equalsimpl0(Key_androidKt.Key(keyEvent.getKeyCode()), Key.Delete)) {
                    i5 = 26;
                }
                return i5 == 0 ? ((KeyMappingKt$commonKeyMapping$1) anonymousClass1.this$0).m171mapZmokQxo(keyEvent) : i5;
        }
    }
}
