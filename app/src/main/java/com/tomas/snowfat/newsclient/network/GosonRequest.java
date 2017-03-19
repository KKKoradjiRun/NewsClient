package com.tomas.snowfat.newsclient.network;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;

/**
 * Created by Tomas on 2017/3/18.
 */

public class GosonRequest<T> extends Request<T> {


    public GosonRequest(int method, String url, Response.ErrorListener listener) {
        super(method, url, listener);
    }


    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        return null;
    }

    @Override
    protected void deliverResponse(T response) {

    }


}
