package androidx.customview.view;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.Toolbar;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.PersistentVectorBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.SmallPersistentVector;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbsSavedState implements Parcelable {
    public final Parcelable mSuperState;
    public static final AnonymousClass1 EMPTY_STATE = new AnonymousClass1();
    public static final Parcelable.Creator<AbsSavedState> CREATOR = new AnonymousClass2(0);

    /* JADX INFO: renamed from: androidx.customview.view.AbsSavedState$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 extends AbsSavedState {
    }

    public AbsSavedState() {
        this.mSuperState = null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mSuperState, i);
    }

    /* JADX INFO: renamed from: androidx.customview.view.AbsSavedState$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass2 implements Parcelable.ClassLoaderCreator {
        public final /* synthetic */ int $r8$classId;

        public /* synthetic */ AnonymousClass2(int i) {
            this.$r8$classId = i;
        }

        /* JADX INFO: renamed from: createFromParcel, reason: collision with other method in class */
        public static SnapshotStateSet m772createFromParcel(Parcel parcel, ClassLoader classLoader) {
            SnapshotStateSet snapshotStateSet = new SnapshotStateSet();
            if (classLoader == null) {
                classLoader = SnapshotStateSet.class.getClassLoader();
            }
            int i = parcel.readInt();
            for (int i2 = 0; i2 < i; i2++) {
                snapshotStateSet.add(parcel.readValue(classLoader));
            }
            return snapshotStateSet;
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            switch (this.$r8$classId) {
                case 0:
                    return new AbsSavedState[i];
                case 1:
                    return new SnapshotStateList[i];
                case 2:
                    return new Toolbar.SavedState[i];
                case 3:
                    return new SnapshotStateSet[i];
                case 4:
                    return new CoordinatorLayout.SavedState[i];
                case 5:
                    return new RecyclerView.SavedState[i];
                case 6:
                    return new BottomSheetBehavior.SavedState[i];
                case 7:
                    return new MaterialButton.SavedState[i];
                case 8:
                    return new CheckableImageButton.SavedState[i];
                default:
                    return new TextInputLayout.SavedState[i];
            }
        }

        public static SnapshotStateList createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (classLoader == null) {
                classLoader = AnonymousClass2.class.getClassLoader();
            }
            int i = parcel.readInt();
            if (i == 0) {
                return new SnapshotStateList();
            }
            PersistentVectorBuilder persistentVectorBuilderBuilder = SmallPersistentVector.EMPTY.builder();
            for (int i2 = 0; i2 < i; i2++) {
                persistentVectorBuilderBuilder.add(parcel.readValue(classLoader));
            }
            return new SnapshotStateList(persistentVectorBuilderBuilder.build());
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
            switch (this.$r8$classId) {
                case 0:
                    if (parcel.readParcelable(classLoader) == null) {
                        return AbsSavedState.EMPTY_STATE;
                    }
                    throw new IllegalStateException("superState must be null");
                case 1:
                    return createFromParcel(parcel, classLoader);
                case 2:
                    return new Toolbar.SavedState(parcel, classLoader);
                case 3:
                    return m772createFromParcel(parcel, classLoader);
                case 4:
                    return new CoordinatorLayout.SavedState(parcel, classLoader);
                case 5:
                    return new RecyclerView.SavedState(parcel, classLoader);
                case 6:
                    return new BottomSheetBehavior.SavedState(parcel, classLoader);
                case 7:
                    return new MaterialButton.SavedState(parcel, classLoader);
                case 8:
                    return new CheckableImageButton.SavedState(parcel, classLoader);
                default:
                    return new TextInputLayout.SavedState(parcel, classLoader);
            }
        }

        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            switch (this.$r8$classId) {
                case 0:
                    if (parcel.readParcelable(null) == null) {
                        return AbsSavedState.EMPTY_STATE;
                    }
                    throw new IllegalStateException("superState must be null");
                case 1:
                    return createFromParcel(parcel, (ClassLoader) null);
                case 2:
                    return new Toolbar.SavedState(parcel, null);
                case 3:
                    return m772createFromParcel(parcel, (ClassLoader) null);
                case 4:
                    return new CoordinatorLayout.SavedState(parcel, null);
                case 5:
                    return new RecyclerView.SavedState(parcel, null);
                case 6:
                    return new BottomSheetBehavior.SavedState(parcel, null);
                case 7:
                    return new MaterialButton.SavedState(parcel, null);
                case 8:
                    return new CheckableImageButton.SavedState(parcel, null);
                default:
                    return new TextInputLayout.SavedState(parcel, null);
            }
        }
    }

    public AbsSavedState(Parcelable parcelable) {
        if (parcelable != null) {
            this.mSuperState = parcelable == EMPTY_STATE ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    public AbsSavedState(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.mSuperState = parcelable == null ? EMPTY_STATE : parcelable;
    }
}
