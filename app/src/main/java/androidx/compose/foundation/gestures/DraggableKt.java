package androidx.compose.foundation.gestures;

import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class DraggableKt {
    public static final /* synthetic */ int $r8$clinit = 0;

    static {
        new DraggableKt$NoOpOnDragStarted$1(3, null, 0);
        new DraggableKt$NoOpOnDragStarted$1(3, null, 1);
    }

    /* JADX INFO: renamed from: toValidVelocity-TH1AsA0, reason: not valid java name */
    public static final long m80toValidVelocityTH1AsA0(long j) {
        return VelocityKt.Velocity(Float.isNaN(Velocity.m734getXimpl(j)) ? 0.0f : Velocity.m734getXimpl(j), Float.isNaN(Velocity.m735getYimpl(j)) ? 0.0f : Velocity.m735getYimpl(j));
    }
}
