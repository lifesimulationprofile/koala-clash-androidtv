package androidx.camera.core.impl;

import android.util.ArrayMap;
import androidx.camera.camera2.interop.CaptureRequestOptions$Builder$$ExternalSyntheticLambda0;
import androidx.camera.core.Preview;
import androidx.compose.ui.node.LayoutNode$$ExternalSyntheticLambda0;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public class OptionsBundle implements Config {
    public static final OptionsBundle EMPTY_BUNDLE;
    public static final LayoutNode$$ExternalSyntheticLambda0 ID_COMPARE;
    public final TreeMap mOptions;

    static {
        LayoutNode$$ExternalSyntheticLambda0 layoutNode$$ExternalSyntheticLambda0 = new LayoutNode$$ExternalSyntheticLambda0(2);
        ID_COMPARE = layoutNode$$ExternalSyntheticLambda0;
        EMPTY_BUNDLE = new OptionsBundle(new TreeMap(layoutNode$$ExternalSyntheticLambda0));
    }

    public OptionsBundle(TreeMap treeMap) {
        this.mOptions = treeMap;
    }

    public static OptionsBundle from(Config config) {
        if (OptionsBundle.class.equals(config.getClass())) {
            return (OptionsBundle) config;
        }
        TreeMap treeMap = new TreeMap(ID_COMPARE);
        for (AutoValue_Config_Option autoValue_Config_Option : config.listOptions()) {
            Set<Config.OptionPriority> priorities = config.getPriorities(autoValue_Config_Option);
            ArrayMap arrayMap = new ArrayMap();
            for (Config.OptionPriority optionPriority : priorities) {
                arrayMap.put(optionPriority, config.retrieveOptionWithPriority(autoValue_Config_Option, optionPriority));
            }
            treeMap.put(autoValue_Config_Option, arrayMap);
        }
        return new OptionsBundle(treeMap);
    }

    @Override // androidx.camera.core.impl.Config
    public final boolean containsOption(AutoValue_Config_Option autoValue_Config_Option) {
        return this.mOptions.containsKey(autoValue_Config_Option);
    }

    @Override // androidx.camera.core.impl.Config
    public final void findOptions(CaptureRequestOptions$Builder$$ExternalSyntheticLambda0 captureRequestOptions$Builder$$ExternalSyntheticLambda0) {
        for (Map.Entry entry : this.mOptions.tailMap(new AutoValue_Config_Option("camera2.captureRequest.option.", Void.class, null)).entrySet()) {
            if (!((AutoValue_Config_Option) entry.getKey()).id.startsWith("camera2.captureRequest.option.")) {
                return;
            }
            AutoValue_Config_Option autoValue_Config_Option = (AutoValue_Config_Option) entry.getKey();
            Preview.Builder builder = (Preview.Builder) captureRequestOptions$Builder$$ExternalSyntheticLambda0.f$0;
            Config config = (Config) captureRequestOptions$Builder$$ExternalSyntheticLambda0.f$1;
            builder.mMutableConfig.insertOption(autoValue_Config_Option, config.getOptionPriority(autoValue_Config_Option), config.retrieveOption(autoValue_Config_Option));
        }
    }

    @Override // androidx.camera.core.impl.Config
    public final Config.OptionPriority getOptionPriority(AutoValue_Config_Option autoValue_Config_Option) {
        Map map = (Map) this.mOptions.get(autoValue_Config_Option);
        if (map != null) {
            return (Config.OptionPriority) Collections.min(map.keySet());
        }
        throw new IllegalArgumentException("Option does not exist: " + autoValue_Config_Option);
    }

    @Override // androidx.camera.core.impl.Config
    public final Set getPriorities(AutoValue_Config_Option autoValue_Config_Option) {
        Map map = (Map) this.mOptions.get(autoValue_Config_Option);
        return map == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(map.keySet());
    }

    @Override // androidx.camera.core.impl.Config
    public final Set listOptions() {
        return Collections.unmodifiableSet(this.mOptions.keySet());
    }

    @Override // androidx.camera.core.impl.Config
    public final Object retrieveOption(AutoValue_Config_Option autoValue_Config_Option) {
        Map map = (Map) this.mOptions.get(autoValue_Config_Option);
        if (map != null) {
            return map.get((Config.OptionPriority) Collections.min(map.keySet()));
        }
        throw new IllegalArgumentException("Option does not exist: " + autoValue_Config_Option);
    }

    @Override // androidx.camera.core.impl.Config
    public final Object retrieveOptionWithPriority(AutoValue_Config_Option autoValue_Config_Option, Config.OptionPriority optionPriority) {
        Map map = (Map) this.mOptions.get(autoValue_Config_Option);
        if (map == null) {
            throw new IllegalArgumentException("Option does not exist: " + autoValue_Config_Option);
        }
        if (map.containsKey(optionPriority)) {
            return map.get(optionPriority);
        }
        throw new IllegalArgumentException("Option does not exist: " + autoValue_Config_Option + " with priority=" + optionPriority);
    }

    @Override // androidx.camera.core.impl.Config
    public final Object retrieveOption(AutoValue_Config_Option autoValue_Config_Option, Object obj) {
        try {
            return retrieveOption(autoValue_Config_Option);
        } catch (IllegalArgumentException unused) {
            return obj;
        }
    }
}
