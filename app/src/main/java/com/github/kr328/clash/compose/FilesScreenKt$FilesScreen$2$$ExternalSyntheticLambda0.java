package com.github.kr328.clash.compose;

import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import coil.compose.AsyncImagePainter$$ExternalSyntheticLambda0;
import com.github.kr328.clash.design.model.DarkMode;
import com.github.kr328.clash.service.model.AccessControlMode;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FilesScreenKt$FilesScreen$2$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ List f$0;
    public final /* synthetic */ Function1 f$1;
    public final /* synthetic */ MutableState f$2;

    public /* synthetic */ FilesScreenKt$FilesScreen$2$$ExternalSyntheticLambda0(List list, Function1 function1, MutableState mutableState, int i) {
        this.$r8$classId = i;
        this.f$0 = list;
        this.f$1 = function1;
        this.f$2 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                AsyncImagePainter$$ExternalSyntheticLambda0 asyncImagePainter$$ExternalSyntheticLambda0 = new AsyncImagePainter$$ExternalSyntheticLambda0(7);
                List list = this.f$0;
                ((LazyListIntervalContent) obj).items(list.size(), new FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2(0, list, asyncImagePainter$$ExternalSyntheticLambda0), new FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2(1, list), new ComposableLambdaImpl(802480018, new MainAppKt$MainApp$2$3$1$1$1$2(list, this.f$1, this.f$2, 1), true));
                break;
            case 1:
                DarkMode darkMode = (DarkMode) this.f$0.get(((Integer) obj).intValue());
                this.f$2.setValue(darkMode);
                this.f$1.invoke(darkMode);
                break;
            case 2:
                String str = (String) this.f$0.get(((Integer) obj).intValue());
                this.f$2.setValue(str);
                this.f$1.invoke(str);
                break;
            default:
                AccessControlMode accessControlMode = (AccessControlMode) this.f$0.get(((Integer) obj).intValue());
                this.f$2.setValue(accessControlMode);
                this.f$1.invoke(accessControlMode);
                break;
        }
        return Unit.INSTANCE;
    }
}
