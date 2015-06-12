package com.gao.http;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;

import com.gao.http.net.Request;
import com.gao.http.net.StringCallback;
import com.gao.http.utilities.Trace;

import java.io.File;


public class TestActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String path = Environment.getExternalStorageDirectory().getAbsolutePath()
                + File.separator + "test.txt";
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
        }.cache(path));
        request.execute();
    }
}
