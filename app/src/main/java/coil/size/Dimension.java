package coil.size;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class Dimension {

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Pixels extends Dimension {
        public final int px;

        public Pixels(int i) {
            this.px = i;
            if (i <= 0) {
                throw new IllegalArgumentException("px must be > 0.");
            }
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Pixels) {
                return this.px == ((Pixels) obj).px;
            }
            return false;
        }

        public final int hashCode() {
            return this.px;
        }

        public final String toString() {
            return String.valueOf(this.px);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Undefined extends Dimension {
        public static final Undefined INSTANCE = new Undefined();

        public final String toString() {
            return "Dimension.Undefined";
        }
    }
}
