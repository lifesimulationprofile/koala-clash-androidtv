package androidx.compose.ui.focus;

import android.os.Trace;
import android.view.KeyEvent;
import android.view.View;
import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import androidx.collection.MutableLongSet;
import androidx.collection.MutableObjectList;
import androidx.collection.ScatterMapKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.key.Key_androidKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeDrawScope$record$1;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.TailModifierNode;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.unit.LayoutDirection;
import coil.network.HttpException;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FocusOwnerImpl implements FocusOwner {
    public FocusTargetNode activeFocusTargetNode;
    public final FocusInvalidationManager focusInvalidationManager;
    public MutableLongSet keysCurrentlyDown;
    public final AndroidComposeView owner;
    public final AndroidComposeView platformFocusOwner;
    public final FocusTargetNode rootFocusNode = new FocusTargetNode(2, null, 14);
    public final FocusOwnerImpl$modifier$1 modifier = new ModifierNodeElement() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$modifier$1
        @Override // androidx.compose.ui.node.ModifierNodeElement
        public final Modifier.Node create() {
            return this.this$0.rootFocusNode;
        }

        public final boolean equals(Object obj) {
            return obj == this;
        }

        public final int hashCode() {
            return this.this$0.rootFocusNode.hashCode();
        }

        @Override // androidx.compose.ui.node.ModifierNodeElement
        public final /* bridge */ /* synthetic */ void update(Modifier.Node node) {
        }
    };
    public final MutableObjectList listeners = new MutableObjectList(1);

    /* JADX WARN: Type inference failed for: r4v3, types: [androidx.compose.ui.focus.FocusOwnerImpl$modifier$1] */
    public FocusOwnerImpl(AndroidComposeView androidComposeView, AndroidComposeView androidComposeView2) {
        this.platformFocusOwner = androidComposeView;
        this.owner = androidComposeView2;
        this.focusInvalidationManager = new FocusInvalidationManager(this, androidComposeView2);
    }

    public final boolean clearFocus(boolean z) {
        NodeChain nodeChain;
        if (getActiveFocusTargetNode() != null) {
            FocusTargetNode activeFocusTargetNode = getActiveFocusTargetNode();
            setActiveFocusTargetNode(null);
            if (activeFocusTargetNode != null) {
                FocusStateImpl focusStateImpl = FocusStateImpl.Active;
                FocusStateImpl focusStateImpl2 = FocusStateImpl.Inactive;
                activeFocusTargetNode.dispatchFocusCallbacks$ui(focusStateImpl, focusStateImpl2);
                if (!activeFocusTargetNode.node.isAttached) {
                    InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                }
                Modifier.Node node = activeFocusTargetNode.node.parent;
                LayoutNode layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(activeFocusTargetNode);
                while (layoutNodeRequireLayoutNode != null) {
                    if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 1024) != 0) {
                        while (node != null) {
                            if ((node.kindSet & 1024) != 0) {
                                MutableVector mutableVector = null;
                                Modifier.Node nodeAccess$pop = node;
                                while (nodeAccess$pop != null) {
                                    if (nodeAccess$pop instanceof FocusTargetNode) {
                                        ((FocusTargetNode) nodeAccess$pop).dispatchFocusCallbacks$ui(FocusStateImpl.ActiveParent, focusStateImpl2);
                                    } else if ((nodeAccess$pop.kindSet & 1024) != 0 && (nodeAccess$pop instanceof DelegatingNode)) {
                                        int i = 0;
                                        for (Modifier.Node node2 = ((DelegatingNode) nodeAccess$pop).delegate; node2 != null; node2 = node2.child) {
                                            if ((node2.kindSet & 1024) != 0) {
                                                i++;
                                                if (i == 1) {
                                                    nodeAccess$pop = node2;
                                                } else {
                                                    if (mutableVector == null) {
                                                        mutableVector = new MutableVector(new Modifier.Node[16]);
                                                    }
                                                    if (nodeAccess$pop != null) {
                                                        mutableVector.add(nodeAccess$pop);
                                                        nodeAccess$pop = null;
                                                    }
                                                    mutableVector.add(node2);
                                                }
                                            }
                                        }
                                        if (i == 1) {
                                        }
                                    }
                                    nodeAccess$pop = HitTestResultKt.access$pop(mutableVector);
                                }
                            }
                            node = node.parent;
                        }
                    }
                    layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
                    node = (layoutNodeRequireLayoutNode == null || (nodeChain = layoutNodeRequireLayoutNode.nodes) == null) ? null : (TailModifierNode) nodeChain.tail;
                }
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: clearFocus-I7lrPNg, reason: not valid java name */
    public final boolean m343clearFocusI7lrPNg(int i, boolean z, boolean z2) {
        int iOrdinal;
        boolean z3 = true;
        if (z || (iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(FocusTraversalKt.m358performCustomClearFocusMxy_nc0(this.rootFocusNode))) == 0) {
            clearFocus(z);
        } else {
            if (iOrdinal != 1 && iOrdinal != 2 && iOrdinal != 3) {
                throw new HttpException();
            }
            z3 = false;
        }
        if (z3 && z2) {
            clearOwnerFocus();
        }
        return z3;
    }

    public final void clearOwnerFocus() {
        AndroidComposeView androidComposeView = this.platformFocusOwner;
        if (androidComposeView.isFocused() || androidComposeView.hasFocus()) {
            androidComposeView.clearFocus();
        } else if (androidComposeView.hasFocus()) {
            View viewFindFocus = androidComposeView.findFocus();
            if (viewFindFocus != null) {
                viewFindFocus.clearFocus();
            }
            androidComposeView.clearFocus();
        }
    }

    /* JADX WARN: Code duplicated, block: B:118:0x015e A[Catch: all -> 0x0019, TryCatch #0 {all -> 0x0019, blocks: (B:3:0x0007, B:5:0x000e, B:10:0x001c, B:14:0x0026, B:17:0x0032, B:19:0x0038, B:20:0x003d, B:22:0x0045, B:24:0x004a, B:26:0x0050, B:30:0x0056, B:128:0x0176, B:130:0x017c, B:131:0x017f, B:133:0x018a, B:136:0x0198, B:140:0x01a2, B:143:0x01a8, B:144:0x01ad, B:147:0x01b5, B:149:0x01bb, B:151:0x01bf, B:153:0x01c7, B:155:0x01cd, B:157:0x01d1, B:159:0x01d7, B:161:0x01e0, B:162:0x01e4, B:163:0x01e7, B:166:0x01ed, B:167:0x01f2, B:168:0x01f5, B:170:0x01fb, B:172:0x01ff, B:175:0x0208, B:177:0x0210, B:184:0x0227, B:185:0x0229, B:187:0x022e, B:189:0x0232, B:212:0x0276, B:193:0x023e, B:195:0x0244, B:197:0x0248, B:199:0x0250, B:201:0x0256, B:203:0x025a, B:205:0x0260, B:207:0x0269, B:208:0x026d, B:209:0x0270, B:213:0x027b, B:217:0x028b, B:219:0x0290, B:221:0x0294, B:244:0x02d8, B:225:0x02a0, B:227:0x02a6, B:229:0x02aa, B:231:0x02b2, B:233:0x02b8, B:235:0x02bc, B:237:0x02c2, B:239:0x02cb, B:240:0x02cf, B:241:0x02d2, B:246:0x02df, B:248:0x02e6, B:253:0x02f9, B:254:0x02fb, B:34:0x005e, B:36:0x0064, B:37:0x0067, B:39:0x006f, B:42:0x007d, B:46:0x0087, B:77:0x00de, B:79:0x00e2, B:49:0x008c, B:51:0x0092, B:53:0x0096, B:55:0x009e, B:57:0x00a4, B:59:0x00a8, B:61:0x00ae, B:63:0x00b7, B:64:0x00bb, B:65:0x00be, B:68:0x00c4, B:69:0x00c9, B:70:0x00cc, B:72:0x00d2, B:74:0x00d6, B:80:0x00e8, B:82:0x00ee, B:83:0x00f1, B:85:0x00fb, B:88:0x0109, B:92:0x0113, B:123:0x016a, B:125:0x016e, B:95:0x0118, B:97:0x011e, B:99:0x0122, B:101:0x012a, B:103:0x0130, B:105:0x0134, B:107:0x013a, B:109:0x0143, B:110:0x0147, B:111:0x014a, B:114:0x0150, B:115:0x0155, B:116:0x0158, B:118:0x015e, B:120:0x0162), top: B:259:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:125:0x016e A[Catch: all -> 0x0019, TryCatch #0 {all -> 0x0019, blocks: (B:3:0x0007, B:5:0x000e, B:10:0x001c, B:14:0x0026, B:17:0x0032, B:19:0x0038, B:20:0x003d, B:22:0x0045, B:24:0x004a, B:26:0x0050, B:30:0x0056, B:128:0x0176, B:130:0x017c, B:131:0x017f, B:133:0x018a, B:136:0x0198, B:140:0x01a2, B:143:0x01a8, B:144:0x01ad, B:147:0x01b5, B:149:0x01bb, B:151:0x01bf, B:153:0x01c7, B:155:0x01cd, B:157:0x01d1, B:159:0x01d7, B:161:0x01e0, B:162:0x01e4, B:163:0x01e7, B:166:0x01ed, B:167:0x01f2, B:168:0x01f5, B:170:0x01fb, B:172:0x01ff, B:175:0x0208, B:177:0x0210, B:184:0x0227, B:185:0x0229, B:187:0x022e, B:189:0x0232, B:212:0x0276, B:193:0x023e, B:195:0x0244, B:197:0x0248, B:199:0x0250, B:201:0x0256, B:203:0x025a, B:205:0x0260, B:207:0x0269, B:208:0x026d, B:209:0x0270, B:213:0x027b, B:217:0x028b, B:219:0x0290, B:221:0x0294, B:244:0x02d8, B:225:0x02a0, B:227:0x02a6, B:229:0x02aa, B:231:0x02b2, B:233:0x02b8, B:235:0x02bc, B:237:0x02c2, B:239:0x02cb, B:240:0x02cf, B:241:0x02d2, B:246:0x02df, B:248:0x02e6, B:253:0x02f9, B:254:0x02fb, B:34:0x005e, B:36:0x0064, B:37:0x0067, B:39:0x006f, B:42:0x007d, B:46:0x0087, B:77:0x00de, B:79:0x00e2, B:49:0x008c, B:51:0x0092, B:53:0x0096, B:55:0x009e, B:57:0x00a4, B:59:0x00a8, B:61:0x00ae, B:63:0x00b7, B:64:0x00bb, B:65:0x00be, B:68:0x00c4, B:69:0x00c9, B:70:0x00cc, B:72:0x00d2, B:74:0x00d6, B:80:0x00e8, B:82:0x00ee, B:83:0x00f1, B:85:0x00fb, B:88:0x0109, B:92:0x0113, B:123:0x016a, B:125:0x016e, B:95:0x0118, B:97:0x011e, B:99:0x0122, B:101:0x012a, B:103:0x0130, B:105:0x0134, B:107:0x013a, B:109:0x0143, B:110:0x0147, B:111:0x014a, B:114:0x0150, B:115:0x0155, B:116:0x0158, B:118:0x015e, B:120:0x0162), top: B:259:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:126:0x0173  */
    /* JADX WARN: Code duplicated, block: B:320:0x00dd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:321:0x008b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:327:0x00c9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x005c  */
    /* JADX WARN: Code duplicated, block: B:340:0x0169 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:341:0x0117 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:342:0x0167 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:349:0x0155 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x005e A[Catch: all -> 0x0019, TryCatch #0 {all -> 0x0019, blocks: (B:3:0x0007, B:5:0x000e, B:10:0x001c, B:14:0x0026, B:17:0x0032, B:19:0x0038, B:20:0x003d, B:22:0x0045, B:24:0x004a, B:26:0x0050, B:30:0x0056, B:128:0x0176, B:130:0x017c, B:131:0x017f, B:133:0x018a, B:136:0x0198, B:140:0x01a2, B:143:0x01a8, B:144:0x01ad, B:147:0x01b5, B:149:0x01bb, B:151:0x01bf, B:153:0x01c7, B:155:0x01cd, B:157:0x01d1, B:159:0x01d7, B:161:0x01e0, B:162:0x01e4, B:163:0x01e7, B:166:0x01ed, B:167:0x01f2, B:168:0x01f5, B:170:0x01fb, B:172:0x01ff, B:175:0x0208, B:177:0x0210, B:184:0x0227, B:185:0x0229, B:187:0x022e, B:189:0x0232, B:212:0x0276, B:193:0x023e, B:195:0x0244, B:197:0x0248, B:199:0x0250, B:201:0x0256, B:203:0x025a, B:205:0x0260, B:207:0x0269, B:208:0x026d, B:209:0x0270, B:213:0x027b, B:217:0x028b, B:219:0x0290, B:221:0x0294, B:244:0x02d8, B:225:0x02a0, B:227:0x02a6, B:229:0x02aa, B:231:0x02b2, B:233:0x02b8, B:235:0x02bc, B:237:0x02c2, B:239:0x02cb, B:240:0x02cf, B:241:0x02d2, B:246:0x02df, B:248:0x02e6, B:253:0x02f9, B:254:0x02fb, B:34:0x005e, B:36:0x0064, B:37:0x0067, B:39:0x006f, B:42:0x007d, B:46:0x0087, B:77:0x00de, B:79:0x00e2, B:49:0x008c, B:51:0x0092, B:53:0x0096, B:55:0x009e, B:57:0x00a4, B:59:0x00a8, B:61:0x00ae, B:63:0x00b7, B:64:0x00bb, B:65:0x00be, B:68:0x00c4, B:69:0x00c9, B:70:0x00cc, B:72:0x00d2, B:74:0x00d6, B:80:0x00e8, B:82:0x00ee, B:83:0x00f1, B:85:0x00fb, B:88:0x0109, B:92:0x0113, B:123:0x016a, B:125:0x016e, B:95:0x0118, B:97:0x011e, B:99:0x0122, B:101:0x012a, B:103:0x0130, B:105:0x0134, B:107:0x013a, B:109:0x0143, B:110:0x0147, B:111:0x014a, B:114:0x0150, B:115:0x0155, B:116:0x0158, B:118:0x015e, B:120:0x0162), top: B:259:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:351:0x0150 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0064 A[Catch: all -> 0x0019, TryCatch #0 {all -> 0x0019, blocks: (B:3:0x0007, B:5:0x000e, B:10:0x001c, B:14:0x0026, B:17:0x0032, B:19:0x0038, B:20:0x003d, B:22:0x0045, B:24:0x004a, B:26:0x0050, B:30:0x0056, B:128:0x0176, B:130:0x017c, B:131:0x017f, B:133:0x018a, B:136:0x0198, B:140:0x01a2, B:143:0x01a8, B:144:0x01ad, B:147:0x01b5, B:149:0x01bb, B:151:0x01bf, B:153:0x01c7, B:155:0x01cd, B:157:0x01d1, B:159:0x01d7, B:161:0x01e0, B:162:0x01e4, B:163:0x01e7, B:166:0x01ed, B:167:0x01f2, B:168:0x01f5, B:170:0x01fb, B:172:0x01ff, B:175:0x0208, B:177:0x0210, B:184:0x0227, B:185:0x0229, B:187:0x022e, B:189:0x0232, B:212:0x0276, B:193:0x023e, B:195:0x0244, B:197:0x0248, B:199:0x0250, B:201:0x0256, B:203:0x025a, B:205:0x0260, B:207:0x0269, B:208:0x026d, B:209:0x0270, B:213:0x027b, B:217:0x028b, B:219:0x0290, B:221:0x0294, B:244:0x02d8, B:225:0x02a0, B:227:0x02a6, B:229:0x02aa, B:231:0x02b2, B:233:0x02b8, B:235:0x02bc, B:237:0x02c2, B:239:0x02cb, B:240:0x02cf, B:241:0x02d2, B:246:0x02df, B:248:0x02e6, B:253:0x02f9, B:254:0x02fb, B:34:0x005e, B:36:0x0064, B:37:0x0067, B:39:0x006f, B:42:0x007d, B:46:0x0087, B:77:0x00de, B:79:0x00e2, B:49:0x008c, B:51:0x0092, B:53:0x0096, B:55:0x009e, B:57:0x00a4, B:59:0x00a8, B:61:0x00ae, B:63:0x00b7, B:64:0x00bb, B:65:0x00be, B:68:0x00c4, B:69:0x00c9, B:70:0x00cc, B:72:0x00d2, B:74:0x00d6, B:80:0x00e8, B:82:0x00ee, B:83:0x00f1, B:85:0x00fb, B:88:0x0109, B:92:0x0113, B:123:0x016a, B:125:0x016e, B:95:0x0118, B:97:0x011e, B:99:0x0122, B:101:0x012a, B:103:0x0130, B:105:0x0134, B:107:0x013a, B:109:0x0143, B:110:0x0147, B:111:0x014a, B:114:0x0150, B:115:0x0155, B:116:0x0158, B:118:0x015e, B:120:0x0162), top: B:259:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x006f A[Catch: all -> 0x0019, TryCatch #0 {all -> 0x0019, blocks: (B:3:0x0007, B:5:0x000e, B:10:0x001c, B:14:0x0026, B:17:0x0032, B:19:0x0038, B:20:0x003d, B:22:0x0045, B:24:0x004a, B:26:0x0050, B:30:0x0056, B:128:0x0176, B:130:0x017c, B:131:0x017f, B:133:0x018a, B:136:0x0198, B:140:0x01a2, B:143:0x01a8, B:144:0x01ad, B:147:0x01b5, B:149:0x01bb, B:151:0x01bf, B:153:0x01c7, B:155:0x01cd, B:157:0x01d1, B:159:0x01d7, B:161:0x01e0, B:162:0x01e4, B:163:0x01e7, B:166:0x01ed, B:167:0x01f2, B:168:0x01f5, B:170:0x01fb, B:172:0x01ff, B:175:0x0208, B:177:0x0210, B:184:0x0227, B:185:0x0229, B:187:0x022e, B:189:0x0232, B:212:0x0276, B:193:0x023e, B:195:0x0244, B:197:0x0248, B:199:0x0250, B:201:0x0256, B:203:0x025a, B:205:0x0260, B:207:0x0269, B:208:0x026d, B:209:0x0270, B:213:0x027b, B:217:0x028b, B:219:0x0290, B:221:0x0294, B:244:0x02d8, B:225:0x02a0, B:227:0x02a6, B:229:0x02aa, B:231:0x02b2, B:233:0x02b8, B:235:0x02bc, B:237:0x02c2, B:239:0x02cb, B:240:0x02cf, B:241:0x02d2, B:246:0x02df, B:248:0x02e6, B:253:0x02f9, B:254:0x02fb, B:34:0x005e, B:36:0x0064, B:37:0x0067, B:39:0x006f, B:42:0x007d, B:46:0x0087, B:77:0x00de, B:79:0x00e2, B:49:0x008c, B:51:0x0092, B:53:0x0096, B:55:0x009e, B:57:0x00a4, B:59:0x00a8, B:61:0x00ae, B:63:0x00b7, B:64:0x00bb, B:65:0x00be, B:68:0x00c4, B:69:0x00c9, B:70:0x00cc, B:72:0x00d2, B:74:0x00d6, B:80:0x00e8, B:82:0x00ee, B:83:0x00f1, B:85:0x00fb, B:88:0x0109, B:92:0x0113, B:123:0x016a, B:125:0x016e, B:95:0x0118, B:97:0x011e, B:99:0x0122, B:101:0x012a, B:103:0x0130, B:105:0x0134, B:107:0x013a, B:109:0x0143, B:110:0x0147, B:111:0x014a, B:114:0x0150, B:115:0x0155, B:116:0x0158, B:118:0x015e, B:120:0x0162), top: B:259:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x007b A[ADDED_TO_REGION, LOOP:12: B:41:0x007b->B:69:0x00c9, LOOP_START, PHI: r7
      0x007b: PHI (r7v30 androidx.compose.ui.Modifier$Node) = (r7v24 androidx.compose.ui.Modifier$Node), (r7v31 androidx.compose.ui.Modifier$Node) binds: [B:40:0x0079, B:69:0x00c9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:42:0x007d A[Catch: all -> 0x0019, TryCatch #0 {all -> 0x0019, blocks: (B:3:0x0007, B:5:0x000e, B:10:0x001c, B:14:0x0026, B:17:0x0032, B:19:0x0038, B:20:0x003d, B:22:0x0045, B:24:0x004a, B:26:0x0050, B:30:0x0056, B:128:0x0176, B:130:0x017c, B:131:0x017f, B:133:0x018a, B:136:0x0198, B:140:0x01a2, B:143:0x01a8, B:144:0x01ad, B:147:0x01b5, B:149:0x01bb, B:151:0x01bf, B:153:0x01c7, B:155:0x01cd, B:157:0x01d1, B:159:0x01d7, B:161:0x01e0, B:162:0x01e4, B:163:0x01e7, B:166:0x01ed, B:167:0x01f2, B:168:0x01f5, B:170:0x01fb, B:172:0x01ff, B:175:0x0208, B:177:0x0210, B:184:0x0227, B:185:0x0229, B:187:0x022e, B:189:0x0232, B:212:0x0276, B:193:0x023e, B:195:0x0244, B:197:0x0248, B:199:0x0250, B:201:0x0256, B:203:0x025a, B:205:0x0260, B:207:0x0269, B:208:0x026d, B:209:0x0270, B:213:0x027b, B:217:0x028b, B:219:0x0290, B:221:0x0294, B:244:0x02d8, B:225:0x02a0, B:227:0x02a6, B:229:0x02aa, B:231:0x02b2, B:233:0x02b8, B:235:0x02bc, B:237:0x02c2, B:239:0x02cb, B:240:0x02cf, B:241:0x02d2, B:246:0x02df, B:248:0x02e6, B:253:0x02f9, B:254:0x02fb, B:34:0x005e, B:36:0x0064, B:37:0x0067, B:39:0x006f, B:42:0x007d, B:46:0x0087, B:77:0x00de, B:79:0x00e2, B:49:0x008c, B:51:0x0092, B:53:0x0096, B:55:0x009e, B:57:0x00a4, B:59:0x00a8, B:61:0x00ae, B:63:0x00b7, B:64:0x00bb, B:65:0x00be, B:68:0x00c4, B:69:0x00c9, B:70:0x00cc, B:72:0x00d2, B:74:0x00d6, B:80:0x00e8, B:82:0x00ee, B:83:0x00f1, B:85:0x00fb, B:88:0x0109, B:92:0x0113, B:123:0x016a, B:125:0x016e, B:95:0x0118, B:97:0x011e, B:99:0x0122, B:101:0x012a, B:103:0x0130, B:105:0x0134, B:107:0x013a, B:109:0x0143, B:110:0x0147, B:111:0x014a, B:114:0x0150, B:115:0x0155, B:116:0x0158, B:118:0x015e, B:120:0x0162), top: B:259:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x0083  */
    /* JADX WARN: Code duplicated, block: B:46:0x0087 A[Catch: all -> 0x0019, TryCatch #0 {all -> 0x0019, blocks: (B:3:0x0007, B:5:0x000e, B:10:0x001c, B:14:0x0026, B:17:0x0032, B:19:0x0038, B:20:0x003d, B:22:0x0045, B:24:0x004a, B:26:0x0050, B:30:0x0056, B:128:0x0176, B:130:0x017c, B:131:0x017f, B:133:0x018a, B:136:0x0198, B:140:0x01a2, B:143:0x01a8, B:144:0x01ad, B:147:0x01b5, B:149:0x01bb, B:151:0x01bf, B:153:0x01c7, B:155:0x01cd, B:157:0x01d1, B:159:0x01d7, B:161:0x01e0, B:162:0x01e4, B:163:0x01e7, B:166:0x01ed, B:167:0x01f2, B:168:0x01f5, B:170:0x01fb, B:172:0x01ff, B:175:0x0208, B:177:0x0210, B:184:0x0227, B:185:0x0229, B:187:0x022e, B:189:0x0232, B:212:0x0276, B:193:0x023e, B:195:0x0244, B:197:0x0248, B:199:0x0250, B:201:0x0256, B:203:0x025a, B:205:0x0260, B:207:0x0269, B:208:0x026d, B:209:0x0270, B:213:0x027b, B:217:0x028b, B:219:0x0290, B:221:0x0294, B:244:0x02d8, B:225:0x02a0, B:227:0x02a6, B:229:0x02aa, B:231:0x02b2, B:233:0x02b8, B:235:0x02bc, B:237:0x02c2, B:239:0x02cb, B:240:0x02cf, B:241:0x02d2, B:246:0x02df, B:248:0x02e6, B:253:0x02f9, B:254:0x02fb, B:34:0x005e, B:36:0x0064, B:37:0x0067, B:39:0x006f, B:42:0x007d, B:46:0x0087, B:77:0x00de, B:79:0x00e2, B:49:0x008c, B:51:0x0092, B:53:0x0096, B:55:0x009e, B:57:0x00a4, B:59:0x00a8, B:61:0x00ae, B:63:0x00b7, B:64:0x00bb, B:65:0x00be, B:68:0x00c4, B:69:0x00c9, B:70:0x00cc, B:72:0x00d2, B:74:0x00d6, B:80:0x00e8, B:82:0x00ee, B:83:0x00f1, B:85:0x00fb, B:88:0x0109, B:92:0x0113, B:123:0x016a, B:125:0x016e, B:95:0x0118, B:97:0x011e, B:99:0x0122, B:101:0x012a, B:103:0x0130, B:105:0x0134, B:107:0x013a, B:109:0x0143, B:110:0x0147, B:111:0x014a, B:114:0x0150, B:115:0x0155, B:116:0x0158, B:118:0x015e, B:120:0x0162), top: B:259:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x008c A[Catch: all -> 0x0019, TryCatch #0 {all -> 0x0019, blocks: (B:3:0x0007, B:5:0x000e, B:10:0x001c, B:14:0x0026, B:17:0x0032, B:19:0x0038, B:20:0x003d, B:22:0x0045, B:24:0x004a, B:26:0x0050, B:30:0x0056, B:128:0x0176, B:130:0x017c, B:131:0x017f, B:133:0x018a, B:136:0x0198, B:140:0x01a2, B:143:0x01a8, B:144:0x01ad, B:147:0x01b5, B:149:0x01bb, B:151:0x01bf, B:153:0x01c7, B:155:0x01cd, B:157:0x01d1, B:159:0x01d7, B:161:0x01e0, B:162:0x01e4, B:163:0x01e7, B:166:0x01ed, B:167:0x01f2, B:168:0x01f5, B:170:0x01fb, B:172:0x01ff, B:175:0x0208, B:177:0x0210, B:184:0x0227, B:185:0x0229, B:187:0x022e, B:189:0x0232, B:212:0x0276, B:193:0x023e, B:195:0x0244, B:197:0x0248, B:199:0x0250, B:201:0x0256, B:203:0x025a, B:205:0x0260, B:207:0x0269, B:208:0x026d, B:209:0x0270, B:213:0x027b, B:217:0x028b, B:219:0x0290, B:221:0x0294, B:244:0x02d8, B:225:0x02a0, B:227:0x02a6, B:229:0x02aa, B:231:0x02b2, B:233:0x02b8, B:235:0x02bc, B:237:0x02c2, B:239:0x02cb, B:240:0x02cf, B:241:0x02d2, B:246:0x02df, B:248:0x02e6, B:253:0x02f9, B:254:0x02fb, B:34:0x005e, B:36:0x0064, B:37:0x0067, B:39:0x006f, B:42:0x007d, B:46:0x0087, B:77:0x00de, B:79:0x00e2, B:49:0x008c, B:51:0x0092, B:53:0x0096, B:55:0x009e, B:57:0x00a4, B:59:0x00a8, B:61:0x00ae, B:63:0x00b7, B:64:0x00bb, B:65:0x00be, B:68:0x00c4, B:69:0x00c9, B:70:0x00cc, B:72:0x00d2, B:74:0x00d6, B:80:0x00e8, B:82:0x00ee, B:83:0x00f1, B:85:0x00fb, B:88:0x0109, B:92:0x0113, B:123:0x016a, B:125:0x016e, B:95:0x0118, B:97:0x011e, B:99:0x0122, B:101:0x012a, B:103:0x0130, B:105:0x0134, B:107:0x013a, B:109:0x0143, B:110:0x0147, B:111:0x014a, B:114:0x0150, B:115:0x0155, B:116:0x0158, B:118:0x015e, B:120:0x0162), top: B:259:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x00e2 A[Catch: all -> 0x0019, TryCatch #0 {all -> 0x0019, blocks: (B:3:0x0007, B:5:0x000e, B:10:0x001c, B:14:0x0026, B:17:0x0032, B:19:0x0038, B:20:0x003d, B:22:0x0045, B:24:0x004a, B:26:0x0050, B:30:0x0056, B:128:0x0176, B:130:0x017c, B:131:0x017f, B:133:0x018a, B:136:0x0198, B:140:0x01a2, B:143:0x01a8, B:144:0x01ad, B:147:0x01b5, B:149:0x01bb, B:151:0x01bf, B:153:0x01c7, B:155:0x01cd, B:157:0x01d1, B:159:0x01d7, B:161:0x01e0, B:162:0x01e4, B:163:0x01e7, B:166:0x01ed, B:167:0x01f2, B:168:0x01f5, B:170:0x01fb, B:172:0x01ff, B:175:0x0208, B:177:0x0210, B:184:0x0227, B:185:0x0229, B:187:0x022e, B:189:0x0232, B:212:0x0276, B:193:0x023e, B:195:0x0244, B:197:0x0248, B:199:0x0250, B:201:0x0256, B:203:0x025a, B:205:0x0260, B:207:0x0269, B:208:0x026d, B:209:0x0270, B:213:0x027b, B:217:0x028b, B:219:0x0290, B:221:0x0294, B:244:0x02d8, B:225:0x02a0, B:227:0x02a6, B:229:0x02aa, B:231:0x02b2, B:233:0x02b8, B:235:0x02bc, B:237:0x02c2, B:239:0x02cb, B:240:0x02cf, B:241:0x02d2, B:246:0x02df, B:248:0x02e6, B:253:0x02f9, B:254:0x02fb, B:34:0x005e, B:36:0x0064, B:37:0x0067, B:39:0x006f, B:42:0x007d, B:46:0x0087, B:77:0x00de, B:79:0x00e2, B:49:0x008c, B:51:0x0092, B:53:0x0096, B:55:0x009e, B:57:0x00a4, B:59:0x00a8, B:61:0x00ae, B:63:0x00b7, B:64:0x00bb, B:65:0x00be, B:68:0x00c4, B:69:0x00c9, B:70:0x00cc, B:72:0x00d2, B:74:0x00d6, B:80:0x00e8, B:82:0x00ee, B:83:0x00f1, B:85:0x00fb, B:88:0x0109, B:92:0x0113, B:123:0x016a, B:125:0x016e, B:95:0x0118, B:97:0x011e, B:99:0x0122, B:101:0x012a, B:103:0x0130, B:105:0x0134, B:107:0x013a, B:109:0x0143, B:110:0x0147, B:111:0x014a, B:114:0x0150, B:115:0x0155, B:116:0x0158, B:118:0x015e, B:120:0x0162), top: B:259:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x00e8 A[Catch: all -> 0x0019, TryCatch #0 {all -> 0x0019, blocks: (B:3:0x0007, B:5:0x000e, B:10:0x001c, B:14:0x0026, B:17:0x0032, B:19:0x0038, B:20:0x003d, B:22:0x0045, B:24:0x004a, B:26:0x0050, B:30:0x0056, B:128:0x0176, B:130:0x017c, B:131:0x017f, B:133:0x018a, B:136:0x0198, B:140:0x01a2, B:143:0x01a8, B:144:0x01ad, B:147:0x01b5, B:149:0x01bb, B:151:0x01bf, B:153:0x01c7, B:155:0x01cd, B:157:0x01d1, B:159:0x01d7, B:161:0x01e0, B:162:0x01e4, B:163:0x01e7, B:166:0x01ed, B:167:0x01f2, B:168:0x01f5, B:170:0x01fb, B:172:0x01ff, B:175:0x0208, B:177:0x0210, B:184:0x0227, B:185:0x0229, B:187:0x022e, B:189:0x0232, B:212:0x0276, B:193:0x023e, B:195:0x0244, B:197:0x0248, B:199:0x0250, B:201:0x0256, B:203:0x025a, B:205:0x0260, B:207:0x0269, B:208:0x026d, B:209:0x0270, B:213:0x027b, B:217:0x028b, B:219:0x0290, B:221:0x0294, B:244:0x02d8, B:225:0x02a0, B:227:0x02a6, B:229:0x02aa, B:231:0x02b2, B:233:0x02b8, B:235:0x02bc, B:237:0x02c2, B:239:0x02cb, B:240:0x02cf, B:241:0x02d2, B:246:0x02df, B:248:0x02e6, B:253:0x02f9, B:254:0x02fb, B:34:0x005e, B:36:0x0064, B:37:0x0067, B:39:0x006f, B:42:0x007d, B:46:0x0087, B:77:0x00de, B:79:0x00e2, B:49:0x008c, B:51:0x0092, B:53:0x0096, B:55:0x009e, B:57:0x00a4, B:59:0x00a8, B:61:0x00ae, B:63:0x00b7, B:64:0x00bb, B:65:0x00be, B:68:0x00c4, B:69:0x00c9, B:70:0x00cc, B:72:0x00d2, B:74:0x00d6, B:80:0x00e8, B:82:0x00ee, B:83:0x00f1, B:85:0x00fb, B:88:0x0109, B:92:0x0113, B:123:0x016a, B:125:0x016e, B:95:0x0118, B:97:0x011e, B:99:0x0122, B:101:0x012a, B:103:0x0130, B:105:0x0134, B:107:0x013a, B:109:0x0143, B:110:0x0147, B:111:0x014a, B:114:0x0150, B:115:0x0155, B:116:0x0158, B:118:0x015e, B:120:0x0162), top: B:259:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x00ee A[Catch: all -> 0x0019, TryCatch #0 {all -> 0x0019, blocks: (B:3:0x0007, B:5:0x000e, B:10:0x001c, B:14:0x0026, B:17:0x0032, B:19:0x0038, B:20:0x003d, B:22:0x0045, B:24:0x004a, B:26:0x0050, B:30:0x0056, B:128:0x0176, B:130:0x017c, B:131:0x017f, B:133:0x018a, B:136:0x0198, B:140:0x01a2, B:143:0x01a8, B:144:0x01ad, B:147:0x01b5, B:149:0x01bb, B:151:0x01bf, B:153:0x01c7, B:155:0x01cd, B:157:0x01d1, B:159:0x01d7, B:161:0x01e0, B:162:0x01e4, B:163:0x01e7, B:166:0x01ed, B:167:0x01f2, B:168:0x01f5, B:170:0x01fb, B:172:0x01ff, B:175:0x0208, B:177:0x0210, B:184:0x0227, B:185:0x0229, B:187:0x022e, B:189:0x0232, B:212:0x0276, B:193:0x023e, B:195:0x0244, B:197:0x0248, B:199:0x0250, B:201:0x0256, B:203:0x025a, B:205:0x0260, B:207:0x0269, B:208:0x026d, B:209:0x0270, B:213:0x027b, B:217:0x028b, B:219:0x0290, B:221:0x0294, B:244:0x02d8, B:225:0x02a0, B:227:0x02a6, B:229:0x02aa, B:231:0x02b2, B:233:0x02b8, B:235:0x02bc, B:237:0x02c2, B:239:0x02cb, B:240:0x02cf, B:241:0x02d2, B:246:0x02df, B:248:0x02e6, B:253:0x02f9, B:254:0x02fb, B:34:0x005e, B:36:0x0064, B:37:0x0067, B:39:0x006f, B:42:0x007d, B:46:0x0087, B:77:0x00de, B:79:0x00e2, B:49:0x008c, B:51:0x0092, B:53:0x0096, B:55:0x009e, B:57:0x00a4, B:59:0x00a8, B:61:0x00ae, B:63:0x00b7, B:64:0x00bb, B:65:0x00be, B:68:0x00c4, B:69:0x00c9, B:70:0x00cc, B:72:0x00d2, B:74:0x00d6, B:80:0x00e8, B:82:0x00ee, B:83:0x00f1, B:85:0x00fb, B:88:0x0109, B:92:0x0113, B:123:0x016a, B:125:0x016e, B:95:0x0118, B:97:0x011e, B:99:0x0122, B:101:0x012a, B:103:0x0130, B:105:0x0134, B:107:0x013a, B:109:0x0143, B:110:0x0147, B:111:0x014a, B:114:0x0150, B:115:0x0155, B:116:0x0158, B:118:0x015e, B:120:0x0162), top: B:259:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x00fb A[Catch: all -> 0x0019, TryCatch #0 {all -> 0x0019, blocks: (B:3:0x0007, B:5:0x000e, B:10:0x001c, B:14:0x0026, B:17:0x0032, B:19:0x0038, B:20:0x003d, B:22:0x0045, B:24:0x004a, B:26:0x0050, B:30:0x0056, B:128:0x0176, B:130:0x017c, B:131:0x017f, B:133:0x018a, B:136:0x0198, B:140:0x01a2, B:143:0x01a8, B:144:0x01ad, B:147:0x01b5, B:149:0x01bb, B:151:0x01bf, B:153:0x01c7, B:155:0x01cd, B:157:0x01d1, B:159:0x01d7, B:161:0x01e0, B:162:0x01e4, B:163:0x01e7, B:166:0x01ed, B:167:0x01f2, B:168:0x01f5, B:170:0x01fb, B:172:0x01ff, B:175:0x0208, B:177:0x0210, B:184:0x0227, B:185:0x0229, B:187:0x022e, B:189:0x0232, B:212:0x0276, B:193:0x023e, B:195:0x0244, B:197:0x0248, B:199:0x0250, B:201:0x0256, B:203:0x025a, B:205:0x0260, B:207:0x0269, B:208:0x026d, B:209:0x0270, B:213:0x027b, B:217:0x028b, B:219:0x0290, B:221:0x0294, B:244:0x02d8, B:225:0x02a0, B:227:0x02a6, B:229:0x02aa, B:231:0x02b2, B:233:0x02b8, B:235:0x02bc, B:237:0x02c2, B:239:0x02cb, B:240:0x02cf, B:241:0x02d2, B:246:0x02df, B:248:0x02e6, B:253:0x02f9, B:254:0x02fb, B:34:0x005e, B:36:0x0064, B:37:0x0067, B:39:0x006f, B:42:0x007d, B:46:0x0087, B:77:0x00de, B:79:0x00e2, B:49:0x008c, B:51:0x0092, B:53:0x0096, B:55:0x009e, B:57:0x00a4, B:59:0x00a8, B:61:0x00ae, B:63:0x00b7, B:64:0x00bb, B:65:0x00be, B:68:0x00c4, B:69:0x00c9, B:70:0x00cc, B:72:0x00d2, B:74:0x00d6, B:80:0x00e8, B:82:0x00ee, B:83:0x00f1, B:85:0x00fb, B:88:0x0109, B:92:0x0113, B:123:0x016a, B:125:0x016e, B:95:0x0118, B:97:0x011e, B:99:0x0122, B:101:0x012a, B:103:0x0130, B:105:0x0134, B:107:0x013a, B:109:0x0143, B:110:0x0147, B:111:0x014a, B:114:0x0150, B:115:0x0155, B:116:0x0158, B:118:0x015e, B:120:0x0162), top: B:259:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x0107 A[ADDED_TO_REGION, LOOP:16: B:87:0x0107->B:115:0x0155, LOOP_START, PHI: r1
      0x0107: PHI (r1v15 androidx.compose.ui.Modifier$Node) = (r1v9 androidx.compose.ui.Modifier$Node), (r1v16 androidx.compose.ui.Modifier$Node) binds: [B:86:0x0105, B:115:0x0155] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:88:0x0109 A[Catch: all -> 0x0019, TryCatch #0 {all -> 0x0019, blocks: (B:3:0x0007, B:5:0x000e, B:10:0x001c, B:14:0x0026, B:17:0x0032, B:19:0x0038, B:20:0x003d, B:22:0x0045, B:24:0x004a, B:26:0x0050, B:30:0x0056, B:128:0x0176, B:130:0x017c, B:131:0x017f, B:133:0x018a, B:136:0x0198, B:140:0x01a2, B:143:0x01a8, B:144:0x01ad, B:147:0x01b5, B:149:0x01bb, B:151:0x01bf, B:153:0x01c7, B:155:0x01cd, B:157:0x01d1, B:159:0x01d7, B:161:0x01e0, B:162:0x01e4, B:163:0x01e7, B:166:0x01ed, B:167:0x01f2, B:168:0x01f5, B:170:0x01fb, B:172:0x01ff, B:175:0x0208, B:177:0x0210, B:184:0x0227, B:185:0x0229, B:187:0x022e, B:189:0x0232, B:212:0x0276, B:193:0x023e, B:195:0x0244, B:197:0x0248, B:199:0x0250, B:201:0x0256, B:203:0x025a, B:205:0x0260, B:207:0x0269, B:208:0x026d, B:209:0x0270, B:213:0x027b, B:217:0x028b, B:219:0x0290, B:221:0x0294, B:244:0x02d8, B:225:0x02a0, B:227:0x02a6, B:229:0x02aa, B:231:0x02b2, B:233:0x02b8, B:235:0x02bc, B:237:0x02c2, B:239:0x02cb, B:240:0x02cf, B:241:0x02d2, B:246:0x02df, B:248:0x02e6, B:253:0x02f9, B:254:0x02fb, B:34:0x005e, B:36:0x0064, B:37:0x0067, B:39:0x006f, B:42:0x007d, B:46:0x0087, B:77:0x00de, B:79:0x00e2, B:49:0x008c, B:51:0x0092, B:53:0x0096, B:55:0x009e, B:57:0x00a4, B:59:0x00a8, B:61:0x00ae, B:63:0x00b7, B:64:0x00bb, B:65:0x00be, B:68:0x00c4, B:69:0x00c9, B:70:0x00cc, B:72:0x00d2, B:74:0x00d6, B:80:0x00e8, B:82:0x00ee, B:83:0x00f1, B:85:0x00fb, B:88:0x0109, B:92:0x0113, B:123:0x016a, B:125:0x016e, B:95:0x0118, B:97:0x011e, B:99:0x0122, B:101:0x012a, B:103:0x0130, B:105:0x0134, B:107:0x013a, B:109:0x0143, B:110:0x0147, B:111:0x014a, B:114:0x0150, B:115:0x0155, B:116:0x0158, B:118:0x015e, B:120:0x0162), top: B:259:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x010f  */
    /* JADX WARN: Code duplicated, block: B:92:0x0113 A[Catch: all -> 0x0019, TryCatch #0 {all -> 0x0019, blocks: (B:3:0x0007, B:5:0x000e, B:10:0x001c, B:14:0x0026, B:17:0x0032, B:19:0x0038, B:20:0x003d, B:22:0x0045, B:24:0x004a, B:26:0x0050, B:30:0x0056, B:128:0x0176, B:130:0x017c, B:131:0x017f, B:133:0x018a, B:136:0x0198, B:140:0x01a2, B:143:0x01a8, B:144:0x01ad, B:147:0x01b5, B:149:0x01bb, B:151:0x01bf, B:153:0x01c7, B:155:0x01cd, B:157:0x01d1, B:159:0x01d7, B:161:0x01e0, B:162:0x01e4, B:163:0x01e7, B:166:0x01ed, B:167:0x01f2, B:168:0x01f5, B:170:0x01fb, B:172:0x01ff, B:175:0x0208, B:177:0x0210, B:184:0x0227, B:185:0x0229, B:187:0x022e, B:189:0x0232, B:212:0x0276, B:193:0x023e, B:195:0x0244, B:197:0x0248, B:199:0x0250, B:201:0x0256, B:203:0x025a, B:205:0x0260, B:207:0x0269, B:208:0x026d, B:209:0x0270, B:213:0x027b, B:217:0x028b, B:219:0x0290, B:221:0x0294, B:244:0x02d8, B:225:0x02a0, B:227:0x02a6, B:229:0x02aa, B:231:0x02b2, B:233:0x02b8, B:235:0x02bc, B:237:0x02c2, B:239:0x02cb, B:240:0x02cf, B:241:0x02d2, B:246:0x02df, B:248:0x02e6, B:253:0x02f9, B:254:0x02fb, B:34:0x005e, B:36:0x0064, B:37:0x0067, B:39:0x006f, B:42:0x007d, B:46:0x0087, B:77:0x00de, B:79:0x00e2, B:49:0x008c, B:51:0x0092, B:53:0x0096, B:55:0x009e, B:57:0x00a4, B:59:0x00a8, B:61:0x00ae, B:63:0x00b7, B:64:0x00bb, B:65:0x00be, B:68:0x00c4, B:69:0x00c9, B:70:0x00cc, B:72:0x00d2, B:74:0x00d6, B:80:0x00e8, B:82:0x00ee, B:83:0x00f1, B:85:0x00fb, B:88:0x0109, B:92:0x0113, B:123:0x016a, B:125:0x016e, B:95:0x0118, B:97:0x011e, B:99:0x0122, B:101:0x012a, B:103:0x0130, B:105:0x0134, B:107:0x013a, B:109:0x0143, B:110:0x0147, B:111:0x014a, B:114:0x0150, B:115:0x0155, B:116:0x0158, B:118:0x015e, B:120:0x0162), top: B:259:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x0118 A[Catch: all -> 0x0019, TryCatch #0 {all -> 0x0019, blocks: (B:3:0x0007, B:5:0x000e, B:10:0x001c, B:14:0x0026, B:17:0x0032, B:19:0x0038, B:20:0x003d, B:22:0x0045, B:24:0x004a, B:26:0x0050, B:30:0x0056, B:128:0x0176, B:130:0x017c, B:131:0x017f, B:133:0x018a, B:136:0x0198, B:140:0x01a2, B:143:0x01a8, B:144:0x01ad, B:147:0x01b5, B:149:0x01bb, B:151:0x01bf, B:153:0x01c7, B:155:0x01cd, B:157:0x01d1, B:159:0x01d7, B:161:0x01e0, B:162:0x01e4, B:163:0x01e7, B:166:0x01ed, B:167:0x01f2, B:168:0x01f5, B:170:0x01fb, B:172:0x01ff, B:175:0x0208, B:177:0x0210, B:184:0x0227, B:185:0x0229, B:187:0x022e, B:189:0x0232, B:212:0x0276, B:193:0x023e, B:195:0x0244, B:197:0x0248, B:199:0x0250, B:201:0x0256, B:203:0x025a, B:205:0x0260, B:207:0x0269, B:208:0x026d, B:209:0x0270, B:213:0x027b, B:217:0x028b, B:219:0x0290, B:221:0x0294, B:244:0x02d8, B:225:0x02a0, B:227:0x02a6, B:229:0x02aa, B:231:0x02b2, B:233:0x02b8, B:235:0x02bc, B:237:0x02c2, B:239:0x02cb, B:240:0x02cf, B:241:0x02d2, B:246:0x02df, B:248:0x02e6, B:253:0x02f9, B:254:0x02fb, B:34:0x005e, B:36:0x0064, B:37:0x0067, B:39:0x006f, B:42:0x007d, B:46:0x0087, B:77:0x00de, B:79:0x00e2, B:49:0x008c, B:51:0x0092, B:53:0x0096, B:55:0x009e, B:57:0x00a4, B:59:0x00a8, B:61:0x00ae, B:63:0x00b7, B:64:0x00bb, B:65:0x00be, B:68:0x00c4, B:69:0x00c9, B:70:0x00cc, B:72:0x00d2, B:74:0x00d6, B:80:0x00e8, B:82:0x00ee, B:83:0x00f1, B:85:0x00fb, B:88:0x0109, B:92:0x0113, B:123:0x016a, B:125:0x016e, B:95:0x0118, B:97:0x011e, B:99:0x0122, B:101:0x012a, B:103:0x0130, B:105:0x0134, B:107:0x013a, B:109:0x0143, B:110:0x0147, B:111:0x014a, B:114:0x0150, B:115:0x0155, B:116:0x0158, B:118:0x015e, B:120:0x0162), top: B:259:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:97:0x011e A[Catch: all -> 0x0019, TryCatch #0 {all -> 0x0019, blocks: (B:3:0x0007, B:5:0x000e, B:10:0x001c, B:14:0x0026, B:17:0x0032, B:19:0x0038, B:20:0x003d, B:22:0x0045, B:24:0x004a, B:26:0x0050, B:30:0x0056, B:128:0x0176, B:130:0x017c, B:131:0x017f, B:133:0x018a, B:136:0x0198, B:140:0x01a2, B:143:0x01a8, B:144:0x01ad, B:147:0x01b5, B:149:0x01bb, B:151:0x01bf, B:153:0x01c7, B:155:0x01cd, B:157:0x01d1, B:159:0x01d7, B:161:0x01e0, B:162:0x01e4, B:163:0x01e7, B:166:0x01ed, B:167:0x01f2, B:168:0x01f5, B:170:0x01fb, B:172:0x01ff, B:175:0x0208, B:177:0x0210, B:184:0x0227, B:185:0x0229, B:187:0x022e, B:189:0x0232, B:212:0x0276, B:193:0x023e, B:195:0x0244, B:197:0x0248, B:199:0x0250, B:201:0x0256, B:203:0x025a, B:205:0x0260, B:207:0x0269, B:208:0x026d, B:209:0x0270, B:213:0x027b, B:217:0x028b, B:219:0x0290, B:221:0x0294, B:244:0x02d8, B:225:0x02a0, B:227:0x02a6, B:229:0x02aa, B:231:0x02b2, B:233:0x02b8, B:235:0x02bc, B:237:0x02c2, B:239:0x02cb, B:240:0x02cf, B:241:0x02d2, B:246:0x02df, B:248:0x02e6, B:253:0x02f9, B:254:0x02fb, B:34:0x005e, B:36:0x0064, B:37:0x0067, B:39:0x006f, B:42:0x007d, B:46:0x0087, B:77:0x00de, B:79:0x00e2, B:49:0x008c, B:51:0x0092, B:53:0x0096, B:55:0x009e, B:57:0x00a4, B:59:0x00a8, B:61:0x00ae, B:63:0x00b7, B:64:0x00bb, B:65:0x00be, B:68:0x00c4, B:69:0x00c9, B:70:0x00cc, B:72:0x00d2, B:74:0x00d6, B:80:0x00e8, B:82:0x00ee, B:83:0x00f1, B:85:0x00fb, B:88:0x0109, B:92:0x0113, B:123:0x016a, B:125:0x016e, B:95:0x0118, B:97:0x011e, B:99:0x0122, B:101:0x012a, B:103:0x0130, B:105:0x0134, B:107:0x013a, B:109:0x0143, B:110:0x0147, B:111:0x014a, B:114:0x0150, B:115:0x0155, B:116:0x0158, B:118:0x015e, B:120:0x0162), top: B:259:0x0007 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v16, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r0v24, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v47 */
    /* JADX WARN: Type inference failed for: r0v48 */
    /* JADX WARN: Type inference failed for: r0v49 */
    /* JADX WARN: Type inference failed for: r0v50 */
    /* JADX WARN: Type inference failed for: r0v51 */
    /* JADX WARN: Type inference failed for: r0v52 */
    /* JADX WARN: Type inference failed for: r0v9, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r15v18 */
    /* JADX WARN: Type inference failed for: r15v19 */
    /* JADX WARN: Type inference failed for: r15v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r15v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r15v9, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v36, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v40, types: [androidx.compose.runtime.collection.MutableVector] */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* JADX WARN: Type inference failed for: r1v45 */
    /* JADX WARN: Type inference failed for: r1v46 */
    /* JADX WARN: Type inference failed for: r1v47 */
    /* JADX WARN: Type inference failed for: r7v40 */
    /* JADX INFO: renamed from: dispatchKeyEvent-YhN2O0w, reason: not valid java name */
    public final boolean m344dispatchKeyEventYhN2O0w(KeyEvent keyEvent, Function0 function0) {
        Modifier.Node node;
        LayoutNode layoutNodeRequireLayoutNode;
        Object obj;
        Object obj2;
        Modifier.Node node2;
        NodeChain nodeChain;
        Modifier.Node nodeAccess$pop;
        MutableVector mutableVector;
        Modifier.Node node3;
        LayoutNode layoutNodeRequireLayoutNode2;
        Object obj3;
        Object obj4;
        NodeChain nodeChain2;
        MutableVector mutableVector2;
        Modifier.Node nodeAccess$pop2;
        NodeChain nodeChain3;
        boolean z;
        FocusTargetNode focusTargetNode = this.rootFocusNode;
        Trace.beginSection("FocusOwnerImpl:dispatchKeyEvent");
        try {
            if (this.focusInvalidationManager.isInvalidationScheduled) {
                System.out.println((Object) "FocusRelatedWarning: Dispatching key event while focus system is invalidated.");
                Trace.endSection();
                return false;
            }
            if (!m348validateKeyEventZmokQxo(keyEvent)) {
                Trace.endSection();
                return false;
            }
            FocusTargetNode focusTargetNodeFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(focusTargetNode);
            if (focusTargetNodeFindActiveFocusNode != null) {
                if (!focusTargetNodeFindActiveFocusNode.node.isAttached) {
                    InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
                }
                Modifier.Node node4 = focusTargetNodeFindActiveFocusNode.node;
                if ((node4.aggregateChildKindSet & 9216) != 0) {
                    node2 = null;
                    for (Modifier.Node node5 = node4.child; node5 != null; node5 = node5.child) {
                        int i = node5.kindSet;
                        if ((i & 9216) != 0) {
                            if ((i & 1024) != 0) {
                                break;
                            }
                            node2 = node5;
                        }
                    }
                } else {
                    node2 = null;
                }
                if (node2 == null) {
                    if (focusTargetNodeFindActiveFocusNode == null) {
                        if (!focusTargetNode.node.isAttached) {
                            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                        }
                        node = focusTargetNode.node.parent;
                        layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(focusTargetNode);
                        loop15: while (true) {
                            if (layoutNodeRequireLayoutNode != null) {
                                obj = null;
                                break;
                            }
                            if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 8192) != 0) {
                                while (node != null) {
                                    if ((node.kindSet & 8192) != 0) {
                                        nodeAccess$pop = node;
                                        mutableVector = null;
                                        while (nodeAccess$pop != null) {
                                            if (nodeAccess$pop instanceof KeyInputModifierNode) {
                                                obj = nodeAccess$pop;
                                                break loop15;
                                            }
                                            if ((nodeAccess$pop.kindSet & 8192) == 0) {
                                            }
                                            nodeAccess$pop = HitTestResultKt.access$pop(mutableVector);
                                        }
                                    }
                                    node = node.parent;
                                }
                            }
                            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
                            if (layoutNodeRequireLayoutNode != null) {
                            }
                        }
                        obj2 = (KeyInputModifierNode) obj;
                        if (obj2 != null) {
                            node2 = ((Modifier.Node) obj2).node;
                        } else {
                            node2 = null;
                        }
                    } else {
                        if (!focusTargetNodeFindActiveFocusNode.node.isAttached) {
                            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                        }
                        node3 = focusTargetNodeFindActiveFocusNode.node;
                        layoutNodeRequireLayoutNode2 = HitTestResultKt.requireLayoutNode(focusTargetNodeFindActiveFocusNode);
                        loop11: while (true) {
                            if (layoutNodeRequireLayoutNode2 != null) {
                                obj3 = null;
                                break;
                            }
                            if ((((Modifier.Node) layoutNodeRequireLayoutNode2.nodes.head).aggregateChildKindSet & 8192) != 0) {
                                while (node3 != null) {
                                    if ((node3.kindSet & 8192) != 0) {
                                        mutableVector2 = null;
                                        nodeAccess$pop2 = node3;
                                        while (nodeAccess$pop2 != null) {
                                            if (nodeAccess$pop2 instanceof KeyInputModifierNode) {
                                                obj3 = nodeAccess$pop2;
                                                break loop11;
                                            }
                                            if ((nodeAccess$pop2.kindSet & 8192) == 0) {
                                            }
                                            nodeAccess$pop2 = HitTestResultKt.access$pop(mutableVector2);
                                        }
                                    }
                                    node3 = node3.parent;
                                }
                            }
                            layoutNodeRequireLayoutNode2 = layoutNodeRequireLayoutNode2.getParent$ui();
                            if (layoutNodeRequireLayoutNode2 != null) {
                            }
                        }
                        obj4 = (KeyInputModifierNode) obj3;
                        if (obj4 != null) {
                            node2 = ((Modifier.Node) obj4).node;
                        } else {
                            if (!focusTargetNode.node.isAttached) {
                                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                            }
                            node = focusTargetNode.node.parent;
                            layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(focusTargetNode);
                            loop15: while (true) {
                                if (layoutNodeRequireLayoutNode != null) {
                                    obj = null;
                                    break;
                                }
                                if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 8192) != 0) {
                                    while (node != null) {
                                        if ((node.kindSet & 8192) != 0) {
                                            nodeAccess$pop = node;
                                            mutableVector = null;
                                            while (nodeAccess$pop != null) {
                                                if (nodeAccess$pop instanceof KeyInputModifierNode) {
                                                    obj = nodeAccess$pop;
                                                    break loop15;
                                                }
                                                if ((nodeAccess$pop.kindSet & 8192) == 0) {
                                                }
                                                nodeAccess$pop = HitTestResultKt.access$pop(mutableVector);
                                            }
                                        }
                                        node = node.parent;
                                    }
                                }
                                layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
                                if (layoutNodeRequireLayoutNode != null) {
                                }
                            }
                            obj2 = (KeyInputModifierNode) obj;
                            if (obj2 != null) {
                                node2 = ((Modifier.Node) obj2).node;
                            } else {
                                node2 = null;
                            }
                        }
                    }
                }
            } else if (focusTargetNodeFindActiveFocusNode == null) {
                if (!focusTargetNode.node.isAttached) {
                    InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                }
                node = focusTargetNode.node.parent;
                layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(focusTargetNode);
                loop15: while (true) {
                    if (layoutNodeRequireLayoutNode != null) {
                        obj = null;
                        break;
                    }
                    if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 8192) != 0) {
                        while (node != null) {
                            if ((node.kindSet & 8192) != 0) {
                                nodeAccess$pop = node;
                                mutableVector = null;
                                while (nodeAccess$pop != null) {
                                    if (nodeAccess$pop instanceof KeyInputModifierNode) {
                                        obj = nodeAccess$pop;
                                        break loop15;
                                    }
                                    if ((nodeAccess$pop.kindSet & 8192) == 0 && (nodeAccess$pop instanceof DelegatingNode)) {
                                        Modifier.Node node6 = ((DelegatingNode) nodeAccess$pop).delegate;
                                        int i2 = 0;
                                        while (node6 != null) {
                                            if ((node6.kindSet & 8192) != 0) {
                                                i2++;
                                                if (i2 == 1) {
                                                    nodeAccess$pop = nodeAccess$pop;
                                                    mutableVector = mutableVector;
                                                    mutableVector = mutableVector;
                                                    Unit unit = Unit.INSTANCE;
                                                    nodeAccess$pop = node6;
                                                } else {
                                                    if (mutableVector == null) {
                                                        mutableVector = new MutableVector(new Modifier.Node[16]);
                                                    }
                                                    if (nodeAccess$pop != null) {
                                                        mutableVector.add(nodeAccess$pop);
                                                        nodeAccess$pop = null;
                                                    }
                                                    mutableVector.add(node6);
                                                }
                                            } else {
                                                nodeAccess$pop = nodeAccess$pop;
                                                mutableVector = mutableVector;
                                            }
                                            node6 = node6.child;
                                            nodeAccess$pop = nodeAccess$pop;
                                            mutableVector = mutableVector;
                                        }
                                        if (i2 == 1) {
                                            nodeAccess$pop = nodeAccess$pop;
                                            mutableVector = mutableVector;
                                        } else {
                                            nodeAccess$pop = nodeAccess$pop;
                                            mutableVector = mutableVector;
                                        }
                                    }
                                    nodeAccess$pop = HitTestResultKt.access$pop(mutableVector);
                                }
                            }
                            node = node.parent;
                        }
                    }
                    layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
                    node = (layoutNodeRequireLayoutNode != null || (nodeChain = layoutNodeRequireLayoutNode.nodes) == null) ? null : (TailModifierNode) nodeChain.tail;
                }
                obj2 = (KeyInputModifierNode) obj;
                if (obj2 != null) {
                    node2 = ((Modifier.Node) obj2).node;
                } else {
                    node2 = null;
                }
            } else {
                if (!focusTargetNodeFindActiveFocusNode.node.isAttached) {
                    InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                }
                node3 = focusTargetNodeFindActiveFocusNode.node;
                layoutNodeRequireLayoutNode2 = HitTestResultKt.requireLayoutNode(focusTargetNodeFindActiveFocusNode);
                loop11: while (true) {
                    if (layoutNodeRequireLayoutNode2 != null) {
                        obj3 = null;
                        break;
                    }
                    if ((((Modifier.Node) layoutNodeRequireLayoutNode2.nodes.head).aggregateChildKindSet & 8192) != 0) {
                        while (node3 != null) {
                            if ((node3.kindSet & 8192) != 0) {
                                mutableVector2 = null;
                                nodeAccess$pop2 = node3;
                                while (nodeAccess$pop2 != null) {
                                    if (nodeAccess$pop2 instanceof KeyInputModifierNode) {
                                        obj3 = nodeAccess$pop2;
                                        break loop11;
                                    }
                                    if ((nodeAccess$pop2.kindSet & 8192) == 0 && (nodeAccess$pop2 instanceof DelegatingNode)) {
                                        Modifier.Node node7 = ((DelegatingNode) nodeAccess$pop2).delegate;
                                        int i3 = 0;
                                        while (node7 != null) {
                                            if ((node7.kindSet & 8192) != 0) {
                                                i3++;
                                                if (i3 == 1) {
                                                    nodeAccess$pop2 = nodeAccess$pop2;
                                                    mutableVector2 = mutableVector2;
                                                    mutableVector2 = mutableVector2;
                                                    Unit unit2 = Unit.INSTANCE;
                                                    nodeAccess$pop2 = node7;
                                                } else {
                                                    if (mutableVector2 == null) {
                                                        mutableVector2 = new MutableVector(new Modifier.Node[16]);
                                                    }
                                                    if (nodeAccess$pop2 != null) {
                                                        mutableVector2.add(nodeAccess$pop2);
                                                        nodeAccess$pop2 = null;
                                                    }
                                                    mutableVector2.add(node7);
                                                }
                                            } else {
                                                nodeAccess$pop2 = nodeAccess$pop2;
                                                mutableVector2 = mutableVector2;
                                            }
                                            node7 = node7.child;
                                            nodeAccess$pop2 = nodeAccess$pop2;
                                            mutableVector2 = mutableVector2;
                                        }
                                        if (i3 == 1) {
                                            nodeAccess$pop2 = nodeAccess$pop2;
                                            mutableVector2 = mutableVector2;
                                        } else {
                                            nodeAccess$pop2 = nodeAccess$pop2;
                                            mutableVector2 = mutableVector2;
                                        }
                                    }
                                    nodeAccess$pop2 = HitTestResultKt.access$pop(mutableVector2);
                                }
                            }
                            node3 = node3.parent;
                        }
                    }
                    layoutNodeRequireLayoutNode2 = layoutNodeRequireLayoutNode2.getParent$ui();
                    node3 = (layoutNodeRequireLayoutNode2 != null || (nodeChain2 = layoutNodeRequireLayoutNode2.nodes) == null) ? null : (TailModifierNode) nodeChain2.tail;
                }
                obj4 = (KeyInputModifierNode) obj3;
                if (obj4 != null) {
                    node2 = ((Modifier.Node) obj4).node;
                } else {
                    if (!focusTargetNode.node.isAttached) {
                        InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                    }
                    node = focusTargetNode.node.parent;
                    layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(focusTargetNode);
                    loop15: while (true) {
                        if (layoutNodeRequireLayoutNode != null) {
                            obj = null;
                            break;
                        }
                        if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 8192) != 0) {
                            while (node != null) {
                                if ((node.kindSet & 8192) != 0) {
                                    nodeAccess$pop = node;
                                    mutableVector = null;
                                    while (nodeAccess$pop != null) {
                                        if (nodeAccess$pop instanceof KeyInputModifierNode) {
                                            obj = nodeAccess$pop;
                                            break loop15;
                                        }
                                        if ((nodeAccess$pop.kindSet & 8192) == 0) {
                                        }
                                        nodeAccess$pop = HitTestResultKt.access$pop(mutableVector);
                                    }
                                }
                                node = node.parent;
                            }
                        }
                        layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
                        if (layoutNodeRequireLayoutNode != null) {
                        }
                    }
                    obj2 = (KeyInputModifierNode) obj;
                    if (obj2 != null) {
                        node2 = ((Modifier.Node) obj2).node;
                    } else {
                        node2 = null;
                    }
                }
            }
            if (node2 != null) {
                if (!node2.node.isAttached) {
                    InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                }
                Modifier.Node node8 = node2.node.parent;
                LayoutNode layoutNodeRequireLayoutNode3 = HitTestResultKt.requireLayoutNode(node2);
                ArrayList arrayList = null;
                while (layoutNodeRequireLayoutNode3 != null) {
                    if ((((Modifier.Node) layoutNodeRequireLayoutNode3.nodes.head).aggregateChildKindSet & 8192) != 0) {
                        while (node8 != null) {
                            if ((node8.kindSet & 8192) != 0) {
                                Modifier.Node nodeAccess$pop3 = node8;
                                MutableVector mutableVector3 = null;
                                while (nodeAccess$pop3 != null) {
                                    if (nodeAccess$pop3 instanceof KeyInputModifierNode) {
                                        if (arrayList == null) {
                                            arrayList = new ArrayList();
                                        }
                                        arrayList.add(nodeAccess$pop3);
                                        z = false;
                                    } else {
                                        z = true;
                                    }
                                    if (z && (nodeAccess$pop3.kindSet & 8192) != 0 && (nodeAccess$pop3 instanceof DelegatingNode)) {
                                        int i4 = 0;
                                        for (Modifier.Node node9 = ((DelegatingNode) nodeAccess$pop3).delegate; node9 != null; node9 = node9.child) {
                                            if ((node9.kindSet & 8192) != 0) {
                                                i4++;
                                                if (i4 == 1) {
                                                    Unit unit3 = Unit.INSTANCE;
                                                    nodeAccess$pop3 = node9;
                                                } else {
                                                    if (mutableVector3 == null) {
                                                        mutableVector3 = new MutableVector(new Modifier.Node[16]);
                                                    }
                                                    if (nodeAccess$pop3 != null) {
                                                        mutableVector3.add(nodeAccess$pop3);
                                                        nodeAccess$pop3 = null;
                                                    }
                                                    mutableVector3.add(node9);
                                                }
                                            }
                                        }
                                        if (i4 == 1) {
                                        }
                                    }
                                    nodeAccess$pop3 = HitTestResultKt.access$pop(mutableVector3);
                                }
                            }
                            node8 = node8.parent;
                        }
                    }
                    layoutNodeRequireLayoutNode3 = layoutNodeRequireLayoutNode3.getParent$ui();
                    node8 = (layoutNodeRequireLayoutNode3 == null || (nodeChain3 = layoutNodeRequireLayoutNode3.nodes) == null) ? null : (TailModifierNode) nodeChain3.tail;
                }
                if (arrayList != null) {
                    int size = arrayList.size() - 1;
                    if (size >= 0) {
                        while (true) {
                            int i5 = size - 1;
                            if (((KeyInputModifierNode) arrayList.get(size)).mo37onPreKeyEventZmokQxo(keyEvent)) {
                                Trace.endSection();
                                return true;
                            }
                            if (i5 < 0) {
                                break;
                            }
                            size = i5;
                        }
                    }
                    Unit unit4 = Unit.INSTANCE;
                }
                ?? Access$pop = node2.node;
                ?? mutableVector4 = 0;
                while (Access$pop != 0) {
                    if (Access$pop instanceof KeyInputModifierNode) {
                        if (((KeyInputModifierNode) Access$pop).mo37onPreKeyEventZmokQxo(keyEvent)) {
                            Trace.endSection();
                            return true;
                        }
                    } else if ((Access$pop.kindSet & 8192) != 0 && (Access$pop instanceof DelegatingNode)) {
                        Modifier.Node node10 = ((DelegatingNode) Access$pop).delegate;
                        int i6 = 0;
                        while (node10 != null) {
                            if ((node10.kindSet & 8192) != 0) {
                                i6++;
                                if (i6 == 1) {
                                    Access$pop = Access$pop;
                                    mutableVector4 = mutableVector4;
                                    mutableVector4 = mutableVector4;
                                    Unit unit5 = Unit.INSTANCE;
                                    Access$pop = node10;
                                } else {
                                    if (mutableVector4 == 0) {
                                        mutableVector4 = new MutableVector(new Modifier.Node[16]);
                                    }
                                    if (Access$pop != 0) {
                                        mutableVector4.add(Access$pop);
                                        Access$pop = 0;
                                    }
                                    mutableVector4.add(node10);
                                }
                            } else {
                                Access$pop = Access$pop;
                                mutableVector4 = mutableVector4;
                            }
                            node10 = node10.child;
                            Access$pop = Access$pop;
                            mutableVector4 = mutableVector4;
                        }
                        if (i6 == 1) {
                            Access$pop = Access$pop;
                            mutableVector4 = mutableVector4;
                        } else {
                            Access$pop = Access$pop;
                            mutableVector4 = mutableVector4;
                        }
                    }
                    Access$pop = HitTestResultKt.access$pop(mutableVector4);
                }
                if (((Boolean) function0.invoke()).booleanValue()) {
                    Trace.endSection();
                    return true;
                }
                ?? Access$pop2 = node2.node;
                ?? mutableVector5 = 0;
                while (Access$pop2 != 0) {
                    if (Access$pop2 instanceof KeyInputModifierNode) {
                        if (((KeyInputModifierNode) Access$pop2).mo35onKeyEventZmokQxo(keyEvent)) {
                            Trace.endSection();
                            return true;
                        }
                    } else if ((Access$pop2.kindSet & 8192) != 0 && (Access$pop2 instanceof DelegatingNode)) {
                        Modifier.Node node11 = ((DelegatingNode) Access$pop2).delegate;
                        int i7 = 0;
                        while (node11 != null) {
                            if ((node11.kindSet & 8192) != 0) {
                                i7++;
                                if (i7 == 1) {
                                    mutableVector5 = mutableVector5;
                                    Access$pop2 = Access$pop2;
                                    mutableVector5 = mutableVector5;
                                    Unit unit6 = Unit.INSTANCE;
                                    Access$pop2 = node11;
                                } else {
                                    if (mutableVector5 == 0) {
                                        mutableVector5 = new MutableVector(new Modifier.Node[16]);
                                    }
                                    if (Access$pop2 != 0) {
                                        mutableVector5.add(Access$pop2);
                                        Access$pop2 = 0;
                                    }
                                    mutableVector5.add(node11);
                                }
                            } else {
                                mutableVector5 = mutableVector5;
                                Access$pop2 = Access$pop2;
                            }
                            node11 = node11.child;
                            mutableVector5 = mutableVector5;
                            Access$pop2 = Access$pop2;
                        }
                        if (i7 == 1) {
                            mutableVector5 = mutableVector5;
                            Access$pop2 = Access$pop2;
                        } else {
                            mutableVector5 = mutableVector5;
                            Access$pop2 = Access$pop2;
                        }
                    }
                    Access$pop2 = HitTestResultKt.access$pop(mutableVector5);
                }
                if (arrayList != null) {
                    int size2 = arrayList.size();
                    for (int i8 = 0; i8 < size2; i8++) {
                        if (((KeyInputModifierNode) arrayList.get(i8)).mo35onKeyEventZmokQxo(keyEvent)) {
                            Trace.endSection();
                            return true;
                        }
                    }
                    Unit unit7 = Unit.INSTANCE;
                }
                Unit unit8 = Unit.INSTANCE;
            }
            Trace.endSection();
            return false;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    /* JADX INFO: renamed from: focusSearch-ULY8qGw, reason: not valid java name */
    public final Boolean m345focusSearchULY8qGw(int i, Rect rect, Function1 function1) {
        boolean zBackwardFocusSearch;
        FocusTargetNode focusTargetNode;
        NodeChain nodeChain;
        FocusTargetNode focusTargetNode2 = this.rootFocusNode;
        FocusTargetNode focusTargetNodeFindActiveFocusNode = FocusTraversalKt.findActiveFocusNode(focusTargetNode2);
        int i2 = 4;
        AndroidComposeView androidComposeView = this.owner;
        boolean zBooleanValue = false;
        if (focusTargetNodeFindActiveFocusNode != null) {
            LayoutDirection layoutDirection = androidComposeView.getLayoutDirection();
            FocusPropertiesImpl focusPropertiesImplFetchFocusProperties$ui = focusTargetNodeFindActiveFocusNode.fetchFocusProperties$ui();
            FocusRequester focusRequester = focusPropertiesImplFetchFocusProperties$ui.start;
            FocusRequester focusRequester2 = focusPropertiesImplFetchFocusProperties$ui.end;
            if (i == 1) {
                focusRequester = focusPropertiesImplFetchFocusProperties$ui.next;
            } else if (i == 2) {
                focusRequester = focusPropertiesImplFetchFocusProperties$ui.previous;
            } else if (i == 5) {
                focusRequester = focusPropertiesImplFetchFocusProperties$ui.up;
            } else if (i == 6) {
                focusRequester = focusPropertiesImplFetchFocusProperties$ui.down;
            } else if (i == 3) {
                int iOrdinal = layoutDirection.ordinal();
                if (iOrdinal != 0) {
                    if (iOrdinal != 1) {
                        throw new HttpException();
                    }
                    focusRequester = focusRequester2;
                }
                if (focusRequester == FocusRequester.Default) {
                    focusRequester = null;
                }
                if (focusRequester == null) {
                    focusRequester = focusPropertiesImplFetchFocusProperties$ui.left;
                }
            } else if (i == 4) {
                int iOrdinal2 = layoutDirection.ordinal();
                if (iOrdinal2 == 0) {
                    focusRequester = focusRequester2;
                } else if (iOrdinal2 != 1) {
                    throw new HttpException();
                }
                if (focusRequester == FocusRequester.Default) {
                    focusRequester = null;
                }
                if (focusRequester == null) {
                    focusRequester = focusPropertiesImplFetchFocusProperties$ui.right;
                }
            } else {
                if (i != 7 && i != 8) {
                    throw new IllegalStateException("invalid FocusDirection");
                }
                FocusOwnerImpl focusOwnerImpl = (FocusOwnerImpl) ((AndroidComposeView) HitTestResultKt.requireOwner(focusTargetNodeFindActiveFocusNode)).getFocusOwner();
                FocusTargetNode activeFocusTargetNode = focusOwnerImpl.getActiveFocusTargetNode();
                if (i == 7) {
                    focusPropertiesImplFetchFocusProperties$ui.onEnter.getClass();
                    Unit unit = Unit.INSTANCE;
                } else {
                    focusPropertiesImplFetchFocusProperties$ui.onExit.getClass();
                    Unit unit2 = Unit.INSTANCE;
                }
                focusRequester = activeFocusTargetNode != focusOwnerImpl.getActiveFocusTargetNode() ? FocusRequester.Redirect : FocusRequester.Default;
            }
            FocusRequester focusRequester3 = FocusRequester.Cancel;
            if (!Intrinsics.areEqual(focusRequester, focusRequester3)) {
                if (Intrinsics.areEqual(focusRequester, FocusRequester.Redirect)) {
                    FocusTargetNode focusTargetNodeFindActiveFocusNode2 = FocusTraversalKt.findActiveFocusNode(focusTargetNode2);
                    if (focusTargetNodeFindActiveFocusNode2 != null) {
                        return (Boolean) function1.invoke(focusTargetNodeFindActiveFocusNode2);
                    }
                } else {
                    FocusRequester focusRequester4 = FocusRequester.Default;
                    if (!Intrinsics.areEqual(focusRequester, focusRequester4)) {
                        if (focusRequester == focusRequester4) {
                            throw new IllegalStateException("\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n");
                        }
                        if (focusRequester == focusRequester3) {
                            throw new IllegalStateException("\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n");
                        }
                        MutableVector mutableVector = focusRequester.focusRequesterNodes;
                        int i3 = mutableVector.size;
                        if (i3 == 0) {
                            System.out.println((Object) "FocusRelatedWarning: \n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n");
                        } else {
                            Object[] objArr = mutableVector.content;
                            boolean z = false;
                            for (int i4 = 0; i4 < i3; i4++) {
                                Modifier.Node node = (Modifier.Node) ((FocusRequesterModifierNode) objArr[i4]);
                                if (!node.node.isAttached) {
                                    InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
                                }
                                MutableVector mutableVector2 = new MutableVector(new Modifier.Node[16]);
                                Modifier.Node node2 = node.node;
                                Modifier.Node node3 = node2.child;
                                if (node3 == null) {
                                    HitTestResultKt.access$addLayoutNodeChildren(mutableVector2, node2);
                                } else {
                                    mutableVector2.add(node3);
                                }
                                while (true) {
                                    int i5 = mutableVector2.size;
                                    if (i5 == 0) {
                                        break;
                                    }
                                    Modifier.Node nodeAccess$pop = (Modifier.Node) mutableVector2.removeAt(i5 - 1);
                                    if ((nodeAccess$pop.aggregateChildKindSet & 1024) == 0) {
                                        HitTestResultKt.access$addLayoutNodeChildren(mutableVector2, nodeAccess$pop);
                                    } else {
                                        while (nodeAccess$pop != null) {
                                            if ((nodeAccess$pop.kindSet & 1024) != 0) {
                                                MutableVector mutableVector3 = null;
                                                while (nodeAccess$pop != null) {
                                                    if (nodeAccess$pop instanceof FocusTargetNode) {
                                                        if (((Boolean) function1.invoke((FocusTargetNode) nodeAccess$pop)).booleanValue()) {
                                                            z = true;
                                                            break;
                                                        }
                                                    } else if ((nodeAccess$pop.kindSet & 1024) != 0 && (nodeAccess$pop instanceof DelegatingNode)) {
                                                        int i6 = 0;
                                                        for (Modifier.Node node4 = ((DelegatingNode) nodeAccess$pop).delegate; node4 != null; node4 = node4.child) {
                                                            if ((node4.kindSet & 1024) != 0) {
                                                                i6++;
                                                                if (i6 == 1) {
                                                                    nodeAccess$pop = node4;
                                                                } else {
                                                                    if (mutableVector3 == null) {
                                                                        mutableVector3 = new MutableVector(new Modifier.Node[16]);
                                                                    }
                                                                    if (nodeAccess$pop != null) {
                                                                        mutableVector3.add(nodeAccess$pop);
                                                                        nodeAccess$pop = null;
                                                                    }
                                                                    mutableVector3.add(node4);
                                                                }
                                                            }
                                                        }
                                                        if (i6 == 1) {
                                                        }
                                                    }
                                                    nodeAccess$pop = HitTestResultKt.access$pop(mutableVector3);
                                                }
                                                break;
                                            }
                                            nodeAccess$pop = nodeAccess$pop.child;
                                        }
                                    }
                                }
                            }
                            zBooleanValue = z;
                        }
                        return Boolean.valueOf(zBooleanValue);
                    }
                }
            }
            return null;
        }
        focusTargetNodeFindActiveFocusNode = null;
        LayoutDirection layoutDirection2 = androidComposeView.getLayoutDirection();
        LayoutNodeDrawScope$record$1 layoutNodeDrawScope$record$1 = new LayoutNodeDrawScope$record$1(focusTargetNodeFindActiveFocusNode, this, function1);
        if (i == 1 || i == 2) {
            if (i == 1) {
                zBackwardFocusSearch = FocusTraversalKt.forwardFocusSearch(focusTargetNode2, layoutNodeDrawScope$record$1);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("This function should only be used for 1-D focus search");
                }
                zBackwardFocusSearch = FocusTraversalKt.backwardFocusSearch(focusTargetNode2, layoutNodeDrawScope$record$1);
            }
            return Boolean.valueOf(zBackwardFocusSearch);
        }
        if (i == 3 || i == 4 || i == 5 || i == 6) {
            return FocusTraversalKt.m364twoDimensionalFocusSearchsMXa3k8(i, focusTargetNode2, rect, layoutNodeDrawScope$record$1);
        }
        if (i == 7) {
            int iOrdinal3 = layoutDirection2.ordinal();
            if (iOrdinal3 != 0) {
                if (iOrdinal3 != 1) {
                    throw new HttpException();
                }
                i2 = 3;
            }
            FocusTargetNode focusTargetNodeFindActiveFocusNode3 = FocusTraversalKt.findActiveFocusNode(focusTargetNode2);
            if (focusTargetNodeFindActiveFocusNode3 != null) {
                return FocusTraversalKt.m364twoDimensionalFocusSearchsMXa3k8(i2, focusTargetNodeFindActiveFocusNode3, rect, layoutNodeDrawScope$record$1);
            }
            return null;
        }
        if (i != 8) {
            throw new IllegalStateException(("Focus search invoked with invalid FocusDirection " + ((Object) FocusDirection.m342toStringimpl(i))).toString());
        }
        FocusTargetNode focusTargetNodeFindActiveFocusNode4 = FocusTraversalKt.findActiveFocusNode(focusTargetNode2);
        if (focusTargetNodeFindActiveFocusNode4 == null) {
            focusTargetNode = null;
            break;
        }
        if (!focusTargetNodeFindActiveFocusNode4.node.isAttached) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node5 = focusTargetNodeFindActiveFocusNode4.node.parent;
        LayoutNode layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(focusTargetNodeFindActiveFocusNode4);
        loop5: while (true) {
            if (layoutNodeRequireLayoutNode == null) {
                focusTargetNode = null;
                break;
            }
            if ((((Modifier.Node) layoutNodeRequireLayoutNode.nodes.head).aggregateChildKindSet & 1024) != 0) {
                while (node5 != null) {
                    if ((node5.kindSet & 1024) != 0) {
                        Modifier.Node nodeAccess$pop2 = node5;
                        MutableVector mutableVector4 = null;
                        while (nodeAccess$pop2 != null) {
                            if (nodeAccess$pop2 instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode3 = (FocusTargetNode) nodeAccess$pop2;
                                if (focusTargetNode3.fetchFocusProperties$ui().canFocus) {
                                    focusTargetNode = focusTargetNode3;
                                    break loop5;
                                }
                            } else if ((nodeAccess$pop2.kindSet & 1024) != 0 && (nodeAccess$pop2 instanceof DelegatingNode)) {
                                int i7 = 0;
                                for (Modifier.Node node6 = ((DelegatingNode) nodeAccess$pop2).delegate; node6 != null; node6 = node6.child) {
                                    if ((node6.kindSet & 1024) != 0) {
                                        i7++;
                                        if (i7 == 1) {
                                            nodeAccess$pop2 = node6;
                                        } else {
                                            if (mutableVector4 == null) {
                                                mutableVector4 = new MutableVector(new Modifier.Node[16]);
                                            }
                                            if (nodeAccess$pop2 != null) {
                                                mutableVector4.add(nodeAccess$pop2);
                                                nodeAccess$pop2 = null;
                                            }
                                            mutableVector4.add(node6);
                                        }
                                    }
                                }
                                if (i7 != 1) {
                                    nodeAccess$pop2 = HitTestResultKt.access$pop(mutableVector4);
                                }
                            }
                            nodeAccess$pop2 = HitTestResultKt.access$pop(mutableVector4);
                        }
                    }
                    node5 = node5.parent;
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui();
            node5 = (layoutNodeRequireLayoutNode == null || (nodeChain = layoutNodeRequireLayoutNode.nodes) == null) ? null : (TailModifierNode) nodeChain.tail;
        }
        if (focusTargetNode != null && !focusTargetNode.equals(focusTargetNode2)) {
            zBooleanValue = ((Boolean) layoutNodeDrawScope$record$1.invoke(focusTargetNode)).booleanValue();
        }
        return Boolean.valueOf(zBooleanValue);
    }

    public final FocusTargetNode getActiveFocusTargetNode() {
        FocusTargetNode focusTargetNode = this.activeFocusTargetNode;
        if (focusTargetNode == null || !focusTargetNode.isAttached) {
            return null;
        }
        return focusTargetNode;
    }

    /* JADX INFO: renamed from: moveFocus-aToIllA, reason: not valid java name */
    public final boolean m346moveFocusaToIllA(final int i, boolean z) {
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = Boolean.FALSE;
        FocusTargetNode activeFocusTargetNode = getActiveFocusTargetNode();
        Boolean boolM345focusSearchULY8qGw = m345focusSearchULY8qGw(i, this.platformFocusOwner.getEmbeddedViewFocusRect(), new Function1() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$moveFocus$focusSearchSuccess$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Boolean boolValueOf = Boolean.valueOf(((FocusTargetNode) obj).m351requestFocus3ESFkO8(i));
                ref$ObjectRef.element = boolValueOf;
                return boolValueOf;
            }
        });
        if (!Intrinsics.areEqual(boolM345focusSearchULY8qGw, Boolean.TRUE) || activeFocusTargetNode == getActiveFocusTargetNode()) {
            if (boolM345focusSearchULY8qGw != null && ref$ObjectRef.element != null) {
                if (!boolM345focusSearchULY8qGw.booleanValue() || !((Boolean) ref$ObjectRef.element).booleanValue()) {
                    if ((i == 1 || i == 2) && z && m343clearFocusI7lrPNg(i, false, false)) {
                        Boolean boolM345focusSearchULY8qGw2 = m345focusSearchULY8qGw(i, null, new FocusOwnerImpl$takeFocus$1(i, 0));
                        if (boolM345focusSearchULY8qGw2 != null ? boolM345focusSearchULY8qGw2.booleanValue() : false) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: renamed from: resetFocus-3ESFkO8, reason: not valid java name */
    public final boolean m347resetFocus3ESFkO8(int i) {
        if (!m343clearFocusI7lrPNg(i, false, false)) {
            return false;
        }
        Boolean boolM345focusSearchULY8qGw = m345focusSearchULY8qGw(i, null, new FocusOwnerImpl$takeFocus$1(i, 1));
        boolean zBooleanValue = boolM345focusSearchULY8qGw != null ? boolM345focusSearchULY8qGw.booleanValue() : false;
        if (!zBooleanValue) {
            clearOwnerFocus();
        }
        return zBooleanValue;
    }

    public final void setActiveFocusTargetNode(FocusTargetNode focusTargetNode) {
        FocusTargetNode focusTargetNode2 = this.activeFocusTargetNode;
        this.activeFocusTargetNode = focusTargetNode;
        MutableObjectList mutableObjectList = this.listeners;
        Object[] objArr = mutableObjectList.content;
        int i = mutableObjectList._size;
        for (int i2 = 0; i2 < i; i2++) {
            ((FocusListener) objArr[i2]).onFocusChanged(focusTargetNode2, focusTargetNode);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r21v3, types: [int] */
    /* JADX WARN: Type inference failed for: r21v4 */
    /* JADX WARN: Type inference failed for: r21v5 */
    /* JADX WARN: Type inference failed for: r5v11, types: [int] */
    /* JADX INFO: renamed from: validateKeyEvent-ZmokQxo, reason: not valid java name */
    public final boolean m348validateKeyEventZmokQxo(KeyEvent keyEvent) {
        int iNumberOfTrailingZeros;
        boolean z;
        long j;
        int iFindFirstAvailableSlot;
        int iNumberOfTrailingZeros2;
        long[] jArr;
        int i;
        long jM505getKeyZmokQxo = Key_androidKt.m505getKeyZmokQxo(keyEvent);
        int iM506getTypeZmokQxo = Key_androidKt.m506getTypeZmokQxo(keyEvent);
        char c = ' ';
        long j2 = 0;
        int i2 = 0;
        boolean z2 = true;
        if (iM506getTypeZmokQxo != 2) {
            if (iM506getTypeZmokQxo != 1) {
                return true;
            }
            MutableLongSet mutableLongSet = this.keysCurrentlyDown;
            if (mutableLongSet == null || !mutableLongSet.contains(jM505getKeyZmokQxo)) {
                return false;
            }
            MutableLongSet mutableLongSet2 = this.keysCurrentlyDown;
            if (mutableLongSet2 != null) {
                int i3 = ((int) ((jM505getKeyZmokQxo >>> 32) ^ jM505getKeyZmokQxo)) * (-862048943);
                int i4 = i3 ^ (i3 << 16);
                int i5 = i4 & 127;
                int i6 = mutableLongSet2._capacity;
                int i7 = i4 >>> 7;
                loop5: while (true) {
                    int i8 = i7 & i6;
                    long[] jArr2 = mutableLongSet2.metadata;
                    int i9 = i8 >> 3;
                    int i10 = (i8 & 7) << 3;
                    long j3 = ((jArr2[i9 + 1] << (64 - i10)) & ((-i10) >> 63)) | (jArr2[i9] >>> i10);
                    long j4 = (((long) i5) * 72340172838076673L) ^ j3;
                    for (long j5 = (~j4) & (j4 - 72340172838076673L) & (-9187201950435737472L); j5 != 0; j5 &= j5 - 1) {
                        iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j5) >> 3) + i8) & i6;
                        if (mutableLongSet2.elements[iNumberOfTrailingZeros] == jM505getKeyZmokQxo) {
                            break loop5;
                        }
                    }
                    if ((j3 & ((~j3) << 6) & (-9187201950435737472L)) != 0) {
                        iNumberOfTrailingZeros = -1;
                        break;
                    }
                    i2 += 8;
                    i7 = i8 + i2;
                }
                if (iNumberOfTrailingZeros >= 0) {
                    mutableLongSet2._size--;
                    long[] jArr3 = mutableLongSet2.metadata;
                    int i11 = mutableLongSet2._capacity;
                    int i12 = iNumberOfTrailingZeros >> 3;
                    int i13 = (iNumberOfTrailingZeros & 7) << 3;
                    long j6 = (jArr3[i12] & (~(255 << i13))) | (254 << i13);
                    jArr3[i12] = j6;
                    jArr3[(((iNumberOfTrailingZeros - 7) & i11) + (i11 & 7)) >> 3] = j6;
                    return true;
                }
            }
            return true;
        }
        MutableLongSet mutableLongSet3 = this.keysCurrentlyDown;
        if (mutableLongSet3 == null) {
            mutableLongSet3 = new MutableLongSet(3);
            this.keysCurrentlyDown = mutableLongSet3;
        }
        int i14 = ((int) (jM505getKeyZmokQxo ^ (jM505getKeyZmokQxo >>> 32))) * (-862048943);
        int i15 = i14 ^ (i14 << 16);
        int i16 = i15 >>> 7;
        int i17 = i15 & 127;
        int i18 = mutableLongSet3._capacity;
        int i19 = i16 & i18;
        int i20 = 0;
        loop0: while (true) {
            long[] jArr4 = mutableLongSet3.metadata;
            int i21 = i19 >> 3;
            char c2 = c;
            int i22 = (i19 & 7) << 3;
            long j7 = (jArr4[i21] >>> i22) | ((jArr4[i21 + 1] << (64 - i22)) & ((-i22) >> 63));
            long j8 = i17;
            long j9 = j7 ^ (j8 * 72340172838076673L);
            long j10 = (j9 - 72340172838076673L) & (~j9) & (-9187201950435737472L);
            while (j10 != j2) {
                iNumberOfTrailingZeros2 = (i19 + (Long.numberOfTrailingZeros(j10) >> 3)) & i18;
                long j11 = j2;
                if (mutableLongSet3.elements[iNumberOfTrailingZeros2] == jM505getKeyZmokQxo) {
                    z = true;
                    break loop0;
                }
                j10 &= j10 - 1;
                j2 = j11;
            }
            long j12 = j2;
            if ((j7 & ((~j7) << 6) & (-9187201950435737472L)) != j12) {
                int iFindFirstAvailableSlot2 = mutableLongSet3.findFirstAvailableSlot(i16);
                if (mutableLongSet3.growthLimit != 0 || ((mutableLongSet3.metadata[iFindFirstAvailableSlot2 >> 3] >> ((iFindFirstAvailableSlot2 & 7) << 3)) & 255) == 254) {
                    z = true;
                    j = 128;
                    iFindFirstAvailableSlot = iFindFirstAvailableSlot2;
                } else {
                    int i23 = mutableLongSet3._capacity;
                    if (i23 <= 8 || Long.compare((((long) mutableLongSet3._size) * 32) ^ Long.MIN_VALUE, (((long) i23) * 25) ^ Long.MIN_VALUE) > 0) {
                        z = true;
                        j = 128;
                        int iNextCapacity = ScatterMapKt.nextCapacity(mutableLongSet3._capacity);
                        long[] jArr5 = mutableLongSet3.metadata;
                        long[] jArr6 = mutableLongSet3.elements;
                        int i24 = mutableLongSet3._capacity;
                        mutableLongSet3.initializeStorage(iNextCapacity);
                        long[] jArr7 = mutableLongSet3.metadata;
                        long[] jArr8 = mutableLongSet3.elements;
                        int i25 = mutableLongSet3._capacity;
                        int i26 = 0;
                        while (i26 < i24) {
                            if (((jArr5[i26 >> 3] >> ((i26 & 7) << 3)) & 255) < 128) {
                                long j13 = jArr6[i26];
                                jArr = jArr7;
                                int i27 = ((int) (j13 ^ (j13 >>> c2))) * (-862048943);
                                int i28 = i27 ^ (i27 << 16);
                                int iFindFirstAvailableSlot3 = mutableLongSet3.findFirstAvailableSlot(i28 >>> 7);
                                int i29 = iFindFirstAvailableSlot3 >> 3;
                                int i30 = (iFindFirstAvailableSlot3 & 7) << 3;
                                long j14 = (jArr[i29] & (~(255 << i30))) | (((long) (i28 & 127)) << i30);
                                jArr[i29] = j14;
                                jArr[(((iFindFirstAvailableSlot3 - 7) & i25) + (i25 & 7)) >> 3] = j14;
                                jArr8[iFindFirstAvailableSlot3] = j13;
                            } else {
                                jArr = jArr7;
                            }
                            i26++;
                            jArr5 = jArr5;
                            jArr7 = jArr;
                        }
                    } else {
                        long[] jArr9 = mutableLongSet3.metadata;
                        int i31 = mutableLongSet3._capacity;
                        long[] jArr10 = mutableLongSet3.elements;
                        int i32 = (i31 + 7) >> 3;
                        int i33 = 0;
                        while (i33 < i32) {
                            long j15 = jArr9[i33] & (-9187201950435737472L);
                            jArr9[i33] = ((~j15) + (j15 >>> 7)) & (-72340172838076674L);
                            i33++;
                            jArr10 = jArr10;
                            z2 = z2;
                        }
                        z = z2;
                        long[] jArr11 = jArr10;
                        j = 128;
                        int length = jArr9.length;
                        int i34 = length - 1;
                        int i35 = length - 2;
                        long j16 = 72057594037927935L;
                        jArr9[i35] = (jArr9[i35] & 72057594037927935L) | (-72057594037927936L);
                        jArr9[i34] = jArr9[0];
                        int i36 = 0;
                        while (i36 != i31) {
                            int i37 = i36 >> 3;
                            int i38 = (i36 & 7) << 3;
                            long j17 = (jArr9[i37] >> i38) & 255;
                            if (j17 != 128 && j17 == 254) {
                                long j18 = jArr11[i36];
                                int i39 = ((int) (j18 ^ (j18 >>> c2))) * (-862048943);
                                int i40 = i39 ^ (i39 << 16);
                                int i41 = i40 >>> 7;
                                int iFindFirstAvailableSlot4 = mutableLongSet3.findFirstAvailableSlot(i41);
                                int i42 = i41 & i31;
                                long j19 = j16;
                                if (((iFindFirstAvailableSlot4 - i42) & i31) / 8 == ((i36 - i42) & i31) / 8) {
                                    jArr9[i37] = ((~(255 << i38)) & jArr9[i37]) | (((long) (i40 & 127)) << i38);
                                    jArr9[jArr9.length - 1] = (jArr9[0] & j19) | Long.MIN_VALUE;
                                    i36++;
                                } else {
                                    int i43 = i36;
                                    int i44 = iFindFirstAvailableSlot4 >> 3;
                                    long j20 = jArr9[i44];
                                    int i45 = (iFindFirstAvailableSlot4 & 7) << 3;
                                    if (((j20 >> i45) & 255) == 128) {
                                        jArr9[i44] = ((~(255 << i45)) & j20) | (((long) (i40 & 127)) << i45);
                                        jArr9[i37] = (jArr9[i37] & (~(255 << i38))) | (128 << i38);
                                        jArr11[iFindFirstAvailableSlot4] = jArr11[i43];
                                        jArr11[i43] = j12;
                                        i = i43;
                                    } else {
                                        jArr9[i44] = (((long) (i40 & 127)) << i45) | ((~(255 << i45)) & j20);
                                        long j21 = jArr11[iFindFirstAvailableSlot4];
                                        jArr11[iFindFirstAvailableSlot4] = jArr11[i43];
                                        jArr11[i43] = j21;
                                        i = i43 - 1;
                                    }
                                    jArr9[jArr9.length - 1] = (jArr9[0] & j19) | Long.MIN_VALUE;
                                    i36 = i + 1;
                                }
                                i31 = i31;
                                j16 = j19;
                            } else {
                                i36++;
                            }
                        }
                        mutableLongSet3.growthLimit = ScatterMapKt.loadedCapacity(mutableLongSet3._capacity) - mutableLongSet3._size;
                    }
                    iFindFirstAvailableSlot = mutableLongSet3.findFirstAvailableSlot(i16);
                }
                mutableLongSet3._size++;
                int i46 = mutableLongSet3.growthLimit;
                long[] jArr12 = mutableLongSet3.metadata;
                int i47 = iFindFirstAvailableSlot >> 3;
                long j22 = jArr12[i47];
                int i48 = (iFindFirstAvailableSlot & 7) << 3;
                mutableLongSet3.growthLimit = i46 - (((j22 >> i48) & 255) == j ? z : 0);
                int i49 = mutableLongSet3._capacity;
                long j23 = (j22 & (~(255 << i48))) | (j8 << i48);
                jArr12[i47] = j23;
                jArr12[(((iFindFirstAvailableSlot - 7) & i49) + (i49 & 7)) >> 3] = j23;
                iNumberOfTrailingZeros2 = iFindFirstAvailableSlot;
                break;
            }
            i20 += 8;
            i19 = (i19 + i20) & i18;
            c = c2;
            j2 = j12;
        }
        mutableLongSet3.elements[iNumberOfTrailingZeros2] = jM505getKeyZmokQxo;
        return z;
    }
}
