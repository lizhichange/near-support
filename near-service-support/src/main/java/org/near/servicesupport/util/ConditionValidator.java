package org.near.servicesupport.util;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.near.servicesupport.error.InvokeServiceException;

/**
 * 请求对象校验工具 o(^▽^)o 基于hibernate validator
 * @author leeson 2016年5月27日 下午5:22:10
 */
public class ConditionValidator {
    private static Validator validator = Validation.byDefaultProvider().configure()
                                           .buildValidatorFactory().getValidator();

    /**
     * 验证对象属性，验证不通过，默认抛出{@link InvokeServiceException}
     */
    public static <T> void validate(T t) {
        validate(t, new ValidatorCallback() {
            @Override
            public void callback(String attrName, String failMsg) {
                throw new InvokeServiceException(100, attrName + failMsg);
            }
        });
    }

    /**
     * 验证对象属性，回调返回第一个错误属性和错误信息
     */
    public static <T> void validate(T t, ValidatorCallback closure) {
        Set<ConstraintViolation<T>> set = validator.validate(t);
        if (null != set && set.size() > 0) {
            ConstraintViolation<T> violation = set.iterator().next();
            String attrName = violation.getPropertyPath().iterator().next().getName();
            String failMsg = violation.getMessage();
            closure.callback(attrName, failMsg);
        }

    }
}