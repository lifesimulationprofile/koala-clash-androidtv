package androidx.compose.runtime;

import androidx.collection.MutableIntObjectMap;
import androidx.compose.runtime.composer.GroupInfo;
import androidx.compose.runtime.composer.gapbuffer.KeyInfo;
import java.util.ArrayList;
import kotlin.SynchronizedLazyImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class GapPending {
    public int groupIndex;
    public final MutableIntObjectMap groupInfos;
    public final ArrayList keyInfos;
    public final SynchronizedLazyImpl keyMap$delegate;
    public final int startIndex;
    public final ArrayList usedKeys;

    public GapPending(int i, ArrayList arrayList) {
        this.keyInfos = arrayList;
        this.startIndex = i;
        if (i < 0) {
            PreconditionsKt.throwIllegalArgumentException("Invalid start index");
        }
        this.usedKeys = new ArrayList();
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap();
        int size = arrayList.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            KeyInfo keyInfo = (KeyInfo) this.keyInfos.get(i3);
            int i4 = keyInfo.location;
            int i5 = keyInfo.nodes;
            mutableIntObjectMap.set(i4, new GroupInfo(i3, i2, i5));
            i2 += i5;
        }
        this.groupInfos = mutableIntObjectMap;
        this.keyMap$delegate = new SynchronizedLazyImpl(new GapPending$keyMap$2(0, this));
    }

    public final boolean updateNodeCount(int i, int i2) {
        int i3;
        MutableIntObjectMap mutableIntObjectMap = this.groupInfos;
        GroupInfo groupInfo = (GroupInfo) mutableIntObjectMap.get(i);
        if (groupInfo == null) {
            return false;
        }
        int i4 = groupInfo.nodeIndex;
        int i5 = i2 - groupInfo.nodeCount;
        groupInfo.nodeCount = i2;
        if (i5 == 0) {
            return true;
        }
        Object[] objArr = mutableIntObjectMap.values;
        long[] jArr = mutableIntObjectMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return true;
        }
        int i6 = 0;
        while (true) {
            long j = jArr[i6];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i7 = 8 - ((~(i6 - length)) >>> 31);
                for (int i8 = 0; i8 < i7; i8++) {
                    if ((255 & j) < 128) {
                        GroupInfo groupInfo2 = (GroupInfo) objArr[(i6 << 3) + i8];
                        if (groupInfo2.nodeIndex >= i4 && !groupInfo2.equals(groupInfo) && (i3 = groupInfo2.nodeIndex + i5) >= 0) {
                            groupInfo2.nodeIndex = i3;
                        }
                    }
                    j >>= 8;
                }
                if (i7 != 8) {
                    return true;
                }
            }
            if (i6 == length) {
                return true;
            }
            i6++;
        }
    }
}
