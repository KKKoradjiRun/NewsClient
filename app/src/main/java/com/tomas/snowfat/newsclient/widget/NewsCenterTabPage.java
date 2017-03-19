package com.tomas.snowfat.newsclient.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Tomas on 2017/3/18.
 */

public class NewsCenterTabPage extends BaseTabPage {
    public NewsCenterTabPage(Context context) {
        super(context);
    }

    public NewsCenterTabPage(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onMenuSwitch(int position) {
        super.onMenuSwitch(position);
        View view =null;
        switch (position){
            case 0:
               /* TextView textView = new TextView(getContext());
                textView.setText("新闻");
                view = textView;*/
                NewsPage newsPage =  new NewsPage(getContext());
                view = newsPage;
                break;
            case 1:
                TextView textView1 = new TextView(getContext());
                textView1.setText("专题");
                view = textView1;
                break;
            case 2:
                TextView textView2 = new TextView(getContext());
                textView2.setText("组图");
                view = textView2;
                break;
            case 3:
                TextView textView3 = new TextView(getContext());
                textView3.setText("互动");
                view = textView3;
                break;
        }
        mTabContentFrame.removeAllViews();
        mTabContentFrame.addView(view);
    }

    @Override
    public void loadServer() {
        super.loadServer();

    }
}
