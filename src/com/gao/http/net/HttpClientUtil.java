package com.gao.http.net;

import android.content.Entity;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

public class HttpClientUtil {
    
    /**
     * 不想让上层直接调用post和get方法，都通过execute来调用
     * @throws Exception 
     */
    public static HttpResponse execute(Request request) throws Exception {
        switch (request.method) {
            case GET:
                return get(request);
            case POST:
                return post(request);
            case DELETE:
                break;
            case PUT:
                break;
            default:
                throw new IllegalStateException("the request method " + request.method.name() + " can't be supported");
        }
        return null;
    }
    
    private static HttpResponse get(Request request) throws Exception {
        HttpClient client  = new DefaultHttpClient();
        HttpGet get = new HttpGet(request.url);
        setHeaders(get, request.headers);
        return client.execute(get);
    }

    private static HttpResponse post(Request request) throws Exception {
        HttpClient client  = new DefaultHttpClient();
        HttpPost post = new HttpPost(request.url);
        if (request.entity == null) {
            throw new IllegalStateException("you should set post content when use POST to method");
        }
        setHeaders(post, request.headers);
        post.setEntity(request.entity);
        return client.execute(post);
    }
    
    private static void setHeaders(HttpUriRequest httpUriRequest, Map<String, String> headers) {
        for (Entry<String, String> entry : headers.entrySet()) {
            httpUriRequest.addHeader(entry.getKey(), entry.getValue());
        }
    }
    
    
    
    
    
}
