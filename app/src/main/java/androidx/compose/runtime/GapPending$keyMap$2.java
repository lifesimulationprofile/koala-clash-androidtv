package androidx.compose.runtime;

import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.ObjectListKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.material3.SingleRowTopAppBarOverrideScope;
import androidx.compose.material3.TopAppBarColors;
import androidx.compose.runtime.collection.MultiValueMap;
import androidx.compose.runtime.composer.gapbuffer.KeyInfo;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import java.util.ArrayList;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class GapPending$keyMap$2 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object this$0;

    public /* synthetic */ GapPending$keyMap$2(int i, Object obj) {
        this.$r8$classId = i;
        this.this$0 = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2, types: [androidx.collection.MutableObjectList] */
    /* JADX WARN: Type inference failed for: r5v1, types: [androidx.compose.runtime.composer.gapbuffer.KeyInfo, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r9v3, types: [androidx.collection.MutableObjectList] */
    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i = this.$r8$classId;
        Object obj = this.this$0;
        switch (i) {
            case 0:
                ArrayList arrayList = ((GapPending) obj).keyInfos;
                MutableScatterMap mutableScatterMap = new MutableScatterMap(arrayList.size());
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ?? r5 = (KeyInfo) arrayList.get(i2);
                    Object obj2 = r5.objectKey;
                    int i3 = r5.key;
                    Object joinedKey = obj2 != null ? new JoinedKey(Integer.valueOf(i3), r5.objectKey) : Integer.valueOf(i3);
                    int iFindInsertIndex = mutableScatterMap.findInsertIndex(joinedKey);
                    boolean z = iFindInsertIndex < 0;
                    Object obj3 = z ? null : mutableScatterMap.values[iFindInsertIndex];
                    if (obj3 != null) {
                        if (obj3 instanceof MutableObjectList) {
                            ?? r9 = (MutableObjectList) obj3;
                            r9.add(r5);
                            r5 = r9;
                        } else {
                            Object[] objArr = ObjectListKt.EmptyArray;
                            ?? mutableObjectList = new MutableObjectList(2);
                            mutableObjectList.add(obj3);
                            mutableObjectList.add(r5);
                            r5 = mutableObjectList;
                        }
                    }
                    if (z) {
                        int i4 = ~iFindInsertIndex;
                        mutableScatterMap.keys[i4] = joinedKey;
                        mutableScatterMap.values[i4] = r5;
                    } else {
                        mutableScatterMap.values[iFindInsertIndex] = r5;
                    }
                }
                return new MultiValueMap(mutableScatterMap);
            default:
                TopAppBarColors topAppBarColors = ((SingleRowTopAppBarOverrideScope) obj).colors;
                return new Color(BrushKt.m419lerpjxsXWHM(topAppBarColors.containerColor, topAppBarColors.scrolledContainerColor, EasingKt.FastOutLinearInEasing.transform(0.0f)));
        }
    }
}
