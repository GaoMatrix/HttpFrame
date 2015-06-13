package com.gao.http.net;

import com.gao.http.utilities.JsonParser;

import java.lang.reflect.Type;

public abstract class JsonCallback<T>  extends AbstractCallback<T>{
    private Class<T> mReturnClass;
    private Type mReturnType;
    
    @Override
    protected T bindData(String json) {
        if (mReturnClass != null) {
            return JsonParser.deserializeFromJson(json, mReturnClass);
        } else if (mReturnType != null) {
            return JsonParser.deserializeFromJson(json, mReturnType);
        }
        return null;
    }

    public JsonCallback<T> setReturnClass(Class<T> returnClass) {
        this.mReturnClass = returnClass;
        return this;
    }

    public JsonCallback<T> setReturnType(Type returnType) {
        this.mReturnType = returnType;
        return this;
    }
    
    
}
