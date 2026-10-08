package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class SingleRowTopAppBarOverrideScope {
    public final Function3 actions;
    public final TopAppBarColors colors;
    public final PaddingValues contentPadding;
    public final float expandedHeight;
    public final Modifier modifier;
    public final Function2 navigationIcon;
    public final TextStyle subtitleTextStyle;
    public final ComposableLambdaImpl title;
    public final TextStyle titleTextStyle;
    public final WindowInsets windowInsets;

    public SingleRowTopAppBarOverrideScope(Modifier modifier, ComposableLambdaImpl composableLambdaImpl, TextStyle textStyle, TextStyle textStyle2, Function2 function2, Function3 function3, float f, PaddingValues paddingValues, WindowInsets windowInsets, TopAppBarColors topAppBarColors) {
        this.modifier = modifier;
        this.title = composableLambdaImpl;
        this.titleTextStyle = textStyle;
        this.subtitleTextStyle = textStyle2;
        this.navigationIcon = function2;
        this.actions = function3;
        this.expandedHeight = f;
        this.contentPadding = paddingValues;
        this.windowInsets = windowInsets;
        this.colors = topAppBarColors;
    }
}
