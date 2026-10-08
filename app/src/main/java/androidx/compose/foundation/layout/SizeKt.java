package androidx.compose.foundation.layout;

import androidx.compose.material3.TooltipKt;
import androidx.compose.runtime.Updater$$ExternalSyntheticLambda0;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class SizeKt {
    public static final WrapContentElement WrapContentHeightCenter;
    public static final WrapContentElement WrapContentHeightTop;
    public static final WrapContentElement WrapContentSizeCenter;
    public static final WrapContentElement WrapContentSizeTopStart;
    public static final WrapContentElement WrapContentWidthCenter;
    public static final WrapContentElement WrapContentWidthStart;
    public static final FillElement FillWholeMaxWidth = new FillElement(2, 1.0f);
    public static final FillElement FillWholeMaxHeight = new FillElement(1, 1.0f);
    public static final FillElement FillWholeMaxSize = new FillElement(3, 1.0f);

    static {
        BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
        int i = 4;
        WrapContentWidthCenter = new WrapContentElement(2, new Updater$$ExternalSyntheticLambda0(i, horizontal), horizontal);
        BiasAlignment.Horizontal horizontal2 = Alignment.Companion.Start;
        WrapContentWidthStart = new WrapContentElement(2, new Updater$$ExternalSyntheticLambda0(i, horizontal2), horizontal2);
        BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
        int i2 = 5;
        WrapContentHeightCenter = new WrapContentElement(1, new Updater$$ExternalSyntheticLambda0(i2, vertical), vertical);
        BiasAlignment.Vertical vertical2 = Alignment.Companion.Top;
        WrapContentHeightTop = new WrapContentElement(1, new Updater$$ExternalSyntheticLambda0(i2, vertical2), vertical2);
        BiasAlignment biasAlignment = Alignment.Companion.Center;
        int i3 = 6;
        WrapContentSizeCenter = new WrapContentElement(3, new Updater$$ExternalSyntheticLambda0(i3, biasAlignment), biasAlignment);
        BiasAlignment biasAlignment2 = Alignment.Companion.TopStart;
        WrapContentSizeTopStart = new WrapContentElement(3, new Updater$$ExternalSyntheticLambda0(i3, biasAlignment2), biasAlignment2);
    }

    /* JADX INFO: renamed from: defaultMinSize-VpY3zN4, reason: not valid java name */
    public static final Modifier m134defaultMinSizeVpY3zN4(Modifier modifier, float f, float f2) {
        return modifier.then(new UnspecifiedConstraintsElement(f, f2));
    }

    public static final Modifier fillMaxWidth(Modifier modifier, float f) {
        return modifier.then(f == 1.0f ? FillWholeMaxWidth : new FillElement(2, f));
    }

    /* JADX INFO: renamed from: height-3ABfNKs, reason: not valid java name */
    public static final Modifier m135height3ABfNKs(Modifier modifier, float f) {
        return modifier.then(new SizeElement(0.0f, f, 0.0f, f, 5));
    }

    /* JADX INFO: renamed from: requiredSize-3ABfNKs, reason: not valid java name */
    public static final Modifier m137requiredSize3ABfNKs(Modifier modifier, float f) {
        return modifier.then(new SizeElement(f, f, f, f, false));
    }

    /* JADX INFO: renamed from: requiredSize-VpY3zN4, reason: not valid java name */
    public static final Modifier m138requiredSizeVpY3zN4(Modifier modifier, float f, float f2) {
        return modifier.then(new SizeElement(f, f2, f, f2, false));
    }

    /* JADX INFO: renamed from: size-3ABfNKs, reason: not valid java name */
    public static final Modifier m140size3ABfNKs(Modifier modifier, float f) {
        return modifier.then(new SizeElement(f, f, f, f, true));
    }

    /* JADX INFO: renamed from: size-VpY3zN4, reason: not valid java name */
    public static final Modifier m141sizeVpY3zN4(Modifier modifier, float f, float f2) {
        return modifier.then(new SizeElement(f, f2, f, f2, true));
    }

    /* JADX INFO: renamed from: sizeIn-qDBjuR0, reason: not valid java name */
    public static final Modifier m142sizeInqDBjuR0(Modifier modifier, float f, float f2, float f3, float f4) {
        return modifier.then(new SizeElement(f, f2, f3, f4, true));
    }

    /* JADX INFO: renamed from: sizeIn-qDBjuR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m143sizeInqDBjuR0$default(Modifier modifier, float f, float f2, int i) {
        float f3 = TooltipKt.TooltipMinHeight;
        if ((i & 2) != 0) {
            f3 = Float.NaN;
        }
        return m142sizeInqDBjuR0(modifier, f, f3, f2, Float.NaN);
    }

    /* JADX INFO: renamed from: width-3ABfNKs, reason: not valid java name */
    public static final Modifier m144width3ABfNKs(Modifier modifier, float f) {
        return modifier.then(new SizeElement(f, 0.0f, f, 0.0f, 10));
    }

    public static Modifier wrapContentHeight$default(Modifier modifier) {
        WrapContentElement wrapContentElement;
        BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
        if (Intrinsics.areEqual(vertical, vertical)) {
            wrapContentElement = WrapContentHeightCenter;
        } else {
            wrapContentElement = Intrinsics.areEqual(vertical, Alignment.Companion.Top) ? WrapContentHeightTop : new WrapContentElement(1, new Updater$$ExternalSyntheticLambda0(5, vertical), vertical);
        }
        return modifier.then(wrapContentElement);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static Modifier wrapContentSize$default(Modifier modifier) {
        WrapContentElement wrapContentElement;
        BiasAlignment biasAlignment = Alignment.Companion.Center;
        if (biasAlignment.equals(biasAlignment)) {
            wrapContentElement = WrapContentSizeCenter;
        } else {
            wrapContentElement = biasAlignment.equals(Alignment.Companion.TopStart) ? WrapContentSizeTopStart : new WrapContentElement(3, new Updater$$ExternalSyntheticLambda0(6, biasAlignment), biasAlignment);
        }
        return modifier.then(wrapContentElement);
    }

    public static Modifier wrapContentWidth$default() {
        BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
        if (Intrinsics.areEqual(horizontal, horizontal)) {
            return WrapContentWidthCenter;
        }
        return Intrinsics.areEqual(horizontal, Alignment.Companion.Start) ? WrapContentWidthStart : new WrapContentElement(2, new Updater$$ExternalSyntheticLambda0(4, horizontal), horizontal);
    }
}
