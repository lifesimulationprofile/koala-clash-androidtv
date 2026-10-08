package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.selection.OffsetProvider;
import androidx.compose.foundation.text.selection.SimpleLayoutKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.ButtonKt$$ExternalSyntheticLambda2;
import androidx.compose.runtime.BroadcastFrameClock$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import com.github.kr328.clash.compose.profiles.ProfilesScreenKt$$ExternalSyntheticLambda7;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AndroidCursorHandle_androidKt {
    public static final float CursorHandleHeight;
    public static final float CursorHandleWidth;

    static {
        float f = 25;
        CursorHandleHeight = f;
        CursorHandleWidth = (f * 2.0f) / 2.4142137f;
    }

    /* JADX INFO: renamed from: CursorHandle-USBMPiE, reason: not valid java name */
    public static final void m165CursorHandleUSBMPiE(OffsetProvider offsetProvider, Modifier modifier, long j, GapComposer gapComposer, int i) {
        int i2;
        gapComposer.startRestartGroup(1776202187);
        int i3 = (gapComposer.changed(offsetProvider) ? 4 : 2) | i | (gapComposer.changed(modifier) ? 32 : 16) | 128;
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
            gapComposer.startDefaults();
            if ((i & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                i2 = i3 & (-897);
                j = 9205357640488583168L;
            } else {
                gapComposer.skipToGroupEnd();
                i2 = i3 & (-897);
            }
            gapComposer.endDefaults();
            int i4 = i2 & 14;
            boolean z = i4 == 4;
            Object objRememberedValue = gapComposer.rememberedValue();
            if (z || objRememberedValue == Composer$Companion.Empty) {
                objRememberedValue = new Recomposer$$ExternalSyntheticLambda0(14, offsetProvider);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            SimpleLayoutKt.HandlePopup(offsetProvider, Alignment.Companion.TopCenter, Thread_jvmKt.rememberComposableLambda(-1653527038, new AndroidCursorHandle_androidKt$$ExternalSyntheticLambda1(j, SemanticsModifierKt.semantics(modifier, false, (Function1) objRememberedValue)), gapComposer), gapComposer, i4 | 432);
        } else {
            gapComposer.skipToGroupEnd();
        }
        long j2 = j;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ButtonKt$$ExternalSyntheticLambda2(offsetProvider, modifier, j2, i);
        }
    }

    public static final void DefaultCursorHandle(Modifier modifier, GapComposer gapComposer, int i, int i2) {
        int i3;
        gapComposer.startRestartGroup(694251107);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else {
            i3 = (gapComposer.changed(modifier) ? 4 : 2) | i;
        }
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 3) != 2)) {
            if (i4 != 0) {
                modifier = Modifier.Companion.$$INSTANCE;
            }
            OffsetKt.Spacer(gapComposer, ClipKt.drawWithCache(SizeKt.m141sizeVpY3zN4(modifier, CursorHandleWidth, CursorHandleHeight), new BroadcastFrameClock$$ExternalSyntheticLambda0(1, ((TextSelectionColors) gapComposer.consume(TextSelectionColorsKt.LocalTextSelectionColors)).handleColor)));
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ProfilesScreenKt$$ExternalSyntheticLambda7(modifier, i, i2);
        }
    }
}
