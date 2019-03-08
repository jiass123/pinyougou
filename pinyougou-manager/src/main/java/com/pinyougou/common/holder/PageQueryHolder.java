package com.pinyougou.common.holder;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.common.entity.QueryQO;
import com.pinyougou.common.entity.Result;
import com.pinyougou.common.service.QueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PageQueryHolder<T> {

    private QueryService queryService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public Result queryList(QueryQO queryQO){
        logger.info("queryList查询参数为:{}", JSON.toJSONString(queryQO));
        Map<String,Object> result = new HashMap<>();
        PageHelper.startPage(queryQO.getPage(),queryQO.getRows(),true);
        List<T> list = queryService.queryList(queryQO);
        PageInfo<T> info = PageInfo.of(list);
        result.put("page",info.getPageSize());
        result.put("rows",info.getPageNum());
        result.put("list",list);
        logger.info("queryList查询的结果为:{}",Result.ok(result));
        return Result.ok(result);
    }

    public QueryService getQueryService() {
        return queryService;
    }

    public void setQueryService(QueryService queryService) {
        this.queryService = queryService;
    }
}
