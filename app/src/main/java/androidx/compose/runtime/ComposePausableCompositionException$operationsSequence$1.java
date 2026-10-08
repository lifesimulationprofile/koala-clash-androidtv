package androidx.compose.runtime;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.collection.MutableIntList;
import androidx.collection.MutableObjectList;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.SequenceBuilderIterator;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ComposePausableCompositionException$operationsSequence$1 extends RestrictedSuspendLambda implements Function2 {
    public int I$0;
    public int I$1;
    public int I$2;
    public /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ ComposePausableCompositionException this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposePausableCompositionException$operationsSequence$1(ComposePausableCompositionException composePausableCompositionException, Continuation continuation) {
        super(2, continuation);
        this.this$0 = composePausableCompositionException;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ComposePausableCompositionException$operationsSequence$1 composePausableCompositionException$operationsSequence$1 = new ComposePausableCompositionException$operationsSequence$1(this.this$0, continuation);
        composePausableCompositionException$operationsSequence$1.L$0 = obj;
        return composePausableCompositionException$operationsSequence$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((ComposePausableCompositionException$operationsSequence$1) create((SequenceBuilderIterator) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SequenceBuilderIterator sequenceBuilderIterator;
        int i;
        int i2;
        int i3;
        String strM;
        int i4;
        int i5;
        String str;
        ComposePausableCompositionException composePausableCompositionException = this.this$0;
        MutableObjectList mutableObjectList = composePausableCompositionException.instances;
        MutableIntList mutableIntList = composePausableCompositionException.operations;
        int i6 = this.label;
        if (i6 == 0) {
            ResultKt.throwOnFailure(obj);
            sequenceBuilderIterator = (SequenceBuilderIterator) this.L$0;
            i = 0;
            i2 = 0;
            i3 = 0;
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = this.I$2;
            i2 = this.I$1;
            i3 = this.I$0;
            sequenceBuilderIterator = (SequenceBuilderIterator) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        if (i3 >= Math.min(composePausableCompositionException.lastOperation + 10, mutableIntList._size)) {
            return Unit.INSTANCE;
        }
        int i7 = i3 + 1;
        int i8 = mutableIntList.get(i3);
        switch (i8) {
            case 0:
                strM = "up";
                break;
            case 1:
                Object obj2 = mutableObjectList.get(i2);
                i2++;
                strM = "down " + obj2;
                break;
            case 2:
                strM = "remove " + mutableIntList.get(i7) + ' ' + mutableIntList.get(i3 + 2);
                i7 = i3 + 3;
                break;
            case 3:
                strM = "move " + mutableIntList.get(i7) + ' ' + mutableIntList.get(i3 + 2) + ' ' + mutableIntList.get(i3 + 3);
                i7 = i3 + 4;
                break;
            case 4:
                strM = "clear";
                break;
            case 5:
                i4 = i3 + 2;
                int i9 = mutableIntList.get(i7);
                i5 = i2 + 1;
                str = "insertBottomUp " + i9 + ' ' + mutableObjectList.get(i2);
                int i10 = i4;
                strM = str;
                i7 = i10;
                i2 = i5;
                break;
            case 6:
                i4 = i3 + 2;
                int i11 = mutableIntList.get(i7);
                i5 = i2 + 1;
                str = "insertTopDown " + i11 + ' ' + mutableObjectList.get(i2);
                int i12 = i4;
                strM = str;
                i7 = i12;
                i2 = i5;
                break;
            case 7:
                Object obj3 = mutableObjectList.get(i2);
                TypeIntrinsics.beforeCheckcastToFunctionOfArity(2, obj3);
                i2 += 2;
                strM = "apply " + ((Function2) obj3);
                break;
            case 8:
                strM = "reuse " + composePausableCompositionException.reused.get(i);
                i++;
                break;
            case 9:
                strM = "recompose pending";
                break;
            default:
                strM = ImageAnalysis$$ExternalSyntheticLambda1.m("unknown op: ", i8);
                break;
        }
        this.L$0 = sequenceBuilderIterator;
        this.I$0 = i7;
        this.I$1 = i2;
        this.I$2 = i;
        this.label = 1;
        sequenceBuilderIterator.yield(i3 + ": " + strM, this);
        return CoroutineSingletons.COROUTINE_SUSPENDED;
    }
}
