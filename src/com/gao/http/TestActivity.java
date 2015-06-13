package com.gao.http;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import com.gao.http.entities.ModuleEntity;
import com.gao.http.net.JsonCallback;
import com.gao.http.net.Request;
import com.gao.http.net.StringCallback;
import com.gao.http.utilities.Trace;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.util.ArrayList;


public class TestActivity extends Activity{
    private static final String TAG = "TestActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //testString();
        
        testJson();
    }

    private void testString() {
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
    
    public void testJson() {
        String path = Environment.getExternalStorageDirectory().getAbsolutePath()
                + File.separator + "test.txt";
        Request request = new Request("http://bcs.duapp.com/jsontest/project/module.dat");
        request.addHeader("Content-Type", "*/*");
        request.setCallback(new JsonCallback<ArrayList<ModuleEntity>>() {

            @Override
            public void onFailure(Exception result) {
            }

            @Override
            public void onSuccess(Object result) {
                ArrayList<ModuleEntity> entities = (ArrayList<ModuleEntity>) result;
                for (ModuleEntity moduleEntity : entities) {
                    Log.d(TAG,  "moduleName: " +  moduleEntity.getModuleName());
                }   
            }
        }.setReturnType(new TypeToken<ArrayList<ModuleEntity>>() {
        }.getType()));
        request.execute();
    }
    
    
    
    
    
}
