package com.gao.http.net;

import com.gao.http.utilities.TextUtil;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.util.EntityUtils;

import java.io.FileOutputStream;
import java.io.InputStream;

public abstract class AbstractCallback implements ICallback{

    public String path;
    
    @Override
    public Object handle(HttpResponse response) throws Exception {
        // file, json, xml, string, image
        HttpEntity entity = response.getEntity();
        switch (response.getStatusLine().getStatusCode()) {
            case HttpStatus.SC_OK:
                if (TextUtil.isValidate(path)) {
                    FileOutputStream fos = new FileOutputStream(path);
                    InputStream is = entity.getContent();
                    byte[] buffer = new byte[2048];
                    int len = -1;
                    while (is.read(buffer) != -1) {
                        fos.write(buffer, 0, len);
                    }
                    is.close();
                    fos.flush();
                    fos.close();
                    return bindData(path);
                } else {
                    return bindData(EntityUtils.toString(entity));
                }
            default:
                break;
        }
        return null;
    }
    
    /**
     * 底层框架不知道我们需要什么JavaBean，可能是file，JSON，xml，string，image
     * 默认返回Object
     * @param string
     * @return
     */
    protected Object bindData(String content) {
        return content;
    }

    //只有上层才使用为了避免混淆，单独移出来
/*    public void onFailure(Exception result) {
        
    }

    public void onSuccess(Exception result) {
        
    }*/
}
