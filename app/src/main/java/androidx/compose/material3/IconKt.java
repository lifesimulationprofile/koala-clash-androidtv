package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.tokens.SmallIconButtonTokens;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathParserKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class IconKt {
    public static final Modifier DefaultIconSizeModifier = SizeKt.m140size3ABfNKs(Modifier.Companion.$$INSTANCE, SmallIconButtonTokens.IconSize);

    /* JADX INFO: renamed from: Icon-ww6aTOc, reason: not valid java name */
    public static final void m249Iconww6aTOc(final ImageVector imageVector, String str, Modifier modifier, long j, GapComposer gapComposer, final int i, final int i2) {
        int i3;
        String str2;
        GapComposer gapComposer2;
        final long j2;
        final Modifier modifier2;
        gapComposer.startRestartGroup(-126890956);
        if ((i & 6) == 0) {
            i3 = (gapComposer.changed(imageVector) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= gapComposer.changed(str) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= gapComposer.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= ((i2 & 8) == 0 && gapComposer.changed(j)) ? 2048 : 1024;
        }
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 1171) != 1170)) {
            gapComposer.startDefaults();
            if ((i & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                if (i4 != 0) {
                    modifier = Modifier.Companion.$$INSTANCE;
                }
                if ((i2 & 8) != 0) {
                    j = ((Color) gapComposer.consume(ContentColorKt.LocalContentColor)).value;
                    i3 &= -7169;
                }
            } else {
                gapComposer.skipToGroupEnd();
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                }
            }
            Modifier modifier3 = modifier;
            long j3 = j;
            gapComposer.endDefaults();
            str2 = str;
            gapComposer2 = gapComposer;
            m248Iconww6aTOc(PathParserKt.rememberVectorPainter(imageVector, gapComposer), str2, modifier3, j3, gapComposer2, (i3 & 112) | 8 | (i3 & 896) | (i3 & 7168));
            modifier2 = modifier3;
            j2 = j3;
        } else {
            str2 = str;
            gapComposer2 = gapComposer;
            gapComposer2.skipToGroupEnd();
            j2 = j;
            modifier2 = modifier;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            final String str3 = str2;
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.IconKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    IconKt.m249Iconww6aTOc(imageVector, str3, modifier2, j2, (GapComposer) obj, Stack.updateChangedFlags(i | 1), i2);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX WARN: Code duplicated, block: B:81:0x0121  */
    /* JADX INFO: renamed from: Icon-ww6aTOc, reason: not valid java name */
    public static final void m248Iconww6aTOc(Painter painter, String str, Modifier modifier, long j, GapComposer gapComposer, int i) {
        int i2;
        Modifier modifier2;
        gapComposer.startRestartGroup(-2142239481);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? gapComposer.changed(painter) : gapComposer.changedInstance(painter) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changed(modifier) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changed(j) ? 2048 : 1024;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 1171) != 1170)) {
            gapComposer.startDefaults();
            if ((i & 1) != 0 && !gapComposer.getDefaultsInvalid()) {
                gapComposer.skipToGroupEnd();
            }
            gapComposer.endDefaults();
            boolean z = (((i2 & 7168) ^ 3072) > 2048 && gapComposer.changed(j)) || (i2 & 3072) == 2048;
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (z || objRememberedValue == neverEqualPolicy) {
                objRememberedValue = Color.m435equalsimpl0(j, Color.Unspecified) ? null : new BlendModeColorFilter(5, j);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            BlendModeColorFilter blendModeColorFilter = (BlendModeColorFilter) objRememberedValue;
            Modifier modifier3 = Modifier.Companion.$$INSTANCE;
            if (str != null) {
                gapComposer.startReplaceGroup(-537002883);
                boolean z2 = (i2 & 112) == 32;
                Object objRememberedValue2 = gapComposer.rememberedValue();
                if (z2 || objRememberedValue2 == neverEqualPolicy) {
                    objRememberedValue2 = new IconKt$$ExternalSyntheticLambda1(str, 0);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                Modifier modifierSemantics = SemanticsModifierKt.semantics(modifier3, false, (Function1) objRememberedValue2);
                gapComposer.end(false);
                modifier2 = modifierSemantics;
            } else {
                gapComposer.startReplaceGroup(-536844101);
                gapComposer.end(false);
                modifier2 = modifier3;
            }
            if (!Size.m384equalsimpl0(painter.mo492getIntrinsicSizeNHjbRc(), 9205357640488583168L)) {
                long jMo492getIntrinsicSizeNHjbRc = painter.mo492getIntrinsicSizeNHjbRc();
                if (Float.isInfinite(Float.intBitsToFloat((int) (jMo492getIntrinsicSizeNHjbRc >> 32))) && Float.isInfinite(Float.intBitsToFloat((int) (jMo492getIntrinsicSizeNHjbRc & 4294967295L)))) {
                    modifier3 = DefaultIconSizeModifier;
                }
            } else {
                modifier3 = DefaultIconSizeModifier;
            }
            BoxKt.Box(ClipKt.paint$default(modifier.then(modifier3), painter, null, ContentScale.Companion.Fit, 0.0f, blendModeColorFilter, 22).then(modifier2), gapComposer, 0);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new IconKt$$ExternalSyntheticLambda2(painter, str, modifier, j, i);
        }
    }
}
