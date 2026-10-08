package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.os.Build;
import androidx.camera.camera2.internal.ZslControlImpl;
import androidx.camera.core.impl.utils.executor.SequentialExecutor;
import androidx.core.os.LocaleListPlatformWrapper$$ExternalSyntheticApiModelOutline0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SessionConfigurationCompat {
    public final SessionConfigurationCompatImpl mImpl;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class SessionConfigurationCompatApi28Impl implements SessionConfigurationCompatImpl {
        public final SessionConfiguration mObject;
        public final List mOutputConfigurations;

        public SessionConfigurationCompatApi28Impl(ArrayList arrayList, SequentialExecutor sequentialExecutor, ZslControlImpl.AnonymousClass1 anonymousClass1) {
            SessionConfiguration sessionConfiguration = new SessionConfiguration(0, SessionConfigurationCompat.transformFromCompat(arrayList), sequentialExecutor, anonymousClass1);
            this.mObject = sessionConfiguration;
            List<OutputConfiguration> outputConfigurations = sessionConfiguration.getOutputConfigurations();
            ArrayList arrayList2 = new ArrayList(outputConfigurations.size());
            for (OutputConfiguration outputConfiguration : outputConfigurations) {
                OutputConfigurationCompat outputConfigurationCompat = null;
                if (outputConfiguration != null) {
                    int i = Build.VERSION.SDK_INT;
                    OutputConfigurationCompatApi24Impl outputConfigurationCompatApi33Impl = i >= 33 ? new OutputConfigurationCompatApi33Impl(outputConfiguration) : i >= 28 ? new OutputConfigurationCompatApi28Impl(new OutputConfigurationCompatApi28Impl.OutputConfigurationParamsApi28(outputConfiguration)) : i >= 26 ? new OutputConfigurationCompatApi26Impl(new OutputConfigurationCompatApi26Impl.OutputConfigurationParamsApi26(outputConfiguration)) : i >= 24 ? new OutputConfigurationCompatApi24Impl(new OutputConfigurationCompatApi24Impl.OutputConfigurationParamsApi24(outputConfiguration)) : null;
                    if (outputConfigurationCompatApi33Impl != null) {
                        outputConfigurationCompat = new OutputConfigurationCompat(outputConfigurationCompatApi33Impl);
                    }
                }
                arrayList2.add(outputConfigurationCompat);
            }
            this.mOutputConfigurations = Collections.unmodifiableList(arrayList2);
        }

        public final boolean equals(Object obj) {
            if (obj instanceof SessionConfigurationCompatApi28Impl) {
                return Objects.equals(this.mObject, ((SessionConfigurationCompatApi28Impl) obj).mObject);
            }
            return false;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public final Executor getExecutor() {
            return this.mObject.getExecutor();
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public final InputConfigurationCompat getInputConfiguration() {
            return InputConfigurationCompat.wrap(this.mObject.getInputConfiguration());
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public final List getOutputConfigurations() {
            return this.mOutputConfigurations;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public final Object getSessionConfiguration() {
            return this.mObject;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public final int getSessionType() {
            return this.mObject.getSessionType();
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public final CameraCaptureSession.StateCallback getStateCallback() {
            return this.mObject.getStateCallback();
        }

        public final int hashCode() {
            return this.mObject.hashCode();
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public final void setInputConfiguration(InputConfigurationCompat inputConfigurationCompat) {
            this.mObject.setInputConfiguration(inputConfigurationCompat.mImpl.mObject);
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public final void setSessionParameters(CaptureRequest captureRequest) {
            this.mObject.setSessionParameters(captureRequest);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public interface SessionConfigurationCompatImpl {
        Executor getExecutor();

        InputConfigurationCompat getInputConfiguration();

        List getOutputConfigurations();

        Object getSessionConfiguration();

        int getSessionType();

        CameraCaptureSession.StateCallback getStateCallback();

        void setInputConfiguration(InputConfigurationCompat inputConfigurationCompat);

        void setSessionParameters(CaptureRequest captureRequest);
    }

    public SessionConfigurationCompat(ArrayList arrayList, SequentialExecutor sequentialExecutor, ZslControlImpl.AnonymousClass1 anonymousClass1) {
        if (Build.VERSION.SDK_INT < 28) {
            this.mImpl = new SessionConfigurationCompatBaseImpl(arrayList, sequentialExecutor, anonymousClass1);
        } else {
            this.mImpl = new SessionConfigurationCompatApi28Impl(arrayList, sequentialExecutor, anonymousClass1);
        }
    }

    public static ArrayList transformFromCompat(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(LocaleListPlatformWrapper$$ExternalSyntheticApiModelOutline0.m(((OutputConfigurationCompat) it.next()).mImpl.getOutputConfiguration()));
        }
        return arrayList;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SessionConfigurationCompat)) {
            return false;
        }
        return this.mImpl.equals(((SessionConfigurationCompat) obj).mImpl);
    }

    public final int hashCode() {
        return this.mImpl.hashCode();
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class SessionConfigurationCompatBaseImpl implements SessionConfigurationCompatImpl {
        public final SequentialExecutor mExecutor;
        public InputConfigurationCompat mInputConfig = null;
        public final List mOutputConfigurations;
        public final ZslControlImpl.AnonymousClass1 mStateCallback;

        public SessionConfigurationCompatBaseImpl(ArrayList arrayList, SequentialExecutor sequentialExecutor, ZslControlImpl.AnonymousClass1 anonymousClass1) {
            this.mOutputConfigurations = Collections.unmodifiableList(new ArrayList(arrayList));
            this.mStateCallback = anonymousClass1;
            this.mExecutor = sequentialExecutor;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SessionConfigurationCompatBaseImpl) {
                SessionConfigurationCompatBaseImpl sessionConfigurationCompatBaseImpl = (SessionConfigurationCompatBaseImpl) obj;
                List list = sessionConfigurationCompatBaseImpl.mOutputConfigurations;
                if (Objects.equals(this.mInputConfig, sessionConfigurationCompatBaseImpl.mInputConfig)) {
                    List list2 = this.mOutputConfigurations;
                    if (list2.size() == list.size()) {
                        for (int i = 0; i < list2.size(); i++) {
                            if (((OutputConfigurationCompat) list2.get(i)).equals(list.get(i))) {
                            }
                        }
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public final Executor getExecutor() {
            return this.mExecutor;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public final InputConfigurationCompat getInputConfiguration() {
            return this.mInputConfig;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public final List getOutputConfigurations() {
            return this.mOutputConfigurations;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public final Object getSessionConfiguration() {
            return null;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public final int getSessionType() {
            return 0;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public final CameraCaptureSession.StateCallback getStateCallback() {
            return this.mStateCallback;
        }

        public final int hashCode() {
            int iHashCode = this.mOutputConfigurations.hashCode() ^ 31;
            int i = (iHashCode << 5) - iHashCode;
            InputConfigurationCompat inputConfigurationCompat = this.mInputConfig;
            int iHashCode2 = (inputConfigurationCompat == null ? 0 : inputConfigurationCompat.mImpl.mObject.hashCode()) ^ i;
            return (iHashCode2 << 5) - iHashCode2;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public final void setInputConfiguration(InputConfigurationCompat inputConfigurationCompat) {
            this.mInputConfig = inputConfigurationCompat;
        }

        @Override // androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat.SessionConfigurationCompatImpl
        public final void setSessionParameters(CaptureRequest captureRequest) {
        }
    }
}
