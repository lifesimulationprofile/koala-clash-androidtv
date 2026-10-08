package androidx.compose.foundation.text.contextmenu.internal;

import android.content.Context;
import android.os.Build;
import androidx.appcompat.widget.Toolbar;
import androidx.compose.foundation.contextmenu.ContextMenuSpec;
import androidx.compose.foundation.contextmenu.ContextMenuUiKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.BasicTextKt$$ExternalSyntheticLambda0;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuData;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProviderKt;
import androidx.compose.material3.SnackbarHostKt$$ExternalSyntheticLambda0;
import androidx.compose.material3.TextKt$$ExternalSyntheticLambda2;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Recomposer$$ExternalSyntheticLambda6;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import androidx.lifecycle.compose.LifecycleEffectKt$$ExternalSyntheticLambda1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.serialization.descriptors.ContextAwareKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class DefaultTextContextMenuDropdownProvider_androidKt {
    public static final PopupProperties DefaultPopupProperties = new PopupProperties(30, true);

    public static final void DefaultTextContextMenuDropdown(TextContextMenuSession textContextMenuSession, TextContextMenuData textContextMenuData, GapComposer gapComposer, int i) {
        GapComposer gapComposer2;
        Context context;
        gapComposer.startRestartGroup(1904307118);
        int i2 = (gapComposer.changed(textContextMenuSession) ? 4 : 2) | i | (gapComposer.changedInstance(textContextMenuData) ? 32 : 16);
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            if (Build.VERSION.SDK_INT >= 28) {
                gapComposer.startReplaceGroup(-1009482584);
                context = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
                gapComposer.end(false);
            } else {
                gapComposer.startReplaceGroup(-1009433480);
                gapComposer.end(false);
                context = null;
            }
            boolean zChangedInstance = gapComposer.changedInstance(textContextMenuData) | ((i2 & 14) == 4) | gapComposer.changedInstance(context);
            Object objRememberedValue = gapComposer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer$Companion.Empty) {
                objRememberedValue = new LifecycleEffectKt$$ExternalSyntheticLambda1(textContextMenuData, context, textContextMenuSession, 9);
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            gapComposer2 = gapComposer;
            ContextMenuUiKt.ContextMenuColumnBuilder(null, null, (Function1) objRememberedValue, gapComposer2, 0, 3);
        } else {
            gapComposer2 = gapComposer;
            gapComposer2.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new TextKt$$ExternalSyntheticLambda2(i, 8, textContextMenuSession, textContextMenuData);
        }
    }

    /* JADX INFO: renamed from: IconBox-RPmYEkk, reason: not valid java name */
    public static final void m183IconBoxRPmYEkk(final int i, final long j, GapComposer gapComposer, final int i2) {
        final int i3;
        int i4;
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup;
        Function2 function2;
        gapComposer.startRestartGroup(-1240244237);
        if ((i2 & 6) == 0) {
            i3 = i;
            i4 = i2 | (gapComposer.changed(i3) ? 4 : 2);
        } else {
            i3 = i;
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= gapComposer.changed(j) ? 32 : 16;
        }
        if (gapComposer.shouldExecute(i4 & 1, (i4 & 19) != 18)) {
            Context context = (Context) gapComposer.consume(AndroidCompositionLocals_androidKt.LocalContext);
            boolean zChanged = ((i4 & 14) == 4) | gapComposer.changed(context);
            Object objRememberedValue = gapComposer.rememberedValue();
            Object obj = Composer$Companion.Empty;
            if (zChanged || objRememberedValue == obj) {
                objRememberedValue = Integer.valueOf(context.obtainStyledAttributes(new int[]{i3}).getResourceId(0, -1));
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            int iIntValue = ((Number) objRememberedValue).intValue();
            if (iIntValue == -1) {
                recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
                if (recomposeScopeImplEndRestartGroup == null) {
                    return;
                }
                final int i5 = 0;
                function2 = new Function2() { // from class: androidx.compose.foundation.text.contextmenu.internal.DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        int i6 = i5;
                        GapComposer gapComposer2 = (GapComposer) obj2;
                        ((Integer) obj3).getClass();
                        switch (i6) {
                            case 0:
                                DefaultTextContextMenuDropdownProvider_androidKt.m183IconBoxRPmYEkk(i3, j, gapComposer2, Stack.updateChangedFlags(i2 | 1));
                                break;
                            default:
                                DefaultTextContextMenuDropdownProvider_androidKt.m183IconBoxRPmYEkk(i3, j, gapComposer2, Stack.updateChangedFlags(i2 | 1));
                                break;
                        }
                        return Unit.INSTANCE;
                    }
                };
            } else {
                Painter painterPainterResource = PainterResources_androidKt.painterResource(iIntValue, gapComposer);
                boolean z = (i4 & 112) == 32;
                Object objRememberedValue2 = gapComposer.rememberedValue();
                if (z || objRememberedValue2 == obj) {
                    objRememberedValue2 = j == 16 ? null : new BlendModeColorFilter(5, j);
                    gapComposer.updateRememberedValue(objRememberedValue2);
                }
                BoxKt.Box(ClipKt.paint$default(SizeKt.m140size3ABfNKs(Modifier.Companion.$$INSTANCE, ContextMenuSpec.IconSize), painterPainterResource, null, ContentScale.Companion.Fit, 0.0f, (BlendModeColorFilter) objRememberedValue2, 22), gapComposer, 0);
            }
            recomposeScopeImplEndRestartGroup.block = function2;
        }
        gapComposer.skipToGroupEnd();
        recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            final int i6 = 1;
            function2 = new Function2() { // from class: androidx.compose.foundation.text.contextmenu.internal.DefaultTextContextMenuDropdownProvider_androidKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    int i7 = i6;
                    GapComposer gapComposer2 = (GapComposer) obj2;
                    ((Integer) obj3).getClass();
                    switch (i7) {
                        case 0:
                            DefaultTextContextMenuDropdownProvider_androidKt.m183IconBoxRPmYEkk(i, j, gapComposer2, Stack.updateChangedFlags(i2 | 1));
                            break;
                        default:
                            DefaultTextContextMenuDropdownProvider_androidKt.m183IconBoxRPmYEkk(i, j, gapComposer2, Stack.updateChangedFlags(i2 | 1));
                            break;
                    }
                    return Unit.INSTANCE;
                }
            };
            recomposeScopeImplEndRestartGroup.block = function2;
        }
    }

    public static final void OpenContextMenu(TextContextMenuSession textContextMenuSession, TextContextMenuDataProvider textContextMenuDataProvider, Function0 function0, GapComposer gapComposer, int i) {
        int i2;
        gapComposer.startRestartGroup(-2040393164);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? gapComposer.changed(textContextMenuSession) : gapComposer.changedInstance(textContextMenuSession) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= (i & 64) == 0 ? gapComposer.changed(textContextMenuDataProvider) : gapComposer.changedInstance(textContextMenuDataProvider) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= gapComposer.changedInstance(function0) ? 256 : 128;
        }
        boolean z = false;
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 147) != 146)) {
            boolean z2 = (i2 & 112) == 32 || ((i2 & 64) != 0 && gapComposer.changed(textContextMenuDataProvider));
            Object objRememberedValue = gapComposer.rememberedValue();
            NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
            if (z2 || objRememberedValue == neverEqualPolicy) {
                objRememberedValue = new MaintainWindowPositionPopupPositionProvider(new Toolbar.AnonymousClass1(24, new Recomposer$$ExternalSyntheticLambda6(9, textContextMenuDataProvider, function0)));
                gapComposer.updateRememberedValue(objRememberedValue);
            }
            MaintainWindowPositionPopupPositionProvider maintainWindowPositionPopupPositionProvider = (MaintainWindowPositionPopupPositionProvider) objRememberedValue;
            if ((i2 & 14) == 4 || ((i2 & 8) != 0 && gapComposer.changedInstance(textContextMenuSession))) {
                z = true;
            }
            Object objRememberedValue2 = gapComposer.rememberedValue();
            if (z || objRememberedValue2 == neverEqualPolicy) {
                objRememberedValue2 = new BasicTextKt$$ExternalSyntheticLambda0(12, textContextMenuSession);
                gapComposer.updateRememberedValue(objRememberedValue2);
            }
            AndroidPopup_androidKt.Popup(maintainWindowPositionPopupPositionProvider, (Function0) objRememberedValue2, DefaultPopupProperties, Thread_jvmKt.rememberComposableLambda(1315155414, new TextKt$$ExternalSyntheticLambda2(7, textContextMenuDataProvider, textContextMenuSession), gapComposer), gapComposer, 3456, 0);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new SnackbarHostKt$$ExternalSyntheticLambda0(textContextMenuSession, textContextMenuDataProvider, function0, i, 5);
        }
    }

    public static final void ProvideDefaultTextContextMenuDropdown(Modifier modifier, ComposableLambdaImpl composableLambdaImpl, GapComposer gapComposer, int i) {
        int i2;
        gapComposer.startRestartGroup(1392105195);
        if ((i & 6) == 0) {
            i2 = (gapComposer.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= gapComposer.changedInstance(composableLambdaImpl) ? 32 : 16;
        }
        if (gapComposer.shouldExecute(i2 & 1, (i2 & 19) != 18)) {
            ContextAwareKt.ProvideBasicTextContextMenu(modifier, TextContextMenuProviderKt.LocalTextContextMenuDropdownProvider, composableLambdaImpl, gapComposer, ((i2 << 6) & 7168) | (i2 & 14) | 432);
        } else {
            gapComposer.skipToGroupEnd();
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AndroidTextContextMenuToolbarProvider_androidKt$$ExternalSyntheticLambda0(modifier, composableLambdaImpl, i, 2);
        }
    }
}
