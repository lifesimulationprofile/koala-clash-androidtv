package com.github.kr328.clash.design.compose.theme;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.Stack;
import com.github.kr328.clash.design.model.DarkMode;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ThemeState {
    public static final ParcelableSnapshotMutableState state$delegate = Stack.mutableStateOf$default(DarkMode.Auto);
}
