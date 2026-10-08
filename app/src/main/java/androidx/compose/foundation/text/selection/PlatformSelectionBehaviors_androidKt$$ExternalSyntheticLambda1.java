package androidx.compose.foundation.text.selection;

import android.content.Context;
import androidx.compose.ui.text.intl.LocaleList;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PlatformSelectionBehaviors_androidKt$$ExternalSyntheticLambda1 implements Function4 {
    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return new PlatformSelectionBehaviorsImpl((CoroutineContext) obj, (Context) obj2, (SelectedTextType) obj3, (LocaleList) obj4);
    }
}
