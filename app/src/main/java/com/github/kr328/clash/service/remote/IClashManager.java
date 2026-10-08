package com.github.kr328.clash.service.remote;

import com.github.kr328.clash.core.model.Provider;
import com.github.kr328.clash.core.model.ProviderList;
import com.github.kr328.clash.core.model.ProxyGroup;
import com.github.kr328.clash.core.model.ProxySort;
import com.github.kr328.clash.core.model.TunnelState;
import com.github.kr328.clash.core.model.UiConfiguration;
import java.util.List;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public interface IClashManager {
    void addClosedConnections(String str);

    void clearClosedConnections();

    void closeAllConnections();

    void closeConnection(String str);

    Object healthCheck(String str, Continuation continuation);

    Object healthCheckProxy(String str, String str2, Continuation continuation);

    void patchOverrideMode(TunnelState.Mode mode);

    boolean patchSelector(String str, String str2);

    String queryClosedConnections();

    TunnelState.Mode queryConfigMode();

    UiConfiguration queryConfiguration();

    String queryConnections();

    TunnelState.Mode queryOverrideMode();

    ProviderList queryProviders();

    ProxyGroup queryProxyGroup(String str, ProxySort proxySort);

    List queryProxyGroupNames(boolean z);

    long queryTrafficTotal();

    TunnelState queryTunnelState();

    void setLogObserver(ILogObserver iLogObserver);

    Object updateProvider(Provider.Type type, String str, Continuation continuation);
}
