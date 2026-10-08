package com.github.kr328.clash.remote;

import android.app.Application;
import android.content.IntentFilter;
import android.util.Log;
import androidx.compose.ui.graphics.vector.VectorGroup;
import coil.disk.DiskLruCache;
import com.github.kr328.clash.TileService$receiver$1;
import com.github.kr328.clash.common.compat.ContextKt;
import com.github.kr328.clash.common.constants.Intents;
import com.github.kr328.clash.common.util.ComponentsKt;
import com.github.kr328.clash.design.model.File;
import com.github.kr328.clash.service.RemoteService;
import dev.chrisbanes.haze.HazeStyleKt$$ExternalSyntheticLambda0;
import io.github.g00fy2.quickie.QROverlayView;
import java.net.NetworkInterface;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.zip.ZipFile;
import kotlin.SynchronizedLazyImpl;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchGroup;
import kotlin.text.MatcherMatchResult;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.internal.StringOpsKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Remote$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ Remote$$ExternalSyntheticLambda1(int i) {
        this.$r8$classId = i;
    }

    /* JADX WARN: Code duplicated, block: B:74:0x01ed  */
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        String string;
        boolean z = false;
        switch (this.$r8$classId) {
            case 0:
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                DiskLruCache.Editor editor = Remote.broadcasts;
                Service service = Remote.service;
                if (zBooleanValue) {
                    Log.d("KoalaClash", "App becomes visible", null);
                    service.getClass();
                    Service$connection$1 service$connection$1 = service.connection;
                    Application application = service.context;
                    try {
                        try {
                            application.bindService(ComponentsKt.getIntent(Reflection.getOrCreateKotlinClass(RemoteService.class)), service$connection$1, 1);
                        } catch (Exception unused) {
                            service.remote.set(null);
                            service.crashed.invoke();
                        }
                    } catch (Exception unused2) {
                        application.unbindService(service$connection$1);
                        service.remote.set(null);
                        service.crashed.invoke();
                        editor.getClass();
                        Application application2 = (Application) editor.entry;
                        TileService$receiver$1 tileService$receiver$1 = (TileService$receiver$1) editor.this$0;
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction(Intents.ACTION_SERVICE_RECREATED);
                        intentFilter.addAction(Intents.ACTION_CLASH_STARTED);
                        intentFilter.addAction(Intents.ACTION_CLASH_STOPPED);
                        intentFilter.addAction(Intents.ACTION_PROFILE_CHANGED);
                        intentFilter.addAction(Intents.ACTION_PROFILE_UPDATE_COMPLETED);
                        intentFilter.addAction(Intents.ACTION_PROFILE_UPDATE_FAILED);
                        intentFilter.addAction(Intents.ACTION_PROFILE_LOADED);
                        Unit unit = Unit.INSTANCE;
                        ContextKt.registerReceiverCompat(application2, tileService$receiver$1, intentFilter, null);
                        editor.closed = new StatusClient(application2, z).currentProfile() != null;
                        return Unit.INSTANCE;
                    }
                    editor.getClass();
                    Application application3 = (Application) editor.entry;
                    try {
                        TileService$receiver$1 tileService$receiver$2 = (TileService$receiver$1) editor.this$0;
                        IntentFilter intentFilter2 = new IntentFilter();
                        intentFilter2.addAction(Intents.ACTION_SERVICE_RECREATED);
                        intentFilter2.addAction(Intents.ACTION_CLASH_STARTED);
                        intentFilter2.addAction(Intents.ACTION_CLASH_STOPPED);
                        intentFilter2.addAction(Intents.ACTION_PROFILE_CHANGED);
                        intentFilter2.addAction(Intents.ACTION_PROFILE_UPDATE_COMPLETED);
                        intentFilter2.addAction(Intents.ACTION_PROFILE_UPDATE_FAILED);
                        intentFilter2.addAction(Intents.ACTION_PROFILE_LOADED);
                        Unit unit2 = Unit.INSTANCE;
                        ContextKt.registerReceiverCompat(application3, tileService$receiver$2, intentFilter2, null);
                        editor.closed = new StatusClient(application3, z).currentProfile() != null;
                    } catch (Exception e) {
                        Log.w("KoalaClash", "Register global receiver: " + e, e);
                    }
                    break;
                } else {
                    Log.d("KoalaClash", "App becomes invisible", null);
                    try {
                        service.context.unbindService(service.connection);
                        break;
                    } catch (Exception unused3) {
                    }
                    service.remote.set(null);
                    editor.getClass();
                }
                return Unit.INSTANCE;
            case 1:
                return Boolean.valueOf(!StringsKt__StringsJVMKt.startsWith((String) obj, "#", false));
            case 2:
                return StringsKt.split$default((String) obj, new String[]{":"}, 3, 2);
            case 3:
                return Boolean.valueOf(!((File) obj).isDirectory);
            case 4:
                return ((File) obj).name;
            case 5:
                ((JsonBuilder) obj).ignoreUnknownKeys = true;
                return Unit.INSTANCE;
            case 6:
                ((IntentFilter) obj).addAction(Intents.ACTION_CLASH_REQUEST_STOP);
                return Unit.INSTANCE;
            case 7:
                IntentFilter intentFilter3 = (IntentFilter) obj;
                intentFilter3.addAction(Intents.ACTION_PROFILE_CHANGED);
                intentFilter3.addAction(Intents.ACTION_MODE_CHANGED);
                return Unit.INSTANCE;
            case 8:
                ((IntentFilter) obj).addAction(Intents.ACTION_PROFILE_LOADED);
                return Unit.INSTANCE;
            case 9:
                ((IntentFilter) obj).addAction(Intents.ACTION_PROFILE_LOADED);
                return Unit.INSTANCE;
            case 10:
                ((IntentFilter) obj).addAction("android.intent.action.TIMEZONE_CHANGED");
                return Unit.INSTANCE;
            case 11:
                String str = (String) obj;
                if (StringsKt.isBlank(str)) {
                    return null;
                }
                return UUID.fromString(str);
            case 12:
                UUID uuid = (UUID) obj;
                return (uuid == null || (string = uuid.toString()) == null) ? "" : string;
            case 13:
                return Boolean.valueOf(new java.io.File((String) obj).exists());
            case 14:
                return SequencesKt.asSequence(new VectorGroup.AnonymousClass1(new ZipFile((String) obj).entries()));
            case 15:
                MatchGroup matchGroup = ((MatcherMatchResult) obj).groups.get(1);
                if (matchGroup != null) {
                    return matchGroup.value;
                }
                return null;
            case 16:
                ((Boolean) obj).booleanValue();
                return Unit.INSTANCE;
            case 17:
                NetworkInterface networkInterface = (NetworkInterface) obj;
                if (networkInterface.isUp() && !networkInterface.isLoopback()) {
                    z = true;
                }
                return Boolean.valueOf(z);
            case 18:
                return SequencesKt.asSequence(new VectorGroup.AnonymousClass1(((NetworkInterface) obj).getInetAddresses()));
            case 19:
                ((Boolean) obj).booleanValue();
                int i = QROverlayView.$r8$clinit;
                return Unit.INSTANCE;
            case 20:
                return Boolean.valueOf(obj == null);
            case 21:
                ClassSerialDescriptorBuilder classSerialDescriptorBuilder = (ClassSerialDescriptorBuilder) obj;
                final HazeStyleKt$$ExternalSyntheticLambda0 hazeStyleKt$$ExternalSyntheticLambda0 = new HazeStyleKt$$ExternalSyntheticLambda0(5);
                ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder, "JsonPrimitive", new SerialDescriptor(hazeStyleKt$$ExternalSyntheticLambda0) { // from class: kotlinx.serialization.json.JsonElementSerializersKt$defer$1
                    public final SynchronizedLazyImpl original$delegate;

                    {
                        this.original$delegate = new SynchronizedLazyImpl(hazeStyleKt$$ExternalSyntheticLambda0);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final List getAnnotations() {
                        return EmptyList.INSTANCE;
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final List getElementAnnotations(int i2) {
                        return getOriginal().getElementAnnotations(i2);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final SerialDescriptor getElementDescriptor(int i2) {
                        return getOriginal().getElementDescriptor(i2);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final int getElementIndex(String str2) {
                        return getOriginal().getElementIndex(str2);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final String getElementName(int i2) {
                        return getOriginal().getElementName(i2);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final int getElementsCount() {
                        return getOriginal().getElementsCount();
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final SerialKind getKind() {
                        return getOriginal().getKind();
                    }

                    public final SerialDescriptor getOriginal() {
                        return (SerialDescriptor) this.original$delegate.getValue();
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final String getSerialName() {
                        return getOriginal().getSerialName();
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final boolean isElementOptional(int i2) {
                        return getOriginal().isElementOptional(i2);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final boolean isInline() {
                        return false;
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final boolean isNullable() {
                        return false;
                    }
                });
                final HazeStyleKt$$ExternalSyntheticLambda0 hazeStyleKt$$ExternalSyntheticLambda1 = new HazeStyleKt$$ExternalSyntheticLambda0(6);
                ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder, "JsonNull", new SerialDescriptor(hazeStyleKt$$ExternalSyntheticLambda1) { // from class: kotlinx.serialization.json.JsonElementSerializersKt$defer$1
                    public final SynchronizedLazyImpl original$delegate;

                    {
                        this.original$delegate = new SynchronizedLazyImpl(hazeStyleKt$$ExternalSyntheticLambda1);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final List getAnnotations() {
                        return EmptyList.INSTANCE;
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final List getElementAnnotations(int i2) {
                        return getOriginal().getElementAnnotations(i2);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final SerialDescriptor getElementDescriptor(int i2) {
                        return getOriginal().getElementDescriptor(i2);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final int getElementIndex(String str2) {
                        return getOriginal().getElementIndex(str2);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final String getElementName(int i2) {
                        return getOriginal().getElementName(i2);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final int getElementsCount() {
                        return getOriginal().getElementsCount();
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final SerialKind getKind() {
                        return getOriginal().getKind();
                    }

                    public final SerialDescriptor getOriginal() {
                        return (SerialDescriptor) this.original$delegate.getValue();
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final String getSerialName() {
                        return getOriginal().getSerialName();
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final boolean isElementOptional(int i2) {
                        return getOriginal().isElementOptional(i2);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final boolean isInline() {
                        return false;
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final boolean isNullable() {
                        return false;
                    }
                });
                final HazeStyleKt$$ExternalSyntheticLambda0 hazeStyleKt$$ExternalSyntheticLambda2 = new HazeStyleKt$$ExternalSyntheticLambda0(7);
                ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder, "JsonLiteral", new SerialDescriptor(hazeStyleKt$$ExternalSyntheticLambda2) { // from class: kotlinx.serialization.json.JsonElementSerializersKt$defer$1
                    public final SynchronizedLazyImpl original$delegate;

                    {
                        this.original$delegate = new SynchronizedLazyImpl(hazeStyleKt$$ExternalSyntheticLambda2);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final List getAnnotations() {
                        return EmptyList.INSTANCE;
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final List getElementAnnotations(int i2) {
                        return getOriginal().getElementAnnotations(i2);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final SerialDescriptor getElementDescriptor(int i2) {
                        return getOriginal().getElementDescriptor(i2);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final int getElementIndex(String str2) {
                        return getOriginal().getElementIndex(str2);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final String getElementName(int i2) {
                        return getOriginal().getElementName(i2);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final int getElementsCount() {
                        return getOriginal().getElementsCount();
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final SerialKind getKind() {
                        return getOriginal().getKind();
                    }

                    public final SerialDescriptor getOriginal() {
                        return (SerialDescriptor) this.original$delegate.getValue();
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final String getSerialName() {
                        return getOriginal().getSerialName();
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final boolean isElementOptional(int i2) {
                        return getOriginal().isElementOptional(i2);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final boolean isInline() {
                        return false;
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final boolean isNullable() {
                        return false;
                    }
                });
                final HazeStyleKt$$ExternalSyntheticLambda0 hazeStyleKt$$ExternalSyntheticLambda3 = new HazeStyleKt$$ExternalSyntheticLambda0(8);
                ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder, "JsonObject", new SerialDescriptor(hazeStyleKt$$ExternalSyntheticLambda3) { // from class: kotlinx.serialization.json.JsonElementSerializersKt$defer$1
                    public final SynchronizedLazyImpl original$delegate;

                    {
                        this.original$delegate = new SynchronizedLazyImpl(hazeStyleKt$$ExternalSyntheticLambda3);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final List getAnnotations() {
                        return EmptyList.INSTANCE;
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final List getElementAnnotations(int i2) {
                        return getOriginal().getElementAnnotations(i2);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final SerialDescriptor getElementDescriptor(int i2) {
                        return getOriginal().getElementDescriptor(i2);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final int getElementIndex(String str2) {
                        return getOriginal().getElementIndex(str2);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final String getElementName(int i2) {
                        return getOriginal().getElementName(i2);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final int getElementsCount() {
                        return getOriginal().getElementsCount();
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final SerialKind getKind() {
                        return getOriginal().getKind();
                    }

                    public final SerialDescriptor getOriginal() {
                        return (SerialDescriptor) this.original$delegate.getValue();
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final String getSerialName() {
                        return getOriginal().getSerialName();
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final boolean isElementOptional(int i2) {
                        return getOriginal().isElementOptional(i2);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final boolean isInline() {
                        return false;
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final boolean isNullable() {
                        return false;
                    }
                });
                final HazeStyleKt$$ExternalSyntheticLambda0 hazeStyleKt$$ExternalSyntheticLambda4 = new HazeStyleKt$$ExternalSyntheticLambda0(9);
                ClassSerialDescriptorBuilder.element$default(classSerialDescriptorBuilder, "JsonArray", new SerialDescriptor(hazeStyleKt$$ExternalSyntheticLambda4) { // from class: kotlinx.serialization.json.JsonElementSerializersKt$defer$1
                    public final SynchronizedLazyImpl original$delegate;

                    {
                        this.original$delegate = new SynchronizedLazyImpl(hazeStyleKt$$ExternalSyntheticLambda4);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final List getAnnotations() {
                        return EmptyList.INSTANCE;
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final List getElementAnnotations(int i2) {
                        return getOriginal().getElementAnnotations(i2);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final SerialDescriptor getElementDescriptor(int i2) {
                        return getOriginal().getElementDescriptor(i2);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final int getElementIndex(String str2) {
                        return getOriginal().getElementIndex(str2);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final String getElementName(int i2) {
                        return getOriginal().getElementName(i2);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final int getElementsCount() {
                        return getOriginal().getElementsCount();
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final SerialKind getKind() {
                        return getOriginal().getKind();
                    }

                    public final SerialDescriptor getOriginal() {
                        return (SerialDescriptor) this.original$delegate.getValue();
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final String getSerialName() {
                        return getOriginal().getSerialName();
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final boolean isElementOptional(int i2) {
                        return getOriginal().isElementOptional(i2);
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final boolean isInline() {
                        return false;
                    }

                    @Override // kotlinx.serialization.descriptors.SerialDescriptor
                    public final boolean isNullable() {
                        return false;
                    }
                });
                return Unit.INSTANCE;
            default:
                Map.Entry entry = (Map.Entry) obj;
                String str2 = (String) entry.getKey();
                JsonElement jsonElement = (JsonElement) entry.getValue();
                StringBuilder sb = new StringBuilder();
                StringOpsKt.printQuoted(sb, str2);
                sb.append(':');
                sb.append(jsonElement);
                return sb.toString();
        }
    }
}
