package io.github.g00fy2.quickie;

import io.github.g00fy2.quickie.content.QRContent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class QRResult {

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class QRError extends QRResult {
        public final Exception exception;

        public QRError(Exception exc) {
            this.exception = exc;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof QRError) && Intrinsics.areEqual(this.exception, ((QRError) obj).exception);
        }

        public final int hashCode() {
            return this.exception.hashCode();
        }

        public final String toString() {
            return "QRError(exception=" + this.exception + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class QRMissingPermission extends QRResult {
        public static final QRMissingPermission INSTANCE = new QRMissingPermission();

        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof QRMissingPermission);
        }

        public final int hashCode() {
            return -451247076;
        }

        public final String toString() {
            return "QRMissingPermission";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class QRSuccess extends QRResult {
        public final QRContent content;

        public QRSuccess(QRContent qRContent) {
            this.content = qRContent;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof QRSuccess) && Intrinsics.areEqual(this.content, ((QRSuccess) obj).content);
        }

        public final int hashCode() {
            return this.content.hashCode();
        }

        public final String toString() {
            return "QRSuccess(content=" + this.content + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class QRUserCanceled extends QRResult {
        public static final QRUserCanceled INSTANCE = new QRUserCanceled();

        public final boolean equals(Object obj) {
            return this == obj || (obj instanceof QRUserCanceled);
        }

        public final int hashCode() {
            return 1573134557;
        }

        public final String toString() {
            return "QRUserCanceled";
        }
    }
}
