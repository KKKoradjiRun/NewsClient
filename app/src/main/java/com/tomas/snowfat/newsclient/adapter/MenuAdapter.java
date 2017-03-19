package com.tomas.snowfat.newsclient.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tomas.snowfat.newsclient.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Tomas on 2017/3/18.
 */

public class MenuAdapter extends BaseAdapter {
    private List<String> mStringList;
    private Context mContext;

    public MenuAdapter(Context context, List<String> list) {
        mStringList = list;
        mContext = context;

    }

    @Override
    public int getCount() {
        return mStringList.size();
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
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.lv_menu_item, null);
            holder = new ViewHolder(convertView);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.mTvMenuItem.setText(mStringList.get(position));

        if(position == 0){
            convertView.setEnabled(true);
        }else{
            convertView.setEnabled(false);
        }


        return convertView;
    }





    class ViewHolder {

        @BindView(R.id.tv_menu_item)
        TextView mTvMenuItem;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
