package androidx.compose.foundation.text.selection;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.textclassifier.TextClassification;
import androidx.activity.ImmLeaksCleaner$$ExternalSyntheticLambda0;
import androidx.compose.foundation.text.contextmenu.ProcessTextApi23Impl;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuTextClassificationItem;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.ui.autofill.AndroidAutofill$$ExternalSyntheticApiModelOutline0;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.intl.LocaleList;
import java.util.List;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class PlatformSelectionBehaviors_androidKt {
    public static final StaticProvidableCompositionLocal LocalTextClassifierCoroutineContext = new StaticProvidableCompositionLocal(new ImmLeaksCleaner$$ExternalSyntheticLambda0(15));
    public static final PlatformSelectionBehaviors_androidKt$$ExternalSyntheticLambda1 PlatformSelectionBehaviorsFactory = new PlatformSelectionBehaviors_androidKt$$ExternalSyntheticLambda1();

    /* JADX INFO: renamed from: addPlatformTextContextMenuItems-71BSaZU, reason: not valid java name */
    public static final void m217addPlatformTextContextMenuItems71BSaZU(TextContextMenuBuilderScope textContextMenuBuilderScope, Context context, boolean z, CharSequence charSequence, TextRange textRange, PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl, Function1 function1) {
        if (Build.VERSION.SDK_INT < 28 || charSequence == null || textRange == null || platformSelectionBehaviorsImpl == null || !(platformSelectionBehaviorsImpl instanceof PlatformSelectionBehaviorsImpl)) {
            function1.invoke(textContextMenuBuilderScope);
            if (charSequence == null || textRange == null) {
                return;
            }
            ProcessTextApi23Impl.m182addProcessedTextContextMenuItemsUAq72N0(textContextMenuBuilderScope, context, z, charSequence, textRange.packedValue);
            return;
        }
        long j = textRange.packedValue;
        Object obj = platformSelectionBehaviorsImpl.AssistantItemKey;
        MutexImpl mutexImpl = platformSelectionBehaviorsImpl.mutex;
        TextClassification textClassification = null;
        if (mutexImpl.tryLock()) {
            TextClassificationResult textClassificationResult = (TextClassificationResult) platformSelectionBehaviorsImpl.textClassificationResult$delegate.getValue();
            TextClassification textClassification2 = (textClassificationResult != null && TextRange.m640equalsimpl0(j, textClassificationResult.selection) && Intrinsics.areEqual(charSequence, textClassificationResult.text)) ? textClassificationResult.textClassification : null;
            mutexImpl.unlock(null);
            textClassification = textClassification2;
        }
        if (textClassification == null) {
            function1.invoke(textContextMenuBuilderScope);
        } else {
            if (!textClassification.getActions().isEmpty()) {
                textContextMenuBuilderScope.components.add(new TextContextMenuTextClassificationItem(obj, textClassification, 0));
            } else if ((textClassification.getIcon() != null || !TextUtils.isEmpty(textClassification.getLabel())) && (textClassification.getIntent() != null || textClassification.getOnClickListener() != null)) {
                textContextMenuBuilderScope.components.add(new TextContextMenuTextClassificationItem(obj, textClassification, -1));
            }
            function1.invoke(textContextMenuBuilderScope);
            List actions = textClassification.getActions();
            int size = actions.size();
            for (int i = 0; i < size; i++) {
                AndroidAutofill$$ExternalSyntheticApiModelOutline0.m334m(actions.get(i));
                if (i > 0) {
                    textContextMenuBuilderScope.components.add(new TextContextMenuTextClassificationItem(obj, textClassification, i));
                }
            }
        }
        ProcessTextApi23Impl.m182addProcessedTextContextMenuItemsUAq72N0(textContextMenuBuilderScope, context, z, charSequence, textRange.packedValue);
    }

    public static final PlatformSelectionBehaviorsImpl rememberPlatformSelectionBehaviors(SelectedTextType selectedTextType, LocaleList localeList, GapComposer gapComposer, int i) {
        gapComposer.startReplaceGroup(430530635);
        if (Build.VERSION.SDK_INT < 28) {
            gapComposer.end(false);
            return null;
        }
        Context context = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
        CoroutineContext coroutineContext = (CoroutineContext) gapComposer.consume(LocalTextClassifierCoroutineContext);
        boolean zChanged = ((((i & 112) ^ 48) > 32 && gapComposer.changed(localeList)) || (i & 48) == 32) | gapComposer.changed(coroutineContext) | gapComposer.changed(context);
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue == Composer$Companion.Empty) {
            PlatformSelectionBehaviorsFactory.getClass();
            objRememberedValue = new PlatformSelectionBehaviorsImpl(coroutineContext, context, selectedTextType, localeList);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl = (PlatformSelectionBehaviorsImpl) objRememberedValue;
        gapComposer.end(false);
        return platformSelectionBehaviorsImpl;
    }
}
