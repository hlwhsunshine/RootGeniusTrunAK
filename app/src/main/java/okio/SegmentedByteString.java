package okio;

import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

final class SegmentedByteString extends ByteString {
    final transient int[] directory;
    final transient byte[][] segments;

    SegmentedByteString(C1939e c1939e, int i) {
        int i2 = 0;
        super(null);
        C1933aa.m5591a(c1939e.f5807b, 0, (long) i);
        C1952u c1952u = c1939e.f5806a;
        int i3 = 0;
        int i4 = 0;
        while (i4 < i) {
            if (c1952u.f5837c == c1952u.f5836b) {
                throw new AssertionError("s.limit == s.pos");
            }
            i4 += c1952u.f5837c - c1952u.f5836b;
            i3++;
            c1952u = c1952u.f5840f;
        }
        this.segments = new byte[i3][];
        this.directory = new int[(i3 * 2)];
        C1952u c1952u2 = c1939e.f5806a;
        i4 = 0;
        while (i2 < i) {
            this.segments[i4] = c1952u2.f5835a;
            int i5 = (c1952u2.f5837c - c1952u2.f5836b) + i2;
            if (i5 > i) {
                i5 = i;
            }
            this.directory[i4] = i5;
            this.directory[this.segments.length + i4] = c1952u2.f5836b;
            c1952u2.f5838d = true;
            i4++;
            c1952u2 = c1952u2.f5840f;
            i2 = i5;
        }
    }

    private int segment(int i) {
        int binarySearch = Arrays.binarySearch(this.directory, 0, this.segments.length, i + 1);
        return binarySearch >= 0 ? binarySearch : binarySearch ^ -1;
    }

    private ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    private Object writeReplace() {
        return toByteString();
    }

    public final ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    public final String base64() {
        return toByteString().base64();
    }

    public final String base64Url() {
        return toByteString().base64Url();
    }

    public final boolean equals(Object obj) {
        return obj == this ? true : (obj instanceof ByteString) && ((ByteString) obj).size() == size() && rangeEquals(0, (ByteString) obj, 0, size());
    }

    public final byte getByte(int i) {
        C1933aa.m5591a((long) this.directory[this.segments.length - 1], (long) i, 1);
        int segment = segment(i);
        return this.segments[segment][(i - (segment == 0 ? 0 : this.directory[segment - 1])) + this.directory[this.segments.length + segment]];
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            i = 1;
            int length = this.segments.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                byte[] bArr = this.segments[i2];
                int i4 = this.directory[length + i2];
                int i5 = this.directory[i2];
                i3 = (i5 - i3) + i4;
                int i6 = i4;
                i4 = i;
                for (i = i6; i < i3; i++) {
                    i4 = (i4 * 31) + bArr[i];
                }
                i2++;
                i3 = i5;
                i = i4;
            }
            this.hashCode = i;
        }
        return i;
    }

    public final String hex() {
        return toByteString().hex();
    }

    public final int indexOf(byte[] bArr, int i) {
        return toByteString().indexOf(bArr, i);
    }

    final byte[] internalArray() {
        return toByteArray();
    }

    public final int lastIndexOf(byte[] bArr, int i) {
        return toByteString().lastIndexOf(bArr, i);
    }

    public final ByteString md5() {
        return toByteString().md5();
    }

    public final boolean rangeEquals(int i, ByteString byteString, int i2, int i3) {
        if (i < 0 || i > size() - i3) {
            return false;
        }
        int segment = segment(i);
        while (i3 > 0) {
            int i4 = segment == 0 ? 0 : this.directory[segment - 1];
            int min = Math.min(i3, ((this.directory[segment] - i4) + i4) - i);
            if (!byteString.rangeEquals(i2, this.segments[segment], (i - i4) + this.directory[this.segments.length + segment], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            segment++;
        }
        return true;
    }

    public final boolean rangeEquals(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > size() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int segment = segment(i);
        while (i3 > 0) {
            int i4 = segment == 0 ? 0 : this.directory[segment - 1];
            int min = Math.min(i3, ((this.directory[segment] - i4) + i4) - i);
            if (!C1933aa.m5593a(this.segments[segment], (i - i4) + this.directory[this.segments.length + segment], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            segment++;
        }
        return true;
    }

    public final ByteString sha256() {
        return toByteString().sha256();
    }

    public final int size() {
        return this.directory[this.segments.length - 1];
    }

    public final ByteString substring(int i) {
        return toByteString().substring(i);
    }

    public final ByteString substring(int i, int i2) {
        return toByteString().substring(i, i2);
    }

    public final ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    public final ByteString toAsciiUppercase() {
        return toByteString().toAsciiUppercase();
    }

    public final byte[] toByteArray() {
        int i = 0;
        Object obj = new byte[this.directory[this.segments.length - 1]];
        int length = this.segments.length;
        int i2 = 0;
        while (i < length) {
            int i3 = this.directory[length + i];
            int i4 = this.directory[i];
            System.arraycopy(this.segments[i], i3, obj, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return obj;
    }

    public final String toString() {
        return toByteString().toString();
    }

    public final String utf8() {
        return toByteString().utf8();
    }

    public final void write(OutputStream outputStream) {
        int i = 0;
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        int length = this.segments.length;
        int i2 = 0;
        while (i < length) {
            int i3 = this.directory[length + i];
            int i4 = this.directory[i];
            outputStream.write(this.segments[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
    }

    final void write(C1939e c1939e) {
        int i = 0;
        int length = this.segments.length;
        int i2 = 0;
        while (i < length) {
            int i3 = this.directory[length + i];
            int i4 = this.directory[i];
            C1952u c1952u = new C1952u(this.segments[i], i3, (i3 + i4) - i2);
            if (c1939e.f5806a == null) {
                c1952u.f5841g = c1952u;
                c1952u.f5840f = c1952u;
                c1939e.f5806a = c1952u;
            } else {
                c1939e.f5806a.f5841g.mo9084a(c1952u);
            }
            i++;
            i2 = i4;
        }
        c1939e.f5807b = ((long) i2) + c1939e.f5807b;
    }
}
