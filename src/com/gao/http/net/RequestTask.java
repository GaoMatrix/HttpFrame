package com.gao.http.net;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;

public class RequestTask extends AsyncTask<Void, Integer, Object> {

    // 最好构造方法传过来
    private Request request;
    
    public RequestTask(Request request) {
        this.request = request;
    }
    
    @Override
    protected void onPreExecute() {
        // TODO Auto-generated method stub
        super.onPreExecute();
    }
    
    @Override
    protected Object doInBackground(Void... params) {
        try {
            HttpResponse response = HttpClientUtil.execute(request);
            if (request.callback != null) {
                // 让里面实现的具体子类来处理
                return request.callback.handle(response);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return e;
        }
    }

    @Override
    protected void onPostExecute(Object result) {
        super.onPostExecute(result);
        if (request.callback != null) {
            if (result instanceof Exception) {
                request.callback.onFailure((Exception)result);
            } else {
                request.callback.onSuccess(result);
            }
        }
    }
    
    @Override
    protected void onProgressUpdate(Integer... values) {
        // TODO Auto-generated method stub
        super.onProgressUpdate(values);
    }
}
