package androidx.compose.animation;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.TwoWayConverterImpl;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.navigation.Navigator;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class SingleValueAnimationKt {
    public static final SpringSpec colorDefaultSpring = ArcSplineKt.spring$default(0.0f, 0.0f, null, 7);

    /* JADX INFO: renamed from: animateColorAsState-euL9pac, reason: not valid java name */
    public static final State m26animateColorAsStateeuL9pac(long j, FiniteAnimationSpec finiteAnimationSpec, String str, GapComposer gapComposer, int i, int i2) {
        if ((i2 & 2) != 0) {
            finiteAnimationSpec = colorDefaultSpring;
        }
        FiniteAnimationSpec finiteAnimationSpec2 = finiteAnimationSpec;
        if ((i2 & 4) != 0) {
            str = "ColorAnimation";
        }
        String str2 = str;
        boolean zChanged = gapComposer.changed(Color.m438getColorSpaceimpl(j));
        Object objRememberedValue = gapComposer.rememberedValue();
        if (zChanged || objRememberedValue == Composer$Companion.Empty) {
            TwoWayConverterImpl twoWayConverterImpl = new TwoWayConverterImpl(CrossfadeKt$Crossfade$3$1.INSTANCE$3, new Navigator.AnonymousClass1(3, Color.m438getColorSpaceimpl(j)));
            gapComposer.updateRememberedValue(twoWayConverterImpl);
            objRememberedValue = twoWayConverterImpl;
        }
        return AnimateAsStateKt.animateValueAsState(new Color(j), (TwoWayConverterImpl) objRememberedValue, finiteAnimationSpec2, null, str2, gapComposer, ((i << 3) & 896) | ((i << 6) & 57344), 8);
    }
}
