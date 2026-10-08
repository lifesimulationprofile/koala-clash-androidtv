package dev.chrisbanes.haze;

import android.graphics.Bitmap;
import android.view.KeyEvent;
import androidx.compose.foundation.text.BasicTextKt;
import androidx.compose.foundation.text.selection.SelectionManager;
import androidx.compose.runtime.CancellationHandle;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidImageBitmap;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.Key_androidKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.RulerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RenderScriptBlurEffect$updateSurface$2$4 implements Function1 {
    public final /* synthetic */ Object $content;
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ RenderScriptBlurEffect$updateSurface$2$4(int i, Object obj) {
        this.$r8$classId = i;
        this.$content = obj;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0041  */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        boolean z;
        boolean z2;
        switch (this.$r8$classId) {
            case 0:
                GraphicsLayerKt.drawLayer((DrawScope) obj, (GraphicsLayer) this.$content);
                return Unit.INSTANCE;
            case 1:
                float[] fArr = ((Matrix) obj).values;
                LayoutCoordinates layoutCoordinates = (LayoutCoordinates) this.$content;
                if (layoutCoordinates.isAttached()) {
                    RulerKt.findRootCoordinates(layoutCoordinates).mo529transformFromEL8BTi8(layoutCoordinates, fArr);
                }
                return Unit.INSTANCE;
            case 2:
                KeyEvent keyEvent = ((androidx.compose.ui.input.key.KeyEvent) obj).nativeKeyEvent;
                SelectionManager selectionManager = (SelectionManager) this.$content;
                if (BasicTextKt.platformDefaultKeyMapping.m171mapZmokQxo(keyEvent) == 18) {
                    selectionManager.copy$foundation();
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 3:
                ((CancellationHandle) this.$content).cancel();
                return Unit.INSTANCE;
            case 4:
                KeyEvent keyEvent2 = ((androidx.compose.ui.input.key.KeyEvent) obj).nativeKeyEvent;
                if (Key.m504equalsimpl0(Key_androidKt.Key(keyEvent2.getKeyCode()), Key.Back)) {
                    z2 = true;
                    if (Key_androidKt.m506getTypeZmokQxo(keyEvent2) == 1) {
                        ((Function0) this.$content).invoke();
                    } else {
                        z2 = false;
                    }
                } else {
                    z2 = false;
                }
                return Boolean.valueOf(z2);
            default:
                Modifier.CC.m310drawImagegbVJVH8$default((DrawScope) obj, new AndroidImageBitmap((Bitmap) this.$content), 0L, 0.0f, null, 0, 62);
                return Unit.INSTANCE;
        }
    }
}
