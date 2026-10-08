package androidx.core.app;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v4.app.INotificationSideChannel;
import android.util.Log;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import com.koala.clash.R;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class NotificationManagerCompat {
    public static String sEnabledNotificationListeners;
    public static SideChannelManager sSideChannelManager;
    public final Context mContext;
    public final NotificationManager mNotificationManager;
    public static final Object sEnabledNotificationListenersLock = new Object();
    public static HashSet sEnabledNotificationListenerPackages = new HashSet();
    public static final Object sLock = new Object();

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class NotifyTask {
        public final Notification notif;
        public final String packageName;

        public NotifyTask(String str, Notification notification) {
            this.packageName = str;
            this.notif = notification;
        }

        public final void send(INotificationSideChannel iNotificationSideChannel) {
            String str = this.packageName;
            Notification notification = this.notif;
            INotificationSideChannel.Stub.Proxy proxy = (INotificationSideChannel.Stub.Proxy) iNotificationSideChannel;
            proxy.getClass();
            Parcel parcelObtain = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(INotificationSideChannel.DESCRIPTOR);
                parcelObtain.writeString(str);
                parcelObtain.writeInt(R.id.nf_clash_status);
                parcelObtain.writeString(null);
                parcelObtain.writeInt(1);
                notification.writeToParcel(parcelObtain, 0);
                proxy.mRemote.transact(1, parcelObtain, null, 1);
            } finally {
                parcelObtain.recycle();
            }
        }

        public final String toString() {
            return ImageAnalysis$$ExternalSyntheticLambda1.m(new StringBuilder("NotifyTask[packageName:"), this.packageName, ", id:2131296579, tag:null]");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class ServiceConnectedEvent {
        public final ComponentName componentName;
        public final IBinder iBinder;

        public ServiceConnectedEvent(ComponentName componentName, IBinder iBinder) {
            this.componentName = componentName;
            this.iBinder = iBinder;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class SideChannelManager implements Handler.Callback, ServiceConnection {
        public final Context mContext;
        public final Handler mHandler;
        public final HashMap mRecordMap = new HashMap();
        public HashSet mCachedEnabledPackages = new HashSet();

        /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
        public final class ListenerRecord {
            public final ComponentName componentName;
            public INotificationSideChannel service;
            public boolean bound = false;
            public final ArrayDeque taskQueue = new ArrayDeque();
            public int retryCount = 0;

            public ListenerRecord(ComponentName componentName) {
                this.componentName = componentName;
            }
        }

        public SideChannelManager(Context context) {
            this.mContext = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            handlerThread.start();
            this.mHandler = new Handler(handlerThread.getLooper(), this);
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            HashSet hashSet;
            int i = message.what;
            INotificationSideChannel iNotificationSideChannel = null;
            if (i == 0) {
                NotifyTask notifyTask = (NotifyTask) message.obj;
                String string = Settings.Secure.getString(this.mContext.getContentResolver(), "enabled_notification_listeners");
                synchronized (NotificationManagerCompat.sEnabledNotificationListenersLock) {
                    if (string != null) {
                        try {
                            if (!string.equals(NotificationManagerCompat.sEnabledNotificationListeners)) {
                                String[] strArrSplit = string.split(":", -1);
                                HashSet hashSet2 = new HashSet(strArrSplit.length);
                                for (String str : strArrSplit) {
                                    ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
                                    if (componentNameUnflattenFromString != null) {
                                        hashSet2.add(componentNameUnflattenFromString.getPackageName());
                                    }
                                }
                                NotificationManagerCompat.sEnabledNotificationListenerPackages = hashSet2;
                                NotificationManagerCompat.sEnabledNotificationListeners = string;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    hashSet = NotificationManagerCompat.sEnabledNotificationListenerPackages;
                }
                if (!hashSet.equals(this.mCachedEnabledPackages)) {
                    this.mCachedEnabledPackages = hashSet;
                    List<ResolveInfo> listQueryIntentServices = this.mContext.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
                    HashSet<ComponentName> hashSet3 = new HashSet();
                    for (ResolveInfo resolveInfo : listQueryIntentServices) {
                        if (hashSet.contains(resolveInfo.serviceInfo.packageName)) {
                            ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                            ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                            if (resolveInfo.serviceInfo.permission != null) {
                                Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                            } else {
                                hashSet3.add(componentName);
                            }
                        }
                    }
                    for (ComponentName componentName2 : hashSet3) {
                        if (!this.mRecordMap.containsKey(componentName2)) {
                            if (Log.isLoggable("NotifManCompat", 3)) {
                                Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                            }
                            this.mRecordMap.put(componentName2, new ListenerRecord(componentName2));
                        }
                    }
                    Iterator it = this.mRecordMap.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry entry = (Map.Entry) it.next();
                        if (!hashSet3.contains(entry.getKey())) {
                            if (Log.isLoggable("NotifManCompat", 3)) {
                                Log.d("NotifManCompat", "Removing listener record for " + entry.getKey());
                            }
                            ListenerRecord listenerRecord = (ListenerRecord) entry.getValue();
                            if (listenerRecord.bound) {
                                this.mContext.unbindService(this);
                                listenerRecord.bound = false;
                            }
                            listenerRecord.service = null;
                            it.remove();
                        }
                    }
                }
                for (ListenerRecord listenerRecord2 : this.mRecordMap.values()) {
                    listenerRecord2.taskQueue.add(notifyTask);
                    processListenerQueue(listenerRecord2);
                }
            } else if (i == 1) {
                ServiceConnectedEvent serviceConnectedEvent = (ServiceConnectedEvent) message.obj;
                ComponentName componentName3 = serviceConnectedEvent.componentName;
                IBinder iBinder = serviceConnectedEvent.iBinder;
                ListenerRecord listenerRecord3 = (ListenerRecord) this.mRecordMap.get(componentName3);
                if (listenerRecord3 != null) {
                    int i2 = INotificationSideChannel.Stub.$r8$clinit;
                    if (iBinder != null) {
                        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(INotificationSideChannel.DESCRIPTOR);
                        if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof INotificationSideChannel)) {
                            INotificationSideChannel.Stub.Proxy proxy = new INotificationSideChannel.Stub.Proxy();
                            proxy.mRemote = iBinder;
                            iNotificationSideChannel = proxy;
                        } else {
                            iNotificationSideChannel = (INotificationSideChannel) iInterfaceQueryLocalInterface;
                        }
                    }
                    listenerRecord3.service = iNotificationSideChannel;
                    listenerRecord3.retryCount = 0;
                    processListenerQueue(listenerRecord3);
                    return true;
                }
            } else if (i == 2) {
                ListenerRecord listenerRecord4 = (ListenerRecord) this.mRecordMap.get((ComponentName) message.obj);
                if (listenerRecord4 != null) {
                    if (listenerRecord4.bound) {
                        this.mContext.unbindService(this);
                        listenerRecord4.bound = false;
                    }
                    listenerRecord4.service = null;
                    return true;
                }
            } else {
                if (i != 3) {
                    return false;
                }
                ListenerRecord listenerRecord5 = (ListenerRecord) this.mRecordMap.get((ComponentName) message.obj);
                if (listenerRecord5 != null) {
                    processListenerQueue(listenerRecord5);
                    return true;
                }
            }
            return true;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Connected to service " + componentName);
            }
            this.mHandler.obtainMessage(1, new ServiceConnectedEvent(componentName, iBinder)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.mHandler.obtainMessage(2, componentName).sendToTarget();
        }

        public final void processListenerQueue(ListenerRecord listenerRecord) {
            boolean z;
            ArrayDeque arrayDeque = listenerRecord.taskQueue;
            ComponentName componentName = listenerRecord.componentName;
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Processing component " + componentName + ", " + arrayDeque.size() + " queued tasks");
            }
            if (arrayDeque.isEmpty()) {
                return;
            }
            if (listenerRecord.bound) {
                z = true;
            } else {
                Intent component = new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(componentName);
                Context context = this.mContext;
                boolean zBindService = context.bindService(component, this, 33);
                listenerRecord.bound = zBindService;
                if (zBindService) {
                    listenerRecord.retryCount = 0;
                } else {
                    Log.w("NotifManCompat", "Unable to bind to listener " + componentName);
                    context.unbindService(this);
                }
                z = listenerRecord.bound;
            }
            if (!z || listenerRecord.service == null) {
                scheduleListenerRetry(listenerRecord);
                return;
            }
            while (true) {
                NotifyTask notifyTask = (NotifyTask) arrayDeque.peek();
                if (notifyTask == null) {
                    break;
                }
                try {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Sending task " + notifyTask);
                    }
                    notifyTask.send(listenerRecord.service);
                    arrayDeque.remove();
                } catch (DeadObjectException unused) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Remote service has died: " + componentName);
                    }
                } catch (RemoteException e) {
                    Log.w("NotifManCompat", "RemoteException communicating with " + componentName, e);
                }
            }
            if (arrayDeque.isEmpty()) {
                return;
            }
            scheduleListenerRetry(listenerRecord);
        }

        public final void scheduleListenerRetry(ListenerRecord listenerRecord) {
            ComponentName componentName = listenerRecord.componentName;
            ArrayDeque arrayDeque = listenerRecord.taskQueue;
            Handler handler = this.mHandler;
            if (handler.hasMessages(3, componentName)) {
                return;
            }
            int i = listenerRecord.retryCount;
            int i2 = i + 1;
            listenerRecord.retryCount = i2;
            if (i2 <= 6) {
                int i3 = (1 << i) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Scheduling retry for " + i3 + " ms");
                }
                handler.sendMessageDelayed(handler.obtainMessage(3, componentName), i3);
                return;
            }
            Log.w("NotifManCompat", "Giving up on delivering " + arrayDeque.size() + " tasks to " + componentName + " after " + listenerRecord.retryCount + " retries");
            arrayDeque.clear();
        }
    }

    public NotificationManagerCompat(Context context) {
        this.mContext = context;
        this.mNotificationManager = (NotificationManager) context.getSystemService("notification");
    }
}
