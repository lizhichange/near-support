package org.near.servicesupport.util;

/**
 * 验证回调，传第一个未验证通过的属性名和错误信息
 * Created by Willard.Hu on 2016/5/29.
 */
public interface ValidatorCallback {

    void callback(String attrName, String failMsg);
}
