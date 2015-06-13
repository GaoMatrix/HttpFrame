
package com.gao.http.net;

import org.apache.http.HttpResponse;

/**
 * 通知上层的接口,业务处理的类都不需要实现这两个接口，把类变成abstract就可以了，
 * 让上层来实现这两个方法。
 * @author GaoMatrix
 * @param <T>
 *
 */
public interface ICallback<T> {
    void onFailure(Exception result);
    void onSuccess(T result);
    T handle(HttpResponse response) throws Exception;
}
