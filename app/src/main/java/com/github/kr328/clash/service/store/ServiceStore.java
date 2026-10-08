package com.github.kr328.clash.service.store;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import coil.ImageLoader$Builder;
import coil.memory.MemoryCacheService;
import coil.request.Parameters;
import com.github.kr328.clash.common.constants.Authorities;
import com.github.kr328.clash.remote.Remote$$ExternalSyntheticLambda1;
import com.github.kr328.clash.service.BaseService;
import com.github.kr328.clash.service.PreferenceProvider;
import com.github.kr328.clash.service.TunService;
import com.github.kr328.clash.service.model.AccessControlMode;
import com.google.android.gms.tasks.zzr;
import java.util.Set;
import java.util.UUID;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import okhttp3.Dispatcher;
import rikka.preference.MultiProcessPreference;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ServiceStore {
    public static final /* synthetic */ KProperty[] $$delegatedProperties;
    public final Dispatcher accessControlMode$delegate;
    public final MemoryCacheService accessControlPackages$delegate;
    public final ImageLoader$Builder activeProfile$delegate;
    public final zzr allowBypass$delegate;
    public final zzr allowIpv6$delegate;
    public final zzr bypassPrivateNetwork$delegate;
    public final zzr dnsHijacking$delegate;
    public final zzr dynamicNotification$delegate;
    public final zzr systemProxy$delegate;
    public final ImageLoader$Builder tunStackMode$delegate;

    static {
        MutablePropertyReference1Impl mutablePropertyReference1Impl = new MutablePropertyReference1Impl(ServiceStore.class, "activeProfile", "getActiveProfile()Ljava/util/UUID;", 0);
        Reflection.factory.getClass();
        $$delegatedProperties = new KProperty[]{mutablePropertyReference1Impl, new MutablePropertyReference1Impl(ServiceStore.class, "bypassPrivateNetwork", "getBypassPrivateNetwork()Z", 0), new MutablePropertyReference1Impl(ServiceStore.class, "accessControlMode", "getAccessControlMode()Lcom/github/kr328/clash/service/model/AccessControlMode;", 0), new MutablePropertyReference1Impl(ServiceStore.class, "accessControlPackages", "getAccessControlPackages()Ljava/util/Set;", 0), new MutablePropertyReference1Impl(ServiceStore.class, "dnsHijacking", "getDnsHijacking()Z", 0), new MutablePropertyReference1Impl(ServiceStore.class, "systemProxy", "getSystemProxy()Z", 0), new MutablePropertyReference1Impl(ServiceStore.class, "allowBypass", "getAllowBypass()Z", 0), new MutablePropertyReference1Impl(ServiceStore.class, "allowIpv6", "getAllowIpv6()Z", 0), new MutablePropertyReference1Impl(ServiceStore.class, "tunStackMode", "getTunStackMode()Ljava/lang/String;", 0), new MutablePropertyReference1Impl(ServiceStore.class, "dynamicNotification", "getDynamicNotification()Z", 0)};
    }

    public ServiceStore(Context context) {
        int i = PreferenceProvider.$r8$clinit;
        Parameters.Builder builder = new Parameters.Builder(28, new MemoryCacheService(21, ((context instanceof BaseService) || (context instanceof TunService)) ? ((ContextWrapper) context).getSharedPreferences("service", 0) : new MultiProcessPreference(context, Authorities.SETTINGS_PROVIDER)));
        this.activeProfile$delegate = new ImageLoader$Builder(builder, new Remote$$ExternalSyntheticLambda1(12), new Remote$$ExternalSyntheticLambda1(11), 7);
        this.bypassPrivateNetwork$delegate = new zzr(builder, "bypass_private_network", true);
        this.accessControlMode$delegate = new Dispatcher(builder, "access_control_mode", AccessControlMode.AcceptAll, AccessControlMode.values());
        this.accessControlPackages$delegate = new MemoryCacheService(22, builder);
        this.dnsHijacking$delegate = new zzr(builder, "dns_hijacking", true);
        this.systemProxy$delegate = new zzr(builder, "system_proxy", true);
        this.allowBypass$delegate = new zzr(builder, "allow_bypass", true);
        this.allowIpv6$delegate = new zzr(builder, "allow_ipv6", false);
        this.tunStackMode$delegate = new ImageLoader$Builder(builder, "tun_stack_mode", "system", 6);
        this.dynamicNotification$delegate = new zzr(builder, "dynamic_notification", true);
    }

    public final Set getAccessControlPackages() {
        KProperty kProperty = $$delegatedProperties[3];
        return ((SharedPreferences) ((MemoryCacheService) ((Parameters.Builder) this.accessControlPackages$delegate.imageLoader).entries).imageLoader).getStringSet("access_control_packages", EmptySet.INSTANCE);
    }

    public final UUID getActiveProfile() {
        KProperty kProperty = $$delegatedProperties[0];
        ImageLoader$Builder imageLoader$Builder = this.activeProfile$delegate;
        MemoryCacheService memoryCacheService = (MemoryCacheService) ((Parameters.Builder) imageLoader$Builder.applicationContext).entries;
        return (UUID) ((Remote$$ExternalSyntheticLambda1) imageLoader$Builder.options).invoke(((SharedPreferences) memoryCacheService.imageLoader).getString("active_profile", (String) ((Remote$$ExternalSyntheticLambda1) imageLoader$Builder.defaults).invoke(null)));
    }

    public final boolean getAllowIpv6() {
        KProperty kProperty = $$delegatedProperties[7];
        return ((Boolean) this.allowIpv6$delegate.getValue()).booleanValue();
    }

    public final boolean getBypassPrivateNetwork() {
        KProperty kProperty = $$delegatedProperties[1];
        return ((Boolean) this.bypassPrivateNetwork$delegate.getValue()).booleanValue();
    }

    public final boolean getDynamicNotification() {
        KProperty kProperty = $$delegatedProperties[9];
        return ((Boolean) this.dynamicNotification$delegate.getValue()).booleanValue();
    }
}
