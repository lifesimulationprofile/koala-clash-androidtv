package com.github.kr328.clash;

import android.os.Bundle;
import androidx.activity.compose.ComponentActivityKt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.FlowRowOverflow;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda2;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda7;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.unit.Density;
import androidx.fragment.app.FragmentManager$1;
import androidx.lifecycle.ViewModelKt;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import coil.ImageLoader$Builder$$ExternalSyntheticLambda2;
import com.github.kr328.clash.compose.PropertiesScreenKt;
import com.github.kr328.clash.design.compose.components.GlassSnackbarKt;
import com.github.kr328.clash.design.compose.theme.AppThemeKt;
import com.github.kr328.clash.service.model.Profile;
import com.github.kr328.clash.util.RemoteKt;
import java.util.UUID;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class PropertiesActivity extends AppCompatActivity {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final ParcelableSnapshotMutableState pendingExit$delegate = Stack.mutableStateOf$default(Boolean.FALSE);
    public Function0 hasUnsaved = new ImageLoader$Builder$$ExternalSyntheticLambda2(22);
    public final SnackbarHostState snackbarHostState = new SnackbarHostState();

    /* JADX INFO: renamed from: com.github.kr328.clash.PropertiesActivity$onCreate$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass2 implements Function2 {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ PropertiesActivity this$0;

        public /* synthetic */ AnonymousClass2(PropertiesActivity propertiesActivity, int i) {
            this.$r8$classId = i;
            this.this$0 = propertiesActivity;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            int i = this.$r8$classId;
            int i2 = 1;
            PropertiesActivity propertiesActivity = this.this$0;
            int i3 = 2;
            switch (i) {
                case 0:
                    GapComposer gapComposer = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
                        gapComposer.skipToGroupEnd();
                    } else {
                        AppThemeKt.AppTheme(false, Thread_jvmKt.rememberComposableLambda(610063621, new AnonymousClass2(propertiesActivity, i3), gapComposer), gapComposer, 48);
                    }
                    break;
                case 1:
                    GapComposer gapComposer2 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        FillElement fillElement = SizeKt.FillWholeMaxSize;
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                        long j = gapComposer2.compositeKeyHashCode;
                        int i4 = (int) (j ^ (j >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, fillElement);
                        ComposeUiNode.Companion.getClass();
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                        gapComposer2.startReusableNode();
                        if (gapComposer2.inserting) {
                            gapComposer2.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer2.useNode();
                        }
                        Stack.m295setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                        Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                        Stack.m295setimpl(gapComposer2, Integer.valueOf(i4), ComposeUiNode.Companion.SetCompositeKeyHash);
                        Stack.m294reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                        Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                        FlowRowOverflow flowRowOverflow = FlowRowOverflow.INSTANCE;
                        int i5 = PropertiesActivity.$r8$clinit;
                        propertiesActivity.Content(0, gapComposer2);
                        GlassSnackbarKt.GlassSnackbarHost(propertiesActivity.snackbarHostState, flowRowOverflow.align(Modifier.Companion.$$INSTANCE, Alignment.Companion.BottomCenter), gapComposer2, 0, 0);
                        gapComposer2.end(true);
                    }
                    break;
                default:
                    GapComposer gapComposer3 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer3.getSkipping()) {
                        gapComposer3.skipToGroupEnd();
                    } else {
                        Stack.CompositionLocalProvider(GlassSnackbarKt.LocalGlassSnackbarHost.defaultProvidedValue$runtime(propertiesActivity.snackbarHostState), Thread_jvmKt.rememberComposableLambda(1669294533, new AnonymousClass2(propertiesActivity, i2), gapComposer3), gapComposer3, 56);
                    }
                    break;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final Object access$commit(PropertiesActivity propertiesActivity, Profile profile, UUID uuid, TooltipKt$$ExternalSyntheticLambda7 tooltipKt$$ExternalSyntheticLambda7, ContinuationImpl continuationImpl) {
        PropertiesActivity$commit$1 propertiesActivity$commit$1;
        if (continuationImpl instanceof PropertiesActivity$commit$1) {
            propertiesActivity$commit$1 = (PropertiesActivity$commit$1) continuationImpl;
            int i = propertiesActivity$commit$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                propertiesActivity$commit$1.label = i - Integer.MIN_VALUE;
            } else {
                propertiesActivity$commit$1 = new PropertiesActivity$commit$1(propertiesActivity, continuationImpl);
            }
        } else {
            propertiesActivity$commit$1 = new PropertiesActivity$commit$1(propertiesActivity, continuationImpl);
        }
        Object obj = propertiesActivity$commit$1.result;
        int i2 = propertiesActivity$commit$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Continuation continuation = null;
            if (StringsKt.isBlank(profile.name)) {
                JobKt.launch$default(ViewModelKt.getLifecycleScope(propertiesActivity), null, new PropertiesActivity$commit$2(propertiesActivity, continuation, 0), 3);
                return Unit.INSTANCE;
            }
            if (profile.type != Profile.Type.File && StringsKt.isBlank(profile.source)) {
                JobKt.launch$default(ViewModelKt.getLifecycleScope(propertiesActivity), null, new PropertiesActivity$commit$2(propertiesActivity, continuation, 1), 3);
                return Unit.INSTANCE;
            }
            NavHostKt$NavHost$29$1 navHostKt$NavHost$29$1 = new NavHostKt$NavHost$29$1(uuid, profile, tooltipKt$$ExternalSyntheticLambda7, continuation, 15);
            propertiesActivity$commit$1.L$0 = propertiesActivity;
            propertiesActivity$commit$1.label = 1;
            Object objWithProfile$default = RemoteKt.withProfile$default(navHostKt$NavHost$29$1, propertiesActivity$commit$1);
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (objWithProfile$default == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            propertiesActivity = propertiesActivity$commit$1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        propertiesActivity.setResult(-1);
        propertiesActivity.finish();
        return Unit.INSTANCE;
    }

    public final void Content(final int i, GapComposer gapComposer) {
        MutableState mutableState;
        Profile profile;
        Object propertiesActivity$$ExternalSyntheticLambda4;
        MutableState mutableState2;
        final PropertiesActivity propertiesActivity = this;
        GapComposer gapComposer2 = gapComposer;
        gapComposer2.startRestartGroup(-22394362);
        if ((((gapComposer2.changedInstance(propertiesActivity) ? 4 : 2) | i) & 3) == 2 && gapComposer2.getSkipping()) {
            gapComposer2.skipToGroupEnd();
        } else {
            Object objRememberedValue = gapComposer2.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer2);
                gapComposer2.updateRememberedValue(objRememberedValue);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            gapComposer2.startReplaceGroup(208643123);
            Object objRememberedValue2 = gapComposer2.rememberedValue();
            if (objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = Stack.mutableStateOf$default(null);
                gapComposer2.updateRememberedValue(objRememberedValue2);
            }
            MutableState mutableState3 = (MutableState) objRememberedValue2;
            Object objM = Density.CC.m(208645299, gapComposer2, false);
            if (objM == neverEqualPolicy) {
                objM = Stack.mutableStateOf$default(null);
                gapComposer2.updateRememberedValue(objM);
            }
            MutableState mutableState4 = (MutableState) objM;
            Object objM2 = Density.CC.m(208647568, gapComposer2, false);
            if (objM2 == neverEqualPolicy) {
                objM2 = Stack.mutableStateOf$default(null);
                gapComposer2.updateRememberedValue(objM2);
            }
            MutableState mutableState5 = (MutableState) objM2;
            Object objM3 = Density.CC.m(208649706, gapComposer2, false);
            if (objM3 == neverEqualPolicy) {
                objM3 = Stack.mutableStateOf$default(Boolean.FALSE);
                gapComposer2.updateRememberedValue(objM3);
            }
            MutableState mutableState6 = (MutableState) objM3;
            gapComposer2.end(false);
            Unit unit = Unit.INSTANCE;
            gapComposer2.startReplaceGroup(208652237);
            boolean zChangedInstance = gapComposer2.changedInstance(propertiesActivity);
            Object objRememberedValue3 = gapComposer2.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == neverEqualPolicy) {
                mutableState = mutableState4;
                NavHostKt$NavHost$29$1 navHostKt$NavHost$29$1 = new NavHostKt$NavHost$29$1(propertiesActivity, mutableState, mutableState5, mutableState3, null, 12);
                gapComposer2.updateRememberedValue(navHostKt$NavHost$29$1);
                objRememberedValue3 = navHostKt$NavHost$29$1;
            } else {
                mutableState = mutableState4;
            }
            gapComposer2.end(false);
            Stack.LaunchedEffect(gapComposer2, unit, (Function2) objRememberedValue3);
            gapComposer2.startReplaceGroup(208668575);
            Object objRememberedValue4 = gapComposer2.rememberedValue();
            if (objRememberedValue4 == neverEqualPolicy) {
                objRememberedValue4 = new TooltipKt$$ExternalSyntheticLambda2(mutableState3, mutableState, 1);
                gapComposer2.updateRememberedValue(objRememberedValue4);
            }
            gapComposer2.end(false);
            propertiesActivity.hasUnsaved = (Function0) objRememberedValue4;
            Profile profile2 = (Profile) mutableState3.getValue();
            if (profile2 == null) {
                RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    final int i2 = 0;
                    recomposeScopeImplEndRestartGroup.block = new Function2(propertiesActivity, i, i2) { // from class: com.github.kr328.clash.PropertiesActivity$$ExternalSyntheticLambda2
                        public final /* synthetic */ int $r8$classId;
                        public final /* synthetic */ PropertiesActivity f$0;

                        {
                            this.$r8$classId = i2;
                            this.f$0 = propertiesActivity;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            int i3 = this.$r8$classId;
                            PropertiesActivity propertiesActivity2 = this.f$0;
                            GapComposer gapComposer3 = (GapComposer) obj;
                            ((Integer) obj2).getClass();
                            int i4 = PropertiesActivity.$r8$clinit;
                            switch (i3) {
                                case 0:
                                    propertiesActivity2.Content(Stack.updateChangedFlags(1), gapComposer3);
                                    break;
                                default:
                                    propertiesActivity2.Content(Stack.updateChangedFlags(1), gapComposer3);
                                    break;
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    return;
                }
                return;
            }
            boolean zBooleanValue = ((Boolean) mutableState6.getValue()).booleanValue();
            boolean z = ((UUID) mutableState5.getValue()) != null;
            gapComposer2.startReplaceGroup(208693112);
            Object objRememberedValue5 = gapComposer2.rememberedValue();
            if (objRememberedValue5 == neverEqualPolicy) {
                objRememberedValue5 = new TooltipKt$$ExternalSyntheticLambda7(mutableState3, 9);
                gapComposer2.updateRememberedValue(objRememberedValue5);
            }
            Function1 function1 = (Function1) objRememberedValue5;
            gapComposer2.end(false);
            gapComposer2.startReplaceGroup(208695046);
            boolean zChangedInstance2 = gapComposer2.changedInstance(coroutineScope) | gapComposer2.changedInstance(propertiesActivity) | gapComposer2.changedInstance(profile2);
            Object objRememberedValue6 = gapComposer2.rememberedValue();
            if (zChangedInstance2 || objRememberedValue6 == neverEqualPolicy) {
                profile = profile2;
                mutableState2 = mutableState6;
                propertiesActivity$$ExternalSyntheticLambda4 = new PropertiesActivity$$ExternalSyntheticLambda4(coroutineScope, mutableState2, propertiesActivity, profile, mutableState5, 0);
                propertiesActivity = propertiesActivity;
                mutableState5 = mutableState5;
                gapComposer2.updateRememberedValue(propertiesActivity$$ExternalSyntheticLambda4);
            } else {
                profile = profile2;
                propertiesActivity$$ExternalSyntheticLambda4 = objRememberedValue6;
                mutableState2 = mutableState6;
            }
            Function0 function0 = (Function0) propertiesActivity$$ExternalSyntheticLambda4;
            gapComposer2.end(false);
            gapComposer2.startReplaceGroup(208715927);
            boolean zChangedInstance3 = gapComposer2.changedInstance(propertiesActivity);
            Object objRememberedValue7 = gapComposer2.rememberedValue();
            if (zChangedInstance3 || objRememberedValue7 == neverEqualPolicy) {
                objRememberedValue7 = new PropertiesActivity$$ExternalSyntheticLambda5(mutableState5, propertiesActivity);
                gapComposer2.updateRememberedValue(objRememberedValue7);
            }
            Function0 function2 = (Function0) objRememberedValue7;
            gapComposer2.end(false);
            gapComposer2.startReplaceGroup(208721490);
            boolean zChangedInstance4 = gapComposer2.changedInstance(propertiesActivity);
            Object objRememberedValue8 = gapComposer2.rememberedValue();
            if (zChangedInstance4 || objRememberedValue8 == neverEqualPolicy) {
                objRememberedValue8 = new PropertiesActivity$$ExternalSyntheticLambda5(propertiesActivity, mutableState2);
                gapComposer2.updateRememberedValue(objRememberedValue8);
            }
            gapComposer2.end(false);
            PropertiesScreenKt.PropertiesScreen(profile, zBooleanValue, z, function1, function0, function2, (Function0) objRememberedValue8, null, gapComposer2, 3072);
            gapComposer2 = gapComposer2;
            if (((Boolean) propertiesActivity.pendingExit$delegate.getValue()).booleanValue()) {
                gapComposer2.startReplaceGroup(208729152);
                boolean zChangedInstance5 = gapComposer2.changedInstance(propertiesActivity);
                Object objRememberedValue9 = gapComposer2.rememberedValue();
                if (zChangedInstance5 || objRememberedValue9 == neverEqualPolicy) {
                    final int i3 = 0;
                    objRememberedValue9 = new Function0(propertiesActivity) { // from class: com.github.kr328.clash.PropertiesActivity$$ExternalSyntheticLambda7
                        public final /* synthetic */ PropertiesActivity f$0;

                        {
                            this.f$0 = propertiesActivity;
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            int i4 = i3;
                            PropertiesActivity propertiesActivity2 = this.f$0;
                            switch (i4) {
                                case 0:
                                    int i5 = PropertiesActivity.$r8$clinit;
                                    propertiesActivity2.pendingExit$delegate.setValue(Boolean.FALSE);
                                    propertiesActivity2.finish();
                                    break;
                                default:
                                    int i6 = PropertiesActivity.$r8$clinit;
                                    propertiesActivity2.pendingExit$delegate.setValue(Boolean.FALSE);
                                    break;
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    gapComposer2.updateRememberedValue(objRememberedValue9);
                }
                Function0 function3 = (Function0) objRememberedValue9;
                gapComposer2.end(false);
                gapComposer2.startReplaceGroup(208732863);
                boolean zChangedInstance6 = gapComposer2.changedInstance(propertiesActivity);
                Object objRememberedValue10 = gapComposer2.rememberedValue();
                if (zChangedInstance6 || objRememberedValue10 == neverEqualPolicy) {
                    final int i4 = 1;
                    objRememberedValue10 = new Function0(propertiesActivity) { // from class: com.github.kr328.clash.PropertiesActivity$$ExternalSyntheticLambda7
                        public final /* synthetic */ PropertiesActivity f$0;

                        {
                            this.f$0 = propertiesActivity;
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            int i5 = i4;
                            PropertiesActivity propertiesActivity2 = this.f$0;
                            switch (i5) {
                                case 0:
                                    int i6 = PropertiesActivity.$r8$clinit;
                                    propertiesActivity2.pendingExit$delegate.setValue(Boolean.FALSE);
                                    propertiesActivity2.finish();
                                    break;
                                default:
                                    int i7 = PropertiesActivity.$r8$clinit;
                                    propertiesActivity2.pendingExit$delegate.setValue(Boolean.FALSE);
                                    break;
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    gapComposer2.updateRememberedValue(objRememberedValue10);
                }
                gapComposer2.end(false);
                PropertiesScreenKt.ExitWithoutSaveDialog(function3, (Function0) objRememberedValue10, gapComposer2, 0);
            }
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup2 = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup2 != null) {
            final int i5 = 1;
            recomposeScopeImplEndRestartGroup2.block = new Function2(propertiesActivity, i, i5) { // from class: com.github.kr328.clash.PropertiesActivity$$ExternalSyntheticLambda2
                public final /* synthetic */ int $r8$classId;
                public final /* synthetic */ PropertiesActivity f$0;

                {
                    this.$r8$classId = i5;
                    this.f$0 = propertiesActivity;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    int i6 = this.$r8$classId;
                    PropertiesActivity propertiesActivity2 = this.f$0;
                    GapComposer gapComposer3 = (GapComposer) obj;
                    ((Integer) obj2).getClass();
                    int i7 = PropertiesActivity.$r8$clinit;
                    switch (i6) {
                        case 0:
                            propertiesActivity2.Content(Stack.updateChangedFlags(1), gapComposer3);
                            break;
                        default:
                            propertiesActivity2.Content(Stack.updateChangedFlags(1), gapComposer3);
                            break;
                    }
                    return Unit.INSTANCE;
                }
            };
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setResult(0);
        getOnBackPressedDispatcher().addCallback(new FragmentManager$1(4, this), this);
        ComponentActivityKt.setContent$default(this, new ComposableLambdaImpl(647900687, new AnonymousClass2(this, 0), true));
    }
}
