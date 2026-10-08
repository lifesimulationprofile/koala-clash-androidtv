package androidx.compose.runtime.composer.gapbuffer;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class GapGroupSourceInformation {
    public ArrayList groups;

    public abstract boolean getClosed();

    public abstract int getDataEndOffset();

    public abstract int getDataStartOffset();

    public abstract ArrayList getGroups();

    public abstract int getKey();

    public abstract String getSourceInformation();

    public abstract boolean hasAnchor(GapAnchor gapAnchor);

    public abstract GapGroupSourceInformation openInformation();

    public abstract boolean removeAnchor(GapAnchor gapAnchor);
}
