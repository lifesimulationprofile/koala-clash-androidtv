package androidx.navigation.compose;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.camera.core.CameraX;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.navigation.NavBackStackEntryState;
import androidx.navigation.NavHostController;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class NavHostControllerKt$NavControllerSaver$2 extends Lambda implements Function1 {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NavHostControllerKt$NavControllerSaver$2(Context context, int i) {
        super(1);
        this.$r8$classId = i;
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                Bundle bundle = (Bundle) obj;
                NavHostController navHostControllerAccess$createNavController = NavHostControllerKt.access$createNavController(this.$context);
                LinkedHashMap linkedHashMap = navHostControllerAccess$createNavController.backStackStates;
                if (bundle != null) {
                    bundle.setClassLoader(navHostControllerAccess$createNavController.context.getClassLoader());
                    navHostControllerAccess$createNavController.navigatorStateToRestore = bundle.getBundle("android-support-nav:controller:navigatorState");
                    navHostControllerAccess$createNavController.backStackToRestore = bundle.getParcelableArray("android-support-nav:controller:backStack");
                    linkedHashMap.clear();
                    int[] intArray = bundle.getIntArray("android-support-nav:controller:backStackDestIds");
                    ArrayList<String> stringArrayList = bundle.getStringArrayList("android-support-nav:controller:backStackIds");
                    if (intArray != null && stringArrayList != null) {
                        int length = intArray.length;
                        int i = 0;
                        int i2 = 0;
                        while (i < length) {
                            navHostControllerAccess$createNavController.backStackMap.put(Integer.valueOf(intArray[i]), stringArrayList.get(i2));
                            i++;
                            i2++;
                        }
                    }
                    ArrayList<String> stringArrayList2 = bundle.getStringArrayList("android-support-nav:controller:backStackStates");
                    if (stringArrayList2 != null) {
                        int size = stringArrayList2.size();
                        int i3 = 0;
                        while (i3 < size) {
                            String str = stringArrayList2.get(i3);
                            i3++;
                            String str2 = str;
                            Parcelable[] parcelableArray = bundle.getParcelableArray("android-support-nav:controller:backStackStates:" + str2);
                            if (parcelableArray != null) {
                                ArrayDeque arrayDeque = new ArrayDeque(parcelableArray.length);
                                int i4 = 0;
                                while (i4 < parcelableArray.length) {
                                    int i5 = i4 + 1;
                                    try {
                                        arrayDeque.addLast((NavBackStackEntryState) parcelableArray[i4]);
                                        i4 = i5;
                                    } catch (ArrayIndexOutOfBoundsException e) {
                                        throw new NoSuchElementException(e.getMessage());
                                    }
                                }
                                linkedHashMap.put(str2, arrayDeque);
                            }
                        }
                    }
                    navHostControllerAccess$createNavController.deepLinkHandled = bundle.getBoolean("android-support-nav:controller:deepLinkHandled");
                }
                return navHostControllerAccess$createNavController;
            default:
                ProcessCameraProvider processCameraProvider = ProcessCameraProvider.sAppInstance;
                processCameraProvider.mCameraX = (CameraX) obj;
                processCameraProvider.mContext = RangesKt.getApplicationContext(this.$context);
                return processCameraProvider;
        }
    }
}
