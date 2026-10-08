package androidx.compose.material3;

import androidx.compose.animation.core.ArcSplineKt;
import androidx.compose.animation.core.SpringSpec;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public interface MotionScheme {

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class ExpressiveMotionSchemeImpl implements MotionScheme {
        public static final ExpressiveMotionSchemeImpl INSTANCE = new ExpressiveMotionSchemeImpl();
        public static final SpringSpec defaultSpatialSpec = ArcSplineKt.spring$default(0.8f, 380.0f, null, 4);
        public static final SpringSpec fastSpatialSpec = ArcSplineKt.spring$default(0.6f, 800.0f, null, 4);
        public static final SpringSpec slowSpatialSpec = ArcSplineKt.spring$default(0.8f, 200.0f, null, 4);
        public static final SpringSpec defaultEffectsSpec = ArcSplineKt.spring$default(1.0f, 1600.0f, null, 4);
        public static final SpringSpec fastEffectsSpec = ArcSplineKt.spring$default(1.0f, 3800.0f, null, 4);
        public static final SpringSpec slowEffectsSpec = ArcSplineKt.spring$default(1.0f, 800.0f, null, 4);

        @Override // androidx.compose.material3.MotionScheme
        public final SpringSpec defaultEffectsSpec() {
            return defaultEffectsSpec;
        }

        @Override // androidx.compose.material3.MotionScheme
        public final SpringSpec defaultSpatialSpec() {
            return defaultSpatialSpec;
        }

        @Override // androidx.compose.material3.MotionScheme
        public final SpringSpec fastEffectsSpec() {
            return fastEffectsSpec;
        }

        @Override // androidx.compose.material3.MotionScheme
        public final SpringSpec fastSpatialSpec() {
            return fastSpatialSpec;
        }

        @Override // androidx.compose.material3.MotionScheme
        public final SpringSpec slowEffectsSpec() {
            return slowEffectsSpec;
        }

        @Override // androidx.compose.material3.MotionScheme
        public final SpringSpec slowSpatialSpec() {
            return slowSpatialSpec;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class StandardMotionSchemeImpl implements MotionScheme {
        public static final StandardMotionSchemeImpl INSTANCE = new StandardMotionSchemeImpl();
        public static final SpringSpec defaultSpatialSpec = ArcSplineKt.spring$default(0.9f, 700.0f, null, 4);
        public static final SpringSpec fastSpatialSpec = ArcSplineKt.spring$default(0.9f, 1400.0f, null, 4);
        public static final SpringSpec slowSpatialSpec = ArcSplineKt.spring$default(0.9f, 300.0f, null, 4);
        public static final SpringSpec defaultEffectsSpec = ArcSplineKt.spring$default(1.0f, 1600.0f, null, 4);
        public static final SpringSpec fastEffectsSpec = ArcSplineKt.spring$default(1.0f, 3800.0f, null, 4);
        public static final SpringSpec slowEffectsSpec = ArcSplineKt.spring$default(1.0f, 800.0f, null, 4);

        @Override // androidx.compose.material3.MotionScheme
        public final SpringSpec defaultEffectsSpec() {
            return defaultEffectsSpec;
        }

        @Override // androidx.compose.material3.MotionScheme
        public final SpringSpec defaultSpatialSpec() {
            return defaultSpatialSpec;
        }

        @Override // androidx.compose.material3.MotionScheme
        public final SpringSpec fastEffectsSpec() {
            return fastEffectsSpec;
        }

        @Override // androidx.compose.material3.MotionScheme
        public final SpringSpec fastSpatialSpec() {
            return fastSpatialSpec;
        }

        @Override // androidx.compose.material3.MotionScheme
        public final SpringSpec slowEffectsSpec() {
            return slowEffectsSpec;
        }

        @Override // androidx.compose.material3.MotionScheme
        public final SpringSpec slowSpatialSpec() {
            return slowSpatialSpec;
        }
    }

    SpringSpec defaultEffectsSpec();

    SpringSpec defaultSpatialSpec();

    SpringSpec fastEffectsSpec();

    SpringSpec fastSpatialSpec();

    SpringSpec slowEffectsSpec();

    SpringSpec slowSpatialSpec();
}
