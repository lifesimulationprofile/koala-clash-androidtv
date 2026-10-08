package kotlin.io;

import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.TracingContext;
import com.github.kr328.clash.compose.MainAppKt;
import com.github.kr328.clash.compose.TvMainAppKt;
import java.io.IOException;
import kotlin.Unit;
import kotlin.coroutines.CombinedContext;
import kotlin.coroutines.ContinuationInterceptor$Key;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.internal.ThreadState;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FilesKt__UtilsKt$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ FilesKt__UtilsKt$$ExternalSyntheticLambda0(int i) {
        this.$r8$classId = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) throws IOException {
        CombinedContext combinedContext;
        switch (this.$r8$classId) {
            case 0:
                throw ((IOException) obj2);
            case 1:
                ((Integer) obj2).getClass();
                MainAppKt.MainApp(Stack.updateChangedFlags(1), (GapComposer) obj);
                return Unit.INSTANCE;
            case 2:
                ((Integer) obj2).getClass();
                TvMainAppKt.TvMainApp(Stack.updateChangedFlags(1), (GapComposer) obj);
                return Unit.INSTANCE;
            case 3:
                String str = (String) obj;
                CoroutineContext.Element element = (CoroutineContext.Element) obj2;
                if (str.length() == 0) {
                    return element.toString();
                }
                return str + ", " + element;
            case 4:
                CoroutineContext.Element element2 = (CoroutineContext.Element) obj2;
                CoroutineContext coroutineContextMinusKey = ((CoroutineContext) obj).minusKey(element2.getKey());
                EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
                if (coroutineContextMinusKey == emptyCoroutineContext) {
                    return element2;
                }
                ContinuationInterceptor$Key continuationInterceptor$Key = ContinuationInterceptor$Key.$$INSTANCE;
                CoroutineDispatcher coroutineDispatcher = (CoroutineDispatcher) coroutineContextMinusKey.get(continuationInterceptor$Key);
                if (coroutineDispatcher == null) {
                    combinedContext = new CombinedContext(coroutineContextMinusKey, element2);
                } else {
                    CoroutineContext coroutineContextMinusKey2 = coroutineContextMinusKey.minusKey(continuationInterceptor$Key);
                    if (coroutineContextMinusKey2 == emptyCoroutineContext) {
                        return new CombinedContext(element2, coroutineDispatcher);
                    }
                    combinedContext = new CombinedContext(new CombinedContext(coroutineContextMinusKey2, element2), coroutineDispatcher);
                }
                return combinedContext;
            case 5:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                return bool;
            case 6:
                return ((CoroutineContext) obj).plus((CoroutineContext.Element) obj2);
            case 7:
                return ((CoroutineContext) obj).plus((CoroutineContext.Element) obj2);
            case 8:
                return Integer.valueOf(((Integer) obj).intValue() + 1);
            case 9:
                CoroutineContext.Element element3 = (CoroutineContext.Element) obj2;
                if (!(element3 instanceof TracingContext)) {
                    return obj;
                }
                Integer num = obj instanceof Integer ? (Integer) obj : null;
                int iIntValue = num != null ? num.intValue() : 1;
                return iIntValue == 0 ? element3 : Integer.valueOf(iIntValue + 1);
            case 10:
                CoroutineContext.Element element4 = (CoroutineContext.Element) obj2;
                if (element4 instanceof TracingContext) {
                    return (TracingContext) element4;
                }
                return null;
            default:
                ThreadState threadState = (ThreadState) obj;
                CoroutineContext.Element element5 = (CoroutineContext.Element) obj2;
                if (element5 instanceof TracingContext) {
                    TracingContext tracingContext = (TracingContext) element5;
                    Object objUpdateThreadContext = tracingContext.updateThreadContext(threadState.context);
                    Object[] objArr = threadState.values;
                    int i = threadState.i;
                    objArr[i] = objUpdateThreadContext;
                    TracingContext[] tracingContextArr = threadState.elements;
                    threadState.i = i + 1;
                    tracingContextArr[i] = tracingContext;
                }
                return threadState;
        }
    }

    public /* synthetic */ FilesKt__UtilsKt$$ExternalSyntheticLambda0(int i, int i2) {
        this.$r8$classId = i2;
    }
}
