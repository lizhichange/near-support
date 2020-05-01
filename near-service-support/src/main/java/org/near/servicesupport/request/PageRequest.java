package org.near.servicesupport.request;

/**
 * 分页请求参数基础类
 * Created by willard on 16-2-29.
 */
// FIXME 由于很多服务依赖 PageRequest，但未升级这个包，后续再切换成 AbstractServiceRequest
public class PageRequest extends BaseRequest {
    private static final long serialVersionUID = 8811775689400542534L;

    protected int page = 1;
    protected int rows = 20;

    /**
     * mysql 分页查询 limit 的起始值
     */
    public int start4Mysql() {
        return page > 1 ? (page - 1) * rows : 0;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
}
