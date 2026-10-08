package com.github.kr328.clash.remote;

import android.database.Cursor;
import android.provider.DocumentsContract;
import androidx.compose.ui.semantics.SemanticsSortKt$$ExternalSyntheticLambda0;
import com.github.kr328.clash.common.constants.Authorities;
import com.github.kr328.clash.design.model.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FilesClient$list$2 extends SuspendLambda implements Function2 {
    public final /* synthetic */ String $parentDocumentId;
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ FilesClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilesClient$list$2(FilesClient filesClient, String str, Continuation continuation) {
        super(2, continuation);
        this.this$0 = filesClient;
        this.$parentDocumentId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new FilesClient$list$2(this.$parentDocumentId, this.this$0, continuation);
            default:
                return new FilesClient$list$2(this.this$0, this.$parentDocumentId, continuation);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        CoroutineScope coroutineScope = (CoroutineScope) obj;
        Continuation continuation = (Continuation) obj2;
        switch (this.$r8$classId) {
            case 0:
                break;
        }
        return ((FilesClient$list$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws IOException {
        int i = this.$r8$classId;
        String str = this.$parentDocumentId;
        FilesClient filesClient = this.this$0;
        switch (i) {
            case 0:
                ResultKt.throwOnFailure(obj);
                Cursor cursorQuery = filesClient.context.getContentResolver().query(DocumentsContract.buildChildDocumentsUri(Authorities.FILES_PROVIDER, str), FilesClient.FilesProjection, null, null, null);
                if (cursorQuery == null) {
                    return EmptyList.INSTANCE;
                }
                try {
                    int columnIndex = cursorQuery.getColumnIndex("document_id");
                    int columnIndex2 = cursorQuery.getColumnIndex("_display_name");
                    int columnIndex3 = cursorQuery.getColumnIndex("_size");
                    int columnIndex4 = cursorQuery.getColumnIndex("last_modified");
                    int columnIndex5 = cursorQuery.getColumnIndex("mime_type");
                    cursorQuery.moveToFirst();
                    int count = cursorQuery.getCount();
                    ArrayList arrayList = new ArrayList(count);
                    int i2 = 0;
                    while (i2 < count) {
                        File file = new File(cursorQuery.getString(columnIndex), cursorQuery.getString(columnIndex2), cursorQuery.getLong(columnIndex3), cursorQuery.getLong(columnIndex4), Intrinsics.areEqual(cursorQuery.getString(columnIndex5), "vnd.android.document/directory"));
                        cursorQuery.moveToNext();
                        arrayList.add(file);
                        i2++;
                        columnIndex = columnIndex;
                    }
                    List listSortedWith = CollectionsKt.sortedWith(arrayList, new SemanticsSortKt$$ExternalSyntheticLambda0(3, new Function1[]{new Remote$$ExternalSyntheticLambda1(3), new Remote$$ExternalSyntheticLambda1(4)}));
                    cursorQuery.close();
                    return listSortedWith;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(cursorQuery, th);
                        throw th2;
                    }
                }
            default:
                ResultKt.throwOnFailure(obj);
                filesClient.getClass();
                return Boolean.valueOf(DocumentsContract.deleteDocument(filesClient.context.getContentResolver(), DocumentsContract.buildDocumentUri(Authorities.FILES_PROVIDER, str)));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilesClient$list$2(String str, FilesClient filesClient, Continuation continuation) {
        super(2, continuation);
        this.$parentDocumentId = str;
        this.this$0 = filesClient;
    }
}
