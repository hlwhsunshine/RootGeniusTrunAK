package android.support.p015v4.view.animation;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* renamed from: android.support.v4.view.animation.PathInterpolatorDonut */
class PathInterpolatorDonut implements Interpolator {
    private static final float PRECISION = 0.002f;
    /* renamed from: mX */
    private final float[] f140mX;
    /* renamed from: mY */
    private final float[] f141mY;

    public PathInterpolatorDonut(float f, float f2) {
        this(PathInterpolatorDonut.createQuad(f, f2));
    }

    public PathInterpolatorDonut(float f, float f2, float f3, float f4) {
        this(PathInterpolatorDonut.createCubic(f, f2, f3, f4));
    }

    public PathInterpolatorDonut(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i = ((int) (length / PRECISION)) + 1;
        this.f140mX = new float[i];
        this.f141mY = new float[i];
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < i; i2++) {
            pathMeasure.getPosTan((((float) i2) * length) / ((float) (i - 1)), fArr, null);
            this.f140mX[i2] = fArr[0];
            this.f141mY[i2] = fArr[1];
        }
    }

    private static Path createCubic(float f, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f, f2, f3, f4, 1.0f, 1.0f);
        return path;
    }

    private static Path createQuad(float f, float f2) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f, f2, 1.0f, 1.0f);
        return path;
    }

    public float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int i;
        int i2 = 0;
        int length = this.f140mX.length - 1;
        while (true) {
            i = i2;
            if (length - i <= 1) {
                break;
            }
            i2 = (i + length) / 2;
            if (f < this.f140mX[i2]) {
            }
        }
        float f2 = this.f140mX[length] - this.f140mX[i];
        if (f2 == 0.0f) {
            return this.f141mY[i];
        }
        float f3 = (f - this.f140mX[i]) / f2;
        f2 = this.f141mY[i];
        return (f3 * (this.f141mY[length] - f2)) + f2;
    }
}
