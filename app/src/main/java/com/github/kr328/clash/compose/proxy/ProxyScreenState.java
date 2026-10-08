package com.github.kr328.clash.compose.proxy;

import com.github.kr328.clash.core.model.ProxySort;
import com.github.kr328.clash.core.model.TunnelState;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ProxyScreenState {
    public final TunnelState.Mode configMode;
    public final TunnelState.Mode currentMode;
    public final String error;
    public final List groupNames;
    public final Map groups;
    public final boolean isLoading;
    public final boolean isTesting;
    public final boolean modeSwitchAllowed;
    public final String selectedGroupName;
    public final ProxySort sort;
    public final Set testedProxies;
    public final Set testingProxies;

    public ProxyScreenState(List list, Map map, String str, TunnelState.Mode mode, TunnelState.Mode mode2, boolean z, ProxySort proxySort, boolean z2, boolean z3, Set set, Set set2, String str2) {
        this.groupNames = list;
        this.groups = map;
        this.selectedGroupName = str;
        this.currentMode = mode;
        this.configMode = mode2;
        this.modeSwitchAllowed = z;
        this.sort = proxySort;
        this.isLoading = z2;
        this.isTesting = z3;
        this.testingProxies = set;
        this.testedProxies = set2;
        this.error = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProxyScreenState)) {
            return false;
        }
        ProxyScreenState proxyScreenState = (ProxyScreenState) obj;
        return Intrinsics.areEqual(this.groupNames, proxyScreenState.groupNames) && Intrinsics.areEqual(this.groups, proxyScreenState.groups) && Intrinsics.areEqual(this.selectedGroupName, proxyScreenState.selectedGroupName) && this.currentMode == proxyScreenState.currentMode && this.configMode == proxyScreenState.configMode && this.modeSwitchAllowed == proxyScreenState.modeSwitchAllowed && this.sort == proxyScreenState.sort && this.isLoading == proxyScreenState.isLoading && this.isTesting == proxyScreenState.isTesting && Intrinsics.areEqual(this.testingProxies, proxyScreenState.testingProxies) && Intrinsics.areEqual(this.testedProxies, proxyScreenState.testedProxies) && Intrinsics.areEqual(this.error, proxyScreenState.error);
    }

    public final int hashCode() {
        int iHashCode = (this.groups.hashCode() + (this.groupNames.hashCode() * 31)) * 31;
        String str = this.selectedGroupName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        TunnelState.Mode mode = this.currentMode;
        int iHashCode3 = (iHashCode2 + (mode == null ? 0 : mode.hashCode())) * 31;
        TunnelState.Mode mode2 = this.configMode;
        int iHashCode4 = (this.testedProxies.hashCode() + ((this.testingProxies.hashCode() + ((((((this.sort.hashCode() + ((((iHashCode3 + (mode2 == null ? 0 : mode2.hashCode())) * 31) + (this.modeSwitchAllowed ? 1231 : 1237)) * 31)) * 31) + (this.isLoading ? 1231 : 1237)) * 31) + (this.isTesting ? 1231 : 1237)) * 31)) * 31)) * 31;
        String str2 = this.error;
        return iHashCode4 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        return "ProxyScreenState(groupNames=" + this.groupNames + ", groups=" + this.groups + ", selectedGroupName=" + this.selectedGroupName + ", currentMode=" + this.currentMode + ", configMode=" + this.configMode + ", modeSwitchAllowed=" + this.modeSwitchAllowed + ", sort=" + this.sort + ", isLoading=" + this.isLoading + ", isTesting=" + this.isTesting + ", testingProxies=" + this.testingProxies + ", testedProxies=" + this.testedProxies + ", error=" + this.error + ")";
    }
}
