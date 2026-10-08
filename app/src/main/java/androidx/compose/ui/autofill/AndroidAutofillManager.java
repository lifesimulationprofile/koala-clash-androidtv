package androidx.compose.ui.autofill;

import android.graphics.Rect;
import android.view.autofill.AutofillId;
import androidx.camera.camera2.internal.ExposureStateImpl;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableScatterMap;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusListener;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.graphics.Api26Bitmap$$ExternalSyntheticApiModelOutline0;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.coreshims.ViewCompatShims;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.spatial.RectManager;
import coil.request.Parameters;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidAutofillManager extends AutofillManager implements FocusListener {
    public final MutableIntSet currentlyDisplayedIDs;
    public final String packageName;
    public boolean pendingAutofillCommit;
    public final Parameters.Builder platformAutofillManager;
    public final RectManager rectManager;
    public final Rect reusableRect = new Rect();
    public final AutofillId rootAutofillId;
    public final SemanticsOwner semanticsOwner;
    public final AndroidComposeView view;

    public AndroidAutofillManager(Parameters.Builder builder, SemanticsOwner semanticsOwner, AndroidComposeView androidComposeView, RectManager rectManager, String str) {
        this.platformAutofillManager = builder;
        this.semanticsOwner = semanticsOwner;
        this.view = androidComposeView;
        this.rectManager = rectManager;
        this.packageName = str;
        androidComposeView.setImportantForAutofill(1);
        ExposureStateImpl autofillId = ViewCompatShims.getAutofillId(androidComposeView);
        AutofillId autofillIdM = autofillId != null ? Api26Bitmap$$ExternalSyntheticApiModelOutline0.m(autofillId.mLock) : null;
        if (autofillIdM == null) {
            throw Modifier.CC.m("Required value was null.");
        }
        this.rootAutofillId = autofillIdM;
        this.currentlyDisplayedIDs = new MutableIntSet();
    }

    @Override // androidx.compose.ui.focus.FocusListener
    public final void onFocusChanged(FocusTargetNode focusTargetNode, FocusTargetNode focusTargetNode2) {
        LayoutNode layoutNodeRequireLayoutNode;
        SemanticsConfiguration semanticsConfiguration;
        LayoutNode layoutNodeRequireLayoutNode2;
        SemanticsConfiguration semanticsConfiguration2;
        if (focusTargetNode != null && (layoutNodeRequireLayoutNode2 = HitTestResultKt.requireLayoutNode(focusTargetNode)) != null && (semanticsConfiguration2 = layoutNodeRequireLayoutNode2.getSemanticsConfiguration()) != null) {
            MutableScatterMap mutableScatterMap = semanticsConfiguration2.props;
            if (mutableScatterMap.contains(SemanticsActions.OnAutofillText) || mutableScatterMap.contains(SemanticsActions.OnFillData)) {
                ((android.view.autofill.AutofillManager) this.platformAutofillManager.entries).notifyViewExited(this.view, layoutNodeRequireLayoutNode2.semanticsId);
            }
        }
        if (focusTargetNode2 == null || (layoutNodeRequireLayoutNode = HitTestResultKt.requireLayoutNode(focusTargetNode2)) == null || (semanticsConfiguration = layoutNodeRequireLayoutNode.getSemanticsConfiguration()) == null) {
            return;
        }
        MutableScatterMap mutableScatterMap2 = semanticsConfiguration.props;
        if (mutableScatterMap2.contains(SemanticsActions.OnAutofillText) || mutableScatterMap2.contains(SemanticsActions.OnFillData)) {
            final int i = layoutNodeRequireLayoutNode.semanticsId;
            this.rectManager.rects.withRect(i, new Function4() { // from class: androidx.compose.ui.autofill.AndroidAutofillManager$onFocusChanged$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    int iIntValue = ((Number) obj).intValue();
                    int iIntValue2 = ((Number) obj2).intValue();
                    int iIntValue3 = ((Number) obj3).intValue();
                    int iIntValue4 = ((Number) obj4).intValue();
                    AndroidAutofillManager androidAutofillManager = this.this$0;
                    Parameters.Builder builder = androidAutofillManager.platformAutofillManager;
                    ((android.view.autofill.AutofillManager) builder.entries).notifyViewEntered(androidAutofillManager.view, i, new Rect(iIntValue, iIntValue2, iIntValue3, iIntValue4));
                    return Unit.INSTANCE;
                }
            });
        }
    }
}
