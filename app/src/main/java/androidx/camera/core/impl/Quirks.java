package androidx.camera.core.impl;

import androidx.compose.ui.graphics.vector.PathNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Quirks {
    public final ArrayList mQuirks;

    public Quirks() {
        this.mQuirks = new ArrayList(32);
    }

    public static String toString(Quirks quirks) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = quirks.mQuirks;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            arrayList.add(((Quirk) obj).getClass().getSimpleName());
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            while (true) {
                sb.append((CharSequence) it.next());
                if (!it.hasNext()) {
                    break;
                }
                sb.append((CharSequence) " | ");
            }
        }
        return sb.toString();
    }

    public void arcToRelative(float f, float f2, float f3, float f4, boolean z) {
        this.mQuirks.add(new PathNode.RelativeArcTo(f, f2, 0.0f, false, z, f3, f4));
    }

    public void close() {
        this.mQuirks.add(PathNode.Close.INSTANCE);
    }

    public boolean contains(Class cls) {
        ArrayList arrayList = this.mQuirks;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            if (cls.isAssignableFrom(((Quirk) obj).getClass())) {
                return true;
            }
        }
        return false;
    }

    public void curveTo(float f, float f2, float f3, float f4, float f5, float f6) {
        this.mQuirks.add(new PathNode.CurveTo(f, f2, f3, f4, f5, f6));
    }

    public void curveToRelative(float f, float f2, float f3, float f4, float f5, float f6) {
        this.mQuirks.add(new PathNode.RelativeCurveTo(f, f2, f3, f4, f5, f6));
    }

    public Quirk get(Class cls) {
        ArrayList arrayList = this.mQuirks;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            Quirk quirk = (Quirk) obj;
            if (quirk.getClass() == cls) {
                return quirk;
            }
        }
        return null;
    }

    public void horizontalLineTo(float f) {
        this.mQuirks.add(new PathNode.HorizontalTo(f));
    }

    public void horizontalLineToRelative(float f) {
        this.mQuirks.add(new PathNode.RelativeHorizontalTo(f));
    }

    public void lineTo(float f, float f2) {
        this.mQuirks.add(new PathNode.LineTo(f, f2));
    }

    public void lineToRelative(float f, float f2) {
        this.mQuirks.add(new PathNode.RelativeLineTo(f, f2));
    }

    public void moveTo(float f, float f2) {
        this.mQuirks.add(new PathNode.MoveTo(f, f2));
    }

    public void reflectiveCurveTo(float f, float f2, float f3, float f4) {
        this.mQuirks.add(new PathNode.ReflectiveCurveTo(f, f2, f3, f4));
    }

    public void reflectiveCurveToRelative(float f, float f2, float f3, float f4) {
        this.mQuirks.add(new PathNode.RelativeReflectiveCurveTo(f, f2, f3, f4));
    }

    public void verticalLineTo(float f) {
        this.mQuirks.add(new PathNode.VerticalTo(f));
    }

    public void verticalLineToRelative(float f) {
        this.mQuirks.add(new PathNode.RelativeVerticalTo(f));
    }

    public Quirks(List list) {
        this.mQuirks = new ArrayList(list);
    }
}
