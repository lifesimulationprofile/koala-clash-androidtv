package androidx.compose.runtime.composer.gapbuffer.changelist;

import androidx.collection.CircularArray;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.GapComposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.composer.gapbuffer.GapAnchor;
import androidx.compose.runtime.composer.gapbuffer.SlotWriter;
import androidx.compose.runtime.tooling.ComposeStackTraceKt;
import com.google.android.gms.internal.mlkit_vision_barcode.zzsj;
import com.google.android.gms.internal.mlkit_vision_common.zzky;
import java.util.Arrays;
import kotlin.collections.ArraysKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Operations extends zzsj {
    public int intArgsSize;
    public int objectArgsSize;
    public int opCodesSize;
    public Operation[] opCodes = new Operation[16];
    public int[] intArgs = new int[16];
    public Object[] objectArgs = new Object[16];

    public final void clear() {
        this.opCodesSize = 0;
        this.intArgsSize = 0;
        Arrays.fill(this.objectArgs, 0, this.objectArgsSize, (Object) null);
        this.objectArgsSize = 0;
    }

    public final void executeAndFlushAllPendingOperations(Applier applier, SlotWriter slotWriter, zzky zzkyVar, OperationErrorContext operationErrorContext) {
        if (this.opCodesSize != 0) {
            CircularArray circularArray = new CircularArray(this);
            Operations operations = (Operations) circularArray.elements;
            while (true) {
                Operation operation = operations.opCodes[circularArray.head];
                GapAnchor groupAnchor = operation.getGroupAnchor(circularArray);
                Applier applier2 = applier;
                SlotWriter slotWriter2 = slotWriter;
                zzky zzkyVar2 = zzkyVar;
                OperationErrorContext operationErrorContext2 = operationErrorContext;
                try {
                    operation.execute(circularArray, applier2, slotWriter2, zzkyVar2, operationErrorContext2);
                    int i = circularArray.head;
                    int i2 = operations.opCodesSize;
                    if (i < i2) {
                        Operation operation2 = operations.opCodes[i];
                        circularArray.tail += operation2.ints;
                        circularArray.capacityBitmask += operation2.objects;
                        int i3 = i + 1;
                        circularArray.head = i3;
                        if (i3 >= i2) {
                            break;
                        }
                        applier = applier2;
                        slotWriter = slotWriter2;
                        zzkyVar = zzkyVar2;
                        operationErrorContext = operationErrorContext2;
                    } else {
                        break;
                    }
                } catch (Throwable th) {
                    if (operationErrorContext2 == null) {
                        throw th;
                    }
                    ComposeStackTraceKt.tryAttachComposeStackTrace(th, new GapComposer$$ExternalSyntheticLambda0(groupAnchor, slotWriter2, operationErrorContext2, 8));
                    throw th;
                }
            }
        }
        clear();
    }

    public final boolean isEmpty() {
        return this.opCodesSize == 0;
    }

    public final void pushOp(Operation operation) {
        int i = this.opCodesSize;
        Operation[] operationArr = this.opCodes;
        if (i == operationArr.length) {
            Operation[] operationArr2 = new Operation[(i > 1024 ? 1024 : i) + i];
            System.arraycopy(operationArr, 0, operationArr2, 0, i);
            this.opCodes = operationArr2;
        }
        int i2 = this.intArgsSize;
        int i3 = operation.ints;
        int i4 = operation.objects;
        int i5 = i2 + i3;
        int[] iArr = this.intArgs;
        int length = iArr.length;
        if (i5 > length) {
            int i6 = (length > 1024 ? 1024 : length) + length;
            if (i6 >= i5) {
                i5 = i6;
            }
            int[] iArr2 = new int[i5];
            ArraysKt.copyInto(0, 0, length, iArr, iArr2);
            this.intArgs = iArr2;
        }
        int i7 = this.objectArgsSize + i4;
        Object[] objArr = this.objectArgs;
        int length2 = objArr.length;
        if (i7 > length2) {
            int i8 = (length2 <= 1024 ? length2 : 1024) + length2;
            if (i8 >= i7) {
                i7 = i8;
            }
            Object[] objArr2 = new Object[i7];
            System.arraycopy(objArr, 0, objArr2, 0, length2);
            this.objectArgs = objArr2;
        }
        Operation[] operationArr3 = this.opCodes;
        int i9 = this.opCodesSize;
        this.opCodesSize = i9 + 1;
        operationArr3[i9] = operation;
        this.intArgsSize += operation.ints;
        this.objectArgsSize += i4;
    }
}
