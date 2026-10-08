package androidx.compose.foundation.text;

import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.foundation.text.selection.SimpleLayoutKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.LazyWindowInfo;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.lifecycle.ViewModelKt;
import coil.compose.AsyncImagePainter$$ExternalSyntheticLambda0;
import coil.util.ContinuationCallback;
import com.github.kr328.clash.compose.FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2;
import com.github.kr328.clash.compose.profiles.ProfilesViewModel;
import com.github.kr328.clash.core.model.Proxy;
import com.github.kr328.clash.core.model.ProxyGroup;
import com.github.kr328.clash.service.model.Profile;
import dev.chrisbanes.haze.RenderScriptBlurEffect$updateSurface$2$4;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class CoreTextFieldKt$$ExternalSyntheticLambda9 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;

    public /* synthetic */ CoreTextFieldKt$$ExternalSyntheticLambda9(LegacyTextFieldState legacyTextFieldState, boolean z, WindowInfo windowInfo, TextFieldSelectionManager textFieldSelectionManager, TextFieldValue textFieldValue, OffsetMapping offsetMapping) {
        this.$r8$classId = 0;
        this.f$0 = legacyTextFieldState;
        this.f$1 = z;
        this.f$2 = windowInfo;
        this.f$3 = textFieldSelectionManager;
        this.f$4 = textFieldValue;
        this.f$5 = offsetMapping;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        TextInputSession textInputSession;
        LayoutCoordinates layoutCoordinates;
        LayoutCoordinates layoutCoordinates2;
        switch (this.$r8$classId) {
            case 0:
                LegacyTextFieldState legacyTextFieldState = (LegacyTextFieldState) this.f$0;
                ParcelableSnapshotMutableState parcelableSnapshotMutableState = legacyTextFieldState.showCursorHandle$delegate;
                WindowInfo windowInfo = (WindowInfo) this.f$2;
                TextFieldSelectionManager textFieldSelectionManager = (TextFieldSelectionManager) this.f$3;
                TextFieldValue textFieldValue = (TextFieldValue) this.f$4;
                OffsetMapping offsetMapping = (OffsetMapping) this.f$5;
                LayoutCoordinates layoutCoordinates3 = (LayoutCoordinates) obj;
                legacyTextFieldState._layoutCoordinates = layoutCoordinates3;
                TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
                if (layoutResult != null) {
                    layoutResult.innerTextFieldCoordinates = layoutCoordinates3;
                }
                if (this.f$1) {
                    if (legacyTextFieldState.getHandleState() == HandleState.Selection) {
                        if (((Boolean) legacyTextFieldState.showFloatingToolbar$delegate.getValue()).booleanValue() && ((Boolean) ((LazyWindowInfo) windowInfo).isWindowFocused$delegate.getValue()).booleanValue()) {
                            textFieldSelectionManager.showSelectionToolbar$foundation();
                        } else {
                            textFieldSelectionManager.hideSelectionToolbar$foundation();
                        }
                        legacyTextFieldState.showSelectionHandleStart$delegate.setValue(Boolean.valueOf(SimpleLayoutKt.isSelectionHandleInVisibleBound(textFieldSelectionManager, true)));
                        legacyTextFieldState.showSelectionHandleEnd$delegate.setValue(Boolean.valueOf(SimpleLayoutKt.isSelectionHandleInVisibleBound(textFieldSelectionManager, false)));
                        parcelableSnapshotMutableState.setValue(Boolean.valueOf(TextRange.m641getCollapsedimpl(textFieldValue.selection)));
                    } else if (legacyTextFieldState.getHandleState() == HandleState.Cursor) {
                        parcelableSnapshotMutableState.setValue(Boolean.valueOf(SimpleLayoutKt.isSelectionHandleInVisibleBound(textFieldSelectionManager, true)));
                    }
                    BasicTextKt.notifyFocusedRect(legacyTextFieldState, textFieldValue, offsetMapping);
                    TextLayoutResultProxy layoutResult2 = legacyTextFieldState.getLayoutResult();
                    if (layoutResult2 != null && (textInputSession = legacyTextFieldState.inputSession) != null && legacyTextFieldState.getHasFocus() && (layoutCoordinates = layoutResult2.innerTextFieldCoordinates) != null && layoutCoordinates.isAttached() && (layoutCoordinates2 = layoutResult2.decorationBoxCoordinates) != null) {
                        TextLayoutResult textLayoutResult = layoutResult2.value;
                        RenderScriptBlurEffect$updateSurface$2$4 renderScriptBlurEffect$updateSurface$2$4 = new RenderScriptBlurEffect$updateSurface$2$4(1, layoutCoordinates);
                        Rect rectVisibleBounds = SimpleLayoutKt.visibleBounds(layoutCoordinates);
                        Rect rectLocalBoundingBoxOf = layoutCoordinates.localBoundingBoxOf(layoutCoordinates2, false);
                        if (Intrinsics.areEqual((TextInputSession) textInputSession.textInputService._currentInputSession.get(), textInputSession)) {
                            textInputSession.platformTextInputService.updateTextLayoutResult(textFieldValue, offsetMapping, textLayoutResult, renderScriptBlurEffect$updateSurface$2$4, rectVisibleBounds, rectLocalBoundingBoxOf);
                        }
                    }
                }
                break;
            case 1:
                State state = (State) this.f$0;
                final ProfilesViewModel profilesViewModel = (ProfilesViewModel) this.f$2;
                final Function1 function1 = (Function1) this.f$3;
                final State state2 = (State) this.f$4;
                final MutableState mutableState = (MutableState) this.f$5;
                final List list = (List) state.getValue();
                AsyncImagePainter$$ExternalSyntheticLambda0 asyncImagePainter$$ExternalSyntheticLambda0 = new AsyncImagePainter$$ExternalSyntheticLambda0(23);
                int size = list.size();
                ContinuationCallback continuationCallback = new ContinuationCallback(7, asyncImagePainter$$ExternalSyntheticLambda0, list);
                FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2 filesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2 = new FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2(9, list);
                final boolean z = this.f$1;
                ((LazyListIntervalContent) obj).items(size, continuationCallback, filesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2, new ComposableLambdaImpl(802480018, new Function4() { // from class: com.github.kr328.clash.compose.profiles.ProfilesScreenKt$ProfilesScreen$2$invoke$lambda$9$lambda$8$lambda$7$$inlined$items$default$4
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                        int i;
                        LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj2;
                        int iIntValue = ((Number) obj3).intValue();
                        GapComposer gapComposer = (GapComposer) obj4;
                        int iIntValue2 = ((Number) obj5).intValue();
                        if ((iIntValue2 & 6) == 0) {
                            i = (gapComposer.changed(lazyItemScopeImpl) ? 4 : 2) | iIntValue2;
                        } else {
                            i = iIntValue2;
                        }
                        if ((iIntValue2 & 48) == 0) {
                            i |= gapComposer.changed(iIntValue) ? 32 : 16;
                        }
                        if (gapComposer.shouldExecute(i & 1, (i & 147) != 146)) {
                            final Profile profile = (Profile) list.get(iIntValue);
                            gapComposer.startReplaceGroup(-172493799);
                            boolean zContains = ((Set) state2.getValue()).contains(profile.uuid);
                            gapComposer.startReplaceGroup(-1945221571);
                            final ProfilesViewModel profilesViewModel2 = profilesViewModel;
                            boolean zChangedInstance = gapComposer.changedInstance(profilesViewModel2) | gapComposer.changedInstance(profile);
                            Object objRememberedValue = gapComposer.rememberedValue();
                            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
                            if (zChangedInstance || objRememberedValue == neverEqualPolicy) {
                                final int i2 = 0;
                                objRememberedValue = new Function0() { // from class: com.github.kr328.clash.compose.profiles.ProfilesScreenKt$ProfilesScreen$2$1$2$1$2$1$1
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        Object value;
                                        switch (i2) {
                                            case 0:
                                                JobKt.launch$default(ViewModelKt.getViewModelScope(profilesViewModel2), null, new ProfilesViewModel$activate$1(profile, null, 0), 3);
                                                break;
                                            default:
                                                ProfilesViewModel profilesViewModel3 = profilesViewModel2;
                                                StateFlowImpl stateFlowImpl = profilesViewModel3._updatingProfiles;
                                                Profile profile2 = profile;
                                                UUID uuid = profile2.uuid;
                                                if (profile2.type != Profile.Type.File && !((Set) stateFlowImpl.getValue()).contains(uuid)) {
                                                    do {
                                                        value = stateFlowImpl.getValue();
                                                    } while (!stateFlowImpl.compareAndSet(value, SetsKt.plus((Set) value, uuid)));
                                                    JobKt.launch$default(ViewModelKt.getViewModelScope(profilesViewModel3), null, new ProfilesViewModel$delete$1(profile2, profilesViewModel3, (Continuation) null), 3);
                                                }
                                                break;
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                gapComposer.updateRememberedValue(objRememberedValue);
                            }
                            Function0 function0 = (Function0) objRememberedValue;
                            gapComposer.end(false);
                            gapComposer.startReplaceGroup(-1945219336);
                            Function1 function2 = function1;
                            boolean zChanged = gapComposer.changed(function2) | gapComposer.changedInstance(profile);
                            Object objRememberedValue2 = gapComposer.rememberedValue();
                            if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                                objRememberedValue2 = new ProfilesScreenKt$ProfilesScreen$2$1$2$1$2$2$1(function2, profile, 0);
                                gapComposer.updateRememberedValue(objRememberedValue2);
                            }
                            Function0 function3 = (Function0) objRememberedValue2;
                            gapComposer.end(false);
                            gapComposer.startReplaceGroup(-1945217182);
                            boolean zChangedInstance2 = gapComposer.changedInstance(profilesViewModel2) | gapComposer.changedInstance(profile);
                            Object objRememberedValue3 = gapComposer.rememberedValue();
                            if (zChangedInstance2 || objRememberedValue3 == neverEqualPolicy) {
                                final int i3 = 1;
                                objRememberedValue3 = new Function0() { // from class: com.github.kr328.clash.compose.profiles.ProfilesScreenKt$ProfilesScreen$2$1$2$1$2$1$1
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        Object value;
                                        switch (i3) {
                                            case 0:
                                                JobKt.launch$default(ViewModelKt.getViewModelScope(profilesViewModel2), null, new ProfilesViewModel$activate$1(profile, null, 0), 3);
                                                break;
                                            default:
                                                ProfilesViewModel profilesViewModel3 = profilesViewModel2;
                                                StateFlowImpl stateFlowImpl = profilesViewModel3._updatingProfiles;
                                                Profile profile2 = profile;
                                                UUID uuid = profile2.uuid;
                                                if (profile2.type != Profile.Type.File && !((Set) stateFlowImpl.getValue()).contains(uuid)) {
                                                    do {
                                                        value = stateFlowImpl.getValue();
                                                    } while (!stateFlowImpl.compareAndSet(value, SetsKt.plus((Set) value, uuid)));
                                                    JobKt.launch$default(ViewModelKt.getViewModelScope(profilesViewModel3), null, new ProfilesViewModel$delete$1(profile2, profilesViewModel3, (Continuation) null), 3);
                                                }
                                                break;
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                gapComposer.updateRememberedValue(objRememberedValue3);
                            }
                            Function0 function4 = (Function0) objRememberedValue3;
                            gapComposer.end(false);
                            gapComposer.startReplaceGroup(-1945214727);
                            boolean zChangedInstance3 = gapComposer.changedInstance(profile);
                            Object objRememberedValue4 = gapComposer.rememberedValue();
                            if (zChangedInstance3 || objRememberedValue4 == neverEqualPolicy) {
                                objRememberedValue4 = new Http2Connection.ReaderRunnable(6, profile, mutableState);
                                gapComposer.updateRememberedValue(objRememberedValue4);
                            }
                            gapComposer.end(false);
                            ProfileCardKt.ProfileCard(profile, zContains, function0, function3, function4, (Function0) objRememberedValue4, null, z, gapComposer, 0);
                            gapComposer.end(false);
                        } else {
                            gapComposer.skipToGroupEnd();
                        }
                        return Unit.INSTANCE;
                    }
                }, true));
                break;
            default:
                final ProxyGroup proxyGroup = (ProxyGroup) this.f$0;
                final Set set = (Set) this.f$2;
                final Set set2 = (Set) this.f$3;
                final Function1 function2 = (Function1) this.f$4;
                final Function1 function3 = (Function1) this.f$5;
                final List list2 = proxyGroup.proxies;
                AsyncImagePainter$$ExternalSyntheticLambda0 asyncImagePainter$$ExternalSyntheticLambda1 = new AsyncImagePainter$$ExternalSyntheticLambda0(25);
                int size2 = list2.size();
                FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2 filesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$3 = new FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2(12, list2, asyncImagePainter$$ExternalSyntheticLambda1);
                FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2 filesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$4 = new FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2(13, list2);
                final boolean z2 = this.f$1;
                ((LazyListIntervalContent) obj).items(size2, filesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$3, filesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$4, new ComposableLambdaImpl(802480018, new Function4() { // from class: com.github.kr328.clash.compose.proxy.ProxyScreenKt$ProxyServersList$lambda$28$lambda$27$$inlined$items$default$4
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                        int i;
                        LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj2;
                        int iIntValue = ((Number) obj3).intValue();
                        GapComposer gapComposer = (GapComposer) obj4;
                        int iIntValue2 = ((Number) obj5).intValue();
                        if ((iIntValue2 & 6) == 0) {
                            i = (gapComposer.changed(lazyItemScopeImpl) ? 4 : 2) | iIntValue2;
                        } else {
                            i = iIntValue2;
                        }
                        if ((iIntValue2 & 48) == 0) {
                            i |= gapComposer.changed(iIntValue) ? 32 : 16;
                        }
                        if (gapComposer.shouldExecute(i & 1, (i & 147) != 146)) {
                            final Proxy proxy = (Proxy) list2.get(iIntValue);
                            gapComposer.startReplaceGroup(-930792414);
                            String str = proxyGroup.now;
                            String str2 = proxy.name;
                            boolean zAreEqual = Intrinsics.areEqual(str, str2);
                            boolean zContains = set.contains(str2);
                            boolean zContains2 = set2.contains(str2);
                            gapComposer.startReplaceGroup(-1276944123);
                            final boolean z3 = z2;
                            boolean zChanged = gapComposer.changed(z3);
                            final Function1 function4 = function2;
                            boolean zChanged2 = zChanged | gapComposer.changed(function4) | gapComposer.changedInstance(proxy);
                            Object objRememberedValue = gapComposer.rememberedValue();
                            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
                            if (zChanged2 || objRememberedValue == neverEqualPolicy) {
                                objRememberedValue = new Function0() { // from class: com.github.kr328.clash.compose.proxy.ProxyScreenKt$ProxyServersList$1$1$2$1$1
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        if (z3) {
                                            function4.invoke(proxy.name);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                gapComposer.updateRememberedValue(objRememberedValue);
                            }
                            Function0 function0 = (Function0) objRememberedValue;
                            gapComposer.end(false);
                            gapComposer.startReplaceGroup(-1276940561);
                            Function1 function5 = function3;
                            boolean zChanged3 = gapComposer.changed(function5) | gapComposer.changedInstance(proxy);
                            Object objRememberedValue2 = gapComposer.rememberedValue();
                            if (zChanged3 || objRememberedValue2 == neverEqualPolicy) {
                                objRememberedValue2 = new Http2Connection.ReaderRunnable(8, function5, proxy);
                                gapComposer.updateRememberedValue(objRememberedValue2);
                            }
                            gapComposer.end(false);
                            ProxyScreenKt.ProxyServerRow(proxy, zAreEqual, zContains, zContains2, function0, (Function0) objRememberedValue2, gapComposer, 0);
                            gapComposer.end(false);
                        } else {
                            gapComposer.skipToGroupEnd();
                        }
                        return Unit.INSTANCE;
                    }
                }, true));
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ CoreTextFieldKt$$ExternalSyntheticLambda9(Object obj, Object obj2, Object obj3, boolean z, Object obj4, Object obj5, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$2 = obj2;
        this.f$3 = obj3;
        this.f$1 = z;
        this.f$4 = obj4;
        this.f$5 = obj5;
    }
}
