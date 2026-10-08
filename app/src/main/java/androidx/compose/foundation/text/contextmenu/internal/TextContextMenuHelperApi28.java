package androidx.compose.foundation.text.contextmenu.internal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import androidx.compose.foundation.contextmenu.ContextMenuSpec;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TextContextMenuHelperApi28 {
    public static final TextContextMenuHelperApi28 INSTANCE = new TextContextMenuHelperApi28();

    public final void IconBox(final Icon icon, GapComposer gapComposer, final int i) {
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        Function2 function2;
        gapComposer.startRestartGroup(2116504409);
        int i2 = (gapComposer.changedInstance(icon) ? 4 : 2) | i;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            Context context = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
            boolean zChanged = gapComposer.changed(icon) | gapComposer.changed(context);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue == Composer$Companion.Empty) {
                objRememberedValue = icon.loadDrawable(context);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Drawable drawable = (Drawable) objRememberedValue;
            if (drawable == null) {
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup == null) {
                    return;
                }
                final int i3 = 0;
                function2 = new Function2(this, icon, i, i3) { // from class: androidx.compose.foundation.text.contextmenu.internal.TextContextMenuHelperApi28$$ExternalSyntheticLambda13
                    public final /* synthetic */ int $r8$classId;
                    public final /* synthetic */ TextContextMenuHelperApi28 f$0;
                    public final /* synthetic */ Icon f$1;

                    {
                        this.$r8$classId = i3;
                        this.f$0 = this;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        int i4 = this.$r8$classId;
                        GapComposer gapComposer2 = (GapComposer) obj;
                        ((Integer) obj2).getClass();
                        switch (i4) {
                            case 0:
                                this.f$0.IconBox(this.f$1, gapComposer2, Stack.updateChangedFlags(49));
                                break;
                            default:
                                this.f$0.IconBox(this.f$1, gapComposer2, Stack.updateChangedFlags(49));
                                break;
                        }
                        return Unit.INSTANCE;
                    }
                };
            } else {
                IconBox(drawable, gapComposer, 48);
            }
            recomposeScopeImplEndRestartGroup.block = function2;
        }
        gapComposer.skipToGroupEnd();
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            final int i4 = 1;
            function2 = new Function2(this, icon, i, i4) { // from class: androidx.compose.foundation.text.contextmenu.internal.TextContextMenuHelperApi28$$ExternalSyntheticLambda13
                public final /* synthetic */ int $r8$classId;
                public final /* synthetic */ TextContextMenuHelperApi28 f$0;
                public final /* synthetic */ Icon f$1;

                {
                    this.$r8$classId = i4;
                    this.f$0 = this;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    int i5 = this.$r8$classId;
                    GapComposer gapComposer2 = (GapComposer) obj;
                    ((Integer) obj2).getClass();
                    switch (i5) {
                        case 0:
                            this.f$0.IconBox(this.f$1, gapComposer2, Stack.updateChangedFlags(49));
                            break;
                        default:
                            this.f$0.IconBox(this.f$1, gapComposer2, Stack.updateChangedFlags(49));
                            break;
                    }
                    return Unit.INSTANCE;
                }
            };
            recomposeScopeImplEndRestartGroup.block = function2;
        }
    }

    public final void IconBox(Drawable drawable, GapComposer gapComposer, int i) {
        gapComposer.startRestartGroup(257732500);
        int i2 = (gapComposer.changedInstance(drawable) ? 4 : 2) | i;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 3) != 2)) {
            Modifier modifierM140size3ABfNKs = SizeKt.m140size3ABfNKs(Modifier.Companion.$$INSTANCE, ContextMenuSpec.IconSize);
            boolean zChangedInstance = gapComposer.changedInstance(drawable);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer$Companion.Empty) {
                objRememberedValue = new Recomposer$$ExternalSyntheticLambda0(16, drawable);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            BoxKt.Box(ClipKt.drawBehind(modifierM140size3ABfNKs, (Function1) objRememberedValue), gapComposer, 0);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TextKt$$ExternalSyntheticLambda2(i, 9, this, drawable);
        }
    }
}
