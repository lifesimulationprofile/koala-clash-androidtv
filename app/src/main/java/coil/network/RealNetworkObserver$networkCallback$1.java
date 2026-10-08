package coil.network;

import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.util.Log;
import coil.ImageLoader$Builder;
import com.github.kr328.clash.service.clash.module.NetworkObserveModule;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.EmptyList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RealNetworkObserver$networkCallback$1 extends ConnectivityManager.NetworkCallback {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object this$0;

    public /* synthetic */ RealNetworkObserver$networkCallback$1(int i, Object obj) {
        this.$r8$classId = i;
        this.this$0 = obj;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        switch (this.$r8$classId) {
            case 0:
                ImageLoader$Builder.access$onConnectivityChange((ImageLoader$Builder) this.this$0, network, true);
                break;
            default:
                Log.i("KoalaClash", "NetworkObserve onAvailable network=" + network, null);
                ConcurrentHashMap concurrentHashMap = ((NetworkObserveModule) this.this$0).networkInfos;
                EmptyList emptyList = EmptyList.INSTANCE;
                NetworkObserveModule.NetworkInfo networkInfo = new NetworkObserveModule.NetworkInfo();
                networkInfo.losingMs = 0L;
                networkInfo.dnsList = emptyList;
                concurrentHashMap.put(network, networkInfo);
                break;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
        switch (this.$r8$classId) {
            case 1:
                Log.i("KoalaClash", "NetworkObserve onLinkPropertiesChanged network=" + network + " " + linkProperties, null);
                NetworkObserveModule.NetworkInfo networkInfo = (NetworkObserveModule.NetworkInfo) ((NetworkObserveModule) this.this$0).networkInfos.get(network);
                if (networkInfo != null) {
                    networkInfo.dnsList = linkProperties.getDnsServers();
                }
                NetworkObserveModule.access$notifyDnsChange((NetworkObserveModule) this.this$0);
                ((NetworkObserveModule) this.this$0).networks.mo842trySendJP2dKIU(network);
                break;
            default:
                super.onLinkPropertiesChanged(network, linkProperties);
                break;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLosing(Network network, int i) {
        switch (this.$r8$classId) {
            case 1:
                Log.i("KoalaClash", "NetworkObserve onLosing network=" + network, null);
                NetworkObserveModule.NetworkInfo networkInfo = (NetworkObserveModule.NetworkInfo) ((NetworkObserveModule) this.this$0).networkInfos.get(network);
                if (networkInfo != null) {
                    networkInfo.losingMs = System.currentTimeMillis() + ((long) i);
                }
                NetworkObserveModule.access$notifyDnsChange((NetworkObserveModule) this.this$0);
                ((NetworkObserveModule) this.this$0).networks.mo842trySendJP2dKIU(network);
                break;
            default:
                super.onLosing(network, i);
                break;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        switch (this.$r8$classId) {
            case 0:
                ImageLoader$Builder.access$onConnectivityChange((ImageLoader$Builder) this.this$0, network, false);
                break;
            default:
                Log.i("KoalaClash", "NetworkObserve onLost network=" + network, null);
                NetworkObserveModule networkObserveModule = (NetworkObserveModule) this.this$0;
                networkObserveModule.networkInfos.remove(network);
                NetworkObserveModule.access$notifyDnsChange(networkObserveModule);
                networkObserveModule.networks.mo842trySendJP2dKIU(network);
                break;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onUnavailable() {
        switch (this.$r8$classId) {
            case 1:
                Log.i("KoalaClash", "NetworkObserve onUnavailable", null);
                break;
            default:
                super.onUnavailable();
                break;
        }
    }
}
