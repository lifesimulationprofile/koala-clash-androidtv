package kotlinx.coroutines.channels;

import androidx.compose.foundation.interaction.FocusInteractionKt$collectIsFocusedAsState$1$1;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.Stack;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ChannelKt {
    public static BufferedChannel Channel$default(int i, int i2, int i3) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        if (i == -2) {
            if (i2 != 1) {
                return new ConflatedBufferedChannel(1, i2);
            }
            Channel.Factory.getClass();
            return new BufferedChannel(Channel.Factory.CHANNEL_DEFAULT_CAPACITY);
        }
        if (i == -1) {
            if (i2 == 1) {
                return new ConflatedBufferedChannel(1, 2);
            }
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
        }
        if (i == 0) {
            return i2 == 1 ? new BufferedChannel(0) : new ConflatedBufferedChannel(1, i2);
        }
        if (i != Integer.MAX_VALUE) {
            return i2 == 1 ? new BufferedChannel(i) : new ConflatedBufferedChannel(i, i2);
        }
        return new BufferedChannel(Integer.MAX_VALUE);
    }

    public static final MutableState collectIsFocusedAsState(MutableInteractionSourceImpl mutableInteractionSourceImpl, GapComposer gapComposer, int i) {
        Object objRememberedValue = gapComposer.rememberedValue();
        NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
        if (objRememberedValue == neverEqualPolicy) {
            objRememberedValue = Stack.mutableStateOf$default(Boolean.FALSE);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        MutableState mutableState = (MutableState) objRememberedValue;
        boolean z = (((i & 14) ^ 6) > 4 && gapComposer.changed(mutableInteractionSourceImpl)) || (i & 6) == 4;
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (z || objRememberedValue2 == neverEqualPolicy) {
            objRememberedValue2 = new FocusInteractionKt$collectIsFocusedAsState$1$1(mutableInteractionSourceImpl, mutableState, null, 0);
            gapComposer.updateRememberedValue(objRememberedValue2);
        }
        Stack.LaunchedEffect(gapComposer, mutableInteractionSourceImpl, (Function2) objRememberedValue2);
        return mutableState;
    }
}
