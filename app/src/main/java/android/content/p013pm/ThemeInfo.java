package android.content.p013pm;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: android.content.pm.ThemeInfo */
public final class ThemeInfo extends BaseThemeInfo {
    private static /* synthetic */ int[] $SWITCH_TABLE$android$content$pm$ThemeInfo$AttributeIndex;
    public static final Creator<ThemeInfo> CREATOR = new C00541();
    private static final String[] compulsoryAttributes = new String[]{"name", "preview", "author", "themeId", "styleName"};
    private static final String[] optionalAttributes = new String[]{"thumbnail", "ringtoneFileName", "notificationRingtoneFileName", "wallpaperImage", "copyright", "ringtoneName", "notificationRingtoneName", "styleId"};
    private static final Map<String, AttributeIndex> sAttributesLookupTable = new HashMap();

    /* renamed from: android.content.pm.ThemeInfo$1 */
    class C00541 implements Creator<ThemeInfo> {
        C00541() {
        }

        public ThemeInfo createFromParcel(Parcel parcel) {
            return new ThemeInfo(parcel, null);
        }

        public ThemeInfo[] newArray(int i) {
            return new ThemeInfo[i];
        }
    }

    /* renamed from: android.content.pm.ThemeInfo$AttributeIndex */
    private enum AttributeIndex {
        THEME_PACKAGE_INDEX,
        PREVIEW_INDEX,
        AUTHOR_INDEX,
        THEME_INDEX,
        THEME_STYLE_NAME_INDEX,
        THUMBNAIL_INDEX,
        RINGTONE_FILE_NAME_INDEX,
        NOTIFICATION_RINGTONE_FILE_NAME_INDEX,
        WALLPAPER_IMAGE_INDEX,
        COPYRIGHT_INDEX,
        RINGTONE_NAME_INDEX,
        NOTIFICATION_RINGTONE_NAME_INDEX,
        STYLE_INDEX;

        public static AttributeIndex get(int i) {
            return AttributeIndex.values()[i];
        }
    }

    static /* synthetic */ int[] $SWITCH_TABLE$android$content$pm$ThemeInfo$AttributeIndex() {
        int[] iArr = $SWITCH_TABLE$android$content$pm$ThemeInfo$AttributeIndex;
        if (iArr == null) {
            iArr = new int[AttributeIndex.values().length];
            try {
                iArr[AttributeIndex.AUTHOR_INDEX.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[AttributeIndex.COPYRIGHT_INDEX.ordinal()] = 10;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[AttributeIndex.NOTIFICATION_RINGTONE_FILE_NAME_INDEX.ordinal()] = 8;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[AttributeIndex.NOTIFICATION_RINGTONE_NAME_INDEX.ordinal()] = 12;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[AttributeIndex.PREVIEW_INDEX.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[AttributeIndex.RINGTONE_FILE_NAME_INDEX.ordinal()] = 7;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[AttributeIndex.RINGTONE_NAME_INDEX.ordinal()] = 11;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[AttributeIndex.STYLE_INDEX.ordinal()] = 13;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[AttributeIndex.THEME_INDEX.ordinal()] = 4;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[AttributeIndex.THEME_PACKAGE_INDEX.ordinal()] = 1;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr[AttributeIndex.THEME_STYLE_NAME_INDEX.ordinal()] = 5;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr[AttributeIndex.THUMBNAIL_INDEX.ordinal()] = 6;
            } catch (NoSuchFieldError e12) {
            }
            try {
                iArr[AttributeIndex.WALLPAPER_IMAGE_INDEX.ordinal()] = 9;
            } catch (NoSuchFieldError e13) {
            }
            $SWITCH_TABLE$android$content$pm$ThemeInfo$AttributeIndex = iArr;
        }
        return iArr;
    }

    static {
        int i = 0;
        for (int i2 = 0; i2 < compulsoryAttributes.length; i2++) {
            sAttributesLookupTable.put(compulsoryAttributes[i2], AttributeIndex.get(i2));
        }
        while (i < optionalAttributes.length) {
            sAttributesLookupTable.put(optionalAttributes[i], AttributeIndex.get(compulsoryAttributes.length + i));
            i++;
        }
    }

    private ThemeInfo(Parcel parcel) {
        super(parcel);
    }

    /* synthetic */ ThemeInfo(Parcel parcel, ThemeInfo themeInfo) {
        this(parcel);
    }

    public ThemeInfo(XmlPullParser xmlPullParser, Resources resources, AttributeSet attributeSet) {
        Map hashMap = new HashMap(sAttributesLookupTable);
        int i = 0;
        for (int i2 = 0; i2 < attributeSet.getAttributeCount(); i2++) {
            String attributeName = attributeSet.getAttributeName(i2);
            if (hashMap.containsKey(attributeName)) {
                AttributeIndex attributeIndex = (AttributeIndex) hashMap.get(attributeName);
                hashMap.remove(attributeName);
                if (attributeIndex.ordinal() < compulsoryAttributes.length) {
                    i++;
                }
                switch (ThemeInfo.$SWITCH_TABLE$android$content$pm$ThemeInfo$AttributeIndex()[attributeIndex.ordinal()]) {
                    case 1:
                        this.name = getResolvedString(resources, attributeSet, i2);
                        break;
                    case 2:
                        this.previewResourceId = attributeSet.getAttributeResourceValue(i2, 0);
                        break;
                    case 3:
                        this.author = getResolvedString(resources, attributeSet, i2);
                        break;
                    case 4:
                        this.themeId = attributeSet.getAttributeValue(i2);
                        break;
                    case 5:
                        this.themeStyleName = getResolvedString(resources, attributeSet, i2);
                        break;
                    case 6:
                        this.thumbnailResourceId = attributeSet.getAttributeResourceValue(i2, 0);
                        break;
                    case 7:
                        this.ringtoneFileName = attributeSet.getAttributeValue(i2);
                        changeDrmFlagIfNeeded(this.ringtoneFileName);
                        break;
                    case 8:
                        this.notificationRingtoneFileName = attributeSet.getAttributeValue(i2);
                        changeDrmFlagIfNeeded(this.notificationRingtoneFileName);
                        break;
                    case 9:
                        this.wallpaperResourceId = attributeSet.getAttributeResourceValue(i2, 0);
                        break;
                    case 10:
                        this.copyright = getResolvedString(resources, attributeSet, i2);
                        break;
                    case 11:
                        this.ringtoneName = attributeSet.getAttributeValue(i2);
                        break;
                    case 12:
                        this.notificationRingtoneName = attributeSet.getAttributeValue(i2);
                        break;
                    case 13:
                        this.styleResourceId = attributeSet.getAttributeResourceValue(i2, 0);
                        break;
                    default:
                        break;
                }
            }
        }
        if (i < compulsoryAttributes.length) {
            throw new XmlPullParserException("Not all compulsory attributes are specified in <theme>");
        }
    }
}
