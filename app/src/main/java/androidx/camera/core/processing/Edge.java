package androidx.camera.core.processing;

import androidx.collection.SimpleArrayMap;
import androidx.core.provider.FontRequestWorker;
import androidx.core.util.Consumer;
import coil.request.RequestService;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Edge implements Consumer {
    public final /* synthetic */ int $r8$classId;
    public Object mListener;

    public /* synthetic */ Edge() {
        this.$r8$classId = 0;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                ((Consumer) this.mListener).accept(obj);
                return;
            case 1:
                FontRequestWorker.TypefaceResult typefaceResult = (FontRequestWorker.TypefaceResult) obj;
                if (typefaceResult == null) {
                    typefaceResult = new FontRequestWorker.TypefaceResult(-3);
                }
                ((RequestService) this.mListener).onTypefaceResult(typefaceResult);
                return;
            default:
                FontRequestWorker.TypefaceResult typefaceResult2 = (FontRequestWorker.TypefaceResult) obj;
                synchronized (FontRequestWorker.LOCK) {
                    try {
                        SimpleArrayMap simpleArrayMap = FontRequestWorker.PENDING_REPLIES;
                        ArrayList arrayList = (ArrayList) simpleArrayMap.get((String) this.mListener);
                        if (arrayList == null) {
                            return;
                        }
                        simpleArrayMap.remove((String) this.mListener);
                        for (int i = 0; i < arrayList.size(); i++) {
                            ((Consumer) arrayList.get(i)).accept(typefaceResult2);
                        }
                        return;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
        }
    }

    public /* synthetic */ Edge(int i, Object obj) {
        this.$r8$classId = i;
        this.mListener = obj;
    }
}
