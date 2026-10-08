package androidx.navigation.compose;

import android.content.Context;
import androidx.navigation.NavHostController;
import androidx.navigation.NavigatorProvider;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class NavHostControllerKt {
    public static final NavHostController access$createNavController(Context context) {
        NavHostController navHostController = new NavHostController(context);
        NavigatorProvider navigatorProvider = navHostController._navigatorProvider;
        navigatorProvider.addNavigator(new ComposeNavGraphNavigator(navigatorProvider));
        navHostController._navigatorProvider.addNavigator(new ComposeNavigator());
        navHostController._navigatorProvider.addNavigator(new DialogNavigator());
        return navHostController;
    }
}
