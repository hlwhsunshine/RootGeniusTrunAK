package android.content.p013pm;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

/* renamed from: android.content.pm.XmlSerializerAndParser */
public interface XmlSerializerAndParser<T> {
    T createFromXml(XmlPullParser xmlPullParser);

    void writeAsXml(T t, XmlSerializer xmlSerializer);
}
