package androidx.compose.foundation.layout;

import android.view.View;
import androidx.activity.compose.BackHandlerKt$$ExternalSyntheticLambda2;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.WeakHashMap;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FlowRowOverflow implements Arrangement.Horizontal, Arrangement.Vertical {
    public static final /* synthetic */ int $r8$clinit = 0;
    public static final FlowRowOverflow INSTANCE = new FlowRowOverflow(1);
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ FlowRowOverflow(int i) {
        this.$r8$classId = i;
    }

    public static final AndroidWindowInsets access$systemInsets(String str, int i) {
        WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
        return new AndroidWindowInsets(str, i);
    }

    public static final ValueInsets access$valueInsetsIgnoringVisibility(String str, int i) {
        WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
        return new ValueInsets(new InsetsValues(0, 0, 0, 0), str);
    }

    public static WindowInsetsHolder current(GapComposer gapComposer) {
        View view = (View) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalView);
        WindowInsetsHolder orCreateFor = getOrCreateFor(view);
        boolean zChangedInstance = gapComposer.changedInstance(orCreateFor) | gapComposer.changedInstance(view);
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChangedInstance || objRememberedValue == Composer$Companion.Empty) {
            objRememberedValue = new BackHandlerKt$$ExternalSyntheticLambda2(21, orCreateFor, view);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        Stack.DisposableEffect(orCreateFor, (Function1) objRememberedValue, gapComposer);
        return orCreateFor;
    }

    public static WindowInsetsHolder getOrCreateFor(View view) {
        WindowInsetsHolder windowInsetsHolder;
        WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
        synchronized (weakHashMap) {
            try {
                Object windowInsetsHolder2 = weakHashMap.get(view);
                if (windowInsetsHolder2 == null) {
                    windowInsetsHolder2 = new WindowInsetsHolder(view);
                    weakHashMap.put(view, windowInsetsHolder2);
                }
                windowInsetsHolder = (WindowInsetsHolder) windowInsetsHolder2;
            } catch (Throwable th) {
                throw th;
            }
        }
        return windowInsetsHolder;
    }

    public Modifier align(Modifier modifier, BiasAlignment biasAlignment) {
        return modifier.then(new BoxChildDataElement(biasAlignment));
    }

    @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
    public void arrange(MeasureScope measureScope, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2) {
        switch (this.$r8$classId) {
            case 2:
                Arrangement.placeLeftOrTop$foundation_layout(iArr, iArr2, false);
                break;
            case 3:
                Arrangement.placeRightOrBottom$foundation_layout(i, iArr, iArr2, false);
                break;
            case 4:
            default:
                if (layoutDirection != LayoutDirection.Ltr) {
                    Arrangement.placeRightOrBottom$foundation_layout(i, iArr, iArr2, true);
                } else {
                    Arrangement.placeLeftOrTop$foundation_layout(iArr, iArr2, false);
                }
                break;
            case 5:
                if (layoutDirection != LayoutDirection.Ltr) {
                    Arrangement.placeLeftOrTop$foundation_layout(iArr, iArr2, true);
                } else {
                    Arrangement.placeRightOrBottom$foundation_layout(i, iArr, iArr2, false);
                }
                break;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0002. Please report as an issue. */
    @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
    /* JADX INFO: renamed from: getSpacing-D9Ej5fM */
    public float mo112getSpacingD9Ej5fM() {
        switch (this.$r8$classId) {
        }
        return 0;
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 2:
                return "AbsoluteArrangement#Left";
            case 3:
                return "AbsoluteArrangement#Right";
            case 4:
                return "Arrangement#Bottom";
            case 5:
                return "Arrangement#End";
            case 6:
                return "Arrangement#Start";
            case 7:
                return "Arrangement#Top";
            default:
                return super.toString();
        }
    }

    @Override // androidx.compose.foundation.layout.Arrangement.Vertical
    public void arrange(int i, MeasureScope measureScope, int[] iArr, int[] iArr2) {
        switch (this.$r8$classId) {
            case 4:
                Arrangement.placeRightOrBottom$foundation_layout(i, iArr, iArr2, false);
                break;
            default:
                Arrangement.placeLeftOrTop$foundation_layout(iArr, iArr2, false);
                break;
        }
    }
}
