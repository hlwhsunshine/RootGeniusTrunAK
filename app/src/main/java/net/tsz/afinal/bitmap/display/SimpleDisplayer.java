package net.tsz.afinal.bitmap.display;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.p070qq.p071e.comm.constants.ErrorCode.InitError;
import net.tsz.afinal.bitmap.core.BitmapDisplayConfig;

public class SimpleDisplayer implements Displayer {
    private void animationDisplay(View view, Bitmap bitmap, Animation animation) {
        animation.setStartTime(AnimationUtils.currentAnimationTimeMillis());
        if (view instanceof ImageView) {
            ((ImageView) view).setImageBitmap(bitmap);
        } else {
            view.setBackgroundDrawable(new BitmapDrawable(bitmap));
        }
        view.startAnimation(animation);
    }

    private void fadeInDisplay(View view, Bitmap bitmap) {
        Drawable transitionDrawable = new TransitionDrawable(new Drawable[]{new ColorDrawable(17170445), new BitmapDrawable(view.getResources(), bitmap)});
        if (view instanceof ImageView) {
            ((ImageView) view).setImageDrawable(transitionDrawable);
        } else {
            view.setBackgroundDrawable(transitionDrawable);
        }
        transitionDrawable.startTransition(InitError.INIT_AD_ERROR);
    }

    public void loadCompletedisplay(View view, Bitmap bitmap, BitmapDisplayConfig bitmapDisplayConfig) {
        switch (bitmapDisplayConfig.getAnimationType()) {
            case 0:
                animationDisplay(view, bitmap, bitmapDisplayConfig.getAnimation());
                return;
            case 1:
                fadeInDisplay(view, bitmap);
                return;
            default:
                return;
        }
    }

    public void loadFailDisplay(View view, Bitmap bitmap) {
        if (view instanceof ImageView) {
            ((ImageView) view).setImageBitmap(bitmap);
        } else {
            view.setBackgroundDrawable(new BitmapDrawable(bitmap));
        }
    }
}
