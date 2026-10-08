package androidx.compose.material3;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.foundation.lazy.LazyListItemProviderImpl;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.layout.LayoutCoordinates;
import coil.network.HttpException;
import com.github.kr328.clash.FilesActivity;
import com.github.kr328.clash.compose.TvMainAppKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class TooltipKt$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ MutableState f$0;

    public /* synthetic */ TooltipKt$$ExternalSyntheticLambda0(MutableState mutableState, int i) {
        this.$r8$classId = i;
        this.f$0 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i = this.$r8$classId;
        MutableState mutableState = this.f$0;
        switch (i) {
            case 0:
                return (LayoutCoordinates) mutableState.getValue();
            case 1:
                return new LazyListIntervalContent((Function1) mutableState.getValue());
            case 2:
                return (LazyListItemProviderImpl) ((Function0) mutableState.getValue()).invoke();
            case 3:
                Boolean bool = (Boolean) mutableState.getValue();
                bool.booleanValue();
                return bool;
            case 4:
                LayoutCoordinates layoutCoordinates = (LayoutCoordinates) mutableState.getValue();
                if (layoutCoordinates != null) {
                    return layoutCoordinates;
                }
                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Required value was null.");
                throw new HttpException();
            case 5:
                LayoutCoordinates layoutCoordinates2 = (LayoutCoordinates) mutableState.getValue();
                if (layoutCoordinates2 != null) {
                    return layoutCoordinates2;
                }
                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Required value was null.");
                throw new HttpException();
            case 6:
                LayoutCoordinates layoutCoordinates3 = (LayoutCoordinates) mutableState.getValue();
                if (layoutCoordinates3 != null) {
                    return layoutCoordinates3;
                }
                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Required value was null.");
                throw new HttpException();
            case 7:
                int i2 = FilesActivity.$r8$clinit;
                mutableState.setValue(null);
                return Unit.INSTANCE;
            case 8:
                int i3 = FilesActivity.$r8$clinit;
                mutableState.setValue(null);
                return Unit.INSTANCE;
            case 9:
                mutableState.setValue(null);
                return Unit.INSTANCE;
            case 10:
                mutableState.setValue(Boolean.FALSE);
                return Unit.INSTANCE;
            case 11:
                mutableState.setValue(Boolean.TRUE);
                return Unit.INSTANCE;
            case 12:
                mutableState.setValue(Boolean.FALSE);
                return Unit.INSTANCE;
            case 13:
                mutableState.setValue(Boolean.FALSE);
                return Unit.INSTANCE;
            case 14:
                mutableState.setValue(Boolean.FALSE);
                return Unit.INSTANCE;
            case 15:
                mutableState.setValue(Boolean.TRUE);
                return Unit.INSTANCE;
            case 16:
                mutableState.setValue(Boolean.TRUE);
                return Unit.INSTANCE;
            case 17:
                mutableState.setValue(Boolean.TRUE);
                return Unit.INSTANCE;
            case 18:
                mutableState.setValue(Boolean.FALSE);
                return Unit.INSTANCE;
            case 19:
                mutableState.setValue(Boolean.FALSE);
                return Unit.INSTANCE;
            case 20:
                mutableState.setValue(Boolean.FALSE);
                return Unit.INSTANCE;
            case 21:
                mutableState.setValue(Boolean.TRUE);
                return Unit.INSTANCE;
            case 22:
                float f = TvMainAppKt.TvOverscanHorizontal;
                mutableState.setValue(Boolean.TRUE);
                return Unit.INSTANCE;
            case 23:
                float f2 = TvMainAppKt.TvOverscanHorizontal;
                mutableState.setValue(Boolean.FALSE);
                return Unit.INSTANCE;
            case 24:
                float f3 = TvMainAppKt.TvOverscanHorizontal;
                mutableState.setValue(Boolean.TRUE);
                return Unit.INSTANCE;
            case 25:
                float f4 = TvMainAppKt.TvOverscanHorizontal;
                mutableState.setValue(Boolean.TRUE);
                return Unit.INSTANCE;
            case 26:
                float f5 = TvMainAppKt.TvOverscanHorizontal;
                mutableState.setValue(Boolean.FALSE);
                return Unit.INSTANCE;
            case 27:
                float f6 = TvMainAppKt.TvOverscanHorizontal;
                mutableState.setValue(Boolean.FALSE);
                return Unit.INSTANCE;
            case 28:
                mutableState.setValue(null);
                return Unit.INSTANCE;
            default:
                mutableState.setValue(null);
                return Unit.INSTANCE;
        }
    }
}
