package com.github.kr328.clash.compose.util;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.Recomposer$join$2;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SafeFlow;
import kotlinx.serialization.internal.EnumDescriptor$$ExternalSyntheticLambda0;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TvGlassTabRowKt$TvGlassTabRow$4$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Animatable $indicatorOffset;
    public final /* synthetic */ SpringSpec $indicatorSpring;
    public final /* synthetic */ Animatable $indicatorWidth;
    public final /* synthetic */ MutableState $isFirstLayout$delegate;
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ int $selectedTabIndex;
    public final /* synthetic */ SnapshotStateMap $tabOffsets;
    public final /* synthetic */ SnapshotStateMap $tabWidths;
    public float F$0;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX INFO: renamed from: com.github.kr328.clash.compose.util.TvGlassTabRowKt$TvGlassTabRow$4$1$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass3 extends SuspendLambda implements Function2 {
        public final /* synthetic */ Animatable $indicatorOffset;
        public final /* synthetic */ SpringSpec $indicatorSpring;
        public final /* synthetic */ float $offset;
        public final /* synthetic */ int $r8$classId;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass3(Animatable animatable, float f, SpringSpec springSpec, Continuation continuation, int i) {
            super(2, continuation);
            this.$r8$classId = i;
            this.$indicatorOffset = animatable;
            this.$offset = f;
            this.$indicatorSpring = springSpec;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            switch (this.$r8$classId) {
                case 0:
                    return new AnonymousClass3(this.$indicatorOffset, this.$offset, this.$indicatorSpring, continuation, 0);
                case 1:
                    return new AnonymousClass3(this.$indicatorOffset, this.$offset, this.$indicatorSpring, continuation, 1);
                case 2:
                    return new AnonymousClass3(this.$indicatorOffset, this.$offset, this.$indicatorSpring, continuation, 2);
                default:
                    return new AnonymousClass3(this.$indicatorOffset, this.$offset, this.$indicatorSpring, continuation, 3);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            CoroutineScope coroutineScope = (CoroutineScope) obj;
            Continuation continuation = (Continuation) obj2;
            switch (this.$r8$classId) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
            }
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            switch (this.$r8$classId) {
                case 0:
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Float f = new Float(this.$offset);
                        this.label = 1;
                        Object objAnimateTo$default = Animatable.animateTo$default(this.$indicatorOffset, f, this.$indicatorSpring, null, this, 12);
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (objAnimateTo$default == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                case 1:
                    int i2 = this.label;
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj);
                        Float f2 = new Float(this.$offset);
                        this.label = 1;
                        Object objAnimateTo$default2 = Animatable.animateTo$default(this.$indicatorOffset, f2, this.$indicatorSpring, null, this, 12);
                        CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (objAnimateTo$default2 == coroutineSingletons2) {
                            return coroutineSingletons2;
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                case 2:
                    int i3 = this.label;
                    if (i3 == 0) {
                        ResultKt.throwOnFailure(obj);
                        Float f3 = new Float(this.$offset);
                        this.label = 1;
                        Object objAnimateTo$default3 = Animatable.animateTo$default(this.$indicatorOffset, f3, this.$indicatorSpring, null, this, 12);
                        CoroutineSingletons coroutineSingletons3 = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (objAnimateTo$default3 == coroutineSingletons3) {
                            return coroutineSingletons3;
                        }
                    } else {
                        if (i3 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                default:
                    int i4 = this.label;
                    if (i4 == 0) {
                        ResultKt.throwOnFailure(obj);
                        Float f4 = new Float(this.$offset);
                        this.label = 1;
                        Object objAnimateTo$default4 = Animatable.animateTo$default(this.$indicatorOffset, f4, this.$indicatorSpring, null, this, 12);
                        CoroutineSingletons coroutineSingletons4 = CoroutineSingletons.COROUTINE_SUSPENDED;
                        if (objAnimateTo$default4 == coroutineSingletons4) {
                            return coroutineSingletons4;
                        }
                    } else {
                        if (i4 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TvGlassTabRowKt$TvGlassTabRow$4$1(int i, SnapshotStateMap snapshotStateMap, SnapshotStateMap snapshotStateMap2, Animatable animatable, Animatable animatable2, MutableState mutableState, SpringSpec springSpec, Continuation continuation) {
        super(2, continuation);
        this.$selectedTabIndex = i;
        this.$tabOffsets = snapshotStateMap;
        this.$tabWidths = snapshotStateMap2;
        this.$indicatorOffset = animatable;
        this.$indicatorWidth = animatable2;
        this.$isFirstLayout$delegate = mutableState;
        this.$indicatorSpring = springSpec;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                TvGlassTabRowKt$TvGlassTabRow$4$1 tvGlassTabRowKt$TvGlassTabRow$4$1 = new TvGlassTabRowKt$TvGlassTabRow$4$1(this.$tabOffsets, this.$selectedTabIndex, this.$tabWidths, this.$indicatorOffset, this.$indicatorWidth, this.$isFirstLayout$delegate, this.$indicatorSpring, continuation);
                tvGlassTabRowKt$TvGlassTabRow$4$1.L$0 = obj;
                return tvGlassTabRowKt$TvGlassTabRow$4$1;
            default:
                TvGlassTabRowKt$TvGlassTabRow$4$1 tvGlassTabRowKt$TvGlassTabRow$4$2 = new TvGlassTabRowKt$TvGlassTabRow$4$1(this.$selectedTabIndex, this.$tabOffsets, this.$tabWidths, this.$indicatorOffset, this.$indicatorWidth, this.$isFirstLayout$delegate, this.$indicatorSpring, continuation);
                tvGlassTabRowKt$TvGlassTabRow$4$2.L$0 = obj;
                return tvGlassTabRowKt$TvGlassTabRow$4$2;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return ((TvGlassTabRowKt$TvGlassTabRow$4$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:62:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:? A[RETURN, SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        float f;
        Float f2;
        CoroutineScope coroutineScope2;
        float f3;
        Float f4;
        switch (this.$r8$classId) {
            case 0:
                int i = this.label;
                Animatable animatable = this.$indicatorWidth;
                MutableState mutableState = this.$isFirstLayout$delegate;
                SnapshotStateMap snapshotStateMap = this.$tabWidths;
                SnapshotStateMap snapshotStateMap2 = this.$tabOffsets;
                int i2 = this.$selectedTabIndex;
                Continuation continuation = null;
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (i != 0) {
                    if (i == 1) {
                        coroutineScope = (CoroutineScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else if (i == 2) {
                        f = this.F$0;
                        ResultKt.throwOnFailure(obj);
                        f2 = new Float(f);
                        this.label = 3;
                        if (animatable.snapTo(f2, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    } else {
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    mutableState.setValue(Boolean.FALSE);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.L$0;
                SafeFlow safeFlowSnapshotFlow = Stack.snapshotFlow(new EnumDescriptor$$ExternalSyntheticLambda0(snapshotStateMap2, i2, snapshotStateMap, 1));
                Recomposer$join$2 recomposer$join$2 = new Recomposer$join$2(2, null, 12);
                this.L$0 = coroutineScope;
                this.label = 1;
                if (FlowKt.first(safeFlowSnapshotFlow, recomposer$join$2, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
                float fFloatValue = ((Number) snapshotStateMap2.get(new Integer(i2))).floatValue();
                float fFloatValue2 = ((Number) snapshotStateMap.get(new Integer(i2))).floatValue();
                boolean zBooleanValue = ((Boolean) mutableState.getValue()).booleanValue();
                Animatable animatable2 = this.$indicatorOffset;
                if (zBooleanValue) {
                    Float f5 = new Float(fFloatValue);
                    this.L$0 = null;
                    this.F$0 = fFloatValue2;
                    this.label = 2;
                    if (animatable2.snapTo(f5, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    f = fFloatValue2;
                    f2 = new Float(f);
                    this.label = 3;
                    if (animatable.snapTo(f2, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    mutableState.setValue(Boolean.FALSE);
                } else {
                    SpringSpec springSpec = this.$indicatorSpring;
                    JobKt.launch$default(coroutineScope, null, new AnonymousClass3(animatable2, fFloatValue, springSpec, continuation, 0), 3);
                    JobKt.launch$default(coroutineScope, null, new AnonymousClass3(animatable, fFloatValue2, springSpec, continuation, 1), 3);
                }
                return Unit.INSTANCE;
            default:
                int i3 = this.label;
                Animatable animatable3 = this.$indicatorWidth;
                MutableState mutableState2 = this.$isFirstLayout$delegate;
                SnapshotStateMap snapshotStateMap3 = this.$tabWidths;
                SnapshotStateMap snapshotStateMap4 = this.$tabOffsets;
                int i4 = this.$selectedTabIndex;
                Continuation continuation2 = null;
                CoroutineSingletons coroutineSingletons2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (i3 != 0) {
                    if (i3 == 1) {
                        coroutineScope2 = (CoroutineScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else if (i3 == 2) {
                        f3 = this.F$0;
                        ResultKt.throwOnFailure(obj);
                        f4 = new Float(f3);
                        this.label = 3;
                        if (animatable3.snapTo(f4, this) == coroutineSingletons2) {
                            return coroutineSingletons2;
                        }
                    } else {
                        if (i3 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    mutableState2.setValue(Boolean.FALSE);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                coroutineScope2 = (CoroutineScope) this.L$0;
                if (i4 < 0) {
                    return Unit.INSTANCE;
                }
                SafeFlow safeFlowSnapshotFlow2 = Stack.snapshotFlow(new EnumDescriptor$$ExternalSyntheticLambda0(snapshotStateMap4, i4, snapshotStateMap3, 2));
                Recomposer$join$2 recomposer$join$3 = new Recomposer$join$2(2, null, 13);
                this.L$0 = coroutineScope2;
                this.label = 1;
                if (FlowKt.first(safeFlowSnapshotFlow2, recomposer$join$3, this) == coroutineSingletons2) {
                    return coroutineSingletons2;
                }
                float fFloatValue3 = ((Number) snapshotStateMap4.get(new Integer(i4))).floatValue();
                float fFloatValue4 = ((Number) snapshotStateMap3.get(new Integer(i4))).floatValue();
                boolean zBooleanValue2 = ((Boolean) mutableState2.getValue()).booleanValue();
                Animatable animatable4 = this.$indicatorOffset;
                if (zBooleanValue2) {
                    Float f6 = new Float(fFloatValue3);
                    this.L$0 = null;
                    this.F$0 = fFloatValue4;
                    this.label = 2;
                    if (animatable4.snapTo(f6, this) == coroutineSingletons2) {
                        return coroutineSingletons2;
                    }
                    f3 = fFloatValue4;
                    f4 = new Float(f3);
                    this.label = 3;
                    if (animatable3.snapTo(f4, this) == coroutineSingletons2) {
                        return coroutineSingletons2;
                    }
                    mutableState2.setValue(Boolean.FALSE);
                } else {
                    SpringSpec springSpec2 = this.$indicatorSpring;
                    JobKt.launch$default(coroutineScope2, null, new AnonymousClass3(animatable4, fFloatValue3, springSpec2, continuation2, 2), 3);
                    JobKt.launch$default(coroutineScope2, null, new AnonymousClass3(animatable3, fFloatValue4, springSpec2, continuation2, 3), 3);
                }
                return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TvGlassTabRowKt$TvGlassTabRow$4$1(SnapshotStateMap snapshotStateMap, int i, SnapshotStateMap snapshotStateMap2, Animatable animatable, Animatable animatable2, MutableState mutableState, SpringSpec springSpec, Continuation continuation) {
        super(2, continuation);
        this.$tabOffsets = snapshotStateMap;
        this.$selectedTabIndex = i;
        this.$tabWidths = snapshotStateMap2;
        this.$indicatorOffset = animatable;
        this.$indicatorWidth = animatable2;
        this.$isFirstLayout$delegate = mutableState;
        this.$indicatorSpring = springSpec;
    }
}
