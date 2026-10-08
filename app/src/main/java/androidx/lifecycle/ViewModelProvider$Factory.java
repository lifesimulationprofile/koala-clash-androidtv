package androidx.lifecycle;

import androidx.lifecycle.viewmodel.MutableCreationExtras;
import kotlin.jvm.internal.ClassReference;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public interface ViewModelProvider$Factory {
    ViewModel create(Class cls);

    ViewModel create(Class cls, MutableCreationExtras mutableCreationExtras);

    ViewModel create(ClassReference classReference, MutableCreationExtras mutableCreationExtras);
}
