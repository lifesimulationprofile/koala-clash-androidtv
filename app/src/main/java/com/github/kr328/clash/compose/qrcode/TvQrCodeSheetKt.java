package com.github.kr328.clash.compose.qrcode;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnMeasurePolicy;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.ScrimKt;
import androidx.compose.material3.SheetState;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TooltipKt$$ExternalSyntheticLambda7;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.graphics.AndroidImageBitmap;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt$RectangleShape$1;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.BitmapPainterKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetModifier$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.node.OwnerSnapshotObserver$onCommitAffectingLayout$1;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.core.view.MenuHostHelper;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import coil.network.HttpException;
import com.github.kr328.clash.FilesActivity$$ExternalSyntheticLambda8;
import com.github.kr328.clash.compose.HwidLimitDialogKt;
import com.github.kr328.clash.compose.PropertiesScreenKt$$ExternalSyntheticLambda10;
import com.github.kr328.clash.compose.newprofile.NewProfileViewModel;
import com.github.kr328.clash.compose.proxy.ProxySelectorSheetKt$$ExternalSyntheticLambda1;
import com.github.kr328.clash.compose.proxy.ProxyViewModel;
import com.github.kr328.clash.design.compose.theme.AppColors;
import com.github.kr328.clash.design.compose.theme.AppColorsKt;
import com.github.kr328.clash.service.HwidLimitMarker;
import com.koala.clash.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.InterruptibleKt$runInterruptible$2;
import kotlinx.coroutines.flow.internal.ChannelFlow;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class TvQrCodeSheetKt {
    /* JADX WARN: Failed to calculate best type for var: r6v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v0 ??, new type: androidx.compose.runtime.GapComposer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:681)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r6v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v0 ??, new type: androidx.compose.runtime.GapComposer
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
    /* JADX WARN: Failed to calculate best type for var: r6v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v2 ??, new type: androidx.compose.runtime.GapComposer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:681)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r6v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v2 ??, new type: androidx.compose.runtime.GapComposer
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
    /* JADX WARN: Failed to calculate best type for var: r6v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v2 ??, new type: androidx.compose.runtime.GapComposer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r6v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v2 ??, new type: androidx.compose.runtime.GapComposer
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
    /* JADX WARN: Failed to calculate best type for var: r6v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v3 ??, new type: androidx.compose.runtime.GapComposer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:681)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r6v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v3 ??, new type: androidx.compose.runtime.GapComposer
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
    /* JADX WARN: Failed to calculate best type for var: r6v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v3 ??, new type: androidx.compose.runtime.GapComposer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r6v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v3 ??, new type: androidx.compose.runtime.GapComposer
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
    /* JADX WARN: Failed to calculate best type for var: r6v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v4 ??, new type: androidx.compose.runtime.GapComposer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:681)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r6v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v4 ??, new type: androidx.compose.runtime.GapComposer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r6v5 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v5 ??, new type: androidx.compose.runtime.GapComposer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:681)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r6v5 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v5 ??, new type: androidx.compose.runtime.GapComposer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Failed to calculate best type for var: r6v6 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v6 ??, new type: androidx.compose.runtime.GapComposer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:681)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r6v6 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v6 ??, new type: androidx.compose.runtime.GapComposer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryInsertAdditionalMove(FixTypesVisitor.java:678)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 8 more
     */
    /* JADX WARN: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v0 androidx.compose.runtime.GapComposer, new type: androidx.compose.runtime.GapComposer
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.applyWithWiderIgnSame(TypeUpdate.java:73)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.applyResolvedVars(TypeSearch.java:100)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:76)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.runMultiVariableSearch(FixTypesVisitor.java:119)
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
    public static final void TvQrCodeSheet(Function0 function0, final Function0 function1, GapComposer gapComposer, int i) {
        MutableState mutableState;
        CoroutineScope coroutineScope;
        Function0 function2;
        Object filesActivity$$ExternalSyntheticLambda8;
        Object obj;
        MutableState mutableState2;
        MutableState mutableState3;
        NewProfileViewModel newProfileViewModel;
        MutableState mutableState4;
        GapComposer gapComposer2;
        GapComposer gapComposer3 = gapComposer;
        gapComposer3.startRestartGroup(1525398159);
        if ((i & 19) == 18 && gapComposer3.getSkipping()) {
            gapComposer3.skipToGroupEnd();
            gapComposer2 = gapComposer3;
        } else {
            Context context = (Context) gapComposer3.consume(AndroidCompositionLocals_androidKt.LocalContext);
            ProxyViewModel.Factory factory = new ProxyViewModel.Factory((Application) context.getApplicationContext(), 1);
            ViewModelStoreOwner current = LocalViewModelStoreOwner.getCurrent(gapComposer3);
            if (current == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            NewProfileViewModel newProfileViewModel2 = (NewProfileViewModel) ViewModelKt.viewModel(Reflection.getOrCreateKotlinClass(NewProfileViewModel.class), current, factory, current instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, gapComposer3);
            final AppColors appColors = (AppColors) gapComposer3.consume(AppColorsKt.LocalAppColors);
            Object objRememberedValue = gapComposer3.rememberedValue();
            Object obj2 = Composer$Companion.Empty;
            if (objRememberedValue == obj2) {
                objRememberedValue = Stack.createCompositionCoroutineScope(gapComposer3);
                gapComposer3.updateRememberedValue(objRememberedValue);
            }
            CoroutineScope coroutineScope2 = (CoroutineScope) objRememberedValue;
            final SheetState sheetStateRememberModalBottomSheetState = ScrimKt.rememberModalBottomSheetState(null, gapComposer3, 6, 2);
            gapComposer3.startReplaceGroup(1171265049);
            Object objRememberedValue2 = gapComposer3.rememberedValue();
            if (objRememberedValue2 == obj2) {
                objRememberedValue2 = Stack.mutableStateOf$default(QrServerState.Starting);
                gapComposer3.updateRememberedValue(objRememberedValue2);
            }
            MutableState mutableState5 = (MutableState) objRememberedValue2;
            Object objM = Density.CC.m(1171267344, gapComposer3, false);
            if (objM == obj2) {
                objM = Stack.mutableStateOf$default(null);
                gapComposer3.updateRememberedValue(objM);
            }
            final MutableState mutableState6 = (MutableState) objM;
            Object objM2 = Density.CC.m(1171269392, gapComposer3, false);
            if (objM2 == obj2) {
                objM2 = Stack.mutableStateOf$default(null);
                gapComposer3.updateRememberedValue(objM2);
            }
            MutableState mutableState7 = (MutableState) objM2;
            Object objM3 = Density.CC.m(1171271449, gapComposer3, false);
            if (objM3 == obj2) {
                objM3 = Stack.mutableStateOf$default(null);
                gapComposer3.updateRememberedValue(objM3);
            }
            MutableState mutableState8 = (MutableState) objM3;
            gapComposer3.end(false);
            MutableState mutableStateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(newProfileViewModel2.completed, gapComposer3);
            MutableState mutableStateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(newProfileViewModel2.error, gapComposer3);
            MutableState mutableStateCollectAsStateWithLifecycle3 = FlowExtKt.collectAsStateWithLifecycle(newProfileViewModel2.hwidLimit, gapComposer3);
            gapComposer3.startReplaceGroup(1171281428);
            boolean zChangedInstance = gapComposer3.changedInstance(coroutineScope2) | gapComposer3.changed(sheetStateRememberModalBottomSheetState) | gapComposer3.changedInstance(newProfileViewModel2);
            Object objRememberedValue3 = gapComposer3.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == obj2) {
                mutableState = mutableStateCollectAsStateWithLifecycle2;
                TvQrCodeSheetKt$$ExternalSyntheticLambda0 tvQrCodeSheetKt$$ExternalSyntheticLambda0 = new TvQrCodeSheetKt$$ExternalSyntheticLambda0(coroutineScope2, sheetStateRememberModalBottomSheetState, newProfileViewModel2, function0, 0);
                coroutineScope = coroutineScope2;
                function2 = function0;
                gapComposer3.updateRememberedValue(tvQrCodeSheetKt$$ExternalSyntheticLambda0);
                objRememberedValue3 = tvQrCodeSheetKt$$ExternalSyntheticLambda0;
            } else {
                function2 = function0;
                mutableState = mutableStateCollectAsStateWithLifecycle2;
                coroutineScope = coroutineScope2;
            }
            Function0 function3 = (Function0) objRememberedValue3;
            gapComposer3.end(false);
            Boolean bool = (Boolean) mutableStateCollectAsStateWithLifecycle.getValue();
            bool.getClass();
            gapComposer3.startReplaceGroup(1171289975);
            boolean zChanged = gapComposer3.changed(mutableStateCollectAsStateWithLifecycle) | gapComposer3.changed(function3);
            Object objRememberedValue4 = gapComposer3.rememberedValue();
            if (zChanged || objRememberedValue4 == obj2) {
                objRememberedValue4 = new ChannelFlow.AnonymousClass2(function3, mutableStateCollectAsStateWithLifecycle, mutableState5, 0, 2);
                gapComposer3.updateRememberedValue(objRememberedValue4);
            }
            gapComposer3.end(false);
            Stack.LaunchedEffect(gapComposer3, bool, (Function2) objRememberedValue4);
            String str = (String) mutableState.getValue();
            gapComposer3.startReplaceGroup(1171295465);
            final MutableState mutableState9 = mutableState;
            boolean zChanged2 = gapComposer3.changed(mutableState9);
            Object objRememberedValue5 = gapComposer3.rememberedValue();
            if (zChanged2 || objRememberedValue5 == obj2) {
                objRememberedValue5 = new InterruptibleKt$runInterruptible$2(mutableState9, mutableState5, 0, 7);
                gapComposer3.updateRememberedValue(objRememberedValue5);
            }
            gapComposer3.end(false);
            Stack.LaunchedEffect(gapComposer3, str, (Function2) objRememberedValue5);
            Unit unit = Unit.INSTANCE;
            gapComposer3.startReplaceGroup(1171301419);
            boolean zChangedInstance2 = gapComposer3.changedInstance(context) | gapComposer3.changedInstance(newProfileViewModel2) | gapComposer3.changedInstance(coroutineScope);
            Object objRememberedValue6 = gapComposer3.rememberedValue();
            if (zChangedInstance2 || objRememberedValue6 == obj2) {
                obj = obj2;
                mutableState2 = mutableState7;
                mutableState3 = mutableState8;
                filesActivity$$ExternalSyntheticLambda8 = new FilesActivity$$ExternalSyntheticLambda8(coroutineScope, context, newProfileViewModel2, mutableState5, mutableState3, mutableState2, mutableState6);
                newProfileViewModel = newProfileViewModel2;
                mutableState4 = mutableState5;
                gapComposer3.updateRememberedValue(filesActivity$$ExternalSyntheticLambda8);
            } else {
                mutableState4 = mutableState5;
                obj = obj2;
                filesActivity$$ExternalSyntheticLambda8 = objRememberedValue6;
                newProfileViewModel = newProfileViewModel2;
                mutableState2 = mutableState7;
                mutableState3 = mutableState8;
            }
            gapComposer3.end(r13);
            Stack.DisposableEffect(unit, (Function1) filesActivity$$ExternalSyntheticLambda8, gapComposer3);
            gapComposer3.startReplaceGroup(1171363783);
            Object objRememberedValue7 = gapComposer3.rememberedValue();
            if (objRememberedValue7 == obj) {
                objRememberedValue7 = new TvQrCodeSheetKt$$ExternalSyntheticLambda2(function2, mutableState3, 0);
                gapComposer3.updateRememberedValue(objRememberedValue7);
            }
            gapComposer3.end(r13);
            long j = appColors.appBackground;
            final MutableState mutableState10 = mutableState2;
            final CoroutineScope coroutineScope3 = coroutineScope;
            long j2 = appColors.textPrimary;
            final MutableState mutableState11 = mutableState4;
            final MutableState mutableState12 = mutableState3;
            ComposableLambdaImpl composableLambdaImplRememberComposableLambda = Thread_jvmKt.rememberComposableLambda(-1367545871, new Function3() { // from class: com.github.kr328.clash.compose.qrcode.TvQrCodeSheetKt.TvQrCodeSheet.5
                /* JADX WARN: Code duplicated, block: B:92:0x07b3  */
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj3, Object obj4, Object obj5) {
                    RectangleShapeKt$RectangleShape$1 rectangleShapeKt$RectangleShape$1;
                    NeverEqualPolicy neverEqualPolicy;
                    int i2;
                    long j3;
                    Modifier.Companion companion;
                    AppColors appColors2;
                    GapComposer gapComposer4;
                    boolean z;
                    Function0 function4;
                    boolean z2;
                    RectangleShapeKt$RectangleShape$1 rectangleShapeKt$RectangleShape$2;
                    long j4;
                    BiasAlignment biasAlignment;
                    LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1;
                    OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$1;
                    NeverEqualPolicy neverEqualPolicy2;
                    boolean z3;
                    Object objM493BitmapPainterQZhYCtY$default;
                    LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$2;
                    ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$1;
                    long j5;
                    GapComposer gapComposer5 = (GapComposer) obj4;
                    int iIntValue = ((Number) obj5).intValue();
                    BiasAlignment biasAlignment2 = Alignment.Companion.Center;
                    if ((iIntValue & 17) == 16 && gapComposer5.getSkipping()) {
                        gapComposer5.skipToGroupEnd();
                    } else {
                        Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
                        float f = 24;
                        Modifier modifierFocusGroup = ImageKt.focusGroup(OffsetKt.m129paddingVpY3zN4(SizeKt.fillMaxWidth(companion2, 1.0f), f, f));
                        BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
                        float f2 = 16;
                        Arrangement.SpacedAligned spacedAlignedM111spacedBy0680j_4 = Arrangement.m111spacedBy0680j_4(f2);
                        AppColors appColors3 = appColors;
                        long j6 = appColors3.textSecondary;
                        ColumnMeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(spacedAlignedM111spacedBy0680j_4, horizontal, gapComposer5, 54);
                        MenuHostHelper menuHostHelper = gapComposer5.applier;
                        long j7 = gapComposer5.compositeKeyHashCode;
                        int i3 = (int) (j7 ^ (j7 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer5.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer5, modifierFocusGroup);
                        ComposeUiNode.Companion.getClass();
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$3 = ComposeUiNode.Companion.Constructor;
                        gapComposer5.startReusableNode();
                        if (gapComposer5.inserting) {
                            gapComposer5.createNode(layoutNode$Companion$Constructor$3);
                        } else {
                            gapComposer5.useNode();
                        }
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$2 = ComposeUiNode.Companion.SetMeasurePolicy;
                        Stack.m295setimpl(gapComposer5, columnMeasurePolicy, composeUiNode$Companion$SetModifier$2);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$3 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                        Stack.m295setimpl(gapComposer5, persistentCompositionLocalMapCurrentCompositionLocalScope, composeUiNode$Companion$SetModifier$3);
                        Integer numValueOf = Integer.valueOf(i3);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$4 = ComposeUiNode.Companion.SetCompositeKeyHash;
                        Stack.m295setimpl(gapComposer5, numValueOf, composeUiNode$Companion$SetModifier$4);
                        OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$2 = ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion;
                        Stack.m294reconcileimpl(gapComposer5, ownerSnapshotObserver$onCommitAffectingLayout$2);
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$5 = ComposeUiNode.Companion.SetModifier;
                        Stack.m295setimpl(gapComposer5, modifierMaterializeModifier, composeUiNode$Companion$SetModifier$5);
                        Modifier modifierFocusable = ImageKt.focusable(SizeKt.fillMaxWidth(companion2, 1.0f), true, null);
                        ColumnMeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.m111spacedBy0680j_4(f2), horizontal, gapComposer5, 54);
                        long j8 = gapComposer5.compositeKeyHashCode;
                        int i4 = (int) (j8 ^ (j8 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope2 = gapComposer5.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier2 = AbsoluteAlignment.materializeModifier(gapComposer5, modifierFocusable);
                        gapComposer5.startReusableNode();
                        if (gapComposer5.inserting) {
                            gapComposer5.createNode(layoutNode$Companion$Constructor$3);
                        } else {
                            gapComposer5.useNode();
                        }
                        Stack.m295setimpl(gapComposer5, columnMeasurePolicy2, composeUiNode$Companion$SetModifier$2);
                        Stack.m295setimpl(gapComposer5, persistentCompositionLocalMapCurrentCompositionLocalScope2, composeUiNode$Companion$SetModifier$3);
                        Modifier.CC.m(i4, gapComposer5, composeUiNode$Companion$SetModifier$4, gapComposer5, ownerSnapshotObserver$onCommitAffectingLayout$2);
                        Stack.m295setimpl(gapComposer5, modifierMaterializeModifier2, composeUiNode$Companion$SetModifier$5);
                        String strStringResource = StringResources_androidKt.stringResource(R.string.tv_qr_title, gapComposer5);
                        TextStyle textStyle = ScrimKt.getTypography(gapComposer5).titleLarge;
                        long j9 = appColors3.textPrimary;
                        long j10 = appColors3.cardBorder;
                        FontWeight fontWeight = FontWeight.Medium;
                        float f3 = 8;
                        long j11 = j10;
                        OwnerSnapshotObserver$onCommitAffectingLayout$1 ownerSnapshotObserver$onCommitAffectingLayout$3 = ownerSnapshotObserver$onCommitAffectingLayout$2;
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$6 = composeUiNode$Companion$SetModifier$4;
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$7 = composeUiNode$Companion$SetModifier$5;
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$4 = layoutNode$Companion$Constructor$3;
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$8 = composeUiNode$Companion$SetModifier$2;
                        BiasAlignment biasAlignment3 = biasAlignment2;
                        ComposeUiNode$Companion$SetModifier$1 composeUiNode$Companion$SetModifier$9 = composeUiNode$Companion$SetModifier$3;
                        TextKt.m275TextNvy7gAk(strStringResource, OffsetKt.m132paddingqDBjuR0$default(companion2, 0.0f, f3, 0.0f, 0.0f, 13), j9, TextUnitKt.getSp(24), null, fontWeight, 0L, new TextAlign(3), 0L, 0, false, 0, 0, textStyle, gapComposer5, 1597488, 0, 129960);
                        long jColor = j9;
                        MutableState mutableState13 = mutableState11;
                        int iOrdinal = ((QrServerState) mutableState13.getValue()).ordinal();
                        RectangleShapeKt$RectangleShape$1 rectangleShapeKt$RectangleShape$3 = BrushKt.RectangleShape;
                        NeverEqualPolicy neverEqualPolicy3 = Composer$Companion.Empty;
                        if (iOrdinal != 0) {
                            if (iOrdinal != 1) {
                                if (iOrdinal == 2) {
                                    mutableState13 = mutableState13;
                                    companion = companion2;
                                    gapComposer5.startReplaceGroup(-583271112);
                                    float f4 = 40;
                                    OffsetKt.Spacer(gapComposer5, SizeKt.m135height3ABfNKs(companion, f4));
                                    TextKt.m275TextNvy7gAk("✔", null, BrushKt.Color(4281652121L), TextUnitKt.getSp(48), null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer5, 24966, 0, 262122);
                                    TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.tv_qr_received, gapComposer5), null, appColors3.textPrimary, 0L, null, fontWeight, 0L, null, 0L, 0, false, 0, 0, ScrimKt.getTypography(gapComposer5).bodyLarge, gapComposer5, 1572864, 0, 131002);
                                    gapComposer4 = gapComposer5;
                                    OffsetKt.Spacer(gapComposer4, SizeKt.m135height3ABfNKs(companion, f4));
                                    gapComposer4.end(false);
                                    Unit unit2 = Unit.INSTANCE;
                                    rectangleShapeKt$RectangleShape$1 = rectangleShapeKt$RectangleShape$3;
                                    neverEqualPolicy = neverEqualPolicy3;
                                    j3 = j6;
                                    appColors2 = appColors3;
                                } else if (iOrdinal == 3) {
                                    mutableState13 = mutableState13;
                                    companion = companion2;
                                    gapComposer5.startReplaceGroup(-582547014);
                                    float f5 = 40;
                                    OffsetKt.Spacer(gapComposer5, SizeKt.m135height3ABfNKs(companion, f5));
                                    TextKt.m275TextNvy7gAk("✘", null, BrushKt.Color(4294472049L), TextUnitKt.getSp(48), null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer5, 24966, 0, 262122);
                                    TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.tv_qr_error, gapComposer5), null, appColors3.textSecondary, 0L, null, null, 0L, new TextAlign(3), 0L, 0, false, 0, 0, ScrimKt.getTypography(gapComposer5).bodyMedium, gapComposer5, 0, 0, 130042);
                                    gapComposer4 = gapComposer5;
                                    OffsetKt.Spacer(gapComposer4, SizeKt.m135height3ABfNKs(companion, f5));
                                    gapComposer4.end(false);
                                    Unit unit3 = Unit.INSTANCE;
                                    rectangleShapeKt$RectangleShape$1 = rectangleShapeKt$RectangleShape$3;
                                    neverEqualPolicy = neverEqualPolicy3;
                                    j3 = j6;
                                    appColors2 = appColors3;
                                } else {
                                    if (iOrdinal != 4) {
                                        gapComposer5.startReplaceGroup(-850182068);
                                        gapComposer5.end(false);
                                        throw new HttpException();
                                    }
                                    gapComposer5.startReplaceGroup(-581809493);
                                    float f6 = 40;
                                    OffsetKt.Spacer(gapComposer5, SizeKt.m135height3ABfNKs(companion2, f6));
                                    mutableState13 = mutableState13;
                                    TextKt.m275TextNvy7gAk("✘", null, BrushKt.Color(4294472049L), TextUnitKt.getSp(48), null, null, 0L, null, 0L, 0, false, 0, 0, null, gapComposer5, 24966, 0, 262122);
                                    TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.tv_qr_profile_error, gapComposer5), null, appColors3.textSecondary, 0L, null, null, 0L, new TextAlign(3), 0L, 0, false, 0, 0, ScrimKt.getTypography(gapComposer5).bodyMedium, gapComposer5, 0, 0, 130042);
                                    String str2 = (String) mutableState9.getValue();
                                    gapComposer4.startReplaceGroup(-850032278);
                                    if (str2 == null) {
                                        gapComposer4 = gapComposer5;
                                        j5 = j6;
                                        companion = companion2;
                                    } else {
                                        gapComposer4 = gapComposer5;
                                        OffsetKt.Spacer(gapComposer4, SizeKt.m135height3ABfNKs(companion2, f3));
                                        j5 = j6;
                                        companion = companion2;
                                        TextKt.m275TextNvy7gAk(str2, null, BrushKt.Color(Color.m440getRedimpl(j6), Color.m439getGreenimpl(j6), Color.m437getBlueimpl(j6), 0.7f, Color.m438getColorSpaceimpl(j6)), 0L, null, null, 0L, new TextAlign(3), 0L, 0, false, 0, 0, ScrimKt.getTypography(gapComposer4).bodySmall, gapComposer4, 0, 0, 130042);
                                        gapComposer4 = gapComposer4;
                                        Unit unit4 = Unit.INSTANCE;
                                    }
                                    gapComposer4.end(false);
                                    OffsetKt.Spacer(gapComposer4, SizeKt.m135height3ABfNKs(companion, f6));
                                    gapComposer4.end(false);
                                    Unit unit5 = Unit.INSTANCE;
                                    rectangleShapeKt$RectangleShape$1 = rectangleShapeKt$RectangleShape$3;
                                    neverEqualPolicy = neverEqualPolicy3;
                                    appColors2 = appColors3;
                                    j3 = j5;
                                }
                                z = true;
                                i2 = 12;
                            } else {
                                companion = companion2;
                                gapComposer5.startReplaceGroup(-585202195);
                                Bitmap bitmap = (Bitmap) mutableState6.getValue();
                                gapComposer5.startReplaceGroup(-850161164);
                                if (bitmap == null) {
                                    j4 = j11;
                                    ownerSnapshotObserver$onCommitAffectingLayout$1 = ownerSnapshotObserver$onCommitAffectingLayout$3;
                                    biasAlignment = biasAlignment3;
                                    layoutNode$Companion$Constructor$2 = layoutNode$Companion$Constructor$4;
                                    composeUiNode$Companion$SetModifier$1 = composeUiNode$Companion$SetModifier$9;
                                    rectangleShapeKt$RectangleShape$2 = rectangleShapeKt$RectangleShape$3;
                                    neverEqualPolicy2 = neverEqualPolicy3;
                                } else {
                                    rectangleShapeKt$RectangleShape$2 = rectangleShapeKt$RectangleShape$3;
                                    j4 = j11;
                                    Modifier modifierM128padding3ABfNKs = OffsetKt.m128padding3ABfNKs(ImageKt.m48borderxT4_qwU(1, j4, ImageKt.m47backgroundbw27NRU(ClipKt.clip(SizeKt.m140size3ABfNKs(companion, 240), RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(f2)), Color.White, rectangleShapeKt$RectangleShape$2), RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(f2)), 12);
                                    biasAlignment = biasAlignment3;
                                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment, false);
                                    long j12 = gapComposer5.compositeKeyHashCode;
                                    int i5 = (int) (j12 ^ (j12 >>> 32));
                                    PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope3 = gapComposer5.currentCompositionLocalScope();
                                    Modifier modifierMaterializeModifier3 = AbsoluteAlignment.materializeModifier(gapComposer5, modifierM128padding3ABfNKs);
                                    gapComposer5.startReusableNode();
                                    if (gapComposer5.inserting) {
                                        layoutNode$Companion$Constructor$1 = layoutNode$Companion$Constructor$4;
                                        gapComposer5.createNode(layoutNode$Companion$Constructor$1);
                                    } else {
                                        layoutNode$Companion$Constructor$1 = layoutNode$Companion$Constructor$4;
                                        gapComposer5.useNode();
                                    }
                                    Stack.m295setimpl(gapComposer5, measurePolicyMaybeCachedBoxMeasurePolicy, composeUiNode$Companion$SetModifier$8);
                                    Stack.m295setimpl(gapComposer5, persistentCompositionLocalMapCurrentCompositionLocalScope3, composeUiNode$Companion$SetModifier$9);
                                    Modifier.CC.m(i5, gapComposer5, composeUiNode$Companion$SetModifier$6, gapComposer5, ownerSnapshotObserver$onCommitAffectingLayout$3);
                                    Stack.m295setimpl(gapComposer5, modifierMaterializeModifier3, composeUiNode$Companion$SetModifier$7);
                                    AndroidImageBitmap androidImageBitmap = new AndroidImageBitmap(bitmap);
                                    String strStringResource2 = StringResources_androidKt.stringResource(R.string.tv_qr_title, gapComposer5);
                                    Modifier modifierM140size3ABfNKs = SizeKt.m140size3ABfNKs(companion, 216);
                                    boolean zChanged3 = gapComposer5.changed(androidImageBitmap);
                                    Object objRememberedValue8 = gapComposer5.rememberedValue();
                                    ownerSnapshotObserver$onCommitAffectingLayout$1 = ownerSnapshotObserver$onCommitAffectingLayout$3;
                                    neverEqualPolicy2 = neverEqualPolicy3;
                                    if (zChanged3 || objRememberedValue8 == neverEqualPolicy2) {
                                        z3 = true;
                                        objM493BitmapPainterQZhYCtY$default = BitmapPainterKt.m493BitmapPainterQZhYCtY$default(androidImageBitmap, 1);
                                        gapComposer5.updateRememberedValue(objM493BitmapPainterQZhYCtY$default);
                                    } else {
                                        objM493BitmapPainterQZhYCtY$default = objRememberedValue8;
                                        z3 = true;
                                    }
                                    layoutNode$Companion$Constructor$2 = layoutNode$Companion$Constructor$1;
                                    composeUiNode$Companion$SetModifier$8 = composeUiNode$Companion$SetModifier$8;
                                    composeUiNode$Companion$SetModifier$1 = composeUiNode$Companion$SetModifier$9;
                                    composeUiNode$Companion$SetModifier$6 = composeUiNode$Companion$SetModifier$6;
                                    composeUiNode$Companion$SetModifier$7 = composeUiNode$Companion$SetModifier$7;
                                    ImageKt.Image((BitmapPainter) objM493BitmapPainterQZhYCtY$default, strStringResource2, modifierM140size3ABfNKs, biasAlignment, ContentScale.Companion.Fit, 1.0f, gapComposer5, 392, 0);
                                    gapComposer5.end(z3);
                                    Unit unit6 = Unit.INSTANCE;
                                }
                                gapComposer5.end(false);
                                gapComposer4 = gapComposer5;
                                j11 = j4;
                                layoutNode$Companion$Constructor$4 = layoutNode$Companion$Constructor$2;
                                composeUiNode$Companion$SetModifier$6 = composeUiNode$Companion$SetModifier$6;
                                ownerSnapshotObserver$onCommitAffectingLayout$3 = ownerSnapshotObserver$onCommitAffectingLayout$1;
                                composeUiNode$Companion$SetModifier$7 = composeUiNode$Companion$SetModifier$7;
                                composeUiNode$Companion$SetModifier$9 = composeUiNode$Companion$SetModifier$1;
                                biasAlignment3 = biasAlignment;
                                composeUiNode$Companion$SetModifier$8 = composeUiNode$Companion$SetModifier$8;
                                neverEqualPolicy = neverEqualPolicy2;
                                rectangleShapeKt$RectangleShape$1 = rectangleShapeKt$RectangleShape$2;
                                i2 = 12;
                                TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.tv_qr_scan_hint, gapComposer5), null, appColors3.textSecondary, 0L, null, null, 0L, new TextAlign(3), 0L, 0, false, 0, 0, ScrimKt.getTypography(gapComposer5).bodyMedium, gapComposer4, 0, 0, 130042);
                                String str3 = (String) mutableState10.getValue();
                                if (str3 == null) {
                                    j3 = j6;
                                } else {
                                    j3 = j6;
                                    TextKt.m275TextNvy7gAk(str3, null, BrushKt.Color(Color.m440getRedimpl(j6), Color.m439getGreenimpl(j6), Color.m437getBlueimpl(j6), 0.6f, Color.m438getColorSpaceimpl(j6)), TextUnitKt.getSp(12), null, null, 0L, new TextAlign(3), 0L, 0, false, 0, 0, ScrimKt.getTypography(gapComposer4).bodySmall, gapComposer4, 24576, 0, 130026);
                                    Unit unit7 = Unit.INSTANCE;
                                }
                                gapComposer4.end(false);
                                appColors2 = appColors3;
                            }
                            gapComposer4.end(z);
                            gapComposer4.startReplaceGroup(568821413);
                            function4 = function1;
                            if (function4 != null || ((QrServerState) mutableState13.getValue()) == QrServerState.Received) {
                                z2 = true;
                            } else {
                                RoundedCornerShape roundedCornerShapeM158RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m158RoundedCornerShape0680j_4(i2);
                                gapComposer4.startReplaceGroup(568824870);
                                Object objRememberedValue9 = gapComposer4.rememberedValue();
                                NeverEqualPolicy neverEqualPolicy4 = neverEqualPolicy;
                                if (objRememberedValue9 == neverEqualPolicy4) {
                                    objRememberedValue9 = Stack.mutableStateOf$default(Boolean.FALSE);
                                    gapComposer4.updateRememberedValue(objRememberedValue9);
                                }
                                MutableState mutableState14 = (MutableState) objRememberedValue9;
                                gapComposer4.end(false);
                                long j13 = ((Boolean) mutableState14.getValue()).booleanValue() ? jColor : j11;
                                if (!((Boolean) mutableState14.getValue()).booleanValue()) {
                                    long j14 = j3;
                                    jColor = BrushKt.Color(Color.m440getRedimpl(j14), Color.m439getGreenimpl(j14), Color.m437getBlueimpl(j14), 0.5f, Color.m438getColorSpaceimpl(j14));
                                }
                                Modifier modifierM47backgroundbw27NRU = ImageKt.m47backgroundbw27NRU(ClipKt.clip(SizeKt.m141sizeVpY3zN4(companion, 240, 44), roundedCornerShapeM158RoundedCornerShape0680j_4), appColors2.cardBackground, rectangleShapeKt$RectangleShape$1);
                                gapComposer4.startReplaceGroup(568840864);
                                Object objRememberedValue10 = gapComposer4.rememberedValue();
                                if (objRememberedValue10 == neverEqualPolicy4) {
                                    objRememberedValue10 = new TooltipKt$$ExternalSyntheticLambda7(mutableState14, 24);
                                    gapComposer4.updateRememberedValue(objRememberedValue10);
                                }
                                gapComposer4.end(false);
                                Modifier modifierM48borderxT4_qwU = ImageKt.m48borderxT4_qwU(((Boolean) mutableState14.getValue()).booleanValue() ? 2 : 1, j13, FocusTraversalKt.onFocusChanged(modifierM47backgroundbw27NRU, (Function1) objRememberedValue10), roundedCornerShapeM158RoundedCornerShape0680j_4);
                                gapComposer4.startReplaceGroup(568846798);
                                CoroutineScope coroutineScope4 = coroutineScope3;
                                boolean zChangedInstance3 = gapComposer4.changedInstance(coroutineScope4);
                                SheetState sheetState = sheetStateRememberModalBottomSheetState;
                                boolean zChanged4 = zChangedInstance3 | gapComposer4.changed(sheetState) | gapComposer4.changed(function4);
                                Object objRememberedValue11 = gapComposer4.rememberedValue();
                                if (zChanged4 || objRememberedValue11 == neverEqualPolicy4) {
                                    ProxySelectorSheetKt$$ExternalSyntheticLambda1 proxySelectorSheetKt$$ExternalSyntheticLambda1 = new ProxySelectorSheetKt$$ExternalSyntheticLambda1(coroutineScope4, mutableState12, sheetState, function4, 1);
                                    gapComposer4.updateRememberedValue(proxySelectorSheetKt$$ExternalSyntheticLambda1);
                                    objRememberedValue11 = proxySelectorSheetKt$$ExternalSyntheticLambda1;
                                }
                                gapComposer4.end(false);
                                Modifier modifierM51clickableoSLSa3U$default = ImageKt.m51clickableoSLSa3U$default(modifierM48borderxT4_qwU, false, null, (Function0) objRememberedValue11, 15);
                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(biasAlignment3, false);
                                long j15 = gapComposer4.compositeKeyHashCode;
                                int i6 = (int) (j15 ^ (j15 >>> 32));
                                PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope4 = gapComposer4.currentCompositionLocalScope();
                                Modifier modifierMaterializeModifier4 = AbsoluteAlignment.materializeModifier(gapComposer4, modifierM51clickableoSLSa3U$default);
                                gapComposer4.startReusableNode();
                                if (gapComposer4.inserting) {
                                    gapComposer4.createNode(layoutNode$Companion$Constructor$4);
                                } else {
                                    gapComposer4.useNode();
                                }
                                Stack.m295setimpl(gapComposer4, measurePolicyMaybeCachedBoxMeasurePolicy2, composeUiNode$Companion$SetModifier$8);
                                Stack.m295setimpl(gapComposer4, persistentCompositionLocalMapCurrentCompositionLocalScope4, composeUiNode$Companion$SetModifier$9);
                                Modifier.CC.m(i6, gapComposer4, composeUiNode$Companion$SetModifier$6, gapComposer4, ownerSnapshotObserver$onCommitAffectingLayout$3);
                                Stack.m295setimpl(gapComposer4, modifierMaterializeModifier4, composeUiNode$Companion$SetModifier$7);
                                GapComposer gapComposer6 = gapComposer4;
                                TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.tv_qr_manual_input, gapComposer4), null, jColor, TextUnitKt.getSp(13), null, FontWeight.Normal, 0L, null, 0L, 0, false, 0, 0, ScrimKt.getTypography(gapComposer4).bodyMedium, gapComposer6, 1597440, 0, 130986);
                                gapComposer4 = gapComposer6;
                                z2 = true;
                                gapComposer4.end(true);
                            }
                            gapComposer4.end(false);
                            gapComposer4.end(z2);
                        } else {
                            rectangleShapeKt$RectangleShape$1 = rectangleShapeKt$RectangleShape$3;
                            neverEqualPolicy = neverEqualPolicy3;
                            i2 = 12;
                            j3 = j6;
                            composeUiNode$Companion$SetModifier$6 = composeUiNode$Companion$SetModifier$6;
                            ownerSnapshotObserver$onCommitAffectingLayout$3 = ownerSnapshotObserver$onCommitAffectingLayout$3;
                            composeUiNode$Companion$SetModifier$7 = composeUiNode$Companion$SetModifier$7;
                            biasAlignment3 = biasAlignment3;
                            layoutNode$Companion$Constructor$4 = layoutNode$Companion$Constructor$4;
                            composeUiNode$Companion$SetModifier$8 = composeUiNode$Companion$SetModifier$8;
                            composeUiNode$Companion$SetModifier$9 = composeUiNode$Companion$SetModifier$9;
                            companion = companion2;
                            gapComposer5.startReplaceGroup(-585920031);
                            float f7 = 40;
                            OffsetKt.Spacer(gapComposer5, SizeKt.m135height3ABfNKs(companion, f7));
                            ProgressIndicatorKt.m256CircularProgressIndicator4lLiAd8(SizeKt.m140size3ABfNKs(companion, 48), appColors3.textPrimary, 3, 0L, 0, 0.0f, gapComposer5, 390, 56);
                            appColors2 = appColors3;
                            TextKt.m275TextNvy7gAk(StringResources_androidKt.stringResource(R.string.tv_qr_starting, gapComposer5), null, appColors3.textSecondary, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ScrimKt.getTypography(gapComposer5).bodyMedium, gapComposer5, 0, 0, 131066);
                            gapComposer4 = gapComposer5;
                            OffsetKt.Spacer(gapComposer4, SizeKt.m135height3ABfNKs(companion, f7));
                            gapComposer4.end(false);
                            Unit unit8 = Unit.INSTANCE;
                        }
                        z = true;
                        gapComposer4.end(z);
                        gapComposer4.startReplaceGroup(568821413);
                        function4 = function1;
                        if (function4 != null) {
                            z2 = true;
                        } else {
                            z2 = true;
                        }
                        gapComposer4.end(false);
                        gapComposer4.end(z2);
                    }
                    return Unit.INSTANCE;
                }
            }, gapComposer3);
            Object obj3 = obj;
            NewProfileViewModel newProfileViewModel3 = newProfileViewModel;
            ScrimKt.m265ModalBottomSheetYbuCTN8((Function0) objRememberedValue7, null, sheetStateRememberModalBottomSheetState, 0.0f, false, null, j, j2, 0.0f, 0L, null, null, null, composableLambdaImplRememberComposableLambda, gapComposer3, 0, 3078, 6970);
            GapComposer gapComposer4 = gapComposer3;
            gapComposer2 = gapComposer4;
            if (((HwidLimitMarker) mutableStateCollectAsStateWithLifecycle3.getValue()) != null) {
                gapComposer4.startReplaceGroup(-1838198608);
                boolean zChangedInstance3 = gapComposer4.changedInstance(newProfileViewModel3);
                Object objRememberedValue8 = gapComposer4.rememberedValue();
                if (zChangedInstance3 || objRememberedValue8 == obj3) {
                    objRememberedValue8 = new TvQrCodeSheetKt$$ExternalSyntheticLambda3(newProfileViewModel3, 0);
                    gapComposer4.updateRememberedValue(objRememberedValue8);
                }
                gapComposer4.end(false);
                HwidLimitDialogKt.HwidLimitDialog(null, (Function0) objRememberedValue8, gapComposer4, 6);
                gapComposer2 = gapComposer4;
            }
        }
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer2.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new PropertiesScreenKt$$ExternalSyntheticLambda10(function0, function1, i, 1);
        }
    }
}
