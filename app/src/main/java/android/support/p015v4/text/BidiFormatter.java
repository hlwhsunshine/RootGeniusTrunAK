package android.support.p015v4.text;

import java.util.Locale;

/* renamed from: android.support.v4.text.BidiFormatter */
public final class BidiFormatter {
    private static final int DEFAULT_FLAGS = 2;
    private static final BidiFormatter DEFAULT_LTR_INSTANCE = new BidiFormatter(false, 2, DEFAULT_TEXT_DIRECTION_HEURISTIC);
    private static final BidiFormatter DEFAULT_RTL_INSTANCE = new BidiFormatter(true, 2, DEFAULT_TEXT_DIRECTION_HEURISTIC);
    private static TextDirectionHeuristicCompat DEFAULT_TEXT_DIRECTION_HEURISTIC = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
    private static final int DIR_LTR = -1;
    private static final int DIR_RTL = 1;
    private static final int DIR_UNKNOWN = 0;
    private static final String EMPTY_STRING = "";
    private static final int FLAG_STEREO_RESET = 2;
    private static final char LRE = '‪';
    private static final char LRM = '‎';
    private static final String LRM_STRING = Character.toString(LRM);
    private static final char PDF = '‬';
    private static final char RLE = '‫';
    private static final char RLM = '‏';
    private static final String RLM_STRING = Character.toString(RLM);
    private final TextDirectionHeuristicCompat mDefaultTextDirectionHeuristicCompat;
    private final int mFlags;
    private final boolean mIsRtlContext;

    /* renamed from: android.support.v4.text.BidiFormatter$Builder */
    public static final class Builder {
        private int mFlags;
        private boolean mIsRtlContext;
        private TextDirectionHeuristicCompat mTextDirectionHeuristicCompat;

        public Builder() {
            initialize(BidiFormatter.isRtlLocale(Locale.getDefault()));
        }

        public Builder(Locale locale) {
            initialize(BidiFormatter.isRtlLocale(locale));
        }

        public Builder(boolean z) {
            initialize(z);
        }

        private static BidiFormatter getDefaultInstanceFromContext(boolean z) {
            return z ? BidiFormatter.DEFAULT_RTL_INSTANCE : BidiFormatter.DEFAULT_LTR_INSTANCE;
        }

        private void initialize(boolean z) {
            this.mIsRtlContext = z;
            this.mTextDirectionHeuristicCompat = BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC;
            this.mFlags = 2;
        }

        public final BidiFormatter build() {
            return (this.mFlags == 2 && this.mTextDirectionHeuristicCompat == BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC) ? Builder.getDefaultInstanceFromContext(this.mIsRtlContext) : new BidiFormatter(this.mIsRtlContext, this.mFlags, this.mTextDirectionHeuristicCompat);
        }

        public final Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
            this.mTextDirectionHeuristicCompat = textDirectionHeuristicCompat;
            return this;
        }

        public final Builder stereoReset(boolean z) {
            if (z) {
                this.mFlags |= 2;
            } else {
                this.mFlags &= -3;
            }
            return this;
        }
    }

    /* renamed from: android.support.v4.text.BidiFormatter$DirectionalityEstimator */
    private static class DirectionalityEstimator {
        private static final byte[] DIR_TYPE_CACHE = new byte[DIR_TYPE_CACHE_SIZE];
        private static final int DIR_TYPE_CACHE_SIZE = 1792;
        private int charIndex;
        private final boolean isHtml;
        private char lastChar;
        private final int length;
        private final String text;

        static {
            for (int i = 0; i < DIR_TYPE_CACHE_SIZE; i++) {
                DIR_TYPE_CACHE[i] = Character.getDirectionality(i);
            }
        }

        DirectionalityEstimator(String str, boolean z) {
            this.text = str;
            this.isHtml = z;
            this.length = str.length();
        }

        private static byte getCachedDirectionality(char c) {
            return c < 1792 ? DIR_TYPE_CACHE[c] : Character.getDirectionality(c);
        }

        private byte skipEntityBackward() {
            int i = this.charIndex;
            while (this.charIndex > 0) {
                String str = this.text;
                int i2 = this.charIndex - 1;
                this.charIndex = i2;
                this.lastChar = str.charAt(i2);
                if (this.lastChar != '&') {
                    if (this.lastChar == ';') {
                        break;
                    }
                }
                return (byte) 12;
            }
            this.charIndex = i;
            this.lastChar = ';';
            return (byte) 13;
        }

        private byte skipEntityForward() {
            while (this.charIndex < this.length) {
                String str = this.text;
                int i = this.charIndex;
                this.charIndex = i + 1;
                char charAt = str.charAt(i);
                this.lastChar = charAt;
                if (charAt == ';') {
                    break;
                }
            }
            return (byte) 12;
        }

        private byte skipTagBackward() {
            int i = this.charIndex;
            while (this.charIndex > 0) {
                String str = this.text;
                int i2 = this.charIndex - 1;
                this.charIndex = i2;
                this.lastChar = str.charAt(i2);
                if (this.lastChar != '<') {
                    if (this.lastChar == '>') {
                        break;
                    } else if (this.lastChar == '\"' || this.lastChar == '\'') {
                        char c = this.lastChar;
                        while (this.charIndex > 0) {
                            String str2 = this.text;
                            int i3 = this.charIndex - 1;
                            this.charIndex = i3;
                            char charAt = str2.charAt(i3);
                            this.lastChar = charAt;
                            if (charAt == c) {
                                break;
                            }
                        }
                    }
                } else {
                    return (byte) 12;
                }
            }
            this.charIndex = i;
            this.lastChar = '>';
            return (byte) 13;
        }

        private byte skipTagForward() {
            int i = this.charIndex;
            while (this.charIndex < this.length) {
                String str = this.text;
                int i2 = this.charIndex;
                this.charIndex = i2 + 1;
                this.lastChar = str.charAt(i2);
                if (this.lastChar == '>') {
                    return (byte) 12;
                }
                if (this.lastChar == '\"' || this.lastChar == '\'') {
                    char c = this.lastChar;
                    while (this.charIndex < this.length) {
                        String str2 = this.text;
                        int i3 = this.charIndex;
                        this.charIndex = i3 + 1;
                        char charAt = str2.charAt(i3);
                        this.lastChar = charAt;
                        if (charAt == c) {
                            break;
                        }
                    }
                }
            }
            this.charIndex = i;
            this.lastChar = '<';
            return (byte) 13;
        }

        byte dirTypeBackward() {
            this.lastChar = this.text.charAt(this.charIndex - 1);
            if (Character.isLowSurrogate(this.lastChar)) {
                int codePointBefore = Character.codePointBefore(this.text, this.charIndex);
                this.charIndex -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.charIndex--;
            byte cachedDirectionality = DirectionalityEstimator.getCachedDirectionality(this.lastChar);
            return this.isHtml ? this.lastChar == '>' ? skipTagBackward() : this.lastChar == ';' ? skipEntityBackward() : cachedDirectionality : cachedDirectionality;
        }

        byte dirTypeForward() {
            this.lastChar = this.text.charAt(this.charIndex);
            if (Character.isHighSurrogate(this.lastChar)) {
                int codePointAt = Character.codePointAt(this.text, this.charIndex);
                this.charIndex += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.charIndex++;
            byte cachedDirectionality = DirectionalityEstimator.getCachedDirectionality(this.lastChar);
            return this.isHtml ? this.lastChar == '<' ? skipTagForward() : this.lastChar == '&' ? skipEntityForward() : cachedDirectionality : cachedDirectionality;
        }

        int getEntryDir() {
            this.charIndex = 0;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (this.charIndex < this.length && i == 0) {
                switch (dirTypeForward()) {
                    case (byte) 0:
                        if (i3 != 0) {
                            i = i3;
                            break;
                        }
                        return -1;
                    case (byte) 1:
                    case (byte) 2:
                        if (i3 != 0) {
                            i = i3;
                            break;
                        }
                        return 1;
                    case (byte) 9:
                        break;
                    case (byte) 14:
                    case (byte) 15:
                        i3++;
                        i2 = -1;
                        break;
                    case (byte) 16:
                    case (byte) 17:
                        i3++;
                        i2 = 1;
                        break;
                    case (byte) 18:
                        i3--;
                        i2 = 0;
                        break;
                    default:
                        i = i3;
                        break;
                }
            }
            if (i == 0) {
                return 0;
            }
            if (i2 != 0) {
                return i2;
            }
            while (this.charIndex > 0) {
                switch (dirTypeBackward()) {
                    case (byte) 14:
                    case (byte) 15:
                        if (i != i3) {
                            i3--;
                            break;
                        }
                        return -1;
                    case (byte) 16:
                    case (byte) 17:
                        if (i != i3) {
                            i3--;
                            break;
                        }
                        return 1;
                    case (byte) 18:
                        i3++;
                        break;
                    default:
                        break;
                }
            }
            return 0;
        }

        int getExitDir() {
            this.charIndex = this.length;
            int i = 0;
            int i2 = 0;
            while (this.charIndex > 0) {
                switch (dirTypeBackward()) {
                    case (byte) 0:
                        if (i2 != 0) {
                            if (i != 0) {
                                break;
                            }
                            i = i2;
                            break;
                        }
                        return -1;
                    case (byte) 1:
                    case (byte) 2:
                        if (i2 != 0) {
                            if (i != 0) {
                                break;
                            }
                            i = i2;
                            break;
                        }
                        return 1;
                    case (byte) 9:
                        break;
                    case (byte) 14:
                    case (byte) 15:
                        if (i != i2) {
                            i2--;
                            break;
                        }
                        return -1;
                    case (byte) 16:
                    case (byte) 17:
                        if (i != i2) {
                            i2--;
                            break;
                        }
                        return 1;
                    case (byte) 18:
                        i2++;
                        break;
                    default:
                        if (i != 0) {
                            break;
                        }
                        i = i2;
                        break;
                }
            }
            return 0;
        }
    }

    private BidiFormatter(boolean z, int i, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        this.mIsRtlContext = z;
        this.mFlags = i;
        this.mDefaultTextDirectionHeuristicCompat = textDirectionHeuristicCompat;
    }

    private static int getEntryDir(String str) {
        return new DirectionalityEstimator(str, false).getEntryDir();
    }

    private static int getExitDir(String str) {
        return new DirectionalityEstimator(str, false).getExitDir();
    }

    public static BidiFormatter getInstance() {
        return new Builder().build();
    }

    public static BidiFormatter getInstance(Locale locale) {
        return new Builder(locale).build();
    }

    public static BidiFormatter getInstance(boolean z) {
        return new Builder(z).build();
    }

    private static boolean isRtlLocale(Locale locale) {
        return TextUtilsCompat.getLayoutDirectionFromLocale(locale) == 1;
    }

    private String markAfter(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl((CharSequence) str, 0, str.length());
        return (this.mIsRtlContext || !(isRtl || BidiFormatter.getExitDir(str) == 1)) ? (!this.mIsRtlContext || (isRtl && BidiFormatter.getExitDir(str) != -1)) ? "" : RLM_STRING : LRM_STRING;
    }

    private String markBefore(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl((CharSequence) str, 0, str.length());
        return (this.mIsRtlContext || !(isRtl || BidiFormatter.getEntryDir(str) == 1)) ? (!this.mIsRtlContext || (isRtl && BidiFormatter.getEntryDir(str) != -1)) ? "" : RLM_STRING : LRM_STRING;
    }

    public final boolean getStereoReset() {
        return (this.mFlags & 2) != 0;
    }

    public final boolean isRtl(String str) {
        return this.mDefaultTextDirectionHeuristicCompat.isRtl((CharSequence) str, 0, str.length());
    }

    public final boolean isRtlContext() {
        return this.mIsRtlContext;
    }

    public final String unicodeWrap(String str) {
        return unicodeWrap(str, this.mDefaultTextDirectionHeuristicCompat, true);
    }

    public final String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        return unicodeWrap(str, textDirectionHeuristicCompat, true);
    }

    public final String unicodeWrap(String str, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z) {
        if (str == null) {
            return null;
        }
        boolean isRtl = textDirectionHeuristicCompat.isRtl((CharSequence) str, 0, str.length());
        StringBuilder stringBuilder = new StringBuilder();
        if (getStereoReset() && z) {
            stringBuilder.append(markBefore(str, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        if (isRtl != this.mIsRtlContext) {
            stringBuilder.append(isRtl ? RLE : LRE);
            stringBuilder.append(str);
            stringBuilder.append(PDF);
        } else {
            stringBuilder.append(str);
        }
        if (z) {
            stringBuilder.append(markAfter(str, isRtl ? TextDirectionHeuristicsCompat.RTL : TextDirectionHeuristicsCompat.LTR));
        }
        return stringBuilder.toString();
    }

    public final String unicodeWrap(String str, boolean z) {
        return unicodeWrap(str, this.mDefaultTextDirectionHeuristicCompat, z);
    }
}
