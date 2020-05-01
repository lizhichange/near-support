package org.near.servicesupport.result;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志支持返回结果
 *
 * @author Created by Willard.Hu on 2016/6/19.
 */
@Deprecated
public class LogSupportResult extends BaseResult {
    private static final long   serialVersionUID = -1650338634143264835L;
    private static final Logger LOG              = LoggerFactory.getLogger(LogSupportResult.class);
    private static String       IP;
    private static String       HOST_NAME;

    static {
        // 类初始化时获取网络ip和本机名称
        try {
            InetAddress netAddress = InetAddress.getLocalHost();
            if (netAddress != null) {
                IP = netAddress.getHostAddress();
                HOST_NAME = netAddress.getHostName();
            }
        } catch (UnknownHostException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /* 服务器名称 */
    private String              sevrName;
    /* 服务器ip */
    private String              sevrIp;

    public LogSupportResult() {
        sevrName = HOST_NAME;
        sevrIp = IP;
    }

    public String getSevrName() {
        return sevrName;
    }

    public void setSevrName(String sevrName) {
        this.sevrName = sevrName;
    }

    public String getSevrIp() {
        return sevrIp;
    }

    public void setSevrIp(String sevrIp) {
        this.sevrIp = sevrIp;
    }
}
