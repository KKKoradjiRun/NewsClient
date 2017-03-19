package com.tomas.snowfat.newsclient.ui.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.tomas.snowfat.newsclient.R;
import com.tomas.snowfat.newsclient.adapter.MenuAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Tomas on 2017/3/17.
 */

public class MenuFragment extends BaseFragment {
    @BindView(R.id.lv_menu)
    ListView mLvMenu;

    private List<String> list = new ArrayList<String>();
    private String[] item = new String[]{"新闻", "专题", "组图", "互动"};
    private int mLastSelectedPosition = 0;
    private OnMenuSwitchListener mOnMenuSwitchListener;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_menu;
    }

    @Override
    public void init() {
        super.init();
        mocklist();
        MenuAdapter adapter = new MenuAdapter(getContext(), list);
        mLvMenu.setAdapter(adapter);

        mLvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                boolean isSwitch = (position != mLastSelectedPosition);
                if(mOnMenuSwitchListener != null){
                    mOnMenuSwitchListener.onMenuSwitch(position,isSwitch);
                }

                if (mLastSelectedPosition == position) {
                    return;
                }
                View child = parent.getChildAt(position);
                child.setEnabled(true);
                View lastChild = parent.getChildAt(mLastSelectedPosition);
                lastChild.setEnabled(false);

                mLastSelectedPosition = position;
            }
        });


    }




    private void mocklist() {
        for (String str : item) {
            list.add(str);

        }

    }
    public interface OnMenuSwitchListener{
        void onMenuSwitch(int position,boolean isSwitch);
    }
    public void setOnMenuSwitchListener(OnMenuSwitchListener listener){
        mOnMenuSwitchListener =listener;

    }
}
