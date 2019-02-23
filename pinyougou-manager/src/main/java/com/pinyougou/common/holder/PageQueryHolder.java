package com.pinyougou.common.holder;

import com.pinyougou.common.entity.QueryQO;
import com.pinyougou.common.entity.Result;
import com.pinyougou.common.service.QueryService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PageQueryHolder<T> {

    private QueryService queryService;

    public Result queryList(QueryQO queryQO){
        List<T> result = queryService.queryList(queryQO);
        return Result.ok(result);
    }

    public QueryService getQueryService() {
        return queryService;
    }

    public void setQueryService(QueryService queryService) {
        this.queryService = queryService;
    }
}
