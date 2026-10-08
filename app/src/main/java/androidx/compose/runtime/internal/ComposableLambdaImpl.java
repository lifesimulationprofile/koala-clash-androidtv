package androidx.compose.runtime.internal;

import androidx.compose.foundation.gestures.ScrollableNode;
import androidx.compose.foundation.gestures.ScrollableNode$onKeyEvent$1;
import androidx.compose.foundation.text.contextmenu.provider.BasicTextContextMenuProvider;
import androidx.compose.material3.ScaffoldKt$$ExternalSyntheticLambda1;
import androidx.compose.material3.SnackbarHostKt$$ExternalSyntheticLambda0;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.ui.unit.Velocity;
import coil.compose.AsyncImageKt$$ExternalSyntheticLambda1;
import com.github.kr328.clash.FilesActivity$$ExternalSyntheticLambda16;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ComposableLambdaImpl implements ComposableLambda {
    public Object _block;
    public final int key;
    public RecomposeScopeImpl scope;
    public ArrayList scopes;
    public final boolean tracked;

    /* JADX INFO: renamed from: androidx.compose.runtime.internal.ComposableLambdaImpl$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final /* synthetic */ class AnonymousClass1 extends AdaptedFunctionReference implements Function2 {
        public final /* synthetic */ int $r8$classId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AnonymousClass1(int i, Object obj, Class cls, String str, String str2, int i2, int i3) {
            super(i, i2, cls, obj, str, str2);
            this.$r8$classId = i3;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            switch (this.$r8$classId) {
                case 0:
                    int iIntValue = ((Number) obj2).intValue();
                    ((ComposableLambdaImpl) this.receiver).invoke(iIntValue, (GapComposer) obj);
                    break;
                case 1:
                    long j = ((Velocity) obj).packedValue;
                    ScrollableNode scrollableNode = (ScrollableNode) this.receiver;
                    JobKt.launch$default(scrollableNode.nestedScrollDispatcher.getCoroutineScope(), null, new ScrollableNode$onKeyEvent$1(scrollableNode, j, null, 2), 3);
                    break;
                default:
                    long j2 = ((Velocity) obj).packedValue;
                    ScrollableNode scrollableNode2 = (ScrollableNode) this.receiver;
                    JobKt.launch$default(scrollableNode2.nestedScrollDispatcher.getCoroutineScope(), null, new ScrollableNode$onKeyEvent$1(scrollableNode2, j2, null, 1), 3);
                    break;
            }
            return Unit.INSTANCE;
        }
    }

    public ComposableLambdaImpl(int i, Object obj, boolean z) {
        this.key = i;
        this.tracked = z;
        this._block = obj;
    }

    @Override // kotlin.jvm.functions.Function8
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Boolean bool, Object obj2, Object obj3, Object obj4, Object obj5, Integer num) {
        return invoke(obj, bool, obj2, obj3, obj4, (GapComposer) obj5, num.intValue());
    }

    public final void trackRead(GapComposer gapComposer) {
        RecomposeScopeImpl currentRecomposeScope$runtime;
        if (!this.tracked || (currentRecomposeScope$runtime = gapComposer.getCurrentRecomposeScope$runtime()) == null) {
            return;
        }
        gapComposer.getClass();
        currentRecomposeScope$runtime.setUsed();
        if (Thread_jvmKt.replacableWith(this.scope, currentRecomposeScope$runtime)) {
            this.scope = currentRecomposeScope$runtime;
            return;
        }
        ArrayList arrayList = this.scopes;
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList();
            this.scopes = arrayList2;
            arrayList2.add(currentRecomposeScope$runtime);
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (Thread_jvmKt.replacableWith((RecomposeScopeImpl) arrayList.get(i), currentRecomposeScope$runtime)) {
                arrayList.set(i, currentRecomposeScope$runtime);
                return;
            }
        }
        arrayList.add(currentRecomposeScope$runtime);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj2).intValue(), (GapComposer) obj);
    }

    @Override // kotlin.jvm.functions.Function3
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke(obj, (GapComposer) obj2, ((Number) obj3).intValue());
    }

    @Override // kotlin.jvm.functions.Function4
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return invoke(obj, obj2, (GapComposer) obj3, ((Number) obj4).intValue());
    }

    @Override // kotlin.jvm.functions.Function5
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return invoke((BasicTextContextMenuProvider.SessionImpl) obj, obj2, obj3, (GapComposer) obj4, ((Number) obj5).intValue());
    }

    public final Object invoke(int i, GapComposer gapComposer) {
        int iBitsForSlot;
        gapComposer.startRestartGroup(this.key);
        trackRead(gapComposer);
        if (gapComposer.changed(this)) {
            iBitsForSlot = Thread_jvmKt.bitsForSlot(2, 0);
        } else {
            iBitsForSlot = Thread_jvmKt.bitsForSlot(1, 0);
        }
        int i2 = i | iBitsForSlot;
        Object obj = this._block;
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(2, obj);
        Object objInvoke = ((Function2) obj).invoke(gapComposer, Integer.valueOf(i2));
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AnonymousClass1(2, this, ComposableLambdaImpl.class, "invoke", "invoke(Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", 8, 0);
        }
        return objInvoke;
    }

    public final Object invoke(Object obj, GapComposer gapComposer, int i) {
        int iBitsForSlot;
        gapComposer.startRestartGroup(this.key);
        trackRead(gapComposer);
        if (gapComposer.changed(this)) {
            iBitsForSlot = Thread_jvmKt.bitsForSlot(2, 1);
        } else {
            iBitsForSlot = Thread_jvmKt.bitsForSlot(1, 1);
        }
        Object obj2 = this._block;
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(3, obj2);
        Object objInvoke = ((Function3) obj2).invoke(obj, gapComposer, Integer.valueOf(iBitsForSlot | i));
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new FilesActivity$$ExternalSyntheticLambda16(i, 4, this, obj);
        }
        return objInvoke;
    }

    public final Object invoke(Object obj, Object obj2, GapComposer gapComposer, int i) {
        int iBitsForSlot;
        gapComposer.startRestartGroup(this.key);
        trackRead(gapComposer);
        if (gapComposer.changed(this)) {
            iBitsForSlot = Thread_jvmKt.bitsForSlot(2, 2);
        } else {
            iBitsForSlot = Thread_jvmKt.bitsForSlot(1, 2);
        }
        Object obj3 = this._block;
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(4, obj3);
        Object objInvoke = ((Function4) obj3).invoke(obj, obj2, gapComposer, Integer.valueOf(iBitsForSlot | i));
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new SnackbarHostKt$$ExternalSyntheticLambda0(this, obj, obj2, i);
        }
        return objInvoke;
    }

    public final Object invoke(BasicTextContextMenuProvider.SessionImpl sessionImpl, Object obj, Object obj2, GapComposer gapComposer, int i) {
        int iBitsForSlot;
        gapComposer.startRestartGroup(this.key);
        trackRead(gapComposer);
        if (gapComposer.changed(this)) {
            iBitsForSlot = Thread_jvmKt.bitsForSlot(2, 3);
        } else {
            iBitsForSlot = Thread_jvmKt.bitsForSlot(1, 3);
        }
        Object obj3 = this._block;
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(5, obj3);
        Object objInvoke = ((Function5) obj3).invoke(sessionImpl, obj, obj2, gapComposer, Integer.valueOf(iBitsForSlot | i));
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new AsyncImageKt$$ExternalSyntheticLambda1(this, sessionImpl, obj, obj2, i, 5);
        }
        return objInvoke;
    }

    public final Object invoke(Object obj, Boolean bool, Object obj2, Object obj3, Object obj4, GapComposer gapComposer, int i) {
        int iBitsForSlot;
        gapComposer.startRestartGroup(this.key);
        trackRead(gapComposer);
        if (gapComposer.changed(this)) {
            iBitsForSlot = Thread_jvmKt.bitsForSlot(2, 6);
        } else {
            iBitsForSlot = Thread_jvmKt.bitsForSlot(1, 6);
        }
        Object obj5 = this._block;
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(8, obj5);
        Object objInvoke = ((Function8) obj5).invoke(obj, bool, obj2, obj3, obj4, gapComposer, Integer.valueOf(i | iBitsForSlot));
        RecomposeScopeImpl recomposeScopeImplEndRestartGroup = gapComposer.endRestartGroup();
        if (recomposeScopeImplEndRestartGroup != null) {
            recomposeScopeImplEndRestartGroup.block = new ScaffoldKt$$ExternalSyntheticLambda1(this, obj, bool, obj2, obj3, obj4, i);
        }
        return objInvoke;
    }
}
