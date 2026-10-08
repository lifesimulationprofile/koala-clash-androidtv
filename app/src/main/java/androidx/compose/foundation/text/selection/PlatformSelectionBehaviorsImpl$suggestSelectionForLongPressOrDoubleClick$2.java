package androidx.compose.foundation.text.selection;

import android.os.Build;
import android.view.textclassifier.TextClassifier;
import android.view.textclassifier.TextSelection;
import androidx.compose.ui.autofill.AndroidAutofill$$ExternalSyntheticApiModelOutline0;
import androidx.compose.ui.text.ParagraphKt;
import androidx.compose.ui.text.TextRange;
import androidx.core.text.PrecomputedTextCompat$Params$$ExternalSyntheticApiModelOutline2;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ long $selection;
    public final /* synthetic */ CharSequence $text;
    public long J$0;
    public /* synthetic */ Object L$0;
    public MutexImpl L$1;
    public PlatformSelectionBehaviorsImpl L$2;
    public CharSequence L$3;
    public int label;
    public final /* synthetic */ PlatformSelectionBehaviorsImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2(long j, PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl, CharSequence charSequence, Continuation continuation) {
        super(2, continuation);
        this.$text = charSequence;
        this.$selection = j;
        this.this$0 = platformSelectionBehaviorsImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2 platformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2 = new PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2(this.$selection, this.this$0, this.$text, continuation);
        platformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2.L$0 = obj;
        return platformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((PlatformSelectionBehaviorsImpl$suggestSelectionForLongPressOrDoubleClick$2) create(AndroidAutofill$$ExternalSyntheticApiModelOutline0.m328m(obj), (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        PlatformSelectionBehaviorsImpl platformSelectionBehaviorsImpl;
        long j;
        MutexImpl mutexImpl;
        TextSelection textSelectionM329m;
        CharSequence charSequence;
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TextClassifier textClassifierM328m = AndroidAutofill$$ExternalSyntheticApiModelOutline0.m328m(this.L$0);
            PrecomputedTextCompat$Params$$ExternalSyntheticApiModelOutline2.m$1();
            long j2 = this.$selection;
            int iM644getMinimpl = TextRange.m644getMinimpl(j2);
            int iM643getMaximpl = TextRange.m643getMaximpl(j2);
            CharSequence charSequence2 = this.$text;
            TextSelection.Request.Builder builderM752m = PrecomputedTextCompat$Params$$ExternalSyntheticApiModelOutline2.m752m(charSequence2, iM644getMinimpl, iM643getMaximpl);
            platformSelectionBehaviorsImpl = this.this$0;
            TextSelection.Request.Builder defaultLocales = builderM752m.setDefaultLocales(platformSelectionBehaviorsImpl.getAndroidLocalList());
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 31) {
                defaultLocales.setIncludeTextClassification(true);
            }
            TextSelection textSelectionSuggestSelection = textClassifierM328m.suggestSelection(defaultLocales.build());
            long jTextRange = ParagraphKt.TextRange(textSelectionSuggestSelection.getSelectionStartIndex(), textSelectionSuggestSelection.getSelectionEndIndex());
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            if (i2 < 31 || textSelectionSuggestSelection.getTextClassification() == null) {
                this.J$0 = jTextRange;
                this.label = 2;
                if (PlatformSelectionBehaviorsImpl.m215access$classifyTextM8tDOmk(platformSelectionBehaviorsImpl, this.$text, jTextRange, textClassifierM328m, this) != coroutineSingletons) {
                    j = jTextRange;
                }
            } else {
                mutexImpl = platformSelectionBehaviorsImpl.mutex;
                this.L$0 = textSelectionSuggestSelection;
                this.L$1 = mutexImpl;
                this.L$2 = platformSelectionBehaviorsImpl;
                this.L$3 = charSequence2;
                this.J$0 = jTextRange;
                this.label = 1;
                if (mutexImpl.lock(this) != coroutineSingletons) {
                    textSelectionM329m = textSelectionSuggestSelection;
                    charSequence = charSequence2;
                    j = jTextRange;
                    platformSelectionBehaviorsImpl.textClassificationResult$delegate.setValue(new TextClassificationResult(charSequence, j, textSelectionM329m.getTextClassification()));
                    Unit unit = Unit.INSTANCE;
                }
            }
            return coroutineSingletons;
        }
        if (i == 1) {
            j = this.J$0;
            charSequence = this.L$3;
            platformSelectionBehaviorsImpl = this.L$2;
            mutexImpl = this.L$1;
            textSelectionM329m = AndroidAutofill$$ExternalSyntheticApiModelOutline0.m329m(this.L$0);
            ResultKt.throwOnFailure(obj);
            try {
                platformSelectionBehaviorsImpl.textClassificationResult$delegate.setValue(new TextClassificationResult(charSequence, j, textSelectionM329m.getTextClassification()));
                Unit unit2 = Unit.INSTANCE;
            } finally {
                mutexImpl.unlock(null);
            }
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j = this.J$0;
            ResultKt.throwOnFailure(obj);
        }
        return new TextRange(j);
    }
}
