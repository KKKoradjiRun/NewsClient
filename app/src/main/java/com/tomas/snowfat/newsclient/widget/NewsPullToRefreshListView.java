package com.tomas.snowfat.newsclient.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.itheima.pulltorefreshlib.PullToRefreshListView;
import com.leon.loopviewpagerlib.FunBanner;
import com.tomas.snowfat.newsclient.R;

/**
 * Created by Tomas on 2017/3/18.
 */

public class NewsPullToRefreshListView extends PullToRefreshListView {
    private int[] imageResIds = {R.mipmap.icon_1, R.mipmap.icon_2, R.mipmap.icon_3, R.mipmap.icon_4, R.mipmap.icon_5};

    public NewsPullToRefreshListView(Context context) {
        this(context,null);
    }

    public NewsPullToRefreshListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    private void init() {
        setAdapter(mAdapter);
        setMode(Mode.BOTH);
        FunBanner.Builder builder = new FunBanner.Builder(getContext());
        FunBanner funBanner = builder.setEnableAutoLoop(true)
                .setImageResIds(imageResIds)
                .setDotSelectedColor(Color.RED)
                .setHeightWidthRatio(0.5556f)
                .setLoopInterval(5000)
                .setEnableAutoLoop(true)
                .setIndicatorBackgroundColor(R.color.indicator_bg)
                .build();
        //getRefreshableView()获取到在这里就是ListView
        getRefreshableView().addHeaderView(funBanner);


    }
    private BaseAdapter mAdapter = new BaseAdapter() {
        @Override
        public int getCount() {
            return 30;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView =View.inflate(getContext(),R.layout.view_news_list_item,null);
            }


            return convertView;
        }
    };

}
