package androidx.navigation.compose;

import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.navigation.NavDestination;
import androidx.navigation.NavDestinationBuilder;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ComposeNavigatorDestinationBuilder extends NavDestinationBuilder {
    public final ComposeNavigator composeNavigator;
    public final ComposableLambdaImpl content;

    public ComposeNavigatorDestinationBuilder(ComposeNavigator composeNavigator, String str, ComposableLambdaImpl composableLambdaImpl) {
        super(composeNavigator, str);
        this.composeNavigator = composeNavigator;
        this.content = composableLambdaImpl;
    }

    @Override // androidx.navigation.NavDestinationBuilder
    public final NavDestination build() {
        return (ComposeNavigator.Destination) super.build();
    }

    @Override // androidx.navigation.NavDestinationBuilder
    public final NavDestination instantiateDestination() {
        return new ComposeNavigator.Destination(this.composeNavigator, this.content);
    }
}
