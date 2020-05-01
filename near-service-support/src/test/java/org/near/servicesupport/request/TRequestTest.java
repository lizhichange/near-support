package org.near.servicesupport.request;

import org.junit.Test;

import org.near.servicesupport.error.CommonServiceErrorEnum;
import org.near.servicesupport.result.ResultBuilder;
import org.near.servicesupport.result.TSingleResult;

/**
 * 
 * Created by Willard.Hu on 2016/5/5.
 */
public class TRequestTest {

    @Test
    public void test_trequest_builder() {
        TRequest<String> req = RequestBuilder.buildT("123");
        System.out.println(req);
    }

    @Test
    public void test_tresult_build() {
        TSingleResult<String> rs = ResultBuilder.failTSingle(CommonServiceErrorEnum.SYSTEM_ERROR);
    }

}
