package com.github.kr328.clash.design.store;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import coil.ImageLoader$Builder;
import coil.memory.MemoryCacheService;
import coil.request.Parameters;
import com.github.kr328.clash.core.model.ProxySort;
import com.github.kr328.clash.design.model.AppInfoSort;
import com.github.kr328.clash.design.model.DarkMode;
import com.google.android.gms.dynamite.zze;
import com.google.android.gms.tasks.zzr;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class UiStore {
    public static final /* synthetic */ KProperty[] $$delegatedProperties;
    public static final zze Companion;
    public final zzr accessControlReverse$delegate;
    public final Dispatcher accessControlSort$delegate;
    public final zzr accessControlSystemApp$delegate;
    public final Dispatcher darkMode$delegate;
    public final zzr enableVpn$delegate;
    public final zzr hideAppIcon$delegate;
    public final zzr hideFromRecents$delegate;
    public final zzr proxyExcludeNotSelectable$delegate;
    public final ImageLoader$Builder proxyLastGroup$delegate;
    public final Dispatcher proxySort$delegate;

    static {
        MutablePropertyReference1Impl mutablePropertyReference1Impl = new MutablePropertyReference1Impl(UiStore.class, "enableVpn", "getEnableVpn()Z", 0);
        Reflection.factory.getClass();
        $$delegatedProperties = new KProperty[]{mutablePropertyReference1Impl, new MutablePropertyReference1Impl(UiStore.class, "darkMode", "getDarkMode()Lcom/github/kr328/clash/design/model/DarkMode;", 0), new MutablePropertyReference1Impl(UiStore.class, "hideAppIcon", "getHideAppIcon()Z", 0), new MutablePropertyReference1Impl(UiStore.class, "hideFromRecents", "getHideFromRecents()Z", 0), new MutablePropertyReference1Impl(UiStore.class, "proxyExcludeNotSelectable", "getProxyExcludeNotSelectable()Z", 0), new MutablePropertyReference1Impl(UiStore.class, "proxyLine", "getProxyLine()I", 0), new MutablePropertyReference1Impl(UiStore.class, "proxySort", "getProxySort()Lcom/github/kr328/clash/core/model/ProxySort;", 0), new MutablePropertyReference1Impl(UiStore.class, "proxyLastGroup", "getProxyLastGroup()Ljava/lang/String;", 0), new MutablePropertyReference1Impl(UiStore.class, "accessControlSort", "getAccessControlSort()Lcom/github/kr328/clash/design/model/AppInfoSort;", 0), new MutablePropertyReference1Impl(UiStore.class, "accessControlReverse", "getAccessControlReverse()Z", 0), new MutablePropertyReference1Impl(UiStore.class, "accessControlSystemApp", "getAccessControlSystemApp()Z", 0)};
        Companion = new zze(14);
    }

    public UiStore(Context context) {
        Parameters.Builder builder = new Parameters.Builder(28, new MemoryCacheService(21, context.getSharedPreferences("ui", 0)));
        this.enableVpn$delegate = new zzr(builder, "enable_vpn", true);
        this.darkMode$delegate = new Dispatcher(builder, "dark_mode", DarkMode.Auto, DarkMode.values());
        PackageManager packageManager = context.getPackageManager();
        Companion.getClass();
        int componentEnabledSetting = packageManager.getComponentEnabledSetting(new ComponentName(context, "com.github.kr328.clash.MainActivityAlias"));
        this.hideAppIcon$delegate = new zzr(builder, "hide_app_icon", (componentEnabledSetting == 1 || componentEnabledSetting == 0) ? false : true);
        this.hideFromRecents$delegate = new zzr(builder, "hide_from_recents", false);
        this.proxyExcludeNotSelectable$delegate = new zzr(builder, "proxy_exclude_not_selectable", false);
        this.proxySort$delegate = new Dispatcher(builder, "proxy_sort", ProxySort.Default, ProxySort.values());
        this.proxyLastGroup$delegate = new ImageLoader$Builder(builder, "proxy_last_group", "", 6);
        this.accessControlSort$delegate = new Dispatcher(builder, "access_control_sort", AppInfoSort.Label, AppInfoSort.values());
        this.accessControlReverse$delegate = new zzr(builder, "access_control_reverse", false);
        this.accessControlSystemApp$delegate = new zzr(builder, "access_control_system_app", false);
    }
}
