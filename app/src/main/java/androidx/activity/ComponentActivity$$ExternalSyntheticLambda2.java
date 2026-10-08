package androidx.activity;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.Preview$$ExternalSyntheticLambda1;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.navigationevent.DirectNavigationEventInput;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ComponentActivity$$ExternalSyntheticLambda2 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ AppCompatActivity f$0;

    public /* synthetic */ ComponentActivity$$ExternalSyntheticLambda2(AppCompatActivity appCompatActivity, int i) {
        this.$r8$classId = i;
        this.f$0 = appCompatActivity;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.$r8$classId) {
            case 0:
                return new FullyDrawnReporter(new ComponentActivity$$ExternalSyntheticLambda2(this.f$0, 1));
            case 1:
                this.f$0.reportFullyDrawn();
                return Unit.INSTANCE;
            case 2:
                DirectNavigationEventInput directNavigationEventInput = new DirectNavigationEventInput();
                this.f$0.getOnBackPressedDispatcher().eventDispatcher.addInput(directNavigationEventInput);
                return directNavigationEventInput;
            case 3:
                AppCompatActivity appCompatActivity = this.f$0;
                return new SavedStateViewModelFactory(appCompatActivity.getApplication(), appCompatActivity, appCompatActivity.getIntent() != null ? appCompatActivity.getIntent().getExtras() : null);
            default:
                AppCompatActivity appCompatActivity2 = this.f$0;
                OnBackPressedDispatcher onBackPressedDispatcher = new OnBackPressedDispatcher(new ComponentActivity$$ExternalSyntheticLambda1(appCompatActivity2, 1));
                if (Build.VERSION.SDK_INT >= 33) {
                    if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                        appCompatActivity2.lifecycleRegistry.addObserver(new ComponentActivity$$ExternalSyntheticLambda13(onBackPressedDispatcher, appCompatActivity2));
                    } else {
                        new Handler(Looper.getMainLooper()).post(new Preview$$ExternalSyntheticLambda1(1, appCompatActivity2, onBackPressedDispatcher));
                    }
                }
                return onBackPressedDispatcher;
        }
    }
}
