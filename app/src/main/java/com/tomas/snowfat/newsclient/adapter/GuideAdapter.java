package com.tomas.snowfat.newsclient.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Tomas on 2017/3/16.
 */

public class GuideAdapter extends PagerAdapter {
    private int[] mImages;
    private Context mContext;
    public GuideAdapter(Context context,int[] images){
        mImages = images;
        mContext = context;


    }
    @Override
    public int getCount() {
        return mImages.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        ImageView imageview = new ImageView(mContext);
        imageview.setImageResource(mImages[position]);
        imageview.setScaleType(ImageView.ScaleType.FIT_XY);

        container.addView(imageview);



        return imageview;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       // super.destroyItem(container, position, object);
        container.removeView((View) object);
    }
}
