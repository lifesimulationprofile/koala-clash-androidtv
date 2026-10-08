package androidx.compose.ui.semantics;

import android.media.MediaCodec;
import androidx.camera.core.Preview;
import androidx.camera.core.impl.AutoValue_SessionConfig_OutputConfig;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import coil.util.ImmutableHardwareBitmapService;
import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class SemanticsSortKt$$ExternalSyntheticLambda0 implements Comparator {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ SemanticsSortKt$$ExternalSyntheticLambda0(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                return ((Number) ((Function2) this.f$0).invoke(obj, obj2)).intValue();
            case 1:
                AutoValue_SessionConfig_OutputConfig autoValue_SessionConfig_OutputConfig = (AutoValue_SessionConfig_OutputConfig) obj2;
                ((ImmutableHardwareBitmapService) this.f$0).getClass();
                Class cls = ((AutoValue_SessionConfig_OutputConfig) obj).surface.mContainerClass;
                int i = 1;
                int i2 = cls == MediaCodec.class ? 2 : cls == Preview.class ? 0 : 1;
                Class cls2 = autoValue_SessionConfig_OutputConfig.surface.mContainerClass;
                if (cls2 == MediaCodec.class) {
                    i = 2;
                } else if (cls2 == Preview.class) {
                    i = 0;
                }
                return i2 - i;
            case 2:
                return ((Number) ((Updater$$ExternalSyntheticLambda0) this.f$0).invoke(obj, obj2)).intValue();
            default:
                for (Function1 function1 : (Function1[]) this.f$0) {
                    int iCompareValues = ComparisonsKt__ComparisonsKt.compareValues((Comparable) function1.invoke(obj), (Comparable) function1.invoke(obj2));
                    if (iCompareValues != 0) {
                        return iCompareValues;
                    }
                }
                return 0;
        }
    }
}
