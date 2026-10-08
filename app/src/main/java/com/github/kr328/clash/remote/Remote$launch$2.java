package com.github.kr328.clash.remote;

import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import coil.disk.DiskLruCache;
import coil.disk.DiskLruCache$$ExternalSyntheticLambda0;
import coil.memory.MemoryCacheService;
import coil.request.Parameters;
import com.github.kr328.clash.ApkBrokenActivity;
import com.github.kr328.clash.common.Global;
import com.github.kr328.clash.common.util.ComponentsKt;
import com.github.kr328.clash.service.data.migrations.MigrationsKt;
import com.github.kr328.clash.service.data.migrations.MigrationsKt$LEGACY_MIGRATION$1;
import com.github.kr328.clash.store.AppStore;
import com.github.kr328.clash.util.ApplicationObserver;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptySet;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FileTreeWalk;
import kotlin.io.LinesSequence;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.sequences.EmptySequence;
import kotlin.sequences.FilteringSequence;
import kotlin.sequences.GeneratorSequence;
import kotlin.sequences.SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt$flatMap$2;
import kotlin.text.Regex;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Remote$launch$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Remote$launch$2(int i, Continuation continuation, int i2) {
        super(i, continuation);
        this.$r8$classId = i2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new Remote$launch$2(2, continuation, 0);
            case 1:
                return new Remote$launch$2(2, continuation, 1);
            default:
                Remote$launch$2 remote$launch$2 = new Remote$launch$2(2, continuation, 2);
                remote$launch$2.label = ((Number) obj).intValue();
                return remote$launch$2;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                return ((Remote$launch$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 1:
                return ((Remote$launch$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            default:
                return ((Remote$launch$2) create(Integer.valueOf(((Number) obj).intValue()), (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z;
        Unit unit;
        Iterable iterableSingleton;
        int i = this.$r8$classId;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        switch (i) {
            case 0:
                int i2 = this.label;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    DiskLruCache.Editor editor = Remote.broadcasts;
                    this.label = 1;
                    Global.INSTANCE.getClass();
                    Application application$1 = Global.getApplication$1();
                    AppStore appStore = new AppStore(application$1);
                    long j = application$1.getPackageManager().getPackageInfo(application$1.getPackageName(), 0).lastUpdateTime;
                    KProperty kProperty = AppStore.$$delegatedProperties[0];
                    Parameters.Builder builder = appStore.updatedAt$delegate;
                    if (Long.valueOf(((SharedPreferences) ((MemoryCacheService) ((Parameters.Builder) builder.entries).entries).imageLoader).getLong("updated_at", -1L)).longValue() != j) {
                        try {
                            ApplicationInfo applicationInfo = application$1.getApplicationInfo();
                            String[] strArr = applicationInfo.splitSourceDirs;
                            if (strArr == null) {
                                strArr = new String[]{applicationInfo.sourceDir};
                            }
                            Regex regex = new Regex("lib/(\\S+)/libclash.so");
                            Set set = ArraysKt.toSet(Build.SUPPORTED_ABIS);
                            int i3 = 13;
                            FilteringSequence filteringSequenceFilter = SequencesKt.filter(strArr.length == 0 ? EmptySequence.INSTANCE : new LinesSequence(1, strArr), new Remote$$ExternalSyntheticLambda1(i3));
                            Remote$$ExternalSyntheticLambda1 remote$$ExternalSyntheticLambda1 = new Remote$$ExternalSyntheticLambda1(14);
                            int i4 = SequencesKt___SequencesKt$flatMap$2.$r8$clinit;
                            GeneratorSequence generatorSequence = new GeneratorSequence(new GeneratorSequence(filteringSequenceFilter, (Function1) remote$$ExternalSyntheticLambda1), new DiskLruCache$$ExternalSyntheticLambda0(i3, regex), 3);
                            int i5 = 20;
                            FileTreeWalk.FileTreeWalkIterator fileTreeWalkIterator = new FileTreeWalk.FileTreeWalkIterator(new FilteringSequence(new GeneratorSequence(new FilteringSequence(generatorSequence, false, new Remote$$ExternalSyntheticLambda1(i5)), new Remote$$ExternalSyntheticLambda1(15), 3), false, new Remote$$ExternalSyntheticLambda1(i5)));
                            if (fileTreeWalkIterator.hasNext()) {
                                Object next = fileTreeWalkIterator.next();
                                if (fileTreeWalkIterator.hasNext()) {
                                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                                    linkedHashSet.add(next);
                                    while (fileTreeWalkIterator.hasNext()) {
                                        linkedHashSet.add(fileTreeWalkIterator.next());
                                    }
                                    iterableSingleton = linkedHashSet;
                                } else {
                                    iterableSingleton = Collections.singleton(next);
                                }
                            } else {
                                iterableSingleton = EmptySet.INSTANCE;
                            }
                            Iterable iterable = iterableSingleton;
                            Set mutableSet = CollectionsKt.toMutableSet(set);
                            mutableSet.retainAll(iterable instanceof Collection ? (Collection) iterable : CollectionsKt.toList(iterable));
                            z = !mutableSet.isEmpty();
                        } catch (Exception unused) {
                            z = false;
                        }
                        if (z) {
                            KProperty kProperty2 = AppStore.$$delegatedProperties[0];
                            long jLongValue = Long.valueOf(j).longValue();
                            SharedPreferences.Editor editorEdit = ((SharedPreferences) ((MemoryCacheService) ((Parameters.Builder) builder.entries).entries).imageLoader).edit();
                            editorEdit.putLong("updated_at", jLongValue);
                            editorEdit.apply();
                            unit = Unit.INSTANCE;
                        } else {
                            Iterator it = ApplicationObserver._createdActivities.iterator();
                            while (it.hasNext()) {
                                ((Activity) it.next()).finish();
                            }
                            application$1.startActivity(ComponentsKt.getIntent(Reflection.getOrCreateKotlinClass(ApkBrokenActivity.class)).addFlags(268435456));
                            unit = Unit.INSTANCE;
                        }
                    } else {
                        unit = Unit.INSTANCE;
                    }
                    if (unit == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            case 1:
                int i6 = this.label;
                if (i6 == 0) {
                    ResultKt.throwOnFailure(obj);
                    MigrationsKt$LEGACY_MIGRATION$1 migrationsKt$LEGACY_MIGRATION$1 = MigrationsKt.LEGACY_MIGRATION;
                    Global.INSTANCE.getClass();
                    Application application$2 = Global.getApplication$1();
                    this.label = 1;
                    if (migrationsKt$LEGACY_MIGRATION$1.invoke(application$2, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                } else {
                    if (i6 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            default:
                ResultKt.throwOnFailure(obj);
                return Boolean.valueOf(this.label > 0);
        }
    }
}
