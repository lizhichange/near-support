package org.near.servicesupport.request;

import org.near.toolkit.common.StringUtil;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class AutoGenKeyIdempotenceRequest extends AbstractIdempotenceRequest {
    private static final long serialVersionUID = -1632297176831614046L;

    /**
     * 自动生成幂等性校验 Key, 算法 IP + PID + THREAD_NAME + TIME_MILLIS
     */
    @Override
    public String genKey() {
        // IP 申明并且定义默认值
        String ip = "0.0.0.0";
        try {
            InetAddress netAddress = InetAddress.getLocalHost();
            if (netAddress != null) {
                ip = netAddress.getHostAddress();
            }
        } catch (UnknownHostException ignore) {
        }
        String pid = StringUtil.split(ManagementFactory.getRuntimeMXBean().getName(), '@')[0];
        String key = ip + "-" + pid + "-" + Thread.currentThread().getName() + "-" + System.currentTimeMillis();
        this.key = key;
        return key;
    }
}
