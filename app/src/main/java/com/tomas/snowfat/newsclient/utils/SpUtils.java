package com.tomas.snowfat.newsclient.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;

/**
 * Created by Tomas on 2017/3/16.
 */

public class SpUtils {

    private SpUtils(){
        throw new Error("Don't need instantiate!");
    }
    private static final String FILE_NAME = "newsclient";

    public static void save(Context context,String key, Object object){

        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        if(object instanceof String){
            editor.putString(key, (String) object);
        }else if(object instanceof Boolean){
            editor.putBoolean(key,(boolean)object);
        }else if(object instanceof Integer){
            editor.putInt(key,(int)object);
        }else if(object instanceof Float){
            editor.putFloat(key,(float)object);
        }else if(object instanceof  Long){
            editor.putLong(key,(long)object);
        }else {
            editor.putString(key,object.toString());

        }
        editor.apply();
    }
    public static Object get(Context context,String key,Object defaultValue){
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                context.MODE_PRIVATE);
        if(defaultValue instanceof String){
            return sp.getString(key, (String) defaultValue);
        }else if(defaultValue instanceof Boolean){
            return sp.getBoolean(key,(boolean) defaultValue);
        }else if(defaultValue instanceof Integer){
            return sp.getInt(key,(int)defaultValue);
        }else if(defaultValue instanceof Float){
            return sp.getFloat(key,(float)defaultValue);
        }else if(defaultValue instanceof Long){
            return sp.getLong(key,(long)defaultValue);
        }

        return null;
    }

    /**
     * 移除key对应的值
     * @param context
     * @param key
     */
    public static void remove(Context context,String key){
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        editor.apply();

    }

    /**
     * 清除所有数据
     * @param context
     */
    public static void clear(Context context){
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
    }

    /**
     * 是否含有某个key
     * @param context
     * @param key
     * @return
     */
    public static boolean contains(Context context,String key){
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, context.MODE_PRIVATE);
        return sp.contains(key);
    }

    /**
     * 获取所有键值对
     * @param context
     * @param key
     * @return
     */
    public static Map<String,?> getAll(Context context,String key){
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, context.MODE_PRIVATE);
        return sp.getAll();
    }
}
