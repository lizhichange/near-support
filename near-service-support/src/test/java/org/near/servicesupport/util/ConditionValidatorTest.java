package org.near.servicesupport.util;

import org.junit.Test;
import org.near.servicesupport.error.InvokeServiceException;
import org.near.servicesupport.request.BaseRequest;

/**
 *
 * Created by Willard.Hu on 2016/5/29.
 */
public class ConditionValidatorTest {

    @Test(expected = InvokeServiceException.class)
    public void test_throw_exception() {
        BaseRequest baseRequest = new BaseRequest();
        ConditionValidator.validate(baseRequest);
    }

    @Test
    public void test_callback() {
        BaseRequest baseRequest = new BaseRequest();
        ConditionValidator.validate(baseRequest, new ValidatorCallback() {
            @Override
            public void callback(String attrName, String failMsg) {
                System.err.println("arrtName:" + attrName + ", failMsg:" + failMsg);
            }
        });
    }
}
