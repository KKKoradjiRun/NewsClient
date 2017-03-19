package com.tomas.snowfat.newsclient.network;

import com.android.volley.Response;
import com.android.volley.VolleyError;

/**
 * Created by Tomas on 2017/3/18.
 */

public class NetWorkListener<T> implements Response.Listener<T>,Response.ErrorListener{

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(T response) {

    }
}
