package androidx.compose.foundation;

import android.view.View;
import android.widget.Magnifier;
import androidx.compose.ui.unit.Density;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class PlatformMagnifierFactoryApi28Impl implements PlatformMagnifierFactory {
    public static final PlatformMagnifierFactoryApi28Impl INSTANCE = new PlatformMagnifierFactoryApi28Impl(0);
    public static final PlatformMagnifierFactoryApi28Impl INSTANCE$1 = new PlatformMagnifierFactoryApi28Impl(1);
    public final /* synthetic */ int $r8$classId;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public class PlatformMagnifierImpl implements PlatformMagnifier {
        public final Magnifier magnifier;

        public PlatformMagnifierImpl(Magnifier magnifier) {
            this.magnifier = magnifier;
        }

        public final void dismiss() {
            this.magnifier.dismiss();
        }

        /* JADX INFO: renamed from: getSize-YbymL2g, reason: not valid java name */
        public final long m59getSizeYbymL2g() {
            return (((long) this.magnifier.getHeight()) & 4294967295L) | (((long) this.magnifier.getWidth()) << 32);
        }

        @Override // androidx.compose.foundation.PlatformMagnifier
        /* JADX INFO: renamed from: update-Wko1d7g */
        public void mo57updateWko1d7g(long j, long j2) {
            this.magnifier.show(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)));
        }

        public final void updateContent() {
            this.magnifier.update();
        }
    }

    public /* synthetic */ PlatformMagnifierFactoryApi28Impl(int i) {
        this.$r8$classId = i;
    }

    @Override // androidx.compose.foundation.PlatformMagnifierFactory
    /* JADX INFO: renamed from: create-nHHXs2Y */
    public final PlatformMagnifier mo58createnHHXs2Y(View view, Density density) {
        switch (this.$r8$classId) {
            case 0:
                return new PlatformMagnifierImpl(new Magnifier(view));
            default:
                return new PlatformMagnifierFactoryApi29Impl$PlatformMagnifierImpl(new Magnifier(view));
        }
    }

    @Override // androidx.compose.foundation.PlatformMagnifierFactory
    public final boolean getCanUpdateZoom() {
        switch (this.$r8$classId) {
            case 0:
                return false;
            default:
                return true;
        }
    }
}
