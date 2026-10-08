package androidx.fragment.app;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.core.widget.NestedScrollView;
import androidx.navigation.NavBackStackEntryState;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
import androidx.versionedparcelable.ParcelImpl;
import coil.memory.MemoryCache$Key;
import com.github.kr328.clash.core.model.LogMessage;
import com.github.kr328.clash.core.util.Parcelizer$ParcelDecoder;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.zat;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallIntentResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import com.google.android.gms.internal.mlkit_vision_common.zzko;
import com.google.android.gms.internal.mlkit_vision_common.zzkp;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new AnonymousClass1(0);
    public final Bundle mArguments;
    public final String mClassName;
    public final int mContainerId;
    public final boolean mDetached;
    public final int mFragmentId;
    public final boolean mFromLayout;
    public final boolean mHidden;
    public final int mMaxLifecycleState;
    public final boolean mRemoving;
    public final boolean mRetainInstance;
    public Bundle mSavedFragmentState;
    public final String mTag;
    public final String mWho;

    /* JADX INFO: renamed from: androidx.fragment.app.FragmentState$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class AnonymousClass1 implements Parcelable.Creator {
        public final /* synthetic */ int $r8$classId;

        public /* synthetic */ AnonymousClass1(int i) {
            this.$r8$classId = i;
        }

        public static void zza(GetServiceRequest getServiceRequest, Parcel parcel, int i) {
            int iZza = zzkp.zza(parcel, 20293);
            int i2 = getServiceRequest.zzc;
            zzkp.zzc(parcel, 1, 4);
            parcel.writeInt(i2);
            int i3 = getServiceRequest.zzd;
            zzkp.zzc(parcel, 2, 4);
            parcel.writeInt(i3);
            int i4 = getServiceRequest.zze;
            zzkp.zzc(parcel, 3, 4);
            parcel.writeInt(i4);
            zzkp.writeString(parcel, 4, getServiceRequest.zzf);
            IBinder iBinder = getServiceRequest.zzg;
            if (iBinder != null) {
                int iZza2 = zzkp.zza(parcel, 5);
                parcel.writeStrongBinder(iBinder);
                zzkp.zzb(parcel, iZza2);
            }
            zzkp.writeTypedArray(parcel, 6, getServiceRequest.zzh, i);
            Bundle bundle = getServiceRequest.zzi;
            if (bundle != null) {
                int iZza3 = zzkp.zza(parcel, 7);
                parcel.writeBundle(bundle);
                zzkp.zzb(parcel, iZza3);
            }
            zzkp.writeParcelable(parcel, 8, getServiceRequest.zzj, i);
            zzkp.writeTypedArray(parcel, 10, getServiceRequest.zzk, i);
            zzkp.writeTypedArray(parcel, 11, getServiceRequest.zzl, i);
            boolean z = getServiceRequest.zzm;
            zzkp.zzc(parcel, 12, 4);
            parcel.writeInt(z ? 1 : 0);
            int i5 = getServiceRequest.zzn;
            zzkp.zzc(parcel, 13, 4);
            parcel.writeInt(i5);
            boolean z2 = getServiceRequest.zzo;
            zzkp.zzc(parcel, 14, 4);
            parcel.writeInt(z2 ? 1 : 0);
            zzkp.writeString(parcel, 15, getServiceRequest.zzp);
            zzkp.zzb(parcel, iZza);
        }

        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            switch (this.$r8$classId) {
                case 0:
                    return new FragmentState(parcel);
                case 1:
                    return new ActivityResult(parcel.readInt(), parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel));
                case 2:
                    return new IntentSenderRequest((IntentSender) parcel.readParcelable(IntentSender.class.getClassLoader()), (Intent) parcel.readParcelable(Intent.class.getClassLoader()), parcel.readInt(), parcel.readInt());
                case 3:
                    AppCompatSpinner.SavedState savedState = new AppCompatSpinner.SavedState(parcel);
                    savedState.mShowDropdown = parcel.readByte() != 0;
                    return savedState;
                case 4:
                    NestedScrollView.SavedState savedState2 = new NestedScrollView.SavedState(parcel);
                    savedState2.scrollPosition = parcel.readInt();
                    return savedState2;
                case 5:
                    return new BackStackRecordState(parcel);
                case 6:
                    return new BackStackState(parcel);
                case 7:
                    FragmentManager$LaunchedFragmentInfo fragmentManager$LaunchedFragmentInfo = new FragmentManager$LaunchedFragmentInfo();
                    fragmentManager$LaunchedFragmentInfo.mWho = parcel.readString();
                    fragmentManager$LaunchedFragmentInfo.mRequestCode = parcel.readInt();
                    return fragmentManager$LaunchedFragmentInfo;
                case 8:
                    FragmentManagerState fragmentManagerState = new FragmentManagerState();
                    fragmentManagerState.mPrimaryNavActiveWho = null;
                    fragmentManagerState.mBackStackStateKeys = new ArrayList();
                    fragmentManagerState.mBackStackStates = new ArrayList();
                    fragmentManagerState.mActive = parcel.createStringArrayList();
                    fragmentManagerState.mAdded = parcel.createStringArrayList();
                    fragmentManagerState.mBackStack = (BackStackRecordState[]) parcel.createTypedArray(BackStackRecordState.CREATOR);
                    fragmentManagerState.mBackStackIndex = parcel.readInt();
                    fragmentManagerState.mPrimaryNavActiveWho = parcel.readString();
                    fragmentManagerState.mBackStackStateKeys = parcel.createStringArrayList();
                    fragmentManagerState.mBackStackStates = parcel.createTypedArrayList(BackStackState.CREATOR);
                    fragmentManagerState.mLaunchedFragments = parcel.createTypedArrayList(FragmentManager$LaunchedFragmentInfo.CREATOR);
                    return fragmentManagerState;
                case 9:
                    return new NavBackStackEntryState(parcel);
                case 10:
                    LinearLayoutManager.SavedState savedState3 = new LinearLayoutManager.SavedState();
                    savedState3.mAnchorPosition = parcel.readInt();
                    savedState3.mAnchorOffset = parcel.readInt();
                    savedState3.mAnchorLayoutFromEnd = parcel.readInt() == 1;
                    return savedState3;
                case 11:
                    StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = new StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem();
                    staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mPosition = parcel.readInt();
                    staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mGapDir = parcel.readInt();
                    staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mHasUnwantedGapAfter = parcel.readInt() == 1;
                    int i = parcel.readInt();
                    if (i > 0) {
                        int[] iArr = new int[i];
                        staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mGapPerSpan = iArr;
                        parcel.readIntArray(iArr);
                    }
                    return staggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
                case 12:
                    StaggeredGridLayoutManager.SavedState savedState4 = new StaggeredGridLayoutManager.SavedState();
                    savedState4.mAnchorPosition = parcel.readInt();
                    savedState4.mVisibleAnchorPosition = parcel.readInt();
                    int i2 = parcel.readInt();
                    savedState4.mSpanOffsetsSize = i2;
                    if (i2 > 0) {
                        int[] iArr2 = new int[i2];
                        savedState4.mSpanOffsets = iArr2;
                        parcel.readIntArray(iArr2);
                    }
                    int i3 = parcel.readInt();
                    savedState4.mSpanLookupSize = i3;
                    if (i3 > 0) {
                        int[] iArr3 = new int[i3];
                        savedState4.mSpanLookup = iArr3;
                        parcel.readIntArray(iArr3);
                    }
                    savedState4.mReverseLayout = parcel.readInt() == 1;
                    savedState4.mAnchorLayoutFromEnd = parcel.readInt() == 1;
                    savedState4.mLastLayoutRTL = parcel.readInt() == 1;
                    savedState4.mFullSpanItems = parcel.readArrayList(StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem.class.getClassLoader());
                    return savedState4;
                case 13:
                    return new ParcelImpl(parcel);
                case 14:
                    String string = parcel.readString();
                    int i4 = parcel.readInt();
                    LinkedHashMap linkedHashMap = new LinkedHashMap(i4);
                    for (int i5 = 0; i5 < i4; i5++) {
                        linkedHashMap.put(parcel.readString(), parcel.readString());
                    }
                    return new MemoryCache$Key(string, linkedHashMap);
                case 15:
                    return (LogMessage) LogMessage.Companion.serializer().deserialize(new Parcelizer$ParcelDecoder(parcel, 0));
                case 16:
                    int iValidateObjectHeader = zzko.validateObjectHeader(parcel);
                    String strCreateString = null;
                    String strCreateString2 = null;
                    String strCreateString3 = null;
                    String strCreateString4 = null;
                    Uri uri = null;
                    String strCreateString5 = null;
                    String strCreateString6 = null;
                    ArrayList arrayListCreateTypedList = null;
                    String strCreateString7 = null;
                    String strCreateString8 = null;
                    long j = 0;
                    int i6 = 0;
                    while (parcel.dataPosition() < iValidateObjectHeader) {
                        int i7 = parcel.readInt();
                        switch ((char) i7) {
                            case 1:
                                i6 = zzko.readInt(parcel, i7);
                                break;
                            case 2:
                                strCreateString = zzko.createString(parcel, i7);
                                break;
                            case 3:
                                strCreateString2 = zzko.createString(parcel, i7);
                                break;
                            case 4:
                                strCreateString3 = zzko.createString(parcel, i7);
                                break;
                            case 5:
                                strCreateString4 = zzko.createString(parcel, i7);
                                break;
                            case 6:
                                uri = (Uri) zzko.createParcelable(i7, parcel, Uri.CREATOR);
                                break;
                            case 7:
                                strCreateString5 = zzko.createString(parcel, i7);
                                break;
                            case '\b':
                                j = zzko.readLong(parcel, i7);
                                break;
                            case '\t':
                                strCreateString6 = zzko.createString(parcel, i7);
                                break;
                            case '\n':
                                arrayListCreateTypedList = zzko.createTypedList(i7, parcel, Scope.CREATOR);
                                break;
                            case 11:
                                strCreateString7 = zzko.createString(parcel, i7);
                                break;
                            case '\f':
                                strCreateString8 = zzko.createString(parcel, i7);
                                break;
                            default:
                                zzko.skipUnknownField(parcel, i7);
                                break;
                        }
                    }
                    zzko.ensureAtEnd(parcel, iValidateObjectHeader);
                    return new GoogleSignInAccount(i6, strCreateString, strCreateString2, strCreateString3, strCreateString4, uri, strCreateString5, j, strCreateString6, arrayListCreateTypedList, strCreateString7, strCreateString8);
                case 17:
                    int iValidateObjectHeader2 = zzko.validateObjectHeader(parcel);
                    String strCreateString9 = null;
                    int i8 = 0;
                    while (parcel.dataPosition() < iValidateObjectHeader2) {
                        int i9 = parcel.readInt();
                        char c = (char) i9;
                        if (c == 1) {
                            i8 = zzko.readInt(parcel, i9);
                        } else if (c != 2) {
                            zzko.skipUnknownField(parcel, i9);
                        } else {
                            strCreateString9 = zzko.createString(parcel, i9);
                        }
                    }
                    zzko.ensureAtEnd(parcel, iValidateObjectHeader2);
                    return new Scope(strCreateString9, i8);
                case 18:
                    int iValidateObjectHeader3 = zzko.validateObjectHeader(parcel);
                    String strCreateString10 = null;
                    ConnectionResult connectionResult = null;
                    int i10 = 0;
                    PendingIntent pendingIntent = null;
                    while (parcel.dataPosition() < iValidateObjectHeader3) {
                        int i11 = parcel.readInt();
                        char c2 = (char) i11;
                        if (c2 == 1) {
                            i10 = zzko.readInt(parcel, i11);
                        } else if (c2 == 2) {
                            strCreateString10 = zzko.createString(parcel, i11);
                        } else if (c2 == 3) {
                            pendingIntent = (PendingIntent) zzko.createParcelable(i11, parcel, PendingIntent.CREATOR);
                        } else if (c2 != 4) {
                            zzko.skipUnknownField(parcel, i11);
                        } else {
                            connectionResult = (ConnectionResult) zzko.createParcelable(i11, parcel, ConnectionResult.CREATOR);
                        }
                    }
                    zzko.ensureAtEnd(parcel, iValidateObjectHeader3);
                    return new Status(i10, strCreateString10, pendingIntent, connectionResult);
                case 19:
                    int iValidateObjectHeader4 = zzko.validateObjectHeader(parcel);
                    ArrayList arrayListCreateTypedList2 = null;
                    int i12 = 0;
                    while (parcel.dataPosition() < iValidateObjectHeader4) {
                        int i13 = parcel.readInt();
                        char c3 = (char) i13;
                        if (c3 == 1) {
                            i12 = zzko.readInt(parcel, i13);
                        } else if (c3 != 2) {
                            zzko.skipUnknownField(parcel, i13);
                        } else {
                            arrayListCreateTypedList2 = zzko.createTypedList(i13, parcel, MethodInvocation.CREATOR);
                        }
                    }
                    zzko.ensureAtEnd(parcel, iValidateObjectHeader4);
                    return new TelemetryData(i12, arrayListCreateTypedList2);
                case 20:
                    int iValidateObjectHeader5 = zzko.validateObjectHeader(parcel);
                    int i14 = -1;
                    int i15 = 0;
                    int i16 = 0;
                    int i17 = 0;
                    int i18 = 0;
                    String strCreateString11 = null;
                    String strCreateString12 = null;
                    long j2 = 0;
                    long j3 = 0;
                    while (parcel.dataPosition() < iValidateObjectHeader5) {
                        int i19 = parcel.readInt();
                        switch ((char) i19) {
                            case 1:
                                i15 = zzko.readInt(parcel, i19);
                                break;
                            case 2:
                                i16 = zzko.readInt(parcel, i19);
                                break;
                            case 3:
                                i17 = zzko.readInt(parcel, i19);
                                break;
                            case 4:
                                j2 = zzko.readLong(parcel, i19);
                                break;
                            case 5:
                                j3 = zzko.readLong(parcel, i19);
                                break;
                            case 6:
                                strCreateString11 = zzko.createString(parcel, i19);
                                break;
                            case 7:
                                strCreateString12 = zzko.createString(parcel, i19);
                                break;
                            case '\b':
                                i18 = zzko.readInt(parcel, i19);
                                break;
                            case '\t':
                                i14 = zzko.readInt(parcel, i19);
                                break;
                            default:
                                zzko.skipUnknownField(parcel, i19);
                                break;
                        }
                    }
                    zzko.ensureAtEnd(parcel, iValidateObjectHeader5);
                    return new MethodInvocation(i15, i16, i17, j2, j3, strCreateString11, strCreateString12, i18, i14);
                case 21:
                    int iValidateObjectHeader6 = zzko.validateObjectHeader(parcel);
                    Account account = null;
                    int i20 = 0;
                    int i21 = 0;
                    GoogleSignInAccount googleSignInAccount = null;
                    while (parcel.dataPosition() < iValidateObjectHeader6) {
                        int i22 = parcel.readInt();
                        char c4 = (char) i22;
                        if (c4 == 1) {
                            i20 = zzko.readInt(parcel, i22);
                        } else if (c4 == 2) {
                            account = (Account) zzko.createParcelable(i22, parcel, Account.CREATOR);
                        } else if (c4 == 3) {
                            i21 = zzko.readInt(parcel, i22);
                        } else if (c4 != 4) {
                            zzko.skipUnknownField(parcel, i22);
                        } else {
                            googleSignInAccount = (GoogleSignInAccount) zzko.createParcelable(i22, parcel, GoogleSignInAccount.CREATOR);
                        }
                    }
                    zzko.ensureAtEnd(parcel, iValidateObjectHeader6);
                    return new zat(i20, account, i21, googleSignInAccount);
                case 22:
                    int iValidateObjectHeader7 = zzko.validateObjectHeader(parcel);
                    int i23 = 0;
                    boolean z = false;
                    boolean z2 = false;
                    IBinder strongBinder = null;
                    ConnectionResult connectionResult2 = null;
                    while (parcel.dataPosition() < iValidateObjectHeader7) {
                        int i24 = parcel.readInt();
                        char c5 = (char) i24;
                        if (c5 == 1) {
                            i23 = zzko.readInt(parcel, i24);
                        } else if (c5 == 2) {
                            int size = zzko.readSize(parcel, i24);
                            int iDataPosition = parcel.dataPosition();
                            if (size == 0) {
                                strongBinder = null;
                            } else {
                                strongBinder = parcel.readStrongBinder();
                                parcel.setDataPosition(iDataPosition + size);
                            }
                        } else if (c5 == 3) {
                            connectionResult2 = (ConnectionResult) zzko.createParcelable(i24, parcel, ConnectionResult.CREATOR);
                        } else if (c5 == 4) {
                            z = zzko.readBoolean(parcel, i24);
                        } else if (c5 != 5) {
                            zzko.skipUnknownField(parcel, i24);
                        } else {
                            z2 = zzko.readBoolean(parcel, i24);
                        }
                    }
                    zzko.ensureAtEnd(parcel, iValidateObjectHeader7);
                    return new zav(i23, strongBinder, connectionResult2, z, z2);
                case 23:
                    int iValidateObjectHeader8 = zzko.validateObjectHeader(parcel);
                    int i25 = 0;
                    int i26 = 0;
                    int i27 = 0;
                    boolean z3 = false;
                    boolean z4 = false;
                    while (parcel.dataPosition() < iValidateObjectHeader8) {
                        int i28 = parcel.readInt();
                        char c6 = (char) i28;
                        if (c6 == 1) {
                            i25 = zzko.readInt(parcel, i28);
                        } else if (c6 == 2) {
                            z3 = zzko.readBoolean(parcel, i28);
                        } else if (c6 == 3) {
                            z4 = zzko.readBoolean(parcel, i28);
                        } else if (c6 == 4) {
                            i26 = zzko.readInt(parcel, i28);
                        } else if (c6 != 5) {
                            zzko.skipUnknownField(parcel, i28);
                        } else {
                            i27 = zzko.readInt(parcel, i28);
                        }
                    }
                    zzko.ensureAtEnd(parcel, iValidateObjectHeader8);
                    return new RootTelemetryConfiguration(i25, i26, i27, z3, z4);
                case 24:
                    int iValidateObjectHeader9 = zzko.validateObjectHeader(parcel);
                    int i29 = 0;
                    Bundle bundle = null;
                    Feature[] featureArr = null;
                    ConnectionTelemetryConfiguration connectionTelemetryConfiguration = null;
                    while (parcel.dataPosition() < iValidateObjectHeader9) {
                        int i30 = parcel.readInt();
                        char c7 = (char) i30;
                        if (c7 == 1) {
                            int size2 = zzko.readSize(parcel, i30);
                            int iDataPosition2 = parcel.dataPosition();
                            if (size2 == 0) {
                                bundle = null;
                            } else {
                                Bundle bundle2 = parcel.readBundle();
                                parcel.setDataPosition(iDataPosition2 + size2);
                                bundle = bundle2;
                            }
                        } else if (c7 == 2) {
                            featureArr = (Feature[]) zzko.createTypedArray(i30, parcel, Feature.CREATOR);
                        } else if (c7 == 3) {
                            i29 = zzko.readInt(parcel, i30);
                        } else if (c7 != 4) {
                            zzko.skipUnknownField(parcel, i30);
                        } else {
                            connectionTelemetryConfiguration = (ConnectionTelemetryConfiguration) zzko.createParcelable(i30, parcel, ConnectionTelemetryConfiguration.CREATOR);
                        }
                    }
                    zzko.ensureAtEnd(parcel, iValidateObjectHeader9);
                    zzk zzkVar = new zzk();
                    zzkVar.zza = bundle;
                    zzkVar.zzb = featureArr;
                    zzkVar.zzc = i29;
                    zzkVar.zzd = connectionTelemetryConfiguration;
                    return zzkVar;
                case 25:
                    int iValidateObjectHeader10 = zzko.validateObjectHeader(parcel);
                    RootTelemetryConfiguration rootTelemetryConfiguration = null;
                    int[] iArrCreateIntArray = null;
                    int[] iArrCreateIntArray2 = null;
                    boolean z5 = false;
                    boolean z6 = false;
                    int i31 = 0;
                    while (parcel.dataPosition() < iValidateObjectHeader10) {
                        int i32 = parcel.readInt();
                        switch ((char) i32) {
                            case 1:
                                rootTelemetryConfiguration = (RootTelemetryConfiguration) zzko.createParcelable(i32, parcel, RootTelemetryConfiguration.CREATOR);
                                break;
                            case 2:
                                z5 = zzko.readBoolean(parcel, i32);
                                break;
                            case 3:
                                z6 = zzko.readBoolean(parcel, i32);
                                break;
                            case 4:
                                int size3 = zzko.readSize(parcel, i32);
                                int iDataPosition3 = parcel.dataPosition();
                                if (size3 == 0) {
                                    iArrCreateIntArray = null;
                                } else {
                                    iArrCreateIntArray = parcel.createIntArray();
                                    parcel.setDataPosition(iDataPosition3 + size3);
                                }
                                break;
                            case 5:
                                i31 = zzko.readInt(parcel, i32);
                                break;
                            case 6:
                                int size4 = zzko.readSize(parcel, i32);
                                int iDataPosition4 = parcel.dataPosition();
                                if (size4 == 0) {
                                    iArrCreateIntArray2 = null;
                                } else {
                                    iArrCreateIntArray2 = parcel.createIntArray();
                                    parcel.setDataPosition(iDataPosition4 + size4);
                                }
                                break;
                            default:
                                zzko.skipUnknownField(parcel, i32);
                                break;
                        }
                    }
                    zzko.ensureAtEnd(parcel, iValidateObjectHeader10);
                    return new ConnectionTelemetryConfiguration(rootTelemetryConfiguration, z5, z6, iArrCreateIntArray, i31, iArrCreateIntArray2);
                case 26:
                    int iValidateObjectHeader11 = zzko.validateObjectHeader(parcel);
                    Bundle bundle3 = new Bundle();
                    Scope[] scopeArr = GetServiceRequest.zza;
                    String strCreateString13 = null;
                    IBinder iBinder = null;
                    Account account2 = null;
                    String strCreateString14 = null;
                    int i33 = 0;
                    int i34 = 0;
                    int i35 = 0;
                    boolean z7 = false;
                    int i36 = 0;
                    boolean z8 = false;
                    Feature[] featureArr2 = GetServiceRequest.zzb;
                    Feature[] featureArr3 = featureArr2;
                    while (parcel.dataPosition() < iValidateObjectHeader11) {
                        int i37 = parcel.readInt();
                        switch ((char) i37) {
                            case 1:
                                i33 = zzko.readInt(parcel, i37);
                                break;
                            case 2:
                                i34 = zzko.readInt(parcel, i37);
                                break;
                            case 3:
                                i35 = zzko.readInt(parcel, i37);
                                break;
                            case 4:
                                strCreateString13 = zzko.createString(parcel, i37);
                                break;
                            case 5:
                                int size5 = zzko.readSize(parcel, i37);
                                int iDataPosition5 = parcel.dataPosition();
                                if (size5 == 0) {
                                    iBinder = null;
                                } else {
                                    IBinder strongBinder2 = parcel.readStrongBinder();
                                    parcel.setDataPosition(iDataPosition5 + size5);
                                    iBinder = strongBinder2;
                                }
                                break;
                            case 6:
                                scopeArr = (Scope[]) zzko.createTypedArray(i37, parcel, Scope.CREATOR);
                                break;
                            case 7:
                                int size6 = zzko.readSize(parcel, i37);
                                int iDataPosition6 = parcel.dataPosition();
                                if (size6 == 0) {
                                    bundle3 = null;
                                } else {
                                    Bundle bundle4 = parcel.readBundle();
                                    parcel.setDataPosition(iDataPosition6 + size6);
                                    bundle3 = bundle4;
                                }
                                break;
                            case '\b':
                                account2 = (Account) zzko.createParcelable(i37, parcel, Account.CREATOR);
                                break;
                            case '\t':
                            default:
                                zzko.skipUnknownField(parcel, i37);
                                break;
                            case '\n':
                                featureArr2 = (Feature[]) zzko.createTypedArray(i37, parcel, Feature.CREATOR);
                                break;
                            case 11:
                                featureArr3 = (Feature[]) zzko.createTypedArray(i37, parcel, Feature.CREATOR);
                                break;
                            case '\f':
                                z7 = zzko.readBoolean(parcel, i37);
                                break;
                            case '\r':
                                i36 = zzko.readInt(parcel, i37);
                                break;
                            case 14:
                                z8 = zzko.readBoolean(parcel, i37);
                                break;
                            case 15:
                                strCreateString14 = zzko.createString(parcel, i37);
                                break;
                        }
                    }
                    zzko.ensureAtEnd(parcel, iValidateObjectHeader11);
                    return new GetServiceRequest(i33, i34, i35, strCreateString13, iBinder, scopeArr, bundle3, account2, featureArr2, featureArr3, z7, i36, z8, strCreateString14);
                case 27:
                    int iValidateObjectHeader12 = zzko.validateObjectHeader(parcel);
                    boolean z9 = false;
                    int i38 = 0;
                    while (parcel.dataPosition() < iValidateObjectHeader12) {
                        int i39 = parcel.readInt();
                        char c8 = (char) i39;
                        if (c8 == 1) {
                            z9 = zzko.readBoolean(parcel, i39);
                        } else if (c8 != 2) {
                            zzko.skipUnknownField(parcel, i39);
                        } else {
                            i38 = zzko.readInt(parcel, i39);
                        }
                    }
                    zzko.ensureAtEnd(parcel, iValidateObjectHeader12);
                    return new ModuleAvailabilityResponse(i38, z9);
                case 28:
                    int iValidateObjectHeader13 = zzko.validateObjectHeader(parcel);
                    PendingIntent pendingIntent2 = null;
                    while (parcel.dataPosition() < iValidateObjectHeader13) {
                        int i40 = parcel.readInt();
                        if (((char) i40) != 1) {
                            zzko.skipUnknownField(parcel, i40);
                        } else {
                            pendingIntent2 = (PendingIntent) zzko.createParcelable(i40, parcel, PendingIntent.CREATOR);
                        }
                    }
                    zzko.ensureAtEnd(parcel, iValidateObjectHeader13);
                    return new ModuleInstallIntentResponse(pendingIntent2);
                default:
                    int iValidateObjectHeader14 = zzko.validateObjectHeader(parcel);
                    int i41 = 0;
                    boolean z10 = false;
                    while (parcel.dataPosition() < iValidateObjectHeader14) {
                        int i42 = parcel.readInt();
                        char c9 = (char) i42;
                        if (c9 == 1) {
                            i41 = zzko.readInt(parcel, i42);
                        } else if (c9 != 2) {
                            zzko.skipUnknownField(parcel, i42);
                        } else {
                            z10 = zzko.readBoolean(parcel, i42);
                        }
                    }
                    zzko.ensureAtEnd(parcel, iValidateObjectHeader14);
                    return new ModuleInstallResponse(i41, z10);
            }
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i) {
            switch (this.$r8$classId) {
                case 0:
                    return new FragmentState[i];
                case 1:
                    return new ActivityResult[i];
                case 2:
                    return new IntentSenderRequest[i];
                case 3:
                    return new AppCompatSpinner.SavedState[i];
                case 4:
                    return new NestedScrollView.SavedState[i];
                case 5:
                    return new BackStackRecordState[i];
                case 6:
                    return new BackStackState[i];
                case 7:
                    return new FragmentManager$LaunchedFragmentInfo[i];
                case 8:
                    return new FragmentManagerState[i];
                case 9:
                    return new NavBackStackEntryState[i];
                case 10:
                    return new LinearLayoutManager.SavedState[i];
                case 11:
                    return new StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem[i];
                case 12:
                    return new StaggeredGridLayoutManager.SavedState[i];
                case 13:
                    return new ParcelImpl[i];
                case 14:
                    return new MemoryCache$Key[i];
                case 15:
                    return new LogMessage[i];
                case 16:
                    return new GoogleSignInAccount[i];
                case 17:
                    return new Scope[i];
                case 18:
                    return new Status[i];
                case 19:
                    return new TelemetryData[i];
                case 20:
                    return new MethodInvocation[i];
                case 21:
                    return new zat[i];
                case 22:
                    return new zav[i];
                case 23:
                    return new RootTelemetryConfiguration[i];
                case 24:
                    return new zzk[i];
                case 25:
                    return new ConnectionTelemetryConfiguration[i];
                case 26:
                    return new GetServiceRequest[i];
                case 27:
                    return new ModuleAvailabilityResponse[i];
                case 28:
                    return new ModuleInstallIntentResponse[i];
                default:
                    return new ModuleInstallResponse[i];
            }
        }
    }

    public FragmentState(Fragment fragment) {
        this.mClassName = fragment.getClass().getName();
        this.mWho = fragment.mWho;
        this.mFromLayout = fragment.mFromLayout;
        this.mFragmentId = fragment.mFragmentId;
        this.mContainerId = fragment.mContainerId;
        this.mTag = fragment.mTag;
        this.mRetainInstance = fragment.mRetainInstance;
        this.mRemoving = fragment.mRemoving;
        this.mDetached = fragment.mDetached;
        this.mArguments = fragment.mArguments;
        this.mHidden = fragment.mHidden;
        this.mMaxLifecycleState = fragment.mMaxState.ordinal();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.mClassName);
        sb.append(" (");
        sb.append(this.mWho);
        sb.append(")}:");
        if (this.mFromLayout) {
            sb.append(" fromLayout");
        }
        int i = this.mContainerId;
        if (i != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(i));
        }
        String str = this.mTag;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(str);
        }
        if (this.mRetainInstance) {
            sb.append(" retainInstance");
        }
        if (this.mRemoving) {
            sb.append(" removing");
        }
        if (this.mDetached) {
            sb.append(" detached");
        }
        if (this.mHidden) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mClassName);
        parcel.writeString(this.mWho);
        parcel.writeInt(this.mFromLayout ? 1 : 0);
        parcel.writeInt(this.mFragmentId);
        parcel.writeInt(this.mContainerId);
        parcel.writeString(this.mTag);
        parcel.writeInt(this.mRetainInstance ? 1 : 0);
        parcel.writeInt(this.mRemoving ? 1 : 0);
        parcel.writeInt(this.mDetached ? 1 : 0);
        parcel.writeBundle(this.mArguments);
        parcel.writeInt(this.mHidden ? 1 : 0);
        parcel.writeBundle(this.mSavedFragmentState);
        parcel.writeInt(this.mMaxLifecycleState);
    }

    public FragmentState(Parcel parcel) {
        this.mClassName = parcel.readString();
        this.mWho = parcel.readString();
        this.mFromLayout = parcel.readInt() != 0;
        this.mFragmentId = parcel.readInt();
        this.mContainerId = parcel.readInt();
        this.mTag = parcel.readString();
        this.mRetainInstance = parcel.readInt() != 0;
        this.mRemoving = parcel.readInt() != 0;
        this.mDetached = parcel.readInt() != 0;
        this.mArguments = parcel.readBundle();
        this.mHidden = parcel.readInt() != 0;
        this.mSavedFragmentState = parcel.readBundle();
        this.mMaxLifecycleState = parcel.readInt();
    }
}
