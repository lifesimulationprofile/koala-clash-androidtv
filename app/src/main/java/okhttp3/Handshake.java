package okhttp3;

import android.app.Application;
import android.content.Context;
import android.os.Trace;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.InputMethodManager;
import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.compose.animation.EnterExitState;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.CompositionImpl;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.retain.ManagedRetainedValuesStore;
import androidx.compose.runtime.retain.impl.PreconditionsKt;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.input.nestedscroll.NestedScrollNode;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.node.LookaheadPassDelegate;
import androidx.compose.ui.platform.AndroidPlatformTextInputSession;
import androidx.compose.ui.platform.ComposeViewContext;
import androidx.compose.ui.platform.DerivedSize;
import androidx.compose.ui.platform.InvertMatrixKt;
import androidx.compose.ui.platform.LifecycleRetainedValuesStoreOwner;
import androidx.compose.ui.spatial.RectManager;
import androidx.compose.ui.text.input.TextInputServiceAndroid;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.window.PopupLayout;
import androidx.core.view.MenuHostHelper;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDeepLink;
import androidx.navigation.compose.NavHostControllerKt;
import coil.network.EmptyNetworkObserver;
import com.google.accompanist.drawablepainter.DrawablePainter;
import com.google.accompanist.drawablepainter.DrawablePainter$callback$2$1;
import io.github.g00fy2.quickie.ScanQRCode;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CancellationException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import kotlin.Pair;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import okhttp3.internal.Util;
import okio.JvmFileHandle;
import okio.JvmSystemFileSystem;
import okio.Path;
import okio.RealBufferedSource;
import okio.ZipFileSystem;
import okio.internal.EocdRecord;
import okio.internal.ResourceFileSystem;
import okio.internal.ZipEntry;
import okio.internal.ZipFilesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Handshake {
    public final CipherSuite cipherSuite;
    public final List localCertificates;
    public final SynchronizedLazyImpl peerCertificates$delegate;
    public final TlsVersion tlsVersion;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class Companion {
        public static ImageVector _brightness4;

        public static Handshake get(SSLSession sSLSession) throws IOException {
            List listImmutableListOf;
            List listImmutableListOf2 = EmptyList.INSTANCE;
            String cipherSuite = sSLSession.getCipherSuite();
            if (cipherSuite == null) {
                throw new IllegalStateException("cipherSuite == null");
            }
            if (cipherSuite.equals("TLS_NULL_WITH_NULL_NULL") ? true : cipherSuite.equals("SSL_NULL_WITH_NULL_NULL")) {
                throw new IOException("cipherSuite == ".concat(cipherSuite));
            }
            CipherSuite cipherSuiteForJavaName = CipherSuite.Companion.forJavaName(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol == null) {
                throw new IllegalStateException("tlsVersion == null");
            }
            if ("NONE".equals(protocol)) {
                throw new IOException("tlsVersion == NONE");
            }
            TlsVersion tlsVersionForJavaName = TlsVersion.Companion.forJavaName(protocol);
            try {
                Certificate[] peerCertificates = sSLSession.getPeerCertificates();
                listImmutableListOf = peerCertificates != null ? Util.immutableListOf(Arrays.copyOf(peerCertificates, peerCertificates.length)) : listImmutableListOf2;
            } catch (SSLPeerUnverifiedException unused) {
            }
            Certificate[] localCertificates = sSLSession.getLocalCertificates();
            if (localCertificates != null) {
                listImmutableListOf2 = Util.immutableListOf(Arrays.copyOf(localCertificates, localCertificates.length));
            }
            return new Handshake(tlsVersionForJavaName, cipherSuiteForJavaName, listImmutableListOf2, new AnonymousClass2(23, listImmutableListOf));
        }
    }

    /* JADX INFO: renamed from: okhttp3.Handshake$peerCertificates$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass2 extends Lambda implements Function0 {
        public final /* synthetic */ Object $peerCertificatesFn;
        public final /* synthetic */ int $r8$classId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass2(int i, Object obj) {
            super(0);
            this.$r8$classId = i;
            this.$peerCertificatesFn = obj;
        }

        /* JADX WARN: Code duplicated, block: B:120:0x026a A[Catch: all -> 0x0205, TRY_LEAVE, TryCatch #5 {all -> 0x0205, blocks: (B:21:0x00ac, B:23:0x00b8, B:24:0x00c4, B:34:0x0128, B:36:0x0134, B:88:0x0204, B:84:0x01fb, B:91:0x0209, B:120:0x026a, B:126:0x028b, B:117:0x0264, B:132:0x0296, B:135:0x02a5, B:136:0x02ac, B:137:0x02ad, B:138:0x02b0, B:139:0x02b1, B:140:0x02c6, B:114:0x025f, B:37:0x013d, B:39:0x0146, B:42:0x0157, B:71:0x01e3, B:67:0x01dc, B:74:0x01e7, B:75:0x01ec, B:76:0x01ed, B:64:0x01d7, B:25:0x00cd, B:27:0x00d6, B:33:0x0104, B:129:0x028e, B:130:0x0293, B:81:0x01f6), top: B:289:0x00ac, inners: #3, #4, #7, #13 }] */
        /* JADX WARN: Code duplicated, block: B:124:0x0280  */
        /* JADX WARN: Code duplicated, block: B:330:0x028b A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:333:0x0283 A[SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r7v1, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            CompositionImpl compositionImpl;
            int iLastIndexOf$default;
            long j;
            RealBufferedSource realBufferedSource;
            Throwable th;
            Pair pair;
            Throwable th2;
            Throwable th3;
            Throwable th4;
            Pair pair2;
            int i = this.$r8$classId;
            long j2 = 0;
            boolean z = false;
            Object obj = this.$peerCertificatesFn;
            switch (i) {
                case 0:
                    try {
                        return (List) ((Lambda) obj).invoke();
                    } catch (SSLPeerUnverifiedException unused) {
                        return EmptyList.INSTANCE;
                    }
                case 1:
                    Transition transition = (Transition) obj;
                    Object objMo773getCurrentState = transition.transitionState.mo773getCurrentState();
                    EnterExitState enterExitState = EnterExitState.PostExit;
                    return Boolean.valueOf(objMo773getCurrentState == enterExitState && transition.targetState$delegate.getValue() == enterExitState);
                case 2:
                    ((FocusTargetNode) obj).fetchFocusProperties$ui();
                    return Unit.INSTANCE;
                case 3:
                    Unit unit = Unit.INSTANCE;
                    ((VectorPainter) obj).drawInvalidation$delegate.setValue(unit);
                    return unit;
                case 4:
                    return (CoroutineScope) ((Dispatcher) obj).runningSyncCalls;
                case 5:
                    return ((NestedScrollNode) obj).getNestedCoroutineScope();
                case 6:
                    LayoutNodeSubcompositionsState.NodeState nodeState = (LayoutNodeSubcompositionsState.NodeState) obj;
                    if (!((Boolean) nodeState.activeState.getValue()).booleanValue() && (compositionImpl = nodeState.composition) != null) {
                        compositionImpl.deactivate();
                    }
                    return Unit.INSTANCE;
                case 7:
                    LayoutNodeSubcompositionsState state = ((SubcomposeLayoutState) obj).getState();
                    LayoutNode layoutNode = state.root;
                    if (state.reusableCount != ((MutableVector) ((MutableObjectList.ObjectListMutableList) layoutNode.getFoldedChildren$ui()).objectList).size) {
                        MutableScatterMap mutableScatterMap = state.nodeToNodeState;
                        Object[] objArr = mutableScatterMap.values;
                        long[] jArr = mutableScatterMap.metadata;
                        int length = jArr.length - 2;
                        if (length >= 0) {
                            int i2 = 0;
                            while (true) {
                                long j3 = jArr[i2];
                                if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                                    int i3 = 8 - ((~(i2 - length)) >>> 31);
                                    long j4 = j3;
                                    for (int i4 = 0; i4 < i3; i4++) {
                                        if ((255 & j4) < 128) {
                                            ((LayoutNodeSubcompositionsState.NodeState) objArr[(i2 << 3) + i4]).forceRecompose = true;
                                        }
                                        j4 >>= 8;
                                    }
                                    if (i3 == 8) {
                                    }
                                }
                                if (i2 != length) {
                                    i2++;
                                }
                            }
                        }
                        if (layoutNode.lookaheadRoot != null) {
                            if (!layoutNode.layoutDelegate.lookaheadMeasurePending) {
                                LayoutNode.requestLookaheadRemeasure$ui$default(layoutNode, false, 7);
                            }
                        } else if (!layoutNode.getMeasurePending$ui()) {
                            LayoutNode.requestRemeasure$ui$default(layoutNode, false, 7);
                        }
                    }
                    return Unit.INSTANCE;
                case 8:
                    LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = ((LayoutNode) obj).layoutDelegate;
                    layoutNodeLayoutDelegate.measurePassDelegate.childDelegatesDirty = true;
                    LookaheadPassDelegate lookaheadPassDelegate = layoutNodeLayoutDelegate.lookaheadPassDelegate;
                    if (lookaheadPassDelegate != null) {
                        lookaheadPassDelegate.childDelegatesDirty = true;
                    }
                    return Unit.INSTANCE;
                case 9:
                    JobKt.cancel(((AndroidPlatformTextInputSession) obj).coroutineScope, (CancellationException) null);
                    return Unit.INSTANCE;
                case 10:
                    return Unit.INSTANCE;
                case 11:
                    View view = ((ComposeViewContext) obj).view;
                    return IntSize.m720equalsimpl0(0L, 0L) ? InvertMatrixKt.calculateWindowSize(view) : new DerivedSize(0L, Density.CC.m697$default$toDpSizekrfVVM(IntSizeKt.m724toSizeozmzZPI(0L), AndroidDensity_androidKt.Density(view.getContext())));
                case 12:
                    ManagedRetainedValuesStore managedRetainedValuesStore = (ManagedRetainedValuesStore) ((LifecycleRetainedValuesStoreOwner.RetainedValuesStoreEntry) obj)._retainedValuesStore.entries;
                    if (!managedRetainedValuesStore.isDisposed) {
                        if (managedRetainedValuesStore.isContentComposed) {
                            PreconditionsKt.throwIllegalStateException("ManagedValuesStore tried to enter composition twice. Did you attempt to install the same store multiple times or into two compositions?");
                        }
                        managedRetainedValuesStore.purgeUnusedExitedValues();
                        managedRetainedValuesStore.isContentComposed = true;
                    }
                    return Unit.INSTANCE;
                case 13:
                    RectManager rectManager = (RectManager) obj;
                    rectManager.dispatchToken = null;
                    Trace.beginSection("OnPositionedDispatch");
                    try {
                        rectManager.dispatchCallbacks();
                        Unit unit2 = Unit.INSTANCE;
                        return Unit.INSTANCE;
                    } finally {
                        Trace.endSection();
                    }
                case 14:
                    return (InputMethodManager) ((View) ((MenuHostHelper) obj).mOnInvalidateMenuCallback).getContext().getSystemService("input_method");
                case 15:
                    return new BaseInputConnection(((TextInputServiceAndroid) obj).view, false);
                case 16:
                    PopupLayout popupLayout = (PopupLayout) obj;
                    LayoutCoordinates parentLayoutCoordinates = popupLayout.getParentLayoutCoordinates();
                    return Boolean.valueOf((((parentLayoutCoordinates == null || !parentLayoutCoordinates.isAttached()) ? null : parentLayoutCoordinates) == null || popupLayout.m740getPopupContentSizebOM6tXw() == null) ? false : true);
                case 17:
                    NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
                    Context context = navBackStackEntry.context;
                    Context applicationContext = context != null ? context.getApplicationContext() : null;
                    return new SavedStateViewModelFactory(applicationContext instanceof Application ? (Application) applicationContext : null, navBackStackEntry, navBackStackEntry.getArguments());
                case 18:
                    return new NavDeepLink((String) obj);
                case 19:
                    return NavHostControllerKt.access$createNavController((Context) obj);
                case 20:
                    List list = (List) ((State) obj).getValue();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : list) {
                        if (Intrinsics.areEqual(((NavBackStackEntry) obj2).destination.navigatorName, "composable")) {
                            arrayList.add(obj2);
                        }
                    }
                    return arrayList;
                case 21:
                    return ((Function0) obj).invoke();
                case 22:
                    return new DrawablePainter$callback$2$1(0, (DrawablePainter) obj);
                case 23:
                    return (List) obj;
                default:
                    ResourceFileSystem resourceFileSystem = (ResourceFileSystem) obj;
                    ClassLoader classLoader = resourceFileSystem.classLoader;
                    JvmSystemFileSystem jvmSystemFileSystem = resourceFileSystem.systemFileSystem;
                    ArrayList list2 = Collections.list(classLoader.getResources(""));
                    ArrayList arrayList2 = new ArrayList();
                    int size = list2.size();
                    int i5 = 0;
                    while (i5 < size) {
                        Object obj3 = list2.get(i5);
                        i5++;
                        URL url = (URL) obj3;
                        if (Intrinsics.areEqual(url.getProtocol(), "file")) {
                            String str = Path.DIRECTORY_SEPARATOR;
                            pair2 = new Pair(jvmSystemFileSystem, Path.Companion.get$default(new File(url.toURI())));
                        } else {
                            pair2 = null;
                        }
                        if (pair2 != null) {
                            arrayList2.add(pair2);
                        }
                    }
                    ArrayList list3 = Collections.list(classLoader.getResources("META-INF/MANIFEST.MF"));
                    ArrayList arrayList3 = new ArrayList();
                    int size2 = list3.size();
                    int i6 = 0;
                    while (i6 < size2) {
                        int i7 = i6 + 1;
                        String string = ((URL) list3.get(i6)).toString();
                        if (StringsKt__StringsJVMKt.startsWith(string, "jar:file:", z) && (iLastIndexOf$default = StringsKt.lastIndexOf$default(6, string, "!")) != -1) {
                            String str2 = Path.DIRECTORY_SEPARATOR;
                            Path path = Path.Companion.get$default(new File(URI.create(string.substring(4, iLastIndexOf$default))));
                            JvmFileHandle jvmFileHandleOpenReadOnly = jvmSystemFileSystem.openReadOnly(path);
                            try {
                                long size3 = jvmFileHandleOpenReadOnly.size() - ((long) 22);
                                if (size3 < j2) {
                                    throw new IOException("not a zip: size=" + jvmFileHandleOpenReadOnly.size());
                                }
                                long jMax = Math.max(size3 - 65536, j2);
                                j = j2;
                                long j5 = size3;
                                while (true) {
                                    RealBufferedSource realBufferedSource2 = new RealBufferedSource(jvmFileHandleOpenReadOnly.source(j5));
                                    try {
                                        if (realBufferedSource2.readIntLe() == 101010256) {
                                            int shortLe = realBufferedSource2.readShortLe() & 65535;
                                            int shortLe2 = realBufferedSource2.readShortLe() & 65535;
                                            long shortLe3 = realBufferedSource2.readShortLe() & 65535;
                                            if (shortLe3 != (realBufferedSource2.readShortLe() & 65535) || shortLe != 0 || shortLe2 != 0) {
                                                throw new IOException("unsupported zip: spanned");
                                            }
                                            long j6 = j5;
                                            realBufferedSource2.skip(4L);
                                            long intLe = ((long) realBufferedSource2.readIntLe()) & 4294967295L;
                                            int shortLe4 = realBufferedSource2.readShortLe() & 65535;
                                            EocdRecord eocdRecord = new EocdRecord(shortLe3, intLe, shortLe4);
                                            realBufferedSource2.readUtf8(shortLe4);
                                            realBufferedSource2.close();
                                            long j7 = j6 - ((long) 20);
                                            if (j7 > j) {
                                                RealBufferedSource realBufferedSource3 = new RealBufferedSource(jvmFileHandleOpenReadOnly.source(j7));
                                                try {
                                                    if (realBufferedSource3.readIntLe() == 117853008) {
                                                        int intLe2 = realBufferedSource3.readIntLe();
                                                        long longLe = realBufferedSource3.readLongLe();
                                                        if (realBufferedSource3.readIntLe() != 1 || intLe2 != 0) {
                                                            throw new IOException("unsupported zip: spanned");
                                                        }
                                                        RealBufferedSource realBufferedSource4 = new RealBufferedSource(jvmFileHandleOpenReadOnly.source(longLe));
                                                        try {
                                                            int intLe3 = realBufferedSource4.readIntLe();
                                                            if (intLe3 != 101075792) {
                                                                throw new IOException("bad zip: expected " + ZipFilesKt.getHex(101075792) + " but was " + ZipFilesKt.getHex(intLe3));
                                                            }
                                                            realBufferedSource4.skip(12L);
                                                            int intLe4 = realBufferedSource4.readIntLe();
                                                            int intLe5 = realBufferedSource4.readIntLe();
                                                            long longLe2 = realBufferedSource4.readLongLe();
                                                            if (longLe2 != realBufferedSource4.readLongLe() || intLe4 != 0 || intLe5 != 0) {
                                                                throw new IOException("unsupported zip: spanned");
                                                            }
                                                            realBufferedSource4.skip(8L);
                                                            EocdRecord eocdRecord2 = new EocdRecord(longLe2, realBufferedSource4.readLongLe(), shortLe4);
                                                            try {
                                                                Unit unit3 = Unit.INSTANCE;
                                                                try {
                                                                    realBufferedSource4.close();
                                                                    th4 = null;
                                                                } catch (Throwable th5) {
                                                                    th4 = th5;
                                                                }
                                                                eocdRecord = eocdRecord2;
                                                            } catch (Throwable th6) {
                                                                th3 = th6;
                                                                eocdRecord = eocdRecord2;
                                                                try {
                                                                    realBufferedSource4.close();
                                                                } catch (Throwable th7) {
                                                                    ScanQRCode.addSuppressed(th3, th7);
                                                                }
                                                                th4 = th3;
                                                            }
                                                            if (th4 != null) {
                                                                throw th4;
                                                            }
                                                        } catch (Throwable th8) {
                                                            th3 = th8;
                                                        }
                                                    }
                                                    Unit unit4 = Unit.INSTANCE;
                                                    try {
                                                        realBufferedSource3.close();
                                                        th2 = null;
                                                    } catch (Throwable th9) {
                                                        th2 = th9;
                                                    }
                                                } catch (Throwable th10) {
                                                    try {
                                                        realBufferedSource3.close();
                                                    } catch (Throwable th11) {
                                                        ScanQRCode.addSuppressed(th10, th11);
                                                    }
                                                    th2 = th10;
                                                }
                                                if (th2 != null) {
                                                    throw th2;
                                                }
                                            }
                                            EocdRecord eocdRecord3 = eocdRecord;
                                            ArrayList arrayList4 = new ArrayList();
                                            RealBufferedSource realBufferedSource5 = new RealBufferedSource(jvmFileHandleOpenReadOnly.source(eocdRecord3.centralDirectoryOffset));
                                            try {
                                                long j8 = eocdRecord3.entryCount;
                                                long j9 = j;
                                                while (j9 < j8) {
                                                    ZipEntry centralDirectoryZipEntry = ZipFilesKt.readCentralDirectoryZipEntry(realBufferedSource5);
                                                    realBufferedSource = realBufferedSource5;
                                                    long j10 = j8;
                                                    try {
                                                        if (centralDirectoryZipEntry.offset >= eocdRecord3.centralDirectoryOffset) {
                                                            throw new IOException("bad zip: local file header offset >= central directory offset");
                                                        }
                                                        Path path2 = ResourceFileSystem.ROOT;
                                                        if (EmptyNetworkObserver.access$keepPath(centralDirectoryZipEntry.canonicalPath)) {
                                                            arrayList4.add(centralDirectoryZipEntry);
                                                        }
                                                        j9++;
                                                        realBufferedSource5 = realBufferedSource;
                                                        j8 = j10;
                                                    } catch (Throwable th12) {
                                                        th = th12;
                                                        Throwable th13 = th;
                                                        try {
                                                            realBufferedSource.close();
                                                        } catch (Throwable th14) {
                                                            ScanQRCode.addSuppressed(th13, th14);
                                                        }
                                                        th = th13;
                                                        if (th == null) {
                                                            throw th;
                                                        }
                                                        ZipFileSystem zipFileSystem = new ZipFileSystem(path, jvmSystemFileSystem, ZipFilesKt.buildIndex(arrayList4));
                                                        try {
                                                            jvmFileHandleOpenReadOnly.close();
                                                            break;
                                                        } catch (Throwable unused2) {
                                                        }
                                                        pair = new Pair(zipFileSystem, ResourceFileSystem.ROOT);
                                                        if (pair != null) {
                                                            arrayList3.add(pair);
                                                        }
                                                        i6 = i7;
                                                        j2 = j;
                                                        z = false;
                                                    }
                                                    break;
                                                }
                                                RealBufferedSource realBufferedSource6 = realBufferedSource5;
                                                Unit unit5 = Unit.INSTANCE;
                                                try {
                                                    realBufferedSource6.close();
                                                    th = null;
                                                } catch (Throwable th15) {
                                                    th = th15;
                                                }
                                            } catch (Throwable th16) {
                                                th = th16;
                                                realBufferedSource = realBufferedSource5;
                                            }
                                            if (th == null) {
                                                throw th;
                                            }
                                            ZipFileSystem zipFileSystem2 = new ZipFileSystem(path, jvmSystemFileSystem, ZipFilesKt.buildIndex(arrayList4));
                                            jvmFileHandleOpenReadOnly.close();
                                            pair = new Pair(zipFileSystem2, ResourceFileSystem.ROOT);
                                            break;
                                            try {
                                                jvmFileHandleOpenReadOnly.close();
                                                throw th;
                                            } catch (Throwable th17) {
                                                ScanQRCode.addSuppressed(th, th17);
                                                throw th;
                                            }
                                        }
                                        long j11 = j5;
                                        realBufferedSource2.close();
                                        j5 = j11 - 1;
                                        if (j5 < jMax) {
                                            throw new IOException("not a zip: end of central directory signature not found");
                                        }
                                    } catch (Throwable th18) {
                                        realBufferedSource2.close();
                                        throw th18;
                                    }
                                }
                            } catch (Throwable th19) {
                                jvmFileHandleOpenReadOnly.close();
                                throw th19;
                            }
                        } else {
                            j = j2;
                            pair = null;
                        }
                        if (pair != null) {
                            arrayList3.add(pair);
                        }
                        i6 = i7;
                        j2 = j;
                        z = false;
                    }
                    return CollectionsKt.plus((Collection) arrayList2, (List) arrayList3);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function0 function0) {
            super(0);
            this.$r8$classId = 0;
            this.$peerCertificatesFn = (Lambda) function0;
        }
    }

    public Handshake(TlsVersion tlsVersion, CipherSuite cipherSuite, List list, Function0 function0) {
        this.tlsVersion = tlsVersion;
        this.cipherSuite = cipherSuite;
        this.localCertificates = list;
        this.peerCertificates$delegate = new SynchronizedLazyImpl(new AnonymousClass2(function0));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Handshake)) {
            return false;
        }
        Handshake handshake = (Handshake) obj;
        return handshake.tlsVersion == this.tlsVersion && Intrinsics.areEqual(handshake.cipherSuite, this.cipherSuite) && Intrinsics.areEqual(handshake.peerCertificates(), peerCertificates()) && Intrinsics.areEqual(handshake.localCertificates, this.localCertificates);
    }

    public final int hashCode() {
        return this.localCertificates.hashCode() + ((peerCertificates().hashCode() + ((this.cipherSuite.hashCode() + ((this.tlsVersion.hashCode() + 527) * 31)) * 31)) * 31);
    }

    public final List peerCertificates() {
        return (List) this.peerCertificates$delegate.getValue();
    }

    public final String toString() {
        List<Certificate> listPeerCertificates = peerCertificates();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(listPeerCertificates, 10));
        for (Certificate certificate : listPeerCertificates) {
            arrayList.add(certificate instanceof X509Certificate ? ((X509Certificate) certificate).getSubjectDN().toString() : certificate.getType());
        }
        String string = arrayList.toString();
        StringBuilder sb = new StringBuilder("Handshake{tlsVersion=");
        sb.append(this.tlsVersion);
        sb.append(" cipherSuite=");
        sb.append(this.cipherSuite);
        sb.append(" peerCertificates=");
        sb.append(string);
        sb.append(" localCertificates=");
        List<Certificate> list = this.localCertificates;
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (Certificate certificate2 : list) {
            arrayList2.add(certificate2 instanceof X509Certificate ? ((X509Certificate) certificate2).getSubjectDN().toString() : certificate2.getType());
        }
        sb.append(arrayList2);
        sb.append('}');
        return sb.toString();
    }
}
