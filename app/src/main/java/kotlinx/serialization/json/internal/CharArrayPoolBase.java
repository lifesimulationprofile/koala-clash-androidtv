package kotlinx.serialization.json.internal;

import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import coil.request.RequestService;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class CharArrayPoolBase {
    public Object arrays;
    public int charsTotal;

    public CharArrayPoolBase(int i) {
        this.charsTotal = i;
    }

    public abstract WindowInsetsCompat onProgress(WindowInsetsCompat windowInsetsCompat, List list);

    public abstract RequestService onStart(WindowInsetsAnimationCompat windowInsetsAnimationCompat, RequestService requestService);

    public void onPrepare() {
    }

    public void onEnd(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
    }
}
