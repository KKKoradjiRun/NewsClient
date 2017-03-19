package com.tomas.snowfat.newsclient.ui.activity;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.tomas.snowfat.newsclient.R;
import com.tomas.snowfat.newsclient.adapter.GuideAdapter;
import com.tomas.snowfat.newsclient.utils.SpUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Tomas on 2017/3/16.
 */

public class GuideActivity extends BaseActivity {

    @BindView(R.id.viewpagers)
    ViewPager mViewpagers;
    @BindView(R.id.btn_guide_start)
    Button mBtnGuideStart;
    private int[] mImages = new int[]{R.mipmap.guide_1, R.mipmap.guide_2, R.mipmap.guide_3};

    @Override
    public int getLayoutResID() {
        return R.layout.activity_guide;
    }

    @Override
    protected void init() {
        super.init();

        GuideAdapter mAdapter = new GuideAdapter(this, mImages);
        mViewpagers.setAdapter(mAdapter);
        mViewpagers.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //当前页面被选中的时候显示按钮
                if(position == mImages.length-1) {
                    mBtnGuideStart.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }




    @OnClick(R.id.btn_guide_start)
    public void onClick() {
        SpUtils.save(this,"isShowGuide",false);
        jumpTo(this,MainActivity.class);
    }
}
