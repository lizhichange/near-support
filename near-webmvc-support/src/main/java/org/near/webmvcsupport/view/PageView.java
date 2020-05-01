package org.near.webmvcsupport.view;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

import java.util.List;

/**
 * 分页渲染对象
 * Created by Willard.Hu on 2016/5/9.
 */
@Getter
@Setter
public class PageView<T> extends ToString {
    private static final long serialVersionUID = -1964710990825517030L;
    /* 当前页 */
    private int page = 1;
    /* 每页显示行数 */
    private int rows = 10;
    /* 数据总数 */
    private int totalSize;
    /* 总页数 */
    private int totalPages;
    /* 数据集合 */
    private List<T> values;


}
