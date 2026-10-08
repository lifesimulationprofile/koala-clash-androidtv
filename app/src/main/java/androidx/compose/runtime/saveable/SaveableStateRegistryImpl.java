package androidx.compose.runtime.saveable;

import androidx.appcompat.widget.AppCompatHintHelper;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.core.view.MenuHostHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.text.CharsKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SaveableStateRegistryImpl implements SaveableStateRegistry {
    public final Function1 canBeSaved;
    public final MutableScatterMap restored;
    public MutableScatterMap valueProviders;

    public SaveableStateRegistryImpl(Map map, Function1 function1) {
        MutableScatterMap mutableScatterMap;
        this.canBeSaved = function1;
        if (map == null || map.isEmpty()) {
            mutableScatterMap = null;
        } else {
            mutableScatterMap = new MutableScatterMap(map.size());
            for (Map.Entry entry : map.entrySet()) {
                mutableScatterMap.set(entry.getKey(), entry.getValue());
            }
        }
        this.restored = mutableScatterMap;
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public final boolean canBeSaved(Object obj) {
        return ((Boolean) this.canBeSaved.invoke(obj)).booleanValue();
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public final Object consumeRestored(String str) {
        MutableScatterMap mutableScatterMap = this.restored;
        List list = mutableScatterMap != null ? (List) mutableScatterMap.remove(str) : null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        if (list.size() > 1 && mutableScatterMap != null) {
            List listSubList = list.subList(1, list.size());
            int iFindInsertIndex = mutableScatterMap.findInsertIndex(str);
            if (iFindInsertIndex < 0) {
                iFindInsertIndex = ~iFindInsertIndex;
            }
            Object[] objArr = mutableScatterMap.values;
            Object obj = objArr[iFindInsertIndex];
            mutableScatterMap.keys[iFindInsertIndex] = str;
            objArr[iFindInsertIndex] = listSubList;
        }
        return list.get(0);
    }

    /* JADX WARN: Code duplicated, block: B:36:0x008e  */
    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public final Map performSave() {
        char c;
        long j;
        long j2;
        long j3;
        long[] jArr;
        int i;
        long[] jArr2;
        int i2;
        MutableScatterMap mutableScatterMap = this.restored;
        if (mutableScatterMap == null && this.valueProviders == null) {
            return EmptyMap.INSTANCE;
        }
        int i3 = 0;
        int i4 = mutableScatterMap != null ? mutableScatterMap._size : 0;
        MutableScatterMap mutableScatterMap2 = this.valueProviders;
        HashMap map = new HashMap(i4 + (mutableScatterMap2 != null ? mutableScatterMap2._size : 0));
        char c2 = 7;
        long j4 = -9187201950435737472L;
        int i5 = 8;
        if (mutableScatterMap != null) {
            Object[] objArr = mutableScatterMap.keys;
            Object[] objArr2 = mutableScatterMap.values;
            long[] jArr3 = mutableScatterMap.metadata;
            int length = jArr3.length - 2;
            if (length >= 0) {
                int i6 = 0;
                j2 = 128;
                while (true) {
                    long j5 = jArr3[i6];
                    j3 = 255;
                    if ((((~j5) << c2) & j5 & j4) != j4) {
                        int i7 = 8 - ((~(i6 - length)) >>> 31);
                        int i8 = 0;
                        while (i8 < i7) {
                            if ((j5 & 255) < 128) {
                                int i9 = (i6 << 3) + i8;
                                map.put((String) objArr[i9], (List) objArr2[i9]);
                            }
                            j5 >>= 8;
                            i8++;
                            c2 = c2;
                            j4 = j4;
                        }
                        c = c2;
                        j = j4;
                        if (i7 != 8) {
                            break;
                        }
                    } else {
                        c = c2;
                        j = j4;
                    }
                    if (i6 == length) {
                        break;
                    }
                    i6++;
                    c2 = c;
                    j4 = j;
                }
            } else {
                c = 7;
                j = -9187201950435737472L;
                j2 = 128;
                j3 = 255;
            }
        } else {
            c = 7;
            j = -9187201950435737472L;
            j2 = 128;
            j3 = 255;
        }
        MutableScatterMap mutableScatterMap3 = this.valueProviders;
        if (mutableScatterMap3 != null) {
            Object[] objArr3 = mutableScatterMap3.keys;
            Object[] objArr4 = mutableScatterMap3.values;
            long[] jArr4 = mutableScatterMap3.metadata;
            int length2 = jArr4.length - 2;
            if (length2 >= 0) {
                int i10 = 0;
                while (true) {
                    long j6 = jArr4[i10];
                    if ((((~j6) << c) & j6 & j) != j) {
                        int i11 = 8 - ((~(i10 - length2)) >>> 31);
                        int i12 = i3;
                        while (i12 < i11) {
                            if ((j6 & j3) < j2) {
                                int i13 = (i10 << 3) + i12;
                                Object obj = objArr3[i13];
                                List list = (List) objArr4[i13];
                                String str = (String) obj;
                                i2 = i5;
                                if (list.size() == 1) {
                                    Object objInvoke = ((Function0) list.get(i3)).invoke();
                                    if (objInvoke != null) {
                                        if (!canBeSaved(objInvoke)) {
                                            throw new IllegalStateException(SaverKt.generateCannotBeSavedErrorMessage(objInvoke).toString());
                                        }
                                        Object[] objArr5 = new Object[1];
                                        objArr5[i3] = objInvoke;
                                        map.put(str, AppCompatHintHelper.arrayListOf(objArr5));
                                    }
                                    jArr2 = jArr4;
                                } else {
                                    int size = list.size();
                                    ArrayList arrayList = new ArrayList(size);
                                    while (i3 < size) {
                                        long[] jArr5 = jArr4;
                                        Object objInvoke2 = ((Function0) list.get(i3)).invoke();
                                        if (objInvoke2 != null && !canBeSaved(objInvoke2)) {
                                            throw new IllegalStateException(SaverKt.generateCannotBeSavedErrorMessage(objInvoke2).toString());
                                        }
                                        arrayList.add(objInvoke2);
                                        i3++;
                                        jArr4 = jArr5;
                                    }
                                    jArr2 = jArr4;
                                    map.put(str, arrayList);
                                }
                            } else {
                                jArr2 = jArr4;
                                i2 = i5;
                            }
                            j6 >>= i2;
                            i12++;
                            i5 = i2;
                            jArr4 = jArr2;
                            i3 = 0;
                        }
                        jArr = jArr4;
                        i = i5;
                        if (i11 != i) {
                            break;
                        }
                    } else {
                        jArr = jArr4;
                        i = i5;
                    }
                    if (i10 == length2) {
                        break;
                    }
                    i10++;
                    i5 = i;
                    jArr4 = jArr;
                    i3 = 0;
                }
            }
        }
        return map;
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public final MenuHostHelper registerProvider(String str, Function0 function0) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!CharsKt.isWhitespace(str.charAt(i))) {
                MutableScatterMap mutableScatterMap = this.valueProviders;
                if (mutableScatterMap == null) {
                    long[] jArr = ScatterMapKt.EmptyGroup;
                    mutableScatterMap = new MutableScatterMap();
                    this.valueProviders = mutableScatterMap;
                }
                Object arrayList = mutableScatterMap.get(str);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    mutableScatterMap.set(str, arrayList);
                }
                ((List) arrayList).add(function0);
                return new MenuHostHelper(mutableScatterMap, str, function0, 19);
            }
        }
        throw new IllegalArgumentException("Registered key is empty or blank");
    }
}
