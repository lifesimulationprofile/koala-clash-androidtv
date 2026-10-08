package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.emoji2.text.EmojiCompat;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class OrientationHelper$1 extends EmojiCompat.Config {
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OrientationHelper$1(RecyclerView.LayoutManager layoutManager, int i) {
        super(layoutManager);
        this.$r8$classId = i;
    }

    @Override // androidx.emoji2.text.EmojiCompat.Config
    public final int getDecoratedEnd(View view) {
        int right;
        int i;
        switch (this.$r8$classId) {
            case 0:
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                ((RecyclerView.LayoutManager) this.mMetadataLoader).getClass();
                right = view.getRight() + ((RecyclerView.LayoutParams) view.getLayoutParams()).mDecorInsets.right;
                i = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                break;
            default:
                RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) view.getLayoutParams();
                ((RecyclerView.LayoutManager) this.mMetadataLoader).getClass();
                right = view.getBottom() + ((RecyclerView.LayoutParams) view.getLayoutParams()).mDecorInsets.bottom;
                i = ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                break;
        }
        return right + i;
    }

    @Override // androidx.emoji2.text.EmojiCompat.Config
    public final int getDecoratedMeasurement(View view) {
        int measuredWidth;
        int i;
        switch (this.$r8$classId) {
            case 0:
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                ((RecyclerView.LayoutManager) this.mMetadataLoader).getClass();
                Rect rect = ((RecyclerView.LayoutParams) view.getLayoutParams()).mDecorInsets;
                measuredWidth = view.getMeasuredWidth() + rect.left + rect.right + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                i = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                break;
            default:
                RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) view.getLayoutParams();
                ((RecyclerView.LayoutManager) this.mMetadataLoader).getClass();
                Rect rect2 = ((RecyclerView.LayoutParams) view.getLayoutParams()).mDecorInsets;
                measuredWidth = view.getMeasuredHeight() + rect2.top + rect2.bottom + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin;
                i = ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                break;
        }
        return measuredWidth + i;
    }

    @Override // androidx.emoji2.text.EmojiCompat.Config
    public final int getDecoratedMeasurementInOther(View view) {
        int measuredHeight;
        int i;
        switch (this.$r8$classId) {
            case 0:
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                ((RecyclerView.LayoutManager) this.mMetadataLoader).getClass();
                Rect rect = ((RecyclerView.LayoutParams) view.getLayoutParams()).mDecorInsets;
                measuredHeight = view.getMeasuredHeight() + rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                i = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                break;
            default:
                RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) view.getLayoutParams();
                ((RecyclerView.LayoutManager) this.mMetadataLoader).getClass();
                Rect rect2 = ((RecyclerView.LayoutParams) view.getLayoutParams()).mDecorInsets;
                measuredHeight = view.getMeasuredWidth() + rect2.left + rect2.right + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin;
                i = ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
                break;
        }
        return measuredHeight + i;
    }

    @Override // androidx.emoji2.text.EmojiCompat.Config
    public final int getDecoratedStart(View view) {
        int left;
        int i;
        switch (this.$r8$classId) {
            case 0:
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                ((RecyclerView.LayoutManager) this.mMetadataLoader).getClass();
                left = view.getLeft() - ((RecyclerView.LayoutParams) view.getLayoutParams()).mDecorInsets.left;
                i = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                break;
            default:
                RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) view.getLayoutParams();
                ((RecyclerView.LayoutManager) this.mMetadataLoader).getClass();
                left = view.getTop() - ((RecyclerView.LayoutParams) view.getLayoutParams()).mDecorInsets.top;
                i = ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin;
                break;
        }
        return left - i;
    }

    @Override // androidx.emoji2.text.EmojiCompat.Config
    public final int getEnd() {
        switch (this.$r8$classId) {
            case 0:
                return ((RecyclerView.LayoutManager) this.mMetadataLoader).mWidth;
            default:
                return ((RecyclerView.LayoutManager) this.mMetadataLoader).mHeight;
        }
    }

    @Override // androidx.emoji2.text.EmojiCompat.Config
    public final int getEndAfterPadding() {
        int i;
        int paddingRight;
        switch (this.$r8$classId) {
            case 0:
                RecyclerView.LayoutManager layoutManager = (RecyclerView.LayoutManager) this.mMetadataLoader;
                i = layoutManager.mWidth;
                paddingRight = layoutManager.getPaddingRight();
                break;
            default:
                RecyclerView.LayoutManager layoutManager2 = (RecyclerView.LayoutManager) this.mMetadataLoader;
                i = layoutManager2.mHeight;
                paddingRight = layoutManager2.getPaddingBottom();
                break;
        }
        return i - paddingRight;
    }

    @Override // androidx.emoji2.text.EmojiCompat.Config
    public final int getEndPadding() {
        switch (this.$r8$classId) {
            case 0:
                return ((RecyclerView.LayoutManager) this.mMetadataLoader).getPaddingRight();
            default:
                return ((RecyclerView.LayoutManager) this.mMetadataLoader).getPaddingBottom();
        }
    }

    @Override // androidx.emoji2.text.EmojiCompat.Config
    public final int getMode() {
        switch (this.$r8$classId) {
            case 0:
                return ((RecyclerView.LayoutManager) this.mMetadataLoader).mWidthMode;
            default:
                return ((RecyclerView.LayoutManager) this.mMetadataLoader).mHeightMode;
        }
    }

    @Override // androidx.emoji2.text.EmojiCompat.Config
    public final int getModeInOther() {
        switch (this.$r8$classId) {
            case 0:
                return ((RecyclerView.LayoutManager) this.mMetadataLoader).mHeightMode;
            default:
                return ((RecyclerView.LayoutManager) this.mMetadataLoader).mWidthMode;
        }
    }

    @Override // androidx.emoji2.text.EmojiCompat.Config
    public final int getStartAfterPadding() {
        switch (this.$r8$classId) {
            case 0:
                return ((RecyclerView.LayoutManager) this.mMetadataLoader).getPaddingLeft();
            default:
                return ((RecyclerView.LayoutManager) this.mMetadataLoader).getPaddingTop();
        }
    }

    @Override // androidx.emoji2.text.EmojiCompat.Config
    public final int getTotalSpace() {
        int paddingLeft;
        int paddingRight;
        switch (this.$r8$classId) {
            case 0:
                RecyclerView.LayoutManager layoutManager = (RecyclerView.LayoutManager) this.mMetadataLoader;
                paddingLeft = layoutManager.mWidth - layoutManager.getPaddingLeft();
                paddingRight = layoutManager.getPaddingRight();
                break;
            default:
                RecyclerView.LayoutManager layoutManager2 = (RecyclerView.LayoutManager) this.mMetadataLoader;
                paddingLeft = layoutManager2.mHeight - layoutManager2.getPaddingTop();
                paddingRight = layoutManager2.getPaddingBottom();
                break;
        }
        return paddingLeft - paddingRight;
    }

    @Override // androidx.emoji2.text.EmojiCompat.Config
    public final int getTransformedEndWithDecoration(View view) {
        switch (this.$r8$classId) {
            case 0:
                RecyclerView.LayoutManager layoutManager = (RecyclerView.LayoutManager) this.mMetadataLoader;
                Rect rect = (Rect) this.mGlyphChecker;
                layoutManager.getTransformedBoundingBox(view, rect);
                return rect.right;
            default:
                RecyclerView.LayoutManager layoutManager2 = (RecyclerView.LayoutManager) this.mMetadataLoader;
                Rect rect2 = (Rect) this.mGlyphChecker;
                layoutManager2.getTransformedBoundingBox(view, rect2);
                return rect2.bottom;
        }
    }

    @Override // androidx.emoji2.text.EmojiCompat.Config
    public final int getTransformedStartWithDecoration(View view) {
        switch (this.$r8$classId) {
            case 0:
                RecyclerView.LayoutManager layoutManager = (RecyclerView.LayoutManager) this.mMetadataLoader;
                Rect rect = (Rect) this.mGlyphChecker;
                layoutManager.getTransformedBoundingBox(view, rect);
                return rect.left;
            default:
                RecyclerView.LayoutManager layoutManager2 = (RecyclerView.LayoutManager) this.mMetadataLoader;
                Rect rect2 = (Rect) this.mGlyphChecker;
                layoutManager2.getTransformedBoundingBox(view, rect2);
                return rect2.top;
        }
    }

    @Override // androidx.emoji2.text.EmojiCompat.Config
    public final void offsetChildren(int i) {
        switch (this.$r8$classId) {
            case 0:
                ((RecyclerView.LayoutManager) this.mMetadataLoader).offsetChildrenHorizontal(i);
                break;
            default:
                ((RecyclerView.LayoutManager) this.mMetadataLoader).offsetChildrenVertical(i);
                break;
        }
    }
}
