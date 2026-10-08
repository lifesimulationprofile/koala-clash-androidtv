package com.github.kr328.clash.service;

import com.github.kr328.clash.log.LogcatReader$$ExternalSyntheticLambda3;
import java.io.File;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ProfileProcessor$resolve$1 extends ContinuationImpl {
    public ProfileProcessor L$0;
    public Object L$1;
    public String L$2;
    public File L$3;
    public LogcatReader$$ExternalSyntheticLambda3 L$4;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        ProfileProcessor profileProcessor = ProfileProcessor.INSTANCE;
        return ProfileProcessor.access$resolve(null, null, null, null, null, this);
    }
}
