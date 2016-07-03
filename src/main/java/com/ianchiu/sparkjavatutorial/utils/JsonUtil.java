package com.ianchiu.sparkjavatutorial.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import spark.ResponseTransformer;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by ian on 6/27/16.
 */
public class JsonUtil {
    public static String toJson(Object object){
        return new Gson().toJson(object);
    }

    public static <E> E fromJson(String json, Class<E> convertTo){
        return new Gson().fromJson(json, convertTo);
    }

    public static <E> E fromJson(String json, Type type){
        return new Gson().fromJson(json, type);
    }

    public static ResponseTransformer json(){
        return JsonUtil::toJson;
    }

    public static Map<String, String> convertBodytoMap(String body){
        Type type = new TypeToken<Map<String, String>>(){}.getType();
        return fromJson(body, type);
    }
}
