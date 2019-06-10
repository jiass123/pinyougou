package com.pinyougou.common.entity;

import javax.validation.constraints.NotNull;

public class QueryQO {

    @NotNull(message = "分页参数不能为空")
    private int page;

    @NotNull(message = "分页参数不能为空")
    private int rows;

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
