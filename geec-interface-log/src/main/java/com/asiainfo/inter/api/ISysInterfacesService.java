package com.asiainfo.api;

/**
 * 接口定义表
 * 
 * @author jiass
 * @email jiass@asianfo.com
 * @date 2019-05-06 17:40:48
 */
public interface ISysInterfacesService{

    /**
     * 根据url 查询接口编号
     * @param url
     * @return
     */
    String queryInterfaceNoByUrl(String url);
}
