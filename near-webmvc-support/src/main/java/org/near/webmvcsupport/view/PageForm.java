package org.near.webmvcsupport.view;

import lombok.Data;


import org.near.toolkit.model.ToString;

/**
 * @author Willard.Hu
 * @date 2016/5/20
 */
@Data
public class PageForm extends ToString {
    private static final long serialVersionUID = 4926122193692891210L;
    protected int pageNum = 1;
    protected int pageSize = 20;
}
