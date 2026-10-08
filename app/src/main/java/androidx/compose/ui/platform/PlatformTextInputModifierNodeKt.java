package androidx.compose.ui.platform;

import androidx.compose.foundation.text.input.internal.LegacyAdaptingPlatformTextInputModifierNode;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.internal.PersistentCompositionLocalHashMap;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.Owner;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import coil.network.HttpException;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class PlatformTextInputModifierNodeKt {
    public static final StaticProvidableCompositionLocal LocalChainedPlatformTextInputInterceptor = new StaticProvidableCompositionLocal(InspectionModeKt$LocalInspectionMode$1.INSTANCE$1);

    /* JADX INFO: renamed from: androidx.compose.ui.platform.PlatformTextInputModifierNodeKt$establishTextInputSession$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            PlatformTextInputModifierNodeKt.establishTextInputSession(null, null, this);
            return CoroutineSingletons.COROUTINE_SUSPENDED;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.platform.PlatformTextInputModifierNodeKt$interceptedTextInputSession$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class C00151 extends ContinuationImpl {
        public int label;
        public /* synthetic */ Object result;

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            PlatformTextInputModifierNodeKt.interceptedTextInputSession(null, null, this);
            return CoroutineSingletons.COROUTINE_SUSPENDED;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final void establishTextInputSession(LegacyAdaptingPlatformTextInputModifierNode legacyAdaptingPlatformTextInputModifierNode, NavHostKt$NavHost$29$1 navHostKt$NavHost$29$1, ContinuationImpl continuationImpl) {
        AnonymousClass1 anonymousClass1;
        if (continuationImpl instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuationImpl;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuationImpl);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuationImpl);
        }
        Object obj = anonymousClass1.result;
        int i2 = anonymousClass1.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            throw new HttpException();
        }
        ResultKt.throwOnFailure(obj);
        if (!legacyAdaptingPlatformTextInputModifierNode.node.isAttached) {
            throw new IllegalArgumentException("establishTextInputSession called from an unattached node");
        }
        Owner ownerRequireOwner = HitTestResultKt.requireOwner(legacyAdaptingPlatformTextInputModifierNode);
        PersistentCompositionLocalHashMap persistentCompositionLocalHashMap = (PersistentCompositionLocalHashMap) HitTestResultKt.requireLayoutNode(legacyAdaptingPlatformTextInputModifierNode).compositionLocalMap;
        persistentCompositionLocalHashMap.getClass();
        if (Stack.read(persistentCompositionLocalHashMap, LocalChainedPlatformTextInputInterceptor) != null) {
            throw new ClassCastException();
        }
        anonymousClass1.label = 1;
        interceptedTextInputSession(ownerRequireOwner, navHostKt$NavHost$29$1, anonymousClass1);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public static final void interceptedTextInputSession(Owner owner, Function2 function2, ContinuationImpl continuationImpl) {
        C00151 c00151;
        if (continuationImpl instanceof C00151) {
            c00151 = (C00151) continuationImpl;
            int i = c00151.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c00151.label = i - Integer.MIN_VALUE;
            } else {
                c00151 = new C00151(continuationImpl);
            }
        } else {
            c00151 = new C00151(continuationImpl);
        }
        Object obj = c00151.result;
        int i2 = c00151.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            c00151.label = 1;
            ((AndroidComposeView) owner).textInputSession(function2, c00151);
        } else {
            if (i2 == 1) {
                ResultKt.throwOnFailure(obj);
                throw new HttpException();
            }
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            throw new HttpException();
        }
    }
}
