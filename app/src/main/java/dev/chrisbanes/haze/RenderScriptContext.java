package dev.chrisbanes.haze;

import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.renderscript.Type;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.flow.internal.ChannelFlow;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class RenderScriptContext {
    public final ScriptIntrinsicBlur blurScript;
    public final BufferedChannel channel = ChannelKt.Channel$default(-1, 0, 6);
    public final Allocation inputAlloc;
    public boolean isDestroyed;
    public final Allocation outputAlloc;
    public final Bitmap outputBitmap;
    public final RenderScript rs;
    public final long size;

    public RenderScriptContext(RenderScript renderScript, long j) {
        this.rs = renderScript;
        this.size = j;
        int i = (int) (j >> 32);
        int i2 = (i % 4) + i;
        int i3 = (int) (j & 4294967295L);
        int i4 = (i3 % 4) + i3;
        Allocation allocationCreateTyped = Allocation.createTyped(renderScript, new Type.Builder(renderScript, Element.U8_4(renderScript)).setX(i2).setY(i4).create(), 33);
        this.inputAlloc = allocationCreateTyped;
        allocationCreateTyped.setOnBufferAvailableListener(new Allocation.OnBufferAvailableListener() { // from class: dev.chrisbanes.haze.RenderScriptContext$$ExternalSyntheticLambda0
            @Override // android.renderscript.Allocation.OnBufferAvailableListener
            public final void onBufferAvailable(Allocation allocation) {
                RenderScriptContext renderScriptContext = this.f$0;
                if (renderScriptContext.isDestroyed) {
                    return;
                }
                allocation.ioReceive();
                BufferedChannel bufferedChannel = renderScriptContext.channel;
                Unit unit = Unit.INSTANCE;
                Object objMo842trySendJP2dKIU = bufferedChannel.mo842trySendJP2dKIU(unit);
                if (!(objMo842trySendJP2dKIU instanceof ChannelResult.Failed)) {
                    return;
                }
                Object obj = ((ChannelResult) JobKt.runBlocking(EmptyCoroutineContext.INSTANCE, new ChannelFlow.AnonymousClass2(bufferedChannel, unit, null, 7))).holder;
            }
        });
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i4, Bitmap.Config.ARGB_8888);
        this.outputBitmap = bitmapCreateBitmap;
        this.outputAlloc = Allocation.createFromBitmap(renderScript, bitmapCreateBitmap);
        ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
        this.blurScript = scriptIntrinsicBlurCreate;
        scriptIntrinsicBlurCreate.setInput(allocationCreateTyped);
    }
}
