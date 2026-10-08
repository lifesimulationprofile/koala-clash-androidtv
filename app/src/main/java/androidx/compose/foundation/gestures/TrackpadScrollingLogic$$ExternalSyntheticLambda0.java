package androidx.compose.foundation.gestures;

import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelResult;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TrackpadScrollingLogic$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Channel f$0;

    public /* synthetic */ TrackpadScrollingLogic$$ExternalSyntheticLambda0(Channel channel, int i) {
        this.$r8$classId = i;
        this.f$0 = channel;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                Object objMo841tryReceivePtdJZtk = this.f$0.mo841tryReceivePtdJZtk();
                if (objMo841tryReceivePtdJZtk instanceof ChannelResult.Failed) {
                    objMo841tryReceivePtdJZtk = null;
                }
                return (TrackpadScrollingLogic.TrackpadScrollDelta) objMo841tryReceivePtdJZtk;
            default:
                Object objMo841tryReceivePtdJZtk2 = this.f$0.mo841tryReceivePtdJZtk();
                if (objMo841tryReceivePtdJZtk2 instanceof ChannelResult.Failed) {
                    objMo841tryReceivePtdJZtk2 = null;
                }
                return (MouseWheelScrollingLogic.MouseWheelScrollDelta) objMo841tryReceivePtdJZtk2;
        }
    }
}
