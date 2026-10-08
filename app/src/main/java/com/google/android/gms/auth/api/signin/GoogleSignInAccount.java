package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.fragment.app.FragmentState;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.internal.mlkit_vision_common.zzkp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new FragmentState.AnonymousClass1(16);
    public final int zab;
    public final List zac;
    public final String zad;
    public final String zae;
    public final String zaf;
    public final String zag;
    public final Uri zah;
    public String zai;
    public final long zaj;
    public final String zak;
    public final String zal;
    public final String zam;
    public final HashSet zan = new HashSet();

    public GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, ArrayList arrayList, String str7, String str8) {
        this.zab = i;
        this.zad = str;
        this.zae = str2;
        this.zaf = str3;
        this.zag = str4;
        this.zah = uri;
        this.zai = str5;
        this.zaj = j;
        this.zak = str6;
        this.zac = arrayList;
        this.zal = str7;
        this.zam = str8;
    }

    public static GoogleSignInAccount zab(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("photoUrl");
        Uri uri = !TextUtils.isEmpty(strOptString) ? Uri.parse(strOptString) : null;
        long j = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i), 1));
        }
        String strOptString2 = jSONObject.optString("id");
        String strOptString3 = jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null;
        String strOptString4 = jSONObject.has("email") ? jSONObject.optString("email") : null;
        String strOptString5 = jSONObject.has("displayName") ? jSONObject.optString("displayName") : null;
        String strOptString6 = jSONObject.has("givenName") ? jSONObject.optString("givenName") : null;
        String strOptString7 = jSONObject.has("familyName") ? jSONObject.optString("familyName") : null;
        String string = jSONObject.getString("obfuscatedIdentifier");
        zzah.checkNotEmpty(string);
        GoogleSignInAccount googleSignInAccount = new GoogleSignInAccount(3, strOptString2, strOptString3, strOptString4, strOptString5, uri, null, j, string, new ArrayList(hashSet), strOptString6, strOptString7);
        googleSignInAccount.zai = jSONObject.has("serverAuthCode") ? jSONObject.optString("serverAuthCode") : null;
        return googleSignInAccount;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        if (!googleSignInAccount.zak.equals(this.zak)) {
            return false;
        }
        HashSet hashSet = new HashSet(googleSignInAccount.zac);
        hashSet.addAll(googleSignInAccount.zan);
        HashSet hashSet2 = new HashSet(this.zac);
        hashSet2.addAll(this.zan);
        return hashSet.equals(hashSet2);
    }

    public final int hashCode() {
        int iHashCode = this.zak.hashCode() + 527;
        HashSet hashSet = new HashSet(this.zac);
        hashSet.addAll(this.zan);
        return (iHashCode * 31) + hashSet.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iZza = zzkp.zza(parcel, 20293);
        zzkp.zzc(parcel, 1, 4);
        parcel.writeInt(this.zab);
        zzkp.writeString(parcel, 2, this.zad);
        zzkp.writeString(parcel, 3, this.zae);
        zzkp.writeString(parcel, 4, this.zaf);
        zzkp.writeString(parcel, 5, this.zag);
        zzkp.writeParcelable(parcel, 6, this.zah, i);
        zzkp.writeString(parcel, 7, this.zai);
        zzkp.zzc(parcel, 8, 8);
        parcel.writeLong(this.zaj);
        zzkp.writeString(parcel, 9, this.zak);
        zzkp.writeTypedList(10, parcel, this.zac);
        zzkp.writeString(parcel, 11, this.zal);
        zzkp.writeString(parcel, 12, this.zam);
        zzkp.zzb(parcel, iZza);
    }
}
