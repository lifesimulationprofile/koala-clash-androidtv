package androidx.activity;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.lang.reflect.Field;
import kotlin.SynchronizedLazyImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ImmLeaksCleaner implements LifecycleEventObserver {
    public static final SynchronizedLazyImpl cleaner$delegate = new SynchronizedLazyImpl(new ImmLeaksCleaner$$ExternalSyntheticLambda0(0));
    public final AppCompatActivity activity;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class Cleaner {
        public abstract boolean clearNextServedView(InputMethodManager inputMethodManager);

        public abstract Object getLock(InputMethodManager inputMethodManager);

        public abstract View getServedView(InputMethodManager inputMethodManager);
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class FailedInitialization extends Cleaner {
        public static final FailedInitialization INSTANCE = new FailedInitialization();

        @Override // androidx.activity.ImmLeaksCleaner.Cleaner
        public final boolean clearNextServedView(InputMethodManager inputMethodManager) {
            return false;
        }

        @Override // androidx.activity.ImmLeaksCleaner.Cleaner
        public final Object getLock(InputMethodManager inputMethodManager) {
            return null;
        }

        @Override // androidx.activity.ImmLeaksCleaner.Cleaner
        public final View getServedView(InputMethodManager inputMethodManager) {
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class ValidCleaner extends Cleaner {
        public final Field hField;
        public final Field nextServedViewField;
        public final Field servedViewField;

        public ValidCleaner(Field field, Field field2, Field field3) {
            this.hField = field;
            this.servedViewField = field2;
            this.nextServedViewField = field3;
        }

        @Override // androidx.activity.ImmLeaksCleaner.Cleaner
        public final boolean clearNextServedView(InputMethodManager inputMethodManager) {
            try {
                this.nextServedViewField.set(inputMethodManager, null);
                return true;
            } catch (IllegalAccessException unused) {
                return false;
            }
        }

        @Override // androidx.activity.ImmLeaksCleaner.Cleaner
        public final Object getLock(InputMethodManager inputMethodManager) {
            try {
                return this.hField.get(inputMethodManager);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }

        @Override // androidx.activity.ImmLeaksCleaner.Cleaner
        public final View getServedView(InputMethodManager inputMethodManager) {
            try {
                return (View) this.servedViewField.get(inputMethodManager);
            } catch (ClassCastException | IllegalAccessException unused) {
                return null;
            }
        }
    }

    public ImmLeaksCleaner(AppCompatActivity appCompatActivity) {
        this.activity = appCompatActivity;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        InputMethodManager inputMethodManager;
        Cleaner cleaner;
        Object lock;
        if (event == Lifecycle.Event.ON_DESTROY && (lock = (cleaner = (Cleaner) cleaner$delegate.getValue()).getLock((inputMethodManager = (InputMethodManager) this.activity.getSystemService("input_method")))) != null) {
            synchronized (lock) {
                View servedView = cleaner.getServedView(inputMethodManager);
                if (servedView == null) {
                    return;
                }
                if (servedView.isAttachedToWindow()) {
                    return;
                }
                boolean zClearNextServedView = cleaner.clearNextServedView(inputMethodManager);
                if (zClearNextServedView) {
                    inputMethodManager.isActive();
                }
            }
        }
    }
}
