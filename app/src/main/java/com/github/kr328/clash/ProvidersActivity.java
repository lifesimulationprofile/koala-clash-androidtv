package com.github.kr328.clash;

import android.os.Bundle;
import androidx.activity.compose.ComponentActivityKt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.FlowRowOverflow;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.BottomSheetKt$$ExternalSyntheticLambda1;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.ThumbNode;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.PersistentCompositionLocalMap;
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
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import coil.decode.BitmapFactoryDecoder$$ExternalSyntheticLambda2;
import com.github.kr328.clash.compose.ProviderItemState;
import com.github.kr328.clash.compose.ProvidersScreenKt;
import com.github.kr328.clash.core.model.Provider;
import com.github.kr328.clash.design.compose.components.GlassSnackbarKt;
import com.github.kr328.clash.design.compose.theme.AppThemeKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ProvidersActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: com.github.kr328.clash.ProvidersActivity$onCreate$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 implements Function2 {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ ProvidersActivity this$0;

        public /* synthetic */ AnonymousClass1(ProvidersActivity providersActivity, int i) {
            this.$r8$classId = i;
            this.this$0 = providersActivity;
        }

        public static final void invoke$setUpdating(MutableState mutableState, Provider provider, boolean z, boolean z2) {
            List<ProviderItemState> list = (List) mutableState.getValue();
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
            for (ProviderItemState providerItemState : list) {
                Provider provider2 = providerItemState.provider;
                if (Intrinsics.areEqual(provider2.name, provider.name) && provider2.type == provider.type) {
                    providerItemState = new ProviderItemState(provider2, z2 ? System.currentTimeMillis() : providerItemState.updatedAt, z);
                }
                arrayList.add(providerItemState);
            }
            mutableState.setValue(arrayList);
        }

        public static final void invoke$updateOne(CoroutineScope coroutineScope, MutableState mutableState, SnackbarHostState snackbarHostState, ProvidersActivity providersActivity, Provider provider) {
            if (provider.vehicleType == Provider.VehicleType.Inline) {
                return;
            }
            invoke$setUpdating(mutableState, provider, true, false);
            JobKt.launch$default(coroutineScope, null, new NavHostKt$NavHost$29$1(provider, snackbarHostState, providersActivity, mutableState, null, 16), 3);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            switch (this.$r8$classId) {
                case 0:
                    GapComposer gapComposer = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer.getSkipping()) {
                        gapComposer.skipToGroupEnd();
                    } else {
                        AppThemeKt.AppTheme(false, Thread_jvmKt.rememberComposableLambda(-952432947, new AnonymousClass1(this.this$0, 1), gapComposer), gapComposer, 48);
                    }
                    break;
                default:
                    GapComposer gapComposer2 = (GapComposer) obj;
                    if ((((Number) obj2).intValue() & 3) == 2 && gapComposer2.getSkipping()) {
                        gapComposer2.skipToGroupEnd();
                    } else {
                        Object objRememberedValue = gapComposer2.rememberedValue();
                        NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
                        if (objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer2);
                            gapComposer2.updateRememberedValue(objRememberedValue);
                        }
                        CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
                        gapComposer2.startReplaceGroup(140313873);
                        Object objRememberedValue2 = gapComposer2.rememberedValue();
                        if (objRememberedValue2 == neverEqualPolicy) {
                            objRememberedValue2 = new SnackbarHostState();
                            gapComposer2.updateRememberedValue(objRememberedValue2);
                        }
                        SnackbarHostState snackbarHostState = (SnackbarHostState) objRememberedValue2;
                        Object objM = Density.CC.m(140315890, gapComposer2, false);
                        if (objM == neverEqualPolicy) {
                            objM = Stack.mutableStateOf$default(EmptyList.INSTANCE);
                            gapComposer2.updateRememberedValue(objM);
                        }
                        MutableState mutableState = (MutableState) objM;
                        gapComposer2.end(false);
                        Unit unit = Unit.INSTANCE;
                        gapComposer2.startReplaceGroup(140319381);
                        Object objRememberedValue3 = gapComposer2.rememberedValue();
                        if (objRememberedValue3 == neverEqualPolicy) {
                            objRememberedValue3 = new ThumbNode.AnonymousClass1(mutableState, (Continuation) null, 18);
                            gapComposer2.updateRememberedValue(objRememberedValue3);
                        }
                        gapComposer2.end(false);
                        Stack.LaunchedEffect(gapComposer2, unit, (Function2) objRememberedValue3);
                        FillElement fillElement = SizeKt.FillWholeMaxSize;
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                        long j = gapComposer2.compositeKeyHashCode;
                        int i = (int) (j ^ (j >>> 32));
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
                        Stack.m295setimpl(gapComposer2, Integer.valueOf(i), ComposeUiNode.Companion.SetCompositeKeyHash);
                        Stack.m294reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                        Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                        FlowRowOverflow flowRowOverflow = FlowRowOverflow.INSTANCE;
                        List list = (List) mutableState.getValue();
                        gapComposer2.startReplaceGroup(-335667301);
                        boolean zChangedInstance = gapComposer2.changedInstance(coroutineScope);
                        ProvidersActivity providersActivity = this.this$0;
                        boolean zChanged = zChangedInstance | gapComposer2.changed(providersActivity);
                        Object objRememberedValue4 = gapComposer2.rememberedValue();
                        if (zChanged || objRememberedValue4 == neverEqualPolicy) {
                            objRememberedValue4 = new FilesActivity$Content$3$1$1(coroutineScope, mutableState, snackbarHostState, providersActivity);
                            gapComposer2.updateRememberedValue(objRememberedValue4);
                        }
                        gapComposer2.end(false);
                        Function1 function1 = (Function1) ((FunctionReferenceImpl) objRememberedValue4);
                        gapComposer2.startReplaceGroup(-335665358);
                        boolean zChangedInstance2 = gapComposer2.changedInstance(coroutineScope) | gapComposer2.changed(providersActivity);
                        Object objRememberedValue5 = gapComposer2.rememberedValue();
                        if (zChangedInstance2 || objRememberedValue5 == neverEqualPolicy) {
                            BottomSheetKt$$ExternalSyntheticLambda1 bottomSheetKt$$ExternalSyntheticLambda1 = new BottomSheetKt$$ExternalSyntheticLambda1(mutableState, coroutineScope, snackbarHostState, providersActivity, 2);
                            gapComposer2.updateRememberedValue(bottomSheetKt$$ExternalSyntheticLambda1);
                            objRememberedValue5 = bottomSheetKt$$ExternalSyntheticLambda1;
                        }
                        Function0 function0 = (Function0) objRememberedValue5;
                        gapComposer2.end(false);
                        gapComposer2.startReplaceGroup(-335653988);
                        boolean zChanged2 = gapComposer2.changed(providersActivity);
                        Object objRememberedValue6 = gapComposer2.rememberedValue();
                        if (zChanged2 || objRememberedValue6 == neverEqualPolicy) {
                            objRememberedValue6 = new BitmapFactoryDecoder$$ExternalSyntheticLambda2(10, providersActivity);
                            gapComposer2.updateRememberedValue(objRememberedValue6);
                        }
                        gapComposer2.end(false);
                        ProvidersScreenKt.ProvidersScreen(list, function1, function0, (Function0) objRememberedValue6, null, gapComposer2, 0);
                        GlassSnackbarKt.GlassSnackbarHost(snackbarHostState, flowRowOverflow.align(Modifier.Companion.$$INSTANCE, Alignment.Companion.BottomCenter), gapComposer2, 6, 0);
                        gapComposer2.end(true);
                    }
                    break;
            }
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ComponentActivityKt.setContent$default(this, new ComposableLambdaImpl(-416081321, new AnonymousClass1(this, 0), true));
    }
}
