package androidx.compose.foundation.text;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import androidx.compose.foundation.gestures.BringIntoViewSpec;
import androidx.compose.foundation.gestures.BringIntoViewSpec_androidKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.WindowInsetsHolder;
import androidx.compose.foundation.lazy.LazyListMeasureResult;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.text.selection.TextFieldPreparedSelection;
import androidx.compose.runtime.CompositionLocalAccessorScope;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.DeleteSurroundingTextCommand;
import androidx.emoji2.text.EmojiCompat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class BasicTextKt$$ExternalSyntheticLambda3 implements Function1 {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ BasicTextKt$$ExternalSyntheticLambda3(int i) {
        this.$r8$classId = i;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0065  */
    /* JADX WARN: Code duplicated, block: B:47:0x011e  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int iOffsetByCodePoints;
        String str;
        int i = 0;
        switch (this.$r8$classId) {
            case 0:
                Long l = (Long) obj;
                l.longValue();
                return l;
            case 1:
                if (((Context) ((CompositionLocalAccessorScope) obj).getCurrentValue(AndroidCompositionLocals_androidKt.LocalContext)).getPackageManager().hasSystemFeature("android.software.leanback")) {
                    return BringIntoViewSpec_androidKt.PivotBringIntoViewSpec;
                }
                BringIntoViewSpec.Companion.getClass();
                return BringIntoViewSpec.Companion.DefaultBringIntoViewSpec;
            case 2:
                return Unit.INSTANCE;
            case 3:
                ((Long) obj).longValue();
                return Unit.INSTANCE;
            case 4:
                PointerType pointerType = (PointerType) obj;
                if (pointerType != null && pointerType.value == 2) {
                    i = 1;
                }
                return Boolean.valueOf(i ^ 1);
            case 5:
                ((Float) obj).floatValue();
                return Unit.INSTANCE;
            case 6:
                return Unit.INSTANCE;
            case 7:
                return Unit.INSTANCE;
            case 8:
                return Unit.INSTANCE;
            case 9:
                return Unit.INSTANCE;
            case 10:
                return Unit.INSTANCE;
            case 11:
                return ((WindowInsetsHolder) obj).ime;
            case 12:
                return ((WindowInsetsHolder) obj).navigationBars;
            case 13:
                ((Integer) obj).getClass();
                return null;
            case 14:
                return Unit.INSTANCE;
            case 15:
                List list = (List) obj;
                return new LazyListState(((Number) list.get(0)).intValue(), ((Number) list.get(1)).intValue());
            case 16:
                return Unit.INSTANCE;
            case 17:
                return Unit.INSTANCE;
            case 18:
                return Unit.INSTANCE;
            case 19:
                return Unit.INSTANCE;
            case 20:
                return Unit.INSTANCE;
            case 21:
                TextFieldPreparedSelection textFieldPreparedSelection = (TextFieldPreparedSelection) obj;
                String str2 = textFieldPreparedSelection.annotatedString.text;
                long j = textFieldPreparedSelection.selection;
                int i2 = TextRange.$r8$clinit;
                int i3 = (int) (j & 4294967295L);
                if (i3 > 0) {
                    EmojiCompat emojiCompatIfLoaded = BasicTextKt.getEmojiCompatIfLoaded();
                    if (emojiCompatIfLoaded != null) {
                        int emojiStart = emojiCompatIfLoaded.getEmojiStart(str2, i3 - 1);
                        if (emojiStart >= 0) {
                            iOffsetByCodePoints = emojiStart;
                        } else if (i3 <= 0) {
                            iOffsetByCodePoints = -1;
                        } else {
                            iOffsetByCodePoints = Character.offsetByCodePoints(str2, i3, -1);
                        }
                    } else if (i3 <= 0) {
                        iOffsetByCodePoints = -1;
                    } else {
                        iOffsetByCodePoints = Character.offsetByCodePoints(str2, i3, -1);
                    }
                } else {
                    iOffsetByCodePoints = -1;
                }
                if (iOffsetByCodePoints == -1) {
                    return null;
                }
                return new DeleteSurroundingTextCommand(((int) (textFieldPreparedSelection.selection & 4294967295L)) - iOffsetByCodePoints, 0);
            case 22:
                TextFieldPreparedSelection textFieldPreparedSelection2 = (TextFieldPreparedSelection) obj;
                String str3 = textFieldPreparedSelection2.annotatedString.text;
                long j2 = textFieldPreparedSelection2.selection;
                int i4 = TextRange.$r8$clinit;
                int iFindFollowingBreak = BasicTextKt.findFollowingBreak(str3, (int) (j2 & 4294967295L));
                if (iFindFollowingBreak != -1) {
                    return new DeleteSurroundingTextCommand(0, iFindFollowingBreak - ((int) (textFieldPreparedSelection2.selection & 4294967295L)));
                }
                return null;
            case 23:
                TextFieldPreparedSelection textFieldPreparedSelection3 = (TextFieldPreparedSelection) obj;
                Integer previousWordOffset = textFieldPreparedSelection3.getPreviousWordOffset();
                if (previousWordOffset == null) {
                    return null;
                }
                int iIntValue = previousWordOffset.intValue();
                long j3 = textFieldPreparedSelection3.selection;
                int i5 = TextRange.$r8$clinit;
                return new DeleteSurroundingTextCommand(((int) (j3 & 4294967295L)) - iIntValue, 0);
            case 24:
                TextFieldPreparedSelection textFieldPreparedSelection4 = (TextFieldPreparedSelection) obj;
                Integer nextWordOffset = textFieldPreparedSelection4.getNextWordOffset();
                if (nextWordOffset == null) {
                    return null;
                }
                int iIntValue2 = nextWordOffset.intValue();
                long j4 = textFieldPreparedSelection4.selection;
                int i6 = TextRange.$r8$clinit;
                return new DeleteSurroundingTextCommand(0, iIntValue2 - ((int) (j4 & 4294967295L)));
            case 25:
                TextFieldPreparedSelection textFieldPreparedSelection5 = (TextFieldPreparedSelection) obj;
                Integer lineStartByOffset = textFieldPreparedSelection5.getLineStartByOffset();
                if (lineStartByOffset == null) {
                    return null;
                }
                int iIntValue3 = lineStartByOffset.intValue();
                long j5 = textFieldPreparedSelection5.selection;
                int i7 = TextRange.$r8$clinit;
                return new DeleteSurroundingTextCommand(((int) (j5 & 4294967295L)) - iIntValue3, 0);
            case 26:
                TextFieldPreparedSelection textFieldPreparedSelection6 = (TextFieldPreparedSelection) obj;
                Integer lineEndByOffset = textFieldPreparedSelection6.getLineEndByOffset();
                if (lineEndByOffset == null) {
                    return null;
                }
                int iIntValue4 = lineEndByOffset.intValue();
                long j6 = textFieldPreparedSelection6.selection;
                int i8 = TextRange.$r8$clinit;
                return new DeleteSurroundingTextCommand(0, iIntValue4 - ((int) (j6 & 4294967295L)));
            case 27:
                List list2 = (List) obj;
                return new TextFieldScrollerPosition(((Boolean) list2.get(1)).booleanValue() ? Orientation.Vertical : Orientation.Horizontal, ((Float) list2.get(0)).floatValue());
            case 28:
                Context context = (Context) obj;
                List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain"), 0);
                ArrayList arrayList = new ArrayList(listQueryIntentActivities.size());
                int size = listQueryIntentActivities.size();
                while (i < size) {
                    ResolveInfo resolveInfo = listQueryIntentActivities.get(i);
                    ResolveInfo resolveInfo2 = resolveInfo;
                    if (context.getPackageName().equals(resolveInfo2.activityInfo.packageName)) {
                        arrayList.add(resolveInfo);
                    } else {
                        ActivityInfo activityInfo = resolveInfo2.activityInfo;
                        if (activityInfo.exported && ((str = activityInfo.permission) == null || context.checkSelfPermission(str) == 0)) {
                            arrayList.add(resolveInfo);
                        }
                    }
                    i++;
                }
                return arrayList;
            default:
                ((Long) obj).longValue();
                return Unit.INSTANCE;
        }
    }

    public /* synthetic */ BasicTextKt$$ExternalSyntheticLambda3(int i, LazyListMeasureResult lazyListMeasureResult) {
        this.$r8$classId = 16;
    }
}
