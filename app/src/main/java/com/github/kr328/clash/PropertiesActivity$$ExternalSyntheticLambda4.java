package com.github.kr328.clash;

import android.content.Context;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.MutableState;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import com.github.kr328.clash.service.model.Profile;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class PropertiesActivity$$ExternalSyntheticLambda4 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ CoroutineScope f$0;
    public final /* synthetic */ MutableState f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ MutableState f$4;

    public /* synthetic */ PropertiesActivity$$ExternalSyntheticLambda4(CoroutineScope coroutineScope, MutableState mutableState, Object obj, Object obj2, MutableState mutableState2, int i) {
        this.$r8$classId = i;
        this.f$0 = coroutineScope;
        this.f$1 = mutableState;
        this.f$2 = obj;
        this.f$3 = obj2;
        this.f$4 = mutableState2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i = this.$r8$classId;
        Object obj = this.f$3;
        Object obj2 = this.f$2;
        CoroutineScope coroutineScope = this.f$0;
        switch (i) {
            case 0:
                PropertiesActivity propertiesActivity = (PropertiesActivity) obj2;
                Profile profile = (Profile) obj;
                int i2 = PropertiesActivity.$r8$clinit;
                MutableState mutableState = this.f$1;
                if (!((Boolean) mutableState.getValue()).booleanValue()) {
                    JobKt.launch$default(coroutineScope, null, new NavHostKt$NavHost$29$1(propertiesActivity, profile, mutableState, this.f$4, null, 13), 3);
                }
                break;
            default:
                Boolean bool = Boolean.TRUE;
                MutableState mutableState2 = this.f$1;
                mutableState2.setValue(bool);
                JobKt.launch$default(coroutineScope, null, new NavHostKt$NavHost$29$1((SnackbarHostState) obj2, (Context) obj, mutableState2, this.f$4, null, 18), 3);
                break;
        }
        return Unit.INSTANCE;
    }
}
