package com.pinyougou.common.service;

import com.pinyougou.common.entity.QueryQO;

import java.util.List;

public interface QueryService {

    <T> List<T> queryList(QueryQO queryQO);

    Integer queryCount(QueryQO queryQO);
}
