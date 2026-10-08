package androidx.compose.ui.platform;

import android.view.accessibility.AccessibilityEvent;
import androidx.compose.ui.node.OwnerSnapshotObserver;
import androidx.navigation.compose.DialogHostKt$DialogHost$1$1$1;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidComposeViewAccessibilityDelegateCompat$onSendAccessibilityEvent$1 extends Lambda implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ AndroidComposeViewAccessibilityDelegateCompat this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AndroidComposeViewAccessibilityDelegateCompat$onSendAccessibilityEvent$1(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, int i) {
        super(1);
        this.$r8$classId = i;
        this.this$0 = androidComposeViewAccessibilityDelegateCompat;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = this.this$0;
                return Boolean.valueOf(androidComposeViewAccessibilityDelegateCompat.view.getParent().requestSendAccessibilityEvent(androidComposeViewAccessibilityDelegateCompat.view, (AccessibilityEvent) obj));
            default:
                ScrollObservationScope scrollObservationScope = (ScrollObservationScope) obj;
                if (scrollObservationScope.allScopes.contains(scrollObservationScope)) {
                    AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat2 = this.this$0;
                    OwnerSnapshotObserver snapshotObserver = androidComposeViewAccessibilityDelegateCompat2.view.getSnapshotObserver();
                    snapshotObserver.observer.observeReads(scrollObservationScope, androidComposeViewAccessibilityDelegateCompat2.scheduleScrollEventIfNeededLambda, new DialogHostKt$DialogHost$1$1$1(7, scrollObservationScope, androidComposeViewAccessibilityDelegateCompat2));
                }
                return Unit.INSTANCE;
        }
    }
}
