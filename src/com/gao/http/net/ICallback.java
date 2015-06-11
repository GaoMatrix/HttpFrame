
package com.gao.http.net;

/**
 * 通知上层的接口,业务处理的类都不需要实现这两个接口，把类变成abstract就可以了，
 * 让上层来实现这两个方法。
 * @author GaoMatrix
 *
 */
public interface ICallback {
    void onFailure(Exception result);
    void onSuccess(Exception result);
}
