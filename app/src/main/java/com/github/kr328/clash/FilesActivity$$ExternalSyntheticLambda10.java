package com.github.kr328.clash;

import android.net.Uri;
import androidx.activity.compose.ActivityResultRegistryKt$$ExternalSyntheticLambda1;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.TargetBasedAnimation;
import androidx.compose.foundation.gestures.MouseWheelScrollingLogic;
import androidx.compose.foundation.gestures.MouseWheelScrollingLogicKt;
import androidx.compose.foundation.gestures.ScrollingLogic$nestedScrollScope$1;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda4;
import androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$lambda$18$0$$inlined$onDispose$1;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.PlatformTextInputService;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda1;
import coil.RealImageLoader$executeMain$result$1;
import coil.compose.AsyncImagePainter$$ExternalSyntheticLambda0;
import coil.request.RequestService;
import com.github.kr328.clash.compose.FileAction;
import com.github.kr328.clash.compose.FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2;
import com.github.kr328.clash.core.model.ProxyGroup;
import com.github.kr328.clash.design.model.File;
import com.github.kr328.clash.design.model.LogFile;
import com.github.kr328.clash.remote.FilesClient;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FilesActivity$$ExternalSyntheticLambda10 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;

    public /* synthetic */ FilesActivity$$ExternalSyntheticLambda10(MutableState mutableState, InfiniteTransition infiniteTransition, Ref$FloatRef ref$FloatRef, CoroutineScope coroutineScope) {
        this.$r8$classId = 2;
        this.f$1 = mutableState;
        this.f$2 = infiniteTransition;
        this.f$3 = ref$FloatRef;
        this.f$0 = coroutineScope;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i = this.$r8$classId;
        Object obj2 = this.f$3;
        Object obj3 = this.f$2;
        Object obj4 = this.f$1;
        Object obj5 = this.f$0;
        switch (i) {
            case 0:
                CoroutineScope coroutineScope = (CoroutineScope) obj5;
                MutableState mutableState = (MutableState) obj4;
                FilesActivity filesActivity = (FilesActivity) obj3;
                FilesClient filesClient = (FilesClient) obj2;
                Uri uri = (Uri) obj;
                int i2 = FilesActivity.$r8$clinit;
                File file = (File) mutableState.getValue();
                mutableState.setValue(null);
                if (uri != null && file != null) {
                    JobKt.launch$default(coroutineScope, null, new RealImageLoader$executeMain$result$1(filesActivity, filesClient, uri, file, null, 11), 3);
                }
                return Unit.INSTANCE;
            case 1:
                Animatable animatable = (Animatable) obj5;
                AnimationState animationState = (AnimationState) obj4;
                Function1 function1 = (Function1) obj3;
                Ref$BooleanRef ref$BooleanRef = (Ref$BooleanRef) obj2;
                AnimationScope animationScope = (AnimationScope) obj;
                ArcSplineKt.updateState(animationScope, animatable.internalState);
                ParcelableSnapshotMutableState parcelableSnapshotMutableState = animationScope.value$delegate;
                Object objAccess$clampToBounds = Animatable.access$clampToBounds(animatable, parcelableSnapshotMutableState.getValue());
                if (!Intrinsics.areEqual(objAccess$clampToBounds, parcelableSnapshotMutableState.getValue())) {
                    animatable.internalState.value$delegate.setValue(objAccess$clampToBounds);
                    animationState.value$delegate.setValue(objAccess$clampToBounds);
                    if (function1 != null) {
                        function1.invoke(animatable);
                    }
                    animationScope.cancelAnimation();
                    ref$BooleanRef.element = true;
                } else if (function1 != null) {
                    function1.invoke(animatable);
                }
                return Unit.INSTANCE;
            case 2:
                InfiniteTransition infiniteTransition = (InfiniteTransition) obj3;
                Ref$FloatRef ref$FloatRef = (Ref$FloatRef) obj2;
                CoroutineScope coroutineScope2 = (CoroutineScope) obj5;
                long jLongValue = ((Long) obj).longValue();
                State state = (State) ((MutableState) obj4).getValue();
                long jLongValue2 = state != null ? ((Number) state.getValue()).longValue() : jLongValue;
                long j = infiniteTransition.startTimeNanos;
                MutableVector mutableVector = infiniteTransition._animations;
                if (j == Long.MIN_VALUE || ref$FloatRef.element != ArcSplineKt.getDurationScale(coroutineScope2.getCoroutineContext())) {
                    infiniteTransition.startTimeNanos = jLongValue;
                    Object[] objArr = mutableVector.content;
                    int i3 = mutableVector.size;
                    for (int i4 = 0; i4 < i3; i4++) {
                        ((InfiniteTransition.TransitionAnimationState) objArr[i4]).startOnTheNextFrame = true;
                    }
                    ref$FloatRef.element = ArcSplineKt.getDurationScale(coroutineScope2.getCoroutineContext());
                }
                float f = ref$FloatRef.element;
                if (f == 0.0f) {
                    Object[] objArr2 = mutableVector.content;
                    int i5 = mutableVector.size;
                    for (int i6 = 0; i6 < i5; i6++) {
                        InfiniteTransition.TransitionAnimationState transitionAnimationState = (InfiniteTransition.TransitionAnimationState) objArr2[i6];
                        transitionAnimationState.value$delegate.setValue(transitionAnimationState.animation.mutableTargetValue);
                        transitionAnimationState.startOnTheNextFrame = true;
                    }
                } else {
                    long j2 = (long) ((jLongValue2 - infiniteTransition.startTimeNanos) / f);
                    Object[] objArr3 = mutableVector.content;
                    int i7 = mutableVector.size;
                    boolean z = true;
                    for (int i8 = 0; i8 < i7; i8++) {
                        InfiniteTransition.TransitionAnimationState transitionAnimationState2 = (InfiniteTransition.TransitionAnimationState) objArr3[i8];
                        if (!transitionAnimationState2.isFinished) {
                            transitionAnimationState2.this$0.refreshChildNeeded$delegate.setValue(Boolean.FALSE);
                            if (transitionAnimationState2.startOnTheNextFrame) {
                                transitionAnimationState2.startOnTheNextFrame = false;
                                transitionAnimationState2.playTimeNanosOffset = j2;
                            }
                            long j3 = j2 - transitionAnimationState2.playTimeNanosOffset;
                            transitionAnimationState2.value$delegate.setValue(transitionAnimationState2.animation.getValueFromNanos(j3));
                            TargetBasedAnimation targetBasedAnimation = transitionAnimationState2.animation;
                            targetBasedAnimation.getClass();
                            transitionAnimationState2.isFinished = ImageAnalysis$$ExternalSyntheticLambda1.$default$isFinishedFromNanos(targetBasedAnimation, j3);
                        }
                        if (!transitionAnimationState2.isFinished) {
                            z = false;
                        }
                    }
                    infiniteTransition.isRunning$delegate.setValue(Boolean.valueOf(!z));
                }
                return Unit.INSTANCE;
            case 3:
                Ref$FloatRef ref$FloatRef2 = (Ref$FloatRef) obj5;
                MouseWheelScrollingLogic mouseWheelScrollingLogic = (MouseWheelScrollingLogic) obj4;
                ScrollingLogic$nestedScrollScope$1 scrollingLogic$nestedScrollScope$1 = (ScrollingLogic$nestedScrollScope$1) obj3;
                ActivityResultRegistryKt$$ExternalSyntheticLambda1 activityResultRegistryKt$$ExternalSyntheticLambda1 = (ActivityResultRegistryKt$$ExternalSyntheticLambda1) obj2;
                AnimationScope animationScope2 = (AnimationScope) obj;
                float fFloatValue = ((Number) animationScope2.value$delegate.getValue()).floatValue() - ref$FloatRef2.element;
                if (!MouseWheelScrollingLogicKt.access$isLowScrollingDelta(fFloatValue)) {
                    if (!MouseWheelScrollingLogicKt.access$isLowScrollingDelta(fFloatValue - mouseWheelScrollingLogic.dispatchMouseWheelScroll(scrollingLogic$nestedScrollScope$1, fFloatValue))) {
                        animationScope2.cancelAnimation();
                        return Unit.INSTANCE;
                    }
                    ref$FloatRef2.element += fFloatValue;
                }
                if (((Boolean) activityResultRegistryKt$$ExternalSyntheticLambda1.invoke(Float.valueOf(ref$FloatRef2.element))).booleanValue()) {
                    animationScope2.cancelAnimation();
                }
                return Unit.INSTANCE;
            case 4:
                LegacyTextFieldState legacyTextFieldState = (LegacyTextFieldState) obj5;
                TextInputService textInputService = (TextInputService) obj4;
                TextFieldValue textFieldValue = (TextFieldValue) obj3;
                ImeOptions imeOptions = (ImeOptions) obj2;
                if (legacyTextFieldState.getHasFocus()) {
                    RequestService requestService = legacyTextFieldState.processor;
                    CoreTextFieldKt$$ExternalSyntheticLambda4 coreTextFieldKt$$ExternalSyntheticLambda4 = legacyTextFieldState.onValueChange;
                    CoreTextFieldKt$$ExternalSyntheticLambda4 coreTextFieldKt$$ExternalSyntheticLambda5 = legacyTextFieldState.onImeActionPerformed;
                    Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                    LifecycleEffectKt$$ExternalSyntheticLambda1 lifecycleEffectKt$$ExternalSyntheticLambda1 = new LifecycleEffectKt$$ExternalSyntheticLambda1((Object) requestService, (Function1) coreTextFieldKt$$ExternalSyntheticLambda4, (Object) ref$ObjectRef, 8);
                    PlatformTextInputService platformTextInputService = textInputService.platformTextInputService;
                    platformTextInputService.startInput(textFieldValue, imeOptions, lifecycleEffectKt$$ExternalSyntheticLambda1, coreTextFieldKt$$ExternalSyntheticLambda5);
                    TextInputSession textInputSession = new TextInputSession(textInputService, platformTextInputService);
                    textInputService._currentInputSession.set(textInputSession);
                    ref$ObjectRef.element = textInputSession;
                    legacyTextFieldState.inputSession = textInputSession;
                }
                return new CoreTextFieldKt$CoreTextField$lambda$18$0$$inlined$onDispose$1();
            case 5:
                FileAction fileAction = (FileAction) obj5;
                MutableState mutableState2 = (MutableState) obj4;
                MutableState mutableState3 = (MutableState) obj3;
                MutableState mutableState4 = (MutableState) obj2;
                File file2 = (File) obj;
                int i9 = FilesActivity.$r8$clinit;
                mutableState2.setValue(fileAction instanceof FileAction.Import ? file2 : (File) mutableState2.getValue());
                mutableState3.setValue(fileAction instanceof FileAction.Export ? file2 : (File) mutableState3.getValue());
                if (fileAction instanceof FileAction.Rename) {
                    mutableState4.setValue(file2);
                }
                return Unit.INSTANCE;
            case 6:
                CoroutineScope coroutineScope3 = (CoroutineScope) obj5;
                LogcatActivity logcatActivity = (LogcatActivity) obj3;
                LogFile logFile = (LogFile) obj2;
                MutableState mutableState5 = (MutableState) obj4;
                Uri uri2 = (Uri) obj;
                int i10 = LogcatActivity.$r8$clinit;
                if (uri2 != null) {
                    JobKt.launch$default(coroutineScope3, null, new LogcatActivity$LocalLogContent$exportLauncher$1$1$1(logcatActivity, logFile, uri2, mutableState5, null, 0), 3);
                }
                return Unit.INSTANCE;
            default:
                final List list = (List) obj5;
                final Map map = (Map) obj4;
                final String str = (String) obj3;
                final Function1 function2 = (Function1) obj2;
                ((LazyListIntervalContent) obj).items(list.size(), new FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2(10, list, new AsyncImagePainter$$ExternalSyntheticLambda0(24)), new FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2(11, list), new ComposableLambdaImpl(802480018, new Function4() { // from class: com.github.kr328.clash.compose.proxy.ProxyScreenKt$ProxyGroupsScroll$lambda$46$lambda$44$lambda$43$$inlined$items$default$4
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj6, Object obj7, Object obj8, Object obj9) {
                        int i11;
                        String str2;
                        LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj6;
                        int iIntValue = ((Number) obj7).intValue();
                        GapComposer gapComposer = (GapComposer) obj8;
                        int iIntValue2 = ((Number) obj9).intValue();
                        if ((iIntValue2 & 6) == 0) {
                            i11 = (gapComposer.changed(lazyItemScopeImpl) ? 4 : 2) | iIntValue2;
                        } else {
                            i11 = iIntValue2;
                        }
                        if ((iIntValue2 & 48) == 0) {
                            i11 |= gapComposer.changed(iIntValue) ? 32 : 16;
                        }
                        if (gapComposer.shouldExecute(i11 & 1, (i11 & 147) != 146)) {
                            String str3 = (String) list.get(iIntValue);
                            gapComposer.startReplaceGroup(778069978);
                            ProxyGroup proxyGroup = (ProxyGroup) map.get(str3);
                            String str4 = null;
                            if (proxyGroup != null && (str2 = proxyGroup.icon) != null && !StringsKt.isBlank(str2)) {
                                str4 = str2;
                            }
                            String str5 = str4;
                            boolean zAreEqual = Intrinsics.areEqual(str, str3);
                            gapComposer.startReplaceGroup(1687673291);
                            Function1 function3 = function2;
                            boolean zChanged = gapComposer.changed(function3) | gapComposer.changed(str3);
                            Object objRememberedValue = gapComposer.rememberedValue();
                            if (zChanged || objRememberedValue == Composer$Companion.Empty) {
                                objRememberedValue = new Http2Connection.ReaderRunnable(7, function3, str3);
                                gapComposer.updateRememberedValue(objRememberedValue);
                            }
                            gapComposer.end(false);
                            ProxyScreenKt.ProxyGroupCard(str3, str5, zAreEqual, (Function0) objRememberedValue, gapComposer, 0);
                            gapComposer.end(false);
                        } else {
                            gapComposer.skipToGroupEnd();
                        }
                        return Unit.INSTANCE;
                    }
                }, true));
                return Unit.INSTANCE;
        }
    }

    public /* synthetic */ FilesActivity$$ExternalSyntheticLambda10(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$3 = obj4;
    }

    public /* synthetic */ FilesActivity$$ExternalSyntheticLambda10(CoroutineScope coroutineScope, LogcatActivity logcatActivity, LogFile logFile, MutableState mutableState) {
        this.$r8$classId = 6;
        this.f$0 = coroutineScope;
        this.f$2 = logcatActivity;
        this.f$3 = logFile;
        this.f$1 = mutableState;
    }
}
