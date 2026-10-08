package androidx.compose.runtime.saveable;

import androidx.core.view.MenuHostHelper;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public interface SaveableStateRegistry {
    boolean canBeSaved(Object obj);

    Object consumeRestored(String str);

    Map performSave();

    MenuHostHelper registerProvider(String str, Function0 function0);
}
