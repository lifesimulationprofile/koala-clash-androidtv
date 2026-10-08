package com.github.kr328.clash.service;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsProvider;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.navigation.compose.NavHostKt$NavHost$29$1;
import coil.decode.BitmapFactoryDecoder$$ExternalSyntheticLambda2;
import coil.network.HttpException;
import com.github.kr328.clash.common.util.PatternsKt;
import com.github.kr328.clash.service.document.Document;
import com.github.kr328.clash.service.document.FileDocument;
import com.github.kr328.clash.service.document.Flag;
import com.github.kr328.clash.service.document.Path;
import com.github.kr328.clash.service.document.Paths;
import com.github.kr328.clash.service.document.Picker;
import com.koala.clash.R;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.internal.ChannelFlow;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FilesProvider extends DocumentsProvider {
    public static final String[] DEFAULT_DOCUMENT_COLUMNS = {"document_id", "_display_name", "mime_type", "last_modified", "_size", "flags"};
    public static final String[] DEFAULT_ROOT_COLUMNS = {"root_id", "flags", "icon", "title", "summary", "document_id"};
    public static final int FLAG_VIRTUAL;
    public final SynchronizedLazyImpl picker$delegate = new SynchronizedLazyImpl(new BitmapFactoryDecoder$$ExternalSyntheticLambda2(13, this));

    /* JADX INFO: renamed from: com.github.kr328.clash.service.FilesProvider$openDocument$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends SuspendLambda implements Function2 {
        public final /* synthetic */ String $documentId;
        public final /* synthetic */ int $m;
        public final /* synthetic */ String $mode;
        public int label;
        public final /* synthetic */ FilesProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, FilesProvider filesProvider, String str2, int i, Continuation continuation) {
            super(2, continuation);
            this.$documentId = str;
            this.this$0 = filesProvider;
            this.$mode = str2;
            this.$m = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.$documentId, this.this$0, this.$mode, this.$m, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws FileNotFoundException {
            int i = this.label;
            String str = this.$documentId;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Path pathResolve = Paths.resolve(str == null ? "/" : str);
                Picker picker = (Picker) this.this$0.picker$delegate.getValue();
                String str2 = this.$mode;
                boolean zContains = str2 != null ? StringsKt.contains(str2, "w", true) : true;
                this.label = 1;
                obj = picker.pick(pathResolve, zContains, this);
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Document document = (Document) obj;
            if (document instanceof FileDocument) {
                return ParcelFileDescriptor.open(((FileDocument) document).file, this.$m);
            }
            throw new FileNotFoundException(CaptureSession$State$EnumUnboxingLocalUtility.m("invalid path ", str));
        }
    }

    /* JADX INFO: renamed from: com.github.kr328.clash.service.FilesProvider$queryDocument$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class C00261 extends SuspendLambda implements Function2 {
        public final /* synthetic */ String $documentId;
        public final /* synthetic */ String[] $projection;
        public final /* synthetic */ int $r8$classId;
        public String L$0;
        public int label;
        public final /* synthetic */ FilesProvider this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ C00261(String str, FilesProvider filesProvider, String[] strArr, Continuation continuation, int i) {
            super(2, continuation);
            this.$r8$classId = i;
            this.$documentId = str;
            this.this$0 = filesProvider;
            this.$projection = strArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            switch (this.$r8$classId) {
                case 0:
                    return new C00261(this.$documentId, this.this$0, this.$projection, continuation, 0);
                default:
                    return new C00261(this.$documentId, this.this$0, this.$projection, continuation, 1);
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
            return ((C00261) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [kotlin.coroutines.intrinsics.CoroutineSingletons] */
        /* JADX WARN: Type inference failed for: r4v4, types: [android.database.MatrixCursor] */
        /* JADX WARN: Type inference failed for: r4v6, types: [android.database.MatrixCursor] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object matrixCursor;
            String str;
            String[] strArr;
            String str2;
            String[] strArr2;
            int i = this.$r8$classId;
            String str3 = this.$documentId;
            Object matrixCursor2 = CoroutineSingletons.COROUTINE_SUSPENDED;
            FilesProvider filesProvider = this.this$0;
            String[] strArr3 = this.$projection;
            switch (i) {
                case 0:
                    int i2 = this.label;
                    try {
                        if (i2 == 0) {
                            ResultKt.throwOnFailure(obj);
                            if (str3 == null) {
                                str3 = "/";
                            }
                            Path pathResolve = Paths.resolve(str3);
                            Picker picker = (Picker) filesProvider.picker$delegate.getValue();
                            this.L$0 = str3;
                            this.label = 1;
                            obj = picker.pick(pathResolve, false, this);
                            if (obj == matrixCursor2) {
                                matrixCursor = matrixCursor2;
                            } else {
                                str = str3;
                            }
                            return matrixCursor;
                        }
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        str = this.L$0;
                        ResultKt.throwOnFailure(obj);
                        Document document = (Document) obj;
                        if (strArr3 == null) {
                            strArr = FilesProvider.DEFAULT_DOCUMENT_COLUMNS;
                        } else {
                            String[] strArr4 = FilesProvider.DEFAULT_DOCUMENT_COLUMNS;
                            strArr = strArr3;
                        }
                        MatrixCursor matrixCursor3 = new MatrixCursor(strArr);
                        MatrixCursor.RowBuilder rowBuilderNewRow = matrixCursor3.newRow();
                        FilesProvider.access$applyDocument(filesProvider, rowBuilderNewRow, document);
                        rowBuilderNewRow.add("document_id", str);
                        matrixCursor = matrixCursor3;
                        break;
                    } catch (Exception unused) {
                        if (strArr3 == null) {
                            strArr3 = FilesProvider.DEFAULT_DOCUMENT_COLUMNS;
                        } else {
                            String[] strArr5 = FilesProvider.DEFAULT_DOCUMENT_COLUMNS;
                        }
                        matrixCursor = new MatrixCursor(strArr3);
                    }
                    return matrixCursor;
                default:
                    int i3 = this.label;
                    try {
                        if (i3 == 0) {
                            ResultKt.throwOnFailure(obj);
                            if (str3 == null) {
                                str3 = "/";
                            }
                            Path pathResolve2 = Paths.resolve(str3);
                            Picker picker2 = (Picker) filesProvider.picker$delegate.getValue();
                            this.L$0 = str3;
                            this.label = 1;
                            obj = picker2.list(pathResolve2, this);
                            if (obj != matrixCursor2) {
                                str2 = str3;
                            }
                            return matrixCursor2;
                        }
                        if (i3 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        str2 = this.L$0;
                        ResultKt.throwOnFailure(obj);
                        List<Document> list = (List) obj;
                        if (strArr3 == null) {
                            strArr2 = FilesProvider.DEFAULT_DOCUMENT_COLUMNS;
                        } else {
                            String[] strArr6 = FilesProvider.DEFAULT_DOCUMENT_COLUMNS;
                            strArr2 = strArr3;
                        }
                        matrixCursor2 = new MatrixCursor(strArr2);
                        for (Document document2 : list) {
                            MatrixCursor.RowBuilder rowBuilderNewRow2 = matrixCursor2.newRow();
                            FilesProvider.access$applyDocument(filesProvider, rowBuilderNewRow2, document2);
                            rowBuilderNewRow2.add("document_id", str2 + "/" + document2.getId());
                            break;
                        }
                    } catch (Exception unused2) {
                        if (strArr3 == null) {
                            strArr3 = FilesProvider.DEFAULT_DOCUMENT_COLUMNS;
                        } else {
                            String[] strArr7 = FilesProvider.DEFAULT_DOCUMENT_COLUMNS;
                        }
                        matrixCursor2 = new MatrixCursor(strArr3);
                    }
                    return matrixCursor2;
            }
        }
    }

    static {
        FLAG_VIRTUAL = Build.VERSION.SDK_INT >= 24 ? 512 : 0;
    }

    public static final void access$applyDocument(FilesProvider filesProvider, MatrixCursor.RowBuilder rowBuilder, Document document) {
        Iterator it = document.getFlags().iterator();
        int i = 0;
        while (it.hasNext()) {
            int iOrdinal = ((Flag) it.next()).ordinal();
            if (iOrdinal == 0) {
                i |= 2;
            } else if (iOrdinal == 1) {
                i |= 4;
            } else {
                if (iOrdinal != 2) {
                    throw new HttpException();
                }
                i |= FLAG_VIRTUAL;
            }
        }
        rowBuilder.add("_display_name", document.getName());
        rowBuilder.add("mime_type", document.getMimeType());
        rowBuilder.add("last_modified", Long.valueOf(document.getUpdatedAt()));
        rowBuilder.add("_size", Long.valueOf(document.getSize()));
        rowBuilder.add("flags", Integer.valueOf(i));
    }

    @Override // android.provider.DocumentsProvider
    public final void deleteDocument(String str) throws Throwable {
        JobKt.runBlocking(EmptyCoroutineContext.INSTANCE, new ChannelFlow.AnonymousClass2(str == null ? "/" : str, str, this, null, 4));
    }

    @Override // android.provider.DocumentsProvider
    public final boolean isChildDocument(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        return StringsKt__StringsJVMKt.startsWith(str2, str, false);
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        return true;
    }

    @Override // android.provider.DocumentsProvider
    public final ParcelFileDescriptor openDocument(String str, String str2, CancellationSignal cancellationSignal) {
        return (ParcelFileDescriptor) JobKt.runBlocking(EmptyCoroutineContext.INSTANCE, new AnonymousClass1(str, this, str2, ParcelFileDescriptor.parseMode(str2), null));
    }

    @Override // android.provider.DocumentsProvider
    public final Cursor queryChildDocuments(String str, String[] strArr, String str2) {
        return (Cursor) JobKt.runBlocking(EmptyCoroutineContext.INSTANCE, new C00261(str, this, strArr, null, 1));
    }

    @Override // android.provider.DocumentsProvider
    public final Cursor queryDocument(String str, String[] strArr) {
        return (Cursor) JobKt.runBlocking(EmptyCoroutineContext.INSTANCE, new C00261(str, this, strArr, null, 0));
    }

    @Override // android.provider.DocumentsProvider
    public final Cursor queryRoots(String[] strArr) {
        if (strArr == null) {
            strArr = DEFAULT_ROOT_COLUMNS;
        }
        MatrixCursor matrixCursor = new MatrixCursor(strArr);
        MatrixCursor.RowBuilder rowBuilderNewRow = matrixCursor.newRow();
        rowBuilderNewRow.add("root_id", "0");
        rowBuilderNewRow.add("flags", 18);
        rowBuilderNewRow.add("icon", Integer.valueOf(R.drawable.ic_logo_service));
        rowBuilderNewRow.add("title", getContext().getString(R.string.clash_meta_for_android));
        rowBuilderNewRow.add("summary", getContext().getString(R.string.profiles_and_providers));
        rowBuilderNewRow.add("document_id", "/");
        rowBuilderNewRow.add("mime_types", "vnd.android.document/directory");
        return matrixCursor;
    }

    @Override // android.provider.DocumentsProvider
    public final String renameDocument(String str, String str2) {
        String str3 = str2 == null ? "" : str2;
        if (PatternsKt.PatternFileName.matches(str3)) {
            return (String) JobKt.runBlocking(EmptyCoroutineContext.INSTANCE, new NavHostKt$NavHost$29$1(str, this, str3, null, 22));
        }
        throw new IllegalArgumentException(CaptureSession$State$EnumUnboxingLocalUtility.m("invalid name ", str2));
    }
}
