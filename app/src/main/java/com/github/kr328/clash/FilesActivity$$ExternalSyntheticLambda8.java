package com.github.kr328.clash;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1;
import coil.RealImageLoader$executeMain$result$1;
import com.github.kr328.clash.compose.newprofile.NewProfileViewModel;
import com.github.kr328.clash.compose.qrcode.TvQrCodeSheetKt$TvQrCodeSheet$3$1$profileServer$1;
import com.github.kr328.clash.design.model.File;
import com.github.kr328.clash.qrserver.QrProfileServer;
import com.github.kr328.clash.remote.FilesClient;
import java.io.ByteArrayOutputStream;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FilesActivity$$ExternalSyntheticLambda8 implements Function1 {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ CoroutineScope f$0;
    public final /* synthetic */ MutableState f$1;
    public final /* synthetic */ Context f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ MutableState f$6;

    public /* synthetic */ FilesActivity$$ExternalSyntheticLambda8(CoroutineScope coroutineScope, Context context, NewProfileViewModel newProfileViewModel, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4) {
        this.f$0 = coroutineScope;
        this.f$2 = context;
        this.f$3 = newProfileViewModel;
        this.f$1 = mutableState;
        this.f$6 = mutableState2;
        this.f$4 = mutableState3;
        this.f$5 = mutableState4;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Object failure;
        int i = this.$r8$classId;
        Object obj2 = this.f$5;
        Object obj3 = this.f$4;
        Object obj4 = this.f$3;
        Context context = this.f$2;
        CoroutineScope coroutineScope = this.f$0;
        switch (i) {
            case 0:
                FilesActivity filesActivity = (FilesActivity) context;
                FilesClient filesClient = (FilesClient) obj4;
                SnapshotStateList snapshotStateList = (SnapshotStateList) obj3;
                String str = (String) obj2;
                Uri uri = (Uri) obj;
                int i2 = FilesActivity.$r8$clinit;
                MutableState mutableState = this.f$1;
                File file = (File) mutableState.getValue();
                mutableState.setValue(null);
                if (uri != null && file != null) {
                    JobKt.launch$default(coroutineScope, null, new FilesActivity$Content$5$1$1$1(filesActivity, filesClient, file, uri, snapshotStateList, str, this.f$6, (Continuation) null), 3);
                }
                return Unit.INSTANCE;
            default:
                NewProfileViewModel newProfileViewModel = (NewProfileViewModel) obj4;
                MutableState mutableState2 = (MutableState) obj3;
                MutableState mutableState3 = (MutableState) obj2;
                try {
                    Drawable applicationIcon = context.getPackageManager().getApplicationIcon(context.getApplicationInfo());
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(96, 96, Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(bitmapCreateBitmap);
                    applicationIcon.setBounds(0, 0, 96, 96);
                    applicationIcon.draw(canvas);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmapCreateBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                    bitmapCreateBitmap.recycle();
                    failure = byteArrayOutputStream.toByteArray();
                    break;
                } catch (Throwable th) {
                    failure = new Result.Failure(th);
                }
                if (failure instanceof Result.Failure) {
                    failure = null;
                }
                QrProfileServer qrProfileServer = new QrProfileServer(new TvQrCodeSheetKt$TvQrCodeSheet$3$1$profileServer$1(newProfileViewModel, null, 0), new TvQrCodeSheetKt$TvQrCodeSheet$3$1$profileServer$1(newProfileViewModel, null, 1), (byte[]) failure);
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                JobKt.launch$default(coroutineScope, DefaultIoScheduler.INSTANCE, new RealImageLoader$executeMain$result$1(qrProfileServer, this.f$1, this.f$6, mutableState2, mutableState3, null, 14), 2);
                return new AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1(19, qrProfileServer);
        }
    }

    public /* synthetic */ FilesActivity$$ExternalSyntheticLambda8(CoroutineScope coroutineScope, MutableState mutableState, FilesActivity filesActivity, FilesClient filesClient, SnapshotStateList snapshotStateList, String str, MutableState mutableState2) {
        this.f$0 = coroutineScope;
        this.f$1 = mutableState;
        this.f$2 = filesActivity;
        this.f$3 = filesClient;
        this.f$4 = snapshotStateList;
        this.f$5 = str;
        this.f$6 = mutableState2;
    }
}
