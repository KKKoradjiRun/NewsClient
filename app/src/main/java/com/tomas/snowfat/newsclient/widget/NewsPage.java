package com.tomas.snowfat.newsclient.widget;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.tomas.snowfat.newsclient.R;
import com.tomas.snowfat.newsclient.bean.CategoryBean;
import com.viewpagerindicator.TabPageIndicator;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Tomas on 2017/3/18.
 */

public class NewsPage extends RelativeLayout {
    @BindView(R.id.indicator)
    TabPageIndicator mIndicator;
    @BindView(R.id.pager)
    ViewPager mPager;

    private static final String[] CONTENT
            = new String[]{"Recent", "Artists", "Albums", "Songs", "Playlists", "Genres", "Itheima", "HelloKitty"};

    private CategoryBean.DataBean mData;
    public NewsPage(Context context) {
        this(context, null);
    }

    public NewsPage(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();


    }

    private void init() {
        View.inflate(getContext(), R.layout.view_news_page, this);
        ButterKnife.bind(this);

        mPager.setAdapter(adapter);
        mIndicator.setViewPager(mPager);
    }

    private PagerAdapter adapter = new PagerAdapter() {
        @Override
        public int getCount() {
            if(mData == null){
                return 0;
            }
            return mData.getChildren().size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
           // return super.instantiateItem(container, position);
            /*TextView textView = new TextView(getContext());
            textView.setText(CONTENT[position]);
            container.addView(textView);
            return textView;*/
            NewsPullToRefreshListView newsPullToRefreshListView =
                    new NewsPullToRefreshListView(getContext());
            container.addView(newsPullToRefreshListView);
            return newsPullToRefreshListView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            //super.destroyItem(container, position, object);
            container.removeView((View) object);
        }

        @Override
        public CharSequence getPageTitle(int position) {

            return mData.getChildren().get(position).getTitle();
        }
    };

    public void setData(CategoryBean.DataBean data) {
        mData = data;
        mIndicator.notifyDataSetChanged();
        adapter.notifyDataSetChanged();
    }
}
