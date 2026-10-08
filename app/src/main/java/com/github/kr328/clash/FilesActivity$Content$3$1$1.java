package com.github.kr328.clash;

import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.github.kr328.clash.core.model.Provider;
import com.github.kr328.clash.remote.FilesClient;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FilesActivity$Content$3$1$1 extends FunctionReferenceImpl implements Function1 {
    public final /* synthetic */ Object $client;
    public final /* synthetic */ MutableState $files$delegate;
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ Object $stack;
    public final /* synthetic */ Object $uuidStr;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilesActivity$Content$3$1$1(SnapshotStateList snapshotStateList, String str, FilesClient filesClient, MutableState mutableState) {
        super(1, Intrinsics.Kotlin.class, "reload", "Content$reload(Landroidx/compose/runtime/snapshots/SnapshotStateList;Ljava/lang/String;Lcom/github/kr328/clash/remote/FilesClient;Landroidx/compose/runtime/MutableState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        this.$stack = snapshotStateList;
        this.$uuidStr = str;
        this.$client = filesClient;
        this.$files$delegate = mutableState;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return FilesActivity.access$Content$reload((SnapshotStateList) this.$stack, (String) this.$uuidStr, (FilesClient) this.$client, this.$files$delegate, (Continuation) obj);
            default:
                CoroutineScope coroutineScope = (CoroutineScope) this.$stack;
                SnackbarHostState snackbarHostState = (SnackbarHostState) this.$uuidStr;
                ProvidersActivity providersActivity = (ProvidersActivity) this.$client;
                ProvidersActivity.AnonymousClass1.invoke$updateOne(coroutineScope, this.$files$delegate, snackbarHostState, providersActivity, (Provider) obj);
                return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilesActivity$Content$3$1$1(CoroutineScope coroutineScope, MutableState mutableState, SnackbarHostState snackbarHostState, ProvidersActivity providersActivity) {
        super(1, Intrinsics.Kotlin.class, "updateOne", "invoke$updateOne(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/MutableState;Landroidx/compose/material3/SnackbarHostState;Lcom/github/kr328/clash/ProvidersActivity;Lcom/github/kr328/clash/core/model/Provider;)V", 0);
        this.$stack = coroutineScope;
        this.$files$delegate = mutableState;
        this.$uuidStr = snackbarHostState;
        this.$client = providersActivity;
    }
}
