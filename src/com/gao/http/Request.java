
package com.gao.http;

import org.apache.http.HttpEntity;

import java.net.URI;
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
    
    public Request(String url, RequestMethod method) {
        this.url = url;
        this.method = method;
    }
    
    public Request(String url) {
        this.url = url;
        this.method = RequestMethod.GET;;
    }
}
