package androidx.customview.widget;

import android.content.ClipDescription;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TtsSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.camera.camera2.internal.ExposureStateImpl;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.collection.ArraySetKt;
import androidx.collection.IntObjectMap;
import androidx.collection.MutableIntIntMap;
import androidx.collection.MutableIntList;
import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.ObjectIntMapKt;
import androidx.collection.SparseArrayCompat;
import androidx.collection.internal.RuntimeHelpersKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import androidx.compose.ui.platform.InvertMatrixKt;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.semantics.SemanticsNodeWithAdjustedBounds;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesAndroid;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.UrlAnnotation;
import androidx.compose.ui.text.VerbatimTtsAnnotation;
import androidx.compose.ui.text.font.AndroidFontUtils_androidKt;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.ComposeClickableSpan;
import androidx.compose.ui.text.style.ColorStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.lifecycle.Lifecycle;
import coil.network.EmptyNetworkObserver;
import coil.network.HttpException;
import coil.request.Parameters;
import com.google.android.gms.internal.mlkit_vision_barcode.zztj;
import com.google.android.gms.internal.mlkit_vision_barcode.zztz;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipDrawable;
import com.koala.clash.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat {
    public static final Rect INVALID_PARENT_BOUNDS = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    public static final Path.Companion NODE_ADAPTER = new Path.Companion();
    public static final EmptyNetworkObserver SPARSE_VALUES_ADAPTER = new EmptyNetworkObserver();
    public final Chip mHost;
    public final AccessibilityManager mManager;
    public MyNodeProvider mNodeProvider;
    public final Rect mTempScreenRect = new Rect();
    public final Rect mTempParentRect = new Rect();
    public final Rect mTempVisibleRect = new Rect();
    public final int[] mTempGlobalRect = new int[2];
    public int mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
    public int mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
    public int mHoveredVirtualViewId = Integer.MIN_VALUE;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class MyNodeProvider extends Parameters.Builder {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ AccessibilityDelegateCompat this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ MyNodeProvider(AccessibilityDelegateCompat accessibilityDelegateCompat, int i) {
            super(17);
            this.$r8$classId = i;
            this.this$0 = accessibilityDelegateCompat;
        }

        private final AccessibilityNodeInfoCompat createAccessibilityNodeInfo$androidx$customview$widget$ExploreByTouchHelper$MyNodeProvider(int i) {
            return new AccessibilityNodeInfoCompat(AccessibilityNodeInfo.obtain(((ExploreByTouchHelper) this.this$0).obtainAccessibilityNodeInfo(i).mInfo));
        }

        @Override // coil.request.Parameters.Builder
        public void addExtraDataToAccessibilityNodeInfo(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, String str, Bundle bundle) {
            switch (this.$r8$classId) {
                case 1:
                    ((AndroidComposeViewAccessibilityDelegateCompat) this.this$0).addExtraDataToAccessibilityNodeInfoHelper(i, accessibilityNodeInfoCompat, str, bundle);
                    break;
            }
        }

        /* JADX WARN: Code duplicated, block: B:105:0x020d  */
        /* JADX WARN: Code duplicated, block: B:108:0x0212  */
        /* JADX WARN: Code duplicated, block: B:115:0x022c  */
        /* JADX WARN: Code duplicated, block: B:116:0x0236  */
        /* JADX WARN: Code duplicated, block: B:119:0x0245  */
        /* JADX WARN: Code duplicated, block: B:121:0x025f  */
        /* JADX WARN: Code duplicated, block: B:123:0x0268  */
        /* JADX WARN: Code duplicated, block: B:126:0x02b5  */
        /* JADX WARN: Code duplicated, block: B:128:0x02b9  */
        /* JADX WARN: Code duplicated, block: B:129:0x02bf  */
        /* JADX WARN: Code duplicated, block: B:135:0x02de A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:136:0x02e0  */
        /* JADX WARN: Code duplicated, block: B:137:0x02e3  */
        /* JADX WARN: Code duplicated, block: B:139:0x02e7  */
        /* JADX WARN: Code duplicated, block: B:140:0x02ea  */
        /* JADX WARN: Code duplicated, block: B:143:0x02fb  */
        /* JADX WARN: Code duplicated, block: B:145:0x0301  */
        /* JADX WARN: Code duplicated, block: B:148:0x030d  */
        /* JADX WARN: Code duplicated, block: B:150:0x0317  */
        /* JADX WARN: Code duplicated, block: B:153:0x0328  */
        /* JADX WARN: Code duplicated, block: B:156:0x035d  */
        /* JADX WARN: Code duplicated, block: B:159:0x0368  */
        /* JADX WARN: Code duplicated, block: B:161:0x0378  */
        /* JADX WARN: Code duplicated, block: B:167:0x0396  */
        /* JADX WARN: Code duplicated, block: B:170:0x039e  */
        /* JADX WARN: Code duplicated, block: B:172:0x03b0 A[LOOP:3: B:169:0x039c->B:172:0x03b0, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:177:0x03cf  */
        /* JADX WARN: Code duplicated, block: B:179:0x03df  */
        /* JADX WARN: Code duplicated, block: B:185:0x03fd  */
        /* JADX WARN: Code duplicated, block: B:188:0x0405  */
        /* JADX WARN: Code duplicated, block: B:190:0x041d  */
        /* JADX WARN: Code duplicated, block: B:194:0x0437  */
        /* JADX WARN: Code duplicated, block: B:196:0x0447  */
        /* JADX WARN: Code duplicated, block: B:204:0x046c  */
        /* JADX WARN: Code duplicated, block: B:206:0x047a  */
        /* JADX WARN: Code duplicated, block: B:208:0x0481  */
        /* JADX WARN: Code duplicated, block: B:210:0x0492  */
        /* JADX WARN: Code duplicated, block: B:212:0x04a4  */
        /* JADX WARN: Code duplicated, block: B:214:0x04ae  */
        /* JADX WARN: Code duplicated, block: B:216:0x04be  */
        /* JADX WARN: Code duplicated, block: B:219:0x04ca  */
        /* JADX WARN: Code duplicated, block: B:222:0x04eb  */
        /* JADX WARN: Code duplicated, block: B:224:0x04f5  */
        /* JADX WARN: Code duplicated, block: B:227:0x0503  */
        /* JADX WARN: Code duplicated, block: B:230:0x0510  */
        /* JADX WARN: Code duplicated, block: B:231:0x0514  */
        /* JADX WARN: Code duplicated, block: B:234:0x052c  */
        /* JADX WARN: Code duplicated, block: B:237:0x0532  */
        /* JADX WARN: Code duplicated, block: B:239:0x0536  */
        /* JADX WARN: Code duplicated, block: B:240:0x053b  */
        /* JADX WARN: Code duplicated, block: B:242:0x053f  */
        /* JADX WARN: Code duplicated, block: B:246:0x054d  */
        /* JADX WARN: Code duplicated, block: B:249:0x0553  */
        /* JADX WARN: Code duplicated, block: B:251:0x0559  */
        /* JADX WARN: Code duplicated, block: B:252:0x055d  */
        /* JADX WARN: Code duplicated, block: B:254:0x0564  */
        /* JADX WARN: Code duplicated, block: B:258:0x0570  */
        /* JADX WARN: Code duplicated, block: B:263:0x0582  */
        /* JADX WARN: Code duplicated, block: B:265:0x058a  */
        /* JADX WARN: Code duplicated, block: B:268:0x0590  */
        /* JADX WARN: Code duplicated, block: B:269:0x0597  */
        /* JADX WARN: Code duplicated, block: B:273:0x05a4  */
        /* JADX WARN: Code duplicated, block: B:276:0x05aa  */
        /* JADX WARN: Code duplicated, block: B:278:0x05ad  */
        /* JADX WARN: Code duplicated, block: B:27:0x0087  */
        /* JADX WARN: Code duplicated, block: B:281:0x05c4 A[LOOP:8: B:277:0x05ab->B:281:0x05c4, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:284:0x05cc  */
        /* JADX WARN: Code duplicated, block: B:287:0x05db  */
        /* JADX WARN: Code duplicated, block: B:289:0x05df  */
        /* JADX WARN: Code duplicated, block: B:290:0x05e4  */
        /* JADX WARN: Code duplicated, block: B:294:0x05f7  */
        /* JADX WARN: Code duplicated, block: B:296:0x05fb  */
        /* JADX WARN: Code duplicated, block: B:297:0x05ff  */
        /* JADX WARN: Code duplicated, block: B:29:0x0096  */
        /* JADX WARN: Code duplicated, block: B:301:0x060c  */
        /* JADX WARN: Code duplicated, block: B:303:0x0616  */
        /* JADX WARN: Code duplicated, block: B:305:0x061c  */
        /* JADX WARN: Code duplicated, block: B:307:0x0622  */
        /* JADX WARN: Code duplicated, block: B:30:0x009a  */
        /* JADX WARN: Code duplicated, block: B:310:0x064b  */
        /* JADX WARN: Code duplicated, block: B:311:0x0650  */
        /* JADX WARN: Code duplicated, block: B:314:0x066a  */
        /* JADX WARN: Code duplicated, block: B:316:0x067d  */
        /* JADX WARN: Code duplicated, block: B:318:0x0687  */
        /* JADX WARN: Code duplicated, block: B:319:0x068e  */
        /* JADX WARN: Code duplicated, block: B:322:0x069f  */
        /* JADX WARN: Code duplicated, block: B:323:0x06a4  */
        /* JADX WARN: Code duplicated, block: B:326:0x06af  */
        /* JADX WARN: Code duplicated, block: B:329:0x06bd  */
        /* JADX WARN: Code duplicated, block: B:331:0x06c1  */
        /* JADX WARN: Code duplicated, block: B:332:0x06c3  */
        /* JADX WARN: Code duplicated, block: B:334:0x06c6  */
        /* JADX WARN: Code duplicated, block: B:335:0x06c8  */
        /* JADX WARN: Code duplicated, block: B:337:0x06cb  */
        /* JADX WARN: Code duplicated, block: B:338:0x06cd  */
        /* JADX WARN: Code duplicated, block: B:33:0x00a2  */
        /* JADX WARN: Code duplicated, block: B:340:0x06d0  */
        /* JADX WARN: Code duplicated, block: B:344:0x06e7  */
        /* JADX WARN: Code duplicated, block: B:346:0x06f3  */
        /* JADX WARN: Code duplicated, block: B:347:0x06f5  */
        /* JADX WARN: Code duplicated, block: B:351:0x06fd  */
        /* JADX WARN: Code duplicated, block: B:352:0x06ff  */
        /* JADX WARN: Code duplicated, block: B:353:0x0701  */
        /* JADX WARN: Code duplicated, block: B:358:0x0709  */
        /* JADX WARN: Code duplicated, block: B:359:0x070b  */
        /* JADX WARN: Code duplicated, block: B:35:0x00aa  */
        /* JADX WARN: Code duplicated, block: B:361:0x070e A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:365:0x0715  */
        /* JADX WARN: Code duplicated, block: B:368:0x071f  */
        /* JADX WARN: Code duplicated, block: B:36:0x00ad  */
        /* JADX WARN: Code duplicated, block: B:374:0x073f  */
        /* JADX WARN: Code duplicated, block: B:376:0x0749  */
        /* JADX WARN: Code duplicated, block: B:380:0x0761  */
        /* JADX WARN: Code duplicated, block: B:383:0x0775  */
        /* JADX WARN: Code duplicated, block: B:385:0x077f  */
        /* JADX WARN: Code duplicated, block: B:388:0x0797  */
        /* JADX WARN: Code duplicated, block: B:38:0x00b5  */
        /* JADX WARN: Code duplicated, block: B:391:0x07b6  */
        /* JADX WARN: Code duplicated, block: B:394:0x07d4  */
        /* JADX WARN: Code duplicated, block: B:396:0x07da  */
        /* JADX WARN: Code duplicated, block: B:398:0x07e8  */
        /* JADX WARN: Code duplicated, block: B:399:0x07ef  */
        /* JADX WARN: Code duplicated, block: B:401:0x07f2  */
        /* JADX WARN: Code duplicated, block: B:405:0x0809  */
        /* JADX WARN: Code duplicated, block: B:409:0x0812  */
        /* JADX WARN: Code duplicated, block: B:40:0x00bb  */
        /* JADX WARN: Code duplicated, block: B:411:0x0815  */
        /* JADX WARN: Code duplicated, block: B:413:0x0830  */
        /* JADX WARN: Code duplicated, block: B:414:0x0835  */
        /* JADX WARN: Code duplicated, block: B:417:0x085c  */
        /* JADX WARN: Code duplicated, block: B:41:0x00c2  */
        /* JADX WARN: Code duplicated, block: B:421:0x0865  */
        /* JADX WARN: Code duplicated, block: B:423:0x0868  */
        /* JADX WARN: Code duplicated, block: B:430:0x0889  */
        /* JADX WARN: Code duplicated, block: B:432:0x0899  */
        /* JADX WARN: Code duplicated, block: B:436:0x08a2  */
        /* JADX WARN: Code duplicated, block: B:438:0x08a5  */
        /* JADX WARN: Code duplicated, block: B:43:0x00c6  */
        /* JADX WARN: Code duplicated, block: B:443:0x08c2  */
        /* JADX WARN: Code duplicated, block: B:446:0x08d3  */
        /* JADX WARN: Code duplicated, block: B:449:0x08f2  */
        /* JADX WARN: Code duplicated, block: B:452:0x0903  */
        /* JADX WARN: Code duplicated, block: B:454:0x090f  */
        /* JADX WARN: Code duplicated, block: B:455:0x0915  */
        /* JADX WARN: Code duplicated, block: B:458:0x0920  */
        /* JADX WARN: Code duplicated, block: B:45:0x00d6  */
        /* JADX WARN: Code duplicated, block: B:461:0x0952  */
        /* JADX WARN: Code duplicated, block: B:465:0x0972  */
        /* JADX WARN: Code duplicated, block: B:468:0x0979  */
        /* JADX WARN: Code duplicated, block: B:471:0x0998  */
        /* JADX WARN: Code duplicated, block: B:474:0x099f  */
        /* JADX WARN: Code duplicated, block: B:477:0x09aa  */
        /* JADX WARN: Code duplicated, block: B:480:0x09cd A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:483:0x09dd  */
        /* JADX WARN: Code duplicated, block: B:485:0x09e1  */
        /* JADX WARN: Code duplicated, block: B:487:0x09ef  */
        /* JADX WARN: Code duplicated, block: B:490:0x09f4  */
        /* JADX WARN: Code duplicated, block: B:491:0x09f6  */
        /* JADX WARN: Code duplicated, block: B:493:0x09f9  */
        /* JADX WARN: Code duplicated, block: B:496:0x0a10  */
        /* JADX WARN: Code duplicated, block: B:499:0x0a1a  */
        /* JADX WARN: Code duplicated, block: B:49:0x0105  */
        /* JADX WARN: Code duplicated, block: B:501:0x0a22  */
        /* JADX WARN: Code duplicated, block: B:503:0x0a2d  */
        /* JADX WARN: Code duplicated, block: B:504:0x0a2f  */
        /* JADX WARN: Code duplicated, block: B:506:0x0a32  */
        /* JADX WARN: Code duplicated, block: B:507:0x0a35  */
        /* JADX WARN: Code duplicated, block: B:509:0x0a3b  */
        /* JADX WARN: Code duplicated, block: B:512:0x0a43  */
        /* JADX WARN: Code duplicated, block: B:514:0x0a4c  */
        /* JADX WARN: Code duplicated, block: B:515:0x0a4e  */
        /* JADX WARN: Code duplicated, block: B:517:0x0a51  */
        /* JADX WARN: Code duplicated, block: B:518:0x0a54  */
        /* JADX WARN: Code duplicated, block: B:522:0x0a67 A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:525:0x0a77  */
        /* JADX WARN: Code duplicated, block: B:527:0x0a7b  */
        /* JADX WARN: Code duplicated, block: B:529:0x0a89  */
        /* JADX WARN: Code duplicated, block: B:52:0x0112  */
        /* JADX WARN: Code duplicated, block: B:532:0x0a8e  */
        /* JADX WARN: Code duplicated, block: B:533:0x0a90  */
        /* JADX WARN: Code duplicated, block: B:535:0x0a93  */
        /* JADX WARN: Code duplicated, block: B:538:0x0aaa  */
        /* JADX WARN: Code duplicated, block: B:541:0x0ab4  */
        /* JADX WARN: Code duplicated, block: B:543:0x0aba  */
        /* JADX WARN: Code duplicated, block: B:546:0x0aca  */
        /* JADX WARN: Code duplicated, block: B:548:0x0ad6  */
        /* JADX WARN: Code duplicated, block: B:551:0x0ae9  */
        /* JADX WARN: Code duplicated, block: B:552:0x0aed  */
        /* JADX WARN: Code duplicated, block: B:555:0x0afc  */
        /* JADX WARN: Code duplicated, block: B:557:0x0b0a  */
        /* JADX WARN: Code duplicated, block: B:55:0x011f  */
        /* JADX WARN: Code duplicated, block: B:560:0x0b28  */
        /* JADX WARN: Code duplicated, block: B:563:0x0b46  */
        /* JADX WARN: Code duplicated, block: B:566:0x0b62  */
        /* JADX WARN: Code duplicated, block: B:568:0x0b76  */
        /* JADX WARN: Code duplicated, block: B:570:0x0b86  */
        /* JADX WARN: Code duplicated, block: B:573:0x0b93  */
        /* JADX WARN: Code duplicated, block: B:574:0x0b95  */
        /* JADX WARN: Code duplicated, block: B:576:0x0b98  */
        /* JADX WARN: Code duplicated, block: B:578:0x0ba9  */
        /* JADX WARN: Code duplicated, block: B:580:0x0bb4  */
        /* JADX WARN: Code duplicated, block: B:581:0x0bc5  */
        /* JADX WARN: Code duplicated, block: B:585:0x0bdc  */
        /* JADX WARN: Code duplicated, block: B:588:0x0be3  */
        /* JADX WARN: Code duplicated, block: B:58:0x0127  */
        /* JADX WARN: Code duplicated, block: B:590:0x0bed  */
        /* JADX WARN: Code duplicated, block: B:592:0x0bf0  */
        /* JADX WARN: Code duplicated, block: B:594:0x0bf6  */
        /* JADX WARN: Code duplicated, block: B:596:0x0bff  */
        /* JADX WARN: Code duplicated, block: B:599:0x0c0f  */
        /* JADX WARN: Code duplicated, block: B:601:0x0c1a  */
        /* JADX WARN: Code duplicated, block: B:605:0x0c39  */
        /* JADX WARN: Code duplicated, block: B:606:0x0c3d  */
        /* JADX WARN: Code duplicated, block: B:609:0x0c4a  */
        /* JADX WARN: Code duplicated, block: B:60:0x012f  */
        /* JADX WARN: Code duplicated, block: B:610:0x0c5e  */
        /* JADX WARN: Code duplicated, block: B:613:0x0c68  */
        /* JADX WARN: Code duplicated, block: B:616:0x0c7d  */
        /* JADX WARN: Code duplicated, block: B:627:0x0c94  */
        /* JADX WARN: Code duplicated, block: B:631:0x0228 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:632:0x021b A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:633:0x0221 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:635:0x0221 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:638:0x0334 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:63:0x013f  */
        /* JADX WARN: Code duplicated, block: B:644:0x03c3 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:651:0x0427 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:660:0x05c9 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:661:0x05b9 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:66:0x0148  */
        /* JADX WARN: Code duplicated, block: B:67:0x0157  */
        /* JADX WARN: Code duplicated, block: B:69:0x015a  */
        /* JADX WARN: Code duplicated, block: B:70:0x0169  */
        /* JADX WARN: Code duplicated, block: B:76:0x017a  */
        /* JADX WARN: Code duplicated, block: B:78:0x0180  */
        /* JADX WARN: Code duplicated, block: B:81:0x0197  */
        /* JADX WARN: Code duplicated, block: B:84:0x019e  */
        /* JADX WARN: Code duplicated, block: B:86:0x01a4  */
        /* JADX WARN: Code duplicated, block: B:90:0x01b8  */
        /* JADX WARN: Code duplicated, block: B:92:0x01d2  */
        /* JADX WARN: Code duplicated, block: B:94:0x01e2  */
        /* JADX WARN: Code duplicated, block: B:97:0x01e6  */
        /* JADX WARN: Code duplicated, block: B:9:0x0038  */
        /* JADX WARN: Instruction removed from duplicated block: B:627:0x0c94, please report this as an issue */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v17, types: [kotlin.collections.EmptyList] */
        /* JADX WARN: Type inference failed for: r2v18, types: [java.util.Collection, java.util.List] */
        /* JADX WARN: Type inference failed for: r2v19, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r3v22 */
        /* JADX WARN: Type inference failed for: r3v23, types: [java.util.Collection, java.util.List] */
        /* JADX WARN: Type inference failed for: r3v24 */
        /* JADX WARN: Type inference failed for: r3v25, types: [java.util.Collection, java.util.List] */
        /* JADX WARN: Type inference failed for: r3v31, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r3v32, types: [java.util.ArrayList] */
        @Override // coil.request.Parameters.Builder
        public final AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int i) {
            AccessibilityNodeInfo accessibilityNodeInfoObtain;
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat;
            int i2;
            SemanticsNode parent;
            Integer numValueOf;
            int iIntValue;
            MutableIntIntMap mutableIntIntMap;
            SparseArrayCompat sparseArrayCompat;
            Resources resources;
            SemanticsConfiguration semanticsConfiguration;
            MutableScatterMap mutableScatterMap;
            Object obj;
            Role role;
            AccessibilityManager accessibilityManager;
            SparseArrayCompat sparseArrayCompat2;
            boolean zIsImportantForAccessibility;
            boolean zIsRequestFromAccessibilityTool;
            List children$ui$default;
            int size;
            boolean z;
            int i3;
            int i4;
            AccessibilityNodeInfo accessibilityNodeInfo;
            AnnotatedString infoText;
            Role role2;
            SemanticsConfiguration semanticsConfiguration2;
            MutableIntIntMap mutableIntIntMap2;
            SemanticsNode semanticsNode;
            AccessibilityNodeInfo accessibilityNodeInfo2;
            Resources resources2;
            MutableScatterMap mutableScatterMap2;
            SpannableString spannableString;
            SemanticsPropertyKey semanticsPropertyKey;
            MutableScatterMap mutableScatterMap3;
            AccessibilityNodeInfo accessibilityNodeInfo3;
            SemanticsNode semanticsNode2;
            String infoStateDescriptionOrNull;
            Object obj2;
            ToggleableState toggleableState;
            Object obj3;
            Boolean bool;
            Role role3;
            int i5;
            SemanticsConfiguration semanticsConfiguration3;
            Object obj4;
            List list;
            String str;
            Object obj5;
            String str2;
            int i6;
            Boolean bool2;
            Integer num;
            int iIntValue2;
            SemanticsPropertyKey semanticsPropertyKey2;
            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat;
            boolean z2;
            SemanticsNode parent2;
            LiveRegionMode liveRegionMode;
            AccessibilityAction accessibilityAction;
            char c;
            AccessibilityAction accessibilityAction2;
            AccessibilityAction accessibilityAction3;
            String iterableTextForAccessibility;
            boolean z3;
            ProgressBarRangeInfo progressBarRangeInfo;
            int i7;
            ScrollAxisRange scrollAxisRange;
            ScrollAxisRange scrollAxisRange2;
            CharSequence charSequence;
            boolean zAccess$isScreenReaderFocusable;
            int orDefault;
            AndroidComposeView androidComposeView;
            int orDefault2;
            String str3;
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2;
            AccessibilityAction accessibilityAction4;
            AccessibilityAction accessibilityAction5;
            AccessibilityAction accessibilityAction6;
            SemanticsConfiguration unmergedConfig$ui;
            SemanticsPropertyKey semanticsPropertyKey3;
            List list2;
            int size2;
            MutableIntList mutableIntList;
            SparseArrayCompat sparseArrayCompat3;
            boolean z4;
            int[] iArr;
            int i8;
            int[] iArrCopyOf;
            int i9;
            int i10;
            ArrayList arrayList;
            int i11;
            Object obj6;
            boolean z5;
            Object obj7;
            Object obj8;
            boolean z6;
            boolean zPopulateAccessibilityNodeInfoProperties$canScrollForward;
            LayoutDirection layoutDirection;
            LayoutNode layoutNode;
            boolean z7;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat;
            boolean z8;
            AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat2;
            Object obj9;
            SemanticsConfiguration unmergedConfig$ui2;
            SemanticsPropertyKey semanticsPropertyKey4;
            float fFloatValue;
            float fFloatValue2;
            float fFloatValue3;
            float fFloatValue4;
            ArrayList arrayList2;
            CharSequence text;
            boolean z9;
            AccessibilityAction accessibilityAction7;
            String label;
            List list3;
            boolean z10;
            AccessibilityAction accessibilityAction8;
            AccessibilityAction accessibilityAction9;
            AccessibilityAction accessibilityAction10;
            AccessibilityAction accessibilityAction11;
            ClipDescription primaryClipDescription;
            boolean zHasMimeType;
            boolean z11;
            boolean z12;
            boolean z13;
            boolean z14;
            int i12;
            boolean z15;
            boolean z16;
            int i13;
            int orDefault3;
            SemanticsNode parent3;
            boolean zBooleanValue;
            SemanticsConfiguration semanticsConfiguration4;
            SemanticsPropertyKey semanticsPropertyKey5;
            boolean zBooleanValue2;
            Object obj10;
            Density density;
            MenuHostHelper menuHostHelper;
            SpannableString spannableString2;
            List list4;
            ArrayList arrayList3;
            SpannableString spannableString3;
            ?? arrayList4;
            ?? arrayList5;
            int size3;
            int i14;
            ?? arrayList6;
            int size4;
            int i15;
            int size5;
            int i16;
            AnnotatedString.Range range;
            int i17;
            Object obj11;
            int i18;
            LinkAnnotation linkAnnotation;
            WeakHashMap weakHashMap;
            Object composeClickableSpan;
            AnnotatedString.Range range2;
            LinkAnnotation.Url url;
            WeakHashMap weakHashMap2;
            Object uRLSpan;
            int size6;
            int i19;
            AnnotatedString.Range range3;
            UrlAnnotation urlAnnotation;
            WeakHashMap weakHashMap3;
            Object uRLSpan2;
            int size7;
            int i20;
            AnnotatedString.Range range4;
            VerbatimTtsAnnotation verbatimTtsAnnotation;
            int i21;
            int i22;
            int size8;
            int i23;
            AnnotatedString.Range range5;
            int size9;
            int i24;
            int i25;
            int i26;
            long jMo668getColor0d7_KjU;
            FontWeight fontWeight;
            FontStyle fontStyle;
            TextGeometricTransform textGeometricTransform;
            long j;
            TextDecoration textDecoration;
            TextForegroundStyle colorStyle;
            SpannableString spannableString4;
            FontWeight fontWeight2;
            int i27;
            int i28;
            int i29;
            SemanticsNode semanticsNode3;
            IntObjectMap currentSemanticsNodes;
            int i30;
            SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds;
            boolean zAreEqual;
            SemanticsNode semanticsNode4;
            int i31;
            int i32;
            String strM614toLegacyClassNameV4PA4sw;
            Object parentForAccessibility;
            View view;
            switch (this.$r8$classId) {
                case 0:
                    return createAccessibilityNodeInfo$androidx$customview$widget$ExploreByTouchHelper$MyNodeProvider(i);
                default:
                    Float fValueOf = Float.valueOf(0.0f);
                    AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat2 = (AndroidComposeViewAccessibilityDelegateCompat) this.this$0;
                    AccessibilityManager accessibilityManager2 = androidComposeViewAccessibilityDelegateCompat2.accessibilityManager;
                    AndroidComposeView androidComposeView2 = androidComposeViewAccessibilityDelegateCompat2.view;
                    if (androidComposeView2.getComposeViewContext().lifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
                        if (accessibilityManager2.isEnabled()) {
                            accessibilityNodeInfoCompat2 = null;
                        } else {
                            accessibilityNodeInfoCompat2 = new AccessibilityNodeInfoCompat(AccessibilityNodeInfo.obtain());
                        }
                        i6 = i;
                        androidComposeViewAccessibilityDelegateCompat = androidComposeViewAccessibilityDelegateCompat2;
                    } else {
                        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds2 = (SemanticsNodeWithAdjustedBounds) androidComposeViewAccessibilityDelegateCompat2.getCurrentSemanticsNodes().get(i);
                        if (semanticsNodeWithAdjustedBounds2 == null) {
                            if (accessibilityManager2.isEnabled()) {
                                accessibilityNodeInfoCompat2 = null;
                            } else {
                                accessibilityNodeInfoCompat2 = new AccessibilityNodeInfoCompat(AccessibilityNodeInfo.obtain());
                            }
                            i6 = i;
                            androidComposeViewAccessibilityDelegateCompat = androidComposeViewAccessibilityDelegateCompat2;
                        } else {
                            SemanticsNode semanticsNode5 = semanticsNodeWithAdjustedBounds2.semanticsNode;
                            SemanticsConfiguration config = semanticsNode5.getConfig();
                            LayoutNode layoutNode2 = semanticsNode5.layoutNode;
                            Object obj12 = config.props.get(SemanticsProperties.IsSensitiveData);
                            if (obj12 == null) {
                                obj12 = null;
                            }
                            boolean zAreEqual2 = Intrinsics.areEqual(obj12, Boolean.TRUE);
                            if (!zAreEqual2) {
                                accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain();
                                accessibilityNodeInfoCompat = new AccessibilityNodeInfoCompat(accessibilityNodeInfoObtain);
                                i2 = Build.VERSION.SDK_INT;
                                if (i2 >= 34) {
                                    TextViewCompat.Api34Impl.setAccessibilityDataSensitive(accessibilityNodeInfoObtain, zAreEqual2);
                                } else {
                                    accessibilityNodeInfoCompat.setBooleanProperty(64, zAreEqual2);
                                }
                                if (i == -1) {
                                    parentForAccessibility = androidComposeView2.getParentForAccessibility();
                                    if (parentForAccessibility instanceof View) {
                                        view = (View) parentForAccessibility;
                                    } else {
                                        view = null;
                                    }
                                    accessibilityNodeInfoCompat.mParentVirtualDescendantId = -1;
                                    accessibilityNodeInfoObtain.setParent(view);
                                } else {
                                    parent = semanticsNode5.getParent();
                                    if (parent != null) {
                                        numValueOf = Integer.valueOf(parent.id);
                                    } else {
                                        numValueOf = null;
                                    }
                                    if (numValueOf != null) {
                                        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("semanticsNode " + i + " has null parent");
                                        throw new HttpException();
                                    }
                                    iIntValue = numValueOf.intValue();
                                    if (iIntValue == androidComposeView2.getSemanticsOwner().getUnmergedRootSemanticsNode().id) {
                                        iIntValue = -1;
                                    }
                                    accessibilityNodeInfoCompat.mParentVirtualDescendantId = iIntValue;
                                    accessibilityNodeInfoObtain.setParent(androidComposeView2, iIntValue);
                                }
                                accessibilityNodeInfoCompat.mVirtualDescendantId = i;
                                accessibilityNodeInfoObtain.setSource(androidComposeView2, i);
                                accessibilityNodeInfoObtain.setBoundsInScreen(androidComposeViewAccessibilityDelegateCompat2.boundsInScreen(semanticsNodeWithAdjustedBounds2));
                                mutableIntIntMap = androidComposeViewAccessibilityDelegateCompat2.drawingOrder;
                                sparseArrayCompat = androidComposeViewAccessibilityDelegateCompat2.labelToActionId;
                                resources = androidComposeView2.getContext().getResources();
                                accessibilityNodeInfoCompat.setClassName("android.view.View");
                                semanticsConfiguration = semanticsNode5.unmergedConfig;
                                mutableScatterMap = semanticsConfiguration.props;
                                if (mutableScatterMap.containsKey(SemanticsProperties.EditableText)) {
                                    accessibilityNodeInfoCompat.setClassName("android.widget.EditText");
                                }
                                if (mutableScatterMap.containsKey(SemanticsProperties.Text)) {
                                    accessibilityNodeInfoCompat.setClassName("android.widget.TextView");
                                }
                                obj = mutableScatterMap.get(SemanticsProperties.Role);
                                if (obj == null) {
                                    obj = null;
                                }
                                role = (Role) obj;
                                if (role != null) {
                                    i31 = role.value;
                                    if (semanticsNode5.isFake$ui()) {
                                        accessibilityManager = accessibilityManager2;
                                        i32 = 4;
                                        sparseArrayCompat2 = sparseArrayCompat;
                                        if (SemanticsNode.getChildren$ui$default(4, semanticsNode5).isEmpty()) {
                                        }
                                        Unit unit = Unit.INSTANCE;
                                    } else {
                                        accessibilityManager = accessibilityManager2;
                                        i32 = 4;
                                        sparseArrayCompat2 = sparseArrayCompat;
                                    }
                                    if (i31 == i32) {
                                        accessibilityNodeInfoObtain.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", resources.getString(R.string.tab));
                                    } else if (i31 == 2) {
                                        accessibilityNodeInfoObtain.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", resources.getString(R.string.switch_role));
                                    } else {
                                        strM614toLegacyClassNameV4PA4sw = InvertMatrixKt.m614toLegacyClassNameV4PA4sw(i31);
                                        if (i31 == 5 || semanticsNode5.isUnmergedLeafNode$ui() || semanticsConfiguration.isMergingSemanticsOfDescendants) {
                                            accessibilityNodeInfoCompat.setClassName(strM614toLegacyClassNameV4PA4sw);
                                        }
                                    }
                                    Unit unit2 = Unit.INSTANCE;
                                } else {
                                    accessibilityManager = accessibilityManager2;
                                    sparseArrayCompat2 = sparseArrayCompat;
                                }
                                accessibilityNodeInfoObtain.setPackageName(androidComposeView2.getContext().getPackageName());
                                zIsImportantForAccessibility = SemanticsNodeKt.isImportantForAccessibility(semanticsNode5);
                                if (i2 >= 24) {
                                    accessibilityNodeInfoObtain.setImportantForAccessibility(zIsImportantForAccessibility);
                                }
                                if (i2 >= 34) {
                                    zIsRequestFromAccessibilityTool = TextViewCompat.Api34Impl.isRequestFromAccessibilityTool(accessibilityManager);
                                } else {
                                    zIsRequestFromAccessibilityTool = true;
                                }
                                children$ui$default = SemanticsNode.getChildren$ui$default(4, semanticsNode5);
                                size = children$ui$default.size();
                                z = zIsRequestFromAccessibilityTool;
                                i3 = 0;
                                i4 = 0;
                                while (true) {
                                    accessibilityNodeInfo = accessibilityNodeInfoCompat.mInfo;
                                    if (i4 < size) {
                                        int i33 = i4;
                                        semanticsNode3 = (SemanticsNode) children$ui$default.get(i4);
                                        int i34 = size;
                                        currentSemanticsNodes = androidComposeViewAccessibilityDelegateCompat2.getCurrentSemanticsNodes();
                                        List list5 = children$ui$default;
                                        i30 = semanticsNode3.id;
                                        if (!currentSemanticsNodes.containsKey(i30)) {
                                            if (androidComposeView2.getAndroidViewsHandler$ui().getLayoutNodeToHolder().get(semanticsNode3.layoutNode) == null) {
                                                throw new ClassCastException();
                                            }
                                            if (i30 != -1) {
                                                semanticsNodeWithAdjustedBounds = (SemanticsNodeWithAdjustedBounds) androidComposeViewAccessibilityDelegateCompat2.getCurrentSemanticsNodes().get(i30);
                                                if (semanticsNodeWithAdjustedBounds != null || (semanticsNode4 = semanticsNodeWithAdjustedBounds.semanticsNode) == null) {
                                                    zAreEqual = false;
                                                } else {
                                                    Object obj13 = semanticsNode4.getConfig().props.get(SemanticsProperties.IsSensitiveData);
                                                    if (obj13 == null) {
                                                        obj13 = null;
                                                    }
                                                    zAreEqual = Intrinsics.areEqual(obj13, Boolean.TRUE);
                                                }
                                                if (z || !zAreEqual) {
                                                    accessibilityNodeInfo.addChild(androidComposeView2, i30);
                                                }
                                                mutableIntIntMap.set(i30, i3);
                                                i3++;
                                            }
                                        }
                                        i4 = i33 + 1;
                                        size = i34;
                                        children$ui$default = list5;
                                    } else {
                                        if (i == androidComposeViewAccessibilityDelegateCompat2.accessibilityFocusedVirtualViewId) {
                                            accessibilityNodeInfo.setAccessibilityFocused(true);
                                            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
                                        } else {
                                            accessibilityNodeInfo.setAccessibilityFocused(false);
                                            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_ACCESSIBILITY_FOCUS);
                                        }
                                        infoText = InvertMatrixKt.getInfoText(semanticsNode5);
                                        if (infoText != null) {
                                            androidComposeView2.getFontFamilyResolver();
                                            density = androidComposeView2.getDensity();
                                            menuHostHelper = androidComposeViewAccessibilityDelegateCompat2.urlSpanCache;
                                            String str4 = infoText.text;
                                            list4 = infoText.annotations;
                                            spannableString2 = new SpannableString(str4);
                                            arrayList3 = infoText.spanStylesOrNull;
                                            if (arrayList3 != null) {
                                                size9 = arrayList3.size();
                                                i24 = 0;
                                                while (i24 < size9) {
                                                    ArrayList arrayList7 = arrayList3;
                                                    AnnotatedString.Range range6 = (AnnotatedString.Range) arrayList3.get(i24);
                                                    int i35 = i24;
                                                    SpanStyle spanStyle = (SpanStyle) range6.item;
                                                    int i36 = size9;
                                                    i25 = range6.start;
                                                    i26 = range6.end;
                                                    MutableIntIntMap mutableIntIntMap3 = mutableIntIntMap;
                                                    SemanticsConfiguration semanticsConfiguration5 = semanticsConfiguration;
                                                    jMo668getColor0d7_KjU = spanStyle.textForegroundStyle.mo668getColor0d7_KjU();
                                                    SemanticsNode semanticsNode6 = semanticsNode5;
                                                    long j2 = spanStyle.fontSize;
                                                    fontWeight = spanStyle.fontWeight;
                                                    fontStyle = spanStyle.fontStyle;
                                                    textGeometricTransform = spanStyle.textGeometricTransform;
                                                    Role role4 = role;
                                                    LocaleList localeList = spanStyle.localeList;
                                                    AccessibilityNodeInfo accessibilityNodeInfo4 = accessibilityNodeInfo;
                                                    Resources resources3 = resources;
                                                    j = spanStyle.background;
                                                    textDecoration = spanStyle.textDecoration;
                                                    colorStyle = spanStyle.textForegroundStyle;
                                                    MutableScatterMap mutableScatterMap4 = mutableScatterMap;
                                                    if (!Color.m435equalsimpl0(jMo668getColor0d7_KjU, colorStyle.mo668getColor0d7_KjU())) {
                                                        if (jMo668getColor0d7_KjU != 16) {
                                                            colorStyle = new ColorStyle(jMo668getColor0d7_KjU);
                                                        } else {
                                                            colorStyle = TextForegroundStyle.Unspecified.INSTANCE;
                                                        }
                                                    }
                                                    zztz.m817setColorRPmYEkk(spannableString2, colorStyle.mo668getColor0d7_KjU(), i25, i26);
                                                    spannableString4 = spannableString2;
                                                    zztz.m818setFontSizeKmRG4DE(spannableString4, j2, density, i25, i26);
                                                    if (fontWeight == null || fontStyle != null) {
                                                        if (fontWeight == null) {
                                                            fontWeight2 = FontWeight.Normal;
                                                        } else {
                                                            fontWeight2 = fontWeight;
                                                        }
                                                        if (fontStyle != null) {
                                                            i27 = fontStyle.value;
                                                        } else {
                                                            i27 = 0;
                                                        }
                                                        StyleSpan styleSpan = new StyleSpan(AndroidFontUtils_androidKt.m655getAndroidTypefaceStyleFO1MlWM(fontWeight2, i27));
                                                        i28 = 33;
                                                        spannableString4.setSpan(styleSpan, i25, i26, 33);
                                                    } else {
                                                        i28 = 33;
                                                    }
                                                    if (textDecoration != null) {
                                                        i29 = textDecoration.mask;
                                                        if ((i29 | 1) == i29) {
                                                            spannableString4.setSpan(new UnderlineSpan(), i25, i26, i28);
                                                        }
                                                        if ((i29 | 2) == i29) {
                                                            spannableString4.setSpan(new StrikethroughSpan(), i25, i26, i28);
                                                        }
                                                    }
                                                    if (textGeometricTransform != null) {
                                                        spannableString4.setSpan(new ScaleXSpan(textGeometricTransform.scaleX), i25, i26, i28);
                                                    }
                                                    zztz.setLocaleList(spannableString4, localeList, i25, i26);
                                                    if (j != 16) {
                                                        spannableString4.setSpan(new BackgroundColorSpan(BrushKt.m426toArgb8_81llA(j)), i25, i26, i28);
                                                    }
                                                    i24 = i35 + 1;
                                                    spannableString2 = spannableString4;
                                                    arrayList3 = arrayList7;
                                                    size9 = i36;
                                                    mutableIntIntMap = mutableIntIntMap3;
                                                    semanticsConfiguration = semanticsConfiguration5;
                                                    semanticsNode5 = semanticsNode6;
                                                    role = role4;
                                                    resources = resources3;
                                                    accessibilityNodeInfo = accessibilityNodeInfo4;
                                                    mutableScatterMap = mutableScatterMap4;
                                                }
                                            }
                                            role2 = role;
                                            semanticsConfiguration2 = semanticsConfiguration;
                                            mutableIntIntMap2 = mutableIntIntMap;
                                            semanticsNode = semanticsNode5;
                                            spannableString3 = spannableString2;
                                            accessibilityNodeInfo2 = accessibilityNodeInfo;
                                            resources2 = resources;
                                            mutableScatterMap2 = mutableScatterMap;
                                            int length = str4.length();
                                            arrayList4 = EmptyList.INSTANCE;
                                            if (list4 != null) {
                                                arrayList5 = new ArrayList(list4.size());
                                                size8 = list4.size();
                                                while (i23 < size8) {
                                                    Object obj14 = list4.get(i23);
                                                    range5 = (AnnotatedString.Range) obj14;
                                                    if (!(range5.item instanceof VerbatimTtsAnnotation) && AnnotatedStringKt.intersect(0, length, range5.start, range5.end)) {
                                                        arrayList5.add(obj14);
                                                    }
                                                }
                                            } else {
                                                arrayList5 = arrayList4;
                                            }
                                            size3 = arrayList5.size();
                                            while (i14 < size3) {
                                                AnnotatedString.Range range7 = (AnnotatedString.Range) arrayList5.get(i14);
                                                verbatimTtsAnnotation = (VerbatimTtsAnnotation) range7.item;
                                                i21 = range7.start;
                                                i22 = range7.end;
                                                if (verbatimTtsAnnotation instanceof VerbatimTtsAnnotation) {
                                                    throw new HttpException();
                                                }
                                                spannableString3.setSpan(new TtsSpan.VerbatimBuilder(verbatimTtsAnnotation.verbatim).build(), i21, i22, 33);
                                            }
                                            int length2 = str4.length();
                                            if (list4 != null) {
                                                arrayList6 = new ArrayList(list4.size());
                                                size7 = list4.size();
                                                while (i20 < size7) {
                                                    Object obj15 = list4.get(i20);
                                                    range4 = (AnnotatedString.Range) obj15;
                                                    if (!(range4.item instanceof UrlAnnotation) && AnnotatedStringKt.intersect(0, length2, range4.start, range4.end)) {
                                                        arrayList6.add(obj15);
                                                    }
                                                }
                                            } else {
                                                arrayList6 = arrayList4;
                                            }
                                            size4 = arrayList6.size();
                                            while (i15 < size4) {
                                                AnnotatedString.Range range8 = (AnnotatedString.Range) arrayList6.get(i15);
                                                urlAnnotation = (UrlAnnotation) range8.item;
                                                int i37 = range8.start;
                                                int i38 = range8.end;
                                                weakHashMap3 = (WeakHashMap) menuHostHelper.mOnInvalidateMenuCallback;
                                                uRLSpan2 = weakHashMap3.get(urlAnnotation);
                                                if (uRLSpan2 == null) {
                                                    uRLSpan2 = new URLSpan(urlAnnotation.url);
                                                    weakHashMap3.put(urlAnnotation, uRLSpan2);
                                                }
                                                spannableString3.setSpan((URLSpan) uRLSpan2, i37, i38, 33);
                                            }
                                            int length3 = str4.length();
                                            if (list4 != null) {
                                                arrayList4 = new ArrayList(list4.size());
                                                size6 = list4.size();
                                                while (i19 < size6) {
                                                    Object obj16 = list4.get(i19);
                                                    range3 = (AnnotatedString.Range) obj16;
                                                    if (!(range3.item instanceof LinkAnnotation) && AnnotatedStringKt.intersect(0, length3, range3.start, range3.end)) {
                                                        arrayList4.add(obj16);
                                                    }
                                                }
                                            }
                                            size5 = arrayList4.size();
                                            while (i16 < size5) {
                                                range = (AnnotatedString.Range) arrayList4.get(i16);
                                                i17 = range.start;
                                                obj11 = range.item;
                                                i18 = range.end;
                                                if (i17 != i18) {
                                                    linkAnnotation = (LinkAnnotation) obj11;
                                                    if (linkAnnotation instanceof LinkAnnotation.Url) {
                                                        url = (LinkAnnotation.Url) obj11;
                                                        range2 = new AnnotatedString.Range(i17, i18, url);
                                                        weakHashMap2 = (WeakHashMap) menuHostHelper.mMenuProviders;
                                                        uRLSpan = weakHashMap2.get(range2);
                                                        if (uRLSpan == null) {
                                                            uRLSpan = new URLSpan(url.url);
                                                            weakHashMap2.put(range2, uRLSpan);
                                                        }
                                                        spannableString3.setSpan((URLSpan) uRLSpan, i17, i18, 33);
                                                    } else {
                                                        weakHashMap = (WeakHashMap) menuHostHelper.mProviderToLifecycleContainers;
                                                        composeClickableSpan = weakHashMap.get(range);
                                                        if (composeClickableSpan == null) {
                                                            composeClickableSpan = new ComposeClickableSpan(linkAnnotation);
                                                            weakHashMap.put(range, composeClickableSpan);
                                                        }
                                                        spannableString3.setSpan((ClickableSpan) composeClickableSpan, i17, i18, 33);
                                                    }
                                                }
                                            }
                                            spannableString = (SpannableString) AndroidComposeViewAccessibilityDelegateCompat.trimToSize(spannableString3);
                                        } else {
                                            role2 = role;
                                            semanticsConfiguration2 = semanticsConfiguration;
                                            androidComposeViewAccessibilityDelegateCompat2 = androidComposeViewAccessibilityDelegateCompat2;
                                            mutableIntIntMap2 = mutableIntIntMap;
                                            semanticsNode = semanticsNode5;
                                            accessibilityNodeInfo2 = accessibilityNodeInfo;
                                            resources2 = resources;
                                            mutableScatterMap2 = mutableScatterMap;
                                            spannableString = null;
                                        }
                                        accessibilityNodeInfoCompat.setText(spannableString);
                                        semanticsPropertyKey = SemanticsProperties.Error;
                                        mutableScatterMap3 = mutableScatterMap2;
                                        if (mutableScatterMap3.containsKey(semanticsPropertyKey)) {
                                            accessibilityNodeInfoObtain.setContentInvalid(true);
                                            obj10 = mutableScatterMap3.get(semanticsPropertyKey);
                                            if (obj10 == null) {
                                                obj10 = null;
                                            }
                                            accessibilityNodeInfo3 = accessibilityNodeInfo2;
                                            accessibilityNodeInfo3.setError((CharSequence) obj10);
                                        } else {
                                            accessibilityNodeInfo3 = accessibilityNodeInfo2;
                                        }
                                        semanticsNode2 = semanticsNode;
                                        Resources resources4 = resources2;
                                        infoStateDescriptionOrNull = InvertMatrixKt.getInfoStateDescriptionOrNull(semanticsNode2, resources4);
                                        if (Build.VERSION.SDK_INT >= 30) {
                                            WindowCompat.Api30Impl.setStateDescription(accessibilityNodeInfo3, infoStateDescriptionOrNull);
                                        } else {
                                            accessibilityNodeInfo3.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", infoStateDescriptionOrNull);
                                        }
                                        accessibilityNodeInfo3.setCheckable(InvertMatrixKt.getInfoIsCheckable(semanticsNode2));
                                        obj2 = mutableScatterMap3.get(SemanticsProperties.ToggleableState);
                                        if (obj2 == null) {
                                            obj2 = null;
                                        }
                                        toggleableState = (ToggleableState) obj2;
                                        if (toggleableState != null) {
                                            if (toggleableState == ToggleableState.On) {
                                                accessibilityNodeInfo3.setChecked(true);
                                            } else if (toggleableState == ToggleableState.Off) {
                                                accessibilityNodeInfo3.setChecked(false);
                                            }
                                            Unit unit3 = Unit.INSTANCE;
                                        }
                                        obj3 = mutableScatterMap3.get(SemanticsProperties.Selected);
                                        if (obj3 == null) {
                                            obj3 = null;
                                        }
                                        bool = (Boolean) obj3;
                                        if (bool != null) {
                                            zBooleanValue2 = bool.booleanValue();
                                            if (role2 == null) {
                                                role3 = role2;
                                                i5 = 4;
                                            } else {
                                                role3 = role2;
                                                i5 = 4;
                                                if (role3.value == 4) {
                                                    accessibilityNodeInfoObtain.setSelected(zBooleanValue2);
                                                }
                                                Unit unit4 = Unit.INSTANCE;
                                            }
                                            accessibilityNodeInfo3.setChecked(zBooleanValue2);
                                            Unit unit5 = Unit.INSTANCE;
                                        } else {
                                            role3 = role2;
                                            i5 = 4;
                                        }
                                        semanticsConfiguration3 = semanticsConfiguration2;
                                        if (semanticsConfiguration3.isMergingSemanticsOfDescendants || SemanticsNode.getChildren$ui$default(i5, semanticsNode2).isEmpty()) {
                                            obj4 = mutableScatterMap3.get(SemanticsProperties.ContentDescription);
                                            if (obj4 == null) {
                                                obj4 = null;
                                            }
                                            list = (List) obj4;
                                            if (list != null) {
                                                str = (String) CollectionsKt.firstOrNull(list);
                                            } else {
                                                str = null;
                                            }
                                            accessibilityNodeInfo3.setContentDescription(str);
                                        }
                                        obj5 = mutableScatterMap3.get(SemanticsProperties.TestTag);
                                        if (obj5 == null) {
                                            obj5 = null;
                                        }
                                        str2 = (String) obj5;
                                        if (str2 != null) {
                                            parent3 = semanticsNode2;
                                            while (true) {
                                                if (parent3 != null) {
                                                    semanticsConfiguration4 = parent3.unmergedConfig;
                                                    semanticsPropertyKey5 = SemanticsPropertiesAndroid.TestTagsAsResourceId;
                                                    if (semanticsConfiguration4.props.containsKey(semanticsPropertyKey5)) {
                                                        zBooleanValue = ((Boolean) semanticsConfiguration4.get(semanticsPropertyKey5)).booleanValue();
                                                    } else {
                                                        parent3 = parent3.getParent();
                                                    }
                                                } else {
                                                    zBooleanValue = false;
                                                }
                                            }
                                            if (zBooleanValue) {
                                                accessibilityNodeInfoObtain.setViewIdResourceName(str2);
                                            }
                                        }
                                        if (((Unit) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsProperties.Heading)) != null) {
                                            if (Build.VERSION.SDK_INT >= 28) {
                                                accessibilityNodeInfo3.setHeading(true);
                                            } else {
                                                accessibilityNodeInfoCompat.setBooleanProperty(2, true);
                                            }
                                            Unit unit6 = Unit.INSTANCE;
                                        }
                                        if (((Unit) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsProperties.TextEntryKey)) != null) {
                                            if (Build.VERSION.SDK_INT >= 29) {
                                                accessibilityNodeInfoObtain.setTextEntryKey(true);
                                            } else {
                                                accessibilityNodeInfoCompat.setBooleanProperty(8, true);
                                            }
                                            Unit unit7 = Unit.INSTANCE;
                                        }
                                        i6 = i;
                                        if (i6 != -1) {
                                            orDefault3 = mutableIntIntMap2.getOrDefault(semanticsNode2.id, -1);
                                            if (orDefault3 != -1) {
                                                if (Build.VERSION.SDK_INT >= 24) {
                                                    accessibilityNodeInfoObtain.setDrawingOrder(orDefault3);
                                                }
                                                Unit unit8 = Unit.INSTANCE;
                                            } else {
                                                Log.w("AccessibilityDelegate", "Drawing order is not available, was AccessibilityNodeInfo requested for a child node before its parent?");
                                            }
                                        }
                                        accessibilityNodeInfoObtain.setPassword(mutableScatterMap3.containsKey(SemanticsProperties.Password));
                                        Object orNull = SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsProperties.IsEditable);
                                        bool2 = Boolean.TRUE;
                                        accessibilityNodeInfoObtain.setEditable(Intrinsics.areEqual(orNull, bool2));
                                        num = (Integer) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsProperties.MaxTextLength);
                                        if (num != null) {
                                            iIntValue2 = num.intValue();
                                        } else {
                                            iIntValue2 = -1;
                                        }
                                        accessibilityNodeInfo3.setMaxTextLength(iIntValue2);
                                        accessibilityNodeInfo3.setEnabled(InvertMatrixKt.access$enabled(semanticsNode2));
                                        semanticsPropertyKey2 = SemanticsProperties.Focused;
                                        accessibilityNodeInfo3.setFocusable(mutableScatterMap3.containsKey(semanticsPropertyKey2));
                                        if (accessibilityNodeInfoObtain.isFocusable()) {
                                            accessibilityNodeInfo3.setFocused(((Boolean) semanticsConfiguration3.get(semanticsPropertyKey2)).booleanValue());
                                            if (accessibilityNodeInfoObtain.isFocused()) {
                                                accessibilityNodeInfoCompat.addAction(2);
                                                androidComposeViewAccessibilityDelegateCompat = androidComposeViewAccessibilityDelegateCompat2;
                                                androidComposeViewAccessibilityDelegateCompat.focusedVirtualViewId = i6;
                                            } else {
                                                androidComposeViewAccessibilityDelegateCompat = androidComposeViewAccessibilityDelegateCompat2;
                                                z2 = true;
                                                accessibilityNodeInfoCompat.addAction(1);
                                            }
                                            accessibilityNodeInfo3.setVisibleToUser(SemanticsNodeKt.isHidden(semanticsNode2) ^ z2);
                                            if (semanticsNode2.isFake$ui()) {
                                                parent2 = semanticsNode2.getParent();
                                            } else {
                                                parent2 = semanticsNode2;
                                            }
                                            if (parent2.getTouchBoundsInRoot().isEmpty()) {
                                                accessibilityNodeInfo3.setVisibleToUser(false);
                                            }
                                            liveRegionMode = (LiveRegionMode) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsProperties.LiveRegion);
                                            if (liveRegionMode != null) {
                                                i12 = liveRegionMode.value;
                                                if (i12 == 0) {
                                                    z15 = true;
                                                } else {
                                                    z15 = false;
                                                }
                                                if (z15) {
                                                    if (i12 == 1) {
                                                        z16 = true;
                                                    } else {
                                                        z16 = false;
                                                    }
                                                    if (z16) {
                                                        i13 = 2;
                                                    } else {
                                                        i13 = 1;
                                                    }
                                                } else {
                                                    i13 = 1;
                                                }
                                                accessibilityNodeInfoObtain.setLiveRegion(i13);
                                                Unit unit9 = Unit.INSTANCE;
                                            }
                                            accessibilityNodeInfo3.setClickable(false);
                                            accessibilityAction = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsActions.OnClick);
                                            c = 3;
                                            if (accessibilityAction != null) {
                                                boolean zAreEqual3 = Intrinsics.areEqual(SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsProperties.Selected), bool2);
                                                if (role3 == null && role3.value == 4) {
                                                    z11 = true;
                                                } else {
                                                    z11 = false;
                                                }
                                                if (z11) {
                                                    z12 = true;
                                                } else {
                                                    if (role3 == null && role3.value == 3) {
                                                        z14 = true;
                                                    } else {
                                                        z14 = false;
                                                    }
                                                    if (z14) {
                                                        z12 = true;
                                                    } else {
                                                        z12 = false;
                                                    }
                                                }
                                                if (z12 || (z12 && !zAreEqual3)) {
                                                    z13 = true;
                                                } else {
                                                    z13 = false;
                                                }
                                                accessibilityNodeInfo3.setClickable(z13);
                                                if (InvertMatrixKt.access$enabled(semanticsNode2) && accessibilityNodeInfoObtain.isClickable()) {
                                                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction.label, 16));
                                                }
                                                Unit unit10 = Unit.INSTANCE;
                                            }
                                            accessibilityNodeInfo3.setLongClickable(false);
                                            accessibilityAction2 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsActions.OnLongClick);
                                            if (accessibilityAction2 != null) {
                                                accessibilityNodeInfo3.setLongClickable(true);
                                                if (InvertMatrixKt.access$enabled(semanticsNode2)) {
                                                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction2.label, 32));
                                                }
                                                Unit unit11 = Unit.INSTANCE;
                                            }
                                            accessibilityAction3 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsActions.CopyText);
                                            if (accessibilityAction3 != null) {
                                                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction3.label, 16384));
                                                Unit unit12 = Unit.INSTANCE;
                                            }
                                            if (InvertMatrixKt.access$enabled(semanticsNode2)) {
                                                accessibilityAction8 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsActions.SetText);
                                                if (accessibilityAction8 != null) {
                                                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction8.label, 2097152));
                                                    Unit unit13 = Unit.INSTANCE;
                                                }
                                                accessibilityAction9 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsActions.OnImeAction);
                                                if (accessibilityAction9 != null) {
                                                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction9.getLabel(), android.R.id.accessibilityActionImeEnter));
                                                    Unit unit14 = Unit.INSTANCE;
                                                }
                                                accessibilityAction10 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsActions.CutText);
                                                if (accessibilityAction10 != null) {
                                                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction10.getLabel(), 65536));
                                                    Unit unit15 = Unit.INSTANCE;
                                                }
                                                accessibilityAction11 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsActions.PasteText);
                                                if (accessibilityAction11 != null) {
                                                    if (accessibilityNodeInfo3.isFocused()) {
                                                        primaryClipDescription = androidComposeView2.m598getClipboardManager().getClipboardManager().getPrimaryClipDescription();
                                                        if (primaryClipDescription != null) {
                                                            zHasMimeType = primaryClipDescription.hasMimeType("text/*");
                                                        } else {
                                                            zHasMimeType = false;
                                                        }
                                                        if (zHasMimeType) {
                                                            accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction11.getLabel(), 32768));
                                                        }
                                                    }
                                                    Unit unit16 = Unit.INSTANCE;
                                                }
                                            }
                                            iterableTextForAccessibility = AndroidComposeViewAccessibilityDelegateCompat.getIterableTextForAccessibility(semanticsNode2);
                                            if (iterableTextForAccessibility != null || iterableTextForAccessibility.length() == 0) {
                                                z3 = true;
                                            } else {
                                                z3 = false;
                                            }
                                            if (!z3) {
                                                accessibilityNodeInfo3.setTextSelection(androidComposeViewAccessibilityDelegateCompat.getAccessibilitySelectionStart(semanticsNode2), androidComposeViewAccessibilityDelegateCompat.getAccessibilitySelectionEnd(semanticsNode2));
                                                accessibilityAction7 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsActions.SetSelection);
                                                if (accessibilityAction7 != null) {
                                                    label = accessibilityAction7.getLabel();
                                                } else {
                                                    label = null;
                                                }
                                                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(label, 131072));
                                                accessibilityNodeInfoCompat.addAction(256);
                                                accessibilityNodeInfoCompat.addAction(512);
                                                accessibilityNodeInfo3.setMovementGranularities(11);
                                                list3 = (List) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsProperties.ContentDescription);
                                                if (list3 != null || list3.isEmpty()) {
                                                    z10 = true;
                                                } else {
                                                    z10 = false;
                                                }
                                                if (z10 && semanticsNode2.getUnmergedConfig$ui().contains(SemanticsActions.GetTextLayoutResult) && !InvertMatrixKt.access$excludeLineAndPageGranularities(semanticsNode2)) {
                                                    accessibilityNodeInfo3.setMovementGranularities(accessibilityNodeInfo3.getMovementGranularities() | 20);
                                                }
                                            }
                                            if (Build.VERSION.SDK_INT >= 26) {
                                                arrayList2 = new ArrayList();
                                                arrayList2.add("androidx.compose.ui.semantics.id");
                                                text = accessibilityNodeInfoCompat.getText();
                                                if (text != null || text.length() == 0) {
                                                    z9 = true;
                                                } else {
                                                    z9 = false;
                                                }
                                                if (!z9 && semanticsNode2.getUnmergedConfig$ui().contains(SemanticsActions.GetTextLayoutResult)) {
                                                    arrayList2.add("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY");
                                                }
                                                if (semanticsNode2.getUnmergedConfig$ui().contains(SemanticsProperties.TestTag)) {
                                                    arrayList2.add("androidx.compose.ui.semantics.testTag");
                                                }
                                                if (semanticsNode2.getUnmergedConfig$ui().contains(SemanticsProperties.Shape)) {
                                                    arrayList2.add("androidx.compose.ui.semantics.shapeType");
                                                    arrayList2.add("androidx.compose.ui.semantics.shapeRect");
                                                    arrayList2.add("androidx.compose.ui.semantics.shapeCorners");
                                                    arrayList2.add("androidx.compose.ui.semantics.shapeRegion");
                                                }
                                                semanticsNode2.getUnmergedConfig$ui().getClass();
                                                if (Build.VERSION.SDK_INT >= 26) {
                                                    accessibilityNodeInfo3.setAvailableExtraData(arrayList2);
                                                }
                                            }
                                            progressBarRangeInfo = (ProgressBarRangeInfo) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsProperties.ProgressBarRangeInfo);
                                            if (progressBarRangeInfo != null) {
                                                unmergedConfig$ui2 = semanticsNode2.getUnmergedConfig$ui();
                                                semanticsPropertyKey4 = SemanticsActions.SetProgress;
                                                if (unmergedConfig$ui2.contains(semanticsPropertyKey4)) {
                                                    accessibilityNodeInfoCompat.setClassName("android.widget.SeekBar");
                                                } else {
                                                    accessibilityNodeInfoCompat.setClassName("android.widget.ProgressBar");
                                                }
                                                ProgressBarRangeInfo progressBarRangeInfo2 = ProgressBarRangeInfo.Indeterminate;
                                                if (progressBarRangeInfo != ProgressBarRangeInfo.Indeterminate) {
                                                    progressBarRangeInfo.getRange().getClass();
                                                    float fFloatValue5 = fValueOf.floatValue();
                                                    progressBarRangeInfo.getRange().getClass();
                                                    accessibilityNodeInfo3.setRangeInfo((AccessibilityNodeInfo.RangeInfo) new ExposureStateImpl(AccessibilityNodeInfo.RangeInfo.obtain(1, fFloatValue5, fValueOf.floatValue(), 0.0f)).mLock);
                                                }
                                                if (semanticsNode2.getUnmergedConfig$ui().contains(semanticsPropertyKey4) && InvertMatrixKt.access$enabled(semanticsNode2)) {
                                                    progressBarRangeInfo.getRange().getClass();
                                                    fFloatValue = fValueOf.floatValue();
                                                    progressBarRangeInfo.getRange().getClass();
                                                    fFloatValue2 = fValueOf.floatValue();
                                                    if (fFloatValue < fFloatValue2) {
                                                        fFloatValue = fFloatValue2;
                                                    }
                                                    if (0.0f < fFloatValue) {
                                                        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                                                    }
                                                    progressBarRangeInfo.getRange().getClass();
                                                    fFloatValue3 = fValueOf.floatValue();
                                                    progressBarRangeInfo.getRange().getClass();
                                                    fFloatValue4 = fValueOf.floatValue();
                                                    if (fFloatValue3 > fFloatValue4) {
                                                        fFloatValue3 = fFloatValue4;
                                                    }
                                                    if (0.0f > fFloatValue3) {
                                                        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                                                    }
                                                }
                                            }
                                            i7 = Build.VERSION.SDK_INT;
                                            if (i7 >= 24) {
                                                InvertMatrixKt.addSetProgressAction(semanticsNode2, accessibilityNodeInfoCompat);
                                            }
                                            zztj.setCollectionInfo(semanticsNode2, accessibilityNodeInfoCompat);
                                            zztj.setCollectionItemInfo(semanticsNode2, accessibilityNodeInfoCompat);
                                            scrollAxisRange = (ScrollAxisRange) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsProperties.HorizontalScrollAxisRange);
                                            AccessibilityAction accessibilityAction12 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsActions.ScrollBy);
                                            if (scrollAxisRange != null && accessibilityAction12 != null) {
                                                obj8 = semanticsNode2.getConfig().props.get(SemanticsProperties.CollectionInfo);
                                                if (obj8 == null) {
                                                    obj8 = null;
                                                }
                                                if (obj8 == null) {
                                                    obj9 = semanticsNode2.getConfig().props.get(SemanticsProperties.SelectableGroup);
                                                    if (obj9 == null) {
                                                        obj9 = null;
                                                    }
                                                    if (obj9 != null) {
                                                        z6 = true;
                                                    } else {
                                                        z6 = false;
                                                    }
                                                } else {
                                                    z6 = true;
                                                }
                                                if (!z6) {
                                                    accessibilityNodeInfoCompat.setClassName("android.widget.HorizontalScrollView");
                                                }
                                                if (((Number) scrollAxisRange.maxValue.invoke()).floatValue() > 0.0f) {
                                                    accessibilityNodeInfo3.setScrollable(true);
                                                }
                                                if (InvertMatrixKt.access$enabled(semanticsNode2)) {
                                                    zPopulateAccessibilityNodeInfoProperties$canScrollForward = AndroidComposeViewAccessibilityDelegateCompat.populateAccessibilityNodeInfoProperties$canScrollForward(scrollAxisRange);
                                                    layoutDirection = LayoutDirection.Rtl;
                                                    if (zPopulateAccessibilityNodeInfoProperties$canScrollForward) {
                                                        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                                                        layoutNode = layoutNode2;
                                                        if (layoutNode.layoutDirection == layoutDirection) {
                                                            z8 = true;
                                                        } else {
                                                            z8 = false;
                                                        }
                                                        if (z8) {
                                                            accessibilityActionCompat2 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT;
                                                        } else {
                                                            accessibilityActionCompat2 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT;
                                                        }
                                                        accessibilityNodeInfoCompat.addAction(accessibilityActionCompat2);
                                                    } else {
                                                        layoutNode = layoutNode2;
                                                    }
                                                    if (AndroidComposeViewAccessibilityDelegateCompat.populateAccessibilityNodeInfoProperties$canScrollBackward(scrollAxisRange)) {
                                                        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                                                        if (layoutNode.layoutDirection == layoutDirection) {
                                                            z7 = true;
                                                        } else {
                                                            z7 = false;
                                                        }
                                                        if (z7) {
                                                            accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT;
                                                        } else {
                                                            accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT;
                                                        }
                                                        accessibilityNodeInfoCompat.addAction(accessibilityActionCompat);
                                                    }
                                                }
                                            }
                                            scrollAxisRange2 = (ScrollAxisRange) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsProperties.VerticalScrollAxisRange);
                                            if (scrollAxisRange2 != null && accessibilityAction12 != null) {
                                                obj6 = semanticsNode2.getConfig().props.get(SemanticsProperties.CollectionInfo);
                                                if (obj6 == null) {
                                                    obj6 = null;
                                                }
                                                if (obj6 == null) {
                                                    obj7 = semanticsNode2.getConfig().props.get(SemanticsProperties.SelectableGroup);
                                                    if (obj7 == null) {
                                                        obj7 = null;
                                                    }
                                                    if (obj7 != null) {
                                                        z5 = true;
                                                    } else {
                                                        z5 = false;
                                                    }
                                                } else {
                                                    z5 = true;
                                                }
                                                if (!z5) {
                                                    accessibilityNodeInfoCompat.setClassName("android.widget.ScrollView");
                                                }
                                                if (((Number) scrollAxisRange2.maxValue.invoke()).floatValue() > 0.0f) {
                                                    accessibilityNodeInfo3.setScrollable(true);
                                                }
                                                if (InvertMatrixKt.access$enabled(semanticsNode2)) {
                                                    if (AndroidComposeViewAccessibilityDelegateCompat.populateAccessibilityNodeInfoProperties$canScrollForward(scrollAxisRange2)) {
                                                        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                                                        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
                                                    }
                                                    if (AndroidComposeViewAccessibilityDelegateCompat.populateAccessibilityNodeInfoProperties$canScrollBackward(scrollAxisRange2)) {
                                                        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                                                        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
                                                    }
                                                }
                                            }
                                            if (i7 >= 29) {
                                                InvertMatrixKt.addPageActions(semanticsNode2, accessibilityNodeInfoCompat);
                                            }
                                            charSequence = (CharSequence) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsProperties.PaneTitle);
                                            if (i7 >= 28) {
                                                accessibilityNodeInfo3.setPaneTitle(charSequence);
                                            } else {
                                                accessibilityNodeInfo3.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
                                            }
                                            if (InvertMatrixKt.access$enabled(semanticsNode2)) {
                                                accessibilityAction4 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsActions.Expand);
                                                if (accessibilityAction4 != null) {
                                                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction4.getLabel(), 262144));
                                                    Unit unit17 = Unit.INSTANCE;
                                                }
                                                accessibilityAction5 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsActions.Collapse);
                                                if (accessibilityAction5 != null) {
                                                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction5.getLabel(), 524288));
                                                    Unit unit18 = Unit.INSTANCE;
                                                }
                                                accessibilityAction6 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsActions.Dismiss);
                                                if (accessibilityAction6 != null) {
                                                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction6.getLabel(), 1048576));
                                                    Unit unit19 = Unit.INSTANCE;
                                                }
                                                unmergedConfig$ui = semanticsNode2.getUnmergedConfig$ui();
                                                semanticsPropertyKey3 = SemanticsActions.CustomActions;
                                                if (unmergedConfig$ui.contains(semanticsPropertyKey3)) {
                                                    list2 = (List) semanticsNode2.getUnmergedConfig$ui().get(semanticsPropertyKey3);
                                                    size2 = list2.size();
                                                    mutableIntList = AndroidComposeViewAccessibilityDelegateCompat.AccessibilityActionsResourceIds;
                                                    if (size2 < mutableIntList._size) {
                                                        throw new IllegalStateException(ImageAnalysis$$ExternalSyntheticLambda1.m(new StringBuilder("Can't have more than "), mutableIntList._size, " custom actions for one widget"));
                                                    }
                                                    SparseArrayCompat sparseArrayCompat4 = new SparseArrayCompat(0);
                                                    MutableObjectIntMap mutableObjectIntMapMutableObjectIntMapOf = ObjectIntMapKt.mutableObjectIntMapOf();
                                                    sparseArrayCompat3 = sparseArrayCompat2;
                                                    if (sparseArrayCompat3.garbage) {
                                                        ArraySetKt.access$gc(sparseArrayCompat3);
                                                    }
                                                    if (RuntimeHelpersKt.binarySearch(sparseArrayCompat3.size, i6, sparseArrayCompat3.keys) >= 0) {
                                                        z4 = true;
                                                    } else {
                                                        z4 = false;
                                                    }
                                                    if (z4) {
                                                        iArr = mutableIntList.content;
                                                        i8 = mutableIntList._size;
                                                        iArrCopyOf = new int[16];
                                                        i9 = 0;
                                                        i10 = 0;
                                                        while (i9 < i8) {
                                                            int i39 = iArr[i9];
                                                            char c2 = c;
                                                            i11 = i10 + 1;
                                                            int i40 = i8;
                                                            if (iArrCopyOf.length < i11) {
                                                                iArrCopyOf = Arrays.copyOf(iArrCopyOf, Math.max(i11, (iArrCopyOf.length * 3) / 2));
                                                            }
                                                            iArrCopyOf[i10] = i39;
                                                            i9++;
                                                            i10 = i11;
                                                            c = c2;
                                                            i8 = i40;
                                                        }
                                                        arrayList = new ArrayList();
                                                        if (list2.size() <= 0) {
                                                            Modifier.CC.m(list2.get(0));
                                                            throw null;
                                                        }
                                                        if (arrayList.size() > 0) {
                                                            Modifier.CC.m(arrayList.get(0));
                                                            if (i10 > 0) {
                                                                int i41 = iArrCopyOf[0];
                                                                throw null;
                                                            }
                                                            RuntimeHelpersKt.throwIndexOutOfBoundsException("Index must be between 0 and size");
                                                            throw null;
                                                        }
                                                    } else if (list2.size() > 0) {
                                                        Modifier.CC.m(list2.get(0));
                                                        mutableIntList.get(0);
                                                        throw null;
                                                    }
                                                    androidComposeViewAccessibilityDelegateCompat.actionIdToLabel.put(i6, sparseArrayCompat4);
                                                    sparseArrayCompat3.put(i6, mutableObjectIntMapMutableObjectIntMapOf);
                                                }
                                            }
                                            zAccess$isScreenReaderFocusable = InvertMatrixKt.access$isScreenReaderFocusable(semanticsNode2, resources4);
                                            if (Build.VERSION.SDK_INT >= 28) {
                                                accessibilityNodeInfo3.setScreenReaderFocusable(zAccess$isScreenReaderFocusable);
                                            } else {
                                                accessibilityNodeInfoCompat.setBooleanProperty(1, zAccess$isScreenReaderFocusable);
                                            }
                                            orDefault = androidComposeViewAccessibilityDelegateCompat.idToBeforeMap.getOrDefault(i6, -1);
                                            if (orDefault != -1) {
                                                InvertMatrixKt.semanticsIdToView(androidComposeView2.getAndroidViewsHandler$ui(), orDefault);
                                                androidComposeView = androidComposeView2;
                                                accessibilityNodeInfo3.setTraversalBefore(androidComposeView, orDefault);
                                                androidComposeViewAccessibilityDelegateCompat.addExtraDataToAccessibilityNodeInfoHelper(i6, accessibilityNodeInfoCompat, androidComposeViewAccessibilityDelegateCompat.ExtraDataTestTraversalBeforeVal, null);
                                            } else {
                                                androidComposeView = androidComposeView2;
                                            }
                                            orDefault2 = androidComposeViewAccessibilityDelegateCompat.idToAfterMap.getOrDefault(i6, -1);
                                            if (orDefault2 != -1) {
                                                InvertMatrixKt.semanticsIdToView(androidComposeView.getAndroidViewsHandler$ui(), orDefault2);
                                            }
                                            str3 = (String) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsPropertiesAndroid.AccessibilityClassName);
                                            if (str3 != null) {
                                                accessibilityNodeInfoCompat.setClassName(str3);
                                                Unit unit20 = Unit.INSTANCE;
                                            }
                                            accessibilityNodeInfoCompat2 = accessibilityNodeInfoCompat;
                                        } else {
                                            androidComposeViewAccessibilityDelegateCompat = androidComposeViewAccessibilityDelegateCompat2;
                                        }
                                        z2 = true;
                                        accessibilityNodeInfo3.setVisibleToUser(SemanticsNodeKt.isHidden(semanticsNode2) ^ z2);
                                        if (semanticsNode2.isFake$ui()) {
                                            parent2 = semanticsNode2.getParent();
                                        } else {
                                            parent2 = semanticsNode2;
                                        }
                                        if (parent2.getTouchBoundsInRoot().isEmpty()) {
                                            accessibilityNodeInfo3.setVisibleToUser(false);
                                        }
                                        liveRegionMode = (LiveRegionMode) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsProperties.LiveRegion);
                                        if (liveRegionMode != null) {
                                            i12 = liveRegionMode.value;
                                            if (i12 == 0) {
                                                z15 = true;
                                            } else {
                                                z15 = false;
                                            }
                                            if (z15) {
                                                if (i12 == 1) {
                                                    z16 = true;
                                                } else {
                                                    z16 = false;
                                                }
                                                if (z16) {
                                                    i13 = 2;
                                                } else {
                                                    i13 = 1;
                                                }
                                            } else {
                                                i13 = 1;
                                            }
                                            accessibilityNodeInfoObtain.setLiveRegion(i13);
                                            Unit unit21 = Unit.INSTANCE;
                                        }
                                        accessibilityNodeInfo3.setClickable(false);
                                        accessibilityAction = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsActions.OnClick);
                                        c = 3;
                                        if (accessibilityAction != null) {
                                            boolean zAreEqual4 = Intrinsics.areEqual(SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsProperties.Selected), bool2);
                                            if (role3 == null) {
                                                z11 = false;
                                            } else {
                                                z11 = true;
                                            }
                                            if (z11) {
                                                z12 = true;
                                            } else {
                                                if (role3 == null) {
                                                    z14 = false;
                                                } else {
                                                    z14 = true;
                                                }
                                                if (z14) {
                                                    z12 = true;
                                                } else {
                                                    z12 = false;
                                                }
                                            }
                                            if (z12) {
                                                z13 = true;
                                            } else {
                                                z13 = true;
                                            }
                                            accessibilityNodeInfo3.setClickable(z13);
                                            if (InvertMatrixKt.access$enabled(semanticsNode2)) {
                                                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction.label, 16));
                                            }
                                            Unit unit110 = Unit.INSTANCE;
                                        }
                                        accessibilityNodeInfo3.setLongClickable(false);
                                        accessibilityAction2 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsActions.OnLongClick);
                                        if (accessibilityAction2 != null) {
                                            accessibilityNodeInfo3.setLongClickable(true);
                                            if (InvertMatrixKt.access$enabled(semanticsNode2)) {
                                                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction2.label, 32));
                                            }
                                            Unit unit111 = Unit.INSTANCE;
                                        }
                                        accessibilityAction3 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsActions.CopyText);
                                        if (accessibilityAction3 != null) {
                                            accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction3.label, 16384));
                                            Unit unit112 = Unit.INSTANCE;
                                        }
                                        if (InvertMatrixKt.access$enabled(semanticsNode2)) {
                                            accessibilityAction8 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsActions.SetText);
                                            if (accessibilityAction8 != null) {
                                                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction8.label, 2097152));
                                                Unit unit113 = Unit.INSTANCE;
                                            }
                                            accessibilityAction9 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsActions.OnImeAction);
                                            if (accessibilityAction9 != null) {
                                                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction9.getLabel(), android.R.id.accessibilityActionImeEnter));
                                                Unit unit114 = Unit.INSTANCE;
                                            }
                                            accessibilityAction10 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsActions.CutText);
                                            if (accessibilityAction10 != null) {
                                                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction10.getLabel(), 65536));
                                                Unit unit115 = Unit.INSTANCE;
                                            }
                                            accessibilityAction11 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsActions.PasteText);
                                            if (accessibilityAction11 != null) {
                                                if (accessibilityNodeInfo3.isFocused()) {
                                                    primaryClipDescription = androidComposeView2.m598getClipboardManager().getClipboardManager().getPrimaryClipDescription();
                                                    if (primaryClipDescription != null) {
                                                        zHasMimeType = primaryClipDescription.hasMimeType("text/*");
                                                    } else {
                                                        zHasMimeType = false;
                                                    }
                                                    if (zHasMimeType) {
                                                        accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction11.getLabel(), 32768));
                                                    }
                                                }
                                                Unit unit116 = Unit.INSTANCE;
                                            }
                                        }
                                        iterableTextForAccessibility = AndroidComposeViewAccessibilityDelegateCompat.getIterableTextForAccessibility(semanticsNode2);
                                        if (iterableTextForAccessibility != null) {
                                            z3 = true;
                                        } else {
                                            z3 = true;
                                        }
                                        if (!z3) {
                                            accessibilityNodeInfo3.setTextSelection(androidComposeViewAccessibilityDelegateCompat.getAccessibilitySelectionStart(semanticsNode2), androidComposeViewAccessibilityDelegateCompat.getAccessibilitySelectionEnd(semanticsNode2));
                                            accessibilityAction7 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsActions.SetSelection);
                                            if (accessibilityAction7 != null) {
                                                label = accessibilityAction7.getLabel();
                                            } else {
                                                label = null;
                                            }
                                            accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(label, 131072));
                                            accessibilityNodeInfoCompat.addAction(256);
                                            accessibilityNodeInfoCompat.addAction(512);
                                            accessibilityNodeInfo3.setMovementGranularities(11);
                                            list3 = (List) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsProperties.ContentDescription);
                                            if (list3 != null) {
                                                z10 = true;
                                            } else {
                                                z10 = true;
                                            }
                                            if (z10) {
                                                accessibilityNodeInfo3.setMovementGranularities(accessibilityNodeInfo3.getMovementGranularities() | 20);
                                            }
                                        }
                                        if (Build.VERSION.SDK_INT >= 26) {
                                            arrayList2 = new ArrayList();
                                            arrayList2.add("androidx.compose.ui.semantics.id");
                                            text = accessibilityNodeInfoCompat.getText();
                                            if (text != null) {
                                                z9 = true;
                                            } else {
                                                z9 = true;
                                            }
                                            if (!z9) {
                                                arrayList2.add("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY");
                                            }
                                            if (semanticsNode2.getUnmergedConfig$ui().contains(SemanticsProperties.TestTag)) {
                                                arrayList2.add("androidx.compose.ui.semantics.testTag");
                                            }
                                            if (semanticsNode2.getUnmergedConfig$ui().contains(SemanticsProperties.Shape)) {
                                                arrayList2.add("androidx.compose.ui.semantics.shapeType");
                                                arrayList2.add("androidx.compose.ui.semantics.shapeRect");
                                                arrayList2.add("androidx.compose.ui.semantics.shapeCorners");
                                                arrayList2.add("androidx.compose.ui.semantics.shapeRegion");
                                            }
                                            semanticsNode2.getUnmergedConfig$ui().getClass();
                                            if (Build.VERSION.SDK_INT >= 26) {
                                                accessibilityNodeInfo3.setAvailableExtraData(arrayList2);
                                            }
                                        }
                                        progressBarRangeInfo = (ProgressBarRangeInfo) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsProperties.ProgressBarRangeInfo);
                                        if (progressBarRangeInfo != null) {
                                            unmergedConfig$ui2 = semanticsNode2.getUnmergedConfig$ui();
                                            semanticsPropertyKey4 = SemanticsActions.SetProgress;
                                            if (unmergedConfig$ui2.contains(semanticsPropertyKey4)) {
                                                accessibilityNodeInfoCompat.setClassName("android.widget.SeekBar");
                                            } else {
                                                accessibilityNodeInfoCompat.setClassName("android.widget.ProgressBar");
                                            }
                                            ProgressBarRangeInfo progressBarRangeInfo3 = ProgressBarRangeInfo.Indeterminate;
                                            if (progressBarRangeInfo != ProgressBarRangeInfo.Indeterminate) {
                                                progressBarRangeInfo.getRange().getClass();
                                                float fFloatValue6 = fValueOf.floatValue();
                                                progressBarRangeInfo.getRange().getClass();
                                                accessibilityNodeInfo3.setRangeInfo((AccessibilityNodeInfo.RangeInfo) new ExposureStateImpl(AccessibilityNodeInfo.RangeInfo.obtain(1, fFloatValue6, fValueOf.floatValue(), 0.0f)).mLock);
                                            }
                                            if (semanticsNode2.getUnmergedConfig$ui().contains(semanticsPropertyKey4)) {
                                                progressBarRangeInfo.getRange().getClass();
                                                fFloatValue = fValueOf.floatValue();
                                                progressBarRangeInfo.getRange().getClass();
                                                fFloatValue2 = fValueOf.floatValue();
                                                if (fFloatValue < fFloatValue2) {
                                                    fFloatValue = fFloatValue2;
                                                }
                                                if (0.0f < fFloatValue) {
                                                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                                                }
                                                progressBarRangeInfo.getRange().getClass();
                                                fFloatValue3 = fValueOf.floatValue();
                                                progressBarRangeInfo.getRange().getClass();
                                                fFloatValue4 = fValueOf.floatValue();
                                                if (fFloatValue3 > fFloatValue4) {
                                                    fFloatValue3 = fFloatValue4;
                                                }
                                                if (0.0f > fFloatValue3) {
                                                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                                                }
                                            }
                                        }
                                        i7 = Build.VERSION.SDK_INT;
                                        if (i7 >= 24) {
                                            InvertMatrixKt.addSetProgressAction(semanticsNode2, accessibilityNodeInfoCompat);
                                        }
                                        zztj.setCollectionInfo(semanticsNode2, accessibilityNodeInfoCompat);
                                        zztj.setCollectionItemInfo(semanticsNode2, accessibilityNodeInfoCompat);
                                        scrollAxisRange = (ScrollAxisRange) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsProperties.HorizontalScrollAxisRange);
                                        AccessibilityAction accessibilityAction13 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsActions.ScrollBy);
                                        if (scrollAxisRange != null) {
                                            obj8 = semanticsNode2.getConfig().props.get(SemanticsProperties.CollectionInfo);
                                            if (obj8 == null) {
                                                obj8 = null;
                                            }
                                            if (obj8 == null) {
                                                obj9 = semanticsNode2.getConfig().props.get(SemanticsProperties.SelectableGroup);
                                                if (obj9 == null) {
                                                    obj9 = null;
                                                }
                                                if (obj9 != null) {
                                                    z6 = true;
                                                } else {
                                                    z6 = false;
                                                }
                                            } else {
                                                z6 = true;
                                            }
                                            if (!z6) {
                                                accessibilityNodeInfoCompat.setClassName("android.widget.HorizontalScrollView");
                                            }
                                            if (((Number) scrollAxisRange.maxValue.invoke()).floatValue() > 0.0f) {
                                                accessibilityNodeInfo3.setScrollable(true);
                                            }
                                            if (InvertMatrixKt.access$enabled(semanticsNode2)) {
                                                zPopulateAccessibilityNodeInfoProperties$canScrollForward = AndroidComposeViewAccessibilityDelegateCompat.populateAccessibilityNodeInfoProperties$canScrollForward(scrollAxisRange);
                                                layoutDirection = LayoutDirection.Rtl;
                                                if (zPopulateAccessibilityNodeInfoProperties$canScrollForward) {
                                                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                                                    layoutNode = layoutNode2;
                                                    if (layoutNode.layoutDirection == layoutDirection) {
                                                        z8 = true;
                                                    } else {
                                                        z8 = false;
                                                    }
                                                    if (z8) {
                                                        accessibilityActionCompat2 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT;
                                                    } else {
                                                        accessibilityActionCompat2 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT;
                                                    }
                                                    accessibilityNodeInfoCompat.addAction(accessibilityActionCompat2);
                                                } else {
                                                    layoutNode = layoutNode2;
                                                }
                                                if (AndroidComposeViewAccessibilityDelegateCompat.populateAccessibilityNodeInfoProperties$canScrollBackward(scrollAxisRange)) {
                                                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                                                    if (layoutNode.layoutDirection == layoutDirection) {
                                                        z7 = true;
                                                    } else {
                                                        z7 = false;
                                                    }
                                                    if (z7) {
                                                        accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT;
                                                    } else {
                                                        accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT;
                                                    }
                                                    accessibilityNodeInfoCompat.addAction(accessibilityActionCompat);
                                                }
                                            }
                                        }
                                        scrollAxisRange2 = (ScrollAxisRange) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsProperties.VerticalScrollAxisRange);
                                        if (scrollAxisRange2 != null) {
                                            obj6 = semanticsNode2.getConfig().props.get(SemanticsProperties.CollectionInfo);
                                            if (obj6 == null) {
                                                obj6 = null;
                                            }
                                            if (obj6 == null) {
                                                obj7 = semanticsNode2.getConfig().props.get(SemanticsProperties.SelectableGroup);
                                                if (obj7 == null) {
                                                    obj7 = null;
                                                }
                                                if (obj7 != null) {
                                                    z5 = true;
                                                } else {
                                                    z5 = false;
                                                }
                                            } else {
                                                z5 = true;
                                            }
                                            if (!z5) {
                                                accessibilityNodeInfoCompat.setClassName("android.widget.ScrollView");
                                            }
                                            if (((Number) scrollAxisRange2.maxValue.invoke()).floatValue() > 0.0f) {
                                                accessibilityNodeInfo3.setScrollable(true);
                                            }
                                            if (InvertMatrixKt.access$enabled(semanticsNode2)) {
                                                if (AndroidComposeViewAccessibilityDelegateCompat.populateAccessibilityNodeInfoProperties$canScrollForward(scrollAxisRange2)) {
                                                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                                                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
                                                }
                                                if (AndroidComposeViewAccessibilityDelegateCompat.populateAccessibilityNodeInfoProperties$canScrollBackward(scrollAxisRange2)) {
                                                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                                                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
                                                }
                                            }
                                        }
                                        if (i7 >= 29) {
                                            InvertMatrixKt.addPageActions(semanticsNode2, accessibilityNodeInfoCompat);
                                        }
                                        charSequence = (CharSequence) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsProperties.PaneTitle);
                                        if (i7 >= 28) {
                                            accessibilityNodeInfo3.setPaneTitle(charSequence);
                                        } else {
                                            accessibilityNodeInfo3.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
                                        }
                                        if (InvertMatrixKt.access$enabled(semanticsNode2)) {
                                            accessibilityAction4 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsActions.Expand);
                                            if (accessibilityAction4 != null) {
                                                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction4.getLabel(), 262144));
                                                Unit unit117 = Unit.INSTANCE;
                                            }
                                            accessibilityAction5 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsActions.Collapse);
                                            if (accessibilityAction5 != null) {
                                                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction5.getLabel(), 524288));
                                                Unit unit118 = Unit.INSTANCE;
                                            }
                                            accessibilityAction6 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsActions.Dismiss);
                                            if (accessibilityAction6 != null) {
                                                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction6.getLabel(), 1048576));
                                                Unit unit119 = Unit.INSTANCE;
                                            }
                                            unmergedConfig$ui = semanticsNode2.getUnmergedConfig$ui();
                                            semanticsPropertyKey3 = SemanticsActions.CustomActions;
                                            if (unmergedConfig$ui.contains(semanticsPropertyKey3)) {
                                                list2 = (List) semanticsNode2.getUnmergedConfig$ui().get(semanticsPropertyKey3);
                                                size2 = list2.size();
                                                mutableIntList = AndroidComposeViewAccessibilityDelegateCompat.AccessibilityActionsResourceIds;
                                                if (size2 < mutableIntList._size) {
                                                    throw new IllegalStateException(ImageAnalysis$$ExternalSyntheticLambda1.m(new StringBuilder("Can't have more than "), mutableIntList._size, " custom actions for one widget"));
                                                }
                                                SparseArrayCompat sparseArrayCompat5 = new SparseArrayCompat(0);
                                                MutableObjectIntMap mutableObjectIntMapMutableObjectIntMapOf2 = ObjectIntMapKt.mutableObjectIntMapOf();
                                                sparseArrayCompat3 = sparseArrayCompat2;
                                                if (sparseArrayCompat3.garbage) {
                                                    ArraySetKt.access$gc(sparseArrayCompat3);
                                                }
                                                if (RuntimeHelpersKt.binarySearch(sparseArrayCompat3.size, i6, sparseArrayCompat3.keys) >= 0) {
                                                    z4 = true;
                                                } else {
                                                    z4 = false;
                                                }
                                                if (z4) {
                                                    iArr = mutableIntList.content;
                                                    i8 = mutableIntList._size;
                                                    iArrCopyOf = new int[16];
                                                    i9 = 0;
                                                    i10 = 0;
                                                    while (i9 < i8) {
                                                        int i310 = iArr[i9];
                                                        char c3 = c;
                                                        i11 = i10 + 1;
                                                        int i42 = i8;
                                                        if (iArrCopyOf.length < i11) {
                                                            iArrCopyOf = Arrays.copyOf(iArrCopyOf, Math.max(i11, (iArrCopyOf.length * 3) / 2));
                                                        }
                                                        iArrCopyOf[i10] = i310;
                                                        i9++;
                                                        i10 = i11;
                                                        c = c3;
                                                        i8 = i42;
                                                    }
                                                    arrayList = new ArrayList();
                                                    if (list2.size() <= 0) {
                                                        Modifier.CC.m(list2.get(0));
                                                        throw null;
                                                    }
                                                    if (arrayList.size() > 0) {
                                                        Modifier.CC.m(arrayList.get(0));
                                                        if (i10 > 0) {
                                                            int i43 = iArrCopyOf[0];
                                                            throw null;
                                                        }
                                                        RuntimeHelpersKt.throwIndexOutOfBoundsException("Index must be between 0 and size");
                                                        throw null;
                                                    }
                                                } else if (list2.size() > 0) {
                                                    Modifier.CC.m(list2.get(0));
                                                    mutableIntList.get(0);
                                                    throw null;
                                                }
                                                androidComposeViewAccessibilityDelegateCompat.actionIdToLabel.put(i6, sparseArrayCompat5);
                                                sparseArrayCompat3.put(i6, mutableObjectIntMapMutableObjectIntMapOf2);
                                            }
                                        }
                                        zAccess$isScreenReaderFocusable = InvertMatrixKt.access$isScreenReaderFocusable(semanticsNode2, resources4);
                                        if (Build.VERSION.SDK_INT >= 28) {
                                            accessibilityNodeInfo3.setScreenReaderFocusable(zAccess$isScreenReaderFocusable);
                                        } else {
                                            accessibilityNodeInfoCompat.setBooleanProperty(1, zAccess$isScreenReaderFocusable);
                                        }
                                        orDefault = androidComposeViewAccessibilityDelegateCompat.idToBeforeMap.getOrDefault(i6, -1);
                                        if (orDefault != -1) {
                                            InvertMatrixKt.semanticsIdToView(androidComposeView2.getAndroidViewsHandler$ui(), orDefault);
                                            androidComposeView = androidComposeView2;
                                            accessibilityNodeInfo3.setTraversalBefore(androidComposeView, orDefault);
                                            androidComposeViewAccessibilityDelegateCompat.addExtraDataToAccessibilityNodeInfoHelper(i6, accessibilityNodeInfoCompat, androidComposeViewAccessibilityDelegateCompat.ExtraDataTestTraversalBeforeVal, null);
                                        } else {
                                            androidComposeView = androidComposeView2;
                                        }
                                        orDefault2 = androidComposeViewAccessibilityDelegateCompat.idToAfterMap.getOrDefault(i6, -1);
                                        if (orDefault2 != -1) {
                                            InvertMatrixKt.semanticsIdToView(androidComposeView.getAndroidViewsHandler$ui(), orDefault2);
                                        }
                                        str3 = (String) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsPropertiesAndroid.AccessibilityClassName);
                                        if (str3 != null) {
                                            accessibilityNodeInfoCompat.setClassName(str3);
                                            Unit unit22 = Unit.INSTANCE;
                                        }
                                        accessibilityNodeInfoCompat2 = accessibilityNodeInfoCompat;
                                    }
                                }
                            } else if (Build.VERSION.SDK_INT >= 34 ? TextViewCompat.Api34Impl.isRequestFromAccessibilityTool(accessibilityManager2) : true) {
                                accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain();
                                accessibilityNodeInfoCompat = new AccessibilityNodeInfoCompat(accessibilityNodeInfoObtain);
                                i2 = Build.VERSION.SDK_INT;
                                if (i2 >= 34) {
                                    TextViewCompat.Api34Impl.setAccessibilityDataSensitive(accessibilityNodeInfoObtain, zAreEqual2);
                                } else {
                                    accessibilityNodeInfoCompat.setBooleanProperty(64, zAreEqual2);
                                }
                                if (i == -1) {
                                    parentForAccessibility = androidComposeView2.getParentForAccessibility();
                                    if (parentForAccessibility instanceof View) {
                                        view = (View) parentForAccessibility;
                                    } else {
                                        view = null;
                                    }
                                    accessibilityNodeInfoCompat.mParentVirtualDescendantId = -1;
                                    accessibilityNodeInfoObtain.setParent(view);
                                } else {
                                    parent = semanticsNode5.getParent();
                                    if (parent != null) {
                                        numValueOf = Integer.valueOf(parent.id);
                                    } else {
                                        numValueOf = null;
                                    }
                                    if (numValueOf != null) {
                                        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("semanticsNode " + i + " has null parent");
                                        throw new HttpException();
                                    }
                                    iIntValue = numValueOf.intValue();
                                    if (iIntValue == androidComposeView2.getSemanticsOwner().getUnmergedRootSemanticsNode().id) {
                                        iIntValue = -1;
                                    }
                                    accessibilityNodeInfoCompat.mParentVirtualDescendantId = iIntValue;
                                    accessibilityNodeInfoObtain.setParent(androidComposeView2, iIntValue);
                                }
                                accessibilityNodeInfoCompat.mVirtualDescendantId = i;
                                accessibilityNodeInfoObtain.setSource(androidComposeView2, i);
                                accessibilityNodeInfoObtain.setBoundsInScreen(androidComposeViewAccessibilityDelegateCompat2.boundsInScreen(semanticsNodeWithAdjustedBounds2));
                                mutableIntIntMap = androidComposeViewAccessibilityDelegateCompat2.drawingOrder;
                                sparseArrayCompat = androidComposeViewAccessibilityDelegateCompat2.labelToActionId;
                                resources = androidComposeView2.getContext().getResources();
                                accessibilityNodeInfoCompat.setClassName("android.view.View");
                                semanticsConfiguration = semanticsNode5.unmergedConfig;
                                mutableScatterMap = semanticsConfiguration.props;
                                if (mutableScatterMap.containsKey(SemanticsProperties.EditableText)) {
                                    accessibilityNodeInfoCompat.setClassName("android.widget.EditText");
                                }
                                if (mutableScatterMap.containsKey(SemanticsProperties.Text)) {
                                    accessibilityNodeInfoCompat.setClassName("android.widget.TextView");
                                }
                                obj = mutableScatterMap.get(SemanticsProperties.Role);
                                if (obj == null) {
                                    obj = null;
                                }
                                role = (Role) obj;
                                if (role != null) {
                                    i31 = role.value;
                                    if (semanticsNode5.isFake$ui()) {
                                        accessibilityManager = accessibilityManager2;
                                        i32 = 4;
                                        sparseArrayCompat2 = sparseArrayCompat;
                                    } else {
                                        accessibilityManager = accessibilityManager2;
                                        i32 = 4;
                                        sparseArrayCompat2 = sparseArrayCompat;
                                        if (SemanticsNode.getChildren$ui$default(4, semanticsNode5).isEmpty()) {
                                        }
                                        Unit unit23 = Unit.INSTANCE;
                                    }
                                    if (i31 == i32) {
                                        accessibilityNodeInfoObtain.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", resources.getString(R.string.tab));
                                    } else if (i31 == 2) {
                                        accessibilityNodeInfoObtain.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", resources.getString(R.string.switch_role));
                                    } else {
                                        strM614toLegacyClassNameV4PA4sw = InvertMatrixKt.m614toLegacyClassNameV4PA4sw(i31);
                                        if (i31 == 5) {
                                            accessibilityNodeInfoCompat.setClassName(strM614toLegacyClassNameV4PA4sw);
                                        } else {
                                            accessibilityNodeInfoCompat.setClassName(strM614toLegacyClassNameV4PA4sw);
                                        }
                                    }
                                    Unit unit24 = Unit.INSTANCE;
                                } else {
                                    accessibilityManager = accessibilityManager2;
                                    sparseArrayCompat2 = sparseArrayCompat;
                                }
                                accessibilityNodeInfoObtain.setPackageName(androidComposeView2.getContext().getPackageName());
                                zIsImportantForAccessibility = SemanticsNodeKt.isImportantForAccessibility(semanticsNode5);
                                if (i2 >= 24) {
                                    accessibilityNodeInfoObtain.setImportantForAccessibility(zIsImportantForAccessibility);
                                }
                                if (i2 >= 34) {
                                    zIsRequestFromAccessibilityTool = TextViewCompat.Api34Impl.isRequestFromAccessibilityTool(accessibilityManager);
                                } else {
                                    zIsRequestFromAccessibilityTool = true;
                                }
                                children$ui$default = SemanticsNode.getChildren$ui$default(4, semanticsNode5);
                                size = children$ui$default.size();
                                z = zIsRequestFromAccessibilityTool;
                                i3 = 0;
                                i4 = 0;
                                while (true) {
                                    accessibilityNodeInfo = accessibilityNodeInfoCompat.mInfo;
                                    if (i4 < size) {
                                        int i311 = i4;
                                        semanticsNode3 = (SemanticsNode) children$ui$default.get(i4);
                                        int i312 = size;
                                        currentSemanticsNodes = androidComposeViewAccessibilityDelegateCompat2.getCurrentSemanticsNodes();
                                        List list6 = children$ui$default;
                                        i30 = semanticsNode3.id;
                                        if (!currentSemanticsNodes.containsKey(i30)) {
                                            if (androidComposeView2.getAndroidViewsHandler$ui().getLayoutNodeToHolder().get(semanticsNode3.layoutNode) == null) {
                                                throw new ClassCastException();
                                            }
                                            if (i30 != -1) {
                                                semanticsNodeWithAdjustedBounds = (SemanticsNodeWithAdjustedBounds) androidComposeViewAccessibilityDelegateCompat2.getCurrentSemanticsNodes().get(i30);
                                                if (semanticsNodeWithAdjustedBounds != null) {
                                                    zAreEqual = false;
                                                } else {
                                                    zAreEqual = false;
                                                }
                                                if (z) {
                                                    accessibilityNodeInfo.addChild(androidComposeView2, i30);
                                                } else {
                                                    accessibilityNodeInfo.addChild(androidComposeView2, i30);
                                                }
                                                mutableIntIntMap.set(i30, i3);
                                                i3++;
                                            }
                                        }
                                        i4 = i311 + 1;
                                        size = i312;
                                        children$ui$default = list6;
                                    } else {
                                        if (i == androidComposeViewAccessibilityDelegateCompat2.accessibilityFocusedVirtualViewId) {
                                            accessibilityNodeInfo.setAccessibilityFocused(true);
                                            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
                                        } else {
                                            accessibilityNodeInfo.setAccessibilityFocused(false);
                                            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_ACCESSIBILITY_FOCUS);
                                        }
                                        infoText = InvertMatrixKt.getInfoText(semanticsNode5);
                                        if (infoText != null) {
                                            androidComposeView2.getFontFamilyResolver();
                                            density = androidComposeView2.getDensity();
                                            menuHostHelper = androidComposeViewAccessibilityDelegateCompat2.urlSpanCache;
                                            String str5 = infoText.text;
                                            list4 = infoText.annotations;
                                            spannableString2 = new SpannableString(str5);
                                            arrayList3 = infoText.spanStylesOrNull;
                                            if (arrayList3 != null) {
                                                size9 = arrayList3.size();
                                                i24 = 0;
                                                while (i24 < size9) {
                                                    ArrayList arrayList8 = arrayList3;
                                                    AnnotatedString.Range range9 = (AnnotatedString.Range) arrayList3.get(i24);
                                                    int i313 = i24;
                                                    SpanStyle spanStyle2 = (SpanStyle) range9.item;
                                                    int i314 = size9;
                                                    i25 = range9.start;
                                                    i26 = range9.end;
                                                    MutableIntIntMap mutableIntIntMap4 = mutableIntIntMap;
                                                    SemanticsConfiguration semanticsConfiguration6 = semanticsConfiguration;
                                                    jMo668getColor0d7_KjU = spanStyle2.textForegroundStyle.mo668getColor0d7_KjU();
                                                    SemanticsNode semanticsNode7 = semanticsNode5;
                                                    long j3 = spanStyle2.fontSize;
                                                    fontWeight = spanStyle2.fontWeight;
                                                    fontStyle = spanStyle2.fontStyle;
                                                    textGeometricTransform = spanStyle2.textGeometricTransform;
                                                    Role role5 = role;
                                                    LocaleList localeList2 = spanStyle2.localeList;
                                                    AccessibilityNodeInfo accessibilityNodeInfo5 = accessibilityNodeInfo;
                                                    Resources resources5 = resources;
                                                    j = spanStyle2.background;
                                                    textDecoration = spanStyle2.textDecoration;
                                                    colorStyle = spanStyle2.textForegroundStyle;
                                                    MutableScatterMap mutableScatterMap5 = mutableScatterMap;
                                                    if (!Color.m435equalsimpl0(jMo668getColor0d7_KjU, colorStyle.mo668getColor0d7_KjU())) {
                                                        if (jMo668getColor0d7_KjU != 16) {
                                                            colorStyle = new ColorStyle(jMo668getColor0d7_KjU);
                                                        } else {
                                                            colorStyle = TextForegroundStyle.Unspecified.INSTANCE;
                                                        }
                                                    }
                                                    zztz.m817setColorRPmYEkk(spannableString2, colorStyle.mo668getColor0d7_KjU(), i25, i26);
                                                    spannableString4 = spannableString2;
                                                    zztz.m818setFontSizeKmRG4DE(spannableString4, j3, density, i25, i26);
                                                    if (fontWeight == null) {
                                                        if (fontWeight == null) {
                                                            fontWeight2 = FontWeight.Normal;
                                                        } else {
                                                            fontWeight2 = fontWeight;
                                                        }
                                                        if (fontStyle != null) {
                                                            i27 = fontStyle.value;
                                                        } else {
                                                            i27 = 0;
                                                        }
                                                        StyleSpan styleSpan2 = new StyleSpan(AndroidFontUtils_androidKt.m655getAndroidTypefaceStyleFO1MlWM(fontWeight2, i27));
                                                        i28 = 33;
                                                        spannableString4.setSpan(styleSpan2, i25, i26, 33);
                                                    } else {
                                                        if (fontWeight == null) {
                                                            fontWeight2 = FontWeight.Normal;
                                                        } else {
                                                            fontWeight2 = fontWeight;
                                                        }
                                                        if (fontStyle != null) {
                                                            i27 = fontStyle.value;
                                                        } else {
                                                            i27 = 0;
                                                        }
                                                        StyleSpan styleSpan3 = new StyleSpan(AndroidFontUtils_androidKt.m655getAndroidTypefaceStyleFO1MlWM(fontWeight2, i27));
                                                        i28 = 33;
                                                        spannableString4.setSpan(styleSpan3, i25, i26, 33);
                                                    }
                                                    if (textDecoration != null) {
                                                        i29 = textDecoration.mask;
                                                        if ((i29 | 1) == i29) {
                                                            spannableString4.setSpan(new UnderlineSpan(), i25, i26, i28);
                                                        }
                                                        if ((i29 | 2) == i29) {
                                                            spannableString4.setSpan(new StrikethroughSpan(), i25, i26, i28);
                                                        }
                                                    }
                                                    if (textGeometricTransform != null) {
                                                        spannableString4.setSpan(new ScaleXSpan(textGeometricTransform.scaleX), i25, i26, i28);
                                                    }
                                                    zztz.setLocaleList(spannableString4, localeList2, i25, i26);
                                                    if (j != 16) {
                                                        spannableString4.setSpan(new BackgroundColorSpan(BrushKt.m426toArgb8_81llA(j)), i25, i26, i28);
                                                    }
                                                    i24 = i313 + 1;
                                                    spannableString2 = spannableString4;
                                                    arrayList3 = arrayList8;
                                                    size9 = i314;
                                                    mutableIntIntMap = mutableIntIntMap4;
                                                    semanticsConfiguration = semanticsConfiguration6;
                                                    semanticsNode5 = semanticsNode7;
                                                    role = role5;
                                                    resources = resources5;
                                                    accessibilityNodeInfo = accessibilityNodeInfo5;
                                                    mutableScatterMap = mutableScatterMap5;
                                                }
                                            }
                                            role2 = role;
                                            semanticsConfiguration2 = semanticsConfiguration;
                                            mutableIntIntMap2 = mutableIntIntMap;
                                            semanticsNode = semanticsNode5;
                                            spannableString3 = spannableString2;
                                            accessibilityNodeInfo2 = accessibilityNodeInfo;
                                            resources2 = resources;
                                            mutableScatterMap2 = mutableScatterMap;
                                            int length4 = str5.length();
                                            arrayList4 = EmptyList.INSTANCE;
                                            if (list4 != null) {
                                                arrayList5 = new ArrayList(list4.size());
                                                size8 = list4.size();
                                                for (i23 = 0; i23 < size8; i23++) {
                                                    Object obj17 = list4.get(i23);
                                                    range5 = (AnnotatedString.Range) obj17;
                                                    if (!(range5.item instanceof VerbatimTtsAnnotation)) {
                                                    }
                                                }
                                            } else {
                                                arrayList5 = arrayList4;
                                            }
                                            size3 = arrayList5.size();
                                            for (i14 = 0; i14 < size3; i14++) {
                                                AnnotatedString.Range range10 = (AnnotatedString.Range) arrayList5.get(i14);
                                                verbatimTtsAnnotation = (VerbatimTtsAnnotation) range10.item;
                                                i21 = range10.start;
                                                i22 = range10.end;
                                                if (verbatimTtsAnnotation instanceof VerbatimTtsAnnotation) {
                                                    throw new HttpException();
                                                }
                                                spannableString3.setSpan(new TtsSpan.VerbatimBuilder(verbatimTtsAnnotation.verbatim).build(), i21, i22, 33);
                                            }
                                            int length5 = str5.length();
                                            if (list4 != null) {
                                                arrayList6 = new ArrayList(list4.size());
                                                size7 = list4.size();
                                                for (i20 = 0; i20 < size7; i20++) {
                                                    Object obj18 = list4.get(i20);
                                                    range4 = (AnnotatedString.Range) obj18;
                                                    if (!(range4.item instanceof UrlAnnotation)) {
                                                    }
                                                }
                                            } else {
                                                arrayList6 = arrayList4;
                                            }
                                            size4 = arrayList6.size();
                                            for (i15 = 0; i15 < size4; i15++) {
                                                AnnotatedString.Range range11 = (AnnotatedString.Range) arrayList6.get(i15);
                                                urlAnnotation = (UrlAnnotation) range11.item;
                                                int i315 = range11.start;
                                                int i316 = range11.end;
                                                weakHashMap3 = (WeakHashMap) menuHostHelper.mOnInvalidateMenuCallback;
                                                uRLSpan2 = weakHashMap3.get(urlAnnotation);
                                                if (uRLSpan2 == null) {
                                                    uRLSpan2 = new URLSpan(urlAnnotation.url);
                                                    weakHashMap3.put(urlAnnotation, uRLSpan2);
                                                }
                                                spannableString3.setSpan((URLSpan) uRLSpan2, i315, i316, 33);
                                            }
                                            int length6 = str5.length();
                                            if (list4 != null) {
                                                arrayList4 = new ArrayList(list4.size());
                                                size6 = list4.size();
                                                for (i19 = 0; i19 < size6; i19++) {
                                                    Object obj19 = list4.get(i19);
                                                    range3 = (AnnotatedString.Range) obj19;
                                                    if (!(range3.item instanceof LinkAnnotation)) {
                                                    }
                                                }
                                            }
                                            size5 = arrayList4.size();
                                            for (i16 = 0; i16 < size5; i16++) {
                                                range = (AnnotatedString.Range) arrayList4.get(i16);
                                                i17 = range.start;
                                                obj11 = range.item;
                                                i18 = range.end;
                                                if (i17 != i18) {
                                                    linkAnnotation = (LinkAnnotation) obj11;
                                                    if (linkAnnotation instanceof LinkAnnotation.Url) {
                                                        url = (LinkAnnotation.Url) obj11;
                                                        range2 = new AnnotatedString.Range(i17, i18, url);
                                                        weakHashMap2 = (WeakHashMap) menuHostHelper.mMenuProviders;
                                                        uRLSpan = weakHashMap2.get(range2);
                                                        if (uRLSpan == null) {
                                                            uRLSpan = new URLSpan(url.url);
                                                            weakHashMap2.put(range2, uRLSpan);
                                                        }
                                                        spannableString3.setSpan((URLSpan) uRLSpan, i17, i18, 33);
                                                    } else {
                                                        weakHashMap = (WeakHashMap) menuHostHelper.mProviderToLifecycleContainers;
                                                        composeClickableSpan = weakHashMap.get(range);
                                                        if (composeClickableSpan == null) {
                                                            composeClickableSpan = new ComposeClickableSpan(linkAnnotation);
                                                            weakHashMap.put(range, composeClickableSpan);
                                                        }
                                                        spannableString3.setSpan((ClickableSpan) composeClickableSpan, i17, i18, 33);
                                                    }
                                                }
                                            }
                                            spannableString = (SpannableString) AndroidComposeViewAccessibilityDelegateCompat.trimToSize(spannableString3);
                                        } else {
                                            role2 = role;
                                            semanticsConfiguration2 = semanticsConfiguration;
                                            androidComposeViewAccessibilityDelegateCompat2 = androidComposeViewAccessibilityDelegateCompat2;
                                            mutableIntIntMap2 = mutableIntIntMap;
                                            semanticsNode = semanticsNode5;
                                            accessibilityNodeInfo2 = accessibilityNodeInfo;
                                            resources2 = resources;
                                            mutableScatterMap2 = mutableScatterMap;
                                            spannableString = null;
                                        }
                                        accessibilityNodeInfoCompat.setText(spannableString);
                                        semanticsPropertyKey = SemanticsProperties.Error;
                                        mutableScatterMap3 = mutableScatterMap2;
                                        if (mutableScatterMap3.containsKey(semanticsPropertyKey)) {
                                            accessibilityNodeInfoObtain.setContentInvalid(true);
                                            obj10 = mutableScatterMap3.get(semanticsPropertyKey);
                                            if (obj10 == null) {
                                                obj10 = null;
                                            }
                                            accessibilityNodeInfo3 = accessibilityNodeInfo2;
                                            accessibilityNodeInfo3.setError((CharSequence) obj10);
                                        } else {
                                            accessibilityNodeInfo3 = accessibilityNodeInfo2;
                                        }
                                        semanticsNode2 = semanticsNode;
                                        Resources resources6 = resources2;
                                        infoStateDescriptionOrNull = InvertMatrixKt.getInfoStateDescriptionOrNull(semanticsNode2, resources6);
                                        if (Build.VERSION.SDK_INT >= 30) {
                                            WindowCompat.Api30Impl.setStateDescription(accessibilityNodeInfo3, infoStateDescriptionOrNull);
                                        } else {
                                            accessibilityNodeInfo3.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", infoStateDescriptionOrNull);
                                        }
                                        accessibilityNodeInfo3.setCheckable(InvertMatrixKt.getInfoIsCheckable(semanticsNode2));
                                        obj2 = mutableScatterMap3.get(SemanticsProperties.ToggleableState);
                                        if (obj2 == null) {
                                            obj2 = null;
                                        }
                                        toggleableState = (ToggleableState) obj2;
                                        if (toggleableState != null) {
                                            if (toggleableState == ToggleableState.On) {
                                                accessibilityNodeInfo3.setChecked(true);
                                            } else if (toggleableState == ToggleableState.Off) {
                                                accessibilityNodeInfo3.setChecked(false);
                                            }
                                            Unit unit25 = Unit.INSTANCE;
                                        }
                                        obj3 = mutableScatterMap3.get(SemanticsProperties.Selected);
                                        if (obj3 == null) {
                                            obj3 = null;
                                        }
                                        bool = (Boolean) obj3;
                                        if (bool != null) {
                                            zBooleanValue2 = bool.booleanValue();
                                            if (role2 == null) {
                                                role3 = role2;
                                                i5 = 4;
                                            } else {
                                                role3 = role2;
                                                i5 = 4;
                                                if (role3.value == 4) {
                                                    accessibilityNodeInfoObtain.setSelected(zBooleanValue2);
                                                }
                                                Unit unit26 = Unit.INSTANCE;
                                            }
                                            accessibilityNodeInfo3.setChecked(zBooleanValue2);
                                            Unit unit27 = Unit.INSTANCE;
                                        } else {
                                            role3 = role2;
                                            i5 = 4;
                                        }
                                        semanticsConfiguration3 = semanticsConfiguration2;
                                        if (semanticsConfiguration3.isMergingSemanticsOfDescendants) {
                                            obj4 = mutableScatterMap3.get(SemanticsProperties.ContentDescription);
                                            if (obj4 == null) {
                                                obj4 = null;
                                            }
                                            list = (List) obj4;
                                            if (list != null) {
                                                str = (String) CollectionsKt.firstOrNull(list);
                                            } else {
                                                str = null;
                                            }
                                            accessibilityNodeInfo3.setContentDescription(str);
                                        } else {
                                            obj4 = mutableScatterMap3.get(SemanticsProperties.ContentDescription);
                                            if (obj4 == null) {
                                                obj4 = null;
                                            }
                                            list = (List) obj4;
                                            if (list != null) {
                                                str = (String) CollectionsKt.firstOrNull(list);
                                            } else {
                                                str = null;
                                            }
                                            accessibilityNodeInfo3.setContentDescription(str);
                                        }
                                        obj5 = mutableScatterMap3.get(SemanticsProperties.TestTag);
                                        if (obj5 == null) {
                                            obj5 = null;
                                        }
                                        str2 = (String) obj5;
                                        if (str2 != null) {
                                            parent3 = semanticsNode2;
                                            while (true) {
                                                if (parent3 != null) {
                                                    semanticsConfiguration4 = parent3.unmergedConfig;
                                                    semanticsPropertyKey5 = SemanticsPropertiesAndroid.TestTagsAsResourceId;
                                                    if (semanticsConfiguration4.props.containsKey(semanticsPropertyKey5)) {
                                                        zBooleanValue = ((Boolean) semanticsConfiguration4.get(semanticsPropertyKey5)).booleanValue();
                                                    } else {
                                                        parent3 = parent3.getParent();
                                                    }
                                                } else {
                                                    zBooleanValue = false;
                                                }
                                            }
                                            if (zBooleanValue) {
                                                accessibilityNodeInfoObtain.setViewIdResourceName(str2);
                                            }
                                        }
                                        if (((Unit) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsProperties.Heading)) != null) {
                                            if (Build.VERSION.SDK_INT >= 28) {
                                                accessibilityNodeInfo3.setHeading(true);
                                            } else {
                                                accessibilityNodeInfoCompat.setBooleanProperty(2, true);
                                            }
                                            Unit unit28 = Unit.INSTANCE;
                                        }
                                        if (((Unit) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsProperties.TextEntryKey)) != null) {
                                            if (Build.VERSION.SDK_INT >= 29) {
                                                accessibilityNodeInfoObtain.setTextEntryKey(true);
                                            } else {
                                                accessibilityNodeInfoCompat.setBooleanProperty(8, true);
                                            }
                                            Unit unit29 = Unit.INSTANCE;
                                        }
                                        i6 = i;
                                        if (i6 != -1) {
                                            orDefault3 = mutableIntIntMap2.getOrDefault(semanticsNode2.id, -1);
                                            if (orDefault3 != -1) {
                                                if (Build.VERSION.SDK_INT >= 24) {
                                                    accessibilityNodeInfoObtain.setDrawingOrder(orDefault3);
                                                }
                                                Unit unit30 = Unit.INSTANCE;
                                            } else {
                                                Log.w("AccessibilityDelegate", "Drawing order is not available, was AccessibilityNodeInfo requested for a child node before its parent?");
                                            }
                                        }
                                        accessibilityNodeInfoObtain.setPassword(mutableScatterMap3.containsKey(SemanticsProperties.Password));
                                        Object orNull2 = SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsProperties.IsEditable);
                                        bool2 = Boolean.TRUE;
                                        accessibilityNodeInfoObtain.setEditable(Intrinsics.areEqual(orNull2, bool2));
                                        num = (Integer) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsProperties.MaxTextLength);
                                        if (num != null) {
                                            iIntValue2 = num.intValue();
                                        } else {
                                            iIntValue2 = -1;
                                        }
                                        accessibilityNodeInfo3.setMaxTextLength(iIntValue2);
                                        accessibilityNodeInfo3.setEnabled(InvertMatrixKt.access$enabled(semanticsNode2));
                                        semanticsPropertyKey2 = SemanticsProperties.Focused;
                                        accessibilityNodeInfo3.setFocusable(mutableScatterMap3.containsKey(semanticsPropertyKey2));
                                        if (accessibilityNodeInfoObtain.isFocusable()) {
                                            accessibilityNodeInfo3.setFocused(((Boolean) semanticsConfiguration3.get(semanticsPropertyKey2)).booleanValue());
                                            if (accessibilityNodeInfoObtain.isFocused()) {
                                                accessibilityNodeInfoCompat.addAction(2);
                                                androidComposeViewAccessibilityDelegateCompat = androidComposeViewAccessibilityDelegateCompat2;
                                                androidComposeViewAccessibilityDelegateCompat.focusedVirtualViewId = i6;
                                            } else {
                                                androidComposeViewAccessibilityDelegateCompat = androidComposeViewAccessibilityDelegateCompat2;
                                                z2 = true;
                                                accessibilityNodeInfoCompat.addAction(1);
                                            }
                                            accessibilityNodeInfo3.setVisibleToUser(SemanticsNodeKt.isHidden(semanticsNode2) ^ z2);
                                            if (semanticsNode2.isFake$ui()) {
                                                parent2 = semanticsNode2.getParent();
                                            } else {
                                                parent2 = semanticsNode2;
                                            }
                                            if (parent2.getTouchBoundsInRoot().isEmpty()) {
                                                accessibilityNodeInfo3.setVisibleToUser(false);
                                            }
                                            liveRegionMode = (LiveRegionMode) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsProperties.LiveRegion);
                                            if (liveRegionMode != null) {
                                                i12 = liveRegionMode.value;
                                                if (i12 == 0) {
                                                    z15 = true;
                                                } else {
                                                    z15 = false;
                                                }
                                                if (z15) {
                                                    i13 = 1;
                                                } else {
                                                    if (i12 == 1) {
                                                        z16 = true;
                                                    } else {
                                                        z16 = false;
                                                    }
                                                    if (z16) {
                                                        i13 = 2;
                                                    } else {
                                                        i13 = 1;
                                                    }
                                                }
                                                accessibilityNodeInfoObtain.setLiveRegion(i13);
                                                Unit unit210 = Unit.INSTANCE;
                                            }
                                            accessibilityNodeInfo3.setClickable(false);
                                            accessibilityAction = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsActions.OnClick);
                                            c = 3;
                                            if (accessibilityAction != null) {
                                                boolean zAreEqual5 = Intrinsics.areEqual(SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsProperties.Selected), bool2);
                                                if (role3 == null) {
                                                    z11 = false;
                                                } else {
                                                    z11 = true;
                                                }
                                                if (z11) {
                                                    z12 = true;
                                                } else {
                                                    if (role3 == null) {
                                                        z14 = false;
                                                    } else {
                                                        z14 = true;
                                                    }
                                                    if (z14) {
                                                        z12 = true;
                                                    } else {
                                                        z12 = false;
                                                    }
                                                }
                                                if (z12) {
                                                    z13 = true;
                                                } else {
                                                    z13 = true;
                                                }
                                                accessibilityNodeInfo3.setClickable(z13);
                                                if (InvertMatrixKt.access$enabled(semanticsNode2)) {
                                                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction.label, 16));
                                                }
                                                Unit unit1110 = Unit.INSTANCE;
                                            }
                                            accessibilityNodeInfo3.setLongClickable(false);
                                            accessibilityAction2 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsActions.OnLongClick);
                                            if (accessibilityAction2 != null) {
                                                accessibilityNodeInfo3.setLongClickable(true);
                                                if (InvertMatrixKt.access$enabled(semanticsNode2)) {
                                                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction2.label, 32));
                                                }
                                                Unit unit1111 = Unit.INSTANCE;
                                            }
                                            accessibilityAction3 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsActions.CopyText);
                                            if (accessibilityAction3 != null) {
                                                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction3.label, 16384));
                                                Unit unit1112 = Unit.INSTANCE;
                                            }
                                            if (InvertMatrixKt.access$enabled(semanticsNode2)) {
                                                accessibilityAction8 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsActions.SetText);
                                                if (accessibilityAction8 != null) {
                                                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction8.label, 2097152));
                                                    Unit unit1113 = Unit.INSTANCE;
                                                }
                                                accessibilityAction9 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsActions.OnImeAction);
                                                if (accessibilityAction9 != null) {
                                                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction9.getLabel(), android.R.id.accessibilityActionImeEnter));
                                                    Unit unit1114 = Unit.INSTANCE;
                                                }
                                                accessibilityAction10 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsActions.CutText);
                                                if (accessibilityAction10 != null) {
                                                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction10.getLabel(), 65536));
                                                    Unit unit1115 = Unit.INSTANCE;
                                                }
                                                accessibilityAction11 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsActions.PasteText);
                                                if (accessibilityAction11 != null) {
                                                    if (accessibilityNodeInfo3.isFocused()) {
                                                        primaryClipDescription = androidComposeView2.m598getClipboardManager().getClipboardManager().getPrimaryClipDescription();
                                                        if (primaryClipDescription != null) {
                                                            zHasMimeType = primaryClipDescription.hasMimeType("text/*");
                                                        } else {
                                                            zHasMimeType = false;
                                                        }
                                                        if (zHasMimeType) {
                                                            accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction11.getLabel(), 32768));
                                                        }
                                                    }
                                                    Unit unit1116 = Unit.INSTANCE;
                                                }
                                            }
                                            iterableTextForAccessibility = AndroidComposeViewAccessibilityDelegateCompat.getIterableTextForAccessibility(semanticsNode2);
                                            if (iterableTextForAccessibility != null) {
                                                z3 = true;
                                            } else {
                                                z3 = true;
                                            }
                                            if (!z3) {
                                                accessibilityNodeInfo3.setTextSelection(androidComposeViewAccessibilityDelegateCompat.getAccessibilitySelectionStart(semanticsNode2), androidComposeViewAccessibilityDelegateCompat.getAccessibilitySelectionEnd(semanticsNode2));
                                                accessibilityAction7 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsActions.SetSelection);
                                                if (accessibilityAction7 != null) {
                                                    label = accessibilityAction7.getLabel();
                                                } else {
                                                    label = null;
                                                }
                                                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(label, 131072));
                                                accessibilityNodeInfoCompat.addAction(256);
                                                accessibilityNodeInfoCompat.addAction(512);
                                                accessibilityNodeInfo3.setMovementGranularities(11);
                                                list3 = (List) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsProperties.ContentDescription);
                                                if (list3 != null) {
                                                    z10 = true;
                                                } else {
                                                    z10 = true;
                                                }
                                                if (z10) {
                                                    accessibilityNodeInfo3.setMovementGranularities(accessibilityNodeInfo3.getMovementGranularities() | 20);
                                                }
                                            }
                                            if (Build.VERSION.SDK_INT >= 26) {
                                                arrayList2 = new ArrayList();
                                                arrayList2.add("androidx.compose.ui.semantics.id");
                                                text = accessibilityNodeInfoCompat.getText();
                                                if (text != null) {
                                                    z9 = true;
                                                } else {
                                                    z9 = true;
                                                }
                                                if (!z9) {
                                                    arrayList2.add("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY");
                                                }
                                                if (semanticsNode2.getUnmergedConfig$ui().contains(SemanticsProperties.TestTag)) {
                                                    arrayList2.add("androidx.compose.ui.semantics.testTag");
                                                }
                                                if (semanticsNode2.getUnmergedConfig$ui().contains(SemanticsProperties.Shape)) {
                                                    arrayList2.add("androidx.compose.ui.semantics.shapeType");
                                                    arrayList2.add("androidx.compose.ui.semantics.shapeRect");
                                                    arrayList2.add("androidx.compose.ui.semantics.shapeCorners");
                                                    arrayList2.add("androidx.compose.ui.semantics.shapeRegion");
                                                }
                                                semanticsNode2.getUnmergedConfig$ui().getClass();
                                                if (Build.VERSION.SDK_INT >= 26) {
                                                    accessibilityNodeInfo3.setAvailableExtraData(arrayList2);
                                                }
                                            }
                                            progressBarRangeInfo = (ProgressBarRangeInfo) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsProperties.ProgressBarRangeInfo);
                                            if (progressBarRangeInfo != null) {
                                                unmergedConfig$ui2 = semanticsNode2.getUnmergedConfig$ui();
                                                semanticsPropertyKey4 = SemanticsActions.SetProgress;
                                                if (unmergedConfig$ui2.contains(semanticsPropertyKey4)) {
                                                    accessibilityNodeInfoCompat.setClassName("android.widget.SeekBar");
                                                } else {
                                                    accessibilityNodeInfoCompat.setClassName("android.widget.ProgressBar");
                                                }
                                                ProgressBarRangeInfo progressBarRangeInfo4 = ProgressBarRangeInfo.Indeterminate;
                                                if (progressBarRangeInfo != ProgressBarRangeInfo.Indeterminate) {
                                                    progressBarRangeInfo.getRange().getClass();
                                                    float fFloatValue7 = fValueOf.floatValue();
                                                    progressBarRangeInfo.getRange().getClass();
                                                    accessibilityNodeInfo3.setRangeInfo((AccessibilityNodeInfo.RangeInfo) new ExposureStateImpl(AccessibilityNodeInfo.RangeInfo.obtain(1, fFloatValue7, fValueOf.floatValue(), 0.0f)).mLock);
                                                }
                                                if (semanticsNode2.getUnmergedConfig$ui().contains(semanticsPropertyKey4)) {
                                                    progressBarRangeInfo.getRange().getClass();
                                                    fFloatValue = fValueOf.floatValue();
                                                    progressBarRangeInfo.getRange().getClass();
                                                    fFloatValue2 = fValueOf.floatValue();
                                                    if (fFloatValue < fFloatValue2) {
                                                        fFloatValue = fFloatValue2;
                                                    }
                                                    if (0.0f < fFloatValue) {
                                                        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                                                    }
                                                    progressBarRangeInfo.getRange().getClass();
                                                    fFloatValue3 = fValueOf.floatValue();
                                                    progressBarRangeInfo.getRange().getClass();
                                                    fFloatValue4 = fValueOf.floatValue();
                                                    if (fFloatValue3 > fFloatValue4) {
                                                        fFloatValue3 = fFloatValue4;
                                                    }
                                                    if (0.0f > fFloatValue3) {
                                                        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                                                    }
                                                }
                                            }
                                            i7 = Build.VERSION.SDK_INT;
                                            if (i7 >= 24) {
                                                InvertMatrixKt.addSetProgressAction(semanticsNode2, accessibilityNodeInfoCompat);
                                            }
                                            zztj.setCollectionInfo(semanticsNode2, accessibilityNodeInfoCompat);
                                            zztj.setCollectionItemInfo(semanticsNode2, accessibilityNodeInfoCompat);
                                            scrollAxisRange = (ScrollAxisRange) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsProperties.HorizontalScrollAxisRange);
                                            AccessibilityAction accessibilityAction14 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsActions.ScrollBy);
                                            if (scrollAxisRange != null) {
                                                obj8 = semanticsNode2.getConfig().props.get(SemanticsProperties.CollectionInfo);
                                                if (obj8 == null) {
                                                    obj8 = null;
                                                }
                                                if (obj8 == null) {
                                                    obj9 = semanticsNode2.getConfig().props.get(SemanticsProperties.SelectableGroup);
                                                    if (obj9 == null) {
                                                        obj9 = null;
                                                    }
                                                    if (obj9 != null) {
                                                        z6 = true;
                                                    } else {
                                                        z6 = false;
                                                    }
                                                } else {
                                                    z6 = true;
                                                }
                                                if (!z6) {
                                                    accessibilityNodeInfoCompat.setClassName("android.widget.HorizontalScrollView");
                                                }
                                                if (((Number) scrollAxisRange.maxValue.invoke()).floatValue() > 0.0f) {
                                                    accessibilityNodeInfo3.setScrollable(true);
                                                }
                                                if (InvertMatrixKt.access$enabled(semanticsNode2)) {
                                                    zPopulateAccessibilityNodeInfoProperties$canScrollForward = AndroidComposeViewAccessibilityDelegateCompat.populateAccessibilityNodeInfoProperties$canScrollForward(scrollAxisRange);
                                                    layoutDirection = LayoutDirection.Rtl;
                                                    if (zPopulateAccessibilityNodeInfoProperties$canScrollForward) {
                                                        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                                                        layoutNode = layoutNode2;
                                                        if (layoutNode.layoutDirection == layoutDirection) {
                                                            z8 = true;
                                                        } else {
                                                            z8 = false;
                                                        }
                                                        if (z8) {
                                                            accessibilityActionCompat2 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT;
                                                        } else {
                                                            accessibilityActionCompat2 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT;
                                                        }
                                                        accessibilityNodeInfoCompat.addAction(accessibilityActionCompat2);
                                                    } else {
                                                        layoutNode = layoutNode2;
                                                    }
                                                    if (AndroidComposeViewAccessibilityDelegateCompat.populateAccessibilityNodeInfoProperties$canScrollBackward(scrollAxisRange)) {
                                                        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                                                        if (layoutNode.layoutDirection == layoutDirection) {
                                                            z7 = true;
                                                        } else {
                                                            z7 = false;
                                                        }
                                                        if (z7) {
                                                            accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT;
                                                        } else {
                                                            accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT;
                                                        }
                                                        accessibilityNodeInfoCompat.addAction(accessibilityActionCompat);
                                                    }
                                                }
                                            }
                                            scrollAxisRange2 = (ScrollAxisRange) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsProperties.VerticalScrollAxisRange);
                                            if (scrollAxisRange2 != null) {
                                                obj6 = semanticsNode2.getConfig().props.get(SemanticsProperties.CollectionInfo);
                                                if (obj6 == null) {
                                                    obj6 = null;
                                                }
                                                if (obj6 == null) {
                                                    obj7 = semanticsNode2.getConfig().props.get(SemanticsProperties.SelectableGroup);
                                                    if (obj7 == null) {
                                                        obj7 = null;
                                                    }
                                                    if (obj7 != null) {
                                                        z5 = true;
                                                    } else {
                                                        z5 = false;
                                                    }
                                                } else {
                                                    z5 = true;
                                                }
                                                if (!z5) {
                                                    accessibilityNodeInfoCompat.setClassName("android.widget.ScrollView");
                                                }
                                                if (((Number) scrollAxisRange2.maxValue.invoke()).floatValue() > 0.0f) {
                                                    accessibilityNodeInfo3.setScrollable(true);
                                                }
                                                if (InvertMatrixKt.access$enabled(semanticsNode2)) {
                                                    if (AndroidComposeViewAccessibilityDelegateCompat.populateAccessibilityNodeInfoProperties$canScrollForward(scrollAxisRange2)) {
                                                        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                                                        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
                                                    }
                                                    if (AndroidComposeViewAccessibilityDelegateCompat.populateAccessibilityNodeInfoProperties$canScrollBackward(scrollAxisRange2)) {
                                                        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                                                        accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
                                                    }
                                                }
                                            }
                                            if (i7 >= 29) {
                                                InvertMatrixKt.addPageActions(semanticsNode2, accessibilityNodeInfoCompat);
                                            }
                                            charSequence = (CharSequence) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsProperties.PaneTitle);
                                            if (i7 >= 28) {
                                                accessibilityNodeInfo3.setPaneTitle(charSequence);
                                            } else {
                                                accessibilityNodeInfo3.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
                                            }
                                            if (InvertMatrixKt.access$enabled(semanticsNode2)) {
                                                accessibilityAction4 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsActions.Expand);
                                                if (accessibilityAction4 != null) {
                                                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction4.getLabel(), 262144));
                                                    Unit unit1117 = Unit.INSTANCE;
                                                }
                                                accessibilityAction5 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsActions.Collapse);
                                                if (accessibilityAction5 != null) {
                                                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction5.getLabel(), 524288));
                                                    Unit unit1118 = Unit.INSTANCE;
                                                }
                                                accessibilityAction6 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsActions.Dismiss);
                                                if (accessibilityAction6 != null) {
                                                    accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction6.getLabel(), 1048576));
                                                    Unit unit1119 = Unit.INSTANCE;
                                                }
                                                unmergedConfig$ui = semanticsNode2.getUnmergedConfig$ui();
                                                semanticsPropertyKey3 = SemanticsActions.CustomActions;
                                                if (unmergedConfig$ui.contains(semanticsPropertyKey3)) {
                                                    list2 = (List) semanticsNode2.getUnmergedConfig$ui().get(semanticsPropertyKey3);
                                                    size2 = list2.size();
                                                    mutableIntList = AndroidComposeViewAccessibilityDelegateCompat.AccessibilityActionsResourceIds;
                                                    if (size2 < mutableIntList._size) {
                                                        throw new IllegalStateException(ImageAnalysis$$ExternalSyntheticLambda1.m(new StringBuilder("Can't have more than "), mutableIntList._size, " custom actions for one widget"));
                                                    }
                                                    SparseArrayCompat sparseArrayCompat6 = new SparseArrayCompat(0);
                                                    MutableObjectIntMap mutableObjectIntMapMutableObjectIntMapOf3 = ObjectIntMapKt.mutableObjectIntMapOf();
                                                    sparseArrayCompat3 = sparseArrayCompat2;
                                                    if (sparseArrayCompat3.garbage) {
                                                        ArraySetKt.access$gc(sparseArrayCompat3);
                                                    }
                                                    if (RuntimeHelpersKt.binarySearch(sparseArrayCompat3.size, i6, sparseArrayCompat3.keys) >= 0) {
                                                        z4 = true;
                                                    } else {
                                                        z4 = false;
                                                    }
                                                    if (z4) {
                                                        iArr = mutableIntList.content;
                                                        i8 = mutableIntList._size;
                                                        iArrCopyOf = new int[16];
                                                        i9 = 0;
                                                        i10 = 0;
                                                        while (i9 < i8) {
                                                            int i317 = iArr[i9];
                                                            char c4 = c;
                                                            i11 = i10 + 1;
                                                            int i44 = i8;
                                                            if (iArrCopyOf.length < i11) {
                                                                iArrCopyOf = Arrays.copyOf(iArrCopyOf, Math.max(i11, (iArrCopyOf.length * 3) / 2));
                                                            }
                                                            iArrCopyOf[i10] = i317;
                                                            i9++;
                                                            i10 = i11;
                                                            c = c4;
                                                            i8 = i44;
                                                        }
                                                        arrayList = new ArrayList();
                                                        if (list2.size() <= 0) {
                                                            Modifier.CC.m(list2.get(0));
                                                            throw null;
                                                        }
                                                        if (arrayList.size() > 0) {
                                                            Modifier.CC.m(arrayList.get(0));
                                                            if (i10 > 0) {
                                                                int i45 = iArrCopyOf[0];
                                                                throw null;
                                                            }
                                                            RuntimeHelpersKt.throwIndexOutOfBoundsException("Index must be between 0 and size");
                                                            throw null;
                                                        }
                                                    } else if (list2.size() > 0) {
                                                        Modifier.CC.m(list2.get(0));
                                                        mutableIntList.get(0);
                                                        throw null;
                                                    }
                                                    androidComposeViewAccessibilityDelegateCompat.actionIdToLabel.put(i6, sparseArrayCompat6);
                                                    sparseArrayCompat3.put(i6, mutableObjectIntMapMutableObjectIntMapOf3);
                                                }
                                            }
                                            zAccess$isScreenReaderFocusable = InvertMatrixKt.access$isScreenReaderFocusable(semanticsNode2, resources6);
                                            if (Build.VERSION.SDK_INT >= 28) {
                                                accessibilityNodeInfo3.setScreenReaderFocusable(zAccess$isScreenReaderFocusable);
                                            } else {
                                                accessibilityNodeInfoCompat.setBooleanProperty(1, zAccess$isScreenReaderFocusable);
                                            }
                                            orDefault = androidComposeViewAccessibilityDelegateCompat.idToBeforeMap.getOrDefault(i6, -1);
                                            if (orDefault != -1) {
                                                InvertMatrixKt.semanticsIdToView(androidComposeView2.getAndroidViewsHandler$ui(), orDefault);
                                                androidComposeView = androidComposeView2;
                                                accessibilityNodeInfo3.setTraversalBefore(androidComposeView, orDefault);
                                                androidComposeViewAccessibilityDelegateCompat.addExtraDataToAccessibilityNodeInfoHelper(i6, accessibilityNodeInfoCompat, androidComposeViewAccessibilityDelegateCompat.ExtraDataTestTraversalBeforeVal, null);
                                            } else {
                                                androidComposeView = androidComposeView2;
                                            }
                                            orDefault2 = androidComposeViewAccessibilityDelegateCompat.idToAfterMap.getOrDefault(i6, -1);
                                            if (orDefault2 != -1) {
                                                InvertMatrixKt.semanticsIdToView(androidComposeView.getAndroidViewsHandler$ui(), orDefault2);
                                            }
                                            str3 = (String) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsPropertiesAndroid.AccessibilityClassName);
                                            if (str3 != null) {
                                                accessibilityNodeInfoCompat.setClassName(str3);
                                                Unit unit211 = Unit.INSTANCE;
                                            }
                                            accessibilityNodeInfoCompat2 = accessibilityNodeInfoCompat;
                                        } else {
                                            androidComposeViewAccessibilityDelegateCompat = androidComposeViewAccessibilityDelegateCompat2;
                                        }
                                        z2 = true;
                                        accessibilityNodeInfo3.setVisibleToUser(SemanticsNodeKt.isHidden(semanticsNode2) ^ z2);
                                        if (semanticsNode2.isFake$ui()) {
                                            parent2 = semanticsNode2.getParent();
                                        } else {
                                            parent2 = semanticsNode2;
                                        }
                                        if (parent2.getTouchBoundsInRoot().isEmpty()) {
                                            accessibilityNodeInfo3.setVisibleToUser(false);
                                        }
                                        liveRegionMode = (LiveRegionMode) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsProperties.LiveRegion);
                                        if (liveRegionMode != null) {
                                            i12 = liveRegionMode.value;
                                            if (i12 == 0) {
                                                z15 = true;
                                            } else {
                                                z15 = false;
                                            }
                                            if (z15) {
                                                if (i12 == 1) {
                                                    z16 = true;
                                                } else {
                                                    z16 = false;
                                                }
                                                if (z16) {
                                                    i13 = 2;
                                                } else {
                                                    i13 = 1;
                                                }
                                            } else {
                                                i13 = 1;
                                            }
                                            accessibilityNodeInfoObtain.setLiveRegion(i13);
                                            Unit unit212 = Unit.INSTANCE;
                                        }
                                        accessibilityNodeInfo3.setClickable(false);
                                        accessibilityAction = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsActions.OnClick);
                                        c = 3;
                                        if (accessibilityAction != null) {
                                            boolean zAreEqual6 = Intrinsics.areEqual(SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsProperties.Selected), bool2);
                                            if (role3 == null) {
                                                z11 = false;
                                            } else {
                                                z11 = true;
                                            }
                                            if (z11) {
                                                z12 = true;
                                            } else {
                                                if (role3 == null) {
                                                    z14 = false;
                                                } else {
                                                    z14 = true;
                                                }
                                                if (z14) {
                                                    z12 = true;
                                                } else {
                                                    z12 = false;
                                                }
                                            }
                                            if (z12) {
                                                z13 = true;
                                            } else {
                                                z13 = true;
                                            }
                                            accessibilityNodeInfo3.setClickable(z13);
                                            if (InvertMatrixKt.access$enabled(semanticsNode2)) {
                                                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction.label, 16));
                                            }
                                            Unit unit11110 = Unit.INSTANCE;
                                        }
                                        accessibilityNodeInfo3.setLongClickable(false);
                                        accessibilityAction2 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsActions.OnLongClick);
                                        if (accessibilityAction2 != null) {
                                            accessibilityNodeInfo3.setLongClickable(true);
                                            if (InvertMatrixKt.access$enabled(semanticsNode2)) {
                                                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction2.label, 32));
                                            }
                                            Unit unit11111 = Unit.INSTANCE;
                                        }
                                        accessibilityAction3 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsActions.CopyText);
                                        if (accessibilityAction3 != null) {
                                            accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction3.label, 16384));
                                            Unit unit11112 = Unit.INSTANCE;
                                        }
                                        if (InvertMatrixKt.access$enabled(semanticsNode2)) {
                                            accessibilityAction8 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsActions.SetText);
                                            if (accessibilityAction8 != null) {
                                                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction8.label, 2097152));
                                                Unit unit11113 = Unit.INSTANCE;
                                            }
                                            accessibilityAction9 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsConfiguration3, SemanticsActions.OnImeAction);
                                            if (accessibilityAction9 != null) {
                                                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction9.getLabel(), android.R.id.accessibilityActionImeEnter));
                                                Unit unit11114 = Unit.INSTANCE;
                                            }
                                            accessibilityAction10 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsActions.CutText);
                                            if (accessibilityAction10 != null) {
                                                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction10.getLabel(), 65536));
                                                Unit unit11115 = Unit.INSTANCE;
                                            }
                                            accessibilityAction11 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsActions.PasteText);
                                            if (accessibilityAction11 != null) {
                                                if (accessibilityNodeInfo3.isFocused()) {
                                                    primaryClipDescription = androidComposeView2.m598getClipboardManager().getClipboardManager().getPrimaryClipDescription();
                                                    if (primaryClipDescription != null) {
                                                        zHasMimeType = primaryClipDescription.hasMimeType("text/*");
                                                    } else {
                                                        zHasMimeType = false;
                                                    }
                                                    if (zHasMimeType) {
                                                        accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction11.getLabel(), 32768));
                                                    }
                                                }
                                                Unit unit11116 = Unit.INSTANCE;
                                            }
                                        }
                                        iterableTextForAccessibility = AndroidComposeViewAccessibilityDelegateCompat.getIterableTextForAccessibility(semanticsNode2);
                                        if (iterableTextForAccessibility != null) {
                                            z3 = true;
                                        } else {
                                            z3 = true;
                                        }
                                        if (!z3) {
                                            accessibilityNodeInfo3.setTextSelection(androidComposeViewAccessibilityDelegateCompat.getAccessibilitySelectionStart(semanticsNode2), androidComposeViewAccessibilityDelegateCompat.getAccessibilitySelectionEnd(semanticsNode2));
                                            accessibilityAction7 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsActions.SetSelection);
                                            if (accessibilityAction7 != null) {
                                                label = accessibilityAction7.getLabel();
                                            } else {
                                                label = null;
                                            }
                                            accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(label, 131072));
                                            accessibilityNodeInfoCompat.addAction(256);
                                            accessibilityNodeInfoCompat.addAction(512);
                                            accessibilityNodeInfo3.setMovementGranularities(11);
                                            list3 = (List) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsProperties.ContentDescription);
                                            if (list3 != null) {
                                                z10 = true;
                                            } else {
                                                z10 = true;
                                            }
                                            if (z10) {
                                                accessibilityNodeInfo3.setMovementGranularities(accessibilityNodeInfo3.getMovementGranularities() | 20);
                                            }
                                        }
                                        if (Build.VERSION.SDK_INT >= 26) {
                                            arrayList2 = new ArrayList();
                                            arrayList2.add("androidx.compose.ui.semantics.id");
                                            text = accessibilityNodeInfoCompat.getText();
                                            if (text != null) {
                                                z9 = true;
                                            } else {
                                                z9 = true;
                                            }
                                            if (!z9) {
                                                arrayList2.add("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY");
                                            }
                                            if (semanticsNode2.getUnmergedConfig$ui().contains(SemanticsProperties.TestTag)) {
                                                arrayList2.add("androidx.compose.ui.semantics.testTag");
                                            }
                                            if (semanticsNode2.getUnmergedConfig$ui().contains(SemanticsProperties.Shape)) {
                                                arrayList2.add("androidx.compose.ui.semantics.shapeType");
                                                arrayList2.add("androidx.compose.ui.semantics.shapeRect");
                                                arrayList2.add("androidx.compose.ui.semantics.shapeCorners");
                                                arrayList2.add("androidx.compose.ui.semantics.shapeRegion");
                                            }
                                            semanticsNode2.getUnmergedConfig$ui().getClass();
                                            if (Build.VERSION.SDK_INT >= 26) {
                                                accessibilityNodeInfo3.setAvailableExtraData(arrayList2);
                                            }
                                        }
                                        progressBarRangeInfo = (ProgressBarRangeInfo) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsProperties.ProgressBarRangeInfo);
                                        if (progressBarRangeInfo != null) {
                                            unmergedConfig$ui2 = semanticsNode2.getUnmergedConfig$ui();
                                            semanticsPropertyKey4 = SemanticsActions.SetProgress;
                                            if (unmergedConfig$ui2.contains(semanticsPropertyKey4)) {
                                                accessibilityNodeInfoCompat.setClassName("android.widget.SeekBar");
                                            } else {
                                                accessibilityNodeInfoCompat.setClassName("android.widget.ProgressBar");
                                            }
                                            ProgressBarRangeInfo progressBarRangeInfo5 = ProgressBarRangeInfo.Indeterminate;
                                            if (progressBarRangeInfo != ProgressBarRangeInfo.Indeterminate) {
                                                progressBarRangeInfo.getRange().getClass();
                                                float fFloatValue8 = fValueOf.floatValue();
                                                progressBarRangeInfo.getRange().getClass();
                                                accessibilityNodeInfo3.setRangeInfo((AccessibilityNodeInfo.RangeInfo) new ExposureStateImpl(AccessibilityNodeInfo.RangeInfo.obtain(1, fFloatValue8, fValueOf.floatValue(), 0.0f)).mLock);
                                            }
                                            if (semanticsNode2.getUnmergedConfig$ui().contains(semanticsPropertyKey4)) {
                                                progressBarRangeInfo.getRange().getClass();
                                                fFloatValue = fValueOf.floatValue();
                                                progressBarRangeInfo.getRange().getClass();
                                                fFloatValue2 = fValueOf.floatValue();
                                                if (fFloatValue < fFloatValue2) {
                                                    fFloatValue = fFloatValue2;
                                                }
                                                if (0.0f < fFloatValue) {
                                                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                                                }
                                                progressBarRangeInfo.getRange().getClass();
                                                fFloatValue3 = fValueOf.floatValue();
                                                progressBarRangeInfo.getRange().getClass();
                                                fFloatValue4 = fValueOf.floatValue();
                                                if (fFloatValue3 > fFloatValue4) {
                                                    fFloatValue3 = fFloatValue4;
                                                }
                                                if (0.0f > fFloatValue3) {
                                                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                                                }
                                            }
                                        }
                                        i7 = Build.VERSION.SDK_INT;
                                        if (i7 >= 24) {
                                            InvertMatrixKt.addSetProgressAction(semanticsNode2, accessibilityNodeInfoCompat);
                                        }
                                        zztj.setCollectionInfo(semanticsNode2, accessibilityNodeInfoCompat);
                                        zztj.setCollectionItemInfo(semanticsNode2, accessibilityNodeInfoCompat);
                                        scrollAxisRange = (ScrollAxisRange) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsProperties.HorizontalScrollAxisRange);
                                        AccessibilityAction accessibilityAction15 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsActions.ScrollBy);
                                        if (scrollAxisRange != null) {
                                            obj8 = semanticsNode2.getConfig().props.get(SemanticsProperties.CollectionInfo);
                                            if (obj8 == null) {
                                                obj8 = null;
                                            }
                                            if (obj8 == null) {
                                                obj9 = semanticsNode2.getConfig().props.get(SemanticsProperties.SelectableGroup);
                                                if (obj9 == null) {
                                                    obj9 = null;
                                                }
                                                if (obj9 != null) {
                                                    z6 = true;
                                                } else {
                                                    z6 = false;
                                                }
                                            } else {
                                                z6 = true;
                                            }
                                            if (!z6) {
                                                accessibilityNodeInfoCompat.setClassName("android.widget.HorizontalScrollView");
                                            }
                                            if (((Number) scrollAxisRange.maxValue.invoke()).floatValue() > 0.0f) {
                                                accessibilityNodeInfo3.setScrollable(true);
                                            }
                                            if (InvertMatrixKt.access$enabled(semanticsNode2)) {
                                                zPopulateAccessibilityNodeInfoProperties$canScrollForward = AndroidComposeViewAccessibilityDelegateCompat.populateAccessibilityNodeInfoProperties$canScrollForward(scrollAxisRange);
                                                layoutDirection = LayoutDirection.Rtl;
                                                if (zPopulateAccessibilityNodeInfoProperties$canScrollForward) {
                                                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                                                    layoutNode = layoutNode2;
                                                    if (layoutNode.layoutDirection == layoutDirection) {
                                                        z8 = true;
                                                    } else {
                                                        z8 = false;
                                                    }
                                                    if (z8) {
                                                        accessibilityActionCompat2 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT;
                                                    } else {
                                                        accessibilityActionCompat2 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT;
                                                    }
                                                    accessibilityNodeInfoCompat.addAction(accessibilityActionCompat2);
                                                } else {
                                                    layoutNode = layoutNode2;
                                                }
                                                if (AndroidComposeViewAccessibilityDelegateCompat.populateAccessibilityNodeInfoProperties$canScrollBackward(scrollAxisRange)) {
                                                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                                                    if (layoutNode.layoutDirection == layoutDirection) {
                                                        z7 = true;
                                                    } else {
                                                        z7 = false;
                                                    }
                                                    if (z7) {
                                                        accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT;
                                                    } else {
                                                        accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT;
                                                    }
                                                    accessibilityNodeInfoCompat.addAction(accessibilityActionCompat);
                                                }
                                            }
                                        }
                                        scrollAxisRange2 = (ScrollAxisRange) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsProperties.VerticalScrollAxisRange);
                                        if (scrollAxisRange2 != null) {
                                            obj6 = semanticsNode2.getConfig().props.get(SemanticsProperties.CollectionInfo);
                                            if (obj6 == null) {
                                                obj6 = null;
                                            }
                                            if (obj6 == null) {
                                                obj7 = semanticsNode2.getConfig().props.get(SemanticsProperties.SelectableGroup);
                                                if (obj7 == null) {
                                                    obj7 = null;
                                                }
                                                if (obj7 != null) {
                                                    z5 = true;
                                                } else {
                                                    z5 = false;
                                                }
                                            } else {
                                                z5 = true;
                                            }
                                            if (!z5) {
                                                accessibilityNodeInfoCompat.setClassName("android.widget.ScrollView");
                                            }
                                            if (((Number) scrollAxisRange2.maxValue.invoke()).floatValue() > 0.0f) {
                                                accessibilityNodeInfo3.setScrollable(true);
                                            }
                                            if (InvertMatrixKt.access$enabled(semanticsNode2)) {
                                                if (AndroidComposeViewAccessibilityDelegateCompat.populateAccessibilityNodeInfoProperties$canScrollForward(scrollAxisRange2)) {
                                                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                                                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
                                                }
                                                if (AndroidComposeViewAccessibilityDelegateCompat.populateAccessibilityNodeInfoProperties$canScrollBackward(scrollAxisRange2)) {
                                                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                                                    accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
                                                }
                                            }
                                        }
                                        if (i7 >= 29) {
                                            InvertMatrixKt.addPageActions(semanticsNode2, accessibilityNodeInfoCompat);
                                        }
                                        charSequence = (CharSequence) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsProperties.PaneTitle);
                                        if (i7 >= 28) {
                                            accessibilityNodeInfo3.setPaneTitle(charSequence);
                                        } else {
                                            accessibilityNodeInfo3.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
                                        }
                                        if (InvertMatrixKt.access$enabled(semanticsNode2)) {
                                            accessibilityAction4 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsActions.Expand);
                                            if (accessibilityAction4 != null) {
                                                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction4.getLabel(), 262144));
                                                Unit unit11117 = Unit.INSTANCE;
                                            }
                                            accessibilityAction5 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsActions.Collapse);
                                            if (accessibilityAction5 != null) {
                                                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction5.getLabel(), 524288));
                                                Unit unit11118 = Unit.INSTANCE;
                                            }
                                            accessibilityAction6 = (AccessibilityAction) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsActions.Dismiss);
                                            if (accessibilityAction6 != null) {
                                                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(accessibilityAction6.getLabel(), 1048576));
                                                Unit unit11119 = Unit.INSTANCE;
                                            }
                                            unmergedConfig$ui = semanticsNode2.getUnmergedConfig$ui();
                                            semanticsPropertyKey3 = SemanticsActions.CustomActions;
                                            if (unmergedConfig$ui.contains(semanticsPropertyKey3)) {
                                                list2 = (List) semanticsNode2.getUnmergedConfig$ui().get(semanticsPropertyKey3);
                                                size2 = list2.size();
                                                mutableIntList = AndroidComposeViewAccessibilityDelegateCompat.AccessibilityActionsResourceIds;
                                                if (size2 < mutableIntList._size) {
                                                    throw new IllegalStateException(ImageAnalysis$$ExternalSyntheticLambda1.m(new StringBuilder("Can't have more than "), mutableIntList._size, " custom actions for one widget"));
                                                }
                                                SparseArrayCompat sparseArrayCompat7 = new SparseArrayCompat(0);
                                                MutableObjectIntMap mutableObjectIntMapMutableObjectIntMapOf4 = ObjectIntMapKt.mutableObjectIntMapOf();
                                                sparseArrayCompat3 = sparseArrayCompat2;
                                                if (sparseArrayCompat3.garbage) {
                                                    ArraySetKt.access$gc(sparseArrayCompat3);
                                                }
                                                if (RuntimeHelpersKt.binarySearch(sparseArrayCompat3.size, i6, sparseArrayCompat3.keys) >= 0) {
                                                    z4 = true;
                                                } else {
                                                    z4 = false;
                                                }
                                                if (z4) {
                                                    iArr = mutableIntList.content;
                                                    i8 = mutableIntList._size;
                                                    iArrCopyOf = new int[16];
                                                    i9 = 0;
                                                    i10 = 0;
                                                    while (i9 < i8) {
                                                        int i318 = iArr[i9];
                                                        char c5 = c;
                                                        i11 = i10 + 1;
                                                        int i46 = i8;
                                                        if (iArrCopyOf.length < i11) {
                                                            iArrCopyOf = Arrays.copyOf(iArrCopyOf, Math.max(i11, (iArrCopyOf.length * 3) / 2));
                                                        }
                                                        iArrCopyOf[i10] = i318;
                                                        i9++;
                                                        i10 = i11;
                                                        c = c5;
                                                        i8 = i46;
                                                    }
                                                    arrayList = new ArrayList();
                                                    if (list2.size() <= 0) {
                                                        Modifier.CC.m(list2.get(0));
                                                        throw null;
                                                    }
                                                    if (arrayList.size() > 0) {
                                                        Modifier.CC.m(arrayList.get(0));
                                                        if (i10 > 0) {
                                                            int i47 = iArrCopyOf[0];
                                                            throw null;
                                                        }
                                                        RuntimeHelpersKt.throwIndexOutOfBoundsException("Index must be between 0 and size");
                                                        throw null;
                                                    }
                                                } else if (list2.size() > 0) {
                                                    Modifier.CC.m(list2.get(0));
                                                    mutableIntList.get(0);
                                                    throw null;
                                                }
                                                androidComposeViewAccessibilityDelegateCompat.actionIdToLabel.put(i6, sparseArrayCompat7);
                                                sparseArrayCompat3.put(i6, mutableObjectIntMapMutableObjectIntMapOf4);
                                            }
                                        }
                                        zAccess$isScreenReaderFocusable = InvertMatrixKt.access$isScreenReaderFocusable(semanticsNode2, resources6);
                                        if (Build.VERSION.SDK_INT >= 28) {
                                            accessibilityNodeInfo3.setScreenReaderFocusable(zAccess$isScreenReaderFocusable);
                                        } else {
                                            accessibilityNodeInfoCompat.setBooleanProperty(1, zAccess$isScreenReaderFocusable);
                                        }
                                        orDefault = androidComposeViewAccessibilityDelegateCompat.idToBeforeMap.getOrDefault(i6, -1);
                                        if (orDefault != -1) {
                                            InvertMatrixKt.semanticsIdToView(androidComposeView2.getAndroidViewsHandler$ui(), orDefault);
                                            androidComposeView = androidComposeView2;
                                            accessibilityNodeInfo3.setTraversalBefore(androidComposeView, orDefault);
                                            androidComposeViewAccessibilityDelegateCompat.addExtraDataToAccessibilityNodeInfoHelper(i6, accessibilityNodeInfoCompat, androidComposeViewAccessibilityDelegateCompat.ExtraDataTestTraversalBeforeVal, null);
                                        } else {
                                            androidComposeView = androidComposeView2;
                                        }
                                        orDefault2 = androidComposeViewAccessibilityDelegateCompat.idToAfterMap.getOrDefault(i6, -1);
                                        if (orDefault2 != -1) {
                                            InvertMatrixKt.semanticsIdToView(androidComposeView.getAndroidViewsHandler$ui(), orDefault2);
                                        }
                                        str3 = (String) SemanticsNodeKt.getOrNull(semanticsNode2.getUnmergedConfig$ui(), SemanticsPropertiesAndroid.AccessibilityClassName);
                                        if (str3 != null) {
                                            accessibilityNodeInfoCompat.setClassName(str3);
                                            Unit unit213 = Unit.INSTANCE;
                                        }
                                        accessibilityNodeInfoCompat2 = accessibilityNodeInfoCompat;
                                    }
                                }
                            } else {
                                i6 = i;
                                androidComposeViewAccessibilityDelegateCompat = androidComposeViewAccessibilityDelegateCompat2;
                                accessibilityNodeInfoCompat2 = null;
                            }
                        }
                    }
                    if (androidComposeViewAccessibilityDelegateCompat.sendingFocusAffectingEvent) {
                        if (i6 == androidComposeViewAccessibilityDelegateCompat.accessibilityFocusedVirtualViewId) {
                            androidComposeViewAccessibilityDelegateCompat.currentlyAccessibilityFocusedANI = accessibilityNodeInfoCompat2;
                        }
                        if (i6 == androidComposeViewAccessibilityDelegateCompat.focusedVirtualViewId) {
                            androidComposeViewAccessibilityDelegateCompat.currentlyFocusedANI = accessibilityNodeInfoCompat2;
                        }
                    }
                    return accessibilityNodeInfoCompat2;
            }
        }

        @Override // coil.request.Parameters.Builder
        public final AccessibilityNodeInfoCompat findFocus(int i) {
            switch (this.$r8$classId) {
                case 0:
                    ExploreByTouchHelper exploreByTouchHelper = (ExploreByTouchHelper) this.this$0;
                    int i2 = i == 2 ? exploreByTouchHelper.mAccessibilityFocusedVirtualViewId : exploreByTouchHelper.mKeyboardFocusedVirtualViewId;
                    if (i2 == Integer.MIN_VALUE) {
                        return null;
                    }
                    return createAccessibilityNodeInfo(i2);
                default:
                    AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = (AndroidComposeViewAccessibilityDelegateCompat) this.this$0;
                    if (i != 1) {
                        if (i == 2) {
                            return createAccessibilityNodeInfo(androidComposeViewAccessibilityDelegateCompat.accessibilityFocusedVirtualViewId);
                        }
                        throw new IllegalArgumentException(ImageAnalysis$$ExternalSyntheticLambda1.m("Unknown focus type: ", i));
                    }
                    int i3 = androidComposeViewAccessibilityDelegateCompat.focusedVirtualViewId;
                    if (i3 == Integer.MIN_VALUE) {
                        return null;
                    }
                    return createAccessibilityNodeInfo(i3);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code duplicated, block: B:155:0x026f  */
        /* JADX WARN: Code duplicated, block: B:20:0x0056  */
        /* JADX WARN: Code duplicated, block: B:22:0x005c  */
        /* JADX WARN: Code duplicated, block: B:24:0x0060  */
        /* JADX WARN: Code duplicated, block: B:274:0x0467  */
        /* JADX WARN: Code duplicated, block: B:275:0x0469  */
        /* JADX WARN: Code duplicated, block: B:278:0x046e  */
        /* JADX WARN: Code duplicated, block: B:279:0x0470  */
        /* JADX WARN: Code duplicated, block: B:282:0x0476  */
        /* JADX WARN: Code duplicated, block: B:283:0x0478  */
        /* JADX WARN: Code duplicated, block: B:286:0x047e  */
        /* JADX WARN: Code duplicated, block: B:287:0x0480  */
        /* JADX WARN: Code duplicated, block: B:290:0x0486  */
        /* JADX WARN: Code duplicated, block: B:291:0x0488  */
        /* JADX WARN: Code duplicated, block: B:294:0x048e  */
        /* JADX WARN: Code duplicated, block: B:295:0x0490  */
        /* JADX WARN: Code duplicated, block: B:302:0x049c  */
        /* JADX WARN: Code duplicated, block: B:309:0x04a8  */
        /* JADX WARN: Code duplicated, block: B:312:0x04ad  */
        /* JADX WARN: Code duplicated, block: B:314:0x04b5  */
        /* JADX WARN: Code duplicated, block: B:317:0x04c0  */
        /* JADX WARN: Code duplicated, block: B:320:0x04c5 A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:327:0x04e7  */
        /* JADX WARN: Code duplicated, block: B:329:0x0502  */
        /* JADX WARN: Code duplicated, block: B:332:0x0507  */
        /* JADX WARN: Code duplicated, block: B:337:0x0521  */
        /* JADX WARN: Code duplicated, block: B:340:0x052a  */
        /* JADX WARN: Code duplicated, block: B:344:0x0531  */
        /* JADX WARN: Code duplicated, block: B:346:0x053b  */
        /* JADX WARN: Code duplicated, block: B:349:0x0540 A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:393:0x05cc  */
        /* JADX WARN: Code duplicated, block: B:396:0x05d8  */
        /* JADX WARN: Code duplicated, block: B:399:0x05dd A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:401:0x05e1  */
        /* JADX WARN: Code duplicated, block: B:402:0x05e6  */
        /* JADX WARN: Code duplicated, block: B:404:0x05ef A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:405:0x05f1  */
        /* JADX WARN: Code duplicated, block: B:408:0x05f6  */
        /* JADX WARN: Code duplicated, block: B:411:0x05fd  */
        /* JADX WARN: Code duplicated, block: B:413:0x0605  */
        /* JADX WARN: Code duplicated, block: B:419:0x0622  */
        /* JADX WARN: Code duplicated, block: B:421:0x0626  */
        /* JADX WARN: Code duplicated, block: B:423:0x062e  */
        /* JADX WARN: Code duplicated, block: B:424:0x0630  */
        /* JADX WARN: Code duplicated, block: B:426:0x0634  */
        /* JADX WARN: Code duplicated, block: B:428:0x063a  */
        /* JADX WARN: Code duplicated, block: B:429:0x063c  */
        /* JADX WARN: Code duplicated, block: B:432:0x0641  */
        /* JADX WARN: Code duplicated, block: B:497:0x0737  */
        /* JADX WARN: Code duplicated, block: B:499:0x0745  */
        /* JADX WARN: Code duplicated, block: B:500:0x0747  */
        /* JADX WARN: Code duplicated, block: B:503:0x074c  */
        /* JADX WARN: Code duplicated, block: B:528:0x0789  */
        /* JADX WARN: Code duplicated, block: B:533:0x079d  */
        /* JADX WARN: Code duplicated, block: B:540:0x07af  */
        /* JADX WARN: Code duplicated, block: B:542:0x07b3  */
        /* JADX WARN: Code duplicated, block: B:545:0x07c3  */
        /* JADX WARN: Code duplicated, block: B:547:0x07c7  */
        /* JADX WARN: Code duplicated, block: B:559:0x082b  */
        /* JADX WARN: Code duplicated, block: B:561:0x0832 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:562:0x0834  */
        /* JADX WARN: Code duplicated, block: B:563:0x0836  */
        /* JADX WARN: Code duplicated, block: B:566:0x083d  */
        /* JADX WARN: Code duplicated, block: B:567:0x0842  */
        /* JADX WARN: Code duplicated, block: B:570:0x084a  */
        /* JADX WARN: Code duplicated, block: B:584:0x087a A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:585:0x087c  */
        /* JADX WARN: Code duplicated, block: B:586:0x087f  */
        /* JADX WARN: Code duplicated, block: B:589:0x0884  */
        /* JADX WARN: Code duplicated, block: B:590:0x0887  */
        /* JADX WARN: Code duplicated, block: B:592:0x08a2  */
        /* JADX WARN: Code duplicated, block: B:594:0x08a6  */
        /* JADX WARN: Code duplicated, block: B:595:0x08a8  */
        /* JADX WARN: Code duplicated, block: B:597:0x08ab  */
        /* JADX WARN: Code duplicated, block: B:598:0x08bc  */
        /* JADX WARN: Code duplicated, block: B:603:0x08ca  */
        /* JADX WARN: Code duplicated, block: B:606:0x08ce  */
        /* JADX WARN: Code duplicated, block: B:608:0x08d2  */
        /* JADX WARN: Code duplicated, block: B:609:0x08d4  */
        /* JADX WARN: Code duplicated, block: B:611:0x08d7  */
        /* JADX WARN: Code duplicated, block: B:613:0x08db  */
        /* JADX WARN: Code duplicated, block: B:614:0x08e2  */
        /* JADX WARN: Code duplicated, block: B:95:0x0148  */
        /* JADX WARN: Code restructure failed: missing block: B:661:0x01be, code lost:
        
            r2 = null;
         */
        @Override // coil.request.Parameters.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean performAction(int r30, int r31, android.os.Bundle r32) {
            /*
                Method dump skipped, instruction units count: 2522
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.ExploreByTouchHelper.MyNodeProvider.performAction(int, int, android.os.Bundle):boolean");
        }
    }

    public ExploreByTouchHelper(Chip chip) {
        this.mHost = chip;
        this.mManager = (AccessibilityManager) chip.getContext().getSystemService("accessibility");
        chip.setFocusable(true);
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        if (chip.getImportantForAccessibility() == 0) {
            chip.setImportantForAccessibility(1);
        }
    }

    public final boolean clearKeyboardFocusForVirtualView(int i) {
        if (this.mKeyboardFocusedVirtualViewId != i) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
        Chip.ChipTouchHelper chipTouchHelper = (Chip.ChipTouchHelper) this;
        if (i == 1) {
            Chip chip = Chip.this;
            chip.closeIconFocused = false;
            chip.refreshDrawableState();
        }
        sendEventForVirtualView(i, 8);
        return true;
    }

    public final AccessibilityNodeInfoCompat createNodeForChild(int i) {
        AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain();
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = new AccessibilityNodeInfoCompat(accessibilityNodeInfoObtain);
        accessibilityNodeInfoObtain.setEnabled(true);
        accessibilityNodeInfoObtain.setFocusable(true);
        accessibilityNodeInfoCompat.setClassName("android.view.View");
        Rect rect = INVALID_PARENT_BOUNDS;
        accessibilityNodeInfoObtain.setBoundsInParent(rect);
        accessibilityNodeInfoObtain.setBoundsInScreen(rect);
        accessibilityNodeInfoCompat.mParentVirtualDescendantId = -1;
        Chip chip = this.mHost;
        accessibilityNodeInfoObtain.setParent(chip);
        onPopulateNodeForVirtualView(i, accessibilityNodeInfoCompat);
        if (accessibilityNodeInfoCompat.getText() == null && accessibilityNodeInfoObtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        Rect rect2 = this.mTempParentRect;
        accessibilityNodeInfoCompat.getBoundsInParent(rect2);
        if (rect2.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int actions = accessibilityNodeInfoObtain.getActions();
        if ((actions & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((actions & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        accessibilityNodeInfoObtain.setPackageName(chip.getContext().getPackageName());
        accessibilityNodeInfoCompat.mVirtualDescendantId = i;
        accessibilityNodeInfoObtain.setSource(chip, i);
        if (this.mAccessibilityFocusedVirtualViewId == i) {
            accessibilityNodeInfoObtain.setAccessibilityFocused(true);
            accessibilityNodeInfoCompat.addAction(128);
        } else {
            accessibilityNodeInfoObtain.setAccessibilityFocused(false);
            accessibilityNodeInfoCompat.addAction(64);
        }
        boolean z = this.mKeyboardFocusedVirtualViewId == i;
        if (z) {
            accessibilityNodeInfoCompat.addAction(2);
        } else if (accessibilityNodeInfoObtain.isFocusable()) {
            accessibilityNodeInfoCompat.addAction(1);
        }
        accessibilityNodeInfoObtain.setFocused(z);
        int[] iArr = this.mTempGlobalRect;
        chip.getLocationOnScreen(iArr);
        Rect rect3 = this.mTempScreenRect;
        accessibilityNodeInfoObtain.getBoundsInScreen(rect3);
        if (rect3.equals(rect)) {
            accessibilityNodeInfoCompat.getBoundsInParent(rect3);
            if (accessibilityNodeInfoCompat.mParentVirtualDescendantId != -1) {
                AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2 = new AccessibilityNodeInfoCompat(AccessibilityNodeInfo.obtain());
                for (int i2 = accessibilityNodeInfoCompat.mParentVirtualDescendantId; i2 != -1; i2 = accessibilityNodeInfoCompat2.mParentVirtualDescendantId) {
                    accessibilityNodeInfoCompat2.mParentVirtualDescendantId = -1;
                    AccessibilityNodeInfo accessibilityNodeInfo = accessibilityNodeInfoCompat2.mInfo;
                    accessibilityNodeInfo.setParent(chip, -1);
                    accessibilityNodeInfo.setBoundsInParent(rect);
                    onPopulateNodeForVirtualView(i2, accessibilityNodeInfoCompat2);
                    accessibilityNodeInfoCompat2.getBoundsInParent(rect2);
                    rect3.offset(rect2.left, rect2.top);
                }
            }
            rect3.offset(iArr[0] - chip.getScrollX(), iArr[1] - chip.getScrollY());
        }
        Rect rect4 = this.mTempVisibleRect;
        if (chip.getLocalVisibleRect(rect4)) {
            rect4.offset(iArr[0] - chip.getScrollX(), iArr[1] - chip.getScrollY());
            if (rect3.intersect(rect4)) {
                AccessibilityNodeInfo accessibilityNodeInfo2 = accessibilityNodeInfoCompat.mInfo;
                accessibilityNodeInfo2.setBoundsInScreen(rect3);
                if (!rect3.isEmpty() && chip.getWindowVisibility() == 0) {
                    Object parent = chip.getParent();
                    while (parent instanceof View) {
                        View view = (View) parent;
                        if (view.getAlpha() > 0.0f && view.getVisibility() == 0) {
                            parent = view.getParent();
                        }
                    }
                    if (parent != null) {
                        accessibilityNodeInfo2.setVisibleToUser(true);
                    }
                }
            }
        }
        return accessibilityNodeInfoCompat;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final Parameters.Builder getAccessibilityNodeProvider(View view) {
        if (this.mNodeProvider == null) {
            this.mNodeProvider = new MyNodeProvider(this, 0);
        }
        return this.mNodeProvider;
    }

    public abstract void getVisibleVirtualViews(ArrayList arrayList);

    /* JADX WARN: Code duplicated, block: B:118:0x0154 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:119:0x0154 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:120:0x0154 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:121:0x0154 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x00bc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x00be A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x00c0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:43:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:46:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:47:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:48:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:51:0x0106  */
    /* JADX WARN: Code duplicated, block: B:54:0x010f  */
    /* JADX WARN: Code duplicated, block: B:57:0x011c  */
    /* JADX WARN: Code duplicated, block: B:66:0x0131  */
    /* JADX WARN: Code duplicated, block: B:68:0x014f  */
    /* JADX WARN: Code duplicated, block: B:89:0x01a9  */
    public final boolean moveFocus(int i, Rect rect) {
        int i2;
        int i3;
        Object obj;
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat;
        int i4;
        int iKeyAt;
        int i5;
        Rect rect2;
        int size;
        Rect rect3;
        int i6;
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2;
        int i7;
        int iMajorAxisDistance;
        int iMinorAxisDistance;
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        SparseArrayCompat sparseArrayCompat = new SparseArrayCompat(0);
        for (int i8 = 0; i8 < arrayList.size(); i8++) {
            sparseArrayCompat.put(((Integer) arrayList.get(i8)).intValue(), createNodeForChild(((Integer) arrayList.get(i8)).intValue()));
        }
        int i9 = this.mKeyboardFocusedVirtualViewId;
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat3 = i9 == Integer.MIN_VALUE ? null : (AccessibilityNodeInfoCompat) sparseArrayCompat.get(i9);
        Path.Companion companion = NODE_ADAPTER;
        EmptyNetworkObserver emptyNetworkObserver = SPARSE_VALUES_ADAPTER;
        Chip chip = this.mHost;
        if (i == 1 || i == 2) {
            i2 = 0;
            i3 = -1;
            WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            boolean z = chip.getLayoutDirection() == 1;
            emptyNetworkObserver.getClass();
            int size2 = sparseArrayCompat.size();
            ArrayList arrayList2 = new ArrayList(size2);
            for (int i10 = 0; i10 < size2; i10++) {
                arrayList2.add((AccessibilityNodeInfoCompat) sparseArrayCompat.valueAt(i10));
            }
            Collections.sort(arrayList2, new FocusStrategy.SequentialComparator(z, companion));
            if (i == 1) {
                int size3 = arrayList2.size();
                if (accessibilityNodeInfoCompat3 != null) {
                    size3 = arrayList2.indexOf(accessibilityNodeInfoCompat3);
                }
                int i11 = size3 - 1;
                if (i11 >= 0) {
                    obj = arrayList2.get(i11);
                } else {
                    obj = null;
                }
            } else {
                if (i != 2) {
                    throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
                }
                int size4 = arrayList2.size();
                int iLastIndexOf = (accessibilityNodeInfoCompat3 == null ? -1 : arrayList2.lastIndexOf(accessibilityNodeInfoCompat3)) + 1;
                if (iLastIndexOf < size4) {
                    obj = arrayList2.get(iLastIndexOf);
                } else {
                    obj = null;
                }
            }
            accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) obj;
        } else {
            if (i != 17 && i != 33 && i != 66 && i != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            Rect rect4 = new Rect();
            int i12 = this.mKeyboardFocusedVirtualViewId;
            if (i12 != Integer.MIN_VALUE) {
                obtainAccessibilityNodeInfo(i12).getBoundsInParent(rect4);
            } else {
                if (rect != null) {
                    rect4.set(rect);
                } else {
                    int width = chip.getWidth();
                    int height = chip.getHeight();
                    if (i == 17) {
                        i5 = -1;
                        rect4.set(width, 0, width, height);
                    } else if (i == 33) {
                        i5 = -1;
                        rect4.set(0, height, width, height);
                    } else if (i == 66) {
                        i5 = -1;
                        rect4.set(-1, 0, -1, height);
                    } else {
                        if (i != 130) {
                            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                        }
                        i5 = -1;
                        rect4.set(0, -1, width, -1);
                    }
                }
                rect2 = new Rect(rect4);
                if (i != 17) {
                    i2 = 0;
                    rect2.offset(rect4.width() + 1, 0);
                } else if (i != 33) {
                    i2 = 0;
                    rect2.offset(0, rect4.height() + 1);
                } else if (i != 66) {
                    i2 = 0;
                    rect2.offset(-(rect4.width() + 1), 0);
                } else {
                    if (i == 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                    i2 = 0;
                    rect2.offset(0, -(rect4.height() + 1));
                }
                emptyNetworkObserver.getClass();
                size = sparseArrayCompat.size();
                rect3 = new Rect();
                accessibilityNodeInfoCompat = null;
                for (i6 = i2; i6 < size; i6++) {
                    accessibilityNodeInfoCompat2 = (AccessibilityNodeInfoCompat) sparseArrayCompat.valueAt(i6);
                    if (accessibilityNodeInfoCompat2 == accessibilityNodeInfoCompat3) {
                        companion.getClass();
                        accessibilityNodeInfoCompat2.getBoundsInParent(rect3);
                        if (FocusStrategy.isCandidate(i, rect4, rect3)) {
                            if (FocusStrategy.isCandidate(i, rect4, rect2) || FocusStrategy.beamBeats(i, rect4, rect3, rect2)) {
                                rect2.set(rect3);
                                accessibilityNodeInfoCompat = accessibilityNodeInfoCompat2;
                            } else if (FocusStrategy.beamBeats(i, rect4, rect2, rect3)) {
                                int iMajorAxisDistance2 = FocusStrategy.majorAxisDistance(i, rect4, rect3);
                                int iMinorAxisDistance2 = FocusStrategy.minorAxisDistance(i, rect4, rect3);
                                i7 = (iMinorAxisDistance2 * iMinorAxisDistance2) + (iMajorAxisDistance2 * 13 * iMajorAxisDistance2);
                                iMajorAxisDistance = FocusStrategy.majorAxisDistance(i, rect4, rect2);
                                iMinorAxisDistance = FocusStrategy.minorAxisDistance(i, rect4, rect2);
                                if (i7 < (iMinorAxisDistance * iMinorAxisDistance) + (iMajorAxisDistance * 13 * iMajorAxisDistance)) {
                                    rect2.set(rect3);
                                    accessibilityNodeInfoCompat = accessibilityNodeInfoCompat2;
                                }
                            }
                        }
                    }
                }
                i3 = i5;
            }
            i5 = -1;
            rect2 = new Rect(rect4);
            if (i != 17) {
                i2 = 0;
                rect2.offset(rect4.width() + 1, 0);
            } else if (i != 33) {
                i2 = 0;
                rect2.offset(0, rect4.height() + 1);
            } else if (i != 66) {
                i2 = 0;
                rect2.offset(-(rect4.width() + 1), 0);
            } else {
                if (i == 130) {
                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                }
                i2 = 0;
                rect2.offset(0, -(rect4.height() + 1));
            }
            emptyNetworkObserver.getClass();
            size = sparseArrayCompat.size();
            rect3 = new Rect();
            accessibilityNodeInfoCompat = null;
            while (i6 < size) {
                accessibilityNodeInfoCompat2 = (AccessibilityNodeInfoCompat) sparseArrayCompat.valueAt(i6);
                if (accessibilityNodeInfoCompat2 == accessibilityNodeInfoCompat3) {
                    companion.getClass();
                    accessibilityNodeInfoCompat2.getBoundsInParent(rect3);
                    if (FocusStrategy.isCandidate(i, rect4, rect3)) {
                        if (FocusStrategy.isCandidate(i, rect4, rect2)) {
                            rect2.set(rect3);
                            accessibilityNodeInfoCompat = accessibilityNodeInfoCompat2;
                        } else if (FocusStrategy.beamBeats(i, rect4, rect2, rect3)) {
                            int iMajorAxisDistance3 = FocusStrategy.majorAxisDistance(i, rect4, rect3);
                            int iMinorAxisDistance3 = FocusStrategy.minorAxisDistance(i, rect4, rect3);
                            i7 = (iMinorAxisDistance3 * iMinorAxisDistance3) + (iMajorAxisDistance3 * 13 * iMajorAxisDistance3);
                            iMajorAxisDistance = FocusStrategy.majorAxisDistance(i, rect4, rect2);
                            iMinorAxisDistance = FocusStrategy.minorAxisDistance(i, rect4, rect2);
                            if (i7 < (iMinorAxisDistance * iMinorAxisDistance) + (iMajorAxisDistance * 13 * iMajorAxisDistance)) {
                                rect2.set(rect3);
                                accessibilityNodeInfoCompat = accessibilityNodeInfoCompat2;
                            }
                        }
                    }
                }
            }
            i3 = i5;
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat4 = accessibilityNodeInfoCompat;
        if (accessibilityNodeInfoCompat4 == null) {
            iKeyAt = Integer.MIN_VALUE;
        } else {
            if (sparseArrayCompat.garbage) {
                ArraySetKt.access$gc(sparseArrayCompat);
            }
            int i13 = sparseArrayCompat.size;
            int i14 = i2;
            while (true) {
                if (i14 >= i13) {
                    i4 = i3;
                    break;
                }
                if (sparseArrayCompat.values[i14] == accessibilityNodeInfoCompat4) {
                    i4 = i14;
                    break;
                }
                i14++;
            }
            iKeyAt = sparseArrayCompat.keyAt(i4);
        }
        return requestKeyboardFocusForVirtualView(iKeyAt);
    }

    public final AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo(int i) {
        if (i != -1) {
            return createNodeForChild(i);
        }
        Chip chip = this.mHost;
        AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(chip);
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = new AccessibilityNodeInfoCompat(accessibilityNodeInfoObtain);
        WeakHashMap weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        chip.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoObtain);
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        if (accessibilityNodeInfoObtain.getChildCount() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            accessibilityNodeInfoCompat.mInfo.addChild(chip, ((Integer) arrayList.get(i2)).intValue());
        }
        return accessibilityNodeInfoCompat;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        AccessibilityNodeInfo accessibilityNodeInfo = accessibilityNodeInfoCompat.mInfo;
        this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        Chip chip = Chip.this;
        ChipDrawable chipDrawable = chip.chipDrawable;
        accessibilityNodeInfo.setCheckable(chipDrawable != null && chipDrawable.checkable);
        accessibilityNodeInfo.setClickable(chip.isClickable());
        accessibilityNodeInfoCompat.setClassName(chip.getAccessibilityClassName());
        accessibilityNodeInfoCompat.setText(chip.getText());
    }

    public abstract void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

    public final boolean requestKeyboardFocusForVirtualView(int i) {
        int i2;
        Chip chip = this.mHost;
        if ((!chip.isFocused() && !chip.requestFocus()) || (i2 = this.mKeyboardFocusedVirtualViewId) == i) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i2);
        }
        if (i == Integer.MIN_VALUE) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = i;
        Chip.ChipTouchHelper chipTouchHelper = (Chip.ChipTouchHelper) this;
        if (i == 1) {
            Chip chip2 = Chip.this;
            chip2.closeIconFocused = true;
            chip2.refreshDrawableState();
        }
        sendEventForVirtualView(i, 8);
        return true;
    }

    public final void sendEventForVirtualView(int i, int i2) {
        View view;
        ViewParent parent;
        AccessibilityEvent accessibilityEventObtain;
        if (i == Integer.MIN_VALUE || !this.mManager.isEnabled() || (parent = (view = this.mHost).getParent()) == null) {
            return;
        }
        if (i != -1) {
            accessibilityEventObtain = AccessibilityEvent.obtain(i2);
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompatObtainAccessibilityNodeInfo = obtainAccessibilityNodeInfo(i);
            accessibilityEventObtain.getText().add(accessibilityNodeInfoCompatObtainAccessibilityNodeInfo.getText());
            AccessibilityNodeInfo accessibilityNodeInfo = accessibilityNodeInfoCompatObtainAccessibilityNodeInfo.mInfo;
            accessibilityEventObtain.setContentDescription(accessibilityNodeInfo.getContentDescription());
            accessibilityEventObtain.setScrollable(accessibilityNodeInfo.isScrollable());
            accessibilityEventObtain.setPassword(accessibilityNodeInfo.isPassword());
            accessibilityEventObtain.setEnabled(accessibilityNodeInfo.isEnabled());
            accessibilityEventObtain.setChecked(accessibilityNodeInfo.isChecked());
            if (accessibilityEventObtain.getText().isEmpty() && accessibilityEventObtain.getContentDescription() == null) {
                throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
            }
            accessibilityEventObtain.setClassName(accessibilityNodeInfo.getClassName());
            accessibilityEventObtain.setSource(view, i);
            accessibilityEventObtain.setPackageName(view.getContext().getPackageName());
        } else {
            accessibilityEventObtain = AccessibilityEvent.obtain(i2);
            view.onInitializeAccessibilityEvent(accessibilityEventObtain);
        }
        parent.requestSendAccessibilityEvent(view, accessibilityEventObtain);
    }
}
