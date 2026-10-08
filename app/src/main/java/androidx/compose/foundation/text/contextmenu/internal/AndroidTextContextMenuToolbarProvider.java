package androidx.compose.foundation.text.contextmenu.internal;

import android.R;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.app.RemoteAction;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.textclassifier.TextClassification;
import androidx.camera.core.impl.LiveDataObservable$$ExternalSyntheticLambda1;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$2;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuComponent;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuData;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuItem;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuKeys;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSeparator;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuTextClassificationItem;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProvider;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.autofill.AndroidAutofill$$ExternalSyntheticApiModelOutline0;
import coil.intercept.EngineInterceptor;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidTextContextMenuToolbarProvider implements TextContextMenuProvider {
    public ActionMode actionMode;
    public final Function1 callbackInjector;
    public final Function0 coordinatesProvider;
    public Runnable finishActionModeRunnable;
    public LiveDataObservable$$ExternalSyntheticLambda1 startActionModeRunnable;
    public final View view;
    public final MutatorMutex mutatorMutex = new MutatorMutex();
    public final SnapshotStateObserver snapshotStateObserver = new SnapshotStateObserver(new AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda0(this, 0));
    public final AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda0 onDataChange = new AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda0(this, 1);
    public final AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda0 onPositionChange = new AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda0(this, 2);

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class TextActionModeCallbackImpl {
        public final AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda3 dataBuilder;
        public final AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda3 positioner;
        public final TextContextMenuSessionImpl session;
        public final View view;

        public TextActionModeCallbackImpl(TextContextMenuSessionImpl textContextMenuSessionImpl, AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda3 androidTextContextMenuToolbarProvider$$ExternalSyntheticLambda3, AndroidTextContextMenuToolbarProvider$$ExternalSyntheticLambda3 androidTextContextMenuToolbarProvider$$ExternalSyntheticLambda4, View view) {
            this.session = textContextMenuSessionImpl;
            this.dataBuilder = androidTextContextMenuToolbarProvider$$ExternalSyntheticLambda3;
            this.positioner = androidTextContextMenuToolbarProvider$$ExternalSyntheticLambda4;
            this.view = view;
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, java.util.Collection, java.util.List] */
        public final boolean updateMenuItems(Menu menu) {
            int i;
            int i2;
            TextContextMenuData textContextMenuData = (TextContextMenuData) this.dataBuilder.invoke();
            int i3 = 0;
            if (Intrinsics.areEqual(textContextMenuData, null)) {
                return false;
            }
            menu.clear();
            ?? r2 = textContextMenuData.components;
            int size = r2.size();
            int i4 = 0;
            int i5 = 1;
            int i6 = 1;
            while (i4 < size) {
                TextContextMenuComponent textContextMenuComponent = (TextContextMenuComponent) r2.get(i4);
                if (textContextMenuComponent instanceof TextContextMenuItem) {
                    i = i5 + 1;
                    Object obj = textContextMenuComponent.key;
                    if (Intrinsics.areEqual(obj, TextContextMenuKeys.CutKey)) {
                        i2 = R.id.cut;
                    } else if (Intrinsics.areEqual(obj, TextContextMenuKeys.CopyKey)) {
                        i2 = R.id.copy;
                    } else if (Intrinsics.areEqual(obj, TextContextMenuKeys.PasteKey)) {
                        i2 = R.id.paste;
                    } else if (Intrinsics.areEqual(obj, TextContextMenuKeys.SelectAllKey)) {
                        i2 = R.id.selectAll;
                    } else {
                        i2 = Intrinsics.areEqual(obj, TextContextMenuKeys.AutofillKey) ? R.id.autofill : i5;
                    }
                    final TextContextMenuItem textContextMenuItem = (TextContextMenuItem) textContextMenuComponent;
                    MenuItem menuItemAdd = menu.add(i6, i2, i5, textContextMenuItem.label);
                    menuItemAdd.setShowAsAction(2);
                    final int i7 = 1;
                    menuItemAdd.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: androidx.compose.foundation.text.contextmenu.internal.TextToolbarHelperApi28$$ExternalSyntheticLambda0
                        @Override // android.view.MenuItem.OnMenuItemClickListener
                        public final boolean onMenuItemClick(MenuItem menuItem) throws PendingIntent.CanceledException {
                            switch (i7) {
                                case 0:
                                    Context context = (Context) textContextMenuItem;
                                    TextClassification textClassification = (TextClassification) this;
                                    String text = textClassification.getText();
                                    PendingIntent activity = PendingIntent.getActivity(context, text != null ? text.hashCode() : 0, textClassification.getIntent(), 201326592);
                                    if (Build.VERSION.SDK_INT < 34) {
                                        activity.send();
                                    } else {
                                        try {
                                            activity.send(ActivityOptions.makeBasic().setPendingIntentBackgroundActivityStartMode(1).toBundle());
                                        } catch (PendingIntent.CanceledException e) {
                                            Log.e("TextClassification", "error sending pendingIntent: " + activity + " error: " + e);
                                            return true;
                                        }
                                    }
                                    break;
                                default:
                                    ((TextContextMenuItem) textContextMenuItem).onClick.invoke(((AndroidTextContextMenuToolbarProvider.TextActionModeCallbackImpl) this).session);
                                    break;
                            }
                            return true;
                        }
                    });
                } else {
                    if (textContextMenuComponent instanceof TextContextMenuTextClassificationItem) {
                        if (Build.VERSION.SDK_INT >= 28) {
                            i = i5 + 1;
                            final Context context = this.view.getContext();
                            TextContextMenuTextClassificationItem textContextMenuTextClassificationItem = (TextContextMenuTextClassificationItem) textContextMenuComponent;
                            final TextClassification textClassification = textContextMenuTextClassificationItem.textClassification;
                            int i8 = textContextMenuTextClassificationItem.index;
                            if (i8 < 0) {
                                MenuItem menuItemAdd2 = menu.add(R.id.textAssist, R.id.textAssist, i5, textClassification.getLabel());
                                menuItemAdd2.setShowAsAction(2);
                                menuItemAdd2.setIcon(textClassification.getIcon());
                                final int i9 = 0;
                                menuItemAdd2.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: androidx.compose.foundation.text.contextmenu.internal.TextToolbarHelperApi28$$ExternalSyntheticLambda0
                                    @Override // android.view.MenuItem.OnMenuItemClickListener
                                    public final boolean onMenuItemClick(MenuItem menuItem) throws PendingIntent.CanceledException {
                                        switch (i9) {
                                            case 0:
                                                Context context2 = (Context) context;
                                                TextClassification textClassification2 = (TextClassification) textClassification;
                                                String text = textClassification2.getText();
                                                PendingIntent activity = PendingIntent.getActivity(context2, text != null ? text.hashCode() : 0, textClassification2.getIntent(), 201326592);
                                                if (Build.VERSION.SDK_INT < 34) {
                                                    activity.send();
                                                } else {
                                                    try {
                                                        activity.send(ActivityOptions.makeBasic().setPendingIntentBackgroundActivityStartMode(1).toBundle());
                                                    } catch (PendingIntent.CanceledException e) {
                                                        Log.e("TextClassification", "error sending pendingIntent: " + activity + " error: " + e);
                                                        return true;
                                                    }
                                                }
                                                break;
                                            default:
                                                ((TextContextMenuItem) context).onClick.invoke(((AndroidTextContextMenuToolbarProvider.TextActionModeCallbackImpl) textClassification).session);
                                                break;
                                        }
                                        return true;
                                    }
                                });
                            } else {
                                int i10 = i8 == 0 ? 1 : i3;
                                final RemoteAction remoteActionM = AndroidAutofill$$ExternalSyntheticApiModelOutline0.m(textClassification.getActions().get(i8));
                                MenuItem menuItemAdd3 = menu.add(R.id.textAssist, i10 != 0 ? 16908353 : i3, i5, remoteActionM.getTitle());
                                menuItemAdd3.setShowAsAction(i10 == 0 ? 0 : 2);
                                if (i10 != 0 || remoteActionM.shouldShowIcon()) {
                                    menuItemAdd3.setIcon(remoteActionM.getIcon().loadDrawable(context));
                                }
                                menuItemAdd3.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: androidx.compose.foundation.text.contextmenu.internal.TextToolbarHelperApi28$$ExternalSyntheticLambda1
                                    @Override // android.view.MenuItem.OnMenuItemClickListener
                                    public final boolean onMenuItemClick(MenuItem menuItem) throws PendingIntent.CanceledException {
                                        PendingIntent actionIntent = remoteActionM.getActionIntent();
                                        if (Build.VERSION.SDK_INT < 34) {
                                            actionIntent.send();
                                            return true;
                                        }
                                        try {
                                            actionIntent.send(ActivityOptions.makeBasic().setPendingIntentBackgroundActivityStartMode(1).toBundle());
                                        } catch (PendingIntent.CanceledException e) {
                                            Log.e("TextClassification", "error sending pendingIntent: " + actionIntent + " error: " + e);
                                        }
                                        return true;
                                    }
                                });
                            }
                        }
                    } else if (textContextMenuComponent instanceof TextContextMenuSeparator) {
                        i6++;
                    }
                    i4++;
                    i3 = 0;
                }
                i5 = i;
                i4++;
                i3 = 0;
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class TextContextMenuSessionImpl implements TextContextMenuSession {
        public final BufferedChannel channel = ChannelKt.Channel$default(0, 0, 7);

        @Override // androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession
        public final void close() {
            this.channel.mo842trySendJP2dKIU(Unit.INSTANCE);
        }
    }

    public AndroidTextContextMenuToolbarProvider(View view, Function1 function1, Function0 function0) {
        this.view = view;
        this.callbackInjector = function1;
        this.coordinatesProvider = function0;
    }

    @Override // androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProvider
    public final Object showTextContextMenu(TextContextMenuDataProvider textContextMenuDataProvider, SuspendLambda suspendLambda) {
        AnchoredDraggableState$anchoredDrag$2 anchoredDraggableState$anchoredDrag$2 = new AnchoredDraggableState$anchoredDrag$2(this, textContextMenuDataProvider, null, 1);
        MutatorMutex mutatorMutex = this.mutatorMutex;
        mutatorMutex.getClass();
        Object objCoroutineScope = JobKt.coroutineScope(new EngineInterceptor.AnonymousClass2(MutatePriority.Default, mutatorMutex, anchoredDraggableState$anchoredDrag$2, null), suspendLambda);
        return objCoroutineScope == CoroutineSingletons.COROUTINE_SUSPENDED ? objCoroutineScope : Unit.INSTANCE;
    }
}
