package kotlin.io;

import androidx.camera.camera2.internal.CaptureSession$State$EnumUnboxingLocalUtility;
import coil.network.HttpException;
import java.io.File;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.FilteringSequence;
import kotlin.sequences.GeneratorSequence;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt$flatMap$2;
import kotlin.text.DelimitedRangesSequence$iterator$1;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class FileTreeWalk implements Sequence {
    public final /* synthetic */ int $r8$classId;
    public final int direction;
    public final Function2 onFail;
    public final Object start;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class DirectoryState extends WalkState {
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class WalkState {
        public final File root;

        public WalkState(File file) {
            this.root = file;
        }

        public abstract File step();
    }

    public /* synthetic */ FileTreeWalk(int i, int i2, Object obj, Function2 function2) {
        this.$r8$classId = i2;
        this.start = obj;
        this.direction = i;
        this.onFail = function2;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        switch (this.$r8$classId) {
            case 0:
                return new FileTreeWalkIterator(this);
            default:
                return new DelimitedRangesSequence$iterator$1(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class FileTreeWalkIterator implements Iterator, KMappedMarker {
        public final /* synthetic */ int $r8$classId;
        public Object nextValue;
        public Object state;
        public int state$1;
        public final /* synthetic */ Sequence this$0;

        /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
        public final class BottomUpDirectoryState extends DirectoryState {
            public boolean failed;
            public int fileIndex;
            public File[] fileList;
            public boolean rootVisited;

            public BottomUpDirectoryState(File file) {
                super(file);
            }

            @Override // kotlin.io.FileTreeWalk.WalkState
            public final File step() {
                int i;
                boolean z = this.failed;
                File file = this.root;
                if (!z && this.fileList == null) {
                    File[] fileArrListFiles = file.listFiles();
                    this.fileList = fileArrListFiles;
                    if (fileArrListFiles == null) {
                        Function2 function2 = ((FileTreeWalk) FileTreeWalkIterator.this.this$0).onFail;
                        if (function2 != null) {
                            function2.invoke(file, new NoSuchFileException(file, 1));
                        }
                        this.failed = true;
                    }
                }
                File[] fileArr = this.fileList;
                if (fileArr != null && (i = this.fileIndex) < fileArr.length) {
                    this.fileIndex = i + 1;
                    return fileArr[i];
                }
                if (this.rootVisited) {
                    return null;
                }
                this.rootVisited = true;
                return file;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
        public final class SingleFileState extends WalkState {
            public boolean visited;

            @Override // kotlin.io.FileTreeWalk.WalkState
            public final File step() {
                if (this.visited) {
                    return null;
                }
                this.visited = true;
                return this.root;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
        public final class TopDownDirectoryState extends DirectoryState {
            public int fileIndex;
            public File[] fileList;
            public boolean rootVisited;

            public TopDownDirectoryState(File file) {
                super(file);
            }

            @Override // kotlin.io.FileTreeWalk.WalkState
            public final File step() {
                Function2 function2;
                boolean z = this.rootVisited;
                File file = this.root;
                if (!z) {
                    this.rootVisited = true;
                    return file;
                }
                File[] fileArr = this.fileList;
                if (fileArr != null && this.fileIndex >= fileArr.length) {
                    return null;
                }
                if (fileArr == null) {
                    File[] fileArrListFiles = file.listFiles();
                    this.fileList = fileArrListFiles;
                    if (fileArrListFiles == null && (function2 = ((FileTreeWalk) FileTreeWalkIterator.this.this$0).onFail) != null) {
                        function2.invoke(file, new NoSuchFileException(file, 1));
                    }
                    File[] fileArr2 = this.fileList;
                    if (fileArr2 == null || fileArr2.length == 0) {
                        return null;
                    }
                }
                File[] fileArr3 = this.fileList;
                int i = this.fileIndex;
                this.fileIndex = i + 1;
                return fileArr3[i];
            }
        }

        public FileTreeWalkIterator(FileTreeWalk fileTreeWalk) {
            this.$r8$classId = 0;
            this.this$0 = fileTreeWalk;
            ArrayDeque arrayDeque = new ArrayDeque();
            this.state = arrayDeque;
            File file = (File) fileTreeWalk.start;
            if (file.isDirectory()) {
                arrayDeque.push(directoryState(file));
            } else if (file.isFile()) {
                arrayDeque.push(new SingleFileState(file));
            } else {
                this.state$1 = 2;
            }
        }

        public void calcNext() {
            FilteringSequence filteringSequence = (FilteringSequence) this.this$0;
            Iterator it = (Iterator) this.nextValue;
            while (it.hasNext()) {
                Object next = it.next();
                if (((Boolean) filteringSequence.predicate.invoke(next)).booleanValue() == filteringSequence.sendWhen) {
                    this.state = next;
                    this.state$1 = 1;
                    return;
                }
            }
            this.state$1 = 0;
        }

        /* JADX WARN: Type inference failed for: r1v4, types: [kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
        public void calcNext$2() {
            Iterator it = (Iterator) this.nextValue;
            if (it.hasNext()) {
                Object next = it.next();
                if (((Boolean) ((Lambda) ((GeneratorSequence) this.this$0).getNextValue).invoke(next)).booleanValue()) {
                    this.state$1 = 1;
                    this.state = next;
                    return;
                }
            }
            this.state$1 = 0;
        }

        public DirectoryState directoryState(File file) {
            int iOrdinal = CaptureSession$State$EnumUnboxingLocalUtility.ordinal(((FileTreeWalk) this.this$0).direction);
            if (iOrdinal == 0) {
                return new TopDownDirectoryState(file);
            }
            if (iOrdinal == 1) {
                return new BottomUpDirectoryState(file);
            }
            throw new HttpException();
        }

        public boolean ensureItemIterator() {
            GeneratorSequence generatorSequence = (GeneratorSequence) this.this$0;
            Iterator it = (Iterator) this.nextValue;
            Iterator it2 = (Iterator) this.state;
            if (it2 != null && it2.hasNext()) {
                this.state$1 = 1;
                return true;
            }
            while (it.hasNext()) {
                Object next = it.next();
                int i = SequencesKt___SequencesKt$flatMap$2.$r8$clinit;
                Iterator it3 = ((Sequence) ((Function1) generatorSequence.getNextValue).invoke(next)).iterator();
                if (it3.hasNext()) {
                    this.state = it3;
                    this.state$1 = 1;
                    return true;
                }
            }
            this.state$1 = 2;
            this.state = null;
            return false;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            switch (this.$r8$classId) {
                case 0:
                    int i = this.state$1;
                    if (i == 0) {
                        return tryToComputeNext();
                    }
                    if (i == 1) {
                        return true;
                    }
                    if (i == 2) {
                        return false;
                    }
                    throw new IllegalArgumentException("hasNext called when the iterator is in the FAILED state.");
                case 1:
                    if (this.state$1 == -1) {
                        calcNext();
                    }
                    return this.state$1 == 1;
                case 2:
                    int i2 = this.state$1;
                    if (i2 == 1) {
                        return true;
                    }
                    if (i2 == 2) {
                        return false;
                    }
                    return ensureItemIterator();
                default:
                    if (this.state$1 == -1) {
                        calcNext$2();
                    }
                    return this.state$1 == 1;
            }
        }

        @Override // java.util.Iterator
        public final Object next() {
            switch (this.$r8$classId) {
                case 0:
                    int i = this.state$1;
                    if (i == 1) {
                        this.state$1 = 0;
                        return (File) this.nextValue;
                    }
                    if (i == 2 || !tryToComputeNext()) {
                        throw new NoSuchElementException();
                    }
                    this.state$1 = 0;
                    return (File) this.nextValue;
                case 1:
                    if (this.state$1 == -1) {
                        calcNext();
                    }
                    if (this.state$1 == 0) {
                        throw new NoSuchElementException();
                    }
                    Object obj = this.state;
                    this.state = null;
                    this.state$1 = -1;
                    return obj;
                case 2:
                    int i2 = this.state$1;
                    if (i2 == 2) {
                        throw new NoSuchElementException();
                    }
                    if (i2 == 0 && !ensureItemIterator()) {
                        throw new NoSuchElementException();
                    }
                    this.state$1 = 0;
                    return ((Iterator) this.state).next();
                default:
                    if (this.state$1 == -1) {
                        calcNext$2();
                    }
                    if (this.state$1 == 0) {
                        throw new NoSuchElementException();
                    }
                    Object obj2 = this.state;
                    this.state = null;
                    this.state$1 = -1;
                    return obj2;
            }
        }

        @Override // java.util.Iterator
        public final void remove() {
            switch (this.$r8$classId) {
                case 0:
                    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
                case 1:
                    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
                case 2:
                    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
                default:
                    throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        }

        public boolean tryToComputeNext() {
            File file;
            this.state$1 = 3;
            ArrayDeque arrayDeque = (ArrayDeque) this.state;
            while (true) {
                WalkState walkState = (WalkState) arrayDeque.peek();
                if (walkState == null) {
                    file = null;
                    break;
                }
                File fileStep = walkState.step();
                if (fileStep == null) {
                    arrayDeque.pop();
                } else {
                    if (fileStep.equals(walkState.root) || !fileStep.isDirectory() || arrayDeque.size() >= Integer.MAX_VALUE) {
                        file = fileStep;
                        break;
                    }
                    arrayDeque.push(directoryState(fileStep));
                }
            }
            if (file != null) {
                this.nextValue = file;
                this.state$1 = 1;
            } else {
                this.state$1 = 2;
            }
            return this.state$1 == 1;
        }

        public FileTreeWalkIterator(FilteringSequence filteringSequence) {
            this.$r8$classId = 1;
            this.this$0 = filteringSequence;
            this.nextValue = filteringSequence.sequence.iterator();
            this.state$1 = -1;
        }

        public FileTreeWalkIterator(GeneratorSequence generatorSequence) {
            this.$r8$classId = 2;
            this.this$0 = generatorSequence;
            this.nextValue = new FileTreeWalkIterator((FilteringSequence) generatorSequence.getInitialValue);
        }

        public FileTreeWalkIterator(GeneratorSequence generatorSequence, byte b) {
            this.$r8$classId = 3;
            this.this$0 = generatorSequence;
            this.nextValue = ((Sequence) generatorSequence.getInitialValue).iterator();
            this.state$1 = -1;
        }
    }
}
