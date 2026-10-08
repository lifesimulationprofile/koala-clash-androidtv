package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ComponentRuntime$$Lambda$5 implements Provider {
    public static final ComponentRuntime$$Lambda$5 instance = new ComponentRuntime$$Lambda$5(0);
    public static final ComponentRuntime$$Lambda$5 instance$1 = new ComponentRuntime$$Lambda$5(1);
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ ComponentRuntime$$Lambda$5(int i) {
        this.$r8$classId = i;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        switch (this.$r8$classId) {
            case 0:
                return Collections.EMPTY_SET;
            default:
                return null;
        }
    }
}
