package com.github.kr328.clash;

import android.graphics.Path;
import android.net.Uri;
import androidx.compose.animation.core.Transition;
import androidx.compose.material3.CheckDrawingCache;
import androidx.compose.material3.CheckboxKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPathMeasure;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.util.MathHelpersKt;
import com.github.kr328.clash.design.model.File;
import com.github.kr328.clash.remote.FilesClient;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class FilesActivity$$ExternalSyntheticLambda3 implements Function1 {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ State f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Object f$4;
    public final /* synthetic */ Object f$5;
    public final /* synthetic */ Object f$6;
    public final /* synthetic */ Object f$7;

    public /* synthetic */ FilesActivity$$ExternalSyntheticLambda3(State state, State state2, Stroke stroke, State state3, Transition.TransitionAnimationState transitionAnimationState, Transition.TransitionAnimationState transitionAnimationState2, Stroke stroke2, CheckDrawingCache checkDrawingCache) {
        this.f$0 = state;
        this.f$1 = state2;
        this.f$7 = stroke;
        this.f$2 = state3;
        this.f$3 = transitionAnimationState;
        this.f$4 = transitionAnimationState2;
        this.f$5 = stroke2;
        this.f$6 = checkDrawingCache;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i = this.$r8$classId;
        Object obj2 = this.f$7;
        Object obj3 = this.f$6;
        Object obj4 = this.f$4;
        Object obj5 = this.f$5;
        Object obj6 = this.f$3;
        Object obj7 = this.f$2;
        State state = this.f$1;
        Object obj8 = this.f$0;
        switch (i) {
            case 0:
                int i2 = FilesActivity.$r8$clinit;
                ((MutableState) state).setValue(null);
                JobKt.launch$default((CoroutineScope) obj8, null, new FilesActivity$Content$5$1$1$1((FilesActivity) obj7, (FilesClient) obj6, (SnapshotStateList) obj4, (Uri) obj5, (String) obj, (String) obj3, (MutableState) obj2, (Continuation) null), 3);
                break;
            case 1:
                Stroke stroke = (Stroke) obj2;
                State state2 = (State) obj7;
                State state3 = (State) obj6;
                State state4 = (State) obj4;
                Stroke stroke2 = (Stroke) obj5;
                CheckDrawingCache checkDrawingCache = (CheckDrawingCache) obj3;
                DrawScope drawScope = (DrawScope) obj;
                long j = ((Color) ((State) obj8).getValue()).value;
                long j2 = ((Color) state.getValue()).value;
                float fMo92toPx0680j_4 = drawScope.mo92toPx0680j_4(CheckboxKt.RadiusSize);
                float f = stroke.width;
                float f2 = f / 2.0f;
                float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.mo474getSizeNHjbRc() >> 32));
                boolean zM435equalsimpl0 = Color.m435equalsimpl0(j, j2);
                Fill fill = Fill.INSTANCE;
                if (zM435equalsimpl0) {
                    drawScope.mo472drawRoundRectuAw5IA(j, (226 & 2) != 0 ? 0L : 0L, (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) & 4294967295L), (((long) Float.floatToRawIntBits(fMo92toPx0680j_4)) << 32) | (((long) Float.floatToRawIntBits(fMo92toPx0680j_4)) & 4294967295L), fill);
                } else {
                    long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f)) & 4294967295L);
                    float f3 = fIntBitsToFloat - (2 * f);
                    long jFloatToRawIntBits2 = (((long) Float.floatToRawIntBits(f3)) << 32) | (((long) Float.floatToRawIntBits(f3)) & 4294967295L);
                    float fMax = Math.max(0.0f, fMo92toPx0680j_4 - f);
                    drawScope.mo472drawRoundRectuAw5IA(j, (226 & 2) != 0 ? 0L : jFloatToRawIntBits, jFloatToRawIntBits2, (((long) Float.floatToRawIntBits(fMax)) << 32) | (((long) Float.floatToRawIntBits(fMax)) & 4294967295L), fill);
                    float f4 = fIntBitsToFloat - f;
                    float f5 = fMo92toPx0680j_4 - f2;
                    drawScope.mo472drawRoundRectuAw5IA(j2, (226 & 2) != 0 ? 0L : (((long) Float.floatToRawIntBits(f2)) << 32) | (((long) Float.floatToRawIntBits(f2)) & 4294967295L), (((long) Float.floatToRawIntBits(f4)) << 32) | (((long) Float.floatToRawIntBits(f4)) & 4294967295L), (((long) Float.floatToRawIntBits(f5)) << 32) | (((long) Float.floatToRawIntBits(f5)) & 4294967295L), stroke);
                }
                long j3 = ((Color) state2.getValue()).value;
                float fFloatValue = ((Number) state3.getValue()).floatValue();
                float fFloatValue2 = ((Number) state4.getValue()).floatValue();
                float fIntBitsToFloat2 = Float.intBitsToFloat((int) (drawScope.mo474getSizeNHjbRc() >> 32));
                float fLerp = MathHelpersKt.lerp(0.4f, 0.5f, fFloatValue2);
                float fLerp2 = MathHelpersKt.lerp(0.7f, 0.5f, fFloatValue2);
                float fLerp3 = MathHelpersKt.lerp(0.5f, 0.5f, fFloatValue2);
                float fLerp4 = MathHelpersKt.lerp(0.3f, 0.5f, fFloatValue2);
                checkDrawingCache.checkPath.internalPath.rewind();
                AndroidPath androidPath = checkDrawingCache.checkPath;
                Path path = androidPath.internalPath;
                Path path2 = androidPath.internalPath;
                path.moveTo(0.2f * fIntBitsToFloat2, fLerp3 * fIntBitsToFloat2);
                path2.lineTo(fLerp * fIntBitsToFloat2, fLerp2 * fIntBitsToFloat2);
                path2.lineTo(0.8f * fIntBitsToFloat2, fIntBitsToFloat2 * fLerp4);
                AndroidPathMeasure androidPathMeasure = checkDrawingCache.pathMeasure;
                androidPathMeasure.internalPathMeasure.setPath(androidPath != null ? androidPath.internalPath : null, false);
                AndroidPath androidPath2 = checkDrawingCache.pathToDraw;
                androidPath2.internalPath.rewind();
                androidPathMeasure.getSegment(0.0f, androidPathMeasure.internalPathMeasure.getLength() * fFloatValue, androidPath2);
                Modifier.CC.m313drawPathLG529CI$default(drawScope, checkDrawingCache.pathToDraw, j3, stroke2, 52);
                break;
            default:
                int i3 = FilesActivity.$r8$clinit;
                ((MutableState) state).setValue(null);
                JobKt.launch$default((CoroutineScope) obj8, null, new FilesActivity$Content$5$1$1$1((FilesActivity) obj7, (FilesClient) obj6, (File) obj5, (String) obj, (SnapshotStateList) obj4, (String) obj3, (MutableState) obj2, (Continuation) null), 3);
                break;
        }
        return Unit.INSTANCE;
    }

    public /* synthetic */ FilesActivity$$ExternalSyntheticLambda3(CoroutineScope coroutineScope, MutableState mutableState, FilesActivity filesActivity, FilesClient filesClient, SnapshotStateList snapshotStateList, Uri uri, String str, MutableState mutableState2) {
        this.f$0 = coroutineScope;
        this.f$1 = mutableState;
        this.f$2 = filesActivity;
        this.f$3 = filesClient;
        this.f$4 = snapshotStateList;
        this.f$5 = uri;
        this.f$6 = str;
        this.f$7 = mutableState2;
    }

    public /* synthetic */ FilesActivity$$ExternalSyntheticLambda3(CoroutineScope coroutineScope, MutableState mutableState, FilesActivity filesActivity, FilesClient filesClient, File file, SnapshotStateList snapshotStateList, String str, MutableState mutableState2) {
        this.f$0 = coroutineScope;
        this.f$1 = mutableState;
        this.f$2 = filesActivity;
        this.f$3 = filesClient;
        this.f$5 = file;
        this.f$4 = snapshotStateList;
        this.f$6 = str;
        this.f$7 = mutableState2;
    }
}
