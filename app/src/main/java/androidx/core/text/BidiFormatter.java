package androidx.core.text;

import android.text.SpannableStringBuilder;
import kotlinx.serialization.json.internal.Composer;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class BidiFormatter {
    public static final BidiFormatter DEFAULT_LTR_INSTANCE;
    public static final BidiFormatter DEFAULT_RTL_INSTANCE;
    public static final String LRM_STRING;
    public static final String RLM_STRING;
    public final boolean mIsRtlContext;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class DirectionalityEstimator {
        public static final byte[] DIR_TYPE_CACHE = new byte[1792];
        public int charIndex;
        public char lastChar;
        public final int length;
        public final CharSequence text;

        static {
            for (int i = 0; i < 1792; i++) {
                DIR_TYPE_CACHE[i] = Character.getDirectionality(i);
            }
        }

        public DirectionalityEstimator(CharSequence charSequence) {
            this.text = charSequence;
            this.length = charSequence.length();
        }

        public final byte dirTypeBackward() {
            int i = this.charIndex - 1;
            CharSequence charSequence = this.text;
            char cCharAt = charSequence.charAt(i);
            this.lastChar = cCharAt;
            if (Character.isLowSurrogate(cCharAt)) {
                int iCodePointBefore = Character.codePointBefore(charSequence, this.charIndex);
                this.charIndex -= Character.charCount(iCodePointBefore);
                return Character.getDirectionality(iCodePointBefore);
            }
            this.charIndex--;
            char c = this.lastChar;
            return c < 1792 ? DIR_TYPE_CACHE[c] : Character.getDirectionality(c);
        }
    }

    static {
        Composer composer = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        LRM_STRING = Character.toString((char) 8206);
        RLM_STRING = Character.toString((char) 8207);
        DEFAULT_LTR_INSTANCE = new BidiFormatter(false);
        DEFAULT_RTL_INSTANCE = new BidiFormatter(true);
    }

    public BidiFormatter(boolean z) {
        Composer composer = TextDirectionHeuristicsCompat.LTR;
        this.mIsRtlContext = z;
    }

    public static int getEntryDir(CharSequence charSequence) {
        byte directionality;
        DirectionalityEstimator directionalityEstimator = new DirectionalityEstimator(charSequence);
        directionalityEstimator.charIndex = 0;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = directionalityEstimator.charIndex;
            if (i4 < directionalityEstimator.length && i == 0) {
                CharSequence charSequence2 = directionalityEstimator.text;
                char cCharAt = charSequence2.charAt(i4);
                directionalityEstimator.lastChar = cCharAt;
                if (Character.isHighSurrogate(cCharAt)) {
                    int iCodePointAt = Character.codePointAt(charSequence2, directionalityEstimator.charIndex);
                    directionalityEstimator.charIndex = Character.charCount(iCodePointAt) + directionalityEstimator.charIndex;
                    directionality = Character.getDirectionality(iCodePointAt);
                } else {
                    directionalityEstimator.charIndex++;
                    char c = directionalityEstimator.lastChar;
                    directionality = c < 1792 ? DirectionalityEstimator.DIR_TYPE_CACHE[c] : Character.getDirectionality(c);
                }
                if (directionality != 0) {
                    if (directionality == 1 || directionality == 2) {
                        if (i3 == 0) {
                            return 1;
                        }
                    } else if (directionality != 9) {
                        switch (directionality) {
                            case 14:
                            case 15:
                                i3++;
                                i2 = -1;
                                continue;
                            case 16:
                            case 17:
                                i3++;
                                i2 = 1;
                                continue;
                            case 18:
                                i3--;
                                i2 = 0;
                                continue;
                        }
                    }
                } else if (i3 == 0) {
                    return -1;
                }
                i = i3;
            }
        }
        if (i != 0) {
            if (i2 == 0) {
                while (directionalityEstimator.charIndex > 0) {
                    switch (directionalityEstimator.dirTypeBackward()) {
                        case 14:
                        case 15:
                            if (i == i3) {
                                return -1;
                            }
                            i3--;
                            break;
                        case 16:
                        case 17:
                            if (i == i3) {
                                return 1;
                            }
                            i3--;
                            break;
                        case 18:
                            i3++;
                            break;
                        default:
                            break;
                    }
                }
            } else {
                return i2;
            }
        }
        return 0;
    }

    public static int getExitDir(CharSequence charSequence) {
        DirectionalityEstimator directionalityEstimator = new DirectionalityEstimator(charSequence);
        directionalityEstimator.charIndex = directionalityEstimator.length;
        int i = 0;
        while (true) {
            int i2 = i;
            while (directionalityEstimator.charIndex > 0) {
                byte bDirTypeBackward = directionalityEstimator.dirTypeBackward();
                if (bDirTypeBackward == 0) {
                    if (i == 0) {
                        return -1;
                    }
                    if (i2 == 0) {
                    }
                } else if (bDirTypeBackward == 1 || bDirTypeBackward == 2) {
                    if (i == 0) {
                        return 1;
                    }
                    if (i2 == 0) {
                    }
                } else if (bDirTypeBackward != 9) {
                    switch (bDirTypeBackward) {
                        case 14:
                        case 15:
                            if (i2 == i) {
                                return -1;
                            }
                            i--;
                            break;
                        case 16:
                        case 17:
                            if (i2 == i) {
                                return 1;
                            }
                            i--;
                            break;
                        case 18:
                            i++;
                            break;
                        default:
                            if (i2 != 0) {
                            }
                            break;
                    }
                } else {
                    continue;
                }
            }
            return 0;
        }
    }

    public final SpannableStringBuilder unicodeWrap(CharSequence charSequence) {
        String str;
        Composer composer = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        if (charSequence == null) {
            return null;
        }
        boolean zIsRtl = composer.isRtl(charSequence, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        boolean zIsRtl2 = (zIsRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR).isRtl(charSequence, charSequence.length());
        String str2 = "";
        String str3 = RLM_STRING;
        String str4 = LRM_STRING;
        boolean z = this.mIsRtlContext;
        if (z || !(zIsRtl2 || getEntryDir(charSequence) == 1)) {
            str = (!z || (zIsRtl2 && getEntryDir(charSequence) != -1)) ? "" : str3;
        } else {
            str = str4;
        }
        spannableStringBuilder.append((CharSequence) str);
        if (zIsRtl != z) {
            spannableStringBuilder.append(zIsRtl ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        boolean zIsRtl3 = (zIsRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR).isRtl(charSequence, charSequence.length());
        if (!z && (zIsRtl3 || getExitDir(charSequence) == 1)) {
            str2 = str4;
        } else if (z && (!zIsRtl3 || getExitDir(charSequence) == -1)) {
            str2 = str3;
        }
        spannableStringBuilder.append((CharSequence) str2);
        return spannableStringBuilder;
    }
}
