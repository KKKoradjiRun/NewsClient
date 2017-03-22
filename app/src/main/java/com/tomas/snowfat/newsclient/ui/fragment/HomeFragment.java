package com.tomas.snowfat.newsclient.ui.fragment;

import android.util.SparseArray;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.tomas.snowfat.newsclient.R;
import com.tomas.snowfat.newsclient.widget.BaseTabPage;
import com.tomas.snowfat.newsclient.widget.GovAffairsTabPage;
import com.tomas.snowfat.newsclient.widget.HomeTabPage;
import com.tomas.snowfat.newsclient.widget.NewsCenterTabPage;
import com.tomas.snowfat.newsclient.widget.SettingTabPage;
import com.tomas.snowfat.newsclient.widget.SmarServiceTabPage;

import butterknife.BindView;

/**
 * Created by Tomas on 2017/3/17.
 */

public class HomeFragment extends BaseFragment {
    @BindView(R.id.tab_frame_container)
    FrameLayout mTabFrameContainer;
    @BindView(R.id.rg_container)
    RadioGroup mRgContainer;

    private SparseArray<BaseTabPage> mTabPageCache  = new SparseArray<BaseTabPage>();
    private OnHomeChangeListener mOnHomeChangeListener;
    private BaseTabPage mCurrentTabPage;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void init() {
        super.init();
        mRgContainer.setOnCheckedChangeListener(mLsitener);
        mRgContainer.check(R.id.rb_home);
    }
    private RadioGroup.OnCheckedChangeListener mLsitener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            BaseTabPage tabPage = null;
            if(mTabPageCache.get(checkedId) != null){
                tabPage = mTabPageCache.get(checkedId);
            }else{
                tabPage = createTabPage(checkedId);
            }
            mCurrentTabPage = tabPage;
            mTabFrameContainer.removeAllViews();
            mTabFrameContainer.addView(tabPage);

            if(mOnHomeChangeListener != null){
                mOnHomeChangeListener.onTabChange(checkedId);
            }
            tabPage.loadServer();

        }
    };
    private BaseTabPage createTabPage(int checkedId){
        BaseTabPage tabPage = null;
        switch (checkedId){
            case R.id.rb_home:
                tabPage = new HomeTabPage(getContext());
                tabPage.setTitle("首页");
                tabPage.hideMenu();

                break;
            case R.id.rb_newscenter:
                tabPage = new NewsCenterTabPage(getContext());
                tabPage.setTitle("新闻中心");
                break;
            case R.id.rb_smartservice:
                tabPage = new SmarServiceTabPage(getContext());
                tabPage.setTitle("智慧服务");
                break;
            case R.id.rb_govaffairs:
                tabPage = new GovAffairsTabPage(getContext());
                tabPage.setTitle("政务");
                break;
            case R.id.rb_setting:
                tabPage = new SettingTabPage(getContext());
                tabPage.setTitle("设置中心");
                tabPage.hideMenu();
                break;
        }
        mTabPageCache.put(checkedId,tabPage);

        tabPage.setOnTabMenuClickListener(new BaseTabPage.OnTabMenuClickListener() {
            @Override
            public void tabMenuClick() {
                if(mOnHomeChangeListener != null){
                    mOnHomeChangeListener.onTabMenuClick();
                }
            }
        });


        return tabPage;

    }

    public void onMenuSwitch(int position){
        mCurrentTabPage.onMenuSwitch(position);

    }
    public interface OnHomeChangeListener{
        void onTabChange(int checkedId);

        void onTabMenuClick();

    }
    public void setOnHomeChangeListener(OnHomeChangeListener listener){
        mOnHomeChangeListener = listener;

    }
}
