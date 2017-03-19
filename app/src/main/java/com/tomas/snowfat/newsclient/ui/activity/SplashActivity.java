package com.tomas.snowfat.newsclient.ui.activity;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.tomas.snowfat.newsclient.R;
import com.tomas.snowfat.newsclient.utils.SpUtils;

import butterknife.BindView;

/**
 * Created by Tomas on 2017/3/16.
 */

public class SplashActivity extends BaseActivity {
    @BindView(R.id.iv_splash)
    ImageView mIvSplash;

    @Override
    public int getLayoutResID() {

        return R.layout.activity_splash;
    }

    @Override
    protected void init() {

        super.init();
        loadAnimation();

    }

    private void loadAnimation() {
        AnimationSet aniSet = new AnimationSet(false);
        //旋转动画
        RotateAnimation rotate = new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,0.5f,
                Animation.RELATIVE_TO_SELF,0.5f);
        rotate.setDuration(2000);
        aniSet.addAnimation(rotate);

        //缩放动画
        ScaleAnimation scale = new ScaleAnimation(0,1,0,1,Animation.RELATIVE_TO_SELF,0.5f,
                Animation.RELATIVE_TO_SELF,0.5f);
        scale.setDuration(2000);
        aniSet.addAnimation(scale);

        //渐变动画
        AlphaAnimation alpha = new AlphaAnimation(0,1);
        alpha.setDuration(2000);
        aniSet.addAnimation(alpha);

        mIvSplash.startAnimation(aniSet);

        aniSet.setAnimationListener(mAnimationListener);

    }
    private Animation.AnimationListener mAnimationListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            //动画结束finish并跳转到向导页面

           /* Intent intent = new Intent(SplashActivity.this,GuideActivity.class);
            startActivity(intent);
            finish();

*/
            boolean isShowGuide = (boolean) SpUtils.get(SplashActivity.this, "isShowGuide", true);
            if(isShowGuide){

            jumpTo(SplashActivity.this,GuideActivity.class);
            }else{
                jumpTo(SplashActivity.this,MainActivity.class);
            }

        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    };


}
