package com.github.kr328.clash.compose;

import androidx.compose.runtime.MutableState;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FilesScreenKt$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Function1 f$0;
    public final /* synthetic */ MutableState f$1;

    public /* synthetic */ FilesScreenKt$$ExternalSyntheticLambda1(Function1 function1, MutableState mutableState, int i) {
        this.$r8$classId = i;
        this.f$0 = function1;
        this.f$1 = mutableState;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                this.f$1.setValue(null);
                this.f$0.invoke((FileAction) obj);
                break;
            case 1:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                this.f$1.setValue(bool);
                this.f$0.invoke(bool);
                break;
            case 2:
                Boolean bool2 = (Boolean) obj;
                bool2.booleanValue();
                this.f$1.setValue(bool2);
                this.f$0.invoke(bool2);
                break;
            case 3:
                Boolean bool3 = (Boolean) obj;
                bool3.booleanValue();
                this.f$1.setValue(bool3);
                this.f$0.invoke(bool3);
                break;
            case 4:
                Boolean bool4 = (Boolean) obj;
                bool4.booleanValue();
                this.f$1.setValue(bool4);
                this.f$0.invoke(bool4);
                break;
            case 5:
                Boolean bool5 = (Boolean) obj;
                bool5.booleanValue();
                this.f$1.setValue(bool5);
                this.f$0.invoke(bool5);
                break;
            case 6:
                Boolean bool6 = (Boolean) obj;
                bool6.booleanValue();
                this.f$1.setValue(bool6);
                this.f$0.invoke(bool6);
                break;
            case 7:
                Boolean bool7 = (Boolean) obj;
                bool7.booleanValue();
                this.f$1.setValue(bool7);
                this.f$0.invoke(bool7);
                break;
            case 8:
                Boolean bool8 = (Boolean) obj;
                bool8.booleanValue();
                this.f$1.setValue(bool8);
                this.f$0.invoke(bool8);
                break;
            case 9:
                Boolean bool9 = (Boolean) obj;
                bool9.booleanValue();
                this.f$1.setValue(bool9);
                this.f$0.invoke(bool9);
                break;
            case 10:
                Boolean bool10 = (Boolean) obj;
                bool10.booleanValue();
                this.f$1.setValue(bool10);
                this.f$0.invoke(bool10);
                break;
            case 11:
                Boolean bool11 = (Boolean) obj;
                bool11.booleanValue();
                this.f$1.setValue(bool11);
                this.f$0.invoke(bool11);
                break;
            default:
                Integer num = (Integer) obj;
                num.getClass();
                this.f$1.setValue(Boolean.FALSE);
                this.f$0.invoke(num);
                break;
        }
        return Unit.INSTANCE;
    }
}
