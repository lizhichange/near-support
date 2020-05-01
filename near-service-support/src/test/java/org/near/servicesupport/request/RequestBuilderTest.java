package org.near.servicesupport.request;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Willard.Hu on 2016/3/19.
 */
public class RequestBuilderTest {

    @Test
    public void build_01() throws Exception {
        BaseRequest baseRequest = RequestBuilder.build(BaseRequest.class);
        assertTrue(baseRequest.getClientIp().length() > 0);
        assertTrue(baseRequest.getClientName().length() > 0);
    }

    @Test
    public void build_02() throws Exception {
        BaseRequest baseRequest = RequestBuilder.build(BaseRequest.class, "Willard");
        assertTrue(baseRequest.getClientIp().length() > 0);
        assertEquals(baseRequest.getClientName(), "Willard");
    }

    @Test
    public void build_03() {
        BaseRequest baseRequest = RequestBuilder.build(BaseRequest.class, "Willard", "1.1.1.1");
        assertEquals(baseRequest.getClientIp(), "1.1.1.1");
        assertEquals(baseRequest.getClientName(), "Willard");
    }

    @Ignore
    public void buildT_01() throws Exception {

    }

    @Ignore
    public void buildT_02() throws Exception {

    }

    @Test
    public void buildPageT_01() throws Exception {
        TPageRequest<String> pageRequest = RequestBuilder.buildPageT("", 1, 20);
        System.out.println(pageRequest);
        Assert.assertTrue(pageRequest != null);
    }

    @Test
    public void buildPageT_02() throws Exception {
        TPageRequest<String> pageRequest = RequestBuilder.buildPageT("", 1, 20, "Willard", "1.1.1.1");
        System.out.println(pageRequest);
        Assert.assertTrue(pageRequest != null);
    }


}
