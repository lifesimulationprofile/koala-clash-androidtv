package com.github.kr328.clash.util;

import androidx.compose.ui.graphics.vector.VectorGroup;
import com.github.kr328.clash.remote.Remote$$ExternalSyntheticLambda1;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import kotlin.io.FileTreeWalk;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.FilteringSequence;
import kotlin.sequences.GeneratorSequence;
import kotlin.sequences.SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt$flatMap$2;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class LocalNetworkKt {
    public static final String getLocalIpAddress() {
        Object next;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                return null;
            }
            FilteringSequence filteringSequenceFilter = SequencesKt.filter(SequencesKt.asSequence(new VectorGroup.AnonymousClass1(networkInterfaces)), new Remote$$ExternalSyntheticLambda1(17));
            Remote$$ExternalSyntheticLambda1 remote$$ExternalSyntheticLambda1 = new Remote$$ExternalSyntheticLambda1(18);
            int i = SequencesKt___SequencesKt$flatMap$2.$r8$clinit;
            FileTreeWalk.FileTreeWalkIterator fileTreeWalkIterator = new FileTreeWalk.FileTreeWalkIterator(new GeneratorSequence(filteringSequenceFilter, (Function1) remote$$ExternalSyntheticLambda1));
            while (true) {
                if (!fileTreeWalkIterator.hasNext()) {
                    next = null;
                    break;
                }
                next = fileTreeWalkIterator.next();
                InetAddress inetAddress = (InetAddress) next;
                if ((inetAddress instanceof Inet4Address) && !((Inet4Address) inetAddress).isLoopbackAddress()) {
                    break;
                }
            }
            InetAddress inetAddress2 = (InetAddress) next;
            if (inetAddress2 != null) {
                return inetAddress2.getHostAddress();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
