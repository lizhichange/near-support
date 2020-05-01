package org.near.webmvcsupport.view;

import lombok.Getter;
import lombok.Setter;
import org.near.toolkit.model.ToString;

/**
 * Created by Willard.Hu on 2016/5/20.
 */
@Getter
@Setter
public class PageForm extends ToString {
    private static final long serialVersionUID = 4926122193692891210L;
    private int page = 1;
    private int rows = 10;

}
