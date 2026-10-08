package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.material3.internal.LayoutUtilKt;
import androidx.compose.material3.tokens.SheetBottomTokens;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import com.koala.clash.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class BottomSheetDefaults {
    public static final float BoundaryDampeningZone;
    public static final BottomSheetDefaults INSTANCE = new BottomSheetDefaults();
    public static final float PositionalThreshold;
    public static final float SheetMaxWidth;
    public static final float VelocityThreshold;

    static {
        float f = SheetBottomTokens.DockedDragHandleHeight;
        float f2 = SheetBottomTokens.DockedModalContainerElevation;
        SheetMaxWidth = 640;
        PositionalThreshold = 56;
        float f3 = 125;
        VelocityThreshold = f3;
        BoundaryDampeningZone = f3;
    }

    /* JADX INFO: renamed from: DragHandle-lgZ2HuY, reason: not valid java name */
    public final void m240DragHandlelgZ2HuY(Modifier modifier, float f, float f2, Shape shape, long j, GapComposer gapComposer, int i) {
        Modifier modifier2;
        float f3;
        float f4;
        Shape shape2;
        long j2;
        long value;
        final float f5;
        final float f6;
        Shape shape3;
        Modifier modifier3;
        gapComposer.startRestartGroup(-1364277227);
        int i2 = i | 9654;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 9363) != 9362)) {
            gapComposer.startDefaults();
            if ((i & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                float f7 = SheetBottomTokens.DockedDragHandleWidth;
                float f8 = SheetBottomTokens.DockedDragHandleHeight;
                RoundedCornerShape roundedCornerShape = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).shapes.extraLarge;
                value = ColorSchemeKt.getValue(19, gapComposer);
                f5 = f7;
                f6 = f8;
                shape3 = roundedCornerShape;
                modifier3 = Modifier.Companion.$$INSTANCE;
            } else {
                gapComposer.skipToGroupEnd();
                modifier3 = modifier;
                f5 = f;
                f6 = f2;
                shape3 = shape;
                value = j;
            }
            gapComposer.endDefaults();
            String strM282getString2EP1pXo = LayoutUtilKt.m282getString2EP1pXo(R.string.m3c_bottom_sheet_drag_handle_description, gapComposer);
            Modifier modifierM130paddingVpY3zN4$default = OffsetKt.m130paddingVpY3zN4$default(modifier3, 0.0f, SheetDefaultsKt.DragHandleVerticalPadding, 1);
            boolean zChanged = gapComposer.changed(strM282getString2EP1pXo);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue == Composer$Companion.Empty) {
                objRememberedValue = new IconKt$$ExternalSyntheticLambda1(strM282getString2EP1pXo, 2);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            long j3 = value;
            SurfaceKt.m269SurfaceT9BRK9s(SemanticsModifierKt.semantics(modifierM130paddingVpY3zN4$default, false, (Function1) objRememberedValue), shape3, j3, 0L, 0.0f, 0.0f, Thread_jvmKt.rememberComposableLambda(-1039573072, new Function2() { // from class: androidx.compose.material3.BottomSheetDefaults$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    GapComposer gapComposer2 = (GapComposer) obj;
                    int iIntValue = ((Integer) obj2).intValue();
                    if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                        BoxKt.Box(SizeKt.m141sizeVpY3zN4(Modifier.Companion.$$INSTANCE, f5, f6), gapComposer2, 0);
                    } else {
                        gapComposer2.skipToGroupEnd();
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, 12582912, 120);
            shape2 = shape3;
            j2 = j3;
            modifier2 = modifier3;
            f3 = f5;
            f4 = f6;
        } else {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
            f3 = f;
            f4 = f2;
            shape2 = shape;
            j2 = j;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new SurfaceKt$$ExternalSyntheticLambda0(this, modifier2, f3, f4, shape2, j2, i);
        }
    }
}
