package com.tomas.snowfat.newsclient.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.tomas.snowfat.newsclient.bean.CategoryBean;
import com.tomas.snowfat.newsclient.network.NewsClientRequest;

/**
 * Created by Tomas on 2017/3/18.
 */

public class NewsCenterTabPage extends BaseTabPage {

    private CategoryBean mCategoryBean;

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
                newsPage.setData(mCategoryBean.getData().get(0));
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
        String url = "http://10.0.3.2:8080/zhbj/categories.json";



        NewsClientRequest<CategoryBean> request =
                new NewsClientRequest<CategoryBean>(Request.Method.GET,url,CategoryBean.class,null, listener, errorListener);

        RequestQueue queue = Volley.newRequestQueue(getContext());
        queue.add(request);

        
    }
    private Response.Listener listener = new Response.Listener<CategoryBean>() {
        @Override
        public void onResponse(CategoryBean response) {
            Toast.makeText(getContext(), "网络成功", Toast.LENGTH_SHORT).show();
            mCategoryBean = response;
            onMenuSwitch(0);

        }
    };
    private Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(getContext(),"网络失败",Toast.LENGTH_SHORT).show();
        }
    };
}
