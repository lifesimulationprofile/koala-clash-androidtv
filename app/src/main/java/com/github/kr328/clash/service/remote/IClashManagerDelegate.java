package com.github.kr328.clash.service.remote;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import com.github.kr328.clash.common.util.ParcelableKt;
import com.github.kr328.clash.core.model.Provider;
import com.github.kr328.clash.core.model.ProviderList;
import com.github.kr328.clash.core.model.ProxyGroup;
import com.github.kr328.clash.core.model.ProxySort;
import com.github.kr328.clash.core.model.TunnelState;
import com.github.kr328.clash.core.model.UiConfiguration;
import com.github.kr328.kaidl.SuspendTransactionKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.internal.ChannelFlow;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class IClashManagerDelegate extends Binder implements IClashManager {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final /* synthetic */ IClashManager $$delegate_0;

    public IClashManagerDelegate(IClashManager iClashManager) {
        this.$$delegate_0 = iClashManager;
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final void addClosedConnections(String str) {
        this.$$delegate_0.addClosedConnections(str);
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final void clearClosedConnections() {
        this.$$delegate_0.clearClosedConnections();
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final void closeAllConnections() {
        this.$$delegate_0.closeAllConnections();
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final void closeConnection(String str) {
        this.$$delegate_0.closeConnection(str);
    }

    @Override // android.os.Binder, android.os.IBinder
    public final String getInterfaceDescriptor() {
        return "com.github.kr328.clash.service.remote.IClashManager";
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final Object healthCheck(String str, Continuation continuation) {
        return this.$$delegate_0.healthCheck(str, continuation);
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final Object healthCheckProxy(String str, String str2, Continuation continuation) {
        return this.$$delegate_0.healthCheckProxy(str, str2, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.github.kr328.clash.service.remote.ILogObserver] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r9v0, types: [android.os.Binder, com.github.kr328.clash.service.remote.IClashManagerDelegate, java.lang.Object] */
    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        IClashManager iClashManager = this.$$delegate_0;
        if (i == 1) {
            if (parcel2 != null) {
                parcel.enforceInterface("com.github.kr328.clash.service.remote.IClashManager");
                TunnelState tunnelStateQueryTunnelState = iClashManager.queryTunnelState();
                parcel2.writeNoException();
                tunnelStateQueryTunnelState.writeToParcel(parcel2, 0);
                return true;
            }
        } else if (i == 2) {
            if (parcel2 != null) {
                parcel.enforceInterface("com.github.kr328.clash.service.remote.IClashManager");
                long jQueryTrafficTotal = iClashManager.queryTrafficTotal();
                parcel2.writeNoException();
                parcel2.writeLong(jQueryTrafficTotal);
                return true;
            }
        } else if (i == 3) {
            if (parcel2 != null) {
                parcel.enforceInterface("com.github.kr328.clash.service.remote.IClashManager");
                List listQueryProxyGroupNames = iClashManager.queryProxyGroupNames(parcel.readInt() != 0);
                parcel2.writeNoException();
                parcel2.writeInt(listQueryProxyGroupNames.size());
                Iterator it = listQueryProxyGroupNames.iterator();
                while (it.hasNext()) {
                    parcel2.writeString((String) it.next());
                }
                return true;
            }
        } else if (i != 4) {
            int i3 = 5;
            if (i == 5) {
                if (parcel2 != null) {
                    parcel.enforceInterface("com.github.kr328.clash.service.remote.IClashManager");
                    UiConfiguration uiConfigurationQueryConfiguration = iClashManager.queryConfiguration();
                    parcel2.writeNoException();
                    uiConfigurationQueryConfiguration.writeToParcel(parcel2, 0);
                    return true;
                }
            } else if (i == 6) {
                if (parcel2 != null) {
                    parcel.enforceInterface("com.github.kr328.clash.service.remote.IClashManager");
                    ProviderList providerListQueryProviders = iClashManager.queryProviders();
                    parcel2.writeNoException();
                    providerListQueryProviders.getClass();
                    ParcelableKt.writeToParcelSlice(0, parcel2, providerListQueryProviders);
                    return true;
                }
            } else {
                if (i != 7) {
                    ?? iLogObserverProxy = 0;
                    if (i == 8) {
                        if (parcel2 == null) {
                            return false;
                        }
                        parcel.enforceInterface("com.github.kr328.clash.service.remote.IClashManager");
                        SuspendTransactionKt.suspendTransaction(parcel, parcel2, new ChannelFlow.AnonymousClass2(this, parcel.readString(), iLogObserverProxy, i3));
                        return true;
                    }
                    if (i == 9) {
                        if (parcel2 == null) {
                            return false;
                        }
                        parcel.enforceInterface("com.github.kr328.clash.service.remote.IClashManager");
                        SuspendTransactionKt.suspendTransaction(parcel, parcel2, new NavHostKt$NavHost$29$1(this, parcel.readString(), parcel.readString(), iLogObserverProxy, 24));
                        return true;
                    }
                    if (i == 10) {
                        if (parcel2 == null) {
                            return false;
                        }
                        parcel.enforceInterface("com.github.kr328.clash.service.remote.IClashManager");
                        SuspendTransactionKt.suspendTransaction(parcel, parcel2, new NavHostKt$NavHost$29$1(this, Provider.Type.values()[parcel.readInt()], parcel.readString(), iLogObserverProxy, 25));
                        return true;
                    }
                    if (i == 11) {
                        if (parcel2 == null) {
                            return false;
                        }
                        parcel.enforceInterface("com.github.kr328.clash.service.remote.IClashManager");
                        TunnelState.Mode modeQueryOverrideMode = iClashManager.queryOverrideMode();
                        parcel2.writeNoException();
                        if (modeQueryOverrideMode == null) {
                            parcel2.writeInt(0);
                            return true;
                        }
                        parcel2.writeInt(1);
                        parcel2.writeInt(modeQueryOverrideMode.ordinal());
                        return true;
                    }
                    if (i == 12) {
                        if (parcel2 == null) {
                            return false;
                        }
                        parcel.enforceInterface("com.github.kr328.clash.service.remote.IClashManager");
                        patchOverrideMode(parcel.readInt() != 0 ? TunnelState.Mode.values()[parcel.readInt()] : null);
                        Unit unit = Unit.INSTANCE;
                        parcel2.writeNoException();
                        return true;
                    }
                    if (i == 13) {
                        if (parcel2 == null) {
                            return false;
                        }
                        parcel.enforceInterface("com.github.kr328.clash.service.remote.IClashManager");
                        TunnelState.Mode modeQueryConfigMode = iClashManager.queryConfigMode();
                        parcel2.writeNoException();
                        if (modeQueryConfigMode == null) {
                            parcel2.writeInt(0);
                            return true;
                        }
                        parcel2.writeInt(1);
                        parcel2.writeInt(modeQueryConfigMode.ordinal());
                        return true;
                    }
                    if (i == 14) {
                        if (parcel2 == null) {
                            return false;
                        }
                        parcel.enforceInterface("com.github.kr328.clash.service.remote.IClashManager");
                        String strQueryConnections = iClashManager.queryConnections();
                        parcel2.writeNoException();
                        parcel2.writeString(strQueryConnections);
                        return true;
                    }
                    if (i == 15) {
                        if (parcel2 == null) {
                            return false;
                        }
                        parcel.enforceInterface("com.github.kr328.clash.service.remote.IClashManager");
                        closeConnection(parcel.readString());
                        Unit unit2 = Unit.INSTANCE;
                        parcel2.writeNoException();
                        return true;
                    }
                    if (i == 16) {
                        if (parcel2 == null) {
                            return false;
                        }
                        parcel.enforceInterface("com.github.kr328.clash.service.remote.IClashManager");
                        closeAllConnections();
                        Unit unit3 = Unit.INSTANCE;
                        parcel2.writeNoException();
                        return true;
                    }
                    if (i == 17) {
                        if (parcel2 == null) {
                            return false;
                        }
                        parcel.enforceInterface("com.github.kr328.clash.service.remote.IClashManager");
                        String strQueryClosedConnections = iClashManager.queryClosedConnections();
                        parcel2.writeNoException();
                        parcel2.writeString(strQueryClosedConnections);
                        return true;
                    }
                    if (i == 18) {
                        if (parcel2 == null) {
                            return false;
                        }
                        parcel.enforceInterface("com.github.kr328.clash.service.remote.IClashManager");
                        addClosedConnections(parcel.readString());
                        Unit unit4 = Unit.INSTANCE;
                        parcel2.writeNoException();
                        return true;
                    }
                    if (i == 19) {
                        if (parcel2 == null) {
                            return false;
                        }
                        parcel.enforceInterface("com.github.kr328.clash.service.remote.IClashManager");
                        clearClosedConnections();
                        Unit unit5 = Unit.INSTANCE;
                        parcel2.writeNoException();
                        return true;
                    }
                    if (i != 20) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    if (parcel2 == null) {
                        return false;
                    }
                    parcel.enforceInterface("com.github.kr328.clash.service.remote.IClashManager");
                    if (parcel.readInt() != 0) {
                        IBinder strongBinder = parcel.readStrongBinder();
                        Reflection.getOrCreateKotlinClass(ILogObserver.class);
                        iLogObserverProxy = strongBinder instanceof ILogObserver ? (ILogObserver) strongBinder : new ILogObserverProxy(0, strongBinder);
                    }
                    setLogObserver(iLogObserverProxy);
                    Unit unit6 = Unit.INSTANCE;
                    parcel2.writeNoException();
                    return true;
                }
                if (parcel2 != null) {
                    parcel.enforceInterface("com.github.kr328.clash.service.remote.IClashManager");
                    boolean zPatchSelector = iClashManager.patchSelector(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(zPatchSelector ? 1 : 0);
                    return true;
                }
            }
        } else if (parcel2 != null) {
            parcel.enforceInterface("com.github.kr328.clash.service.remote.IClashManager");
            ProxyGroup proxyGroupQueryProxyGroup = iClashManager.queryProxyGroup(parcel.readString(), ProxySort.values()[parcel.readInt()]);
            parcel2.writeNoException();
            proxyGroupQueryProxyGroup.writeToParcel(parcel2, 0);
            return true;
        }
        return false;
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final void patchOverrideMode(TunnelState.Mode mode) {
        this.$$delegate_0.patchOverrideMode(mode);
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final boolean patchSelector(String str, String str2) {
        return this.$$delegate_0.patchSelector(str, str2);
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final String queryClosedConnections() {
        return this.$$delegate_0.queryClosedConnections();
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final TunnelState.Mode queryConfigMode() {
        return this.$$delegate_0.queryConfigMode();
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final UiConfiguration queryConfiguration() {
        return this.$$delegate_0.queryConfiguration();
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final String queryConnections() {
        return this.$$delegate_0.queryConnections();
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final TunnelState.Mode queryOverrideMode() {
        return this.$$delegate_0.queryOverrideMode();
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final ProviderList queryProviders() {
        return this.$$delegate_0.queryProviders();
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final ProxyGroup queryProxyGroup(String str, ProxySort proxySort) {
        return this.$$delegate_0.queryProxyGroup(str, proxySort);
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final List queryProxyGroupNames(boolean z) {
        return this.$$delegate_0.queryProxyGroupNames(z);
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final long queryTrafficTotal() {
        return this.$$delegate_0.queryTrafficTotal();
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final TunnelState queryTunnelState() {
        return this.$$delegate_0.queryTunnelState();
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final void setLogObserver(ILogObserver iLogObserver) {
        this.$$delegate_0.setLogObserver(iLogObserver);
    }

    @Override // com.github.kr328.clash.service.remote.IClashManager
    public final Object updateProvider(Provider.Type type, String str, Continuation continuation) {
        return this.$$delegate_0.updateProvider(type, str, continuation);
    }
}
