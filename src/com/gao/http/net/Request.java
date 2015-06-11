
package com.gao.http.net;

import org.apache.http.HttpEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * 请求封装成实体bean
 * @author GaoMatrix
 *
 */
public class Request {
    public enum RequestMethod {
        GET, POST, DELETE, PUT
    }
    
    public RequestMethod method;
    public String url;
    public HttpEntity entity;
    public Map<String, String> headers;
    public ICallback callback;
    
    public Request(String url, RequestMethod method) {
        this.url = url;
        this.method = method;
    }
    
    public Request(String url) {
        this.url = url;
        this.method = RequestMethod.GET;;
    }
    
    public void setCallback(ICallback callback) {
        this.callback = callback;
    }
    
    public void addHeader(String key, String value) {
        if (headers == null) {
            headers = new HashMap<String, String>();
        }
        headers.put(key, value);
    }

    public void execute() {
        RequestTask task = new RequestTask(this);
        task.execute();
    }
}
