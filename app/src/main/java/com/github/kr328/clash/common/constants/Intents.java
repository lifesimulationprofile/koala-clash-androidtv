package com.github.kr328.clash.common.constants;

import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import com.github.kr328.clash.common.util.GlobalKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class Intents {
    public static final String ACTION_CLASH_REQUEST_STOP;
    public static final String ACTION_CLASH_STARTED;
    public static final String ACTION_CLASH_STOPPED;
    public static final String ACTION_MODE_CHANGED;
    public static final String ACTION_PROFILE_CHANGED;
    public static final String ACTION_PROFILE_LOADED;
    public static final String ACTION_PROFILE_REQUEST_UPDATE;
    public static final String ACTION_PROFILE_SCHEDULE_UPDATES;
    public static final String ACTION_PROFILE_UPDATE_COMPLETED;
    public static final String ACTION_PROFILE_UPDATE_FAILED;
    public static final String ACTION_SERVICE_RECREATED;
    public static final String ACTION_START_CLASH;
    public static final String ACTION_STOP_CLASH;
    public static final String ACTION_TOGGLE_CLASH;

    static {
        String str = GlobalKt.packageName;
        ACTION_START_CLASH = ImageAnalysis$$ExternalSyntheticLambda1.m(str, ".action.START_CLASH");
        ACTION_STOP_CLASH = ImageAnalysis$$ExternalSyntheticLambda1.m(str, ".action.STOP_CLASH");
        ACTION_TOGGLE_CLASH = ImageAnalysis$$ExternalSyntheticLambda1.m(str, ".action.TOGGLE_CLASH");
        ACTION_SERVICE_RECREATED = ImageAnalysis$$ExternalSyntheticLambda1.m(str, ".intent.action.CLASH_RECREATED");
        ACTION_CLASH_STARTED = ImageAnalysis$$ExternalSyntheticLambda1.m(str, ".intent.action.CLASH_STARTED");
        ACTION_CLASH_STOPPED = ImageAnalysis$$ExternalSyntheticLambda1.m(str, ".intent.action.CLASH_STOPPED");
        ACTION_CLASH_REQUEST_STOP = ImageAnalysis$$ExternalSyntheticLambda1.m(str, ".intent.action.CLASH_REQUEST_STOP");
        ACTION_PROFILE_CHANGED = ImageAnalysis$$ExternalSyntheticLambda1.m(str, ".intent.action.PROFILE_CHANGED");
        ACTION_PROFILE_UPDATE_COMPLETED = ImageAnalysis$$ExternalSyntheticLambda1.m(str, ".intent.action.PROFILE_UPDATE_COMPLETED");
        ACTION_PROFILE_UPDATE_FAILED = ImageAnalysis$$ExternalSyntheticLambda1.m(str, ".intent.action.PROFILE_UPDATE_FAILED");
        ACTION_PROFILE_REQUEST_UPDATE = ImageAnalysis$$ExternalSyntheticLambda1.m(str, ".intent.action.REQUEST_UPDATE");
        ACTION_PROFILE_SCHEDULE_UPDATES = ImageAnalysis$$ExternalSyntheticLambda1.m(str, ".intent.action.SCHEDULE_UPDATES");
        ACTION_PROFILE_LOADED = ImageAnalysis$$ExternalSyntheticLambda1.m(str, ".intent.action.PROFILE_LOADED");
        ACTION_MODE_CHANGED = ImageAnalysis$$ExternalSyntheticLambda1.m(str, ".intent.action.MODE_CHANGED");
    }
}
