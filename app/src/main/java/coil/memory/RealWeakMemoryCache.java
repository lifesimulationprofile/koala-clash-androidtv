package coil.memory;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.menu.MenuDialogHelper;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuToolbarHandlerNode;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProvider;
import androidx.compose.foundation.text.contextmenu.provider.TextContextMenuProviderKt;
import androidx.compose.runtime.tooling.ParseException;
import androidx.compose.ui.node.HitTestResultKt;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.navigation.NavOptions;
import androidx.navigation.compose.NavHostKt$NavHost$28$1;
import androidx.room.DatabaseConfiguration;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzah;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.DeepRecursiveScopeImpl;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.StandaloneCoroutine;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.json.internal.ArrayPoolsKt;
import kotlinx.serialization.json.internal.CharArrayPool;
import kotlinx.serialization.json.internal.JsonTreeReader$readDeepRecursive$1;
import kotlinx.serialization.json.internal.JsonTreeReader$readObject$2;
import kotlinx.serialization.json.internal.WriteModeKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RealWeakMemoryCache implements AccessibilityViewCommand {
    public final /* synthetic */ int $r8$classId;
    public Object cache;
    public int operationsSinceCleanUp;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class InternalValue {
        public final WeakReference bitmap;
        public final Map extras;
        public final int identityHashCode;
        public final int size;

        public InternalValue(int i, WeakReference weakReference, Map map, int i2) {
            this.identityHashCode = i;
            this.bitmap = weakReference;
            this.extras = map;
            this.size = i2;
        }
    }

    public /* synthetic */ RealWeakMemoryCache(int i, int i2, Object obj) {
        this.$r8$classId = i2;
        this.cache = obj;
        this.operationsSinceCleanUp = i;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x009e  */
    /* JADX WARN: Code duplicated, block: B:31:0x00a2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:34:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public static final Object access$readObject(RealWeakMemoryCache realWeakMemoryCache, DeepRecursiveScopeImpl deepRecursiveScopeImpl, BaseContinuationImpl baseContinuationImpl) {
        JsonTreeReader$readObject$2 jsonTreeReader$readObject$2;
        byte bConsumeNextToken;
        LinkedHashMap linkedHashMap;
        LinkedHashMap linkedHashMap2;
        RealWeakMemoryCache realWeakMemoryCache2;
        byte bConsumeNextToken2;
        DatabaseConfiguration databaseConfiguration;
        DatabaseConfiguration databaseConfiguration2 = (DatabaseConfiguration) realWeakMemoryCache.cache;
        if (baseContinuationImpl instanceof JsonTreeReader$readObject$2) {
            jsonTreeReader$readObject$2 = (JsonTreeReader$readObject$2) baseContinuationImpl;
            int i = jsonTreeReader$readObject$2.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                jsonTreeReader$readObject$2.label = i - Integer.MIN_VALUE;
            } else {
                jsonTreeReader$readObject$2 = new JsonTreeReader$readObject$2(realWeakMemoryCache, baseContinuationImpl);
            }
        } else {
            jsonTreeReader$readObject$2 = new JsonTreeReader$readObject$2(realWeakMemoryCache, baseContinuationImpl);
        }
        Object obj = jsonTreeReader$readObject$2.result;
        int i2 = jsonTreeReader$readObject$2.label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String str = jsonTreeReader$readObject$2.L$3;
            linkedHashMap2 = jsonTreeReader$readObject$2.L$2;
            realWeakMemoryCache2 = jsonTreeReader$readObject$2.L$1;
            DeepRecursiveScopeImpl deepRecursiveScopeImpl2 = jsonTreeReader$readObject$2.L$0;
            ResultKt.throwOnFailure(obj);
            linkedHashMap2.put(str, (JsonElement) obj);
            bConsumeNextToken2 = ((DatabaseConfiguration) realWeakMemoryCache2.cache).consumeNextToken();
            if (bConsumeNextToken2 == 4) {
                bConsumeNextToken = bConsumeNextToken2;
                realWeakMemoryCache = realWeakMemoryCache2;
                linkedHashMap = linkedHashMap2;
                deepRecursiveScopeImpl = deepRecursiveScopeImpl2;
            } else if (bConsumeNextToken2 != 7) {
                DatabaseConfiguration.fail$default((DatabaseConfiguration) realWeakMemoryCache2.cache, "Expected end of the object or comma", 0, null, 6);
                throw null;
            }
            databaseConfiguration = (DatabaseConfiguration) realWeakMemoryCache2.cache;
            if (bConsumeNextToken2 == 6) {
                databaseConfiguration.consumeNextToken((byte) 7);
            } else if (bConsumeNextToken2 == 4) {
                WriteModeKt.invalidTrailingComma$default(databaseConfiguration);
                throw null;
            }
            return new JsonObject(linkedHashMap2);
        }
        ResultKt.throwOnFailure(obj);
        bConsumeNextToken = databaseConfiguration2.consumeNextToken((byte) 6);
        if (databaseConfiguration2.peekNextToken() == 4) {
            DatabaseConfiguration.fail$default(databaseConfiguration2, "Unexpected leading comma", 0, null, 6);
            throw null;
        }
        linkedHashMap = new LinkedHashMap();
        DatabaseConfiguration databaseConfiguration3 = (DatabaseConfiguration) realWeakMemoryCache.cache;
        if (!databaseConfiguration3.canConsumeValue()) {
            linkedHashMap2 = linkedHashMap;
            realWeakMemoryCache2 = realWeakMemoryCache;
            bConsumeNextToken2 = bConsumeNextToken;
            databaseConfiguration = (DatabaseConfiguration) realWeakMemoryCache2.cache;
            if (bConsumeNextToken2 == 6) {
                databaseConfiguration.consumeNextToken((byte) 7);
            } else if (bConsumeNextToken2 == 4) {
                WriteModeKt.invalidTrailingComma$default(databaseConfiguration);
                throw null;
            }
            return new JsonObject(linkedHashMap2);
        }
        String strConsumeString = databaseConfiguration3.consumeString();
        databaseConfiguration3.consumeNextToken((byte) 5);
        Unit unit = Unit.INSTANCE;
        jsonTreeReader$readObject$2.L$0 = deepRecursiveScopeImpl;
        jsonTreeReader$readObject$2.L$1 = realWeakMemoryCache;
        jsonTreeReader$readObject$2.L$2 = linkedHashMap;
        jsonTreeReader$readObject$2.L$3 = strConsumeString;
        jsonTreeReader$readObject$2.label = 1;
        deepRecursiveScopeImpl.cont = jsonTreeReader$readObject$2;
        deepRecursiveScopeImpl.value = unit;
        return CoroutineSingletons.COROUTINE_SUSPENDED;
    }

    public void add(long j) {
        if (contains(j)) {
            return;
        }
        int i = this.operationsSinceCleanUp;
        long[] jArrCopyOf = (long[]) this.cache;
        if (i >= jArrCopyOf.length) {
            jArrCopyOf = Arrays.copyOf(jArrCopyOf, Math.max(i + 1, jArrCopyOf.length * 2));
            this.cache = jArrCopyOf;
        }
        jArrCopyOf[i] = j;
        if (i >= this.operationsSinceCleanUp) {
            this.operationsSinceCleanUp = i + 1;
        }
    }

    public boolean atEnd() {
        return this.operationsSinceCleanUp >= ((String) this.cache).length();
    }

    public void cleanUp$coil_base_release() {
        WeakReference weakReference;
        this.operationsSinceCleanUp = 0;
        Iterator it = ((LinkedHashMap) this.cache).values().iterator();
        while (it.hasNext()) {
            ArrayList arrayList = (ArrayList) it.next();
            if (arrayList.size() <= 1) {
                InternalValue internalValue = (InternalValue) CollectionsKt.firstOrNull(arrayList);
                if (((internalValue == null || (weakReference = internalValue.bitmap) == null) ? null : (Bitmap) weakReference.get()) == null) {
                    it.remove();
                }
            } else {
                int size = arrayList.size();
                int i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    int i3 = i2 - i;
                    if (((InternalValue) arrayList.get(i3)).bitmap.get() == null) {
                        arrayList.remove(i3);
                        i++;
                    }
                }
                if (arrayList.isEmpty()) {
                    it.remove();
                }
            }
        }
    }

    public boolean contains(long j) {
        int i = this.operationsSinceCleanUp;
        for (int i2 = 0; i2 < i; i2++) {
            if (((long[]) this.cache)[i2] == j) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.widget.ListAdapter] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    public AlertDialog create() {
        final AlertController.AlertParams alertParams = (AlertController.AlertParams) this.cache;
        AlertDialog alertDialog = new AlertDialog(alertParams.mContext, this.operationsSinceCleanUp);
        View view = alertParams.mCustomTitleView;
        final AlertController alertController = alertDialog.mAlert;
        if (view != null) {
            alertController.mCustomTitleView = view;
        } else {
            CharSequence charSequence = alertParams.mTitle;
            if (charSequence != null) {
                alertController.mTitle = charSequence;
                TextView textView = alertController.mTitleView;
                if (textView != null) {
                    textView.setText(charSequence);
                }
            }
            Drawable drawable = alertParams.mIcon;
            if (drawable != null) {
                alertController.mIcon = drawable;
                ImageView imageView = alertController.mIconView;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    alertController.mIconView.setImageDrawable(drawable);
                }
            }
        }
        if (alertParams.mAdapter != null) {
            AlertController.RecycleListView recycleListView = (AlertController.RecycleListView) alertParams.mInflater.inflate(alertController.mListLayout, (ViewGroup) null);
            int i = alertParams.mIsSingleChoice ? alertController.mSingleChoiceItemLayout : alertController.mListItemLayout;
            Object obj = alertParams.mAdapter;
            ?? checkedItemAdapter = obj;
            if (obj == null) {
                checkedItemAdapter = new AlertController.CheckedItemAdapter(alertParams.mContext, i, R.id.text1, null);
            }
            alertController.mAdapter = checkedItemAdapter;
            alertController.mCheckedItem = alertParams.mCheckedItem;
            if (alertParams.mOnClickListener != null) {
                recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.app.AlertController.AlertParams.3
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView adapterView, View view2, int i2, long j) {
                        AlertParams alertParams2 = AlertParams.this;
                        DialogInterface.OnClickListener onClickListener = alertParams2.mOnClickListener;
                        AlertController alertController2 = alertController;
                        onClickListener.onClick(alertController2.mDialog, i2);
                        if (alertParams2.mIsSingleChoice) {
                            return;
                        }
                        alertController2.mDialog.dismiss();
                    }
                });
            }
            if (alertParams.mIsSingleChoice) {
                recycleListView.setChoiceMode(1);
            }
            alertController.mListView = recycleListView;
        }
        alertDialog.setCancelable(true);
        alertDialog.setCanceledOnTouchOutside(true);
        alertDialog.setOnCancelListener(null);
        alertDialog.setOnDismissListener(null);
        MenuDialogHelper menuDialogHelper = alertParams.mOnKeyListener;
        if (menuDialogHelper != null) {
            alertDialog.setOnKeyListener(menuDialogHelper);
        }
        return alertDialog;
    }

    public void ensureTotalCapacity(int i, int i2) {
        int i3 = i2 + i;
        char[] cArr = (char[]) this.cache;
        if (cArr.length <= i3) {
            int i4 = i * 2;
            if (i3 < i4) {
                i3 = i4;
            }
            this.cache = Arrays.copyOf(cArr, i3);
        }
    }

    public void expect() throws ParseException {
        if (matches(')')) {
            return;
        }
        throwParseError("expected )");
        throw null;
    }

    public boolean hasNext() {
        return this.operationsSinceCleanUp < ((ArrayList) this.cache).size();
    }

    public boolean matches(char c) {
        int i = this.operationsSinceCleanUp;
        String str = (String) this.cache;
        return i < str.length() && str.charAt(this.operationsSinceCleanUp) == c;
    }

    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
    public boolean perform(View view) {
        ((BottomSheetBehavior) this.cache).setState(this.operationsSinceCleanUp);
        return true;
    }

    public JsonElement read() {
        JsonElement jsonObject;
        Object obj;
        DatabaseConfiguration databaseConfiguration = (DatabaseConfiguration) this.cache;
        byte bPeekNextToken = databaseConfiguration.peekNextToken();
        if (bPeekNextToken == 1) {
            return readValue(true);
        }
        if (bPeekNextToken == 0) {
            return readValue(false);
        }
        if (bPeekNextToken != 6) {
            if (bPeekNextToken == 8) {
                return readArray();
            }
            DatabaseConfiguration.fail$default(databaseConfiguration, "Cannot read Json element because of unexpected ".concat(WriteModeKt.tokenDescription(bPeekNextToken)), 0, null, 6);
            throw null;
        }
        int i = this.operationsSinceCleanUp + 1;
        this.operationsSinceCleanUp = i;
        if (i == 200) {
            JsonTreeReader$readDeepRecursive$1 jsonTreeReader$readDeepRecursive$1 = new JsonTreeReader$readDeepRecursive$1(this, null);
            Unit unit = Unit.INSTANCE;
            DeepRecursiveScopeImpl deepRecursiveScopeImpl = new DeepRecursiveScopeImpl();
            deepRecursiveScopeImpl.function = jsonTreeReader$readDeepRecursive$1;
            deepRecursiveScopeImpl.value = unit;
            deepRecursiveScopeImpl.cont = deepRecursiveScopeImpl;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
            deepRecursiveScopeImpl.result = coroutineSingletons;
            while (true) {
                obj = deepRecursiveScopeImpl.result;
                Continuation continuation = deepRecursiveScopeImpl.cont;
                if (continuation == null) {
                    break;
                }
                if (coroutineSingletons.equals(obj)) {
                    try {
                        JsonTreeReader$readDeepRecursive$1 jsonTreeReader$readDeepRecursive$2 = deepRecursiveScopeImpl.function;
                        Unit unit2 = deepRecursiveScopeImpl.value;
                        TypeIntrinsics.beforeCheckcastToFunctionOfArity(3, jsonTreeReader$readDeepRecursive$2);
                        Object objInvoke = jsonTreeReader$readDeepRecursive$2.invoke(deepRecursiveScopeImpl, unit2, continuation);
                        if (objInvoke != coroutineSingletons) {
                            continuation.resumeWith(objInvoke);
                        }
                    } catch (Throwable th) {
                        continuation.resumeWith(new Result.Failure(th));
                    }
                } else {
                    deepRecursiveScopeImpl.result = coroutineSingletons;
                    continuation.resumeWith(obj);
                }
            }
            ResultKt.throwOnFailure(obj);
            jsonObject = (JsonElement) obj;
        } else {
            byte bConsumeNextToken = databaseConfiguration.consumeNextToken((byte) 6);
            if (databaseConfiguration.peekNextToken() == 4) {
                DatabaseConfiguration.fail$default(databaseConfiguration, "Unexpected leading comma", 0, null, 6);
                throw null;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            while (databaseConfiguration.canConsumeValue()) {
                String strConsumeString = databaseConfiguration.consumeString();
                databaseConfiguration.consumeNextToken((byte) 5);
                linkedHashMap.put(strConsumeString, read());
                bConsumeNextToken = databaseConfiguration.consumeNextToken();
                if (bConsumeNextToken != 4) {
                    if (bConsumeNextToken == 7) {
                        break;
                    }
                    DatabaseConfiguration.fail$default(databaseConfiguration, "Expected end of the object or comma", 0, null, 6);
                    throw null;
                }
            }
            if (bConsumeNextToken == 6) {
                databaseConfiguration.consumeNextToken((byte) 7);
            } else if (bConsumeNextToken == 4) {
                WriteModeKt.invalidTrailingComma$default(databaseConfiguration);
                throw null;
            }
            jsonObject = new JsonObject(linkedHashMap);
        }
        this.operationsSinceCleanUp--;
        return jsonObject;
    }

    public JsonArray readArray() {
        DatabaseConfiguration databaseConfiguration = (DatabaseConfiguration) this.cache;
        byte bConsumeNextToken = databaseConfiguration.consumeNextToken();
        if (databaseConfiguration.peekNextToken() == 4) {
            DatabaseConfiguration.fail$default(databaseConfiguration, "Unexpected leading comma", 0, null, 6);
            throw null;
        }
        ArrayList arrayList = new ArrayList();
        while (databaseConfiguration.canConsumeValue()) {
            arrayList.add(read());
            bConsumeNextToken = databaseConfiguration.consumeNextToken();
            if (bConsumeNextToken != 4) {
                boolean z = bConsumeNextToken == 9;
                int i = databaseConfiguration.journalMode;
                if (!z) {
                    DatabaseConfiguration.fail$default(databaseConfiguration, "Expected end of the array or comma", i, null, 4);
                    throw null;
                }
            }
        }
        if (bConsumeNextToken == 8) {
            databaseConfiguration.consumeNextToken((byte) 9);
        } else if (bConsumeNextToken == 4) {
            WriteModeKt.invalidTrailingComma(databaseConfiguration, "array");
            throw null;
        }
        return new JsonArray(arrayList);
    }

    public JsonPrimitive readValue(boolean z) {
        DatabaseConfiguration databaseConfiguration = (DatabaseConfiguration) this.cache;
        String strConsumeStringLenient = !z ? databaseConfiguration.consumeStringLenient() : databaseConfiguration.consumeString();
        return (z || !Intrinsics.areEqual(strConsumeStringLenient, "null")) ? new JsonLiteral(strConsumeStringLenient, z) : JsonNull.INSTANCE;
    }

    public void release() {
        CharArrayPool charArrayPool = CharArrayPool.INSTANCE;
        char[] cArr = (char[]) this.cache;
        synchronized (charArrayPool) {
            try {
                int i = charArrayPool.charsTotal;
                if (cArr.length + i < ArrayPoolsKt.MAX_CHARS_IN_POOL) {
                    charArrayPool.charsTotal = i + cArr.length;
                    ((ArrayDeque) charArrayPool.arrays).addLast(cArr);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void remove(long j) {
        int i = this.operationsSinceCleanUp;
        int i2 = 0;
        while (i2 < i) {
            if (j == ((long[]) this.cache)[i2]) {
                int i3 = this.operationsSinceCleanUp - 1;
                while (i2 < i3) {
                    long[] jArr = (long[]) this.cache;
                    int i4 = i2 + 1;
                    jArr[i2] = jArr[i4];
                    i2 = i4;
                }
                this.operationsSinceCleanUp--;
                return;
            }
            i2++;
        }
    }

    public synchronized void set(MemoryCache$Key memoryCache$Key, Bitmap bitmap, Map map, int i) {
        try {
            LinkedHashMap linkedHashMap = (LinkedHashMap) this.cache;
            Object arrayList = linkedHashMap.get(memoryCache$Key);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(memoryCache$Key, arrayList);
            }
            ArrayList arrayList2 = (ArrayList) arrayList;
            int iIdentityHashCode = System.identityHashCode(bitmap);
            InternalValue internalValue = new InternalValue(iIdentityHashCode, new WeakReference(bitmap), map, i);
            int size = arrayList2.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    arrayList2.add(internalValue);
                    break;
                }
                InternalValue internalValue2 = (InternalValue) arrayList2.get(i2);
                if (i >= internalValue2.size) {
                    if (internalValue2.identityHashCode != iIdentityHashCode || internalValue2.bitmap.get() != bitmap) {
                        arrayList2.add(i2, internalValue);
                        break;
                    } else {
                        arrayList2.set(i2, internalValue);
                        break;
                    }
                }
                i2++;
            }
            int i3 = this.operationsSinceCleanUp;
            this.operationsSinceCleanUp = i3 + 1;
            if (i3 >= 10) {
                cleanUp$coil_base_release();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void show() {
        TextContextMenuProvider textContextMenuProvider;
        if (this.operationsSinceCleanUp == 1) {
            InlineClassHelperKt.throwIllegalStateException("ToolbarRequester is not initialized.");
        }
        TextContextMenuToolbarHandlerNode textContextMenuToolbarHandlerNode = (TextContextMenuToolbarHandlerNode) this.cache;
        if (textContextMenuToolbarHandlerNode == null || !textContextMenuToolbarHandlerNode.isAttached) {
            return;
        }
        StandaloneCoroutine standaloneCoroutine = textContextMenuToolbarHandlerNode.textToolbarJob;
        if ((standaloneCoroutine == null || !standaloneCoroutine.isActive()) && (textContextMenuProvider = (TextContextMenuProvider) HitTestResultKt.currentValueOf(textContextMenuToolbarHandlerNode, TextContextMenuProviderKt.LocalTextContextMenuToolbarProvider)) != null) {
            textContextMenuToolbarHandlerNode.textToolbarJob = JobKt.launch$default(textContextMenuToolbarHandlerNode.getCoroutineScope(), null, new NavHostKt$NavHost$28$1(textContextMenuToolbarHandlerNode, textContextMenuProvider, (Continuation) null, 16), 1);
        }
    }

    public int takeIntUntil(String str) throws ParseException {
        Integer intOrNull = StringsKt__StringsJVMKt.toIntOrNull(takeUntil(str));
        if (intOrNull != null) {
            return intOrNull.intValue();
        }
        throwParseError("expected int");
        throw null;
    }

    public String takeUntil(String str) {
        int i = this.operationsSinceCleanUp;
        String str2 = (String) this.cache;
        while (this.operationsSinceCleanUp < str2.length() && !StringsKt.contains$default(str, str2.charAt(this.operationsSinceCleanUp))) {
            this.operationsSinceCleanUp++;
        }
        int i2 = this.operationsSinceCleanUp;
        return i2 > i ? str2.substring(i, i2) : "";
    }

    public void throwParseError(String str) throws ParseException {
        int i = this.operationsSinceCleanUp;
        String str2 = (String) this.cache;
        int iMin = Math.min(i, str2.length());
        StringBuilder sbM16m = ImageAnalysis$$ExternalSyntheticLambda1.m16m("Error while parsing source information: ", str, " at ");
        sbM16m.append(str2.substring(0, iMin));
        sbM16m.append('|');
        sbM16m.append(str2.substring(iMin));
        throw new ParseException(sbM16m.toString());
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 12:
                return new String((char[]) this.cache, 0, this.operationsSinceCleanUp);
            default:
                return super.toString();
        }
    }

    public synchronized void trimMemory(int i) {
        if (i >= 10 && i != 20) {
            cleanUp$coil_base_release();
        }
    }

    public void write(String str) {
        int length = str.length();
        if (length == 0) {
            return;
        }
        ensureTotalCapacity(this.operationsSinceCleanUp, length);
        str.getChars(0, str.length(), (char[]) this.cache, this.operationsSinceCleanUp);
        this.operationsSinceCleanUp += length;
    }

    public /* synthetic */ RealWeakMemoryCache(int i, Serializable serializable) {
        this.$r8$classId = i;
        this.cache = serializable;
    }

    public /* synthetic */ RealWeakMemoryCache(int i, boolean z) {
        this.$r8$classId = i;
    }

    public RealWeakMemoryCache(ConnectionResult connectionResult, int i) {
        this.$r8$classId = 9;
        zzah.checkNotNull(connectionResult);
        this.cache = connectionResult;
        this.operationsSinceCleanUp = i;
    }

    public RealWeakMemoryCache(JsonConfiguration jsonConfiguration, DatabaseConfiguration databaseConfiguration) {
        this.$r8$classId = 13;
        this.cache = databaseConfiguration;
    }

    public RealWeakMemoryCache(int i) {
        this.$r8$classId = i;
        switch (i) {
            case 4:
                this.operationsSinceCleanUp = 1;
                break;
            case 8:
                this.operationsSinceCleanUp = 1;
                this.cache = Collections.singletonList(null);
                break;
            default:
                this.cache = new LinkedHashMap();
                break;
        }
    }

    public RealWeakMemoryCache(int i, NavOptions.Builder[] builderArr) {
        this.$r8$classId = 11;
        this.operationsSinceCleanUp = i;
        this.cache = builderArr;
    }

    public RealWeakMemoryCache(Context context) {
        this.$r8$classId = 1;
        int iResolveDialogTheme = AlertDialog.resolveDialogTheme(context, 0);
        this.cache = new AlertController.AlertParams(new ContextThemeWrapper(context, AlertDialog.resolveDialogTheme(context, iResolveDialogTheme)));
        this.operationsSinceCleanUp = iResolveDialogTheme;
    }

    public RealWeakMemoryCache(ArrayList arrayList) {
        this.$r8$classId = 8;
        this.operationsSinceCleanUp = 0;
        this.cache = arrayList;
    }
}
