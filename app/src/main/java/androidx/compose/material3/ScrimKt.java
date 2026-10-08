package androidx.compose.material3;

import android.view.View;
import androidx.activity.ImmLeaksCleaner$$ExternalSyntheticLambda0;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.FocusInteraction$Focus;
import androidx.compose.foundation.interaction.HoverInteraction$Enter;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.SizeElement;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.AccessibilityUtilKt$$ExternalSyntheticLambda0;
import androidx.compose.material3.internal.ChildSemanticsNodeElement;
import androidx.compose.material3.internal.LayoutUtilKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.material3.internal.TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0;
import androidx.compose.material3.tokens.ButtonSmallTokens;
import androidx.compose.material3.tokens.DialogTokens;
import androidx.compose.material3.tokens.FilledButtonTokens;
import androidx.compose.material3.tokens.SmallIconButtonTokens;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.DynamicProvidableCompositionLocal;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda0;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendPointerInputElement;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.RulerKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetModifier$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayout$1;
import androidx.compose.ui.platform.AccessibilityManager;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda10;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.DialogProperties;
import coil.RealImageLoader$execute$3;
import coil.network.HttpException;
import coil.request.RequestService;
import com.koala.clash.R;
import dev.chrisbanes.haze.BlurEffectKt$$ExternalSyntheticLambda1;
import java.util.ArrayList;
import java.util.UUID;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ScrimKt {
    public static final ComposableLambdaImpl lambda$2094288676 = new ComposableLambdaImpl(2094288676, new SaversKt$$ExternalSyntheticLambda0(6), false);

    /* JADX INFO: renamed from: lambda$-1342205566, reason: not valid java name */
    public static final ComposableLambdaImpl f5lambda$1342205566 = new ComposableLambdaImpl(-1342205566, new AccessibilityUtilKt$$ExternalSyntheticLambda0(2), false);
    public static final ComposableLambdaImpl lambda$1121996006 = new ComposableLambdaImpl(1121996006, new SaversKt$$ExternalSyntheticLambda0(7), false);

    /* JADX INFO: renamed from: lambda$-91331245, reason: not valid java name */
    public static final ComposableLambdaImpl f8lambda$91331245 = new ComposableLambdaImpl(-91331245, new SaversKt$$ExternalSyntheticLambda0(8), false);

    /* JADX INFO: renamed from: lambda$-39202156, reason: not valid java name */
    public static final ComposableLambdaImpl f7lambda$39202156 = new ComposableLambdaImpl(-39202156, new SaversKt$$ExternalSyntheticLambda0(9), false);
    public static final ComposableLambdaImpl lambda$1582488484 = new ComposableLambdaImpl(1582488484, new SaversKt$$ExternalSyntheticLambda0(10), false);
    public static final ComposableLambdaImpl lambda$414328099 = new ComposableLambdaImpl(414328099, new SaversKt$$ExternalSyntheticLambda0(11), false);

    /* JADX INFO: renamed from: lambda$-1514016380, reason: not valid java name */
    public static final ComposableLambdaImpl f6lambda$1514016380 = new ComposableLambdaImpl(-1514016380, new SaversKt$$ExternalSyntheticLambda0(12), false);

    /* JADX WARN: Code duplicated, block: B:101:0x0120  */
    /* JADX WARN: Code duplicated, block: B:103:0x0130  */
    /* JADX WARN: Code duplicated, block: B:119:0x0165  */
    /* JADX WARN: Code duplicated, block: B:121:0x0168  */
    /* JADX WARN: Code duplicated, block: B:123:0x016b  */
    /* JADX WARN: Code duplicated, block: B:126:0x0170  */
    /* JADX WARN: Code duplicated, block: B:127:0x017b  */
    /* JADX WARN: Code duplicated, block: B:130:0x0181  */
    /* JADX WARN: Code duplicated, block: B:133:0x0199  */
    /* JADX WARN: Code duplicated, block: B:134:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:137:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:138:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:141:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:144:0x020e  */
    /* JADX WARN: Code duplicated, block: B:146:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x0056  */
    /* JADX WARN: Code duplicated, block: B:33:0x005b  */
    /* JADX WARN: Code duplicated, block: B:35:0x005f  */
    /* JADX WARN: Code duplicated, block: B:37:0x0067  */
    /* JADX WARN: Code duplicated, block: B:38:0x006a  */
    /* JADX WARN: Code duplicated, block: B:42:0x0072  */
    /* JADX WARN: Code duplicated, block: B:44:0x007a  */
    /* JADX WARN: Code duplicated, block: B:45:0x007d  */
    /* JADX WARN: Code duplicated, block: B:47:0x0081  */
    /* JADX WARN: Code duplicated, block: B:50:0x0088  */
    /* JADX WARN: Code duplicated, block: B:52:0x0090  */
    /* JADX WARN: Code duplicated, block: B:53:0x0093  */
    /* JADX WARN: Code duplicated, block: B:55:0x0098  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:63:0x00af A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:66:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:69:0x00be  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:74:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:79:0x00da  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:91:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:94:0x010e  */
    /* JADX WARN: Code duplicated, block: B:98:0x0117  */
    /* JADX INFO: renamed from: AlertDialog-Oix01E0, reason: not valid java name */
    public static final void m263AlertDialogOix01E0(Function0 function0, ComposableLambdaImpl composableLambdaImpl, Modifier modifier, Function2 function2, Function2 function3, Function2 function4, Function2 function5, Shape shape, long j, long j2, long j3, long j4, float f, DialogProperties dialogProperties, GapComposer gapComposer, int i, int i2) {
        int i3;
        Function2 function6;
        int i4;
        Function2 function7;
        int i5;
        long value;
        int i6;
        int i7;
        int i8;
        boolean z;
        Modifier modifier2;
        long j5;
        long j6;
        float f2;
        DialogProperties dialogProperties2;
        Function2 function8;
        long j7;
        Function2 function9;
        Shape shape2;
        long j8;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        Shape value2;
        long value3;
        long value4;
        Modifier modifier3;
        Shape shape3;
        int i9;
        Function2 function10;
        long j9;
        float f3;
        DialogProperties dialogProperties3;
        long j10;
        Function2 function11;
        long j11;
        int i10;
        int i11;
        int i12;
        gapComposer.startRestartGroup(94478519);
        if ((i & 6) == 0) {
            i3 = (gapComposer.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= gapComposer.changedInstance(composableLambdaImpl) ? 32 : 16;
        }
        int i13 = i3 | 384;
        int i14 = i2 & 8;
        if (i14 == 0) {
            if ((i & 3072) == 0) {
                function6 = function2;
                i13 |= gapComposer.changedInstance(function6) ? 2048 : 1024;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    function7 = function3;
                    if (gapComposer.changedInstance(function7)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i13 |= i5;
                }
                if ((196608 & i) != 0) {
                    if (gapComposer.changedInstance(function4)) {
                        i12 = 131072;
                    } else {
                        i12 = 65536;
                    }
                    i13 |= i12;
                }
                if ((1572864 & i) != 0) {
                    if (gapComposer.changedInstance(function5)) {
                        i11 = 1048576;
                    } else {
                        i11 = 524288;
                    }
                    i13 |= i11;
                }
                if ((i & 12582912) != 0) {
                    i13 |= ((i2 & 128) == 0 || !gapComposer.changed(shape)) ? 4194304 : 8388608;
                }
                if ((i & 100663296) == 0) {
                    value = j;
                    if ((i2 & 256) == 0 || !gapComposer.changed(value)) {
                        i10 = 33554432;
                    } else {
                        i10 = 67108864;
                    }
                    i13 |= i10;
                } else {
                    value = j;
                }
                if ((i & 805306368) == 0) {
                    i13 |= 268435456;
                }
                if ((i2 & 1024) == 0 || !gapComposer.changed(j3)) {
                    i6 = 2;
                } else {
                    i6 = 4;
                }
                if ((i2 & 2048) == 0 || !gapComposer.changed(j4)) {
                    i7 = 16;
                } else {
                    i7 = 32;
                }
                i8 = i6 | i7 | 3456;
                if ((i13 & 306783379) == 306783378 || (i8 & 1171) != 1170) {
                    z = true;
                } else {
                    z = false;
                }
                if (gapComposer.shouldExecute(i13 & 1, z)) {
                    gapComposer.startDefaults();
                    if ((i & 1) != 0 || gapComposer.getDefaultsInvalid()) {
                        if (i14 != 0) {
                            function6 = null;
                        }
                        if (i4 != 0) {
                            function7 = null;
                        }
                        if ((i2 & 128) != 0) {
                            float f4 = AlertDialogDefaults.TonalElevation;
                            value2 = ShapesKt.getValue(DialogTokens.ContainerShape, gapComposer);
                            i13 &= -29360129;
                        } else {
                            value2 = shape;
                        }
                        if ((i2 & 256) != 0) {
                            float f5 = AlertDialogDefaults.TonalElevation;
                            int i15 = DialogTokens.ContainerShape;
                            value = ColorSchemeKt.getValue(38, gapComposer);
                            i13 &= -234881025;
                        }
                        float f6 = AlertDialogDefaults.TonalElevation;
                        long value5 = ColorSchemeKt.getValue(DialogTokens.IconColor, gapComposer);
                        int i16 = (-1879048193) & i13;
                        if ((i2 & 1024) != 0) {
                            value3 = ColorSchemeKt.getValue(DialogTokens.HeadlineColor, gapComposer);
                            i8 &= -15;
                        } else {
                            value3 = j3;
                        }
                        if ((i2 & 2048) != 0) {
                            value4 = ColorSchemeKt.getValue(DialogTokens.SupportingTextColor, gapComposer);
                            i8 &= -113;
                        } else {
                            value4 = j4;
                        }
                        float f7 = AlertDialogDefaults.TonalElevation;
                        DialogProperties dialogProperties4 = new DialogProperties();
                        modifier3 = Modifier.Companion.$$INSTANCE;
                        shape3 = value2;
                        i9 = i16;
                        function10 = function6;
                        j9 = value4;
                        long j12 = value3;
                        f3 = f7;
                        dialogProperties3 = dialogProperties4;
                        j10 = value5;
                        function11 = function7;
                        j11 = j12;
                    } else {
                        gapComposer.skipToGroupEnd();
                        if ((i2 & 128) != 0) {
                            i13 &= -29360129;
                        }
                        if ((i2 & 256) != 0) {
                            i13 &= -234881025;
                        }
                        i9 = i13 & (-1879048193);
                        if ((i2 & 1024) != 0) {
                            i8 &= -15;
                        }
                        if ((i2 & 2048) != 0) {
                            i8 &= -113;
                        }
                        modifier3 = modifier;
                        shape3 = shape;
                        j10 = j2;
                        j9 = j4;
                        f3 = f;
                        dialogProperties3 = dialogProperties;
                        function10 = function6;
                        function11 = function7;
                        j11 = j3;
                    }
                    gapComposer.endDefaults();
                    Modifier modifier4 = modifier3;
                    AlertDialogKt.m235AlertDialogImplwrnwzgE(function0, composableLambdaImpl, modifier4, function10, function11, function4, function5, shape3, value, j10, j11, j9, f3, dialogProperties3, gapComposer, i9 & 2147483646, i8 & 8190);
                    function9 = function11;
                    dialogProperties2 = dialogProperties3;
                    function8 = function10;
                    f2 = f3;
                    modifier2 = modifier4;
                    j6 = j9;
                    j8 = j11;
                    j5 = j10;
                    j7 = value;
                    shape2 = shape3;
                } else {
                    gapComposer.skipToGroupEnd();
                    modifier2 = modifier;
                    j5 = j2;
                    j6 = j4;
                    f2 = f;
                    dialogProperties2 = dialogProperties;
                    function8 = function6;
                    j7 = value;
                    function9 = function7;
                    shape2 = shape;
                    j8 = j3;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new AlertDialogKt$$ExternalSyntheticLambda2(function0, composableLambdaImpl, modifier2, function8, function9, function4, function5, shape2, j7, j5, j8, j6, f2, dialogProperties2, i, i2, 1);
                }
            }
            i13 |= 24576;
            function7 = function3;
            if ((196608 & i) != 0) {
                if (gapComposer.changedInstance(function4)) {
                    i12 = 131072;
                } else {
                    i12 = 65536;
                }
                i13 |= i12;
            }
            if ((1572864 & i) != 0) {
                if (gapComposer.changedInstance(function5)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i13 |= i11;
            }
            if ((i & 12582912) != 0) {
                i13 |= ((i2 & 128) == 0 || !gapComposer.changed(shape)) ? 4194304 : 8388608;
            }
            if ((i & 100663296) == 0) {
                value = j;
                if ((i2 & 256) == 0) {
                    i10 = 33554432;
                } else {
                    i10 = 33554432;
                }
                i13 |= i10;
            } else {
                value = j;
            }
            if ((i & 805306368) == 0) {
                i13 |= 268435456;
            }
            if ((i2 & 1024) == 0) {
                i6 = 2;
            } else {
                i6 = 2;
            }
            if ((i2 & 2048) == 0) {
                i7 = 16;
            } else {
                i7 = 16;
            }
            i8 = i6 | i7 | 3456;
            if ((i13 & 306783379) == 306783378) {
                z = true;
            } else {
                z = true;
            }
            if (gapComposer.shouldExecute(i13 & 1, z)) {
                gapComposer.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        function6 = null;
                    }
                    if (i4 != 0) {
                        function7 = null;
                    }
                    if ((i2 & 128) != 0) {
                        float f8 = AlertDialogDefaults.TonalElevation;
                        value2 = ShapesKt.getValue(DialogTokens.ContainerShape, gapComposer);
                        i13 &= -29360129;
                    } else {
                        value2 = shape;
                    }
                    if ((i2 & 256) != 0) {
                        float f9 = AlertDialogDefaults.TonalElevation;
                        int i17 = DialogTokens.ContainerShape;
                        value = ColorSchemeKt.getValue(38, gapComposer);
                        i13 &= -234881025;
                    }
                    float f10 = AlertDialogDefaults.TonalElevation;
                    long value6 = ColorSchemeKt.getValue(DialogTokens.IconColor, gapComposer);
                    int i18 = (-1879048193) & i13;
                    if ((i2 & 1024) != 0) {
                        value3 = ColorSchemeKt.getValue(DialogTokens.HeadlineColor, gapComposer);
                        i8 &= -15;
                    } else {
                        value3 = j3;
                    }
                    if ((i2 & 2048) != 0) {
                        value4 = ColorSchemeKt.getValue(DialogTokens.SupportingTextColor, gapComposer);
                        i8 &= -113;
                    } else {
                        value4 = j4;
                    }
                    float f11 = AlertDialogDefaults.TonalElevation;
                    DialogProperties dialogProperties5 = new DialogProperties();
                    modifier3 = Modifier.Companion.$$INSTANCE;
                    shape3 = value2;
                    i9 = i18;
                    function10 = function6;
                    j9 = value4;
                    long j13 = value3;
                    f3 = f11;
                    dialogProperties3 = dialogProperties5;
                    j10 = value6;
                    function11 = function7;
                    j11 = j13;
                } else {
                    if (i14 != 0) {
                        function6 = null;
                    }
                    if (i4 != 0) {
                        function7 = null;
                    }
                    if ((i2 & 128) != 0) {
                        float f12 = AlertDialogDefaults.TonalElevation;
                        value2 = ShapesKt.getValue(DialogTokens.ContainerShape, gapComposer);
                        i13 &= -29360129;
                    } else {
                        value2 = shape;
                    }
                    if ((i2 & 256) != 0) {
                        float f13 = AlertDialogDefaults.TonalElevation;
                        int i19 = DialogTokens.ContainerShape;
                        value = ColorSchemeKt.getValue(38, gapComposer);
                        i13 &= -234881025;
                    }
                    float f14 = AlertDialogDefaults.TonalElevation;
                    long value7 = ColorSchemeKt.getValue(DialogTokens.IconColor, gapComposer);
                    int i110 = (-1879048193) & i13;
                    if ((i2 & 1024) != 0) {
                        value3 = ColorSchemeKt.getValue(DialogTokens.HeadlineColor, gapComposer);
                        i8 &= -15;
                    } else {
                        value3 = j3;
                    }
                    if ((i2 & 2048) != 0) {
                        value4 = ColorSchemeKt.getValue(DialogTokens.SupportingTextColor, gapComposer);
                        i8 &= -113;
                    } else {
                        value4 = j4;
                    }
                    float f15 = AlertDialogDefaults.TonalElevation;
                    DialogProperties dialogProperties6 = new DialogProperties();
                    modifier3 = Modifier.Companion.$$INSTANCE;
                    shape3 = value2;
                    i9 = i110;
                    function10 = function6;
                    j9 = value4;
                    long j14 = value3;
                    f3 = f15;
                    dialogProperties3 = dialogProperties6;
                    j10 = value7;
                    function11 = function7;
                    j11 = j14;
                }
                gapComposer.endDefaults();
                Modifier modifier5 = modifier3;
                AlertDialogKt.m235AlertDialogImplwrnwzgE(function0, composableLambdaImpl, modifier5, function10, function11, function4, function5, shape3, value, j10, j11, j9, f3, dialogProperties3, gapComposer, i9 & 2147483646, i8 & 8190);
                function9 = function11;
                dialogProperties2 = dialogProperties3;
                function8 = function10;
                f2 = f3;
                modifier2 = modifier5;
                j6 = j9;
                j8 = j11;
                j5 = j10;
                j7 = value;
                shape2 = shape3;
            } else {
                gapComposer.skipToGroupEnd();
                modifier2 = modifier;
                j5 = j2;
                j6 = j4;
                f2 = f;
                dialogProperties2 = dialogProperties;
                function8 = function6;
                j7 = value;
                function9 = function7;
                shape2 = shape;
                j8 = j3;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new AlertDialogKt$$ExternalSyntheticLambda2(function0, composableLambdaImpl, modifier2, function8, function9, function4, function5, shape2, j7, j5, j8, j6, f2, dialogProperties2, i, i2, 1);
            }
        }
        i13 = i3 | 3456;
        function6 = function2;
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                function7 = function3;
                if (gapComposer.changedInstance(function7)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i13 |= i5;
            }
            if ((196608 & i) != 0) {
                if (gapComposer.changedInstance(function4)) {
                    i12 = 131072;
                } else {
                    i12 = 65536;
                }
                i13 |= i12;
            }
            if ((1572864 & i) != 0) {
                if (gapComposer.changedInstance(function5)) {
                    i11 = 1048576;
                } else {
                    i11 = 524288;
                }
                i13 |= i11;
            }
            if ((i & 12582912) != 0) {
                i13 |= ((i2 & 128) == 0 || !gapComposer.changed(shape)) ? 4194304 : 8388608;
            }
            if ((i & 100663296) == 0) {
                value = j;
                if ((i2 & 256) == 0) {
                    i10 = 33554432;
                } else {
                    i10 = 33554432;
                }
                i13 |= i10;
            } else {
                value = j;
            }
            if ((i & 805306368) == 0) {
                i13 |= 268435456;
            }
            if ((i2 & 1024) == 0) {
                i6 = 2;
            } else {
                i6 = 2;
            }
            if ((i2 & 2048) == 0) {
                i7 = 16;
            } else {
                i7 = 16;
            }
            i8 = i6 | i7 | 3456;
            if ((i13 & 306783379) == 306783378) {
                z = true;
            } else {
                z = true;
            }
            if (gapComposer.shouldExecute(i13 & 1, z)) {
                gapComposer.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        function6 = null;
                    }
                    if (i4 != 0) {
                        function7 = null;
                    }
                    if ((i2 & 128) != 0) {
                        float f16 = AlertDialogDefaults.TonalElevation;
                        value2 = ShapesKt.getValue(DialogTokens.ContainerShape, gapComposer);
                        i13 &= -29360129;
                    } else {
                        value2 = shape;
                    }
                    if ((i2 & 256) != 0) {
                        float f17 = AlertDialogDefaults.TonalElevation;
                        int i111 = DialogTokens.ContainerShape;
                        value = ColorSchemeKt.getValue(38, gapComposer);
                        i13 &= -234881025;
                    }
                    float f18 = AlertDialogDefaults.TonalElevation;
                    long value8 = ColorSchemeKt.getValue(DialogTokens.IconColor, gapComposer);
                    int i112 = (-1879048193) & i13;
                    if ((i2 & 1024) != 0) {
                        value3 = ColorSchemeKt.getValue(DialogTokens.HeadlineColor, gapComposer);
                        i8 &= -15;
                    } else {
                        value3 = j3;
                    }
                    if ((i2 & 2048) != 0) {
                        value4 = ColorSchemeKt.getValue(DialogTokens.SupportingTextColor, gapComposer);
                        i8 &= -113;
                    } else {
                        value4 = j4;
                    }
                    float f19 = AlertDialogDefaults.TonalElevation;
                    DialogProperties dialogProperties7 = new DialogProperties();
                    modifier3 = Modifier.Companion.$$INSTANCE;
                    shape3 = value2;
                    i9 = i112;
                    function10 = function6;
                    j9 = value4;
                    long j15 = value3;
                    f3 = f19;
                    dialogProperties3 = dialogProperties7;
                    j10 = value8;
                    function11 = function7;
                    j11 = j15;
                } else {
                    if (i14 != 0) {
                        function6 = null;
                    }
                    if (i4 != 0) {
                        function7 = null;
                    }
                    if ((i2 & 128) != 0) {
                        float f110 = AlertDialogDefaults.TonalElevation;
                        value2 = ShapesKt.getValue(DialogTokens.ContainerShape, gapComposer);
                        i13 &= -29360129;
                    } else {
                        value2 = shape;
                    }
                    if ((i2 & 256) != 0) {
                        float f111 = AlertDialogDefaults.TonalElevation;
                        int i113 = DialogTokens.ContainerShape;
                        value = ColorSchemeKt.getValue(38, gapComposer);
                        i13 &= -234881025;
                    }
                    float f112 = AlertDialogDefaults.TonalElevation;
                    long value9 = ColorSchemeKt.getValue(DialogTokens.IconColor, gapComposer);
                    int i114 = (-1879048193) & i13;
                    if ((i2 & 1024) != 0) {
                        value3 = ColorSchemeKt.getValue(DialogTokens.HeadlineColor, gapComposer);
                        i8 &= -15;
                    } else {
                        value3 = j3;
                    }
                    if ((i2 & 2048) != 0) {
                        value4 = ColorSchemeKt.getValue(DialogTokens.SupportingTextColor, gapComposer);
                        i8 &= -113;
                    } else {
                        value4 = j4;
                    }
                    float f113 = AlertDialogDefaults.TonalElevation;
                    DialogProperties dialogProperties8 = new DialogProperties();
                    modifier3 = Modifier.Companion.$$INSTANCE;
                    shape3 = value2;
                    i9 = i114;
                    function10 = function6;
                    j9 = value4;
                    long j16 = value3;
                    f3 = f113;
                    dialogProperties3 = dialogProperties8;
                    j10 = value9;
                    function11 = function7;
                    j11 = j16;
                }
                gapComposer.endDefaults();
                Modifier modifier6 = modifier3;
                AlertDialogKt.m235AlertDialogImplwrnwzgE(function0, composableLambdaImpl, modifier6, function10, function11, function4, function5, shape3, value, j10, j11, j9, f3, dialogProperties3, gapComposer, i9 & 2147483646, i8 & 8190);
                function9 = function11;
                dialogProperties2 = dialogProperties3;
                function8 = function10;
                f2 = f3;
                modifier2 = modifier6;
                j6 = j9;
                j8 = j11;
                j5 = j10;
                j7 = value;
                shape2 = shape3;
            } else {
                gapComposer.skipToGroupEnd();
                modifier2 = modifier;
                j5 = j2;
                j6 = j4;
                f2 = f;
                dialogProperties2 = dialogProperties;
                function8 = function6;
                j7 = value;
                function9 = function7;
                shape2 = shape;
                j8 = j3;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new AlertDialogKt$$ExternalSyntheticLambda2(function0, composableLambdaImpl, modifier2, function8, function9, function4, function5, shape2, j7, j5, j8, j6, f2, dialogProperties2, i, i2, 1);
            }
        }
        i13 |= 24576;
        function7 = function3;
        if ((196608 & i) != 0) {
            if (gapComposer.changedInstance(function4)) {
                i12 = 131072;
            } else {
                i12 = 65536;
            }
            i13 |= i12;
        }
        if ((1572864 & i) != 0) {
            if (gapComposer.changedInstance(function5)) {
                i11 = 1048576;
            } else {
                i11 = 524288;
            }
            i13 |= i11;
        }
        if ((i & 12582912) != 0) {
            i13 |= ((i2 & 128) == 0 || !gapComposer.changed(shape)) ? 4194304 : 8388608;
        }
        if ((i & 100663296) == 0) {
            value = j;
            if ((i2 & 256) == 0) {
                i10 = 33554432;
            } else {
                i10 = 33554432;
            }
            i13 |= i10;
        } else {
            value = j;
        }
        if ((i & 805306368) == 0) {
            i13 |= 268435456;
        }
        if ((i2 & 1024) == 0) {
            i6 = 2;
        } else {
            i6 = 2;
        }
        if ((i2 & 2048) == 0) {
            i7 = 16;
        } else {
            i7 = 16;
        }
        i8 = i6 | i7 | 3456;
        if ((i13 & 306783379) == 306783378) {
            z = true;
        } else {
            z = true;
        }
        if (gapComposer.shouldExecute(i13 & 1, z)) {
            gapComposer.startDefaults();
            if ((i & 1) != 0) {
                if (i14 != 0) {
                    function6 = null;
                }
                if (i4 != 0) {
                    function7 = null;
                }
                if ((i2 & 128) != 0) {
                    float f114 = AlertDialogDefaults.TonalElevation;
                    value2 = ShapesKt.getValue(DialogTokens.ContainerShape, gapComposer);
                    i13 &= -29360129;
                } else {
                    value2 = shape;
                }
                if ((i2 & 256) != 0) {
                    float f115 = AlertDialogDefaults.TonalElevation;
                    int i115 = DialogTokens.ContainerShape;
                    value = ColorSchemeKt.getValue(38, gapComposer);
                    i13 &= -234881025;
                }
                float f116 = AlertDialogDefaults.TonalElevation;
                long value10 = ColorSchemeKt.getValue(DialogTokens.IconColor, gapComposer);
                int i116 = (-1879048193) & i13;
                if ((i2 & 1024) != 0) {
                    value3 = ColorSchemeKt.getValue(DialogTokens.HeadlineColor, gapComposer);
                    i8 &= -15;
                } else {
                    value3 = j3;
                }
                if ((i2 & 2048) != 0) {
                    value4 = ColorSchemeKt.getValue(DialogTokens.SupportingTextColor, gapComposer);
                    i8 &= -113;
                } else {
                    value4 = j4;
                }
                float f117 = AlertDialogDefaults.TonalElevation;
                DialogProperties dialogProperties9 = new DialogProperties();
                modifier3 = Modifier.Companion.$$INSTANCE;
                shape3 = value2;
                i9 = i116;
                function10 = function6;
                j9 = value4;
                long j17 = value3;
                f3 = f117;
                dialogProperties3 = dialogProperties9;
                j10 = value10;
                function11 = function7;
                j11 = j17;
            } else {
                if (i14 != 0) {
                    function6 = null;
                }
                if (i4 != 0) {
                    function7 = null;
                }
                if ((i2 & 128) != 0) {
                    float f118 = AlertDialogDefaults.TonalElevation;
                    value2 = ShapesKt.getValue(DialogTokens.ContainerShape, gapComposer);
                    i13 &= -29360129;
                } else {
                    value2 = shape;
                }
                if ((i2 & 256) != 0) {
                    float f119 = AlertDialogDefaults.TonalElevation;
                    int i117 = DialogTokens.ContainerShape;
                    value = ColorSchemeKt.getValue(38, gapComposer);
                    i13 &= -234881025;
                }
                float f1110 = AlertDialogDefaults.TonalElevation;
                long value11 = ColorSchemeKt.getValue(DialogTokens.IconColor, gapComposer);
                int i118 = (-1879048193) & i13;
                if ((i2 & 1024) != 0) {
                    value3 = ColorSchemeKt.getValue(DialogTokens.HeadlineColor, gapComposer);
                    i8 &= -15;
                } else {
                    value3 = j3;
                }
                if ((i2 & 2048) != 0) {
                    value4 = ColorSchemeKt.getValue(DialogTokens.SupportingTextColor, gapComposer);
                    i8 &= -113;
                } else {
                    value4 = j4;
                }
                float f1111 = AlertDialogDefaults.TonalElevation;
                DialogProperties dialogProperties10 = new DialogProperties();
                modifier3 = Modifier.Companion.$$INSTANCE;
                shape3 = value2;
                i9 = i118;
                function10 = function6;
                j9 = value4;
                long j18 = value3;
                f3 = f1111;
                dialogProperties3 = dialogProperties10;
                j10 = value11;
                function11 = function7;
                j11 = j18;
            }
            gapComposer.endDefaults();
            Modifier modifier7 = modifier3;
            AlertDialogKt.m235AlertDialogImplwrnwzgE(function0, composableLambdaImpl, modifier7, function10, function11, function4, function5, shape3, value, j10, j11, j9, f3, dialogProperties3, gapComposer, i9 & 2147483646, i8 & 8190);
            function9 = function11;
            dialogProperties2 = dialogProperties3;
            function8 = function10;
            f2 = f3;
            modifier2 = modifier7;
            j6 = j9;
            j8 = j11;
            j5 = j10;
            j7 = value;
            shape2 = shape3;
        } else {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
            j5 = j2;
            j6 = j4;
            f2 = f;
            dialogProperties2 = dialogProperties;
            function8 = function6;
            j7 = value;
            function9 = function7;
            shape2 = shape;
            j8 = j3;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AlertDialogKt$$ExternalSyntheticLambda2(function0, composableLambdaImpl, modifier2, function8, function9, function4, function5, shape2, j7, j5, j8, j6, f2, dialogProperties2, i, i2, 1);
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0117  */
    /* JADX WARN: Code duplicated, block: B:103:0x0121  */
    /* JADX WARN: Code duplicated, block: B:110:0x0133 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:111:0x0135  */
    /* JADX WARN: Code duplicated, block: B:113:0x013a  */
    /* JADX WARN: Code duplicated, block: B:116:0x0140  */
    /* JADX WARN: Code duplicated, block: B:117:0x0153  */
    /* JADX WARN: Code duplicated, block: B:119:0x0157  */
    /* JADX WARN: Code duplicated, block: B:123:0x016f  */
    /* JADX WARN: Code duplicated, block: B:126:0x0180  */
    /* JADX WARN: Code duplicated, block: B:127:0x0183  */
    /* JADX WARN: Code duplicated, block: B:130:0x0188  */
    /* JADX WARN: Code duplicated, block: B:132:0x018d  */
    /* JADX WARN: Code duplicated, block: B:134:0x0192  */
    /* JADX WARN: Code duplicated, block: B:135:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:137:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:140:0x01d1 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:143:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:146:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:147:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:149:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:150:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:152:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:153:0x0202  */
    /* JADX WARN: Code duplicated, block: B:155:0x0206  */
    /* JADX WARN: Code duplicated, block: B:156:0x0209  */
    /* JADX WARN: Code duplicated, block: B:159:0x0211  */
    /* JADX WARN: Code duplicated, block: B:160:0x0226  */
    /* JADX WARN: Code duplicated, block: B:163:0x023f  */
    /* JADX WARN: Code duplicated, block: B:165:0x0245  */
    /* JADX WARN: Code duplicated, block: B:171:0x0256  */
    /* JADX WARN: Code duplicated, block: B:173:0x025c  */
    /* JADX WARN: Code duplicated, block: B:179:0x0270 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:182:0x0278  */
    /* JADX WARN: Code duplicated, block: B:185:0x029b  */
    /* JADX WARN: Code duplicated, block: B:186:0x02a6  */
    /* JADX WARN: Code duplicated, block: B:189:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:192:0x02d7  */
    /* JADX WARN: Code duplicated, block: B:194:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:196:0x02f4  */
    /* JADX WARN: Code duplicated, block: B:198:0x034a  */
    /* JADX WARN: Code duplicated, block: B:201:0x0357  */
    /* JADX WARN: Code duplicated, block: B:203:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0041  */
    /* JADX WARN: Code duplicated, block: B:25:0x0046  */
    /* JADX WARN: Code duplicated, block: B:27:0x004a  */
    /* JADX WARN: Code duplicated, block: B:29:0x0052  */
    /* JADX WARN: Code duplicated, block: B:30:0x0055  */
    /* JADX WARN: Code duplicated, block: B:34:0x005e  */
    /* JADX WARN: Code duplicated, block: B:36:0x0064  */
    /* JADX WARN: Code duplicated, block: B:37:0x0067  */
    /* JADX WARN: Code duplicated, block: B:41:0x006e  */
    /* JADX WARN: Code duplicated, block: B:43:0x0074  */
    /* JADX WARN: Code duplicated, block: B:44:0x0077  */
    /* JADX WARN: Code duplicated, block: B:48:0x007f  */
    /* JADX WARN: Code duplicated, block: B:50:0x0083  */
    /* JADX WARN: Code duplicated, block: B:52:0x008b  */
    /* JADX WARN: Code duplicated, block: B:53:0x008e  */
    /* JADX WARN: Code duplicated, block: B:56:0x0094  */
    /* JADX WARN: Code duplicated, block: B:59:0x009d  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:64:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:69:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:70:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:74:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:75:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:80:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:82:0x00db  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:85:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:89:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:91:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:92:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:94:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:97:0x010b  */
    /* JADX WARN: Code duplicated, block: B:98:0x010e  */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v14, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v21 */
    public static final void Button(final Function0 function0, Modifier modifier, boolean z, final Shape shape, ButtonColors buttonColors, ButtonElevation buttonElevation, PaddingValues paddingValues, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        ButtonElevation buttonElevation2;
        int i6;
        int i7;
        PaddingValues paddingValues2;
        int i8;
        int i9;
        boolean z3;
        Modifier modifier3;
        PaddingValues paddingValues3;
        boolean z4;
        ButtonElevation buttonElevation3;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        ButtonElevation buttonElevation4;
        PaddingValues paddingValues4;
        Object objRememberedValue;
        Object obj;
        MutableInteractionSourceImpl mutableInteractionSourceImpl;
        int i10;
        long j;
        long j2;
        Object objRememberedValue2;
        SnapshotStateList snapshotStateList;
        boolean zChanged;
        Object objRememberedValue3;
        Interaction interaction;
        float f;
        Object objRememberedValue4;
        Animatable animatable;
        boolean zChangedInstance;
        Object objRememberedValue5;
        boolean z5;
        ButtonElevation buttonElevation5;
        AnimationState animationState;
        ?? r6;
        float f2;
        Object objRememberedValue6;
        final MutableInteractionSourceImpl mutableInteractionSourceImpl2;
        Object objRememberedValue7;
        int i11;
        int i12;
        int i13;
        gapComposer.startRestartGroup(-1310015664);
        if ((i & 6) == 0) {
            i3 = (gapComposer.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i14 = i2 & 2;
        if (i14 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= gapComposer.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    z2 = z;
                    if (gapComposer.changed(z2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i & 3072) == 0) {
                    if (gapComposer.changed(shape)) {
                        i13 = 2048;
                    } else {
                        i13 = 1024;
                    }
                    i3 |= i13;
                }
                if ((i & 24576) == 0) {
                    if (gapComposer.changed(buttonColors)) {
                        i12 = 16384;
                    } else {
                        i12 = 8192;
                    }
                    i3 |= i12;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        buttonElevation2 = buttonElevation;
                        int i15 = gapComposer.changed(buttonElevation2) ? 131072 : 65536;
                        i3 |= i15;
                    } else {
                        buttonElevation2 = buttonElevation;
                    }
                    i3 |= i15;
                } else {
                    buttonElevation2 = buttonElevation;
                }
                if ((i2 & 64) != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (gapComposer.changed((Object) null)) {
                        i6 = 1048576;
                    } else {
                        i6 = 524288;
                    }
                    i3 |= i6;
                }
                i7 = i2 & 128;
                if (i7 != 0) {
                    i3 |= 12582912;
                    paddingValues2 = paddingValues;
                } else {
                    paddingValues2 = paddingValues;
                    if ((i & 12582912) == 0) {
                        if (gapComposer.changed(paddingValues2)) {
                            i8 = 8388608;
                        } else {
                            i8 = 4194304;
                        }
                        i3 |= i8;
                    }
                }
                if ((i2 & 256) != 0) {
                    i3 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    if (gapComposer.changed((Object) null)) {
                        i9 = 67108864;
                    } else {
                        i9 = 33554432;
                    }
                    i3 |= i9;
                }
                if ((805306368 & i) != 0) {
                    if (gapComposer.changedInstance(composableLambdaImpl)) {
                        i11 = 536870912;
                    } else {
                        i11 = 268435456;
                    }
                    i3 |= i11;
                }
                if ((i3 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (gapComposer.shouldExecute(i3 & 1, z3)) {
                    gapComposer.startDefaults();
                    if ((i & 1) != 0 || gapComposer.getDefaultsInvalid()) {
                        if (i14 != 0) {
                            modifier2 = Modifier.Companion.$$INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 32) != 0) {
                            PaddingValuesImpl paddingValuesImpl = ButtonDefaults.ContentPadding;
                            buttonElevation4 = new ButtonElevation(FilledButtonTokens.ContainerElevation, FilledButtonTokens.PressedContainerElevation, FilledButtonTokens.FocusedContainerElevation, FilledButtonTokens.HoveredContainerElevation, FilledButtonTokens.DisabledContainerElevation);
                            i3 &= -458753;
                        } else {
                            buttonElevation4 = buttonElevation2;
                        }
                        if (i7 != 0) {
                            paddingValues2 = ButtonDefaults.ContentPadding;
                        }
                        paddingValues4 = paddingValues2;
                        buttonElevation2 = buttonElevation4;
                    } else {
                        gapComposer.skipToGroupEnd();
                        if ((i2 & 32) != 0) {
                            i3 &= -458753;
                        }
                        paddingValues4 = paddingValues2;
                    }
                    gapComposer.endDefaults();
                    gapComposer.startReplaceGroup(1691726283);
                    objRememberedValue = gapComposer.rememberedValue();
                    obj = Composer$Companion.Empty;
                    if (objRememberedValue == obj) {
                        objRememberedValue = new MutableInteractionSourceImpl();
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
                    gapComposer.end(false);
                    i10 = i3;
                    if (z2) {
                        j = buttonColors.containerColor;
                    } else {
                        j = buttonColors.disabledContainerColor;
                    }
                    Modifier modifier4 = modifier2;
                    if (z2) {
                        j2 = buttonColors.contentColor;
                    } else {
                        j2 = buttonColors.disabledContentColor;
                    }
                    long j3 = j2;
                    if (buttonElevation2 == null) {
                        gapComposer.startReplaceGroup(1691909926);
                        gapComposer.end(false);
                        mutableInteractionSourceImpl = mutableInteractionSourceImpl;
                        j = j;
                        z5 = z2;
                        buttonElevation5 = buttonElevation2;
                        animationState = null;
                        r6 = 0;
                    } else {
                        gapComposer.startReplaceGroup(-499611589);
                        int i16 = ((i10 >> 6) & 14) | ((i10 >> 9) & 896);
                        objRememberedValue2 = gapComposer.rememberedValue();
                        if (objRememberedValue2 == obj) {
                            objRememberedValue2 = new SnapshotStateList();
                            gapComposer.updateRememberedValue(objRememberedValue2);
                        }
                        snapshotStateList = (SnapshotStateList) objRememberedValue2;
                        zChanged = gapComposer.changed(mutableInteractionSourceImpl);
                        objRememberedValue3 = gapComposer.rememberedValue();
                        if (zChanged || objRememberedValue3 == obj) {
                            objRememberedValue3 = new RealImageLoader$execute$3(mutableInteractionSourceImpl, snapshotStateList, null, 18);
                            gapComposer.updateRememberedValue(objRememberedValue3);
                        }
                        Stack.LaunchedEffect(gapComposer, mutableInteractionSourceImpl, (Function2) objRememberedValue3);
                        interaction = (Interaction) CollectionsKt.lastOrNull(snapshotStateList);
                        if (!z2) {
                            f = buttonElevation2.disabledElevation;
                        } else if (interaction instanceof PressInteraction.Press) {
                            f = buttonElevation2.pressedElevation;
                        } else if (interaction instanceof HoverInteraction$Enter) {
                            f = buttonElevation2.hoveredElevation;
                        } else if (interaction instanceof FocusInteraction$Focus) {
                            f = buttonElevation2.focusedElevation;
                        } else {
                            f = buttonElevation2.defaultElevation;
                        }
                        objRememberedValue4 = gapComposer.rememberedValue();
                        if (objRememberedValue4 == obj) {
                            objRememberedValue4 = new Animatable(new Dp(f), ArcSplineKt.DpToVector, null, 12);
                            gapComposer.updateRememberedValue(objRememberedValue4);
                        }
                        animatable = (Animatable) objRememberedValue4;
                        Dp dp = new Dp(f);
                        zChangedInstance = gapComposer.changedInstance(animatable) | gapComposer.changed(f) | ((((i16 & 14) ^ 6) <= 4 && gapComposer.changed(z2)) || (i16 & 6) == 4) | ((((i16 & 896) ^ 384) <= 256 && gapComposer.changed(buttonElevation2)) || (i16 & 384) == 256) | gapComposer.changedInstance(interaction);
                        objRememberedValue5 = gapComposer.rememberedValue();
                        if (!zChangedInstance || objRememberedValue5 == obj) {
                            z5 = z2;
                            buttonElevation5 = buttonElevation2;
                            objRememberedValue5 = new ButtonElevation$animateElevation$2$1(animatable, f, z5, buttonElevation5, interaction, null);
                            gapComposer.updateRememberedValue(objRememberedValue5);
                        } else {
                            z5 = z2;
                            buttonElevation5 = buttonElevation2;
                        }
                        Stack.LaunchedEffect(gapComposer, dp, (Function2) objRememberedValue5);
                        animationState = animatable.internalState;
                        r6 = 0;
                        gapComposer.end(false);
                    }
                    if (animationState != null) {
                        f2 = ((Dp) animationState.value$delegate.getValue()).value;
                    } else {
                        f2 = (float) r6;
                    }
                    objRememberedValue6 = gapComposer.rememberedValue();
                    if (objRememberedValue6 == obj) {
                        objRememberedValue6 = new SaversKt$$ExternalSyntheticLambda10(7);
                        gapComposer.updateRememberedValue(objRememberedValue6);
                    }
                    final Modifier modifierSemantics = SemanticsModifierKt.semantics(modifier4, r6, (Function1) objRememberedValue6);
                    final ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Thread_jvmKt.rememberComposableLambda(-535639973, new ButtonKt$$ExternalSyntheticLambda2(j3, paddingValues4, composableLambdaImpl, 0), gapComposer);
                    DynamicProvidableCompositionLocal dynamicProvidableCompositionLocal = SurfaceKt.LocalAbsoluteTonalElevation;
                    float f3 = (float) r6;
                    if (mutableInteractionSourceImpl == null) {
                        gapComposer.startReplaceGroup(-1701074900);
                        objRememberedValue7 = gapComposer.rememberedValue();
                        if (objRememberedValue7 == obj) {
                            objRememberedValue7 = new MutableInteractionSourceImpl();
                            gapComposer.updateRememberedValue(objRememberedValue7);
                        }
                        gapComposer.end(false);
                        mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue7;
                    } else {
                        gapComposer.startReplaceGroup(2023335947);
                        gapComposer.end(false);
                        mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                    }
                    ProvidableCompositionLocal providableCompositionLocal = SurfaceKt.LocalAbsoluteTonalElevation;
                    final float f4 = ((Dp) gapComposer.consume(providableCompositionLocal)).value + f3;
                    final long j4 = j;
                    final float f5 = f2;
                    final boolean z6 = z5;
                    Stack.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.LocalContentColor.defaultProvidedValue$runtime(new Color(j3)), providableCompositionLocal.defaultProvidedValue$runtime(new Dp(f4))}, Thread_jvmKt.rememberComposableLambda(849208527, new Function2() { // from class: androidx.compose.material3.SurfaceKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            GapComposer gapComposer2 = (GapComposer) obj2;
                            int iIntValue = ((Integer) obj3).intValue();
                            if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                                HorizontalAlignmentLine horizontalAlignmentLine = InteractiveComponentSizeKt.MinimumInteractiveTopAlignmentLine;
                                Modifier modifierThen = modifierSemantics.then(MinimumInteractiveModifier.INSTANCE);
                                DynamicProvidableCompositionLocal dynamicProvidableCompositionLocal2 = RippleKt.LocalRippleThemeConfiguration;
                                boolean z7 = ((RippleThemeConfiguration) gapComposer2.consume(dynamicProvidableCompositionLocal2)).focus instanceof RippleThemeConfiguration$Focus$InsetRing;
                                MutableInteractionSourceImpl mutableInteractionSourceImpl3 = mutableInteractionSourceImpl2;
                                Shape shape2 = shape;
                                Modifier modifierIndication = Modifier.Companion.$$INSTANCE;
                                if (z7) {
                                    modifierIndication = IndicationKt.indication(modifierIndication, mutableInteractionSourceImpl3, RippleKt.m260rippleOu1YvPQ$default(0.0f, 0L, shape2, true, 7));
                                }
                                Modifier modifierThen2 = ImageKt.m50clickableO2vRcR0$default(SurfaceKt.m270surfaceXOJAsU(((Density) gapComposer2.consume(CompositionLocalsKt.LocalDensity)).mo92toPx0680j_4(f5), SurfaceKt.m271surfaceColorAtElevationCLU3JFs(j4, f4, gapComposer2), modifierThen.then(modifierIndication), shape2), mutableInteractionSourceImpl3, RippleKt.m260rippleOu1YvPQ$default(0.0f, 0L, shape2, !(((RippleThemeConfiguration) gapComposer2.consume(dynamicProvidableCompositionLocal2)).focus instanceof RippleThemeConfiguration$Focus$InsetRing), 215), z6, null, function0, 24).then(new ChildSemanticsNodeElement(new SaversKt$$ExternalSyntheticLambda10(17)));
                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, true);
                                long j5 = gapComposer2.compositeKeyHashCode;
                                int i17 = (int) (j5 ^ (j5 >>> 32));
                                PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                                Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierThen2);
                                ComposeUiNode.Companion.getClass();
                                LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                                gapComposer2.startReusableNode();
                                if (gapComposer2.inserting) {
                                    gapComposer2.createNode(layoutNode$Companion$Constructor$1);
                                } else {
                                    gapComposer2.useNode();
                                }
                                Stack.m295setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                                Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                                Stack.m295setimpl(gapComposer2, Integer.valueOf(i17), ComposeUiNode.Companion.SetCompositeKeyHash);
                                Stack.m294reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                                Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                                composableLambdaImplRememberComposableLambda.invoke((Object) gapComposer2, (Object) 0);
                                gapComposer2.end(true);
                            } else {
                                gapComposer2.skipToGroupEnd();
                            }
                            return Unit.INSTANCE;
                        }
                    }, gapComposer), gapComposer, 56);
                    modifier3 = modifier4;
                    paddingValues3 = paddingValues4;
                    z4 = z5;
                    buttonElevation3 = buttonElevation5;
                } else {
                    gapComposer.skipToGroupEnd();
                    modifier3 = modifier2;
                    paddingValues3 = paddingValues2;
                    z4 = z2;
                    buttonElevation3 = buttonElevation2;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new ButtonKt$$ExternalSyntheticLambda3(function0, modifier3, z4, shape, buttonColors, buttonElevation3, paddingValues3, composableLambdaImpl, i, i2);
                }
            }
            i3 |= 384;
            z2 = z;
            if ((i & 3072) == 0) {
                if (gapComposer.changed(shape)) {
                    i13 = 2048;
                } else {
                    i13 = 1024;
                }
                i3 |= i13;
            }
            if ((i & 24576) == 0) {
                if (gapComposer.changed(buttonColors)) {
                    i12 = 16384;
                } else {
                    i12 = 8192;
                }
                i3 |= i12;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    buttonElevation2 = buttonElevation;
                    if (gapComposer.changed(buttonElevation2)) {
                    }
                    i3 |= i15;
                } else {
                    buttonElevation2 = buttonElevation;
                }
                i3 |= i15;
            } else {
                buttonElevation2 = buttonElevation;
            }
            if ((i2 & 64) != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (gapComposer.changed((Object) null)) {
                    i6 = 1048576;
                } else {
                    i6 = 524288;
                }
                i3 |= i6;
            }
            i7 = i2 & 128;
            if (i7 != 0) {
                i3 |= 12582912;
                paddingValues2 = paddingValues;
            } else {
                paddingValues2 = paddingValues;
                if ((i & 12582912) == 0) {
                    if (gapComposer.changed(paddingValues2)) {
                        i8 = 8388608;
                    } else {
                        i8 = 4194304;
                    }
                    i3 |= i8;
                }
            }
            if ((i2 & 256) != 0) {
                i3 |= 100663296;
            } else if ((i & 100663296) == 0) {
                if (gapComposer.changed((Object) null)) {
                    i9 = 67108864;
                } else {
                    i9 = 33554432;
                }
                i3 |= i9;
            }
            if ((805306368 & i) != 0) {
                if (gapComposer.changedInstance(composableLambdaImpl)) {
                    i11 = 536870912;
                } else {
                    i11 = 268435456;
                }
                i3 |= i11;
            }
            if ((i3 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (gapComposer.shouldExecute(i3 & 1, z3)) {
                gapComposer.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion.$$INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 32) != 0) {
                        PaddingValuesImpl paddingValuesImpl2 = ButtonDefaults.ContentPadding;
                        buttonElevation4 = new ButtonElevation(FilledButtonTokens.ContainerElevation, FilledButtonTokens.PressedContainerElevation, FilledButtonTokens.FocusedContainerElevation, FilledButtonTokens.HoveredContainerElevation, FilledButtonTokens.DisabledContainerElevation);
                        i3 &= -458753;
                    } else {
                        buttonElevation4 = buttonElevation2;
                    }
                    if (i7 != 0) {
                        paddingValues2 = ButtonDefaults.ContentPadding;
                    }
                    paddingValues4 = paddingValues2;
                    buttonElevation2 = buttonElevation4;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion.$$INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 32) != 0) {
                        PaddingValuesImpl paddingValuesImpl3 = ButtonDefaults.ContentPadding;
                        buttonElevation4 = new ButtonElevation(FilledButtonTokens.ContainerElevation, FilledButtonTokens.PressedContainerElevation, FilledButtonTokens.FocusedContainerElevation, FilledButtonTokens.HoveredContainerElevation, FilledButtonTokens.DisabledContainerElevation);
                        i3 &= -458753;
                    } else {
                        buttonElevation4 = buttonElevation2;
                    }
                    if (i7 != 0) {
                        paddingValues2 = ButtonDefaults.ContentPadding;
                    }
                    paddingValues4 = paddingValues2;
                    buttonElevation2 = buttonElevation4;
                }
                gapComposer.endDefaults();
                gapComposer.startReplaceGroup(1691726283);
                objRememberedValue = gapComposer.rememberedValue();
                obj = Composer$Companion.Empty;
                if (objRememberedValue == obj) {
                    objRememberedValue = new MutableInteractionSourceImpl();
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
                gapComposer.end(false);
                i10 = i3;
                if (z2) {
                    j = buttonColors.containerColor;
                } else {
                    j = buttonColors.disabledContainerColor;
                }
                Modifier modifier5 = modifier2;
                if (z2) {
                    j2 = buttonColors.contentColor;
                } else {
                    j2 = buttonColors.disabledContentColor;
                }
                long j5 = j2;
                if (buttonElevation2 == null) {
                    gapComposer.startReplaceGroup(1691909926);
                    gapComposer.end(false);
                    mutableInteractionSourceImpl = mutableInteractionSourceImpl;
                    j = j;
                    z5 = z2;
                    buttonElevation5 = buttonElevation2;
                    animationState = null;
                    r6 = 0;
                } else {
                    gapComposer.startReplaceGroup(-499611589);
                    int i17 = ((i10 >> 6) & 14) | ((i10 >> 9) & 896);
                    objRememberedValue2 = gapComposer.rememberedValue();
                    if (objRememberedValue2 == obj) {
                        objRememberedValue2 = new SnapshotStateList();
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    snapshotStateList = (SnapshotStateList) objRememberedValue2;
                    zChanged = gapComposer.changed(mutableInteractionSourceImpl);
                    objRememberedValue3 = gapComposer.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new RealImageLoader$execute$3(mutableInteractionSourceImpl, snapshotStateList, null, 18);
                        gapComposer.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new RealImageLoader$execute$3(mutableInteractionSourceImpl, snapshotStateList, null, 18);
                        gapComposer.updateRememberedValue(objRememberedValue3);
                    }
                    Stack.LaunchedEffect(gapComposer, mutableInteractionSourceImpl, (Function2) objRememberedValue3);
                    interaction = (Interaction) CollectionsKt.lastOrNull(snapshotStateList);
                    if (!z2) {
                        f = buttonElevation2.disabledElevation;
                    } else if (interaction instanceof PressInteraction.Press) {
                        f = buttonElevation2.pressedElevation;
                    } else if (interaction instanceof HoverInteraction$Enter) {
                        f = buttonElevation2.hoveredElevation;
                    } else if (interaction instanceof FocusInteraction$Focus) {
                        f = buttonElevation2.focusedElevation;
                    } else {
                        f = buttonElevation2.defaultElevation;
                    }
                    objRememberedValue4 = gapComposer.rememberedValue();
                    if (objRememberedValue4 == obj) {
                        objRememberedValue4 = new Animatable(new Dp(f), ArcSplineKt.DpToVector, null, 12);
                        gapComposer.updateRememberedValue(objRememberedValue4);
                    }
                    animatable = (Animatable) objRememberedValue4;
                    Dp dp2 = new Dp(f);
                    zChangedInstance = gapComposer.changedInstance(animatable) | gapComposer.changed(f) | ((((i17 & 14) ^ 6) <= 4 && gapComposer.changed(z2)) || (i17 & 6) == 4) | ((((i17 & 896) ^ 384) <= 256 && gapComposer.changed(buttonElevation2)) || (i17 & 384) == 256) | gapComposer.changedInstance(interaction);
                    objRememberedValue5 = gapComposer.rememberedValue();
                    if (zChangedInstance) {
                        z5 = z2;
                        buttonElevation5 = buttonElevation2;
                        objRememberedValue5 = new ButtonElevation$animateElevation$2$1(animatable, f, z5, buttonElevation5, interaction, null);
                        gapComposer.updateRememberedValue(objRememberedValue5);
                    } else {
                        z5 = z2;
                        buttonElevation5 = buttonElevation2;
                        objRememberedValue5 = new ButtonElevation$animateElevation$2$1(animatable, f, z5, buttonElevation5, interaction, null);
                        gapComposer.updateRememberedValue(objRememberedValue5);
                    }
                    Stack.LaunchedEffect(gapComposer, dp2, (Function2) objRememberedValue5);
                    animationState = animatable.internalState;
                    r6 = 0;
                    gapComposer.end(false);
                }
                if (animationState != null) {
                    f2 = ((Dp) animationState.value$delegate.getValue()).value;
                } else {
                    f2 = (float) r6;
                }
                objRememberedValue6 = gapComposer.rememberedValue();
                if (objRememberedValue6 == obj) {
                    objRememberedValue6 = new SaversKt$$ExternalSyntheticLambda10(7);
                    gapComposer.updateRememberedValue(objRememberedValue6);
                }
                final Modifier modifierSemantics2 = SemanticsModifierKt.semantics(modifier5, r6, (Function1) objRememberedValue6);
                final ComposableLambdaImpl composableLambdaImplRememberComposableLambda2 = Thread_jvmKt.rememberComposableLambda(-535639973, new ButtonKt$$ExternalSyntheticLambda2(j5, paddingValues4, composableLambdaImpl, 0), gapComposer);
                DynamicProvidableCompositionLocal dynamicProvidableCompositionLocal2 = SurfaceKt.LocalAbsoluteTonalElevation;
                float f6 = (float) r6;
                if (mutableInteractionSourceImpl == null) {
                    gapComposer.startReplaceGroup(-1701074900);
                    objRememberedValue7 = gapComposer.rememberedValue();
                    if (objRememberedValue7 == obj) {
                        objRememberedValue7 = new MutableInteractionSourceImpl();
                        gapComposer.updateRememberedValue(objRememberedValue7);
                    }
                    gapComposer.end(false);
                    mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue7;
                } else {
                    gapComposer.startReplaceGroup(2023335947);
                    gapComposer.end(false);
                    mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                }
                ProvidableCompositionLocal providableCompositionLocal2 = SurfaceKt.LocalAbsoluteTonalElevation;
                final float f7 = ((Dp) gapComposer.consume(providableCompositionLocal2)).value + f6;
                final long j6 = j;
                final float f8 = f2;
                final boolean z7 = z5;
                Stack.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.LocalContentColor.defaultProvidedValue$runtime(new Color(j5)), providableCompositionLocal2.defaultProvidedValue$runtime(new Dp(f7))}, Thread_jvmKt.rememberComposableLambda(849208527, new Function2() { // from class: androidx.compose.material3.SurfaceKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        GapComposer gapComposer2 = (GapComposer) obj2;
                        int iIntValue = ((Integer) obj3).intValue();
                        if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                            HorizontalAlignmentLine horizontalAlignmentLine = InteractiveComponentSizeKt.MinimumInteractiveTopAlignmentLine;
                            Modifier modifierThen = modifierSemantics2.then(MinimumInteractiveModifier.INSTANCE);
                            DynamicProvidableCompositionLocal dynamicProvidableCompositionLocal3 = RippleKt.LocalRippleThemeConfiguration;
                            boolean z8 = ((RippleThemeConfiguration) gapComposer2.consume(dynamicProvidableCompositionLocal3)).focus instanceof RippleThemeConfiguration$Focus$InsetRing;
                            MutableInteractionSourceImpl mutableInteractionSourceImpl3 = mutableInteractionSourceImpl2;
                            Shape shape2 = shape;
                            Modifier modifierIndication = Modifier.Companion.$$INSTANCE;
                            if (z8) {
                                modifierIndication = IndicationKt.indication(modifierIndication, mutableInteractionSourceImpl3, RippleKt.m260rippleOu1YvPQ$default(0.0f, 0L, shape2, true, 7));
                            }
                            Modifier modifierThen2 = ImageKt.m50clickableO2vRcR0$default(SurfaceKt.m270surfaceXOJAsU(((Density) gapComposer2.consume(CompositionLocalsKt.LocalDensity)).mo92toPx0680j_4(f8), SurfaceKt.m271surfaceColorAtElevationCLU3JFs(j6, f7, gapComposer2), modifierThen.then(modifierIndication), shape2), mutableInteractionSourceImpl3, RippleKt.m260rippleOu1YvPQ$default(0.0f, 0L, shape2, !(((RippleThemeConfiguration) gapComposer2.consume(dynamicProvidableCompositionLocal3)).focus instanceof RippleThemeConfiguration$Focus$InsetRing), 215), z7, null, function0, 24).then(new ChildSemanticsNodeElement(new SaversKt$$ExternalSyntheticLambda10(17)));
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, true);
                            long j7 = gapComposer2.compositeKeyHashCode;
                            int i18 = (int) (j7 ^ (j7 >>> 32));
                            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierThen2);
                            ComposeUiNode.Companion.getClass();
                            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                            gapComposer2.startReusableNode();
                            if (gapComposer2.inserting) {
                                gapComposer2.createNode(layoutNode$Companion$Constructor$1);
                            } else {
                                gapComposer2.useNode();
                            }
                            Stack.m295setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                            Stack.m295setimpl(gapComposer2, Integer.valueOf(i18), ComposeUiNode.Companion.SetCompositeKeyHash);
                            Stack.m294reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                            composableLambdaImplRememberComposableLambda2.invoke((Object) gapComposer2, (Object) 0);
                            gapComposer2.end(true);
                        } else {
                            gapComposer2.skipToGroupEnd();
                        }
                        return Unit.INSTANCE;
                    }
                }, gapComposer), gapComposer, 56);
                modifier3 = modifier5;
                paddingValues3 = paddingValues4;
                z4 = z5;
                buttonElevation3 = buttonElevation5;
            } else {
                gapComposer.skipToGroupEnd();
                modifier3 = modifier2;
                paddingValues3 = paddingValues2;
                z4 = z2;
                buttonElevation3 = buttonElevation2;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new ButtonKt$$ExternalSyntheticLambda3(function0, modifier3, z4, shape, buttonColors, buttonElevation3, paddingValues3, composableLambdaImpl, i, i2);
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                z2 = z;
                if (gapComposer.changed(z2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i & 3072) == 0) {
                if (gapComposer.changed(shape)) {
                    i13 = 2048;
                } else {
                    i13 = 1024;
                }
                i3 |= i13;
            }
            if ((i & 24576) == 0) {
                if (gapComposer.changed(buttonColors)) {
                    i12 = 16384;
                } else {
                    i12 = 8192;
                }
                i3 |= i12;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    buttonElevation2 = buttonElevation;
                    if (gapComposer.changed(buttonElevation2)) {
                    }
                    i3 |= i15;
                } else {
                    buttonElevation2 = buttonElevation;
                }
                i3 |= i15;
            } else {
                buttonElevation2 = buttonElevation;
            }
            if ((i2 & 64) != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (gapComposer.changed((Object) null)) {
                    i6 = 1048576;
                } else {
                    i6 = 524288;
                }
                i3 |= i6;
            }
            i7 = i2 & 128;
            if (i7 != 0) {
                i3 |= 12582912;
                paddingValues2 = paddingValues;
            } else {
                paddingValues2 = paddingValues;
                if ((i & 12582912) == 0) {
                    if (gapComposer.changed(paddingValues2)) {
                        i8 = 8388608;
                    } else {
                        i8 = 4194304;
                    }
                    i3 |= i8;
                }
            }
            if ((i2 & 256) != 0) {
                i3 |= 100663296;
            } else if ((i & 100663296) == 0) {
                if (gapComposer.changed((Object) null)) {
                    i9 = 67108864;
                } else {
                    i9 = 33554432;
                }
                i3 |= i9;
            }
            if ((805306368 & i) != 0) {
                if (gapComposer.changedInstance(composableLambdaImpl)) {
                    i11 = 536870912;
                } else {
                    i11 = 268435456;
                }
                i3 |= i11;
            }
            if ((i3 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (gapComposer.shouldExecute(i3 & 1, z3)) {
                gapComposer.startDefaults();
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion.$$INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 32) != 0) {
                        PaddingValuesImpl paddingValuesImpl4 = ButtonDefaults.ContentPadding;
                        buttonElevation4 = new ButtonElevation(FilledButtonTokens.ContainerElevation, FilledButtonTokens.PressedContainerElevation, FilledButtonTokens.FocusedContainerElevation, FilledButtonTokens.HoveredContainerElevation, FilledButtonTokens.DisabledContainerElevation);
                        i3 &= -458753;
                    } else {
                        buttonElevation4 = buttonElevation2;
                    }
                    if (i7 != 0) {
                        paddingValues2 = ButtonDefaults.ContentPadding;
                    }
                    paddingValues4 = paddingValues2;
                    buttonElevation2 = buttonElevation4;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.Companion.$$INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 32) != 0) {
                        PaddingValuesImpl paddingValuesImpl5 = ButtonDefaults.ContentPadding;
                        buttonElevation4 = new ButtonElevation(FilledButtonTokens.ContainerElevation, FilledButtonTokens.PressedContainerElevation, FilledButtonTokens.FocusedContainerElevation, FilledButtonTokens.HoveredContainerElevation, FilledButtonTokens.DisabledContainerElevation);
                        i3 &= -458753;
                    } else {
                        buttonElevation4 = buttonElevation2;
                    }
                    if (i7 != 0) {
                        paddingValues2 = ButtonDefaults.ContentPadding;
                    }
                    paddingValues4 = paddingValues2;
                    buttonElevation2 = buttonElevation4;
                }
                gapComposer.endDefaults();
                gapComposer.startReplaceGroup(1691726283);
                objRememberedValue = gapComposer.rememberedValue();
                obj = Composer$Companion.Empty;
                if (objRememberedValue == obj) {
                    objRememberedValue = new MutableInteractionSourceImpl();
                    gapComposer.updateRememberedValue(objRememberedValue);
                }
                mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
                gapComposer.end(false);
                i10 = i3;
                if (z2) {
                    j = buttonColors.containerColor;
                } else {
                    j = buttonColors.disabledContainerColor;
                }
                Modifier modifier6 = modifier2;
                if (z2) {
                    j2 = buttonColors.contentColor;
                } else {
                    j2 = buttonColors.disabledContentColor;
                }
                long j7 = j2;
                if (buttonElevation2 == null) {
                    gapComposer.startReplaceGroup(1691909926);
                    gapComposer.end(false);
                    mutableInteractionSourceImpl = mutableInteractionSourceImpl;
                    j = j;
                    z5 = z2;
                    buttonElevation5 = buttonElevation2;
                    animationState = null;
                    r6 = 0;
                } else {
                    gapComposer.startReplaceGroup(-499611589);
                    int i18 = ((i10 >> 6) & 14) | ((i10 >> 9) & 896);
                    objRememberedValue2 = gapComposer.rememberedValue();
                    if (objRememberedValue2 == obj) {
                        objRememberedValue2 = new SnapshotStateList();
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    snapshotStateList = (SnapshotStateList) objRememberedValue2;
                    zChanged = gapComposer.changed(mutableInteractionSourceImpl);
                    objRememberedValue3 = gapComposer.rememberedValue();
                    if (zChanged) {
                        objRememberedValue3 = new RealImageLoader$execute$3(mutableInteractionSourceImpl, snapshotStateList, null, 18);
                        gapComposer.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new RealImageLoader$execute$3(mutableInteractionSourceImpl, snapshotStateList, null, 18);
                        gapComposer.updateRememberedValue(objRememberedValue3);
                    }
                    Stack.LaunchedEffect(gapComposer, mutableInteractionSourceImpl, (Function2) objRememberedValue3);
                    interaction = (Interaction) CollectionsKt.lastOrNull(snapshotStateList);
                    if (!z2) {
                        f = buttonElevation2.disabledElevation;
                    } else if (interaction instanceof PressInteraction.Press) {
                        f = buttonElevation2.pressedElevation;
                    } else if (interaction instanceof HoverInteraction$Enter) {
                        f = buttonElevation2.hoveredElevation;
                    } else if (interaction instanceof FocusInteraction$Focus) {
                        f = buttonElevation2.focusedElevation;
                    } else {
                        f = buttonElevation2.defaultElevation;
                    }
                    objRememberedValue4 = gapComposer.rememberedValue();
                    if (objRememberedValue4 == obj) {
                        objRememberedValue4 = new Animatable(new Dp(f), ArcSplineKt.DpToVector, null, 12);
                        gapComposer.updateRememberedValue(objRememberedValue4);
                    }
                    animatable = (Animatable) objRememberedValue4;
                    Dp dp3 = new Dp(f);
                    zChangedInstance = gapComposer.changedInstance(animatable) | gapComposer.changed(f) | ((((i18 & 14) ^ 6) <= 4 && gapComposer.changed(z2)) || (i18 & 6) == 4) | ((((i18 & 896) ^ 384) <= 256 && gapComposer.changed(buttonElevation2)) || (i18 & 384) == 256) | gapComposer.changedInstance(interaction);
                    objRememberedValue5 = gapComposer.rememberedValue();
                    if (zChangedInstance) {
                        z5 = z2;
                        buttonElevation5 = buttonElevation2;
                        objRememberedValue5 = new ButtonElevation$animateElevation$2$1(animatable, f, z5, buttonElevation5, interaction, null);
                        gapComposer.updateRememberedValue(objRememberedValue5);
                    } else {
                        z5 = z2;
                        buttonElevation5 = buttonElevation2;
                        objRememberedValue5 = new ButtonElevation$animateElevation$2$1(animatable, f, z5, buttonElevation5, interaction, null);
                        gapComposer.updateRememberedValue(objRememberedValue5);
                    }
                    Stack.LaunchedEffect(gapComposer, dp3, (Function2) objRememberedValue5);
                    animationState = animatable.internalState;
                    r6 = 0;
                    gapComposer.end(false);
                }
                if (animationState != null) {
                    f2 = ((Dp) animationState.value$delegate.getValue()).value;
                } else {
                    f2 = (float) r6;
                }
                objRememberedValue6 = gapComposer.rememberedValue();
                if (objRememberedValue6 == obj) {
                    objRememberedValue6 = new SaversKt$$ExternalSyntheticLambda10(7);
                    gapComposer.updateRememberedValue(objRememberedValue6);
                }
                final Modifier modifierSemantics3 = SemanticsModifierKt.semantics(modifier6, r6, (Function1) objRememberedValue6);
                final ComposableLambdaImpl composableLambdaImplRememberComposableLambda3 = Thread_jvmKt.rememberComposableLambda(-535639973, new ButtonKt$$ExternalSyntheticLambda2(j7, paddingValues4, composableLambdaImpl, 0), gapComposer);
                DynamicProvidableCompositionLocal dynamicProvidableCompositionLocal3 = SurfaceKt.LocalAbsoluteTonalElevation;
                float f9 = (float) r6;
                if (mutableInteractionSourceImpl == null) {
                    gapComposer.startReplaceGroup(-1701074900);
                    objRememberedValue7 = gapComposer.rememberedValue();
                    if (objRememberedValue7 == obj) {
                        objRememberedValue7 = new MutableInteractionSourceImpl();
                        gapComposer.updateRememberedValue(objRememberedValue7);
                    }
                    gapComposer.end(false);
                    mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue7;
                } else {
                    gapComposer.startReplaceGroup(2023335947);
                    gapComposer.end(false);
                    mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
                }
                ProvidableCompositionLocal providableCompositionLocal3 = SurfaceKt.LocalAbsoluteTonalElevation;
                final float f10 = ((Dp) gapComposer.consume(providableCompositionLocal3)).value + f9;
                final long j8 = j;
                final float f11 = f2;
                final boolean z8 = z5;
                Stack.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.LocalContentColor.defaultProvidedValue$runtime(new Color(j7)), providableCompositionLocal3.defaultProvidedValue$runtime(new Dp(f10))}, Thread_jvmKt.rememberComposableLambda(849208527, new Function2() { // from class: androidx.compose.material3.SurfaceKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        GapComposer gapComposer2 = (GapComposer) obj2;
                        int iIntValue = ((Integer) obj3).intValue();
                        if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                            HorizontalAlignmentLine horizontalAlignmentLine = InteractiveComponentSizeKt.MinimumInteractiveTopAlignmentLine;
                            Modifier modifierThen = modifierSemantics3.then(MinimumInteractiveModifier.INSTANCE);
                            DynamicProvidableCompositionLocal dynamicProvidableCompositionLocal4 = RippleKt.LocalRippleThemeConfiguration;
                            boolean z9 = ((RippleThemeConfiguration) gapComposer2.consume(dynamicProvidableCompositionLocal4)).focus instanceof RippleThemeConfiguration$Focus$InsetRing;
                            MutableInteractionSourceImpl mutableInteractionSourceImpl3 = mutableInteractionSourceImpl2;
                            Shape shape2 = shape;
                            Modifier modifierIndication = Modifier.Companion.$$INSTANCE;
                            if (z9) {
                                modifierIndication = IndicationKt.indication(modifierIndication, mutableInteractionSourceImpl3, RippleKt.m260rippleOu1YvPQ$default(0.0f, 0L, shape2, true, 7));
                            }
                            Modifier modifierThen2 = ImageKt.m50clickableO2vRcR0$default(SurfaceKt.m270surfaceXOJAsU(((Density) gapComposer2.consume(CompositionLocalsKt.LocalDensity)).mo92toPx0680j_4(f11), SurfaceKt.m271surfaceColorAtElevationCLU3JFs(j8, f10, gapComposer2), modifierThen.then(modifierIndication), shape2), mutableInteractionSourceImpl3, RippleKt.m260rippleOu1YvPQ$default(0.0f, 0L, shape2, !(((RippleThemeConfiguration) gapComposer2.consume(dynamicProvidableCompositionLocal4)).focus instanceof RippleThemeConfiguration$Focus$InsetRing), 215), z8, null, function0, 24).then(new ChildSemanticsNodeElement(new SaversKt$$ExternalSyntheticLambda10(17)));
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, true);
                            long j9 = gapComposer2.compositeKeyHashCode;
                            int i19 = (int) (j9 ^ (j9 >>> 32));
                            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierThen2);
                            ComposeUiNode.Companion.getClass();
                            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                            gapComposer2.startReusableNode();
                            if (gapComposer2.inserting) {
                                gapComposer2.createNode(layoutNode$Companion$Constructor$1);
                            } else {
                                gapComposer2.useNode();
                            }
                            Stack.m295setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                            Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                            Stack.m295setimpl(gapComposer2, Integer.valueOf(i19), ComposeUiNode.Companion.SetCompositeKeyHash);
                            Stack.m294reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                            Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                            composableLambdaImplRememberComposableLambda3.invoke((Object) gapComposer2, (Object) 0);
                            gapComposer2.end(true);
                        } else {
                            gapComposer2.skipToGroupEnd();
                        }
                        return Unit.INSTANCE;
                    }
                }, gapComposer), gapComposer, 56);
                modifier3 = modifier6;
                paddingValues3 = paddingValues4;
                z4 = z5;
                buttonElevation3 = buttonElevation5;
            } else {
                gapComposer.skipToGroupEnd();
                modifier3 = modifier2;
                paddingValues3 = paddingValues2;
                z4 = z2;
                buttonElevation3 = buttonElevation2;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new ButtonKt$$ExternalSyntheticLambda3(function0, modifier3, z4, shape, buttonColors, buttonElevation3, paddingValues3, composableLambdaImpl, i, i2);
            }
        }
        i3 |= 384;
        z2 = z;
        if ((i & 3072) == 0) {
            if (gapComposer.changed(shape)) {
                i13 = 2048;
            } else {
                i13 = 1024;
            }
            i3 |= i13;
        }
        if ((i & 24576) == 0) {
            if (gapComposer.changed(buttonColors)) {
                i12 = 16384;
            } else {
                i12 = 8192;
            }
            i3 |= i12;
        }
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                buttonElevation2 = buttonElevation;
                if (gapComposer.changed(buttonElevation2)) {
                }
                i3 |= i15;
            } else {
                buttonElevation2 = buttonElevation;
            }
            i3 |= i15;
        } else {
            buttonElevation2 = buttonElevation;
        }
        if ((i2 & 64) != 0) {
            i3 |= 1572864;
        } else if ((i & 1572864) == 0) {
            if (gapComposer.changed((Object) null)) {
                i6 = 1048576;
            } else {
                i6 = 524288;
            }
            i3 |= i6;
        }
        i7 = i2 & 128;
        if (i7 != 0) {
            i3 |= 12582912;
            paddingValues2 = paddingValues;
        } else {
            paddingValues2 = paddingValues;
            if ((i & 12582912) == 0) {
                if (gapComposer.changed(paddingValues2)) {
                    i8 = 8388608;
                } else {
                    i8 = 4194304;
                }
                i3 |= i8;
            }
        }
        if ((i2 & 256) != 0) {
            i3 |= 100663296;
        } else if ((i & 100663296) == 0) {
            if (gapComposer.changed((Object) null)) {
                i9 = 67108864;
            } else {
                i9 = 33554432;
            }
            i3 |= i9;
        }
        if ((805306368 & i) != 0) {
            if (gapComposer.changedInstance(composableLambdaImpl)) {
                i11 = 536870912;
            } else {
                i11 = 268435456;
            }
            i3 |= i11;
        }
        if ((i3 & 306783379) != 306783378) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (gapComposer.shouldExecute(i3 & 1, z3)) {
            gapComposer.startDefaults();
            if ((i & 1) != 0) {
                if (i14 != 0) {
                    modifier2 = Modifier.Companion.$$INSTANCE;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 32) != 0) {
                    PaddingValuesImpl paddingValuesImpl6 = ButtonDefaults.ContentPadding;
                    buttonElevation4 = new ButtonElevation(FilledButtonTokens.ContainerElevation, FilledButtonTokens.PressedContainerElevation, FilledButtonTokens.FocusedContainerElevation, FilledButtonTokens.HoveredContainerElevation, FilledButtonTokens.DisabledContainerElevation);
                    i3 &= -458753;
                } else {
                    buttonElevation4 = buttonElevation2;
                }
                if (i7 != 0) {
                    paddingValues2 = ButtonDefaults.ContentPadding;
                }
                paddingValues4 = paddingValues2;
                buttonElevation2 = buttonElevation4;
            } else {
                if (i14 != 0) {
                    modifier2 = Modifier.Companion.$$INSTANCE;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 32) != 0) {
                    PaddingValuesImpl paddingValuesImpl7 = ButtonDefaults.ContentPadding;
                    buttonElevation4 = new ButtonElevation(FilledButtonTokens.ContainerElevation, FilledButtonTokens.PressedContainerElevation, FilledButtonTokens.FocusedContainerElevation, FilledButtonTokens.HoveredContainerElevation, FilledButtonTokens.DisabledContainerElevation);
                    i3 &= -458753;
                } else {
                    buttonElevation4 = buttonElevation2;
                }
                if (i7 != 0) {
                    paddingValues2 = ButtonDefaults.ContentPadding;
                }
                paddingValues4 = paddingValues2;
                buttonElevation2 = buttonElevation4;
            }
            gapComposer.endDefaults();
            gapComposer.startReplaceGroup(1691726283);
            objRememberedValue = gapComposer.rememberedValue();
            obj = Composer$Companion.Empty;
            if (objRememberedValue == obj) {
                objRememberedValue = new MutableInteractionSourceImpl();
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
            gapComposer.end(false);
            i10 = i3;
            if (z2) {
                j = buttonColors.containerColor;
            } else {
                j = buttonColors.disabledContainerColor;
            }
            Modifier modifier7 = modifier2;
            if (z2) {
                j2 = buttonColors.contentColor;
            } else {
                j2 = buttonColors.disabledContentColor;
            }
            long j9 = j2;
            if (buttonElevation2 == null) {
                gapComposer.startReplaceGroup(1691909926);
                gapComposer.end(false);
                mutableInteractionSourceImpl = mutableInteractionSourceImpl;
                j = j;
                z5 = z2;
                buttonElevation5 = buttonElevation2;
                animationState = null;
                r6 = 0;
            } else {
                gapComposer.startReplaceGroup(-499611589);
                int i19 = ((i10 >> 6) & 14) | ((i10 >> 9) & 896);
                objRememberedValue2 = gapComposer.rememberedValue();
                if (objRememberedValue2 == obj) {
                    objRememberedValue2 = new SnapshotStateList();
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                snapshotStateList = (SnapshotStateList) objRememberedValue2;
                zChanged = gapComposer.changed(mutableInteractionSourceImpl);
                objRememberedValue3 = gapComposer.rememberedValue();
                if (zChanged) {
                    objRememberedValue3 = new RealImageLoader$execute$3(mutableInteractionSourceImpl, snapshotStateList, null, 18);
                    gapComposer.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new RealImageLoader$execute$3(mutableInteractionSourceImpl, snapshotStateList, null, 18);
                    gapComposer.updateRememberedValue(objRememberedValue3);
                }
                Stack.LaunchedEffect(gapComposer, mutableInteractionSourceImpl, (Function2) objRememberedValue3);
                interaction = (Interaction) CollectionsKt.lastOrNull(snapshotStateList);
                if (!z2) {
                    f = buttonElevation2.disabledElevation;
                } else if (interaction instanceof PressInteraction.Press) {
                    f = buttonElevation2.pressedElevation;
                } else if (interaction instanceof HoverInteraction$Enter) {
                    f = buttonElevation2.hoveredElevation;
                } else if (interaction instanceof FocusInteraction$Focus) {
                    f = buttonElevation2.focusedElevation;
                } else {
                    f = buttonElevation2.defaultElevation;
                }
                objRememberedValue4 = gapComposer.rememberedValue();
                if (objRememberedValue4 == obj) {
                    objRememberedValue4 = new Animatable(new Dp(f), ArcSplineKt.DpToVector, null, 12);
                    gapComposer.updateRememberedValue(objRememberedValue4);
                }
                animatable = (Animatable) objRememberedValue4;
                Dp dp4 = new Dp(f);
                zChangedInstance = gapComposer.changedInstance(animatable) | gapComposer.changed(f) | ((((i19 & 14) ^ 6) <= 4 && gapComposer.changed(z2)) || (i19 & 6) == 4) | ((((i19 & 896) ^ 384) <= 256 && gapComposer.changed(buttonElevation2)) || (i19 & 384) == 256) | gapComposer.changedInstance(interaction);
                objRememberedValue5 = gapComposer.rememberedValue();
                if (zChangedInstance) {
                    z5 = z2;
                    buttonElevation5 = buttonElevation2;
                    objRememberedValue5 = new ButtonElevation$animateElevation$2$1(animatable, f, z5, buttonElevation5, interaction, null);
                    gapComposer.updateRememberedValue(objRememberedValue5);
                } else {
                    z5 = z2;
                    buttonElevation5 = buttonElevation2;
                    objRememberedValue5 = new ButtonElevation$animateElevation$2$1(animatable, f, z5, buttonElevation5, interaction, null);
                    gapComposer.updateRememberedValue(objRememberedValue5);
                }
                Stack.LaunchedEffect(gapComposer, dp4, (Function2) objRememberedValue5);
                animationState = animatable.internalState;
                r6 = 0;
                gapComposer.end(false);
            }
            if (animationState != null) {
                f2 = ((Dp) animationState.value$delegate.getValue()).value;
            } else {
                f2 = (float) r6;
            }
            objRememberedValue6 = gapComposer.rememberedValue();
            if (objRememberedValue6 == obj) {
                objRememberedValue6 = new SaversKt$$ExternalSyntheticLambda10(7);
                gapComposer.updateRememberedValue(objRememberedValue6);
            }
            final Modifier modifierSemantics4 = SemanticsModifierKt.semantics(modifier7, r6, (Function1) objRememberedValue6);
            final ComposableLambdaImpl composableLambdaImplRememberComposableLambda4 = Thread_jvmKt.rememberComposableLambda(-535639973, new ButtonKt$$ExternalSyntheticLambda2(j9, paddingValues4, composableLambdaImpl, 0), gapComposer);
            DynamicProvidableCompositionLocal dynamicProvidableCompositionLocal4 = SurfaceKt.LocalAbsoluteTonalElevation;
            float f12 = (float) r6;
            if (mutableInteractionSourceImpl == null) {
                gapComposer.startReplaceGroup(-1701074900);
                objRememberedValue7 = gapComposer.rememberedValue();
                if (objRememberedValue7 == obj) {
                    objRememberedValue7 = new MutableInteractionSourceImpl();
                    gapComposer.updateRememberedValue(objRememberedValue7);
                }
                gapComposer.end(false);
                mutableInteractionSourceImpl2 = (MutableInteractionSourceImpl) objRememberedValue7;
            } else {
                gapComposer.startReplaceGroup(2023335947);
                gapComposer.end(false);
                mutableInteractionSourceImpl2 = mutableInteractionSourceImpl;
            }
            ProvidableCompositionLocal providableCompositionLocal4 = SurfaceKt.LocalAbsoluteTonalElevation;
            final float f13 = ((Dp) gapComposer.consume(providableCompositionLocal4)).value + f12;
            final long j10 = j;
            final float f14 = f2;
            final boolean z9 = z5;
            Stack.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.LocalContentColor.defaultProvidedValue$runtime(new Color(j9)), providableCompositionLocal4.defaultProvidedValue$runtime(new Dp(f13))}, Thread_jvmKt.rememberComposableLambda(849208527, new Function2() { // from class: androidx.compose.material3.SurfaceKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    GapComposer gapComposer2 = (GapComposer) obj2;
                    int iIntValue = ((Integer) obj3).intValue();
                    if (gapComposer2.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                        HorizontalAlignmentLine horizontalAlignmentLine = InteractiveComponentSizeKt.MinimumInteractiveTopAlignmentLine;
                        Modifier modifierThen = modifierSemantics4.then(MinimumInteractiveModifier.INSTANCE);
                        DynamicProvidableCompositionLocal dynamicProvidableCompositionLocal5 = RippleKt.LocalRippleThemeConfiguration;
                        boolean z10 = ((RippleThemeConfiguration) gapComposer2.consume(dynamicProvidableCompositionLocal5)).focus instanceof RippleThemeConfiguration$Focus$InsetRing;
                        MutableInteractionSourceImpl mutableInteractionSourceImpl3 = mutableInteractionSourceImpl2;
                        Shape shape2 = shape;
                        Modifier modifierIndication = Modifier.Companion.$$INSTANCE;
                        if (z10) {
                            modifierIndication = IndicationKt.indication(modifierIndication, mutableInteractionSourceImpl3, RippleKt.m260rippleOu1YvPQ$default(0.0f, 0L, shape2, true, 7));
                        }
                        Modifier modifierThen2 = ImageKt.m50clickableO2vRcR0$default(SurfaceKt.m270surfaceXOJAsU(((Density) gapComposer2.consume(CompositionLocalsKt.LocalDensity)).mo92toPx0680j_4(f14), SurfaceKt.m271surfaceColorAtElevationCLU3JFs(j10, f13, gapComposer2), modifierThen.then(modifierIndication), shape2), mutableInteractionSourceImpl3, RippleKt.m260rippleOu1YvPQ$default(0.0f, 0L, shape2, !(((RippleThemeConfiguration) gapComposer2.consume(dynamicProvidableCompositionLocal5)).focus instanceof RippleThemeConfiguration$Focus$InsetRing), 215), z9, null, function0, 24).then(new ChildSemanticsNodeElement(new SaversKt$$ExternalSyntheticLambda10(17)));
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, true);
                        long j11 = gapComposer2.compositeKeyHashCode;
                        int i110 = (int) (j11 ^ (j11 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer2.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer2, modifierThen2);
                        ComposeUiNode.Companion.getClass();
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                        gapComposer2.startReusableNode();
                        if (gapComposer2.inserting) {
                            gapComposer2.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer2.useNode();
                        }
                        Stack.m295setimpl(gapComposer2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                        Stack.m295setimpl(gapComposer2, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                        Stack.m295setimpl(gapComposer2, Integer.valueOf(i110), ComposeUiNode.Companion.SetCompositeKeyHash);
                        Stack.m294reconcileimpl(gapComposer2, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                        Stack.m295setimpl(gapComposer2, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                        composableLambdaImplRememberComposableLambda4.invoke((Object) gapComposer2, (Object) 0);
                        gapComposer2.end(true);
                    } else {
                        gapComposer2.skipToGroupEnd();
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer), gapComposer, 56);
            modifier3 = modifier7;
            paddingValues3 = paddingValues4;
            z4 = z5;
            buttonElevation3 = buttonElevation5;
        } else {
            gapComposer.skipToGroupEnd();
            modifier3 = modifier2;
            paddingValues3 = paddingValues2;
            z4 = z2;
            buttonElevation3 = buttonElevation2;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ButtonKt$$ExternalSyntheticLambda3(function0, modifier3, z4, shape, buttonColors, buttonElevation3, paddingValues3, composableLambdaImpl, i, i2);
        }
    }

    public static final void FadeInFadeOutWithScale(SnackbarHostState.SnackbarDataImpl snackbarDataImpl, Modifier modifier, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        Object obj;
        char c;
        SnackbarHostState.SnackbarDataImpl snackbarDataImpl2 = snackbarDataImpl;
        gapComposer.startRestartGroup(-977568115);
        int i2 = (i & 6) == 0 ? (gapComposer.changed(snackbarDataImpl2) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(modifier) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl) ? 256 : 128;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            String strM282getString2EP1pXo = LayoutUtilKt.m282getString2EP1pXo(R.string.m3c_snackbar_pane_title, gapComposer);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == Composer$Companion.Empty) {
                obj = objRememberedValue;
                FadeInFadeOutState fadeInFadeOutState = new FadeInFadeOutState();
                fadeInFadeOutState.current = new Object();
                fadeInFadeOutState.items = new ArrayList();
                gapComposer.updateRememberedValue(fadeInFadeOutState);
                obj = fadeInFadeOutState;
            }
            obj = objRememberedValue;
            FadeInFadeOutState fadeInFadeOutState2 = (FadeInFadeOutState) obj;
            Object obj2 = fadeInFadeOutState2.current;
            ArrayList arrayList = fadeInFadeOutState2.items;
            if (Intrinsics.areEqual(snackbarDataImpl2, obj2)) {
                c = ' ';
                gapComposer.startReplaceGroup(1443889109);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(1441886385);
                fadeInFadeOutState2.current = snackbarDataImpl2;
                ArrayList arrayList2 = new ArrayList(arrayList.size());
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    arrayList2.add((SnackbarHostState.SnackbarDataImpl) ((FadeInFadeOutAnimationItem) arrayList.get(i3)).key);
                }
                ArrayList arrayList3 = new ArrayList(arrayList2);
                if (!arrayList3.contains(snackbarDataImpl2)) {
                    arrayList3.add(snackbarDataImpl2);
                }
                arrayList.clear();
                ArrayList arrayList4 = new ArrayList(arrayList3.size());
                int size2 = arrayList3.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    Object obj3 = arrayList3.get(i4);
                    if (obj3 != null) {
                        arrayList4.add(obj3);
                    }
                }
                int size3 = arrayList4.size();
                int i5 = 0;
                while (i5 < size3) {
                    SnackbarHostState.SnackbarDataImpl snackbarDataImpl3 = (SnackbarHostState.SnackbarDataImpl) arrayList4.get(i5);
                    arrayList.add(new FadeInFadeOutAnimationItem(snackbarDataImpl3, Thread_jvmKt.rememberComposableLambda(-1952400805, new SnackbarHostKt$$ExternalSyntheticLambda1(snackbarDataImpl3, snackbarDataImpl2, fadeInFadeOutState2, strM282getString2EP1pXo, 0), gapComposer)));
                    i5++;
                    snackbarDataImpl2 = snackbarDataImpl;
                }
                c = ' ';
                gapComposer.end(false);
            }
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
            long j = gapComposer.compositeKeyHashCode;
            int i6 = (int) (j ^ (j >>> c));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifier);
            ComposeUiNode.Companion.getClass();
            Function0 function0 = ComposeUiNode.Companion.Constructor;
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(function0);
            } else {
                gapComposer.useNode();
            }
            Stack.m295setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m295setimpl(gapComposer, Integer.valueOf(i6), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m294reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m295setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            RecomposeScopeImpl currentRecomposeScope$runtime = gapComposer.getCurrentRecomposeScope$runtime();
            if (currentRecomposeScope$runtime == null) {
                throw new IllegalStateException("no recompose scope found");
            }
            currentRecomposeScope$runtime.setUsed();
            fadeInFadeOutState2.scope = currentRecomposeScope$runtime;
            gapComposer.startReplaceGroup(-1888182177);
            int size4 = arrayList.size();
            for (int i7 = 0; i7 < size4; i7++) {
                FadeInFadeOutAnimationItem fadeInFadeOutAnimationItem = (FadeInFadeOutAnimationItem) arrayList.get(i7);
                Object obj4 = (SnackbarHostState.SnackbarDataImpl) fadeInFadeOutAnimationItem.key;
                ComposableLambdaImpl composableLambdaImpl2 = fadeInFadeOutAnimationItem.transition;
                gapComposer.startMovableGroup(1325010085, obj4);
                composableLambdaImpl2.invoke((Object) Thread_jvmKt.rememberComposableLambda(-1893791890, new TextKt$$ExternalSyntheticLambda2(composableLambdaImpl, obj4, 17), gapComposer), (Object) gapComposer, (Object) 6);
                gapComposer.end(false);
            }
            gapComposer.end(false);
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new SnackbarHostKt$$ExternalSyntheticLambda0(snackbarDataImpl, modifier, composableLambdaImpl, i, 8);
        }
    }

    /* JADX INFO: renamed from: HorizontalDivider-9IZ8Weo, reason: not valid java name */
    public static final void m264HorizontalDivider9IZ8Weo(Modifier modifier, float f, final long j, GapComposer gapComposer, final int i, final int i2) {
        int i3;
        gapComposer.startRestartGroup(75144485);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = i | (gapComposer.changed(modifier) ? 4 : 2);
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= gapComposer.changed(f) ? 32 : 16;
        }
        int i6 = i3 | (gapComposer.changed(j) ? 256 : 128);
        boolean z = true;
        if (gapComposer.shouldExecute(i6 & 1, (i6 & 147) != 146)) {
            gapComposer.startDefaults();
            if ((i & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                if (i4 != 0) {
                    modifier = Modifier.Companion.$$INSTANCE;
                }
                if (i5 != 0) {
                    f = DividerDefaults.Thickness;
                }
            } else {
                gapComposer.skipToGroupEnd();
            }
            gapComposer.endDefaults();
            Modifier modifierM135height3ABfNKs = SizeKt.m135height3ABfNKs(SizeKt.fillMaxWidth(modifier, 1.0f), f);
            boolean z2 = (i6 & 112) == 32;
            if ((((i6 & 896) ^ 384) <= 256 || !gapComposer.changed(j)) && (i6 & 384) != 256) {
                z = false;
            }
            boolean z3 = z2 | z;
            Object objRememberedValue = gapComposer.rememberedValue();
            if (z3 || objRememberedValue == Composer$Companion.Empty) {
                objRememberedValue = new DividerKt$$ExternalSyntheticLambda0(f, 1, j);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            ImageKt.Canvas(modifierM135height3ABfNKs, (Function1) objRememberedValue, gapComposer, 0);
        } else {
            gapComposer.skipToGroupEnd();
        }
        final Modifier modifier2 = modifier;
        final float f2 = f;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.DividerKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    ScrimKt.m264HorizontalDivider9IZ8Weo(modifier2, f2, j, (GapComposer) obj, Stack.updateChangedFlags(i | 1), i2);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x003b  */
    /* JADX WARN: Code duplicated, block: B:25:0x0040  */
    /* JADX WARN: Code duplicated, block: B:27:0x0044  */
    /* JADX WARN: Code duplicated, block: B:29:0x004c  */
    /* JADX WARN: Code duplicated, block: B:30:0x004f  */
    /* JADX WARN: Code duplicated, block: B:34:0x0056  */
    /* JADX WARN: Code duplicated, block: B:36:0x005a  */
    /* JADX WARN: Code duplicated, block: B:38:0x0062  */
    /* JADX WARN: Code duplicated, block: B:39:0x0065  */
    /* JADX WARN: Code duplicated, block: B:42:0x006b  */
    /* JADX WARN: Code duplicated, block: B:45:0x0074  */
    /* JADX WARN: Code duplicated, block: B:48:0x007d  */
    /* JADX WARN: Code duplicated, block: B:50:0x0085  */
    /* JADX WARN: Code duplicated, block: B:51:0x0088  */
    /* JADX WARN: Code duplicated, block: B:53:0x008c  */
    /* JADX WARN: Code duplicated, block: B:56:0x0098  */
    /* JADX WARN: Code duplicated, block: B:57:0x009a  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:70:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:71:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:74:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:79:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:80:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:82:0x0115  */
    /* JADX WARN: Code duplicated, block: B:85:0x0151  */
    /* JADX WARN: Code duplicated, block: B:88:0x015f  */
    /* JADX WARN: Code duplicated, block: B:90:? A[RETURN, SYNTHETIC] */
    public static final void IconButton(Function0 function0, Modifier modifier, boolean z, IconButtonColors iconButtonColors, Shape shape, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i, int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        IconButtonColors iconButtonColors2;
        int i6;
        ComposableLambdaImpl composableLambdaImpl2;
        boolean z3;
        Modifier modifier3;
        boolean z4;
        IconButtonColors iconButtonColors3;
        Shape shape2;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        int i7;
        Modifier modifier4;
        boolean z5;
        Shape value;
        int i8;
        long j;
        IconButtonColors iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3;
        int i9;
        gapComposer.startRestartGroup(1413012038);
        if ((i & 6) == 0) {
            i3 = (gapComposer.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= gapComposer.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    z2 = z;
                    if (gapComposer.changed(z2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        iconButtonColors2 = iconButtonColors;
                        int i11 = gapComposer.changed(iconButtonColors2) ? 2048 : 1024;
                        i3 |= i11;
                    } else {
                        iconButtonColors2 = iconButtonColors;
                    }
                    i3 |= i11;
                } else {
                    iconButtonColors2 = iconButtonColors;
                }
                i6 = i3 | 24576;
                if ((196608 & i) == 0) {
                    i6 = 90112 | i3;
                }
                if ((1572864 & i) == 0) {
                    composableLambdaImpl2 = composableLambdaImpl;
                    if (gapComposer.changedInstance(composableLambdaImpl2)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i6 |= i9;
                } else {
                    composableLambdaImpl2 = composableLambdaImpl;
                }
                if ((599187 & i6) != 599186) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (gapComposer.shouldExecute(i6 & 1, z3)) {
                    gapComposer.startDefaults();
                    i7 = -458753;
                    if ((i & 1) != 0 || gapComposer.getDefaultsInvalid()) {
                        if (i10 != 0) {
                            modifier4 = Modifier.Companion.$$INSTANCE;
                        } else {
                            modifier4 = modifier2;
                        }
                        z5 = i4 == 0 ? z2 : true;
                        if ((i2 & 8) != 0) {
                            int i12 = IconButtonDefaults.$r8$clinit;
                            j = ((Color) gapComposer.consume(ContentColorKt.LocalContentColor)).value;
                            iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3 = IconButtonDefaults.m247defaultIconButtonColors4WTKRHQ$material3(((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme, j);
                            if (!Color.m435equalsimpl0(iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3.contentColor, j)) {
                                iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3 = iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3.m246copyjRlVdoo(iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3.containerColor, j, iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3.disabledContainerColor, BrushKt.Color(Color.m440getRedimpl(j), Color.m439getGreenimpl(j), Color.m437getBlueimpl(j), 0.38f, Color.m438getColorSpaceimpl(j)));
                            }
                            i6 &= -7169;
                            iconButtonColors2 = iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3;
                        } else {
                            i7 = -458753;
                            z5 = z5;
                        }
                        int i13 = IconButtonDefaults.$r8$clinit;
                        float f = SmallIconButtonTokens.ContainerHeight;
                        value = ShapesKt.getValue(7, gapComposer);
                        IconButtonColors iconButtonColors4 = iconButtonColors2;
                        i8 = i6 & i7;
                        iconButtonColors3 = iconButtonColors4;
                        z2 = z5;
                    } else {
                        gapComposer.skipToGroupEnd();
                        if ((i2 & 8) != 0) {
                            i6 &= -7169;
                        }
                        iconButtonColors3 = iconButtonColors2;
                        i8 = i6 & (-458753);
                        modifier4 = modifier2;
                        value = shape;
                    }
                    gapComposer.endDefaults();
                    int i14 = i8 << 3;
                    boolean z6 = z2;
                    ComposableLambdaImpl composableLambdaImpl3 = composableLambdaImpl2;
                    Modifier modifier5 = modifier4;
                    IconButtonImpl(modifier5, function0, z6, value, iconButtonColors3, composableLambdaImpl3, gapComposer, (i8 & 3670016) | ((i8 >> 3) & 14) | (i14 & 112) | (i8 & 896) | (57344 & i14) | (i14 & 458752));
                    shape2 = value;
                    z4 = z6;
                    modifier3 = modifier5;
                } else {
                    gapComposer.skipToGroupEnd();
                    modifier3 = modifier2;
                    z4 = z2;
                    iconButtonColors3 = iconButtonColors2;
                    shape2 = shape;
                }
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup != null) {
                    recomposeScopeImplEndRestartGroup.block = new TooltipKt$$ExternalSyntheticLambda4(function0, modifier3, z4, iconButtonColors3, shape2, composableLambdaImpl, i, i2);
                }
            }
            i3 |= 384;
            z2 = z;
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    iconButtonColors2 = iconButtonColors;
                    if (gapComposer.changed(iconButtonColors2)) {
                    }
                    i3 |= i11;
                } else {
                    iconButtonColors2 = iconButtonColors;
                }
                i3 |= i11;
            } else {
                iconButtonColors2 = iconButtonColors;
            }
            i6 = i3 | 24576;
            if ((196608 & i) == 0) {
                i6 = 90112 | i3;
            }
            if ((1572864 & i) == 0) {
                composableLambdaImpl2 = composableLambdaImpl;
                if (gapComposer.changedInstance(composableLambdaImpl2)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i6 |= i9;
            } else {
                composableLambdaImpl2 = composableLambdaImpl;
            }
            if ((599187 & i6) != 599186) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (gapComposer.shouldExecute(i6 & 1, z3)) {
                gapComposer.startDefaults();
                i7 = -458753;
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier4 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 8) != 0) {
                        int i15 = IconButtonDefaults.$r8$clinit;
                        j = ((Color) gapComposer.consume(ContentColorKt.LocalContentColor)).value;
                        iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3 = IconButtonDefaults.m247defaultIconButtonColors4WTKRHQ$material3(((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme, j);
                        if (!Color.m435equalsimpl0(iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3.contentColor, j)) {
                            iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3 = iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3.m246copyjRlVdoo(iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3.containerColor, j, iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3.disabledContainerColor, BrushKt.Color(Color.m440getRedimpl(j), Color.m439getGreenimpl(j), Color.m437getBlueimpl(j), 0.38f, Color.m438getColorSpaceimpl(j)));
                        }
                        i6 &= -7169;
                        iconButtonColors2 = iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3;
                    } else {
                        i7 = -458753;
                        z5 = z5;
                    }
                    int i16 = IconButtonDefaults.$r8$clinit;
                    float f2 = SmallIconButtonTokens.ContainerHeight;
                    value = ShapesKt.getValue(7, gapComposer);
                    IconButtonColors iconButtonColors5 = iconButtonColors2;
                    i8 = i6 & i7;
                    iconButtonColors3 = iconButtonColors5;
                    z2 = z5;
                } else {
                    if (i10 != 0) {
                        modifier4 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 8) != 0) {
                        int i17 = IconButtonDefaults.$r8$clinit;
                        j = ((Color) gapComposer.consume(ContentColorKt.LocalContentColor)).value;
                        iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3 = IconButtonDefaults.m247defaultIconButtonColors4WTKRHQ$material3(((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme, j);
                        if (!Color.m435equalsimpl0(iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3.contentColor, j)) {
                            iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3 = iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3.m246copyjRlVdoo(iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3.containerColor, j, iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3.disabledContainerColor, BrushKt.Color(Color.m440getRedimpl(j), Color.m439getGreenimpl(j), Color.m437getBlueimpl(j), 0.38f, Color.m438getColorSpaceimpl(j)));
                        }
                        i6 &= -7169;
                        iconButtonColors2 = iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3;
                    } else {
                        i7 = -458753;
                        z5 = z5;
                    }
                    int i18 = IconButtonDefaults.$r8$clinit;
                    float f3 = SmallIconButtonTokens.ContainerHeight;
                    value = ShapesKt.getValue(7, gapComposer);
                    IconButtonColors iconButtonColors6 = iconButtonColors2;
                    i8 = i6 & i7;
                    iconButtonColors3 = iconButtonColors6;
                    z2 = z5;
                }
                gapComposer.endDefaults();
                int i19 = i8 << 3;
                boolean z7 = z2;
                ComposableLambdaImpl composableLambdaImpl4 = composableLambdaImpl2;
                Modifier modifier6 = modifier4;
                IconButtonImpl(modifier6, function0, z7, value, iconButtonColors3, composableLambdaImpl4, gapComposer, (i8 & 3670016) | ((i8 >> 3) & 14) | (i19 & 112) | (i8 & 896) | (57344 & i19) | (i19 & 458752));
                shape2 = value;
                z4 = z7;
                modifier3 = modifier6;
            } else {
                gapComposer.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
                iconButtonColors3 = iconButtonColors2;
                shape2 = shape;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new TooltipKt$$ExternalSyntheticLambda4(function0, modifier3, z4, iconButtonColors3, shape2, composableLambdaImpl, i, i2);
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                z2 = z;
                if (gapComposer.changed(z2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    iconButtonColors2 = iconButtonColors;
                    if (gapComposer.changed(iconButtonColors2)) {
                    }
                    i3 |= i11;
                } else {
                    iconButtonColors2 = iconButtonColors;
                }
                i3 |= i11;
            } else {
                iconButtonColors2 = iconButtonColors;
            }
            i6 = i3 | 24576;
            if ((196608 & i) == 0) {
                i6 = 90112 | i3;
            }
            if ((1572864 & i) == 0) {
                composableLambdaImpl2 = composableLambdaImpl;
                if (gapComposer.changedInstance(composableLambdaImpl2)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i6 |= i9;
            } else {
                composableLambdaImpl2 = composableLambdaImpl;
            }
            if ((599187 & i6) != 599186) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (gapComposer.shouldExecute(i6 & 1, z3)) {
                gapComposer.startDefaults();
                i7 = -458753;
                if ((i & 1) != 0) {
                    if (i10 != 0) {
                        modifier4 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 8) != 0) {
                        int i110 = IconButtonDefaults.$r8$clinit;
                        j = ((Color) gapComposer.consume(ContentColorKt.LocalContentColor)).value;
                        iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3 = IconButtonDefaults.m247defaultIconButtonColors4WTKRHQ$material3(((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme, j);
                        if (!Color.m435equalsimpl0(iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3.contentColor, j)) {
                            iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3 = iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3.m246copyjRlVdoo(iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3.containerColor, j, iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3.disabledContainerColor, BrushKt.Color(Color.m440getRedimpl(j), Color.m439getGreenimpl(j), Color.m437getBlueimpl(j), 0.38f, Color.m438getColorSpaceimpl(j)));
                        }
                        i6 &= -7169;
                        iconButtonColors2 = iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3;
                    } else {
                        i7 = -458753;
                        z5 = z5;
                    }
                    int i111 = IconButtonDefaults.$r8$clinit;
                    float f4 = SmallIconButtonTokens.ContainerHeight;
                    value = ShapesKt.getValue(7, gapComposer);
                    IconButtonColors iconButtonColors7 = iconButtonColors2;
                    i8 = i6 & i7;
                    iconButtonColors3 = iconButtonColors7;
                    z2 = z5;
                } else {
                    if (i10 != 0) {
                        modifier4 = Modifier.Companion.$$INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 == 0) {
                    }
                    if ((i2 & 8) != 0) {
                        int i112 = IconButtonDefaults.$r8$clinit;
                        j = ((Color) gapComposer.consume(ContentColorKt.LocalContentColor)).value;
                        iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3 = IconButtonDefaults.m247defaultIconButtonColors4WTKRHQ$material3(((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme, j);
                        if (!Color.m435equalsimpl0(iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3.contentColor, j)) {
                            iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3 = iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3.m246copyjRlVdoo(iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3.containerColor, j, iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3.disabledContainerColor, BrushKt.Color(Color.m440getRedimpl(j), Color.m439getGreenimpl(j), Color.m437getBlueimpl(j), 0.38f, Color.m438getColorSpaceimpl(j)));
                        }
                        i6 &= -7169;
                        iconButtonColors2 = iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3;
                    } else {
                        i7 = -458753;
                        z5 = z5;
                    }
                    int i113 = IconButtonDefaults.$r8$clinit;
                    float f5 = SmallIconButtonTokens.ContainerHeight;
                    value = ShapesKt.getValue(7, gapComposer);
                    IconButtonColors iconButtonColors8 = iconButtonColors2;
                    i8 = i6 & i7;
                    iconButtonColors3 = iconButtonColors8;
                    z2 = z5;
                }
                gapComposer.endDefaults();
                int i114 = i8 << 3;
                boolean z8 = z2;
                ComposableLambdaImpl composableLambdaImpl5 = composableLambdaImpl2;
                Modifier modifier7 = modifier4;
                IconButtonImpl(modifier7, function0, z8, value, iconButtonColors3, composableLambdaImpl5, gapComposer, (i8 & 3670016) | ((i8 >> 3) & 14) | (i114 & 112) | (i8 & 896) | (57344 & i114) | (i114 & 458752));
                shape2 = value;
                z4 = z8;
                modifier3 = modifier7;
            } else {
                gapComposer.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
                iconButtonColors3 = iconButtonColors2;
                shape2 = shape;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new TooltipKt$$ExternalSyntheticLambda4(function0, modifier3, z4, iconButtonColors3, shape2, composableLambdaImpl, i, i2);
            }
        }
        i3 |= 384;
        z2 = z;
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                iconButtonColors2 = iconButtonColors;
                if (gapComposer.changed(iconButtonColors2)) {
                }
                i3 |= i11;
            } else {
                iconButtonColors2 = iconButtonColors;
            }
            i3 |= i11;
        } else {
            iconButtonColors2 = iconButtonColors;
        }
        i6 = i3 | 24576;
        if ((196608 & i) == 0) {
            i6 = 90112 | i3;
        }
        if ((1572864 & i) == 0) {
            composableLambdaImpl2 = composableLambdaImpl;
            if (gapComposer.changedInstance(composableLambdaImpl2)) {
                i9 = 1048576;
            } else {
                i9 = 524288;
            }
            i6 |= i9;
        } else {
            composableLambdaImpl2 = composableLambdaImpl;
        }
        if ((599187 & i6) != 599186) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (gapComposer.shouldExecute(i6 & 1, z3)) {
            gapComposer.startDefaults();
            i7 = -458753;
            if ((i & 1) != 0) {
                if (i10 != 0) {
                    modifier4 = Modifier.Companion.$$INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 == 0) {
                }
                if ((i2 & 8) != 0) {
                    int i115 = IconButtonDefaults.$r8$clinit;
                    j = ((Color) gapComposer.consume(ContentColorKt.LocalContentColor)).value;
                    iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3 = IconButtonDefaults.m247defaultIconButtonColors4WTKRHQ$material3(((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme, j);
                    if (!Color.m435equalsimpl0(iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3.contentColor, j)) {
                        iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3 = iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3.m246copyjRlVdoo(iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3.containerColor, j, iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3.disabledContainerColor, BrushKt.Color(Color.m440getRedimpl(j), Color.m439getGreenimpl(j), Color.m437getBlueimpl(j), 0.38f, Color.m438getColorSpaceimpl(j)));
                    }
                    i6 &= -7169;
                    iconButtonColors2 = iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3;
                } else {
                    i7 = -458753;
                    z5 = z5;
                }
                int i116 = IconButtonDefaults.$r8$clinit;
                float f6 = SmallIconButtonTokens.ContainerHeight;
                value = ShapesKt.getValue(7, gapComposer);
                IconButtonColors iconButtonColors9 = iconButtonColors2;
                i8 = i6 & i7;
                iconButtonColors3 = iconButtonColors9;
                z2 = z5;
            } else {
                if (i10 != 0) {
                    modifier4 = Modifier.Companion.$$INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 == 0) {
                }
                if ((i2 & 8) != 0) {
                    int i117 = IconButtonDefaults.$r8$clinit;
                    j = ((Color) gapComposer.consume(ContentColorKt.LocalContentColor)).value;
                    iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3 = IconButtonDefaults.m247defaultIconButtonColors4WTKRHQ$material3(((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme, j);
                    if (!Color.m435equalsimpl0(iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3.contentColor, j)) {
                        iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3 = iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3.m246copyjRlVdoo(iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3.containerColor, j, iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3.disabledContainerColor, BrushKt.Color(Color.m440getRedimpl(j), Color.m439getGreenimpl(j), Color.m437getBlueimpl(j), 0.38f, Color.m438getColorSpaceimpl(j)));
                    }
                    i6 &= -7169;
                    iconButtonColors2 = iconButtonColorsM247defaultIconButtonColors4WTKRHQ$material3;
                } else {
                    i7 = -458753;
                    z5 = z5;
                }
                int i118 = IconButtonDefaults.$r8$clinit;
                float f7 = SmallIconButtonTokens.ContainerHeight;
                value = ShapesKt.getValue(7, gapComposer);
                IconButtonColors iconButtonColors10 = iconButtonColors2;
                i8 = i6 & i7;
                iconButtonColors3 = iconButtonColors10;
                z2 = z5;
            }
            gapComposer.endDefaults();
            int i119 = i8 << 3;
            boolean z9 = z2;
            ComposableLambdaImpl composableLambdaImpl6 = composableLambdaImpl2;
            Modifier modifier8 = modifier4;
            IconButtonImpl(modifier8, function0, z9, value, iconButtonColors3, composableLambdaImpl6, gapComposer, (i8 & 3670016) | ((i8 >> 3) & 14) | (i119 & 112) | (i8 & 896) | (57344 & i119) | (i119 & 458752));
            shape2 = value;
            z4 = z9;
            modifier3 = modifier8;
        } else {
            gapComposer.skipToGroupEnd();
            modifier3 = modifier2;
            z4 = z2;
            iconButtonColors3 = iconButtonColors2;
            shape2 = shape;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TooltipKt$$ExternalSyntheticLambda4(function0, modifier3, z4, iconButtonColors3, shape2, composableLambdaImpl, i, i2);
        }
    }

    public static final void IconButtonImpl(Modifier modifier, Function0 function0, boolean z, Shape shape, IconButtonColors iconButtonColors, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        int i2;
        gapComposer.startRestartGroup(-1134296466);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changed(shape) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= gapComposer.changed(iconButtonColors) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= gapComposer.changed((Object) null) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl) ? 1048576 : 524288;
        }
        int i3 = i2;
        if (gapComposer.shouldExecute(i3 & 1, (599187 & i3) != 599186)) {
            gapComposer.startReplaceGroup(976976045);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == Composer$Companion.Empty) {
                objRememberedValue = new MutableInteractionSourceImpl();
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            MutableInteractionSourceImpl mutableInteractionSourceImpl = (MutableInteractionSourceImpl) objRememberedValue;
            gapComposer.end(false);
            HorizontalAlignmentLine horizontalAlignmentLine = InteractiveComponentSizeKt.MinimumInteractiveTopAlignmentLine;
            Modifier modifierThen = modifier.then(MinimumInteractiveModifier.INSTANCE);
            int i4 = IconButtonDefaults.$r8$clinit;
            float f = SmallIconButtonTokens.DefaultLeadingSpace;
            long jM706DpSizeYgX7TsA = DpKt.m706DpSizeYgX7TsA(SmallIconButtonTokens.IconSize + f + f, SmallIconButtonTokens.ContainerHeight);
            FillElement fillElement = SizeKt.FillWholeMaxWidth;
            Modifier modifierThen2 = ImageKt.m50clickableO2vRcR0$default(ImageKt.m47backgroundbw27NRU(ClipKt.clip(SizeKt.m141sizeVpY3zN4(modifierThen, DpSize.m711getWidthD9Ej5fM(jM706DpSizeYgX7TsA), DpSize.m710getHeightD9Ej5fM(jM706DpSizeYgX7TsA)), shape), z ? iconButtonColors.containerColor : iconButtonColors.disabledContainerColor, shape), mutableInteractionSourceImpl, RippleKt.m260rippleOu1YvPQ$default(0.0f, 0L, shape, false, 247), z, new Role(0), function0, 8).then(new ChildSemanticsNodeElement(new SaversKt$$ExternalSyntheticLambda10(17)));
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.Center, false);
            long j = gapComposer.compositeKeyHashCode;
            int i5 = (int) (j ^ (j >>> 32));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifierThen2);
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer.startReusableNode();
            if (gapComposer.inserting) {
                gapComposer.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer.useNode();
            }
            Stack.m295setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            Stack.m295setimpl(gapComposer, Integer.valueOf(i5), ComposeUiNode.Companion.SetCompositeKeyHash);
            Stack.m294reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
            Stack.m295setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
            Stack.CompositionLocalProvider(ContentColorKt.LocalContentColor.defaultProvidedValue$runtime(new Color(z ? iconButtonColors.contentColor : iconButtonColors.disabledContentColor)), composableLambdaImpl, gapComposer, ((i3 >> 15) & 112) | 8);
            gapComposer.end(true);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new CheckboxKt$$ExternalSyntheticLambda4(modifier, function0, z, shape, iconButtonColors, composableLambdaImpl, i);
        }
    }

    /* JADX WARN: Failed to calculate best type for var: r0v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v0 ??, new type: androidx.compose.runtime.GapComposer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v0 ??, new type: androidx.compose.runtime.GapComposer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v1 ??, new type: androidx.compose.runtime.GapComposer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v1 ??, new type: androidx.compose.runtime.GapComposer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r0v6 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r0v6 ??, new type: androidx.compose.runtime.GapComposer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r21v5 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r21v5 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r47v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r47v0 ??, new type: androidx.compose.runtime.GapComposer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r8v13 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r8v13 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to set immutable type for var: r47v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r47v0 ??, new type: androidx.compose.runtime.GapComposer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setImmutableType(TypeInferenceVisitor.java:111)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:102)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:102)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v9 ??, new type: boolean
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    /* JADX INFO: renamed from: ModalBottomSheet-YbuCTN8, reason: not valid java name */
    public static final void m265ModalBottomSheetYbuCTN8(kotlin.jvm.functions.Function0 r30, androidx.compose.ui.Modifier r31, androidx.compose.material3.SheetState r32, float r33, boolean r34, androidx.compose.ui.graphics.Shape r35, long r36, long r38, float r40, long r41, kotlin.jvm.functions.Function2 r43, kotlin.jvm.functions.Function2 r44, androidx.compose.material3.ModalBottomSheetProperties r45, androidx.compose.runtime.internal.ComposableLambdaImpl r46, androidx.compose.runtime.GapComposer r47, int r48, int r49, int r50) {
        /*
            Method dump skipped, instruction units count: 739
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ScrimKt.m265ModalBottomSheetYbuCTN8(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.material3.SheetState, float, boolean, androidx.compose.ui.graphics.Shape, long, long, float, long, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.material3.ModalBottomSheetProperties, androidx.compose.runtime.internal.ComposableLambdaImpl, androidx.compose.runtime.GapComposer, int, int, int):void");
    }

    /* JADX INFO: renamed from: ModalBottomSheetDialog-sW7UJKQ, reason: not valid java name */
    public static final void m266ModalBottomSheetDialogsW7UJKQ(final Function0 function0, long j, final ModalBottomSheetProperties modalBottomSheetProperties, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        int i2;
        ModalBottomSheetProperties modalBottomSheetProperties2;
        final LayoutDirection layoutDirection;
        boolean z;
        boolean z2;
        long j2 = j;
        gapComposer.startRestartGroup(-85756322);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(j2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            modalBottomSheetProperties2 = modalBottomSheetProperties;
            i2 |= gapComposer.changed(modalBottomSheetProperties2) ? 256 : 128;
        } else {
            modalBottomSheetProperties2 = modalBottomSheetProperties;
        }
        if ((i & 3072) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl) ? 2048 : 1024;
        }
        int i3 = i2;
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 1171) != 1170)) {
            gapComposer.startDefaults();
            if ((i & 1) != 0 && !gapComposer.getDefaultsInvalid()) {
                gapComposer.skipToGroupEnd();
            }
            gapComposer.endDefaults();
            View view = (View) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalView);
            Density density = (Density) gapComposer.consume(CompositionLocalsKt.LocalDensity);
            LayoutDirection layoutDirection2 = (LayoutDirection) gapComposer.consume(CompositionLocalsKt.LocalLayoutDirection);
            GapComposer.CompositionContextImpl compositionContextImplRememberCompositionContext = Stack.rememberCompositionContext(gapComposer);
            MutableState mutableStateRememberUpdatedState = Stack.rememberUpdatedState(composableLambdaImpl, gapComposer);
            Object[] objArr = new Object[0];
            Object objRememberedValue = gapComposer.rememberedValue();
            Object obj = Composer$Companion.Empty;
            if (objRememberedValue == obj) {
                objRememberedValue = new ImmLeaksCleaner$$ExternalSyntheticLambda0(28);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            UUID uuid = (UUID) SaverKt.rememberSaveable(objArr, (Function0) objRememberedValue, gapComposer);
            boolean zChanged = gapComposer.changed(view) | gapComposer.changed(density);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue2 == obj) {
                layoutDirection = layoutDirection2;
                z = true;
                z2 = false;
                ModalBottomSheetDialogWrapper modalBottomSheetDialogWrapper = new ModalBottomSheetDialogWrapper(function0, modalBottomSheetProperties2, j2, view, layoutDirection, density, uuid);
                j2 = j2;
                ComposableLambdaImpl composableLambdaImpl2 = new ComposableLambdaImpl(1379699857, new AndroidMenu_androidKt$$ExternalSyntheticLambda0(mutableStateRememberUpdatedState, 1), true);
                ModalBottomSheetDialogLayout modalBottomSheetDialogLayout = modalBottomSheetDialogWrapper.dialogLayout;
                modalBottomSheetDialogLayout.setParentCompositionContext(compositionContextImplRememberCompositionContext);
                modalBottomSheetDialogLayout.content$delegate.setValue(composableLambdaImpl2);
                modalBottomSheetDialogLayout.shouldCreateCompositionOnAttachedToWindow = true;
                modalBottomSheetDialogLayout.createComposition();
                gapComposer.updateRememberedValue(modalBottomSheetDialogWrapper);
                objRememberedValue2 = modalBottomSheetDialogWrapper;
            } else {
                layoutDirection = layoutDirection2;
                z = true;
                z2 = false;
            }
            final ModalBottomSheetDialogWrapper modalBottomSheetDialogWrapper2 = (ModalBottomSheetDialogWrapper) objRememberedValue2;
            boolean zChangedInstance = gapComposer.changedInstance(modalBottomSheetDialogWrapper2);
            Object objRememberedValue3 = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == obj) {
                objRememberedValue3 = new Recomposer$$ExternalSyntheticLambda0(25, modalBottomSheetDialogWrapper2);
                gapComposer.updateRememberedValue(objRememberedValue3);
            }
            Stack.DisposableEffect(modalBottomSheetDialogWrapper2, (Function1) objRememberedValue3, gapComposer);
            boolean zChangedInstance2 = gapComposer.changedInstance(modalBottomSheetDialogWrapper2) | ((i3 & 14) == 4 ? z : z2) | ((i3 & 896) == 256 ? z : z2);
            if ((((i3 & 112) ^ 48) <= 32 || !gapComposer.changed(j2)) && (i3 & 48) != 32) {
                z = z2;
            }
            boolean zChanged2 = zChangedInstance2 | z | gapComposer.changed(layoutDirection.ordinal());
            Object objRememberedValue4 = gapComposer.rememberedValue();
            if (zChanged2 || objRememberedValue4 == obj) {
                final long j3 = j2;
                Object obj2 = new Function0() { // from class: androidx.compose.material3.ModalBottomSheet_androidKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        modalBottomSheetDialogWrapper2.m251updateParameters9LQNqLg(function0, modalBottomSheetProperties, j3, layoutDirection);
                        return Unit.INSTANCE;
                    }
                };
                gapComposer.updateRememberedValue(obj2);
                objRememberedValue4 = obj2;
            }
            Stack.SideEffect((Function0) objRememberedValue4, gapComposer);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new IconKt$$ExternalSyntheticLambda2(function0, j, modalBottomSheetProperties, composableLambdaImpl, i);
        }
    }

    /* JADX INFO: renamed from: Scrim-yrwZFoE, reason: not valid java name */
    public static final void m267ScrimyrwZFoE(final String str, Modifier modifier, final Function0 function0, final Function0 function1, final long j, GapComposer gapComposer, final int i) {
        final Modifier modifier2;
        Modifier modifier3;
        boolean z;
        gapComposer.startRestartGroup(-2078815310);
        int i2 = i | (gapComposer.changed(str) ? 4 : 2) | 48 | (gapComposer.changedInstance(function0) ? 256 : 128) | (gapComposer.changedInstance(function1) ? 2048 : 1024) | (gapComposer.changed(j) ? 16384 : 8192);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 9363) != 9362)) {
            gapComposer.startDefaults();
            int i3 = i & 1;
            Modifier modifierSemantics = Modifier.Companion.$$INSTANCE;
            if (i3 == 0 || gapComposer.getDefaultsInvalid()) {
                modifier3 = modifierSemantics;
            } else {
                gapComposer.skipToGroupEnd();
                modifier3 = modifier;
            }
            gapComposer.endDefaults();
            if (j != 16) {
                gapComposer.startReplaceGroup(-853219337);
                NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
                if (function0 != null) {
                    gapComposer.startReplaceGroup(-853120974);
                    int i4 = i2 & 896;
                    boolean z2 = i4 == 256;
                    Object objRememberedValue = gapComposer.rememberedValue();
                    if (z2 || objRememberedValue == neverEqualPolicy) {
                        objRememberedValue = new ScrimKt$Scrim$dismissModifier$1$1(0, function0);
                        gapComposer.updateRememberedValue(objRememberedValue);
                    }
                    SuspendPointerInputElement suspendPointerInputElement = new SuspendPointerInputElement(function0, null, (PointerInputEventHandler) objRememberedValue, 6);
                    boolean z3 = ((i2 & 14) == 4) | (i4 == 256);
                    Object objRememberedValue2 = gapComposer.rememberedValue();
                    if (z3 || objRememberedValue2 == neverEqualPolicy) {
                        objRememberedValue2 = new BlurEffectKt$$ExternalSyntheticLambda1(4, str, function0);
                        gapComposer.updateRememberedValue(objRememberedValue2);
                    }
                    z = true;
                    modifierSemantics = SemanticsModifierKt.semantics(suspendPointerInputElement, true, (Function1) objRememberedValue2);
                    gapComposer.end(false);
                } else {
                    z = true;
                    gapComposer.startReplaceGroup(-852623672);
                    gapComposer.end(false);
                }
                Modifier modifierThen = modifier3.then(SizeKt.FillWholeMaxSize).then(modifierSemantics);
                boolean z4 = (((((57344 & i2) ^ 24576) <= 16384 || !gapComposer.changed(j)) && (i2 & 24576) != 16384) ? false : z) | ((i2 & 7168) == 2048 ? z : false);
                Object objRememberedValue3 = gapComposer.rememberedValue();
                if (z4 || objRememberedValue3 == neverEqualPolicy) {
                    objRememberedValue3 = new Function1() { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Modifier.CC.m315drawRectnJ9OG0$default((DrawScope) obj, j, 0L, RangesKt.coerceIn(((Number) function1.invoke()).floatValue(), 0.0f, 1.0f), 0, 118);
                            return Unit.INSTANCE;
                        }
                    };
                    gapComposer.updateRememberedValue(objRememberedValue3);
                }
                ImageKt.Canvas(modifierThen, (Function1) objRememberedValue3, gapComposer, 0);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(-852426512);
                gapComposer.end(false);
            }
            modifier2 = modifier3;
        } else {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2(str, modifier2, function0, function1, j, i) { // from class: androidx.compose.material3.ScrimKt$$ExternalSyntheticLambda2
                public final /* synthetic */ String f$0;
                public final /* synthetic */ Modifier f$1;
                public final /* synthetic */ Function0 f$2;
                public final /* synthetic */ Function0 f$3;
                public final /* synthetic */ long f$4;

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(1);
                    ScrimKt.m267ScrimyrwZFoE(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, (GapComposer) obj, iUpdateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void SnackbarHost(SnackbarHostState snackbarHostState, Modifier modifier, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        int i2;
        gapComposer.startRestartGroup(-1077081618);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(snackbarHostState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changed(modifier) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl) ? 256 : 128;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            SnackbarHostState.SnackbarDataImpl snackbarDataImpl = (SnackbarHostState.SnackbarDataImpl) snackbarHostState.currentSnackbarData$delegate.getValue();
            AccessibilityManager accessibilityManager = (AccessibilityManager) gapComposer.consume(CompositionLocalsKt.LocalAccessibilityManager);
            boolean zChanged = gapComposer.changed(snackbarDataImpl) | gapComposer.changedInstance(accessibilityManager);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChanged || objRememberedValue == Composer$Companion.Empty) {
                objRememberedValue = new RealImageLoader$execute$3(snackbarDataImpl, accessibilityManager, null, 19);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            Stack.LaunchedEffect(gapComposer, snackbarDataImpl, (Function2) objRememberedValue);
            FadeInFadeOutWithScale((SnackbarHostState.SnackbarDataImpl) snackbarHostState.currentSnackbarData$delegate.getValue(), modifier, composableLambdaImpl, gapComposer, i2 & 1008);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new SnackbarHostKt$$ExternalSyntheticLambda0(snackbarHostState, modifier, composableLambdaImpl, i, 0);
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x005b  */
    /* JADX WARN: Code duplicated, block: B:28:0x005d  */
    /* JADX WARN: Code duplicated, block: B:31:0x0066  */
    /* JADX WARN: Code duplicated, block: B:40:0x008b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x008e  */
    /* JADX WARN: Code duplicated, block: B:45:0x009e  */
    /* JADX WARN: Code duplicated, block: B:47:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:48:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:50:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:53:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:56:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:58:? A[RETURN, SYNTHETIC] */
    public static final void TextButton(Function0 function0, Modifier modifier, boolean z, Shape shape, ButtonColors buttonColors, PaddingValues paddingValues, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i, int i2) {
        Function0 function1;
        int i3;
        boolean z2;
        int i4;
        ButtonColors buttonColors2;
        int i5;
        boolean z3;
        Modifier modifier2;
        Shape shape2;
        PaddingValues paddingValues2;
        ButtonColors buttonColors3;
        boolean z4;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        int i6;
        ButtonColors buttonColors4;
        PaddingValues paddingValues3;
        int i7;
        boolean z5;
        Shape shape3;
        Modifier modifier3;
        ColorScheme colorScheme;
        ButtonColors buttonColors5;
        gapComposer.startRestartGroup(-1061374109);
        if ((i & 6) == 0) {
            function1 = function0;
            i3 = i | (gapComposer.changedInstance(function1) ? 4 : 2);
        } else {
            function1 = function0;
            i3 = i;
        }
        int i8 = i3 | 48;
        int i9 = i2 & 4;
        if (i9 != 0) {
            i4 = i3 | 432;
            z2 = z;
        } else {
            z2 = z;
            i4 = i8 | (gapComposer.changed(z2) ? 256 : 128);
        }
        int i10 = i4 | 1024;
        if ((i2 & 16) == 0) {
            buttonColors2 = buttonColors;
            int i11 = gapComposer.changed(buttonColors2) ? 16384 : 8192;
            i5 = i10 | i11 | 115015680;
            if ((306783379 & i5) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (gapComposer.shouldExecute(i5 & 1, z3)) {
                gapComposer.startDefaults();
                if ((i & 1) != 0 || gapComposer.getDefaultsInvalid()) {
                    boolean z6 = i9 == 0 ? z2 : true;
                    PaddingValuesImpl paddingValuesImpl = ButtonDefaults.ContentPadding;
                    float f = ButtonSmallTokens.ContainerHeight;
                    Shape value = ShapesKt.getValue(7, gapComposer);
                    i6 = i5 & (-7169);
                    if ((i2 & 16) != 0) {
                        colorScheme = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme;
                        buttonColors5 = colorScheme.defaultTextButtonColorsCached;
                        if (buttonColors5 == null) {
                            long j = Color.Transparent;
                            long jFromToken = ColorSchemeKt.fromToken(colorScheme, 26);
                            long jFromToken2 = ColorSchemeKt.fromToken(colorScheme, 19);
                            buttonColors4 = new ButtonColors(j, jFromToken, j, BrushKt.Color(Color.m440getRedimpl(jFromToken2), Color.m439getGreenimpl(jFromToken2), Color.m437getBlueimpl(jFromToken2), 0.38f, Color.m438getColorSpaceimpl(jFromToken2)));
                            colorScheme.defaultTextButtonColorsCached = buttonColors4;
                        } else {
                            buttonColors4 = buttonColors5;
                        }
                        i6 = i5 & (-64513);
                    } else {
                        buttonColors4 = buttonColors2;
                    }
                    paddingValues3 = ButtonDefaults.TextButtonContentPadding;
                    i7 = i6;
                    z5 = z6;
                    shape3 = value;
                    modifier3 = Modifier.Companion.$$INSTANCE;
                    buttonColors2 = buttonColors4;
                } else {
                    gapComposer.skipToGroupEnd();
                    int i12 = i5 & (-7169);
                    if ((i2 & 16) != 0) {
                        i12 = i5 & (-64513);
                    }
                    paddingValues3 = paddingValues;
                    z5 = z2;
                    i7 = i12;
                    modifier3 = modifier;
                    shape3 = shape;
                }
                gapComposer.endDefaults();
                Button(function1, modifier3, z5, shape3, buttonColors2, null, paddingValues3, composableLambdaImpl, gapComposer, i7 & 2147483646, 0);
                shape2 = shape3;
                paddingValues2 = paddingValues3;
                modifier2 = modifier3;
                buttonColors3 = buttonColors2;
                z4 = z5;
            } else {
                gapComposer.skipToGroupEnd();
                modifier2 = modifier;
                shape2 = shape;
                paddingValues2 = paddingValues;
                buttonColors3 = buttonColors2;
                z4 = z2;
            }
            recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
            if (recomposeScopeImplEndRestartGroup != null) {
                recomposeScopeImplEndRestartGroup.block = new ButtonKt$$ExternalSyntheticLambda0(function0, modifier2, z4, shape2, buttonColors3, paddingValues2, composableLambdaImpl, i, i2);
            }
        }
        buttonColors2 = buttonColors;
        i5 = i10 | i11 | 115015680;
        if ((306783379 & i5) != 306783378) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (gapComposer.shouldExecute(i5 & 1, z3)) {
            gapComposer.startDefaults();
            if ((i & 1) != 0) {
                if (i9 == 0) {
                }
                PaddingValuesImpl paddingValuesImpl2 = ButtonDefaults.ContentPadding;
                float f2 = ButtonSmallTokens.ContainerHeight;
                Shape value2 = ShapesKt.getValue(7, gapComposer);
                i6 = i5 & (-7169);
                if ((i2 & 16) != 0) {
                    colorScheme = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme;
                    buttonColors5 = colorScheme.defaultTextButtonColorsCached;
                    if (buttonColors5 == null) {
                        long j2 = Color.Transparent;
                        long jFromToken3 = ColorSchemeKt.fromToken(colorScheme, 26);
                        long jFromToken4 = ColorSchemeKt.fromToken(colorScheme, 19);
                        buttonColors4 = new ButtonColors(j2, jFromToken3, j2, BrushKt.Color(Color.m440getRedimpl(jFromToken4), Color.m439getGreenimpl(jFromToken4), Color.m437getBlueimpl(jFromToken4), 0.38f, Color.m438getColorSpaceimpl(jFromToken4)));
                        colorScheme.defaultTextButtonColorsCached = buttonColors4;
                    } else {
                        buttonColors4 = buttonColors5;
                    }
                    i6 = i5 & (-64513);
                } else {
                    buttonColors4 = buttonColors2;
                }
                paddingValues3 = ButtonDefaults.TextButtonContentPadding;
                i7 = i6;
                z5 = z6;
                shape3 = value2;
                modifier3 = Modifier.Companion.$$INSTANCE;
                buttonColors2 = buttonColors4;
            } else {
                if (i9 == 0) {
                }
                PaddingValuesImpl paddingValuesImpl3 = ButtonDefaults.ContentPadding;
                float f3 = ButtonSmallTokens.ContainerHeight;
                Shape value3 = ShapesKt.getValue(7, gapComposer);
                i6 = i5 & (-7169);
                if ((i2 & 16) != 0) {
                    colorScheme = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).colorScheme;
                    buttonColors5 = colorScheme.defaultTextButtonColorsCached;
                    if (buttonColors5 == null) {
                        long j3 = Color.Transparent;
                        long jFromToken5 = ColorSchemeKt.fromToken(colorScheme, 26);
                        long jFromToken6 = ColorSchemeKt.fromToken(colorScheme, 19);
                        buttonColors4 = new ButtonColors(j3, jFromToken5, j3, BrushKt.Color(Color.m440getRedimpl(jFromToken6), Color.m439getGreenimpl(jFromToken6), Color.m437getBlueimpl(jFromToken6), 0.38f, Color.m438getColorSpaceimpl(jFromToken6)));
                        colorScheme.defaultTextButtonColorsCached = buttonColors4;
                    } else {
                        buttonColors4 = buttonColors5;
                    }
                    i6 = i5 & (-64513);
                } else {
                    buttonColors4 = buttonColors2;
                }
                paddingValues3 = ButtonDefaults.TextButtonContentPadding;
                i7 = i6;
                z5 = z6;
                shape3 = value3;
                modifier3 = Modifier.Companion.$$INSTANCE;
                buttonColors2 = buttonColors4;
            }
            gapComposer.endDefaults();
            Button(function1, modifier3, z5, shape3, buttonColors2, null, paddingValues3, composableLambdaImpl, gapComposer, i7 & 2147483646, 0);
            shape2 = shape3;
            paddingValues2 = paddingValues3;
            modifier2 = modifier3;
            buttonColors3 = buttonColors2;
            z4 = z5;
        } else {
            gapComposer.skipToGroupEnd();
            modifier2 = modifier;
            shape2 = shape;
            paddingValues2 = paddingValues;
            buttonColors3 = buttonColors2;
            z4 = z2;
        }
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ButtonKt$$ExternalSyntheticLambda0(function0, modifier2, z4, shape2, buttonColors3, paddingValues2, composableLambdaImpl, i, i2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:234:0x04be  */
    /* JADX WARN: Code duplicated, block: B:238:0x04c5  */
    /* JADX WARN: Code duplicated, block: B:241:0x04ff  */
    /* JADX WARN: Code duplicated, block: B:242:0x0503  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v10, types: [int] */
    /* JADX WARN: Type inference failed for: r12v44 */
    /* JADX WARN: Type inference failed for: r12v52 */
    /* JADX WARN: Type inference failed for: r39v0, types: [java.lang.Object, kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r41v0, types: [java.lang.Object, kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r42v0, types: [java.lang.Object, kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r43v0, types: [java.lang.Object, kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r44v0, types: [java.lang.Object, kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r50v0, types: [androidx.compose.runtime.internal.ComposableLambdaImpl, java.lang.Object] */
    public static final void TextFieldLayout(Function2 function2, final Function2 function3, Function3 function4, final Function2 function5, final Function2 function6, final Function2 function7, final Function2 function8, final boolean z, final TextFieldLabelPosition$Attached textFieldLabelPosition$Attached, final TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0, final TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1, final TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$2, final ComposableLambdaImpl composableLambdaImpl, Function2 function9, PaddingValues paddingValues, GapComposer gapComposer, final int i, final int i2) {
        int i3;
        int i4;
        Function2 function10;
        Function3 function11;
        Function2 function12;
        final PaddingValues paddingValues2;
        GapComposer gapComposer2;
        char c;
        GapComposer gapComposer3;
        BiasAlignment biasAlignment;
        boolean z2;
        ?? r12;
        float f;
        BiasAlignment biasAlignment2;
        int i5;
        Function3 function13;
        Function2 function14;
        boolean z3;
        TextFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0 textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$3;
        boolean z4;
        Object objRememberedValue;
        BiasAlignment biasAlignment3 = Alignment.Companion.Center;
        BiasAlignment biasAlignment4 = Alignment.Companion.TopStart;
        gapComposer.startRestartGroup(-1552532491);
        int i6 = i & 6;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        if (i6 == 0) {
            i3 = i | (gapComposer.changed(companion) ? 4 : 2);
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= gapComposer.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= gapComposer.changedInstance(function3) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= gapComposer.changedInstance(function4) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= gapComposer.changedInstance(function5) ? 16384 : 8192;
        }
        if ((i & 196608) == 0) {
            i3 |= gapComposer.changedInstance(function6) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i3 |= gapComposer.changedInstance(function7) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= gapComposer.changedInstance(function8) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= gapComposer.changed(z) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= gapComposer.changed(textFieldLabelPosition$Attached) ? 536870912 : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | ((i2 & 8) == 0 ? gapComposer.changed(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0) : gapComposer.changedInstance(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= (i2 & 64) == 0 ? gapComposer.changed(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1) : gapComposer.changedInstance(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= (i2 & 512) == 0 ? gapComposer.changed(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$2) : gapComposer.changedInstance(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$2) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= gapComposer.changedInstance(composableLambdaImpl) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= gapComposer.changedInstance(function9) ? 16384 : 8192;
        }
        if ((i2 & 196608) == 0) {
            i4 |= gapComposer.changed(paddingValues) ? 131072 : 65536;
        }
        int i7 = i4;
        if (gapComposer.shouldExecute(i3 & 1, ((i3 & 306783379) == 306783378 && (74899 & i7) == 74898) ? false : true)) {
            float fMinimizedLabelHalfHeight = TextFieldImplKt.minimizedLabelHalfHeight(gapComposer);
            int i8 = i7 & 14;
            boolean zChanged = ((i7 & 896) == 256 || ((i7 & 512) != 0 && gapComposer.changed(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$2))) | ((i3 & 1879048192) == 536870912) | ((i3 & 234881024) == 67108864) | (i8 == 4 || ((i7 & 8) != 0 && gapComposer.changed(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0))) | ((i7 & 112) == 32 || ((i7 & 64) != 0 && gapComposer.changed(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1))) | ((458752 & i7) == 131072) | gapComposer.changed(fMinimizedLabelHalfHeight);
            Object objRememberedValue2 = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (zChanged || objRememberedValue2 == neverEqualPolicy) {
                c = ' ';
                GapComposer gapComposer4 = gapComposer;
                objRememberedValue2 = new TextFieldMeasurePolicy(z, textFieldLabelPosition$Attached, textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0, textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1, textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$2, paddingValues, fMinimizedLabelHalfHeight);
                paddingValues2 = paddingValues;
                gapComposer4.updateRememberedValue(objRememberedValue2);
                gapComposer3 = gapComposer4;
            } else {
                paddingValues2 = paddingValues;
                c = ' ';
                gapComposer3 = gapComposer;
            }
            TextFieldMeasurePolicy textFieldMeasurePolicy = (TextFieldMeasurePolicy) objRememberedValue2;
            LayoutDirection layoutDirection = (LayoutDirection) gapComposer3.consume(CompositionLocalsKt.LocalLayoutDirection);
            long j = gapComposer3.compositeKeyHashCode;
            int i9 = (int) (j ^ (j >>> c));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer3.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer3, companion);
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            gapComposer3.startReusableNode();
            if (gapComposer3.inserting) {
                gapComposer3.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer3.useNode();
            }
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$1 = ComposeUiNode.Companion.SetMeasurePolicy;
            Stack.m295setimpl(gapComposer3, textFieldMeasurePolicy, composeUiNode$Companion$SetModifier$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope, composeUiNode$Companion$SetModifier$2);
            Integer numValueOf = Integer.valueOf(i9);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetCompositeKeyHash;
            Stack.m295setimpl(gapComposer3, numValueOf, composeUiNode$Companion$SetModifier$3);
            OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
            Stack.m294reconcileimpl(gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$1);
            ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetModifier;
            Stack.m295setimpl(gapComposer3, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$4);
            composableLambdaImpl.invoke(gapComposer3, Integer.valueOf((i7 >> 9) & 14));
            if (function5 != 0) {
                gapComposer3.startReplaceGroup(993153366);
                Modifier modifierLayoutId = RulerKt.layoutId(companion, "Leading");
                HorizontalAlignmentLine horizontalAlignmentLine = InteractiveComponentSizeKt.MinimumInteractiveTopAlignmentLine;
                Modifier modifierThen = modifierLayoutId.then(MinimumInteractiveModifier.INSTANCE);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(r16, false);
                long j2 = gapComposer3.compositeKeyHashCode;
                int i10 = (int) (j2 ^ (j2 >>> c));
                PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer3.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer3, modifierThen);
                gapComposer3.startReusableNode();
                biasAlignment = biasAlignment3;
                if (gapComposer3.inserting) {
                    gapComposer3.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    gapComposer3.useNode();
                }
                Stack.m295setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy, composeUiNode$Companion$SetModifier$1);
                Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$2);
                ImageAnalysis$$ExternalSyntheticLambda1.m(i10, gapComposer3, composeUiNode$Companion$SetModifier$3, gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$1);
                Stack.m295setimpl(gapComposer3, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$4);
                function5.invoke(gapComposer3, Integer.valueOf((i3 >> 12) & 14));
                gapComposer3.end(true);
                z2 = false;
                gapComposer3.end(false);
            } else {
                biasAlignment = r16;
                z2 = false;
                gapComposer3.startReplaceGroup(993399382);
                gapComposer3.end(false);
            }
            if (function6 != 0) {
                gapComposer3.startReplaceGroup(993442100);
                Modifier modifierLayoutId2 = RulerKt.layoutId(companion, "Trailing");
                HorizontalAlignmentLine horizontalAlignmentLine2 = InteractiveComponentSizeKt.MinimumInteractiveTopAlignmentLine;
                Modifier modifierThen2 = modifierLayoutId2.then(MinimumInteractiveModifier.INSTANCE);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, z2);
                long j3 = gapComposer3.compositeKeyHashCode;
                int i11 = (int) (j3 ^ (j3 >>> c));
                PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope3 = gapComposer3.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier3 = AbsoluteAlignment.materializeModifier(gapComposer3, modifierThen2);
                gapComposer3.startReusableNode();
                if (gapComposer3.inserting) {
                    gapComposer3.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    gapComposer3.useNode();
                }
                Stack.m295setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy2, composeUiNode$Companion$SetModifier$1);
                Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope3, composeUiNode$Companion$SetModifier$2);
                ImageAnalysis$$ExternalSyntheticLambda1.m(i11, gapComposer3, composeUiNode$Companion$SetModifier$3, gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$1);
                Stack.m295setimpl(gapComposer3, modifierMaterializeModifier3, composeUiNode$Companion$SetModifier$4);
                function6.invoke(gapComposer3, Integer.valueOf((i3 >> 15) & 14));
                gapComposer3.end(true);
                r12 = 0;
                gapComposer3.end(false);
            } else {
                gapComposer3.startReplaceGroup(993690038);
                gapComposer3.end(z2);
                r12 = z2;
            }
            float fCalculateStartPadding = OffsetKt.calculateStartPadding(paddingValues2, layoutDirection);
            float fCalculateEndPadding = OffsetKt.calculateEndPadding(paddingValues2, layoutDirection);
            float fTextFieldHorizontalIconPadding = TextFieldImplKt.textFieldHorizontalIconPadding(gapComposer3);
            if (function5 != 0) {
                fCalculateStartPadding -= fTextFieldHorizontalIconPadding;
                float f2 = (float) r12;
                if (fCalculateStartPadding < f2) {
                    fCalculateStartPadding = f2;
                }
            }
            float f3 = fCalculateStartPadding;
            if (function6 != 0) {
                fCalculateEndPadding -= fTextFieldHorizontalIconPadding;
                float f4 = (float) r12;
                if (fCalculateEndPadding < f4) {
                    fCalculateEndPadding = f4;
                }
            }
            if (function7 != 0) {
                gapComposer3.startReplaceGroup(994466433);
                Modifier modifierM132paddingqDBjuR0$default = OffsetKt.m132paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(RulerKt.layoutId(companion, "Prefix").then(new SizeElement(0.0f, (1 & 1) != 0 ? Float.NaN : TextFieldImplKt.MinTextLineHeight, 0.0f, (1 & 2) != 0 ? Float.NaN : 0.0f, 5))), f3, 0.0f, TextFieldImplKt.PrefixSuffixTextPadding, 0.0f, 10);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment4, false);
                long j4 = gapComposer3.compositeKeyHashCode;
                int i12 = (int) (j4 ^ (j4 >>> c));
                PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope4 = gapComposer3.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier4 = AbsoluteAlignment.materializeModifier(gapComposer3, modifierM132paddingqDBjuR0$default);
                gapComposer3.startReusableNode();
                if (gapComposer3.inserting) {
                    gapComposer3.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    gapComposer3.useNode();
                }
                Stack.m295setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy3, composeUiNode$Companion$SetModifier$1);
                Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope4, composeUiNode$Companion$SetModifier$2);
                ImageAnalysis$$ExternalSyntheticLambda1.m(i12, gapComposer3, composeUiNode$Companion$SetModifier$3, gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$1);
                Stack.m295setimpl(gapComposer3, modifierMaterializeModifier4, composeUiNode$Companion$SetModifier$4);
                function7.invoke(gapComposer3, Integer.valueOf((i3 >> 18) & 14));
                gapComposer3.end(true);
                gapComposer3.end(false);
            } else {
                gapComposer3.startReplaceGroup(994794134);
                gapComposer3.end(false);
            }
            if (function8 != 0) {
                gapComposer3.startReplaceGroup(994837379);
                f = fCalculateEndPadding;
                Modifier modifierM132paddingqDBjuR0$default2 = OffsetKt.m132paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(RulerKt.layoutId(companion, "Suffix").then(new SizeElement(0.0f, (1 & 1) != 0 ? Float.NaN : TextFieldImplKt.MinTextLineHeight, 0.0f, (1 & 2) != 0 ? Float.NaN : 0.0f, 5))), TextFieldImplKt.PrefixSuffixTextPadding, 0.0f, f, 0.0f, 10);
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment4, false);
                long j5 = gapComposer3.compositeKeyHashCode;
                int i13 = (int) (j5 ^ (j5 >>> c));
                PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope5 = gapComposer3.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier5 = AbsoluteAlignment.materializeModifier(gapComposer3, modifierM132paddingqDBjuR0$default2);
                gapComposer3.startReusableNode();
                if (gapComposer3.inserting) {
                    gapComposer3.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    gapComposer3.useNode();
                }
                Stack.m295setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy4, composeUiNode$Companion$SetModifier$1);
                Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope5, composeUiNode$Companion$SetModifier$2);
                ImageAnalysis$$ExternalSyntheticLambda1.m(i13, gapComposer3, composeUiNode$Companion$SetModifier$3, gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$1);
                Stack.m295setimpl(gapComposer3, modifierMaterializeModifier5, composeUiNode$Companion$SetModifier$4);
                function8.invoke(gapComposer3, Integer.valueOf((i3 >> 21) & 14));
                gapComposer3.end(true);
                gapComposer3.end(false);
            } else {
                f = fCalculateEndPadding;
                gapComposer3.startReplaceGroup(995163158);
                gapComposer3.end(false);
            }
            Modifier modifierM132paddingqDBjuR0$default3 = OffsetKt.m132paddingqDBjuR0$default(companion, f3, 0.0f, f, 0.0f, 10);
            if (function3 != 0) {
                gapComposer3.startReplaceGroup(995662971);
                Modifier modifierLayoutId3 = RulerKt.layoutId(companion, "Label");
                if (i8 != 4) {
                    if ((i7 & 8) != 0) {
                        textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$3 = textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0;
                        if (gapComposer3.changedInstance(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$3)) {
                        }
                        objRememberedValue = gapComposer3.rememberedValue();
                        if (z4 || objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = new TextFieldKt$$ExternalSyntheticLambda0(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$3, 0);
                            gapComposer3.updateRememberedValue(objRememberedValue);
                        }
                        Modifier modifierThen3 = SizeKt.wrapContentHeight$default(RulerKt.layout(modifierLayoutId3, new SheetDefaultsKt$$ExternalSyntheticLambda5(5, (Function0) objRememberedValue))).then(modifierM132paddingqDBjuR0$default3);
                        biasAlignment2 = biasAlignment4;
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment2, false);
                        long j6 = gapComposer3.compositeKeyHashCode;
                        int i14 = (int) (j6 ^ (j6 >>> c));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope6 = gapComposer3.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier6 = AbsoluteAlignment.materializeModifier(gapComposer3, modifierThen3);
                        gapComposer3.startReusableNode();
                        if (gapComposer3.inserting) {
                            gapComposer3.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer3.useNode();
                        }
                        Stack.m295setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy5, composeUiNode$Companion$SetModifier$1);
                        Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope6, composeUiNode$Companion$SetModifier$2);
                        ImageAnalysis$$ExternalSyntheticLambda1.m(i14, gapComposer3, composeUiNode$Companion$SetModifier$3, gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$1);
                        Stack.m295setimpl(gapComposer3, modifierMaterializeModifier6, composeUiNode$Companion$SetModifier$4);
                        function3.invoke(gapComposer3, Integer.valueOf((i3 >> 6) & 14));
                        gapComposer3.end(true);
                        i5 = 0;
                        gapComposer3.end(false);
                    } else {
                        textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$3 = textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0;
                    }
                    z4 = false;
                    objRememberedValue = gapComposer3.rememberedValue();
                    if (z4) {
                        objRememberedValue = new TextFieldKt$$ExternalSyntheticLambda0(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$3, 0);
                        gapComposer3.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new TextFieldKt$$ExternalSyntheticLambda0(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$3, 0);
                        gapComposer3.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierThen4 = SizeKt.wrapContentHeight$default(RulerKt.layout(modifierLayoutId3, new SheetDefaultsKt$$ExternalSyntheticLambda5(5, (Function0) objRememberedValue))).then(modifierM132paddingqDBjuR0$default3);
                    biasAlignment2 = biasAlignment4;
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment2, false);
                    long j7 = gapComposer3.compositeKeyHashCode;
                    int i15 = (int) (j7 ^ (j7 >>> c));
                    PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope7 = gapComposer3.currentCompositionLocalScope();
                    Modifier modifierMaterializeModifier7 = AbsoluteAlignment.materializeModifier(gapComposer3, modifierThen4);
                    gapComposer3.startReusableNode();
                    if (gapComposer3.inserting) {
                        gapComposer3.createNode(layoutNode$Companion$Constructor$1);
                    } else {
                        gapComposer3.useNode();
                    }
                    Stack.m295setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy6, composeUiNode$Companion$SetModifier$1);
                    Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope7, composeUiNode$Companion$SetModifier$2);
                    ImageAnalysis$$ExternalSyntheticLambda1.m(i15, gapComposer3, composeUiNode$Companion$SetModifier$3, gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$1);
                    Stack.m295setimpl(gapComposer3, modifierMaterializeModifier7, composeUiNode$Companion$SetModifier$4);
                    function3.invoke(gapComposer3, Integer.valueOf((i3 >> 6) & 14));
                    gapComposer3.end(true);
                    i5 = 0;
                    gapComposer3.end(false);
                } else {
                    textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$3 = textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0;
                }
                z4 = true;
                objRememberedValue = gapComposer3.rememberedValue();
                if (z4) {
                    objRememberedValue = new TextFieldKt$$ExternalSyntheticLambda0(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$3, 0);
                    gapComposer3.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new TextFieldKt$$ExternalSyntheticLambda0(textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$3, 0);
                    gapComposer3.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierThen5 = SizeKt.wrapContentHeight$default(RulerKt.layout(modifierLayoutId3, new SheetDefaultsKt$$ExternalSyntheticLambda5(5, (Function0) objRememberedValue))).then(modifierM132paddingqDBjuR0$default3);
                biasAlignment2 = biasAlignment4;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment2, false);
                long j8 = gapComposer3.compositeKeyHashCode;
                int i16 = (int) (j8 ^ (j8 >>> c));
                PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope8 = gapComposer3.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier8 = AbsoluteAlignment.materializeModifier(gapComposer3, modifierThen5);
                gapComposer3.startReusableNode();
                if (gapComposer3.inserting) {
                    gapComposer3.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    gapComposer3.useNode();
                }
                Stack.m295setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy7, composeUiNode$Companion$SetModifier$1);
                Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope8, composeUiNode$Companion$SetModifier$2);
                ImageAnalysis$$ExternalSyntheticLambda1.m(i16, gapComposer3, composeUiNode$Companion$SetModifier$3, gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$1);
                Stack.m295setimpl(gapComposer3, modifierMaterializeModifier8, composeUiNode$Companion$SetModifier$4);
                function3.invoke(gapComposer3, Integer.valueOf((i3 >> 6) & 14));
                gapComposer3.end(true);
                i5 = 0;
                gapComposer3.end(false);
            } else {
                biasAlignment2 = biasAlignment4;
                i5 = 0;
                gapComposer3.startReplaceGroup(996057942);
                gapComposer3.end(false);
            }
            Modifier modifierM132paddingqDBjuR0$default4 = OffsetKt.m132paddingqDBjuR0$default(SizeKt.wrapContentHeight$default(companion.then(new SizeElement(0.0f, (1 & 1) != 0 ? Float.NaN : TextFieldImplKt.MinTextLineHeight, 0.0f, (1 & 2) != 0 ? Float.NaN : 0.0f, 5))), function7 == 0 ? f3 : i5, 0.0f, function8 == 0 ? f : i5, 0.0f, 10);
            if (function4 != null) {
                gapComposer3.startReplaceGroup(996427927);
                Function3 function15 = function4;
                function15.invoke(RulerKt.layoutId(companion, "Hint").then(modifierM132paddingqDBjuR0$default4), gapComposer3, Integer.valueOf((i3 >> 6) & 112));
                gapComposer3.end(false);
                function13 = function15;
            } else {
                function13 = function4;
                gapComposer3.startReplaceGroup(996519222);
                gapComposer3.end(false);
            }
            Modifier modifierThen6 = RulerKt.layoutId(companion, "TextField").then(modifierM132paddingqDBjuR0$default4);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy8 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment2, true);
            long j9 = gapComposer3.compositeKeyHashCode;
            int i17 = (int) (j9 ^ (j9 >>> c));
            PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope9 = gapComposer3.currentCompositionLocalScope();
            Modifier modifierMaterializeModifier9 = AbsoluteAlignment.materializeModifier(gapComposer3, modifierThen6);
            gapComposer3.startReusableNode();
            if (gapComposer3.inserting) {
                gapComposer3.createNode(layoutNode$Companion$Constructor$1);
            } else {
                gapComposer3.useNode();
            }
            Stack.m295setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy8, composeUiNode$Companion$SetModifier$1);
            Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope9, composeUiNode$Companion$SetModifier$2);
            ImageAnalysis$$ExternalSyntheticLambda1.m(i17, gapComposer3, composeUiNode$Companion$SetModifier$3, gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$1);
            Stack.m295setimpl(gapComposer3, modifierMaterializeModifier9, composeUiNode$Companion$SetModifier$4);
            Function2 function16 = function2;
            function16.invoke(gapComposer3, Integer.valueOf((i3 >> 3) & 14));
            gapComposer3.end(true);
            if (function9 != null) {
                gapComposer3.startReplaceGroup(996767873);
                Modifier modifierPadding = OffsetKt.padding(SizeKt.wrapContentHeight$default(RulerKt.layoutId(companion, "Supporting").then(new SizeElement(0.0f, (1 & 1) != 0 ? Float.NaN : TextFieldImplKt.MinSupportingTextLineHeight, 0.0f, (1 & 2) != 0 ? Float.NaN : 0.0f, 5))), TextFieldDefaults.m273supportingTextPaddinga9UjIt4$material3$default());
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy9 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment2, false);
                long j10 = gapComposer3.compositeKeyHashCode;
                int i18 = (int) (j10 ^ (j10 >>> c));
                PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope10 = gapComposer3.currentCompositionLocalScope();
                Modifier modifierMaterializeModifier10 = AbsoluteAlignment.materializeModifier(gapComposer3, modifierPadding);
                gapComposer3.startReusableNode();
                if (gapComposer3.inserting) {
                    gapComposer3.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    gapComposer3.useNode();
                }
                Stack.m295setimpl(gapComposer3, measurePolicyMaybeCachedBoxMeasurePolicy9, composeUiNode$Companion$SetModifier$1);
                Stack.m295setimpl(gapComposer3, persistentCompositionLocalMapCurrentCompositionLocalScope10, composeUiNode$Companion$SetModifier$2);
                ImageAnalysis$$ExternalSyntheticLambda1.m(i18, gapComposer3, composeUiNode$Companion$SetModifier$3, gapComposer3, ownerSnapshotObserver$onCommitAffectingLayout$1);
                Stack.m295setimpl(gapComposer3, modifierMaterializeModifier10, composeUiNode$Companion$SetModifier$4);
                Function2 function17 = function9;
                function17.invoke(gapComposer3, Integer.valueOf((i7 >> 12) & 14));
                z3 = true;
                gapComposer3.end(true);
                gapComposer3.end(false);
                function14 = function17;
            } else {
                function14 = function9;
                z3 = true;
                gapComposer3.startReplaceGroup(997157078);
                gapComposer3.end(false);
            }
            gapComposer3.end(z3);
            gapComposer2 = gapComposer3;
            function10 = function16;
            function12 = function14;
            function11 = function13;
        } else {
            function10 = function2;
            function11 = function4;
            function12 = function9;
            paddingValues2 = paddingValues;
            GapComposer gapComposer5 = gapComposer;
            gapComposer5.skipToGroupEnd();
            gapComposer2 = gapComposer5;
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            final Function2 function18 = function10;
            final Function2 function19 = function12;
            final Function3 function20 = function11;
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.TextFieldKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iUpdateChangedFlags = Stack.updateChangedFlags(i | 1);
                    int iUpdateChangedFlags2 = Stack.updateChangedFlags(i2);
                    ScrimKt.TextFieldLayout(function18, function3, function20, function5, function6, function7, function8, z, textFieldLabelPosition$Attached, textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$0, textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$1, textFieldImplKt$sam$androidx_compose_material3_internal_FloatProducer$2, composableLambdaImpl, function19, paddingValues2, (GapComposer) obj, iUpdateChangedFlags, iUpdateChangedFlags2);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    /* JADX INFO: renamed from: VerticalDivider-9IZ8Weo, reason: not valid java name */
    public static final void m268VerticalDivider9IZ8Weo(final Modifier modifier, float f, final long j, GapComposer gapComposer, final int i) {
        int i2;
        gapComposer.startRestartGroup(-1534852205);
        if ((i & 6) == 0) {
            i2 = i | (gapComposer.changed(modifier) ? 4 : 2);
        } else {
            i2 = i;
        }
        int i3 = i2 | 48 | (gapComposer.changed(j) ? 256 : 128);
        boolean z = true;
        if (gapComposer.shouldExecute(i3 & 1, (i3 & 147) != 146)) {
            gapComposer.startDefaults();
            if ((i & 1) == 0 || gapComposer.getDefaultsInvalid()) {
                f = DividerDefaults.Thickness;
            } else {
                gapComposer.skipToGroupEnd();
            }
            gapComposer.endDefaults();
            Modifier modifierM144width3ABfNKs = SizeKt.m144width3ABfNKs(modifier.then(SizeKt.FillWholeMaxHeight), f);
            if ((((i3 & 896) ^ 384) <= 256 || !gapComposer.changed(j)) && (i3 & 384) != 256) {
                z = false;
            }
            Object objRememberedValue = gapComposer.rememberedValue();
            if (z || objRememberedValue == Composer$Companion.Empty) {
                objRememberedValue = new DividerKt$$ExternalSyntheticLambda0(f, 0, j);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            ImageKt.Canvas(modifierM144width3ABfNKs, (Function1) objRememberedValue, gapComposer, 0);
        } else {
            gapComposer.skipToGroupEnd();
        }
        final float f2 = f;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new Function2() { // from class: androidx.compose.material3.DividerKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    ScrimKt.m268VerticalDivider9IZ8Weo(modifier, f2, j, (GapComposer) obj, Stack.updateChangedFlags(i | 1));
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static Typography getTypography(GapComposer gapComposer) {
        return ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).typography;
    }

    public static final SheetState rememberModalBottomSheetState(Function1 function1, GapComposer gapComposer, int i, int i2) {
        Object obj;
        final int i3 = 1;
        final int i4 = 0;
        final boolean z = (i2 & 1) == 0;
        int i5 = 2;
        int i6 = i2 & 2;
        Object obj2 = Composer$Companion.Empty;
        if (i6 != 0) {
            Object objRememberedValue = gapComposer.rememberedValue();
            if (objRememberedValue == obj2) {
                obj = objRememberedValue;
                Object saversKt$$ExternalSyntheticLambda10 = new SaversKt$$ExternalSyntheticLambda10(9);
                gapComposer.updateRememberedValue(saversKt$$ExternalSyntheticLambda10);
                obj = saversKt$$ExternalSyntheticLambda10;
            }
            obj = objRememberedValue;
            function1 = (Function1) obj;
        }
        final Function1 function2 = function1;
        int i7 = (i & 14) | 384;
        float f = SheetDefaultsKt.DragHandleVerticalPadding;
        final float f2 = BottomSheetDefaults.PositionalThreshold;
        final float f3 = BottomSheetDefaults.VelocityThreshold;
        final Density density = (Density) gapComposer.consume(CompositionLocalsKt.LocalDensity);
        boolean zChanged = gapComposer.changed(density) | gapComposer.changed(f2);
        Object objRememberedValue2 = gapComposer.rememberedValue();
        Object obj3 = objRememberedValue2;
        if (zChanged || objRememberedValue2 == obj2) {
            Object obj4 = new Function0() { // from class: androidx.compose.material3.SheetDefaultsKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    float fMo92toPx0680j_4;
                    switch (i4) {
                        case 0:
                            fMo92toPx0680j_4 = density.mo92toPx0680j_4(f2);
                            break;
                        default:
                            fMo92toPx0680j_4 = density.mo92toPx0680j_4(f2);
                            break;
                    }
                    return Float.valueOf(fMo92toPx0680j_4);
                }
            };
            gapComposer.updateRememberedValue(obj4);
            obj3 = obj4;
        }
        final Function0 function0 = (Function0) obj3;
        boolean zChanged2 = gapComposer.changed(density) | gapComposer.changed(f3);
        Object objRememberedValue3 = gapComposer.rememberedValue();
        Object obj5 = objRememberedValue3;
        if (zChanged2 || objRememberedValue3 == obj2) {
            Object obj6 = new Function0() { // from class: androidx.compose.material3.SheetDefaultsKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    float fMo92toPx0680j_4;
                    switch (i3) {
                        case 0:
                            fMo92toPx0680j_4 = density.mo92toPx0680j_4(f3);
                            break;
                        default:
                            fMo92toPx0680j_4 = density.mo92toPx0680j_4(f3);
                            break;
                    }
                    return Float.valueOf(fMo92toPx0680j_4);
                }
            };
            gapComposer.updateRememberedValue(obj6);
            obj5 = obj6;
        }
        final Function0 function3 = (Function0) obj5;
        Object[] objArr = {Boolean.valueOf(z), function2, Boolean.FALSE};
        RequestService requestService = new RequestService(i5, new SaversKt$$ExternalSyntheticLambda0(18), new SnackbarHostKt$$ExternalSyntheticLambda5(z, function0, function3, function2));
        if ((((i7 & 14) ^ 6) <= 4 || !gapComposer.changed(z)) && (i7 & 6) != 4) {
            i3 = 0;
        }
        boolean z2 = ((((gapComposer.changed(function0) ? 1 : 0) | i3) | (gapComposer.changed(function3) ? 1 : 0)) == true ? 1 : 0) | (gapComposer.changed(function2) ? 1 : 0) | (gapComposer.changed(false) ? 1 : 0);
        Object objRememberedValue4 = gapComposer.rememberedValue();
        if (z2 || objRememberedValue4 == obj2) {
            final SheetValue sheetValue = SheetValue.Hidden;
            Object obj7 = new Function0(z, function0, function3, sheetValue, function2) { // from class: androidx.compose.material3.SheetDefaultsKt$$ExternalSyntheticLambda3
                public final /* synthetic */ boolean f$0;
                public final /* synthetic */ Function0 f$1;
                public final /* synthetic */ SheetValue f$3;
                public final /* synthetic */ Function1 f$4;

                {
                    this.f$3 = sheetValue;
                    this.f$4 = function2;
                }

                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return new SheetState(this.f$0, this.f$1, this.f$3, this.f$4);
                }
            };
            gapComposer.updateRememberedValue(obj7);
            objRememberedValue4 = obj7;
        }
        return (SheetState) SaverKt.rememberSaveable(objArr, requestService, (Function0) objRememberedValue4, gapComposer, 0);
    }

    public static final FiniteAnimationSpec value(int i, GapComposer gapComposer) {
        MotionScheme motionScheme = ((MaterialTheme$Values) gapComposer.consume(MaterialThemeKt._localMaterialTheme)).motionScheme;
        int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(i);
        if (iOrdinal == 0) {
            return motionScheme.defaultSpatialSpec();
        }
        if (iOrdinal == 1) {
            return motionScheme.fastSpatialSpec();
        }
        if (iOrdinal == 2) {
            return motionScheme.slowSpatialSpec();
        }
        if (iOrdinal == 3) {
            return motionScheme.defaultEffectsSpec();
        }
        if (iOrdinal == 4) {
            return motionScheme.fastEffectsSpec();
        }
        if (iOrdinal == 5) {
            return motionScheme.slowEffectsSpec();
        }
        throw new HttpException();
    }
}
