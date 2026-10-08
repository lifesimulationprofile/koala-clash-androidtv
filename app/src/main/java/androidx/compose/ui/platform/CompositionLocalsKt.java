package androidx.compose.ui.platform;

import androidx.compose.runtime.DynamicProvidableCompositionLocal;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.retain.LocalRetainedValuesStoreKt;
import androidx.compose.ui.node.Owner;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class CompositionLocalsKt {
    public static final StaticProvidableCompositionLocal LocalAccessibilityManager = new StaticProvidableCompositionLocal(CompositionLocalsKt$LocalDensity$1.INSTANCE$7);
    public static final StaticProvidableCompositionLocal LocalAutofill = new StaticProvidableCompositionLocal(CompositionLocalsKt$LocalDensity$1.INSTANCE$8);
    public static final StaticProvidableCompositionLocal LocalAutofillTree = new StaticProvidableCompositionLocal(CompositionLocalsKt$LocalDensity$1.INSTANCE$10);
    public static final StaticProvidableCompositionLocal LocalAutofillManager = new StaticProvidableCompositionLocal(CompositionLocalsKt$LocalDensity$1.INSTANCE$9);
    public static final StaticProvidableCompositionLocal LocalClipboardManager = new StaticProvidableCompositionLocal(CompositionLocalsKt$LocalDensity$1.INSTANCE$12);
    public static final StaticProvidableCompositionLocal LocalClipboard = new StaticProvidableCompositionLocal(CompositionLocalsKt$LocalDensity$1.INSTANCE$11);
    public static final StaticProvidableCompositionLocal LocalGraphicsContext = new StaticProvidableCompositionLocal(CompositionLocalsKt$LocalDensity$1.INSTANCE$17);
    public static final StaticProvidableCompositionLocal LocalDensity = new StaticProvidableCompositionLocal(CompositionLocalsKt$LocalDensity$1.INSTANCE);
    public static final StaticProvidableCompositionLocal LocalFocusManager = new StaticProvidableCompositionLocal(CompositionLocalsKt$LocalDensity$1.INSTANCE$14);
    public static final StaticProvidableCompositionLocal LocalFontLoader = new StaticProvidableCompositionLocal(CompositionLocalsKt$LocalDensity$1.INSTANCE$16);
    public static final StaticProvidableCompositionLocal LocalFontFamilyResolver = new StaticProvidableCompositionLocal(CompositionLocalsKt$LocalDensity$1.INSTANCE$15);
    public static final StaticProvidableCompositionLocal LocalHapticFeedback = new StaticProvidableCompositionLocal(CompositionLocalsKt$LocalDensity$1.INSTANCE$18);
    public static final StaticProvidableCompositionLocal LocalInputModeManager = new StaticProvidableCompositionLocal(CompositionLocalsKt$LocalDensity$1.INSTANCE$19);
    public static final StaticProvidableCompositionLocal LocalLayoutDirection = new StaticProvidableCompositionLocal(CompositionLocalsKt$LocalDensity$1.INSTANCE$20);
    public static final StaticProvidableCompositionLocal LocalProvidableLocaleList = new StaticProvidableCompositionLocal(CompositionLocalsKt$LocalDensity$1.INSTANCE$22);
    public static final StaticProvidableCompositionLocal LocalTextInputService = new StaticProvidableCompositionLocal(CompositionLocalsKt$LocalDensity$1.INSTANCE$25);
    public static final StaticProvidableCompositionLocal LocalSoftwareKeyboardController = new StaticProvidableCompositionLocal(CompositionLocalsKt$LocalDensity$1.INSTANCE$24);
    public static final StaticProvidableCompositionLocal LocalTextToolbar = new StaticProvidableCompositionLocal(CompositionLocalsKt$LocalDensity$1.INSTANCE$26);
    public static final StaticProvidableCompositionLocal LocalUriHandler = new StaticProvidableCompositionLocal(CompositionLocalsKt$LocalDensity$1.INSTANCE$27);
    public static final StaticProvidableCompositionLocal LocalViewConfiguration = new StaticProvidableCompositionLocal(CompositionLocalsKt$LocalDensity$1.INSTANCE$28);
    public static final StaticProvidableCompositionLocal LocalWindowInfo = new StaticProvidableCompositionLocal(CompositionLocalsKt$LocalDensity$1.INSTANCE$29);
    public static final StaticProvidableCompositionLocal LocalPointerIconService = new StaticProvidableCompositionLocal(CompositionLocalsKt$LocalDensity$1.INSTANCE$21);
    public static final DynamicProvidableCompositionLocal LocalProvidableScrollCaptureInProgress = new DynamicProvidableCompositionLocal(CompositionLocalsKt$LocalDensity$1.INSTANCE$23);
    public static final StaticProvidableCompositionLocal LocalCursorBlinkEnabled = new StaticProvidableCompositionLocal(CompositionLocalsKt$LocalDensity$1.INSTANCE$13);

    public static final void ProvideCommonCompositionLocals(Owner owner, AndroidUriHandler androidUriHandler, Function2 function2, GapComposer gapComposer, int i) {
        gapComposer.startRestartGroup(1925803616);
        int i2 = i | (gapComposer.changed(owner) ? 4 : 2) | (gapComposer.changed(androidUriHandler) ? 32 : 16) | (gapComposer.changedInstance(function2) ? 256 : 128);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            AndroidComposeView androidComposeView = (AndroidComposeView) owner;
            ProvidedValue providedValueDefaultProvidedValue$runtime = LocalAccessibilityManager.defaultProvidedValue$runtime(androidComposeView.getAccessibilityManager());
            ProvidedValue providedValueDefaultProvidedValue$runtime2 = LocalAutofill.defaultProvidedValue$runtime(androidComposeView.getAutofill());
            ProvidedValue providedValueDefaultProvidedValue$runtime3 = LocalAutofillManager.defaultProvidedValue$runtime(androidComposeView.getAutofillManager());
            ProvidedValue providedValueDefaultProvidedValue$runtime4 = LocalAutofillTree.defaultProvidedValue$runtime(androidComposeView.getAutofillTree());
            ProvidedValue providedValueDefaultProvidedValue$runtime5 = LocalClipboardManager.defaultProvidedValue$runtime(androidComposeView.m598getClipboardManager());
            ProvidedValue providedValueDefaultProvidedValue$runtime6 = LocalClipboard.defaultProvidedValue$runtime(androidComposeView.m597getClipboard());
            ProvidedValue providedValueDefaultProvidedValue$runtime7 = LocalDensity.defaultProvidedValue$runtime(androidComposeView.getDensity());
            ProvidedValue providedValueDefaultProvidedValue$runtime8 = LocalFocusManager.defaultProvidedValue$runtime(androidComposeView.getFocusOwner());
            ProvidedValue providedValueDefaultProvidedValue$runtime9 = LocalFontLoader.defaultProvidedValue$runtime(androidComposeView.getFontLoader());
            providedValueDefaultProvidedValue$runtime9.canOverride = false;
            ProvidedValue providedValueDefaultProvidedValue$runtime10 = LocalFontFamilyResolver.defaultProvidedValue$runtime(androidComposeView.getFontFamilyResolver());
            providedValueDefaultProvidedValue$runtime10.canOverride = false;
            Stack.CompositionLocalProvider(new ProvidedValue[]{providedValueDefaultProvidedValue$runtime, providedValueDefaultProvidedValue$runtime2, providedValueDefaultProvidedValue$runtime3, providedValueDefaultProvidedValue$runtime4, providedValueDefaultProvidedValue$runtime5, providedValueDefaultProvidedValue$runtime6, providedValueDefaultProvidedValue$runtime7, providedValueDefaultProvidedValue$runtime8, providedValueDefaultProvidedValue$runtime9, providedValueDefaultProvidedValue$runtime10, LocalHapticFeedback.defaultProvidedValue$runtime(androidComposeView.getHapticFeedBack()), LocalInputModeManager.defaultProvidedValue$runtime(androidComposeView.getInputModeManager()), LocalLayoutDirection.defaultProvidedValue$runtime(androidComposeView.getLayoutDirection()), LocalTextInputService.defaultProvidedValue$runtime(androidComposeView.getTextInputService()), LocalSoftwareKeyboardController.defaultProvidedValue$runtime(androidComposeView.getSoftwareKeyboardController()), LocalTextToolbar.defaultProvidedValue$runtime(androidComposeView.getTextToolbar()), LocalUriHandler.defaultProvidedValue$runtime(androidUriHandler), LocalViewConfiguration.defaultProvidedValue$runtime(androidComposeView.getViewConfiguration()), LocalWindowInfo.defaultProvidedValue$runtime(androidComposeView.getWindowInfo()), LocalPointerIconService.defaultProvidedValue$runtime(androidComposeView.getPointerIconService()), LocalGraphicsContext.defaultProvidedValue$runtime(androidComposeView.getGraphicsContext()), LocalRetainedValuesStoreKt.LocalRetainedValuesStore.defaultProvidedValue$runtime(androidComposeView.getRetainedValuesStore()), LocalProvidableLocaleList.defaultProvidedValue$runtime(androidComposeView.getLocaleList())}, function2, gapComposer, ((i2 >> 3) & 112) | 8);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new NavHostKt$NavHost$29$1.AnonymousClass1(owner, androidUriHandler, function2, i, 1);
        }
    }

    public static final void access$noLocalProvidedFor(String str) {
        throw new IllegalStateException(("CompositionLocal " + str + " not present").toString());
    }
}
