package coil.util;

import android.view.InputDevice;
import android.view.KeyEvent;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.SnapshotIdSet;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.key.Key_androidKt;
import androidx.compose.ui.platform.DelegatingSoftwareKeyboardController;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import coil.compose.AsyncImagePainter$$ExternalSyntheticLambda0;
import coil.disk.DiskLruCache;
import com.github.kr328.clash.remote.Resource$get$2$callback$1;
import dev.chrisbanes.haze.HazeKt;
import dev.chrisbanes.haze.HazeTint;
import dev.chrisbanes.haze.ScrimBlurEffect;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuationImpl;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.connection.RealCall;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ContinuationCallback implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final Object call;
    public final Object continuation;

    public /* synthetic */ ContinuationCallback(int i, Object obj, Object obj2) {
        this.$r8$classId = i;
        this.call = obj;
        this.continuation = obj2;
    }

    private final Object invoke$androidx$compose$runtime$snapshots$GlobalSnapshot$takeNestedMutableSnapshot$1$1(Object obj) {
        long j;
        SnapshotIdSet snapshotIdSet = (SnapshotIdSet) obj;
        synchronized (SnapshotKt.lock) {
            j = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = ((long) 1) + j;
        }
        return new MutableSnapshot(j, snapshotIdSet, (Function1) this.call, (Function1) this.continuation);
    }

    private final Object invoke$com$github$kr328$clash$remote$Resource$get$2$1(Object obj) {
        CacheStrategy cacheStrategy = (CacheStrategy) this.call;
        Resource$get$2$callback$1 resource$get$2$callback$1 = (Resource$get$2$callback$1) this.continuation;
        synchronized (cacheStrategy) {
            ((LinkedHashSet) cacheStrategy.networkRequest).remove(resource$get$2$callback$1);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:69:0x0148  */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        boolean z;
        switch (this.$r8$classId) {
            case 0:
                try {
                    ((RealCall) this.call).cancel();
                    break;
                } catch (Throwable unused) {
                }
                return Unit.INSTANCE;
            case 1:
                KeyEvent keyEvent = ((androidx.compose.ui.input.key.KeyEvent) obj).nativeKeyEvent;
                if (((LegacyTextFieldState) this.call).getHandleState() == HandleState.Selection && keyEvent.getKeyCode() == 4) {
                    z = true;
                    if (Key_androidKt.m506getTypeZmokQxo(keyEvent) == 1) {
                        ((TextFieldSelectionManager) this.continuation).m230deselect_kEHs6E$foundation(null);
                    } else {
                        z = false;
                    }
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 2:
                KeyEvent keyEvent2 = ((androidx.compose.ui.input.key.KeyEvent) obj).nativeKeyEvent;
                FocusOwner focusOwner = (FocusOwner) this.call;
                InputDevice device = keyEvent2.getDevice();
                boolean zM346moveFocusaToIllA = false;
                if (device != null && device.supportsSource(513) && ((!device.isVirtual() || keyEvent2.getSource() == 33554433) && Key_androidKt.m506getTypeZmokQxo(keyEvent2) == 2 && keyEvent2.getSource() != 257)) {
                    if (BasicTextKt.m167access$isKeyCodeYhN2O0w(19, keyEvent2)) {
                        zM346moveFocusaToIllA = ((FocusOwnerImpl) focusOwner).m346moveFocusaToIllA(5, true);
                    } else if (BasicTextKt.m167access$isKeyCodeYhN2O0w(20, keyEvent2)) {
                        zM346moveFocusaToIllA = ((FocusOwnerImpl) focusOwner).m346moveFocusaToIllA(6, true);
                    } else if (BasicTextKt.m167access$isKeyCodeYhN2O0w(21, keyEvent2)) {
                        zM346moveFocusaToIllA = ((FocusOwnerImpl) focusOwner).m346moveFocusaToIllA(3, true);
                    } else if (BasicTextKt.m167access$isKeyCodeYhN2O0w(22, keyEvent2)) {
                        zM346moveFocusaToIllA = ((FocusOwnerImpl) focusOwner).m346moveFocusaToIllA(4, true);
                    } else if (BasicTextKt.m167access$isKeyCodeYhN2O0w(23, keyEvent2)) {
                        SoftwareKeyboardController softwareKeyboardController = ((LegacyTextFieldState) this.continuation).keyboardController;
                        if (softwareKeyboardController != null) {
                            ((DelegatingSoftwareKeyboardController) softwareKeyboardController).show();
                        }
                        zM346moveFocusaToIllA = true;
                    }
                }
                return Boolean.valueOf(zM346moveFocusaToIllA);
            case 3:
                DiskLruCache.Editor editor = (DiskLruCache.Editor) this.call;
                Object obj2 = editor.entry;
                CancellableContinuationImpl cancellableContinuationImpl = (CancellableContinuationImpl) this.continuation;
                synchronized (obj2) {
                    ((ArrayList) editor.written).remove(cancellableContinuationImpl);
                }
                return Unit.INSTANCE;
            case 4:
                return invoke$androidx$compose$runtime$snapshots$GlobalSnapshot$takeNestedMutableSnapshot$1$1(obj);
            case 5:
                return ((AsyncImagePainter$$ExternalSyntheticLambda0) this.call).invoke(((List) this.continuation).get(((Number) obj).intValue()));
            case 6:
                return ((AsyncImagePainter$$ExternalSyntheticLambda0) this.call).invoke(((List) this.continuation).get(((Number) obj).intValue()));
            case 7:
                return ((AsyncImagePainter$$ExternalSyntheticLambda0) this.call).invoke(((List) this.continuation).get(((Number) obj).intValue()));
            case 8:
                return invoke$com$github$kr328$clash$remote$Resource$get$2$1(obj);
            default:
                DrawScope drawScope = (DrawScope) obj;
                HazeKt.m827drawScrimDBWKusU(drawScope, (HazeTint) this.call, ((ScrimBlurEffect) this.continuation).node, 0L, drawScope.mo474getSizeNHjbRc());
                return Unit.INSTANCE;
        }
    }
}
