package kotlin.text;

import androidx.collection.LruCache;
import androidx.compose.runtime.GapComposer;
import androidx.compose.runtime.Stack;
import androidx.compose.ui.graphics.AndroidRenderEffect;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerImpl;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.tracing.Trace;
import com.google.android.gms.internal.mlkit_vision_common.zzjo;
import dev.chrisbanes.haze.HazeEffectNode;
import dev.chrisbanes.haze.HazeEffectNodeKt;
import dev.chrisbanes.haze.RenderEffectBlurEffect;
import dev.chrisbanes.haze.RenderEffectParams;
import dev.chrisbanes.haze.RenderEffect_androidKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.internal.SafeCollector;
import kotlinx.coroutines.internal.ScopeCoroutine;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class StringsKt__StringsKt$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ StringsKt__StringsKt$$ExternalSyntheticLambda0(int i, Object obj) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x020c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:102:0x020e A[LOOP:3: B:91:0x01df->B:102:0x020e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:111:0x01c8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:112:0x017a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:117:0x0202 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:118:0x017a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x017a  */
    /* JADX WARN: Code duplicated, block: B:84:0x01d2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:85:0x01d4 A[LOOP:1: B:74:0x01a4->B:85:0x01d4, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:8:0x002a  */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        Object next;
        String str;
        Pair pair;
        String str2;
        Object next2;
        String str3;
        String str4;
        switch (this.$r8$classId) {
            case 0:
                List list = (List) this.f$0;
                CharSequence charSequence = (CharSequence) obj;
                int iIntValue = ((Integer) obj2).intValue();
                if (list.size() == 1) {
                    String str5 = (String) CollectionsKt.single(list);
                    int iIndexOf$default = StringsKt.indexOf$default(charSequence, str5, iIntValue, false, 4);
                    if (iIndexOf$default < 0) {
                        pair = null;
                    } else {
                        pair = new Pair(Integer.valueOf(iIndexOf$default), str5);
                    }
                } else {
                    if (iIntValue < 0) {
                        iIntValue = 0;
                    }
                    IntRange intRange = new IntRange(iIntValue, charSequence.length(), 1);
                    boolean z = charSequence instanceof String;
                    int i = intRange.step;
                    int i2 = intRange.last;
                    if (z) {
                        if ((i <= 0 || iIntValue > i2) && (i >= 0 || i2 > iIntValue)) {
                            pair = null;
                        } else {
                            while (true) {
                                Iterator it = list.iterator();
                                do {
                                    if (it.hasNext()) {
                                        next2 = it.next();
                                        str4 = (String) next2;
                                    } else {
                                        next2 = null;
                                    }
                                    str3 = (String) next2;
                                    if (str3 != null) {
                                        pair = new Pair(Integer.valueOf(iIntValue), str3);
                                    } else if (iIntValue != i2) {
                                        iIntValue += i;
                                    } else {
                                        pair = null;
                                    }
                                } while (!str4.regionMatches(0, (String) charSequence, iIntValue, str4.length()));
                                str3 = (String) next2;
                                if (str3 != null) {
                                    pair = new Pair(Integer.valueOf(iIntValue), str3);
                                } else if (iIntValue != i2) {
                                    iIntValue += i;
                                } else {
                                    pair = null;
                                }
                            }
                        }
                    } else if ((i <= 0 || iIntValue > i2) && (i >= 0 || i2 > iIntValue)) {
                        pair = null;
                    } else {
                        int i3 = iIntValue;
                        while (true) {
                            Iterator it2 = list.iterator();
                            do {
                                if (it2.hasNext()) {
                                    next = it2.next();
                                    str2 = (String) next;
                                } else {
                                    next = null;
                                }
                                str = (String) next;
                                if (str != null) {
                                    pair = new Pair(Integer.valueOf(i3), str);
                                } else if (i3 != i2) {
                                    i3 += i;
                                } else {
                                    pair = null;
                                }
                            } while (!StringsKt.regionMatchesImpl(str2, 0, charSequence, i3, str2.length(), false));
                            str = (String) next;
                            if (str != null) {
                                pair = new Pair(Integer.valueOf(i3), str);
                            } else if (i3 != i2) {
                                i3 += i;
                            } else {
                                pair = null;
                            }
                        }
                    }
                }
                if (pair != null) {
                    return new Pair(pair.first, Integer.valueOf(((String) pair.second).length()));
                }
                return null;
            case 1:
                ((Integer) obj2).getClass();
                zzjo.PreferenceLeadingIcon((ImageVector) this.f$0, (GapComposer) obj, Stack.updateChangedFlags(1));
                return Unit.INSTANCE;
            case 2:
                RenderEffectBlurEffect renderEffectBlurEffect = (RenderEffectBlurEffect) this.f$0;
                DrawScope drawScope = (DrawScope) obj;
                GraphicsLayer graphicsLayer = (GraphicsLayer) obj2;
                HazeEffectNode hazeEffectNode = renderEffectBlurEffect.node;
                if (renderEffectBlurEffect.renderEffect == null || (hazeEffectNode.dirtyTracker & 907003) != 0) {
                    float fM824calculateInputScaleFactor3ABfNKs$default = HazeEffectNodeKt.m824calculateInputScaleFactor3ABfNKs$default(hazeEffectNode);
                    float fResolveBlurRadius = HazeEffectNodeKt.resolveBlurRadius(hazeEffectNode);
                    if (Float.isNaN(fResolveBlurRadius)) {
                        fResolveBlurRadius = 0;
                    }
                    float fResolveNoiseFactor = HazeEffectNodeKt.resolveNoiseFactor(hazeEffectNode);
                    List listResolveTints = HazeEffectNodeKt.resolveTints(hazeEffectNode);
                    long j = hazeEffectNode.size;
                    long j2 = hazeEffectNode.layerOffset;
                    int i4 = Intrinsics.areEqual(hazeEffectNode.blurredEdgeTreatment, null) ? 3 : 0;
                    Trace.beginSection("HazeEffectNode-getOrCreateRenderEffect");
                    try {
                        RenderEffectParams renderEffectParams = new RenderEffectParams(fResolveBlurRadius, fResolveNoiseFactor, fM824calculateInputScaleFactor3ABfNKs$default, j, j2, listResolveTints, 1.0f, null, i4);
                        ?? r7 = HazeEffectNodeKt.renderEffectCache$delegate;
                        AndroidRenderEffect androidRenderEffectCreateRenderEffect = (AndroidRenderEffect) ((LruCache) r7.getValue()).get(renderEffectParams);
                        if (androidRenderEffectCreateRenderEffect == null) {
                            androidRenderEffectCreateRenderEffect = RenderEffect_androidKt.createRenderEffect(hazeEffectNode, renderEffectParams);
                            if (androidRenderEffectCreateRenderEffect != null) {
                                ((LruCache) r7.getValue()).put(renderEffectParams, androidRenderEffectCreateRenderEffect);
                            } else {
                                androidRenderEffectCreateRenderEffect = null;
                            }
                            break;
                        }
                        android.os.Trace.endSection();
                        renderEffectBlurEffect.renderEffect = androidRenderEffectCreateRenderEffect;
                    } catch (Throwable th) {
                        android.os.Trace.endSection();
                        throw th;
                    }
                }
                AndroidRenderEffect androidRenderEffect = renderEffectBlurEffect.renderEffect;
                GraphicsLayerImpl graphicsLayerImpl = graphicsLayer.impl;
                if (!Intrinsics.areEqual(graphicsLayerImpl.getRenderEffect(), androidRenderEffect)) {
                    graphicsLayerImpl.setRenderEffect(androidRenderEffect);
                }
                graphicsLayer.setAlpha(hazeEffectNode.alpha);
                GraphicsLayerKt.drawLayer(drawScope, graphicsLayer);
                return Unit.INSTANCE;
            case 3:
                int iIndexOfAny = StringsKt.indexOfAny((CharSequence) obj, (char[]) this.f$0, ((Integer) obj2).intValue(), false);
                if (iIndexOfAny < 0) {
                    return null;
                }
                return new Pair(Integer.valueOf(iIndexOfAny), 1);
            default:
                SafeCollector safeCollector = (SafeCollector) this.f$0;
                int iIntValue2 = ((Integer) obj).intValue();
                CoroutineContext.Element element = (CoroutineContext.Element) obj2;
                CoroutineContext.Key key = element.getKey();
                CoroutineContext.Element element2 = safeCollector.collectContext.get(key);
                if (key == Job.Key.$$INSTANCE) {
                    Job job = (Job) element2;
                    Job parent = (Job) element;
                    while (true) {
                        if (parent == null) {
                            parent = null;
                        } else if (parent != job && (parent instanceof ScopeCoroutine)) {
                            parent = ((ScopeCoroutine) parent).getParent();
                        }
                    }
                    if (parent != job) {
                        throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + parent + ", expected child of " + job + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
                    }
                    if (job != null) {
                        iIntValue2++;
                    }
                } else if (element != element2) {
                    iIntValue2 = Integer.MIN_VALUE;
                } else {
                    iIntValue2++;
                }
                return Integer.valueOf(iIntValue2);
        }
    }

    public /* synthetic */ StringsKt__StringsKt$$ExternalSyntheticLambda0(ImageVector imageVector, int i) {
        this.$r8$classId = 1;
        this.f$0 = imageVector;
    }
}
