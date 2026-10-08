package com.github.kr328.clash;

import android.app.Application;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.provider.DocumentsContract;
import androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.compose.DialogNavigator;
import com.github.kr328.clash.common.constants.Authorities;
import com.github.kr328.clash.compose.newprofile.NewProfileViewModel;
import com.github.kr328.clash.core.model.LogMessage;
import com.github.kr328.clash.design.model.LogFile;
import com.github.kr328.clash.design.util.I18nKt;
import com.github.kr328.clash.log.LogcatFilter;
import com.github.kr328.clash.remote.FilesClient;
import com.github.kr328.clash.service.model.Profile;
import com.github.kr328.clash.service.remote.IClashManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LogcatActivity$writeLogTo$2$1 extends SuspendLambda implements Function2 {
    public final /* synthetic */ Object $file;
    public /* synthetic */ Object $it;
    public final /* synthetic */ Object $messages;
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LogcatActivity$writeLogTo$2$1(Object obj, Object obj2, Object obj3, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.$it = obj;
        this.$file = obj2;
        this.$messages = obj3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        switch (this.$r8$classId) {
            case 0:
                return new LogcatActivity$writeLogTo$2$1((LogcatFilter) this.$it, (LogFile) this.$file, (List) this.$messages, continuation, 0);
            case 1:
                LogcatActivity$writeLogTo$2$1 logcatActivity$writeLogTo$2$1 = new LogcatActivity$writeLogTo$2$1((PointerInputScope) this.$file, (TextDragObserver) this.$messages, continuation, 1);
                logcatActivity$writeLogTo$2$1.$it = obj;
                return logcatActivity$writeLogTo$2$1;
            case 2:
                return new LogcatActivity$writeLogTo$2$1((MutableState) this.$it, (DialogNavigator) this.$file, (SnapshotStateList) this.$messages, continuation, 2);
            case 3:
                return new LogcatActivity$writeLogTo$2$1((IBinder) this.$it, (IClashManager) this.$file, (LogcatService) this.$messages, continuation, 3);
            case 4:
                LogcatActivity$writeLogTo$2$1 logcatActivity$writeLogTo$2$2 = new LogcatActivity$writeLogTo$2$1((ShareToTvActivity) this.$file, (Profile) this.$messages, continuation, 4);
                logcatActivity$writeLogTo$2$2.$it = obj;
                return logcatActivity$writeLogTo$2$2;
            case 5:
                return new LogcatActivity$writeLogTo$2$1((NewProfileViewModel) this.$it, (UUID) this.$file, (byte[]) this.$messages, continuation, 5);
            case 6:
                return new LogcatActivity$writeLogTo$2$1((NewProfileViewModel) this.$it, (UUID) this.$file, (Uri) this.$messages, continuation, 6);
            case 7:
                LogcatActivity$writeLogTo$2$1 logcatActivity$writeLogTo$2$3 = new LogcatActivity$writeLogTo$2$1((String) this.$file, (String) this.$messages, continuation, 7);
                logcatActivity$writeLogTo$2$3.$it = obj;
                return logcatActivity$writeLogTo$2$3;
            case 8:
                return new LogcatActivity$writeLogTo$2$1((FilesClient) this.$it, (String) this.$file, (String) this.$messages, continuation, 8);
            case 9:
                return new LogcatActivity$writeLogTo$2$1((ContentResolver) this.$it, (Uri) this.$file, (Uri) this.$messages, continuation, 9);
            default:
                return new LogcatActivity$writeLogTo$2$1((Exception) this.$it, (IBinder) this.$file, (Parcel) this.$messages, continuation, 10);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                return ((LogcatActivity$writeLogTo$2$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 1:
                return ((LogcatActivity$writeLogTo$2$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 2:
                return ((LogcatActivity$writeLogTo$2$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 3:
                return ((LogcatActivity$writeLogTo$2$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 4:
                return ((LogcatActivity$writeLogTo$2$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 5:
                return ((LogcatActivity$writeLogTo$2$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 6:
                return ((LogcatActivity$writeLogTo$2$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 7:
                return ((LogcatActivity$writeLogTo$2$1) create((IClashManager) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 8:
                return ((LogcatActivity$writeLogTo$2$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            case 9:
                return ((LogcatActivity$writeLogTo$2$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
            default:
                return ((LogcatActivity$writeLogTo$2$1) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws RemoteException, IOException {
        Object failure;
        boolean zTransact;
        int i = this.$r8$classId;
        int i2 = 2;
        int i3 = 1;
        Long l = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object obj2 = this.$messages;
        Object obj3 = this.$file;
        switch (i) {
            case 0:
                ResultKt.throwOnFailure(obj);
                LogcatFilter logcatFilter = (LogcatFilter) this.$it;
                Date date = ((LogFile) obj3).date;
                LogcatActivity logcatActivity = logcatFilter.context;
                logcatFilter.append((CharSequence) "# Capture on ".concat(I18nKt.format$default(date, logcatActivity, 6))).append('\n');
                for (LogMessage logMessage : (List) obj2) {
                    logcatFilter.append((CharSequence) String.format("%12s %7s: %s", Arrays.copyOf(new Object[]{I18nKt.format$default(logMessage.time, logcatActivity, 4), logMessage.level.name(), logMessage.message}, 3))).append('\n');
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.$it;
                PointerInputScope pointerInputScope = (PointerInputScope) obj3;
                TextDragObserver textDragObserver = (TextDragObserver) obj2;
                JobKt.launch$default(coroutineScope, null, new CoreTextFieldKt$TextFieldCursorHandle$2$1.AnonymousClass1.C00001(pointerInputScope, textDragObserver, objArr2 == true ? 1 : 0, i3), 1);
                return JobKt.launch$default(coroutineScope, null, new CoreTextFieldKt$TextFieldCursorHandle$2$1.AnonymousClass1.C00001(pointerInputScope, textDragObserver, objArr == true ? 1 : 0, i2), 1);
            case 2:
                ResultKt.throwOnFailure(obj);
                DialogNavigator dialogNavigator = (DialogNavigator) obj3;
                SnapshotStateList snapshotStateList = (SnapshotStateList) obj2;
                for (NavBackStackEntry navBackStackEntry : (Set) ((MutableState) this.$it).getValue()) {
                    if (!((List) dialogNavigator.getState().backStack.$$delegate_0.getValue()).contains(navBackStackEntry) && !snapshotStateList.contains(navBackStackEntry)) {
                        dialogNavigator.getState().markTransitionComplete(navBackStackEntry);
                    }
                }
                return Unit.INSTANCE;
            case 3:
                ResultKt.throwOnFailure(obj);
                if (((IBinder) this.$it).isBinderAlive()) {
                    ((IClashManager) obj3).setLogObserver(null);
                }
                ((LogcatService) obj2).stopSelf();
                return Unit.INSTANCE;
            case 4:
                ResultKt.throwOnFailure(obj);
                try {
                    InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(FilesKt.resolve(FilesKt.resolve(com.github.kr328.clash.service.util.FilesKt.getImportedDir((ShareToTvActivity) obj3), ((Profile) obj2).uuid.toString()), "config.yaml")), Charsets.UTF_8);
                    try {
                        StringWriter stringWriter = new StringWriter();
                        char[] cArr = new char[8192];
                        for (int i4 = inputStreamReader.read(cArr); i4 >= 0; i4 = inputStreamReader.read(cArr)) {
                            stringWriter.write(cArr, 0, i4);
                        }
                        failure = stringWriter.toString();
                        inputStreamReader.close();
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(inputStreamReader, th);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    failure = new Result.Failure(th3);
                }
                if (failure instanceof Result.Failure) {
                    return null;
                }
                return failure;
            case 5:
                ResultKt.throwOnFailure(obj);
                File fileResolve = FilesKt.resolve(FilesKt.resolve(FilesKt.resolve(((NewProfileViewModel) this.$it).app.getFilesDir(), "imported"), ((UUID) obj3).toString()), "config.yaml");
                File parentFile = fileResolve.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                byte[] bArr = (byte[]) obj2;
                FileOutputStream fileOutputStream = new FileOutputStream(fileResolve);
                try {
                    fileOutputStream.write(bArr);
                    Unit unit = Unit.INSTANCE;
                    fileOutputStream.close();
                    return Unit.INSTANCE;
                } catch (Throwable th4) {
                    try {
                        throw th4;
                    } catch (Throwable th5) {
                        CloseableKt.closeFinally(fileOutputStream, th4);
                        throw th5;
                    }
                }
            case 6:
                ResultKt.throwOnFailure(obj);
                Application application = ((NewProfileViewModel) this.$it).app;
                File fileResolve2 = FilesKt.resolve(FilesKt.resolve(FilesKt.resolve(application.getFilesDir(), "imported"), ((UUID) obj3).toString()), "config.yaml");
                InputStream inputStreamOpenInputStream = application.getContentResolver().openInputStream((Uri) obj2);
                if (inputStreamOpenInputStream != null) {
                    try {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(fileResolve2);
                        try {
                            long jCopyTo$default = ByteStreamsKt.copyTo$default(inputStreamOpenInputStream, fileOutputStream2);
                            fileOutputStream2.close();
                            l = new Long(jCopyTo$default);
                            inputStreamOpenInputStream.close();
                        } catch (Throwable th6) {
                            try {
                                throw th6;
                            } catch (Throwable th7) {
                                CloseableKt.closeFinally(fileOutputStream2, th6);
                                throw th7;
                            }
                        }
                    } catch (Throwable th8) {
                        try {
                            throw th8;
                        } catch (Throwable th9) {
                            CloseableKt.closeFinally(inputStreamOpenInputStream, th8);
                            throw th9;
                        }
                    }
                }
                return l;
            case 7:
                ResultKt.throwOnFailure(obj);
                return Boolean.valueOf(((IClashManager) this.$it).patchSelector((String) obj3, (String) obj2));
            case 8:
                ResultKt.throwOnFailure(obj);
                FilesClient filesClient = (FilesClient) this.$it;
                filesClient.getClass();
                return DocumentsContract.renameDocument(filesClient.context.getContentResolver(), DocumentsContract.buildDocumentUri(Authorities.FILES_PROVIDER, (String) obj3), (String) obj2);
            case 9:
                ResultKt.throwOnFailure(obj);
                ContentResolver contentResolver = (ContentResolver) this.$it;
                Uri uri = (Uri) obj3;
                InputStream inputStreamOpenInputStream2 = contentResolver.openInputStream(uri);
                if (inputStreamOpenInputStream2 == null) {
                    throw new FileNotFoundException(uri + " not found");
                }
                Uri uri2 = (Uri) obj2;
                try {
                    OutputStream outputStreamOpenOutputStream = contentResolver.openOutputStream(uri2, "rwt");
                    if (outputStreamOpenOutputStream == null) {
                        throw new FileNotFoundException(uri2 + " not found");
                    }
                    try {
                        long jCopyTo$default2 = ByteStreamsKt.copyTo$default(inputStreamOpenInputStream2, outputStreamOpenOutputStream);
                        outputStreamOpenOutputStream.close();
                        Long l2 = new Long(jCopyTo$default2);
                        inputStreamOpenInputStream2.close();
                        return l2;
                    } catch (Throwable th10) {
                        try {
                            throw th10;
                        } catch (Throwable th11) {
                            CloseableKt.closeFinally(outputStreamOpenOutputStream, th10);
                            throw th11;
                        }
                    }
                } catch (Throwable th12) {
                    try {
                        throw th12;
                    } catch (Throwable th13) {
                        CloseableKt.closeFinally(inputStreamOpenInputStream2, th12);
                        throw th13;
                    }
                }
            default:
                IBinder iBinder = (IBinder) obj3;
                Parcel parcel = (Parcel) obj2;
                ResultKt.throwOnFailure(obj);
                Exception exc = (Exception) this.$it;
                if (exc instanceof CancellationException) {
                    zTransact = iBinder.transact(2, parcel, null, 1);
                } else {
                    parcel.setDataPosition(0);
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(exc.getMessage());
                    illegalArgumentException.setStackTrace(exc.getStackTrace());
                    Unit unit2 = Unit.INSTANCE;
                    parcel.writeException(illegalArgumentException);
                    zTransact = iBinder.transact(1, parcel, null, 1);
                }
                return Boolean.valueOf(zTransact);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LogcatActivity$writeLogTo$2$1(Object obj, Object obj2, Continuation continuation, int i) {
        super(2, continuation);
        this.$r8$classId = i;
        this.$file = obj;
        this.$messages = obj2;
    }
}
