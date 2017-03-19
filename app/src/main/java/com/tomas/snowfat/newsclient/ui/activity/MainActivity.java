package com.tomas.snowfat.newsclient.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.tomas.snowfat.newsclient.R;
import com.tomas.snowfat.newsclient.ui.fragment.HomeFragment;
import com.tomas.snowfat.newsclient.ui.fragment.MenuFragment;

public class MainActivity extends SlidingFragmentActivity {
    private MenuFragment mMenuFragment;
    private HomeFragment mHomeFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMenuFragment = new MenuFragment();
        mHomeFragment = new HomeFragment();
        //初始化左边布局
        initLeftMenu();
        //初始化内容布局
        initContent();
        //配置SlidingMenu的属性
        customizeSlidingMenu();

        initListener();


    }

    private void initListener() {

        mHomeFragment.setOnHomeChangeListener(new HomeFragment.OnHomeChangeListener() {
            @Override
            public void onTabChange(int checkedId) {
                if(checkedId == R.id.rb_home || checkedId == R.id.rb_setting){
                    getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
                }else{
                    getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
                }


            }

            @Override
            public void onTabMenuClick() {
                getSlidingMenu().toggle();
            }
        });
        mMenuFragment.setOnMenuSwitchListener(new MenuFragment.OnMenuSwitchListener() {
            @Override
            public void onMenuSwitch(int position, boolean isSwitch) {
                getSlidingMenu().toggle();
                if(isSwitch){
                    mHomeFragment.onMenuSwitch(position);
                }
            }
        });
    }

    private void customizeSlidingMenu() {
        SlidingMenu sm = getSlidingMenu();
        sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);//侧滑菜单偏移量
        sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);//设置从边缘拉出侧滑菜单
        getSlidingMenu().setMode(SlidingMenu.LEFT);//设置左边可拉出侧滑菜单
    }

    private void initContent() {
        setContentView(R.layout.content_frame);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, mHomeFragment)
                .commit();
    }

    private void initLeftMenu() {
        setBehindContentView(R.layout.menu_frame);
        FragmentTransaction t = this.getSupportFragmentManager().beginTransaction();
        t.replace(R.id.menu_frame, mMenuFragment);
        t.commit();
    }
}
