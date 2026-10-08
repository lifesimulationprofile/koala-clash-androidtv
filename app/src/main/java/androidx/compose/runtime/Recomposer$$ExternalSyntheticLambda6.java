package androidx.compose.runtime;

import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.textclassifier.TextClassification;
import androidx.activity.compose.ComposeBackHandler;
import androidx.activity.compose.ComposePredictiveBackHandler;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.collection.MutableScatterSet;
import androidx.compose.foundation.BackgroundNode;
import androidx.compose.foundation.FocusableNode;
import androidx.compose.foundation.lazy.layout.LazySaveableStateHolder;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuItem;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import androidx.compose.foundation.text.selection.Selection;
import androidx.compose.foundation.text.selection.SelectionManager;
import androidx.compose.foundation.text.selection.SelectionManagerKt$WhenMappings;
import androidx.compose.foundation.text.selection.SimpleLayoutKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt$WhenMappings;
import androidx.compose.material3.BottomSheetKt$BottomSheetImpl$6$1$1$1$1;
import androidx.compose.material3.FadeInFadeOutState;
import androidx.compose.material3.SheetState;
import androidx.compose.material3.SheetValue;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.ThumbNode;
import androidx.compose.material3.TooltipStateImpl;
import androidx.compose.material3.internal.BasicTooltipKt$anchorSemantics$1$1$1;
import androidx.compose.runtime.composer.gapbuffer.SlotReader;
import androidx.compose.runtime.composer.gapbuffer.SlotTable;
import androidx.compose.runtime.composer.gapbuffer.SlotTableKt;
import androidx.compose.runtime.internal.AtomicInt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.tooling.ComposeStackTrace;
import androidx.compose.runtime.tooling.CompositionErrorContextImpl;
import androidx.compose.runtime.tooling.ObjectLocation;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.PinnableContainerKt;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.core.view.MenuHostHelper;
import androidx.lifecycle.ViewModelKt;
import androidx.navigation.compose.NavHostKt$NavHost$28$1;
import coil.network.HttpException;
import com.github.kr328.clash.ApkDownloader;
import com.github.kr328.clash.LogcatActivity;
import com.github.kr328.clash.LogsActivity;
import com.github.kr328.clash.LogsActivity$onCreate$1$1$1$1;
import com.github.kr328.clash.MainActivity;
import com.github.kr328.clash.UpdateInfo;
import com.github.kr328.clash.compose.connections.ProcessGroup;
import com.github.kr328.clash.compose.newprofile.NewProfileViewModel;
import com.github.kr328.clash.design.compose.components.LiquidGlassNavItem;
import com.github.kr328.clash.design.model.LogFile;
import com.google.android.gms.internal.mlkit_vision_barcode.zzso;
import com.koala.clash.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptyMap;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Recomposer$$ExternalSyntheticLambda6 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ Recomposer$$ExternalSyntheticLambda6(int i, Object obj, Object obj2) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    /* JADX WARN: Code duplicated, block: B:104:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:22:0x005e  */
    /* JADX WARN: Code duplicated, block: B:238:0x0497 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:239:0x0499 A[LOOP:2: B:229:0x0464->B:239:0x0499, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:254:0x049c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:0x0188  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8, types: [androidx.compose.runtime.tooling.ObjectLocation] */
    /* JADX WARN: Type inference failed for: r9v18, types: [kotlin.coroutines.jvm.internal.SuspendLambda, kotlin.jvm.functions.Function1] */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() throws Exception {
        long j;
        TextLayoutResultProxy layoutResult;
        LegacyTextFieldState legacyTextFieldState;
        AnnotatedString annotatedString;
        ?? r8;
        List listPlus;
        SlotReader slotReaderOpenReader;
        String string;
        ClipData primaryClip;
        ClipData.Item itemAt;
        CharSequence charSequenceCoerceToText;
        int i = this.$r8$classId;
        long jM225getMagnifierCenterJVtK1S4 = 9205357640488583168L;
        int i2 = 1;
        int i3 = 0;
        ?? objectLocation = 0;
        Object obj = this.f$1;
        Object obj2 = this.f$0;
        switch (i) {
            case 0:
                MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                CompositionImpl compositionImpl = (CompositionImpl) obj;
                Object[] objArr = mutableScatterSet.elements;
                long[] jArr = mutableScatterSet.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i4 = 0;
                    while (true) {
                        long j2 = jArr[i4];
                        if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i5 = 8 - ((~(i4 - length)) >>> 31);
                            for (int i6 = 0; i6 < i5; i6++) {
                                if ((255 & j2) < 128) {
                                    compositionImpl.recordWriteOf(objArr[(i4 << 3) + i6]);
                                }
                                j2 >>= 8;
                            }
                            if (i5 == 8) {
                                if (i4 != length) {
                                    i4++;
                                }
                            }
                        } else if (i4 != length) {
                            i4++;
                        }
                    }
                }
                return Unit.INSTANCE;
            case 1:
                ((ComposeBackHandler) obj2).currentOnBackCompleted = (Function0) obj;
                return Unit.INSTANCE;
            case 2:
                ((ComposePredictiveBackHandler) obj2).currentOnBack = (Function2) obj;
                return Unit.INSTANCE;
            case 3:
                ((Channel) obj2).mo842trySendJP2dKIU(obj);
                return Unit.INSTANCE;
            case 4:
                BackgroundNode backgroundNode = (BackgroundNode) obj2;
                LayoutNodeDrawScope layoutNodeDrawScope = (LayoutNodeDrawScope) obj;
                backgroundNode.tmpOutline = backgroundNode.shape.mo60createOutlinePq9zytI(layoutNodeDrawScope.canvasDrawScope.drawContext.m756getSizeNHjbRc(), layoutNodeDrawScope.getLayoutDirection(), layoutNodeDrawScope);
                return Unit.INSTANCE;
            case 5:
                ((Ref$ObjectRef) obj2).element = HitTestResultKt.currentValueOf((FocusableNode) obj, PinnableContainerKt.LocalPinnableContainer);
                return Unit.INSTANCE;
            case 6:
                return new LazySaveableStateHolder((SaveableStateRegistry) obj2, EmptyMap.INSTANCE, (SaveableStateHolder) obj);
            case 7:
                TextFieldValue textFieldValue = (TextFieldValue) obj2;
                MutableState mutableState = (MutableState) obj;
                if (!TextRange.m640equalsimpl0(textFieldValue.selection, ((TextFieldValue) mutableState.getValue()).selection) || !Intrinsics.areEqual(textFieldValue.composition, ((TextFieldValue) mutableState.getValue()).composition)) {
                    mutableState.setValue(textFieldValue);
                }
                return Unit.INSTANCE;
            case 8:
                ((Ref$ObjectRef) obj2).element = ((Function0) obj).invoke();
                return Unit.INSTANCE;
            case 9:
                return new IntOffset(IntOffsetKt.m717roundk4lQ0M(((TextContextMenuDataProvider) obj2).mo184positiontuRUvjQ((LayoutCoordinates) ((Function0) obj).invoke())));
            case 10:
                ((TextContextMenuItem) obj2).onClick.invoke((TextContextMenuSession) obj);
                return Unit.INSTANCE;
            case 11:
                Context context = (Context) obj2;
                TextClassification textClassification = (TextClassification) obj;
                String text = textClassification.getText();
                PendingIntent activity = PendingIntent.getActivity(context, text != null ? text.hashCode() : 0, textClassification.getIntent(), 201326592);
                if (Build.VERSION.SDK_INT >= 34) {
                    try {
                        activity.send(ActivityOptions.makeBasic().setPendingIntentBackgroundActivityStartMode(1).toBundle());
                    } catch (PendingIntent.CanceledException e) {
                        Log.e("TextClassification", "error sending pendingIntent: " + activity + " error: " + e);
                    }
                    break;
                } else {
                    activity.send();
                }
                return Unit.INSTANCE;
            case 12:
                SelectionManager selectionManager = (SelectionManager) obj2;
                long j3 = ((IntSize) ((MutableState) obj).getValue()).packedValue;
                Selection selection = selectionManager.getSelection();
                if (selection != null) {
                    Handle draggingHandle = selectionManager.getDraggingHandle();
                    int i7 = draggingHandle == null ? -1 : SelectionManagerKt$WhenMappings.$EnumSwitchMapping$0[draggingHandle.ordinal()];
                    if (i7 != -1) {
                        if (i7 == 1) {
                            jM225getMagnifierCenterJVtK1S4 = SimpleLayoutKt.m225getMagnifierCenterJVtK1S4(selectionManager, j3, selection.start);
                        } else {
                            if (i7 != 2) {
                                if (i7 != 3) {
                                    throw new HttpException();
                                }
                                throw new IllegalStateException("SelectionContainer does not support cursor");
                            }
                            jM225getMagnifierCenterJVtK1S4 = SimpleLayoutKt.m225getMagnifierCenterJVtK1S4(selectionManager, j3, selection.end);
                        }
                    }
                }
                return new Offset(jM225getMagnifierCenterJVtK1S4);
            case 13:
                JobKt.launch$default((CoroutineScope) obj2, null, new ThumbNode.AnonymousClass1((SuspendLambda) obj, null), 1);
                return Unit.INSTANCE;
            case 14:
                TextFieldSelectionManager textFieldSelectionManager = (TextFieldSelectionManager) obj2;
                long j4 = ((IntSize) ((MutableState) obj).getValue()).packedValue;
                Offset offsetM231getCurrentDragPosition_m7T9E = textFieldSelectionManager.m231getCurrentDragPosition_m7T9E();
                if (offsetM231getCurrentDragPosition_m7T9E != null) {
                    long j5 = offsetM231getCurrentDragPosition_m7T9E.packedValue;
                    AnnotatedString transformedText$foundation = textFieldSelectionManager.getTransformedText$foundation();
                    if (transformedText$foundation != null && transformedText$foundation.text.length() != 0) {
                        Handle handle = (Handle) textFieldSelectionManager.draggingHandle$delegate.getValue();
                        int i8 = handle == null ? -1 : TextFieldSelectionManagerKt$WhenMappings.$EnumSwitchMapping$0[handle.ordinal()];
                        if (i8 != -1) {
                            if (i8 == 1 || i8 == 2) {
                                long j6 = textFieldSelectionManager.getValue$foundation().selection;
                                int i9 = TextRange.$r8$clinit;
                                j = j6 >> 32;
                            } else {
                                if (i8 != 3) {
                                    throw new HttpException();
                                }
                                long j7 = textFieldSelectionManager.getValue$foundation().selection;
                                int i10 = TextRange.$r8$clinit;
                                j = j7 & 4294967295L;
                            }
                            int i11 = (int) j;
                            LegacyTextFieldState legacyTextFieldState2 = textFieldSelectionManager.state;
                            if (legacyTextFieldState2 != null && (layoutResult = legacyTextFieldState2.getLayoutResult()) != null && (legacyTextFieldState = textFieldSelectionManager.state) != null && (annotatedString = legacyTextFieldState.textDelegate.text) != null) {
                                int iCoerceIn = RangesKt.coerceIn(textFieldSelectionManager.offsetMapping.originalToTransformed(i11), 0, annotatedString.text.length());
                                float fIntBitsToFloat = Float.intBitsToFloat((int) (layoutResult.m180translateDecorationToInnerCoordinatesMKHz9U$foundation(j5) >> 32));
                                TextLayoutResult textLayoutResult = layoutResult.value;
                                MultiParagraph multiParagraph = textLayoutResult.multiParagraph;
                                int lineForOffset = multiParagraph.getLineForOffset(iCoerceIn);
                                float lineLeft = textLayoutResult.getLineLeft(lineForOffset);
                                float lineRight = textLayoutResult.getLineRight(lineForOffset);
                                float fCoerceIn = RangesKt.coerceIn(fIntBitsToFloat, Math.min(lineLeft, lineRight), Math.max(lineLeft, lineRight));
                                if (IntSize.m720equalsimpl0(j4, 0L) || Math.abs(fIntBitsToFloat - fCoerceIn) <= ((int) (j4 >> 32)) / 2) {
                                    float lineTop = multiParagraph.getLineTop(lineForOffset);
                                    jM225getMagnifierCenterJVtK1S4 = (((long) Float.floatToRawIntBits(fCoerceIn)) << 32) | (((long) Float.floatToRawIntBits(((multiParagraph.getLineBottom(lineForOffset) - lineTop) / 2) + lineTop)) & 4294967295L);
                                }
                            }
                        }
                    }
                }
                return new Offset(jM225getMagnifierCenterJVtK1S4);
            case 15:
                SheetState sheetState = (SheetState) obj2;
                CoroutineScope coroutineScope = (CoroutineScope) obj;
                if (((Boolean) sheetState.confirmValueChange.invoke(SheetValue.PartiallyExpanded)).booleanValue()) {
                    JobKt.launch$default(coroutineScope, null, new BottomSheetKt$BottomSheetImpl$6$1$1$1$1(sheetState, objectLocation, 5), 3);
                }
                return Boolean.TRUE;
            case 16:
                SnackbarHostState.SnackbarDataImpl snackbarDataImpl = (SnackbarHostState.SnackbarDataImpl) obj2;
                FadeInFadeOutState fadeInFadeOutState = (FadeInFadeOutState) obj;
                if (!Intrinsics.areEqual(snackbarDataImpl, fadeInFadeOutState.current)) {
                    CollectionsKt__MutableCollectionsKt.removeAll(fadeInFadeOutState.items, new Recomposer$$ExternalSyntheticLambda0(26, snackbarDataImpl));
                    RecomposeScopeImpl recomposeScopeImpl = fadeInFadeOutState.scope;
                    if (recomposeScopeImpl != null) {
                        recomposeScopeImpl.invalidate();
                    }
                }
                return Unit.INSTANCE;
            case 17:
                JobKt.launch$default((CoroutineScope) obj2, null, new BasicTooltipKt$anchorSemantics$1$1$1((TooltipStateImpl) obj, objectLocation, i3), 3);
                return Boolean.TRUE;
            case 18:
                Recomposer$$ExternalSyntheticLambda1 recomposer$$ExternalSyntheticLambda1 = (Recomposer$$ExternalSyntheticLambda1) obj;
                if (((AtomicInt) ((MenuHostHelper) obj2).mOnInvalidateMenuCallback).get() == 0) {
                    recomposer$$ExternalSyntheticLambda1.invoke();
                }
                return Unit.INSTANCE;
            case 19:
                GapComposer gapComposer = ((CompositionErrorContextImpl) obj2).composer;
                SlotTable slotTable = gapComposer.slotTable;
                SlotReader slotReaderOpenReader2 = slotTable.openReader();
                int i12 = 0;
                while (true) {
                    try {
                        if (i12 < slotTable.groupsSize) {
                            if (slotReaderOpenReader2.isNode(i12)) {
                                Object objNode = slotReaderOpenReader2.node(i12);
                                if (objNode != obj) {
                                    RememberObserverHolder rememberObserverHolder = objNode instanceof RememberObserverHolder ? (RememberObserverHolder) objNode : null;
                                    if ((rememberObserverHolder != null ? rememberObserverHolder.getWrapped() : null) == obj) {
                                    }
                                }
                                ObjectLocation objectLocation2 = new ObjectLocation(i12, null);
                                slotReaderOpenReader2.close();
                                r8 = objectLocation2;
                                if (r8 != 0) {
                                    int i13 = r8.group;
                                    Integer num = r8.dataOffset;
                                    slotReaderOpenReader = slotTable.openReader();
                                    try {
                                        ArrayList arrayListTraceForGroup = zzso.traceForGroup(slotReaderOpenReader, i13, num);
                                        slotReaderOpenReader.close();
                                        listPlus = CollectionsKt.plus((Collection) arrayListTraceForGroup, gapComposer.parentStackTrace$runtime());
                                    } catch (Throwable th) {
                                        slotReaderOpenReader.close();
                                        throw th;
                                    }
                                } else {
                                    listPlus = EmptyList.INSTANCE;
                                }
                                return new ComposeStackTrace(listPlus, gapComposer.sourceMarkersEnabled);
                            }
                            int[] iArr = slotReaderOpenReader2.groups;
                            int i14 = i12 + 1;
                            int iAccess$slotAnchor = (i14 < slotReaderOpenReader2.groupsSize ? iArr[(i14 * 5) + 4] : slotReaderOpenReader2.slotsSize) - SlotTableKt.access$slotAnchor(iArr, i12);
                            int i15 = 0;
                            while (true) {
                                if (i15 >= iAccess$slotAnchor) {
                                    i12 = i14;
                                } else {
                                    Object objGroupGet = slotReaderOpenReader2.groupGet(i12, i15);
                                    if (objGroupGet != obj) {
                                        RememberObserverHolder rememberObserverHolder2 = objGroupGet instanceof RememberObserverHolder ? (RememberObserverHolder) objGroupGet : null;
                                        if ((rememberObserverHolder2 != null ? rememberObserverHolder2.getWrapped() : null) != obj) {
                                            i15++;
                                        }
                                    }
                                    objectLocation = new ObjectLocation(i12, Integer.valueOf(i15));
                                }
                            }
                        } else {
                            Unit unit = Unit.INSTANCE;
                        }
                        slotReaderOpenReader2.close();
                        r8 = objectLocation;
                        if (r8 != 0) {
                            int i16 = r8.group;
                            Integer num2 = r8.dataOffset;
                            slotReaderOpenReader = slotTable.openReader();
                            ArrayList arrayListTraceForGroup2 = zzso.traceForGroup(slotReaderOpenReader, i16, num2);
                            slotReaderOpenReader.close();
                            listPlus = CollectionsKt.plus((Collection) arrayListTraceForGroup2, gapComposer.parentStackTrace$runtime());
                        } else {
                            listPlus = EmptyList.INSTANCE;
                        }
                        return new ComposeStackTrace(listPlus, gapComposer.sourceMarkersEnabled);
                    } catch (Throwable th2) {
                        slotReaderOpenReader2.close();
                        throw th2;
                    }
                }
            case 20:
                int i17 = LogcatActivity.$r8$clinit;
                ((ManagedActivityResultLauncher) obj2).launch(((LogFile) obj).fileName);
                return Unit.INSTANCE;
            case 21:
                LogsActivity logsActivity = (LogsActivity) obj2;
                JobKt.launch$default(ViewModelKt.getLifecycleScope(logsActivity), null, new LogsActivity$onCreate$1$1$1$1(logsActivity, (MutableState) obj, objectLocation, i2), 3);
                return Unit.INSTANCE;
            case 22:
                MainActivity mainActivity = (MainActivity) obj2;
                UpdateInfo updateInfo = (UpdateInfo) obj;
                mainActivity.pendingUpdate$delegate.setValue(null);
                String str = updateInfo.apkDownloadUrl;
                if (str != null) {
                    ApkDownloader.downloadAndInstall(mainActivity, str, updateInfo.versionName);
                } else {
                    mainActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(updateInfo.htmlUrl)));
                }
                return Unit.INSTANCE;
            case 23:
                ((Function1) obj2).invoke((String) obj);
                return Unit.INSTANCE;
            case 24:
                ((Function1) obj2).invoke((LogFile) obj);
                return Unit.INSTANCE;
            case 25:
                JobKt.launch$default((CoroutineScope) obj2, null, new NavHostKt$NavHost$28$1((ProcessGroup) obj, (Continuation) objectLocation, 27), 3);
                return Unit.INSTANCE;
            case 26:
                Context context2 = (Context) obj2;
                NewProfileViewModel newProfileViewModel = (NewProfileViewModel) obj;
                ClipboardManager clipboardManager = (ClipboardManager) context2.getSystemService(ClipboardManager.class);
                if (clipboardManager == null || (primaryClip = clipboardManager.getPrimaryClip()) == null) {
                    string = null;
                } else {
                    if (primaryClip.getItemCount() <= 0) {
                        primaryClip = null;
                    }
                    if (primaryClip == null || (itemAt = primaryClip.getItemAt(0)) == null || (charSequenceCoerceToText = itemAt.coerceToText(context2)) == null) {
                        string = null;
                    } else {
                        string = charSequenceCoerceToText.toString();
                    }
                }
                String string2 = string != null ? StringsKt.trim(string).toString() : null;
                if (string2 == null) {
                    string2 = "";
                }
                if (string2.length() != 0) {
                    String strExtractDeepLink = NewProfileViewModel.extractDeepLink(string2);
                    if (strExtractDeepLink != null) {
                        newProfileViewModel.setLink(strExtractDeepLink);
                    } else if (NewProfileViewModel.isValidUrl(string2)) {
                        newProfileViewModel.setLink(string2);
                    } else {
                        newProfileViewModel._error.setValue(newProfileViewModel.app.getString(R.string.invalid_url));
                    }
                }
                return Unit.INSTANCE;
            case 27:
                ((Function1) obj2).invoke(((LiquidGlassNavItem) obj).key);
                return Unit.INSTANCE;
            default:
                ((PlatformHapticFeedback) ((HapticFeedback) obj2)).m503performHapticFeedbackCdsT49E(0);
                ((Function0) obj).invoke();
                return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Recomposer$$ExternalSyntheticLambda6(CoroutineScope coroutineScope, Function1 function1) {
        this.$r8$classId = 13;
        this.f$0 = coroutineScope;
        this.f$1 = (SuspendLambda) function1;
    }
}
