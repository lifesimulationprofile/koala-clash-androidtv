package androidx.compose.ui.platform;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.DynamicProvidableCompositionLocal;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.HostDefaultProviderKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.composer.gapbuffer.SlotTable;
import androidx.compose.runtime.composer.gapbuffer.SlotWriter;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.runtime.saveable.SaveableStateRegistryImpl;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.runtime.tooling.InspectionTablesKt;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.res.ImageVectorCache;
import androidx.compose.ui.res.ResourceIdCache;
import androidx.compose.ui.text.font.Font$ResourceLoader;
import androidx.fragment.app.FragmentManager$$ExternalSyntheticLambda4;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.navigation.Navigator;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.compose.LocalSavedStateRegistryOwnerKt;
import coil.request.RequestService;
import com.github.kr328.clash.remote.StatusClient;
import com.google.android.gms.internal.mlkit_vision_barcode.zztt;
import com.koala.clash.R;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableSet;
import okhttp3.Handshake;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ComposeViewContext {
    public final AndroidAccessibilityManager accessibilityManager;
    public final Handshake.AnonymousClass2 calculateWindowSizeLambda;
    public final ComposeViewContext$callback$1 callback;
    public final CanvasHolder canvasHolder;
    public final AndroidClipboard clipboard;
    public final AndroidClipboardManager clipboardManager;
    public final CompositionContext compositionContext;
    public final MutableState configuration;
    public final Configuration currentConfiguration;
    public final MutableState fontFamilyResolver;
    public final Font$ResourceLoader fontLoader;
    public final HapticFeedback hapticFeedback;
    public final ImageVectorCache imageVectorCache;
    public final LifecycleOwner lifecycleOwner;
    public final ResourceIdCache resourceIdCache;
    public final SavedStateRegistryOwner savedStateRegistryOwner;
    public final LayoutNodeDrawScope sharedDrawScope;
    public final AndroidUriHandler uriHandler;
    public final View view;
    public final AndroidViewConfiguration viewConfiguration;
    public int viewCount;
    public final ViewModelStoreOwner viewModelStoreOwner;
    public final LazyWindowInfo windowInfo;

    public ComposeViewContext(ComposeViewContext composeViewContext, View view, CompositionContext compositionContext, LifecycleOwner lifecycleOwner, SavedStateRegistryOwner savedStateRegistryOwner, ViewModelStoreOwner viewModelStoreOwner) {
        CanvasHolder canvasHolder;
        LayoutNodeDrawScope layoutNodeDrawScope;
        ResourceIdCache resourceIdCache;
        View view2;
        boolean zAreEqual = Intrinsics.areEqual((composeViewContext == null || (view2 = composeViewContext.view) == null) ? null : view2.getContext(), view.getContext());
        this.view = view;
        this.compositionContext = compositionContext;
        this.lifecycleOwner = lifecycleOwner;
        this.savedStateRegistryOwner = savedStateRegistryOwner;
        this.viewModelStoreOwner = viewModelStoreOwner;
        this.imageVectorCache = zAreEqual ? composeViewContext.imageVectorCache : new ImageVectorCache();
        this.resourceIdCache = (composeViewContext == null || (resourceIdCache = composeViewContext.resourceIdCache) == null) ? new ResourceIdCache() : resourceIdCache;
        Configuration configuration = zAreEqual ? composeViewContext.currentConfiguration : new Configuration(view.getContext().getResources().getConfiguration());
        this.currentConfiguration = configuration;
        this.configuration = zAreEqual ? composeViewContext.configuration : Stack.mutableStateOf$default(new Configuration(configuration));
        this.accessibilityManager = zAreEqual ? composeViewContext.accessibilityManager : new AndroidAccessibilityManager(view.getContext());
        this.uriHandler = zAreEqual ? composeViewContext.uriHandler : new AndroidUriHandler(view.getContext(), (byte) 0);
        AndroidClipboardManager androidClipboardManager = zAreEqual ? composeViewContext.clipboardManager : new AndroidClipboardManager(view.getContext());
        this.clipboardManager = androidClipboardManager;
        this.clipboard = zAreEqual ? composeViewContext.clipboard : new AndroidClipboard(androidClipboardManager);
        this.fontLoader = zAreEqual ? composeViewContext.fontLoader : new StatusClient(view.getContext(), false);
        this.fontFamilyResolver = zAreEqual ? composeViewContext.fontFamilyResolver : new ParcelableSnapshotMutableState(zztt.createFontFamilyResolver(view.getContext()), NeverEqualPolicy.INSTANCE$1);
        this.hapticFeedback = view == (composeViewContext != null ? composeViewContext.view : null) ? composeViewContext.hapticFeedback : new PlatformHapticFeedback(view);
        this.viewConfiguration = zAreEqual ? composeViewContext.viewConfiguration : new AndroidViewConfiguration(android.view.ViewConfiguration.get(view.getContext()));
        this.sharedDrawScope = (composeViewContext == null || (layoutNodeDrawScope = composeViewContext.sharedDrawScope) == null) ? new LayoutNodeDrawScope() : layoutNodeDrawScope;
        this.windowInfo = new LazyWindowInfo();
        this.canvasHolder = (composeViewContext == null || (canvasHolder = composeViewContext.canvasHolder) == null) ? new CanvasHolder() : canvasHolder;
        this.calculateWindowSizeLambda = new Handshake.AnonymousClass2(11, this);
        this.callback = new ComposeViewContext$callback$1(this);
    }

    public final void ProvideCompositionLocals$ui(AndroidComposeView androidComposeView, Function2 function2, GapComposer gapComposer, int i) {
        char c;
        char c2;
        boolean z;
        gapComposer.startRestartGroup(123858079);
        int i2 = (gapComposer.changedInstance(androidComposeView) ? 4 : 2) | i | (gapComposer.changedInstance(function2) ? 32 : 16) | (gapComposer.changedInstance(this) ? 256 : 128);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            Object tag = androidComposeView.getTag(R.id.inspection_slot_table_set);
            LinkedHashMap linkedHashMap = null;
            Set set = (!(tag instanceof Set) || ((tag instanceof KMappedMarker) && !(tag instanceof KMutableSet))) ? null : (Set) tag;
            if (set == null) {
                Object parent = androidComposeView.getParent();
                View view = parent instanceof View ? (View) parent : null;
                Object tag2 = view != null ? view.getTag(R.id.inspection_slot_table_set) : null;
                set = (!(tag2 instanceof Set) || ((tag2 instanceof KMappedMarker) && !(tag2 instanceof KMutableSet))) ? null : (Set) tag2;
            }
            if (set != null) {
                set.add(gapComposer.getCompositionData());
                gapComposer.forceRecomposeScopes = true;
                gapComposer.sourceMarkersEnabled = true;
                gapComposer.slotTable.collectSourceInformation();
                gapComposer.insertTable.collectSourceInformation();
                SlotWriter slotWriter = gapComposer.writer;
                SlotTable slotTable = slotWriter.table;
                slotWriter.sourceInformationMap = slotTable.sourceInformationMap;
                slotWriter.calledByMap = slotTable.calledByMap;
            }
            Object objRememberedValue = gapComposer.rememberedValue();
            SavedStateRegistryOwner savedStateRegistryOwner = this.savedStateRegistryOwner;
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (objRememberedValue == neverEqualPolicy) {
                View view2 = (View) androidComposeView.getParent();
                Object tag3 = view2.getTag(R.id.compose_view_saveable_id_tag);
                String strValueOf = tag3 instanceof String ? (String) tag3 : null;
                if (strValueOf == null) {
                    strValueOf = String.valueOf(view2.getId());
                }
                String strM = CaptureSession$State$EnumUnboxingLocalUtility.m("SaveableStateRegistry:", strValueOf);
                RequestService savedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
                Bundle bundleConsumeRestoredStateForKey = savedStateRegistry.consumeRestoredStateForKey(strM);
                if (bundleConsumeRestoredStateForKey != null) {
                    linkedHashMap = new LinkedHashMap();
                    for (String str : bundleConsumeRestoredStateForKey.keySet()) {
                        linkedHashMap.put(str, bundleConsumeRestoredStateForKey.getParcelableArrayList(str));
                    }
                }
                c = 4;
                c2 = 2;
                AndroidComposeView.AnonymousClass1 anonymousClass1 = AndroidComposeView.AnonymousClass1.INSTANCE$3;
                StaticProvidableCompositionLocal staticProvidableCompositionLocal = SaveableStateRegistryKt.LocalSaveableStateRegistry;
                SaveableStateRegistryImpl saveableStateRegistryImpl = new SaveableStateRegistryImpl(linkedHashMap, anonymousClass1);
                if (savedStateRegistry.getSavedStateProvider(strM) != null) {
                    z = false;
                } else {
                    try {
                        savedStateRegistry.registerSavedStateProvider(strM, new FragmentManager$$ExternalSyntheticLambda4(1, saveableStateRegistryImpl));
                        z = true;
                    } catch (IllegalArgumentException unused) {
                        z = false;
                    }
                }
                DisposableSaveableStateRegistry disposableSaveableStateRegistry = new DisposableSaveableStateRegistry(saveableStateRegistryImpl, new DisposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$1(z, savedStateRegistry, strM));
                gapComposer.updateRememberedValue(disposableSaveableStateRegistry);
                objRememberedValue = disposableSaveableStateRegistry;
            } else {
                c = 4;
                c2 = 2;
            }
            DisposableSaveableStateRegistry disposableSaveableStateRegistry2 = (DisposableSaveableStateRegistry) objRememberedValue;
            Unit unit = Unit.INSTANCE;
            boolean zChangedInstance = gapComposer.changedInstance(disposableSaveableStateRegistry2);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new Navigator.AnonymousClass1(20, disposableSaveableStateRegistry2);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            Stack.DisposableEffect(unit, (Function1) objRememberedValue2, gapComposer);
            DynamicProvidableCompositionLocal dynamicProvidableCompositionLocal = CompositionLocalsKt.LocalProvidableScrollCaptureInProgress;
            boolean zBooleanValue = ((Boolean) gapComposer.consume(dynamicProvidableCompositionLocal)).booleanValue() | androidComposeView.getScrollCaptureInProgress$ui();
            boolean zChanged = gapComposer.changed(androidComposeView.getView());
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue3 == neverEqualPolicy) {
                androidComposeView.getView();
                objRememberedValue3 = new ViewTreeHostDefaultProvider();
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            ProvidedValue providedValueDefaultProvidedValue$runtime = LocalLifecycleOwnerKt.LocalLifecycleOwner.defaultProvidedValue$runtime(this.lifecycleOwner);
            ProvidedValue providedValueDefaultProvidedValue$runtime2 = LocalSavedStateRegistryOwnerKt.LocalSavedStateRegistryOwner.defaultProvidedValue$runtime(savedStateRegistryOwner);
            ProvidedValue providedValueDefaultProvidedValue$runtime3 = AndroidCompositionLocals_androidKt.LocalImageVectorCache.defaultProvidedValue$runtime(this.imageVectorCache);
            ProvidedValue providedValueDefaultProvidedValue$runtime4 = AndroidCompositionLocals_androidKt.LocalResourceIdCache.defaultProvidedValue$runtime(this.resourceIdCache);
            ProvidedValue providedValueDefaultProvidedValue$runtime5 = AndroidCompositionLocals_androidKt.LocalContext.defaultProvidedValue$runtime(androidComposeView.getContext());
            ProvidedValue providedValueDefaultProvidedValue$runtime6 = InspectionTablesKt.LocalInspectionTables.defaultProvidedValue$runtime(set);
            ProvidedValue providedValueDefaultProvidedValue$runtime7 = AndroidCompositionLocals_androidKt.LocalConfiguration.defaultProvidedValue$runtime(androidComposeView.getConfiguration());
            ProvidedValue providedValueDefaultProvidedValue$runtime8 = SaveableStateRegistryKt.LocalSaveableStateRegistry.defaultProvidedValue$runtime(disposableSaveableStateRegistry2);
            ProvidedValue providedValueDefaultProvidedValue$runtime9 = AndroidCompositionLocals_androidKt.LocalView.defaultProvidedValue$runtime(androidComposeView.getView());
            ProvidedValue providedValueDefaultProvidedValue$runtime10 = dynamicProvidableCompositionLocal.defaultProvidedValue$runtime(Boolean.valueOf(zBooleanValue));
            ProvidedValue providedValueDefaultProvidedValue$runtime11 = CompositionLocalsKt.LocalViewConfiguration.defaultProvidedValue$runtime(androidComposeView.getViewConfiguration());
            ProvidedValue providedValueDefaultProvidedValue$runtime12 = HostDefaultProviderKt.LocalHostDefaultProvider.defaultProvidedValue$runtime((ViewTreeHostDefaultProvider) objRememberedValue3);
            ProvidedValue[] providedValueArr = new ProvidedValue[12];
            providedValueArr[0] = providedValueDefaultProvidedValue$runtime;
            providedValueArr[1] = providedValueDefaultProvidedValue$runtime2;
            providedValueArr[c2] = providedValueDefaultProvidedValue$runtime3;
            providedValueArr[3] = providedValueDefaultProvidedValue$runtime4;
            providedValueArr[c] = providedValueDefaultProvidedValue$runtime5;
            providedValueArr[5] = providedValueDefaultProvidedValue$runtime6;
            providedValueArr[6] = providedValueDefaultProvidedValue$runtime7;
            providedValueArr[7] = providedValueDefaultProvidedValue$runtime8;
            providedValueArr[8] = providedValueDefaultProvidedValue$runtime9;
            providedValueArr[9] = providedValueDefaultProvidedValue$runtime10;
            providedValueArr[10] = providedValueDefaultProvidedValue$runtime11;
            providedValueArr[11] = providedValueDefaultProvidedValue$runtime12;
            Stack.CompositionLocalProvider(providedValueArr, Thread_jvmKt.rememberComposableLambda(1317454175, new ComposeViewContext$ProvideCompositionLocals$2(androidComposeView, this, function2), gapComposer), gapComposer, 56);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ComposeViewContext$ProvideCompositionLocals$2(this, androidComposeView, function2, i);
        }
    }

    public final void decrementViewCount$ui() {
        int i = this.viewCount - 1;
        this.viewCount = i;
        if (i < 0) {
            Log.e("ComposeViewContext", "View count has dropped below 0");
            this.viewCount = 0;
        }
        if (this.viewCount == 0) {
            View view = this.view;
            Context context = view.getContext();
            ComposeViewContext$callback$1 composeViewContext$callback$1 = this.callback;
            context.unregisterComponentCallbacks(composeViewContext$callback$1);
            LazyWindowInfo lazyWindowInfo = this.windowInfo;
            if (lazyWindowInfo._containerSize == null) {
                lazyWindowInfo.onInitializeContainerSize = null;
            }
            view.getViewTreeObserver().removeOnWindowFocusChangeListener(composeViewContext$callback$1);
        }
    }

    public final void incrementViewCount$ui() {
        int i = this.viewCount + 1;
        this.viewCount = i;
        if (i == 1) {
            View view = this.view;
            Context context = view.getContext();
            ComposeViewContext$callback$1 composeViewContext$callback$1 = this.callback;
            context.registerComponentCallbacks(composeViewContext$callback$1);
            onConfigurationChanged$ui(view.getResources().getConfiguration());
            boolean zHasWindowFocus = view.hasWindowFocus();
            LazyWindowInfo lazyWindowInfo = this.windowInfo;
            lazyWindowInfo.isWindowFocused$delegate.setValue(Boolean.valueOf(zHasWindowFocus));
            ParcelableSnapshotMutableState parcelableSnapshotMutableState = lazyWindowInfo._containerSize;
            Handshake.AnonymousClass2 anonymousClass2 = this.calculateWindowSizeLambda;
            if (parcelableSnapshotMutableState == null) {
                lazyWindowInfo.onInitializeContainerSize = anonymousClass2;
            }
            if (parcelableSnapshotMutableState != null) {
                parcelableSnapshotMutableState.setValue(anonymousClass2.invoke());
            }
            view.getViewTreeObserver().addOnWindowFocusChangeListener(composeViewContext$callback$1);
        }
    }

    public final void onConfigurationChanged$ui(Configuration configuration) {
        ParcelableSnapshotMutableState parcelableSnapshotMutableState;
        int iUpdateFrom = this.currentConfiguration.updateFrom(configuration);
        if (iUpdateFrom != 0) {
            Iterator it = this.imageVectorCache.map.entrySet().iterator();
            while (it.hasNext()) {
                ImageVectorCache.ImageVectorEntry imageVectorEntry = (ImageVectorCache.ImageVectorEntry) ((WeakReference) ((Map.Entry) it.next()).getValue()).get();
                if (imageVectorEntry == null || Configuration.needNewResources(iUpdateFrom, imageVectorEntry.configFlags)) {
                    it.remove();
                }
            }
            this.configuration.setValue(new Configuration(configuration));
            this.resourceIdCache.clear();
            if ((268435456 & iUpdateFrom) != 0) {
                this.fontFamilyResolver.setValue(zztt.createFontFamilyResolver(this.view.getContext()));
            }
            if (((-1342235264) & iUpdateFrom) == 0 || (parcelableSnapshotMutableState = this.windowInfo._containerSize) == null) {
                return;
            }
            parcelableSnapshotMutableState.setValue(this.calculateWindowSizeLambda.invoke());
        }
    }
}
