package androidx.compose.ui.text;

import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.collection.MutableScatterMap;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.FlowRowOverflow;
import androidx.compose.foundation.layout.LimitInsets;
import androidx.compose.foundation.layout.WindowInsetsHolder;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.layout.LazySaveableStateHolder;
import androidx.compose.foundation.text.TextFieldScrollerPosition;
import androidx.compose.foundation.text.selection.SelectionRegistrarImpl;
import androidx.compose.material3.BottomSheetDefaults;
import androidx.compose.material3.SheetState;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.saveable.SaveableHolder;
import androidx.compose.runtime.saveable.SaveableStateHolderImpl;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.TextUnit;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SaversKt$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ SaversKt$$ExternalSyntheticLambda0(int i) {
        this.$r8$classId = i;
    }

    /* JADX WARN: Code duplicated, block: B:141:0x00f6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x00f1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:32:0x00f3 A[LOOP:0: B:19:0x00ac->B:32:0x00f3, LOOP_END] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                AnnotatedString annotatedString = (AnnotatedString) obj2;
                return AppCompatHintHelper.arrayListOf(annotatedString.text, SaversKt.save(annotatedString.annotations, SaversKt.AnnotationRangeListSaver, (SaveableHolder) obj));
            case 1:
                return Integer.valueOf(((ScrollState) obj2).value$delegate.getIntValue());
            case 2:
                LazyListState lazyListState = (LazyListState) obj2;
                return AppCompatHintHelper.listOf(Integer.valueOf(((ParcelableSnapshotMutableIntState) lazyListState.scrollPosition.call).getIntValue()), Integer.valueOf(((ParcelableSnapshotMutableIntState) lazyListState.scrollPosition.finder).getIntValue()));
            case 3:
                Map mapPerformSave = ((LazySaveableStateHolder) obj2).performSave();
                if (mapPerformSave.isEmpty()) {
                    return null;
                }
                return mapPerformSave;
            case 4:
                TextFieldScrollerPosition textFieldScrollerPosition = (TextFieldScrollerPosition) obj2;
                return AppCompatHintHelper.listOf(Float.valueOf(textFieldScrollerPosition.offset$delegate.getFloatValue()), Boolean.valueOf(((Orientation) textFieldScrollerPosition.orientation$delegate.getValue()) == Orientation.Vertical));
            case 5:
                return Long.valueOf(((SelectionRegistrarImpl) obj2).incrementId.get());
            case 6:
                GapComposer gapComposer = (GapComposer) obj;
                int iIntValue = ((Integer) obj2).intValue();
                if (!gapComposer.shouldExecute(iIntValue & 1, (iIntValue & 3) != 2)) {
                    gapComposer.skipToGroupEnd();
                }
                return Unit.INSTANCE;
            case 7:
                GapComposer gapComposer2 = (GapComposer) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                if (gapComposer2.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    BottomSheetDefaults.INSTANCE.m240DragHandlelgZ2HuY(null, 0.0f, 0.0f, null, 0L, gapComposer2, 196608);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                return Unit.INSTANCE;
            case 8:
                GapComposer gapComposer3 = (GapComposer) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                if (!gapComposer3.shouldExecute(iIntValue3 & 1, (iIntValue3 & 3) != 2)) {
                    gapComposer3.skipToGroupEnd();
                }
                return Unit.INSTANCE;
            case 9:
                GapComposer gapComposer4 = (GapComposer) obj;
                int iIntValue4 = ((Integer) obj2).intValue();
                if (!gapComposer4.shouldExecute(iIntValue4 & 1, (iIntValue4 & 3) != 2)) {
                    gapComposer4.skipToGroupEnd();
                }
                return Unit.INSTANCE;
            case 10:
                GapComposer gapComposer5 = (GapComposer) obj;
                int iIntValue5 = ((Integer) obj2).intValue();
                if (!gapComposer5.shouldExecute(iIntValue5 & 1, (iIntValue5 & 3) != 2)) {
                    gapComposer5.skipToGroupEnd();
                }
                return Unit.INSTANCE;
            case 11:
                GapComposer gapComposer6 = (GapComposer) obj;
                int iIntValue6 = ((Integer) obj2).intValue();
                if (!gapComposer6.shouldExecute(iIntValue6 & 1, (iIntValue6 & 3) != 2)) {
                    gapComposer6.skipToGroupEnd();
                }
                return Unit.INSTANCE;
            case 12:
                GapComposer gapComposer7 = (GapComposer) obj;
                int iIntValue7 = ((Integer) obj2).intValue();
                if (!gapComposer7.shouldExecute(iIntValue7 & 1, (iIntValue7 & 3) != 2)) {
                    gapComposer7.skipToGroupEnd();
                }
                return Unit.INSTANCE;
            case 13:
                GapComposer gapComposer8 = (GapComposer) obj;
                ((Integer) obj2).getClass();
                gapComposer8.startReplaceGroup(-511854661);
                BottomSheetDefaults bottomSheetDefaults = BottomSheetDefaults.INSTANCE;
                WeakHashMap weakHashMap = WindowInsetsHolder.viewMap;
                LimitInsets limitInsets = new LimitInsets(FlowRowOverflow.current(gapComposer8).safeDrawing, 48);
                gapComposer8.end(false);
                return limitInsets;
            case 14:
                return Integer.valueOf(((Measurable) obj).minIntrinsicHeight(((Integer) obj2).intValue()));
            case 15:
                return Integer.valueOf(((Measurable) obj).maxIntrinsicWidth(((Integer) obj2).intValue()));
            case 16:
                return Integer.valueOf(((Measurable) obj).maxIntrinsicHeight(((Integer) obj2).intValue()));
            case 17:
                return Integer.valueOf(((Measurable) obj).minIntrinsicWidth(((Integer) obj2).intValue()));
            case 18:
                return ((SheetState) obj2).getCurrentValue();
            case 19:
                return Integer.valueOf(((Measurable) obj).minIntrinsicWidth(((Integer) obj2).intValue()));
            case 20:
                return Integer.valueOf(((Measurable) obj).maxIntrinsicWidth(((Integer) obj2).intValue()));
            case 21:
                return Integer.valueOf(((Measurable) obj).minIntrinsicHeight(((Integer) obj2).intValue()));
            case 22:
                return Integer.valueOf(((Measurable) obj).maxIntrinsicHeight(((Integer) obj2).intValue()));
            case 23:
                SaveableStateHolderImpl saveableStateHolderImpl = (SaveableStateHolderImpl) obj2;
                Map map = saveableStateHolderImpl.savedStates;
                MutableScatterMap mutableScatterMap = saveableStateHolderImpl.registries;
                Object[] objArr = mutableScatterMap.keys;
                Object[] objArr2 = mutableScatterMap.values;
                long[] jArr = mutableScatterMap.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i = 0;
                    while (true) {
                        long j = jArr[i];
                        if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i2 = 8 - ((~(i - length)) >>> 31);
                            for (int i3 = 0; i3 < i2; i3++) {
                                if ((255 & j) < 128) {
                                    int i4 = (i << 3) + i3;
                                    Object obj3 = objArr[i4];
                                    Map mapPerformSave2 = ((SaveableStateRegistry) objArr2[i4]).performSave();
                                    if (mapPerformSave2.isEmpty()) {
                                        map.remove(obj3);
                                    } else {
                                        map.put(obj3, mapPerformSave2);
                                    }
                                }
                                j >>= 8;
                            }
                            if (i2 == 8) {
                                if (i != length) {
                                    i++;
                                }
                            }
                        } else if (i != length) {
                            i++;
                        }
                    }
                }
                if (map.isEmpty()) {
                    return null;
                }
                return map;
            case 24:
                return obj2;
            case 25:
                return Integer.valueOf(((TextDecoration) obj2).mask);
            case 26:
                TextGeometricTransform textGeometricTransform = (TextGeometricTransform) obj2;
                return AppCompatHintHelper.arrayListOf(Float.valueOf(textGeometricTransform.scaleX), Float.valueOf(textGeometricTransform.skewX));
            case 27:
                SaveableHolder saveableHolder = (SaveableHolder) obj;
                TextIndent textIndent = (TextIndent) obj2;
                TextUnit textUnit = new TextUnit(textIndent.firstLine);
                SaversKt$NonNullValueClassSaver$1 saversKt$NonNullValueClassSaver$1 = SaversKt.TextUnitSaver;
                return AppCompatHintHelper.arrayListOf(SaversKt.save(textUnit, saversKt$NonNullValueClassSaver$1, saveableHolder), SaversKt.save(new TextUnit(textIndent.restLine), saversKt$NonNullValueClassSaver$1, saveableHolder));
            case 28:
                return Integer.valueOf(((FontWeight) obj2).weight);
            default:
                LinkAnnotation.Url url = (LinkAnnotation.Url) obj2;
                return AppCompatHintHelper.arrayListOf(url.url, SaversKt.save(url.styles, SaversKt.TextLinkStylesSaver, (SaveableHolder) obj));
        }
    }
}
