package androidx.core.view;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContentInfo;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.core.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class ContentInfoCompat {
    public final Compat mCompat;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public interface BuilderCompat {
        ContentInfoCompat build();

        void setExtras(Bundle bundle);

        void setFlags(int i);

        void setLinkUri(Uri uri);
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public interface Compat {
        ClipData getClip();

        int getFlags();

        int getSource();

        ContentInfo getWrapped();
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class CompatImpl implements BuilderCompat, Compat {
        public final /* synthetic */ int $r8$classId = 1;
        public ClipData mClip;
        public Bundle mExtras;
        public int mFlags;
        public Uri mLinkUri;
        public int mSource;

        public /* synthetic */ CompatImpl() {
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public ContentInfoCompat build() {
            return new ContentInfoCompat(new CompatImpl(this));
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public ClipData getClip() {
            return this.mClip;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getFlags() {
            return this.mFlags;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public int getSource() {
            return this.mSource;
        }

        @Override // androidx.core.view.ContentInfoCompat.Compat
        public ContentInfo getWrapped() {
            return null;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setExtras(Bundle bundle) {
            this.mExtras = bundle;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setFlags(int i) {
            this.mFlags = i;
        }

        @Override // androidx.core.view.ContentInfoCompat.BuilderCompat
        public void setLinkUri(Uri uri) {
            this.mLinkUri = uri;
        }

        public String toString() {
            String strValueOf;
            String str;
            switch (this.$r8$classId) {
                case 0:
                    Uri uri = this.mLinkUri;
                    StringBuilder sb = new StringBuilder("ContentInfoCompat{clip=");
                    sb.append(this.mClip.getDescription());
                    sb.append(", source=");
                    int i = this.mSource;
                    if (i == 0) {
                        strValueOf = "SOURCE_APP";
                    } else if (i == 1) {
                        strValueOf = "SOURCE_CLIPBOARD";
                    } else if (i == 2) {
                        strValueOf = "SOURCE_INPUT_METHOD";
                    } else if (i == 3) {
                        strValueOf = "SOURCE_DRAG_AND_DROP";
                    } else if (i != 4) {
                        strValueOf = i != 5 ? String.valueOf(i) : "SOURCE_PROCESS_TEXT";
                    } else {
                        strValueOf = "SOURCE_AUTOFILL";
                    }
                    sb.append(strValueOf);
                    sb.append(", flags=");
                    int i2 = this.mFlags;
                    sb.append((i2 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i2));
                    if (uri == null) {
                        str = "";
                    } else {
                        str = ", hasLinkUri(" + uri.toString().length() + ")";
                    }
                    sb.append(str);
                    return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.mExtras != null ? ", hasExtras" : "", "}");
                default:
                    return super.toString();
            }
        }

        public CompatImpl(CompatImpl compatImpl) {
            ClipData clipData = compatImpl.mClip;
            clipData.getClass();
            this.mClip = clipData;
            int i = compatImpl.mSource;
            Preconditions.checkArgumentInRange(i, 0, 5, "source");
            this.mSource = i;
            int i2 = compatImpl.mFlags;
            if ((i2 & 1) == i2) {
                this.mFlags = i2;
                this.mLinkUri = compatImpl.mLinkUri;
                this.mExtras = compatImpl.mExtras;
            } else {
                throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i2) + ", but only 0x" + Integer.toHexString(1) + " are allowed");
            }
        }
    }

    public ContentInfoCompat(Compat compat) {
        this.mCompat = compat;
    }

    public final String toString() {
        return this.mCompat.toString();
    }
}
