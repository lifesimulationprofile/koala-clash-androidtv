package androidx.compose.ui.window;

import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.DynamicProvidableCompositionLocal;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.navigation.NavController$executeRestoreState$3;
import androidx.navigation.NavController$handleDeepLink$2;
import coil.RealImageLoader$execute$3;
import java.util.List;
import java.util.UUID;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AndroidPopup_androidKt {
    public static final DynamicProvidableCompositionLocal LocalPopupTestTag = new DynamicProvidableCompositionLocal(AndroidPopup_androidKt$Popup$popupId$1$1.INSTANCE$3);
    public static final DynamicProvidableCompositionLocal LocalIsInPopupLayout = new DynamicProvidableCompositionLocal(AndroidPopup_androidKt$Popup$popupId$1$1.INSTANCE$2);

    /* JADX WARN: Code duplicated, block: B:102:0x022c  */
    /* JADX WARN: Code duplicated, block: B:103:0x0230  */
    /* JADX WARN: Code duplicated, block: B:105:0x0257  */
    /* JADX WARN: Code duplicated, block: B:108:0x0261  */
    /* JADX WARN: Code duplicated, block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x003b  */
    /* JADX WARN: Code duplicated, block: B:25:0x0043  */
    /* JADX WARN: Code duplicated, block: B:26:0x0046  */
    /* JADX WARN: Code duplicated, block: B:28:0x004a  */
    /* JADX WARN: Code duplicated, block: B:31:0x0052  */
    /* JADX WARN: Code duplicated, block: B:33:0x0058  */
    /* JADX WARN: Code duplicated, block: B:34:0x005b  */
    /* JADX WARN: Code duplicated, block: B:38:0x0066  */
    /* JADX WARN: Code duplicated, block: B:39:0x0068  */
    /* JADX WARN: Code duplicated, block: B:42:0x0071 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:43:0x0073  */
    /* JADX WARN: Code duplicated, block: B:44:0x0076  */
    /* JADX WARN: Code duplicated, block: B:47:0x00af  */
    /* JADX WARN: Code duplicated, block: B:50:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:51:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:54:0x010c  */
    /* JADX WARN: Code duplicated, block: B:55:0x010e  */
    /* JADX WARN: Code duplicated, block: B:58:0x0117  */
    /* JADX WARN: Code duplicated, block: B:59:0x0119  */
    /* JADX WARN: Code duplicated, block: B:65:0x0136  */
    /* JADX WARN: Code duplicated, block: B:68:0x0154  */
    /* JADX WARN: Code duplicated, block: B:69:0x0156  */
    /* JADX WARN: Code duplicated, block: B:72:0x015e  */
    /* JADX WARN: Code duplicated, block: B:73:0x0160  */
    /* JADX WARN: Code duplicated, block: B:79:0x017d  */
    /* JADX WARN: Code duplicated, block: B:82:0x019a  */
    /* JADX WARN: Code duplicated, block: B:83:0x019c  */
    /* JADX WARN: Code duplicated, block: B:87:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:91:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:95:0x01de  */
    /* JADX WARN: Code duplicated, block: B:99:0x0204  */
    public static final void Popup(PopupPositionProvider popupPositionProvider, Function0 function0, final PopupProperties popupProperties, final ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, final int i, final int i2) {
        int i3;
        Function0 function1;
        PopupProperties popupProperties2;
        int i4;
        boolean z;
        final Function0 function2;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        final Function0 function3;
        View view;
        Density density;
        String str;
        final LayoutDirection layoutDirection;
        GapComposer.CompositionContextImpl compositionContextImplRememberCompositionContext;
        MutableState mutableStateRememberUpdatedState;
        Object objRememberedValue;
        Object obj;
        UUID uuid;
        boolean zBooleanValue;
        Object objRememberedValue2;
        String str2;
        Continuation continuation;
        boolean z2;
        PopupLayout popupLayout;
        int i5;
        boolean z3;
        int i6;
        boolean z4;
        boolean zChanged;
        Object objRememberedValue3;
        final PopupLayout popupLayout2;
        boolean z5;
        boolean z6;
        boolean zChanged2;
        Object objRememberedValue4;
        boolean z7;
        boolean z8;
        Object objRememberedValue5;
        boolean zChangedInstance;
        Object objRememberedValue6;
        boolean zChangedInstance2;
        Object objRememberedValue7;
        boolean zChangedInstance3;
        Object objRememberedValue8;
        Function0 function4;
        int i7;
        int i8;
        final PopupPositionProvider popupPositionProvider2 = popupPositionProvider;
        gapComposer.startRestartGroup(-1772091631);
        if ((i & 6) == 0) {
            i3 = (gapComposer.changed(popupPositionProvider2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 == 0) {
            if ((i & 48) == 0) {
                function1 = function0;
                i3 |= gapComposer.changedInstance(function1) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                popupProperties2 = popupProperties;
                if (gapComposer.changed(popupProperties2)) {
                    i8 = 256;
                } else {
                    i8 = 128;
                }
                i3 |= i8;
            } else {
                popupProperties2 = popupProperties;
            }
            if ((i & 3072) == 0) {
                if (gapComposer.changedInstance(composableLambdaImpl)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            i4 = i3;
            if ((i4 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (gapComposer.shouldExecute(i4 & 1, z)) {
                if (i9 != 0) {
                    function3 = null;
                } else {
                    function3 = function1;
                }
                view = (View) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalView);
                density = (Density) gapComposer.consume(CompositionLocalsKt.LocalDensity);
                str = (String) gapComposer.consume(LocalPopupTestTag);
                layoutDirection = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
                compositionContextImplRememberCompositionContext = Stack.rememberCompositionContext(gapComposer);
                mutableStateRememberUpdatedState = Stack.rememberUpdatedState(composableLambdaImpl, gapComposer);
                Object[] objArr = new Object[0];
                objRememberedValue = gapComposer.rememberedValue();
                obj = Composer$Companion.Empty;
                if (objRememberedValue == obj) {
                    objRememberedValue = AndroidPopup_androidKt$Popup$popupId$1$1.INSTANCE;
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                uuid = (UUID) SaverKt.rememberSaveable(objArr, (Function0) objRememberedValue, gapComposer);
                zBooleanValue = ((Boolean) gapComposer.consume(LocalIsInPopupLayout)).booleanValue();
                objRememberedValue2 = gapComposer.rememberedValue();
                if (objRememberedValue2 == obj) {
                    str2 = str;
                    continuation = null;
                    z2 = false;
                    PopupLayout popupLayout3 = new PopupLayout(function3, popupProperties2, str2, view, density, popupPositionProvider2, uuid, zBooleanValue);
                    popupPositionProvider2 = popupPositionProvider2;
                    popupLayout3.setContent(compositionContextImplRememberCompositionContext, new ComposableLambdaImpl(-297523940, new AndroidPopup_androidKt$Popup$popupLayout$1$1$1(popupLayout3, mutableStateRememberUpdatedState, 0), true));
                    gapComposer.updateRememberedValue(popupLayout3);
                    objRememberedValue2 = popupLayout3;
                } else {
                    str2 = str;
                    continuation = null;
                    z2 = false;
                }
                popupLayout = (PopupLayout) objRememberedValue2;
                boolean zChangedInstance4 = gapComposer.changedInstance(popupLayout);
                i5 = i4 & 112;
                if (i5 == 32) {
                    z3 = true;
                } else {
                    z3 = z2;
                }
                boolean z9 = zChangedInstance4 | z3;
                i6 = i4 & 896;
                if (i6 == 256) {
                    z4 = true;
                } else {
                    z4 = z2;
                }
                zChanged = z9 | z4 | gapComposer.changed(str2) | gapComposer.changed(layoutDirection.ordinal());
                objRememberedValue3 = gapComposer.rememberedValue();
                if (!zChanged || objRememberedValue3 == obj) {
                    popupLayout2 = popupLayout;
                    Object navController$executeRestoreState$3 = new NavController$executeRestoreState$3(popupLayout2, function3, popupProperties, str2, layoutDirection, 1);
                    gapComposer.updateRememberedValue(navController$executeRestoreState$3);
                    objRememberedValue3 = navController$executeRestoreState$3;
                } else {
                    popupLayout2 = popupLayout;
                }
                Stack.DisposableEffect(popupLayout2, (Function1) objRememberedValue3, gapComposer);
                boolean zChangedInstance5 = gapComposer.changedInstance(popupLayout2);
                if (i5 == 32) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                boolean z10 = zChangedInstance5 | z5;
                if (i6 == 256) {
                    z6 = true;
                } else {
                    z6 = z2;
                }
                zChanged2 = z10 | z6 | gapComposer.changed(str2) | gapComposer.changed(layoutDirection.ordinal());
                objRememberedValue4 = gapComposer.rememberedValue();
                if (zChanged2 || objRememberedValue4 == obj) {
                    final String str3 = str2;
                    Object obj2 = new Function0() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            popupLayout2.updateParameters(function3, popupProperties, str3, layoutDirection);
                            return Unit.INSTANCE;
                        }
                    };
                    gapComposer.updateRememberedValue(obj2);
                    objRememberedValue4 = obj2;
                }
                Stack.SideEffect((Function0) objRememberedValue4, gapComposer);
                boolean zChangedInstance6 = gapComposer.changedInstance(popupLayout2);
                if ((i4 & 14) == 4) {
                    z7 = true;
                } else {
                    z7 = z2;
                }
                z8 = zChangedInstance6 | z7;
                objRememberedValue5 = gapComposer.rememberedValue();
                if (z8 || objRememberedValue5 == obj) {
                    objRememberedValue5 = new NavController$handleDeepLink$2(10, popupLayout2, popupPositionProvider2);
                    gapComposer.updateRememberedValue(objRememberedValue5);
                }
                Stack.DisposableEffect(popupPositionProvider2, (Function1) objRememberedValue5, gapComposer);
                zChangedInstance = gapComposer.changedInstance(popupLayout2);
                objRememberedValue6 = gapComposer.rememberedValue();
                if (zChangedInstance || objRememberedValue6 == obj) {
                    objRememberedValue6 = new RealImageLoader$execute$3(popupLayout2, continuation, 26);
                    gapComposer.updateRememberedValue(objRememberedValue6);
                }
                Stack.LaunchedEffect(gapComposer, popupLayout2, (Function2) objRememberedValue6);
                zChangedInstance2 = gapComposer.changedInstance(popupLayout2);
                objRememberedValue7 = gapComposer.rememberedValue();
                if (zChangedInstance2 || objRememberedValue7 == obj) {
                    objRememberedValue7 = new AndroidPopup_androidKt$Popup$7$1(popupLayout2, 0);
                    gapComposer.updateRememberedValue(objRememberedValue7);
                }
                Modifier modifierOnGloballyPositioned = RulerKt.onGloballyPositioned(Modifier.Companion.$$INSTANCE, (Function1) objRememberedValue7);
                zChangedInstance3 = gapComposer.changedInstance(popupLayout2) | gapComposer.changed(layoutDirection.ordinal());
                objRememberedValue8 = gapComposer.rememberedValue();
                if (zChangedInstance3 || objRememberedValue8 == obj) {
                    objRememberedValue8 = new MeasurePolicy() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8$1
                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        public final /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i10) {
                            return Modifier.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, list, i10);
                        }

                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        public final /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i10) {
                            return Modifier.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, list, i10);
                        }

                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        /* JADX INFO: renamed from: measure-3p2s80s */
                        public final MeasureResult mo24measure3p2s80s(MeasureScope measureScope, List list, long j) {
                            popupLayout2.setParentLayoutDirection(layoutDirection);
                            return measureScope.layout(0, 0, EmptyMap.INSTANCE, AndroidPopup_androidKt$Popup$5$1$1.INSTANCE$2);
                        }

                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        public final /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i10) {
                            return Modifier.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, list, i10);
                        }

                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        public final /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i10) {
                            return Modifier.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, list, i10);
                        }
                    };
                    gapComposer.updateRememberedValue(objRememberedValue8);
                }
                MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue8;
                long j = gapComposer.compositeKeyHashCode;
                int i10 = (int) (j ^ (j >>> 32));
                PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifierOnGloballyPositioned);
                ComposeUiNode.Companion.getClass();
                function4 = ComposeUiNode.Companion.Constructor;
                gapComposer.startReusableNode();
                if (gapComposer.inserting) {
                    gapComposer.createNode(function4);
                } else {
                    gapComposer.useNode();
                }
                Stack.m295setimpl(gapComposer, measurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                Stack.m295setimpl(gapComposer, Integer.valueOf(i10), ComposeUiNode.Companion.SetCompositeKeyHash);
                Stack.m294reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                Stack.m295setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                gapComposer.end(true);
                function2 = function3;
            } else {
                gapComposer.skipToGroupEnd();
                function2 = function1;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt.Popup.9
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj3, Object obj4) {
                        ((Number) obj4).intValue();
                        AndroidPopup_androidKt.Popup(popupPositionProvider2, function2, popupProperties, composableLambdaImpl, (GapComposer) obj3, Stack.updateChangedFlags(i | 1), i2);
                        return Unit.INSTANCE;
                    }
                };
            }
        }
        i3 |= 48;
        function1 = function0;
        if ((i & 384) == 0) {
            popupProperties2 = popupProperties;
            if (gapComposer.changed(popupProperties2)) {
                i8 = 256;
            } else {
                i8 = 128;
            }
            i3 |= i8;
        } else {
            popupProperties2 = popupProperties;
        }
        if ((i & 3072) == 0) {
            if (gapComposer.changedInstance(composableLambdaImpl)) {
                i7 = 2048;
            } else {
                i7 = 1024;
            }
            i3 |= i7;
        }
        i4 = i3;
        if ((i4 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (gapComposer.shouldExecute(i4 & 1, z)) {
            if (i9 != 0) {
                function3 = null;
            } else {
                function3 = function1;
            }
            view = (View) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalView);
            density = (Density) gapComposer.consume(CompositionLocalsKt.LocalDensity);
            str = (String) gapComposer.consume(LocalPopupTestTag);
            layoutDirection = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
            compositionContextImplRememberCompositionContext = Stack.rememberCompositionContext(gapComposer);
            mutableStateRememberUpdatedState = Stack.rememberUpdatedState(composableLambdaImpl, gapComposer);
            Object[] objArr2 = new Object[0];
            objRememberedValue = gapComposer.rememberedValue();
            obj = Composer$Companion.Empty;
            if (objRememberedValue == obj) {
                objRememberedValue = AndroidPopup_androidKt$Popup$popupId$1$1.INSTANCE;
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            uuid = (UUID) SaverKt.rememberSaveable(objArr2, (Function0) objRememberedValue, gapComposer);
            zBooleanValue = ((Boolean) gapComposer.consume(LocalIsInPopupLayout)).booleanValue();
            objRememberedValue2 = gapComposer.rememberedValue();
            if (objRememberedValue2 == obj) {
                str2 = str;
                continuation = null;
                z2 = false;
                PopupLayout popupLayout4 = new PopupLayout(function3, popupProperties2, str2, view, density, popupPositionProvider2, uuid, zBooleanValue);
                popupPositionProvider2 = popupPositionProvider2;
                popupLayout4.setContent(compositionContextImplRememberCompositionContext, new ComposableLambdaImpl(-297523940, new AndroidPopup_androidKt$Popup$popupLayout$1$1$1(popupLayout4, mutableStateRememberUpdatedState, 0), true));
                gapComposer.updateRememberedValue(popupLayout4);
                objRememberedValue2 = popupLayout4;
            } else {
                str2 = str;
                continuation = null;
                z2 = false;
            }
            popupLayout = (PopupLayout) objRememberedValue2;
            boolean zChangedInstance7 = gapComposer.changedInstance(popupLayout);
            i5 = i4 & 112;
            if (i5 == 32) {
                z3 = true;
            } else {
                z3 = z2;
            }
            boolean z11 = zChangedInstance7 | z3;
            i6 = i4 & 896;
            if (i6 == 256) {
                z4 = true;
            } else {
                z4 = z2;
            }
            zChanged = z11 | z4 | gapComposer.changed(str2) | gapComposer.changed(layoutDirection.ordinal());
            objRememberedValue3 = gapComposer.rememberedValue();
            if (zChanged) {
                popupLayout2 = popupLayout;
                Object navController$executeRestoreState$4 = new NavController$executeRestoreState$3(popupLayout2, function3, popupProperties, str2, layoutDirection, 1);
                gapComposer.updateRememberedValue(navController$executeRestoreState$4);
                objRememberedValue3 = navController$executeRestoreState$4;
            } else {
                popupLayout2 = popupLayout;
                Object navController$executeRestoreState$5 = new NavController$executeRestoreState$3(popupLayout2, function3, popupProperties, str2, layoutDirection, 1);
                gapComposer.updateRememberedValue(navController$executeRestoreState$5);
                objRememberedValue3 = navController$executeRestoreState$5;
            }
            Stack.DisposableEffect(popupLayout2, (Function1) objRememberedValue3, gapComposer);
            boolean zChangedInstance8 = gapComposer.changedInstance(popupLayout2);
            if (i5 == 32) {
                z5 = true;
            } else {
                z5 = z2;
            }
            boolean z12 = zChangedInstance8 | z5;
            if (i6 == 256) {
                z6 = true;
            } else {
                z6 = z2;
            }
            zChanged2 = z12 | z6 | gapComposer.changed(str2) | gapComposer.changed(layoutDirection.ordinal());
            objRememberedValue4 = gapComposer.rememberedValue();
            if (zChanged2) {
                final String str4 = str2;
                Object obj3 = new Function0() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        popupLayout2.updateParameters(function3, popupProperties, str4, layoutDirection);
                        return Unit.INSTANCE;
                    }
                };
                gapComposer.updateRememberedValue(obj3);
                objRememberedValue4 = obj3;
            } else {
                final String str5 = str2;
                Object obj4 = new Function0() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        popupLayout2.updateParameters(function3, popupProperties, str5, layoutDirection);
                        return Unit.INSTANCE;
                    }
                };
                gapComposer.updateRememberedValue(obj4);
                objRememberedValue4 = obj4;
            }
            Stack.SideEffect((Function0) objRememberedValue4, gapComposer);
            boolean zChangedInstance9 = gapComposer.changedInstance(popupLayout2);
            if ((i4 & 14) == 4) {
                z7 = true;
            } else {
                z7 = z2;
            }
            z8 = zChangedInstance9 | z7;
            objRememberedValue5 = gapComposer.rememberedValue();
            if (z8) {
                objRememberedValue5 = new NavController$handleDeepLink$2(10, popupLayout2, popupPositionProvider2);
                gapComposer.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = new NavController$handleDeepLink$2(10, popupLayout2, popupPositionProvider2);
                gapComposer.updateRememberedValue(objRememberedValue5);
            }
            Stack.DisposableEffect(popupPositionProvider2, (Function1) objRememberedValue5, gapComposer);
            zChangedInstance = gapComposer.changedInstance(popupLayout2);
            objRememberedValue6 = gapComposer.rememberedValue();
            if (zChangedInstance) {
                objRememberedValue6 = new RealImageLoader$execute$3(popupLayout2, continuation, 26);
                gapComposer.updateRememberedValue(objRememberedValue6);
            } else {
                objRememberedValue6 = new RealImageLoader$execute$3(popupLayout2, continuation, 26);
                gapComposer.updateRememberedValue(objRememberedValue6);
            }
            Stack.LaunchedEffect(gapComposer, popupLayout2, (Function2) objRememberedValue6);
            zChangedInstance2 = gapComposer.changedInstance(popupLayout2);
            objRememberedValue7 = gapComposer.rememberedValue();
            if (zChangedInstance2) {
                objRememberedValue7 = new AndroidPopup_androidKt$Popup$7$1(popupLayout2, 0);
                gapComposer.updateRememberedValue(objRememberedValue7);
            } else {
                objRememberedValue7 = new AndroidPopup_androidKt$Popup$7$1(popupLayout2, 0);
                gapComposer.updateRememberedValue(objRememberedValue7);
            }
            Modifier modifierOnGloballyPositioned2 = RulerKt.onGloballyPositioned(Modifier.Companion.$$INSTANCE, (Function1) objRememberedValue7);
            zChangedInstance3 = gapComposer.changedInstance(popupLayout2) | gapComposer.changed(layoutDirection.ordinal());
            objRememberedValue8 = gapComposer.rememberedValue();
            if (zChangedInstance3) {
                objRememberedValue8 = new MeasurePolicy() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public final /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
                        return Modifier.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, list, i11);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public final /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
                        return Modifier.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, list, i11);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo24measure3p2s80s(MeasureScope measureScope, List list, long j2) {
                        popupLayout2.setParentLayoutDirection(layoutDirection);
                        return measureScope.layout(0, 0, EmptyMap.INSTANCE, AndroidPopup_androidKt$Popup$5$1$1.INSTANCE$2);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public final /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
                        return Modifier.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, list, i11);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public final /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
                        return Modifier.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, list, i11);
                    }
                };
                gapComposer.updateRememberedValue(objRememberedValue8);
            } else {
                objRememberedValue8 = new MeasurePolicy() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$Popup$8$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public final /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
                        return Modifier.CC.$default$maxIntrinsicHeight(this, intrinsicMeasureScope, list, i11);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public final /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
                        return Modifier.CC.$default$maxIntrinsicWidth(this, intrinsicMeasureScope, list, i11);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo24measure3p2s80s(MeasureScope measureScope, List list, long j2) {
                        popupLayout2.setParentLayoutDirection(layoutDirection);
                        return measureScope.layout(0, 0, EmptyMap.INSTANCE, AndroidPopup_androidKt$Popup$5$1$1.INSTANCE$2);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public final /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
                        return Modifier.CC.$default$minIntrinsicHeight(this, intrinsicMeasureScope, list, i11);
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    public final /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i11) {
                        return Modifier.CC.$default$minIntrinsicWidth(this, intrinsicMeasureScope, list, i11);
                    }
                };
                gapComposer.updateRememberedValue(objRememberedValue8);
            }
            MeasurePolicy measurePolicy2 = (MeasurePolicy) objRememberedValue8;
            long j2 = gapComposer.compositeKeyHashCode;
            int i11 = (int) (j2 ^ (j2 >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer, modifierOnGloballyPositioned2);
            ComposeUiNode.Companion.getClass();
            function4 = ComposeUiNode.Companion.Constructor;
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(function4);
            } else {
                gapComposer.useNode();
            }
            Stack.m295setimpl(gapComposer, measurePolicy2, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope2, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m295setimpl(gapComposer, Integer.valueOf(i11), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m294reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m295setimpl(gapComposer, modifierMaterializeModifier2, ComposeUiNode.Companion.SetModifier);
            gapComposer.end(true);
            function2 = function3;
        } else {
            gapComposer.skipToGroupEnd();
            function2 = function1;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt.Popup.9
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj5, Object obj6) {
                    ((Number) obj6).intValue();
                    AndroidPopup_androidKt.Popup(popupPositionProvider2, function2, popupProperties, composableLambdaImpl, (GapComposer) obj5, Stack.updateChangedFlags(i | 1), i2);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final boolean isFlagSecureEnabled(View view) {
        ViewGroup.LayoutParams layoutParams = view.getRootView().getLayoutParams();
        WindowManager.LayoutParams layoutParams2 = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
        return (layoutParams2 == null || (layoutParams2.flags & 8192) == 0) ? false : true;
    }
}
