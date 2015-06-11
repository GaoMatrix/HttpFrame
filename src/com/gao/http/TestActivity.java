package com.gao.http;

import android.app.Activity;
import android.os.Bundle;

import com.gao.http.net.Request;
import com.gao.http.net.StringCallback;
import com.gao.http.utilities.Trace;


public class TestActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Request request = new Request("http://www.stay4it.com");
        request.addHeader("Content-Type", "*/*");
        request.setCallback(new StringCallback() {
            
            @Override
            public void onSuccess(Object result) {
                Trace.d((String)result);
            }
            
            @Override
            public void onFailure(Exception result) {
                Trace.e(result.getMessage());
            }
        });
        request.execute();
    }
}
