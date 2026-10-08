package okhttp3.internal.connection;

import androidx.camera.camera2.internal.ZslControlImpl$$ExternalSyntheticLambda0;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.customview.poolingcontainer.PoolingContainer;
import androidx.fragment.app.FragmentStateManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.Handshake;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RealConnection$connectTls$1 extends Lambda implements Function0 {
    public final /* synthetic */ Object $address;
    public final /* synthetic */ Object $certificatePinner;
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object $unverifiedHandshake;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RealConnection$connectTls$1(Object obj, Object obj2, Object obj3, int i) {
        super(0);
        this.$r8$classId = i;
        this.$certificatePinner = obj;
        this.$unverifiedHandshake = obj2;
        this.$address = obj3;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                return ((CertificatePinner) this.$certificatePinner).certificateChainCleaner.clean(((Address) this.$address).url.host, ((Handshake) this.$unverifiedHandshake).peerCertificates());
            default:
                AbstractComposeView abstractComposeView = (AbstractComposeView) this.$certificatePinner;
                abstractComposeView.removeOnAttachStateChangeListener((FragmentStateManager.AnonymousClass1) this.$unverifiedHandshake);
                PoolingContainer.getPoolingContainerListenerHolder(abstractComposeView).listeners.remove((ZslControlImpl$$ExternalSyntheticLambda0) this.$address);
                return Unit.INSTANCE;
        }
    }
}
