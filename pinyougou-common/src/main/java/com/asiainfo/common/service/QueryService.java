package com.asiainfo.common.service;

import com.asiainfo.common.entity.QueryQO;

import java.util.List;

public interface QueryService {

    <T> List<T> queryList(QueryQO queryQO);

    Integer queryCount(QueryQO queryQO);
}
