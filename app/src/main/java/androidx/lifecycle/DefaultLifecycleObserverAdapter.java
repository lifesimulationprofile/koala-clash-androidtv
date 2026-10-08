package androidx.lifecycle;

import coil.network.HttpException;
import coil.request.RequestService;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class DefaultLifecycleObserverAdapter implements LifecycleEventObserver {
    public final /* synthetic */ int $r8$classId;
    public final Object defaultLifecycleObserver;
    public final Object lifecycleEventObserver;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[Lifecycle.Event.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ DefaultLifecycleObserverAdapter(int i, Object obj, Object obj2) {
        this.$r8$classId = i;
        this.defaultLifecycleObserver = obj;
        this.lifecycleEventObserver = obj2;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        switch (this.$r8$classId) {
            case 0:
                DefaultLifecycleObserver defaultLifecycleObserver = (DefaultLifecycleObserver) this.defaultLifecycleObserver;
                switch (WhenMappings.$EnumSwitchMapping$0[event.ordinal()]) {
                    case 1:
                        defaultLifecycleObserver.getClass();
                        break;
                    case 2:
                        defaultLifecycleObserver.onStart(lifecycleOwner);
                        break;
                    case 3:
                        defaultLifecycleObserver.onResume(lifecycleOwner);
                        break;
                    case 4:
                        defaultLifecycleObserver.getClass();
                        break;
                    case 5:
                        defaultLifecycleObserver.onStop(lifecycleOwner);
                        break;
                    case 6:
                        defaultLifecycleObserver.onDestroy(lifecycleOwner);
                        break;
                    case 7:
                        throw new IllegalArgumentException("ON_ANY must not been send by anybody");
                    default:
                        throw new HttpException();
                }
                LifecycleEventObserver lifecycleEventObserver = (LifecycleEventObserver) this.lifecycleEventObserver;
                if (lifecycleEventObserver != null) {
                    lifecycleEventObserver.onStateChanged(lifecycleOwner, event);
                    return;
                }
                return;
            case 1:
                if (event == Lifecycle.Event.ON_START) {
                    ((Lifecycle) this.defaultLifecycleObserver).removeObserver(this);
                    ((RequestService) this.lifecycleEventObserver).runOnNextRecreation();
                    return;
                }
                return;
            default:
                HashMap map = ((ClassesInfoCache.CallbackInfo) this.lifecycleEventObserver).mEventToHandlers;
                List list = (List) map.get(event);
                Object obj = this.defaultLifecycleObserver;
                ClassesInfoCache.CallbackInfo.invokeMethodsForEvent(list, lifecycleOwner, event, obj);
                ClassesInfoCache.CallbackInfo.invokeMethodsForEvent((List) map.get(Lifecycle.Event.ON_ANY), lifecycleOwner, event, obj);
                return;
        }
    }

    public DefaultLifecycleObserverAdapter(LifecycleObserver lifecycleObserver) {
        this.$r8$classId = 2;
        this.defaultLifecycleObserver = lifecycleObserver;
        ClassesInfoCache classesInfoCache = ClassesInfoCache.sInstance;
        Class<?> cls = lifecycleObserver.getClass();
        ClassesInfoCache.CallbackInfo callbackInfo = (ClassesInfoCache.CallbackInfo) classesInfoCache.mCallbackMap.get(cls);
        this.lifecycleEventObserver = callbackInfo == null ? classesInfoCache.createInfo(cls, null) : callbackInfo;
    }
}
