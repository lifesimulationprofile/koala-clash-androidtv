package androidx.emoji2.text;

import androidx.emoji2.text.flatbuffer.MetadataItem;
import androidx.emoji2.text.flatbuffer.MetadataList;
import java.nio.ByteBuffer;
import okhttp3.Dispatcher;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TypefaceEmojiRasterizer {
    public static final ThreadLocal sMetadataItem = new ThreadLocal();
    public volatile int mCache = 0;
    public final int mIndex;
    public final Dispatcher mMetadataRepo;

    public TypefaceEmojiRasterizer(Dispatcher dispatcher, int i) {
        this.mMetadataRepo = dispatcher;
        this.mIndex = i;
    }

    public final int getCodepointAt(int i) {
        MetadataItem metadataItem = getMetadataItem();
        int i__offset = metadataItem.__offset(16);
        if (i__offset == 0) {
            return 0;
        }
        ByteBuffer byteBuffer = (ByteBuffer) metadataItem.bb;
        int i2 = i__offset + metadataItem.bb_pos;
        return byteBuffer.getInt((i * 4) + byteBuffer.getInt(i2) + i2 + 4);
    }

    public final MetadataItem getMetadataItem() {
        ThreadLocal threadLocal = sMetadataItem;
        MetadataItem metadataItem = (MetadataItem) threadLocal.get();
        if (metadataItem == null) {
            metadataItem = new MetadataItem();
            threadLocal.set(metadataItem);
        }
        MetadataList metadataList = (MetadataList) this.mMetadataRepo.executorServiceOrNull;
        int i__offset = metadataList.__offset(6);
        if (i__offset != 0) {
            int i = i__offset + metadataList.bb_pos;
            int i2 = (this.mIndex * 4) + ((ByteBuffer) metadataList.bb).getInt(i) + i + 4;
            int i3 = ((ByteBuffer) metadataList.bb).getInt(i2) + i2;
            ByteBuffer byteBuffer = (ByteBuffer) metadataList.bb;
            metadataItem.bb = byteBuffer;
            if (byteBuffer != null) {
                metadataItem.bb_pos = i3;
                int i4 = i3 - byteBuffer.getInt(i3);
                metadataItem.vtable_start = i4;
                metadataItem.vtable_size = ((ByteBuffer) metadataItem.bb).getShort(i4);
                return metadataItem;
            }
            metadataItem.bb_pos = 0;
            metadataItem.vtable_start = 0;
            metadataItem.vtable_size = 0;
        }
        return metadataItem;
    }

    public final String toString() {
        int i;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        MetadataItem metadataItem = getMetadataItem();
        int i__offset = metadataItem.__offset(4);
        sb.append(Integer.toHexString(i__offset != 0 ? ((ByteBuffer) metadataItem.bb).getInt(i__offset + metadataItem.bb_pos) : 0));
        sb.append(", codepoints:");
        MetadataItem metadataItem2 = getMetadataItem();
        int i__offset2 = metadataItem2.__offset(16);
        if (i__offset2 != 0) {
            int i2 = i__offset2 + metadataItem2.bb_pos;
            i = ((ByteBuffer) metadataItem2.bb).getInt(((ByteBuffer) metadataItem2.bb).getInt(i2) + i2);
        } else {
            i = 0;
        }
        for (int i3 = 0; i3 < i; i3++) {
            sb.append(Integer.toHexString(getCodepointAt(i3)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
