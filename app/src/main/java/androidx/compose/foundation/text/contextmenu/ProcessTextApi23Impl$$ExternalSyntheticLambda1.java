package androidx.compose.foundation.text.contextmenu;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.foundation.text.contextmenu.internal.DefaultTextContextMenuDropdownProvider_androidKt;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuDataProvider;
import androidx.compose.runtime.GapComposer;
import androidx.compose.ui.text.TextRange;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function5;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ProcessTextApi23Impl$$ExternalSyntheticLambda1 implements Function5 {
    public final /* synthetic */ int $r8$classId;

    @Override // kotlin.jvm.functions.Function5
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        int i;
        int i2;
        switch (this.$r8$classId) {
            case 0:
                boolean zBooleanValue = ((Boolean) obj3).booleanValue();
                long j = ((TextRange) obj5).packedValue;
                String string = ((CharSequence) obj4).subSequence(TextRange.m644getMinimpl(j), TextRange.m643getMaximpl(j)).toString();
                Intent intentPutExtra = new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain").putExtra("android.intent.extra.PROCESS_TEXT_READONLY", zBooleanValue);
                ActivityInfo activityInfo = ((ResolveInfo) obj2).activityInfo;
                Intent className = intentPutExtra.setClassName(activityInfo.packageName, activityInfo.name);
                className.putExtra("android.intent.extra.PROCESS_TEXT", string);
                ((Context) obj).startActivity(className);
                break;
            case 1:
                TextContextMenuSession textContextMenuSession = (TextContextMenuSession) obj;
                TextContextMenuDataProvider textContextMenuDataProvider = (TextContextMenuDataProvider) obj2;
                Function0 function0 = (Function0) obj3;
                GapComposer gapComposer = (GapComposer) obj4;
                int iIntValue = ((Integer) obj5).intValue();
                if ((iIntValue & 6) == 0) {
                    i = ((iIntValue & 8) == 0 ? gapComposer.changed(textContextMenuSession) : gapComposer.changedInstance(textContextMenuSession) ? 4 : 2) | iIntValue;
                } else {
                    i = iIntValue;
                }
                if ((iIntValue & 48) == 0) {
                    i |= (iIntValue & 64) == 0 ? gapComposer.changed(textContextMenuDataProvider) : gapComposer.changedInstance(textContextMenuDataProvider) ? 32 : 16;
                }
                if ((iIntValue & 384) == 0) {
                    i |= gapComposer.changedInstance(function0) ? 256 : 128;
                }
                if (gapComposer.shouldExecute(i & 1, (i & 1171) != 1170)) {
                    DefaultTextContextMenuDropdownProvider_androidKt.OpenContextMenu(textContextMenuSession, textContextMenuDataProvider, function0, gapComposer, i & 1022);
                } else {
                    gapComposer.skipToGroupEnd();
                }
                break;
            default:
                TextContextMenuSession textContextMenuSession2 = (TextContextMenuSession) obj;
                TextContextMenuDataProvider textContextMenuDataProvider2 = (TextContextMenuDataProvider) obj2;
                Function0 function1 = (Function0) obj3;
                GapComposer gapComposer2 = (GapComposer) obj4;
                int iIntValue2 = ((Integer) obj5).intValue();
                if ((iIntValue2 & 6) == 0) {
                    i2 = ((iIntValue2 & 8) == 0 ? gapComposer2.changed(textContextMenuSession2) : gapComposer2.changedInstance(textContextMenuSession2) ? 4 : 2) | iIntValue2;
                } else {
                    i2 = iIntValue2;
                }
                if ((iIntValue2 & 48) == 0) {
                    i2 |= (iIntValue2 & 64) == 0 ? gapComposer2.changed(textContextMenuDataProvider2) : gapComposer2.changedInstance(textContextMenuDataProvider2) ? 32 : 16;
                }
                if ((iIntValue2 & 384) == 0) {
                    i2 |= gapComposer2.changedInstance(function1) ? 256 : 128;
                }
                if (gapComposer2.shouldExecute(i2 & 1, (i2 & 1171) != 1170)) {
                    DefaultTextContextMenuDropdownProvider_androidKt.OpenContextMenu(textContextMenuSession2, textContextMenuDataProvider2, function1, gapComposer2, i2 & 1022);
                } else {
                    gapComposer2.skipToGroupEnd();
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
