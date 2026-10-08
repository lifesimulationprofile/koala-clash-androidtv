package kotlinx.coroutines.internal;

import androidx.compose.ui.Modifier;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class Symbol implements SupportSQLiteQuery {
    public final /* synthetic */ int $r8$classId;
    public String symbol;

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public String getSql() {
        return this.symbol;
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 0:
                return Modifier.CC.m(new StringBuilder("<"), this.symbol, '>');
            default:
                return super.toString();
        }
    }

    public /* synthetic */ Symbol(String str, int i) {
        this.$r8$classId = i;
        this.symbol = str;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
    }
}
