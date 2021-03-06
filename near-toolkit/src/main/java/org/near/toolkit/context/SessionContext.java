package org.near.toolkit.context;

import org.near.toolkit.common.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * session上下文，请求线程级别作用域
 *
 * @author Created by Willard on 2015/9/7.
 */
public class SessionContext {

    /**
     * 用户标识Session key
     */
    public static final String USER_ID_KEY = "userId";

    public static final String OPEN_ID_KEY = "openId";

    public static final String HOST_ADD = "hostAddress";

    /**
     * 将Session中存储的业务数据放到 SessionContext 工具类中直接访问，
     * 原理是使用线程变量ThreadLocal将参数存在来，同一个线程访问就可以获取到数据了。
     *
     * @param sessionData Session数据模型 {@link SessionData}
     */
    public static void writeSessionContext(SessionData sessionData) {
        if (sessionData == null) {
            return;
        }
        if (StringUtil.isNotBlank(sessionData.getUserId())) {
            ThreadCache.setAttribute(USER_ID_KEY, sessionData.getUserId());
        }

        if (StringUtil.isNotBlank(sessionData.getOpenId())) {
            ThreadCache.setAttribute(OPEN_ID_KEY, sessionData.getOpenId());
        }
        if (StringUtil.isNotBlank(sessionData.getHostAdd())) {
            ThreadCache.setAttribute(HOST_ADD, sessionData.getHostAdd());
        }

    }

    public static void set(HttpSession session, String userId, String openId,
                           String hostAddress) {
        SessionData sessionData = new SessionData();
        sessionData.setUserId(userId);
        sessionData.setOpenId(openId);
        session.setAttribute(USER_ID_KEY, userId);
        session.setAttribute(OPEN_ID_KEY, openId);
        session.setAttribute(HOST_ADD, hostAddress);
        writeSessionContext(sessionData);
    }

    public static void setUserId(HttpSession session, String userId) {
        SessionData sessionData = new SessionData();
        sessionData.setUserId(userId);
        session.setAttribute(USER_ID_KEY, userId);
        writeSessionContext(sessionData);
    }

    public static void setOpenId(HttpSession session, String openId) {
        SessionData sessionData = new SessionData();
        sessionData.setOpenId(openId);
        session.setAttribute(OPEN_ID_KEY, openId);
        writeSessionContext(sessionData);
    }


    public static void setHostAdd(HttpSession session, String hostAdd) {
        SessionData sessionData = new SessionData();
        sessionData.setHostAdd(hostAdd);
        session.setAttribute(HOST_ADD, hostAdd);
        writeSessionContext(sessionData);
    }

    /**
     * 清除ThreadLocal中存放的业务数据
     */
    public static void clearSessionContext() {
        ThreadCache.clear();
    }

    public static boolean hasAttribute(String key) {
        return ThreadCache.hasAttribute(key);
    }

    /**
     * 移除属性，并且返回被移除的值
     */
    public static Object removeAttribute(String key) {
        return ThreadCache.removeAttribute(key);
    }


    /**
     * 获取 userId，会在拦截器  中注入到线程变量
     */
    public static String getUserId() {
        Object userId = ThreadCache.getAttribute(USER_ID_KEY);
        if (userId == null) {
            return null;
        }
        return (String) userId;
    }


    public static String getHostAdd() {
        Object hostAdd = ThreadCache.getAttribute(HOST_ADD);
        if (hostAdd == null) {
            return null;
        }
        return (String) hostAdd;
    }

    public static String getOpenId() {
        Object openId = ThreadCache.getAttribute(OPEN_ID_KEY);
        if (openId == null) {
            return null;
        }
        return (String) openId;
    }

    public static String getOpenId(HttpServletRequest request) {
        Object openId = request.getSession().getAttribute(OPEN_ID_KEY);
        if (openId == null) {
            return null;
        }

        return (String) openId;
    }

    public static String getHostAdd(HttpServletRequest request) {
        Object hostAdd = request.getSession().getAttribute(HOST_ADD);
        if (hostAdd == null) {
            return null;
        }
        return (String) hostAdd;
    }

    public static String getUserId(HttpServletRequest request) {
        Object userId = request.getSession().getAttribute(USER_ID_KEY);
        if (userId == null) {
            return null;
        }
        return (String) userId;
    }
}
