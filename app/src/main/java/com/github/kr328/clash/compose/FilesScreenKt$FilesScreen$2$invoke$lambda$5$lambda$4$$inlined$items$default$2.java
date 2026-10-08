package com.github.kr328.clash.compose;

import com.github.kr328.clash.compose.connections.ProcessGroup;
import com.github.kr328.clash.core.model.ConnectionInfo;
import com.github.kr328.clash.core.model.Proxy;
import com.github.kr328.clash.design.model.AppInfo;
import com.github.kr328.clash.design.model.File;
import com.github.kr328.clash.service.model.Profile;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2 implements Function1 {
    public final /* synthetic */ List $items;
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2(int i, List list) {
        this.$r8$classId = i;
        this.$items = list;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return ((File) this.$items.get(((Number) obj).intValue())).id;
            case 1:
                this.$items.get(((Number) obj).intValue());
                return null;
            case 2:
                this.$items.get(((Number) obj).intValue());
                return null;
            case 3:
                this.$items.get(((Number) obj).intValue());
                return null;
            case 4:
                return ((ConnectionInfo) this.$items.get(((Number) obj).intValue())).id;
            case 5:
                this.$items.get(((Number) obj).intValue());
                return null;
            case 6:
                this.$items.get(((Number) obj).intValue());
                return null;
            case 7:
                return ((ProcessGroup) this.$items.get(((Number) obj).intValue())).process;
            case 8:
                this.$items.get(((Number) obj).intValue());
                return null;
            case 9:
                this.$items.get(((Number) obj).intValue());
                return null;
            case 10:
                return (String) this.$items.get(((Number) obj).intValue());
            case 11:
                this.$items.get(((Number) obj).intValue());
                return null;
            case 12:
                return ((Proxy) this.$items.get(((Number) obj).intValue())).name;
            case 13:
                this.$items.get(((Number) obj).intValue());
                return null;
            case 14:
                return ((AppInfo) this.$items.get(((Number) obj).intValue())).packageName;
            case 15:
                this.$items.get(((Number) obj).intValue());
                return null;
            case 16:
                this.$items.get(((Number) obj).intValue());
                return null;
            case 17:
                return ((Profile) this.$items.get(((Number) obj).intValue())).uuid;
            default:
                this.$items.get(((Number) obj).intValue());
                return null;
        }
    }

    public /* synthetic */ FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2(int i, List list, Function1 function1) {
        this.$r8$classId = i;
        this.$items = list;
    }
}
