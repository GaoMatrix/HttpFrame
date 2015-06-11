package com.gao.http.net;

public abstract class StringCallback extends AbstractCallback{

    @Override
    protected Object bindData(String content) {
        return content;
    }
}
