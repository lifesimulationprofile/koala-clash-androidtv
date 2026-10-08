package androidx.compose.material3;

import android.net.Uri;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.focus.FocusStateImpl;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1;
import com.github.kr328.clash.FilesActivity;
import com.github.kr328.clash.PropertiesActivity;
import com.github.kr328.clash.compose.connections.ConnectionsScreenKt;
import com.github.kr328.clash.compose.home.HomeViewModel$observer$1;
import com.github.kr328.clash.remote.Remote;
import com.github.kr328.clash.service.model.Profile;
import java.util.UUID;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.JsonImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TooltipKt$$ExternalSyntheticLambda7 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ MutableState f$0;

    public /* synthetic */ TooltipKt$$ExternalSyntheticLambda7(MutableState mutableState, int i) {
        this.$r8$classId = i;
        this.f$0 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i = this.$r8$classId;
        MutableState mutableState = this.f$0;
        switch (i) {
            case 0:
                mutableState.setValue((LayoutCoordinates) obj);
                return Unit.INSTANCE;
            case 1:
                Float f = (Float) obj;
                f.getClass();
                return Float.valueOf(((Number) ((Function1) mutableState.getValue()).invoke(f)).floatValue());
            case 2:
                ((Function1) mutableState.getValue()).invoke((Offset) obj);
                return Unit.INSTANCE;
            case 3:
                mutableState.setValue((LayoutCoordinates) obj);
                return Unit.INSTANCE;
            case 4:
                mutableState.setValue((LayoutCoordinates) obj);
                return Unit.INSTANCE;
            case 5:
                mutableState.setValue((LayoutCoordinates) obj);
                return Unit.INSTANCE;
            case 6:
                mutableState.setValue((Selection) obj);
                return Unit.INSTANCE;
            case 7:
                mutableState.setValue(new Offset(((LayoutCoordinates) obj).mo526localToScreenMKHz9U(0L)));
                return Unit.INSTANCE;
            case 8:
                Uri uri = (Uri) obj;
                int i2 = FilesActivity.$r8$clinit;
                if (uri != null) {
                    String str = (String) CollectionsKt.lastOrNull(StringsKt.split$default(uri.getSchemeSpecificPart(), new String[]{"/"}, 0, 6));
                    if (str == null) {
                        str = "File";
                    }
                    mutableState.setValue(new Pair(str, uri));
                }
                return Unit.INSTANCE;
            case 9:
                int i3 = PropertiesActivity.$r8$clinit;
                mutableState.setValue((Profile) obj);
                return Unit.INSTANCE;
            case 10:
                int i4 = PropertiesActivity.$r8$clinit;
                mutableState.setValue((UUID) obj);
                return Unit.INSTANCE;
            case 11:
                mutableState.setValue(Boolean.valueOf(((FocusStateImpl) obj).isFocused()));
                return Unit.INSTANCE;
            case 12:
                mutableState.setValue((String) obj);
                return Unit.INSTANCE;
            case 13:
                mutableState.setValue(Boolean.valueOf(((FocusStateImpl) obj).isFocused()));
                return Unit.INSTANCE;
            case 14:
                mutableState.setValue(Boolean.valueOf(((FocusStateImpl) obj).isFocused()));
                return Unit.INSTANCE;
            case 15:
                mutableState.setValue((String) obj);
                return Unit.INSTANCE;
            case 16:
                HomeViewModel$observer$1 homeViewModel$observer$1 = new HomeViewModel$observer$1(1, mutableState);
                Remote.broadcasts.addObserver(homeViewModel$observer$1);
                return new AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1(17, homeViewModel$observer$1);
            case 17:
                JsonImpl jsonImpl = ConnectionsScreenKt.connectionJson;
                mutableState.setValue((String) obj);
                return Unit.INSTANCE;
            case 18:
                mutableState.setValue(Boolean.valueOf(((FocusStateImpl) obj).isFocused()));
                return Unit.INSTANCE;
            case 19:
                mutableState.setValue(Boolean.valueOf(((FocusStateImpl) obj).isFocused()));
                return Unit.INSTANCE;
            case 20:
                mutableState.setValue(Boolean.valueOf(((FocusStateImpl) obj).getHasFocus()));
                return Unit.INSTANCE;
            case 21:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                mutableState.setValue(bool);
                return Unit.INSTANCE;
            case 22:
                mutableState.setValue(Boolean.valueOf(((FocusStateImpl) obj).isFocused()));
                return Unit.INSTANCE;
            case 23:
                mutableState.setValue(Boolean.valueOf(((FocusStateImpl) obj).isFocused()));
                return Unit.INSTANCE;
            case 24:
                mutableState.setValue(Boolean.valueOf(((FocusStateImpl) obj).isFocused()));
                return Unit.INSTANCE;
            case 25:
                mutableState.setValue(Boolean.valueOf(((FocusStateImpl) obj).isFocused()));
                return Unit.INSTANCE;
            case 26:
                mutableState.setValue((String) obj);
                return Unit.INSTANCE;
            case 27:
                mutableState.setValue(Boolean.valueOf(((FocusStateImpl) obj).isFocused()));
                return Unit.INSTANCE;
            default:
                mutableState.setValue(Boolean.valueOf(((FocusStateImpl) obj).isFocused()));
                return Unit.INSTANCE;
        }
    }
}
