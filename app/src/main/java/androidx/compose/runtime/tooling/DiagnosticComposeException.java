package androidx.compose.runtime.tooling;

import androidx.appcompat.widget.AppCompatHintHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.ReversedListReadOnly;
import kotlin.collections.builders.ListBuilder;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.connection.Exchange;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DiagnosticComposeException extends RuntimeException {
    public final ComposeStackTrace trace;

    public DiagnosticComposeException(ComposeStackTrace composeStackTrace) {
        this.trace = composeStackTrace;
        if (composeStackTrace.hasSourceInformation) {
            return;
        }
        int[] iArr = {201, 202, 204, 206, 207, 125, -127, 126665345, 200};
        List list = composeStackTrace.frames;
        int size = list.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            ComposeStackTraceFrame composeStackTraceFrame = (ComposeStackTraceFrame) list.get(i);
            if (!ArraysKt.contains(iArr, composeStackTraceFrame.groupKey)) {
                if (composeStackTraceFrame.groupKey == 100) {
                    int i3 = i + 2;
                    if (i3 < size && ((ComposeStackTraceFrame) list.get(i3)).groupKey == 1000) {
                        break;
                    } else if (!arrayList.isEmpty()) {
                        arrayList.remove(AppCompatHintHelper.getLastIndex(arrayList));
                    }
                } else {
                    arrayList.add(composeStackTraceFrame);
                }
            }
            i = i2;
        }
        int size2 = arrayList.size();
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[size2];
        for (int i4 = 0; i4 < size2; i4++) {
            stackTraceElementArr[i4] = new StackTraceElement("$$compose", "m$" + ((ComposeStackTraceFrame) arrayList.get(i4)).groupKey, "SourceFile", 1);
        }
        setStackTrace(stackTraceElementArr);
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    /* JADX WARN: Type inference failed for: r14v2, types: [java.lang.Object, java.util.List] */
    @Override // java.lang.Throwable
    public final String getMessage() {
        ComposeStackTrace composeStackTrace = this.trace;
        if (!composeStackTrace.hasSourceInformation) {
            return "Composition stack when thrown:";
        }
        StringBuilder sb = new StringBuilder("Composition stack when thrown:\n");
        ListBuilder listBuilderCreateListBuilder = AppCompatHintHelper.createListBuilder();
        ReversedListReadOnly reversedListReadOnly = new ReversedListReadOnly(0, composeStackTrace.frames);
        int size = reversedListReadOnly.getSize();
        String str = null;
        String str2 = null;
        for (int i = 0; i < size; i++) {
            ComposeStackTraceFrame composeStackTraceFrame = (ComposeStackTraceFrame) reversedListReadOnly.get(i);
            Exchange exchange = composeStackTraceFrame.sourceInfo;
            Integer num = composeStackTraceFrame.groupOffset;
            if (exchange != null) {
                boolean z = exchange.hasFailure;
                String str3 = (String) exchange.call;
                if (str3 == null) {
                    String str4 = z ? "<lambda>" : null;
                    if (str4 != null) {
                        str = str4;
                    } else if (str == null) {
                        str = "<unknown function>";
                    }
                } else {
                    str = str3;
                }
                String str5 = (String) exchange.finder;
                if (str5 != null) {
                    str2 = str5;
                } else if (str2 == null) {
                    str2 = "<unknown file>";
                }
                ?? r14 = exchange.connection;
                String str6 = str + '(' + str2 + ':' + ((num == null || num.intValue() >= r14.size()) ? "<unknown line>" : String.valueOf(((LocationSourceInformation) r14.get(num.intValue())).lineNumber)) + ')';
                if (!z) {
                }
                if (!Intrinsics.areEqual(str3, "rememberCompositionContext") || !Intrinsics.areEqual((String) exchange.codec, "9igjgp")) {
                    listBuilderCreateListBuilder.add(str6);
                }
            }
        }
        ReversedListReadOnly reversedListReadOnly2 = new ReversedListReadOnly(0, AppCompatHintHelper.build(listBuilderCreateListBuilder));
        int size2 = reversedListReadOnly2.getSize();
        for (int i2 = 0; i2 < size2; i2++) {
            String str7 = (String) reversedListReadOnly2.get(i2);
            sb.append("\tat ");
            sb.append(str7);
            sb.append('\n');
        }
        return sb.toString();
    }
}
