package androidx.compose.foundation.text.selection;

import android.content.Context;
import android.view.textclassifier.TextClassification;
import android.view.textclassifier.TextClassifier;
import androidx.compose.foundation.gestures.ScrollableKt$semanticsScrollBy$2;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.ui.autofill.AndroidAutofill$$ExternalSyntheticApiModelOutline0;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.intl.PlatformLocaleKt;
import androidx.core.os.LocaleListPlatformWrapper$$ExternalSyntheticApiModelOutline0;
import androidx.core.text.PrecomputedTextCompat$Params$$ExternalSyntheticApiModelOutline2;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class PlatformSelectionBehaviorsImpl {
    public final Context context;
    public final CoroutineContext coroutineContext;
    public final LocaleList localeList;
    public final SelectedTextType selectedTextType;
    public TextClassifier textClassificationSession;
    public final MutexImpl mutex = new MutexImpl();
    public final ParcelableSnapshotMutableState textClassificationResult$delegate = Stack.mutableStateOf$default(null);
    public final Object AssistantItemKey = new Object();

    public PlatformSelectionBehaviorsImpl(CoroutineContext coroutineContext, Context context, SelectedTextType selectedTextType, LocaleList localeList) {
        this.coroutineContext = coroutineContext;
        this.context = context;
        this.selectedTextType = selectedTextType;
        this.localeList = localeList;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    /* JADX INFO: renamed from: access$classifyText-M8tDOmk, reason: not valid java name */
    public static final Object m215access$classifyTextM8tDOmk(PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl, CharSequence charSequence, long j, TextClassifier textClassifier, ContinuationImpl continuationImpl) {
        PlatformSelectionBehaviorsImpl$classifyText$1 platformSelectionBehaviorsImpl$classifyText$1;
        long j2;
        CharSequence charSequence2;
        TextClassifier textClassifierM328m;
        MutexImpl mutexImpl;
        TextClassification textClassificationClassifyText;
        long j3;
        CharSequence charSequence3;
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = platformSelectionBehaviorsImpl.textClassificationResult$delegate;
        MutexImpl mutexImpl2 = platformSelectionBehaviorsImpl.mutex;
        if (continuationImpl instanceof PlatformSelectionBehaviorsImpl$classifyText$1) {
            platformSelectionBehaviorsImpl$classifyText$1 = (PlatformSelectionBehaviorsImpl$classifyText$1) continuationImpl;
            int i = platformSelectionBehaviorsImpl$classifyText$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                platformSelectionBehaviorsImpl$classifyText$1.label = i - Integer.MIN_VALUE;
            } else {
                platformSelectionBehaviorsImpl$classifyText$1 = new PlatformSelectionBehaviorsImpl$classifyText$1(platformSelectionBehaviorsImpl, continuationImpl);
            }
        } else {
            platformSelectionBehaviorsImpl$classifyText$1 = new PlatformSelectionBehaviorsImpl$classifyText$1(platformSelectionBehaviorsImpl, continuationImpl);
        }
        Object obj = platformSelectionBehaviorsImpl$classifyText$1.result;
        int i2 = platformSelectionBehaviorsImpl$classifyText$1.label;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                platformSelectionBehaviorsImpl$classifyText$1.L$0 = charSequence;
                platformSelectionBehaviorsImpl$classifyText$1.L$1 = textClassifier;
                platformSelectionBehaviorsImpl$classifyText$1.L$2 = mutexImpl2;
                j2 = j;
                platformSelectionBehaviorsImpl$classifyText$1.J$0 = j2;
                platformSelectionBehaviorsImpl$classifyText$1.label = 1;
                if (mutexImpl2.lock(platformSelectionBehaviorsImpl$classifyText$1) != coroutineSingletons) {
                    charSequence2 = charSequence;
                    textClassifierM328m = textClassifier;
                    mutexImpl = mutexImpl2;
                }
                return coroutineSingletons;
            }
            if (i2 == 1) {
                j2 = platformSelectionBehaviorsImpl$classifyText$1.J$0;
                mutexImpl = platformSelectionBehaviorsImpl$classifyText$1.L$2;
                textClassifierM328m = AndroidAutofill$$ExternalSyntheticApiModelOutline0.m328m(platformSelectionBehaviorsImpl$classifyText$1.L$1);
                charSequence2 = platformSelectionBehaviorsImpl$classifyText$1.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j3 = platformSelectionBehaviorsImpl$classifyText$1.J$0;
                mutexImpl2 = platformSelectionBehaviorsImpl$classifyText$1.L$2;
                textClassificationClassifyText = AndroidAutofill$$ExternalSyntheticApiModelOutline0.m326m(platformSelectionBehaviorsImpl$classifyText$1.L$1);
                charSequence3 = platformSelectionBehaviorsImpl$classifyText$1.L$0;
                ResultKt.throwOnFailure(obj);
            }
            try {
                parcelableSnapshotMutableState.setValue(new TextClassificationResult(charSequence3, j3, textClassificationClassifyText));
                Unit unit = Unit.INSTANCE;
                return Unit.INSTANCE;
            } finally {
                mutexImpl2.unlock(null);
            }
            TextClassificationResult textClassificationResult = (TextClassificationResult) parcelableSnapshotMutableState.getValue();
            if (textClassificationResult != null) {
                StaticProvidableCompositionLocal staticProvidableCompositionLocal = PlatformSelectionBehaviors_androidKt.LocalTextClassifierCoroutineContext;
                if (TextRange.m640equalsimpl0(j2, textClassificationResult.selection) && Intrinsics.areEqual(charSequence2, textClassificationResult.text)) {
                    Unit unit2 = Unit.INSTANCE;
                    mutexImpl.unlock(null);
                    return unit2;
                }
            }
            Unit unit3 = Unit.INSTANCE;
            mutexImpl.unlock(null);
            PrecomputedTextCompat$Params$$ExternalSyntheticApiModelOutline2.m();
            textClassificationClassifyText = textClassifierM328m.classifyText(PrecomputedTextCompat$Params$$ExternalSyntheticApiModelOutline2.m(charSequence2, TextRange.m644getMinimpl(j2), TextRange.m643getMaximpl(j2)).setDefaultLocales(platformSelectionBehaviorsImpl.getAndroidLocalList()).build());
            platformSelectionBehaviorsImpl$classifyText$1.L$0 = charSequence2;
            platformSelectionBehaviorsImpl$classifyText$1.L$1 = textClassificationClassifyText;
            platformSelectionBehaviorsImpl$classifyText$1.L$2 = mutexImpl2;
            platformSelectionBehaviorsImpl$classifyText$1.J$0 = j2;
            platformSelectionBehaviorsImpl$classifyText$1.label = 2;
            if (mutexImpl2.lock(platformSelectionBehaviorsImpl$classifyText$1) != coroutineSingletons) {
                j3 = j2;
                charSequence3 = charSequence2;
                parcelableSnapshotMutableState.setValue(new TextClassificationResult(charSequence3, j3, textClassificationClassifyText));
                Unit unit4 = Unit.INSTANCE;
                return Unit.INSTANCE;
            }
            return coroutineSingletons;
        } catch (Throwable th) {
            mutexImpl.unlock(null);
            throw th;
        }
    }

    public final android.os.LocaleList getAndroidLocalList() {
        LocaleList localeList = this.localeList;
        if (localeList == null) {
            LocaleListPlatformWrapper$$ExternalSyntheticApiModelOutline0.m747m();
            return LocaleListPlatformWrapper$$ExternalSyntheticApiModelOutline0.m(new Locale[]{PlatformLocaleKt.platformLocaleDelegate.getCurrent().get().platformLocale});
        }
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(localeList, 10));
        Iterator it = localeList.localeList.iterator();
        while (it.hasNext()) {
            arrayList.add(((androidx.compose.ui.text.intl.Locale) it.next()).platformLocale);
        }
        Locale[] localeArr = (Locale[]) arrayList.toArray(new Locale[0]);
        return LocaleListPlatformWrapper$$ExternalSyntheticApiModelOutline0.m((Locale[]) Arrays.copyOf(localeArr, localeArr.length));
    }

    /* JADX INFO: renamed from: onShowContextMenuOrSelectionToolbar-Sb-Bc2M, reason: not valid java name */
    public final Object m216onShowContextMenuOrSelectionToolbarSbBc2M(CharSequence charSequence, long j, SuspendLambda suspendLambda) {
        if (charSequence.length() == 0 || TextRange.m641getCollapsedimpl(j)) {
            return Unit.INSTANCE;
        }
        return JobKt.withContext(this.coroutineContext, new NavHostKt$NavHost$29$1(this, new ScrollableKt$semanticsScrollBy$2(j, this, charSequence, null), (Continuation) null), suspendLambda);
    }
}
