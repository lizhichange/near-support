package org.near.servicesupport.request;

import org.near.servicesupport.util.SignDateUtil;

import javax.validation.constraints.NotNull;

/**
 * 验证签名的请求对象抽象类，需要验证签名的请求对象继承该类，实现验证签名方法。
 * 签名由于不同参数的生成签名方式会有区别，所以不支持模版类型
 * Created by Willard.Hu on 2016/5/5.
 */
public abstract class SignRequest extends AbstractServiceRequest {
    private static final long serialVersionUID = -699848950040890611L;
    /**
     * 请求业务参数签名
     */
    @NotNull
    protected String sign;

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    /**
     * 子类实现验证签名方法，可以使用SignDateUtil.genDefaultSignData将类属性转成Map对象，
     * 但前提条件是属性都是基础类型，如果是复杂对象或者是集合，则需要自己实现。
     *
     * @see SignDateUtil
     */
    abstract public void checkSign();
}
