package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsNodeKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class TouchBoundsExpansion {
    public static final /* synthetic */ int $r8$clinit = 0;
    public static final long None = Companion.pack$ui(0, 0, 0, 0);

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Companion {
        public final /* synthetic */ int $r8$classId;

        public /* synthetic */ Companion(int i) {
            this.$r8$classId = i;
        }

        public static final int access$unpack(int i, long j) {
            int i2 = TouchBoundsExpansion.$r8$clinit;
            return ((int) (j >> (i * 15))) & 32767;
        }

        public static long pack$ui(int i, int i2, int i3, int i4) {
            return (((long) (i2 & 32767)) << 15) | ((long) (i & 32767)) | (((long) (i3 & 32767)) << 30) | (((long) (i4 & 32767)) << 45) | Long.MIN_VALUE;
        }

        /* JADX INFO: renamed from: entityType-OLwlOKw, reason: not valid java name */
        public int m582entityTypeOLwlOKw() {
            switch (this.$r8$classId) {
                case 1:
                    return 16;
                default:
                    return 8;
            }
        }

        public boolean shouldHitTest(Modifier.Node node) {
            switch (this.$r8$classId) {
                case 1:
                    return true;
                default:
                    return SemanticsNodeKt.isImportantForAccessibility(SemanticsNodeKt.SemanticsNode(HitTestResultKt.requireLayoutNode(node), false));
            }
        }
    }
}
