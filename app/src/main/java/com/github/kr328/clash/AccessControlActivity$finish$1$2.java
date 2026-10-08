package com.github.kr328.clash;

import android.content.pm.PackageManager;
import androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda1;
import coil.compose.AsyncImagePainter$$ExternalSyntheticLambda0;
import coil.disk.DiskLruCache$$ExternalSyntheticLambda0;
import com.github.kr328.clash.design.model.AppInfoSort;
import com.github.kr328.clash.service.store.ServiceStore;
import com.google.android.material.button.MaterialButtonToggleGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.LinesSequence;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.GeneratorSequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AccessControlActivity$finish$1$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ AccessControlActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AccessControlActivity$finish$1$2(AccessControlActivity accessControlActivity, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.this$0 = accessControlActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new AccessControlActivity$finish$1$2(this.this$0, continuation, 0);
            case 1:
                return new AccessControlActivity$finish$1$2(this.this$0, continuation, 1);
            default:
                return new AccessControlActivity$finish$1$2(this.this$0, continuation, 2);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (this.$r8$classId) {
            case 0:
                break;
            case 1:
                break;
        }
        return ((AccessControlActivity$finish$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Comparator comparator;
        switch (this.$r8$classId) {
            case 0:
                ResultKt.throwOnFailure(obj);
                super/*android.app.Activity*/.finish();
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure(obj);
                return CollectionsKt.toMutableSet(((ServiceStore) this.this$0.srvStore$delegate.getValue()).getAccessControlPackages());
            default:
                ResultKt.throwOnFailure(obj);
                AccessControlActivity accessControlActivity = this.this$0;
                boolean zBooleanValue = ((Boolean) accessControlActivity.reverseFlow.getValue()).booleanValue();
                final AppInfoSort appInfoSort = (AppInfoSort) accessControlActivity.sortFlow.getValue();
                boolean zBooleanValue2 = ((Boolean) accessControlActivity.systemAppsFlow.getValue()).booleanValue();
                Set set = accessControlActivity.selected;
                final MaterialButtonToggleGroup.AnonymousClass1 anonymousClass1 = new MaterialButtonToggleGroup.AnonymousClass1(5, set != null ? CollectionsKt.toSet(set) : EmptySet.INSTANCE);
                if (zBooleanValue) {
                    final int i = 0;
                    comparator = new Comparator() { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda0
                        @Override // java.util.Comparator
                        public final int compare(Object obj2, Object obj3) {
                            switch (i) {
                                case 0:
                                    int iCompare = anonymousClass1.compare(obj2, obj3);
                                    return iCompare != 0 ? iCompare : appInfoSort.compare(obj3, obj2);
                                default:
                                    int iCompare2 = anonymousClass1.compare(obj2, obj3);
                                    return iCompare2 != 0 ? iCompare2 : appInfoSort.compare(obj2, obj3);
                            }
                        }
                    };
                } else {
                    final int i2 = 1;
                    comparator = new Comparator() { // from class: kotlin.comparisons.ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda0
                        @Override // java.util.Comparator
                        public final int compare(Object obj2, Object obj3) {
                            switch (i2) {
                                case 0:
                                    int iCompare = anonymousClass1.compare(obj2, obj3);
                                    return iCompare != 0 ? iCompare : appInfoSort.compare(obj3, obj2);
                                default:
                                    int iCompare2 = anonymousClass1.compare(obj2, obj3);
                                    return iCompare2 != 0 ? iCompare2 : appInfoSort.compare(obj2, obj3);
                            }
                        }
                    };
                }
                PackageManager packageManager = accessControlActivity.getPackageManager();
                int i3 = 4;
                ArrayList mutableList = SequencesKt.toMutableList(new GeneratorSequence(SequencesKt.filter(SequencesKt.filter(SequencesKt.filter(SequencesKt.filter(new LinesSequence(2, packageManager.getInstalledPackages(4096)), new AccessControlActivity$onCreate$2$1$$ExternalSyntheticLambda0(accessControlActivity, i3)), new AsyncImagePainter$$ExternalSyntheticLambda0(i3)), new AsyncImagePainter$$ExternalSyntheticLambda0(5)), new BackHandlerKt$$ExternalSyntheticLambda1(2, accessControlActivity, zBooleanValue2)), new DiskLruCache$$ExternalSyntheticLambda0(5, packageManager), 3));
                CollectionsKt__MutableCollectionsJVMKt.sortWith(mutableList, comparator);
                Iterator it = mutableList.iterator();
                if (!it.hasNext()) {
                    return EmptyList.INSTANCE;
                }
                Object next = it.next();
                if (!it.hasNext()) {
                    return Collections.singletonList(next);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(next);
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
                return arrayList;
        }
    }
}
