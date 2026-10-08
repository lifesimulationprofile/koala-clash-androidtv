package kotlinx.serialization.json;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class JsonConfiguration {
    public final String classDiscriminator;
    public final int classDiscriminatorMode;
    public final boolean explicitNulls;
    public final boolean ignoreUnknownKeys;
    public final String prettyPrintIndent;
    public final boolean useAlternativeNames;

    public JsonConfiguration(boolean z, boolean z2, String str, String str2, boolean z3, int i) {
        this.ignoreUnknownKeys = z;
        this.explicitNulls = z2;
        this.prettyPrintIndent = str;
        this.classDiscriminator = str2;
        this.useAlternativeNames = z3;
        this.classDiscriminatorMode = i;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("JsonConfiguration(encodeDefaults=false, ignoreUnknownKeys=");
        sb.append(this.ignoreUnknownKeys);
        sb.append(", isLenient=false, allowStructuredMapKeys=false, prettyPrint=false, explicitNulls=");
        sb.append(this.explicitNulls);
        sb.append(", prettyPrintIndent='");
        sb.append(this.prettyPrintIndent);
        sb.append("', coerceInputValues=false, useArrayPolymorphism=false, classDiscriminator='");
        sb.append(this.classDiscriminator);
        sb.append("', allowSpecialFloatingPointValues=false, useAlternativeNames=");
        sb.append(this.useAlternativeNames);
        sb.append(", namingStrategy=null, decodeEnumsCaseInsensitive=false, allowTrailingComma=false, allowComments=false, classDiscriminatorMode=");
        int i = this.classDiscriminatorMode;
        if (i == 1) {
            str = "NONE";
        } else if (i != 2) {
            str = i != 3 ? "null" : "POLYMORPHIC";
        } else {
            str = "ALL_JSON_OBJECTS";
        }
        sb.append(str);
        sb.append(')');
        return sb.toString();
    }
}
