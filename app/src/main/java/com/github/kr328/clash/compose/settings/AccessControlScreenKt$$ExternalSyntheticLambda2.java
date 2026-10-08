package com.github.kr328.clash.compose.settings;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.foundation.lazy.LazyItemScopeImpl;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidImageBitmap;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.core.view.MenuHostHelper;
import coil.compose.AsyncImagePainter$$ExternalSyntheticLambda0;
import coil.request.Parameters;
import com.github.kr328.clash.compose.FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2;
import com.github.kr328.clash.design.model.AppInfo;
import com.google.android.gms.internal.mlkit_vision_common.zzjb;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class AccessControlScreenKt$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ int $r8$classId = 0;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ boolean f$3;

    public /* synthetic */ AccessControlScreenKt$$ExternalSyntheticLambda2(List list, Set set, Function1 function1, boolean z) {
        this.f$0 = list;
        this.f$1 = set;
        this.f$2 = function1;
        this.f$3 = z;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                final List list = (List) this.f$0;
                final Set set = (Set) this.f$1;
                final Function1 function1 = (Function1) this.f$2;
                AsyncImagePainter$$ExternalSyntheticLambda0 asyncImagePainter$$ExternalSyntheticLambda0 = new AsyncImagePainter$$ExternalSyntheticLambda0(26);
                int size = list.size();
                FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2 filesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2 = new FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2(14, list, asyncImagePainter$$ExternalSyntheticLambda0);
                FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2 filesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$3 = new FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2(15, list);
                final boolean z = this.f$3;
                ((LazyListIntervalContent) obj).items(size, filesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2, filesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$3, new ComposableLambdaImpl(802480018, new Function4() { // from class: com.github.kr328.clash.compose.settings.AccessControlScreenKt$AppList$lambda$13$lambda$12$$inlined$items$default$4
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj2, Object obj3, Object obj4, Object obj5) {
                        int i;
                        LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj2;
                        int iIntValue = ((Number) obj3).intValue();
                        GapComposer gapComposer = (GapComposer) obj4;
                        int iIntValue2 = ((Number) obj5).intValue();
                        if ((iIntValue2 & 6) == 0) {
                            i = (gapComposer.changed(lazyItemScopeImpl) ? 4 : 2) | iIntValue2;
                        } else {
                            i = iIntValue2;
                        }
                        if ((iIntValue2 & 48) == 0) {
                            i |= gapComposer.changed(iIntValue) ? 32 : 16;
                        }
                        if (gapComposer.shouldExecute(i & 1, (i & 147) != 146)) {
                            AppInfo appInfo = (AppInfo) list.get(iIntValue);
                            gapComposer.startReplaceGroup(135120573);
                            boolean zContains = set.contains(appInfo.packageName);
                            gapComposer.startReplaceGroup(2082572293);
                            Function1 function2 = function1;
                            boolean zChanged = gapComposer.changed(function2) | gapComposer.changedInstance(appInfo);
                            Object objRememberedValue = gapComposer.rememberedValue();
                            if (zChanged || objRememberedValue == Composer$Companion.Empty) {
                                objRememberedValue = new Http2Connection.ReaderRunnable(9, function2, appInfo);
                                gapComposer.updateRememberedValue(objRememberedValue);
                            }
                            gapComposer.end(false);
                            zzjb.AppRow(appInfo, zContains, (Function0) objRememberedValue, z, gapComposer, 8);
                            gapComposer.end(false);
                        } else {
                            gapComposer.skipToGroupEnd();
                        }
                        return Unit.INSTANCE;
                    }
                }, true));
                return Unit.INSTANCE;
            default:
                Function0 function0 = (Function0) this.f$0;
                AndroidImageBitmap androidImageBitmap = (AndroidImageBitmap) this.f$1;
                BlendModeColorFilter blendModeColorFilter = (BlendModeColorFilter) this.f$2;
                LayoutNodeDrawScope layoutNodeDrawScope = (LayoutNodeDrawScope) obj;
                layoutNodeDrawScope.drawContent();
                CanvasDrawScope canvasDrawScope = layoutNodeDrawScope.canvasDrawScope;
                if (!((Boolean) function0.invoke()).booleanValue()) {
                    return Unit.INSTANCE;
                }
                if (this.f$3) {
                    long jMo473getCenterF1C5BW0 = canvasDrawScope.mo473getCenterF1C5BW0();
                    MenuHostHelper menuHostHelper = canvasDrawScope.drawContext;
                    long jM756getSizeNHjbRc = menuHostHelper.m756getSizeNHjbRc();
                    menuHostHelper.getCanvas().save();
                    try {
                        ((Parameters.Builder) menuHostHelper.mOnInvalidateMenuCallback).m792scale0AR0LA0(-1.0f, 1.0f, jMo473getCenterF1C5BW0);
                        Modifier.CC.m310drawImagegbVJVH8$default(layoutNodeDrawScope, androidImageBitmap, 0L, 0.0f, blendModeColorFilter, 0, 46);
                    } finally {
                        ImageAnalysis$$ExternalSyntheticLambda1.m(menuHostHelper, jM756getSizeNHjbRc);
                    }
                } else {
                    Modifier.CC.m310drawImagegbVJVH8$default(layoutNodeDrawScope, androidImageBitmap, 0L, 0.0f, blendModeColorFilter, 0, 46);
                }
                return Unit.INSTANCE;
        }
    }

    public /* synthetic */ AccessControlScreenKt$$ExternalSyntheticLambda2(Function0 function0, boolean z, AndroidImageBitmap androidImageBitmap, BlendModeColorFilter blendModeColorFilter) {
        this.f$0 = function0;
        this.f$3 = z;
        this.f$1 = androidImageBitmap;
        this.f$2 = blendModeColorFilter;
    }
}
