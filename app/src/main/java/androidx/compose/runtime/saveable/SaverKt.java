package androidx.compose.runtime.saveable;

import androidx.compose.runtime.Composer$Companion;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda0;
import androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda10;
import coil.ImageLoader$Builder$$ExternalSyntheticLambda2;
import coil.request.RequestService;
import com.github.kr328.clash.FilesActivity$$ExternalSyntheticLambda6;
import java.util.Arrays;
import kotlin.jvm.functions.Function0;
import kotlin.text.CharsKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class SaverKt {
    public static final RequestService AutoSaver = new RequestService(2, new SaversKt$$ExternalSyntheticLambda0(24), new SaversKt$$ExternalSyntheticLambda10(21));

    public static final String generateCannotBeSavedErrorMessage(Object obj) {
        return obj + " cannot be saved using the current SaveableStateRegistry. The default implementation only supports types which can be stored inside the Bundle. Please consider implementing a custom Saver for this class and pass it to rememberSaveable().";
    }

    public static final Object rememberSaveable(Object[] objArr, Function0 function0, GapComposer gapComposer) {
        return rememberSaveable(Arrays.copyOf(objArr, objArr.length), AutoSaver, function0, gapComposer, 3456, 0);
    }

    public static final SaveableStateHolderImpl rememberSaveableStateHolder(GapComposer gapComposer) {
        gapComposer.startReplaceGroup(1967007413);
        Object[] objArr = new Object[0];
        Object objRememberedValue = gapComposer.rememberedValue();
        if (objRememberedValue == Composer$Companion.Empty) {
            objRememberedValue = new ImageLoader$Builder$$ExternalSyntheticLambda2(9);
            gapComposer.updateRememberedValue(objRememberedValue);
        }
        SaveableStateHolderImpl saveableStateHolderImpl = (SaveableStateHolderImpl) rememberSaveable(objArr, SaveableStateHolderImpl.Saver, (Function0) objRememberedValue, gapComposer, 384);
        saveableStateHolderImpl.parentSaveableStateRegistry = (SaveableStateRegistry) gapComposer.consume(SaveableStateRegistryKt.LocalSaveableStateRegistry);
        gapComposer.end(false);
        return saveableStateHolderImpl;
    }

    public static final Object rememberSaveable(Object[] objArr, Saver saver, Function0 function0, GapComposer gapComposer, int i) {
        return rememberSaveable(Arrays.copyOf(objArr, objArr.length), saver, function0, gapComposer, 384 | ((i << 3) & 7168), 0);
    }

    public static final Object rememberSaveable(Object[] objArr, Saver saver, Function0 function0, GapComposer gapComposer, int i, int i2) {
        Object[] objArr2;
        Saver saver2;
        Object obj;
        Object objConsumeRestored;
        long j = gapComposer.compositeKeyHashCode;
        CharsKt.checkRadix(36);
        String string = Long.toString(j, 36);
        SaveableStateRegistry saveableStateRegistry = (SaveableStateRegistry) gapComposer.consume(SaveableStateRegistryKt.LocalSaveableStateRegistry);
        Object objRememberedValue = gapComposer.rememberedValue();
        Object obj2 = Composer$Companion.Empty;
        if (objRememberedValue == obj2) {
            Object objRestore = (saveableStateRegistry == null || (objConsumeRestored = saveableStateRegistry.consumeRestored(string)) == null) ? null : saver.restore(objConsumeRestored);
            if (objRestore == null) {
                objRestore = function0.invoke();
            }
            objArr2 = objArr;
            saver2 = saver;
            Object saveableHolder = new SaveableHolder(saver2, saveableStateRegistry, string, objRestore, objArr2);
            gapComposer.updateRememberedValue(saveableHolder);
            objRememberedValue = saveableHolder;
        } else {
            objArr2 = objArr;
            saver2 = saver;
        }
        SaveableHolder saveableHolder2 = (SaveableHolder) objRememberedValue;
        Object objInvoke = Arrays.equals(objArr2, saveableHolder2.inputs) ? saveableHolder2.value : null;
        if (objInvoke == null) {
            objInvoke = function0.invoke();
        }
        boolean zChangedInstance = gapComposer.changedInstance(saveableHolder2) | ((((i & 112) ^ 48) > 32 && gapComposer.changedInstance(saver2)) || (i & 48) == 32) | gapComposer.changedInstance(saveableStateRegistry) | gapComposer.changed(string) | gapComposer.changedInstance(objInvoke) | gapComposer.changedInstance(objArr2);
        Object objRememberedValue2 = gapComposer.rememberedValue();
        if (zChangedInstance || objRememberedValue2 == obj2) {
            Object[] objArr3 = objArr2;
            obj = objInvoke;
            Object filesActivity$$ExternalSyntheticLambda6 = new FilesActivity$$ExternalSyntheticLambda6(saveableHolder2, saver2, saveableStateRegistry, string, obj, objArr3, 2);
            gapComposer.updateRememberedValue(filesActivity$$ExternalSyntheticLambda6);
            objRememberedValue2 = filesActivity$$ExternalSyntheticLambda6;
        } else {
            obj = objInvoke;
        }
        Stack.SideEffect((Function0) objRememberedValue2, gapComposer);
        return obj;
    }
}
