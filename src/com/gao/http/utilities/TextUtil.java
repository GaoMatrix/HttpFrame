package com.gao.http.utilities;

public class TextUtil {

    public static   boolean  isValidate(String content) {
        if (null != content && !"".equals(content)) {
            return  true;
        }
        return false;
    }
}
