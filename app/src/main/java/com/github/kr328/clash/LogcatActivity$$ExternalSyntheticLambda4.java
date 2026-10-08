package com.github.kr328.clash;

import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.material3.internal.LayoutUtilKt;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import com.github.kr328.clash.compose.PropertiesScreenKt;
import com.github.kr328.clash.design.compose.theme.AppThemeKt;
import kotlin.Function;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LogcatActivity$$ExternalSyntheticLambda4 implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ boolean f$1;

    public /* synthetic */ LogcatActivity$$ExternalSyntheticLambda4(int i, int i2, Object obj, boolean z) {
        this.$r8$classId = i2;
        this.f$0 = obj;
        this.f$1 = z;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        int i = this.$r8$classId;
        Object obj3 = this.f$0;
        boolean z = this.f$1;
        switch (i) {
            case 0:
                ((Integer) obj2).getClass();
                int i2 = LogcatActivity.$r8$clinit;
                ((LogcatActivity) obj3).StreamingLogContent(Stack.updateChangedFlags(1), (GapComposer) obj, z);
                break;
            case 1:
                ((Integer) obj2).getClass();
                BasicTextKt.SelectionToolbarAndHandles((TextFieldSelectionManager) obj3, z, (GapComposer) obj, Stack.updateChangedFlags(1));
                break;
            case 2:
                ((Integer) obj2).getClass();
                LayoutUtilKt.PredictiveBackHandler(z, (Function2) obj3, (GapComposer) obj, Stack.updateChangedFlags(1));
                break;
            case 3:
                ((Integer) obj2).getClass();
                PropertiesScreenKt.SaveBar(z, (Function0) obj3, (GapComposer) obj, Stack.updateChangedFlags(1));
                break;
            default:
                ((Integer) obj2).getClass();
                AppThemeKt.AppTheme(z, (ComposableLambdaImpl) obj3, (GapComposer) obj, Stack.updateChangedFlags(49));
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ LogcatActivity$$ExternalSyntheticLambda4(boolean z, Function function, int i, int i2) {
        this.$r8$classId = i2;
        this.f$1 = z;
        this.f$0 = function;
    }
}
