package coil.disk;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import androidx.activity.ImmLeaksCleaner$$ExternalSyntheticLambda0;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.camera.lifecycle.LifecycleCamera;
import androidx.collection.MutableObjectIntMap;
import androidx.compose.foundation.lazy.LazyListIntervalContent;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.saveable.SaveableStateHolderImpl;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.text.font.FontFamilyResolverImpl;
import androidx.compose.ui.text.font.TypefaceRequest;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.DeleteAllCommand;
import androidx.compose.ui.text.input.DeleteSurroundingTextCommand;
import androidx.compose.ui.text.input.DeleteSurroundingTextInCodePointsCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.FinishComposingTextCommand;
import androidx.compose.ui.text.input.SetComposingRegionCommand;
import androidx.compose.ui.text.input.SetComposingTextCommand;
import androidx.compose.ui.text.input.SetSelectionCommand;
import androidx.compose.ui.window.AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1;
import androidx.navigation.NavGraph;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptionsBuilder;
import coil.decode.BitmapFactoryDecoder$$ExternalSyntheticApiModelOutline0;
import com.github.kr328.clash.ApkBrokenActivity;
import com.github.kr328.clash.FilesActivity$showError$1;
import com.github.kr328.clash.LogcatActivity;
import com.github.kr328.clash.LogsActivity;
import com.github.kr328.clash.ShareToTvActivity;
import com.github.kr328.clash.common.util.ComponentsKt;
import com.github.kr328.clash.compose.FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2;
import com.github.kr328.clash.compose.TvMainAppKt;
import com.github.kr328.clash.compose.home.HomeScreenKt$StatusAndControl$1$2;
import com.github.kr328.clash.compose.home.HomeViewModel$observer$1;
import com.github.kr328.clash.compose.proxy.ProxyViewModel;
import com.github.kr328.clash.design.model.AppInfo;
import com.github.kr328.clash.design.model.LogFile;
import com.github.kr328.clash.remote.Remote;
import com.github.kr328.clash.service.model.Profile;
import com.google.mlkit.vision.barcode.common.Barcode;
import dev.chrisbanes.haze.RenderScriptBlurEffect;
import io.github.g00fy2.quickie.QRCodeAnalyzer;
import io.github.g00fy2.quickie.QRScannerActivity;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.zip.ZipEntry;
import kotlin.Unit;
import kotlin.collections.AbstractCollection;
import kotlin.collections.AbstractMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Reflection;
import kotlin.text.MatcherMatchResult;
import kotlin.text.MatcherMatchResult$groups$1;
import kotlin.text.Regex;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.serialization.descriptors.SerialDescriptorImpl;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class DiskLruCache$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ DiskLruCache$$ExternalSyntheticLambda0(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00f5  */
    /* JADX WARN: Multi-variable type inference failed */
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
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        String strConcat;
        StringBuilder sb;
        int i;
        int i2 = 3;
        char c = 1;
        Barcode barcode = null;
        Object[] objArr = 0;
        switch (this.$r8$classId) {
            case 0:
                ((DiskLruCache) this.f$0).hasJournalErrors = true;
                return Unit.INSTANCE;
            case 1:
                SaveableStateRegistry saveableStateRegistry = ((SaveableStateHolderImpl) this.f$0).parentSaveableStateRegistry;
                return Boolean.valueOf(saveableStateRegistry != null ? saveableStateRegistry.canBeSaved(obj) : true);
            case 2:
                SnapshotStateObserver snapshotStateObserver = (SnapshotStateObserver) this.f$0;
                synchronized (snapshotStateObserver.observedScopeMapsLock) {
                    SnapshotStateObserver.ObservedScopeMap observedScopeMap = snapshotStateObserver.currentMap;
                    Object obj2 = observedScopeMap.currentScope;
                    int i3 = observedScopeMap.currentToken;
                    MutableObjectIntMap mutableObjectIntMap = observedScopeMap.currentScopeReads;
                    if (mutableObjectIntMap == null) {
                        mutableObjectIntMap = new MutableObjectIntMap();
                        observedScopeMap.currentScopeReads = mutableObjectIntMap;
                        observedScopeMap.scopeToValues.set(obj2, mutableObjectIntMap);
                        Unit unit = Unit.INSTANCE;
                    }
                    observedScopeMap.recordRead(obj, i3, obj2, mutableObjectIntMap);
                }
                return Unit.INSTANCE;
            case 3:
                TypefaceRequest typefaceRequest = (TypefaceRequest) obj;
                return ((FontFamilyResolverImpl) this.f$0).resolve(new TypefaceRequest(null, typefaceRequest.fontWeight, typefaceRequest.fontStyle, typefaceRequest.fontSynthesis, typefaceRequest.resourceLoaderCacheKey)).value;
            case 4:
                EditCommand editCommand = (EditCommand) obj;
                String str = ((EditCommand) this.f$0) == editCommand ? " > " : "   ";
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                if (!(editCommand instanceof CommitTextCommand)) {
                    if (editCommand instanceof SetComposingTextCommand) {
                        sb = new StringBuilder("SetComposingTextCommand(text.length=");
                        SetComposingTextCommand setComposingTextCommand = (SetComposingTextCommand) editCommand;
                        sb.append(setComposingTextCommand.annotatedString.text.length());
                        sb.append(", newCursorPosition=");
                        i = setComposingTextCommand.newCursorPosition;
                    } else if (editCommand instanceof SetComposingRegionCommand) {
                        strConcat = ((SetComposingRegionCommand) editCommand).toString();
                    } else if (editCommand instanceof DeleteSurroundingTextCommand) {
                        strConcat = ((DeleteSurroundingTextCommand) editCommand).toString();
                    } else if (editCommand instanceof DeleteSurroundingTextInCodePointsCommand) {
                        strConcat = ((DeleteSurroundingTextInCodePointsCommand) editCommand).toString();
                    } else if (editCommand instanceof SetSelectionCommand) {
                        strConcat = ((SetSelectionCommand) editCommand).toString();
                    } else if (editCommand instanceof FinishComposingTextCommand) {
                        strConcat = "FinishComposingTextCommand()";
                    } else if (editCommand instanceof DeleteAllCommand) {
                        strConcat = "DeleteAllCommand()";
                    } else {
                        String simpleName = Reflection.getOrCreateKotlinClass(editCommand.getClass()).getSimpleName();
                        if (simpleName == null) {
                            simpleName = "{anonymous EditCommand}";
                        }
                        strConcat = "Unknown EditCommand: ".concat(simpleName);
                    }
                    sb2.append(strConcat);
                    return sb2.toString();
                }
                sb = new StringBuilder("CommitTextCommand(text.length=");
                CommitTextCommand commitTextCommand = (CommitTextCommand) editCommand;
                sb.append(commitTextCommand.annotatedString.text.length());
                sb.append(", newCursorPosition=");
                i = commitTextCommand.newCursorPosition;
                strConcat = ImageAnalysis$$ExternalSyntheticLambda1.m(sb, i, ')');
                sb2.append(strConcat);
                return sb2.toString();
            case 5:
                PackageManager packageManager = (PackageManager) this.f$0;
                PackageInfo packageInfo = (PackageInfo) obj;
                String str2 = packageInfo.packageName;
                Drawable drawableLoadIcon = packageInfo.applicationInfo.loadIcon(packageManager);
                if (Build.VERSION.SDK_INT >= 26 && BitmapFactoryDecoder$$ExternalSyntheticApiModelOutline0.m784m(drawableLoadIcon) && BitmapFactoryDecoder$$ExternalSyntheticApiModelOutline0.m(drawableLoadIcon).getBackground() == null) {
                    drawableLoadIcon = BitmapFactoryDecoder$$ExternalSyntheticApiModelOutline0.m(drawableLoadIcon).getForeground();
                }
                return new AppInfo(str2, packageInfo.applicationInfo.loadLabel(packageManager).toString(), drawableLoadIcon, packageInfo.firstInstallTime, packageInfo.lastUpdateTime);
            case 6:
                ((ApkBrokenActivity) this.f$0).startActivity(new Intent("android.intent.action.VIEW").setData(Uri.parse((String) obj)));
                return Unit.INSTANCE;
            case 7:
                LogsActivity logsActivity = (LogsActivity) this.f$0;
                Intent intent = ComponentsKt.getIntent(Reflection.getOrCreateKotlinClass(LogcatActivity.class));
                intent.setData(Uri.fromParts("file", ((LogFile) obj).fileName, null));
                logsActivity.startActivity(intent);
                return Unit.INSTANCE;
            case 8:
                ShareToTvActivity shareToTvActivity = (ShareToTvActivity) this.f$0;
                int i4 = ShareToTvActivity.$r8$clinit;
                JobKt.launch$default(shareToTvActivity, null, new FilesActivity$showError$1((Profile) obj, shareToTvActivity, objArr == true ? 1 : 0, 5), 3);
                return Unit.INSTANCE;
            case 9:
                NavHostController navHostController = (NavHostController) this.f$0;
                NavOptionsBuilder navOptionsBuilder = (NavOptionsBuilder) obj;
                int i5 = NavGraph.$r8$clinit;
                NavGraph navGraph = navHostController._graph;
                if (navGraph == null) {
                    throw new IllegalStateException("You must call setGraph() before calling getGraph()");
                }
                navOptionsBuilder.popUpToId = NavGraph.Companion.findStartDestination(navGraph).id;
                Unit unit2 = Unit.INSTANCE;
                navOptionsBuilder.saveState = true;
                navOptionsBuilder.launchSingleTop = true;
                navOptionsBuilder.restoreState = true;
                return Unit.INSTANCE;
            case 10:
                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = (ParcelableSnapshotMutableIntState) this.f$0;
                int iIntValue = ((Integer) obj).intValue();
                float f = TvMainAppKt.TvOverscanHorizontal;
                parcelableSnapshotMutableIntState.setIntValue(iIntValue);
                return Unit.INSTANCE;
            case 11:
                HomeViewModel$observer$1 homeViewModel$observer$1 = new HomeViewModel$observer$1(i2, (ProxyViewModel) this.f$0);
                Remote.broadcasts.addObserver(homeViewModel$observer$1);
                return new AndroidPopup_androidKt$Popup$2$1$invoke$$inlined$onDispose$1(18, homeViewModel$observer$1);
            case 12:
                List list = (List) this.f$0;
                ((LazyListIntervalContent) obj).items(list.size(), null, new FilesScreenKt$FilesScreen$2$invoke$lambda$5$lambda$4$$inlined$items$default$2(16, list), new ComposableLambdaImpl(802480018, new HomeScreenKt$StatusAndControl$1$2(c == true ? 1 : 0, list), true));
                return Unit.INSTANCE;
            case 13:
                Regex regex = (Regex) this.f$0;
                String name = ((ZipEntry) obj).getName();
                Matcher matcher = regex.nativePattern.matcher(name);
                if (matcher.matches()) {
                    return new MatcherMatchResult(matcher, name);
                }
                return null;
            case 14:
                GraphicsLayerKt.drawLayer((DrawScope) obj, ((RenderScriptBlurEffect) this.f$0).contentLayer);
                return Unit.INSTANCE;
            case 15:
                QRCodeAnalyzer qRCodeAnalyzer = (QRCodeAnalyzer) this.f$0;
                for (Barcode barcode2 : (List) obj) {
                    if (barcode2 != null) {
                        barcode = barcode2;
                        if (barcode != null) {
                            qRCodeAnalyzer.onSuccess.invoke(barcode);
                        }
                        return Unit.INSTANCE;
                    }
                }
                if (barcode != null) {
                    qRCodeAnalyzer.onSuccess.invoke(barcode);
                }
                return Unit.INSTANCE;
            case 16:
                LifecycleCamera lifecycleCamera = (LifecycleCamera) this.f$0;
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                int i6 = QRScannerActivity.$r8$clinit;
                lifecycleCamera.mCameraUseCaseAdapter.mAdapterCameraControl.enableTorch(zBooleanValue);
                return Unit.INSTANCE;
            case 17:
                return obj == ((AbstractCollection) this.f$0) ? "(this Collection)" : String.valueOf(obj);
            case 18:
                AbstractMap abstractMap = (AbstractMap) this.f$0;
                Map.Entry entry = (Map.Entry) obj;
                StringBuilder sb3 = new StringBuilder();
                Object key = entry.getKey();
                sb3.append(key == abstractMap ? "(this Map)" : String.valueOf(key));
                sb3.append('=');
                Object value = entry.getValue();
                sb3.append(value != abstractMap ? String.valueOf(value) : "(this Map)");
                return sb3.toString();
            case 19:
                return ((ImmLeaksCleaner$$ExternalSyntheticLambda0) this.f$0).invoke();
            case 20:
                return ((MatcherMatchResult$groups$1) this.f$0).get(((Integer) obj).intValue());
            case 21:
                ((MutexImpl) this.f$0).unlock(null);
                return Unit.INSTANCE;
            case 22:
                SerialDescriptorImpl serialDescriptorImpl = (SerialDescriptorImpl) this.f$0;
                int iIntValue2 = ((Integer) obj).intValue();
                return serialDescriptorImpl.elementNames[iIntValue2] + ": " + serialDescriptorImpl.elementDescriptors[iIntValue2].getSerialName();
            default:
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = (PluginGeneratedSerialDescriptor) this.f$0;
                int iIntValue3 = ((Integer) obj).intValue();
                return pluginGeneratedSerialDescriptor.names[iIntValue3] + ": " + pluginGeneratedSerialDescriptor.getElementDescriptor(iIntValue3).getSerialName();
        }
    }

    public /* synthetic */ DiskLruCache$$ExternalSyntheticLambda0(int i, Object obj, Object obj2) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }
}
