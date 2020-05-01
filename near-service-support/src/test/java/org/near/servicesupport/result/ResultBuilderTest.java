package org.near.servicesupport.result;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * Created by Willard.Hu on 2016/3/5.
 */
public class ResultBuilderTest {

    @Test
    public void test_succ() {
        BaseResult rs = ResultBuilder.succ(BaseResult.class);
        Assert.assertTrue(rs.getErrcode() == 0);
    }

    @Test
    public void test_fail() {
        BaseResult rs = ResultBuilder.fail(BaseResult.class, 100, "err");
        Assert.assertTrue(rs.getErrcode() == 100);
    }

    @Test
    public void test_succPageResult() {
        PageResult rs = ResultBuilder.succPageResult(PageResult.class, 1, 10, 52);
        Assert.assertTrue(rs.getTotalPage() == 6);
    }
}
