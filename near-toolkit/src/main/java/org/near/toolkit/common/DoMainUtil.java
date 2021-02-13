package org.near.toolkit.common;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User:   lizhi
 * Date: 2018-6-1
 * Time: 10:41
 *
 * @author lizhi
 */
public class DoMainUtil {

    private final static String REGEX_DOMAIN = "(?<=http://|\\.)[^.]*?\\.(com|cn|net|org|biz|info|cc|tv|top|club)";

    private static Pattern p = Pattern.compile(REGEX_DOMAIN,
            Pattern.CASE_INSENSITIVE);

    /**
     * 根据url地址获取域名
     *
     * @param url 请求地址
     * @return 域名
     */
    public static String getDoMain(String url) {
        if (StringUtil.isBlank(url)) {
            return null;
        }
        Matcher matcher = p.matcher(url);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    /**
     * 获取登录用户的IP地址
     *
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if ("0:0:0:0:0:0:0:1".equals(ip)) {
            ip = "127.0.0.1";
        }
        if (ip.split(",").length > 1) {
            ip = ip.split(",")[0];
        }
        return ip;
    }
}
