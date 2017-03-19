package com.tomas.snowfat.newsclient.ui.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by Tomas on 2017/3/17.
 */

public abstract class BaseFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(getLayoutId(),null);
        ButterKnife.bind(this,root);
        init();
        return root;
    }
    public void init(){

    };

    public abstract  int getLayoutId();
}
