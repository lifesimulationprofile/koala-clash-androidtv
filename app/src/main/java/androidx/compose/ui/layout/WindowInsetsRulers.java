package androidx.compose.ui.layout;

import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public interface WindowInsetsRulers {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final WindowInsetsRulersImpl CaptionBar;
        public static final WindowInsetsRulersImpl DisplayCutout;
        public static final WindowInsetsRulersImpl Ime;
        public static final WindowInsetsRulersImpl MandatorySystemGestures;
        public static final WindowInsetsRulersImpl NavigationBars;
        public static final WindowInsetsRulersImpl StatusBars;
        public static final WindowInsetsRulersImpl SystemGestures;
        public static final WindowInsetsRulersImpl TappableElement;
        public static final WindowInsetsRulersImpl Waterfall;

        static {
            WindowInsetsRulersImpl windowInsetsRulersImpl = new WindowInsetsRulersImpl("caption bar");
            CaptionBar = windowInsetsRulersImpl;
            WindowInsetsRulersImpl windowInsetsRulersImpl2 = new WindowInsetsRulersImpl("display cutout");
            DisplayCutout = windowInsetsRulersImpl2;
            WindowInsetsRulersImpl windowInsetsRulersImpl3 = new WindowInsetsRulersImpl("ime");
            Ime = windowInsetsRulersImpl3;
            WindowInsetsRulersImpl windowInsetsRulersImpl4 = new WindowInsetsRulersImpl("mandatory system gestures");
            MandatorySystemGestures = windowInsetsRulersImpl4;
            WindowInsetsRulersImpl windowInsetsRulersImpl5 = new WindowInsetsRulersImpl("navigation bars");
            NavigationBars = windowInsetsRulersImpl5;
            WindowInsetsRulersImpl windowInsetsRulersImpl6 = new WindowInsetsRulersImpl("status bars");
            StatusBars = windowInsetsRulersImpl6;
            char c = 2;
            WindowInsetsRulers[] windowInsetsRulersArr = {windowInsetsRulersImpl6, windowInsetsRulersImpl5, windowInsetsRulersImpl};
            ArrayList arrayList = new ArrayList(3);
            for (int i = 0; i < 3; i++) {
                arrayList.add(((WindowInsetsRulersImpl) windowInsetsRulersArr[i]).current);
            }
            RectRulersImpl[] rectRulersImplArr = (RectRulersImpl[]) arrayList.toArray(new RectRulersImpl[0]);
            new RectRulersImpl((RectRulersImpl[]) Arrays.copyOf(rectRulersImplArr, rectRulersImplArr.length));
            ArrayList arrayList2 = new ArrayList(3);
            for (int i2 = 0; i2 < 3; i2++) {
                arrayList2.add(((WindowInsetsRulersImpl) windowInsetsRulersArr[i2]).maximum);
            }
            RectRulersImpl[] rectRulersImplArr2 = (RectRulersImpl[]) arrayList2.toArray(new RectRulersImpl[0]);
            new RectRulersImpl((RectRulersImpl[]) Arrays.copyOf(rectRulersImplArr2, rectRulersImplArr2.length));
            WindowInsetsRulersImpl windowInsetsRulersImpl7 = new WindowInsetsRulersImpl("system gestures");
            SystemGestures = windowInsetsRulersImpl7;
            WindowInsetsRulersImpl windowInsetsRulersImpl8 = new WindowInsetsRulersImpl("tappable element");
            TappableElement = windowInsetsRulersImpl8;
            WindowInsetsRulersImpl windowInsetsRulersImpl9 = new WindowInsetsRulersImpl("waterfall");
            Waterfall = windowInsetsRulersImpl9;
            WindowInsetsRulers[] windowInsetsRulersArr2 = {windowInsetsRulersImpl6, windowInsetsRulersImpl5, windowInsetsRulersImpl, windowInsetsRulersImpl2, windowInsetsRulersImpl3, windowInsetsRulersImpl8};
            ArrayList arrayList3 = new ArrayList(6);
            int i3 = 0;
            while (i3 < 6) {
                arrayList3.add(((WindowInsetsRulersImpl) windowInsetsRulersArr2[i3]).current);
                i3++;
                c = c;
            }
            char c2 = c;
            RectRulersImpl[] rectRulersImplArr3 = (RectRulersImpl[]) arrayList3.toArray(new RectRulersImpl[0]);
            new RectRulersImpl((RectRulersImpl[]) Arrays.copyOf(rectRulersImplArr3, rectRulersImplArr3.length));
            ArrayList arrayList4 = new ArrayList(6);
            for (int i4 = 0; i4 < 6; i4++) {
                arrayList4.add(((WindowInsetsRulersImpl) windowInsetsRulersArr2[i4]).maximum);
            }
            RectRulersImpl[] rectRulersImplArr4 = (RectRulersImpl[]) arrayList4.toArray(new RectRulersImpl[0]);
            new RectRulersImpl((RectRulersImpl[]) Arrays.copyOf(rectRulersImplArr4, rectRulersImplArr4.length));
            WindowInsetsRulers[] windowInsetsRulersArr3 = new WindowInsetsRulers[4];
            windowInsetsRulersArr3[0] = windowInsetsRulersImpl4;
            windowInsetsRulersArr3[1] = windowInsetsRulersImpl7;
            windowInsetsRulersArr3[c2] = windowInsetsRulersImpl8;
            windowInsetsRulersArr3[3] = windowInsetsRulersImpl9;
            ArrayList arrayList5 = new ArrayList(4);
            for (int i5 = 0; i5 < 4; i5++) {
                arrayList5.add(((WindowInsetsRulersImpl) windowInsetsRulersArr3[i5]).current);
            }
            RectRulersImpl[] rectRulersImplArr5 = (RectRulersImpl[]) arrayList5.toArray(new RectRulersImpl[0]);
            new RectRulersImpl((RectRulersImpl[]) Arrays.copyOf(rectRulersImplArr5, rectRulersImplArr5.length));
            ArrayList arrayList6 = new ArrayList(4);
            for (int i6 = 0; i6 < 4; i6++) {
                arrayList6.add(((WindowInsetsRulersImpl) windowInsetsRulersArr3[i6]).maximum);
            }
            RectRulersImpl[] rectRulersImplArr6 = (RectRulersImpl[]) arrayList6.toArray(new RectRulersImpl[0]);
            new RectRulersImpl((RectRulersImpl[]) Arrays.copyOf(rectRulersImplArr6, rectRulersImplArr6.length));
            WindowInsetsRulers[] windowInsetsRulersArr4 = new WindowInsetsRulers[9];
            windowInsetsRulersArr4[0] = windowInsetsRulersImpl6;
            windowInsetsRulersArr4[1] = windowInsetsRulersImpl5;
            windowInsetsRulersArr4[c2] = windowInsetsRulersImpl;
            windowInsetsRulersArr4[3] = windowInsetsRulersImpl3;
            windowInsetsRulersArr4[4] = windowInsetsRulersImpl7;
            windowInsetsRulersArr4[5] = windowInsetsRulersImpl4;
            windowInsetsRulersArr4[6] = windowInsetsRulersImpl8;
            windowInsetsRulersArr4[7] = windowInsetsRulersImpl2;
            windowInsetsRulersArr4[8] = windowInsetsRulersImpl9;
            ArrayList arrayList7 = new ArrayList(9);
            for (int i7 = 0; i7 < 9; i7++) {
                arrayList7.add(((WindowInsetsRulersImpl) windowInsetsRulersArr4[i7]).current);
            }
            RectRulersImpl[] rectRulersImplArr7 = (RectRulersImpl[]) arrayList7.toArray(new RectRulersImpl[0]);
            new RectRulersImpl((RectRulersImpl[]) Arrays.copyOf(rectRulersImplArr7, rectRulersImplArr7.length));
            ArrayList arrayList8 = new ArrayList(9);
            for (int i8 = 0; i8 < 9; i8++) {
                arrayList8.add(((WindowInsetsRulersImpl) windowInsetsRulersArr4[i8]).maximum);
            }
            RectRulersImpl[] rectRulersImplArr8 = (RectRulersImpl[]) arrayList8.toArray(new RectRulersImpl[0]);
            new RectRulersImpl((RectRulersImpl[]) Arrays.copyOf(rectRulersImplArr8, rectRulersImplArr8.length));
        }
    }
}
