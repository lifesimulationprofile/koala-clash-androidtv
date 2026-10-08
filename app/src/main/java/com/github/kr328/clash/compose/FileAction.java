package com.github.kr328.clash.compose;

import com.github.kr328.clash.design.model.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public interface FileAction {

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Delete implements FileAction {
        public final File file;

        public Delete(File file) {
            this.file = file;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Delete) && Intrinsics.areEqual(this.file, ((Delete) obj).file);
        }

        public final int hashCode() {
            return this.file.hashCode();
        }

        public final String toString() {
            return "Delete(file=" + this.file + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Export implements FileAction {
        public final File file;

        public Export(File file) {
            this.file = file;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Export) && Intrinsics.areEqual(this.file, ((Export) obj).file);
        }

        public final int hashCode() {
            return this.file.hashCode();
        }

        public final String toString() {
            return "Export(file=" + this.file + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Import implements FileAction {
        public final File file;

        public Import(File file) {
            this.file = file;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Import) && Intrinsics.areEqual(this.file, ((Import) obj).file);
        }

        public final int hashCode() {
            File file = this.file;
            if (file == null) {
                return 0;
            }
            return file.hashCode();
        }

        public final String toString() {
            return "Import(file=" + this.file + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Open implements FileAction {
        public final File file;

        public Open(File file) {
            this.file = file;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Open) && Intrinsics.areEqual(this.file, ((Open) obj).file);
        }

        public final int hashCode() {
            return this.file.hashCode();
        }

        public final String toString() {
            return "Open(file=" + this.file + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Rename implements FileAction {
        public final File file;

        public Rename(File file) {
            this.file = file;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Rename) && Intrinsics.areEqual(this.file, ((Rename) obj).file);
        }

        public final int hashCode() {
            return this.file.hashCode();
        }

        public final String toString() {
            return "Rename(file=" + this.file + ")";
        }
    }
}
