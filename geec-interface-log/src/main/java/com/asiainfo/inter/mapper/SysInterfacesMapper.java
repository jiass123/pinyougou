package com.asiainfo.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * 接口定义表
 * 
 * @author jiass
 * @email jiass@asianfo.com
 * @date 2019-05-06 17:40:48
 */
public interface SysInterfacesMapper{

    String selectInterfaceNoByUrl(@Param("url") String url);
}
