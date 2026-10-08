package okio.internal;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.TwoWayConverterImpl;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.material3.TooltipKt$TooltipBox$$inlined$animateFloat$1;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotId_jvmKt;
import androidx.compose.ui.AbsoluteAlignment;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.Navigator;
import androidx.recyclerview.widget.GapWorker;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import okio.BufferedSource;
import okio.C0045SegmentedByteString;
import okio.Path;
import okio.RealBufferedSource;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ZipFilesKt {
    public static final char[] HEX_DIGIT_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: renamed from: okio.internal.ZipFilesKt$readOrSkipLocalHeader$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class C00461 extends Lambda implements Function2 {
        public final /* synthetic */ Object $extendedCreatedAtSeconds;
        public final /* synthetic */ Object $extendedLastAccessedAtSeconds;
        public final /* synthetic */ Object $extendedLastModifiedAtSeconds;
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Object $this_readOrSkipLocalHeader;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ C00461(Object obj, Object obj2, Object obj3, Object obj4, int i) {
            super(2);
            this.$r8$classId = i;
            this.$this_readOrSkipLocalHeader = obj;
            this.$extendedLastModifiedAtSeconds = obj2;
            this.$extendedLastAccessedAtSeconds = obj3;
            this.$extendedCreatedAtSeconds = obj4;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) throws IOException {
            Object objMo773getCurrentState;
            switch (this.$r8$classId) {
                case 0:
                    int iIntValue = ((Number) obj).intValue();
                    long jLongValue = ((Number) obj2).longValue();
                    BufferedSource bufferedSource = (BufferedSource) this.$this_readOrSkipLocalHeader;
                    if (iIntValue == 21589) {
                        if (jLongValue < 1) {
                            throw new IOException("bad zip: extended timestamp extra too short");
                        }
                        byte b = bufferedSource.readByte();
                        boolean z = (b & 1) == 1;
                        boolean z2 = (b & 2) == 2;
                        boolean z3 = (b & 4) == 4;
                        long j = z ? 5L : 1L;
                        if (z2) {
                            j += 4;
                        }
                        if (z3) {
                            j += 4;
                        }
                        if (jLongValue < j) {
                            throw new IOException("bad zip: extended timestamp extra too short");
                        }
                        if (z) {
                            ((Ref$ObjectRef) this.$extendedLastModifiedAtSeconds).element = Integer.valueOf(bufferedSource.readIntLe());
                        }
                        if (z2) {
                            ((Ref$ObjectRef) this.$extendedLastAccessedAtSeconds).element = Integer.valueOf(bufferedSource.readIntLe());
                        }
                        if (z3) {
                            ((Ref$ObjectRef) this.$extendedCreatedAtSeconds).element = Integer.valueOf(bufferedSource.readIntLe());
                        }
                    }
                    return Unit.INSTANCE;
                case 1:
                    GapComposer gapComposer = (GapComposer) obj;
                    int iIntValue2 = ((Number) obj2).intValue();
                    if (gapComposer.shouldExecute(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                        Transition transition = (Transition) this.$this_readOrSkipLocalHeader;
                        TweenSpec tweenSpec = (TweenSpec) this.$extendedLastModifiedAtSeconds;
                        TwoWayConverterImpl twoWayConverterImpl = ArcSplineKt.FloatToVector;
                        boolean zIsSeeking = transition.isSeeking();
                        Lifecycle lifecycle = transition.transitionState;
                        NeverEqualPolicy neverEqualPolicy = Composer$Companion.Empty;
                        if (zIsSeeking) {
                            gapComposer.startReplaceGroup(1666827533);
                            gapComposer.end(false);
                            objMo773getCurrentState = lifecycle.mo773getCurrentState();
                        } else {
                            gapComposer.startReplaceGroup(1666573488);
                            boolean zChanged = gapComposer.changed(transition);
                            objMo773getCurrentState = gapComposer.rememberedValue();
                            if (zChanged || objMo773getCurrentState == neverEqualPolicy) {
                                Snapshot currentThreadSnapshot = SnapshotId_jvmKt.getCurrentThreadSnapshot();
                                Function1 readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                                Snapshot snapshotMakeCurrentNonObservable = SnapshotId_jvmKt.makeCurrentNonObservable(currentThreadSnapshot);
                                try {
                                    Object objMo773getCurrentState2 = lifecycle.mo773getCurrentState();
                                    SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                                    gapComposer.updateRememberedValue(objMo773getCurrentState2);
                                    objMo773getCurrentState = objMo773getCurrentState2;
                                } catch (Throwable th) {
                                    SnapshotId_jvmKt.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                                    throw th;
                                }
                            }
                            gapComposer.end(false);
                        }
                        gapComposer.startReplaceGroup(1378811975);
                        Object obj3 = this.$extendedLastAccessedAtSeconds;
                        float f = Intrinsics.areEqual(objMo773getCurrentState, obj3) ? 1.0f : 0.0f;
                        gapComposer.end(false);
                        Float fValueOf = Float.valueOf(f);
                        boolean zChanged2 = gapComposer.changed(transition);
                        Object objRememberedValue = gapComposer.rememberedValue();
                        if (zChanged2 || objRememberedValue == neverEqualPolicy) {
                            objRememberedValue = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transition, 1));
                            gapComposer.updateRememberedValue(objRememberedValue);
                        }
                        Object value = ((State) objRememberedValue).getValue();
                        gapComposer.startReplaceGroup(1378811975);
                        float f2 = Intrinsics.areEqual(value, obj3) ? 1.0f : 0.0f;
                        gapComposer.end(false);
                        Float fValueOf2 = Float.valueOf(f2);
                        boolean zChanged3 = gapComposer.changed(transition);
                        Object objRememberedValue2 = gapComposer.rememberedValue();
                        if (zChanged3 || objRememberedValue2 == neverEqualPolicy) {
                            objRememberedValue2 = Stack.derivedStateOf(new TooltipKt$TooltipBox$$inlined$animateFloat$1(transition, 2));
                            gapComposer.updateRememberedValue(objRememberedValue2);
                        }
                        gapComposer.startReplaceGroup(955869654);
                        gapComposer.end(false);
                        Transition.TransitionAnimationState transitionAnimationStateCreateTransitionAnimation = ArcSplineKt.createTransitionAnimation(transition, fValueOf, fValueOf2, tweenSpec, twoWayConverterImpl, gapComposer, 0);
                        boolean zChanged4 = gapComposer.changed(transitionAnimationStateCreateTransitionAnimation);
                        Object objRememberedValue3 = gapComposer.rememberedValue();
                        if (zChanged4 || objRememberedValue3 == neverEqualPolicy) {
                            objRememberedValue3 = new Navigator.AnonymousClass1(5, transitionAnimationStateCreateTransitionAnimation);
                            gapComposer.updateRememberedValue(objRememberedValue3);
                        }
                        Modifier modifierGraphicsLayer = BrushKt.graphicsLayer(Modifier.Companion.$$INSTANCE, (Function1) objRememberedValue3);
                        ComposableLambdaImpl composableLambdaImpl = (ComposableLambdaImpl) this.$extendedCreatedAtSeconds;
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.TopStart, false);
                        long j2 = gapComposer.compositeKeyHashCode;
                        int i = (int) (j2 ^ (j2 >>> 32));
                        PersistentCompositionLocalMap persistentCompositionLocalMapCurrentCompositionLocalScope = gapComposer.currentCompositionLocalScope();
                        Modifier modifierMaterializeModifier = AbsoluteAlignment.materializeModifier(gapComposer, modifierGraphicsLayer);
                        ComposeUiNode.Companion.getClass();
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                        gapComposer.startReusableNode();
                        if (gapComposer.inserting) {
                            gapComposer.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            gapComposer.useNode();
                        }
                        Stack.m295setimpl(gapComposer, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                        Stack.m295setimpl(gapComposer, persistentCompositionLocalMapCurrentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                        Stack.m291initimpl(gapComposer, Integer.valueOf(i), ComposeUiNode.Companion.SetCompositeKeyHash);
                        Stack.m294reconcileimpl(gapComposer, ComposeUiNode.Companion.ApplyOnDeactivatedNodeAssertion);
                        Stack.m295setimpl(gapComposer, modifierMaterializeModifier, ComposeUiNode.Companion.SetModifier);
                        composableLambdaImpl.invoke(obj3, (Object) gapComposer, (Object) 0);
                        gapComposer.end(true);
                    } else {
                        gapComposer.skipToGroupEnd();
                    }
                    return Unit.INSTANCE;
                default:
                    int iIntValue3 = ((Number) obj).intValue();
                    long jLongValue2 = ((Number) obj2).longValue();
                    RealBufferedSource realBufferedSource = (RealBufferedSource) this.$this_readOrSkipLocalHeader;
                    if (iIntValue3 == 1) {
                        Ref$ObjectRef ref$ObjectRef = (Ref$ObjectRef) this.$extendedLastModifiedAtSeconds;
                        if (ref$ObjectRef.element != null) {
                            throw new IOException("bad zip: NTFS extra attribute tag 0x0001 repeated");
                        }
                        if (jLongValue2 != 24) {
                            throw new IOException("bad zip: NTFS extra attribute tag 0x0001 size != 24");
                        }
                        ref$ObjectRef.element = Long.valueOf(realBufferedSource.readLongLe());
                        ((Ref$ObjectRef) this.$extendedLastAccessedAtSeconds).element = Long.valueOf(realBufferedSource.readLongLe());
                        ((Ref$ObjectRef) this.$extendedCreatedAtSeconds).element = Long.valueOf(realBufferedSource.readLongLe());
                    }
                    return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C00461(Ref$ObjectRef ref$ObjectRef, RealBufferedSource realBufferedSource, Ref$ObjectRef ref$ObjectRef2, Ref$ObjectRef ref$ObjectRef3) {
            super(2);
            this.$r8$classId = 2;
            this.$extendedLastModifiedAtSeconds = ref$ObjectRef;
            this.$this_readOrSkipLocalHeader = realBufferedSource;
            this.$extendedLastAccessedAtSeconds = ref$ObjectRef2;
            this.$extendedCreatedAtSeconds = ref$ObjectRef3;
        }
    }

    public static final int access$decodeHexDigit(char c) {
        if ('0' <= c && c < ':') {
            return c - '0';
        }
        if ('a' <= c && c < 'g') {
            return c - 'W';
        }
        if ('A' <= c && c < 'G') {
            return c - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c);
    }

    public static final LinkedHashMap buildIndex(ArrayList arrayList) {
        String str = Path.DIRECTORY_SEPARATOR;
        Path path = Path.Companion.get$default("/");
        Pair[] pairArr = {new Pair(path, new ZipEntry(path, true, null, 0L, 0L, 0L, 0, 0L, 0, 0, null, null, null, 65532))};
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsKt.mapCapacity(1));
        MapsKt__MapsKt.putAll(linkedHashMap, pairArr);
        for (ZipEntry zipEntry : CollectionsKt.sortedWith(arrayList, new GapWorker.AnonymousClass1(9))) {
            if (((ZipEntry) linkedHashMap.put(zipEntry.canonicalPath, zipEntry)) == null) {
                while (true) {
                    Path path2 = zipEntry.canonicalPath;
                    Path pathParent = path2.parent();
                    if (pathParent == null) {
                        break;
                    }
                    ZipEntry zipEntry2 = (ZipEntry) linkedHashMap.get(pathParent);
                    if (zipEntry2 != null) {
                        zipEntry2.children.add(path2);
                        break;
                    }
                    ZipEntry zipEntry3 = new ZipEntry(pathParent, true, null, 0L, 0L, 0L, 0, 0L, 0, 0, null, null, null, 65532);
                    linkedHashMap.put(pathParent, zipEntry3);
                    zipEntry3.children.add(path2);
                    zipEntry = zipEntry3;
                }
            }
        }
        return linkedHashMap;
    }

    public static final String getHex(int i) {
        CharsKt.checkRadix(16);
        return "0x".concat(Integer.toString(i, 16));
    }

    public static final ZipEntry readCentralDirectoryZipEntry(final RealBufferedSource realBufferedSource) throws IOException {
        int intLe = realBufferedSource.readIntLe();
        if (intLe != 33639248) {
            throw new IOException("bad zip: expected " + getHex(33639248) + " but was " + getHex(intLe));
        }
        realBufferedSource.skip(4L);
        short shortLe = realBufferedSource.readShortLe();
        int i = shortLe & 65535;
        if ((shortLe & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + getHex(i));
        }
        int shortLe2 = realBufferedSource.readShortLe() & 65535;
        int shortLe3 = realBufferedSource.readShortLe() & 65535;
        int shortLe4 = realBufferedSource.readShortLe() & 65535;
        long intLe2 = ((long) realBufferedSource.readIntLe()) & 4294967295L;
        final Ref$LongRef ref$LongRef = new Ref$LongRef();
        ref$LongRef.element = ((long) realBufferedSource.readIntLe()) & 4294967295L;
        final Ref$LongRef ref$LongRef2 = new Ref$LongRef();
        ref$LongRef2.element = ((long) realBufferedSource.readIntLe()) & 4294967295L;
        int shortLe5 = realBufferedSource.readShortLe() & 65535;
        int shortLe6 = realBufferedSource.readShortLe() & 65535;
        int shortLe7 = 65535 & realBufferedSource.readShortLe();
        realBufferedSource.skip(8L);
        final Ref$LongRef ref$LongRef3 = new Ref$LongRef();
        ref$LongRef3.element = ((long) realBufferedSource.readIntLe()) & 4294967295L;
        String utf8 = realBufferedSource.readUtf8(shortLe5);
        if (StringsKt.contains$default(utf8, (char) 0)) {
            throw new IOException("bad zip: filename contains 0x00");
        }
        final long j = ref$LongRef2.element == 4294967295L ? 8 : 0L;
        if (ref$LongRef.element == 4294967295L) {
            j += (long) 8;
        }
        if (ref$LongRef3.element == 4294967295L) {
            j += (long) 8;
        }
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        final Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        readExtra(realBufferedSource, shortLe6, new Function2() { // from class: okio.internal.ZipFilesKt.readCentralDirectoryZipEntry.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) throws IOException {
                int iIntValue = ((Number) obj).intValue();
                long jLongValue = ((Number) obj2).longValue();
                RealBufferedSource realBufferedSource2 = realBufferedSource;
                if (iIntValue == 1) {
                    Ref$BooleanRef ref$BooleanRef2 = ref$BooleanRef;
                    if (ref$BooleanRef2.element) {
                        throw new IOException("bad zip: zip64 extra repeated");
                    }
                    ref$BooleanRef2.element = true;
                    if (jLongValue < j) {
                        throw new IOException("bad zip: zip64 extra too short");
                    }
                    Ref$LongRef ref$LongRef4 = ref$LongRef2;
                    long longLe = ref$LongRef4.element;
                    if (longLe == 4294967295L) {
                        longLe = realBufferedSource2.readLongLe();
                    }
                    ref$LongRef4.element = longLe;
                    Ref$LongRef ref$LongRef5 = ref$LongRef;
                    ref$LongRef5.element = ref$LongRef5.element == 4294967295L ? realBufferedSource2.readLongLe() : 0L;
                    Ref$LongRef ref$LongRef6 = ref$LongRef3;
                    ref$LongRef6.element = ref$LongRef6.element == 4294967295L ? realBufferedSource2.readLongLe() : 0L;
                } else if (iIntValue == 10) {
                    if (jLongValue < 4) {
                        throw new IOException("bad zip: NTFS extra too short");
                    }
                    realBufferedSource2.skip(4L);
                    ZipFilesKt.readExtra(realBufferedSource2, (int) (jLongValue - 4), new C00461(ref$ObjectRef, realBufferedSource2, ref$ObjectRef2, ref$ObjectRef3));
                }
                return Unit.INSTANCE;
            }
        });
        if (j > 0 && !ref$BooleanRef.element) {
            throw new IOException("bad zip: zip64 extra required but absent");
        }
        String utf9 = realBufferedSource.readUtf8(shortLe7);
        String str = Path.DIRECTORY_SEPARATOR;
        return new ZipEntry(Path.Companion.get$default("/").resolve(utf8), utf8.endsWith("/"), utf9, intLe2, ref$LongRef.element, ref$LongRef2.element, shortLe2, ref$LongRef3.element, shortLe4, shortLe3, (Long) ref$ObjectRef.element, (Long) ref$ObjectRef2.element, (Long) ref$ObjectRef3.element, 57344);
    }

    public static final void readExtra(BufferedSource bufferedSource, int i, Function2 function2) throws IOException {
        long j = i;
        while (j != 0) {
            if (j < 4) {
                throw new IOException("bad zip: truncated header in extra field");
            }
            int shortLe = bufferedSource.readShortLe() & 65535;
            long shortLe2 = ((long) bufferedSource.readShortLe()) & 65535;
            long j2 = j - ((long) 4);
            if (j2 < shortLe2) {
                throw new IOException("bad zip: truncated value in extra field");
            }
            bufferedSource.require(shortLe2);
            long j3 = bufferedSource.getBuffer().size;
            function2.invoke(Integer.valueOf(shortLe), Long.valueOf(shortLe2));
            long j4 = (bufferedSource.getBuffer().size + shortLe2) - j3;
            if (j4 < 0) {
                throw new IOException(ImageAnalysis$$ExternalSyntheticLambda1.m("unsupported zip: too many bytes processed for ", shortLe));
            }
            if (j4 > 0) {
                bufferedSource.getBuffer().skip(j4);
            }
            j = j2 - shortLe2;
        }
    }

    public static final ZipEntry readOrSkipLocalHeader(RealBufferedSource realBufferedSource, ZipEntry zipEntry) throws IOException {
        int intLe = realBufferedSource.readIntLe();
        if (intLe != 67324752) {
            throw new IOException("bad zip: expected " + getHex(67324752) + " but was " + getHex(intLe));
        }
        realBufferedSource.skip(2L);
        short shortLe = realBufferedSource.readShortLe();
        int i = shortLe & 65535;
        if ((shortLe & 1) != 0) {
            throw new IOException("unsupported zip: general purpose bit flag=" + getHex(i));
        }
        realBufferedSource.skip(18L);
        long shortLe2 = ((long) realBufferedSource.readShortLe()) & 65535;
        int shortLe3 = realBufferedSource.readShortLe() & 65535;
        realBufferedSource.skip(shortLe2);
        if (zipEntry == null) {
            realBufferedSource.skip(shortLe3);
            return null;
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
        readExtra(realBufferedSource, shortLe3, new C00461(realBufferedSource, ref$ObjectRef, ref$ObjectRef2, ref$ObjectRef3, 0));
        return new ZipEntry(zipEntry.canonicalPath, zipEntry.isDirectory, zipEntry.comment, zipEntry.crc, zipEntry.compressedSize, zipEntry.size, zipEntry.compressionMethod, zipEntry.offset, zipEntry.dosLastModifiedAtDate, zipEntry.dosLastModifiedAtTime, zipEntry.ntfsLastModifiedAtFiletime, zipEntry.ntfsLastAccessedAtFiletime, zipEntry.ntfsCreatedAtFiletime, (Integer) ref$ObjectRef.element, (Integer) ref$ObjectRef2.element, (Integer) ref$ObjectRef3.element);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0021 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:12:0x0022  */
    public static final int segment(C0045SegmentedByteString c0045SegmentedByteString, int i) {
        int i2;
        int[] iArr = c0045SegmentedByteString.directory;
        int i3 = i + 1;
        int length = c0045SegmentedByteString.segments.length - 1;
        int i4 = 0;
        while (i4 <= length) {
            i2 = (i4 + length) >>> 1;
            int i5 = iArr[i2];
            if (i5 < i3) {
                i4 = i2 + 1;
            } else {
                if (i5 <= i3) {
                    if (i2 >= 0) {
                        return i2;
                    }
                    return ~i2;
                }
                length = i2 - 1;
            }
        }
        i2 = (-i4) - 1;
        if (i2 >= 0) {
            return i2;
        }
        return ~i2;
    }
}
