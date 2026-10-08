package coil.compose;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Trace;
import androidx.camera.camera2.internal.CameraIdUtil;
import androidx.compose.material3.ThumbNode;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidImageBitmap;
import androidx.compose.ui.graphics.BlendModeColorFilter;
import androidx.compose.ui.graphics.painter.BitmapPainterKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import coil.RealImageLoader;
import coil.request.DefaultRequestOptions;
import coil.request.ErrorResult;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.request.SuccessResult;
import coil.transition.CrossfadeTransition;
import coil.transition.Transition;
import coil.util.Requests;
import com.google.accompanist.drawablepainter.DrawablePainter;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorJobImpl;
import kotlinx.coroutines.android.HandlerContext;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.internal.ContextScope;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AsyncImagePainter extends Painter implements RememberObserver {
    public static final AsyncImagePainter$$ExternalSyntheticLambda0 DefaultTransform = new AsyncImagePainter$$ExternalSyntheticLambda0(0);
    public Painter _painter;
    public State _state;
    public ContentScale contentScale;
    public int filterQuality;
    public final ParcelableSnapshotMutableState imageLoader$delegate;
    public boolean isPreview;
    public Function1 onState;
    public ContextScope rememberScope;
    public final ParcelableSnapshotMutableState request$delegate;
    public final ParcelableSnapshotMutableState state$delegate;
    public Function1 transform;
    public final StateFlowImpl drawSize = FlowKt.MutableStateFlow(new Size(0));
    public final ParcelableSnapshotMutableState painter$delegate = Stack.mutableStateOf$default(null);
    public final ParcelableSnapshotMutableFloatState alpha$delegate = new ParcelableSnapshotMutableFloatState(1.0f);
    public final ParcelableSnapshotMutableState colorFilter$delegate = Stack.mutableStateOf$default(null);

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class State {

        /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
        public final class Empty extends State {
            public static final Empty INSTANCE = new Empty();

            public final boolean equals(Object obj) {
                return this == obj || (obj instanceof Empty);
            }

            @Override // coil.compose.AsyncImagePainter.State
            public final Painter getPainter() {
                return null;
            }

            public final int hashCode() {
                return -1515560141;
            }

            public final String toString() {
                return "Empty";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
        public final class Error extends State {
            public final Painter painter;
            public final ErrorResult result;

            public Error(Painter painter, ErrorResult errorResult) {
                this.painter = painter;
                this.result = errorResult;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Error)) {
                    return false;
                }
                Error error = (Error) obj;
                return Intrinsics.areEqual(this.painter, error.painter) && Intrinsics.areEqual(this.result, error.result);
            }

            @Override // coil.compose.AsyncImagePainter.State
            public final Painter getPainter() {
                return this.painter;
            }

            public final int hashCode() {
                Painter painter = this.painter;
                return this.result.hashCode() + ((painter == null ? 0 : painter.hashCode()) * 31);
            }

            public final String toString() {
                return "Error(painter=" + this.painter + ", result=" + this.result + ')';
            }
        }

        /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
        public final class Loading extends State {
            public final Painter painter;

            public Loading(Painter painter) {
                this.painter = painter;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Loading) && Intrinsics.areEqual(this.painter, ((Loading) obj).painter);
            }

            @Override // coil.compose.AsyncImagePainter.State
            public final Painter getPainter() {
                return this.painter;
            }

            public final int hashCode() {
                Painter painter = this.painter;
                if (painter == null) {
                    return 0;
                }
                return painter.hashCode();
            }

            public final String toString() {
                return "Loading(painter=" + this.painter + ')';
            }
        }

        /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
        public final class Success extends State {
            public final Painter painter;
            public final SuccessResult result;

            public Success(Painter painter, SuccessResult successResult) {
                this.painter = painter;
                this.result = successResult;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Success)) {
                    return false;
                }
                Success success = (Success) obj;
                return Intrinsics.areEqual(this.painter, success.painter) && Intrinsics.areEqual(this.result, success.result);
            }

            @Override // coil.compose.AsyncImagePainter.State
            public final Painter getPainter() {
                return this.painter;
            }

            public final int hashCode() {
                return this.result.hashCode() + (this.painter.hashCode() * 31);
            }

            public final String toString() {
                return "Success(painter=" + this.painter + ", result=" + this.result + ')';
            }
        }

        public abstract Painter getPainter();
    }

    public AsyncImagePainter(ImageRequest imageRequest, RealImageLoader realImageLoader) {
        State.Empty empty = State.Empty.INSTANCE;
        this._state = empty;
        this.transform = DefaultTransform;
        this.contentScale = ContentScale.Companion.Fit;
        this.filterQuality = 1;
        this.state$delegate = Stack.mutableStateOf$default(empty);
        this.request$delegate = Stack.mutableStateOf$default(imageRequest);
        this.imageLoader$delegate = Stack.mutableStateOf$default(realImageLoader);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void applyAlpha(float f) {
        this.alpha$delegate.setFloatValue(f);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void applyColorFilter(BlendModeColorFilter blendModeColorFilter) {
        this.colorFilter$delegate.setValue(blendModeColorFilter);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    /* JADX INFO: renamed from: getIntrinsicSize-NH-jbRc */
    public final long mo492getIntrinsicSizeNHjbRc() {
        Painter painter = (Painter) this.painter$delegate.getValue();
        if (painter != null) {
            return painter.mo492getIntrinsicSizeNHjbRc();
        }
        return 9205357640488583168L;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onAbandoned() {
        ContextScope contextScope = this.rememberScope;
        if (contextScope != null) {
            JobKt.cancel(contextScope, (CancellationException) null);
        }
        this.rememberScope = null;
        Object obj = this._painter;
        RememberObserver rememberObserver = obj instanceof RememberObserver ? (RememberObserver) obj : null;
        if (rememberObserver != null) {
            rememberObserver.onAbandoned();
        }
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public final void onDraw(LayoutNodeDrawScope layoutNodeDrawScope) {
        Size size = new Size(layoutNodeDrawScope.mo474getSizeNHjbRc());
        StateFlowImpl stateFlowImpl = this.drawSize;
        stateFlowImpl.getClass();
        stateFlowImpl.updateState(null, size);
        Painter painter = (Painter) this.painter$delegate.getValue();
        if (painter != null) {
            painter.m495drawx_KDEd0(layoutNodeDrawScope, layoutNodeDrawScope.mo474getSizeNHjbRc(), this.alpha$delegate.getFloatValue(), (BlendModeColorFilter) this.colorFilter$delegate.getValue());
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onForgotten() {
        ContextScope contextScope = this.rememberScope;
        if (contextScope != null) {
            JobKt.cancel(contextScope, (CancellationException) null);
        }
        this.rememberScope = null;
        Object obj = this._painter;
        RememberObserver rememberObserver = obj instanceof RememberObserver ? (RememberObserver) obj : null;
        if (rememberObserver != null) {
            rememberObserver.onForgotten();
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onRemembered() {
        Trace.beginSection("AsyncImagePainter.onRemembered");
        try {
            if (this.rememberScope == null) {
                SupervisorJobImpl supervisorJobImplSupervisorJob$default = JobKt.SupervisorJob$default();
                DefaultScheduler defaultScheduler = Dispatchers.Default;
                ContextScope contextScopeCoroutineScope = JobKt.CoroutineScope(CameraIdUtil.plus(supervisorJobImplSupervisorJob$default, ((HandlerContext) MainDispatcherLoader.dispatcher).immediate));
                this.rememberScope = contextScopeCoroutineScope;
                Object obj = this._painter;
                Continuation continuation = null;
                RememberObserver rememberObserver = obj instanceof RememberObserver ? (RememberObserver) obj : null;
                if (rememberObserver != null) {
                    rememberObserver.onRemembered();
                }
                if (this.isPreview) {
                    ImageRequest.Builder builderNewBuilder$default = ImageRequest.newBuilder$default((ImageRequest) this.request$delegate.getValue());
                    builderNewBuilder$default.defaults = ((RealImageLoader) this.imageLoader$delegate.getValue()).defaults;
                    builderNewBuilder$default.resolvedScale = 0;
                    builderNewBuilder$default.build().defaults.getClass();
                    DefaultRequestOptions defaultRequestOptions = Requests.DEFAULT_REQUEST_OPTIONS;
                    updateState(new State.Loading(null));
                } else {
                    JobKt.launch$default(contextScopeCoroutineScope, null, new ThumbNode.AnonymousClass1(this, continuation, 14), 3);
                }
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    public final Painter toPainter(Drawable drawable) {
        return drawable instanceof BitmapDrawable ? BitmapPainterKt.m493BitmapPainterQZhYCtY$default(new AndroidImageBitmap(((BitmapDrawable) drawable).getBitmap()), this.filterQuality) : new DrawablePainter(drawable.mutate());
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0060  */
    /* JADX WARN: Code duplicated, block: B:26:0x0064  */
    /* JADX WARN: Code duplicated, block: B:33:0x0085  */
    /* JADX WARN: Code duplicated, block: B:34:0x0088  */
    /* JADX WARN: Code duplicated, block: B:36:0x008b  */
    /* JADX WARN: Code duplicated, block: B:39:0x0096  */
    /* JADX WARN: Code duplicated, block: B:41:0x009b  */
    /* JADX WARN: Code duplicated, block: B:44:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:46:? A[RETURN, SYNTHETIC] */
    public final void updateState(State state) {
        ImageResult imageResult;
        Painter painter;
        Function1 function1;
        Object painter2;
        RememberObserver rememberObserver;
        RememberObserver rememberObserver2;
        State state2 = this._state;
        State state3 = (State) this.transform.invoke(state);
        this._state = state3;
        this.state$delegate.setValue(state3);
        if (!(state3 instanceof State.Success)) {
            if (state3 instanceof State.Error) {
                imageResult = ((State.Error) state3).result;
            } else {
                painter = null;
            }
            if (painter == null) {
                painter = state3.getPainter();
            }
            this._painter = painter;
            this.painter$delegate.setValue(painter);
            if (this.rememberScope != null && state2.getPainter() != state3.getPainter()) {
                painter2 = state2.getPainter();
                if (painter2 instanceof RememberObserver) {
                    rememberObserver = (RememberObserver) painter2;
                } else {
                    rememberObserver = null;
                }
                if (rememberObserver != null) {
                    rememberObserver.onForgotten();
                }
                Object painter3 = state3.getPainter();
                rememberObserver2 = painter3 instanceof RememberObserver ? (RememberObserver) painter3 : null;
                if (rememberObserver2 != null) {
                    rememberObserver2.onRemembered();
                }
            }
            function1 = this.onState;
            if (function1 != null) {
                function1.invoke(state3);
            }
        }
        imageResult = ((State.Success) state3).result;
        Transition transitionCreate = imageResult.getRequest().transitionFactory.create(AsyncImageKt.fakeTransitionTarget, imageResult);
        if (transitionCreate instanceof CrossfadeTransition) {
            painter = new CrossfadePainter(state2 instanceof State.Loading ? state2.getPainter() : null, state3.getPainter(), this.contentScale, ((CrossfadeTransition) transitionCreate).durationMillis, ((imageResult instanceof SuccessResult) && ((SuccessResult) imageResult).isPlaceholderCached) ? false : true);
        } else {
            painter = null;
        }
        if (painter == null) {
            painter = state3.getPainter();
        }
        this._painter = painter;
        this.painter$delegate.setValue(painter);
        if (this.rememberScope != null) {
            painter2 = state2.getPainter();
            if (painter2 instanceof RememberObserver) {
                rememberObserver = (RememberObserver) painter2;
            } else {
                rememberObserver = null;
            }
            if (rememberObserver != null) {
                rememberObserver.onForgotten();
            }
            Object painter4 = state3.getPainter();
            if (painter4 instanceof RememberObserver) {
            }
            if (rememberObserver2 != null) {
                rememberObserver2.onRemembered();
            }
        }
        function1 = this.onState;
        if (function1 != null) {
            function1.invoke(state3);
        }
    }
}
