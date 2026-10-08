package androidx.emoji2.text;

import androidx.emoji2.text.flatbuffer.MetadataItem;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class EmojiProcessor$ProcessorSm {
    public int mCurrentDepth;
    public MetadataRepo$Node mCurrentNode;
    public MetadataRepo$Node mFlushNode;
    public int mLastCodepoint;
    public final MetadataRepo$Node mRootNode;
    public int mState = 1;

    public EmojiProcessor$ProcessorSm(MetadataRepo$Node metadataRepo$Node) {
        this.mRootNode = metadataRepo$Node;
        this.mCurrentNode = metadataRepo$Node;
    }

    public final void reset() {
        this.mState = 1;
        this.mCurrentNode = this.mRootNode;
        this.mCurrentDepth = 0;
    }

    public final boolean shouldUseEmojiPresentationStyleForSingleCodepoint() {
        MetadataItem metadataItem = this.mCurrentNode.mData.getMetadataItem();
        int i__offset = metadataItem.__offset(6);
        return !(i__offset == 0 || ((ByteBuffer) metadataItem.bb).get(i__offset + metadataItem.bb_pos) == 0) || this.mLastCodepoint == 65039;
    }
}
