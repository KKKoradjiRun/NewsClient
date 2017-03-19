package com.tomas.snowfat.newsclient.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tomas.snowfat.newsclient.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Tomas on 2017/3/18.
 */

public class BaseTabPage extends RelativeLayout {
    @BindView(R.id.iv_basetab_menu)
    ImageView mIvBasetabMenu;
    @BindView(R.id.tv_basetab_title)
    TextView mTvBasetabTitle;
    @BindView(R.id.tab_content_frame)
    FrameLayout mTabContentFrame;
    private OnTabMenuClickListener mOnTabMenuClickListener;

    public BaseTabPage(Context context) {
        this(context, null);
    }

    public BaseTabPage(Context context, AttributeSet attrs) {
        super(context, attrs);
        View.inflate(context, R.layout.view_basetab_page, this);
        ButterKnife.bind(this, this);

        init();


    }

    public void init() {

    }
    public void loadServer(){

    }

    public void hideMenu() {
        mIvBasetabMenu.setVisibility(GONE);
    }

    public void setTitle(String title) {
        mTvBasetabTitle.setText(title);
    }

    @OnClick(R.id.iv_basetab_menu)
    public void onClick() {
        if(mOnTabMenuClickListener != null) {
            mOnTabMenuClickListener.tabMenuClick();
        }
    }

   public interface OnTabMenuClickListener{
        void tabMenuClick();
    }
    public void setOnTabMenuClickListener(OnTabMenuClickListener listener){

        mOnTabMenuClickListener = listener;
    }
    public void onMenuSwitch(int position){

    }
}
