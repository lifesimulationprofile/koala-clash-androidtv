package kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.EmptyMap;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonNames;
import kotlinx.serialization.json.internal.WriteModeKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class EnumSerializer$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ EnumSerializer$$ExternalSyntheticLambda0(int i, Object obj, Object obj2) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        String[] strArrNames;
        switch (this.$r8$classId) {
            case 0:
                EnumSerializer enumSerializer = (EnumSerializer) this.f$0;
                String str = (String) this.f$1;
                enumSerializer.getClass();
                Enum[] enumArr = (Enum[]) enumSerializer.values;
                EnumDescriptor enumDescriptor = new EnumDescriptor(str, enumArr.length);
                for (Enum r0 : enumArr) {
                    enumDescriptor.addElement(r0.name(), false);
                }
                return enumDescriptor;
            default:
                SerialDescriptor serialDescriptor = (SerialDescriptor) this.f$0;
                Json json = (Json) this.f$1;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                JsonConfiguration jsonConfiguration = json.configuration;
                WriteModeKt.namingStrategy(serialDescriptor, json);
                int elementsCount = serialDescriptor.getElementsCount();
                for (int i = 0; i < elementsCount; i++) {
                    List elementAnnotations = serialDescriptor.getElementAnnotations(i);
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : elementAnnotations) {
                        if (obj instanceof JsonNames) {
                            arrayList.add(obj);
                        }
                    }
                    JsonNames jsonNames = (JsonNames) (arrayList.size() == 1 ? arrayList.get(0) : null);
                    if (jsonNames != null && (strArrNames = jsonNames.names()) != null) {
                        for (String str2 : strArrNames) {
                            String str3 = Intrinsics.areEqual(serialDescriptor.getKind(), SerialKind.ENUM.INSTANCE) ? "enum value" : "property";
                            if (linkedHashMap.containsKey(str2)) {
                                throw new UnknownFieldException("The suggested name '" + str2 + "' for " + str3 + ' ' + serialDescriptor.getElementName(i) + " is already one of the names for " + str3 + ' ' + serialDescriptor.getElementName(((Number) MapsKt__MapsKt.getValue(str2, linkedHashMap)).intValue()) + " in " + serialDescriptor);
                            }
                            linkedHashMap.put(str2, Integer.valueOf(i));
                        }
                    }
                }
                return linkedHashMap.isEmpty() ? EmptyMap.INSTANCE : linkedHashMap;
        }
    }
}
