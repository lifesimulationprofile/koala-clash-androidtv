package kotlinx.serialization.json.internal;

import coil.memory.RealWeakMemoryCache;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ComposerForUnquotedLiterals extends Composer {
    public final boolean forceQuoting;

    public ComposerForUnquotedLiterals(RealWeakMemoryCache realWeakMemoryCache, boolean z) {
        super(realWeakMemoryCache);
        this.forceQuoting = z;
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public final void printQuoted(String str) {
        if (this.forceQuoting) {
            super.printQuoted(str);
        } else {
            print(str);
        }
    }
}
