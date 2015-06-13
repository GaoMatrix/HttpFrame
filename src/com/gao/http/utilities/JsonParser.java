package com.gao.http.utilities;

import com.google.gson.Gson;

import java.lang.reflect.Type;

public class JsonParser {
    private static Gson sGson = new Gson();

    public static <T> T deserializeFromJson(String json, Class<T> clz) {
        return sGson.fromJson(json, clz);
    }
 
    public static <T> T deserializeFromJson(String json, Type type) {
        return sGson.fromJson(json, type);
    }
    
    public static String serializeToJson(Object object) {
        return sGson.toJson(object);
    }
}
