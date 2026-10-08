package androidx.compose.ui.semantics;

import androidx.collection.Keys;
import androidx.collection.MapWrapper;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.ui.platform.InvertMatrixKt;
import java.util.Iterator;
import kotlin.Function;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SemanticsConfiguration implements SemanticsPropertyReceiver, Iterable, KMappedMarker {
    public boolean isClearingSemantics;
    public boolean isMergingSemanticsOfDescendants;
    public MapWrapper mapWrapper;
    public final MutableScatterMap props;

    public SemanticsConfiguration() {
        long[] jArr = ScatterMapKt.EmptyGroup;
        this.props = new MutableScatterMap();
    }

    public final boolean contains(SemanticsPropertyKey semanticsPropertyKey) {
        return this.props.containsKey(semanticsPropertyKey);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0058 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:15:0x005a A[LOOP:0: B:5:0x0023->B:15:0x005a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:18:0x005d A[EDGE_INSN: B:18:0x005d->B:16:0x005d BREAK  A[LOOP:0: B:5:0x0023->B:15:0x005a], SYNTHETIC] */
    public final SemanticsConfiguration copy() {
        SemanticsConfiguration semanticsConfiguration = new SemanticsConfiguration();
        semanticsConfiguration.isMergingSemanticsOfDescendants = this.isMergingSemanticsOfDescendants;
        semanticsConfiguration.isClearingSemantics = this.isClearingSemantics;
        MutableScatterMap mutableScatterMap = semanticsConfiguration.props;
        mutableScatterMap.getClass();
        MutableScatterMap mutableScatterMap2 = this.props;
        Object[] objArr = mutableScatterMap2.keys;
        Object[] objArr2 = mutableScatterMap2.values;
        long[] jArr = mutableScatterMap2.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i != length) {
                        break;
                        break;
                    }
                    i++;
                } else {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            int i4 = (i << 3) + i3;
                            mutableScatterMap.set(objArr[i4], objArr2[i4]);
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    }
                    if (i != length) {
                        break;
                    }
                    i++;
                }
            }
        }
        return semanticsConfiguration;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SemanticsConfiguration)) {
            return false;
        }
        SemanticsConfiguration semanticsConfiguration = (SemanticsConfiguration) obj;
        return Intrinsics.areEqual(this.props, semanticsConfiguration.props) && this.isMergingSemanticsOfDescendants == semanticsConfiguration.isMergingSemanticsOfDescendants && this.isClearingSemantics == semanticsConfiguration.isClearingSemantics;
    }

    public final Object get(SemanticsPropertyKey semanticsPropertyKey) {
        Object obj = this.props.get(semanticsPropertyKey);
        if (obj != null) {
            return obj;
        }
        throw new IllegalStateException("Key not present: " + semanticsPropertyKey + " - consider getOrElse or getOrNull");
    }

    public final int hashCode() {
        return (((this.props.hashCode() * 31) + (this.isMergingSemanticsOfDescendants ? 1231 : 1237)) * 31) + (this.isClearingSemantics ? 1231 : 1237);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        MapWrapper mapWrapper = this.mapWrapper;
        if (mapWrapper == null) {
            MutableScatterMap mutableScatterMap = this.props;
            mutableScatterMap.getClass();
            MapWrapper mapWrapper2 = new MapWrapper(mutableScatterMap);
            this.mapWrapper = mapWrapper2;
            mapWrapper = mapWrapper2;
        }
        return ((Keys) mapWrapper.entrySet()).iterator();
    }

    public final void mergeChild$ui(SemanticsConfiguration semanticsConfiguration) {
        MutableScatterMap mutableScatterMap = semanticsConfiguration.props;
        Object[] objArr = mutableScatterMap.keys;
        Object[] objArr2 = mutableScatterMap.values;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        int i4 = (i << 3) + i3;
                        Object obj = objArr[i4];
                        Object obj2 = objArr2[i4];
                        SemanticsPropertyKey semanticsPropertyKey = (SemanticsPropertyKey) obj;
                        MutableScatterMap mutableScatterMap2 = this.props;
                        Object objInvoke = semanticsPropertyKey.mergePolicy.invoke(mutableScatterMap2.get(semanticsPropertyKey), obj2);
                        if (objInvoke != null) {
                            mutableScatterMap2.set(semanticsPropertyKey, objInvoke);
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    @Override // androidx.compose.ui.semantics.SemanticsPropertyReceiver
    public final void set(SemanticsPropertyKey semanticsPropertyKey, Object obj) {
        boolean z = obj instanceof AccessibilityAction;
        MutableScatterMap mutableScatterMap = this.props;
        if (z && mutableScatterMap.containsKey(semanticsPropertyKey)) {
            AccessibilityAction accessibilityAction = (AccessibilityAction) mutableScatterMap.get(semanticsPropertyKey);
            AccessibilityAction accessibilityAction2 = (AccessibilityAction) obj;
            String str = accessibilityAction2.label;
            if (str == null) {
                str = accessibilityAction.label;
            }
            Function function = accessibilityAction2.action;
            if (function == null) {
                function = accessibilityAction.action;
            }
            mutableScatterMap.set(semanticsPropertyKey, new AccessibilityAction(str, function));
        } else {
            mutableScatterMap.set(semanticsPropertyKey, obj);
        }
        semanticsPropertyKey.getClass();
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0078 A[DONT_INVERT, PHI: r2
      0x0078: PHI (r2v6 java.lang.String) = (r2v5 java.lang.String), (r2v7 java.lang.String) binds: [B:13:0x003f, B:20:0x0076] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:22:0x007a A[LOOP:0: B:12:0x0031->B:22:0x007a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:26:0x007d A[EDGE_INSN: B:26:0x007d->B:23:0x007d BREAK  A[LOOP:0: B:12:0x0031->B:22:0x007a], SYNTHETIC] */
    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        if (this.isMergingSemanticsOfDescendants) {
            sb.append("mergeDescendants=true");
            str = ", ";
        } else {
            str = "";
        }
        if (this.isClearingSemantics) {
            sb.append(str);
            sb.append("isClearingSemantics=true");
            str = ", ";
        }
        MutableScatterMap mutableScatterMap = this.props;
        Object[] objArr = mutableScatterMap.keys;
        Object[] objArr2 = mutableScatterMap.values;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i != length) {
                        break;
                        break;
                    }
                    i++;
                } else {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            int i4 = (i << 3) + i3;
                            Object obj = objArr[i4];
                            Object obj2 = objArr2[i4];
                            sb.append(str);
                            sb.append(((SemanticsPropertyKey) obj).name);
                            sb.append(" : ");
                            sb.append(obj2);
                            str = ", ";
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    }
                    if (i != length) {
                        break;
                    }
                    i++;
                }
            }
        }
        return InvertMatrixKt.simpleIdentityToString(this) + "{ " + ((Object) sb) + " }";
    }
}
