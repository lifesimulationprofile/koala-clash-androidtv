package androidx.lifecycle;

import android.graphics.Rect;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.SessionConfig;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.composer.gapbuffer.GapAnchor;
import androidx.compose.runtime.composer.gapbuffer.GapGroupSourceInformation;
import androidx.compose.runtime.tooling.ComposeStackTraceFrame;
import coil.network.HttpException;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class Lifecycle implements CameraControlInternal {
    public final Object internalScopeRef;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Event {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Event[] $VALUES;
        public static final Companion Companion;
        public static final Event ON_ANY;
        public static final Event ON_CREATE;
        public static final Event ON_DESTROY;
        public static final Event ON_PAUSE;
        public static final Event ON_RESUME;
        public static final Event ON_START;
        public static final Event ON_STOP;

        /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
        public final class Companion {
        }

        /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
        public abstract /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Event.values().length];
                try {
                    iArr[Event.ON_CREATE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Event.ON_STOP.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Event.ON_START.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Event.ON_PAUSE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[Event.ON_RESUME.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[Event.ON_DESTROY.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[Event.ON_ANY.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        static {
            Event event = new Event("ON_CREATE", 0);
            ON_CREATE = event;
            Event event2 = new Event("ON_START", 1);
            ON_START = event2;
            Event event3 = new Event("ON_RESUME", 2);
            ON_RESUME = event3;
            Event event4 = new Event("ON_PAUSE", 3);
            ON_PAUSE = event4;
            Event event5 = new Event("ON_STOP", 4);
            ON_STOP = event5;
            Event event6 = new Event("ON_DESTROY", 5);
            ON_DESTROY = event6;
            Event event7 = new Event("ON_ANY", 6);
            ON_ANY = event7;
            Event[] eventArr = {event, event2, event3, event4, event5, event6, event7};
            $VALUES = eventArr;
            $ENTRIES = new EnumEntriesList(eventArr);
            Companion = new Companion();
        }

        public static Event valueOf(String str) {
            return (Event) Enum.valueOf(Event.class, str);
        }

        public static Event[] values() {
            return (Event[]) $VALUES.clone();
        }

        public final State getTargetState() {
            switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
                case 1:
                case 2:
                    return State.CREATED;
                case 3:
                case 4:
                    return State.STARTED;
                case 5:
                    return State.RESUMED;
                case 6:
                    return State.DESTROYED;
                case 7:
                    throw new IllegalArgumentException(this + " has no target state");
                default:
                    throw new HttpException();
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class State {
        public static final /* synthetic */ State[] $VALUES;
        public static final State CREATED;
        public static final State DESTROYED;
        public static final State INITIALIZED;
        public static final State RESUMED;
        public static final State STARTED;

        static {
            State state = new State("DESTROYED", 0);
            DESTROYED = state;
            State state2 = new State("INITIALIZED", 1);
            INITIALIZED = state2;
            State state3 = new State("CREATED", 2);
            CREATED = state3;
            State state4 = new State("STARTED", 3);
            STARTED = state4;
            State state5 = new State("RESUMED", 4);
            RESUMED = state5;
            $VALUES = new State[]{state, state2, state3, state4, state5};
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        public final boolean isAtLeast(State state) {
            return compareTo(state) >= 0;
        }
    }

    public Lifecycle(CameraControlInternal cameraControlInternal) {
        this.internalScopeRef = cameraControlInternal;
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void addInteropConfig(Config config) {
        ((CameraControlInternal) this.internalScopeRef).addInteropConfig(config);
    }

    public abstract void addObserver(LifecycleObserver lifecycleObserver);

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void addZslConfig(SessionConfig.Builder builder) {
        ((CameraControlInternal) this.internalScopeRef).addZslConfig(builder);
    }

    public boolean appendGroupSourceInformation(int i, GapGroupSourceInformation gapGroupSourceInformation, Object obj) {
        ArrayList groups = gapGroupSourceInformation.getGroups();
        boolean z = false;
        if (groups != null) {
            int size = groups.size();
            for (int i2 = 0; i2 < size; i2++) {
                Object obj2 = groups.get(i2);
                if (obj2 instanceof GapAnchor) {
                    if (obj2.equals(obj)) {
                        appendTraceFrame(gapGroupSourceInformation.getKey(), gapGroupSourceInformation, obj2);
                        return true;
                    }
                } else {
                    if (!(obj2 instanceof GapGroupSourceInformation)) {
                        throw new IllegalStateException(("Unexpected child source info " + obj2).toString());
                    }
                    if (appendGroupSourceInformation(i, (GapGroupSourceInformation) obj2, obj)) {
                        appendTraceFrame(gapGroupSourceInformation.getKey(), gapGroupSourceInformation, obj2);
                        return true;
                    }
                }
            }
        } else {
            if (!gapGroupSourceInformation.getClosed()) {
                appendTraceFrame(i, gapGroupSourceInformation, null);
                return true;
            }
            int dataStartOffset = gapGroupSourceInformation.getDataStartOffset();
            int dataEndOffset = gapGroupSourceInformation.getDataEndOffset();
            if (obj instanceof Integer) {
                Number number = (Number) obj;
                int iIntValue = number.intValue();
                if ((dataStartOffset <= iIntValue && iIntValue < dataEndOffset) || (dataStartOffset == dataEndOffset && dataStartOffset == number.intValue())) {
                    z = true;
                }
                if (z) {
                    appendTraceFrame(gapGroupSourceInformation.getKey(), gapGroupSourceInformation, null);
                }
                return z;
            }
        }
        return false;
    }

    public void appendTraceFrame(int i, GapGroupSourceInformation gapGroupSourceInformation, Object obj) {
        ((ArrayList) this.internalScopeRef).add(new ComposeStackTraceFrame(i, null, null));
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void clearInteropConfig() {
        ((CameraControlInternal) this.internalScopeRef).clearInteropConfig();
    }

    public abstract void clearWatchSet$runtime(SendChannel sendChannel);

    public abstract void commitSubscriptionChanges$runtime();

    public abstract Object create(Object obj);

    public abstract void dispose$runtime();

    @Override // androidx.camera.core.impl.CameraControlInternal
    public ListenableFuture enableTorch(boolean z) {
        return ((CameraControlInternal) this.internalScopeRef).enableTorch(z);
    }

    public Object get(Object obj) {
        synchronized (((HashMap) this.internalScopeRef)) {
            try {
                if (((HashMap) this.internalScopeRef).containsKey(obj)) {
                    return ((HashMap) this.internalScopeRef).get(obj);
                }
                Object objCreate = create(obj);
                ((HashMap) this.internalScopeRef).put(obj, objCreate);
                return objCreate;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract State getCurrentState();

    /* JADX INFO: renamed from: getCurrentState, reason: collision with other method in class */
    public abstract Object mo773getCurrentState();

    @Override // androidx.camera.core.impl.CameraControlInternal
    public Config getInteropConfig() {
        return ((CameraControlInternal) this.internalScopeRef).getInteropConfig();
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public Rect getSensorRect() {
        return ((CameraControlInternal) this.internalScopeRef).getSensorRect();
    }

    public abstract Object getTargetState();

    public abstract int groupKeyOf(GapAnchor gapAnchor);

    public void processEdge(int i, Object obj, GapGroupSourceInformation gapGroupSourceInformation, Object obj2) {
        if (Intrinsics.areEqual(obj, Composer$Companion.Empty)) {
            appendTraceFrame(i, gapGroupSourceInformation, null);
        }
    }

    public abstract Function1 readObserverFor$runtime(SendChannel sendChannel);

    public abstract void removeObserver(LifecycleObserver lifecycleObserver);

    public abstract void setCurrentState$animation_core(Object obj);

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void setFlashMode(int i) {
        ((CameraControlInternal) this.internalScopeRef).setFlashMode(i);
    }

    @Override // androidx.camera.core.impl.CameraControlInternal
    public void setScreenFlash(ImageCapture.ScreenFlash screenFlash) {
        ((CameraControlInternal) this.internalScopeRef).setScreenFlash(screenFlash);
    }

    public abstract GapGroupSourceInformation sourceInformationOf(GapAnchor gapAnchor);

    public GapGroupSourceInformation sourceInformationOf(Object obj) {
        if (obj instanceof GapAnchor) {
            return sourceInformationOf((GapAnchor) obj);
        }
        if (obj instanceof GapGroupSourceInformation) {
            return (GapGroupSourceInformation) obj;
        }
        throw new IllegalStateException(("Unexpected child source info " + obj).toString());
    }

    public abstract void transitionConfigured$animation_core(Transition transition);

    public abstract void transitionRemoved$animation_core();

    public Lifecycle(int i) {
        switch (i) {
            case 2:
                this.internalScopeRef = Stack.mutableStateOf$default(Boolean.FALSE);
                break;
            case 3:
                this.internalScopeRef = new Object();
                break;
            case 4:
                this.internalScopeRef = new ArrayList();
                break;
            case 5:
                this.internalScopeRef = new HashMap();
                break;
            default:
                this.internalScopeRef = new AtomicReference();
                break;
        }
    }
}
