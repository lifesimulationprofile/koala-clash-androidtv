package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.EndOfChain;
import com.google.android.gms.internal.mlkit_vision_barcode.zzsm;
import java.util.Arrays;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TrieNode {
    public static final TrieNode EMPTY = new TrieNode(0, 0, new Object[0], null);
    public Object[] buffer;
    public int dataMap;
    public int nodeMap;
    public final EndOfChain ownedBy;

    public TrieNode(int i, int i2, Object[] objArr, EndOfChain endOfChain) {
        this.dataMap = i;
        this.nodeMap = i2;
        this.ownedBy = endOfChain;
        this.buffer = objArr;
    }

    public static TrieNode makeNode(int i, Object obj, Object obj2, int i2, Object obj3, Object obj4, int i3, EndOfChain endOfChain) {
        if (i3 > 30) {
            return new TrieNode(0, 0, new Object[]{obj, obj2, obj3, obj4}, endOfChain);
        }
        int iIndexSegment = zzsm.indexSegment(i, i3);
        int iIndexSegment2 = zzsm.indexSegment(i2, i3);
        if (iIndexSegment != iIndexSegment2) {
            return new TrieNode((1 << iIndexSegment) | (1 << iIndexSegment2), 0, iIndexSegment < iIndexSegment2 ? new Object[]{obj, obj2, obj3, obj4} : new Object[]{obj3, obj4, obj, obj2}, endOfChain);
        }
        return new TrieNode(0, 1 << iIndexSegment, new Object[]{makeNode(i, obj, obj2, i2, obj3, obj4, i3 + 5, endOfChain)}, endOfChain);
    }

    public final Object[] bufferMoveEntryToNode(int i, int i2, int i3, Object obj, Object obj2, int i4, EndOfChain endOfChain) {
        Object obj3 = this.buffer[i];
        TrieNode trieNodeMakeNode = makeNode(obj3 != null ? obj3.hashCode() : 0, obj3, valueAtKeyIndex(i), i3, obj, obj2, i4 + 5, endOfChain);
        int iNodeIndex$runtime = nodeIndex$runtime(i2);
        int i5 = iNodeIndex$runtime + 1;
        Object[] objArr = this.buffer;
        Object[] objArr2 = new Object[objArr.length - 1];
        ArraysKt.copyInto$default(objArr, objArr2, 0, i, 6);
        ArraysKt.copyInto(objArr, objArr2, i, i + 2, i5);
        objArr2[iNodeIndex$runtime - 1] = trieNodeMakeNode;
        ArraysKt.copyInto(objArr, objArr2, iNodeIndex$runtime, i5, objArr.length);
        return objArr2;
    }

    public final int calculateSize() {
        if (this.nodeMap == 0) {
            return this.buffer.length / 2;
        }
        int iBitCount = Integer.bitCount(this.dataMap);
        int length = this.buffer.length;
        for (int i = iBitCount * 2; i < length; i++) {
            iBitCount += nodeAtIndex$runtime(i).calculateSize();
        }
        return iBitCount;
    }

    public final boolean collisionContainsKey(Object obj) {
        IntProgression intProgressionStep = RangesKt.step(RangesKt.until(0, this.buffer.length), 2);
        int i = intProgressionStep.first;
        int i2 = intProgressionStep.last;
        int i3 = intProgressionStep.step;
        if ((i3 > 0 && i <= i2) || (i3 < 0 && i2 <= i)) {
            while (!Intrinsics.areEqual(obj, this.buffer[i])) {
                if (i != i2) {
                    i += i3;
                }
            }
            return true;
        }
        return false;
    }

    public final boolean containsKey(int i, int i2, Object obj) {
        int iIndexSegment = 1 << zzsm.indexSegment(i, i2);
        if (hasEntryAt$runtime(iIndexSegment)) {
            return Intrinsics.areEqual(obj, this.buffer[entryKeyIndex$runtime(iIndexSegment)]);
        }
        if (!hasNodeAt(iIndexSegment)) {
            return false;
        }
        TrieNode trieNodeNodeAtIndex$runtime = nodeAtIndex$runtime(nodeIndex$runtime(iIndexSegment));
        return i2 == 30 ? trieNodeNodeAtIndex$runtime.collisionContainsKey(obj) : trieNodeNodeAtIndex$runtime.containsKey(i, i2 + 5, obj);
    }

    public final boolean elementsIdentityEquals(TrieNode trieNode) {
        if (this == trieNode) {
            return true;
        }
        if (this.nodeMap == trieNode.nodeMap && this.dataMap == trieNode.dataMap) {
            int length = this.buffer.length;
            for (int i = 0; i < length; i++) {
                if (this.buffer[i] == trieNode.buffer[i]) {
                }
            }
            return true;
        }
        return false;
    }

    public final int entryKeyIndex$runtime(int i) {
        return Integer.bitCount((i - 1) & this.dataMap) * 2;
    }

    public final Object get(int i, int i2, Object obj) {
        int iIndexSegment = 1 << zzsm.indexSegment(i, i2);
        if (hasEntryAt$runtime(iIndexSegment)) {
            int iEntryKeyIndex$runtime = entryKeyIndex$runtime(iIndexSegment);
            if (Intrinsics.areEqual(obj, this.buffer[iEntryKeyIndex$runtime])) {
                return valueAtKeyIndex(iEntryKeyIndex$runtime);
            }
            return null;
        }
        if (!hasNodeAt(iIndexSegment)) {
            return null;
        }
        TrieNode trieNodeNodeAtIndex$runtime = nodeAtIndex$runtime(nodeIndex$runtime(iIndexSegment));
        if (i2 != 30) {
            return trieNodeNodeAtIndex$runtime.get(i, i2 + 5, obj);
        }
        IntProgression intProgressionStep = RangesKt.step(RangesKt.until(0, trieNodeNodeAtIndex$runtime.buffer.length), 2);
        int i3 = intProgressionStep.first;
        int i4 = intProgressionStep.last;
        int i5 = intProgressionStep.step;
        if ((i5 <= 0 || i3 > i4) && (i5 >= 0 || i4 > i3)) {
            return null;
        }
        while (!Intrinsics.areEqual(obj, trieNodeNodeAtIndex$runtime.buffer[i3])) {
            if (i3 == i4) {
                return null;
            }
            i3 += i5;
        }
        return trieNodeNodeAtIndex$runtime.valueAtKeyIndex(i3);
    }

    public final boolean hasEntryAt$runtime(int i) {
        return (i & this.dataMap) != 0;
    }

    public final boolean hasNodeAt(int i) {
        return (i & this.nodeMap) != 0;
    }

    public final TrieNode mutableCollisionRemoveEntryAtIndex(int i, PersistentHashMapBuilder persistentHashMapBuilder) {
        persistentHashMapBuilder.setSize(persistentHashMapBuilder.size - 1);
        persistentHashMapBuilder.operationResult = valueAtKeyIndex(i);
        Object[] objArr = this.buffer;
        if (objArr.length == 2) {
            return null;
        }
        if (this.ownedBy != persistentHashMapBuilder.ownership) {
            return new TrieNode(0, 0, zzsm.access$removeEntryAtIndex(i, objArr), persistentHashMapBuilder.ownership);
        }
        this.buffer = zzsm.access$removeEntryAtIndex(i, objArr);
        return this;
    }

    public final TrieNode mutablePut(int i, Object obj, Object obj2, int i2, PersistentHashMapBuilder persistentHashMapBuilder) {
        PersistentHashMapBuilder persistentHashMapBuilder2;
        TrieNode trieNodeMutablePut;
        int iIndexSegment = 1 << zzsm.indexSegment(i, i2);
        boolean zHasEntryAt$runtime = hasEntryAt$runtime(iIndexSegment);
        EndOfChain endOfChain = this.ownedBy;
        if (zHasEntryAt$runtime) {
            int iEntryKeyIndex$runtime = entryKeyIndex$runtime(iIndexSegment);
            if (!Intrinsics.areEqual(obj, this.buffer[iEntryKeyIndex$runtime])) {
                persistentHashMapBuilder.setSize(persistentHashMapBuilder.size + 1);
                EndOfChain endOfChain2 = persistentHashMapBuilder.ownership;
                if (endOfChain != endOfChain2) {
                    return new TrieNode(this.dataMap ^ iIndexSegment, this.nodeMap | iIndexSegment, bufferMoveEntryToNode(iEntryKeyIndex$runtime, iIndexSegment, i, obj, obj2, i2, endOfChain2), endOfChain2);
                }
                this.buffer = bufferMoveEntryToNode(iEntryKeyIndex$runtime, iIndexSegment, i, obj, obj2, i2, endOfChain2);
                this.dataMap ^= iIndexSegment;
                this.nodeMap |= iIndexSegment;
                return this;
            }
            persistentHashMapBuilder.operationResult = valueAtKeyIndex(iEntryKeyIndex$runtime);
            if (valueAtKeyIndex(iEntryKeyIndex$runtime) == obj2) {
                return this;
            }
            if (endOfChain == persistentHashMapBuilder.ownership) {
                this.buffer[iEntryKeyIndex$runtime + 1] = obj2;
                return this;
            }
            persistentHashMapBuilder.modCount++;
            Object[] objArr = this.buffer;
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
            objArrCopyOf[iEntryKeyIndex$runtime + 1] = obj2;
            return new TrieNode(this.dataMap, this.nodeMap, objArrCopyOf, persistentHashMapBuilder.ownership);
        }
        if (!hasNodeAt(iIndexSegment)) {
            persistentHashMapBuilder.setSize(persistentHashMapBuilder.size + 1);
            EndOfChain endOfChain3 = persistentHashMapBuilder.ownership;
            int iEntryKeyIndex$runtime2 = entryKeyIndex$runtime(iIndexSegment);
            if (endOfChain != endOfChain3) {
                return new TrieNode(this.dataMap | iIndexSegment, this.nodeMap, zzsm.access$insertEntryAtIndex(this.buffer, iEntryKeyIndex$runtime2, obj, obj2), endOfChain3);
            }
            this.buffer = zzsm.access$insertEntryAtIndex(this.buffer, iEntryKeyIndex$runtime2, obj, obj2);
            this.dataMap |= iIndexSegment;
            return this;
        }
        int iNodeIndex$runtime = nodeIndex$runtime(iIndexSegment);
        TrieNode trieNodeNodeAtIndex$runtime = nodeAtIndex$runtime(iNodeIndex$runtime);
        if (i2 == 30) {
            IntProgression intProgressionStep = RangesKt.step(RangesKt.until(0, trieNodeNodeAtIndex$runtime.buffer.length), 2);
            int i3 = intProgressionStep.first;
            int i4 = intProgressionStep.last;
            int i5 = intProgressionStep.step;
            if ((i5 > 0 && i3 <= i4) || (i5 < 0 && i4 <= i3)) {
                while (true) {
                    if (!Intrinsics.areEqual(obj, trieNodeNodeAtIndex$runtime.buffer[i3])) {
                        if (i3 == i4) {
                            persistentHashMapBuilder.setSize(persistentHashMapBuilder.size + 1);
                            trieNodeMutablePut = new TrieNode(0, 0, zzsm.access$insertEntryAtIndex(trieNodeNodeAtIndex$runtime.buffer, 0, obj, obj2), persistentHashMapBuilder.ownership);
                            break;
                        }
                        i3 += i5;
                    } else {
                        persistentHashMapBuilder.operationResult = trieNodeNodeAtIndex$runtime.valueAtKeyIndex(i3);
                        if (trieNodeNodeAtIndex$runtime.ownedBy != persistentHashMapBuilder.ownership) {
                            persistentHashMapBuilder.modCount++;
                            Object[] objArr2 = trieNodeNodeAtIndex$runtime.buffer;
                            Object[] objArrCopyOf2 = Arrays.copyOf(objArr2, objArr2.length);
                            objArrCopyOf2[i3 + 1] = obj2;
                            trieNodeMutablePut = new TrieNode(0, 0, objArrCopyOf2, persistentHashMapBuilder.ownership);
                            break;
                        }
                        trieNodeNodeAtIndex$runtime.buffer[i3 + 1] = obj2;
                        trieNodeMutablePut = trieNodeNodeAtIndex$runtime;
                        break;
                    }
                }
            } else {
                persistentHashMapBuilder.setSize(persistentHashMapBuilder.size + 1);
                trieNodeMutablePut = new TrieNode(0, 0, zzsm.access$insertEntryAtIndex(trieNodeNodeAtIndex$runtime.buffer, 0, obj, obj2), persistentHashMapBuilder.ownership);
                break;
            }
            persistentHashMapBuilder2 = persistentHashMapBuilder;
        } else {
            persistentHashMapBuilder2 = persistentHashMapBuilder;
            trieNodeMutablePut = trieNodeNodeAtIndex$runtime.mutablePut(i, obj, obj2, i2 + 5, persistentHashMapBuilder2);
        }
        return trieNodeNodeAtIndex$runtime == trieNodeMutablePut ? this : mutableUpdateNodeAtIndex(iNodeIndex$runtime, trieNodeMutablePut, persistentHashMapBuilder2.ownership);
    }

    public final TrieNode mutablePutAll(TrieNode trieNode, int i, DeltaCounter deltaCounter, PersistentHashMapBuilder persistentHashMapBuilder) {
        TrieNode trieNode2;
        Object[] objArr;
        TrieNode trieNodeMakeNode;
        if (this == trieNode) {
            deltaCounter.count += calculateSize();
            return this;
        }
        int i2 = 0;
        if (i > 30) {
            EndOfChain endOfChain = persistentHashMapBuilder.ownership;
            int i3 = trieNode.nodeMap;
            Object[] objArr2 = this.buffer;
            Object[] objArrCopyOf = Arrays.copyOf(objArr2, objArr2.length + trieNode.buffer.length);
            int length = this.buffer.length;
            IntProgression intProgressionStep = RangesKt.step(RangesKt.until(0, trieNode.buffer.length), 2);
            int i4 = intProgressionStep.first;
            int i5 = intProgressionStep.last;
            int i6 = intProgressionStep.step;
            if ((i6 > 0 && i4 <= i5) || (i6 < 0 && i5 <= i4)) {
                while (true) {
                    if (collisionContainsKey(trieNode.buffer[i4])) {
                        deltaCounter.count++;
                    } else {
                        Object[] objArr3 = trieNode.buffer;
                        objArrCopyOf[length] = objArr3[i4];
                        objArrCopyOf[length + 1] = objArr3[i4 + 1];
                        length += 2;
                    }
                    if (i4 == i5) {
                        break;
                    }
                    i4 += i6;
                }
            }
            if (length != this.buffer.length) {
                if (length == trieNode.buffer.length) {
                    return trieNode;
                }
                return length == objArrCopyOf.length ? new TrieNode(0, 0, objArrCopyOf, endOfChain) : new TrieNode(0, 0, Arrays.copyOf(objArrCopyOf, length), endOfChain);
            }
        } else {
            int i7 = this.nodeMap | trieNode.nodeMap;
            int i8 = this.dataMap;
            int i9 = trieNode.dataMap;
            int i10 = (i8 ^ i9) & (~i7);
            int i11 = i8 & i9;
            int i12 = i10;
            while (i11 != 0) {
                int iLowestOneBit = Integer.lowestOneBit(i11);
                if (Intrinsics.areEqual(this.buffer[entryKeyIndex$runtime(iLowestOneBit)], trieNode.buffer[trieNode.entryKeyIndex$runtime(iLowestOneBit)])) {
                    i12 |= iLowestOneBit;
                } else {
                    i7 |= iLowestOneBit;
                }
                i11 ^= iLowestOneBit;
            }
            if ((i7 & i12) != 0) {
                PreconditionsKt.throwIllegalStateException("Check failed.");
            }
            if (Intrinsics.areEqual(this.ownedBy, persistentHashMapBuilder.ownership) && this.dataMap == i12 && this.nodeMap == i7) {
                trieNode2 = this;
            } else {
                trieNode2 = new TrieNode(i12, i7, new Object[Integer.bitCount(i7) + (Integer.bitCount(i12) * 2)], null);
            }
            int i13 = i7;
            int i14 = 0;
            while (i13 != 0) {
                int iLowestOneBit2 = Integer.lowestOneBit(i13);
                Object[] objArr4 = trieNode2.buffer;
                int length2 = (objArr4.length - 1) - i14;
                if (hasNodeAt(iLowestOneBit2)) {
                    trieNodeMakeNode = nodeAtIndex$runtime(nodeIndex$runtime(iLowestOneBit2));
                    if (trieNode.hasNodeAt(iLowestOneBit2)) {
                        trieNodeMakeNode = trieNodeMakeNode.mutablePutAll(trieNode.nodeAtIndex$runtime(trieNode.nodeIndex$runtime(iLowestOneBit2)), i + 5, deltaCounter, persistentHashMapBuilder);
                        objArr = objArr4;
                    } else if (trieNode.hasEntryAt$runtime(iLowestOneBit2)) {
                        int iEntryKeyIndex$runtime = trieNode.entryKeyIndex$runtime(iLowestOneBit2);
                        Object obj = trieNode.buffer[iEntryKeyIndex$runtime];
                        Object objValueAtKeyIndex = trieNode.valueAtKeyIndex(iEntryKeyIndex$runtime);
                        int i15 = persistentHashMapBuilder.size;
                        objArr = objArr4;
                        trieNodeMakeNode = trieNodeMakeNode.mutablePut(obj != null ? obj.hashCode() : i2, obj, objValueAtKeyIndex, i + 5, persistentHashMapBuilder);
                        if (persistentHashMapBuilder.size == i15) {
                            deltaCounter.count++;
                        }
                    } else {
                        objArr = objArr4;
                    }
                } else {
                    objArr = objArr4;
                    if (trieNode.hasNodeAt(iLowestOneBit2)) {
                        TrieNode trieNodeNodeAtIndex$runtime = trieNode.nodeAtIndex$runtime(trieNode.nodeIndex$runtime(iLowestOneBit2));
                        if (hasEntryAt$runtime(iLowestOneBit2)) {
                            int iEntryKeyIndex$runtime2 = entryKeyIndex$runtime(iLowestOneBit2);
                            Object obj2 = this.buffer[iEntryKeyIndex$runtime2];
                            int i16 = i + 5;
                            if (trieNodeNodeAtIndex$runtime.containsKey(obj2 != null ? obj2.hashCode() : 0, i16, obj2)) {
                                deltaCounter.count++;
                                trieNodeMakeNode = trieNodeNodeAtIndex$runtime;
                            } else {
                                trieNodeMakeNode = trieNodeNodeAtIndex$runtime.mutablePut(obj2 != null ? obj2.hashCode() : 0, obj2, valueAtKeyIndex(iEntryKeyIndex$runtime2), i16, persistentHashMapBuilder);
                            }
                        } else {
                            trieNodeMakeNode = trieNodeNodeAtIndex$runtime;
                        }
                    } else {
                        int iEntryKeyIndex$runtime3 = entryKeyIndex$runtime(iLowestOneBit2);
                        Object obj3 = this.buffer[iEntryKeyIndex$runtime3];
                        Object objValueAtKeyIndex2 = valueAtKeyIndex(iEntryKeyIndex$runtime3);
                        int iEntryKeyIndex$runtime4 = trieNode.entryKeyIndex$runtime(iLowestOneBit2);
                        Object obj4 = trieNode.buffer[iEntryKeyIndex$runtime4];
                        trieNodeMakeNode = makeNode(obj3 != null ? obj3.hashCode() : 0, obj3, objValueAtKeyIndex2, obj4 != null ? obj4.hashCode() : 0, obj4, trieNode.valueAtKeyIndex(iEntryKeyIndex$runtime4), i + 5, persistentHashMapBuilder.ownership);
                    }
                }
                objArr[length2] = trieNodeMakeNode;
                i14++;
                i13 ^= iLowestOneBit2;
                i2 = 0;
            }
            int i17 = 0;
            while (i12 != 0) {
                int iLowestOneBit3 = Integer.lowestOneBit(i12);
                int i18 = i17 * 2;
                if (trieNode.hasEntryAt$runtime(iLowestOneBit3)) {
                    int iEntryKeyIndex$runtime5 = trieNode.entryKeyIndex$runtime(iLowestOneBit3);
                    Object[] objArr5 = trieNode2.buffer;
                    objArr5[i18] = trieNode.buffer[iEntryKeyIndex$runtime5];
                    objArr5[i18 + 1] = trieNode.valueAtKeyIndex(iEntryKeyIndex$runtime5);
                    if (hasEntryAt$runtime(iLowestOneBit3)) {
                        deltaCounter.count++;
                    }
                } else {
                    int iEntryKeyIndex$runtime6 = entryKeyIndex$runtime(iLowestOneBit3);
                    Object[] objArr6 = trieNode2.buffer;
                    objArr6[i18] = this.buffer[iEntryKeyIndex$runtime6];
                    objArr6[i18 + 1] = valueAtKeyIndex(iEntryKeyIndex$runtime6);
                }
                i17++;
                i12 ^= iLowestOneBit3;
            }
            if (!elementsIdentityEquals(trieNode2)) {
                return trieNode.elementsIdentityEquals(trieNode2) ? trieNode : trieNode2;
            }
        }
        return this;
    }

    public final TrieNode mutableRemove(int i, Object obj, int i2, PersistentHashMapBuilder persistentHashMapBuilder) {
        TrieNode trieNodeMutableRemove;
        int iIndexSegment = 1 << zzsm.indexSegment(i, i2);
        if (hasEntryAt$runtime(iIndexSegment)) {
            int iEntryKeyIndex$runtime = entryKeyIndex$runtime(iIndexSegment);
            if (Intrinsics.areEqual(obj, this.buffer[iEntryKeyIndex$runtime])) {
                return mutableRemoveEntryAtIndex(iEntryKeyIndex$runtime, iIndexSegment, persistentHashMapBuilder);
            }
        } else if (hasNodeAt(iIndexSegment)) {
            int iNodeIndex$runtime = nodeIndex$runtime(iIndexSegment);
            TrieNode trieNodeNodeAtIndex$runtime = nodeAtIndex$runtime(iNodeIndex$runtime);
            if (i2 == 30) {
                IntProgression intProgressionStep = RangesKt.step(RangesKt.until(0, trieNodeNodeAtIndex$runtime.buffer.length), 2);
                int i3 = intProgressionStep.first;
                int i4 = intProgressionStep.last;
                int i5 = intProgressionStep.step;
                if ((i5 > 0 && i3 <= i4) || (i5 < 0 && i4 <= i3)) {
                    while (true) {
                        if (!Intrinsics.areEqual(obj, trieNodeNodeAtIndex$runtime.buffer[i3])) {
                            if (i3 == i4) {
                                trieNodeMutableRemove = trieNodeNodeAtIndex$runtime;
                                break;
                            }
                            i3 += i5;
                        } else {
                            trieNodeMutableRemove = trieNodeNodeAtIndex$runtime.mutableCollisionRemoveEntryAtIndex(i3, persistentHashMapBuilder);
                            break;
                        }
                    }
                } else {
                    trieNodeMutableRemove = trieNodeNodeAtIndex$runtime;
                    break;
                }
            } else {
                trieNodeMutableRemove = trieNodeNodeAtIndex$runtime.mutableRemove(i, obj, i2 + 5, persistentHashMapBuilder);
            }
            return mutableReplaceNode(trieNodeNodeAtIndex$runtime, trieNodeMutableRemove, iNodeIndex$runtime, iIndexSegment, persistentHashMapBuilder.ownership);
        }
        return this;
    }

    public final TrieNode mutableRemoveEntryAtIndex(int i, int i2, PersistentHashMapBuilder persistentHashMapBuilder) {
        persistentHashMapBuilder.setSize(persistentHashMapBuilder.size - 1);
        persistentHashMapBuilder.operationResult = valueAtKeyIndex(i);
        Object[] objArr = this.buffer;
        if (objArr.length == 2) {
            return null;
        }
        if (this.ownedBy != persistentHashMapBuilder.ownership) {
            return new TrieNode(i2 ^ this.dataMap, this.nodeMap, zzsm.access$removeEntryAtIndex(i, objArr), persistentHashMapBuilder.ownership);
        }
        this.buffer = zzsm.access$removeEntryAtIndex(i, objArr);
        this.dataMap ^= i2;
        return this;
    }

    public final TrieNode mutableReplaceNode(TrieNode trieNode, TrieNode trieNode2, int i, int i2, EndOfChain endOfChain) {
        EndOfChain endOfChain2 = this.ownedBy;
        if (trieNode2 != null) {
            return (endOfChain2 == endOfChain || trieNode != trieNode2) ? mutableUpdateNodeAtIndex(i, trieNode2, endOfChain) : this;
        }
        Object[] objArr = this.buffer;
        if (objArr.length == 1) {
            return null;
        }
        if (endOfChain2 != endOfChain) {
            return new TrieNode(this.dataMap, i2 ^ this.nodeMap, zzsm.access$removeNodeAtIndex(i, objArr), endOfChain);
        }
        this.buffer = zzsm.access$removeNodeAtIndex(i, objArr);
        this.nodeMap ^= i2;
        return this;
    }

    public final TrieNode mutableUpdateNodeAtIndex(int i, TrieNode trieNode, EndOfChain endOfChain) {
        Object[] objArr = this.buffer;
        if (objArr.length == 1 && trieNode.buffer.length == 2 && trieNode.nodeMap == 0) {
            trieNode.dataMap = this.nodeMap;
            return trieNode;
        }
        if (this.ownedBy == endOfChain) {
            objArr[i] = trieNode;
            return this;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        objArrCopyOf[i] = trieNode;
        return new TrieNode(this.dataMap, this.nodeMap, objArrCopyOf, endOfChain);
    }

    public final TrieNode nodeAtIndex$runtime(int i) {
        return (TrieNode) this.buffer[i];
    }

    public final int nodeIndex$runtime(int i) {
        return (this.buffer.length - 1) - Integer.bitCount((i - 1) & this.nodeMap);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00cb, code lost:
    
        if (r14 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00d4, code lost:
    
        if (r14 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d7, code lost:
    
        r14.cache = updateNodeAtIndex(r12, r4, (androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode) r14.cache);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00e1, code lost:
    
        return r14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final coil.memory.RealWeakMemoryCache put(int r12, int r13, java.lang.Object r14, java.lang.Object r15) {
        /*
            Method dump skipped, instruction units count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode.put(int, int, java.lang.Object, java.lang.Object):coil.memory.RealWeakMemoryCache");
    }

    public final TrieNode remove(int i, int i2, Object obj) {
        TrieNode trieNodeRemove;
        int iIndexSegment = 1 << zzsm.indexSegment(i, i2);
        if (hasEntryAt$runtime(iIndexSegment)) {
            int iEntryKeyIndex$runtime = entryKeyIndex$runtime(iIndexSegment);
            if (Intrinsics.areEqual(obj, this.buffer[iEntryKeyIndex$runtime])) {
                Object[] objArr = this.buffer;
                if (objArr.length != 2) {
                    return new TrieNode(this.dataMap ^ iIndexSegment, this.nodeMap, zzsm.access$removeEntryAtIndex(iEntryKeyIndex$runtime, objArr), null);
                }
                return null;
            }
            return this;
        }
        if (hasNodeAt(iIndexSegment)) {
            int iNodeIndex$runtime = nodeIndex$runtime(iIndexSegment);
            TrieNode trieNodeNodeAtIndex$runtime = nodeAtIndex$runtime(iNodeIndex$runtime);
            if (i2 == 30) {
                IntProgression intProgressionStep = RangesKt.step(RangesKt.until(0, trieNodeNodeAtIndex$runtime.buffer.length), 2);
                int i3 = intProgressionStep.first;
                int i4 = intProgressionStep.last;
                int i5 = intProgressionStep.step;
                if ((i5 > 0 && i3 <= i4) || (i5 < 0 && i4 <= i3)) {
                    while (true) {
                        if (!Intrinsics.areEqual(obj, trieNodeNodeAtIndex$runtime.buffer[i3])) {
                            if (i3 == i4) {
                                trieNodeRemove = trieNodeNodeAtIndex$runtime;
                                break;
                            }
                            i3 += i5;
                        } else {
                            Object[] objArr2 = trieNodeNodeAtIndex$runtime.buffer;
                            if (objArr2.length != 2) {
                                trieNodeRemove = new TrieNode(0, 0, zzsm.access$removeEntryAtIndex(i3, objArr2), null);
                                break;
                            }
                            trieNodeRemove = null;
                            break;
                        }
                    }
                } else {
                    trieNodeRemove = trieNodeNodeAtIndex$runtime;
                    break;
                }
            } else {
                trieNodeRemove = trieNodeNodeAtIndex$runtime.remove(i, i2 + 5, obj);
            }
            if (trieNodeRemove == null) {
                Object[] objArr3 = this.buffer;
                if (objArr3.length != 1) {
                    return new TrieNode(this.dataMap, iIndexSegment ^ this.nodeMap, zzsm.access$removeNodeAtIndex(iNodeIndex$runtime, objArr3), null);
                }
                return null;
            }
            if (trieNodeNodeAtIndex$runtime != trieNodeRemove) {
                return updateNodeAtIndex(iNodeIndex$runtime, iIndexSegment, trieNodeRemove);
            }
        }
        return this;
    }

    public final TrieNode updateNodeAtIndex(int i, int i2, TrieNode trieNode) {
        Object[] objArr = trieNode.buffer;
        if (objArr.length != 2 || trieNode.nodeMap != 0) {
            Object[] objArr2 = this.buffer;
            Object[] objArrCopyOf = Arrays.copyOf(objArr2, objArr2.length);
            objArrCopyOf[i] = trieNode;
            return new TrieNode(this.dataMap, this.nodeMap, objArrCopyOf, null);
        }
        if (this.buffer.length == 1) {
            trieNode.dataMap = this.nodeMap;
            return trieNode;
        }
        int iEntryKeyIndex$runtime = entryKeyIndex$runtime(i2);
        Object[] objArr3 = this.buffer;
        Object obj = objArr[0];
        Object obj2 = objArr[1];
        Object[] objArrCopyOf2 = Arrays.copyOf(objArr3, objArr3.length + 1);
        ArraysKt.copyInto(objArrCopyOf2, objArrCopyOf2, i + 2, i + 1, objArr3.length);
        ArraysKt.copyInto(objArrCopyOf2, objArrCopyOf2, iEntryKeyIndex$runtime + 2, iEntryKeyIndex$runtime, i);
        objArrCopyOf2[iEntryKeyIndex$runtime] = obj;
        objArrCopyOf2[iEntryKeyIndex$runtime + 1] = obj2;
        return new TrieNode(this.dataMap ^ i2, i2 ^ this.nodeMap, objArrCopyOf2, null);
    }

    public final Object valueAtKeyIndex(int i) {
        return this.buffer[i + 1];
    }

    public final TrieNode mutableRemove(int i, Object obj, Object obj2, int i2, PersistentHashMapBuilder persistentHashMapBuilder) {
        TrieNode trieNode;
        TrieNode trieNodeMutableRemove;
        int iIndexSegment = 1 << zzsm.indexSegment(i, i2);
        if (hasEntryAt$runtime(iIndexSegment)) {
            int iEntryKeyIndex$runtime = entryKeyIndex$runtime(iIndexSegment);
            if (Intrinsics.areEqual(obj, this.buffer[iEntryKeyIndex$runtime]) && Intrinsics.areEqual(obj2, valueAtKeyIndex(iEntryKeyIndex$runtime))) {
                return mutableRemoveEntryAtIndex(iEntryKeyIndex$runtime, iIndexSegment, persistentHashMapBuilder);
            }
        } else if (hasNodeAt(iIndexSegment)) {
            int iNodeIndex$runtime = nodeIndex$runtime(iIndexSegment);
            TrieNode trieNodeNodeAtIndex$runtime = nodeAtIndex$runtime(iNodeIndex$runtime);
            if (i2 == 30) {
                IntProgression intProgressionStep = RangesKt.step(RangesKt.until(0, trieNodeNodeAtIndex$runtime.buffer.length), 2);
                int i3 = intProgressionStep.first;
                int i4 = intProgressionStep.last;
                int i5 = intProgressionStep.step;
                if ((i5 > 0 && i3 <= i4) || (i5 < 0 && i4 <= i3)) {
                    while (true) {
                        if (!Intrinsics.areEqual(obj, trieNodeNodeAtIndex$runtime.buffer[i3]) || !Intrinsics.areEqual(obj2, trieNodeNodeAtIndex$runtime.valueAtKeyIndex(i3))) {
                            if (i3 == i4) {
                                trieNodeMutableRemove = trieNodeNodeAtIndex$runtime;
                                break;
                            }
                            i3 += i5;
                        } else {
                            trieNodeMutableRemove = trieNodeNodeAtIndex$runtime.mutableCollisionRemoveEntryAtIndex(i3, persistentHashMapBuilder);
                            break;
                        }
                    }
                } else {
                    trieNodeMutableRemove = trieNodeNodeAtIndex$runtime;
                    break;
                }
                trieNode = trieNodeNodeAtIndex$runtime;
            } else {
                trieNode = trieNodeNodeAtIndex$runtime;
                trieNodeMutableRemove = trieNode.mutableRemove(i, obj, obj2, i2 + 5, persistentHashMapBuilder);
            }
            return mutableReplaceNode(trieNode, trieNodeMutableRemove, iNodeIndex$runtime, iIndexSegment, persistentHashMapBuilder.ownership);
        }
        return this;
    }
}
