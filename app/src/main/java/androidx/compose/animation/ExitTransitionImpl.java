package androidx.compose.animation;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ExitTransitionImpl {
    public static final ExitTransitionImpl KeepUntilTransitionsFinished;
    public static final ExitTransitionImpl None;
    public final TransitionData data;

    static {
        LinkedHashMap linkedHashMap = null;
        Fade fade = null;
        Slide slide = null;
        ChangeSize changeSize = null;
        Scale scale = null;
        None = new ExitTransitionImpl(new TransitionData(fade, slide, changeSize, scale, linkedHashMap, 127));
        KeepUntilTransitionsFinished = new ExitTransitionImpl(new TransitionData(fade, slide, changeSize, scale, linkedHashMap, 95));
    }

    public ExitTransitionImpl(TransitionData transitionData) {
        this.data = transitionData;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ExitTransitionImpl) && Intrinsics.areEqual(((ExitTransitionImpl) obj).data, this.data);
    }

    public final int hashCode() {
        return this.data.hashCode();
    }

    public final ExitTransitionImpl plus(ExitTransitionImpl exitTransitionImpl) {
        TransitionData transitionData = exitTransitionImpl.data;
        Fade fade = transitionData.fade;
        TransitionData transitionData2 = this.data;
        if (fade == null) {
            fade = transitionData2.fade;
        }
        Slide slide = transitionData.slide;
        if (slide == null) {
            slide = transitionData2.slide;
        }
        ChangeSize changeSize = transitionData.changeSize;
        if (changeSize == null) {
            changeSize = transitionData2.changeSize;
        }
        boolean z = transitionData.hold || transitionData2.hold;
        Map map = transitionData2.effectsMap;
        Map map2 = transitionData.effectsMap;
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return new ExitTransitionImpl(new TransitionData(fade, slide, changeSize, (Scale) null, z, linkedHashMap));
    }

    public final String toString() {
        if (equals(None)) {
            return "ExitTransition.None";
        }
        if (equals(KeepUntilTransitionsFinished)) {
            return "ExitTransition.KeepUntilTransitionsFinished";
        }
        StringBuilder sb = new StringBuilder("ExitTransition: \nFade - ");
        TransitionData transitionData = this.data;
        Fade fade = transitionData.fade;
        sb.append(fade != null ? fade.toString() : null);
        sb.append(",\nSlide - ");
        Slide slide = transitionData.slide;
        sb.append(slide != null ? slide.toString() : null);
        sb.append(",\nShrink - ");
        ChangeSize changeSize = transitionData.changeSize;
        sb.append(changeSize != null ? changeSize.toString() : null);
        sb.append(",\nScale - ");
        sb.append((String) null);
        sb.append(",\nKeepUntilTransitionsFinished - ");
        sb.append(transitionData.hold);
        return sb.toString();
    }
}
