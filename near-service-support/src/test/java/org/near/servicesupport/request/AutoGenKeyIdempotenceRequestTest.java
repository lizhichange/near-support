package org.near.servicesupport.request;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Willard.Hu on 2016/11/16 0016.
 */
public class AutoGenKeyIdempotenceRequestTest {

    @Test
    public void test_genKey() {
        AutoGenKeyIdempotenceRequest request = new AutoGenKeyIdempotenceRequest();
        String key = request.genKey();
        System.out.println(key);
        assertEquals(key, request.getKey());
    }
}
