package com.tomas.snowfat.newsclient.network;

import com.android.volley.Cache;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;

/**
 * Created by Tomas on 2017/3/19.
 */

public class NewsClientRequest<T> extends JsonRequest<T> {
    private Gson mGson = new Gson();
    private Class<T> mClass;

    public NewsClientRequest(int method, String url,Class<T> clzz, String requestBody,
                             Response.Listener listener, Response.ErrorListener errorListener) {
        super(method, url, requestBody, listener, errorListener);
        mClass = clzz;

    }

    @Override
    protected Response parseNetworkResponse(NetworkResponse response) {
        String result  = null;
        try {
            result = new String(response.data,PROTOCOL_CHARSET);
            T bean = mGson.fromJson(result, mClass);
            Cache.Entry cacheEntry = HttpHeaderParser.parseCacheHeaders(response);
            return Response.success(bean,cacheEntry);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }


}
